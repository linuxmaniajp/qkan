
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
 * プログラム 様式第十一レコード (QP001RecordCareSupplyClaim)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 介護給付費請求書情報レコード
 *
 */
public class QP001RecordCareSupplyClaim extends QP001RecordAbstract {

    // 交換情報識別番号4桁(7111固定)
    private String _101001 = "7111";

    // サービス提供年月6桁(YYYYMM)
    private String _101002 = "";

    // 事業所番号10桁
    private String _101003 = "";

    // 保険・公費等区分コード1桁 1-保険請求 2-公費請求
    private int _101004 = 0;

    // 法別番号2桁※保険請求分の場合は0
    private String _101005 = "";

    // 請求情報区分コード2桁 法別番号=0 OR 12→01-居宅・施設サービス 02-居宅介護支援 法別番号=それ以外→0固定
    private String _101006 = "";

    // (サービス費用)件数6桁
//    private int _101007 = 0;
    private VRMap _101007 = new VRHashMap();

    // (サービス費用)単位数11桁
    private int _101008 = 0;

    // (サービス費用)費用合計12桁
    private int _101009 = 0;

    // (サービス費用)保険請求額12桁
    private int _101010 = 0;

    // (サービス費用)公費請求額12桁
    private int _101011 = 0;

    // (サービス費用)利用者負担12桁
    private int _101012 = 0;

    // (特定入所者介護サービス費等)件数6桁
    private int _101013 = 0;

    // (特定入所者護サービス費等)延べ日数8桁
    private int _101014 = 0;

    // (特定入所者介護サービス費等)費用合計12桁
    private int _101015 = 0;

    // (特定入所者介護サービス費等)利用者負担12桁
    private int _101016 = 0;

    // (特定入所者介護サービス費等)公費請求額12桁
    private int _101017 = 0;

    // (特定入所者介サービス費等)保険請求額12桁
    private int _101018 = 0;

    protected String getSerialId() {
        return null;
    }

    /**
     * 交換情報識別番号4桁(7111固定)を取得する。
     * 
     * @return
     */
    protected String get_101001() {
        return _101001;
    }

