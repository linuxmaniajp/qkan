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
 * 作成日: 2006/01/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 社会福祉減免レコード (QP001RecordReduction)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 社会福祉減免レコード
 * 
 * @author shin fujihara
 * 
 */
public class QP001RecordReduction extends QP001RecordAbstract {

    // 交換情報識別番号4桁
    private String _901001 = "";

    // レコード種別コード2桁(12を設定)"
    private static final String _901002 = "12";

    // サービス提供年月6桁(YYYYMM)"
    private String _901003 = "";

    // 事業所番号10桁
    private String _901004 = "";

    // 事業所番号10桁
    private String _901005 = "";

    // 被保険者番号10桁
    private String _901006 = "";

    // 軽減率4桁
    private int _901007 = 0;

    // サービス種類コード2桁
    private String _901008 = "";

    // 受領すべき利用者負担の総額8桁
    private int _901009 = 0;

    // 軽減額8桁
    private int _901010 = 0;

    // 軽減後利用者負担額8桁
    private int _901011 = 0;

    // 備考20桁
    private String _901012 = "";

    // 単位数
    private int _901013 = 0;
    
    //金額
    private int _901014 = 0;

    /**
     * 交換情報識別番号4桁を取得する。
     * 
     * @return
     */
    protected String get_901001() {
        return _901001;
    }

    /**
     * 交換情報識別番号4桁を設定する。
     * 
     * @param _901001
     */
    protected void set_901001(String _901001) {
        this._901001 = _901001;
    }

    /**
     * レコード種別コード2桁を取得する。
     */
    protected String get_901002() {
        return _901002;
    }

    /**
     * サービス提供年月6桁を取得する。
     * 
     * @return
     */
    protected String get_901003() {
        return _901003;
    }

    /**
     * サービス提供年月6桁を設定する。
     * 
     * @param _901003
     */
    protected void set_901003(String _901003) {
        this._901003 = _901003;
    }

    /**
     * 事業所番号10桁を取得する。
     * 
     * @return
     */
    protected String get_901004() {
        return _901004;
    }

    /**
     * 事業所番号10桁を設定する。
     * 
     * @param _901004
     */
    protected void set_901004(String _901004) {
        this._901004 = _901004;
    }

    /**
     * 証記載保険者番号8桁を取得する。
     * 
     * @return
     */
    protected String get_901005() {
        return _901005;
    }

    /**
     * 証記載保険者番号8桁を設定する。
     * 
     * @param _901005
     */
    protected void set_901005(String _901005) {
        this._901005 = _901005;
    }

    /**
     * 被保険者番号10桁を取得する。
     * 
     * @return
     */
    protected String get_901006() {
        return _901006;
    }

    /**
     * 被保険者番号10桁を設定する。
     * 
     * @param _901006
     */
    protected void set_901006(String _901006) {
        this._901006 = _901006;
    }

    /**
     * 軽減率4桁を取得する。
     * 
     * @return
     */
    protected int get_901007() {
        return _901007;
    }

    /**
     * 軽減率4桁を設定する。
     * 
     * @param _901007
     */
    protected void set_901007(int _901007) {
        this._901007 = _901007;
    }

    /**
     * サービス種類コード2桁を取得する。
     * 
     * @return
     */
    protected String get_901008() {
        return _901008;
    }

    /**
     * サービス種類コード2桁を設定する。
     * 
     * @param _901008
     */
    protected void set_901008(String _901008) {
        this._901008 = _901008;
    }

    /**
     * 受領すべき利用者負担の総額8桁を取得する。
     * 
     * @return
     */
    protected int get_901009() {
        return _901009;
    }

    /**
     * 受領すべき利用者負担の総額8桁を設定する。
     * 
     * @param _901009
     */
    protected void set_901009(int _901009) {
        this._901009 = _901009;
    }

    /**
     * 軽減額8桁を取得する。
     * 
     * @return
     */
    protected int get_901010() {
        return _901010;
    }

    /**
     * 軽減額8桁を設定する。
     * 
     * @param _901010
     */
    protected void set_901010(int _901010) {
        this._901010 = _901010;
    }

    /**
     * 軽減後利用者負担額8桁を取得する。
     * 
     * @return
     */
    protected int get_901011() {
        return _901011;
    }

    /**
     * 軽減後利用者負担額8桁を設定する。
     * 
     * @param _901011
     */
    protected void set_901011(int _901011) {
        this._901011 = _901011;
    }

    /**
     * 備考20桁を取得する。
     * 
     * @return
     */
    protected String get_901012() {
        return _901012;
    }

    /**
     * 備考20桁を設定する。
     * 
     * @param _901012
     */
    protected void set_901012(String _901012) {
        this._901012 = _901012;
    }

