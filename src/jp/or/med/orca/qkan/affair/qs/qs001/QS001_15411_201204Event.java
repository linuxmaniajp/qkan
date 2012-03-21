
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
 * �v���O���� �T�[�r�X�p�^�[���n�斧���^��앟���{�� (QS001_15411_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.vr.util.VRMap;

/**
 * �T�[�r�X�p�^�[���n�斧���^��앟���{�݃C�x���g��`(QS001_15411_201204) 
 */
public abstract class QS001_15411_201204Event extends QS001_15411_201204State implements QS001Service {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_15411_201204Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getKaigoWelfareFacilityInstitutionDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoWelfareFacilityInstitutionDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoWelfareFacilityDinnerOffer().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoWelfareFacilityDinnerOfferActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoWelfareFacilityOralSwitchRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoWelfareFacilityOralSwitchRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoWelfareFacilityJunOralSwitchRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoWelfareFacilityJunOralSwitchRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoWelfareFacilityOldMeasuresPerson().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoWelfareFacilityOldMeasuresPersonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoWelfareFacilityTakingCareNursingAddRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoWelfareFacilityTakingCareNursingAddRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoWelfareFacilityCalculationDivisionRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoWelfareFacilityCalculationDivisionRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getOralKeepStructureAddRadioGroup().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                oralKeepStructureAddRadioGroupSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //�R���|�[�l���g�C�x���g

  /**
   * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoWelfareFacilityInstitutionDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�H���񋟑I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoWelfareFacilityDinnerOfferActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�o���ڍs���Z�̕ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoWelfareFacilityOralSwitchRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�o���ێ����Z�̕ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoWelfareFacilityJunOralSwitchRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u���[�u�����҃`�F�b�N�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoWelfareFacilityOldMeasuresPersonActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�Ŏ������Z�̕ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoWelfareFacilityTakingCareNursingAddRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u�Z��敪�̕ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void kaigoWelfareFacilityCalculationDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * �u���o�@�\�ێ��Ǘ��̐����Z�̕ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void oralKeepStructureAddRadioGroupSelectionChanged(ListSelectionEvent e) throws Exception;

  //�ϐ���`

  private boolean invalidUnitCareProvider;
  //getter/setter

  /**
   * invalidUnitCareProvider��Ԃ��܂��B
   * @return invalidUnitCareProvider
   */
  protected boolean getInvalidUnitCareProvider(){
    return invalidUnitCareProvider;
  }
  /**
   * invalidUnitCareProvider��ݒ肵�܂��B
   * @param invalidUnitCareProvider invalidUnitCareProvider
   */
  protected void setInvalidUnitCareProvider(boolean invalidUnitCareProvider){
    this.invalidUnitCareProvider = invalidUnitCareProvider;
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param provider VRMap
   * @throws Exception ������O
   *
   */
  public abstract void providerSelected(VRMap provider) throws Exception;

  /**
   * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return VRMap
   */
  public abstract VRMap getValidData() throws Exception;

  /**
   * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isUseProvider() throws Exception;

  /**
   * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return ACComboBox
   */
  public abstract ACComboBox getBeginTimeCombo() throws Exception;

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return ACComboBox
   */
  public abstract ACComboBox getEndTimeCombo() throws Exception;

  /**
   * �u�H����p���擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param meatType int
   * @throws Exception ������O
   * @return String
   */
  public abstract String getMeatCost(int meatType) throws Exception;

  /**
   * �u�f�[�^�o�C���h���̏����v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void binded() throws Exception;

}
