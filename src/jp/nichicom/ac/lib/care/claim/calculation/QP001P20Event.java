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
 * 作成日: 2006/02/06  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 介護保険サービス利用請求書 (001)
 * プログラム 介護保険サービス利用請求書 (QP001P15)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.text.NumberFormat;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;


/**
 * 介護保険サービス利用請求書イベント定義(QP001P201) 帳票定義体ファイル名 ： QP001P201.xml
 * 介護保険サービス利用請求書イベント定義(振込口座欄あり)(QP001P202) 帳票定義体ファイル名 ： QP001P202.xml
 * 介護保険サービス利用領収書イベント定義(QP001P203) 帳票定義体ファイル名 ： QP001P203.xml
 * 介護保険サービス利用領収書イベント定義(振込口座欄あり)(QP001P204) 帳票定義体ファイル名 ： QP001P204.xml
 * 介護保険サービス利用領収書イベント定義（領収欄あり）(QP001P205) 帳票定義体ファイル名 ： QP001P205.xml
 */
public class QP001P20Event {
    
    ACDateFormat eraFormat = new ACDateFormat("ggg");
    ACDateFormat eraYearFormat = new ACDateFormat("ee");
    ACDateFormat monthFormat = new ACDateFormat("MM");
    ACDateFormat dayFormat = new ACDateFormat("dd");
    private NumberFormat nf = NumberFormat.getInstance();
    
    //印刷クラス
    ACChotarouXMLWriter writer = null;
    //印刷用データ
    VRMap style = null;
    //介護サービス利用
    VRMap serviceDetail = null;
    //請求年月日
    private Date seikyuDate = null;
    //請求対象年月日
    private Date targetDate = null;
    //領収年月日
    Date ryousyuDate = null;
    
    //事業所名称
    VRMap provider = null;
    //居宅介護事業所
    VRMap care_provider = null;
    private String patientName = "";
    VRMap printSetting = null;
    
    //小計・合計を印刷するにチェック
    private boolean isTotalCheck = false;
    
    
    /**
     * コンストラクタです。
     */
    public QP001P20Event() {
    }

    /**
     * 印刷します。
     * 
     * @param writer
     *            印刷管理クラス
     * @param printParam
     *            印刷パラメタ
     * @throws Exception
     *             処理例外
     */
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception{
        this.writer = writer;
        this.style = (VRMap)printParam.get("STYLE_DATA");
        //利用者請求情報
        this.serviceDetail = (VRMap)printParam.get("CLAIM_PATIENT_DETAIL");
        this.provider = (VRMap)printParam.get("PROVIDER");
        care_provider = (VRMap)printParam.get("CARE_PROVIDER");
        patientName = ACCastUtilities.toString(printParam.get("PATIENT_NAME"));
        printSetting = (VRMap)printParam.get("PRINT_SETTING");
        
        //請求年月日
        if(!ACTextUtilities.isNullText(VRBindPathParser.get("TARGET_DATE",printSetting))){
            seikyuDate = ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",printSetting),null);
        }
        
        //請求対象年月日
        targetDate = ACCastUtilities.toDate(VRBindPathParser.get("TARGET_DATE",this.style),null);
        
        //領収年月日
        if(!ACTextUtilities.isNullText(VRBindPathParser.get("GET_DATE",printSetting))){
            ryousyuDate = ACCastUtilities.toDate(VRBindPathParser.get("GET_DATE",printSetting));
        }
        
        //小計・合計を印刷するにチェック
        if(ACCastUtilities.toInt(VRBindPathParser.get("TOTAL_CHECK",printSetting),0) == 1){
            isTotalCheck = true;
        }
        
        return doPrint();
    }
    
