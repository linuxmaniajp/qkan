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
 * �v���Z�X �{�݃T�[�r�X����싋�t��׏��i���×{�^�{��) (001)
 * �v���O���� �{�݃T�[�r�X����싋�t��׏��i���×{�^�{��) (QP001P11)
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
 * �{�݃T�[�r�X����싋�t��׏��i���×{�^�{��)(�l����\) -�l����\
 */
public class QP001P10_201204 extends QP001P02_10Event {
    
	/* 
	 * �l����\ 201204�ȍ~
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
    public QP001P10_201204() {
    }

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P100_201204.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P100_201204";
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
        //ACChotarouXMLUtilities.addFormat(writer, "QP001P11", "QP001P11.xml");

        // ��{��񃌃R�[�h
        VRMap baseMap = getBaseMap();
        // ���׏�񃌃R�[�h�W��
        VRList detailList = getDetailList();
        // �W�v��񃌃R�[�h
        VRMap typeMap = getTypeMap();

        // ����f�Ô��񃌃R�[�h
        VRList diagnosisList = getDiagnosisList();

        // ��������҉��T�[�r�X��p��񃌃R�[�h
        VRList nursingList = getNursingList();
        
        VRMap nursingLast = getLastRecord(nursingList,"801007");
        
        VRMap diagnosisFirstMap = getNominationRecord(diagnosisList,"501007",1);
        VRMap diagnosisLastMap = getLastRecord(diagnosisList,"501007");

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
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)) {
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
            if ((nursingList.getDataSize() > 0) && (nursingCount == kohiCount)) {
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
                
                //�����E�ޏ��̃f�[�^��ݒ肷��B
                setNyusyoDate();
                
                //[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
                if (QP001Util.TERM_200904_AFFTER <= getTerm()){
                	//�����O�̏󋵂�ݒ肷��
                	setBeforeHospitalization();
                }
                //[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
                
                //���׌��������[�v����B��8���𒴂���ꍇ�́A���y�[�W�Ɉ�
                if(isDetailListShow(kohiCount)){
                	setDetailList(detailList,9,kohiCount);
                }

                if(isDiagnosisListShow(kohiCount,diagnosisLastMap)){
	                // ����f�Ô�������[�v����B��6���𒴂���ꍇ�́A���y�[�W�Ɉ�
	                for (int j = 1; j < 7; j++) {
	                    if (diagnosisList.getDataSize() == 0)
	                        break;
	                    VRMap diagnosis = (VRMap) diagnosisList.get(0);
	                    // ���ʔԍ���ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, diagnosis,
	                            "501009", "shikibetsuno" + j);
	                    // ���e��ݒ肷��B������f�Ô�}�X�^(M_SPECIAL_CLINIC)��SPECIAL_CLINIC_TYPE�ƌ������ASPECIAL_CLINIC_NAME��\���B
	                    // setValue(tokuteishinryo(w4,h*), 501009);
	                    //[ID:0000454][Shin Fujihara] 2009/05/01 edit begin ��Q�Ή�
	                    /*
	                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
	                            manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009"))));
	                    */
	                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryo.h" + j + ".w4",
	                            manager.getSpecialClinicName(String.valueOf(diagnosis.get("501009")),baseMap.get("201003")));
	                    //[ID:0000454][Shin Fujihara] 2009/05/01 edit end ��Q�Ή�
	                    // �P�ʐ���ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotani" + j, pad(diagnosis.get("501010"),4));
	                    // �񐔂�ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryotimes" + j, pad(diagnosis.get("501011"),2));
	                    // �ی����P�ʐ���ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentani" + j, pad(diagnosis.get("501012"),5));
	                    
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
                }

                // ��������҉��T�[�r�X���������[�v����B��4���𒴂���ꍇ�́A���y�[�W�Ɉ�
                if(nursingCount == kohiCount){
                    for (int j = 1; j < 5; j++) {
                        if (nursingList.getDataSize() == 0)
                            break;
                        VRMap nursing = (VRMap) nursingList.get(0);
                        // �T�[�r�X���e��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, nursing, "801034",
                                "tokuteimeisai.h" + j + ".w2");
                        //�T�[�r�X�R�[�h��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "tokuteiservicecode" + j, ACCastUtilities
                                        .toString(VRBindPathParser.get("801008",
                                                nursing))
                                        + ACCastUtilities.toString(VRBindPathParser
                                                .get("801009", nursing)));

                        //��p�P����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteitani" + j, pad(VRBindPathParser.get("801010", nursing), 4));
                        //���S���x�z��ݒ肷��B
                        //[ID:0000651][Shin Fujihara] 2011/07/06 add begin ���S���x�z0�~�\���Ή�
                        //ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j, pad(VRBindPathParser.get("801011", nursing), 4));
                        ACChotarouXMLUtilities.setValue(writer, "dokuteilimit" + j, pad0NursingLimit(VRBindPathParser.get("801011", nursing), 4));
                        //[ID:0000651][Shin Fujihara] 2011/07/06 add end ���S���x�z0�~�\���Ή�
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
                        //[ID:0000449][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                        //ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha" + j, pad(VRBindPathParser.get("801021", nursing), 5));
                        ACChotarouXMLUtilities.setValue(writer, "tokuteiriyosha" + j, pad0(VRBindPathParser.get("801021", nursing), 5));
                        //[ID:0000449][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
                        
                        nursingList.remove(0);
                    }
                }

                //�p�����ꖇ�߂̏ꍇ
                if (i == 0) {
                    
                	if(isDetailListShow(kohiCount)){
	                    //���t��ח��̍��v���o��==============================
	                    //�T�[�r�X�P�ʐ����v��ݒ肷��B�@���T�[�r�X�P�ʐ��̍��Z��ݒ�B
	                    ACChotarouXMLUtilities.setValue(writer,"servicetimetotal",pad(String.valueOf(getServiceUnitTotal()),5));
	                    //����ΏےP�ʐ����v��ݒ肷��B�@������ΏےP�ʐ��̍��Z��ݒ�B
	                    switch(kohiCount){
	                    case 0:
	                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal1()),5));
	                        break;
	                    case 1:
	                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal2()),5));
	                        break;
	                    case 2:
	                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal3()),5));
	                        break;
	                    }
                	}
                	if(isDiagnosisListShow(kohiCount,diagnosisLastMap)){
	                    // ����f�Ô��񃌃R�[�h�����ԍ���01�̃��R�[�h�̏��a����ݒ肷��B
	                    // 01�̃��R�[�h���Ȃ��ꍇ��99�̃��R�[�h�̒l���̗p����B
	                    ACChotarouXMLUtilities.setValue(writer, diagnosisFirstMap,"501008", "tokuteishinryo.syoubyo.w4");
	                    
	                    //����f�Ô�̍��v�����o��
	                    if(diagnosisLastMap != null){
	                        //����f�Ô�̕ی����P�ʐ��̍��v��ݒ肷��B ������f�Ô��񃌃R�[�h�����ԍ���99�̒l���̗p����B
	                        ACChotarouXMLUtilities.setValue(writer, "tokuteishinryohokentanitotal", pad(diagnosisLastMap.get("501013"),5));
	                        
	                    }
                	}
                    if(isDetailListShow(kohiCount)){
	                    //�����z�W�v���@�ی���================================
	                    //���t�P�ʐ���ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "kyufutani", pad(typeMap.get("701014"),6));
	                    //�P�ʐ��P����ݒ肷��B
	                    ACChotarouXMLUtilities.setValue(writer, "tanisutani", getTanka(typeMap.get("701015")));
	                    
	                    if(kohiCount == 0){
	                        //�ی����t����ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "hokenkyufu", pad(baseMap.get("201029"),3));
	                        //�ی������z��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(typeMap.get("701016"),6));
	                        // ���p�ҕ��S�z�i�ی����j��ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "hokenriyousyahutan",pad(typeMap.get("701017"),6));
	                    }
	                    
	                    
	                    //�����z�W�v���@���===============================
	                    switch(kohiCount){
	                    //����1
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
	                    //����2
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
	                    //����3
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
                    }
                    if(isDiagnosisListShow(kohiCount,diagnosisLastMap)){
	                    //�����z�W�v���@�ی�������f�Ô�======================
	                    if(diagnosisLastMap != null){
	                        //�ی�������f�Ô�̋��t�P�ʐ���ݒ肷��B
	                        ACChotarouXMLUtilities.setValue(writer, "hokentokuteikyufutani", pad(diagnosisLastMap.get("501013"),6));
	                        
	                        if(kohiCount == 0){
	                            //�ی�������f�Ô�t����ݒ肷��B
	                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteikyufu", pad(baseMap.get("201029"),3));
	                            //����f�Ô���z
	                            ACChotarouXMLUtilities.setValue(writer, "hokentokuteiseikyu", pad(baseMap.get("201037"),6));
	                            //����f�Ô�p�ҕ��S�z
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
	                            //ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(baseMap.get("201043"),6));
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701031"),6));
	                            //���p�ҕ��S�z��ݒ肷��B
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyafutan", pad(typeMap.get("701032"),6));
	                            break;
	                        case 1:
	                            //����f�Ô�̌���P�ʐ��̍��v��ݒ肷��B�@������f�Ô��񃌃R�[�h�����ԍ���99�̒l���̗p����B
	                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501019"),5));
	                            //�������f�Ô�̋��t�P�ʐ���ݒ肷��B
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufutani", pad(diagnosisLastMap.get("501019"),6));
	                            //����t����ݒ肷��B
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufu", pad(baseMap.get("201031"),3));
	                            //������z��ݒ肷��B
	                            //ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(baseMap.get("201049"),6));
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701034"),6));
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyafutan", pad(typeMap.get("701035"),6));
	                            break;
	                        case 2:
	                            //����f�Ô�̌���P�ʐ��̍��v��ݒ肷��B�@������f�Ô��񃌃R�[�h�����ԍ���99�̒l���̗p����B
	                            ACChotarouXMLUtilities.setValue(writer, "tokuteishinryokohitanitotal", pad(diagnosisLastMap.get("501022"),5));
	                            //�������f�Ô�̋��t�P�ʐ���ݒ肷��B
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufutani", pad(diagnosisLastMap.get("501022"),6));
	                            //����t����ݒ肷��B
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteikyufu", pad(baseMap.get("201032"),3));
	                            //������z��ݒ肷��B
	                            //ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(baseMap.get("201055"),6));
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiseikyu", pad(typeMap.get("701037"),6));
	                            ACChotarouXMLUtilities.setValue(writer, "kohitokuteiriyousyafutan", pad(typeMap.get("701038"),6));
	                            break;
	                        }
	                    }
                    }
                    if((nursingLast != null) && (nursingCount == kohiCount)){
                        //��p�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tokuteihiyototal",pad(nursingLast.get("801022"),6));
                        //�ی��ҕ��S�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,"tokuteihokentotal", pad(nursingLast.get("801023"),6));
                        //�ی��������z��ݒ肷��B
                        //[ID:0000449][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
                        //ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad(nursingLast.get("801024"),5));
                        ACChotarouXMLUtilities.setValue(writer,"tokuteiriyoshatotal", pad0(nursingLast.get("801024"),5));
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
                //����y�[�W������2���ȏ�̏ꍇ
                //if ((kohiCountTotal * pageCount) > 1) {
                if ((pageCountMax) > 1) {
                    //�o�̓y�[�W���̑�����ݒ肷��B
//                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
//                            ACCastUtilities.toString((kohiCountTotal * pageCount)));
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((pageCountMax)));
                    //���݂̏o�̓y�[�W����ݒ肷��B
//                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
//                            ACCastUtilities.toString(((kohiCount * pageCount) +i + 1)));
                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
                            ACCastUtilities.toString(printPage));
                }

                //�y�[�W�I��
                writer.endPageEdit();
            }
        }

        return true;

    }

}
