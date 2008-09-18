package jp.nichicom.copaychecker;

import java.io.*;
import java.util.*;

import jp.nichicom.copaychecker.util.*;

/**
 * �S�z���ȕ��S�ߌ�`�F�b�N���s�N���X
 * @version 1.00 2008.2.26
 * @author shin fujihara
 */
public class CopayChecker extends Thread { 
	
	private boolean isRun = true;
	
	private int progressCount = 0;
	private String status = " ";
	
	private Exception runException = null;
	
	//�`�F�b�N�J�n������
	private String checkStartDate = "2008-08-1";
	//�`�F�b�N�I��������
	private String checkEndDate = "2008-09-30";
	
	private String[] sameFields = new String[]{"PATIENT_ID", "INSURED_ID", "TARGET_DATE", "CLAIM_DATE", "INSURER_ID", "PROVIDER_ID"};
	
	private boolean isOutLog = false;
	
	public void run(){
		isRun = true;
		try{
			
			Log.info("�`�F�b�N�������J�n���܂��B");
			
			DBConnect db = new DBConnect();
			BufferedWriter objBw = null;
            
            try{
                // Firebird1.5�n���ƃX�L�[�}�ɑ΂���AS��͎g���Ȃ��̂�VIEW�őΉ�����
                for(int s=0;s < 4; s++){
                    // Create����View��
                    int count = s+1;
                    String viewName = "";
                    switch(count){
                    case 1:
                        viewName = "TEMP_PLAN_UNIT";
                        break;
                    case 2:
                        viewName = "TEMP_LIMIT_UNIT";
                        break;
                    case 3:
                        viewName = "TEMP_UNIT";
                        break;
                    case 4:
                        viewName = "TEMP_SERVICE";
                        break;
                    }
                    db.exec(getCreateViewSQL(viewName));
                    // �R�~�b�g����
                    db.commit();
                }
            }catch (Exception e) {
                // ���ʂɃX�L�b�v
            }
			
			try{
				
				//�ϊ����ʃ��O�쐬
				Util.makeDir("logs/copaycheck.csv");
				File rec_data = new File("logs/copaycheck.csv");
				
				OutputStreamWriter objOsr = new OutputStreamWriter(
						new FileOutputStream(rec_data));
				objBw = new BufferedWriter(objOsr);
				
				setStatus("�Ώی����̊m�F�J�n",0);
				
				//�`�F�b�N�Ώۃf�[�^�S���擾
				List check_list = db.execQuery(getCheckListSQL());
				
				setStatus("�Ώی����̊m�F����",0);
				
				Map comparison = null;
				PatientCopay copay = new PatientCopay();
				int list_total = check_list.size();
				
				for (int i = 0; i < list_total; i++){
					
					Map rec = (Map)check_list.get(i);
					
					if (comparison == null){
						comparison = rec;
					}
					
					//�ʃf�[�^�ɐ؂�ւ�����ꍇ
					if (!isSameClaim(comparison, rec)) {
						String[] logline = copay.analize(db.execQuery(getCopaySQL(comparison)));
						writeCheckList(objBw, logline);
						
						comparison = rec;
						
						copay = new PatientCopay();
					}
					
					copay.checkCopay(rec);
					
					setStatus(i + "/" + list_total + "���I�����܂����B", (i * 100) / list_total );
				}
				
				if (comparison != null) {
					String[] logline =copay.analize(db.execQuery(getCopaySQL(comparison)));
					writeCheckList(objBw, logline);
				}
				
				db = null;
				
				
				setStatus(rec_data.getPath() + "�ɁA�ϊ����ʂ�ۑ����Ă��܂��B", 100);
				
				Log.info("�`�F�b�N�������J�n������I�����܂����B");
				
			} catch(Exception e) {
				db.rollback();
				throw e;
			} finally{
				db = null;
				if(objBw != null){
					objBw.close();
				}
			}
		} catch(Exception ex){
			runException = ex;
		} finally{
			isRun = false;
		}
	}
	
	private boolean isSameClaim(Map sip, Map dip) {
		
		for (int i = 0; i < sameFields.length; i++){
			if (!sip.get(sameFields[i]).equals(dip.get(sameFields[i]))){
				return false;
			}
		}
		
		return true;
	}
	
    // VIEW�̍쐬
    private String getCreateViewSQL(String viewName) {
        StringBuffer query = new StringBuffer();
        query.append("RECREATE VIEW ");
        query.append(viewName);
        query.append(" AS");
        query.append(" SELECT");
        query.append(" *");
        query.append(" FROM");
        query.append(" CLAIM_DETAIL_TEXT_2008");
        return query.toString(); 
    }
    
