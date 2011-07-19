/*
 * �쐬��: 2006/06/08
 *
 */
package jp.or.med.orca.qkan.affair.qm.qm001;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * �V�X�e������o�^�\�ȃ}�X�^�̕␳�p�^�X�N�N���X 
 * @author n0153
 *
 */
public class QM001UpdateMasterTask {
	// �}�X�^�o�[�W����
	public String version = "";
	
	/** 
	 * �R���X�g���N�^
	 */
	public QM001UpdateMasterTask(){
	}

	/** 
	 * �R���X�g���N�^
	 */
	public QM001UpdateMasterTask(String version){
		setVersion(version);
	}
	
	/**
	 * �o�[�W�����␳�^�X�N�Ǘ�
	 * @param dbm
	 * @throws Exception
	 */
	public void adjustTask(ACDBManager dbm) throws Exception{
		
		try{

			// �\�h�Ń^�X�N
			task1(dbm);
            
			//�K��Ō�×{��̎����o�הŃ^�X�N
            task2(dbm);
            
            //�V���Ɋւ��鎖�Ə����̎����␳(V540)
            task3(dbm);
            
            //����21�N4���@�����ɂ����鎖�Ə��̐��̈ڍs(V545)
            task4(dbm);
            
            //����21�N4���@�����@���p�҂̌�����␳(V546)
            task5(dbm);
            
            
            // [ID:0000493][Tozo TANAKA] 2009/04/28 add begin �yDB�␳�z�s���ȃT�[�r�X�f�[�^(����f�Ô)�폜�Ή�
            ArrayList tableYears = taskDeleteJunkServiceDetail(dbm);
            // [ID:0000493][Tozo TANAKA] 2009/04/28 add end �yDB�␳�z�s���ȃT�[�r�X�f�[�^(����f�Ô)�폜�Ή�

		}catch(Exception ex){
			throw ex;
		}
	}
	
