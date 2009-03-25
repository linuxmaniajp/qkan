
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
 * 作成日: 2009/02/10  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防福祉用具貸与 (QS001144_H2104)
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
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanServiceUnitGetter;

/**
 * サービスパターン介護予防福祉用具貸与(QS001144_H2104) 
 */
public class QS001144_H2104 extends QS001144_H2104Event {
  /**
   * コンストラクタです。
   */
  public QS001144_H2104(){
  }

  //コンポーネントイベント

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001144_H2104.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
      // ※画面展開時の初期設定
      // 特地加算テキスト
      getWelfarePoint().setText("");
      getWelfareTokuchiPoint().setText("");
      // 中山間地域等小規模事業所加算テキスト
      getProviderAddMountainousAreaScalePoint().setText("");
      // 中山間地域等でのサービス提供加算テキスト
      getProviderAddMountainousAreaRafioPoint().setText("");
      // ※コンボアイテムの設定
      // ※準備
      // コンボアイテム設定用のレコード comboItemMap を生成する。
      VRMap comboItemMap = new VRHashMap();
      // ※設定
      // ※福祉用具リスト
      // コードマスタデータよりCODE_ID：47(用具）を取得する。
      // 取得した値を、comboItemMapの KEY : 1670101 の VALUE として設定する。
      comboItemMap.setData("1670101", QkanCommon.getArrayFromMasterCode(47,
              "1670101"));
      // ※展開
      // 自身(this)にcomboItemMapに設定する。
      getThis().setModelSource(comboItemMap);
      // コンボアイテムを展開する。
      getThis().bindModelSource();
      // ※選択項目の初期設定
      // ※準備
      // 初期選択設定用のレコード defaultMap を生成する。
      VRMap defaultMap = new VRHashMap();
      // ※設定
      // ※展開
      // 自身(this)にdefaultMapに設定する。
      getThis().setSource(defaultMap);
      // 初期選択項目を展開する。
      getThis().bindSource();

  }

  /**
   * 「事業所コンボ変更時関数」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void providerSelected(VRMap provider) throws Exception{
      // ※事業所コンボ変更時に呼ぶ関数
      // 選択事業所情報がnullでない場合
      if (provider != null) {
          // ※以下の内容詳細項目は、選択事業所の値を設定する。
          // ※準備
          // 事業所連動用のレコード defaultMap を生成する。
          VRMap defaultMap = new VRHashMap();
          // ※設定
          // ※展開
          // 自身(this)にdefaultMapに設定する。
          getThis().setSource(defaultMap);
          // 初期選択項目を展開する。
          getThis().bindSource();
          // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
          // 画面状態を変更する。
          checkState();
      }
  }

  /**
   * 「入力内容の不備を検査」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public VRMap getValidData() throws Exception{
      // ※入力内容に不備がないかをチェックし、サービスデータを返す。
      // ※返却用のレコード(data)を生成
      VRMap data = new VRHashMap();
      // 自身(this)のソースとして生成レコードを設定する。
      getThis().setSource(data);
      // 自身(this)のapplySourceを呼び出してデータを収集する。
      getThis().applySource();
      // ※返却用レコードから不要なキーを除去
      // 用具コンボ(welfareTools)が未選択の場合
      if (!getWelfareTools().isSelected()) {
          // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          // nullを返す。
          return null;
      }
      // 単位数テキスト(welfarePoint)が空欄の場合
      if (ACTextUtilities.isNullText(getWelfarePoint().getText())) {
          // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          // nullを返す。
          return null;
      }
      // 返却用レコードから、特地加算テキスト(welfareTokuchiPoint)のbindPathを除去する。
      QkanCommon.removeDisabledBindPath(getThis(), data);
      // 問題なければ返却用レコード(data)を返す。
      // 特別地域加算テキストの有効状態をチェックする。
      if(getWelfareTokuchiPoint().isEnabled()){
          String val = getWelfareTokuchiPoint().getText();
          // 特別地域であり尚且つテキスト未入力もしくは0が入力されている場合
          if(ACTextUtilities.isNullText(val)||ACCastUtilities.toInt(val)==0){
              // キーを削っておく
              data.remove(getWelfareTokuchiPoint().getBindPath());
          }
      }
      
      // 中山間等地域
      if (getProviderAddMountainousAreaScalePoint().isEnabled()) {
          // 中山間加算テキスト(getProviderAddMountainousAreaScalePoint)が有効の場合
          String val = getProviderAddMountainousAreaScalePoint().getText();
          if (ACTextUtilities.isNullText(val) || (ACCastUtilities.toInt(val,0) == 0)) {
              // 中山間加算テキスト(getProviderAddMountainousAreaScalePoint)が空欄か値が0の場合
              // 返却用レコードから、中山間加算テキスト(getProviderAddMountainousAreaRafioPoint)のbindPathを除去する。
              data.remove(getProviderAddMountainousAreaScalePoint().getBindPath());
          }
      }
      
      // 中山間地域等でのサービス提供
      String val = getProviderAddMountainousAreaRafioPoint().getText();
      if (ACTextUtilities.isNullText(val) || (ACCastUtilities.toInt(val,0) == 0)) {
          data.remove(getProviderAddMountainousAreaRafioPoint().getBindPath());
      }
      
      return data;
  }

  /**
   * 「事業所情報の必要性を取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean isUseProvider() throws Exception{
      // ※事業所情報が必要なサービスであるかを返す。
      // trueを返す。
      return true;
  }

  /**
   * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
      // ※開始時刻入力用のコンボを返す。
      // 関数の返り値として開始時間コンボを返す。
      return null;
  }

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getEndTimeCombo() throws Exception{
      // ※終了時刻入力用のコンボを返す。
      // 関数の返り値として終了時間コンボを返す。
      return null;
  }

  /**
   * 「画面状態制御」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void checkState() throws Exception{
      // ※画面状態制御処理
      // ※事業所連動
      // 内部変数 providerInfoMap を生成する。
      VRMap providerInfoMap = new VRHashMap();
      // 事業所パネル情報を取得し providerInfoMap に格納する。
      // getSelectedProvider();
      providerInfoMap = getSelectedProvider();
      // providerInfoMapが null かチェックする。
      if (providerInfoMap != null) {
          // null（事業所未選択）だった場合
          // 何も行わない。
          // null以外だった場合
          // providerInfoMap から KEY：SPECIAL_AREA_FLAG の値を取得する。
          if (ACCastUtilities.toInt(VRBindPathParser.get("SPECIAL_AREA_FLAG",
                  providerInfoMap)) == 1) {
              // 取り出した値が1だった場合
              // 画面状態を変更する
              setState_INVALID_ADD_SPECIAL_AREA();
          } else {
              // 1以外の場合
              // 画面状態を変更する
              setState_VALID_ADD_SPECIAL_AREA();
          }
          
          // 中山間地域事業所であるかの判定ロジック
          String providerID = ACCastUtilities.toString(((VRMap) providerInfoMap)
                  .getData("PROVIDER_ID"), "");
          // 介護予防福祉用具貸与
          VRList serviceInfo = QkanCommon.getProviderServiceDetail(
                  getDBManager(), providerID, ACCastUtilities.toInt("16711", 0));

          if(serviceInfo != null && serviceInfo.getData(0) instanceof VRMap) {
              VRMap providerServiceInfo = (VRMap)serviceInfo.getData(0);
              // 中山間地域等の小規模事業所である場合
              if(CareServiceCommon.isMountainousArea(providerServiceInfo)) {
                  setState_VALID_ADD_MOUNTAINOUS_AREA();
              } else {
                  setState_INVALID_ADD_MOUNTAINOUS_AREA();
              }
              
          } else {
              setState_INVALID_ADD_MOUNTAINOUS_AREA();
              
          }              
          
      }

  }
  /**
   * 「サービス法改正区分取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public int getServiceLowVersion() throws Exception {
      //※このサービスパネルが扱うサービスの法改正区分(M_DETAIL.SYSTEM_BIND_PATH=14)を返す。 
      //QkanConstants.SERVICE_LOW_VERSION_H2104 を返す。
      return QkanConstants.SERVICE_LOW_VERSION_H2104;
  }

  /**
     * 「中山間地域等単位数検査」に関する処理を行ないます。
     * 
     * @param checkMode int
     * @throws Exception 処理例外
     * @return boolean
     */
    public boolean checkMountainousPoint(int checkMode) throws Exception {
        // ※中山間地域等の単位数が、法定上限を超えていないか検査する。

        //
        if (getSkipCheckMountainousPoint()) {
            return true;
        }

        // 警告状態変数(warningState)を定義し、0で初期化する。
        int warningState = 0;

        // 中山間地域等小規模事業所加算の超過を検査する。
        if (getProviderAddMountainousAreaScalePoint().isEnabled()
                && !ACTextUtilities.isNullText(getWelfarePoint().getText())
                && !ACTextUtilities
                        .isNullText(getProviderAddMountainousAreaScalePoint()
                                .getText())) {
            // 中山間地域等小規模事業所加算(providerAddMountainousAreaScalePoint)が無効でなく、かつ
            // 単位数(welfarePoint)および中山間地域等小規模事業所加算(providerAddMountainousAreaScalePoint)の値が空でない場合
            if (ACCastUtilities.toInt(getProviderAddMountainousAreaScalePoint()
                    .getText()) > (ACCastUtilities.toInt(getWelfarePoint()
                    .getText()) * 2 / 3)) {
                // 中山間地域等小規模事業所加算(providerAddMountainousAreaScalePoint)の値が
                // 単位数(welfarePoint)の値の3分の2を超えている場合
                // 警告状態変数(warningState)に1を加算する。
                warningState += 1;
            }
        }

        // 中山間地域等でのサービス提供加算の超過を検査する。
        if (getProviderAddMountainousAreaRafioPoint().isEnabled()
                && !ACTextUtilities.isNullText(getWelfarePoint().getText())
                && !ACTextUtilities
                        .isNullText(getProviderAddMountainousAreaRafioPoint()
                                .getText())) {
            // 中山間地域等でのサービス提供加算(providerAddMountainousAreaRafioPoint)が無効でなく、かつ
            // 単位数(welfarePoint)および中山間地域等でのサービス提供加算(providerAddMountainousAreaRafioPoint)の値が空でない場合
            if (ACCastUtilities.toInt(getProviderAddMountainousAreaRafioPoint()
                    .getText()) > (ACCastUtilities.toInt(getWelfarePoint()
                    .getText()) * 1 / 3)) {
                // 中山間地域等でのサービス提供加算(providerAddMountainousAreaRafioPoint)の値が
                // 単位数(welfarePoint)の値の3分の1を超えている場合
                // 警告状態変数(warningState)に2を加算する。
                warningState += 2;
            }
        }

        // 上限超過検査結果をもとに、警告メッセージ等を表示する。
        // 警告状態変数(warningState)の値を基準に、以下のとおり分岐する。
        switch (warningState) {
        case 0:
            // 値が0の場合(警告なし)
            // 中山間地域等小規模事業所加算(providerAddMountainousAreaScalePoint)のコンテナ部分を通常表示にする。
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // 中山間地域等でのサービス提供加算(providerAddMountainousAreaRafioPoint)のコンテナ部分を通常表示にする。
            break;
        case 1:
            // 値が1の場合(中山間地域等小規模事業所加算のみ警告)
            // 中山間地域等小規模事業所加算(providerAddMountainousAreaScalePoint)のコンテナ部分を警告表示にする。
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            // 中山間地域等でのサービス提供加算(providerAddMountainousAreaRafioPoint)のコンテナ部分を通常表示にする。
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // 引数checkModeが0または1の場合
            switch (checkMode) {
            case 0:
            case 1:
                // クラス変数skipCheckMountainousPointに真(true)を代入する。
                setSkipCheckMountainousPoint(true);
                // 中山間地域等小規模事業所加算が超過している旨、警告を表示する。
                // ※メッセージID = QS001_WARNING_OF_MOUNTAINOUS_AREA
                QkanMessageList.getInstance()
                        .QS001_WARNING_OF_MOUNTAINOUS_AREA("中山間地域等小規模事業所加算",
                                "3分の2");
                // クラス変数skipCheckMountainousPointに偽(false)を代入する。
                setSkipCheckMountainousPoint(false);
                break;
            }
            // 関数の戻り値として偽を返す。
            return false;
        case 2:
            // 値が2の場合(中山間地域等でのサービス提供加算のみ警告)
            // 中山間地域等小規模事業所加算(providerAddMountainousAreaScalePoint)のコンテナ部分を通常表示にする。
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            // 中山間地域等でのサービス提供加算(providerAddMountainousAreaRafioPoint)のコンテナ部分を警告表示にする。
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // 引数checkModeが0または2の場合
            switch (checkMode) {
            case 0:
            case 2:
                // クラス変数skipCheckMountainousPointに真(true)を代入する。
                setSkipCheckMountainousPoint(true);
                // 中山間地域等でのサービス提供加算が超過している旨、警告を表示する。
                // ※メッセージID = QS001_WARNING_OF_MOUNTAINOUS_AREA
                QkanMessageList.getInstance()
                        .QS001_WARNING_OF_MOUNTAINOUS_AREA("中山間地域等でのサービス提供加算",
                                "3分の1");
                // クラス変数skipCheckMountainousPointに偽(false)を代入する。
                setSkipCheckMountainousPoint(false);
                break;
            }
            // 関数の戻り値として偽を返す。
            return false;
        case 3:
            // 値が3の場合(中山間地域等小規模事業所加算と中山間地域等でのサービス提供加算に警告)
            // 中山間地域等小規模事業所加算(providerAddMountainousAreaScalePoint)のコンテナ部分を警告表示にする。
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            // 中山間地域等でのサービス提供加算(providerAddMountainousAreaRafioPoint)のコンテナ部分を警告表示にする。
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // クラス変数skipCheckMountainousPointに真(true)を代入する。
            setSkipCheckMountainousPoint(true);
            // 中山間地域等小規模事業所加算および中山間地域等でのサービス提供加算が超過している旨、警告を表示する。
            // ※メッセージID = QS001_WARNING_OF_MOUNTAINOUS_AREA_ALL
            QkanMessageList.getInstance()
                    .QS001_WARNING_OF_MOUNTAINOUS_AREA_ALL();
            // クラス変数skipCheckMountainousPointに偽(false)を代入する。
            setSkipCheckMountainousPoint(false);
            // 関数の戻り値として偽を返す。
            return false;
        }
        // 関数の戻り値として真を返す。

        return true;
    }

    /**
     * 「中山間地域単位上限検査」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void providerAddMountainousAreaRafioPointFocusLost(FocusEvent e)
            throws Exception {
        // ※単位数のフォーカス喪失イベント
        // 関数「中山間地域等単位数検査」をcheckMode=2で呼び出す。
        checkMountainousPoint(2);
    }

    /**
     * 「中山間地域単位上限検査」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void providerAddMountainousAreaScalePointFocusLost(FocusEvent e)
            throws Exception {
        // ※単位数のフォーカス喪失イベント
        // 関数「中山間地域等単位数検査」をcheckMode=1で呼び出す。
        checkMountainousPoint(1);
    }

    /**
     * 「中山間地域単位上限検査」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void welfarePointFocusLost(FocusEvent e) throws Exception {
        // ※単位数のフォーカス喪失イベント
        // 関数「中山間地域等単位数検査」をcheckMode=0で呼び出す。
        checkMountainousPoint(0);
    }

}
