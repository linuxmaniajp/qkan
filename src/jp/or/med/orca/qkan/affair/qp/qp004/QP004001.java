
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
 * �쐬��: 2006/04/07  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (004)
 * �v���O���� ���莡�Ô�ҏW��� (QP004001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * ���莡�Ô�ҏW���(QP004001) 
 */
public class QP004001 extends QP004001Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP004001(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�N���A�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void medicalClearActionPerformed(ActionEvent e) throws Exception{
    // �ҏW�̈���N���A����B
      getRecordEditors().setSource((VRBindSource)getRecordEditors().createSource());
      getRecordEditors().bindSource();
  }

  /**
   * �u�ǉ��v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void medicalInsertActionPerformed(ActionEvent e) throws Exception{
    // �ҏW�̈�̏����ꗗ�ɒǉ�����B
      VRMap param = new VRHashMap();
      getRecordEditors().setSource(param);
      getRecordEditors().applySource();
      getEditMedicalInfos().add(param);
      getMedicalTable().setSelectedSortedLastRow();
  }

  /**
   * �u���ցv�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void medicalUpdateActionPerformed(ActionEvent e) throws Exception{
    // �ҏW�̈�̏��ňꗗ�̑I�����ڂ�����������B
      if(getMedicalTable().isSelected()){
          getRecordEditors().applySource();
          getMedicalTable().invalidate();
          getMedicalTable().repaint();
      }
  }

  /**
   * �u�폜�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void medicalDeleteActionPerformed(ActionEvent e) throws Exception{
    // �ꗗ�̑I�����ڂ��폜����B
      if(getMedicalTable().isSelected()){
          int row=getMedicalTable().getSelectedSortedRow();
          getEditMedicalInfos().remove(getMedicalTable().getSelectedModelRow());
          getMedicalTable().setSelectedSortedRowOnAfterDelete(row);
      }
  }

  /**
   * �uOK�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void apllyActionPerformed(ActionEvent e) throws Exception{
    // �ݒ�����W�v����ʂ����B
      setApplied(true);
      
      //�W�v
      
      
      
      //�]�L
      getMedicalInfos().clear();
      getMedicalInfos().addAll(getEditMedicalInfos());
      
      dispose();
  }

  /**
   * �u�L�����Z���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // ��ʂ����B
      dispose();
  }

  public static void main(String[] args) {
      // �f�t�H���g�f�o�b�O�N��
        try {
            ACFrame.setVRLookAndFeel();
            ACFrame.getInstance().setFrameEventProcesser(
                    new QkanFrameEventProcesser());
            QkanCommon.debugInitialize();
            new QP004001().showModal(new VRArrayList(), new VRArrayList(),new VRArrayList());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
  }

  //�����֐�

  /**
   * �u��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean showModal(VRList medicalInfos, VRList basicInfos, VRList totalInfos) throws Exception{
    // ��ʂ�\������B
      setMedicalInfos(medicalInfos);
      setBasicInfos(basicInfos);
      setTotalInfos(totalInfos);

      
      //��{���̕\��
      
      
      
      //�]�L
      Iterator it=getMedicalInfos().iterator();
      while(it.hasNext()){
          getEditMedicalInfos().add(((VRMap)it.next()).clone());
      }
      
      ACTableModelAdapter adapt=new ACTableModelAdapter(getEditMedicalInfos(), 
              new String[]{
          "401008",
          "401009",
          "401010",
          "401011",
          "401012",
          "401013",
          "401015",
          "401017",
      });
      getMedicalTable().setModel(adapt);
      
      if(getEditMedicalInfos().isEmpty()){
          setState_RECORD_DESELECTED();
      }else{
          getMedicalTable().setSelectedSortedFirstRow();
      }
      setVisible(true);
      return getApplied();
  }

  protected void medicalTableSelectionChanged(ListSelectionEvent e) throws Exception {
    //�I����Ԃɉ����ă��R�[�h�̕ҏW�{�^���̗L����Ԃ�ύX����B
    if(e.getValueIsAdjusting()){
        return;
    }
    if(getMedicalTable().isSelected()){
        setState_RECORD_SELECTED();
        getRecordEditors().setSource((VRBindSource)getEditMedicalInfos().get(getMedicalTable().getSelectedModelRow()));
        getRecordEditors().bindSource();
    }else{
        setState_RECORD_DESELECTED();
    }
}

}
