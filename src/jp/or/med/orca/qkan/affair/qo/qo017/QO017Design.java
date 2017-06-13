
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
 * 開発者: 
 * 作成日: 2016/09/16  日本コンピューター株式会社  新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他 (O)
 * プロセス 総合事業サービスコード登録 (017)
 * プログラム 総合事業サービスコード登録 (QO017)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo017;
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
 * 総合事業サービスコード登録画面項目デザイン(QO017) 
 */
public class QO017Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton newData;

  private ACAffairButton clear;

  private ACPanel contents;

  private ACGroupBox sjServiceCodeSetInfos;

  private ACPanel sjServiceCodeInfos;

  private ACLabelContainer insurerContena;

  private ACTextField insurerIdText;

  private ACComboBox insurerIdCombo;

  private ACComboBoxModelAdapter insurerIdComboModel;

  private ACLabelContainer serviceCodeKindContena;

  private ACComboBox serviceCodeKindCombo;

  private ACComboBoxModelAdapter serviceCodeKindComboModel;

  private ACTextField serveceCodeKindNameText;

  private ACTextField serviceCodeItemText;

  private ACLabelContainer serviceCodeItemTextContainer;

  private ACLabelContainer tekiyoKikanContena;

  private QkanDateTextField tekiyoKikanSt;

  private ACLabel tekiyoKikanLabel;

  private QkanDateTextField tekiyoKikanEd;

  private ACTextField serviceNameText;

  private ACLabelContainer serviceNameTextContainer;

  private ACTextField serviceUnitText;

  private ACLabelContainer serviceUnitTextContainer;

  private ACComboBox santeiTaniCombo;

  private ACLabelContainer santeiTaniComboContainer;

  private ACComboBoxModelAdapter santeiTaniComboModel;

  private ACTextField seigenNissuKaisuText;

  private ACLabelContainer seigenNissuKaisuTextContainer;

  private ACComboBox santeiKaisuSeigenKikanCombo;

  private ACLabelContainer santeiKaisuSeigenKikanComboContainer;

  private ACComboBoxModelAdapter santeiKaisuSeigenKikanComboModel;

  private ACValueArrayRadioButtonGroup shikyuGendogakuTaishoKbn;

  private ACLabelContainer shikyuGendogakuTaishoKbnContainer;

  private ACListModelAdapter shikyuGendogakuTaishoKbnModel;

  private ACRadioButtonItem shikyuGendogakuTaishoKbnTaisho;

  private ACRadioButtonItem shikyuGendogakuTaishoKbnTaishogai;

  private ACTextField yobiText;

  private ACLabelContainer yobiTextContainer;

  private ACTextField kyufuritsuText;

  private ACLabelContainer kyufuritsuTextContainer;

  private ACTextField futangakuText;

  private ACLabelContainer futangakuTextContainer;

  private ACComboBox jigyoJisshiKbnCombo;

  private ACLabelContainer jigyoJisshiKbnComboContainer;

  private ACComboBoxModelAdapter jigyoJisshiKbnComboModel;

  private ACComboBox yoshien1JisshikbnCombo;

  private ACLabelContainer yoshien1JisshikbnComboContainer;

  private ACComboBoxModelAdapter yoshien1JisshikbnComboModel;

  private ACComboBox yoshien2JisshikbnCombo;

  private ACLabelContainer yoshien2JisshikbnComboContainer;

  private ACComboBoxModelAdapter yoshien2JisshikbnComboModel;

  private QkanDateTextField sakuseiDate;

  private ACLabelContainer sakuseiDateContainer;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("総合事業サービスコード登録");

      addButtons();
    }
    return buttons;

  }

  /**
   * 登録を取得します。
   * @return 登録
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("登録(S)");

      insert.setToolTipText("現在の内容を登録します。");

      insert.setMnemonic('S');

      insert.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addInsert();
    }
    return insert;

  }

  /**
   * 更新を取得します。
   * @return 更新
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("更新(S)");

      update.setToolTipText("現在の内容を更新します。");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

  /**
   * 新規を取得します。
   * @return 新規
   */
  public ACAffairButton getNewData(){
    if(newData==null){

      newData = new ACAffairButton();

      newData.setText("新規(N)");

      newData.setToolTipText("総合事業サービスコードを新規に作成します。");

      newData.setMnemonic('N');

      newData.setIconPath(ACConstants.ICON_PATH_NEW_24);

      addNewData();
    }
    return newData;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACAffairButton getClear(){
    if(clear==null){

      clear = new ACAffairButton();

      clear.setText("クリア(C)");

      clear.setToolTipText("総合事業サービスコードの情報をクリアします。");

      clear.setMnemonic('C');

      clear.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClear();
    }
    return clear;

  }

  /**
   * 入力領域を取得します。
   * @return 入力領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 総合事業サービスコード情報設定領域を取得します。
   * @return 総合事業サービスコード情報設定領域
   */
  public ACGroupBox getSjServiceCodeSetInfos(){
    if(sjServiceCodeSetInfos==null){

      sjServiceCodeSetInfos = new ACGroupBox();

      sjServiceCodeSetInfos.setText("基本情報");

      sjServiceCodeSetInfos.setVgap(5);

      addSjServiceCodeSetInfos();
    }
    return sjServiceCodeSetInfos;

  }

  /**
   * 総合事業サービスコード情報入力領域を取得します。
   * @return 総合事業サービスコード情報入力領域
   */
  public ACPanel getSjServiceCodeInfos(){
    if(sjServiceCodeInfos==null){

      sjServiceCodeInfos = new ACPanel();

      sjServiceCodeInfos.setHgap(1);

      addSjServiceCodeInfos();
    }
    return sjServiceCodeInfos;

  }

  /**
   * 保険者番号コンテナを取得します。
   * @return 保険者番号コンテナ
   */
  public ACLabelContainer getInsurerContena(){
    if(insurerContena==null){

      insurerContena = new ACLabelContainer();

      insurerContena.setText("保険者番号");

      addInsurerContena();
    }
    return insurerContena;

  }

  /**
   * 保険者番号テキストを取得します。
   * @return 保険者番号テキスト
   */
  public ACTextField getInsurerIdText(){
    if(insurerIdText==null){

      insurerIdText = new ACTextField();

      insurerIdText.setBindPath("INSURER_ID");

      insurerIdText.setColumns(6);

      insurerIdText.setCharType(VRCharType.ONLY_DIGIT);

      insurerIdText.setIMEMode(InputSubset.LATIN);

      insurerIdText.setMaxLength(6);

      addInsurerIdText();
    }
    return insurerIdText;

  }

  /**
   * 保険者番号コンボを取得します。
   * @return 保険者番号コンボ
   */
  public ACComboBox getInsurerIdCombo(){
    if(insurerIdCombo==null){

      insurerIdCombo = new ACComboBox();

      insurerIdCombo.setBindPath("INSURER_NAME");

      insurerIdCombo.setEditable(false);

      insurerIdCombo.setModelBindPath("INSURER_ID");

      insurerIdCombo.setRenderBindPath("INSURER_NAME");

      insurerIdCombo.setModel(getInsurerIdComboModel());

      addInsurerIdCombo();
    }
    return insurerIdCombo;

  }

  /**
   * 保険者番号コンボモデルを取得します。
   * @return 保険者番号コンボモデル
   */
  protected ACComboBoxModelAdapter getInsurerIdComboModel(){
    if(insurerIdComboModel==null){
      insurerIdComboModel = new ACComboBoxModelAdapter();
      addInsurerIdComboModel();
    }
    return insurerIdComboModel;
  }

  /**
   * サービス種類コンテナを取得します。
   * @return サービス種類コンテナ
   */
  public ACLabelContainer getServiceCodeKindContena(){
    if(serviceCodeKindContena==null){

      serviceCodeKindContena = new ACLabelContainer();

      serviceCodeKindContena.setText("サービス種類");

      addServiceCodeKindContena();
    }
    return serviceCodeKindContena;

  }

  /**
   * サービス種類コンボを取得します。
   * @return サービス種類コンボ
   */
  public ACComboBox getServiceCodeKindCombo(){
    if(serviceCodeKindCombo==null){

      serviceCodeKindCombo = new ACComboBox();

      serviceCodeKindCombo.setBindPath("SERVICE_CODE_KIND");

      serviceCodeKindCombo.setEditable(false);

      serviceCodeKindCombo.setModelBindPath("SERVICE_CODE_KIND");

      serviceCodeKindCombo.setRenderBindPath("SERVICE_NAME");

      serviceCodeKindCombo.setBlankable(false);

      serviceCodeKindCombo.setModel(getServiceCodeKindComboModel());

      addServiceCodeKindCombo();
    }
    return serviceCodeKindCombo;

  }

  /**
   * サービス種類コンボモデルを取得します。
   * @return サービス種類コンボモデル
   */
  protected ACComboBoxModelAdapter getServiceCodeKindComboModel(){
    if(serviceCodeKindComboModel==null){
      serviceCodeKindComboModel = new ACComboBoxModelAdapter();
      addServiceCodeKindComboModel();
    }
    return serviceCodeKindComboModel;
  }

  /**
   * サービス種類テキストを取得します。
   * @return サービス種類テキスト
   */
  public ACTextField getServeceCodeKindNameText(){
    if(serveceCodeKindNameText==null){

      serveceCodeKindNameText = new ACTextField();

      serveceCodeKindNameText.setEditable(false);

      serveceCodeKindNameText.setColumns(25);

      addServeceCodeKindNameText();
    }
    return serveceCodeKindNameText;

  }

  /**
   * サービス項目コードテキストを取得します。
   * @return サービス項目コードテキスト
   */
  public ACTextField getServiceCodeItemText(){
    if(serviceCodeItemText==null){

      serviceCodeItemText = new ACTextField();

      getServiceCodeItemTextContainer().setText("サービス項目");

      serviceCodeItemText.setBindPath("SERVICE_CODE_ITEM");

      serviceCodeItemText.setColumns(4);

      serviceCodeItemText.setCharType(VRCharType.ONLY_ALNUM);

      serviceCodeItemText.setIMEMode(InputSubset.LATIN);

      serviceCodeItemText.setMaxLength(4);

      addServiceCodeItemText();
    }
    return serviceCodeItemText;

  }

  /**
   * サービス項目コードテキストコンテナを取得します。
   * @return サービス項目コードテキストコンテナ
   */
  protected ACLabelContainer getServiceCodeItemTextContainer(){
    if(serviceCodeItemTextContainer==null){
      serviceCodeItemTextContainer = new ACLabelContainer();
      serviceCodeItemTextContainer.setFollowChildEnabled(true);
      serviceCodeItemTextContainer.setVAlignment(VRLayout.CENTER);
      serviceCodeItemTextContainer.add(getServiceCodeItemText(), null);
    }
    return serviceCodeItemTextContainer;
  }

  /**
   * 適用期間コンテナを取得します。
   * @return 適用期間コンテナ
   */
  public ACLabelContainer getTekiyoKikanContena(){
    if(tekiyoKikanContena==null){

      tekiyoKikanContena = new ACLabelContainer();

      tekiyoKikanContena.setText("適用期間");

      addTekiyoKikanContena();
    }
    return tekiyoKikanContena;

  }

  /**
   * 適用期間テキスト(開始)を取得します。
   * @return 適用期間テキスト(開始)
   */
  public QkanDateTextField getTekiyoKikanSt(){
    if(tekiyoKikanSt==null){

      tekiyoKikanSt = new QkanDateTextField();

      tekiyoKikanSt.setBindPath("TEKIYO_ST_DATE");

      addTekiyoKikanSt();
    }
    return tekiyoKikanSt;

  }

  /**
   * 適用期間・ラベルを取得します。
   * @return 適用期間・ラベル
   */
  public ACLabel getTekiyoKikanLabel(){
    if(tekiyoKikanLabel==null){

      tekiyoKikanLabel = new ACLabel();

      tekiyoKikanLabel.setText("から");

      addTekiyoKikanLabel();
    }
    return tekiyoKikanLabel;

  }

  /**
   * 適用期間テキスト(終了)を取得します。
   * @return 適用期間テキスト(終了)
   */
  public QkanDateTextField getTekiyoKikanEd(){
    if(tekiyoKikanEd==null){

      tekiyoKikanEd = new QkanDateTextField();

      tekiyoKikanEd.setBindPath("TEKIYO_ED_DATE");

      addTekiyoKikanEd();
    }
    return tekiyoKikanEd;

  }

  /**
   * サービス名称テキストを取得します。
   * @return サービス名称テキスト
   */
  public ACTextField getServiceNameText(){
    if(serviceNameText==null){

      serviceNameText = new ACTextField();

      getServiceNameTextContainer().setText("サービス名称");

      serviceNameText.setBindPath("SERVICE_NAME");

      serviceNameText.setColumns(64);

      serviceNameText.setIMEMode(InputSubset.KANJI);

      serviceNameText.setMaxLength(64);

      addServiceNameText();
    }
    return serviceNameText;

  }

  /**
   * サービス名称テキストコンテナを取得します。
   * @return サービス名称テキストコンテナ
   */
  protected ACLabelContainer getServiceNameTextContainer(){
    if(serviceNameTextContainer==null){
      serviceNameTextContainer = new ACLabelContainer();
      serviceNameTextContainer.setFollowChildEnabled(true);
      serviceNameTextContainer.setVAlignment(VRLayout.CENTER);
      serviceNameTextContainer.add(getServiceNameText(), null);
    }
    return serviceNameTextContainer;
  }

  /**
   * 単位数テキストを取得します。
   * @return 単位数テキスト
   */
  public ACTextField getServiceUnitText(){
    if(serviceUnitText==null){

      serviceUnitText = new ACTextField();

      getServiceUnitTextContainer().setText("単位数");

      serviceUnitText.setBindPath("SERVICE_UNIT");

      serviceUnitText.setColumns(4);

      serviceUnitText.setCharType(VRCharType.ONLY_NUMBER);

      serviceUnitText.setHorizontalAlignment(SwingConstants.RIGHT);

      serviceUnitText.setIMEMode(InputSubset.LATIN);

      serviceUnitText.setMaxLength(6);

      addServiceUnitText();
    }
    return serviceUnitText;

  }

  /**
   * 単位数テキストコンテナを取得します。
   * @return 単位数テキストコンテナ
   */
  protected ACLabelContainer getServiceUnitTextContainer(){
    if(serviceUnitTextContainer==null){
      serviceUnitTextContainer = new ACLabelContainer();
      serviceUnitTextContainer.setFollowChildEnabled(true);
      serviceUnitTextContainer.setVAlignment(VRLayout.CENTER);
      serviceUnitTextContainer.add(getServiceUnitText(), null);
    }
    return serviceUnitTextContainer;
  }

  /**
   * 算定単位コンボを取得します。
   * @return 算定単位コンボ
   */
  public ACComboBox getSanteiTaniCombo(){
    if(santeiTaniCombo==null){

      santeiTaniCombo = new ACComboBox();

      getSanteiTaniComboContainer().setText("算定単位");

      santeiTaniCombo.setBindPath("SANTEI_TANI");

      santeiTaniCombo.setEditable(false);

      santeiTaniCombo.setModelBindPath("SANTEI_TANI");

      santeiTaniCombo.setRenderBindPath("CONTENT");

      santeiTaniCombo.setBlankable(false);

      santeiTaniCombo.setModel(getSanteiTaniComboModel());

      addSanteiTaniCombo();
    }
    return santeiTaniCombo;

  }

  /**
   * 算定単位コンボコンテナを取得します。
   * @return 算定単位コンボコンテナ
   */
  protected ACLabelContainer getSanteiTaniComboContainer(){
    if(santeiTaniComboContainer==null){
      santeiTaniComboContainer = new ACLabelContainer();
      santeiTaniComboContainer.setFollowChildEnabled(true);
      santeiTaniComboContainer.setVAlignment(VRLayout.CENTER);
      santeiTaniComboContainer.add(getSanteiTaniCombo(), null);
    }
    return santeiTaniComboContainer;
  }

  /**
   * 算定単位コンボモデルを取得します。
   * @return 算定単位コンボモデル
   */
  protected ACComboBoxModelAdapter getSanteiTaniComboModel(){
    if(santeiTaniComboModel==null){
      santeiTaniComboModel = new ACComboBoxModelAdapter();
      addSanteiTaniComboModel();
    }
    return santeiTaniComboModel;
  }

  /**
   * 制限日数回数テキストを取得します。
   * @return 制限日数回数テキスト
   */
  public ACTextField getSeigenNissuKaisuText(){
    if(seigenNissuKaisuText==null){

      seigenNissuKaisuText = new ACTextField();

      getSeigenNissuKaisuTextContainer().setText("制限日数回数");

      seigenNissuKaisuText.setBindPath("SEIGEN_NISSU_KAISU");

      seigenNissuKaisuText.setColumns(5);

      seigenNissuKaisuText.setCharType(VRCharType.ONLY_DIGIT);

      seigenNissuKaisuText.setHorizontalAlignment(SwingConstants.RIGHT);

      seigenNissuKaisuText.setIMEMode(InputSubset.LATIN);

      seigenNissuKaisuText.setMaxLength(2);

      addSeigenNissuKaisuText();
    }
    return seigenNissuKaisuText;

  }

  /**
   * 制限日数回数テキストコンテナを取得します。
   * @return 制限日数回数テキストコンテナ
   */
  protected ACLabelContainer getSeigenNissuKaisuTextContainer(){
    if(seigenNissuKaisuTextContainer==null){
      seigenNissuKaisuTextContainer = new ACLabelContainer();
      seigenNissuKaisuTextContainer.setFollowChildEnabled(true);
      seigenNissuKaisuTextContainer.setVAlignment(VRLayout.CENTER);
      seigenNissuKaisuTextContainer.add(getSeigenNissuKaisuText(), null);
    }
    return seigenNissuKaisuTextContainer;
  }

  /**
   * 算定回数制限期間コンボを取得します。
   * @return 算定回数制限期間コンボ
   */
  public ACComboBox getSanteiKaisuSeigenKikanCombo(){
    if(santeiKaisuSeigenKikanCombo==null){

      santeiKaisuSeigenKikanCombo = new ACComboBox();

      getSanteiKaisuSeigenKikanComboContainer().setText("算定回数制限期間");

      santeiKaisuSeigenKikanCombo.setBindPath("SANTEI_KAISU_SEIGEN_KIKAN");

      santeiKaisuSeigenKikanCombo.setEditable(false);

      santeiKaisuSeigenKikanCombo.setModelBindPath("SANTEI_KAISU_SEIGEN_KIKAN");

      santeiKaisuSeigenKikanCombo.setRenderBindPath("CONTENT");

      santeiKaisuSeigenKikanCombo.setBlankable(true);

      santeiKaisuSeigenKikanCombo.setModel(getSanteiKaisuSeigenKikanComboModel());

      addSanteiKaisuSeigenKikanCombo();
    }
    return santeiKaisuSeigenKikanCombo;

  }

  /**
   * 算定回数制限期間コンボコンテナを取得します。
   * @return 算定回数制限期間コンボコンテナ
   */
  protected ACLabelContainer getSanteiKaisuSeigenKikanComboContainer(){
    if(santeiKaisuSeigenKikanComboContainer==null){
      santeiKaisuSeigenKikanComboContainer = new ACLabelContainer();
      santeiKaisuSeigenKikanComboContainer.setFollowChildEnabled(true);
      santeiKaisuSeigenKikanComboContainer.setVAlignment(VRLayout.CENTER);
      santeiKaisuSeigenKikanComboContainer.add(getSanteiKaisuSeigenKikanCombo(), null);
    }
    return santeiKaisuSeigenKikanComboContainer;
  }

  /**
   * 算定回数制限期間コンボモデルを取得します。
   * @return 算定回数制限期間コンボモデル
   */
  protected ACComboBoxModelAdapter getSanteiKaisuSeigenKikanComboModel(){
    if(santeiKaisuSeigenKikanComboModel==null){
      santeiKaisuSeigenKikanComboModel = new ACComboBoxModelAdapter();
      addSanteiKaisuSeigenKikanComboModel();
    }
    return santeiKaisuSeigenKikanComboModel;
  }

  /**
   * 支給限度額対象区分を取得します。
   * @return 支給限度額対象区分
   */
  public ACValueArrayRadioButtonGroup getShikyuGendogakuTaishoKbn(){
    if(shikyuGendogakuTaishoKbn==null){

      shikyuGendogakuTaishoKbn = new ACValueArrayRadioButtonGroup();

      getShikyuGendogakuTaishoKbnContainer().setText("支給限度額対象区分");

      shikyuGendogakuTaishoKbn.setBindPath("SHIKYU_GENDOGAKU_TAISHO_KBN");

      shikyuGendogakuTaishoKbn.setUseClearButton(false);

      shikyuGendogakuTaishoKbn.setModel(getShikyuGendogakuTaishoKbnModel());

      shikyuGendogakuTaishoKbn.setValues(new int[]{3,1});

      addShikyuGendogakuTaishoKbn();
    }
    return shikyuGendogakuTaishoKbn;

  }

  /**
   * 支給限度額対象区分コンテナを取得します。
   * @return 支給限度額対象区分コンテナ
   */
  protected ACLabelContainer getShikyuGendogakuTaishoKbnContainer(){
    if(shikyuGendogakuTaishoKbnContainer==null){
      shikyuGendogakuTaishoKbnContainer = new ACLabelContainer();
      shikyuGendogakuTaishoKbnContainer.setFollowChildEnabled(true);
      shikyuGendogakuTaishoKbnContainer.setVAlignment(VRLayout.CENTER);
      shikyuGendogakuTaishoKbnContainer.add(getShikyuGendogakuTaishoKbn(), null);
    }
    return shikyuGendogakuTaishoKbnContainer;
  }

  /**
   * 支給限度額対象区分モデルを取得します。
   * @return 支給限度額対象区分モデル
   */
  protected ACListModelAdapter getShikyuGendogakuTaishoKbnModel(){
    if(shikyuGendogakuTaishoKbnModel==null){
      shikyuGendogakuTaishoKbnModel = new ACListModelAdapter();
      addShikyuGendogakuTaishoKbnModel();
    }
    return shikyuGendogakuTaishoKbnModel;
  }

  /**
   * 対象を取得します。
   * @return 対象
   */
  public ACRadioButtonItem getShikyuGendogakuTaishoKbnTaisho(){
    if(shikyuGendogakuTaishoKbnTaisho==null){

      shikyuGendogakuTaishoKbnTaisho = new ACRadioButtonItem();

      shikyuGendogakuTaishoKbnTaisho.setText("対象");

      shikyuGendogakuTaishoKbnTaisho.setGroup(getShikyuGendogakuTaishoKbn());

      shikyuGendogakuTaishoKbnTaisho.setConstraints(VRLayout.FLOW);

      addShikyuGendogakuTaishoKbnTaisho();
    }
    return shikyuGendogakuTaishoKbnTaisho;

  }

  /**
   * 対象外を取得します。
   * @return 対象外
   */
  public ACRadioButtonItem getShikyuGendogakuTaishoKbnTaishogai(){
    if(shikyuGendogakuTaishoKbnTaishogai==null){

      shikyuGendogakuTaishoKbnTaishogai = new ACRadioButtonItem();

      shikyuGendogakuTaishoKbnTaishogai.setText("対象外");

      shikyuGendogakuTaishoKbnTaishogai.setGroup(getShikyuGendogakuTaishoKbn());

      shikyuGendogakuTaishoKbnTaishogai.setConstraints(VRLayout.FLOW);

      addShikyuGendogakuTaishoKbnTaishogai();
    }
    return shikyuGendogakuTaishoKbnTaishogai;

  }

  /**
   * 予備項目テキストを取得します。
   * @return 予備項目テキスト
   */
  public ACTextField getYobiText(){
    if(yobiText==null){

      yobiText = new ACTextField();

      getYobiTextContainer().setText("予備項目");

      yobiText.setBindPath("YOBI");

      yobiText.setColumns(10);

      yobiText.setIMEMode(InputSubset.LATIN);

      yobiText.setMaxLength(10);

      addYobiText();
    }
    return yobiText;

  }

  /**
   * 予備項目テキストコンテナを取得します。
   * @return 予備項目テキストコンテナ
   */
  protected ACLabelContainer getYobiTextContainer(){
    if(yobiTextContainer==null){
      yobiTextContainer = new ACLabelContainer();
      yobiTextContainer.setFollowChildEnabled(true);
      yobiTextContainer.setVAlignment(VRLayout.CENTER);
      yobiTextContainer.add(getYobiText(), null);
    }
    return yobiTextContainer;
  }

  /**
   * 給付率テキストを取得します。
   * @return 給付率テキスト
   */
  public ACTextField getKyufuritsuText(){
    if(kyufuritsuText==null){

      kyufuritsuText = new ACTextField();

      getKyufuritsuTextContainer().setText("給付率");

      kyufuritsuText.setBindPath("KYUFURITSU");

      kyufuritsuText.setColumns(5);

      kyufuritsuText.setCharType(VRCharType.ONLY_DIGIT);

      kyufuritsuText.setHorizontalAlignment(SwingConstants.RIGHT);

      kyufuritsuText.setIMEMode(InputSubset.LATIN);

      kyufuritsuText.setMaxLength(3);

      addKyufuritsuText();
    }
    return kyufuritsuText;

  }

  /**
   * 給付率テキストコンテナを取得します。
   * @return 給付率テキストコンテナ
   */
  protected ACLabelContainer getKyufuritsuTextContainer(){
    if(kyufuritsuTextContainer==null){
      kyufuritsuTextContainer = new ACLabelContainer();
      kyufuritsuTextContainer.setFollowChildEnabled(true);
      kyufuritsuTextContainer.setVAlignment(VRLayout.CENTER);
      kyufuritsuTextContainer.add(getKyufuritsuText(), null);
    }
    return kyufuritsuTextContainer;
  }

  /**
   * 利用者負担額テキストを取得します。
   * @return 利用者負担額テキスト
   */
  public ACTextField getFutangakuText(){
    if(futangakuText==null){

      futangakuText = new ACTextField();

      getFutangakuTextContainer().setText("利用者負担額");

      futangakuText.setBindPath("FUTANGAKU");

      futangakuText.setColumns(5);

      futangakuText.setCharType(VRCharType.ONLY_NUMBER);

      futangakuText.setHorizontalAlignment(SwingConstants.RIGHT);

      futangakuText.setIMEMode(InputSubset.LATIN);

      futangakuText.setMaxLength(6);

      addFutangakuText();
    }
    return futangakuText;

  }

  /**
   * 利用者負担額テキストコンテナを取得します。
   * @return 利用者負担額テキストコンテナ
   */
  protected ACLabelContainer getFutangakuTextContainer(){
    if(futangakuTextContainer==null){
      futangakuTextContainer = new ACLabelContainer();
      futangakuTextContainer.setFollowChildEnabled(true);
      futangakuTextContainer.setVAlignment(VRLayout.CENTER);
      futangakuTextContainer.add(getFutangakuText(), null);
    }
    return futangakuTextContainer;
  }

  /**
   * 事業対象者実施区分コンボを取得します。
   * @return 事業対象者実施区分コンボ
   */
  public ACComboBox getJigyoJisshiKbnCombo(){
    if(jigyoJisshiKbnCombo==null){

      jigyoJisshiKbnCombo = new ACComboBox();

      getJigyoJisshiKbnComboContainer().setText("事業対象者実施区分");

      jigyoJisshiKbnCombo.setBindPath("JIGYO_TAISHOSHA_JISSHI_KBN");

      jigyoJisshiKbnCombo.setEditable(false);

      jigyoJisshiKbnCombo.setModelBindPath("JIGYO_TAISHOSHA_JISSHI_KBN");

      jigyoJisshiKbnCombo.setRenderBindPath("CONTENT");

      jigyoJisshiKbnCombo.setBlankable(false);

      jigyoJisshiKbnCombo.setModel(getJigyoJisshiKbnComboModel());

      addJigyoJisshiKbnCombo();
    }
    return jigyoJisshiKbnCombo;

  }

  /**
   * 事業対象者実施区分コンボコンテナを取得します。
   * @return 事業対象者実施区分コンボコンテナ
   */
  protected ACLabelContainer getJigyoJisshiKbnComboContainer(){
    if(jigyoJisshiKbnComboContainer==null){
      jigyoJisshiKbnComboContainer = new ACLabelContainer();
      jigyoJisshiKbnComboContainer.setFollowChildEnabled(true);
      jigyoJisshiKbnComboContainer.setVAlignment(VRLayout.CENTER);
      jigyoJisshiKbnComboContainer.add(getJigyoJisshiKbnCombo(), null);
    }
    return jigyoJisshiKbnComboContainer;
  }

  /**
   * 事業対象者実施区分コンボモデルを取得します。
   * @return 事業対象者実施区分コンボモデル
   */
  protected ACComboBoxModelAdapter getJigyoJisshiKbnComboModel(){
    if(jigyoJisshiKbnComboModel==null){
      jigyoJisshiKbnComboModel = new ACComboBoxModelAdapter();
      addJigyoJisshiKbnComboModel();
    }
    return jigyoJisshiKbnComboModel;
  }

  /**
   * 要支援１受給者実施区分コンボを取得します。
   * @return 要支援１受給者実施区分コンボ
   */
  public ACComboBox getYoshien1JisshikbnCombo(){
    if(yoshien1JisshikbnCombo==null){

      yoshien1JisshikbnCombo = new ACComboBox();

      getYoshien1JisshikbnComboContainer().setText("要支援１受給者実施区分");

      yoshien1JisshikbnCombo.setBindPath("YOSHIEN1_JUKYUSHA_JISSHI_KBN");

      yoshien1JisshikbnCombo.setEditable(false);

      yoshien1JisshikbnCombo.setModelBindPath("YOSHIEN1_JUKYUSHA_JISSHI_KBN");

      yoshien1JisshikbnCombo.setRenderBindPath("CONTENT");

      yoshien1JisshikbnCombo.setBlankable(false);

      yoshien1JisshikbnCombo.setModel(getYoshien1JisshikbnComboModel());

      addYoshien1JisshikbnCombo();
    }
    return yoshien1JisshikbnCombo;

  }

  /**
   * 要支援１受給者実施区分コンボコンテナを取得します。
   * @return 要支援１受給者実施区分コンボコンテナ
   */
  protected ACLabelContainer getYoshien1JisshikbnComboContainer(){
    if(yoshien1JisshikbnComboContainer==null){
      yoshien1JisshikbnComboContainer = new ACLabelContainer();
      yoshien1JisshikbnComboContainer.setFollowChildEnabled(true);
      yoshien1JisshikbnComboContainer.setVAlignment(VRLayout.CENTER);
      yoshien1JisshikbnComboContainer.add(getYoshien1JisshikbnCombo(), null);
    }
    return yoshien1JisshikbnComboContainer;
  }

  /**
   * 要支援１受給者実施区分コンボモデルを取得します。
   * @return 要支援１受給者実施区分コンボモデル
   */
  protected ACComboBoxModelAdapter getYoshien1JisshikbnComboModel(){
    if(yoshien1JisshikbnComboModel==null){
      yoshien1JisshikbnComboModel = new ACComboBoxModelAdapter();
      addYoshien1JisshikbnComboModel();
    }
    return yoshien1JisshikbnComboModel;
  }

  /**
   * 要支援２受給者実施区分コンボを取得します。
   * @return 要支援２受給者実施区分コンボ
   */
  public ACComboBox getYoshien2JisshikbnCombo(){
    if(yoshien2JisshikbnCombo==null){

      yoshien2JisshikbnCombo = new ACComboBox();

      getYoshien2JisshikbnComboContainer().setText("要支援２受給者実施区分");

      yoshien2JisshikbnCombo.setBindPath("YOSHIEN2_JUKYUSHA_JISSHI_KBN");

      yoshien2JisshikbnCombo.setEditable(false);

      yoshien2JisshikbnCombo.setModelBindPath("YOSHIEN2_JUKYUSHA_JISSHI_KBN");

      yoshien2JisshikbnCombo.setRenderBindPath("CONTENT");

      yoshien2JisshikbnCombo.setBlankable(false);

      yoshien2JisshikbnCombo.setModel(getYoshien2JisshikbnComboModel());

      addYoshien2JisshikbnCombo();
    }
    return yoshien2JisshikbnCombo;

  }

  /**
   * 要支援２受給者実施区分コンボコンテナを取得します。
   * @return 要支援２受給者実施区分コンボコンテナ
   */
  protected ACLabelContainer getYoshien2JisshikbnComboContainer(){
    if(yoshien2JisshikbnComboContainer==null){
      yoshien2JisshikbnComboContainer = new ACLabelContainer();
      yoshien2JisshikbnComboContainer.setFollowChildEnabled(true);
      yoshien2JisshikbnComboContainer.setVAlignment(VRLayout.CENTER);
      yoshien2JisshikbnComboContainer.add(getYoshien2JisshikbnCombo(), null);
    }
    return yoshien2JisshikbnComboContainer;
  }

  /**
   * 要支援２受給者実施区分コンボモデルを取得します。
   * @return 要支援２受給者実施区分コンボモデル
   */
  protected ACComboBoxModelAdapter getYoshien2JisshikbnComboModel(){
    if(yoshien2JisshikbnComboModel==null){
      yoshien2JisshikbnComboModel = new ACComboBoxModelAdapter();
      addYoshien2JisshikbnComboModel();
    }
    return yoshien2JisshikbnComboModel;
  }

  /**
   * 作成年月日テキストを取得します。
   * @return 作成年月日テキスト
   */
  public QkanDateTextField getSakuseiDate(){
    if(sakuseiDate==null){

      sakuseiDate = new QkanDateTextField();

      getSakuseiDateContainer().setText("作成年月日");

      sakuseiDate.setBindPath("SAKUSEI_DATE");

      addSakuseiDate();
    }
    return sakuseiDate;

  }

  /**
   * 作成年月日テキストコンテナを取得します。
   * @return 作成年月日テキストコンテナ
   */
  protected ACLabelContainer getSakuseiDateContainer(){
    if(sakuseiDateContainer==null){
      sakuseiDateContainer = new ACLabelContainer();
      sakuseiDateContainer.setFollowChildEnabled(true);
      sakuseiDateContainer.setVAlignment(VRLayout.CENTER);
      sakuseiDateContainer.add(getSakuseiDate(), null);
    }
    return sakuseiDateContainer;
  }

  /**
   * コンストラクタです。
   */
  public QO017Design() {

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

    buttons.add(getClear(), VRLayout.EAST);
    buttons.add(getNewData(), VRLayout.EAST);
    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
  }

  /**
   * 登録に内部項目を追加します。
   */
  protected void addInsert(){

  }

  /**
   * 更新に内部項目を追加します。
   */
  protected void addUpdate(){

  }

  /**
   * 新規に内部項目を追加します。
   */
  protected void addNewData(){

  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addClear(){

  }

  /**
   * 入力領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getSjServiceCodeSetInfos(), VRLayout.NORTH);

  }

  /**
   * 総合事業サービスコード情報設定領域に内部項目を追加します。
   */
  protected void addSjServiceCodeSetInfos(){

    sjServiceCodeSetInfos.add(getSjServiceCodeInfos(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 総合事業サービスコード情報入力領域に内部項目を追加します。
   */
  protected void addSjServiceCodeInfos(){

    sjServiceCodeInfos.add(getInsurerContena(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getServiceCodeKindContena(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getServiceCodeItemTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getTekiyoKikanContena(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getServiceNameTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getServiceUnitTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getSanteiTaniComboContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getSeigenNissuKaisuTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getSanteiKaisuSeigenKikanComboContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getShikyuGendogakuTaishoKbnContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getYobiTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getKyufuritsuTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getFutangakuTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getJigyoJisshiKbnComboContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getYoshien1JisshikbnComboContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getYoshien2JisshikbnComboContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sjServiceCodeInfos.add(getSakuseiDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 保険者番号コンテナに内部項目を追加します。
   */
  protected void addInsurerContena(){

    insurerContena.add(getInsurerIdText(), VRLayout.FLOW);

    insurerContena.add(getInsurerIdCombo(), VRLayout.FLOW);

  }

  /**
   * 保険者番号テキストに内部項目を追加します。
   */
  protected void addInsurerIdText(){

  }

  /**
   * 保険者番号コンボに内部項目を追加します。
   */
  protected void addInsurerIdCombo(){

  }

  /**
   * 保険者番号コンボモデルに内部項目を追加します。
   */
  protected void addInsurerIdComboModel(){

  }

  /**
   * サービス種類コンテナに内部項目を追加します。
   */
  protected void addServiceCodeKindContena(){

    serviceCodeKindContena.add(getServiceCodeKindCombo(), VRLayout.FLOW);

    serviceCodeKindContena.add(getServeceCodeKindNameText(), VRLayout.FLOW);

  }

  /**
   * サービス種類コンボに内部項目を追加します。
   */
  protected void addServiceCodeKindCombo(){

  }

  /**
   * サービス種類コンボモデルに内部項目を追加します。
   */
  protected void addServiceCodeKindComboModel(){

  }

  /**
   * サービス種類テキストに内部項目を追加します。
   */
  protected void addServeceCodeKindNameText(){

  }

  /**
   * サービス項目コードテキストに内部項目を追加します。
   */
  protected void addServiceCodeItemText(){

  }

  /**
   * 適用期間コンテナに内部項目を追加します。
   */
  protected void addTekiyoKikanContena(){

    tekiyoKikanContena.add(getTekiyoKikanSt(), VRLayout.FLOW);

    tekiyoKikanContena.add(getTekiyoKikanLabel(), VRLayout.FLOW);

    tekiyoKikanContena.add(getTekiyoKikanEd(), VRLayout.FLOW);

  }

  /**
   * 適用期間テキスト(開始)に内部項目を追加します。
   */
  protected void addTekiyoKikanSt(){

  }

  /**
   * 適用期間・ラベルに内部項目を追加します。
   */
  protected void addTekiyoKikanLabel(){

  }

  /**
   * 適用期間テキスト(終了)に内部項目を追加します。
   */
  protected void addTekiyoKikanEd(){

  }

  /**
   * サービス名称テキストに内部項目を追加します。
   */
  protected void addServiceNameText(){

  }

  /**
   * 単位数テキストに内部項目を追加します。
   */
  protected void addServiceUnitText(){

  }

  /**
   * 算定単位コンボに内部項目を追加します。
   */
  protected void addSanteiTaniCombo(){

  }

  /**
   * 算定単位コンボモデルに内部項目を追加します。
   */
  protected void addSanteiTaniComboModel(){

  }

  /**
   * 制限日数回数テキストに内部項目を追加します。
   */
  protected void addSeigenNissuKaisuText(){

  }

  /**
   * 算定回数制限期間コンボに内部項目を追加します。
   */
  protected void addSanteiKaisuSeigenKikanCombo(){

  }

  /**
   * 算定回数制限期間コンボモデルに内部項目を追加します。
   */
  protected void addSanteiKaisuSeigenKikanComboModel(){

  }

  /**
   * 支給限度額対象区分に内部項目を追加します。
   */
  protected void addShikyuGendogakuTaishoKbn(){

  }

  /**
   * 支給限度額対象区分モデルに内部項目を追加します。
   */
  protected void addShikyuGendogakuTaishoKbnModel(){

    getShikyuGendogakuTaishoKbnTaisho().setButtonIndex(3);

    getShikyuGendogakuTaishoKbnModel().add(getShikyuGendogakuTaishoKbnTaisho());

    getShikyuGendogakuTaishoKbnTaishogai().setButtonIndex(1);

    getShikyuGendogakuTaishoKbnModel().add(getShikyuGendogakuTaishoKbnTaishogai());

  }

  /**
   * 対象に内部項目を追加します。
   */
  protected void addShikyuGendogakuTaishoKbnTaisho(){

  }

  /**
   * 対象外に内部項目を追加します。
   */
  protected void addShikyuGendogakuTaishoKbnTaishogai(){

  }

  /**
   * 予備項目テキストに内部項目を追加します。
   */
  protected void addYobiText(){

  }

  /**
   * 給付率テキストに内部項目を追加します。
   */
  protected void addKyufuritsuText(){

  }

  /**
   * 利用者負担額テキストに内部項目を追加します。
   */
  protected void addFutangakuText(){

  }

  /**
   * 事業対象者実施区分コンボに内部項目を追加します。
   */
  protected void addJigyoJisshiKbnCombo(){

  }

  /**
   * 事業対象者実施区分コンボモデルに内部項目を追加します。
   */
  protected void addJigyoJisshiKbnComboModel(){

  }

  /**
   * 要支援１受給者実施区分コンボに内部項目を追加します。
   */
  protected void addYoshien1JisshikbnCombo(){

  }

  /**
   * 要支援１受給者実施区分コンボモデルに内部項目を追加します。
   */
  protected void addYoshien1JisshikbnComboModel(){

  }

  /**
   * 要支援２受給者実施区分コンボに内部項目を追加します。
   */
  protected void addYoshien2JisshikbnCombo(){

  }

  /**
   * 要支援２受給者実施区分コンボモデルに内部項目を追加します。
   */
  protected void addYoshien2JisshikbnComboModel(){

  }

  /**
   * 作成年月日テキストに内部項目を追加します。
   */
  protected void addSakuseiDate(){

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

    return getInsurerIdText();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO017Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO017Design getThis() {
    return this;
  }
}
