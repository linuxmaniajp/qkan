
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

public class QP001P091_201804 extends QP001P09_201804{
	
	/* 
	 * 様式第九 201804以降
	 * 
	 * addFormat()
	 * 設定する帳票定義体を変更
	 * 
	 * getFormatId()
	 * フォーマット番号の変更
	 */

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P091_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P091_201804";
    }

    // [H30.4改正対応][Yoichiro Kamei] 2018/3/28 add - begin
    protected int getSpecialClinicRecordType() {
    	//特別療養費のレコードタイプを返す
    	return QkanConstants.SPECIAL_CLINIC_RECORD_TYPE_TOKUBETU_RYOYO;
    }
    
	@Override
	protected VRMap getEmergencyInfo() {
		return getemErgencyOwnFacilityMap();
	}
	
	@Override
	protected void writeEmergency() throws Exception {
		VRMap emergencyOwnFacilityMap = getEmergencyInfo();
		// 緊急時施設治療費===================================
        if(emergencyOwnFacilityMap != null){
            
            // 特定疾患施設療養費 傷病名１
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701047", "emergency1.h1.w8");
            // 特定疾患施設療養費 傷病名２
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701048", "emergency1.h2.w8");
            // 特定疾患施設療養費 傷病名３
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701049", "emergency1.h3.w8");
            // 特定疾患施設療養費開始年月日１
            if (QP001Util.isDate(VRBindPathParser.get("1701050", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701050", emergencyOwnFacilityMap));
                // 特定疾患施設療養費開始年月日１の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h1.w19", eraFormat.format(start));
                // 特定疾患施設療養費開始年月日１の和暦年を設定する。
                ACChotarouXMLUtilities.setValue(writer, "ownyear1", eraYearFormat.format(start));
                // 特定疾患施設療養費開始年月日１の月を設定する。
                ACChotarouXMLUtilities.setValue(writer, "ownmonth1", monthFormat.format(start));
                // 特定疾患施設療養費開始年月日１の日を設定する。
                ACChotarouXMLUtilities.setValue(writer, "ownday1", dayFormat.format(start));
            }
            // 特定疾患施設療養費開始年月日２
            if (QP001Util.isDate(VRBindPathParser.get("1701051", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701051", emergencyOwnFacilityMap));
                // 特定疾患施設療養費開始年月日２の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h2.w19", eraFormat.format(start));
                // 特定疾患施設療養費開始年月日２の和暦年を設定する。
                ACChotarouXMLUtilities.setValue(writer, "ownyear2", eraYearFormat.format(start));
                // 特定疾患施設療養費開始年月日２の月を設定する。
                ACChotarouXMLUtilities.setValue(writer, "ownmonth2", monthFormat.format(start));
                // 特定疾患施設療養費開始年月日２の日を設定する。
                ACChotarouXMLUtilities.setValue(writer, "ownday2", dayFormat.format(start));
            }
            // 特定疾患施設療養費開始年月日３
            if (QP001Util.isDate(VRBindPathParser.get("1701052", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701052", emergencyOwnFacilityMap));
                // 特定疾患施設療養費開始年月日３の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h3.w19", eraFormat.format(start));
                // 特定疾患施設療養費開始年月日３の和暦年を設定する。
                ACChotarouXMLUtilities.setValue(writer, "ownyear3", eraYearFormat.format(start));
                // 特定疾患施設療養費開始年月日３の月を設定する。
                ACChotarouXMLUtilities.setValue(writer, "ownmonth3", monthFormat.format(start));
                // 特定疾患施設療養費開始年月日３の日を設定する。
                ACChotarouXMLUtilities.setValue(writer, "ownday3", dayFormat.format(start));
            }
            // 特定疾患施設療養費(再掲)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency1.h4.w7", pad(emergencyOwnFacilityMap.get("1701055"),0));
            // 特定疾患施設療養費単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency1.h4.w10", pad(emergencyOwnFacilityMap.get("1701053"),0));
            // 特定疾患施設療養費日数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "owntani", pad(emergencyOwnFacilityMap.get("1701054"),2));
            
            
            // 緊急時傷病名１を設定する。
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701008", "emergency1.h5.w8");
            // 緊急時傷病名２を設定する。
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701009", "emergency1.h6.w8");
            // 緊急時傷病名３を設定する。
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701010", "emergency1.h7.w8");

            // 緊急時治療開始開始年月日１
            if (QP001Util.isDate(VRBindPathParser.get("1701011", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701011", emergencyOwnFacilityMap));
                // 緊急時治療開始年月日１の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h5.w19", eraFormat.format(start));
                // 緊急時治療開始年月日１の和暦年を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergencyyear1", eraYearFormat.format(start));
                // 緊急時治療開始年月日１の月を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergencymonth1", monthFormat.format(start));
                // 緊急時治療開始年月日１の日を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergencyday1", dayFormat.format(start));
            }

            // 緊急時治療開始年月日２
            if (QP001Util.isDate(VRBindPathParser.get("1701012", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701012", emergencyOwnFacilityMap));
                // 緊急時治療開始年月日２の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h6.w19", eraFormat.format(start));
                // 緊急時治療開始年月日２の和暦年を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergencyyear2", eraYearFormat.format(start));
                // 緊急時治療開始年月日２の月を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergencymonth2", monthFormat.format(start));
                // 緊急時治療開始年月日２の日を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergencyday2", dayFormat.format(start));
            }

            // 緊急時治療開始年月日３
            if (QP001Util.isDate(VRBindPathParser.get("1701013", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701013", emergencyOwnFacilityMap));
                // 緊急時治療開始年月日３の和暦を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h7.w19", eraFormat.format(start));
                // 緊急時治療開始年月日３の和暦年を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergencyyear3", eraYearFormat.format(start));
                // 緊急時治療開始年月日３の月を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergencymonth3", monthFormat.format(start));
                // 緊急時治療開始年月日３の日を設定する。
                ACChotarouXMLUtilities.setValue(writer, "emergencyday3", dayFormat.format(start));
            }

            // 緊急時治療管理(再掲)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency1.h8.w7", pad(emergencyOwnFacilityMap.get("1701020"),0));
            // 緊急時治療管理単位数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency1.h8.w10", pad(emergencyOwnFacilityMap.get("1701018"),0));
            // 緊急時治療管理日数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergencytani", pad(emergencyOwnFacilityMap.get("1701019"),2));

            // リハビリテーション点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h9.w6", pad(emergencyOwnFacilityMap.get("1701021"),0));
            // 処置点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h10.w6", pad(emergencyOwnFacilityMap.get("1701022"),0));
            // 手術点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h11.w6", pad(emergencyOwnFacilityMap.get("1701023"),0));
            // 麻酔点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h12.w6", pad(emergencyOwnFacilityMap.get("1701024"),0));
            // 放射線治療点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h13.w6", pad(emergencyOwnFacilityMap.get("1701025"),0));
            // 合計点数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h14.w6", pad(emergencyOwnFacilityMap.get("1701046"),0));
            
            // 摘要を設定する。※摘要１～摘要２０までを「／」で連結し、出力。
            StringBuilder tekiyo = new StringBuilder();
            for (int j = 1701026; j < 1701046; j++) {
                if (!ACTextUtilities.isNullText(VRBindPathParser.get(ACCastUtilities.toString(j), emergencyOwnFacilityMap))) {
                    tekiyo.append(VRBindPathParser.get(ACCastUtilities.toString(j), emergencyOwnFacilityMap));
                    tekiyo.append("／");
                }
            }
            if (tekiyo.length() > 0) {
                tekiyo.deleteCharAt(tekiyo.length() - 1);
            }
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h10.w10",tekiyo.toString());
            
            // 往診日数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "oushintimes", pad(emergencyOwnFacilityMap.get("1701014"),2));
            // 往診医療機関名を設定する。
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap,"1701015", "emergency3.h15.w8");
            
            // 通院日数を設定する。
            ACChotarouXMLUtilities.setValue(writer, "tuuintimes", pad(emergencyOwnFacilityMap.get("1701016"),2));
            // 通院医療機関を設定する。
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701017","emergency3.h15.w21");
        }
	}
    // [H30.4改正対応][Yoichiro Kamei] 2018/3/28 add - end
}
