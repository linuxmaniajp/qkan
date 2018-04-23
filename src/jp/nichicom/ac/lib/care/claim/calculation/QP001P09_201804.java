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
 * �v���Z�X �{�݃T�[�r�X����싋�t��׏��i���V�l�ی��{�݁j (001)
 * �v���O���� �{�݃T�[�r�X����싋�t��׏��i���V�l�ی��{�݁j (QP001P10)
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
 * �{�݃T�[�r�X����싋�t��׏��i���V�l�ی��{�݁E����É@�j(�l�����) -�l����� ���[��`�̃t�@�C���� �F QP001P09X_YYYYMM.xml
 */
public abstract class QP001P09_201804 extends QP001P02_10Event {
    
	/* 
	 * �l����� 201804�ȍ~
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
    public QP001P09_201804() {
    }

//    public void addFormat() throws Exception {
//        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P091_201804.xml");
//    }
//
//    public String getFormatId() throws Exception {
//        return "QP001P091_201804";
//    }   
    
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
        // ��{�E�v��񃌃R�[�h
        VRList baseSummaryList = getBaseSummaryList(); //[H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add
        // ���׏�񃌃R�[�h�W��
        VRList detailList = getDetailList();
        // �W�v��񃌃R�[�h
        VRMap typeMap = getTypeMap();

        // �ً}���{�ݗ×{�E���{�ݗ×{���񃌃R�[�h
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - begin
//        VRMap emergencyOwnFacilityMap = getemErgencyOwnFacilityMap();
        VRMap emergencyOwnFacilityMap = getEmergencyInfo();
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - end
        
        // ��������҉��T�[�r�X��p��񃌃R�[�h
        VRList nursingList = getNursingList();
        
        //���ʗ×{���񃌃R�[�h
        VRList diagnosisList = getDiagnosisList();
        //���R�[�h�����ԍ��������̃��R�[�h
        VRMap diagnosisLastMap = getLastRecord(diagnosisList,"501007");
        VRMap diagnosisFirstMap = getNominationRecord(diagnosisList,"501007",1);
        if (diagnosisFirstMap == null) {
            diagnosisFirstMap = diagnosisLastMap;
        }
        
        //[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        int detailsRecordCount = 5;
        if (QP001Util.TERM_200904_AFFTER <= getTerm()){
            detailsRecordCount = 4;
        }
        //[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
        
        VRMap nursingLast = getLastRecord(nursingList,"801007");
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
            //���ʗ×{���񃌃R�[�h
            diagnosisList = getDiagnosisList();
            
            // ����Ő����Z�o����B�i1�ł�����̖��׏���8���A��������҉��T�[�r�X�����4��)
            // ��������҂��󎚂��Ȃ��ꍇ������̂ŁA����v�Z����B
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
                
                //[ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                //pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 5d);
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / (double)detailsRecordCount);
                //[ID:0000447][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
                
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 2d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) diagnosisList.getDataSize() / 2d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            //[H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - begin
            if (baseSummaryList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) baseSummaryList.getDataSize() / 2d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            //[H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - end
            pageCountMax += pageCount;
        }

        // ��������[�v
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            // ���R�[�h�̕���
            parseStyle();
            // ��{��񃌃R�[�h
            baseMap = getBaseMap();
            // ��{�E�v��񃌃R�[�h
            baseSummaryList = getBaseSummaryList(); //[H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add           
            // ���׏�񃌃R�[�h�W��
            detailList = getDetailList();
            // �W�v��񃌃R�[�h
            typeMap = getTypeMap();

            // �ً}���{�ݗ×{�E���{�ݗ×{���񃌃R�[�h
            // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - begin
//            emergencyOwnFacilityMap = getemErgencyOwnFacilityMap();
            emergencyOwnFacilityMap = getEmergencyInfo();
            // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - end
            // ��������҉��T�[�r�X��p��񃌃R�[�h
            nursingList = getNursingList();
            //���ʎ��Ô��񃌃R�[�h
            diagnosisList = getDiagnosisList();

            
            // ����Ő����Z�o����B�i1�ł�����̖��׏���5���A��������҉��T�[�r�X�����2���A���ʎ��Ô��2��)
            // ��������҂��󎚂��Ȃ��ꍇ������̂ŁA����v�Z����B
            int pageCount = 1;
            int pageTemp = 1;

            if (detailList.getDataSize() > 0) {
                
                //[ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                //pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 5d);
                pageTemp = (int) Math.ceil((double) detailList.getDataSize() / (double)detailsRecordCount);
                //[ID:0000447][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
                
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)) {
                pageTemp = (int) Math.ceil((double) nursingList.getDataSize() / 2d);
                if (pageTemp > pageCount)
                    pageCount = pageTemp;
            }
            //����f�Ô�E���Ô��񃌃R�[�h����
            if (diagnosisList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) diagnosisList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            //[H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - begin
            if (baseSummaryList.getDataSize() > 0) {
                pageTemp = (int) Math.ceil((double) baseSummaryList.getDataSize() / 2d);
                if (pageTemp > pageCount){
                    pageCount = pageTemp;
                }
            }
            //[H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - end

            // ������[�v
            for (int i = 0; i < pageCount; i++,printPage++) {
                // �y�[�W�J�n
                //[ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                //writer.beginPageEdit("QP001P10_2");
                writer.beginPageEdit(getFormatId());
                //[ID:0000447][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�

                // ���[���ʏ���ݒ�
                setPrintHeader(kohiCount);
                
                setNyusyoDate();
                
                //[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
                if (QP001Util.TERM_200904_AFFTER <= getTerm()){
                    //�����O�̏󋵂�ݒ肷��
                    setBeforeHospitalization();
                }
                //[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
                
                // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - begin
                setBaseSummaryList(baseSummaryList, 3);
                // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - end
                
                //���׌��������[�v����B��5���𒴂���ꍇ�́A���y�[�W�Ɉ�
                //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start �V���̈ꕔ����Ώۂ̑Ή�
                //���ʊ֐�����ꕔ����`�F�b�N���s���Ǝ��֐��̌Ăяo���֕ύX
                //if(isDetailListShow(kohiCount)){
                if(isDetailListShowStyle9(kohiCount,baseMap)){
                //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start �V���̈ꕔ����Ώۂ̑Ή�
                    
                    //[ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                    //setDetailList(detailList,6,kohiCount);
                	
                	//[H30.04�����Ή�][Shinobu Hitaka] 2018/03/18 edit - start �l���ύX�Ή�
                    //setDetailList(detailList, detailsRecordCount + 1, kohiCount);
                    setDetailList(detailList, detailsRecordCount + 1, kohiCount, 6);
                    //[H30.04�����Ή�][Shinobu Hitaka] 2014/02/12 edit - end
                    
                    //[ID:0000447][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
                }
                
                //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start �V���̈ꕔ����Ώۂ̑Ή�
                //���ʊ֐�����ꕔ����`�F�b�N���s���Ǝ��֐��̌Ăяo���֕ύX
                //if(isDiagnosisListShow(kohiCount,diagnosisLastMap)){
                if(isDiagnosisListShowStyle9(kohiCount,diagnosisLastMap,baseMap)){
                //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - end   �V���̈ꕔ����Ώۂ̑Ή�
                    
                    // ����f�Ô�������[�v����B��2���𒴂���ꍇ�́A���y�[�W�Ɉ�
                    for (int j = 1; j < 3; j++) {
                        if (diagnosisList.getDataSize() == 0)
                            break;
                        VRMap diagnosis = (VRMap) diagnosisList.get(0);
                        // ���ʔԍ���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, diagnosis,
                                "501009", "shikibetsuno" + j);
                        // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/28 mod - begin
//                        // ���e��ݒ肷��B������f�Ô�}�X�^(M_SPECIAL_CLINIC)��SPECIAL_CLINIC_TYPE�ƌ������ASPECIAL_CLINIC_NAME��\���B
//                        //[ID:0000454][Shin Fujihara] 2009/05/01 edit begin ��Q�Ή�
//                        /*
//                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
//                                manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),2));
//                        */
//                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
//                                manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),2, baseMap.get("201003")));
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
                                manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009"))
                                		, getSpecialClinicRecordType(), baseMap.get("201003")));
                        // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/28 mod - end
                        //[ID:0000454][Shin Fujihara] 2009/05/01 edit end ��Q�Ή�
                        // �P�ʐ���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotani" + j, pad(diagnosis.get("501010"),4));
                        // �񐔂�ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotimes" + j, pad(diagnosis.get("501011"),2));
                        // �ی����P�ʐ���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentani" + j, pad(diagnosis.get("501012"),6));
                        
                        switch(kohiCount){
                            case 0:
                                // ����񐔂�ݒ肷��B
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501014"),2));
                                // ����P�ʐ���ݒ肷��B
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501015"),6));
                                break;
                            case 1:
                                // ����񐔂�ݒ肷��B
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501017"),2));
                                // ����P�ʐ���ݒ肷��B
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501018"),6));
                                break;
                            case 2:
                                // ����񐔂�ݒ肷��B
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitimes" + j, pad(diagnosis.get("501020"),2));
                                // ����P�ʐ���ݒ肷��B
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitani" + j, pad(diagnosis.get("501021"),6));
                                break;
                        }
                        
                        // �E�v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, diagnosis,
                                "501023", "tokuteishinryo.h" + j + ".tekiyo");
                        
                        diagnosisList.remove(0);
                    }
                }

                // ��������҉��T�[�r�X���������[�v����B��2���𒴂���ꍇ�́A���y�[�W�Ɉ�
                if(nursingCount == kohiCount){
                    for (int j = 1; j < 3; j++) {
                        if (nursingList.getDataSize() == 0)
                            break;
                        VRMap nursing = (VRMap) nursingList.get(0);
                        // �T�[�r�X���e��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, nursing, "801034", "tokuteimeisai.h" + j + ".w2");
                        // �T�[�r�X�R�[�h��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteiservicecode" + j, ACCastUtilities
                                        .toString(VRBindPathParser.get("801008",
                                                nursing))
                                        + ACCastUtilities.toString(VRBindPathParser
                                                .get("801009", nursing)));

                        // ��p�P����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitani" + j, pad(VRBindPathParser.get("801010", nursing), 4));
                        // ���S���x�z��ݒ肷��B
                        //[ID:0000651][Shin Fujihara] 2011/07/06 add begin ���S���x�z0�~�\���Ή�
                        //ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j, pad(VRBindPathParser.get("801011", nursing), 4));
                        ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j, pad0NursingLimit(VRBindPathParser.get("801011", nursing), 4));
                        //[ID:0000651][Shin Fujihara] 2011/07/06 add end ���S���x�z0�~�\���Ή�
                        // ������ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitimes" + j, pad(VRBindPathParser.get("801012", nursing), 2));
                        // ��p�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyo" + j, pad(VRBindPathParser.get("801016", nursing), 6));
                        // �ی������z��ݒ肷��B
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
                        
                        // ���p�ҕ��S�z��ݒ肷��B
                        //[ID:0000449][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                        //ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha" + j, pad(VRBindPathParser.get("801021", nursing), 5));
                        ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha" + j, pad0(VRBindPathParser.get("801021", nursing), 5));
                        //[ID:0000449][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
                        
                        nursingList.remove(0);
                    }
                }


                // 1�y�[�W�ڂ݈̂󎚂���
                if (i == 0) {
                    //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start �V���̈ꕔ����Ώۂ̑Ή�
                    //���ʊ֐�����ꕔ����`�F�b�N���s���Ǝ��֐��̌Ăяo���֕ύX
                    //if(isDetailListShow(kohiCount)){
                    if(isDetailListShowStyle9(kohiCount,baseMap)){
                    //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start �V���̈ꕔ����Ώۂ̑Ή�
                            
                        //�T�[�r�X�P�ʐ����v��ݒ肷��B�@���T�[�r�X�P�ʐ��̍��Z��ݒ�B
                        ACChotarouXMLUtilities.setValue(writer,"servicetimetotal",pad(String.valueOf(getServiceUnitTotal()),6));
                        //����ΏےP�ʐ����v��ݒ肷��B�@������ΏےP�ʐ��̍��Z��ݒ�B
                        switch(kohiCount){
                        case 0:
                            ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal1()),6));
                            break;
                        case 1:
                            ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal2()),6));
                            break;
                        case 2:
                            ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal3()),6));
                            break;
                        }
                    }
                    
                    // �ً}���{�ݎ��Ô�===================================
// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - begin
//                    if(emergencyOwnFacilityMap != null){
//                        
//                        // ���莾���{�ݗ×{�� ���a���P
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701047", "emergency1.h1.w8");
//                        // ���莾���{�ݗ×{�� ���a���Q
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701048", "emergency1.h2.w8");
//                        // ���莾���{�ݗ×{�� ���a���R
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701049", "emergency1.h3.w8");
//                        // ���莾���{�ݗ×{��J�n�N�����P
//                        if (QP001Util.isDate(VRBindPathParser.get("1701050", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701050", emergencyOwnFacilityMap));
//                            // ���莾���{�ݗ×{��J�n�N�����P�̘a���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h1.w19", eraFormat.format(start));
//                            // ���莾���{�ݗ×{��J�n�N�����P�̘a��N��ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "ownyear1", eraYearFormat.format(start));
//                            // ���莾���{�ݗ×{��J�n�N�����P�̌���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "ownmonth1", monthFormat.format(start));
//                            // ���莾���{�ݗ×{��J�n�N�����P�̓���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "ownday1", dayFormat.format(start));
//                        }
//                        // ���莾���{�ݗ×{��J�n�N�����Q
//                        if (QP001Util.isDate(VRBindPathParser.get("1701051", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701051", emergencyOwnFacilityMap));
//                            // ���莾���{�ݗ×{��J�n�N�����Q�̘a���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h2.w19", eraFormat.format(start));
//                            // ���莾���{�ݗ×{��J�n�N�����Q�̘a��N��ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "ownyear2", eraYearFormat.format(start));
//                            // ���莾���{�ݗ×{��J�n�N�����Q�̌���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "ownmonth2", monthFormat.format(start));
//                            // ���莾���{�ݗ×{��J�n�N�����Q�̓���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "ownday2", dayFormat.format(start));
//                        }
//                        // ���莾���{�ݗ×{��J�n�N�����R
//                        if (QP001Util.isDate(VRBindPathParser.get("1701052", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701052", emergencyOwnFacilityMap));
//                            // ���莾���{�ݗ×{��J�n�N�����R�̘a���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h3.w19", eraFormat.format(start));
//                            // ���莾���{�ݗ×{��J�n�N�����R�̘a��N��ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "ownyear3", eraYearFormat.format(start));
//                            // ���莾���{�ݗ×{��J�n�N�����R�̌���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "ownmonth3", monthFormat.format(start));
//                            // ���莾���{�ݗ×{��J�n�N�����R�̓���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "ownday3", dayFormat.format(start));
//                        }
//                        // ���莾���{�ݗ×{��(�Čf)��ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergency1.h4.w7", pad(emergencyOwnFacilityMap.get("1701055"),0));
//                        // ���莾���{�ݗ×{��P�ʐ���ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergency1.h4.w10", pad(emergencyOwnFacilityMap.get("1701053"),0));
//                        // ���莾���{�ݗ×{�������ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "owntani", pad(emergencyOwnFacilityMap.get("1701054"),2));
//                        
//                        
//                        // �ً}�����a���P��ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701008", "emergency1.h5.w8");
//                        // �ً}�����a���Q��ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701009", "emergency1.h6.w8");
//                        // �ً}�����a���R��ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701010", "emergency1.h7.w8");
//    
//                        // �ً}�����ÊJ�n�J�n�N�����P
//                        if (QP001Util.isDate(VRBindPathParser.get("1701011", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701011", emergencyOwnFacilityMap));
//                            // �ً}�����ÊJ�n�N�����P�̘a���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h5.w19", eraFormat.format(start));
//                            // �ً}�����ÊJ�n�N�����P�̘a��N��ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyyear1", eraYearFormat.format(start));
//                            // �ً}�����ÊJ�n�N�����P�̌���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergencymonth1", monthFormat.format(start));
//                            // �ً}�����ÊJ�n�N�����P�̓���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyday1", dayFormat.format(start));
//                        }
//    
//                        // �ً}�����ÊJ�n�N�����Q
//                        if (QP001Util.isDate(VRBindPathParser.get("1701012", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701012", emergencyOwnFacilityMap));
//                            // �ً}�����ÊJ�n�N�����Q�̘a���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h6.w19", eraFormat.format(start));
//                            // �ً}�����ÊJ�n�N�����Q�̘a��N��ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyyear2", eraYearFormat.format(start));
//                            // �ً}�����ÊJ�n�N�����Q�̌���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergencymonth2", monthFormat.format(start));
//                            // �ً}�����ÊJ�n�N�����Q�̓���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyday2", dayFormat.format(start));
//                        }
//    
//                        // �ً}�����ÊJ�n�N�����R
//                        if (QP001Util.isDate(VRBindPathParser.get("1701013", emergencyOwnFacilityMap))) {
//                            Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701013", emergencyOwnFacilityMap));
//                            // �ً}�����ÊJ�n�N�����R�̘a���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergency1.h7.w19", eraFormat.format(start));
//                            // �ً}�����ÊJ�n�N�����R�̘a��N��ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyyear3", eraYearFormat.format(start));
//                            // �ً}�����ÊJ�n�N�����R�̌���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergencymonth3", monthFormat.format(start));
//                            // �ً}�����ÊJ�n�N�����R�̓���ݒ肷��B
//                            ACChotarouXMLUtilities.setValue(writer, "emergencyday3", dayFormat.format(start));
//                        }
//    
//                        // �ً}�����ÊǗ�(�Čf)��ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergency1.h8.w7", pad(emergencyOwnFacilityMap.get("1701020"),0));
//                        // �ً}�����ÊǗ��P�ʐ���ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergency1.h8.w10", pad(emergencyOwnFacilityMap.get("1701018"),0));
//                        // �ً}�����ÊǗ�������ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergencytani", pad(emergencyOwnFacilityMap.get("1701019"),2));
//    
//                        // ���n�r���e�[�V�����_����ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h9.w6", pad(emergencyOwnFacilityMap.get("1701021"),0));
//                        // ���u�_����ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h10.w6", pad(emergencyOwnFacilityMap.get("1701022"),0));
//                        // ��p�_����ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h11.w6", pad(emergencyOwnFacilityMap.get("1701023"),0));
//                        // �����_����ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h12.w6", pad(emergencyOwnFacilityMap.get("1701024"),0));
//                        // ���ː����Ó_����ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h13.w6", pad(emergencyOwnFacilityMap.get("1701025"),0));
//                        // ���v�_����ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h14.w6", pad(emergencyOwnFacilityMap.get("1701046"),0));
//                        
//                        // �E�v��ݒ肷��B���E�v�P�`�E�v�Q�O�܂ł��u�^�v�ŘA�����A�o�́B
//                        StringBuilder tekiyo = new StringBuilder();
//                        for (int j = 1701026; j < 1701046; j++) {
//                            if (!ACTextUtilities.isNullText(VRBindPathParser.get(ACCastUtilities.toString(j), emergencyOwnFacilityMap))) {
//                                tekiyo.append(VRBindPathParser.get(ACCastUtilities.toString(j), emergencyOwnFacilityMap));
//                                tekiyo.append("�^");
//                            }
//                        }
//                        if (tekiyo.length() > 0) {
//                            tekiyo.deleteCharAt(tekiyo.length() - 1);
//                        }
//                        ACChotarouXMLUtilities.setValue(writer, "emergency2.h10.w10",tekiyo.toString());
//                        
//                        // ���f������ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "oushintimes", pad(emergencyOwnFacilityMap.get("1701014"),2));
//                        // ���f��Ë@�֖���ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap,"1701015", "emergency3.h15.w8");
//                        
//                        // �ʉ@������ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, "tuuintimes", pad(emergencyOwnFacilityMap.get("1701016"),2));
//                        // �ʉ@��Ë@�ւ�ݒ肷��B
//                        ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701017","emergency3.h15.w21");
//                    }
                    writeEmergency();
