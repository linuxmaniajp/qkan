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
 * 作成日: 2006/01/16  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 帳票管理 (C)
 * プロセス 訪問看護記録書Ⅰ (004)
 * プログラム 訪問看護記録書Ⅰ NO.2 (QC00402)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc004;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * 訪問看護記録書Ⅰ NO.2(QC00402) 帳票定義体ファイル名 ： QC00402.xml
 */
public class QC004P02 extends QC004P02Event {
	/**
	 * コンストラクタです。
	 */
	public QC004P02() {
	}

	/**
	 * 帳票を生成します。
	 * 
	 * @param writer
	 *            印刷管理クラス
	 * @param printParam
	 *            印刷パラメタ
	 * @throws Exception
	 *             処理例外
	 */
	public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
		// 必要であれば帳票IDを書き換えること。
		ACChotarouXMLUtilities.addFormat(writer, "QC004P02", "QC004P02.xml");
		// ページ開始
		writer.beginPageEdit("QC004P02");
		// 下記の条件で、利用者・家族の依頼目的を設定する。
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "PURPOSE", "purpose", 74);
		// 1行に印刷する文字数は全角37文字とする。
		// 総行数は6行とする。

		// 渡りパラメーター：ADL_MOVEの値をチェックする。
		// setValue("kirokushoGrid1.h1.w2", patientFullName);
		switch (ACCastUtilities.toInt(printParam.getData("ADL_MOVE"))) {
			case 1:
				// 値が1だった場合
				// adlMove2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
				// adlMove3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
				// adlMove4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove4");
				break;

			case 2:
				// 値が2だった場合
				// adlMove1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
				// adlMove3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
				// adlMove4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove4");
				break;

			case 3:
				// 値が3だった場合
				// adlMove1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
				// adlMove2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
				// adlMove4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove4");
				break;

			case 4:
				// 値が4だった場合
				// adlMove1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
				// adlMove2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
				// adlMove3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
				break;

			default:
				// 値が0もしくはその他だった場合
				// adlMove1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove1");
				// adlMove2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove2");
				// adlMove3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove3");
				// adlMove4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlMove4");
				break;
		}

		// 渡りパラメーター：ADL_FOODの値をチェックする。
		switch (ACCastUtilities.toInt(printParam.getData("ADL_FOOD"))) {
			case 1:
				// 値が1だった場合
				// adlFood2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
				// adlFood3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
				// adlFood4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood4");
				break;

			case 2:
				// 値が2だった場合
				// adlFood1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
				// adlFood3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
				// adlFood4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood4");
				break;

			case 3:
				// 値が3だった場合
				// adlFood1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
				// adlFood2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
				// adlFood4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood4");
				break;

			case 4:
				// 値が4だった場合
				// adlFood1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
				// adlFood2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
				// adlFood3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
				break;

			default:
				// 値が0もしくはその他だった場合
				// adlFood1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood1");
				// adlFood2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood2");
				// adlFood3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood3");
				// adlFood4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlFood4");
				break;
		}

		// 渡りパラメーター：ADL_EXCRETIONの値をチェックする。
		switch (ACCastUtilities.toInt(printParam.getData("ADL_EXCRETION"))) {
			case 1:
				// 値が1だった場合
				// adlExcretion2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
				// adlExcretion3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
				// adlExcretion4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion4");
				break;

			case 2:
				// 値が2だった場合
				// adlExcretion1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
				// adlExcretion3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
				// adlExcretion4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion4");
				break;

			case 3:
				// 値が3だった場合
				// adlExcretion1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
				// adlExcretion2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
				// adlExcretion4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion4");
				break;

			case 4:
				// 値が4だった場合
				// adlExcretion1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
				// adlExcretion2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
				// adlExcretion3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
				break;

			default:
				// 値が0もしくはその他だった場合
				// adlExcretion1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion1");
				// adlExcretion2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion2");
				// adlExcretion3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion3");
				// adlExcretion4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlExcretion4");
				break;
		}

		// 渡りパラメーター：ADL_BATHの値をチェックする。
		switch (ACCastUtilities.toInt(printParam.getData("ADL_BATH"))) {
			case 1:
				// 値が1だった場合
				// adlBath2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
				// adlBath3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
				// adlBath4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath4");
				break;

			case 2:
				// 値が2だった場合
				// adlBath1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
				// adlBath3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
				// adlBath4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath4");
				break;

			case 3:
				// 値が3だった場合
				// adlBath1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
				// adlBath2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
				// adlBath4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath4");
				break;

			case 4:
				// 値が4だった場合
				// adlBath1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
				// adlBath2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
				// adlChangeCloth3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
				break;

			default:
				// 値が0もしくはその他だった場合
				// adlBath1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath1");
				// adlBath2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath2");
				// adlChangeCloth3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath3");
				// adlChangeCloth4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlBath4");
				break;
		}

		// 渡りパラメーター：ADL_CHANGE_CLOTHの値をチェックする。
		switch (ACCastUtilities.toInt(printParam.getData("ADL_CHANGE_CLOTH"))) {
			case 1:
				// 値が1だった場合
				// adlChangeClothes2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes2");
				// adlChangeClothes3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes3");
				// adlChangeClothes4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes4");
				break;

			case 2:
				// 値が2だった場合
				// adlChangeClothes1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes1");
				// adlChangeClothes3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes3");
				// adlChangeClothes4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes4");
				break;

			case 3:
				// 値が3だった場合
				// adlChangeClothes1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes1");
				// adlChangeClothes2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes2");
				// adlChangeClothes4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes4");
				break;

			case 4:
				// 値が4だった場合
				// adlChangeClothes1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes1");
				// adlChangeClothes2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes2");
				// adlChangeClothes3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes3");
				break;

			default:
				// 値が0もしくはその他だった場合
				// adlChangeClothes1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes1");
				// adlChangeClothes2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes2");
				// adlChangeClothes3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes3");
				// adlChangeClothes4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlChangeClothes4");
				break;
		}

		// 渡りパラメーター：ADL_COSMETICの値をチェックする。
		switch (ACCastUtilities.toInt(printParam.getData("ADL_COSMETIC"))) {
			case 1:
				// 値が1だった場合
				// adCosmetic2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic2");
				// adCosmetic3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic3");
				// adCosmetic4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic4");
				break;

			case 2:
				// 値が2だった場合
				// adCosmetic1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic1");
				// adCosmetic3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic3");
				// adCosmetic4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic4");
				break;

			case 3:
				// 値が3だった場合
				// adCosmetic1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic1");
				// adCosmetic2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic2");
				// adCosmetic4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic4");
				break;

			case 4:
				// 値が4だった場合
				// adCosmetic1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic1");
				// adCosmetic2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic2");
				// adCosmetic3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic3");
				break;

			default:
				// 値が0もしくはその他だった場合
				// adCosmetic1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic1");
				// adCosmetic2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic2");
				// adCosmetic3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic3");
				// adCosmetic4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adCosmetic4");

				break;
		}

		// 渡りパラメーター：ADL_COMMUNICATIONの値をチェックする。
		switch (ACCastUtilities.toInt(printParam.getData("ADL_COMMUNICATION"))) {
			case 1:
				// 値が1だった場合
				// adlCommunication2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication2");
				// adlCommunication3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication3");
				// adlCommunication4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication4");
				break;

			case 2:
				// 値が2だった場合
				// adlCommunication1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication1");
				// adlCommunication3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication3");
				// adlCommunication4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication4");
				break;

			case 3:
				// 値が3だった場合
				// adlCommunication1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication1");
				// adlCommunication2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication2");
				// adlCommunication4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication4");
				break;

			case 4:
				// 値が4だった場合
				// adlCommunication1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication1");
				// adlCommunication2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication2");
				// adlCommunication3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication3");
				break;

			default:
				// 値が0もしくはその他だった場合
				// adlCommunication1を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication1");
				// adlCommunication2を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication2");
				// adlCommunication3を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication3");
				// adlCommunication4を非表示にする。
				ACChotarouXMLUtilities.setInvisible(writer, "adlCommunication4");
				break;
		}

		// 主治医氏名を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME", "doctorName");
		// 主治医医療機関を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_FACILITY_NAME", "providerName");
		// 主治医所在地を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_FACILITY_ADDRESS", "providerAdderess");

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
		// 電話番号を設定する。
		// setValue(providerTel, providerTel);

		String providerTel = QkanCommon.toTel(String.valueOf(printParam.getData("MEDICAL_FACILITY_TEL_FIRST")), String.valueOf(printParam.getData("MEDICAL_FACILITY_TEL_SECOND")), String.valueOf(printParam.getData("MEDICAL_FACILITY_TEL_THIRD")));

		// 結合した電話番号を設定する。
		ACChotarouXMLUtilities.setValue(writer, "providerTel", providerTel);

		// 下記の条件で、緊急時の連絡方法を設定する。
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "DOCTOR_RENRAKUSAKI", "doctorRenrakusaki", 92);
		// 1行に印刷する文字数は全角46文字とする。
		// 最大出力行数は8行とする。

		// 関係機関1 連絡先を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_RENRAKUSAKI1", "kirokushoGrid4.h2.w2");
		// 関係機関1 担当者を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_PREPARED1", "kirokushoGrid4.h2.w3");
		// 関係機関1 備考を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_NOTE1", "kirokushoGrid4.h2.w4");
		// 関係機関2 連絡先を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_RENRAKUSAKI2", "kirokushoGrid4.h3.w2");
		// 関係機関2 担当者を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_PREPARED2", "kirokushoGrid4.h3.w3");
		// 関係機関2 備考を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_NOTE2", "kirokushoGrid4.h3.w4");
		// 関係機関3 連絡先を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_RENRAKUSAKI3", "kirokushoGrid4.h4.w2");
		// 関係機関3 担当者を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_PREPARED3", "kirokushoGrid4.h4.w3");
		// 関係機関3 備考を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_NOTE3", "kirokushoGrid4.h4.w4");
		// 関係機関4 連絡先を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_RENRAKUSAKI4", "kirokushoGrid4.h5.w2");
		// 関係機関4 担当者を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_PREPARED4", "kirokushoGrid4.h5.w3");
		// 関係機関4 備考を設定する。
		ACChotarouXMLUtilities.setValue(writer, printParam, "MEDICAL_NOTE4", "kirokushoGrid4.h5.w4");

		// 下記の条件で、福祉・保健サービス等の利用状況を設定する。
		// 1行に印刷する文字数は全角46文字とする。
		// 最大出力行数は6行とする。
		ACChotarouXMLUtilities.setTextOfLineWrapOnByte(writer, printParam, "USED_STATE", "UsedState", 92);
		
		// ページ終了
		writer.endPageEdit();
		return true;
	}

}
