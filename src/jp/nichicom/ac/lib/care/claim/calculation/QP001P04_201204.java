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
 * �v���Z�X �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j (001)
 * �v���O���� �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j (QP00105)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j(�l����l) - ���[��`�̃t�@�C���� �F QP001P04X_YYYYMM.xml
 */
public class QP001P04_201204 extends QP001P02_10Event {

    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P04_201204() {
    }

    /**
     * H20.5�ȍ~�̒��[���C�A�E�g�ɑΉ�����������\�b�h
     * @param printParam
     * @return
     * @throws Exception
     */
    public boolean doPrintImpl(VRMap printParam) throws Exception {

        // ��{��񃌃R�[�h
        VRMap baseMap = getBaseMap();
        // ���׏�񃌃R�[�h�W��
        VRList detailList = getDetailList();
        // �W�v��񃌃R�[�h
        VRMap typeMap = getTypeMap();

        // �ً}���{�ݗ×{��񃌃R�[�h
        VRMap emergencyMap = getemErgencyMap();
        // ��������҉��T�[�r�X��p��񃌃R�[�h
        VRList nursingList = getNursingList();

        VRMap nursingLast = getLastRecord(nursingList, "801007");
        
        VRList diagnosisList = getDiagnosisList();
        //���R�[�h�����ԍ��������̃��R�[�h
        VRMap diagnosisLastMap = getLastRecord(diagnosisList,"501007");
        VRMap diagnosisFirstMap = getNominationRecord(diagnosisList,"501007",1);
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
            // ��������҉��T�[�r�X��p��񃌃R�[�h
            nursingList = getNursingList();
            // ����f�Ô��񃌃R�[�h
            diagnosisList = getDiagnosisList();

            // ����Ő����Z�o����B�i1�ł�����̖��׏���4���A��������҉��T�[�r�X�����2���A���ʎ��Ô��2��)
            // ����������̎󋋂��󂯂Ă���ꍇ�́A�󋋌�����[���o�͂���B
            // ��������҂��󎚂��Ȃ��ꍇ������̂ŁA����v�Z����B
            int pageCount = 1;
            int pageTemp = 1;

            //���׏�񃌃R�[�h����
            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 4d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            //��������҉��T�[�r�X���񃌃R�[�h����
            if ((nursingList.getDataSize() > 0) && (0 == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            //����f�Ô�E���Ô��񃌃R�[�h����
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) diagnosisList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
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

            // �ً}���{�ݗ×{��񃌃R�[�h
            emergencyMap = getemErgencyMap();
            // ��������҉��T�[�r�X��p��񃌃R�[�h
            nursingList = getNursingList();
            // ����f�Ô��񃌃R�[�h
            diagnosisList = getDiagnosisList();

            // ����Ő����Z�o����B�i1�ł�����̖��׏���7���A��������҉��T�[�r�X�����4��)
            // ����������̎󋋂��󂯂Ă���ꍇ�́A�󋋌�����[���o�͂���B
            // ��������҂��󎚂��Ȃ��ꍇ������̂ŁA����v�Z����B
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 4d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            if ((nursingList.getDataSize() > 0) && (0 == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            //����f�Ô�E���Ô��񃌃R�[�h����
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) diagnosisList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
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
                    Date start = ACCastUtilities.toDate(VRBindPathParser.get("201024", baseMap));
                    // �����N�����̘a���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer,"nyusyodate.h2.w11", eraFormat.format(start));
                    // �����N�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��
                    ACChotarouXMLUtilities.setValue(writer, "nyusyoyear",eraYearFormat.format(start));
                    // �����N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "nyusyomonth",monthFormat.format(start));
                    // �����N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "nyusyoday",dayFormat.format(start));
                }

                // �ޏ��N�����̐ݒ�
                if (QP001Util.isDate(baseMap.get("201025"))) {
                    Date end = ACCastUtilities.toDate(VRBindPathParser.get("201025", baseMap));
                    // �ޏ��N�����̘a���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer,"taisyodate.h2.w11", eraFormat.format(end));
                    // �ޏ��N�����̔N(YY�t�H�[�}�b�g)��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "taisyoyear",eraYearFormat.format(end));
                    // �ޏ��N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "taisyomonth",monthFormat.format(end));
                    // �ޏ��N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "taisyoday",dayFormat.format(end));

                }
                // �Z�������̎�������ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "tankijitsu", pad(typeMap.get("701013"), 2));

                // ���׌��������[�v����B��7���𒴂���ꍇ�́A���y�[�W�Ɉ�
                setDetailList(detailList, 5, kohiCount);

                // ����×{��������[�v����B��2���𒴂���ꍇ�́A���y�[�W�Ɉ�
                for (int j = 1; j < 3; j++) {
                    if (diagnosisList.getDataSize() == 0){
                        break;
                    }
                    VRMap diagnosis = (VRMap) diagnosisList.get(0);
                    // ���ʔԍ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "shikibetsuno" + j, pad(diagnosis.get("501009"),2));
                    // ���e��ݒ肷��B������f�Ô�}�X�^(M_SPECIAL_CLINIC)��SPECIAL_CLINIC_TYPE�ƌ������ASPECIAL_CLINIC_NAME��\���B
                    //[ID:0000454][Shin Fujihara] 2009/05/01 edit begin ��Q�Ή�
                    /*
                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
                            manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),2));
                    */
                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
                            manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),2,baseMap.get("201003")));
                    //[ID:0000454][Shin Fujihara] 2009/05/01 edit end ��Q�Ή�
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
                
                // ��������҉��T�[�r�X���������[�v����B��2���𒴂���ꍇ�́A���y�[�W�Ɉ�
                if (0 == kohiCount) {
                    for (int j = 1; j < 3; j++) {
                        if (nursingList.getDataSize() == 0)
                            break;
                        VRMap nursing = (VRMap) nursingList.get(0);
                        // �T�[�r�X���e��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, nursing,
                                "801034", "tokuteimeisai.h" + j + ".w2");
                        // �T�[�r�X�R�[�h��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteiservicecode" + j, ACCastUtilities
                                        .toString(VRBindPathParser.get(
                                                "801008", nursing))
                                        + ACCastUtilities
                                                .toString(VRBindPathParser.get(
                                                        "801009", nursing)));

                        // ��p�P����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitani"
                                + j, pad(VRBindPathParser
                                .get("801010", nursing), 4));
                        // ���S���x�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "dokuteilimit"
                        		//[ID:0000651][Shin Fujihara] 2011/07/06 add begin ���S���x�z0�~�\���Ή�
                                //+ j, pad(VRBindPathParser
                        		+ j, pad0NursingLimit(VRBindPathParser
                        		//[ID:0000651][Shin Fujihara] 2011/07/06 add end ���S���x�z0�~�\���Ή�
                                .get("801011", nursing), 4));
                        // ������ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitimes"
                                + j, pad(VRBindPathParser
                                .get("801012", nursing), 2));
                        // ��p�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyo"
                                + j, pad(VRBindPathParser
                                .get("801016", nursing), 6));
                        // �ی������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihoken"
                                + j, pad(VRBindPathParser
                                .get("801017", nursing), 6));
                        // ���p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                        		//[ID:0000449][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                                //"tokuteiriyosha" + j, pad(VRBindPathParser.get(
                        		"tokuteiriyosha" + j, pad0(VRBindPathParser.get(
                                //[ID:0000449][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
                                        "801021", nursing), 5));

                        nursingList.remove(0);
                    }
                }

                // 1�y�[�W�ڂ݈̂󎚂���
                if (i == 0) {
                    // �T�[�r�X�P�ʐ����v��ݒ肷��B ���T�[�r�X�P�ʐ��̍��Z��ݒ�B
                    // setValue(servicetimetotal);
                    ACChotarouXMLUtilities.setValue(writer, "servicetimetotal",
                            pad(String.valueOf(getServiceUnitTotal()), 5));
                    // ����ΏےP�ʐ����v��ݒ肷��B ������ΏےP�ʐ��̍��Z��ݒ�B
                    switch (kohiCount) {
                    case 0:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String
                                        .valueOf(getKohiTotal1()), 5));
                        break;
                    case 1:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String
                                        .valueOf(getKohiTotal2()), 5));
                        break;
                    case 2:
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohitanitotal", pad(String
                                        .valueOf(getKohiTotal3()), 5));
                        break;
                    }

                    /* ============================================================================= */
                    /* �ً}���{�ݗ×{�� */
                    /* ============================================================================= */
                    if(emergencyMap != null){
	                    // �ً}�����a���P��ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, emergencyMap,
	                            "401008", "emergency.s1.syoubyo");
	                    // �ً}�����a���Q��ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, emergencyMap,
	                            "401009", "emergency.s2.syoubyo");
	                    // �ً}�����a���R��ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, emergencyMap,
	                            "401010", "emergency.s3.syoubyo");
	
	                    // �ً}�����ÊJ�n�J�n�N�����P
	                    if (QP001Util.isDate(VRBindPathParser.get("401011",
	                            emergencyMap))) {
	                        Date start = ACCastUtilities.toDate(VRBindPathParser
	                                .get("401011", emergencyMap));
	                        // �ً}�����ÊJ�n�N�����P�̘a���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergency.s1.emergencydate", eraFormat
	                                        .format(start));
	                        // �ً}�����ÊJ�n�N�����P�̘a��N��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyyear1", eraYearFormat.format(start));
	                        // �ً}�����ÊJ�n�N�����P�̌���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencymonth1", monthFormat.format(start));
	                        // �ً}�����ÊJ�n�N�����P�̓���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyday1", dayFormat.format(start));
	                    }
	
	                    // �ً}�����ÊJ�n�N�����Q
	                    if (QP001Util.isDate(VRBindPathParser.get("401012",
	                            emergencyMap))) {
	                        Date start = ACCastUtilities.toDate(VRBindPathParser
	                                .get("401012", emergencyMap));
	                        // �ً}�����ÊJ�n�N�����Q�̘a���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergency.s2.emergencydate", eraFormat
	                                        .format(start));
	                        // �ً}�����ÊJ�n�N�����Q�̘a��N��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyyear2", eraYearFormat.format(start));
	                        // �ً}�����ÊJ�n�N�����Q�̌���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencymonth2", monthFormat.format(start));
	                        // �ً}�����ÊJ�n�N�����Q�̓���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyday2", dayFormat.format(start));
	                    }
	
	                    // �ً}�����ÊJ�n�N�����R
	                    if (QP001Util.isDate(VRBindPathParser.get("401013",
	                            emergencyMap))) {
	                        Date start = ACCastUtilities.toDate(VRBindPathParser
	                                .get("401013", emergencyMap));
	                        // �ً}�����ÊJ�n�N�����R�̘a���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergency.s3.emergencydate", eraFormat
	                                        .format(start));
	                        // �ً}�����ÊJ�n�N�����R�̘a��N��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyyear3", eraYearFormat.format(start));
	                        // �ً}�����ÊJ�n�N�����R�̌���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencymonth3", monthFormat.format(start));
	                        // �ً}�����ÊJ�n�N�����R�̓���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer,
	                                "emergencyday3", dayFormat.format(start));
	                    }
	
	                    // �ً}�����ÊǗ�(�Čf)��ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h8.w4",
	                            pad(emergencyMap.get("401020"), 0));
	                    // �ً}�����ÊǗ��P�ʐ���ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h8.w10",
	                            pad(emergencyMap.get("401018"), 0));
	                    // �ً}�����ÊǗ�������ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "tani", pad(
	                            emergencyMap.get("401019"), 2));
	
	                    // ���n�r���e�[�V�����_����ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h7.w4",
	                            pad(emergencyMap.get("401021"), 0));
	                    // ���u�_����ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h6.w4",
	                            pad(emergencyMap.get("401022"), 0));
	                    // ��p�_����ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h5.w4",
	                            pad(emergencyMap.get("401023"), 0));
	                    // �����_����ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h4.w4",
	                            pad(emergencyMap.get("401024"), 0));
	                    // ���ː����Ó_����ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h3.w4",
	                            pad(emergencyMap.get("401025"), 0));
	                    // ���v��ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h1.w4",
	                            pad(emergencyMap.get("401046"), 0));
	
	                    // �E�v��ݒ肷��B���E�v�P�`�E�v�Q�O�܂ł��u�^�v�ŘA�����A�o�́B
	                    StringBuilder tekiyo = new StringBuilder();
	                    for (int j = 401026; j < 401046; j++) {
	                        if (!ACTextUtilities.isNullText(VRBindPathParser.get(
	                                ACCastUtilities.toString(j), emergencyMap))) {
	                            tekiyo.append(VRBindPathParser.get(ACCastUtilities
	                                    .toString(j), emergencyMap));
	                            tekiyo.append("�^");
	                        }
	                    }
	                    if (tekiyo.length() > 0) {
	                        tekiyo.deleteCharAt(tekiyo.length() - 1);
	                    }
	                    ACChotarouXMLUtilities.setValue(writer, "emergency.h6.w10",
	                            tekiyo.toString());
	                    // ���f������ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "oushintimes", pad(
	                            emergencyMap.get("401014"), 2));
	                    // ���f��Ë@�֖���ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, emergencyMap,
	                            "401015", "emergency.h2.w3");
	                    // �ʉ@������ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "tuuintimes", pad(
	                            emergencyMap.get("401016"), 2));
	                    // �ʉ@��Ë@�ւ�ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, emergencyMap,
	                            "401017", "emergency.h2.w16");
	                
                    }

                    // ����f�Ô��񃌃R�[�h�����ԍ���01�̃��R�[�h�̏��a����ݒ肷��B
                    // 01�̃��R�[�h���Ȃ��ꍇ��99�̃��R�[�h�̒l���̗p����B
                    ACChotarouXMLUtilities.setValue(writer, diagnosisFirstMap, "501008", "tokuteishinryo.syoubyo.w4");
                    
                    if(diagnosisLastMap != null){ 
                        //����f�Ô�̕ی����P�ʐ��̍��v��ݒ肷��B ������f�Ô��񃌃R�[�h�����ԍ���99�̒l���̗p����B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentanitotal", pad(diagnosisLastMap.get("501013"),5));
                        
                        switch(kohiCount){
                        case 0:
                            //����f�Ô�̌���P�ʐ��̍��v��ݒ肷��B�@������f�Ô��񃌃R�[�h�����ԍ���99�̒l���̗p����B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501016"),5));
                            break;
                        case 1:
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501019"),5));
                            break;
                        case 2:
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501022"),5));
                            break;
                        }
                    }
                    
                    /* ============================================================================= */
                    /* �����z�W�v�� */
                    /* ============================================================================= */

                    // �ی���
                    // �v��P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "plantani", pad(
                            typeMap.get("701009"), 6));
                    // ���x�z�Ǘ��ΏےP�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "limitin", pad(
                            typeMap.get("701010"), 6));
                    // ���x�z�Ǘ��ΏۊO�P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "limitout", pad(
                            typeMap.get("701011"), 6));
                    // ���t�_���E�P�ʐ��i�ی����j��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "hokentani", pad(
                            typeMap.get("701014"), 6));
                    // �_���E�P�ʐ��P����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "tanka",
                            getTanka(typeMap.get("701015")));

                    if (kohiCount == 0) {
                        // ���t���i�ی����j��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenkyuhu",
                                pad(baseMap.get("201029"), 3));
                        // �ی������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu",
                                pad(typeMap.get("701016"), 6));
                        // �ی����p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "hokenriyosyafutan", pad(typeMap.get("701017"),
                                        6));
                    }

                    // ���
                    switch (kohiCount) {
                    case 0:
                        // ����T�[�r�X�P�ʐ�
                        ACChotarouXMLUtilities.setValue(writer, "kohitani",
                                pad(typeMap.get("701018"), 6));
                        // ���t�_���E�P�ʐ��i����j��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu",
                                pad(baseMap.get("201030"), 3));
                        // ������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu",
                                pad(typeMap.get("701019"), 6));
                        // ����p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohiriyosyafutan", pad(typeMap.get("701020"),
                                        6));
                        break;
                    case 1:
                        // ����T�[�r�X�P�ʐ�
                        ACChotarouXMLUtilities.setValue(writer, "kohitani",
                                pad(typeMap.get("701021"), 6));
                        // ���t�_���E�P�ʐ��i����j��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu",
                                pad(baseMap.get("201031"), 3));
                        // ������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu",
                                pad(typeMap.get("701022"), 6));
                        // ����p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohiriyosyafutan", pad(typeMap.get("701023"),
                                        6));
                        break;
                    case 2:
                        //����T�[�r�X�P�ʐ�
                        ACChotarouXMLUtilities.setValue(writer, "kohitani",
                                pad(typeMap.get("701024"), 6));
                        //���t�_���E�P�ʐ��i����j��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu",
                                pad(baseMap.get("201032"), 3));
                        //������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu",
                                pad(typeMap.get("701025"), 6));
                        //����p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohiriyosyafutan", pad(typeMap.get("201053"),
                                        6));
                        break;
                    }

                    //�����z�W�v�� �ی������莡��====================================
                    if (ACCastUtilities.toInt(typeMap.get("701027"), 0) != 0) {
                        // ���t�_���E�P�ʐ��i�ی������莡�Áj��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "hokentokuteitani", pad(typeMap.get("701027"),
                                        6));

                        if (kohiCount == 0) {
                            // ���t���i�ی����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "hokentokuteikyuhu", pad(baseMap
                                            .get("201029"), 3));
                            // �����z�i�ی������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "hokentokuteiseikyu", pad(typeMap
                                            .get("701028"), 6));
                            // �{�l���S�z�i�ی������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "hokentokuteiriyousyahutan", pad(typeMap
                                            .get("701029"), 6));
                        }
                    }

                    //�����z�W�v�� ������莡��====================================
                    switch (kohiCount) {
                    case 0:
                        if (ACCastUtilities.toInt(typeMap.get("701030"), 0) != 0) {
                            // ���t�_���E�P�ʐ��i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteitani", pad(typeMap
                                            .get("701030"), 6));
                            //���t���i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteikyuhu", pad(baseMap
                                            .get("201030"), 3));
                            // �����z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiseikyu", pad(typeMap
                                            .get("701031"), 6));
                            // ���p�ҕ��S�z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiriyousyahutan", pad(typeMap
                                            .get("701032"), 6));
                        }
                        break;
                    case 1:
                        if (ACCastUtilities.toInt(typeMap.get("701033"), 0) != 0) {
                            // ���t�_���E�P�ʐ��i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteitani", pad(typeMap
                                            .get("701033"), 6));
                            //���t���i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteikyuhu", pad(baseMap
                                            .get("201031"), 3));
                            // �����z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiseikyu", pad(typeMap
                                            .get("701034"), 6));
                            // ���p�ҕ��S�z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiriyousyahutan", pad(typeMap
                                            .get("701035"), 6));
                        }
                        break;
                    case 2:
                        if (ACCastUtilities.toInt(typeMap.get("701033"), 0) != 0) {
                            // ���t�_���E�P�ʐ��i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteitani", pad(typeMap
                                            .get("701036"), 6));
                            //���t���i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteikyuhu", pad(baseMap
                                            .get("201032"), 3));
                            // �����z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiseikyu", pad(typeMap
                                            .get("701037"), 6));
                            // ���p�ҕ��S�z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer,
                                    "kohitokuteiriyousyahutan", pad(typeMap
                                            .get("701038"), 6));
                        }
                        break;
                    }

                    //��������҂̍��v��ݒ肷��B
                    if ((nursingLast != null) && (0 == kohiCount)) {
                        //��p�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteihiyototal", pad(nursingLast
                                        .get("801022"), 6));
                        //�ی��ҕ��S�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteihokentotal", pad(nursingLast
                                        .get("801023"), 6));
                        //�ی��������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                        		//[ID:0000449][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                                //"tokuteiriyoshatotal", pad(nursingLast
                        		"tokuteiriyoshatotal", pad0(nursingLast
                        		//[ID:0000449][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
                                        .get("801024"), 5));
                    }
                    
                    
                    
                    //�ی�������f�Ô�
                    
                    
                }
                

                //����y�[�W������2���ȏ�̏ꍇ
                //if ((kohiCountTotal * pageCount) > 1) {
                if ((pageCountMax) > 1) {
                    //�o�̓y�[�W���̑�����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities
                                    .toString((pageCountMax)));
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
    //[H20.5 �@�����Ή�] fujihara add end


}
