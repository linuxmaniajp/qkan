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
 * �쐬��: 2006/02/02  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ����f�Ô��� (001)
 * �v���O���� ����f�Ô��� (QS001028)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * ����f�Ô���(QS001028)
 */
public class QS001028 extends QS001028Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001028() {
    }

    // �R���|�[�l���g�C�x���g
    /**
     * �u�ݒ�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void applyActionPerformed(ActionEvent e) throws Exception {
        // ����ʂ̏�Ԃ��Ăяo�����ɕԂ�
        // values�ɉ�ʂ̒l���i�[����B
        getSpecificConsultationFeePattern().setSource(getValues());
        getValues().clear();
        getSpecificConsultationFeePattern().applySource();

        // �������ȃR���{�̒l���폜����B
        // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)�������Ȃ�΁A���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)��bindPath���폜����B
        if (!getScienceTherapy1Combo().isEnabled()) {
            getValues().remove(getScienceTherapy1Combo().getBindPath());
        }
        // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)�������Ȃ�΁A���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)��bindPath���폜����B
        if (!getScienceTherapy2Combo().isEnabled()) {
            getValues().remove(getScienceTherapy2Combo().getBindPath());
        }
        // ���w�Ö@�i�h�h�h�j�R���{(scienceTherapy3Combo)�������Ȃ�΁A���w�Ö@�i�h�h�h�j�R���{(scienceTherapy3Combo)��bindPath���폜����B
        if (!getScienceTherapy3Combo().isEnabled()) {
            getValues().remove(getScienceTherapy3Combo().getBindPath());
        }
        // ���w�Ö@�i�h�u�j�R���{(scienceTherapy4Combo)�������Ȃ�΁A���w�Ö@�i�h�u�j�R���{(scienceTherapy4Combo)��bindPath���폜����B
        if (!getScienceTherapy4Combo().isEnabled()) {
            getValues().remove(getScienceTherapy4Combo().getBindPath());
        }
        // ���w�i�h�j�R���{(science1Combo)�������Ȃ�΁A���w�i�h�j�R���{(science1Combo)��bindPath���폜����B
        if (!getScience1Combo().isEnabled()) {
            getValues().remove(getScience1Combo().getBindPath());
        }
        // ���w�i�h�h�j�R���{(science2Combo)�������Ȃ�΁A���w�i�h�h�j�R���{(science2Combo)��bindPath���폜����B
        if (!getScience2Combo().isEnabled()) {
            getValues().remove(getScience2Combo().getBindPath());
        }
        // ���w�i�h�h�h�j�R���{(science3Combo)�������Ȃ�΁A���w�i�h�h�h�j�R���{(science3Combo)��bindPath���폜����B
        if (!getScience3Combo().isEnabled()) {
            getValues().remove(getScience3Combo().getBindPath());
        }
        // ���w�i�h�u�j�R���{(science4Combo)�������Ȃ�΁A���w�i�h�u�j�R���{(science4Combo)��bindPath���폜����B
        if (!getScience4Combo().isEnabled()) {
            getValues().remove(getScience4Combo().getBindPath());
        }
        // ���퐶�������P�����Z�R���{(normalLifeCombo)�������Ȃ�΁A���퐶�������P�����Z�R���{(normalLifeCombo)��bindPath���폜����B
        if (!getNormalLifeCombo().isEnabled()) {
            getValues().remove(getNormalLifeCombo().getBindPath());
        }
        // ��ƗÖ@I�R���{(workTherapy1Combo)�������Ȃ�΁A��ƗÖ@I�R���{(workTherapy1Combo)��bindPath���폜����B
        if (!getWorkTherapy1Combo().isEnabled()) {
            getValues().remove(getWorkTherapy1Combo().getBindPath());
        }
        // ��ƗÖ@II�R���{(workTherapy2Combo)�������Ȃ�΁A��ƗÖ@II�R���{(workTherapy2Combo)��bindPath���폜����B
        if (!getWorkTherapy2Combo().isEnabled()) {
            getValues().remove(getWorkTherapy2Combo().getBindPath());
        }
        // ��ƁiI�j�R���{(work1Combo)�������Ȃ�΁A��ƁiI�j�R���{(work1Combo)��bindPath���폜����B
        if (!getWork1Combo().isEnabled()) {
            getValues().remove(getWork1Combo().getBindPath());
        }
        // ��ƁiII�j�R���{(work2Combo)�������Ȃ�΁A��ƁiII�j�R���{(work2Combo)��bindPath���폜����B
        if (!getWork2Combo().isEnabled()) {
            getValues().remove(getWork2Combo().getBindPath());
        }
        // ���퐶�����������Z�R���{(normalLife2Combo)�������Ȃ�΁A���퐶�����������Z�R���{(normalLife2Combo)��bindPath���폜����B
        if (!getNormalLife2Combo().isEnabled()) {
            getValues().remove(getNormalLife2Combo().getBindPath());
        }
        // ���꒮�o�Ö@�h�R���{(languageTherapy1Combo)�������Ȃ�΁A���꒮�o�Ö@�h�R���{(languageTherapy1Combo)��bindPath���폜����B
        if (!getLanguageTherapy1Combo().isEnabled()) {
            getValues().remove(getLanguageTherapy1Combo().getBindPath());
        }
        // ���꒮�o�Ö@II�R���{(languageTherapy2Combo)�������Ȃ�΁A���꒮�o�Ö@II�R���{(languageTherapy2Combo)��bindPath���폜����B
        if (!getLanguageTherapy2Combo().isEnabled()) {
            getValues().remove(getLanguageTherapy2Combo().getBindPath());
        }
        // ���꒮�o�iI�j�R���{(language1Combo)�������Ȃ�΁A���꒮�o�iI�j�R���{(language1Combo)��bindPath���폜����B
        if (!getLanguage1Combo().isEnabled()) {
            getValues().remove(getLanguage1Combo().getBindPath());
        }
        // ���꒮�o�iII�j�R���{(language2Combo)�������Ȃ�΁A���꒮�o�iII�j�R���{(language2Combo)��bindPath���폜����B
        if (!getLanguage2Combo().isEnabled()) {
            getValues().remove(getLanguage2Combo().getBindPath());
        }

        // �����I���ȃ`�F�b�N�̒l���폜����B
        // �����΍�w���Ǘ�(infectionGuidanceManagement)�����I���Ȃ�΁A�����΍�w���Ǘ�(infectionGuidanceManagement)��bindPath���폜����B
        if (!getInfectionGuidanceManagement().isSelected()) {
            getValues().remove(getInfectionGuidanceManagement().getBindPath());
        }
        // ��጑΍�w���Ǘ�(bedGuidanceManagement)�����I���Ȃ�΁A��጑΍�w���Ǘ�(bedGuidanceManagement)��bindPath���폜����B
        if (!getBedGuidanceManagement().isSelected()) {
            getValues().remove(getBedGuidanceManagement().getBindPath());
        }
        // �������@�f�ÊǗ�(beginningGuidanceManagement)�����I���Ȃ�΁A�������@�f�ÊǗ�(beginningGuidanceManagement)��bindPath���폜����B
        if (!getBeginningGuidanceManagement().isSelected()) {
            getValues().remove(getBeginningGuidanceManagement().getBindPath());
        }
        // �d�x�×{�Ǘ�(heavyRecuperateGuidanceManagement)�����I���Ȃ�΁A�d�x�×{�Ǘ�(heavyRecuperateGuidanceManagement)��bindPath���폜����B
        if (!getHeavyRecuperateGuidanceManagement().isSelected()) {
            getValues().remove(
                    getHeavyRecuperateGuidanceManagement().getBindPath());
        }
        // ����{�݊Ǘ�(particularInstitutionManagment)�����I���Ȃ�΁A����{�݊Ǘ�(particularInstitutionManagment)��bindPath���폜����B
        if (!getParticularInstitutionManagment().isSelected()) {
            getValues().remove(
                    getParticularInstitutionManagment().getBindPath());
        }
        // ����{�݊Ǘ������Z(particularInstitutionManagmentPrivateRoom)�����I���Ȃ�΁A����{�݊Ǘ������Z(particularInstitutionManagmentPrivateRoom)��bindPath���폜����B
        if (!getParticularInstitutionManagmentPrivateRoom().isSelected()) {
            getValues().remove(
                    getParticularInstitutionManagmentPrivateRoom()
                            .getBindPath());
        }
        // ����{�݊Ǘ�2�l�������Z(particularInstitutionManagmentPrivateRoom2)�����I���Ȃ�΁A����{�݊Ǘ�2�l�������Z(particularInstitutionManagmentPrivateRoom2)��bindPath���폜����B
        if (!getParticularInstitutionManagmentPrivateRoom2().isSelected()) {
            getValues().remove(
                    getParticularInstitutionManagmentPrivateRoom2()
                            .getBindPath());
        }
        // �d�ǔ畆��ᇊǗ��w��(heavySkinManegement)�����I���Ȃ�΁A�d�ǔ畆��ᇊǗ��w��(heavySkinManegement)��bindPath���폜����B
        if (!getHeavySkinManegement().isSelected()) {
            getValues().remove(getHeavySkinManegement().getBindPath());
        }
        // ���h�{�H���w��(careNutritionDinnerLeading)�����I���Ȃ�΁A���h�{�H���w��(careNutritionDinnerLeading)��bindPath���폜����B
        if (!getCareNutritionDinnerLeading().isSelected()) {
            getValues().remove(getCareNutritionDinnerLeading().getBindPath());
        }
        // ��܊Ǘ��w��(medicineManegementLeading)�����I���Ȃ�΁A��܊Ǘ��w��(medicineManegementLeading)��bindPath���폜����B
        if (!getMedicineManegementLeading().isSelected()) {
            getValues().remove(getMedicineManegementLeading().getBindPath());
        }
        // ���ʖ�܊Ǘ��w�����Z(specialMedicineManagementLeading)�����I���Ȃ�΁A���ʖ�܊Ǘ��w�����Z(specialMedicineManagementLeading)��bindPath���폜����B
        if (!getSpecialMedicineManagementLeading().isSelected()) {
            getValues().remove(
                    getSpecialMedicineManagementLeading().getBindPath());
        }
        // ��w���񋟁i�h�j(medicalScienceInfo1)�����I���Ȃ�΁A��w���񋟁i�h�j(medicalScienceInfo1)��bindPath���폜����B
        if (!getMedicalScienceInfo1().isSelected()) {
            getValues().remove(getMedicalScienceInfo1().getBindPath());
        }
        // ��w���񋟁i�h�h�j(medicalScienceInfo2)�����I���Ȃ�΁A��w���񋟁i�h�h�j(medicalScienceInfo2)��bindPath���폜����B
        if (!getMedicalScienceInfo2().isSelected()) {
            getValues().remove(getMedicalScienceInfo2().getBindPath());
        }
        // ���n�r���v����Z(rehabilitationPlan)�����I���Ȃ�΁A���n�r���v����Z(rehabilitationPlan)��bindPath���폜����B
        if (!getRehabilitationPlan().isSelected()) {
            getValues().remove(getRehabilitationPlan().getBindPath());
        }
        // ���퓮��P���w�����Z(normalAction)�����I���Ȃ�΁A���퓮��P���w�����Z(normalAction)��bindPath���폜����B
        if (!getNormalAction().isSelected()) {
            getValues().remove(getNormalAction().getBindPath());
        }
        // ���n�r���v����Z(rehabilitationPlan2)�����I���Ȃ�΁A���n�r���v����Z(rehabilitationPlan2)��bindPath���폜����B
        if (!getRehabilitationPlan2().isSelected()) {
            getValues().remove(getRehabilitationPlan2().getBindPath());
        }
        // ���퓮��P���w�����Z(normalActionTraning)�����I���Ȃ�΁A���퓮��P���w�����Z(normalActionTraning)��bindPath���폜����B
        if (!getNormalActionTraning().isSelected()) {
            getValues().remove(getNormalActionTraning().getBindPath());
        }
        // �ېH�@�\�Ö@(dinner)�����I���Ȃ�΁A�ېH�@�\�Ö@(dinner)��bindPath���폜����B
        if (!getDinner().isSelected()) {
            getValues().remove(getDinner().getBindPath());
        }
        // ���_�ȍ�ƗÖ@(mindTherapy)�����I���Ȃ�΁A���_�ȍ�ƗÖ@(mindTherapy)��bindPath���폜����B
        if (!getMindTherapy().isSelected()) {
            getValues().remove(getMindTherapy().getBindPath());
        }
        // �F�m�ǘV�l���@���_�Ö@(cognitive)�����I���Ȃ�΁A�F�m�ǘV�l���@���_�Ö@(cognitive)��bindPath���폜����B
        if (!getCognitive().isSelected()) {
            getValues().remove(getCognitive().getBindPath());
        }

        // ���ݒ�ς݂Ƃ��ĕ���B

        // �ݒ�{�^�������������t���O��true�ɂ���B
        setApplied(true);
        // ��ʂ����B
        dispose();
    }

    /**
     * �u�L�����Z���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void closeActionPerformed(ActionEvent e) throws Exception {
        // ����ʂ̏�Ԃ�j������
        // (values�̍X�V�͍s��Ȃ�)
        dispose();
    }

    /**
     * �u���w�Ö@�i�h�j�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void scienceTherapy1ActionPerformed(ActionEvent e)
            throws Exception {
        // �����w�Ö@�i�h�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getScienceTherapy1().isSelected()) {
            // ���w�Ö@�i�h�j�`�F�b�N(scienceTherapy1)���I������Ă���ꍇ
            // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)��L���ɂ���B
            setState_VALID_SCIENCE_THERAPY1();
            // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)��1�ڂ̍��ڂ�I������B
            getScienceTherapy1Combo().setSelectedIndex(0);
        } else {
            // ���w�Ö@�i�h�j�`�F�b�N(scienceTherapy1)���I������Ă��Ȃ��ꍇ
            // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)�𖳌��ɂ���B
            setState_INVALID_SCIENCE_THERAPY1();
            // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)�𖢑I����Ԃɂ���B
            getScienceTherapy1Combo().clearSelection();
        }
    }

    /**
     * �u���w�Ö@�i�h�h�j�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void scienceTherapy2ActionPerformed(ActionEvent e)
            throws Exception {
        // �����w�Ö@�i�h�h�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getScienceTherapy2().isSelected()) {
            // ���w�Ö@�i�h�h�j�`�F�b�N(scienceTherapy2)���I������Ă���ꍇ
            // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)��L���ɂ���B
            setState_VALID_SCIENCE_THERAPY2();
            // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)��1�ڂ̍��ڂ�I������B
            getScienceTherapy2Combo().setSelectedIndex(0);
        } else {
            // ���w�Ö@�i�h�h�j�`�F�b�N(scienceTherapy2)���I������Ă��Ȃ��ꍇ
            // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)�𖳌��ɂ���B
            setState_INVALID_SCIENCE_THERAPY2();
            // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)�𖢑I����Ԃɂ���B
            getScienceTherapy2Combo().clearSelection();
        }

    }

    /**
     * �u���w�Ö@�i�h�h�h�j�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void scienceTherapy3ActionPerformed(ActionEvent e)
            throws Exception {
        // �����w�Ö@�i�h�h�h�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getScienceTherapy3().isSelected()) {
            // ���w�Ö@�i�h�h�h�j�`�F�b�N(scienceTherapy3)���I������Ă���ꍇ
            // ���w�Ö@�i�h�h�h�j�R���{(scienceTherapy3Combo)��L���ɂ���B
            setState_VALID_SCIENCE_THERAPY3();
            // ���w�Ö@�i�h�h�h�j�R���{(scienceTherapy3Combo)��1�ڂ̍��ڂ�I������B
            getScienceTherapy3Combo().setSelectedIndex(0);
        } else {
            // ���w�Ö@�i�h�h�h�j�`�F�b�N(scienceTherapy3)���I������Ă��Ȃ��ꍇ
            // ���w�Ö@�i�h�h�h�j�R���{(scienceTherapy3Combo)�𖳌��ɂ���B
            setState_INVALID_SCIENCE_THERAPY3();
            // ���w�Ö@�i�h�h�h�j�R���{(scienceTherapy3Combo)�𖢑I����Ԃɂ���B
            getScienceTherapy3Combo().clearSelection();
        }

    }

    /**
     * �u���w�Ö@�i�h�u�j�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void scienceTherapy4ActionPerformed(ActionEvent e)
            throws Exception {
        // �����w�Ö@�i�h�u�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getScienceTherapy4().isSelected()) {
            // ���w�Ö@�i�h�u�j�`�F�b�N(scienceTherapy4)���I������Ă���ꍇ
            // ���w�Ö@�i�h�u�j�R���{(scienceTherapy4Combo)��L���ɂ���B
            setState_VALID_SCIENCE_THERAPY4();
            // ���w�Ö@�i�h�u�j�R���{(scienceTherapy4Combo)��1�ڂ̍��ڂ�I������B
            getScienceTherapy4Combo().setSelectedIndex(0);
        } else {
            // ���w�Ö@�i�h�u�j�`�F�b�N(scienceTherapy4)���I������Ă��Ȃ��ꍇ
            // ���w�Ö@�i�h�u�j�R���{(scienceTherapy4Combo)�𖳌��ɂ���B
            setState_INVALID_SCIENCE_THERAPY4();
            // ���w�Ö@�i�h�u�j�R���{(scienceTherapy4Combo)�𖢑I����Ԃɂ���B
            getScienceTherapy4Combo().clearSelection();
        }

    }

    /**
     * �u���w�i�h�j�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void science1ActionPerformed(ActionEvent e) throws Exception {
        // �����w�i�h�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getScience1().isSelected()) {
            // ���w�i�h�j�`�F�b�N(science1)���I������Ă���ꍇ
            // ���w�i�h�j�R���{(science1Combo)��L���ɂ���B
            setState_VALID_SCIENCE1();
            // ���w�i�h�j�R���{(science1Combo)��1�ڂ̍��ڂ�I������B
            getScience1Combo().setSelectedIndex(0);
        } else {
            // ���w�i�h�j�`�F�b�N(science1)���I������Ă��Ȃ��ꍇ
            // ���w�i�h�j�R���{(science1Combo)�𖳌��ɂ���B
            setState_INVALID_SCIENCE1();
            // ���w�i�h�j�R���{(science1Combo)�𖢑I����Ԃɂ���B
            getScience1Combo().clearSelection();
        }

    }

    /**
     * �u���w�i�h�h�j�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void science2ActionPerformed(ActionEvent e) throws Exception {
        // �����w�i�h�h�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getScience2().isSelected()) {
            // ���w�i�h�h�j�`�F�b�N(science2)���I������Ă���ꍇ
            // ���w�i�h�h�j�R���{(science2Combo)��L���ɂ���B
            setState_VALID_SCIENCE2();
            // ���w�i�h�h�j�R���{(science2Combo)��1�ڂ̍��ڂ�I������B
            getScience2Combo().setSelectedIndex(0);
        } else {
            // ���w�i�h�h�j�`�F�b�N(science2)���I������Ă��Ȃ��ꍇ
            // ���w�i�h�h�j�R���{(science2Combo)�𖳌��ɂ���B
            setState_INVALID_SCIENCE2();
            // ���w�i�h�h�j�R���{(science2Combo)�𖢑I����Ԃɂ���B
            getScience2Combo().clearSelection();
        }

    }

    /**
     * �u���w�i�h�h�h�j�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void science3ActionPerformed(ActionEvent e) throws Exception {
        // �����w�i�h�h�h�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getScience3().isSelected()) {
            // ���w�i�h�h�h�j�`�F�b�N(science3)���I������Ă���ꍇ
            // ���w�i�h�h�h�j�R���{(science3Combo)��L���ɂ���B
            setState_VALID_SCIENCE3();
            // ���w�i�h�h�h�j�R���{(science3Combo)��1�ڂ̍��ڂ�I������B
            getScience3Combo().setSelectedIndex(0);
        } else {
            // ���w�i�h�h�h�j�`�F�b�N(science3)���I������Ă��Ȃ��ꍇ
            // ���w�i�h�h�h�j�R���{(science3Combo)�𖳌��ɂ���B
            setState_INVALID_SCIENCE3();
            // ���w�i�h�h�h�j�R���{(science3Combo)�𖢑I����Ԃɂ���B
            getScience3Combo().clearSelection();
        }

    }

    /**
     * �u���w�i�h�u�j�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void science4ActionPerformed(ActionEvent e) throws Exception {
        // �����w�i�h�u�j�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getScience4().isSelected()) {
            // ���w�i�h�u�j�`�F�b�N(science4)���I������Ă���ꍇ
            // ���w�i�h�u�j�R���{(science4Combo)��L���ɂ���B
            setState_VALID_SCIENCE4();
            // ���w�i�h�u�j�R���{(science4Combo)��1�ڂ̍��ڂ�I������B
            getScience4Combo().setSelectedIndex(0);
        } else {
            // ���w�i�h�u�j�`�F�b�N(science4)���I������Ă��Ȃ��ꍇ
            // ���w�i�h�u�j�R���{(science4Combo)�𖳌��ɂ���B
            setState_INVALID_SCIENCE4();
            // ���w�i�h�u�j�R���{(science4Combo)�𖢑I����Ԃɂ���B
            getScience4Combo().clearSelection();
        }

    }

    /**
     * �u���퐶�������P�����Z�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void normalLifeActionPerformed(ActionEvent e) throws Exception {
        // �����퐶�������P�����Z�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getNormalLife().isSelected()) {
            // ���퐶�������P�����Z�`�F�b�N(normalLife)���I������Ă���ꍇ
            // ���퐶�������P�����Z�R���{(normalLifeCombo)��L���ɂ���B
            setState_VALID_NORMAL_LIFE_();
            // ���퐶�������P�����Z�R���{(normalLifeCombo)��1�ڂ̍��ڂ�I������B
            getNormalLifeCombo().setSelectedIndex(0);
        } else {
            // ���퐶�������P�����Z�`�F�b�N(normalLife)���I������Ă��Ȃ��ꍇ
            // ���퐶�������P�����Z�R���{(normalLifeCombo)�𖳌��ɂ���B
            setState_INVALID_NORMAL_LIFE_();
            // ���퐶�������P�����Z�R���{(normalLifeCombo)�𖢑I����Ԃɂ���B
            getNormalLifeCombo().clearSelection();
        }

    }

    /**
     * �u��ƗÖ@I�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void workTherapy1ActionPerformed(ActionEvent e) throws Exception {
        // ����ƗÖ@I�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getWorkTherapy1().isSelected()) {
            // ��ƗÖ@I�`�F�b�N(workTherapy1)���I������Ă���ꍇ
            // ��ƗÖ@I�R���{(workTherapy1Combo)��L���ɂ���B
            setState_VALID_WORK_THERAPY1();
            // ��ƗÖ@I�R���{(workTherapy1Combo)��1�ڂ̍��ڂ�I������B
            getWorkTherapy1Combo().setSelectedIndex(0);
        } else {
            // ��ƗÖ@I�`�F�b�N(workTherapy1)���I������Ă��Ȃ��ꍇ
            // ��ƗÖ@I�R���{(workTherapy1Combo)�𖳌��ɂ���B
            setState_INVALID_WORK_THERAPY1();
            // ��ƗÖ@I�R���{(workTherapy1Combo)�𖢑I����Ԃɂ���B
            getWorkTherapy1Combo().clearSelection();
        }

    }

    /**
     * �u��ƗÖ@II�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void workTherapy2ActionPerformed(ActionEvent e) throws Exception {
        // ����ƗÖ@II�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getWorkTherapy2().isSelected()) {
            // ��ƗÖ@II�`�F�b�N(workTherapy2)���I������Ă���ꍇ
            // ��ƗÖ@II�R���{(workTherapy2Combo)��L���ɂ���B
            setState_VALID_WORK_THERAPY2();
            // ��ƗÖ@II�R���{(workTherapy2Combo)��1�ڂ̍��ڂ�I������B
            getWorkTherapy2Combo().setSelectedIndex(0);
        } else {
            // ��ƗÖ@II�`�F�b�N(workTherapy2)���I������Ă��Ȃ��ꍇ
            // ��ƗÖ@II�R���{(workTherapy2Combo)�𖳌��ɂ���B
            setState_INVALID_WORK_THERAPY2();
            // ��ƗÖ@II�R���{(workTherapy2Combo)�𖢑I����Ԃɂ���B
            getWorkTherapy2Combo().clearSelection();
        }

    }

    /**
     * �u���(I)�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void work1ActionPerformed(ActionEvent e) throws Exception {
        // �����(I)�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getWork1().isSelected()) {
            // ���(I)�`�F�b�N(work1)���I������Ă���ꍇ
            // ���(I)�R���{(work1Combo)��L���ɂ���B
            setState_VALID_WORK1();
            // ��ƁiI�j�R���{(work1Combo)��1�ڂ̍��ڂ�I������B
            getWork1Combo().setSelectedIndex(0);
        } else {
            // ���(I)�`�F�b�N(work1)���I������Ă��Ȃ��ꍇ
            // ���(I)�R���{(work1Combo)�𖳌��ɂ���B
            setState_INVALID_WORK1();
            // ���(I)�R���{(work1Combo)�𖢑I����Ԃɂ���B
            getWork1Combo().clearSelection();
        }

    }

    /**
     * �u���(II)�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void work2ActionPerformed(ActionEvent e) throws Exception {
        // �����(II)�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getWork2().isSelected()) {
            // ���(II)�`�F�b�N(work2)���I������Ă���ꍇ
            // ���(II)�R���{(work2Combo)��L���ɂ���B
            setState_VALID_WORK2();
            // ��ƁiII�j�R���{(work2Combo)��1�ڂ̍��ڂ�I������B
            getWork2Combo().setSelectedIndex(0);
        } else {
            // ���(II)�`�F�b�N(work2)���I������Ă��Ȃ��ꍇ
            // ���(II)�R���{(work2Combo)�𖳌��ɂ���B
            setState_INVALID_WORK2();
            // ���(II)�R���{(work2Combo)�𖢑I����Ԃɂ���B
            getWork2Combo().clearSelection();
        }

    }

    /**
     * �u���퐶�����������Z�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void normalLife2ActionPerformed(ActionEvent e) throws Exception {
        // �����퐶�����������Z�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getNormalLife2().isSelected()) {
            // ���퐶�����������Z�`�F�b�N(normalLife2)���I������Ă���ꍇ
            // ���퐶�����������Z�R���{(normalLife2Combo)��L���ɂ���B
            setState_VALID_NORMAL_LIFE2();
            // ���퐶�����������Z�R���{(normalLife2Combo)��1�ڂ̍��ڂ�I������B
            getNormalLife2Combo().setSelectedIndex(0);
        } else {
            // ���퐶�����������Z�`�F�b�N(normalLife2)���I������Ă��Ȃ��ꍇ
            // ���퐶�����������Z�R���{(normalLife2Combo)�𖳌��ɂ���B
            setState_INVALID_NORMAL_LIFE2();
            // ���퐶�����������Z�R���{(normalLife2Combo)�𖢑I����Ԃɂ���B
            getNormalLife2Combo().clearSelection();
        }
    }

    /**
     * �u���꒮�o�Ö@�h�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void languageTherapy1ActionPerformed(ActionEvent e)
            throws Exception {
        // �����꒮�o�Ö@�h�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getLanguageTherapy1().isSelected()) {
            // ���꒮�o�Ö@�h�`�F�b�N(languageTherapy1)���I������Ă���ꍇ
            // ���꒮�o�Ö@�h�R���{(languageTherapy1Combo)��L���ɂ���B
            setState_VALID_LANGUAGE_THERAPY1();
            // ���꒮�o�Ö@�h�R���{(languageTherapy1Combo)��1�ڂ̍��ڂ�I������B
            getLanguageTherapy1Combo().setSelectedIndex(0);
        } else {
            // ���꒮�o�Ö@�h�`�F�b�N(languageTherapy1)���I������Ă��Ȃ��ꍇ
            // ���꒮�o�Ö@�h�R���{(languageTherapy1Combo)�𖳌��ɂ���B
            setState_INVALID_LANGUAGE_THERAPY1();
            // ���꒮�o�Ö@�h�R���{(languageTherapy1Combo)�𖢑I����Ԃɂ���B
            getLanguageTherapy1Combo().clearSelection();
        }

    }

    /**
     * �u���꒮�o�Ö@�hI�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void languageTherapy2ActionPerformed(ActionEvent e)
            throws Exception {
        // �����꒮�o�Ö@�hI�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getLanguageTherapy2().isSelected()) {
            // ���꒮�o�Ö@�hI�`�F�b�N(languageTherapy2)���I������Ă���ꍇ
            // ���꒮�o�Ö@�hI�R���{(languageTherapy2Combo)��L���ɂ���B
            setState_VALID_LANGUAGE_THERAPY2();
            // ���꒮�o�Ö@�hI�R���{(languageTherapy2Combo)��1�ڂ̍��ڂ�I������B
            getLanguageTherapy2Combo().setSelectedIndex(0);
        } else {
            // ���꒮�o�Ö@�hI�`�F�b�N(languageTherapy2)���I������Ă��Ȃ��ꍇ
            // ���꒮�o�Ö@�hI�R���{(languageTherapy2Combo)�𖳌��ɂ���B
            setState_INVALID_LANGUAGE_THERAPY2();
            // ���꒮�o�Ö@�hI�R���{(languageTherapy2Combo)�𖢑I����Ԃɂ���B
            getLanguageTherapy2Combo().clearSelection();
        }

    }

    /**
     * �u���꒮�o(I)�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void language1ActionPerformed(ActionEvent e) throws Exception {
        // �����꒮�o(I)�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getLanguage1().isSelected()) {
            // ���꒮�o(I)�`�F�b�N(language1)���I������Ă���ꍇ
            // ���꒮�o(I)�R���{(language1Combo)��L���ɂ���B
            setState_VALID_LANGUAGE1();
            // ���꒮�o�iI�j�R���{(language1Combo)��1�ڂ̍��ڂ�I������B
            getLanguage1Combo().setSelectedIndex(0);
        } else {
            // ���꒮�o(I)�`�F�b�N(language1)���I������Ă��Ȃ��ꍇ
            // ���꒮�o(I)�R���{(language1Combo)�𖳌��ɂ���B
            setState_INVALID_LANGUAGE1();
            // ���꒮�o(I)�R���{(language1Combo)�𖢑I����Ԃɂ���B
            getLanguage1Combo().clearSelection();
        }

    }

    /**
     * �u���꒮�o(II)�̗L����ԕύX�v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void language2ActionPerformed(ActionEvent e) throws Exception {
        // �����꒮�o(II)�̃`�F�b�N�L���ɉ����ăR���{�̗L����Ԃ�ύX
        if (getLanguage2().isSelected()) {
            // ���꒮�o(II)�`�F�b�N(language2)���I������Ă���ꍇ
            // ���꒮�o(II)�R���{(language2Combo)��L���ɂ���B
            setState_VALID_LANGUAGE2();
            // ���꒮�o�iII�j�R���{(language2Combo)��1�ڂ̍��ڂ�I������B
            getLanguage2Combo().setSelectedIndex(0);
        } else {
            // ���꒮�o(II)�`�F�b�N(language2)���I������Ă��Ȃ��ꍇ
            // ���꒮�o(II)�R���{(language2Combo)�𖳌��ɂ���B
            setState_INVALID_LANGUAGE2();
            // ���꒮�o(II)�R���{(language2Combo)�𖢑I����Ԃɂ���B
            getLanguage2Combo().clearSelection();
        }

    }

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001028.class.getName(), param));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param systemServiceKindDetail int
     * @param param VRMap
     * @throws Exception ������O
     * @return boolean
     */
    public boolean showModal(int systemServiceKindDetail, VRMap param)
            throws Exception {
        // ����ʂ̏�����

        setAffairTitle("QS001028");
        
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();

        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F109�i���w�Ö@(I)�j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 109 �� VALUE �Ƃ��Đݒ肷��B
        VRList codes = QkanCommon.getArrayFromMasterCode(109, "3010114");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010115");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010116");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010117");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010118");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010119");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010120");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010121");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010122");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010125");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010126");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010127");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010128");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010129");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010132");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010133");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010134");
        ACBindUtilities.copyBindPath(codes, "CONTENT_KEY", "3010135");
        comboItemMap.setData("109", codes);
        // ���R���{�A�C�e���̐ݒ�
        // ���g(specificConsultationFeePattern)��comboItemMap�ɐݒ肷��B
        getSpecificConsultationFeePattern().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getSpecificConsultationFeePattern().bindModelSource();

        // ���T�[�r�X�̎�ނɉ����ĕ\�����ڂ𐧌�����B

        switch (systemServiceKindDetail) {
        // ����systemServiceKindDetail�̒l���ȉ��̒Z�������×{���T�[�r�X�̏ꍇ
        // �E12201�F�Z�������×{���(�V��)
        case 12201:
        case 12211:
        // �E12301�F�Z�������×{���(�×{�a����L����a�@)
        case 12301:
        case 12311:
        // �E12302�F�Z�������×{���(�×{�a����L����f�Ï�)
        case 12302:
        case 12312:
        // �E12303�F�Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
        case 12303:
        case 12313:
        // �E12304�F�Z�������×{���(��K���f�Ï�)
        case 12304:
        case 12314:
            // �u�������@�f�ÊǗ��E�����v��Ԃɂ���B
            setState_INVALID_BEGINNIGN_GUIDANCE();
            break;
        }
        switch (systemServiceKindDetail) {
        // ����systemServiceKindDetail�̒l���ȉ��̘V�l���F�m�ǎ����×{�a���T�[�r�X�̏ꍇ
        case 12303:
        case 12313:
        // �E12303�F�Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
        case 15303:
        case 15313:
            // �E15303�F���×{�^��Î{��(�V�l���F�m�ǎ����×{�a����L����a�@)
            // �u�V�l���F�m�ǎ����×{�a���v��Ԃɂ���B
            setState_OLD_COGNITIVE_WARD();
            break;
        }

        // �������œn���ꂽ����f�Ô������ʂɓW�J����B
        // ����param ������ϐ�values�ɐݒ肷��B
        setValues(param);
        // values�̒l����ʂɓW�J����B
        getSpecificConsultationFeePattern().setSource(getValues());
        getSpecificConsultationFeePattern().bindSource();

        // ���R���{�̑I����Ԃ���`�F�b�N�̑I����ԂƃR���{�̗L��������߂�B


        // ���w�Ö@�i�h�j�R���{(scienceTherapy1Combo)���I������Ă���΁A���w�Ö@�i�h�j�`�F�b�N(scienceTherapy1)��I������B
        getScienceTherapy1()
                .setSelected(getScienceTherapy1Combo().isSelected());
        if(getScienceTherapy1().isSelected()){
            setState_VALID_SCIENCE_THERAPY1();
        }
        // ���w�Ö@�i�h�h�j�R���{(scienceTherapy2Combo)���I������Ă���΁A���w�Ö@�i�h�h�j�`�F�b�N(scienceTherapy2)��I������B
        getScienceTherapy2()
                .setSelected(getScienceTherapy2Combo().isSelected());
        if(getScienceTherapy2().isSelected()){
            setState_VALID_SCIENCE_THERAPY2();
        }
        // ���w�Ö@�i�h�h�h�j�R���{(scienceTherapy3Combo)���I������Ă���΁A���w�Ö@�i�h�h�h�j�`�F�b�N(scienceTherapy3)��I������B
        getScienceTherapy3()
                .setSelected(getScienceTherapy3Combo().isSelected());
        if(getScienceTherapy3().isSelected()){
            setState_VALID_SCIENCE_THERAPY3();
        }
        // ���w�Ö@�i�h�u�j�R���{(scienceTherapy4Combo)���I������Ă���΁A���w�Ö@�i�h�u�j�`�F�b�N(scienceTherapy4)��I������B
        getScienceTherapy4()
                .setSelected(getScienceTherapy4Combo().isSelected());
        if(getScienceTherapy4().isSelected()){
            setState_VALID_SCIENCE_THERAPY4();
        }
        // ���w�i�h�j�R���{(science1Combo)���I������Ă���΁A���w�i�h�j�`�F�b�N(science1)��I������B
        getScience1().setSelected(getScience1Combo().isSelected());
        if(getScience1().isSelected()){
            setState_VALID_SCIENCE1();
        }
        // ���w�i�h�h�j�R���{(science2Combo)���I������Ă���΁A���w�i�h�h�j�`�F�b�N(science2)��I������B
        getScience2().setSelected(getScience2Combo().isSelected());
        if(getScience2().isSelected()){
            setState_VALID_SCIENCE2();
        }
        // ���w�i�h�h�h�j�R���{(science3Combo)���I������Ă���΁A���w�i�h�h�h�j�`�F�b�N(science3)��I������B
        getScience3().setSelected(getScience3Combo().isSelected());
        if(getScience3().isSelected()){
            setState_VALID_SCIENCE3();
        }
        // ���w�i�h�u�j�R���{(science4Combo)���I������Ă���΁A���w�i�h�u�j�`�F�b�N(science4)��I������B
        getScience4().setSelected(getScience4Combo().isSelected());
        if(getScience4().isSelected()){
            setState_VALID_SCIENCE4();
        }
        // ���퐶�������P�����Z�R���{(normalLifeCombo)���I������Ă���΁A���퐶�������P�����Z�`�F�b�N(normalLife)��I������B
        getNormalLife().setSelected(getNormalLifeCombo().isSelected());
        if(getNormalLife().isSelected()){
            setState_VALID_NORMAL_LIFE_();
        }
        // ��ƗÖ@I�R���{(workTherapy1Combo)���I������Ă���΁A��ƗÖ@I�`�F�b�N(workTherapy1)��I������B
        getWorkTherapy1().setSelected(getWorkTherapy1Combo().isSelected());
        if(getWorkTherapy1().isSelected()){
            setState_VALID_WORK_THERAPY1();
        }
        // ��ƗÖ@II�R���{(workTherapy2Combo)���I������Ă���΁A��ƗÖ@II�`�F�b�N(workTherapy2)��I������B
        getWorkTherapy2().setSelected(getWorkTherapy2Combo().isSelected());
        if(getWorkTherapy2().isSelected()){
            setState_VALID_WORK_THERAPY2();
        }
        // ���(I)�R���{(work1Combo)���I������Ă���΁A���(I)�`�F�b�N(work1)��I������B
        getWork1().setSelected(getWork1Combo().isSelected());
        if(getWork1().isSelected()){
            setState_VALID_WORK1();
        }
        // ���(II)�R���{(work2Combo)���I������Ă���΁A���(II)�`�F�b�N(work2)��I������B
        getWork2().setSelected(getWork2Combo().isSelected());
        if(getWork2().isSelected()){
            setState_VALID_WORK2();
        }
        // ���퐶�����������Z�R���{(normalLife2Combo)���I������Ă���΁A���퐶�����������Z�`�F�b�N(normalLife2)��I������B
        getNormalLife2().setSelected(getNormalLife2Combo().isSelected());
        if(getNormalLife2().isSelected()){
            setState_VALID_NORMAL_LIFE2();
        }
        // ���꒮�o�Ö@�h�R���{(languageTherapy1Combo)���I������Ă���΁A���꒮�o�Ö@�h�`�F�b�N(languageTherapy1)��I������B
        getLanguageTherapy1().setSelected(
                getLanguageTherapy1Combo().isSelected());
        if(getLanguageTherapy1().isSelected()){
            setState_VALID_LANGUAGE_THERAPY1();
        }
        // ���꒮�o�Ö@�hI�R���{(languageTherapy2Combo)���I������Ă���΁A���꒮�o�Ö@�hI�`�F�b�N(languageTherapy2)��I������B
        getLanguageTherapy2().setSelected(
                getLanguageTherapy2Combo().isSelected());
        if(getLanguageTherapy2().isSelected()){
            setState_VALID_LANGUAGE_THERAPY2();
        }
        // ���꒮�o(I)�R���{(language1Combo)���I������Ă���΁A���꒮�o(I)�`�F�b�N(language1)��I������B
        getLanguage1().setSelected(getLanguage1Combo().isSelected());
        if(getLanguage1().isSelected()){
            setState_VALID_LANGUAGE1();
        }
        // ���꒮�o(II)�R���{(language2Combo)���I������Ă���΁A���꒮�o(II)�`�F�b�N(language2)��I������B
        getLanguage2().setSelected(getLanguage2Combo().isSelected());
        if(getLanguage2().isSelected()){
            setState_VALID_LANGUAGE2();
        }

        // ��ʂ�\������B
        setVisible(true);

        return getApplied();
    }

    public static String[] getTargetBindPathes(int systemServiceKindDetail)
            throws Exception {
        switch (systemServiceKindDetail) {
        // ����systemServiceKindDetail�̒l���ȉ��̒Z�������×{���T�[�r�X�̏ꍇ
        case 12201://�Z�������×{���(�V��)
        case 12211:
        case 12301:// �Z�������×{���i�a�@�×{�j
        case 12311:
        case 12302:// �Z�������×{���i�f�Ï��×{�j
        case 12312:
        case 12304://�Z�������×{���(��K���f�Ï�)
        case 12314:
            return new String[] { "3010101", "3010102", "3010104", "3010105",
                    "3010106", "3010107", "3010108", "3010109","3010110",
                    "3010111", "3010112", "3010113", "3010114", "3010115",
                    "3010116", "3010117", "3010118", "3010119", "3010120",
                    "3010121", "3010122", "3010123", "3010124", "3010125",
                    "3010126", "3010127", "3010128", "3010129", "3010130",
                    "3010131", "3010132", "3010133", "3010134", "3010135",
                    "3010136", "3010137", "3010138", };
        // ����systemServiceKindDetail�̒l���ȉ��̒Z�������×{��삩�V�l���F�m�ǎ����×{�a���T�[�r�X�̏ꍇ
        case 12303:// �Z�������×{���(�V�l���F�m�ǎ����×{�a����L����a�@)
        case 12313:
            return new String[] { "3010101", "3010102", "3010104", "3010137",
                    "3010138", };
        // ����systemServiceKindDetail�̒l���ȉ��̘V�l���F�m�ǎ����×{�a���T�[�r�X�̏ꍇ
        case 15303:// ���×{�^��Î{��(�V�l���F�m�ǎ����×{�a����L����a�@)
        case 15313:
            return new String[] { "3010101", "3010102", "3010103", "3010104",
                    "3010137", "3010138", };
        default:
            return new String[] { "3010101", "3010102", "3010103", "3010104",
                    "3010105", "3010106", "3010107", "3010108","3010109",
                    "3010110", "3010111", "3010112", "3010113", "3010114",
                    "3010115", "3010116", "3010117", "3010118", "3010119",
                    "3010120", "3010121", "3010122", "3010123", "3010124",
                    "3010125", "3010126", "3010127", "3010128", "3010129",
                    "3010130", "3010131", "3010132", "3010133", "3010134",
                    "3010135", "3010136", "3010137", "3010138", };
        }
    }

}
