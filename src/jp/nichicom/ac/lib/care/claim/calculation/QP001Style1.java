
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
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� �l����� (QP001Style1)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * �l�����@�꒠�[���̏��
 * @author shin fujihara
 *
 */
public class QP001Style1{
	

    //����T�[�r�X�E�{�݃T�[�r�X
    private QP001RecordCareSupplyClaim insurance1 = new QP001RecordCareSupplyClaim();
    //������x��
    private QP001RecordCareSupplyClaim insurance2 = new QP001RecordCareSupplyClaim();
    
    //�����
    //���ۋ���T�[�r�X�E�{�݃T�[�r�X
    private QP001RecordCareSupplyClaim publicExpense12_1 = new QP001RecordCareSupplyClaim();
    //���ۋ�����x��
    private QP001RecordCareSupplyClaim publicExpense12_2 = new QP001RecordCareSupplyClaim();
    //���j34��
    private QP001RecordCareSupplyClaim publicExpense10 = new QP001RecordCareSupplyClaim();
    //���j35��
    private QP001RecordCareSupplyClaim publicExpense11 = new QP001RecordCareSupplyClaim();
    //���_32��
    private QP001RecordCareSupplyClaim publicExpense21 = new QP001RecordCareSupplyClaim();
    //�g��E�X��
    private QP001RecordCareSupplyClaim publicExpense15 = new QP001RecordCareSupplyClaim();
    //�����E���
    private QP001RecordCareSupplyClaim publicExpense19 = new QP001RecordCareSupplyClaim();
    //���莾�������Ì���
    private QP001RecordCareSupplyClaim publicExpense51 = new QP001RecordCareSupplyClaim();
    //��Q�ҁE�x���[�u
    private QP001RecordCareSupplyClaim publicExpense57 = new QP001RecordCareSupplyClaim();
    //�픚�ҏ���
    private QP001RecordCareSupplyClaim publicExpense81 = new QP001RecordCareSupplyClaim();
    //�픚�̌���
    private QP001RecordCareSupplyClaim publicExpense86 = new QP001RecordCareSupplyClaim();
    //�L�@�q�f�E�ً}
    private QP001RecordCareSupplyClaim publicExpense87 = new QP001RecordCareSupplyClaim();
    //�����a�����΍􃁃`������
    private QP001RecordCareSupplyClaim publicExpense88 = new QP001RecordCareSupplyClaim();
    //����(�S�z�Ə�)
    private QP001RecordCareSupplyClaim publicExpense58 = new QP001RecordCareSupplyClaim();
    //�Ζ�
    private QP001RecordCareSupplyClaim publicExpense66 = new QP001RecordCareSupplyClaim();
    //�����c���@�l��
    private QP001RecordCareSupplyClaim publicExpense25 = new QP001RecordCareSupplyClaim();
    
    private QP001Manager manager = null;
    
    /**
     * �R���X�g���N�^
     */
    public QP001Style1(QP001Manager manager){
        this.manager = manager;
    }
    
    /**
     * �T�[�r�X�񋟓��t���擾���A�I�u�W�F�N�g�̃V���A���Ƃ��ĕԋp����B
     * @param claimList
     * @return
     * @throws Exception
     */
    public static String getSerialId(VRList claimList) throws Exception {
        
        String result = "";
        
        lbl:for(int i = 0; i < claimList.size(); i++){
            VRMap map = (VRMap)claimList.get(i);
            //�L�[�̑��݃`�F�b�N
            if(!map.containsKey("CATEGORY_NO")){
                continue;
            }
            
            switch(ACCastUtilities.toInt(map.get("CATEGORY_NO"),0)){
            //��{��񃌃R�[�h
            case 2:
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                result = String.valueOf(map.get("201003"));
                break lbl;
                
            //�W�v��񃌃R�[�h
            case 7:
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                result = String.valueOf(map.get("701003"));
                break lbl;
                
            //��������҉��T�[�r�X��p��񃌃R�[�h
            case 8:
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                result = String.valueOf(map.get("801003"));
                break lbl;
                
            //��싋�t������׏�(����T�[�r�X�v���)��񃌃R�[�h
            case 10:
                //�T�[�r�X�񋟔N��6��(YYYYMM)
                result = String.valueOf(map.get("1001004"));
                break lbl;
                
            default:
                break;
            }
        }
        return result;
    }
    
	
	/**
	 * �f�[�^�̉�͂����s����B
	 * @param claimList
	 * @throws Exception
	 */
    public void parse(VRList claimList) throws Exception {
		
        VRMap kohiMap = new VRHashMap();
        VRList typeList = new VRArrayList();
        VRList nursingList = new VRArrayList();
        
        for(int i = 0; i < claimList.size(); i++){
            VRMap map = (VRMap)claimList.get(i);
            
            //�L�[�̑��݃`�F�b�N
            if(!map.containsKey("CATEGORY_NO")){
                continue;
            }
            
            switch(ACCastUtilities.toInt(map.get("CATEGORY_NO"),0)){
            //��{��񃌃R�[�h
            case 2:
                //�ی�����
                //����E�{�݃T�[�r�X�^���\�h�T�[�r�X�^�n�斧���^�T�[�r�X���T�[�r�X��p
                //���ےP�ƈȊO�̏ꍇ�̂݌v�シ��B
                if(!QP001SpecialCase.isSeihoOnly(String.valueOf(map.get("201006")))){
                    insurance1.parse(map,1,"00","01");
                }
                String[] kohi = new String[3];
                //����̏���ޔ�
                if(!kohiMap.containsKey(map.get("201001"))){
                    kohi[0] = ACCastUtilities.toString((map.get("201058")));
                    kohi[1] = ACCastUtilities.toString((map.get("201059")));
                    kohi[2] = ACCastUtilities.toString((map.get("201060")));
                    kohiMap.put(map.get("201001"),kohi);
                }
                
                ///////����̏W�v���ʂł͂Ȃ��l���̍��Z�ōs���悤�ύX
                //����P�̃^�C�v���ݒ肳��Ă���ꍇ
                if(!ACTextUtilities.isNullText(kohi[0])){
                    //�f�[�^�̐ݒ���s���B
                    setKohiRecord(map,kohi[0],0);
                }
                
                //����Q�̃^�C�v���ݒ肳��Ă���ꍇ
                if(!ACTextUtilities.isNullText(kohi[1])){
                    //�f�[�^�̐ݒ���s���B
                    setKohiRecord(map,kohi[1],1);
                }
                
                //����R�̃^�C�v���ݒ肳��Ă���ꍇ
                if(!ACTextUtilities.isNullText(kohi[2])){
                    //�f�[�^�̐ݒ���s���B
                    setKohiRecord(map,kohi[2],2);
                }
                
                break;
                
            //�W�v��񃌃R�[�h
            case 7:
                typeList.add(map);
                break;
                
            //��������҉��T�[�r�X��p��񃌃R�[�h
            case 8:
                if(String.valueOf(map.get("801007")).equals("99")){
                    nursingList.add(map);
                }
                break;
                
            //��싋�t������׏�(����T�[�r�X�v���)��񃌃R�[�h
            case 10:
                //������x���E���\�h�x���T�[�r�X��p
                //����̓K�p�������ꍇ
                if(ACTextUtilities.isNullText(map.get("1001019"))){
                    insurance2.parseStyle7(map,1,"00","02");
                    
                //����̓K�p������ꍇ
                } else {
                    setKohiRecord(map,String.valueOf(map.get("1001019")),0);
                }
                break;
                
            default:
                break;
            }            
        }
        
        //�W�v���
        for(int i = 0; i < typeList.size(); i++){
            VRMap map = (VRMap)typeList.get(i);
            //�ً}������f�Ô�̉��Z���s���B
            //���ےP�ƈȊO�̏ꍇ�̂݌v�シ��B
            if(!QP001SpecialCase.isSeihoOnly(String.valueOf(map.get("701006")))){
                insurance1.parseCategory7(map);
            }
            
            if(kohiMap.containsKey(map.get("701001"))){
                String kohi[] = (String[])kohiMap.get(map.get("701001"));
                //������̃`�F�b�N
                //����P�̃^�C�v���ݒ肳��Ă���ꍇ
                if(!ACTextUtilities.isNullText(kohi[0])){
                    //�f�[�^�̐ݒ���s���B
                    setKohiRecordCategory7(map,kohi[0],0);
                }
                
                //����Q�̃^�C�v���ݒ肳��Ă���ꍇ
                if(!ACTextUtilities.isNullText(kohi[1])){
                    //�f�[�^�̐ݒ���s���B
                    setKohiRecordCategory7(map,kohi[1],1);
                }
                
                //����R�̃^�C�v���ݒ肳��Ă���ꍇ
                if(!ACTextUtilities.isNullText(kohi[2])){
                    //�f�[�^�̐ݒ���s���B
                    setKohiRecordCategory7(map,kohi[2],2);
                }
            }
            
        }
        
        
        //��������҉��
        for(int i = 0; i < nursingList.size(); i++){
            VRMap map = (VRMap)nursingList.get(i);
            
            //ID:0000198
            //�ی������z��0�̏ꍇ�͌v�サ�Ȃ�
            if(ACCastUtilities.toInt(map.get("801023"),0) != 0){
            	insurance1.parseCategory8(map,1,"00","01");
            }
            
            if(kohiMap.containsKey(map.get("801001"))){
                
                //�l���W�C�X�C�P�O�łȂ��ƌ���̓K�p�͍s���Ȃ��B
                if(!QP001SpecialCase.isShisetsuDiscriminationNo(String.valueOf(map.get("801001")))){
                    continue;
                }
                
                String kohi[] = (String[])kohiMap.get(map.get("801001"));
                //������̃`�F�b�N
                //����P�̃^�C�v���ݒ肳��Ă���ꍇ
                if(!ACTextUtilities.isNullText(kohi[0])){
                	//ID:0000188
                	//������z��0�̏ꍇ�͌v�サ�Ȃ��B
                	if(ACCastUtilities.toInt(map.get("801026"),0) != 0){
                        //�f�[�^�̐ݒ���s���B
                        setKohiRecord(map,kohi[0],0);
                	}
                }
                
                //����Q�̃^�C�v���ݒ肳��Ă���ꍇ
                if(!ACTextUtilities.isNullText(kohi[1])){
                	//ID:0000188
                	if(ACCastUtilities.toInt(map.get("801029"),0) != 0){
                        //�f�[�^�̐ݒ���s���B
                        setKohiRecord(map,kohi[1],1);
                	}
                }
                
                //����R�̃^�C�v���ݒ肳��Ă���ꍇ
                if(!ACTextUtilities.isNullText(kohi[2])){
                	if(ACCastUtilities.toInt(map.get("801032"),0) != 0){
                        //�f�[�^�̐ݒ���s���B
                        setKohiRecord(map,kohi[2],2);
                	}
                }
                
            }
        }
        
	}
    
    /**
     * ����̃f�[�^��ݒ肷��B
     * @param map
     * @param kohiType
     * @throws Exception
     */
    private void setKohiRecord(VRMap map,String kohiType,int kohiPosition) throws Exception {
        //����̖@�ʔԍ��ŕ��򂷂�B
        switch(ACCastUtilities.toInt(manager.getKohiData(kohiType,"KOHI_LAW_NO"),0)){
            //���j34��
            case 10:
                publicExpense10.parseKohi(map,2,"10","00",kohiPosition);
                break;
                
            //���j35��
            case 11:
                publicExpense11.parseKohi(map,2,"11","00",kohiPosition);
                break;
                
            //����
            case 12:
                //����E�{�݂Ƌ�����x���ŕ���
                switch(ACCastUtilities.toInt(map.get("CLAIM_STYLE_TYPE"),0)){
                //�l���掵�̏ꍇ
                case QkanConstants.CLAIM_STYLE_FORMAT_7:
                case QkanConstants.CLAIM_STYLE_FORMAT_7_2:
                    publicExpense12_2.parseKohi(map,2,"12","02",kohiPosition);
                    break;
                //�l���掵�ȊO�̏ꍇ
                default:
                    publicExpense12_1.parseKohi(map,2,"12","01",kohiPosition);
                    break;
                    
                }
                break;
                
            //�g��E�X��
            case 15:
                publicExpense15.parseKohi(map,2,"15","00",kohiPosition);
                break;
                
            //�����E���
            case 19:
                publicExpense19.parseKohi(map,2,"19","00",kohiPosition);
                break;
                
            //���_32��
            case 21:
                publicExpense21.parseKohi(map,2,"21","00",kohiPosition);
                break;
                
            //���莾�������Ì�����
            case 51:
                publicExpense51.parseKohi(map,2,"51","00",kohiPosition);
                break;
                
            //��Q�ҁE�x���[�u
            case 57:
                publicExpense57.parseKohi(map,2,"57","00",kohiPosition);
                break;
                
            //����(�S�z�Ə�)
            case 58:
                publicExpense58.parseKohi(map,2,"58","00",kohiPosition);
                break;
                
            //�Ζ�
            case 66:
                publicExpense66.parseKohi(map,2,"66","00",kohiPosition);
                break;
                
            //�픚�ҏ���
            case 81:
                publicExpense81.parseKohi(map,2,"81","00",kohiPosition);
                break;
                
            //�픚�̌���
            case 86:
                publicExpense86.parseKohi(map,2,"86","00",kohiPosition);
                break;
                
            //�L�@�q�f�E�ً}�[�u
            case 87:
                publicExpense87.parseKohi(map,2,"87","00",kohiPosition);
                break;
                
            //�����a�����΍�
            case 88:
                publicExpense88.parseKohi(map,2,"88","00",kohiPosition);
                break;
            
            //[H20.4 �@�����Ή�] fujihara start
            //�����c���M�l��
            case 25:
            	publicExpense25.parseKohi(map, 2, "25", "00", kohiPosition);
                break;
            //[H20.4 �@�����Ή�] fujihara add end
        }
    }
    
    /**
     * ����̃f�[�^��ݒ肷��B
     * @param map
     * @param kohiType
     * @throws Exception
     */
    private void setKohiRecordCategory7(VRMap map,String kohiType,int kohiPosition) throws Exception {
        //����̖@�ʔԍ��ŕ��򂷂�B
        switch(ACCastUtilities.toInt(manager.getKohiData(kohiType,"KOHI_LAW_NO"),0)){
            //���j34��
            case 10:
                publicExpense10.parseCategory7(map);
                break;
                
            //���j35��
            case 11:
                publicExpense11.parseCategory7(map);
                break;
                
            //����
            case 12:
                //����E�{�݂Ƌ�����x���ŕ���
                switch(ACCastUtilities.toInt(map.get("CLAIM_STYLE_TYPE"),0)){
                //�l���掵�̏ꍇ
                case QkanConstants.CLAIM_STYLE_FORMAT_7:
                case QkanConstants.CLAIM_STYLE_FORMAT_7_2:
                    publicExpense12_2.parseCategory7(map);
                    break;
                //�l���掵�ȊO�̏ꍇ
                default:
                    publicExpense12_1.parseCategory7(map);
                    break;
                    
                }
                break;
                
            //�g��E�X��
            case 15:
                publicExpense15.parseCategory7(map);
                break;
                
            //�����E���
            case 19:
                publicExpense19.parseCategory7(map);
                break;
                
            //���_32��
            case 21:
                publicExpense21.parseCategory7(map);
                break;
                
            //���莾�������Ì�����
            case 51:
                publicExpense51.parseCategory7(map);
                break;
                
            //��Q�ҁE�x���[�u
            case 57:
                publicExpense57.parseCategory7(map);
                break;
                
            //����(�S�z�Ə�)
            case 58:
                publicExpense58.parseCategory7(map);
                break;
                
            //�Ζ�
            case 66:
                publicExpense66.parseCategory7(map);
                break;
                
            //�픚�ҏ���
            case 81:
                publicExpense81.parseCategory7(map);
                break;
                
            //�픚�̌���
            case 86:
                publicExpense86.parseCategory7(map);
                break;
                
            //�L�@�q�f�E�ً}�[�u
            case 87:
                publicExpense87.parseCategory7(map);
                break;
                
            //�����a�����΍�
            case 88:
                publicExpense88.parseCategory7(map);
                break;
                
            //[H20.4 �@�����Ή�] fujihara start
            //�����c���M�l��
            case 25:
            	publicExpense25.parseCategory7(map);
            	break;
            //[H20.4 �@�����Ή�] fujihara add end
            
        }
    }
	
	/**
	 * �f�[�^�̊m����s���B
	 */
	protected void commitRecords(QP001PatientState patientState) throws Exception {
		//
	}
	
	/**
	 * DB�o�^�p�̃��R�[�h�W�����쐬���܂��B
	 * @param patient_id
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
    public VRList getRecords() throws Exception {
		VRList list = new VRArrayList();
        
        //����T�[�r�X�E�{�݃T�[�r�X
        if(!insurance1.isNew()){
            list.add(insurance1.getRecord());
        }
        
        //������x��
        if(!insurance2.isNew()){
            list.add(insurance2.getRecord());
        }
        
        //�����
        //������̖@�ʔԍ����ɏo�͂���B
        //���j34��
        if(!publicExpense10.isNew()){
            list.add(publicExpense10.getRecord());
        }
        //���j35��
        if(!publicExpense11.isNew()){
            list.add(publicExpense11.getRecord());
        }
        
        //���ۋ���T�[�r�X�E�{�݃T�[�r�X
        if(!publicExpense12_1.isNew()){
            list.add(publicExpense12_1.getRecord());
        }
        
        //���ۋ�����x��
        if(!publicExpense12_2.isNew()){
            list.add(publicExpense12_2.getRecord());
        }
        //�g��E�X��
        if(!publicExpense15.isNew()){
            list.add(publicExpense15.getRecord());
        }
        
        //�����E���
        if(!publicExpense19.isNew()){
            list.add(publicExpense19.getRecord());
        }
        
        //���_32��
        if(!publicExpense21.isNew()){
            list.add(publicExpense21.getRecord());
        }
        
        //���莾�������Ì���
        if(!publicExpense51.isNew()){
            list.add(publicExpense51.getRecord());
        }
        
        //��Q�ҁE�x���[�u
        if(!publicExpense57.isNew()){
            list.add(publicExpense57.getRecord());
        }
        
        //����(�S�z�Ə�)
        if(!publicExpense58.isNew()){
            list.add(publicExpense58.getRecord());
        }
        //�Ζ�
        if(!publicExpense66.isNew()){
            list.add(publicExpense66.getRecord());
        }
        //�픚�ҏ���
        if(!publicExpense81.isNew()){
            list.add(publicExpense81.getRecord());
        }
        
        //�픚�̌���
        if(!publicExpense86.isNew()){
            list.add(publicExpense86.getRecord());
        }
        
        //�L�@�q�f�E�ً}
        if(!publicExpense87.isNew()){
            list.add(publicExpense87.getRecord());
        }
        
        //�����a�����΍􃁃`������
        if(!publicExpense88.isNew()){
            list.add(publicExpense88.getRecord());
        }
		
        //[H20.4 �@�����Ή�] fujihara start
        //�����c���M�l��
        if(!publicExpense25.isNew()){
            list.add(publicExpense25.getRecord());
        }
        //[H20.4 �@�����Ή�] fujihara end
        
		return list;
	}
	

}
