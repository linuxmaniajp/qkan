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
 * 作成日: 2006/02/16  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス CSV出力 (008)
 * プログラム フォルダ選択 (QP008)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp008;

import java.awt.event.*;
import java.io.*;

import org.omg.CORBA.Environment;

import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.lib.care.claim.calculation.QP001;
import jp.nichicom.ac.text.*;
import jp.nichicom.vr.util.*;
import jp.or.med.orca.qkan.affair.QkanMessageList;
import jp.or.med.orca.qkan.affair.qp.qp009.QP009;

/**
 * フォルダ選択(QP008)
 */
public class QP008 extends QP008Event {
    
    private QP001 owner = null; 
    
    /**
     * コンストラクタです。
     */
    public QP008() {
    }
    
    public QP008(QP001 owner){
        this.owner = owner;
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
        setAffairTitle("QP008");

        VRMap settings = new VRHashMap();
        settings.put("MEDIUM_DIVISION", new Integer(1));
        // 設定ファイルを読み込み、画面の初期状態を設定する。
        if (ACFrame.getInstance().hasProperty("Claim/Button")) {
            // 設定ファイルのClaim-Buttonの値を取得する。
            String buttonState = getProperty("Claim/Button");
            // Claim-Buttonが0の場合
            if ("".equals(buttonState) || "0".equals(buttonState)) {
                // 「保存先決定(基準)ボタン(saveStandardButton)」を押下状態にする。
                getSaveStandardButton().setSelected(true);

                // Claim-Buttonが0の場合
            } else if ("1".equals(buttonState)) {
                // 「保存先決定(任意)ボタン(saveOptionButton)」を押下状態にする。
                getSaveOptionButton().setSelected(true);
            }
        } else {
            getSaveOptionButton().setSelected(true);
        }

        // 設定ファイルのClaim-Folderの値を取得し、ファイルパステキスト(filePath)に設定する。
        if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
            settings.put("FILE_PATH", getProperty("Claim/Folder"));
        }else{
            settings.put("FILE_PATH", new File( "." ).getAbsoluteFile().getParentFile());
        }

        // 該当が無い場合
        // 「伝送(mediumDivisionRadioItem3)」を選択状態にする。
        settings.put("MEDIUM_DIVISION", new Integer(3));
        if (ACFrame.getInstance().hasProperty("Claim/Drive")) {
            // 設定ファイルのClaim-Driveの値を取得する。
            String drive = getProperty("Claim/Drive");
            // Claim-DriveがFDの場合
            if ("FD".equals(drive)) {
                // 「FD(mediumDivisionRadioItem1)」を選択状態にする。
                settings.put("MEDIUM_DIVISION", new Integer(1));
                // Claim-DriveがMOの場合
            } else if ("MO".equals(drive)) {
                // 「MO(mediumDivisionRadioItem2)」を選択状態にする。
                settings.put("MEDIUM_DIVISION", new Integer(2));
                // Claim-DriveがEの場合
            } else if ("E".equals(drive)) {
                // 「伝送(mediumDivisionRadioItem3)」を選択状態にする。s
                settings.put("MEDIUM_DIVISION", new Integer(3));
            }
        }

        // 画面の設定を行う。
        setState_INIT();
        getContents().setSource(settings);
        getContents().bindSource();
        
