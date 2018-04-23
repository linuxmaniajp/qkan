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
 * �v���O���� �ݑ�T�[�r�X��싋�t��׏��i�Z�������������j (QP00104)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �ݑ�T�[�r�X��싋�t��׏��i�Z�������������j(�l����O) -  ���[��`�̃t�@�C���� �F QP001P03X_YYYYYMM.xml
 */
public class QP001P03_201804 extends QP001P02_10Event {

    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P03_201804() {
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
        VRMap typeMap = getTypeMap();
        // ��������҉��T�[�r�X��񃌃R�[�h
        VRList nursingList = getNursingList();
        
        VRMap nursingLast = getLastRecord(nursingList,"801007");
        
        // �Е����ƃ��R�[�h
        VRMap reductionMap = getReductionMap();

        // ����p���i�[�p��VRArrayList printArray���`����B
        // printArray�ɁA�n��p�����[�^�� KEY : PARAM �� VALUE ��ݒ肷��B
        // ���ȉ��AprintArray�Ɋi�[����Ă��郌�R�[�h���Q�Ƃ���B
        // ����������̎󋋂��󂯂Ă���ꍇ�́A�󋋌�����[���o�͂���B
        
        // ����Ő����Z�o����B�i1�ł�����̖��׏���10���A��������҉��T�[�r�X�����4��)
        // ��������҂��󎚂��Ȃ��ꍇ������̂ŁA����v�Z����B
        int pageCountMax = 0;
        int printPage = 1;
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            parseStyle();
            // ���׏�񃌃R�[�h�W��
            detailList = getDetailList();
            // ��������҉��T�[�r�X��񃌃R�[�h
            nursingList = getNursingList();
            
            int pageTemp = 1;
            int pageCount = 1;
            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 10d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (0 == kohiCount)) {
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
            reductionMap = getReductionMap();
            
            
            // ����Ő����Z�o����B�i1�ł�����̖��׏���10���A��������҉��T�[�r�X�����4��)
            // ��������҂��󎚂��Ȃ��ꍇ������̂ŁA����v�Z����B
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 10d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (0 == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 4d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }

            // ������[�v
            for (int i = 0; i < pageCount; i++,printPage++) {
                // �y�[�W�J�n
                writer.beginPageEdit(getFormatId());

                // ���[���ʏ���ݒ�
                setPrintHeader(kohiCount);

                // ����T�[�r�X�󋵂�ݒ�
                setKyotakuData();

                // �����N�����̐ݒ�
                if (QP001Util.isDate(baseMap.get("201024"))) {
                    Date start = ACCastUtilities.toDate(baseMap.get("201024"));
                    // �����N�����̘a���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer,
                            "nyusyodate.h2.w11", eraFormat.format(start));
                    // �����N�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��
                    ACChotarouXMLUtilities.setValue(writer, "nyusyoyear",
                            eraYearFormat.format(start));
                    // �����N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "nyusyomonth",
                            monthFormat.format(start));
                    // �����N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "nyusyoday",
                            dayFormat.format(start));
                }

                // �ޏ��N�����̐ݒ�
                if (QP001Util.isDate(baseMap.get("201025"))) {
                    Date end = ACCastUtilities.toDate(baseMap.get("201025"));
                    // �ޏ��N�����̘a���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer,
                            "taisyodate.h2.w11", eraFormat.format(end));
                    // �ޏ��N�����̔N(YY�t�H�[�}�b�g)��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "taisyoyear",
                            eraYearFormat.format(end));
                    // �ޏ��N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "taisyomonth",
                            monthFormat.format(end));
                    // �ޏ��N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "taisyoday", dayFormat
                            .format(end));

                }
                // �Z�������̎�������ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "tankijitsu", pad(typeMap.get("701013"), 2));

                //���׌��������[�v����B��10���𒴂���ꍇ�́A���y�[�W�Ɉ�
                setDetailList(detailList,11,kohiCount);

                
                // ��������҉��T�[�r�X���������[�v����B��4���𒴂���ꍇ�́A���y�[�W�Ɉ�
                if(0 == kohiCount){
                    for (int j = 1; j < 5; j++) {
                        if (nursingList.getDataSize() == 0)
                            break;
                        VRMap nursing = (VRMap) nursingList.get(0);
                        // �T�[�r�X���e��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, nursing, "801034",
                                "tokuteimeisai.h" + j + ".w2");
                        // �T�[�r�X�R�[�h��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteiservicecode" + j, ACCastUtilities
                                        .toString(VRBindPathParser.get("801008",
                                                nursing))
                                        + ACCastUtilities.toString(VRBindPathParser
                                                .get("801009", nursing)));

                        // ��p�P����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitani" + j,
                                pad(VRBindPathParser.get("801010", nursing), 4));
                        // ���S���x�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j,
                        		pad0NursingLimit(VRBindPathParser.get("801011", nursing), 4));
                        // ������ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitimes" + j,
                                pad(VRBindPathParser.get("801012", nursing), 2));
                        // ��p�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyo" + j,
                                pad(VRBindPathParser.get("801016", nursing), 6));
                        // �ی������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihoken" + j,
                                pad(VRBindPathParser.get("801017", nursing), 6));
                        // ���p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha"
                                + j,
                                pad0(VRBindPathParser.get("801021", nursing), 5));

                        nursingList.remove(0);
                    }
                }

                // �p�����ꖇ�߂̏ꍇ
                if (i == 0) {
                    
                    // �T�[�r�X�P�ʐ��̍��v��ݒ肷��B(�T�[�r�X�P�ʐ��̍��Z)
                    ACChotarouXMLUtilities.setValue(writer, "servicetimetotal",
                            pad(String.valueOf(getServiceUnitTotal()), 5));
                    // ����ΏےP�ʐ��̍��v��ݒ肷��B(����ΏےP�ʐ��̍��v)
                    switch (kohiCount) {
                    case 0:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String.valueOf(getKohiTotal1()), 5));
                        break;
                    case 1:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String.valueOf(getKohiTotal2()), 5));
                        break;
                    case 2:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String.valueOf(getKohiTotal3()), 5));
                        break;
                    }

                    // �v��P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "plantani", pad(
                            typeMap.get("701009"), 6));

                    // ���x�z�Ǘ��ΏےP�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "limitin", pad(
                            typeMap.get("701010"), 6));
                    // ���x�z�Ǘ��ΏۊO�P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "limitout", pad(
                            typeMap.get("701011"), 6));
                    // ���t�P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "kyufutani", pad(
                            typeMap.get("701014"), 6));

                    // �P�ʐ��P����ݒ肷��B
                    // getTanka(VRBindPathParser.get("701015",type)
                    ACChotarouXMLUtilities.setValue(writer, "tanisutani",
                            getTanka(typeMap.get("701015")));
                    
                    if(kohiCount == 0){
                        // �ی����t����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenkyufu", pad(
                                baseMap.get("201029"), 3));
                        // �ی������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(
                                typeMap.get("701016"), 6));
                        // ���p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "riyosyafutan",
                                pad(typeMap.get("701017"), 6));
                    }


                    // ����Ԃɂ�蕪��
                    switch (kohiCount) {
                    // ����1
                    case 0:
                        //����P�ʐ���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani",
                                pad(typeMap.get("701018"), 6));
                        //����t����ݒ肷��B
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201030",
                                                baseMap), 3));
                        //������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201040", baseMap), 6));
                        //����{�l���S�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201041", baseMap), 6));
                        break;
                    //����2
                    case 1:
                        //����P�ʐ���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani",
                                pad(typeMap.get("701021"), 6));
                        //����t����ݒ肷��B
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201031",
                                                baseMap), 3));
                        //������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201046", baseMap), 6));
                        //����{�l���S�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201047", baseMap), 6));
                        break;
                    //����3
                    case 2:
                        //����P�ʐ���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohibuntani",
                                pad(typeMap.get("701024"), 6));
                        //����t����ݒ肷��B
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201032",
                                                baseMap), 3));
                        //������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201052", baseMap), 6));
                        //����{�l���S�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201053", baseMap), 6));
                        break;
                    }
                    
                    if((nursingLast != null) && (0 == kohiCount)){
                        //��p�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyototal",pad(nursingLast.get("801022"),6));
                        //�ی��ҕ��S�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,"tokuteihokentotal", pad(nursingLast.get("801023"),6));
                        //�ی��������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad0(nursingLast.get("801024"),5));
                    }

                    //�Е����Ƃ̏���ݒ肷��B
                    doPrintReductionList(reductionMap);
                }
                //����y�[�W������2���ȏ�̏ꍇ
                if(pageCountMax > 1){
                    //�o�̓y�[�W���̑�����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((pageCountMax)));
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
    /**
     * �l����l�Ɨl����l�̓�̍�����⊮����
     * @param printParam
     * @param reductionList
     * @throws Exception
     */
    public void doPrintReductionList(VRMap reductionMap) throws Exception{
        
    }

    public void addFormat() throws Exception {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        
    }

    public String getFormatId() throws Exception {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return null;
    }
}
