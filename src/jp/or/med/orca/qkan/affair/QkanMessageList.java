
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
 * 作成日: 2008/01/15  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair;
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
/**
 * メッセージ一覧(QkanMessageList) 
 */
public class QkanMessageList {
  private static QkanMessageList singleton;
  /**
   * コンストラクタです。
   * singleton pattern
   */
  private QkanMessageList() {
  }
  /**
   * インスタンスを返します。
   * @return インスタンス
   */
  public static QkanMessageList getInstance(){
    if(singleton==null){
      singleton = new QkanMessageList();
    }
    return singleton;
  }

  /**
   * メッセージ「入力内容を登録しますか？」を表示します。
   * <p>
   * 戻るボタン押下時
   * 登録モード
   * スナップショットチェックに引っかかった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_INSERT_ON_MODIFIED() throws Exception{

    return ACMessageBox.showYesNoCancel("入力内容を登録しますか？", "登録して戻る(I)", 'I', "破棄して戻る(R)", 'R', ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「変更されています。＜改行＞更新しますか？」を表示します。
   * <p>
   * 戻るボタン押下時
   * 更新モード
   * スナップショットチェックに引っかかった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_UPDATE_ON_MODIFIED() throws Exception{

    return ACMessageBox.showYesNoCancel("変更されています。" + ACConstants.LINE_SEPARATOR + "更新しますか？", "更新して戻る(U)", 'U', "破棄して戻る(R)", 'R', ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「変更された内容は破棄されます。＜改行＞終了してもよろしいですか？」を表示します。
   * <p>
   * ×ボタン押下時
   * スナップショットチェックに引っかかった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_CLOSE_ON_MODIFIED() throws Exception{

    return ACMessageBox.show("変更された内容は破棄されます。" + ACConstants.LINE_SEPARATOR + "終了してもよろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「同時に同じデータを編集しようとしました。＜改行＞妥当性確保の為、処理を中止します。」を表示します。
   * <p>
   * パッシブチェックでエラーが発生した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_PASSIVE_CHECK_ON_UPDATE() throws Exception{

    return ACMessageBox.show("同時に同じデータを編集しようとしました。" + ACConstants.LINE_SEPARATOR + "妥当性確保の為、処理を中止します。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[項目名]を入力してください。」を表示します。
   * <p>
   * 入力チェック
   * 必須入力項目が未入力の場合
   * [項目名]は項目名
   * 　→[項目名] = 利用者氏名
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_NEED_CHECK_FOR_INPUT(VRMap param) throws Exception {
    return ERROR_OF_NEED_CHECK_FOR_INPUT(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「[項目名]を入力してください。」を表示します。
   * <p>
   * 入力チェック
   * 必須入力項目が未入力の場合
   * [項目名]は項目名
   * 　→[項目名] = 利用者氏名
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_NEED_CHECK_FOR_INPUT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("を入力してください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[項目名]を選択してください。」を表示します。
   * <p>
   * 入力チェック
   * 必須選択項目が未選択の場合
   * [項目名]は項目名
   * 　→[項目名] = 要介護認定
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_NEED_CHECK_FOR_SELECT(VRMap param) throws Exception {
    return ERROR_OF_NEED_CHECK_FOR_SELECT(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「[項目名]を選択してください。」を表示します。
   * <p>
   * 入力チェック
   * 必須選択項目が未選択の場合
   * [項目名]は項目名
   * 　→[項目名] = 要介護認定
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_NEED_CHECK_FOR_SELECT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("を選択してください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[項目名]日付に誤りがあります。」を表示します。
   * <p>
   * 入力チェック
   * 日付項目に不正な値が入力されている場合
   * [項目名]は項目名を表示する場合に使用
   * 　→例：[項目名] = 生年月日の
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_WRONG_DATE(VRMap param) throws Exception {
    return ERROR_OF_WRONG_DATE(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「[項目名]日付に誤りがあります。」を表示します。
   * <p>
   * 入力チェック
   * 日付項目に不正な値が入力されている場合
   * [項目名]は項目名を表示する場合に使用
   * 　→例：[項目名] = 生年月日の
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_WRONG_DATE(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("日付に誤りがあります。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[項目名]未来の日付が入力されています。」を表示します。
   * <p>
   * 入力チェック
   * 未来日付が禁止されている日付項目に、未来日付が入力されている場合
   * 　→例：[項目名] = 作成年月日に
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_FUTURE_DATE(VRMap param) throws Exception {
    return ERROR_OF_FUTURE_DATE(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「[項目名]未来の日付が入力されています。」を表示します。
   * <p>
   * 入力チェック
   * 未来日付が禁止されている日付項目に、未来日付が入力されている場合
   * 　→例：[項目名] = 作成年月日に
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_FUTURE_DATE(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("未来の日付が入力されています。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[項目名][開始日] ≦ [終了日] としてください。」を表示します。
   * <p>
   * 入力チェック
   * 日付項目の前後関係が誤っている場合
   * [項目名]は項目名を表示する場合に使用
   * 　→例：[項目名] = 有効期間は
   * 　　　　　[開始日] = 開始
   * 　　　　　[終了日] = 終了
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_GREATER_DATE_RELATION(VRMap param) throws Exception {
    return ERROR_OF_GREATER_DATE_RELATION(

      VRBindPathParser.get("項目名", param)

      , VRBindPathParser.get("開始日", param)

      , VRBindPathParser.get("終了日", param)

           );
  }
  /**
   * メッセージ「[項目名][開始日] ≦ [終了日] としてください。」を表示します。
   * <p>
   * 入力チェック
   * 日付項目の前後関係が誤っている場合
   * [項目名]は項目名を表示する場合に使用
   * 　→例：[項目名] = 有効期間は
   * 　　　　　[開始日] = 開始
   * 　　　　　[終了日] = 終了
   * </p>
   * @param arg1 項目名
   * @param arg2 開始日
   * @param arg3 終了日
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_GREATER_DATE_RELATION(

      Object arg1
      , Object arg2
      , Object arg3
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append(arg2);

    sb.append(" ≦ ");

    sb.append(arg3);

    sb.append(" としてください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[項目名][開始日] ≧ [終了日] としてください。」を表示します。
   * <p>
   * 入力チェック
   * 日付項目の前後関係が誤っている場合
   * %S%は項目名を表示する場合に使用
   * 　→例：
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_LESSER_DATE_RELATION(VRMap param) throws Exception {
    return ERROR_OF_LESSER_DATE_RELATION(

      VRBindPathParser.get("項目名", param)

      , VRBindPathParser.get("開始日", param)

      , VRBindPathParser.get("終了日", param)

           );
  }
  /**
   * メッセージ「[項目名][開始日] ≧ [終了日] としてください。」を表示します。
   * <p>
   * 入力チェック
   * 日付項目の前後関係が誤っている場合
   * %S%は項目名を表示する場合に使用
   * 　→例：
   * </p>
   * @param arg1 項目名
   * @param arg2 開始日
   * @param arg3 終了日
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_LESSER_DATE_RELATION(

      Object arg1
      , Object arg2
      , Object arg3
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append(arg2);

    sb.append(" ≧ ");

    sb.append(arg3);

    sb.append(" としてください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「同一と思われる[項目名]が既に登録されています。＜改行＞登録しますか？」を表示します。
   * <p>
   * 保存前の確認
   * 同一のデータの登録は許すが、念のため確認する場合
   * 　→例：%S% = 利用者
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_SAME_DATA_FOUND(VRMap param) throws Exception {
    return WARNING_OF_SAME_DATA_FOUND(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「同一と思われる[項目名]が既に登録されています。＜改行＞登録しますか？」を表示します。
   * <p>
   * 保存前の確認
   * 同一のデータの登録は許すが、念のため確認する場合
   * 　→例：%S% = 利用者
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_SAME_DATA_FOUND(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("同一と思われる");

    sb.append(arg1);

    sb.append("が既に登録されています。" + ACConstants.LINE_SEPARATOR + "登録しますか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「同一の[項目名]が既に登録されています。」を表示します。
   * <p>
   * 保存前の確認
   * 同一のデータの登録を許さない場合
   * 　→例：%S% = 保険者
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_SAME_DATA_FOUND(VRMap param) throws Exception {
    return ERROR_OF_SAME_DATA_FOUND(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「同一の[項目名]が既に登録されています。」を表示します。
   * <p>
   * 保存前の確認
   * 同一のデータの登録を許さない場合
   * 　→例：%S% = 保険者
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_SAME_DATA_FOUND(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("同一の");

    sb.append(arg1);

    sb.append("が既に登録されています。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「選択したデータを削除します。＜改行＞よろしいですか？」を表示します。
   * <p>
   * 削除前の確認
   * 削除前にメッセージを出すことは必須
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DELETE_SELECTION() throws Exception{

    return ACMessageBox.show("選択したデータを削除します。" + ACConstants.LINE_SEPARATOR + "よろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「[項目名]を削除します。＜改行＞よろしいですか？」を表示します。
   * <p>
   * 削除前の確認
   * 削除前にメッセージを出すことは必須
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DELETE(VRMap param) throws Exception {
    return WARNING_OF_DELETE(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「[項目名]を削除します。＜改行＞よろしいですか？」を表示します。
   * <p>
   * 削除前の確認
   * 削除前にメッセージを出すことは必須
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DELETE(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("を削除します。" + ACConstants.LINE_SEPARATOR + "よろしいですか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「選択したデータを印刷します。＜改行＞よろしいですか？」を表示します。
   * <p>
   * 印刷前の確認
   * 印刷前にメッセージを出すことは任意
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_PRINT_SELECTION() throws Exception{

    return ACMessageBox.show("選択したデータを印刷します。" + ACConstants.LINE_SEPARATOR + "よろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「[項目名]を印刷します。＜改行＞よろしいですか？」を表示します。
   * <p>
   * 印刷前の確認
   * 印刷前にメッセージを出すことは任意
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_PRINT(VRMap param) throws Exception {
    return WARNING_OF_PRINT(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「[項目名]を印刷します。＜改行＞よろしいですか？」を表示します。
   * <p>
   * 印刷前の確認
   * 印刷前にメッセージを出すことは任意
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_PRINT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("を印刷します。" + ACConstants.LINE_SEPARATOR + "よろしいですか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「登録しました。」を表示します。
   * <p>
   * 処理完了通知
   * 登録(INSERT)が正常終了した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int INSERT_SUCCESSED() throws Exception{

    return ACMessageBox.show("登録しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「更新しました。」を表示します。
   * <p>
   * 処理完了通知
   * 更新(UPDATE)が正常終了した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int UPDATE_SUCCESSED() throws Exception{

    return ACMessageBox.show("更新しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「削除しました。」を表示します。
   * <p>
   * 処理完了通知
   * 削除(DELTE)が正常終了した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int DELETE_SUCCESSED() throws Exception{

    return ACMessageBox.show("削除しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「条件に合致する「[項目名]」が見つかりませんでした。」を表示します。
   * <p>
   * 検索業務
   * 検索結果が0件の場合
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int NOT_FOUND(VRMap param) throws Exception {
    return NOT_FOUND(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「条件に合致する「[項目名]」が見つかりませんでした。」を表示します。
   * <p>
   * 検索業務
   * 検索結果が0件の場合
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int NOT_FOUND(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("条件に合致する「");

    sb.append(arg1);

    sb.append("」が見つかりませんでした。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「検索条件が変更されています。＜改行＞条件を元に戻すか、再度検索してください。」を表示します。
   * <p>
   * 検索条件と検索結果が1画面内にある検索業務
   * 検索後、検索条件のみを変更して印刷しようとした場合
   * （表示されている条件と、表示されている結果が異なる場合）
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_FIND_CONDITION_ON_MODIFIED() throws Exception{

    return ACMessageBox.show("検索条件が変更されています。" + ACConstants.LINE_SEPARATOR + "条件を元に戻すか、再度検索してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[項目名]履歴を確定させますか？」を表示します。
   * <p>
   * 印刷後、フラグを立てる場合
   * 　→例：印刷
   * 　→例：CSV作成
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DECISION_HISTORY(VRMap param) throws Exception {
    return WARNING_OF_DECISION_HISTORY(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「[項目名]履歴を確定させますか？」を表示します。
   * <p>
   * 印刷後、フラグを立てる場合
   * 　→例：印刷
   * 　→例：CSV作成
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DECISION_HISTORY(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("履歴を確定させますか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「同時に同じデータを削除しようとしました。＜改行＞妥当性確保の為、処理を中止します。」を表示します。
   * <p>
   * 画面遷移時に該当レコードを取得できなかった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_PASSIVE_CHECK_ON_FIND() throws Exception{

    return ACMessageBox.show("同時に同じデータを削除しようとしました。" + ACConstants.LINE_SEPARATOR + "妥当性確保の為、処理を中止します。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「選択中の利用者　[項目名]を削除しますか？」を表示します。
   * 
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_WARNING_ON_DELETE_OF_SELECTED_PATIENT(VRMap param) throws Exception {
    return QU001_WARNING_ON_DELETE_OF_SELECTED_PATIENT(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「選択中の利用者　[項目名]を削除しますか？」を表示します。
   * 
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_WARNING_ON_DELETE_OF_SELECTED_PATIENT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("選択中の利用者　");

    sb.append(arg1);

    sb.append("を削除しますか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「現在表示されている利用者の一覧表を印刷します。＜改行＞よろしいですか？」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_WARNING_ON_PRINT_OF_PATIENT() throws Exception{

    return ACMessageBox.show("現在表示されている利用者の一覧表を印刷します。" + ACConstants.LINE_SEPARATOR + "よろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「要介護度の有効期間が切れているか、登録されていません。＜改行＞有効期間外のサービスは集計できません。＜改行＞新しい要介護度が決まっていれば、利用者情報詳細画面で登録してください。」を表示します。
   * <p>
   * 利用者一覧画面からサービス予定/実績画面に遷移する際に、期間内の要介護度がなければ表示。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_HAS_NO_YOKAIGODO() throws Exception{

    return ACMessageBox.show("要介護度の有効期間が切れているか、登録されていません。" + ACConstants.LINE_SEPARATOR + "有効期間外のサービスは集計できません。" + ACConstants.LINE_SEPARATOR + "新しい要介護度が決まっていれば、利用者情報詳細画面で登録してください。", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「[S]の[I]列目を入力してください。」を表示します。
   * 
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP005_ERROR_ON_NEED_CHECK_OF_INPUT(VRMap param) throws Exception {
    return QP005_ERROR_ON_NEED_CHECK_OF_INPUT(

      VRBindPathParser.get("S", param)

      , VRBindPathParser.get("I", param)

           );
  }
  /**
   * メッセージ「[S]の[I]列目を入力してください。」を表示します。
   * 
   * @param arg1 S
   * @param arg2 I
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP005_ERROR_ON_NEED_CHECK_OF_INPUT(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("の");

    sb.append(arg2);

    sb.append("列目を入力してください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「保存されているデータの中で、最新のデータを読み込みます。＜改行＞（現在入力されているデータは消えてしまいます。）＜改行＞よろしいですか？」を表示します。
   * <p>
   * 最新の過去データを読み込む際の確認メッセージ。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QC001_WARNING_ON_READ_OF_MOST_NEW_DATA() throws Exception{

    return ACMessageBox.show("保存されているデータの中で、最新のデータを読み込みます。" + ACConstants.LINE_SEPARATOR + "（現在入力されているデータは消えてしまいます。）" + ACConstants.LINE_SEPARATOR + "よろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「過去のデータが存在しませんでした。＜改行＞読込処理は行いません。」を表示します。
   * <p>
   * 最新の過去データを読み込もうとしたが、過去データが存在しなかった場合。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QC001_NOTICE_HAS_NO_LAST_DATA() throws Exception{

    return ACMessageBox.show("過去のデータが存在しませんでした。" + ACConstants.LINE_SEPARATOR + "読込処理は行いません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「明細書に印字できる公費は最大[num]件のため、同一帳票様式の＜改行＞サービスにかかる公費を、ひと月に[num]件までとしてください。」を表示します。
   * <p>
   * 同月内に、同一帳票様式のサービスを選択している公費情報が4件以上（医療なら3件以上）ある場合。
   * 第一引数：＜num＞　3件
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU004_ERROR_ON_KOHI_OVER_LIMIT(VRMap param) throws Exception {
    return QU004_ERROR_ON_KOHI_OVER_LIMIT(

      VRBindPathParser.get("num", param)

           );
  }
  /**
   * メッセージ「明細書に印字できる公費は最大[num]件のため、同一帳票様式の＜改行＞サービスにかかる公費を、ひと月に[num]件までとしてください。」を表示します。
   * <p>
   * 同月内に、同一帳票様式のサービスを選択している公費情報が4件以上（医療なら3件以上）ある場合。
   * 第一引数：＜num＞　3件
   * </p>
   * @param arg1 num
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU004_ERROR_ON_KOHI_OVER_LIMIT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("明細書に印字できる公費は最大");

    sb.append(arg1);

    sb.append("件のため、同一帳票様式の" + ACConstants.LINE_SEPARATOR + "サービスにかかる公費を、ひと月に");

    sb.append(arg1);

    sb.append("件までとしてください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「有効期間が、登録されている[target]の有効期間と重なっています。＜改行＞重なっている[target]の有効期間終了日を変更してもよろしいですか？」を表示します。
   * <p>
   * [target]の有効期間が重複した場合に表示する。OKが選択された場合、重なっている[target]の有効期間終了日を、登録しようとしている[target]の有効期間開始日の前日に設定する。
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DUPLICATE_TERM(VRMap param) throws Exception {
    return WARNING_OF_DUPLICATE_TERM(

      VRBindPathParser.get("target", param)

           );
  }
  /**
   * メッセージ「有効期間が、登録されている[target]の有効期間と重なっています。＜改行＞重なっている[target]の有効期間終了日を変更してもよろしいですか？」を表示します。
   * <p>
   * [target]の有効期間が重複した場合に表示する。OKが選択された場合、重なっている[target]の有効期間終了日を、登録しようとしている[target]の有効期間開始日の前日に設定する。
   * </p>
   * @param arg1 target
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DUPLICATE_TERM(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("有効期間が、登録されている");

    sb.append(arg1);

    sb.append("の有効期間と重なっています。" + ACConstants.LINE_SEPARATOR + "重なっている");

    sb.append(arg1);

    sb.append("の有効期間終了日を変更してもよろしいですか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「有効期間が、登録されている医療保険の有効期間と重なっています。」を表示します。
   * <p>
   * 医療保険の有効期間が重複した場合。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU003_ERROR_OF_DUPLICATE_IRYO() throws Exception{

    return ACMessageBox.show("有効期間が、登録されている医療保険の有効期間と重なっています。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「印刷欄にチェックがついていません。＜改行＞表示されている全ての帳票を印刷しますか？」を表示します。
   * <p>
   * 利用者一覧にチェックをつけずに印刷ボタンが押下された場合。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_WARGNING_PRINT() throws Exception{

    return ACMessageBox.show("印刷欄にチェックがついていません。" + ACConstants.LINE_SEPARATOR + "表示されている全ての帳票を印刷しますか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「集計欄にチェックのついている利用者の実績を確定し、集計処理を行ないます。」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_CONFIRMATION_PRINT() throws Exception{

    return ACMessageBox.show("集計欄にチェックのついている利用者の実績を確定し、集計処理を行ないます。", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「集計が終了しました。」を表示します。
   * <p>
   * 実績集計完了時に表示するメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_INSERT_SUCCESSED() throws Exception{

    return ACMessageBox.show("集計が終了しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「有効期間が、登録されている支給限度額の有効期間と重なっています。」を表示します。
   * <p>
   * 支給限度額の有効期間が重複した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO002_ERROR_OF_DUPLICATE_LIMIT_RATE() throws Exception{

    return ACMessageBox.show("有効期間が、登録されている支給限度額の有効期間と重なっています。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「印刷履歴を確定しますか？」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_PRINT_COMMIT() throws Exception{

    return ACMessageBox.show("印刷履歴を確定しますか？", ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_YES);

  }

  /**
   * メッセージ「更新しますか？」を表示します。
   * <p>
   * DB登録時の確認メッセージ。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP005_WARNING_OF_UPDATE() throws Exception{

    return ACMessageBox.show("更新しますか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[S]([I])の請求書または領収書を出力しますか？」を表示します。
   * <p>
   * 利用者請求を出力する事業者の確認メッセージ
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_PROVIDER_CHECK(VRMap param) throws Exception {
    return QP001_PROVIDER_CHECK(

      VRBindPathParser.get("S", param)

      , VRBindPathParser.get("I", param)

           );
  }
  /**
   * メッセージ「[S]([I])の請求書または領収書を出力しますか？」を表示します。
   * <p>
   * 利用者請求を出力する事業者の確認メッセージ
   * </p>
   * @param arg1 S
   * @param arg2 I
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_PROVIDER_CHECK(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("(");

    sb.append(arg2);

    sb.append(")の請求書または領収書を出力しますか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「印刷対象の事業所がないため印刷を中止しました。」を表示します。
   * <p>
   * 出力対象の事業所が選択されなかった場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_PROVIDER_NOSELECT() throws Exception{

    return ACMessageBox.show("印刷対象の事業所がないため印刷を中止しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「事業所 [S]([I]) の＜改行＞[S2]分の請求書CSVを作成します。」を表示します。
   * 
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_CSV_PROVIDER_CHECK(VRMap param) throws Exception {
    return QP001_CSV_PROVIDER_CHECK(

      VRBindPathParser.get("S", param)

      , VRBindPathParser.get("I", param)

      , VRBindPathParser.get("S2", param)

           );
  }
  /**
   * メッセージ「事業所 [S]([I]) の＜改行＞[S2]分の請求書CSVを作成します。」を表示します。
   * 
   * @param arg1 S
   * @param arg2 I
   * @param arg3 S2
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_CSV_PROVIDER_CHECK(

      Object arg1
      , Object arg2
      , Object arg3
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("事業所 ");

    sb.append(arg1);

    sb.append("(");

    sb.append(arg2);

    sb.append(") の" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg3);

    sb.append("分の請求書CSVを作成します。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「ＣＳＶ作成が終了しました。＜改行＞印刷履歴を確定しますか？」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_CSV_COMMIT() throws Exception{

    return ACMessageBox.show("ＣＳＶ作成が終了しました。" + ACConstants.LINE_SEPARATOR + "印刷履歴を確定しますか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[S]として登録されているため削除できません。」を表示します。
   * <p>
   * 他業務で使用されている事業所や保険者を削除しようとした場合のメッセージ
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_DELETE_USED(VRMap param) throws Exception {
    return ERROR_OF_DELETE_USED(

      VRBindPathParser.get("S", param)

           );
  }
  /**
   * メッセージ「[S]として登録されているため削除できません。」を表示します。
   * <p>
   * 他業務で使用されている事業所や保険者を削除しようとした場合のメッセージ
   * </p>
   * @param arg1 S
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_DELETE_USED(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("として登録されているため削除できません。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「他のコンピュータのデータベースを使用している場合は、この機能を利用することができません。」を表示します。
   * <p>
   * DB退避/復元時、サーバが別のコンピュータだった場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_USER_OTHER_COMPUTER() throws Exception{

    return ACMessageBox.show("他のコンピュータのデータベースを使用している場合は、この機能を利用することができません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「無効なパス名です。＜改行＞(退避先のファイルが現在のデータベースファイルと同じです)」を表示します。
   * <p>
   * DB退避時、現在使用中のFDBファイルを退避先として指定した場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_BACKUP_SAME_TO_USED() throws Exception{

    return ACMessageBox.show("無効なパス名です。" + ACConstants.LINE_SEPARATOR + "(退避先のファイルが現在のデータベースファイルと同じです)", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「無効なパス名です。＜改行＞(復元元のファイルが現在のデータベースファイルと同じです)」を表示します。
   * <p>
   * DB復元時、現在使用中のFDBファイルを復元元として指定した場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_RESTORE_SAME_TO_USED() throws Exception{

    return ACMessageBox.show("無効なパス名です。" + ACConstants.LINE_SEPARATOR + "(復元元のファイルが現在のデータベースファイルと同じです)", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「無効なパス名です。＜改行＞(退避先のファイルが復元元ファイルと同じです)」を表示します。
   * <p>
   * DB復元時、退避先FDBを現行FDBの退避先として指定した場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_BACKUP_SAME_TO_RESTORE() throws Exception{

    return ACMessageBox.show("無効なパス名です。" + ACConstants.LINE_SEPARATOR + "(退避先のファイルが復元元ファイルと同じです)", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「同じ名前のファイルが存在しています。＜改行＞上書してもよろしいですか？」を表示します。
   * <p>
   * DB退避/復元時、指定された退避先ファイルが既に存在する場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_QUESTION_OF_EXIST_SELECTED_FDB() throws Exception{

    return ACMessageBox.show("同じ名前のファイルが存在しています。" + ACConstants.LINE_SEPARATOR + "上書してもよろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データの退避(バックアップ)処理を開始します。＜改行＞しばらく時間がかかりますが、よろしいですか？」を表示します。
   * <p>
   * DB退避処理開始確認メッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_QUESTION_OF_TO_START_BACKUP() throws Exception{

    return ACMessageBox.show("データの退避(バックアップ)処理を開始します。" + ACConstants.LINE_SEPARATOR + "しばらく時間がかかりますが、よろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データの復元(リストア)処理を開始します。＜改行＞しばらく時間がかかりますが、よろしいですか？」を表示します。
   * <p>
   * DB復元処理開始確認メッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_QUESTION_OF_TO_START_RESTORE() throws Exception{

    return ACMessageBox.show("データの復元(リストア)処理を開始します。" + ACConstants.LINE_SEPARATOR + "しばらく時間がかかりますが、よろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データの退避(バックアップ)が終了しました。」を表示します。
   * <p>
   * DB退避時、退避処理に成功した場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_BACKUP_SUCCESSED() throws Exception{

    return ACMessageBox.show("データの退避(バックアップ)が終了しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データの退避(バックアップ)に失敗しました。」を表示します。
   * <p>
   * DB退避時、退避処理に失敗した場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_BACKUP_FAILED() throws Exception{

    return ACMessageBox.show("データの退避(バックアップ)に失敗しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データの復元(リストア)が終了しました。」を表示します。
   * <p>
   * DB復元時、復元処理に成功した場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_RESTORE_SUCCESSED() throws Exception{

    return ACMessageBox.show("データの復元(リストア)が終了しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データの復元(リストア)に失敗しました。＜改行＞データベースに他の端末やその他のソフトウェアがアクセス中でないか確認してください。」を表示します。
   * <p>
   * DB復元時、復元処理に失敗した場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_RESTORE_FAILED_FILEIO() throws Exception{

    return ACMessageBox.show("データの復元(リストア)に失敗しました。" + ACConstants.LINE_SEPARATOR + "データベースに他の端末やその他のソフトウェアがアクセス中でないか確認してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「選択されたファイル([RESTORE])から全データの復元を実行します。＜改行＞現在のデータは別ファイル([BACKUP])に保存されます。＜改行＞実行してもよろしいですか？」を表示します。
   * <p>
   * DB退避時、現行DBの退避先を確認するときのメッセージ
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_QUESTION_OF_BACKUP_FILENAME(VRMap param) throws Exception {
    return QO005_QUESTION_OF_BACKUP_FILENAME(

      VRBindPathParser.get("RESTORE", param)

      , VRBindPathParser.get("BACKUP", param)

           );
  }
  /**
   * メッセージ「選択されたファイル([RESTORE])から全データの復元を実行します。＜改行＞現在のデータは別ファイル([BACKUP])に保存されます。＜改行＞実行してもよろしいですか？」を表示します。
   * <p>
   * DB退避時、現行DBの退避先を確認するときのメッセージ
   * </p>
   * @param arg1 RESTORE
   * @param arg2 BACKUP
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_QUESTION_OF_BACKUP_FILENAME(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("選択されたファイル(");

    sb.append(arg1);

    sb.append(")から全データの復元を実行します。" + ACConstants.LINE_SEPARATOR + "現在のデータは別ファイル(");

    sb.append(arg2);

    sb.append(")に保存されます。" + ACConstants.LINE_SEPARATOR + "実行してもよろしいですか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[項目名]時刻に誤りがあります。」を表示します。
   * <p>
   * 入力チェック
   * 時刻項目に存在しない時刻が入力されている場合
   * [項目名]は項目名を表示する場合に使用
   * 　→例：[項目名] = 訪問終了の
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP006_ERROR_OF_WRONG_TIME(VRMap param) throws Exception {
    return QP006_ERROR_OF_WRONG_TIME(

      VRBindPathParser.get("項目名", param)

           );
  }
  /**
   * メッセージ「[項目名]時刻に誤りがあります。」を表示します。
   * <p>
   * 入力チェック
   * 時刻項目に存在しない時刻が入力されている場合
   * [項目名]は項目名を表示する場合に使用
   * 　→例：[項目名] = 訪問終了の
   * </p>
   * @param arg1 項目名
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP006_ERROR_OF_WRONG_TIME(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("時刻に誤りがあります。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「居宅療養管理指導の回数が限度を超えている可能性があります。＜改行＞このまま登録してもよろしいですか？＜改行＞[S]」を表示します。
   * <p>
   * サービス予定登録時、居宅療養管理指導の回数が限度回数を超えている場合に表示。[S]は項目と回数。(例:管理栄養士 3回)
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_LIMIT_OVER_KYOTAKU_RYOYO_KANRI_SHIDO(VRMap param) throws Exception {
    return QS001_LIMIT_OVER_KYOTAKU_RYOYO_KANRI_SHIDO(

      VRBindPathParser.get("S", param)

           );
  }
  /**
   * メッセージ「居宅療養管理指導の回数が限度を超えている可能性があります。＜改行＞このまま登録してもよろしいですか？＜改行＞[S]」を表示します。
   * <p>
   * サービス予定登録時、居宅療養管理指導の回数が限度回数を超えている場合に表示。[S]は項目と回数。(例:管理栄養士 3回)
   * </p>
   * @param arg1 S
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_LIMIT_OVER_KYOTAKU_RYOYO_KANRI_SHIDO(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("居宅療養管理指導の回数が限度を超えている可能性があります。" + ACConstants.LINE_SEPARATOR + "このまま登録してもよろしいですか？" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg1);

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「変更された内容は破棄されます。＜改行＞クリアしてもよろしいですか？」を表示します。
   * <p>
   * 処理実行確認メッセージ。
   * クリアボタン押下時、画面が変更されている場合に表示。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_CLEAR_ON_MODIFIED() throws Exception{

    return ACMessageBox.show("変更された内容は破棄されます。" + ACConstants.LINE_SEPARATOR + "クリアしてもよろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「提供サービスのマスタ情報の取得に失敗しました。」を表示します。
   * <p>
   * 提供サービスのマスタ情報が取得できなかった場合に表示するメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO004_ERROR_OF_SERVICE_MASTER() throws Exception{

    return ACMessageBox.show("提供サービスのマスタ情報の取得に失敗しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[列名]欄にチェックがついていません。＜改行＞表示されている全員の[処理]しますか？」を表示します。
   * <p>
   * 利用者一覧にチェックをつけずに集計ボタンが押下された場合。
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_WARGNING_TOTAL(VRMap param) throws Exception {
    return QP001_WARGNING_TOTAL(

      VRBindPathParser.get("列名", param)

      , VRBindPathParser.get("処理", param)

           );
  }
  /**
   * メッセージ「[列名]欄にチェックがついていません。＜改行＞表示されている全員の[処理]しますか？」を表示します。
   * <p>
   * 利用者一覧にチェックをつけずに集計ボタンが押下された場合。
   * </p>
   * @param arg1 列名
   * @param arg2 処理
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_WARGNING_TOTAL(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("欄にチェックがついていません。" + ACConstants.LINE_SEPARATOR + "表示されている全員の");

    sb.append(arg2);

    sb.append("しますか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「ひと月に、異なる被保険者番号は2つまでしか登録できません。＜改行＞3つ以上登録する場合は、同名の新しい利用者を作成してください。」を表示します。
   * <p>
   * 要介護認定情報の追加・編集時、1月に異なる被保険者番号が3つ以上存在することになる場合。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP002_ERROR_OF_INSURED_ID() throws Exception{

    return ACMessageBox.show("ひと月に、異なる被保険者番号は2つまでしか登録できません。" + ACConstants.LINE_SEPARATOR + "3つ以上登録する場合は、同名の新しい利用者を作成してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「実績の全消去と予定の読込を行います。＜改行＞よろしいですか？」を表示します。
   * <p>
   * 予定情報取込時。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_READ_PLAN() throws Exception{

    return ACMessageBox.show("実績の全消去と予定の読込を行います。" + ACConstants.LINE_SEPARATOR + "よろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「提供サービス情報が変更されています。＜改行＞変更を反映してもよろしいですか？」を表示します。
   * <p>
   * 提供サービス変更時にパネルを切り替えを行った場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO004_WARNING_OF_SERVICE_INSERT() throws Exception{

    return ACMessageBox.show("提供サービス情報が変更されています。" + ACConstants.LINE_SEPARATOR + "変更を反映してもよろしいですか？", ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「メニューマスタ情報の取得に失敗しました。」を表示します。
   * <p>
   * メニューマスタの情報の取得に失敗した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO004_ERROR_OF_MASTER_MENU() throws Exception{

    return ACMessageBox.show("メニューマスタ情報の取得に失敗しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「有効期間日付[TIME]に誤りがあります。＜改行＞[MONTH]の日付を入力してください。」を表示します。
   * <p>
   * 保険者登録の支給限度額有効期間に不正な日付が入力された場合
   * 第一引数→[TIME]
   * 第二引数→[MONTH]
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_VALID_PERIOD(VRMap param) throws Exception {
    return ERROR_OF_VALID_PERIOD(

      VRBindPathParser.get("TIME", param)

      , VRBindPathParser.get("MONTH", param)

           );
  }
  /**
   * メッセージ「有効期間日付[TIME]に誤りがあります。＜改行＞[MONTH]の日付を入力してください。」を表示します。
   * <p>
   * 保険者登録の支給限度額有効期間に不正な日付が入力された場合
   * 第一引数→[TIME]
   * 第二引数→[MONTH]
   * </p>
   * @param arg1 TIME
   * @param arg2 MONTH
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_VALID_PERIOD(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("有効期間日付");

    sb.append(arg1);

    sb.append("に誤りがあります。" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg2);

    sb.append("の日付を入力してください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[FIELD]は[LENGTH]桁で入力してください。」を表示します。
   * <p>
   * 桁数チェックでエラーが発生した際に表示する。
   * 第一引数→[FIELD]
   * 第二引数→[LENGTH]
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_LENGTH(VRMap param) throws Exception {
    return ERROR_OF_LENGTH(

      VRBindPathParser.get("FIELD", param)

      , VRBindPathParser.get("LENGTH", param)

           );
  }
  /**
   * メッセージ「[FIELD]は[LENGTH]桁で入力してください。」を表示します。
   * <p>
   * 桁数チェックでエラーが発生した際に表示する。
   * 第一引数→[FIELD]
   * 第二引数→[LENGTH]
   * </p>
   * @param arg1 FIELD
   * @param arg2 LENGTH
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_LENGTH(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("は");

    sb.append(arg2);

    sb.append("桁で入力してください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「変更されています。＜改行＞[PROCESS]して[PRINTNAME]を印刷してもよろしいですか？」を表示します。
   * <p>
   * 印刷前に画面が変更されている場合に表示
   * 第一引数→[PROCESS]　例：登録、更新
   * 第二引数→[PRINTNAME]　例：訪問看護計画書
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DO_PRINT(VRMap param) throws Exception {
    return WARNING_OF_DO_PRINT(

      VRBindPathParser.get("PROCESS", param)

      , VRBindPathParser.get("PRINTNAME", param)

           );
  }
  /**
   * メッセージ「変更されています。＜改行＞[PROCESS]して[PRINTNAME]を印刷してもよろしいですか？」を表示します。
   * <p>
   * 印刷前に画面が変更されている場合に表示
   * 第一引数→[PROCESS]　例：登録、更新
   * 第二引数→[PRINTNAME]　例：訪問看護計画書
   * </p>
   * @param arg1 PROCESS
   * @param arg2 PRINTNAME
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DO_PRINT(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("変更されています。" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg1);

    sb.append("して");

    sb.append(arg2);

    sb.append("を印刷してもよろしいですか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「要介護度の認定有効期間が過ぎているか、もしくは登録されていません。＜改行＞利用者情報詳細画面で認定情報を登録してください。」を表示します。
   * <p>
   * 利用者一覧から画面遷移時に対象年月内に認定履歴のないとき、使用します。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_NO_NINTEI_HISTORY() throws Exception{

    return ACMessageBox.show("要介護度の認定有効期間が過ぎているか、もしくは登録されていません。" + ACConstants.LINE_SEPARATOR + "利用者情報詳細画面で認定情報を登録してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[AFFAIR]編集の前に利用者情報を[PROCESS]する必要があります。＜改行＞[PROCESS]してもよろしいですか？」を表示します。
   * <p>
   * 画面遷移前に画面が変更されている場合に表示
   * 第一引数→[AFFAIR]　例：公費・軽減情報、医療看護情報
   * 第ニ引数→[PROCESS]　例：登録、更新
   * 第三引数→[PROCESS]　例：登録、更新
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU002_WARNING_OF_TRANSFER(VRMap param) throws Exception {
    return QU002_WARNING_OF_TRANSFER(

      VRBindPathParser.get("AFFAIR", param)

      , VRBindPathParser.get("PROCESS", param)

           );
  }
  /**
   * メッセージ「[AFFAIR]編集の前に利用者情報を[PROCESS]する必要があります。＜改行＞[PROCESS]してもよろしいですか？」を表示します。
   * <p>
   * 画面遷移前に画面が変更されている場合に表示
   * 第一引数→[AFFAIR]　例：公費・軽減情報、医療看護情報
   * 第ニ引数→[PROCESS]　例：登録、更新
   * 第三引数→[PROCESS]　例：登録、更新
   * </p>
   * @param arg1 AFFAIR
   * @param arg2 PROCESS
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU002_WARNING_OF_TRANSFER(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("編集の前に利用者情報を");

    sb.append(arg2);

    sb.append("する必要があります。" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg2);

    sb.append("してもよろしいですか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「表示できる実績がありません。＜改行＞予定を表示しますか？」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_QUESTION_OF_NO_RESULT() throws Exception{

    return ACMessageBox.show("表示できる実績がありません。" + ACConstants.LINE_SEPARATOR + "予定を表示しますか？", ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「事業所が選択されていません。」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_EROOR_OF_UNSELECTED_PROVIDER() throws Exception{

    return ACMessageBox.show("事業所が選択されていません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「内容詳細に不備があります。」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_NO_CONTENT() throws Exception{

    return ACMessageBox.show("内容詳細に不備があります。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「時刻に不備があります。」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_NO_TIME() throws Exception{

    return ACMessageBox.show("時刻に不備があります。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[対象利用者]がいるため変更することができません。」を表示します。
   * <p>
   * 事業所情報登録時に提供サービス情報を削除使用とした場合
   * 第1引数→[対象利用者]　例：サービスを受けている利用者
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DELETE_PROVIDER(VRMap param) throws Exception {
    return WARNING_OF_DELETE_PROVIDER(

      VRBindPathParser.get("対象利用者", param)

           );
  }
  /**
   * メッセージ「[対象利用者]がいるため変更することができません。」を表示します。
   * <p>
   * 事業所情報登録時に提供サービス情報を削除使用とした場合
   * 第1引数→[対象利用者]　例：サービスを受けている利用者
   * </p>
   * @param arg1 対象利用者
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_DELETE_PROVIDER(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("がいるため変更することができません。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「厚生労働省規定の支給限度額に変更してもよろしいですか？＜改行＞（現在入力されているデータは消えてしまいます。）」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO002_WARNING_OF_LIMIT_RATE_REGULAR() throws Exception{

    return ACMessageBox.show("厚生労働省規定の支給限度額に変更してもよろしいですか？" + ACConstants.LINE_SEPARATOR + "（現在入力されているデータは消えてしまいます。）", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「月間表をクリアしてもよろしいですか？」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_WARNING_OF_CLEAR_MONTHLY() throws Exception{

    return ACMessageBox.show("月間表をクリアしてもよろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「週間表をクリアしてもよろしいですか？」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_WARNING_OF_CLEAR_WEEKLY() throws Exception{

    return ACMessageBox.show("週間表をクリアしてもよろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「この認定履歴を[mode]すると、有効期間外になるサービスが存在します。＜改行＞[mode]してもよろしいですか？」を表示します。
   * <p>
   * 要介護認定情報編集・削除時、有効期間外となるサービスが存在する場合
   * 第一引数：→[mode]　例：編集
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU002_WARNING_OF_OUT_OF_VALID(VRMap param) throws Exception {
    return QU002_WARNING_OF_OUT_OF_VALID(

      VRBindPathParser.get("mode", param)

           );
  }
  /**
   * メッセージ「この認定履歴を[mode]すると、有効期間外になるサービスが存在します。＜改行＞[mode]してもよろしいですか？」を表示します。
   * <p>
   * 要介護認定情報編集・削除時、有効期間外となるサービスが存在する場合
   * 第一引数：→[mode]　例：編集
   * </p>
   * @param arg1 mode
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU002_WARNING_OF_OUT_OF_VALID(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("この認定履歴を");

    sb.append(arg1);

    sb.append("すると、有効期間外になるサービスが存在します。" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg1);

    sb.append("してもよろしいですか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「有効期間が、登録されている要介護認定の有効期間と重なっています。」を表示します。
   * <p>
   * 要介護認定の有効期間が重複した場合に表示する。（有効期間を自動で調整できない場合）
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU002_ERROR_OF_DUPLICATE_KAIGO() throws Exception{

    return ACMessageBox.show("有効期間が、登録されている要介護認定の有効期間と重なっています。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「公費・社福軽減情報画面で生保の情報を登録してください。」を表示します。
   * <p>
   * 被保険者番号が「H」で始まる場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU002_REQUEST_TO_INSERT_SEIHO() throws Exception{

    return ACMessageBox.show("公費・社福軽減情報画面で生保の情報を登録してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[期間]の訪問看護の実績を読込みます。＜改行＞（現在入力されているデータは消えてしまいます。）＜改行＞よろしいですか？」を表示します。
   * <p>
   * 訪問看護報告書で訪問看護の実績を読込む場合
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QC002_WARNING_OF_RESULT(VRMap param) throws Exception {
    return QC002_WARNING_OF_RESULT(

      VRBindPathParser.get("期間", param)

           );
  }
  /**
   * メッセージ「[期間]の訪問看護の実績を読込みます。＜改行＞（現在入力されているデータは消えてしまいます。）＜改行＞よろしいですか？」を表示します。
   * <p>
   * 訪問看護報告書で訪問看護の実績を読込む場合
   * </p>
   * @param arg1 期間
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QC002_WARNING_OF_RESULT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("の訪問看護の実績を読込みます。" + ACConstants.LINE_SEPARATOR + "（現在入力されているデータは消えてしまいます。）" + ACConstants.LINE_SEPARATOR + "よろしいですか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「訪問看護の実績データが存在しませんでした。＜改行＞読込処理は行いません。」を表示します。
   * <p>
   * 訪問看護の実績が読込めなかった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QC002_ERROR_OF_RESULT() throws Exception{

    return ACMessageBox.show("訪問看護の実績データが存在しませんでした。" + ACConstants.LINE_SEPARATOR + "読込処理は行いません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「「生活援助」では「30分未満」は選択できません。＜改行＞「30分以上1時間未満」に設定します。」を表示します。
   * <p>
   * 訪問介護の訪問種別として「生活援助」を選択し、提供時間に「30分未満」を指定した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_LIFE_ASSIST_TIME() throws Exception{

    return ACMessageBox.show("「生活援助」では「30分未満」は選択できません。" + ACConstants.LINE_SEPARATOR + "「30分以上1時間未満」に設定します。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「すでに同一の[item]情報が有効期間内に登録されています。」を表示します。
   * <p>
   * 選択した公費と同じ公費が、入力した有効期間内に登録されている場合
   * 第一引数→[item]　例：公費
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU004_ERROR_OF_DUPLICATE_KOHI_TERM(VRMap param) throws Exception {
    return QU004_ERROR_OF_DUPLICATE_KOHI_TERM(

      VRBindPathParser.get("item", param)

           );
  }
  /**
   * メッセージ「すでに同一の[item]情報が有効期間内に登録されています。」を表示します。
   * <p>
   * 選択した公費と同じ公費が、入力した有効期間内に登録されている場合
   * 第一引数→[item]　例：公費
   * </p>
   * @param arg1 item
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU004_ERROR_OF_DUPLICATE_KOHI_TERM(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("すでに同一の");

    sb.append(arg1);

    sb.append("情報が有効期間内に登録されています。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「日数が指定されていません。」を表示します。
   * <p>
   * サービス予定の週間表において、貼り付け日数を指定せずに貼り付けボタンを押下した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_NO_PASTE_DAY() throws Exception{

    return ACMessageBox.show("日数が指定されていません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「貼り付け先が指定されていません。」を表示します。
   * <p>
   * サービス予定の週間表において、貼り付け曜日を指定せずに貼り付けボタンを押下した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_NO_PASTE_WEEK() throws Exception{

    return ACMessageBox.show("貼り付け先が指定されていません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「給付率には、91以上100以下の値を入力してください。」を表示します。
   * <p>
   * 給付率の値が、90未満もしくは101以上であった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU004_ERROR_OF_BENEFIT_RATE_VALUE() throws Exception{

    return ACMessageBox.show("給付率には、91以上100以下の値を入力してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「利用者負担単位数が未入力です。」を表示します。
   * <p>
   * 自己負担調整画面にて利用者負担単位数を空欄にした場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_BLANK_ADJUST_UNIT() throws Exception{

    return ACMessageBox.show("利用者負担単位数が未入力です。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「割引率には、100以下の値を入力してください。」を表示します。
   * <p>
   * 割引率に100を超える値を入力された場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO004_ERROR_OF_REDUCT_RATE() throws Exception{

    return ACMessageBox.show("割引率には、100以下の値を入力してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[item]が重複しています。」を表示します。
   * <p>
   * 項目名が重複していた場合。
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO008_ERROR_OF_OVERLAP(VRMap param) throws Exception {
    return QO008_ERROR_OF_OVERLAP(

      VRBindPathParser.get("item", param)

           );
  }
  /**
   * メッセージ「[item]が重複しています。」を表示します。
   * <p>
   * 項目名が重複していた場合。
   * </p>
   * @param arg1 item
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO008_ERROR_OF_OVERLAP(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("が重複しています。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[count]枚目のフロッピーを挿入して下さい。」を表示します。
   * <p>
   * フロッピーが複数毎にわたる場合。
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_NEXT_FD(VRMap param) throws Exception {
    return QP001_NEXT_FD(

      VRBindPathParser.get("count", param)

           );
  }
  /**
   * メッセージ「[count]枚目のフロッピーを挿入して下さい。」を表示します。
   * <p>
   * フロッピーが複数毎にわたる場合。
   * </p>
   * @param arg1 count
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_NEXT_FD(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("枚目のフロッピーを挿入して下さい。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「ログイン事業所を選択して下さい。」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QM001_ERROR_OF_PROVIDER() throws Exception{

    return ACMessageBox.show("ログイン事業所を選択して下さい。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「区分支給限度基準額を超えています。＜改行＞利用者負担単位数を調整後に印刷してください。」を表示します。
   * <p>
   * 区分支給限度額を超えた状態で利用票・提供票を印刷しようとした場合。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_LIMIT_RATE_OVER() throws Exception{

    return ACMessageBox.show("区分支給限度基準額を超えています。" + ACConstants.LINE_SEPARATOR + "利用者負担単位数を調整後に印刷してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「当月の要介護認定履歴が存在しません。＜改行＞当月に有効な要介護認定履歴を作成後、印刷してください。」を表示します。
   * <p>
   * 当月の要介護認定履歴がない状態で利用票・提供票を印刷しようとした場合。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_NO_INSURE_INFO() throws Exception{

    return ACMessageBox.show("当月の要介護認定履歴が存在しません。" + ACConstants.LINE_SEPARATOR + "当月に有効な要介護認定履歴を作成後、印刷してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「30日超のサービスは、全額自己負担扱いです。」を表示します。
   * <p>
   * 30日超のサービスに対して自己負担調整を行おうとした場合。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_EDIT_ON_30_DAY_OVER_SERVICE() throws Exception{

    return ACMessageBox.show("30日超のサービスは、全額自己負担扱いです。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[item]は[value]以下の値を入力してください。」を表示します。
   * <p>
   * 入力された値が大きすぎる場合
   * 第一引数→[item]　例：給付率
   * 第二引数→[value]　例：100
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_VALUE_TOO_MUCH(VRMap param) throws Exception {
    return ERROR_OF_VALUE_TOO_MUCH(

      VRBindPathParser.get("item", param)

      , VRBindPathParser.get("value", param)

           );
  }
  /**
   * メッセージ「[item]は[value]以下の値を入力してください。」を表示します。
   * <p>
   * 入力された値が大きすぎる場合
   * 第一引数→[item]　例：給付率
   * 第二引数→[value]　例：100
   * </p>
   * @param arg1 item
   * @param arg2 value
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_VALUE_TOO_MUCH(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("は");

    sb.append(arg2);

    sb.append("以下の値を入力してください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「対象年月には、「平成18年4月」以降の日付を入力してください。」を表示します。
   * <p>
   * 平成18年4月以前の日付が入力された場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_ERROR_OF_DATE_BEFORE_LAW_CHANGE() throws Exception{

    return ACMessageBox.show("対象年月には、「平成18年4月」以降の日付を入力してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「入力された[key]は、過去に削除された[item]の[key]と一致します。＜改行＞削除済みの[item]情報を復元しますか？」を表示します。
   * <p>
   * 過去に削除されたデータの中に、KEYの一致するデータがあった場合。
   * 第一引数→[key]　例：事業所番号
   * 第二引数→[item]　例：事業所
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_RESTORATION_OF_DELETE_DATA(VRMap param) throws Exception {
    return WARNING_OF_RESTORATION_OF_DELETE_DATA(

      VRBindPathParser.get("key", param)

      , VRBindPathParser.get("item", param)

           );
  }
  /**
   * メッセージ「入力された[key]は、過去に削除された[item]の[key]と一致します。＜改行＞削除済みの[item]情報を復元しますか？」を表示します。
   * <p>
   * 過去に削除されたデータの中に、KEYの一致するデータがあった場合。
   * 第一引数→[key]　例：事業所番号
   * 第二引数→[item]　例：事業所
   * </p>
   * @param arg1 key
   * @param arg2 item
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_RESTORATION_OF_DELETE_DATA(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("入力された");

    sb.append(arg1);

    sb.append("は、過去に削除された");

    sb.append(arg2);

    sb.append("の");

    sb.append(arg1);

    sb.append("と一致します。" + ACConstants.LINE_SEPARATOR + "削除済みの");

    sb.append(arg2);

    sb.append("情報を復元しますか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「事業所登録がキャンセルされたため、給管鳥を終了します。」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QM001_END_OF_SYSTEM() throws Exception{

    return ACMessageBox.show("事業所登録がキャンセルされたため、給管鳥を終了します。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「未入力の項目があります。」を表示します。
   * <p>
   * 入力すべき項目を空欄で処理しようとしたとき。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_BLANK_TEXT() throws Exception{

    return ACMessageBox.show("未入力の項目があります。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「選択されたファイルは有効なデータベースファイルではありません。」を表示します。
   * <p>
   * 選択したファイルがDBでなかった場合、もしくは存在しない場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_NOT_A_DATABASE() throws Exception{

    return ACMessageBox.show("選択されたファイルは有効なデータベースファイルではありません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データベースの保存場所に日本語を含む事はできません。データベースを移動するか、別のデータベースを指定してください。」を表示します。
   * <p>
   * データベースの場所に日本語キャラクターが含まれていた場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_DBPATH_INCLUDE_JAPANESE_CHAR() throws Exception{

    return ACMessageBox.show("データベースの保存場所に日本語を含む事はできません。データベースを移動するか、別のデータベースを指定してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データベースのファイル名が変更されています、設定を更新して再度実行してください。」を表示します。
   * <p>
   * データベースのバックアップ・リストアを行う前に、復元先になるDBパスが画面で変更されている場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_NOT_SAME_PROPERTY_DBPATH() throws Exception{

    return ACMessageBox.show("データベースのファイル名が変更されています、設定を更新して再度実行してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「接続確認用テンポラリ領域へのDBファイルコピーに失敗しました。正しいファイルか確認してください。」を表示します。
   * <p>
   * 接続検証用テンポラリに指定されたファイルをコピーする際にエラーが発生した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_COPY_DBFILE_TEMP_FAILED() throws Exception{

    return ACMessageBox.show("接続確認用テンポラリ領域へのDBファイルコピーに失敗しました。正しいファイルか確認してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「復元元のデータベースを認識できません。＜改行＞正常なFirebirdのデータベースファイルであるか確認してください。」を表示します。
   * <p>
   * 復元指定したDBファイルの接続検証でDBとして接続できなかった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_NOT_FIREBIRD_DB() throws Exception{

    return ACMessageBox.show("復元元のデータベースを認識できません。" + ACConstants.LINE_SEPARATOR + "正常なFirebirdのデータベースファイルであるか確認してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「選択されたファイルは実行可能なファイルではありません。」を表示します。
   * <p>
   * PDFビュアーに指定したファイルが実行可能な拡張子で無かった場合、または存在しない場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_NOT_EXECUTE_FILE() throws Exception{

    return ACMessageBox.show("選択されたファイルは実行可能なファイルではありません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「IPアドレスまたはホスト名が未入力です。」を表示します。
   * <p>
   * ラジオボタンがリモートになっているにも関わらず、IPアドレスかホスト名が入力されていなかった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_EMPTY_IP_OR_HOST() throws Exception{

    return ACMessageBox.show("IPアドレスまたはホスト名が未入力です。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データベースの設定ファイル名が入力されていません。」を表示します。
   * <p>
   * データベースのファイルの場所が未入力になっていた場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_EMPTY_DBFILE_PATH() throws Exception{

    return ACMessageBox.show("データベースの設定ファイル名が入力されていません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「PDFファイルビュアーの設定がされていません。」を表示します。
   * <p>
   * PDFファイル閲覧ソフトの実行パスが未入力になっていた場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_EMPTY_PDF_VIEWER_PATH() throws Exception{

    return ACMessageBox.show("PDFファイルビュアーの設定がされていません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データベースをオープンできません。データベースの設定を見直してください。＜改行＞※例として、以下の項目をご確認ください。＜改行＞【動作環境】＜改行＞・Macの場合、Java実行環境(JRE)に「Java 1.4.2 Update 2」を適用済みですか？＜改行＞【セキュリティソフトによる制限】＜改行＞・ウィルス対策ソフトや、セキュリティ関係のソフトウェアをインストールしていますか？→当該ソフトの設定を変更し、ポート3050での通信を許可するか、Firebird に実行権限を付与してください。＜改行＞・ Windows XPの場合、「ファイアウォール」機能を使用されていますか？→ファイアウォールの設定を変更し、ブロックしない例外プログラムに Firebird を追加してください。＜改行＞※Windowsで標準設定のまま Firebird をインストールした場合、C:\\Program Files\\Firebird\\bin\\fbguard.exe とC:\\Program Files\\Firebird\\bin\\fbserver.exe の実行を許可する設定にしてください。＜改行＞※各ソフトウェアの設定方法の詳細につきましては、ソフトウェアのメーカーにお問い合わせください。」を表示します。
   * <p>
   * 設定を格納する前にFBに接続可能か事前にチェックを行う際に、接続ができなかったら表示するエラー
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_NOT_CONNECT_FIREBIRD() throws Exception{

    return ACMessageBox.show("データベースをオープンできません。データベースの設定を見直してください。" + ACConstants.LINE_SEPARATOR + "※例として、以下の項目をご確認ください。" + ACConstants.LINE_SEPARATOR + "【動作環境】" + ACConstants.LINE_SEPARATOR + "・Macの場合、Java実行環境(JRE)に「Java 1.4.2 Update 2」を適用済みですか？" + ACConstants.LINE_SEPARATOR + "【セキュリティソフトによる制限】" + ACConstants.LINE_SEPARATOR + "・ウィルス対策ソフトや、セキュリティ関係のソフトウェアをインストールしていますか？→当該ソフトの設定を変更し、ポート3050での通信を許可するか、Firebird に実行権限を付与してください。" + ACConstants.LINE_SEPARATOR + "・ Windows XPの場合、「ファイアウォール」機能を使用されていますか？→ファイアウォールの設定を変更し、ブロックしない例外プログラムに Firebird を追加してください。" + ACConstants.LINE_SEPARATOR + "※Windowsで標準設定のまま Firebird をインストールした場合、C:\\Program Files\\Firebird\\bin\\fbguard.exe とC:\\Program Files\\Firebird\\bin\\fbserver.exe の実行を許可する設定にしてください。" + ACConstants.LINE_SEPARATOR + "※各ソフトウェアの設定方法の詳細につきましては、ソフトウェアのメーカーにお問い合わせください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「印字可能なサービスが設定されていません。＜改行＞印刷しますか？」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_WARNING_OF_BLANK_PAGE() throws Exception{

    return ACMessageBox.show("印字可能なサービスが設定されていません。" + ACConstants.LINE_SEPARATOR + "印刷しますか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「給付管理対象外のサービスは自己負担調整できません。」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_INVALID_UNIT_ADJUST() throws Exception{

    return ACMessageBox.show("給付管理対象外のサービスは自己負担調整できません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[info]が変更されています。確定していない変更は破棄されます。＜改行＞よろしいですか？＜改行＞＜改行＞※変更を反映する場合、追加もしくは書替ボタンを押下してください。」を表示します。
   * <p>
   * 要介護認定履歴などのテーブル編集業務において、追加・編集ボタンにてデータが確定されていない場合
   * 第一引数→[info] 例：要介護認定情報もしくは異動情報
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_CANCELLATION_UNSETTLED_DATA(VRMap param) throws Exception {
    return WARNING_OF_CANCELLATION_UNSETTLED_DATA(

      VRBindPathParser.get("info", param)

           );
  }
  /**
   * メッセージ「[info]が変更されています。確定していない変更は破棄されます。＜改行＞よろしいですか？＜改行＞＜改行＞※変更を反映する場合、追加もしくは書替ボタンを押下してください。」を表示します。
   * <p>
   * 要介護認定履歴などのテーブル編集業務において、追加・編集ボタンにてデータが確定されていない場合
   * 第一引数→[info] 例：要介護認定情報もしくは異動情報
   * </p>
   * @param arg1 info
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int WARNING_OF_CANCELLATION_UNSETTLED_DATA(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("が変更されています。確定していない変更は破棄されます。" + ACConstants.LINE_SEPARATOR + "よろしいですか？" + ACConstants.LINE_SEPARATOR + "" + ACConstants.LINE_SEPARATOR + "※変更を反映する場合、追加もしくは書替ボタンを押下してください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「すでに、同一の介護支援専門員番号を持つ担当者が登録されています。」を表示します。
   * <p>
   * 介護支援専門員番号が重複する場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO004_ERROR_OF_DUPLICATE_CARE_MANAGER_NO() throws Exception{

    return ACMessageBox.show("すでに、同一の介護支援専門員番号を持つ担当者が登録されています。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[item]が重複しています。」を表示します。
   * <p>
   * 項目名が重複していた場合。
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO002_ERROR_OF_OVERLAP(VRMap param) throws Exception {
    return QO002_ERROR_OF_OVERLAP(

      VRBindPathParser.get("item", param)

           );
  }
  /**
   * メッセージ「[item]が重複しています。」を表示します。
   * <p>
   * 項目名が重複していた場合。
   * </p>
   * @param arg1 item
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO002_ERROR_OF_OVERLAP(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("が重複しています。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「居宅サービス計画を作成する事業所が選択されていません。＜改行＞＜改行＞※居宅サービス計画を作成する事業所が登録されていない場合は、事業所登録画面にて＜改行＞　以下のいずれかのサービスを提供する事業所を登録してください。＜改行＞　　　・居宅介護支援＜改行＞　　　・介護予防支援＜改行＞　　　・小規模多機能型居宅介護＜改行＞　　　・介護予防小規模多機能型居宅介護」を表示します。
   * <p>
   * 要介護認定履歴の居宅介護支援事業所が選択されていなかった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU002_ERROR_OF_NO_DATA_SHIEN_PROVIDER() throws Exception{

    return ACMessageBox.show("居宅サービス計画を作成する事業所が選択されていません。" + ACConstants.LINE_SEPARATOR + "" + ACConstants.LINE_SEPARATOR + "※居宅サービス計画を作成する事業所が登録されていない場合は、事業所登録画面にて" + ACConstants.LINE_SEPARATOR + "　以下のいずれかのサービスを提供する事業所を登録してください。" + ACConstants.LINE_SEPARATOR + "　　　・居宅介護支援" + ACConstants.LINE_SEPARATOR + "　　　・介護予防支援" + ACConstants.LINE_SEPARATOR + "　　　・小規模多機能型居宅介護" + ACConstants.LINE_SEPARATOR + "　　　・介護予防小規模多機能型居宅介護", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「削除しました。＜改行＞ログイン事業所を再選択するため、戻るボタンを押下した際に自動でログアウトします。」を表示します。
   * <p>
   * 事業所一覧でログイン事業所を削除した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO003_DELETE_SUCCESSED_AND_MUST_LOGOUT() throws Exception{

    return ACMessageBox.show("削除しました。" + ACConstants.LINE_SEPARATOR + "ログイン事業所を再選択するため、戻るボタンを押下した際に自動でログアウトします。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「利用者負担単位数が給付管理対象単位数を超えています。＜改行＞利用者負担単位数を調整後に印刷してください。」を表示します。
   * <p>
   * 利用者負担調整後の単位数が0未満で印刷した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_MINIMUM_OVER() throws Exception{

    return ACMessageBox.show("利用者負担単位数が給付管理対象単位数を超えています。" + ACConstants.LINE_SEPARATOR + "利用者負担単位数を調整後に印刷してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「CSV出力可能なフォルダが指定されていません。＜改行＞「任意のフォルダ」を押下して出力先を指定してください。」を表示します。
   * <p>
   * CSV出力先として有効なフォルダ以外を指定した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP008_ERROR_OF_INVALID_FOLDER() throws Exception{

    return ACMessageBox.show("CSV出力可能なフォルダが指定されていません。" + ACConstants.LINE_SEPARATOR + "「任意のフォルダ」を押下して出力先を指定してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「被保険者番号が「H」で始まっているため、生保単独とみなし＜改行＞介護保険給付率を0%にします。＜改行＞よろしいですか？」を表示します。
   * <p>
   * 要介護認定履歴登録・編集時、被保険者番号が「H」で始まっている場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU002_WARNING_OF_CHANGE_RATE_FOR_SEIHO_TANDOKU() throws Exception{

    return ACMessageBox.show("被保険者番号が「H」で始まっているため、生保単独とみなし" + ACConstants.LINE_SEPARATOR + "介護保険給付率を0%にします。" + ACConstants.LINE_SEPARATOR + "よろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「ログイン事業所が存在しません。ログアウトしてログイン事業所を選択してください。」を表示します。
   * <p>
   * 利用者一覧（請求）にてログイン事業所情報を取得できなかった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_ERROR_OF_NO_LOGIN_PROVIDER() throws Exception{

    return ACMessageBox.show("ログイン事業所が存在しません。ログアウトしてログイン事業所を選択してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データベースの変更確認のため、自動でログアウトします。」を表示します。
   * 
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_AUTO_LOGOUT() throws Exception{

    return ACMessageBox.show("データベースの変更確認のため、自動でログアウトします。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「接続確認用のデータベースファイルの削除に失敗しました。」を表示します。
   * <p>
   * 接続検証用テンポラリからファイルを削除する際にエラーが発生した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_DELETE_DBFILE_TEMP_FAILED() throws Exception{

    return ACMessageBox.show("接続確認用のデータベースファイルの削除に失敗しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「データの復元(リストア)に失敗しました。＜改行＞現在のデータベースの退避先にファイルを書き込む事ができません。」を表示します。
   * <p>
   * DB復元時、復元処理に失敗した場合のメッセージ
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_RESTORE_FAILED_COPY() throws Exception{

    return ACMessageBox.show("データの復元(リストア)に失敗しました。" + ACConstants.LINE_SEPARATOR + "現在のデータベースの退避先にファイルを書き込む事ができません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「有効な要介護認定履歴が存在しません。＜改行＞利用者情報を確認してください。」を表示します。
   * <p>
   * 保険者番号の欠如した認定履歴で印刷しようとした場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_EMPTY_PRINT() throws Exception{

    return ACMessageBox.show("有効な要介護認定履歴が存在しません。" + ACConstants.LINE_SEPARATOR + "利用者情報を確認してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「生保単独ではないため、0%以外の給付率を入力する必要があります。」を表示します。
   * <p>
   * 被保険者番号が「H」で始まらない場合に、給付率が「0%」に設定されていた場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU002_ERROR_OF_RATE_FOR_NOT_SEIHO_TANDOKU() throws Exception{

    return ACMessageBox.show("生保単独ではないため、0%以外の給付率を入力する必要があります。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「集計できない実績がありました。」を表示します。
   * <p>
   * 介護予防対応まで要支援１、要支援２の場合は作成されないさーびすこーどがあるため、エラーメッセージを表示し集計を中断する。
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_ERROR_OF_NURSING_NECESSARY_LEVEL() throws Exception{

    return ACMessageBox.show("集計できない実績がありました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[target]は[limit]としてください。」を表示します。
   * <p>
   * 時間帯等の範囲外エラーの場合
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_RANGE_OVER(VRMap param) throws Exception {
    return QS001_ERROR_OF_RANGE_OVER(

      VRBindPathParser.get("target", param)

      , VRBindPathParser.get("limit", param)

           );
  }
  /**
   * メッセージ「[target]は[limit]としてください。」を表示します。
   * <p>
   * 時間帯等の範囲外エラーの場合
   * </p>
   * @param arg1 target
   * @param arg2 limit
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_RANGE_OVER(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("は");

    sb.append(arg2);

    sb.append("としてください。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「介護支援専門員番号が未入力のサービスがあります。」を表示します。
   * <p>
   * 介護支援専門員番号未入力だった場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_WARNING_OF_SENMONIN_NO() throws Exception{

    return ACMessageBox.show("介護支援専門員番号が未入力のサービスがあります。", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「接続先の設定が不正です。＜改行＞接続先ホストやポート番号を見直してください。」を表示します。
   * <p>
   * 接続時エラー
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO013_ERROR_OF_CONECT() throws Exception{

    return ACMessageBox.show("接続先の設定が不正です。" + ACConstants.LINE_SEPARATOR + "接続先ホストやポート番号を見直してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「すべての患者を検索します。よろしいですか？＜改行＞※100件あたり5秒程度かかります。」を表示します。
   * <p>
   * 検索時
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO013_QUESTION_OF_FIND() throws Exception{

    return ACMessageBox.show("すべての患者を検索します。よろしいですか？" + ACConstants.LINE_SEPARATOR + "※100件あたり5秒程度かかります。", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「[State]に失敗しました。[Item]」を表示します。
   * <p>
   * 接続エラー（カスタム）
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO013_ERROR_OF_CONECT_CUSTOM(VRMap param) throws Exception {
    return QO013_ERROR_OF_CONECT_CUSTOM(

      VRBindPathParser.get("State", param)

      , VRBindPathParser.get("Item", param)

           );
  }
  /**
   * メッセージ「[State]に失敗しました。[Item]」を表示します。
   * <p>
   * 接続エラー（カスタム）
   * </p>
   * @param arg1 State
   * @param arg2 Item
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO013_ERROR_OF_CONECT_CUSTOM(

      Object arg1
      , Object arg2
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("に失敗しました。");

    sb.append(arg2);

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「DBSのバージョンが異なります。」を表示します。
   * <p>
   * 接続エラー（DBS）
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO013_ERROR_OF_CONECT_DATA_BASE_VERSION() throws Exception{

    return ACMessageBox.show("DBSのバージョンが異なります。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「設定ファイルへの書き込みに失敗しました。＜改行＞処理を中断します。」を表示します。
   * <p>
   * プロパティファイルへの書き込み失敗時
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO013_ERROR_OF_WRITE_PROPERTY() throws Exception{

    return ACMessageBox.show("設定ファイルへの書き込みに失敗しました。" + ACConstants.LINE_SEPARATOR + "処理を中断します。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「患者情報が存在しません。」を表示します。
   * <p>
   * 患者情報取得失敗時
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO013_NO_PATIENT() throws Exception{

    return ACMessageBox.show("患者情報が存在しません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「患者情報を取得しました。」を表示します。
   * <p>
   * 患者情報取得成功時
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO013_SUCCESS_PATIENT() throws Exception{

    return ACMessageBox.show("患者情報を取得しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「患者情報を取り込みました。」を表示します。
   * <p>
   * 患者情報取り込み成功時
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO013_SUCCESS_INSERT() throws Exception{

    return ACMessageBox.show("患者情報を取り込みました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「2件以上の保険情報が混在した領収書は作成できません。＜改行＞利用者情報を確認し、保険の有効期間ごとに分けて領収書を作成してください。」を表示します。
   * <p>
   * 2件以上の保険の有効期間をまたぐ請求期間を指定した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP011_ERROR_OF_MULTIPLE_INSURE_SPAN() throws Exception{

    return ACMessageBox.show("2件以上の保険情報が混在した領収書は作成できません。" + ACConstants.LINE_SEPARATOR + "利用者情報を確認し、保険の有効期間ごとに分けて領収書を作成してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「請求期間に有効な保険情報が存在しません。＜改行＞全額利用者負担として作成しますか？」を表示します。
   * <p>
   * 有効な保険情報が存在しない場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP011_WARNING_OF_INVALID_INSURE_SPAN() throws Exception{

    return ACMessageBox.show("請求期間に有効な保険情報が存在しません。" + ACConstants.LINE_SEPARATOR + "全額利用者負担として作成しますか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「消費税率を再設定します。よろしいですか？」を表示します。
   * <p>
   * 訪問看護療養費領収書編集にて税率再設定を行う場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP012_QUESTION_OF_TAX_CHANGE() throws Exception{

    return ACMessageBox.show("消費税率を再設定します。よろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「データベースの設定が完了していません。＜改行＞設定を更新後、いったん前画面に戻り、再度本画面を表示してください。」を表示します。
   * <p>
   * 消費税率を設定不能な状態で税率変更を行おうとした場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO005_ERROR_OF_DB_FAILED() throws Exception{

    return ACMessageBox.show("データベースの設定が完了していません。" + ACConstants.LINE_SEPARATOR + "設定を更新後、いったん前画面に戻り、再度本画面を表示してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「保険情報が変更されたため、請求期間の実績を読み込めません。＜改行＞（2件以上の保険情報が混在した領収書は作成できません。）」を表示します。
   * <p>
   * 2件以上の保険の有効期間をまたぐ請求期間を指定した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP012_ERROR_OF_MULTIPLE_INSURE_SPAN() throws Exception{

    return ACMessageBox.show("保険情報が変更されたため、請求期間の実績を読み込めません。" + ACConstants.LINE_SEPARATOR + "（2件以上の保険情報が混在した領収書は作成できません。）", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「請求期間に有効な保険情報が存在しません。＜改行＞全額利用者負担として実績を読み込みますか？」を表示します。
   * <p>
   * 有効な保険情報が存在しない場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP012_WARNING_OF_INVALID_INSURE_SPAN() throws Exception{

    return ACMessageBox.show("請求期間に有効な保険情報が存在しません。" + ACConstants.LINE_SEPARATOR + "全額利用者負担として実績を読み込みますか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「請求期間における訪問看護の実績を読み込みます。＜改行＞（現在入力されている提供日・保険適用負担は消えてしまいます。）＜改行＞よろしいですか？」を表示します。
   * <p>
   * 訪問看護療養費領収書編集で訪問看護の実績を読込む場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP012_WARNING_OF_OPEN_RESULT() throws Exception{

    return ACMessageBox.show("請求期間における訪問看護の実績を読み込みます。" + ACConstants.LINE_SEPARATOR + "（現在入力されている提供日・保険適用負担は消えてしまいます。）" + ACConstants.LINE_SEPARATOR + "よろしいですか？", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「印刷履歴を確定しますか？」を表示します。
   * <p>
   * 印刷済みにするかの確認
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP012_QUESTION_OF_PRINT_COMMIT() throws Exception{

    return ACMessageBox.show("印刷履歴を確定しますか？", ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_YES);

  }

  /**
   * メッセージ「領収額合計は999,999,999までとしてください。」を表示します。
   * <p>
   * 異常な高額を領収額合計とした場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP012_ERROR_OF_TOTAL_LIMIT_OVER() throws Exception{

    return ACMessageBox.show("領収額合計は999,999,999までとしてください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「CSV出力に失敗しました。＜改行＞処理を終了します。」を表示します。
   * <p>
   * FD容量が足りないなど、CSV出力に失敗した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_ERROR_OF_CSV_OUTPUT() throws Exception{

    return ACMessageBox.show("CSV出力に失敗しました。" + ACConstants.LINE_SEPARATOR + "処理を終了します。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「高齢7/8の指定に誤りがあります。＜改行＞印刷を実行しますか?」を表示します。
   * <p>
   * H18.9月以前に老人７割のデータが存在、もしくはH18.10以降に老人８割のデータが存在した場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_WARNING_OF_INJUSTICE_CLAIM() throws Exception{

    return ACMessageBox.show("高齢7/8の指定に誤りがあります。" + ACConstants.LINE_SEPARATOR + "印刷を実行しますか?", ACMessageBox.BUTTON_OK | ACMessageBox.BUTTON_CANCEL, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL);

  }

  /**
   * メッセージ「利用者負担の発生する利用者が選択されていません。＜改行＞印刷を中止します。」を表示します。
   * <p>
   * 利用者負担額の発生しない利用者のみが選択されている場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_ERROR_OF_PATIENT_SELF_NO_PRICE() throws Exception{

    return ACMessageBox.show("利用者負担の発生する利用者が選択されていません。" + ACConstants.LINE_SEPARATOR + "印刷を中止します。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「選択されている利用者の[reportName]の情報が存在しません。＜改行＞印刷を中止します。」を表示します。
   * <p>
   * 印刷対象の帳票データが1件も存在しない場合
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_ERROR_OF_EMPTY_DATA_REPORT_ONLY(VRMap param) throws Exception {
    return QU001_ERROR_OF_EMPTY_DATA_REPORT_ONLY(

      VRBindPathParser.get("reportName", param)

           );
  }
  /**
   * メッセージ「選択されている利用者の[reportName]の情報が存在しません。＜改行＞印刷を中止します。」を表示します。
   * <p>
   * 印刷対象の帳票データが1件も存在しない場合
   * </p>
   * @param arg1 reportName
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_ERROR_OF_EMPTY_DATA_REPORT_ONLY(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("選択されている利用者の");

    sb.append(arg1);

    sb.append("の情報が存在しません。" + ACConstants.LINE_SEPARATOR + "印刷を中止します。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「[reportName]の情報が存在しない利用者が含まれています。＜改行＞印刷してもよろしいですか？」を表示します。
   * <p>
   * 印刷対象に帳票データの存在しない対象者が含まれる場合
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_WARNING_OF_EMPTY_DATA_REPORT_MIXED(VRMap param) throws Exception {
    return QU001_WARNING_OF_EMPTY_DATA_REPORT_MIXED(

      VRBindPathParser.get("reportName", param)

           );
  }
  /**
   * メッセージ「[reportName]の情報が存在しない利用者が含まれています。＜改行＞印刷してもよろしいですか？」を表示します。
   * <p>
   * 印刷対象に帳票データの存在しない対象者が含まれる場合
   * </p>
   * @param arg1 reportName
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_WARNING_OF_EMPTY_DATA_REPORT_MIXED(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append(arg1);

    sb.append("の情報が存在しない利用者が含まれています。" + ACConstants.LINE_SEPARATOR + "印刷してもよろしいですか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_YES);

  }

  /**
   * メッセージ「印刷可能な[reportName]が選択されていません。＜改行＞表示されている利用者の印刷可能な[reportName]を印刷してもよろしいですか？」を表示します。
   * <p>
   * 印刷対象にチェックがついていない場合
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_WARNING_OF_PRINT_TARGET_NO_SELECT(VRMap param) throws Exception {
    return QU001_WARNING_OF_PRINT_TARGET_NO_SELECT(

      VRBindPathParser.get("reportName", param)

           );
  }
  /**
   * メッセージ「印刷可能な[reportName]が選択されていません。＜改行＞表示されている利用者の印刷可能な[reportName]を印刷してもよろしいですか？」を表示します。
   * <p>
   * 印刷対象にチェックがついていない場合
   * </p>
   * @param arg1 reportName
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_WARNING_OF_PRINT_TARGET_NO_SELECT(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("印刷可能な");

    sb.append(arg1);

    sb.append("が選択されていません。" + ACConstants.LINE_SEPARATOR + "表示されている利用者の印刷可能な");

    sb.append(arg1);

    sb.append("を印刷してもよろしいですか？");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_NO);

  }

  /**
   * メッセージ「印刷に失敗しました。」を表示します。
   * <p>
   * 印刷処理に失敗した場合、原則出ることはない
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int ERROR_OF_PRINT() throws Exception{

    return ACMessageBox.show("印刷に失敗しました。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_INFOMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「利用者負担の発生しない利用者が含まれています。＜改行＞印刷してもよろしいですか？」を表示します。
   * <p>
   * 利用者向け請求書選択バージョンの印刷
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QP001_WARNING_OF_CUSTOM_PRINT() throws Exception{

    return ACMessageBox.showYesNoCancel("利用者負担の発生しない利用者が含まれています。" + ACConstants.LINE_SEPARATOR + "印刷してもよろしいですか？", "印刷する(全て)(O)", 'O', "印刷する(請求あり)(N)", 'N', ACMessageBox.FOCUS_NO);

  }

  /**
   * メッセージ「利用者負担の発生しない利用者が選択されています。＜改行＞印刷してもよろしいですか？」を表示します。
   * <p>
   * 印刷対象が存在しないが印刷する場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_WARNING_OF_EMPTY_DATA_REPORT_ONLY() throws Exception{

    return ACMessageBox.show("利用者負担の発生しない利用者が選択されています。" + ACConstants.LINE_SEPARATOR + "印刷してもよろしいですか？", ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_YES);

  }

  /**
   * メッセージ「印刷済みの[reportName]です。＜改行＞更新すると印刷済みでなくなります。＜改行＞更新してもよろしいですか？＜改行＞（印刷済みにする場合は再度印刷を行う必要があります。）」を表示します。
   * <p>
   * 既に印刷済みの居宅量管理指導書を保存する場合
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO(VRMap param) throws Exception {
    return QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO(

      VRBindPathParser.get("reportName", param)

           );
  }
  /**
   * メッセージ「印刷済みの[reportName]です。＜改行＞更新すると印刷済みでなくなります。＜改行＞更新してもよろしいですか？＜改行＞（印刷済みにする場合は再度印刷を行う必要があります。）」を表示します。
   * <p>
   * 既に印刷済みの居宅量管理指導書を保存する場合
   * </p>
   * @param arg1 reportName
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QC005_WARNING_OF_PRINTED_KYOTAKU_RYOYO(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("印刷済みの");

    sb.append(arg1);

    sb.append("です。" + ACConstants.LINE_SEPARATOR + "更新すると印刷済みでなくなります。" + ACConstants.LINE_SEPARATOR + "更新してもよろしいですか？" + ACConstants.LINE_SEPARATOR + "（印刷済みにする場合は再度印刷を行う必要があります。）");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_YES | ACMessageBox.BUTTON_NO, ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_NO);

  }

  /**
   * メッセージ「印刷可能な[reportName]が選択されていません。＜改行＞[reportName]の情報を保存することで印刷することが可能です。」を表示します。
   * <p>
   * 印刷不可能な場合
   * </p>
   * @param param パラメタ
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_ERROR_OF_NO_PRINT_DATA(VRMap param) throws Exception {
    return QU001_ERROR_OF_NO_PRINT_DATA(

      VRBindPathParser.get("reportName", param)

           );
  }
  /**
   * メッセージ「印刷可能な[reportName]が選択されていません。＜改行＞[reportName]の情報を保存することで印刷することが可能です。」を表示します。
   * <p>
   * 印刷不可能な場合
   * </p>
   * @param arg1 reportName
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QU001_ERROR_OF_NO_PRINT_DATA(

      Object arg1
                        ) throws Exception{
    StringBuffer sb = new StringBuffer();

    sb.append("印刷可能な");

    sb.append(arg1);

    sb.append("が選択されていません。" + ACConstants.LINE_SEPARATOR + "");

    sb.append(arg1);

    sb.append("の情報を保存することで印刷することが可能です。");

    return ACMessageBox.show(sb.toString(), ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「サービスパターン名が未入力です。」を表示します。
   * <p>
   * サービスパターン名が入力されていない場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_SERVICE_PATTERN_NAME() throws Exception{

    return ACMessageBox.show("サービスパターン名が未入力です。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「摘要欄に値を設定する場合は、数字6桁を設定してください。」を表示します。
   * <p>
   * 摘要欄に数値6桁以外が入力されている場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QS001_ERROR_OF_TEKIYOU_INPUT() throws Exception{

    return ACMessageBox.show("摘要欄に値を設定する場合は、数字6桁を設定してください。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

  /**
   * メッセージ「入力されたパスワードに空白文字が含まれています。＜改行＞空白文字を含んだパスワードは使用できません。」を表示します。
   * <p>
   * 日レセ連係時に空白を含むパスワードが設定されていた場合
   * </p>
   * @throws Exception 処理例外
   * @return 選択したボタンID
   */
  public int QO013_ERROR_OF_BLANK_IN_PASSWORD() throws Exception{

    return ACMessageBox.show("入力されたパスワードに空白文字が含まれています。" + ACConstants.LINE_SEPARATOR + "空白文字を含んだパスワードは使用できません。", ACMessageBox.BUTTON_OK, ACMessageBox.ICON_EXCLAMATION, ACMessageBox.FOCUS_OK);

  }

}