    /**
     * 交換情報識別番号4桁(7111固定)を設定する。
     * 
     * @param _101001
     */
    protected void set_101001(String _101001) {
        this._101001 = _101001;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を取得する。
     * 
     * @return
     */
    protected String get_101002() {
        return _101002;
    }

    /**
     * サービス提供年月6桁(YYYYMM)を設定する。
     * 
     * @param _101002
     */
    protected void set_101002(String _101002) {
        this._101002 = _101002;
    }

    /**
     * 事業所番号10桁を取得する。
     * 
     * @return
     */
    protected String get_101003() {
        return _101003;
    }

    /**
     * 事業所番号10桁を設定する。
     * 
     * @param _101003
     */
    protected void set_101003(String _101003) {
        this._101003 = _101003;
    }

    /**
     * 保険・公費等区分コード1桁 1-保険請求 2-公費請求を取得する。
     * 
     * @return
     */
    protected int get_101004() {
        return _101004;
    }

    /**
     * 保険・公費等区分コード1桁 1-保険請求 2-公費請求を設定する。
     * 
     * @param _101004
     */
    protected void set_101004(int _101004) {
        this._101004 = _101004;
    }

    /**
     * 法別番号2桁※保険請求分の場合は0を取得する。
     * 
     * @return
     */
    protected String get_101005() {
        return _101005;
    }

    /**
     * 法別番号2桁※保険請求分の場合は0を設定する。
     * 
     * @param _101005
     */
    protected void set_101005(String _101005) {
        this._101005 = _101005;
    }

    /**
     * 請求情報区分コード2桁 法別番号=0 OR 12→01-居宅・施設サービス 02-居宅介護支援 法別番号=それ以外→0固定 を取得する。
     */
    protected String get_101006() {
        return _101006;
    }

    /**
     * 請求情報区分コード2桁 法別番号=0 OR 12→01-居宅・施設サービス 02-居宅介護支援 法別番号=それ以外→0固定 を設定する。
     * 
     * @param _101006
     */
    protected void set_101006(String _101006) {
        this._101006 = _101006;
    }

    /**
     * (サービス費用)件数6桁を取得する。
     * 
     * @return
     */
    protected int get_101007() {
        return _101007.size();
    }

//    /**
//     * (サービス費用)件数6桁を設定する。
//     * 
//     * @param _101007
//     */
//    protected void set_101007(int _101007) {
//        this._101007 = _101007;
//    }
    /**
     * (サービス費用)件数6桁を設定する。
     * 
     * @param _101007
     */
    // [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010年度対応
//    protected void set_101007(Object identification, Object patient_id) {
//        _101007.put(String.valueOf(identification) + "-" + String.valueOf(patient_id),null);
//    }
    protected void set_101007(Object identification, Object insurer_id ,Object patient_id) {
        _101007.put(String.valueOf(identification) + "-" + insurer_id + "-" + String.valueOf(patient_id),null);
    }
    // [ID:0000622][Shin Fujihara] 2010/11 edit end 2010年度対応
    /**
     * (サービス費用)単位数11桁を取得する。
     * 
     * @return
     */
    protected int get_101008() {
        return _101008;
    }

    /**
     * (サービス費用)単位数11桁を設定する。
     * 
     * @param _101008
     */
    protected void set_101008(int _101008) {
        this._101008 = _101008;
    }

    /**
     * (サービス費用)費用合計12桁を取得する。
     * 
     * @return
     */
    protected int get_101009() {
        return _101009;
    }

    /**
     * (サービス費用)費用合計12桁を設定する。
     * 
     * @param _101009
     */
    protected void set_101009(int _101009) {
        this._101009 = _101009;
    }

    /**
     * (サービス費用)保険請求額12桁を取得する。
     * 
     * @return
     */
    protected int get_101010() {
        return _101010;
    }

    /**
     * ` (サービス費用)保険請求額12桁を設定する。
     * 
     * @param _101010
     */
    protected void set_101010(int _101010) {
        this._101010 = _101010;
    }

    /**
     * (サービス費用)公費請求額12桁を取得する。
     * 
     * @return
     */
    protected int get_101011() {
        return _101011;
    }

    /**
     * (サービス費用)公費請求額12桁を設定する。
     * 
     * @param _101011
     */
    protected void set_101011(int _101011) {
        this._101011 = _101011;
    }

    /**
     * (サービス費用)利用者負担12桁を取得する。
     * 
     * @return
     */
    protected int get_101012() {
        return _101012;
    }

    /**
     * (サービス費用)利用者負担12桁を設定する。
     * 
     * @param _101012
     */
    protected void set_101012(int _101012) {
        this._101012 = _101012;
    }

    /**
     * (特定入所者介護サービス費等)件数6桁を取得する。
     * 
     * @return
     */
    protected int get_101013() {
        return _101013;
    }

    /**
     * (特定入所者介護サービス費等)件数6桁を設定する。
     * 
     * @param _101013
     */
    protected void set_101013(int _101013) {
        this._101013 = _101013;
    }

    /**
     * (特定入所者護サービス費等)延べ日数8桁を取得する。
     * 
     * @return
     */
    protected int get_101014() {
        return _101014;
    }

    /**
     * (特定入所者護サービス費等)延べ日数8桁を設定する。
     * 
     * @param _101014
     */
    protected void set_101014(int _101014) {
        this._101014 = _101014;
    }

    /**
     * (特定入所者介護サービス費等)費用合計12桁を取得する。
     * 
     * @return
     */
    protected int get_101015() {
        return _101015;
    }

    /**
     * (特定入所者介護サービス費等)費用合計12桁を設定する。
     * 
     * @param _101015
     */
    protected void set_101015(int _101015) {
        this._101015 = _101015;
    }

    /**
     * (特定入所者介護サービス費等)利用者負担12桁を取得する。
     * 
     * @return
     */
    protected int get_101016() {
        return _101016;
    }

    /**
     * (特定入所者介護サービス費等)利用者負担12桁を設定する。
     * 
     * @param _101016
     */
    protected void set_101016(int _101016) {
        this._101016 = _101016;
    }

    /**
     * (特定入所者介護サービス費等)公費請求額12桁を取得する。
     * 
     * @return
     */
    protected int get_101017() {
        return _101017;
    }

    /**
     * (特定入所者介護サービス費等)公費請求額12桁を設定する。
     * 
     * @param _101017
     */
    protected void set_101017(int _101017) {
        this._101017 = _101017;
    }

    /**
     * (特定入所者介サービス費等)保険請求額12桁を取得する。
     * 
     * @return
     */
    protected int get_101018() {
        return _101018;
    }

    /**
     * (特定入所者介サービス費等)保険請求額12桁を設定する。
     * 
     * @param _101018
     */
    protected void set_101018(int _101018) {
        this._101018 = _101018;
    }

    
    public boolean isNew() throws Exception {
        if(ACTextUtilities.isNullText(get_101002())){
            return true;
        }
        return false;
    }
    
    /**
     * データのパースを実行します。
     * @param base
     * @param recordKubun 1-保険請求 2-公費請求
     * @param lawNo 法別番号　※保険請求は0
     * @param kubun
     * @throws Exception
     */
    protected void parse(VRMap base,int recordKubun, String lawNo, String kubun) throws Exception {

        // 基本情報レコードの値から介護給付費請求書のレイアウトに変更する。
        // サービス提供年月
        set_101002(String.valueOf(base.get("201003")));
        // 事業所番号
        set_101003(String.valueOf(base.get("201004")));
        // 保険・公費区分レコード
        // 1-保険請求 2-公費請求
        set_101004(recordKubun);
        
        // 法別番号2桁※保険請求分の場合は0
        set_101005(lawNo);

        // 請求情報区分コード2桁
        // 法別番号=0 OR 12→01-居宅・施設サービス 02-居宅介護支援 法別番号=それ以外→0固定
        // 【解説】
        // 保険請求、または公費請求で法別番号が12(生保)の場合→01-居宅・施設サービス 02-居宅介護支援
        // 公費請求で法別番号が12以外の場合→0固定
        set_101006(kubun);

        // (サービス費用)件数6桁を設定する。
        //set_101007(get_101007() + 1);
        // [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010年度対応
        //set_101007(base.get("201001"),base.get("201006"));
        set_101007(base.get("201001"), base.get("201005"), base.get("201006"));
        // [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010年度対応

        // (サービス費用)単位数11桁を設定する。
        set_101008(get_101008()
                + ACCastUtilities.toInt(base.get("201033"), 0));

        // (サービス費用)保険請求額12桁を設定する。
        set_101010(get_101010()
                + ACCastUtilities.toInt(base.get("201034"), 0) //(合計情報 保険)請求額9桁
                + ACCastUtilities.toInt(base.get("201036"), 0) //(合計情報 保険)緊急時施設療養費請求額9桁
                + ACCastUtilities.toInt(base.get("201037"), 0));//(合計情報 保険)特定診療費請求額9桁

        // (サービス費用)公費請求額12桁を設定する。
        set_101011(get_101011()
                + ACCastUtilities.toInt(base.get("201040"), 0) // 公費１
                + ACCastUtilities.toInt(base.get("201046"), 0) // 公費２
                + ACCastUtilities.toInt(base.get("201052"), 0) // 公費３
                
                + ACCastUtilities.toInt(base.get("201042"), 0) //(合計情報 公費1)緊急時施設療養費請求額8桁
                + ACCastUtilities.toInt(base.get("201048"), 0) //(合計情報 公費2)緊急時施設療養費請求額8桁
                + ACCastUtilities.toInt(base.get("201054"), 0) //(合計情報 公費3)緊急時施設療養費請求額8桁
                
                + ACCastUtilities.toInt(base.get("201043"), 0) //(合計情報 公費1)特定診療費請求額8桁
                + ACCastUtilities.toInt(base.get("201049"), 0) //(合計情報 公費2)特定診療費請求額8桁
                + ACCastUtilities.toInt(base.get("201055"), 0) //(合計情報 公費3)特定診療費請求額8桁
        );

        // (サービス費用)利用者負担12桁を設定する。
        set_101012(get_101012()
                + ACCastUtilities.toInt(base.get("201035"), 0) //保険分利用者負担額
                + ACCastUtilities.toInt(base.get("201041"), 0) //(合計情報 公費1)本人負担額8桁
                + ACCastUtilities.toInt(base.get("201047"), 0) //(合計情報 公費2)本人負担額8桁
                + ACCastUtilities.toInt(base.get("201053"), 0) //(合計情報 公費3)本人負担額8桁
                );
        
        // (サービス費用)費用合計12桁を設定する。
        //保険請求額+公費請求額+利用者負担額
        set_101009(get_101010() + get_101011() + get_101012());

    }

    /**
     * 集計情報レコードの集計
     * @param base
     * @throws Exception
     */
    protected void parseCategory7(VRMap base) throws Exception {
        // (保険分出来高医療費)単位数合計
        set_101008(get_101008()
                + ACCastUtilities.toInt(base.get("701027"), 0)
                );
        //(保険分出来高医療費)出来高医療費利用者負担額8桁
        set_101012(get_101012()
                + ACCastUtilities.toInt(base.get("701029"),0)
                + ACCastUtilities.toInt(base.get("701032"),0)
                + ACCastUtilities.toInt(base.get("701035"),0)
                + ACCastUtilities.toInt(base.get("701038"),0)
                );
        
//        //公費請求額
//        set_101011(get_101011()
//                + ACCastUtilities.toInt(base.get("701029"),0)
//                + ACCastUtilities.toInt(base.get("701031"),0)
//                + ACCastUtilities.toInt(base.get("701034"),0)
//                + ACCastUtilities.toInt(base.get("701037"),0)
//                );
        
        // (サービス費用)費用合計12桁を設定する。
        set_101009(get_101010() + get_101011() + get_101012());
    }
    
    /**
     * 特定入所者情報レコードの集計
     * @param base
     * @param recordKubun
     * @param lawNo
     * @param kubun
     * @throws Exception
     */
    protected void parseCategory8(VRMap base,int recordKubun, String lawNo, String kubun) throws Exception {
      // 特定入所者介護サービス費用件数
        set_101013(get_101013() + 1);
        // 特定入所者介護サービス費用合計
        set_101015(get_101015() + ACCastUtilities.toInt(base.get("801022"), 0));
        // 特定入所者介護サービス利用者負担
        set_101016(get_101016()
                + ACCastUtilities.toInt(base.get("801024"), 0)
                + ACCastUtilities.toInt(base.get("801027"), 0)// 公費１
                + ACCastUtilities.toInt(base.get("801030"), 0)// 公費２
                + ACCastUtilities.toInt(base.get("801033"), 0)// 公費３
                );
        // 特定入所者介護サービス公費請求額
        set_101017(get_101017()
                + ACCastUtilities.toInt(base.get("801026"), 0)// 公費１
                + ACCastUtilities.toInt(base.get("801029"), 0)// 公費２
                + ACCastUtilities.toInt(base.get("801032"), 0)// 公費３
        );
        // 特定入所者介護サービス保険請求額
        set_101018(get_101018()
                + ACCastUtilities.toInt(base.get("801023"),0));
    }
    
    /**
     * データのパースを実行します。
     * @param base
     * @param recordKubun 1-保険請求 2-公費請求
     * @param lawNo 法別番号　※保険請求は0
     * @param kubun
     * @throws Exception
     */
    protected void parseStyle7(VRMap base,int recordKubun, String lawNo, String kubun) throws Exception {

        // 基本情報レコードの値から介護給付費請求書のレイアウトに変更する。
        // サービス提供年月
        set_101002(String.valueOf(base.get("1001004")));
        // 事業所番号
        set_101003(String.valueOf(base.get("1001002")));
        // 保険・公費区分レコード
        // 1-保険請求 2-公費請求
        set_101004(recordKubun);
        
        // 法別番号2桁※保険請求分の場合は0
        set_101005(lawNo);

        // 請求情報区分コード2桁
        // 法別番号=0 OR 12→01-居宅・施設サービス 02-居宅介護支援 法別番号=それ以外→0固定
        // 【解説】
        // 保険請求、または公費請求で法別番号が12(生保)の場合→01-居宅・施設サービス 02-居宅介護支援
        // 公費請求で法別番号が12以外の場合→0固定
        set_101006(kubun);

        // (サービス費用)件数6桁を設定する。
        //set_101007(get_101007() + 1);
        // [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010年度対応
        //set_101007(base.get("1001001"),base.get("1001007"));
        set_101007(base.get("1001001"), base.get("1001005"), base.get("1001007"));
        // [ID:0000622][Shin Fujihara] 2010/11 edit end 2010年度対応

        // (サービス費用)単位数11桁を設定する。
        set_101008(get_101008() + ACCastUtilities.toInt(base.get("1001017"), 0));

        // (サービス費用)費用合計12桁を設定する。
        set_101009(get_101009() + ACCastUtilities.toInt(base.get("1001018"), 0));

        // (サービス費用)保険請求額12桁を設定する。
        set_101010(get_101010() + ACCastUtilities.toInt(base.get("1001018"), 0));

        // (サービス費用)公費請求額12桁を設定する。
        set_101011(0);

        // (サービス費用)利用者負担12桁を設定する。
        set_101012(0);
    }
    
    
    /**
     * データのパースを実行します。
     * @param base
     * @param recordKubun 1-保険請求 2-公費請求
     * @param lawNo 法別番号　※保険請求は0
     * @param kubun
     * @throws Exception
     */
    protected void parseKohi(VRMap base,int recordKubun, String lawNo, String kubun,int kohiPosition) throws Exception {

        // 保険・公費区分レコード
        // 1-保険請求 2-公費請求
        set_101004(recordKubun);
        // 法別番号2桁※保険請求分の場合は0
        set_101005(lawNo);
        // 請求情報区分コード2桁
        // 法別番号=0 OR 12→01-居宅・施設サービス 02-居宅介護支援 法別番号=それ以外→0固定
        // 【解説】
        // 保険請求、または公費請求で法別番号が12(生保)の場合→01-居宅・施設サービス 02-居宅介護支援
        // 公費請求で法別番号が12以外の場合→0固定
        set_101006(kubun);
        
        if(base.containsKey("201001")){
            // (サービス費用)件数6桁を設定する。
            //set_101007(get_101007() + 1);
        	// [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010年度対応
            //set_101007(base.get("201001"),base.get("201006"));
        	set_101007(base.get("201001"), base.get("201005"), base.get("201006"));
        	// [ID:0000622][Shin Fujihara] 2010/11 edit end 2010年度対応
            // 基本情報レコードの値から介護給付費請求書のレイアウトに変更する。
            // サービス提供年月
            set_101002(String.valueOf(base.get("201003")));
            // 事業所番号
            set_101003(String.valueOf(base.get("201004")));

            
            // (サービス費用)単位数11桁を設定する。
            set_101008(get_101008()
                    + ACCastUtilities.toInt(base.get("201033"), 0));

            // (サービス費用)保険請求額12桁を設定する。
            set_101010(get_101010()
                    + ACCastUtilities.toInt(base.get("201034"), 0) //(合計情報 保険)請求額9桁
                    + ACCastUtilities.toInt(base.get("201036"), 0) //(合計情報 保険)緊急時施設療養費請求額9桁
                    + ACCastUtilities.toInt(base.get("201037"), 0));//(合計情報 保険)特定診療費請求額9桁

            

            // (サービス費用)公費請求額12桁を設定する。
            switch(kohiPosition){
            case 0:
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("201040"), 0) // 公費１
                        + ACCastUtilities.toInt(base.get("201042"), 0) //(合計情報 公費1)緊急時施設療養費請求額8桁
                        + ACCastUtilities.toInt(base.get("201043"), 0) //(合計情報 公費1)特定診療費請求額8桁
                        );
                // (サービス費用)利用者負担12桁を設定する。
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201035"), 0) //保険分利用者負担額
                        + ACCastUtilities.toInt(base.get("201041"), 0) //(合計情報 公費1)本人負担額8桁
                        );
                
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201046"), 0) // 公費２
                        + ACCastUtilities.toInt(base.get("201048"), 0) //(合計情報 公費2)緊急時施設療養費請求額8桁
                        + ACCastUtilities.toInt(base.get("201049"), 0) //(合計情報 公費2)特定診療費請求額8桁
                        );
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201052"), 0) // 公費３
                        + ACCastUtilities.toInt(base.get("201054"), 0) //(合計情報 公費3)緊急時施設療養費請求額8桁
                        + ACCastUtilities.toInt(base.get("201055"), 0) //(合計情報 公費3)特定診療費請求額8桁
                        );
                
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201047"), 0) //(合計情報 公費2)本人負担額8桁
                        + ACCastUtilities.toInt(base.get("201053"), 0) //(合計情報 公費3)本人負担額8桁
                        );
                        break;
            case 1:
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("201046"), 0) // 公費２
                        + ACCastUtilities.toInt(base.get("201048"), 0) //(合計情報 公費2)緊急時施設療養費請求額8桁
                        + ACCastUtilities.toInt(base.get("201049"), 0) //(合計情報 公費2)特定診療費請求額8桁
                        );
                // (サービス費用)利用者負担12桁を設定する。
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201035"), 0) //保険分利用者負担額
                        + ACCastUtilities.toInt(base.get("201047"), 0) //(合計情報 公費2)本人負担額8桁
                        );
                
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201040"), 0) // 公費１
                        + ACCastUtilities.toInt(base.get("201042"), 0) //(合計情報 公費1)緊急時施設療養費請求額8桁
                        + ACCastUtilities.toInt(base.get("201043"), 0) //(合計情報 公費1)特定診療費請求額8桁
                        );
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201052"), 0) // 公費３
                        + ACCastUtilities.toInt(base.get("201054"), 0) //(合計情報 公費3)緊急時施設療養費請求額8桁
                        + ACCastUtilities.toInt(base.get("201055"), 0) //(合計情報 公費3)特定診療費請求額8桁
                        );
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201041"), 0) //(合計情報 公費1)本人負担額8桁
                        + ACCastUtilities.toInt(base.get("201053"), 0) //(合計情報 公費3)本人負担額8桁
                        );
                        break;
            case 2:
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("201052"), 0) // 公費３
                        + ACCastUtilities.toInt(base.get("201054"), 0) //(合計情報 公費3)緊急時施設療養費請求額8桁
                        + ACCastUtilities.toInt(base.get("201055"), 0) //(合計情報 公費3)特定診療費請求額8桁
                        );
                // (サービス費用)利用者負担12桁を設定する。
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201035"), 0) //保険分利用者負担額
                        + ACCastUtilities.toInt(base.get("201053"), 0) //(合計情報 公費3)本人負担額8桁
                        );
                
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201040"), 0) // 公費１
                        + ACCastUtilities.toInt(base.get("201042"), 0) //(合計情報 公費1)緊急時施設療養費請求額8桁
                        + ACCastUtilities.toInt(base.get("201043"), 0) //(合計情報 公費1)特定診療費請求額8桁
                        );
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201052"), 0) // 公費３
                        + ACCastUtilities.toInt(base.get("201054"), 0) //(合計情報 公費3)緊急時施設療養費請求額8桁
                        + ACCastUtilities.toInt(base.get("201055"), 0) //(合計情報 公費3)特定診療費請求額8桁
                        );
                
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201047"), 0) //(合計情報 公費2)本人負担額8桁
                        + ACCastUtilities.toInt(base.get("201053"), 0) //(合計情報 公費3)本人負担額8桁
                        );
                        break;
            }
            

            // (サービス費用)費用合計12桁を設定する。
            //保険請求額+公費請求額+利用者負担額
            set_101009(get_101010() + get_101011() + get_101012());

        }
        
        //集計情報レコード
        if(base.containsKey("701001")){
            // (サービス費用)件数6桁を設定する。
            //set_101007(get_101007() + 1);
        	// [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010年度対応
            //set_101007(base.get("701001"),base.get("701006"));
        	set_101007(base.get("701001"), base.get("701005"), base.get("701006"));
        	// [ID:0000622][Shin Fujihara] 2010/11 edit end 2010年度対応
            // 基本情報レコードの値から介護給付費請求書のレイアウトに変更する。
            // サービス提供年月
            set_101002(String.valueOf(base.get("701003")));
            // 事業所番号
            set_101003(String.valueOf(base.get("701004")));

            // (サービス費用)公費請求額12桁を設定する。
            switch(kohiPosition){
            case 0:
                //単位数
                set_101008(get_101008()
                        + ACCastUtilities.toInt(base.get("701018"),0)   //公費１単位数
                        + ACCastUtilities.toInt(base.get("701030"),0)   //(公費1分出来高医療費)単位数合計8桁
                        );
                
                
                //費用額合計==========================
                //保険分の公費の適用があるか確認
                if((ACCastUtilities.toInt(base.get("701019"), 0) + ACCastUtilities.toInt(base.get("701020"), 0)) > 0){
                    //存在すれば、保険分の費用を加算
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701016"), 0)  //(保険)請求額9桁
                            + ACCastUtilities.toInt(base.get("701017"), 0)  //(保険)利用者負担額8桁
                            + ACCastUtilities.toInt(base.get("701019"), 0)  //(公費1)請求額9桁
                            + ACCastUtilities.toInt(base.get("701020"), 0)  //(公費1)本人負担額6桁
                            + ACCastUtilities.toInt(base.get("701022"), 0)  //(公費2)請求額9桁
                            + ACCastUtilities.toInt(base.get("701023"), 0)  //(公費2)本人負担額6桁
                            + ACCastUtilities.toInt(base.get("701025"), 0)  //(公費3)請求額9桁
                            + ACCastUtilities.toInt(base.get("701026"), 0)  //(公費3)本人負担額6桁
                            );
                }
                
                //保険分出来高医療費の公費の適用があるか確認
                if((ACCastUtilities.toInt(base.get("701031"), 0) + ACCastUtilities.toInt(base.get("701032"), 0)) > 0){
                    //存在すれば保険分出来高医療費の費用を加算
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701028"), 0)  //(保険分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701029"), 0)  //(保険分出来高医療費)出来高医療費利用者負担額8桁
                            + ACCastUtilities.toInt(base.get("701031"), 0)  //(公費1分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701032"), 0)  //(公費1分出来高医療費)出来高医療費本人負担額8桁
                            + ACCastUtilities.toInt(base.get("701034"), 0)  //(公費2分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701035"), 0)  //(公費2分出来高医療費)出来高医療費本人負担額8桁
                            + ACCastUtilities.toInt(base.get("701037"), 0)  //(公費3分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701038"), 0)  //(公費3分出来高医療費)出来高医療費本人負担額8桁
                            );
                }
                
                //公費請求額==========================================
                // (サービス費用)利用者負担12桁を設定する。
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("701019"), 0)  //(公費1)請求額9桁
                        + ACCastUtilities.toInt(base.get("701031"), 0)  //(公費1分出来高医療費)請求額9桁
                        );
                        break;
            case 1:
                //単位数
                set_101008(get_101008()
                        + ACCastUtilities.toInt(base.get("701021"),0)   //公費２単位数
                        + ACCastUtilities.toInt(base.get("701033"),0)   //(公費２分出来高医療費)単位数合計8桁
                        );
                
                
                //費用額合計==========================
                //保険分の公費の適用があるか確認
                if((ACCastUtilities.toInt(base.get("701022"), 0) + ACCastUtilities.toInt(base.get("701023"), 0)) > 0){
                    //存在すれば、保険分の費用を加算
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701016"), 0)  //(保険)請求額9桁
                            + ACCastUtilities.toInt(base.get("701017"), 0)  //(保険)利用者負担額8桁
                            + ACCastUtilities.toInt(base.get("701019"), 0)  //(公費1)請求額9桁
                            + ACCastUtilities.toInt(base.get("701020"), 0)  //(公費1)本人負担額6桁
                            + ACCastUtilities.toInt(base.get("701022"), 0)  //(公費2)請求額9桁
                            + ACCastUtilities.toInt(base.get("701023"), 0)  //(公費2)本人負担額6桁
                            + ACCastUtilities.toInt(base.get("701025"), 0)  //(公費3)請求額9桁
                            + ACCastUtilities.toInt(base.get("701026"), 0)  //(公費3)本人負担額6桁
                            );
                }
                
                //保険分出来高医療費の公費の適用があるか確認
                if((ACCastUtilities.toInt(base.get("701034"), 0) + ACCastUtilities.toInt(base.get("701035"), 0)) > 0){
                    //存在すれば保険分出来高医療費の費用を加算
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701028"), 0)  //(保険分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701029"), 0)  //(保険分出来高医療費)出来高医療費利用者負担額8桁
                            + ACCastUtilities.toInt(base.get("701031"), 0)  //(公費1分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701032"), 0)  //(公費1分出来高医療費)出来高医療費本人負担額8桁
                            + ACCastUtilities.toInt(base.get("701034"), 0)  //(公費2分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701035"), 0)  //(公費2分出来高医療費)出来高医療費本人負担額8桁
                            + ACCastUtilities.toInt(base.get("701037"), 0)  //(公費3分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701038"), 0)  //(公費3分出来高医療費)出来高医療費本人負担額8桁
                            );
                }
                
                //公費請求額==========================================
                // (サービス費用)利用者負担12桁を設定する。
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("701022"), 0)  //(公費2)請求額9桁
                        + ACCastUtilities.toInt(base.get("701034"), 0)  //(公費2分出来高医療費)請求額9桁
                        );
                        break;
            case 2:
                //単位数
                set_101008(get_101008()
                        + ACCastUtilities.toInt(base.get("701024"),0)   //公費３単位数
                        + ACCastUtilities.toInt(base.get("701036"),0)   //(公費３分出来高医療費)単位数合計8桁
                        );
                
                
                //費用額合計==========================
                //保険分の公費の適用があるか確認
                if((ACCastUtilities.toInt(base.get("701025"), 0) + ACCastUtilities.toInt(base.get("701026"), 0)) > 0){
                    //存在すれば、保険分の費用を加算
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701016"), 0)  //(保険)請求額9桁
                            + ACCastUtilities.toInt(base.get("701017"), 0)  //(保険)利用者負担額8桁
                            + ACCastUtilities.toInt(base.get("701019"), 0)  //(公費1)請求額9桁
                            + ACCastUtilities.toInt(base.get("701020"), 0)  //(公費1)本人負担額6桁
                            + ACCastUtilities.toInt(base.get("701022"), 0)  //(公費2)請求額9桁
                            + ACCastUtilities.toInt(base.get("701023"), 0)  //(公費2)本人負担額6桁
                            + ACCastUtilities.toInt(base.get("701025"), 0)  //(公費3)請求額9桁
                            + ACCastUtilities.toInt(base.get("701026"), 0)  //(公費3)本人負担額6桁
                            );
                }
                
                //保険分出来高医療費の公費の適用があるか確認
                if((ACCastUtilities.toInt(base.get("701037"), 0) + ACCastUtilities.toInt(base.get("701038"), 0)) > 0){
                    //存在すれば保険分出来高医療費の費用を加算
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701028"), 0)  //(保険分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701029"), 0)  //(保険分出来高医療費)出来高医療費利用者負担額8桁
                            + ACCastUtilities.toInt(base.get("701031"), 0)  //(公費1分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701032"), 0)  //(公費1分出来高医療費)出来高医療費本人負担額8桁
                            + ACCastUtilities.toInt(base.get("701034"), 0)  //(公費2分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701035"), 0)  //(公費2分出来高医療費)出来高医療費本人負担額8桁
                            + ACCastUtilities.toInt(base.get("701037"), 0)  //(公費3分出来高医療費)請求額9桁
                            + ACCastUtilities.toInt(base.get("701038"), 0)  //(公費3分出来高医療費)出来高医療費本人負担額8桁
                            );
                }
                
                //公費請求額==========================================
                // (サービス費用)利用者負担12桁を設定する。
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("701025"), 0)  //(公費3)請求額9桁
                        + ACCastUtilities.toInt(base.get("701037"), 0)  //(公費3分出来高医療費)請求額9桁
                        );
                        break;
            }
        }
        
        if(base.containsKey("801001")){
            // 特定入所者介護サービス費用件数
            set_101013(get_101013() + 1);
            // 特定入所者介護サービス費用合計
            set_101015(get_101015() + ACCastUtilities.toInt(base.get("801022"), 0));
            // 特定入所者介護サービス利用者負担
            set_101016(get_101016()
                    + ACCastUtilities.toInt(base.get("801024"), 0)
                    );
            // 特定入所者介護サービス公費請求額
            set_101017(get_101017()
                    + ACCastUtilities.toInt(base.get("801026"), 0)// 公費１
                    + ACCastUtilities.toInt(base.get("801029"), 0)// 公費２
                    + ACCastUtilities.toInt(base.get("801032"), 0)// 公費３
            );
            set_101018(get_101018()
                    + ACCastUtilities.toInt(base.get("801023"),0));
            
            // (サービス費用)費用合計12桁を設定する。
            //保険請求額+公費請求額+利用者負担額
            set_101009(get_101010() + get_101011() + get_101012());
        }
        
        if(base.containsKey("1001004")){
            // 基本情報レコードの値から介護給付費請求書のレイアウトに変更する。
            // サービス提供年月
            set_101002(String.valueOf(base.get("1001004")));
            // 事業所番号
            set_101003(String.valueOf(base.get("1001002")));

            // (サービス費用)件数6桁を設定する。
            //set_101007(get_101007() + 1);
            // [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010年度対応
            //set_101007(base.get("1001001"),base.get("1001007"));
            set_101007(base.get("1001001"), base.get("1001005"), base.get("1001007"));
            // [ID:0000622][Shin Fujihara] 2010/11 edit end 2010年度対応

            // (サービス費用)単位数11桁を設定する。
            set_101008(get_101008() + ACCastUtilities.toInt(base.get("1001017"), 0));

            // (サービス費用)費用合計12桁を設定する。
            set_101009(get_101009() + ACCastUtilities.toInt(base.get("1001018"), 0));

            // (サービス費用)保険請求額12桁を設定する。
            set_101010(0);

            // (サービス費用)公費請求額12桁を設定する。
            set_101011(get_101011() +  + ACCastUtilities.toInt(base.get("1001018"), 0));

            // (サービス費用)利用者負担12桁を設定する。
            set_101012(0);
            
            // (サービス費用)費用合計12桁を設定する。
            //保険請求額+公費請求額+利用者負担額
            set_101009(get_101010() + get_101011() + get_101012());
        }

    }
    
    /**
     * 保持しているデータをマップに変換する。
     * @return
     * @throws Exception
     */
    protected VRMap getRecord() throws Exception {
        VRMap result = new VRHashMap();
        
        putData(result, "101001", get_101001());
        putData(result, "101002", get_101002());
        putData(result, "101003", get_101003());
        putData(result, "101004", get_101004());
        putData(result, "101005", get_101005());
        putData(result, "101006", get_101006());
        putData(result, "101007", get_101007());
        putData(result, "101008", get_101008());
        putData(result, "101009", get_101009());
        
        putData(result, "101010", get_101010());
        putData(result, "101011", get_101011());
        putData(result, "101012", get_101012());
        putData(result, "101013", get_101013());
        putData(result, "101014", get_101014());
        putData(result, "101015", get_101015());
        putData(result, "101016", get_101016());
        putData(result, "101017", get_101017());
        putData(result, "101018", get_101018());
        
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_BENEFIT_BILL);
        
        return result;
    }
    
    private void putData(VRMap map, String key, int value) throws Exception {
        putData(map,key,String.valueOf(value));
    }
    
    private void putData(VRMap map, String key, String value) throws Exception {
        map.put(key,value);
    }
    
}
