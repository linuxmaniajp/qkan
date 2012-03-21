
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
 * 作成日: 2006/04/07  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (004)
 * プログラム 特定治療費編集画面 (QP004001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * 特定治療費編集画面(QP004001) 
 */
public class QP004001 extends QP004001Event {
  /**
   * コンストラクタです。
   */
  public QP004001(){
  }

  //コンポーネントイベント

  /**
   * 「クリア」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void medicalClearActionPerformed(ActionEvent e) throws Exception{
    // 編集領域をクリアする。
      getRecordEditors().setSource((VRBindSource)getRecordEditors().createSource());
      getRecordEditors().bindSource();
  }

  /**
   * 「追加」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void medicalInsertActionPerformed(ActionEvent e) throws Exception{
    // 編集領域の情報を一覧に追加する。
      VRMap param = new VRHashMap();
      getRecordEditors().setSource(param);
      getRecordEditors().applySource();
      getEditMedicalInfos().add(param);
      getMedicalTable().setSelectedSortedLastRow();
  }

  /**
   * 「書替」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void medicalUpdateActionPerformed(ActionEvent e) throws Exception{
    // 編集領域の情報で一覧の選択項目を書き換える。
      if(getMedicalTable().isSelected()){
          getRecordEditors().applySource();
          getMedicalTable().invalidate();
          getMedicalTable().repaint();
      }
  }

  /**
   * 「削除」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void medicalDeleteActionPerformed(ActionEvent e) throws Exception{
    // 一覧の選択項目を削除する。
      if(getMedicalTable().isSelected()){
          int row=getMedicalTable().getSelectedSortedRow();
          getEditMedicalInfos().remove(getMedicalTable().getSelectedModelRow());
          getMedicalTable().setSelectedSortedRowOnAfterDelete(row);
      }
  }

  /**
   * 「OK」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void apllyActionPerformed(ActionEvent e) throws Exception{
    // 設定情報を集計し画面を閉じる。
      setApplied(true);
      
      //集計
      
      
      
      //転記
      getMedicalInfos().clear();
      getMedicalInfos().addAll(getEditMedicalInfos());
      
      dispose();
  }

  /**
   * 「キャンセル」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // 画面を閉じる。
      dispose();
  }

  public static void main(String[] args) {
      // デフォルトデバッグ起動
        try {
            ACFrame.setVRLookAndFeel();
            ACFrame.getInstance().setFrameEventProcesser(
                    new QkanFrameEventProcesser());
            QkanCommon.debugInitialize();
            new QP004001().showModal(new VRArrayList(), new VRArrayList(),new VRArrayList());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
  }

  //内部関数

  /**
   * 「画面展開」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean showModal(VRList medicalInfos, VRList basicInfos, VRList totalInfos) throws Exception{
    // 画面を表示する。
      setMedicalInfos(medicalInfos);
      setBasicInfos(basicInfos);
      setTotalInfos(totalInfos);

      
      //基本情報の表示
      
      
      
      //転記
      Iterator it=getMedicalInfos().iterator();
      while(it.hasNext()){
          getEditMedicalInfos().add(((VRMap)it.next()).clone());
      }
      
      ACTableModelAdapter adapt=new ACTableModelAdapter(getEditMedicalInfos(), 
              new String[]{
          "401008",
          "401009",
          "401010",
          "401011",
          "401012",
          "401013",
          "401015",
          "401017",
      });
      getMedicalTable().setModel(adapt);
      
      if(getEditMedicalInfos().isEmpty()){
          setState_RECORD_DESELECTED();
      }else{
          getMedicalTable().setSelectedSortedFirstRow();
      }
      setVisible(true);
      return getApplied();
  }

  protected void medicalTableSelectionChanged(ListSelectionEvent e) throws Exception {
    //選択状態に応じてレコードの編集ボタンの有効状態を変更する。
    if(e.getValueIsAdjusting()){
        return;
    }
    if(getMedicalTable().isSelected()){
        setState_RECORD_SELECTED();
        getRecordEditors().setSource((VRBindSource)getEditMedicalInfos().get(getMedicalTable().getSelectedModelRow()));
        getRecordEditors().bindSource();
    }else{
        setState_RECORD_DESELECTED();
    }
}

}
