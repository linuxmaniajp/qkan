
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
 * 作成日: 2006/05/16  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防短期入所療養介護（基準適合診療所） (QS001142)
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
/**
 * サービスパターン介護予防短期入所療養介護（基準適合診療所）画面項目デザイン(QS001142) 
 */
public class QS001142Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel shortStayStandardRecuperationPatterns;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationHospitalRoomDivisionRadio;

  private ACLabelContainer shortStayStandardRecuperationHospitalRoomDivisionRadioContainer;

  private ACListModelAdapter shortStayStandardRecuperationHospitalRoomDivisionRadioModel;

  private ACRadioButtonItem shortStayStandardRecuperationHospitalRoomDivisionRadioItem1;

  private ACRadioButtonItem shortStayStandardRecuperationHospitalRoomDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationMeetingAndSendingOff;

  private ACLabelContainer shortStayStandardRecuperationMeetingAndSendingOffContainer;

  private ACListModelAdapter shortStayStandardRecuperationMeetingAndSendingOffModel;

  private ACRadioButtonItem shortStayStandardRecuperationMeetingAndSendingOffNone;

  private ACRadioButtonItem shortStayStandardRecuperationMeetingAndSendingOffOneWay;

  private ACRadioButtonItem shortStayStandardRecuperationMeetingAndSendingOffRoundTrip;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationDieticianManageRadio;

  private ACLabelContainer shortStayStandardRecuperationDieticianManageRadioContainer;

  private ACListModelAdapter shortStayStandardRecuperationDieticianManageRadioModel;

  private ACRadioButtonItem shortStayStandardRecuperationDieticianManageRadioItem1;

  private ACRadioButtonItem shortStayStandardRecuperationDieticianManageRadioItem2;

  private ACRadioButtonItem shortStayStandardRecuperationDieticianManageRadioItem3;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationMedicalExpensesRadio;

  private ACLabelContainer shortStayStandardRecuperationMedicalExpensesRadioContainer;

  private ACListModelAdapter shortStayStandardRecuperationMedicalExpensesRadioModel;

  private ACRadioButtonItem shortStayStandardRecuperationMedicalExpensesRadioItem1;

  private ACRadioButtonItem shortStayStandardRecuperationMedicalExpensesRadioItem2;

  private ACClearableRadioButtonGroup shortStayStandardRecuperationEtcShiftSubtractionRadio;

  private ACLabelContainer shortStayStandardRecuperationEtcShiftSubtractionRadioContainer;

  private ACListModelAdapter shortStayStandardRecuperationEtcShiftSubtractionRadioModel;

  private ACRadioButtonItem shortStayStandardRecuperationEtcShiftSubtractionRadioItem1;

  private ACRadioButtonItem shortStayStandardRecuperationEtcShiftSubtractionRadioItem2;

  private ACBackLabelContainer shortStayStandardRecuperationDinnerContainer;

  private ACComboBox shortStayStandardRecuperationDinnerOffer;

  private ACLabelContainer shortStayStandardRecuperationDinnerOfferContainer;

  private ACComboBoxModelAdapter shortStayStandardRecuperationDinnerOfferModel;

  private ACTextField shortStayStandardRecuperationDinnerCost;

  private ACLabelContainer shortStayStandardRecuperationDinnerCostContainer;

  private ACIntegerCheckBox shortStayStandardRecuperationEtc30Over;

  //getter

  /**
   * 短期入所療養介護（基準適合診療所）パターン領域）を取得します。
   * @return 短期入所療養介護（基準適合診療所）パターン領域）
   */
  public ACPanel getShortStayStandardRecuperationPatterns(){
    if(shortStayStandardRecuperationPatterns==null){

      shortStayStandardRecuperationPatterns = new ACPanel();

      shortStayStandardRecuperationPatterns.setHgap(0);

      addShortStayStandardRecuperationPatterns();
    }
    return shortStayStandardRecuperationPatterns;

  }

  /**
   * 病室区分を取得します。
   * @return 病室区分
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationHospitalRoomDivisionRadio(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadio==null){

      shortStayStandardRecuperationHospitalRoomDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationHospitalRoomDivisionRadioContainer().setText("病室区分");

      shortStayStandardRecuperationHospitalRoomDivisionRadio.setBindPath("1260401");

      shortStayStandardRecuperationHospitalRoomDivisionRadio.setUseClearButton(false);

      shortStayStandardRecuperationHospitalRoomDivisionRadio.setModel(getShortStayStandardRecuperationHospitalRoomDivisionRadioModel());

      addShortStayStandardRecuperationHospitalRoomDivisionRadio();
    }
    return shortStayStandardRecuperationHospitalRoomDivisionRadio;

  }

  /**
   * 病室区分コンテナを取得します。
   * @return 病室区分コンテナ
   */
  protected ACLabelContainer getShortStayStandardRecuperationHospitalRoomDivisionRadioContainer(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadioContainer==null){
      shortStayStandardRecuperationHospitalRoomDivisionRadioContainer = new ACLabelContainer();
      shortStayStandardRecuperationHospitalRoomDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationHospitalRoomDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationHospitalRoomDivisionRadioContainer.add(getShortStayStandardRecuperationHospitalRoomDivisionRadio(), null);
    }
    return shortStayStandardRecuperationHospitalRoomDivisionRadioContainer;
  }

  /**
   * 病室区分モデルを取得します。
   * @return 病室区分モデル
   */
  protected ACListModelAdapter getShortStayStandardRecuperationHospitalRoomDivisionRadioModel(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadioModel==null){
      shortStayStandardRecuperationHospitalRoomDivisionRadioModel = new ACListModelAdapter();
      addShortStayStandardRecuperationHospitalRoomDivisionRadioModel();
    }
    return shortStayStandardRecuperationHospitalRoomDivisionRadioModel;
  }

  /**
   * 従来型個室を取得します。
   * @return 従来型個室
   */
  public ACRadioButtonItem getShortStayStandardRecuperationHospitalRoomDivisionRadioItem1(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadioItem1==null){

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem1.setText("従来型個室");

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem1.setGroup(getShortStayStandardRecuperationHospitalRoomDivisionRadio());

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationHospitalRoomDivisionRadioItem1();
    }
    return shortStayStandardRecuperationHospitalRoomDivisionRadioItem1;

  }

  /**
   * 多床室を取得します。
   * @return 多床室
   */
  public ACRadioButtonItem getShortStayStandardRecuperationHospitalRoomDivisionRadioItem2(){
    if(shortStayStandardRecuperationHospitalRoomDivisionRadioItem2==null){

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem2.setText("多床室");

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem2.setGroup(getShortStayStandardRecuperationHospitalRoomDivisionRadio());

      shortStayStandardRecuperationHospitalRoomDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationHospitalRoomDivisionRadioItem2();
    }
    return shortStayStandardRecuperationHospitalRoomDivisionRadioItem2;

  }

  /**
   * 送迎を取得します。
   * @return 送迎
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationMeetingAndSendingOff(){
    if(shortStayStandardRecuperationMeetingAndSendingOff==null){

      shortStayStandardRecuperationMeetingAndSendingOff = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationMeetingAndSendingOffContainer().setText("送迎加算");

      shortStayStandardRecuperationMeetingAndSendingOff.setBindPath("6");

      shortStayStandardRecuperationMeetingAndSendingOff.setUseClearButton(false);

      shortStayStandardRecuperationMeetingAndSendingOff.setModel(getShortStayStandardRecuperationMeetingAndSendingOffModel());

      addShortStayStandardRecuperationMeetingAndSendingOff();
    }
    return shortStayStandardRecuperationMeetingAndSendingOff;

  }

  /**
   * 送迎コンテナを取得します。
   * @return 送迎コンテナ
   */
  protected ACLabelContainer getShortStayStandardRecuperationMeetingAndSendingOffContainer(){
    if(shortStayStandardRecuperationMeetingAndSendingOffContainer==null){
      shortStayStandardRecuperationMeetingAndSendingOffContainer = new ACLabelContainer();
      shortStayStandardRecuperationMeetingAndSendingOffContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationMeetingAndSendingOffContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationMeetingAndSendingOffContainer.add(getShortStayStandardRecuperationMeetingAndSendingOff(), null);
    }
    return shortStayStandardRecuperationMeetingAndSendingOffContainer;
  }

  /**
   * 送迎モデルを取得します。
   * @return 送迎モデル
   */
  protected ACListModelAdapter getShortStayStandardRecuperationMeetingAndSendingOffModel(){
    if(shortStayStandardRecuperationMeetingAndSendingOffModel==null){
      shortStayStandardRecuperationMeetingAndSendingOffModel = new ACListModelAdapter();
      addShortStayStandardRecuperationMeetingAndSendingOffModel();
    }
    return shortStayStandardRecuperationMeetingAndSendingOffModel;
  }

  /**
   * 送迎なしを取得します。
   * @return 送迎なし
   */
  public ACRadioButtonItem getShortStayStandardRecuperationMeetingAndSendingOffNone(){
    if(shortStayStandardRecuperationMeetingAndSendingOffNone==null){

      shortStayStandardRecuperationMeetingAndSendingOffNone = new ACRadioButtonItem();

      shortStayStandardRecuperationMeetingAndSendingOffNone.setText("送迎なし");

      shortStayStandardRecuperationMeetingAndSendingOffNone.setGroup(getShortStayStandardRecuperationMeetingAndSendingOff());

      shortStayStandardRecuperationMeetingAndSendingOffNone.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationMeetingAndSendingOffNone();
    }
    return shortStayStandardRecuperationMeetingAndSendingOffNone;

  }

  /**
   * 送迎片道を取得します。
   * @return 送迎片道
   */
  public ACRadioButtonItem getShortStayStandardRecuperationMeetingAndSendingOffOneWay(){
    if(shortStayStandardRecuperationMeetingAndSendingOffOneWay==null){

      shortStayStandardRecuperationMeetingAndSendingOffOneWay = new ACRadioButtonItem();

      shortStayStandardRecuperationMeetingAndSendingOffOneWay.setText("送迎片道");

      shortStayStandardRecuperationMeetingAndSendingOffOneWay.setGroup(getShortStayStandardRecuperationMeetingAndSendingOff());

      shortStayStandardRecuperationMeetingAndSendingOffOneWay.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationMeetingAndSendingOffOneWay();
    }
    return shortStayStandardRecuperationMeetingAndSendingOffOneWay;

  }

  /**
   * 送迎往復を取得します。
   * @return 送迎往復
   */
  public ACRadioButtonItem getShortStayStandardRecuperationMeetingAndSendingOffRoundTrip(){
    if(shortStayStandardRecuperationMeetingAndSendingOffRoundTrip==null){

      shortStayStandardRecuperationMeetingAndSendingOffRoundTrip = new ACRadioButtonItem();

      shortStayStandardRecuperationMeetingAndSendingOffRoundTrip.setText("送迎往復");

      shortStayStandardRecuperationMeetingAndSendingOffRoundTrip.setGroup(getShortStayStandardRecuperationMeetingAndSendingOff());

      shortStayStandardRecuperationMeetingAndSendingOffRoundTrip.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationMeetingAndSendingOffRoundTrip();
    }
    return shortStayStandardRecuperationMeetingAndSendingOffRoundTrip;

  }

  /**
   * 栄養管理体制加算を取得します。
   * @return 栄養管理体制加算
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationDieticianManageRadio(){
    if(shortStayStandardRecuperationDieticianManageRadio==null){

      shortStayStandardRecuperationDieticianManageRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationDieticianManageRadioContainer().setText("栄養管理体制加算");

      shortStayStandardRecuperationDieticianManageRadio.setBindPath("1260402");

      shortStayStandardRecuperationDieticianManageRadio.setUseClearButton(false);

      shortStayStandardRecuperationDieticianManageRadio.setModel(getShortStayStandardRecuperationDieticianManageRadioModel());

      addShortStayStandardRecuperationDieticianManageRadio();
    }
    return shortStayStandardRecuperationDieticianManageRadio;

  }

  /**
   * 栄養管理体制加算コンテナを取得します。
   * @return 栄養管理体制加算コンテナ
   */
  protected ACLabelContainer getShortStayStandardRecuperationDieticianManageRadioContainer(){
    if(shortStayStandardRecuperationDieticianManageRadioContainer==null){
      shortStayStandardRecuperationDieticianManageRadioContainer = new ACLabelContainer();
      shortStayStandardRecuperationDieticianManageRadioContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationDieticianManageRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationDieticianManageRadioContainer.add(getShortStayStandardRecuperationDieticianManageRadio(), null);
    }
    return shortStayStandardRecuperationDieticianManageRadioContainer;
  }

  /**
   * 栄養管理体制加算モデルを取得します。
   * @return 栄養管理体制加算モデル
   */
  protected ACListModelAdapter getShortStayStandardRecuperationDieticianManageRadioModel(){
    if(shortStayStandardRecuperationDieticianManageRadioModel==null){
      shortStayStandardRecuperationDieticianManageRadioModel = new ACListModelAdapter();
      addShortStayStandardRecuperationDieticianManageRadioModel();
    }
    return shortStayStandardRecuperationDieticianManageRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayStandardRecuperationDieticianManageRadioItem1(){
    if(shortStayStandardRecuperationDieticianManageRadioItem1==null){

      shortStayStandardRecuperationDieticianManageRadioItem1 = new ACRadioButtonItem();

      shortStayStandardRecuperationDieticianManageRadioItem1.setText("なし");

      shortStayStandardRecuperationDieticianManageRadioItem1.setGroup(getShortStayStandardRecuperationDieticianManageRadio());

      shortStayStandardRecuperationDieticianManageRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationDieticianManageRadioItem1();
    }
    return shortStayStandardRecuperationDieticianManageRadioItem1;

  }

  /**
   * 管理栄養士を取得します。
   * @return 管理栄養士
   */
  public ACRadioButtonItem getShortStayStandardRecuperationDieticianManageRadioItem2(){
    if(shortStayStandardRecuperationDieticianManageRadioItem2==null){

      shortStayStandardRecuperationDieticianManageRadioItem2 = new ACRadioButtonItem();

      shortStayStandardRecuperationDieticianManageRadioItem2.setText("管理栄養士");

      shortStayStandardRecuperationDieticianManageRadioItem2.setGroup(getShortStayStandardRecuperationDieticianManageRadio());

      shortStayStandardRecuperationDieticianManageRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addShortStayStandardRecuperationDieticianManageRadioItem2();
    }
    return shortStayStandardRecuperationDieticianManageRadioItem2;

  }

  /**
   * 栄養士を取得します。
   * @return 栄養士
   */
  public ACRadioButtonItem getShortStayStandardRecuperationDieticianManageRadioItem3(){
    if(shortStayStandardRecuperationDieticianManageRadioItem3==null){

      shortStayStandardRecuperationDieticianManageRadioItem3 = new ACRadioButtonItem();

      shortStayStandardRecuperationDieticianManageRadioItem3.setText("栄養士");

      shortStayStandardRecuperationDieticianManageRadioItem3.setGroup(getShortStayStandardRecuperationDieticianManageRadio());

      shortStayStandardRecuperationDieticianManageRadioItem3.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationDieticianManageRadioItem3();
    }
    return shortStayStandardRecuperationDieticianManageRadioItem3;

  }

  /**
   * 療養食加算を取得します。
   * @return 療養食加算
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationMedicalExpensesRadio(){
    if(shortStayStandardRecuperationMedicalExpensesRadio==null){

      shortStayStandardRecuperationMedicalExpensesRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationMedicalExpensesRadioContainer().setText("療養食加算");

      shortStayStandardRecuperationMedicalExpensesRadio.setBindPath("1260403");

      shortStayStandardRecuperationMedicalExpensesRadio.setUseClearButton(false);

      shortStayStandardRecuperationMedicalExpensesRadio.setModel(getShortStayStandardRecuperationMedicalExpensesRadioModel());

      addShortStayStandardRecuperationMedicalExpensesRadio();
    }
    return shortStayStandardRecuperationMedicalExpensesRadio;

  }

  /**
   * 療養食加算コンテナを取得します。
   * @return 療養食加算コンテナ
   */
  protected ACLabelContainer getShortStayStandardRecuperationMedicalExpensesRadioContainer(){
    if(shortStayStandardRecuperationMedicalExpensesRadioContainer==null){
      shortStayStandardRecuperationMedicalExpensesRadioContainer = new ACLabelContainer();
      shortStayStandardRecuperationMedicalExpensesRadioContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationMedicalExpensesRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationMedicalExpensesRadioContainer.add(getShortStayStandardRecuperationMedicalExpensesRadio(), null);
    }
    return shortStayStandardRecuperationMedicalExpensesRadioContainer;
  }

  /**
   * 療養食加算モデルを取得します。
   * @return 療養食加算モデル
   */
  protected ACListModelAdapter getShortStayStandardRecuperationMedicalExpensesRadioModel(){
    if(shortStayStandardRecuperationMedicalExpensesRadioModel==null){
      shortStayStandardRecuperationMedicalExpensesRadioModel = new ACListModelAdapter();
      addShortStayStandardRecuperationMedicalExpensesRadioModel();
    }
    return shortStayStandardRecuperationMedicalExpensesRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayStandardRecuperationMedicalExpensesRadioItem1(){
    if(shortStayStandardRecuperationMedicalExpensesRadioItem1==null){

      shortStayStandardRecuperationMedicalExpensesRadioItem1 = new ACRadioButtonItem();

      shortStayStandardRecuperationMedicalExpensesRadioItem1.setText("なし");

      shortStayStandardRecuperationMedicalExpensesRadioItem1.setGroup(getShortStayStandardRecuperationMedicalExpensesRadio());

      shortStayStandardRecuperationMedicalExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationMedicalExpensesRadioItem1();
    }
    return shortStayStandardRecuperationMedicalExpensesRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getShortStayStandardRecuperationMedicalExpensesRadioItem2(){
    if(shortStayStandardRecuperationMedicalExpensesRadioItem2==null){

      shortStayStandardRecuperationMedicalExpensesRadioItem2 = new ACRadioButtonItem();

      shortStayStandardRecuperationMedicalExpensesRadioItem2.setText("あり");

      shortStayStandardRecuperationMedicalExpensesRadioItem2.setGroup(getShortStayStandardRecuperationMedicalExpensesRadio());

      shortStayStandardRecuperationMedicalExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationMedicalExpensesRadioItem2();
    }
    return shortStayStandardRecuperationMedicalExpensesRadioItem2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACClearableRadioButtonGroup getShortStayStandardRecuperationEtcShiftSubtractionRadio(){
    if(shortStayStandardRecuperationEtcShiftSubtractionRadio==null){

      shortStayStandardRecuperationEtcShiftSubtractionRadio = new ACClearableRadioButtonGroup();

      getShortStayStandardRecuperationEtcShiftSubtractionRadioContainer().setText("人員減算");

      shortStayStandardRecuperationEtcShiftSubtractionRadio.setBindPath("1260404");

      shortStayStandardRecuperationEtcShiftSubtractionRadio.setUseClearButton(false);

      shortStayStandardRecuperationEtcShiftSubtractionRadio.setModel(getShortStayStandardRecuperationEtcShiftSubtractionRadioModel());

      addShortStayStandardRecuperationEtcShiftSubtractionRadio();
    }
    return shortStayStandardRecuperationEtcShiftSubtractionRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getShortStayStandardRecuperationEtcShiftSubtractionRadioContainer(){
    if(shortStayStandardRecuperationEtcShiftSubtractionRadioContainer==null){
      shortStayStandardRecuperationEtcShiftSubtractionRadioContainer = new ACLabelContainer();
      shortStayStandardRecuperationEtcShiftSubtractionRadioContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationEtcShiftSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationEtcShiftSubtractionRadioContainer.add(getShortStayStandardRecuperationEtcShiftSubtractionRadio(), null);
    }
    return shortStayStandardRecuperationEtcShiftSubtractionRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getShortStayStandardRecuperationEtcShiftSubtractionRadioModel(){
    if(shortStayStandardRecuperationEtcShiftSubtractionRadioModel==null){
      shortStayStandardRecuperationEtcShiftSubtractionRadioModel = new ACListModelAdapter();
      addShortStayStandardRecuperationEtcShiftSubtractionRadioModel();
    }
    return shortStayStandardRecuperationEtcShiftSubtractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getShortStayStandardRecuperationEtcShiftSubtractionRadioItem1(){
    if(shortStayStandardRecuperationEtcShiftSubtractionRadioItem1==null){

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem1 = new ACRadioButtonItem();

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem1.setText("なし");

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem1.setGroup(getShortStayStandardRecuperationEtcShiftSubtractionRadio());

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationEtcShiftSubtractionRadioItem1();
    }
    return shortStayStandardRecuperationEtcShiftSubtractionRadioItem1;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getShortStayStandardRecuperationEtcShiftSubtractionRadioItem2(){
    if(shortStayStandardRecuperationEtcShiftSubtractionRadioItem2==null){

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem2 = new ACRadioButtonItem();

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem2.setText("定員超過");

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem2.setGroup(getShortStayStandardRecuperationEtcShiftSubtractionRadio());

      shortStayStandardRecuperationEtcShiftSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addShortStayStandardRecuperationEtcShiftSubtractionRadioItem2();
    }
    return shortStayStandardRecuperationEtcShiftSubtractionRadioItem2;

  }

  /**
   * 食事コンテナを取得します。
   * @return 食事コンテナ
   */
  public ACBackLabelContainer getShortStayStandardRecuperationDinnerContainer(){
    if(shortStayStandardRecuperationDinnerContainer==null){

      shortStayStandardRecuperationDinnerContainer = new ACBackLabelContainer();

      addShortStayStandardRecuperationDinnerContainer();
    }
    return shortStayStandardRecuperationDinnerContainer;

  }

  /**
   * 食事提供を取得します。
   * @return 食事提供
   */
  public ACComboBox getShortStayStandardRecuperationDinnerOffer(){
    if(shortStayStandardRecuperationDinnerOffer==null){

      shortStayStandardRecuperationDinnerOffer = new ACComboBox();

      getShortStayStandardRecuperationDinnerOfferContainer().setText("食事提供");

      shortStayStandardRecuperationDinnerOffer.setBindPath("1260405");

      shortStayStandardRecuperationDinnerOffer.setEditable(false);

      shortStayStandardRecuperationDinnerOffer.setModelBindPath("1260405");

      shortStayStandardRecuperationDinnerOffer.setRenderBindPath("CONTENT");

      shortStayStandardRecuperationDinnerOffer.setModel(getShortStayStandardRecuperationDinnerOfferModel());

      addShortStayStandardRecuperationDinnerOffer();
    }
    return shortStayStandardRecuperationDinnerOffer;

  }

  /**
   * 食事提供コンテナを取得します。
   * @return 食事提供コンテナ
   */
  protected ACLabelContainer getShortStayStandardRecuperationDinnerOfferContainer(){
    if(shortStayStandardRecuperationDinnerOfferContainer==null){
      shortStayStandardRecuperationDinnerOfferContainer = new ACLabelContainer();
      shortStayStandardRecuperationDinnerOfferContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationDinnerOfferContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationDinnerOfferContainer.add(getShortStayStandardRecuperationDinnerOffer(), null);
    }
    return shortStayStandardRecuperationDinnerOfferContainer;
  }

  /**
   * 食事提供モデルを取得します。
   * @return 食事提供モデル
   */
  protected ACComboBoxModelAdapter getShortStayStandardRecuperationDinnerOfferModel(){
    if(shortStayStandardRecuperationDinnerOfferModel==null){
      shortStayStandardRecuperationDinnerOfferModel = new ACComboBoxModelAdapter();
      addShortStayStandardRecuperationDinnerOfferModel();
    }
    return shortStayStandardRecuperationDinnerOfferModel;
  }

  /**
   * 食事費用を取得します。
   * @return 食事費用
   */
  public ACTextField getShortStayStandardRecuperationDinnerCost(){
    if(shortStayStandardRecuperationDinnerCost==null){

      shortStayStandardRecuperationDinnerCost = new ACTextField();

      getShortStayStandardRecuperationDinnerCostContainer().setText("食事費用");

      shortStayStandardRecuperationDinnerCost.setBindPath("1260406");

      shortStayStandardRecuperationDinnerCost.setColumns(4);

      shortStayStandardRecuperationDinnerCost.setCharType(VRCharType.ONLY_DIGIT);

      shortStayStandardRecuperationDinnerCost.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayStandardRecuperationDinnerCost.setIMEMode(InputSubset.LATIN);

      shortStayStandardRecuperationDinnerCost.setMaxLength(5);

      addShortStayStandardRecuperationDinnerCost();
    }
    return shortStayStandardRecuperationDinnerCost;

  }

  /**
   * 食事費用コンテナを取得します。
   * @return 食事費用コンテナ
   */
  protected ACLabelContainer getShortStayStandardRecuperationDinnerCostContainer(){
    if(shortStayStandardRecuperationDinnerCostContainer==null){
      shortStayStandardRecuperationDinnerCostContainer = new ACLabelContainer();
      shortStayStandardRecuperationDinnerCostContainer.setFollowChildEnabled(true);
      shortStayStandardRecuperationDinnerCostContainer.setVAlignment(VRLayout.CENTER);
      shortStayStandardRecuperationDinnerCostContainer.add(getShortStayStandardRecuperationDinnerCost(), null);
    }
    return shortStayStandardRecuperationDinnerCostContainer;
  }

  /**
   * 30日超を取得します。
   * @return 30日超
   */
  public ACIntegerCheckBox getShortStayStandardRecuperationEtc30Over(){
    if(shortStayStandardRecuperationEtc30Over==null){

      shortStayStandardRecuperationEtc30Over = new ACIntegerCheckBox();

      shortStayStandardRecuperationEtc30Over.setText("30日超");

      shortStayStandardRecuperationEtc30Over.setBindPath("5");

      shortStayStandardRecuperationEtc30Over.setSelectValue(2);

      shortStayStandardRecuperationEtc30Over.setUnSelectValue(1);

      addShortStayStandardRecuperationEtc30Over();
    }
    return shortStayStandardRecuperationEtc30Over;

  }

  /**
   * コンストラクタです。
   */
  public QS001142Design() {

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

    this.add(getShortStayStandardRecuperationPatterns(), VRLayout.CLIENT);

  }

  /**
   * 短期入所療養介護（基準適合診療所）パターン領域）に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationPatterns(){

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationHospitalRoomDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationMeetingAndSendingOffContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationDieticianManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationMedicalExpensesRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationEtcShiftSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationDinnerContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    shortStayStandardRecuperationPatterns.add(getShortStayStandardRecuperationEtc30Over(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 病室区分に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationHospitalRoomDivisionRadio(){

  }

  /**
   * 病室区分モデルに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationHospitalRoomDivisionRadioModel(){

    getShortStayStandardRecuperationHospitalRoomDivisionRadioItem1().setButtonIndex(1);
    getShortStayStandardRecuperationHospitalRoomDivisionRadioModel().add(getShortStayStandardRecuperationHospitalRoomDivisionRadioItem1());

    getShortStayStandardRecuperationHospitalRoomDivisionRadioItem2().setButtonIndex(2);
    getShortStayStandardRecuperationHospitalRoomDivisionRadioModel().add(getShortStayStandardRecuperationHospitalRoomDivisionRadioItem2());

  }

  /**
   * 従来型個室に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationHospitalRoomDivisionRadioItem1(){

  }

  /**
   * 多床室に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationHospitalRoomDivisionRadioItem2(){

  }

  /**
   * 送迎に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationMeetingAndSendingOff(){

  }

  /**
   * 送迎モデルに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationMeetingAndSendingOffModel(){

    getShortStayStandardRecuperationMeetingAndSendingOffNone().setButtonIndex(1);
    getShortStayStandardRecuperationMeetingAndSendingOffModel().add(getShortStayStandardRecuperationMeetingAndSendingOffNone());

    getShortStayStandardRecuperationMeetingAndSendingOffOneWay().setButtonIndex(2);
    getShortStayStandardRecuperationMeetingAndSendingOffModel().add(getShortStayStandardRecuperationMeetingAndSendingOffOneWay());

    getShortStayStandardRecuperationMeetingAndSendingOffRoundTrip().setButtonIndex(3);
    getShortStayStandardRecuperationMeetingAndSendingOffModel().add(getShortStayStandardRecuperationMeetingAndSendingOffRoundTrip());

  }

  /**
   * 送迎なしに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationMeetingAndSendingOffNone(){

  }

  /**
   * 送迎片道に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationMeetingAndSendingOffOneWay(){

  }

  /**
   * 送迎往復に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationMeetingAndSendingOffRoundTrip(){

  }

  /**
   * 栄養管理体制加算に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationDieticianManageRadio(){

  }

  /**
   * 栄養管理体制加算モデルに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationDieticianManageRadioModel(){

    getShortStayStandardRecuperationDieticianManageRadioItem1().setButtonIndex(1);
    getShortStayStandardRecuperationDieticianManageRadioModel().add(getShortStayStandardRecuperationDieticianManageRadioItem1());

    getShortStayStandardRecuperationDieticianManageRadioItem2().setButtonIndex(2);
    getShortStayStandardRecuperationDieticianManageRadioModel().add(getShortStayStandardRecuperationDieticianManageRadioItem2());

    getShortStayStandardRecuperationDieticianManageRadioItem3().setButtonIndex(3);
    getShortStayStandardRecuperationDieticianManageRadioModel().add(getShortStayStandardRecuperationDieticianManageRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationDieticianManageRadioItem1(){

  }

  /**
   * 管理栄養士に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationDieticianManageRadioItem2(){

  }

  /**
   * 栄養士に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationDieticianManageRadioItem3(){

  }

  /**
   * 療養食加算に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationMedicalExpensesRadio(){

  }

  /**
   * 療養食加算モデルに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationMedicalExpensesRadioModel(){

    getShortStayStandardRecuperationMedicalExpensesRadioItem1().setButtonIndex(1);
    getShortStayStandardRecuperationMedicalExpensesRadioModel().add(getShortStayStandardRecuperationMedicalExpensesRadioItem1());

    getShortStayStandardRecuperationMedicalExpensesRadioItem2().setButtonIndex(2);
    getShortStayStandardRecuperationMedicalExpensesRadioModel().add(getShortStayStandardRecuperationMedicalExpensesRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationMedicalExpensesRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationMedicalExpensesRadioItem2(){

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationEtcShiftSubtractionRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationEtcShiftSubtractionRadioModel(){

    getShortStayStandardRecuperationEtcShiftSubtractionRadioItem1().setButtonIndex(1);
    getShortStayStandardRecuperationEtcShiftSubtractionRadioModel().add(getShortStayStandardRecuperationEtcShiftSubtractionRadioItem1());

    getShortStayStandardRecuperationEtcShiftSubtractionRadioItem2().setButtonIndex(2);
    getShortStayStandardRecuperationEtcShiftSubtractionRadioModel().add(getShortStayStandardRecuperationEtcShiftSubtractionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationEtcShiftSubtractionRadioItem1(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationEtcShiftSubtractionRadioItem2(){

  }

  /**
   * 食事コンテナに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationDinnerContainer(){

    shortStayStandardRecuperationDinnerContainer.add(getShortStayStandardRecuperationDinnerOfferContainer(), VRLayout.FLOW);

    shortStayStandardRecuperationDinnerContainer.add(getShortStayStandardRecuperationDinnerCostContainer(), VRLayout.FLOW);

  }

  /**
   * 食事提供に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationDinnerOffer(){

  }

  /**
   * 食事提供モデルに内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationDinnerOfferModel(){

  }

  /**
   * 食事費用に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationDinnerCost(){

  }

  /**
   * 30日超に内部項目を追加します。
   */
  protected void addShortStayStandardRecuperationEtc30Over(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001142Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001142Design getThis() {
    return this;
  }
}
