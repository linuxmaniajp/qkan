
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
 * �쐬��: 2009/07/22  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���ъm��/�������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� �O��W�v���ʕێ����� (QP001InformationHold)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACSQLSafeDateFormat;
import jp.nichicom.ac.text.ACSQLSafeStringFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;

public class QP001InformationProcessing {
	
	/**
	 * ���L�񌏂̈Č��ɑΉ����邽�߁A�N���X��ǉ�
	 * [ID:0000434][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
	 * [ID:0000491][Shin Fujihara] 2009/07 add begin 2009�N�x�Ή�
	 */
	
	private VRList claim = null;
	
	private ACDBManager dbm = null;
	private QP001PatientState patient = null;
	
	private VRMap diagnosisQueue = new VRHashMap();
	private VRList detailsDivision = new VRArrayList();
	private VRList serviceKindListLastMonth = new VRArrayList();
	private VRList serviceKindListThisMonth = new VRArrayList();
	
	/**
	 * ��������@�󔒈ȊO
	 */
	private final int NOT_EMPTY = 1;
	/**
	 * ��������@�[���ȊO
	 */
	private final int NOT_ZERO = 2;
	
	/**
	 * �R���X�g���N�^�ŁA�ďW�v�O�̃f�[�^��ޔ����Ă���
	 */
	public QP001InformationProcessing(ACDBManager dbm, QP001PatientState patient, Date targetDate) throws Exception {
		
        this.patient = patient;
        this.dbm = dbm;
		
        // �����ڍ׏����擾���AVRArrayList claimList �Ɋi�[����B
        StringBuilder sb = new StringBuilder();
        
        //���������擾
        sb.append(" SELECT");
        sb.append(" DISTINCT");
        sb.append(" CLAIM_DATE");
        sb.append(" FROM");
        sb.append(" CLAIM");
        sb.append(" WHERE");
        sb.append(" (CLAIM.PATIENT_ID = " + patient.getPatientId() + ")");
        sb.append(" AND (CLAIM.TARGET_DATE = '" + VRDateParser.format(targetDate,"yyyy/MM/dd") + "')");
        sb.append(" AND (CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        sb.append(" ORDER BY CLAIM.LAST_TIME DESC");
        
        VRList list = dbm.executeQuery(sb.toString());
        
        if((list == null) || (list.size() == 0)){
        	return;
        }
        
        Date claimDate = ACCastUtilities.toDate(((VRMap)list.get(0)).get("CLAIM_DATE"),null);
        
        if(claimDate == null){
        	return;
        }
        
        sb = new StringBuilder();
        
        sb.append(" AND(CLAIM.TARGET_DATE = '" + VRDateParser.format(targetDate,"yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.PATIENT_ID = " + patient.getPatientId() + ")");
        sb.append(" AND(CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
        sb.append(" AND (CLAIM.CATEGORY_NO IN (2,3,5,7))");
        
        //��������ޔ�
        claim = QkanCommon.getClaimDetailCustom(dbm, claimDate, sb.toString());
	}
	
	/**
	 * �W�v���ʂɁA�ďW�v�O�̌��ʂ𔽉f������B
	 * @param updateList
	 * @throws Exception
	 */
	public void reflect(VRList updateList) throws Exception {
		if (updateList == null) {
			return;
		}
		
		//�挎�񋟂����T�[�r�X��ރR�[�h��ޔ�
		setServiceKind(patient.claim, serviceKindListLastMonth);
		//�����񋟂����T�[�r�X��ރR�[�h��ޔ�
		setServiceKind(updateList, serviceKindListThisMonth);
		
		for (int i = 0; i < updateList.size(); i++){
			VRMap map = (VRMap)updateList.get(i);
			reflectStyle(map);
		}
		
		//���a���R�s�[��O����
		Iterator it = diagnosisQueue.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			if (key.endsWith("99")) {
				if (diagnosisQueue.containsKey(key.substring(0, key.length() - 3) + "-1")) {
					continue;
				}
			}
			// �R�s�[����
			setInvalidName((VRMap)diagnosisQueue.get(key));
		}
		
		if (detailsDivision.size() > 0) {
			updateList.addAll(detailsDivision);
		}
	}
	
	private void setServiceKind(VRList targetList, VRList serviceKindList) throws Exception {
		
		if ((targetList == null) || (targetList.size() == 0)) {
			return;
		}
		
		for (int i = 0; i < targetList.size(); i++) {
    		VRMap map = (VRMap)targetList.get(i);
    		
    		//���R�[�h��ʂ�3(���׏��)�ȊO�̃��R�[�h�͓ǂݔ�΂�
    		if(ACCastUtilities.toInt(map.get("CATEGORY_NO"),0) != 3){
    			continue;
    		}
    		
    		String serviceCoceKind = ACCastUtilities.toString(map.get("301007"), "");
    		
    		if (!serviceKindList.contains(serviceCoceKind)) {
    			serviceKindList.add(serviceCoceKind);
    		}
		}
	}
	
	/**
	 * �񋟉񐔂�99��𒴂���ꍇ�A���R�[�h�𕪊�����
	 * @param map
	 * @throws Exception
	 */
	private void reflectDetails(VRMap map) throws Exception {
		//�����A�񐔂��m�F
		int count = ACCastUtilities.toInt(map.get("301010"), 0);
		if (count <= 99){
			return;
		}
		
		int kohi1 = ACCastUtilities.toInt(map.get("301011"), 0);
		int kohi2 = ACCastUtilities.toInt(map.get("301012"), 0);
		int kohi3 = ACCastUtilities.toInt(map.get("301013"), 0);
		
		int[] counts = new int[]{count, kohi1, kohi2, kohi3};
		
		//�������g�̃��R�[�h���X�V
		//�����A��
		map.put("301010", stealCount(counts, 0));
		//����P
		map.put("301011", stealCount(counts, 1));
		//����Q
		map.put("301012", stealCount(counts, 2));
		//����R
		map.put("301013", stealCount(counts, 3));
		reCalcDetails(map);
		
		while(true){
			VRMap split = copyDetails(map);
			
			//�����A��
			split.put("301010", stealCount(counts, 0));
			//����P
			split.put("301011", stealCount(counts, 1));
			//����Q
			split.put("301012", stealCount(counts, 2));
			//����R
			split.put("301013", stealCount(counts, 3));
			reCalcDetails(split);
			
			detailsDivision.add(split);
			if (counts[0] <= 0) {
				break;
			}
		}
	}
	
	private String stealCount(int[] counts, int index) throws Exception {
		String result = "";
		int target = counts[index];
		if (target < 99) {
			result = String.valueOf(counts[index]);
			counts[index] = 0;
		} else {
			result = "99";
			counts[index] -= 99;
		}
		return result;
	}
	
	private void reCalcDetails(VRMap map) throws Exception {
		
		int _301009 = ACCastUtilities.toInt(map.get("301009"), 0);
		
		//�T�[�r�X�P�ʐ� = �P�ʐ� * ��
		map.put("301014", 
				String.valueOf(
				_301009 * ACCastUtilities.toInt(map.get("301010"), 0)));
		
		//����P�ΏۃT�[�r�X�P�ʐ� = �P�ʐ� * ����P�����E��
		map.put("301015", 
				String.valueOf(
				_301009 * ACCastUtilities.toInt(map.get("301011"), 0)));
		
		//����Q�ΏۃT�[�r�X�P�ʐ� = �P�ʐ� * ����Q�����E��
		map.put("301016", 
				String.valueOf(
				_301009 * ACCastUtilities.toInt(map.get("301012"), 0)));
		
		//����R�ΏۃT�[�r�X�P�ʐ� = �P�ʐ� * ����R�����E��
		map.put("301017", 
				String.valueOf(
				_301009 * ACCastUtilities.toInt(map.get("301013"), 0)));
	}
	
	private VRMap copyDetails(VRMap map) throws Exception {
		VRMap result = new VRHashMap();
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next().toString();
			result.put(key, map.get(key));
		}
		
		return result;
	}
	
	
	/**
	 * �l�����(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect2base(VRMap map) throws Exception {
		
		//�J�n�N����
		//�ٓ���񂪐ݒ肳��Ă��Ȃ��ꍇ
		if (ACTextUtilities.isNullText(map.get("201021"))) {
			//���K�͑��@�\�A�����^�̏ꍇ
			if (isSyokiboTakinou()){
				
				//�O��W�v���~�N�����擾
				Object _201022 = patient.getLastDataCategory2(String.valueOf(map.get("201001")), "201022");
				//�O��̒��~�N�������ݒ肳��Ă��Ȃ��ꍇ
				if (ACTextUtilities.isNullText(_201022)) {
					//�W�v�O�A�J�n�����ݒ肳��Ă��Ȃ��ꍇ
					//�O��W�v���ʂ���A�J�n�N������ݒ肷��
					Object _201021 = patient.getLastDataCategory2(String.valueOf(map.get("201001")), "201021");
					if (!ACTextUtilities.isNullText(_201021)) {
						map.put("201021", _201021);
					} else {
						//�W�v�O�̃f�[�^���ݒ�ł���΁A�ݒ肷��
						setSameBase(map,"201021");
					}
				}
			} else { 
				//�W�v�O�̃f�[�^���ݒ�ł���΁A�ݒ肷��
				setSameBase(map,"201021");
			}
		}
		
		//���~�N����
		if (ACTextUtilities.isNullText(map.get("201022"))) {
			setSameBase(map,"201022");
		}
		
		//���~���R�R�[�h
		if (ACCastUtilities.toInt(map.get("201023"), 0) == 0) {
			setSameBase(map,"201023", NOT_ZERO);
		}
	}
	
	/**
	 * �l�����(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect2details(VRMap map) throws Exception {
		
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/2/27 edit - begin �p�~���ǉ��R�[�h�Ή�
		/*
		int serviceCode = getServiceCode(map);
		boolean changed = false;
		
		//�W�v�ێ��@�\
		switch(serviceCode) {
		//�Z���W�����n�r���e�[�V�������Z
		case 145001:
		case 145002:
		//�ʏ����n�r���e�[�V����
		case 165602:
		case 165603:
		case 165604:
		//[CCCX:1616,2096][Shinobu Hitaka] 2014/11/25 add �u16 5610�F�ʏ����n�d�x�×{�Ǘ����Z�v��ǉ�
		case 165610:
		//���K�͑��@�\�@���Ə��J�n�����Z
		case 736139:
		case 736140:
			changed = setSameDetails(map);
			break;
		}
		*/
		
		String serviceCode = getServiceCode(map);
		boolean changed = false;
		
		//�W�v�ێ��@�\
		//�K�⃊�n          145001:�p�~�@145002:�p�~�@145003:�Z���W�����n���Z
		//�ʏ����n          165602:�p�~�@165603:�p�~�@165604:�p�~
		//                  165610:�d�x�×{�Ǘ����Z �@165613:�Z���W���ʃ��n���Z�i�ǉ��j
		//�Z�������������  216116:��ØA�g�������Z
		//���K�͑��@�\      736139:�p�~�@736140:�p�~
		//�����^�T�[�r�X    776139:���ƊJ�n���x�����Z
		if ("145003".equals(serviceCode)
			|| "165610".equals(serviceCode) || "165613".equals(serviceCode)
			|| "216116".equals(serviceCode) || "776139".equals(serviceCode)
			) {
			changed = setSameDetails(map);
		}
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/2/27 edit - end

		if (changed) {
			return;
		}
		
		//�O���ǂݍ��݋@�\
		/*
		14 5002�̃T�[�r�X�����݂��Ă���A���O���̃f�[�^�� 14 5001������ꍇ��14 5001 �̓E�v���̃f�[�^��ݒ�B
		���K�⃊�n
		14 5001 �K�⃊�n�Z���W�����Z�P��14 5002 �K�⃊�n�Z���W�����Z�Q

		�K�⃊�n�̏ꍇ�ƐU��ւ��̕��j�͓��l
		���ʏ����n
		16 5602 �ʏ����n�Z���W�����n���Z�P��16 5603 �ʏ����n�Z���W�����n���Z�Q
		*/
		
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/2/27 edit - begin �p�~�ɂ��R�����g��
		/*
		Object _301018 = null;
		
		switch(serviceCode) {
		//�Z���W�����n�r���e�[�V�������Z
		case 145002:
			_301018 = patient.getLastRecapitulationCategory3("145001");
			break;
		//�ʏ����n�r���e�[�V����
		case 165603:
			_301018 = patient.getLastRecapitulationCategory3("165602");
			break;
		}
		
		if (!ACTextUtilities.isNullText(_301018)){
			map.put("301018", _301018);
		}
		*/
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/27 edit - end
	}
	
