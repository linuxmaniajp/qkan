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
 * 開発者: 上司　和善
 * 作成日: 2006/02/18  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 定型文編集 (008)
 * プログラム 定型文編集 (QO008)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo008;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import com.lowagie.text.Table;
import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;

import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * 定型文編集(QO008)
 */
public class QO008 extends QO008Event {
    /**
     * コンストラクタです。
     */
    public QO008() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @param affair 業務情報
     * @throws Exception 処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // 画面初期化を行う。
        initialize();

        // データを検索し、画面に展開する。
        doFind();
        
        //初期化
        setDataChangeFlag(0);

    }

    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }

        // 最後に保存されてから変更されている場合（dataChangeFlag == 1）
        if (getDataChangeFlag() == 1) {
            // 確認メッセージを表示する。
            // ・メッセージID：WARNING_OF_UPDATE_ON_MODIFIED
            int msgID = QkanMessageList.getInstance()
                    .WARNING_OF_UPDATE_ON_MODIFIED();
            // 「はい」を選択した場合
            switch (msgID) {
            case ACMessageBox.RESULT_YES:
                // 保存処理を行う。
                if (!doSave()) {
                    // 保存処理が正常終了しなかった場合
                    // 処理を中断する。(終了)
                    return false;

                }
                return true;
                
            //いいえ選択時
            case ACMessageBox.RESULT_NO:
                //前画面に遷移する
                return true;
                
            //キャンセル選択時
            case ACMessageBox.RESULT_CANCEL:
                // 処理を中断する（何もしない）。
                return false;

            }

        }

        // 「QM002 メインメニュー」画面に遷移する。
        return true;
    }

    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        
        // 最後に保存されてから変更されているかどうかチェックする。
        if (getDataChangeFlag() == 1) {
            // 最後に保存されてから変更されている場合（dataChangeFlag == 1）
            // 終了確認メッセージを表示する。
            int msgID = QkanMessageList.getInstance()
                    .WARNING_OF_CLOSE_ON_MODIFIED();
            // ・メッセージID：WARNING_OF_CLOSE_ON_MODIFIED
            if (msgID == ACMessageBox.RESULT_OK) {
                // 「はい」選択以外の場合
                return true;
            } else {
                return false;
            }
            // 処理を中断する（何もしない）。
            // システムを終了する。
        }
        
        return true;
    }

    // コンポーネントイベント

    /**
     * 「更新処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {
        int fixedRow = -1;
        int fixedItemRow = -1;
        // 項目テーブルのレコードが選択されていた場合
        if (getFixedFormTable().getSelectedModelRow() != -1) {
            // 選択されているレコードを取得する。
            fixedRow = getFixedFormTable().getSelectedModelRow();
        }

        // 詳細項目テーブルのレコードが選択されていた場合
        if (getFixedFormEditItemTable().getSelectedModelRow() != -1) {
            // 選択されているレコード数を取得する。
            fixedItemRow = getFixedFormEditItemTable().getSelectedModelRow();
        }
        // 保存処理を行う。
        if (!doSave()) {
            // 保存処理が正常終了しなかった場合
            // 処理を中断する。(終了)
            return;
        }

        // 保存処理が正常終了した場合
        // 最新のデータを取得する。
        doFind();

        if (fixedRow != -1) {
            getFixedFormTable().setSelectedModelRow(fixedRow);
        }

        // 保存前に選択されていた行を選択状態にする。
        if (fixedItemRow != -1) {
            getFixedFormEditItemTable().setSelectedModelRow(fixedItemRow);

        }

        // 処理完了通知メッセージを表示する。
        QkanMessageList.getInstance().UPDATE_SUCCESSED();
        // ・メッセージID：UPDATE_SUCCESSED

        // dataChangeFlagに0を代入する。
        setDataChangeFlag(0);
    }

    /**
     * 「表示データ切り替え処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void fixedFormTableSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // VRList listを生成する。
        VRList list = new VRArrayList();
        // 選択されていない場合
        if (getFixedFormTable().getSelectedModelRow() == -1) {
            // fixedFormTableModelにlistを設定する。
//            getFixedFormTableModel().setAdaptee(list);

            // 画面の状態を設定する。
            // ・状態ID：UNEDITABLE
            setState_UNEDITABLE();
        } else {
            // 選択されている場合
            // 選択レコードよりFIXED_FORM_IDを取得し、fixedFormIdに格納する。

            VRMap map = (VRMap) getFixedFormTable().getSelectedModelRowValue();
            setFixedFormId(ACCastUtilities.toInt(map.getData("FIXED_FORM_ID")));
            setTableType(ACCastUtilities.toInt(map.getData("TABLE_TYPE")));
            
            //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
            setSelectedKey(getTableType()+"-"+getFixedFormId());
            //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
            
            // 現在選択中の分類に紐づく詳細項目群を取得する。
            if (getListGroupMap() != null) {
            	//[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010年度対応
                //list = (VRList) getListGroupMap().getData(getTableType()+"-"+getFixedFormId());
            	list = (VRList) getListGroupMap().getData(getSelectedKey());
                //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010年度対応
            }
            // fixedFormTableModelにlistを設定する。
            if(list.size() >= 0){
                getFixedFormTableModel().setAdaptee(list);
            }
            
            //[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010年度対応
            /*
            // 画面の状態を設定する。
            setState_EDITABLE();
            // ・状態ID：EDITABLE
            // listの件数が0件の場合
            if (list.size() <= 0) {
                // ボタンの状態設定を行う。
                // ・状態ID：ITEM_UNSELECTED
            	setState_ITEM_UNSELECTED();
            } else {
                // listの件数が1件以上の場合
                // fixedFormEditItemTableの1行目を選択した状態に設定する。
            	getFixedFormEditItemTable().setSelectedSortedFirstRow();
            }
            */
            
            // 画面の状態を設定する。
            // listの件数が0件の場合
            if (list.size() <= 0) {
            	if (PRINT_PROVIDER.equals(getSelectedKey())) {
            		setState_UNEDITABLE();
            	} else {
            		setState_ITEM_UNSELECTED();
            	}
            	
            } else {
                // listの件数が1件以上の場合
                // fixedFormEditItemTableの1行目を選択した状態に設定する。
            	getFixedFormEditItemTable().setSelectedSortedFirstRow();
            	
            	if (PRINT_PROVIDER.equals(getSelectedKey())) {
            		setState_ITEM_SELECTED_PROVIDER();
            	} else {
            		setState_EDITABLE();
            	}
            }
            //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010年度対応
        }
    }

    /**
     * 「定型文表示処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void fixedFormEditItemTableSelectionChanged(ListSelectionEvent e)
            throws Exception {
        // VRMap mapを生成する。
        VRMap map = new VRHashMap();
        // 選択されていない場合
        if (getFixedFormEditItemTable().getSelectedModelRow() == -1) {
            // ボタンの状態設定を行う。
        	//[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010年度対応
        	if (PRINT_PROVIDER.equals(getSelectedKey())) {
        		setState_UNEDITABLE();
        	} else {
        		setState_ITEM_UNSELECTED();
        	}
            //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010年度対応
            // ・状態ID：ITEM_UNSELECTED
            // 「入力・編集テキストボックス領域（fixedFormEditInputCaptions）」のソースを生成し、mapに格納する。
            map = (VRMap) getFixedFormEditInputCaptions().createSource();
        } else {
            // 選択されている場合
            // ボタンの状態設定を行う。
        	//[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010年度対応
        	if (PRINT_PROVIDER.equals(getSelectedKey())) {
        		setState_ITEM_SELECTED_PROVIDER();
        	} else {
        		setState_ITEM_SELECTED();
        	}
            //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010年度対応
            // ・状態ID：ITEM_SELECTED
            // 選択レコードをmapに格納する。
            map = (VRMap) getFixedFormEditItemTable()
                    .getSelectedModelRowValue();

        }
        
        // mapを「入力・編集テキストボックス領域（fixedFormEditInputCaptions）」のソースとして設定する。
        getFixedFormEditInputCaptions().setSource(map);

        // 画面に展開する。
        getFixedFormEditInputCaptions().bindSource();

    }

    /**
     * 「定型文追加処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void fixedFormEditInsertActionPerformed(ActionEvent e)
            throws Exception {
        // 入力チェックを行う。
        if (!isValidInput()) {
            // 入力チェックの戻り値がfalseの場合
            // 処理を中断する。(終了)
            return;
        }
        // VRMap mapを生成する。
        VRMap map = new VRLinkedHashMap();
        // mapを「入力・編集テキストボックス領域（fixedFormEditInputCaptions）」のソースとして設定する。
        getFixedFormEditInputCaptions().setSource(map);
        // mapに「入力・編集テキストボックス領域（fixedFormEditInputCaptions）」の値を流し込む。
        getFixedFormEditInputCaptions().applySource();
        // VRList listを生成する。
        VRList list = new VRArrayList();
        // fixedFormTableModelに設定されているレコード集合をVRList listに格納する。
        list = (VRList) getListGroupMap().getData(getTableType()+"-"
                +getFixedFormId());
        
        
        // 追加可能なデータかどうかチェックする。
        for (int i = 0; i < list.size(); i++) {
            VRMap checkMap = (VRMap) list.getData(i);
            // 追加項目と一致した場合
            if (map.getData("CONTENT").equals(checkMap.getData("CONTENT"))) {
                QkanMessageList.getInstance().QO008_ERROR_OF_OVERLAP("内容");
                return;
            }
        }
        
        int maxSort = 0;
        
        // mapに以下のKEY/VALUEを設定する。
        // KEY：SQL_MODE VALUE：SQL_MODE_INSERT
        // KEY：TABLE_TYPE VALUE：TABLE_TYPE_FIXED_FORM
        // KEY：FIXED_FORM_ID VALUE：fixedFormId
        // KEY：CONTENT_SORT VALUE：maxSort + 1
        map.setData("SQL_MODE", new Integer(String.valueOf(SQL_MODE_INSERT)));
        map.setData("TABLE_TYPE", new Integer(getTableType()));
        map.setData("FIXED_FORM_ID", new Integer(getFixedFormId()));
        map.setData("CONTENT_SORT", new Integer(0));
        // mapをlistに追加する。
        list.add(map);
        // fixedFormTableModelにlistを設定する。
        getFixedFormTableModel().setAdaptee(list);
        // 追加した行を選択した状態に設定する。
        getFixedFormEditItemTable().setSelectedSortedLastRow();
        // ボタンの状態設定を行う。
        setState_ITEM_SELECTED();
        // ・状態ID：ITEM_SELECTED
        // dataChangeFlagに1を代入する。
        setDataChangeFlag(1);

    }

    /**
     * 「定型文更新処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void fixedFormEditUpdateActionPerformed(ActionEvent e)
            throws Exception {
        // 入力チェックを行う。
        if (!isValidInput()) {
            // 入力チェックの戻り値がfalseの場合
            // 処理を終了する。
            return;
        }

        VRMap applyMap = new VRHashMap();
        // 「入力・編集テキストボックス領域（fixedFormEditInputCaptions）」のソースを取得する。
        getFixedFormEditInputCaptions().setSource(applyMap);
        getFixedFormEditInputCaptions().applySource();
        // 選択行のレコードに以下のKEY/VALUEを設定する。
        VRMap map = (VRMap) getFixedFormEditItemTable()
                .getSelectedModelRowValue();
        // 選択行レコードのSQL_MODEの値がSQL_MODE_INSERTの場合
        if (new Integer(SQL_MODE_INSERT).equals(map.getData("SQL_MODE"))) {
            // KEY：SQL_MODE VALUE：SQL_MODE_INSERT_TO_UPDATE
            map.setData("SQL_MODE", new Integer(SQL_MODE_INSERT_TO_UPDATE));
            // 新規＋更新モード以外だった場合
        } else if (!new Integer(SQL_MODE_INSERT_TO_UPDATE).equals(map
                .getData("SQL_MODE"))) {            
            // KEY：SQL_MODE VALUE：SQL_MODE_UPDATE
            map.setData("SQL_MODE", new Integer(SQL_MODE_UPDATE));
        }
        
        map.putAll(applyMap);
        // dataChangeFlagに1を代入する。
        setDataChangeFlag(1);
        // 再描画処理
        getFixedFormEditItemTable().revalidate();
        getFixedFormEditItemTable().repaint();

    }

    /**
     * 「定型文削除処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void fixedFormEditDeleteActionPerformed(ActionEvent e)
            throws Exception {
        if(getFixedFormEditItemTable().getSelectedModelRow()==-1){
            return;
        }
        
        // 選択行のレコードのSQL_MODEの値によって分岐する。
        VRMap map = (VRMap) getFixedFormEditItemTable()
                .getSelectedModelRowValue();
        // SQL_MODEの値を持たない場合
        if (!VRBindPathParser.has("SQL_MODE", map)) {
            // 選択行のレコードに以下のKEY/VALUEを設定する。
            // KEY：SQL_MODE VALUE：SQL_MODE_DELETE
            map.setData("SQL_MODE", new Integer(SQL_MODE_DELETE));
            // SQL_MODE_DEFAULTの場合
            // 選択行のレコードに以下のKEY/VALUEを設定する。
            // KEY：SQL_MODE VALUE：SQL_MODE_DELETE
        } else {
            if (!new Integer(SQL_MODE_DELETE).equals(map.getData("SQL_MODE"))) {
                // 現在処理中の項目リストを取得
                //// 2008/01/07 [Masahiko_Higuchi] edit - begin version 5.3.8 対応漏れエラー対応
                VRList list = (VRList) getListGroupMap().getData(getTableType() + "-" + getFixedFormId());
                //// 2008/01/07 [Masahiko_Higuchi] edit - end
                // SQL_MODE_INSERTもしくはSQL_MODE_INSERT_TO_UPDATEの場合;
                if (new Integer(SQL_MODE_INSERT)
                        .equals(map.getData("SQL_MODE"))
                        || new Integer(SQL_MODE_INSERT_TO_UPDATE).equals(map
                                .getData("SQL_MODE"))) {
                    int selectRow = getFixedFormEditItemTable()
                            .getSelectedModelRow();
                    // 選択行を削除する。
                    list.remove(selectRow);
                    // 削除後に理想とするレコードを選択状態にする
                    getFixedFormEditItemTable()
                            .setSelectedSortedRowOnAfterDelete(selectRow);

                    //SQL_MODEがSQL_MODE_UPDATEだった場合
                } else if (new Integer(SQL_MODE_UPDATE).equals(map
                        .getData("SQL_MODE"))) {
                    // KEY：SQL_MODE VALUE：SQL_MODE_UPDATE_TO_DELETE
                    map.setData("SQL_MODE", new Integer(
                            SQL_MODE_UPDATE_TO_DELETE));
                    // SQL_MODE_UPDATE_TO_DELETE以外だった場合
                } else if(!new Integer(SQL_MODE_UPDATE_TO_DELETE).equals(map.getData("SQL_MODE"))){
                    map.setData("SQL_MODE", new Integer(SQL_MODE_DELETE));
                }

            }
            // SQL_MODE_DELETEの場合
            // 処理を終了する。
        }
        // 再描画処理
        getFixedFormEditItemTable().revalidate();
        getFixedFormEditItemTable().repaint();
        // dataChangeFlagに1を代入する。
        setDataChangeFlag(1);

    }

    /**
     * 「定型文削除取消処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void fixedFormEditCancelDeleteActionPerformed(ActionEvent e)
            throws Exception {
        VRMap map = (VRMap) getFixedFormEditItemTable()
                .getSelectedModelRowValue();
        // 選択行のレコードのSQL_MODEの値によって分岐する。
        // SQL_MODE_UPDATE_TO_DELETEの場合
        if (new Integer(SQL_MODE_UPDATE_TO_DELETE).equals(map
                .getData("SQL_MODE"))) {
            // 選択行のレコードに以下のKEY/VALUEを設定する。
            // KEY：SQL_MODE VALUE：SQL_MODE_UPDATE
            map.setData("SQL_MODE", new Integer(SQL_MODE_UPDATE));
        } else if (new Integer(SQL_MODE_DELETE).equals(map.getData("SQL_MODE"))) {
            // SQL_MODE_DELETEの場合
            // 選択行のレコードに以下のKEY/VALUEを設定する。
            map.setData("SQL_MODE", new Integer(SQL_MODE_DEFAULT));
            // KEY：SQL_MODE VALUE：SQL_MODE_DEFAULT
        }
        // 上記以外の場合
        // 処理を終了する。
        // 再描画処理
        getFixedFormEditItemTable().revalidate();
        getFixedFormEditItemTable().repaint();

    }

    /**
     * 「順番繰り上げ処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void fixedFormEditItemManipulateButtonUpActionPerformed(
            ActionEvent e) throws Exception {
        // 選択行がテーブルの1行目でない場合
        if (getFixedFormEditItemTable().getSelectedRow() <= 0) {
            return;
        }
        // コピーに使用するMap
        VRMap cloneMap = new VRHashMap();
        
        VRMap map = (VRMap) getFixedFormEditItemTable()
                .getSelectedModelRowValue();
        //現在選択中の分類に紐づく項目を取得
        VRList list = (VRList) getListGroupMap().getData(getTableType()+"-"
                +getFixedFormId());
        //選択行の１つ上のレコードを取得する。
        VRMap upRowMap = (VRMap) list.getData(getFixedFormEditItemTable()
                .getSelectedModelRow() - 1);
        
        // 選択行のレコードをコピーする。
        cloneMap = (VRMap) map.clone();
        // 選択行のレコードを選択行の1つ上のレコードで上書きする。
        map.putAll(upRowMap);
        // 選択行の1つ上のレコードを選択行のレコードで上書きする。
        upRowMap.putAll(cloneMap);
        // 画面を再描画する。
        getFixedFormEditItemTable().revalidate();
        getFixedFormEditItemTable().repaint();

        // 繰り上げたレコードを選択状態にする
        getFixedFormEditItemTable().setSelectedModelRow(
                getFixedFormEditItemTable().getSelectedModelRow() - 1);
        
        //dataChangeflgに1設定する
        setDataChangeFlag(1);

    }

    /**
     * 「順番繰り下げ処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void fixedFormEditItemManipulateButtonDownActionPerformed(
            ActionEvent e) throws Exception {
        // 選択行がテーブルの最終行でない場合
        VRList list = (VRList) getListGroupMap().getData(getTableType()+"-"
                +getFixedFormId());
        if (getFixedFormEditItemTable().getSelectedModelRow() >= list.size() - 1) {
            return;
        }
        
        VRMap cloneMap = new VRHashMap();
        //選択行のレコードを取得する
        VRMap map = (VRMap) getFixedFormEditItemTable()
                .getSelectedModelRowValue();

        // 選択行の1つしたのレコードを取得する。
        VRMap downRowMap = (VRMap) list.getData(getFixedFormEditItemTable()
                .getSelectedModelRow() + 1);

        // 選択行のレコードをコピーする。
        cloneMap = (VRMap) map.clone();
        // 選択行のレコードを選択行の1つ下のレコードで上書きする。
        map.putAll(downRowMap);
        // 選択行の1つ下のレコードを選択行のレコードで上書きする。
        downRowMap.putAll(cloneMap);
        
        getFixedFormEditItemTable().revalidate();
        getFixedFormEditItemTable().repaint();
        
        //繰り下げたレコードを選択状態にする。
        getFixedFormEditItemTable().setSelectedModelRow(
                getFixedFormEditItemTable().getSelectedModelRow() + 1);
        
        //dataChangeflgに1設定する
        setDataChangeFlag(1);
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        QkanSystemInformation.getInstance().setLoginProviderID("0000000001");
        ACFrame.debugStart(new ACAffairInfo(QO008.class.getName(), param));
    }

    // 内部関数

    /**
     * 「画面初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※画面初期化処理
        // ※ウィンドウタイトル・業務ボタンバーの設定
        // ウィンドウタイトル・業務ボタンバーを設定する。
        setAffairTitle(AFFAIR_ID, getButtons());

        setPASSIVE_CHECK_KEY(new ACPassiveKey("FIXED_FORM", new String[] {
                "TABLE_TYPE", "FIXED_FORM_ID", "CONTENT_KEY" }, new Format[] { null, null, null },
                "LAST_TIME", "LAST_TIME"));

        // ※テーブルモデルの設定
        // fixedFormGroupTableModelを生成する。
        ACTableModelAdapter fixedFormGroupTableModel = new ACTableModelAdapter();
        // 以下のカラムを設定する。
        // "FIXED_FORM_GROUP" "FIXED_FORM_TITLE"
        fixedFormGroupTableModel.setColumns(new String[] { "FIXED_FORM_GROUP",
                "FIXED_FORM_TITLE" });

        setFixedFormGroupTableModel(fixedFormGroupTableModel);
        // fixedFormTableに設定する。
        getFixedFormTable().setModel(getFixedFormGroupTableModel());
        // fixedFormTableModelを生成する。
        ACTableModelAdapter fixedFormTableModel = new ACTableModelAdapter();
        // 以下のカラムを設定する。
        // "SQL_MODE" "CONTENT"
        //[ID:0000612][Shin Fujihara] 2010/11 edit begin 2010年度対応
        //fixedFormTableModel.setColumns(new String[] { "SQL_MODE", "CONTENT" });
        fixedFormTableModel.setColumns(new String[] { "SQL_MODE", "SERVICE_CODE_KIND", "CONTENT" });
        ((QkanServiceKindNameFormat)getFixedFormEditItemTableColumn4().getFormat()).setMasterService(QkanCommon.getMasterService(getDBManager()));
        //[ID:0000612][Shin Fujihara] 2010/11 edit end 2010年度対応
        setFixedFormTableModel(fixedFormTableModel);
        // fixedFormEditItemTableに設定する。
        getFixedFormEditItemTable().setModel(getFixedFormTableModel());
        // ※状態初期設定
        // 状態を設定する。
        setState_UNEDITABLE();
        // ・状態ID：UNEDITABLE

    }

    /**
     * 「検索処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFind() throws Exception {
        // ※検索処理および画面展開
        // ※定型文分類情報取得
        // SQL文取得用VRMap sqlParamを定義する。
        VRMap sqlParam = new VRHashMap();
        // sqlParamに下記の値を設定する。
        // KEY：TABLE_TYPE VALUE：TABLE_TYPE_FIXED_FORM
        sqlParam.setData("TABLE_TYPE", new Integer(TABLE_TYPE_FIXED_FORM));
        // sqlParamを引数として、定型文分類情報取得用SQL文を取得する。
        // 取得したSQL文を実行し、定型文分類情報を取得する。
        VRList list = new VRArrayList();
        
        //医療系非表示対応 fujihara.shin 2009.1.15 edit start
        //list = (VRList) getDBManager().executeQuery(
        //        getSQL_GET_FIXED_FORM_GROUP(sqlParam));
        if (QkanCommon.isShowOldIryo()){
        	list = (VRList) getDBManager().executeQuery(getSQL_GET_FIXED_FORM_GROUP(sqlParam));
        } else {
        	list = (VRList) getDBManager().executeQuery(getSQL_GET_FIXED_FORM_GROUP_WITHOUT_IRYO(sqlParam));
        }
        //医療系非表示対応 fujihara.shin 2009.1.15 edit end
        
        // 取得した定型文分類情報をfixedFormGroupTableModelに設定する。
        // setAdaptee(fixedFormGroupTableModel, 取得したデータ);
        getFixedFormGroupTableModel().setAdaptee(list);

        getFixedFormTable().setModel(getFixedFormGroupTableModel());
        // ※定型文情報取得
        // 定型文情報取得用SQL文を取得する。
        // 取得したSQL文を実行し、定型文情報を取得し、fixedFormListに格納する。
        
        //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
        sqlParam.put("PROVIDER_ID", QkanSystemInformation.getInstance().getLoginProviderID());
        //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
        
        setFixedFormList(getDBManager().executeQuery(
                getSQL_GET_FIXED_FORM(sqlParam)));

        // 種類ごとにまとめたMapを生成する。
        createGroupMap(getFixedFormList());
        
        //定型文が空だった場合のエラートラップ
        VRMap map = new VRHashMap();
        for(int i=1; i<=2; i++){
            for(int j=1; j<=2; j++){
                String key = i+"-"+j;
                if(getListGroupMap().getData(key) == null){
                    //listGroupMapにマージする。
                    map.setData(key,new VRArrayList());
                }
            }
        }
        
        //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
        if(getListGroupMap().getData(PRINT_PROVIDER) == null){
        	map.setData(PRINT_PROVIDER, new VRArrayList());
        }
        //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
        
        getListGroupMap().putAll(map);
//        if(getListGroupMap().getData("1") == null|| getListGroupMap().getData("2") == null){
//            VRList list1 = new VRArrayList();
//            VRList list2 = new VRArrayList();
//            VRMap map = new VRHashMap();
//            //nullの場合は初期値を追加する。
//            if(getListGroupMap().getData("1") == null){
//                map.setData("1",list1);
//            }
//            //nullの場合は初期値を追加する。
//            if(getListGroupMap().getData("2") == null){
//                map.setData("2",list2);
//            }
//            //listGroupMapにマージする。
//            getListGroupMap().putAll(map);
//       }
        
        // fixedFormTableの1行目を選択した状態に設定する。
        getFixedFormTable().setSelectedSortedFirstRow();

        // パッシブキーをクリアする。
        getPassiveChecker().clearReservedPassive();
        // fixedFormListをパッシブキーに登録する。
        // reservedPassive(PASSIVE_CHECK_KEY, fixedFormList);
        getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
                getFixedFormList());

        
    }

    /**
     * 「入力チェック」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean isValidInput() throws Exception {
        // ※入力チェック
        // メッセージに渡す文字列格納用String msgParamを生成する。
        String msgParam = null;
        // ・fixedFormEditInputAndCompileTextBox
        if (ACTextUtilities.isNullText(getFixedFormEditInputAndCompileTextBox()
                .getText())) {
            // 未入力の場合（スペースのみの入力も含む）
            // msgParamに"入力・編集欄"を代入する。
            msgParam = "入力・編集欄";
            // エラーメッセージを表示する。
            QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(
                    msgParam);
            // ・メッセージID：ERROR_OF_NEED_CHECK_FOR_INPUT
            // エラーが発生したインスタンスにフォーカスを当てる
            getFixedFormEditInputAndCompileTextBox().requestFocus();
            // 戻り値としてfalseを返す。
            return false;
        }
        return true;
    }

    /**
     * 「保存処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doSave() throws Exception {
        // ※保存処理
        // ※パッシブチェック
        try {
            // トランザクションを開始する。
            getDBManager().beginTransaction();

            int tempId = 0;
            // パッシブタスクをクリアする。
            getPassiveChecker().clearPassiveTask();
            // パッシブタスクを登録する。
            getPassiveChecker().addPassiveDeleteTask(getPASSIVE_CHECK_KEY());
            // パッシブチェックを実行する。
            if (!getPassiveChecker().passiveCheck(getDBManager())) {
                //テーブルロック解除のためロールバック
                getDBManager().rollbackTransaction();
                // パッシブエラーがある場合
                // パッシブエラーメッセージを表示する。※メッセージID = ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                QkanMessageList.getInstance()
                        .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                // 処理を中断する。
                return false;
            }
            // SQL文を取得するため下記のKEY/VALUEを設定する
            // KEY:TABLE_TYPE VALUE:TABLE_TYPE_FIXED_FORM(定数）
            VRMap param = new VRHashMap();
            param.setData("TABLE_TYPE", new Integer(TABLE_TYPE_FIXED_FORM));
            // 定型文情報を削除するためのSQL文を取得する。
            // 取得したSQL文を実行する。
            getDBManager().executeUpdate(getSQL_DELETE_FIXED_FORM(param));

            java.util.Iterator it = getListGroupMap().entrySet().iterator();
            // キー名を取得
            Map.Entry key = null;
            // KEYをString型で格納
            String strKey = "";
            // Map内のKeyの数文ループ処理を行う
            while (it.hasNext()) {
                key = (Map.Entry) it.next();
                // KEYをString型で格納
                strKey = String.valueOf(key.getKey());
                // 取り出したリストを格納する変数を生成する。
                VRList groupList = new VRArrayList();
                // Map内からListをグループ毎のリストを取得する。
                groupList = (VRList) getListGroupMap().getData(strKey);
                // カウンター
                int fixedFormIdInsertCount1 = 0;
                int fixedFormIdInsertCount2 = 0;
                // 取り出したリストの件数分ループ処理を行う
                for (int j = 0; j < groupList.size(); j++) {
                    VRMap map = (VRMap) groupList.getData(j);
                    
                    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
                    String groupKey = String.valueOf(map.get("TABLE_TYPE")) + "-" +  String.valueOf(map.get("FIXED_FORM_ID"));
                    if (PRINT_PROVIDER.equals(groupKey)) {
                    	updatePrintProviderName(map);
                    	continue;
                    }
                    //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
                    
                    // 削除対象に指定されているレコードデータかチェックする。
                    // 削除対象のレコードではなかった場合
                    if (!new Integer(SQL_MODE_DELETE).equals(map
                            .getData("SQL_MODE"))
                            && !new Integer(SQL_MODE_UPDATE_TO_DELETE)
                                    .equals(map.getData("SQL_MODE"))) {
                        // 全額自己負担分のデータだった場合
                        if (new Integer(1).equals(map.getData("FIXED_FORM_ID"))) {
                            // 連番を振る
                            map.setData("CONTENT_KEY", new Integer(
                                    fixedFormIdInsertCount1));
                            map.setData("CONTENT_SORT", new Integer(
                                    fixedFormIdInsertCount1));
                            // カウンターを＋１
                            fixedFormIdInsertCount1++;

                            // その他費目のデータだった場合
                        } else {
                            // 連番を振る
                            map.setData("CONTENT_KEY", new Integer(
                                    fixedFormIdInsertCount2));
                            map.setData("CONTENT_SORT", new Integer(
                                    fixedFormIdInsertCount2));
                            // カウンターを＋１
                            fixedFormIdInsertCount2++;
                        }

                        // DBに登録する
                        getDBManager().executeUpdate(
                                getSQL_INSERT_FIXED_FORM(map));

                    }

                }
            }

            // ※コミット/ロールバック
            // 上記のSQL処理中にエラーがなかった場合
            // 処理をコミットする。
            getDBManager().commitTransaction();
            return true;
        } catch (Exception ex) {
            // 上記のSQL処理中にエラーがあった場合
            ex.printStackTrace();
            // 処理をロールバックする。
            getDBManager().rollbackTransaction();
            // 例外を投げる。
            throw ex;
            // 処理を終了する。
        }

    }
    
    //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
    //事業所名称更新処理
    private void updatePrintProviderName(VRMap map) throws Exception {
    	
    	switch (ACCastUtilities.toInt(map.getData("SQL_MODE"), Integer.MAX_VALUE)) {
    	case SQL_MODE_UPDATE:
    		getDBManager().executeUpdate(getSQL_UPDATE_FIXED_FORM_PROVIDER_NAME(map));
    		break;
    		
    	case SQL_MODE_DELETE:
    		getDBManager().executeUpdate(getSQL_DELETE_FIXED_FORM_PROVIDER_NAME(map));
    		break;
    	}
    	
    }
    //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応

    /**
     * グループごとにまとめたMapを作成します。
     * 
     * @param list
     * @return
     * @throws Exception
     */
    public void createGroupMap(VRList list) throws Exception {
        VRList adder;
        //新規にMapを生成する。
        VRMap initializeMap = new VRHashMap();
        setListGroupMap(initializeMap);
        for (int i = 0; i < list.size(); i++) {
            // リストから１つMapを取得
            VRMap map = (VRMap) list.getData(i);                        
            map.setData("SQL_MODE", new Integer(SQL_MODE_DEFAULT));
            
            String key = ACCastUtilities.toString(map.getData("TABLE_TYPE"))
                    + "-"
                    + ACCastUtilities.toString(map.getData("FIXED_FORM_ID"));
            // グループ化するキー名が既に存在しているかをチェックする
            if (VRBindPathParser.has(key, getListGroupMap())) {
                // 該当するリストを取得
                adder = (VRList) getListGroupMap().getData(key);
                // リストに追加
                adder.add(map);

            } else {
                // 新規にリストを生成
                adder = new VRArrayList();
                // リストに追加                
                adder.add(map);
                // 新規のキー名で格納
                getListGroupMap().setData(key, adder);
            }
            
            //[ID:0000612][Shin Fujihara] 2010/11 add begin 2010年度対応
            if (PRINT_PROVIDER.equals(key)) {
            	map.put("SERVICE_CODE_KIND", new Integer(ACCastUtilities.toInt(map.get("CONTENT_KEY"), 0) + 1000));
            }
            //[ID:0000612][Shin Fujihara] 2010/11 add end 2010年度対応
        }

    }
}
