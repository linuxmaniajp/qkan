package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �������ƃ}�X�^(M_SJ_SERVICE_CODE)���擾���邽�߂̃N���X
 * 
 * @since V7.3.0
 * @author Yoichiro.Kamei
 */
public class QkanSjServiceCodeManager {
	
	// �Ώۂ̃V�X�e���T�[�r�X��ރR�[�h�i�Ǝ��j
	public static List<String> dokujiCodes = Arrays.asList(new String[]{
		"50211", "50611" //A2, A6
	});
	
	// �Ώۂ̃T�[�r�X��ރR�[�h�i�Ǝ��j
	public static List<String> dokujiKinds  = Arrays.asList(new String[]{
			"A2", "A6"
	});
	
	// �Ώۂ̃V�X�e���T�[�r�X��ރR�[�h�i���\�h�P�A�}�l�W�����g�j
	public static List<String> afCodes = Arrays.asList(new String[]{
		"51511" //AF
	});
	
	// �Ώۂ̃T�[�r�X��ރR�[�h�i���\�h�P�A�}�l�W�����g�j
	public static List<String> afKinds  = Arrays.asList(new String[]{
			"AF"
	});
	
	// �Ώۂ̃V�X�e���T�[�r�X��ރR�[�h�i�Ǝ��藦�j
	public static List<String> teiritsuCodes = Arrays.asList(new String[]{
		  "50311", "50711"   //A3, A7
		, "50911", "51111", "51311" //A9, AB, AD
	});
	
	// �Ώۂ̃T�[�r�X��ރR�[�h�i�Ǝ��藦�j
	public static List<String> teiritsuKinds = Arrays.asList(new String[]{
		  "A3", "A7", "A9", "AB", "AD"
	});
	
	// �Ώۂ̃V�X�e���T�[�r�X��ރR�[�h�i�Ǝ���z�j
	public static List<String> teigakuCodes = Arrays.asList(new String[]{
		  "50411", "50811"  //A4, A8
		, "51011", "51211", "51411" //AA, AC, AE
	});
	
	// �Ώۂ̃T�[�r�X��ރR�[�h�i�Ǝ���z�j
	public static List<String> teigakuKinds = Arrays.asList(new String[]{
		  "A4", "A8", "AA", "AC", "AE"
	});
	
	//TODO: ��L�R�[�h��`�́A�\�ł���΁A���������ɃT�[�r�X�}�X�^����ݒ肷��B
	
	
	// �Ώۂ̃V�X�e���T�[�r�X��ރR�[�h�i�Ǝ��藦�A�Ǝ���z�j
	public static List<String> teiritsuTeigakuCodes = new ArrayList();
	static {
		teiritsuTeigakuCodes.addAll(teiritsuCodes);
		teiritsuTeigakuCodes.addAll(teigakuCodes);
	}
	
	// �Ώۂ̃T�[�r�X��ރR�[�h�i�Ǝ��藦�A�Ǝ���z�j
	public static List<String> teiritsuTeigakuKinds = new ArrayList();
	static {
		teiritsuTeigakuKinds.addAll(teiritsuKinds);
		teiritsuTeigakuKinds.addAll(teigakuKinds);
	}
	
	// �Ώۂ̃V�X�e���T�[�r�X��ރR�[�h�i�Ǝ��E�Ǝ��藦�A�Ǝ���z�j
	public static List<String> dokujiTeiritsuTeigakuCodes = new ArrayList();
	static {
		dokujiTeiritsuTeigakuCodes.addAll(dokujiCodes);
		dokujiTeiritsuTeigakuCodes.addAll(teiritsuCodes);
		dokujiTeiritsuTeigakuCodes.addAll(teigakuCodes);
	}
	
	// �Ώۂ̃T�[�r�X��ރR�[�h�i�Ǝ��E�Ǝ��藦�A�Ǝ���z�j
	public static List<String> dokujiTeiritsuTeigakuKinds = new ArrayList();
	static {
		dokujiTeiritsuTeigakuKinds.addAll(dokujiKinds);
		dokujiTeiritsuTeigakuKinds.addAll(teiritsuKinds);
		dokujiTeiritsuTeigakuKinds.addAll(teigakuKinds);
	}
	
