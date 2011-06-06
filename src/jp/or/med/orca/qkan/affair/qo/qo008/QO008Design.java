
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
 * 作成日: 2010/11/15  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 定型文管理 (008)
 * プログラム 定型文項目一覧 (QO008)
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
/**
 * 定型文項目一覧画面項目デザイン(QO008) 
 */
public class QO008Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar Buttons;

  private ACAffairButton update;

  private ACPanel contents;

  private VRLayout contentLayout;

  private ACPanel fixedFormPanels;

  private ACPanel fixedFormPanel;

  private ACGroupBox fixedForm;

  private VRLayout fixedFormLayout;

  private ACLabel fixedFormLabel;

  private ACTable fixedFormTable;

  private VRTableColumnModel fixedFormTableColumnModel;

  private ACTableColumn fixedFormTableColumn１;

  private ACTableColumn fixedFormTableColumn２;

  private ACTableColumn fixedFormTableColumn３;

  private ACPanel fixedFormEdits;

  private ACGroupBox fixedFormEdit;

  private VRLayout fixedFormEditLayout;

  private ACPanel fixedFormEditComments;

  private VRLayout fixedFormEditCommentLayout;

  private ACLabel fixedFormEditComment1;

  private ACLabel fixedFormEditComment2;

  private ACPanel fixedFormEdititemAndItemManipulateButtons;

  private ACPanel fixedFormEdititems;

  private ACTable fixedFormEditItemTable;

  private VRTableColumnModel fixedFormEditItemTableColumnModel;

  private ACTableColumn fixedFormEditItemTableColumn1;

  private ACTableColumn fixedFormEditItemTableColumn2;

  private ACTableColumn fixedFormEditItemTableColumn4;

  private ACTableColumn fixedFormEditItemTableColumn3;

  private ACPanel fixedFormEditItemManipulateButtons;

  private ACButton fixedFormEditItemManipulateButtonUp;

  private ACButton fixedFormEditItemManipulateButtonDown;

  private ACPanel fixedFormEditInputAndCompileTextBoxs;

  private ACPanel fixedFormEditInputLefts;

  private ACLabel fixedFormEditInputLeft;

  private ACLabel fixedFormEditInputCaption1;

  private ACLabel fixedFormEditInputCaption2;

  private ACLabel fixedFormEditInputCaption3;

  private ACPanel fixedFormEditInputCaptions;

  private VRLayout fixedFormEditInputCaptionLayout;

  private ACTextField fixedFormEditInputAndCompileTextBox;

  private ACLabelContainer fixedFormEditInputAndCompileTextBoxContainer;

  private ACPanel fixedFormEditDownButtons;

  private ACButton fixedFormEditInsert;

  private ACButton fixedFormEditUpdate;

  private ACButton fixedFormEditDelete;

  private ACButton fixedFormEditCancelDelete;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(Buttons==null){

      Buttons = new ACAffairButtonBar();

      Buttons.setText("定型文編集");

      addButtons();
    }
    return Buttons;

  }

  /**
   * 更新ボタンを取得します。
   * @return 更新ボタン
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("更新(S)");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setLayout(getContentLayout());

      addContents();
    }
    return contents;

  }

  /**
   * クライアント領域・レイアウトを取得します。
   * @return クライアント領域・レイアウト
   */
  public VRLayout getContentLayout(){
    if(contentLayout==null){

      contentLayout = new VRLayout();

      addContentLayout();
    }
    return contentLayout;

  }

  /**
   * 定型文項目一覧・パネルを取得します。
   * @return 定型文項目一覧・パネル
   */
  public ACPanel getFixedFormPanels(){
    if(fixedFormPanels==null){

      fixedFormPanels = new ACPanel();

      addFixedFormPanels();
    }
    return fixedFormPanels;

  }

  /**
   * 定型文項目選択パネルを取得します。
   * @return 定型文項目選択パネル
   */
  public ACPanel getFixedFormPanel(){
    if(fixedFormPanel==null){

      fixedFormPanel = new ACPanel();

      addFixedFormPanel();
    }
    return fixedFormPanel;

  }

  /**
   * 定型文項目選択フレームを取得します。
   * @return 定型文項目選択フレーム
   */
  public ACGroupBox getFixedForm(){
    if(fixedForm==null){

      fixedForm = new ACGroupBox();

      fixedForm.setText("定型文項目選択");

      fixedForm.setLayout(getFixedFormLayout());

      addFixedForm();
    }
    return fixedForm;

  }

  /**
   * 定型文項目選択レイアウトを取得します。
   * @return 定型文項目選択レイアウト
   */
  public VRLayout getFixedFormLayout(){
    if(fixedFormLayout==null){

      fixedFormLayout = new VRLayout();

      fixedFormLayout.setHgap(0);

      addFixedFormLayout();
    }
    return fixedFormLayout;

  }

  /**
   * 定型分項目選択ラベルを取得します。
   * @return 定型分項目選択ラベル
   */
  public ACLabel getFixedFormLabel(){
    if(fixedFormLabel==null){

      fixedFormLabel = new ACLabel();

      fixedFormLabel.setText("編集したい定型文項目を選択してください。");

      addFixedFormLabel();
    }
    return fixedFormLabel;

  }

  /**
   * 定型分項目選択テーブルを取得します。
   * @return 定型分項目選択テーブル
   */
  public ACTable getFixedFormTable(){
    if(fixedFormTable==null){

      fixedFormTable = new ACTable();

      fixedFormTable.setColumnModel(getFixedFormTableColumnModel());

      fixedFormTable.setPreferredSize(new Dimension(700,140));

      addFixedFormTable();
    }
    return fixedFormTable;

  }

  /**
   * 定型分項目選択テーブルカラムモデルを取得します。
   * @return 定型分項目選択テーブルカラムモデル
   */
  protected VRTableColumnModel getFixedFormTableColumnModel(){
    if(fixedFormTableColumnModel==null){
      fixedFormTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addFixedFormTableColumnModel();
    }
    return fixedFormTableColumnModel;
  }

  /**
   * テーブル：No.を取得します。
   * @return テーブル：No.
   */
  public ACTableColumn getFixedFormTableColumn１(){
    if(fixedFormTableColumn１==null){

      fixedFormTableColumn１ = new ACTableColumn();

      fixedFormTableColumn１.setHeaderValue("No.");

      fixedFormTableColumn１.setColumns(4);

      fixedFormTableColumn１.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      fixedFormTableColumn１.setSortable(false);

      addFixedFormTableColumn１();
    }
    return fixedFormTableColumn１;

  }

  /**
   * テーブル：分類を取得します。
   * @return テーブル：分類
   */
  public ACTableColumn getFixedFormTableColumn２(){
    if(fixedFormTableColumn２==null){

      fixedFormTableColumn２ = new ACTableColumn();

      fixedFormTableColumn２.setHeaderValue("分類");

      fixedFormTableColumn２.setColumnName("FIXED_FORM_GROUP");

      fixedFormTableColumn２.setColumns(14);

      addFixedFormTableColumn２();
    }
    return fixedFormTableColumn２;

  }

  /**
   * テーブル：項目を取得します。
   * @return テーブル：項目
   */
  public ACTableColumn getFixedFormTableColumn３(){
    if(fixedFormTableColumn３==null){

      fixedFormTableColumn３ = new ACTableColumn();

      fixedFormTableColumn３.setHeaderValue("項目");

      fixedFormTableColumn３.setColumnName("FIXED_FORM_TITLE");

      fixedFormTableColumn３.setColumns(10);

      addFixedFormTableColumn３();
    }
    return fixedFormTableColumn３;

  }

  /**
   * 定型文編集パネルを取得します。
   * @return 定型文編集パネル
   */
  public ACPanel getFixedFormEdits(){
    if(fixedFormEdits==null){

      fixedFormEdits = new ACPanel();

      addFixedFormEdits();
    }
    return fixedFormEdits;

  }

  /**
   * 定型文編集・フレームを取得します。
   * @return 定型文編集・フレーム
   */
  public ACGroupBox getFixedFormEdit(){
    if(fixedFormEdit==null){

      fixedFormEdit = new ACGroupBox();

      fixedFormEdit.setText("定型文編集");

      fixedFormEdit.setLayout(getFixedFormEditLayout());

      addFixedFormEdit();
    }
    return fixedFormEdit;

  }

  /**
   * 定型文編集パネル・レイアウトを取得します。
   * @return 定型文編集パネル・レイアウト
   */
  public VRLayout getFixedFormEditLayout(){
    if(fixedFormEditLayout==null){

      fixedFormEditLayout = new VRLayout();

      addFixedFormEditLayout();
    }
    return fixedFormEditLayout;

  }

  /**
   * コメント領域を取得します。
   * @return コメント領域
   */
  public ACPanel getFixedFormEditComments(){
    if(fixedFormEditComments==null){

      fixedFormEditComments = new ACPanel();

      fixedFormEditComments.setLayout(getFixedFormEditCommentLayout());

      addFixedFormEditComments();
    }
    return fixedFormEditComments;

  }

  /**
   * コメント領域・レイアウトを取得します。
   * @return コメント領域・レイアウト
   */
  public VRLayout getFixedFormEditCommentLayout(){
    if(fixedFormEditCommentLayout==null){

      fixedFormEditCommentLayout = new VRLayout();

      fixedFormEditCommentLayout.setHgap(0);

      addFixedFormEditCommentLayout();
    }
    return fixedFormEditCommentLayout;

  }

  /**
   * コメント・ラベル1を取得します。
   * @return コメント・ラベル1
   */
  public ACLabel getFixedFormEditComment1(){
    if(fixedFormEditComment1==null){

      fixedFormEditComment1 = new ACLabel();

      fixedFormEditComment1.setText("[変更]もしくは[削除]したい項目を候補リストから選んでください。");

      addFixedFormEditComment1();
    }
    return fixedFormEditComment1;

  }

  /**
   * コメント・ラベル2を取得します。
   * @return コメント・ラベル2
   */
  public ACLabel getFixedFormEditComment2(){
    if(fixedFormEditComment2==null){

      fixedFormEditComment2 = new ACLabel();

      fixedFormEditComment2.setText("[追加]の時は下のテキストボックスに入力して[追加]を押してください。");

      addFixedFormEditComment2();
    }
    return fixedFormEditComment2;

  }

  /**
   * 項目・項目操作ボタン領域を取得します。
   * @return 項目・項目操作ボタン領域
   */
  public ACPanel getFixedFormEdititemAndItemManipulateButtons(){
    if(fixedFormEdititemAndItemManipulateButtons==null){

      fixedFormEdititemAndItemManipulateButtons = new ACPanel();

      addFixedFormEdititemAndItemManipulateButtons();
    }
    return fixedFormEdititemAndItemManipulateButtons;

  }

  /**
   * 項目領域を取得します。
   * @return 項目領域
   */
  public ACPanel getFixedFormEdititems(){
    if(fixedFormEdititems==null){

      fixedFormEdititems = new ACPanel();

      fixedFormEdititems.setHgap(0);

      addFixedFormEdititems();
    }
    return fixedFormEdititems;

  }

  /**
   * 項目テーブルを取得します。
   * @return 項目テーブル
   */
  public ACTable getFixedFormEditItemTable(){
    if(fixedFormEditItemTable==null){

      fixedFormEditItemTable = new ACTable();

      fixedFormEditItemTable.setColumnModel(getFixedFormEditItemTableColumnModel());

      fixedFormEditItemTable.setPreferredSize(new Dimension(700,220));

      addFixedFormEditItemTable();
    }
    return fixedFormEditItemTable;

  }

  /**
   * 項目テーブルカラムモデルを取得します。
   * @return 項目テーブルカラムモデル
   */
  protected VRTableColumnModel getFixedFormEditItemTableColumnModel(){
    if(fixedFormEditItemTableColumnModel==null){
      fixedFormEditItemTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addFixedFormEditItemTableColumnModel();
    }
    return fixedFormEditItemTableColumnModel;
  }

  /**
   * テーブル：No.を取得します。
   * @return テーブル：No.
   */
  public ACTableColumn getFixedFormEditItemTableColumn1(){
    if(fixedFormEditItemTableColumn1==null){

      fixedFormEditItemTableColumn1 = new ACTableColumn();

      fixedFormEditItemTableColumn1.setHeaderValue("No.");

      fixedFormEditItemTableColumn1.setColumns(4);

      fixedFormEditItemTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      fixedFormEditItemTableColumn1.setSortable(false);

      addFixedFormEditItemTableColumn1();
    }
    return fixedFormEditItemTableColumn1;

  }

  /**
   * テーブル：処理モードを取得します。
   * @return テーブル：処理モード
   */
  public ACTableColumn getFixedFormEditItemTableColumn2(){
    if(fixedFormEditItemTableColumn2==null){

      fixedFormEditItemTableColumn2 = new ACTableColumn();

      fixedFormEditItemTableColumn2.setHeaderValue("処理");

      fixedFormEditItemTableColumn2.setColumns(4);

      fixedFormEditItemTableColumn2.setRendererType(ACTableCellViewer.RENDERER_TYPE_STATE_ICON);

      fixedFormEditItemTableColumn2.setSortable(false);

      addFixedFormEditItemTableColumn2();
    }
    return fixedFormEditItemTableColumn2;

  }

  /**
   * サービス種類を取得します。
   * @return サービス種類
   */
  public ACTableColumn getFixedFormEditItemTableColumn4(){
    if(fixedFormEditItemTableColumn4==null){

      fixedFormEditItemTableColumn4 = new ACTableColumn();

      fixedFormEditItemTableColumn4.setHeaderValue("サービス種類");

      fixedFormEditItemTableColumn4.setColumnName("SERVICE_CODE_KIND");

      fixedFormEditItemTableColumn4.setColumns(14);

      fixedFormEditItemTableColumn4.setFormat(QkanServiceKindNameFormat.getInstance());

      fixedFormEditItemTableColumn4.setSortable(false);

      addFixedFormEditItemTableColumn4();
    }
    return fixedFormEditItemTableColumn4;

  }

  /**
   * テーブル：内容を取得します。
   * @return テーブル：内容
   */
  public ACTableColumn getFixedFormEditItemTableColumn3(){
    if(fixedFormEditItemTableColumn3==null){

      fixedFormEditItemTableColumn3 = new ACTableColumn();

      fixedFormEditItemTableColumn3.setHeaderValue("内容");

      fixedFormEditItemTableColumn3.setColumnName("CONTENT");

      fixedFormEditItemTableColumn3.setColumns(25);

      fixedFormEditItemTableColumn3.setSortable(false);

      addFixedFormEditItemTableColumn3();
    }
    return fixedFormEditItemTableColumn3;

  }

  /**
   * 項目操作ボタン領域を取得します。
   * @return 項目操作ボタン領域
   */
  public ACPanel getFixedFormEditItemManipulateButtons(){
    if(fixedFormEditItemManipulateButtons==null){

      fixedFormEditItemManipulateButtons = new ACPanel();

      addFixedFormEditItemManipulateButtons();
    }
    return fixedFormEditItemManipulateButtons;

  }

  /**
   * 上へボタンを取得します。
   * @return 上へボタン
   */
  public ACButton getFixedFormEditItemManipulateButtonUp(){
    if(fixedFormEditItemManipulateButtonUp==null){

      fixedFormEditItemManipulateButtonUp = new ACButton();

      fixedFormEditItemManipulateButtonUp.setText("上へ");

      addFixedFormEditItemManipulateButtonUp();
    }
    return fixedFormEditItemManipulateButtonUp;

  }

  /**
   * 下へボタンを取得します。
   * @return 下へボタン
   */
  public ACButton getFixedFormEditItemManipulateButtonDown(){
    if(fixedFormEditItemManipulateButtonDown==null){

      fixedFormEditItemManipulateButtonDown = new ACButton();

      fixedFormEditItemManipulateButtonDown.setText("下へ");

      addFixedFormEditItemManipulateButtonDown();
    }
    return fixedFormEditItemManipulateButtonDown;

  }

  /**
   * 入力・編集テキストボックス領域を取得します。
   * @return 入力・編集テキストボックス領域
   */
  public ACPanel getFixedFormEditInputAndCompileTextBoxs(){
    if(fixedFormEditInputAndCompileTextBoxs==null){

      fixedFormEditInputAndCompileTextBoxs = new ACPanel();

      addFixedFormEditInputAndCompileTextBoxs();
    }
    return fixedFormEditInputAndCompileTextBoxs;

  }

  /**
   * 入力・編集ラベル領域を取得します。
   * @return 入力・編集ラベル領域
   */
  public ACPanel getFixedFormEditInputLefts(){
    if(fixedFormEditInputLefts==null){

      fixedFormEditInputLefts = new ACPanel();

      addFixedFormEditInputLefts();
    }
    return fixedFormEditInputLefts;

  }

  /**
   * 入力・編集テキストボックスラベルを取得します。
   * @return 入力・編集テキストボックスラベル
   */
  public ACLabel getFixedFormEditInputLeft(){
    if(fixedFormEditInputLeft==null){

      fixedFormEditInputLeft = new ACLabel();

      fixedFormEditInputLeft.setText("入力・編集欄");

      addFixedFormEditInputLeft();
    }
    return fixedFormEditInputLeft;

  }

  /**
   * 入力・編集キャプションラベル1を取得します。
   * @return 入力・編集キャプションラベル1
   */
  public ACLabel getFixedFormEditInputCaption1(){
    if(fixedFormEditInputCaption1==null){

      fixedFormEditInputCaption1 = new ACLabel();

      fixedFormEditInputCaption1.setText("(");

      addFixedFormEditInputCaption1();
    }
    return fixedFormEditInputCaption1;

  }

  /**
   * 入力・編集キャプションラベル2を取得します。
   * @return 入力・編集キャプションラベル2
   */
  public ACLabel getFixedFormEditInputCaption2(){
    if(fixedFormEditInputCaption2==null){

      fixedFormEditInputCaption2 = new ACLabel();

      fixedFormEditInputCaption2.setText("100");

      addFixedFormEditInputCaption2();
    }
    return fixedFormEditInputCaption2;

  }

  /**
   * 入力・編集キャプションラベル3を取得します。
   * @return 入力・編集キャプションラベル3
   */
  public ACLabel getFixedFormEditInputCaption3(){
    if(fixedFormEditInputCaption3==null){

      fixedFormEditInputCaption3 = new ACLabel();

      fixedFormEditInputCaption3.setText("文字以内)");

      addFixedFormEditInputCaption3();
    }
    return fixedFormEditInputCaption3;

  }

  /**
   * 入力・編集テキストボックス領域を取得します。
   * @return 入力・編集テキストボックス領域
   */
  public ACPanel getFixedFormEditInputCaptions(){
    if(fixedFormEditInputCaptions==null){

      fixedFormEditInputCaptions = new ACPanel();

      fixedFormEditInputCaptions.setLayout(getFixedFormEditInputCaptionLayout());

      addFixedFormEditInputCaptions();
    }
    return fixedFormEditInputCaptions;

  }

  /**
   * 入力・編集テキストボックス領域・レイアウトを取得します。
   * @return 入力・編集テキストボックス領域・レイアウト
   */
  public VRLayout getFixedFormEditInputCaptionLayout(){
    if(fixedFormEditInputCaptionLayout==null){

      fixedFormEditInputCaptionLayout = new VRLayout();

      fixedFormEditInputCaptionLayout.setHgap(0);

      addFixedFormEditInputCaptionLayout();
    }
    return fixedFormEditInputCaptionLayout;

  }

  /**
   * 入力・編集テキストボックスを取得します。
   * @return 入力・編集テキストボックス
   */
  public ACTextField getFixedFormEditInputAndCompileTextBox(){
    if(fixedFormEditInputAndCompileTextBox==null){

      fixedFormEditInputAndCompileTextBox = new ACTextField();

      fixedFormEditInputAndCompileTextBox.setBindPath("CONTENT");

      fixedFormEditInputAndCompileTextBox.setColumns(60);

      fixedFormEditInputAndCompileTextBox.setIMEMode(InputSubset.KANJI);

      fixedFormEditInputAndCompileTextBox.setMaxLength(100);

      addFixedFormEditInputAndCompileTextBox();
    }
    return fixedFormEditInputAndCompileTextBox;

  }

  /**
   * 入力・編集テキストボックスコンテナを取得します。
   * @return 入力・編集テキストボックスコンテナ
   */
  protected ACLabelContainer getFixedFormEditInputAndCompileTextBoxContainer(){
    if(fixedFormEditInputAndCompileTextBoxContainer==null){
      fixedFormEditInputAndCompileTextBoxContainer = new ACLabelContainer();
      fixedFormEditInputAndCompileTextBoxContainer.setFollowChildEnabled(true);
      fixedFormEditInputAndCompileTextBoxContainer.setVAlignment(VRLayout.CENTER);
      fixedFormEditInputAndCompileTextBoxContainer.add(getFixedFormEditInputAndCompileTextBox(), VRLayout.CLIENT);
    }
    return fixedFormEditInputAndCompileTextBoxContainer;
  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getFixedFormEditDownButtons(){
    if(fixedFormEditDownButtons==null){

      fixedFormEditDownButtons = new ACPanel();

      addFixedFormEditDownButtons();
    }
    return fixedFormEditDownButtons;

  }

  /**
   * 追加ボタンを取得します。
   * @return 追加ボタン
   */
  public ACButton getFixedFormEditInsert(){
    if(fixedFormEditInsert==null){

      fixedFormEditInsert = new ACButton();

      fixedFormEditInsert.setText("追加");

      fixedFormEditInsert.setToolTipText("定型文を追加します。");

      fixedFormEditInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addFixedFormEditInsert();
    }
    return fixedFormEditInsert;

  }

  /**
   * 編集ボタンを取得します。
   * @return 編集ボタン
   */
  public ACButton getFixedFormEditUpdate(){
    if(fixedFormEditUpdate==null){

      fixedFormEditUpdate = new ACButton();

      fixedFormEditUpdate.setText("編集");

      fixedFormEditUpdate.setToolTipText("定型文を変更します。");

      fixedFormEditUpdate.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addFixedFormEditUpdate();
    }
    return fixedFormEditUpdate;

  }

  /**
   * 削除ボタンを取得します。
   * @return 削除ボタン
   */
  public ACButton getFixedFormEditDelete(){
    if(fixedFormEditDelete==null){

      fixedFormEditDelete = new ACButton();

      fixedFormEditDelete.setText("削除");

      fixedFormEditDelete.setToolTipText("定型文を削除します。");

      fixedFormEditDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addFixedFormEditDelete();
    }
    return fixedFormEditDelete;

  }

  /**
   * 削除取消ボタンを取得します。
   * @return 削除取消ボタン
   */
  public ACButton getFixedFormEditCancelDelete(){
    if(fixedFormEditCancelDelete==null){

      fixedFormEditCancelDelete = new ACButton();

      fixedFormEditCancelDelete.setText("削除取消");

      fixedFormEditCancelDelete.setToolTipText("定型文の削除を取り消します。");

      fixedFormEditCancelDelete.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addFixedFormEditCancelDelete();
    }
    return fixedFormEditCancelDelete;

  }

  /**
   * コンストラクタです。
   */
  public QO008Design() {

    try {
      initialize();

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身の設定を行ないます。
   */
  protected void initThis(){
  }

  /**
   * thisに内部項目を追加します。
   */
  protected void addThis(){

    this.add(getButtons(), VRLayout.NORTH);

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    Buttons.add(getUpdate(), VRLayout.EAST);
  }

  /**
   * 更新ボタンに内部項目を追加します。
   */
  protected void addUpdate(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getFixedFormPanels(), VRLayout.CLIENT);

  }

  /**
   * クライアント領域・レイアウトに内部項目を追加します。
   */
  protected void addContentLayout(){

  }

  /**
   * 定型文項目一覧・パネルに内部項目を追加します。
   */
  protected void addFixedFormPanels(){

    fixedFormPanels.add(getFixedFormPanel(), VRLayout.NORTH);

    fixedFormPanels.add(getFixedFormEdits(), VRLayout.NORTH);

  }

  /**
   * 定型文項目選択パネルに内部項目を追加します。
   */
  protected void addFixedFormPanel(){

    fixedFormPanel.add(getFixedForm(), VRLayout.FLOW);

  }

  /**
   * 定型文項目選択フレームに内部項目を追加します。
   */
  protected void addFixedForm(){

    fixedForm.add(getFixedFormLabel(), VRLayout.NORTH);

    fixedForm.add(getFixedFormTable(), VRLayout.FLOW);

  }

  /**
   * 定型文項目選択レイアウトに内部項目を追加します。
   */
  protected void addFixedFormLayout(){

  }

  /**
   * 定型分項目選択ラベルに内部項目を追加します。
   */
  protected void addFixedFormLabel(){

  }

  /**
   * 定型分項目選択テーブルに内部項目を追加します。
   */
  protected void addFixedFormTable(){

  }

  /**
   * 定型分項目選択テーブルカラムモデルに内部項目を追加します。
   */
  protected void addFixedFormTableColumnModel(){

    getFixedFormTableColumnModel().addColumn(getFixedFormTableColumn１());

    getFixedFormTableColumnModel().addColumn(getFixedFormTableColumn２());

    getFixedFormTableColumnModel().addColumn(getFixedFormTableColumn３());

  }

  /**
   * テーブル：No.に内部項目を追加します。
   */
  protected void addFixedFormTableColumn１(){

  }

  /**
   * テーブル：分類に内部項目を追加します。
   */
  protected void addFixedFormTableColumn２(){

  }

  /**
   * テーブル：項目に内部項目を追加します。
   */
  protected void addFixedFormTableColumn３(){

  }

  /**
   * 定型文編集パネルに内部項目を追加します。
   */
  protected void addFixedFormEdits(){

    fixedFormEdits.add(getFixedFormEdit(), VRLayout.FLOW);

  }

  /**
   * 定型文編集・フレームに内部項目を追加します。
   */
  protected void addFixedFormEdit(){

    fixedFormEdit.add(getFixedFormEditComments(), VRLayout.NORTH);

    fixedFormEdit.add(getFixedFormEdititemAndItemManipulateButtons(), VRLayout.NORTH);

    fixedFormEdit.add(getFixedFormEditInputAndCompileTextBoxs(), VRLayout.NORTH);

    fixedFormEdit.add(getFixedFormEditDownButtons(), VRLayout.NORTH);

  }

  /**
   * 定型文編集パネル・レイアウトに内部項目を追加します。
   */
  protected void addFixedFormEditLayout(){

  }

  /**
   * コメント領域に内部項目を追加します。
   */
  protected void addFixedFormEditComments(){

    fixedFormEditComments.add(getFixedFormEditComment1(), VRLayout.FLOW_RETURN);

    fixedFormEditComments.add(getFixedFormEditComment2(), VRLayout.FLOW);

  }

  /**
   * コメント領域・レイアウトに内部項目を追加します。
   */
  protected void addFixedFormEditCommentLayout(){

  }

  /**
   * コメント・ラベル1に内部項目を追加します。
   */
  protected void addFixedFormEditComment1(){

  }

  /**
   * コメント・ラベル2に内部項目を追加します。
   */
  protected void addFixedFormEditComment2(){

  }

  /**
   * 項目・項目操作ボタン領域に内部項目を追加します。
   */
  protected void addFixedFormEdititemAndItemManipulateButtons(){

    fixedFormEdititemAndItemManipulateButtons.add(getFixedFormEdititems(), VRLayout.WEST);

    fixedFormEdititemAndItemManipulateButtons.add(getFixedFormEditItemManipulateButtons(), VRLayout.WEST);

  }

  /**
   * 項目領域に内部項目を追加します。
   */
  protected void addFixedFormEdititems(){

    fixedFormEdititems.add(getFixedFormEditItemTable(), VRLayout.FLOW);

  }

  /**
   * 項目テーブルに内部項目を追加します。
   */
  protected void addFixedFormEditItemTable(){

  }

  /**
   * 項目テーブルカラムモデルに内部項目を追加します。
   */
  protected void addFixedFormEditItemTableColumnModel(){

    getFixedFormEditItemTableColumnModel().addColumn(getFixedFormEditItemTableColumn1());

    getFixedFormEditItemTableColumnModel().addColumn(getFixedFormEditItemTableColumn2());

    getFixedFormEditItemTableColumnModel().addColumn(getFixedFormEditItemTableColumn4());

    getFixedFormEditItemTableColumnModel().addColumn(getFixedFormEditItemTableColumn3());

  }

  /**
   * テーブル：No.に内部項目を追加します。
   */
  protected void addFixedFormEditItemTableColumn1(){

  }

  /**
   * テーブル：処理モードに内部項目を追加します。
   */
  protected void addFixedFormEditItemTableColumn2(){

  }

  /**
   * サービス種類に内部項目を追加します。
   */
  protected void addFixedFormEditItemTableColumn4(){

  }

  /**
   * テーブル：内容に内部項目を追加します。
   */
  protected void addFixedFormEditItemTableColumn3(){

  }

  /**
   * 項目操作ボタン領域に内部項目を追加します。
   */
  protected void addFixedFormEditItemManipulateButtons(){

    fixedFormEditItemManipulateButtons.add(getFixedFormEditItemManipulateButtonUp(), VRLayout.FLOW_RETURN);

    fixedFormEditItemManipulateButtons.add(getFixedFormEditItemManipulateButtonDown(), VRLayout.FLOW_RETURN);

  }

  /**
   * 上へボタンに内部項目を追加します。
   */
  protected void addFixedFormEditItemManipulateButtonUp(){

  }

  /**
   * 下へボタンに内部項目を追加します。
   */
  protected void addFixedFormEditItemManipulateButtonDown(){

  }

  /**
   * 入力・編集テキストボックス領域に内部項目を追加します。
   */
  protected void addFixedFormEditInputAndCompileTextBoxs(){

    fixedFormEditInputAndCompileTextBoxs.add(getFixedFormEditInputLefts(), VRLayout.NORTH);

    fixedFormEditInputAndCompileTextBoxs.add(getFixedFormEditInputCaptions(), VRLayout.FLOW);

  }

  /**
   * 入力・編集ラベル領域に内部項目を追加します。
   */
  protected void addFixedFormEditInputLefts(){

    fixedFormEditInputLefts.add(getFixedFormEditInputLeft(), VRLayout.WEST);

    fixedFormEditInputLefts.add(getFixedFormEditInputCaption3(), VRLayout.EAST);
    fixedFormEditInputLefts.add(getFixedFormEditInputCaption2(), VRLayout.EAST);
    fixedFormEditInputLefts.add(getFixedFormEditInputCaption1(), VRLayout.EAST);
  }

  /**
   * 入力・編集テキストボックスラベルに内部項目を追加します。
   */
  protected void addFixedFormEditInputLeft(){

  }

  /**
   * 入力・編集キャプションラベル1に内部項目を追加します。
   */
  protected void addFixedFormEditInputCaption1(){

  }

  /**
   * 入力・編集キャプションラベル2に内部項目を追加します。
   */
  protected void addFixedFormEditInputCaption2(){

  }

  /**
   * 入力・編集キャプションラベル3に内部項目を追加します。
   */
  protected void addFixedFormEditInputCaption3(){

  }

  /**
   * 入力・編集テキストボックス領域に内部項目を追加します。
   */
  protected void addFixedFormEditInputCaptions(){

    fixedFormEditInputCaptions.add(getFixedFormEditInputAndCompileTextBoxContainer(), VRLayout.WEST);

  }

  /**
   * 入力・編集テキストボックス領域・レイアウトに内部項目を追加します。
   */
  protected void addFixedFormEditInputCaptionLayout(){

  }

  /**
   * 入力・編集テキストボックスに内部項目を追加します。
   */
  protected void addFixedFormEditInputAndCompileTextBox(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addFixedFormEditDownButtons(){

    fixedFormEditDownButtons.add(getFixedFormEditInsert(), VRLayout.WEST);

    fixedFormEditDownButtons.add(getFixedFormEditUpdate(), VRLayout.WEST);

    fixedFormEditDownButtons.add(getFixedFormEditDelete(), VRLayout.WEST);

    fixedFormEditDownButtons.add(getFixedFormEditCancelDelete(), VRLayout.WEST);

  }

  /**
   * 追加ボタンに内部項目を追加します。
   */
  protected void addFixedFormEditInsert(){

  }

  /**
   * 編集ボタンに内部項目を追加します。
   */
  protected void addFixedFormEditUpdate(){

  }

  /**
   * 削除ボタンに内部項目を追加します。
   */
  protected void addFixedFormEditDelete(){

  }

  /**
   * 削除取消ボタンに内部項目を追加します。
   */
  protected void addFixedFormEditCancelDelete(){

  }

  /**
   * コンポーネントを初期化します。
   * @throws Exception 初期化例外
   */
  private void initialize() throws Exception {
    initThis();
    addThis();
  }
  public boolean canBack(VRMap parameters) throws Exception {
    return true;
  }
  public Component getFirstFocusComponent() {

    return null;

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO008Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO008Design getThis() {
    return this;
  }
}