	/**
	 * �\�h�o�הŃ^�X�N
	 * @param dbm DBManager
	 * @throws Exception
	 */
	public void task1(ACDBManager dbm) throws Exception{

		try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
			
			// �ǉ����j���[ID
			int menuId = 10707;
			
			VRMap sqlParam = new VRHashMap();
			VRBindPathParser.set("MENU_ID", sqlParam, new Integer(menuId));
			
			// M_MENU���X�V����Ă���@���@PROVIDER_MENU���X�V����Ă��Ȃ��ꍇ
			// �X�V�^�X�N�𑖂点��B
			if(!(dbm.executeQuery(op.getSQL_GET_EXISTING_M_MENU(sqlParam)).isEmpty()) && 
					(dbm.executeQuery(op.getSQL_GET_EXISTING_PROVIDER_MENU(sqlParam)).isEmpty())){
			
				// ���p�Ҍ���T�[�r�X�e�[�u��
                op.adjustPatientKohiService(dbm);
				
				// ���Ə����j���[�e�[�u��
                op.adjustProviderMenu(dbm, menuId);
				
				// �R�~�b�g
				dbm.commitTransaction();
				
			}
			
		}catch(Exception ex){
			dbm.rollbackTransaction();
			throw ex;
		}
	}
    /**
     * �K��Ō�×{��̎����o�הŃ^�X�N
     * @param dbm DBManager
     * @throws Exception
     */
    public void task2(ACDBManager dbm) throws Exception{

        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
            
            // �ǉ����j���[ID
            int menuId = 10608;
            
            VRMap sqlParam = new VRHashMap();
            VRBindPathParser.set("MENU_ID", sqlParam, new Integer(menuId));
            
            // M_MENU���X�V����Ă���@���@PROVIDER_MENU���X�V����Ă��Ȃ��ꍇ
            // �X�V�^�X�N�𑖂点��B
            if(!(dbm.executeQuery(op.getSQL_GET_EXISTING_M_MENU(sqlParam)).isEmpty()) && 
                    (dbm.executeQuery(op.getSQL_GET_EXISTING_PROVIDER_MENU(sqlParam)).isEmpty())){
                            
                // ���Ə����j���[�e�[�u��
                op.adjustProviderMenu(dbm, menuId);
                
                // �R�~�b�g
                dbm.commitTransaction();
                
            }
            
        }catch(Exception ex){
            dbm.rollbackTransaction();
            throw ex;
        }
    }
    
	public void setVersion(String version){
		this.version = version;
	}
	
	public String getVersion(){
		return this.version;
	}

    /**
     * �V���Ɋւ��鎖�Ə����̎����␳(V540)
     * @param dbm
     * @throws Exception
     * 
     * @author Masahiko_Higuchi
     * @since V540
     */
    public void task3(ACDBManager dbm) throws Exception{
        
        try{
        QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
        
            // �Z�������×{���i�V���j
            String tankiRouken = "12211";
            // �V��
            String rouken = "15211";
            // ���\�h�Z�������×{���i�V���j
            String yobouTankiRouken = "12511";
            String[] services = {tankiRouken,rouken,yobouTankiRouken};
            // �{�ݓ��̋敪�i�̐��j�A�×{�̐��ێ����ʉ��Z�A�^�[�~�i���P�A���Z
            String[] serviceDetailsTankiRouken = {"1220120","1220121"};
            String[] serviceDetailsRouken = {"1520122","1520123","1520124"};
            String[] serviceDetailsYobouTankiRouken = {"1250116","1250117"};
            // ���ʊi�[�p
            VRList resultList = new VRArrayList();
            VRList updateList = new VRArrayList();
            VRMap updateMap;
            VRHashMap sqlParam =null;
            // �A�b�v�f�[�g�O�ł��邩���m�F����
            resultList = dbm.executeQuery(op.getSQL_GET_PROVIDER_SERVICE_ROUKEN(null));
            VRMap checkMap = (VRMap)resultList.getData(0);
            // �擾������0���̏ꍇ�͎����␳����B
            if(ACCastUtilities.toInt(checkMap.getData(0),0) == 0){
                resultList = new VRArrayList();
                // ���T�[�r�X�����[�v
                for(int i=0;i<services.length;i++){
                    sqlParam = new VRHashMap();
                    sqlParam.setData("SYSTEM_SERVICE_KIND_DETAIL",services[i]);
                    // �擾����
                    resultList = (VRList)dbm.executeQuery(op.getSQL_GET_PROVIDER_SERVICE_ID(sqlParam));
                    // �擾�������[�v
                    for(int k=0;k<resultList.size();k++){
                        VRMap map = (VRMap)resultList.getData(k);
                        updateMap = new VRHashMap();
                        String[] details = {};
                        // ���Ə��T�[�r�XID
                        int id = ACCastUtilities.toInt(map.getData(0),-1);
                        // ��̒l�̏ꍇ�͏I��
                        if(id == -1){
                            break;
                        }
                        // ����
                        // ���ږ��̊i�[���l��ݒ�
                        if(tankiRouken.equals(services[i])){
                            details = serviceDetailsTankiRouken;
                        }else if(rouken.equals(services[i])){
                            details = serviceDetailsRouken;
                        }else if(yobouTankiRouken.equals(services[i])){
                            details = serviceDetailsYobouTankiRouken;
                        }
                        // �ݒ�
                        for(int j=0;j<details.length;j++){
                            updateMap = new VRHashMap();
                            updateMap.setData("PROVIDER_SERVICE_ID",ACCastUtilities.toInteger(id));
                            updateMap.setData("SYSTEM_BIND_PATH",details[j]);
                            // �����l�͈ꗥ�w�P:�Ȃ��x�Őݒ肷��B
                            updateMap.setData("DETAIL_VALUE",new Integer(1));
                            updateList.add(updateMap);
                        }
                    }
                }
                // �X�V�Ώۂ����݂���ꍇ
                if(!updateList.isEmpty()){
                    for(int l=0;l<updateList.size();l++){
                        VRMap result = (VRMap)updateList.getData(l);
                        dbm.executeUpdate(op.getSQL_INSERT_PROVIDER_SERVICE_DETAIL_INTEGER(result));
                    }
                    // �R�~�b�g
                    dbm.commitTransaction();
                }
            }
            
            
        }catch(Exception ex){
            // ���[���o�b�N
            dbm.rollbackTransaction();
        }
        
    }
    // [ID:0000444][Tozo TANAKA] 2009/03/12 add begin ����21�N4���@�����Ή�
    /**
     * ����21�N4���@�����ɂ����鎖�Ə��̐��̈ڍs(V545)
     * @param dbm
     * @throws Exception
     * 
     * @author Tozo_TANAKA
     * @since V545
     */
    public void task4(ACDBManager dbm) throws Exception{
        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();

            //���A�b�v�f�[�g�O�ł��邩���m�F����B
            //�@������̎��Ə��̐��ɂ������݂��Ȃ�BindPath�Ō�����������B
            VRList rows = dbm.executeQuery(op
                    .getSQL_GET_PROVIDER_SERVICE_DETAIL_H2104(null));
            if (rows.size() > 0
                    && (ACCastUtilities.toInt(((Map) rows.get(0))
                            .get("COUNTVAL"), 0) > 0)) {
                // �擾������0���łȂ���Ε␳�̕K�v���Ȃ����߁A�������I������B
                return;
            }
            
            // �����̂܂܈ڍs��
            String[][] listForCopy = new String[][] {
            // �ʏ����/�h�{���P�̐�/
                    { "1150108", "1150113", },
                    // �ʏ����/�{�ݓ��̋敪/
                    { "1150101", "1150115", },
                    // �ʏ����/�ʋ@�\�P���̐�/
                    { "1150102", "1150116", },
                    // �ʏ����n/�{�ݓ��̋敪/
                    { "1160101", "1160112", },
                    // �Z�������×{���i���V�l�ی��{�݁j/�E���̌����ɂ�錸�Z�̏�/
                    { "1220108", "1220126", },
                    // �Z�������×{���i�a�@�×{�^�j/�{�ݓ��̋敪/
                    { "1230101", "1230124", },
                    // �Z�������×{���i�a�@�×{�^�j/�l���z�u�敪/
                    { "1230102", "1230126", },
                    // �Z�������×{���i�a�@�×{�^�j/���j�b�g�P�A�̐�/
                    { "1230118", "1230127", },
                    // ����{�ݓ����Ґ������/�{�ݓ��̋敪/
                    { "1330105", "1330108", },
                    // ������x��/����̐��������Ə����Z�̗L��/
                    { "1430103", "1430104", },
                    // ���V�l�����{��/�h�{�}�l�W�����g�̐�/
                    { "1510109", "1510134", },
                    // ���V�l�ی��{��/�h�{�}�l�W�����g�̐�/
                    { "1520106", "1520130", },
                    // ���V�l�ی��{��/�E���̌����ɂ�錸�Z�̏�/
                    { "1520109", "1520131", },
                    // ���×{�^��Î{�݁i�a�@�×{�^�j/�h�{�}�l�W�����g�̐�/
                    { "1530107", "1530126", },
                    // ���×{�^��Î{�݁i�a�@�×{�^�j/�{�ݓ��̋敪/
                    { "1530101", "1530128", },
                    // ���×{�^��Î{�݁i�a�@�×{�^�j/�l���z�u�敪/
                    { "1530102", "1530129", },
                    // ���×{�^��Î{�݁i�a�@�×{�^�j/���j�b�g�P�A�̐�/
                    { "1530119", "1530131", },
                    // ���×{�^��Î{�݁i�f�Ï��^�j/�h�{�}�l�W�����g�̐�/
                    { "1530205", "1530225", },
                    // ���×{�^��Î{�݁i�F�m�ǎ����^�j/�h�{�}�l�W�����g�̐�/
                    { "1530304", "1530322", },
                    // �F�m�ǑΉ��^�ʏ����/�h�{���P�̐�/
                    { "1720104", "1720109", },
                    // �n�斧���^���V�l�����{��/�h�{�}�l�W�����g�̐�/
                    { "1540109", "1540135", },
                    // ���\�h�Z�������×{���i���V�l�ی��{�݁j/�E���̌����ɂ�錸�Z�̏�/
                    { "1250103", "1250122", },
                    // ���\�h�Z�������×{���i�a�@�×{�^�j/�{�ݓ��̋敪/
                    { "1260101", "1260122", },
                    // ���\�h�Z�������×{���i�a�@�×{�^�j/�l���z�u�敪/
                    { "1260102", "1260123", },
                    // ���\�h�Z�������×{���i�a�@�×{�^�j/��ԋΖ������/
                    { "1260103", "1260124", },
                    // ���\�h�Z�������×{���i�a�@�×{�^�j/���j�b�g�P�A�̐�/
                    { "1260105", "1260125", }, };
            // ��1�ȊO��2�Ɉڍs��
            String[][] listFor1Or2 = new String[][] {
            // �Z�������×{���i�a�@�×{�^�j/�×{���/
                    { "1230104", "1230123", },
                    // ���×{�^��Î{�݁i�a�@�×{�^�j/�×{���/
                    { "1530104", "1530127", },
                    // ���\�h�Z�������×{���i�a�@�×{�^�j/�×{���/
                    { "1260106", "1260121", }, };

            // ��4�̂�6�Ɉڍs��
            String[][] listFor4To6 = new String[][] {
            // �Z�������×{���i�a�@�×{�^�j/��ԋΖ������/
                    { "1230103", "1230125", },
                    // ���×{�^��Î{�݁i�a�@�×{�^�j/��ԋΖ������/
                    { "1530103", "1530130", }, };

            VRArrayList providerDetails = QkanCommon
                    .getProviderServiceDetailCustom(dbm, "");

            Iterator it = providerDetails.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                int end;
                // �L�[�̒P���]�L
                end = listForCopy.length;
                for (int i = 0; i < end; i++) {
                    Object val = VRBindPathParser.get(listForCopy[i][0], row);
                    if (val != null) {
                        VRBindPathParser.set(listForCopy[i][1], row, val);
                    }
                }

                // �����n�r���񋟑̐�/���w�Ö@�̈ڍs
                // ���n�r���񋟑̐�/���w�Ö@ II �� ���w�Ö@ I
                if (ACCastUtilities.toInt(VRBindPathParser.get("3010104", row),
                        0) == 2) {
                    // ���w�Ö@ II�̒l��2(�`�F�b�N���t���Ă���)�̏ꍇ
                    // ���w�Ö@ I�̒l��2(�`�F�b�N���t���Ă���)�ɂ���B
                    VRBindPathParser.set("3010103", row, new Integer(2));
                }
                // ���w�Ö@ II�̃L�[���폜����B
                row.remove("3010104");

                // ���×{����̈ڍs
                // 1�ȊO��2�Ƃ��ē]�L
                end = listFor1Or2.length;
                for (int i = 0; i < end; i++) {
                    Object val = VRBindPathParser.get(listFor1Or2[i][0], row);
                    if (val != null) {
                        Object newVal = new Integer(2);
                        if (ACCastUtilities.toInt(val, 0) == 1) {
                            newVal = val;
                        }
                        VRBindPathParser.set(listFor1Or2[i][1], row, newVal);
                    }
                }

                // ����ԋΖ�������̈ڍs
                // 4�̂�6�Ƃ��ē]�L
                end = listFor4To6.length;
                for (int i = 0; i < end; i++) {
                    Object val = VRBindPathParser.get(listFor4To6[i][0], row);
                    if (val != null) {
                        Object newVal = val;
                        if (ACCastUtilities.toInt(val, 0) == 4) {
                            newVal = new Integer(6);
                        }
                        VRBindPathParser.set(listFor4To6[i][1], row, newVal);
                    }
                }

            }

            // �X�V
             QkanCommon.updateProviderServiceDetailCustom(dbm,
             providerDetails, "(PROVIDER_ID IS NOT NULL)");
            
        }catch(Exception ex){
            dbm.rollbackTransaction();
            throw ex;
        }
    }     
    // [ID:0000444][Tozo TANAKA] 2009/03/12 add end

    // [ID:0000447][Shin Fujihara] 2009/04 add begin ����21�N4���@�����Ή�
    /**
     * ����21�N4���@�����@���p�҂̌�����␳(V546)
     * @param dbm
     * @throws Exception
     * 
     * @author Shin Fujihara
     * @since V546
     */
    public void task5(ACDBManager dbm) throws Exception{
        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
            
            String[][] kohiList = new String[][]{
            		//���j�\�h�@�u��ʊ��ҁv
            		{"1001","12211"},
            		{"1001","12511"},
            		{"1001","15211"},
            		//8102:����(�n���P�ƁE���ی�)
            		{"8102","17311"},
            		{"8102","17511"}
            };
            
            for (int i = 0; i < kohiList.length; i++){            	
            	VRMap sqlParam = new VRHashMap();
            	sqlParam.put("KOHI_TYPE", kohiList[i][0]);
            	sqlParam.put("SYSTEM_SERVICE_KIND_DETAIL", kohiList[i][1]);
            	//�C��
            	VRList list = dbm.executeQuery(op.getSQL_GET_PATIENT_KOHI_H2104(sqlParam));
            	
            	Iterator it = list.iterator();
            	
            	while(it.hasNext()){
            		VRMap row = (VRMap)it.next();
            		row.put("SYSTEM_SERVICE_KIND_DETAIL", kohiList[i][1]);
            		dbm.executeUpdate(op.getSQL_INSERT_PATIENT_KOHI_H2104(row));
            	}
            }
            
        }catch(Exception ex){
            dbm.rollbackTransaction();
            throw ex;
        }
    }     
    // [ID:0000447][Shin Fujihara] 2009/04 add end ����21�N4���@�����Ή�
    
    
    // [ID:0000493][Tozo TANAKA] 2009/04/28 add begin �yDB�␳�z�s���ȃT�[�r�X�f�[�^(����f�Ô)�폜�Ή�
    public ArrayList taskDeleteJunkServiceDetail(ACDBManager dbm) throws Exception{
        ArrayList tableYears = new ArrayList();
        try{ 
            QM001UpdateMasterOperation op = new QM001UpdateMasterOperation();
            
            VRList rows = dbm.executeQuery(op.getSQL_GET_SERVICE_DETAIL_YEAR_RANGE(null));
            if(!rows.isEmpty()){
                VRMap row = (VRMap)rows.get(0);
                int minumumYear = ACCastUtilities.toInt(row.get("MINIMUM_YEAR"),0);
                int maximumYear = ACCastUtilities.toInt(row.get("MAXIMUM_YEAR"),0);
                for(int year=minumumYear; year<=maximumYear; year++){
                    try{
                        VRMap sqlParam = new VRHashMap();
                        sqlParam.put("YEAR", ACCastUtilities.toInteger(year));
                        
                        //�e�[�u�����݃`�F�b�N
                        dbm.executeQuery(op.getSQL_GET_SERVICE_DETAIL_TABLE_ROWS(sqlParam));
                        
                        //�G���[�łȂ���Α���
                        //����f�Ô�̏d�x�×{�Ǘ�(3010142)�̍폜
                        dbm.executeUpdate(op.getSQL_DELETE_JUNK_SERVICE_DETAIL1(sqlParam));
                        //���×{�^��Î{�݂̓���f�Ô�̏d�x�×{�Ǘ�(3010104)�̍폜
                        dbm.executeUpdate(op.getSQL_DELETE_JUNK_SERVICE_DETAIL2(sqlParam));
                        
				        // [ID:0000503][Masahiko Higuchi] 2009/05/01 add begin�y�T�[�r�X�\��E���сz����f�Ô�ڂ̕\������̉��C
                        dbm.executeUpdate(op.getSQL_DELETE_JUNK_SERVICE_DETAIL3(sqlParam));
                        dbm.executeUpdate(op.getSQL_DELETE_JUNK_SERVICE_DETAIL4(sqlParam));
				        // [ID:0000503][Masahiko Higuchi] 2009/05/01 add end
                        
                        tableYears.add(new Integer(year));
                    }catch(Exception ex){
                        //�e�[�u���s���݂ɂ��G���[�𖳎�
                    }
                }   
            }
            
        }catch(Exception ex){
            dbm.rollbackTransaction();
            throw ex;
        }
        return tableYears;
    }     
    // [ID:0000493][Tozo TANAKA] 2009/04/28 add end �yDB�␳�z�s���ȃT�[�r�X�f�[�^(����f�Ô)�폜�Ή�
    
}