        pack();
    }

    // コンポーネントイベント

    /**
     * 「OK押下時の処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void okActionPerformed(ActionEvent e) throws Exception {
        VRMap settings = new VRHashMap();
        // contentsのバインドソースとしてsettingsを指定する。
        getContents().setSource(settings);
        // 画面の情報をsettingsに格納する。
        getContents().applySource();
        
        // CSV出力が完了していない場合。(outPut が falseの場合)
        if(!getOutPut()){
            File outPath = new File(ACCastUtilities.toString(settings.get("FILE_PATH")));
            if(!outPath.isDirectory()){
                QkanMessageList.getInstance().QP008_ERROR_OF_INVALID_FOLDER();
                return;
            }
            
            
            //「伝送」が選択されている場合
            if(ACCastUtilities.toInt(settings.get("MEDIUM_DIVISION")) == 3){
                boolean show = true;
                //設定ファイルのClaim-Infoの値を取得する。
                if(ACFrame.getInstance().hasProperty("Claim/Info")){
                    String check = getProperty("Claim/Info");
                    if("1".equals(check)){
                        show = false;
                    }
                }
                if(show){
                    //確認メッセージダイアログを表示する。(QP009)
                    QP009 qp009 = new QP009();
                    qp009.showModal();
                }
            }
            //選択されているフォルダにCSVファイルを作成する。(QP001のメソッドを呼び出し)
            String outFilePath = owner.makeCSV(settings);

            // ドライブの準備ができていない場合
            if(false){
                // 画面状態を変更する。
                setState_ERROR();
            } else {
                // 正常にファイルが作成された場合
                // 画面状態を変更する。
                // 画面に「出力は正常に終了しました。ファイル名：（出力したファイルパス）」を表示する。
                
                getComment().setText("　　出力は正常に終了しました。\n　　ファイル名：" + outFilePath);
                setState_INFO();
                //outPut に trueを設定する。
                setOutPut(true);
                //「デフォルトとして保存(fileFormCheckBox)」にチェックが付いている場合
                if(getFileFormCheckBox().isSelected()){
                    // 現在選択されている値を設定ファイルに保存する。
                    // 「保存先決定(基準)ボタン(saveStandardButton)」が押下状態の場合
                    if(getSaveStandardButton().isSelected()){
                       //Claim-Buttonに0を設定する。
                        setProperty("Claim/Button","0");
                    }
                    //「保存先決定(任意)ボタン(saveOptionButton)」が押下状態の場合
                    if(getSaveOptionButton().isSelected()){
                        //Claim-Buttonに1を設定する。
                        setProperty("Claim/Button","1");
                    }
                    if(!ACTextUtilities.isNullText(settings.get("FILE_PATH"))){
                       //ファイルパステキスト(filePath)に設定されている値を、Claim-Folderに設定する。
                        setProperty("Claim/Folder", String.valueOf(settings.get("FILE_PATH")));
                    }
                    if(!ACTextUtilities.isNullText(settings.get("MEDIUM_DIVISION"))){
                        int select = ACCastUtilities.toInt(settings.get("MEDIUM_DIVISION"));
                        
                        switch(select){
                            //「FD(mediumDivisionRadioItem1)」が選択状態の場合
                            case 1:
                                //Claim-DriveにFDを設定する。
                                setProperty("Claim/Drive","FD");
                                break;
                            //「MO(mediumDivisionRadioItem2)」が選択状態の場合
                            case 2:
                                //Claim-DriveにMOを設定する。
                                setProperty("Claim/Drive","MO");
                                break;
                            //「伝送(mediumDivisionRadioItem3)」が選択状態の場合
                            case 3:
                                //Claim-DriveにEを設定する。
                                setProperty("Claim/Drive","E");
                                break;
                        }
                        
                        
                    }
                }                
                
            }
            
            pack();
            
        } else {
            // CSV出力が完了している場合。(outPut が trueの場合)

            // 当ダイアログ呼び出し元にCSV出力成功を通知し、ダイアログを閉じる。
            dispose();
        }

    }

    /**
     * 「戻る押下時の処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void goBackActionPerformed(ActionEvent e) throws Exception {
        // 画面状態を変更する。
        setState_INIT();

    }

    /**
     * 「キャンセル押下時の処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void cancelActionPerformed(ActionEvent e) throws Exception {
        // 当ダイアログ呼び出し元に値は返さず、ダイアログを閉じる。
        dispose();
    }

    /**
     * 「A:ボタン押下時の処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void saveStandardButtonActionPerformed(ActionEvent e)
            throws Exception {
        
        VRMap settings = new VRHashMap();
        // contentsのバインドソースとしてsettingsを指定する。
        getContents().setSource(settings);
        // 画面の情報をsettingsに格納する。
        getContents().applySource();
        
        // 「FD(mediumDivisionRadioItem1)」を選択状態にする。
        settings.put("MEDIUM_DIVISION",new Integer(1));
        
        // ファイルパステキスト(filePath)に「A:」を表示する。
        settings.put("FILE_PATH","A:");
        
        //「保存先決定(基準)ボタン(saveStandardButton)」を押下状態にする。
        getSaveStandardButton().setSelected(true);
        getSaveOptionButton().setSelected(false);
        
        getContents().bindSource();
        
    }

    /**
     * 「任意のフォルダ:押下時の処理」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void saveOptionButtonActionPerformed(ActionEvent e)
            throws Exception {
        
        VRMap settings = new VRHashMap();
        // contentsのバインドソースとしてsettingsを指定する。
        getContents().setSource(settings);
        // 画面の情報をsettingsに格納する。
        getContents().applySource();
        
        
        // 設定ファイルのClaim-Folderの値を取得する。
        String path = "";
        if (ACFrame.getInstance().hasProperty("Claim/Folder")) {
            path = getProperty("Claim/Folder");
        }
        
        //取得した値を初期値としフォルダ選択画面を表示する。
        ACFileChooser fileChooser = new ACFileChooser();
        File selectFile = fileChooser.showDirectorySelectDaialog("ＣＳＶ出力フォルダ選択", path);
        
        //フォルダ選択画面でＯＫが選択された場合
        if(selectFile != null){
            
            //「伝送(mediumDivisionRadioItem3)」を選択状態にする。
            settings.put("MEDIUM_DIVISION",new Integer(3));
            
            //選択されたパスをファイルパステキスト(filePath)に表示する。
            settings.put("FILE_PATH",selectFile.getPath());
            
            //「保存先決定(任意)ボタン(saveOptionButton)」を押下状態にする。
            getSaveOptionButton().setSelected(true);
            getSaveStandardButton().setSelected(false);
            getContents().bindSource();
        }
        
    }

}
