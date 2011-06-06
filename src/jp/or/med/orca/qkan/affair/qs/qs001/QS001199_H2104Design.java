
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
 * 作成日: 2010/11/05  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム 特定診療費画面 (QS001199_H2104)
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
 * 特定診療費画面画面項目デザイン(QS001199_H2104) 
 */
public class QS001199_H2104Design extends QkanAffairDialog {
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

  private ACIntegerCheckBox medicalScienceInfo1;

  private ACIntegerCheckBox medicalScienceInfo2;

  private ACGroupBox rehabilitation;

  private ACGroupBox scienceTherapy;

  private ACPanel scienceTherapys;

  private ACLabelContainer scienceTherapy1Container;

  private ACIntegerCheckBox scienceTherapy1;

  private ACComboBox scienceTherapy1Combo;

  private ACComboBoxModelAdapter scienceTherapy1ComboModel;

  private ACLabelContainer scienceTherapy2Container;

  private ACIntegerCheckBox scienceTherapy2;

  private ACComboBox scienceTherapy2Combo;

  private ACComboBoxModelAdapter scienceTherapy2ComboModel;

  private ACLabelContainer science1Container;

  private ACLabel scienceLabel1;

  private ACIntegerCheckBox science1;

  private ACComboBox science1Combo;

  private ACComboBoxModelAdapter science1ComboModel;

  private ACLabelContainer science2Container;

  private ACIntegerCheckBox science2;

  private ACComboBox science2Combo;

  private ACComboBoxModelAdapter science2ComboModel;

  private ACIntegerCheckBox rehabilitationPlan;

  private ACIntegerCheckBox normalAction;

  private ACLabelContainer rehabilitationSystem1Container;

  private ACIntegerCheckBox rehabilitationSystem1;

  private ACComboBox rehabilitationSystem1Combo;

  private ACComboBoxModelAdapter rehabilitationSystem1ComboModel;

  private ACGroupBox workTherapyFrame;

  private ACPanel workTherapyFrames;

  private ACLabelContainer workTherapy1Conteiner;

  private ACIntegerCheckBox workTherapy1;

  private ACComboBox workTherapy1Combo;

  private ACComboBoxModelAdapter workTherapy1ComboModel;

  private ACLabelContainer work1Conteiner;

  private ACLabel reduce11Over;

  private ACIntegerCheckBox work1;

  private ACComboBox work1Combo;

  private ACComboBoxModelAdapter work1ComboModel;

  private ACIntegerCheckBox rehabilitationPlan2;

  private ACIntegerCheckBox normalActionTraning;

  private ACLabelContainer rehabilitationSystem2Container;

  private ACIntegerCheckBox rehabilitationSystem2;

  private ACComboBox rehabilitationSystem2Combo;

  private ACComboBoxModelAdapter rehabilitationSystem2ComboModel;

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

  private ACLabelContainer rehabilitationSystem3Container;

  private ACIntegerCheckBox rehabilitationSystem3;

  private ACComboBox rehabilitationSystem3Combo;

  private ACComboBoxModelAdapter rehabilitationSystem3ComboModel;

  private ACIntegerCheckBox dinner;

  private ACIntegerCheckBox concentratedRehabilitation;

  private ACIntegerCheckBox groupCommunication;

  private ACIntegerCheckBox dementiaShortRehabilitation;

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

      guidanceManagement.setPreferredSize(new Dimension(1,115));

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
   * 褥瘡対策指導管理を取得します。
   * @return 褥瘡対策指導管理
   */
  public ACIntegerCheckBox getBedGuidanceManagement(){
    if(bedGuidanceManagement==null){

      bedGuidanceManagement = new ACIntegerCheckBox();

      bedGuidanceManagement.setText("褥瘡対策指導管理");

      bedGuidanceManagement.setBindPath("3010102");

      addBedGuidanceManagement();
    }
    return bedGuidanceManagement;

  }

