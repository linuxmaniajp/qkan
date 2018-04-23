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
 * �v���Z�X �ݑ�T�[�r�X��싋�t��׏��i�Z�������������j (001)
 * �v���O���� �ݑ�T�[�r�X��싋�t��׏��i�Z�������������j (QP001041)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

public class QP001P031_201804 extends QP001P03_201804{
    
	
	/* 
	 * �l����O 201804�ȍ~
	 * addFormat()
	 * �ݒ肷�钠�[��`�̂�ύX
	 * 
	 * getFormatId()
	 * �t�H�[�}�b�g�ԍ��̕ύX
	 */

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P031_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P031_201804";
    }    

    public void doPrintReductionList(VRMap reductionMap) throws Exception {
        
        if (reductionMap != null) {
        	// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p����
            //if (ACCastUtilities.toInt(VRBindPathParser.get(
            //        "901008", reductionMap)) == 21) {
        	String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("901008", reductionMap));
        	if ("21".equals(serviceCodeKind)) {
            // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - end   �T�[�r�X�R�[�h�p����
        		
                //�y������ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "keigenritsu", pad(VRBindPathParser.get(
                                "901007", reductionMap), 4));
                //�Z�������������T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��21�̃��R�[�h���Ώ�
                ACChotarouXMLUtilities.setValue(writer,
                        "tankijyuryo", pad(VRBindPathParser.get(
                                "901009", reductionMap), 6));
                //�Z�������������T�[�r�X��̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��21�̃��R�[�h���Ώ�
                ACChotarouXMLUtilities.setValue(writer,
                        "tankikeigen", pad(VRBindPathParser.get(
                                "901010", reductionMap), 6));
                //�Z�������������T�[�r�X��̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��21�̃��R�[�h���Ώ�
                ACChotarouXMLUtilities.setValue(writer,
                        "tankikeigengo", pad(VRBindPathParser.get(
                                "901011", reductionMap), 6));
                //�Z�������������T�[�r�X��̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��21�̃��R�[�h���Ώ�
                ACChotarouXMLUtilities.setValue(writer,
                        "syafuku.h8.w2", VRBindPathParser.get(
                                "901012", reductionMap));

            }
        }
    }

}
