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
 * 作成日: 2006/02/15  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 利用者向け印刷 (007)
 * プログラム 利用者向請求書印刷設定 (QP007)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp007;

import java.awt.event.*;

import javax.swing.event.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.vr.util.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;

/**
 * 利用者向請求書印刷設定(QP007)
 */
public class QP007 extends QP007Event {
    
    //設定値返却用
    VRMap result = null;
    
    /**
     * コンストラクタです。
     */
    public QP007() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @param affair
     *            業務情報
     * @throws Exception
     *             処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        VRMap affairInfoMap = QkanCommon.getAffairInfo(getDBManager(), "QP007");
        setTitle((String) affairInfoMap.get("WINDOW_TITLE"));
        
        VRMap settings = new VRHashMap();
        settings.put("TARGET_RADIO",new Integer(1));

        // 設定ファイルを読み込み、画面の初期状態を設定する。
        if (ACFrame.getInstance().hasProperty("Claim/TargetRadio")) {
            String targetRadio = getProperty("Claim/TargetRadio");
            //設定ファイルのClaim-TargetRadioが1の場合
            if("1".equals(targetRadio)){
                //「請求書ラジオボタン(patientBillSetupPapersRadioItem1)」にチェックを付ける。
                settings.put("TARGET_RADIO",new Integer(1));
            //設定ファイルのClaim-TargetRadioが2の場合
            } else if("2".equals(targetRadio)){
                //「領収書ラジオボタン(patientBillSetupPapersRadioItem2)」にチェックを付ける。
                settings.put("TARGET_RADIO",new Integer(2));
            //設定ファイルのClaim-TargetRadioが3の場合
            } else if("3".equals(targetRadio)){
                //「請求書・領収書ラジオボタン(patientBillSetupPapersRadioItem3)」にチェックを付ける。
                settings.put("TARGET_RADIO",new Integer(3));
            }
        }
        
        if (ACFrame.getInstance().hasProperty("Claim/TotalCheck")) {
            //設定ファイルのClaim-TotalCheckが0の場合
            //「合計・小計を印刷する(patientBillSetupBillAndReceiptDate)」のチェックをはずす。
            //設定ファイルのClaim-TotalCheckが1の場合
            //「合計・小計を印刷する(patientBillSetupBillAndReceiptDate)」のチェックを付ける。
            settings.put("TOTAL_CHECK",getProperty("Claim/TotalCheck"));
        } else {
            settings.put("TOTAL_CHECK",new Integer(0));
        }
        
        if (ACFrame.getInstance().hasProperty("Claim/PrintCheck")) {
            //設定ファイルのClaim-PrintCheckが0の場合
            //「請求書に振込先の枠を印刷する(patientBillSetupUnderPrintOn)」のチェックをはずす。
            //設定ファイルのClaim-PrintCheckが1の場合
            //「請求書に振込先の枠を印刷する(patientBillSetupUnderPrintOn)」のチェックを付ける。
            settings.put("PRINT_CHECK",getProperty("Claim/PrintCheck"));
        } else {
            settings.put("PRINT_CHECK",new Integer(0));
        }
        
        if (ACFrame.getInstance().hasProperty("Claim/StyleCheck")) {
            //設定ファイルのClaim-StyleCheckが0の場合
            //「医療費控除対応版で出力する(patientBillSetupMedicalTreatmentOn)」のチェックをはずす。
            //設定ファイルのClaim-StyleCheckが1の場合
            //「医療費控除対応版で出力する(patientBillSetupMedicalTreatmentOn)」のチェックを付ける。
            settings.put("STYLE_CHECK",getProperty("Claim/StyleCheck"));
        } else {
            settings.put("STYLE_CHECK",new Integer(0));
        }
        