	/**
	 * �l�����̓�(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect22base(VRMap map) throws Exception {
		//�J�n�N����
		//�ٓ���񂪐ݒ肳��Ă��Ȃ��ꍇ
		if (ACTextUtilities.isNullText(map.get("201021"))) {
			//���K�͑��@�\�̏ꍇ
			if (isSyokiboTakinouYobou()){
				
				//�O��W�v���~�N�����擾
				Object _201022 = patient.getLastDataCategory2(String.valueOf(map.get("201001")), "201022");
				//�O��̒��~�N�������ݒ肳��Ă��Ȃ��ꍇ
				if (ACTextUtilities.isNullText(_201022)) {
					//�W�v�O�A�J�n�����ݒ肳��Ă��Ȃ��ꍇ
					//�O��W�v���ʂ���A�J�n�N������ݒ肷��
					Object _201021 = patient.getLastDataCategory2(String.valueOf(map.get("201001")), "201021");
					if (!ACTextUtilities.isNullText(_201021)) {
						map.put("201021", _201021);
					} else {
						//�W�v�O�̃f�[�^���ݒ�ł���΁A�ݒ肷��
						setSameBase(map,"201021");
					}
				}
			} else {
				//�W�v�O�̃f�[�^���ݒ�ł���΁A�ݒ肷��
				setSameBase(map,"201021");
			}
		}
		
		//���~�N����
		if (ACTextUtilities.isNullText(map.get("201022"))) {
			setSameBase(map,"201022");
		}
		
		//���~���R�R�[�h
		if (ACCastUtilities.toInt(map.get("201023"), 0) == 0) {
			setSameBase(map,"201023", NOT_ZERO);
		}
	}
	
	/**
	 * �l�����̓�(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect22details(VRMap map) throws Exception {
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - begin �T�[�r�X�R�[�h�p����
		/*
		switch(getServiceCode(map)) {
		//�Z���W�����n�r���e�[�V�������Z
		case 645001:
		//���K�͑��@�\�@���Ə��J�n�����Z
		case 756139:
		case 756140:
			setSameDetails(map);
			break;
		}
		*/
		//�W�v�ێ��@�\
		//�K�⃊�n�@�@�@645001:�Z���W�����n���Z
		//���K�͑��@�\�@756139:�p�~�@756140:�p�~
		String serviceCode = getServiceCode(map);
		if ("645001".equals(serviceCode)) {
			setSameDetails(map);
		}
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - end
	}
	
	/**
	 * �l����O(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect3base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����O(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect3details(VRMap map) throws Exception {
		//������
		setMultiRoom(map);
		
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/3/19 add - begin 
		//�W�v�ێ��@�\
		//�Z�������@�@�@216116:��ØA�g�������Z
		String serviceCode = getServiceCode(map);
		if ("216116".equals(serviceCode)) {
			setSameDetails(map);
		}
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/3/19 add - end
	}
	
	/**
	 * �l����O�̓�(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect32base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����O�̓�(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect32details(VRMap map) throws Exception {
		//������
		setMultiRoom(map);
	}
	
	/**
	 * �l����l(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect4base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����l(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect4diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l����l(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect4details(VRMap map) throws Exception {
		//������
		setMultiRoom(map);
		
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - begin �T�[�r�X�R�[�h�p����
		/*
		//[CCCX:1616,2096][Shinobu Hitaka] 2014/12/11 add begin�u22 6278�C22 6278�F�Z�������×{���i�V���j�̏d�x�×{�Ǘ����Z�P�C�Q�v��ǉ�
		switch(getServiceCode(map)) {
		case 226278:
		case 226279:
			setSameDetails(map);
			break;
		}
		//[CCCX:1616,2096][Shinobu Hitaka] 2014/12/11 add end  �u22 6278�C22 6278�F�Z�������×{���i�V���j�̏d�x�×{�Ǘ����Z�P�C�Q�v��ǉ�
		*/
		String serviceCode = getServiceCode(map);
		
		//�W�v�ێ��@�\
		//�Z�������×{���i�V���j�@226278:�d�x�×{�Ǘ����Z�P�@226279:�d�x�×{�Ǘ����Z�Q
		if ("226278".equals(serviceCode) || "226279".equals(serviceCode)) {
			setSameDetails(map);
		}
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - end

	}
	
	/**
	 * �l����l�̓�(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect42base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����l�̓�(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect42diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l����l�̓�(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect42details(VRMap map) throws Exception {
		//������
		setMultiRoom(map);
	}
	
	/**
	 * �l�����(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect5base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l�����(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect5diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l�����(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect5details(VRMap map) throws Exception {
		//������
		setMultiRoom(map);
	}
	
	/**
	 * �l����܂̓�(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect52base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����܂̓�(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect52diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l����܂̓�(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect52details(VRMap map) throws Exception {
		//������
		setMultiRoom(map);
	}
	
	/**
	 * �l����Z(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect6base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * �l����Z(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect6diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l����Z(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect6details(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����Z�̓�(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect62base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * �l����Z�̓�(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect62diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l����Z�̓�(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect62details(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����Z�̎O(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect63base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * �l����Z�̎O(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect63diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l����Z�̎O(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect63details(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����Z�̎l(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect64base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * �l����Z�̎l(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect64diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l����Z�̎l(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect64details(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����Z�̌�(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect65base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����Z�̌�(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect65diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l����Z�̌�(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect65details(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����Z�̘Z(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect66base(VRMap map) throws Exception {
		//nothing
	}
	
	/**
	 * �l����Z�̘Z(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect66diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l����Z�̘Z(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect66details(VRMap map) throws Exception {
		//nothing
	}

	   /**
     * �l����Z�̎�(��{���)�̌��ʔ��f����
     * @param map
     * @throws Exception
     */
    private void reflect67base(VRMap map) throws Exception {
        //nothing
    }
    
    /**
     * �l����Z�̎�(����f�Ô���)�̌��ʔ��f����
     * @param map
     * @throws Exception
     */
    private void reflect67diagnosis(VRMap map) throws Exception {
        setSameDiagnosis(map);
    }
    
    /**
     * �l����Z�̎�(���׏��)�̌��ʔ��f����
     * @param map
     * @throws Exception
     */
    private void reflect67details(VRMap map) throws Exception {
        //nothing
    }

	
	/**
	 * �l���攪(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect8base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * �l���攪(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect8diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l���攪(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect8details(VRMap map) throws Exception {
		//������
		setMultiRoom(map);
	}
	
	/**
	 * �l�����(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect9base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * �l�����(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect9diagnosis(VRMap map) throws Exception {
        setSameDiagnosis(map);
	}
	
	/**
	 * �l�����(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect9details(VRMap map) throws Exception {
		//������
		if (setMultiRoom(map)){
			return;
		}
		
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - begin �T�[�r�X�R�[�h�p����
		/*
		switch(getServiceCode(map)) {
		//�Z���W�����n�r���e�[�V�������{���Z
		case 526252:
		//�F�m�ǒZ���W�����n�r���e�[�V�������{���Z
		case 526253:
			setSameDetails(map);
			break;
		}
		*/
		String serviceCode = getServiceCode(map);
		
		//�W�v�ێ��@�\
		//�V���@526252:�Z���W�����n�r���e�[�V�������{���Z�@526253:�F�m�ǒZ���W�����n�r���e�[�V�������{���Z
		if ("526252".equals(serviceCode) || "526253".equals(serviceCode)) {
			setSameDetails(map);
		}
		// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - end
	}

	/**
	 * �l����\(��{���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect10base(VRMap map) throws Exception {
		reflectBaseCommon(map);
	}
	
	/**
	 * �l����\(����f�Ô���)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect10diagnosis(VRMap map) throws Exception {
		setSameDiagnosis(map);
	}
	
	/**
	 * �l����\(���׏��)�̌��ʔ��f����
	 * @param map
	 * @throws Exception
	 */
	private void reflect10details(VRMap map) throws Exception {
		setMultiRoom(map);
	}
	
	/**
	 * ��{��񃌃R�[�h�@�R�s�[����
	 * @param map
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private boolean setSameBase(VRMap map, String key) throws Exception {
		return setSameBase(map, key, NOT_EMPTY);
	}
	
	/**
	 * ��{��񔽉f���ʏ���
	 * @param map
	 * @throws Exception
	 */
	private void reflectBaseCommon(VRMap map) throws Exception {
		
		//���~���R�R�[�h
		if (ACCastUtilities.toInt(map.get("201023"), 0) == 0) {
			setSameBase(map,"201023", NOT_ZERO);
		}

		//�ޏ�(�@)��̏�ԃR�[�h
		if (ACCastUtilities.toInt(map.get("201028"), 0) == 0) {
			setSameBase(map,"201028", NOT_ZERO);
		}
	}
	
	
	/**
	 * ��{��񃌃R�[�h�@�R�s�[����
	 * @param map
	 * @param key
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	private boolean setSameBase(VRMap map, String key, int conditions) throws Exception {
		
		if (claim == null) {
			return false;
		}
		//�o�^���悤�Ƃ���l���󔒂ł���΁A�������s��Ȃ�			
		if (isValueExist(map, key, conditions)) {
			return false;
		}
		
		for (int i = 0; i < claim.size(); i++) {
			VRMap tmp = (VRMap)claim.get(i);
			
			if (!tmp.containsKey(key)){
				continue;
			}
			
			//201001 ������񎯕ʔԍ�4��
			if (!isEquals(map,tmp,"201001")) {
				continue;
			}
			//201002 ���R�[�h��ʃR�[�h2��(01��ݒ�)
			if (!isEquals(map,tmp,"201002")) {
				continue;
			}
			//201003 �T�[�r�X�񋟔N��6��(YYYYMM)
			if (!isEquals(map,tmp,"201003")) {
				continue;
			}
			//201004 ���Ə��ԍ�10��
			if (!isEquals(map,tmp,"201004")) {
				continue;
			}
			//201005 �؋L�ڕی��Ҕԍ�8��
			if (!isEquals(map,tmp,"201005")) {
				continue;
			}
			//201006 ��ی��Ҕԍ�10��
			if (!isEquals(map,tmp,"201006")) {
				continue;
			}
			
			//�o�^���悤�Ƃ���l���󔒂ł���΁A�������s��Ȃ�			
			if (isValueEmpty(tmp, key, conditions)) {
				return false;
			}
			
			map.put(key, tmp.get(key));
			return true;
		}
		return false;
	}
	
	/**
	 * �������ݒ菈��
	 * @param map
	 * @throws Exception
	 */
	private boolean setMultiRoom(VRMap map) throws Exception {
		ACSQLSafeDateFormat dateFormat = new ACSQLSafeDateFormat();
		
		String kind = ACCastUtilities.toString(map.get("301021"), "");
		String item = ACCastUtilities.toString(map.get("301022"), "");
		Date targetDate = ACCastUtilities.toDate(map.get("301003") + "01");
		
	    StringBuilder sb = new StringBuilder();

	    sb.append("SELECT");
	    sb.append(" CODE_ID");
	    sb.append(" FROM");
	    sb.append(" M_SERVICE_CODE");
	    sb.append(" WHERE");
	    sb.append("(");
	    sb.append(" SYSTEM_SERVICE_KIND_DETAIL");
	    sb.append(" =");
	    sb.append(ACSQLSafeStringFormat.getInstance().format(kind));
	    sb.append(")");
	    sb.append("AND");
	    sb.append("(");
	    sb.append(" SYSTEM_SERVICE_CODE_ITEM");
	    sb.append(" =");
	    sb.append(ACSQLSafeStringFormat.getInstance().format(item));
	    sb.append(")");
	    sb.append("AND");
	    sb.append("(");
	    sb.append(" SERVICE_VALID_START");
	    sb.append(" <=");
	    sb.append(dateFormat.format(targetDate, "yyyy-MM-dd"));
	    sb.append(")");
	    sb.append("AND");
	    sb.append("(");
	    sb.append(" SERVICE_VALID_END");
	    sb.append(" >=");
	    sb.append(dateFormat.format(targetDate, "yyyy-MM-dd"));
	    sb.append(")");
	    
	    VRList list = dbm.executeQuery(sb.toString());
		
		if ((list != null) && (list.size() > 0)){
			VRMap service = (VRMap)list.get(0);
			//�������T�[�r�X�̏ꍇ
			switch(ACCastUtilities.toInt(service.get("CODE_ID"), 0)){
			case 197:
			case 243:
				setSameDetails(map);
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * ����f�Ô�A���ʗ×{��R�[�h�@�R�s�[����
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private boolean setSameDiagnosis(VRMap map) throws Exception {
		//�ǉ��d�l�Ȃ̂ł����ŁE�E�E
		//���a����ޔ����Ă���
		setInvalidNameQueue(map);
		
        switch(ACCastUtilities.toInt(map.get("501009"),0)) {
        //�d�x�×{�Ǘ�
        case 35:
        //�Z���W�����n�r�����Z
        case 52:
        	return setSameDiagnosis(map, "501023");
        }
		//�E�v�����w��
		return false;
	}
	
	/**
	 * ����f�Ô�A���ʗ×{��R�[�h�@�R�s�[����
	 * @param map
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private boolean setSameDiagnosis(VRMap map, String key) throws Exception {
		return setSameDiagnosis(map, key, NOT_EMPTY);
	}
	

	private boolean setSameDiagnosis(VRMap map, String key, int conditions) throws Exception {
		
		if (claim == null) {
			return false;
		}
		
		//���Ɏ��яW�v�Ō��ʂ��o�^����Ă���ꍇ�́A�������s��Ȃ�
		/* �d�l�ύX�ɔ����A�����̎��яW�v���ʂ������I�ɔ��f����
		if (isValueExist(map, key, conditions)){
			return false;
		}
		*/
		
		for (int i = 0; i < claim.size(); i++) {
			VRMap tmp = (VRMap)claim.get(i);
			
			if (!tmp.containsKey(key)){
				continue;
			}
			
			//501001 ������񎯕ʔԍ�4��
			if (!isEquals(map,tmp,"501001")) {
				continue;
			}
			//501002 ���R�[�h��ʃR�[�h2��(04��ݒ�)
			if (!isEquals(map,tmp,"501002")) {
				continue;
			}
			//501003 �T�[�r�X�񋟔N��6��(YYYYMM)
			if (!isEquals(map,tmp,"501003")) {
				continue;
			}
			//501004 ���Ə��ԍ�10��
			if (!isEquals(map,tmp,"501004")) {
				continue;
			}
			//501005 �؋L�ڕی��Ҕԍ�8��
			if (!isEquals(map,tmp,"501005")) {
				continue;
			}
			//501006 ��ی��Ҕԍ�10��
			if (!isEquals(map,tmp,"501006")) {
				continue;
			}
			//501009 ���ʔԍ�2���@����f�Ô�̎��ʔԍ�
			if (!isEquals(map,tmp,"501009")) {
				continue;
			}
			//�o�^���悤�Ƃ���l���󔒂ł���΁A�������s��Ȃ�
			/* �d�l�ύX�ɔ����A�����̎��яW�v���ʂ������I�ɔ��f����
			if (isValueEmpty(tmp, key, conditions)) {
				return false;
			}
			*/
			
			//�W�v�O�̃f�[�^�𔽉f
			map.put(key, tmp.get(key));
			return true;
		}
		return false;

	}
	
	/**
	 * ���a���R�s�[����
	 * @param map
	 * @throws Exception
	 */
	private void setInvalidNameQueue(VRMap map) throws Exception {
		String num = ACCastUtilities.toString(map.get("501007"), "");
		
		if ("1".equals(num) || "99".equals(num)) {
			//���a���R�s�[�����̃L���[�ɓ����
			StringBuilder key = new StringBuilder();
			key.append(map.get("501001"));
			key.append(map.get("501002"));
			key.append(map.get("501003"));
			key.append(map.get("501004"));
			key.append(map.get("501005"));
			key.append(map.get("501006"));
			key.append("-");
			key.append(map.get("501007"));
			diagnosisQueue.put(key.toString(), map);
		}
	}
	
	/**
	 * ���a���R�s�[����
	 * @param map
	 * @throws Exception
	 */
	private void setInvalidName(VRMap map) throws Exception {
		
		if (claim == null) {
			return;
		}
		
		//���ɑO���̏��a�����ݒ肳��Ă���ꍇ�́A�O���f�[�^��D�悷��	
		/* �d�l�ύX�ɔ����A�����̎��яW�v���ʂ������I�ɔ��f����
		if (!isValueEmpty(map, "501008", NOT_EMPTY)) {
			return;
		}
		*/
		
		for (int i = 0; i < claim.size(); i++) {
			VRMap tmp = (VRMap)claim.get(i);
			
			if (!tmp.containsKey("501008")){
				continue;
			}
			
			String invalidName = ACCastUtilities.toString(tmp.get("501008"), "");
			if (ACTextUtilities.isNullText(invalidName)){
				continue;
			}
			
			//501001 ������񎯕ʔԍ�4��
			if (!isEquals(map,tmp,"501001")) {
				continue;
			}
			//501002 ���R�[�h��ʃR�[�h2��(02��ݒ�)
			if (!isEquals(map,tmp,"501002")) {
				continue;
			}
			//501003 �T�[�r�X�񋟔N��6��(YYYYMM)
			if (!isEquals(map,tmp,"501003")) {
				continue;
			}
			//501004 ���Ə��ԍ�10��
			if (!isEquals(map,tmp,"501004")) {
				continue;
			}
			//501005 �؋L�ڕی��Ҕԍ�8��
			if (!isEquals(map,tmp,"501005")) {
				continue;
			}
			//501006 ��ی��Ҕԍ�10��
			if (!isEquals(map,tmp,"501006")) {
				continue;
			}
			
			//�o�^���悤�Ƃ���l���󔒂ł���΁A�������s��Ȃ�
			/* �d�l�ύX�ɔ����A�����̎��яW�v���ʂ������I�ɔ��f����
			if (isValueEmpty(tmp, "501008", NOT_EMPTY)) {
				return;
			}
			*/
			
			map.put("501008", invalidName);
			
			break;
		}
	}
	
	
	/**
	 * ���׏�񃌃R�[�h�@�R�s�[����
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private boolean setSameDetails(VRMap map) throws Exception {
		//�E�v�����w��
		return setSameDetails(map, "301018");
	}
	
	/**
	 * ���׏�񃌃R�[�h�@�R�s�[����
	 * @param map
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private boolean setSameDetails(VRMap map, String key) throws Exception {
		return setSameDetails(map, key, NOT_EMPTY);
	}
	
	/**
	 * ���׏�񃌃R�[�h�@�R�s�[����
	 * @param map
	 * @param key
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	private boolean setSameDetails(VRMap map, String key, int conditions) throws Exception {
		
		if (claim == null) {
			return false;
		}
		
		/* �d�l�ύX�ɔ����A�����I�ɑO��W�v�̒l���̗p
		if (isValueExist(map, key, conditions)){
			return false;
		}
		*/
		
		for (int i = 0; i < claim.size(); i++) {
			VRMap tmp = (VRMap)claim.get(i);
			
			if (!tmp.containsKey(key)){
				continue;
			}
			
			//301001 ������񎯕ʔԍ�4��
			if (!isEquals(map,tmp,"301001")) {
				continue;
			}
			//301002 ���R�[�h��ʃR�[�h2��(02��ݒ�)
			if (!isEquals(map,tmp,"301002")) {
				continue;
			}
			//301003 �T�[�r�X�񋟔N��6��(YYYYMM)
			if (!isEquals(map,tmp,"301003")) {
				continue;
			}
			//301004 ���Ə��ԍ�10��
			if (!isEquals(map,tmp,"301004")) {
				continue;
			}
			//301005 �؋L�ڕی��Ҕԍ�8��
			if (!isEquals(map,tmp,"301005")) {
				continue;
			}
			//301006 ��ی��Ҕԍ�10��
			if (!isEquals(map,tmp,"301006")) {
				continue;
			}
			//301007 �T�[�r�X��ރR�[�h2��
			if (!isEquals(map,tmp,"301007")) {
				continue;
			}
			//301008 �T�[�r�X���ڃR�[�h4��
			if (!isEquals(map,tmp,"301008")) {
				continue;
			}
			//�o�^���悤�Ƃ���l���󔒂ł���΁A�������s��Ȃ�
			/* �d�l�ύX�ɔ����A�����I�ɑO��W�v�̒l���̗p
			if (isValueEmpty(tmp, key, conditions)) {
				return false;
			}
			*/
			
			//�W�v�O�̃f�[�^�𔽉f
			map.put(key, tmp.get(key));
			return true;
		}
		return false;
	}
	
	private boolean isEquals(VRMap map, VRMap tmp, String key) throws Exception {
		return isEquals(map, tmp, key, key);
	}
	
	private boolean isEquals(VRMap map, VRMap tmp, String mapkey, String tmpkey) throws Exception {
		if (!map.containsKey(mapkey)){
			return false;
		}
		if (!tmp.containsKey(tmpkey)){
			return false;
		}
		return map.get(mapkey).equals(tmp.get(tmpkey));
	}
	
	/**
	 * ���K�͑��@�\�̏W�v��񃌃R�[�h������
	 * @param map
	 * @return
	 * @throws Exception
	 */
	private boolean isSyokiboTakinou() throws Exception {
	    //[ID:0000722][Shin Fujihara] 2012/04 edit begin 2012�N�x�Ή�
//		return (serviceKindListLastMonth.contains("73")
//				&& serviceKindListThisMonth.contains("73"));
        
	    //���K�͑��@�\��
	    if (serviceKindListLastMonth.contains("73")
                && serviceKindListThisMonth.contains("73")) {
	        return true;
	    }
	    
	    //�����^��
        if (serviceKindListLastMonth.contains("77")
                && serviceKindListThisMonth.contains("77")) {
            return true;
        }
	    
	    return false;
		//[ID:0000722][Shin Fujihara] 2012/04 edit end 2012�N�x�Ή�
	}
	/**
	 * �\�h���K�͑��@�\�̏W�v��񃌃R�[�h������
	 * @return
	 * @throws Exception
	 */
	private boolean isSyokiboTakinouYobou() throws Exception {
		return (serviceKindListLastMonth.contains("75")
				&& serviceKindListThisMonth.contains("75"));
	}
	
	// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - begin 
	/* �T�[�r�X�R�[�h�p�����ɔ����A�Ԃ�l�𐔒l���當����֕ύX
	private int getServiceCode(VRMap map) throws Exception {
		int code = 0;
		
		//�T�[�r�X��ރR�[�h
		if (!map.containsKey("301007")) {
			return code;
		}
		//�T�[�r�X���ڃR�[�h
		if (!map.containsKey("301008")) {
			return code;
		}
		
		return ACCastUtilities.toInt(String.valueOf(map.get("301007")) + String.valueOf(map.get("301008")), 0);
	}
	*/
	private String getServiceCode(VRMap map) throws Exception {
		String code = "";
		
		//�T�[�r�X��ރR�[�h
		if (!map.containsKey("301007")) {
			return code;
		}
		//�T�[�r�X���ڃR�[�h
		if (!map.containsKey("301008")) {
			return code;
		}
		
		return String.valueOf(map.get("301007")) + String.valueOf(map.get("301008"));
	}
	// [H27.4�����Ή�][Shinobu Hitaka] 2015/1/20 edit - end
	
	private boolean isValueExist(VRMap map, String key, int conditions) {
		//�󔒈ȊO�`�F�b�N
		if ((conditions & NOT_EMPTY) == NOT_EMPTY) {
			//�W�v��A�󔒈ȊO���ݒ肳��Ă�����A�������s��Ȃ�
			if (!ACTextUtilities.isNullText(map.get(key))){
				return true;
			}
		}
		//�[���ȊO
		if ((conditions & NOT_ZERO) == NOT_ZERO) {
			//�W�v��A0�ȊO���ݒ肳��Ă�����A�������s��Ȃ�
			if (ACCastUtilities.toInt(map.get(key), 0) != 0) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isValueEmpty(VRMap map, String key, int conditions) {
		//�󔒈ȊO�`�F�b�N
		if ((conditions & NOT_EMPTY) == NOT_EMPTY) {
			if (ACTextUtilities.isNullText(map.get(key))){
				return true;
			}
		}
		//�[���ȊO
		if ((conditions & NOT_ZERO) == NOT_ZERO) {
			//�W�v��A0�ȊO���ݒ肳��Ă�����A�������s��Ȃ�
			if (ACCastUtilities.toInt(map.get(key), 0) == 0) {
				return true;
			}
		}
		return false;
	}
	
	private String[] getStyleCode(VRMap map) throws Exception {
		String header = "235";
		String[] style = new String[]{null, null};
		
		for (int i = 0; i < header.length(); i++) {
			String key = header.charAt(i) + "01001";
			if (map.containsKey(key)) {
				style[0] = ACCastUtilities.toString(map.get(key), null);
				style[1] = String.valueOf(header.charAt(i));
				break;
			}
		}
		
		return style;
	}

	public void reflectStyle(VRMap map) throws Exception {
		String[] style = getStyleCode(map);
		
		if (style[0] == null) {
			return;
		}
		
		if (QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(style[0])) {
			if ("2".equals(style[1])){
				reflect2base(map);
			} else if ("3".equals(style[1])){
				reflect2details(map);
				reflectDetails(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect22base(map);
			} else if ("3".equals(style[1])){
				reflect22details(map);
				reflectDetails(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect3base(map);
			} else if ("3".equals(style[1])){
				reflect3details(map);
				reflectDetails(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect32base(map);
			} else if ("3".equals(style[1])){
				reflect32details(map);
				reflectDetails(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect4base(map);
			} else if ("3".equals(style[1])){
				reflect4details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect4diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect42base(map);
			} else if ("3".equals(style[1])){
				reflect42details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect42diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect5base(map);
			} else if ("3".equals(style[1])){
				reflect5details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect5diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect52base(map);
			} else if ("3".equals(style[1])){
				reflect52details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect52diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect6base(map);
			} else if ("3".equals(style[1])){
				reflect6details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect6diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect62base(map);
			} else if ("3".equals(style[1])){
				reflect62details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect62diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect63base(map);
			} else if ("3".equals(style[1])){
				reflect63details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect63diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect64base(map);
			} else if ("3".equals(style[1])){
				reflect64details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect64diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect65base(map);
			} else if ("3".equals(style[1])){
				reflect65details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect65diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect66base(map);
			} else if ("3".equals(style[1])){
				reflect66details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect66diagnosis(map);
			}
        } else if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(style[0])){
            if ("2".equals(style[1])){
                reflect67base(map);
            } else if ("3".equals(style[1])){
                reflect67details(map);
                reflectDetails(map);
            } else if ("5".equals(style[1])){
                reflect67diagnosis(map);
            }
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect8base(map);
			} else if ("3".equals(style[1])){
				reflect8details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect8diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect9base(map);
			} else if ("3".equals(style[1])){
				reflect9details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect9diagnosis(map);
			}
		} else if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(style[0])){
			if ("2".equals(style[1])){
				reflect10base(map);
			} else if ("3".equals(style[1])){
				reflect10details(map);
				reflectDetails(map);
			} else if ("5".equals(style[1])){
				reflect10diagnosis(map);
			}
		}
	}
	
}
