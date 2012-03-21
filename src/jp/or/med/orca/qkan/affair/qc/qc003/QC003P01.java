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
 * 開発者: 樋口　雅彦
 * 作成日: 2005/12/19  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 老人訪問看護・訪問看護の情報提供書 (003)
 * プログラム 老人訪問看護・訪問看護の情報提供書 (QC00301)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc003;

import java.util.Date;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * 老人訪問看護・訪問看護の情報提供書(QC00301) 帳票定義体ファイル名 ： QC00301.xml
 */
public class QC003P01 extends QC003P01Event {
    /**
     * コンストラクタです。
     */
    public QC003P01() {
    }

    /**
     * 帳票を生成します。
     * 
     * @param writer 印刷管理クラス
     * @param printParam 印刷パラメタ
     * @throws Exception 処理例外
     */
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam)
            throws Exception {
        // TODO 帳票IDを必要に応じて"mainFormat"から適切なものに書き換えること。
        ACChotarouXMLUtilities.addFormat(writer, "QC003P01", "QC003P01.xml");
        // ページ開始 homonkangojohoteikyosho
        writer.beginPageEdit("QC003P01");
        // CREATE_DATEの年の部分を設定する。
        Date createDate = (Date) printParam.getData("CREATE_DATE");
        // setValue(createDate(w2.h), 日付（年）);
        int eraYear = ACDateUtilities.getEraYear(createDate);
        ACChotarouXMLUtilities.setValue(writer, "createDate.h.w2", new Integer(
                eraYear));
        // CREATE_DATEの月の部分を設定する。
        // setValue(createDate(w4.h), 日付（月）);
        int month = ACDateUtilities.getMonth(createDate);
        ACChotarouXMLUtilities.setValue(writer, "createDate.h.w4", new Integer(
                month));

        // CREATE_DATEの日の部分を設定する。
        // setValue(createDate（w6.h）, 日付（日）);
        int day = ACDateUtilities.getDayOfMonth(createDate);
        ACChotarouXMLUtilities.setValue(writer, "createDate.h.w6", new Integer(
                day));

        // 情報提供先を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "JOHO_TEIKYO_SAKI",
                "johoTeikyoSaki");
        // 訪問看護ステーション 所在地を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "PROVIDER_ADDRESS",
                "providerAddress");
        // 訪問看護ステーション 名称を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "PROVIDER_NAME",
                "providerName");

        // PROVIDER_TEL_FIRSTの値をチェックする。
        // 空白だった場合
        // PROVIDER_TEL_SECONDの値をチェックする。
        // 空白だった場合
        // PROVIDER_TEL_THIRDの値をチェックする。
        // 空白だった場合
        // 処理を抜ける。（電話番号を印字しない）
        // 空白ではなかった場合
        // 次処理へ。
        // 空白ではなかった場合
        // 次処理へ。
        // 空白ではなかった場合
        // 次処理へ。
        // 電話番号を結合しproviderTelに格納する。
        // toTel(PROVIDER_TEL_FIRST, PROVIDER_TEL_SECOND, PROVIDER_TEL_THIRD);
        String providerTel = QkanCommon.toTel(ACCastUtilities
                .toString(printParam.getData("PROVIDER_TEL_FIRST")),
                ACCastUtilities.toString(printParam
                        .getData("PROVIDER_TEL_SECOND")), ACCastUtilities
                        .toString(printParam.getData("PROVIDER_TEL_THIRD")));
        // 電話番号を設定する。
        // setValue(providerTel, providerTel);
        ACChotarouXMLUtilities.setValue(writer, "providerTel", providerTel);

        // 管理者氏名を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam,
                "PROVIDER_ADMINISTRATOR", "providerAdministrator");
        // 利用者氏名を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam,
                "PATIENT_FULL_NAME", "patientInfo1.h1.w6");
        // 渡りパラメーターPATIENT_SEXの値をチェックする。
        if (new Integer(1).equals(printParam.getData("PATIENT_SEX"))) {
            // 値が1だった場合
            // 「女」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
        } else if(new Integer(2).equals(printParam.getData("PATIENT_SEX"))){
            // 値が2だった場合
            // 「男」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
        }else{
            //非表示にする
            ACChotarouXMLUtilities.setInvisible(writer, "patientSex1");
            ACChotarouXMLUtilities.setInvisible(writer, "patientSex2");
        }

        // 利用者生年月日を取得する
        Date patientBirthDay = (Date) printParam.getData(("PATIENT_BIRTHDAY"));

        // 利用者の誕生日を設定する。
        ACChotarouXMLUtilities.setValue(writer, "patientAge", ACCastUtilities
                .toString(QkanCommon.calcAge(patientBirthDay,
                        QkanSystemInformation.getInstance().getSystemDate())));

        String eraFull = ACDateUtilities.getEraFull(patientBirthDay);

        // 年号が「明治」だった場合
        if ("明治".equals(eraFull)) {
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay2");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay3");
            // 「平成」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay4");

            // 年号が「大正」だった場合
        } else if ("大正".equals(eraFull)) {
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay1");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay3");
            // 「平成」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay4");

            // 年号が「昭和」だった場合
        } else if ("昭和".equals(eraFull)) {
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay1");
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay2");
            // 「平成」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay4");

            // 年号が｢平成」だった場合
        } else if ("平成".equals(eraFull)) {
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay1");
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay2");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay3");
            
        } else {
            // 「明治」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay1");
            // 「大正」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay2");
            // 「昭和」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay3");
            // 「平成」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirthDay4");
            
        }

        // 年を設定する。
        ACChotarouXMLUtilities.setValue(writer, "patientBirthdayYear",
                new Integer(ACDateUtilities.getEraYear(patientBirthDay)));
        // 月を設定する。
        ACChotarouXMLUtilities.setValue(writer, "patientBirthdayMonth",
                new Integer(ACDateUtilities.getMonth(patientBirthDay)));
        // 日を設定する。
        ACChotarouXMLUtilities.setValue(writer, "patientBirthdayDay",
                new Integer(ACDateUtilities.getDayOfMonth(patientBirthDay)));
        // ログイン日付を取得し、変数（logijnDate）に格納する。
        // 年齢を計算し、変数（patientAge）に格納する。
        // calcAge(PATIENT_BIRTHDAY, logijnDate);
        int patientAge = QkanCommon.calcAge(patientBirthDay,
                QkanSystemInformation.getInstance().getSystemDate());
        // 計算した値を設定する。
        // setValue(patientAge, patientAge);
        ACChotarouXMLUtilities.setValue(writer, "patientAge", new Integer(
                patientAge));
        // 職業を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_JOB",
                "patientJob");
        // 住所を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_ADDRESS",
                "patientInfo2.h1.w2");
        // PATIENT_TEL_FIRSTの値をチェックする。
        // 空白だった場合
        // PATIENT_TEL_SECONDの値をチェックする。
        // 空白だった場合
        // PATIENT_TEL_THIRDの値をチェックする。
        // 空白だった場合
        // 処理を抜ける。
        // 空白ではなかった場合
        // 次処理へ。
        // 空白ではなかった場合
        // 次処理へ。
        // 空白ではなかった場合
        // 次処理へ。
        // 電話番号を結合しPatientTelに格納する。
        // toTel(PATIENT_TEL_FIRST, PATIENT_TEL_SECOND, PATIENT_TEL_THIRD);
        String patientTel = QkanCommon.toTel(ACCastUtilities
                .toString(printParam.getData("PATIENT_TEL_FIRST")),
                ACCastUtilities.toString(printParam
                        .getData("PATIENT_TEL_SECOND")), ACCastUtilities
                        .toString(printParam.getData("PATIENT_TEL_THIRD")));
        // 電話番号を設定する。
        ACChotarouXMLUtilities.setValue(writer, "patientInfo2.h2.w2",
                patientTel);
        // 主治医氏名を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME",
                "doctorInfo.h1.w2");
        // 主治医住所を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_ADDRESS",
                "doctorInfo.h2.w2");
        // 主傷病名を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "DISEASE",
                "doctorInfo.h3.w2");

        int adlMove = ACCastUtilities.toInt(printParam.getData("ADL_MOVE"));
        // 渡りパラメーターADL_MOVEの値をチェックする。
        switch (adlMove) {
        // 値が1だった場合
        case 1:
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
            // 「全面解除」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
            // 処理終了
            break;

        // 値が2だった場合
        case 2:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
            // 処理終了
            break;

        // 値が3だった場合
        case 3:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
            // 処理終了
            break;

        // 未選択状態だった場合
        default:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
            // 処理終了
            break;

        }

        int adlExcretion = ACCastUtilities.toInt(printParam
                .getData("ADL_EXCRETION"));
        // 渡りパラーメーターADL_EXCRETIONの値をチェックする
        switch (adlExcretion) {
        // 値が1だった場合
        case 1:
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
            // 「全面解除」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
            // 処理終了
            break;

        case 2:
            // 値が2だった場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
            // 処理終了
            break;

        case 3:
            // 値が3だった場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
            // 処理終了
            break;

        default:
            // 値が3だった場合
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
            // 処理終了
            break;

        }

        int adlChangeCloth = ACCastUtilities.toInt(printParam
                .getData("ADL_CHANGE_CLOTH"));
        // 渡りパラメーターADL_CHANGE_CLOTHの値をチェックする。
        switch (adlChangeCloth) {
        // 値が1だった場合
        case 1:
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth2");
            // 「全面解除」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth3");
            // 処理終了
            break;

        // 値が2だった場合
        case 2:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth1");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth3");
            // 処理終了
            break;

        // 値が3だった場合
        case 3:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth2");
            // 処理終了
            break;

        default:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth2");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlChangeCloth3");
            // 処理終了
            break;

        }

        int adlFood = ACCastUtilities.toInt(printParam.getData("ADL_FOOD"));
        // 渡りパラメーターADL_FOODの値をチェックする。
        switch (adlFood) {
        // 値が1だった場合
        case 1:
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
            // 「全面解除」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
            // 処理終了
            break;

        // 値が2だった場合
        case 2:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
            // 処理終了
            break;

        // 値が3だった場合
        case 3:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");

            // 処理終了
            break;

        default:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
            // 処理終了
            break;
        }

        int adlBath = ACCastUtilities.toInt(printParam.getData("ADL_BATH"));
        // 渡りパラメーターADL_BATHの値をチェックする。
        switch (adlBath) {
        // 値が1だった場合
        case 1:
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
            // 「全面解除」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
            // 処理終了
            break;

        // 値が2だった場合
        case 2:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
            // 処理終了
            break;

        // 値が3だった場合
        case 3:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
            // 処理終了
            break;

        default:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
            // 処理終了
            break;

        }

        int adlCosmetic = ACCastUtilities.toInt(printParam
                .getData("ADL_COSMETIC"));
        // 渡りパラメーターADL_COSMETICの値をチェックする。
        switch (adlCosmetic) {
        // 値が1だった場合
        case 1:
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic2");
            // 「全面解除」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic3");
            // 処理終了
            break;

        // 値が2だった場合
        case 2:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic1");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic3");
            // 処理終了
            break;

        // 値が3だった場合
        case 3:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic2");
            // 処理終了
            break;

        default:
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic1");
            // 「一部介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic2");
            // 「全面介助」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "adlCosmetic3");
            // 処理終了
            break;

        }

        // 要介護度
        int jotaiCode = ACCastUtilities.toInt(printParam.getData("JOTAI_CODE"), 1);
        // JOTAI_CODEの値をチェックする
        switch (jotaiCode) {
        // 値が1だった場合
        case 1:
            //「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // 処理終了
            break;

        // 値が11だった場合
        case 11:
            //「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // 処理終了
            break;
        case 12:
            //「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // 処理終了
            break;
        case 13:
            //「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // 処理終了
            break;
        // 値が21だった場合
        case 21:
            //「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // 処理終了
            break;

        // 値が22だった場合
        case 22:
            //「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // 処理終了
            break;

        // 値が23だった場合
        case 23:
            //「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // 処理終了
            break;

        // 値が24だった場合
        case 24:
            //「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // 「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            // 処理終了
            break;

        // 値が25だった場合
        case 25:
            //「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
            // 「自立」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            // 「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            // 「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            // 「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            // 「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            // 「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            //処理終了
            break;

        default:
            //「要支援１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode12");
            //「要支援２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode13");
//            //「自立」のシェイプを非表示にする。
//            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode1");
            //「要支援」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode2");
            //「要介護１」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode3");
            //「要介護２」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode4");
            //「要介護３」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode5");
            //「要介護４」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode6");
            //「要介護５」のシェイプを非表示にする。
            ACChotarouXMLUtilities.setInvisible(writer, "patientJotaiCode7");
            break;
        }

        // 下記の条件で病状・障害等の状態を設定する。
        //・1行に印刷されるのは、全角45文字とする。46文字以降は2行目に設定する。
        //・最大出力行数は2行とする。    

        //文字列に変換
        String byojoShogaiState = ACCastUtilities.toString(printParam
                .get("BYOJO_SHOGAI_STATE"));

        ACChotarouXMLUtilities.setValue(writer, "etcInfo.h1.w2",
                getInsertionLineSeparatorToStringOnByte(byojoShogaiState, 90));

        //1月当たりの訪問回数（日）を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam, "HOMON_KAISU_DAY",
                "hokenKaisuDay");

        //1月当たりの訪問回数（回）を設定する。
        ACChotarouXMLUtilities.setValue(writer, printParam,
                "HOMON_KAISU_COUNT", "hokenKaisuCount");

        //下記の条件で看護の内容を設定する。
        //1行に印刷されるのは、全角45文字とする。46文字以降は2行目に設定する。
        //・最大出力行数は2行とする。
        String kangoNaiyo = ACCastUtilities.toString(printParam.get("KANGO_NAIYO"));

        ACChotarouXMLUtilities.setValue(writer, "etcInfo.h4.w2",
                getInsertionLineSeparatorToStringOnByte(kangoNaiyo, 90));

        //下記の条件で必要と考えられる保健福祉サービスを設定する。
        //1行に印刷されるのは、全角45文字とする。46文字以降は2行目に設定する。
        //・最大出力行数は2行とする。    
        String hokenFukushiService = ACCastUtilities.toString(printParam
                .get("HOKEN_FUKUSHI_SERVICE")); 

        ACChotarouXMLUtilities
                .setValue(writer, "etcInfo.h3.w2",
                        getInsertionLineSeparatorToStringOnByte(
                                hokenFukushiService, 90));

        //下記の条件でその他特記すべき事項を設定する。
        //1行に印刷されるのは、全角45文字とする。46文字以降は2行目に設定する。
        //・最大出力行数は2行とする。
        String ryuijiko = ACCastUtilities.toString(printParam.get("RYUIJIKO")); 
        
        ACChotarouXMLUtilities.setValue(writer, "etcInfo.h2.w2",
                getInsertionLineSeparatorToStringOnByte(ryuijiko, 90));

        //ページ終了
        writer.endPageEdit();
        //TODO 印刷を実行したならばtrueを返す。
        return true;
    }

    /**
     * 文字数ごとに改行コードを挿入した文字列を返します
     * @param keyName キーの名前
     * @param printParam 使用するパラーメーター
     * @param columns 改行基準とする文字数
     * @return 改行コードを挿入した文字列
     * @throws Exception
     */
    public String getInsertionLineSeparatorToString(String keyName,
            VRMap printParam, int columns) throws Exception {
        
        //バイトなので文字数にあわせ2倍にする
        String[] slComment = ACTextUtilities.separateLineWrapOnByte(
                ACCastUtilities.toString(printParam.getData(keyName)), columns*2+1);

        StringBuilder sbComment = new StringBuilder();

        for (int i = 0; i < slComment.length; i++) {
            sbComment.append(slComment[i]);
            //最終行である場合は改行コードを追加しない
            if (i != slComment.length - 1) {
                //改行コードを追加する
                sbComment.append(ACConstants.LINE_SEPARATOR);
            }
        }

        String insertionLineSeparatorString = sbComment.toString();

        //改行コードを追加した文字列を返す
        return insertionLineSeparatorString;
    }

    /**
     * 指定された文字数で改行した文字列を返します。
     * @param chr 改行対象となる文字列
     * @param columnIndex 改行基準文字数
     * @return 改行文字を挿入した文字列
     */
    public String getInsertionLineSeparatorToStringOnChar(String chr, int charIndex){
        String[] slCharacter = ACTextUtilities.separateLineWrapOnChar(chr,charIndex);
        
        StringBuilder sbCharacter = new StringBuilder();

        for (int i = 0; i < slCharacter.length; i++) {
            sbCharacter.append(slCharacter[i]);
            //最終行である場合は改行コードを追加しない
            if (i != slCharacter.length - 1) {
                //改行コードを追加する
                sbCharacter.append(ACConstants.LINE_SEPARATOR);
            }
        }

        String insertionLineSeparatorString = sbCharacter.toString();
        
        return insertionLineSeparatorString;
    }
    
    
    /**
     * 指定された文字数で改行した文字列を返します。
     * @param chr 改行対象となる文字列
     * @param byteIndex 改行基準バイト数
     * @return 改行文字を挿入した文字列
     */
    public String getInsertionLineSeparatorToStringOnByte(String chr, int byteIndex){
        String[] slCharacter = ACTextUtilities.separateLineWrapOnByte(chr,byteIndex);
        
        StringBuilder sbCharacter = new StringBuilder();

        for (int i = 0; i < slCharacter.length; i++) {
            sbCharacter.append(slCharacter[i]);
            //最終行である場合は改行コードを追加しない
            if (i != slCharacter.length - 1) {
                //改行コードを追加する
                sbCharacter.append(ACConstants.LINE_SEPARATOR);
            }
        }

        String insertionLineSeparatorString = sbCharacter.toString();
        
        return insertionLineSeparatorString;
    }
}
