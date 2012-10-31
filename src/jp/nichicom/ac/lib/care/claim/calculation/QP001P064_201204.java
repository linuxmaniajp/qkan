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
 * �쐬��: 2006/01/19  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X (�ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj (001)
 * �v���O���� (�ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj (QP001P074)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.util.VRMap;

public class QP001P064_201204 extends QP001P06_201204{
    
	/* 
	 * �l����Z�̎l 201204�ȍ~
	 * 
	 * addFormat()
	 * �ݒ肷�钠�[��`�̂�ύX
	 * 
	 * getFormatId()
	 * �t�H�[�}�b�g�ԍ��̕ύX
	 */

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P064_201204.xml");
    }

    public String getFormatId() throws Exception {
    	return "QP001P064_201204";
    }
    
    @Override
    protected void doPrintExternalUseHeader(VRMap baseMap, VRMap typeMap) throws Exception{
        //�����O�̏󋵂�ݒ肷��
        setBeforeHospitalization();
    }

    protected void doPrintExternalUse(VRMap baseMap,VRMap typeMap) throws Exception {
        //�O�����p�^���t����P�ʐ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "limit", pad(typeMap.get("701009"),6));
        //�O�����p�^����Ǘ��ΏےP�ʐ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "limittarget", pad(typeMap.get("701010"),6));
        //�O�����p�^���x�z�Ǘ��ΏۊO�P�ʐ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "limitout", pad(typeMap.get("701011"),6));
        //���t�P�ʐ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "hokentanitotal", pad(typeMap.get("701014"),6));
    }

}
