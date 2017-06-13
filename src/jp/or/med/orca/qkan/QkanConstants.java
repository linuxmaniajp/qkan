/** TODO <HEAD_IKENSYO> */
package jp.or.med.orca.qkan;

import java.awt.Color;
import java.util.Date;

import javax.swing.plaf.ColorUIResource;

import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACNowAgeFormat;
import jp.nichicom.ac.text.ACOneDecimalDoubleFormat;
import jp.nichicom.ac.util.ACDateUtilities;

/**
 * システム共通定義です。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public interface QkanConstants {

    /**
     * 給管鳥システムのバージョン情報を管理します。
     */
    public static final String QKAN_SYSTEM_VERSION = "7.0.0";

    // アイコン
    /**
     * 利用請求詳細を表すアイコン定数です。
     */
    public static final String ICON_PATH_PATIENT_BILL_24 = "jp/or/med/orca/qkan/images/icon/pix24/btn_101.png";
    /**
     * 事業所請求詳細を表すアイコン定数です。
     */
    public static final String ICON_PATH_PROVIDER_BILL_24 = "jp/or/med/orca/qkan/images/icon/pix24/btn_102.png";
    /**
     * 意見書を表すアイコン定数です。
     */
    public static final String ICON_PATH_IKENSHO_24 = "jp/or/med/orca/qkan/images/icon/pix24/btn_103.png";

    // 色設定
    
/*    //赤紫
    public static final Color COLOR_QKAN_THEMA = new Color(71, 30, 71);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_1 = new ColorUIResource(111, 69, 78);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_2 = new ColorUIResource(161, 99, 148);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_3 = new ColorUIResource(191, 139, 173);
    
    // 赤紫系背景
    public static final ColorUIResource COLOR_RESOURCE_QKAN_SECONDARY_1 = new ColorUIResource(150, 120, 120);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_SECONDARY_2 = new ColorUIResource(220, 200, 200);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_SECONDARY_3 = new ColorUIResource(250, 230, 230);
    
    // 赤紫系コンテナ背景色
    public static final ColorUIResource COLOR_BACK_LABEL_CONTAINER = new ColorUIResource(255, 183, 173);
*/    
    
/* 
    // 緑 V6.0.0
    public static final Color COLOR_QKAN_THEMA = new Color(51,102,51);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_1 = new ColorUIResource(91 ,141 ,58);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_2 = new ColorUIResource(141 ,171 ,128);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_3 = new ColorUIResource(171 ,211 ,153);
    
    // 緑系背景-->未使用
    public static final ColorUIResource COLOR_RESOURCE_QKAN_SECONDARY_1 = new ColorUIResource(150, 120, 120);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_SECONDARY_2 = new ColorUIResource(220, 200, 200);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_SECONDARY_3 = new ColorUIResource(250, 230, 230);
    
    // 緑系コンテナ背景色
    public static final ColorUIResource COLOR_BACK_LABEL_CONTAINER = new ColorUIResource(130, 201, 82);
*/    
    
