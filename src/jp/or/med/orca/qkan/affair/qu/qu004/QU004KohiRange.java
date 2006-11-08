/*
 * �쐬��: 2006/05/10
 *
 * TODO ���̐������ꂽ�t�@�C���̃e���v���[�g��ύX����ɂ͎��փW�����v:
 * �E�B���h�E - �ݒ� - Java - �R�[�h�E�X�^�C�� - �R�[�h�E�e���v���[�g
 */
package jp.or.med.orca.qkan.affair.qu.qu004;

import java.util.ArrayList;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * �����L�����ԑ���A�`�F�b�N�N���X
 */
public class QU004KohiRange {

	public final static int RESULT_OK = 0;

	public final static int RESULT_COUNT_OVER = 1;

	public final static int RESULT_SPLIT = 2;

	public final static int RESULT_KOHI_SPLIT = 3;

	public final static int RESULT_KOHI_IS_INCLUDED = 4;

	// �J�n�A�I��
	private Date begin;

	private Date end;

	// �d������
	private int count = 1;

	// �d���������錏��
	private int maxCount = 0;

	// ����ID
	private ArrayList kohiIdList = new ArrayList();

	public void QU004KohiRange() {
		this.begin = new Date();
		this.end = new Date();
		this.count = 1;
		this.maxCount = 0;
		this.kohiIdList = new ArrayList();
	}

	public void QU004KohiRange(int maxCount) {
		this.begin = new Date();
		this.end = new Date();
		this.count = 1;
		this.maxCount = maxCount;
		this.kohiIdList = new ArrayList();
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getBegin() {
		return this.begin;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getEnd() {
		return this.end;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return this.count;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getMaxCount() {
		return this.maxCount;
	}

	public void setKohiIdList(ArrayList kohiIdList) {
		this.kohiIdList = kohiIdList;
	}

	public ArrayList getKohiIdList() {
		return this.kohiIdList;
	}

	/**
	 * �d���̌������J�E���g���A�ő勖�����𒴂����ꍇfalse��Ԃ��B
	 */
	public boolean check(ArrayList rangeList, ArrayList list) throws Exception {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			VRMap row = (VRMap) list.get(i);
			switch (check(rangeList, list, row)) {
			case RESULT_COUNT_OVER:
				return false;
			case RESULT_KOHI_IS_INCLUDED:
				list.remove(i);
				i--;
				size--;
				break;
			case RESULT_KOHI_SPLIT:
			case RESULT_OK:
			case RESULT_SPLIT:
				break;
			}
		}
		return true;
	}

	/**
	 * �d���̌������J�E���g���A�ő勖�����𒴂����ꍇfalse��Ԃ��B
	 */
	public int check(ArrayList rangeList, ArrayList list, VRMap row)
			throws Exception {

		// ����̏���ޔ�
		int kohiId = ACCastUtilities
				.toInt(VRBindPathParser.get("KOHI_ID", row));
		Date kohiBegin = ACCastUtilities.toDate(VRBindPathParser.get(
				"KOHI_VALID_START", row));
		Date kohiEnd = ACCastUtilities.toDate(VRBindPathParser.get(
				"KOHI_VALID_END", row));

		int result = RESULT_OK;
		int duplicateStyle = ACDateUtilities.getDuplicateTermCheck(begin, end,
				kohiBegin, kohiEnd);
		QU004KohiRange newRange;

		switch (duplicateStyle) {
		case ACDateUtilities.DUPLICATE_NONE:
			// �d���Ȃ�
			break;
		case ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN:
		case ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN_ON_ONE_DAY:
			// ��������
			// �d�����Ȃ���������
			newRange = new QU004KohiRange();
			newRange.begin = (Date) this.begin.clone();
			newRange.end = ACDateUtilities.addDay(kohiBegin, -1);
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// �d����������
			this.begin = kohiBegin;
			this.count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// ��r���̌�����̗L�����Ԃ𑀍�
			VRBindPathParser.set("KOHI_VALID_START", row, ACDateUtilities
					.addDay(this.end, 1));
			break;
		case ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_END:
			// ��������
			// �d�����Ȃ���������
			newRange = new QU004KohiRange();
			newRange.begin = (Date) this.begin.clone();
			newRange.end = ACDateUtilities.addDay(kohiBegin, -1);
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// �d����������
			this.begin = kohiBegin;
			this.count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// ��r���̌�����͍폜����K�v������
			result = RESULT_KOHI_IS_INCLUDED;
			break;
		case ACDateUtilities.DUPLICATE_FIRST_BEGIN_AND_SECOND_END:
		case ACDateUtilities.DUPLICATE_FIRST_BEGIN_AND_SECOND_END_ON_ONE_DAY:
			// ��������
			// �d�����Ȃ���������
			newRange = new QU004KohiRange();
			newRange.begin = ACDateUtilities.addDay(kohiEnd, 1);
			newRange.end = (Date) this.end.clone();
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// �d����������
			this.end = kohiEnd;
			this.count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// ��r���̌�����̗L�����Ԃ𑀍�
			VRBindPathParser.set("KOHI_VALID_END", row, ACDateUtilities.addDay(
					this.begin, -1));
			break;
		case ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_BEGIN:
			// ��������
			// �d�����Ȃ���������
			newRange = new QU004KohiRange();
			newRange.begin = ACDateUtilities.addDay(kohiEnd, 1);
			newRange.end = (Date) this.end.clone();
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// �d����������
			this.end = kohiEnd;
			this.count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// ��r���̌�����͍폜����K�v������
			result = RESULT_KOHI_IS_INCLUDED;
			break;
		case ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND:
			// ��������
			// �d�����Ȃ���������1
			newRange = new QU004KohiRange();
			newRange.begin = (Date) this.begin.clone();
			newRange.end = ACDateUtilities.addDay(kohiBegin, -1);
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// �d�����Ȃ���������2
			newRange = new QU004KohiRange();
			newRange.begin = ACDateUtilities.addDay(kohiEnd, 1);
			newRange.end = (Date) this.end.clone();
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// �d����������
			this.begin = kohiBegin;
			this.end = kohiEnd;
			this.count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// ��r���̌�����͍폜����K�v������
			result = RESULT_KOHI_IS_INCLUDED;
			break;
		case ACDateUtilities.DUPLICATE_FIRST_EQUALS_SECOND:
			// ���������͔������Ȃ�
			count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// ��r���̌�����͍폜����K�v������
			result = RESULT_KOHI_IS_INCLUDED;
			break;
		case ACDateUtilities.DUPLICATE_SECOND_INCLUDE_FIRST:
			// ���������͔������Ȃ�
			count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// ��r����������B
			VRMap temp = new VRHashMap();
			for (int i = 0; i < list.size(); i++) {
				VRMap map = (VRMap) list.get(i);
				int mapKohiId = ACCastUtilities.toInt(VRBindPathParser.get(
						"KOHI_ID", map));
				int rowKohiId = ACCastUtilities.toInt(VRBindPathParser.get(
						"KOHI_ID", row));
				if (mapKohiId == rowKohiId) {
					temp = (VRMap) map.clone();
				}
			}
			Date tempBegin = ACDateUtilities.addDay(this.end, 1);
			VRBindPathParser.set("KOHI_VALID_START", temp, tempBegin);
			list.add(temp);
			// ��r���̌�����̗L�����Ԃ𑀍�
			VRBindPathParser.set("KOHI_VALID_END", row, ACDateUtilities.addDay(
					this.begin, -1));
			result = RESULT_KOHI_SPLIT;
			break;
		case ACDateUtilities.DUPLICATE_SECOND_INCLUDE_FIRST_EQUALS_BOTH_END:
			// ���������͔������Ȃ�
			count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// ��r���̌�����̗L�����Ԃ𑀍�
			VRBindPathParser.set("KOHI_VALID_END", row, ACDateUtilities.addDay(
					this.begin, -1));
			break;
		case ACDateUtilities.DUPLICATE_SECOND_INCLUDE_FIRST_EQUALS_BOTH_BEGIN:
			// ���������͔������Ȃ�
			count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// ��r���̌�����̗L�����Ԃ𑀍�
			VRBindPathParser.set("KOHI_VALID_START", row, ACDateUtilities
					.addDay(this.end, 1));
			break;
		}

		if (count > maxCount) {
			return RESULT_COUNT_OVER;
		} else {
			return result;
		}
	}
}