	//�ꗗ�擾
	private String getCheckListSQL() {
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT DISTINCT");
		query.append(" CLAIM.*,");
		query.append(" TEMP_PLAN_UNIT.DETAIL_VALUE AS PLAN_UNIT_VALUE,");
		query.append(" TEMP_LIMIT_UNIT.DETAIL_VALUE AS LIMIT_UNIT_VALUE,");
		query.append(" TEMP_UNIT.DETAIL_VALUE AS UNIT_VALUE,");
		query.append(" M_SERVICE.SERVICE_KIND_NAME,");
		query.append(" PATIENT.PATIENT_FAMILY_NAME,");
		query.append(" PATIENT.PATIENT_FIRST_NAME,");
		query.append(" PROVIDER.PROVIDER_NAME,");
		query.append(" EXTRACT(YEAR FROM CLAIM.TARGET_DATE) || '�N' || EXTRACT(MONTH FROM CLAIM.TARGET_DATE) || '��' AS FORMATED_TARGET_DATE,");
		query.append(" EXTRACT(YEAR FROM CLAIM.CLAIM_DATE) || '�N' || EXTRACT(MONTH FROM CLAIM.CLAIM_DATE) || '��' AS FORMATED_CLAIM_DATE");
		
		query.append(" FROM");
		query.append(" CLAIM,");
		query.append(" TEMP_PLAN_UNIT,");
		query.append(" TEMP_LIMIT_UNIT,");
		query.append(" TEMP_UNIT,");
		query.append(" TEMP_SERVICE,");
		query.append(" M_SERVICE,");
		query.append(" PATIENT,");
		query.append(" PROVIDER");
		query.append(" WHERE");
		query.append(" (CLAIM.CLAIM_DATE BETWEEN '" + checkStartDate + "' AND '" + checkEndDate + "')");
		query.append(" AND (CLAIM.CLAIM_ID = TEMP_PLAN_UNIT.CLAIM_ID)");
		query.append(" AND (TEMP_PLAN_UNIT.SYSTEM_BIND_PATH = 701009)");
		query.append(" AND (CLAIM.CLAIM_ID = TEMP_LIMIT_UNIT.CLAIM_ID)");
		query.append(" AND (TEMP_LIMIT_UNIT.SYSTEM_BIND_PATH = 701010)");
		query.append(" AND (CLAIM.CLAIM_ID = TEMP_UNIT.CLAIM_ID)");
		query.append(" AND (TEMP_UNIT.SYSTEM_BIND_PATH = 701015)");
		query.append(" AND (CLAIM.CLAIM_ID = TEMP_SERVICE.CLAIM_ID)");
		query.append(" AND (TEMP_SERVICE.SYSTEM_BIND_PATH = 701007)");
		query.append(" AND (TEMP_SERVICE.DETAIL_VALUE = M_SERVICE.SERVICE_CODE_KIND)");
		query.append(" AND (CLAIM.PATIENT_ID = PATIENT.PATIENT_ID)");
		query.append(" AND (CLAIM.PROVIDER_ID = PROVIDER.PROVIDER_ID)");
		//�v��P�ʐ������x�z�Ǘ��ΏےP�ʐ�����̃f�[�^�̂ݎ擾����
		query.append(" AND (CAST(TEMP_PLAN_UNIT.DETAIL_VALUE AS INTEGER) < CAST(TEMP_LIMIT_UNIT.DETAIL_VALUE AS INTEGER))");
		//�\�[�g���w��
		query.append(" ORDER BY");
		query.append(" CLAIM.CLAIM_DATE,");
		query.append(" CLAIM.INSURER_ID,");
		query.append(" CLAIM.PROVIDER_ID,");
		query.append(" CLAIM.INSURED_ID,");
        query.append(" CLAIM.CLAIM_ID");
		
		
		
		return query.toString();

	}
	
	private String getCopaySQL(Map rec) throws Exception {
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_SERVICE_NO1,");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_PAY_NO1,");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_SERVICE_NO2,");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_PAY_NO2,");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_SERVICE_NO3,");
		query.append(" CLAIM_PATIENT_DETAIL.SELF_PAY_NO3");
		query.append(" FROM");
		query.append(" CLAIM,");
		query.append(" CLAIM_PATIENT_DETAIL");
		query.append(" WHERE");
		query.append(" (CLAIM.CLAIM_ID = CLAIM_PATIENT_DETAIL.CLAIM_ID)");
		query.append(" AND (CLAIM.PATIENT_ID = " + rec.get("PATIENT_ID") + ")");
		query.append(" AND (CLAIM.INSURED_ID = '" + rec.get("INSURED_ID") + "')");
		query.append(" AND (CLAIM.TARGET_DATE = '" + rec.get("TARGET_DATE") + "')");
		query.append(" AND (CLAIM.CLAIM_DATE = '" + rec.get("CLAIM_DATE") + "')");
		query.append(" AND (CLAIM.INSURER_ID = '" + rec.get("INSURER_ID") + "')");
		query.append(" AND (CLAIM.PROVIDER_ID = '" + rec.get("PROVIDER_ID") + "')");
		
		return query.toString();
	}
	
	
	private void writeCheckList(BufferedWriter objBw, String[] lines) throws Exception {
		
		for (int i = 0; i < lines.length; i++) {
			
			if (!isOutLog) {
				//�w�b�_�o��
				objBw.write("��ی��Ҕԍ�,�ΏێҎ���,�񋟃T�[�r�X,�ڍ�,�Ώ۔N��,�����N��,���Ə��ԍ�,���Ə�����\n");
			}
			objBw.write(lines[i] + "\n");
			isOutLog = true;
		}
		
	}
	
	public boolean existErrorList() {
		return isOutLog;
	}
	
	
	private void setStatus(String title,int value) {
		status = title;
		progressCount = value;
	}
	
	/**
	 * �f�[�^�X�V�^�X�N�̎��s
	 */
	public boolean runTask(MainFrame frame) throws Exception{
		
		setStatus("�Ώی����̊m�F��...",0);
		
		super.start();
		
		while(isRun){
			frame.paintComponents(frame.getGraphics());
			frame.progress.setValue(progressCount);
			frame.status.setText(status);
			Thread.sleep(500);
		}
		
		if(runException != null){
			throw runException;
		}
		
		return true;
	}
}