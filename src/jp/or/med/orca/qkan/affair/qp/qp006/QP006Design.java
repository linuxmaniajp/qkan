
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
 * 作成日: 2006/04/13  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 実績確定・請求データ作成 (006)
 * プログラム 医療明細書詳細情報編集 (QP006)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp006;
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
 * 医療明細書詳細情報編集画面項目デザイン(QP006) 
 */
public class QP006Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton update;

  private ACPanel infos;

  private ACPanel contents;

  private ACPanel visitCareDetailedContentLeft;

  private VRLayout visitCareDetailedContentLeftLayout;

  private ACGroupBox visitCareDetailedBasicInfo;

  private VRLayout visitCareDetailedBasicInfoLayout;

  private ACPanel visitCareDetailedContentLeftUp;

  private ACLabelContainer visitCareDetailedDateContena;

  private ACTextField visitCareDetailedDateText;

  private ACLabel visitCareDetailedDateLabel1;

  private ACTextField visitCareDetailedPrefectureNo;

  private ACLabelContainer visitCareDetailedPrefectureNoContainer;

  private ACTextField visitCareDetailedStationCode;

  private ACLabelContainer visitCareDetailedStationCodeContainer;

  private VRLayout visitCareDetailedStationCodeLayout;

  private ACTextField visitCareDetailedTownsAndVillages;

  private ACLabelContainer visitCareDetailedTownsAndVillagesContainer;

  private ACTextField visitCareDetailedoldPerson;

  private ACLabelContainer visitCareDetailedoldPersonContainer;

  private ACTextField visitCareDetailedPublicExpense1;

  private ACLabelContainer visitCareDetailedPublicExpense1Container;

  private ACTextField visitCareDetailedPublicTake1;

  private ACLabelContainer visitCareDetailedPublicTake1Container;

  private ACTextField visitCareDetailedPublicExpense2;

  private ACLabelContainer visitCareDetailedPublicExpense2Container;

  private ACTextField visitCareDetailedPublicTake2;

  private ACLabelContainer visitCareDetailedPublicTake2Container;

  private ACPanel visitCareDetailedContentLeftCenter1;

  private ACTextField visitCareDetailedName;

  private ACLabelContainer visitCareDetailedNameContainer;

  private ACTextField visitCareDetailedSexContena;

  private ACLabelContainer visitCareDetailedSexContenaContainer;

  private ACTextField visitCareDetailedBirth;

  private ACLabelContainer visitCareDetailedBirthContainer;

  private ACComboBox visitCareDetailedOfficialReason;

  private ACLabelContainer visitCareDetailedOfficialReasonContainer;

  private ACComboBoxModelAdapter visitCareDetailedOfficialReasonModel;

  private ACGroupBox visitCareDetailedSpecialWrites;

  private VRLayout visitCareDetailedSpecialWritesLayout;

  private ACTextArea visitCareDetailedSpecialWrite;

  private ACLabelContainer visitCareDetailedSpecialWriteContainer;

  private ACPanel visitCareDetailedContentRight;

  private ACGroupBox visitCareDetailedInsuranceInfoFram;

  private VRLayout visitCareDetailedInsuranceInfoFramLayout;

  private ACTextField visitCareDetailedInsure1;

  private ACLabelContainer visitCareDetailedInsure1Container;

  private ACTextField visitCareDetailedInsure2;

  private ACLabelContainer visitCareDetailedInsure2Container;

  private ACTextField visitCareDetailedInsure3;

  private ACLabelContainer visitCareDetailedInsure3Container;

  private ACTextField visitCareDetailedInsure4;

  private ACLabelContainer visitCareDetailedInsure4Container;

  private ACTextField visitCareDetailedInsure5;

  private ACLabelContainer visitCareDetailedInsure5Container;

  private ACTextField visitCareDetailedInsurance;

  private ACLabelContainer visitCareDetailedInsuranceContainer;

  private ACLabelContainer visitCareDetailedRatioContents;

  private ACTextField visitCareDetailedRatio;

  private ACLabel visitCareDetailedRatioUnit;

  private ACTextField visitCareDetailedMarkAndNo;

  private ACLabelContainer visitCareDetailedMarkAndNoContainer;

  private ACGroupBox visitCareDetailedNurseCallStations;

  private VRLayout visitCareDetailedNurseCallStationsLayout;

  private ACTextArea visitCareDetailedNurseCallStation;

  private ACLabelContainer visitCareDetailedNurseCallStationContainer;

  private ACPanel visitCareDetailedInfosUnder;

  private JTabbedPane visitCareDetailedPoints1;

  private ACPanel visitCareDetailedPanel1;

  private ACGroupBox visitCareDetailedMindState;

  private VRLayout visitCareDetailedMindStateLayout;

  private ACTextArea visitCareDetailedMindStateText;

  private ACLabelContainer visitCareDetailedMindStateTextContainer;

  private ACGroupBox visitCareDetailedMainDisease;

  private VRLayout visitCareDetailedMainDiseaseLayout;

  private ACTextArea visitCareDetailedMainDiseaseText;

  private ACLabelContainer visitCareDetailedMainDiseaseTextContainer;

  private ACGroupBox visitCareDetailedInstructDate;

  private VRLayout visitCareDetailedInstructDateLayout;

  private ACLabelContainer visitCareDetailedInstructPeriods;

  private QkanDateTextField visitCareDetailedInstructDateText1;

  private ACLabel visitCareDetailedInstructDateLabel;

  private QkanDateTextField visitCareDetailedInstructDateText2;

  private ACLabelContainer visitCareDetailedSpecialInstruct;

  private QkanDateTextField visitCareDetailedSpecialInstructDateText1;

  private ACLabel visitCareDetailedSpecialInstructDateLabel;

  private QkanDateTextField visitCareDetailedSpecialInstructDateText2;

  private ACPanel visitCareDetailed10Panel1;

  private ACGroupBox visitCareDetailedStanderdGroup;

  private ACGroupBox visitCareDetailedStanderd;

  private VRLayout visitCareDetailedStanderdLayout;

  private ACLabel visitCareDetailed11Label1;

  private ACLabelContainer visitCareDetailed11Contena1;

  private ACTextField visitCareDetailedMoneyText1;

  private ACLabel visitCareDetailedMoneyLabel1;

  private ACTextField visitCareDetailedDayText1;

  private ACLabel visitCareDetailedDayLabel1;

  private ACTextField visitCareDetailedMoneyText2;

  private ACLabel visitCareDetailedMoneyLabel2;

  private ACTextField visitCareDetailedMoneyText3;

  private ACLabel visitCareDetailedMoneyLabel3;

  private ACTextField visitCareDetailedMoneyText4;

  private ACLabel visitCareDetailedMoneyLabel4;

  private ACLabelContainer visitCareDetailed11Contena2;

  private ACTextField visitCareDetailedMoneyText5;

  private ACLabel visitCareDetailedMoneyLabel5;

  private ACTextField visitCareDetailedDayText2;

  private ACLabel visitCareDetailedDayLabel2;

  private ACTextField visitCareDetailedMoneyText6;

  private ACLabel visitCareDetailedMoneyLabel6;

  private ACTextField visitCareDetailedMoneyText7;

  private ACLabel visitCareDetailedMoneyLabel7;

  private ACTextField visitCareDetailedMoneyText8;

  private ACLabel visitCareDetailedMoneyLabel8;

  private ACLabel visitCareDetailed12Label;

  private ACLabelContainer visitCareDetailed12Contena1;

  private ACTextField visitCareDetailedMoneyText9;

  private ACLabel visitCareDetailedMoneyLabel9;

  private ACTextField visitCareDetailedDayText3;

  private ACLabel visitCareDetailedDayLabel3;

  private ACTextField visitCareDetailedMoneyText10;

  private ACLabel visitCareDetailedMoneyLabel10;

  private ACTextField visitCareDetailedMoneyText11;

  private ACLabel visitCareDetailedMoneyLabel11;

  private ACTextField visitCareDetailedMoneyText12;

  private ACLabel visitCareDetailedMoneyLabel12;

  private ACLabelContainer visitCareDetailed12Contena2;

  private ACTextField visitCareDetailedMoneyText13;

  private ACLabel visitCareDetailedMoneyLabel13;

  private ACTextField visitCareDetailedDayText4;

  private ACLabel visitCareDetailedDayLabel4;

  private ACTextField visitCareDetailedMoneyText14;

  private ACLabel visitCareDetailedMoneyLabel14;

  private ACTextField visitCareDetailedMoneyText15;

  private ACLabel visitCareDetailedMoneyLabel15;

  private ACTextField visitCareDetailedMoneyText16;

  private ACLabel visitCareDetailedMoneyLabel16;

  private ACLabel visitCareDetailed13;

  private ACLabelContainer visitCareDetailed13Conatena;

  private ACTextField visitCareDetailedMoneyText17;

  private ACLabel visitCareDetailedMoneyLabel17;

  private ACTextField visitCareDetailedDayText5;

  private ACLabel visitCareDetailedDayLabel5;

  private ACTextField visitCareDetailedMoneyText18;

  private ACLabel visitCareDetailedMoneyLabel18;

  private ACTextField visitCareDetailedMoneyText19;

  private ACLabel visitCareDetailedMoneyLabel19;

  private ACTextField visitCareDetailedMoneyText20;

  private ACLabel visitCareDetailedMoneyLabel20;

  private ACLabelContainer visitCareDetailed13Conatena2;

  private ACTextField visitCareDetailedMoneyText51;

  private ACLabel visitCareDetailedMoneyLabel51;

  private ACTextField visitCareDetailedDayText8;

  private ACLabel visitCareDetailedDayLabel8;

  private ACTextField visitCareDetailedMoneyText52;

  private ACLabel visitCareDetailedMoneyLabel52;

  private ACTextField visitCareDetailedMoneyText53;

  private ACLabel visitCareDetailedMoneyLabel53;

  private ACTextField visitCareDetailedMoneyText54;

  private ACLabel visitCareDetailedMoneyLabel54;

  private ACLabel visitCareDetailed14;

  private ACLabelContainer visitCareDetailed14Conatena;

  private ACTextField visitCareDetailedMoneyText55;

  private ACLabel visitCareDetailedMoneyLabel55;

  private ACTextField visitCareDetailedDayText9;

  private ACLabel visitCareDetailedDayLabel9;

  private ACTextField visitCareDetailedMoneyText56;

  private ACLabel visitCareDetailedMoneyLabel56;

  private ACTextField visitCareDetailedMoneyText57;

  private ACLabel visitCareDetailedMoneyLabel57;

  private ACTextField visitCareDetailedMoneyText58;

  private ACLabel visitCareDetailedMoneyLabel58;

  private ACPanel visitCareDetailed10Panel2;

  private ACGroupBox visitCareDetailedStanderd2;

  private VRLayout visitCareDetailedStanderd2Layout;

  private ACLabel visitCareDetailed14Label;

  private VRLayout visitCareDetailed14LabelLayout;

  private ACLabelContainer visitCareDetailed14Contena;

  private ACTextField visitCareDetailedMoneyText21;

  private ACLabel visitCareDetailedMoneyLabel21;

  private ACTextField visitCareDetailedDayText6;

  private ACLabel visitCareDetailedDayLabel6;

  private ACTextField visitCareDetailedMoneyText22;

  private ACLabel visitCareDetailedMoneyLabel22;

  private ACTextField visitCareDetailedMoneyText23;

  private ACLabel visitCareDetailedMoneyLabel23;

  private ACTextField visitCareDetailedMoneyText24;

  private ACLabel visitCareDetailedMoneyLabel24;

  private ACLabel visitCareDetailed15label;

  private ACLabelContainer visitCareDetailed15Contena;

  private VRLayout visitCareDetailed15ContenaLayout;

  private ACTextField visitCareDetailedMoneyText25;

  private ACLabel visitCareDetailedMoneyLabel25;

  private ACTextField visitCareDetailedTimeText1;

  private ACLabel visitCareDetailedTimeLabel1;

  private ACTextField visitCareDetailedMoneyText26;

  private ACLabel visitCareDetailedMoneyLabel26;

  private ACTextField visitCareDetailedMoneyText27;

  private ACLabel visitCareDetailedMoneyLabel27;

  private ACTextField visitCareDetailedMoneyText28;

  private ACLabel visitCareDetailedMoneyLabel28;

  private ACPanel visitCareDetailed20Panel;

  private ACGroupBox visitCareDetailed20Frame;

  private VRLayout visitCareDetailed20FrameLayout;

  private ACLabel visitCareDetailed21label;

  private ACLabelContainer visitCareDetailed21Contena;

  private VRLayout visitCareDetailed21ContenaLayout;

  private ACTextField visitCareDetailedMoneyText29;

  private ACLabel visitCareDetailedMoneyLabel29;

  private ACTextField visitCareDetailedMoneyText29Insert;

  private ACLabel visitCareDetailedMoneyLabel29Insert;

  private ACTextField visitCareDetailedDayText7;

  private ACLabel visitCareDetailedDayLabel7;

  private ACTextField visitCareDetailedMoneyText30;

  private ACLabel visitCareDetailedMoneyLabel30;

  private ACTextField visitCareDetailedMoneyText31;

  private ACLabel visitCareDetailedMoneyLabel31;

  private ACTextField visitCareDetailedMoneyText32;

  private ACLabel visitCareDetailedMoneyLabel32;

  private ACLabel visitCareDetailed22Label;

  private ACLabelContainer visitCareDetailed23Conatena;

  private ACLabel visitCareDetailed23Label;

  private ACTextField visitCareDetailedMoneyText36;

  private ACLabel visitCareDetailedMoneyLabel36;

  private ACTextField visitCareDetailedMoneyText37;

  private ACLabel visitCareDetailedMoneyLabel37;

  private ACTextField visitCareDetailedMoneyText38;

  private ACLabel visitCareDetailedMoneyLabel38;

  private ACLabelContainer visitCareDetailed24Contena;

  private ACLabel visitCareDetailed24Label;

  private ACTextField visitCareDetailedMoneyText39;

  private ACLabel visitCareDetailedMoneyLabel39;

  private ACTextField visitCareDetailedMoneyText40;

  private ACLabel visitCareDetailedMoneyLabel40;

  private ACTextField visitCareDetailedMoneyText41;

  private ACLabel visitCareDetailedMoneyLabel41;

  private ACLabelContainer visitCareDetailed25Contena;

  private ACLabel visitCareDetailed25Label;

  private ACTextField visitCareDetailedMoneyText42;

  private ACLabel visitCareDetailedMoneyLabel42;

  private ACTextField visitCareDetailedMoneyText43;

  private ACLabel visitCareDetailedMoneyLabel43;

  private ACTextField visitCareDetailedMoneyText44;

  private ACLabel visitCareDetailedMoneyLabel44;

  private ACGroupBox visitCareDetailed30Frame;

  private VRLayout visitCareDetailed30FrameLayout;

  private ACTextField visitCareDetailedMoneyText45;

  private ACLabelContainer visitCareDetailedMoneyText45Container;

  private ACLabel visitCareDetailedMoneyLabel45;

  private ACTextField visitCareDetailedMoneyText46;

  private ACLabelContainer visitCareDetailedMoneyText46Container;

  private ACLabel visitCareDetailedMoneyLabel46;

  private ACTextField visitCareDetailedMoneyText47;

  private ACLabelContainer visitCareDetailedMoneyText47Container;

  private ACLabel visitCareDetailedMoneyLabel47;

  private ACGroupBox visitCareDetailed40Frame;

  private VRLayout visitCareDetailed40FrameLayout;

  private ACTextField visitCareDetailedMoneyText48;

  private ACLabelContainer visitCareDetailedMoneyText48Container;

  private ACLabel visitCareDetailedMoneyLabel48;

  private ACTextField visitCareDetailedMoneyText49;

  private ACLabelContainer visitCareDetailedMoneyText49Container;

  private ACLabel visitCareDetailedMoneyLabel49;

  private ACTextField visitCareDetailedMoneyText50;

  private ACLabelContainer visitCareDetailedMoneyText50Container;

  private ACLabel visitCareDetailedMoneyLabel50;

  private ACTextField visitCareDetailedMoneyText61;

  private ACLabelContainer visitCareDetailedMoneyText61Container;

  private ACLabel visitCareDetailedMoneyLabel61;

  private ACTextField visitCareDetailedMoneyText62;

  private ACLabelContainer visitCareDetailedMoneyText62Container;

  private ACLabel visitCareDetailedMoneyLabel62;

  private ACTextField visitCareDetailedMoneyText63;

  private ACLabelContainer visitCareDetailedMoneyText63Container;

  private ACLabel visitCareDetailedMoneyLabel63;

  private ACPanel visitCareDetailedPoints3Panel1;

  private VRLayout visitCareDetailedPoints3Panel1Layout;

  private ACPanel visitCareDetailedPoints3Homon;

  private QkanDateTextField visitStart;

  private ACLabelContainer visitStartContainer;

  private QkanDateTextField visitEnd;

  private ACLabelContainer visitEndContainer;

  private ACTimeTextField visitEndTime;

  private ACLabelContainer visitEndTimeContainer;

  private ACComboBox visitEndState;

  private ACLabelContainer visitEndStateContainer;

  private ACComboBoxModelAdapter visitEndStateModel;

  private ACTextField visitEndStateEtc;

  private ACLabelContainer visitEndStateEtcContainer;

  private VRLayout visitEndStateEtcLayout;

  private QkanDateTextField dieDate;

  private ACLabelContainer dieDateContainer;

  private ACTimeTextField dieTime;

  private ACLabelContainer dieTimeContainer;

  private ACTextField mainDoctorOrgan;

  private ACLabelContainer mainDoctorOrganContainer;

  private ACTextField mainDoctorName;

  private ACLabelContainer mainDoctorNameContainer;

  private ACGroupBox visitFrame;

  private VRLayout visitFrameLayout;

  private ACComboBox visitCombo1;

  private ACComboBoxModelAdapter visitCombo1Model;

  private ACListItem visitCombo1Item1;

  private ACListItem visitCombo1Item2;

  private ACListItem visitCombo1Item3;

  private ACListItem visitCombo1Item4;

  private ACListItem visitCombo1Item5;

  private ACComboBox visitCombo2;

  private ACComboBoxModelAdapter visitCombo2Model;

  private ACListItem visitCombo2Item1;

  private ACListItem visitCombo2Item2;

  private ACListItem visitCombo2Item3;

  private ACListItem visitCombo2Item4;

  private ACListItem visitCombo2Item5;

  private ACComboBox visitCombo3;

  private ACComboBoxModelAdapter visitCombo3Model;

  private ACListItem visitCombo3Item1;

  private ACListItem visitCombo3Item2;

  private ACListItem visitCombo3Item3;

  private ACListItem visitCombo3Item4;

  private ACListItem visitCombo3Item5;

  private ACComboBox visitCombo4;

  private ACComboBoxModelAdapter visitCombo4Model;

  private ACListItem visitCombo4item1;

  private ACListItem visitCombo4item2;

  private ACListItem visitCombo4item3;

  private ACListItem visitCombo4item4;

  private ACListItem visitCombo4item5;

  private ACComboBox visitCombo5;

  private ACComboBoxModelAdapter visitCombo5Model;

  private ACListItem visitCombo5Item1;

  private ACListItem visitCombo5Item2;

  private ACListItem visitCombo5Item3;

  private ACListItem visitCombo5Item4;

  private ACListItem visitCombo5Item5;

  private ACComboBox visitCombo6;

  private ACComboBoxModelAdapter visitCombo6Model;

  private ACListItem visitCombo6Item1;

  private ACListItem visitCombo6Item2;

  private ACListItem visitCombo6Item3;

  private ACListItem visitCombo6Item4;

  private ACListItem visitCombo6Item5;

  private ACComboBox visitCombo7;

  private ACComboBoxModelAdapter visitCombo7Model;

  private ACListItem visitCombo7Item1;

  private ACListItem visitCombo7Item2;

  private ACListItem visitCombo7Item3;

  private ACListItem visitCombo7Item4;

  private ACListItem visitCombo7Item5;

  private ACComboBox visitCombo8;

  private ACComboBoxModelAdapter visitCombo8Model;

  private ACListItem visitCombo8Item1;

  private ACListItem visitCombo8Item2;

  private ACListItem visitCombo8Item3;

  private ACListItem visitCombo8Item4;

  private ACListItem visitCombo8Item5;

  private ACComboBox visitCombo9;

  private ACComboBoxModelAdapter visitCombo9Model;

  private ACListItem visitCombo9Item1;

  private ACListItem visitCombo9Item2;

  private ACListItem visitCombo9Item3;

  private ACListItem visitCombo9Item4;

  private ACListItem visitCombo9Item5;

  private ACComboBox visitCombo10;

  private ACComboBoxModelAdapter visitCombo10Model;

  private ACListItem visitCombo10Item1;

  private ACListItem visitCombo10Item2;

  private ACListItem visitCombo10Item3;

  private ACListItem visitCombo10Item4;

  private ACListItem visitCombo10Item5;

  private ACComboBox visitCombo11;

  private ACComboBoxModelAdapter visitCombo11Model;

  private ACListItem visitCombo11Item1;

  private ACListItem visitCombo11Item2;

  private ACListItem visitCombo11Item3;

  private ACListItem visitCombo11Item4;

  private ACListItem visitCombo11Item5;

  private ACComboBox visitCombo12;

  private ACComboBoxModelAdapter visitCombo12Model;

  private ACListItem visitCombo12Item1;

  private ACListItem visitCombo12Item2;

  private ACListItem visitCombo12Item3;

  private ACListItem visitCombo12Item4;

  private ACListItem visitCombo12Item5;

  private ACComboBox visitCombo13;

  private ACComboBoxModelAdapter visitCombo13Model;

  private ACListItem visitCombo13Item1;

  private ACListItem visitCombo13Item2;

  private ACListItem visitCombo13Item3;

  private ACListItem visitCombo13Item4;

  private ACListItem visitCombo13Item5;

  private ACComboBox visitCombo14;

  private ACComboBoxModelAdapter visitCombo14Model;

  private ACListItem visitCombo14Item1;

  private ACListItem visitCombo14Item2;

  private ACListItem visitCombo14Item3;

  private ACListItem visitCombo14Item4;

  private ACListItem visitCombo14Item5;

  private ACComboBox visitCombo15;

  private ACComboBoxModelAdapter visitCombo15Model;

  private ACListItem visitCombo15Item1;

  private ACListItem visitCombo15Item2;

  private ACListItem visitCombo15Item3;

  private ACListItem visitCombo15Item4;

  private ACListItem visitCombo15Item5;

  private ACComboBox visitCombo16;

  private ACComboBoxModelAdapter visitCombo16Model;

  private ACListItem visitCombo16Item1;

  private ACListItem visitCombo16Item2;

  private ACListItem visitCombo16Item3;

  private ACListItem visitCombo16Item4;

  private ACListItem visitCombo16Item5;

  private ACComboBox visitCombo17;

  private ACComboBoxModelAdapter visitCombo17Model;

  private ACListItem visitCombo17Item1;

  private ACListItem visitCombo17Item2;

  private ACListItem visitCombo17Item3;

  private ACListItem visitCombo17Item4;

  private ACListItem visitCombo17Item5;

  private ACComboBox visitCombo18;

  private ACComboBoxModelAdapter visitCombo18Model;

  private ACListItem visitCombo18Item1;

  private ACListItem visitCombo18Item2;

  private ACListItem visitCombo18Item3;

  private ACListItem visitCombo18Item4;

  private ACListItem visitCombo18Item5;

  private ACComboBox visitCombo19;

  private ACComboBoxModelAdapter visitCombo19Model;

  private ACListItem visitCombo19Item1;

  private ACListItem visitCombo19Item2;

  private ACListItem visitCombo19Item3;

  private ACListItem visitCombo19Item4;

  private ACListItem visitCombo19Item5;

  private ACComboBox visitCombo20;

  private ACComboBoxModelAdapter visitCombo20Model;

  private ACListItem visitCombo20Item1;

  private ACListItem visitCombo20Item2;

  private ACListItem visitCombo20Item3;

  private ACListItem visitCombo20Item4;

  private ACListItem visitCombo20Item5;

  private ACComboBox visitCombo21;

  private ACComboBoxModelAdapter visitCombo21Model;

  private ACListItem visitCombo21Item1;

  private ACListItem visitCombo21Item2;

  private ACListItem visitCombo21Item3;

  private ACListItem visitCombo21Item4;

  private ACListItem visitCombo21Item5;

  private ACComboBox visitCombo22;

  private ACComboBoxModelAdapter visitCombo22Model;

  private ACListItem visitCombo22Item1;

  private ACListItem visitCombo22Item2;

  private ACListItem visitCombo22Item3;

  private ACListItem visitCombo22Item4;

  private ACListItem visitCombo22Item5;

  private ACComboBox visitCombo23;

  private ACComboBoxModelAdapter visitCombo23Model;

  private ACListItem visitCombo23Item1;

  private ACListItem visitCombo23Item2;

  private ACListItem visitCombo23Item3;

  private ACListItem visitCombo23Item4;

  private ACListItem visitCombo23Item5;

  private ACComboBox visitCombo24;

  private ACComboBoxModelAdapter visitCombo24Model;

  private ACListItem visitCombo24Item1;

  private ACListItem visitCombo24Item2;

  private ACListItem visitCombo24Item3;

  private ACListItem visitCombo24Item4;

  private ACListItem visitCombo24Item5;

  private ACComboBox visitCombo25;

  private ACComboBoxModelAdapter visitCombo25Model;

  private ACListItem visitCombo25Item1;

  private ACListItem visitCombo25Item2;

  private ACListItem visitCombo25Item3;

  private ACListItem visitCombo25Item4;

  private ACListItem visitCombo25Item5;

  private ACComboBox visitCombo26;

  private ACComboBoxModelAdapter visitCombo26Model;

  private ACListItem visitCombo26Item1;

  private ACListItem visitCombo26Item2;

  private ACListItem visitCombo26Item3;

  private ACListItem visitCombo26Item4;

  private ACListItem visitCombo26Item5;

  private ACComboBox visitCombo27;

  private ACComboBoxModelAdapter visitCombo27Model;

  private ACListItem visitCombo27Item1;

  private ACListItem visitCombo27Item2;

  private ACListItem visitCombo27Item3;

  private ACListItem visitCombo27Item4;

  private ACListItem visitCombo27Item5;

  private ACComboBox visitCombo28;

  private ACComboBoxModelAdapter visitCombo28Model;

  private ACListItem visitCombo28Item1;

  private ACListItem visitCombo28Item2;

  private ACListItem visitCombo28Item3;

  private ACListItem visitCombo28Item4;

  private ACListItem visitCombo28Item5;

  private ACComboBox visitCombo29;

  private ACComboBoxModelAdapter visitCombo29Model;

  private ACListItem visitCombo29Item1;

  private ACListItem visitCombo29Item2;

  private ACListItem visitCombo29Item3;

  private ACListItem visitCombo29Item4;

  private ACListItem visitCombo29Item5;

  private ACComboBox visitCombo30;

  private ACComboBoxModelAdapter visitCombo30Model;

  private ACListItem visitCombo30Item1;

  private ACListItem visitCombo30Item2;

  private ACListItem visitCombo30Item3;

  private ACListItem visitCombo30Item4;

  private ACListItem visitCombo30Item5;

  private ACComboBox visitCombo31;

  private ACComboBoxModelAdapter visitCombo31Model;

  private ACListItem visitCombo31Item1;

  private ACListItem visitCombo31Item2;

  private ACListItem visitCombo31Item3;

  private ACListItem visitCombo31Item4;

  private ACListItem visitCombo31Item5;

  private ACPanel visitCareDetailedPoints3Panel3;

  private ACGroupBox realityDate;

  private VRLayout realityDateLayout;

  private ACLabelContainer insuranceContena;

  private ACLabel insuranceLabel1;

  private ACTextField insuranceText1;

  private ACLabel insuranceLabel2;

  private ACLabelContainer publicExpenseContena;

  private ACLabel publicExpenseLabel1;

  private ACTextField publicExpenseText1;

  private ACLabel publicExpenseLabel2;

  private ACTextField publicExpenseText2;

  private ACLabelContainer publicExpense2Contena;

  private ACLabel publicExpense2Label1;

  private ACTextField publicExpense2Text1;

  private ACLabel publicExpense2ContenaLabel2;

  private ACTextField publicExpense2Text2;

  private ACPanel mainDoctorInfoDatePanel;

  private QkanDateTextField mainDoctorInfoDate;

  private ACLabelContainer mainDoctorInfoDateContainer;

  private ACGroupBox offerInfos;

  private VRLayout offerInfoLayout;

  private ACTextArea offerInfoText;

  private ACLabelContainer offerInfoTextContainer;

  private ACTextField infoOfferTownsAndVillagesName;

  private ACLabelContainer infoOfferTownsAndVillagesNameContainer;

  private ACGroupBox specialEtcs;

  private VRLayout specialEtcLayout;

  private ACTextArea specialEtcText;

  private ACLabelContainer specialEtcTextContainer;

  private ACPanel visitCareDetailedTotalInfos;

  private VRLayout visitCareDetailedTotalInfosLayout;

  private ACGroupBox visitCareDetailedTotalInfosFrame;

  private VRLayout visitCareDetailedTotalInfosFrameLayout;

  private ACGroupBox visitCareDetailedExpenseMoneyFrame;

  private VRLayout visitCareDetailedExpenseMoneyFrameLayout;

  private ACLabelContainer visitCareDetailedExpenseMoneyContena1;

  private ACTextField visitCareDetailedExpenseMoneyText1;

  private ACLabel visitCareDetailedExpenseMoneyLabel1;

  private ACLabelContainer visitCareDetailedExpenseMoneyContena2;

  private ACTextField visitCareDetailedExpenseMoneyText2;

  private ACLabel visitCareDetailedExpenseMoneyLabel2;

  private ACLabelContainer visitCareDetailedExpenseMoneyContena3;

  private ACTextField visitCareDetailedExpenseMoneyText3;

  private ACLabel visitCareDetailedExpenseMoneyLabel3;

  private ACGroupBox visitCareDetailedOneshareFrame;

  private VRLayout visitCareDetailedOneshareFrameLayout;

  private ACLabelContainer visitCareDetailedOneshareContena1;

  private ACTextField visitCareDetailedOneshareText;

  private ACLabel visitCareDetailedOneshareLabel;

  private ACLabelContainer visitCareDetailedOneshareContena2;

  private ACTextField visitCareDetailedOneshareTex2;

  private ACLabel visitCareDetailedOneshareLabe2;

  private ACLabelContainer visitCareDetailedOneshareContena3;

  private ACTextField visitCareDetailedOneshareTex3;

  private ACLabel visitCareDetailedOneshareLabe3;

  private ACGroupBox visitCareDetailedReductionGroup;

  private ACBackLabelContainer visitCareDetailedReductionContena;

  private ACTextField visitCareDetailedReduction;

  private ACLabelContainer visitCareDetailedReductionContainer;

  private ACClearableRadioButtonGroup visitCareDetailedReductionRadio;

  private ACLabelContainer visitCareDetailedReductionRadioContainer;

  private ACListModelAdapter visitCareDetailedReductionRadioModel;

  private VRLayout visitCareDetailedReductionRadioLayout;

  private ACRadioButtonItem visitCareDetailedReductionRadioItem1;

  private ACRadioButtonItem visitCareDetailedReductionRadioItem2;

  private ACClearableRadioButtonGroup visitCareDetailedStateRadio;

  private ACLabelContainer visitCareDetailedStateRadioContainer;

  private ACListModelAdapter visitCareDetailedStateRadioModel;

  private ACRadioButtonItem visitCareDetailedStateRadioItem1;

  private ACRadioButtonItem visitCareDetailedStateRadioItem2;

  private ACGroupBox visitCareDetailedTotalMoneyStanderdEtcFrame;

  private VRLayout visitCareDetailedTotalMoneyStanderdEtcFrameLayout;

  private ACTextArea visitCareDetailedTotalMoneyStanderdEtcText;

  private ACLabelContainer visitCareDetailedTotalMoneyStanderdEtcTextContainer;

  //getter

  /**
   * 業務ボタンバーを取得します。
   * @return 業務ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("医療明細書詳細編集画面");

      addButtons();
    }
    return buttons;

  }

  /**
   * 更新を取得します。
   * @return 更新
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("更新（S)");

      update.setToolTipText("現在の内容を更新します。");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

  /**
   * 情報領域を取得します。
   * @return 情報領域
   */
  public ACPanel getInfos(){
    if(infos==null){

      infos = new ACPanel();

      addInfos();
    }
    return infos;

  }

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * クライアント領域・左を取得します。
   * @return クライアント領域・左
   */
  public ACPanel getVisitCareDetailedContentLeft(){
    if(visitCareDetailedContentLeft==null){

      visitCareDetailedContentLeft = new ACPanel();

      visitCareDetailedContentLeft.setLayout(getVisitCareDetailedContentLeftLayout());

      addVisitCareDetailedContentLeft();
    }
    return visitCareDetailedContentLeft;

  }

  /**
   * クライアント領域・左・レイアウトを取得します。
   * @return クライアント領域・左・レイアウト
   */
  public VRLayout getVisitCareDetailedContentLeftLayout(){
    if(visitCareDetailedContentLeftLayout==null){

      visitCareDetailedContentLeftLayout = new VRLayout();

      visitCareDetailedContentLeftLayout.setHgap(0);

      addVisitCareDetailedContentLeftLayout();
    }
    return visitCareDetailedContentLeftLayout;

  }

  /**
   * 基本情報・グループを取得します。
   * @return 基本情報・グループ
   */
  public ACGroupBox getVisitCareDetailedBasicInfo(){
    if(visitCareDetailedBasicInfo==null){

      visitCareDetailedBasicInfo = new ACGroupBox();

      visitCareDetailedBasicInfo.setText("基本情報");

      visitCareDetailedBasicInfo.setLayout(getVisitCareDetailedBasicInfoLayout());

      addVisitCareDetailedBasicInfo();
    }
    return visitCareDetailedBasicInfo;

  }

  /**
   * 基本情報・グループ・レイアウトを取得します。
   * @return 基本情報・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedBasicInfoLayout(){
    if(visitCareDetailedBasicInfoLayout==null){

      visitCareDetailedBasicInfoLayout = new VRLayout();

      visitCareDetailedBasicInfoLayout.setAutoWrap(false);

      addVisitCareDetailedBasicInfoLayout();
    }
    return visitCareDetailedBasicInfoLayout;

  }

  /**
   * 基本情報領域・上を取得します。
   * @return 基本情報領域・上
   */
  public ACPanel getVisitCareDetailedContentLeftUp(){
    if(visitCareDetailedContentLeftUp==null){

      visitCareDetailedContentLeftUp = new ACPanel();

      visitCareDetailedContentLeftUp.setAutoWrap(false);

      addVisitCareDetailedContentLeftUp();
    }
    return visitCareDetailedContentLeftUp;

  }

  /**
   * 年月・コンテナを取得します。
   * @return 年月・コンテナ
   */
  public ACLabelContainer getVisitCareDetailedDateContena(){
    if(visitCareDetailedDateContena==null){

      visitCareDetailedDateContena = new ACLabelContainer();

      addVisitCareDetailedDateContena();
    }
    return visitCareDetailedDateContena;

  }

  /**
   * 年月・テキストを取得します。
   * @return 年月・テキスト
   */
  public ACTextField getVisitCareDetailedDateText(){
    if(visitCareDetailedDateText==null){

      visitCareDetailedDateText = new ACTextField();

      visitCareDetailedDateText.setBindPath("TARGET_DATE");

      visitCareDetailedDateText.setEditable(false);

      visitCareDetailedDateText.setColumns(8);

      visitCareDetailedDateText.setFormat(new ACBorderBlankDateFormat("gggee年MM月"));

      addVisitCareDetailedDateText();
    }
    return visitCareDetailedDateText;

  }

  /**
   * 分・ラベルを取得します。
   * @return 分・ラベル
   */
  public ACLabel getVisitCareDetailedDateLabel1(){
    if(visitCareDetailedDateLabel1==null){

      visitCareDetailedDateLabel1 = new ACLabel();

      visitCareDetailedDateLabel1.setText("分");

      addVisitCareDetailedDateLabel1();
    }
    return visitCareDetailedDateLabel1;

  }

  /**
   * 県番・テキストを取得します。
   * @return 県番・テキスト
   */
  public ACTextField getVisitCareDetailedPrefectureNo(){
    if(visitCareDetailedPrefectureNo==null){

      visitCareDetailedPrefectureNo = new ACTextField();

      getVisitCareDetailedPrefectureNoContainer().setText("県番");

      visitCareDetailedPrefectureNo.setBindPath("1301003");

      visitCareDetailedPrefectureNo.setColumns(6);

      visitCareDetailedPrefectureNo.setCharType(VRCharType.ONLY_ALNUM);

      visitCareDetailedPrefectureNo.setIMEMode(InputSubset.LATIN);

      visitCareDetailedPrefectureNo.setMaxLength(28);

      addVisitCareDetailedPrefectureNo();
    }
    return visitCareDetailedPrefectureNo;

  }

  /**
   * 県番・テキストコンテナを取得します。
   * @return 県番・テキストコンテナ
   */
  protected ACLabelContainer getVisitCareDetailedPrefectureNoContainer(){
    if(visitCareDetailedPrefectureNoContainer==null){
      visitCareDetailedPrefectureNoContainer = new ACLabelContainer();
      visitCareDetailedPrefectureNoContainer.setFollowChildEnabled(true);
      visitCareDetailedPrefectureNoContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedPrefectureNoContainer.add(getVisitCareDetailedPrefectureNo(), null);
    }
    return visitCareDetailedPrefectureNoContainer;
  }

  /**
   * ステーションコード・テキストを取得します。
   * @return ステーションコード・テキスト
   */
  public ACTextField getVisitCareDetailedStationCode(){
    if(visitCareDetailedStationCode==null){

      visitCareDetailedStationCode = new ACTextField();

      getVisitCareDetailedStationCodeContainer().setText("ステーションコード");

      visitCareDetailedStationCode.setBindPath("1301004");

      visitCareDetailedStationCode.setLayout(getVisitCareDetailedStationCodeLayout());

      visitCareDetailedStationCode.setColumns(8);

      visitCareDetailedStationCode.setCharType(VRCharType.ONLY_ALNUM);

      visitCareDetailedStationCode.setIMEMode(InputSubset.LATIN);

      visitCareDetailedStationCode.setMaxLength(50);

      addVisitCareDetailedStationCode();
    }
    return visitCareDetailedStationCode;

  }

  /**
   * ステーションコード・テキストコンテナを取得します。
   * @return ステーションコード・テキストコンテナ
   */
  protected ACLabelContainer getVisitCareDetailedStationCodeContainer(){
    if(visitCareDetailedStationCodeContainer==null){
      visitCareDetailedStationCodeContainer = new ACLabelContainer();
      visitCareDetailedStationCodeContainer.setFollowChildEnabled(true);
      visitCareDetailedStationCodeContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedStationCodeContainer.add(getVisitCareDetailedStationCode(), null);
    }
    return visitCareDetailedStationCodeContainer;
  }

  /**
   * ステーションコード・テキスト・レイアウトを取得します。
   * @return ステーションコード・テキスト・レイアウト
   */
  public VRLayout getVisitCareDetailedStationCodeLayout(){
    if(visitCareDetailedStationCodeLayout==null){

      visitCareDetailedStationCodeLayout = new VRLayout();

      visitCareDetailedStationCodeLayout.setAutoWrap(false);

      visitCareDetailedStationCodeLayout.setHgap(0);

      visitCareDetailedStationCodeLayout.setLabelMargin(0);

      visitCareDetailedStationCodeLayout.setVgap(0);

      visitCareDetailedStationCodeLayout.setHgrid(200);

      addVisitCareDetailedStationCodeLayout();
    }
    return visitCareDetailedStationCodeLayout;

  }

  /**
   * 市町村番号を取得します。
   * @return 市町村番号
   */
  public ACTextField getVisitCareDetailedTownsAndVillages(){
    if(visitCareDetailedTownsAndVillages==null){

      visitCareDetailedTownsAndVillages = new ACTextField();

      getVisitCareDetailedTownsAndVillagesContainer().setText("市町村番号");

      visitCareDetailedTownsAndVillages.setBindPath("1301005");

      visitCareDetailedTownsAndVillages.setColumns(9);

      visitCareDetailedTownsAndVillages.setCharType(VRCharType.ONLY_ALNUM);

      visitCareDetailedTownsAndVillages.setIMEMode(InputSubset.LATIN);

      visitCareDetailedTownsAndVillages.setMaxLength(50);

      addVisitCareDetailedTownsAndVillages();
    }
    return visitCareDetailedTownsAndVillages;

  }

  /**
   * 市町村番号コンテナを取得します。
   * @return 市町村番号コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedTownsAndVillagesContainer(){
    if(visitCareDetailedTownsAndVillagesContainer==null){
      visitCareDetailedTownsAndVillagesContainer = new ACLabelContainer();
      visitCareDetailedTownsAndVillagesContainer.setFollowChildEnabled(true);
      visitCareDetailedTownsAndVillagesContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedTownsAndVillagesContainer.add(getVisitCareDetailedTownsAndVillages(), null);
    }
    return visitCareDetailedTownsAndVillagesContainer;
  }

  /**
   * 老人受給者番号を取得します。
   * @return 老人受給者番号
   */
  public ACTextField getVisitCareDetailedoldPerson(){
    if(visitCareDetailedoldPerson==null){

      visitCareDetailedoldPerson = new ACTextField();

      getVisitCareDetailedoldPersonContainer().setText("老人受給者番号");

      visitCareDetailedoldPerson.setBindPath("1301006");

      visitCareDetailedoldPerson.setColumns(9);

      visitCareDetailedoldPerson.setCharType(VRCharType.ONLY_ALNUM);

      visitCareDetailedoldPerson.setIMEMode(InputSubset.LATIN);

      visitCareDetailedoldPerson.setMaxLength(50);

      addVisitCareDetailedoldPerson();
    }
    return visitCareDetailedoldPerson;

  }

  /**
   * 老人受給者番号コンテナを取得します。
   * @return 老人受給者番号コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedoldPersonContainer(){
    if(visitCareDetailedoldPersonContainer==null){
      visitCareDetailedoldPersonContainer = new ACLabelContainer();
      visitCareDetailedoldPersonContainer.setFollowChildEnabled(true);
      visitCareDetailedoldPersonContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedoldPersonContainer.add(getVisitCareDetailedoldPerson(), null);
    }
    return visitCareDetailedoldPersonContainer;
  }

  /**
   * 公費負担者番号①を取得します。
   * @return 公費負担者番号①
   */
  public ACTextField getVisitCareDetailedPublicExpense1(){
    if(visitCareDetailedPublicExpense1==null){

      visitCareDetailedPublicExpense1 = new ACTextField();

      getVisitCareDetailedPublicExpense1Container().setText("公費負担者番号１");

      visitCareDetailedPublicExpense1.setBindPath("1301007");

      visitCareDetailedPublicExpense1.setColumns(9);

      visitCareDetailedPublicExpense1.setCharType(VRCharType.ONLY_ALNUM);

      visitCareDetailedPublicExpense1.setIMEMode(InputSubset.LATIN);

      visitCareDetailedPublicExpense1.setMaxLength(8);

      addVisitCareDetailedPublicExpense1();
    }
    return visitCareDetailedPublicExpense1;

  }

  /**
   * 公費負担者番号①コンテナを取得します。
   * @return 公費負担者番号①コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedPublicExpense1Container(){
    if(visitCareDetailedPublicExpense1Container==null){
      visitCareDetailedPublicExpense1Container = new ACLabelContainer();
      visitCareDetailedPublicExpense1Container.setFollowChildEnabled(true);
      visitCareDetailedPublicExpense1Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedPublicExpense1Container.add(getVisitCareDetailedPublicExpense1(), null);
    }
    return visitCareDetailedPublicExpense1Container;
  }

  /**
   * 公費受給者番号①を取得します。
   * @return 公費受給者番号①
   */
  public ACTextField getVisitCareDetailedPublicTake1(){
    if(visitCareDetailedPublicTake1==null){

      visitCareDetailedPublicTake1 = new ACTextField();

      getVisitCareDetailedPublicTake1Container().setText("公費受給者番号１");

      visitCareDetailedPublicTake1.setBindPath("1301008");

      visitCareDetailedPublicTake1.setColumns(9);

      visitCareDetailedPublicTake1.setCharType(VRCharType.ONLY_ALNUM);

      visitCareDetailedPublicTake1.setIMEMode(InputSubset.LATIN);

      visitCareDetailedPublicTake1.setMaxLength(7);

      addVisitCareDetailedPublicTake1();
    }
    return visitCareDetailedPublicTake1;

  }

  /**
   * 公費受給者番号①コンテナを取得します。
   * @return 公費受給者番号①コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedPublicTake1Container(){
    if(visitCareDetailedPublicTake1Container==null){
      visitCareDetailedPublicTake1Container = new ACLabelContainer();
      visitCareDetailedPublicTake1Container.setFollowChildEnabled(true);
      visitCareDetailedPublicTake1Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedPublicTake1Container.add(getVisitCareDetailedPublicTake1(), null);
    }
    return visitCareDetailedPublicTake1Container;
  }

  /**
   * 公費負担者番号②を取得します。
   * @return 公費負担者番号②
   */
  public ACTextField getVisitCareDetailedPublicExpense2(){
    if(visitCareDetailedPublicExpense2==null){

      visitCareDetailedPublicExpense2 = new ACTextField();

      getVisitCareDetailedPublicExpense2Container().setText("公費負担者番号２");

      visitCareDetailedPublicExpense2.setBindPath("1301009");

      visitCareDetailedPublicExpense2.setColumns(9);

      visitCareDetailedPublicExpense2.setCharType(VRCharType.ONLY_ALNUM);

      visitCareDetailedPublicExpense2.setIMEMode(InputSubset.LATIN);

      visitCareDetailedPublicExpense2.setMaxLength(8);

      addVisitCareDetailedPublicExpense2();
    }
    return visitCareDetailedPublicExpense2;

  }

  /**
   * 公費負担者番号②コンテナを取得します。
   * @return 公費負担者番号②コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedPublicExpense2Container(){
    if(visitCareDetailedPublicExpense2Container==null){
      visitCareDetailedPublicExpense2Container = new ACLabelContainer();
      visitCareDetailedPublicExpense2Container.setFollowChildEnabled(true);
      visitCareDetailedPublicExpense2Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedPublicExpense2Container.add(getVisitCareDetailedPublicExpense2(), null);
    }
    return visitCareDetailedPublicExpense2Container;
  }

  /**
   * 公費受給者番号②を取得します。
   * @return 公費受給者番号②
   */
  public ACTextField getVisitCareDetailedPublicTake2(){
    if(visitCareDetailedPublicTake2==null){

      visitCareDetailedPublicTake2 = new ACTextField();

      getVisitCareDetailedPublicTake2Container().setText("公費受給者番号２");

      visitCareDetailedPublicTake2.setBindPath("1301010");

      visitCareDetailedPublicTake2.setColumns(9);

      visitCareDetailedPublicTake2.setCharType(VRCharType.ONLY_ALNUM);

      visitCareDetailedPublicTake2.setIMEMode(InputSubset.LATIN);

      visitCareDetailedPublicTake2.setMaxLength(7);

      addVisitCareDetailedPublicTake2();
    }
    return visitCareDetailedPublicTake2;

  }

  /**
   * 公費受給者番号②コンテナを取得します。
   * @return 公費受給者番号②コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedPublicTake2Container(){
    if(visitCareDetailedPublicTake2Container==null){
      visitCareDetailedPublicTake2Container = new ACLabelContainer();
      visitCareDetailedPublicTake2Container.setFollowChildEnabled(true);
      visitCareDetailedPublicTake2Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedPublicTake2Container.add(getVisitCareDetailedPublicTake2(), null);
    }
    return visitCareDetailedPublicTake2Container;
  }

  /**
   * 基本情報領域・左を取得します。
   * @return 基本情報領域・左
   */
  public ACPanel getVisitCareDetailedContentLeftCenter1(){
    if(visitCareDetailedContentLeftCenter1==null){

      visitCareDetailedContentLeftCenter1 = new ACPanel();

      addVisitCareDetailedContentLeftCenter1();
    }
    return visitCareDetailedContentLeftCenter1;

  }

  /**
   * 氏名を取得します。
   * @return 氏名
   */
  public ACTextField getVisitCareDetailedName(){
    if(visitCareDetailedName==null){

      visitCareDetailedName = new ACTextField();

      getVisitCareDetailedNameContainer().setText("氏名");

      visitCareDetailedName.setBindPath("1301019");

      visitCareDetailedName.setEditable(false);

      visitCareDetailedName.setColumns(13);

      visitCareDetailedName.setMaxLength(15);

      addVisitCareDetailedName();
    }
    return visitCareDetailedName;

  }

  /**
   * 氏名コンテナを取得します。
   * @return 氏名コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedNameContainer(){
    if(visitCareDetailedNameContainer==null){
      visitCareDetailedNameContainer = new ACLabelContainer();
      visitCareDetailedNameContainer.setFollowChildEnabled(true);
      visitCareDetailedNameContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedNameContainer.add(getVisitCareDetailedName(), null);
    }
    return visitCareDetailedNameContainer;
  }

  /**
   * 性別を取得します。
   * @return 性別
   */
  public ACTextField getVisitCareDetailedSexContena(){
    if(visitCareDetailedSexContena==null){

      visitCareDetailedSexContena = new ACTextField();

      getVisitCareDetailedSexContenaContainer().setText("性別");

      visitCareDetailedSexContena.setBindPath("SEX");

      visitCareDetailedSexContena.setEditable(false);

      visitCareDetailedSexContena.setColumns(1);

      visitCareDetailedSexContena.setMaxLength(2);

      addVisitCareDetailedSexContena();
    }
    return visitCareDetailedSexContena;

  }

  /**
   * 性別コンテナを取得します。
   * @return 性別コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedSexContenaContainer(){
    if(visitCareDetailedSexContenaContainer==null){
      visitCareDetailedSexContenaContainer = new ACLabelContainer();
      visitCareDetailedSexContenaContainer.setFollowChildEnabled(true);
      visitCareDetailedSexContenaContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedSexContenaContainer.add(getVisitCareDetailedSexContena(), null);
    }
    return visitCareDetailedSexContenaContainer;
  }

  /**
   * 生年月日を取得します。
   * @return 生年月日
   */
  public ACTextField getVisitCareDetailedBirth(){
    if(visitCareDetailedBirth==null){

      visitCareDetailedBirth = new ACTextField();

      getVisitCareDetailedBirthContainer().setText("生年月日");

      visitCareDetailedBirth.setBindPath("BIRTH_DAY");

      visitCareDetailedBirth.setEditable(false);

      visitCareDetailedBirth.setColumns(11);

      visitCareDetailedBirth.setMaxLength(15);

      addVisitCareDetailedBirth();
    }
    return visitCareDetailedBirth;

  }

  /**
   * 生年月日コンテナを取得します。
   * @return 生年月日コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedBirthContainer(){
    if(visitCareDetailedBirthContainer==null){
      visitCareDetailedBirthContainer = new ACLabelContainer();
      visitCareDetailedBirthContainer.setFollowChildEnabled(true);
      visitCareDetailedBirthContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedBirthContainer.add(getVisitCareDetailedBirth(), null);
    }
    return visitCareDetailedBirthContainer;
  }

  /**
   * 職務上の事由を取得します。
   * @return 職務上の事由
   */
  public ACComboBox getVisitCareDetailedOfficialReason(){
    if(visitCareDetailedOfficialReason==null){

      visitCareDetailedOfficialReason = new ACComboBox();

      getVisitCareDetailedOfficialReasonContainer().setText("職務上の事由");

      visitCareDetailedOfficialReason.setBindPath("1301022");

      visitCareDetailedOfficialReason.setEditable(false);

      visitCareDetailedOfficialReason.setModelBindPath("SHOKUMU_JIYU");

      visitCareDetailedOfficialReason.setRenderBindPath("CONTENT");

      visitCareDetailedOfficialReason.setBlankable(true);

      visitCareDetailedOfficialReason.setModel(getVisitCareDetailedOfficialReasonModel());

      addVisitCareDetailedOfficialReason();
    }
    return visitCareDetailedOfficialReason;

  }

  /**
   * 職務上の事由コンテナを取得します。
   * @return 職務上の事由コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedOfficialReasonContainer(){
    if(visitCareDetailedOfficialReasonContainer==null){
      visitCareDetailedOfficialReasonContainer = new ACLabelContainer();
      visitCareDetailedOfficialReasonContainer.setFollowChildEnabled(true);
      visitCareDetailedOfficialReasonContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedOfficialReasonContainer.add(getVisitCareDetailedOfficialReason(), null);
    }
    return visitCareDetailedOfficialReasonContainer;
  }

  /**
   * 職務上の事由モデルを取得します。
   * @return 職務上の事由モデル
   */
  protected ACComboBoxModelAdapter getVisitCareDetailedOfficialReasonModel(){
    if(visitCareDetailedOfficialReasonModel==null){
      visitCareDetailedOfficialReasonModel = new ACComboBoxModelAdapter();
      addVisitCareDetailedOfficialReasonModel();
    }
    return visitCareDetailedOfficialReasonModel;
  }

  /**
   * 特記・グループを取得します。
   * @return 特記・グループ
   */
  public ACGroupBox getVisitCareDetailedSpecialWrites(){
    if(visitCareDetailedSpecialWrites==null){

      visitCareDetailedSpecialWrites = new ACGroupBox();

      visitCareDetailedSpecialWrites.setText("特記");

      visitCareDetailedSpecialWrites.setLayout(getVisitCareDetailedSpecialWritesLayout());

      addVisitCareDetailedSpecialWrites();
    }
    return visitCareDetailedSpecialWrites;

  }

  /**
   * 特記・グループ・レイアウトを取得します。
   * @return 特記・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedSpecialWritesLayout(){
    if(visitCareDetailedSpecialWritesLayout==null){

      visitCareDetailedSpecialWritesLayout = new VRLayout();

      visitCareDetailedSpecialWritesLayout.setHgap(0);

      visitCareDetailedSpecialWritesLayout.setLabelMargin(0);

      visitCareDetailedSpecialWritesLayout.setVgap(0);

      addVisitCareDetailedSpecialWritesLayout();
    }
    return visitCareDetailedSpecialWritesLayout;

  }

  /**
   * 特記テキストを取得します。
   * @return 特記テキスト
   */
  public ACTextArea getVisitCareDetailedSpecialWrite(){
    if(visitCareDetailedSpecialWrite==null){

      visitCareDetailedSpecialWrite = new ACTextArea();

      visitCareDetailedSpecialWrite.setBindPath("1301023");

      visitCareDetailedSpecialWrite.setColumns(36);

      visitCareDetailedSpecialWrite.setRows(6);

      visitCareDetailedSpecialWrite.setMaxRows(5);

      visitCareDetailedSpecialWrite.setIMEMode(InputSubset.KANJI);

      visitCareDetailedSpecialWrite.setMaxLength(150);

      visitCareDetailedSpecialWrite.setLineWrap(true);

      addVisitCareDetailedSpecialWrite();
    }
    return visitCareDetailedSpecialWrite;

  }

  /**
   * 特記テキストコンテナを取得します。
   * @return 特記テキストコンテナ
   */
  protected ACLabelContainer getVisitCareDetailedSpecialWriteContainer(){
    if(visitCareDetailedSpecialWriteContainer==null){
      visitCareDetailedSpecialWriteContainer = new ACLabelContainer();
      visitCareDetailedSpecialWriteContainer.setFollowChildEnabled(true);
      visitCareDetailedSpecialWriteContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedSpecialWriteContainer.add(getVisitCareDetailedSpecialWrite(), null);
    }
    return visitCareDetailedSpecialWriteContainer;
  }

  /**
   * クライアント領域・右を取得します。
   * @return クライアント領域・右
   */
  public ACPanel getVisitCareDetailedContentRight(){
    if(visitCareDetailedContentRight==null){

      visitCareDetailedContentRight = new ACPanel();

      addVisitCareDetailedContentRight();
    }
    return visitCareDetailedContentRight;

  }

  /**
   * 保険情報・グループを取得します。
   * @return 保険情報・グループ
   */
  public ACGroupBox getVisitCareDetailedInsuranceInfoFram(){
    if(visitCareDetailedInsuranceInfoFram==null){

      visitCareDetailedInsuranceInfoFram = new ACGroupBox();

      visitCareDetailedInsuranceInfoFram.setText("保険情報");

      visitCareDetailedInsuranceInfoFram.setLayout(getVisitCareDetailedInsuranceInfoFramLayout());

      addVisitCareDetailedInsuranceInfoFram();
    }
    return visitCareDetailedInsuranceInfoFram;

  }

  /**
   * 保険情報・グループ・レイアウトを取得します。
   * @return 保険情報・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedInsuranceInfoFramLayout(){
    if(visitCareDetailedInsuranceInfoFramLayout==null){

      visitCareDetailedInsuranceInfoFramLayout = new VRLayout();

      visitCareDetailedInsuranceInfoFramLayout.setAutoWrap(false);

      visitCareDetailedInsuranceInfoFramLayout.setHgap(0);

      visitCareDetailedInsuranceInfoFramLayout.setLabelMargin(0);

      visitCareDetailedInsuranceInfoFramLayout.setVgap(0);

      addVisitCareDetailedInsuranceInfoFramLayout();
    }
    return visitCareDetailedInsuranceInfoFramLayout;

  }

  /**
   * 主保険を取得します。
   * @return 主保険
   */
  public ACTextField getVisitCareDetailedInsure1(){
    if(visitCareDetailedInsure1==null){

      visitCareDetailedInsure1 = new ACTextField();

      getVisitCareDetailedInsure1Container().setText("主保険");

      visitCareDetailedInsure1.setBindPath("INS_TYPE1");

      visitCareDetailedInsure1.setEditable(false);

      visitCareDetailedInsure1.setColumns(4);

      addVisitCareDetailedInsure1();
    }
    return visitCareDetailedInsure1;

  }

  /**
   * 主保険コンテナを取得します。
   * @return 主保険コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedInsure1Container(){
    if(visitCareDetailedInsure1Container==null){
      visitCareDetailedInsure1Container = new ACLabelContainer();
      visitCareDetailedInsure1Container.setFollowChildEnabled(true);
      visitCareDetailedInsure1Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedInsure1Container.add(getVisitCareDetailedInsure1(), null);
    }
    return visitCareDetailedInsure1Container;
  }

  /**
   * 老人/退職を取得します。
   * @return 老人/退職
   */
  public ACTextField getVisitCareDetailedInsure2(){
    if(visitCareDetailedInsure2==null){

      visitCareDetailedInsure2 = new ACTextField();

      getVisitCareDetailedInsure2Container().setText("老人/退職");

      visitCareDetailedInsure2.setBindPath("INS_TYPE2");

      visitCareDetailedInsure2.setEditable(false);

      visitCareDetailedInsure2.setColumns(4);

      addVisitCareDetailedInsure2();
    }
    return visitCareDetailedInsure2;

  }

  /**
   * 老人/退職コンテナを取得します。
   * @return 老人/退職コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedInsure2Container(){
    if(visitCareDetailedInsure2Container==null){
      visitCareDetailedInsure2Container = new ACLabelContainer();
      visitCareDetailedInsure2Container.setFollowChildEnabled(true);
      visitCareDetailedInsure2Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedInsure2Container.add(getVisitCareDetailedInsure2(), null);
    }
    return visitCareDetailedInsure2Container;
  }

  /**
   * 併用を取得します。
   * @return 併用
   */
  public ACTextField getVisitCareDetailedInsure3(){
    if(visitCareDetailedInsure3==null){

      visitCareDetailedInsure3 = new ACTextField();

      getVisitCareDetailedInsure3Container().setText("併用");

      visitCareDetailedInsure3.setBindPath("INS_TYPE3");

      visitCareDetailedInsure3.setEditable(false);

      visitCareDetailedInsure3.setColumns(4);

      addVisitCareDetailedInsure3();
    }
    return visitCareDetailedInsure3;

  }

  /**
   * 併用コンテナを取得します。
   * @return 併用コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedInsure3Container(){
    if(visitCareDetailedInsure3Container==null){
      visitCareDetailedInsure3Container = new ACLabelContainer();
      visitCareDetailedInsure3Container.setFollowChildEnabled(true);
      visitCareDetailedInsure3Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedInsure3Container.add(getVisitCareDetailedInsure3(), null);
    }
    return visitCareDetailedInsure3Container;
  }

  /**
   * 本人/家族を取得します。
   * @return 本人/家族
   */
  public ACTextField getVisitCareDetailedInsure4(){
    if(visitCareDetailedInsure4==null){

      visitCareDetailedInsure4 = new ACTextField();

      getVisitCareDetailedInsure4Container().setText("本人/家族");

      visitCareDetailedInsure4.setBindPath("INS_TYPE4");

      visitCareDetailedInsure4.setEditable(false);

      visitCareDetailedInsure4.setColumns(4);

      addVisitCareDetailedInsure4();
    }
    return visitCareDetailedInsure4;

  }

  /**
   * 本人/家族コンテナを取得します。
   * @return 本人/家族コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedInsure4Container(){
    if(visitCareDetailedInsure4Container==null){
      visitCareDetailedInsure4Container = new ACLabelContainer();
      visitCareDetailedInsure4Container.setFollowChildEnabled(true);
      visitCareDetailedInsure4Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedInsure4Container.add(getVisitCareDetailedInsure4(), null);
    }
    return visitCareDetailedInsure4Container;
  }

  /**
   * 高齢9/高齢8を取得します。
   * @return 高齢9/高齢8
   */
  public ACTextField getVisitCareDetailedInsure5(){
    if(visitCareDetailedInsure5==null){

      visitCareDetailedInsure5 = new ACTextField();

      getVisitCareDetailedInsure5Container().setText("高齢9/高齢8");

      visitCareDetailedInsure5.setBindPath("INS_TYPE5");

      visitCareDetailedInsure5.setEditable(false);

      visitCareDetailedInsure5.setColumns(4);

      addVisitCareDetailedInsure5();
    }
    return visitCareDetailedInsure5;

  }

  /**
   * 高齢9/高齢8コンテナを取得します。
   * @return 高齢9/高齢8コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedInsure5Container(){
    if(visitCareDetailedInsure5Container==null){
      visitCareDetailedInsure5Container = new ACLabelContainer();
      visitCareDetailedInsure5Container.setFollowChildEnabled(true);
      visitCareDetailedInsure5Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedInsure5Container.add(getVisitCareDetailedInsure5(), null);
    }
    return visitCareDetailedInsure5Container;
  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTextField getVisitCareDetailedInsurance(){
    if(visitCareDetailedInsurance==null){

      visitCareDetailedInsurance = new ACTextField();

      getVisitCareDetailedInsuranceContainer().setText("保険者番号");

      visitCareDetailedInsurance.setBindPath("1301016");

      visitCareDetailedInsurance.setEditable(false);

      visitCareDetailedInsurance.setColumns(8);

      visitCareDetailedInsurance.setCharType(VRCharType.ONLY_ALNUM);

      visitCareDetailedInsurance.setIMEMode(InputSubset.LATIN);

      visitCareDetailedInsurance.setMaxLength(50);

      addVisitCareDetailedInsurance();
    }
    return visitCareDetailedInsurance;

  }

  /**
   * 保険者番号コンテナを取得します。
   * @return 保険者番号コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedInsuranceContainer(){
    if(visitCareDetailedInsuranceContainer==null){
      visitCareDetailedInsuranceContainer = new ACLabelContainer();
      visitCareDetailedInsuranceContainer.setFollowChildEnabled(true);
      visitCareDetailedInsuranceContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedInsuranceContainer.add(getVisitCareDetailedInsurance(), null);
    }
    return visitCareDetailedInsuranceContainer;
  }

  /**
   * 給付割合コンテナを取得します。
   * @return 給付割合コンテナ
   */
  public ACLabelContainer getVisitCareDetailedRatioContents(){
    if(visitCareDetailedRatioContents==null){

      visitCareDetailedRatioContents = new ACLabelContainer();

      visitCareDetailedRatioContents.setText("給付割合");

      addVisitCareDetailedRatioContents();
    }
    return visitCareDetailedRatioContents;

  }

  /**
   * 給付割合を取得します。
   * @return 給付割合
   */
  public ACTextField getVisitCareDetailedRatio(){
    if(visitCareDetailedRatio==null){

      visitCareDetailedRatio = new ACTextField();

      visitCareDetailedRatio.setBindPath("BENEFIT_RATE");

      visitCareDetailedRatio.setEditable(false);

      visitCareDetailedRatio.setColumns(4);

      visitCareDetailedRatio.setHorizontalAlignment(SwingConstants.RIGHT);

      addVisitCareDetailedRatio();
    }
    return visitCareDetailedRatio;

  }

  /**
   * 給付割合単位を取得します。
   * @return 給付割合単位
   */
  public ACLabel getVisitCareDetailedRatioUnit(){
    if(visitCareDetailedRatioUnit==null){

      visitCareDetailedRatioUnit = new ACLabel();

      visitCareDetailedRatioUnit.setText("割");

      addVisitCareDetailedRatioUnit();
    }
    return visitCareDetailedRatioUnit;

  }

  /**
   * 記号・番号を取得します。
   * @return 記号・番号
   */
  public ACTextField getVisitCareDetailedMarkAndNo(){
    if(visitCareDetailedMarkAndNo==null){

      visitCareDetailedMarkAndNo = new ACTextField();

      getVisitCareDetailedMarkAndNoContainer().setText("記号・番号");

      visitCareDetailedMarkAndNo.setBindPath("1301018");

      visitCareDetailedMarkAndNo.setEditable(false);

      visitCareDetailedMarkAndNo.setColumns(27);

      visitCareDetailedMarkAndNo.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMarkAndNo.setMaxLength(50);

      addVisitCareDetailedMarkAndNo();
    }
    return visitCareDetailedMarkAndNo;

  }

  /**
   * 記号・番号コンテナを取得します。
   * @return 記号・番号コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMarkAndNoContainer(){
    if(visitCareDetailedMarkAndNoContainer==null){
      visitCareDetailedMarkAndNoContainer = new ACLabelContainer();
      visitCareDetailedMarkAndNoContainer.setFollowChildEnabled(true);
      visitCareDetailedMarkAndNoContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMarkAndNoContainer.add(getVisitCareDetailedMarkAndNo(), null);
    }
    return visitCareDetailedMarkAndNoContainer;
  }

  /**
   * 老人）訪問看護ステーション・グループを取得します。
   * @return 老人）訪問看護ステーション・グループ
   */
  public ACGroupBox getVisitCareDetailedNurseCallStations(){
    if(visitCareDetailedNurseCallStations==null){

      visitCareDetailedNurseCallStations = new ACGroupBox();

      visitCareDetailedNurseCallStations.setText("（老人）訪問看護ステーション");

      visitCareDetailedNurseCallStations.setLayout(getVisitCareDetailedNurseCallStationsLayout());

      addVisitCareDetailedNurseCallStations();
    }
    return visitCareDetailedNurseCallStations;

  }

  /**
   * 老人）訪問看護ステーション・レイアウトを取得します。
   * @return 老人）訪問看護ステーション・レイアウト
   */
  public VRLayout getVisitCareDetailedNurseCallStationsLayout(){
    if(visitCareDetailedNurseCallStationsLayout==null){

      visitCareDetailedNurseCallStationsLayout = new VRLayout();

      visitCareDetailedNurseCallStationsLayout.setAutoWrap(false);

      visitCareDetailedNurseCallStationsLayout.setHgap(0);

      visitCareDetailedNurseCallStationsLayout.setLabelMargin(0);

      visitCareDetailedNurseCallStationsLayout.setVgap(0);

      addVisitCareDetailedNurseCallStationsLayout();
    }
    return visitCareDetailedNurseCallStationsLayout;

  }

  /**
   * 老人）訪問看護ステーションを取得します。
   * @return 老人）訪問看護ステーション
   */
  public ACTextArea getVisitCareDetailedNurseCallStation(){
    if(visitCareDetailedNurseCallStation==null){

      visitCareDetailedNurseCallStation = new ACTextArea();

      visitCareDetailedNurseCallStation.setBindPath("1301024");

      visitCareDetailedNurseCallStation.setColumns(65);

      visitCareDetailedNurseCallStation.setRows(5);

      visitCareDetailedNurseCallStation.setMaxRows(9);

      visitCareDetailedNurseCallStation.setIMEMode(InputSubset.KANJI);

      visitCareDetailedNurseCallStation.setMaxLength(250);

      visitCareDetailedNurseCallStation.setLineWrap(true);

      addVisitCareDetailedNurseCallStation();
    }
    return visitCareDetailedNurseCallStation;

  }

  /**
   * 老人）訪問看護ステーションコンテナを取得します。
   * @return 老人）訪問看護ステーションコンテナ
   */
  protected ACLabelContainer getVisitCareDetailedNurseCallStationContainer(){
    if(visitCareDetailedNurseCallStationContainer==null){
      visitCareDetailedNurseCallStationContainer = new ACLabelContainer();
      visitCareDetailedNurseCallStationContainer.setFollowChildEnabled(true);
      visitCareDetailedNurseCallStationContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedNurseCallStationContainer.add(getVisitCareDetailedNurseCallStation(), null);
    }
    return visitCareDetailedNurseCallStationContainer;
  }

  /**
   * 情報領域を取得します。
   * @return 情報領域
   */
  public ACPanel getVisitCareDetailedInfosUnder(){
    if(visitCareDetailedInfosUnder==null){

      visitCareDetailedInfosUnder = new ACPanel();

      addVisitCareDetailedInfosUnder();
    }
    return visitCareDetailedInfosUnder;

  }

  /**
   * タブ領域を取得します。
   * @return タブ領域
   */
  public JTabbedPane getVisitCareDetailedPoints1(){
    if(visitCareDetailedPoints1==null){

      visitCareDetailedPoints1 = new JTabbedPane();

      addVisitCareDetailedPoints1();
    }
    return visitCareDetailedPoints1;

  }

  /**
   * パネル1を取得します。
   * @return パネル1
   */
  public ACPanel getVisitCareDetailedPanel1(){
    if(visitCareDetailedPanel1==null){

      visitCareDetailedPanel1 = new ACPanel();

      addVisitCareDetailedPanel1();
    }
    return visitCareDetailedPanel1;

  }

  /**
   * 心身の状態・グループを取得します。
   * @return 心身の状態・グループ
   */
  public ACGroupBox getVisitCareDetailedMindState(){
    if(visitCareDetailedMindState==null){

      visitCareDetailedMindState = new ACGroupBox();

      visitCareDetailedMindState.setText("心身の状態");

      visitCareDetailedMindState.setLayout(getVisitCareDetailedMindStateLayout());

      addVisitCareDetailedMindState();
    }
    return visitCareDetailedMindState;

  }

  /**
   * 心身の状態・グループ・レイアウトを取得します。
   * @return 心身の状態・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedMindStateLayout(){
    if(visitCareDetailedMindStateLayout==null){

      visitCareDetailedMindStateLayout = new VRLayout();

      visitCareDetailedMindStateLayout.setAutoWrap(false);

      visitCareDetailedMindStateLayout.setHgap(0);

      visitCareDetailedMindStateLayout.setLabelMargin(0);

      visitCareDetailedMindStateLayout.setVgap(0);

      addVisitCareDetailedMindStateLayout();
    }
    return visitCareDetailedMindStateLayout;

  }

  /**
   * 心身の状態・テキストエリアを取得します。
   * @return 心身の状態・テキストエリア
   */
  public ACTextArea getVisitCareDetailedMindStateText(){
    if(visitCareDetailedMindStateText==null){

      visitCareDetailedMindStateText = new ACTextArea();

      visitCareDetailedMindStateText.setBindPath("1301027");

      visitCareDetailedMindStateText.setColumns(80);

      visitCareDetailedMindStateText.setRows(5);

      visitCareDetailedMindStateText.setMaxRows(8);

      visitCareDetailedMindStateText.setIMEMode(InputSubset.KANJI);

      visitCareDetailedMindStateText.setMaxLength(255);

      visitCareDetailedMindStateText.setLineWrap(true);

      addVisitCareDetailedMindStateText();
    }
    return visitCareDetailedMindStateText;

  }

  /**
   * 心身の状態・テキストエリアコンテナを取得します。
   * @return 心身の状態・テキストエリアコンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMindStateTextContainer(){
    if(visitCareDetailedMindStateTextContainer==null){
      visitCareDetailedMindStateTextContainer = new ACLabelContainer();
      visitCareDetailedMindStateTextContainer.setFollowChildEnabled(true);
      visitCareDetailedMindStateTextContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMindStateTextContainer.add(getVisitCareDetailedMindStateText(), VRLayout.CLIENT);
    }
    return visitCareDetailedMindStateTextContainer;
  }

  /**
   * 主たる傷病名・グループを取得します。
   * @return 主たる傷病名・グループ
   */
  public ACGroupBox getVisitCareDetailedMainDisease(){
    if(visitCareDetailedMainDisease==null){

      visitCareDetailedMainDisease = new ACGroupBox();

      visitCareDetailedMainDisease.setText("主たる傷病名");

      visitCareDetailedMainDisease.setLayout(getVisitCareDetailedMainDiseaseLayout());

      addVisitCareDetailedMainDisease();
    }
    return visitCareDetailedMainDisease;

  }

  /**
   * 主たる傷病名・グループ・レイアウトを取得します。
   * @return 主たる傷病名・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedMainDiseaseLayout(){
    if(visitCareDetailedMainDiseaseLayout==null){

      visitCareDetailedMainDiseaseLayout = new VRLayout();

      visitCareDetailedMainDiseaseLayout.setAutoWrap(false);

      visitCareDetailedMainDiseaseLayout.setHgap(0);

      visitCareDetailedMainDiseaseLayout.setLabelMargin(0);

      visitCareDetailedMainDiseaseLayout.setVgap(0);

      addVisitCareDetailedMainDiseaseLayout();
    }
    return visitCareDetailedMainDiseaseLayout;

  }

  /**
   * 主たる傷病名・テキストエリアを取得します。
   * @return 主たる傷病名・テキストエリア
   */
  public ACTextArea getVisitCareDetailedMainDiseaseText(){
    if(visitCareDetailedMainDiseaseText==null){

      visitCareDetailedMainDiseaseText = new ACTextArea();

      visitCareDetailedMainDiseaseText.setBindPath("1301028");

      visitCareDetailedMainDiseaseText.setColumns(80);

      visitCareDetailedMainDiseaseText.setRows(5);

      visitCareDetailedMainDiseaseText.setMaxRows(8);

      visitCareDetailedMainDiseaseText.setIMEMode(InputSubset.KANJI);

      visitCareDetailedMainDiseaseText.setMaxLength(255);

      visitCareDetailedMainDiseaseText.setLineWrap(true);

      addVisitCareDetailedMainDiseaseText();
    }
    return visitCareDetailedMainDiseaseText;

  }

  /**
   * 主たる傷病名・テキストエリアコンテナを取得します。
   * @return 主たる傷病名・テキストエリアコンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMainDiseaseTextContainer(){
    if(visitCareDetailedMainDiseaseTextContainer==null){
      visitCareDetailedMainDiseaseTextContainer = new ACLabelContainer();
      visitCareDetailedMainDiseaseTextContainer.setFollowChildEnabled(true);
      visitCareDetailedMainDiseaseTextContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMainDiseaseTextContainer.add(getVisitCareDetailedMainDiseaseText(), VRLayout.CLIENT);
    }
    return visitCareDetailedMainDiseaseTextContainer;
  }

  /**
   * 指示年月日・グループを取得します。
   * @return 指示年月日・グループ
   */
  public ACGroupBox getVisitCareDetailedInstructDate(){
    if(visitCareDetailedInstructDate==null){

      visitCareDetailedInstructDate = new ACGroupBox();

      visitCareDetailedInstructDate.setText("指示年月日");

      visitCareDetailedInstructDate.setLayout(getVisitCareDetailedInstructDateLayout());

      addVisitCareDetailedInstructDate();
    }
    return visitCareDetailedInstructDate;

  }

  /**
   * 指示年月日・グループ・レイアウトを取得します。
   * @return 指示年月日・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedInstructDateLayout(){
    if(visitCareDetailedInstructDateLayout==null){

      visitCareDetailedInstructDateLayout = new VRLayout();

      visitCareDetailedInstructDateLayout.setAutoWrap(false);

      visitCareDetailedInstructDateLayout.setHgap(0);

      visitCareDetailedInstructDateLayout.setLabelMargin(0);

      visitCareDetailedInstructDateLayout.setVgap(0);

      addVisitCareDetailedInstructDateLayout();
    }
    return visitCareDetailedInstructDateLayout;

  }

  /**
   * 指示期間・コンテナを取得します。
   * @return 指示期間・コンテナ
   */
  public ACLabelContainer getVisitCareDetailedInstructPeriods(){
    if(visitCareDetailedInstructPeriods==null){

      visitCareDetailedInstructPeriods = new ACLabelContainer();

      visitCareDetailedInstructPeriods.setText("指示期間");

      addVisitCareDetailedInstructPeriods();
    }
    return visitCareDetailedInstructPeriods;

  }

  /**
   * 日付テキスト1を取得します。
   * @return 日付テキスト1
   */
  public QkanDateTextField getVisitCareDetailedInstructDateText1(){
    if(visitCareDetailedInstructDateText1==null){

      visitCareDetailedInstructDateText1 = new QkanDateTextField();

      visitCareDetailedInstructDateText1.setBindPath("1301029");

      addVisitCareDetailedInstructDateText1();
    }
    return visitCareDetailedInstructDateText1;

  }

  /**
   * 日付ラベル1を取得します。
   * @return 日付ラベル1
   */
  public ACLabel getVisitCareDetailedInstructDateLabel(){
    if(visitCareDetailedInstructDateLabel==null){

      visitCareDetailedInstructDateLabel = new ACLabel();

      visitCareDetailedInstructDateLabel.setText("から");

      addVisitCareDetailedInstructDateLabel();
    }
    return visitCareDetailedInstructDateLabel;

  }

  /**
   * 日付テキスト2を取得します。
   * @return 日付テキスト2
   */
  public QkanDateTextField getVisitCareDetailedInstructDateText2(){
    if(visitCareDetailedInstructDateText2==null){

      visitCareDetailedInstructDateText2 = new QkanDateTextField();

      visitCareDetailedInstructDateText2.setBindPath("1301030");

      addVisitCareDetailedInstructDateText2();
    }
    return visitCareDetailedInstructDateText2;

  }

  /**
   * 特別指示）・コンテナを取得します。
   * @return 特別指示）・コンテナ
   */
  public ACLabelContainer getVisitCareDetailedSpecialInstruct(){
    if(visitCareDetailedSpecialInstruct==null){

      visitCareDetailedSpecialInstruct = new ACLabelContainer();

      visitCareDetailedSpecialInstruct.setText("（特別指示）");

      addVisitCareDetailedSpecialInstruct();
    }
    return visitCareDetailedSpecialInstruct;

  }

  /**
   * 日付テキスト特別1を取得します。
   * @return 日付テキスト特別1
   */
  public QkanDateTextField getVisitCareDetailedSpecialInstructDateText1(){
    if(visitCareDetailedSpecialInstructDateText1==null){

      visitCareDetailedSpecialInstructDateText1 = new QkanDateTextField();

      visitCareDetailedSpecialInstructDateText1.setBindPath("1301031");

      addVisitCareDetailedSpecialInstructDateText1();
    }
    return visitCareDetailedSpecialInstructDateText1;

  }

  /**
   * 日付ラベル特別1を取得します。
   * @return 日付ラベル特別1
   */
  public ACLabel getVisitCareDetailedSpecialInstructDateLabel(){
    if(visitCareDetailedSpecialInstructDateLabel==null){

      visitCareDetailedSpecialInstructDateLabel = new ACLabel();

      visitCareDetailedSpecialInstructDateLabel.setText("から");

      addVisitCareDetailedSpecialInstructDateLabel();
    }
    return visitCareDetailedSpecialInstructDateLabel;

  }

  /**
   * 日付テキスト特別2を取得します。
   * @return 日付テキスト特別2
   */
  public QkanDateTextField getVisitCareDetailedSpecialInstructDateText2(){
    if(visitCareDetailedSpecialInstructDateText2==null){

      visitCareDetailedSpecialInstructDateText2 = new QkanDateTextField();

      visitCareDetailedSpecialInstructDateText2.setBindPath("1301032");

      addVisitCareDetailedSpecialInstructDateText2();
    }
    return visitCareDetailedSpecialInstructDateText2;

  }

  /**
   * （１０）基本療養費パネル１を取得します。
   * @return （１０）基本療養費パネル１
   */
  public ACPanel getVisitCareDetailed10Panel1(){
    if(visitCareDetailed10Panel1==null){

      visitCareDetailed10Panel1 = new ACPanel();

      addVisitCareDetailed10Panel1();
    }
    return visitCareDetailed10Panel1;

  }

  /**
   * 基本療養費・グループを取得します。
   * @return 基本療養費・グループ
   */
  public ACGroupBox getVisitCareDetailedStanderdGroup(){
    if(visitCareDetailedStanderdGroup==null){

      visitCareDetailedStanderdGroup = new ACGroupBox();

      visitCareDetailedStanderdGroup.setText("基本療養費");

      addVisitCareDetailedStanderdGroup();
    }
    return visitCareDetailedStanderdGroup;

  }

  /**
   * 基本療養費（Ⅱ）・グループを取得します。
   * @return 基本療養費（Ⅱ）・グループ
   */
  public ACGroupBox getVisitCareDetailedStanderd(){
    if(visitCareDetailedStanderd==null){

      visitCareDetailedStanderd = new ACGroupBox();

      visitCareDetailedStanderd.setText("基本療養費（Ｉ）");

      visitCareDetailedStanderd.setLayout(getVisitCareDetailedStanderdLayout());

      addVisitCareDetailedStanderd();
    }
    return visitCareDetailedStanderd;

  }

  /**
   * 基本療養費・グループ・レイアウトを取得します。
   * @return 基本療養費・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedStanderdLayout(){
    if(visitCareDetailedStanderdLayout==null){

      visitCareDetailedStanderdLayout = new VRLayout();

      visitCareDetailedStanderdLayout.setAutoWrap(false);

      visitCareDetailedStanderdLayout.setHgap(4);

      visitCareDetailedStanderdLayout.setLabelMargin(1);

      visitCareDetailedStanderdLayout.setVgap(4);

      addVisitCareDetailedStanderdLayout();
    }
    return visitCareDetailedStanderdLayout;

  }

  /**
   * １１）保健師、助産師、看護師、理学療法士、作業療法士、言語聴覚士を取得します。
   * @return １１）保健師、助産師、看護師、理学療法士、作業療法士、言語聴覚士
   */
  public ACLabel getVisitCareDetailed11Label1(){
    if(visitCareDetailed11Label1==null){

      visitCareDetailed11Label1 = new ACLabel();

      visitCareDetailed11Label1.setText("（11）保健師、助産師、看護師、理学療法士、作業療法士、言語聴覚士");

      addVisitCareDetailed11Label1();
    }
    return visitCareDetailed11Label1;

  }

  /**
   * １１コンテナ１を取得します。
   * @return １１コンテナ１
   */
  public ACLabelContainer getVisitCareDetailed11Contena1(){
    if(visitCareDetailed11Contena1==null){

      visitCareDetailed11Contena1 = new ACLabelContainer();

      addVisitCareDetailed11Contena1();
    }
    return visitCareDetailed11Contena1;

  }

  /**
   * 金額テキスト1を取得します。
   * @return 金額テキスト1
   */
  public ACTextField getVisitCareDetailedMoneyText1(){
    if(visitCareDetailedMoneyText1==null){

      visitCareDetailedMoneyText1 = new ACTextField();

      visitCareDetailedMoneyText1.setBindPath("1301033");

      visitCareDetailedMoneyText1.setColumns(8);

      visitCareDetailedMoneyText1.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText1.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText1.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText1.setMaxLength(8);

      addVisitCareDetailedMoneyText1();
    }
    return visitCareDetailedMoneyText1;

  }

  /**
   * 金額ラベル1を取得します。
   * @return 金額ラベル1
   */
  public ACLabel getVisitCareDetailedMoneyLabel1(){
    if(visitCareDetailedMoneyLabel1==null){

      visitCareDetailedMoneyLabel1 = new ACLabel();

      visitCareDetailedMoneyLabel1.setText("円×");

      addVisitCareDetailedMoneyLabel1();
    }
    return visitCareDetailedMoneyLabel1;

  }

  /**
   * 日数テキスト1を取得します。
   * @return 日数テキスト1
   */
  public ACTextField getVisitCareDetailedDayText1(){
    if(visitCareDetailedDayText1==null){

      visitCareDetailedDayText1 = new ACTextField();

      visitCareDetailedDayText1.setBindPath("1301034");

      visitCareDetailedDayText1.setColumns(2);

      visitCareDetailedDayText1.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedDayText1.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedDayText1.setIMEMode(InputSubset.LATIN);

      visitCareDetailedDayText1.setMaxLength(2);

      addVisitCareDetailedDayText1();
    }
    return visitCareDetailedDayText1;

  }

  /**
   * 日数ラベル1を取得します。
   * @return 日数ラベル1
   */
  public ACLabel getVisitCareDetailedDayLabel1(){
    if(visitCareDetailedDayLabel1==null){

      visitCareDetailedDayLabel1 = new ACLabel();

      visitCareDetailedDayLabel1.setText("日");

      addVisitCareDetailedDayLabel1();
    }
    return visitCareDetailedDayLabel1;

  }

  /**
   * 金額テキスト2を取得します。
   * @return 金額テキスト2
   */
  public ACTextField getVisitCareDetailedMoneyText2(){
    if(visitCareDetailedMoneyText2==null){

      visitCareDetailedMoneyText2 = new ACTextField();

      visitCareDetailedMoneyText2.setBindPath("1301035");

      visitCareDetailedMoneyText2.setColumns(8);

      visitCareDetailedMoneyText2.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText2.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText2.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText2.setMaxLength(10);

      addVisitCareDetailedMoneyText2();
    }
    return visitCareDetailedMoneyText2;

  }

  /**
   * 金額ラベル2を取得します。
   * @return 金額ラベル2
   */
  public ACLabel getVisitCareDetailedMoneyLabel2(){
    if(visitCareDetailedMoneyLabel2==null){

      visitCareDetailedMoneyLabel2 = new ACLabel();

      visitCareDetailedMoneyLabel2.setText("円");

      addVisitCareDetailedMoneyLabel2();
    }
    return visitCareDetailedMoneyLabel2;

  }

  /**
   * 金額テキスト3を取得します。
   * @return 金額テキスト3
   */
  public ACTextField getVisitCareDetailedMoneyText3(){
    if(visitCareDetailedMoneyText3==null){

      visitCareDetailedMoneyText3 = new ACTextField();

      visitCareDetailedMoneyText3.setBindPath("1301036");

      visitCareDetailedMoneyText3.setColumns(8);

      visitCareDetailedMoneyText3.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText3.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText3.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText3.setMaxLength(8);

      addVisitCareDetailedMoneyText3();
    }
    return visitCareDetailedMoneyText3;

  }

  /**
   * 金額ラベル3を取得します。
   * @return 金額ラベル3
   */
  public ACLabel getVisitCareDetailedMoneyLabel3(){
    if(visitCareDetailedMoneyLabel3==null){

      visitCareDetailedMoneyLabel3 = new ACLabel();

      visitCareDetailedMoneyLabel3.setText("円");

      addVisitCareDetailedMoneyLabel3();
    }
    return visitCareDetailedMoneyLabel3;

  }

  /**
   * 金額テキスト4を取得します。
   * @return 金額テキスト4
   */
  public ACTextField getVisitCareDetailedMoneyText4(){
    if(visitCareDetailedMoneyText4==null){

      visitCareDetailedMoneyText4 = new ACTextField();

      visitCareDetailedMoneyText4.setBindPath("1301037");

      visitCareDetailedMoneyText4.setColumns(8);

      visitCareDetailedMoneyText4.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText4.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText4.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText4.setMaxLength(8);

      addVisitCareDetailedMoneyText4();
    }
    return visitCareDetailedMoneyText4;

  }

  /**
   * 金額ラベル4を取得します。
   * @return 金額ラベル4
   */
  public ACLabel getVisitCareDetailedMoneyLabel4(){
    if(visitCareDetailedMoneyLabel4==null){

      visitCareDetailedMoneyLabel4 = new ACLabel();

      visitCareDetailedMoneyLabel4.setText("円");

      addVisitCareDetailedMoneyLabel4();
    }
    return visitCareDetailedMoneyLabel4;

  }

  /**
   * １１コンテナ２を取得します。
   * @return １１コンテナ２
   */
  public ACLabelContainer getVisitCareDetailed11Contena2(){
    if(visitCareDetailed11Contena2==null){

      visitCareDetailed11Contena2 = new ACLabelContainer();

      addVisitCareDetailed11Contena2();
    }
    return visitCareDetailed11Contena2;

  }

  /**
   * 金額テキスト5を取得します。
   * @return 金額テキスト5
   */
  public ACTextField getVisitCareDetailedMoneyText5(){
    if(visitCareDetailedMoneyText5==null){

      visitCareDetailedMoneyText5 = new ACTextField();

      visitCareDetailedMoneyText5.setBindPath("1301038");

      visitCareDetailedMoneyText5.setColumns(8);

      visitCareDetailedMoneyText5.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText5.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText5.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText5.setMaxLength(8);

      addVisitCareDetailedMoneyText5();
    }
    return visitCareDetailedMoneyText5;

  }

  /**
   * 金額ラベル5を取得します。
   * @return 金額ラベル5
   */
  public ACLabel getVisitCareDetailedMoneyLabel5(){
    if(visitCareDetailedMoneyLabel5==null){

      visitCareDetailedMoneyLabel5 = new ACLabel();

      visitCareDetailedMoneyLabel5.setText("円×");

      addVisitCareDetailedMoneyLabel5();
    }
    return visitCareDetailedMoneyLabel5;

  }

  /**
   * 日数テキスト2を取得します。
   * @return 日数テキスト2
   */
  public ACTextField getVisitCareDetailedDayText2(){
    if(visitCareDetailedDayText2==null){

      visitCareDetailedDayText2 = new ACTextField();

      visitCareDetailedDayText2.setBindPath("1301039");

      visitCareDetailedDayText2.setColumns(2);

      visitCareDetailedDayText2.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedDayText2.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedDayText2.setIMEMode(InputSubset.LATIN);

      visitCareDetailedDayText2.setMaxLength(2);

      addVisitCareDetailedDayText2();
    }
    return visitCareDetailedDayText2;

  }

  /**
   * 日数ラベル2を取得します。
   * @return 日数ラベル2
   */
  public ACLabel getVisitCareDetailedDayLabel2(){
    if(visitCareDetailedDayLabel2==null){

      visitCareDetailedDayLabel2 = new ACLabel();

      visitCareDetailedDayLabel2.setText("日");

      addVisitCareDetailedDayLabel2();
    }
    return visitCareDetailedDayLabel2;

  }

  /**
   * 金額テキスト6を取得します。
   * @return 金額テキスト6
   */
  public ACTextField getVisitCareDetailedMoneyText6(){
    if(visitCareDetailedMoneyText6==null){

      visitCareDetailedMoneyText6 = new ACTextField();

      visitCareDetailedMoneyText6.setBindPath("1301040");

      visitCareDetailedMoneyText6.setColumns(8);

      visitCareDetailedMoneyText6.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText6.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText6.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText6.setMaxLength(10);

      addVisitCareDetailedMoneyText6();
    }
    return visitCareDetailedMoneyText6;

  }

  /**
   * 金額ラベル6を取得します。
   * @return 金額ラベル6
   */
  public ACLabel getVisitCareDetailedMoneyLabel6(){
    if(visitCareDetailedMoneyLabel6==null){

      visitCareDetailedMoneyLabel6 = new ACLabel();

      visitCareDetailedMoneyLabel6.setText("円");

      addVisitCareDetailedMoneyLabel6();
    }
    return visitCareDetailedMoneyLabel6;

  }

  /**
   * 金額テキスト7を取得します。
   * @return 金額テキスト7
   */
  public ACTextField getVisitCareDetailedMoneyText7(){
    if(visitCareDetailedMoneyText7==null){

      visitCareDetailedMoneyText7 = new ACTextField();

      visitCareDetailedMoneyText7.setBindPath("1301041");

      visitCareDetailedMoneyText7.setColumns(8);

      visitCareDetailedMoneyText7.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText7.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText7.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText7.setMaxLength(8);

      addVisitCareDetailedMoneyText7();
    }
    return visitCareDetailedMoneyText7;

  }

  /**
   * 金額ラベル7を取得します。
   * @return 金額ラベル7
   */
  public ACLabel getVisitCareDetailedMoneyLabel7(){
    if(visitCareDetailedMoneyLabel7==null){

      visitCareDetailedMoneyLabel7 = new ACLabel();

      visitCareDetailedMoneyLabel7.setText("円");

      addVisitCareDetailedMoneyLabel7();
    }
    return visitCareDetailedMoneyLabel7;

  }

  /**
   * 金額テキスト8を取得します。
   * @return 金額テキスト8
   */
  public ACTextField getVisitCareDetailedMoneyText8(){
    if(visitCareDetailedMoneyText8==null){

      visitCareDetailedMoneyText8 = new ACTextField();

      visitCareDetailedMoneyText8.setBindPath("1301042");

      visitCareDetailedMoneyText8.setColumns(8);

      visitCareDetailedMoneyText8.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText8.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText8.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText8.setMaxLength(8);

      addVisitCareDetailedMoneyText8();
    }
    return visitCareDetailedMoneyText8;

  }

  /**
   * 金額ラベル8を取得します。
   * @return 金額ラベル8
   */
  public ACLabel getVisitCareDetailedMoneyLabel8(){
    if(visitCareDetailedMoneyLabel8==null){

      visitCareDetailedMoneyLabel8 = new ACLabel();

      visitCareDetailedMoneyLabel8.setText("円");

      addVisitCareDetailedMoneyLabel8();
    }
    return visitCareDetailedMoneyLabel8;

  }

  /**
   * １２）准看護師を取得します。
   * @return １２）准看護師
   */
  public ACLabel getVisitCareDetailed12Label(){
    if(visitCareDetailed12Label==null){

      visitCareDetailed12Label = new ACLabel();

      visitCareDetailed12Label.setText("（12）准看護師");

      addVisitCareDetailed12Label();
    }
    return visitCareDetailed12Label;

  }

  /**
   * １２コンテナ１を取得します。
   * @return １２コンテナ１
   */
  public ACLabelContainer getVisitCareDetailed12Contena1(){
    if(visitCareDetailed12Contena1==null){

      visitCareDetailed12Contena1 = new ACLabelContainer();

      addVisitCareDetailed12Contena1();
    }
    return visitCareDetailed12Contena1;

  }

  /**
   * 金額テキスト9を取得します。
   * @return 金額テキスト9
   */
  public ACTextField getVisitCareDetailedMoneyText9(){
    if(visitCareDetailedMoneyText9==null){

      visitCareDetailedMoneyText9 = new ACTextField();

      visitCareDetailedMoneyText9.setBindPath("1301043");

      visitCareDetailedMoneyText9.setColumns(8);

      visitCareDetailedMoneyText9.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText9.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText9.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText9.setMaxLength(8);

      addVisitCareDetailedMoneyText9();
    }
    return visitCareDetailedMoneyText9;

  }

  /**
   * 金額ラベル9を取得します。
   * @return 金額ラベル9
   */
  public ACLabel getVisitCareDetailedMoneyLabel9(){
    if(visitCareDetailedMoneyLabel9==null){

      visitCareDetailedMoneyLabel9 = new ACLabel();

      visitCareDetailedMoneyLabel9.setText("円×");

      addVisitCareDetailedMoneyLabel9();
    }
    return visitCareDetailedMoneyLabel9;

  }

  /**
   * 日数テキスト3を取得します。
   * @return 日数テキスト3
   */
  public ACTextField getVisitCareDetailedDayText3(){
    if(visitCareDetailedDayText3==null){

      visitCareDetailedDayText3 = new ACTextField();

      visitCareDetailedDayText3.setBindPath("1301044");

      visitCareDetailedDayText3.setColumns(2);

      visitCareDetailedDayText3.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedDayText3.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedDayText3.setIMEMode(InputSubset.LATIN);

      visitCareDetailedDayText3.setMaxLength(2);

      addVisitCareDetailedDayText3();
    }
    return visitCareDetailedDayText3;

  }

  /**
   * 日数ラベル3を取得します。
   * @return 日数ラベル3
   */
  public ACLabel getVisitCareDetailedDayLabel3(){
    if(visitCareDetailedDayLabel3==null){

      visitCareDetailedDayLabel3 = new ACLabel();

      visitCareDetailedDayLabel3.setText("日");

      addVisitCareDetailedDayLabel3();
    }
    return visitCareDetailedDayLabel3;

  }

  /**
   * 金額テキスト10を取得します。
   * @return 金額テキスト10
   */
  public ACTextField getVisitCareDetailedMoneyText10(){
    if(visitCareDetailedMoneyText10==null){

      visitCareDetailedMoneyText10 = new ACTextField();

      visitCareDetailedMoneyText10.setBindPath("1301045");

      visitCareDetailedMoneyText10.setColumns(8);

      visitCareDetailedMoneyText10.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText10.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText10.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText10.setMaxLength(10);

      addVisitCareDetailedMoneyText10();
    }
    return visitCareDetailedMoneyText10;

  }

  /**
   * 金額ラベル10を取得します。
   * @return 金額ラベル10
   */
  public ACLabel getVisitCareDetailedMoneyLabel10(){
    if(visitCareDetailedMoneyLabel10==null){

      visitCareDetailedMoneyLabel10 = new ACLabel();

      visitCareDetailedMoneyLabel10.setText("円");

      addVisitCareDetailedMoneyLabel10();
    }
    return visitCareDetailedMoneyLabel10;

  }

  /**
   * 金額テキスト11を取得します。
   * @return 金額テキスト11
   */
  public ACTextField getVisitCareDetailedMoneyText11(){
    if(visitCareDetailedMoneyText11==null){

      visitCareDetailedMoneyText11 = new ACTextField();

      visitCareDetailedMoneyText11.setBindPath("1301046");

      visitCareDetailedMoneyText11.setColumns(8);

      visitCareDetailedMoneyText11.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText11.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText11.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText11.setMaxLength(8);

      addVisitCareDetailedMoneyText11();
    }
    return visitCareDetailedMoneyText11;

  }

  /**
   * 金額ラベル11を取得します。
   * @return 金額ラベル11
   */
  public ACLabel getVisitCareDetailedMoneyLabel11(){
    if(visitCareDetailedMoneyLabel11==null){

      visitCareDetailedMoneyLabel11 = new ACLabel();

      visitCareDetailedMoneyLabel11.setText("円");

      addVisitCareDetailedMoneyLabel11();
    }
    return visitCareDetailedMoneyLabel11;

  }

  /**
   * 金額テキスト12を取得します。
   * @return 金額テキスト12
   */
  public ACTextField getVisitCareDetailedMoneyText12(){
    if(visitCareDetailedMoneyText12==null){

      visitCareDetailedMoneyText12 = new ACTextField();

      visitCareDetailedMoneyText12.setBindPath("1301047");

      visitCareDetailedMoneyText12.setColumns(8);

      visitCareDetailedMoneyText12.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText12.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText12.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText12.setMaxLength(8);

      addVisitCareDetailedMoneyText12();
    }
    return visitCareDetailedMoneyText12;

  }

  /**
   * 金額ラベル12を取得します。
   * @return 金額ラベル12
   */
  public ACLabel getVisitCareDetailedMoneyLabel12(){
    if(visitCareDetailedMoneyLabel12==null){

      visitCareDetailedMoneyLabel12 = new ACLabel();

      visitCareDetailedMoneyLabel12.setText("円");

      addVisitCareDetailedMoneyLabel12();
    }
    return visitCareDetailedMoneyLabel12;

  }

  /**
   * １２コンテナ２を取得します。
   * @return １２コンテナ２
   */
  public ACLabelContainer getVisitCareDetailed12Contena2(){
    if(visitCareDetailed12Contena2==null){

      visitCareDetailed12Contena2 = new ACLabelContainer();

      addVisitCareDetailed12Contena2();
    }
    return visitCareDetailed12Contena2;

  }

  /**
   * 金額テキスト13を取得します。
   * @return 金額テキスト13
   */
  public ACTextField getVisitCareDetailedMoneyText13(){
    if(visitCareDetailedMoneyText13==null){

      visitCareDetailedMoneyText13 = new ACTextField();

      visitCareDetailedMoneyText13.setBindPath("1301048");

      visitCareDetailedMoneyText13.setColumns(8);

      visitCareDetailedMoneyText13.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText13.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText13.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText13.setMaxLength(8);

      addVisitCareDetailedMoneyText13();
    }
    return visitCareDetailedMoneyText13;

  }

  /**
   * 金額ラベル13を取得します。
   * @return 金額ラベル13
   */
  public ACLabel getVisitCareDetailedMoneyLabel13(){
    if(visitCareDetailedMoneyLabel13==null){

      visitCareDetailedMoneyLabel13 = new ACLabel();

      visitCareDetailedMoneyLabel13.setText("円×");

      addVisitCareDetailedMoneyLabel13();
    }
    return visitCareDetailedMoneyLabel13;

  }

  /**
   * 日数テキスト4を取得します。
   * @return 日数テキスト4
   */
  public ACTextField getVisitCareDetailedDayText4(){
    if(visitCareDetailedDayText4==null){

      visitCareDetailedDayText4 = new ACTextField();

      visitCareDetailedDayText4.setBindPath("1301049");

      visitCareDetailedDayText4.setColumns(2);

      visitCareDetailedDayText4.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedDayText4.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedDayText4.setIMEMode(InputSubset.LATIN);

      visitCareDetailedDayText4.setMaxLength(2);

      addVisitCareDetailedDayText4();
    }
    return visitCareDetailedDayText4;

  }

  /**
   * 日数ラベル4を取得します。
   * @return 日数ラベル4
   */
  public ACLabel getVisitCareDetailedDayLabel4(){
    if(visitCareDetailedDayLabel4==null){

      visitCareDetailedDayLabel4 = new ACLabel();

      visitCareDetailedDayLabel4.setText("日");

      addVisitCareDetailedDayLabel4();
    }
    return visitCareDetailedDayLabel4;

  }

  /**
   * 金額テキスト14を取得します。
   * @return 金額テキスト14
   */
  public ACTextField getVisitCareDetailedMoneyText14(){
    if(visitCareDetailedMoneyText14==null){

      visitCareDetailedMoneyText14 = new ACTextField();

      visitCareDetailedMoneyText14.setBindPath("1301050");

      visitCareDetailedMoneyText14.setColumns(8);

      visitCareDetailedMoneyText14.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText14.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText14.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText14.setMaxLength(10);

      addVisitCareDetailedMoneyText14();
    }
    return visitCareDetailedMoneyText14;

  }

  /**
   * 金額ラベル14を取得します。
   * @return 金額ラベル14
   */
  public ACLabel getVisitCareDetailedMoneyLabel14(){
    if(visitCareDetailedMoneyLabel14==null){

      visitCareDetailedMoneyLabel14 = new ACLabel();

      visitCareDetailedMoneyLabel14.setText("円");

      addVisitCareDetailedMoneyLabel14();
    }
    return visitCareDetailedMoneyLabel14;

  }

  /**
   * 金額テキスト15を取得します。
   * @return 金額テキスト15
   */
  public ACTextField getVisitCareDetailedMoneyText15(){
    if(visitCareDetailedMoneyText15==null){

      visitCareDetailedMoneyText15 = new ACTextField();

      visitCareDetailedMoneyText15.setBindPath("1301051");

      visitCareDetailedMoneyText15.setColumns(8);

      visitCareDetailedMoneyText15.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText15.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText15.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText15.setMaxLength(8);

      addVisitCareDetailedMoneyText15();
    }
    return visitCareDetailedMoneyText15;

  }

  /**
   * 金額ラベル15を取得します。
   * @return 金額ラベル15
   */
  public ACLabel getVisitCareDetailedMoneyLabel15(){
    if(visitCareDetailedMoneyLabel15==null){

      visitCareDetailedMoneyLabel15 = new ACLabel();

      visitCareDetailedMoneyLabel15.setText("円");

      addVisitCareDetailedMoneyLabel15();
    }
    return visitCareDetailedMoneyLabel15;

  }

  /**
   * 金額テキスト16を取得します。
   * @return 金額テキスト16
   */
  public ACTextField getVisitCareDetailedMoneyText16(){
    if(visitCareDetailedMoneyText16==null){

      visitCareDetailedMoneyText16 = new ACTextField();

      visitCareDetailedMoneyText16.setBindPath("1301052");

      visitCareDetailedMoneyText16.setColumns(8);

      visitCareDetailedMoneyText16.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText16.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText16.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText16.setMaxLength(8);

      addVisitCareDetailedMoneyText16();
    }
    return visitCareDetailedMoneyText16;

  }

  /**
   * 金額ラベル16を取得します。
   * @return 金額ラベル16
   */
  public ACLabel getVisitCareDetailedMoneyLabel16(){
    if(visitCareDetailedMoneyLabel16==null){

      visitCareDetailedMoneyLabel16 = new ACLabel();

      visitCareDetailedMoneyLabel16.setText("円");

      addVisitCareDetailedMoneyLabel16();
    }
    return visitCareDetailedMoneyLabel16;

  }

  /**
   * １３）難病等複数回訪問加算を取得します。
   * @return １３）難病等複数回訪問加算
   */
  public ACLabel getVisitCareDetailed13(){
    if(visitCareDetailed13==null){

      visitCareDetailed13 = new ACLabel();

      visitCareDetailed13.setText("（13）難病等複数回訪問加算");

      addVisitCareDetailed13();
    }
    return visitCareDetailed13;

  }

  /**
   * １３コンテナを取得します。
   * @return １３コンテナ
   */
  public ACLabelContainer getVisitCareDetailed13Conatena(){
    if(visitCareDetailed13Conatena==null){

      visitCareDetailed13Conatena = new ACLabelContainer();

      addVisitCareDetailed13Conatena();
    }
    return visitCareDetailed13Conatena;

  }

  /**
   * 金額テキスト17を取得します。
   * @return 金額テキスト17
   */
  public ACTextField getVisitCareDetailedMoneyText17(){
    if(visitCareDetailedMoneyText17==null){

      visitCareDetailedMoneyText17 = new ACTextField();

      visitCareDetailedMoneyText17.setBindPath("1301053");

      visitCareDetailedMoneyText17.setColumns(8);

      visitCareDetailedMoneyText17.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText17.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText17.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText17.setMaxLength(8);

      addVisitCareDetailedMoneyText17();
    }
    return visitCareDetailedMoneyText17;

  }

  /**
   * 金額ラベル17を取得します。
   * @return 金額ラベル17
   */
  public ACLabel getVisitCareDetailedMoneyLabel17(){
    if(visitCareDetailedMoneyLabel17==null){

      visitCareDetailedMoneyLabel17 = new ACLabel();

      visitCareDetailedMoneyLabel17.setText("円×");

      addVisitCareDetailedMoneyLabel17();
    }
    return visitCareDetailedMoneyLabel17;

  }

  /**
   * 日数テキスト5を取得します。
   * @return 日数テキスト5
   */
  public ACTextField getVisitCareDetailedDayText5(){
    if(visitCareDetailedDayText5==null){

      visitCareDetailedDayText5 = new ACTextField();

      visitCareDetailedDayText5.setBindPath("1301054");

      visitCareDetailedDayText5.setColumns(2);

      visitCareDetailedDayText5.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedDayText5.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedDayText5.setIMEMode(InputSubset.LATIN);

      visitCareDetailedDayText5.setMaxLength(2);

      addVisitCareDetailedDayText5();
    }
    return visitCareDetailedDayText5;

  }

  /**
   * 日数ラベル5を取得します。
   * @return 日数ラベル5
   */
  public ACLabel getVisitCareDetailedDayLabel5(){
    if(visitCareDetailedDayLabel5==null){

      visitCareDetailedDayLabel5 = new ACLabel();

      visitCareDetailedDayLabel5.setText("日");

      addVisitCareDetailedDayLabel5();
    }
    return visitCareDetailedDayLabel5;

  }

  /**
   * 金額テキスト18を取得します。
   * @return 金額テキスト18
   */
  public ACTextField getVisitCareDetailedMoneyText18(){
    if(visitCareDetailedMoneyText18==null){

      visitCareDetailedMoneyText18 = new ACTextField();

      visitCareDetailedMoneyText18.setBindPath("1301055");

      visitCareDetailedMoneyText18.setColumns(8);

      visitCareDetailedMoneyText18.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText18.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText18.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText18.setMaxLength(10);

      addVisitCareDetailedMoneyText18();
    }
    return visitCareDetailedMoneyText18;

  }

  /**
   * 金額ラベル18を取得します。
   * @return 金額ラベル18
   */
  public ACLabel getVisitCareDetailedMoneyLabel18(){
    if(visitCareDetailedMoneyLabel18==null){

      visitCareDetailedMoneyLabel18 = new ACLabel();

      visitCareDetailedMoneyLabel18.setText("円");

      addVisitCareDetailedMoneyLabel18();
    }
    return visitCareDetailedMoneyLabel18;

  }

  /**
   * 金額テキスト19を取得します。
   * @return 金額テキスト19
   */
  public ACTextField getVisitCareDetailedMoneyText19(){
    if(visitCareDetailedMoneyText19==null){

      visitCareDetailedMoneyText19 = new ACTextField();

      visitCareDetailedMoneyText19.setBindPath("1301056");

      visitCareDetailedMoneyText19.setColumns(8);

      visitCareDetailedMoneyText19.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText19.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText19.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText19.setMaxLength(8);

      addVisitCareDetailedMoneyText19();
    }
    return visitCareDetailedMoneyText19;

  }

  /**
   * 金額ラベル19を取得します。
   * @return 金額ラベル19
   */
  public ACLabel getVisitCareDetailedMoneyLabel19(){
    if(visitCareDetailedMoneyLabel19==null){

      visitCareDetailedMoneyLabel19 = new ACLabel();

      visitCareDetailedMoneyLabel19.setText("円");

      addVisitCareDetailedMoneyLabel19();
    }
    return visitCareDetailedMoneyLabel19;

  }

  /**
   * 金額テキスト20を取得します。
   * @return 金額テキスト20
   */
  public ACTextField getVisitCareDetailedMoneyText20(){
    if(visitCareDetailedMoneyText20==null){

      visitCareDetailedMoneyText20 = new ACTextField();

      visitCareDetailedMoneyText20.setBindPath("1301057");

      visitCareDetailedMoneyText20.setColumns(8);

      visitCareDetailedMoneyText20.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText20.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText20.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText20.setMaxLength(8);

      addVisitCareDetailedMoneyText20();
    }
    return visitCareDetailedMoneyText20;

  }

  /**
   * 金額ラベル20を取得します。
   * @return 金額ラベル20
   */
  public ACLabel getVisitCareDetailedMoneyLabel20(){
    if(visitCareDetailedMoneyLabel20==null){

      visitCareDetailedMoneyLabel20 = new ACLabel();

      visitCareDetailedMoneyLabel20.setText("円");

      addVisitCareDetailedMoneyLabel20();
    }
    return visitCareDetailedMoneyLabel20;

  }

  /**
   * １３コンテナを取得します。
   * @return １３コンテナ
   */
  public ACLabelContainer getVisitCareDetailed13Conatena2(){
    if(visitCareDetailed13Conatena2==null){

      visitCareDetailed13Conatena2 = new ACLabelContainer();

      addVisitCareDetailed13Conatena2();
    }
    return visitCareDetailed13Conatena2;

  }

  /**
   * 金額テキスト51を取得します。
   * @return 金額テキスト51
   */
  public ACTextField getVisitCareDetailedMoneyText51(){
    if(visitCareDetailedMoneyText51==null){

      visitCareDetailedMoneyText51 = new ACTextField();

      visitCareDetailedMoneyText51.setBindPath("1301058");

      visitCareDetailedMoneyText51.setColumns(8);

      visitCareDetailedMoneyText51.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText51.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText51.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText51.setMaxLength(8);

      addVisitCareDetailedMoneyText51();
    }
    return visitCareDetailedMoneyText51;

  }

  /**
   * 金額ラベル51を取得します。
   * @return 金額ラベル51
   */
  public ACLabel getVisitCareDetailedMoneyLabel51(){
    if(visitCareDetailedMoneyLabel51==null){

      visitCareDetailedMoneyLabel51 = new ACLabel();

      visitCareDetailedMoneyLabel51.setText("円×");

      addVisitCareDetailedMoneyLabel51();
    }
    return visitCareDetailedMoneyLabel51;

  }

  /**
   * 日数テキスト8を取得します。
   * @return 日数テキスト8
   */
  public ACTextField getVisitCareDetailedDayText8(){
    if(visitCareDetailedDayText8==null){

      visitCareDetailedDayText8 = new ACTextField();

      visitCareDetailedDayText8.setBindPath("1301059");

      visitCareDetailedDayText8.setColumns(2);

      visitCareDetailedDayText8.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedDayText8.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedDayText8.setIMEMode(InputSubset.LATIN);

      visitCareDetailedDayText8.setMaxLength(2);

      addVisitCareDetailedDayText8();
    }
    return visitCareDetailedDayText8;

  }

  /**
   * 日数ラベル8を取得します。
   * @return 日数ラベル8
   */
  public ACLabel getVisitCareDetailedDayLabel8(){
    if(visitCareDetailedDayLabel8==null){

      visitCareDetailedDayLabel8 = new ACLabel();

      visitCareDetailedDayLabel8.setText("日");

      addVisitCareDetailedDayLabel8();
    }
    return visitCareDetailedDayLabel8;

  }

  /**
   * 金額テキスト52を取得します。
   * @return 金額テキスト52
   */
  public ACTextField getVisitCareDetailedMoneyText52(){
    if(visitCareDetailedMoneyText52==null){

      visitCareDetailedMoneyText52 = new ACTextField();

      visitCareDetailedMoneyText52.setBindPath("1301060");

      visitCareDetailedMoneyText52.setColumns(8);

      visitCareDetailedMoneyText52.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText52.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText52.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText52.setMaxLength(10);

      addVisitCareDetailedMoneyText52();
    }
    return visitCareDetailedMoneyText52;

  }

  /**
   * 金額ラベル52を取得します。
   * @return 金額ラベル52
   */
  public ACLabel getVisitCareDetailedMoneyLabel52(){
    if(visitCareDetailedMoneyLabel52==null){

      visitCareDetailedMoneyLabel52 = new ACLabel();

      visitCareDetailedMoneyLabel52.setText("円");

      addVisitCareDetailedMoneyLabel52();
    }
    return visitCareDetailedMoneyLabel52;

  }

  /**
   * 金額テキスト53を取得します。
   * @return 金額テキスト53
   */
  public ACTextField getVisitCareDetailedMoneyText53(){
    if(visitCareDetailedMoneyText53==null){

      visitCareDetailedMoneyText53 = new ACTextField();

      visitCareDetailedMoneyText53.setBindPath("1301061");

      visitCareDetailedMoneyText53.setColumns(8);

      visitCareDetailedMoneyText53.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText53.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText53.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText53.setMaxLength(8);

      addVisitCareDetailedMoneyText53();
    }
    return visitCareDetailedMoneyText53;

  }

  /**
   * 金額ラベル53を取得します。
   * @return 金額ラベル53
   */
  public ACLabel getVisitCareDetailedMoneyLabel53(){
    if(visitCareDetailedMoneyLabel53==null){

      visitCareDetailedMoneyLabel53 = new ACLabel();

      visitCareDetailedMoneyLabel53.setText("円");

      addVisitCareDetailedMoneyLabel53();
    }
    return visitCareDetailedMoneyLabel53;

  }

  /**
   * 金額テキスト54を取得します。
   * @return 金額テキスト54
   */
  public ACTextField getVisitCareDetailedMoneyText54(){
    if(visitCareDetailedMoneyText54==null){

      visitCareDetailedMoneyText54 = new ACTextField();

      visitCareDetailedMoneyText54.setBindPath("1301062");

      visitCareDetailedMoneyText54.setColumns(8);

      visitCareDetailedMoneyText54.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText54.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText54.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText54.setMaxLength(8);

      addVisitCareDetailedMoneyText54();
    }
    return visitCareDetailedMoneyText54;

  }

  /**
   * 金額ラベル54を取得します。
   * @return 金額ラベル54
   */
  public ACLabel getVisitCareDetailedMoneyLabel54(){
    if(visitCareDetailedMoneyLabel54==null){

      visitCareDetailedMoneyLabel54 = new ACLabel();

      visitCareDetailedMoneyLabel54.setText("円");

      addVisitCareDetailedMoneyLabel54();
    }
    return visitCareDetailedMoneyLabel54;

  }

  /**
   * １４）緊急訪問看護加算を取得します。
   * @return １４）緊急訪問看護加算
   */
  public ACLabel getVisitCareDetailed14(){
    if(visitCareDetailed14==null){

      visitCareDetailed14 = new ACLabel();

      visitCareDetailed14.setText("（14）緊急訪問看護加算");

      addVisitCareDetailed14();
    }
    return visitCareDetailed14;

  }

  /**
   * １４コンテナを取得します。
   * @return １４コンテナ
   */
  public ACLabelContainer getVisitCareDetailed14Conatena(){
    if(visitCareDetailed14Conatena==null){

      visitCareDetailed14Conatena = new ACLabelContainer();

      addVisitCareDetailed14Conatena();
    }
    return visitCareDetailed14Conatena;

  }

  /**
   * 金額テキスト55を取得します。
   * @return 金額テキスト55
   */
  public ACTextField getVisitCareDetailedMoneyText55(){
    if(visitCareDetailedMoneyText55==null){

      visitCareDetailedMoneyText55 = new ACTextField();

      visitCareDetailedMoneyText55.setBindPath("1301153");

      visitCareDetailedMoneyText55.setColumns(8);

      visitCareDetailedMoneyText55.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText55.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText55.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText55.setMaxLength(8);

      addVisitCareDetailedMoneyText55();
    }
    return visitCareDetailedMoneyText55;

  }

  /**
   * 金額ラベル55を取得します。
   * @return 金額ラベル55
   */
  public ACLabel getVisitCareDetailedMoneyLabel55(){
    if(visitCareDetailedMoneyLabel55==null){

      visitCareDetailedMoneyLabel55 = new ACLabel();

      visitCareDetailedMoneyLabel55.setText("円×");

      addVisitCareDetailedMoneyLabel55();
    }
    return visitCareDetailedMoneyLabel55;

  }

  /**
   * 日数テキスト9を取得します。
   * @return 日数テキスト9
   */
  public ACTextField getVisitCareDetailedDayText9(){
    if(visitCareDetailedDayText9==null){

      visitCareDetailedDayText9 = new ACTextField();

      visitCareDetailedDayText9.setBindPath("1301154");

      visitCareDetailedDayText9.setColumns(2);

      visitCareDetailedDayText9.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedDayText9.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedDayText9.setIMEMode(InputSubset.LATIN);

      visitCareDetailedDayText9.setMaxLength(2);

      addVisitCareDetailedDayText9();
    }
    return visitCareDetailedDayText9;

  }

  /**
   * 日数ラベル9を取得します。
   * @return 日数ラベル9
   */
  public ACLabel getVisitCareDetailedDayLabel9(){
    if(visitCareDetailedDayLabel9==null){

      visitCareDetailedDayLabel9 = new ACLabel();

      visitCareDetailedDayLabel9.setText("日");

      addVisitCareDetailedDayLabel9();
    }
    return visitCareDetailedDayLabel9;

  }

  /**
   * 金額テキスト56を取得します。
   * @return 金額テキスト56
   */
  public ACTextField getVisitCareDetailedMoneyText56(){
    if(visitCareDetailedMoneyText56==null){

      visitCareDetailedMoneyText56 = new ACTextField();

      visitCareDetailedMoneyText56.setBindPath("1301155");

      visitCareDetailedMoneyText56.setColumns(8);

      visitCareDetailedMoneyText56.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText56.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText56.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText56.setMaxLength(10);

      addVisitCareDetailedMoneyText56();
    }
    return visitCareDetailedMoneyText56;

  }

  /**
   * 金額ラベル56を取得します。
   * @return 金額ラベル56
   */
  public ACLabel getVisitCareDetailedMoneyLabel56(){
    if(visitCareDetailedMoneyLabel56==null){

      visitCareDetailedMoneyLabel56 = new ACLabel();

      visitCareDetailedMoneyLabel56.setText("円");

      addVisitCareDetailedMoneyLabel56();
    }
    return visitCareDetailedMoneyLabel56;

  }

  /**
   * 金額テキスト57を取得します。
   * @return 金額テキスト57
   */
  public ACTextField getVisitCareDetailedMoneyText57(){
    if(visitCareDetailedMoneyText57==null){

      visitCareDetailedMoneyText57 = new ACTextField();

      visitCareDetailedMoneyText57.setBindPath("1301156");

      visitCareDetailedMoneyText57.setColumns(8);

      visitCareDetailedMoneyText57.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText57.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText57.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText57.setMaxLength(8);

      addVisitCareDetailedMoneyText57();
    }
    return visitCareDetailedMoneyText57;

  }

  /**
   * 金額ラベル58を取得します。
   * @return 金額ラベル58
   */
  public ACLabel getVisitCareDetailedMoneyLabel57(){
    if(visitCareDetailedMoneyLabel57==null){

      visitCareDetailedMoneyLabel57 = new ACLabel();

      visitCareDetailedMoneyLabel57.setText("円");

      addVisitCareDetailedMoneyLabel57();
    }
    return visitCareDetailedMoneyLabel57;

  }

  /**
   * 金額テキスト59を取得します。
   * @return 金額テキスト59
   */
  public ACTextField getVisitCareDetailedMoneyText58(){
    if(visitCareDetailedMoneyText58==null){

      visitCareDetailedMoneyText58 = new ACTextField();

      visitCareDetailedMoneyText58.setBindPath("1301157");

      visitCareDetailedMoneyText58.setColumns(8);

      visitCareDetailedMoneyText58.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText58.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText58.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText58.setMaxLength(8);

      addVisitCareDetailedMoneyText58();
    }
    return visitCareDetailedMoneyText58;

  }

  /**
   * 金額ラベル60を取得します。
   * @return 金額ラベル60
   */
  public ACLabel getVisitCareDetailedMoneyLabel58(){
    if(visitCareDetailedMoneyLabel58==null){

      visitCareDetailedMoneyLabel58 = new ACLabel();

      visitCareDetailedMoneyLabel58.setText("円");

      addVisitCareDetailedMoneyLabel58();
    }
    return visitCareDetailedMoneyLabel58;

  }

  /**
   * （１０）基本療養費パネル２を取得します。
   * @return （１０）基本療養費パネル２
   */
  public ACPanel getVisitCareDetailed10Panel2(){
    if(visitCareDetailed10Panel2==null){

      visitCareDetailed10Panel2 = new ACPanel();

      addVisitCareDetailed10Panel2();
    }
    return visitCareDetailed10Panel2;

  }

  /**
   * 基本療養費（II）・グループ）を取得します。
   * @return 基本療養費（II）・グループ）
   */
  public ACGroupBox getVisitCareDetailedStanderd2(){
    if(visitCareDetailedStanderd2==null){

      visitCareDetailedStanderd2 = new ACGroupBox();

      visitCareDetailedStanderd2.setText("基本療養費（ＩＩ）");

      visitCareDetailedStanderd2.setLayout(getVisitCareDetailedStanderd2Layout());

      addVisitCareDetailedStanderd2();
    }
    return visitCareDetailedStanderd2;

  }

  /**
   * 基本療養費（II）・グループ・レイアウト）を取得します。
   * @return 基本療養費（II）・グループ・レイアウト）
   */
  public VRLayout getVisitCareDetailedStanderd2Layout(){
    if(visitCareDetailedStanderd2Layout==null){

      visitCareDetailedStanderd2Layout = new VRLayout();

      visitCareDetailedStanderd2Layout.setAutoWrap(false);

      visitCareDetailedStanderd2Layout.setHgap(4);

      visitCareDetailedStanderd2Layout.setLabelMargin(2);

      visitCareDetailedStanderd2Layout.setVgap(4);

      addVisitCareDetailedStanderd2Layout();
    }
    return visitCareDetailedStanderd2Layout;

  }

  /**
   * １５）保健師、看護師、作業療法士を取得します。
   * @return １５）保健師、看護師、作業療法士
   */
  public ACLabel getVisitCareDetailed14Label(){
    if(visitCareDetailed14Label==null){

      visitCareDetailed14Label = new ACLabel();

      visitCareDetailed14Label.setText("（15）保健師、看護師、作業療法士");

      visitCareDetailed14Label.setLayout(getVisitCareDetailed14LabelLayout());

      addVisitCareDetailed14Label();
    }
    return visitCareDetailed14Label;

  }

  /**
   * １５）保健師、看護師、作業療法士・レイアウトを取得します。
   * @return １５）保健師、看護師、作業療法士・レイアウト
   */
  public VRLayout getVisitCareDetailed14LabelLayout(){
    if(visitCareDetailed14LabelLayout==null){

      visitCareDetailed14LabelLayout = new VRLayout();

      visitCareDetailed14LabelLayout.setAutoWrap(true);

      visitCareDetailed14LabelLayout.setHgap(0);

      visitCareDetailed14LabelLayout.setLabelMargin(0);

      visitCareDetailed14LabelLayout.setVgap(0);

      addVisitCareDetailed14LabelLayout();
    }
    return visitCareDetailed14LabelLayout;

  }

  /**
   * １５コンテナを取得します。
   * @return １５コンテナ
   */
  public ACLabelContainer getVisitCareDetailed14Contena(){
    if(visitCareDetailed14Contena==null){

      visitCareDetailed14Contena = new ACLabelContainer();

      addVisitCareDetailed14Contena();
    }
    return visitCareDetailed14Contena;

  }

  /**
   * 金額テキスト21を取得します。
   * @return 金額テキスト21
   */
  public ACTextField getVisitCareDetailedMoneyText21(){
    if(visitCareDetailedMoneyText21==null){

      visitCareDetailedMoneyText21 = new ACTextField();

      visitCareDetailedMoneyText21.setBindPath("1301063");

      visitCareDetailedMoneyText21.setColumns(8);

      visitCareDetailedMoneyText21.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText21.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText21.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText21.setMaxLength(8);

      addVisitCareDetailedMoneyText21();
    }
    return visitCareDetailedMoneyText21;

  }

  /**
   * 金額ラベル21を取得します。
   * @return 金額ラベル21
   */
  public ACLabel getVisitCareDetailedMoneyLabel21(){
    if(visitCareDetailedMoneyLabel21==null){

      visitCareDetailedMoneyLabel21 = new ACLabel();

      visitCareDetailedMoneyLabel21.setText("円×");

      addVisitCareDetailedMoneyLabel21();
    }
    return visitCareDetailedMoneyLabel21;

  }

  /**
   * 日数テキスト6を取得します。
   * @return 日数テキスト6
   */
  public ACTextField getVisitCareDetailedDayText6(){
    if(visitCareDetailedDayText6==null){

      visitCareDetailedDayText6 = new ACTextField();

      visitCareDetailedDayText6.setBindPath("1301064");

      visitCareDetailedDayText6.setColumns(2);

      visitCareDetailedDayText6.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedDayText6.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedDayText6.setIMEMode(InputSubset.LATIN);

      visitCareDetailedDayText6.setMaxLength(2);

      addVisitCareDetailedDayText6();
    }
    return visitCareDetailedDayText6;

  }

  /**
   * 日数ラベル6を取得します。
   * @return 日数ラベル6
   */
  public ACLabel getVisitCareDetailedDayLabel6(){
    if(visitCareDetailedDayLabel6==null){

      visitCareDetailedDayLabel6 = new ACLabel();

      visitCareDetailedDayLabel6.setText("日");

      addVisitCareDetailedDayLabel6();
    }
    return visitCareDetailedDayLabel6;

  }

  /**
   * 金額テキスト22を取得します。
   * @return 金額テキスト22
   */
  public ACTextField getVisitCareDetailedMoneyText22(){
    if(visitCareDetailedMoneyText22==null){

      visitCareDetailedMoneyText22 = new ACTextField();

      visitCareDetailedMoneyText22.setBindPath("1301065");

      visitCareDetailedMoneyText22.setColumns(8);

      visitCareDetailedMoneyText22.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText22.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText22.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText22.setMaxLength(10);

      addVisitCareDetailedMoneyText22();
    }
    return visitCareDetailedMoneyText22;

  }

  /**
   * 金額ラベル22を取得します。
   * @return 金額ラベル22
   */
  public ACLabel getVisitCareDetailedMoneyLabel22(){
    if(visitCareDetailedMoneyLabel22==null){

      visitCareDetailedMoneyLabel22 = new ACLabel();

      visitCareDetailedMoneyLabel22.setText("円");

      addVisitCareDetailedMoneyLabel22();
    }
    return visitCareDetailedMoneyLabel22;

  }

  /**
   * 金額テキスト23を取得します。
   * @return 金額テキスト23
   */
  public ACTextField getVisitCareDetailedMoneyText23(){
    if(visitCareDetailedMoneyText23==null){

      visitCareDetailedMoneyText23 = new ACTextField();

      visitCareDetailedMoneyText23.setBindPath("1301066");

      visitCareDetailedMoneyText23.setColumns(8);

      visitCareDetailedMoneyText23.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText23.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText23.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText23.setMaxLength(8);

      addVisitCareDetailedMoneyText23();
    }
    return visitCareDetailedMoneyText23;

  }

  /**
   * 金額ラベル23を取得します。
   * @return 金額ラベル23
   */
  public ACLabel getVisitCareDetailedMoneyLabel23(){
    if(visitCareDetailedMoneyLabel23==null){

      visitCareDetailedMoneyLabel23 = new ACLabel();

      visitCareDetailedMoneyLabel23.setText("円");

      addVisitCareDetailedMoneyLabel23();
    }
    return visitCareDetailedMoneyLabel23;

  }

  /**
   * 金額テキスト24を取得します。
   * @return 金額テキスト24
   */
  public ACTextField getVisitCareDetailedMoneyText24(){
    if(visitCareDetailedMoneyText24==null){

      visitCareDetailedMoneyText24 = new ACTextField();

      visitCareDetailedMoneyText24.setBindPath("1301067");

      visitCareDetailedMoneyText24.setColumns(8);

      visitCareDetailedMoneyText24.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText24.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText24.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText24.setMaxLength(8);

      addVisitCareDetailedMoneyText24();
    }
    return visitCareDetailedMoneyText24;

  }

  /**
   * 金額ラベル24を取得します。
   * @return 金額ラベル24
   */
  public ACLabel getVisitCareDetailedMoneyLabel24(){
    if(visitCareDetailedMoneyLabel24==null){

      visitCareDetailedMoneyLabel24 = new ACLabel();

      visitCareDetailedMoneyLabel24.setText("円");

      addVisitCareDetailedMoneyLabel24();
    }
    return visitCareDetailedMoneyLabel24;

  }

  /**
   * １６）延長時間加算を取得します。
   * @return １６）延長時間加算
   */
  public ACLabel getVisitCareDetailed15label(){
    if(visitCareDetailed15label==null){

      visitCareDetailed15label = new ACLabel();

      visitCareDetailed15label.setText("（16）延長時間加算");

      addVisitCareDetailed15label();
    }
    return visitCareDetailed15label;

  }

  /**
   * １６コンテナを取得します。
   * @return １６コンテナ
   */
  public ACLabelContainer getVisitCareDetailed15Contena(){
    if(visitCareDetailed15Contena==null){

      visitCareDetailed15Contena = new ACLabelContainer();

      visitCareDetailed15Contena.setLayout(getVisitCareDetailed15ContenaLayout());

      addVisitCareDetailed15Contena();
    }
    return visitCareDetailed15Contena;

  }

  /**
   * １６コンテナ・レイアウトを取得します。
   * @return １６コンテナ・レイアウト
   */
  public VRLayout getVisitCareDetailed15ContenaLayout(){
    if(visitCareDetailed15ContenaLayout==null){

      visitCareDetailed15ContenaLayout = new VRLayout();

      visitCareDetailed15ContenaLayout.setAutoWrap(false);

      visitCareDetailed15ContenaLayout.setHgap(2);

      visitCareDetailed15ContenaLayout.setLabelMargin(2);

      visitCareDetailed15ContenaLayout.setVgap(2);

      addVisitCareDetailed15ContenaLayout();
    }
    return visitCareDetailed15ContenaLayout;

  }

  /**
   * 金額テキスト25を取得します。
   * @return 金額テキスト25
   */
  public ACTextField getVisitCareDetailedMoneyText25(){
    if(visitCareDetailedMoneyText25==null){

      visitCareDetailedMoneyText25 = new ACTextField();

      visitCareDetailedMoneyText25.setBindPath("1301068");

      visitCareDetailedMoneyText25.setColumns(8);

      visitCareDetailedMoneyText25.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText25.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText25.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText25.setMaxLength(8);

      addVisitCareDetailedMoneyText25();
    }
    return visitCareDetailedMoneyText25;

  }

  /**
   * 金額ラベル25を取得します。
   * @return 金額ラベル25
   */
  public ACLabel getVisitCareDetailedMoneyLabel25(){
    if(visitCareDetailedMoneyLabel25==null){

      visitCareDetailedMoneyLabel25 = new ACLabel();

      visitCareDetailedMoneyLabel25.setText("円×");

      addVisitCareDetailedMoneyLabel25();
    }
    return visitCareDetailedMoneyLabel25;

  }

  /**
   * 時間テキスト1を取得します。
   * @return 時間テキスト1
   */
  public ACTextField getVisitCareDetailedTimeText1(){
    if(visitCareDetailedTimeText1==null){

      visitCareDetailedTimeText1 = new ACTextField();

      visitCareDetailedTimeText1.setBindPath("1301069");

      visitCareDetailedTimeText1.setColumns(2);

      visitCareDetailedTimeText1.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedTimeText1.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedTimeText1.setIMEMode(InputSubset.LATIN);

      visitCareDetailedTimeText1.setMaxLength(2);

      addVisitCareDetailedTimeText1();
    }
    return visitCareDetailedTimeText1;

  }

  /**
   * 時間ラベル1を取得します。
   * @return 時間ラベル1
   */
  public ACLabel getVisitCareDetailedTimeLabel1(){
    if(visitCareDetailedTimeLabel1==null){

      visitCareDetailedTimeLabel1 = new ACLabel();

      visitCareDetailedTimeLabel1.setText("時間");

      addVisitCareDetailedTimeLabel1();
    }
    return visitCareDetailedTimeLabel1;

  }

  /**
   * 金額テキスト26を取得します。
   * @return 金額テキスト26
   */
  public ACTextField getVisitCareDetailedMoneyText26(){
    if(visitCareDetailedMoneyText26==null){

      visitCareDetailedMoneyText26 = new ACTextField();

      visitCareDetailedMoneyText26.setBindPath("1301070");

      visitCareDetailedMoneyText26.setColumns(8);

      visitCareDetailedMoneyText26.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText26.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText26.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText26.setMaxLength(10);

      addVisitCareDetailedMoneyText26();
    }
    return visitCareDetailedMoneyText26;

  }

  /**
   * 金額ラベル26を取得します。
   * @return 金額ラベル26
   */
  public ACLabel getVisitCareDetailedMoneyLabel26(){
    if(visitCareDetailedMoneyLabel26==null){

      visitCareDetailedMoneyLabel26 = new ACLabel();

      visitCareDetailedMoneyLabel26.setText("円");

      addVisitCareDetailedMoneyLabel26();
    }
    return visitCareDetailedMoneyLabel26;

  }

  /**
   * 金額テキスト27を取得します。
   * @return 金額テキスト27
   */
  public ACTextField getVisitCareDetailedMoneyText27(){
    if(visitCareDetailedMoneyText27==null){

      visitCareDetailedMoneyText27 = new ACTextField();

      visitCareDetailedMoneyText27.setBindPath("1301071");

      visitCareDetailedMoneyText27.setColumns(8);

      visitCareDetailedMoneyText27.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText27.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText27.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText27.setMaxLength(8);

      addVisitCareDetailedMoneyText27();
    }
    return visitCareDetailedMoneyText27;

  }

  /**
   * 金額ラベル27を取得します。
   * @return 金額ラベル27
   */
  public ACLabel getVisitCareDetailedMoneyLabel27(){
    if(visitCareDetailedMoneyLabel27==null){

      visitCareDetailedMoneyLabel27 = new ACLabel();

      visitCareDetailedMoneyLabel27.setText("円");

      addVisitCareDetailedMoneyLabel27();
    }
    return visitCareDetailedMoneyLabel27;

  }

  /**
   * 金額テキスト28を取得します。
   * @return 金額テキスト28
   */
  public ACTextField getVisitCareDetailedMoneyText28(){
    if(visitCareDetailedMoneyText28==null){

      visitCareDetailedMoneyText28 = new ACTextField();

      visitCareDetailedMoneyText28.setBindPath("1301072");

      visitCareDetailedMoneyText28.setColumns(8);

      visitCareDetailedMoneyText28.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText28.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText28.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText28.setMaxLength(8);

      addVisitCareDetailedMoneyText28();
    }
    return visitCareDetailedMoneyText28;

  }

  /**
   * 金額ラベル28を取得します。
   * @return 金額ラベル28
   */
  public ACLabel getVisitCareDetailedMoneyLabel28(){
    if(visitCareDetailedMoneyLabel28==null){

      visitCareDetailedMoneyLabel28 = new ACLabel();

      visitCareDetailedMoneyLabel28.setText("円");

      addVisitCareDetailedMoneyLabel28();
    }
    return visitCareDetailedMoneyLabel28;

  }

  /**
   * （２０）管理療養費パネル）を取得します。
   * @return （２０）管理療養費パネル）
   */
  public ACPanel getVisitCareDetailed20Panel(){
    if(visitCareDetailed20Panel==null){

      visitCareDetailed20Panel = new ACPanel();

      addVisitCareDetailed20Panel();
    }
    return visitCareDetailed20Panel;

  }

  /**
   * 管理療養費・グループを取得します。
   * @return 管理療養費・グループ
   */
  public ACGroupBox getVisitCareDetailed20Frame(){
    if(visitCareDetailed20Frame==null){

      visitCareDetailed20Frame = new ACGroupBox();

      visitCareDetailed20Frame.setText("管理療養費");

      visitCareDetailed20Frame.setLayout(getVisitCareDetailed20FrameLayout());

      addVisitCareDetailed20Frame();
    }
    return visitCareDetailed20Frame;

  }

  /**
   * 管理療養費・グループ・レイアウトを取得します。
   * @return 管理療養費・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailed20FrameLayout(){
    if(visitCareDetailed20FrameLayout==null){

      visitCareDetailed20FrameLayout = new VRLayout();

      visitCareDetailed20FrameLayout.setAutoWrap(false);

      visitCareDetailed20FrameLayout.setHgap(4);

      visitCareDetailed20FrameLayout.setLabelMargin(2);

      visitCareDetailed20FrameLayout.setVgap(4);

      addVisitCareDetailed20FrameLayout();
    }
    return visitCareDetailed20FrameLayout;

  }

  /**
   * ２１）管理療養費を取得します。
   * @return ２１）管理療養費
   */
  public ACLabel getVisitCareDetailed21label(){
    if(visitCareDetailed21label==null){

      visitCareDetailed21label = new ACLabel();

      visitCareDetailed21label.setText("（21）管理療養費");

      addVisitCareDetailed21label();
    }
    return visitCareDetailed21label;

  }

  /**
   * 療養管理費・コンテナを取得します。
   * @return 療養管理費・コンテナ
   */
  public ACLabelContainer getVisitCareDetailed21Contena(){
    if(visitCareDetailed21Contena==null){

      visitCareDetailed21Contena = new ACLabelContainer();

      visitCareDetailed21Contena.setLayout(getVisitCareDetailed21ContenaLayout());

      addVisitCareDetailed21Contena();
    }
    return visitCareDetailed21Contena;

  }

  /**
   * 療養管理費・コンテナ・レイアウトを取得します。
   * @return 療養管理費・コンテナ・レイアウト
   */
  public VRLayout getVisitCareDetailed21ContenaLayout(){
    if(visitCareDetailed21ContenaLayout==null){

      visitCareDetailed21ContenaLayout = new VRLayout();

      visitCareDetailed21ContenaLayout.setAutoWrap(false);

      visitCareDetailed21ContenaLayout.setHgap(4);

      visitCareDetailed21ContenaLayout.setLabelMargin(2);

      visitCareDetailed21ContenaLayout.setVgap(4);

      addVisitCareDetailed21ContenaLayout();
    }
    return visitCareDetailed21ContenaLayout;

  }

  /**
   * 金額テキスト29を取得します。
   * @return 金額テキスト29
   */
  public ACTextField getVisitCareDetailedMoneyText29(){
    if(visitCareDetailedMoneyText29==null){

      visitCareDetailedMoneyText29 = new ACTextField();

      visitCareDetailedMoneyText29.setBindPath("1301073");

      visitCareDetailedMoneyText29.setColumns(8);

      visitCareDetailedMoneyText29.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText29.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText29.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText29.setMaxLength(8);

      addVisitCareDetailedMoneyText29();
    }
    return visitCareDetailedMoneyText29;

  }

  /**
   * 金額ラベル29を取得します。
   * @return 金額ラベル29
   */
  public ACLabel getVisitCareDetailedMoneyLabel29(){
    if(visitCareDetailedMoneyLabel29==null){

      visitCareDetailedMoneyLabel29 = new ACLabel();

      visitCareDetailedMoneyLabel29.setText("＋");

      addVisitCareDetailedMoneyLabel29();
    }
    return visitCareDetailedMoneyLabel29;

  }

  /**
   * 金額テキスト追加を取得します。
   * @return 金額テキスト追加
   */
  public ACTextField getVisitCareDetailedMoneyText29Insert(){
    if(visitCareDetailedMoneyText29Insert==null){

      visitCareDetailedMoneyText29Insert = new ACTextField();

      visitCareDetailedMoneyText29Insert.setBindPath("1301074");

      visitCareDetailedMoneyText29Insert.setColumns(8);

      visitCareDetailedMoneyText29Insert.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText29Insert.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText29Insert.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText29Insert.setMaxLength(8);

      addVisitCareDetailedMoneyText29Insert();
    }
    return visitCareDetailedMoneyText29Insert;

  }

  /**
   * 金額ラベル追加を取得します。
   * @return 金額ラベル追加
   */
  public ACLabel getVisitCareDetailedMoneyLabel29Insert(){
    if(visitCareDetailedMoneyLabel29Insert==null){

      visitCareDetailedMoneyLabel29Insert = new ACLabel();

      visitCareDetailedMoneyLabel29Insert.setText("×");

      addVisitCareDetailedMoneyLabel29Insert();
    }
    return visitCareDetailedMoneyLabel29Insert;

  }

  /**
   * 日数テキスト7を取得します。
   * @return 日数テキスト7
   */
  public ACTextField getVisitCareDetailedDayText7(){
    if(visitCareDetailedDayText7==null){

      visitCareDetailedDayText7 = new ACTextField();

      visitCareDetailedDayText7.setBindPath("1301075");

      visitCareDetailedDayText7.setColumns(2);

      visitCareDetailedDayText7.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedDayText7.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedDayText7.setIMEMode(InputSubset.LATIN);

      visitCareDetailedDayText7.setMaxLength(2);

      addVisitCareDetailedDayText7();
    }
    return visitCareDetailedDayText7;

  }

  /**
   * 日数ラベル7を取得します。
   * @return 日数ラベル7
   */
  public ACLabel getVisitCareDetailedDayLabel7(){
    if(visitCareDetailedDayLabel7==null){

      visitCareDetailedDayLabel7 = new ACLabel();

      visitCareDetailedDayLabel7.setText("日 ");

      addVisitCareDetailedDayLabel7();
    }
    return visitCareDetailedDayLabel7;

  }

  /**
   * 金額テキスト30を取得します。
   * @return 金額テキスト30
   */
  public ACTextField getVisitCareDetailedMoneyText30(){
    if(visitCareDetailedMoneyText30==null){

      visitCareDetailedMoneyText30 = new ACTextField();

      visitCareDetailedMoneyText30.setBindPath("1301076");

      visitCareDetailedMoneyText30.setColumns(8);

      visitCareDetailedMoneyText30.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText30.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText30.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText30.setMaxLength(10);

      addVisitCareDetailedMoneyText30();
    }
    return visitCareDetailedMoneyText30;

  }

  /**
   * 金額ラベル30を取得します。
   * @return 金額ラベル30
   */
  public ACLabel getVisitCareDetailedMoneyLabel30(){
    if(visitCareDetailedMoneyLabel30==null){

      visitCareDetailedMoneyLabel30 = new ACLabel();

      visitCareDetailedMoneyLabel30.setText("円 ");

      addVisitCareDetailedMoneyLabel30();
    }
    return visitCareDetailedMoneyLabel30;

  }

  /**
   * 金額テキスト31を取得します。
   * @return 金額テキスト31
   */
  public ACTextField getVisitCareDetailedMoneyText31(){
    if(visitCareDetailedMoneyText31==null){

      visitCareDetailedMoneyText31 = new ACTextField();

      visitCareDetailedMoneyText31.setBindPath("1301077");

      visitCareDetailedMoneyText31.setColumns(8);

      visitCareDetailedMoneyText31.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText31.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText31.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText31.setMaxLength(8);

      addVisitCareDetailedMoneyText31();
    }
    return visitCareDetailedMoneyText31;

  }

  /**
   * 金額ラベル31を取得します。
   * @return 金額ラベル31
   */
  public ACLabel getVisitCareDetailedMoneyLabel31(){
    if(visitCareDetailedMoneyLabel31==null){

      visitCareDetailedMoneyLabel31 = new ACLabel();

      visitCareDetailedMoneyLabel31.setText("円 ");

      addVisitCareDetailedMoneyLabel31();
    }
    return visitCareDetailedMoneyLabel31;

  }

  /**
   * 金額テキスト32を取得します。
   * @return 金額テキスト32
   */
  public ACTextField getVisitCareDetailedMoneyText32(){
    if(visitCareDetailedMoneyText32==null){

      visitCareDetailedMoneyText32 = new ACTextField();

      visitCareDetailedMoneyText32.setBindPath("1301078");

      visitCareDetailedMoneyText32.setColumns(8);

      visitCareDetailedMoneyText32.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText32.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText32.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText32.setMaxLength(8);

      addVisitCareDetailedMoneyText32();
    }
    return visitCareDetailedMoneyText32;

  }

  /**
   * 金額ラベル32を取得します。
   * @return 金額ラベル32
   */
  public ACLabel getVisitCareDetailedMoneyLabel32(){
    if(visitCareDetailedMoneyLabel32==null){

      visitCareDetailedMoneyLabel32 = new ACLabel();

      visitCareDetailedMoneyLabel32.setText("円");

      addVisitCareDetailedMoneyLabel32();
    }
    return visitCareDetailedMoneyLabel32;

  }

  /**
   * ２２）管理療養費の加算を取得します。
   * @return ２２）管理療養費の加算
   */
  public ACLabel getVisitCareDetailed22Label(){
    if(visitCareDetailed22Label==null){

      visitCareDetailed22Label = new ACLabel();

      visitCareDetailed22Label.setText("（22）管理療養費の加算");

      addVisitCareDetailed22Label();
    }
    return visitCareDetailed22Label;

  }

  /**
   * ２３）－２４・コンテナを取得します。
   * @return ２３）－２４・コンテナ
   */
  public ACLabelContainer getVisitCareDetailed23Conatena(){
    if(visitCareDetailed23Conatena==null){

      visitCareDetailed23Conatena = new ACLabelContainer();

      addVisitCareDetailed23Conatena();
    }
    return visitCareDetailed23Conatena;

  }

  /**
   * ２３）－２４を取得します。
   * @return ２３）－２４
   */
  public ACLabel getVisitCareDetailed23Label(){
    if(visitCareDetailed23Label==null){

      visitCareDetailed23Label = new ACLabel();

      visitCareDetailed23Label.setText("（23）　２４　　　　　　　　　　　　　");

      addVisitCareDetailed23Label();
    }
    return visitCareDetailed23Label;

  }

  /**
   * 金額テキスト36を取得します。
   * @return 金額テキスト36
   */
  public ACTextField getVisitCareDetailedMoneyText36(){
    if(visitCareDetailedMoneyText36==null){

      visitCareDetailedMoneyText36 = new ACTextField();

      visitCareDetailedMoneyText36.setBindPath("1301079");

      visitCareDetailedMoneyText36.setColumns(8);

      visitCareDetailedMoneyText36.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText36.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText36.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText36.setMaxLength(8);

      addVisitCareDetailedMoneyText36();
    }
    return visitCareDetailedMoneyText36;

  }

  /**
   * 金額ラベル36を取得します。
   * @return 金額ラベル36
   */
  public ACLabel getVisitCareDetailedMoneyLabel36(){
    if(visitCareDetailedMoneyLabel36==null){

      visitCareDetailedMoneyLabel36 = new ACLabel();

      visitCareDetailedMoneyLabel36.setText("円 ");

      addVisitCareDetailedMoneyLabel36();
    }
    return visitCareDetailedMoneyLabel36;

  }

  /**
   * 金額テキスト37を取得します。
   * @return 金額テキスト37
   */
  public ACTextField getVisitCareDetailedMoneyText37(){
    if(visitCareDetailedMoneyText37==null){

      visitCareDetailedMoneyText37 = new ACTextField();

      visitCareDetailedMoneyText37.setBindPath("1301080");

      visitCareDetailedMoneyText37.setColumns(8);

      visitCareDetailedMoneyText37.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText37.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText37.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText37.setMaxLength(8);

      addVisitCareDetailedMoneyText37();
    }
    return visitCareDetailedMoneyText37;

  }

  /**
   * 金額ラベル37を取得します。
   * @return 金額ラベル37
   */
  public ACLabel getVisitCareDetailedMoneyLabel37(){
    if(visitCareDetailedMoneyLabel37==null){

      visitCareDetailedMoneyLabel37 = new ACLabel();

      visitCareDetailedMoneyLabel37.setText("円 ");

      addVisitCareDetailedMoneyLabel37();
    }
    return visitCareDetailedMoneyLabel37;

  }

  /**
   * 金額テキスト38を取得します。
   * @return 金額テキスト38
   */
  public ACTextField getVisitCareDetailedMoneyText38(){
    if(visitCareDetailedMoneyText38==null){

      visitCareDetailedMoneyText38 = new ACTextField();

      visitCareDetailedMoneyText38.setBindPath("1301081");

      visitCareDetailedMoneyText38.setColumns(8);

      visitCareDetailedMoneyText38.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText38.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText38.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText38.setMaxLength(8);

      addVisitCareDetailedMoneyText38();
    }
    return visitCareDetailedMoneyText38;

  }

  /**
   * 金額ラベル38を取得します。
   * @return 金額ラベル38
   */
  public ACLabel getVisitCareDetailedMoneyLabel38(){
    if(visitCareDetailedMoneyLabel38==null){

      visitCareDetailedMoneyLabel38 = new ACLabel();

      visitCareDetailedMoneyLabel38.setText("円");

      addVisitCareDetailedMoneyLabel38();
    }
    return visitCareDetailedMoneyLabel38;

  }

  /**
   * ２４）－重症・コンテナを取得します。
   * @return ２４）－重症・コンテナ
   */
  public ACLabelContainer getVisitCareDetailed24Contena(){
    if(visitCareDetailed24Contena==null){

      visitCareDetailed24Contena = new ACLabelContainer();

      addVisitCareDetailed24Contena();
    }
    return visitCareDetailed24Contena;

  }

  /**
   * ２４）－重症を取得します。
   * @return ２４）－重症
   */
  public ACLabel getVisitCareDetailed24Label(){
    if(visitCareDetailed24Label==null){

      visitCareDetailed24Label = new ACLabel();

      visitCareDetailed24Label.setText("（24）　重症　　　　　　　　　　　　　");

      addVisitCareDetailed24Label();
    }
    return visitCareDetailed24Label;

  }

  /**
   * 金額テキスト39を取得します。
   * @return 金額テキスト39
   */
  public ACTextField getVisitCareDetailedMoneyText39(){
    if(visitCareDetailedMoneyText39==null){

      visitCareDetailedMoneyText39 = new ACTextField();

      visitCareDetailedMoneyText39.setBindPath("1301082");

      visitCareDetailedMoneyText39.setColumns(8);

      visitCareDetailedMoneyText39.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText39.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText39.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText39.setMaxLength(8);

      addVisitCareDetailedMoneyText39();
    }
    return visitCareDetailedMoneyText39;

  }

  /**
   * 金額ラベル39を取得します。
   * @return 金額ラベル39
   */
  public ACLabel getVisitCareDetailedMoneyLabel39(){
    if(visitCareDetailedMoneyLabel39==null){

      visitCareDetailedMoneyLabel39 = new ACLabel();

      visitCareDetailedMoneyLabel39.setText("円 ");

      addVisitCareDetailedMoneyLabel39();
    }
    return visitCareDetailedMoneyLabel39;

  }

  /**
   * 金額テキスト40を取得します。
   * @return 金額テキスト40
   */
  public ACTextField getVisitCareDetailedMoneyText40(){
    if(visitCareDetailedMoneyText40==null){

      visitCareDetailedMoneyText40 = new ACTextField();

      visitCareDetailedMoneyText40.setBindPath("1301083");

      visitCareDetailedMoneyText40.setColumns(8);

      visitCareDetailedMoneyText40.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText40.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText40.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText40.setMaxLength(8);

      addVisitCareDetailedMoneyText40();
    }
    return visitCareDetailedMoneyText40;

  }

  /**
   * 金額ラベル40を取得します。
   * @return 金額ラベル40
   */
  public ACLabel getVisitCareDetailedMoneyLabel40(){
    if(visitCareDetailedMoneyLabel40==null){

      visitCareDetailedMoneyLabel40 = new ACLabel();

      visitCareDetailedMoneyLabel40.setText("円 ");

      addVisitCareDetailedMoneyLabel40();
    }
    return visitCareDetailedMoneyLabel40;

  }

  /**
   * 金額テキスト41を取得します。
   * @return 金額テキスト41
   */
  public ACTextField getVisitCareDetailedMoneyText41(){
    if(visitCareDetailedMoneyText41==null){

      visitCareDetailedMoneyText41 = new ACTextField();

      visitCareDetailedMoneyText41.setBindPath("1301084");

      visitCareDetailedMoneyText41.setColumns(8);

      visitCareDetailedMoneyText41.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText41.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText41.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText41.setMaxLength(8);

      addVisitCareDetailedMoneyText41();
    }
    return visitCareDetailedMoneyText41;

  }

  /**
   * 金額ラベル41を取得します。
   * @return 金額ラベル41
   */
  public ACLabel getVisitCareDetailedMoneyLabel41(){
    if(visitCareDetailedMoneyLabel41==null){

      visitCareDetailedMoneyLabel41 = new ACLabel();

      visitCareDetailedMoneyLabel41.setText("円");

      addVisitCareDetailedMoneyLabel41();
    }
    return visitCareDetailedMoneyLabel41;

  }

  /**
   * ２５）－退院・コンテナを取得します。
   * @return ２５）－退院・コンテナ
   */
  public ACLabelContainer getVisitCareDetailed25Contena(){
    if(visitCareDetailed25Contena==null){

      visitCareDetailed25Contena = new ACLabelContainer();

      addVisitCareDetailed25Contena();
    }
    return visitCareDetailed25Contena;

  }

  /**
   * ２５）－退院を取得します。
   * @return ２５）－退院
   */
  public ACLabel getVisitCareDetailed25Label(){
    if(visitCareDetailed25Label==null){

      visitCareDetailed25Label = new ACLabel();

      visitCareDetailed25Label.setText("（25）　退院　　　　　　　　　　　　　");

      addVisitCareDetailed25Label();
    }
    return visitCareDetailed25Label;

  }

  /**
   * 金額テキスト42を取得します。
   * @return 金額テキスト42
   */
  public ACTextField getVisitCareDetailedMoneyText42(){
    if(visitCareDetailedMoneyText42==null){

      visitCareDetailedMoneyText42 = new ACTextField();

      visitCareDetailedMoneyText42.setBindPath("1301085");

      visitCareDetailedMoneyText42.setColumns(8);

      visitCareDetailedMoneyText42.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText42.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText42.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText42.setMaxLength(8);

      addVisitCareDetailedMoneyText42();
    }
    return visitCareDetailedMoneyText42;

  }

  /**
   * 金額ラベル42を取得します。
   * @return 金額ラベル42
   */
  public ACLabel getVisitCareDetailedMoneyLabel42(){
    if(visitCareDetailedMoneyLabel42==null){

      visitCareDetailedMoneyLabel42 = new ACLabel();

      visitCareDetailedMoneyLabel42.setText("円 ");

      addVisitCareDetailedMoneyLabel42();
    }
    return visitCareDetailedMoneyLabel42;

  }

  /**
   * 金額テキスト43を取得します。
   * @return 金額テキスト43
   */
  public ACTextField getVisitCareDetailedMoneyText43(){
    if(visitCareDetailedMoneyText43==null){

      visitCareDetailedMoneyText43 = new ACTextField();

      visitCareDetailedMoneyText43.setBindPath("1301086");

      visitCareDetailedMoneyText43.setColumns(8);

      visitCareDetailedMoneyText43.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText43.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText43.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText43.setMaxLength(8);

      addVisitCareDetailedMoneyText43();
    }
    return visitCareDetailedMoneyText43;

  }

  /**
   * 金額ラベル43を取得します。
   * @return 金額ラベル43
   */
  public ACLabel getVisitCareDetailedMoneyLabel43(){
    if(visitCareDetailedMoneyLabel43==null){

      visitCareDetailedMoneyLabel43 = new ACLabel();

      visitCareDetailedMoneyLabel43.setText("円 ");

      addVisitCareDetailedMoneyLabel43();
    }
    return visitCareDetailedMoneyLabel43;

  }

  /**
   * 金額テキスト44を取得します。
   * @return 金額テキスト44
   */
  public ACTextField getVisitCareDetailedMoneyText44(){
    if(visitCareDetailedMoneyText44==null){

      visitCareDetailedMoneyText44 = new ACTextField();

      visitCareDetailedMoneyText44.setBindPath("1301087");

      visitCareDetailedMoneyText44.setColumns(8);

      visitCareDetailedMoneyText44.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText44.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText44.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText44.setMaxLength(8);

      addVisitCareDetailedMoneyText44();
    }
    return visitCareDetailedMoneyText44;

  }

  /**
   * 金額ラベル44を取得します。
   * @return 金額ラベル44
   */
  public ACLabel getVisitCareDetailedMoneyLabel44(){
    if(visitCareDetailedMoneyLabel44==null){

      visitCareDetailedMoneyLabel44 = new ACLabel();

      visitCareDetailedMoneyLabel44.setText("円");

      addVisitCareDetailedMoneyLabel44();
    }
    return visitCareDetailedMoneyLabel44;

  }

  /**
   * 情報提供療養費・グループを取得します。
   * @return 情報提供療養費・グループ
   */
  public ACGroupBox getVisitCareDetailed30Frame(){
    if(visitCareDetailed30Frame==null){

      visitCareDetailed30Frame = new ACGroupBox();

      visitCareDetailed30Frame.setText("（30）情報提供療養費");

      visitCareDetailed30Frame.setLayout(getVisitCareDetailed30FrameLayout());

      addVisitCareDetailed30Frame();
    }
    return visitCareDetailed30Frame;

  }

  /**
   * 情報提供療養費・グループ・レイアウトを取得します。
   * @return 情報提供療養費・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailed30FrameLayout(){
    if(visitCareDetailed30FrameLayout==null){

      visitCareDetailed30FrameLayout = new VRLayout();

      visitCareDetailed30FrameLayout.setAutoWrap(false);

      visitCareDetailed30FrameLayout.setHgap(4);

      visitCareDetailed30FrameLayout.setLabelMargin(2);

      visitCareDetailed30FrameLayout.setVgap(4);

      addVisitCareDetailed30FrameLayout();
    }
    return visitCareDetailed30FrameLayout;

  }

  /**
   * 金額テキスト45を取得します。
   * @return 金額テキスト45
   */
  public ACTextField getVisitCareDetailedMoneyText45(){
    if(visitCareDetailedMoneyText45==null){

      visitCareDetailedMoneyText45 = new ACTextField();

      visitCareDetailedMoneyText45.setBindPath("1301088");

      visitCareDetailedMoneyText45.setColumns(8);

      visitCareDetailedMoneyText45.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText45.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText45.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText45.setMaxLength(8);

      addVisitCareDetailedMoneyText45();
    }
    return visitCareDetailedMoneyText45;

  }

  /**
   * 金額テキスト45コンテナを取得します。
   * @return 金額テキスト45コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMoneyText45Container(){
    if(visitCareDetailedMoneyText45Container==null){
      visitCareDetailedMoneyText45Container = new ACLabelContainer();
      visitCareDetailedMoneyText45Container.setFollowChildEnabled(true);
      visitCareDetailedMoneyText45Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMoneyText45Container.add(getVisitCareDetailedMoneyText45(), null);
    }
    return visitCareDetailedMoneyText45Container;
  }

  /**
   * 金額ラベル45を取得します。
   * @return 金額ラベル45
   */
  public ACLabel getVisitCareDetailedMoneyLabel45(){
    if(visitCareDetailedMoneyLabel45==null){

      visitCareDetailedMoneyLabel45 = new ACLabel();

      visitCareDetailedMoneyLabel45.setText("円");

      addVisitCareDetailedMoneyLabel45();
    }
    return visitCareDetailedMoneyLabel45;

  }

  /**
   * 金額テキスト46を取得します。
   * @return 金額テキスト46
   */
  public ACTextField getVisitCareDetailedMoneyText46(){
    if(visitCareDetailedMoneyText46==null){

      visitCareDetailedMoneyText46 = new ACTextField();

      visitCareDetailedMoneyText46.setBindPath("1301089");

      visitCareDetailedMoneyText46.setColumns(8);

      visitCareDetailedMoneyText46.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText46.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText46.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText46.setMaxLength(8);

      addVisitCareDetailedMoneyText46();
    }
    return visitCareDetailedMoneyText46;

  }

  /**
   * 金額テキスト46コンテナを取得します。
   * @return 金額テキスト46コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMoneyText46Container(){
    if(visitCareDetailedMoneyText46Container==null){
      visitCareDetailedMoneyText46Container = new ACLabelContainer();
      visitCareDetailedMoneyText46Container.setFollowChildEnabled(true);
      visitCareDetailedMoneyText46Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMoneyText46Container.add(getVisitCareDetailedMoneyText46(), null);
    }
    return visitCareDetailedMoneyText46Container;
  }

  /**
   * 金額ラベル46を取得します。
   * @return 金額ラベル46
   */
  public ACLabel getVisitCareDetailedMoneyLabel46(){
    if(visitCareDetailedMoneyLabel46==null){

      visitCareDetailedMoneyLabel46 = new ACLabel();

      visitCareDetailedMoneyLabel46.setText("円");

      addVisitCareDetailedMoneyLabel46();
    }
    return visitCareDetailedMoneyLabel46;

  }

  /**
   * 金額テキスト47を取得します。
   * @return 金額テキスト47
   */
  public ACTextField getVisitCareDetailedMoneyText47(){
    if(visitCareDetailedMoneyText47==null){

      visitCareDetailedMoneyText47 = new ACTextField();

      visitCareDetailedMoneyText47.setBindPath("1301090");

      visitCareDetailedMoneyText47.setColumns(8);

      visitCareDetailedMoneyText47.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText47.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText47.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText47.setMaxLength(8);

      addVisitCareDetailedMoneyText47();
    }
    return visitCareDetailedMoneyText47;

  }

  /**
   * 金額テキスト47コンテナを取得します。
   * @return 金額テキスト47コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMoneyText47Container(){
    if(visitCareDetailedMoneyText47Container==null){
      visitCareDetailedMoneyText47Container = new ACLabelContainer();
      visitCareDetailedMoneyText47Container.setFollowChildEnabled(true);
      visitCareDetailedMoneyText47Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMoneyText47Container.add(getVisitCareDetailedMoneyText47(), null);
    }
    return visitCareDetailedMoneyText47Container;
  }

  /**
   * 金額ラベル47を取得します。
   * @return 金額ラベル47
   */
  public ACLabel getVisitCareDetailedMoneyLabel47(){
    if(visitCareDetailedMoneyLabel47==null){

      visitCareDetailedMoneyLabel47 = new ACLabel();

      visitCareDetailedMoneyLabel47.setText("円");

      addVisitCareDetailedMoneyLabel47();
    }
    return visitCareDetailedMoneyLabel47;

  }

  /**
   * ターミナルケア療養費・グループを取得します。
   * @return ターミナルケア療養費・グループ
   */
  public ACGroupBox getVisitCareDetailed40Frame(){
    if(visitCareDetailed40Frame==null){

      visitCareDetailed40Frame = new ACGroupBox();

      visitCareDetailed40Frame.setText("（40）ターミナルケア療養費");

      visitCareDetailed40Frame.setLayout(getVisitCareDetailed40FrameLayout());

      addVisitCareDetailed40Frame();
    }
    return visitCareDetailed40Frame;

  }

  /**
   * ターミナルケア療養費・グループ・レイアウトを取得します。
   * @return ターミナルケア療養費・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailed40FrameLayout(){
    if(visitCareDetailed40FrameLayout==null){

      visitCareDetailed40FrameLayout = new VRLayout();

      visitCareDetailed40FrameLayout.setAutoWrap(false);

      visitCareDetailed40FrameLayout.setHgap(4);

      visitCareDetailed40FrameLayout.setLabelMargin(2);

      visitCareDetailed40FrameLayout.setVgap(4);

      addVisitCareDetailed40FrameLayout();
    }
    return visitCareDetailed40FrameLayout;

  }

  /**
   * 金額テキスト48を取得します。
   * @return 金額テキスト48
   */
  public ACTextField getVisitCareDetailedMoneyText48(){
    if(visitCareDetailedMoneyText48==null){

      visitCareDetailedMoneyText48 = new ACTextField();

      visitCareDetailedMoneyText48.setBindPath("1301091");

      visitCareDetailedMoneyText48.setColumns(8);

      visitCareDetailedMoneyText48.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText48.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText48.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText48.setMaxLength(8);

      addVisitCareDetailedMoneyText48();
    }
    return visitCareDetailedMoneyText48;

  }

  /**
   * 金額テキスト48コンテナを取得します。
   * @return 金額テキスト48コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMoneyText48Container(){
    if(visitCareDetailedMoneyText48Container==null){
      visitCareDetailedMoneyText48Container = new ACLabelContainer();
      visitCareDetailedMoneyText48Container.setFollowChildEnabled(true);
      visitCareDetailedMoneyText48Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMoneyText48Container.add(getVisitCareDetailedMoneyText48(), null);
    }
    return visitCareDetailedMoneyText48Container;
  }

  /**
   * 金額ラベル48を取得します。
   * @return 金額ラベル48
   */
  public ACLabel getVisitCareDetailedMoneyLabel48(){
    if(visitCareDetailedMoneyLabel48==null){

      visitCareDetailedMoneyLabel48 = new ACLabel();

      visitCareDetailedMoneyLabel48.setText("円");

      addVisitCareDetailedMoneyLabel48();
    }
    return visitCareDetailedMoneyLabel48;

  }

  /**
   * 金額テキスト49を取得します。
   * @return 金額テキスト49
   */
  public ACTextField getVisitCareDetailedMoneyText49(){
    if(visitCareDetailedMoneyText49==null){

      visitCareDetailedMoneyText49 = new ACTextField();

      visitCareDetailedMoneyText49.setBindPath("1301092");

      visitCareDetailedMoneyText49.setColumns(8);

      visitCareDetailedMoneyText49.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText49.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText49.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText49.setMaxLength(8);

      addVisitCareDetailedMoneyText49();
    }
    return visitCareDetailedMoneyText49;

  }

  /**
   * 金額テキスト49コンテナを取得します。
   * @return 金額テキスト49コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMoneyText49Container(){
    if(visitCareDetailedMoneyText49Container==null){
      visitCareDetailedMoneyText49Container = new ACLabelContainer();
      visitCareDetailedMoneyText49Container.setFollowChildEnabled(true);
      visitCareDetailedMoneyText49Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMoneyText49Container.add(getVisitCareDetailedMoneyText49(), null);
    }
    return visitCareDetailedMoneyText49Container;
  }

  /**
   * 金額ラベル49を取得します。
   * @return 金額ラベル49
   */
  public ACLabel getVisitCareDetailedMoneyLabel49(){
    if(visitCareDetailedMoneyLabel49==null){

      visitCareDetailedMoneyLabel49 = new ACLabel();

      visitCareDetailedMoneyLabel49.setText("円");

      addVisitCareDetailedMoneyLabel49();
    }
    return visitCareDetailedMoneyLabel49;

  }

  /**
   * 金額テキスト50を取得します。
   * @return 金額テキスト50
   */
  public ACTextField getVisitCareDetailedMoneyText50(){
    if(visitCareDetailedMoneyText50==null){

      visitCareDetailedMoneyText50 = new ACTextField();

      visitCareDetailedMoneyText50.setBindPath("1301093");

      visitCareDetailedMoneyText50.setColumns(8);

      visitCareDetailedMoneyText50.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText50.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText50.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText50.setMaxLength(8);

      addVisitCareDetailedMoneyText50();
    }
    return visitCareDetailedMoneyText50;

  }

  /**
   * 金額テキスト50コンテナを取得します。
   * @return 金額テキスト50コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMoneyText50Container(){
    if(visitCareDetailedMoneyText50Container==null){
      visitCareDetailedMoneyText50Container = new ACLabelContainer();
      visitCareDetailedMoneyText50Container.setFollowChildEnabled(true);
      visitCareDetailedMoneyText50Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMoneyText50Container.add(getVisitCareDetailedMoneyText50(), null);
    }
    return visitCareDetailedMoneyText50Container;
  }

  /**
   * 金額ラベル50を取得します。
   * @return 金額ラベル50
   */
  public ACLabel getVisitCareDetailedMoneyLabel50(){
    if(visitCareDetailedMoneyLabel50==null){

      visitCareDetailedMoneyLabel50 = new ACLabel();

      visitCareDetailedMoneyLabel50.setText("円");

      addVisitCareDetailedMoneyLabel50();
    }
    return visitCareDetailedMoneyLabel50;

  }

  /**
   * 金額テキスト61を取得します。
   * @return 金額テキスト61
   */
  public ACTextField getVisitCareDetailedMoneyText61(){
    if(visitCareDetailedMoneyText61==null){

      visitCareDetailedMoneyText61 = new ACTextField();

      visitCareDetailedMoneyText61.setBindPath("1301158");

      visitCareDetailedMoneyText61.setColumns(8);

      visitCareDetailedMoneyText61.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText61.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText61.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText61.setMaxLength(8);

      addVisitCareDetailedMoneyText61();
    }
    return visitCareDetailedMoneyText61;

  }

  /**
   * 金額テキスト61コンテナを取得します。
   * @return 金額テキスト61コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMoneyText61Container(){
    if(visitCareDetailedMoneyText61Container==null){
      visitCareDetailedMoneyText61Container = new ACLabelContainer();
      visitCareDetailedMoneyText61Container.setFollowChildEnabled(true);
      visitCareDetailedMoneyText61Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMoneyText61Container.add(getVisitCareDetailedMoneyText61(), null);
    }
    return visitCareDetailedMoneyText61Container;
  }

  /**
   * 金額ラベル61を取得します。
   * @return 金額ラベル61
   */
  public ACLabel getVisitCareDetailedMoneyLabel61(){
    if(visitCareDetailedMoneyLabel61==null){

      visitCareDetailedMoneyLabel61 = new ACLabel();

      visitCareDetailedMoneyLabel61.setText("円");

      addVisitCareDetailedMoneyLabel61();
    }
    return visitCareDetailedMoneyLabel61;

  }

  /**
   * 金額テキスト62を取得します。
   * @return 金額テキスト62
   */
  public ACTextField getVisitCareDetailedMoneyText62(){
    if(visitCareDetailedMoneyText62==null){

      visitCareDetailedMoneyText62 = new ACTextField();

      visitCareDetailedMoneyText62.setBindPath("1301159");

      visitCareDetailedMoneyText62.setColumns(8);

      visitCareDetailedMoneyText62.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText62.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText62.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText62.setMaxLength(8);

      addVisitCareDetailedMoneyText62();
    }
    return visitCareDetailedMoneyText62;

  }

  /**
   * 金額テキスト62コンテナを取得します。
   * @return 金額テキスト62コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMoneyText62Container(){
    if(visitCareDetailedMoneyText62Container==null){
      visitCareDetailedMoneyText62Container = new ACLabelContainer();
      visitCareDetailedMoneyText62Container.setFollowChildEnabled(true);
      visitCareDetailedMoneyText62Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMoneyText62Container.add(getVisitCareDetailedMoneyText62(), null);
    }
    return visitCareDetailedMoneyText62Container;
  }

  /**
   * 金額ラベル62を取得します。
   * @return 金額ラベル62
   */
  public ACLabel getVisitCareDetailedMoneyLabel62(){
    if(visitCareDetailedMoneyLabel62==null){

      visitCareDetailedMoneyLabel62 = new ACLabel();

      visitCareDetailedMoneyLabel62.setText("円");

      addVisitCareDetailedMoneyLabel62();
    }
    return visitCareDetailedMoneyLabel62;

  }

  /**
   * 金額テキスト63を取得します。
   * @return 金額テキスト63
   */
  public ACTextField getVisitCareDetailedMoneyText63(){
    if(visitCareDetailedMoneyText63==null){

      visitCareDetailedMoneyText63 = new ACTextField();

      visitCareDetailedMoneyText63.setBindPath("1301160");

      visitCareDetailedMoneyText63.setColumns(8);

      visitCareDetailedMoneyText63.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedMoneyText63.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedMoneyText63.setIMEMode(InputSubset.LATIN);

      visitCareDetailedMoneyText63.setMaxLength(8);

      addVisitCareDetailedMoneyText63();
    }
    return visitCareDetailedMoneyText63;

  }

  /**
   * 金額テキスト63コンテナを取得します。
   * @return 金額テキスト63コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedMoneyText63Container(){
    if(visitCareDetailedMoneyText63Container==null){
      visitCareDetailedMoneyText63Container = new ACLabelContainer();
      visitCareDetailedMoneyText63Container.setFollowChildEnabled(true);
      visitCareDetailedMoneyText63Container.setVAlignment(VRLayout.CENTER);
      visitCareDetailedMoneyText63Container.add(getVisitCareDetailedMoneyText63(), null);
    }
    return visitCareDetailedMoneyText63Container;
  }

  /**
   * 金額ラベル63を取得します。
   * @return 金額ラベル63
   */
  public ACLabel getVisitCareDetailedMoneyLabel63(){
    if(visitCareDetailedMoneyLabel63==null){

      visitCareDetailedMoneyLabel63 = new ACLabel();

      visitCareDetailedMoneyLabel63.setText("円");

      addVisitCareDetailedMoneyLabel63();
    }
    return visitCareDetailedMoneyLabel63;

  }

  /**
   * 3パネル1を取得します。
   * @return 3パネル1
   */
  public ACPanel getVisitCareDetailedPoints3Panel1(){
    if(visitCareDetailedPoints3Panel1==null){

      visitCareDetailedPoints3Panel1 = new ACPanel();

      visitCareDetailedPoints3Panel1.setLayout(getVisitCareDetailedPoints3Panel1Layout());

      addVisitCareDetailedPoints3Panel1();
    }
    return visitCareDetailedPoints3Panel1;

  }

  /**
   * 3パネル1・レイアウトを取得します。
   * @return 3パネル1・レイアウト
   */
  public VRLayout getVisitCareDetailedPoints3Panel1Layout(){
    if(visitCareDetailedPoints3Panel1Layout==null){

      visitCareDetailedPoints3Panel1Layout = new VRLayout();

      visitCareDetailedPoints3Panel1Layout.setAutoWrap(false);

      visitCareDetailedPoints3Panel1Layout.setHgap(4);

      visitCareDetailedPoints3Panel1Layout.setLabelMargin(2);

      visitCareDetailedPoints3Panel1Layout.setVgap(4);

      addVisitCareDetailedPoints3Panel1Layout();
    }
    return visitCareDetailedPoints3Panel1Layout;

  }

  /**
   * 訪問領域を取得します。
   * @return 訪問領域
   */
  public ACPanel getVisitCareDetailedPoints3Homon(){
    if(visitCareDetailedPoints3Homon==null){

      visitCareDetailedPoints3Homon = new ACPanel();

      addVisitCareDetailedPoints3Homon();
    }
    return visitCareDetailedPoints3Homon;

  }

  /**
   * 訪問開始年月日を取得します。
   * @return 訪問開始年月日
   */
  public QkanDateTextField getVisitStart(){
    if(visitStart==null){

      visitStart = new QkanDateTextField();

      getVisitStartContainer().setText("訪問開始年月日");

      visitStart.setBindPath("1301094");

      visitStart.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      visitStart.setMaxLength(12);

      addVisitStart();
    }
    return visitStart;

  }

  /**
   * 訪問開始年月日コンテナを取得します。
   * @return 訪問開始年月日コンテナ
   */
  protected ACLabelContainer getVisitStartContainer(){
    if(visitStartContainer==null){
      visitStartContainer = new ACLabelContainer();
      visitStartContainer.setFollowChildEnabled(true);
      visitStartContainer.setVAlignment(VRLayout.CENTER);
      visitStartContainer.add(getVisitStart(), null);
    }
    return visitStartContainer;
  }

  /**
   * 訪問終了年月日を取得します。
   * @return 訪問終了年月日
   */
  public QkanDateTextField getVisitEnd(){
    if(visitEnd==null){

      visitEnd = new QkanDateTextField();

      getVisitEndContainer().setText("訪問終了年月日");

      visitEnd.setBindPath("HOMON_END_DATE");

      visitEnd.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      visitEnd.setMaxLength(12);

      addVisitEnd();
    }
    return visitEnd;

  }

  /**
   * 訪問終了年月日コンテナを取得します。
   * @return 訪問終了年月日コンテナ
   */
  protected ACLabelContainer getVisitEndContainer(){
    if(visitEndContainer==null){
      visitEndContainer = new ACLabelContainer();
      visitEndContainer.setFollowChildEnabled(true);
      visitEndContainer.setVAlignment(VRLayout.CENTER);
      visitEndContainer.add(getVisitEnd(), null);
    }
    return visitEndContainer;
  }

  /**
   * 時刻を取得します。
   * @return 時刻
   */
  public ACTimeTextField getVisitEndTime(){
    if(visitEndTime==null){

      visitEndTime = new ACTimeTextField();

      getVisitEndTimeContainer().setText("時刻");

      visitEndTime.setBindPath("HOMON_END_TIME");

      visitEndTime.setColumns(6);

      visitEndTime.setCharType(ACConstants.CHAR_TYPE_TIME_HOUR_MINUTE);

      visitEndTime.setMaxLength(6);

      addVisitEndTime();
    }
    return visitEndTime;

  }

  /**
   * 時刻コンテナを取得します。
   * @return 時刻コンテナ
   */
  protected ACLabelContainer getVisitEndTimeContainer(){
    if(visitEndTimeContainer==null){
      visitEndTimeContainer = new ACLabelContainer();
      visitEndTimeContainer.setFollowChildEnabled(true);
      visitEndTimeContainer.setVAlignment(VRLayout.CENTER);
      visitEndTimeContainer.add(getVisitEndTime(), null);
    }
    return visitEndTimeContainer;
  }

  /**
   * 訪問終了の状況を取得します。
   * @return 訪問終了の状況
   */
  public ACComboBox getVisitEndState(){
    if(visitEndState==null){

      visitEndState = new ACComboBox();

      getVisitEndStateContainer().setText("訪問終了の状況");

      visitEndState.setBindPath("1301099");

      visitEndState.setEditable(false);

      visitEndState.setModelBindPath("HOUMON_END_STATE");

      visitEndState.setRenderBindPath("CONTENT");

      visitEndState.setModel(getVisitEndStateModel());

      addVisitEndState();
    }
    return visitEndState;

  }

  /**
   * 訪問終了の状況コンテナを取得します。
   * @return 訪問終了の状況コンテナ
   */
  protected ACLabelContainer getVisitEndStateContainer(){
    if(visitEndStateContainer==null){
      visitEndStateContainer = new ACLabelContainer();
      visitEndStateContainer.setFollowChildEnabled(true);
      visitEndStateContainer.setVAlignment(VRLayout.CENTER);
      visitEndStateContainer.add(getVisitEndState(), null);
    }
    return visitEndStateContainer;
  }

  /**
   * 訪問終了の状況モデルを取得します。
   * @return 訪問終了の状況モデル
   */
  protected ACComboBoxModelAdapter getVisitEndStateModel(){
    if(visitEndStateModel==null){
      visitEndStateModel = new ACComboBoxModelAdapter();
      addVisitEndStateModel();
    }
    return visitEndStateModel;
  }

  /**
   * その他理由を取得します。
   * @return その他理由
   */
  public ACTextField getVisitEndStateEtc(){
    if(visitEndStateEtc==null){

      visitEndStateEtc = new ACTextField();

      getVisitEndStateEtcContainer().setText("その他");

      visitEndStateEtc.setBindPath("1301100");

      visitEndStateEtc.setLayout(getVisitEndStateEtcLayout());

      visitEndStateEtc.setColumns(15);

      visitEndStateEtc.setIMEMode(InputSubset.KANJI);

      visitEndStateEtc.setMaxLength(255);

      addVisitEndStateEtc();
    }
    return visitEndStateEtc;

  }

  /**
   * その他理由コンテナを取得します。
   * @return その他理由コンテナ
   */
  protected ACLabelContainer getVisitEndStateEtcContainer(){
    if(visitEndStateEtcContainer==null){
      visitEndStateEtcContainer = new ACLabelContainer();
      visitEndStateEtcContainer.setFollowChildEnabled(true);
      visitEndStateEtcContainer.setVAlignment(VRLayout.CENTER);
      visitEndStateEtcContainer.add(getVisitEndStateEtc(), null);
    }
    return visitEndStateEtcContainer;
  }

  /**
   * その他理由・レイアウトを取得します。
   * @return その他理由・レイアウト
   */
  public VRLayout getVisitEndStateEtcLayout(){
    if(visitEndStateEtcLayout==null){

      visitEndStateEtcLayout = new VRLayout();

      visitEndStateEtcLayout.setAutoWrap(false);

      visitEndStateEtcLayout.setHgrid(200);

      addVisitEndStateEtcLayout();
    }
    return visitEndStateEtcLayout;

  }

  /**
   * 死亡年月日を取得します。
   * @return 死亡年月日
   */
  public QkanDateTextField getDieDate(){
    if(dieDate==null){

      dieDate = new QkanDateTextField();

      getDieDateContainer().setText("死亡年月日");

      dieDate.setBindPath("DIE_DATE");

      dieDate.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      dieDate.setMaxLength(12);

      addDieDate();
    }
    return dieDate;

  }

  /**
   * 死亡年月日コンテナを取得します。
   * @return 死亡年月日コンテナ
   */
  protected ACLabelContainer getDieDateContainer(){
    if(dieDateContainer==null){
      dieDateContainer = new ACLabelContainer();
      dieDateContainer.setFollowChildEnabled(true);
      dieDateContainer.setVAlignment(VRLayout.CENTER);
      dieDateContainer.add(getDieDate(), null);
    }
    return dieDateContainer;
  }

  /**
   * 時刻を取得します。
   * @return 時刻
   */
  public ACTimeTextField getDieTime(){
    if(dieTime==null){

      dieTime = new ACTimeTextField();

      getDieTimeContainer().setText("時刻");

      dieTime.setBindPath("DIE_TIME");

      dieTime.setColumns(6);

      dieTime.setCharType(ACConstants.CHAR_TYPE_TIME_HOUR_MINUTE);

      dieTime.setMaxLength(6);

      addDieTime();
    }
    return dieTime;

  }

  /**
   * 時刻コンテナを取得します。
   * @return 時刻コンテナ
   */
  protected ACLabelContainer getDieTimeContainer(){
    if(dieTimeContainer==null){
      dieTimeContainer = new ACLabelContainer();
      dieTimeContainer.setFollowChildEnabled(true);
      dieTimeContainer.setVAlignment(VRLayout.CENTER);
      dieTimeContainer.add(getDieTime(), null);
    }
    return dieTimeContainer;
  }

  /**
   * 主治医の属する医療機関の名称を取得します。
   * @return 主治医の属する医療機関の名称
   */
  public ACTextField getMainDoctorOrgan(){
    if(mainDoctorOrgan==null){

      mainDoctorOrgan = new ACTextField();

      getMainDoctorOrganContainer().setText("主治医の属する医療機関の名称");

      mainDoctorOrgan.setBindPath("1301102");

      mainDoctorOrgan.setColumns(20);

      mainDoctorOrgan.setIMEMode(InputSubset.KANJI);

      mainDoctorOrgan.setMaxLength(65);

      addMainDoctorOrgan();
    }
    return mainDoctorOrgan;

  }

  /**
   * 主治医の属する医療機関の名称コンテナを取得します。
   * @return 主治医の属する医療機関の名称コンテナ
   */
  protected ACLabelContainer getMainDoctorOrganContainer(){
    if(mainDoctorOrganContainer==null){
      mainDoctorOrganContainer = new ACLabelContainer();
      mainDoctorOrganContainer.setFollowChildEnabled(true);
      mainDoctorOrganContainer.setVAlignment(VRLayout.CENTER);
      mainDoctorOrganContainer.add(getMainDoctorOrgan(), null);
    }
    return mainDoctorOrganContainer;
  }

  /**
   * 主治医の氏名を取得します。
   * @return 主治医の氏名
   */
  public ACTextField getMainDoctorName(){
    if(mainDoctorName==null){

      mainDoctorName = new ACTextField();

      getMainDoctorNameContainer().setText("主治医の氏名");

      mainDoctorName.setBindPath("1301103");

      mainDoctorName.setColumns(15);

      mainDoctorName.setIMEMode(InputSubset.KANJI);

      mainDoctorName.setMaxLength(65);

      addMainDoctorName();
    }
    return mainDoctorName;

  }

  /**
   * 主治医の氏名コンテナを取得します。
   * @return 主治医の氏名コンテナ
   */
  protected ACLabelContainer getMainDoctorNameContainer(){
    if(mainDoctorNameContainer==null){
      mainDoctorNameContainer = new ACLabelContainer();
      mainDoctorNameContainer.setFollowChildEnabled(true);
      mainDoctorNameContainer.setVAlignment(VRLayout.CENTER);
      mainDoctorNameContainer.add(getMainDoctorName(), null);
    }
    return mainDoctorNameContainer;
  }

  /**
   * 訪問日グループを取得します。
   * @return 訪問日グループ
   */
  public ACGroupBox getVisitFrame(){
    if(visitFrame==null){

      visitFrame = new ACGroupBox();

      visitFrame.setText("訪問日");

      visitFrame.setLayout(getVisitFrameLayout());

      addVisitFrame();
    }
    return visitFrame;

  }

  /**
   * 訪問日グループ・レイアウトを取得します。
   * @return 訪問日グループ・レイアウト
   */
  public VRLayout getVisitFrameLayout(){
    if(visitFrameLayout==null){

      visitFrameLayout = new VRLayout();

      visitFrameLayout.setAutoWrap(false);

      visitFrameLayout.setHgap(3);

      visitFrameLayout.setLabelMargin(0);

      visitFrameLayout.setVgap(3);

      addVisitFrameLayout();
    }
    return visitFrameLayout;

  }

  /**
   * 訪問日コンボ1を取得します。
   * @return 訪問日コンボ1
   */
  public ACComboBox getVisitCombo1(){
    if(visitCombo1==null){

      visitCombo1 = new ACComboBox();

      visitCombo1.setBindPath("1301104");

      visitCombo1.setEditable(false);

      visitCombo1.setRenderBindPath("ITEM");

      visitCombo1.setModel(getVisitCombo1Model());

      visitCombo1.setPreferredSize(new Dimension(60,20));

      addVisitCombo1();
    }
    return visitCombo1;

  }

  /**
   * 訪問日コンボ1モデルを取得します。
   * @return 訪問日コンボ1モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo1Model(){
    if(visitCombo1Model==null){
      visitCombo1Model = new ACComboBoxModelAdapter();
      addVisitCombo1Model();
    }
    return visitCombo1Model;
  }

  /**
   * 1を取得します。
   * @return 1
   */
  public ACListItem getVisitCombo1Item1(){
    if(visitCombo1Item1==null){

      visitCombo1Item1 = new ACListItem();

      visitCombo1Item1.setText("1");

      visitCombo1Item1.setSimpleValueMode(false);
      visitCombo1Item1.put(getVisitCombo1().getRenderBindPath(), "1");
      visitCombo1Item1.put(getVisitCombo1().getBindPath(), new Integer(0));

      addVisitCombo1Item1();
    }
    return visitCombo1Item1;

  }

  /**
   * 1○を取得します。
   * @return 1○
   */
  public ACListItem getVisitCombo1Item2(){
    if(visitCombo1Item2==null){

      visitCombo1Item2 = new ACListItem();

      visitCombo1Item2.setText("1○");

      visitCombo1Item2.setSimpleValueMode(false);
      visitCombo1Item2.put(getVisitCombo1().getRenderBindPath(), "1○");
      visitCombo1Item2.put(getVisitCombo1().getBindPath(), new Integer(1));

      addVisitCombo1Item2();
    }
    return visitCombo1Item2;

  }

  /**
   * 1△を取得します。
   * @return 1△
   */
  public ACListItem getVisitCombo1Item3(){
    if(visitCombo1Item3==null){

      visitCombo1Item3 = new ACListItem();

      visitCombo1Item3.setText("1△");

      visitCombo1Item3.setSimpleValueMode(false);
      visitCombo1Item3.put(getVisitCombo1().getRenderBindPath(), "1△");
      visitCombo1Item3.put(getVisitCombo1().getBindPath(), new Integer(2));

      addVisitCombo1Item3();
    }
    return visitCombo1Item3;

  }

  /**
   * 1◎を取得します。
   * @return 1◎
   */
  public ACListItem getVisitCombo1Item4(){
    if(visitCombo1Item4==null){

      visitCombo1Item4 = new ACListItem();

      visitCombo1Item4.setText("1◎");

      visitCombo1Item4.setSimpleValueMode(false);
      visitCombo1Item4.put(getVisitCombo1().getRenderBindPath(), "1◎");
      visitCombo1Item4.put(getVisitCombo1().getBindPath(), new Integer(3));

      addVisitCombo1Item4();
    }
    return visitCombo1Item4;

  }

  /**
   * 1△◎を取得します。
   * @return 1△◎
   */
  public ACListItem getVisitCombo1Item5(){
    if(visitCombo1Item5==null){

      visitCombo1Item5 = new ACListItem();

      visitCombo1Item5.setText("1△◎");

      visitCombo1Item5.setSimpleValueMode(false);
      visitCombo1Item5.put(getVisitCombo1().getRenderBindPath(), "1△◎");
      visitCombo1Item5.put(getVisitCombo1().getBindPath(), new Integer(4));

      addVisitCombo1Item5();
    }
    return visitCombo1Item5;

  }

  /**
   * 訪問日コンボ2を取得します。
   * @return 訪問日コンボ2
   */
  public ACComboBox getVisitCombo2(){
    if(visitCombo2==null){

      visitCombo2 = new ACComboBox();

      visitCombo2.setBindPath("1301105");

      visitCombo2.setEditable(false);

      visitCombo2.setRenderBindPath("ITEM");

      visitCombo2.setModel(getVisitCombo2Model());

      visitCombo2.setPreferredSize(new Dimension(60,20));

      addVisitCombo2();
    }
    return visitCombo2;

  }

  /**
   * 訪問日コンボ2モデルを取得します。
   * @return 訪問日コンボ2モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo2Model(){
    if(visitCombo2Model==null){
      visitCombo2Model = new ACComboBoxModelAdapter();
      addVisitCombo2Model();
    }
    return visitCombo2Model;
  }

  /**
   * 2を取得します。
   * @return 2
   */
  public ACListItem getVisitCombo2Item1(){
    if(visitCombo2Item1==null){

      visitCombo2Item1 = new ACListItem();

      visitCombo2Item1.setText("2");

      visitCombo2Item1.setSimpleValueMode(false);
      visitCombo2Item1.put(getVisitCombo2().getRenderBindPath(), "2");
      visitCombo2Item1.put(getVisitCombo2().getBindPath(), new Integer(0));

      addVisitCombo2Item1();
    }
    return visitCombo2Item1;

  }

  /**
   * 2○を取得します。
   * @return 2○
   */
  public ACListItem getVisitCombo2Item2(){
    if(visitCombo2Item2==null){

      visitCombo2Item2 = new ACListItem();

      visitCombo2Item2.setText("2○");

      visitCombo2Item2.setSimpleValueMode(false);
      visitCombo2Item2.put(getVisitCombo2().getRenderBindPath(), "2○");
      visitCombo2Item2.put(getVisitCombo2().getBindPath(), new Integer(1));

      addVisitCombo2Item2();
    }
    return visitCombo2Item2;

  }

  /**
   * 2△を取得します。
   * @return 2△
   */
  public ACListItem getVisitCombo2Item3(){
    if(visitCombo2Item3==null){

      visitCombo2Item3 = new ACListItem();

      visitCombo2Item3.setText("2△");

      visitCombo2Item3.setSimpleValueMode(false);
      visitCombo2Item3.put(getVisitCombo2().getRenderBindPath(), "2△");
      visitCombo2Item3.put(getVisitCombo2().getBindPath(), new Integer(2));

      addVisitCombo2Item3();
    }
    return visitCombo2Item3;

  }

  /**
   * 2◎を取得します。
   * @return 2◎
   */
  public ACListItem getVisitCombo2Item4(){
    if(visitCombo2Item4==null){

      visitCombo2Item4 = new ACListItem();

      visitCombo2Item4.setText("2◎");

      visitCombo2Item4.setSimpleValueMode(false);
      visitCombo2Item4.put(getVisitCombo2().getRenderBindPath(), "2◎");
      visitCombo2Item4.put(getVisitCombo2().getBindPath(), new Integer(3));

      addVisitCombo2Item4();
    }
    return visitCombo2Item4;

  }

  /**
   * 2△◎を取得します。
   * @return 2△◎
   */
  public ACListItem getVisitCombo2Item5(){
    if(visitCombo2Item5==null){

      visitCombo2Item5 = new ACListItem();

      visitCombo2Item5.setText("2△◎");

      visitCombo2Item5.setSimpleValueMode(false);
      visitCombo2Item5.put(getVisitCombo2().getRenderBindPath(), "2△◎");
      visitCombo2Item5.put(getVisitCombo2().getBindPath(), new Integer(4));

      addVisitCombo2Item5();
    }
    return visitCombo2Item5;

  }

  /**
   * 訪問日コンボ3を取得します。
   * @return 訪問日コンボ3
   */
  public ACComboBox getVisitCombo3(){
    if(visitCombo3==null){

      visitCombo3 = new ACComboBox();

      visitCombo3.setBindPath("1301106");

      visitCombo3.setEditable(false);

      visitCombo3.setRenderBindPath("ITEM");

      visitCombo3.setModel(getVisitCombo3Model());

      visitCombo3.setPreferredSize(new Dimension(60,20));

      addVisitCombo3();
    }
    return visitCombo3;

  }

  /**
   * 訪問日コンボ3モデルを取得します。
   * @return 訪問日コンボ3モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo3Model(){
    if(visitCombo3Model==null){
      visitCombo3Model = new ACComboBoxModelAdapter();
      addVisitCombo3Model();
    }
    return visitCombo3Model;
  }

  /**
   * 3を取得します。
   * @return 3
   */
  public ACListItem getVisitCombo3Item1(){
    if(visitCombo3Item1==null){

      visitCombo3Item1 = new ACListItem();

      visitCombo3Item1.setText("3");

      visitCombo3Item1.setSimpleValueMode(false);
      visitCombo3Item1.put(getVisitCombo3().getRenderBindPath(), "3");
      visitCombo3Item1.put(getVisitCombo3().getBindPath(), new Integer(0));

      addVisitCombo3Item1();
    }
    return visitCombo3Item1;

  }

  /**
   * 3○を取得します。
   * @return 3○
   */
  public ACListItem getVisitCombo3Item2(){
    if(visitCombo3Item2==null){

      visitCombo3Item2 = new ACListItem();

      visitCombo3Item2.setText("3○");

      visitCombo3Item2.setSimpleValueMode(false);
      visitCombo3Item2.put(getVisitCombo3().getRenderBindPath(), "3○");
      visitCombo3Item2.put(getVisitCombo3().getBindPath(), new Integer(1));

      addVisitCombo3Item2();
    }
    return visitCombo3Item2;

  }

  /**
   * 3△を取得します。
   * @return 3△
   */
  public ACListItem getVisitCombo3Item3(){
    if(visitCombo3Item3==null){

      visitCombo3Item3 = new ACListItem();

      visitCombo3Item3.setText("3△");

      visitCombo3Item3.setSimpleValueMode(false);
      visitCombo3Item3.put(getVisitCombo3().getRenderBindPath(), "3△");
      visitCombo3Item3.put(getVisitCombo3().getBindPath(), new Integer(2));

      addVisitCombo3Item3();
    }
    return visitCombo3Item3;

  }

  /**
   * 3◎を取得します。
   * @return 3◎
   */
  public ACListItem getVisitCombo3Item4(){
    if(visitCombo3Item4==null){

      visitCombo3Item4 = new ACListItem();

      visitCombo3Item4.setText("3◎");

      visitCombo3Item4.setSimpleValueMode(false);
      visitCombo3Item4.put(getVisitCombo3().getRenderBindPath(), "3◎");
      visitCombo3Item4.put(getVisitCombo3().getBindPath(), new Integer(3));

      addVisitCombo3Item4();
    }
    return visitCombo3Item4;

  }

  /**
   * 3△◎を取得します。
   * @return 3△◎
   */
  public ACListItem getVisitCombo3Item5(){
    if(visitCombo3Item5==null){

      visitCombo3Item5 = new ACListItem();

      visitCombo3Item5.setText("3△◎");

      visitCombo3Item5.setSimpleValueMode(false);
      visitCombo3Item5.put(getVisitCombo3().getRenderBindPath(), "3△◎");
      visitCombo3Item5.put(getVisitCombo3().getBindPath(), new Integer(4));

      addVisitCombo3Item5();
    }
    return visitCombo3Item5;

  }

  /**
   * 訪問日コンボ4を取得します。
   * @return 訪問日コンボ4
   */
  public ACComboBox getVisitCombo4(){
    if(visitCombo4==null){

      visitCombo4 = new ACComboBox();

      visitCombo4.setBindPath("1301107");

      visitCombo4.setEditable(false);

      visitCombo4.setRenderBindPath("ITEM");

      visitCombo4.setModel(getVisitCombo4Model());

      visitCombo4.setPreferredSize(new Dimension(60,20));

      addVisitCombo4();
    }
    return visitCombo4;

  }

  /**
   * 訪問日コンボ4モデルを取得します。
   * @return 訪問日コンボ4モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo4Model(){
    if(visitCombo4Model==null){
      visitCombo4Model = new ACComboBoxModelAdapter();
      addVisitCombo4Model();
    }
    return visitCombo4Model;
  }

  /**
   * 4を取得します。
   * @return 4
   */
  public ACListItem getVisitCombo4item1(){
    if(visitCombo4item1==null){

      visitCombo4item1 = new ACListItem();

      visitCombo4item1.setText("4");

      visitCombo4item1.setSimpleValueMode(false);
      visitCombo4item1.put(getVisitCombo4().getRenderBindPath(), "4");
      visitCombo4item1.put(getVisitCombo4().getBindPath(), new Integer(0));

      addVisitCombo4item1();
    }
    return visitCombo4item1;

  }

  /**
   * 4○を取得します。
   * @return 4○
   */
  public ACListItem getVisitCombo4item2(){
    if(visitCombo4item2==null){

      visitCombo4item2 = new ACListItem();

      visitCombo4item2.setText("4○");

      visitCombo4item2.setSimpleValueMode(false);
      visitCombo4item2.put(getVisitCombo4().getRenderBindPath(), "4○");
      visitCombo4item2.put(getVisitCombo4().getBindPath(), new Integer(1));

      addVisitCombo4item2();
    }
    return visitCombo4item2;

  }

  /**
   * 4△を取得します。
   * @return 4△
   */
  public ACListItem getVisitCombo4item3(){
    if(visitCombo4item3==null){

      visitCombo4item3 = new ACListItem();

      visitCombo4item3.setText("4△");

      visitCombo4item3.setSimpleValueMode(false);
      visitCombo4item3.put(getVisitCombo4().getRenderBindPath(), "4△");
      visitCombo4item3.put(getVisitCombo4().getBindPath(), new Integer(2));

      addVisitCombo4item3();
    }
    return visitCombo4item3;

  }

  /**
   * 4◎を取得します。
   * @return 4◎
   */
  public ACListItem getVisitCombo4item4(){
    if(visitCombo4item4==null){

      visitCombo4item4 = new ACListItem();

      visitCombo4item4.setText("4◎");

      visitCombo4item4.setSimpleValueMode(false);
      visitCombo4item4.put(getVisitCombo4().getRenderBindPath(), "4◎");
      visitCombo4item4.put(getVisitCombo4().getBindPath(), new Integer(3));

      addVisitCombo4item4();
    }
    return visitCombo4item4;

  }

  /**
   * 4△◎を取得します。
   * @return 4△◎
   */
  public ACListItem getVisitCombo4item5(){
    if(visitCombo4item5==null){

      visitCombo4item5 = new ACListItem();

      visitCombo4item5.setText("4△◎");

      visitCombo4item5.setSimpleValueMode(false);
      visitCombo4item5.put(getVisitCombo4().getRenderBindPath(), "4△◎");
      visitCombo4item5.put(getVisitCombo4().getBindPath(), new Integer(4));

      addVisitCombo4item5();
    }
    return visitCombo4item5;

  }

  /**
   * 訪問日コンボ5を取得します。
   * @return 訪問日コンボ5
   */
  public ACComboBox getVisitCombo5(){
    if(visitCombo5==null){

      visitCombo5 = new ACComboBox();

      visitCombo5.setBindPath("1301108");

      visitCombo5.setEditable(false);

      visitCombo5.setRenderBindPath("ITEM");

      visitCombo5.setModel(getVisitCombo5Model());

      visitCombo5.setPreferredSize(new Dimension(60,20));

      addVisitCombo5();
    }
    return visitCombo5;

  }

  /**
   * 訪問日コンボ5モデルを取得します。
   * @return 訪問日コンボ5モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo5Model(){
    if(visitCombo5Model==null){
      visitCombo5Model = new ACComboBoxModelAdapter();
      addVisitCombo5Model();
    }
    return visitCombo5Model;
  }

  /**
   * 5を取得します。
   * @return 5
   */
  public ACListItem getVisitCombo5Item1(){
    if(visitCombo5Item1==null){

      visitCombo5Item1 = new ACListItem();

      visitCombo5Item1.setText("5");

      visitCombo5Item1.setSimpleValueMode(false);
      visitCombo5Item1.put(getVisitCombo5().getRenderBindPath(), "5");
      visitCombo5Item1.put(getVisitCombo5().getBindPath(), new Integer(0));

      addVisitCombo5Item1();
    }
    return visitCombo5Item1;

  }

  /**
   * 5○を取得します。
   * @return 5○
   */
  public ACListItem getVisitCombo5Item2(){
    if(visitCombo5Item2==null){

      visitCombo5Item2 = new ACListItem();

      visitCombo5Item2.setText("5○");

      visitCombo5Item2.setSimpleValueMode(false);
      visitCombo5Item2.put(getVisitCombo5().getRenderBindPath(), "5○");
      visitCombo5Item2.put(getVisitCombo5().getBindPath(), new Integer(1));

      addVisitCombo5Item2();
    }
    return visitCombo5Item2;

  }

  /**
   * 5△を取得します。
   * @return 5△
   */
  public ACListItem getVisitCombo5Item3(){
    if(visitCombo5Item3==null){

      visitCombo5Item3 = new ACListItem();

      visitCombo5Item3.setText("5△");

      visitCombo5Item3.setSimpleValueMode(false);
      visitCombo5Item3.put(getVisitCombo5().getRenderBindPath(), "5△");
      visitCombo5Item3.put(getVisitCombo5().getBindPath(), new Integer(2));

      addVisitCombo5Item3();
    }
    return visitCombo5Item3;

  }

  /**
   * 5◎を取得します。
   * @return 5◎
   */
  public ACListItem getVisitCombo5Item4(){
    if(visitCombo5Item4==null){

      visitCombo5Item4 = new ACListItem();

      visitCombo5Item4.setText("5◎");

      visitCombo5Item4.setSimpleValueMode(false);
      visitCombo5Item4.put(getVisitCombo5().getRenderBindPath(), "5◎");
      visitCombo5Item4.put(getVisitCombo5().getBindPath(), new Integer(3));

      addVisitCombo5Item4();
    }
    return visitCombo5Item4;

  }

  /**
   * 5△◎を取得します。
   * @return 5△◎
   */
  public ACListItem getVisitCombo5Item5(){
    if(visitCombo5Item5==null){

      visitCombo5Item5 = new ACListItem();

      visitCombo5Item5.setText("5△◎");

      visitCombo5Item5.setSimpleValueMode(false);
      visitCombo5Item5.put(getVisitCombo5().getRenderBindPath(), "5△◎");
      visitCombo5Item5.put(getVisitCombo5().getBindPath(), new Integer(4));

      addVisitCombo5Item5();
    }
    return visitCombo5Item5;

  }

  /**
   * 訪問日コンボ6を取得します。
   * @return 訪問日コンボ6
   */
  public ACComboBox getVisitCombo6(){
    if(visitCombo6==null){

      visitCombo6 = new ACComboBox();

      visitCombo6.setBindPath("1301109");

      visitCombo6.setEditable(false);

      visitCombo6.setRenderBindPath("ITEM");

      visitCombo6.setModel(getVisitCombo6Model());

      visitCombo6.setPreferredSize(new Dimension(60,20));

      addVisitCombo6();
    }
    return visitCombo6;

  }

  /**
   * 訪問日コンボ6モデルを取得します。
   * @return 訪問日コンボ6モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo6Model(){
    if(visitCombo6Model==null){
      visitCombo6Model = new ACComboBoxModelAdapter();
      addVisitCombo6Model();
    }
    return visitCombo6Model;
  }

  /**
   * 6を取得します。
   * @return 6
   */
  public ACListItem getVisitCombo6Item1(){
    if(visitCombo6Item1==null){

      visitCombo6Item1 = new ACListItem();

      visitCombo6Item1.setText("6");

      visitCombo6Item1.setSimpleValueMode(false);
      visitCombo6Item1.put(getVisitCombo6().getRenderBindPath(), "6");
      visitCombo6Item1.put(getVisitCombo6().getBindPath(), new Integer(0));

      addVisitCombo6Item1();
    }
    return visitCombo6Item1;

  }

  /**
   * 6○を取得します。
   * @return 6○
   */
  public ACListItem getVisitCombo6Item2(){
    if(visitCombo6Item2==null){

      visitCombo6Item2 = new ACListItem();

      visitCombo6Item2.setText("6○");

      visitCombo6Item2.setSimpleValueMode(false);
      visitCombo6Item2.put(getVisitCombo6().getRenderBindPath(), "6○");
      visitCombo6Item2.put(getVisitCombo6().getBindPath(), new Integer(1));

      addVisitCombo6Item2();
    }
    return visitCombo6Item2;

  }

  /**
   * 6△を取得します。
   * @return 6△
   */
  public ACListItem getVisitCombo6Item3(){
    if(visitCombo6Item3==null){

      visitCombo6Item3 = new ACListItem();

      visitCombo6Item3.setText("6△");

      visitCombo6Item3.setSimpleValueMode(false);
      visitCombo6Item3.put(getVisitCombo6().getRenderBindPath(), "6△");
      visitCombo6Item3.put(getVisitCombo6().getBindPath(), new Integer(2));

      addVisitCombo6Item3();
    }
    return visitCombo6Item3;

  }

  /**
   * 6◎を取得します。
   * @return 6◎
   */
  public ACListItem getVisitCombo6Item4(){
    if(visitCombo6Item4==null){

      visitCombo6Item4 = new ACListItem();

      visitCombo6Item4.setText("6◎");

      visitCombo6Item4.setSimpleValueMode(false);
      visitCombo6Item4.put(getVisitCombo6().getRenderBindPath(), "6◎");
      visitCombo6Item4.put(getVisitCombo6().getBindPath(), new Integer(3));

      addVisitCombo6Item4();
    }
    return visitCombo6Item4;

  }

  /**
   * 6△◎を取得します。
   * @return 6△◎
   */
  public ACListItem getVisitCombo6Item5(){
    if(visitCombo6Item5==null){

      visitCombo6Item5 = new ACListItem();

      visitCombo6Item5.setText("6△◎");

      visitCombo6Item5.setSimpleValueMode(false);
      visitCombo6Item5.put(getVisitCombo6().getRenderBindPath(), "6△◎");
      visitCombo6Item5.put(getVisitCombo6().getBindPath(), new Integer(4));

      addVisitCombo6Item5();
    }
    return visitCombo6Item5;

  }

  /**
   * 訪問日コンボ7を取得します。
   * @return 訪問日コンボ7
   */
  public ACComboBox getVisitCombo7(){
    if(visitCombo7==null){

      visitCombo7 = new ACComboBox();

      visitCombo7.setBindPath("1301110");

      visitCombo7.setEditable(false);

      visitCombo7.setRenderBindPath("ITEM");

      visitCombo7.setModel(getVisitCombo7Model());

      visitCombo7.setPreferredSize(new Dimension(60,20));

      addVisitCombo7();
    }
    return visitCombo7;

  }

  /**
   * 訪問日コンボ7モデルを取得します。
   * @return 訪問日コンボ7モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo7Model(){
    if(visitCombo7Model==null){
      visitCombo7Model = new ACComboBoxModelAdapter();
      addVisitCombo7Model();
    }
    return visitCombo7Model;
  }

  /**
   * 7を取得します。
   * @return 7
   */
  public ACListItem getVisitCombo7Item1(){
    if(visitCombo7Item1==null){

      visitCombo7Item1 = new ACListItem();

      visitCombo7Item1.setText("7");

      visitCombo7Item1.setSimpleValueMode(false);
      visitCombo7Item1.put(getVisitCombo7().getRenderBindPath(), "7");
      visitCombo7Item1.put(getVisitCombo7().getBindPath(), new Integer(0));

      addVisitCombo7Item1();
    }
    return visitCombo7Item1;

  }

  /**
   * 7○を取得します。
   * @return 7○
   */
  public ACListItem getVisitCombo7Item2(){
    if(visitCombo7Item2==null){

      visitCombo7Item2 = new ACListItem();

      visitCombo7Item2.setText("7○");

      visitCombo7Item2.setSimpleValueMode(false);
      visitCombo7Item2.put(getVisitCombo7().getRenderBindPath(), "7○");
      visitCombo7Item2.put(getVisitCombo7().getBindPath(), new Integer(1));

      addVisitCombo7Item2();
    }
    return visitCombo7Item2;

  }

  /**
   * 7△を取得します。
   * @return 7△
   */
  public ACListItem getVisitCombo7Item3(){
    if(visitCombo7Item3==null){

      visitCombo7Item3 = new ACListItem();

      visitCombo7Item3.setText("7△");

      visitCombo7Item3.setSimpleValueMode(false);
      visitCombo7Item3.put(getVisitCombo7().getRenderBindPath(), "7△");
      visitCombo7Item3.put(getVisitCombo7().getBindPath(), new Integer(2));

      addVisitCombo7Item3();
    }
    return visitCombo7Item3;

  }

  /**
   * 7◎を取得します。
   * @return 7◎
   */
  public ACListItem getVisitCombo7Item4(){
    if(visitCombo7Item4==null){

      visitCombo7Item4 = new ACListItem();

      visitCombo7Item4.setText("7◎");

      visitCombo7Item4.setSimpleValueMode(false);
      visitCombo7Item4.put(getVisitCombo7().getRenderBindPath(), "7◎");
      visitCombo7Item4.put(getVisitCombo7().getBindPath(), new Integer(3));

      addVisitCombo7Item4();
    }
    return visitCombo7Item4;

  }

  /**
   * 7△◎を取得します。
   * @return 7△◎
   */
  public ACListItem getVisitCombo7Item5(){
    if(visitCombo7Item5==null){

      visitCombo7Item5 = new ACListItem();

      visitCombo7Item5.setText("7△◎");

      visitCombo7Item5.setSimpleValueMode(false);
      visitCombo7Item5.put(getVisitCombo7().getRenderBindPath(), "7△◎");
      visitCombo7Item5.put(getVisitCombo7().getBindPath(), new Integer(4));

      addVisitCombo7Item5();
    }
    return visitCombo7Item5;

  }

  /**
   * 訪問日コンボ8を取得します。
   * @return 訪問日コンボ8
   */
  public ACComboBox getVisitCombo8(){
    if(visitCombo8==null){

      visitCombo8 = new ACComboBox();

      visitCombo8.setBindPath("1301111");

      visitCombo8.setEditable(false);

      visitCombo8.setRenderBindPath("ITEM");

      visitCombo8.setModel(getVisitCombo8Model());

      visitCombo8.setPreferredSize(new Dimension(60,20));

      addVisitCombo8();
    }
    return visitCombo8;

  }

  /**
   * 訪問日コンボ8モデルを取得します。
   * @return 訪問日コンボ8モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo8Model(){
    if(visitCombo8Model==null){
      visitCombo8Model = new ACComboBoxModelAdapter();
      addVisitCombo8Model();
    }
    return visitCombo8Model;
  }

  /**
   * 8を取得します。
   * @return 8
   */
  public ACListItem getVisitCombo8Item1(){
    if(visitCombo8Item1==null){

      visitCombo8Item1 = new ACListItem();

      visitCombo8Item1.setText("8");

      visitCombo8Item1.setSimpleValueMode(false);
      visitCombo8Item1.put(getVisitCombo8().getRenderBindPath(), "8");
      visitCombo8Item1.put(getVisitCombo8().getBindPath(), new Integer(0));

      addVisitCombo8Item1();
    }
    return visitCombo8Item1;

  }

  /**
   * 8○を取得します。
   * @return 8○
   */
  public ACListItem getVisitCombo8Item2(){
    if(visitCombo8Item2==null){

      visitCombo8Item2 = new ACListItem();

      visitCombo8Item2.setText("8○");

      visitCombo8Item2.setSimpleValueMode(false);
      visitCombo8Item2.put(getVisitCombo8().getRenderBindPath(), "8○");
      visitCombo8Item2.put(getVisitCombo8().getBindPath(), new Integer(1));

      addVisitCombo8Item2();
    }
    return visitCombo8Item2;

  }

  /**
   * 8△を取得します。
   * @return 8△
   */
  public ACListItem getVisitCombo8Item3(){
    if(visitCombo8Item3==null){

      visitCombo8Item3 = new ACListItem();

      visitCombo8Item3.setText("8△");

      visitCombo8Item3.setSimpleValueMode(false);
      visitCombo8Item3.put(getVisitCombo8().getRenderBindPath(), "8△");
      visitCombo8Item3.put(getVisitCombo8().getBindPath(), new Integer(2));

      addVisitCombo8Item3();
    }
    return visitCombo8Item3;

  }

  /**
   * 8◎を取得します。
   * @return 8◎
   */
  public ACListItem getVisitCombo8Item4(){
    if(visitCombo8Item4==null){

      visitCombo8Item4 = new ACListItem();

      visitCombo8Item4.setText("8◎");

      visitCombo8Item4.setSimpleValueMode(false);
      visitCombo8Item4.put(getVisitCombo8().getRenderBindPath(), "8◎");
      visitCombo8Item4.put(getVisitCombo8().getBindPath(), new Integer(3));

      addVisitCombo8Item4();
    }
    return visitCombo8Item4;

  }

  /**
   * 8△◎を取得します。
   * @return 8△◎
   */
  public ACListItem getVisitCombo8Item5(){
    if(visitCombo8Item5==null){

      visitCombo8Item5 = new ACListItem();

      visitCombo8Item5.setText("8△◎");

      visitCombo8Item5.setSimpleValueMode(false);
      visitCombo8Item5.put(getVisitCombo8().getRenderBindPath(), "8△◎");
      visitCombo8Item5.put(getVisitCombo8().getBindPath(), new Integer(4));

      addVisitCombo8Item5();
    }
    return visitCombo8Item5;

  }

  /**
   * 訪問日コンボ9を取得します。
   * @return 訪問日コンボ9
   */
  public ACComboBox getVisitCombo9(){
    if(visitCombo9==null){

      visitCombo9 = new ACComboBox();

      visitCombo9.setBindPath("1301112");

      visitCombo9.setEditable(false);

      visitCombo9.setRenderBindPath("ITEM");

      visitCombo9.setModel(getVisitCombo9Model());

      visitCombo9.setPreferredSize(new Dimension(60,20));

      addVisitCombo9();
    }
    return visitCombo9;

  }

  /**
   * 訪問日コンボ9モデルを取得します。
   * @return 訪問日コンボ9モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo9Model(){
    if(visitCombo9Model==null){
      visitCombo9Model = new ACComboBoxModelAdapter();
      addVisitCombo9Model();
    }
    return visitCombo9Model;
  }

  /**
   * 9を取得します。
   * @return 9
   */
  public ACListItem getVisitCombo9Item1(){
    if(visitCombo9Item1==null){

      visitCombo9Item1 = new ACListItem();

      visitCombo9Item1.setText("9");

      visitCombo9Item1.setSimpleValueMode(false);
      visitCombo9Item1.put(getVisitCombo9().getRenderBindPath(), "9");
      visitCombo9Item1.put(getVisitCombo9().getBindPath(), new Integer(0));

      addVisitCombo9Item1();
    }
    return visitCombo9Item1;

  }

  /**
   * 9○を取得します。
   * @return 9○
   */
  public ACListItem getVisitCombo9Item2(){
    if(visitCombo9Item2==null){

      visitCombo9Item2 = new ACListItem();

      visitCombo9Item2.setText("9○");

      visitCombo9Item2.setSimpleValueMode(false);
      visitCombo9Item2.put(getVisitCombo9().getRenderBindPath(), "9○");
      visitCombo9Item2.put(getVisitCombo9().getBindPath(), new Integer(1));

      addVisitCombo9Item2();
    }
    return visitCombo9Item2;

  }

  /**
   * 9△を取得します。
   * @return 9△
   */
  public ACListItem getVisitCombo9Item3(){
    if(visitCombo9Item3==null){

      visitCombo9Item3 = new ACListItem();

      visitCombo9Item3.setText("9△");

      visitCombo9Item3.setSimpleValueMode(false);
      visitCombo9Item3.put(getVisitCombo9().getRenderBindPath(), "9△");
      visitCombo9Item3.put(getVisitCombo9().getBindPath(), new Integer(2));

      addVisitCombo9Item3();
    }
    return visitCombo9Item3;

  }

  /**
   * 9◎を取得します。
   * @return 9◎
   */
  public ACListItem getVisitCombo9Item4(){
    if(visitCombo9Item4==null){

      visitCombo9Item4 = new ACListItem();

      visitCombo9Item4.setText("9◎");

      visitCombo9Item4.setSimpleValueMode(false);
      visitCombo9Item4.put(getVisitCombo9().getRenderBindPath(), "9◎");
      visitCombo9Item4.put(getVisitCombo9().getBindPath(), new Integer(3));

      addVisitCombo9Item4();
    }
    return visitCombo9Item4;

  }

  /**
   * 9△◎を取得します。
   * @return 9△◎
   */
  public ACListItem getVisitCombo9Item5(){
    if(visitCombo9Item5==null){

      visitCombo9Item5 = new ACListItem();

      visitCombo9Item5.setText("9△◎");

      visitCombo9Item5.setSimpleValueMode(false);
      visitCombo9Item5.put(getVisitCombo9().getRenderBindPath(), "9△◎");
      visitCombo9Item5.put(getVisitCombo9().getBindPath(), new Integer(4));

      addVisitCombo9Item5();
    }
    return visitCombo9Item5;

  }

  /**
   * 訪問日コンボ10を取得します。
   * @return 訪問日コンボ10
   */
  public ACComboBox getVisitCombo10(){
    if(visitCombo10==null){

      visitCombo10 = new ACComboBox();

      visitCombo10.setBindPath("1301113");

      visitCombo10.setEditable(false);

      visitCombo10.setRenderBindPath("ITEM");

      visitCombo10.setModel(getVisitCombo10Model());

      visitCombo10.setPreferredSize(new Dimension(60,20));

      addVisitCombo10();
    }
    return visitCombo10;

  }

  /**
   * 訪問日コンボ10モデルを取得します。
   * @return 訪問日コンボ10モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo10Model(){
    if(visitCombo10Model==null){
      visitCombo10Model = new ACComboBoxModelAdapter();
      addVisitCombo10Model();
    }
    return visitCombo10Model;
  }

  /**
   * 10を取得します。
   * @return 10
   */
  public ACListItem getVisitCombo10Item1(){
    if(visitCombo10Item1==null){

      visitCombo10Item1 = new ACListItem();

      visitCombo10Item1.setText("10");

      visitCombo10Item1.setSimpleValueMode(false);
      visitCombo10Item1.put(getVisitCombo10().getRenderBindPath(), "10");
      visitCombo10Item1.put(getVisitCombo10().getBindPath(), new Integer(0));

      addVisitCombo10Item1();
    }
    return visitCombo10Item1;

  }

  /**
   * 10○を取得します。
   * @return 10○
   */
  public ACListItem getVisitCombo10Item2(){
    if(visitCombo10Item2==null){

      visitCombo10Item2 = new ACListItem();

      visitCombo10Item2.setText("10○");

      visitCombo10Item2.setSimpleValueMode(false);
      visitCombo10Item2.put(getVisitCombo10().getRenderBindPath(), "10○");
      visitCombo10Item2.put(getVisitCombo10().getBindPath(), new Integer(1));

      addVisitCombo10Item2();
    }
    return visitCombo10Item2;

  }

  /**
   * 10△を取得します。
   * @return 10△
   */
  public ACListItem getVisitCombo10Item3(){
    if(visitCombo10Item3==null){

      visitCombo10Item3 = new ACListItem();

      visitCombo10Item3.setText("10△");

      visitCombo10Item3.setSimpleValueMode(false);
      visitCombo10Item3.put(getVisitCombo10().getRenderBindPath(), "10△");
      visitCombo10Item3.put(getVisitCombo10().getBindPath(), new Integer(2));

      addVisitCombo10Item3();
    }
    return visitCombo10Item3;

  }

  /**
   * 10◎を取得します。
   * @return 10◎
   */
  public ACListItem getVisitCombo10Item4(){
    if(visitCombo10Item4==null){

      visitCombo10Item4 = new ACListItem();

      visitCombo10Item4.setText("10◎");

      visitCombo10Item4.setSimpleValueMode(false);
      visitCombo10Item4.put(getVisitCombo10().getRenderBindPath(), "10◎");
      visitCombo10Item4.put(getVisitCombo10().getBindPath(), new Integer(3));

      addVisitCombo10Item4();
    }
    return visitCombo10Item4;

  }

  /**
   * 10△◎を取得します。
   * @return 10△◎
   */
  public ACListItem getVisitCombo10Item5(){
    if(visitCombo10Item5==null){

      visitCombo10Item5 = new ACListItem();

      visitCombo10Item5.setText("10△◎");

      visitCombo10Item5.setSimpleValueMode(false);
      visitCombo10Item5.put(getVisitCombo10().getRenderBindPath(), "10△◎");
      visitCombo10Item5.put(getVisitCombo10().getBindPath(), new Integer(4));

      addVisitCombo10Item5();
    }
    return visitCombo10Item5;

  }

  /**
   * 訪問日コンボ11を取得します。
   * @return 訪問日コンボ11
   */
  public ACComboBox getVisitCombo11(){
    if(visitCombo11==null){

      visitCombo11 = new ACComboBox();

      visitCombo11.setBindPath("1301114");

      visitCombo11.setEditable(false);

      visitCombo11.setRenderBindPath("ITEM");

      visitCombo11.setModel(getVisitCombo11Model());

      visitCombo11.setPreferredSize(new Dimension(60,20));

      addVisitCombo11();
    }
    return visitCombo11;

  }

  /**
   * 訪問日コンボ11モデルを取得します。
   * @return 訪問日コンボ11モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo11Model(){
    if(visitCombo11Model==null){
      visitCombo11Model = new ACComboBoxModelAdapter();
      addVisitCombo11Model();
    }
    return visitCombo11Model;
  }

  /**
   * 11を取得します。
   * @return 11
   */
  public ACListItem getVisitCombo11Item1(){
    if(visitCombo11Item1==null){

      visitCombo11Item1 = new ACListItem();

      visitCombo11Item1.setText("11");

      visitCombo11Item1.setSimpleValueMode(false);
      visitCombo11Item1.put(getVisitCombo11().getRenderBindPath(), "11");
      visitCombo11Item1.put(getVisitCombo11().getBindPath(), new Integer(0));

      addVisitCombo11Item1();
    }
    return visitCombo11Item1;

  }

  /**
   * 11○を取得します。
   * @return 11○
   */
  public ACListItem getVisitCombo11Item2(){
    if(visitCombo11Item2==null){

      visitCombo11Item2 = new ACListItem();

      visitCombo11Item2.setText("11○");

      visitCombo11Item2.setSimpleValueMode(false);
      visitCombo11Item2.put(getVisitCombo11().getRenderBindPath(), "11○");
      visitCombo11Item2.put(getVisitCombo11().getBindPath(), new Integer(1));

      addVisitCombo11Item2();
    }
    return visitCombo11Item2;

  }

  /**
   * 11△を取得します。
   * @return 11△
   */
  public ACListItem getVisitCombo11Item3(){
    if(visitCombo11Item3==null){

      visitCombo11Item3 = new ACListItem();

      visitCombo11Item3.setText("11△");

      visitCombo11Item3.setSimpleValueMode(false);
      visitCombo11Item3.put(getVisitCombo11().getRenderBindPath(), "11△");
      visitCombo11Item3.put(getVisitCombo11().getBindPath(), new Integer(2));

      addVisitCombo11Item3();
    }
    return visitCombo11Item3;

  }

  /**
   * 11◎を取得します。
   * @return 11◎
   */
  public ACListItem getVisitCombo11Item4(){
    if(visitCombo11Item4==null){

      visitCombo11Item4 = new ACListItem();

      visitCombo11Item4.setText("11◎");

      visitCombo11Item4.setSimpleValueMode(false);
      visitCombo11Item4.put(getVisitCombo11().getRenderBindPath(), "11◎");
      visitCombo11Item4.put(getVisitCombo11().getBindPath(), new Integer(3));

      addVisitCombo11Item4();
    }
    return visitCombo11Item4;

  }

  /**
   * 11△◎を取得します。
   * @return 11△◎
   */
  public ACListItem getVisitCombo11Item5(){
    if(visitCombo11Item5==null){

      visitCombo11Item5 = new ACListItem();

      visitCombo11Item5.setText("11△◎");

      visitCombo11Item5.setSimpleValueMode(false);
      visitCombo11Item5.put(getVisitCombo11().getRenderBindPath(), "11△◎");
      visitCombo11Item5.put(getVisitCombo11().getBindPath(), new Integer(4));

      addVisitCombo11Item5();
    }
    return visitCombo11Item5;

  }

  /**
   * 訪問日コンボ12を取得します。
   * @return 訪問日コンボ12
   */
  public ACComboBox getVisitCombo12(){
    if(visitCombo12==null){

      visitCombo12 = new ACComboBox();

      visitCombo12.setBindPath("1301115");

      visitCombo12.setEditable(false);

      visitCombo12.setRenderBindPath("ITEM");

      visitCombo12.setModel(getVisitCombo12Model());

      visitCombo12.setPreferredSize(new Dimension(60,20));

      addVisitCombo12();
    }
    return visitCombo12;

  }

  /**
   * 訪問日コンボ12モデルを取得します。
   * @return 訪問日コンボ12モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo12Model(){
    if(visitCombo12Model==null){
      visitCombo12Model = new ACComboBoxModelAdapter();
      addVisitCombo12Model();
    }
    return visitCombo12Model;
  }

  /**
   * 12を取得します。
   * @return 12
   */
  public ACListItem getVisitCombo12Item1(){
    if(visitCombo12Item1==null){

      visitCombo12Item1 = new ACListItem();

      visitCombo12Item1.setText("12");

      visitCombo12Item1.setSimpleValueMode(false);
      visitCombo12Item1.put(getVisitCombo12().getRenderBindPath(), "12");
      visitCombo12Item1.put(getVisitCombo12().getBindPath(), new Integer(0));

      addVisitCombo12Item1();
    }
    return visitCombo12Item1;

  }

  /**
   * 12○を取得します。
   * @return 12○
   */
  public ACListItem getVisitCombo12Item2(){
    if(visitCombo12Item2==null){

      visitCombo12Item2 = new ACListItem();

      visitCombo12Item2.setText("12○");

      visitCombo12Item2.setSimpleValueMode(false);
      visitCombo12Item2.put(getVisitCombo12().getRenderBindPath(), "12○");
      visitCombo12Item2.put(getVisitCombo12().getBindPath(), new Integer(1));

      addVisitCombo12Item2();
    }
    return visitCombo12Item2;

  }

  /**
   * 12△を取得します。
   * @return 12△
   */
  public ACListItem getVisitCombo12Item3(){
    if(visitCombo12Item3==null){

      visitCombo12Item3 = new ACListItem();

      visitCombo12Item3.setText("12△");

      visitCombo12Item3.setSimpleValueMode(false);
      visitCombo12Item3.put(getVisitCombo12().getRenderBindPath(), "12△");
      visitCombo12Item3.put(getVisitCombo12().getBindPath(), new Integer(2));

      addVisitCombo12Item3();
    }
    return visitCombo12Item3;

  }

  /**
   * 12◎を取得します。
   * @return 12◎
   */
  public ACListItem getVisitCombo12Item4(){
    if(visitCombo12Item4==null){

      visitCombo12Item4 = new ACListItem();

      visitCombo12Item4.setText("12◎");

      visitCombo12Item4.setSimpleValueMode(false);
      visitCombo12Item4.put(getVisitCombo12().getRenderBindPath(), "12◎");
      visitCombo12Item4.put(getVisitCombo12().getBindPath(), new Integer(3));

      addVisitCombo12Item4();
    }
    return visitCombo12Item4;

  }

  /**
   * 12△◎を取得します。
   * @return 12△◎
   */
  public ACListItem getVisitCombo12Item5(){
    if(visitCombo12Item5==null){

      visitCombo12Item5 = new ACListItem();

      visitCombo12Item5.setText("12△◎");

      visitCombo12Item5.setSimpleValueMode(false);
      visitCombo12Item5.put(getVisitCombo12().getRenderBindPath(), "12△◎");
      visitCombo12Item5.put(getVisitCombo12().getBindPath(), new Integer(4));

      addVisitCombo12Item5();
    }
    return visitCombo12Item5;

  }

  /**
   * 訪問日コンボ13を取得します。
   * @return 訪問日コンボ13
   */
  public ACComboBox getVisitCombo13(){
    if(visitCombo13==null){

      visitCombo13 = new ACComboBox();

      visitCombo13.setBindPath("1301116");

      visitCombo13.setEditable(false);

      visitCombo13.setRenderBindPath("ITEM");

      visitCombo13.setModel(getVisitCombo13Model());

      visitCombo13.setPreferredSize(new Dimension(60,20));

      addVisitCombo13();
    }
    return visitCombo13;

  }

  /**
   * 訪問日コンボ13モデルを取得します。
   * @return 訪問日コンボ13モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo13Model(){
    if(visitCombo13Model==null){
      visitCombo13Model = new ACComboBoxModelAdapter();
      addVisitCombo13Model();
    }
    return visitCombo13Model;
  }

  /**
   * 13を取得します。
   * @return 13
   */
  public ACListItem getVisitCombo13Item1(){
    if(visitCombo13Item1==null){

      visitCombo13Item1 = new ACListItem();

      visitCombo13Item1.setText("13");

      visitCombo13Item1.setSimpleValueMode(false);
      visitCombo13Item1.put(getVisitCombo13().getRenderBindPath(), "13");
      visitCombo13Item1.put(getVisitCombo13().getBindPath(), new Integer(0));

      addVisitCombo13Item1();
    }
    return visitCombo13Item1;

  }

  /**
   * 13○を取得します。
   * @return 13○
   */
  public ACListItem getVisitCombo13Item2(){
    if(visitCombo13Item2==null){

      visitCombo13Item2 = new ACListItem();

      visitCombo13Item2.setText("13○");

      visitCombo13Item2.setSimpleValueMode(false);
      visitCombo13Item2.put(getVisitCombo13().getRenderBindPath(), "13○");
      visitCombo13Item2.put(getVisitCombo13().getBindPath(), new Integer(1));

      addVisitCombo13Item2();
    }
    return visitCombo13Item2;

  }

  /**
   * 13△を取得します。
   * @return 13△
   */
  public ACListItem getVisitCombo13Item3(){
    if(visitCombo13Item3==null){

      visitCombo13Item3 = new ACListItem();

      visitCombo13Item3.setText("13△");

      visitCombo13Item3.setSimpleValueMode(false);
      visitCombo13Item3.put(getVisitCombo13().getRenderBindPath(), "13△");
      visitCombo13Item3.put(getVisitCombo13().getBindPath(), new Integer(2));

      addVisitCombo13Item3();
    }
    return visitCombo13Item3;

  }

  /**
   * 13◎を取得します。
   * @return 13◎
   */
  public ACListItem getVisitCombo13Item4(){
    if(visitCombo13Item4==null){

      visitCombo13Item4 = new ACListItem();

      visitCombo13Item4.setText("13◎");

      visitCombo13Item4.setSimpleValueMode(false);
      visitCombo13Item4.put(getVisitCombo13().getRenderBindPath(), "13◎");
      visitCombo13Item4.put(getVisitCombo13().getBindPath(), new Integer(3));

      addVisitCombo13Item4();
    }
    return visitCombo13Item4;

  }

  /**
   * 13△◎を取得します。
   * @return 13△◎
   */
  public ACListItem getVisitCombo13Item5(){
    if(visitCombo13Item5==null){

      visitCombo13Item5 = new ACListItem();

      visitCombo13Item5.setText("13△◎");

      visitCombo13Item5.setSimpleValueMode(false);
      visitCombo13Item5.put(getVisitCombo13().getRenderBindPath(), "13△◎");
      visitCombo13Item5.put(getVisitCombo13().getBindPath(), new Integer(4));

      addVisitCombo13Item5();
    }
    return visitCombo13Item5;

  }

  /**
   * 訪問日コンボ14を取得します。
   * @return 訪問日コンボ14
   */
  public ACComboBox getVisitCombo14(){
    if(visitCombo14==null){

      visitCombo14 = new ACComboBox();

      visitCombo14.setBindPath("1301117");

      visitCombo14.setEditable(false);

      visitCombo14.setRenderBindPath("ITEM");

      visitCombo14.setModel(getVisitCombo14Model());

      visitCombo14.setPreferredSize(new Dimension(60,20));

      addVisitCombo14();
    }
    return visitCombo14;

  }

  /**
   * 訪問日コンボ14モデルを取得します。
   * @return 訪問日コンボ14モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo14Model(){
    if(visitCombo14Model==null){
      visitCombo14Model = new ACComboBoxModelAdapter();
      addVisitCombo14Model();
    }
    return visitCombo14Model;
  }

  /**
   * 14を取得します。
   * @return 14
   */
  public ACListItem getVisitCombo14Item1(){
    if(visitCombo14Item1==null){

      visitCombo14Item1 = new ACListItem();

      visitCombo14Item1.setText("14");

      visitCombo14Item1.setSimpleValueMode(false);
      visitCombo14Item1.put(getVisitCombo14().getRenderBindPath(), "14");
      visitCombo14Item1.put(getVisitCombo14().getBindPath(), new Integer(0));

      addVisitCombo14Item1();
    }
    return visitCombo14Item1;

  }

  /**
   * 14○を取得します。
   * @return 14○
   */
  public ACListItem getVisitCombo14Item2(){
    if(visitCombo14Item2==null){

      visitCombo14Item2 = new ACListItem();

      visitCombo14Item2.setText("14○");

      visitCombo14Item2.setSimpleValueMode(false);
      visitCombo14Item2.put(getVisitCombo14().getRenderBindPath(), "14○");
      visitCombo14Item2.put(getVisitCombo14().getBindPath(), new Integer(1));

      addVisitCombo14Item2();
    }
    return visitCombo14Item2;

  }

  /**
   * 14△を取得します。
   * @return 14△
   */
  public ACListItem getVisitCombo14Item3(){
    if(visitCombo14Item3==null){

      visitCombo14Item3 = new ACListItem();

      visitCombo14Item3.setText("14△");

      visitCombo14Item3.setSimpleValueMode(false);
      visitCombo14Item3.put(getVisitCombo14().getRenderBindPath(), "14△");
      visitCombo14Item3.put(getVisitCombo14().getBindPath(), new Integer(2));

      addVisitCombo14Item3();
    }
    return visitCombo14Item3;

  }

  /**
   * 14◎を取得します。
   * @return 14◎
   */
  public ACListItem getVisitCombo14Item4(){
    if(visitCombo14Item4==null){

      visitCombo14Item4 = new ACListItem();

      visitCombo14Item4.setText("14◎");

      visitCombo14Item4.setSimpleValueMode(false);
      visitCombo14Item4.put(getVisitCombo14().getRenderBindPath(), "14◎");
      visitCombo14Item4.put(getVisitCombo14().getBindPath(), new Integer(3));

      addVisitCombo14Item4();
    }
    return visitCombo14Item4;

  }

  /**
   * 14△◎を取得します。
   * @return 14△◎
   */
  public ACListItem getVisitCombo14Item5(){
    if(visitCombo14Item5==null){

      visitCombo14Item5 = new ACListItem();

      visitCombo14Item5.setText("14△◎");

      visitCombo14Item5.setSimpleValueMode(false);
      visitCombo14Item5.put(getVisitCombo14().getRenderBindPath(), "14△◎");
      visitCombo14Item5.put(getVisitCombo14().getBindPath(), new Integer(4));

      addVisitCombo14Item5();
    }
    return visitCombo14Item5;

  }

  /**
   * 訪問日コンボ15を取得します。
   * @return 訪問日コンボ15
   */
  public ACComboBox getVisitCombo15(){
    if(visitCombo15==null){

      visitCombo15 = new ACComboBox();

      visitCombo15.setBindPath("1301118");

      visitCombo15.setEditable(false);

      visitCombo15.setRenderBindPath("ITEM");

      visitCombo15.setModel(getVisitCombo15Model());

      visitCombo15.setPreferredSize(new Dimension(60,20));

      addVisitCombo15();
    }
    return visitCombo15;

  }

  /**
   * 訪問日コンボ15モデルを取得します。
   * @return 訪問日コンボ15モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo15Model(){
    if(visitCombo15Model==null){
      visitCombo15Model = new ACComboBoxModelAdapter();
      addVisitCombo15Model();
    }
    return visitCombo15Model;
  }

  /**
   * 15を取得します。
   * @return 15
   */
  public ACListItem getVisitCombo15Item1(){
    if(visitCombo15Item1==null){

      visitCombo15Item1 = new ACListItem();

      visitCombo15Item1.setText("15");

      visitCombo15Item1.setSimpleValueMode(false);
      visitCombo15Item1.put(getVisitCombo15().getRenderBindPath(), "15");
      visitCombo15Item1.put(getVisitCombo15().getBindPath(), new Integer(0));

      addVisitCombo15Item1();
    }
    return visitCombo15Item1;

  }

  /**
   * 15○を取得します。
   * @return 15○
   */
  public ACListItem getVisitCombo15Item2(){
    if(visitCombo15Item2==null){

      visitCombo15Item2 = new ACListItem();

      visitCombo15Item2.setText("15○");

      visitCombo15Item2.setSimpleValueMode(false);
      visitCombo15Item2.put(getVisitCombo15().getRenderBindPath(), "15○");
      visitCombo15Item2.put(getVisitCombo15().getBindPath(), new Integer(1));

      addVisitCombo15Item2();
    }
    return visitCombo15Item2;

  }

  /**
   * 15△を取得します。
   * @return 15△
   */
  public ACListItem getVisitCombo15Item3(){
    if(visitCombo15Item3==null){

      visitCombo15Item3 = new ACListItem();

      visitCombo15Item3.setText("15△");

      visitCombo15Item3.setSimpleValueMode(false);
      visitCombo15Item3.put(getVisitCombo15().getRenderBindPath(), "15△");
      visitCombo15Item3.put(getVisitCombo15().getBindPath(), new Integer(2));

      addVisitCombo15Item3();
    }
    return visitCombo15Item3;

  }

  /**
   * 15◎を取得します。
   * @return 15◎
   */
  public ACListItem getVisitCombo15Item4(){
    if(visitCombo15Item4==null){

      visitCombo15Item4 = new ACListItem();

      visitCombo15Item4.setText("15◎");

      visitCombo15Item4.setSimpleValueMode(false);
      visitCombo15Item4.put(getVisitCombo15().getRenderBindPath(), "15◎");
      visitCombo15Item4.put(getVisitCombo15().getBindPath(), new Integer(3));

      addVisitCombo15Item4();
    }
    return visitCombo15Item4;

  }

  /**
   * 15△◎を取得します。
   * @return 15△◎
   */
  public ACListItem getVisitCombo15Item5(){
    if(visitCombo15Item5==null){

      visitCombo15Item5 = new ACListItem();

      visitCombo15Item5.setText("15△◎");

      visitCombo15Item5.setSimpleValueMode(false);
      visitCombo15Item5.put(getVisitCombo15().getRenderBindPath(), "15△◎");
      visitCombo15Item5.put(getVisitCombo15().getBindPath(), new Integer(4));

      addVisitCombo15Item5();
    }
    return visitCombo15Item5;

  }

  /**
   * 訪問日コンボ16を取得します。
   * @return 訪問日コンボ16
   */
  public ACComboBox getVisitCombo16(){
    if(visitCombo16==null){

      visitCombo16 = new ACComboBox();

      visitCombo16.setBindPath("1301119");

      visitCombo16.setEditable(false);

      visitCombo16.setRenderBindPath("ITEM");

      visitCombo16.setModel(getVisitCombo16Model());

      visitCombo16.setPreferredSize(new Dimension(60,20));

      addVisitCombo16();
    }
    return visitCombo16;

  }

  /**
   * 訪問日コンボ16モデルを取得します。
   * @return 訪問日コンボ16モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo16Model(){
    if(visitCombo16Model==null){
      visitCombo16Model = new ACComboBoxModelAdapter();
      addVisitCombo16Model();
    }
    return visitCombo16Model;
  }

  /**
   * 16を取得します。
   * @return 16
   */
  public ACListItem getVisitCombo16Item1(){
    if(visitCombo16Item1==null){

      visitCombo16Item1 = new ACListItem();

      visitCombo16Item1.setText("16");

      visitCombo16Item1.setSimpleValueMode(false);
      visitCombo16Item1.put(getVisitCombo16().getRenderBindPath(), "16");
      visitCombo16Item1.put(getVisitCombo16().getBindPath(), new Integer(0));

      addVisitCombo16Item1();
    }
    return visitCombo16Item1;

  }

  /**
   * 16○を取得します。
   * @return 16○
   */
  public ACListItem getVisitCombo16Item2(){
    if(visitCombo16Item2==null){

      visitCombo16Item2 = new ACListItem();

      visitCombo16Item2.setText("16○");

      visitCombo16Item2.setSimpleValueMode(false);
      visitCombo16Item2.put(getVisitCombo16().getRenderBindPath(), "16○");
      visitCombo16Item2.put(getVisitCombo16().getBindPath(), new Integer(1));

      addVisitCombo16Item2();
    }
    return visitCombo16Item2;

  }

  /**
   * 16△を取得します。
   * @return 16△
   */
  public ACListItem getVisitCombo16Item3(){
    if(visitCombo16Item3==null){

      visitCombo16Item3 = new ACListItem();

      visitCombo16Item3.setText("16△");

      visitCombo16Item3.setSimpleValueMode(false);
      visitCombo16Item3.put(getVisitCombo16().getRenderBindPath(), "16△");
      visitCombo16Item3.put(getVisitCombo16().getBindPath(), new Integer(2));

      addVisitCombo16Item3();
    }
    return visitCombo16Item3;

  }

  /**
   * 16◎を取得します。
   * @return 16◎
   */
  public ACListItem getVisitCombo16Item4(){
    if(visitCombo16Item4==null){

      visitCombo16Item4 = new ACListItem();

      visitCombo16Item4.setText("16◎");

      visitCombo16Item4.setSimpleValueMode(false);
      visitCombo16Item4.put(getVisitCombo16().getRenderBindPath(), "16◎");
      visitCombo16Item4.put(getVisitCombo16().getBindPath(), new Integer(3));

      addVisitCombo16Item4();
    }
    return visitCombo16Item4;

  }

  /**
   * 16△◎を取得します。
   * @return 16△◎
   */
  public ACListItem getVisitCombo16Item5(){
    if(visitCombo16Item5==null){

      visitCombo16Item5 = new ACListItem();

      visitCombo16Item5.setText("16△◎");

      visitCombo16Item5.setSimpleValueMode(false);
      visitCombo16Item5.put(getVisitCombo16().getRenderBindPath(), "16△◎");
      visitCombo16Item5.put(getVisitCombo16().getBindPath(), new Integer(4));

      addVisitCombo16Item5();
    }
    return visitCombo16Item5;

  }

  /**
   * 訪問日コンボ17を取得します。
   * @return 訪問日コンボ17
   */
  public ACComboBox getVisitCombo17(){
    if(visitCombo17==null){

      visitCombo17 = new ACComboBox();

      visitCombo17.setBindPath("1301120");

      visitCombo17.setEditable(false);

      visitCombo17.setRenderBindPath("ITEM");

      visitCombo17.setModel(getVisitCombo17Model());

      visitCombo17.setPreferredSize(new Dimension(60,20));

      addVisitCombo17();
    }
    return visitCombo17;

  }

  /**
   * 訪問日コンボ17モデルを取得します。
   * @return 訪問日コンボ17モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo17Model(){
    if(visitCombo17Model==null){
      visitCombo17Model = new ACComboBoxModelAdapter();
      addVisitCombo17Model();
    }
    return visitCombo17Model;
  }

  /**
   * 17を取得します。
   * @return 17
   */
  public ACListItem getVisitCombo17Item1(){
    if(visitCombo17Item1==null){

      visitCombo17Item1 = new ACListItem();

      visitCombo17Item1.setText("17");

      visitCombo17Item1.setSimpleValueMode(false);
      visitCombo17Item1.put(getVisitCombo17().getRenderBindPath(), "17");
      visitCombo17Item1.put(getVisitCombo17().getBindPath(), new Integer(0));

      addVisitCombo17Item1();
    }
    return visitCombo17Item1;

  }

  /**
   * 17○を取得します。
   * @return 17○
   */
  public ACListItem getVisitCombo17Item2(){
    if(visitCombo17Item2==null){

      visitCombo17Item2 = new ACListItem();

      visitCombo17Item2.setText("17○");

      visitCombo17Item2.setSimpleValueMode(false);
      visitCombo17Item2.put(getVisitCombo17().getRenderBindPath(), "17○");
      visitCombo17Item2.put(getVisitCombo17().getBindPath(), new Integer(1));

      addVisitCombo17Item2();
    }
    return visitCombo17Item2;

  }

  /**
   * 17△を取得します。
   * @return 17△
   */
  public ACListItem getVisitCombo17Item3(){
    if(visitCombo17Item3==null){

      visitCombo17Item3 = new ACListItem();

      visitCombo17Item3.setText("17△");

      visitCombo17Item3.setSimpleValueMode(false);
      visitCombo17Item3.put(getVisitCombo17().getRenderBindPath(), "17△");
      visitCombo17Item3.put(getVisitCombo17().getBindPath(), new Integer(2));

      addVisitCombo17Item3();
    }
    return visitCombo17Item3;

  }

  /**
   * 17◎を取得します。
   * @return 17◎
   */
  public ACListItem getVisitCombo17Item4(){
    if(visitCombo17Item4==null){

      visitCombo17Item4 = new ACListItem();

      visitCombo17Item4.setText("17◎");

      visitCombo17Item4.setSimpleValueMode(false);
      visitCombo17Item4.put(getVisitCombo17().getRenderBindPath(), "17◎");
      visitCombo17Item4.put(getVisitCombo17().getBindPath(), new Integer(3));

      addVisitCombo17Item4();
    }
    return visitCombo17Item4;

  }

  /**
   * 17△◎を取得します。
   * @return 17△◎
   */
  public ACListItem getVisitCombo17Item5(){
    if(visitCombo17Item5==null){

      visitCombo17Item5 = new ACListItem();

      visitCombo17Item5.setText("17△◎");

      visitCombo17Item5.setSimpleValueMode(false);
      visitCombo17Item5.put(getVisitCombo17().getRenderBindPath(), "17△◎");
      visitCombo17Item5.put(getVisitCombo17().getBindPath(), new Integer(4));

      addVisitCombo17Item5();
    }
    return visitCombo17Item5;

  }

  /**
   * 訪問日コンボ18を取得します。
   * @return 訪問日コンボ18
   */
  public ACComboBox getVisitCombo18(){
    if(visitCombo18==null){

      visitCombo18 = new ACComboBox();

      visitCombo18.setBindPath("1301121");

      visitCombo18.setEditable(false);

      visitCombo18.setRenderBindPath("ITEM");

      visitCombo18.setModel(getVisitCombo18Model());

      visitCombo18.setPreferredSize(new Dimension(60,20));

      addVisitCombo18();
    }
    return visitCombo18;

  }

  /**
   * 訪問日コンボ18モデルを取得します。
   * @return 訪問日コンボ18モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo18Model(){
    if(visitCombo18Model==null){
      visitCombo18Model = new ACComboBoxModelAdapter();
      addVisitCombo18Model();
    }
    return visitCombo18Model;
  }

  /**
   * 18を取得します。
   * @return 18
   */
  public ACListItem getVisitCombo18Item1(){
    if(visitCombo18Item1==null){

      visitCombo18Item1 = new ACListItem();

      visitCombo18Item1.setText("18");

      visitCombo18Item1.setSimpleValueMode(false);
      visitCombo18Item1.put(getVisitCombo18().getRenderBindPath(), "18");
      visitCombo18Item1.put(getVisitCombo18().getBindPath(), new Integer(0));

      addVisitCombo18Item1();
    }
    return visitCombo18Item1;

  }

  /**
   * 18○を取得します。
   * @return 18○
   */
  public ACListItem getVisitCombo18Item2(){
    if(visitCombo18Item2==null){

      visitCombo18Item2 = new ACListItem();

      visitCombo18Item2.setText("18○");

      visitCombo18Item2.setSimpleValueMode(false);
      visitCombo18Item2.put(getVisitCombo18().getRenderBindPath(), "18○");
      visitCombo18Item2.put(getVisitCombo18().getBindPath(), new Integer(1));

      addVisitCombo18Item2();
    }
    return visitCombo18Item2;

  }

  /**
   * 18△を取得します。
   * @return 18△
   */
  public ACListItem getVisitCombo18Item3(){
    if(visitCombo18Item3==null){

      visitCombo18Item3 = new ACListItem();

      visitCombo18Item3.setText("18△");

      visitCombo18Item3.setSimpleValueMode(false);
      visitCombo18Item3.put(getVisitCombo18().getRenderBindPath(), "18△");
      visitCombo18Item3.put(getVisitCombo18().getBindPath(), new Integer(2));

      addVisitCombo18Item3();
    }
    return visitCombo18Item3;

  }

  /**
   * 18◎を取得します。
   * @return 18◎
   */
  public ACListItem getVisitCombo18Item4(){
    if(visitCombo18Item4==null){

      visitCombo18Item4 = new ACListItem();

      visitCombo18Item4.setText("18◎");

      visitCombo18Item4.setSimpleValueMode(false);
      visitCombo18Item4.put(getVisitCombo18().getRenderBindPath(), "18◎");
      visitCombo18Item4.put(getVisitCombo18().getBindPath(), new Integer(3));

      addVisitCombo18Item4();
    }
    return visitCombo18Item4;

  }

  /**
   * 18△◎を取得します。
   * @return 18△◎
   */
  public ACListItem getVisitCombo18Item5(){
    if(visitCombo18Item5==null){

      visitCombo18Item5 = new ACListItem();

      visitCombo18Item5.setText("18△◎");

      visitCombo18Item5.setSimpleValueMode(false);
      visitCombo18Item5.put(getVisitCombo18().getRenderBindPath(), "18△◎");
      visitCombo18Item5.put(getVisitCombo18().getBindPath(), new Integer(4));

      addVisitCombo18Item5();
    }
    return visitCombo18Item5;

  }

  /**
   * 訪問日コンボ19を取得します。
   * @return 訪問日コンボ19
   */
  public ACComboBox getVisitCombo19(){
    if(visitCombo19==null){

      visitCombo19 = new ACComboBox();

      visitCombo19.setBindPath("1301122");

      visitCombo19.setEditable(false);

      visitCombo19.setRenderBindPath("ITEM");

      visitCombo19.setModel(getVisitCombo19Model());

      visitCombo19.setPreferredSize(new Dimension(60,20));

      addVisitCombo19();
    }
    return visitCombo19;

  }

  /**
   * 訪問日コンボ19モデルを取得します。
   * @return 訪問日コンボ19モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo19Model(){
    if(visitCombo19Model==null){
      visitCombo19Model = new ACComboBoxModelAdapter();
      addVisitCombo19Model();
    }
    return visitCombo19Model;
  }

  /**
   * 19を取得します。
   * @return 19
   */
  public ACListItem getVisitCombo19Item1(){
    if(visitCombo19Item1==null){

      visitCombo19Item1 = new ACListItem();

      visitCombo19Item1.setText("19");

      visitCombo19Item1.setSimpleValueMode(false);
      visitCombo19Item1.put(getVisitCombo19().getRenderBindPath(), "19");
      visitCombo19Item1.put(getVisitCombo19().getBindPath(), new Integer(0));

      addVisitCombo19Item1();
    }
    return visitCombo19Item1;

  }

  /**
   * 19○を取得します。
   * @return 19○
   */
  public ACListItem getVisitCombo19Item2(){
    if(visitCombo19Item2==null){

      visitCombo19Item2 = new ACListItem();

      visitCombo19Item2.setText("19○");

      visitCombo19Item2.setSimpleValueMode(false);
      visitCombo19Item2.put(getVisitCombo19().getRenderBindPath(), "19○");
      visitCombo19Item2.put(getVisitCombo19().getBindPath(), new Integer(1));

      addVisitCombo19Item2();
    }
    return visitCombo19Item2;

  }

  /**
   * 19△を取得します。
   * @return 19△
   */
  public ACListItem getVisitCombo19Item3(){
    if(visitCombo19Item3==null){

      visitCombo19Item3 = new ACListItem();

      visitCombo19Item3.setText("19△");

      visitCombo19Item3.setSimpleValueMode(false);
      visitCombo19Item3.put(getVisitCombo19().getRenderBindPath(), "19△");
      visitCombo19Item3.put(getVisitCombo19().getBindPath(), new Integer(2));

      addVisitCombo19Item3();
    }
    return visitCombo19Item3;

  }

  /**
   * 19◎を取得します。
   * @return 19◎
   */
  public ACListItem getVisitCombo19Item4(){
    if(visitCombo19Item4==null){

      visitCombo19Item4 = new ACListItem();

      visitCombo19Item4.setText("19◎");

      visitCombo19Item4.setSimpleValueMode(false);
      visitCombo19Item4.put(getVisitCombo19().getRenderBindPath(), "19◎");
      visitCombo19Item4.put(getVisitCombo19().getBindPath(), new Integer(3));

      addVisitCombo19Item4();
    }
    return visitCombo19Item4;

  }

  /**
   * 19△◎を取得します。
   * @return 19△◎
   */
  public ACListItem getVisitCombo19Item5(){
    if(visitCombo19Item5==null){

      visitCombo19Item5 = new ACListItem();

      visitCombo19Item5.setText("19△◎");

      visitCombo19Item5.setSimpleValueMode(false);
      visitCombo19Item5.put(getVisitCombo19().getRenderBindPath(), "19△◎");
      visitCombo19Item5.put(getVisitCombo19().getBindPath(), new Integer(4));

      addVisitCombo19Item5();
    }
    return visitCombo19Item5;

  }

  /**
   * 訪問日コンボ20を取得します。
   * @return 訪問日コンボ20
   */
  public ACComboBox getVisitCombo20(){
    if(visitCombo20==null){

      visitCombo20 = new ACComboBox();

      visitCombo20.setBindPath("1301123");

      visitCombo20.setEditable(false);

      visitCombo20.setRenderBindPath("ITEM");

      visitCombo20.setModel(getVisitCombo20Model());

      visitCombo20.setPreferredSize(new Dimension(60,20));

      addVisitCombo20();
    }
    return visitCombo20;

  }

  /**
   * 訪問日コンボ20モデルを取得します。
   * @return 訪問日コンボ20モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo20Model(){
    if(visitCombo20Model==null){
      visitCombo20Model = new ACComboBoxModelAdapter();
      addVisitCombo20Model();
    }
    return visitCombo20Model;
  }

  /**
   * 20を取得します。
   * @return 20
   */
  public ACListItem getVisitCombo20Item1(){
    if(visitCombo20Item1==null){

      visitCombo20Item1 = new ACListItem();

      visitCombo20Item1.setText("20");

      visitCombo20Item1.setSimpleValueMode(false);
      visitCombo20Item1.put(getVisitCombo20().getRenderBindPath(), "20");
      visitCombo20Item1.put(getVisitCombo20().getBindPath(), new Integer(0));

      addVisitCombo20Item1();
    }
    return visitCombo20Item1;

  }

  /**
   * 20○を取得します。
   * @return 20○
   */
  public ACListItem getVisitCombo20Item2(){
    if(visitCombo20Item2==null){

      visitCombo20Item2 = new ACListItem();

      visitCombo20Item2.setText("20○");

      visitCombo20Item2.setSimpleValueMode(false);
      visitCombo20Item2.put(getVisitCombo20().getRenderBindPath(), "20○");
      visitCombo20Item2.put(getVisitCombo20().getBindPath(), new Integer(1));

      addVisitCombo20Item2();
    }
    return visitCombo20Item2;

  }

  /**
   * 20△を取得します。
   * @return 20△
   */
  public ACListItem getVisitCombo20Item3(){
    if(visitCombo20Item3==null){

      visitCombo20Item3 = new ACListItem();

      visitCombo20Item3.setText("20△");

      visitCombo20Item3.setSimpleValueMode(false);
      visitCombo20Item3.put(getVisitCombo20().getRenderBindPath(), "20△");
      visitCombo20Item3.put(getVisitCombo20().getBindPath(), new Integer(2));

      addVisitCombo20Item3();
    }
    return visitCombo20Item3;

  }

  /**
   * 20◎を取得します。
   * @return 20◎
   */
  public ACListItem getVisitCombo20Item4(){
    if(visitCombo20Item4==null){

      visitCombo20Item4 = new ACListItem();

      visitCombo20Item4.setText("20◎");

      visitCombo20Item4.setSimpleValueMode(false);
      visitCombo20Item4.put(getVisitCombo20().getRenderBindPath(), "20◎");
      visitCombo20Item4.put(getVisitCombo20().getBindPath(), new Integer(3));

      addVisitCombo20Item4();
    }
    return visitCombo20Item4;

  }

  /**
   * 20△◎を取得します。
   * @return 20△◎
   */
  public ACListItem getVisitCombo20Item5(){
    if(visitCombo20Item5==null){

      visitCombo20Item5 = new ACListItem();

      visitCombo20Item5.setText("20△◎");

      visitCombo20Item5.setSimpleValueMode(false);
      visitCombo20Item5.put(getVisitCombo20().getRenderBindPath(), "20△◎");
      visitCombo20Item5.put(getVisitCombo20().getBindPath(), new Integer(4));

      addVisitCombo20Item5();
    }
    return visitCombo20Item5;

  }

  /**
   * 訪問日コンボ21を取得します。
   * @return 訪問日コンボ21
   */
  public ACComboBox getVisitCombo21(){
    if(visitCombo21==null){

      visitCombo21 = new ACComboBox();

      visitCombo21.setBindPath("1301124");

      visitCombo21.setEditable(false);

      visitCombo21.setRenderBindPath("ITEM");

      visitCombo21.setModel(getVisitCombo21Model());

      visitCombo21.setPreferredSize(new Dimension(60,20));

      addVisitCombo21();
    }
    return visitCombo21;

  }

  /**
   * 訪問日コンボ21モデルを取得します。
   * @return 訪問日コンボ21モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo21Model(){
    if(visitCombo21Model==null){
      visitCombo21Model = new ACComboBoxModelAdapter();
      addVisitCombo21Model();
    }
    return visitCombo21Model;
  }

  /**
   * 21を取得します。
   * @return 21
   */
  public ACListItem getVisitCombo21Item1(){
    if(visitCombo21Item1==null){

      visitCombo21Item1 = new ACListItem();

      visitCombo21Item1.setText("21");

      visitCombo21Item1.setSimpleValueMode(false);
      visitCombo21Item1.put(getVisitCombo21().getRenderBindPath(), "21");
      visitCombo21Item1.put(getVisitCombo21().getBindPath(), new Integer(0));

      addVisitCombo21Item1();
    }
    return visitCombo21Item1;

  }

  /**
   * 21○を取得します。
   * @return 21○
   */
  public ACListItem getVisitCombo21Item2(){
    if(visitCombo21Item2==null){

      visitCombo21Item2 = new ACListItem();

      visitCombo21Item2.setText("21○");

      visitCombo21Item2.setSimpleValueMode(false);
      visitCombo21Item2.put(getVisitCombo21().getRenderBindPath(), "21○");
      visitCombo21Item2.put(getVisitCombo21().getBindPath(), new Integer(1));

      addVisitCombo21Item2();
    }
    return visitCombo21Item2;

  }

  /**
   * 21△を取得します。
   * @return 21△
   */
  public ACListItem getVisitCombo21Item3(){
    if(visitCombo21Item3==null){

      visitCombo21Item3 = new ACListItem();

      visitCombo21Item3.setText("21△");

      visitCombo21Item3.setSimpleValueMode(false);
      visitCombo21Item3.put(getVisitCombo21().getRenderBindPath(), "21△");
      visitCombo21Item3.put(getVisitCombo21().getBindPath(), new Integer(2));

      addVisitCombo21Item3();
    }
    return visitCombo21Item3;

  }

  /**
   * 21◎を取得します。
   * @return 21◎
   */
  public ACListItem getVisitCombo21Item4(){
    if(visitCombo21Item4==null){

      visitCombo21Item4 = new ACListItem();

      visitCombo21Item4.setText("21◎");

      visitCombo21Item4.setSimpleValueMode(false);
      visitCombo21Item4.put(getVisitCombo21().getRenderBindPath(), "21◎");
      visitCombo21Item4.put(getVisitCombo21().getBindPath(), new Integer(3));

      addVisitCombo21Item4();
    }
    return visitCombo21Item4;

  }

  /**
   * 21△◎を取得します。
   * @return 21△◎
   */
  public ACListItem getVisitCombo21Item5(){
    if(visitCombo21Item5==null){

      visitCombo21Item5 = new ACListItem();

      visitCombo21Item5.setText("21△◎");

      visitCombo21Item5.setSimpleValueMode(false);
      visitCombo21Item5.put(getVisitCombo21().getRenderBindPath(), "21△◎");
      visitCombo21Item5.put(getVisitCombo21().getBindPath(), new Integer(4));

      addVisitCombo21Item5();
    }
    return visitCombo21Item5;

  }

  /**
   * 訪問日コンボ22を取得します。
   * @return 訪問日コンボ22
   */
  public ACComboBox getVisitCombo22(){
    if(visitCombo22==null){

      visitCombo22 = new ACComboBox();

      visitCombo22.setBindPath("1301125");

      visitCombo22.setEditable(false);

      visitCombo22.setRenderBindPath("ITEM");

      visitCombo22.setModel(getVisitCombo22Model());

      visitCombo22.setPreferredSize(new Dimension(60,20));

      addVisitCombo22();
    }
    return visitCombo22;

  }

  /**
   * 訪問日コンボ22モデルを取得します。
   * @return 訪問日コンボ22モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo22Model(){
    if(visitCombo22Model==null){
      visitCombo22Model = new ACComboBoxModelAdapter();
      addVisitCombo22Model();
    }
    return visitCombo22Model;
  }

  /**
   * 22を取得します。
   * @return 22
   */
  public ACListItem getVisitCombo22Item1(){
    if(visitCombo22Item1==null){

      visitCombo22Item1 = new ACListItem();

      visitCombo22Item1.setText("22");

      visitCombo22Item1.setSimpleValueMode(false);
      visitCombo22Item1.put(getVisitCombo22().getRenderBindPath(), "22");
      visitCombo22Item1.put(getVisitCombo22().getBindPath(), new Integer(0));

      addVisitCombo22Item1();
    }
    return visitCombo22Item1;

  }

  /**
   * 22○を取得します。
   * @return 22○
   */
  public ACListItem getVisitCombo22Item2(){
    if(visitCombo22Item2==null){

      visitCombo22Item2 = new ACListItem();

      visitCombo22Item2.setText("22○");

      visitCombo22Item2.setSimpleValueMode(false);
      visitCombo22Item2.put(getVisitCombo22().getRenderBindPath(), "22○");
      visitCombo22Item2.put(getVisitCombo22().getBindPath(), new Integer(1));

      addVisitCombo22Item2();
    }
    return visitCombo22Item2;

  }

  /**
   * 22△を取得します。
   * @return 22△
   */
  public ACListItem getVisitCombo22Item3(){
    if(visitCombo22Item3==null){

      visitCombo22Item3 = new ACListItem();

      visitCombo22Item3.setText("22△");

      visitCombo22Item3.setSimpleValueMode(false);
      visitCombo22Item3.put(getVisitCombo22().getRenderBindPath(), "22△");
      visitCombo22Item3.put(getVisitCombo22().getBindPath(), new Integer(2));

      addVisitCombo22Item3();
    }
    return visitCombo22Item3;

  }

  /**
   * 22◎を取得します。
   * @return 22◎
   */
  public ACListItem getVisitCombo22Item4(){
    if(visitCombo22Item4==null){

      visitCombo22Item4 = new ACListItem();

      visitCombo22Item4.setText("22◎");

      visitCombo22Item4.setSimpleValueMode(false);
      visitCombo22Item4.put(getVisitCombo22().getRenderBindPath(), "22◎");
      visitCombo22Item4.put(getVisitCombo22().getBindPath(), new Integer(3));

      addVisitCombo22Item4();
    }
    return visitCombo22Item4;

  }

  /**
   * 22△◎を取得します。
   * @return 22△◎
   */
  public ACListItem getVisitCombo22Item5(){
    if(visitCombo22Item5==null){

      visitCombo22Item5 = new ACListItem();

      visitCombo22Item5.setText("22△◎");

      visitCombo22Item5.setSimpleValueMode(false);
      visitCombo22Item5.put(getVisitCombo22().getRenderBindPath(), "22△◎");
      visitCombo22Item5.put(getVisitCombo22().getBindPath(), new Integer(4));

      addVisitCombo22Item5();
    }
    return visitCombo22Item5;

  }

  /**
   * 訪問日コンボ23を取得します。
   * @return 訪問日コンボ23
   */
  public ACComboBox getVisitCombo23(){
    if(visitCombo23==null){

      visitCombo23 = new ACComboBox();

      visitCombo23.setBindPath("1301126");

      visitCombo23.setEditable(false);

      visitCombo23.setRenderBindPath("ITEM");

      visitCombo23.setModel(getVisitCombo23Model());

      visitCombo23.setPreferredSize(new Dimension(60,20));

      addVisitCombo23();
    }
    return visitCombo23;

  }

  /**
   * 訪問日コンボ23モデルを取得します。
   * @return 訪問日コンボ23モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo23Model(){
    if(visitCombo23Model==null){
      visitCombo23Model = new ACComboBoxModelAdapter();
      addVisitCombo23Model();
    }
    return visitCombo23Model;
  }

  /**
   * 23を取得します。
   * @return 23
   */
  public ACListItem getVisitCombo23Item1(){
    if(visitCombo23Item1==null){

      visitCombo23Item1 = new ACListItem();

      visitCombo23Item1.setText("23");

      visitCombo23Item1.setSimpleValueMode(false);
      visitCombo23Item1.put(getVisitCombo23().getRenderBindPath(), "23");
      visitCombo23Item1.put(getVisitCombo23().getBindPath(), new Integer(0));

      addVisitCombo23Item1();
    }
    return visitCombo23Item1;

  }

  /**
   * 23○を取得します。
   * @return 23○
   */
  public ACListItem getVisitCombo23Item2(){
    if(visitCombo23Item2==null){

      visitCombo23Item2 = new ACListItem();

      visitCombo23Item2.setText("23○");

      visitCombo23Item2.setSimpleValueMode(false);
      visitCombo23Item2.put(getVisitCombo23().getRenderBindPath(), "23○");
      visitCombo23Item2.put(getVisitCombo23().getBindPath(), new Integer(1));

      addVisitCombo23Item2();
    }
    return visitCombo23Item2;

  }

  /**
   * 23△を取得します。
   * @return 23△
   */
  public ACListItem getVisitCombo23Item3(){
    if(visitCombo23Item3==null){

      visitCombo23Item3 = new ACListItem();

      visitCombo23Item3.setText("23△");

      visitCombo23Item3.setSimpleValueMode(false);
      visitCombo23Item3.put(getVisitCombo23().getRenderBindPath(), "23△");
      visitCombo23Item3.put(getVisitCombo23().getBindPath(), new Integer(2));

      addVisitCombo23Item3();
    }
    return visitCombo23Item3;

  }

  /**
   * 23◎を取得します。
   * @return 23◎
   */
  public ACListItem getVisitCombo23Item4(){
    if(visitCombo23Item4==null){

      visitCombo23Item4 = new ACListItem();

      visitCombo23Item4.setText("23◎");

      visitCombo23Item4.setSimpleValueMode(false);
      visitCombo23Item4.put(getVisitCombo23().getRenderBindPath(), "23◎");
      visitCombo23Item4.put(getVisitCombo23().getBindPath(), new Integer(3));

      addVisitCombo23Item4();
    }
    return visitCombo23Item4;

  }

  /**
   * 23△◎を取得します。
   * @return 23△◎
   */
  public ACListItem getVisitCombo23Item5(){
    if(visitCombo23Item5==null){

      visitCombo23Item5 = new ACListItem();

      visitCombo23Item5.setText("23△◎");

      visitCombo23Item5.setSimpleValueMode(false);
      visitCombo23Item5.put(getVisitCombo23().getRenderBindPath(), "23△◎");
      visitCombo23Item5.put(getVisitCombo23().getBindPath(), new Integer(4));

      addVisitCombo23Item5();
    }
    return visitCombo23Item5;

  }

  /**
   * 訪問日コンボ24を取得します。
   * @return 訪問日コンボ24
   */
  public ACComboBox getVisitCombo24(){
    if(visitCombo24==null){

      visitCombo24 = new ACComboBox();

      visitCombo24.setBindPath("1301127");

      visitCombo24.setEditable(false);

      visitCombo24.setRenderBindPath("ITEM");

      visitCombo24.setModel(getVisitCombo24Model());

      visitCombo24.setPreferredSize(new Dimension(60,20));

      addVisitCombo24();
    }
    return visitCombo24;

  }

  /**
   * 訪問日コンボ24モデルを取得します。
   * @return 訪問日コンボ24モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo24Model(){
    if(visitCombo24Model==null){
      visitCombo24Model = new ACComboBoxModelAdapter();
      addVisitCombo24Model();
    }
    return visitCombo24Model;
  }

  /**
   * 24を取得します。
   * @return 24
   */
  public ACListItem getVisitCombo24Item1(){
    if(visitCombo24Item1==null){

      visitCombo24Item1 = new ACListItem();

      visitCombo24Item1.setText("24");

      visitCombo24Item1.setSimpleValueMode(false);
      visitCombo24Item1.put(getVisitCombo24().getRenderBindPath(), "24");
      visitCombo24Item1.put(getVisitCombo24().getBindPath(), new Integer(0));

      addVisitCombo24Item1();
    }
    return visitCombo24Item1;

  }

  /**
   * 24○を取得します。
   * @return 24○
   */
  public ACListItem getVisitCombo24Item2(){
    if(visitCombo24Item2==null){

      visitCombo24Item2 = new ACListItem();

      visitCombo24Item2.setText("24○");

      visitCombo24Item2.setSimpleValueMode(false);
      visitCombo24Item2.put(getVisitCombo24().getRenderBindPath(), "24○");
      visitCombo24Item2.put(getVisitCombo24().getBindPath(), new Integer(1));

      addVisitCombo24Item2();
    }
    return visitCombo24Item2;

  }

  /**
   * 24△を取得します。
   * @return 24△
   */
  public ACListItem getVisitCombo24Item3(){
    if(visitCombo24Item3==null){

      visitCombo24Item3 = new ACListItem();

      visitCombo24Item3.setText("24△");

      visitCombo24Item3.setSimpleValueMode(false);
      visitCombo24Item3.put(getVisitCombo24().getRenderBindPath(), "24△");
      visitCombo24Item3.put(getVisitCombo24().getBindPath(), new Integer(2));

      addVisitCombo24Item3();
    }
    return visitCombo24Item3;

  }

  /**
   * 24◎を取得します。
   * @return 24◎
   */
  public ACListItem getVisitCombo24Item4(){
    if(visitCombo24Item4==null){

      visitCombo24Item4 = new ACListItem();

      visitCombo24Item4.setText("24◎");

      visitCombo24Item4.setSimpleValueMode(false);
      visitCombo24Item4.put(getVisitCombo24().getRenderBindPath(), "24◎");
      visitCombo24Item4.put(getVisitCombo24().getBindPath(), new Integer(3));

      addVisitCombo24Item4();
    }
    return visitCombo24Item4;

  }

  /**
   * 24△◎を取得します。
   * @return 24△◎
   */
  public ACListItem getVisitCombo24Item5(){
    if(visitCombo24Item5==null){

      visitCombo24Item5 = new ACListItem();

      visitCombo24Item5.setText("24△◎");

      visitCombo24Item5.setSimpleValueMode(false);
      visitCombo24Item5.put(getVisitCombo24().getRenderBindPath(), "24△◎");
      visitCombo24Item5.put(getVisitCombo24().getBindPath(), new Integer(4));

      addVisitCombo24Item5();
    }
    return visitCombo24Item5;

  }

  /**
   * 訪問日コンボ25を取得します。
   * @return 訪問日コンボ25
   */
  public ACComboBox getVisitCombo25(){
    if(visitCombo25==null){

      visitCombo25 = new ACComboBox();

      visitCombo25.setBindPath("1301128");

      visitCombo25.setEditable(false);

      visitCombo25.setRenderBindPath("ITEM");

      visitCombo25.setModel(getVisitCombo25Model());

      visitCombo25.setPreferredSize(new Dimension(60,20));

      addVisitCombo25();
    }
    return visitCombo25;

  }

  /**
   * 訪問日コンボ25モデルを取得します。
   * @return 訪問日コンボ25モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo25Model(){
    if(visitCombo25Model==null){
      visitCombo25Model = new ACComboBoxModelAdapter();
      addVisitCombo25Model();
    }
    return visitCombo25Model;
  }

  /**
   * 25を取得します。
   * @return 25
   */
  public ACListItem getVisitCombo25Item1(){
    if(visitCombo25Item1==null){

      visitCombo25Item1 = new ACListItem();

      visitCombo25Item1.setText("25");

      visitCombo25Item1.setSimpleValueMode(false);
      visitCombo25Item1.put(getVisitCombo25().getRenderBindPath(), "25");
      visitCombo25Item1.put(getVisitCombo25().getBindPath(), new Integer(0));

      addVisitCombo25Item1();
    }
    return visitCombo25Item1;

  }

  /**
   * 25○を取得します。
   * @return 25○
   */
  public ACListItem getVisitCombo25Item2(){
    if(visitCombo25Item2==null){

      visitCombo25Item2 = new ACListItem();

      visitCombo25Item2.setText("25○");

      visitCombo25Item2.setSimpleValueMode(false);
      visitCombo25Item2.put(getVisitCombo25().getRenderBindPath(), "25○");
      visitCombo25Item2.put(getVisitCombo25().getBindPath(), new Integer(1));

      addVisitCombo25Item2();
    }
    return visitCombo25Item2;

  }

  /**
   * 25△を取得します。
   * @return 25△
   */
  public ACListItem getVisitCombo25Item3(){
    if(visitCombo25Item3==null){

      visitCombo25Item3 = new ACListItem();

      visitCombo25Item3.setText("25△");

      visitCombo25Item3.setSimpleValueMode(false);
      visitCombo25Item3.put(getVisitCombo25().getRenderBindPath(), "25△");
      visitCombo25Item3.put(getVisitCombo25().getBindPath(), new Integer(2));

      addVisitCombo25Item3();
    }
    return visitCombo25Item3;

  }

  /**
   * 25◎を取得します。
   * @return 25◎
   */
  public ACListItem getVisitCombo25Item4(){
    if(visitCombo25Item4==null){

      visitCombo25Item4 = new ACListItem();

      visitCombo25Item4.setText("25◎");

      visitCombo25Item4.setSimpleValueMode(false);
      visitCombo25Item4.put(getVisitCombo25().getRenderBindPath(), "25◎");
      visitCombo25Item4.put(getVisitCombo25().getBindPath(), new Integer(3));

      addVisitCombo25Item4();
    }
    return visitCombo25Item4;

  }

  /**
   * 25△◎を取得します。
   * @return 25△◎
   */
  public ACListItem getVisitCombo25Item5(){
    if(visitCombo25Item5==null){

      visitCombo25Item5 = new ACListItem();

      visitCombo25Item5.setText("25△◎");

      visitCombo25Item5.setSimpleValueMode(false);
      visitCombo25Item5.put(getVisitCombo25().getRenderBindPath(), "25△◎");
      visitCombo25Item5.put(getVisitCombo25().getBindPath(), new Integer(4));

      addVisitCombo25Item5();
    }
    return visitCombo25Item5;

  }

  /**
   * 訪問日コンボ26を取得します。
   * @return 訪問日コンボ26
   */
  public ACComboBox getVisitCombo26(){
    if(visitCombo26==null){

      visitCombo26 = new ACComboBox();

      visitCombo26.setBindPath("1301129");

      visitCombo26.setEditable(false);

      visitCombo26.setRenderBindPath("ITEM");

      visitCombo26.setModel(getVisitCombo26Model());

      visitCombo26.setPreferredSize(new Dimension(60,20));

      addVisitCombo26();
    }
    return visitCombo26;

  }

  /**
   * 訪問日コンボ26モデルを取得します。
   * @return 訪問日コンボ26モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo26Model(){
    if(visitCombo26Model==null){
      visitCombo26Model = new ACComboBoxModelAdapter();
      addVisitCombo26Model();
    }
    return visitCombo26Model;
  }

  /**
   * 26を取得します。
   * @return 26
   */
  public ACListItem getVisitCombo26Item1(){
    if(visitCombo26Item1==null){

      visitCombo26Item1 = new ACListItem();

      visitCombo26Item1.setText("26");

      visitCombo26Item1.setSimpleValueMode(false);
      visitCombo26Item1.put(getVisitCombo26().getRenderBindPath(), "26");
      visitCombo26Item1.put(getVisitCombo26().getBindPath(), new Integer(0));

      addVisitCombo26Item1();
    }
    return visitCombo26Item1;

  }

  /**
   * 26○を取得します。
   * @return 26○
   */
  public ACListItem getVisitCombo26Item2(){
    if(visitCombo26Item2==null){

      visitCombo26Item2 = new ACListItem();

      visitCombo26Item2.setText("26○");

      visitCombo26Item2.setSimpleValueMode(false);
      visitCombo26Item2.put(getVisitCombo26().getRenderBindPath(), "26○");
      visitCombo26Item2.put(getVisitCombo26().getBindPath(), new Integer(1));

      addVisitCombo26Item2();
    }
    return visitCombo26Item2;

  }

  /**
   * 26△を取得します。
   * @return 26△
   */
  public ACListItem getVisitCombo26Item3(){
    if(visitCombo26Item3==null){

      visitCombo26Item3 = new ACListItem();

      visitCombo26Item3.setText("26△");

      visitCombo26Item3.setSimpleValueMode(false);
      visitCombo26Item3.put(getVisitCombo26().getRenderBindPath(), "26△");
      visitCombo26Item3.put(getVisitCombo26().getBindPath(), new Integer(2));

      addVisitCombo26Item3();
    }
    return visitCombo26Item3;

  }

  /**
   * 26◎を取得します。
   * @return 26◎
   */
  public ACListItem getVisitCombo26Item4(){
    if(visitCombo26Item4==null){

      visitCombo26Item4 = new ACListItem();

      visitCombo26Item4.setText("26◎");

      visitCombo26Item4.setSimpleValueMode(false);
      visitCombo26Item4.put(getVisitCombo26().getRenderBindPath(), "26◎");
      visitCombo26Item4.put(getVisitCombo26().getBindPath(), new Integer(3));

      addVisitCombo26Item4();
    }
    return visitCombo26Item4;

  }

  /**
   * 26△◎を取得します。
   * @return 26△◎
   */
  public ACListItem getVisitCombo26Item5(){
    if(visitCombo26Item5==null){

      visitCombo26Item5 = new ACListItem();

      visitCombo26Item5.setText("26△◎");

      visitCombo26Item5.setSimpleValueMode(false);
      visitCombo26Item5.put(getVisitCombo26().getRenderBindPath(), "26△◎");
      visitCombo26Item5.put(getVisitCombo26().getBindPath(), new Integer(4));

      addVisitCombo26Item5();
    }
    return visitCombo26Item5;

  }

  /**
   * 訪問日コンボ27を取得します。
   * @return 訪問日コンボ27
   */
  public ACComboBox getVisitCombo27(){
    if(visitCombo27==null){

      visitCombo27 = new ACComboBox();

      visitCombo27.setBindPath("1301130");

      visitCombo27.setEditable(false);

      visitCombo27.setRenderBindPath("ITEM");

      visitCombo27.setModel(getVisitCombo27Model());

      visitCombo27.setPreferredSize(new Dimension(60,20));

      addVisitCombo27();
    }
    return visitCombo27;

  }

  /**
   * 訪問日コンボ27モデルを取得します。
   * @return 訪問日コンボ27モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo27Model(){
    if(visitCombo27Model==null){
      visitCombo27Model = new ACComboBoxModelAdapter();
      addVisitCombo27Model();
    }
    return visitCombo27Model;
  }

  /**
   * 27を取得します。
   * @return 27
   */
  public ACListItem getVisitCombo27Item1(){
    if(visitCombo27Item1==null){

      visitCombo27Item1 = new ACListItem();

      visitCombo27Item1.setText("27");

      visitCombo27Item1.setSimpleValueMode(false);
      visitCombo27Item1.put(getVisitCombo27().getRenderBindPath(), "27");
      visitCombo27Item1.put(getVisitCombo27().getBindPath(), new Integer(0));

      addVisitCombo27Item1();
    }
    return visitCombo27Item1;

  }

  /**
   * 27○を取得します。
   * @return 27○
   */
  public ACListItem getVisitCombo27Item2(){
    if(visitCombo27Item2==null){

      visitCombo27Item2 = new ACListItem();

      visitCombo27Item2.setText("27○");

      visitCombo27Item2.setSimpleValueMode(false);
      visitCombo27Item2.put(getVisitCombo27().getRenderBindPath(), "27○");
      visitCombo27Item2.put(getVisitCombo27().getBindPath(), new Integer(1));

      addVisitCombo27Item2();
    }
    return visitCombo27Item2;

  }

  /**
   * 27△を取得します。
   * @return 27△
   */
  public ACListItem getVisitCombo27Item3(){
    if(visitCombo27Item3==null){

      visitCombo27Item3 = new ACListItem();

      visitCombo27Item3.setText("27△");

      visitCombo27Item3.setSimpleValueMode(false);
      visitCombo27Item3.put(getVisitCombo27().getRenderBindPath(), "27△");
      visitCombo27Item3.put(getVisitCombo27().getBindPath(), new Integer(2));

      addVisitCombo27Item3();
    }
    return visitCombo27Item3;

  }

  /**
   * 27◎を取得します。
   * @return 27◎
   */
  public ACListItem getVisitCombo27Item4(){
    if(visitCombo27Item4==null){

      visitCombo27Item4 = new ACListItem();

      visitCombo27Item4.setText("27◎");

      visitCombo27Item4.setSimpleValueMode(false);
      visitCombo27Item4.put(getVisitCombo27().getRenderBindPath(), "27◎");
      visitCombo27Item4.put(getVisitCombo27().getBindPath(), new Integer(3));

      addVisitCombo27Item4();
    }
    return visitCombo27Item4;

  }

  /**
   * 27△◎を取得します。
   * @return 27△◎
   */
  public ACListItem getVisitCombo27Item5(){
    if(visitCombo27Item5==null){

      visitCombo27Item5 = new ACListItem();

      visitCombo27Item5.setText("27△◎");

      visitCombo27Item5.setSimpleValueMode(false);
      visitCombo27Item5.put(getVisitCombo27().getRenderBindPath(), "27△◎");
      visitCombo27Item5.put(getVisitCombo27().getBindPath(), new Integer(4));

      addVisitCombo27Item5();
    }
    return visitCombo27Item5;

  }

  /**
   * 訪問日コンボ28を取得します。
   * @return 訪問日コンボ28
   */
  public ACComboBox getVisitCombo28(){
    if(visitCombo28==null){

      visitCombo28 = new ACComboBox();

      visitCombo28.setBindPath("1301131");

      visitCombo28.setEditable(false);

      visitCombo28.setRenderBindPath("ITEM");

      visitCombo28.setModel(getVisitCombo28Model());

      visitCombo28.setPreferredSize(new Dimension(60,20));

      addVisitCombo28();
    }
    return visitCombo28;

  }

  /**
   * 訪問日コンボ28モデルを取得します。
   * @return 訪問日コンボ28モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo28Model(){
    if(visitCombo28Model==null){
      visitCombo28Model = new ACComboBoxModelAdapter();
      addVisitCombo28Model();
    }
    return visitCombo28Model;
  }

  /**
   * 28を取得します。
   * @return 28
   */
  public ACListItem getVisitCombo28Item1(){
    if(visitCombo28Item1==null){

      visitCombo28Item1 = new ACListItem();

      visitCombo28Item1.setText("28");

      visitCombo28Item1.setSimpleValueMode(false);
      visitCombo28Item1.put(getVisitCombo28().getRenderBindPath(), "28");
      visitCombo28Item1.put(getVisitCombo28().getBindPath(), new Integer(0));

      addVisitCombo28Item1();
    }
    return visitCombo28Item1;

  }

  /**
   * 28○を取得します。
   * @return 28○
   */
  public ACListItem getVisitCombo28Item2(){
    if(visitCombo28Item2==null){

      visitCombo28Item2 = new ACListItem();

      visitCombo28Item2.setText("28○");

      visitCombo28Item2.setSimpleValueMode(false);
      visitCombo28Item2.put(getVisitCombo28().getRenderBindPath(), "28○");
      visitCombo28Item2.put(getVisitCombo28().getBindPath(), new Integer(1));

      addVisitCombo28Item2();
    }
    return visitCombo28Item2;

  }

  /**
   * 28△を取得します。
   * @return 28△
   */
  public ACListItem getVisitCombo28Item3(){
    if(visitCombo28Item3==null){

      visitCombo28Item3 = new ACListItem();

      visitCombo28Item3.setText("28△");

      visitCombo28Item3.setSimpleValueMode(false);
      visitCombo28Item3.put(getVisitCombo28().getRenderBindPath(), "28△");
      visitCombo28Item3.put(getVisitCombo28().getBindPath(), new Integer(2));

      addVisitCombo28Item3();
    }
    return visitCombo28Item3;

  }

  /**
   * 28◎を取得します。
   * @return 28◎
   */
  public ACListItem getVisitCombo28Item4(){
    if(visitCombo28Item4==null){

      visitCombo28Item4 = new ACListItem();

      visitCombo28Item4.setText("28◎");

      visitCombo28Item4.setSimpleValueMode(false);
      visitCombo28Item4.put(getVisitCombo28().getRenderBindPath(), "28◎");
      visitCombo28Item4.put(getVisitCombo28().getBindPath(), new Integer(3));

      addVisitCombo28Item4();
    }
    return visitCombo28Item4;

  }

  /**
   * 28△◎を取得します。
   * @return 28△◎
   */
  public ACListItem getVisitCombo28Item5(){
    if(visitCombo28Item5==null){

      visitCombo28Item5 = new ACListItem();

      visitCombo28Item5.setText("28△◎");

      visitCombo28Item5.setSimpleValueMode(false);
      visitCombo28Item5.put(getVisitCombo28().getRenderBindPath(), "28△◎");
      visitCombo28Item5.put(getVisitCombo28().getBindPath(), new Integer(4));

      addVisitCombo28Item5();
    }
    return visitCombo28Item5;

  }

  /**
   * 訪問日コンボ29を取得します。
   * @return 訪問日コンボ29
   */
  public ACComboBox getVisitCombo29(){
    if(visitCombo29==null){

      visitCombo29 = new ACComboBox();

      visitCombo29.setBindPath("1301132");

      visitCombo29.setEditable(false);

      visitCombo29.setRenderBindPath("ITEM");

      visitCombo29.setModel(getVisitCombo29Model());

      visitCombo29.setPreferredSize(new Dimension(60,20));

      addVisitCombo29();
    }
    return visitCombo29;

  }

  /**
   * 訪問日コンボ29モデルを取得します。
   * @return 訪問日コンボ29モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo29Model(){
    if(visitCombo29Model==null){
      visitCombo29Model = new ACComboBoxModelAdapter();
      addVisitCombo29Model();
    }
    return visitCombo29Model;
  }

  /**
   * 29を取得します。
   * @return 29
   */
  public ACListItem getVisitCombo29Item1(){
    if(visitCombo29Item1==null){

      visitCombo29Item1 = new ACListItem();

      visitCombo29Item1.setText("29");

      visitCombo29Item1.setSimpleValueMode(false);
      visitCombo29Item1.put(getVisitCombo29().getRenderBindPath(), "29");
      visitCombo29Item1.put(getVisitCombo29().getBindPath(), new Integer(0));

      addVisitCombo29Item1();
    }
    return visitCombo29Item1;

  }

  /**
   * 29○を取得します。
   * @return 29○
   */
  public ACListItem getVisitCombo29Item2(){
    if(visitCombo29Item2==null){

      visitCombo29Item2 = new ACListItem();

      visitCombo29Item2.setText("29○");

      visitCombo29Item2.setSimpleValueMode(false);
      visitCombo29Item2.put(getVisitCombo29().getRenderBindPath(), "29○");
      visitCombo29Item2.put(getVisitCombo29().getBindPath(), new Integer(1));

      addVisitCombo29Item2();
    }
    return visitCombo29Item2;

  }

  /**
   * 29△を取得します。
   * @return 29△
   */
  public ACListItem getVisitCombo29Item3(){
    if(visitCombo29Item3==null){

      visitCombo29Item3 = new ACListItem();

      visitCombo29Item3.setText("29△");

      visitCombo29Item3.setSimpleValueMode(false);
      visitCombo29Item3.put(getVisitCombo29().getRenderBindPath(), "29△");
      visitCombo29Item3.put(getVisitCombo29().getBindPath(), new Integer(2));

      addVisitCombo29Item3();
    }
    return visitCombo29Item3;

  }

  /**
   * 29◎を取得します。
   * @return 29◎
   */
  public ACListItem getVisitCombo29Item4(){
    if(visitCombo29Item4==null){

      visitCombo29Item4 = new ACListItem();

      visitCombo29Item4.setText("29◎");

      visitCombo29Item4.setSimpleValueMode(false);
      visitCombo29Item4.put(getVisitCombo29().getRenderBindPath(), "29◎");
      visitCombo29Item4.put(getVisitCombo29().getBindPath(), new Integer(3));

      addVisitCombo29Item4();
    }
    return visitCombo29Item4;

  }

  /**
   * 29△◎を取得します。
   * @return 29△◎
   */
  public ACListItem getVisitCombo29Item5(){
    if(visitCombo29Item5==null){

      visitCombo29Item5 = new ACListItem();

      visitCombo29Item5.setText("29△◎");

      visitCombo29Item5.setSimpleValueMode(false);
      visitCombo29Item5.put(getVisitCombo29().getRenderBindPath(), "29△◎");
      visitCombo29Item5.put(getVisitCombo29().getBindPath(), new Integer(4));

      addVisitCombo29Item5();
    }
    return visitCombo29Item5;

  }

  /**
   * 訪問日コンボ30を取得します。
   * @return 訪問日コンボ30
   */
  public ACComboBox getVisitCombo30(){
    if(visitCombo30==null){

      visitCombo30 = new ACComboBox();

      visitCombo30.setBindPath("1301133");

      visitCombo30.setEditable(false);

      visitCombo30.setRenderBindPath("ITEM");

      visitCombo30.setModel(getVisitCombo30Model());

      visitCombo30.setPreferredSize(new Dimension(60,20));

      addVisitCombo30();
    }
    return visitCombo30;

  }

  /**
   * 訪問日コンボ30モデルを取得します。
   * @return 訪問日コンボ30モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo30Model(){
    if(visitCombo30Model==null){
      visitCombo30Model = new ACComboBoxModelAdapter();
      addVisitCombo30Model();
    }
    return visitCombo30Model;
  }

  /**
   * 30を取得します。
   * @return 30
   */
  public ACListItem getVisitCombo30Item1(){
    if(visitCombo30Item1==null){

      visitCombo30Item1 = new ACListItem();

      visitCombo30Item1.setText("30");

      visitCombo30Item1.setSimpleValueMode(false);
      visitCombo30Item1.put(getVisitCombo30().getRenderBindPath(), "30");
      visitCombo30Item1.put(getVisitCombo30().getBindPath(), new Integer(0));

      addVisitCombo30Item1();
    }
    return visitCombo30Item1;

  }

  /**
   * 30○を取得します。
   * @return 30○
   */
  public ACListItem getVisitCombo30Item2(){
    if(visitCombo30Item2==null){

      visitCombo30Item2 = new ACListItem();

      visitCombo30Item2.setText("30○");

      visitCombo30Item2.setSimpleValueMode(false);
      visitCombo30Item2.put(getVisitCombo30().getRenderBindPath(), "30○");
      visitCombo30Item2.put(getVisitCombo30().getBindPath(), new Integer(1));

      addVisitCombo30Item2();
    }
    return visitCombo30Item2;

  }

  /**
   * 30△を取得します。
   * @return 30△
   */
  public ACListItem getVisitCombo30Item3(){
    if(visitCombo30Item3==null){

      visitCombo30Item3 = new ACListItem();

      visitCombo30Item3.setText("30△");

      visitCombo30Item3.setSimpleValueMode(false);
      visitCombo30Item3.put(getVisitCombo30().getRenderBindPath(), "30△");
      visitCombo30Item3.put(getVisitCombo30().getBindPath(), new Integer(2));

      addVisitCombo30Item3();
    }
    return visitCombo30Item3;

  }

  /**
   * 30◎を取得します。
   * @return 30◎
   */
  public ACListItem getVisitCombo30Item4(){
    if(visitCombo30Item4==null){

      visitCombo30Item4 = new ACListItem();

      visitCombo30Item4.setText("30◎");

      visitCombo30Item4.setSimpleValueMode(false);
      visitCombo30Item4.put(getVisitCombo30().getRenderBindPath(), "30◎");
      visitCombo30Item4.put(getVisitCombo30().getBindPath(), new Integer(3));

      addVisitCombo30Item4();
    }
    return visitCombo30Item4;

  }

  /**
   * 30△◎を取得します。
   * @return 30△◎
   */
  public ACListItem getVisitCombo30Item5(){
    if(visitCombo30Item5==null){

      visitCombo30Item5 = new ACListItem();

      visitCombo30Item5.setText("30△◎");

      visitCombo30Item5.setSimpleValueMode(false);
      visitCombo30Item5.put(getVisitCombo30().getRenderBindPath(), "30△◎");
      visitCombo30Item5.put(getVisitCombo30().getBindPath(), new Integer(4));

      addVisitCombo30Item5();
    }
    return visitCombo30Item5;

  }

  /**
   * 訪問日コンボ31を取得します。
   * @return 訪問日コンボ31
   */
  public ACComboBox getVisitCombo31(){
    if(visitCombo31==null){

      visitCombo31 = new ACComboBox();

      visitCombo31.setBindPath("1301134");

      visitCombo31.setEditable(false);

      visitCombo31.setRenderBindPath("ITEM");

      visitCombo31.setModel(getVisitCombo31Model());

      visitCombo31.setPreferredSize(new Dimension(60,20));

      addVisitCombo31();
    }
    return visitCombo31;

  }

  /**
   * 訪問日コンボ31モデルを取得します。
   * @return 訪問日コンボ31モデル
   */
  protected ACComboBoxModelAdapter getVisitCombo31Model(){
    if(visitCombo31Model==null){
      visitCombo31Model = new ACComboBoxModelAdapter();
      addVisitCombo31Model();
    }
    return visitCombo31Model;
  }

  /**
   * 31を取得します。
   * @return 31
   */
  public ACListItem getVisitCombo31Item1(){
    if(visitCombo31Item1==null){

      visitCombo31Item1 = new ACListItem();

      visitCombo31Item1.setText("31");

      visitCombo31Item1.setSimpleValueMode(false);
      visitCombo31Item1.put(getVisitCombo31().getRenderBindPath(), "31");
      visitCombo31Item1.put(getVisitCombo31().getBindPath(), new Integer(0));

      addVisitCombo31Item1();
    }
    return visitCombo31Item1;

  }

  /**
   * 31○を取得します。
   * @return 31○
   */
  public ACListItem getVisitCombo31Item2(){
    if(visitCombo31Item2==null){

      visitCombo31Item2 = new ACListItem();

      visitCombo31Item2.setText("31○");

      visitCombo31Item2.setSimpleValueMode(false);
      visitCombo31Item2.put(getVisitCombo31().getRenderBindPath(), "31○");
      visitCombo31Item2.put(getVisitCombo31().getBindPath(), new Integer(1));

      addVisitCombo31Item2();
    }
    return visitCombo31Item2;

  }

  /**
   * 31△を取得します。
   * @return 31△
   */
  public ACListItem getVisitCombo31Item3(){
    if(visitCombo31Item3==null){

      visitCombo31Item3 = new ACListItem();

      visitCombo31Item3.setText("31△");

      visitCombo31Item3.setSimpleValueMode(false);
      visitCombo31Item3.put(getVisitCombo31().getRenderBindPath(), "31△");
      visitCombo31Item3.put(getVisitCombo31().getBindPath(), new Integer(2));

      addVisitCombo31Item3();
    }
    return visitCombo31Item3;

  }

  /**
   * 31◎を取得します。
   * @return 31◎
   */
  public ACListItem getVisitCombo31Item4(){
    if(visitCombo31Item4==null){

      visitCombo31Item4 = new ACListItem();

      visitCombo31Item4.setText("31◎");

      visitCombo31Item4.setSimpleValueMode(false);
      visitCombo31Item4.put(getVisitCombo31().getRenderBindPath(), "31◎");
      visitCombo31Item4.put(getVisitCombo31().getBindPath(), new Integer(3));

      addVisitCombo31Item4();
    }
    return visitCombo31Item4;

  }

  /**
   * 31△◎を取得します。
   * @return 31△◎
   */
  public ACListItem getVisitCombo31Item5(){
    if(visitCombo31Item5==null){

      visitCombo31Item5 = new ACListItem();

      visitCombo31Item5.setText("31△◎");

      visitCombo31Item5.setSimpleValueMode(false);
      visitCombo31Item5.put(getVisitCombo31().getRenderBindPath(), "31△◎");
      visitCombo31Item5.put(getVisitCombo31().getBindPath(), new Integer(4));

      addVisitCombo31Item5();
    }
    return visitCombo31Item5;

  }

  /**
   * 3パネル3を取得します。
   * @return 3パネル3
   */
  public ACPanel getVisitCareDetailedPoints3Panel3(){
    if(visitCareDetailedPoints3Panel3==null){

      visitCareDetailedPoints3Panel3 = new ACPanel();

      addVisitCareDetailedPoints3Panel3();
    }
    return visitCareDetailedPoints3Panel3;

  }

  /**
   * 実日数・グループを取得します。
   * @return 実日数・グループ
   */
  public ACGroupBox getRealityDate(){
    if(realityDate==null){

      realityDate = new ACGroupBox();

      realityDate.setText("実日数");

      realityDate.setLayout(getRealityDateLayout());

      addRealityDate();
    }
    return realityDate;

  }

  /**
   * 実日数・グループ・レイアウトを取得します。
   * @return 実日数・グループ・レイアウト
   */
  public VRLayout getRealityDateLayout(){
    if(realityDateLayout==null){

      realityDateLayout = new VRLayout();

      realityDateLayout.setAutoWrap(false);

      realityDateLayout.setHgap(4);

      realityDateLayout.setLabelMargin(2);

      realityDateLayout.setVgap(4);

      addRealityDateLayout();
    }
    return realityDateLayout;

  }

  /**
   * 保険コンテナを取得します。
   * @return 保険コンテナ
   */
  public ACLabelContainer getInsuranceContena(){
    if(insuranceContena==null){

      insuranceContena = new ACLabelContainer();

      addInsuranceContena();
    }
    return insuranceContena;

  }

  /**
   * ラベル1を取得します。
   * @return ラベル1
   */
  public ACLabel getInsuranceLabel1(){
    if(insuranceLabel1==null){

      insuranceLabel1 = new ACLabel();

      insuranceLabel1.setText("保険");

      addInsuranceLabel1();
    }
    return insuranceLabel1;

  }

  /**
   * テキストを取得します。
   * @return テキスト
   */
  public ACTextField getInsuranceText1(){
    if(insuranceText1==null){

      insuranceText1 = new ACTextField();

      insuranceText1.setBindPath("1301096");

      insuranceText1.setColumns(4);

      insuranceText1.setCharType(VRCharType.ONLY_DIGIT);

      insuranceText1.setHorizontalAlignment(SwingConstants.RIGHT);

      insuranceText1.setIMEMode(InputSubset.LATIN);

      insuranceText1.setMaxLength(15);

      addInsuranceText1();
    }
    return insuranceText1;

  }

  /**
   * ラベル2を取得します。
   * @return ラベル2
   */
  public ACLabel getInsuranceLabel2(){
    if(insuranceLabel2==null){

      insuranceLabel2 = new ACLabel();

      insuranceLabel2.setText("日");

      addInsuranceLabel2();
    }
    return insuranceLabel2;

  }

  /**
   * 公費１コンテナを取得します。
   * @return 公費１コンテナ
   */
  public ACLabelContainer getPublicExpenseContena(){
    if(publicExpenseContena==null){

      publicExpenseContena = new ACLabelContainer();

      addPublicExpenseContena();
    }
    return publicExpenseContena;

  }

  /**
   * ラベル1を取得します。
   * @return ラベル1
   */
  public ACLabel getPublicExpenseLabel1(){
    if(publicExpenseLabel1==null){

      publicExpenseLabel1 = new ACLabel();

      publicExpenseLabel1.setText("公費1");

      addPublicExpenseLabel1();
    }
    return publicExpenseLabel1;

  }

  /**
   * テキストを取得します。
   * @return テキスト
   */
  public ACTextField getPublicExpenseText1(){
    if(publicExpenseText1==null){

      publicExpenseText1 = new ACTextField();

      publicExpenseText1.setBindPath("1301097");

      publicExpenseText1.setColumns(4);

      publicExpenseText1.setCharType(VRCharType.ONLY_DIGIT);

      publicExpenseText1.setHorizontalAlignment(SwingConstants.RIGHT);

      publicExpenseText1.setIMEMode(InputSubset.LATIN);

      publicExpenseText1.setMaxLength(15);

      addPublicExpenseText1();
    }
    return publicExpenseText1;

  }

  /**
   * ラベル2を取得します。
   * @return ラベル2
   */
  public ACLabel getPublicExpenseLabel2(){
    if(publicExpenseLabel2==null){

      publicExpenseLabel2 = new ACLabel();

      publicExpenseLabel2.setText("日");

      addPublicExpenseLabel2();
    }
    return publicExpenseLabel2;

  }

  /**
   * テキスト2を取得します。
   * @return テキスト2
   */
  public ACTextField getPublicExpenseText2(){
    if(publicExpenseText2==null){

      publicExpenseText2 = new ACTextField();

      publicExpenseText2.setBindPath("1301149");

      publicExpenseText2.setEditable(false);
      
      publicExpenseText2.setColumns(8);

      publicExpenseText2.setIMEMode(InputSubset.KANJI);

      publicExpenseText2.setMaxLength(65);

      addPublicExpenseText2();
    }
    return publicExpenseText2;

  }

  /**
   * 公費２コンテナを取得します。
   * @return 公費２コンテナ
   */
  public ACLabelContainer getPublicExpense2Contena(){
    if(publicExpense2Contena==null){

      publicExpense2Contena = new ACLabelContainer();

      addPublicExpense2Contena();
    }
    return publicExpense2Contena;

  }

  /**
   * ラベル1を取得します。
   * @return ラベル1
   */
  public ACLabel getPublicExpense2Label1(){
    if(publicExpense2Label1==null){

      publicExpense2Label1 = new ACLabel();

      publicExpense2Label1.setText("公費2");

      addPublicExpense2Label1();
    }
    return publicExpense2Label1;

  }

  /**
   * テキストを取得します。
   * @return テキスト
   */
  public ACTextField getPublicExpense2Text1(){
    if(publicExpense2Text1==null){

      publicExpense2Text1 = new ACTextField();

      publicExpense2Text1.setBindPath("1301098");

      publicExpense2Text1.setColumns(4);

      publicExpense2Text1.setCharType(VRCharType.ONLY_DIGIT);

      publicExpense2Text1.setHorizontalAlignment(SwingConstants.RIGHT);

      publicExpense2Text1.setIMEMode(InputSubset.LATIN);

      publicExpense2Text1.setMaxLength(15);

      addPublicExpense2Text1();
    }
    return publicExpense2Text1;

  }

  /**
   * ラベル2を取得します。
   * @return ラベル2
   */
  public ACLabel getPublicExpense2ContenaLabel2(){
    if(publicExpense2ContenaLabel2==null){

      publicExpense2ContenaLabel2 = new ACLabel();

      publicExpense2ContenaLabel2.setText("日");

      addPublicExpense2ContenaLabel2();
    }
    return publicExpense2ContenaLabel2;

  }

  /**
   * テキスト2を取得します。
   * @return テキスト2
   */
  public ACTextField getPublicExpense2Text2(){
    if(publicExpense2Text2==null){

      publicExpense2Text2 = new ACTextField();

      publicExpense2Text2.setBindPath("1301150");

      publicExpense2Text2.setColumns(8);
      
      publicExpense2Text2.setEditable(false);

      publicExpense2Text2.setIMEMode(InputSubset.KANJI);

      publicExpense2Text2.setMaxLength(65);

      addPublicExpense2Text2();
    }
    return publicExpense2Text2;

  }

  /**
   * 主治医への直近報告年月日・パネルを取得します。
   * @return 主治医への直近報告年月日・パネル
   */
  public ACPanel getMainDoctorInfoDatePanel(){
    if(mainDoctorInfoDatePanel==null){

      mainDoctorInfoDatePanel = new ACPanel();

      addMainDoctorInfoDatePanel();
    }
    return mainDoctorInfoDatePanel;

  }

  /**
   * 主治医への直近報告年月日を取得します。
   * @return 主治医への直近報告年月日
   */
  public QkanDateTextField getMainDoctorInfoDate(){
    if(mainDoctorInfoDate==null){

      mainDoctorInfoDate = new QkanDateTextField();

      getMainDoctorInfoDateContainer().setText("主治医への直近報告年月日");

      mainDoctorInfoDate.setBindPath("1301135");

      addMainDoctorInfoDate();
    }
    return mainDoctorInfoDate;

  }

  /**
   * 主治医への直近報告年月日コンテナを取得します。
   * @return 主治医への直近報告年月日コンテナ
   */
  protected ACLabelContainer getMainDoctorInfoDateContainer(){
    if(mainDoctorInfoDateContainer==null){
      mainDoctorInfoDateContainer = new ACLabelContainer();
      mainDoctorInfoDateContainer.setFollowChildEnabled(true);
      mainDoctorInfoDateContainer.setVAlignment(VRLayout.CENTER);
      mainDoctorInfoDateContainer.add(getMainDoctorInfoDate(), null);
    }
    return mainDoctorInfoDateContainer;
  }

  /**
   * 提供した情報の概要・グループを取得します。
   * @return 提供した情報の概要・グループ
   */
  public ACGroupBox getOfferInfos(){
    if(offerInfos==null){

      offerInfos = new ACGroupBox();

      offerInfos.setText("提供した情報の概要");

      offerInfos.setLayout(getOfferInfoLayout());

      addOfferInfos();
    }
    return offerInfos;

  }

  /**
   * 提供した情報の概要・グループ・レイアウトを取得します。
   * @return 提供した情報の概要・グループ・レイアウト
   */
  public VRLayout getOfferInfoLayout(){
    if(offerInfoLayout==null){

      offerInfoLayout = new VRLayout();

      offerInfoLayout.setAutoWrap(false);

      offerInfoLayout.setHgap(4);

      offerInfoLayout.setLabelMargin(2);

      offerInfoLayout.setVgap(4);

      addOfferInfoLayout();
    }
    return offerInfoLayout;

  }

  /**
   * 提供した情報の概要テキストを取得します。
   * @return 提供した情報の概要テキスト
   */
  public ACTextArea getOfferInfoText(){
    if(offerInfoText==null){

      offerInfoText = new ACTextArea();

      offerInfoText.setBindPath("1301136");

      offerInfoText.setColumns(80);

      offerInfoText.setRows(4);

      offerInfoText.setMaxRows(4);

      offerInfoText.setIMEMode(InputSubset.KANJI);

      offerInfoText.setMaxLength(135);

      offerInfoText.setLineWrap(true);

      addOfferInfoText();
    }
    return offerInfoText;

  }

  /**
   * 提供した情報の概要テキストコンテナを取得します。
   * @return 提供した情報の概要テキストコンテナ
   */
  protected ACLabelContainer getOfferInfoTextContainer(){
    if(offerInfoTextContainer==null){
      offerInfoTextContainer = new ACLabelContainer();
      offerInfoTextContainer.setFollowChildEnabled(true);
      offerInfoTextContainer.setVAlignment(VRLayout.CENTER);
      offerInfoTextContainer.add(getOfferInfoText(), null);
    }
    return offerInfoTextContainer;
  }

  /**
   * 情報提供先の市（区）町村等の名称を取得します。
   * @return 情報提供先の市（区）町村等の名称
   */
  public ACTextField getInfoOfferTownsAndVillagesName(){
    if(infoOfferTownsAndVillagesName==null){

      infoOfferTownsAndVillagesName = new ACTextField();

      getInfoOfferTownsAndVillagesNameContainer().setText("情報提供先の市（区）町村等の名称");

      infoOfferTownsAndVillagesName.setBindPath("1301137");

      infoOfferTownsAndVillagesName.setColumns(25);

      infoOfferTownsAndVillagesName.setIMEMode(InputSubset.KANJI);

      infoOfferTownsAndVillagesName.setMaxLength(128);

      addInfoOfferTownsAndVillagesName();
    }
    return infoOfferTownsAndVillagesName;

  }

  /**
   * 情報提供先の市（区）町村等の名称コンテナを取得します。
   * @return 情報提供先の市（区）町村等の名称コンテナ
   */
  protected ACLabelContainer getInfoOfferTownsAndVillagesNameContainer(){
    if(infoOfferTownsAndVillagesNameContainer==null){
      infoOfferTownsAndVillagesNameContainer = new ACLabelContainer();
      infoOfferTownsAndVillagesNameContainer.setFollowChildEnabled(true);
      infoOfferTownsAndVillagesNameContainer.setVAlignment(VRLayout.CENTER);
      infoOfferTownsAndVillagesNameContainer.add(getInfoOfferTownsAndVillagesName(), null);
    }
    return infoOfferTownsAndVillagesNameContainer;
  }

  /**
   * 特記事項・グループを取得します。
   * @return 特記事項・グループ
   */
  public ACGroupBox getSpecialEtcs(){
    if(specialEtcs==null){

      specialEtcs = new ACGroupBox();

      specialEtcs.setText("特記事項");

      specialEtcs.setLayout(getSpecialEtcLayout());

      addSpecialEtcs();
    }
    return specialEtcs;

  }

  /**
   * 特記事項・グループ・レイアウトを取得します。
   * @return 特記事項・グループ・レイアウト
   */
  public VRLayout getSpecialEtcLayout(){
    if(specialEtcLayout==null){

      specialEtcLayout = new VRLayout();

      specialEtcLayout.setAutoWrap(false);

      specialEtcLayout.setHgap(4);

      specialEtcLayout.setLabelMargin(2);

      specialEtcLayout.setVgap(4);

      addSpecialEtcLayout();
    }
    return specialEtcLayout;

  }

  /**
   * 特記事項を取得します。
   * @return 特記事項
   */
  public ACTextArea getSpecialEtcText(){
    if(specialEtcText==null){

      specialEtcText = new ACTextArea();

      specialEtcText.setBindPath("1301138");

      specialEtcText.setColumns(80);

      specialEtcText.setRows(7);

      specialEtcText.setMaxRows(20);

      specialEtcText.setIMEMode(InputSubset.KANJI);

      specialEtcText.setMaxLength(135);

      specialEtcText.setLineWrap(true);

      addSpecialEtcText();
    }
    return specialEtcText;

  }

  /**
   * 特記事項コンテナを取得します。
   * @return 特記事項コンテナ
   */
  protected ACLabelContainer getSpecialEtcTextContainer(){
    if(specialEtcTextContainer==null){
      specialEtcTextContainer = new ACLabelContainer();
      specialEtcTextContainer.setFollowChildEnabled(true);
      specialEtcTextContainer.setVAlignment(VRLayout.CENTER);
      specialEtcTextContainer.add(getSpecialEtcText(), null);
    }
    return specialEtcTextContainer;
  }

  /**
   * 合計情報パネルを取得します。
   * @return 合計情報パネル
   */
  public ACPanel getVisitCareDetailedTotalInfos(){
    if(visitCareDetailedTotalInfos==null){

      visitCareDetailedTotalInfos = new ACPanel();

      visitCareDetailedTotalInfos.setLayout(getVisitCareDetailedTotalInfosLayout());

      addVisitCareDetailedTotalInfos();
    }
    return visitCareDetailedTotalInfos;

  }

  /**
   * 合計情報領域・レイアウトを取得します。
   * @return 合計情報領域・レイアウト
   */
  public VRLayout getVisitCareDetailedTotalInfosLayout(){
    if(visitCareDetailedTotalInfosLayout==null){

      visitCareDetailedTotalInfosLayout = new VRLayout();

      visitCareDetailedTotalInfosLayout.setAutoWrap(false);

      visitCareDetailedTotalInfosLayout.setHgap(2);

      visitCareDetailedTotalInfosLayout.setLabelMargin(2);

      visitCareDetailedTotalInfosLayout.setVgap(2);

      addVisitCareDetailedTotalInfosLayout();
    }
    return visitCareDetailedTotalInfosLayout;

  }

  /**
   * 合計情報領域・グループを取得します。
   * @return 合計情報領域・グループ
   */
  public ACGroupBox getVisitCareDetailedTotalInfosFrame(){
    if(visitCareDetailedTotalInfosFrame==null){

      visitCareDetailedTotalInfosFrame = new ACGroupBox();

      visitCareDetailedTotalInfosFrame.setText("合計");

      visitCareDetailedTotalInfosFrame.setLayout(getVisitCareDetailedTotalInfosFrameLayout());

      addVisitCareDetailedTotalInfosFrame();
    }
    return visitCareDetailedTotalInfosFrame;

  }

  /**
   * 合計情報領域・グループ・レイアウトを取得します。
   * @return 合計情報領域・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedTotalInfosFrameLayout(){
    if(visitCareDetailedTotalInfosFrameLayout==null){

      visitCareDetailedTotalInfosFrameLayout = new VRLayout();

      visitCareDetailedTotalInfosFrameLayout.setAutoWrap(false);

      visitCareDetailedTotalInfosFrameLayout.setHgap(2);

      visitCareDetailedTotalInfosFrameLayout.setLabelMargin(2);

      visitCareDetailedTotalInfosFrameLayout.setVgap(2);

      addVisitCareDetailedTotalInfosFrameLayout();
    }
    return visitCareDetailedTotalInfosFrameLayout;

  }

  /**
   * 請求・グループを取得します。
   * @return 請求・グループ
   */
  public ACGroupBox getVisitCareDetailedExpenseMoneyFrame(){
    if(visitCareDetailedExpenseMoneyFrame==null){

      visitCareDetailedExpenseMoneyFrame = new ACGroupBox();

      visitCareDetailedExpenseMoneyFrame.setText("請求");

      visitCareDetailedExpenseMoneyFrame.setLayout(getVisitCareDetailedExpenseMoneyFrameLayout());

      addVisitCareDetailedExpenseMoneyFrame();
    }
    return visitCareDetailedExpenseMoneyFrame;

  }

  /**
   * 請求・グループ・レイアウトを取得します。
   * @return 請求・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedExpenseMoneyFrameLayout(){
    if(visitCareDetailedExpenseMoneyFrameLayout==null){

      visitCareDetailedExpenseMoneyFrameLayout = new VRLayout();

      visitCareDetailedExpenseMoneyFrameLayout.setAutoWrap(false);

      visitCareDetailedExpenseMoneyFrameLayout.setHgap(2);

      visitCareDetailedExpenseMoneyFrameLayout.setLabelMargin(2);

      visitCareDetailedExpenseMoneyFrameLayout.setVgap(2);

      addVisitCareDetailedExpenseMoneyFrameLayout();
    }
    return visitCareDetailedExpenseMoneyFrameLayout;

  }

  /**
   * 請求金額1・コンテナを取得します。
   * @return 請求金額1・コンテナ
   */
  public ACLabelContainer getVisitCareDetailedExpenseMoneyContena1(){
    if(visitCareDetailedExpenseMoneyContena1==null){

      visitCareDetailedExpenseMoneyContena1 = new ACLabelContainer();

      addVisitCareDetailedExpenseMoneyContena1();
    }
    return visitCareDetailedExpenseMoneyContena1;

  }

  /**
   * 請求金額テキスト1を取得します。
   * @return 請求金額テキスト1
   */
  public ACTextField getVisitCareDetailedExpenseMoneyText1(){
    if(visitCareDetailedExpenseMoneyText1==null){

      visitCareDetailedExpenseMoneyText1 = new ACTextField();

      visitCareDetailedExpenseMoneyText1.setBindPath("1301139");

      visitCareDetailedExpenseMoneyText1.setColumns(10);

      visitCareDetailedExpenseMoneyText1.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedExpenseMoneyText1.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedExpenseMoneyText1.setIMEMode(InputSubset.LATIN);

      visitCareDetailedExpenseMoneyText1.setMaxLength(15);

      addVisitCareDetailedExpenseMoneyText1();
    }
    return visitCareDetailedExpenseMoneyText1;

  }

  /**
   * 請求金額ラベル1を取得します。
   * @return 請求金額ラベル1
   */
  public ACLabel getVisitCareDetailedExpenseMoneyLabel1(){
    if(visitCareDetailedExpenseMoneyLabel1==null){

      visitCareDetailedExpenseMoneyLabel1 = new ACLabel();

      visitCareDetailedExpenseMoneyLabel1.setText("円");

      addVisitCareDetailedExpenseMoneyLabel1();
    }
    return visitCareDetailedExpenseMoneyLabel1;

  }

  /**
   * 請求金額2・コンテナを取得します。
   * @return 請求金額2・コンテナ
   */
  public ACLabelContainer getVisitCareDetailedExpenseMoneyContena2(){
    if(visitCareDetailedExpenseMoneyContena2==null){

      visitCareDetailedExpenseMoneyContena2 = new ACLabelContainer();

      addVisitCareDetailedExpenseMoneyContena2();
    }
    return visitCareDetailedExpenseMoneyContena2;

  }

  /**
   * 請求金額テキスト2を取得します。
   * @return 請求金額テキスト2
   */
  public ACTextField getVisitCareDetailedExpenseMoneyText2(){
    if(visitCareDetailedExpenseMoneyText2==null){

      visitCareDetailedExpenseMoneyText2 = new ACTextField();

      visitCareDetailedExpenseMoneyText2.setBindPath("1301144");

      visitCareDetailedExpenseMoneyText2.setColumns(10);

      visitCareDetailedExpenseMoneyText2.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedExpenseMoneyText2.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedExpenseMoneyText2.setIMEMode(InputSubset.LATIN);

      visitCareDetailedExpenseMoneyText2.setMaxLength(15);

      addVisitCareDetailedExpenseMoneyText2();
    }
    return visitCareDetailedExpenseMoneyText2;

  }

  /**
   * 請求金額ラベル2を取得します。
   * @return 請求金額ラベル2
   */
  public ACLabel getVisitCareDetailedExpenseMoneyLabel2(){
    if(visitCareDetailedExpenseMoneyLabel2==null){

      visitCareDetailedExpenseMoneyLabel2 = new ACLabel();

      visitCareDetailedExpenseMoneyLabel2.setText("円");

      addVisitCareDetailedExpenseMoneyLabel2();
    }
    return visitCareDetailedExpenseMoneyLabel2;

  }

  /**
   * 請求金額3・コンテナを取得します。
   * @return 請求金額3・コンテナ
   */
  public ACLabelContainer getVisitCareDetailedExpenseMoneyContena3(){
    if(visitCareDetailedExpenseMoneyContena3==null){

      visitCareDetailedExpenseMoneyContena3 = new ACLabelContainer();

      addVisitCareDetailedExpenseMoneyContena3();
    }
    return visitCareDetailedExpenseMoneyContena3;

  }

  /**
   * 請求金額テキスト3を取得します。
   * @return 請求金額テキスト3
   */
  public ACTextField getVisitCareDetailedExpenseMoneyText3(){
    if(visitCareDetailedExpenseMoneyText3==null){

      visitCareDetailedExpenseMoneyText3 = new ACTextField();

      visitCareDetailedExpenseMoneyText3.setBindPath("1301146");

      visitCareDetailedExpenseMoneyText3.setColumns(10);

      visitCareDetailedExpenseMoneyText3.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedExpenseMoneyText3.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedExpenseMoneyText3.setIMEMode(InputSubset.LATIN);

      visitCareDetailedExpenseMoneyText3.setMaxLength(15);

      addVisitCareDetailedExpenseMoneyText3();
    }
    return visitCareDetailedExpenseMoneyText3;

  }

  /**
   * 請求金額ラベル3を取得します。
   * @return 請求金額ラベル3
   */
  public ACLabel getVisitCareDetailedExpenseMoneyLabel3(){
    if(visitCareDetailedExpenseMoneyLabel3==null){

      visitCareDetailedExpenseMoneyLabel3 = new ACLabel();

      visitCareDetailedExpenseMoneyLabel3.setText("円");

      addVisitCareDetailedExpenseMoneyLabel3();
    }
    return visitCareDetailedExpenseMoneyLabel3;

  }

  /**
   * 負担金額・グループを取得します。
   * @return 負担金額・グループ
   */
  public ACGroupBox getVisitCareDetailedOneshareFrame(){
    if(visitCareDetailedOneshareFrame==null){

      visitCareDetailedOneshareFrame = new ACGroupBox();

      visitCareDetailedOneshareFrame.setText("負担金額");

      visitCareDetailedOneshareFrame.setLayout(getVisitCareDetailedOneshareFrameLayout());

      addVisitCareDetailedOneshareFrame();
    }
    return visitCareDetailedOneshareFrame;

  }

  /**
   * 負担金額・グループ・レイアウトを取得します。
   * @return 負担金額・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedOneshareFrameLayout(){
    if(visitCareDetailedOneshareFrameLayout==null){

      visitCareDetailedOneshareFrameLayout = new VRLayout();

      visitCareDetailedOneshareFrameLayout.setAutoWrap(false);

      visitCareDetailedOneshareFrameLayout.setHgap(2);

      visitCareDetailedOneshareFrameLayout.setLabelMargin(2);

      visitCareDetailedOneshareFrameLayout.setVgap(2);

      addVisitCareDetailedOneshareFrameLayout();
    }
    return visitCareDetailedOneshareFrameLayout;

  }

  /**
   * 負担金額1・コンテナを取得します。
   * @return 負担金額1・コンテナ
   */
  public ACLabelContainer getVisitCareDetailedOneshareContena1(){
    if(visitCareDetailedOneshareContena1==null){

      visitCareDetailedOneshareContena1 = new ACLabelContainer();

      addVisitCareDetailedOneshareContena1();
    }
    return visitCareDetailedOneshareContena1;

  }

  /**
   * 負担金額テキスト1を取得します。
   * @return 負担金額テキスト1
   */
  public ACTextField getVisitCareDetailedOneshareText(){
    if(visitCareDetailedOneshareText==null){

      visitCareDetailedOneshareText = new ACTextField();

      visitCareDetailedOneshareText.setBindPath("1301140");

      visitCareDetailedOneshareText.setColumns(10);

      visitCareDetailedOneshareText.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedOneshareText.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedOneshareText.setIMEMode(InputSubset.LATIN);

      visitCareDetailedOneshareText.setMaxLength(15);

      addVisitCareDetailedOneshareText();
    }
    return visitCareDetailedOneshareText;

  }

  /**
   * 負担金額ラベル1を取得します。
   * @return 負担金額ラベル1
   */
  public ACLabel getVisitCareDetailedOneshareLabel(){
    if(visitCareDetailedOneshareLabel==null){

      visitCareDetailedOneshareLabel = new ACLabel();

      visitCareDetailedOneshareLabel.setText("円");

      addVisitCareDetailedOneshareLabel();
    }
    return visitCareDetailedOneshareLabel;

  }

  /**
   * 負担金額2・コンテナを取得します。
   * @return 負担金額2・コンテナ
   */
  public ACLabelContainer getVisitCareDetailedOneshareContena2(){
    if(visitCareDetailedOneshareContena2==null){

      visitCareDetailedOneshareContena2 = new ACLabelContainer();

      addVisitCareDetailedOneshareContena2();
    }
    return visitCareDetailedOneshareContena2;

  }

  /**
   * 負担金額テキスト2を取得します。
   * @return 負担金額テキスト2
   */
  public ACTextField getVisitCareDetailedOneshareTex2(){
    if(visitCareDetailedOneshareTex2==null){

      visitCareDetailedOneshareTex2 = new ACTextField();

      visitCareDetailedOneshareTex2.setBindPath("1301145");

      visitCareDetailedOneshareTex2.setColumns(10);

      visitCareDetailedOneshareTex2.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedOneshareTex2.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedOneshareTex2.setIMEMode(InputSubset.LATIN);

      visitCareDetailedOneshareTex2.setMaxLength(15);

      addVisitCareDetailedOneshareTex2();
    }
    return visitCareDetailedOneshareTex2;

  }

  /**
   * 負担金額ラベル2を取得します。
   * @return 負担金額ラベル2
   */
  public ACLabel getVisitCareDetailedOneshareLabe2(){
    if(visitCareDetailedOneshareLabe2==null){

      visitCareDetailedOneshareLabe2 = new ACLabel();

      visitCareDetailedOneshareLabe2.setText("円");

      addVisitCareDetailedOneshareLabe2();
    }
    return visitCareDetailedOneshareLabe2;

  }

  /**
   * 負担金額3・コンテナを取得します。
   * @return 負担金額3・コンテナ
   */
  public ACLabelContainer getVisitCareDetailedOneshareContena3(){
    if(visitCareDetailedOneshareContena3==null){

      visitCareDetailedOneshareContena3 = new ACLabelContainer();

      addVisitCareDetailedOneshareContena3();
    }
    return visitCareDetailedOneshareContena3;

  }

  /**
   * 負担金額テキスト3を取得します。
   * @return 負担金額テキスト3
   */
  public ACTextField getVisitCareDetailedOneshareTex3(){
    if(visitCareDetailedOneshareTex3==null){

      visitCareDetailedOneshareTex3 = new ACTextField();

      visitCareDetailedOneshareTex3.setBindPath("1301147");

      visitCareDetailedOneshareTex3.setColumns(10);

      visitCareDetailedOneshareTex3.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedOneshareTex3.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedOneshareTex3.setIMEMode(InputSubset.LATIN);

      visitCareDetailedOneshareTex3.setMaxLength(15);

      addVisitCareDetailedOneshareTex3();
    }
    return visitCareDetailedOneshareTex3;

  }

  /**
   * 負担金額ラベル3を取得します。
   * @return 負担金額ラベル3
   */
  public ACLabel getVisitCareDetailedOneshareLabe3(){
    if(visitCareDetailedOneshareLabe3==null){

      visitCareDetailedOneshareLabe3 = new ACLabel();

      visitCareDetailedOneshareLabe3.setText("円");

      addVisitCareDetailedOneshareLabe3();
    }
    return visitCareDetailedOneshareLabe3;

  }

  /**
   * 減額グループを取得します。
   * @return 減額グループ
   */
  public ACGroupBox getVisitCareDetailedReductionGroup(){
    if(visitCareDetailedReductionGroup==null){

      visitCareDetailedReductionGroup = new ACGroupBox();

      visitCareDetailedReductionGroup.setAutoWrap(false);

      addVisitCareDetailedReductionGroup();
    }
    return visitCareDetailedReductionGroup;

  }

  /**
   * 減額・コンテナを取得します。
   * @return 減額・コンテナ
   */
  public ACBackLabelContainer getVisitCareDetailedReductionContena(){
    if(visitCareDetailedReductionContena==null){

      visitCareDetailedReductionContena = new ACBackLabelContainer();

      addVisitCareDetailedReductionContena();
    }
    return visitCareDetailedReductionContena;

  }

  /**
   * 減額を取得します。
   * @return 減額
   */
  public ACTextField getVisitCareDetailedReduction(){
    if(visitCareDetailedReduction==null){

      visitCareDetailedReduction = new ACTextField();

      getVisitCareDetailedReductionContainer().setText("減額");

      visitCareDetailedReduction.setBindPath("1301141");

      visitCareDetailedReduction.setColumns(8);

      visitCareDetailedReduction.setCharType(VRCharType.ONLY_DIGIT);

      visitCareDetailedReduction.setHorizontalAlignment(SwingConstants.RIGHT);

      visitCareDetailedReduction.setIMEMode(InputSubset.LATIN);

      visitCareDetailedReduction.setMaxLength(8);

      addVisitCareDetailedReduction();
    }
    return visitCareDetailedReduction;

  }

  /**
   * 減額コンテナを取得します。
   * @return 減額コンテナ
   */
  protected ACLabelContainer getVisitCareDetailedReductionContainer(){
    if(visitCareDetailedReductionContainer==null){
      visitCareDetailedReductionContainer = new ACLabelContainer();
      visitCareDetailedReductionContainer.setFollowChildEnabled(true);
      visitCareDetailedReductionContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedReductionContainer.add(getVisitCareDetailedReduction(), null);
    }
    return visitCareDetailedReductionContainer;
  }

  /**
   * 減額ラジオグループを取得します。
   * @return 減額ラジオグループ
   */
  public ACClearableRadioButtonGroup getVisitCareDetailedReductionRadio(){
    if(visitCareDetailedReductionRadio==null){

      visitCareDetailedReductionRadio = new ACClearableRadioButtonGroup();

      visitCareDetailedReductionRadio.setBindPath("1301142");

      visitCareDetailedReductionRadio.setLayout(getVisitCareDetailedReductionRadioLayout());

      visitCareDetailedReductionRadio.setUseClearButton(false);

      visitCareDetailedReductionRadio.setModel(getVisitCareDetailedReductionRadioModel());

      addVisitCareDetailedReductionRadio();
    }
    return visitCareDetailedReductionRadio;

  }

  /**
   * 減額ラジオグループコンテナを取得します。
   * @return 減額ラジオグループコンテナ
   */
  protected ACLabelContainer getVisitCareDetailedReductionRadioContainer(){
    if(visitCareDetailedReductionRadioContainer==null){
      visitCareDetailedReductionRadioContainer = new ACLabelContainer();
      visitCareDetailedReductionRadioContainer.setFollowChildEnabled(true);
      visitCareDetailedReductionRadioContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedReductionRadioContainer.add(getVisitCareDetailedReductionRadio(), null);
    }
    return visitCareDetailedReductionRadioContainer;
  }

  /**
   * 減額ラジオグループモデルを取得します。
   * @return 減額ラジオグループモデル
   */
  protected ACListModelAdapter getVisitCareDetailedReductionRadioModel(){
    if(visitCareDetailedReductionRadioModel==null){
      visitCareDetailedReductionRadioModel = new ACListModelAdapter();
      addVisitCareDetailedReductionRadioModel();
    }
    return visitCareDetailedReductionRadioModel;
  }

  /**
   * 減額ラジオグループ・レイアウトを取得します。
   * @return 減額ラジオグループ・レイアウト
   */
  public VRLayout getVisitCareDetailedReductionRadioLayout(){
    if(visitCareDetailedReductionRadioLayout==null){

      visitCareDetailedReductionRadioLayout = new VRLayout();

      visitCareDetailedReductionRadioLayout.setAutoWrap(false);

      visitCareDetailedReductionRadioLayout.setHgap(0);

      visitCareDetailedReductionRadioLayout.setLabelMargin(0);

      visitCareDetailedReductionRadioLayout.setVgap(0);

      addVisitCareDetailedReductionRadioLayout();
    }
    return visitCareDetailedReductionRadioLayout;

  }

  /**
   * 割を取得します。
   * @return 割
   */
  public ACRadioButtonItem getVisitCareDetailedReductionRadioItem1(){
    if(visitCareDetailedReductionRadioItem1==null){

      visitCareDetailedReductionRadioItem1 = new ACRadioButtonItem();

      visitCareDetailedReductionRadioItem1.setText("割");

      visitCareDetailedReductionRadioItem1.setGroup(getVisitCareDetailedReductionRadio());

      visitCareDetailedReductionRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitCareDetailedReductionRadioItem1();
    }
    return visitCareDetailedReductionRadioItem1;

  }

  /**
   * 円を取得します。
   * @return 円
   */
  public ACRadioButtonItem getVisitCareDetailedReductionRadioItem2(){
    if(visitCareDetailedReductionRadioItem2==null){

      visitCareDetailedReductionRadioItem2 = new ACRadioButtonItem();

      visitCareDetailedReductionRadioItem2.setText("円");

      visitCareDetailedReductionRadioItem2.setGroup(getVisitCareDetailedReductionRadio());

      visitCareDetailedReductionRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitCareDetailedReductionRadioItem2();
    }
    return visitCareDetailedReductionRadioItem2;

  }

  /**
   * 状態ラジオグループを取得します。
   * @return 状態ラジオグループ
   */
  public ACClearableRadioButtonGroup getVisitCareDetailedStateRadio(){
    if(visitCareDetailedStateRadio==null){

      visitCareDetailedStateRadio = new ACClearableRadioButtonGroup();

      visitCareDetailedStateRadio.setBindPath("1301143");

      visitCareDetailedStateRadio.setUseClearButton(false);

      visitCareDetailedStateRadio.setModel(getVisitCareDetailedStateRadioModel());

      addVisitCareDetailedStateRadio();
    }
    return visitCareDetailedStateRadio;

  }

  /**
   * 状態ラジオグループコンテナを取得します。
   * @return 状態ラジオグループコンテナ
   */
  protected ACLabelContainer getVisitCareDetailedStateRadioContainer(){
    if(visitCareDetailedStateRadioContainer==null){
      visitCareDetailedStateRadioContainer = new ACLabelContainer();
      visitCareDetailedStateRadioContainer.setFollowChildEnabled(true);
      visitCareDetailedStateRadioContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedStateRadioContainer.add(getVisitCareDetailedStateRadio(), null);
    }
    return visitCareDetailedStateRadioContainer;
  }

  /**
   * 状態ラジオグループモデルを取得します。
   * @return 状態ラジオグループモデル
   */
  protected ACListModelAdapter getVisitCareDetailedStateRadioModel(){
    if(visitCareDetailedStateRadioModel==null){
      visitCareDetailedStateRadioModel = new ACListModelAdapter();
      addVisitCareDetailedStateRadioModel();
    }
    return visitCareDetailedStateRadioModel;
  }

  /**
   * 免除を取得します。
   * @return 免除
   */
  public ACRadioButtonItem getVisitCareDetailedStateRadioItem1(){
    if(visitCareDetailedStateRadioItem1==null){

      visitCareDetailedStateRadioItem1 = new ACRadioButtonItem();

      visitCareDetailedStateRadioItem1.setText("免除");

      visitCareDetailedStateRadioItem1.setGroup(getVisitCareDetailedStateRadio());

      visitCareDetailedStateRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitCareDetailedStateRadioItem1();
    }
    return visitCareDetailedStateRadioItem1;

  }

  /**
   * 支払猶予を取得します。
   * @return 支払猶予
   */
  public ACRadioButtonItem getVisitCareDetailedStateRadioItem2(){
    if(visitCareDetailedStateRadioItem2==null){

      visitCareDetailedStateRadioItem2 = new ACRadioButtonItem();

      visitCareDetailedStateRadioItem2.setText("支払猶予");

      visitCareDetailedStateRadioItem2.setGroup(getVisitCareDetailedStateRadio());

      visitCareDetailedStateRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitCareDetailedStateRadioItem2();
    }
    return visitCareDetailedStateRadioItem2;

  }

  /**
   * 備考・グループを取得します。
   * @return 備考・グループ
   */
  public ACGroupBox getVisitCareDetailedTotalMoneyStanderdEtcFrame(){
    if(visitCareDetailedTotalMoneyStanderdEtcFrame==null){

      visitCareDetailedTotalMoneyStanderdEtcFrame = new ACGroupBox();

      visitCareDetailedTotalMoneyStanderdEtcFrame.setText("備考");

      visitCareDetailedTotalMoneyStanderdEtcFrame.setLayout(getVisitCareDetailedTotalMoneyStanderdEtcFrameLayout());

      addVisitCareDetailedTotalMoneyStanderdEtcFrame();
    }
    return visitCareDetailedTotalMoneyStanderdEtcFrame;

  }

  /**
   * 備考・グループ・レイアウトを取得します。
   * @return 備考・グループ・レイアウト
   */
  public VRLayout getVisitCareDetailedTotalMoneyStanderdEtcFrameLayout(){
    if(visitCareDetailedTotalMoneyStanderdEtcFrameLayout==null){

      visitCareDetailedTotalMoneyStanderdEtcFrameLayout = new VRLayout();

      visitCareDetailedTotalMoneyStanderdEtcFrameLayout.setAutoWrap(false);

      visitCareDetailedTotalMoneyStanderdEtcFrameLayout.setHgap(0);

      visitCareDetailedTotalMoneyStanderdEtcFrameLayout.setLabelMargin(0);

      visitCareDetailedTotalMoneyStanderdEtcFrameLayout.setVgap(0);

      addVisitCareDetailedTotalMoneyStanderdEtcFrameLayout();
    }
    return visitCareDetailedTotalMoneyStanderdEtcFrameLayout;

  }

  /**
   * 備考・テキストエリアを取得します。
   * @return 備考・テキストエリア
   */
  public ACTextArea getVisitCareDetailedTotalMoneyStanderdEtcText(){
    if(visitCareDetailedTotalMoneyStanderdEtcText==null){

      visitCareDetailedTotalMoneyStanderdEtcText = new ACTextArea();

      visitCareDetailedTotalMoneyStanderdEtcText.setBindPath("1301148");

      visitCareDetailedTotalMoneyStanderdEtcText.setColumns(65);

      visitCareDetailedTotalMoneyStanderdEtcText.setRows(4);

      visitCareDetailedTotalMoneyStanderdEtcText.setMaxRows(4);

      visitCareDetailedTotalMoneyStanderdEtcText.setIMEMode(InputSubset.KANJI);

      visitCareDetailedTotalMoneyStanderdEtcText.setMaxLength(300);

      visitCareDetailedTotalMoneyStanderdEtcText.setLineWrap(true);

      addVisitCareDetailedTotalMoneyStanderdEtcText();
    }
    return visitCareDetailedTotalMoneyStanderdEtcText;

  }

  /**
   * 備考・テキストエリアコンテナを取得します。
   * @return 備考・テキストエリアコンテナ
   */
  protected ACLabelContainer getVisitCareDetailedTotalMoneyStanderdEtcTextContainer(){
    if(visitCareDetailedTotalMoneyStanderdEtcTextContainer==null){
      visitCareDetailedTotalMoneyStanderdEtcTextContainer = new ACLabelContainer();
      visitCareDetailedTotalMoneyStanderdEtcTextContainer.setFollowChildEnabled(true);
      visitCareDetailedTotalMoneyStanderdEtcTextContainer.setVAlignment(VRLayout.CENTER);
      visitCareDetailedTotalMoneyStanderdEtcTextContainer.add(getVisitCareDetailedTotalMoneyStanderdEtcText(), null);
    }
    return visitCareDetailedTotalMoneyStanderdEtcTextContainer;
  }

  /**
   * コンストラクタです。
   */
  public QP006Design() {

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

    this.add(getInfos(), VRLayout.CLIENT);

  }

  /**
   * 業務ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getUpdate(), VRLayout.EAST);
  }

  /**
   * 更新に内部項目を追加します。
   */
  protected void addUpdate(){

  }

  /**
   * 情報領域に内部項目を追加します。
   */
  protected void addInfos(){

    infos.add(getContents(), VRLayout.NORTH);

    infos.add(getVisitCareDetailedInfosUnder(), VRLayout.CLIENT);

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getVisitCareDetailedContentLeft(), VRLayout.WEST);

    contents.add(getVisitCareDetailedContentRight(), VRLayout.WEST);

  }

  /**
   * クライアント領域・左に内部項目を追加します。
   */
  protected void addVisitCareDetailedContentLeft(){

    visitCareDetailedContentLeft.add(getVisitCareDetailedBasicInfo(), VRLayout.FLOW_RETURN);

  }

  /**
   * クライアント領域・左・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedContentLeftLayout(){

  }

  /**
   * 基本情報・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedBasicInfo(){

    visitCareDetailedBasicInfo.add(getVisitCareDetailedContentLeftUp(), VRLayout.NORTH);

    visitCareDetailedBasicInfo.add(getVisitCareDetailedContentLeftCenter1(), VRLayout.CLIENT);

    visitCareDetailedBasicInfo.add(getVisitCareDetailedSpecialWrites(), VRLayout.CLIENT);

  }

  /**
   * 基本情報・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedBasicInfoLayout(){

  }

  /**
   * 基本情報領域・上に内部項目を追加します。
   */
  protected void addVisitCareDetailedContentLeftUp(){

    visitCareDetailedContentLeftUp.add(getVisitCareDetailedDateContena(), VRLayout.FLOW);

    visitCareDetailedContentLeftUp.add(getVisitCareDetailedPrefectureNoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedContentLeftUp.add(getVisitCareDetailedStationCodeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedContentLeftUp.add(getVisitCareDetailedTownsAndVillagesContainer(), VRLayout.FLOW_INSETLINE);

    visitCareDetailedContentLeftUp.add(getVisitCareDetailedoldPersonContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedContentLeftUp.add(getVisitCareDetailedPublicExpense1Container(), VRLayout.FLOW_INSETLINE);

    visitCareDetailedContentLeftUp.add(getVisitCareDetailedPublicTake1Container(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedContentLeftUp.add(getVisitCareDetailedPublicExpense2Container(), VRLayout.FLOW_INSETLINE);

    visitCareDetailedContentLeftUp.add(getVisitCareDetailedPublicTake2Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 年月・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedDateContena(){

    visitCareDetailedDateContena.add(getVisitCareDetailedDateText(), VRLayout.FLOW);

    visitCareDetailedDateContena.add(getVisitCareDetailedDateLabel1(), VRLayout.FLOW);

  }

  /**
   * 年月・テキストに内部項目を追加します。
   */
  protected void addVisitCareDetailedDateText(){

  }

  /**
   * 分・ラベルに内部項目を追加します。
   */
  protected void addVisitCareDetailedDateLabel1(){

  }

  /**
   * 県番・テキストに内部項目を追加します。
   */
  protected void addVisitCareDetailedPrefectureNo(){

  }

  /**
   * ステーションコード・テキストに内部項目を追加します。
   */
  protected void addVisitCareDetailedStationCode(){

  }

  /**
   * ステーションコード・テキスト・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedStationCodeLayout(){

  }

  /**
   * 市町村番号に内部項目を追加します。
   */
  protected void addVisitCareDetailedTownsAndVillages(){

  }

  /**
   * 老人受給者番号に内部項目を追加します。
   */
  protected void addVisitCareDetailedoldPerson(){

  }

  /**
   * 公費負担者番号①に内部項目を追加します。
   */
  protected void addVisitCareDetailedPublicExpense1(){

  }

  /**
   * 公費受給者番号①に内部項目を追加します。
   */
  protected void addVisitCareDetailedPublicTake1(){

  }

  /**
   * 公費負担者番号②に内部項目を追加します。
   */
  protected void addVisitCareDetailedPublicExpense2(){

  }

  /**
   * 公費受給者番号②に内部項目を追加します。
   */
  protected void addVisitCareDetailedPublicTake2(){

  }

  /**
   * 基本情報領域・左に内部項目を追加します。
   */
  protected void addVisitCareDetailedContentLeftCenter1(){

    visitCareDetailedContentLeftCenter1.add(getVisitCareDetailedNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedContentLeftCenter1.add(getVisitCareDetailedSexContenaContainer(), VRLayout.FLOW_INSETLINE);

    visitCareDetailedContentLeftCenter1.add(getVisitCareDetailedBirthContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedContentLeftCenter1.add(getVisitCareDetailedOfficialReasonContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 氏名に内部項目を追加します。
   */
  protected void addVisitCareDetailedName(){

  }

  /**
   * 性別に内部項目を追加します。
   */
  protected void addVisitCareDetailedSexContena(){

  }

  /**
   * 生年月日に内部項目を追加します。
   */
  protected void addVisitCareDetailedBirth(){

  }

  /**
   * 職務上の事由に内部項目を追加します。
   */
  protected void addVisitCareDetailedOfficialReason(){

  }

  /**
   * 職務上の事由モデルに内部項目を追加します。
   */
  protected void addVisitCareDetailedOfficialReasonModel(){

  }

  /**
   * 特記・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedSpecialWrites(){

    visitCareDetailedSpecialWrites.add(getVisitCareDetailedSpecialWriteContainer(), VRLayout.FLOW);

  }

  /**
   * 特記・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedSpecialWritesLayout(){

  }

  /**
   * 特記テキストに内部項目を追加します。
   */
  protected void addVisitCareDetailedSpecialWrite(){

  }

  /**
   * クライアント領域・右に内部項目を追加します。
   */
  protected void addVisitCareDetailedContentRight(){

    visitCareDetailedContentRight.add(getVisitCareDetailedInsuranceInfoFram(), VRLayout.NORTH);

    visitCareDetailedContentRight.add(getVisitCareDetailedNurseCallStations(), VRLayout.NORTH);

  }

  /**
   * 保険情報・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedInsuranceInfoFram(){

    visitCareDetailedInsuranceInfoFram.add(getVisitCareDetailedInsure1Container(), VRLayout.FLOW_INSETLINE);

    visitCareDetailedInsuranceInfoFram.add(getVisitCareDetailedInsure2Container(), VRLayout.FLOW_INSETLINE);

    visitCareDetailedInsuranceInfoFram.add(getVisitCareDetailedInsure3Container(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedInsuranceInfoFram.add(getVisitCareDetailedInsure4Container(), VRLayout.FLOW_INSETLINE);

    visitCareDetailedInsuranceInfoFram.add(getVisitCareDetailedInsure5Container(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedInsuranceInfoFram.add(getVisitCareDetailedInsuranceContainer(), VRLayout.FLOW_INSETLINE);

    visitCareDetailedInsuranceInfoFram.add(getVisitCareDetailedRatioContents(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedInsuranceInfoFram.add(getVisitCareDetailedMarkAndNoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 保険情報・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedInsuranceInfoFramLayout(){

  }

  /**
   * 主保険に内部項目を追加します。
   */
  protected void addVisitCareDetailedInsure1(){

  }

  /**
   * 老人/退職に内部項目を追加します。
   */
  protected void addVisitCareDetailedInsure2(){

  }

  /**
   * 併用に内部項目を追加します。
   */
  protected void addVisitCareDetailedInsure3(){

  }

  /**
   * 本人/家族に内部項目を追加します。
   */
  protected void addVisitCareDetailedInsure4(){

  }

  /**
   * 高齢9/高齢8に内部項目を追加します。
   */
  protected void addVisitCareDetailedInsure5(){

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addVisitCareDetailedInsurance(){

  }

  /**
   * 給付割合コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedRatioContents(){

    visitCareDetailedRatioContents.add(getVisitCareDetailedRatio(), VRLayout.FLOW);

    visitCareDetailedRatioContents.add(getVisitCareDetailedRatioUnit(), VRLayout.FLOW);

  }

  /**
   * 給付割合に内部項目を追加します。
   */
  protected void addVisitCareDetailedRatio(){

  }

  /**
   * 給付割合単位に内部項目を追加します。
   */
  protected void addVisitCareDetailedRatioUnit(){

  }

  /**
   * 記号・番号に内部項目を追加します。
   */
  protected void addVisitCareDetailedMarkAndNo(){

  }

  /**
   * 老人）訪問看護ステーション・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedNurseCallStations(){

    visitCareDetailedNurseCallStations.add(getVisitCareDetailedNurseCallStationContainer(), VRLayout.FLOW);

  }

  /**
   * 老人）訪問看護ステーション・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedNurseCallStationsLayout(){

  }

  /**
   * 老人）訪問看護ステーションに内部項目を追加します。
   */
  protected void addVisitCareDetailedNurseCallStation(){

  }

  /**
   * 情報領域に内部項目を追加します。
   */
  protected void addVisitCareDetailedInfosUnder(){

    visitCareDetailedInfosUnder.add(getVisitCareDetailedPoints1(), VRLayout.CLIENT);

    visitCareDetailedInfosUnder.add(getVisitCareDetailedTotalInfos(), VRLayout.EAST);
  }

  /**
   * タブ領域に内部項目を追加します。
   */
  protected void addVisitCareDetailedPoints1(){

    visitCareDetailedPoints1.addTab("  心身の状態等  ", getVisitCareDetailedPanel1());

    visitCareDetailedPoints1.addTab("  基本療養費（Ｉ）", getVisitCareDetailed10Panel1());

    visitCareDetailedPoints1.addTab("  基本療養費（ＩＩ）", getVisitCareDetailed10Panel2());

    visitCareDetailedPoints1.addTab("  管理療養費等  ", getVisitCareDetailed20Panel());

    visitCareDetailedPoints1.addTab("  訪問看護情報１  ", getVisitCareDetailedPoints3Panel1());

    visitCareDetailedPoints1.addTab("  訪問看護情報２  ", getVisitCareDetailedPoints3Panel3());

  }

  /**
   * パネル1に内部項目を追加します。
   */
  protected void addVisitCareDetailedPanel1(){

    visitCareDetailedPanel1.add(getVisitCareDetailedMindState(), VRLayout.FLOW_RETURN);

    visitCareDetailedPanel1.add(getVisitCareDetailedMainDisease(), VRLayout.FLOW_RETURN);

    visitCareDetailedPanel1.add(getVisitCareDetailedInstructDate(), VRLayout.FLOW);

  }

  /**
   * 心身の状態・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedMindState(){

    visitCareDetailedMindState.add(getVisitCareDetailedMindStateTextContainer(), VRLayout.CLIENT);

  }

  /**
   * 心身の状態・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedMindStateLayout(){

  }

  /**
   * 心身の状態・テキストエリアに内部項目を追加します。
   */
  protected void addVisitCareDetailedMindStateText(){

  }

  /**
   * 主たる傷病名・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedMainDisease(){

    visitCareDetailedMainDisease.add(getVisitCareDetailedMainDiseaseTextContainer(), VRLayout.CLIENT);

  }

  /**
   * 主たる傷病名・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedMainDiseaseLayout(){

  }

  /**
   * 主たる傷病名・テキストエリアに内部項目を追加します。
   */
  protected void addVisitCareDetailedMainDiseaseText(){

  }

  /**
   * 指示年月日・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedInstructDate(){

    visitCareDetailedInstructDate.add(getVisitCareDetailedInstructPeriods(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedInstructDate.add(getVisitCareDetailedSpecialInstruct(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 指示年月日・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedInstructDateLayout(){

  }

  /**
   * 指示期間・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedInstructPeriods(){

    visitCareDetailedInstructPeriods.add(getVisitCareDetailedInstructDateText1(), VRLayout.FLOW);

    visitCareDetailedInstructPeriods.add(getVisitCareDetailedInstructDateLabel(), VRLayout.FLOW);

    visitCareDetailedInstructPeriods.add(getVisitCareDetailedInstructDateText2(), VRLayout.FLOW);

  }

  /**
   * 日付テキスト1に内部項目を追加します。
   */
  protected void addVisitCareDetailedInstructDateText1(){

  }

  /**
   * 日付ラベル1に内部項目を追加します。
   */
  protected void addVisitCareDetailedInstructDateLabel(){

  }

  /**
   * 日付テキスト2に内部項目を追加します。
   */
  protected void addVisitCareDetailedInstructDateText2(){

  }

  /**
   * 特別指示）・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedSpecialInstruct(){

    visitCareDetailedSpecialInstruct.add(getVisitCareDetailedSpecialInstructDateText1(), VRLayout.FLOW);

    visitCareDetailedSpecialInstruct.add(getVisitCareDetailedSpecialInstructDateLabel(), VRLayout.FLOW);

    visitCareDetailedSpecialInstruct.add(getVisitCareDetailedSpecialInstructDateText2(), VRLayout.FLOW);

  }

  /**
   * 日付テキスト特別1に内部項目を追加します。
   */
  protected void addVisitCareDetailedSpecialInstructDateText1(){

  }

  /**
   * 日付ラベル特別1に内部項目を追加します。
   */
  protected void addVisitCareDetailedSpecialInstructDateLabel(){

  }

  /**
   * 日付テキスト特別2に内部項目を追加します。
   */
  protected void addVisitCareDetailedSpecialInstructDateText2(){

  }

  /**
   * （１０）基本療養費パネル１に内部項目を追加します。
   */
  protected void addVisitCareDetailed10Panel1(){

    visitCareDetailed10Panel1.add(getVisitCareDetailedStanderdGroup(), VRLayout.CLIENT);

  }

  /**
   * 基本療養費・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedStanderdGroup(){

    visitCareDetailedStanderdGroup.add(getVisitCareDetailedStanderd(), VRLayout.NORTH);

  }

  /**
   * 基本療養費（Ⅱ）・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedStanderd(){

    visitCareDetailedStanderd.add(getVisitCareDetailed11Label1(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd.add(getVisitCareDetailed11Contena1(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd.add(getVisitCareDetailed11Contena2(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd.add(getVisitCareDetailed12Label(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd.add(getVisitCareDetailed12Contena1(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd.add(getVisitCareDetailed12Contena2(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd.add(getVisitCareDetailed13(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd.add(getVisitCareDetailed13Conatena(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd.add(getVisitCareDetailed13Conatena2(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd.add(getVisitCareDetailed14(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd.add(getVisitCareDetailed14Conatena(), VRLayout.FLOW_RETURN);

  }

  /**
   * 基本療養費・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedStanderdLayout(){

  }

  /**
   * １１）保健師、助産師、看護師、理学療法士、作業療法士、言語聴覚士に内部項目を追加します。
   */
  protected void addVisitCareDetailed11Label1(){

  }

  /**
   * １１コンテナ１に内部項目を追加します。
   */
  protected void addVisitCareDetailed11Contena1(){

    visitCareDetailed11Contena1.add(getVisitCareDetailedMoneyText1(), VRLayout.FLOW);

    visitCareDetailed11Contena1.add(getVisitCareDetailedMoneyLabel1(), VRLayout.FLOW);

    visitCareDetailed11Contena1.add(getVisitCareDetailedDayText1(), VRLayout.FLOW);

    visitCareDetailed11Contena1.add(getVisitCareDetailedDayLabel1(), VRLayout.FLOW);

    visitCareDetailed11Contena1.add(getVisitCareDetailedMoneyText2(), VRLayout.FLOW);

    visitCareDetailed11Contena1.add(getVisitCareDetailedMoneyLabel2(), VRLayout.FLOW);

    visitCareDetailed11Contena1.add(getVisitCareDetailedMoneyText3(), VRLayout.FLOW);

    visitCareDetailed11Contena1.add(getVisitCareDetailedMoneyLabel3(), VRLayout.FLOW);

    visitCareDetailed11Contena1.add(getVisitCareDetailedMoneyText4(), VRLayout.FLOW);

    visitCareDetailed11Contena1.add(getVisitCareDetailedMoneyLabel4(), VRLayout.FLOW);

  }

  /**
   * 金額テキスト1に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText1(){

  }

  /**
   * 金額ラベル1に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel1(){

  }

  /**
   * 日数テキスト1に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayText1(){

  }

  /**
   * 日数ラベル1に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayLabel1(){

  }

  /**
   * 金額テキスト2に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText2(){

  }

  /**
   * 金額ラベル2に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel2(){

  }

  /**
   * 金額テキスト3に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText3(){

  }

  /**
   * 金額ラベル3に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel3(){

  }

  /**
   * 金額テキスト4に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText4(){

  }

  /**
   * 金額ラベル4に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel4(){

  }

  /**
   * １１コンテナ２に内部項目を追加します。
   */
  protected void addVisitCareDetailed11Contena2(){

    visitCareDetailed11Contena2.add(getVisitCareDetailedMoneyText5(), VRLayout.FLOW);

    visitCareDetailed11Contena2.add(getVisitCareDetailedMoneyLabel5(), VRLayout.FLOW);

    visitCareDetailed11Contena2.add(getVisitCareDetailedDayText2(), VRLayout.FLOW);

    visitCareDetailed11Contena2.add(getVisitCareDetailedDayLabel2(), VRLayout.FLOW);

    visitCareDetailed11Contena2.add(getVisitCareDetailedMoneyText6(), VRLayout.FLOW);

    visitCareDetailed11Contena2.add(getVisitCareDetailedMoneyLabel6(), VRLayout.FLOW);

    visitCareDetailed11Contena2.add(getVisitCareDetailedMoneyText7(), VRLayout.FLOW);

    visitCareDetailed11Contena2.add(getVisitCareDetailedMoneyLabel7(), VRLayout.FLOW);

    visitCareDetailed11Contena2.add(getVisitCareDetailedMoneyText8(), VRLayout.FLOW);

    visitCareDetailed11Contena2.add(getVisitCareDetailedMoneyLabel8(), VRLayout.FLOW);

  }

  /**
   * 金額テキスト5に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText5(){

  }

  /**
   * 金額ラベル5に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel5(){

  }

  /**
   * 日数テキスト2に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayText2(){

  }

  /**
   * 日数ラベル2に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayLabel2(){

  }

  /**
   * 金額テキスト6に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText6(){

  }

  /**
   * 金額ラベル6に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel6(){

  }

  /**
   * 金額テキスト7に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText7(){

  }

  /**
   * 金額ラベル7に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel7(){

  }

  /**
   * 金額テキスト8に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText8(){

  }

  /**
   * 金額ラベル8に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel8(){

  }

  /**
   * １２）准看護師に内部項目を追加します。
   */
  protected void addVisitCareDetailed12Label(){

  }

  /**
   * １２コンテナ１に内部項目を追加します。
   */
  protected void addVisitCareDetailed12Contena1(){

    visitCareDetailed12Contena1.add(getVisitCareDetailedMoneyText9(), VRLayout.FLOW);

    visitCareDetailed12Contena1.add(getVisitCareDetailedMoneyLabel9(), VRLayout.FLOW);

    visitCareDetailed12Contena1.add(getVisitCareDetailedDayText3(), VRLayout.FLOW);

    visitCareDetailed12Contena1.add(getVisitCareDetailedDayLabel3(), VRLayout.FLOW);

    visitCareDetailed12Contena1.add(getVisitCareDetailedMoneyText10(), VRLayout.FLOW);

    visitCareDetailed12Contena1.add(getVisitCareDetailedMoneyLabel10(), VRLayout.FLOW);

    visitCareDetailed12Contena1.add(getVisitCareDetailedMoneyText11(), VRLayout.FLOW);

    visitCareDetailed12Contena1.add(getVisitCareDetailedMoneyLabel11(), VRLayout.FLOW);

    visitCareDetailed12Contena1.add(getVisitCareDetailedMoneyText12(), VRLayout.FLOW);

    visitCareDetailed12Contena1.add(getVisitCareDetailedMoneyLabel12(), VRLayout.FLOW);

  }

  /**
   * 金額テキスト9に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText9(){

  }

  /**
   * 金額ラベル9に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel9(){

  }

  /**
   * 日数テキスト3に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayText3(){

  }

  /**
   * 日数ラベル3に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayLabel3(){

  }

  /**
   * 金額テキスト10に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText10(){

  }

  /**
   * 金額ラベル10に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel10(){

  }

  /**
   * 金額テキスト11に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText11(){

  }

  /**
   * 金額ラベル11に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel11(){

  }

  /**
   * 金額テキスト12に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText12(){

  }

  /**
   * 金額ラベル12に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel12(){

  }

  /**
   * １２コンテナ２に内部項目を追加します。
   */
  protected void addVisitCareDetailed12Contena2(){

    visitCareDetailed12Contena2.add(getVisitCareDetailedMoneyText13(), VRLayout.FLOW);

    visitCareDetailed12Contena2.add(getVisitCareDetailedMoneyLabel13(), VRLayout.FLOW);

    visitCareDetailed12Contena2.add(getVisitCareDetailedDayText4(), VRLayout.FLOW);

    visitCareDetailed12Contena2.add(getVisitCareDetailedDayLabel4(), VRLayout.FLOW);

    visitCareDetailed12Contena2.add(getVisitCareDetailedMoneyText14(), VRLayout.FLOW);

    visitCareDetailed12Contena2.add(getVisitCareDetailedMoneyLabel14(), VRLayout.FLOW);

    visitCareDetailed12Contena2.add(getVisitCareDetailedMoneyText15(), VRLayout.FLOW);

    visitCareDetailed12Contena2.add(getVisitCareDetailedMoneyLabel15(), VRLayout.FLOW);

    visitCareDetailed12Contena2.add(getVisitCareDetailedMoneyText16(), VRLayout.FLOW);

    visitCareDetailed12Contena2.add(getVisitCareDetailedMoneyLabel16(), VRLayout.FLOW);

  }

  /**
   * 金額テキスト13に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText13(){

  }

  /**
   * 金額ラベル13に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel13(){

  }

  /**
   * 日数テキスト4に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayText4(){

  }

  /**
   * 日数ラベル4に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayLabel4(){

  }

  /**
   * 金額テキスト14に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText14(){

  }

  /**
   * 金額ラベル14に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel14(){

  }

  /**
   * 金額テキスト15に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText15(){

  }

  /**
   * 金額ラベル15に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel15(){

  }

  /**
   * 金額テキスト16に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText16(){

  }

  /**
   * 金額ラベル16に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel16(){

  }

  /**
   * １３）難病等複数回訪問加算に内部項目を追加します。
   */
  protected void addVisitCareDetailed13(){

  }

  /**
   * １３コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailed13Conatena(){

    visitCareDetailed13Conatena.add(getVisitCareDetailedMoneyText17(), VRLayout.FLOW);

    visitCareDetailed13Conatena.add(getVisitCareDetailedMoneyLabel17(), VRLayout.FLOW);

    visitCareDetailed13Conatena.add(getVisitCareDetailedDayText5(), VRLayout.FLOW);

    visitCareDetailed13Conatena.add(getVisitCareDetailedDayLabel5(), VRLayout.FLOW);

    visitCareDetailed13Conatena.add(getVisitCareDetailedMoneyText18(), VRLayout.FLOW);

    visitCareDetailed13Conatena.add(getVisitCareDetailedMoneyLabel18(), VRLayout.FLOW);

    visitCareDetailed13Conatena.add(getVisitCareDetailedMoneyText19(), VRLayout.FLOW);

    visitCareDetailed13Conatena.add(getVisitCareDetailedMoneyLabel19(), VRLayout.FLOW);

    visitCareDetailed13Conatena.add(getVisitCareDetailedMoneyText20(), VRLayout.FLOW);

    visitCareDetailed13Conatena.add(getVisitCareDetailedMoneyLabel20(), VRLayout.FLOW);

  }

  /**
   * 金額テキスト17に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText17(){

  }

  /**
   * 金額ラベル17に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel17(){

  }

  /**
   * 日数テキスト5に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayText5(){

  }

  /**
   * 日数ラベル5に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayLabel5(){

  }

  /**
   * 金額テキスト18に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText18(){

  }

  /**
   * 金額ラベル18に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel18(){

  }

  /**
   * 金額テキスト19に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText19(){

  }

  /**
   * 金額ラベル19に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel19(){

  }

  /**
   * 金額テキスト20に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText20(){

  }

  /**
   * 金額ラベル20に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel20(){

  }

  /**
   * １３コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailed13Conatena2(){

    visitCareDetailed13Conatena2.add(getVisitCareDetailedMoneyText51(), VRLayout.FLOW);

    visitCareDetailed13Conatena2.add(getVisitCareDetailedMoneyLabel51(), VRLayout.FLOW);

    visitCareDetailed13Conatena2.add(getVisitCareDetailedDayText8(), VRLayout.FLOW);

    visitCareDetailed13Conatena2.add(getVisitCareDetailedDayLabel8(), VRLayout.FLOW);

    visitCareDetailed13Conatena2.add(getVisitCareDetailedMoneyText52(), VRLayout.FLOW);

    visitCareDetailed13Conatena2.add(getVisitCareDetailedMoneyLabel52(), VRLayout.FLOW);

    visitCareDetailed13Conatena2.add(getVisitCareDetailedMoneyText53(), VRLayout.FLOW);

    visitCareDetailed13Conatena2.add(getVisitCareDetailedMoneyLabel53(), VRLayout.FLOW);

    visitCareDetailed13Conatena2.add(getVisitCareDetailedMoneyText54(), VRLayout.FLOW);

    visitCareDetailed13Conatena2.add(getVisitCareDetailedMoneyLabel54(), VRLayout.FLOW);

  }

  /**
   * 金額テキスト51に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText51(){

  }

  /**
   * 金額ラベル51に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel51(){

  }

  /**
   * 日数テキスト8に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayText8(){

  }

  /**
   * 日数ラベル8に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayLabel8(){

  }

  /**
   * 金額テキスト52に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText52(){

  }

  /**
   * 金額ラベル52に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel52(){

  }

  /**
   * 金額テキスト53に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText53(){

  }

  /**
   * 金額ラベル53に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel53(){

  }

  /**
   * 金額テキスト54に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText54(){

  }

  /**
   * 金額ラベル54に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel54(){

  }

  /**
   * １４）緊急訪問看護加算に内部項目を追加します。
   */
  protected void addVisitCareDetailed14(){

  }

  /**
   * １４コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailed14Conatena(){

    visitCareDetailed14Conatena.add(getVisitCareDetailedMoneyText55(), VRLayout.FLOW);

    visitCareDetailed14Conatena.add(getVisitCareDetailedMoneyLabel55(), VRLayout.FLOW);

    visitCareDetailed14Conatena.add(getVisitCareDetailedDayText9(), VRLayout.FLOW);

    visitCareDetailed14Conatena.add(getVisitCareDetailedDayLabel9(), VRLayout.FLOW);

    visitCareDetailed14Conatena.add(getVisitCareDetailedMoneyText56(), VRLayout.FLOW);

    visitCareDetailed14Conatena.add(getVisitCareDetailedMoneyLabel56(), VRLayout.FLOW);

    visitCareDetailed14Conatena.add(getVisitCareDetailedMoneyText57(), VRLayout.FLOW);

    visitCareDetailed14Conatena.add(getVisitCareDetailedMoneyLabel57(), VRLayout.FLOW);

    visitCareDetailed14Conatena.add(getVisitCareDetailedMoneyText58(), VRLayout.FLOW);

    visitCareDetailed14Conatena.add(getVisitCareDetailedMoneyLabel58(), VRLayout.FLOW);

  }

  /**
   * 金額テキスト55に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText55(){

  }

  /**
   * 金額ラベル55に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel55(){

  }

  /**
   * 日数テキスト9に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayText9(){

  }

  /**
   * 日数ラベル9に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayLabel9(){

  }

  /**
   * 金額テキスト56に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText56(){

  }

  /**
   * 金額ラベル56に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel56(){

  }

  /**
   * 金額テキスト57に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText57(){

  }

  /**
   * 金額ラベル58に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel57(){

  }

  /**
   * 金額テキスト59に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText58(){

  }

  /**
   * 金額ラベル60に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel58(){

  }

  /**
   * （１０）基本療養費パネル２に内部項目を追加します。
   */
  protected void addVisitCareDetailed10Panel2(){

    visitCareDetailed10Panel2.add(getVisitCareDetailedStanderd2(), VRLayout.NORTH);

  }

  /**
   * 基本療養費（II）・グループ）に内部項目を追加します。
   */
  protected void addVisitCareDetailedStanderd2(){

    visitCareDetailedStanderd2.add(getVisitCareDetailed14Label(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd2.add(getVisitCareDetailed14Contena(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd2.add(getVisitCareDetailed15label(), VRLayout.FLOW_RETURN);

    visitCareDetailedStanderd2.add(getVisitCareDetailed15Contena(), VRLayout.FLOW_RETURN);

  }

  /**
   * 基本療養費（II）・グループ・レイアウト）に内部項目を追加します。
   */
  protected void addVisitCareDetailedStanderd2Layout(){

  }

  /**
   * １５）保健師、看護師、作業療法士に内部項目を追加します。
   */
  protected void addVisitCareDetailed14Label(){

  }

  /**
   * １５）保健師、看護師、作業療法士・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailed14LabelLayout(){

  }

  /**
   * １５コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailed14Contena(){

    visitCareDetailed14Contena.add(getVisitCareDetailedMoneyText21(), VRLayout.FLOW);

    visitCareDetailed14Contena.add(getVisitCareDetailedMoneyLabel21(), VRLayout.FLOW);

    visitCareDetailed14Contena.add(getVisitCareDetailedDayText6(), VRLayout.FLOW);

    visitCareDetailed14Contena.add(getVisitCareDetailedDayLabel6(), VRLayout.FLOW);

    visitCareDetailed14Contena.add(getVisitCareDetailedMoneyText22(), VRLayout.FLOW);

    visitCareDetailed14Contena.add(getVisitCareDetailedMoneyLabel22(), VRLayout.FLOW);

    visitCareDetailed14Contena.add(getVisitCareDetailedMoneyText23(), VRLayout.FLOW);

    visitCareDetailed14Contena.add(getVisitCareDetailedMoneyLabel23(), VRLayout.FLOW);

    visitCareDetailed14Contena.add(getVisitCareDetailedMoneyText24(), VRLayout.FLOW);

    visitCareDetailed14Contena.add(getVisitCareDetailedMoneyLabel24(), VRLayout.FLOW);

  }

  /**
   * 金額テキスト21に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText21(){

  }

  /**
   * 金額ラベル21に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel21(){

  }

  /**
   * 日数テキスト6に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayText6(){

  }

  /**
   * 日数ラベル6に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayLabel6(){

  }

  /**
   * 金額テキスト22に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText22(){

  }

  /**
   * 金額ラベル22に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel22(){

  }

  /**
   * 金額テキスト23に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText23(){

  }

  /**
   * 金額ラベル23に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel23(){

  }

  /**
   * 金額テキスト24に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText24(){

  }

  /**
   * 金額ラベル24に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel24(){

  }

  /**
   * １６）延長時間加算に内部項目を追加します。
   */
  protected void addVisitCareDetailed15label(){

  }

  /**
   * １６コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailed15Contena(){

    visitCareDetailed15Contena.add(getVisitCareDetailedMoneyText25(), VRLayout.FLOW);

    visitCareDetailed15Contena.add(getVisitCareDetailedMoneyLabel25(), VRLayout.FLOW);

    visitCareDetailed15Contena.add(getVisitCareDetailedTimeText1(), VRLayout.FLOW);

    visitCareDetailed15Contena.add(getVisitCareDetailedTimeLabel1(), VRLayout.FLOW);

    visitCareDetailed15Contena.add(getVisitCareDetailedMoneyText26(), VRLayout.FLOW);

    visitCareDetailed15Contena.add(getVisitCareDetailedMoneyLabel26(), VRLayout.FLOW);

    visitCareDetailed15Contena.add(getVisitCareDetailedMoneyText27(), VRLayout.FLOW);

    visitCareDetailed15Contena.add(getVisitCareDetailedMoneyLabel27(), VRLayout.FLOW);

    visitCareDetailed15Contena.add(getVisitCareDetailedMoneyText28(), VRLayout.FLOW);

    visitCareDetailed15Contena.add(getVisitCareDetailedMoneyLabel28(), VRLayout.FLOW);

  }

  /**
   * １６コンテナ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailed15ContenaLayout(){

  }

  /**
   * 金額テキスト25に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText25(){

  }

  /**
   * 金額ラベル25に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel25(){

  }

  /**
   * 時間テキスト1に内部項目を追加します。
   */
  protected void addVisitCareDetailedTimeText1(){

  }

  /**
   * 時間ラベル1に内部項目を追加します。
   */
  protected void addVisitCareDetailedTimeLabel1(){

  }

  /**
   * 金額テキスト26に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText26(){

  }

  /**
   * 金額ラベル26に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel26(){

  }

  /**
   * 金額テキスト27に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText27(){

  }

  /**
   * 金額ラベル27に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel27(){

  }

  /**
   * 金額テキスト28に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText28(){

  }

  /**
   * 金額ラベル28に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel28(){

  }

  /**
   * （２０）管理療養費パネル）に内部項目を追加します。
   */
  protected void addVisitCareDetailed20Panel(){

    visitCareDetailed20Panel.add(getVisitCareDetailed20Frame(), VRLayout.NORTH);

    visitCareDetailed20Panel.add(getVisitCareDetailed30Frame(), VRLayout.NORTH);

    visitCareDetailed20Panel.add(getVisitCareDetailed40Frame(), VRLayout.NORTH);

  }

  /**
   * 管理療養費・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailed20Frame(){

    visitCareDetailed20Frame.add(getVisitCareDetailed21label(), VRLayout.FLOW_RETURN);

    visitCareDetailed20Frame.add(getVisitCareDetailed21Contena(), VRLayout.FLOW_RETURN);

    visitCareDetailed20Frame.add(getVisitCareDetailed22Label(), VRLayout.FLOW_RETURN);

    visitCareDetailed20Frame.add(getVisitCareDetailed23Conatena(), VRLayout.FLOW_RETURN);

    visitCareDetailed20Frame.add(getVisitCareDetailed24Contena(), VRLayout.FLOW_RETURN);

    visitCareDetailed20Frame.add(getVisitCareDetailed25Contena(), VRLayout.FLOW_RETURN);

  }

  /**
   * 管理療養費・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailed20FrameLayout(){

  }

  /**
   * ２１）管理療養費に内部項目を追加します。
   */
  protected void addVisitCareDetailed21label(){

  }

  /**
   * 療養管理費・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailed21Contena(){

    visitCareDetailed21Contena.add(getVisitCareDetailedMoneyText29(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedMoneyLabel29(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedMoneyText29Insert(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedMoneyLabel29Insert(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedDayText7(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedDayLabel7(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedMoneyText30(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedMoneyLabel30(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedMoneyText31(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedMoneyLabel31(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedMoneyText32(), VRLayout.FLOW);

    visitCareDetailed21Contena.add(getVisitCareDetailedMoneyLabel32(), VRLayout.FLOW_RETURN);

  }

  /**
   * 療養管理費・コンテナ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailed21ContenaLayout(){

  }

  /**
   * 金額テキスト29に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText29(){

  }

  /**
   * 金額ラベル29に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel29(){

  }

  /**
   * 金額テキスト追加に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText29Insert(){

  }

  /**
   * 金額ラベル追加に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel29Insert(){

  }

  /**
   * 日数テキスト7に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayText7(){

  }

  /**
   * 日数ラベル7に内部項目を追加します。
   */
  protected void addVisitCareDetailedDayLabel7(){

  }

  /**
   * 金額テキスト30に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText30(){

  }

  /**
   * 金額ラベル30に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel30(){

  }

  /**
   * 金額テキスト31に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText31(){

  }

  /**
   * 金額ラベル31に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel31(){

  }

  /**
   * 金額テキスト32に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText32(){

  }

  /**
   * 金額ラベル32に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel32(){

  }

  /**
   * ２２）管理療養費の加算に内部項目を追加します。
   */
  protected void addVisitCareDetailed22Label(){

  }

  /**
   * ２３）－２４・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailed23Conatena(){

    visitCareDetailed23Conatena.add(getVisitCareDetailed23Label(), VRLayout.FLOW);

    visitCareDetailed23Conatena.add(getVisitCareDetailedMoneyText36(), VRLayout.FLOW);

    visitCareDetailed23Conatena.add(getVisitCareDetailedMoneyLabel36(), VRLayout.FLOW);

    visitCareDetailed23Conatena.add(getVisitCareDetailedMoneyText37(), VRLayout.FLOW);

    visitCareDetailed23Conatena.add(getVisitCareDetailedMoneyLabel37(), VRLayout.FLOW);

    visitCareDetailed23Conatena.add(getVisitCareDetailedMoneyText38(), VRLayout.FLOW);

    visitCareDetailed23Conatena.add(getVisitCareDetailedMoneyLabel38(), VRLayout.FLOW_RETURN);

  }

  /**
   * ２３）－２４に内部項目を追加します。
   */
  protected void addVisitCareDetailed23Label(){

  }

  /**
   * 金額テキスト36に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText36(){

  }

  /**
   * 金額ラベル36に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel36(){

  }

  /**
   * 金額テキスト37に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText37(){

  }

  /**
   * 金額ラベル37に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel37(){

  }

  /**
   * 金額テキスト38に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText38(){

  }

  /**
   * 金額ラベル38に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel38(){

  }

  /**
   * ２４）－重症・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailed24Contena(){

    visitCareDetailed24Contena.add(getVisitCareDetailed24Label(), VRLayout.FLOW);

    visitCareDetailed24Contena.add(getVisitCareDetailedMoneyText39(), VRLayout.FLOW);

    visitCareDetailed24Contena.add(getVisitCareDetailedMoneyLabel39(), VRLayout.FLOW);

    visitCareDetailed24Contena.add(getVisitCareDetailedMoneyText40(), VRLayout.FLOW);

    visitCareDetailed24Contena.add(getVisitCareDetailedMoneyLabel40(), VRLayout.FLOW);

    visitCareDetailed24Contena.add(getVisitCareDetailedMoneyText41(), VRLayout.FLOW);

    visitCareDetailed24Contena.add(getVisitCareDetailedMoneyLabel41(), VRLayout.FLOW_RETURN);

  }

  /**
   * ２４）－重症に内部項目を追加します。
   */
  protected void addVisitCareDetailed24Label(){

  }

  /**
   * 金額テキスト39に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText39(){

  }

  /**
   * 金額ラベル39に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel39(){

  }

  /**
   * 金額テキスト40に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText40(){

  }

  /**
   * 金額ラベル40に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel40(){

  }

  /**
   * 金額テキスト41に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText41(){

  }

  /**
   * 金額ラベル41に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel41(){

  }

  /**
   * ２５）－退院・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailed25Contena(){

    visitCareDetailed25Contena.add(getVisitCareDetailed25Label(), VRLayout.FLOW);

    visitCareDetailed25Contena.add(getVisitCareDetailedMoneyText42(), VRLayout.FLOW);

    visitCareDetailed25Contena.add(getVisitCareDetailedMoneyLabel42(), VRLayout.FLOW);

    visitCareDetailed25Contena.add(getVisitCareDetailedMoneyText43(), VRLayout.FLOW);

    visitCareDetailed25Contena.add(getVisitCareDetailedMoneyLabel43(), VRLayout.FLOW);

    visitCareDetailed25Contena.add(getVisitCareDetailedMoneyText44(), VRLayout.FLOW);

    visitCareDetailed25Contena.add(getVisitCareDetailedMoneyLabel44(), VRLayout.FLOW);

  }

  /**
   * ２５）－退院に内部項目を追加します。
   */
  protected void addVisitCareDetailed25Label(){

  }

  /**
   * 金額テキスト42に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText42(){

  }

  /**
   * 金額ラベル42に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel42(){

  }

  /**
   * 金額テキスト43に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText43(){

  }

  /**
   * 金額ラベル43に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel43(){

  }

  /**
   * 金額テキスト44に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText44(){

  }

  /**
   * 金額ラベル44に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel44(){

  }

  /**
   * 情報提供療養費・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailed30Frame(){

    visitCareDetailed30Frame.add(getVisitCareDetailedMoneyText45Container(), VRLayout.FLOW);

    visitCareDetailed30Frame.add(getVisitCareDetailedMoneyLabel45(), VRLayout.FLOW);

    visitCareDetailed30Frame.add(getVisitCareDetailedMoneyText46Container(), VRLayout.FLOW);

    visitCareDetailed30Frame.add(getVisitCareDetailedMoneyLabel46(), VRLayout.FLOW);

    visitCareDetailed30Frame.add(getVisitCareDetailedMoneyText47Container(), VRLayout.FLOW);

    visitCareDetailed30Frame.add(getVisitCareDetailedMoneyLabel47(), VRLayout.FLOW);

  }

  /**
   * 情報提供療養費・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailed30FrameLayout(){

  }

  /**
   * 金額テキスト45に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText45(){

  }

  /**
   * 金額ラベル45に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel45(){

  }

  /**
   * 金額テキスト46に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText46(){

  }

  /**
   * 金額ラベル46に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel46(){

  }

  /**
   * 金額テキスト47に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText47(){

  }

  /**
   * 金額ラベル47に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel47(){

  }

  /**
   * ターミナルケア療養費・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailed40Frame(){

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyText48Container(), VRLayout.FLOW);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyLabel48(), VRLayout.FLOW);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyText49Container(), VRLayout.FLOW);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyLabel49(), VRLayout.FLOW);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyText50Container(), VRLayout.FLOW);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyLabel50(), VRLayout.FLOW_RETURN);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyText61Container(), VRLayout.FLOW);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyLabel61(), VRLayout.FLOW);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyText62Container(), VRLayout.FLOW);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyLabel62(), VRLayout.FLOW);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyText63Container(), VRLayout.FLOW);

    visitCareDetailed40Frame.add(getVisitCareDetailedMoneyLabel63(), VRLayout.FLOW);

  }

  /**
   * ターミナルケア療養費・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailed40FrameLayout(){

  }

  /**
   * 金額テキスト48に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText48(){

  }

  /**
   * 金額ラベル48に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel48(){

  }

  /**
   * 金額テキスト49に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText49(){

  }

  /**
   * 金額ラベル49に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel49(){

  }

  /**
   * 金額テキスト50に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText50(){

  }

  /**
   * 金額ラベル50に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel50(){

  }

  /**
   * 金額テキスト61に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText61(){

  }

  /**
   * 金額ラベル61に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel61(){

  }

  /**
   * 金額テキスト62に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText62(){

  }

  /**
   * 金額ラベル62に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel62(){

  }

  /**
   * 金額テキスト63に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyText63(){

  }

  /**
   * 金額ラベル63に内部項目を追加します。
   */
  protected void addVisitCareDetailedMoneyLabel63(){

  }

  /**
   * 3パネル1に内部項目を追加します。
   */
  protected void addVisitCareDetailedPoints3Panel1(){

    visitCareDetailedPoints3Panel1.add(getVisitCareDetailedPoints3Homon(), VRLayout.NORTH);

    visitCareDetailedPoints3Panel1.add(getVisitFrame(), VRLayout.NORTH);

  }

  /**
   * 3パネル1・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedPoints3Panel1Layout(){

  }

  /**
   * 訪問領域に内部項目を追加します。
   */
  protected void addVisitCareDetailedPoints3Homon(){

    visitCareDetailedPoints3Homon.add(getVisitStartContainer(), VRLayout.FLOW_RETURN);

    visitCareDetailedPoints3Homon.add(getVisitEndContainer(), VRLayout.FLOW);

    visitCareDetailedPoints3Homon.add(getVisitEndTimeContainer(), VRLayout.FLOW_RETURN);

    visitCareDetailedPoints3Homon.add(getVisitEndStateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedPoints3Homon.add(getVisitEndStateEtcContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedPoints3Homon.add(getDieDateContainer(), VRLayout.FLOW_INSETLINE);

    visitCareDetailedPoints3Homon.add(getDieTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedPoints3Homon.add(getMainDoctorOrganContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    visitCareDetailedPoints3Homon.add(getMainDoctorNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 訪問開始年月日に内部項目を追加します。
   */
  protected void addVisitStart(){

  }

  /**
   * 訪問終了年月日に内部項目を追加します。
   */
  protected void addVisitEnd(){

  }

  /**
   * 時刻に内部項目を追加します。
   */
  protected void addVisitEndTime(){

  }

  /**
   * 訪問終了の状況に内部項目を追加します。
   */
  protected void addVisitEndState(){

  }

  /**
   * 訪問終了の状況モデルに内部項目を追加します。
   */
  protected void addVisitEndStateModel(){

  }

  /**
   * その他理由に内部項目を追加します。
   */
  protected void addVisitEndStateEtc(){

  }

  /**
   * その他理由・レイアウトに内部項目を追加します。
   */
  protected void addVisitEndStateEtcLayout(){

  }

  /**
   * 死亡年月日に内部項目を追加します。
   */
  protected void addDieDate(){

  }

  /**
   * 時刻に内部項目を追加します。
   */
  protected void addDieTime(){

  }

  /**
   * 主治医の属する医療機関の名称に内部項目を追加します。
   */
  protected void addMainDoctorOrgan(){

  }

  /**
   * 主治医の氏名に内部項目を追加します。
   */
  protected void addMainDoctorName(){

  }

  /**
   * 訪問日グループに内部項目を追加します。
   */
  protected void addVisitFrame(){

    visitFrame.add(getVisitCombo1(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo2(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo3(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo4(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo5(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo6(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo7(), VRLayout.FLOW_RETURN);

    visitFrame.add(getVisitCombo8(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo9(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo10(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo11(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo12(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo13(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo14(), VRLayout.FLOW_RETURN);

    visitFrame.add(getVisitCombo15(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo16(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo17(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo18(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo19(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo20(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo21(), VRLayout.FLOW_RETURN);

    visitFrame.add(getVisitCombo22(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo23(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo24(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo25(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo26(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo27(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo28(), VRLayout.FLOW_RETURN);

    visitFrame.add(getVisitCombo29(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo30(), VRLayout.FLOW);

    visitFrame.add(getVisitCombo31(), VRLayout.FLOW);

  }

  /**
   * 訪問日グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitFrameLayout(){

  }

  /**
   * 訪問日コンボ1に内部項目を追加します。
   */
  protected void addVisitCombo1(){

  }

  /**
   * 訪問日コンボ1モデルに内部項目を追加します。
   */
  protected void addVisitCombo1Model(){

    getVisitCombo1Model().add(getVisitCombo1Item1());

    getVisitCombo1Model().add(getVisitCombo1Item2());

    getVisitCombo1Model().add(getVisitCombo1Item3());

    getVisitCombo1Model().add(getVisitCombo1Item4());

    getVisitCombo1Model().add(getVisitCombo1Item5());

  }

  /**
   * 1に内部項目を追加します。
   */
  protected void addVisitCombo1Item1(){

  }

  /**
   * 1○に内部項目を追加します。
   */
  protected void addVisitCombo1Item2(){

  }

  /**
   * 1△に内部項目を追加します。
   */
  protected void addVisitCombo1Item3(){

  }

  /**
   * 1◎に内部項目を追加します。
   */
  protected void addVisitCombo1Item4(){

  }

  /**
   * 1△◎に内部項目を追加します。
   */
  protected void addVisitCombo1Item5(){

  }

  /**
   * 訪問日コンボ2に内部項目を追加します。
   */
  protected void addVisitCombo2(){

  }

  /**
   * 訪問日コンボ2モデルに内部項目を追加します。
   */
  protected void addVisitCombo2Model(){

    getVisitCombo2Model().add(getVisitCombo2Item1());

    getVisitCombo2Model().add(getVisitCombo2Item2());

    getVisitCombo2Model().add(getVisitCombo2Item3());

    getVisitCombo2Model().add(getVisitCombo2Item4());

    getVisitCombo2Model().add(getVisitCombo2Item5());

  }

  /**
   * 2に内部項目を追加します。
   */
  protected void addVisitCombo2Item1(){

  }

  /**
   * 2○に内部項目を追加します。
   */
  protected void addVisitCombo2Item2(){

  }

  /**
   * 2△に内部項目を追加します。
   */
  protected void addVisitCombo2Item3(){

  }

  /**
   * 2◎に内部項目を追加します。
   */
  protected void addVisitCombo2Item4(){

  }

  /**
   * 2△◎に内部項目を追加します。
   */
  protected void addVisitCombo2Item5(){

  }

  /**
   * 訪問日コンボ3に内部項目を追加します。
   */
  protected void addVisitCombo3(){

  }

  /**
   * 訪問日コンボ3モデルに内部項目を追加します。
   */
  protected void addVisitCombo3Model(){

    getVisitCombo3Model().add(getVisitCombo3Item1());

    getVisitCombo3Model().add(getVisitCombo3Item2());

    getVisitCombo3Model().add(getVisitCombo3Item3());

    getVisitCombo3Model().add(getVisitCombo3Item4());

    getVisitCombo3Model().add(getVisitCombo3Item5());

  }

  /**
   * 3に内部項目を追加します。
   */
  protected void addVisitCombo3Item1(){

  }

  /**
   * 3○に内部項目を追加します。
   */
  protected void addVisitCombo3Item2(){

  }

  /**
   * 3△に内部項目を追加します。
   */
  protected void addVisitCombo3Item3(){

  }

  /**
   * 3◎に内部項目を追加します。
   */
  protected void addVisitCombo3Item4(){

  }

  /**
   * 3△◎に内部項目を追加します。
   */
  protected void addVisitCombo3Item5(){

  }

  /**
   * 訪問日コンボ4に内部項目を追加します。
   */
  protected void addVisitCombo4(){

  }

  /**
   * 訪問日コンボ4モデルに内部項目を追加します。
   */
  protected void addVisitCombo4Model(){

    getVisitCombo4Model().add(getVisitCombo4item1());

    getVisitCombo4Model().add(getVisitCombo4item2());

    getVisitCombo4Model().add(getVisitCombo4item3());

    getVisitCombo4Model().add(getVisitCombo4item4());

    getVisitCombo4Model().add(getVisitCombo4item5());

  }

  /**
   * 4に内部項目を追加します。
   */
  protected void addVisitCombo4item1(){

  }

  /**
   * 4○に内部項目を追加します。
   */
  protected void addVisitCombo4item2(){

  }

  /**
   * 4△に内部項目を追加します。
   */
  protected void addVisitCombo4item3(){

  }

  /**
   * 4◎に内部項目を追加します。
   */
  protected void addVisitCombo4item4(){

  }

  /**
   * 4△◎に内部項目を追加します。
   */
  protected void addVisitCombo4item5(){

  }

  /**
   * 訪問日コンボ5に内部項目を追加します。
   */
  protected void addVisitCombo5(){

  }

  /**
   * 訪問日コンボ5モデルに内部項目を追加します。
   */
  protected void addVisitCombo5Model(){

    getVisitCombo5Model().add(getVisitCombo5Item1());

    getVisitCombo5Model().add(getVisitCombo5Item2());

    getVisitCombo5Model().add(getVisitCombo5Item3());

    getVisitCombo5Model().add(getVisitCombo5Item4());

    getVisitCombo5Model().add(getVisitCombo5Item5());

  }

  /**
   * 5に内部項目を追加します。
   */
  protected void addVisitCombo5Item1(){

  }

  /**
   * 5○に内部項目を追加します。
   */
  protected void addVisitCombo5Item2(){

  }

  /**
   * 5△に内部項目を追加します。
   */
  protected void addVisitCombo5Item3(){

  }

  /**
   * 5◎に内部項目を追加します。
   */
  protected void addVisitCombo5Item4(){

  }

  /**
   * 5△◎に内部項目を追加します。
   */
  protected void addVisitCombo5Item5(){

  }

  /**
   * 訪問日コンボ6に内部項目を追加します。
   */
  protected void addVisitCombo6(){

  }

  /**
   * 訪問日コンボ6モデルに内部項目を追加します。
   */
  protected void addVisitCombo6Model(){

    getVisitCombo6Model().add(getVisitCombo6Item1());

    getVisitCombo6Model().add(getVisitCombo6Item2());

    getVisitCombo6Model().add(getVisitCombo6Item3());

    getVisitCombo6Model().add(getVisitCombo6Item4());

    getVisitCombo6Model().add(getVisitCombo6Item5());

  }

  /**
   * 6に内部項目を追加します。
   */
  protected void addVisitCombo6Item1(){

  }

  /**
   * 6○に内部項目を追加します。
   */
  protected void addVisitCombo6Item2(){

  }

  /**
   * 6△に内部項目を追加します。
   */
  protected void addVisitCombo6Item3(){

  }

  /**
   * 6◎に内部項目を追加します。
   */
  protected void addVisitCombo6Item4(){

  }

  /**
   * 6△◎に内部項目を追加します。
   */
  protected void addVisitCombo6Item5(){

  }

  /**
   * 訪問日コンボ7に内部項目を追加します。
   */
  protected void addVisitCombo7(){

  }

  /**
   * 訪問日コンボ7モデルに内部項目を追加します。
   */
  protected void addVisitCombo7Model(){

    getVisitCombo7Model().add(getVisitCombo7Item1());

    getVisitCombo7Model().add(getVisitCombo7Item2());

    getVisitCombo7Model().add(getVisitCombo7Item3());

    getVisitCombo7Model().add(getVisitCombo7Item4());

    getVisitCombo7Model().add(getVisitCombo7Item5());

  }

  /**
   * 7に内部項目を追加します。
   */
  protected void addVisitCombo7Item1(){

  }

  /**
   * 7○に内部項目を追加します。
   */
  protected void addVisitCombo7Item2(){

  }

  /**
   * 7△に内部項目を追加します。
   */
  protected void addVisitCombo7Item3(){

  }

  /**
   * 7◎に内部項目を追加します。
   */
  protected void addVisitCombo7Item4(){

  }

  /**
   * 7△◎に内部項目を追加します。
   */
  protected void addVisitCombo7Item5(){

  }

  /**
   * 訪問日コンボ8に内部項目を追加します。
   */
  protected void addVisitCombo8(){

  }

  /**
   * 訪問日コンボ8モデルに内部項目を追加します。
   */
  protected void addVisitCombo8Model(){

    getVisitCombo8Model().add(getVisitCombo8Item1());

    getVisitCombo8Model().add(getVisitCombo8Item2());

    getVisitCombo8Model().add(getVisitCombo8Item3());

    getVisitCombo8Model().add(getVisitCombo8Item4());

    getVisitCombo8Model().add(getVisitCombo8Item5());

  }

  /**
   * 8に内部項目を追加します。
   */
  protected void addVisitCombo8Item1(){

  }

  /**
   * 8○に内部項目を追加します。
   */
  protected void addVisitCombo8Item2(){

  }

  /**
   * 8△に内部項目を追加します。
   */
  protected void addVisitCombo8Item3(){

  }

  /**
   * 8◎に内部項目を追加します。
   */
  protected void addVisitCombo8Item4(){

  }

  /**
   * 8△◎に内部項目を追加します。
   */
  protected void addVisitCombo8Item5(){

  }

  /**
   * 訪問日コンボ9に内部項目を追加します。
   */
  protected void addVisitCombo9(){

  }

  /**
   * 訪問日コンボ9モデルに内部項目を追加します。
   */
  protected void addVisitCombo9Model(){

    getVisitCombo9Model().add(getVisitCombo9Item1());

    getVisitCombo9Model().add(getVisitCombo9Item2());

    getVisitCombo9Model().add(getVisitCombo9Item3());

    getVisitCombo9Model().add(getVisitCombo9Item4());

    getVisitCombo9Model().add(getVisitCombo9Item5());

  }

  /**
   * 9に内部項目を追加します。
   */
  protected void addVisitCombo9Item1(){

  }

  /**
   * 9○に内部項目を追加します。
   */
  protected void addVisitCombo9Item2(){

  }

  /**
   * 9△に内部項目を追加します。
   */
  protected void addVisitCombo9Item3(){

  }

  /**
   * 9◎に内部項目を追加します。
   */
  protected void addVisitCombo9Item4(){

  }

  /**
   * 9△◎に内部項目を追加します。
   */
  protected void addVisitCombo9Item5(){

  }

  /**
   * 訪問日コンボ10に内部項目を追加します。
   */
  protected void addVisitCombo10(){

  }

  /**
   * 訪問日コンボ10モデルに内部項目を追加します。
   */
  protected void addVisitCombo10Model(){

    getVisitCombo10Model().add(getVisitCombo10Item1());

    getVisitCombo10Model().add(getVisitCombo10Item2());

    getVisitCombo10Model().add(getVisitCombo10Item3());

    getVisitCombo10Model().add(getVisitCombo10Item4());

    getVisitCombo10Model().add(getVisitCombo10Item5());

  }

  /**
   * 10に内部項目を追加します。
   */
  protected void addVisitCombo10Item1(){

  }

  /**
   * 10○に内部項目を追加します。
   */
  protected void addVisitCombo10Item2(){

  }

  /**
   * 10△に内部項目を追加します。
   */
  protected void addVisitCombo10Item3(){

  }

  /**
   * 10◎に内部項目を追加します。
   */
  protected void addVisitCombo10Item4(){

  }

  /**
   * 10△◎に内部項目を追加します。
   */
  protected void addVisitCombo10Item5(){

  }

  /**
   * 訪問日コンボ11に内部項目を追加します。
   */
  protected void addVisitCombo11(){

  }

  /**
   * 訪問日コンボ11モデルに内部項目を追加します。
   */
  protected void addVisitCombo11Model(){

    getVisitCombo11Model().add(getVisitCombo11Item1());

    getVisitCombo11Model().add(getVisitCombo11Item2());

    getVisitCombo11Model().add(getVisitCombo11Item3());

    getVisitCombo11Model().add(getVisitCombo11Item4());

    getVisitCombo11Model().add(getVisitCombo11Item5());

  }

  /**
   * 11に内部項目を追加します。
   */
  protected void addVisitCombo11Item1(){

  }

  /**
   * 11○に内部項目を追加します。
   */
  protected void addVisitCombo11Item2(){

  }

  /**
   * 11△に内部項目を追加します。
   */
  protected void addVisitCombo11Item3(){

  }

  /**
   * 11◎に内部項目を追加します。
   */
  protected void addVisitCombo11Item4(){

  }

  /**
   * 11△◎に内部項目を追加します。
   */
  protected void addVisitCombo11Item5(){

  }

  /**
   * 訪問日コンボ12に内部項目を追加します。
   */
  protected void addVisitCombo12(){

  }

  /**
   * 訪問日コンボ12モデルに内部項目を追加します。
   */
  protected void addVisitCombo12Model(){

    getVisitCombo12Model().add(getVisitCombo12Item1());

    getVisitCombo12Model().add(getVisitCombo12Item2());

    getVisitCombo12Model().add(getVisitCombo12Item3());

    getVisitCombo12Model().add(getVisitCombo12Item4());

    getVisitCombo12Model().add(getVisitCombo12Item5());

  }

  /**
   * 12に内部項目を追加します。
   */
  protected void addVisitCombo12Item1(){

  }

  /**
   * 12○に内部項目を追加します。
   */
  protected void addVisitCombo12Item2(){

  }

  /**
   * 12△に内部項目を追加します。
   */
  protected void addVisitCombo12Item3(){

  }

  /**
   * 12◎に内部項目を追加します。
   */
  protected void addVisitCombo12Item4(){

  }

  /**
   * 12△◎に内部項目を追加します。
   */
  protected void addVisitCombo12Item5(){

  }

  /**
   * 訪問日コンボ13に内部項目を追加します。
   */
  protected void addVisitCombo13(){

  }

  /**
   * 訪問日コンボ13モデルに内部項目を追加します。
   */
  protected void addVisitCombo13Model(){

    getVisitCombo13Model().add(getVisitCombo13Item1());

    getVisitCombo13Model().add(getVisitCombo13Item2());

    getVisitCombo13Model().add(getVisitCombo13Item3());

    getVisitCombo13Model().add(getVisitCombo13Item4());

    getVisitCombo13Model().add(getVisitCombo13Item5());

  }

  /**
   * 13に内部項目を追加します。
   */
  protected void addVisitCombo13Item1(){

  }

  /**
   * 13○に内部項目を追加します。
   */
  protected void addVisitCombo13Item2(){

  }

  /**
   * 13△に内部項目を追加します。
   */
  protected void addVisitCombo13Item3(){

  }

  /**
   * 13◎に内部項目を追加します。
   */
  protected void addVisitCombo13Item4(){

  }

  /**
   * 13△◎に内部項目を追加します。
   */
  protected void addVisitCombo13Item5(){

  }

  /**
   * 訪問日コンボ14に内部項目を追加します。
   */
  protected void addVisitCombo14(){

  }

  /**
   * 訪問日コンボ14モデルに内部項目を追加します。
   */
  protected void addVisitCombo14Model(){

    getVisitCombo14Model().add(getVisitCombo14Item1());

    getVisitCombo14Model().add(getVisitCombo14Item2());

    getVisitCombo14Model().add(getVisitCombo14Item3());

    getVisitCombo14Model().add(getVisitCombo14Item4());

    getVisitCombo14Model().add(getVisitCombo14Item5());

  }

  /**
   * 14に内部項目を追加します。
   */
  protected void addVisitCombo14Item1(){

  }

  /**
   * 14○に内部項目を追加します。
   */
  protected void addVisitCombo14Item2(){

  }

  /**
   * 14△に内部項目を追加します。
   */
  protected void addVisitCombo14Item3(){

  }

  /**
   * 14◎に内部項目を追加します。
   */
  protected void addVisitCombo14Item4(){

  }

  /**
   * 14△◎に内部項目を追加します。
   */
  protected void addVisitCombo14Item5(){

  }

  /**
   * 訪問日コンボ15に内部項目を追加します。
   */
  protected void addVisitCombo15(){

  }

  /**
   * 訪問日コンボ15モデルに内部項目を追加します。
   */
  protected void addVisitCombo15Model(){

    getVisitCombo15Model().add(getVisitCombo15Item1());

    getVisitCombo15Model().add(getVisitCombo15Item2());

    getVisitCombo15Model().add(getVisitCombo15Item3());

    getVisitCombo15Model().add(getVisitCombo15Item4());

    getVisitCombo15Model().add(getVisitCombo15Item5());

  }

  /**
   * 15に内部項目を追加します。
   */
  protected void addVisitCombo15Item1(){

  }

  /**
   * 15○に内部項目を追加します。
   */
  protected void addVisitCombo15Item2(){

  }

  /**
   * 15△に内部項目を追加します。
   */
  protected void addVisitCombo15Item3(){

  }

  /**
   * 15◎に内部項目を追加します。
   */
  protected void addVisitCombo15Item4(){

  }

  /**
   * 15△◎に内部項目を追加します。
   */
  protected void addVisitCombo15Item5(){

  }

  /**
   * 訪問日コンボ16に内部項目を追加します。
   */
  protected void addVisitCombo16(){

  }

  /**
   * 訪問日コンボ16モデルに内部項目を追加します。
   */
  protected void addVisitCombo16Model(){

    getVisitCombo16Model().add(getVisitCombo16Item1());

    getVisitCombo16Model().add(getVisitCombo16Item2());

    getVisitCombo16Model().add(getVisitCombo16Item3());

    getVisitCombo16Model().add(getVisitCombo16Item4());

    getVisitCombo16Model().add(getVisitCombo16Item5());

  }

  /**
   * 16に内部項目を追加します。
   */
  protected void addVisitCombo16Item1(){

  }

  /**
   * 16○に内部項目を追加します。
   */
  protected void addVisitCombo16Item2(){

  }

  /**
   * 16△に内部項目を追加します。
   */
  protected void addVisitCombo16Item3(){

  }

  /**
   * 16◎に内部項目を追加します。
   */
  protected void addVisitCombo16Item4(){

  }

  /**
   * 16△◎に内部項目を追加します。
   */
  protected void addVisitCombo16Item5(){

  }

  /**
   * 訪問日コンボ17に内部項目を追加します。
   */
  protected void addVisitCombo17(){

  }

  /**
   * 訪問日コンボ17モデルに内部項目を追加します。
   */
  protected void addVisitCombo17Model(){

    getVisitCombo17Model().add(getVisitCombo17Item1());

    getVisitCombo17Model().add(getVisitCombo17Item2());

    getVisitCombo17Model().add(getVisitCombo17Item3());

    getVisitCombo17Model().add(getVisitCombo17Item4());

    getVisitCombo17Model().add(getVisitCombo17Item5());

  }

  /**
   * 17に内部項目を追加します。
   */
  protected void addVisitCombo17Item1(){

  }

  /**
   * 17○に内部項目を追加します。
   */
  protected void addVisitCombo17Item2(){

  }

  /**
   * 17△に内部項目を追加します。
   */
  protected void addVisitCombo17Item3(){

  }

  /**
   * 17◎に内部項目を追加します。
   */
  protected void addVisitCombo17Item4(){

  }

  /**
   * 17△◎に内部項目を追加します。
   */
  protected void addVisitCombo17Item5(){

  }

  /**
   * 訪問日コンボ18に内部項目を追加します。
   */
  protected void addVisitCombo18(){

  }

  /**
   * 訪問日コンボ18モデルに内部項目を追加します。
   */
  protected void addVisitCombo18Model(){

    getVisitCombo18Model().add(getVisitCombo18Item1());

    getVisitCombo18Model().add(getVisitCombo18Item2());

    getVisitCombo18Model().add(getVisitCombo18Item3());

    getVisitCombo18Model().add(getVisitCombo18Item4());

    getVisitCombo18Model().add(getVisitCombo18Item5());

  }

  /**
   * 18に内部項目を追加します。
   */
  protected void addVisitCombo18Item1(){

  }

  /**
   * 18○に内部項目を追加します。
   */
  protected void addVisitCombo18Item2(){

  }

  /**
   * 18△に内部項目を追加します。
   */
  protected void addVisitCombo18Item3(){

  }

  /**
   * 18◎に内部項目を追加します。
   */
  protected void addVisitCombo18Item4(){

  }

  /**
   * 18△◎に内部項目を追加します。
   */
  protected void addVisitCombo18Item5(){

  }

  /**
   * 訪問日コンボ19に内部項目を追加します。
   */
  protected void addVisitCombo19(){

  }

  /**
   * 訪問日コンボ19モデルに内部項目を追加します。
   */
  protected void addVisitCombo19Model(){

    getVisitCombo19Model().add(getVisitCombo19Item1());

    getVisitCombo19Model().add(getVisitCombo19Item2());

    getVisitCombo19Model().add(getVisitCombo19Item3());

    getVisitCombo19Model().add(getVisitCombo19Item4());

    getVisitCombo19Model().add(getVisitCombo19Item5());

  }

  /**
   * 19に内部項目を追加します。
   */
  protected void addVisitCombo19Item1(){

  }

  /**
   * 19○に内部項目を追加します。
   */
  protected void addVisitCombo19Item2(){

  }

  /**
   * 19△に内部項目を追加します。
   */
  protected void addVisitCombo19Item3(){

  }

  /**
   * 19◎に内部項目を追加します。
   */
  protected void addVisitCombo19Item4(){

  }

  /**
   * 19△◎に内部項目を追加します。
   */
  protected void addVisitCombo19Item5(){

  }

  /**
   * 訪問日コンボ20に内部項目を追加します。
   */
  protected void addVisitCombo20(){

  }

  /**
   * 訪問日コンボ20モデルに内部項目を追加します。
   */
  protected void addVisitCombo20Model(){

    getVisitCombo20Model().add(getVisitCombo20Item1());

    getVisitCombo20Model().add(getVisitCombo20Item2());

    getVisitCombo20Model().add(getVisitCombo20Item3());

    getVisitCombo20Model().add(getVisitCombo20Item4());

    getVisitCombo20Model().add(getVisitCombo20Item5());

  }

  /**
   * 20に内部項目を追加します。
   */
  protected void addVisitCombo20Item1(){

  }

  /**
   * 20○に内部項目を追加します。
   */
  protected void addVisitCombo20Item2(){

  }

  /**
   * 20△に内部項目を追加します。
   */
  protected void addVisitCombo20Item3(){

  }

  /**
   * 20◎に内部項目を追加します。
   */
  protected void addVisitCombo20Item4(){

  }

  /**
   * 20△◎に内部項目を追加します。
   */
  protected void addVisitCombo20Item5(){

  }

  /**
   * 訪問日コンボ21に内部項目を追加します。
   */
  protected void addVisitCombo21(){

  }

  /**
   * 訪問日コンボ21モデルに内部項目を追加します。
   */
  protected void addVisitCombo21Model(){

    getVisitCombo21Model().add(getVisitCombo21Item1());

    getVisitCombo21Model().add(getVisitCombo21Item2());

    getVisitCombo21Model().add(getVisitCombo21Item3());

    getVisitCombo21Model().add(getVisitCombo21Item4());

    getVisitCombo21Model().add(getVisitCombo21Item5());

  }

  /**
   * 21に内部項目を追加します。
   */
  protected void addVisitCombo21Item1(){

  }

  /**
   * 21○に内部項目を追加します。
   */
  protected void addVisitCombo21Item2(){

  }

  /**
   * 21△に内部項目を追加します。
   */
  protected void addVisitCombo21Item3(){

  }

  /**
   * 21◎に内部項目を追加します。
   */
  protected void addVisitCombo21Item4(){

  }

  /**
   * 21△◎に内部項目を追加します。
   */
  protected void addVisitCombo21Item5(){

  }

  /**
   * 訪問日コンボ22に内部項目を追加します。
   */
  protected void addVisitCombo22(){

  }

  /**
   * 訪問日コンボ22モデルに内部項目を追加します。
   */
  protected void addVisitCombo22Model(){

    getVisitCombo22Model().add(getVisitCombo22Item1());

    getVisitCombo22Model().add(getVisitCombo22Item2());

    getVisitCombo22Model().add(getVisitCombo22Item3());

    getVisitCombo22Model().add(getVisitCombo22Item4());

    getVisitCombo22Model().add(getVisitCombo22Item5());

  }

  /**
   * 22に内部項目を追加します。
   */
  protected void addVisitCombo22Item1(){

  }

  /**
   * 22○に内部項目を追加します。
   */
  protected void addVisitCombo22Item2(){

  }

  /**
   * 22△に内部項目を追加します。
   */
  protected void addVisitCombo22Item3(){

  }

  /**
   * 22◎に内部項目を追加します。
   */
  protected void addVisitCombo22Item4(){

  }

  /**
   * 22△◎に内部項目を追加します。
   */
  protected void addVisitCombo22Item5(){

  }

  /**
   * 訪問日コンボ23に内部項目を追加します。
   */
  protected void addVisitCombo23(){

  }

  /**
   * 訪問日コンボ23モデルに内部項目を追加します。
   */
  protected void addVisitCombo23Model(){

    getVisitCombo23Model().add(getVisitCombo23Item1());

    getVisitCombo23Model().add(getVisitCombo23Item2());

    getVisitCombo23Model().add(getVisitCombo23Item3());

    getVisitCombo23Model().add(getVisitCombo23Item4());

    getVisitCombo23Model().add(getVisitCombo23Item5());

  }

  /**
   * 23に内部項目を追加します。
   */
  protected void addVisitCombo23Item1(){

  }

  /**
   * 23○に内部項目を追加します。
   */
  protected void addVisitCombo23Item2(){

  }

  /**
   * 23△に内部項目を追加します。
   */
  protected void addVisitCombo23Item3(){

  }

  /**
   * 23◎に内部項目を追加します。
   */
  protected void addVisitCombo23Item4(){

  }

  /**
   * 23△◎に内部項目を追加します。
   */
  protected void addVisitCombo23Item5(){

  }

  /**
   * 訪問日コンボ24に内部項目を追加します。
   */
  protected void addVisitCombo24(){

  }

  /**
   * 訪問日コンボ24モデルに内部項目を追加します。
   */
  protected void addVisitCombo24Model(){

    getVisitCombo24Model().add(getVisitCombo24Item1());

    getVisitCombo24Model().add(getVisitCombo24Item2());

    getVisitCombo24Model().add(getVisitCombo24Item3());

    getVisitCombo24Model().add(getVisitCombo24Item4());

    getVisitCombo24Model().add(getVisitCombo24Item5());

  }

  /**
   * 24に内部項目を追加します。
   */
  protected void addVisitCombo24Item1(){

  }

  /**
   * 24○に内部項目を追加します。
   */
  protected void addVisitCombo24Item2(){

  }

  /**
   * 24△に内部項目を追加します。
   */
  protected void addVisitCombo24Item3(){

  }

  /**
   * 24◎に内部項目を追加します。
   */
  protected void addVisitCombo24Item4(){

  }

  /**
   * 24△◎に内部項目を追加します。
   */
  protected void addVisitCombo24Item5(){

  }

  /**
   * 訪問日コンボ25に内部項目を追加します。
   */
  protected void addVisitCombo25(){

  }

  /**
   * 訪問日コンボ25モデルに内部項目を追加します。
   */
  protected void addVisitCombo25Model(){

    getVisitCombo25Model().add(getVisitCombo25Item1());

    getVisitCombo25Model().add(getVisitCombo25Item2());

    getVisitCombo25Model().add(getVisitCombo25Item3());

    getVisitCombo25Model().add(getVisitCombo25Item4());

    getVisitCombo25Model().add(getVisitCombo25Item5());

  }

  /**
   * 25に内部項目を追加します。
   */
  protected void addVisitCombo25Item1(){

  }

  /**
   * 25○に内部項目を追加します。
   */
  protected void addVisitCombo25Item2(){

  }

  /**
   * 25△に内部項目を追加します。
   */
  protected void addVisitCombo25Item3(){

  }

  /**
   * 25◎に内部項目を追加します。
   */
  protected void addVisitCombo25Item4(){

  }

  /**
   * 25△◎に内部項目を追加します。
   */
  protected void addVisitCombo25Item5(){

  }

  /**
   * 訪問日コンボ26に内部項目を追加します。
   */
  protected void addVisitCombo26(){

  }

  /**
   * 訪問日コンボ26モデルに内部項目を追加します。
   */
  protected void addVisitCombo26Model(){

    getVisitCombo26Model().add(getVisitCombo26Item1());

    getVisitCombo26Model().add(getVisitCombo26Item2());

    getVisitCombo26Model().add(getVisitCombo26Item3());

    getVisitCombo26Model().add(getVisitCombo26Item4());

    getVisitCombo26Model().add(getVisitCombo26Item5());

  }

  /**
   * 26に内部項目を追加します。
   */
  protected void addVisitCombo26Item1(){

  }

  /**
   * 26○に内部項目を追加します。
   */
  protected void addVisitCombo26Item2(){

  }

  /**
   * 26△に内部項目を追加します。
   */
  protected void addVisitCombo26Item3(){

  }

  /**
   * 26◎に内部項目を追加します。
   */
  protected void addVisitCombo26Item4(){

  }

  /**
   * 26△◎に内部項目を追加します。
   */
  protected void addVisitCombo26Item5(){

  }

  /**
   * 訪問日コンボ27に内部項目を追加します。
   */
  protected void addVisitCombo27(){

  }

  /**
   * 訪問日コンボ27モデルに内部項目を追加します。
   */
  protected void addVisitCombo27Model(){

    getVisitCombo27Model().add(getVisitCombo27Item1());

    getVisitCombo27Model().add(getVisitCombo27Item2());

    getVisitCombo27Model().add(getVisitCombo27Item3());

    getVisitCombo27Model().add(getVisitCombo27Item4());

    getVisitCombo27Model().add(getVisitCombo27Item5());

  }

  /**
   * 27に内部項目を追加します。
   */
  protected void addVisitCombo27Item1(){

  }

  /**
   * 27○に内部項目を追加します。
   */
  protected void addVisitCombo27Item2(){

  }

  /**
   * 27△に内部項目を追加します。
   */
  protected void addVisitCombo27Item3(){

  }

  /**
   * 27◎に内部項目を追加します。
   */
  protected void addVisitCombo27Item4(){

  }

  /**
   * 27△◎に内部項目を追加します。
   */
  protected void addVisitCombo27Item5(){

  }

  /**
   * 訪問日コンボ28に内部項目を追加します。
   */
  protected void addVisitCombo28(){

  }

  /**
   * 訪問日コンボ28モデルに内部項目を追加します。
   */
  protected void addVisitCombo28Model(){

    getVisitCombo28Model().add(getVisitCombo28Item1());

    getVisitCombo28Model().add(getVisitCombo28Item2());

    getVisitCombo28Model().add(getVisitCombo28Item3());

    getVisitCombo28Model().add(getVisitCombo28Item4());

    getVisitCombo28Model().add(getVisitCombo28Item5());

  }

  /**
   * 28に内部項目を追加します。
   */
  protected void addVisitCombo28Item1(){

  }

  /**
   * 28○に内部項目を追加します。
   */
  protected void addVisitCombo28Item2(){

  }

  /**
   * 28△に内部項目を追加します。
   */
  protected void addVisitCombo28Item3(){

  }

  /**
   * 28◎に内部項目を追加します。
   */
  protected void addVisitCombo28Item4(){

  }

  /**
   * 28△◎に内部項目を追加します。
   */
  protected void addVisitCombo28Item5(){

  }

  /**
   * 訪問日コンボ29に内部項目を追加します。
   */
  protected void addVisitCombo29(){

  }

  /**
   * 訪問日コンボ29モデルに内部項目を追加します。
   */
  protected void addVisitCombo29Model(){

    getVisitCombo29Model().add(getVisitCombo29Item1());

    getVisitCombo29Model().add(getVisitCombo29Item2());

    getVisitCombo29Model().add(getVisitCombo29Item3());

    getVisitCombo29Model().add(getVisitCombo29Item4());

    getVisitCombo29Model().add(getVisitCombo29Item5());

  }

  /**
   * 29に内部項目を追加します。
   */
  protected void addVisitCombo29Item1(){

  }

  /**
   * 29○に内部項目を追加します。
   */
  protected void addVisitCombo29Item2(){

  }

  /**
   * 29△に内部項目を追加します。
   */
  protected void addVisitCombo29Item3(){

  }

  /**
   * 29◎に内部項目を追加します。
   */
  protected void addVisitCombo29Item4(){

  }

  /**
   * 29△◎に内部項目を追加します。
   */
  protected void addVisitCombo29Item5(){

  }

  /**
   * 訪問日コンボ30に内部項目を追加します。
   */
  protected void addVisitCombo30(){

  }

  /**
   * 訪問日コンボ30モデルに内部項目を追加します。
   */
  protected void addVisitCombo30Model(){

    getVisitCombo30Model().add(getVisitCombo30Item1());

    getVisitCombo30Model().add(getVisitCombo30Item2());

    getVisitCombo30Model().add(getVisitCombo30Item3());

    getVisitCombo30Model().add(getVisitCombo30Item4());

    getVisitCombo30Model().add(getVisitCombo30Item5());

  }

  /**
   * 30に内部項目を追加します。
   */
  protected void addVisitCombo30Item1(){

  }

  /**
   * 30○に内部項目を追加します。
   */
  protected void addVisitCombo30Item2(){

  }

  /**
   * 30△に内部項目を追加します。
   */
  protected void addVisitCombo30Item3(){

  }

  /**
   * 30◎に内部項目を追加します。
   */
  protected void addVisitCombo30Item4(){

  }

  /**
   * 30△◎に内部項目を追加します。
   */
  protected void addVisitCombo30Item5(){

  }

  /**
   * 訪問日コンボ31に内部項目を追加します。
   */
  protected void addVisitCombo31(){

  }

  /**
   * 訪問日コンボ31モデルに内部項目を追加します。
   */
  protected void addVisitCombo31Model(){

    getVisitCombo31Model().add(getVisitCombo31Item1());

    getVisitCombo31Model().add(getVisitCombo31Item2());

    getVisitCombo31Model().add(getVisitCombo31Item3());

    getVisitCombo31Model().add(getVisitCombo31Item4());

    getVisitCombo31Model().add(getVisitCombo31Item5());

  }

  /**
   * 31に内部項目を追加します。
   */
  protected void addVisitCombo31Item1(){

  }

  /**
   * 31○に内部項目を追加します。
   */
  protected void addVisitCombo31Item2(){

  }

  /**
   * 31△に内部項目を追加します。
   */
  protected void addVisitCombo31Item3(){

  }

  /**
   * 31◎に内部項目を追加します。
   */
  protected void addVisitCombo31Item4(){

  }

  /**
   * 31△◎に内部項目を追加します。
   */
  protected void addVisitCombo31Item5(){

  }

  /**
   * 3パネル3に内部項目を追加します。
   */
  protected void addVisitCareDetailedPoints3Panel3(){

    visitCareDetailedPoints3Panel3.add(getRealityDate(), VRLayout.NORTH);

    visitCareDetailedPoints3Panel3.add(getMainDoctorInfoDatePanel(), VRLayout.NORTH);

    visitCareDetailedPoints3Panel3.add(getOfferInfos(), VRLayout.NORTH);

    visitCareDetailedPoints3Panel3.add(getInfoOfferTownsAndVillagesNameContainer(), VRLayout.FLOW);

    visitCareDetailedPoints3Panel3.add(getSpecialEtcs(), VRLayout.NORTH);

  }

  /**
   * 実日数・グループに内部項目を追加します。
   */
  protected void addRealityDate(){

    realityDate.add(getInsuranceContena(), VRLayout.FLOW_INSETLINE_RETURN);

    realityDate.add(getPublicExpenseContena(), VRLayout.FLOW_INSETLINE_RETURN);

    realityDate.add(getPublicExpense2Contena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 実日数・グループ・レイアウトに内部項目を追加します。
   */
  protected void addRealityDateLayout(){

  }

  /**
   * 保険コンテナに内部項目を追加します。
   */
  protected void addInsuranceContena(){

    insuranceContena.add(getInsuranceLabel1(), null);

    insuranceContena.add(getInsuranceText1(), null);

    insuranceContena.add(getInsuranceLabel2(), null);

  }

  /**
   * ラベル1に内部項目を追加します。
   */
  protected void addInsuranceLabel1(){

  }

  /**
   * テキストに内部項目を追加します。
   */
  protected void addInsuranceText1(){

  }

  /**
   * ラベル2に内部項目を追加します。
   */
  protected void addInsuranceLabel2(){

  }

  /**
   * 公費１コンテナに内部項目を追加します。
   */
  protected void addPublicExpenseContena(){

    publicExpenseContena.add(getPublicExpenseLabel1(), null);

    publicExpenseContena.add(getPublicExpenseText1(), null);

    publicExpenseContena.add(getPublicExpenseLabel2(), null);

    publicExpenseContena.add(getPublicExpenseText2(), null);

  }

  /**
   * ラベル1に内部項目を追加します。
   */
  protected void addPublicExpenseLabel1(){

  }

  /**
   * テキストに内部項目を追加します。
   */
  protected void addPublicExpenseText1(){

  }

  /**
   * ラベル2に内部項目を追加します。
   */
  protected void addPublicExpenseLabel2(){

  }

  /**
   * テキスト2に内部項目を追加します。
   */
  protected void addPublicExpenseText2(){

  }

  /**
   * 公費２コンテナに内部項目を追加します。
   */
  protected void addPublicExpense2Contena(){

    publicExpense2Contena.add(getPublicExpense2Label1(), null);

    publicExpense2Contena.add(getPublicExpense2Text1(), null);

    publicExpense2Contena.add(getPublicExpense2ContenaLabel2(), null);

    publicExpense2Contena.add(getPublicExpense2Text2(), null);

  }

  /**
   * ラベル1に内部項目を追加します。
   */
  protected void addPublicExpense2Label1(){

  }

  /**
   * テキストに内部項目を追加します。
   */
  protected void addPublicExpense2Text1(){

  }

  /**
   * ラベル2に内部項目を追加します。
   */
  protected void addPublicExpense2ContenaLabel2(){

  }

  /**
   * テキスト2に内部項目を追加します。
   */
  protected void addPublicExpense2Text2(){

  }

  /**
   * 主治医への直近報告年月日・パネルに内部項目を追加します。
   */
  protected void addMainDoctorInfoDatePanel(){

    mainDoctorInfoDatePanel.add(getMainDoctorInfoDateContainer(), VRLayout.FLOW);

  }

  /**
   * 主治医への直近報告年月日に内部項目を追加します。
   */
  protected void addMainDoctorInfoDate(){

  }

  /**
   * 提供した情報の概要・グループに内部項目を追加します。
   */
  protected void addOfferInfos(){

    offerInfos.add(getOfferInfoTextContainer(), VRLayout.FLOW);

  }

  /**
   * 提供した情報の概要・グループ・レイアウトに内部項目を追加します。
   */
  protected void addOfferInfoLayout(){

  }

  /**
   * 提供した情報の概要テキストに内部項目を追加します。
   */
  protected void addOfferInfoText(){

  }

  /**
   * 情報提供先の市（区）町村等の名称に内部項目を追加します。
   */
  protected void addInfoOfferTownsAndVillagesName(){

  }

  /**
   * 特記事項・グループに内部項目を追加します。
   */
  protected void addSpecialEtcs(){

    specialEtcs.add(getSpecialEtcTextContainer(), VRLayout.FLOW);

  }

  /**
   * 特記事項・グループ・レイアウトに内部項目を追加します。
   */
  protected void addSpecialEtcLayout(){

  }

  /**
   * 特記事項に内部項目を追加します。
   */
  protected void addSpecialEtcText(){

  }

  /**
   * 合計情報パネルに内部項目を追加します。
   */
  protected void addVisitCareDetailedTotalInfos(){

    visitCareDetailedTotalInfos.add(getVisitCareDetailedTotalInfosFrame(), null);

  }

  /**
   * 合計情報領域・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedTotalInfosLayout(){

  }

  /**
   * 合計情報領域・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedTotalInfosFrame(){

    visitCareDetailedTotalInfosFrame.add(getVisitCareDetailedExpenseMoneyFrame(), VRLayout.NORTH);

    visitCareDetailedTotalInfosFrame.add(getVisitCareDetailedOneshareFrame(), VRLayout.NORTH);

    visitCareDetailedTotalInfosFrame.add(getVisitCareDetailedTotalMoneyStanderdEtcFrame(), VRLayout.NORTH);

  }

  /**
   * 合計情報領域・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedTotalInfosFrameLayout(){

  }

  /**
   * 請求・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyFrame(){

    visitCareDetailedExpenseMoneyFrame.add(getVisitCareDetailedExpenseMoneyContena1(), VRLayout.FLOW);

    visitCareDetailedExpenseMoneyFrame.add(getVisitCareDetailedExpenseMoneyContena2(), VRLayout.FLOW);

    visitCareDetailedExpenseMoneyFrame.add(getVisitCareDetailedExpenseMoneyContena3(), VRLayout.FLOW_RETURN);

  }

  /**
   * 請求・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyFrameLayout(){

  }

  /**
   * 請求金額1・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyContena1(){

    visitCareDetailedExpenseMoneyContena1.add(getVisitCareDetailedExpenseMoneyText1(), VRLayout.FLOW);

    visitCareDetailedExpenseMoneyContena1.add(getVisitCareDetailedExpenseMoneyLabel1(), VRLayout.FLOW);

  }

  /**
   * 請求金額テキスト1に内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyText1(){

  }

  /**
   * 請求金額ラベル1に内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyLabel1(){

  }

  /**
   * 請求金額2・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyContena2(){

    visitCareDetailedExpenseMoneyContena2.add(getVisitCareDetailedExpenseMoneyText2(), VRLayout.FLOW);

    visitCareDetailedExpenseMoneyContena2.add(getVisitCareDetailedExpenseMoneyLabel2(), VRLayout.FLOW);

  }

  /**
   * 請求金額テキスト2に内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyText2(){

  }

  /**
   * 請求金額ラベル2に内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyLabel2(){

  }

  /**
   * 請求金額3・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyContena3(){

    visitCareDetailedExpenseMoneyContena3.add(getVisitCareDetailedExpenseMoneyText3(), VRLayout.FLOW);

    visitCareDetailedExpenseMoneyContena3.add(getVisitCareDetailedExpenseMoneyLabel3(), VRLayout.FLOW);

  }

  /**
   * 請求金額テキスト3に内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyText3(){

  }

  /**
   * 請求金額ラベル3に内部項目を追加します。
   */
  protected void addVisitCareDetailedExpenseMoneyLabel3(){

  }

  /**
   * 負担金額・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareFrame(){

    visitCareDetailedOneshareFrame.add(getVisitCareDetailedOneshareContena1(), VRLayout.FLOW);

    visitCareDetailedOneshareFrame.add(getVisitCareDetailedOneshareContena2(), VRLayout.FLOW);

    visitCareDetailedOneshareFrame.add(getVisitCareDetailedOneshareContena3(), VRLayout.FLOW_RETURN);

    visitCareDetailedOneshareFrame.add(getVisitCareDetailedReductionGroup(), null);

  }

  /**
   * 負担金額・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareFrameLayout(){

  }

  /**
   * 負担金額1・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareContena1(){

    visitCareDetailedOneshareContena1.add(getVisitCareDetailedOneshareText(), VRLayout.FLOW);

    visitCareDetailedOneshareContena1.add(getVisitCareDetailedOneshareLabel(), VRLayout.FLOW);

  }

  /**
   * 負担金額テキスト1に内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareText(){

  }

  /**
   * 負担金額ラベル1に内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareLabel(){

  }

  /**
   * 負担金額2・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareContena2(){

    visitCareDetailedOneshareContena2.add(getVisitCareDetailedOneshareTex2(), VRLayout.FLOW);

    visitCareDetailedOneshareContena2.add(getVisitCareDetailedOneshareLabe2(), VRLayout.FLOW);

  }

  /**
   * 負担金額テキスト2に内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareTex2(){

  }

  /**
   * 負担金額ラベル2に内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareLabe2(){

  }

  /**
   * 負担金額3・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareContena3(){

    visitCareDetailedOneshareContena3.add(getVisitCareDetailedOneshareTex3(), VRLayout.FLOW);

    visitCareDetailedOneshareContena3.add(getVisitCareDetailedOneshareLabe3(), VRLayout.FLOW);

  }

  /**
   * 負担金額テキスト3に内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareTex3(){

  }

  /**
   * 負担金額ラベル3に内部項目を追加します。
   */
  protected void addVisitCareDetailedOneshareLabe3(){

  }

  /**
   * 減額グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedReductionGroup(){

    visitCareDetailedReductionGroup.add(getVisitCareDetailedReductionContena(), VRLayout.FLOW);

  }

  /**
   * 減額・コンテナに内部項目を追加します。
   */
  protected void addVisitCareDetailedReductionContena(){

    visitCareDetailedReductionContena.add(getVisitCareDetailedReductionContainer(), VRLayout.FLOW);

    visitCareDetailedReductionContena.add(getVisitCareDetailedReductionRadioContainer(), VRLayout.FLOW);

    visitCareDetailedReductionContena.add(getVisitCareDetailedStateRadioContainer(), VRLayout.FLOW);

  }

  /**
   * 減額に内部項目を追加します。
   */
  protected void addVisitCareDetailedReduction(){

  }

  /**
   * 減額ラジオグループに内部項目を追加します。
   */
  protected void addVisitCareDetailedReductionRadio(){

  }

  /**
   * 減額ラジオグループモデルに内部項目を追加します。
   */
  protected void addVisitCareDetailedReductionRadioModel(){

    getVisitCareDetailedReductionRadioItem1().setButtonIndex(1);
    getVisitCareDetailedReductionRadioModel().add(getVisitCareDetailedReductionRadioItem1());

    getVisitCareDetailedReductionRadioItem2().setButtonIndex(2);
    getVisitCareDetailedReductionRadioModel().add(getVisitCareDetailedReductionRadioItem2());

  }

  /**
   * 減額ラジオグループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedReductionRadioLayout(){

  }

  /**
   * 割に内部項目を追加します。
   */
  protected void addVisitCareDetailedReductionRadioItem1(){

  }

  /**
   * 円に内部項目を追加します。
   */
  protected void addVisitCareDetailedReductionRadioItem2(){

  }

  /**
   * 状態ラジオグループに内部項目を追加します。
   */
  protected void addVisitCareDetailedStateRadio(){

  }

  /**
   * 状態ラジオグループモデルに内部項目を追加します。
   */
  protected void addVisitCareDetailedStateRadioModel(){

    getVisitCareDetailedStateRadioItem1().setButtonIndex(1);
    getVisitCareDetailedStateRadioModel().add(getVisitCareDetailedStateRadioItem1());

    getVisitCareDetailedStateRadioItem2().setButtonIndex(2);
    getVisitCareDetailedStateRadioModel().add(getVisitCareDetailedStateRadioItem2());

  }

  /**
   * 免除に内部項目を追加します。
   */
  protected void addVisitCareDetailedStateRadioItem1(){

  }

  /**
   * 支払猶予に内部項目を追加します。
   */
  protected void addVisitCareDetailedStateRadioItem2(){

  }

  /**
   * 備考・グループに内部項目を追加します。
   */
  protected void addVisitCareDetailedTotalMoneyStanderdEtcFrame(){

    visitCareDetailedTotalMoneyStanderdEtcFrame.add(getVisitCareDetailedTotalMoneyStanderdEtcTextContainer(), VRLayout.FLOW);

  }

  /**
   * 備考・グループ・レイアウトに内部項目を追加します。
   */
  protected void addVisitCareDetailedTotalMoneyStanderdEtcFrameLayout(){

  }

  /**
   * 備考・テキストエリアに内部項目を追加します。
   */
  protected void addVisitCareDetailedTotalMoneyStanderdEtcText(){

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
      ACFrame.debugStart(new ACAffairInfo(QP006Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP006Design getThis() {
    return this;
  }
}
