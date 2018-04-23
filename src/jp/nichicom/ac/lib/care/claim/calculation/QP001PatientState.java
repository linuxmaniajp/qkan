
/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKAACHO�iJMA care benefit management software�j
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKAACHO (JMA care benefit management software)".
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
 * �v���O���� ���p�ҏڍ׃f�[�^�Ǘ� (QP001PatientState)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.SelfPaymentNumberCalcurater;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACFillZero10LeftFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * ���p�҈ꗗ�i�����j(QP001)<br> 
 * ���p�҂̏�Ԃ��擾�E�ێ����܂��B
 * 
 * @author shin fujihara
 * 
 */
public class QP001PatientState {

	//�F�藚�����
	private VRList ninteiHistory;
	//��������
	private VRList kohiHistory;
	//�{�ݗ������(V4.5�ł͈ꌏ�̂�)
	private VRMap shisetsuHistory;
	//�ٓ��������(����)
	private VRList changesHistory;
    //�ړ��������i�S�āj
    private VRList changesHistoryAll;
    
 // 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
    private VRList jushotiTokureiHistory;
 // 2015/1/14 [Yoichiro Kamei] add - end
 		
	//�Ώۂ̗��p�҃f�[�^
	private VRMap patient;
    //����ȕ��S�z�Ǘ��pMap
    private VRMap kohiSelfPay = new VRHashMap();
    
    //�O���̏W�v����
    VRList claim = null;
    
    //2008/09/03 [Shin Fujihara] add - begin 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
    //30�������A�W�v�ɔ��f���ꂸ�̂Ă�ꂽ�P��
    private VRMap abandonedUnit = new VRHashMap();
    private VRMap abandonedDays = new VRHashMap();
    //2008/09/03 [Shin Fujihara] add - begin 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
    
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/23 add - begin
    //30�����̋����^���Z�̌v�Z�p
    //Map<�T�[�r�X��ރR�[�h, Map<�T�[�r�X�R�[�h, QP001PercentageAdder>>
    Map<String, Map<String, QP001PercentageAdder>> kyouseiAdderKindMap 
    	= new HashMap<String, Map<String, QP001PercentageAdder>>();
    //Map<�T�[�r�X�R�[�h, �T�[�r�X�R�[�h�}�X�^���>
    Map<String, Map<String, Object>> kyouseiCodes = new HashMap<String, Map<String, Object>>();
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/23 add - end
    
    //[ID:0000734][Shin Fujihara] 2012/04 add start 30�����̏������P���Z�̌v�Z
    private VRMap abandonedUnitAddition = new VRHashMap();
    //[ID:0000734][Shin Fujihara] 2012/04 add end 30�����̏������P���Z�̌v�Z
    
    //[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
    //���n�A���R�ԁA�������P���Z�̎��ȕ��S�z��ޔ�����
    private VRMap addSelfpay = new VRHashMap();
    //[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
	
    // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
    private SelfPaymentNumberCalcurater selfPaymentNumberCalcurater;
    // [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
    
	/**
	 * �R���X�g���N�^<br>
	 * ������patient_id�Ŏw�肳�ꂽ���p�҂̑�O����targetDate�Ɏw�肳�ꂽ����<br>
	 * �v���x�F�藚���A������A�ی��敪�������擾���A�����ϐ��ɑޔ����܂��B<br>
	 * 
	 * @param dbm DB�R�l�N�V����
	 * @param patient_id �����Ώۂ̗��p��ID
	 * @param targetDate �Ώۓ��t(���܂ŗL��)
	 */
	public QP001PatientState(ACDBManager dbm,VRMap patient, Date targetDate) throws Exception{
		//���p�ҏ���ޔ�
		this.patient = patient;
		
		int patient_id = getPatientDatatoInt("PATIENT_ID");

		//�Ώ۔N���̃t�H�[�}�b�g
		String target = VRDateParser.format(targetDate,"yyyy/MM");
		
		//�F�藚������������
		initNinteiHistory(dbm,patient_id,target);
		//�������������
		initKohiHistory(dbm,patient_id,target);
		//�{�ݗ�����������
		//[ID:0000749][Shin Fujihara] 2012/09 edit begin 2012�N�x�Ή� ��������҂̗����Ǘ��@�\
		//initShisetsuHistory(dbm,patient_id);
		initShisetsuHistory(dbm,patient_id, target);
		//[ID:0000749][Shin Fujihara] 2012/09 edit end 2012�N�x�Ή� ��������҂̗����Ǘ��@�\
		//�ٓ���������������
        initChangeHistory(dbm,patient_id,target);
		
 // 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
        initJushotiTokureiHistory(dbm,patient_id,target);
 // 2015/1/14 [Yoichiro Kamei] add - end

		//�E�v�����p���Ή�
		//�O�����̐��������擾
		initLastMonthClaim(dbm,patient_id,targetDate);
	}
	
	protected int getPatientDatatoInt(String key) throws Exception {
		return ACCastUtilities.toInt(VRBindPathParser.get(key,patient));
	}
	protected String getPatientData(String key) throws Exception {
		return ACCastUtilities.toString(VRBindPathParser.get(key,patient));
	}
	
	public int getPatientId() throws Exception {
		return Integer.parseInt(String.valueOf(VRBindPathParser.get("PATIENT_ID",patient)));
	}
	
	/**
	 * �F�藚���������������܂��B
	 * @param dbm DB�R�l�N�V����
	 * @param patient_id �����Ώۂ̗��p��ID
	 * @param targetDate �Ώۓ��t(���܂ŗL��)
	 */
	private void initNinteiHistory(ACDBManager dbm,int patient_id, String targetDate) throws Exception{
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetDate + "/01"));
		
		StringBuilder sb = new StringBuilder();

		String valid_start = targetDate + "/01";
		String valid_end = VRDateParser.format(targetDateEnd,"yyyy/MM/dd") ;
		
		sb.append(" SELECT");
		sb.append(" h.PATIENT_ID,");
		sb.append(" h.NINTEI_HISTORY_ID,");
		sb.append(" h.INSURER_ID,");
		sb.append(" h.INSURED_ID,");
		sb.append(" h.INSURE_RATE,");
		sb.append(" h.PLANNER,");
		sb.append(" h.PROVIDER_ID,");
		sb.append(" h.SHUBETSU_CODE,");
		sb.append(" h.CHANGE_CODE,");
		sb.append(" h.JOTAI_CODE,");
		sb.append(" h.SHINSEI_DATE,");
		sb.append(" h.NINTEI_DATE,");
		sb.append(" h.INSURE_VALID_START,");
		sb.append(" h.INSURE_VALID_END,");
// 2014/12/17 [Yoichiro Kamei] add - begin �V�X�e���L�����ԑΉ�
		sb.append(" h.SYSTEM_INSURE_VALID_START,");
		sb.append(" h.SYSTEM_INSURE_VALID_END,");
// 2014/12/17 [Yoichiro Kamei] add - end
		sb.append(" h.STOP_DATE,");
		sb.append(" h.STOP_REASON,");
		sb.append(" h.REPORTED_DATE,");
		sb.append(" h.LIMIT_RATE,");
		sb.append(" h.LAST_TIME,");
// 2016/7/18 [�������ƑΉ�][Yoichiro Kamei] add - begin ���ƑΏێ҂̌��x�z�ύX�t���O
        sb.append(" h.LIMIT_CHANGE_FLAG,");
// 2016/7/18 [�������ƑΉ�][Yoichiro Kamei] add - end
		sb.append(" lrd_ex.LIMIT_RATE_VALUE AS EXTERNAL_USE_LIMIT");
		sb.append(" FROM");
		sb.append(" PATIENT_NINTEI_HISTORY h,");
		sb.append(" M_LIMIT_RATE lr_ex,");
		sb.append(" M_LIMIT_RATE_DETAIL lrd_ex");
		sb.append(" WHERE");
		sb.append(" (h.PATIENT_ID = " + patient_id + ")");
		sb.append(" AND (h.CHANGE_CODE = 0)");
		sb.append(" AND (h.JOTAI_CODE <> 1)");
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//		sb.append(" AND (h.INSURE_VALID_START  <= '" + valid_end + "')");
//		sb.append(" AND (h.INSURE_VALID_END >= '" + valid_start + "')");
		sb.append(" AND (h.SYSTEM_INSURE_VALID_START  <= '" + valid_end + "')");
		sb.append(" AND (h.SYSTEM_INSURE_VALID_END >= '" + valid_start + "')");
// 2014/12/17 [Yoichiro Kamei] mod - end
		sb.append(" AND (lr_ex.LIMIT_RATE_TYPE = lrd_ex.LIMIT_RATE_TYPE)");
		sb.append(" AND (lr_ex.LIMIT_RATE_HISTORY_ID = lrd_ex.LIMIT_RATE_HISTORY_ID)");
		sb.append(" AND (lr_ex.LIMIT_RATE_VALID_START <= '" + valid_end + "')");
		sb.append(" AND (lr_ex.LIMIT_RATE_VALID_END >= '" + valid_start + "')");
		sb.append(" AND (lr_ex.LIMIT_RATE_TYPE = 2)");
		sb.append(" AND (h.JOTAI_CODE = lrd_ex.JOTAI_CODE)");
		sb.append(" ORDER BY h.NINTEI_HISTORY_ID ASC");
		
		ninteiHistory = dbm.executeQuery(sb.toString());
		
        //2014/01/24 [Shinobu Hitaka] add - begin �y2014.4 �敪�x�����x�z����Ή��z
        //���p�Җ��̌��x�z���A�Ώ۔N���̌����J���ȋK��̋敪�x�����x�z�ɍ����ւ���
		VRMap map;
        for (int i = 0; i < ninteiHistory.getDataSize(); i++) {
            map = (VRMap) ninteiHistory.getData(i);
            int limitRate = -1;
            
            
// 2016/7/18 [�������ƑΉ�][Yoichiro Kamei] add - begin ���ƑΏێ҂̌��x�z�ύX�t���O
//            // �����J���ȋK��̋敪�x�����x�z���擾����B
//            limitRate = QkanCommon.getOfficialLimitRate(dbm, targetDateEnd, new Integer(1), map.get("JOTAI_CODE").toString());

			// ���ƑΏێ҂Łu�v�x���P�̊z�𒴂��ăT�[�r�X�𗘗p�v�̏ꍇ�́A�v�x���Q�̌��x�z���g�p
			int jotaiCode = ACCastUtilities.toInt(map.getData("JOTAI_CODE"), 0);
			int limitChangeFlg = ACCastUtilities.toInt(map.getData("LIMIT_CHANGE_FLAG"), 0);
			if (limitChangeFlg == 2) {
			    if (QkanConstants.YOUKAIGODO_JIGYOTAISHO == jotaiCode) {
			        jotaiCode = QkanConstants.YOUKAIGODO_YOUSHIEN2;
			    }
			}
			limitRate = QkanCommon.getOfficialLimitRate(dbm, targetDateEnd, new Integer(1), String.valueOf(jotaiCode));
//2016/7/18 [�������ƑΉ�][Yoichiro Kamei] add - end
            if (limitRate > 0) {
                map.setData("LIMIT_RATE", limitRate);
            }
            // �����J���ȋK��̊O�����p�^���t����P�ʐ��́A��L��SQL�Ŏ擾���Ă���̂ŉ������Ȃ�
        }
        //2014/01/24 [Shinobu Hitaka] add - end �y2014.4 �敪�x�����x�z����Ή��z
		
	}
	
	/**
	 * ������������������܂��B
	 * @param dbm DB�R�l�N�V����
	 * @param patient_id �����Ώۂ̗��p��ID
	 * @param targetDate�@�Ώۓ��t(���܂ŗL��)
	 */
	private void initKohiHistory(ACDBManager dbm,int patient_id, String targetDate) throws Exception{
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetDate + "/01"));
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" DISTINCT");
		sb.append(" PATIENT_KOHI.INSURE_TYPE,");
		sb.append(" PATIENT_KOHI.KOHI_TYPE,");
        sb.append(" PATIENT_KOHI.BENEFIT_RATE,");
		sb.append(" PATIENT_KOHI.KOHI_LAW_NO,");
		sb.append(" PATIENT_KOHI.INSURER_ID,");
		sb.append(" KOHI_LAW_NO || INSURER_ID AS KOHI_PAYER_NO,");
		sb.append(" PATIENT_KOHI.KOHI_RECIPIENT_NO,");
		sb.append(" PATIENT_KOHI.KOHI_VALID_START,");
		sb.append(" PATIENT_KOHI.KOHI_VALID_END,");
		sb.append(" PATIENT_KOHI.SELF_PAY,");
        sb.append(" M_KOHI_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");
		sb.append(" FROM");
		sb.append(" PATIENT_KOHI,");
        sb.append(" M_KOHI_SERVICE");
		sb.append(" WHERE");
		sb.append(" (PATIENT_KOHI.PATIENT_ID = " + patient_id + ")");
        sb.append(" AND (PATIENT_KOHI.KOHI_TYPE = M_KOHI_SERVICE.KOHI_TYPE)");
		sb.append(" AND (PATIENT_KOHI.KOHI_VALID_START <= '" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
		sb.append(" AND (PATIENT_KOHI.KOHI_VALID_END >= '" + targetDate + "/01')");
		sb.append(" ORDER BY PATIENT_KOHI.KOHI_ID ASC");
		
		kohiHistory = dbm.executeQuery(sb.toString());
		
	}
	
	/**
	 * �{�ݏ������������܂��B
	 * @param dbm DB�R�l�N�V����
	 * @param patient_id ���p��ID
	 * @param targetDate�@�Ώۓ��t(���܂ŗL��)
	 * @throws Exception
	 */
	//[ID:0000749][Shin Fujihara] 2012/09 edit begin 2012�N�x�Ή� ��������҂̗����Ǘ��@�\
	//private void initShisetsuHistory(ACDBManager dbm,int patient_id) throws Exception {
	private void initShisetsuHistory(ACDBManager dbm,int patient_id, String targetDate) throws Exception {
	//[ID:0000749][Shin Fujihara] 2012/09 edit end 2012�N�x�Ή� ��������҂̗����Ǘ��@�\
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
//		sb.append(" SHOTOKU_DANKAI");
        sb.append(" TOKUTEI_NYUSHO_FLAG");
		sb.append(" ,LIMIT_SHOKUHI");
		sb.append(" ,LIMIT_UNIT_KOSHITSU");
		sb.append(" ,LIMIT_UNIT_JUNKOSHITSU");
		sb.append(" ,LIMIT_JURAIGATA1");
		sb.append(" ,LIMIT_JURAIGATA2");
		sb.append(" ,LIMIT_TASHOSHITSU");
		// 2015/6/8 [Shinobu Hitaka] add - begin H27.8�����Ή��@������(���{���ƘV���E�×{��)�ɕ����ĕێ�
		sb.append(" ,LIMIT_TASHOSHITSU2");	
		// 2015/6/8 [Shinobu Hitaka] add - end
		sb.append(" ,KYUSOCHI_FLAG");
		sb.append(" ,DISEASE");
		sb.append(" FROM");
		sb.append(" PATIENT_SHISETSU_HISTORY");
		sb.append(" WHERE");
		sb.append(" (PATIENT_ID = " + patient_id + ")");
		
		//[ID:0000749][Shin Fujihara] 2012/09 add begin 2012�N�x�Ή� ��������҂̗����Ǘ��@�\
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetDate + "/01"));
		sb.append(" AND (SHISETSU_VALID_START <= '" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
		sb.append(" AND (SHISETSU_VALID_END >= '" + targetDate + "/01')");
		//[ID:0000749][Shin Fujihara] 2012/09 add end 2012�N�x�Ή� ��������҂̗����Ǘ��@�\
		
		VRList list = dbm.executeQuery(sb.toString());
		
		if(list.getDataSize() > 0){
			shisetsuHistory = (VRMap)list.getData(0);
		} else {
			shisetsuHistory = null;
		}
	}
	
	/**
	 * �ٓ����������擾����B
	 * @param dbm �R�l�N�V����
	 * @param patient_id ���p�҂h�c
	 * @param targetDate �Ώۓ�
	 * @throws Exception
	 */
    private void initChangeHistory(ACDBManager dbm,int patient_id,String targetDate) throws Exception{
        Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetDate + "/01"));
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" PATIENT_CHANGES_HISTORY.CHANGES_HISTORY_ID");
		sb.append(" ,PATIENT_CHANGES_HISTORY.SYSTEM_SERVICE_KIND_DETAIL");
		sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_CONTENT");
		sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_DATE");
		sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_TIME");
		sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_REASON");
		sb.append(" ,PATIENT_CHANGES_HISTORY.REASON_MEMO");
        sb.append(" ,M_SERVICE.CHANGES_CONTENT_TYPE");
		sb.append(" FROM");
		sb.append(" PATIENT_CHANGES_HISTORY");
        sb.append(" ,M_SERVICE");
		sb.append(" WHERE");
		sb.append(" (PATIENT_CHANGES_HISTORY.PATIENT_ID = " + patient_id + ")");
        sb.append(" AND (PATIENT_CHANGES_HISTORY.SYSTEM_SERVICE_KIND_DETAIL = M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL) ");
        sb.append(" AND (PATIENT_CHANGES_HISTORY.CHANGES_DATE <= '" + VRDateParser.format(targetDateEnd,"yyyy/MM/dd") + "')");
        sb.append(" AND (PATIENT_CHANGES_HISTORY.CHANGES_DATE >= '" + targetDate + "/01')");
        sb.append(" ORDER BY PATIENT_CHANGES_HISTORY.CHANGES_HISTORY_ID DESC");
		
		changesHistory = dbm.executeQuery(sb.toString());
        
        sb = new StringBuilder();
        sb.append(" SELECT");
        sb.append(" PATIENT_CHANGES_HISTORY.CHANGES_HISTORY_ID");
        sb.append(" ,PATIENT_CHANGES_HISTORY.SYSTEM_SERVICE_KIND_DETAIL");
        sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_CONTENT");
        sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_DATE");
        sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_TIME");
        sb.append(" ,PATIENT_CHANGES_HISTORY.CHANGES_REASON");
        sb.append(" ,PATIENT_CHANGES_HISTORY.REASON_MEMO");
        sb.append(" ,M_SERVICE.CHANGES_CONTENT_TYPE");
        sb.append(" FROM");
        sb.append(" PATIENT_CHANGES_HISTORY");
        sb.append(" ,M_SERVICE");
        sb.append(" WHERE");
        sb.append(" (PATIENT_ID = " + patient_id + ")");
        sb.append(" AND (PATIENT_CHANGES_HISTORY.SYSTEM_SERVICE_KIND_DETAIL = M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL) ");
        changesHistoryAll = dbm.executeQuery(sb.toString());
	}
	
