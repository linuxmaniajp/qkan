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
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jp.nichicom.ac.lang.ACCastUtilities;

/**
 * %�����A%���Z�̑ΏےP�ʐ���ێ�����N���X�i����Ή��j
 * 
 * @author Yoichiro Kamei
 *
 */
public class QP001PercentageAddInfo {
	
	public static final String PARCENTAGE_ADD_TARGET_KEY_3 = "PARCENTAGE_ADD_TARGET_3";
	public static final String PARCENTAGE_ADD_TARGET_KEY_3_UNIT = "PARCENTAGE_ADD_TARGET_3_UNIT";
	public static final String PARCENTAGE_ADD_TARGET_KEY_6 = "PARCENTAGE_ADD_TARGET_6";
	public static final String PARCENTAGE_ADD_TARGET_KEY_6_UNIT = "PARCENTAGE_ADD_TARGET_6_UNIT";
	public static final String PARCENTAGE_ADD_TARGET_KEY_5 = "PARCENTAGE_ADD_TARGET_5";
	public static final String PARCENTAGE_ADD_TARGET_KEY_5_UNIT = "PARCENTAGE_ADD_TARGET_5_UNIT";
	public static final String PARCENTAGE_ADD_TARGET_KEY_7 = "PARCENTAGE_ADD_TARGET_7";
	public static final String PARCENTAGE_ADD_TARGET_KEY_7_UNIT = "PARCENTAGE_ADD_TARGET_7_UNIT";
	public static final String PARCENTAGE_ADD_TARGET_KEY_8 = "PARCENTAGE_ADD_TARGET_8";

	// ���Z�̑ΏۂƂȂ��{�T�[�r�X�̒P�ʐ�
	private int kihonUnit = 0;

	// �����Z�̃T�[�r�X�R�[�h���L�[�ɉ��Z�̑ΏۂƂȂ��{�T�[�r�X�̉񐔂�ێ�
	// <���Z�̃T�[�r�X�R�[�h, ��{�T�[�r�X�̉�>
	private Map<String, Integer> kihonCountMap = new HashMap<String, Integer>();

	// �ΏۂƂȂ道���Z�̃T�[�r�X�R�[�h���L�[��<QP001KohiKey, ��>��ێ�����}�b�v
	private Map<String, Map<QP001KohiKey, Integer>> kohiCountMap = new HashMap<String, Map<QP001KohiKey, Integer>>();

	//�Z��̍ۂɌv�Z�Ɋ܂߂�֘A���Z�̏��
	// <���Z�̃T�[�r�X�R�[�h, <���Z�t���O, <���Z��, ��{�T�[�r�X�̉�>>>
	private Map<String, Map<Integer, Map<Integer, Integer>>> relationMap 
		= new HashMap<String, Map<Integer, Map<Integer, Integer>>>();
	
	//�Z��̍ۂɌv�Z�Ɋ܂߂�֘A���Z�̏��i����j
	// <���Z�̃T�[�r�X�R�[�h, <KohiKey, <���Z�t���O, <���Z��, ��{�T�[�r�X�̉�>>>>
	private Map<String, Map<QP001KohiKey, Map<Integer, Map<Integer, Integer>>>> relationKohiMap 
		= new HashMap<String, Map<QP001KohiKey, Map<Integer, Map<Integer, Integer>>>>();
	
	public static Integer SERVICE_ADD_FLAG_KYOUSEI = new Integer(5);
	public static Integer SERVICE_ADD_FLAG_SAME_BUILDING = new Integer(7);
	public static Integer SERVICE_ADD_FLAG_TOKUCHI = new Integer(3);
	public static Integer SERVICE_ADD_FLAG_CHUSAN = new Integer(6);
	
	/**
	 * �R���X�g���N�^�B
	 * 
	 * @param kihonUnit
	 *            ���Z�̑ΏۂƂȂ��{�T�[�r�X�̒P�ʐ�
	 */
	public QP001PercentageAddInfo(int kihonUnit) {
		this.kihonUnit = kihonUnit;
	}
	
	/**
	 * ���̃N���X���ێ�������Z���̃T�[�r�X�R�[�h�Z�b�g��Ԃ��܂��B
	 * 
	 * @return ���̃N���X���ێ�������Z���̃T�[�r�X�R�[�h�Z�b�g
	 */
	public Set<String> getHoldSvCodeSet() {
		return kihonCountMap.keySet();
	}
	
	
	//%���Z�̃T�[�r�X�R�[�h��KEY�ɉ��Z����l�ɕێ�����}�b�v
	private Map<String, Integer> perMap = new HashMap<String, Integer>();
	//%���Z�̃T�[�r�X�R�[�h��KEY�ɉ��Z�t���O��l�ɕێ�����}�b�v
	private Map<String, Integer> addFlgMap = new HashMap<String, Integer>();
	
