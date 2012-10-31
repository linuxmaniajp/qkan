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
 * �J����: ��i�@�a�P
 * �쐬��: 2007/02/27  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���ی��T�[�r�X���p�̎����i�̎�������j (001)
 * �v���O���� ���ی��T�[�r�X���p�̎����i�̎�������j (QP001P19)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;

/**
 * ���ی��T�[�r�X���p�̎����i�̎�������j ���[��`�̃t�@�C���� �F QP001P215.xml
 */
public class QP001P215 extends QP001P21Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P215() {
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
        ACChotarouXMLUtilities.addFormat(writer, "QP001P215", "QP001P215.xml");
        // �y�[�W�J�n
        writer.beginPageEdit("QP001P215");

        //���[���ʂ̃f�[�^�ݒ���s���B
        setBasicData();

        //��ÍT���z
        if(serviceDetail != null){
            ACChotarouXMLUtilities.setValue(writer, "iryokojyo", getFormatData(serviceDetail,"KOJO_TARGET"));
        }
        //������x�����Ə���
        if(care_provider != null){
            ACChotarouXMLUtilities.setValue(writer, care_provider, "PROVIDER_NAME","jigyousyoname2");
        }
        
        //�̎��N����
        if(ryousyuDate != null){
            // �����N�����̘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "ryosyuDate2.h1.w2", eraFormat.format(ryousyuDate));
            // �����N�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "ryosyuDate2.h1.w3", eraYearFormat.format(ryousyuDate));
            // �����N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "ryosyuDate2.h1.w5", monthFormat.format(ryousyuDate));
            // �����N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "ryosyuDate2.h1.w7", dayFormat.format(ryousyuDate));
        }
        
        //�y�[�W�I��
        writer.endPageEdit();
        //��������s�����Ȃ��true��Ԃ��B
        return true;
    }

}