// 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
	/**
	 * �Z���n���ᗚ���������������܂��B
	 * @param dbm DB�R�l�N�V����
	 * @param patient_id �����Ώۂ̗��p��ID
	 * @param targetDate�@�Ώۓ��t(���܂ŗL��)
	 */
	private void initJushotiTokureiHistory(ACDBManager dbm,int patient_id, String targetDate) throws Exception{
		Date targetDateEnd = ACDateUtilities.toLastDayOfMonth(ACCastUtilities.toDate(targetDate + "/01"));
		
		String valid_start = targetDate + "/01";
		String valid_end = VRDateParser.format(targetDateEnd,"yyyy/MM/dd") ;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT");
		sb.append(" PATIENT_ID,");
		sb.append(" JUSHOTI_HISTORY_ID,");
		sb.append(" JUSHOTI_VALID_START,");
        sb.append(" JUSHOTI_VALID_END,");
		sb.append(" JUSHOTI_INSURER_ID");
		sb.append(" FROM");
		sb.append(" PATIENT_JUSHOTI_TOKUREI");
		sb.append(" WHERE");
		sb.append(" (PATIENT_ID = " + patient_id + ")");
		sb.append(" AND (JUSHOTI_VALID_START  <= '" + valid_end + "')");
		sb.append(" AND (JUSHOTI_VALID_END >= '" + valid_start + "')");
		sb.append(" ORDER BY JUSHOTI_HISTORY_ID ASC");
		
		jushotiTokureiHistory = dbm.executeQuery(sb.toString());
	}
