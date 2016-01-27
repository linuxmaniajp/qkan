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
 * プログラム 特定診療費情報レコード (QP001RecordDiagnosis)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;//add 20140210

/**
 * 特定診療費情報レコード
 * 
 */
public class QP001RecordDiagnosis extends QP001RecordAbstract {

    // 交換情報識別番号4桁
    private String _501001 = "";

    // レコード種別コード2桁
    private static final String _501002 = "04";

    // サービス提供年月6桁(YYYYMM)
    private String _501003 = "";

    // 事業所番号10桁
    private String _501004 = "";

    // 証記載保険者番号8桁
    private String _501005 = "";

    // 被保険者番号10桁
    private String _501006 = "";

    // 特定診療費情報レコード順次番号2桁
    private int _501007 = 0;

    // 傷病名40桁
    private String _501008 = "";

    // 識別番号2桁-特定診療費の識別番号
    private String _501009 = "";

    // 単位数4桁
    private int _501010 = 0;

    // (保険)回数2桁
    private int _501011 = 0;

    // (保険)サービス単位数6桁
    private int _501012 = 0;

    // (保険)合計単位数8桁
    private int _501013 = 0;

    // (公費1)回数2桁
    private int _501014 = 0;

    // (公費1)サービス単位数6桁
    private int _501015 = 0;

    // (公費1)合計単位数8桁
    private int _501016 = 0;

    // (公費2)回数2桁
    private int _501017 = 0;

    // (公費2)サービス単位数6桁
    private int _501018 = 0;

    // (公費2)合計単位数8桁
    private int _501019 = 0;

    // (公費3)回数2桁
    private int _501020 = 0;

    // (公費3)サービス単位数6桁
    private int _501021 = 0;

    // (公費3)合計単位数8桁
    private int _501022 = 0;

    // 摘要100桁
    private String _501023 = "";

    // 公費１公費タイプ
    private String _501024 = "";

    // 公費２公費タイプ
    private String _501025 = "";

    // 公費３公費タイプ
    private String _501026 = "";

    // システム内サービス種類コード
    private String _501027 = "";

    // 公費順位決定オブジェクト
    private QP001RecordSupporter kohiManager = new QP001RecordSupporter();

    protected String getSerialId() {
        // TODO 自動生成されたメソッド・スタブ
        return null;
    }

    /**
     * レコード種別コード2桁を取得する。
     * 
     * @return
     */
    protected static String get_501002() {
        return _501002;
    }

    /**
     * 交換情報識別番号4桁を取得する。
     * 
     * @return
     */
    protected String get_501001() {
        return _501001;
    }

