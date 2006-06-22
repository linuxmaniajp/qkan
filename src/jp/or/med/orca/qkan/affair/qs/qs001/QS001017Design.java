
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
 * 開発者: 小笠　貴志
 * 作成日: 2006/01/26  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン短期入所療養介護（居宅療養管理指導） (QS001017)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.component.ACVerticalRadioButtonGroup;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * サービスパターン短期入所療養介護（居宅療養管理指導）画面項目デザイン(QS001017) 
 */
public class QS001017Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel recuperationManagementGuidancePatterns;

  private ACBackLabelContainer recuperationManagementGuidanceTimeContena;

  private ACTimeComboBox recuperationManagementGuidanceBeginTime;

  private ACLabelContainer recuperationManagementGuidanceBeginTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceBeginTimeModel;

  private ACTimeComboBox recuperationManagementGuidanceEndTime;

  private ACLabelContainer recuperationManagementGuidanceEndTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceEndTimeModel;

  private ACVerticalRadioButtonGroup recuperationManagementGuidanceOccupationalCategory;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDoctor;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDentist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDietitian;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryEtc;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2;

  //getter

  /**
   * 短期入所療養介護（居宅療養管理指導）パターン領域）を取得します。
   * @return 短期入所療養介護（居宅療養管理指導）パターン領域）
   */
  public ACPanel getRecuperationManagementGuidancePatterns(){
    if(recuperationManagementGuidancePatterns==null){

      recuperationManagementGuidancePatterns = new ACPanel();

      recuperationManagementGuidancePatterns.setAutoWrap(false);

      recuperationManagementGuidancePatterns.setHgrid(200);

      addRecuperationManagementGuidancePatterns();
    }
    return recuperationManagementGuidancePatterns;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getRecuperationManagementGuidanceTimeContena(){
    if(recuperationManagementGuidanceTimeContena==null){

      recuperationManagementGuidanceTimeContena = new ACBackLabelContainer();

      addRecuperationManagementGuidanceTimeContena();
    }
    return recuperationManagementGuidanceTimeContena;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getRecuperationManagementGuidanceBeginTime(){
    if(recuperationManagementGuidanceBeginTime==null){

      recuperationManagementGuidanceBeginTime = new ACTimeComboBox();

      getRecuperationManagementGuidanceBeginTimeContainer().setText("開始時刻");

      recuperationManagementGuidanceBeginTime.setBindPath("3");

      recuperationManagementGuidanceBeginTime.setModelBindPath("3");

      recuperationManagementGuidanceBeginTime.setModel(getRecuperationManagementGuidanceBeginTimeModel());

      recuperationManagementGuidanceBeginTime.setRenderBindPath("CONTENT");

      addRecuperationManagementGuidanceBeginTime();
    }
    return recuperationManagementGuidanceBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceBeginTimeContainer(){
    if(recuperationManagementGuidanceBeginTimeContainer==null){
      recuperationManagementGuidanceBeginTimeContainer = new ACLabelContainer();
      recuperationManagementGuidanceBeginTimeContainer.add(getRecuperationManagementGuidanceBeginTime(), null);
    }
    return recuperationManagementGuidanceBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getRecuperationManagementGuidanceBeginTimeModel(){
    if(recuperationManagementGuidanceBeginTimeModel==null){
      recuperationManagementGuidanceBeginTimeModel = new ACComboBoxModelAdapter();
      addRecuperationManagementGuidanceBeginTimeModel();
    }
    return recuperationManagementGuidanceBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getRecuperationManagementGuidanceEndTime(){
    if(recuperationManagementGuidanceEndTime==null){

      recuperationManagementGuidanceEndTime = new ACTimeComboBox();

      getRecuperationManagementGuidanceEndTimeContainer().setText("終了時刻");

      recuperationManagementGuidanceEndTime.setBindPath("4");

      recuperationManagementGuidanceEndTime.setModelBindPath("4");

      recuperationManagementGuidanceEndTime.setModel(getRecuperationManagementGuidanceEndTimeModel());

      recuperationManagementGuidanceEndTime.setRenderBindPath("CONTENT");

      addRecuperationManagementGuidanceEndTime();
    }
    return recuperationManagementGuidanceEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceEndTimeContainer(){
    if(recuperationManagementGuidanceEndTimeContainer==null){
      recuperationManagementGuidanceEndTimeContainer = new ACLabelContainer();
      recuperationManagementGuidanceEndTimeContainer.add(getRecuperationManagementGuidanceEndTime(), null);
    }
    return recuperationManagementGuidanceEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getRecuperationManagementGuidanceEndTimeModel(){
    if(recuperationManagementGuidanceEndTimeModel==null){
      recuperationManagementGuidanceEndTimeModel = new ACComboBoxModelAdapter();
      addRecuperationManagementGuidanceEndTimeModel();
    }
    return recuperationManagementGuidanceEndTimeModel;
  }

  /**
   * 職種を取得します。
   * @return 職種
   */
  public ACVerticalRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategory(){
    if(recuperationManagementGuidanceOccupationalCategory==null){

      recuperationManagementGuidanceOccupationalCategory = new ACVerticalRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryContainer().setText("職員区分");

      recuperationManagementGuidanceOccupationalCategory.setBindPath("1310103");

      recuperationManagementGuidanceOccupationalCategory.setModel(getRecuperationManagementGuidanceOccupationalCategoryModel());

      recuperationManagementGuidanceOccupationalCategory.setUseClearButton(false);

      addRecuperationManagementGuidanceOccupationalCategory();
    }
    return recuperationManagementGuidanceOccupationalCategory;

  }

  /**
   * 職種コンテナを取得します。
   * @return 職種コンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryContainer==null){
      recuperationManagementGuidanceOccupationalCategoryContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryContainer.add(getRecuperationManagementGuidanceOccupationalCategory(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryContainer;
  }

  /**
   * 職種モデルを取得します。
   * @return 職種モデル
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryModel(){
    if(recuperationManagementGuidanceOccupationalCategoryModel==null){
      recuperationManagementGuidanceOccupationalCategoryModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryModel;
  }

  /**
   * 医師を取得します。
   * @return 医師
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDoctor(){
    if(recuperationManagementGuidanceOccupationalCategoryDoctor==null){

      recuperationManagementGuidanceOccupationalCategoryDoctor = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDoctor.setText("医師");

      recuperationManagementGuidanceOccupationalCategoryDoctor.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDoctor.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDoctor();
    }
    return recuperationManagementGuidanceOccupationalCategoryDoctor;

  }

  /**
   * 歯科医師を取得します。
   * @return 歯科医師
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDentist(){
    if(recuperationManagementGuidanceOccupationalCategoryDentist==null){

      recuperationManagementGuidanceOccupationalCategoryDentist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDentist.setText("歯科医師");

      recuperationManagementGuidanceOccupationalCategoryDentist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDentist.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDentist();
    }
    return recuperationManagementGuidanceOccupationalCategoryDentist;

  }

  /**
   * 薬剤師（医療機関）を取得します。
   * @return 薬剤師（医療機関）
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setText("薬剤師（医療機関）");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist;

  }

  /**
   * 薬剤師（薬局）を取得します。
   * @return 薬剤師（薬局）
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist(){
    if(recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist==null){

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setText("薬剤師（薬局）");

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist();
    }
    return recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist;

  }

  /**
   * 栄養士を取得します。
   * @return 栄養士
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDietitian(){
    if(recuperationManagementGuidanceOccupationalCategoryDietitian==null){

      recuperationManagementGuidanceOccupationalCategoryDietitian = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDietitian.setText("栄養士");

      recuperationManagementGuidanceOccupationalCategoryDietitian.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDietitian.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDietitian();
    }
    return recuperationManagementGuidanceOccupationalCategoryDietitian;

  }

  /**
   * 歯科衛生士等を取得します。
   * @return 歯科衛生士等
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryEtc(){
    if(recuperationManagementGuidanceOccupationalCategoryEtc==null){

      recuperationManagementGuidanceOccupationalCategoryEtc = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryEtc.setText("歯科衛生士等");

      recuperationManagementGuidanceOccupationalCategoryEtc.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryEtc.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryEtc();
    }
    return recuperationManagementGuidanceOccupationalCategoryEtc;

  }

  /**
   * 在総診を取得します。
   * @return 在総診
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer().setText("在総診");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setBindPath("1310104");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel());

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setUseClearButton(false);

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio;

  }

  /**
   * 在総診コンテナを取得します。
   * @return 在総診コンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer;
  }

  /**
   * 在総診モデルを取得します。
   * @return 在総診モデル
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel==null){
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1.setText("なし");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1.setGroup(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio());

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2.setText("あり");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2.setGroup(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio());

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2;

  }

  /**
   * 特別薬剤を取得します。
   * @return 特別薬剤
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer().setText("特別薬剤");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setBindPath("1310105");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setUseClearButton(false);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio;

  }

  /**
   * 特別薬剤コンテナを取得します。
   * @return 特別薬剤コンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer;
  }

  /**
   * 特別薬剤モデルを取得します。
   * @return 特別薬剤モデル
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel==null){
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setText("なし");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setGroup(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setText("あり");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setGroup(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2;

  }

  /**
   * 回数を取得します。
   * @return 回数
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio==null){

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer().setText("回数");

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio.setBindPath("1310106");

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel());

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio.setUseClearButton(false);

      addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio;

  }

  /**
   * 回数コンテナを取得します。
   * @return 回数コンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer;
  }

  /**
   * 回数モデルを取得します。
   * @return 回数モデル
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel(){
    if(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel==null){
      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel;
  }

  /**
   * 1回目を取得します。
   * @return 1回目
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1(){
    if(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1==null){

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1.setText("1回目");

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1.setGroup(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio());

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1();
    }
    return recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1;

  }

  /**
   * 2回目以降を取得します。
   * @return 2回目以降
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2(){
    if(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2==null){

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2.setText("2回目以降");

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2.setGroup(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio());

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2();
    }
    return recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001017Design() {

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

    this.add(getRecuperationManagementGuidancePatterns(), VRLayout.WEST);

  }

  /**
   * 短期入所療養介護（居宅療養管理指導）パターン領域）に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidancePatterns(){

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimeContena(){

    recuperationManagementGuidanceTimeContena.add(getRecuperationManagementGuidanceBeginTimeContainer(), VRLayout.FLOW);

    recuperationManagementGuidanceTimeContena.add(getRecuperationManagementGuidanceEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceEndTimeModel(){

  }

  /**
   * 職種に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategory(){

  }

  /**
   * 職種モデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryModel(){

    getRecuperationManagementGuidanceOccupationalCategoryDoctor().setButtonIndex(1);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDoctor());

    getRecuperationManagementGuidanceOccupationalCategoryDentist().setButtonIndex(2);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDentist());

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist().setButtonIndex(3);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist());

    getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist().setButtonIndex(4);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist());

    getRecuperationManagementGuidanceOccupationalCategoryDietitian().setButtonIndex(5);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDietitian());

    getRecuperationManagementGuidanceOccupationalCategoryEtc().setButtonIndex(6);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryEtc());

  }

  /**
   * 医師に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDoctor(){

  }

  /**
   * 歯科医師に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDentist(){

  }

  /**
   * 薬剤師（医療機関）に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist(){

  }

  /**
   * 薬剤師（薬局）に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist(){

  }

  /**
   * 栄養士に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDietitian(){

  }

  /**
   * 歯科衛生士等に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryEtc(){

  }

  /**
   * 在総診に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(){

  }

  /**
   * 在総診モデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel(){

    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1());

    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2(){

  }

  /**
   * 特別薬剤に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(){

  }

  /**
   * 特別薬剤モデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel(){

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1());

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2(){

  }

  /**
   * 回数に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio(){

  }

  /**
   * 回数モデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel(){

    getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1());

    getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2());

  }

  /**
   * 1回目に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1(){

  }

  /**
   * 2回目以降に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2(){

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.getInstance().getContentPane().add(new QS001017Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001017Design getThis() {
    return this;
  }
}
