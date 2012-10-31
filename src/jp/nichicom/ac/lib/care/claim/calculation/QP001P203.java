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
 * �쐬��: 2006/02/06  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���ی��T�[�r�X���p�̎��� (001)
 * �v���O���� ���ی��T�[�r�X���p�̎��� (QP001P17)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;

/**
 * ���ی��T�[�r�X���p�̎��� ���[��`�̃t�@�C���� �F QP001P203.xml
 */
public class QP001P203 extends QP001P20Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P203() {
    }

    /**
     * ���[�𐶐����܂��B
     * 
     * @param writer
     *            ����Ǘ��N���X
     * @param printParam
     *            ����p�����^
     * @throws Exception
     *             ������O
     */
    public boolean doPrint()
            throws Exception {
        
        // �K�v�ł���Β��[ID�����������邱�ƁB
        ACChotarouXMLUtilities.addFormat(writer, "QP001P203", "QP001P203.xml");
        // �y�[�W�J�n
        writer.beginPageEdit("QP001P203");
        //���[���ʂ̃f�[�^�ݒ���s���B
        setBasicData();
        
        //�y�[�W�I��
        writer.endPageEdit();
        // ��������s�����Ȃ��true��Ԃ��B
        return true;
    }

}