  /**
   * 初期入院診療管理を取得します。
   * @return 初期入院診療管理
   */
  public ACIntegerCheckBox getBeginningGuidanceManagement(){
    if(beginningGuidanceManagement==null){

      beginningGuidanceManagement = new ACIntegerCheckBox();

      beginningGuidanceManagement.setText("初期入院診療管理");

      beginningGuidanceManagement.setBindPath("3010103");

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
   * 医学情報提供(I)を取得します。
   * @return 医学情報提供(I)
   */
  public ACIntegerCheckBox getMedicalScienceInfo1(){
    if(medicalScienceInfo1==null){

      medicalScienceInfo1 = new ACIntegerCheckBox();

      medicalScienceInfo1.setText("医学情報提供(I)");

      medicalScienceInfo1.setBindPath("3010112");

      addMedicalScienceInfo1();
    }
    return medicalScienceInfo1;

  }

  /**
   * 医学情報提供(II)を取得します。
   * @return 医学情報提供(II)
   */
  public ACIntegerCheckBox getMedicalScienceInfo2(){
    if(medicalScienceInfo2==null){

      medicalScienceInfo2 = new ACIntegerCheckBox();

      medicalScienceInfo2.setText("医学情報提供(II)");

      medicalScienceInfo2.setBindPath("3010113");

      addMedicalScienceInfo2();
    }
    return medicalScienceInfo2;

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
   * 理学療法領域を取得します。
   * @return 理学療法領域
   */
  public ACGroupBox getScienceTherapy(){
    if(scienceTherapy==null){

      scienceTherapy = new ACGroupBox();

      scienceTherapy.setText("理学療法");

      scienceTherapy.setPreferredSize(new Dimension(1,125));

      addScienceTherapy();
    }
    return scienceTherapy;

  }

  /**
   * 理学療法領域を取得します。
   * @return 理学療法領域
   */
  public ACPanel getScienceTherapys(){
    if(scienceTherapys==null){

      scienceTherapys = new ACPanel();

      addScienceTherapys();
    }
    return scienceTherapys;

  }

  /**
   * 理学療法コンテナ1を取得します。
   * @return 理学療法コンテナ1
   */
  public ACLabelContainer getScienceTherapy1Container(){
    if(scienceTherapy1Container==null){

      scienceTherapy1Container = new ACLabelContainer();

      addScienceTherapy1Container();
    }
    return scienceTherapy1Container;

  }

  /**
   * 理学療法(I)を取得します。
   * @return 理学療法(I)
   */
  public ACIntegerCheckBox getScienceTherapy1(){
    if(scienceTherapy1==null){

      scienceTherapy1 = new ACIntegerCheckBox();

      scienceTherapy1.setText("理学療法(I)");

      addScienceTherapy1();
    }
    return scienceTherapy1;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getScienceTherapy1Combo(){
    if(scienceTherapy1Combo==null){

      scienceTherapy1Combo = new ACComboBox();

      scienceTherapy1Combo.setBindPath("3010116");

      scienceTherapy1Combo.setEnabled(false);

      scienceTherapy1Combo.setEditable(false);

      scienceTherapy1Combo.setModelBindPath("109");

      scienceTherapy1Combo.setRenderBindPath("CONTENT");

      scienceTherapy1Combo.setModel(getScienceTherapy1ComboModel());

      scienceTherapy1Combo.setPreferredSize(new Dimension(50,10));

      addScienceTherapy1Combo();
    }
    return scienceTherapy1Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getScienceTherapy1ComboModel(){
    if(scienceTherapy1ComboModel==null){
      scienceTherapy1ComboModel = new ACComboBoxModelAdapter();
      addScienceTherapy1ComboModel();
    }
    return scienceTherapy1ComboModel;
  }

  /**
   * 理学療法コンテナ2を取得します。
   * @return 理学療法コンテナ2
   */
  public ACLabelContainer getScienceTherapy2Container(){
    if(scienceTherapy2Container==null){

      scienceTherapy2Container = new ACLabelContainer();

      addScienceTherapy2Container();
    }
    return scienceTherapy2Container;

  }

  /**
   * 理学療法(II)を取得します。
   * @return 理学療法(II)
   */
  public ACIntegerCheckBox getScienceTherapy2(){
    if(scienceTherapy2==null){

      scienceTherapy2 = new ACIntegerCheckBox();

      scienceTherapy2.setText("理学療法(II)");

      addScienceTherapy2();
    }
    return scienceTherapy2;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getScienceTherapy2Combo(){
    if(scienceTherapy2Combo==null){

      scienceTherapy2Combo = new ACComboBox();

      scienceTherapy2Combo.setBindPath("3010117");

      scienceTherapy2Combo.setEnabled(false);

      scienceTherapy2Combo.setEditable(false);

      scienceTherapy2Combo.setModelBindPath("109");

      scienceTherapy2Combo.setRenderBindPath("CONTENT");

      scienceTherapy2Combo.setModel(getScienceTherapy2ComboModel());

      scienceTherapy2Combo.setPreferredSize(new Dimension(50,10));

      addScienceTherapy2Combo();
    }
    return scienceTherapy2Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getScienceTherapy2ComboModel(){
    if(scienceTherapy2ComboModel==null){
      scienceTherapy2ComboModel = new ACComboBoxModelAdapter();
      addScienceTherapy2ComboModel();
    }
    return scienceTherapy2ComboModel;
  }

  /**
   * 理学コンテナ1を取得します。
   * @return 理学コンテナ1
   */
  public ACLabelContainer getScience1Container(){
    if(science1Container==null){

      science1Container = new ACLabelContainer();

      addScience1Container();
    }
    return science1Container;

  }

  /**
   * ラベルを取得します。
   * @return ラベル
   */
  public ACLabel getScienceLabel1(){
    if(scienceLabel1==null){

      scienceLabel1 = new ACLabel();

      scienceLabel1.setText("11回目以降の減算");

      addScienceLabel1();
    }
    return scienceLabel1;

  }

  /**
   * 理学(I)を取得します。
   * @return 理学(I)
   */
  public ACIntegerCheckBox getScience1(){
    if(science1==null){

      science1 = new ACIntegerCheckBox();

      science1.setText("理学(I)");

      addScience1();
    }
    return science1;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getScience1Combo(){
    if(science1Combo==null){

      science1Combo = new ACComboBox();

      science1Combo.setBindPath("3010120");

      science1Combo.setEnabled(false);

      science1Combo.setEditable(false);

      science1Combo.setModelBindPath("109");

      science1Combo.setRenderBindPath("CONTENT");

      science1Combo.setModel(getScience1ComboModel());

      science1Combo.setPreferredSize(new Dimension(50,10));

      addScience1Combo();
    }
    return science1Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getScience1ComboModel(){
    if(science1ComboModel==null){
      science1ComboModel = new ACComboBoxModelAdapter();
      addScience1ComboModel();
    }
    return science1ComboModel;
  }

  /**
   * 理学コンテナ2を取得します。
   * @return 理学コンテナ2
   */
  public ACLabelContainer getScience2Container(){
    if(science2Container==null){

      science2Container = new ACLabelContainer();

      addScience2Container();
    }
    return science2Container;

  }

  /**
   * 理学(II)を取得します。
   * @return 理学(II)
   */
  public ACIntegerCheckBox getScience2(){
    if(science2==null){

      science2 = new ACIntegerCheckBox();

      science2.setText("理学(II)");

      addScience2();
    }
    return science2;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getScience2Combo(){
    if(science2Combo==null){

      science2Combo = new ACComboBox();

      science2Combo.setBindPath("3010121");

      science2Combo.setEnabled(false);

      science2Combo.setEditable(false);

      science2Combo.setModelBindPath("109");

      science2Combo.setRenderBindPath("CONTENT");

      science2Combo.setModel(getScience2ComboModel());

      science2Combo.setPreferredSize(new Dimension(50,10));

      addScience2Combo();
    }
    return science2Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getScience2ComboModel(){
    if(science2ComboModel==null){
      science2ComboModel = new ACComboBoxModelAdapter();
      addScience2ComboModel();
    }
    return science2ComboModel;
  }

  /**
   * リハビリ計画加算を取得します。
   * @return リハビリ計画加算
   */
  public ACIntegerCheckBox getRehabilitationPlan(){
    if(rehabilitationPlan==null){

      rehabilitationPlan = new ACIntegerCheckBox();

      rehabilitationPlan.setText("リハビリ計画加算");

      rehabilitationPlan.setBindPath("3010123");

      addRehabilitationPlan();
    }
    return rehabilitationPlan;

  }

  /**
   * 日常動作訓練指導加算を取得します。
   * @return 日常動作訓練指導加算
   */
  public ACIntegerCheckBox getNormalAction(){
    if(normalAction==null){

      normalAction = new ACIntegerCheckBox();

      normalAction.setText("日常動作訓練指導加算");

      normalAction.setBindPath("3010124");

      addNormalAction();
    }
    return normalAction;

  }

  /**
   * リハビリ体制強化加算コンテナを取得します。
   * @return リハビリ体制強化加算コンテナ
   */
  public ACLabelContainer getRehabilitationSystem1Container(){
    if(rehabilitationSystem1Container==null){

      rehabilitationSystem1Container = new ACLabelContainer();

      addRehabilitationSystem1Container();
    }
    return rehabilitationSystem1Container;

  }

  /**
   * リハビリ体制強化加算を取得します。
   * @return リハビリ体制強化加算
   */
  public ACIntegerCheckBox getRehabilitationSystem1(){
    if(rehabilitationSystem1==null){

      rehabilitationSystem1 = new ACIntegerCheckBox();

      rehabilitationSystem1.setText("リハビリ体制強化加算");

      addRehabilitationSystem1();
    }
    return rehabilitationSystem1;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getRehabilitationSystem1Combo(){
    if(rehabilitationSystem1Combo==null){

      rehabilitationSystem1Combo = new ACComboBox();

      rehabilitationSystem1Combo.setBindPath("3010139");

      rehabilitationSystem1Combo.setEnabled(false);

      rehabilitationSystem1Combo.setEditable(false);

      rehabilitationSystem1Combo.setModelBindPath("109");

      rehabilitationSystem1Combo.setRenderBindPath("CONTENT");

      rehabilitationSystem1Combo.setModel(getRehabilitationSystem1ComboModel());

      rehabilitationSystem1Combo.setPreferredSize(new Dimension(50,10));

      addRehabilitationSystem1Combo();
    }
    return rehabilitationSystem1Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getRehabilitationSystem1ComboModel(){
    if(rehabilitationSystem1ComboModel==null){
      rehabilitationSystem1ComboModel = new ACComboBoxModelAdapter();
      addRehabilitationSystem1ComboModel();
    }
    return rehabilitationSystem1ComboModel;
  }

  /**
   * 作業療法フレームを取得します。
   * @return 作業療法フレーム
   */
  public ACGroupBox getWorkTherapyFrame(){
    if(workTherapyFrame==null){

      workTherapyFrame = new ACGroupBox();

      workTherapyFrame.setText("作業療法");

      workTherapyFrame.setAutoWrap(false);

      workTherapyFrame.setPreferredSize(new Dimension(1,100));

      addWorkTherapyFrame();
    }
    return workTherapyFrame;

  }

  /**
   * 作業療法領域を取得します。
   * @return 作業療法領域
   */
  public ACPanel getWorkTherapyFrames(){
    if(workTherapyFrames==null){

      workTherapyFrames = new ACPanel();

      workTherapyFrames.setAutoWrap(false);

      addWorkTherapyFrames();
    }
    return workTherapyFrames;

  }

  /**
   * 作業療法Iコンテナを取得します。
   * @return 作業療法Iコンテナ
   */
  public ACLabelContainer getWorkTherapy1Conteiner(){
    if(workTherapy1Conteiner==null){

      workTherapy1Conteiner = new ACLabelContainer();

      addWorkTherapy1Conteiner();
    }
    return workTherapy1Conteiner;

  }

  /**
   * 作業療法Iを取得します。
   * @return 作業療法I
   */
  public ACIntegerCheckBox getWorkTherapy1(){
    if(workTherapy1==null){

      workTherapy1 = new ACIntegerCheckBox();

      workTherapy1.setText("作業療法");

      addWorkTherapy1();
    }
    return workTherapy1;

  }

  /**
   * 作業療法Iコンボを取得します。
   * @return 作業療法Iコンボ
   */
  public ACComboBox getWorkTherapy1Combo(){
    if(workTherapy1Combo==null){

      workTherapy1Combo = new ACComboBox();

      workTherapy1Combo.setBindPath("3010126");

      workTherapy1Combo.setEnabled(false);

      workTherapy1Combo.setEditable(false);

      workTherapy1Combo.setModelBindPath("109");

      workTherapy1Combo.setRenderBindPath("CONTENT");

      workTherapy1Combo.setModel(getWorkTherapy1ComboModel());

      workTherapy1Combo.setPreferredSize(new Dimension(50,10));

      addWorkTherapy1Combo();
    }
    return workTherapy1Combo;

  }

  /**
   * 作業療法Iコンボモデルを取得します。
   * @return 作業療法Iコンボモデル
   */
  protected ACComboBoxModelAdapter getWorkTherapy1ComboModel(){
    if(workTherapy1ComboModel==null){
      workTherapy1ComboModel = new ACComboBoxModelAdapter();
      addWorkTherapy1ComboModel();
    }
    return workTherapy1ComboModel;
  }

  /**
   * 作業Iコンテナを取得します。
   * @return 作業Iコンテナ
   */
  public ACLabelContainer getWork1Conteiner(){
    if(work1Conteiner==null){

      work1Conteiner = new ACLabelContainer();

      addWork1Conteiner();
    }
    return work1Conteiner;

  }

  /**
   * 11回目以降の減算を取得します。
   * @return 11回目以降の減算
   */
  public ACLabel getReduce11Over(){
    if(reduce11Over==null){

      reduce11Over = new ACLabel();

      reduce11Over.setText("11回目以降の減算");

      addReduce11Over();
    }
    return reduce11Over;

  }

  /**
   * 作業(I)を取得します。
   * @return 作業(I)
   */
  public ACIntegerCheckBox getWork1(){
    if(work1==null){

      work1 = new ACIntegerCheckBox();

      work1.setText("作業");

      addWork1();
    }
    return work1;

  }

  /**
   * 作業(I)コンボを取得します。
   * @return 作業(I)コンボ
   */
  public ACComboBox getWork1Combo(){
    if(work1Combo==null){

      work1Combo = new ACComboBox();

      work1Combo.setBindPath("3010128");

      work1Combo.setEnabled(false);

      work1Combo.setEditable(false);

      work1Combo.setModelBindPath("109");

      work1Combo.setRenderBindPath("CONTENT");

      work1Combo.setModel(getWork1ComboModel());

      work1Combo.setPreferredSize(new Dimension(50,10));

      addWork1Combo();
    }
    return work1Combo;

  }

  /**
   * 作業(I)コンボモデルを取得します。
   * @return 作業(I)コンボモデル
   */
  protected ACComboBoxModelAdapter getWork1ComboModel(){
    if(work1ComboModel==null){
      work1ComboModel = new ACComboBoxModelAdapter();
      addWork1ComboModel();
    }
    return work1ComboModel;
  }

  /**
   * リハビリ計画加算を取得します。
   * @return リハビリ計画加算
   */
  public ACIntegerCheckBox getRehabilitationPlan2(){
    if(rehabilitationPlan2==null){

      rehabilitationPlan2 = new ACIntegerCheckBox();

      rehabilitationPlan2.setText("リハビリ計画加算");

      rehabilitationPlan2.setBindPath("3010130");

      addRehabilitationPlan2();
    }
    return rehabilitationPlan2;

  }

  /**
   * 日常動作訓練指導加算を取得します。
   * @return 日常動作訓練指導加算
   */
  public ACIntegerCheckBox getNormalActionTraning(){
    if(normalActionTraning==null){

      normalActionTraning = new ACIntegerCheckBox();

      normalActionTraning.setText("日常動作訓練指導加算");

      normalActionTraning.setBindPath("3010131");

      addNormalActionTraning();
    }
    return normalActionTraning;

  }

  /**
   * リハビリ体制強化加算コンテナを取得します。
   * @return リハビリ体制強化加算コンテナ
   */
  public ACLabelContainer getRehabilitationSystem2Container(){
    if(rehabilitationSystem2Container==null){

      rehabilitationSystem2Container = new ACLabelContainer();

      addRehabilitationSystem2Container();
    }
    return rehabilitationSystem2Container;

  }

  /**
   * リハビリ体制強化加算を取得します。
   * @return リハビリ体制強化加算
   */
  public ACIntegerCheckBox getRehabilitationSystem2(){
    if(rehabilitationSystem2==null){

      rehabilitationSystem2 = new ACIntegerCheckBox();

      rehabilitationSystem2.setText("リハビリ体制強化加算");

      addRehabilitationSystem2();
    }
    return rehabilitationSystem2;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getRehabilitationSystem2Combo(){
    if(rehabilitationSystem2Combo==null){

      rehabilitationSystem2Combo = new ACComboBox();

      rehabilitationSystem2Combo.setBindPath("3010140");

      rehabilitationSystem2Combo.setEnabled(false);

      rehabilitationSystem2Combo.setEditable(false);

      rehabilitationSystem2Combo.setModelBindPath("109");

      rehabilitationSystem2Combo.setRenderBindPath("CONTENT");

      rehabilitationSystem2Combo.setModel(getRehabilitationSystem2ComboModel());

      rehabilitationSystem2Combo.setPreferredSize(new Dimension(50,10));

      addRehabilitationSystem2Combo();
    }
    return rehabilitationSystem2Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getRehabilitationSystem2ComboModel(){
    if(rehabilitationSystem2ComboModel==null){
      rehabilitationSystem2ComboModel = new ACComboBoxModelAdapter();
      addRehabilitationSystem2ComboModel();
    }
    return rehabilitationSystem2ComboModel;
  }

  /**
   * その他領域を取得します。
   * @return その他領域
   */
  public ACGroupBox getEtcFrame(){
    if(etcFrame==null){

      etcFrame = new ACGroupBox();

      etcFrame.setText("その他");

      etcFrame.setPreferredSize(new Dimension(1,110));

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
   * 言語聴覚療法Iコンテナを取得します。
   * @return 言語聴覚療法Iコンテナ
   */
  public ACLabelContainer getLanguageTherapy1Conteiner(){
    if(languageTherapy1Conteiner==null){

      languageTherapy1Conteiner = new ACLabelContainer();

      addLanguageTherapy1Conteiner();
    }
    return languageTherapy1Conteiner;

  }

  /**
   * 言語聴覚療法Iを取得します。
   * @return 言語聴覚療法I
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
   * 言語聴覚療法Iコンボを取得します。
   * @return 言語聴覚療法Iコンボ
   */
  public ACComboBox getLanguageTherapy1Combo(){
    if(languageTherapy1Combo==null){

      languageTherapy1Combo = new ACComboBox();

      languageTherapy1Combo.setBindPath("3010133");

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
   * 言語聴覚療法Iコンボモデルを取得します。
   * @return 言語聴覚療法Iコンボモデル
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
   * 言語聴覚(I)を取得します。
   * @return 言語聴覚(I)
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
   * 言語聴覚(I)コンボを取得します。
   * @return 言語聴覚(I)コンボ
   */
  public ACComboBox getLanguage1Combo(){
    if(language1Combo==null){

      language1Combo = new ACComboBox();

      language1Combo.setBindPath("3010135");

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
   * 言語聴覚(I)コンボモデルを取得します。
   * @return 言語聴覚(I)コンボモデル
   */
  protected ACComboBoxModelAdapter getLanguage1ComboModel(){
    if(language1ComboModel==null){
      language1ComboModel = new ACComboBoxModelAdapter();
      addLanguage1ComboModel();
    }
    return language1ComboModel;
  }

  /**
   * リハビリ体制強化加算コンテナを取得します。
   * @return リハビリ体制強化加算コンテナ
   */
  public ACLabelContainer getRehabilitationSystem3Container(){
    if(rehabilitationSystem3Container==null){

      rehabilitationSystem3Container = new ACLabelContainer();

      addRehabilitationSystem3Container();
    }
    return rehabilitationSystem3Container;

  }

  /**
   * リハビリ体制強化加算を取得します。
   * @return リハビリ体制強化加算
   */
  public ACIntegerCheckBox getRehabilitationSystem3(){
    if(rehabilitationSystem3==null){

      rehabilitationSystem3 = new ACIntegerCheckBox();

      rehabilitationSystem3.setText("リハビリ体制強化加算");

      addRehabilitationSystem3();
    }
    return rehabilitationSystem3;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getRehabilitationSystem3Combo(){
    if(rehabilitationSystem3Combo==null){

      rehabilitationSystem3Combo = new ACComboBox();

      rehabilitationSystem3Combo.setBindPath("3010141");

      rehabilitationSystem3Combo.setEnabled(false);

      rehabilitationSystem3Combo.setEditable(false);

      rehabilitationSystem3Combo.setModelBindPath("109");

      rehabilitationSystem3Combo.setRenderBindPath("CONTENT");

      rehabilitationSystem3Combo.setModel(getRehabilitationSystem3ComboModel());

      rehabilitationSystem3Combo.setPreferredSize(new Dimension(50,10));

      addRehabilitationSystem3Combo();
    }
    return rehabilitationSystem3Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getRehabilitationSystem3ComboModel(){
    if(rehabilitationSystem3ComboModel==null){
      rehabilitationSystem3ComboModel = new ACComboBoxModelAdapter();
      addRehabilitationSystem3ComboModel();
    }
    return rehabilitationSystem3ComboModel;
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
   * 短期集中リハビリ実施加算を取得します。
   * @return 短期集中リハビリ実施加算
   */
  public ACIntegerCheckBox getConcentratedRehabilitation(){
    if(concentratedRehabilitation==null){

      concentratedRehabilitation = new ACIntegerCheckBox();

      concentratedRehabilitation.setText("短期集中リハビリ実施加算");

      concentratedRehabilitation.setBindPath("3010143");

      addConcentratedRehabilitation();
    }
    return concentratedRehabilitation;

  }

  /**
   * 集団コミュニケーション療法を取得します。
   * @return 集団コミュニケーション療法
   */
  public ACIntegerCheckBox getGroupCommunication(){
    if(groupCommunication==null){

      groupCommunication = new ACIntegerCheckBox();

      groupCommunication.setText("集団コミュニケーション療法");

      groupCommunication.setBindPath("3010150");

      addGroupCommunication();
    }
    return groupCommunication;

  }

  /**
   * 認知症短期集中リハビリ加算を取得します。
   * @return 認知症短期集中リハビリ加算
   */
  public ACIntegerCheckBox getDementiaShortRehabilitation(){
    if(dementiaShortRehabilitation==null){

      dementiaShortRehabilitation = new ACIntegerCheckBox();

      dementiaShortRehabilitation.setText("認知症短期集中リハビリ加算");

      dementiaShortRehabilitation.setBindPath("3010151");

      addDementiaShortRehabilitation();
    }
    return dementiaShortRehabilitation;

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
   * 認知症老人入院精神療法を取得します。
   * @return 認知症老人入院精神療法
   */
  public ACIntegerCheckBox getCognitive(){
    if(cognitive==null){

      cognitive = new ACIntegerCheckBox();

      cognitive.setText("認知症老人入院精神療法");

      cognitive.setBindPath("3010138");

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
  public QS001199_H2104Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(800, 600);

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

    guidanceManagements.add(getBedGuidanceManagement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getBeginningGuidanceManagement(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getHeavyRecuperateGuidanceManagement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getParticularInstitutionManagment(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom2(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getHeavySkinManegement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getMedicineManegementLeading(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getSpecialMedicineManagementLeading(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getMedicalScienceInfo1(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getMedicalScienceInfo2(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 感染対策指導管理に内部項目を追加します。
   */
  protected void addInfectionGuidanceManagement(){

  }

  /**
   * 褥瘡対策指導管理に内部項目を追加します。
   */
  protected void addBedGuidanceManagement(){

  }

  /**
   * 初期入院診療管理に内部項目を追加します。
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
   * 医学情報提供(I)に内部項目を追加します。
   */
  protected void addMedicalScienceInfo1(){

  }

  /**
   * 医学情報提供(II)に内部項目を追加します。
   */
  protected void addMedicalScienceInfo2(){

  }

  /**
   * リハビリテーション領域に内部項目を追加します。
   */
  protected void addRehabilitation(){

    rehabilitation.add(getScienceTherapy(), VRLayout.NORTH);

    rehabilitation.add(getWorkTherapyFrame(), VRLayout.NORTH);

    rehabilitation.add(getEtcFrame(), VRLayout.NORTH);

    rehabilitation.add(getMindFrame(), VRLayout.NORTH);

  }

  /**
   * 理学療法領域に内部項目を追加します。
   */
  protected void addScienceTherapy(){

    scienceTherapy.add(getScienceTherapys(), VRLayout.NORTH);

  }

  /**
   * 理学療法領域に内部項目を追加します。
   */
  protected void addScienceTherapys(){

    scienceTherapys.add(getScienceTherapy1Container(), VRLayout.FLOW_INSETLINE);

    scienceTherapys.add(getScienceTherapy2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    scienceTherapys.add(getScience1Container(), VRLayout.FLOW_INSETLINE);

    scienceTherapys.add(getScience2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    scienceTherapys.add(getRehabilitationPlan(), VRLayout.FLOW_INSETLINE);

    scienceTherapys.add(getNormalAction(), VRLayout.FLOW_INSETLINE_RETURN);

    scienceTherapys.add(getRehabilitationSystem1Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 理学療法コンテナ1に内部項目を追加します。
   */
  protected void addScienceTherapy1Container(){

    scienceTherapy1Container.add(getScienceTherapy1(), null);

    scienceTherapy1Container.add(getScienceTherapy1Combo(), null);

  }

  /**
   * 理学療法(I)に内部項目を追加します。
   */
  protected void addScienceTherapy1(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addScienceTherapy1Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addScienceTherapy1ComboModel(){

  }

  /**
   * 理学療法コンテナ2に内部項目を追加します。
   */
  protected void addScienceTherapy2Container(){

    scienceTherapy2Container.add(getScienceTherapy2(), null);

    scienceTherapy2Container.add(getScienceTherapy2Combo(), null);

  }

  /**
   * 理学療法(II)に内部項目を追加します。
   */
  protected void addScienceTherapy2(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addScienceTherapy2Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addScienceTherapy2ComboModel(){

  }

  /**
   * 理学コンテナ1に内部項目を追加します。
   */
  protected void addScience1Container(){

    science1Container.add(getScienceLabel1(), null);

    science1Container.add(getScience1(), null);

    science1Container.add(getScience1Combo(), null);

  }

  /**
   * ラベルに内部項目を追加します。
   */
  protected void addScienceLabel1(){

  }

  /**
   * 理学(I)に内部項目を追加します。
   */
  protected void addScience1(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addScience1Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addScience1ComboModel(){

  }

  /**
   * 理学コンテナ2に内部項目を追加します。
   */
  protected void addScience2Container(){

    science2Container.add(getScience2(), null);

    science2Container.add(getScience2Combo(), null);

  }

  /**
   * 理学(II)に内部項目を追加します。
   */
  protected void addScience2(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addScience2Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addScience2ComboModel(){

  }

  /**
   * リハビリ計画加算に内部項目を追加します。
   */
  protected void addRehabilitationPlan(){

  }

  /**
   * 日常動作訓練指導加算に内部項目を追加します。
   */
  protected void addNormalAction(){

  }

  /**
   * リハビリ体制強化加算コンテナに内部項目を追加します。
   */
  protected void addRehabilitationSystem1Container(){

    rehabilitationSystem1Container.add(getRehabilitationSystem1(), null);

    rehabilitationSystem1Container.add(getRehabilitationSystem1Combo(), null);

  }

  /**
   * リハビリ体制強化加算に内部項目を追加します。
   */
  protected void addRehabilitationSystem1(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addRehabilitationSystem1Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addRehabilitationSystem1ComboModel(){

  }

  /**
   * 作業療法フレームに内部項目を追加します。
   */
  protected void addWorkTherapyFrame(){

    workTherapyFrame.add(getWorkTherapyFrames(), VRLayout.NORTH);

  }

  /**
   * 作業療法領域に内部項目を追加します。
   */
  protected void addWorkTherapyFrames(){

    workTherapyFrames.add(getWorkTherapy1Conteiner(), VRLayout.FLOW_INSETLINE);

    workTherapyFrames.add(getWork1Conteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    workTherapyFrames.add(getRehabilitationPlan2(), VRLayout.FLOW_INSETLINE);

    workTherapyFrames.add(getNormalActionTraning(), VRLayout.FLOW_INSETLINE_RETURN);

    workTherapyFrames.add(getRehabilitationSystem2Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 作業療法Iコンテナに内部項目を追加します。
   */
  protected void addWorkTherapy1Conteiner(){

    workTherapy1Conteiner.add(getWorkTherapy1(), null);

    workTherapy1Conteiner.add(getWorkTherapy1Combo(), null);

  }

  /**
   * 作業療法Iに内部項目を追加します。
   */
  protected void addWorkTherapy1(){

  }

  /**
   * 作業療法Iコンボに内部項目を追加します。
   */
  protected void addWorkTherapy1Combo(){

  }

  /**
   * 作業療法Iコンボモデルに内部項目を追加します。
   */
  protected void addWorkTherapy1ComboModel(){

  }

  /**
   * 作業Iコンテナに内部項目を追加します。
   */
  protected void addWork1Conteiner(){

    work1Conteiner.add(getReduce11Over(), null);

    work1Conteiner.add(getWork1(), null);

    work1Conteiner.add(getWork1Combo(), null);

  }

  /**
   * 11回目以降の減算に内部項目を追加します。
   */
  protected void addReduce11Over(){

  }

  /**
   * 作業(I)に内部項目を追加します。
   */
  protected void addWork1(){

  }

  /**
   * 作業(I)コンボに内部項目を追加します。
   */
  protected void addWork1Combo(){

  }

  /**
   * 作業(I)コンボモデルに内部項目を追加します。
   */
  protected void addWork1ComboModel(){

  }

  /**
   * リハビリ計画加算に内部項目を追加します。
   */
  protected void addRehabilitationPlan2(){

  }

  /**
   * 日常動作訓練指導加算に内部項目を追加します。
   */
  protected void addNormalActionTraning(){

  }

  /**
   * リハビリ体制強化加算コンテナに内部項目を追加します。
   */
  protected void addRehabilitationSystem2Container(){

    rehabilitationSystem2Container.add(getRehabilitationSystem2(), null);

    rehabilitationSystem2Container.add(getRehabilitationSystem2Combo(), null);

  }

  /**
   * リハビリ体制強化加算に内部項目を追加します。
   */
  protected void addRehabilitationSystem2(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addRehabilitationSystem2Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addRehabilitationSystem2ComboModel(){

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

    etcFrames.add(getRehabilitationSystem3Container(), VRLayout.FLOW_INSETLINE_RETURN);

    etcFrames.add(getDinner(), VRLayout.FLOW_INSETLINE);

    etcFrames.add(getConcentratedRehabilitation(), VRLayout.FLOW_INSETLINE_RETURN);

    etcFrames.add(getGroupCommunication(), VRLayout.FLOW_INSETLINE);

    etcFrames.add(getDementiaShortRehabilitation(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 言語聴覚療法Iコンテナに内部項目を追加します。
   */
  protected void addLanguageTherapy1Conteiner(){

    languageTherapy1Conteiner.add(getLanguageTherapy1(), null);

    languageTherapy1Conteiner.add(getLanguageTherapy1Combo(), null);

  }

  /**
   * 言語聴覚療法Iに内部項目を追加します。
   */
  protected void addLanguageTherapy1(){

  }

  /**
   * 言語聴覚療法Iコンボに内部項目を追加します。
   */
  protected void addLanguageTherapy1Combo(){

  }

  /**
   * 言語聴覚療法Iコンボモデルに内部項目を追加します。
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
   * 言語聴覚(I)に内部項目を追加します。
   */
  protected void addLanguage1(){

  }

  /**
   * 言語聴覚(I)コンボに内部項目を追加します。
   */
  protected void addLanguage1Combo(){

  }

  /**
   * 言語聴覚(I)コンボモデルに内部項目を追加します。
   */
  protected void addLanguage1ComboModel(){

  }

  /**
   * リハビリ体制強化加算コンテナに内部項目を追加します。
   */
  protected void addRehabilitationSystem3Container(){

    rehabilitationSystem3Container.add(getRehabilitationSystem3(), null);

    rehabilitationSystem3Container.add(getRehabilitationSystem3Combo(), null);

  }

  /**
   * リハビリ体制強化加算に内部項目を追加します。
   */
  protected void addRehabilitationSystem3(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addRehabilitationSystem3Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addRehabilitationSystem3ComboModel(){

  }

  /**
   * 摂食機能療法に内部項目を追加します。
   */
  protected void addDinner(){

  }

  /**
   * 短期集中リハビリ実施加算に内部項目を追加します。
   */
  protected void addConcentratedRehabilitation(){

  }

  /**
   * 集団コミュニケーション療法に内部項目を追加します。
   */
  protected void addGroupCommunication(){

  }

  /**
   * 認知症短期集中リハビリ加算に内部項目を追加します。
   */
  protected void addDementiaShortRehabilitation(){

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
   * 認知症老人入院精神療法に内部項目を追加します。
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
      new QS001199_H2104Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001199_H2104Design getThis() {
    return this;
  }
}