// 2015/1/14 [Yoichiro Kamei] add - end
	
	/**
	 * ���p�҂̐挎���̐��������擾����B
	 * @param dbm DB����N���X
	 * @param patient_id ���p�҂�ID
	 * @param targetDate ����̐����Ώۓ��t
	 * @throws Exception
	 */
	private void initLastMonthClaim(ACDBManager dbm,int patient_id, Date targetDate) throws Exception {
        
        // �����ڍ׏����擾���AVRArrayList claimList �Ɋi�[����B
        StringBuilder sb = new StringBuilder();
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        cal.add(Calendar.MONTH, -1);
        
        //�挎�̐��������擾
        sb.append(" SELECT");
        sb.append(" DISTINCT");
        sb.append(" CLAIM_DATE");
        sb.append(" FROM");
        sb.append(" CLAIM");
        sb.append(" WHERE");
        sb.append(" (CLAIM.PATIENT_ID = " + patient_id + ")");
        sb.append(" AND (CLAIM.TARGET_DATE = '" + VRDateParser.format(cal.getTime(),"yyyy/MM/dd") + "')");
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        
        VRList list = dbm.executeQuery(sb.toString());
        
        if((list == null) || (list.size() == 0)){
        	return;
        }
        
        Date claimDate = ACCastUtilities.toDate(((VRMap)list.get(0)).get("CLAIM_DATE"),null);
        
        if(claimDate == null){
        	return;
        }
        
        sb = new StringBuilder();
        
        sb.append(" AND(CLAIM.TARGET_DATE = '" + VRDateParser.format(cal.getTime(),"yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.PATIENT_ID = " + patient_id + ")");
        sb.append(" AND(CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 mod - begin
        // ��{�E�v���擾
//        //�����́A���׏��Ɠ���f�Ô�A�K��Ō��Â݂̂ł悢
//        //[ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
//        //sb.append(" AND (CLAIM.CATEGORY_NO IN (3,5,13))");
//        //���~���R�E�����i�@�j�O�̏󋵃R�[�h�̈��p���d�l�ǉ��ɔ����A
//        //��{��񃌃R�[�h���ޔ�
//        sb.append(" AND (CLAIM.CATEGORY_NO IN (2,3,5,13))");
//        //[ID:0000447][Shin Fujihara] 2009/02 edit end ����21�N4���@�����Ή�
//        //�K�v�ł���΁A����ɏ������i��(��F���׏�񃌃R�[�h�̂� etc...)   
        sb.append(" AND (CLAIM.CATEGORY_NO IN (2,3,5,13,19))");
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 mod - end
        
        //�挎���̐�������ޔ�
        claim = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());
	}
	
	
	/**
	 * �w�肳�ꂽ���t�̕ی��Ҕԍ����擾����B
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
	protected String getInsurerId(Object targetDate) throws Exception{
		return getNinteiData(targetDate,"INSURER_ID");
	}
	
	/**
	 * �w�肳�ꂽ���t�̗v����ԋ敪���擾����B
	 * @param targetDate
	 * @return
	 */
	public String getJotaiCode(Object targetDate) throws Exception{
		return getNinteiData(targetDate,"JOTAI_CODE");
	}
	
    /**
     * �w�肳�ꂽ���t���_�Ő��ےP�Ǝ󋋎҂ł��邩��ԋp����B
     * @param targetDate
     * @return
     * @throws Exception
     */
    protected boolean isSeihoOnly(Object targetDate) throws Exception {
        //��ی��Ҕԍ���H�Ŏn�܂��Ă��邩�Ŕ��f
        return QP001SpecialCase.isSeihoOnly(getInsuredId(targetDate));
    }
    
	/**
	 * �w�肳�ꂽ���t�̔�ی��Ҕԍ����擾����B
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
	protected String getInsuredId(Object targetDate) throws Exception {
		return getNinteiData(targetDate,"INSURED_ID");
	}
	
// 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
	/**
	 * �w�肳�ꂽ���t�̏Z���n����̎{�ݏ��ݕی��Ҕԍ����擾����B
	 * �f�[�^�����݂��Ȃ��ꍇ�́A�󕶎���Ԃ��B
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
	public String getJushotiTokureiInsurerId(Object targetDate) throws Exception{
		return getJushotiTokureiData(targetDate,"JUSHOTI_INSURER_ID");
	}
// 2015/1/14 [Yoichiro Kamei] add - end
	
	/**
	 * �w�肳�ꂽ���t�̎Љ�����Ƃ̊������擾����B
	 * �w������ΏۊO�̏ꍇ�́A0��ԋp����B
     * �Е����Ƃ̊����̂ݏ����_�ȉ������͉\�ł��邽�߁A10�{�����l��ԋp����B
     * �v�Z���ɐ؂�̂Ă�B
	 * @param targetDate
	 * @param serviceCode
	 * @return
	 */
	protected int getReductionRatio(Object targetDate,String systemServiceKindDetail) throws Exception {
		VRList list = getKohiData(targetDate,3,systemServiceKindDetail);
		VRMap map;

		for(int i = 0; i < list.getDataSize(); i++){
			map = (VRMap)list.getData(i);
            String kohi_type = String.valueOf(map.get("KOHI_TYPE"));
			if(kohi_type.equals("7701") || kohi_type.equals("7702")){
                return ACCastUtilities.toInt(map.get("BENEFIT_RATE"));
			}
		}
		
		return 0;
	}
	
	/**
	 * �w�肳�ꂽ���t�̌�������擾����B
	 * @param targetDate
	 * @param serviceCodes
	 * @return
	 * @throws Exception
	 */
	protected int getKohiRatio(Object targetDate, String systemServiceKindDetail,String applicationType,int insureType,int medicalFlag,QP001Manager manager) throws Exception{
		VRList list = getKohiDataFromServiceKind(targetDate,systemServiceKindDetail,applicationType,insureType,medicalFlag,manager);
		int result = 0;
		
		VRMap map;
		int temp = 0;
		for(int i = 0; i < list.getDataSize(); i++){
			map = (VRMap)list.getData(i);
			//temp = ACCastUtilities.toInt(VRBindPathParser.get("BENEFIT_RATE",map));
			QP001KohiKey kohiKey = new QP001KohiKey(map);
            temp = ACCastUtilities.toInt(getKohiData(kohiKey,"BENEFIT_RATE",insureType),0);
			if(temp > result) result = temp;
			
			if(result == 100) break;
		}
		
		return result;
	}
	
	
	/**
	 * �Ώۓ��ɃV�X�e�����T�[�r�X�R�[�h�̃T�[�r�X���Y���������̈ꗗ���擾����B
	 * @param targetDate �Ώۓ�
	 * @param systemServiceKindDetail �V�X�e�����T�[�r�X�R�[�h
	 * @param applicationType �K�p�^�C�v	1:�T�[�r�X�񋟔� 
	 * 																		2:�ً}���{�ݗ×{�Ǘ�
	 *																		3:����f�Ô�
	 *																		4:�H���񋟔�
	 *																		5:���p�ҕ��S
	 * @return
	 * @throws Exception
	 */
	protected VRList getKohiDataFromServiceKind(Object targetDate, String systemServiceKindDetail,String applicationType,int insureType,int medicalFlag,QP001Manager manager) throws Exception {
		VRList result = new VRArrayList();
		//�w�肳�ꂽ���t�ɊY�������������擾
		VRList list = getKohiData(targetDate,insureType,systemServiceKindDetail);
		
		VRMap map;
		VRMap kohiTemp;
		String kohiType;
		
		//�Ώۓ��ɓK�p�Ώۂ̌�����Q�Ƃ���B
		for(int i = 0; i < list.getDataSize(); i++){
			map = (VRMap)list.getData(i);
			kohiType = ACCastUtilities.toString(VRBindPathParser.get("KOHI_TYPE",map));
			//kohiTemp = QP001Manager.getInstance().getKohiMatchData(kohiType,systemServiceKindDetail,applicationType);
            kohiTemp = manager.getKohiMatchData(kohiType,systemServiceKindDetail,applicationType);
			if(kohiTemp != null){
                
                /* ������s��Ȃ��悤�ύX
                //BY_MEDICAL_FLAG��1�̏ꍇ
                if(String.valueOf(kohiTemp.get("BY_MEDICAL_FLAG")).equals("1")){
                    //��Ë@�փt���O��1�łȂ��ꍇ
                    if(medicalFlag != 1){
                        continue;
                    }
                }
                */
// 2015/5/12 [Yoichiro Kamei] add - begin ����֘A������
			    kohiTemp.setData("SERVICE_DATE", targetDate);
			    kohiTemp.setData("KOHI_LAW_NO", map.getData("KOHI_LAW_NO"));
			    kohiTemp.setData("INSURER_ID", map.getData("INSURER_ID"));
			    kohiTemp.setData("KOHI_RECIPIENT_NO", map.getData("KOHI_RECIPIENT_NO"));
// 2015/5/12 [Yoichiro Kamei] add - end
				result.add(kohiTemp);
//				//���t����100�Ȃ烊�X�g�ւ̒ǉ���ł��؂�(����ȍ~�̌���͓K�p����Ȃ����߁B)
//				if(ACCastUtilities.toString(VRBindPathParser.get("BENEFIT_RATE",kohiTemp)).equals("100"))break;
			}
		}
		return result;
	}
	
	/**
	 * �{�ݏ����擾����B
	 * @param key
	 * @return
	 * @throws Exception
	 */
    public String getShisetsuData(String key) throws Exception {
    	//[ID:0000749][Shin Fujihara] 2012/09 edit begin 2012�N�x�Ή� ��������҂̗����Ǘ��@�\
    	//�݊��̂��߁A"TOKUTEI_NYUSHO_FLAG"�A"KYUSOCHI_FLAG"���w�肳�ꂽ����"1"��Ԃ�
		//if (shisetsuHistory == null) return "";
    	if (shisetsuHistory == null) {
    		if ("TOKUTEI_NYUSHO_FLAG".equals(key) || "KYUSOCHI_FLAG".equals(key)) {
    			return "1";
    		}
    		return "";
    	}
		//[ID:0000749][Shin Fujihara] 2012/09 edit end 2012�N�x�Ή� ��������҂̗����Ǘ��@�\
		
		return ACCastUtilities.toString(VRBindPathParser.get(key,shisetsuHistory));
	}
	
	/**
	 * �w�肳�ꂽ���t�ɊY�����������̎擾���s���܂��B
	 * @param targetDate �Ώۂ̓��t
	 * @param kohiTypes �擾�������Ώۂ̌���^�C�v �J���}��؂�ŕ����w��\
	 * @return �擾�f�[�^
	 * @throws Exception
	 */
	protected VRList getKohiData(Object targetDate,int insureType,String system_service_kind_detail) throws Exception{
		VRList result = new VRArrayList();
		String target = toDateString(targetDate);
		if(target == null) return result;
		
		if(kohiHistory == null) return result;
		
		int startYMD = 0;
		int endYMD = 0;
		VRMap map = null;		
		int targetDateTemp = Integer.parseInt(target);
		
        //����̔F�藚�����������A�w�肳�ꂽ���t�ƍ��v���郌�R�[�h��ޔ�����B
		for(int i = 0; i < kohiHistory.getDataSize(); i++){
			map = (VRMap)kohiHistory.getData(i);
			startYMD = getInt("KOHI_VALID_START",map);
			endYMD = getInt("KOHI_VALID_END",map);
			
            //�ی���ނ��w�肳�ꂽ���̂��m�F����B
			if(ACCastUtilities.toInt(VRBindPathParser.get("INSURE_TYPE",map)) != insureType){
				continue;
			}
            //
            if(!ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",map)).equals(system_service_kind_detail)){
                continue;
            }
			
			if((startYMD <= targetDateTemp) && (targetDateTemp <= endYMD)){
				result.add(map);
			}
		}
		return result;
	}
    
	/**
	 * ��������擾����B
	 * @param kohiType
	 * @param key
	 * @return
	 * @throws Exception
	 */
	protected String getKohiData(QP001KohiKey kohiKey, String key,int insureType) throws Exception {
		String result = "";

		if(kohiHistory == null) return result;
// 2015/5/12 [Yoichiro Kamei] add - begin ����֘A������
		if (kohiKey == null
		    || ACTextUtilities.isNullText(kohiKey.getKohiLawNo())
		    || ACTextUtilities.isNullText(kohiKey.getInsurerId())
		    || ACTextUtilities.isNullText(kohiKey.getKohiRecipientNo())) {
		    return result;
		}
// 2015/5/12 [Yoichiro Kamei] add - end
		
		VRMap map;
		for(int i = 0; i < kohiHistory.getDataSize(); i++){
			map = (VRMap)kohiHistory.getData(i);
// 2015/5/12 [Yoichiro Kamei] mod - begin ����֘A������
//	         if(ACCastUtilities.toString(VRBindPathParser.get("KOHI_TYPE",map)).equals(kohiType)
//	                    && ACCastUtilities.toInt(VRBindPathParser.get("INSURE_TYPE",map)) == insureType){
			if(ACCastUtilities.toString(VRBindPathParser.get("KOHI_LAW_NO",map)).equals(kohiKey.getKohiLawNo())
			    && ACCastUtilities.toString(VRBindPathParser.get("INSURER_ID",map)).equals(kohiKey.getInsurerId())
			    && ACCastUtilities.toString(VRBindPathParser.get("KOHI_RECIPIENT_NO",map)).equals(kohiKey.getKohiRecipientNo())
                && ACCastUtilities.toInt(VRBindPathParser.get("INSURE_TYPE",map)) == insureType
			){
// 2015/5/12 [Yoichiro Kamei] mod - end
				result = ACCastUtilities.toString(VRBindPathParser.get(key,map));
				break;
			}
		}
		return result;
	}
	
    /**
     * ����ȕ��S�z���擾����B
     * @param kohiType
     * @param insureType
     * @return
     * @throws Exception
     */
    protected int getKohiSelfPay(QP001KohiKey kohiKey, int insureType) throws Exception {
        int result = 0;
        //�擾�ς݂̌���ȕ��S�z�̑��݃`�F�b�N
        if(kohiSelfPay.containsKey(kohiKey)){
            //�擾�ς݂̌���ȕ��S�z���擾
            result = ((Integer)kohiSelfPay.get(kohiKey)).intValue();
            
        //����ȕ��S�z�����擾�̏ꍇ
        } else {
            //����̗�����񂩂玩�ȕ��S�z���擾����B
            String selfPayTemp = getKohiData(kohiKey, "SELF_PAY", insureType);
            if (!ACTextUtilities.isNullText(selfPayTemp)) {
                result = ACCastUtilities.toInt(selfPayTemp);
                //�擾�ς݌���ȕ��S�z�Ƃ��ēo�^����B
                kohiSelfPay.put(kohiKey, new Integer(result));
            }
        }
        
        return result;
    }
    
    /**
     * �g�p��������ȕ��S�z��ݒ肷��B
     * @param kohiType
     * @param use
     * @throws Exception
     */
    protected void setKohiSelfPayUse(QP001KohiKey kohiKey, int use) throws Exception {
        if(kohiSelfPay.containsKey(kohiKey)){
            int value = ((Integer)kohiSelfPay.get(kohiKey)).intValue();
            value -= use;
            kohiSelfPay.put(kohiKey,new Integer(value));
        }
    }
	
    /**
     * �ی��Ҕԍ��A��ی��Ҕԍ����L�[�ɓ����Ō�̔F�藚�������擾����B
     * �������̃f�[�^�͏��O����B
     * @param insurer_id �ی��Ҕԍ�
     * @param insured_id ��ی��Ҕԍ�
     * @param key �擾����L�[
     * @return �擾�����f�[�^
     * @throws Exception ���s���G���[
     */
    protected String getNinteiDataLast(String insurer_id, String insured_id,
            String key) throws Exception {
        
        String result = "";

        if (ninteiHistory == null)
            return result;

        VRMap resultMap = null;

        for (int i = 0; i < ninteiHistory.getDataSize(); i++) {
            VRMap map = (VRMap) ninteiHistory.getData(i);

            if ((String.valueOf(map.get("INSURER_ID")).equals(insurer_id))
                    && (String.valueOf(map.get("INSURED_ID")).equals(insured_id))) {
                //�v���x�敪�������Ȃ珈�����s��Ȃ�
                if(ACCastUtilities.toInt(map.get("JOTAI_CODE"),1) == 1){
                    continue;
                }
                
                if(resultMap == null){
                    resultMap = (VRMap) ninteiHistory.getData(i);
                } else {
                    
                    //�L�����ԊJ�n���r����B
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//                    if (ACDateUtilities.compareOnDay(ACCastUtilities.toDate(resultMap.get("INSURE_VALID_START")),
//                            ACCastUtilities.toDate(map.get("INSURE_VALID_START"))) < 0) {
                    if (ACDateUtilities.compareOnDay(ACCastUtilities.toDate(resultMap.get("SYSTEM_INSURE_VALID_START")),
                            ACCastUtilities.toDate(map.get("SYSTEM_INSURE_VALID_START"))) < 0) {
// 2014/12/17 [Yoichiro Kamei] mod - end
                        resultMap = (VRMap) ninteiHistory.getData(i);
                    }
                }
            }
        }
        
        if(resultMap != null){
            result = String.valueOf(resultMap.get(key));
        }
        
// 2016/7/21 [SHinobu Hitaka] add - begin ���ƑΏێ҂͑O�Ƀ[��������"06"��Ԃ�
        if ("JOTAI_CODE".equals(key) && result.length() == 1) {
            result = "0" + result;
        }
// 2016/7/21 [SHinobu Hitaka] add - end

        return result;
    }
    
    /**
     * �ی��Ҕԍ��A��ی��Ҕԍ����L�[�ɓ����ł����Ƃ��d���F��̔F�藚�������擾����B
     * �������̃f�[�^�͏��O����B
     * @param insurer_id �ی��Ҕԍ�
     * @param insured_id ��ی��Ҕԍ�
     * @param key �擾����L�[
     * @return �擾�����f�[�^
     * @throws Exception ���s���G���[
     */
    protected String getNinteiDataHeavy (String insurer_id, String insured_id,
            String key) throws Exception {
        
        String result = "";

        if (ninteiHistory == null)
            return result;

        VRMap resultMap = null;

        for (int i = 0; i < ninteiHistory.getDataSize(); i++) {
            VRMap map = (VRMap) ninteiHistory.getData(i);

            if ((String.valueOf(map.get("INSURER_ID")).equals(insurer_id))
                    && (String.valueOf(map.get("INSURED_ID")).equals(insured_id))) {
                //�v���x�敪�������Ȃ珈�����s��Ȃ�
                if(ACCastUtilities.toInt(map.get("JOTAI_CODE"),1) == 1){
                    continue;
                }
                
                if(resultMap == null){
                    resultMap = (VRMap) ninteiHistory.getData(i);
                } else {
                    //�v���x�敪���r����B
//                    if (ACCastUtilities.toInt(resultMap.get("JOTAI_CODE"),1) <
//                            ACCastUtilities.toInt(map.get("JOTAI_CODE"),1)) {
//                        resultMap = (VRMap) ninteiHistory.getData(i);
//                    }
                    //�x�����x�z���r����B
                    if (ACCastUtilities.toInt(resultMap.get("LIMIT_RATE"),0) <
                            ACCastUtilities.toInt(map.get("LIMIT_RATE"),0)) {
                        resultMap = (VRMap) ninteiHistory.getData(i);
                    }
                }
            }
        }
        
        if(resultMap != null){
            result = String.valueOf(resultMap.get(key));
        }

// 2016/7/21 [SHinobu Hitaka] add - begin ���ƑΏێ҂͑O�Ƀ[��������"06"��Ԃ�
        if ("JOTAI_CODE".equals(key) && result.length() == 1) {
            result = "0" + result;
        }
// 2016/7/21 [SHinobu Hitaka] add - end

        return result;
    }
    
    
	/**
	 * �w�肳�ꂽ���t�ɊY������F�藚�����̎擾���s���܂��B
	 * @param targetDate �Ώۂ̓��t
	 * @param key �擾����L�[
	 * @return �擾�f�[�^
	 * @throws Exception
	 */
	public String getNinteiData(Object targetDate,String key) throws Exception{
		targetDate = toDateString(targetDate);
		
		String result = "";
		String target = toDateString(String.valueOf(targetDate));
		if(target == null) return result;
		
		if(ninteiHistory == null) return result;
		int startYMD = 0;
		int endYMD = 0;
		VRMap map = null;		
		int targetDateTemp = Integer.parseInt(target);
// 2017/1/20 [Yoichiro Kamei] add - begin [CCCX: 03393]�Ή�
		VRMap targetMap = null;
// 2017/1/20 [Yoichiro Kamei] add - end
		
		for(int i = 0; i < ninteiHistory.getDataSize(); i++){
			map = (VRMap)ninteiHistory.getData(i);
// 2014/12/17 [Yoichiro Kamei] mod - begin �V�X�e���L�����ԑΉ�
//			startYMD = getInt("INSURE_VALID_START",map);
//			endYMD = getInt("INSURE_VALID_END",map);
			startYMD = getInt("SYSTEM_INSURE_VALID_START",map);
			endYMD = getInt("SYSTEM_INSURE_VALID_END",map);
// 2014/12/17 [Yoichiro Kamei] mod - end
			if((startYMD <= targetDateTemp) && (targetDateTemp <= endYMD)){
				// 2017/1/20 [Yoichiro Kamei] add - begin [CCCX: 03393]�Ή�
				targetMap = map;
				// 2017/1/20 [Yoichiro Kamei] add - end
				break;
			}
		}
		// 2017/1/20 [Yoichiro Kamei] mod - begin [CCCX: 03393]�Ή�
//		if(map == null) return result;
//		
//		result = String.valueOf(VRBindPathParser.get(key,map));
		if (targetMap == null) {
			return result;
		}
		result = String.valueOf(VRBindPathParser.get(key, targetMap));
		// 2017/1/20 [Yoichiro Kamei] mod - end
		
		return result;
	}
	
	protected int getChangeDatatoInt(String systemServiceKindDetail,String chargeContent,String key,String changesContentType) throws Exception {
		int result = 0;
		try{
			result = ACCastUtilities.toInt(getChangeData(systemServiceKindDetail,chargeContent,key,changesContentType));
		} catch(Exception e){}
		return result;
		
	}
	
// 2016/8/15 [Shinobu Hitaka] add - begin �������ƑΉ�
    /**
     * �ی��Ҕԍ��A��ی��Ҕԍ����L�[�ɓ����Ō�̗v�x���܂��͎��ƑΏێ҂̔F�藚�������擾����B
     * @param insurer_id �ی��Ҕԍ�
     * @param insured_id ��ی��Ҕԍ�
     * @return �擾�����F�藚�����Map�f�[�^
     * @throws Exception ���s���G���[
     */
    protected VRMap getNinteiDataLastShien(String insurer_id, String insured_id) throws Exception {
        
        VRMap resultMap = null;

        if (ninteiHistory == null)
            return resultMap;

        for (int i = 0; i < ninteiHistory.getDataSize(); i++) {
            VRMap map = (VRMap) ninteiHistory.getData(i);

            if ((String.valueOf(map.get("INSURER_ID")).equals(insurer_id))
                    && (String.valueOf(map.get("INSURED_ID")).equals(insured_id))) {
                //�v���x�敪���v�x���E���ƑΏێ҈ȊO�Ȃ珈�����s��Ȃ�
            	int jotaiCode = ACCastUtilities.toInt(map.get("JOTAI_CODE"),1);
                if (jotaiCode != QkanConstants.YOUKAIGODO_JIGYOTAISHO && 
    	            jotaiCode != QkanConstants.YOUKAIGODO_YOUSHIEN1 && 
    	            jotaiCode != QkanConstants.YOUKAIGODO_YOUSHIEN2){
                    continue;
                }
                
                if (resultMap == null) {
                    resultMap = (VRMap) ninteiHistory.getData(i);
                } else {
                    
                    //�L�����ԊJ�n���r����B
                    if (ACDateUtilities.compareOnDay(ACCastUtilities.toDate(resultMap.get("SYSTEM_INSURE_VALID_START")),
                            ACCastUtilities.toDate(map.get("SYSTEM_INSURE_VALID_START"))) < 0) {
                        resultMap = (VRMap) ninteiHistory.getData(i);
                    }
                }
            }
        }
        
        if (resultMap != null) {
        	String result = String.valueOf(resultMap.get("JOTAI_CODE"));
            if (result.length() == 1) {
                result = "0" + result;
                resultMap.setData("JOTAI_CODE", result);
            }
        }

        return resultMap;
    }
// 2016/8/15 [Shinobu Hitaka] add - end �������ƑΉ�

// 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
	/**
	 * �w�肳�ꂽ���t�ɊY������Z���n������̎擾���s���܂��B
	 * @param targetDate �Ώۂ̓��t
	 * @param key �擾����L�[
	 * @return �擾�f�[�^
	 * @throws Exception
	 */
	public String getJushotiTokureiData(Object targetDate,String key) throws Exception{
		targetDate = toDateString(targetDate);
		
		String result = "";
		String target = toDateString(String.valueOf(targetDate));
		if(target == null) return result;
		
		if(jushotiTokureiHistory == null) return result;
		int startYMD = 0;
		int endYMD = 0;
		VRMap map = null;		
		int targetDateTemp = Integer.parseInt(target);
		
		for(int i = 0; i < jushotiTokureiHistory.getDataSize(); i++){
			map = (VRMap)jushotiTokureiHistory.getData(i);
			startYMD = getInt("JUSHOTI_VALID_START",map);
			endYMD = getInt("JUSHOTI_VALID_END",map);

			if((startYMD <= targetDateTemp) && (targetDateTemp <= endYMD)){
				//�w�肳�ꂽ���t�ŗL���ȏZ���n�����񂪌��������ꍇ
				result = String.valueOf(VRBindPathParser.get(key,map)); 
				break;
			}
		}
		return result;
	}
// 2015/1/14 [Yoichiro Kamei] add - end
	
	/**
	 * �ٓ����������擾����B
	 * @param systemServiceKindDetail �V�X�e�����T�[�r�X�R�[�h
	 * @param chargeContent �ٓ����R
	 * @param key �擾����f�[�^
	 * @return
	 * @throws Exception
	 */
	protected String getChangeData(String systemServiceKindDetail,String chargeContent,String key,String changesContentType) throws Exception {
    
		String result = "";
		if(changesHistory == null) return result;
		
        String[] changesContentTypes = changesContentType.split(",");
        
		VRMap map = null;
        
		lbl:for(int i = 0; i < changesHistory.getDataSize(); i++){
			map = (VRMap)changesHistory.getData(i);
            //if(String.valueOf(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",map)).equals(systemServiceKindDetail) &&
            if(systemServiceKindDetail.indexOf(String.valueOf(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",map))) != -1 &&
                    String.valueOf(VRBindPathParser.get("CHANGES_CONTENT",map)).equals(chargeContent)){
                for(int j = 0; j < changesContentTypes.length; j++){
                    if(String.valueOf(VRBindPathParser.get("CHANGES_CONTENT_TYPE",map)).equals(changesContentTypes[j])){
                        result = ACCastUtilities.toString(VRBindPathParser.get(key,map));
                        break lbl;
                    }
                }
            }
		}
		return result;
	}
    
    /**
     * �ٓ����������擾����B
     * @param systemServiceKindDetail �V�X�e�����T�[�r�X�R�[�h
     * @param chargeContent �ٓ����R
     * @param key �擾����f�[�^
     * @return
     * @throws Exception
     */
    protected String getChangeDataAll(String systemServiceKindDetail,String chargeContent,String key) throws Exception {
        String result = "";
        if(changesHistoryAll == null) return result;
        
        VRMap map = null;
        String sysData = "";
        String contentData = "";
        
        for(int i = 0; i < changesHistoryAll.getDataSize(); i++){
            map = (VRMap)changesHistoryAll.getData(i);
            sysData = String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL"));
            contentData = String.valueOf(map.get("CHANGES_CONTENT"));
            
            if(sysData.equals(systemServiceKindDetail) && contentData.equals(chargeContent)){
                result = ACCastUtilities.toString(VRBindPathParser.get(key,map));
                break;
            }
        }
        return result;
    }
    
    //[ID:0000750][Shin Fujihara] 2012/09 edit begin 2012�N�x�Ή� �ٓ���񂩂���E�މ@���̎擾���@�ύX
//    /**
//     * ���p�҂̈ٓ�����S�̂���������̃f�[�^����������B
//     * @param systemServiceKindDetail �V�X�e�����T�[�r�X�R�[�h
//     * @param chargeContent �ړ����R 1-�J�n�E�����E���@�E�K��J�n    2-�I���E�ޏ��E�މ@�E�K��I��
//     * @param changesContentType 1-����n�@2-�{�݌n1�@3-�{�݌n2 4-��ÊŌ� 5-�����n
//     * @param target �����Ώۓ��t
//     * @return �擾����CHANGES_DATE
//     * @throws Exception
//     */
//    //[ID:0000572][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
//    // �߂�l��VRMap�ɕύX
//    //�S�̓I�ɕύX���Ă���̂ŁA������CVS�Q��
//    //protected String getChangeDataAll(String systemServiceKindDetail,String chargeContent,String changesContentType,String target) throws Exception {
//    protected VRMap getChangeDataAll(String systemServiceKindDetail,String chargeContent,String changesContentType,String target) throws Exception {
//        
//        VRMap result = null;
//        
//        if(changesHistoryAll == null) return result;
//        
//        Date candidateDate = null;
//        Date lastDate = null;
//        Date targetDate = null;
//        
//        //��r�Ώۂ̓��t��Date�ɕϊ�����B
//        try{
//            if(target.length() == 6){
//                targetDate = ACCastUtilities.toDate(target + "01");
//            } else {
//                targetDate = ACCastUtilities.toDate(target);
//            }
//        } catch(Exception e){}
//        
//        if(targetDate == null){
//            return result;
//        }
//        
//        VRMap map = null;
//        
//        //�����f�[�^��S����
//        String[] changesContentTypes = changesContentType.split(",");
//        
//        for(int i = 0; i < changesHistoryAll.getDataSize(); i++){
//            map = (VRMap)changesHistoryAll.getData(i);
//            
//            //if(String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL")).equals(systemServiceKindDetail) &&
//            if(systemServiceKindDetail.indexOf(String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL"))) != -1 &&
//                    String.valueOf(map.get("CHANGES_CONTENT")).equals(chargeContent)){
//                
//                for(int j = 0; j < changesContentTypes.length; j++){
//                    if(String.valueOf(map.get("CHANGES_CONTENT_TYPE")).equals(changesContentTypes[j])){
//                        
//                        candidateDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
//                        
//                        //�擾�������t���Ώی��ȑO���m�F�i�Ώی����܂ށj
//                        if(ACDateUtilities.compareOnMonth(candidateDate,targetDate) <= 0){
//                            //��r�Ώۂ̓��t�����ɑ��݂���ꍇ
//                            if(lastDate != null){
//                                if(ACDateUtilities.compareOnDay(lastDate,candidateDate) < 0){
//                                    lastDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
//                                    result = map;
//                                }
//                            } else {
//                                lastDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
//                                result = map;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        /*
//        if(lastDate != null){
//            result = String.valueOf(lastDate);
//        }
//        */
//        
//        return result;
//    }
//    //[ID:0000572][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
//    
//    /**
//     * ���p�҂̈ٓ�����S�̂���ޏ����̃f�[�^����������B
//     * @param systemServiceKindDetail �V�X�e�����T�[�r�X�R�[�h
//     * @param chargeContent �ړ����R 1-�J�n�E�����E���@�E�K��J�n    2-�I���E�ޏ��E�މ@�E�K��I��
//     * @param changesContentType 1-����n�@2-�{�݌n1�@3-�{�݌n2 4-��ÊŌ� 5-�����n
//     * @param target �����Ώۓ��t
//     * @return �擾����CHANGES_DATE
//     * @throws Exception
//     */
//    protected VRMap getChangeDataAllLeaving(String systemServiceKindDetail,String chargeContent,String changesContentType) throws Exception {
//        
//        VRMap result = null;
//        
//        if(changesHistoryAll == null) return result;
//        
//        Date lastDate = null;
//        int changesHistoryId = 0;
//        VRMap map = null;
//        
//        //�����f�[�^��S����
//        String[] changesContentTypes = changesContentType.split(",");
//        
//        for(int i = 0; i < changesHistoryAll.getDataSize(); i++){
//            map = (VRMap)changesHistoryAll.getData(i);
//            
//            //if(String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL")).equals(systemServiceKindDetail) &&
//            if(systemServiceKindDetail.indexOf(String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL"))) != -1 &&
//                    String.valueOf(map.get("CHANGES_CONTENT")).equals(chargeContent)){
//                
//                for(int j = 0; j < changesContentTypes.length; j++){
//                    if(String.valueOf(map.get("CHANGES_CONTENT_TYPE")).equals(changesContentTypes[j])){
//                        //��r�Ώۂ̓��t�����ɑ��݂���ꍇ
//                        if(lastDate != null){
//                            //����ԍ����r
//                            if(changesHistoryId < ACCastUtilities.toInt(map.get("CHANGES_HISTORY_ID"))){
//                                lastDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
//                                changesHistoryId = ACCastUtilities.toInt(map.get("CHANGES_HISTORY_ID"),0);
//                                result = map;
//                            }
//                        } else {
//                            lastDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
//                            changesHistoryId = ACCastUtilities.toInt(map.get("CHANGES_HISTORY_ID"),0);
//                            result = map;
//                        }
//                    }
//                }
//            }
//        }
//        
//        return result;
//    }
    
    /**
     * ���p�҂̈ٓ�����S�̂�����E�ޏ����̃f�[�^����������B
     * @param systemServiceKindDetail �V�X�e�����T�[�r�X�R�[�h
     * @param chargeContent �ړ����R 1-�J�n�E�����E���@�E�K��J�n    2-�I���E�ޏ��E�މ@�E�K��I��
     * @param changesContentType 1-����n�@2-�{�݌n1�@3-�{�݌n2 4-��ÊŌ� 5-�����n
     * @param target �����Ώۓ��t
     * @return �擾����CHANGES_DATE
     * @throws Exception
     */
    protected VRMap getChangeDataAll(String systemServiceKindDetail, String target) throws Exception {
    	
    	VRMap result = new VRHashMap();
    	VRMap in = null; //�������R�[�h
    	VRMap out = null; //�ޏ����R�[�h
    	
    	if (changesHistoryAll == null) {
    		return result;
    	}
    	
        //��r�Ώۂ̓��t��Date�ɕϊ�����B
    	if(target.length() == 6){
    		target += "01";
    	}
    	
    	Date targetDate = ACCastUtilities.toDate(target, null);
        if(targetDate == null){
            return result;
        }
        
        
        //yyyyMMdd(�ٓ��N����) - �ٓ����R - ����ԍ����L�[��TreeMap�֊i�[
        Map<String, VRMap> history = new TreeMap<String, VRMap>();
        
        //�K�v�Ȉٓ����R�̃^�C�v
        Set<String> changesContentType = new HashSet<String>();
        changesContentType.add("2"); //�{�݌n1
        changesContentType.add("3"); //�{�݌n2
        changesContentType.add("5"); //�����n
        
        VRMap map = null;
        StringBuilder key = null;
        
        for(int i = 0; i < changesHistoryAll.getDataSize(); i++){
        	map = (VRMap)changesHistoryAll.getData(i);
        	
        	//�T�[�r�X��ރR�[�h���m�F�@�ΏۃT�[�r�X�łȂ���Γǂݔ�΂�
        	if(systemServiceKindDetail.indexOf(String.valueOf(map.get("SYSTEM_SERVICE_KIND_DETAIL"))) == -1) {
        		continue;
        	}
        	
        	//�ٓ����R�̃R�[�h���m�F�@�ΏۂłȂ���Γǂݔ�΂�
        	if (!changesContentType.contains(String.valueOf(map.get("CHANGES_CONTENT_TYPE")))) {
        		continue;
        	}
        	
        	//�擾�������t���Ώی��ȑO���m�F�i�Ώی����܂ށj
        	//�Ώی��ȍ~�ł���Ζ���
        	Date candidateDate = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
        	if(ACDateUtilities.compareOnMonth(targetDate, candidateDate) < 0){
        		continue;
        	}
        	
        	//�\�[�g�p�̃L�[���쐬���ATreeMap�֐ݒ�
        	key = new StringBuilder();
        	key.append(VRDateParser.format(candidateDate, "yyyyMMdd")); //�ٓ���
        	key.append("-");
        	key.append(map.get("CHANGES_CONTENT"));	//�ٓ����R
        	key.append("-");
        	key.append(ACFillZero10LeftFormat.getInstance().format(map.get("CHANGES_HISTORY_ID")));
        	
        	history.put(key.toString(), map);
        }
        
        
        //�������A�ޏ������m�肷��
        map = null;
        for (VRMap row : history.values()) {
        	int cr = ACCastUtilities.toInt(row.get("CHANGES_CONTENT"), 0);
        	
        	//���񃋁[�v
        	if (map == null) {
        		//����
        		if (cr == 1) {
        			in = row;
        		//�ޏ�
        		} else if (cr == 2) {
        			out = row;
        		}
        		map = row;
        		continue;
        	}
        	
        	int cm = ACCastUtilities.toInt(map.get("CHANGES_CONTENT"), 0);
        	Date dm = ACCastUtilities.toDate(map.get("CHANGES_DATE"));
        	Date dr = ACCastUtilities.toDate(row.get("CHANGES_DATE"));
        	
        	//�������̏ꍇtargetDate
        	if ((ACDateUtilities.compareOnMonth(dm, dr) == 0) &&
        			(ACDateUtilities.compareOnMonth(dm, targetDate) == 0)){
        		
        		if (cm == 1) {
        			//�����ɓ����������A�� => �ޏ��𖳌���
        			if (cr == 1) {
        				out = null;
        				
        			//�����̌�̑ޏ��͍̗p
        			} else if (cr == 2){
        				out = row;
        			}
        			
        		} else if (cm == 2) {
        			//�����ɑޏ� => �����̏ꍇ�́A�ޏ��𖳌���
        			if (cr == 1) {
        				out = null;
        				
        			//�ޏ��̌�̑ޏ��́A��̕��̑ޏ����̗p
        			} else if (cr == 2){
        				out = row;
        			}
        		}
        		
        	} else {
        		//����
        		if (cr == 1) {
        			in = row;
        		//�ޏ�
        		} else if (cr == 2) {
        			out = row;
        		}
        		map = row;
        	}
        	
        }
    	
    	result.put("IN", in);
    	result.put("OUT", out);
    	
    	return result;
    }
    
    //[ID:0000750][Shin Fujihara] 2012/09 edit end 2012�N�x�Ή� �ٓ���񂩂���E�މ@���̎擾���@�ύX
    
    //=================================================================================================
    // ���p�҂̑O�����тɋL�ڂ���Ă���K�p���̓��e�擾
    //=================================================================================================
    
    /**
     * �w�肵���T�[�r�X�R�[�h�A�J�e�S���̑O�����W�v�ɋL�ڂ���Ă���E�v���i�������������j���擾����
     * @param serviceCode �T�[�r�X�R�[�h
     * @return �擾�����E�v���L�ڎ����i�������������j
     * @throws Exception
     */
    protected String getLastRecapitulationCategory3(String serviceCode) throws Exception {
    	String result = "";
    	if((claim == null) || (claim.size() == 0)){
    		return result;
    	}
    	
    	for(int i = 0; i < claim.size(); i++){
    		VRMap map = (VRMap)claim.get(i);
    		String lastServiceCode = "";
    		int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"),0);
    		
    		//���R�[�h��ʂ�3(���׏��)�ȊO�̃��R�[�h�͓ǂݔ�΂�
    		if(categoryNo != 3){
    			continue;
    		}
    		lastServiceCode = ACCastUtilities.toString(map.get("301007"),"") + ACCastUtilities.toString(map.get("301008"),"");
    		
    		//�T�[�r�X�R�[�h���w��ȊO�ł���΁A�ǂݔ�΂�
    		if(!serviceCode.equals(lastServiceCode)){
    			continue;
    		}

    		//�E�v�����擾
    		// 2015/4/24 [H27.4�����Ή�][Shinobu Hitaka] edit - begin �����E�v������ꍇ�̑Ή�
//    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get("301018"),""))){
//    			String[] temp = ACCastUtilities.toString(map.get("301018"),"").split("/");
//    			if(!temp[0].endsWith("%")){
//    				result = temp[0];
//    			}
//    			break;
//    		}
    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get("301018"),""))){
    			String[] temp = ACCastUtilities.toString(map.get("301018"),"").split("/");
    			for ( int j = 0; j < temp.length; j++ ) {
    				if(!temp[j].endsWith("%")){
    					if (result.length() > 0) {
    						result += "/";
    					}
    					result += temp[j];
    				}
    			}
    			break;
    		}
    		// 2015/4/24 [H27.4�����Ή�][Shinobu Hitaka] edit - end 
    	}
    	
    	return result;
    }
    
    
    /**
     * ����f�Ô�R�[�h���珝�a�����擾���A�ԋp����B
     * @param styleIdentificationNo �������ʔԍ�
     * @return �擾�������a��
     * @throws Exception
     */
    protected String getLastRecapitulationCategory5(String styleIdentificationNo) throws Exception {
    	String result = "";
    	if((claim == null) || (claim.size() == 0)){
    		return result;
    	}
    	
    	for(int i = 0; i < claim.size(); i++){
    		VRMap map = (VRMap)claim.get(i);
    		String lastStyleIdentificationNo = "";
    		int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"),0);
    		
    		//���R�[�h��ʂ�5(����f�Ô�)�ȊO�̃��R�[�h�͓ǂݔ�΂�
    		if(categoryNo != 5){
    			continue;
    		}
    		//�������ʔԍ�
    		lastStyleIdentificationNo = ACCastUtilities.toString(map.get("501001"),"");
    		
    		if(!lastStyleIdentificationNo.equals(styleIdentificationNo)){
    			continue;
    		}
    		
    		//���a�����擾
    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get("501008"),""))){
    			result = ACCastUtilities.toString(map.get("501008"),"");
    			break;
    		}
    	}
    	
    	return result;
    }
    
    /**
     * �w�肵���T�[�r�X�R�[�h�A�J�e�S���̑O�����W�v�ɋL�ڂ���Ă���E�v���i�������������j���擾����
     * @param serviceCode �T�[�r�X�R�[�h
     * @return �擾�����E�v���L�ڎ����i�������������j
     * @throws Exception
     */
    protected String getLastRecapitulationCategory5(String styleIdentificationNo,String consultationIdentificationNo) throws Exception {
    	String result = "";
    	if((claim == null) || (claim.size() == 0)){
    		return result;
    	}
    	
    	for(int i = 0; i < claim.size(); i++){
    		VRMap map = (VRMap)claim.get(i);
    		String lastStyleIdentificationNo = "";
    		String lastConsultationIdentificationNo = "";
    		int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"),0);
    		
    		//���R�[�h��ʂ�5(����f�Ô�)�ȊO�̃��R�[�h�͓ǂݔ�΂�
    		if(categoryNo != 5){
    			continue;
    		}
    		//�������ʔԍ�
    		lastStyleIdentificationNo = ACCastUtilities.toString(map.get("501001"),"");
    		
    		if(!lastStyleIdentificationNo.equals(styleIdentificationNo)){
    			continue;
    		}
    		
    		//�f�Î��ʔԍ�
    		lastConsultationIdentificationNo = ACCastUtilities.toString(map.get("501009"),"");
    		
    		if(!lastConsultationIdentificationNo.equals(consultationIdentificationNo)){
    			continue;
    		}

    		//�E�v�����擾
    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get("501023"),""))){
    			result = ACCastUtilities.toString(map.get("501023"),"");
    			break;
    		}
    	}
    	
    	return result;
    }
    
 // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - begin
	/**
	 * �w�肵���������ʔԍ��A�E�v��ރR�[�h�̑O�����̊�{�E�v���̓E�v�����擾����
	 * 
	 * @param styleIdentificationNo
	 *            �������ʔԍ�
	 * @param baseSummariKind
	 *            �E�v��ރR�[�h
	 * @return �擾������{�E�v���L�ڎ���
	 * @throws Exception
	 */
	protected String getLastRecapitulationCategory19(String styleIdentificationNo, String baseSummariKind)
			throws Exception {
		String result = "";
		if ((claim == null) || (claim.size() == 0)) {
			return result;
		}

		for (int i = 0; i < claim.size(); i++) {
			VRMap map = (VRMap) claim.get(i);
			String lastStyleIdentificationNo = "";
			String lastBaseSummariKind = "";
			int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"), 0);

			// ���R�[�h��ʂ�19(��{�E�v���R�[�h)�ȊO�̃��R�[�h�͓ǂݔ�΂�
			if (categoryNo != 19) {
				continue;
			}
			// �������ʔԍ�
			lastStyleIdentificationNo = ACCastUtilities.toString(map.get("1901001"), "");

			if (!lastStyleIdentificationNo.equals(styleIdentificationNo)) {
				continue;
			}

			// �E�v��ރR�[�h
			lastBaseSummariKind = ACCastUtilities.toString(map.get("1901007"), "");

			if (!lastBaseSummariKind.equals(baseSummariKind)) {
				continue;
			}

			// �E�v�����擾
			if (!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get("1901008"), ""))) {
				result = ACCastUtilities.toString(map.get("1901008"), "");
				break;
			}
		}

		return result;
	}
 // [H30.4�����Ή�][Yoichiro Kamei] 2018/4/2 add - end
    
    /**
     * �w�肵���o�C���h�p�X�̖K��Ō��ÑO�����̏����擾����B
     * @param systemBindPath �擾�Ώۂ̃o�C���h�p�X
     * @return �擾�������e
     * @throws Exception
     */
    protected Object getLastDataCategory13(String systemBindPath) throws Exception {
    	Object result = null;
    	if((claim == null) || (claim.size() == 0)){
    		return result;
    	}
    	
    	for(int i = 0; i < claim.size(); i++){
    		VRMap map = (VRMap)claim.get(i);
    		int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"),0);
    		
    		//���R�[�h��ʂ�13(�K��Ō���)�ȊO�̃��R�[�h�͓ǂݔ�΂�
    		if(categoryNo != 13){
    			continue;
    		}

    		//�E�v�����擾
    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get(systemBindPath),""))){
    			result = map.get(systemBindPath);
    			break;
    		}
    	}
    	
    	return result;
    }
    
    //[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
    /**
     * �w�肵���o�C���h�p�X�̊�{��񃌃R�[�h�̐挎���������擾����B
     * @param _201001 �������ʔԍ�
     * @param systemBindPath �擾�Ώۂ̃o�C���h�p�X
     * @return �擾�������e
     * @throws Exception
     */
    protected Object getLastDataCategory2(String _201001, String systemBindPath) throws Exception {
    	Object result = null;
    	if((claim == null) || (claim.size() == 0)){
    		return result;
    	}
    	
    	for(int i = 0; i < claim.size(); i++){
    		VRMap map = (VRMap)claim.get(i);
    		int categoryNo = ACCastUtilities.toInt(map.get("CATEGORY_NO"),0);
    		
    		//���R�[�h��ʂ�2(��{��񃌃R�[�h)�ȊO�̃��R�[�h�͓ǂݔ�΂�
    		if(categoryNo != 2){
    			continue;
    		}
    		
    		//�������ʔԍ�
    		String style_id = ACCastUtilities.toString(map.get("201001"),"");
    		
    		if (!style_id.equals(_201001)){
    			continue;
    		}

    		//�E�v�����擾
    		if(!ACTextUtilities.isNullText(ACCastUtilities.toString(map.get(systemBindPath),""))){
    			result = map.get(systemBindPath);
    			break;
    		}
    	}
    	return result;
    }
    //[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
    
    
    //2008/09/03 [Shin Fujihara] add - begin 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
    /**
     * �w�肳�ꂽ�T�[�r�X��ރR�[�h�ŏW�v�Ŗ������ꂽ�P�ʐ���ݒ�
     * @param serviceDetail �T�[�r�X�ڍ�
     * @param serviceCode �T�[�r�X�R�[�h
     * @throws 
     */
    protected void putAbandonedUnit(VRMap serviceDetail,VRMap serviceCode) throws Exception {
    	
        String serviceCodeKind = ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));
        String key = serviceCodeKind + ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_ITEM"));
        int unit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
        
        //[ID:0000717][Shin Fujihara] 2012/04 add start ����24�N4���@�����Ή�
        //������Q�C��
        //���R�[�h��ʂ� 3-���ʒn�� 6-���R�� 8-�������P�̏ꍇ�́A�S�z���ȕ��S�Ƃ���
        //�ςݏグ���s��Ȃ��悤�C��
        switch (ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_FLAG"),0)) {
        case 3: //���ʒn��
        case 6: //���R��
        case 8: //�������P
            //[ID:0000734][Shin Fujihara] 2012/04 add start 30�����̏������P���Z�̌v�Z
            //30�����̒P�ʐ��ɂ��A���ʒn��A���R�ԁA�������P���Z��K�p����
            abandonedUnitAddition.put(serviceCodeKind + "_" + serviceCode.get("SERVICE_ADD_FLAG"), serviceCode);
            //[ID:0000734][Shin Fujihara] 2012/04 add end 30�����̏������P���Z�̌v�Z
            return;
        }
        //[ID:0000717][Shin Fujihara] 2012/04 add end ����24�N4���@�����Ή�
        
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/23 add - begin
        // �����^���Z�̃T�[�r�X�R�[�h�̏ꍇ
        if (CareServiceCommon.isAddPercentageForKyousei(serviceCode)) {        	
        	//�T�[�r�X�R�[�h��ێ��i��Ōv�Z�Ɏg�p�j
        	if (!kyouseiCodes.containsKey(key)) {
        		kyouseiCodes.put(key, serviceCode);
        	}
        	if (!kyouseiAdderKindMap.containsKey(serviceCodeKind)) {
        		kyouseiAdderKindMap.put(serviceCodeKind, new HashMap<String, QP001PercentageAdder>());
        	}
        	Map<String, QP001PercentageAdder> kyouseiAdderMap = kyouseiAdderKindMap.get(serviceCodeKind);
        	//�����^���Z�̑ΏۂƂȂ��{�T�[�r�X�̒P�ʐ���ێ�        	
        	if (!kyouseiAdderMap.containsKey(key)) {
        		kyouseiAdderMap.put(key, new QP001PercentageAdder());
        	}
        	QP001PercentageAdder kyouseiAdder = kyouseiAdderMap.get(key);
        	Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE", serviceDetail);
        	kyouseiAdder.parse(serviceCode, targetServiceDate);
        	
        	//�ȍ~�̏����͍s�킸���^�[������
        	return;
        }        
        // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/23 add - end
        
    	switch(ACCastUtilities.toInt(serviceCode.get("TOTAL_GROUPING_TYPE"),0)){
    	//2-���P��
    	case 2:
    		Object serviceDate = serviceDetail.get("SERVICE_DATE");
    		//���ɉ��Z�������`�F�b�N����
    		if (abandonedDays.containsKey(key)){
    			VRList days = (VRList)abandonedDays.get(key);
    			if (days.contains(serviceDate)) {
    				return;
    			}
    			days.add(serviceDate);
    		} else {
    			VRList days = new VRArrayList();
    			days.add(serviceDate);
    			abandonedDays.put(key, days);
    		}
    		break;
    	}
        
    	int total_unit = 0;
    	if (abandonedUnit.containsKey(serviceCodeKind)) {
    		total_unit = ACCastUtilities.toInt(abandonedUnit.get(serviceCodeKind), 0);
    	}
    	abandonedUnit.put(serviceCodeKind, new Integer(total_unit + unit));
    }
    /**
     * �w�肳�ꂽ�T�[�r�X��ރR�[�h�ŏW�v�Ŗ������ꂽ�P�ʐ����擾����
     * @param serviceCodeKind �T�[�r�X��ރR�[�h
     * @return �P�ʐ�
     * @throws
     */
    protected int getAbandonedUnit(String serviceCodeKind) throws Exception {
    	int result = 0;
    	if (abandonedUnit.containsKey(serviceCodeKind)){
    		result = ACCastUtilities.toInt(abandonedUnit.get(serviceCodeKind) ,0);
    	}
    	
    	//[ID:0000734][Shin Fujihara] 2012/04 add start 30�����̏������P���Z�̌v�Z
    	//���o�����P�ʐ���0�Ȃ珈���I��
    	if (result == 0) {
    	    return result;
    	}
    	
    	VRMap serviceCode = null;
    	String key;
    	int unit = 0;
    	//���Z�̃`�F�b�N
    	// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/23 mod - begin�@�������P���Z�ȊO�́����Z�͂��ׂĕی������Ƃ���悤�ύX
//    	//���ʒn��
//    	key = serviceCodeKind + "_3";
//    	if (abandonedUnitAddition.containsKey(key)) {
//    	    serviceCode = (VRMap)abandonedUnitAddition.get(key);
//    	    unit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
//    	    result += (int) Math.round((double) ( result * unit) / 100d);
//    	}
//    	
//    	//���R��
//    	key = serviceCodeKind + "_6";
//        if (abandonedUnitAddition.containsKey(key)) {
//            serviceCode = (VRMap)abandonedUnitAddition.get(key);
//            unit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
//            result += (int) Math.round((double) ( result * unit) / 100d);
//        }
    	// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/23 mod - end
    	
    	// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/23 add - begin
    	// �����^���Z�̔��f
    	if (kyouseiAdderKindMap.containsKey(serviceCodeKind)) {
    		Map<String, QP001PercentageAdder> kyouseiAdderMap = kyouseiAdderKindMap.get(serviceCodeKind);
        	int kyouseiUnit = 0;
        	for (String svCode : kyouseiAdderMap.keySet()) {
        		QP001PercentageAdder kyouseiAdder = kyouseiAdderMap.get(svCode);
        		Map code = kyouseiCodes.get(svCode);
        		//���Z��
        		int per = ACCastUtilities.toInt(code.get("SERVICE_UNIT"), 0);
        		int totalUnit = kyouseiAdder.getUnit();
        		kyouseiUnit += CareServiceCommon.calcPercentageUnit(totalUnit, per);
        	}
        	result += kyouseiUnit;
    	}
    	// [H30.4�����Ή�][Yoichiro Kamei] 2018/3/23 add - end
    	
        //�������P
        key = serviceCodeKind + "_8";
        if (abandonedUnitAddition.containsKey(key)) {
            serviceCode = (VRMap)abandonedUnitAddition.get(key);
            unit = ACCastUtilities.toInt(serviceCode.get("SERVICE_UNIT"), 0);
            
            int staffUnit = ACCastUtilities.toInt(serviceCode.get("SERVICE_STAFF_UNIT"), 0);
            result += CareServiceCommon.calcSyogu(result, unit, staffUnit);
        }
    	//[ID:0000734][Shin Fujihara] 2012/04 add end 30�����̏������P���Z�̌v�Z
    	
    	return result;
    }
    //2008/09/03 [Shin Fujihara] add - end 30�����̒P�ʐ���PatientState�ɕێ�����悤�ύX
    
	/**
	 * �����I��int�ɕϊ�����B
	 * @param key
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private int getInt(String key,VRMap map) throws Exception {
		String target = String.valueOf(VRBindPathParser.get(key,map));
		target = target.replaceAll("-|/","");
		
		return Integer.parseInt(target);
	}
	
    /**
     * ���t�ɕϊ��\�ȕ�����֕ύX����B
     * @param value
     * @return
     * @throws Exception
     */
	private String toDateString(Object value) throws Exception {
		if(value instanceof Date){
			return toDateString((Date)value);
		} else {
			return toDateString(ACCastUtilities.toString(value));
		}
	}
	
    /**
     * yyyyMMdd�^���̕�����ɕϊ�����B
     * @param value
     * @return
     * @throws Exception
     */
	private String toDateString(Date value) throws Exception {
		return toDateString(VRDateParser.format(value,"yyyyMMdd"));
	}
	
	/**
	 * �����I�ɓ��t������ɕϊ�����B
	 * @param value
	 * @return
	 */
	private String toDateString(String value){
		if((value == null) || value.length() < 8) return null;
		
		StringBuilder esc = new StringBuilder();
		char[] data = value.toCharArray();
		
		for(int i = 0; i < data.length; i++){
			if("0123456789".indexOf(data[i]) != -1){
				esc.append(data[i]);
				if(esc.length() == 8) break;
			}
		}
		if(esc.length() == 8) {
			return esc.toString();
		} else {
			return null;
		}
	}
	
	
	//[ID:0000682][Shin Fujihara] add begin �y�@�����Ή��z���E���������P���Z
    /**
     * �w�肳�ꂽ�T�[�r�X��ރR�[�h�ŏW�v�Ŗ������ꂽ�P�ʐ���ݒ�
     * @param serviceCodeKind �T�[�r�X��ރR�[�h
     * @param unit �ǉ�����P�ʐ�
     * @throws 
     */
    protected void putAddSelfpay(String serviceCodeKind, int unit) throws Exception {
        
        int total_unit = 0;
        if (addSelfpay.containsKey(serviceCodeKind)) {
            total_unit = ACCastUtilities.toInt(addSelfpay.get(serviceCodeKind), 0);
        }
        addSelfpay.put(serviceCodeKind, new Integer(total_unit + unit));
    }
    
    protected int getAddSelfpay(String serviceCodeKind) throws Exception {
        
        int result = 0;
        if (addSelfpay.containsKey(serviceCodeKind)) {
            result = ACCastUtilities.toInt(addSelfpay.get(serviceCodeKind), 0);
        }
        return result;
    }
	//[ID:0000682][Shin Fujihara] add end �y�@�����Ή��z���E���������P���Z
    
    
    //[CCCX:1653][Shinobu Hitaka] 2014/03/19 add - start �������P�L�{����ȕ��S�L�̍ďW�v
    /**
     * ����ȕ��S�z��ݒ肷��B
     * setKohiSelfPay->���g�p��, clearKohiSelfPay->�ǉ� 2015/06/05
     * @param kohiKey
     * @param pay
     * @throws Exception
     */
    protected void setKohiSelfPay(QP001KohiKey kohiKey, int pay) throws Exception {
        if(kohiSelfPay.containsKey(kohiKey)){
            int value = ((Integer)kohiSelfPay.get(kohiKey)).intValue();
            value = pay;
            kohiSelfPay.put(kohiKey,new Integer(value));
        }
    }
    
    protected void clearKohiSelfPay() throws Exception {
    	kohiSelfPay.clear();
    }
    //[CCCX:1653][Shinobu Hitaka] 2014/03/19 add - end   �������P�L�{����ȕ��S�L�̍ďW�v
    
	// [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - begin �T�[�r�X�񋟑̐����Z�̎��ȕ��S�Ή�
	public SelfPaymentNumberCalcurater getSelfPaymentNumberCalcurater() {
		return selfPaymentNumberCalcurater;
	}

	public void setSelfPaymentNumberCalcurater(
			SelfPaymentNumberCalcurater selfPaymentNumberCalcurater) {
		this.selfPaymentNumberCalcurater = selfPaymentNumberCalcurater;
	}
	// [H27.4�����Ή�][Yoichiro Kamei] 2015/4/3 add - end
}