/*    // 青
    public static final Color COLOR_QKAN_THEMA = new Color(0, 51, 153);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_1 = new ColorUIResource(40, 90, 160);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_2 = new ColorUIResource(90, 120, 230);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_3 = new ColorUIResource(120, 160, 255);
    */

    // [H27.4改正対応][Shinobu Hitaka] 2015/1/28 add - begin 
    // 紫系 V7.0.0
    public static final Color COLOR_QKAN_THEMA = new Color(102,51,153);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_1 = new ColorUIResource(119,74,142);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_2 = new ColorUIResource(152,116,170);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_PRIMARY_3 = new ColorUIResource(200,172,214);
    
    // 紫系背景
    public static final ColorUIResource COLOR_RESOURCE_QKAN_SECONDARY_1 = new ColorUIResource(150, 120, 120);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_SECONDARY_2 = new ColorUIResource(220, 200, 200);
    public static final ColorUIResource COLOR_RESOURCE_QKAN_SECONDARY_3 = new ColorUIResource(250, 230, 230);
    
    // 紫系コンテナ背景色
    public static final ColorUIResource COLOR_BACK_LABEL_CONTAINER = new ColorUIResource(186,127,207);
    // [H27.4改正対応][Shinobu Hitaka] 2015/1/28 add - end 

    // フォーマッタ
    /**
     * 1-男、2-女と変換するフォーマッタです。
     */
    public static final ACHashMapFormat FORMAT_SEX = new ACHashMapFormat(
            new String[] { "男", "女" }, new Integer[] { new Integer(1),
                    new Integer(2) });
    /**
     * 現在年齢に変換するフォーマッタです。
     */
    public static final ACNowAgeFormat FORMAT_NOW_AGE = new ACNowAgeFormat();

    /**
     * 小数点第一位まで表示するフォーマッタです。
     */
    public static final ACOneDecimalDoubleFormat FORMAT_DOUBLE1 = ACOneDecimalDoubleFormat
            .getInstance();

    // エディション
    public static final int EDITION_DEFAULT = 1; // デフォルトエディション

    // 事業者種別
    public static final int LOGIN_MODE_KYOTAKU_SHIEN = 1; // 居宅支援事業者
    public static final int LOGIN_MODE_KYOTAKU_SERVICE = 2; // 居宅サービス提供業者
    public static final int LOGIN_MODE_SHISETSU_SERVICE = 3; // 施設サービス提供業者

    // PROCESS_MODE(処理モード)
    public static final int PROCESS_MODE_DELETE = 1; // 削除
    public static final int PROCESS_MODE_SELECT = 2; // 検索
    public static final int PROCESS_MODE_UPDATE = 3; // 更新
    public static final int PROCESS_MODE_INSERT = 4; // 登録

    // サービス詳細取得
    /**
     * 101-サービス予定全体を表すサービス詳細取得モード定数です。
     */
    public static final int SERVICE_DETAIL_GET_PLAN = 101;
    /**
     * 102-サービス実績全体を表すサービス詳細取得モード定数です。
     */
    public static final int SERVICE_DETAIL_GET_RESULT = 102;
    /**
     * 103-サービス予定の月間全体を表すサービス詳細取得モード定数です。
     */
    public static final int SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY = 103;
    /**
     * 103-サービス予定の週間全体を表すサービス詳細取得モード定数です。
     */
    public static final int SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY = 104;

    // サービス用途
    /**
     * 1-サービスパターンを表すサービス用途定数です。
     */
    public static final Integer SERVICE_USE_TYPE_PATTERN = new Integer(1);
    /**
     * 2-予定（週間－開始日○）を表すサービス用途定数です。
     */
    public static final Integer SERVICE_USE_TYPE_PLAN_WEEKLY_DAY = new Integer(
            2);
    /**
     * 3-予定（週間－開始日×）を表すサービス用途定数です。
     */
    public static final Integer SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY = new Integer(
            3);
    /**
     * 4-予定（月間-開始日○）を表すサービス用途定数です。
     */
    public static final Integer SERVICE_USE_TYPE_PLAN_MONTHLY_DAY = new Integer(
            4);
    /**
     * 5-予定（月間-開始日×）を表すサービス用途定数です。
     */
    public static final Integer SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY = new Integer(
            5);
    /**
     * 6-実績（開始日-○）を表すサービス用途定数です。
     */
    public static final Integer SERVICE_USE_TYPE_RESULT_MONTHLY_DAY = new Integer(
            6);
    /**
     * 7-実績（開始日-×）を表すサービス用途定数です。
     */
    public static final Integer SERVICE_USE_TYPE_RESULT_MONTHLY_FREE_DAY = new Integer(
            7);
    /**
     * 8-実績（週間－開始日○）を表すサービス用途定数です。
     */
    public static final Integer SERVICE_USE_TYPE_RESULT_WEEKLY_DAY = new Integer(
            8);
    /**
     * 9-実績（週間－開始日×）を表すサービス用途定数です。
     */
    public static final Integer SERVICE_USE_TYPE_RESULT_WEEKLY_FREE_DAY = new Integer(
            9);

    // サービス用途が2の時のみ使用するWEEK_DAYフィールド値
    /**
     * 101-日常生活午前を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_FREE_AM = new Integer(101);
    /**
     * 102-日常生活午後を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_FREE_PM = new Integer(102);
    /**
     * 111-日曜午前を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_SUNDAY_AM = new Integer(111);
    /**
     * 112-月曜午前を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_MONDAY_AM = new Integer(112);
    /**
     * 113-火曜午前を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_TUESDAY_AM = new Integer(113);
    /**
     * 114-水曜午前を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_WEDNESDAY_AM = new Integer(114);
    /**
     * 115-木曜午前を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_THURSDAY_AM = new Integer(115);
    /**
     * 116-金曜午前を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_FRIDAY_AM = new Integer(116);
    /**
     * 117-土曜午前を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_SATURDAY_AM = new Integer(117);
    /**
     * 121-日曜午後を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_SUNDAY_PM = new Integer(121);
    /**
     * 122-月曜午後を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_MONDAY_PM = new Integer(122);
    /**
     * 123-火曜午後を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_TUESDAY_PM = new Integer(123);
    /**
     * 124-水曜午後を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_WEDNESDAY_PM = new Integer(124);
    /**
     * 125-木曜午後を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_THURSDAY_PM = new Integer(125);
    /**
     * 126-金曜午後を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_FRIDAY_PM = new Integer(126);
    /**
     * 127-土曜午後を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_SATURDAY_PM = new Integer(127);

    /**
     * 1-指定なしを表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_UNKNOWN = new Integer(1);
    /**
     * 37-月初を表すサービス曜日定数です。
     */
    public static final Integer SERVICE_WEEK_DAY_FIRST_DAY = new Integer(37);

    /**
     * 101-週単位以外のサービスにおける期間を表すサービス詳細定数です。
     */
    public static final Integer SERVICE_SYSTEM_BIND_PATH_SPAN = new Integer(101);

    // [ID:0000444][Tozo TANAKA] 2009/03/07 add begin 平成21年4月法改正対応
    /**
     * 14-サービスの法改正区分を表すサービス詳細定数です。
     */
    public static final String SERVICE_SYSTEM_BIND_PATH_LOW_VERSION = "14";
    // [ID:0000444][Tozo TANAKA] 2009/03/07 add end

    /**
     * 10-サービスパターンの内部番号を表す数値です。
     */
    public static final Integer INTERNAL_SERVICE_PATTERN_NO_BIND_PATH = new Integer(
            10);
    // /**
    // * 90101-「その他」を表すサービス種類定数です。
    // */
    // public static final Integer SERVICE_KIND_DETAIL_OTHER = new
    // Integer(90101);
    // /**
    // * 90201-「主な日常生活上の活動」を表すサービス種類定数です。
    // */
    // public static final Integer SERVICE_KIND_DETAIL_DAILY_LIFE = new
    // Integer(90201);

    /**
     * 1-「システム管理サービス」を表すサービス種類定数です。
     */
    public static final Integer SERVICE_KIND_DETAIL_SYSTEM_SERVICE = new Integer(
            1);

    /**
     * 特定施設入所関連のサービスコードをあらわすサービスコード種類定数です。
     */
    public static final String SERVICE_KIND_LIFE_CARE_AT_SPECIAL_FACILITIY = "59";

    /**
     * 特定入居者であるかをあらわすサービス詳細種類です。
     */
    public static final String SERVICE_SYSTEM_KIND_DETAIL_SPECIAL_FACILITIY = "7";

    /**
     * 旧措置入所者であるかをあらわすサービス詳細種類です。
     */
    public static final String SERVICE_SYSTEM_KIND_DETAIL_OLD_FACILITIY_USER = "8";

    /**
     * 計画単位数をあらわすサービス詳細種類です。
     */
    public static final String SERVICE_SYSTEM_KIND_DETAIL_PLAN_UNIT = "1001";

    /**
     * サービスの単独加算フラグをあらわすサービス詳細種類です。
     */
    public static final String SERVICE_SYSTEM_KIND_DETAIL_ADD_TYPE = "9";

    /**
     * サービスパターンのソート順をあらわすサービス詳細種類です。
     */
    public static final String SERVICE_SYSTEM_KIND_DETAIL_SORT_ORDER = "10";

    // 特定診療費属性
    /**
     * 1-サービスを表す特定診療費属性定数です。
     */
    public static final int SPECIAL_CLINIC_TYPE_SERVICE = 1;
    /**
     * 2-事業者 を表す特定診療費属性定数です。
     */
    public static final int SPECIAL_CLINIC_TYPE_PROVIDER = 2;
    /**
     * 3-スタッフ を表す特定診療費属性定数です。
     */
    public static final int SPECIAL_CLINIC_TYPE_STAFF = 3;
    /**
     * 4-請求を表す特定診療費属性定数です。
     */
    public static final int SPECIAL_CLINIC_TYPE_BILL = 4;

    // 詳細マスタ形式
    /**
     * 1.サービスを表す詳細マスタ形式定数です。
     */
    public static final int DETAIL_MASTER_SERVICE = 1;
    /**
     * 2.事業所を表す詳細マスタ形式定数です。
     */
    public static final int DETAIL_MASTER_PROVIDER = 2;
    /**
     * 3.スタッフを表す詳細マスタ形式定数です。
     */
    public static final int DETAIL_MASTER_STAFF = 3;
    /**
     * 4.請求ＤＢを表す詳細マスタ形式定数です。
     */
    public static final int DETAIL_MASTER_CLAIM = 4;

    // 詳細データ形式
    /**
     * 1．INTEGERを表す詳細データ形式定数です。
     */
    public static final int DETAIL_DATA_INTEGER = 1;
    /**
     * 2．TEXTを表す詳細データ形式定数です。
     */
    public static final int DETAIL_DATA_STRING = 2;
    /**
     * 3．TIMESTAMP表す詳細データ形式定数です。
     */
    public static final int DETAIL_DATA_DATE = 3;

    // サービス予定・実績フラグ
    /**
     * 1.サービス予定を表す定数です。
     */
    public static final int PROCESS_TYPE_PLAN = 1;
    /**
     * 2.サービス実績を表す定数です。
     */
    public static final int PROCESS_TYPE_RESULT = 2;

    // 利用・提供票フラグ
    /**
     * 1.利用票を表す定数です。
     */
    public static final int PRINT_MODE_USE = 1;
    /**
     * 2.利用票別表を表す定数です。
     */
    public static final int PRINT_MODE_USE_ANOTHER = 2;
    /**
     * 3.提供票を表す定数です。
     */
    public static final int PRINT_MODE_OFFER = 3;
    /**
     * 4.提供票別表を表す定数です。
     */
    public static final int PRINT_MODE_OFFER_ANOTHER = 4;

    // 請求情報帳票様式種類
    /**
     * 10101-介護給付費請求書情報を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_BENEFIT_BILL = 10101;
    /**
     * 10211-様式第2を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_2 = 10211;
    /**
     * 10212-様式第2-2を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_2_2 = 10212;
    /**
     * 10311-様式第3を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_3 = 10311;
    /**
     * 10312-様式第3-2を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_3_2 = 10312;
    /**
     * 10411-様式第4を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_4 = 10411;
    /**
     * 10412-様式第4を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_4_2 = 10412;
    /**
     * 10511-様式 第5を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_5 = 10511;
    /**
     * 10512-様式 第5-2を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_5_2 = 10512;
    /**
     * 10611-様式第6を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_6 = 10611;
    /**
     * 10612-様式第6-2を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_6_2 = 10612;
    /**
     * 10613-様式第6-3を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_6_3 = 10613;
    /**
     * 10614-様式第6-4を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_6_4 = 10614;
    /**
     * 10615-様式第6-5を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_6_5 = 10615;
    /**
     * 10616-様式第6-6を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_6_6 = 10616;
    /**
     * 10617-様式第6-7を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_6_7 = 10617;
    /**
     * 10711-様式第7を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_7 = 10711;
    /**
     * 10712-様式第7-2を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_7_2 = 10712;
    /**
     * 10811-様式第8を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_8 = 10811;
    /**
     * 10812-様式第8を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_8_2 = 10812;
    /**
     * 9-様式第9を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_9 = 10911;
    /**
     * 10-様式第10を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_FORMAT_10 = 11011;
    /**
     * 11-給付管理票総括情報を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_BENEFIT_SUMMARY = 11111;
    /**
     * 12-給付管理票情報を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_BENEFIT_MANAGEMENT = 11211;
    /**
     * 13-訪問看護療養費明細書（社保）を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_VISIT_DETAILED_SOCIAL_INSURANCE = 20101;
    /**
     * 14-訪問看護療養費明細書（国保）を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_VISIT_DETAILE_NATIONAL_INSURANCE = 20102;
    /**
     * 15-訪問看護療養費請求書（社保）を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_VISIT_BILL_SOCIAL_INSURANCE = 20201;
    /**
     * 16-訪問看護療養費請求書（国保）を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_VISIT_BILL_NATIONAL_INSURANCE = 20202;
    /**
     * 17-利用者向け請求を表す帳票の様式番号定数です。
     */
    public static final int CLAIM_STYLE_BILL_FOR_PATIENT = 30101;

    // 請求情報カテゴリ番号
    /**
     * 1：介護給付費請求書情報を表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_BENEFIT_BILL = new Integer(1);
    /**
     * 2：基本情報レコードを表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_RECORD_BASIC_INFOMATION = new Integer(
            2);
    /**
     * 3：明細情報レコードを表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_RECORD_DETAILED = new Integer(3);
    /**
     * 4：緊急時施設療養情報レコードを表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_RECORD_EMERGENCY_INSTITUTION = new Integer(
            4);
    /**
     * 5：特定診療費情報レコードを表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_RECORD_SPECIAL_TREATMENT = new Integer(
            5);
    /**
     * 6：食事費用情報レコードを表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_RECORD_MEAT_EXPENSES = new Integer(
            6);
    /**
     * 7：集計情報レコードを表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_RECORD_TOTAL = new Integer(7);
    /**
     * 8：特定入所者介護サービス費用情報レコードを表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_RECODE_SPECIAL_ENTER_SERVICE = new Integer(
            8);
    /**
     * 9：社会福祉法人軽減額情報レコードを表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_SOCIAL_WELFARE_REDUCE = new Integer(
            9);
    /**
     * 10：介護給付費請求明細書(居宅サービス計画費)情報を表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_DETAILED_BENEFIT = new Integer(10);
    /**
     * 11：給付管理票総括票情報を表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_SUMMARY = new Integer(11);
    /**
     * 12：給付管理票情報を表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_MANAGEMENT = new Integer(12);
    /**
     * 13-訪問看護療養費明細書を表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_VISIT_DETAILED = new Integer(13);
    /**
     * 14-訪問看護療養費請求書（社保）を表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_VISIT_BILL_SOCIAL_INSURANCE = new Integer(
            14);
    /**
     * 15-訪問看護療養費請求書（国保）を表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_VISIT_BILL_NATIONAL_INSURANCE = new Integer(
            15);
    /**
     * 16-利用者向け請求を表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_BILL_FOR_PATIENT = new Integer(16);
    /**
     * 17：緊急時施設療養・自施設療養費情報レコードを表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_RECORD_EMERGENCY_OWN_FACILITY_INSTITUTION = new Integer(
            17);
 // 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
    /**
     * 18：明細情報（住所地特例）レコードを表す分類の情報定数です。
     */
    public static final Integer CATEGORY_NO_RECORD_DETAILED_JUSHOTI_TOKUREI = new Integer(18);
 // 2014/12/24 [Yoichiro Kamei] add - end
    
    // スケジュールカレンダへのドロップ許可フラグ
    /**
     * 1.ドロップ不可を表すドロップ許可フラグ定数です。
     */
    public static final int CALENADR_DROP_NONE = 0;
    /**
     * 1.月間表を表すドロップ許可フラグ定数です。
     */
    public static final int CALENADR_DROP_MONTHLY = 1;
    /**
     * 2.週間表の曜日部分を表すドロップ許可フラグ定数です。
     */
    public static final int CALENADR_DROP_WEEKLY = 2;
    /**
     * 3.月間表と週間表の曜日部分を表すドロップ許可フラグ定数です。
     */
    public static final int CALENADR_DROP_MONTHLY_AND_WEEKLY = 3;
    /**
     * 4.週間表の日常生活を表すドロップ許可フラグ定数です。
     */
    public static final int CALENADR_DROP_DAILY_LIFE = 4;

    /**
     * 平成19年4月1日の定数です。
     */
    public static final Date H1904 = ACDateUtilities.createDate(2007, 4, 1);
    /**
     * 平成20年4月1日の定数です。
     */
    public static final Date H2004 = ACDateUtilities.createDate(2008, 4, 1);
    /**
     * 平成20年5月1日の定数です。
     */
    public static final Date H2005 = ACDateUtilities.createDate(2008, 5, 1);
    /**
     * 平成21年4月1日の定数です。
     */
    public static final Date H2104 = ACDateUtilities.createDate(2009, 4, 1);
    /**
     * 平成27年1月1日の定数です。
     */
    public static final Date H2701 = ACDateUtilities.createDate(2015, 1, 1);

 // 2015/1/9 [Yoichiro Kamei] add - begin H27.4改正対応
    /**
     * 平成27年4月1日の定数です。
     */
    public static final Date H2704 = ACDateUtilities.createDate(2015, 4, 1);
 // 2015/1/9 [Yoichiro Kamei] add - end

 // 2016/1/28 [Shinobu Hitaka] add - begin H28.4改正対応
   /**
    * 平成28年4月1日の定数です。
    */
   public static final Date H2804 = ACDateUtilities.createDate(2016, 4, 1);
 // 2016/1/28 [Shinobu Hitaka] add - end
       
    /**
     * 20090401-サービスの法改正区分における[平成21年4月1日以降]を表す定数です。
     */
    public static final int SERVICE_LOW_VERSION_H2104 = 20090401;

    // [ID:0000666][Masahiko.Higuchi] 2012/12/13 add begin 法改正区分による分岐の修正
    /**
     * 20120401-サービスの法改正区分における[平成24年4月1日以降]を表す定数です。
     */
    public static final int SERVICE_LOW_VERSION_H2404 = 20120401;

 // 2015/1/9 [Yoichiro Kamei] add - begin H27.4改正対応
    /**
     * 20150401-サービスの法改正区分における[平成27年4月1日以降]を表す定数です。
     */
    public static final int SERVICE_LOW_VERSION_H2704 = 20150401;
 // 2015/1/9 [Yoichiro Kamei] add - end
    
    /**
     * 平成24年5月1日の定数です。
     */
    public static final Date H2404 = ACDateUtilities.createDate(2012, 4, 1);
    // [ID:0000666][Masahiko.Higuchi] 2012/12/13 add End

    public static final String[] CLAIM_PATIENT_DETAIL_SERVICE_MARK = { "○",
            "◎", "□", "△", "◇", "▽", "☆" };

}