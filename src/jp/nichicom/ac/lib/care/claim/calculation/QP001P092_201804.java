
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
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
 *****************************************************************
 * アプリ: QKANCHO
 * 開発者: 藤原　伸
 * 作成日: 2006/01/17  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 在宅サービス介護給付費明細書（介護老人保健施設） (001)
 * プログラム 在宅サービス介護給付費明細書（介護老人保健施設） (QP001051)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public class QP001P092_201804 extends QP001P09_201804{
	
	/* 
	 * 様式第九の二 201804以降
	 * 
	 * addFormat()
	 * 設定する帳票定義体を変更
	 * 
	 * getFormatId()
	 * フォーマット番号の変更
	 */

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P092_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P092_201804";
    }
    protected int getSpecialClinicRecordType() {
    	//特別診療費のレコードタイプを返す
    	return QkanConstants.SPECIAL_CLINIC_RECORD_TYPE_TOKUBETU_SHINRYO;
    }

	@Override
	protected VRMap getEmergencyInfo() {
		return getemErgencyMap();
	}

	@Override
	protected void writeEmergency() throws Exception {
		VRMap emergencyMap = getEmergencyInfo();
		/* ============================================================================= */
        /* 緊急時施設療養費 */
        /* ============================================================================= */
        if(emergencyMap != null){
            // 緊急時傷病名１を設定する。
            ACChotarouXMLUtilities.setValue(writer, emergencyMap,
                    "401008", "emergency.s1.syoubyo");
            // 緊急時傷病名２を設定する。
            ACChotarouXMLUtilities.setValue(writer, emergencyMap,
                    "401009", "emergency.s2.syoubyo");
            // 緊急時傷病名３を設定する。
            ACChotarouXMLUtilities.setValue(writer, emergencyMap,
                    "401010", "emergency.s3.syoubyo");

            // 緊急時治療開始開始年月日１
            if (QP001Util.isDate(VRBindPathParser.get("401011",
                    emergencyMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser
                        .get("401011", emergencyMap));
                // 緊急時治療開始年月日１の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergency.s1.emergencydate", eraFormat
                                .format(start));
                // 緊急時治療開始年月日１の和暦年を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyyear1", eraYearFormat.format(start));
                // 緊急時治療開始年月日１の月を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencymonth1", monthFormat.format(start));
                // 緊急時治療開始年月日１の日を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyday1", dayFormat.format(start));
            }

            // 緊急時治療開始年月日２
            if (QP001Util.isDate(VRBindPathParser.get("401012",
                    emergencyMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser
                        .get("401012", emergencyMap));
                // 緊急時治療開始年月日２の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergency.s2.emergencydate", eraFormat
                                .format(start));
                // 緊急時治療開始年月日２の和暦年を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyyear2", eraYearFormat.format(start));
                // 緊急時治療開始年月日２の月を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencymonth2", monthFormat.format(start));
                // 緊急時治療開始年月日２の日を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyday2", dayFormat.format(start));
            }

            // 緊急時治療開始年月日３
            if (QP001Util.isDate(VRBindPathParser.get("401013",
                    emergencyMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser
                        .get("401013", emergencyMap));
                // 緊急時治療開始年月日３の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergency.s3.emergencydate", eraFormat
                                .format(start));
                // 緊急時治療開始年月日３の和暦年を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyyear3", eraYearFormat.format(start));
                // 緊急時治療開始年月日３の月を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencymonth3", monthFormat.format(start));
                // 緊急時治療開始年月日３の日を設定する。
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyday3", dayFormat.format(start));
            }

            // 緊急時治療管理(再掲)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency.h8.w4",
                    pad(emergencyMap.get("401020"), 0));
            // 緊急時治療管理単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency.h8.w10",
                    pad(emergencyMap.get("401018"), 0));
            // 緊急時治療管理日数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "tani", pad(
                    emergencyMap.get("401019"), 2));

            // リハビリテーション点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency.h7.w4",
                    pad(emergencyMap.get("401021"), 0));
            // 処置点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency.h6.w4",
                    pad(emergencyMap.get("401022"), 0));
            // 手術点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency.h5.w4",
                    pad(emergencyMap.get("401023"), 0));
            // 麻酔点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency.h4.w4",
                    pad(emergencyMap.get("401024"), 0));
            // 放射線治療点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency.h3.w4",
                    pad(emergencyMap.get("401025"), 0));
            // 合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency.h1.w4",
                    pad(emergencyMap.get("401046"), 0));

            // 摘要を設定する。※摘要１～摘要２０までを「／」で連結し、出力。
            StringBuilder tekiyo = new StringBuilder();
            for (int j = 401026; j < 401046; j++) {
                if (!ACTextUtilities.isNullText(VRBindPathParser.get(
                        ACCastUtilities.toString(j), emergencyMap))) {
                    tekiyo.append(VRBindPathParser.get(ACCastUtilities
                            .toString(j), emergencyMap));
                    tekiyo.append("／");
                }
            }
            if (tekiyo.length() > 0) {
                tekiyo.deleteCharAt(tekiyo.length() - 1);
            }
            ACChotarouXMLUtilities.setValue(writer, "emergency.h6.w10",
                    tekiyo.toString());
            // 往診日数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "oushintimes", pad(
                    emergencyMap.get("401014"), 2));
            // 往診医療機関名を設定する。
            ACChotarouXMLUtilities.setValue(writer, emergencyMap,
                    "401015", "emergency.h2.w3");
            // 通院日数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "tuuintimes", pad(
                    emergencyMap.get("401016"), 2));
            // 通院医療機関を設定する。
            ACChotarouXMLUtilities.setValue(writer, emergencyMap,
                    "401017", "emergency.h2.w16");
        
        }
	}
}