    /**
     * 各帳票共通のデータ設定を行います。<br>
     * 各帳票の違い<br>
     * QP001P201 - 通常利用請求書<br>
     * QP001P202 - 通常利用請求書+振込先口座付<br>
     * QP001P203 - 通常利用領収書(利用請求書と頭書きが異なるのみ)<br>
     * QP001P204 - 通常利用領収書+振込先口座付<br>
     * QP001P205 - 通常利用領収書+領収額<br>
     * <br>
     * @throws Exception
     */
    protected void setBasicData() throws Exception {
        
        int riyousya = 0;
        int zengaku = 0;
        int kohi = 0;
        int etc = 0;
        
        //請求日が入力されていれば
        if(seikyuDate != null){
            // 請求年月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w1", eraFormat.format(seikyuDate));
            // 請求年月日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w2", eraYearFormat.format(seikyuDate));
            // 請求年月日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w4", monthFormat.format(seikyuDate));
            // 請求年月日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyuDate.h1.w6", dayFormat.format(seikyuDate));
        }
        
        if(ryousyuDate != null){
            // 請求年月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w1", eraFormat.format(ryousyuDate));
            // 請求年月日の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w2", eraYearFormat.format(ryousyuDate));
            // 請求年月日の月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w4", monthFormat.format(ryousyuDate));
            // 請求年月日の日(DDフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "ryousyuDate.h1.w6", dayFormat.format(ryousyuDate));
        }

        // 請求の対象者を設定する。
        ACChotarouXMLUtilities.setValue(writer, "riyosya", patientName);

        //請求の対象日を設定する。
        if(targetDate != null){
            //請求対象年月日の和暦を設定する。
            ACChotarouXMLUtilities.setValue(writer, "targetDate.h1.w2", eraFormat.format(targetDate));
            //請求対象の和暦年(YYフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "targetDate.h1.w3", eraYearFormat.format(targetDate));
            //請求対象の和暦月(MMフォーマット)を設定する。
            ACChotarouXMLUtilities.setValue(writer, "targetDate.h1.w5", monthFormat.format(targetDate));
        }
        
        //利用者負担のデータを設定
        // サービス名１を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601001","seikyu.r1.service");
        // 利用者負担額１を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r1.futan", getFormatData(style, "1601002"));
        // サービス名２を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601003","seikyu.r2.service");
        // 利用者負担額２を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r2.futan", getFormatData(style, "1601004"));
        // サービス名３を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601005","seikyu.r3.service");
        // 利用者負担額３を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r3.futan", getFormatData(style, "1601006"));
        // サービス名４を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601007","seikyu.r4.service");
        // 利用者負担額４を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r4.futan", getFormatData(style, "1601008"));
        // サービス名５を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601009","seikyu.r5.service");
        // 利用者負担額５を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r5.futan", getFormatData(style, "1601010"));
        // サービス名６を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601011","seikyu.r6.service");
        // 利用者負担額６を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r6.futan", getFormatData(style, "1601012"));
        // サービス名７を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601013","seikyu.r7.service");
        // 利用者負担額７を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r7.futan", getFormatData(style, "1601014"));
        // サービス名８を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601015","seikyu.r8.service");
        // 利用者負担額８を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r8.futan", getFormatData(style, "1601016"));
        // サービス名９を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601017","seikyu.r9.service");
        // 利用者負担額９を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r9.futan", getFormatData(style, "1601018"));
        // サービス名１０を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601019","seikyu.r10.service");
        // 利用者負担額１０を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r10.futan", getFormatData(style, "1601020"));
        
        // 単位数１を設定する。
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r1.unit", getFormatData(style, "1601038"));
        // 回数１を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r1.count", getFormatData(style, "1601039"));
        // 単位数２を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r2.unit", getFormatData(style, "1601040"));
        // 回数２を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r2.count", getFormatData(style, "1601041"));
        // 単位数３を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r3.unit", getFormatData(style, "1601042"));
        // 回数３を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r3.count", getFormatData(style, "1601043"));
        // 単位数４を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r4.unit", getFormatData(style, "1601044"));
        // 回数４を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r4.count", getFormatData(style, "1601045"));
        // 単位数５を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r5.unit", getFormatData(style, "1601046"));
        // 回数５を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r5.count", getFormatData(style, "1601047"));
        // 単位数６を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r6.unit", getFormatData(style, "1601048"));
        // 回数６を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r6.count", getFormatData(style, "1601049"));
        // 単位数７を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r7.unit", getFormatData(style, "1601050"));
        // 回数７を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r7.count", getFormatData(style, "1601051"));
        // 単位数８を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r8.unit", getFormatData(style, "1601052"));
        // 回数８を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r8.count", getFormatData(style, "1601053"));
        // 単位数９を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r9.unit", getFormatData(style, "1601054"));
        // 回数９を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r9.count", getFormatData(style, "1601055"));
        // 単位数１０を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r10.unit", getFormatData(style, "1601056"));
        // 回数１０を設定する
        ACChotarouXMLUtilities.setValue(writer, "seikyu.r10.count", getFormatData(style, "1601057"));
        
        
        riyousya += ACCastUtilities.toInt(style.get("1601002"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601004"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601006"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601008"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601010"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601012"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601014"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601016"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601018"),0);
        riyousya += ACCastUtilities.toInt(style.get("1601020"),0);
        
        
        if(serviceDetail != null){
            //全額自己負担のデータを設定する。
            // サービス名１を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "SELF_SERVICE_NO1","zengaku.z1.service");
            // 利用者負担額１を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "zengaku.z1.futan", getFormatData(serviceDetail, "SELF_PAY_NO1"));
            // サービス名２を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "SELF_SERVICE_NO2","zengaku.z2.service");
            // 利用者負担額２を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "zengaku.z2.futan", getFormatData(serviceDetail, "SELF_PAY_NO2"));
            // サービス名３を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "SELF_SERVICE_NO3","zengaku.z3.service");
            // 利用者負担額３を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "zengaku.z3.futan", getFormatData(serviceDetail, "SELF_PAY_NO3"));

            zengaku += ACCastUtilities.toInt(serviceDetail.get("SELF_PAY_NO1"),0);
            zengaku += ACCastUtilities.toInt(serviceDetail.get("SELF_PAY_NO2"),0);
            zengaku += ACCastUtilities.toInt(serviceDetail.get("SELF_PAY_NO3"),0);
        }
        
        //公費本人負担のデータを設定する。
        // サービス名１を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601021","kohi.k1.service");
        // 利用者負担額１を設定する。
        ACChotarouXMLUtilities.setValue(writer, "kohi.k1.futan", getFormatData(style, "1601022"));
        // サービス名２を設定する。
        ACChotarouXMLUtilities.setValue(writer, style, "1601023","kohi.k2.service");
        // 利用者負担額２を設定する。
        ACChotarouXMLUtilities.setValue(writer, "kohi.k2.futan", getFormatData(style, "1601024"));
        
        
        kohi += ACCastUtilities.toInt(style.get("1601022"),0);
        kohi += ACCastUtilities.toInt(style.get("1601024"),0);
        
        
        if(serviceDetail != null){
            //その他のデータを設定する。
            // サービス名１を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO1","seikyu.e1.service");
            // 利用者負担額１を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e1.futan", getFormatData(serviceDetail, "OTHER_PAY_NO1"));
            // サービス名２を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO2","seikyu.e2.service");
            // 利用者負担額２を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e2.futan", getFormatData(serviceDetail, "OTHER_PAY_NO2"));
            // サービス名３を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO3","seikyu.e3.service");
            // 利用者負担額３を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e3.futan", getFormatData(serviceDetail, "OTHER_PAY_NO3"));
            // サービス名４を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO4","seikyu.e4.service");
            // 利用者負担額４を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e4.futan", getFormatData(serviceDetail, "OTHER_PAY_NO4"));
            // サービス名５を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO5","seikyu.e5.service");
            // 利用者負担額５を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e5.futan", getFormatData(serviceDetail, "OTHER_PAY_NO5"));

            // 単位数１を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e1.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO1"));
            // 回数１を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e1.count", getFormatData(serviceDetail, "OTHER_COUNT_NO1"));
            // 単位数２を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e2.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO2"));
            // 回数２を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e2.count", getFormatData(serviceDetail, "OTHER_COUNT_NO2"));
            // 単位数３を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e3.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO3"));
            // 回数３を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e3.count", getFormatData(serviceDetail, "OTHER_COUNT_NO3"));
            // 単位数４を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e4.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO4"));
            // 回数４を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e4.count", getFormatData(serviceDetail, "OTHER_COUNT_NO4"));
            // 単位数５を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e5.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO5"));
            // 回数５を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e5.count", getFormatData(serviceDetail, "OTHER_COUNT_NO5"));
            // サービス名６を設定する。
            ACChotarouXMLUtilities.setValue(writer, serviceDetail, "OTHER_HIMOKU_NO6","seikyu.e6.service");
            // 単位数５を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e6.unit", getFormatData(serviceDetail, "OTHER_UNIT_NO6"));
            // 回数５を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e6.count", getFormatData(serviceDetail, "OTHER_COUNT_NO6"));
            // 利用者負担額５を設定する。 ※CLAIM_PATIENT_DETAILより取得
            ACChotarouXMLUtilities.setValue(writer, "seikyu.e6.futan", getFormatData(serviceDetail, "OTHER_PAY_NO6"));
            
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO1"),0);
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO2"),0);
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO3"),0);
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO4"),0);
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO5"),0);
            etc += ACCastUtilities.toInt(serviceDetail.get("OTHER_PAY_NO6"),0);
        }

        // 事業所名を設定する。
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME","jigyosyoname");
        // 事業所の所在地を設定する。
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_ADDRESS","address");
        // 事業所の電話番号を設定する。
        ACChotarouXMLUtilities.setValue(writer, "tel", QkanCommon.toTel(provider.get("PROVIDER_TEL_FIRST"),provider.get("PROVIDER_TEL_SECOND"),provider.get("PROVIDER_TEL_THIRD")));
        // 事業所の管理者氏名を設定する。
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_OWNER_NAME","kanrisya");
        
        
        // 小計・合計を印刷するにチェックがついている場合、
        if(isTotalCheck){
            // 利用者負担の利用者負担額小計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total1.futan", getFormatData(riyousya));
            // 全額自己負担の利用者負担額小計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total2.futan", getFormatData(zengaku));
            // 公費本人負担の本人負担額小計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total3.futan", getFormatData(kohi));
            // その他の利用料小計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total4.futan", getFormatData(etc));
            //総合計を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyu.total5.futan",getFormatData(riyousya + zengaku + kohi + etc));
            // 請求額を設定する。
            ACChotarouXMLUtilities.setValue(writer, "seikyutotal", getFormatData(riyousya + zengaku + kohi + etc));
            
        }

    }
    
    private String getFormatData(int value) throws Exception {
        if(value == 0) return "";
        return nf.format((double)(value));
    }
    
    
    /**
     * 印刷を実行します。
     * 印刷実行に必用なデータは全て親クラスで保持しています。
     * @return
     * @throws Exception
     */
    public boolean doPrint() throws Exception{
        return false;
    }
    
    public String getFormatData(VRMap style,String key) throws Exception{
        String value = String.valueOf(style.get(key));
        
        if(ACTextUtilities.isNullText(value) || "0".equals(value) || value.equalsIgnoreCase("NULL")){
            return "";
        }
        
        return nf.format(ACCastUtilities.toDouble(value,0));
    }

	/**
	 * @return isTotalCheck を戻します。
	 */
	public boolean getIsTotalCheck() {
		return isTotalCheck;
	}

	/**
	 * @param isTotalCheck isTotalCheck を設定。
	 */
	public void setIsTotalCheck(boolean isTotalCheck) {
		this.isTotalCheck = isTotalCheck;
	}
	/**
	 * @return nf を戻します。
	 */
	public NumberFormat getNf() {
		return nf;
	}

	/**
	 * @param nf nf を設定。
	 */
	public void setNf(NumberFormat nf) {
		this.nf = nf;
	}

}
