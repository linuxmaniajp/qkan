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
 * 作成日: 2009/07/10  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 再集計機能 (QP001ReTotal)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;

public class QP001ReTotal {

    /** 基本情報レコード(2) */
    private VRList base = new VRArrayList();

    /** 明細情報レコード(3) */
    private VRList detail = new VRArrayList();

    /** 緊急時施設療養情報レコード(4) */
    private VRList emergency = new VRArrayList();

    /** 緊急時施設療養情報レコード(17) */
    private VRList emergencyOwnFacility = new VRArrayList();

    /** 特定診療費情報レコード(5) */
    private VRList diagnosis = new VRArrayList();

    /** 集計情報レコード(7) */
    private VRList type = new VRArrayList();

    /** 特定入所者介護サービス費用情報レコード(8) */
    private VRList nursing = new VRArrayList();

    /** 社会福祉法人軽減額情報レコード(9) */
    private VRList reduction = new VRArrayList();

    /** 特定入所者介護総計レコード */
    private VRMap nursingTotal = null;

    /** 介護給付費請求明細書（居宅サービス計画費）情報 */
    private VRList careplan = new VRArrayList();

    /** 給付率 */
    private int rate = Integer.MIN_VALUE;
    /** 公費給付率 */
    private int[] kohiRate = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE,
            Integer.MIN_VALUE };
    /** 公費種類 */
    private String[] kohiType = new String[] { null, null, null };
    /** 緊急時治療適用公費 */
    private VRList emergencyKohi = new VRArrayList();

    /** 利用者情報 */
    private QP001PatientState patientState = null;

    /** 基本情報レコードに設定する緊急時、特定診療費情報 */
    private VRMap baseCache = new VRHashMap();

    /** 計画単位数上書きフラグ **/
    private boolean isPlanOverwrite = false;
    
    private Date targetDate = null;
    private ACDBManager dbm = null;

    public void calc(VRList[] list, ACDBManager dbm, int patient_id,
            boolean isPlanOverwrite) throws Exception {
        if (list == null) {
            throw new NullPointerException("引数のリストにnullが設定されています。");
        }
        
        this.dbm = dbm;
        // 計画単位数上書きフラグを設定
        this.isPlanOverwrite = isPlanOverwrite;

        // レコード振り分け
        parseRecord(list);

        VRMap patient = new VRHashMap();
        patient.put("PATIENT_ID", String.valueOf(patient_id));

        String target = null;
        String style = null;

        if (base.size() > 0) {
            target = ((VRMap) base.get(0)).get("201003") + "01";
            style = toString(((VRMap) base.get(0)), "201001");
        } else if (careplan.size() > 0) {
            target = ((VRMap) careplan.get(0)).get("1001004") + "01";
        } else {
            return;
        }
        targetDate = ACCastUtilities.toDate(target);

        // 利用者情報取得
        patientState = new QP001PatientState(dbm, patient, targetDate);

        initUsedKohi(dbm, patientState, targetDate, style);

        // 再集計実行
        doTotal();
    }

    /**
     * 使用済み公費自己負担額を算定する
     * 
     * @param dbm
     * @param patientState
     * @param targetDate
     * @param style
     * @throws Exception
     */
    private void initUsedKohi(ACDBManager dbm, QP001PatientState patientState,
            Date targetDate, String style) throws Exception {

        if (style == null) {
            return;
        }

        // 請求詳細情報を取得し、VRArrayList claimList に格納する。
        StringBuilder sb = new StringBuilder();

        // 請求月を取得
        sb.append(" SELECT");
        sb.append(" DISTINCT");
        sb.append(" CLAIM_DATE");
        sb.append(" FROM");
        sb.append(" CLAIM");
        sb.append(" WHERE");
        sb.append(" (CLAIM.PATIENT_ID = " + patientState.getPatientId() + ")");
        sb.append(" AND (CLAIM.TARGET_DATE = '"
                + VRDateParser.format(targetDate, "yyyy/MM/dd") + "')");
        sb.append(" AND (CLAIM.PROVIDER_ID = '"
                + QkanSystemInformation.getInstance().getLoginProviderID()
                + "')");

        VRList list = dbm.executeQuery(sb.toString());

        if ((list == null) || (list.size() == 0)) {
            return;
        }

        Date claimDate = ACCastUtilities.toDate(
                ((VRMap) list.get(0)).get("CLAIM_DATE"), null);

        if (claimDate == null) {
            return;
        }

        sb = new StringBuilder();

        sb.append(" AND(CLAIM.TARGET_DATE = '"
                + VRDateParser.format(targetDate, "yyyy/MM/dd") + "')");
        sb.append(" AND(CLAIM.PATIENT_ID = " + patientState.getPatientId()
                + ")");
        sb.append(" AND(CLAIM.PROVIDER_ID = '"
                + QkanSystemInformation.getInstance().getLoginProviderID()
                + "')");
        sb.append(" AND (CLAIM.CATEGORY_NO IN (2))");

        // 請求情報取得
        VRList claim = QkanCommon.getClaimDetailCustom(dbm, claimDate,
                sb.toString());

        for (int i = 0; i < claim.size(); i++) {
            VRMap map = (VRMap) claim.get(i);

            // 再集計対象のデータと交換識別番号がおなじものはスキップ
            if (toString(map, "201001").equals(style)) {
                continue;
            }

            String kohiType = null;

            // 公費1 公費種類(KOHI_TYPE)
            kohiType = toString(map, "201058");
            if (!"".equals(kohiType)) {
                patientState.getKohiSelfPay(kohiType, 1);
                // (合計情報 公費1)本人負担額を差し引く
                patientState.setKohiSelfPayUse(kohiType, toInt(map, "201041"));
            }

            // 公費2 公費種類(KOHI_TYPE)
            kohiType = toString(map, "201059");
            if (!"".equals(kohiType)) {
                patientState.getKohiSelfPay(kohiType, 1);
                // (合計情報 公費2)本人負担額を差し引く
                patientState.setKohiSelfPayUse(kohiType, toInt(map, "201047"));
            }

            // 公費3 公費種類(KOHI_TYPE)
            kohiType = toString(map, "201060");
            if (!"".equals(kohiType)) {
                patientState.getKohiSelfPay(kohiType, 1);
                // (合計情報 公費3)本人負担額を差し引く
                patientState.setKohiSelfPayUse(kohiType, toInt(map, "201053"));
            }

        }

        // 緊急時治療に適用される公費を取得する
        // 交換識別番号から、システム内サービス種類コードを判定
        // ※注　ハードコーティング
        String systemServiceKind = null;

        // 様式第四　短期入所療養介護(老健)
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(style)) {
            systemServiceKind = "12211";

            // 様式第四の二　介護予防短期入所療養介護(老健)
        } else if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204
                .equals(style)) {
            systemServiceKind = "12511";

            // 様式第九　介護老人保健施設
        } else if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(style)) {
            systemServiceKind = "15211";
        }

        if (ACTextUtilities.isNullText(systemServiceKind)) {
            return;
        }

        // 公費-サービスマスタ取得
        sb = new StringBuilder();

        sb.append(" SELECT");
        sb.append(" KOHI_TYPE");
        sb.append(" FROM");
        sb.append(" M_KOHI_SERVICE");
        sb.append(" WHERE");
        // 2:緊急時施設療養管理
        sb.append(" (APPLICATION_TYPE = 2)");
        sb.append(" AND (SYSTEM_SERVICE_KIND_DETAIL = " + systemServiceKind
                + ")");
        // 2-医療機関も含め全ての事業所
        sb.append(" AND (BY_MEDICAL_FLAG = 2)");
        sb.append(" AND (KOHI_SERVICE_VALID_START  <='"
                + VRDateParser.format(targetDate, "yyyy/MM/dd") + "')");
        sb.append(" AND (KOHI_SERVICE_VALID_END  >= '"
                + VRDateParser.format(targetDate, "yyyy/MM/dd") + "')");

        list = dbm.executeQuery(sb.toString());

        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.get(i);
            emergencyKohi.add(ACCastUtilities.toString(map.get("KOHI_TYPE")));
        }

    }

    /**
     * 引数を解析して、振り分ける
     * 
     * @param list
     */
    private void parseRecord(VRList[] list) {

        // 何が入っているか不明なので、各リストの先頭のmapの
        // カテゴリから振り分け先を判断
        for (int i = 0; i < list.length; i++) {
            if (list[i].size() <= 0) {
                continue;
            }
            VRMap map = (VRMap) list[i].get(0);
            switch (toInt(map, "CATEGORY_NO")) {
            // 基本情報レコード
            case 2:
                base = list[i];
                break;
            // 明細情報レコード
            case 3:
                detail = list[i];
                break;
            // 緊急時施設療養情報レコード
            case 4:
                emergency = list[i];
                break;
            // 特定診療費情報レコード
            case 5:
                diagnosis = list[i];
                break;
            // 集計情報レコード
            case 7:
                type = list[i];
                break;
            // 特定入所者介護サービス費用情報レコード
            case 8:
                nursing = list[i];
                break;
            // 社会福祉法人軽減額情報レコード
            case 9:
                reduction = list[i];
                break;
            // 様式第七
            case 10:
                careplan = list[i];
                break;
            // 緊急時施設療養・自施設療養費情報レコード
            case 17:
                emergencyOwnFacility = list[i];
                break;
            }
        }
    }

    private void doTotal() throws Exception {

        // 明細情報レコードの集計処理
        parseDetail();

        // 緊急時治療レコードの集計処理
        parseEmergency();

        // 緊急時治療管理・自施設療養費
        parseEmergencyOwnFacility();

        // 特定診療・特別療養費情報レコード
        parseDiagnosis();

        // 特定入所者介護サービス費用情報レコード
        parseNursing();

        // 集計情報レコード
        parseType();
        
        //[ID:0000726][Shin Fujihara] 2012/04 add begin 処遇改善加算の再集計対応
        parseImproveTheTreatment();
        //[ID:0000726][Shin Fujihara] 2012/04 add end

        // 基本情報レコード
        parseBase();

        // 社福レコード
        parseReduction();

        // 居宅サービス計画費
        parseCarePlan();
    }

    /**
     * 明細情報レコードの集計処理
     * 
     * @throws Exception
     */
    private void parseDetail() throws Exception {

        VRMap map = null;

        for (int i = 0; i < detail.size(); i++) {
            map = (VRMap) detail.get(i);

            if (toInt(map, "301009") == 0) {
                continue;
            }

            // サービス単位数 = 単位数 * 回数
            mul(map, "301014", "301009", "301010");
            // 公費１対象サービス単位数 = 単位数 * 公費１日数・回数
            mul(map, "301015", "301009", "301011");
            // 公費２対象サービス単位数 = 単位数 * 公費２日数・回数
            mul(map, "301016", "301009", "301012");
            // 公費３対象サービス単位数 = 単位数 * 公費３日数・回数
            mul(map, "301017", "301009", "301013");
        }
    }

    /**
     * 緊急時治療レコードの集計処理
     * 
     * @throws Exception
     */
    private void parseEmergency() throws Exception {

        VRMap map = null;

        for (int i = 0; i < emergency.size(); i++) {
            map = (VRMap) emergency.get(i);
            // 緊急時治療管理小計 = 緊急時治療管理単位数 * 緊急時治療管理日数
            mul(map, "401020", "401018", "401019");
            // 緊急時施設療養費合計点数 =
            // リハビリテーション点数 + 処置点数 + 手術点数 + 麻酔点数 + 放射線治療点数
            add(map, "401046", new String[] { "401021", "401022", "401023",
                    "401024", "401025" });
        }
    }

    /**
     * 緊急時治療管理・自施設療養費レコードの集計処理
     * 
     * @throws Exception
     */
    private void parseEmergencyOwnFacility() throws Exception {

        VRMap map = null;

        for (int i = 0; i < emergencyOwnFacility.size(); i++) {
            map = (VRMap) emergencyOwnFacility.get(i);
            // 緊急時治療管理小計 = 緊急時治療管理単位数 * 緊急時治療管理日数
            mul(map, "1701020", "1701018", "1701019");
            
            // 自施設療養費小計 = 自施設療養費単位数 * 自施設療養費日数
            mul(map, "1701055", "1701053", "1701054");
            
            // 緊急時施設療養費合計点数 =
            // リハビリテーション点数 + 処置点数 + 手術点数 + 麻酔点数 + 放射線治療点数
            add(map, "1701046", new String[] { "1701021", "1701022", "1701023",
                    "1701024", "1701025" });
        }
    }

    /**
     * 特定診療・特別療養費情報レコード
     * 
     * @throws Exception
     */
    private void parseDiagnosis() throws Exception {

        VRMap map = null;
        int total = 0;
        int total_kohi1 = 0;
        int total_kohi2 = 0;
        int total_kohi3 = 0;

        for (int i = 0; i < diagnosis.size(); i++) {
            map = (VRMap) diagnosis.get(i);
            // 保険サービス単位数 = 単位数 * 保険回数
            total += mul(map, "501012", "501010", "501011");
            // 公費1サービス単位数 = 単位数 * 公費1回数
            total_kohi1 += mul(map, "501015", "501010", "501014");
            // 公費2サービス単位数 = 単位数 * 公費2回数
            total_kohi2 += mul(map, "501018", "501010", "501017");
            // 公費3サービス単位数 = 単位数 * 公費3回数
            total_kohi3 += mul(map, "501021", "501010", "501020");
        }
        // 各合計単位数を設定する
        if (map != null) {
            map.put("501013", String.valueOf(total));
            map.put("501016", String.valueOf(total_kohi1));
            map.put("501019", String.valueOf(total_kohi2));
            map.put("501022", String.valueOf(total_kohi3));
        }
    }

    /**
     * 特定入所者介護サービス費用情報レコード
     * 
     * @throws Exception
     */
    private void parseNursing() throws Exception {
        // 並び替えは保留
        // もともと並び替えていない模様
        /*
         * Collections.sort(nursing, new Comparator() { public int
         * compare(Object obj1, Object obj2) { //サービスコードでソートする VRMap map1 =
         * ((VRMap)obj1); VRMap map2 = ((VRMap)obj2);
         * 
         * String serviceCode1 = ACCastUtilities.toString(map1.get("801008"),
         * ""); serviceCode1 += ACCastUtilities.toString(map1.get("801009"),
         * ""); String serviceCode2 =
         * ACCastUtilities.toString(map2.get("801008"), ""); serviceCode2 +=
         * ACCastUtilities.toString(map2.get("801009"), "");
         * 
         * if (serviceCode1.compareTo(serviceCode2) < 0) { return -1; } else if
         * (serviceCode1.compareTo(serviceCode2) > 0) { return 1; } return 0; }
         * });
         */
        VRMap map = null;
        int _801022 = 0;
        int _801023 = 0;
        int _801024 = 0;
        int _801025 = 0;
        int _801026 = 0;
        int _801028 = 0;
        int _801029 = 0;
        int _801031 = 0;
        int _801032 = 0;

        // [ID:0000605][Shin Fujihara] 2010/05 edit begin 2009年度障害対応
        int count_801007 = 1;
        // [ID:0000605][Shin Fujihara] 2010/05 edit end 2009年度障害対応

        for (int i = 0; i < nursing.size(); i++) {
            map = (VRMap) nursing.get(i);

            // 初期化
            map.put("801016", "0");
            map.put("801017", "0");
            map.put("801018", "0");
            map.put("801019", "0");
            map.put("801020", "0");
            map.put("801021", "0");

            // [ID:0000605][Shin Fujihara] 2010/05 del begin 2009年度障害対応
            // 番号の振り替えを後半に移動
            // 順次番号振り替え
            // map.put("801007", String.valueOf(i + 1));
            // [ID:0000605][Shin Fujihara] 2010/05 del end 2009年度障害対応

            // 費用額 = 費用単価 * 日数
            mul(map, "801016", "801010", "801012");
            // 保険分請求額 = 費用額　- (負担限度額 * 日数)
            mul(map, "801017", "801011", "801012");
            sub(map, "801017", new String[] { "801016", "801017" });

            // 負数になったら(利用者請求のほうが多ければ)0に戻す。
            if (toInt(map, "801017") < 0) {
                map.put("801017", "0");
            }

            // 様式第八～十の場合、公費の算定を行う
            if (QP001SpecialCase.isShisetsuDiscriminationNo(toString(map,
                    "801001"))) {

                boolean kohiEnd = false;

                // 生保単独の場合
                if (QP001SpecialCase.isSeihoOnly(toString(map, "801006"))) {
                    // 保険分請求額を0に設定
                    map.put("801017", "0");
                    // 公費１請求額に費用額の全額を設定する。
                    map.put("801018", map.get("801016"));
                    // 利用者負担額に0を設定する。
                    map.put("801021", "0");
                } else {
                    // 種類種別(1.食費　6.多床室)
                    int serviceKind = toInt(map, "801037");
                    // 1.食費　6.多床室以外は算定しない
                    if ((serviceKind == 1) || (serviceKind == 6)) {
                        // 公費１の適用がある場合(公費日数と給付率で判断)
                        if ((toInt(map, "801013") != 0)
                                && (getKohiRate(1) != 0)) {
                            // 公費1負担額(明細)6桁を設定する。(負担限度額*公費1日数)
                            mul(map, "801018", "801011", "801013");
                            // 公費分１が費用額と保険分の合算を超える場合
                            if (toInt(map, "801018") > (toInt(map, "801016") + toInt(
                                    map, "801017"))) {
                                // 公費分に費用額から保険分を引いた値を適用する。
                                sub(map, "801018", new String[] { "801016",
                                        "801017" });
                            }
                            // 全額給付したら処理を終了
                            if (toInt(map, "801016") == (toInt(map, "801017") + toInt(
                                    map, "801018"))) {
                                kohiEnd = true;
                            }
                        }
                        // 公費２の適用がある場合(日数判断)
                        if (!kohiEnd && (toInt(map, "801014") != 0)
                                && (getKohiRate(2) != 0)) {
                            // 公費２負担額(明細)6桁を設定する。(負担限度額*公費２日数)
                            mul(map, "801019", "801011", "801014");
                            // 公費分２が費用額と保険分の合算を超える場合
                            if (toInt(map, "801019") > (toInt(map, "801016") + toInt(
                                    map, "801017"))) {
                                // 公費分に費用額から保険分を引いた値を適用する。
                                sub(map, "801019", new String[] { "801016",
                                        "801017" });
                            }
                            // 全額給付したら処理を終了
                            if (toInt(map, "801016") == (toInt(map, "801017")
                                    + toInt(map, "801018") + toInt(map,
                                        "801019"))) {
                                kohiEnd = true;
                            }
                        }
                        // 公費３の適用がある場合(日数判断)
                        if (!kohiEnd && (toInt(map, "801015") != 0)
                                && (getKohiRate(3) != 0)) {
                            // 公費３負担額(明細)6桁を設定する。(負担限度額*公費３日数)
                            mul(map, "801020", "801011", "801015");
                            // 公費分３が費用額と保険分の合算を超える場合
                            if (toInt(map, "801020") > (toInt(map, "801016") + toInt(
                                    map, "801017"))) {
                                // 公費分に費用額から保険分を引いた値を適用する。
                                sub(map, "801020", new String[] { "801016",
                                        "801017" });
                            }
                        }
                    }
                }
            }

            // 利用者負担額を設定する。
            sub(map, "801021", new String[] { "801016", "801017", "801018",
                    "801019", "801020" });

            map.put("801022", "0");
            map.put("801023", "0");
            map.put("801024", "0");
            map.put("801025", "0");
            map.put("801026", "0");
            map.put("801028", "0");
            map.put("801029", "0");
            map.put("801031", "0");
            map.put("801032", "0");

            // [ID:0000605][Shin Fujihara] 2010/05 add begin 2009年度障害対応
            // 全額自己負担の場合は、レコード順次番号を0とし、
            // 合計金額への合算を行なわない
            if (toInt(map, "801017") + toInt(map, "801018")
                    + toInt(map, "801019") + toInt(map, "801020") <= 0) {
                map.put("801007", "0");
                continue;
            }
            map.put("801007", String.valueOf(count_801007));
            count_801007 += 1;

            // 一旦、レコード順次番号99のデータとして退避
            nursingTotal = map;
            // [ID:0000605][Shin Fujihara] 2010/05 add end 2009年度障害対応

            // 集計
            // 費用額合計
            _801022 += toInt(map, "801016");
            // 保険分請求額合計
            _801023 += toInt(map, "801017");
            // 利用者負担額合計
            _801024 += toInt(map, "801021");

            // (公費1)負担額合計
            _801025 += toInt(map, "801018");
            // (公費1)請求額
            _801026 += toInt(map, "801018");

            // (公費2)負担額合計
            _801028 += toInt(map, "801019");
            // (公費2)請求額
            _801029 += toInt(map, "801019");

            // (公費3)負担額合計
            _801031 += toInt(map, "801020");
            // (公費3)請求額
            _801032 += toInt(map, "801020");
        }

        // [ID:0000605][Shin Fujihara] 2010/05 edit begin 2009年度障害対応
        // mapではなく、nursingTotalを使用するよう変更
        // 集計を実施していなければ、処理終了
        if (nursingTotal == null) {
            return;
        }

        // レコード順次番号を99に振り替え
        nursingTotal.put("801007", "99");

        // 各々の総計を設定する
        nursingTotal.put("801022", String.valueOf(_801022));
        nursingTotal.put("801023", String.valueOf(_801023));
        nursingTotal.put("801024", String.valueOf(_801024));
        nursingTotal.put("801025", String.valueOf(_801025));
        nursingTotal.put("801026", String.valueOf(_801026));
        nursingTotal.put("801028", String.valueOf(_801028));
        nursingTotal.put("801029", String.valueOf(_801029));
        nursingTotal.put("801031", String.valueOf(_801031));
        nursingTotal.put("801032", String.valueOf(_801032));
        // [ID:0000605][Shin Fujihara] 2010/05 edit end 2009年度障害対応
    }
    
    
    //[ID:0000726][Shin Fujihara] 2012/04 add begin 処遇改善加算の再集計対応
    /**
     * 処遇改善加算の再集計処理
     * @throws Exception
     */
    private void parseImproveTheTreatment() throws Exception {
        
        List<VRMap> syogu = new ArrayList<VRMap>();
        VRMap map = null;

        for (int i = 0; i < detail.size(); i++) {
            map = (VRMap) detail.get(i);
            
            //サービス名称を取得
            String serviceName = ACCastUtilities.toString(map.get("301019"), "");
            
            //「「処遇改善」という文字列があったら、処遇改善加算とみなす。
            if (serviceName.indexOf("処遇改善") != -1) {
                syogu.add(map);
            }
        }
        
        //処遇改善加算が存在しない場合は処理終了
        if (syogu.isEmpty()) {
            return;
        }
        
        //処遇改善加算の計算
        for (VRMap row : syogu) {
            
            //加算割合取得
            VRMap servcie = getServcieCode(row);
            if (servcie == null) {
                continue;
            }
            
            String servcieCodeKind = ACCastUtilities.toString(row.get("301007"), "");
            
            //対応する集計情報レコードを取得
            map = getType(servcieCodeKind);
            
            //取得に失敗した場合は処理終了
            if (map == null) {
                continue;
            }
            
            int[] unitArray = new int[4];
            //必要な値を抽出
            // (保険)単位数合計 + (保険分出来高医療費)単位数合計
            unitArray[0] = ACCastUtilities.toInt(map.get("701014"), 0) + ACCastUtilities.toInt(map.get("701027"), 0);
            //(公費1)単位数合計 + (公費1分出来高医療費)単位数合計
            unitArray[1] = ACCastUtilities.toInt(map.get("701018"), 0) + ACCastUtilities.toInt(map.get("701030"), 0);
            //(公費2)単位数合計 + (公費2分出来高医療費)単位数合計
            unitArray[2] = ACCastUtilities.toInt(map.get("701021"), 0) + ACCastUtilities.toInt(map.get("701033"), 0);
            //(公費3)単位数合計 + (公費3分出来高医療費)単位数合計
            unitArray[3] = ACCastUtilities.toInt(map.get("701024"), 0) + ACCastUtilities.toInt(map.get("701036"), 0);
            
            
            //現在処遇改善レコードに設定されている値を引く
            //これが、処遇改善加算算定の元となる単位数
            // サービス単位数
            unitArray[0] -= ACCastUtilities.toInt(row.get("301014"), 0);
            //公費1対象サービス単位数
            unitArray[1] -= ACCastUtilities.toInt(row.get("301015"), 0);
            //公費2対象サービス単位数
            unitArray[2] -= ACCastUtilities.toInt(row.get("301016"), 0);
            //公費3対象サービス単位数
            unitArray[3] -= ACCastUtilities.toInt(row.get("301017"), 0);
            
            
            //処遇改善加算を再計算し、設定
            int serviceUnit = ACCastUtilities.toInt(servcie.get("SERVICE_UNIT"), 0);
            int serviceStaffUnit = ACCastUtilities.toInt(servcie.get("SERVICE_STAFF_UNIT"), 0);
            
            int _301014 = CareServiceCommon.calcSyogu(unitArray[0], serviceUnit, serviceStaffUnit);
            int _301015 = CareServiceCommon.calcSyogu(unitArray[1], serviceUnit, serviceStaffUnit);
            int _301016 = CareServiceCommon.calcSyogu(unitArray[2], serviceUnit, serviceStaffUnit);
            int _301017 = CareServiceCommon.calcSyogu(unitArray[3], serviceUnit, serviceStaffUnit);
            
            //単位数の再設定
            row.put("301014", _301014);
            row.put("301009", _301014);
            
            row.put("301015", _301015);
            row.put("301016", _301016);
            row.put("301017", _301017);
            
            //公費1回数
            setSyoguKohiCount(row, _301015, "301011");
            //公費2回数
            setSyoguKohiCount(row, _301016, "301012");
            //公費3回数
            setSyoguKohiCount(row, _301017, "301013");
            
        }
        
        // 処遇改善の値を編集したので、集計情報レコードを再作成
        parseType();
        
    }
    
    private VRMap getType(String servcieCodeKind) throws Exception {
        
        if (type.isEmpty()) {
            return null;
        }
        
        VRMap map = null;
        
        for (Object row : type) {
            map = (VRMap)row;
            //サービス種類コードを比較
            //一致する場合は処理終了
            if (servcieCodeKind.equals(ACCastUtilities.toString(map.get("701007"), ""))) {
                return map;
            }
        }
        
        return null;
    }
    
    
    private VRMap getServcieCode(VRMap row) throws Exception {
        
        String systemServiceKind = ACCastUtilities.toString(row.get("301021"), "");
        String systemServiceItem = ACCastUtilities.toString(row.get("301022"), "");
        String target = VRDateParser.format(targetDate, "yyyy/MM/dd");
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT * FROM M_SERVICE_CODE WHERE");
        sql.append("(SYSTEM_SERVICE_KIND_DETAIL = ");
        sql.append(systemServiceKind);
        sql.append(") AND (SYSTEM_SERVICE_CODE_ITEM = '");
        sql.append(systemServiceItem);
        sql.append("') AND (SERVICE_VALID_START <= '");
        sql.append(target);
        sql.append("') AND (SERVICE_VALID_END >= '");
        sql.append(target);
        sql.append("')");
        
        VRList list = dbm.executeQuery(sql.toString());
        if (list.isEmpty()) {
            return null;
        }
        
        return (VRMap)list.get(0);
    }
    
    private void setSyoguKohiCount(VRMap detail, int kohiUnit, String bindPath) throws Exception {
        if (0 < kohiUnit) {
            detail.put(bindPath, 1);
        } else {
            detail.put(bindPath, 0);
        }
    }
    
    //[ID:0000726][Shin Fujihara] 2012/04 add end
    

    /**
     * 集計情報レコードの集計処理
     * 
     * @throws Exception
     */
    private void parseType() throws Exception {

        // 集計情報の合計金額を一旦クリア
        for (int i = 0; i < type.size(); i++) {
            VRMap map = (VRMap) type.get(i);
            // 計画単位数
            // map.put("701009", "0");
            // 限度額管理対象単位数
            map.put("701010", "0");
            // 限度額管理対象外単位数
            map.put("701011", "0");
            // 保険単位数合計
            map.put("701014", "0");
            // (公費1)単位数合計
            map.put("701018", "0");
            // 公費１請求額
            map.put("701019", "0");
            // 公費１本人負担額
            map.put("701020", "0");
            // (公費2)単位数合計
            map.put("701021", "0");
            // 公費２請求額
            map.put("701022", "0");
            // 公費２本人負担額
            map.put("701023", "0");
            // (公費3)単位数合計
            map.put("701024", "0");
            // 公費３請求額を0とする
            map.put("701025", "0");
            // 公費３本人負担額
            map.put("701026", "0");
            // (保険分出来高医療費)単位数合計
            map.put("701027", "0");
            // (保険分出来高医療費)請求額9桁
            map.put("701028", "0");
            // (保険分出来高医療費)出来高医療費利用者負担額8桁
            map.put("701029", "0");
            // (公費1分出来高医療費)単位数合計8桁
            map.put("701030", "0");
            // (公費1分出来高医療費)請求額9桁
            map.put("701031", "0");
            // (公費1分出来高医療費)出来高医療費本人負担額8桁
            map.put("701032", "0");
            // (公費2分出来高医療費)単位数合計8桁
            map.put("701033", "0");
            // (公費2分出来高医療費)請求額9桁
            map.put("701034", "0");
            // (公費2分出来高医療費)出来高医療費本人負担額8桁
            map.put("701035", "0");
            // (公費3分出来高医療費)単位数合計8桁
            map.put("701036", "0");
            // (公費3分出来高医療費)請求額9桁
            map.put("701037", "0");
            // (公費3分出来高医療費)出来高医療費本人負担額8桁
            map.put("701038", "0");

        }

        /* ====================================================== */
        // 明細情報を集計情報にまとめる
        /* ====================================================== */
        int toolsTotalDay = Integer.MIN_VALUE;
        int toolsTotalDayYobo = Integer.MIN_VALUE;
        //外部利用型使用フラグ
        boolean externalUse = false;
        for (int i = 0; i < detail.size(); i++) {
            VRMap map = (VRMap) detail.get(i);
            VRMap tmap = getTypeMap(toString(map, "301007"));
            if (tmap == null) {
                continue;
            }

            // 限度額管理対象フラグ
            switch (toInt(map, "301020")) {
            // 1(限度額管理対象)の場合
            case 1:
                // 計画単位数
                // addAppend(tmap, "701009", map, "301014");
                // 限度額管理対象単位数
                addAppend(tmap, "701010", map, "301014");
                break;
            // 2(限度額管理対象外)の場合
            case 2:
                // 限度額管理対象外単位数
                addAppend(tmap, "701011", map, "301014");
                break;
            // 3(外部利用型)の場合
            case 3:
                // 計画単位数(そっとしておく？)
                // set_701009(ACCastUtilities.toInt(patientState.getNinteiDataHeavy(get_701005(),get_701006(),"EXTERNAL_USE_LIMIT"),0));
                // 限度額管理対象単位数
                addAppend(tmap, "701010", map, "301014");
                externalUse = true;
                break;
            }

            // 保険単位数合計
            addAppend(tmap, "701014", map, "301014");
            // (公費1)単位数合計
            addAppend(tmap, "701018", map, "301015");
            // (公費2)単位数合計
            addAppend(tmap, "701021", map, "301016");
            // (公費3)単位数合計
            addAppend(tmap, "701024", map, "301017");

            // 福祉用具例外処理
            switch (toInt(map, "301007")) {
            // 福祉用具
            case 17:
                if (toolsTotalDay < toInt(map, "301010")) {
                    tmap.put("701008", map.get("301010"));
                    toolsTotalDay = toInt(map, "301010");
                }
                break;
            // 予防福祉用具
            case 67:
                if (toolsTotalDayYobo < toInt(map, "301010")) {
                    tmap.put("701008", map.get("301010"));
                    toolsTotalDayYobo = toInt(map, "301010");
                }
                break;
            }
        }
        

        /* ====================================================== */
        // 集計情報レコード自身の確定
        /* ====================================================== */

        for (int i = 0; i < type.size(); i++) {
            VRMap map = (VRMap) type.get(i);

            // 限度額管理対象単位数と限度額管理対象外単位数が0なら、集計レコード自体を削除
            if ((toInt(map, "701010") == 0) && (toInt(map, "701011") == 0)) {
                type.remove(i);
                i--;
                continue;
            }
            
            // [ID:0000576]計画単位数上書きフラグを確認
            // 確定している計画単位数として、限度額管理対象単位数を設定する
            // ※こうしておかないと、
            // 明細レコード削除=>自動再集計で限度額対象単位数を採用
            // （でも、701046のデータは残る）
            // 画面を開きなおして、再集計ボタンを押す
            // 701046のデータが残っているので、以前の計画単位数が採用されてしまう
            if (isPlanOverwrite) {
                map.put("701046", map.get("701010"));
            }

            // 計画単位数
            // 実績集計時、確定している計画単位数が存在しない場合
            if (ACTextUtilities.isNullText(map.get("701046"))) {
                // 限度額管理対象単位数を計画単位数とする
                map.put("701009", map.get("701010"));
            } else {
                map.put("701009", map.get("701046"));
            }

            // 計画単位数と限度額対象管理数の少ないほうを採用する
            if (toInt(map, "701009") < toInt(map, "701010")) {
                map.put("701014",
                        String.valueOf(toInt(map, "701009")
                                + toInt(map, "701011")));
            } else {
                map.put("701014",
                        String.valueOf(toInt(map, "701010")
                                + toInt(map, "701011")));
            }

            // 生保単独
            if (QP001SpecialCase.isSeihoOnly(toString(map, "701006"))) {
                map.put("701016", "0");
            } else {
                // 対象単位数×単位数単価(小数点以下切捨て)
                int totalUnit = (int) Math
                        .floor((double) (toInt(map, "701014") * getMultiplies100(
                                map, "701015")) / 100d);
                // 保険給付率
                totalUnit = (int) Math.floor((totalUnit * getRate()) / 100d);
                map.put("701016", String.valueOf(totalUnit));
            }

            // 公費の単位数確定
            // 計画単位数 < 限度額管理対象単位数の場合、保険単位数 < 公費単位数と
            // なってしまうため、補正を行う
            int _701014 = ACCastUtilities.toInt(map.get("701014"), 0);

            // 公費１単位数確認
            if (_701014 < ACCastUtilities.toInt(map.get("701018"), 0)) {
                map.put("701018", map.get("701014"));
            }
            // 公費２単位数確認
            if (_701014 < ACCastUtilities.toInt(map.get("701021"), 0)) {
                map.put("701021", map.get("701014"));
            }
            // 公費３単位数確認
            if (_701014 < ACCastUtilities.toInt(map.get("701024"), 0)) {
                map.put("701024", map.get("701014"));
            }

            // 公費算定
            int kohiClaim = 0;
            int reduction = 0;
            // 給付率取得
            int usedRate = getRate();

            boolean kohiEnd = false;

            // 公費１の適用あり
            if ((getKohiRate(1) != 0) && (toInt(map, "701018") != 0)) {
                kohiClaim = getKohiClaim(map, toInt(map, "701018"),
                        getKohiRate(1), 0, usedRate);
                reduction += kohiClaim;
                // ((公費1)請求額)に値を設定する。
                map.put("701019",
                        String.valueOf(toInt(map, "701019") + kohiClaim));
                // 適用した公費を退避する。
                usedRate = getKohiRate(1);
                // 公費1の給付率が100%の場合処理を終了する。
                if (getKohiRate(1) == 100)
                    kohiEnd = true;
            }
            // 公費２の適用あり
            if (!kohiEnd && (getKohiRate(2) != 0)
                    && (toInt(map, "701021") != 0)) {
                if (getKohiRate(2) > usedRate) {
                    kohiClaim = getKohiClaim(map, toInt(map, "701021"),
                            getKohiRate(2), reduction, usedRate);
                    reduction += kohiClaim;
                    // ((公費2)請求額)に値を設定する。
                    map.put("701022",
                            String.valueOf(toInt(map, "701022") + kohiClaim));
                    // 適用した公費を退避する。
                    usedRate = getKohiRate(2);
                    if (getKohiRate(2) == 100)
                        kohiEnd = true;
                }
            }

            // 公費３の適用あり
            if (!kohiEnd && (getKohiRate(3) != 0)
                    && (toInt(map, "701024") != 0)) {
                if (getKohiRate(3) > usedRate) {
                    kohiClaim = getKohiClaim(map, toInt(map, "701024"),
                            getKohiRate(3), reduction, usedRate);
                    reduction += kohiClaim;
                    // ((公費3)請求額)に値を設定する。
                    map.put("701025",
                            String.valueOf(toInt(map, "701025") + kohiClaim));
                }
            }

            // 公費本人負担額の算定
            int selfPay = 0;
            int kohiCost = 0;
            // 公費１の適用あり
            if (getKohiRate(1) != 0) {
                selfPay = patientState.getKohiSelfPay(getKohiType(1), 1);
                if (selfPay != 0) {
                    // 様式第八、第九、第十の場合で且つ生保単独者で無い場合は、自己負担額の使用に制限をかける
                    kohiCost = 0;
                    if (nursingTotal != null) {
                        kohiCost = toInt(nursingTotal, "801026");
                    }

                    selfPay = QP001SpecialCase.convertSelfPay(
                            toString(map, "701001"), toString(map, "701006"),
                            selfPay, getKohiType(1), kohiCost);

                    // 公費１請求額と本人負担額を比較し、本人負担額が大きい場合
                    if (toInt(map, "701019") < selfPay) {
                        // 公費１本人負担額に公費１請求額を設定する
                        map.put("701020", map.get("701019"));
                        // 公費１請求額を0とする
                        map.put("701019", "0");
                        // 使用した公費自己負担額を設定する。
                        patientState.setKohiSelfPayUse(getKohiType(1),
                                toInt(map, "701020"));
                    } else {
                        map.put("701020", String.valueOf(selfPay));
                        sub(map, "701019", new String[] { "701019", "701020" });
                        // 使用した公費自己負担額を設定する。
                        patientState.setKohiSelfPayUse(getKohiType(1), selfPay);
                    }

                }
            }

            // 公費２の本人負担額を取得
            if (getKohiRate(2) != 0) {
                selfPay = patientState.getKohiSelfPay(getKohiType(2), 1);
                if (selfPay != 0) {
                    kohiCost = 0;
                    if (nursingTotal != null) {
                        kohiCost = toInt(nursingTotal, "801029");
                    }

                    selfPay = QP001SpecialCase.convertSelfPay(
                            toString(map, "701001"), toString(map, "701006"),
                            selfPay, getKohiType(2), kohiCost);

                    // 公費２請求額と本人負担額を比較し、本人負担が大きい場合
                    if (toInt(map, "701022") < selfPay) {
                        // 公費２本人負担額に公費２請求額を設定する。
                        map.put("701023", map.get("701022"));
                        // 公費２請求額を0とする
                        map.put("701022", "0");
                        // 使用した公費自己負担額を設定する。
                        patientState.setKohiSelfPayUse(getKohiType(2),
                                toInt(map, "701023"));

                    } else {
                        map.put("701023", String.valueOf(selfPay));
                        sub(map, "701022", new String[] { "701022", "701023" });
                        // 使用した公費自己負担額を設定する。
                        patientState.setKohiSelfPayUse(getKohiType(2), selfPay);
                    }
                }

                // 公費３の本人負担額を取得
                if (getKohiRate(3) != 0) {
                    selfPay = patientState.getKohiSelfPay(getKohiType(3), 1);
                    if (selfPay != 0) {
                        kohiCost = 0;
                        if (nursingTotal != null) {
                            kohiCost = toInt(nursingTotal, "801032");
                        }

                        selfPay = QP001SpecialCase.convertSelfPay(
                                toString(map, "701001"),
                                toString(map, "701006"), selfPay,
                                getKohiType(3), kohiCost);

                        // 公費３請求額と本人負担額を比較し、本人負担が大きい場合
                        if (toInt(map, "701025") < selfPay) {
                            // 公費３本人負担額に公費３請求額を設定する。
                            map.put("701026", map.get("701025"));
                            // 公費３請求額を0とする
                            map.put("701025", "0");
                            // 使用した公費自己負担額を設定する。
                            patientState.setKohiSelfPayUse(getKohiType(3),
                                    toInt(map, "701026"));

                        } else {
                            map.put("701026", String.valueOf(selfPay));
                            sub(map, "701025", new String[] { "701025",
                                    "701026" });
                            // 使用した公費自己負担額を設定する。
                            patientState.setKohiSelfPayUse(getKohiType(3),
                                    selfPay);
                        }
                    }
                }

            }

            // 利用者負担額の確定を行う。
            // 総額-介護保険負担-公費１-公費２-公費３-公費１本人負担-公費２本人負担-公費３本人負担
            map.put("701017", String.valueOf((int) Math.floor((double) (toInt(
                    map, "701014") * getMultiplies100(map, "701015")) / 100d)));
            sub(map, "701017", new String[] { "701017", "701016", "701019",
                    "701022", "701025", "701020", "701023", "701026" });
            
            
            // 様式第六の三、様式第六の四の例外処理
            String identificationNo = ACCastUtilities.toString(map.get("701001"), ""); 
            if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(identificationNo)
                || QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(identificationNo)) {
                
                //外部利用型未使用の場合
                if (!externalUse) {
                    //限度額管理対象外単位数を0にする
                    map.put("701011", "0");
                }
            }
        }

        /* ====================================================== */
        // 特定診療費情報レコードを集計情報にまとめる
        /* ====================================================== */
        for (int i = 0; i < diagnosis.size(); i++) {
            VRMap map = (VRMap) diagnosis.get(i);
            // レコード順次番号が99のものを採用
            if (toInt(map, "501007") != 99) {
                continue;
            }
            // 確定処理
            commitDiagnosis(map);
            break;
        }

        /* ====================================================== */
        // 緊急時情報レコードの公費を集計情報にまとめる
        /* ====================================================== */
        if (type.size() == 1) {
            VRMap map = (VRMap) type.get(0);

            String identity = toString(map, "701001");
            // この条件に入る場合は、集計情報レコードは1レコードの場合のみ
            if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(identity)
                    || QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(identity)) {
                // 様式第四、
                // 確定処理実行
                commitEmergency(map);
                
            
            } else if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(identity)) {
                // 第九の場合、緊急時治療管理・自施設療養費の確定処理
                commitEmergencyOwnFacility(map);
                
            }
        }

        /* ====================================================== */
        // 公費自己負担額確定
        /* ====================================================== */
        for (int i = 0; i < type.size(); i++) {
            VRMap map = (VRMap) type.get(i);
            commitSeflPay(map);
        }

        // 公費自己負担額の算定
        if (nursingTotal == null) {
            return;
        }

        // 様式第八、第九、第十以外の場合は処理を中断する。
        if (!QP001SpecialCase.isShisetsuDiscriminationNo(toString(nursingTotal,
                "801001"))) {
            return;
        }

        // 公費１の適用があるか確認
        if (getKohiRate(1) != 0) {
            // 公費１自己負担額の設定を行う。
            int selfPay = patientState.getKohiSelfPay(getKohiType(1), 1);
            // 公費自己負担額の方が大きければ
            if (toInt(nursingTotal, "801026") < selfPay) {
                // (公費1)本人負担額5桁に請求額を設定する。
                nursingTotal.put("801027", nursingTotal.get("801026"));
                // 公費1請求額を0に設定する。
                nursingTotal.put("801026", "0");
                // 使用した自己負担を報告する。
                patientState.setKohiSelfPayUse(getKohiType(1),
                        toInt(nursingTotal, "801027"));

            } else {
                // 公費１請求額から公費自己負担分を減算する
                nursingTotal
                        .put("801026",
                                String.valueOf(toInt(nursingTotal, "801026")
                                        - selfPay));
                // 公費１自己負担額を設定する。
                nursingTotal.put("801027", String.valueOf(selfPay));
                // 使用した自己負担を報告する。
                patientState.setKohiSelfPayUse(getKohiType(1), selfPay);
            }
        }

        // 公費２の適用があるか確認
        if (getKohiRate(2) != 0) {
            // 公費２自己負担額の設定を行う。
            int selfPay = patientState.getKohiSelfPay(getKohiType(2), 1);
            // 公費自己負担額の方が大きければ
            if (toInt(nursingTotal, "801029") < selfPay) {
                // (公費2)本人負担額5桁に請求額を設定する。
                nursingTotal.put("801030", nursingTotal.get("801029"));
                // 公費2請求額を0に設定する。
                nursingTotal.put("801029", "0");
                // 使用した自己負担を報告する。
                patientState.setKohiSelfPayUse(getKohiType(2),
                        toInt(nursingTotal, "801030"));

            } else {
                // 公費２請求額から公費自己負担分を減算する
                nursingTotal
                        .put("801029",
                                String.valueOf(toInt(nursingTotal, "801029")
                                        - selfPay));
                // 公費２自己負担額を設定する。
                nursingTotal.put("801030", String.valueOf(selfPay));
                // 使用した自己負担を報告する。
                patientState.setKohiSelfPayUse(getKohiType(2), selfPay);
            }
        }

        // 公費３の適用があるか確認
        if (getKohiRate(3) != 0) {
            // 公費３自己負担額の設定を行う。
            int selfPay = patientState.getKohiSelfPay(getKohiType(3), 1);
            // 公費自己負担額の方が大きければ
            if (toInt(nursingTotal, "801032") < selfPay) {
                // (公費3)本人負担額5桁に請求額を設定する。
                nursingTotal.put("801033", nursingTotal.get("801032"));
                // 公費3請求額を0に設定する。
                nursingTotal.put("801032", "0");
                // 使用した自己負担を報告する。
                patientState.setKohiSelfPayUse(getKohiType(3),
                        toInt(nursingTotal, "801031"));

            } else {
                // 公費３請求額から公費自己負担分を減算する
                nursingTotal
                        .put("801032",
                                String.valueOf(toInt(nursingTotal, "801032")
                                        - selfPay));
                // 公費３自己負担額を設定する。
                nursingTotal.put("801033", String.valueOf(selfPay));
                // 使用した自己負担を報告する。
                patientState.setKohiSelfPayUse(getKohiType(3), selfPay);
            }
        }
    }

    /**
     * 特定診療費情報レコードの内容を、集計情報レコードに反映する。
     * 
     * @param map
     * @throws Exception
     */
    private void commitDiagnosis(VRMap map) throws Exception {

        VRMap tmap = (VRMap) type.get(0);

        // (保険分出来高医療費)単位数合計
        tmap.put("701027", map.get("501013"));

        // 生保単独の場合
        if (QP001SpecialCase.isSeihoOnly(toString(tmap, "701005"))) {
            tmap.put("701028", "0");
            baseCache.put("201037", "0");
        } else {
            tmap.put("701028", String.valueOf((int) Math.floor((double) (toInt(
                    tmap, "701027") * 10 * getRate()) / 100d)));
            baseCache.put("201037", tmap.get("701028"));
        }
        // (公費1分出来高医療費)単位数合計
        tmap.put("701030", map.get("501016"));
        // (公費2分出来高医療費)単位数合計
        tmap.put("701033", map.get("501019"));
        // (公費3分出来高医療費)単位数合計
        tmap.put("701036", map.get("501022"));

        // 公費費用計算
        int totalRate = toInt(tmap, "701027") * 10;
        int amendsRate = getRate();

        // 公費1の適用あり
        if (getKohiRate(1) != 0) {
            // 月途中公費を疑う
            if (toInt(tmap, "701027") == toInt(tmap, "701030")) {
                // 月途中公費なし
                // 給付率100
                if (getKohiRate(1) == 100) {
                    // 高額医療合計金額-保険請求額
                    // sub(tmap, "701031", new String[]{"701027", "701028"});
                    tmap.put("701031",
                            String.valueOf(totalRate - toInt(tmap, "701028")));

                } else {
                    tmap.put(
                            "701031",
                            String.valueOf((int) Math.floor(totalRate
                                    * (getKohiRate(1) - getRate()) / 100)));
                }

            } else {
                // 月途中公費あり
                tmap.put(
                        "701031",
                        String.valueOf((int) Math.floor(toInt(tmap, "701030")
                                * 10 * (getKohiRate(1) - amendsRate) / 100)));
                amendsRate = getKohiRate(1);
            }
            baseCache.put("201043", tmap.get("701031"));
        }

        // 公費の対象となる自己負担額が残っているか確認
        if (totalRate >= (toInt(tmap, "701028") + toInt(tmap, "701031"))) {
            // 公費2の適用がある場合
            if (getKohiRate(2) != 0) {
                // 月途中公費を疑う
                if (toInt(tmap, "701027") == toInt(tmap, "701033")) {
                    // 月途中公費なし
                    // 給付率100
                    if (getKohiRate(2) == 100) {
                        tmap.put(
                                "701034",
                                String.valueOf(totalRate
                                        - toInt(tmap, "701028")
                                        - toInt(tmap, "701031")));
                    } else {
                        tmap.put(
                                "701034",
                                String.valueOf((int) Math.floor(totalRate
                                        * (getKohiRate(2) - getKohiRate(1))
                                        / 100)));
                    }

                } else {
                    // 月途中公費あり
                    tmap.put("701034", String.valueOf((int) Math.floor(toInt(
                            tmap, "701033")
                            * 10
                            * (getKohiRate(2) - amendsRate) / 100)));
                    amendsRate = getKohiRate(2);
                }
                baseCache.put("201049", tmap.get("701034"));
            }
        }
        // 公費の対象となる自己負担が残っているか確認
        if (totalRate >= (toInt(tmap, "701028") + toInt(tmap, "701031") + toInt(
                tmap, "701034"))) {
            // 公費2の適用がある場合
            if (getKohiRate(3) != 0) {
                // 月途中公費を疑う
                if (toInt(tmap, "701027") == toInt(tmap, "701036")) {
                    // 月途中公費なし
                    // 給付率100
                    if (getKohiRate(3) == 100) {
                        tmap.put(
                                "701037",
                                String.valueOf(totalRate
                                        - toInt(tmap, "701028")
                                        - toInt(tmap, "701031")
                                        - toInt(tmap, "701034")));
                    } else {
                        tmap.put(
                                "701037",
                                String.valueOf((int) Math.floor(totalRate
                                        * (getKohiRate(3) - getKohiRate(2))
                                        / 100)));
                    }

                } else {
                    // 月途中公費あり
                    tmap.put("701037", String.valueOf((int) Math.floor(toInt(
                            tmap, "701036")
                            * 10
                            * (getKohiRate(3) - amendsRate) / 100)));
                }
                baseCache.put("201055", tmap.get("701037"));
            }
        }
    }

    /**
     * 緊急時治療確定処理
     * 
     * @param tmap
     *            基本情報レコード
     * @throws Exception
     */
    private void commitEmergency(VRMap tmap) throws Exception {

        VRMap map = null;

        for (int i = 0; i < emergency.size(); i++) {
            map = (VRMap) emergency.get(i);
            // レコード順次番号が99のものを採用
            if (toInt(map, "401007") == 99) {
                break;
            }
        }

        // レコード順次番号99のレコードが存在しない
        // 処理終了
        if (map == null) {
            return;
        }

        int _701028 = 0;
        // (保険分出来高医療費)単位数合計
        addAppend(tmap, "701027", map, "401046");

        // 公費単独受給者の場合
        if (QP001SpecialCase.isSeihoOnly(toString(tmap, "701005"))) {
            // (保険分出来高医療費)請求額 0を設定する。
            baseCache.put("201036", "0");
        } else {
            // (保険分出来高医療費)請求額を算出する。
            _701028 = (int) Math
                    .floor((double) (toInt(map, "401046") * 10 * getRate()) / 100d);
            baseCache.put("201036", String.valueOf(_701028));
        }
        addAppend(tmap, "701028", baseCache, "201036");

        // 公費費用計算
        // 保険分出来高医療単位数合計
        int totalRate = toInt(map, "401046") * 10;
        int amendsRate = getRate();

        // ※月途中公費は考慮しない
        // 公費1の適用あり
        if ((getKohiRate(1) != 0) && emergencyKohi.contains(getKohiType(1))) {

            // (公費1分出来高医療費)単位数合計
            addAppend(tmap, "701030", map, "401046");
            // 給付率100
            if (getKohiRate(1) == 100) {
                baseCache.put("201042", String.valueOf(totalRate - _701028));
            } else {
                baseCache.put(
                        "201042",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(1) - getRate()) / 100)));
            }
            addAppend(tmap, "701031", baseCache, "201042");
            amendsRate = getKohiRate(1);
        }

        // 公費2の適用あり
        if ((getKohiRate(2) != 0) && (amendsRate < getKohiRate(2))
                && emergencyKohi.contains(getKohiType(2))) {

            // (公費2分出来高医療費)単位数合計
            addAppend(tmap, "701033", map, "401046");
            // 給付率100
            if (getKohiRate(2) == 100) {
                baseCache.put(
                        "201048",
                        String.valueOf(totalRate - _701028
                                - toInt(baseCache, "201042")));
            } else {
                baseCache.put(
                        "201048",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(2) - amendsRate) / 100)));
            }
            addAppend(tmap, "701034", baseCache, "201048");
            amendsRate = getKohiRate(2);
        }

        // 公費3の適用あり
        if ((getKohiRate(3) != 0) && (amendsRate < getKohiRate(3))
                && emergencyKohi.contains(getKohiType(3))) {

            // (公費3分出来高医療費)単位数合計
            addAppend(tmap, "701036", map, "401046");
            // 給付率100
            if (getKohiRate(3) == 100) {
                baseCache.put(
                        "201054",
                        String.valueOf(totalRate - _701028
                                - toInt(baseCache, "201042")
                                - toInt(baseCache, "201048")));
            } else {
                baseCache.put(
                        "201054",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(3) - amendsRate) / 100)));
            }
            addAppend(tmap, "701037", baseCache, "201054");
            amendsRate = getKohiRate(1);
        }

    }
    
    
    
    /**
     * 緊急時治療・自施設療養費確定処理
     * 
     * @param tmap
     *            基本情報レコード
     * @throws Exception
     */
    private void commitEmergencyOwnFacility(VRMap tmap) throws Exception {

        VRMap map = null;

        for (int i = 0; i < emergencyOwnFacility.size(); i++) {
            map = (VRMap) emergencyOwnFacility.get(i);
            // レコード順次番号が99のものを採用
            if (toInt(map, "1701007") == 99) {
                break;
            }
        }

        // レコード順次番号99のレコードが存在しない
        // 処理終了
        if (map == null) {
            return;
        }

        int _701028 = 0;
        // (保険分出来高医療費)単位数合計
        addAppend(tmap, "701027", map, "1701046");

        // 公費単独受給者の場合
        if (QP001SpecialCase.isSeihoOnly(toString(tmap, "701005"))) {
            // (保険分出来高医療費)請求額 0を設定する。
            baseCache.put("201036", "0");
        } else {
            // (保険分出来高医療費)請求額を算出する。
            _701028 = (int) Math
                    .floor((double) (toInt(map, "1701046") * 10 * getRate()) / 100d);
            baseCache.put("201036", String.valueOf(_701028));
        }
        addAppend(tmap, "701028", baseCache, "201036");

        // 公費費用計算
        // 保険分出来高医療単位数合計
        int totalRate = toInt(map, "1701046") * 10;
        int amendsRate = getRate();

        // ※月途中公費は考慮しない
        // 公費1の適用あり
        if ((getKohiRate(1) != 0) && emergencyKohi.contains(getKohiType(1))) {

            // (公費1分出来高医療費)単位数合計
            addAppend(tmap, "701030", map, "1701046");
            // 給付率100
            if (getKohiRate(1) == 100) {
                baseCache.put("201042", String.valueOf(totalRate - _701028));
            } else {
                baseCache.put(
                        "201042",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(1) - getRate()) / 100)));
            }
            addAppend(tmap, "701031", baseCache, "201042");
            amendsRate = getKohiRate(1);
        }

        // 公費2の適用あり
        if ((getKohiRate(2) != 0) && (amendsRate < getKohiRate(2))
                && emergencyKohi.contains(getKohiType(2))) {

            // (公費2分出来高医療費)単位数合計
            addAppend(tmap, "701033", map, "1701046");
            // 給付率100
            if (getKohiRate(2) == 100) {
                baseCache.put(
                        "201048",
                        String.valueOf(totalRate - _701028
                                - toInt(baseCache, "201042")));
            } else {
                baseCache.put(
                        "201048",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(2) - amendsRate) / 100)));
            }
            addAppend(tmap, "701034", baseCache, "201048");
            amendsRate = getKohiRate(2);
        }

        // 公費3の適用あり
        if ((getKohiRate(3) != 0) && (amendsRate < getKohiRate(3))
                && emergencyKohi.contains(getKohiType(3))) {

            // (公費3分出来高医療費)単位数合計
            addAppend(tmap, "701036", map, "1701046");
            // 給付率100
            if (getKohiRate(3) == 100) {
                baseCache.put(
                        "201054",
                        String.valueOf(totalRate - _701028
                                - toInt(baseCache, "201042")
                                - toInt(baseCache, "201048")));
            } else {
                baseCache.put(
                        "201054",
                        String.valueOf((int) Math.floor(totalRate
                                * (getKohiRate(3) - amendsRate) / 100)));
            }
            addAppend(tmap, "701037", baseCache, "201054");
            amendsRate = getKohiRate(1);
        }

    }

    /**
     * 公費自己負担額の算定
     * 
     * @param tmap
     * @throws Exception
     */
    private void commitSeflPay(VRMap tmap) throws Exception {

        // 公費本人負担額の算出を行う
        int selfPay = 0;
        // 公費１の本人負担額
        if (toInt(tmap, "701031") != 0) {
            selfPay = patientState.getKohiSelfPay(getKohiType(1), 1);
            if (selfPay != 0) {
                selfPay = QP001SpecialCase.getApplicationIndividualPayment(
                        toString(tmap, "701001"), toString(tmap, "701006"),
                        selfPay, toInt(tmap, "701020"), getKohiType(1),
                        nursingTotal);

                // 公費１請求額と本人負担額を比較し、本人負担額が大きい場合
                if (toInt(tmap, "701031") < selfPay) {
                    // 公費１本人負担額に公費１請求額を設定する
                    tmap.put("701032", tmap.get("701031"));
                    // 公費１請求額を0とする
                    tmap.put("701031", "0");
                    // 使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(getKohiType(1),
                            toInt(tmap, "701032"));

                } else {
                    tmap.put("701032", String.valueOf(selfPay));
                    sub(tmap, "701031", new String[] { "701031", "701032" });
                    // 使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(getKohiType(1), selfPay);
                }

                // 請求額から利用者負担額を差し引く
                subAmountClaimed("701032", selfPay);
            }
        }

        // 公費２の本人負担額を取得
        if (toInt(tmap, "701034") != 0) {
            selfPay = patientState.getKohiSelfPay(getKohiType(2), 1);
            if (selfPay != 0) {
                selfPay = QP001SpecialCase.getApplicationIndividualPayment(
                        toString(tmap, "701001"), toString(tmap, "701006"),
                        selfPay, toInt(tmap, "701023"), getKohiType(2),
                        nursingTotal);

                // 公費２請求額と本人負担額を比較し、本人負担額が大きい場合
                if (toInt(tmap, "701034") < selfPay) {
                    // 公費２本人負担額に公費２請求額を設定する
                    tmap.put("701035", tmap.get("701034"));
                    // 公費２請求額を0とする
                    tmap.put("701034", "0");
                    // 使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(getKohiType(2),
                            toInt(tmap, "701035"));

                } else {
                    tmap.put("701035", String.valueOf(selfPay));
                    sub(tmap, "701034", new String[] { "701034", "701035" });
                    // 使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(getKohiType(2), selfPay);
                }

                // 請求額から利用者負担額を差し引く
                subAmountClaimed("701035", selfPay);
            }
        }

        // 公費３の本人負担額を取得
        if (toInt(tmap, "701037") != 0) {
            selfPay = patientState.getKohiSelfPay(getKohiType(3), 1);
            if (selfPay != 0) {
                selfPay = QP001SpecialCase.getApplicationIndividualPayment(
                        toString(tmap, "701001"), toString(tmap, "701006"),
                        selfPay, toInt(tmap, "701026"), getKohiType(3),
                        nursingTotal);

                // 公費３請求額と本人負担額を比較し、本人負担額が大きい場合
                if (toInt(tmap, "701037") < selfPay) {
                    // 公費３本人負担額に公費３請求額を設定する
                    tmap.put("701038", tmap.get("701037"));
                    // 公費３請求額を0とする
                    tmap.put("701037", "0");
                    // 使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(getKohiType(3),
                            toInt(tmap, "701038"));

                } else {
                    tmap.put("701038", String.valueOf(selfPay));
                    sub(tmap, "701037", new String[] { "701037", "701038" });
                    // 使用した公費自己負担額を設定する。
                    patientState.setKohiSelfPayUse(getKohiType(3), selfPay);
                }

                // 請求額から利用者負担額を差し引く
                subAmountClaimed("701038", selfPay);
            }
        }

        // 利用者負担額を設定する。
        tmap.put("701029", String.valueOf(toInt(tmap, "701027") * 10));
        sub(tmap, "701029", new String[] { "701029", "701028", "701031",
                "701034", "701037", "701032", "701035", "701038" });
    }

    /**
     * 請求額から利用者負担分の金額を差し引く
     * 
     * @param key
     * @param selfPay
     * @throws Exception
     */
    private void subAmountClaimed(String key, int selfPay) throws Exception {

        String[] keys = null;

        // 利用者負担１
        if ("701032".equals(key)) {
            keys = new String[] { "201042", "201043" };

            // 利用者負担２
        } else if ("701035".equals(key)) {
            keys = new String[] { "201048", "201049" };

            // 利用者負担３
        } else if ("701038".equals(key)) {
            keys = new String[] { "201054", "201055" };

        }

        if (keys == null) {
            return;
        }

        for (int i = 0; i < keys.length; i++) {

            if (!baseCache.containsKey(keys[i])) {
                continue;
            }

            int claim = ACCastUtilities.toInt(baseCache.get(keys[i]), 0);

            // 請求額よりも利用者負担額が大きい場合
            if (claim <= selfPay) {
                // 全額担保可能なので、Mapからキーを削除
                baseCache.remove(keys[i]);
                // 使用可能利用者負担額を差し引く
                selfPay -= claim;

                // 利用者負担額が少ない場合
            } else {
                // 請求額を再設定
                baseCache.put(keys[i], String.valueOf(claim - selfPay));
                return;
            }
        }
    }

    private VRMap getTypeMap(String code) throws Exception {
        VRMap result = null;

        for (int i = 0; i < type.size(); i++) {
            VRMap map = (VRMap) type.get(i);
            if (code.equals(toString(map, "701007"))) {
                result = map;
                break;
            }
        }

        return result;
    }

    /**
     * 基本情報レコードの集計処理
     * 
     * @throws Exception
     */
    private void parseBase() throws Exception {

        if (base.size() != 1) {
            return;
        }

        VRMap bmap = (VRMap) base.get(0);

        // 初期化
        // (合計情報 保険)サービス単位数8桁
        bmap.put("201033", "0");
        // (合計情報 保険)請求額9桁
        bmap.put("201034", "0");
        // (合計情報 保険)利用者負担額8桁
        bmap.put("201035", "0");

        // (合計情報 公費1)サービス単位数8桁
        bmap.put("201039", "0");
        // (合計情報 公費1)請求額8桁
        bmap.put("201040", "0");
        // (合計情報 公費1)本人負担額8桁
        bmap.put("201041", "0");

        // (合計情報 公費2)サービス単位数8桁
        bmap.put("201045", "0");
        // (合計情報 公費2)請求額8桁
        bmap.put("201046", "0");
        // (合計情報 公費2)本人負担額8桁
        bmap.put("201047", "0");

        // (合計情報 公費3)サービス単位数8桁
        bmap.put("201051", "0");
        // (合計情報 公費3)請求額8桁
        bmap.put("201052", "0");
        // (合計情報 公費3)本人負担額8桁
        bmap.put("201053", "0");

        // (合計情報 保険)特定診療費請求額9桁
        bmap.put("201037", "0");
        // (合計情報 公費1)特定診療費請求額8桁
        bmap.put("201043", "0");
        // (合計情報 公費2)特定診療費請求額8桁
        bmap.put("201049", "0");
        // (合計情報 公費3)特定診療費請求額8桁
        bmap.put("201055", "0");

        // (合計情報 保険)緊急時施設療養費請求額9桁
        bmap.put("201036", "0");
        // (合計情報 公費1)緊急時施設療養費請求額8桁
        bmap.put("201042", "0");
        // (合計情報 公費2)緊急時施設療養費請求額8桁
        bmap.put("201048", "0");
        // (合計情報 公費3)緊急時施設療養費請求額8桁
        bmap.put("201054", "0");

        for (int i = 0; i < type.size(); i++) {
            VRMap map = (VRMap) type.get(i);

            // (合計情報 保険)サービス単位数8桁
            addAppend(bmap, "201033", map, "701014");
            // (合計情報 保険)請求額9桁
            addAppend(bmap, "201034", map, "701016");
            // (合計情報 保険)利用者負担額8桁
            addAppend(bmap, "201035", map, "701017");

            // (合計情報 公費1)サービス単位数8桁
            addAppend(bmap, "201039", map, "701018");
            // (合計情報 公費1)請求額8桁
            addAppend(bmap, "201040", map, "701019");
            // (合計情報 公費1)本人負担額8桁
            addAppend(bmap, "201041", map, "701020");

            // (合計情報 公費2)サービス単位数8桁
            addAppend(bmap, "201045", map, "701021");
            // (合計情報 公費2)請求額8桁
            addAppend(bmap, "201046", map, "701022");
            // (合計情報 公費2)本人負担額8桁
            addAppend(bmap, "201047", map, "701023");

            // (合計情報 公費3)サービス単位数8桁
            addAppend(bmap, "201051", map, "701024");
            // (合計情報 公費3)請求額8桁
            addAppend(bmap, "201052", map, "701025");
            // (合計情報 公費3)本人負担額8桁
            addAppend(bmap, "201053", map, "701026");
        }

        // 緊急時、特定診療費のデータを入れる
        Iterator it = baseCache.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            bmap.put(key, baseCache.get(key));
        }

        // 特定入所者情報初期化
        if (nursingTotal == null) {
            // (合計情報 保険)特定入所者介護サービス費等請求額8桁
            bmap.put("201038", "0");
            // (合計情報 公費1)特定入所者介護サービス費等請求額8桁
            bmap.put("201044", "0");
            // (合計情報 公費2)特定入所者介護サービス費等請求額8桁
            bmap.put("201050", "0");
            // (合計情報 公費3)特定入所者介護サービス費等請求額8桁
            bmap.put("201056", "0");

            // 特定入所者情報コピー
        } else {
            // (合計情報 保険)特定入所者介護サービス費等請求額8桁
            bmap.put("201038", nursingTotal.get("801023"));
            // (合計情報 公費1)特定入所者介護サービス費等請求額8桁
            bmap.put("201044", nursingTotal.get("801026"));
            // (合計情報 公費2)特定入所者介護サービス費等請求額8桁
            bmap.put("201050", nursingTotal.get("801029"));
            // (合計情報 公費3)特定入所者介護サービス費等請求額8桁
            bmap.put("201056", nursingTotal.get("801032"));
        }

    }

    /**
     * 社福レコードの集計処理
     * 
     * @throws Exception
     */
    private void parseReduction() throws Exception {

        for (int i = 0; i < reduction.size(); i++) {
            VRMap map = (VRMap) reduction.get(i);

            // 対象の集計情報レコードを得る
            VRMap tmap = null;
            for (int j = 0; j < type.size(); j++) {
                VRMap tmp = (VRMap) type.get(j);
                if (toString(map, "901008").equals(toString(tmp, "701007"))) {
                    tmap = tmp;
                    break;
                }
            }
            if (tmap == null) {
                continue;
            }

            // 受領すべき利用者負担の総額
            map.put("901009", tmap.get("701017"));

            // 901010軽減額
            map.put("901010", String.valueOf((int) Math.floor((toInt(map,
                    "901009") * toInt(map, "901007")) / (100 * 10))));

            // 901011軽減後利用者負担額
            sub(map, "901011", new String[] { "901009", "901010" });
        }
    }

    /**
     * 居宅介護支援費
     * 
     * @throws Exception
     */
    private void parseCarePlan() throws Exception {

        VRMap map = null;
        VRMap lastmap = null;
        int total = 0;

        if (careplan.size() <= 0) {
            return;
        }

        map = (VRMap) careplan.get(0);
        // 旧様式は集計を行わない(行えない)
        if ("8124,8125"
                .indexOf(ACCastUtilities.toString(map.get("1001001"), "")) == -1) {
            return;
        }

        for (int i = 0; i < careplan.size(); i++) {
            map = (VRMap) careplan.get(i);
            // 単位数小計 = 単位数 * 回数
            total += mul(map, "1001017", "1001025", "1001026");

            if (ACCastUtilities.toInt(map.get("1001024"), 0) == 99) {
                lastmap = map;
            }
        }

        if (lastmap == null) {
            return;
        }

        // 単位数単価
        BigDecimal _1001006 = new BigDecimal(toString(map, "1001006"));
        _1001006 = _1001006.multiply(new BigDecimal("100"));

        // サービス単位数合計
        lastmap.put("1001027", String.valueOf(total));
        // 請求金額
        map.put("1001018",
                String.valueOf((int) (Math.floor((double) total
                        * _1001006.intValue()) / 100d)));
    }

    /**
     * 給付率を取得する
     * 
     * @return
     */
    private int getRate() {

        // 基本情報レコードから公費の給付率を取得する
        if (base.size() <= 0) {
            return 0;
        }

        // 給付率が未取得の場合、取得実行
        if (rate == Integer.MIN_VALUE) {
            initBaseData();
        }
        return rate;
    }

    /**
     * 公費の給付率を取得する
     * 
     * @param kohiNo
     *            公費番号(1～3)
     * @return 給付率
     */
    private int getKohiRate(int kohiNo) {
        if ((kohiNo < 1) || (3 < kohiNo)) {
            return 0;
        }

        // 基本情報レコードから公費の給付率を取得する
        if (base.size() <= 0) {
            return 0;
        }

        // 給付率が未取得の場合、取得実行
        if (kohiRate[kohiNo - 1] == Integer.MIN_VALUE) {
            initBaseData();
        }
        return kohiRate[kohiNo - 1];
    }

    private String getKohiType(int kohiNo) {
        if ((kohiNo < 1) || (3 < kohiNo)) {
            return "";
        }

        // 基本情報レコードから公費の給付率を取得する
        if (base.size() <= 0) {
            return "";
        }

        // 給付率が未取得の場合、取得実行
        if (kohiType[kohiNo - 1] == null) {
            initBaseData();
        }
        return kohiType[kohiNo - 1];
    }

    private void initBaseData() {
        VRMap map = (VRMap) base.get(0);
        rate = toInt(map, "201029");

        kohiRate[0] = toInt(map, "201030");
        kohiRate[1] = toInt(map, "201031");
        kohiRate[2] = toInt(map, "201032");

        kohiType[0] = toString(map, "201058");
        kohiType[1] = toString(map, "201059");
        kohiType[2] = toString(map, "201060");
    }

    /**
     * 公費給付額を算定する
     * 
     * @param unit
     * @param ratio
     * @param reduction
     * @param usedRate
     * @return
     */
    private int getKohiClaim(VRMap map, int unit, int ratio, int reduction,
            int usedRate) {
        int result = 0;
        int kyufu = 0;

        int total = (int) Math.floor((double) (unit * getMultiplies100(map,
                "701015")) / 100d);

        kyufu = (int) Math.floor(total * ((double) getRate() / 100d));
        // 保険給付率が100%の場合

        if ((ratio == 100) && (toInt(map, "701014") == unit)) {
            // 利用者請求から介護保険負担額を引いたもの
            result = total - kyufu - reduction;
        } else {
            // 合計金額*(公費給付率-保険給付率-)
            result = (int) Math.floor((total * (ratio - usedRate)) / 100);
        }
        return result;
    }

    /**
     * 掛け算
     * 
     * @param map
     *            値の入っているmap
     * @param code
     *            演算結果を代入するキー
     * @param code1
     *            演算対象１
     * @param code2
     *            演算対象２
     * @return 演算結果
     */
    private int mul(VRMap map, String code, String code1, String code2) {
        int v = ACCastUtilities.toInt(map.get(code1), 0)
                * ACCastUtilities.toInt(map.get(code2), 0);
        map.put(code, String.valueOf(v));
        return v;
    }

    /**
     * 足し算(別map参照)
     * 
     * @param map1
     * @param code1
     * @param map2
     * @param code2
     */
    private void addAppend(VRMap map1, String code1, VRMap map2, String code2) {
        map1.put(code1, String.valueOf(toInt(map1, code1) + toInt(map2, code2)));
    }

    /**
     * 足し算(map内部)
     * 
     * @param map
     *            値の入っているmap
     * @param code
     *            演算結果を代入するキー
     * @param codes
     *            演算対象
     * @return 演算結果
     */
    private int add(VRMap map, String code, String[] codes) {
        int v = 0;
        for (int i = 0; i < codes.length; i++) {
            v += ACCastUtilities.toInt(map.get(codes[i]), 0);
        }
        map.put(code, String.valueOf(v));
        return v;
    }

    /**
     * 引き算
     * 
     * @param map
     *            値の入っているmap
     * @param code
     *            演算結果を代入するキー
     * @param codes
     *            演算対象
     * @return 演算結果
     */
    private int sub(VRMap map, String code, String[] codes) {
        int v = ACCastUtilities.toInt(map.get(codes[0]), 0);
        for (int i = 1; i < codes.length; i++) {
            v -= ACCastUtilities.toInt(map.get(codes[i]), 0);
        }
        map.put(code, String.valueOf(v));
        return v;
    }

    /**
     * 指定キーの値を100倍した値を取得する
     * 
     * @param map
     * @param key
     * @return
     */
    private int getMultiplies100(VRMap map, String key) {
        BigDecimal temp = new BigDecimal(toString(map, key));
        temp = temp.multiply(new BigDecimal("100"));
        return temp.intValue();
    }

    /**
     * int変換
     * 
     * @param map
     *            VRMap
     * @param key
     *            変換対象キー
     * @return 変換後の値(※エラー時は0を返却)
     */
    private int toInt(VRMap map, String key) {
        return ACCastUtilities.toInt(map.get(key), 0);
    }

    /**
     * String変換
     * 
     * @param map
     *            VRMap
     * @param key
     *            変換対象キー
     * @return 変換後の値(※エラー時は空白を返却)
     */
    private String toString(VRMap map, String key) {
        return ACCastUtilities.toString(map.get(key), "");
    }
}
