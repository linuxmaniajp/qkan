
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
 * 開発者: 松本　幸一
 * 作成日: 2006/03/29  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン短期入所療養介護（居宅療養管理指導） (QS001106)
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
 * サービスパターン短期入所療養介護（居宅療養管理指導）画面項目デザイン(QS001106) 
 */
public class QS001106Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel recuperationManagementGuidancePatterns;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceOccupationalCategory;

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

  private ACClearableRadioButtonGroup recuperationManagementGuidanceInfoAddRadio;

  private ACLabelContainer recuperationManagementGuidanceInfoAddRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceInfoAddRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceInfoAddRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceInfoAddRadioItem2;

  private ACGroupBox recuperationManagementGuidanceTimesGroup;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceTimesHospitalRadio;

  private ACLabelContainer recuperationManagementGuidanceTimesHospitalRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceTimesHospitalRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceTimesHospitalRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceTimesHospitalRadioItem2;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceTimesDrugstoreRadio;

  private ACLabelContainer recuperationManagementGuidanceTimesDrugstoreRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceTimesDrugstoreRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceTimesDrugstoreRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceTimesDrugstoreRadioItem2;

  private ACIntegerCheckBox recuperationManagementGuidanceTimesCancerEndCheck;

  private ACBackLabelContainer recuperationManagementGuidanceTimeContena;

  private ACTimeComboBox recuperationManagementGuidanceBeginTime;

  private ACLabelContainer recuperationManagementGuidanceBeginTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceBeginTimeModel;

  private ACTimeComboBox recuperationManagementGuidanceEndTime;

  private ACLabelContainer recuperationManagementGuidanceEndTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceEndTimeModel;

  //getter

  /**
   * 短期入所療養介護（居宅療養管理指導）パターン領域）を取得します。
   * @return 短期入所療養介護（居宅療養管理指導）パターン領域）
   */
  public ACPanel getRecuperationManagementGuidancePatterns(){
    if(recuperationManagementGuidancePatterns==null){

      recuperationManagementGuidancePatterns = new ACPanel();

      recuperationManagementGuidancePatterns.setAutoWrap(false);

      recuperationManagementGuidancePatterns.setHgap(0);

      recuperationManagementGuidancePatterns.setHgrid(200);

      addRecuperationManagementGuidancePatterns();
    }
    return recuperationManagementGuidancePatterns;

  }

  /**
   * 職種を取得します。
   * @return 職種
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategory(){
    if(recuperationManagementGuidanceOccupationalCategory==null){

      recuperationManagementGuidanceOccupationalCategory = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryContainer().setText("担当者区分");

      recuperationManagementGuidanceOccupationalCategory.setBindPath("1310103");

      recuperationManagementGuidanceOccupationalCategory.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategory.setModel(getRecuperationManagementGuidanceOccupationalCategoryModel());

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
      recuperationManagementGuidanceOccupationalCategoryContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryContainer.setVAlignment(VRLayout.CENTER);
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

      recuperationManagementGuidanceOccupationalCategoryDoctor.setConstraints(VRLayout.FLOW);

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
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDietitian(){
    if(recuperationManagementGuidanceOccupationalCategoryDietitian==null){

      recuperationManagementGuidanceOccupationalCategoryDietitian = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDietitian.setText("管理栄養士");

      recuperationManagementGuidanceOccupationalCategoryDietitian.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDietitian.setConstraints(VRLayout.FLOW);

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
   * 在宅時医学総合管理料を取得します。
   * @return 在宅時医学総合管理料
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer().setText("在宅時医学総合管理料");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setBindPath("1310104");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel());

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio;

  }

  /**
   * 在宅時医学総合管理料コンテナを取得します。
   * @return 在宅時医学総合管理料コンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer;
  }

  /**
   * 在宅時医学総合管理料モデルを取得します。
   * @return 在宅時医学総合管理料モデル
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

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel());

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
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.setVAlignment(VRLayout.CENTER);
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
   * 情報提供未実施減算を取得します。
   * @return 情報提供未実施減算
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceInfoAddRadio(){
    if(recuperationManagementGuidanceInfoAddRadio==null){

      recuperationManagementGuidanceInfoAddRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceInfoAddRadioContainer().setText("情報提供未実施減算");

      recuperationManagementGuidanceInfoAddRadio.setBindPath("1310107");

      recuperationManagementGuidanceInfoAddRadio.setUseClearButton(false);

      recuperationManagementGuidanceInfoAddRadio.setModel(getRecuperationManagementGuidanceInfoAddRadioModel());

      addRecuperationManagementGuidanceInfoAddRadio();
    }
    return recuperationManagementGuidanceInfoAddRadio;

  }

  /**
   * 情報提供未実施減算コンテナを取得します。
   * @return 情報提供未実施減算コンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceInfoAddRadioContainer(){
    if(recuperationManagementGuidanceInfoAddRadioContainer==null){
      recuperationManagementGuidanceInfoAddRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceInfoAddRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceInfoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceInfoAddRadioContainer.add(getRecuperationManagementGuidanceInfoAddRadio(), null);
    }
    return recuperationManagementGuidanceInfoAddRadioContainer;
  }

  /**
   * 情報提供未実施減算モデルを取得します。
   * @return 情報提供未実施減算モデル
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceInfoAddRadioModel(){
    if(recuperationManagementGuidanceInfoAddRadioModel==null){
      recuperationManagementGuidanceInfoAddRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceInfoAddRadioModel();
    }
    return recuperationManagementGuidanceInfoAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceInfoAddRadioItem1(){
    if(recuperationManagementGuidanceInfoAddRadioItem1==null){

      recuperationManagementGuidanceInfoAddRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceInfoAddRadioItem1.setText("なし");

      recuperationManagementGuidanceInfoAddRadioItem1.setGroup(getRecuperationManagementGuidanceInfoAddRadio());

      recuperationManagementGuidanceInfoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceInfoAddRadioItem1();
    }
    return recuperationManagementGuidanceInfoAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceInfoAddRadioItem2(){
    if(recuperationManagementGuidanceInfoAddRadioItem2==null){

      recuperationManagementGuidanceInfoAddRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceInfoAddRadioItem2.setText("あり");

      recuperationManagementGuidanceInfoAddRadioItem2.setGroup(getRecuperationManagementGuidanceInfoAddRadio());

      recuperationManagementGuidanceInfoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceInfoAddRadioItem2();
    }
    return recuperationManagementGuidanceInfoAddRadioItem2;

  }

  /**
   * 薬剤師居宅療養管理指導回数を取得します。
   * @return 薬剤師居宅療養管理指導回数
   */
  public ACGroupBox getRecuperationManagementGuidanceTimesGroup(){
    if(recuperationManagementGuidanceTimesGroup==null){

      recuperationManagementGuidanceTimesGroup = new ACGroupBox();

      recuperationManagementGuidanceTimesGroup.setText("薬剤師居宅療養管理指導回数");

      recuperationManagementGuidanceTimesGroup.setFollowChildEnabled(false);

      addRecuperationManagementGuidanceTimesGroup();
    }
    return recuperationManagementGuidanceTimesGroup;

  }

  /**
   * 薬剤師が医療機関を取得します。
   * @return 薬剤師が医療機関
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceTimesHospitalRadio(){
    if(recuperationManagementGuidanceTimesHospitalRadio==null){

      recuperationManagementGuidanceTimesHospitalRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceTimesHospitalRadioContainer().setText("薬剤師が医療機関");

      recuperationManagementGuidanceTimesHospitalRadio.setBindPath("1310108");

      recuperationManagementGuidanceTimesHospitalRadio.setUseClearButton(false);

      recuperationManagementGuidanceTimesHospitalRadio.setModel(getRecuperationManagementGuidanceTimesHospitalRadioModel());

      addRecuperationManagementGuidanceTimesHospitalRadio();
    }
    return recuperationManagementGuidanceTimesHospitalRadio;

  }

  /**
   * 薬剤師が医療機関コンテナを取得します。
   * @return 薬剤師が医療機関コンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceTimesHospitalRadioContainer(){
    if(recuperationManagementGuidanceTimesHospitalRadioContainer==null){
      recuperationManagementGuidanceTimesHospitalRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceTimesHospitalRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceTimesHospitalRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceTimesHospitalRadioContainer.add(getRecuperationManagementGuidanceTimesHospitalRadio(), null);
    }
    return recuperationManagementGuidanceTimesHospitalRadioContainer;
  }

  /**
   * 薬剤師が医療機関モデルを取得します。
   * @return 薬剤師が医療機関モデル
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceTimesHospitalRadioModel(){
    if(recuperationManagementGuidanceTimesHospitalRadioModel==null){
      recuperationManagementGuidanceTimesHospitalRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceTimesHospitalRadioModel();
    }
    return recuperationManagementGuidanceTimesHospitalRadioModel;
  }

  /**
   * 1回目又は2回目を取得します。
   * @return 1回目又は2回目
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceTimesHospitalRadioItem1(){
    if(recuperationManagementGuidanceTimesHospitalRadioItem1==null){

      recuperationManagementGuidanceTimesHospitalRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceTimesHospitalRadioItem1.setText("1回目又は2回目");

      recuperationManagementGuidanceTimesHospitalRadioItem1.setGroup(getRecuperationManagementGuidanceTimesHospitalRadio());

      recuperationManagementGuidanceTimesHospitalRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceTimesHospitalRadioItem1();
    }
    return recuperationManagementGuidanceTimesHospitalRadioItem1;

  }

  /**
   * 3回目以降を取得します。
   * @return 3回目以降
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceTimesHospitalRadioItem2(){
    if(recuperationManagementGuidanceTimesHospitalRadioItem2==null){

      recuperationManagementGuidanceTimesHospitalRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceTimesHospitalRadioItem2.setText("3回目以降");

      recuperationManagementGuidanceTimesHospitalRadioItem2.setGroup(getRecuperationManagementGuidanceTimesHospitalRadio());

      recuperationManagementGuidanceTimesHospitalRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceTimesHospitalRadioItem2();
    }
    return recuperationManagementGuidanceTimesHospitalRadioItem2;

  }

  /**
   * 薬剤師が薬局を取得します。
   * @return 薬剤師が薬局
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceTimesDrugstoreRadio(){
    if(recuperationManagementGuidanceTimesDrugstoreRadio==null){

      recuperationManagementGuidanceTimesDrugstoreRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceTimesDrugstoreRadioContainer().setText("薬剤師が薬局");

      recuperationManagementGuidanceTimesDrugstoreRadio.setBindPath("1310109");

      recuperationManagementGuidanceTimesDrugstoreRadio.setUseClearButton(false);

      recuperationManagementGuidanceTimesDrugstoreRadio.setModel(getRecuperationManagementGuidanceTimesDrugstoreRadioModel());

      addRecuperationManagementGuidanceTimesDrugstoreRadio();
    }
    return recuperationManagementGuidanceTimesDrugstoreRadio;

  }

  /**
   * 薬剤師が薬局コンテナを取得します。
   * @return 薬剤師が薬局コンテナ
   */
  protected ACLabelContainer getRecuperationManagementGuidanceTimesDrugstoreRadioContainer(){
    if(recuperationManagementGuidanceTimesDrugstoreRadioContainer==null){
      recuperationManagementGuidanceTimesDrugstoreRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceTimesDrugstoreRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceTimesDrugstoreRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceTimesDrugstoreRadioContainer.add(getRecuperationManagementGuidanceTimesDrugstoreRadio(), null);
    }
    return recuperationManagementGuidanceTimesDrugstoreRadioContainer;
  }

  /**
   * 薬剤師が薬局モデルを取得します。
   * @return 薬剤師が薬局モデル
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceTimesDrugstoreRadioModel(){
    if(recuperationManagementGuidanceTimesDrugstoreRadioModel==null){
      recuperationManagementGuidanceTimesDrugstoreRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceTimesDrugstoreRadioModel();
    }
    return recuperationManagementGuidanceTimesDrugstoreRadioModel;
  }

  /**
   * 1回目を取得します。
   * @return 1回目
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceTimesDrugstoreRadioItem1(){
    if(recuperationManagementGuidanceTimesDrugstoreRadioItem1==null){

      recuperationManagementGuidanceTimesDrugstoreRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceTimesDrugstoreRadioItem1.setText("1回目");

      recuperationManagementGuidanceTimesDrugstoreRadioItem1.setGroup(getRecuperationManagementGuidanceTimesDrugstoreRadio());

      recuperationManagementGuidanceTimesDrugstoreRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceTimesDrugstoreRadioItem1();
    }
    return recuperationManagementGuidanceTimesDrugstoreRadioItem1;

  }

  /**
   * 2回目以降を取得します。
   * @return 2回目以降
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceTimesDrugstoreRadioItem2(){
    if(recuperationManagementGuidanceTimesDrugstoreRadioItem2==null){

      recuperationManagementGuidanceTimesDrugstoreRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceTimesDrugstoreRadioItem2.setText("2回目以降");

      recuperationManagementGuidanceTimesDrugstoreRadioItem2.setGroup(getRecuperationManagementGuidanceTimesDrugstoreRadio());

      recuperationManagementGuidanceTimesDrugstoreRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceTimesDrugstoreRadioItem2();
    }
    return recuperationManagementGuidanceTimesDrugstoreRadioItem2;

  }

  /**
   * ガン末期を取得します。
   * @return ガン末期
   */
  public ACIntegerCheckBox getRecuperationManagementGuidanceTimesCancerEndCheck(){
    if(recuperationManagementGuidanceTimesCancerEndCheck==null){

      recuperationManagementGuidanceTimesCancerEndCheck = new ACIntegerCheckBox();

      recuperationManagementGuidanceTimesCancerEndCheck.setText("ガン末期");

      recuperationManagementGuidanceTimesCancerEndCheck.setBindPath("1310110");

      recuperationManagementGuidanceTimesCancerEndCheck.setSelectValue(2);

      recuperationManagementGuidanceTimesCancerEndCheck.setUnSelectValue(1);

      addRecuperationManagementGuidanceTimesCancerEndCheck();
    }
    return recuperationManagementGuidanceTimesCancerEndCheck;

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

      recuperationManagementGuidanceBeginTime.setRenderBindPath("CONTENT");

      recuperationManagementGuidanceBeginTime.setModel(getRecuperationManagementGuidanceBeginTimeModel());

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
      recuperationManagementGuidanceBeginTimeContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceBeginTimeContainer.setVAlignment(VRLayout.CENTER);
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

      recuperationManagementGuidanceEndTime.setRenderBindPath("CONTENT");

      recuperationManagementGuidanceEndTime.setModel(getRecuperationManagementGuidanceEndTimeModel());

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
      recuperationManagementGuidanceEndTimeContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceEndTimeContainer.setVAlignment(VRLayout.CENTER);
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
   * コンストラクタです。
   */
  public QS001106Design() {

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

    this.add(getRecuperationManagementGuidancePatterns(), VRLayout.CLIENT);

  }

  /**
   * 短期入所療養介護（居宅療養管理指導）パターン領域）に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidancePatterns(){

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceInfoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceTimesGroup(), VRLayout.FLOW_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
   * 管理栄養士に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDietitian(){

  }

  /**
   * 歯科衛生士等に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryEtc(){

  }

  /**
   * 在宅時医学総合管理料に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(){

  }

  /**
   * 在宅時医学総合管理料モデルに内部項目を追加します。
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
   * 情報提供未実施減算に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceInfoAddRadio(){

  }

  /**
   * 情報提供未実施減算モデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceInfoAddRadioModel(){

    getRecuperationManagementGuidanceInfoAddRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceInfoAddRadioModel().add(getRecuperationManagementGuidanceInfoAddRadioItem1());

    getRecuperationManagementGuidanceInfoAddRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceInfoAddRadioModel().add(getRecuperationManagementGuidanceInfoAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceInfoAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceInfoAddRadioItem2(){

  }

  /**
   * 薬剤師居宅療養管理指導回数に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesGroup(){

    recuperationManagementGuidanceTimesGroup.add(getRecuperationManagementGuidanceTimesHospitalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidanceTimesGroup.add(getRecuperationManagementGuidanceTimesDrugstoreRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidanceTimesGroup.add(getRecuperationManagementGuidanceTimesCancerEndCheck(), VRLayout.FLOW);

  }

  /**
   * 薬剤師が医療機関に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesHospitalRadio(){

  }

  /**
   * 薬剤師が医療機関モデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesHospitalRadioModel(){

    getRecuperationManagementGuidanceTimesHospitalRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceTimesHospitalRadioModel().add(getRecuperationManagementGuidanceTimesHospitalRadioItem1());

    getRecuperationManagementGuidanceTimesHospitalRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceTimesHospitalRadioModel().add(getRecuperationManagementGuidanceTimesHospitalRadioItem2());

  }

  /**
   * 1回目又は2回目に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesHospitalRadioItem1(){

  }

  /**
   * 3回目以降に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesHospitalRadioItem2(){

  }

  /**
   * 薬剤師が薬局に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesDrugstoreRadio(){

  }

  /**
   * 薬剤師が薬局モデルに内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesDrugstoreRadioModel(){

    getRecuperationManagementGuidanceTimesDrugstoreRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceTimesDrugstoreRadioModel().add(getRecuperationManagementGuidanceTimesDrugstoreRadioItem1());

    getRecuperationManagementGuidanceTimesDrugstoreRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceTimesDrugstoreRadioModel().add(getRecuperationManagementGuidanceTimesDrugstoreRadioItem2());

  }

  /**
   * 1回目に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesDrugstoreRadioItem1(){

  }

  /**
   * 2回目以降に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesDrugstoreRadioItem2(){

  }

  /**
   * ガン末期に内部項目を追加します。
   */
  protected void addRecuperationManagementGuidanceTimesCancerEndCheck(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001106Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001106Design getThis() {
    return this;
  }
}
