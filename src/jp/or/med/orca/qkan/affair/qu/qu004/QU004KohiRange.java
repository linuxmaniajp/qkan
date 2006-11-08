/*
 * 作成日: 2006/05/10
 *
 * TODO この生成されたファイルのテンプレートを変更するには次へジャンプ:
 * ウィンドウ - 設定 - Java - コード・スタイル - コード・テンプレート
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
 * 公費履歴有効期間操作、チェッククラス
 */
public class QU004KohiRange {

	public final static int RESULT_OK = 0;

	public final static int RESULT_COUNT_OVER = 1;

	public final static int RESULT_SPLIT = 2;

	public final static int RESULT_KOHI_SPLIT = 3;

	public final static int RESULT_KOHI_IS_INCLUDED = 4;

	// 開始、終了
	private Date begin;

	private Date end;

	// 重複件数
	private int count = 1;

	// 重複を許可する件数
	private int maxCount = 0;

	// 公費ID
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
	 * 重複の件数をカウントし、最大許可件数を超えた場合falseを返す。
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
	 * 重複の件数をカウントし、最大許可件数を超えた場合falseを返す。
	 */
	public int check(ArrayList rangeList, ArrayList list, VRMap row)
			throws Exception {

		// 公費の情報を退避
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
			// 重複なし
			break;
		case ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN:
		case ACDateUtilities.DUPLICATE_FIRST_END_AND_SECOND_BEGIN_ON_ONE_DAY:
			// 分割処理
			// 重複しなかった部分
			newRange = new QU004KohiRange();
			newRange.begin = (Date) this.begin.clone();
			newRange.end = ACDateUtilities.addDay(kohiBegin, -1);
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// 重複した部分
			this.begin = kohiBegin;
			this.count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// 比較元の公費履歴の有効期間を操作
			VRBindPathParser.set("KOHI_VALID_START", row, ACDateUtilities
					.addDay(this.end, 1));
			break;
		case ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_END:
			// 分割処理
			// 重複しなかった部分
			newRange = new QU004KohiRange();
			newRange.begin = (Date) this.begin.clone();
			newRange.end = ACDateUtilities.addDay(kohiBegin, -1);
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// 重複した部分
			this.begin = kohiBegin;
			this.count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// 比較元の公費履歴は削除する必要がある
			result = RESULT_KOHI_IS_INCLUDED;
			break;
		case ACDateUtilities.DUPLICATE_FIRST_BEGIN_AND_SECOND_END:
		case ACDateUtilities.DUPLICATE_FIRST_BEGIN_AND_SECOND_END_ON_ONE_DAY:
			// 分割処理
			// 重複しなかった部分
			newRange = new QU004KohiRange();
			newRange.begin = ACDateUtilities.addDay(kohiEnd, 1);
			newRange.end = (Date) this.end.clone();
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// 重複した部分
			this.end = kohiEnd;
			this.count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// 比較元の公費履歴の有効期間を操作
			VRBindPathParser.set("KOHI_VALID_END", row, ACDateUtilities.addDay(
					this.begin, -1));
			break;
		case ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND_EQUALS_BOTH_BEGIN:
			// 分割処理
			// 重複しなかった部分
			newRange = new QU004KohiRange();
			newRange.begin = ACDateUtilities.addDay(kohiEnd, 1);
			newRange.end = (Date) this.end.clone();
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// 重複した部分
			this.end = kohiEnd;
			this.count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// 比較元の公費履歴は削除する必要がある
			result = RESULT_KOHI_IS_INCLUDED;
			break;
		case ACDateUtilities.DUPLICATE_FIRST_INCLUDE_SECOND:
			// 分割処理
			// 重複しなかった部分1
			newRange = new QU004KohiRange();
			newRange.begin = (Date) this.begin.clone();
			newRange.end = ACDateUtilities.addDay(kohiBegin, -1);
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// 重複しなかった部分2
			newRange = new QU004KohiRange();
			newRange.begin = ACDateUtilities.addDay(kohiEnd, 1);
			newRange.end = (Date) this.end.clone();
			newRange.count = this.count;
			newRange.maxCount = this.maxCount;
			newRange.kohiIdList = (ArrayList) this.kohiIdList.clone();
			rangeList.add(newRange);
			// 重複した部分
			this.begin = kohiBegin;
			this.end = kohiEnd;
			this.count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// 比較元の公費履歴は削除する必要がある
			result = RESULT_KOHI_IS_INCLUDED;
			break;
		case ACDateUtilities.DUPLICATE_FIRST_EQUALS_SECOND:
			// 分割処理は発生しない
			count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// 比較元の公費履歴は削除する必要がある
			result = RESULT_KOHI_IS_INCLUDED;
			break;
		case ACDateUtilities.DUPLICATE_SECOND_INCLUDE_FIRST:
			// 分割処理は発生しない
			count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// 比較元が増える。
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
			// 比較元の公費履歴の有効期間を操作
			VRBindPathParser.set("KOHI_VALID_END", row, ACDateUtilities.addDay(
					this.begin, -1));
			result = RESULT_KOHI_SPLIT;
			break;
		case ACDateUtilities.DUPLICATE_SECOND_INCLUDE_FIRST_EQUALS_BOTH_END:
			// 分割処理は発生しない
			count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// 比較元の公費履歴の有効期間を操作
			VRBindPathParser.set("KOHI_VALID_END", row, ACDateUtilities.addDay(
					this.begin, -1));
			break;
		case ACDateUtilities.DUPLICATE_SECOND_INCLUDE_FIRST_EQUALS_BOTH_BEGIN:
			// 分割処理は発生しない
			count += 1;
			this.kohiIdList.add(new Integer(kohiId));
			// 比較元の公費履歴の有効期間を操作
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
