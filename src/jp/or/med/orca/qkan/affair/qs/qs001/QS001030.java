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
 * 開発者: 田中　統蔵
 * 作成日: 2006/02/15  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 集計明細画面 (QS001030)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServicePrintParameter;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceSchedulePrintManager;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceUnitCalcurateResult;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * 集計明細画面(QS001030)
 */
public class QS001030 extends QS001030Event {
    /**
     * コンストラクタです。
     */
    public QS001030() {
    }

    // コンポーネントイベント

    /**
     * 「閉じる」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void closeActionPerformed(ActionEvent e) throws Exception {
        // ■画面を閉じる
        // 画面を破棄します。
        dispose();
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001030.class.getName(), param));
    }

    // 内部関数

    /**
     * 「初期設定」に関する処理を行ないます。
     * 
     * @param inLimitAmout CareServiceUnitCalcurateResult
     * @param insureInfo VRMap
     * @param procesType int
     * @throws Exception 処理例外
     */
    public void showModal(CareServiceUnitCalcurateResult inLimitAmout,
            VRMap insureInfo, int processType,
            CareServiceCodeCalcurater calcurater, VRList services)
            throws Exception {
        // ■画面展開時の初期設定
        CareServiceUnitCalcurateResult outerService = calcurater
        .getServiceUnitCalcurateResult(services,
                CareServiceCodeCalcurater.CALC_MODE_OUTER_SERVICE_LIMIT_AMOUNT);

        
        // ※引数を元にテーブルモデルを作成し、集計明細テーブル(detailsTable)に設定する。
        getDetailsTable().setModel(
                new ACTableModelAdapter(inLimitAmout, new String[] {
                        "SYSTEM_SERVICE_KIND_DETAIL", "UNIT", "ADJUST",
                        "RESULT", }));
        getOuterTable().setModel(
                new ACTableModelAdapter(outerService, new String[] {
                        "SYSTEM_SERVICE_KIND_DETAIL", "UNIT", "ADJUST",
                        "RESULT", }));
        getContents().setSource(insureInfo);
        getContents().bindSource();

        // ※利用者負担額概算を算出を算出する。
        checkInLimitAmount(calcurater, services, inLimitAmout, outerService);

        // ※ウィンドウタイトルの設定
        // 業務情報レコードを取得する。
        // ウィンドウタイトルに、取得レコードのKEY : WINDOW_TITLEのVALUEを設定する。
        setAffairTitle("QS001030");

        if (processType == QkanConstants.PROCESS_TYPE_PLAN) {
            setState_PROCESS_TYPE_PLAN();
        } else {
            setState_PROCESS_TYPE_RESULT();
        }

        setVisible(true);
    }


    /**
     * 「給付管理対象概算算出」に関する処理を行ないます。
     * 
     * @param calcurater CareServiceCodeCalcurater
     * @param services VRList
     * @throws Exception 処理例外
     */
    public void checkInLimitAmount(CareServiceCodeCalcurater calcurater,
            VRList services,CareServiceUnitCalcurateResult inLimitAmout,CareServiceUnitCalcurateResult outLimitAmout)
            throws Exception {

        
        // ■利用者負担額概算を算出
        
        //※別表に記載しない給付管理対象外単位数の計算
        // 合算用の整数を宣言し、0で初期化する。
        int total = 0;
        // 集計単位計算用のマップ配列(Map[])を要素数2個の宣言時初期化で生成する。
        Map[] totalGroupingCache = new Map[] { new HashMap(), new HashMap() };
        Iterator it = services.iterator();
        while (it.hasNext()) {
            // サービスを全走査する。
            VRMap service = (VRMap) it.next();
            if (CareServiceCommon.isLifeCare(service)||CareServiceCommon.isHomeMedicalAdvice(service)) {
                //別表に記載されない生活介護/居宅療養管理指導サービスの単位数を加算する。
                // 割引済み単位数を計算し、合算に加算する。
                total += calcurater.getReductedUnit(service, true,
                        CareServiceCodeCalcurater.CALC_MODE_OUT_LIMIT_AMOUNT,
                        totalGroupingCache);
            }
        }
        
        //別表の集計ロジックを通して、別表に記載される給付管理対象外単位数と利用者負担額を取得する。
        CareServiceSchedulePrintManager mng = new CareServiceSchedulePrintManager();
        mng.initialize(calcurater);
        mng.parse(services);
        mng.setBuildDivedProvider(false);

        int lastRow = mng.getUserSubTableRowCount();
        CareServicePrintParameter buildParam = new CareServicePrintParameter();
        buildParam.setPrintParameter(new VRHashMap());
        List list=new ArrayList();
        mng.buildUserSubTable(buildParam, list);
        int patientCost = 0;
        int outLimitUnit = 0;
        it = list.iterator();
        while (it.hasNext()) {
            Iterator provIt = ((List) it.next()).iterator();
            while (provIt.hasNext()) {
                List ins = (List) provIt.next();
                if (!ins.isEmpty()) {
                    Map page = (Map) ins.get(0);
                    patientCost += ACCastUtilities.toInt(page
                            .get("main.total.x18"), 0)
                            + ACCastUtilities.toInt(page.get("main.total.x19"),
                                    0);
                    Iterator insIt = ins.iterator();
                    while (insIt.hasNext()) {
                        page = (Map) insIt.next();
                        for (int i = 1; i < lastRow; i++) {
                            String unit = ACCastUtilities.toString(page
                                    .get("main.y" + i + ".x12"));
                            if (!ACTextUtilities.isNullText(unit)) {
                                if (unit.charAt(0) == '(') {
                                    outLimitUnit += ACCastUtilities
                                            .toInt(unit.substring(1, unit
                                                    .length() - 2), 0);
                                }
                            }
                        }
                    }
                }
            }
        }
        
        //別表に記載された利用者負担額と生活介護/居宅療養管理指導サービスの単位数(=概算)の合算を負担額概算(aboutCalc)の値として表示する。
        getAboutCalc().setText(ACCastUtilities.toString(patientCost+total));
        //別表に記載された給付管理対象外単位数と生活介護/居宅療養管理指導サービスの単位数の合算を給付管理対象外単位数(homeMedicalAdvice)の値として表示する。
        getHomeMedicalAdvice().setText(ACCastUtilities.toString(outLimitUnit+total));

        
        // ※給付管理対象内サービスを算出
        int adj = inLimitAmout.getAdjustTotal();
        int adjusted = inLimitAmout.getManagementTotal() - adj;
        int limit = ACCastUtilities.toInt(getInLimitAmountLimit().getText(), 0);

        //調整後単位数と支給限度額のどちらか低いほうを限度内単位数として表示する。
        getInLimitAmountValue().setText(
                ACCastUtilities.toString(Math.min(adjusted, limit)));
        
        
    }

}
