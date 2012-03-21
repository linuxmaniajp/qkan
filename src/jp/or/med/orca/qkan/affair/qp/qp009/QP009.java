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
 * �J����: �����@�L
 * �쐬��: 2006/02/15  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X CSV�o�� (009)
 * �v���O���� �`���m�F (QP009)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp009;

import java.awt.event.ActionEvent;

/**
 * �`���m�F(QP009)
 */
public class QP009 extends QP009Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP009() {
    }

    // �R���|�[�l���g�C�x���g

    /**
     * �uOK�������̏����v�C�x���g�ł��B
     * 
     * @param e
     *            �C�x���g���
     * @throws Exception
     *             ������O
     */
    protected void okActionPerformed(ActionEvent e) throws Exception {
        // �u����ȍ~�͂��̃��b�Z�[�W��\�����Ȃ��B(nextCheck)�v���I������Ă���ꍇ
        if(getNextCheck().isSelected()){
            //�`�F�b�N��Ԃ�ݒ�t�@�C���ɕۑ�����B
            //Claim-Info ��1��ݒ肷��
            setProperty("Claim/Info","1");
        } else {
            setProperty("Claim/Info","0");
        }
        saveProperty();
        
        dispose();
    }

    /**
     * �u�N�����C�x���g�v�Ɋւ��鏈�����s�Ȃ��܂��B
     *
     * @throws Exception ������O
     *
     */
    public void showModal() throws Exception {
        setAffairTitle("QP009");
        setVisible(true);
    }

    
}
