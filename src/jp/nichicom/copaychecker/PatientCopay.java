package jp.nichicom.copaychecker;

import java.util.*;
import jp.nichicom.copaychecker.util.*;

//�Ώێ҃f�[�^�ێ��N���X
public class PatientCopay {

	/**
	 * �񋟔N��(���O�p)
	 */
	private String target_date = "";
	
	/**
	 * ������(���O�p)
	 */
	private String claim_date = "";
	
	/**
	 * �ΏێҎ���(���O�p)
	 */
	private String patient_nm = "";
	/**
	 * �ی��Ҕԍ�(���O�p)
	 */
	private String insured_id = "";
	
	/**
	 * ���Ə��ԍ�(���O�p)
	 */
	private String provider_id = "";
	
	/**
	 * ���Ə�����(���O�p)
	 */
	private String provider_name = "";
	
	/**
	 * ���p�ҕ��S�z�̌v�Z����
	 */
	private Map copayMap = new LinkedHashMap();
	private Map copayMapError = new HashMap();
	
	private List log = new ArrayList();
	
	private int copay_total = 0;
	/**
	 * ���ȕ��S�z�`�F�b�N
	 * @param rec
	 * @throws Exception
	 */
	public void checkCopay(Map rec) throws Exception{
		
		//�ΏێҎ�����ݒ肷��
		if ("".equals(patient_nm)){
			//PATIENT_FAMILY_NAME,PATIENT_FIRST_NAME,INSURED_ID,PROVIDER_NAME
			target_date = Util.toStr(rec.get("FORMATED_TARGET_DATE"));
			claim_date = Util.toStr(rec.get("FORMATED_CLAIM_DATE"));
			patient_nm = Util.toStr(rec.get("PATIENT_FAMILY_NAME")) + "�@"
                    + Util.toStr(rec.get("PATIENT_FIRST_NAME"));
			insured_id = Util.toStr(rec.get("INSURED_ID"));
			provider_id = Util.toStr(rec.get("PROVIDER_ID"));
			provider_name = Util.toStr(rec.get("PROVIDER_NAME"));
		}
		
		//�v��P�ʐ�
		int plan_unit = Util.toInt(rec.get("PLAN_UNIT_VALUE"));
		//���ђP�ʐ�
		int limit_unit = Util.toInt(rec.get("LIMIT_UNIT_VALUE"));
		//�P�ʐ��P��*10
		int unit = Util.toInt(replaceDot(rec.get("UNIT_VALUE")));
		
		if (limit_unit <= plan_unit){
			return;
		}
		
		//���m�Ȏ��ȕ��S�z���Z�肷��
		int copay = (int)Math.floor((double)((limit_unit - plan_unit) * unit) / 100d);
		copay_total += copay;
		//map�ɑޔ�
		copayMap.put(rec.get("SERVICE_KIND_NAME"), new Integer(copay));
		
		//��������ȕ��S�z���Z�肷��
		int copay_error = (int)Math.floor((double)(limit_unit * unit) / 100d) 
						   - (int)Math.floor((double)(plan_unit * unit) / 100d);
		
		copayMapError.put(rec.get("SERVICE_KIND_NAME"), new Integer(copay_error));
	}
	
	public String[] analize(List copay_list) throws Exception {
		switch (copay_list.size()) {
		//���p�Ҏ��ȕ��S�z�f�[�^�Ȃ�
		case 0:
			//���p�Ҍ��������ւ̈󎚂Ȃ��Ȃ̂ŁA�`�F�b�N���Ȃ�
			break;
			
		//���p�Ҏ��ȕ��S�z�f�[�^����擾
		case 1:
			match((Map)copay_list.get(0));
			break;
			
		//���p�Ҏ��ȕ��S�z�f�[�^�擾�ُ�
		default:
			Log.warning("���ȕ��S�f�[�^�����ُ�(" + copay_list.size() + "):" + patient_nm + insured_id);
			throw new Exception("���ȕ��S�f�[�^�����ُ�(" + copay_list.size() + "):" + patient_nm + insured_id);
		}
		
		String[] result = new String[log.size()];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = (String)log.get(i);
		}
		
