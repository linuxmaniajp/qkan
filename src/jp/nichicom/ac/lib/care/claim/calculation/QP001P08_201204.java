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
 * �v���Z�X �{�݃T�[�r�X����싋�t��׏��i��앟���{�݁j (001)
 * �v���O���� �{�݃T�[�r�X����싋�t��׏��i��앟���{�݁j (QP001P09)
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
 * �{�݃T�[�r�X����싋�t��׏��i��앟���{�݁j(�l���攪) - ���[��`�̃t�@�C���� �F QP001P080_YYYYMM.xml
 */
public class QP001P08_201204 extends QP001P02_10Event {
    
	/* 
	 * �l���攪 201204�ȍ~
	 * 
	 * addFormat()
	 * �ݒ肷�钠�[��`�̂�ύX
	 * 
	 * getFormatId()
	 * �t�H�[�}�b�g�ԍ��̕ύX
	 */
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P08_201204() {
    }
    
    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P080_201204.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P080_201204";
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
        // �K�v�ł���Β��[ID�����������邱�ƁB
        //ACChotarouXMLUtilities.addFormat(writer, "QP001P09", "QP001P09.xml");

        // ��{��񃌃R�[�h
        VRMap baseMap = getBaseMap();
        // ���׏�񃌃R�[�h�W��
        VRList detailList = getDetailList();
        // �W�v��񃌃R�[�h
        VRMap typeMap = getTypeMap();
        // ��������҉��T�[�r�X��񃌃R�[�h
        VRList nursingList = getNursingList();
        
        int detailsRecordCount = 10;
        
        VRMap nursingLast = getLastRecord(nursingList,"801007");
        // �Е����ƃ��R�[�h
        VRList reductionList = getReductionList();
        int pageCountMax = 0;
        int printPage = 1;
        // ��������[�v
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            parseStyle();
            // ���׏�񃌃R�[�h�W��
            detailList = getDetailList();
            // ��������҉��T�[�r�X��񃌃R�[�h
            nursingList = getNursingList();
            
            // ����Ő����Z�o����B�i1�ł�����̖��׏���11���A��������҉��T�[�r�X�����4��)
            //��������҂��󎚂��Ȃ��ꍇ������̂ŁA����v�Z����B
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / (double)detailsRecordCount);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)){
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 4d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            pageCountMax += pageCount;
        }

        // ��������[�v
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            parseStyle();
            // ��{��񃌃R�[�h
            baseMap = getBaseMap();
            // ���׏�񃌃R�[�h�W��
            detailList = getDetailList();
            // �W�v��񃌃R�[�h
            typeMap = getTypeMap();
            // ��������҉��T�[�r�X��񃌃R�[�h
            nursingList = getNursingList();
            // �Е����ƃ��R�[�h
            reductionList = getReductionList();
            
            // ����Ő����Z�o����B�i1�ł�����̖��׏���11���A��������҉��T�[�r�X�����4��)
            //��������҂��󎚂��Ȃ��ꍇ������̂ŁA����v�Z����B
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
            	pageTemp = (int) Math.ceil((double) detailList.getDataSize() / (double)detailsRecordCount);
            	
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)){
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 4d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }

            // ����y�[�W�����A���[�v����
            for (int i = 0; i < pageCount; i++,printPage++) {
                // �y�[�W�J�n
                writer.beginPageEdit(getFormatId());

                // ���[���ʏ���ݒ�
                setPrintHeader(kohiCount);
                
                setNyusyoDate();
                
                //�����O�̏󋵂�ݒ肷��
                setBeforeHospitalization();

                //���[�u����
                switch(ACCastUtilities.toInt(baseMap.get("201016"),0)){
                    //���[�u�Ȃ�
                    case 1:
                        ACChotarouXMLUtilities.setInvisible(writer,"kyusohciari");
                        break;
                    //���[�u����
                    case 2:
                        ACChotarouXMLUtilities.setInvisible(writer,"kyusohcinashi");
                        break;
                    default:
                        ACChotarouXMLUtilities.setInvisible(writer,"kyusohcinashi");
                        ACChotarouXMLUtilities.setInvisible(writer,"kyusohciari");
                        break;
                }
                if(isDetailListShow(kohiCount)){
                	setDetailList(detailList, detailsRecordCount + 1, kohiCount);
                }


                // ��������҉��T�[�r�X���������[�v����B��4���𒴂���ꍇ�́A���y�[�W�Ɉ�
                if(nursingCount == kohiCount){
                    for (int j = 1; j < 5; j++) {
                        if (nursingList.getDataSize() == 0) break;
                        
                        VRMap nursing = (VRMap) nursingList.get(0);
                        // �T�[�r�X���e��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, nursing, "801034","tokuteimeisai.h" + j + ".w2");
                        // �T�[�r�X�R�[�h��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteiservicecode" + j, ACCastUtilities
                                        .toString(VRBindPathParser.get("801008",
                                                nursing))
                                        + ACCastUtilities.toString(VRBindPathParser
                                                .get("801009", nursing)));

                        //��p�P����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitani" + j, pad(VRBindPathParser.get("801010", nursing), 4));
                        //���S���x�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j, pad0NursingLimit(VRBindPathParser.get("801011", nursing), 4));
                        //������ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitimes" + j, pad(VRBindPathParser.get("801012", nursing), 2));
                        //��p�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyo" + j, pad(VRBindPathParser.get("801016", nursing), 6));
                        //�ی������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihoken" + j, pad(VRBindPathParser.get("801017", nursing), 6));
                        
                        switch(kohiCount){
                        case 0:
                            //���������ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohitimes" + j, pad(VRBindPathParser.get("801013", nursing), 2));
                            //�����p��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohi" + j, pad(VRBindPathParser.get("801018", nursing), 6));
                            break;
                        case 1:
                            //���������ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohitimes" + j, pad(VRBindPathParser.get("801014", nursing), 2));
                            //�����p��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohi" + j, pad(VRBindPathParser.get("801019", nursing), 6));
                            break;
                        case 2:
                            //���������ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohitimes" + j, pad(VRBindPathParser.get("801015", nursing), 2));
                            //�����p��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohi" + j, pad(VRBindPathParser.get("801020", nursing), 6));
                            break;
                        }

                        
                        //���p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha" + j, pad0(VRBindPathParser.get("801021", nursing), 5));
                        
                        nursingList.remove(0);
                    }
                }


                if (i == 0) {
                	if(isDetailListShow(kohiCount)){
	                    //�T�[�r�X�P�ʐ��̍��v��ݒ肷��B(�T�[�r�X�P�ʐ��̍��Z)
	                    ACChotarouXMLUtilities.setValue(writer, "servicetimetotal",pad(String.valueOf(getServiceUnitTotal()),5));
	                    //����ΏےP�ʐ��̍��v��ݒ肷��B(����ΏےP�ʐ��̍��v)
	                    switch(kohiCount){
	                    case 0:
	                        ACChotarouXMLUtilities.setValue(writer, "kohitanitotal", pad(String.valueOf(getKohiTotal1()),5));
	                        //����P�ʐ���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701018"),6));
	                        //������z��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701019"),6));
	                        //����{�l���S�z��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "kohihonnin", pad(typeMap.get("701020"),6));
	                        break;
	                    case 1:
	                        ACChotarouXMLUtilities.setValue(writer, "kohitanitotal", pad(String.valueOf(getKohiTotal2()),5));
	                        //����P�ʐ���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701021"),6));
	                        //������z��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701022"),6));
	                        //����{�l���S�z��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "kohihonnin", pad(typeMap.get("701023"),6));
	                        break;
	                    case 2:
	                        ACChotarouXMLUtilities.setValue(writer, "kohitanitotal", pad(String.valueOf(getKohiTotal3()),5));
	                        //����P�ʐ���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701024"),6));
	                        //������z��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701025"),6));
	                        //����{�l���S�z��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "kohihonnin", pad(typeMap.get("7010246"),6));
	                        break;
	                    }
                    
	                    //���t�P�ʐ���ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "kyufutani", pad(typeMap.get("701014"),6));
	                    
	                    //�P�ʐ��P����ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "tanisutani", getTanka(typeMap.get("701015")));
	                    
	                    //����t����ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201030"),3));
	                    
	                    if(kohiCount == 0){
	                        //�ی����t����ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "hokenkyufu", pad(baseMap.get("201029"),3));
	                        //�ی������z��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(typeMap.get("701016"),6));
	                        //���p�ҕ��S�z��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "riyosyafutan", pad(typeMap.get("701017"),6));
	                    }
                	}
                    
                    if((nursingLast != null) && (nursingCount == kohiCount)){
                        //��p�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyototal",pad(nursingLast.get("801022"),6));
                        
                        //�ی��ҕ��S�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,"tokuteihokentotal", pad(nursingLast.get("801023"),6));
                        //�ی��������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad0(nursingLast.get("801024"),5));
                        
                        switch(kohiCount){
                        case 0:
                            //������v��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal1",pad(nursingLast.get("801025"),6));
                            //��������z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal2",pad(nursingLast.get("801026"),6));
                            //����{�l���S�z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohihonninmonth",pad(nursingLast.get("801027"),5));
                            break;
                        case 1:
                            //������v��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal1",pad(nursingLast.get("801028"),6));
                            //��������z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal2",pad(nursingLast.get("801029"),6));
                            //����{�l���S�z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohihonninmonth",pad(nursingLast.get("801030"),5));
                            break;
                        case 2:
                            //������v��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal1",pad(nursingLast.get("801031"),6));
                            //��������z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitotal2",pad(nursingLast.get("801032"),6));
                            //����{�l���S�z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteikohihonninmonth",pad(nursingLast.get("801033"),5));
                            break;
                        }
                    }

                    //�Е�����
                    if ((reductionList != null) && (reductionList.getDataSize() > 0)) {
                        
                        //�y������ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "keigenritsu",
                                pad(VRBindPathParser.get("901007",(VRMap) reductionList.getData(0)), 4));
                        
                        for (int j = 0; j < reductionList.getDataSize(); j++) {
                            VRMap reduction = (VRMap) reductionList.getData(j);
                            // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - begin �T�[�r�X�R�[�h�p����
//                            switch (ACCastUtilities.toInt(VRBindPathParser.get(
//                                    "901008", reduction))) {
//                            case 51:
//                                //�{�݉��T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
//                                ACChotarouXMLUtilities.setValue(writer, "jyuryo51",pad(reduction.get("901009"),6));
//                                //�{�݉��T�[�r�X��̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
//                                ACChotarouXMLUtilities.setValue(writer, "keigen51", pad(reduction.get("901010"),6));
//                                //�{�݉��T�[�r�X��̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
//                                ACChotarouXMLUtilities.setValue(writer, "keigengo51", pad(reduction.get("901011"),6));
//                                //�{�݉��T�[�r�X��̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��21�̃��R�[�h���Ώ�
//                                ACChotarouXMLUtilities.setValue(writer, "syafuku.h2.w27", pad(reduction.get("901012"),6));
//                                break;
//                            case 54:
//                                //�{�݉��T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
//                                ACChotarouXMLUtilities.setValue(writer, "jyuryo54",pad(reduction.get("901009"),6));
//                                //�{�݉��T�[�r�X��̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
//                                ACChotarouXMLUtilities.setValue(writer, "keigen54", pad(reduction.get("901010"),6));
//                                //�{�݉��T�[�r�X��̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
//                                ACChotarouXMLUtilities.setValue(writer, "keigengo54", pad(reduction.get("901011"),6));
//                                //�{�݉��T�[�r�X��̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��21�̃��R�[�h���Ώ�
//                                ACChotarouXMLUtilities.setValue(writer, "syafuku.h3.w27", pad(reduction.get("901012"),6));
//                                break;
//                            }
                            String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("901008", reduction));
                        	if ("51".equals(serviceCodeKind)) {
								//�{�݉��T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
								ACChotarouXMLUtilities.setValue(writer, "jyuryo51",pad(reduction.get("901009"),6));
								//�{�݉��T�[�r�X��̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
								ACChotarouXMLUtilities.setValue(writer, "keigen51", pad(reduction.get("901010"),6));
								//�{�݉��T�[�r�X��̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
								ACChotarouXMLUtilities.setValue(writer, "keigengo51", pad(reduction.get("901011"),6));
								//�{�݉��T�[�r�X��̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��21�̃��R�[�h���Ώ�
								ACChotarouXMLUtilities.setValue(writer, "syafuku.h2.w27", pad(reduction.get("901012"),6));
                        	}
                        	if ("54".equals(serviceCodeKind)) {
	                            //�{�݉��T�[�r�X��̗��p�ҕ��S�z�̑��z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
	                            ACChotarouXMLUtilities.setValue(writer, "jyuryo54",pad(reduction.get("901009"),6));
	                            //�{�݉��T�[�r�X��̌y���z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
	                            ACChotarouXMLUtilities.setValue(writer, "keigen54", pad(reduction.get("901010"),6));
	                            //�{�݉��T�[�r�X��̌y���㗘�p�ҕ��S�z��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��51�̃��R�[�h���Ώ�
	                            ACChotarouXMLUtilities.setValue(writer, "keigengo54", pad(reduction.get("901011"),6));
	                            //�{�݉��T�[�r�X��̔��l��ݒ肷��B ���T�[�r�X��ރ��R�[�h(901008)��21�̃��R�[�h���Ώ�
	                            ACChotarouXMLUtilities.setValue(writer, "syafuku.h3.w27", pad(reduction.get("901012"),6));
                        	}
                            // [H27.4�����Ή�][Shinobu Hitaka] 2015/1/22 edit - end   �T�[�r�X�R�[�h�p����
                            
                        }
                        

                    }
                }

                //����y�[�W������2���ȏ�̏ꍇ
                //if ((kohiCountTotal * pageCount) > 1) {
                if ((pageCountMax) > 1) {
                    //�o�̓y�[�W���̑�����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((pageCountMax)));
                    //���݂̏o�̓y�[�W����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
                            ACCastUtilities.toString(printPage));
                }
                //�y�[�W�I��
                writer.endPageEdit();

            }
        }

        //��������s�����Ȃ��true��Ԃ��B
        return true;
    }

}
