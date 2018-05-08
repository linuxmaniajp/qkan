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
 * �쐬��: 2006/01/13  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �ݑ�T�[�r�X��싋�t��׏��i����j (001)
 * �v���O���� �ݑ�T�[�r�X��싋�t��׏��i����j (QP001P032)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Arrays;
import java.util.List;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

public class QP001P023_201804 extends QP001P02_201804{
    
    // �l�����̎O 201804�N�ȍ~

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P023_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P023_201804";
    }
    
    public void doPrintDetailList(VRList detailList,int kohiCount) throws Exception {
        setDetailList(detailList,11,kohiCount);
    }
    
    @Override
    public void doPrintDetailJushotiTokureiList(
    		VRList detailJushotiTokureiList, int kohiCount) throws Exception {
    	setDetailJushotiTokureiList(detailJushotiTokureiList, 4, kohiCount);
    }

    public void doPrintReductionList(VRList reductionList) throws Exception {
    	// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/4 add - begin
    	//�o�͑ΏۂƂȂ�T�[�r�X���
    	List<String> targetKindList = Arrays.asList(new String[]{
    			  "A1" //�K��^�T�[�r�X(�݂Ȃ�)
    			, "A2" //�K��^�T�[�r�X(�Ǝ�)
    			, "A3" //�K��^�T�[�r�X(�Ǝ��^�藦)
    			, "A4" //�K��^�T�[�r�X(�Ǝ��^��z)
    			, "A5" //�ʏ��^�T�[�r�X(�݂Ȃ�)
    			, "A6" //�ʏ��^�T�[�r�X(�Ǝ�)
    			, "A7" //�ʏ��^�T�[�r�X(�Ǝ��^�藦)
    			, "A8" //�ʏ��^�T�[�r�X(�Ǝ��^��z)
    	});
    	if (reductionList.getDataSize() > 0) {
    		//�T�[�r�X��ރR�[�h���ΏۂɊ܂܂�Ă��Ȃ���Ώ���
            for (int j = 0; j < reductionList.getDataSize(); j++) {
                VRMap reduction = (VRMap) reductionList.getData(j);
                String kind = ACCastUtilities.toString(VRBindPathParser.get("901008", reduction));
                if (!targetKindList.contains(kind)) {
                	reductionList.remove(j);
                }
            }
    		setReductionList(reductionList, 4);
    	}    	
    	// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/4 add - end
    }

}