// [H30.4�����Ή�][Yoichiro Kamei] 2018/4/11 mod - end
                    
                    //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - start �V���̈ꕔ����Ώۂ̑Ή�
                    //���ʊ֐�����ꕔ����`�F�b�N���s���Ǝ��֐��̌Ăяo���֕ύX
                    //if(isDiagnosisListShow(kohiCount,diagnosisLastMap)){
                    if(isDiagnosisListShowStyle9(kohiCount,diagnosisLastMap,baseMap)){
                    //[CCCX:1470][Shinobu Hitaka] 2014/02/12 edit - end   �V���̈ꕔ����Ώۂ̑Ή�
                        
                        // ����f�Ô��񃌃R�[�h�����ԍ���01�̃��R�[�h�̏��a����ݒ肷��B
                        // 01�̃��R�[�h���Ȃ��ꍇ��99�̃��R�[�h�̒l���̗p����B
                        ACChotarouXMLUtilities.setValue(writer, diagnosisFirstMap,"501008", "tokuteishinryo.syoubyo.w4");
                        
                        //����f�Ô�̍��v�����o��
                        if(diagnosisLastMap != null){
                            //����f�Ô�̕ی����P�ʐ��̍��v��ݒ肷��B ������f�Ô��񃌃R�[�h�����ԍ���99�̒l���̗p����B
                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentanitotal", pad(diagnosisLastMap.get("501013"),6));
                            
                            switch(kohiCount){
                            case 0:
                                //����f�Ô�̌���P�ʐ��̍��v��ݒ肷��B�@������f�Ô��񃌃R�[�h�����ԍ���99�̒l���̗p����B
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501016"),6));
                                break;
                            case 1:
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501019"),6));
                                break;
                            case 2:
                                ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501022"),6));
                                break;
                            }
                            
                        }
                    }
                    
                    //[CCCX:1470][Shinobu Hitaka] 2014/03/13 edit - start �V���̈ꕔ����Ώۂ̑Ή�
                    //���ʊ֐�����ꕔ����`�F�b�N���s���Ǝ��֐��̌Ăяo���֕ύX
                    //if(isDetailListShow(kohiCount)){
                    if(isDetailListShowStyle9(kohiCount,baseMap)){
                    //[CCCX:1470][Shinobu Hitaka] 2014/03/13 edit - start �V���̈ꕔ����Ώۂ̑Ή�
                        
                        //�����z�W�v�� �ی���====================================
                        // ���t�_���E�P�ʐ��i�ی����j��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokentani", pad(typeMap.get("701014"),6));
                        // �_���E�P�ʐ��P����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tanka", getTanka(typeMap.get("701015")));
                        
                        if(kohiCount == 0){
                            // ���t���i�ی����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "hokenkyuhu", pad(baseMap.get("201029"),3));
                            // �����z�i�ی����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(typeMap.get("701016"),6));
                            // ���p�ҕ��S�z�i�ی����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "hokenriyousyahutan",pad(typeMap.get("701017"),6));
                        }
                        
                        //�����z�W�v�� ���====================================
                        switch(kohiCount){
                        case 0:
                            // ���t�_���E�P�ʐ��i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitani", pad(typeMap.get("701018"),6));
                            // ���t���i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohikyuhu", pad(baseMap.get("201030"),3));
                            // �����z�i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701019"),6));
                            // ���p�ҕ��S�z�i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701020"),6));
                            break;
                        case 1:
                            // ���t�_���E�P�ʐ��i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitani", pad(typeMap.get("701021"),6));
                            // ���t���i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohikyuhu", pad(baseMap.get("201031"),3));
                            // �����z�i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701022"),6));
                            // ���p�ҕ��S�z�i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701023"),6));
                            break;
                        case 2:
                            // ���t�_���E�P�ʐ��i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitani", pad(typeMap.get("701024"),6));
                            // ���t���i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohikyuhu", pad(baseMap.get("201032"),3));
                            // �����z�i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(typeMap.get("701025"),6));
                            // ���p�ҕ��S�z�i����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohiriyousyahutan", pad(typeMap.get("701026"),6));
                            break;
                        }
                    }
                    
                    //�����z�W�v�� �ی������莡�ÁE����×{��====================================
                    if(ACCastUtilities.toInt(typeMap.get("701027"),0) != 0){
                        
                        ACChotarouXMLUtilities.setValue(writer, "hokentokuteitani", pad(typeMap.get("701027"),6));
                        if(kohiCount == 0){
                            // ���t���i�ی����j��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteikyuhu", pad(baseMap.get("201029"),3));
                            // �����z�i�ی������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteiseikyu", pad(typeMap.get("701028"),6));
                            // �{�l���S�z�i�ی������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteiriyousyahutan", pad(typeMap.get("701029"),6));
                        }
                        
                    }
                    
                    //�����z�W�v�� ������莡��====================================
                    switch(kohiCount){
                    case 0:
                        if(ACCastUtilities.toInt(typeMap.get("701030"),0) != 0){
                            // ���t�_���E�P�ʐ��i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteitani", pad(typeMap.get("701030"),6));
                            //���t���i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyuhu", pad(baseMap.get("201030"),3));
                            // �����z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701031"),6));
                            // ���p�ҕ��S�z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyahutan", pad(typeMap.get("701032"),6));
                        }
                        break;
                    case 1:
                        if(ACCastUtilities.toInt(typeMap.get("701033"),0) != 0){
                            // ���t�_���E�P�ʐ��i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteitani", pad(typeMap.get("701033"),6));
                            //���t���i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyuhu", pad(baseMap.get("201031"),3));
                            // �����z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701034"),6));
                            // ���p�ҕ��S�z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyahutan", pad(typeMap.get("701035"),6));
                        }
                        break;
                    case 2:
                        if(ACCastUtilities.toInt(typeMap.get("701036"),0) != 0){
                            // ���t�_���E�P�ʐ��i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteitani", pad(typeMap.get("701036"),6));
                            //���t���i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyuhu", pad(baseMap.get("201032"),3));
                            // �����z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701037"),6));
                            // ���p�ҕ��S�z�i������莡�Áj��ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyahutan", pad(typeMap.get("701038"),6));
                        }
                        break;
                    }

                    
                    if((nursingLast != null) && (nursingCount == kohiCount)){
                        //��p�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyototal",pad(nursingLast.get("801022"),6));
                        
                        //�ی��ҕ��S�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,"tokuteihokentotal", pad(nursingLast.get("801023"),6));
                        //�ی��������z��ݒ肷��B
                        //[ID:0000449][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                        //ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad(nursingLast.get("801024"),5));
                        ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad0(nursingLast.get("801024"),6));
                        //[ID:0000449][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
                        
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

                }
                // ����y�[�W������2���ȏ�̏ꍇ
                if ((pageCountMax) > 1) {
                    // �o�̓y�[�W���̑�����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((pageCountMax)));
                    // ���݂̏o�̓y�[�W����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
                            ACCastUtilities.toString(printPage));
                }
                // �y�[�W�I��
                writer.endPageEdit();
            }
        }

        // ��������s�����Ȃ��true��Ԃ��B
        return true;
    }
    
    /**
     * ���t��ח���\�����邩�̃t���O��ԋp���܂��B<br>
     * �V����p
     * @param kohiCount
     * @return
     * @throws Exception
     */
    protected boolean isDetailListShowStyle9(int kohiCount, VRMap baseMap) throws Exception {
        
        switch(kohiCount){
            //����P�����
            case 0:
                // ����S�Ҕԍ����m�F
                //����S�Ҕԍ������݂�
                if(!ACTextUtilities.isNullText(baseMap.get("201007"))){
                    if(ACCastUtilities.toString(baseMap.get("201007")).startsWith("10")){
                        return true;
                    }
                    
                    //���8801:�����a�����΍�A8802:���`������A8701:�L�@�q�f�A6601:�Ζȁ@�̏ꍇ
                    //�ꕔ����K�p�̂��߁A����v���Ȃ��Ă��\������
                    if (ACCastUtilities.toString(baseMap.get("201007")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201007")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201007")).startsWith("66")) {
                        return true;
                    }
                    
                    //����v��0�̏ꍇ�͕\���𒆒f����B
                    if(getKohiTotal1() == 0){
                        return false;
                    }
                }
                break;
            //����Q�����
            case 1:
                if(!ACTextUtilities.isNullText(baseMap.get("201009"))){
                    if(ACCastUtilities.toString(baseMap.get("201009")).startsWith("10")){
                        return true;
                    }
                    
                    //���8801:�����a�����΍�A8802:���`������A8701:�L�@�q�f�A6601:�Ζȁ@�̏ꍇ
                    //�ꕔ����K�p�̂��߁A����v���Ȃ��Ă��\������
                    if (ACCastUtilities.toString(baseMap.get("201009")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201009")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201009")).startsWith("66")) {
                        return true;
                    }
                    
                    //����v��0�̏ꍇ�͕\���𒆒f����B
                    if(getKohiTotal2() == 0){
                        return false;
                    }
                }
                break;
            //����R�����
            case 2:
                if(!ACTextUtilities.isNullText(baseMap.get("201011"))){
                    if(ACCastUtilities.toString(baseMap.get("201011")).startsWith("10")){
                        return true;
                    }
                    
                    //���8801:�����a�����΍�A8802:���`������A8701:�L�@�q�f�A6601:�Ζȁ@�̏ꍇ
                    //�ꕔ����K�p�̂��߁A����v���Ȃ��Ă��\������
                    if (ACCastUtilities.toString(baseMap.get("201011")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201011")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201011")).startsWith("66")) {
                        return true;
                    }

                    //����v��0�̏ꍇ�͕\���𒆒f����B
                    if(getKohiTotal3() == 0){
                        return false;
                    }
                }
                break;
        }
        return true;
    }
    
    /**
     * ����f�Ô�ח���\�����邩�̃t���O��ԋp���܂��B
     * �V����p
     * @param kohiCount
     * @param diagnosisLastMap
     * @return
     * @throws Exception
     */
    protected boolean isDiagnosisListShowStyle9(int kohiCount,VRMap diagnosisLastMap, VRMap baseMap) throws Exception {
        
        if(diagnosisLastMap == null){
            return true;
        }
        switch(kohiCount){
            //����P�����
            case 0:
                // ����S�Ҕԍ����m�F
                //����S�Ҕԍ������݂�
                if(!ACTextUtilities.isNullText(baseMap.get("201007"))){
                    if(ACCastUtilities.toString(baseMap.get("201007")).startsWith("10")){
                        return true;
                    }

                    //���8801:�����a�����΍�A8802:���`������A8701:�L�@�q�f�A6601:�Ζȁ@�̏ꍇ
                    //�ꕔ����K�p�̂��߁A����v���Ȃ��Ă��\������
                    if (ACCastUtilities.toString(baseMap.get("201007")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201007")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201007")).startsWith("66")) {
                        return true;
                    }
                    
                    //����v��0�̏ꍇ�͕\���𒆒f����B
                    if(ACCastUtilities.toInt(diagnosisLastMap.get("501016"),0) == 0){
                        return false;
                    }
                }
                break;
            //����Q�����
            case 1:
                if(!ACTextUtilities.isNullText(baseMap.get("201009"))){
                    if(ACCastUtilities.toString(baseMap.get("201009")).startsWith("10")){
                        return true;
                    }
                    
                    //���8801:�����a�����΍�A8802:���`������A8701:�L�@�q�f�A6601:�Ζȁ@�̏ꍇ
                    //�ꕔ����K�p�̂��߁A����v���Ȃ��Ă��\������
                    if (ACCastUtilities.toString(baseMap.get("201009")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201009")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201009")).startsWith("66")) {
                        return true;
                    }
                    
                    //����v��0�̏ꍇ�͕\���𒆒f����B
                    if(ACCastUtilities.toInt(diagnosisLastMap.get("501019"),0) == 0){
                        return false;
                    }
                }
                break;
            //����R�����
            case 2:
                if(!ACTextUtilities.isNullText(baseMap.get("201011"))){
                    if(ACCastUtilities.toString(baseMap.get("201011")).startsWith("10")){
                        return true;
                    }
                    
                    //���8801:�����a�����΍�A8802:���`������A8701:�L�@�q�f�A6601:�Ζȁ@�̏ꍇ
                    //�ꕔ����K�p�̂��߁A����v���Ȃ��Ă��\������
                    if (ACCastUtilities.toString(baseMap.get("201011")).startsWith("88") ||
                            ACCastUtilities.toString(baseMap.get("201011")).startsWith("87") || 
                            ACCastUtilities.toString(baseMap.get("201011")).startsWith("66")) {
                        return true;
                    }
                    
                    //����v��0�̏ꍇ�͕\���𒆒f����B
                    if(ACCastUtilities.toInt(diagnosisLastMap.get("501022"),0) == 0){
                        return false;
                    }
                }
                break;
        }
        return true;
    }

    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/28 add - begin
    // ���ʗ×{��܂��͓��ʐf�Ô�̃��R�[�h�^�C�v���擾���܂��B�i�q�N���X�Ŏ����j
    protected abstract int getSpecialClinicRecordType();
    
    // �ً}���{�ݗ×{�E�ً}���{�ݐf�Ï��܂��́A���莾���{�ݗ×{������o�͂��܂��B�i�q�N���X�Ŏ����j
    protected abstract VRMap getEmergencyInfo();
    protected abstract void writeEmergency() throws Exception;
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/28 add - end
}
