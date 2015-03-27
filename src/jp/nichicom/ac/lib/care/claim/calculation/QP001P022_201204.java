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

public class QP001P022_201204 extends QP001P02_201204{
    
    // �l�����̓� 201204�N�ȍ~

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P022_201204.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P022_201204";
    }
    
    public void doPrintDetailList(VRList detailList,int kohiCount) throws Exception {
 // 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] mod - begin 
 //       setDetailList(detailList,13,kohiCount);
        setDetailList(detailList,11,kohiCount);
 // 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] mod - end 
    }
    
 // 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
    @Override
    public void doPrintDetailJushotiTokureiList(
    		VRList detailJushotiTokureiList, int kohiCount) throws Exception {
    	setDetailJushotiTokureiList(detailJushotiTokureiList, 4, kohiCount);
    }
 // 2015/1/14 [Yoichiro Kamei] add - end

    public void doPrintReductionList(VRList reductionList) throws Exception {
// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
    	//�o�͑ΏۂƂȂ�T�[�r�X���
    	List<String> targetKindList = Arrays.asList(new String[]{"61", "65", "74", "75"});
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
//                // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - begin �T�[�r�X�R�[�h�p����
//                /*
//                switch (ACCastUtilities.toInt(VRBindPathParser.get(
//                        "901008", reduction))) {
//                case 61:
//                    //���\�h�K����T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��61�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "houmonjyuryo", pad(VRBindPathParser
//                                    .get("901009", reduction), 6));
//                    //���\�h�K����T�[�r�X��̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��11�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "houmonkeigen", pad(VRBindPathParser
//                                    .get("901010", reduction), 6));
//                    //���\�h�K����T�[�r�X��̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��11�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "houmonkeigengo", pad(VRBindPathParser
//                                    .get("901011", reduction), 6));
//                    //���\�h�K����T�[�r�X��̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��11�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syafuku.h1.w33", VRBindPathParser.get("901012", reduction));
//
//                    break;
//                case 65:
//                    //���\�h�ʏ����T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��12�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "tuusyojyuryo", pad(VRBindPathParser
//                                    .get("901009", reduction), 6));
//                    //���\�h�ʏ����T�[�r�X��̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��12�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "tuusyokeigen", pad(VRBindPathParser
//                                    .get("901010", reduction), 6));
//                    //���\�h�ʏ����T�[�r�X��̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��12�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "tuusyokeigengo", pad(VRBindPathParser
//                                    .get("901011", reduction), 6));
//                    //���\�h�ʏ����T�[�r�X��̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��12�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syafuku.h2.w33", VRBindPathParser.get("901012", reduction));
//                    break;
//
//                case 74:
//                    //���\�h�F�m�ǑΉ��^�ʏ����̃T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��71�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "ninchijyuryo", pad(VRBindPathParser
//                                    .get("901009", reduction), 6));
//                    //���\�h�F�m�ǑΉ��^�ʏ����̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��71�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "ninchikeigen", pad(VRBindPathParser
//                                    .get("901010", reduction), 6));
//                    //���\�h�F�m�ǑΉ��^�ʏ����̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��71�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "ninchikeigengo", pad(VRBindPathParser
//                                    .get("901011", reduction), 6));
//                    //���\�h�F�m�ǑΉ��^�ʏ����̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��71�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syafuku.h3.w33", VRBindPathParser.get("901012", reduction));
//                    break;
//
//                case 75:
//                    //���\�h���K�͑��@�\�^������̃T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��72�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syokibojyuryo", pad(VRBindPathParser
//                                    .get("901009", reduction), 6));
//                    //���\�h���K�͑��@�\�^������̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��72�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syokibokeigen", pad(VRBindPathParser
//                                    .get("901010", reduction), 6));
//                    //���\�h���K�͑��@�\�^������̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��72�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syokibokeigengo", pad(VRBindPathParser
//                                    .get("901011", reduction), 6));
//                    //���\�h���K�͑��@�\�^������̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��72�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syafuku.h4.w33", VRBindPathParser.get("901012", reduction));
//                    break;
//
//                }
//                */
//                //�T�[�r�X��ރR�[�h�ɂ��ݒ肷��
//                String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("901008", reduction));
//                if ("61".equals(serviceCodeKind)) {
//                    //���\�h�K����T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��61�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "houmonjyuryo", pad(VRBindPathParser
//                                    .get("901009", reduction), 6));
//                    //���\�h�K����T�[�r�X��̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��11�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "houmonkeigen", pad(VRBindPathParser
//                                    .get("901010", reduction), 6));
//                    //���\�h�K����T�[�r�X��̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��11�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "houmonkeigengo", pad(VRBindPathParser
//                                    .get("901011", reduction), 6));
//                    //���\�h�K����T�[�r�X��̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��11�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syafuku.h1.w33", VRBindPathParser.get("901012", reduction));
//                }
//                
//                if ("65".equals(serviceCodeKind)) {
//                    //���\�h�ʏ����T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��12�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "tuusyojyuryo", pad(VRBindPathParser
//                                    .get("901009", reduction), 6));
//                    //���\�h�ʏ����T�[�r�X��̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��12�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "tuusyokeigen", pad(VRBindPathParser
//                                    .get("901010", reduction), 6));
//                    //���\�h�ʏ����T�[�r�X��̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��12�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "tuusyokeigengo", pad(VRBindPathParser
//                                    .get("901011", reduction), 6));
//                    //���\�h�ʏ����T�[�r�X��̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��12�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syafuku.h2.w33", VRBindPathParser.get("901012", reduction));
//                }
//
//                if ("74".equals(serviceCodeKind)) {
//                    //���\�h�F�m�ǑΉ��^�ʏ����̃T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��71�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "ninchijyuryo", pad(VRBindPathParser
//                                    .get("901009", reduction), 6));
//                    //���\�h�F�m�ǑΉ��^�ʏ����̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��71�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "ninchikeigen", pad(VRBindPathParser
//                                    .get("901010", reduction), 6));
//                    //���\�h�F�m�ǑΉ��^�ʏ����̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��71�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "ninchikeigengo", pad(VRBindPathParser
//                                    .get("901011", reduction), 6));
//                    //���\�h�F�m�ǑΉ��^�ʏ����̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��71�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syafuku.h3.w33", VRBindPathParser.get("901012", reduction));
//                }
//
//                if ("75".equals(serviceCodeKind)) {
//                    //���\�h���K�͑��@�\�^������̃T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��72�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syokibojyuryo", pad(VRBindPathParser
//                                    .get("901009", reduction), 6));
//                    //���\�h���K�͑��@�\�^������̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��72�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syokibokeigen", pad(VRBindPathParser
//                                    .get("901010", reduction), 6));
//                    //���\�h���K�͑��@�\�^������̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��72�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syokibokeigengo", pad(VRBindPathParser
//                                    .get("901011", reduction), 6));
//                    //���\�h���K�͑��@�\�^������̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��72�̃��R�[�h���Ώ�
//                    ACChotarouXMLUtilities.setValue(writer,
//                            "syafuku.h4.w33", VRBindPathParser.get("901012", reduction));
//                }
//                // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - end   �T�[�r�X�R�[�h�p����
//            }
//        }
// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] mod - end
    }

}
