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
 * �J����: �����@���̂�
 * �쐬��: 2017/06/27  MIS��B������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �ݑ�T�[�r�X��싋�t��׏��i����j (001)
 * �v���O���� �ݑ�T�[�r�X��싋�t��׏��i����j (QP001P07)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * ����C�x���g
 * 
 * ���\�h�E���퐶���������Ɣ�׏��i���\�h�P�A�}�l�W�����g��j�C�x���g��`-�l���掵�̎O
 * 201804�N�ȍ~�i���ǒ���H29.8�`�Ή��j
 * �l���掵�Ƃ͈قȂ�̂ŗl���掵�̃N���X���p�����Ȃ��i�l�����̎O�Ɏ��Ă���j
 */
public class QP001P073_201804 extends QP001P02_10Event{
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P073_201804() {
    }

    public void addFormat() throws Exception {
    	ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P073_201804.xml");
        
    }

    public String getFormatId() throws Exception {
    	return "QP001P073_201804";
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
    public boolean doPrintImpl(VRMap printParam) throws Exception {
        
        // ��{��񃌃R�[�h
        VRMap baseMap = getBaseMap();
        // ���׏�񃌃R�[�h�W��
        VRList detailList = getDetailList();
        // �W�v��񃌃R�[�h
        VRList typeList = getTypeList();
        // ���׏��i�Z���n����j���R�[�h�W��
        VRList detailJushotiTokureiList = getDetailJushotiTokureiList();
        
        // ����Ő����Z�o����B�i1�ł�����̖��׏���10���A�Z���n�������3��)
        // ����������̎󋋂��󂯂Ă���ꍇ�́A�󋋌�����[���o�͂���B
        int pageCount = 1;
        int pageTemp = 1;

        if (detailList.getDataSize() > 0) {
        	pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 10d);
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
        if (detailJushotiTokureiList.getDataSize() > 0) {
        	pageTemp = (int) Math.ceil((double) detailJushotiTokureiList.getDataSize() / 3d);
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }

        // �����
        int kohiCount = 0;

        // ���R�[�h�̕���
        parseStyle();
        // ��{��񃌃R�[�h
        baseMap = getBaseMap();
        // ���׏�񃌃R�[�h
        detailList = getDetailList();
        // �W�v��񃌃R�[�h
        typeList = getTypeList();
        // ���׏�񃌃R�[�h
        detailJushotiTokureiList = getDetailJushotiTokureiList();
        
        // ������[�v
        for (int i = 0; i < pageCount; i++) {
            // �y�[�W�J�n
            writer.beginPageEdit(getFormatId());

            // ���[���ʏ���ݒ�
            setPrintHeader(kohiCount);

            // ���׏��̃e�[�u����ݒ�
            // ��11���𒴂���ꍇ�́A���y�[�W�Ɉ�
            setDetailList(detailList, 11, kohiCount);

            // �Z���n����
            setDetailJushotiTokureiList(detailJushotiTokureiList, 4, kohiCount);
            
            // �p�����ꖇ�߂̏ꍇ
            if (i == 0) {
            	
                // �W�v��
                if (typeList.getDataSize() != 0) {
                    
                    VRMap type = (VRMap) typeList.get(0);
                    // �P�ʐ��P����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "tanisutani",
                            getTanka(VRBindPathParser.get("701015", type)));
                }
                if (kohiCount == 0) {
                    // �P�ʐ����v��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "jigyobuntani",
                            pad(VRBindPathParser.get("201033", baseMap), 6));
                    // ���Ɣ���z��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "jigyoseikyu",
                            pad(VRBindPathParser.get("201034", baseMap), 6));
                    // ����P�ʐ����v��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "kohibuntani",
                            pad(VRBindPathParser.get("201039", baseMap), 6));
                    // ����t����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "kohikyufu",
                            pad(VRBindPathParser.get("201030", baseMap), 3));
                    // ������z���v��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "kohiseikyu",
                            pad(VRBindPathParser.get("201040", baseMap), 6));
                }
            }

            //����y�[�W������2���ȏ�̏ꍇ
            if ((kohiCountTotal * pageCount) > 1) {
                //�o�̓y�[�W���̑�����ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "totalpage",
                        ACCastUtilities.toString((kohiCountTotal * pageCount)));
                //���݂̏o�̓y�[�W����ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "nowpage",
                        ACCastUtilities.toString(((kohiCount * pageCount) + i + 1)));
            }
            //�y�[�W�I��
            writer.endPageEdit();
        }

        //��������s�����Ȃ��true��Ԃ��B
        return true;
    }
    

    /**
     * ���׏���ݒ肷��B
     * @param detailList
     * @param loopCount
     * @param kohiCount
     * @throws Exception
     */
    protected void setDetailList(VRList detailList,int loopCount,int kohiCount) throws Exception {
        // ���׌��������[�v����B
        for (int j = 1; j < loopCount; j++) {
            if (detailList.getDataSize() == 0)
                break;
            VRMap detail = (VRMap) detailList.get(0);
            // �T�[�r�X���e��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, detail, "301019",
                    "meisai.h" + j + ".w2");
            // �T�[�r�X�R�[�h��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "servicecode" + j,
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "301007", detail))
                            + ACCastUtilities.toString(VRBindPathParser
                                    .get("301008", detail)));

            //�P�ʐ���\������T�[�r�X�łȂ���ΒP�ʐ��P����\������B
            if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("301007")),String.valueOf(detail.get("301008")),
            		ACCastUtilities.toInt(detail.get("301027"), 0))){
                // �P�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "tani" + j, pad(
                        VRBindPathParser.get("301009", detail), 4));
            }

            // �����E�񐔂�ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "times" + j, pad(
                    VRBindPathParser.get("301010", detail), 2));
            
            // �T�[�r�X�P�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "servicetime" + j,
                    pad(VRBindPathParser.get("301014", detail), 6));

            
            switch (kohiCount) {
            // ����1
            case 0:
                // ����񐔂�ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301011", detail), 2));
                
                // ����ΏےP�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301015", detail), 6));
                break;
            // ����2
            case 1:
                // ����񐔂�ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301012", detail), 2));
                
                // ����ΏےP�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301016", detail), 6));

                break;
            // ����3
            case 2:
                // ����񐔂�ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301013", detail), 2));
                // ����ΏےP�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301017", detail), 6));
                break;
            }

            // �E�v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, detail, "301018",
                    "meisai.h" + j + ".tekiyo");
            detailList.remove(0);
        }
    }
    
    /**
     * ���׏��i�Z���n����j��ݒ肷��B
     * @param detailList
     * @param loopCount
     * @param kohiCount
     * @throws Exception
     */
    protected void setDetailJushotiTokureiList(VRList detailList,int loopCount,int kohiCount) throws Exception {
        // ���׌��������[�v����B
        for (int j = 1; j < loopCount; j++) {
            if (detailList.getDataSize() == 0)
                break;
            VRMap detail = (VRMap) detailList.get(0);
            // �T�[�r�X���e��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, detail, "1801020",
                    "j_meisai.h" + j + ".w2");
            // �T�[�r�X�R�[�h��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "j_servicecode" + j,
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "1801007", detail))
                            + ACCastUtilities.toString(VRBindPathParser
                                    .get("1801008", detail)));

            //�P�ʐ���\������T�[�r�X�łȂ���ΒP�ʐ��P����\������B
            if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("1801007")),String.valueOf(detail.get("1801008")),
            		ACCastUtilities.toInt(detail.get("1801028"), 0))){
                // �P�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "j_tani" + j, pad(
                        VRBindPathParser.get("1801009", detail), 4));
            }

            // �����E�񐔂�ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "j_times" + j, pad(
                    VRBindPathParser.get("1801010", detail), 2));
            // �T�[�r�X�P�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "j_servicetime" + j,
                    pad(VRBindPathParser.get("1801014", detail), 6));

            switch (kohiCount) {
            // ����1
            case 0:
                // ����񐔂�ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "j_kohitimes" + j, pad(VRBindPathParser.get(
                                "1801011", detail), 2));
                // ����ΏےP�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "j_kohitani" + j,
                        pad(VRBindPathParser.get("1801015", detail), 6));
                break;
            // ����2
            case 1:
                // ����񐔂�ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "j_kohitimes" + j, pad(VRBindPathParser.get(
                                "1801012", detail), 2));
                // ����ΏےP�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "j_kohitani" + j,
                        pad(VRBindPathParser.get("1801016", detail), 6));
                break;
            // ����3
            case 2:
                // ����񐔂�ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "j_kohitimes" + j, pad(VRBindPathParser.get(
                                "1801013", detail), 2));
                // ����ΏےP�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "j_kohitani" + j,
                        pad(VRBindPathParser.get("1801017", detail), 6));
                break;
            }
            
            // �{�ݏ��ݕی��Ҕԍ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, detail, "1801018",
                    "j_meisai.h" + j + ".w10");
            
            // �E�v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, detail, "1801019",
                    "j_meisai.h" + j + ".tekiyo");
            detailList.remove(0);
        }
    }

}
