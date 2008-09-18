
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
 * 作成日: 2008/05/01  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム 特別療養費画面 (QS001200)
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
 * 特別療養費画面画面項目デザイン(QS001200) 
 */
public class QS001200Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel specificConsultationFeePattern;

  private ACGroupBox guidanceManagement;

  private ACPanel guidanceManagements;

  private ACIntegerCheckBox infectionGuidanceManagement;

  private ACIntegerCheckBox bedGuidanceManagement;

  private ACIntegerCheckBox beginningGuidanceManagement;

  private ACIntegerCheckBox heavyRecuperateGuidanceManagement;

  private ACIntegerCheckBox particularInstitutionManagment;

  private ACIntegerCheckBox particularInstitutionManagmentPrivateRoom;

  private ACIntegerCheckBox particularInstitutionManagmentPrivateRoom2;

  private ACIntegerCheckBox heavySkinManegement;

  private ACIntegerCheckBox medicineManegementLeading;

  private ACIntegerCheckBox specialMedicineManagementLeading;

  private ACIntegerCheckBox medicalScienceInfo;

  private ACIntegerCheckBox rehabilitationManegement;

  private ACGroupBox rehabilitation;

  private ACGroupBox etcFrame;

  private ACPanel etcFrames;

  private ACLabelContainer languageTherapy1Conteiner;

  private ACIntegerCheckBox languageTherapy1;

  private ACComboBox languageTherapy1Combo;

  private ACComboBoxModelAdapter languageTherapy1ComboModel;

  private ACLabelContainer language1Conteiner;

  private ACLabel language1Reduce;

  private ACIntegerCheckBox language1;

  private ACComboBox language1Combo;

  private ACComboBoxModelAdapter language1ComboModel;

  private ACIntegerCheckBox rehabilitationSystem;

  private ACIntegerCheckBox dinner;

  private ACGroupBox mindFrame;

  private ACPanel mindFrames;

  private ACIntegerCheckBox mindTherapy;

  private ACIntegerCheckBox cognitive;

  private ACPanel buttons;

  private ACButton apply;

  //getter

  /**
   * 特定診療費設定領域を取得します。
   * @return 特定診療費設定領域
   */
  public ACPanel getSpecificConsultationFeePattern(){
    if(specificConsultationFeePattern==null){

      specificConsultationFeePattern = new ACPanel();

      addSpecificConsultationFeePattern();
    }
    return specificConsultationFeePattern;

  }

  /**
   * 指導管理等を取得します。
   * @return 指導管理等
   */
  public ACGroupBox getGuidanceManagement(){
    if(guidanceManagement==null){

      guidanceManagement = new ACGroupBox();

      guidanceManagement.setText("指導管理等");

      guidanceManagement.setPreferredSize(new Dimension(1,130));

      addGuidanceManagement();
    }
    return guidanceManagement;

  }

  /**
   * 指導管理等を取得します。
   * @return 指導管理等
   */
  public ACPanel getGuidanceManagements(){
    if(guidanceManagements==null){

      guidanceManagements = new ACPanel();

      addGuidanceManagements();
    }
    return guidanceManagements;

  }

  /**
   * 感染対策指導管理を取得します。
   * @return 感染対策指導管理
   */
  public ACIntegerCheckBox getInfectionGuidanceManagement(){
    if(infectionGuidanceManagement==null){

      infectionGuidanceManagement = new ACIntegerCheckBox();

      infectionGuidanceManagement.setText("感染対策指導管理");

      infectionGuidanceManagement.setBindPath("3010101");

      addInfectionGuidanceManagement();
    }
    return infectionGuidanceManagement;

  }

  /**
   * 褥瘡管理を取得します。
   * @return 褥瘡管理
   */
  public ACIntegerCheckBox getBedGuidanceManagement(){
    if(bedGuidanceManagement==null){

      bedGuidanceManagement = new ACIntegerCheckBox();

      bedGuidanceManagement.setText("褥瘡管理");

      bedGuidanceManagement.setBindPath("3010102");

      addBedGuidanceManagement();
    }
    return bedGuidanceManagement;

  }

  /**
   * 初期入所診療管理を取得します。
   * @return 初期入所診療管理
   */
  public ACIntegerCheckBox getBeginningGuidanceManagement(){
    if(beginningGuidanceManagement==null){

      beginningGuidanceManagement = new ACIntegerCheckBox();

      beginningGuidanceManagement.setText("初期入所診療管理");

      beginningGuidanceManagement.setBindPath("3010144");

      addBeginningGuidanceManagement();
    }
    return beginningGuidanceManagement;

  }

  /**
   * 重度療養管理を取得します。
   * @return 重度療養管理
   */
  public ACIntegerCheckBox getHeavyRecuperateGuidanceManagement(){
    if(heavyRecuperateGuidanceManagement==null){

      heavyRecuperateGuidanceManagement = new ACIntegerCheckBox();

      heavyRecuperateGuidanceManagement.setText("重度療養管理");

      heavyRecuperateGuidanceManagement.setBindPath("3010104");

      addHeavyRecuperateGuidanceManagement();
    }
    return heavyRecuperateGuidanceManagement;

  }

  /**
   * 特定施設管理を取得します。
   * @return 特定施設管理
   */
  public ACIntegerCheckBox getParticularInstitutionManagment(){
    if(particularInstitutionManagment==null){

      particularInstitutionManagment = new ACIntegerCheckBox();

      particularInstitutionManagment.setText("特定施設管理");

      particularInstitutionManagment.setBindPath("3010105");

      addParticularInstitutionManagment();
    }
    return particularInstitutionManagment;

  }

  /**
   * 特定施設管理個室加算を取得します。
   * @return 特定施設管理個室加算
   */
  public ACIntegerCheckBox getParticularInstitutionManagmentPrivateRoom(){
    if(particularInstitutionManagmentPrivateRoom==null){

      particularInstitutionManagmentPrivateRoom = new ACIntegerCheckBox();

      particularInstitutionManagmentPrivateRoom.setText("特定施設管理個室加算");

      particularInstitutionManagmentPrivateRoom.setBindPath("3010106");

      addParticularInstitutionManagmentPrivateRoom();
    }
    return particularInstitutionManagmentPrivateRoom;

  }

  /**
   * 特定施設管理2人部屋加算を取得します。
   * @return 特定施設管理2人部屋加算
   */
  public ACIntegerCheckBox getParticularInstitutionManagmentPrivateRoom2(){
    if(particularInstitutionManagmentPrivateRoom2==null){

      particularInstitutionManagmentPrivateRoom2 = new ACIntegerCheckBox();

      particularInstitutionManagmentPrivateRoom2.setText("特定施設管理2人部屋加算");

      particularInstitutionManagmentPrivateRoom2.setBindPath("3010107");

      addParticularInstitutionManagmentPrivateRoom2();
    }
    return particularInstitutionManagmentPrivateRoom2;

  }

  /**
   * 重症皮膚潰瘍管理指導を取得します。
   * @return 重症皮膚潰瘍管理指導
   */
  public ACIntegerCheckBox getHeavySkinManegement(){
    if(heavySkinManegement==null){

      heavySkinManegement = new ACIntegerCheckBox();

      heavySkinManegement.setText("重症皮膚潰瘍管理指導");

      heavySkinManegement.setBindPath("3010108");

      addHeavySkinManegement();
    }
    return heavySkinManegement;

  }

  /**
   * 薬剤管理指導を取得します。
   * @return 薬剤管理指導
   */
  public ACIntegerCheckBox getMedicineManegementLeading(){
    if(medicineManegementLeading==null){

      medicineManegementLeading = new ACIntegerCheckBox();

      medicineManegementLeading.setText("薬剤管理指導");

      medicineManegementLeading.setBindPath("3010110");

      addMedicineManegementLeading();
    }
    return medicineManegementLeading;

  }

  /**
   * 特別薬剤管理指導加算を取得します。
   * @return 特別薬剤管理指導加算
   */
  public ACIntegerCheckBox getSpecialMedicineManagementLeading(){
    if(specialMedicineManagementLeading==null){

      specialMedicineManagementLeading = new ACIntegerCheckBox();

      specialMedicineManagementLeading.setText("特別薬剤管理指導加算");

      specialMedicineManagementLeading.setBindPath("3010111");

      addSpecialMedicineManagementLeading();
    }
    return specialMedicineManagementLeading;

  }

  /**
   * 医学情報提供を取得します。
   * @return 医学情報提供
   */
  public ACIntegerCheckBox getMedicalScienceInfo(){
    if(medicalScienceInfo==null){

      medicalScienceInfo = new ACIntegerCheckBox();

      medicalScienceInfo.setText("医学情報提供");

      medicalScienceInfo.setBindPath("3010145");

      addMedicalScienceInfo();
    }
    return medicalScienceInfo;

  }

  /**
   * リハビリテーション指導管理を取得します。
   * @return リハビリテーション指導管理
   */
  public ACIntegerCheckBox getRehabilitationManegement(){
    if(rehabilitationManegement==null){

      rehabilitationManegement = new ACIntegerCheckBox();

      rehabilitationManegement.setText("リハビリテーション指導管理");

      rehabilitationManegement.setBindPath("3010146");

      addRehabilitationManegement();
    }
    return rehabilitationManegement;

  }

  /**
   * リハビリテーション領域を取得します。
   * @return リハビリテーション領域
   */
  public ACGroupBox getRehabilitation(){
    if(rehabilitation==null){

      rehabilitation = new ACGroupBox();

      rehabilitation.setText("リハビリテーション");

      rehabilitation.setAutoWrap(false);

      rehabilitation.setHgap(0);

      rehabilitation.setLabelMargin(0);

      addRehabilitation();
    }
    return rehabilitation;

  }

  /**
   * その他領域を取得します。
   * @return その他領域
   */
  public ACGroupBox getEtcFrame(){
    if(etcFrame==null){

      etcFrame = new ACGroupBox();

      etcFrame.setText("その他");

      etcFrame.setPreferredSize(new Dimension(1,80));

      addEtcFrame();
    }
    return etcFrame;

  }

  /**
   * その他領域を取得します。
   * @return その他領域
   */
  public ACPanel getEtcFrames(){
    if(etcFrames==null){

      etcFrames = new ACPanel();

      addEtcFrames();
    }
    return etcFrames;

  }

  /**
   * 言語聴覚療法コンテナを取得します。
   * @return 言語聴覚療法コンテナ
   */
  public ACLabelContainer getLanguageTherapy1Conteiner(){
    if(languageTherapy1Conteiner==null){

      languageTherapy1Conteiner = new ACLabelContainer();

      addLanguageTherapy1Conteiner();
    }
    return languageTherapy1Conteiner;

  }

  /**
   * 言語聴覚療法を取得します。
   * @return 言語聴覚療法
   */
  public ACIntegerCheckBox getLanguageTherapy1(){
    if(languageTherapy1==null){

      languageTherapy1 = new ACIntegerCheckBox();

      languageTherapy1.setText("言語聴覚療法");

      addLanguageTherapy1();
    }
    return languageTherapy1;

  }

  /**
   * 言語聴覚療法コンボを取得します。
   * @return 言語聴覚療法コンボ
   */
  public ACComboBox getLanguageTherapy1Combo(){
    if(languageTherapy1Combo==null){

      languageTherapy1Combo = new ACComboBox();

      languageTherapy1Combo.setBindPath("3010147");

      languageTherapy1Combo.setEnabled(false);

      languageTherapy1Combo.setEditable(false);

      languageTherapy1Combo.setModelBindPath("109");

      languageTherapy1Combo.setRenderBindPath("CONTENT");

      languageTherapy1Combo.setModel(getLanguageTherapy1ComboModel());

      languageTherapy1Combo.setPreferredSize(new Dimension(50,10));

      addLanguageTherapy1Combo();
    }
    return languageTherapy1Combo;

  }

  /**
   * 言語聴覚療法コンボモデルを取得します。
   * @return 言語聴覚療法コンボモデル
   */
  protected ACComboBoxModelAdapter getLanguageTherapy1ComboModel(){
    if(languageTherapy1ComboModel==null){
      languageTherapy1ComboModel = new ACComboBoxModelAdapter();
      addLanguageTherapy1ComboModel();
    }
    return languageTherapy1ComboModel;
  }

  /**
   * 言語聴覚コンテナを取得します。
   * @return 言語聴覚コンテナ
   */
  public ACLabelContainer getLanguage1Conteiner(){
    if(language1Conteiner==null){

      language1Conteiner = new ACLabelContainer();

      addLanguage1Conteiner();
    }
    return language1Conteiner;

  }

  /**
   * 11回目以降の減算を取得します。
   * @return 11回目以降の減算
   */
  public ACLabel getLanguage1Reduce(){
    if(language1Reduce==null){

      language1Reduce = new ACLabel();

      language1Reduce.setText("11回目以降の減算");

      addLanguage1Reduce();
    }
    return language1Reduce;

  }

  /**
   * 言語聴覚を取得します。
   * @return 言語聴覚
   */
  public ACIntegerCheckBox getLanguage1(){
    if(language1==null){

      language1 = new ACIntegerCheckBox();

      language1.setText("言語聴覚");

      addLanguage1();
    }
    return language1;

  }

  /**
   * 言語聴覚コンボを取得します。
   * @return 言語聴覚コンボ
   */
  public ACComboBox getLanguage1Combo(){
    if(language1Combo==null){

      language1Combo = new ACComboBox();

      language1Combo.setBindPath("3010148");

      language1Combo.setEnabled(false);

      language1Combo.setEditable(false);

      language1Combo.setModelBindPath("109");

      language1Combo.setRenderBindPath("CONTENT");

      language1Combo.setModel(getLanguage1ComboModel());

      language1Combo.setPreferredSize(new Dimension(50,10));

      addLanguage1Combo();
    }
    return language1Combo;

  }

  /**
   * 言語聴覚コンボモデルを取得します。
   * @return 言語聴覚コンボモデル
   */
  protected ACComboBoxModelAdapter getLanguage1ComboModel(){
    if(language1ComboModel==null){
      language1ComboModel = new ACComboBoxModelAdapter();
      addLanguage1ComboModel();
    }
    return language1ComboModel;
  }

  /**
   * リハビリ体制強化加算を取得します。
   * @return リハビリ体制強化加算
   */
  public ACIntegerCheckBox getRehabilitationSystem(){
    if(rehabilitationSystem==null){

      rehabilitationSystem = new ACIntegerCheckBox();

      rehabilitationSystem.setText("リハビリ体制強化加算");

      rehabilitationSystem.setBindPath("3010141");

      addRehabilitationSystem();
    }
    return rehabilitationSystem;

  }

  /**
   * 摂食機能療法を取得します。
   * @return 摂食機能療法
   */
  public ACIntegerCheckBox getDinner(){
    if(dinner==null){

      dinner = new ACIntegerCheckBox();

      dinner.setText("摂食機能療法");

      dinner.setBindPath("3010136");

      addDinner();
    }
    return dinner;

  }

  /**
   * 精神科専門療法フレームを取得します。
   * @return 精神科専門療法フレーム
   */
  public ACGroupBox getMindFrame(){
    if(mindFrame==null){

      mindFrame = new ACGroupBox();

      mindFrame.setText("精神科専門療法");

      mindFrame.setPreferredSize(new Dimension(1,50));

      addMindFrame();
    }
    return mindFrame;

  }

  /**
   * 精神科専門療法領域を取得します。
   * @return 精神科専門療法領域
   */
  public ACPanel getMindFrames(){
    if(mindFrames==null){

      mindFrames = new ACPanel();

      addMindFrames();
    }
    return mindFrames;

  }

  /**
   * 精神科作業療法を取得します。
   * @return 精神科作業療法
   */
  public ACIntegerCheckBox getMindTherapy(){
    if(mindTherapy==null){

      mindTherapy = new ACIntegerCheckBox();

      mindTherapy.setText("精神科作業療法");

      mindTherapy.setBindPath("3010137");

      addMindTherapy();
    }
    return mindTherapy;

  }

  /**
   * 認知症老人入所精神療法を取得します。
   * @return 認知症老人入所精神療法
   */
  public ACIntegerCheckBox getCognitive(){
    if(cognitive==null){

      cognitive = new ACIntegerCheckBox();

      cognitive.setText("認知症老人入所精神療法");

      cognitive.setBindPath("3010149");

      addCognitive();
    }
    return cognitive;

  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * 設定を取得します。
   * @return 設定
   */
  public ACButton getApply(){
    if(apply==null){

      apply = new ACButton();

      apply.setText("閉じる(C)");

      apply.setMnemonic('C');

      apply.setIconPath(ACConstants.ICON_PATH_OK_16);

      addApply();
    }
    return apply;

  }

  /**
   * コンストラクタです。
   */
  public QS001200Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(600, 355);

      // ウィンドウを中央に配置
      Point pos;
      try{
          pos= ACFrame.getInstance().getLocationOnScreen();
      }catch(Exception ex){
          pos = new Point(0,0);
      }
      Dimension screenSize = ACFrame.getInstance().getSize();
      Dimension frameSize = this.getSize();
      if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
      }
      this.setLocation((int)(pos.getX()+(screenSize.width - frameSize.width) / 2),
              (int)(pos.getY()+(screenSize.height - frameSize.height) / 2));

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

    this.getContentPane().add(getSpecificConsultationFeePattern(), VRLayout.CLIENT);

  }

  /**
   * 特定診療費設定領域に内部項目を追加します。
   */
  protected void addSpecificConsultationFeePattern(){

    specificConsultationFeePattern.add(getGuidanceManagement(), VRLayout.NORTH);

    specificConsultationFeePattern.add(getRehabilitation(), VRLayout.NORTH);

    specificConsultationFeePattern.add(getButtons(), VRLayout.NORTH);

  }

  /**
   * 指導管理等に内部項目を追加します。
   */
  protected void addGuidanceManagement(){

    guidanceManagement.add(getGuidanceManagements(), VRLayout.NORTH);

  }

  /**
   * 指導管理等に内部項目を追加します。
   */
  protected void addGuidanceManagements(){

    guidanceManagements.add(getInfectionGuidanceManagement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getBedGuidanceManagement(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getBeginningGuidanceManagement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getHeavyRecuperateGuidanceManagement(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getParticularInstitutionManagment(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom2(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getHeavySkinManegement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getMedicineManegementLeading(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getSpecialMedicineManagementLeading(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getMedicalScienceInfo(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getRehabilitationManegement(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 感染対策指導管理に内部項目を追加します。
   */
  protected void addInfectionGuidanceManagement(){

  }

  /**
   * 褥瘡管理に内部項目を追加します。
   */
  protected void addBedGuidanceManagement(){

  }

  /**
   * 初期入所診療管理に内部項目を追加します。
   */
  protected void addBeginningGuidanceManagement(){

  }

  /**
   * 重度療養管理に内部項目を追加します。
   */
  protected void addHeavyRecuperateGuidanceManagement(){

  }

  /**
   * 特定施設管理に内部項目を追加します。
   */
  protected void addParticularInstitutionManagment(){

  }

  /**
   * 特定施設管理個室加算に内部項目を追加します。
   */
  protected void addParticularInstitutionManagmentPrivateRoom(){

  }

  /**
   * 特定施設管理2人部屋加算に内部項目を追加します。
   */
  protected void addParticularInstitutionManagmentPrivateRoom2(){

  }

  /**
   * 重症皮膚潰瘍管理指導に内部項目を追加します。
   */
  protected void addHeavySkinManegement(){

  }

  /**
   * 薬剤管理指導に内部項目を追加します。
   */
  protected void addMedicineManegementLeading(){

  }

  /**
   * 特別薬剤管理指導加算に内部項目を追加します。
   */
  protected void addSpecialMedicineManagementLeading(){

  }

  /**
   * 医学情報提供に内部項目を追加します。
   */
  protected void addMedicalScienceInfo(){

  }

  /**
   * リハビリテーション指導管理に内部項目を追加します。
   */
  protected void addRehabilitationManegement(){

  }

  /**
   * リハビリテーション領域に内部項目を追加します。
   */
  protected void addRehabilitation(){

    rehabilitation.add(getEtcFrame(), VRLayout.NORTH);

    rehabilitation.add(getMindFrame(), VRLayout.NORTH);

  }

  /**
   * その他領域に内部項目を追加します。
   */
  protected void addEtcFrame(){

    etcFrame.add(getEtcFrames(), VRLayout.NORTH);

  }

  /**
   * その他領域に内部項目を追加します。
   */
  protected void addEtcFrames(){

    etcFrames.add(getLanguageTherapy1Conteiner(), VRLayout.FLOW_INSETLINE);

    etcFrames.add(getLanguage1Conteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    etcFrames.add(getRehabilitationSystem(), VRLayout.FLOW_INSETLINE);

    etcFrames.add(getDinner(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 言語聴覚療法コンテナに内部項目を追加します。
   */
  protected void addLanguageTherapy1Conteiner(){

    languageTherapy1Conteiner.add(getLanguageTherapy1(), null);

    languageTherapy1Conteiner.add(getLanguageTherapy1Combo(), null);

  }

  /**
   * 言語聴覚療法に内部項目を追加します。
   */
  protected void addLanguageTherapy1(){

  }

  /**
   * 言語聴覚療法コンボに内部項目を追加します。
   */
  protected void addLanguageTherapy1Combo(){

  }

  /**
   * 言語聴覚療法コンボモデルに内部項目を追加します。
   */
  protected void addLanguageTherapy1ComboModel(){

  }

  /**
   * 言語聴覚コンテナに内部項目を追加します。
   */
  protected void addLanguage1Conteiner(){

    language1Conteiner.add(getLanguage1Reduce(), null);

    language1Conteiner.add(getLanguage1(), null);

    language1Conteiner.add(getLanguage1Combo(), null);

  }

  /**
   * 11回目以降の減算に内部項目を追加します。
   */
  protected void addLanguage1Reduce(){

  }

  /**
   * 言語聴覚に内部項目を追加します。
   */
  protected void addLanguage1(){

  }

  /**
   * 言語聴覚コンボに内部項目を追加します。
   */
  protected void addLanguage1Combo(){

  }

  /**
   * 言語聴覚コンボモデルに内部項目を追加します。
   */
  protected void addLanguage1ComboModel(){

  }

  /**
   * リハビリ体制強化加算に内部項目を追加します。
   */
  protected void addRehabilitationSystem(){

  }

  /**
   * 摂食機能療法に内部項目を追加します。
   */
  protected void addDinner(){

  }

  /**
   * 精神科専門療法フレームに内部項目を追加します。
   */
  protected void addMindFrame(){

    mindFrame.add(getMindFrames(), VRLayout.NORTH);

  }

  /**
   * 精神科専門療法領域に内部項目を追加します。
   */
  protected void addMindFrames(){

    mindFrames.add(getMindTherapy(), VRLayout.FLOW_INSETLINE);

    mindFrames.add(getCognitive(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 精神科作業療法に内部項目を追加します。
   */
  protected void addMindTherapy(){

  }

  /**
   * 認知症老人入所精神療法に内部項目を追加します。
   */
  protected void addCognitive(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getApply(), VRLayout.EAST);
  }

  /**
   * 設定に内部項目を追加します。
   */
  protected void addApply(){

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

  public void setVisible(boolean visible){
    if(visible){
      try{
        initAffair(null);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(ex);
      }
    }
    super.setVisible(visible);
  }
  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      new QS001200Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001200Design getThis() {
    return this;
  }
}