	private static String lastUpdateTime; //�}�X�^�̍ŏI�X�V�����i�ő�l�j
	private static final int serviceCodeCacheLimit = 1000;
	private static HashMap<String, VRMap> serviceCodeCache = new HashMap<String, VRMap>();

	/**
	 * �}�X�^���X�V����Ă���΃L���b�V�����N���A���܂��B
	 * @throws Exception 
	 */
	public static synchronized void clearCacheIfUpdated(ACDBManager dbm) throws Exception {
		String nowLastTime = getLastUpdateTime(dbm);
		if (!nowLastTime.equals(lastUpdateTime)) {
			clearCache();
			lastUpdateTime = nowLastTime;
		}
	}
	
	/**
	 * �T�[�r�X�R�[�h�̃L���b�V�����N���A���܂��B
	 */
	public static synchronized void clearCache() {
		serviceCodeCache.clear();
	}

	/**
	 * �������ƃT�[�r�X�R�[�h�}�X�^�̃L�[�𐶐����܂��B
	 * 
	 * @param insurerId
	 *            �ی��Ҕԍ�
	 * @param systemServiceKindDetail
	 *            �V�X�e���T�[�r�X��ރR�[�h
	 * @param itemCode
	 *            �T�[�r�X���ڃR�[�h
	 * @return �������ƃT�[�r�X�R�[�h�}�X�^�̃L�[
	 */
	public static String createSjServiceCodeKey(String insurerId,
			String systemServiceKindDetail, String itemCode) {
		StringBuilder sb = new StringBuilder();
		sb.append(insurerId);
		sb.append(systemServiceKindDetail);
		sb.append(itemCode);
		return sb.toString();
	}

