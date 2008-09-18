
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
 * 作成日: 2006/02/18  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その多機能 (O)
 * プロセス 事業所情報登録 (004)
 * プログラム 短期入所療養介護（介護老人保健施設） (QO004009)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * 短期入所療養介護（介護老人保健施設）画面項目デザイン(QO004009) 
 */
public class QO004009Design extends ACPanel {
  //GUIコンポーネント

  private ACGroupBox shortStayCareOldPersonGroup;

  private ACLabelContainer shortStayCareOldPersonDiscountConteiner;

  private ACTextField shortStayCareOldPersonDiscountText;

  private ACLabel shortStayCareOldPersonDiscountLabel;

  private ACClearableRadioButtonGroup shortStayCareOldPersonInstitutionDivisionRadio;

  private ACLabelContainer shortStayCareOldPersonInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayCareOldPersonInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayCareOldPersonNightWorkDivisionRadio;

  private ACLabelContainer shortStayCareOldPersonNightWorkDivisionRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonNightWorkDivisionRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonNightWorkDivisionOn;

  private ACRadioButtonItem shortStayCareOldPersonNightWorkDivisionOff;

  private ACClearableRadioButtonGroup shortStayCareOldPersonRehabilitationRadio;

  private ACLabelContainer shortStayCareOldPersonRehabilitationRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonRehabilitationRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonRehabilitationOff;

  private ACRadioButtonItem shortStayCareOldPersonRehabilitationOn;

  private ACClearableRadioButtonGroup shortStayCareOldPersonCognitiveRadio;

  private ACLabelContainer shortStayCareOldPersonCognitiveRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonCognitiveRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonCognitiveOff;

  private ACRadioButtonItem shortStayCareOldPersonCognitiveOn;

  private ACClearableRadioButtonGroup shortStayCareOldPersonMeetingAndSendingRadio;

  private ACLabelContainer shortStayCareOldPersonMeetingAndSendingRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonMeetingAndSendingRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonMeetingAndSendingOff;

  private ACRadioButtonItem shortStayCareOldPersonMeetingAndSendingOn;

  private ACClearableRadioButtonGroup shortStayCareOldPersonRecuperationNutritionManageRadio;

  private ACLabelContainer shortStayCareOldPersonRecuperationNutritionManageRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonRecuperationNutritionManageRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonRecuperationNutritionManageOff;

  private ACRadioButtonItem shortStayCareOldPersonNutritionManageOn;

  private ACClearableRadioButtonGroup shortStayCareOldPersonRecuperationRadio;

  private ACLabelContainer shortStayCareOldPersonRecuperationRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonRecuperationRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonOff;

  private ACRadioButtonItem shortStayCareOldPersonOn;

  private ACClearableRadioButtonGroup shortStayCareOldPersonStaffReduceRadio;

  private ACLabelContainer shortStayCareOldPersonStaffReduceRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonStaffReduceRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonStaffReduceRadioItem1;

  private ACRadioButtonItem shortStayCareOldPersonStaffReduceRadioItem2;

  private ACRadioButtonItem shortStayCareOldPersonStaffReduceRadioItem3;

  private ACLabelContainer shortStayCareOldPersonDinnerStandardConteinar;

  private ACTextField shortStayCareOldPersonDinnerStandarTotal;

  private ACLabel shortStayCareOldPersonMorningDinnerStandardMoneyLabel;

  private ACTextField shortStayCareOldPersonMorningDinnerStandardMoney;

  private ACLabel shortStayCareOldPersonNoonDinnerStandardMoneyLabel;

  private ACTextField shortStayCareOldPersonNoonDinnerStandardMoney;

  private ACLabel shortStayCareOldPersonNightDinnerStandardMoneyLabel;

  private ACTextField shortStayCareOldPersonNightDinnerStandardMoney;

  private ACLabel shortStayCareOldPersonDinnerStandarTotalLabel;

  private ACLabelContainer shortStayCareOldPersonUnitRoomContainar;

  private ACTextField shortStayCareOldPersonUnitRoomText;

  private ACLabel shortStayCareOldPersonUnitRoomLabel;

  private ACLabelContainer shortStayCareOldPersonUnitSemiRoomContainar;

  private ACTextField shortStayCareOldPersonUnitSemiRoomText;

  private ACLabel shortStayCareOldPersonUnitSemiRoomLabel;

  private ACLabelContainer shortStayCareOldPersonNormalRoomContainar;

  private ACTextField shortStayCareOldPersonNormalRoomText;

  private ACLabel shortStayCareOldPersonNormalRoomLabel;

  private ACLabelContainer shortStayCareOldPersonTasyouRoomContainar;

  private ACTextField shortStayCareOldPersonTasyouRoomText;

