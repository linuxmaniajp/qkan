
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
 * 作成日: 2006/03/09  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン訪問看護（医療） (QS001104)
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
 * サービスパターン訪問看護（医療）画面項目デザイン(QS001104) 
 */
public class QS001104Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACPanel houmonKangoIryoPatterns;

  private ACClearableRadioButtonGroup houmonKangoIryoClass;

  private ACLabelContainer houmonKangoIryoClassContainer;

  private ACListModelAdapter houmonKangoIryoClassModel;

  private ACRadioButtonItem houmonKangoIryoClass1;

  private ACRadioButtonItem houmonKangoIryoClass2;

  private ACClearableRadioButtonGroup houmonKangoIryoIntractableDiseaseRadio;

  private ACLabelContainer houmonKangoIryoIntractableDiseaseRadioContainer;

  private ACListModelAdapter houmonKangoIryoIntractableDiseaseRadioModel;

  private ACRadioButtonItem houmonKangoIryoIntractableDiseaseRadioItem1;

  private ACRadioButtonItem houmonKangoIryoIntractableDiseaseRadioItem2;

  private ACLabelContainer houmonKangoIryoExtensionTimeContena;

  private ACTextField houmonKangoIryoExtensionTimeText;

  private ACLabel houmonKangoIryoExtensionTimeLabel;

  private ACClearableRadioButtonGroup houmonKangoIryoGuidanceRadio;

  private ACLabelContainer houmonKangoIryoGuidanceRadioContainer;

  private ACListModelAdapter houmonKangoIryoGuidanceRadioModel;

  private ACRadioButtonItem houmonKangoIryoGuidanceRadioItem1;

  private ACRadioButtonItem houmonKangoIryoGuidanceRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoIryo24HoureRadio;

  private ACLabelContainer houmonKangoIryo24HoureRadioContainer;

  private ACListModelAdapter houmonKangoIryo24HoureRadioModel;

  private ACRadioButtonItem houmonKangoIryo24HoureRadioItem1;

  private ACRadioButtonItem houmonKangoIryo24HoureRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoIryoSeriousIllnessRadio;

  private ACLabelContainer houmonKangoIryoSeriousIllnessRadioContainer;

  private ACListModelAdapter houmonKangoIryoSeriousIllnessRadioModel;

  private ACRadioButtonItem houmonKangoIryoSeriousIllnessRadioItem1;

  private ACRadioButtonItem houmonKangoIryoSeriousIllnessRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoIryoInfoRadio;

  private ACLabelContainer houmonKangoIryoInfoRadioContainer;

  private ACListModelAdapter houmonKangoIryoInfoRadioModel;

  private ACRadioButtonItem houmonKangoIryoInfoRadioItem1;

  private ACRadioButtonItem houmonKangoIryoInfoRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoIryoTerminalRadio;

  private ACLabelContainer houmonKangoIryoTerminalRadioContainer;

  private ACListModelAdapter houmonKangoIryoTerminalRadioModel;

  private ACRadioButtonItem houmonKangoIryoTerminalRadioItem1;

  private ACRadioButtonItem houmonKangoIryoTerminalRadioItem2;

  //getter

  /**
   * 訪問看護（介護）パターン領域）を取得します。
   * @return 訪問看護（介護）パターン領域）
   */
  public ACPanel getHoumonKangoIryoPatterns(){
    if(houmonKangoIryoPatterns==null){

      houmonKangoIryoPatterns = new ACPanel();

      addHoumonKangoIryoPatterns();
    }
    return houmonKangoIryoPatterns;

  }

  /**
   * 訪問看護職員区分を取得します。
   * @return 訪問看護職員区分
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoClass(){
    if(houmonKangoIryoClass==null){

      houmonKangoIryoClass = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoClassContainer().setText("職員区分");

      houmonKangoIryoClass.setBindPath("2010104");

      houmonKangoIryoClass.setModel(getHoumonKangoIryoClassModel());

      houmonKangoIryoClass.setUseClearButton(false);

      addHoumonKangoIryoClass();
    }
    return houmonKangoIryoClass;

  }

  /**
   * 訪問看護職員区分コンテナを取得します。
   * @return 訪問看護職員区分コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoClassContainer(){
    if(houmonKangoIryoClassContainer==null){
      houmonKangoIryoClassContainer = new ACLabelContainer();
      houmonKangoIryoClassContainer.setFollowChildEnabled(true);
      houmonKangoIryoClassContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoClassContainer.add(getHoumonKangoIryoClass(), null);
    }
    return houmonKangoIryoClassContainer;
  }

  /**
   * 訪問看護職員区分モデルを取得します。
   * @return 訪問看護職員区分モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoClassModel(){
    if(houmonKangoIryoClassModel==null){
      houmonKangoIryoClassModel = new ACListModelAdapter();
      addHoumonKangoIryoClassModel();
    }
    return houmonKangoIryoClassModel;
  }

  /**
   * 正看等を取得します。
   * @return 正看等
   */
  public ACRadioButtonItem getHoumonKangoIryoClass1(){
    if(houmonKangoIryoClass1==null){

      houmonKangoIryoClass1 = new ACRadioButtonItem();

      houmonKangoIryoClass1.setText("正看等");

      houmonKangoIryoClass1.setGroup(getHoumonKangoIryoClass());

      addHoumonKangoIryoClass1();
    }
    return houmonKangoIryoClass1;

  }

  /**
   * 准看を取得します。
   * @return 准看
   */
  public ACRadioButtonItem getHoumonKangoIryoClass2(){
    if(houmonKangoIryoClass2==null){

      houmonKangoIryoClass2 = new ACRadioButtonItem();

      houmonKangoIryoClass2.setText("准看");

      houmonKangoIryoClass2.setGroup(getHoumonKangoIryoClass());

      addHoumonKangoIryoClass2();
    }
    return houmonKangoIryoClass2;

  }

  /**
   * 難病等複数回数訪問加算を取得します。
   * @return 難病等複数回数訪問加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoIntractableDiseaseRadio(){
    if(houmonKangoIryoIntractableDiseaseRadio==null){

      houmonKangoIryoIntractableDiseaseRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoIntractableDiseaseRadioContainer().setText("難病等複数回数訪問加算");

      houmonKangoIryoIntractableDiseaseRadio.setBindPath("2010105");

      houmonKangoIryoIntractableDiseaseRadio.setModel(getHoumonKangoIryoIntractableDiseaseRadioModel());

      houmonKangoIryoIntractableDiseaseRadio.setUseClearButton(false);

      addHoumonKangoIryoIntractableDiseaseRadio();
    }
    return houmonKangoIryoIntractableDiseaseRadio;

  }

  /**
   * 難病等複数回数訪問加算コンテナを取得します。
   * @return 難病等複数回数訪問加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoIntractableDiseaseRadioContainer(){
    if(houmonKangoIryoIntractableDiseaseRadioContainer==null){
      houmonKangoIryoIntractableDiseaseRadioContainer = new ACLabelContainer();
      houmonKangoIryoIntractableDiseaseRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoIntractableDiseaseRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoIntractableDiseaseRadioContainer.add(getHoumonKangoIryoIntractableDiseaseRadio(), null);
    }
    return houmonKangoIryoIntractableDiseaseRadioContainer;
  }

  /**
   * 難病等複数回数訪問加算モデルを取得します。
   * @return 難病等複数回数訪問加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoIntractableDiseaseRadioModel(){
    if(houmonKangoIryoIntractableDiseaseRadioModel==null){
      houmonKangoIryoIntractableDiseaseRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoIntractableDiseaseRadioModel();
    }
    return houmonKangoIryoIntractableDiseaseRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoIntractableDiseaseRadioItem1(){
    if(houmonKangoIryoIntractableDiseaseRadioItem1==null){

      houmonKangoIryoIntractableDiseaseRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoIntractableDiseaseRadioItem1.setText("なし");

      houmonKangoIryoIntractableDiseaseRadioItem1.setGroup(getHoumonKangoIryoIntractableDiseaseRadio());

      addHoumonKangoIryoIntractableDiseaseRadioItem1();
    }
    return houmonKangoIryoIntractableDiseaseRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoIryoIntractableDiseaseRadioItem2(){
    if(houmonKangoIryoIntractableDiseaseRadioItem2==null){

      houmonKangoIryoIntractableDiseaseRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoIntractableDiseaseRadioItem2.setText("あり");

      houmonKangoIryoIntractableDiseaseRadioItem2.setGroup(getHoumonKangoIryoIntractableDiseaseRadio());

      addHoumonKangoIryoIntractableDiseaseRadioItem2();
    }
    return houmonKangoIryoIntractableDiseaseRadioItem2;

  }

  /**
   * 延長時間加算コンテナを取得します。
   * @return 延長時間加算コンテナ
   */
  public ACLabelContainer getHoumonKangoIryoExtensionTimeContena(){
    if(houmonKangoIryoExtensionTimeContena==null){

      houmonKangoIryoExtensionTimeContena = new ACLabelContainer();

      houmonKangoIryoExtensionTimeContena.setText("延長時間加算");

      houmonKangoIryoExtensionTimeContena.setFollowChildEnabled(false);

      addHoumonKangoIryoExtensionTimeContena();
    }
    return houmonKangoIryoExtensionTimeContena;

  }

  /**
   * 延長時間・テキストを取得します。
   * @return 延長時間・テキスト
   */
  public ACTextField getHoumonKangoIryoExtensionTimeText(){
    if(houmonKangoIryoExtensionTimeText==null){

      houmonKangoIryoExtensionTimeText = new ACTextField();

      houmonKangoIryoExtensionTimeText.setBindPath("2010106");

      houmonKangoIryoExtensionTimeText.setColumns(2);

      houmonKangoIryoExtensionTimeText.setCharType(VRCharType.ONLY_DIGIT);

      houmonKangoIryoExtensionTimeText.setHorizontalAlignment(SwingConstants.RIGHT);

      houmonKangoIryoExtensionTimeText.setIMEMode(InputSubset.LATIN);

      houmonKangoIryoExtensionTimeText.setMaxLength(2);

      addHoumonKangoIryoExtensionTimeText();
    }
    return houmonKangoIryoExtensionTimeText;

  }

  /**
   * 延長時間・ラベル2を取得します。
   * @return 延長時間・ラベル2
   */
  public ACLabel getHoumonKangoIryoExtensionTimeLabel(){
    if(houmonKangoIryoExtensionTimeLabel==null){

      houmonKangoIryoExtensionTimeLabel = new ACLabel();

      houmonKangoIryoExtensionTimeLabel.setText("時間");

      addHoumonKangoIryoExtensionTimeLabel();
    }
    return houmonKangoIryoExtensionTimeLabel;

  }

  /**
   * 共同指導加算を取得します。
   * @return 共同指導加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoGuidanceRadio(){
    if(houmonKangoIryoGuidanceRadio==null){

      houmonKangoIryoGuidanceRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoGuidanceRadioContainer().setText("共同指導加算");

      houmonKangoIryoGuidanceRadio.setBindPath("2010107");

      houmonKangoIryoGuidanceRadio.setModel(getHoumonKangoIryoGuidanceRadioModel());

      houmonKangoIryoGuidanceRadio.setUseClearButton(false);

      addHoumonKangoIryoGuidanceRadio();
    }
    return houmonKangoIryoGuidanceRadio;

  }

  /**
   * 共同指導加算コンテナを取得します。
   * @return 共同指導加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoGuidanceRadioContainer(){
    if(houmonKangoIryoGuidanceRadioContainer==null){
      houmonKangoIryoGuidanceRadioContainer = new ACLabelContainer();
      houmonKangoIryoGuidanceRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoGuidanceRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoGuidanceRadioContainer.add(getHoumonKangoIryoGuidanceRadio(), null);
    }
    return houmonKangoIryoGuidanceRadioContainer;
  }

  /**
   * 共同指導加算モデルを取得します。
   * @return 共同指導加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoGuidanceRadioModel(){
    if(houmonKangoIryoGuidanceRadioModel==null){
      houmonKangoIryoGuidanceRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoGuidanceRadioModel();
    }
    return houmonKangoIryoGuidanceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoGuidanceRadioItem1(){
    if(houmonKangoIryoGuidanceRadioItem1==null){

      houmonKangoIryoGuidanceRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoGuidanceRadioItem1.setText("なし");

      houmonKangoIryoGuidanceRadioItem1.setGroup(getHoumonKangoIryoGuidanceRadio());

      addHoumonKangoIryoGuidanceRadioItem1();
    }
    return houmonKangoIryoGuidanceRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoIryoGuidanceRadioItem2(){
    if(houmonKangoIryoGuidanceRadioItem2==null){

      houmonKangoIryoGuidanceRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoGuidanceRadioItem2.setText("あり");

      houmonKangoIryoGuidanceRadioItem2.setGroup(getHoumonKangoIryoGuidanceRadio());

      addHoumonKangoIryoGuidanceRadioItem2();
    }
    return houmonKangoIryoGuidanceRadioItem2;

  }

  /**
   * 24時間加算を取得します。
   * @return 24時間加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryo24HoureRadio(){
    if(houmonKangoIryo24HoureRadio==null){

      houmonKangoIryo24HoureRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryo24HoureRadioContainer().setText("24時間連絡体制加算");

      houmonKangoIryo24HoureRadio.setBindPath("2010108");

      houmonKangoIryo24HoureRadio.setModel(getHoumonKangoIryo24HoureRadioModel());

      houmonKangoIryo24HoureRadio.setUseClearButton(false);

      addHoumonKangoIryo24HoureRadio();
    }
    return houmonKangoIryo24HoureRadio;

  }

  /**
   * 24時間加算コンテナを取得します。
   * @return 24時間加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryo24HoureRadioContainer(){
    if(houmonKangoIryo24HoureRadioContainer==null){
      houmonKangoIryo24HoureRadioContainer = new ACLabelContainer();
      houmonKangoIryo24HoureRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryo24HoureRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryo24HoureRadioContainer.add(getHoumonKangoIryo24HoureRadio(), null);
    }
    return houmonKangoIryo24HoureRadioContainer;
  }

  /**
   * 24時間加算モデルを取得します。
   * @return 24時間加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryo24HoureRadioModel(){
    if(houmonKangoIryo24HoureRadioModel==null){
      houmonKangoIryo24HoureRadioModel = new ACListModelAdapter();
      addHoumonKangoIryo24HoureRadioModel();
    }
    return houmonKangoIryo24HoureRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryo24HoureRadioItem1(){
    if(houmonKangoIryo24HoureRadioItem1==null){

      houmonKangoIryo24HoureRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryo24HoureRadioItem1.setText("なし");

      houmonKangoIryo24HoureRadioItem1.setGroup(getHoumonKangoIryo24HoureRadio());

      addHoumonKangoIryo24HoureRadioItem1();
    }
    return houmonKangoIryo24HoureRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoIryo24HoureRadioItem2(){
    if(houmonKangoIryo24HoureRadioItem2==null){

      houmonKangoIryo24HoureRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryo24HoureRadioItem2.setText("あり");

      houmonKangoIryo24HoureRadioItem2.setGroup(getHoumonKangoIryo24HoureRadio());

      addHoumonKangoIryo24HoureRadioItem2();
    }
    return houmonKangoIryo24HoureRadioItem2;

  }

  /**
   * 重傷者加算を取得します。
   * @return 重傷者加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoSeriousIllnessRadio(){
    if(houmonKangoIryoSeriousIllnessRadio==null){

      houmonKangoIryoSeriousIllnessRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoSeriousIllnessRadioContainer().setText("重症者管理加算");

      houmonKangoIryoSeriousIllnessRadio.setBindPath("2010109");

      houmonKangoIryoSeriousIllnessRadio.setModel(getHoumonKangoIryoSeriousIllnessRadioModel());

      houmonKangoIryoSeriousIllnessRadio.setUseClearButton(false);

      addHoumonKangoIryoSeriousIllnessRadio();
    }
    return houmonKangoIryoSeriousIllnessRadio;

  }

  /**
   * 重傷者加算コンテナを取得します。
   * @return 重傷者加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoSeriousIllnessRadioContainer(){
    if(houmonKangoIryoSeriousIllnessRadioContainer==null){
      houmonKangoIryoSeriousIllnessRadioContainer = new ACLabelContainer();
      houmonKangoIryoSeriousIllnessRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoSeriousIllnessRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoSeriousIllnessRadioContainer.add(getHoumonKangoIryoSeriousIllnessRadio(), null);
    }
    return houmonKangoIryoSeriousIllnessRadioContainer;
  }

  /**
   * 重傷者加算モデルを取得します。
   * @return 重傷者加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoSeriousIllnessRadioModel(){
    if(houmonKangoIryoSeriousIllnessRadioModel==null){
      houmonKangoIryoSeriousIllnessRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoSeriousIllnessRadioModel();
    }
    return houmonKangoIryoSeriousIllnessRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoSeriousIllnessRadioItem1(){
    if(houmonKangoIryoSeriousIllnessRadioItem1==null){

      houmonKangoIryoSeriousIllnessRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoSeriousIllnessRadioItem1.setText("なし");

      houmonKangoIryoSeriousIllnessRadioItem1.setGroup(getHoumonKangoIryoSeriousIllnessRadio());

      addHoumonKangoIryoSeriousIllnessRadioItem1();
    }
    return houmonKangoIryoSeriousIllnessRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoIryoSeriousIllnessRadioItem2(){
    if(houmonKangoIryoSeriousIllnessRadioItem2==null){

      houmonKangoIryoSeriousIllnessRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoSeriousIllnessRadioItem2.setText("あり");

      houmonKangoIryoSeriousIllnessRadioItem2.setGroup(getHoumonKangoIryoSeriousIllnessRadio());

      addHoumonKangoIryoSeriousIllnessRadioItem2();
    }
    return houmonKangoIryoSeriousIllnessRadioItem2;

  }

  /**
   * 情報提供加算を取得します。
   * @return 情報提供加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoInfoRadio(){
    if(houmonKangoIryoInfoRadio==null){

      houmonKangoIryoInfoRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoInfoRadioContainer().setText("情報提供加算");

      houmonKangoIryoInfoRadio.setBindPath("2010110");

      houmonKangoIryoInfoRadio.setModel(getHoumonKangoIryoInfoRadioModel());

      houmonKangoIryoInfoRadio.setUseClearButton(false);

      addHoumonKangoIryoInfoRadio();
    }
    return houmonKangoIryoInfoRadio;

  }

  /**
   * 情報提供加算コンテナを取得します。
   * @return 情報提供加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoInfoRadioContainer(){
    if(houmonKangoIryoInfoRadioContainer==null){
      houmonKangoIryoInfoRadioContainer = new ACLabelContainer();
      houmonKangoIryoInfoRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoInfoRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoInfoRadioContainer.add(getHoumonKangoIryoInfoRadio(), null);
    }
    return houmonKangoIryoInfoRadioContainer;
  }

  /**
   * 情報提供加算モデルを取得します。
   * @return 情報提供加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoInfoRadioModel(){
    if(houmonKangoIryoInfoRadioModel==null){
      houmonKangoIryoInfoRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoInfoRadioModel();
    }
    return houmonKangoIryoInfoRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoInfoRadioItem1(){
    if(houmonKangoIryoInfoRadioItem1==null){

      houmonKangoIryoInfoRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoInfoRadioItem1.setText("なし");

      houmonKangoIryoInfoRadioItem1.setGroup(getHoumonKangoIryoInfoRadio());

      addHoumonKangoIryoInfoRadioItem1();
    }
    return houmonKangoIryoInfoRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoIryoInfoRadioItem2(){
    if(houmonKangoIryoInfoRadioItem2==null){

      houmonKangoIryoInfoRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoInfoRadioItem2.setText("あり");

      houmonKangoIryoInfoRadioItem2.setGroup(getHoumonKangoIryoInfoRadio());

      addHoumonKangoIryoInfoRadioItem2();
    }
    return houmonKangoIryoInfoRadioItem2;

  }

  /**
   * ターミナルケア加算を取得します。
   * @return ターミナルケア加算
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoTerminalRadio(){
    if(houmonKangoIryoTerminalRadio==null){

      houmonKangoIryoTerminalRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoTerminalRadioContainer().setText("ターミナルケア加算");

      houmonKangoIryoTerminalRadio.setBindPath("2010111");

      houmonKangoIryoTerminalRadio.setModel(getHoumonKangoIryoTerminalRadioModel());

      houmonKangoIryoTerminalRadio.setUseClearButton(false);

      addHoumonKangoIryoTerminalRadio();
    }
    return houmonKangoIryoTerminalRadio;

  }

  /**
   * ターミナルケア加算コンテナを取得します。
   * @return ターミナルケア加算コンテナ
   */
  protected ACLabelContainer getHoumonKangoIryoTerminalRadioContainer(){
    if(houmonKangoIryoTerminalRadioContainer==null){
      houmonKangoIryoTerminalRadioContainer = new ACLabelContainer();
      houmonKangoIryoTerminalRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoTerminalRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoTerminalRadioContainer.add(getHoumonKangoIryoTerminalRadio(), null);
    }
    return houmonKangoIryoTerminalRadioContainer;
  }

  /**
   * ターミナルケア加算モデルを取得します。
   * @return ターミナルケア加算モデル
   */
  protected ACListModelAdapter getHoumonKangoIryoTerminalRadioModel(){
    if(houmonKangoIryoTerminalRadioModel==null){
      houmonKangoIryoTerminalRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoTerminalRadioModel();
    }
    return houmonKangoIryoTerminalRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonKangoIryoTerminalRadioItem1(){
    if(houmonKangoIryoTerminalRadioItem1==null){

      houmonKangoIryoTerminalRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoTerminalRadioItem1.setText("なし");

      houmonKangoIryoTerminalRadioItem1.setGroup(getHoumonKangoIryoTerminalRadio());

      addHoumonKangoIryoTerminalRadioItem1();
    }
    return houmonKangoIryoTerminalRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonKangoIryoTerminalRadioItem2(){
    if(houmonKangoIryoTerminalRadioItem2==null){

      houmonKangoIryoTerminalRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoTerminalRadioItem2.setText("あり");

      houmonKangoIryoTerminalRadioItem2.setGroup(getHoumonKangoIryoTerminalRadio());

      addHoumonKangoIryoTerminalRadioItem2();
    }
    return houmonKangoIryoTerminalRadioItem2;

  }

  /**
   * コンストラクタです。
   */
  public QS001104Design() {

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

    this.add(getHoumonKangoIryoPatterns(), VRLayout.CLIENT);

  }

  /**
   * 訪問看護（介護）パターン領域）に内部項目を追加します。
   */
  protected void addHoumonKangoIryoPatterns(){

    houmonKangoIryoPatterns.add(getHoumonKangoIryoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoIntractableDiseaseRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoExtensionTimeContena(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoGuidanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryo24HoureRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoSeriousIllnessRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoInfoRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 訪問看護職員区分に内部項目を追加します。
   */
  protected void addHoumonKangoIryoClass(){

  }

  /**
   * 訪問看護職員区分モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoClassModel(){

    getHoumonKangoIryoClass1().setButtonIndex(1);
    getHoumonKangoIryoClassModel().add(getHoumonKangoIryoClass1());

    getHoumonKangoIryoClass2().setButtonIndex(2);
    getHoumonKangoIryoClassModel().add(getHoumonKangoIryoClass2());

  }

  /**
   * 正看等に内部項目を追加します。
   */
  protected void addHoumonKangoIryoClass1(){

  }

  /**
   * 准看に内部項目を追加します。
   */
  protected void addHoumonKangoIryoClass2(){

  }

  /**
   * 難病等複数回数訪問加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadio(){

  }

  /**
   * 難病等複数回数訪問加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadioModel(){

    getHoumonKangoIryoIntractableDiseaseRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoIntractableDiseaseRadioModel().add(getHoumonKangoIryoIntractableDiseaseRadioItem1());

    getHoumonKangoIryoIntractableDiseaseRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoIntractableDiseaseRadioModel().add(getHoumonKangoIryoIntractableDiseaseRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadioItem2(){

  }

  /**
   * 延長時間加算コンテナに内部項目を追加します。
   */
  protected void addHoumonKangoIryoExtensionTimeContena(){

    houmonKangoIryoExtensionTimeContena.add(getHoumonKangoIryoExtensionTimeText(), VRLayout.FLOW);

    houmonKangoIryoExtensionTimeContena.add(getHoumonKangoIryoExtensionTimeLabel(), VRLayout.FLOW);

  }

  /**
   * 延長時間・テキストに内部項目を追加します。
   */
  protected void addHoumonKangoIryoExtensionTimeText(){

  }

  /**
   * 延長時間・ラベル2に内部項目を追加します。
   */
  protected void addHoumonKangoIryoExtensionTimeLabel(){

  }

  /**
   * 共同指導加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryoGuidanceRadio(){

  }

  /**
   * 共同指導加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoGuidanceRadioModel(){

    getHoumonKangoIryoGuidanceRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoGuidanceRadioModel().add(getHoumonKangoIryoGuidanceRadioItem1());

    getHoumonKangoIryoGuidanceRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoGuidanceRadioModel().add(getHoumonKangoIryoGuidanceRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoGuidanceRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoIryoGuidanceRadioItem2(){

  }

  /**
   * 24時間加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryo24HoureRadio(){

  }

  /**
   * 24時間加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryo24HoureRadioModel(){

    getHoumonKangoIryo24HoureRadioItem1().setButtonIndex(1);
    getHoumonKangoIryo24HoureRadioModel().add(getHoumonKangoIryo24HoureRadioItem1());

    getHoumonKangoIryo24HoureRadioItem2().setButtonIndex(2);
    getHoumonKangoIryo24HoureRadioModel().add(getHoumonKangoIryo24HoureRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryo24HoureRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoIryo24HoureRadioItem2(){

  }

  /**
   * 重傷者加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryoSeriousIllnessRadio(){

  }

  /**
   * 重傷者加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioModel(){

    getHoumonKangoIryoSeriousIllnessRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoSeriousIllnessRadioModel().add(getHoumonKangoIryoSeriousIllnessRadioItem1());

    getHoumonKangoIryoSeriousIllnessRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoSeriousIllnessRadioModel().add(getHoumonKangoIryoSeriousIllnessRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioItem2(){

  }

  /**
   * 情報提供加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryoInfoRadio(){

  }

  /**
   * 情報提供加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoInfoRadioModel(){

    getHoumonKangoIryoInfoRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoInfoRadioModel().add(getHoumonKangoIryoInfoRadioItem1());

    getHoumonKangoIryoInfoRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoInfoRadioModel().add(getHoumonKangoIryoInfoRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoInfoRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoIryoInfoRadioItem2(){

  }

  /**
   * ターミナルケア加算に内部項目を追加します。
   */
  protected void addHoumonKangoIryoTerminalRadio(){

  }

  /**
   * ターミナルケア加算モデルに内部項目を追加します。
   */
  protected void addHoumonKangoIryoTerminalRadioModel(){

    getHoumonKangoIryoTerminalRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoTerminalRadioModel().add(getHoumonKangoIryoTerminalRadioItem1());

    getHoumonKangoIryoTerminalRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoTerminalRadioModel().add(getHoumonKangoIryoTerminalRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonKangoIryoTerminalRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonKangoIryoTerminalRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001104Design getThis() {
    return this;
  }
}