    /**
     * 社福減免対象単位数を設定する。
     * @param _901013
     */
    protected void set_901013(int _901013) {
        this._901013 = _901013;
    }
    /**
     * 社福減免対象単位数を取得する。
     * @return
     */
    protected int get_901013() {
        return _901013;
    }
    /**
     * 社福減免対象の金額を設定する。(食費など)
     * @param _901014
     */
    protected void set_901014(int _901014) {
        this._901014 = _901014;
    }
    /**
     * 社福減免対象の金額を取得する。(食費など)
     * @return
     */
    protected int get_901014() {
        return _901014;
    }

    /**
     * 既に情報が登録されているか返却します。
     * 
     * @return 新規:true 追加:false
     */
    protected boolean isNew() {
        // 交換情報レコードに登録が無ければ新規とみなす。
        return ((get_901001() == null) || ("".equals(get_901001())));
    }

    /**
     * データのパースを実行します。
     * 
     * @param serviceDetail
     * @param targetDate
     * @param patientState
     * @param serviceCode
     * @throws Exception
     */
    protected void parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,
            String identificationNo,QP001Manager manager) throws Exception {

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);
        
        
        if (isNew()) {
            // reduction の KEY : 901001(交換情報識別番号) に VALUE : 第六引数を設定する。
            set_901001(identificationNo);

            // reduction の KEY : 901003(サービス提供年月) に VALUE :
            // yyyyMM形式にフォーマットしたtargetDateを設定する。
            set_901003(VRDateParser.format(targetDate, "yyyyMM"));

            // reduction の KEY : 901004(事業所番号) に VALUE :
            // 10桁フォーマットした事業所番号(serviceDetailより取得)を設定する。
            set_901004(ACCastUtilities.toString(VRBindPathParser.get(
                    "PROVIDER_ID", serviceDetail)));

            // reduction の KEY : 901005(証記載保険者番号) に VALUE :
            // 8桁フォーマットした利用者の保険者番号(patientより取得)を設定する。
            set_901005(patientState.getInsurerId(targetServiceDate));

            // reduction の KEY : 901006(被保険者番号) に VALUE :
            // 10桁フォーマットした利用者の被保険者番号(patientより取得)を設定する。
            set_901006(patientState.getInsuredId(targetServiceDate));

            // reduction の KEY : 901007(軽減率) に VALUE : patient の軽減率を設定する。 ※050.0
            // または 025.0
            set_901007(patientState.getReductionRatio(targetServiceDate, String
                    .valueOf(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
                            serviceCode))));

            // reduction の KEY : 901008(サービス種類コード) に VALUE :
            // 2桁フォーマットしたサービス種類コード(serviceCodeより取得))を設定する。
            set_901008(ACCastUtilities.toString(VRBindPathParser.get(
                    "SERVICE_CODE_KIND", serviceCode)));

            // reduction の KEY : TANI(対象単位数) に VALUE :
            // 単位数(serviceCodeより取得)を設定する。
            set_901013(manager.getServiceUnit(get_901004(),
                    serviceCode));

        } else {
            // reduction の KEY : TANI(対象単位数) の値に単位数(serviceCodeより取得)を加える。
            set_901013(get_901013()
                    + manager.getServiceUnit(get_901004(),
                            serviceCode));
        }
        
        //食費、居住費の特例処理
        if("59".equals(ACCastUtilities.toString(VRBindPathParser.get(
                "SERVICE_CODE_KIND", serviceCode)))){
            //費用単価
            int unit = QP001SpecialCase.getUnit(serviceDetail,serviceCode,manager);
            //利用者負担額
            int userUnit = QP001SpecialCase.getRiyosyaFutan(serviceCode,patientState);
            //費用単価よりも利用者負担額が大きい場合
            if(unit < userUnit){
                //費用単価を利用者負担として設定する。
                set_901014(unit);
            } else {
                //利用者負担額を設定する。
                set_901014(userUnit);
            }
        }

    }

    /**
     * レコード固有の値を取得する。
     */
    protected String getSerialId() {

        StringBuilder serial = new StringBuilder();
        // 交換情報識別番号4桁
        serial.append(get_901001());
        // レコード種別コード2桁
        serial.append(get_901002());
        // サービス提供年月6桁
        serial.append(get_901003());
        // 事業所番号10桁
        serial.append(get_901004());
        // 証記載保険者番号8桁
        serial.append(get_901005());
        // 被保険者番号10桁
        serial.append(get_901006());
        // 軽減率4桁
        serial.append(get_901007());
        // サービス種類コード2桁
        serial.append(get_901008());

        return serial.toString();
    }
    
    /**
     * 
     * @param identificationNo
     * @param targetDate
     * @param targetServiceDate
     * @param serviceDetail
     * @param serviceCode
     * @param patientState
     * @param reductionMap
     * @return
     * @throws Exception
     */
    protected static QP001RecordReduction getInstance(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState,VRMap reductionMap,QP001Manager manager) throws Exception {
        
        QP001RecordReduction reduction = null;
        
        //レコードの作成可否を判断
        if(!isMakeRecord(targetDate, targetServiceDate,serviceDetail,serviceCode,patientState,manager)){
            return reduction;
        }
        
        String serial = getSerialId(identificationNo,
                                    targetDate,
                                    targetServiceDate,
                                    serviceDetail,
                                    serviceCode,
                                    patientState);
        
        //条件に合致するレコードが存在しない場合
        if(!reductionMap.containsKey(serial)){
            reduction = new QP001RecordReduction();
            reductionMap.put(serial,reduction);
        //条件に合致するレコードが存在する場合
        } else {
            reduction = (QP001RecordReduction)reductionMap.get(serial);
        }
        
        return reduction;
    }

    protected static boolean isMakeRecord(Date targetDate,
            Object targetServiceDate, VRMap serviceDetail, VRMap serviceCode,
            QP001PatientState patientState,QP001Manager manager) throws Exception {
        
        //サービス提供時、社会福祉法人軽減額の対象でない場合。
        if(patientState.getReductionRatio(targetServiceDate,String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL"))) == 0){
            //処理を終了する。
            return false;
        }
        
        //事業所が該当のサービスを社福減免として認めていない場合。        
//        if(!QP001Manager.getInstance().isReduction(String.valueOf(serviceDetail.get("PROVIDER_ID")),String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")))){
        if(!manager.isReduction(String.valueOf(serviceDetail.get("PROVIDER_ID")),String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")))){
            //処理を終了する。
            return false;
        }
        
        //サービス提供時、patient の保険負担額が100%の場合。
//        if (patientState.getKohiRatio(targetDate,
//                                      String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),
//                                      "1",1,
//                                      QP001Manager.getInstance().getProviderMedicalFlag(String.valueOf(serviceDetail.get("PROVIDER_ID")))) == 100) {

        
        //社福減免対象のサービスで無い場合
        // [H27.4改正対応][Shinobu Hitaka] 2015/1/20 edit - begin サービスコード英数化
        /*
        //様式第二
        int code_kind =ACCastUtilities.toInt(serviceCode.get("SERVICE_CODE_KIND"));
        switch(code_kind){
        case 11: //様式2-1
        case 15: //様式2-1
        case 21: //様式3-1
        case 24: //様式3-2
        case 51: //様式8
        case 54: //様式8
        case 61: //様式2-2
        case 65: //様式2-2
        case 71: //様式2-1
        case 72: //様式2-1
        case 73: //様式2-1(小規模多機能型居宅介護)
        case 74: //様式2-2
        case 75: //様式2-2
        
        case 76: //様式2-1(定期巡回)
        case 77: //様式2-1(複合型)
            if (patientState.getKohiRatio(targetDate,
                    String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),
                    "1",1,
                    manager.getProviderMedicalFlag(String.valueOf(serviceDetail.get("PROVIDER_ID"))),manager) == 100) {
                //処理を終了する。
                return false;
            }
            return true;
        
//        case 59: //食費・居住費・・・
//            //自己負担額が存在するかで判断
//            if(QP001SpecialCase.getRiyosyaFutan(serviceCode,patientState) != 0){
//                return true;
//            }
//            break;
        }
        */
        String serviceCodeKind =ACCastUtilities.toString(serviceCode.get("SERVICE_CODE_KIND"));
        if ("11".equals(serviceCodeKind) || 	//様式2-1
        	"15".equals(serviceCodeKind) || 	//様式2-1
        	"21".equals(serviceCodeKind) || 	//様式3-1
        	"24".equals(serviceCodeKind) || 	//様式3-2
        	"51".equals(serviceCodeKind) || 	//様式8
        	"54".equals(serviceCodeKind) || 	//様式8
        	"61".equals(serviceCodeKind) || 	//様式2-2
        	"65".equals(serviceCodeKind) || 	//様式2-2
        	"68".equals(serviceCodeKind) || 	//様式2-1(小規模多機能型居宅介護・短期) H27.4改正
        	"69".equals(serviceCodeKind) || 	//様式2-2(予防小規模多機能型居宅介護・短期) H27.4改正
        	"71".equals(serviceCodeKind) || 	//様式2-1
        	"72".equals(serviceCodeKind) || 	//様式2-1
        	"73".equals(serviceCodeKind) || 	//様式2-1(小規模多機能型居宅介護)
        	"74".equals(serviceCodeKind) || 	//様式2-2
        	"75".equals(serviceCodeKind) || 	//様式2-2
        	"76".equals(serviceCodeKind) || 	//様式2-1(定期巡回)
        	"77".equals(serviceCodeKind) || 	//様式2-1(複合型)
        	"79".equals(serviceCodeKind) || 	//様式2-1(複合型・短期) H27.4改正
        	"78".equals(serviceCodeKind) || 	//様式2-1(地域密着型通所) H28.4改正
        	"A1".equals(serviceCodeKind) || 	//様式2-3(総合事業：訪問型) H27.4改正 add 2016.7.22
        	"A5".equals(serviceCodeKind)    	//様式2-3(総合事業：通所型) H27.4改正 add 2016.7.22
        	) {
            if (patientState.getKohiRatio(targetDate,
                    String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),
                    "1",1,
                    manager.getProviderMedicalFlag(String.valueOf(serviceDetail.get("PROVIDER_ID"))),manager) == 100) {
                //処理を終了する。
                return false;
            }
            return true;
        }
        // [H27.4改正対応][Shinobu Hitaka] 2015/1/20 edit - end   サービスコード英数化
        
        return false;
    }
    
    private static String getSerialId(String identificationNo,
            Date targetDate, Object targetServiceDate, VRMap serviceDetail,
            VRMap serviceCode, QP001PatientState patientState) throws Exception {

        StringBuilder serial = new StringBuilder();
        // 交換識別番号
        serial.append(identificationNo);
        // レコード種別コード2桁(02固定)
        serial.append(_901002);
        // サービス提供年月6桁(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // 事業所番号10桁
        serial.append(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
        // 証記載保険者番号8桁
        serial.append(patientState.getInsurerId(targetServiceDate));
        // 被保険者番号10桁
        serial.append(patientState.getInsuredId(targetServiceDate));
        // 軽減率
        serial.append(patientState.getReductionRatio(targetServiceDate, String
                .valueOf(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL",
                        serviceCode))));
        // サービス種類コード
        serial.append(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode));

        return serial.toString();
    }

    /**
     * レコード内容の確定を行う。
     */
    protected void commitRecord(int patientBurden) throws Exception {

        // 受領すべき利用者負担の総額8桁→利用者負担額
        // 集計情報が確定しないとわからないもの。
        set_901009(patientBurden);

        // 軽減額8桁→利用者負担額*軽減率
        //軽減率は入力された値の10倍を返却するので、1000で割る
        set_901010((int) Math.floor((patientBurden * get_901007()) / (100 * 10)));

        // 軽減後利用者負担額8桁→利用者負担額-軽減額
        set_901011(patientBurden - get_901010());

        // 備考20桁
        set_901012("");
    }

    /**
     * データ作成
     * 
     * @param style
     * @return
     */
    protected VRMap getRecord(VRMap style) throws Exception {
        VRMap result = copyStyle(style);

        // 交換情報識別番号4桁
        setData(result, "901001", get_901001());
        // レコード種別コード2桁(12を設定)
        setData(result, "901002", get_901002());
        // サービス提供年月6桁(YYYYMM)
        setData(result, "901003", get_901003());
        // 事業所番号10桁
        setData(result, "901004", get_901004());
        // 証記載保険者番号8桁
        setData(result, "901005", get_901005());
        // 被保険者番号10桁
        setData(result, "901006", get_901006());
        // 軽減率4桁
        setData(result, "901007", get_901007());
        // サービス種類コード2桁
        setData(result, "901008", get_901008());
        // 受領すべき利用者負担の総額8桁
        setData(result, "901009", get_901009());

        // 軽減額8桁
        setData(result, "901010", get_901010());
        //軽減後利用者負担額8桁
        setData(result, "901011", get_901011());
        //備考20桁
        setData(result, "901012", get_901012());
        //		//対象単位数
        //		setData(result,style,"901013",get_901013());

        return result;
    }

    private VRMap copyStyle(VRMap style) {
        VRMap result = new VRHashMap();
        Object key;
        //ディープコピー
        Iterator it = style.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            result.put(key, style.get(key));
        }
        //社会福祉法人軽減額情報レコード
        //result.put("CATEGORY_NO", "9");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_SOCIAL_WELFARE_REDUCE);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[901001=" + get_901001() + "]\n");
        result.append("[901002=" + get_901002() + "]\n");
        result.append("[901003=" + get_901003() + "]\n");
        result.append("[901004=" + get_901004() + "]\n");
        result.append("[901005=" + get_901005() + "]\n");
        result.append("[901006=" + get_901006() + "]\n");
        result.append("[901007=" + get_901007() + "]\n");
        result.append("[901008=" + get_901008() + "]\n");
        result.append("[901009=" + get_901009() + "]\n");
        result.append("[901010=" + get_901010() + "]\n");
        result.append("[901011=" + get_901011() + "]\n");
        result.append("[901012=" + get_901012() + "]\n");
        result.append("[901013=" + get_901013() + "]\n");
        return result.toString();
    }

}
