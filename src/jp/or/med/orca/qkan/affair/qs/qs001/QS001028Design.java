
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
 * 作成日: 2006/03/06  日本コンピューター株式会社 小笠　貴志 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム 特定診療費画面 (QS001028)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * 特定診療費画面画面項目デザイン(QS001028) 
 */
public class QS001028Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel specificConsultationFeePattern;

  private ACGroupBox guidanceManagement;

  private ACPanel guidanceManagements;

  private GridBagLayout guidanceManagementLayout;

  private ACIntegerCheckBox infectionGuidanceManagement;

  private ACIntegerCheckBox bedGuidanceManagement;

  private ACIntegerCheckBox beginningGuidanceManagement;

  private ACIntegerCheckBox heavyRecuperateGuidanceManagement;

  private ACIntegerCheckBox particularInstitutionManagment;

  private ACIntegerCheckBox particularInstitutionManagmentPrivateRoom;

  private ACIntegerCheckBox particularInstitutionManagmentPrivateRoom2;

  private ACIntegerCheckBox heavySkinManegement;

  private ACIntegerCheckBox careNutritionDinnerLeading;

  private ACIntegerCheckBox medicineManegementLeading;

  private ACIntegerCheckBox specialMedicineManagementLeading;

  private ACIntegerCheckBox medicalScienceInfo1;

  private ACIntegerCheckBox medicalScienceInfo2;

  private ACGroupBox rehabilitation;

  private ACGroupBox scienceTherapy;

  private ACPanel scienceTherapys;

  private GridBagLayout scienceTherapyLayout;

  private ACLabelContainer scienceTherapy1Container;

  private ACIntegerCheckBox scienceTherapy1;

  private ACComboBox scienceTherapy1Combo;

  private ACComboBoxModelAdapter scienceTherapy1ComboModel;

  private ACLabelContainer scienceTherapy2Container;

  private ACIntegerCheckBox scienceTherapy2;

  private ACComboBox scienceTherapy2Combo;

  private ACComboBoxModelAdapter scienceTherapy2ComboModel;

  private ACLabelContainer scienceTherapy3Container;

  private ACIntegerCheckBox scienceTherapy3;

  private ACComboBox scienceTherapy3Combo;

  private ACComboBoxModelAdapter scienceTherapy3ComboModel;

  private ACLabelContainer scienceTherapy4Container;

  private ACIntegerCheckBox scienceTherapy4;

  private ACComboBox scienceTherapy4Combo;

  private ACComboBoxModelAdapter scienceTherapy4ComboModel;

  private ACLabelContainer science1Container;

  private ACLabel scienceLabel1;

  private ACIntegerCheckBox science1;

  private ACComboBox science1Combo;

  private ACComboBoxModelAdapter science1ComboModel;

  private ACLabelContainer science2Container;

  private ACIntegerCheckBox science2;

  private ACComboBox science2Combo;

  private ACComboBoxModelAdapter science2ComboModel;

  private ACLabelContainer science3Container;

  private ACIntegerCheckBox science3;

  private ACComboBox science3Combo;

  private ACComboBoxModelAdapter science3ComboModel;

  private ACLabelContainer science4Container;

  private ACIntegerCheckBox science4;

  private ACComboBox science4Combo;

  private ACComboBoxModelAdapter science4ComboModel;

  private ACLabelContainer normalLifeConteiner;

  private ACIntegerCheckBox normalLife;

  private ACComboBox normalLifeCombo;

  private ACComboBoxModelAdapter normalLifeComboModel;

  private ACPanel rehabilitationPlans;

  private ACIntegerCheckBox rehabilitationPlan;

  private ACPanel normalActions;

  private ACIntegerCheckBox normalAction;

  private ACGroupBox workTherapyFrame;

  private ACPanel workTherapyFrames;

  private GridBagLayout workTherapyFrameLayout;

  private ACLabelContainer workTherapy1Conteiner;

  private ACIntegerCheckBox workTherapy1;

  private ACComboBox workTherapy1Combo;

  private ACComboBoxModelAdapter workTherapy1ComboModel;

  private ACLabelContainer workTherapy2Conteiner;

  private ACIntegerCheckBox workTherapy2;

  private ACComboBox workTherapy2Combo;

  private ACComboBoxModelAdapter workTherapy2ComboModel;

  private ACLabelContainer work1Conteiner;

  private ACLabel reduce11Over;

  private ACIntegerCheckBox work1;

  private ACComboBox work1Combo;

  private ACComboBoxModelAdapter work1ComboModel;

  private ACLabelContainer work2Conteiner;

  private ACIntegerCheckBox work2;

  private ACComboBox work2Combo;

  private ACComboBoxModelAdapter work2ComboModel;

  private ACLabelContainer normalLife2Container;

  private ACIntegerCheckBox normalLife2;

  private ACComboBox normalLife2Combo;

  private ACComboBoxModelAdapter normalLife2ComboModel;

  private ACPanel rehabilitationPlan2s;

  private ACIntegerCheckBox rehabilitationPlan2;

  private ACPanel normalActionTranings;

  private ACIntegerCheckBox normalActionTraning;

  private ACGroupBox etcFrame;

  private ACPanel etcFrames;

  private GridBagLayout etcFrameLayout;

  private ACLabelContainer languageTherapy1Conteiner;

  private ACIntegerCheckBox languageTherapy1;

  private ACComboBox languageTherapy1Combo;

  private ACComboBoxModelAdapter languageTherapy1ComboModel;

  private ACLabelContainer languageTherapy2Conteiner;

  private ACIntegerCheckBox languageTherapy2;

  private ACComboBox languageTherapy2Combo;

  private ACComboBoxModelAdapter languageTherapy2ComboModel;

  private ACLabelContainer language1Conteiner;

  private ACLabel language1Reduce;

  private ACIntegerCheckBox language1;

  private ACComboBox language1Combo;

  private ACComboBoxModelAdapter language1ComboModel;

  private ACLabelContainer language2Conteiner;

  private ACIntegerCheckBox language2;

  private ACComboBox language2Combo;

  private ACComboBoxModelAdapter language2ComboModel;

  private ACPanel dinners;

  private ACIntegerCheckBox dinner;

  private ACGroupBox mindFrame;

  private ACPanel mindFrames;

  private GridBagLayout mindFrameLayout;

  private ACPanel mindTherapys;

  private ACIntegerCheckBox mindTherapy;

  private ACPanel cognitives;

  private ACIntegerCheckBox cognitive;

  private ACPanel buttons;

  private ACButton apply;

  private ACButton close;

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

      guidanceManagements.setLayout(getGuidanceManagementLayout());

      addGuidanceManagements();
    }
    return guidanceManagements;

  }

  /**
   * 指導管理等レイアウトを取得します。
   * @return 指導管理等レイアウト
   */
  public GridBagLayout getGuidanceManagementLayout(){
    if(guidanceManagementLayout==null){

      guidanceManagementLayout = new GridBagLayout();

      addGuidanceManagementLayout();
    }
    return guidanceManagementLayout;

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
   * 介護栄養食事指導を取得します。
   * @return 介護栄養食事指導
   */
  public ACIntegerCheckBox getCareNutritionDinnerLeading(){
    if(careNutritionDinnerLeading==null){

      careNutritionDinnerLeading = new ACIntegerCheckBox();

      careNutritionDinnerLeading.setText("介護栄養食事指導");

      careNutritionDinnerLeading.setBindPath("3010109");

      addCareNutritionDinnerLeading();
    }
    return careNutritionDinnerLeading;

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

      scienceTherapys.setLayout(getScienceTherapyLayout());

      addScienceTherapys();
    }
    return scienceTherapys;

  }

  /**
   * 理学療法領域レイアウトを取得します。
   * @return 理学療法領域レイアウト
   */
  public GridBagLayout getScienceTherapyLayout(){
    if(scienceTherapyLayout==null){

      scienceTherapyLayout = new GridBagLayout();

      addScienceTherapyLayout();
    }
    return scienceTherapyLayout;

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

      scienceTherapy1Combo.setBindPath("3010114");

      scienceTherapy1Combo.setEnabled(false);

      scienceTherapy1Combo.setEditable(false);

      scienceTherapy1Combo.setModelBindPath("109");

      scienceTherapy1Combo.setModel(getScienceTherapy1ComboModel());

      scienceTherapy1Combo.setRenderBindPath("CONTENT");

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

      scienceTherapy2Combo.setBindPath("3010115");

      scienceTherapy2Combo.setEnabled(false);

      scienceTherapy2Combo.setEditable(false);

      scienceTherapy2Combo.setModelBindPath("109");

      scienceTherapy2Combo.setModel(getScienceTherapy2ComboModel());

      scienceTherapy2Combo.setRenderBindPath("CONTENT");

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
   * 理学療法コンテナ3を取得します。
   * @return 理学療法コンテナ3
   */
  public ACLabelContainer getScienceTherapy3Container(){
    if(scienceTherapy3Container==null){

      scienceTherapy3Container = new ACLabelContainer();

      addScienceTherapy3Container();
    }
    return scienceTherapy3Container;

  }

  /**
   * 理学療法(III)を取得します。
   * @return 理学療法(III)
   */
  public ACIntegerCheckBox getScienceTherapy3(){
    if(scienceTherapy3==null){

      scienceTherapy3 = new ACIntegerCheckBox();

      scienceTherapy3.setText("理学療法(III)");

      addScienceTherapy3();
    }
    return scienceTherapy3;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getScienceTherapy3Combo(){
    if(scienceTherapy3Combo==null){

      scienceTherapy3Combo = new ACComboBox();

      scienceTherapy3Combo.setBindPath("3010116");

      scienceTherapy3Combo.setEnabled(false);

      scienceTherapy3Combo.setEditable(false);

      scienceTherapy3Combo.setModelBindPath("109");

      scienceTherapy3Combo.setModel(getScienceTherapy3ComboModel());

      scienceTherapy3Combo.setRenderBindPath("CONTENT");

      scienceTherapy3Combo.setPreferredSize(new Dimension(50,10));

      addScienceTherapy3Combo();
    }
    return scienceTherapy3Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getScienceTherapy3ComboModel(){
    if(scienceTherapy3ComboModel==null){
      scienceTherapy3ComboModel = new ACComboBoxModelAdapter();
      addScienceTherapy3ComboModel();
    }
    return scienceTherapy3ComboModel;
  }

  /**
   * 理学療法コンテナ4を取得します。
   * @return 理学療法コンテナ4
   */
  public ACLabelContainer getScienceTherapy4Container(){
    if(scienceTherapy4Container==null){

      scienceTherapy4Container = new ACLabelContainer();

      addScienceTherapy4Container();
    }
    return scienceTherapy4Container;

  }

  /**
   * 理学療法(IＶ)を取得します。
   * @return 理学療法(IＶ)
   */
  public ACIntegerCheckBox getScienceTherapy4(){
    if(scienceTherapy4==null){

      scienceTherapy4 = new ACIntegerCheckBox();

      scienceTherapy4.setText("理学療法(IＶ)");

      addScienceTherapy4();
    }
    return scienceTherapy4;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getScienceTherapy4Combo(){
    if(scienceTherapy4Combo==null){

      scienceTherapy4Combo = new ACComboBox();

      scienceTherapy4Combo.setBindPath("3010117");

      scienceTherapy4Combo.setEnabled(false);

      scienceTherapy4Combo.setEditable(false);

      scienceTherapy4Combo.setModelBindPath("109");

      scienceTherapy4Combo.setModel(getScienceTherapy4ComboModel());

      scienceTherapy4Combo.setRenderBindPath("CONTENT");

      scienceTherapy4Combo.setPreferredSize(new Dimension(50,10));

      addScienceTherapy4Combo();
    }
    return scienceTherapy4Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getScienceTherapy4ComboModel(){
    if(scienceTherapy4ComboModel==null){
      scienceTherapy4ComboModel = new ACComboBoxModelAdapter();
      addScienceTherapy4ComboModel();
    }
    return scienceTherapy4ComboModel;
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

      science1Combo.setBindPath("3010118");

      science1Combo.setEnabled(false);

      science1Combo.setEditable(false);

      science1Combo.setModelBindPath("109");

      science1Combo.setModel(getScience1ComboModel());

      science1Combo.setRenderBindPath("CONTENT");

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

      science2Combo.setBindPath("3010119");

      science2Combo.setEnabled(false);

      science2Combo.setEditable(false);

      science2Combo.setModelBindPath("109");

      science2Combo.setModel(getScience2ComboModel());

      science2Combo.setRenderBindPath("CONTENT");

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
   * 理学コンテナ3を取得します。
   * @return 理学コンテナ3
   */
  public ACLabelContainer getScience3Container(){
    if(science3Container==null){

      science3Container = new ACLabelContainer();

      addScience3Container();
    }
    return science3Container;

  }

  /**
   * 理学(III)を取得します。
   * @return 理学(III)
   */
  public ACIntegerCheckBox getScience3(){
    if(science3==null){

      science3 = new ACIntegerCheckBox();

      science3.setText("理学(III)");

      addScience3();
    }
    return science3;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getScience3Combo(){
    if(science3Combo==null){

      science3Combo = new ACComboBox();

      science3Combo.setBindPath("3010120");

      science3Combo.setEnabled(false);

      science3Combo.setEditable(false);

      science3Combo.setModelBindPath("109");

      science3Combo.setModel(getScience3ComboModel());

      science3Combo.setRenderBindPath("CONTENT");

      science3Combo.setPreferredSize(new Dimension(50,10));

      addScience3Combo();
    }
    return science3Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getScience3ComboModel(){
    if(science3ComboModel==null){
      science3ComboModel = new ACComboBoxModelAdapter();
      addScience3ComboModel();
    }
    return science3ComboModel;
  }

  /**
   * 理学コンテナ4を取得します。
   * @return 理学コンテナ4
   */
  public ACLabelContainer getScience4Container(){
    if(science4Container==null){

      science4Container = new ACLabelContainer();

      addScience4Container();
    }
    return science4Container;

  }

  /**
   * 理学(IＶ)を取得します。
   * @return 理学(IＶ)
   */
  public ACIntegerCheckBox getScience4(){
    if(science4==null){

      science4 = new ACIntegerCheckBox();

      science4.setText("理学(IＶ)");

      addScience4();
    }
    return science4;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getScience4Combo(){
    if(science4Combo==null){

      science4Combo = new ACComboBox();

      science4Combo.setBindPath("3010121");

      science4Combo.setEnabled(false);

      science4Combo.setEditable(false);

      science4Combo.setModelBindPath("109");

      science4Combo.setModel(getScience4ComboModel());

      science4Combo.setRenderBindPath("CONTENT");

      science4Combo.setPreferredSize(new Dimension(50,10));

      addScience4Combo();
    }
    return science4Combo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getScience4ComboModel(){
    if(science4ComboModel==null){
      science4ComboModel = new ACComboBoxModelAdapter();
      addScience4ComboModel();
    }
    return science4ComboModel;
  }

  /**
   * 日常生活訓練加算コンテナを取得します。
   * @return 日常生活訓練加算コンテナ
   */
  public ACLabelContainer getNormalLifeConteiner(){
    if(normalLifeConteiner==null){

      normalLifeConteiner = new ACLabelContainer();

      addNormalLifeConteiner();
    }
    return normalLifeConteiner;

  }

  /**
   * 日常生活活動訓練加算を取得します。
   * @return 日常生活活動訓練加算
   */
  public ACIntegerCheckBox getNormalLife(){
    if(normalLife==null){

      normalLife = new ACIntegerCheckBox();

      normalLife.setText("日常生活活動訓練加算");

      addNormalLife();
    }
    return normalLife;

  }

  /**
   * コンボを取得します。
   * @return コンボ
   */
  public ACComboBox getNormalLifeCombo(){
    if(normalLifeCombo==null){

      normalLifeCombo = new ACComboBox();

      normalLifeCombo.setBindPath("3010122");

      normalLifeCombo.setEnabled(false);

      normalLifeCombo.setEditable(false);

      normalLifeCombo.setModelBindPath("109");

      normalLifeCombo.setModel(getNormalLifeComboModel());

      normalLifeCombo.setRenderBindPath("CONTENT");

      normalLifeCombo.setPreferredSize(new Dimension(50,10));

      addNormalLifeCombo();
    }
    return normalLifeCombo;

  }

  /**
   * コンボモデルを取得します。
   * @return コンボモデル
   */
  protected ACComboBoxModelAdapter getNormalLifeComboModel(){
    if(normalLifeComboModel==null){
      normalLifeComboModel = new ACComboBoxModelAdapter();
      addNormalLifeComboModel();
    }
    return normalLifeComboModel;
  }

  /**
   * リハビリ計画加算領域を取得します。
   * @return リハビリ計画加算領域
   */
  public ACPanel getRehabilitationPlans(){
    if(rehabilitationPlans==null){

      rehabilitationPlans = new ACPanel();

      rehabilitationPlans.setHgap(14);

      addRehabilitationPlans();
    }
    return rehabilitationPlans;

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
   * 日常動作訓練指導加算領域を取得します。
   * @return 日常動作訓練指導加算領域
   */
  public ACPanel getNormalActions(){
    if(normalActions==null){

      normalActions = new ACPanel();

      normalActions.setHgap(14);

      addNormalActions();
    }
    return normalActions;

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
   * 作業療法フレームを取得します。
   * @return 作業療法フレーム
   */
  public ACGroupBox getWorkTherapyFrame(){
    if(workTherapyFrame==null){

      workTherapyFrame = new ACGroupBox();

      workTherapyFrame.setText("作業療法");

      workTherapyFrame.setAutoWrap(false);

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

      workTherapyFrames.setLayout(getWorkTherapyFrameLayout());

      workTherapyFrames.setAutoWrap(false);

      addWorkTherapyFrames();
    }
    return workTherapyFrames;

  }

  /**
   * 作業療法フレーム・レイアウトを取得します。
   * @return 作業療法フレーム・レイアウト
   */
  public GridBagLayout getWorkTherapyFrameLayout(){
    if(workTherapyFrameLayout==null){

      workTherapyFrameLayout = new GridBagLayout();

      addWorkTherapyFrameLayout();
    }
    return workTherapyFrameLayout;

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

      workTherapy1.setText("作業療法(I)");

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

      workTherapy1Combo.setBindPath("3010125");

      workTherapy1Combo.setEnabled(false);

      workTherapy1Combo.setEditable(false);

      workTherapy1Combo.setModelBindPath("109");

      workTherapy1Combo.setModel(getWorkTherapy1ComboModel());

      workTherapy1Combo.setRenderBindPath("CONTENT");

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
   * 作業療法IIコンテナを取得します。
   * @return 作業療法IIコンテナ
   */
  public ACLabelContainer getWorkTherapy2Conteiner(){
    if(workTherapy2Conteiner==null){

      workTherapy2Conteiner = new ACLabelContainer();

      addWorkTherapy2Conteiner();
    }
    return workTherapy2Conteiner;

  }

  /**
   * 作業療法IIを取得します。
   * @return 作業療法II
   */
  public ACIntegerCheckBox getWorkTherapy2(){
    if(workTherapy2==null){

      workTherapy2 = new ACIntegerCheckBox();

      workTherapy2.setText("作業療法(II)");

      addWorkTherapy2();
    }
    return workTherapy2;

  }

  /**
   * 作業療法II・コンボを取得します。
   * @return 作業療法II・コンボ
   */
  public ACComboBox getWorkTherapy2Combo(){
    if(workTherapy2Combo==null){

      workTherapy2Combo = new ACComboBox();

      workTherapy2Combo.setBindPath("3010126");

      workTherapy2Combo.setEnabled(false);

      workTherapy2Combo.setEditable(false);

      workTherapy2Combo.setModelBindPath("109");

      workTherapy2Combo.setModel(getWorkTherapy2ComboModel());

      workTherapy2Combo.setRenderBindPath("CONTENT");

      workTherapy2Combo.setPreferredSize(new Dimension(50,10));

      addWorkTherapy2Combo();
    }
    return workTherapy2Combo;

  }

  /**
   * 作業療法II・コンボモデルを取得します。
   * @return 作業療法II・コンボモデル
   */
  protected ACComboBoxModelAdapter getWorkTherapy2ComboModel(){
    if(workTherapy2ComboModel==null){
      workTherapy2ComboModel = new ACComboBoxModelAdapter();
      addWorkTherapy2ComboModel();
    }
    return workTherapy2ComboModel;
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

      work1.setText("作業(I)");

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

      work1Combo.setBindPath("3010127");

      work1Combo.setEnabled(false);

      work1Combo.setEditable(false);

      work1Combo.setModelBindPath("109");

      work1Combo.setModel(getWork1ComboModel());

      work1Combo.setRenderBindPath("CONTENT");

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
   * 作業IIコンテナを取得します。
   * @return 作業IIコンテナ
   */
  public ACLabelContainer getWork2Conteiner(){
    if(work2Conteiner==null){

      work2Conteiner = new ACLabelContainer();

      addWork2Conteiner();
    }
    return work2Conteiner;

  }

  /**
   * 作業(II)を取得します。
   * @return 作業(II)
   */
  public ACIntegerCheckBox getWork2(){
    if(work2==null){

      work2 = new ACIntegerCheckBox();

      work2.setText("作業(II)");

      addWork2();
    }
    return work2;

  }

  /**
   * 作業(II)コンボを取得します。
   * @return 作業(II)コンボ
   */
  public ACComboBox getWork2Combo(){
    if(work2Combo==null){

      work2Combo = new ACComboBox();

      work2Combo.setBindPath("3010128");

      work2Combo.setEnabled(false);

      work2Combo.setEditable(false);

      work2Combo.setModelBindPath("109");

      work2Combo.setModel(getWork2ComboModel());

      work2Combo.setRenderBindPath("CONTENT");

      work2Combo.setPreferredSize(new Dimension(50,10));

      addWork2Combo();
    }
    return work2Combo;

  }

  /**
   * 作業(II)コンボモデルを取得します。
   * @return 作業(II)コンボモデル
   */
  protected ACComboBoxModelAdapter getWork2ComboModel(){
    if(work2ComboModel==null){
      work2ComboModel = new ACComboBoxModelAdapter();
      addWork2ComboModel();
    }
    return work2ComboModel;
  }

  /**
   * 日常生活活動導加算コンテナを取得します。
   * @return 日常生活活動導加算コンテナ
   */
  public ACLabelContainer getNormalLife2Container(){
    if(normalLife2Container==null){

      normalLife2Container = new ACLabelContainer();

      addNormalLife2Container();
    }
    return normalLife2Container;

  }

  /**
   * 日常生活活動導加算を取得します。
   * @return 日常生活活動導加算
   */
  public ACIntegerCheckBox getNormalLife2(){
    if(normalLife2==null){

      normalLife2 = new ACIntegerCheckBox();

      normalLife2.setText("日常生活活動訓練加算");

      addNormalLife2();
    }
    return normalLife2;

  }

  /**
   * 日常生活活動導加算コンボを取得します。
   * @return 日常生活活動導加算コンボ
   */
  public ACComboBox getNormalLife2Combo(){
    if(normalLife2Combo==null){

      normalLife2Combo = new ACComboBox();

      normalLife2Combo.setBindPath("3010129");

      normalLife2Combo.setEnabled(false);

      normalLife2Combo.setEditable(false);

      normalLife2Combo.setModelBindPath("109");

      normalLife2Combo.setModel(getNormalLife2ComboModel());

      normalLife2Combo.setRenderBindPath("CONTENT");

      normalLife2Combo.setPreferredSize(new Dimension(50,10));

      addNormalLife2Combo();
    }
    return normalLife2Combo;

  }

  /**
   * 日常生活活動導加算コンボモデルを取得します。
   * @return 日常生活活動導加算コンボモデル
   */
  protected ACComboBoxModelAdapter getNormalLife2ComboModel(){
    if(normalLife2ComboModel==null){
      normalLife2ComboModel = new ACComboBoxModelAdapter();
      addNormalLife2ComboModel();
    }
    return normalLife2ComboModel;
  }

  /**
   * リハビリ計画加算領域を取得します。
   * @return リハビリ計画加算領域
   */
  public ACPanel getRehabilitationPlan2s(){
    if(rehabilitationPlan2s==null){

      rehabilitationPlan2s = new ACPanel();

      rehabilitationPlan2s.setHgap(14);

      addRehabilitationPlan2s();
    }
    return rehabilitationPlan2s;

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
   * 日常動作訓練指導加算領域を取得します。
   * @return 日常動作訓練指導加算領域
   */
  public ACPanel getNormalActionTranings(){
    if(normalActionTranings==null){

      normalActionTranings = new ACPanel();

      addNormalActionTranings();
    }
    return normalActionTranings;

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
   * その他領域を取得します。
   * @return その他領域
   */
  public ACGroupBox getEtcFrame(){
    if(etcFrame==null){

      etcFrame = new ACGroupBox();

      etcFrame.setText("その他");

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

      etcFrames.setLayout(getEtcFrameLayout());

      addEtcFrames();
    }
    return etcFrames;

  }

  /**
   * その他領域レイアウトを取得します。
   * @return その他領域レイアウト
   */
  public GridBagLayout getEtcFrameLayout(){
    if(etcFrameLayout==null){

      etcFrameLayout = new GridBagLayout();

      addEtcFrameLayout();
    }
    return etcFrameLayout;

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

      languageTherapy1.setText("言語聴覚療法(I)");

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

      languageTherapy1Combo.setBindPath("3010132");

      languageTherapy1Combo.setEnabled(false);

      languageTherapy1Combo.setEditable(false);

      languageTherapy1Combo.setModelBindPath("109");

      languageTherapy1Combo.setModel(getLanguageTherapy1ComboModel());

      languageTherapy1Combo.setRenderBindPath("CONTENT");

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
   * 言語聴覚療法IIコンテナを取得します。
   * @return 言語聴覚療法IIコンテナ
   */
  public ACLabelContainer getLanguageTherapy2Conteiner(){
    if(languageTherapy2Conteiner==null){

      languageTherapy2Conteiner = new ACLabelContainer();

      addLanguageTherapy2Conteiner();
    }
    return languageTherapy2Conteiner;

  }

  /**
   * 言語聴覚療法IIを取得します。
   * @return 言語聴覚療法II
   */
  public ACIntegerCheckBox getLanguageTherapy2(){
    if(languageTherapy2==null){

      languageTherapy2 = new ACIntegerCheckBox();

      languageTherapy2.setText("言語聴覚療法(II)");

      addLanguageTherapy2();
    }
    return languageTherapy2;

  }

  /**
   * 言語聴覚療法IIコンボを取得します。
   * @return 言語聴覚療法IIコンボ
   */
  public ACComboBox getLanguageTherapy2Combo(){
    if(languageTherapy2Combo==null){

      languageTherapy2Combo = new ACComboBox();

      languageTherapy2Combo.setBindPath("3010133");

      languageTherapy2Combo.setEnabled(false);

      languageTherapy2Combo.setEditable(false);

      languageTherapy2Combo.setModelBindPath("109");

      languageTherapy2Combo.setModel(getLanguageTherapy2ComboModel());

      languageTherapy2Combo.setRenderBindPath("CONTENT");

      languageTherapy2Combo.setPreferredSize(new Dimension(50,10));

      addLanguageTherapy2Combo();
    }
    return languageTherapy2Combo;

  }

  /**
   * 言語聴覚療法IIコンボモデルを取得します。
   * @return 言語聴覚療法IIコンボモデル
   */
  protected ACComboBoxModelAdapter getLanguageTherapy2ComboModel(){
    if(languageTherapy2ComboModel==null){
      languageTherapy2ComboModel = new ACComboBoxModelAdapter();
      addLanguageTherapy2ComboModel();
    }
    return languageTherapy2ComboModel;
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

      language1.setText("言語聴覚(I)");

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

      language1Combo.setBindPath("3010134");

      language1Combo.setEnabled(false);

      language1Combo.setEditable(false);

      language1Combo.setModelBindPath("109");

      language1Combo.setModel(getLanguage1ComboModel());

      language1Combo.setRenderBindPath("CONTENT");

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
   * 言語聴覚2コンテナを取得します。
   * @return 言語聴覚2コンテナ
   */
  public ACLabelContainer getLanguage2Conteiner(){
    if(language2Conteiner==null){

      language2Conteiner = new ACLabelContainer();

      addLanguage2Conteiner();
    }
    return language2Conteiner;

  }

  /**
   * 言語聴覚(II)を取得します。
   * @return 言語聴覚(II)
   */
  public ACIntegerCheckBox getLanguage2(){
    if(language2==null){

      language2 = new ACIntegerCheckBox();

      language2.setText("言語聴覚(II)");

      addLanguage2();
    }
    return language2;

  }

  /**
   * 言語聴覚(II)コンボを取得します。
   * @return 言語聴覚(II)コンボ
   */
  public ACComboBox getLanguage2Combo(){
    if(language2Combo==null){

      language2Combo = new ACComboBox();

      language2Combo.setBindPath("3010135");

      language2Combo.setEnabled(false);

      language2Combo.setEditable(false);

      language2Combo.setModelBindPath("109");

      language2Combo.setModel(getLanguage2ComboModel());

      language2Combo.setRenderBindPath("CONTENT");

      language2Combo.setPreferredSize(new Dimension(50,10));

      addLanguage2Combo();
    }
    return language2Combo;

  }

  /**
   * 言語聴覚(II)コンボモデルを取得します。
   * @return 言語聴覚(II)コンボモデル
   */
  protected ACComboBoxModelAdapter getLanguage2ComboModel(){
    if(language2ComboModel==null){
      language2ComboModel = new ACComboBoxModelAdapter();
      addLanguage2ComboModel();
    }
    return language2ComboModel;
  }

  /**
   * 摂食機能療法領域を取得します。
   * @return 摂食機能療法領域
   */
  public ACPanel getDinners(){
    if(dinners==null){

      dinners = new ACPanel();

      dinners.setHgap(14);

      addDinners();
    }
    return dinners;

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

      mindFrames.setLayout(getMindFrameLayout());

      addMindFrames();
    }
    return mindFrames;

  }

  /**
   * 精神科専門療法レイアウトを取得します。
   * @return 精神科専門療法レイアウト
   */
  public GridBagLayout getMindFrameLayout(){
    if(mindFrameLayout==null){

      mindFrameLayout = new GridBagLayout();

      addMindFrameLayout();
    }
    return mindFrameLayout;

  }

  /**
   * 精神科作業療法領域を取得します。
   * @return 精神科作業療法領域
   */
  public ACPanel getMindTherapys(){
    if(mindTherapys==null){

      mindTherapys = new ACPanel();

      addMindTherapys();
    }
    return mindTherapys;

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
   * 認知症老人入院精神療法領域を取得します。
   * @return 認知症老人入院精神療法領域
   */
  public ACPanel getCognitives(){
    if(cognitives==null){

      cognitives = new ACPanel();

      addCognitives();
    }
    return cognitives;

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

      apply.setText("設定(O)");

      apply.setMnemonic('O');

      apply.setIconPath(ACConstants.ICON_PATH_OK_16);

      addApply();
    }
    return apply;

  }

  /**
   * 閉じるを取得します。
   * @return 閉じる
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("閉じる(C)");

      close.setMnemonic('C');

      close.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addClose();
    }
    return close;

  }

  /**
   * コンストラクタです。
   */
  public QS001028Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(800, 500);

      // ウィンドウを中央に配置
      Point pos = ACFrame.getInstance().getLocationOnScreen();
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

    guidanceManagement.add(getGuidanceManagements(), VRLayout.FLOW);

  }

  /**
   * 指導管理等に内部項目を追加します。
   */
  protected void addGuidanceManagements(){

    guidanceManagements.add(getInfectionGuidanceManagement(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getBedGuidanceManagement(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getBeginningGuidanceManagement(), new GridBagConstraints(2, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getHeavyRecuperateGuidanceManagement(), new GridBagConstraints(3, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getParticularInstitutionManagment(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom2(), new GridBagConstraints(2, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getHeavySkinManegement(), new GridBagConstraints(0, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getCareNutritionDinnerLeading(), new GridBagConstraints(1, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getMedicineManegementLeading(), new GridBagConstraints(2, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getSpecialMedicineManagementLeading(), new GridBagConstraints(3, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getMedicalScienceInfo1(), new GridBagConstraints(0, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getMedicalScienceInfo2(), new GridBagConstraints(1, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

  }

  /**
   * 指導管理等レイアウトに内部項目を追加します。
   */
  protected void addGuidanceManagementLayout(){

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
   * 介護栄養食事指導に内部項目を追加します。
   */
  protected void addCareNutritionDinnerLeading(){

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

    scienceTherapy.add(getScienceTherapys(), VRLayout.FLOW);

  }

  /**
   * 理学療法領域に内部項目を追加します。
   */
  protected void addScienceTherapys(){

    scienceTherapys.add(getScienceTherapy1Container(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScienceTherapy2Container(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScienceTherapy3Container(), new GridBagConstraints(2, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScienceTherapy4Container(), new GridBagConstraints(3, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScience1Container(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScience2Container(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScience3Container(), new GridBagConstraints(2, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScience4Container(), new GridBagConstraints(3, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getNormalLifeConteiner(), new GridBagConstraints(0, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getRehabilitationPlans(), new GridBagConstraints(1, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0));

    scienceTherapys.add(getNormalActions(), new GridBagConstraints(2, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0));

  }

  /**
   * 理学療法領域レイアウトに内部項目を追加します。
   */
  protected void addScienceTherapyLayout(){

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
   * 理学療法コンテナ3に内部項目を追加します。
   */
  protected void addScienceTherapy3Container(){

    scienceTherapy3Container.add(getScienceTherapy3(), null);

    scienceTherapy3Container.add(getScienceTherapy3Combo(), null);

  }

  /**
   * 理学療法(III)に内部項目を追加します。
   */
  protected void addScienceTherapy3(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addScienceTherapy3Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addScienceTherapy3ComboModel(){

  }

  /**
   * 理学療法コンテナ4に内部項目を追加します。
   */
  protected void addScienceTherapy4Container(){

    scienceTherapy4Container.add(getScienceTherapy4(), null);

    scienceTherapy4Container.add(getScienceTherapy4Combo(), null);

  }

  /**
   * 理学療法(IＶ)に内部項目を追加します。
   */
  protected void addScienceTherapy4(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addScienceTherapy4Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addScienceTherapy4ComboModel(){

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
   * 理学コンテナ3に内部項目を追加します。
   */
  protected void addScience3Container(){

    science3Container.add(getScience3(), null);

    science3Container.add(getScience3Combo(), null);

  }

  /**
   * 理学(III)に内部項目を追加します。
   */
  protected void addScience3(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addScience3Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addScience3ComboModel(){

  }

  /**
   * 理学コンテナ4に内部項目を追加します。
   */
  protected void addScience4Container(){

    science4Container.add(getScience4(), null);

    science4Container.add(getScience4Combo(), null);

  }

  /**
   * 理学(IＶ)に内部項目を追加します。
   */
  protected void addScience4(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addScience4Combo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addScience4ComboModel(){

  }

  /**
   * 日常生活訓練加算コンテナに内部項目を追加します。
   */
  protected void addNormalLifeConteiner(){

    normalLifeConteiner.add(getNormalLife(), null);

    normalLifeConteiner.add(getNormalLifeCombo(), null);

  }

  /**
   * 日常生活活動訓練加算に内部項目を追加します。
   */
  protected void addNormalLife(){

  }

  /**
   * コンボに内部項目を追加します。
   */
  protected void addNormalLifeCombo(){

  }

  /**
   * コンボモデルに内部項目を追加します。
   */
  protected void addNormalLifeComboModel(){

  }

  /**
   * リハビリ計画加算領域に内部項目を追加します。
   */
  protected void addRehabilitationPlans(){

    rehabilitationPlans.add(getRehabilitationPlan(), VRLayout.FLOW);

  }

  /**
   * リハビリ計画加算に内部項目を追加します。
   */
  protected void addRehabilitationPlan(){

  }

  /**
   * 日常動作訓練指導加算領域に内部項目を追加します。
   */
  protected void addNormalActions(){

    normalActions.add(getNormalAction(), VRLayout.FLOW);

  }

  /**
   * 日常動作訓練指導加算に内部項目を追加します。
   */
  protected void addNormalAction(){

  }

  /**
   * 作業療法フレームに内部項目を追加します。
   */
  protected void addWorkTherapyFrame(){

    workTherapyFrame.add(getWorkTherapyFrames(), VRLayout.FLOW);

  }

  /**
   * 作業療法領域に内部項目を追加します。
   */
  protected void addWorkTherapyFrames(){

    workTherapyFrames.add(getWorkTherapy1Conteiner(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getWorkTherapy2Conteiner(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getWork1Conteiner(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getWork2Conteiner(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getNormalLife2Container(), new GridBagConstraints(0, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getRehabilitationPlan2s(), new GridBagConstraints(1, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getNormalActionTranings(), new GridBagConstraints(2, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

  }

  /**
   * 作業療法フレーム・レイアウトに内部項目を追加します。
   */
  protected void addWorkTherapyFrameLayout(){

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
   * 作業療法IIコンテナに内部項目を追加します。
   */
  protected void addWorkTherapy2Conteiner(){

    workTherapy2Conteiner.add(getWorkTherapy2(), null);

    workTherapy2Conteiner.add(getWorkTherapy2Combo(), null);

  }

  /**
   * 作業療法IIに内部項目を追加します。
   */
  protected void addWorkTherapy2(){

  }

  /**
   * 作業療法II・コンボに内部項目を追加します。
   */
  protected void addWorkTherapy2Combo(){

  }

  /**
   * 作業療法II・コンボモデルに内部項目を追加します。
   */
  protected void addWorkTherapy2ComboModel(){

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
   * 作業IIコンテナに内部項目を追加します。
   */
  protected void addWork2Conteiner(){

    work2Conteiner.add(getWork2(), null);

    work2Conteiner.add(getWork2Combo(), null);

  }

  /**
   * 作業(II)に内部項目を追加します。
   */
  protected void addWork2(){

  }

  /**
   * 作業(II)コンボに内部項目を追加します。
   */
  protected void addWork2Combo(){

  }

  /**
   * 作業(II)コンボモデルに内部項目を追加します。
   */
  protected void addWork2ComboModel(){

  }

  /**
   * 日常生活活動導加算コンテナに内部項目を追加します。
   */
  protected void addNormalLife2Container(){

    normalLife2Container.add(getNormalLife2(), null);

    normalLife2Container.add(getNormalLife2Combo(), null);

  }

  /**
   * 日常生活活動導加算に内部項目を追加します。
   */
  protected void addNormalLife2(){

  }

  /**
   * 日常生活活動導加算コンボに内部項目を追加します。
   */
  protected void addNormalLife2Combo(){

  }

  /**
   * 日常生活活動導加算コンボモデルに内部項目を追加します。
   */
  protected void addNormalLife2ComboModel(){

  }

  /**
   * リハビリ計画加算領域に内部項目を追加します。
   */
  protected void addRehabilitationPlan2s(){

    rehabilitationPlan2s.add(getRehabilitationPlan2(), VRLayout.FLOW);

  }

  /**
   * リハビリ計画加算に内部項目を追加します。
   */
  protected void addRehabilitationPlan2(){

  }

  /**
   * 日常動作訓練指導加算領域に内部項目を追加します。
   */
  protected void addNormalActionTranings(){

    normalActionTranings.add(getNormalActionTraning(), VRLayout.FLOW);

  }

  /**
   * 日常動作訓練指導加算に内部項目を追加します。
   */
  protected void addNormalActionTraning(){

  }

  /**
   * その他領域に内部項目を追加します。
   */
  protected void addEtcFrame(){

    etcFrame.add(getEtcFrames(), VRLayout.FLOW);

  }

  /**
   * その他領域に内部項目を追加します。
   */
  protected void addEtcFrames(){

    etcFrames.add(getLanguageTherapy1Conteiner(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    etcFrames.add(getLanguageTherapy2Conteiner(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    etcFrames.add(getLanguage1Conteiner(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    etcFrames.add(getLanguage2Conteiner(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    etcFrames.add(getDinners(), new GridBagConstraints(2, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

  }

  /**
   * その他領域レイアウトに内部項目を追加します。
   */
  protected void addEtcFrameLayout(){

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
   * 言語聴覚療法IIコンテナに内部項目を追加します。
   */
  protected void addLanguageTherapy2Conteiner(){

    languageTherapy2Conteiner.add(getLanguageTherapy2(), null);

    languageTherapy2Conteiner.add(getLanguageTherapy2Combo(), null);

  }

  /**
   * 言語聴覚療法IIに内部項目を追加します。
   */
  protected void addLanguageTherapy2(){

  }

  /**
   * 言語聴覚療法IIコンボに内部項目を追加します。
   */
  protected void addLanguageTherapy2Combo(){

  }

  /**
   * 言語聴覚療法IIコンボモデルに内部項目を追加します。
   */
  protected void addLanguageTherapy2ComboModel(){

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
   * 言語聴覚2コンテナに内部項目を追加します。
   */
  protected void addLanguage2Conteiner(){

    language2Conteiner.add(getLanguage2(), null);

    language2Conteiner.add(getLanguage2Combo(), null);

  }

  /**
   * 言語聴覚(II)に内部項目を追加します。
   */
  protected void addLanguage2(){

  }

  /**
   * 言語聴覚(II)コンボに内部項目を追加します。
   */
  protected void addLanguage2Combo(){

  }

  /**
   * 言語聴覚(II)コンボモデルに内部項目を追加します。
   */
  protected void addLanguage2ComboModel(){

  }

  /**
   * 摂食機能療法領域に内部項目を追加します。
   */
  protected void addDinners(){

    dinners.add(getDinner(), null);

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

    mindFrame.add(getMindFrames(), VRLayout.FLOW);

  }

  /**
   * 精神科専門療法領域に内部項目を追加します。
   */
  protected void addMindFrames(){

    mindFrames.add(getMindTherapys(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    mindFrames.add(getCognitives(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

  }

  /**
   * 精神科専門療法レイアウトに内部項目を追加します。
   */
  protected void addMindFrameLayout(){

  }

  /**
   * 精神科作業療法領域に内部項目を追加します。
   */
  protected void addMindTherapys(){

    mindTherapys.add(getMindTherapy(), VRLayout.FLOW);

  }

  /**
   * 精神科作業療法に内部項目を追加します。
   */
  protected void addMindTherapy(){

  }

  /**
   * 認知症老人入院精神療法領域に内部項目を追加します。
   */
  protected void addCognitives(){

    cognitives.add(getCognitive(), VRLayout.FLOW);

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

    buttons.add(getClose(), VRLayout.EAST);
    buttons.add(getApply(), VRLayout.EAST);
  }

  /**
   * 設定に内部項目を追加します。
   */
  protected void addApply(){

  }

  /**
   * 閉じるに内部項目を追加します。
   */
  protected void addClose(){

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
      new QS001028Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001028Design getThis() {
    return this;
  }
}
