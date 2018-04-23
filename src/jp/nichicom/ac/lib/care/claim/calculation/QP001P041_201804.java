
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
 * �쐬��: 2006/01/17  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j (001)
 * �v���O���� �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j (QP001051)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.or.med.orca.qkan.QkanConstants;

public class QP001P041_201804 extends QP001P04_201804{
	
	/* 
	 * �l����l 201804�ȍ~
	 * 
	 * addFormat()
	 * �ݒ肷�钠�[��`�̂�ύX
	 * 
	 * getFormatId()
	 * �t�H�[�}�b�g�ԍ��̕ύX
	 */

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P041_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P041_201804";
    }

    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/28 add - begin
    protected int getSpecialClinicRecordType() {
    	//���ʗ×{��̃��R�[�h�^�C�v��Ԃ�
    	return QkanConstants.SPECIAL_CLINIC_RECORD_TYPE_TOKUBETU_RYOYO;
    }
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/28 add - end
}
