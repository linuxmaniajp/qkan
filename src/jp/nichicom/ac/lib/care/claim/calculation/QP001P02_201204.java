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
 * �v���O���� �ݑ�T�[�r�X��싋�t��׏��i����j (QP00103)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �ݑ�T�[�r�X��싋�t��׏��i����j(�l�����) - ���[��`�̃t�@�C���� �F QP001P02X_YYYYYMM.xml
 */
public class QP001P02_201204 extends QP001P02_10Event {

    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P02_201204() {
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
        // �Е����ƃ��R�[�h
        VRList reductionList = getReductionList();
        
 // 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
        // ���׏��i�Z���n����j���R�[�h�W��
        VRList detailJushotiTokureiList = getDetailJushotiTokureiList();
 // 2015/1/14 [Yoichiro Kamei] add - end
        
        // ����Ő����Z�o����B�i1�ł�����̖��׏���14���A�W�v����4��)
        // ����������̎󋋂��󂯂Ă���ꍇ�́A�󋋌�����[���o�͂���B
        int pageCount = 1;
        int pageTemp = 1;

        if (detailList.getDataSize() > 0) {
            //pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 14d);
        	pageTemp = (int) Math.ceil((double) detailList.getDataSize() / getDetailRowCount());
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
        if (typeList.getDataSize() > 0) {
            pageTemp = (int) Math.ceil((double) typeList.getDataSize() / 4d);
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
 // 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] add - begin
        if (detailJushotiTokureiList.getDataSize() > 0) {
        	pageTemp = (int) Math.ceil((double) detailJushotiTokureiList.getDataSize() / getDetailJushotiTokureiRowCount());
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
        if (reductionList.getDataSize() > 0) {
        	pageTemp = (int) Math.ceil((double) reductionList.getDataSize() / 3d);
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
 // 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] add - end

        // ��������[�v
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            // ���R�[�h�̕���
            parseStyle();
            // ��{��񃌃R�[�h
            baseMap = getBaseMap();
            // ���׏�񃌃R�[�h
            detailList = getDetailList();
            // �W�v��񃌃R�[�h
            typeList = getTypeList();
            // �Е����ƃ��R�[�h
            reductionList = getReductionList();
 // 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
            // ���׏�񃌃R�[�h
            detailJushotiTokureiList = getDetailJushotiTokureiList();
 // 2015/1/14 [Yoichiro Kamei] add - end
            
            // ������[�v
            for (int i = 0; i < pageCount; i++) {
                // �y�[�W�J�n
                writer.beginPageEdit(getFormatId());

                // ���[���ʏ���ݒ�
                setPrintHeader(kohiCount);

                // ����T�[�r�X�󋵂�ݒ�
                setKyotakuData();

                // �J�n�A�I���󋵂�ݒ�
                setKaishiDate();
                
                //���׏��̃e�[�u����ݒ�
                //��12���𒴂���ꍇ�́A���y�[�W�Ɉ�
//                setDetailList(detailList,13,kohiCount);
                doPrintDetailList(detailList,kohiCount);

// 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
                doPrintDetailJushotiTokureiList(detailJushotiTokureiList, kohiCount);
// 2015/1/14 [Yoichiro Kamei] add - end
                
                // �W�v���������[�v����B��4���𒴂���ꍇ�́A���y�[�W�Ɉ�
                setTypeList(typeList,5,kohiCount);

// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
                // �Е��y����ݒ�
                doPrintReductionList(reductionList);
// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] mod - end
                
                // �p�����ꖇ�߂̏ꍇ
                if (i == 0) {
                    
                    if(kohiCount == 0){
                        // �ی����t����ݒ肷��B
                        if (!ACTextUtilities.isNullText(VRBindPathParser.get("201029", baseMap))) {
                            ACChotarouXMLUtilities.setValue(writer, "hokenkyufu",
                                            pad(VRBindPathParser.get("201029",baseMap), 3));
                        }
                        // �ی������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyutotal",
                                pad(VRBindPathParser.get("201034", baseMap), 6));
                        
                        // ���p�ҕ��S�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "riyousyahutantotal", pad(VRBindPathParser.get(
                                        "201035", baseMap), 6));
                    }

                    // ����Ԃɂ�蕪��
                    switch (kohiCount) {
                    // ����1
                    case 0:
                        // ����t����ݒ肷��B
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201030",
                                                baseMap), 3));
                        // ������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201040", baseMap), 6));
                        // ����{�l���S�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201041", baseMap), 6));
                        break;
                    // ����2
                    case 1:
                        // ����t����ݒ肷��B
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201031",
                                                baseMap), 3));
                        // ������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201046", baseMap), 6));
                        // ����{�l���S�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201047", baseMap), 6));
                        break;
                    // ����3
                    case 2:
                        // ����t����ݒ肷��B
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201032",
                                                baseMap), 3));
                        // ������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201052", baseMap), 6));
                        // ����{�l���S�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201053", baseMap), 6));
                        break;
                    }
                    
// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] mod - begin �ςƂȂ������ߏ�Ɉړ�
//                    //����̊g���|�C���g���R�[������B
//                    doPrintReductionList(reductionList);
// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] mod - end

                }

                //����y�[�W������2���ȏ�̏ꍇ
                if ((kohiCountTotal * pageCount) > 1) {
                    //�o�̓y�[�W���̑�����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((kohiCountTotal * pageCount)));
                    //���݂̏o�̓y�[�W����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
                            ACCastUtilities.toString(((kohiCount * pageCount) +i + 1)));
                }
                //�y�[�W�I��
                writer.endPageEdit();
            }

        }
        //��������s�����Ȃ��true��Ԃ��B
        return true;
    }
    
    /**
     * �l�����Ɨl�����̓�̍�����⊮����
     * @param printParam
     * @param reductionList
     * @throws Exception
     */
    public void doPrintReductionList(VRList reductionList) throws Exception{
        
    }
    /**
     * �l�����Ɨl�����̓�̍�����⊮����
     * @param printParam
     * @param reductionList
     * @throws Exception
     */
    public void doPrintDetailList(VRList detailList,int kohiCount) throws Exception {
        
    }
 // 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
    /**
     * ���׏��i�Z���n����j���̈���f�[�^�ݒ���s��
     * @param detailJushotiTokureiList
     * @param kohiCount
     * @throws Exception
     */
    public void doPrintDetailJushotiTokureiList(VRList detailJushotiTokureiList, int kohiCount) throws Exception {
        
    }
    /**
     * ���׏��i�Z���n����j���̂P�y�[�W������̏o�͍s�����擾����
     */
    public double getDetailJushotiTokureiRowCount() {
        return 3d;
    }
    
    
    //[H27.4����]�T�[�r�X�P�ʐ��T���˂U���o�͂̑Ή��̂��߁A�I�[�o�[���C�h���Ē�`
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
            if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("301007")),String.valueOf(detail.get("301008")))){
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
            if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("1801007")),String.valueOf(detail.get("1801008")))){
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
 // 2015/1/14 [Yoichiro Kamei] add - end
    
 // 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] add - begin
    /**
     * �Е��y����ݒ肷��B
     * @param reductionList
     * @param loopCount
     * @throws Exception
     */
    protected void setReductionList(VRList reductionList, int loopCount) throws Exception {
        if (reductionList.getDataSize() == 0) {
        	return;
        }
        //�y������ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "keigenritsu",
                pad(VRBindPathParser.get("901007",
                        (VRMap) reductionList.getData(0)), 4));
        
        // ���׌��������[�v����B
        for (int j = 1; j < loopCount; j++) {
            if (reductionList.getDataSize() == 0) {
            	break;
            }
            VRMap reduction = (VRMap) reductionList.get(0);
            String kind = ACCastUtilities.toString(VRBindPathParser.get("901008", reduction));
            
            //�T�[�r�X��ރR�[�h
            ACChotarouXMLUtilities.setValue(writer, "syafuku.h" + j + ".kind", kind);
            
            //�T�[�r�X����
            VRMap service = (VRMap) getServiceName().get(kind);
            ACChotarouXMLUtilities.setValue(writer, service, "SERVICE_KIND_NAME", "syafuku.h" + j + ".service");
                        
            //���p�ҕ��S�z�̑��z��ݒ�
            ACChotarouXMLUtilities.setValue(writer, "jyuryo" + j, pad(VRBindPathParser.get("901009", reduction), 6));
            //�y���z��ݒ�
            ACChotarouXMLUtilities.setValue(writer, "keigen" + j, pad(VRBindPathParser .get("901010", reduction), 6));
            //�y���㗘�p�ҕ��S�z��ݒ�
            ACChotarouXMLUtilities.setValue(writer, "keigengo" + j, pad(VRBindPathParser.get("901011", reduction), 6));
            //���l
            ACChotarouXMLUtilities.setValue(writer, "syafuku.h" + j + ".biko", VRBindPathParser.get("901012", reduction));
            
            reductionList.remove(0); //�ݒ�ς݂Ȃ̂őΏۂ��珜�O
        }
    }
// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] add - end
    
    public void addFormat() throws Exception {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        
    }

    public String getFormatId() throws Exception {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return null;
    }
    
    public double getDetailRowCount() {
        return 12d;
    }
    
}
