
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
 * 作成日: 2006/06/01  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所一覧 (003)
 * プログラム 事業所一覧 (QO003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo003;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.sql.ACPassiveKey;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 事業所一覧イベント定義(QO003) 
 */
public abstract class QO003Event extends QO003SQL {
  /**
   * コンストラクタです。
   */
  public QO003Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getFind().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                findActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDetail().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                detailActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                deleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getProviderTable().addMouseListener(new MouseAdapter(){
        private boolean lockFlag = false;
        public void mouseClicked(MouseEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                if (e.getClickCount() == 2) {
                    providerTableMouseClicked(e);
                }
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getPrint().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「検索処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void findActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「事業所登録画面に遷移（更新）」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void detailActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「事業所登録画面に遷移（登録）」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void deleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「詳細画面遷移」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void providerTableMouseClicked(MouseEvent e) throws Exception;

  /**
   * 「印刷」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PROVIDER_PASSIVE_CHECK_KEY;
  private int providerDeleteFlg = 0;
  private String providerId;
  private String deleteErrorMsg;
  private VRMap affairMap = new VRHashMap();
  private VRMap staffMap = new VRHashMap();
  private VRList providerList = new VRArrayList();
  private ACTableModelAdapter providerTableModel;
  //getter/setter

  /**
   * PROVIDER_PASSIVE_CHECK_KEYを返します。
   * @return PROVIDER_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPROVIDER_PASSIVE_CHECK_KEY(){
    return PROVIDER_PASSIVE_CHECK_KEY;
  }
  /**
   * PROVIDER_PASSIVE_CHECK_KEYを設定します。
   * @param PROVIDER_PASSIVE_CHECK_KEY PROVIDER_PASSIVE_CHECK_KEY
   */
  protected void setPROVIDER_PASSIVE_CHECK_KEY(ACPassiveKey PROVIDER_PASSIVE_CHECK_KEY){
    this.PROVIDER_PASSIVE_CHECK_KEY = PROVIDER_PASSIVE_CHECK_KEY;
  }

  /**
   * providerDeleteFlgを返します。
   * @return providerDeleteFlg
   */
  protected int getProviderDeleteFlg(){
    return providerDeleteFlg;
  }
  /**
   * providerDeleteFlgを設定します。
   * @param providerDeleteFlg providerDeleteFlg
   */
  protected void setProviderDeleteFlg(int providerDeleteFlg){
    this.providerDeleteFlg = providerDeleteFlg;
  }

  /**
   * providerIdを返します。
   * @return providerId
   */
  protected String getProviderId(){
    return providerId;
  }
  /**
   * providerIdを設定します。
   * @param providerId providerId
   */
  protected void setProviderId(String providerId){
    this.providerId = providerId;
  }

  /**
   * deleteErrorMsgを返します。
   * @return deleteErrorMsg
   */
  protected String getDeleteErrorMsg(){
    return deleteErrorMsg;
  }
  /**
   * deleteErrorMsgを設定します。
   * @param deleteErrorMsg deleteErrorMsg
   */
  protected void setDeleteErrorMsg(String deleteErrorMsg){
    this.deleteErrorMsg = deleteErrorMsg;
  }

  /**
   * affairMapを返します。
   * @return affairMap
   */
  protected VRMap getAffairMap(){
    return affairMap;
  }
  /**
   * affairMapを設定します。
   * @param affairMap affairMap
   */
  protected void setAffairMap(VRMap affairMap){
    this.affairMap = affairMap;
  }

  /**
   * staffMapを返します。
   * @return staffMap
   */
  protected VRMap getStaffMap(){
    return staffMap;
  }
  /**
   * staffMapを設定します。
   * @param staffMap staffMap
   */
  protected void setStaffMap(VRMap staffMap){
    this.staffMap = staffMap;
  }

  /**
   * providerListを返します。
   * @return providerList
   */
  protected VRList getProviderList(){
    return providerList;
  }
  /**
   * providerListを設定します。
   * @param providerList providerList
   */
  protected void setProviderList(VRList providerList){
    this.providerList = providerList;
  }

  /**
   * providerTableModelを返します。
   * @return providerTableModel
   */
  protected ACTableModelAdapter getProviderTableModel(){
    return providerTableModel;
  }
  /**
   * providerTableModelを設定します。
   * @param providerTableModel providerTableModel
   */
  protected void setProviderTableModel(ACTableModelAdapter providerTableModel){
    this.providerTableModel = providerTableModel;
  }

  //内部関数

  /**
   * 「事業所情報取得処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「スタッフ情報を取得する」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindStaff() throws Exception;

  /**
   * 「削除処理可否確認処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doDeleteCheck() throws Exception;

  /**
   * 「削除処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doDelete() throws Exception;

  /**
   * 「検索処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindProvider() throws Exception;

  /**
   * 「検索条件退避」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void createFindState() throws Exception;

}
