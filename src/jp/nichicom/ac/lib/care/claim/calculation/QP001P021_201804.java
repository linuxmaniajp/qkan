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
 * �v���O���� �ݑ�T�[�r�X��싋�t��׏��i����j (QP001P031)
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

public class QP001P021_201804 extends QP001P02_201804{
    
	//�l����� 201804�N�ȍ~

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P021_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P021_201804";
    }
    
    public void doPrintDetailList(VRList detailList,int kohiCount) throws Exception {
        setDetailList(detailList,11,kohiCount);
    }
    
 // 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
    @Override
    public void doPrintDetailJushotiTokureiList(
    		VRList detailJushotiTokureiList, int kohiCount) throws Exception {
    	setDetailJushotiTokureiList(detailJushotiTokureiList, 4, kohiCount);
    }
 // 2015/1/14 [Yoichiro Kamei] add - end
    
    @Override
    public double getDetailRowCount() {
        return 10d;
    }

    public void doPrintReductionList(VRList reductionList) throws Exception {
 // 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
    	//�o�͑ΏۂƂȂ�T�[�r�X���
    	List<String> targetKindList = Arrays.asList(new String[]{
    			  "11" //�K����
    			, "15" //�ʏ����
    			, "76" //�������E�����Ή��^�K����Ō�
    			, "71" //��ԑΉ��^�K����
    			, "72" //�F�m�ǑΉ��^�ʏ����
    			, "73" //���K�͑��@�\�^������i�Z�����p�^�ȊO�j
    			, "77" //�����^�T�[�r�X�i�Ō쏬�K�͑��@�\�^������E�Z�����p�^�ȊO�j
    			, "68" //���K�͑��@�\�^������i�Z�����p�^�j
    			, "79" //�����^�T�[�r�X�i��쏬�K�͑��@�\�^������E�Z�����p�^�j
    			, "78" //�n�斧���^�ʏ���� H28.4����
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
//        if (reductionList.getDataSize() > 0) {
//            //�y������ݒ肷��B
//            ACChotarouXMLUtilities.setValue(writer, "keigenritsu",
//                    pad(VRBindPathParser.get("901007",
//                            (VRMap) reductionList.getData(0)), 4));
//
//            for (int j = 0; j < reductionList.getDataSize(); j++) {
//                VRMap reduction = (VRMap) reductionList.getData(j);
//                
//                String kind = ACCastUtilities.toString(VRBindPathParser.get("901008", reduction));
//                
//                //kind���T�[�r�X��ރR�[�h
//                //11:�K����A15:�ʏ����A76:�������A71:��ԑΉ��^�A72:�F�m�ǑΉ��^
//                //73:���K�͑��@�\�A77:�����^
//                
//                //���p�ҕ��S�z�̑��z��ݒ�
//                ACChotarouXMLUtilities.setValue(writer, "jyuryo" + kind, pad(VRBindPathParser.get("901009", reduction), 6));
//                //�y���z��ݒ�
//                ACChotarouXMLUtilities.setValue(writer, "keigen" + kind, pad(VRBindPathParser .get("901010", reduction), 6));
//                //�y���㗘�p�ҕ��S�z��ݒ�
//                ACChotarouXMLUtilities.setValue(writer, "keigengo" + kind, pad(VRBindPathParser.get("901011", reduction), 6));
//                //���l
//                ACChotarouXMLUtilities.setValue(writer, "syafuku.h" + kind + ".biko", VRBindPathParser.get("901012", reduction));
//            }
//        }
// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] mod - end
    }

}
