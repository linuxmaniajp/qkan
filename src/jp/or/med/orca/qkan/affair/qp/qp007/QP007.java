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
import java.awt.im.InputSubset;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.*;
import javax.swing.table.TableCellEditor;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableCellViewerCustomCell;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.text.QkanServiceKindNameFormat;

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
        
        
        //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
        //「サービスごとに請求書・領収書を出力する」のチェックが付いている場合、
        //サービス名称一覧のグリッドを表示する
        if (ACFrame.getInstance().hasProperty("PrintConfig/ServiceByReceipt")
        	&& ACCastUtilities.toInt(getProperty("PrintConfig/ServiceByReceipt")) == 1) {
        	//サービス名称-事業所名のグリッドを表示
            setState_BY_RECEIPT_ON();
            
            //印字に使用する事業所名称を取得し、グリッドに表示する
            getProviderNames();
            
            //IMEモードを漢字入力に
            VRList list = new VRArrayList();
            for (int i = 0; i < getProviderNameList().size(); i++) {
                ACTextField cellTextField = new ACTextField();
                ACTableCellViewerCustomCell cell = new ACTableCellViewerCustomCell();
                cell.setEditor(cellTextField);
                cellTextField.setIMEMode(InputSubset.KANJI);
                cellTextField.setMaxLength(100);
                cell.setEditable(true);
                list.add(cell);
            }
            getProviderNameColumn().setCustomCells(list);

        } else {
        	setState_BY_RECEIPT_OFF();
        }
        
        //画面配置を最適化
        pack();
        //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
        
        
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
        
        //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
        //変更された事業所名称の保存処理
        if (getTablePanel().isVisible()) {
	        saveProviderNames();
	        result.put("PROVIDER_NAMES",getProviderNameList());
        }
        //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
        
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

    
    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
	public void getProviderNames() throws Exception {
		
		// ログイン事業所名称を取得
		String loginProviderName = "";
        VRList providerData = QkanCommon.getProviderInfo(getDBManager(), QkanSystemInformation.getInstance().getLoginProviderID());
        if (!providerData.isEmpty()) {
        	loginProviderName = ACCastUtilities.toString(((VRMap)providerData.get(0)).get("PROVIDER_NAME"), "");
        }
        
		
        // 提供しているサービスの一覧を取得
		VRList providerServiceList = QkanCommon.getProviderServiceDetail(getDBManager(), QkanSystemInformation.getInstance().getLoginProviderID());
		
		// サービス名称の一覧を取得
		VRMap serviceMap = QkanCommon.getMasterService(getDBManager());
		
		// 前回印刷時に使用した事業所名称の情報を取得
		VRMap sqlParam = new VRHashMap();
		sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
		VRMap prePrintProviderNames = new VRHashMap();
		ACBindUtilities.setMapFromArray(
				getDBManager().executeQuery(getSQL_GET_FIXED_FORM(sqlParam)),
				prePrintProviderNames,
				"CONTENT_KEY");
		
		// FIXED_FORM_IDを退避しておく
		if (prePrintProviderNames.isEmpty()) { 
			setProviderFixedFormId(0);
		} else {
			setProviderFixedFormId(ACCastUtilities.toInt(((VRMap)prePrintProviderNames.getData(0)).get("FIXED_FORM_ID"), 0));
		}
		
		
		Set offerServiceKind = new HashSet();
		VRList showList = new VRArrayList();
		
		for (int i = 0; i < providerServiceList.size(); i++) {

			VRMap provider = (VRMap)providerServiceList.get(i);
			VRMap master = (VRMap)serviceMap.get(provider.get("SYSTEM_SERVICE_KIND_DETAIL"));
			
			//マスタにサービス種類コードが設定されていない場合は、設定キャンセル
			if (master.get("SERVICE_CODE_KIND") == null) {
				continue;
			}
			
			//既にリストに追加済みのサービスの場合はキャンセル
			if (offerServiceKind.contains(master.get("SERVICE_CODE_KIND"))) {
				continue;
			}
			
			//データに追加
			VRMap row = new VRHashMap();
			row.put("SERVICE_CODE_KIND", new Integer(ACCastUtilities.toInt(master.get("SERVICE_CODE_KIND"), 0) + 1000));
			
			// prePrintProviderNamesの内容を確認
			Integer kind = ACCastUtilities.toInteger(master.get("SERVICE_CODE_KIND"), 0);
			if (prePrintProviderNames.containsKey(kind)) {
				VRMap t = (VRMap)prePrintProviderNames.get(kind);
				row.put("PROVIDER_NAME", t.get("CONTENT"));
				prePrintProviderNames.remove(kind);
			} else {
				row.put("PROVIDER_NAME", loginProviderName);
			}
			
			
			showList.add(row);
			
			offerServiceKind.add(master.get("SERVICE_CODE_KIND"));
		}
		
		// prePrintProviderNamesに残っているデータを追加
		// （以前提供していたが、現在は提供していないサービス）
		for (int i = 0; i < prePrintProviderNames.size(); i++) {
			VRMap row = new VRHashMap();
			VRMap t = (VRMap)prePrintProviderNames.getData(i);
			row.put("SERVICE_CODE_KIND", new Integer(ACCastUtilities.toInt(t.get("CONTENT_KEY"), 0) + 1000));
			row.put("PROVIDER_NAME", t.get("CONTENT"));
			showList.add(row);
		}
		
		setProviderNameList(showList);
		
		// 列の翻訳データとして、サービスコードのデータを設定
		((QkanServiceKindNameFormat)getServiceNameColumn().getFormat()).setMasterService(serviceMap);
		
		// 作成したデータをテーブルに表示する
        String[] ada = { "SERVICE_CODE_KIND", "PROVIDER_NAME" };
		ACTableModelAdapter tableModel = new ACTableModelAdapter();
		tableModel.setColumns(ada);
		getServiceByProviderName().setModel(tableModel);
		
		tableModel.setAdaptee(getProviderNameList());
	}

	// 事業所名称保存処理
	public void saveProviderNames() throws Exception {
		
		//FIXED_FORMに登録されている情報を念のため再取得
		VRMap sqlParam = new VRHashMap();
		sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
		VRMap prePrintProviderNames = new VRHashMap();
		ACBindUtilities.setMapFromArray(
				getDBManager().executeQuery(getSQL_GET_FIXED_FORM(sqlParam)),
				prePrintProviderNames,
				"CONTENT_KEY");
		
		//idを確定
		if (getProviderFixedFormId() == 0) {
			
			VRList result = getDBManager().executeQuery(getSQL_GET_MAX_FIXED_FORM_ID(null));
			if (result.isEmpty()) {
				throw new Exception("getSQL_GET_MAX_FIXED_FORM_IDの結果が0件です。");
			}
			setProviderFixedFormId(ACCastUtilities.toInt(((VRMap)result.get(0)).get("MAX_FIXED_FORM_ID")));
		}
		
		
		sqlParam.put("FIXED_FORM_ID", Integer.toString(getProviderFixedFormId()));
		
		VRMap row = null;
		for (int i = 0; i < getProviderNameList().size(); i++) {
			row = (VRMap)getProviderNameList().get(i);
			row.put("SERVICE_CODE_KIND", new Integer(ACCastUtilities.toInt(row.get("SERVICE_CODE_KIND"), 0) - 1000));
			
			// 登録済みデータ
			if (prePrintProviderNames.containsKey(row.get("SERVICE_CODE_KIND"))) {
				VRMap t =(VRMap)prePrintProviderNames.get(row.get("SERVICE_CODE_KIND"));
				
				//事業所名の変更チェック
				if (!t.get("CONTENT").equals(row.get("PROVIDER_NAME"))) {
					sqlParam.put("CONTENT_KEY", row.get("SERVICE_CODE_KIND"));
					sqlParam.put("CONTENT", row.get("PROVIDER_NAME"));
					getDBManager().executeUpdate(getSQL_UPDATE_FIXED_FORM(sqlParam));
				}
				
			// 未登録データ
			} else {
				sqlParam.put("CONTENT_KEY", row.get("SERVICE_CODE_KIND"));
				sqlParam.put("CONTENT", row.get("PROVIDER_NAME"));
				getDBManager().executeUpdate(getSQL_INSERT_FIXED_FORM(sqlParam));
			}
		}
		
	}
	//[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応

}
