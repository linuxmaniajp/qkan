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
 * 作成日: 2007/12/14  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001033)
 * プログラム サービス予定 (QS001033)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

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
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
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
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * サービス予定(QS001033)
 */
public class QS001033 extends QS001033Event {
    /**
     * コンストラクタです。
     */
    public QS001033() {
    }

    // コンポーネントイベント

    /**
     * 「okボタン押下時の処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void okButtonActionPerformed(ActionEvent e) throws Exception {
        // ■ＯＫボタン押下時の処理
        if (!checkInputData()) {
            // afterServiceTextにフォーカスを当てる
            getAfterServiceText().requestFocus();
            return;
        }
        // VRMap data を生成する。
        VRMap data = new VRHashMap();
        // contents に data を設定する。
        getContents().setSource(data);
        // 画面上の値を収集する。
        getContents().applySource();
        // changeData に data 内のＫＥＹ：11を追加する。
        if (data != null && data.containsKey("11")) {
            getChangeData().setData("11", data.getData("11"));
        }
        setEntryType(true);
        // 画面を破棄する。
        dispose();
    }

    /**
     * 「キャンセルボタン押下時の処理」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void cancelButtonActionPerformed(ActionEvent e) throws Exception {
        // ■キャンセルボタン押下時の処理
        // 画面を破棄する。
        dispose();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001033.class.getName(), param));
    }

    // 内部関数

    /**
     * 「画面展開」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void showModel(VRMap baseData, ACDBManager dbm) throws Exception {
        // ■画面展開時の処理
        if (baseData == null || dbm == null) {
            // 万が一Nullの場合は画面は起動させない
            return;
        }
        setAffairTitle("QS001033");
        // 渡り変数の baseData をchangeDataに退避する。
        setChangeData(baseData);
        // 背景色の変更クラスを生成
        setAfterServiceTextBackgroundChanger(new ACFollowContainerFormatEventListener());
        getAfterServiceTextBackgroundChanger().formatValid(
                new VRFormatEvent(getAfterServiceText(), null, null));
        // entryType に false を設定する。
        setEntryType(false);
        /*
        // String serviceKind を生成する。
        String serviceKind = null;
        // VRMap bindMap を生成する。
        VRMap bindMap = new VRHashMap();
        // serviceKind にbaseData 内のＫＥＹ：SYSTEM_SERVICE_KIND_DETAILの値を取得する。
        serviceKind = ACCastUtilities.toString(baseData
                .getData("SYSTEM_SERVICE_KIND_DETAIL"), "");
        // object service にserviceKindに一致するマスターデータを取得する。
        Object service = null;
        service = QkanCommon.getMasterService(getDBManager());
        // serviceがＭａｐである場合
        if (service instanceof VRMap) {
            VRMap serviceDetail = new VRHashMap();
            // 一旦取得
            Object obj = ((VRMap) service).getData(ACCastUtilities
                    .toInteger(serviceKind));
            // Mapである場合
            if (obj instanceof VRMap) {
                serviceDetail = (VRMap) obj;
                bindMap.setData("11", getChangeData().getData("11"));
                // contents にbindMap を設定する。
                getContents().setSource(bindMap);
                // 設定したデータを画面に展開する
                getContents().bindSource();
            }
        }
        */

        this.setVisible(true);

    }
    /**
     * データ入力チェック処理
     */
    public boolean checkInputData() throws Exception {
        // ■入力チェック処理
        // afterServiceTextに値が入力されているかチェックする。
        if (ACTextUtilities.isNullText(getAfterServiceText())) {
            // 値が入力されていない場合            
            // エラーメッセージを表示する。    
            QkanMessageList.getInstance().QS001_ERROR_OF_SERVICE_PATTERN_NAME();
            // 戻り値として　false を返す。   
            return false;
        }
        //    値が入力されている場合         
        //        戻り値として　True を返す。        

        return true;
    }
    /**
     * ロストフォーカス時の処理
     */
    protected void afterServiceTextFocusLost(FocusEvent e) throws Exception {
        if(ACTextUtilities.isNullText(getAfterServiceText())){
            // 異常
            getAfterServiceTextBackgroundChanger().changeInvalidContainer();
        }else{
            // 正常
            getAfterServiceTextBackgroundChanger().changeValidContainer();
        }
        
    }
    /**
     * パターン名称の変更が行われたかを返します。
     * 
     * @return True:名称変更有 False:名称変更無し
     */
    public boolean isPatternNameChange() throws Exception {
        return getEntryType();
    }

}