  private ACLabel shortStayCareOldPersonTasyouRoomLabel;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getShortStayCareOldPersonGroup(){
    if(shortStayCareOldPersonGroup==null){

      shortStayCareOldPersonGroup = new ACGroupBox();

      shortStayCareOldPersonGroup.setText("短期入所療養介護（介護老人保健施設）");

      shortStayCareOldPersonGroup.setFollowChildEnabled(true);

      shortStayCareOldPersonGroup.setHgrid(200);

      addShortStayCareOldPersonGroup();
    }
    return shortStayCareOldPersonGroup;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getShortStayCareOldPersonDiscountConteiner(){
    if(shortStayCareOldPersonDiscountConteiner==null){

      shortStayCareOldPersonDiscountConteiner = new ACLabelContainer();

      shortStayCareOldPersonDiscountConteiner.setText("割引率");

      shortStayCareOldPersonDiscountConteiner.setFollowChildEnabled(true);

      addShortStayCareOldPersonDiscountConteiner();
    }
    return shortStayCareOldPersonDiscountConteiner;

  }

  /**
   * テキストを取得します。
   * @return テキスト
   */
  public ACTextField getShortStayCareOldPersonDiscountText(){
    if(shortStayCareOldPersonDiscountText==null){

      shortStayCareOldPersonDiscountText = new ACTextField();

      shortStayCareOldPersonDiscountText.setBindPath("REDUCT_RATE");

      shortStayCareOldPersonDiscountText.setColumns(3);

      shortStayCareOldPersonDiscountText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonDiscountText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonDiscountText.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonDiscountText.setMaxLength(3);

      addShortStayCareOldPersonDiscountText();
    }
    return shortStayCareOldPersonDiscountText;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getShortStayCareOldPersonDiscountLabel(){
    if(shortStayCareOldPersonDiscountLabel==null){

      shortStayCareOldPersonDiscountLabel = new ACLabel();

      shortStayCareOldPersonDiscountLabel.setText("％");

      addShortStayCareOldPersonDiscountLabel();
    }
    return shortStayCareOldPersonDiscountLabel;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonInstitutionDivisionRadio(){
    if(shortStayCareOldPersonInstitutionDivisionRadio==null){

      shortStayCareOldPersonInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonInstitutionDivisionRadioContainer().setText("施設区分");

      shortStayCareOldPersonInstitutionDivisionRadio.setBindPath("1220101");

      shortStayCareOldPersonInstitutionDivisionRadio.setModel(getShortStayCareOldPersonInstitutionDivisionRadioModel());

      shortStayCareOldPersonInstitutionDivisionRadio.setUseClearButton(false);

      addShortStayCareOldPersonInstitutionDivisionRadio();
    }
    return shortStayCareOldPersonInstitutionDivisionRadio;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayCareOldPersonInstitutionDivisionRadioContainer(){
    if(shortStayCareOldPersonInstitutionDivisionRadioContainer==null){
      shortStayCareOldPersonInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonInstitutionDivisionRadioContainer.add(getShortStayCareOldPersonInstitutionDivisionRadio(), null);
    }
    return shortStayCareOldPersonInstitutionDivisionRadioContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayCareOldPersonInstitutionDivisionRadioModel(){
    if(shortStayCareOldPersonInstitutionDivisionRadioModel==null){
      shortStayCareOldPersonInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonInstitutionDivisionRadioModel();
    }
    return shortStayCareOldPersonInstitutionDivisionRadioModel;
  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getShortStayCareOldPersonInstitutionDivisionRadioItem1(){
    if(shortStayCareOldPersonInstitutionDivisionRadioItem1==null){

      shortStayCareOldPersonInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayCareOldPersonInstitutionDivisionRadioItem1.setText("介護老人保健施設");

      shortStayCareOldPersonInstitutionDivisionRadioItem1.setGroup(getShortStayCareOldPersonInstitutionDivisionRadio());

      addShortStayCareOldPersonInstitutionDivisionRadioItem1();
    }
    return shortStayCareOldPersonInstitutionDivisionRadioItem1;

  }

  /**
   * ユニット型介護老人保健施設を取得します。
   * @return ユニット型介護老人保健施設
   */
  public ACRadioButtonItem getShortStayCareOldPersonInstitutionDivisionRadioItem2(){
    if(shortStayCareOldPersonInstitutionDivisionRadioItem2==null){

      shortStayCareOldPersonInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayCareOldPersonInstitutionDivisionRadioItem2.setText("ユニット型介護老人保健施設");

      shortStayCareOldPersonInstitutionDivisionRadioItem2.setGroup(getShortStayCareOldPersonInstitutionDivisionRadio());

      addShortStayCareOldPersonInstitutionDivisionRadioItem2();
    }
    return shortStayCareOldPersonInstitutionDivisionRadioItem2;

  }

  /**
   * 夜間勤務条件基準ラジオグループを取得します。
   * @return 夜間勤務条件基準ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonNightWorkDivisionRadio(){
    if(shortStayCareOldPersonNightWorkDivisionRadio==null){

      shortStayCareOldPersonNightWorkDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonNightWorkDivisionRadioContainer().setText("夜間勤務条件基準");

      shortStayCareOldPersonNightWorkDivisionRadio.setBindPath("1220102");

      shortStayCareOldPersonNightWorkDivisionRadio.setModel(getShortStayCareOldPersonNightWorkDivisionRadioModel());

      shortStayCareOldPersonNightWorkDivisionRadio.setUseClearButton(false);

      addShortStayCareOldPersonNightWorkDivisionRadio();
    }
    return shortStayCareOldPersonNightWorkDivisionRadio;

  }

  /**
   * 夜間勤務条件基準ラジオグループコンテナを取得します。
   * @return 夜間勤務条件基準ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayCareOldPersonNightWorkDivisionRadioContainer(){
    if(shortStayCareOldPersonNightWorkDivisionRadioContainer==null){
      shortStayCareOldPersonNightWorkDivisionRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonNightWorkDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonNightWorkDivisionRadioContainer.add(getShortStayCareOldPersonNightWorkDivisionRadio(), null);
    }
    return shortStayCareOldPersonNightWorkDivisionRadioContainer;
  }

  /**
   * 夜間勤務条件基準ラジオグループモデルを取得します。
   * @return 夜間勤務条件基準ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayCareOldPersonNightWorkDivisionRadioModel(){
    if(shortStayCareOldPersonNightWorkDivisionRadioModel==null){
      shortStayCareOldPersonNightWorkDivisionRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonNightWorkDivisionRadioModel();
    }
    return shortStayCareOldPersonNightWorkDivisionRadioModel;
  }

  /**
   * 基準型を取得します。
   * @return 基準型
   */
  public ACRadioButtonItem getShortStayCareOldPersonNightWorkDivisionOn(){
    if(shortStayCareOldPersonNightWorkDivisionOn==null){

      shortStayCareOldPersonNightWorkDivisionOn = new ACRadioButtonItem();

      shortStayCareOldPersonNightWorkDivisionOn.setText("基準型");

      shortStayCareOldPersonNightWorkDivisionOn.setGroup(getShortStayCareOldPersonNightWorkDivisionRadio());

      addShortStayCareOldPersonNightWorkDivisionOn();
    }
    return shortStayCareOldPersonNightWorkDivisionOn;

  }

  /**
   * 減算型を取得します。
   * @return 減算型
   */
  public ACRadioButtonItem getShortStayCareOldPersonNightWorkDivisionOff(){
    if(shortStayCareOldPersonNightWorkDivisionOff==null){

      shortStayCareOldPersonNightWorkDivisionOff = new ACRadioButtonItem();

      shortStayCareOldPersonNightWorkDivisionOff.setText("減算型");

      shortStayCareOldPersonNightWorkDivisionOff.setGroup(getShortStayCareOldPersonNightWorkDivisionRadio());

      addShortStayCareOldPersonNightWorkDivisionOff();
    }
    return shortStayCareOldPersonNightWorkDivisionOff;

  }

  /**
   * リハビリテーション機能強化ラジオグループを取得します。
   * @return リハビリテーション機能強化ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonRehabilitationRadio(){
    if(shortStayCareOldPersonRehabilitationRadio==null){

      shortStayCareOldPersonRehabilitationRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonRehabilitationRadioContainer().setText("リハビリ機能強化体制");

      shortStayCareOldPersonRehabilitationRadio.setBindPath("1220103");

      shortStayCareOldPersonRehabilitationRadio.setModel(getShortStayCareOldPersonRehabilitationRadioModel());

      shortStayCareOldPersonRehabilitationRadio.setUseClearButton(false);

      addShortStayCareOldPersonRehabilitationRadio();
    }
    return shortStayCareOldPersonRehabilitationRadio;

  }

  /**
   * リハビリテーション機能強化ラジオグループコンテナを取得します。
   * @return リハビリテーション機能強化ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayCareOldPersonRehabilitationRadioContainer(){
    if(shortStayCareOldPersonRehabilitationRadioContainer==null){
      shortStayCareOldPersonRehabilitationRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonRehabilitationRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonRehabilitationRadioContainer.add(getShortStayCareOldPersonRehabilitationRadio(), null);
    }
    return shortStayCareOldPersonRehabilitationRadioContainer;
  }

  /**
   * リハビリテーション機能強化ラジオグループモデルを取得します。
   * @return リハビリテーション機能強化ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayCareOldPersonRehabilitationRadioModel(){
    if(shortStayCareOldPersonRehabilitationRadioModel==null){
      shortStayCareOldPersonRehabilitationRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonRehabilitationRadioModel();
    }
    return shortStayCareOldPersonRehabilitationRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayCareOldPersonRehabilitationOff(){
    if(shortStayCareOldPersonRehabilitationOff==null){

      shortStayCareOldPersonRehabilitationOff = new ACRadioButtonItem();

      shortStayCareOldPersonRehabilitationOff.setText("なし");

      shortStayCareOldPersonRehabilitationOff.setGroup(getShortStayCareOldPersonRehabilitationRadio());

      addShortStayCareOldPersonRehabilitationOff();
    }
    return shortStayCareOldPersonRehabilitationOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayCareOldPersonRehabilitationOn(){
    if(shortStayCareOldPersonRehabilitationOn==null){

      shortStayCareOldPersonRehabilitationOn = new ACRadioButtonItem();

      shortStayCareOldPersonRehabilitationOn.setText("あり");

      shortStayCareOldPersonRehabilitationOn.setGroup(getShortStayCareOldPersonRehabilitationRadio());

      addShortStayCareOldPersonRehabilitationOn();
    }
    return shortStayCareOldPersonRehabilitationOn;

  }

  /**
   * 認知症専門棟ラジオグループを取得します。
   * @return 認知症専門棟ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonCognitiveRadio(){
    if(shortStayCareOldPersonCognitiveRadio==null){

      shortStayCareOldPersonCognitiveRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonCognitiveRadioContainer().setText("認知症専門棟");

      shortStayCareOldPersonCognitiveRadio.setBindPath("1220104");

      shortStayCareOldPersonCognitiveRadio.setModel(getShortStayCareOldPersonCognitiveRadioModel());

      shortStayCareOldPersonCognitiveRadio.setUseClearButton(false);

      addShortStayCareOldPersonCognitiveRadio();
    }
    return shortStayCareOldPersonCognitiveRadio;

  }

  /**
   * 認知症専門棟ラジオグループコンテナを取得します。
   * @return 認知症専門棟ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayCareOldPersonCognitiveRadioContainer(){
    if(shortStayCareOldPersonCognitiveRadioContainer==null){
      shortStayCareOldPersonCognitiveRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonCognitiveRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonCognitiveRadioContainer.add(getShortStayCareOldPersonCognitiveRadio(), null);
    }
    return shortStayCareOldPersonCognitiveRadioContainer;
  }

  /**
   * 認知症専門棟ラジオグループモデルを取得します。
   * @return 認知症専門棟ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayCareOldPersonCognitiveRadioModel(){
    if(shortStayCareOldPersonCognitiveRadioModel==null){
      shortStayCareOldPersonCognitiveRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonCognitiveRadioModel();
    }
    return shortStayCareOldPersonCognitiveRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayCareOldPersonCognitiveOff(){
    if(shortStayCareOldPersonCognitiveOff==null){

      shortStayCareOldPersonCognitiveOff = new ACRadioButtonItem();

      shortStayCareOldPersonCognitiveOff.setText("なし");

      shortStayCareOldPersonCognitiveOff.setGroup(getShortStayCareOldPersonCognitiveRadio());

      addShortStayCareOldPersonCognitiveOff();
    }
    return shortStayCareOldPersonCognitiveOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayCareOldPersonCognitiveOn(){
    if(shortStayCareOldPersonCognitiveOn==null){

      shortStayCareOldPersonCognitiveOn = new ACRadioButtonItem();

      shortStayCareOldPersonCognitiveOn.setText("あり");

      shortStayCareOldPersonCognitiveOn.setGroup(getShortStayCareOldPersonCognitiveRadio());

      addShortStayCareOldPersonCognitiveOn();
    }
    return shortStayCareOldPersonCognitiveOn;

  }

  /**
   * 送迎体制ラジオグループを取得します。
   * @return 送迎体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonMeetingAndSendingRadio(){
    if(shortStayCareOldPersonMeetingAndSendingRadio==null){

      shortStayCareOldPersonMeetingAndSendingRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonMeetingAndSendingRadioContainer().setText("送迎体制");

      shortStayCareOldPersonMeetingAndSendingRadio.setBindPath("1220105");

      shortStayCareOldPersonMeetingAndSendingRadio.setModel(getShortStayCareOldPersonMeetingAndSendingRadioModel());

      shortStayCareOldPersonMeetingAndSendingRadio.setUseClearButton(false);

      addShortStayCareOldPersonMeetingAndSendingRadio();
    }
    return shortStayCareOldPersonMeetingAndSendingRadio;

  }

  /**
   * 送迎体制ラジオグループコンテナを取得します。
   * @return 送迎体制ラジオグループコンテナ
   */
  protected ACLabelContainer getShortStayCareOldPersonMeetingAndSendingRadioContainer(){
    if(shortStayCareOldPersonMeetingAndSendingRadioContainer==null){
      shortStayCareOldPersonMeetingAndSendingRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonMeetingAndSendingRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonMeetingAndSendingRadioContainer.add(getShortStayCareOldPersonMeetingAndSendingRadio(), null);
    }
    return shortStayCareOldPersonMeetingAndSendingRadioContainer;
  }

  /**
   * 送迎体制ラジオグループモデルを取得します。
   * @return 送迎体制ラジオグループモデル
   */
  protected ACListModelAdapter getShortStayCareOldPersonMeetingAndSendingRadioModel(){
    if(shortStayCareOldPersonMeetingAndSendingRadioModel==null){
      shortStayCareOldPersonMeetingAndSendingRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonMeetingAndSendingRadioModel();
    }
    return shortStayCareOldPersonMeetingAndSendingRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayCareOldPersonMeetingAndSendingOff(){
    if(shortStayCareOldPersonMeetingAndSendingOff==null){

      shortStayCareOldPersonMeetingAndSendingOff = new ACRadioButtonItem();

      shortStayCareOldPersonMeetingAndSendingOff.setText("なし");

      shortStayCareOldPersonMeetingAndSendingOff.setGroup(getShortStayCareOldPersonMeetingAndSendingRadio());

      addShortStayCareOldPersonMeetingAndSendingOff();
    }
    return shortStayCareOldPersonMeetingAndSendingOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayCareOldPersonMeetingAndSendingOn(){
    if(shortStayCareOldPersonMeetingAndSendingOn==null){

      shortStayCareOldPersonMeetingAndSendingOn = new ACRadioButtonItem();

      shortStayCareOldPersonMeetingAndSendingOn.setText("あり");

      shortStayCareOldPersonMeetingAndSendingOn.setGroup(getShortStayCareOldPersonMeetingAndSendingRadio());

      addShortStayCareOldPersonMeetingAndSendingOn();
    }
    return shortStayCareOldPersonMeetingAndSendingOn;

  }

  /**
   * 栄養管理体制を取得します。
   * @return 栄養管理体制
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonRecuperationNutritionManageRadio(){
    if(shortStayCareOldPersonRecuperationNutritionManageRadio==null){

      shortStayCareOldPersonRecuperationNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonRecuperationNutritionManageRadioContainer().setText("栄養管理体制");

      shortStayCareOldPersonRecuperationNutritionManageRadio.setBindPath("1220106");

      shortStayCareOldPersonRecuperationNutritionManageRadio.setModel(getShortStayCareOldPersonRecuperationNutritionManageRadioModel());

      shortStayCareOldPersonRecuperationNutritionManageRadio.setUseClearButton(false);

      addShortStayCareOldPersonRecuperationNutritionManageRadio();
    }
    return shortStayCareOldPersonRecuperationNutritionManageRadio;

  }

  /**
   * 栄養管理体制コンテナを取得します。
   * @return 栄養管理体制コンテナ
   */
  protected ACLabelContainer getShortStayCareOldPersonRecuperationNutritionManageRadioContainer(){
    if(shortStayCareOldPersonRecuperationNutritionManageRadioContainer==null){
      shortStayCareOldPersonRecuperationNutritionManageRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonRecuperationNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonRecuperationNutritionManageRadioContainer.add(getShortStayCareOldPersonRecuperationNutritionManageRadio(), null);
    }
    return shortStayCareOldPersonRecuperationNutritionManageRadioContainer;
  }

  /**
   * 栄養管理体制モデルを取得します。
   * @return 栄養管理体制モデル
   */
  protected ACListModelAdapter getShortStayCareOldPersonRecuperationNutritionManageRadioModel(){
    if(shortStayCareOldPersonRecuperationNutritionManageRadioModel==null){
      shortStayCareOldPersonRecuperationNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonRecuperationNutritionManageRadioModel();
    }
    return shortStayCareOldPersonRecuperationNutritionManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayCareOldPersonRecuperationNutritionManageOff(){
    if(shortStayCareOldPersonRecuperationNutritionManageOff==null){

      shortStayCareOldPersonRecuperationNutritionManageOff = new ACRadioButtonItem();

      shortStayCareOldPersonRecuperationNutritionManageOff.setText("なし");

      shortStayCareOldPersonRecuperationNutritionManageOff.setGroup(getShortStayCareOldPersonRecuperationNutritionManageRadio());

      addShortStayCareOldPersonRecuperationNutritionManageOff();
    }
    return shortStayCareOldPersonRecuperationNutritionManageOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayCareOldPersonNutritionManageOn(){
    if(shortStayCareOldPersonNutritionManageOn==null){

      shortStayCareOldPersonNutritionManageOn = new ACRadioButtonItem();

      shortStayCareOldPersonNutritionManageOn.setText("あり");

      shortStayCareOldPersonNutritionManageOn.setGroup(getShortStayCareOldPersonRecuperationNutritionManageRadio());

      addShortStayCareOldPersonNutritionManageOn();
    }
    return shortStayCareOldPersonNutritionManageOn;

  }

  /**
   * 療養食体制を取得します。
   * @return 療養食体制
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonRecuperationRadio(){
    if(shortStayCareOldPersonRecuperationRadio==null){

      shortStayCareOldPersonRecuperationRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonRecuperationRadioContainer().setText("療養食体制");

      shortStayCareOldPersonRecuperationRadio.setBindPath("1220107");

      shortStayCareOldPersonRecuperationRadio.setModel(getShortStayCareOldPersonRecuperationRadioModel());

      shortStayCareOldPersonRecuperationRadio.setUseClearButton(false);

      addShortStayCareOldPersonRecuperationRadio();
    }
    return shortStayCareOldPersonRecuperationRadio;

  }

  /**
   * 療養食体制コンテナを取得します。
   * @return 療養食体制コンテナ
   */
  protected ACLabelContainer getShortStayCareOldPersonRecuperationRadioContainer(){
    if(shortStayCareOldPersonRecuperationRadioContainer==null){
      shortStayCareOldPersonRecuperationRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonRecuperationRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonRecuperationRadioContainer.add(getShortStayCareOldPersonRecuperationRadio(), null);
    }
    return shortStayCareOldPersonRecuperationRadioContainer;
  }

  /**
   * 療養食体制モデルを取得します。
   * @return 療養食体制モデル
   */
  protected ACListModelAdapter getShortStayCareOldPersonRecuperationRadioModel(){
    if(shortStayCareOldPersonRecuperationRadioModel==null){
      shortStayCareOldPersonRecuperationRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonRecuperationRadioModel();
    }
    return shortStayCareOldPersonRecuperationRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayCareOldPersonOff(){
    if(shortStayCareOldPersonOff==null){

      shortStayCareOldPersonOff = new ACRadioButtonItem();

      shortStayCareOldPersonOff.setText("なし");

      shortStayCareOldPersonOff.setGroup(getShortStayCareOldPersonRecuperationRadio());

      addShortStayCareOldPersonOff();
    }
    return shortStayCareOldPersonOff;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayCareOldPersonOn(){
    if(shortStayCareOldPersonOn==null){

      shortStayCareOldPersonOn = new ACRadioButtonItem();

      shortStayCareOldPersonOn.setText("あり");

      shortStayCareOldPersonOn.setGroup(getShortStayCareOldPersonRecuperationRadio());

      addShortStayCareOldPersonOn();
    }
    return shortStayCareOldPersonOn;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonStaffReduceRadio(){
    if(shortStayCareOldPersonStaffReduceRadio==null){

      shortStayCareOldPersonStaffReduceRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonStaffReduceRadioContainer().setText("人員減算");

      shortStayCareOldPersonStaffReduceRadio.setBindPath("1220108");

      shortStayCareOldPersonStaffReduceRadio.setModel(getShortStayCareOldPersonStaffReduceRadioModel());

      shortStayCareOldPersonStaffReduceRadio.setUseClearButton(false);

      addShortStayCareOldPersonStaffReduceRadio();
    }
    return shortStayCareOldPersonStaffReduceRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getShortStayCareOldPersonStaffReduceRadioContainer(){
    if(shortStayCareOldPersonStaffReduceRadioContainer==null){
      shortStayCareOldPersonStaffReduceRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonStaffReduceRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonStaffReduceRadioContainer.add(getShortStayCareOldPersonStaffReduceRadio(), null);
    }
    return shortStayCareOldPersonStaffReduceRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getShortStayCareOldPersonStaffReduceRadioModel(){
    if(shortStayCareOldPersonStaffReduceRadioModel==null){
      shortStayCareOldPersonStaffReduceRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonStaffReduceRadioModel();
    }
    return shortStayCareOldPersonStaffReduceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayCareOldPersonStaffReduceRadioItem1(){
    if(shortStayCareOldPersonStaffReduceRadioItem1==null){

      shortStayCareOldPersonStaffReduceRadioItem1 = new ACRadioButtonItem();

      shortStayCareOldPersonStaffReduceRadioItem1.setText("なし");

      shortStayCareOldPersonStaffReduceRadioItem1.setGroup(getShortStayCareOldPersonStaffReduceRadio());

      addShortStayCareOldPersonStaffReduceRadioItem1();
    }
    return shortStayCareOldPersonStaffReduceRadioItem1;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getShortStayCareOldPersonStaffReduceRadioItem2(){
    if(shortStayCareOldPersonStaffReduceRadioItem2==null){

      shortStayCareOldPersonStaffReduceRadioItem2 = new ACRadioButtonItem();

      shortStayCareOldPersonStaffReduceRadioItem2.setText("定員超過");

      shortStayCareOldPersonStaffReduceRadioItem2.setGroup(getShortStayCareOldPersonStaffReduceRadio());

      addShortStayCareOldPersonStaffReduceRadioItem2();
    }
    return shortStayCareOldPersonStaffReduceRadioItem2;

  }

  /**
   * 看護・介護職員又は医師、PT、OTの不足を取得します。
   * @return 看護・介護職員又は医師、PT、OTの不足
   */
  public ACRadioButtonItem getShortStayCareOldPersonStaffReduceRadioItem3(){
    if(shortStayCareOldPersonStaffReduceRadioItem3==null){

      shortStayCareOldPersonStaffReduceRadioItem3 = new ACRadioButtonItem();

      shortStayCareOldPersonStaffReduceRadioItem3.setText("看護・介護職員又は医師、PT、OTの不足");

      shortStayCareOldPersonStaffReduceRadioItem3.setGroup(getShortStayCareOldPersonStaffReduceRadio());

      addShortStayCareOldPersonStaffReduceRadioItem3();
    }
    return shortStayCareOldPersonStaffReduceRadioItem3;

  }

  /**
   * 食費基準額・コンテナを取得します。
   * @return 食費基準額・コンテナ
   */
  public ACLabelContainer getShortStayCareOldPersonDinnerStandardConteinar(){
    if(shortStayCareOldPersonDinnerStandardConteinar==null){

      shortStayCareOldPersonDinnerStandardConteinar = new ACLabelContainer();

      shortStayCareOldPersonDinnerStandardConteinar.setText("　　　　　　　食費基準額");

      shortStayCareOldPersonDinnerStandardConteinar.setFollowChildEnabled(true);

      addShortStayCareOldPersonDinnerStandardConteinar();
    }
    return shortStayCareOldPersonDinnerStandardConteinar;

  }

  /**
   * 食費基準額・合計・テキストを取得します。
   * @return 食費基準額・合計・テキスト
   */
  public ACTextField getShortStayCareOldPersonDinnerStandarTotal(){
    if(shortStayCareOldPersonDinnerStandarTotal==null){

      shortStayCareOldPersonDinnerStandarTotal = new ACTextField();

      shortStayCareOldPersonDinnerStandarTotal.setBindPath("1220109");

      shortStayCareOldPersonDinnerStandarTotal.setEditable(false);

      shortStayCareOldPersonDinnerStandarTotal.setColumns(4);

      shortStayCareOldPersonDinnerStandarTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonDinnerStandarTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonDinnerStandarTotal.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonDinnerStandarTotal.setMaxLength(4);

      addShortStayCareOldPersonDinnerStandarTotal();
    }
    return shortStayCareOldPersonDinnerStandarTotal;

  }

  /**
   * 食費基準額・朝・ラベルを取得します。
   * @return 食費基準額・朝・ラベル
   */
  public ACLabel getShortStayCareOldPersonMorningDinnerStandardMoneyLabel(){
    if(shortStayCareOldPersonMorningDinnerStandardMoneyLabel==null){

      shortStayCareOldPersonMorningDinnerStandardMoneyLabel = new ACLabel();

      shortStayCareOldPersonMorningDinnerStandardMoneyLabel.setText("　朝");

      addShortStayCareOldPersonMorningDinnerStandardMoneyLabel();
    }
    return shortStayCareOldPersonMorningDinnerStandardMoneyLabel;

  }

  /**
   * 食費基準額・朝・テキストを取得します。
   * @return 食費基準額・朝・テキスト
   */
  public ACTextField getShortStayCareOldPersonMorningDinnerStandardMoney(){
    if(shortStayCareOldPersonMorningDinnerStandardMoney==null){

      shortStayCareOldPersonMorningDinnerStandardMoney = new ACTextField();

      shortStayCareOldPersonMorningDinnerStandardMoney.setBindPath("1220110");

      shortStayCareOldPersonMorningDinnerStandardMoney.setColumns(3);

      shortStayCareOldPersonMorningDinnerStandardMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonMorningDinnerStandardMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonMorningDinnerStandardMoney.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonMorningDinnerStandardMoney.setMaxLength(3);

      addShortStayCareOldPersonMorningDinnerStandardMoney();
    }
    return shortStayCareOldPersonMorningDinnerStandardMoney;

  }

  /**
   * 食費基準額・昼・ラベルを取得します。
   * @return 食費基準額・昼・ラベル
   */
  public ACLabel getShortStayCareOldPersonNoonDinnerStandardMoneyLabel(){
    if(shortStayCareOldPersonNoonDinnerStandardMoneyLabel==null){

      shortStayCareOldPersonNoonDinnerStandardMoneyLabel = new ACLabel();

      shortStayCareOldPersonNoonDinnerStandardMoneyLabel.setText("昼");

      addShortStayCareOldPersonNoonDinnerStandardMoneyLabel();
    }
    return shortStayCareOldPersonNoonDinnerStandardMoneyLabel;

  }

  /**
   * 食費基準額・昼・テキストを取得します。
   * @return 食費基準額・昼・テキスト
   */
  public ACTextField getShortStayCareOldPersonNoonDinnerStandardMoney(){
    if(shortStayCareOldPersonNoonDinnerStandardMoney==null){

      shortStayCareOldPersonNoonDinnerStandardMoney = new ACTextField();

      shortStayCareOldPersonNoonDinnerStandardMoney.setBindPath("1220111");

      shortStayCareOldPersonNoonDinnerStandardMoney.setColumns(3);

      shortStayCareOldPersonNoonDinnerStandardMoney.setMaxLength(3);

      addShortStayCareOldPersonNoonDinnerStandardMoney();
    }
    return shortStayCareOldPersonNoonDinnerStandardMoney;

  }

  /**
   * 食費基準額・夜・ラベルを取得します。
   * @return 食費基準額・夜・ラベル
   */
  public ACLabel getShortStayCareOldPersonNightDinnerStandardMoneyLabel(){
    if(shortStayCareOldPersonNightDinnerStandardMoneyLabel==null){

      shortStayCareOldPersonNightDinnerStandardMoneyLabel = new ACLabel();

      shortStayCareOldPersonNightDinnerStandardMoneyLabel.setText("夜");

      addShortStayCareOldPersonNightDinnerStandardMoneyLabel();
    }
    return shortStayCareOldPersonNightDinnerStandardMoneyLabel;

  }

  /**
   * 食費基準額・夜・テキストを取得します。
   * @return 食費基準額・夜・テキスト
   */
  public ACTextField getShortStayCareOldPersonNightDinnerStandardMoney(){
    if(shortStayCareOldPersonNightDinnerStandardMoney==null){

      shortStayCareOldPersonNightDinnerStandardMoney = new ACTextField();

      shortStayCareOldPersonNightDinnerStandardMoney.setBindPath("1220112");

      shortStayCareOldPersonNightDinnerStandardMoney.setColumns(3);

      shortStayCareOldPersonNightDinnerStandardMoney.setMaxLength(3);

      addShortStayCareOldPersonNightDinnerStandardMoney();
    }
    return shortStayCareOldPersonNightDinnerStandardMoney;

  }

  /**
   * 食費基準額・ラベルを取得します。
   * @return 食費基準額・ラベル
   */
  public ACLabel getShortStayCareOldPersonDinnerStandarTotalLabel(){
    if(shortStayCareOldPersonDinnerStandarTotalLabel==null){

      shortStayCareOldPersonDinnerStandarTotalLabel = new ACLabel();

      shortStayCareOldPersonDinnerStandarTotalLabel.setText("（円）");

      addShortStayCareOldPersonDinnerStandarTotalLabel();
    }
    return shortStayCareOldPersonDinnerStandarTotalLabel;

  }

  /**
   * ユニット型個室基準額コンテナを取得します。
   * @return ユニット型個室基準額コンテナ
   */
  public ACLabelContainer getShortStayCareOldPersonUnitRoomContainar(){
    if(shortStayCareOldPersonUnitRoomContainar==null){

      shortStayCareOldPersonUnitRoomContainar = new ACLabelContainer();

      shortStayCareOldPersonUnitRoomContainar.setText("ユニット型個室基準額");

      shortStayCareOldPersonUnitRoomContainar.setFollowChildEnabled(true);

      addShortStayCareOldPersonUnitRoomContainar();
    }
    return shortStayCareOldPersonUnitRoomContainar;

  }

  /**
   * ユニット型個室テキストを取得します。
   * @return ユニット型個室テキスト
   */
  public ACTextField getShortStayCareOldPersonUnitRoomText(){
    if(shortStayCareOldPersonUnitRoomText==null){

      shortStayCareOldPersonUnitRoomText = new ACTextField();

      shortStayCareOldPersonUnitRoomText.setBindPath("1220113");

      shortStayCareOldPersonUnitRoomText.setColumns(4);

      shortStayCareOldPersonUnitRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonUnitRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonUnitRoomText.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonUnitRoomText.setMaxLength(4);

      addShortStayCareOldPersonUnitRoomText();
    }
    return shortStayCareOldPersonUnitRoomText;

  }

  /**
   * ユニット型個室ラベルを取得します。
   * @return ユニット型個室ラベル
   */
  public ACLabel getShortStayCareOldPersonUnitRoomLabel(){
    if(shortStayCareOldPersonUnitRoomLabel==null){

      shortStayCareOldPersonUnitRoomLabel = new ACLabel();

      shortStayCareOldPersonUnitRoomLabel.setText("（円）");

      addShortStayCareOldPersonUnitRoomLabel();
    }
    return shortStayCareOldPersonUnitRoomLabel;

  }

  /**
   * ユニット型準個室基準額コンテナを取得します。
   * @return ユニット型準個室基準額コンテナ
   */
  public ACLabelContainer getShortStayCareOldPersonUnitSemiRoomContainar(){
    if(shortStayCareOldPersonUnitSemiRoomContainar==null){

      shortStayCareOldPersonUnitSemiRoomContainar = new ACLabelContainer();

      shortStayCareOldPersonUnitSemiRoomContainar.setText("ユニット型準個室基準額");

      shortStayCareOldPersonUnitSemiRoomContainar.setFollowChildEnabled(true);

      addShortStayCareOldPersonUnitSemiRoomContainar();
    }
    return shortStayCareOldPersonUnitSemiRoomContainar;

  }

  /**
   * ユニット型準個室テキストを取得します。
   * @return ユニット型準個室テキスト
   */
  public ACTextField getShortStayCareOldPersonUnitSemiRoomText(){
    if(shortStayCareOldPersonUnitSemiRoomText==null){

      shortStayCareOldPersonUnitSemiRoomText = new ACTextField();

      shortStayCareOldPersonUnitSemiRoomText.setBindPath("1220114");

      shortStayCareOldPersonUnitSemiRoomText.setColumns(4);

      shortStayCareOldPersonUnitSemiRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonUnitSemiRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonUnitSemiRoomText.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonUnitSemiRoomText.setMaxLength(4);

      addShortStayCareOldPersonUnitSemiRoomText();
    }
    return shortStayCareOldPersonUnitSemiRoomText;

  }

  /**
   * ユニット型準個室ラベルを取得します。
   * @return ユニット型準個室ラベル
   */
  public ACLabel getShortStayCareOldPersonUnitSemiRoomLabel(){
    if(shortStayCareOldPersonUnitSemiRoomLabel==null){

      shortStayCareOldPersonUnitSemiRoomLabel = new ACLabel();

      shortStayCareOldPersonUnitSemiRoomLabel.setText("（円）");

      addShortStayCareOldPersonUnitSemiRoomLabel();
    }
    return shortStayCareOldPersonUnitSemiRoomLabel;

  }

  /**
   * 従来型個室基準額コンテナを取得します。
   * @return 従来型個室基準額コンテナ
   */
  public ACLabelContainer getShortStayCareOldPersonNormalRoomContainar(){
    if(shortStayCareOldPersonNormalRoomContainar==null){

      shortStayCareOldPersonNormalRoomContainar = new ACLabelContainer();

      shortStayCareOldPersonNormalRoomContainar.setText("　　従来型個室基準額");

      shortStayCareOldPersonNormalRoomContainar.setFollowChildEnabled(true);

      addShortStayCareOldPersonNormalRoomContainar();
    }
    return shortStayCareOldPersonNormalRoomContainar;

  }

  /**
   * 従来型個室テキストを取得します。
   * @return 従来型個室テキスト
   */
  public ACTextField getShortStayCareOldPersonNormalRoomText(){
    if(shortStayCareOldPersonNormalRoomText==null){

      shortStayCareOldPersonNormalRoomText = new ACTextField();

      shortStayCareOldPersonNormalRoomText.setBindPath("1220115");

      shortStayCareOldPersonNormalRoomText.setColumns(4);

      shortStayCareOldPersonNormalRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonNormalRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonNormalRoomText.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonNormalRoomText.setMaxLength(4);

      addShortStayCareOldPersonNormalRoomText();
    }
    return shortStayCareOldPersonNormalRoomText;

  }

  /**
   * 従来型個室ラベルを取得します。
   * @return 従来型個室ラベル
   */
  public ACLabel getShortStayCareOldPersonNormalRoomLabel(){
    if(shortStayCareOldPersonNormalRoomLabel==null){

      shortStayCareOldPersonNormalRoomLabel = new ACLabel();

      shortStayCareOldPersonNormalRoomLabel.setText("（円）");

      addShortStayCareOldPersonNormalRoomLabel();
    }
    return shortStayCareOldPersonNormalRoomLabel;

  }

  /**
   * 多床室基準額コンテナを取得します。
   * @return 多床室基準額コンテナ
   */
  public ACLabelContainer getShortStayCareOldPersonTasyouRoomContainar(){
    if(shortStayCareOldPersonTasyouRoomContainar==null){

      shortStayCareOldPersonTasyouRoomContainar = new ACLabelContainer();

      shortStayCareOldPersonTasyouRoomContainar.setText("　　多床室基準額");

      shortStayCareOldPersonTasyouRoomContainar.setFollowChildEnabled(true);

      addShortStayCareOldPersonTasyouRoomContainar();
    }
    return shortStayCareOldPersonTasyouRoomContainar;

  }

  /**
   * 多床室テキストを取得します。
   * @return 多床室テキスト
   */
  public ACTextField getShortStayCareOldPersonTasyouRoomText(){
    if(shortStayCareOldPersonTasyouRoomText==null){

      shortStayCareOldPersonTasyouRoomText = new ACTextField();

      shortStayCareOldPersonTasyouRoomText.setBindPath("1220116");

      shortStayCareOldPersonTasyouRoomText.setColumns(4);

      shortStayCareOldPersonTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonTasyouRoomText.setMaxLength(4);

      addShortStayCareOldPersonTasyouRoomText();
    }
    return shortStayCareOldPersonTasyouRoomText;

  }

  /**
   * 多床室ラベルを取得します。
   * @return 多床室ラベル
   */
  public ACLabel getShortStayCareOldPersonTasyouRoomLabel(){
    if(shortStayCareOldPersonTasyouRoomLabel==null){

      shortStayCareOldPersonTasyouRoomLabel = new ACLabel();

      shortStayCareOldPersonTasyouRoomLabel.setText("（円）");

      addShortStayCareOldPersonTasyouRoomLabel();
    }
    return shortStayCareOldPersonTasyouRoomLabel;

  }

  /**
   * コンストラクタです。
   */
  public QO004009Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getShortStayCareOldPersonGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonGroup(){

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonDiscountConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonNightWorkDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonRehabilitationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonCognitiveRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonMeetingAndSendingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonRecuperationNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonRecuperationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonStaffReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonDinnerStandardConteinar(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonUnitRoomContainar(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonUnitSemiRoomContainar(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonNormalRoomContainar(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonTasyouRoomContainar(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonDiscountConteiner(){

    shortStayCareOldPersonDiscountConteiner.add(getShortStayCareOldPersonDiscountText(), VRLayout.FLOW);

    shortStayCareOldPersonDiscountConteiner.add(getShortStayCareOldPersonDiscountLabel(), VRLayout.FLOW);

  }

  /**
   * テキストに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonDiscountText(){

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonDiscountLabel(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonInstitutionDivisionRadio(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonInstitutionDivisionRadioModel(){

    getShortStayCareOldPersonInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayCareOldPersonInstitutionDivisionRadioModel().add(getShortStayCareOldPersonInstitutionDivisionRadioItem1());

    getShortStayCareOldPersonInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayCareOldPersonInstitutionDivisionRadioModel().add(getShortStayCareOldPersonInstitutionDivisionRadioItem2());

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addShortStayCareOldPersonInstitutionDivisionRadioItem1(){

  }

  /**
   * ユニット型介護老人保健施設に内部項目を追加します。
   */
  protected void addShortStayCareOldPersonInstitutionDivisionRadioItem2(){

  }

  /**
   * 夜間勤務条件基準ラジオグループに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNightWorkDivisionRadio(){

  }

  /**
   * 夜間勤務条件基準ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNightWorkDivisionRadioModel(){

    getShortStayCareOldPersonNightWorkDivisionOn().setButtonIndex(1);
    getShortStayCareOldPersonNightWorkDivisionRadioModel().add(getShortStayCareOldPersonNightWorkDivisionOn());

    getShortStayCareOldPersonNightWorkDivisionOff().setButtonIndex(2);
    getShortStayCareOldPersonNightWorkDivisionRadioModel().add(getShortStayCareOldPersonNightWorkDivisionOff());

  }

  /**
   * 基準型に内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNightWorkDivisionOn(){

  }

  /**
   * 減算型に内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNightWorkDivisionOff(){

  }

  /**
   * リハビリテーション機能強化ラジオグループに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonRehabilitationRadio(){

  }

  /**
   * リハビリテーション機能強化ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonRehabilitationRadioModel(){

    getShortStayCareOldPersonRehabilitationOff().setButtonIndex(1);
    getShortStayCareOldPersonRehabilitationRadioModel().add(getShortStayCareOldPersonRehabilitationOff());

    getShortStayCareOldPersonRehabilitationOn().setButtonIndex(2);
    getShortStayCareOldPersonRehabilitationRadioModel().add(getShortStayCareOldPersonRehabilitationOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonRehabilitationOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonRehabilitationOn(){

  }

  /**
   * 認知症専門棟ラジオグループに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonCognitiveRadio(){

  }

  /**
   * 認知症専門棟ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonCognitiveRadioModel(){

    getShortStayCareOldPersonCognitiveOff().setButtonIndex(1);
    getShortStayCareOldPersonCognitiveRadioModel().add(getShortStayCareOldPersonCognitiveOff());

    getShortStayCareOldPersonCognitiveOn().setButtonIndex(2);
    getShortStayCareOldPersonCognitiveRadioModel().add(getShortStayCareOldPersonCognitiveOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonCognitiveOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonCognitiveOn(){

  }

  /**
   * 送迎体制ラジオグループに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonMeetingAndSendingRadio(){

  }

  /**
   * 送迎体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonMeetingAndSendingRadioModel(){

    getShortStayCareOldPersonMeetingAndSendingOff().setButtonIndex(1);
    getShortStayCareOldPersonMeetingAndSendingRadioModel().add(getShortStayCareOldPersonMeetingAndSendingOff());

    getShortStayCareOldPersonMeetingAndSendingOn().setButtonIndex(2);
    getShortStayCareOldPersonMeetingAndSendingRadioModel().add(getShortStayCareOldPersonMeetingAndSendingOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonMeetingAndSendingOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonMeetingAndSendingOn(){

  }

  /**
   * 栄養管理体制に内部項目を追加します。
   */
  protected void addShortStayCareOldPersonRecuperationNutritionManageRadio(){

  }

  /**
   * 栄養管理体制モデルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonRecuperationNutritionManageRadioModel(){

    getShortStayCareOldPersonRecuperationNutritionManageOff().setButtonIndex(1);
    getShortStayCareOldPersonRecuperationNutritionManageRadioModel().add(getShortStayCareOldPersonRecuperationNutritionManageOff());

    getShortStayCareOldPersonNutritionManageOn().setButtonIndex(2);
    getShortStayCareOldPersonRecuperationNutritionManageRadioModel().add(getShortStayCareOldPersonNutritionManageOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonRecuperationNutritionManageOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNutritionManageOn(){

  }

  /**
   * 療養食体制に内部項目を追加します。
   */
  protected void addShortStayCareOldPersonRecuperationRadio(){

  }

  /**
   * 療養食体制モデルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonRecuperationRadioModel(){

    getShortStayCareOldPersonOff().setButtonIndex(1);
    getShortStayCareOldPersonRecuperationRadioModel().add(getShortStayCareOldPersonOff());

    getShortStayCareOldPersonOn().setButtonIndex(2);
    getShortStayCareOldPersonRecuperationRadioModel().add(getShortStayCareOldPersonOn());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonOff(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonOn(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addShortStayCareOldPersonStaffReduceRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonStaffReduceRadioModel(){

    getShortStayCareOldPersonStaffReduceRadioItem1().setButtonIndex(1);
    getShortStayCareOldPersonStaffReduceRadioModel().add(getShortStayCareOldPersonStaffReduceRadioItem1());

    getShortStayCareOldPersonStaffReduceRadioItem2().setButtonIndex(2);
    getShortStayCareOldPersonStaffReduceRadioModel().add(getShortStayCareOldPersonStaffReduceRadioItem2());

    getShortStayCareOldPersonStaffReduceRadioItem3().setButtonIndex(3);
    getShortStayCareOldPersonStaffReduceRadioModel().add(getShortStayCareOldPersonStaffReduceRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonStaffReduceRadioItem1(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addShortStayCareOldPersonStaffReduceRadioItem2(){

  }

  /**
   * 看護・介護職員又は医師、PT、OTの不足に内部項目を追加します。
   */
  protected void addShortStayCareOldPersonStaffReduceRadioItem3(){

  }

  /**
   * 食費基準額・コンテナに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonDinnerStandardConteinar(){

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonDinnerStandarTotal(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonMorningDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonMorningDinnerStandardMoney(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonNoonDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonNoonDinnerStandardMoney(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonNightDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonNightDinnerStandardMoney(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonDinnerStandarTotalLabel(), VRLayout.FLOW);

  }

  /**
   * 食費基準額・合計・テキストに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonDinnerStandarTotal(){

  }

  /**
   * 食費基準額・朝・ラベルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonMorningDinnerStandardMoneyLabel(){

  }

  /**
   * 食費基準額・朝・テキストに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonMorningDinnerStandardMoney(){

  }

  /**
   * 食費基準額・昼・ラベルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNoonDinnerStandardMoneyLabel(){

  }

  /**
   * 食費基準額・昼・テキストに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNoonDinnerStandardMoney(){

  }

  /**
   * 食費基準額・夜・ラベルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNightDinnerStandardMoneyLabel(){

  }

  /**
   * 食費基準額・夜・テキストに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNightDinnerStandardMoney(){

  }

  /**
   * 食費基準額・ラベルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonDinnerStandarTotalLabel(){

  }

  /**
   * ユニット型個室基準額コンテナに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonUnitRoomContainar(){

    shortStayCareOldPersonUnitRoomContainar.add(getShortStayCareOldPersonUnitRoomText(), null);

    shortStayCareOldPersonUnitRoomContainar.add(getShortStayCareOldPersonUnitRoomLabel(), null);

  }

  /**
   * ユニット型個室テキストに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonUnitRoomText(){

  }

  /**
   * ユニット型個室ラベルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonUnitRoomLabel(){

  }

  /**
   * ユニット型準個室基準額コンテナに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonUnitSemiRoomContainar(){

    shortStayCareOldPersonUnitSemiRoomContainar.add(getShortStayCareOldPersonUnitSemiRoomText(), null);

    shortStayCareOldPersonUnitSemiRoomContainar.add(getShortStayCareOldPersonUnitSemiRoomLabel(), null);

  }

  /**
   * ユニット型準個室テキストに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonUnitSemiRoomText(){

  }

  /**
   * ユニット型準個室ラベルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonUnitSemiRoomLabel(){

  }

  /**
   * 従来型個室基準額コンテナに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNormalRoomContainar(){

    shortStayCareOldPersonNormalRoomContainar.add(getShortStayCareOldPersonNormalRoomText(), null);

    shortStayCareOldPersonNormalRoomContainar.add(getShortStayCareOldPersonNormalRoomLabel(), null);

  }

  /**
   * 従来型個室テキストに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNormalRoomText(){

  }

  /**
   * 従来型個室ラベルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonNormalRoomLabel(){

  }

  /**
   * 多床室基準額コンテナに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonTasyouRoomContainar(){

    shortStayCareOldPersonTasyouRoomContainar.add(getShortStayCareOldPersonTasyouRoomText(), null);

    shortStayCareOldPersonTasyouRoomContainar.add(getShortStayCareOldPersonTasyouRoomLabel(), null);

  }

  /**
   * 多床室テキストに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonTasyouRoomText(){

  }

  /**
   * 多床室ラベルに内部項目を追加します。
   */
  protected void addShortStayCareOldPersonTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004009Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004009Design getThis() {
    return this;
  }
}
