
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
 * �쐬��: 2011/12/19  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j (QS001_12313_201504)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.vr.util.VRMap;

/**
 * �T�[�r�X�p�^�[���Z�������×{���i�F�m�ǎ����j�C�x���g��`(QS001_12313_201504) 
 */
public abstract class QS001_12313_201504Event extends QS001_12313_201504State implements QS001Service {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_12313_201504Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getShortStayDementiaRecuperationInstitutionDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shortStayDementiaRecuperationInstitutionDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShortStayDementiaRecuperationSpecificConsultationFee().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shortStayDementiaRecuperationSpecificConsultationFeeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShortStayDementiaRecuperationDinnerOffer().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shortStayDementiaRecuperationDinnerOfferActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShortStayDementiaRecuperationHospitalDivisionRadio().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shortStayDementiaRecuperationHospitalDivisionRadioActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShortStayDementiaRecuperationPersonSubtraction().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                shortStayDementiaRecuperationPersonSubtractionActionPerformed(e);
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
  protected abstract void shortStayDementiaRecuperationInstitutionDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u����f�Ô�̐ݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shortStayDementiaRecuperationSpecificConsultationFeeActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�H���񋟑I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shortStayDementiaRecuperationDinnerOfferActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�a���敪�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shortStayDementiaRecuperationHospitalDivisionRadioActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�l�����Z�I���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void shortStayDementiaRecuperationPersonSubtractionActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  public static final int SYSTEM_SERVICE_KIND_DETAIL = 12303;
  private boolean unitCareFlag;
  private boolean staffAssignmentFlag;
  private boolean divisionFlag;
  //getter/setter

  /**
   * unitCareFlag��Ԃ��܂��B
   * @return unitCareFlag
   */
  protected boolean getUnitCareFlag(){
    return unitCareFlag;
  }
  /**
   * unitCareFlag��ݒ肵�܂��B
   * @param unitCareFlag unitCareFlag
   */
  protected void setUnitCareFlag(boolean unitCareFlag){
    this.unitCareFlag = unitCareFlag;
  }

  /**
   * staffAssignmentFlag��Ԃ��܂��B
   * @return staffAssignmentFlag
   */
  protected boolean getStaffAssignmentFlag(){
    return staffAssignmentFlag;
  }
  /**
   * staffAssignmentFlag��ݒ肵�܂��B
   * @param staffAssignmentFlag staffAssignmentFlag
   */
  protected void setStaffAssignmentFlag(boolean staffAssignmentFlag){
    this.staffAssignmentFlag = staffAssignmentFlag;
  }

  /**
   * divisionFlag��Ԃ��܂��B
   * @return divisionFlag
   */
  protected boolean getDivisionFlag(){
    return divisionFlag;
  }
  /**
   * divisionFlag��ݒ肵�܂��B
   * @param divisionFlag divisionFlag
   */
  protected void setDivisionFlag(boolean divisionFlag){
    this.divisionFlag = divisionFlag;
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

}