		return result;
	}
	
	private void match(Map copay_rec) throws Exception {
		//���ȕ��S�z�e�[�u���̐��`
		Map copayDb = new HashMap();
		
		for (int i = 1; i <= 3; i++) {
			if (!Util.isNull((String)copay_rec.get("SELF_PAY_NO" + i))) {
				copayDb.put((String)copay_rec.get("SELF_SERVICE_NO" + i), new Integer((String)copay_rec.get("SELF_PAY_NO" + i)));
			}
		}
		
		
		
		//���̑��Ƀ}�[�W����Ă���\�����^��
		if (copayMap.size() > 3) {
			
			//DB�ɂ��̑��̓o�^�����邩
			if (copayDb.containsKey("���̑�")) {
				if (isCopayDelta(copay_total, Util.toInt(copayDb.get("���̑�")))) {
					addLogLine("���̑�", copay_total, Util.toInt(copayDb.get("���̑�")));
                    return;
				}
			}
		}
		
		Iterator it = copayMap.keySet().iterator();
		
		//�������z�����[�v
		while (it.hasNext()) {
			Object key = it.next();
			
			//DB�����`�F�b�N
			if (copayDb.containsKey(key)) {
				//�L�[�����݂���΁A�l���`�F�b�N
				if (isCopayDelta(copayDb.get(key), copayMap.get(key))){
					addLogLine(key.toString(), Util.toInt(copayMap.get(key)), Util.toInt(copayDb.get(key)));
				}
				
			} else {
				//��v���ĂȂ������ꍇ�̂݁A�m�F���肢���b�Z�[�W
				if (isCopayDelta(copayMap.get(key), copayMapError.get(key))){
					addLogLine(key.toString(), Util.toInt(copayMap.get(key)));
				}
			}
		}
	}
	
	private boolean isCopayDelta(Object sip, Object dip) {
		return isCopayDelta(Util.toInt(sip), Util.toInt(dip));
	}
	
	private boolean isCopayDelta(int sip, int dip) {
		
        int abs = Math.abs(sip - dip);
        
        if ((1 <= abs) && (abs <= 6)) {
            return true;
        }
        return false;
	}
	private void addLogLine(String service_name, int real) {
		StringBuffer line = new StringBuffer();
		
		line.append("�S�z���ȕ��S�z�̐������z���m�F�ł��܂���ł����B");
		line.append(real);
		line.append("�~�Ő������Ă��邩�m�F���Ă��������B");
		
		log.add(getLogLine(service_name, line.toString()));
	}
	
	private void addLogLine(String service_name, int real, int falt) {
		StringBuffer line = new StringBuffer();
		
		line.append(real);
		line.append("�~�̐�����");
		line.append(falt);
		line.append("�~�ň󎚂��Ă���\��������܂��B");
		
		log.add(getLogLine(service_name, line.toString()));
	}
	
	private String getLogLine(String service_name, String msg) {
		StringBuffer line = new StringBuffer();
		
		String separate = ",";

		//��ی��Ҕԍ�
		line.append(insured_id);
		line.append(separate);
		
		//�ΏێҎ���
		line.append(patient_nm);
		line.append(separate);

		//�񋟃T�[�r�X
		line.append(service_name);
		line.append(separate);
		
		//�ڍ�
		line.append(msg);
		line.append(separate);
		
		//�Ώ۔N��
		line.append(target_date);
		line.append(separate);
		
		//�����N��
		line.append(claim_date);
		line.append(separate);
		//���Ə��ԍ�
		line.append(provider_id);
		line.append(separate);
		
		//���Ə�����
		line.append(provider_name);
		
		return line.toString();

	}
	
	
	private String replaceDot(Object value) {
		
		if (value instanceof String) {
			String result = ((String)value).replaceAll("\\.", "");
			
			while(result.length() < 4) {
				result += "0";
			}
			return result;
		}
		return "";
	}
	
}
