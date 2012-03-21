
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
 * �쐬��: 2006/04/10  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���j���[ (M)
 * �v���Z�X ���C�����j���[ (002)
 * �v���O���� ���C�����j���[ (QM002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm002;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.mainmenu.ACFilterableMainMenuTree;
import jp.nichicom.ac.component.mainmenu.ACFilterableMainMenuTreeNode;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeExecuteAffair;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeNodePanel;
import jp.nichicom.ac.component.mainmenu.ACMainMenuTreeNodePanelFactoryAssistant;

/**
 * ���C�����j���[�C�x���g��`(QM002) 
 */
public abstract class QM002Event extends QM002SQL implements ACMainMenuTreeExecuteAffair, ACMainMenuTreeNodePanelFactoryAssistant {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QM002Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
   */
  protected void addEvents() {
    getLogout().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                logoutActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getShowVersion().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                showVersionActionPerformed(e);
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
   * �u���O�A�E�g�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void logoutActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u�o�[�W�������v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void showVersionActionPerformed(ActionEvent e) throws Exception;

  //�ϐ���`

  //getter/setter

  //�����֐�

  /**
   * �u���C�����j���[�����ǉ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param panel ACMainMenuTreeNodePanel
   * @param tree ACFilterableMainMenuTree
   * @param child ACFilterableMainMenuTreeNode
   * @param parameter Object
   * @throws Exception ������O
   *
   */
  public abstract void assistCreateMainMenuPanel(ACMainMenuTreeNodePanel panel, ACFilterableMainMenuTree tree, ACFilterableMainMenuTreeNode child, Object parameter) throws Exception;

}
