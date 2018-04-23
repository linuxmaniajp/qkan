package jp.nichicom.ac.lib.care.claim.print.schedule;

import java.util.Date;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.ACDateUtilities;

/**
 * ���n��ŃT�[�r�X���\�[�g���邽�߂�Comparator
 * �T�[�r�X�񋟓��A�J�n�����A�P�ʐ��̏����Ń\�[�g
 */
public class ServiceDateTimeLineComparator implements java.util.Comparator<Map<String, Object>> {
	
	private String unitKey;

	public ServiceDateTimeLineComparator(String unitKey) {
		this.unitKey = unitKey;
	}

	public int compare(Map<String, Object> object1, Map<String, Object> object2) {
        Date date1 = ACCastUtilities.toDate(object1.get("SERVICE_DATE"), null);
        Date date2 = ACCastUtilities.toDate(object2.get("SERVICE_DATE"), null);
        
        if (date1 != null && date2 == null) {
        	return 1;
        } else if (date1 == null && date2 != null) {
        	return -1;
        }
        int dateResult = date1.compareTo(date2);
        if (dateResult != 0) {
        	return dateResult;
        }
        
        //���t�������ꍇ�A�J�n����������
        date1 = ACCastUtilities.toDate(object1.get("3"), null);
        date2 = ACCastUtilities.toDate(object2.get("3"), null);
        //�ǂ��炩�������͂̏ꍇ�A�����͂̕�����
        if (date1 != null && date2 == null) {
            return 1;
        } else if (date1 == null && date2 != null) {
            return -1;
        }
        if (date1 != null && date2 != null) {
            Integer hour1 = ACDateUtilities.getHourOfDay(date1);
            Integer hour2 = ACDateUtilities.getHourOfDay(date2);
            int hourResult = hour1.compareTo(hour2);
            if (hourResult != 0) {
            	return hourResult;
            }
            
            Integer minute1 = ACDateUtilities.getMinute(date1);
            Integer minute2 = ACDateUtilities.getMinute(date2);
            int minuteResult = minute1.compareTo(minute2);
            if (minuteResult != 0) {
            	return minuteResult;
            }
        }
        if (unitKey != null 
        		&& object1.containsKey(unitKey)
        		&& object2.containsKey(unitKey)) {
            //�J�n�����������ꍇ�A�P�ʐ��Ń\�[�g
            Integer unit1 = ACCastUtilities.toInt(object1.get(unitKey), 0);
            Integer unit2 = ACCastUtilities.toInt(object2.get(unitKey), 0);
            return unit1.compareTo(unit2);
        }
        return 0;
    }
}
