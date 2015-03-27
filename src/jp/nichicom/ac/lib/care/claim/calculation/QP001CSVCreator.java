
/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKAACHO�iJMA care benefit management software�j
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
 * �쐬��: 2005/12/06  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���ъm��/�������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� CSV�t�@�C���쐬���W���[�� (QP001CSVCreator)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

/**
 * ���p�҈ꗗ�i�����j(QP001CSVCreator) CSV�t�@�C���쐬�N���X
 * ���Ώی����Ƃ�CSV�t�@�C�����쐬����B
 * @version 2.1
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanMessageList;

public class QP001CSVCreator {
    
    private DecimalFormat continuousnessFormat = new DecimalFormat("00");
    private DecimalFormat insureNoFormat = new DecimalFormat("00000000");
    private ACDateFormat csvFileNameFormat = new ACDateFormat("eeMM");
    
    //�f�[�^���
    //�l����ꂩ���\ 711
    //�l����\�� 821
    //�l���掵 812
    private String dataType = "";
    
    //��؂蕶��
    private final String spliter = "\",\"";
    /**
     * �f�t�H���g�R���X�g���N�^
     *
     */
    public QP001CSVCreator(){
    }
    
    
    public String create(ACDBManager dbm, String affair,VRList patientData, Date claimDate, VRMap settings,Date claimTargetDate,QP001Manager manager) throws Exception {
        
        //�f�[�^��ʂ��m�肷��B
        //���t�Ǘ��[
        if("02".equals(affair)){
            dataType = "821";
        //�l���掵
        } else if("03".equals(affair)){
            dataType = "812";
        //�l����񂩂��\
        } else if("04".equals(affair)){
            dataType = "711";
        //�l�����
        } else if("08".equals(affair)){
            dataType = "711";
        }
        
        
        // �������ޔ�p�� VRArrayList claim_temp �𐶐�����B
        TreeMap claimSorter = new TreeMap();
        List style11 = new ArrayList();
        
//        //��싋�t���������p
//        TreeMap style1Sorter = new TreeMap();
        
        VRMap map = null;
        VRList claim = null;
        String serviceDate = "";
        
        List claimListTemp = null;
        QP001Style1 style1 = null;
        
        //[ID:0000443][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        QP001ErrorControl errorControl = new QP001ErrorControl();
        //[ID:0000443][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
        
        //patientData�̌��������[�v����B
        for(int i = 0; i < patientData.size(); i++){
            map = (VRMap)patientData.get(i);
            // ��ʂ́u���p�҈ꗗ(infoTable)�v�ɕ\�����Ă��闘�p�҂́u�I��(��(infoTableColumn3)�v�̃`�F�b�N�����Ă���ꍇ�B
            if (!"TRUE".equalsIgnoreCase(ACCastUtilities
                    .toString(VRBindPathParser.get("CHOISE", map)))){
                continue;
            }
            
            //patientData�� KEY : PATIENT_ID �� VALUE ���擾����(���p��ID)�B
            int patient_id = ACCastUtilities.toInt(map.get("PATIENT_ID"));
            // �l���ԍ����擾����B
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", map),0);
            
            // �����ڍ׏����擾���AVRArrayList claimList �Ɋi�[����B
            StringBuilder sb = new StringBuilder();
            Date rowClaimDate =  ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            sb.append(" AND(CLAIM.CLAIM_DATE = '" + VRDateParser.format(rowClaimDate,"yyyy/MM/dd") + "')");
            sb.append(" AND(CLAIM.TARGET_DATE = '" + VRDateParser.format(ACCastUtilities.toDate(map.get("TARGET_DATE")),"yyyy/MM/dd") + "')");
            // ���p��ID���w�肵�Ă���Ȃ�Γ���̗��p�҂̂݁B���w��Ȃ�ΑS���p�҂�ΏۂƂ���B
            sb.append(" AND(CLAIM.PATIENT_ID = " + patient_id + ")");
            // �ی��Ҕԍ��A��ی��Ҕԍ��̌���������ǉ�����B
            sb.append(" AND(CLAIM.INSURER_ID = '" + VRBindPathParser.get("INSURER_ID",map) + "')");
            sb.append(" AND(CLAIM.INSURED_ID = '" + VRBindPathParser.get("INSURED_ID",map) + "')");
            sb.append(" AND(CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
            
            if (!"08".equals(affair)) {
                sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + claimStyleType + ")");
            }
            
            claim = QkanCommon.getClaimDetailCustom(dbm, rowClaimDate, sb.toString());
            
            if((claim == null) || (claim.size() == 0)){
                continue;
            }
            
            try{
                serviceDate = String.valueOf(
                        VRDateParser.format(
                        ACCastUtilities.toDate(
                                ((VRMap)claim.get(0)).get("TARGET_DATE")),"yyyyMM"));
            } catch (Exception e){
                VRLogger.warning("�Ώۓ��̎擾�Ɏ��s:" + claim);
                continue;
            }

            
            //affair�̒l�ɂ���ĕ��򂷂�B
            //�u02�v�̏ꍇ �����p�҈ꗗ�i���t�Ǘ��[�j
            if("02".equals(affair)){
                String kubun = ACCastUtilities.toString(map.get("KUBUN"),"");
                if(kubun == null){
                    kubun = ""; 
                }
                String kubunCode = "1";
                if("�V�K".equals(kubun)){
                    kubunCode = "1";
                } else if("�C��".equals(kubun)){
                    kubunCode = "2";
                } else if("���".equals(kubun)){
                    kubunCode = "3";
                }
                
                //[ID:0000443][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
                if (!errorControl.isValidBenefitManagement(claim, map)){
                	continue;
                }
                //[ID:0000443][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
                
                //claim���l����\��̏��(���ʃ��R�[�h�̒l��8211)���擾���Aclime_temp�ɐݒ肷��B
                setTargetRecord(claim,style11,QP001SpecialCase.getBenefitManagementCodes() ,kubunCode,claimTargetDate);

            //�u08�v�̏ꍇ �����p�҈ꗗ�i�ݑ�T�[�r�X�񋟎��Ə������j
            } else if("08".equals(affair)){
                // claim���l�����̏��(���ʃ��R�[�h�̒l��7131)���擾���Aclime_temp�ɐݒ肷��B
                // claim���l����O�̏��(���ʃ��R�[�h�̒l��7143)���擾���Aclime_temp�ɐݒ肷��B
                // claim���l����l�̏��(���ʃ��R�[�h�̒l��7153)���擾���Aclime_temp�ɐݒ肷��B
                // claim���l����܂̏��(���ʃ��R�[�h�̒l��7164)���擾���Aclime_temp�ɐݒ肷��B
                // claim���l����Z�̏��(���ʃ��R�[�h�̒l��7171)���擾���Aclime_temp�ɐݒ肷��B
                // claim���l���掵�̏��(���ʃ��R�[�h�̒l��8122)���擾���Aclime_temp�ɐݒ肷��B
                // claim���l���掵�̏��(���ʃ��R�[�h�̒l��8123)���擾���Aclime_temp�ɐݒ肷��B
                // claim���l���攪�̏��(���ʃ��R�[�h�̒l��7183)���擾���Aclime_temp�ɐݒ肷��B
                // claim���l�����̏��(���ʃ��R�[�h�̒l��7193)���擾���Aclime_temp�ɐݒ肷��B
                // claim���l����\�̏��(���ʃ��R�[�h�̒l��71A3)���擾���Aclime_temp�ɐݒ肷��B
                
                CSVData data = null;
                //���ɓo�^������ꍇ
                if(claimSorter.containsKey(serviceDate)){
                    data = (CSVData)claimSorter.get(serviceDate);
                } else {
                    data = new CSVData(manager);
                    claimSorter.put(serviceDate,data);
                }
                claimListTemp = data.getCSVList();
                style1 = data.getTotalObject();
                
                setTargetRecord(claim,claimListTemp, QP001SpecialCase.getPerformanceCodes());
                style1.parse(claim);
                
            }
        }

        //���t�Ǘ��[�̏ꍇ�͂P�t�@�C��
        if("02".equals(affair)){
        	//[ID:0000443][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        	errorControl.showBenefitManagementError();
        	if (errorControl.isAllError()){
        		return null;
        	}
        	//[ID:0000443][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
            Collections.sort(style11,new StringComparator());
            return makeCSV(style11,claimDate, settings,claimTargetDate);
        }
        List claim_temp_list = null;
        Iterator it = claimSorter.keySet().iterator();
        String result = "";
        while(it.hasNext()){
            claim_temp_list = new ArrayList();
            String key = String.valueOf(it.next());
            CSVData data = (CSVData)claimSorter.get(key);
            setTargetRecord(data.getTotalObject().getRecords(),claim_temp_list,"7111");
            claim_temp_list.addAll(data.getCSVList());
            
            Collections.sort(claim_temp_list,new StringComparator());
            
            if(!ACTextUtilities.isNullText(result)){
                result += "\n�@�@�@�@�@�@�@�@";
            }
            
            // 2006/08/28 add begin kamitsukasa
            // �K��Ō�×{��̎����Ή�
            String temp = makeCSV(claim_temp_list,claimDate, settings,claimTargetDate);
            if(temp == null){
                return null;
            }
            result += temp;
            // 2006/08/28 add end kamitsukasa
//            result += makeCSV(claim_temp_list,claimDate, settings,claimTargetDate);
            
            //����Ȃ��Ȃ����f�[�^���̂Ă�B
            claimSorter.put(key,null);
            Runtime.getRuntime().gc();
        }
        
        // CSV�t�@�C�����쐬����B
        return result;
        
        
    }

    /**
     * �����Ɏw�肳�ꂽ���ʔԍ��ɊY�����郌�R�[�h�ł���ꍇ�A
     * �e���|�������X�g�Ɋi�[����B
     * @param claim
     * @param claim_temp
     * @param code
     * @throws Exception
     */
    private void setTargetRecord(VRList claim,List claimList,String code) throws Exception {
        setTargetRecord(claim,claimList,code,"",null);
    }
    
    /**
     * �����Ɏw�肳�ꂽ���ʔԍ��ɊY�����郌�R�[�h�ł���ꍇ�A
     * �e���|�������X�g�Ɋi�[����B
     * @param claim
     * @param claimCSVList
     * @param code
     * @throws Exception
     */
    private void setTargetRecord(VRList claim,List claimCSVList,String code, String kubunCode,Date targetDate) throws Exception {
        VRMap map = null;
        //��r�Ώۂ̃R�[�h
        String compCode = "";
        //�\�[�g�p�̃L�[
        StringBuilder sortkey = new StringBuilder();
        String csvData = "";
        
        for(int i = 0; i < claim.size(); i++){
            sortkey = new StringBuilder();
            map = (VRMap)claim.get(i);
            csvData = "";
            //CATEGORY_NO
            //��싋�t�����
            if(map.containsKey("101001")){
                compCode = ACCastUtilities.toString(map.get("101001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("101005")) + "-" + getSortKey(map.get("101006"));
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("101002"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��(7111�Œ�)
                sortkey.append(map.get("101001"));
                sortkey.append("-");

                //���Ə��ԍ�10��
                sortkey.append(map.get("101003"));
                sortkey.append("-");
                //�ی��E����敪�R�[�h1���@1-�ی����� 2-�����
                sortkey.append(map.get("101004"));
                sortkey.append("-");
                //�@�ʔԍ�2�����ی��������̏ꍇ��0
                sortkey.append(map.get("101005"));
                sortkey.append("-");
                //�������敪�R�[�h2���@�@�ʔԍ�=0 OR 12��01-����E�{�݃T�[�r�X�@02-������x���@�@�ʔԍ�=����ȊO��0�Œ�
                sortkey.append(map.get("101006"));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeCareSupplyClaim(map);
                
            //��{��񃌃R�[�h
            } else if(map.containsKey("201001")){
                compCode = ACCastUtilities.toString(map.get("201001"));
                
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("201003"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��
                sortkey.append(map.get("201001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("201005"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("201006"));
                sortkey.append("-");                

                //���R�[�h��ʃR�[�h2��(01��ݒ�)
                sortkey.append(map.get("201002"));
                sortkey.append("-");
                //���Ə��ԍ�10��
                sortkey.append(map.get("201004"));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeBaseRecord(map);
                
            //���׏�񃌃R�[�h
            } else if(map.containsKey("301001")){
                compCode = ACCastUtilities.toString(map.get("301001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("301007")) + "-" + getSortKey(map.get("301008"));
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("301003"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��
                sortkey.append(map.get("301001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("301005"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("301006"));
                sortkey.append("-");
                
                //���R�[�h��ʃR�[�h2��(02��ݒ�)
                sortkey.append(map.get("301002"));
                sortkey.append("-");
                //���Ə��ԍ�10��
                sortkey.append(map.get("301004"));
                sortkey.append("-");
                //�T�[�r�X��ރR�[�h2��
                sortkey.append(map.get("301007"));
                sortkey.append("-");
                //�T�[�r�X���ڃR�[�h4��
                sortkey.append(map.get("301008"));
                
                //�����p��Ή�
                sortkey.append("-");
                sortkey.append(map.get("301009"));
                sortkey.append("-");
                sortkey.append(map.get("301018"));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeDetailRecord(map);
                
            //�ً}���{�ݗ×{��񃌃R�[�h
            } else if(map.containsKey("401001")){
                //�󃌃R�[�h�Ή�
                if(ACTextUtilities.isNullText(map.get("401001"))){
                    continue;
                }
                
                //add sta 2006.05.20 fujihara.shin
                if(!QP001SpecialCase.isValidRecordEmergency(map)){
                	continue;
                }
                //add end 2006.05.20 fujihara.shin
                
                compCode = ACCastUtilities.toString(map.get("401001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("401007"));
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("401003"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��
                sortkey.append(map.get("401001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("401005"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("401006"));
                sortkey.append("-");
                
                //���R�[�h��ʃR�[�h2��(03��ݒ�)
                sortkey.append(map.get("401002"));
                sortkey.append("-");
                //���Ə��ԍ�10��
                sortkey.append(map.get("401004"));
                sortkey.append("-");
                //�ً}���{�ݗ×{��񃌃R�[�h�����ԍ�2��
                sortkey.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("401007"),0)));

                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeEmergencyRecord(map);
                
            //����f�Ô��񃌃R�[�h
            } else if(map.containsKey("501001")){
                compCode = ACCastUtilities.toString(map.get("501001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("501007"));
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("501003"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��
                sortkey.append(map.get("501001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("501005"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("501006"));
                sortkey.append("-");
                
                //���R�[�h��ʃR�[�h2��(04��ݒ�)
                sortkey.append(map.get("501002"));
                sortkey.append("-");
                //���Ə��ԍ�10��
                sortkey.append(map.get("501004"));
                sortkey.append("-");
                //����f�Ô��񃌃R�[�h�����ԍ�2��
                sortkey.append(continuousnessFormat.format(ACCastUtilities.toInt(map.get("501007"),0)));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeDiagnosisRecord(map);
                
                
            //�H��(���g�p)
            } else if(map.containsKey("601001")){
                compCode = ACCastUtilities.toString(map.get("601001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO"));
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("601003"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��
                sortkey.append(map.get("601001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("601005"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("601006"));
                sortkey.append("-");
                
                //���R�[�h��ʃR�[�h2��(05��ݒ�)
                sortkey.append(map.get("601002"));
                sortkey.append("-");
                //���Ə��ԍ�10��
                sortkey.append(map.get("601004"));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = "";
                
                
            //�W�v��񃌃R�[�h
            } else if(map.containsKey("701001")){
                compCode = ACCastUtilities.toString(map.get("701001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("701007"));
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("701003"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��
                sortkey.append(map.get("701001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("701005"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("701006"));
                sortkey.append("-");
                
                //���R�[�h��ʃR�[�h2��(10��ݒ�)
                sortkey.append(map.get("701002"));
                sortkey.append("-");
                //���Ə��ԍ�10��
                sortkey.append(map.get("701004"));
                sortkey.append("-");
                //�T�[�r�X��ރR�[�h2��
                sortkey.append(map.get("701007"));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeTypeRecord(map);
                
            //��������҉��T�[�r�X��p��񃌃R�[�h
            } else if(map.containsKey("801001")){
                //2006.04.28 �S�z���p�ҕ��S�Ή�
                //���R�[�h�����ԍ���0�̃��R�[�h�͕\�����Ȃ��B
                if(ACCastUtilities.toInt(map.get("801007"),0) == 0){
                    continue;
                }
                
                compCode = ACCastUtilities.toString(map.get("801001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("801007"));
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("801003"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��
                sortkey.append(map.get("801001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("801005"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("801006"));
                sortkey.append("-");
                
                //���R�[�h��ʃR�[�h2��(11��ݒ�)
                sortkey.append(map.get("801002"));
                sortkey.append("-");
                //���Ə��ԍ�10��
                sortkey.append(map.get("801004"));
                sortkey.append("-");
                //��������҉��T�[�r�X��p��񃌃R�[�h�����ԍ�2��
                sortkey.append(continuousnessFormat.format(ACCastUtilities.toInt(map.get("801007"),0)));
                sortkey.append("-");
                //�T�[�r�X��ރR�[�h2��
                sortkey.append(map.get("801008"));
                sortkey.append("-");
                //�T�[�r�X���ڃR�[�h4��
                sortkey.append(map.get("801009"));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeNursingRecord(map);
                
            //�Љ������
            } else if(map.containsKey("901001")){
                compCode = ACCastUtilities.toString(map.get("901001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("901008"));
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("901003"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��
                sortkey.append(map.get("901001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("901005"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("901006"));
                sortkey.append("-");
                
                //���R�[�h��ʃR�[�h2��(12��ݒ�)
                sortkey.append(map.get("901002"));
                sortkey.append("-");
                //���Ə��ԍ�10��
                sortkey.append(map.get("901004"));
                sortkey.append("-");
                //�T�[�r�X��ރR�[�h2��
                sortkey.append(map.get("901008"));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeReductionRecord(map);
                
            //����T�[�r�X�v����񃌃R�[�h
            } else if(map.containsKey("1001001")){
                compCode = ACCastUtilities.toString(map.get("1001001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("1001007"));
                
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("1001004"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��(����18�N4���ȑO8121�Œ�@����18�N4���ȍ~8122�A��������8123)
                sortkey.append(map.get("1001001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("1001005"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("1001007"));
                sortkey.append("-");
                
                //���Ə��ԍ�10��
                sortkey.append(map.get("1001002"));
                sortkey.append("-");
                //�w��/��Y�������Ə��敪�R�[�h1���@1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� 5-�n�斧���^�T�[�r�X
                sortkey.append(map.get("1001003"));
                sortkey.append("-");
                
                //[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
                if ("8124,8125".indexOf(compCode) != -1) {
                	sortkey.append(continuousnessFormat.format(ACCastUtilities.toInt(map.get("1001024"),0)));
                    sortkey.append("-");
                }
                //[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
                
                //�P�ʐ��P��4��
                sortkey.append(map.get("1001006"));
                sortkey.append("-");
                //����S�Ҕԍ�8��
                sortkey.append(map.get("1001008"));
                sortkey.append("-");
                //����󋋎Ҕԍ�7��
                sortkey.append(map.get("1001009"));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeCarePlanCSV(map);
                
            //���g�p
            } else if(map.containsKey("1101001")){
                compCode = ACCastUtilities.toString(map.get("1101001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO"));
                //��o�N��6��(YYYYMM)
                sortkey.append(map.get("1101002"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��(8211�Œ�)
                sortkey.append(map.get("1101001"));
                sortkey.append("-");
                
                //�ی��Ҕԍ�8��
                sortkey.append(map.get("1101003"));
                sortkey.append("-");
                //���Ə��ԍ�10��(������x�����Ə�)
                sortkey.append(map.get("1101004"));
                sortkey.append("-");
                //����T�[�r�X�v��쐬�敪�R�[�h1���@1-������x�����Ə��쐬 2-���ȍ쐬
                sortkey.append(map.get("1101005"));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = "";
                
            //���t�Ǘ��[
            } else if(map.containsKey("1201001")){
            	// add sta 2006.5.11 shin.fujihara
            	if(targetDate == null){
            		continue;
            	}
            	// add end 2006.5.11
            	
                compCode = ACCastUtilities.toString(map.get("1201001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("1201008"));
                //�Ώ۔N��6��(YYYYMM)
                sortkey.append(map.get("1201002"));
                sortkey.append("-");
                //���t�Ǘ��[���쐬�敪�R�[�h��ǉ�����B
                map.put("1201005",kubunCode);
                //������񎯕ʔԍ�4��(����18�N4���ȑO8221�Œ�@����18�N4���ȍ~8222�Œ�)
                sortkey.append(map.get("1201001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("1201003"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("1201009"));
                sortkey.append("-");
                
                //���Ə��ԍ�10��(������x�����Ə��A�������͉��\�h�x�����Ə�)
                sortkey.append(map.get("1201004"));
                sortkey.append("-");
                //���t�Ǘ��[���쐬�敪�R�[�h1���@1-�V�K 2-�C�� 3-���
                sortkey.append(map.get("1201005"));
                sortkey.append("-");
                //���t�Ǘ��[�쐬�N����8��(YYYYMMDD)
                sortkey.append(map.get("1201006"));
                sortkey.append("-");
                //���t�Ǘ��[��ʋ敪�R�[�h1���@1-�K��ʏ��T�[�r�X���t�Ǘ��[ 2-�Z�������T�[�r�X���t�Ǘ��[ 3-����T�[�r�X�敪���t�Ǘ��[
                sortkey.append(map.get("1201007"));
                sortkey.append("-");
                //���t�Ǘ��[���׍s�ԍ�2��
                sortkey.append(map.get("1201008"));
                
                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeSupplyManagementCSV(map,targetDate);
                
            //�ً}���{�ݗ×{�E���{�ݗ×{���񃌃R�[�h
            } else if(map.containsKey("1701001")){
                //�󃌃R�[�h�Ή�
                if(ACTextUtilities.isNullText(map.get("1701001"))){
                    continue;
                }
                
                if(!QP001SpecialCase.isValidRecordEmergencyOwnFacility(map)){
                    continue;
                }
                
                compCode = ACCastUtilities.toString(map.get("1701001"));
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                sortkey.append(map.get("1701003"));
                sortkey.append("-");
                //������񎯕ʔԍ�4��
                sortkey.append(map.get("1701001"));
                sortkey.append("-");
                //�؋L�ڕی��Ҕԍ�8��
                sortkey.append(map.get("1701005"));
                sortkey.append("-");
                //��ی��Ҕԍ�10��
                sortkey.append(map.get("1701006"));
                sortkey.append("-");
                
                //���R�[�h��ʃR�[�h2��(03��ݒ�)
                sortkey.append(map.get("1701002"));
                sortkey.append("-");
                //���Ə��ԍ�10��
                sortkey.append(map.get("1701004"));
                sortkey.append("-");
                //�ً}���{�ݗ×{��񃌃R�[�h�����ԍ�2��
                sortkey.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("1701007"),0)));

                //CSV�o�͗p�̃f�[�^�𐶐�
                csvData = makeEmergencyOwnFacilityRecord(map);
                
            }
 // 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
            //���׏��i�Z���n����j���R�[�h
	          else if(map.containsKey("1801001")){
	            compCode = ACCastUtilities.toString(map.get("1801001"));
	            
	            //�T�[�r�X�񋟔N��6��(YYYYMM)
	            sortkey.append(map.get("1801003"));
	            sortkey.append("-");
	            //������񎯕ʔԍ�4��
	            sortkey.append(map.get("1801001"));
	            sortkey.append("-");
	            //�؋L�ڕی��Ҕԍ�8��
	            sortkey.append(map.get("1801005"));
	            sortkey.append("-");
	            //��ی��Ҕԍ�10��
	            sortkey.append(map.get("1801006"));
	            sortkey.append("-");
	            
	            //���R�[�h��ʃR�[�h2��(14��ݒ�)
	            sortkey.append(map.get("1801002"));
	            sortkey.append("-");
	            //���Ə��ԍ�10��
	            sortkey.append(map.get("1801004"));
	            sortkey.append("-");
	            //�T�[�r�X��ރR�[�h2��
	            sortkey.append(map.get("1801007"));
	            sortkey.append("-");
	            //�T�[�r�X���ڃR�[�h4��
	            sortkey.append(map.get("1801008"));
	            
	            //�����p��Ή�
	            sortkey.append("-");
	            sortkey.append(map.get("1801009"));
	            sortkey.append("-");
	            sortkey.append(map.get("1801019"));
	            
	            //CSV�o�͗p�̃f�[�^�𐶐�
	            csvData = makeDetailJushotiTokureiRecord(map);
// 2014/12/24 [Yoichiro Kamei] add - end
	        } else {
            	continue;
            }
            
            //�l�Ɣ�r
            if(code.indexOf(compCode) != -1){
                claimCSVList.add(new String[]{sortkey.toString(),csvData});
            }
        }
    }
    
    /**
     * CSV�t�@�C���̍쐬���s���B
     * @param clime_temp
     * @param claimDate
     * @param settings
     * @return
     * @throws Exception
     */
    private String makeCSV(List clime_temp,Date claimDate,VRMap settings,Date claimTargetDate) throws Exception {
        //char crlf = 0x0D0A;
        String crlf = String.valueOf(new char[]{0x0D,0x0A});
        // CSV�t�@�C�����쐬����B
        // �t�@�C���֏o�͂��镶����ޔ�z��StringBuilder sb �𐶐�����B
        StringBuilder sb = new StringBuilder();
        
        //1�t�@�C���ɏo�͂����f�[�^����
        int dataCount = 1;
        //���R�[�h�ʂ��ԍ�
        int recordCount = 2;
        int controlRecordCount = 1;
        
        int fdCount = 1;
        int baitai = 0;
        
        //�t�@�C�����̖����K���́AFD/CD-R:f MO:m �`��(ISDN):d �`��(�C���^�[�l�b�g):i(�a��N��)(�A���t�@�x�b�ga-).csv
        String fileNameHeader = csvFileNameFormat.format(new Date());
        switch(ACCastUtilities.toInt(VRBindPathParser.get("MEDIUM_DIVISION",settings))){
            //FD�^CD-R
            case 1:
                fileNameHeader = "f" + fileNameHeader;
                baitai = 4;
                break;
            //MO
            case 2:
                fileNameHeader = "m" + fileNameHeader;
                baitai = 2;
                break;
            //�`���iISDN�j
            case 3:
                fileNameHeader = "d" + fileNameHeader;
                baitai = 1;
                break;
            //[CCCX:1938][Shinobu Hitaka] 2014/10 edit begin ����26�N11���C���^�[�l�b�g�����J�n�Ή�
            //�`���i�C���^�[�l�b�g�j
            case 4:
                fileNameHeader = "i" + fileNameHeader;
                baitai = 7;
                break;
            //[CCCX:1938][Shinobu Hitaka] 2014/10 edit end   ����26�N11���C���^�[�l�b�g�����J�n�Ή�
        }
        
        
        //FD���I������Ă��邩�t���O
        boolean fdSelect = (ACCastUtilities.toInt(settings.get("MEDIUM_DIVISION")) == 1);
        int maxFileSize = 1024 * 1024;
        //int maxFileSize = 1024 * 5;
        
        String filePath = ACCastUtilities.toString(settings.get("FILE_PATH"));
        
        //File file = new File(filePath, fileNameHeader + String.valueOf((char)(0x60 + fileCount)) + ".csv");
        File file = getNewFile(filePath,fileNameHeader);
        OutputStreamWriter objOsr=new OutputStreamWriter(new FileOutputStream(file),"MS932");
        BufferedWriter objBw=new BufferedWriter(objOsr);
        
        try{
            // sb�̐擪�Ɉȉ��̕������ǉ�����B
            //FD���I������Ă��Ȃ����
            if(!fdSelect){
                //�w�b�_���R�[�h�쐬
                sb.append(getControlRecord(controlRecordCount,0,clime_temp.size(),baitai,claimDate) + crlf);
            }
            
            //clime_temp�̐������[�v����B
            for(int i = 0; i < clime_temp.size(); i++,recordCount++,dataCount++){
                String[] data = (String[])clime_temp.get(i);
                
                //�f�[�^��StringBuilder�ɑޔ�����B
                sb.append("2," + recordCount + "," + data[1] + crlf);
                
                //FD���I������Ă���ꍇ
                if(fdSelect && ((i % 1000) == 0)){
                    
                    //�o�͂����e�ʂ��`�F�b�N����B
                    //�e�ʂ�FD�T�C�Y�𒴂������Ȃ��
                    if(sb.toString().getBytes().length > maxFileSize){
                        sb.insert(0,getControlRecord(controlRecordCount,fdCount-1,dataCount,baitai,claimDate) + crlf);
                        
                        //��U�t�@�C���ɏo��
                        objBw.write(sb.toString());
                        
                        sb = new StringBuilder();
                        
                        //�t�@�C�����N���[�Y����
                        objBw.close();
                        
                        recordCount++;
                        dataCount = 0;
                        fdCount++;
                        
                        //���̃t���[���s�[�f�B�X�N��}�����Ă��������B
                        //"�P���ڂ̃t���b�s�[��}�����ĉ������B"
                        VRMap messageMap = new VRHashMap();
                        messageMap.put("count",String.valueOf(fdCount));
                        QkanMessageList.getInstance().QP001_NEXT_FD(messageMap);
                        
                        //�V�K�t�@�C�����I�[�v������
                        // �t�@�C�����̖����K���́Ad(�a��N��)(�A���t�@�x�b�ga-).csv
                        file = getNewFile(filePath,fileNameHeader);
                        objOsr = new OutputStreamWriter(new FileOutputStream(file),"MS932");
                        objBw = new BufferedWriter(objOsr);
                        controlRecordCount=recordCount;

                    }
                }
                
            }
            
            
            if(fdSelect){
                sb.insert(0,getControlRecord(controlRecordCount,fdCount-1,dataCount - 1,baitai,claimDate) + crlf);
            }
            
            //�������t�@�C�����o�͂����ꍇ�ł��A�Ō�ɏo�͂����t�@�C���̖��[�݂̂ɕt������B
            // sb�̍Ō�Ɉȉ��̕������ǉ�����B
            // ���R�[�h���3
            sb.append("3");
            // �J���}(,)
            sb.append(",");
            // ���R�[�h�ԍ�(�A��)
            //sb.append(recordNoFormat.format((long)(recordCount)));
            sb.append(recordCount);
            // ���s�R�[�h(0x0D0A)
            sb.append(crlf);
            
            objBw.write(sb.toString());
            
            // �t�@�C���ɏo�͂���B
            objBw.close();
        
        } catch (Exception e){
            // �t�@�C���o�͎��̃G���[
            return null;
        }
        return file.getAbsolutePath();
    }
    
    /**
     * CSV�o�͂Ɏg�p����t�@�C���I�u�W�F�N�g���擾���܂��B
     * @return
     * @throws Exception
     */
    private File getNewFile(String filePath,String fileNameHeader) throws Exception {
        File file = null;
//        for(int fileNameOption = 1;;fileNameOption++){
//            file = new File(filePath, fileNameHeader + String.valueOf((char)(0x60 + fileNameOption)) + ".csv");
//            //�쐬����Ă��Ȃ��t�@�C����T��
//            if(!file.exists()){
//                break;
//            }
//        }
        // ������z�ȏ�̃t�@�C�����쐬���Ȃ��悤�C��
        for(int fileNameOption = 0;fileNameOption < 26;fileNameOption++){
            file = new File(filePath, fileNameHeader + String.valueOf((char)(0x61 + fileNameOption)) + ".csv");
            //�쐬����Ă��Ȃ��t�@�C����T��
            if(!file.exists()){
                break;
            }
        }
        return file;
    }
    
    /**
     * CSV�t�@�C���̃R���g���[�����R�[�h���쐬���܂��B
     * @param recordCount
     * @param volume
     * @param size
     * @param baitai
     * @param claimDate
     * @return
     * @throws Exception
     */
    public String getControlRecord(int recordCount,int volume,int size,int baitai,Date claimDate) throws Exception {
        StringBuilder sb = new StringBuilder();
        //�R���g���[�����R�[�h������1
        sb.append("1");
        // �J���}(,)
        sb.append(",");
        // ���R�[�h�ԍ�0000000001
        //sb.append(recordNoFormat.format((long)recordCount));
        sb.append(recordCount);
        // �J���}(,)
        sb.append(",");
        // �{�����[���ʂ��ԍ�000
        //sb.append(fileCountFormat.format((long)volume));
        sb.append(volume);
        // �J���}(,)
        sb.append(",");
        // ���R�[�h����
        sb.append(size);
        // �J���}(,)
        sb.append(",");
        // �f�[�^���
        sb.append(dataType);
        // �J���}(,)
        sb.append(",");
        // ��������������ԍ�0
        sb.append("0");
        // �J���}(,)
        sb.append(",");
        // �ی��Ҕԍ�(""�ł�����)
        sb.append("000000");
        // �J���}(,)
        sb.append(",");
        // ���Ə��ԍ�
        sb.append(QkanSystemInformation.getInstance().getLoginProviderID());
        // �J���}(,)
        sb.append(",");
        // �s���{���ԍ�
        //sb.append(QkanSystemInformation.getInstance().getLoginProviderID().substring(0,2));
        sb.append("00");
        // �J���}(,)
        sb.append(",");
        // �}�̋敪("1":�`��(ISDN) "2":MO "4":FD/CD-R "7":�`��(�C���^�[�l�b�g))
        sb.append(baitai);
        // �J���}(,)
        sb.append(",");
        // �����Ώی�
        sb.append(VRDateParser.format(claimDate,"yyyyMM"));
        // �J���}(,)
        sb.append(",");
        // �t�@�C���Ǘ��敪000000
        sb.append("0");
        
        
        return sb.toString();
    }
    
    /**
     * �u��싋�t��׏���CSV�t�@�C���쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public String makeCareSupplyClaim(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        //������x���t���O
        //0:��������ҁ@�����E��p���v�E������z���o��
        //1:��������ҁ@�S�ďo��
        //2:��������ҁ@���o��
        int tokuteiOut = 0;
        
        //����E�{�݃T�[�r�X ���\�h�T�[�r�X �n�斧���^�T�[�r�X���ł���΁A����f�Ô�����o�͂���B
        if ("1".equals(getData(map, "101004"))
                && "00".equals(getData(map, "101005"))
                && "01".equals(getData(map, "101006"))) {
            tokuteiOut = 1;
        }
        
        if ("1".equals(getData(map, "101004"))
                && "00".equals(getData(map, "101005"))
                && "02".equals(getData(map, "101006"))) {
            tokuteiOut = 2;
        }
        
        if ("2".equals(getData(map, "101004"))
                && "12".equals(getData(map, "101005"))
                && "02".equals(getData(map, "101006"))) {
            tokuteiOut = 3;
        }
        
        //�ȉ��̕�������J���}��؂�Ő�������B
        // ������񎯕ʔԍ�4��(7111�Œ�)
        sb.append("\"");
        sb.append(getData(map,"101001"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        sb.append(getData(map,"101002"));
        sb.append(spliter);
        // ���Ə��ԍ�10��
        sb.append(getData(map,"101003"));
        sb.append(spliter);
        // �ی��E����敪�R�[�h1���@1-�ی����� 2-�����
        sb.append(getData(map,"101004"));
        sb.append(spliter);
        // �@�ʔԍ�2�����ی��������̏ꍇ��0
        sb.append(getData(map,"101005"));
        sb.append(spliter);
        // �������敪�R�[�h2���@�@�ʔԍ�=0 OR 12��01-����E�{�݃T�[�r�X�@02-������x���@�@�ʔԍ�=����ȊO��0�Œ�
        sb.append(getData(map,"101006"));
        sb.append(spliter);
        
        // (�T�[�r�X��p)����6��
        sb.append(getData(map,"101007"));
        sb.append(spliter);
        // (�T�[�r�X��p)�P�ʐ�11��
        sb.append(getData(map,"101008"));
        sb.append(spliter);
        //(�T�[�r�X��p)��p���v12�� 
        sb.append(getData(map,"101009"));
        sb.append(spliter);
        
        switch(tokuteiOut){
        //0:��������ҁ@�����E��p���v�E������z���o��
        case 0:
            // (�T�[�r�X��p)�ی������z12��
            //sb.append(getData(map,"101010"));
            sb.append("0");
            sb.append(spliter);
            // (�T�[�r�X��p)������z12��
            sb.append(getData(map,"101011"));
            sb.append(spliter);
            // (�T�[�r�X��p)���p�ҕ��S12��
            sb.append("0");
            sb.append(spliter);
            
            // (��������҉��T�[�r�X�)����6��
            sb.append(getData(map,"101013"));
            sb.append(spliter);
            // (��������Ҍ�T�[�r�X�)���ד���8��
            //����17�N10���ȍ~�͐ݒ�s�v
            //sb.append(getData(map,"101014"));
            sb.append(spliter);
            
            // (��������҉��T�[�r�X�)��p���v12��
            sb.append(getData(map,"101015"));
            sb.append(spliter);
            // (��������҉��T�[�r�X�)���p�ҕ��S12��
            sb.append("0");
            sb.append(spliter);
            // (��������҉��T�[�r�X�)������z12��
            sb.append(getData(map,"101017"));
            sb.append(spliter);
            // (��������҉�T�[�r�X�)�ی������z12��
            sb.append("0");
            sb.append("\"");
            break;
            
        //1:��������ҁ@�S�ďo��
        case 1:
            // (�T�[�r�X��p)�ی������z12��
            sb.append(getData(map,"101010"));
            sb.append(spliter);
            // (�T�[�r�X��p)������z12��
            sb.append(getData(map,"101011"));
            sb.append(spliter);
            // (�T�[�r�X��p)���p�ҕ��S12��
            sb.append(getData(map,"101012"));
            sb.append(spliter);
            
            // (��������҉��T�[�r�X�)����6��
            sb.append(getData(map,"101013"));
            sb.append(spliter);
            // (��������Ҍ�T�[�r�X�)���ד���8��
            //����17�N10���ȍ~�͐ݒ�s�v
            //sb.append(getData(map,"101014"));
            sb.append(spliter);
            
            // (��������҉��T�[�r�X�)��p���v12��
            sb.append(getData(map,"101015"));
            sb.append(spliter);
            // (��������҉��T�[�r�X�)���p�ҕ��S12��
            sb.append(getData(map,"101016"));
            sb.append(spliter);
            // (��������҉��T�[�r�X�)������z12��
            sb.append(getData(map,"101017"));
            sb.append(spliter);
            // (��������҉�T�[�r�X�)�ی������z12��
            sb.append(getData(map,"101018"));
            sb.append("\"");
            break;
            
        //2:��������ҁ@���o��
        case 2:
            // (�T�[�r�X��p)�ی������z12��
            sb.append(getData(map,"101010"));
            sb.append(spliter);
            // (�T�[�r�X��p)������z12��
            sb.append(getData(map,"101011"));
            sb.append(spliter);
            // (�T�[�r�X��p)���p�ҕ��S12��
            sb.append(getData(map,"101012"));
            sb.append(spliter);
            
            // (��������҉��T�[�r�X�)����6��
            sb.append(spliter);
            // (��������Ҍ�T�[�r�X�)���ד���8��
            //����17�N10���ȍ~�͐ݒ�s�v
            //sb.append(getData(map,"101014"));
            sb.append(spliter);
            
            // (��������҉��T�[�r�X�)��p���v12��
            sb.append(spliter);
            // (��������҉��T�[�r�X�)���p�ҕ��S12��
            sb.append(spliter);
            // (��������҉��T�[�r�X�)������z12��
            sb.append(spliter);
            // (��������҉�T�[�r�X�)�ی������z12��
            sb.append("\"");
            break;
            
        //3:��������ҁ@���o��+�T�[�r�X��p�̕ی��E���p�ҕ��S��0�o��
        case 3:
            // (�T�[�r�X��p)�ی������z12��
            sb.append("0");
            sb.append(spliter);
            // (�T�[�r�X��p)������z12��
            sb.append(getData(map,"101011"));
            sb.append(spliter);
            // (�T�[�r�X��p)���p�ҕ��S12��
            sb.append("0");
            sb.append(spliter);
            
            // (��������҉��T�[�r�X�)����6��
            sb.append(spliter);
            // (��������Ҍ�T�[�r�X�)���ד���8��
            //����17�N10���ȍ~�͐ݒ�s�v
            //sb.append(getData(map,"101014"));
            sb.append(spliter);
            
            // (��������҉��T�[�r�X�)��p���v12��
            sb.append(spliter);
            // (��������҉��T�[�r�X�)���p�ҕ��S12��
            sb.append(spliter);
            // (��������҉��T�[�r�X�)������z12��
            sb.append(spliter);
            // (��������҉�T�[�r�X�)�ی������z12��
            sb.append("\"");
            break;
        }
        
        return sb.toString();

    }

    /**
     * �u��{��񃌃R�[�h�f�[�^������쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public String makeBaseRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // ������񎯕ʔԍ�4��(SYSTEM_BIND_PATH:201001)
        sb.append("\"");
        sb.append(getData(map,"201001"));
        sb.append(spliter);
        // ���R�[�h��ʃR�[�h2��(SYSTEM_BIND_PATH:201002)
        sb.append(getData(map,"201002"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(SYSTEM_BIND_PATH:201003)
        sb.append(getData(map,"201003"));
        sb.append(spliter);
        // ���Ə��ԍ�10��(SYSTEM_BIND_PATH:201004)
        sb.append(getData(map,"201004"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��(SYSTEM_BIND_PATH:201005)
        //sb.append(getData(map,"201005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"201005"),0)));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��(SYSTEM_BIND_PATH:201006)
        sb.append(getData(map,"201006"));
        sb.append(spliter);
        // (����1)���S�Ҕԍ�8��(SYSTEM_BIND_PATH:201007)
        sb.append(getData(map,"201007"));
        sb.append(spliter);
        // (����1)�󋋎Ҕԍ�7��(SYSTEM_BIND_PATH:201008)
        sb.append(getData(map,"201008"));
        sb.append(spliter);
        // (����2)���S�Ҕԍ�8��(SYSTEM_BIND_PATH:201009)
        sb.append(getData(map,"201009"));
        sb.append(spliter);
        // (����2)�󋋎Ҕԍ�7��(SYSTEM_BIND_PATH:201010)
        sb.append(getData(map,"201010"));
        sb.append(spliter);
        // (����3)���S�Ҕԍ�8��(SYSTEM_BIND_PATH:201011)
        sb.append(getData(map,"201011"));
        sb.append(spliter);
        // (����3)�󋋎Ҕԍ�7��(SYSTEM_BIND_PATH:201012)
        sb.append(getData(map,"201012"));
        sb.append(spliter);
        // (��ی��ҏ��)���N����8��YYYYMMDD(SYSTEM_BIND_PATH:201013)
        sb.append(getData(map,"201013"));
        sb.append(spliter);
        // (��ی��ҏ��)���ʃR�[�h1��(SYSTEM_BIND_PATH:201014)
        sb.append(getData(map,"201014"));
        sb.append(spliter);
        // (��ی��ҏ��)�v����ԋ敪�R�[�h2��(SYSTEM_BIND_PATH:201015)
        sb.append(getData(map,"201015"));
        sb.append(spliter);
        // (��ی��ҏ��)���[�u�����ғ���R�[�h1��(SYSTEM_BIND_PATH:201016)
        //�l���攪�̂ݏo��
        if("7183".equals(String.valueOf(map.get("201001")))){
            sb.append(getData(map,"201016"));
        }
        sb.append(spliter);
        // (��ی��ҏ��)�F��L������ �J�n�N����8��(YYYYMMDD)(SYSTEM_BIND_PATH:201017)
        sb.append(getData(map,"201017"));
        sb.append(spliter);
        // (��ی��ҏ��)�F��L������ �I���N����8��(YYYYMMDD)(SYSTEM_BIND_PATH:201018)
        sb.append(getData(map,"201018"));
        sb.append(spliter);
        // (����T�[�r�X�v��)����T�[�r�X�v��쐬�敪�R�[�h(SYSTEM_BIND_PATH:201019)
        if(ACCastUtilities.toInt(map.get("201019"),0) != 0){
            sb.append(getData(map,"201019"));
        }
        sb.append(spliter);
        if(QP001SpecialCase.isServicePlanMakerLiving(getData(map,"201001"))){
            // (����T�[�r�X�v��)���Ə��ԍ�10��(������x�����Ə�)(SYSTEM_BIND_PATH:201020)
            sb.append(getData(map,"201020"));
        }
        sb.append(spliter);
        // �J�n�N����8��(YYYYMMDD)(SYSTEM_BIND_PATH:201021)
        sb.append(getData(map,"201021"));
        sb.append(spliter);
        // ���~�N����8��(YYYYMMDD)(SYSTEM_BIND_PATH:201022)
        sb.append(getData(map,"201022"));
        sb.append(spliter);
        // ���~���R�R�[�h1��(SYSTEM_BIND_PATH:201023)
        if(ACCastUtilities.toInt(map.get("201023"),0) != 0){
            sb.append(getData(map,"201023"));
        }
        sb.append(spliter);
        // ����(�@)�N����8��(YYYYMMDD)(SYSTEM_BIND_PATH:201024)
        sb.append(getData(map,"201024"));
        sb.append(spliter);
        // �ޏ�(�@)�N����8��(YYYYMMDD)(SYSTEM_BIND_PATH:201025)
        sb.append(getData(map,"201025"));
        sb.append(spliter);
        // ����(�@)������2��(SYSTEM_BIND_PATH:201026)
        if(ACTextUtilities.isNullText(getData(map,"201026"))){
            sb.append("0");
        } else {
            sb.append(getData(map,"201026"));
        }
        sb.append(spliter);
        // �O������2��(SYSTEM_BIND_PATH:201027)
        if(ACTextUtilities.isNullText(getData(map,"201027"))){
            sb.append("0");
        } else {
            sb.append(getData(map,"201027"));
        }
        sb.append(spliter);
        // �ޏ�(�@)��̏�ԃR�[�h1��(SYSTEM_BIND_PATH:201028)
        if(ACCastUtilities.toInt(map.get("201028"),0) != 0){
            sb.append(getData(map,"201028"));
        }
        sb.append(spliter);
        // �ی����t��3��(SYSTEM_BIND_PATH:201029)
        sb.append(getData(map,"201029"));
        sb.append(spliter);
        // ����1���t��(SYSTEM_BIND_PATH:201030)
        sb.append(getData(map,"201030"));
        sb.append(spliter);
        // ����2���t��(SYSTEM_BIND_PATH:201031)
        sb.append(getData(map,"201031"));
        sb.append(spliter);
        // ����3���t��(SYSTEM_BIND_PATH:201032)
        sb.append(getData(map,"201032"));
        sb.append(spliter);
        // (���v��� �ی�)�T�[�r�X�P�ʐ�8��(SYSTEM_BIND_PATH:201033)
        sb.append(getData(map,"201033"));
        sb.append(spliter);
        // (���v��� �ی�)�����z9��(SYSTEM_BIND_PATH:201034)
        sb.append(getData(map,"201034"));
        sb.append(spliter);
        // (���v��� �ی�)���p�ҕ��S�z8��(SYSTEM_BIND_PATH:201035)
        sb.append(getData(map,"201035"));
        sb.append(spliter);
        // (���v��� �ی�)�ً}���{�ݗ×{����z9��(SYSTEM_BIND_PATH:201036)
        sb.append(getData(map,"201036"));
        sb.append(spliter);
        // (���v��� �ی�)����f�Ô���z9��(SYSTEM_BIND_PATH:201037)
        sb.append(getData(map,"201037"));
        sb.append(spliter);
        // (���v��� �ی�)��������҉��T�[�r�X������z8��(SYSTEM_BIND_PATH:201038)
        sb.append(getData(map,"201038"));
        sb.append(spliter);
        // (���v��� ����1)�T�[�r�X�P�ʐ�8��(SYSTEM_BIND_PATH:201039)
        sb.append(getData(map,"201039"));
        sb.append(spliter);
        // (���v��� ����1)�����z8��(SYSTEM_BIND_PATH:201040)
        sb.append(getData(map,"201040"));
        sb.append(spliter);
        // (���v��� ����1)�{�l���S�z8��(SYSTEM_BIND_PATH:201041)
        sb.append(getData(map,"201041"));
        sb.append(spliter);
        // (���v��� ����1)�ً}���{�ݗ×{����z8��(SYSTEM_BIND_PATH:201042)
        sb.append(getData(map,"201042"));
        sb.append(spliter);
        // (���v��� ����1)����f�Ô���z8��(SYSTEM_BIND_PATH:201043)
        sb.append(getData(map,"201043"));
        sb.append(spliter);
        // (���v��� ����1)��������҉��T�[�r�X������z8��(SYSTEM_BIND_PATH:201044)
        sb.append(getData(map,"201044"));
        sb.append(spliter);
        // (���v��� ����2)�T�[�r�X�P�ʐ�8��(SYSTEM_BIND_PATH:201045)
        sb.append(getData(map,"201045"));
        sb.append(spliter);
        // (���v��� ����2)�����z8��(SYSTEM_BIND_PATH:201046)
        sb.append(getData(map,"201046"));
        sb.append(spliter);
        // (���v��� ����2)�{�l���S�z8��(SYSTEM_BIND_PATH:201047)
        sb.append(getData(map,"201047"));
        sb.append(spliter);
        // (���v��� ����2)�ً}���{�ݗ×{����z8��(SYSTEM_BIND_PATH:201048)
        sb.append(getData(map,"201048"));
        sb.append(spliter);
        // (���v��� ����2)����f�Ô���z8��(SYSTEM_BIND_PATH:201049)
        sb.append(getData(map,"201049"));
        sb.append(spliter);
        // (���v��� ����2)��������҉��T�[�r�X������z8��(SYSTEM_BIND_PATH:201050)
        sb.append(getData(map,"201050"));
        sb.append(spliter);
        // (���v��� ����3)�T�[�r�X�P�ʐ�8��(SYSTEM_BIND_PATH:201051)
        sb.append(getData(map,"201051"));
        sb.append(spliter);
        // (���v��� ����3)�����z8��(SYSTEM_BIND_PATH:201052)
        sb.append(getData(map,"201052"));
        sb.append(spliter);
        // (���v��� ����3)�{�l���S�z8��(SYSTEM_BIND_PATH:201053)
        sb.append(getData(map,"201053"));
        sb.append(spliter);
        // (���v��� ����3)�ً}���{�ݗ×{����z8��(SYSTEM_BIND_PATH:201054)
        sb.append(getData(map,"201054"));
        sb.append(spliter);
        // (���v��� ����3)����f�Ô���z8��(SYSTEM_BIND_PATH:201055)
        sb.append(getData(map,"201055"));
        sb.append(spliter);
        // (���v��� ����3)��������҉��T�[�r�X������z8��(SYSTEM_BIND_PATH:201056)
        sb.append(getData(map,"201056"));
        sb.append("\"");
        
//        sb.append(",");
//        // ����T�[�r�X�v��Ҏ��Ə���(SYSTEM_BIND_PATH:201057)
//        sb.append(map.get("201057"));
//        sb.append(",");
//        // ����1 ������(KOHI_TYPE)(SYSTEM_BIND_PATH:201058)
//        sb.append(map.get("201058"));
//        sb.append(",");
//        // ����2 ������(KOHI_TYPE)(SYSTEM_BIND_PATH:201059)
//        sb.append(map.get("201059"));
//        sb.append(",");
//        // ����3 ������(KOHI_TYPE)(SYSTEM_BIND_PATH:201060)
//        sb.append(map.get("201060"));
        
        return sb.toString();
    }

    /**
     * �u���׏�񃌃R�[�h�f�[�^������쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public String makeDetailRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // �ȉ��̕�������J���}��؂�Ő�������B
        // ������񎯕ʔԍ�4��(SYSTEM_BIND_PATH:301001)
        sb.append("\"");
        sb.append(getData(map,"301001"));
        sb.append(spliter);
        // ���R�[�h��ʃR�[�h2��(SYSTEM_BIND_PATH:301002)
        sb.append(getData(map,"301002"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(YYYYMM)(SYSTEM_BIND_PATH:301003)
        sb.append(getData(map,"301003"));
        sb.append(spliter);
        // ���Ə��ԍ�10��(SYSTEM_BIND_PATH:301004)
        sb.append(getData(map,"301004"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��(SYSTEM_BIND_PATH:301005)
        //sb.append(getData(map,"301005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"301005"),0)));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��(SYSTEM_BIND_PATH:301006)
        sb.append(getData(map,"301006"));
        sb.append(spliter);
        // �T�[�r�X��ރR�[�h2��(SYSTEM_BIND_PATH:301007)
        sb.append(getData(map,"301007"));
        sb.append(spliter);
        // �T�[�r�X���ڃR�[�h4��(SYSTEM_BIND_PATH:301008)
        sb.append(getData(map,"301008"));
        sb.append(spliter);
        //�P�ʐ����L�ڂ��Ȃ��T�[�r�X�łȂ��ꍇ�A�P�ʐ����o�͂���B
        if(!QP001SpecialCase.isUnitNoCountService(getData(map,"301007"),getData(map,"301008"))){
            // �P�ʐ�4��(SYSTEM_BIND_PATH:301009)
            sb.append(getData(map,"301009"));
        }
        sb.append(spliter);
        // �������2��(SYSTEM_BIND_PATH:301010)
        sb.append(getData(map,"301010"));
        sb.append(spliter);
        // ����1�Ώۓ����E��2��(SYSTEM_BIND_PATH:301011)
        sb.append(getData(map,"301011"));
        sb.append(spliter);
        // ����2�Ώۓ����E��2��(SYSTEM_BIND_PATH:301012)
        sb.append(getData(map,"301012"));
        sb.append(spliter);
        // ����3�Ώۓ����E��2��(SYSTEM_BIND_PATH:301013)
        sb.append(getData(map,"301013"));
        sb.append(spliter);
        // �T�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:301014)
        sb.append(getData(map,"301014"));
        sb.append(spliter);
        // ����1�ΏۃT�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:301015)
        sb.append(getData(map,"301015"));
        sb.append(spliter);
        // ����2�ΏۃT�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:301016)
        sb.append(getData(map,"301016"));
        sb.append(spliter);
        // ����3�ΏۃT�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:301017)
        sb.append(getData(map,"301017"));
        sb.append(spliter);
        // �E�v20��(SYSTEM_BIND_PATH:301018)
        sb.append(getData(map,"301018"));
        sb.append("\"");
        
        return sb.toString();
    }

    /**
     * �u�ً}���{�ݗ×{��񃌃R�[�h�f�[�^������쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public String makeEmergencyRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // �ȉ��̕�������J���}��؂�Ő�������B
        // ������񎯕ʔԍ�4��(SYSTEM_BIND_PATH:401001)
        sb.append("\"");
        sb.append(getData(map,"401001"));
        sb.append(spliter);
        // ���R�[�h��ʃR�[�h2��(SYSTEM_BIND_PATH:401002)
        sb.append(getData(map,"401002"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(YYYYMM)(SYSTEM_BIND_PATH:401003)
        sb.append(getData(map,"401003"));
        sb.append(spliter);
        // ���Ə��ԍ�10��(SYSTEM_BIND_PATH:401004)
        sb.append(getData(map,"401004"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��(SYSTEM_BIND_PATH:401005)
        //sb.append(getData(map,"401005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"401005"),0)));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��(SYSTEM_BIND_PATH:401006)
        sb.append(getData(map,"401006"));
        sb.append(spliter);
        // �ً}���{�ݗ×{��񃌃R�[�h�����ԍ�2��(SYSTEM_BIND_PATH:401007)
        sb.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("401007"))));
        sb.append(spliter);
        // �ً}�����a��1 40��(SYSTEM_BIND_PATH:401008)
        sb.append(getData(map,"401008"));
        sb.append(spliter);
        // �ً}�����a��2 40��(SYSTEM_BIND_PATH:401009)
        sb.append(getData(map,"401009"));
        sb.append(spliter);
        // �ً}�����a��3 40��(SYSTEM_BIND_PATH:401010)
        sb.append(getData(map,"401010"));
        sb.append(spliter);
        // �ً}�����ÊJ�n�N����1 8��(YYYYMMDD)(SYSTEM_BIND_PATH:401011)
        sb.append(getData(map,"401011"));
        sb.append(spliter);
        // �ً}�����ÊJ�n�N����2 8��(YYYYMMDD)(SYSTEM_BIND_PATH:401012)
        sb.append(getData(map,"401012"));
        sb.append(spliter);
        // �ً}�����ÊJ�n�N����3 8��(YYYYMMDD)(SYSTEM_BIND_PATH:401013)
        sb.append(getData(map,"401013"));
        sb.append(spliter);
        // ���f����2��(SYSTEM_BIND_PATH:401014)
        sb.append(getData(map,"401014"));
        sb.append(spliter);
        // ���f��Ë@�֖�40��(SYSTEM_BIND_PATH:401015)
        sb.append(getData(map,"401015"));
        sb.append(spliter);
        // �ʉ@����2��(SYSTEM_BIND_PATH:401016)
        sb.append(getData(map,"401016"));
        sb.append(spliter);
        // �ʉ@��Ë@�֖�40��(SYSTEM_BIND_PATH:401017)
        sb.append(getData(map,"401017"));
        sb.append(spliter);
        // �ً}�����ÊǗ��P�ʐ�6��(SYSTEM_BIND_PATH:401018)
        sb.append(getData(map,"401018"));
        sb.append(spliter);
        // �ً}�����ÊǗ�����2��(SYSTEM_BIND_PATH:401019)
        sb.append(getData(map,"401019"));
        sb.append(spliter);
        // �ً}�����ÊǗ����v7��(SYSTEM_BIND_PATH:401020)
        sb.append(getData(map,"401020"));
        sb.append(spliter);
        // ���n�r���e�[�V�����_��7��(SYSTEM_BIND_PATH:401021)
        sb.append(getData(map,"401021"));
        sb.append(spliter);
        // ���u�_��7��(SYSTEM_BIND_PATH:401022)
        sb.append(getData(map,"401022"));
        sb.append(spliter);
        // ��p�_��7��(SYSTEM_BIND_PATH:401023)
        sb.append(getData(map,"401023"));
        sb.append(spliter);
        // �����_��7��(SYSTEM_BIND_PATH:401024)
        sb.append(getData(map,"401024"));
        sb.append(spliter);
        // ���ː����Ó_��7��(SYSTEM_BIND_PATH:401025)
        sb.append(getData(map,"401025"));
        sb.append(spliter);
        // �E�v1 64��(SYSTEM_BIND_PATH:401026)
        sb.append(getData(map,"401026"));
        sb.append(spliter);
        // �E�v2 64��(SYSTEM_BIND_PATH:401027)
        sb.append(getData(map,"401027"));
        sb.append(spliter);
        // �E�v3 64��(SYSTEM_BIND_PATH:401028)
        sb.append(getData(map,"401028"));
        sb.append(spliter);
        // �E�v4 64��(SYSTEM_BIND_PATH:401029)
        sb.append(getData(map,"401029"));
        sb.append(spliter);
        // �E�v5 64��(SYSTEM_BIND_PATH:401030)
        sb.append(getData(map,"401030"));
        sb.append(spliter);
        // �E�v6 64��(SYSTEM_BIND_PATH:401031)
        sb.append(getData(map,"401031"));
        sb.append(spliter);
        // �E�v7 64��(SYSTEM_BIND_PATH:401032)
        sb.append(getData(map,"401032"));
        sb.append(spliter);
        // �E�v8 64��(SYSTEM_BIND_PATH:401033)
        sb.append(getData(map,"401033"));
        sb.append(spliter);
        // �E�v9 64��(SYSTEM_BIND_PATH:401034)
        sb.append(getData(map,"401034"));
        sb.append(spliter);
        // �E�v10 64��(SYSTEM_BIND_PATH:401035)
        sb.append(getData(map,"401035"));
        sb.append(spliter);
        // �E�v11 64��(SYSTEM_BIND_PATH:401036)
        sb.append(getData(map,"401036"));
        sb.append(spliter);
        // �E�v12 64��(SYSTEM_BIND_PATH:401037)
        sb.append(getData(map,"401037"));
        sb.append(spliter);
        // �E�v13 64��(SYSTEM_BIND_PATH:401038)
        sb.append(getData(map,"401038"));
        sb.append(spliter);
        // �E�v14 64��(SYSTEM_BIND_PATH:401039)
        sb.append(getData(map,"401039"));
        sb.append(spliter);
        // �E�v15 64��(SYSTEM_BIND_PATH:401040)
        sb.append(getData(map,"401040"));
        sb.append(spliter);
        // �E�v16 64��(SYSTEM_BIND_PATH:401041)
        sb.append(getData(map,"401041"));
        sb.append(spliter);
        // �E�v17 64��(SYSTEM_BIND_PATH:401042)
        sb.append(getData(map,"401042"));
        sb.append(spliter);
        // �E�v18 64��(SYSTEM_BIND_PATH:401043)
        sb.append(getData(map,"401043"));
        sb.append(spliter);
        // �E�v19 64��(SYSTEM_BIND_PATH:401044)
        // edit sta 2006.05.20 fujihara.shin
        //sb.append(getData(map,"401043"));
        sb.append(getData(map,"401044"));
        // edit end 2006.05.20 fujihara.shin
        sb.append(spliter);
        // �E�v20 64��(SYSTEM_BIND_PATH:401045)
        sb.append(getData(map,"401045"));
        sb.append(spliter);
        // �ً}���{�ݗ×{��v�_��8��(SYSTEM_BIND_PATH:401046)
        sb.append(getData(map,"401046"));
        sb.append("\"");
        
        return sb.toString();
    }

    /**
     * �u����f�Ô��񃌃R�[�h�f�[�^������쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public String makeDiagnosisRecord(VRMap map) throws Exception {
        
        int _501007 = ACCastUtilities.toInt(map.get("501007"),0);
        StringBuilder sb = new StringBuilder();
        // �ȉ��̕�������J���}��؂�Ő�������B
        // ������񎯕ʔԍ�4��(SYSTEM_BIND_PATH:501001)
        sb.append("\"");
        sb.append(getData(map,"501001"));
        sb.append(spliter);
        // ���R�[�h��ʃR�[�h2��(SYSTEM_BIND_PATH:501002)
        sb.append(getData(map,"501002"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(YYYYMM)(SYSTEM_BIND_PATH:501003)
        sb.append(getData(map,"501003"));
        sb.append(spliter);
        // ���Ə��ԍ�10��(SYSTEM_BIND_PATH:501004)
        sb.append(getData(map,"501004"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��(SYSTEM_BIND_PATH:501005)
        //sb.append(getData(map,"501005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"501005"),0)));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��(SYSTEM_BIND_PATH:501006)
        sb.append(getData(map,"501006"));
        sb.append(spliter);
        // ����f�Ô��񃌃R�[�h�����ԍ�2��(SYSTEM_BIND_PATH:501007)
        //sb.append(getData(map,"501007"));
        sb.append(continuousnessFormat.format((long)_501007));
        sb.append(spliter);
        // ���a��40��(SYSTEM_BIND_PATH:501008)
        sb.append(getData(map,"501008"));
        sb.append(spliter);
        // ���ʔԍ�2������f�Ô�̎��ʔԍ�(SYSTEM_BIND_PATH:501009)
        sb.append(getData(map,"501009"));
        sb.append(spliter);
        // �P�ʐ�4��(SYSTEM_BIND_PATH:501010)
        sb.append(getData(map,"501010"));
        sb.append(spliter);
        // (�ی�)��2��(SYSTEM_BIND_PATH:501011)
        sb.append(getData(map,"501011"));
        sb.append(spliter);
        // (�ی�)�T�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:501012)
        sb.append(getData(map,"501012"));
        sb.append(spliter);
        if(_501007 == 99){
            // (�ی�)���v�P�ʐ�8��(SYSTEM_BIND_PATH:501013)
            sb.append(getData(map,"501013"));
        }
        sb.append(spliter);
        // (����1)��2��(SYSTEM_BIND_PATH:501014)
        sb.append(getData(map,"501014"));
        sb.append(spliter);
        // (����1)�T�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:501015)
        sb.append(getData(map,"501015"));
        sb.append(spliter);
        if(_501007 == 99){
            // (����1)���v�P�ʐ�8��(SYSTEM_BIND_PATH:501016)
            sb.append(getData(map,"501016"));
        }
        sb.append(spliter);
        // (����2)��2��(SYSTEM_BIND_PATH:501017)
        sb.append(getData(map,"501017"));
        sb.append(spliter);
        // (����2)�T�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:501018)
        sb.append(getData(map,"501018"));
        sb.append(spliter);
        if(_501007 == 99){
            // (����2)���v�P�ʐ�8��(SYSTEM_BIND_PATH:501019)
            sb.append(getData(map,"501019"));
        }
        sb.append(spliter);
        // (����3)��2��(SYSTEM_BIND_PATH:501020)
        sb.append(getData(map,"501020"));
        sb.append(spliter);
        // (����3)�T�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:501021)
        sb.append(getData(map,"501021"));
        sb.append(spliter);
        if(_501007 == 99){
            // (����3)���v�P�ʐ�8��(SYSTEM_BIND_PATH:501022)
            sb.append(getData(map,"501022"));
        }
        sb.append(spliter);
        // �E�v100��(SYSTEM_BIND_PATH:501023)
        sb.append(getData(map,"501023"));
        sb.append("\"");
        
        return sb.toString();
    }

    /**
     * �u�W�v��񃌃R�[�h�f�[�^������쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public String makeTypeRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // �ȉ��̕�������J���}��؂�Ő�������B
        // ������񎯕ʔԍ�4��(SYSTEM_BIND_PATH:701001)
        sb.append("\"");
        sb.append(getData(map,"701001"));
        sb.append(spliter);
        // ���R�[�h��ʃR�[�h2��(SYSTEM_BIND_PATH:701002)
        sb.append(getData(map,"701002"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(YYYYMM)(SYSTEM_BIND_PATH:701003)
        sb.append(getData(map,"701003"));
        sb.append(spliter);
        // ���Ə��ԍ�10��(SYSTEM_BIND_PATH:701004)
        sb.append(getData(map,"701004"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��(SYSTEM_BIND_PATH:701005)
        //sb.append(getData(map,"701005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"701005"),0)));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��(SYSTEM_BIND_PATH:701006)
        sb.append(getData(map,"701006"));
        sb.append(spliter);
        // �T�[�r�X��ރR�[�h2��(SYSTEM_BIND_PATH:701007)
        sb.append(getData(map,"701007"));
        sb.append(spliter);
        // �T�[�r�X������2��(SYSTEM_BIND_PATH:701008)
        //�l����O�A��l�A��܁A��Z�̌܁A��Z�̘Z�̏ꍇ�̂ݏo�͂���B
        if(QP001SpecialCase.isOutRealDay(String.valueOf(map.get("701001")))) {
            sb.append(getData(map,"701008"));
        } else {
            sb.append("0");
        }
        sb.append(spliter);
        // �v��P�ʐ�6��(SYSTEM_BIND_PATH:701009)
        sb.append(getData(map,"701009"));
        sb.append(spliter);
        // ���x�z�Ǘ��ΏےP�ʐ�6��(SYSTEM_BIND_PATH:701010)
        sb.append(getData(map,"701010"));
        sb.append(spliter);
        
        //���x�z�Ǘ��ΏۊO�P�ʐ�6��(SYSTEM_BIND_PATH:701011)
        //�l������O�A
        if(QP001SpecialCase.isOutLimitUncontrolledUnit(String.valueOf(map.get("701001")))) {
            sb.append(getData(map,"701011"));
        } else {
            sb.append("0");
        }
        sb.append(spliter);
        
        
        // �Z�������v�����2��(SYSTEM_BIND_PATH:701012)
        //�o�͂��Ȃ��d�l
        //sb.append(getData(map,"701012"));
        sb.append(spliter);
        // �Z������������2��(SYSTEM_BIND_PATH:701013)
        //sb.append(getData(map,"701013"));
        //�o�͂��Ȃ��d�l
        sb.append(spliter);
        
        // (�ی�)�P�ʐ����v8��(SYSTEM_BIND_PATH:701014)
        sb.append(getData(map,"701014"));
        sb.append(spliter);
        // (�ی�)�P�ʐ��P��4��(SYSTEM_BIND_PATH:701015)
        sb.append(getTanka(getData(map,"701015")));
        sb.append(spliter);
        // (�ی�)�����z9��(SYSTEM_BIND_PATH:701016)
        sb.append(getData(map,"701016"));
        sb.append(spliter);
        // (�ی�)���p�ҕ��S�z8��(SYSTEM_BIND_PATH:701017)
        sb.append(getData(map,"701017"));
        sb.append(spliter);
        // (����1)�P�ʐ����v6��(SYSTEM_BIND_PATH:701018)
        sb.append(getData(map,"701018"));
        sb.append(spliter);
        // (����1)�����z9��(SYSTEM_BIND_PATH:701019)
        sb.append(getData(map,"701019"));
        sb.append(spliter);
        // (����1)�{�l���S�z6��(SYSTEM_BIND_PATH:701020)
        sb.append(getData(map,"701020"));
        sb.append(spliter);
        // (����2)�P�ʐ����v6��(SYSTEM_BIND_PATH:701021)
        sb.append(getData(map,"701021"));
        sb.append(spliter);
        // (����2)�����z9��(SYSTEM_BIND_PATH:701022)
        sb.append(getData(map,"701022"));
        sb.append(spliter);
        // (����2)�{�l���S�z6��(SYSTEM_BIND_PATH:701023)
        sb.append(getData(map,"701023"));
        sb.append(spliter);
        // (����3)�P�ʐ����v6��(SYSTEM_BIND_PATH:701024)
        sb.append(getData(map,"701024"));
        sb.append(spliter);
        // (����3)�����z9��(SYSTEM_BIND_PATH:701025)
        sb.append(getData(map,"701025"));
        sb.append(spliter);
        // (����3)�{�l���S�z6��(SYSTEM_BIND_PATH:701026)
        sb.append(getData(map,"701026"));
        sb.append(spliter);
        // (�ی����o������Ô�)�P�ʐ����v8��(SYSTEM_BIND_PATH:701027)
        sb.append(getData(map,"701027"));
        sb.append(spliter);
        // (�ی����o������Ô�)�����z9��(SYSTEM_BIND_PATH:701028)
        sb.append(getData(map,"701028"));
        sb.append(spliter);
        // (�ی����o������Ô�)�o������Ô�p�ҕ��S�z8��(SYSTEM_BIND_PATH:701029)
        sb.append(getData(map,"701029"));
        sb.append(spliter);
        // (����1���o������Ô�)�P�ʐ����v8��(SYSTEM_BIND_PATH:701030)
        sb.append(getData(map,"701030"));
        sb.append(spliter);
        // (����1���o������Ô�)�����z9��(SYSTEM_BIND_PATH:701031)
        sb.append(getData(map,"701031"));
        sb.append(spliter);
        // (����1���o������Ô�)�o������Ô�{�l���S�z8��(SYSTEM_BIND_PATH:701032)
        sb.append(getData(map,"701032"));
        sb.append(spliter);
        // (����2���o������Ô�)�P�ʐ����v8��(SYSTEM_BIND_PATH:701033)
        sb.append(getData(map,"701033"));
        sb.append(spliter);
        // (����2���o������Ô�)�����z9��(SYSTEM_BIND_PATH:701034)
        sb.append(getData(map,"701034"));
        sb.append(spliter);
        // (����2���o������Ô�)�o������Ô�{�l���S�z8��(SYSTEM_BIND_PATH:701035)
        sb.append(getData(map,"701035"));
        sb.append(spliter);
        // (����3���o������Ô�)�P�ʐ����v8��(SYSTEM_BIND_PATH:701036)
        sb.append(getData(map,"701036"));
        sb.append(spliter);
        // (����3���o������Ô�)�����z9��(SYSTEM_BIND_PATH:701037)
        sb.append(getData(map,"701037"));
        sb.append(spliter);
        // (����3���o������Ô�)�o������Ô�{�l���S�z8��(SYSTEM_BIND_PATH:701038)
        sb.append(getData(map,"701038"));
        sb.append("\"");
        
        return sb.toString();
    }

    /**
     * �u��������҉��T�[�r�X��p��񃌃R�[�h�f�[�^������쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public String makeNursingRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // �ȉ��̕�������J���}��؂�Ő�������B
        
        // ������񎯕ʔԍ�4��(SYSTEM_BIND_PATH:801001)
        sb.append("\"");
        sb.append(getData(map,"801001"));
        sb.append(spliter);
        // ���R�[�h��ʃR�[�h2��(11��ݒ�)(SYSTEM_BIND_PATH:801002)
        sb.append(getData(map,"801002"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(YYYYMM)(SYSTEM_BIND_PATH:801003)
        sb.append(getData(map,"801003"));
        sb.append(spliter);
        // ���Ə��ԍ�10��(SYSTEM_BIND_PATH:801004)
        sb.append(getData(map,"801004"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��(SYSTEM_BIND_PATH:801005)
        //sb.append(getData(map,"801005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"801005"),0)));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��(SYSTEM_BIND_PATH:801006)
        sb.append(getData(map,"801006"));
        sb.append(spliter);
        // ��������҉��T�[�r�X��p��񃌃R�[�h�����ԍ�2��(SYSTEM_BIND_PATH:801007)
        //sb.append(getData(map,"801007"));
        sb.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("801007"),0)));
        sb.append(spliter);
        // �T�[�r�X��ރR�[�h2��(SYSTEM_BIND_PATH:801008)
        sb.append(getData(map,"801008"));
        sb.append(spliter);
        // �T�[�r�X���ڃR�[�h4��(SYSTEM_BIND_PATH:801009)
        sb.append(getData(map,"801009"));
        sb.append(spliter);
        // ��p�P��4��(SYSTEM_BIND_PATH:801010)
        sb.append(getData(map,"801010"));
        sb.append(spliter);
        // ���S���x�z4��(SYSTEM_BIND_PATH:801011)
        sb.append(getData(map,"801011"));
        sb.append(spliter);
        // ����2��(SYSTEM_BIND_PATH:801012)
        sb.append(getData(map,"801012"));
        sb.append(spliter);
        // ����1����2��(SYSTEM_BIND_PATH:801013)
        sb.append(getData(map,"801013"));
        sb.append(spliter);
        // ����2����2��(SYSTEM_BIND_PATH:801014)
        sb.append(getData(map,"801014"));
        sb.append(spliter);
        // ����3����2��(SYSTEM_BIND_PATH:801015)
        sb.append(getData(map,"801015"));
        sb.append(spliter);
        // ��p�z6��(SYSTEM_BIND_PATH:801016)
        sb.append(getData(map,"801016"));
        sb.append(spliter);
        // �ی��������z6��(SYSTEM_BIND_PATH:801017)
        sb.append(getData(map,"801017"));
        sb.append(spliter);
        // ����1���S�z(����)6��(SYSTEM_BIND_PATH:801018)
        sb.append(getData(map,"801018"));
        sb.append(spliter);
        // ����2���S�z(����)6��(SYSTEM_BIND_PATH:801019)
        sb.append(getData(map,"801019"));
        sb.append(spliter);
        // ����3���S�z(����)6��(SYSTEM_BIND_PATH:801020)
        sb.append(getData(map,"801020"));
        sb.append(spliter);
        // ���p�ҕ��S�z5��(SYSTEM_BIND_PATH:801021)
        sb.append(getData(map,"801021"));
        sb.append(spliter);
        
        //���R�[�h�����ԍ���99�̏ꍇ�̂݁A�l���o�͂���B
        if(ACCastUtilities.toInt(map.get("801007"),0) == 99){
            // ��p�z���v6��(SYSTEM_BIND_PATH:801022)
            sb.append(getData(map,"801022"));
            sb.append(spliter);
            // �ی��������z���v6��(SYSTEM_BIND_PATH:801023)
            sb.append(getData(map,"801023"));
            sb.append(spliter);
            // ���p�ҕ��S�z���v6��(SYSTEM_BIND_PATH:801024)
            sb.append(getData(map,"801024"));
            sb.append(spliter);
            // (����1)���S�z���v6��(SYSTEM_BIND_PATH:801025)
            sb.append(getData(map,"801025"));
            sb.append(spliter);
            // (����1)�����z6��(SYSTEM_BIND_PATH:801026)
            sb.append(getData(map,"801026"));
            sb.append(spliter);
            // (����1)�{�l���S�z5��(SYSTEM_BIND_PATH:801027)
            sb.append(getData(map,"801027"));
            sb.append(spliter);
            // (����2)���S�z���v6��(SYSTEM_BIND_PATH:801028)
            sb.append(getData(map,"801028"));
            sb.append(spliter);
            // (����2)�����z6��(SYSTEM_BIND_PATH:801029)
            sb.append(getData(map,"801029"));
            sb.append(spliter);
            // (����2)�{�l���S�z5��(SYSTEM_BIND_PATH:801030)
            sb.append(getData(map,"801030"));
            sb.append(spliter);
            // (����3)���S�z���v6��(SYSTEM_BIND_PATH:801031)
            sb.append(getData(map,"801031"));
            sb.append(spliter);
            // (����3)�����z6��(SYSTEM_BIND_PATH:801032)
            sb.append(getData(map,"801032"));
            sb.append(spliter);
            // (����3)�{�l���S�z5��(SYSTEM_BIND_PATH:801033)
            sb.append(getData(map,"801033"));
            sb.append("\"");
        } else {
            // ��p�z���v6��(SYSTEM_BIND_PATH:801022)
            sb.append(spliter);
            // �ی��������z���v6��(SYSTEM_BIND_PATH:801023)
            sb.append(spliter);
            // ���p�ҕ��S�z���v6��(SYSTEM_BIND_PATH:801024)
            sb.append(spliter);
            // (����1)���S�z���v6��(SYSTEM_BIND_PATH:801025)
            sb.append(spliter);
            // (����1)�����z6��(SYSTEM_BIND_PATH:801026)
            sb.append(spliter);
            // (����1)�{�l���S�z5��(SYSTEM_BIND_PATH:801027)
            sb.append(spliter);
            // (����2)���S�z���v6��(SYSTEM_BIND_PATH:801028)
            sb.append(spliter);
            // (����2)�����z6��(SYSTEM_BIND_PATH:801029)
            sb.append(spliter);
            // (����2)�{�l���S�z5��(SYSTEM_BIND_PATH:801030)
            sb.append(spliter);
            // (����3)���S�z���v6��(SYSTEM_BIND_PATH:801031)
            sb.append(spliter);
            // (����3)�����z6��(SYSTEM_BIND_PATH:801032)
            sb.append(spliter);
            // (����3)�{�l���S�z5��(SYSTEM_BIND_PATH:801033)
            sb.append("\"");
        }
        
        return sb.toString();
    }

    /**
     * �u�Љ���@�l�y���z��񃌃R�[�h�f�[�^�쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public String makeReductionRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // �ȉ��̕�������J���}��؂�Ő�������B
        // ������񎯕ʔԍ�4��(SYSTEM_BIND_PATH:901001)
        sb.append("\"");
        sb.append(map.get("901001"));
        sb.append(spliter);
        // ���R�[�h��ʃR�[�h2��(SYSTEM_BIND_PATH:901002)
        sb.append(getData(map,"901002"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(YYYYMM)(SYSTEM_BIND_PATH:901003)
        sb.append(getData(map,"901003"));
        sb.append(spliter);
        // ���Ə��ԍ�10��(SYSTEM_BIND_PATH:901004)
        sb.append(getData(map,"901004"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��(SYSTEM_BIND_PATH:901005)
        //sb.append(getData(map,"901005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"901005"),0)));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��(SYSTEM_BIND_PATH:901006)
        sb.append(getData(map,"901006"));
        sb.append(spliter);
        // �y����4��(SYSTEM_BIND_PATH:901007)
        //sb.append(getTanka(getData(map,"901007")));
        sb.append(getData(map,"901007"));
        sb.append(spliter);
        // �T�[�r�X��ރR�[�h2��(SYSTEM_BIND_PATH:901008)
        sb.append(getData(map,"901008"));
        sb.append(spliter);
        // ��̂��ׂ����p�ҕ��S�̑��z8��(SYSTEM_BIND_PATH:901009)
        sb.append(getData(map,"901009"));
        sb.append(spliter);
        // �y���z8��(SYSTEM_BIND_PATH:901010)
        sb.append(getData(map,"901010"));
        sb.append(spliter);
        // �y���㗘�p�ҕ��S�z8��(SYSTEM_BIND_PATH:901011)
        sb.append(getData(map,"901011"));
        sb.append(spliter);
        // ���l20��(SYSTEM_BIND_PATH:901012)
        sb.append(getData(map,"901012"));
        sb.append("\"");
        
        return sb.toString();
    }
    
    /**
     * �u���t�Ǘ���CSV�t�@�C���쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public String makeCarePlanCSV(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        //�ȉ��̕�������J���}��؂�Ő�������B
        // ������񎯕ʔԍ�4��(����18�N4���ȑO8121�Œ�@����18�N4���ȍ~8122�A��������8123)
        sb.append("\"");
        sb.append(getData(map,"1001001"));
        sb.append(spliter);
        // ���Ə��ԍ�10��
        sb.append(getData(map,"1001002"));
        sb.append(spliter);
        // �w��/��Y�������Ə��敪�R�[�h1���@1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� 5-�n�斧���^�T�[�r�X
        sb.append(getData(map,"1001003"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(YYYYMM)
        sb.append(getData(map,"1001004"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��
        sb.append(getData(map,"1001005"));
        //���������t�H�[�}�b�g���Ȃ��ėǂ�
        //sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"1001005"),0)));
        sb.append(spliter);
        // �P�ʐ��P��4��
        sb.append(getTanka(getData(map,"1001006")));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��
        sb.append(getData(map,"1001007"));
        sb.append(spliter);
        // ����S�Ҕԍ�8��
        sb.append(getData(map,"1001008"));
        sb.append(spliter);
        // ����󋋎Ҕԍ�7��
        sb.append(getData(map,"1001009"));
        sb.append(spliter);
        // ��ی��Ґ��N����8��(YYYYMMDD)
        sb.append(getData(map,"1001010"));
        sb.append(spliter);
        // ���ʃR�[�h1��1-�j 2-��
        sb.append(getData(map,"1001011"));
        sb.append(spliter);
        // �v����ԋ敪�R�[�h2���@01-��Y�� 11-�v�x��(�o�ߓI�v���) 12-�v�x��1 13-�v�x��2 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
        sb.append(getData(map,"1001012"));
        sb.append(spliter);
        // �F��L������(�J�n)8��(YYYYMMDD)
        sb.append(getData(map,"1001013"));
        sb.append(spliter);
        // �F��L������(�I��)8��(YYYYMMDD)
        sb.append(getData(map,"1001014"));
        sb.append(spliter);
        
        // ����T�[�r�X�v��쐬�˗��͏o�N����8��(YYYYMMDD)
        sb.append(getData(map,"1001015"));
        sb.append(spliter);
        
    	//�T�[�r�X�v���׍s�ԍ�
    	sb.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("1001024"),0)));
    	sb.append(spliter);
    	//�T�[�r�X�R�[�h
        sb.append(getData(map,"1001016"));
        sb.append(spliter);
        //�P�ʐ�
        sb.append(getData(map,"1001025"));
        sb.append(spliter);
        //��
        sb.append(getData(map,"1001026"));
        sb.append(spliter);
        //�T�[�r�X�P�ʐ�
        sb.append(getData(map,"1001017"));
        sb.append(spliter);
        //�T�[�r�X�P�ʐ����v
        sb.append(getData(map,"1001027"));
        sb.append(spliter);
        
        // �������z6��
        sb.append(getData(map,"1001018"));
        sb.append(spliter);
        // �S�����x�������ԍ�(������񎯕ʔԍ���8122�̏ꍇ�A�K�{)
        sb.append(getData(map,"1001022"));
        sb.append(spliter);
        // �E�v
        sb.append(getData(map,"1001023"));
        sb.append("\"");
        
        return sb.toString();

    }

    /**
     * �u���t�Ǘ���CSV�t�@�C���쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @throws Exception ������O
     */
    public String makeSupplyManagementCSV(VRMap map, Date claimTargetDate) throws Exception {
        
        StringBuilder sb = new StringBuilder();
        
        //�ȉ��̕�������J���}��؂�Ő�������B
        // ������񎯕ʔԍ�4��(����18�N4���ȑO8221�Œ�@����18�N4���ȍ~8222�Œ�)
        sb.append("\"");
        sb.append(getData(map,"1201001"));
        sb.append(spliter);
        // �Ώ۔N��6��(YYYYMM)
        sb.append(getData(map,"1201002"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"1201003"),0)));
        sb.append(spliter);
        // ���Ə��ԍ�10��(������x�����Ə��A�������͉��\�h�x�����Ə�)
        sb.append(getData(map,"1201004"));
        sb.append(spliter);
        // ���t�Ǘ��[���쐬�敪�R�[�h1���@1-�V�K 2-�C�� 3-���
        sb.append(getData(map,"1201005"));
        sb.append(spliter);
        // ���t�Ǘ��[�쐬�N����8��(YYYYMMDD)
        sb.append(VRDateParser.format(claimTargetDate,"yyyyMMdd"));
        sb.append(spliter);
        // ���t�Ǘ��[��ʋ敪�R�[�h1���@1-�K��ʏ��T�[�r�X���t�Ǘ��[ 2-�Z�������T�[�r�X���t�Ǘ��[ 3-����T�[�r�X�敪���t�Ǘ��[
        sb.append(getData(map,"1201007"));
        sb.append(spliter);
        // ���t�Ǘ��[���׍s�ԍ�2��
        //sb.append(getData(map,"1201008"));
        sb.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("1201008"),0)));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��
        sb.append(getData(map,"1201009"));
        sb.append(spliter);
        // ��ی��Ґ��N����8��(YYYYMMDD)
        sb.append(getData(map,"1201010"));
        sb.append(spliter);
        // ���ʃR�[�h1���@1-�j 2-��
        sb.append(getData(map,"1201011"));
        sb.append(spliter);
        // �v����ԋ敪�R�[�h2���@01-��Y�� 11-�v�x��(�o�ߓI�v���) 12-�v�x��1 13-�v�x��2 21-�v���1 22-�v���2 23-�v���3 24-�v���4 25-�v���5
        sb.append(getData(map,"1201012"));
        sb.append(spliter);
        // ���x�z�K�p����(�J�n)6��(YYYYMM)
        sb.append(getData(map,"1201013"));
        sb.append(spliter);
        // ���x�z�K�p����(�I��)6��(YYYYMM)
        sb.append(getData(map,"1201014"));
        sb.append(spliter);
        
        // ����E���\�h�x�����x�z6��
        sb.append(getData(map,"1201015"));
        sb.append(spliter);
        // ����T�[�r�X�v��쐬�敪�R�[�h1���@1-������x�����Ə��쐬�@2-���ȍ쐬�@3-���\�h�x�����Ə��쐬
        sb.append(getData(map,"1201016"));
        sb.append(spliter);
        // ���Ə��ԍ�(�T�[�r�X���Ə�)10��
        sb.append(getData(map,"1201017"));
        sb.append(spliter);
        // �w��/��Y�������Ə��敪�R�[�h1���@1-�w�莖�Ə� 2-��Y�����Ə� 3-�����T�[�r�X���Ə� 4-���̑� 5-�n�斧���^�T�[�r�X
        sb.append(getData0Rep(map,"1201018"));
        sb.append(spliter);
        // �T�[�r�X��ރR�[�h2��
        sb.append(getData(map,"1201019"));
        sb.append(spliter);
        // ���t�v��P�ʐ�/����6��
        sb.append(getData0Rep(map,"1201020"));
        sb.append(spliter);
        // ���x�z�Ǘ����Ԃɂ�����O���܂ł̋��t�v�����3��
        sb.append(getData(map,"1201021"));
        sb.append(spliter);
        // �w��T�[�r�X�����v6��
        sb.append(getData(map,"1201022"));
        sb.append(spliter);
        // ��Y���T�[�r�X�����v6��
        sb.append(getData(map,"1201023"));
        sb.append(spliter);
        // ���t�v�捇�v�P�ʐ�/����6��
        sb.append(getData0Rep(map,"1201024"));
        sb.append(spliter);
        // �S�����x�������ԍ�
        sb.append(getData(map,"1201025"));
        sb.append(spliter);
        // �ϑ���̋�����x�����Ə��ԍ�
        sb.append(getData(map,"1201026"));
        sb.append(spliter);
        // �ϑ���̒S�����x�������ԍ�
        sb.append(getData(map,"1201027"));
        sb.append("\"");
        
        return sb.toString();

    }
    
    
    /**
     * �u�ً}���{�ݗ×{��񃌃R�[�h�f�[�^������쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public String makeEmergencyOwnFacilityRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // �ȉ��̕�������J���}��؂�Ő�������B
        // ������񎯕ʔԍ�4��(SYSTEM_BIND_PATH:1701001)
        sb.append("\"");
        sb.append(getData(map,"1701001"));
        sb.append(spliter);
        // ���R�[�h��ʃR�[�h2��(SYSTEM_BIND_PATH:1701002)
        sb.append(getData(map,"1701002"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(YYYYMM)(SYSTEM_BIND_PATH:1701003)
        sb.append(getData(map,"1701003"));
        sb.append(spliter);
        // ���Ə��ԍ�10��(SYSTEM_BIND_PATH:1701004)
        sb.append(getData(map,"1701004"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��(SYSTEM_BIND_PATH:1701005)
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"1701005"),0)));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��(SYSTEM_BIND_PATH:1701006)
        sb.append(getData(map,"1701006"));
        sb.append(spliter);
        // �ً}���{�ݗ×{��񃌃R�[�h�����ԍ�2��(SYSTEM_BIND_PATH:1701007)
        sb.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("1701007"))));
        sb.append(spliter);
        // �ً}�����a��1 40��(SYSTEM_BIND_PATH:1701008)
        sb.append(getData(map,"1701008"));
        sb.append(spliter);
        // �ً}�����a��2 40��(SYSTEM_BIND_PATH:1701009)
        sb.append(getData(map,"1701009"));
        sb.append(spliter);
        // �ً}�����a��3 40��(SYSTEM_BIND_PATH:1701010)
        sb.append(getData(map,"1701010"));
        sb.append(spliter);
        // �ً}�����ÊJ�n�N����1 8��(YYYYMMDD)(SYSTEM_BIND_PATH:1701011)
        sb.append(getData(map,"1701011"));
        sb.append(spliter);
        // �ً}�����ÊJ�n�N����2 8��(YYYYMMDD)(SYSTEM_BIND_PATH:1701012)
        sb.append(getData(map,"1701012"));
        sb.append(spliter);
        // �ً}�����ÊJ�n�N����3 8��(YYYYMMDD)(SYSTEM_BIND_PATH:1701013)
        sb.append(getData(map,"1701013"));
        sb.append(spliter);
        // ���f����2��(SYSTEM_BIND_PATH:1701014)
        sb.append(getData(map,"1701014"));
        sb.append(spliter);
        // ���f��Ë@�֖�40��(SYSTEM_BIND_PATH:1701015)
        sb.append(getData(map,"1701015"));
        sb.append(spliter);
        // �ʉ@����2��(SYSTEM_BIND_PATH:1701016)
        sb.append(getData(map,"1701016"));
        sb.append(spliter);
        // �ʉ@��Ë@�֖�40��(SYSTEM_BIND_PATH:1701017)
        sb.append(getData(map,"1701017"));
        sb.append(spliter);
        // �ً}�����ÊǗ��P�ʐ�6��(SYSTEM_BIND_PATH:1701018)
        sb.append(getData(map,"1701018"));
        sb.append(spliter);
        // �ً}�����ÊǗ�����2��(SYSTEM_BIND_PATH:1701019)
        sb.append(getData(map,"1701019"));
        sb.append(spliter);
        // �ً}�����ÊǗ����v7��(SYSTEM_BIND_PATH:1701020)
        sb.append(getData(map,"1701020"));
        sb.append(spliter);
        // ���n�r���e�[�V�����_��7��(SYSTEM_BIND_PATH:1701021)
        sb.append(getData(map,"1701021"));
        sb.append(spliter);
        // ���u�_��7��(SYSTEM_BIND_PATH:1701022)
        sb.append(getData(map,"1701022"));
        sb.append(spliter);
        // ��p�_��7��(SYSTEM_BIND_PATH:1701023)
        sb.append(getData(map,"1701023"));
        sb.append(spliter);
        // �����_��7��(SYSTEM_BIND_PATH:1701024)
        sb.append(getData(map,"1701024"));
        sb.append(spliter);
        // ���ː����Ó_��7��(SYSTEM_BIND_PATH:1701025)
        sb.append(getData(map,"1701025"));
        sb.append(spliter);
        // �E�v1 64��(SYSTEM_BIND_PATH:1701026)
        sb.append(getData(map,"1701026"));
        sb.append(spliter);
        // �E�v2 64��(SYSTEM_BIND_PATH:1701027)
        sb.append(getData(map,"1701027"));
        sb.append(spliter);
        // �E�v3 64��(SYSTEM_BIND_PATH:1701028)
        sb.append(getData(map,"1701028"));
        sb.append(spliter);
        // �E�v4 64��(SYSTEM_BIND_PATH:1701029)
        sb.append(getData(map,"1701029"));
        sb.append(spliter);
        // �E�v5 64��(SYSTEM_BIND_PATH:1701030)
        sb.append(getData(map,"1701030"));
        sb.append(spliter);
        // �E�v6 64��(SYSTEM_BIND_PATH:1701031)
        sb.append(getData(map,"1701031"));
        sb.append(spliter);
        // �E�v7 64��(SYSTEM_BIND_PATH:1701032)
        sb.append(getData(map,"1701032"));
        sb.append(spliter);
        // �E�v8 64��(SYSTEM_BIND_PATH:1701033)
        sb.append(getData(map,"1701033"));
        sb.append(spliter);
        // �E�v9 64��(SYSTEM_BIND_PATH:1701034)
        sb.append(getData(map,"1701034"));
        sb.append(spliter);
        // �E�v10 64��(SYSTEM_BIND_PATH:1701035)
        sb.append(getData(map,"1701035"));
        sb.append(spliter);
        // �E�v11 64��(SYSTEM_BIND_PATH:1701036)
        sb.append(getData(map,"1701036"));
        sb.append(spliter);
        // �E�v12 64��(SYSTEM_BIND_PATH:1701037)
        sb.append(getData(map,"1701037"));
        sb.append(spliter);
        // �E�v13 64��(SYSTEM_BIND_PATH:1701038)
        sb.append(getData(map,"1701038"));
        sb.append(spliter);
        // �E�v14 64��(SYSTEM_BIND_PATH:1701039)
        sb.append(getData(map,"1701039"));
        sb.append(spliter);
        // �E�v15 64��(SYSTEM_BIND_PATH:1701040)
        sb.append(getData(map,"1701040"));
        sb.append(spliter);
        // �E�v16 64��(SYSTEM_BIND_PATH:1701041)
        sb.append(getData(map,"1701041"));
        sb.append(spliter);
        // �E�v17 64��(SYSTEM_BIND_PATH:1701042)
        sb.append(getData(map,"1701042"));
        sb.append(spliter);
        // �E�v18 64��(SYSTEM_BIND_PATH:1701043)
        sb.append(getData(map,"1701043"));
        sb.append(spliter);
        // �E�v19 64��(SYSTEM_BIND_PATH:1701044);
        sb.append(getData(map,"1701044"));
        sb.append(spliter);
        // �E�v20 64��(SYSTEM_BIND_PATH:1701045)
        sb.append(getData(map,"1701045"));
        sb.append(spliter);
        // �ً}���{�ݗ×{��v�_��8��(SYSTEM_BIND_PATH:1701046)
        sb.append(getData(map,"1701046"));
        sb.append(spliter);
        // ���{�ݗ×{��a��1 40��(SYSTEM_BIND_PATH:1701047)
        sb.append(getData(map,"1701047"));
        sb.append(spliter);
        // ���{�ݗ×{��a��2 40��(SYSTEM_BIND_PATH:1701048)
        sb.append(getData(map,"1701048"));
        sb.append(spliter);
        // ���{�ݗ×{��a��3 40��(SYSTEM_BIND_PATH:1701049)
        sb.append(getData(map,"1701049"));
        sb.append(spliter);
        // ���{�ݗ×{��J�n�N����1 8��(YYYYMMDD)(SYSTEM_BIND_PATH:1701050)
        sb.append(getData(map,"1701050"));
        sb.append(spliter);
        // ���{�ݗ×{��J�n�N����2 8��(YYYYMMDD)(SYSTEM_BIND_PATH:1701051)
        sb.append(getData(map,"1701051"));
        sb.append(spliter);
        // ���{�ݗ×{��J�n�N����3 8��(YYYYMMDD)(SYSTEM_BIND_PATH:1701052)
        sb.append(getData(map,"1701052"));
        sb.append(spliter);
        // ���{�ݗ×{��P�ʐ�6��(SYSTEM_BIND_PATH:1701053)
        sb.append(getData(map,"1701053"));
        sb.append(spliter);
        // ���{�ݗ×{�����2��(SYSTEM_BIND_PATH:1701054)
        sb.append(getData(map,"1701054"));
        sb.append(spliter);
        // ���{�ݗ×{��v7��(SYSTEM_BIND_PATH:1701055)
        sb.append(getData(map,"1701055"));
        
        sb.append("\"");
        
        return sb.toString();
    }
    
 // 2014/12/24 [Yoichiro Kamei] add - begin �Z���n����Ή�
    /**
     * �u���׏��i�Z���n����j���R�[�h�f�[�^������쐬�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception
     *             ������O
     */
    public String makeDetailJushotiTokureiRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // �ȉ��̕�������J���}��؂�Ő�������B
        // ������񎯕ʔԍ�4��(SYSTEM_BIND_PATH:1801001)
        sb.append("\"");
        sb.append(getData(map,"1801001"));
        sb.append(spliter);
        // ���R�[�h��ʃR�[�h2��(SYSTEM_BIND_PATH:1801002)
        sb.append(getData(map,"1801002"));
        sb.append(spliter);
        // �T�[�r�X�񋟔N��6��(YYYYMM)(SYSTEM_BIND_PATH:1801003)
        sb.append(getData(map,"1801003"));
        sb.append(spliter);
        // ���Ə��ԍ�10��(SYSTEM_BIND_PATH:1801004)
        sb.append(getData(map,"1801004"));
        sb.append(spliter);
        // �؋L�ڕی��Ҕԍ�8��(SYSTEM_BIND_PATH:1801005)
        //sb.append(getData(map,"1801005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"1801005"),0)));
        sb.append(spliter);
        // ��ی��Ҕԍ�10��(SYSTEM_BIND_PATH:1801006)
        sb.append(getData(map,"1801006"));
        sb.append(spliter);
        // �T�[�r�X��ރR�[�h2��(SYSTEM_BIND_PATH:1801007)
        sb.append(getData(map,"1801007"));
        sb.append(spliter);
        // �T�[�r�X���ڃR�[�h4��(SYSTEM_BIND_PATH:1801008)
        sb.append(getData(map,"1801008"));
        sb.append(spliter);
        //�P�ʐ����L�ڂ��Ȃ��T�[�r�X�łȂ��ꍇ�A�P�ʐ����o�͂���B
        if(!QP001SpecialCase.isUnitNoCountService(getData(map,"1801007"),getData(map,"1801008"))){
            // �P�ʐ�4��(SYSTEM_BIND_PATH:1801009)
            sb.append(getData(map,"1801009"));
        }
        sb.append(spliter);
        // �������2��(SYSTEM_BIND_PATH:1801010)
        sb.append(getData(map,"1801010"));
        sb.append(spliter);
        // ����1�Ώۓ����E��2��(SYSTEM_BIND_PATH:1801011)
        sb.append(getData(map,"1801011"));
        sb.append(spliter);
        // ����2�Ώۓ����E��2��(SYSTEM_BIND_PATH:1801012)
        sb.append(getData(map,"1801012"));
        sb.append(spliter);
        // ����3�Ώۓ����E��2��(SYSTEM_BIND_PATH:1801013)
        sb.append(getData(map,"1801013"));
        sb.append(spliter);
        // �T�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:1801014)
        sb.append(getData(map,"1801014"));
        sb.append(spliter);
        // ����1�ΏۃT�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:1801015)
        sb.append(getData(map,"1801015"));
        sb.append(spliter);
        // ����2�ΏۃT�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:1801016)
        sb.append(getData(map,"1801016"));
        sb.append(spliter);
        // ����3�ΏۃT�[�r�X�P�ʐ�6��(SYSTEM_BIND_PATH:1801017)
        sb.append(getData(map,"1801017"));
        sb.append(spliter);
        // �{�ݏ��ݕی��Ҕԍ�6��(SYSTEM_BIND_PATH:1801018)
        sb.append(getData(map,"1801018"));
        //sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"1801018"),0)));
        sb.append(spliter);
        // �E�v20��(SYSTEM_BIND_PATH:1801019)
        sb.append(getData(map,"1801019"));
        sb.append("\"");
        
        return sb.toString();
    }
 // 2014/12/24 [Yoichiro Kamei] add - end 
    
    private String getData0Rep(VRMap map,String key) throws Exception {
        String result = getData(map,key);
        if((result == null) || ("0".equals(result))){
            result = "";
        }
        return result;
    }
    
    /**
     * CSV�o�͗p�̕�����ɕϊ�����B
     * @param map
     * @param key
     * @return
     * @throws Exception
     */
    private String getData(VRMap map,String key) throws Exception {
        String result = "";
        if(!map.containsKey(key)){
            VRLogger.warning("CSV�o�́FMAP�ɑ��݂��Ȃ��L�[���w�肳��܂����B:" + key);
        } else {
            if(map.get(key) != null){
                result = String.valueOf(map.get(key));
                if("null".equalsIgnoreCase(result)){
                    result = "";
                }
            }
        }
        return result;
    }
    
    /**
     * 12.34�^���̒l��.�𔲂��āA1234�ɕύX���܂��B
     * 5.67�^���̏ꍇ�͐擪�ɋ󔒂������567��ԋp���܂��B
     * @param value
     * @return
     * @throws Exception
     */
    protected String getTanka(Object value) throws Exception {
        if (ACTextUtilities.isNullText(value))
            return "";
        String[] temp = ACCastUtilities.toString(value).split("\\.");
        temp[0] = pad(temp[0], 2);
        if (temp.length == 1)
            return temp[0] + "00";
        
        switch(temp[1].length()){
        case 0:
            temp[1] = "00";
            break;
        case 1:
            temp[1] += "0";
            break;
        }

        return temp[0] + temp[1];

    }
    

    /**
     * ������̐擪�ɋ󔒕�����}�����A�����Ŏw�肳�ꂽ�������ɂ��ĕԋp���܂��B
     * ������0�̏ꍇ�͋󔒂ɒu������܂��B
     * @param value �Ώە�����
     * @param pad ���߂镶����
     * @return �󔒂�}������������
     * @throws Exception
     */
    protected String pad(Object value, int pad) throws Exception {
        if (ACTextUtilities.isNullText(value))
            return "";
        String temp = ACCastUtilities.toString(value);
        if ("0".equals(temp))
            return "";
        StringBuilder padString = new StringBuilder();
        for (int i = 0; i < pad - temp.length(); i++) {
            padString.append(" ");
        }
        return padString.toString() + temp;
    }
    
    private class CSVData {
        private QP001Style1 style1 = null;
        private List csvList = new ArrayList();
        
        public CSVData(QP001Manager manager) {
            this.style1 = new QP001Style1(manager);
        }
        
        public QP001Style1 getTotalObject() {
            return style1;
        }
        
        public List getCSVList() {
            return csvList;
        }
    }
    
    /**
     * �w�肳��Ă���\�[�g�L�[���Ɏ������Ń\�[�g����
     */
    private class StringComparator implements java.util.Comparator {
        public int compare(Object object1, Object object2) {
            String value1 = "";
            String value2 = "";
            try{
                value1 = ((String[])object1)[0];
                value2 = ((String[])object2)[0];
            } catch(Exception e){
                VRLogger.warning(e);
            }
            
            return value1.compareTo(value2);
        }
    }
    
}