        // [利用者向け請求書・領収書　詳細版対応] fujihara add start
        if (ACFrame.getInstance().hasProperty("Claim/DetailsCheck")) {
			//設定ファイルのClaim-DetailsCheckが0の場合	
			//「詳細版で印刷する(patientBillSetupDetailsPrintOn)」のチェックをはずす。
			//設定ファイルのClaim-DetailsCheckが0の場合	
			//「詳細版で印刷する(patientBillSetupDetailsPrintOn)」のチェックを付ける。
            settings.put("DETAILS_CHECK",getProperty("Claim/DetailsCheck"));
        } else {
            settings.put("DETAILS_CHECK",new Integer(0));
        }
        // [利用者向け請求書・領収書　詳細版対応] fujihara add end
        
        
        // 「請求書日付(patientBillSetupBillDate)」にログイン日付を設定する。
        settings.put("TARGET_DATE",QkanSystemInformation.getInstance().getSystemDate());
        // 「領収書日付(patientBillSetupReceiptDate)」にログイン日付を設定する。
        settings.put("GET_DATE",QkanSystemInformation.getInstance().getSystemDate());
        getContents().setSource(settings);
        getContents().bindSource();
    }

    // コンポーネントイベント

    /**
     * 「印刷条件Enabled変更」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void patientBillSetupPapersRadioSelectionChanged(
            ListSelectionEvent e) throws Exception {
        
        //■印刷オプションチェックの変更処理
        switch(getPatientBillSetupPapersRadio().getSelectedIndex()){
            //請求書が選択されている場合
            case 1:
                //「医療費控除対応版で出力(patientBillSetupMedicalTreatmentOn)」のチェックをはずす。
                getPatientBillSetupMedicalTreatmentOn().setValue(0);
                // 請求書ラジオボタンクリック時の画面設定を行う。
                setState_RADIO_1();
                break;
            //領収書が選択されている場合
            case 2:
                //「請求書に振込先の枠を印刷する(patientBillSetupUnderPrintOn)」のチェックをはずす。
                getPatientBillSetupUnderPrintOn().setValue(0);
                // 領収書ラジオボタンクリック時の画面設定を行う。
                setState_RADIO_2();
                break;
                
            //請求書・領収書が選択されている場合
            case 3:
                // 請求書・領収書ラジオボタンクリック時の画面設定を行う。
                setState_RADIO_3();
                break;
        }
    }

    /**
     * 「印刷押下時の処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void printActionPerformed(ActionEvent e) throws Exception {
        VRMap settings = new VRHashMap();
        // contentsのバインドソースとしてsettingsを指定する。
        getContents().setSource(settings);
        // 画面の情報をsettingsに格納する。
        getContents().applySource();
        
        
        // 現在選択されている値を設定ファイルに保存する。
        // 「請求書ラジオボタン(patientBillSetupPapersRadioItem1)」にチェックが付いている場合。
        // 設定ファイルのClaim-TargetRadioに1を設定する。
        // 「領収書ラジオボタン(patientBillSetupPapersRadioItem2)」にチェックが付いている場合。
        // 設定ファイルのClaim-TargetRadioに2を設定する。
        // 「請求書・領収書ラジオボタン(patientBillSetupPapersRadioItem3)」にチェックが付いている場合。
        // 設定ファイルのClaim-TargetRadioに3を設定する。
        setProperty("Claim/TargetRadio", String.valueOf(settings.getData("TARGET_RADIO")));
        
        setProperty("Claim/TotalCheck",String.valueOf(settings.getData("TOTAL_CHECK")));
        
        // 「請求書に振込先の枠を印刷する(patientBillSetupUnderPrintOn)」がチェックされていない場合。
        // 設定ファイルのClaim-PrintCheckに0を設定する。
        // 「請求書に振込先の枠を印刷する(patientBillSetupUnderPrintOn)」がチェックされている場合。
        // 設定ファイルのClaim-PrintCheckに1を設定する。
        setProperty("Claim/PrintCheck", String.valueOf(settings.getData("PRINT_CHECK")));
        
        // 「医療費控除対応版で出力する(patientBillSetupMedicalTreatmentOn)」がチェックされていない場合。
        // 設定ファイルのClaim-StyleCheckに0を設定する。
        // 「医療費控除対応版で出力する(patientBillSetupMedicalTreatmentOn)」がチェックされている場合。
        // 設定ファイルのClaim-StyleCheckに1を設定する。
        setProperty("Claim/StyleCheck", String.valueOf(settings.getData("STYLE_CHECK")));
        
        // [利用者向け請求書・領収書　詳細版対応] fujihara add start
        //「詳細版で印刷する(patientBillSetupDetailsPrintOn)」がチェックされていない場合。	
        //設定ファイルのClaim-DetailsCheckを0に設定する。
        //「詳細版で印刷する(patientBillSetupDetailsPrintOn)」がチェックされている場合。	
        //設定ファイルのClaim-DetailsCheckを1に設定する。
        setProperty("Claim/DetailsCheck", String.valueOf(settings.getData("DETAILS_CHECK")));
        // [利用者向け請求書・領収書　詳細版対応] fujihara add end
        
        saveProperty();
        
        // 当ダイアログ呼び出し元に、「印刷対象」「請求書日付」「領収書日付」「合計・小計を印刷する」「請求書に振込先の枠を印刷する」
        // 「医療費控除対応版で出力」に設定された値を返し、ダイアログを閉じる。
        
        result = settings;
        result.put("PRINT","TRUE");
        //ウインドウを閉じる。
        dispose();
    }

    /**
     * 「閉じる押下時の処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void closeActionPerformed(ActionEvent e) throws Exception {
        result = null;
        // 当ダイアログ呼び出し元に値は返さず、ダイアログを閉じる。
        dispose();
    }
    
    public VRMap getResult() throws Exception {
        return result;
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QP007.class.getName(), param));
    }

}
