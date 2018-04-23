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
 * �v���Z�X (�ݑ�T�[�r�X��싋�t��׏��i�a�@�E�f�Ï��ɂ�����Z�������×{���j) (001)
 * �v���O���� (�ݑ�T�[�r�X��싋�t��׏��i�a�@�E�f�Ï��ɂ�����Z�������×{���j) (QP00106)
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
 * (�ݑ�T�[�r�X��싋�t��׏��i�a�@�E�f�Ï��ɂ�����Z�������×{���j)(�l�����) - ���[��`�̃t�@�C���� �F QP001P05X_YYYYMM.xml
 */
public class QP001P05_201804 extends QP001P02_10Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P05_201804() {
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

        // ����f�Ô��񃌃R�[�h
        VRList diagnosisList = getDiagnosisList();
        //���R�[�h�����ԍ��������̃��R�[�h
        VRMap diagnosisLastMap = getLastRecord(diagnosisList,"501007");
        
        // ��������҉��T�[�r�X��p��񃌃R�[�h
        VRList nursingList = getNursingList();
        VRMap diagnosisFirstMap = getNominationRecord(diagnosisList,"501007",1);
        VRMap nursingLast = getLastRecord(nursingList,"801007");

        if (diagnosisFirstMap == null) {
            diagnosisFirstMap = diagnosisLastMap;
        }
        
        
        int pageCountMax = 0;
        int printPage = 1;
        // ��������[�v
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            // ���R�[�h�̕���
            parseStyle();
            // ���׏�񃌃R�[�h�W��
            detailList = getDetailList();
            // ����f�Ô��񃌃R�[�h
            diagnosisList = getDiagnosisList();
            // ��������҉��T�[�r�X��p��񃌃R�[�h
            nursingList = getNursingList();
            
            // ����Ő����Z�o����B�i1�ł�����̖��׏���7���A��������҉��T�[�r�X�����4��)
            // ����������̎󋋂��󂯂Ă���ꍇ�́A�󋋌�����[���o�͂���B
            //��������҂��󎚂��Ȃ��ꍇ������̂ŁA����v�Z����B
            int pageCount = 1;
            int pageTemp = 1;

            // ����Ő����Z�o����B�i1�ł�����̖��׏���8���A����f�Ô����6���A��������҉��T�[�r�X�����4��)
            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 8d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math
                        .ceil((double) diagnosisList.getDataSize() / 6d);
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
            // ���R�[�h�̕���
            parseStyle();
            // ��{��񃌃R�[�h
            baseMap = getBaseMap();
            // ���׏�񃌃R�[�h�W��
            detailList = getDetailList();
            // �W�v��񃌃R�[�h
            typeMap = getTypeMap();

            // ����f�Ô��񃌃R�[�h
            diagnosisList = getDiagnosisList();
            // ��������҉��T�[�r�X��p��񃌃R�[�h
            nursingList = getNursingList();
            
            // ����Ő����Z�o����B�i1�ł�����̖��׏���7���A��������҉��T�[�r�X�����4��)
            // ����������̎󋋂��󂯂Ă���ꍇ�́A�󋋌�����[���o�͂���B
            //��������҂��󎚂��Ȃ��ꍇ������̂ŁA����v�Z����B
            int pageCount = 1;
            int pageTemp = 1;

            // ����Ő����Z�o����B�i1�ł�����̖��׏���8���A����f�Ô����6���A��������҉��T�[�r�X�����4��)
            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 8d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math
                        .ceil((double) diagnosisList.getDataSize() / 6d);
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
                    Date start = ACCastUtilities.toDate(VRBindPathParser.get(
                            "201024", baseMap));
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
                    Date end = ACCastUtilities.toDate(VRBindPathParser.get(
                            "201025", baseMap));
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

                // ���׌��������[�v����B��8���𒴂���ꍇ�́A���y�[�W�Ɉ�
                setDetailList(detailList,9,kohiCount);


                // ����f�Ô�������[�v����B��6���𒴂���ꍇ�́A���y�[�W�Ɉ�
                for (int j = 1; j < 7; j++) {
                    if (diagnosisList.getDataSize() == 0)
                        break;
                    VRMap diagnosis = (VRMap) diagnosisList.get(0);
                    // ���ʔԍ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "shikibetsuno" + j, pad(diagnosis.get("501009"),2));

                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
                            manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),baseMap.get("201003")));

                    // �P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotani" + j, pad(diagnosis.get("501010"),4));
                    // �񐔂�ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotimes" + j, pad(diagnosis.get("501011"),2));
                    // �ی����P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentani" + j, pad(diagnosis.get("501012"),5) );
                    
                    switch(kohiCount){
                    case 0:
                        // ����񐔂�ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501014"),2));
                        // ����P�ʐ���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501015"),5));
                        break;
                    case 1:
                        // ����񐔂�ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501017"),2));
                        // ����P�ʐ���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501018"),5));
                        break;
                    case 2:
                        // ����񐔂�ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501020"),2));
                        // ����P�ʐ���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501021"),5));
                        break;
                    }
                    
                    // �E�v��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, diagnosis,
                            "501023", "tokuteishinryo.h" + j + ".tekiyo");
                    
                    diagnosisList.remove(0);
                }

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

                //�p�����ꖇ�߂̏ꍇ
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

                    // ����f�Ô��񃌃R�[�h�����ԍ���01�̃��R�[�h�̏��a����ݒ肷��B
                    // 01�̃��R�[�h���Ȃ��ꍇ��99�̃��R�[�h�̒l���̗p����B
                    ACChotarouXMLUtilities.setValue(writer, diagnosisFirstMap, "501008", "tokuteishinryo.syoubyo.w4");
                    
                    if(diagnosisLastMap != null){ 
                        //����f�Ô�̕ی����P�ʐ��̍��v��ݒ肷��B ������f�Ô��񃌃R�[�h�����ԍ���99�̒l���̗p����B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentanitotal", pad(diagnosisLastMap.get("501013"),5));
                    }
                    
                    //�ی���
                    //�v��P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "plantani", pad(typeMap.get("701009"),6));
                    //���x�z�Ǘ��ΏےP�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "limitin", pad(typeMap.get("701010"),6));
                    //���x�z�Ǘ��ΏۊO�P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "limitout", pad(typeMap.get("701011"),6));
                    
                    //���t�P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "kyufutani", pad(typeMap.get("701014"),6));
                    //�P�ʐ��P����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "tanisutani", getTanka(typeMap.get("701015")));
                    
                    if(kohiCount == 0){
                        //�ی����t����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenkyufu", pad(baseMap.get("201029"),3));
                        //�ی������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(typeMap.get("701016"),6));
                        // ���p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenriyousyafutan", pad(typeMap.get("701017"),6));
                    }
                    
                    
                    //���
                    switch(kohiCount){
                    case 0:
                        if(ACCastUtilities.toInt(typeMap.get("701018"),0) != 0){
                            //����P�ʐ���ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701018"),6));
                            //����t����ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201030"),3));
                            //������z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701019"),6));
                            // ���p�ҕ��S�z�i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701020"),6));
                        }
                        break;
                    case 1:
                        if(ACCastUtilities.toInt(typeMap.get("701021"),0) != 0){
                            //����P�ʐ���ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701021"),6));
                            //����t����ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201031"),3));
                            //������z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701022"),6));
                            // ���p�ҕ��S�z�i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701023"),6));
                        }
                        break;
                    case 2:
                        if(ACCastUtilities.toInt(typeMap.get("701024"),0) != 0){
                            //����P�ʐ���ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohibuntani", pad(typeMap.get("701024"),6));
                            //����t����ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201032"),3));
                            //������z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701025"),6));
                            // ���p�ҕ��S�z�i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701026"),6));
                        }
                        break;
                    }

                    
                    //�ی�������f�Ô�
                    
                    //�������f�Ô�
                    if(diagnosisLastMap != null){
                        //�ی�������f�Ô�̋��t�P�ʐ���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokentokuteikyufutani", pad(diagnosisLastMap.get("501013"),6));
                        
                        if(kohiCount == 0){
                            //�ی����t����ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteikyufu", pad(baseMap.get("201029"),3));
                            //�����z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteiseikyu", pad(baseMap.get("201037"),6));
                            //���p�ҕ��S�z
                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteiriyousyafutan", pad(typeMap.get("701029"),6));
                        }
                        
                        switch(kohiCount){
                        case 0:
                            //����f�Ô�̌���P�ʐ��̍��v��ݒ肷��B�@������f�Ô��񃌃R�[�h�����ԍ���99�̒l���̗p����B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501016"),5));
                            //�������f�Ô�̋��t�P�ʐ���ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufutani", pad(diagnosisLastMap.get("501016"),6));
                            //����t����ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufu", pad(baseMap.get("201030"),3));
                            //������z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701031"),6));
                            //���p�ҕ��S�z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyafutan", pad(typeMap.get("701032"),6));
                            break;
                        case 1:
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501019"),5));
                            //�������f�Ô�̋��t�P�ʐ���ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufutani", pad(diagnosisLastMap.get("501019"),6));
                            //����t����ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufu", pad(baseMap.get("201031"),3));
                            //������z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701034"),6));
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyafutan", pad(typeMap.get("701035"),6));
                            break;
                        case 2:
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501022"),5));
                            //�������f�Ô�̋��t�P�ʐ���ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufutani", pad(diagnosisLastMap.get("501022"),6));
                            //����t����ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufu", pad(baseMap.get("201032"),3));
                            //������z��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701037"),6));
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyafutan", pad(typeMap.get("701038"),6));
                            break;
                        }

                    }
                    
                    if((nursingLast != null) && (0 == kohiCount)){
                        //��p�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyototal",pad(nursingLast.get("801022"),6));
                        //�ی��ҕ��S�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,"tokuteihokentotal", pad(nursingLast.get("801023"),6));
                        //�ی��������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad0(nursingLast.get("801024"),5));
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
