
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
 * �쐬��: 2011/11/21  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��o�^ (004)
 * �v���O���� ���\�h�Z�������×{���i�a�@�×{�^�j (QO004139)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRMap;

/**
 * ���\�h�Z�������×{���i�a�@�×{�^�j�C�x���g��`(QO004139) 
 */
@SuppressWarnings("serial")
public abstract class QO004_12611_201204Event extends QO004_12611_201204SQL implements iProviderServicePanel {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004_12611_201204Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getFacilitiesDivision().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                facilitiesDivisionSelectionChanged(e);
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
   * �u��ʏ�Ԑݒ�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void facilitiesDivisionSelectionChanged(ListSelectionEvent e) throws Exception;

  //�ϐ���`

  public static final int CODE_STAFF_REDUCE = 167;
  public static final int FACILITY_TYPE_BYOIN = 1;
  public static final int FACILITY_TYPE_UNIT = 2;
  public static final int FACILITY_TYPE_PASSAGE = 3;
  public static final int FACILITY_TYPE_UNIT_PASSAGE = 4;
  public static final int STAFF_LACK_KANGO_KAIGO = 2;
  public static final int STAFF_LACK_SEIKAN = 3;
  public static final int STAFF_LACK_HEKICHI = 5;
  public static final String PATH_STAFF_REDUCE = "1230109";
  //getter/setter

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * �u�p�l����Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param state boolean
   * @throws Exception ������O
   *
   */
  public abstract void stateManager(boolean state) throws Exception;

  /**
   * �u�p�l���f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param map VRMap
   * @throws Exception ������O
   *
   */
  public abstract void getDetails(VRMap map) throws Exception;

  /**
   * �u�����f�[�^�폜�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param map VRMap
   * @throws Exception ������O
   *
   */
  public abstract void removeInvalidData(VRMap map) throws Exception;

  /**
   * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void checkState() throws Exception;

}