    /**
     * 交換情報識別番号4桁を設定する。
     * 
     * @param _501001
     */
    protected void set_501001(String _501001) {
        this._501001 = _501001;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を取得する。
     * 
     * @return
     */
    protected String get_501003() {
        return _501003;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を設定する。
     * 
     * @param _501003
     */
    protected void set_501003(String _501003) {
        this._501003 = _501003;
    }

    /**
     * 事業所番号10桁を取得する。
     * 
     * @return
     */
    protected String get_501004() {
        return _501004;
    }

    /**
     * 事業所番号10桁を設定する。
     * 
     * @param _501004
     */
    protected void set_501004(String _501004) {
        this._501004 = _501004;
    }

    /**
     * 証記載保険者番号8桁を取得する。
     * 
     * @return
     */
    protected String get_501005() {
        return _501005;
    }

    /**
     * 証記載保険者番号8桁を設定する。
     * 
     * @param _501005
     */
    protected void set_501005(String _501005) {
        this._501005 = _501005;
    }

    /**
     * 被保険者番号10桁を取得する。
     * 
     * @return
     */
    protected String get_501006() {
        return _501006;
    }

    /**
     * 被保険者番号10桁を設定する。
     * 
     * @param _501006
     */
    protected void set_501006(String _501006) {
        this._501006 = _501006;
    }

    /**
     * 特定診療費情報レコード順次番号2桁を取得する。
     */
    protected int get_501007() {
        return _501007;
    }

    /**
     * 特定診療費情報レコード順次番号2桁を設定する。
     * 
     * @param _501007
     */
    protected void set_501007(int _501007) {
        this._501007 = _501007;
    }

    /**
     * 傷病名40桁を取得する。
     * 
     * @return
     */
    protected String get_501008() {
        return _501008;
    }

    /**
     * 傷病名40桁を設定する。
     * 
     * @param _501008
     */
    protected void set_501008(String _501008) {
        this._501008 = _501008;
    }

    /**
     * 識別番号2桁-特定診療費の識別番号を取得する。
     * 
     * @return
     */
    protected String get_501009() {
        return _501009;
    }

    /**
     * 識別番号2桁-特定診療費の識別番号を設定する。
     * 
     * @param _501009
     */
    protected void set_501009(String _501009) {
        this._501009 = _501009;
    }

    /**
     * 単位数4桁を取得する。
     * 
     * @return
     */
    protected int get_501010() {
        return _501010;
    }

    /**
     * 単位数4桁を設定する。
     * 
     * @param _501010
     */
    protected void set_501010(int _501010) {
        this._501010 = _501010;
    }

    /**
     * (保険)回数2桁を取得する。
     * 
     * @return
     */
    protected int get_501011() {
        return _501011;
    }

    /**
     * (保険)回数2桁を設定する。
     * 
     * @param _501011
     */
    protected void set_501011(int _501011) {
        this._501011 = _501011;
    }

    /**
     * (保険)サービス単位数6桁を取得する。
     * 
     * @return
     */
    protected int get_501012() {
        return _501012;
    }

    /**
     * (保険)サービス単位数6桁を設定する。
     * 
     * @param _501012
     */
    protected void set_501012(int _501012) {
        this._501012 = _501012;
    }

    /**
     * (保険)合計単位数8桁を取得する。
     * 
     * @return
     */
    protected int get_501013() {
        return _501013;
    }

    /**
     * (保険)合計単位数8桁を設定する。
     * 
     * @param _501013
     */
    protected void set_501013(int _501013) {
        this._501013 = _501013;
    }

    /**
     * (公費1)回数2桁を取得する。
     * 
     * @return
     */
    protected int get_501014() {
        return _501014;
    }

    /**
     * (公費1)回数2桁を設定する。
     */
    protected void set_501014(int _501014) {
        this._501014 = _501014;
    }

    /**
     * (公費1)サービス単位数6桁を取得する。
     * 
     * @return
     */
    protected int get_501015() {
        return _501015;
    }

    /**
     * (公費1)サービス単位数6桁を設定する。
     * 
     * @param _501015
     */
    protected void set_501015(int _501015) {
        this._501015 = _501015;
    }

    /**
     * (公費1)合計単位数8桁を取得する。
     * 
     * @return
     */
    protected int get_501016() {
        return _501016;
    }

    /**
     * (公費1)合計単位数8桁を設定する。
     * 
     * @param _501016
     */
    protected void set_501016(int _501016) {
        this._501016 = _501016;
    }

    /**
     * (公費2)回数2桁を取得する。
     * 
     * @return
     */
    protected int get_501017() {
        return _501017;
    }

    /**
     * (公費2)回数2桁を設定する。
     * 
     * @param _501017
     */
    protected void set_501017(int _501017) {
        this._501017 = _501017;
    }

    /**
     * (公費2)サービス単位数6桁を取得する。
     * 
     * @return
     */
    protected int get_501018() {
        return _501018;
    }

    /**
     * (公費2)サービス単位数6桁を設定する。
     * 
     * @param _501018
     */
    protected void set_501018(int _501018) {
        this._501018 = _501018;
    }

    /**
     * (公費2)合計単位数8桁を取得する。
     * 
     * @return
     */
    protected int get_501019() {
        return _501019;
    }

    /**
     * (公費2)合計単位数8桁を設定する。
     */
    protected void set_501019(int _501019) {
        this._501019 = _501019;
    }

    /**
     * (公費3)回数2桁を取得する。
     * 
     * @return
     */
    protected int get_501020() {
        return _501020;
    }

    /**
     * (公費3)回数2桁を設定する。
     * 
     * @param _501020
     */
    protected void set_501020(int _501020) {
        this._501020 = _501020;
    }

    /**
     * (公費3)サービス単位数6桁を取得する。
     * 
     * @return
     */
    protected int get_501021() {
        return _501021;
    }

    /**
     * (公費3)サービス単位数6桁を設定する。
     * 
     * @param _501021
     */
    protected void set_501021(int _501021) {
        this._501021 = _501021;
    }

    /**
     * (公費3)合計単位数8桁を取得する。
     * 
     * @return
     */
    protected int get_501022() {
        return _501022;
    }

    /**
     * (公費3)合計単位数8桁を設定する。
     * 
     * @param _501022
     */
    protected void set_501022(int _501022) {
        this._501022 = _501022;
    }

    /**
     * 摘要100桁を取得する。
     * 
     * @return
     */
    protected String get_501023() {
        return _501023;
    }

    /**
     * 摘要100桁を設定する。
     * 
     * @param _501023
     */
    protected void set_501023(String _501023) {
        this._501023 = _501023;
    }

    /**
     * 公費１公費タイプを取得する。
     * 
     * @return
     */
    protected String get_501024() {
        return _501024;
    }

    /**
     * 公費１公費タイプを設定する。
     * 
     * @param _501024
     */
    protected void set_501024(String _501024) {
        this._501024 = _501024;
    }

    /**
     * 公費２公費タイプを取得する。
     * 
     * @return
     */
    protected String get_501025() {
        return _501025;
    }

    /**
     * 公費２公費タイプを設定する。
     * 
     * @param _501025
     */
    protected void set_501025(String _501025) {
        this._501025 = _501025;
    }

    /**
     * 公費３公費タイプを取得する。
     * 
     * @return
     */
    protected String get_501026() {
        return _501026;
    }

    /**
     * 公費３公費タイプを設定する。
     * 
     * @param _501026
     */
    protected void set_501026(String _501026) {
        this._501026 = _501026;
    }

    /**
     * システム内サービス種類コードを取得する。
     * 
     * @return
     */
    protected String get_501027() {
        return _501027;
    }

    /**
     * システム内サービス種類コードを設定する。
     * 
     * @param _501026
     */
    protected void set_501027(String _501027) {
        this._501027 = _501027;
    }

    protected VRMap getKohiList() {
        return this.kohiManager.getKohiList();
    }

    protected VRList getRealDays() {
        return this.kohiManager.getRealDays();
    }

// 2015/5/12 [Yoichiro Kamei] mod - begin 公費関連見直し：使用していないのでコメント化
//    protected VRMap getKohiPattern() {
//        return this.kohiManager.getKohiPattern();
//    }
// 2015/5/12 [Yoichiro Kamei] mod - end
    /**
     * 既に情報が登録されているか返却します。
     * 
     * @return 新規:true 追加:false
     */
    private boolean isNew() {
        // 交換情報レコードに登録が無ければ新規とみなす。
        return ((get_501001() == null) || ("".equals(get_501001())));
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
    //
    /*[H20.5 法改正対応] fujihara edit start
    protected void parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,
            String identificationNo, String specialClinicType,int count,QP001Manager manager) throws Exception {
    */
    protected void parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,
            String identificationNo, String specialClinicType,int count,QP001Manager manager, int recordType) throws Exception {
    //[H20.5 法改正対応] fujihara edit end

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);

        if (isNew()) {
            // diagnosis の KEY : 501001(交換情報識別番号) に VALUE : 第６引数を設定する。
            set_501001(identificationNo);

            // diagnosis の KEY : 501003(サービス提供年月) に
            // VALUE : yyyyMM形式にフォーマットしたtargetDateを設定する。
            set_501003(VRDateParser.format(targetDate, "yyyyMM"));

            // diagnosis の KEY : 501004(事業所番号) に
            // VALUE : 10桁フォーマットした事業所番号(serviceDetailより取得)を設定する。
            set_501004(ACCastUtilities.toString(VRBindPathParser.get(
                    "PROVIDER_ID", serviceDetail)));

            // diagnosis の KEY : 501005(証記載保険者番号) に
            // VALUE : 8桁フォーマットした利用者の保険者番号(patientより取得)を設定する。
            set_501005(patientState.getInsurerId(targetServiceDate));

            // diagnosis の KEY : 501006(被保険者番号) に
            // VALUE : 10桁フォーマットした利用者の被保険者番号(patientより取得)を設定する。
            set_501006(patientState.getInsuredId(targetServiceDate));

            // diagnosis の KEY : 501010(単位数) に VALUE :
            // 共通関数(getSpecialClinicInfo)で取得した値を設定する。
            //[ID:0000454][Shin Fujihara] 2009/05/01 edit begin 障害対応
            //set_501010(QP001Manager.getInstance().getSpecialClinicUnit(specialClinicType));
            //[H20.5 法改正対応] fujihara edit start
            //set_501010(manager.getSpecialClinicUnit(specialClinicType));
            //set_501010(manager.getSpecialClinicUnit(specialClinicType,recordType));
            //[H20.5 法改正対応] fujihara edit end
            set_501010(manager.getSpecialClinicUnit(specialClinicType,recordType,get_501003()));
            //[ID:0000454][Shin Fujihara] 2009/05/01 edit end 障害対応
            
            // diagnosis の KEY : 501011((保険)回数) にカウントを設定する。
            set_501011(count);

            // システム内サービス種類コードを設定する。
            set_501027(ACCastUtilities.toString(VRBindPathParser.get(
                    "SYSTEM_SERVICE_KIND_DETAIL", serviceCode)));

        } else {
            set_501011(get_501011() + count);
        }

        // 公費順位の登録を行う。
//        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, get_501027(),
//                "3", get_501010(),QP001Manager.getInstance().getProviderMedicalFlag(get_501004()),count);
//        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, serviceCode,
//                "3", get_501010(),QP001Manager.getInstance().getProviderMedicalFlag(get_501004()),count);
        kohiManager.setExtraData(targetServiceDate,serviceDetail, patientState, serviceCode,
                "3", get_501010(),manager.getProviderMedicalFlag(get_501004()),count,manager);

    }
    
    
    /**
     * システム内サービス種類コード別での仮集計実行
     * @param kohi
     * @param patientState
     * @throws Exception
     */
    protected void commitRecord(QP001KohiKey[] kohi, QP001PatientState patientState) throws Exception {
        
        boolean kohiLimit = false;
        
        // (保険)サービス単位数6桁(単位数*回数)
        set_501012(get_501010() * get_501011());
        // 公費１公費タイプ
        if ((kohi[0] != null) && (!"".equals(kohi[0].getKohiType()))) {
            set_501024(kohi[0].getKohiType());
        }
        
        // 公費２公費タイプ
        if ((kohi[1] != null) && (!"".equals(kohi[1].getKohiType()))) {
            set_501025(kohi[1].getKohiType());
        }
        
        // 公費３公費タイプ
        if ((kohi[2] != null) && (!"".equals(kohi[2].getKohiType()))) {
            set_501026(kohi[2].getKohiType());
        }
        

        // 公費１の適用があるか確認
        if ((kohi[0] != null) && (!"".equals(kohi[0].getKohiType()))) {
            
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start 老健の一部公費対象の対応
            //老健の一部公費対象（88,87,66）の場合は公費設定をしない
            //以下IF文を追加
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[0].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   老健の一部公費対象の対応
                
                // 適用がある場合
                // 公費１対象日数を設定する。
                set_501014(kohiManager.getKohiCount(kohi[0]));
                // (公費1)サービス単位数6桁
                set_501015(get_501010() * get_501014());
                
                // 給付率が100%になったら処理を終了する。
                kohiLimit = (ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1)) == 100);
            
            }
        }
        // 公費２の適用があるか確認
        if ((!kohiLimit) && (kohi[1] != null) && (!"".equals(kohi[1].getKohiType()))) {
            
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start 老健の一部公費対象の対応
            //老健の一部公費対象（88,87,66）の場合は公費設定をしない
            //以下IF文を追加
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[1].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   老健の一部公費対象の対応
                
                // 適用がある場合
                // 公費２対象日数を設定する。
                set_501017(kohiManager.getKohiCount(kohi[1]));
                // (公費2)サービス単位数6桁
                set_501018(get_501010() * get_501017());
                
                // 給付率が100%になったら処理を終了する。
                kohiLimit = (ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1)) == 100);
            
            }
            
        }
        // 公費３の適用があるか確認
        if ((!kohiLimit) && (kohi[2] != null) && (!"".equals(kohi[2].getKohiType()))) {
            
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start 老健の一部公費対象の対応
            //老健の一部公費対象（88,87,66）の場合は公費設定をしない
            //以下IF文を追加
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[2].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   老健の一部公費対象の対応
                
                // 適用がある場合
                // 公費３対象日数を設定する。
                set_501020(kohiManager.getKohiCount(kohi[2]));
                // (公費3)サービス単位数6桁
                set_501021(get_501010() * get_501020());
                
            }
        }
        
    }

    /**
     * レコード内容の確定を行う。
     */
    protected void commitRecord(QP001KohiKey[] kohi, int count,QP001PatientState patientState) throws Exception {
        boolean kohiLimit = false;
        
        set_501007(count);
        
        // (保険)サービス単位数6桁(単位数*回数)
        set_501012(get_501010() * get_501011());
        // 公費１公費タイプ
        if ((kohi[0] != null) && (!"".equals(kohi[0].getKohiType()))) {
            set_501024(kohi[0].getKohiType());
        }
        
        // 公費２公費タイプ
        if ((kohi[1] != null) && (!"".equals(kohi[1].getKohiType()))) {
            set_501025(kohi[1].getKohiType());
        }
        
        // 公費３公費タイプ
        if ((kohi[2] != null) && (!"".equals(kohi[2].getKohiType()))) {
            set_501026(kohi[2].getKohiType());
        }
        

        // 公費１の適用があるか確認
        if ((kohi[0] != null) && (!"".equals(kohi[0].getKohiType()))) {
            
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start 老健の一部公費対象の対応
            //老健の一部公費対象（88,87,66）の場合は公費設定をしない
            //以下IF文を追加
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[0].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   老健の一部公費対象の対応
                
                // 適用がある場合
                // (公費1)サービス単位数6桁
                set_501015(get_501010() * get_501014());
                
                // 給付率が100%になったら処理を終了する。
                kohiLimit = (ACCastUtilities.toInt(patientState.getKohiData(kohi[0],"BENEFIT_RATE",1)) == 100);

            }
        }
        // 公費２の適用があるか確認
        if ((!kohiLimit) && (kohi[1] != null) && (!"".equals(kohi[1].getKohiType()))) {

            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start 老健の一部公費対象の対応
            //老健の一部公費対象（88,87,66）の場合は公費設定をしない
            //以下IF文を追加
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[1].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   老健の一部公費対象の対応
                
                // 適用がある場合
                // (公費2)サービス単位数6桁
                set_501018(get_501010() * get_501017());
                
                // 給付率が100%になったら処理を終了する。
                kohiLimit = (ACCastUtilities.toInt(patientState.getKohiData(kohi[1],"BENEFIT_RATE",1)) == 100);
            
            }
        }
        // 公費３の適用があるか確認
        if ((!kohiLimit) && (kohi[2] != null) && (!"".equals(kohi[2].getKohiType()))) {

            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - start 老健の一部公費対象の対応
            //老健の一部公費対象（88,87,66）の場合は公費設定をしない
            //以下IF文を追加
            if (!CareServiceCommon.isKouhiSystemService(get_501027(), kohi[2].getKohiType())) {
            //[CCCX:1470][Shinobu Hitaka] 2014/02/10 edit - end   老健の一部公費対象の対応
                
                // 適用がある場合
                // (公費3)サービス単位数6桁
                set_501021(get_501010() * get_501020());
                
            }
        }
        
        //摘要欄の設定を行う。
        //薬剤管理指導の場合
        if("09".equals(get_501009()) || "9".equals(get_501009())){
            
            //日付を並べなおす
            ArrayList ary = new ArrayList();
            for(int i = 0; i < kohiManager.getRealDays().size(); i++){
                Integer day = new Integer(ACDateUtilities.getDayOfMonth(ACCastUtilities.toDate(kohiManager.getRealDays().get(i))));
                if(!ary.contains(day)){
                    ary.add(day);
                }
            }
            
            Object[] oa = ary.toArray();
            Arrays.sort(oa);
            StringBuilder tekiyoTemp = new StringBuilder();
            
            for(int i = 0; i < oa.length; i++){
                if(tekiyoTemp.length() != 0){
                	//簡易入力にあわせる
                    //tekiyoTemp.append("、");
                	tekiyoTemp.append("，");
                }
                //全角で設定しないと返礼になる。
                //tekiyoTemp.append(String.valueOf(oa[i]));
                tekiyoTemp.append(QP001Util.toWideNumber(oa[i]));
            }
            set_501023(tekiyoTemp.toString());
        }
        
        //傷病名引継ぎ対応
        //レコード順次番号が1の場合は傷病名を設定する。
        if(get_501007() == 1){
        	set_501008(patientState.getLastRecapitulationCategory5(get_501001()));
        }
        //摘要欄引継ぎ対応
        //重度診療管理・短期集中リハビリ加算
        if("35".equals(get_501009()) || "52".equals(get_501009())){
        	set_501023(patientState.getLastRecapitulationCategory5(get_501001(),get_501009()));
        }
    }

    /**
     * レコード順次番号99の集計を行う。
     * 
     * @param diagnosisMap
     * @throws Exception
     */
    protected void commitRecord(Map diagnosisMap,QP001PatientState patientState) throws Exception {
        QP001RecordDiagnosis diagnosis = null;
        // 識別レコードを99に変更
        set_501007(99);
        Iterator it = diagnosisMap.keySet().iterator();
        while (it.hasNext()) {
            diagnosis = (QP001RecordDiagnosis) diagnosisMap.get(it.next());
            // (保険)合計単位数8桁
            set_501013(get_501013() + diagnosis.get_501012());
            // (公費1)合計単位数8桁
            set_501016(get_501016() + diagnosis.get_501015());
            // (公費2)合計単位数8桁
            set_501019(get_501019() + diagnosis.get_501018());
            // (公費3)合計単位数8桁
            set_501022(get_501022() + diagnosis.get_501021());
        }
    }
    
    protected void merge(QP001RecordDiagnosis target) throws Exception {
        
        // (保険)回数2桁
        set_501011(get_501011() + target.get_501011());
        // (公費1)回数2桁
        set_501014(get_501014() + target.get_501014());
        // (公費2)回数2桁
        set_501017(get_501017() + target.get_501017());
        //(公費3)回数2桁
        set_501020(get_501020() + target.get_501020());
        
        //公費情報のマージ
        kohiManager.getRealDays().addAll(target.getRealDays());
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
        setData(result, "501001", get_501001());
        // レコード種別コード2桁(04を設定)
        setData(result, "501002", get_501002());
        // サービス提供年月6桁(YYYYMM)
        setData(result, "501003", get_501003());
        // 事業所番号10桁
        setData(result, "501004", get_501004());
        // 証記載保険者番号8桁
        setData(result, "501005", get_501005());
        // 被保険者番号10桁
        setData(result, "501006", get_501006());
        // 特定診療費情報レコード順次番号2桁
        setData(result, "501007", get_501007());
        // 傷病名40桁
        setData(result, "501008", get_501008());
        // 識別番号2桁特定診療費の識別番号
        setData(result, "501009", get_501009());

        // 単位数4桁
        setData(result, "501010", get_501010());
        // (保険)回数2桁
        setData(result, "501011", get_501011());
        // (保険)サービス単位数6桁
        setData(result, "501012", get_501012());
        // (保険)合計単位数8桁
        setData(result, "501013", get_501013());
        // (公費1)回数2桁
        setData(result, "501014", get_501014());
        // (公費1)サービス単位数6桁
        setData(result, "501015", get_501015());
        // (公費1)合計単位数8桁
        setData(result, "501016", get_501016());
        // (公費2)回数2桁
        setData(result, "501017", get_501017());
        // (公費2)サービス単位数6桁
        setData(result, "501018", get_501018());
        //(公費2)合計単位数8桁
        setData(result, "501019", get_501019());

        //(公費3)回数2桁
        setData(result, "501020", get_501020());
        //(公費3)サービス単位数6桁
        setData(result, "501021", get_501021());
        //(公費3)合計単位数8桁
        setData(result, "501022", get_501022());
        //摘要100桁
        setData(result, "501023", get_501023());
        /*
         //公費１公費タイプ
         setData(result,"501024",get_501024());
         //公費２公費タイプ
         setData(result,"501025",get_501025());
         //公費３公費タイプ
         setData(result,"501026",get_501026());
         */
        //		setData(result,style,"501027",get_501027());
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
        //特定診療費情報レコード
        //result.put("CATEGORY_NO", "5");
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_RECORD_SPECIAL_TREATMENT);
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("[501001=" + get_501001() + "]\n");
        result.append("[501002=" + get_501002() + "]\n");
        result.append("[501003=" + get_501003() + "]\n");
        result.append("[501004=" + get_501004() + "]\n");
        result.append("[501005=" + get_501005() + "]\n");
        result.append("[501006=" + get_501006() + "]\n");
        result.append("[501007=" + get_501007() + "]\n");
        result.append("[501008=" + get_501008() + "]\n");
        result.append("[501009=" + get_501009() + "]\n");

        result.append("[501010=" + get_501010() + "]\n");
        result.append("[501011=" + get_501011() + "]\n");
        result.append("[501012=" + get_501012() + "]\n");
        result.append("[501013=" + get_501013() + "]\n");
        result.append("[501014=" + get_501014() + "]\n");
        result.append("[501015=" + get_501015() + "]\n");
        result.append("[501016=" + get_501016() + "]\n");
        result.append("[501017=" + get_501017() + "]\n");
        result.append("[501018=" + get_501018() + "]\n");
        result.append("[501019=" + get_501019() + "]\n");

        result.append("[501020=" + get_501020() + "]\n");
        result.append("[501021=" + get_501021() + "]\n");
        result.append("[501022=" + get_501022() + "]\n");
        result.append("[501023=" + get_501023() + "]\n");
        result.append("[501024=" + get_501024() + "]\n");
        result.append("[501025=" + get_501025() + "]\n");
        result.append("[501026=" + get_501026() + "]\n");

        return result.toString();
    }

}
