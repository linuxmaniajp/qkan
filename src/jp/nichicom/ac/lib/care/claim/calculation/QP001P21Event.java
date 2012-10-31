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
 * �v���Z�X ���ی��T�[�r�X���p������ (001)
 * �v���O���� ���ی��T�[�r�X���p������ (QP001P23)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * ���ی��T�[�r�X���p�������C�x���g��`(QP001P211) ���[��`�̃t�@�C���� �F QP001P211.xml
 * ���ی��T�[�r�X���p�������C�x���g��`(�U������������)(QP001P212) ���[��`�̃t�@�C���� �F QP001P212.xml
 * ���ی��T�[�r�X���p�̎����C�x���g��`(QP001P213) ���[��`�̃t�@�C���� �F QP001P213.xml
 * ���ی��T�[�r�X���p�̎����C�x���g��`(�U������������)(QP001P214) ���[��`�̃t�@�C���� �F QP001P214.xml
 * ���ی��T�[�r�X���p�̎����C�x���g��`�i�̎�������j(QP001P215) ���[��`�̃t�@�C���� �F QP001P215.xml
 */
public class QP001P21Event extends QP001P20Event {
	
	protected void setBasicData() throws Exception {
		super.setBasicData();

        // ���v�E���v���������Ƀ`�F�b�N�����Ă���ꍇ�A
        if(getIsTotalCheck()){
            // �����z��ݒ肷��B
        	if(serviceDetail != null){
        		// ���p�Ҍ����������R�[�h���쐬����Ă���ꍇ
        		// ���[�U�̓��͂ɏ]���󎚂���B��"0"��"0"�Ƃ��Ĉ󎚂���B
        		ACChotarouXMLUtilities.setValue(writer, "innertax", getFormatDataExceptZero(serviceDetail, "INNER_TAX"));
        	}else{
        		// ���p�Ҍ����������R�[�h���쐬����Ă��Ȃ��ꍇ
        		// "0"�������l�Ƃ��Ĉ󎚂���B
        		ACChotarouXMLUtilities.setValue(writer, "innertax", "0");
        	}
        }
	}
	
    public String getFormatDataExceptZero(VRMap style,String key) throws Exception{
        String value = String.valueOf(style.get(key));
        
        // "0"�̏ꍇ��""��ԋp���Ȃ��B
        if(ACTextUtilities.isNullText(value) || value.equalsIgnoreCase("NULL")){
            return "";
        }
        
        return getNf().format(ACCastUtilities.toDouble(value,0));
    }

}