	/**
	 * �w�肵���T�[�r�X�R�[�h����͂��ĉ��Z��񓙂�ێ����܂��B
	 * 
	 * @param serviceCode
	 *            �T�[�r�X�R�[�h���
	 * 
	 * @return �����Z�̃T�[�r�X���ڃR�[�h�Z�b�g
	 */
	public void parseService(Map serviceCode) {
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
			int per = ACCastUtilities.toInt(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3_UNIT), 0);
			addFlgMap.put(svCode, SERVICE_ADD_FLAG_TOKUCHI);
			perMap.put(svCode, per);
		}
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6), "");
			int per = ACCastUtilities.toInt(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6_UNIT), 0);
			addFlgMap.put(svCode, SERVICE_ADD_FLAG_CHUSAN);
			perMap.put(svCode, per);
		}
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
			int per = ACCastUtilities.toInt(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5_UNIT), 0);
			addFlgMap.put(svCode, SERVICE_ADD_FLAG_KYOUSEI);
			perMap.put(svCode, per);
		}
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
			int per = ACCastUtilities.toInt(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7_UNIT), 0);
			addFlgMap.put(svCode, SERVICE_ADD_FLAG_SAME_BUILDING);
			perMap.put(svCode, per);
		}
	}
//	/**
//	 * �w�肵���T�[�r�X�R�[�h��聓���Z�̃T�[�r�X�R�[�h�Z�b�g�𐶐����܂��B
//	 * 
//	 * @param serviceCode
//	 *            �T�[�r�X�R�[�h���
//	 * 
//	 * @return �����Z�̃T�[�r�X���ڃR�[�h�Z�b�g
//	 */
//	public Set<String> createPercentageAddCodeSet(Map serviceCode) {		
//		Set<String> ret = new HashSet<String>();
//		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
//			ret.add((String) serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3));
//		}
//		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
//			ret.add((String) serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6));
//		}
//		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
//			ret.add((String) serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5));
//		}
//		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
//			ret.add((String) serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7));
//		}
//		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_8)) {
//			ret.add((String) serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_8));
//		}
//		return ret;
//	}
	
	/**
	 * �w�肵���T�[�r�X�R�[�h�ɂ��āA�����Z�̊�{�T�[�r�X�̉񐔂�ǉ����܂��B
	 * 
	 * @param percentageAddCodeSet
	 *            �����Z�̃T�[�r�X�R�[�h�Z�b�g
	 * @param count
	 *            ��
	 */
	public void addKihonCount(Map serviceCode, int count) {
		//�����^���Z
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
			addKihonCountMap(svCode, count);
		}
		//���ꌚ�����Z
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
			addKihonCountMap(svCode, count);
			
			//�֘A���Z�̉񐔒ǉ�
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationMap(svCode, count, relateSvCode);
			}
		}
		//���n���Z
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
			addKihonCountMap(svCode, count);
			
			//�֘A���Z�̉񐔒ǉ�
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationMap(svCode, count, relateSvCode);
			}
		}
		//���R�Ԓn�擙�񋟉��Z
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6), "");
			addKihonCountMap(svCode, count);
			
			//�֘A���Z�̉񐔒ǉ�
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
				addRelationMap(svCode, count, relateSvCode);
			}
		}
		//�������P���Z
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_8)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_8), "");
			addKihonCountMap(svCode, count);
			
			//�֘A���Z�̉񐔒ǉ�
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
				addRelationMap(svCode, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6), "");
				addRelationMap(svCode, count, relateSvCode);
			}
		}
	}
	//�w�肳�ꂽ%���Z�T�[�r�X�R�[�h���Ċ�{�T�[�r�X�̉񐔂�ǉ����܂��B
	private void addKihonCountMap(String svCode, int count) {
		int nowCount = ACCastUtilities.toInt(kihonCountMap.get(svCode), 0);
		kihonCountMap.put(svCode, nowCount + count);
	}
	
	//�w�肳�ꂽ%���Z�T�[�r�X�R�[�h�Ɋ֘A����%���Z�R�[�h�ɂ��āA��{�T�[�r�X�̉񐔂�ǉ����܂��B
	private void addRelationMap(String svCode, int count, String relateSvCode) {
		if (!relationMap.containsKey(svCode)) {
			relationMap.put(svCode, new HashMap<Integer, Map<Integer, Integer>>());
		}
		Map<Integer, Map<Integer, Integer>> flMap = relationMap.get(svCode);
		addFlgMapCount(flMap, relateSvCode, count);
	}
	
	//�w�肳�ꂽ�֘A%���Z�R�[�h�ɂ��āAflMap<���Z�t���O, <���Z��, ��{�T�[�r�X�̉�>>�̉񐔂�ǉ����܂��B
	private void addFlgMapCount(Map<Integer, Map<Integer, Integer>> flMap,
			String relateSvCode, int count ) {
		//�֘A���Z�R�[�h�̉��Z�t���O�Ɖ��Z�����擾
		int addFlg = addFlgMap.get(relateSvCode);
		int per = perMap.get(relateSvCode);
		
		if (!flMap.containsKey(addFlg)) {
			flMap.put(addFlg, new HashMap<Integer, Integer>());
		}
		Map<Integer, Integer> prMap = flMap.get(addFlg);
		int nowCount = ACCastUtilities.toInt(prMap.get(per), 0);
		prMap.put(per, nowCount + count);
	}
	
	
	/**
	 * �w�肵���T�[�r�X�R�[�h�ɂ��āA�w�肵��KohiKey�̉񐔂�ǉ����܂��B
	 * 
	 * @param serviceCode
	 *            �T�[�r�X�R�[�h
	 * @param kohiKey
	 *            KohiKey
	 * @param count
	 *            ��
	 */
	public void addKohiCount(Map serviceCode, QP001KohiKey kohiKey, int count) {
		//�����^���Z
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
			addKohiCountMap(svCode, kohiKey, count);
		}
		//���ꌚ�����Z
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
			addKohiCountMap(svCode, kohiKey, count);
			
			//�֘A���Z�̉񐔒ǉ�
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
		}
		//���n���Z
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
			addKohiCountMap(svCode, kohiKey, count);
			
			//�֘A���Z�̉񐔒ǉ�
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
		}
		//���R�Ԓn�擙�񋟉��Z
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6), "");
			addKohiCountMap(svCode, kohiKey, count);
			
			//�֘A���Z�̉񐔒ǉ�
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
		}
		//�������P���Z
		if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_8)) {
			String svCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_8), "");
			addKohiCountMap(svCode, kohiKey, count);
			
			//�֘A���Z�̉񐔒ǉ�
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_5)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_5), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_7)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_7), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_3)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_3), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
			if (serviceCode.containsKey(PARCENTAGE_ADD_TARGET_KEY_6)) {
				String relateSvCode = ACCastUtilities.toString(serviceCode.get(PARCENTAGE_ADD_TARGET_KEY_6), "");
				addRelationKohiMap(svCode, kohiKey, count, relateSvCode);
			}
		}
	}
	
	//�w�肵��%���Z�T�[�r�X�R�[�h�AKohiKey���āA��{�T�[�r�X�̉񐔂�ǉ����܂��B
	private void addKohiCountMap(String svCode, QP001KohiKey kohiKey, int count) {
		if (!kohiCountMap.containsKey(svCode)) {
			kohiCountMap.put(svCode, new HashMap<QP001KohiKey, Integer>());
		}
		Map<QP001KohiKey, Integer> kohiCountKeyMap = kohiCountMap.get(svCode);
		int nowCount = ACCastUtilities.toInt(kohiCountKeyMap.get(kohiKey), 0);
		kohiCountKeyMap.put(kohiKey, nowCount + count);
	}
	
	//�w�肳�ꂽ%���Z�T�[�r�X�R�[�h�Ɋ֘A����%���Z�R�[�h�AKohiKey�ɂ��āA��{�T�[�r�X�̉񐔂�ǉ����܂��B
	private void addRelationKohiMap(String svCode, QP001KohiKey kohiKey, int count, String relateSvCode) {
		if (!relationKohiMap.containsKey(svCode)) {
			relationKohiMap.put(svCode, new HashMap<QP001KohiKey, Map<Integer, Map<Integer, Integer>>>());
		}
		Map<QP001KohiKey, Map<Integer,Map<Integer,Integer>>> rKohiMap = relationKohiMap.get(svCode);
		if (!rKohiMap.containsKey(kohiKey)) {
			rKohiMap.put(kohiKey, new HashMap<Integer, Map<Integer, Integer>>());
		}
		Map<Integer, Map<Integer, Integer>> flMap = rKohiMap.get(kohiKey);
		addFlgMapCount(flMap, relateSvCode, count);
	}
	
	/**
	 * �w�肵�������Z�̃T�[�r�X�R�[�h���ΏۂƂ����{�T�[�r�X�̒P�ʐ����擾���܂��B
	 * 
	 * @param svCode
	 *            �����Z�̃T�[�r�X�R�[�h
	 * @return �w�肵�������Z�̃T�[�r�X�R�[�h���ΏۂƂ����{�T�[�r�X�̒P�ʐ�
	 */
	public int getKasanBaseUnit(String svCode) {
		int count = ACCastUtilities.toInt(kihonCountMap.get(svCode), 0);
		return count * kihonUnit;
	}

	/**
	 * �w�肵�������Z�̃T�[�r�X�R�[�h�AKohiKey���ΏۂƂ����{�T�[�r�X�̌���ΏےP�ʐ����擾���܂��B
	 * 
	 * @param svCode
	 *            �����Z�̃T�[�r�X�R�[�h
	 * @param kohiKey
	 *            QP001KohiKey
	 * 
	 * @return �w�肵�������Z�̃T�[�r�X���ڃR�[�h�AKohiKey���ΏۂƂ����{�T�[�r�X�̌���ΏےP�ʐ�
	 */
	public int getKasanBaseKohiUnit(String svCode, QP001KohiKey kohiKey) {
		Map<QP001KohiKey, Integer> kohiCountKeyMap = kohiCountMap.get(svCode);
		int count = ACCastUtilities.toInt(kohiCountKeyMap.get(kohiKey), 0);
		return count * kihonUnit;
	}
	
	
	
	//�֘A���Z��
	/**
	 * �w�肵�������Z�̃T�[�r�X�R�[�h�A�֘A���Z�t���O���ΏۂƂ�����Z���Ɗ�{�T�[�r�X�̑ΏےP�ʐ����擾���܂��B
	 * 
	 * @param svCode
	 *            �����Z�̃T�[�r�X�R�[�h
	 * @param addFlg
	 *            �T�[�r�X���Z�t���O
	 * 
	 * @return ���Z���Ɗ�{�T�[�r�X�̑ΏےP�ʐ��̃}�b�v
	 */
	public Map<Integer, Integer> getRelateAddUnit(String svCode, int addFlg) {
		Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
		if (!relationMap.containsKey(svCode)) {
			return ret;
		}
		Map<Integer, Map<Integer, Integer>> flMap = relationMap.get(svCode);
		if (!flMap.containsKey(addFlg)) {
			return ret;
		}
		Map<Integer, Integer> prMap = flMap.get(addFlg);
		for (int per : prMap.keySet()) {
			int count = ACCastUtilities.toInt(prMap.get(per), 0);
			//�񐔁~�P�ʐ��őΏےP�ʐ����Z�b�g
			ret.put(per, count * kihonUnit);
		}
		return ret;
	}

	/**
	 * �w�肵��KohiKey�A�����Z�̃T�[�r�X�R�[�h�A�֘A���Z�t���O���ΏۂƂ�����Z���Ɗ�{�T�[�r�X�̑ΏےP�ʐ����擾���܂��B
	 * 
	 * @param kohiKey QP001KohiKey
	 * 
	 * @param svCode
	 *            �����Z�̃T�[�r�X�R�[�h
	 * @param addFlg
	 *            �T�[�r�X���Z�t���O
	 * 
	 * @return ���Z���Ɗ�{�T�[�r�X�̑ΏےP�ʐ��̃}�b�v
	 */
	public Map<Integer, Integer> getRelateAddKohiUnit(QP001KohiKey kohiKey, String svCode, int addFlg) {
		Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
		if (!relationKohiMap.containsKey(svCode)) {
			return ret;
		}
		Map<QP001KohiKey, Map<Integer,Map<Integer,Integer>>> rKohiMap = relationKohiMap.get(svCode);
		if (!rKohiMap.containsKey(kohiKey)) {
			return ret;
		}
		Map<Integer, Map<Integer, Integer>> flMap = rKohiMap.get(kohiKey);
		if (!flMap.containsKey(addFlg)) {
			return ret;
		}
		Map<Integer, Integer> prMap = flMap.get(addFlg);
		for (int per : prMap.keySet()) {
			int count = ACCastUtilities.toInt(prMap.get(per), 0);
			//�񐔁~�P�ʐ��őΏےP�ʐ����Z�b�g
			ret.put(per, count * kihonUnit);
		}
		return ret;
	}

}
