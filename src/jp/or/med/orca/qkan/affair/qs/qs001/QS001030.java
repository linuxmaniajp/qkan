
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
 * �쐬��: 2006/02/15  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �W�v���׉�� (QS001030)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceUnitCalcurateResult;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * �W�v���׉��(QS001030) 
 */
public class QS001030 extends QS001030Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001030(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // ����ʂ����
    // �@��ʂ�j�����܂��B
      dispose();
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001030.class.getName(), param));
  }

  //�����֐� 

  /**
   * �u�����ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void showModal(CareServiceUnitCalcurateResult inLimitAmout, CareServiceUnitCalcurateResult outerService, VRMap insureInfo) throws Exception{
    // ����ʓW�J���̏����ݒ�
    // �����������Ƀe�[�u�����f�����쐬���A�W�v���׃e�[�u��(detailsTable)�ɐݒ肷��B
      getDetailsTable().setModel(new ACTableModelAdapter(inLimitAmout, new String[]{
              "SYSTEM_SERVICE_KIND_DETAIL",
              "UNIT",
              "ADJUST",
              "RESULT",
      }));
      getOuterTable().setModel(new ACTableModelAdapter(outerService, new String[]{
              "SYSTEM_SERVICE_KIND_DETAIL",
              "UNIT",
              "ADJUST",
              "RESULT",
      }));
      getContents().setSource(insureInfo);
      getContents().bindSource();
      
    // ���E�B���h�E�^�C�g���̐ݒ�
    // �@�Ɩ���񃌃R�[�h���擾����B
    // �@�E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
      setAffairTitle("QS001030");
    
      setVisible(true);
  }

}