	/**
	 * �Ώ۔N���ɂ����鑍�����ƃT�[�r�X�R�[�h�}�X�^���L�[���P���擾���܂��B
	 * 
	 * @param dbm
	 * @param key
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
	public static VRMap getSjServiceCodeByKey(ACDBManager dbm, String key,
			Date targetDate) throws Exception {

		// �L���b�V���ɂ���΃L���b�V������擾
		String cacheKey = key + "-"
				+ VRDateParser.format(targetDate, "yyyy/MM/dd");
		if (serviceCodeCache.containsKey(cacheKey)) {
			return serviceCodeCache.get(cacheKey);
		}

		VRMap param = new VRHashMap();
		param.put("SYSTEM_SERVICE_CODE_ITEM", key);
		VRList list = getSjServiceCode(dbm, targetDate, param);
		if (list.size() > 0) {
			VRMap data = (VRMap) list.get(0);
			if (serviceCodeCache.size() > serviceCodeCacheLimit) {
				// �L���b�V�����E�𒴂����炷�ׂăN���A�i��ʌ����΍�j
				serviceCodeCache.clear();
			}
			
			convertServiceCodeColumn(data);
			
			// �L���b�V���Ɋi�[
			serviceCodeCache.put(cacheKey, data);
			return data;
		}
		
		// 2017/6/21 [Yoichiro Kamei] add - begin ���\�h�P�A�}�l�W�����g�Ή�
		if (key == null || "".equals(key)) {
			return new VRHashMap();
		}
		// �T�[�r�X��ނ�AF�̏ꍇ
		// �ی��ғƎ��̃}�X�^���擾�ł��Ȃ���΍���̃}�X�^����擾����
		String insurerId = key.substring(0, 6);
		String kind = key.substring(6, 11);
		String item = key.substring(11, 15);		
		if (QkanSjServiceCodeManager.afCodes.contains(kind)) {	
			param = new VRHashMap();			
			param.put("INSURER_ID", insurerId);
			param.put("SYSTEM_SERVICE_KIND_DETAIL", kind);
			param.put("SERVICE_CODE_ITEM", item);
			list = getAfServiceCode(dbm, targetDate, param);
			if (list.size() > 0) {
				VRMap data = (VRMap) list.get(0);
				if (serviceCodeCache.size() > serviceCodeCacheLimit) {
					// �L���b�V�����E�𒴂����炷�ׂăN���A�i��ʌ����΍�j
					serviceCodeCache.clear();
				}
				
				// �L���b�V���Ɋi�[
				serviceCodeCache.put(cacheKey, data);
				return data;
			}		
		}
		// 2017/6/21 [Yoichiro Kamei] add - end

		return new VRHashMap();
	}
	
	//�������ƃT�[�r�X�R�[�h�}�X�^���T�[�r�X�R�[�h�}�X�^�̍��ڒl�ɕϊ�����B
	//�ϊ��o���Ȃ����̂́A�Œ�l���Z�b�g
	private static void convertServiceCodeColumn(VRMap data) {
		// ���t�Ǘ����x�z�Ώۃt���O
		String gendoKbn = ACCastUtilities.toString(data.get("SHIKYU_GENDOGAKU_TAISHO_KBN"), "");
		if ("3".equals(gendoKbn)) {
			data.put("LIMIT_AMOUNT_OBJECT", 1); // ���t�Ǘ����x�z�Ώ�
		} else {
			data.put("LIMIT_AMOUNT_OBJECT", 2); // ���t�Ǘ����x�z�ΏۊO
		}
		
		// �T�[�r�X���Z�t���O
		data.put("SERVICE_ADD_FLAG", 1); //�P��
		
		// �W�v�W�����敪
		String santeiTani = ACCastUtilities.toString(data.get("SANTEI_TANI"), "");
		if ("01".equals(santeiTani)) {
			data.put("TOTAL_GROUPING_TYPE", 1);
		} else if ("02".equals(santeiTani)) {
			data.put("TOTAL_GROUPING_TYPE", 2);
		} else if ("03".equals(santeiTani)) {
			data.put("TOTAL_GROUPING_TYPE", 3);
		} else if ("05".equals(santeiTani)) {//1�T�Ԃɂ��́A���P�ʂɕϊ�
			data.put("TOTAL_GROUPING_TYPE", 2);
		}

		// �{�̕�V�t���O
		data.put("SERVICE_MAIN_FLAG", 1); //�{�̕�V
		// �a���敪
		data.put("ROOM_TYPE", 0);
		// ���Z���
		data.put("SERVICE_ADD_TYPE", 0);
		// �������P����
		data.put("SERVICE_STAFF_UNIT", 0);
		// �E�v���L�ڕK�{�t���O
		data.put("SUMMARY_FLAG", 0);
		// �E�v������
		data.put("SUMMARY_MEMO", "0");
		// �N���X���
		data.put("CLASS_TYPE", 0);
		// �R�[�hID
		data.put("CODE_ID", 0);
		// �ҏW�\�t���O
		data.put("EDITABLE_FLAG", 0);
	}

	/**
	 * �Ώ۔N���ɂ����鑍�����ƃT�[�r�X�R�[�h�}�X�^�擾�֐��ł��B
	 * 
	 * @param dbm
	 *            DBManager
	 * @param targetDate
	 *            �Ώ۔N��
	 * @return �f�[�^�x�[�X���擾�������ʃ��X�g
	 * @throws Exception
	 *             ������O
	 */
	public static VRList getSjServiceCode(ACDBManager dbm, Date targetDate, VRMap param)
			throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" M_SJ_SERVICE_CODE.SYSTEM_SERVICE_CODE_ITEM,");
		sb.append(" M_SJ_SERVICE_CODE.INSURER_ID,");
		sb.append(" M_SJ_SERVICE_CODE.SYSTEM_SERVICE_KIND_DETAIL,");
		sb.append(" M_SJ_SERVICE_CODE.TEKIYO_ST_DATE,");
		sb.append(" M_SJ_SERVICE_CODE.TEKIYO_ED_DATE,");
		sb.append(" M_SJ_SERVICE_CODE.SERVICE_CODE_KIND,");
		sb.append(" M_SJ_SERVICE_CODE.SERVICE_CODE_ITEM,");
		sb.append(" M_SJ_SERVICE_CODE.SERVICE_NAME,");
		sb.append(" M_SJ_SERVICE_CODE.SERVICE_UNIT,");
		sb.append(" M_SJ_SERVICE_CODE.SANTEI_TANI,");
		sb.append(" M_SJ_SERVICE_CODE.SEIGEN_NISSU_KAISU,");
		sb.append(" M_SJ_SERVICE_CODE.SANTEI_KAISU_SEIGEN_KIKAN,");
		sb.append(" M_SJ_SERVICE_CODE.SHIKYU_GENDOGAKU_TAISHO_KBN,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI,");
		sb.append(" M_SJ_SERVICE_CODE.KYUFURITSU,");
		sb.append(" M_SJ_SERVICE_CODE.FUTANGAKU,");
		sb.append(" M_SJ_SERVICE_CODE.JIGYO_TAISHOSHA_JISSHI_KBN,");
		sb.append(" M_SJ_SERVICE_CODE.YOSHIEN1_JUKYUSHA_JISSHI_KBN,");
		sb.append(" M_SJ_SERVICE_CODE.YOSHIEN2_JUKYUSHA_JISSHI_KBN,");
		sb.append(" M_SJ_SERVICE_CODE.KOKUHO_ITAKU_KBN,");
		sb.append(" M_SJ_SERVICE_CODE.SAKUSEI_DATE,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_2,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_3,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_4,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_5,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_6,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_7,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_8,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_9,");
		sb.append(" M_SJ_SERVICE_CODE.YOBI_10");
		sb.append(" FROM");
		sb.append(" M_SJ_SERVICE_CODE");
		sb.append(" WHERE");
		
		String key = ACCastUtilities.toString(param.get("SYSTEM_SERVICE_CODE_ITEM"), "");
		if (!"".equals(key)) {
			sb.append(" (M_SJ_SERVICE_CODE.SYSTEM_SERVICE_CODE_ITEM='" + key + "')");
		} else {
			//�L�[�̎w�肪�����ꍇ�́A�e������w��
			String insurerId = ACCastUtilities.toString(param.get("INSURER_ID"), "");
			if (!"".equals(insurerId)) {
				sb.append(" (M_SJ_SERVICE_CODE.INSURER_ID='" + insurerId + "')");
			}
			
			String systemKind = ACCastUtilities.toString(param.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
			if (!"".equals(systemKind)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.SYSTEM_SERVICE_KIND_DETAIL='" + systemKind + "')");
			}
			
			String itemCode = ACCastUtilities.toString(param.get("SERVICE_CODE_ITEM"), "");
			if (!"".equals(itemCode)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.SERVICE_CODE_ITEM='" + itemCode + "')");
			}
			
			String name = ACCastUtilities.toString(param.get("SERVICE_NAME"), "");
			if (!"".equals(name)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.SERVICE_NAME like '%" + name + "%')");
			}
			
			String kyufu = ACCastUtilities.toString(param.get("KYUFURITSU"), "");
			if (!"".equals(kyufu)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.KYUFURITSU='" + kyufu + "')");
			}
			
			String futan = ACCastUtilities.toString(param.get("FUTANGAKU"), "");
			if (!"".equals(futan)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.FUTANGAKU='" + futan + "')");
			}
			
			String jigyoJisshiKbn = ACCastUtilities.toString(param.get("JIGYO_TAISHOSHA_JISSHI_KBN"), "");
			if (!"".equals(jigyoJisshiKbn)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.JIGYO_TAISHOSHA_JISSHI_KBN='" + jigyoJisshiKbn + "')");
			}
			
			String shien1JisshiKbn = ACCastUtilities.toString(param.get("YOSHIEN1_JUKYUSHA_JISSHI_KBN"), "");
			if (!"".equals(shien1JisshiKbn)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.YOSHIEN1_JUKYUSHA_JISSHI_KBN='" + shien1JisshiKbn + "')");
			}
			
			String shien2JisshiKbn = ACCastUtilities.toString(param.get("YOSHIEN2_JUKYUSHA_JISSHI_KBN"), "");
			if (!"".equals(shien2JisshiKbn)) {
				sb.append(" AND (M_SJ_SERVICE_CODE.YOSHIEN2_JUKYUSHA_JISSHI_KBN='" + shien2JisshiKbn + "')");
			}
		}
		
		String date = VRDateParser.format(targetDate, "yyyy/MM/dd");
		sb.append(" AND (M_SJ_SERVICE_CODE.TEKIYO_ST_DATE<='" + date + "')");
		sb.append(" AND (M_SJ_SERVICE_CODE.TEKIYO_ED_DATE>='" + date + "')");
		sb.append(" AND (M_SJ_SERVICE_CODE.DELETE_FLG=0)");
		sb.append(" ORDER BY");
		sb.append(" M_SJ_SERVICE_CODE.SYSTEM_SERVICE_CODE_ITEM ASC");
		
		return dbm.executeQuery(sb.toString());
	}
	
	// 2017/6/21 [Yoichiro Kamei] add - begin ���\�h�P�A�}�l�W�����g�Ή�
	/**
	 * �Ώ۔N���ɂ����鍑��̉��\�h�P�A�}�l�W�����g�̃T�[�r�X�R�[�h�}�X�^�擾�֐��ł��B
	 * 
	 * @param dbm
	 *            DBManager
	 * @param targetDate
	 *            �Ώ۔N��
	 * @return �f�[�^�x�[�X���擾�������ʃ��X�g
	 * @throws Exception
	 *             ������O
	 */
	public static VRList getAfServiceCode(ACDBManager dbm, Date targetDate, VRMap param)
			throws Exception {
		
		//�ی��ғƎ���AF�R�[�h�L�����m�F
		VRMap spParam = new VRHashMap();
		spParam.put("INSURER_ID", param.get("INSURER_ID"));
		spParam.put("SYSTEM_SERVICE_KIND_DETAIL", param.get("SYSTEM_SERVICE_KIND_DETAIL"));
		VRList spList = QkanSjServiceCodeManager.getSjServiceCode(dbm, targetDate, spParam);
		if (spList.size() > 0) {
			//�ی��ғƎ���AF�R�[�h���P���ł����݂���ꍇ�A����̃R�[�h�͎Q�Ƃ��Ȃ�
			//��̃��X�g��Ԃ��i�擾�f�[�^�Ȃ��Ƃ���j
			return new VRArrayList();
		}
		
		//�ی��ғƎ���AF�R�[�h�����݂��Ȃ��ꍇ�́A����̃R�[�h���Q�Ƃ���
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
        sb.append(" SYSTEM_SERVICE_KIND_DETAIL");
		//�V�X�e���T�[�r�X���ڃR�[�h�͑������ƃT�[�r�X�R�[�h�}�X�^�ɍ��킹��i����R�[�h���ʂ̂��ߕی��Ҕԍ��̓I�[���O�Ƃ��Ă����j
		sb.append(",'000000' || SYSTEM_SERVICE_KIND_DETAIL || SERVICE_CODE_ITEM AS SYSTEM_SERVICE_CODE_ITEM");		
        sb.append(",SERVICE_VALID_START");
        sb.append(",SERVICE_VALID_END");
        sb.append(",SERVICE_CODE_KIND");
        sb.append(",SERVICE_CODE_ITEM");
        sb.append(",SERVICE_NAME");
        sb.append(",SERVICE_UNIT");
        sb.append(",LIMIT_AMOUNT_OBJECT");
        sb.append(",SERVICE_ADD_FLAG");
        sb.append(",TOTAL_GROUPING_TYPE");
        sb.append(",SERVICE_MAIN_FLAG");
        sb.append(",ROOM_TYPE");
        sb.append(",SERVICE_ADD_TYPE");
        sb.append(",SERVICE_STAFF_UNIT");
        sb.append(",SUMMARY_FLAG");
        sb.append(",SUMMARY_MEMO");
        sb.append(",CLASS_TYPE");
        sb.append(",CODE_ID");
        sb.append(",EDITABLE_FLAG");
        sb.append(",LAST_TIME");
		sb.append(" FROM");
		sb.append(" M_SERVICE_CODE");
		sb.append(" WHERE");
		
		String systemKind = ACCastUtilities.toString(param.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
		if (!"".equals(systemKind)) {
			sb.append(" (SYSTEM_SERVICE_KIND_DETAIL='" + systemKind + "')");
		}
		
		String itemCode = ACCastUtilities.toString(param.get("SERVICE_CODE_ITEM"), "");
		if (!"".equals(itemCode)) {
			sb.append(" AND (SERVICE_CODE_ITEM='" + itemCode + "')");
		}
		
		String name = ACCastUtilities.toString(param.get("SERVICE_NAME"), "");
		if (!"".equals(name)) {
			sb.append(" AND (SERVICE_NAME like '%" + name + "%')");
		}
		
		String date = VRDateParser.format(targetDate, "yyyy/MM/dd");
		sb.append(" AND (SERVICE_VALID_START<='" + date + "')");
		sb.append(" AND (SERVICE_VALID_END>='" + date + "')");
		sb.append(" ORDER BY");
		sb.append(" SERVICE_CODE_ITEM ASC");
		
		return dbm.executeQuery(sb.toString());
	}
	// 2017/6/21 [Yoichiro Kamei] add - end ���\�h�P�A�}�l�W�����g�Ή�
	
	// �}�X�^�̍ŏI�X�V�������擾���܂��B
	private static String getLastUpdateTime(ACDBManager dbm) throws Exception {
		String sql = "SELECT MAX(LAST_TIME) AS LAST_TIME FROM M_SJ_SERVICE_CODE";
		VRList list =  dbm.executeQuery(sql);
		VRMap ret = (VRMap) list.get(0);
		Date date = ACCastUtilities.toDate(ret.get("LAST_TIME"), null);
		if (date == null) {
			return "";
		}
		String lastTime = VRDateParser.format(date, "yyyy/MM/dd HH:mm:ss");
		return lastTime;
	}

	/**
	 * �������Ƃ̃T�[�r�X��ގ擾�֐��ł��B
	 * <p>
	 * �Ώ۔N����n�����ꍇ�F������Ԃɂ����ėL���ȑ������Ƃ̃T�[�r�X��ނ��擾���܂��B<br/>
	 * �Ώ۔N�����ȗ������ꍇ�F���ԂɊ֌W�Ȃ��S�ẴT�[�r�X��ނ��擾���܂��B
	 * </p>
	 * 
	 * @param dbm DBManager
	 * @param targetDate �Ώ۔N��
	 * @return �T�[�r�X��ނ��L�[�A�T�[�r�X��`���W����l�ɂ����}�b�v
	 * @throws Exception ������O
	 */
	public static VRList getMasterServiceSogojigyo(ACDBManager dbm, Date targetDate)
			throws Exception {
		StringBuilder sb;

		sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" M_SERVICE.SERVICE_CODE_KIND,");
		sb.append(" M_SERVICE.SERVICE_CODE_KIND || '�F' || M_SERVICE.SERVICE_NAME AS SERVICE_NAME");
		sb.append(" FROM");
		sb.append(" M_SERVICE");
		sb.append(" WHERE");
		sb.append(" (M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL IN(");
		sb.append(" SELECT DISTINCT");
		sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");
		sb.append(" FROM");
		sb.append(" M_SERVICE");
		sb.append(" WHERE");
		sb.append(" M_SERVICE.CLAIM_LAYER = 1301");
		if (targetDate != null) {
			String date = VRDateParser.format(targetDate, "yyyy/MM/dd");
			sb.append(" AND");
			sb.append(" (M_SERVICE.SERVICE_VALID_START<='" + date + "')");
			sb.append(" AND (M_SERVICE.SERVICE_VALID_END>='" + date + "')");
		}
		sb.append(" AND M_SERVICE.SERVICE_CODE_KIND NOT IN ('A1', 'A5')");
		sb.append(" )");
		sb.append(" )");
		sb.append(" ORDER BY");
		sb.append(" M_SERVICE.SERVICE_SORT ASC");

		VRList list = null;
		if (dbm != null) {
			list = dbm.executeQuery(sb.toString());
		}
		return list;
	}

}
