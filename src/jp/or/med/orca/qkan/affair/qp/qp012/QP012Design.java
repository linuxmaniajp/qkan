
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
 * 開発者: 田中　統蔵
 * 作成日: 2007/03/18  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 訪問看護療養費領収書編集 (012)
 * プログラム 訪問看護療養費領収書編集 (QP012)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp012;
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
 * 訪問看護療養費領収書編集画面項目デザイン(QP012) 
 */
public class QP012Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton open;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton print;

  private ACPanel contents;

  private ACPanel mainItemContents;

  private ACGroupBox basicContents;

  private ACTextField billNo;

  private ACLabelContainer billNoContainer;

  private ACTextField patientCode;

  private ACLabelContainer patientCodeContainer;

  private ACTextField patientName;

  private ACLabelContainer patientNameContainer;

  private ACPanel itemContents;

  private JTabbedPane itemTabs;

  private ACPanel byInsurerContents;

  private ACPanel byInsurerTitle;

  private ACTextField byInsurerNameTitle;

  private ACTextField byInsurerPriceTitle;

  private ACTextField byInsurerNumberTitle;

  private ACTextField byInsurerSumTitle;

  private ACPanel byInsurer1;

  private ACComboBox byInsurerName1;

  private ACComboBoxModelAdapter byInsurerName1Model;

  private ACTextField byInsurerPrice1;

  private ACTextField byInsurerNumber1;

  private ACTextField byInsurerSum1;

  private ACPanel byInsurer2;

  private ACComboBox byInsurerName2;

  private ACComboBoxModelAdapter byInsurerName2Model;

  private ACTextField byInsurerPrice2;

  private ACTextField byInsurerNumber2;

  private ACTextField byInsurerSum2;

  private ACPanel byInsurer3;

  private ACComboBox byInsurerName3;

  private ACComboBoxModelAdapter byInsurerName3Model;

  private ACTextField byInsurerPrice3;

  private ACTextField byInsurerNumber3;

  private ACTextField byInsurerSum3;

  private ACPanel byInsurer4;

  private ACComboBox byInsurerName4;

  private ACComboBoxModelAdapter byInsurerName4Model;

  private ACTextField byInsurerPrice4;

  private ACTextField byInsurerNumber4;

  private ACTextField byInsurerSum4;

  private ACPanel byInsurer5;

  private ACComboBox byInsurerName5;

  private ACComboBoxModelAdapter byInsurerName5Model;

  private ACTextField byInsurerPrice5;

  private ACTextField byInsurerNumber5;

  private ACTextField byInsurerSum5;

  private ACPanel byInsurer6;

  private ACComboBox byInsurerName6;

  private ACComboBoxModelAdapter byInsurerName6Model;

  private ACTextField byInsurerPrice6;

  private ACTextField byInsurerNumber6;

  private ACTextField byInsurerSum6;

  private ACPanel byInsurer7;

  private ACComboBox byInsurerName7;

  private ACComboBoxModelAdapter byInsurerName7Model;

  private ACTextField byInsurerPrice7;

  private ACTextField byInsurerNumber7;

  private ACTextField byInsurerSum7;

  private ACPanel byInsurer8;

  private ACComboBox byInsurerName8;

  private ACComboBoxModelAdapter byInsurerName8Model;

  private ACTextField byInsurerPrice8;

  private ACTextField byInsurerNumber8;

  private ACTextField byInsurerSum8;

  private ACPanel byInsurer9;

  private ACComboBox byInsurerName9;

  private ACComboBoxModelAdapter byInsurerName9Model;

  private ACTextField byInsurerPrice9;

  private ACTextField byInsurerNumber9;

  private ACTextField byInsurerSum9;

  private ACPanel byInsurer10;

  private ACComboBox byInsurerName10;

  private ACComboBoxModelAdapter byInsurerName10Model;

  private ACTextField byInsurerPrice10;

  private ACTextField byInsurerNumber10;

  private ACTextField byInsurerSum10;

  private ACPanel byInsurer11;

  private ACComboBox byInsurerName11;

  private ACComboBoxModelAdapter byInsurerName11Model;

  private ACTextField byInsurerPrice11;

  private ACTextField byInsurerNumber11;

  private ACTextField byInsurerSum11;

  private ACPanel byInsurer12;

  private ACComboBox byInsurerName12;

  private ACComboBoxModelAdapter byInsurerName12Model;

  private ACTextField byInsurerPrice12;

  private ACTextField byInsurerNumber12;

  private ACTextField byInsurerSum12;

  private ACPanel byInsurer13;

  private ACComboBox byInsurerName13;

  private ACComboBoxModelAdapter byInsurerName13Model;

  private ACTextField byInsurerPrice13;

  private ACTextField byInsurerNumber13;

  private ACTextField byInsurerSum13;

  private ACPanel byInsurer14;

  private ACComboBox byInsurerName14;

  private ACComboBoxModelAdapter byInsurerName14Model;

  private ACTextField byInsurerPrice14;

  private ACTextField byInsurerNumber14;

  private ACTextField byInsurerSum14;

  private ACPanel byInsurer15;

  private ACComboBox byInsurerName15;

  private ACComboBoxModelAdapter byInsurerName15Model;

  private ACTextField byInsurerPrice15;

  private ACTextField byInsurerNumber15;

  private ACTextField byInsurerSum15;

  private ACPanel byInsurer16;

  private ACComboBox byInsurerName16;

  private ACComboBoxModelAdapter byInsurerName16Model;

  private ACTextField byInsurerPrice16;

  private ACTextField byInsurerNumber16;

  private ACTextField byInsurerSum16;

  private ACPanel byInsurer17;

  private ACComboBox byInsurerName17;

  private ACComboBoxModelAdapter byInsurerName17Model;

  private ACTextField byInsurerPrice17;

  private ACTextField byInsurerNumber17;

  private ACTextField byInsurerSum17;

  private ACPanel byInsurer18;

  private ACComboBox byInsurerName18;

  private ACComboBoxModelAdapter byInsurerName18Model;

  private ACTextField byInsurerPrice18;

  private ACTextField byInsurerNumber18;

  private ACTextField byInsurerSum18;

  private ACPanel byInsurer19;

  private ACComboBox byInsurerName19;

  private ACComboBoxModelAdapter byInsurerName19Model;

  private ACTextField byInsurerPrice19;

  private ACTextField byInsurerNumber19;

  private ACTextField byInsurerSum19;

  private ACPanel byInsurer20;

  private ACComboBox byInsurerName20;

  private ACComboBoxModelAdapter byInsurerName20Model;

  private ACTextField byInsurerPrice20;

  private ACTextField byInsurerNumber20;

  private ACTextField byInsurerSum20;

  private ACPanel byPatientContents;

  private ACPanel byPatientTitle;

  private ACTextField byPatientNameTitle;

  private ACTextField byPatientPriceTitle;

  private ACTextField byPatientNumberTitle;

  private ACTextField byPatientSumTitle;

  private ACTextField byPatientTaxTargetTitle;

  private ACTextField byPatientUseTaxTitle;

  private ACTextField byPatientTaxTitle;

  private ACPanel byPatient1;

  private ACComboBox byPatientName1;

  private ACComboBoxModelAdapter byPatientName1Model;

  private ACTextField byPatientPrice1;

  private ACTextField byPatientNumber1;

  private ACTextField byPatientSum1;

  private ACIntegerCheckBox byPatientTaxTarget1;

  private ACIntegerCheckBox byPatientUseTax1;

  private ACTextField byPatientTax1;

  private ACPanel byPatient2;

  private ACComboBox byPatientName2;

  private ACComboBoxModelAdapter byPatientName2Model;

  private ACTextField byPatientPrice2;

  private ACTextField byPatientNumber2;

  private ACTextField byPatientSum2;

  private ACIntegerCheckBox byPatientTaxTarget2;

  private ACIntegerCheckBox byPatientUseTax2;

  private ACTextField byPatientTax2;

  private ACPanel byPatient3;

  private ACComboBox byPatientName3;

  private ACComboBoxModelAdapter byPatientName3Model;

  private ACTextField byPatientPrice3;

  private ACTextField byPatientNumber3;

  private ACTextField byPatientSum3;

  private ACIntegerCheckBox byPatientTaxTarget3;

  private ACIntegerCheckBox byPatientUseTax3;

  private ACTextField byPatientTax3;

  private ACPanel byPatient4;

  private ACComboBox byPatientName4;

  private ACComboBoxModelAdapter byPatientName4Model;

  private ACTextField byPatientPrice4;

  private ACTextField byPatientNumber4;

  private ACTextField byPatientSum4;

  private ACIntegerCheckBox byPatientTaxTarget4;

  private ACIntegerCheckBox byPatientUseTax4;

  private ACTextField byPatientTax4;

  private ACPanel byPatient5;

  private ACComboBox byPatientName5;

  private ACComboBoxModelAdapter byPatientName5Model;

  private ACTextField byPatientPrice5;

  private ACTextField byPatientNumber5;

  private ACTextField byPatientSum5;

  private ACIntegerCheckBox byPatientTaxTarget5;

  private ACIntegerCheckBox byPatientUseTax5;

  private ACTextField byPatientTax5;

  private ACPanel byPatient6;

  private ACComboBox byPatientName6;

  private ACComboBoxModelAdapter byPatientName6Model;

  private ACTextField byPatientPrice6;

  private ACTextField byPatientNumber6;

  private ACTextField byPatientSum6;

  private ACIntegerCheckBox byPatientTaxTarget6;

  private ACIntegerCheckBox byPatientUseTax6;

  private ACTextField byPatientTax6;

  private ACPanel byPatient7;

  private ACComboBox byPatientName7;

  private ACComboBoxModelAdapter byPatientName7Model;

  private ACTextField byPatientPrice7;

  private ACTextField byPatientNumber7;

  private ACTextField byPatientSum7;

  private ACIntegerCheckBox byPatientTaxTarget7;

  private ACIntegerCheckBox byPatientUseTax7;

  private ACTextField byPatientTax7;

  private ACPanel byPatient8;

  private ACComboBox byPatientName8;

  private ACComboBoxModelAdapter byPatientName8Model;

  private ACTextField byPatientPrice8;

  private ACTextField byPatientNumber8;

  private ACTextField byPatientSum8;

  private ACIntegerCheckBox byPatientTaxTarget8;

  private ACIntegerCheckBox byPatientUseTax8;

  private ACTextField byPatientTax8;

  private ACPanel byPatient9;

  private ACComboBox byPatientName9;

  private ACComboBoxModelAdapter byPatientName9Model;

  private ACTextField byPatientPrice9;

  private ACTextField byPatientNumber9;

  private ACTextField byPatientSum9;

  private ACIntegerCheckBox byPatientTaxTarget9;

  private ACIntegerCheckBox byPatientUseTax9;

  private ACTextField byPatientTax9;

  private ACPanel byPatient10;

  private ACComboBox byPatientName10;

  private ACComboBoxModelAdapter byPatientName10Model;

  private ACTextField byPatientPrice10;

  private ACTextField byPatientNumber10;

  private ACTextField byPatientSum10;

  private ACIntegerCheckBox byPatientTaxTarget10;

  private ACIntegerCheckBox byPatientUseTax10;

  private ACTextField byPatientTax10;

  private ACPanel byPatient11;

  private ACComboBox byPatientName11;

  private ACComboBoxModelAdapter byPatientName11Model;

  private ACTextField byPatientPrice11;

  private ACTextField byPatientNumber11;

  private ACTextField byPatientSum11;

  private ACIntegerCheckBox byPatientTaxTarget11;

  private ACIntegerCheckBox byPatientUseTax11;

  private ACTextField byPatientTax11;

  private ACPanel byPatient12;

  private ACComboBox byPatientName12;

  private ACComboBoxModelAdapter byPatientName12Model;

  private ACTextField byPatientPrice12;

  private ACTextField byPatientNumber12;

  private ACTextField byPatientSum12;

  private ACIntegerCheckBox byPatientTaxTarget12;

  private ACIntegerCheckBox byPatientUseTax12;

  private ACTextField byPatientTax12;

  private ACPanel byPatient13;

  private ACComboBox byPatientName13;

  private ACComboBoxModelAdapter byPatientName13Model;

  private ACTextField byPatientPrice13;

  private ACTextField byPatientNumber13;

  private ACTextField byPatientSum13;

  private ACIntegerCheckBox byPatientTaxTarget13;

  private ACIntegerCheckBox byPatientUseTax13;

  private ACTextField byPatientTax13;

  private ACPanel byPatient14;

  private ACComboBox byPatientName14;

  private ACComboBoxModelAdapter byPatientName14Model;

  private ACTextField byPatientPrice14;

  private ACTextField byPatientNumber14;

  private ACTextField byPatientSum14;

  private ACIntegerCheckBox byPatientTaxTarget14;

  private ACIntegerCheckBox byPatientUseTax14;

  private ACTextField byPatientTax14;

  private ACPanel byPatient15;

  private ACComboBox byPatientName15;

  private ACComboBoxModelAdapter byPatientName15Model;

  private ACTextField byPatientPrice15;

  private ACTextField byPatientNumber15;

  private ACTextField byPatientSum15;

  private ACIntegerCheckBox byPatientTaxTarget15;

  private ACIntegerCheckBox byPatientUseTax15;

  private ACTextField byPatientTax15;

  private ACPanel byPatient16;

  private ACComboBox byPatientName16;

  private ACComboBoxModelAdapter byPatientName16Model;

  private ACTextField byPatientPrice16;

  private ACTextField byPatientNumber16;

  private ACTextField byPatientSum16;

  private ACIntegerCheckBox byPatientTaxTarget16;

  private ACIntegerCheckBox byPatientUseTax16;

  private ACTextField byPatientTax16;

  private ACPanel byPatient17;

  private ACComboBox byPatientName17;

  private ACComboBoxModelAdapter byPatientName17Model;

  private ACTextField byPatientPrice17;

  private ACTextField byPatientNumber17;

  private ACTextField byPatientSum17;

  private ACIntegerCheckBox byPatientTaxTarget17;

  private ACIntegerCheckBox byPatientUseTax17;

  private ACTextField byPatientTax17;

  private ACPanel byPatient18;

  private ACComboBox byPatientName18;

  private ACComboBoxModelAdapter byPatientName18Model;

  private ACTextField byPatientPrice18;

  private ACTextField byPatientNumber18;

  private ACTextField byPatientSum18;

  private ACIntegerCheckBox byPatientTaxTarget18;

  private ACIntegerCheckBox byPatientUseTax18;

  private ACTextField byPatientTax18;

  private ACPanel byPatient19;

  private ACComboBox byPatientName19;

  private ACComboBoxModelAdapter byPatientName19Model;

  private ACTextField byPatientPrice19;

  private ACTextField byPatientNumber19;

  private ACTextField byPatientSum19;

  private ACIntegerCheckBox byPatientTaxTarget19;

  private ACIntegerCheckBox byPatientUseTax19;

  private ACTextField byPatientTax19;

  private ACPanel byPatient20;

  private ACComboBox byPatientName20;

  private ACComboBoxModelAdapter byPatientName20Model;

  private ACTextField byPatientPrice20;

  private ACTextField byPatientNumber20;

  private ACTextField byPatientSum20;

  private ACIntegerCheckBox byPatientTaxTarget20;

  private ACIntegerCheckBox byPatientUseTax20;

  private ACTextField byPatientTax20;

  private ACLabel useTaxInfomation;

  private ACPanel optionContents;

  private ACGroupBox insurerContents;

  private ACLabelContainer billSpanContainer;

  private ACTextField billSpanStart;

  private ACLabel billSpan;

  private ACTextField billSpanEnd;

  private QkanDateTextField printDate;

  private ACLabelContainer printDateContainer;

  private ACLabelContainer byPatientRateContainer;

  private ACTextField byPatientRate;

  private ACLabel byPatientRateUnit;

  private ACTextField patientFamilyType;

  private ACLabelContainer patientFamilyTypeContainer;

  private ACTextField insureType;

  private ACLabelContainer insureTypeContainer;

  private ACLabelContainer taxContainer;

  private ACTextField tax;

  private ACLabel taxUnit;

  private ACButton taxChange;

  private ACGroupBox provideContents;

  private ACComboBox provideDay1;

  private ACComboBoxModelAdapter provideDay1Model;

  private ACListItem provideDay1Item1;

  private ACListItem provideDay1Item2;

  private ACListItem provideDay1Item3;

  private ACListItem provideDay1Item4;

  private ACListItem provideDay1Item5;

  private ACListItem provideDay1Item6;

  private ACListItem provideDay1Item7;

  private ACComboBox provideDay2;

  private ACComboBoxModelAdapter provideDay2Model;

  private ACListItem provideDay2Item1;

  private ACListItem provideDay2Item2;

  private ACListItem provideDay2Item3;

  private ACListItem provideDay2Item4;

  private ACListItem provideDay2Item5;

  private ACListItem provideDay2Item6;

  private ACListItem provideDay2Item7;

  private ACComboBox provideDay3;

  private ACComboBoxModelAdapter provideDay3Model;

  private ACListItem provideDay3Item1;

  private ACListItem provideDay3Item2;

  private ACListItem provideDay3Item3;

  private ACListItem provideDay3Item4;

  private ACListItem provideDay3Item5;

  private ACListItem provideDay3Item6;

  private ACListItem provideDay3Item7;

  private ACComboBox provideDay4;

  private ACComboBoxModelAdapter provideDay4Model;

  private ACListItem provideDay4item1;

  private ACListItem provideDay4item2;

  private ACListItem provideDay4item3;

  private ACListItem provideDay4item4;

  private ACListItem provideDay4item5;

  private ACListItem provideDay4item6;

  private ACListItem provideDay4Item7;

  private ACComboBox provideDay5;

  private ACComboBoxModelAdapter provideDay5Model;

  private ACListItem provideDay5Item1;

  private ACListItem provideDay5Item2;

  private ACListItem provideDay5Item3;

  private ACListItem provideDay5Item4;

  private ACListItem provideDay5Item5;

  private ACListItem provideDay5Item6;

  private ACListItem provideDay5Item7;

  private ACComboBox provideDay6;

  private ACComboBoxModelAdapter provideDay6Model;

  private ACListItem provideDay6Item1;

  private ACListItem provideDay6Item2;

  private ACListItem provideDay6Item3;

  private ACListItem provideDay6Item4;

  private ACListItem provideDay6Item5;

  private ACListItem provideDay6Item6;

  private ACListItem provideDay6Item7;

  private ACComboBox provideDay7;

  private ACComboBoxModelAdapter provideDay7Model;

  private ACListItem provideDay7Item1;

  private ACListItem provideDay7Item2;

  private ACListItem provideDay7Item3;

  private ACListItem provideDay7Item4;

  private ACListItem provideDay7Item5;

  private ACListItem provideDay7Item6;

  private ACListItem provideDay7Item7;

  private ACComboBox provideDay8;

  private ACComboBoxModelAdapter provideDay8Model;

  private ACListItem provideDay8Item1;

  private ACListItem provideDay8Item2;

  private ACListItem provideDay8Item3;

  private ACListItem provideDay8Item4;

  private ACListItem provideDay8Item5;

  private ACListItem provideDay8Item6;

  private ACListItem provideDay8Item7;

  private ACComboBox provideDay9;

  private ACComboBoxModelAdapter provideDay9Model;

  private ACListItem provideDay9Item1;

  private ACListItem provideDay9Item2;

  private ACListItem provideDay9Item3;

  private ACListItem provideDay9Item4;

  private ACListItem provideDay9Item5;

  private ACListItem provideDay9Item6;

  private ACListItem provideDay9Item7;

  private ACComboBox provideDay10;

  private ACComboBoxModelAdapter provideDay10Model;

  private ACListItem provideDay10Item1;

  private ACListItem provideDay10Item2;

  private ACListItem provideDay10Item3;

  private ACListItem provideDay10Item4;

  private ACListItem provideDay10Item5;

  private ACListItem provideDay10Item6;

  private ACListItem provideDay10Item7;

  private ACComboBox provideDay11;

  private ACComboBoxModelAdapter provideDay11Model;

  private ACListItem provideDay11Item1;

  private ACListItem provideDay11Item2;

  private ACListItem provideDay11Item3;

  private ACListItem provideDay11Item4;

  private ACListItem provideDay11Item5;

  private ACListItem provideDay11Item6;

  private ACListItem provideDay11Item7;

  private ACComboBox provideDay12;

  private ACComboBoxModelAdapter provideDay12Model;

  private ACListItem provideDay12Item1;

  private ACListItem provideDay12Item2;

  private ACListItem provideDay12Item3;

  private ACListItem provideDay12Item4;

  private ACListItem provideDay12Item5;

  private ACListItem provideDay12Item6;

  private ACListItem provideDay12Item7;

  private ACComboBox provideDay13;

  private ACComboBoxModelAdapter provideDay13Model;

  private ACListItem provideDay13Item1;

  private ACListItem provideDay13Item2;

  private ACListItem provideDay13Item3;

  private ACListItem provideDay13Item4;

  private ACListItem provideDay13Item5;

  private ACListItem provideDay13Item6;

  private ACListItem provideDay13Item7;

  private ACComboBox provideDay14;

  private ACComboBoxModelAdapter provideDay14Model;

  private ACListItem provideDay14Item1;

  private ACListItem provideDay14Item2;

  private ACListItem provideDay14Item3;

  private ACListItem provideDay14Item4;

  private ACListItem provideDay14Item5;

  private ACListItem provideDay14Item6;

  private ACListItem provideDay14Item7;

  private ACComboBox provideDay15;

  private ACComboBoxModelAdapter provideDay15Model;

  private ACListItem provideDay15Item1;

  private ACListItem provideDay15Item2;

  private ACListItem provideDay15Item3;

  private ACListItem provideDay15Item4;

  private ACListItem provideDay15Item5;

  private ACListItem provideDay15Item6;

  private ACListItem provideDay15Item7;

  private ACComboBox provideDay16;

  private ACComboBoxModelAdapter provideDay16Model;

  private ACListItem provideDay16Item1;

  private ACListItem provideDay16Item2;

  private ACListItem provideDay16Item3;

  private ACListItem provideDay16Item4;

  private ACListItem provideDay16Item5;

  private ACListItem provideDay16Item6;

  private ACListItem provideDay16Item7;

  private ACComboBox provideDay17;

  private ACComboBoxModelAdapter provideDay17Model;

  private ACListItem provideDay17Item1;

  private ACListItem provideDay17Item2;

  private ACListItem provideDay17Item3;

  private ACListItem provideDay17Item4;

  private ACListItem provideDay17Item5;

  private ACListItem provideDay17Item6;

  private ACListItem provideDay17Item7;

  private ACComboBox provideDay18;

  private ACComboBoxModelAdapter provideDay18Model;

  private ACListItem provideDay18Item1;

  private ACListItem provideDay18Item2;

  private ACListItem provideDay18Item3;

  private ACListItem provideDay18Item4;

  private ACListItem provideDay18Item5;

  private ACListItem provideDay18Item6;

  private ACListItem provideDay18Item7;

  private ACComboBox provideDay19;

  private ACComboBoxModelAdapter provideDay19Model;

  private ACListItem provideDay19Item1;

  private ACListItem provideDay19Item2;

  private ACListItem provideDay19Item3;

  private ACListItem provideDay19Item4;

  private ACListItem provideDay19Item5;

  private ACListItem provideDay19Item6;

  private ACListItem provideDay19Item7;

  private ACComboBox provideDay20;

  private ACComboBoxModelAdapter provideDay20Model;

  private ACListItem provideDay20Item1;

  private ACListItem provideDay20Item2;

  private ACListItem provideDay20Item3;

  private ACListItem provideDay20Item4;

  private ACListItem provideDay20Item5;

  private ACListItem provideDay20Item6;

  private ACListItem provideDay20Item7;

  private ACComboBox provideDay21;

  private ACComboBoxModelAdapter provideDay21Model;

  private ACListItem provideDay21Item1;

  private ACListItem provideDay21Item2;

  private ACListItem provideDay21Item3;

  private ACListItem provideDay21Item4;

  private ACListItem provideDay21Item5;

  private ACListItem provideDay21Item6;

  private ACListItem provideDay21Item7;

  private ACComboBox provideDay22;

  private ACComboBoxModelAdapter provideDay22Model;

  private ACListItem provideDay22Item1;

  private ACListItem provideDay22Item2;

  private ACListItem provideDay22Item3;

  private ACListItem provideDay22Item4;

  private ACListItem provideDay22Item5;

  private ACListItem provideDay22Item6;

  private ACListItem provideDay22Item7;

  private ACComboBox provideDay23;

  private ACComboBoxModelAdapter provideDay23Model;

  private ACListItem provideDay23Item1;

  private ACListItem provideDay23Item2;

  private ACListItem provideDay23Item3;

  private ACListItem provideDay23Item4;

  private ACListItem provideDay23Item5;

  private ACListItem provideDay23Item6;

  private ACListItem provideDay23Item7;

  private ACComboBox provideDay24;

  private ACComboBoxModelAdapter provideDay24Model;

  private ACListItem provideDay24Item1;

  private ACListItem provideDay24Item2;

  private ACListItem provideDay24Item3;

  private ACListItem provideDay24Item4;

  private ACListItem provideDay24Item5;

  private ACListItem provideDay24Item6;

  private ACListItem provideDay24Item7;

  private ACComboBox provideDay25;

  private ACComboBoxModelAdapter provideDay25Model;

  private ACListItem provideDay25Item1;

  private ACListItem provideDay25Item2;

  private ACListItem provideDay25Item3;

  private ACListItem provideDay25Item4;

  private ACListItem provideDay25Item5;

  private ACListItem provideDay25Item6;

  private ACListItem provideDay25Item7;

  private ACComboBox provideDay26;

  private ACComboBoxModelAdapter provideDay26Model;

  private ACListItem provideDay26Item1;

  private ACListItem provideDay26Item2;

  private ACListItem provideDay26Item3;

  private ACListItem provideDay26Item4;

  private ACListItem provideDay26Item5;

  private ACListItem provideDay26Item6;

  private ACListItem provideDay26Item7;

  private ACComboBox provideDay27;

  private ACComboBoxModelAdapter provideDay27Model;

  private ACListItem provideDay27Item1;

  private ACListItem provideDay27Item2;

  private ACListItem provideDay27Item3;

  private ACListItem provideDay27Item4;

  private ACListItem provideDay27Item5;

  private ACListItem provideDay27Item6;

  private ACListItem provideDay27Item7;

  private ACComboBox provideDay28;

  private ACComboBoxModelAdapter provideDay28Model;

  private ACListItem provideDay28Item1;

  private ACListItem provideDay28Item2;

  private ACListItem provideDay28Item3;

  private ACListItem provideDay28Item4;

  private ACListItem provideDay28Item5;

  private ACListItem provideDay28Item6;

  private ACListItem provideDay28Item7;

  private ACComboBox provideDay29;

  private ACComboBoxModelAdapter provideDay29Model;

  private ACListItem provideDay29Item1;

  private ACListItem provideDay29Item2;

  private ACListItem provideDay29Item3;

  private ACListItem provideDay29Item4;

  private ACListItem provideDay29Item5;

  private ACListItem provideDay29Item6;

  private ACListItem provideDay29Item7;

  private ACComboBox provideDay30;

  private ACComboBoxModelAdapter provideDay30Model;

  private ACListItem provideDay30Item1;

  private ACListItem provideDay30Item2;

  private ACListItem provideDay30Item3;

  private ACListItem provideDay30Item4;

  private ACListItem provideDay30Item5;

  private ACListItem provideDay30Item6;

  private ACListItem provideDay30Item7;

  private ACComboBox provideDay31;

  private ACComboBoxModelAdapter provideDay31Model;

  private ACListItem provideDay31Item1;

  private ACListItem provideDay31Item2;

  private ACListItem provideDay31Item3;

  private ACListItem provideDay31Item4;

  private ACListItem provideDay31Item5;

  private ACListItem provideDay31Item6;

  private ACListItem provideDay31Item7;

  private ACGroupBox noteContents;

  private ACTextArea note;

  private ACGroupBox totalContents;

  private ACPanel totalTitleContents;

  private ACTextField totalSpace;

  private ACTextField totalInsurerTitle;

  private ACTextField totalUserTitle;

  private ACPanel totalNoTaxContents;

  private ACTextField totalNoTaxTitle;

  private ACTextField totalNoTaxByInsurer;

  private ACTextField totalNoTaxByPatient;

  private ACPanel totalInTaxContents;

  private ACTextField totalInTaxTitle;

  private ACTextField totalInTaxByInsurer;

  private ACTextField totalInTaxByPatient;

  private ACPanel totalFullContents;

  private ACTextField totalFullTitle;

  private ACTextField totalFull;

  //getter

  /**
   * ボタンバーを取得します。
   * @return ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("訪問看護療養費領収書編集");

      addButtons();
    }
    return buttons;

  }

  /**
   * 実績読み込みを取得します。
   * @return 実績読み込み
   */
  public ACAffairButton getOpen(){
    if(open==null){

      open = new ACAffairButton();

      open.setText("実績読込(O)");

      open.setToolTipText("請求期間の実績を取り込みます。");

      open.setMnemonic('O');

      open.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpen();
    }
    return open;

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
   * 印刷を取得します。
   * @return 印刷
   */
  public ACAffairButton getPrint(){
    if(print==null){

      print = new ACAffairButton();

      print.setText("印刷(P)");

      print.setToolTipText("印刷します。");

      print.setMnemonic('P');

      print.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrint();
    }
    return print;

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
   * 基本項目領域を取得します。
   * @return 基本項目領域
   */
  public ACPanel getMainItemContents(){
    if(mainItemContents==null){

      mainItemContents = new ACPanel();

      addMainItemContents();
    }
    return mainItemContents;

  }

  /**
   * 基本情報領域を取得します。
   * @return 基本情報領域
   */
  public ACGroupBox getBasicContents(){
    if(basicContents==null){

      basicContents = new ACGroupBox();

      basicContents.setText("基本情報");

      addBasicContents();
    }
    return basicContents;

  }

  /**
   * 領収書No.を取得します。
   * @return 領収書No.
   */
  public ACTextField getBillNo(){
    if(billNo==null){

      billNo = new ACTextField();

      getBillNoContainer().setText("領収書No.");

      billNo.setBindPath("BILL_NO");

      billNo.setEditable(false);

      billNo.setColumns(9);

      addBillNo();
    }
    return billNo;

  }

  /**
   * 領収書No.コンテナを取得します。
   * @return 領収書No.コンテナ
   */
  protected ACLabelContainer getBillNoContainer(){
    if(billNoContainer==null){
      billNoContainer = new ACLabelContainer();
      billNoContainer.setFollowChildEnabled(true);
      billNoContainer.setVAlignment(VRLayout.CENTER);
      billNoContainer.add(getBillNo(), null);
    }
    return billNoContainer;
  }

  /**
   * 患者番号を取得します。
   * @return 患者番号
   */
  public ACTextField getPatientCode(){
    if(patientCode==null){

      patientCode = new ACTextField();

      getPatientCodeContainer().setText("患者番号");

      patientCode.setBindPath("BILL_PATIENT_CODE");

      patientCode.setColumns(15);

      patientCode.setCharType(new VRCharType("ONLY_ALNUMPUNCT", "^[0-9A-Za-z\\u0020-\\u002f\\u003a-\\u0040\\u005b-\\u0060\\u007b-\\u007e]*$"));

      patientCode.setIMEMode(InputSubset.LATIN);

      patientCode.setMaxLength(15);

      addPatientCode();
    }
    return patientCode;

  }

  /**
   * 患者番号コンテナを取得します。
   * @return 患者番号コンテナ
   */
  protected ACLabelContainer getPatientCodeContainer(){
    if(patientCodeContainer==null){
      patientCodeContainer = new ACLabelContainer();
      patientCodeContainer.setFollowChildEnabled(true);
      patientCodeContainer.setVAlignment(VRLayout.CENTER);
      patientCodeContainer.add(getPatientCode(), null);
    }
    return patientCodeContainer;
  }

  /**
   * 氏名を取得します。
   * @return 氏名
   */
  public ACTextField getPatientName(){
    if(patientName==null){

      patientName = new ACTextField();

      getPatientNameContainer().setText("氏名");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setEditable(false);

      patientName.setColumns(32);

      addPatientName();
    }
    return patientName;

  }

  /**
   * 氏名コンテナを取得します。
   * @return 氏名コンテナ
   */
  protected ACLabelContainer getPatientNameContainer(){
    if(patientNameContainer==null){
      patientNameContainer = new ACLabelContainer();
      patientNameContainer.setFollowChildEnabled(true);
      patientNameContainer.setVAlignment(VRLayout.CENTER);
      patientNameContainer.add(getPatientName(), null);
    }
    return patientNameContainer;
  }

  /**
   * 項目領域を取得します。
   * @return 項目領域
   */
  public ACPanel getItemContents(){
    if(itemContents==null){

      itemContents = new ACPanel();

      addItemContents();
    }
    return itemContents;

  }

  /**
   * 項目タブを取得します。
   * @return 項目タブ
   */
  public JTabbedPane getItemTabs(){
    if(itemTabs==null){

      itemTabs = new JTabbedPane();

      addItemTabs();
    }
    return itemTabs;

  }

  /**
   * 保険適用負担領域を取得します。
   * @return 保険適用負担領域
   */
  public ACPanel getByInsurerContents(){
    if(byInsurerContents==null){

      byInsurerContents = new ACPanel();

      addByInsurerContents();
    }
    return byInsurerContents;

  }

  /**
   * 保険負担分タイトルを取得します。
   * @return 保険負担分タイトル
   */
  public ACPanel getByInsurerTitle(){
    if(byInsurerTitle==null){

      byInsurerTitle = new ACPanel();

      byInsurerTitle.setAutoWrap(false);

      byInsurerTitle.setHgap(0);

      byInsurerTitle.setVgap(0);

      addByInsurerTitle();
    }
    return byInsurerTitle;

  }

  /**
   * 保険負担分項目タイトルを取得します。
   * @return 保険負担分項目タイトル
   */
  public ACTextField getByInsurerNameTitle(){
    if(byInsurerNameTitle==null){

      byInsurerNameTitle = new ACTextField();

      byInsurerNameTitle.setText("保険負担分項目");

      byInsurerNameTitle.setEditable(false);

      byInsurerNameTitle.setColumns(10);

      addByInsurerNameTitle();
    }
    return byInsurerNameTitle;

  }

  /**
   * 保険負担分単価タイトルを取得します。
   * @return 保険負担分単価タイトル
   */
  public ACTextField getByInsurerPriceTitle(){
    if(byInsurerPriceTitle==null){

      byInsurerPriceTitle = new ACTextField();

      byInsurerPriceTitle.setText("単価");

      byInsurerPriceTitle.setEditable(false);

      byInsurerPriceTitle.setColumns(3);

      addByInsurerPriceTitle();
    }
    return byInsurerPriceTitle;

  }

  /**
   * 保険負担分数量タイトルを取得します。
   * @return 保険負担分数量タイトル
   */
  public ACTextField getByInsurerNumberTitle(){
    if(byInsurerNumberTitle==null){

      byInsurerNumberTitle = new ACTextField();

      byInsurerNumberTitle.setText("数量");

      byInsurerNumberTitle.setEditable(false);

      byInsurerNumberTitle.setColumns(2);

      addByInsurerNumberTitle();
    }
    return byInsurerNumberTitle;

  }

  /**
   * 保険負担分金額タイトルを取得します。
   * @return 保険負担分金額タイトル
   */
  public ACTextField getByInsurerSumTitle(){
    if(byInsurerSumTitle==null){

      byInsurerSumTitle = new ACTextField();

      byInsurerSumTitle.setText("金額");

      byInsurerSumTitle.setEditable(false);

      byInsurerSumTitle.setColumns(5);

      addByInsurerSumTitle();
    }
    return byInsurerSumTitle;

  }

  /**
   * 保険負担分1行目を取得します。
   * @return 保険負担分1行目
   */
  public ACPanel getByInsurer1(){
    if(byInsurer1==null){

      byInsurer1 = new ACPanel();

      byInsurer1.setAutoWrap(false);

      byInsurer1.setHgap(0);

      byInsurer1.setVgap(0);

      addByInsurer1();
    }
    return byInsurer1;

  }

  /**
   * 保険負担分項目1行目を取得します。
   * @return 保険負担分項目1行目
   */
  public ACComboBox getByInsurerName1(){
    if(byInsurerName1==null){

      byInsurerName1 = new ACComboBox();

      byInsurerName1.setBindPath("BY_INSURER_NAME1");

      byInsurerName1.setColumns(10);

      byInsurerName1.setModelBindPath("BY_INSURER_NAME");

      byInsurerName1.setIMEMode(InputSubset.KANJI);

      byInsurerName1.setMaxLength(20);

      byInsurerName1.setMaxColumns(10);

      byInsurerName1.setModel(getByInsurerName1Model());

      addByInsurerName1();
    }
    return byInsurerName1;

  }

  /**
   * 保険負担分項目1行目モデルを取得します。
   * @return 保険負担分項目1行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName1Model(){
    if(byInsurerName1Model==null){
      byInsurerName1Model = new ACComboBoxModelAdapter();
      addByInsurerName1Model();
    }
    return byInsurerName1Model;
  }

  /**
   * 保険負担分単価1行目を取得します。
   * @return 保険負担分単価1行目
   */
  public ACTextField getByInsurerPrice1(){
    if(byInsurerPrice1==null){

      byInsurerPrice1 = new ACTextField();

      byInsurerPrice1.setBindPath("BY_INSURER_PRICE1");

      byInsurerPrice1.setColumns(3);

      byInsurerPrice1.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice1.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice1.setIMEMode(InputSubset.LATIN);

      byInsurerPrice1.setMaxLength(5);

      addByInsurerPrice1();
    }
    return byInsurerPrice1;

  }

  /**
   * 保険負担分数量1行目を取得します。
   * @return 保険負担分数量1行目
   */
  public ACTextField getByInsurerNumber1(){
    if(byInsurerNumber1==null){

      byInsurerNumber1 = new ACTextField();

      byInsurerNumber1.setBindPath("BY_INSURER_NUMBER1");

      byInsurerNumber1.setColumns(2);

      byInsurerNumber1.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber1.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber1.setIMEMode(InputSubset.LATIN);

      byInsurerNumber1.setMaxLength(3);

      addByInsurerNumber1();
    }
    return byInsurerNumber1;

  }

  /**
   * 保険負担分金額1行目を取得します。
   * @return 保険負担分金額1行目
   */
  public ACTextField getByInsurerSum1(){
    if(byInsurerSum1==null){

      byInsurerSum1 = new ACTextField();

      byInsurerSum1.setBindPath("BY_INSURER_SUM1");

      byInsurerSum1.setColumns(5);

      byInsurerSum1.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum1.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum1.setIMEMode(InputSubset.LATIN);

      byInsurerSum1.setMaxLength(8);

      addByInsurerSum1();
    }
    return byInsurerSum1;

  }

  /**
   * 保険負担分2行目を取得します。
   * @return 保険負担分2行目
   */
  public ACPanel getByInsurer2(){
    if(byInsurer2==null){

      byInsurer2 = new ACPanel();

      byInsurer2.setAutoWrap(false);

      byInsurer2.setHgap(0);

      byInsurer2.setVgap(0);

      addByInsurer2();
    }
    return byInsurer2;

  }

  /**
   * 保険負担分項目2行目を取得します。
   * @return 保険負担分項目2行目
   */
  public ACComboBox getByInsurerName2(){
    if(byInsurerName2==null){

      byInsurerName2 = new ACComboBox();

      byInsurerName2.setBindPath("BY_INSURER_NAME2");

      byInsurerName2.setColumns(10);

      byInsurerName2.setModelBindPath("BY_INSURER_NAME");

      byInsurerName2.setIMEMode(InputSubset.KANJI);

      byInsurerName2.setMaxLength(20);

      byInsurerName2.setMaxColumns(10);

      byInsurerName2.setModel(getByInsurerName2Model());

      addByInsurerName2();
    }
    return byInsurerName2;

  }

  /**
   * 保険負担分項目2行目モデルを取得します。
   * @return 保険負担分項目2行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName2Model(){
    if(byInsurerName2Model==null){
      byInsurerName2Model = new ACComboBoxModelAdapter();
      addByInsurerName2Model();
    }
    return byInsurerName2Model;
  }

  /**
   * 保険負担分単価2行目を取得します。
   * @return 保険負担分単価2行目
   */
  public ACTextField getByInsurerPrice2(){
    if(byInsurerPrice2==null){

      byInsurerPrice2 = new ACTextField();

      byInsurerPrice2.setBindPath("BY_INSURER_PRICE2");

      byInsurerPrice2.setColumns(3);

      byInsurerPrice2.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice2.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice2.setIMEMode(InputSubset.LATIN);

      byInsurerPrice2.setMaxLength(5);

      addByInsurerPrice2();
    }
    return byInsurerPrice2;

  }

  /**
   * 保険負担分数量2行目を取得します。
   * @return 保険負担分数量2行目
   */
  public ACTextField getByInsurerNumber2(){
    if(byInsurerNumber2==null){

      byInsurerNumber2 = new ACTextField();

      byInsurerNumber2.setBindPath("BY_INSURER_NUMBER2");

      byInsurerNumber2.setColumns(2);

      byInsurerNumber2.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber2.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber2.setIMEMode(InputSubset.LATIN);

      byInsurerNumber2.setMaxLength(3);

      addByInsurerNumber2();
    }
    return byInsurerNumber2;

  }

  /**
   * 保険負担分金額2行目を取得します。
   * @return 保険負担分金額2行目
   */
  public ACTextField getByInsurerSum2(){
    if(byInsurerSum2==null){

      byInsurerSum2 = new ACTextField();

      byInsurerSum2.setBindPath("BY_INSURER_SUM2");

      byInsurerSum2.setColumns(5);

      byInsurerSum2.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum2.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum2.setIMEMode(InputSubset.LATIN);

      byInsurerSum2.setMaxLength(8);

      addByInsurerSum2();
    }
    return byInsurerSum2;

  }

  /**
   * 保険負担分3行目を取得します。
   * @return 保険負担分3行目
   */
  public ACPanel getByInsurer3(){
    if(byInsurer3==null){

      byInsurer3 = new ACPanel();

      byInsurer3.setAutoWrap(false);

      byInsurer3.setHgap(0);

      byInsurer3.setVgap(0);

      addByInsurer3();
    }
    return byInsurer3;

  }

  /**
   * 保険負担分項目3行目を取得します。
   * @return 保険負担分項目3行目
   */
  public ACComboBox getByInsurerName3(){
    if(byInsurerName3==null){

      byInsurerName3 = new ACComboBox();

      byInsurerName3.setBindPath("BY_INSURER_NAME3");

      byInsurerName3.setColumns(10);

      byInsurerName3.setModelBindPath("BY_INSURER_NAME");

      byInsurerName3.setIMEMode(InputSubset.KANJI);

      byInsurerName3.setMaxLength(20);

      byInsurerName3.setMaxColumns(10);

      byInsurerName3.setModel(getByInsurerName3Model());

      addByInsurerName3();
    }
    return byInsurerName3;

  }

  /**
   * 保険負担分項目3行目モデルを取得します。
   * @return 保険負担分項目3行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName3Model(){
    if(byInsurerName3Model==null){
      byInsurerName3Model = new ACComboBoxModelAdapter();
      addByInsurerName3Model();
    }
    return byInsurerName3Model;
  }

  /**
   * 保険負担分単価3行目を取得します。
   * @return 保険負担分単価3行目
   */
  public ACTextField getByInsurerPrice3(){
    if(byInsurerPrice3==null){

      byInsurerPrice3 = new ACTextField();

      byInsurerPrice3.setBindPath("BY_INSURER_PRICE3");

      byInsurerPrice3.setColumns(3);

      byInsurerPrice3.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice3.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice3.setIMEMode(InputSubset.LATIN);

      byInsurerPrice3.setMaxLength(5);

      addByInsurerPrice3();
    }
    return byInsurerPrice3;

  }

  /**
   * 保険負担分数量3行目を取得します。
   * @return 保険負担分数量3行目
   */
  public ACTextField getByInsurerNumber3(){
    if(byInsurerNumber3==null){

      byInsurerNumber3 = new ACTextField();

      byInsurerNumber3.setBindPath("BY_INSURER_NUMBER3");

      byInsurerNumber3.setColumns(2);

      byInsurerNumber3.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber3.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber3.setIMEMode(InputSubset.LATIN);

      byInsurerNumber3.setMaxLength(3);

      addByInsurerNumber3();
    }
    return byInsurerNumber3;

  }

  /**
   * 保険負担分金額3行目を取得します。
   * @return 保険負担分金額3行目
   */
  public ACTextField getByInsurerSum3(){
    if(byInsurerSum3==null){

      byInsurerSum3 = new ACTextField();

      byInsurerSum3.setBindPath("BY_INSURER_SUM3");

      byInsurerSum3.setColumns(5);

      byInsurerSum3.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum3.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum3.setIMEMode(InputSubset.LATIN);

      byInsurerSum3.setMaxLength(8);

      addByInsurerSum3();
    }
    return byInsurerSum3;

  }

  /**
   * 保険負担分4行目を取得します。
   * @return 保険負担分4行目
   */
  public ACPanel getByInsurer4(){
    if(byInsurer4==null){

      byInsurer4 = new ACPanel();

      byInsurer4.setAutoWrap(false);

      byInsurer4.setHgap(0);

      byInsurer4.setVgap(0);

      addByInsurer4();
    }
    return byInsurer4;

  }

  /**
   * 保険負担分項目4行目を取得します。
   * @return 保険負担分項目4行目
   */
  public ACComboBox getByInsurerName4(){
    if(byInsurerName4==null){

      byInsurerName4 = new ACComboBox();

      byInsurerName4.setBindPath("BY_INSURER_NAME4");

      byInsurerName4.setColumns(10);

      byInsurerName4.setModelBindPath("BY_INSURER_NAME");

      byInsurerName4.setIMEMode(InputSubset.KANJI);

      byInsurerName4.setMaxLength(20);

      byInsurerName4.setMaxColumns(10);

      byInsurerName4.setModel(getByInsurerName4Model());

      addByInsurerName4();
    }
    return byInsurerName4;

  }

  /**
   * 保険負担分項目4行目モデルを取得します。
   * @return 保険負担分項目4行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName4Model(){
    if(byInsurerName4Model==null){
      byInsurerName4Model = new ACComboBoxModelAdapter();
      addByInsurerName4Model();
    }
    return byInsurerName4Model;
  }

  /**
   * 保険負担分単価4行目を取得します。
   * @return 保険負担分単価4行目
   */
  public ACTextField getByInsurerPrice4(){
    if(byInsurerPrice4==null){

      byInsurerPrice4 = new ACTextField();

      byInsurerPrice4.setBindPath("BY_INSURER_PRICE4");

      byInsurerPrice4.setColumns(3);

      byInsurerPrice4.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice4.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice4.setIMEMode(InputSubset.LATIN);

      byInsurerPrice4.setMaxLength(5);

      addByInsurerPrice4();
    }
    return byInsurerPrice4;

  }

  /**
   * 保険負担分数量4行目を取得します。
   * @return 保険負担分数量4行目
   */
  public ACTextField getByInsurerNumber4(){
    if(byInsurerNumber4==null){

      byInsurerNumber4 = new ACTextField();

      byInsurerNumber4.setBindPath("BY_INSURER_NUMBER4");

      byInsurerNumber4.setColumns(2);

      byInsurerNumber4.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber4.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber4.setIMEMode(InputSubset.LATIN);

      byInsurerNumber4.setMaxLength(3);

      addByInsurerNumber4();
    }
    return byInsurerNumber4;

  }

  /**
   * 保険負担分金額4行目を取得します。
   * @return 保険負担分金額4行目
   */
  public ACTextField getByInsurerSum4(){
    if(byInsurerSum4==null){

      byInsurerSum4 = new ACTextField();

      byInsurerSum4.setBindPath("BY_INSURER_SUM4");

      byInsurerSum4.setColumns(5);

      byInsurerSum4.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum4.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum4.setIMEMode(InputSubset.LATIN);

      byInsurerSum4.setMaxLength(8);

      addByInsurerSum4();
    }
    return byInsurerSum4;

  }

  /**
   * 保険負担分5行目を取得します。
   * @return 保険負担分5行目
   */
  public ACPanel getByInsurer5(){
    if(byInsurer5==null){

      byInsurer5 = new ACPanel();

      byInsurer5.setAutoWrap(false);

      byInsurer5.setHgap(0);

      byInsurer5.setVgap(0);

      addByInsurer5();
    }
    return byInsurer5;

  }

  /**
   * 保険負担分項目5行目を取得します。
   * @return 保険負担分項目5行目
   */
  public ACComboBox getByInsurerName5(){
    if(byInsurerName5==null){

      byInsurerName5 = new ACComboBox();

      byInsurerName5.setBindPath("BY_INSURER_NAME5");

      byInsurerName5.setColumns(10);

      byInsurerName5.setModelBindPath("BY_INSURER_NAME");

      byInsurerName5.setIMEMode(InputSubset.KANJI);

      byInsurerName5.setMaxLength(20);

      byInsurerName5.setMaxColumns(10);

      byInsurerName5.setModel(getByInsurerName5Model());

      addByInsurerName5();
    }
    return byInsurerName5;

  }

  /**
   * 保険負担分項目5行目モデルを取得します。
   * @return 保険負担分項目5行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName5Model(){
    if(byInsurerName5Model==null){
      byInsurerName5Model = new ACComboBoxModelAdapter();
      addByInsurerName5Model();
    }
    return byInsurerName5Model;
  }

  /**
   * 保険負担分単価5行目を取得します。
   * @return 保険負担分単価5行目
   */
  public ACTextField getByInsurerPrice5(){
    if(byInsurerPrice5==null){

      byInsurerPrice5 = new ACTextField();

      byInsurerPrice5.setBindPath("BY_INSURER_PRICE5");

      byInsurerPrice5.setColumns(3);

      byInsurerPrice5.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice5.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice5.setIMEMode(InputSubset.LATIN);

      byInsurerPrice5.setMaxLength(5);

      addByInsurerPrice5();
    }
    return byInsurerPrice5;

  }

  /**
   * 保険負担分数量5行目を取得します。
   * @return 保険負担分数量5行目
   */
  public ACTextField getByInsurerNumber5(){
    if(byInsurerNumber5==null){

      byInsurerNumber5 = new ACTextField();

      byInsurerNumber5.setBindPath("BY_INSURER_NUMBER5");

      byInsurerNumber5.setColumns(2);

      byInsurerNumber5.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber5.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber5.setIMEMode(InputSubset.LATIN);

      byInsurerNumber5.setMaxLength(3);

      addByInsurerNumber5();
    }
    return byInsurerNumber5;

  }

  /**
   * 保険負担分金額5行目を取得します。
   * @return 保険負担分金額5行目
   */
  public ACTextField getByInsurerSum5(){
    if(byInsurerSum5==null){

      byInsurerSum5 = new ACTextField();

      byInsurerSum5.setBindPath("BY_INSURER_SUM5");

      byInsurerSum5.setColumns(5);

      byInsurerSum5.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum5.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum5.setIMEMode(InputSubset.LATIN);

      byInsurerSum5.setMaxLength(8);

      addByInsurerSum5();
    }
    return byInsurerSum5;

  }

  /**
   * 保険負担分6行目を取得します。
   * @return 保険負担分6行目
   */
  public ACPanel getByInsurer6(){
    if(byInsurer6==null){

      byInsurer6 = new ACPanel();

      byInsurer6.setAutoWrap(false);

      byInsurer6.setHgap(0);

      byInsurer6.setVgap(0);

      addByInsurer6();
    }
    return byInsurer6;

  }

  /**
   * 保険負担分項目6行目を取得します。
   * @return 保険負担分項目6行目
   */
  public ACComboBox getByInsurerName6(){
    if(byInsurerName6==null){

      byInsurerName6 = new ACComboBox();

      byInsurerName6.setBindPath("BY_INSURER_NAME6");

      byInsurerName6.setColumns(10);

      byInsurerName6.setModelBindPath("BY_INSURER_NAME");

      byInsurerName6.setIMEMode(InputSubset.KANJI);

      byInsurerName6.setMaxLength(20);

      byInsurerName6.setMaxColumns(10);

      byInsurerName6.setModel(getByInsurerName6Model());

      addByInsurerName6();
    }
    return byInsurerName6;

  }

  /**
   * 保険負担分項目6行目モデルを取得します。
   * @return 保険負担分項目6行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName6Model(){
    if(byInsurerName6Model==null){
      byInsurerName6Model = new ACComboBoxModelAdapter();
      addByInsurerName6Model();
    }
    return byInsurerName6Model;
  }

  /**
   * 保険負担分単価6行目を取得します。
   * @return 保険負担分単価6行目
   */
  public ACTextField getByInsurerPrice6(){
    if(byInsurerPrice6==null){

      byInsurerPrice6 = new ACTextField();

      byInsurerPrice6.setBindPath("BY_INSURER_PRICE6");

      byInsurerPrice6.setColumns(3);

      byInsurerPrice6.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice6.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice6.setIMEMode(InputSubset.LATIN);

      byInsurerPrice6.setMaxLength(5);

      addByInsurerPrice6();
    }
    return byInsurerPrice6;

  }

  /**
   * 保険負担分数量6行目を取得します。
   * @return 保険負担分数量6行目
   */
  public ACTextField getByInsurerNumber6(){
    if(byInsurerNumber6==null){

      byInsurerNumber6 = new ACTextField();

      byInsurerNumber6.setBindPath("BY_INSURER_NUMBER6");

      byInsurerNumber6.setColumns(2);

      byInsurerNumber6.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber6.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber6.setIMEMode(InputSubset.LATIN);

      byInsurerNumber6.setMaxLength(3);

      addByInsurerNumber6();
    }
    return byInsurerNumber6;

  }

  /**
   * 保険負担分金額6行目を取得します。
   * @return 保険負担分金額6行目
   */
  public ACTextField getByInsurerSum6(){
    if(byInsurerSum6==null){

      byInsurerSum6 = new ACTextField();

      byInsurerSum6.setBindPath("BY_INSURER_SUM6");

      byInsurerSum6.setColumns(5);

      byInsurerSum6.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum6.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum6.setIMEMode(InputSubset.LATIN);

      byInsurerSum6.setMaxLength(8);

      addByInsurerSum6();
    }
    return byInsurerSum6;

  }

  /**
   * 保険負担分7行目を取得します。
   * @return 保険負担分7行目
   */
  public ACPanel getByInsurer7(){
    if(byInsurer7==null){

      byInsurer7 = new ACPanel();

      byInsurer7.setAutoWrap(false);

      byInsurer7.setHgap(0);

      byInsurer7.setVgap(0);

      addByInsurer7();
    }
    return byInsurer7;

  }

  /**
   * 保険負担分項目7行目を取得します。
   * @return 保険負担分項目7行目
   */
  public ACComboBox getByInsurerName7(){
    if(byInsurerName7==null){

      byInsurerName7 = new ACComboBox();

      byInsurerName7.setBindPath("BY_INSURER_NAME7");

      byInsurerName7.setColumns(10);

      byInsurerName7.setModelBindPath("BY_INSURER_NAME");

      byInsurerName7.setIMEMode(InputSubset.KANJI);

      byInsurerName7.setMaxLength(20);

      byInsurerName7.setMaxColumns(10);

      byInsurerName7.setModel(getByInsurerName7Model());

      addByInsurerName7();
    }
    return byInsurerName7;

  }

  /**
   * 保険負担分項目7行目モデルを取得します。
   * @return 保険負担分項目7行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName7Model(){
    if(byInsurerName7Model==null){
      byInsurerName7Model = new ACComboBoxModelAdapter();
      addByInsurerName7Model();
    }
    return byInsurerName7Model;
  }

  /**
   * 保険負担分単価7行目を取得します。
   * @return 保険負担分単価7行目
   */
  public ACTextField getByInsurerPrice7(){
    if(byInsurerPrice7==null){

      byInsurerPrice7 = new ACTextField();

      byInsurerPrice7.setBindPath("BY_INSURER_PRICE7");

      byInsurerPrice7.setColumns(3);

      byInsurerPrice7.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice7.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice7.setIMEMode(InputSubset.LATIN);

      byInsurerPrice7.setMaxLength(5);

      addByInsurerPrice7();
    }
    return byInsurerPrice7;

  }

  /**
   * 保険負担分数量7行目を取得します。
   * @return 保険負担分数量7行目
   */
  public ACTextField getByInsurerNumber7(){
    if(byInsurerNumber7==null){

      byInsurerNumber7 = new ACTextField();

      byInsurerNumber7.setBindPath("BY_INSURER_NUMBER7");

      byInsurerNumber7.setColumns(2);

      byInsurerNumber7.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber7.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber7.setIMEMode(InputSubset.LATIN);

      byInsurerNumber7.setMaxLength(3);

      addByInsurerNumber7();
    }
    return byInsurerNumber7;

  }

  /**
   * 保険負担分金額7行目を取得します。
   * @return 保険負担分金額7行目
   */
  public ACTextField getByInsurerSum7(){
    if(byInsurerSum7==null){

      byInsurerSum7 = new ACTextField();

      byInsurerSum7.setBindPath("BY_INSURER_SUM7");

      byInsurerSum7.setColumns(5);

      byInsurerSum7.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum7.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum7.setIMEMode(InputSubset.LATIN);

      byInsurerSum7.setMaxLength(8);

      addByInsurerSum7();
    }
    return byInsurerSum7;

  }

  /**
   * 保険負担分8行目を取得します。
   * @return 保険負担分8行目
   */
  public ACPanel getByInsurer8(){
    if(byInsurer8==null){

      byInsurer8 = new ACPanel();

      byInsurer8.setAutoWrap(false);

      byInsurer8.setHgap(0);

      byInsurer8.setVgap(0);

      addByInsurer8();
    }
    return byInsurer8;

  }

  /**
   * 保険負担分項目8行目を取得します。
   * @return 保険負担分項目8行目
   */
  public ACComboBox getByInsurerName8(){
    if(byInsurerName8==null){

      byInsurerName8 = new ACComboBox();

      byInsurerName8.setBindPath("BY_INSURER_NAME8");

      byInsurerName8.setColumns(10);

      byInsurerName8.setModelBindPath("BY_INSURER_NAME");

      byInsurerName8.setIMEMode(InputSubset.KANJI);

      byInsurerName8.setMaxLength(20);

      byInsurerName8.setMaxColumns(10);

      byInsurerName8.setModel(getByInsurerName8Model());

      addByInsurerName8();
    }
    return byInsurerName8;

  }

  /**
   * 保険負担分項目8行目モデルを取得します。
   * @return 保険負担分項目8行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName8Model(){
    if(byInsurerName8Model==null){
      byInsurerName8Model = new ACComboBoxModelAdapter();
      addByInsurerName8Model();
    }
    return byInsurerName8Model;
  }

  /**
   * 保険負担分単価8行目を取得します。
   * @return 保険負担分単価8行目
   */
  public ACTextField getByInsurerPrice8(){
    if(byInsurerPrice8==null){

      byInsurerPrice8 = new ACTextField();

      byInsurerPrice8.setBindPath("BY_INSURER_PRICE8");

      byInsurerPrice8.setColumns(3);

      byInsurerPrice8.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice8.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice8.setIMEMode(InputSubset.LATIN);

      byInsurerPrice8.setMaxLength(5);

      addByInsurerPrice8();
    }
    return byInsurerPrice8;

  }

  /**
   * 保険負担分数量8行目を取得します。
   * @return 保険負担分数量8行目
   */
  public ACTextField getByInsurerNumber8(){
    if(byInsurerNumber8==null){

      byInsurerNumber8 = new ACTextField();

      byInsurerNumber8.setBindPath("BY_INSURER_NUMBER8");

      byInsurerNumber8.setColumns(2);

      byInsurerNumber8.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber8.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber8.setIMEMode(InputSubset.LATIN);

      byInsurerNumber8.setMaxLength(3);

      addByInsurerNumber8();
    }
    return byInsurerNumber8;

  }

  /**
   * 保険負担分金額8行目を取得します。
   * @return 保険負担分金額8行目
   */
  public ACTextField getByInsurerSum8(){
    if(byInsurerSum8==null){

      byInsurerSum8 = new ACTextField();

      byInsurerSum8.setBindPath("BY_INSURER_SUM8");

      byInsurerSum8.setColumns(5);

      byInsurerSum8.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum8.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum8.setIMEMode(InputSubset.LATIN);

      byInsurerSum8.setMaxLength(8);

      addByInsurerSum8();
    }
    return byInsurerSum8;

  }

  /**
   * 保険負担分9行目を取得します。
   * @return 保険負担分9行目
   */
  public ACPanel getByInsurer9(){
    if(byInsurer9==null){

      byInsurer9 = new ACPanel();

      byInsurer9.setAutoWrap(false);

      byInsurer9.setHgap(0);

      byInsurer9.setVgap(0);

      addByInsurer9();
    }
    return byInsurer9;

  }

  /**
   * 保険負担分項目9行目を取得します。
   * @return 保険負担分項目9行目
   */
  public ACComboBox getByInsurerName9(){
    if(byInsurerName9==null){

      byInsurerName9 = new ACComboBox();

      byInsurerName9.setBindPath("BY_INSURER_NAME9");

      byInsurerName9.setColumns(10);

      byInsurerName9.setModelBindPath("BY_INSURER_NAME");

      byInsurerName9.setIMEMode(InputSubset.KANJI);

      byInsurerName9.setMaxLength(20);

      byInsurerName9.setMaxColumns(10);

      byInsurerName9.setModel(getByInsurerName9Model());

      addByInsurerName9();
    }
    return byInsurerName9;

  }

  /**
   * 保険負担分項目9行目モデルを取得します。
   * @return 保険負担分項目9行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName9Model(){
    if(byInsurerName9Model==null){
      byInsurerName9Model = new ACComboBoxModelAdapter();
      addByInsurerName9Model();
    }
    return byInsurerName9Model;
  }

  /**
   * 保険負担分単価9行目を取得します。
   * @return 保険負担分単価9行目
   */
  public ACTextField getByInsurerPrice9(){
    if(byInsurerPrice9==null){

      byInsurerPrice9 = new ACTextField();

      byInsurerPrice9.setBindPath("BY_INSURER_PRICE9");

      byInsurerPrice9.setColumns(3);

      byInsurerPrice9.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice9.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice9.setIMEMode(InputSubset.LATIN);

      byInsurerPrice9.setMaxLength(5);

      addByInsurerPrice9();
    }
    return byInsurerPrice9;

  }

  /**
   * 保険負担分数量9行目を取得します。
   * @return 保険負担分数量9行目
   */
  public ACTextField getByInsurerNumber9(){
    if(byInsurerNumber9==null){

      byInsurerNumber9 = new ACTextField();

      byInsurerNumber9.setBindPath("BY_INSURER_NUMBER9");

      byInsurerNumber9.setColumns(2);

      byInsurerNumber9.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber9.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber9.setIMEMode(InputSubset.LATIN);

      byInsurerNumber9.setMaxLength(3);

      addByInsurerNumber9();
    }
    return byInsurerNumber9;

  }

  /**
   * 保険負担分金額9行目を取得します。
   * @return 保険負担分金額9行目
   */
  public ACTextField getByInsurerSum9(){
    if(byInsurerSum9==null){

      byInsurerSum9 = new ACTextField();

      byInsurerSum9.setBindPath("BY_INSURER_SUM9");

      byInsurerSum9.setColumns(5);

      byInsurerSum9.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum9.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum9.setIMEMode(InputSubset.LATIN);

      byInsurerSum9.setMaxLength(8);

      addByInsurerSum9();
    }
    return byInsurerSum9;

  }

  /**
   * 保険負担分10行目を取得します。
   * @return 保険負担分10行目
   */
  public ACPanel getByInsurer10(){
    if(byInsurer10==null){

      byInsurer10 = new ACPanel();

      byInsurer10.setAutoWrap(false);

      byInsurer10.setHgap(0);

      byInsurer10.setVgap(0);

      addByInsurer10();
    }
    return byInsurer10;

  }

  /**
   * 保険負担分項目10行目を取得します。
   * @return 保険負担分項目10行目
   */
  public ACComboBox getByInsurerName10(){
    if(byInsurerName10==null){

      byInsurerName10 = new ACComboBox();

      byInsurerName10.setBindPath("BY_INSURER_NAME10");

      byInsurerName10.setColumns(10);

      byInsurerName10.setModelBindPath("BY_INSURER_NAME");

      byInsurerName10.setIMEMode(InputSubset.KANJI);

      byInsurerName10.setMaxLength(20);

      byInsurerName10.setMaxColumns(10);

      byInsurerName10.setModel(getByInsurerName10Model());

      addByInsurerName10();
    }
    return byInsurerName10;

  }

  /**
   * 保険負担分項目10行目モデルを取得します。
   * @return 保険負担分項目10行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName10Model(){
    if(byInsurerName10Model==null){
      byInsurerName10Model = new ACComboBoxModelAdapter();
      addByInsurerName10Model();
    }
    return byInsurerName10Model;
  }

  /**
   * 保険負担分単価10行目を取得します。
   * @return 保険負担分単価10行目
   */
  public ACTextField getByInsurerPrice10(){
    if(byInsurerPrice10==null){

      byInsurerPrice10 = new ACTextField();

      byInsurerPrice10.setBindPath("BY_INSURER_PRICE10");

      byInsurerPrice10.setColumns(3);

      byInsurerPrice10.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice10.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice10.setIMEMode(InputSubset.LATIN);

      byInsurerPrice10.setMaxLength(5);

      addByInsurerPrice10();
    }
    return byInsurerPrice10;

  }

  /**
   * 保険負担分数量10行目を取得します。
   * @return 保険負担分数量10行目
   */
  public ACTextField getByInsurerNumber10(){
    if(byInsurerNumber10==null){

      byInsurerNumber10 = new ACTextField();

      byInsurerNumber10.setBindPath("BY_INSURER_NUMBER10");

      byInsurerNumber10.setColumns(2);

      byInsurerNumber10.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber10.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber10.setIMEMode(InputSubset.LATIN);

      byInsurerNumber10.setMaxLength(3);

      addByInsurerNumber10();
    }
    return byInsurerNumber10;

  }

  /**
   * 保険負担分金額10行目を取得します。
   * @return 保険負担分金額10行目
   */
  public ACTextField getByInsurerSum10(){
    if(byInsurerSum10==null){

      byInsurerSum10 = new ACTextField();

      byInsurerSum10.setBindPath("BY_INSURER_SUM10");

      byInsurerSum10.setColumns(5);

      byInsurerSum10.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum10.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum10.setIMEMode(InputSubset.LATIN);

      byInsurerSum10.setMaxLength(8);

      addByInsurerSum10();
    }
    return byInsurerSum10;

  }

  /**
   * 保険負担分11行目を取得します。
   * @return 保険負担分11行目
   */
  public ACPanel getByInsurer11(){
    if(byInsurer11==null){

      byInsurer11 = new ACPanel();

      byInsurer11.setAutoWrap(false);

      byInsurer11.setHgap(0);

      byInsurer11.setVgap(0);

      addByInsurer11();
    }
    return byInsurer11;

  }

  /**
   * 保険負担分項目11行目を取得します。
   * @return 保険負担分項目11行目
   */
  public ACComboBox getByInsurerName11(){
    if(byInsurerName11==null){

      byInsurerName11 = new ACComboBox();

      byInsurerName11.setBindPath("BY_INSURER_NAME11");

      byInsurerName11.setColumns(10);

      byInsurerName11.setModelBindPath("BY_INSURER_NAME");

      byInsurerName11.setIMEMode(InputSubset.KANJI);

      byInsurerName11.setMaxLength(20);

      byInsurerName11.setMaxColumns(10);

      byInsurerName11.setModel(getByInsurerName11Model());

      addByInsurerName11();
    }
    return byInsurerName11;

  }

  /**
   * 保険負担分項目11行目モデルを取得します。
   * @return 保険負担分項目11行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName11Model(){
    if(byInsurerName11Model==null){
      byInsurerName11Model = new ACComboBoxModelAdapter();
      addByInsurerName11Model();
    }
    return byInsurerName11Model;
  }

  /**
   * 保険負担分単価11行目を取得します。
   * @return 保険負担分単価11行目
   */
  public ACTextField getByInsurerPrice11(){
    if(byInsurerPrice11==null){

      byInsurerPrice11 = new ACTextField();

      byInsurerPrice11.setBindPath("BY_INSURER_PRICE11");

      byInsurerPrice11.setColumns(3);

      byInsurerPrice11.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice11.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice11.setIMEMode(InputSubset.LATIN);

      byInsurerPrice11.setMaxLength(5);

      addByInsurerPrice11();
    }
    return byInsurerPrice11;

  }

  /**
   * 保険負担分数量11行目を取得します。
   * @return 保険負担分数量11行目
   */
  public ACTextField getByInsurerNumber11(){
    if(byInsurerNumber11==null){

      byInsurerNumber11 = new ACTextField();

      byInsurerNumber11.setBindPath("BY_INSURER_NUMBER11");

      byInsurerNumber11.setColumns(2);

      byInsurerNumber11.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber11.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber11.setIMEMode(InputSubset.LATIN);

      byInsurerNumber11.setMaxLength(3);

      addByInsurerNumber11();
    }
    return byInsurerNumber11;

  }

  /**
   * 保険負担分金額11行目を取得します。
   * @return 保険負担分金額11行目
   */
  public ACTextField getByInsurerSum11(){
    if(byInsurerSum11==null){

      byInsurerSum11 = new ACTextField();

      byInsurerSum11.setBindPath("BY_INSURER_SUM11");

      byInsurerSum11.setColumns(5);

      byInsurerSum11.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum11.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum11.setIMEMode(InputSubset.LATIN);

      byInsurerSum11.setMaxLength(8);

      addByInsurerSum11();
    }
    return byInsurerSum11;

  }

  /**
   * 保険負担分12行目を取得します。
   * @return 保険負担分12行目
   */
  public ACPanel getByInsurer12(){
    if(byInsurer12==null){

      byInsurer12 = new ACPanel();

      byInsurer12.setAutoWrap(false);

      byInsurer12.setHgap(0);

      byInsurer12.setVgap(0);

      addByInsurer12();
    }
    return byInsurer12;

  }

  /**
   * 保険負担分項目12行目を取得します。
   * @return 保険負担分項目12行目
   */
  public ACComboBox getByInsurerName12(){
    if(byInsurerName12==null){

      byInsurerName12 = new ACComboBox();

      byInsurerName12.setBindPath("BY_INSURER_NAME12");

      byInsurerName12.setColumns(10);

      byInsurerName12.setModelBindPath("BY_INSURER_NAME");

      byInsurerName12.setIMEMode(InputSubset.KANJI);

      byInsurerName12.setMaxLength(20);

      byInsurerName12.setMaxColumns(10);

      byInsurerName12.setModel(getByInsurerName12Model());

      addByInsurerName12();
    }
    return byInsurerName12;

  }

  /**
   * 保険負担分項目12行目モデルを取得します。
   * @return 保険負担分項目12行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName12Model(){
    if(byInsurerName12Model==null){
      byInsurerName12Model = new ACComboBoxModelAdapter();
      addByInsurerName12Model();
    }
    return byInsurerName12Model;
  }

  /**
   * 保険負担分単価12行目を取得します。
   * @return 保険負担分単価12行目
   */
  public ACTextField getByInsurerPrice12(){
    if(byInsurerPrice12==null){

      byInsurerPrice12 = new ACTextField();

      byInsurerPrice12.setBindPath("BY_INSURER_PRICE12");

      byInsurerPrice12.setColumns(3);

      byInsurerPrice12.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice12.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice12.setIMEMode(InputSubset.LATIN);

      byInsurerPrice12.setMaxLength(5);

      addByInsurerPrice12();
    }
    return byInsurerPrice12;

  }

  /**
   * 保険負担分数量12行目を取得します。
   * @return 保険負担分数量12行目
   */
  public ACTextField getByInsurerNumber12(){
    if(byInsurerNumber12==null){

      byInsurerNumber12 = new ACTextField();

      byInsurerNumber12.setBindPath("BY_INSURER_NUMBER12");

      byInsurerNumber12.setColumns(2);

      byInsurerNumber12.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber12.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber12.setIMEMode(InputSubset.LATIN);

      byInsurerNumber12.setMaxLength(3);

      addByInsurerNumber12();
    }
    return byInsurerNumber12;

  }

  /**
   * 保険負担分金額12行目を取得します。
   * @return 保険負担分金額12行目
   */
  public ACTextField getByInsurerSum12(){
    if(byInsurerSum12==null){

      byInsurerSum12 = new ACTextField();

      byInsurerSum12.setBindPath("BY_INSURER_SUM12");

      byInsurerSum12.setColumns(5);

      byInsurerSum12.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum12.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum12.setIMEMode(InputSubset.LATIN);

      byInsurerSum12.setMaxLength(8);

      addByInsurerSum12();
    }
    return byInsurerSum12;

  }

  /**
   * 保険負担分13行目を取得します。
   * @return 保険負担分13行目
   */
  public ACPanel getByInsurer13(){
    if(byInsurer13==null){

      byInsurer13 = new ACPanel();

      byInsurer13.setAutoWrap(false);

      byInsurer13.setHgap(0);

      byInsurer13.setVgap(0);

      addByInsurer13();
    }
    return byInsurer13;

  }

  /**
   * 保険負担分項目13行目を取得します。
   * @return 保険負担分項目13行目
   */
  public ACComboBox getByInsurerName13(){
    if(byInsurerName13==null){

      byInsurerName13 = new ACComboBox();

      byInsurerName13.setBindPath("BY_INSURER_NAME13");

      byInsurerName13.setColumns(10);

      byInsurerName13.setModelBindPath("BY_INSURER_NAME");

      byInsurerName13.setIMEMode(InputSubset.KANJI);

      byInsurerName13.setMaxLength(20);

      byInsurerName13.setMaxColumns(10);

      byInsurerName13.setModel(getByInsurerName13Model());

      addByInsurerName13();
    }
    return byInsurerName13;

  }

  /**
   * 保険負担分項目13行目モデルを取得します。
   * @return 保険負担分項目13行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName13Model(){
    if(byInsurerName13Model==null){
      byInsurerName13Model = new ACComboBoxModelAdapter();
      addByInsurerName13Model();
    }
    return byInsurerName13Model;
  }

  /**
   * 保険負担分単価13行目を取得します。
   * @return 保険負担分単価13行目
   */
  public ACTextField getByInsurerPrice13(){
    if(byInsurerPrice13==null){

      byInsurerPrice13 = new ACTextField();

      byInsurerPrice13.setBindPath("BY_INSURER_PRICE13");

      byInsurerPrice13.setColumns(3);

      byInsurerPrice13.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice13.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice13.setIMEMode(InputSubset.LATIN);

      byInsurerPrice13.setMaxLength(5);

      addByInsurerPrice13();
    }
    return byInsurerPrice13;

  }

  /**
   * 保険負担分数量13行目を取得します。
   * @return 保険負担分数量13行目
   */
  public ACTextField getByInsurerNumber13(){
    if(byInsurerNumber13==null){

      byInsurerNumber13 = new ACTextField();

      byInsurerNumber13.setBindPath("BY_INSURER_NUMBER13");

      byInsurerNumber13.setColumns(2);

      byInsurerNumber13.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber13.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber13.setIMEMode(InputSubset.LATIN);

      byInsurerNumber13.setMaxLength(3);

      addByInsurerNumber13();
    }
    return byInsurerNumber13;

  }

  /**
   * 保険負担分金額13行目を取得します。
   * @return 保険負担分金額13行目
   */
  public ACTextField getByInsurerSum13(){
    if(byInsurerSum13==null){

      byInsurerSum13 = new ACTextField();

      byInsurerSum13.setBindPath("BY_INSURER_SUM13");

      byInsurerSum13.setColumns(5);

      byInsurerSum13.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum13.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum13.setIMEMode(InputSubset.LATIN);

      byInsurerSum13.setMaxLength(8);

      addByInsurerSum13();
    }
    return byInsurerSum13;

  }

  /**
   * 保険負担分14行目を取得します。
   * @return 保険負担分14行目
   */
  public ACPanel getByInsurer14(){
    if(byInsurer14==null){

      byInsurer14 = new ACPanel();

      byInsurer14.setAutoWrap(false);

      byInsurer14.setHgap(0);

      byInsurer14.setVgap(0);

      addByInsurer14();
    }
    return byInsurer14;

  }

  /**
   * 保険負担分項目14行目を取得します。
   * @return 保険負担分項目14行目
   */
  public ACComboBox getByInsurerName14(){
    if(byInsurerName14==null){

      byInsurerName14 = new ACComboBox();

      byInsurerName14.setBindPath("BY_INSURER_NAME14");

      byInsurerName14.setColumns(10);

      byInsurerName14.setModelBindPath("BY_INSURER_NAME");

      byInsurerName14.setIMEMode(InputSubset.KANJI);

      byInsurerName14.setMaxLength(20);

      byInsurerName14.setMaxColumns(10);

      byInsurerName14.setModel(getByInsurerName14Model());

      addByInsurerName14();
    }
    return byInsurerName14;

  }

  /**
   * 保険負担分項目14行目モデルを取得します。
   * @return 保険負担分項目14行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName14Model(){
    if(byInsurerName14Model==null){
      byInsurerName14Model = new ACComboBoxModelAdapter();
      addByInsurerName14Model();
    }
    return byInsurerName14Model;
  }

  /**
   * 保険負担分単価14行目を取得します。
   * @return 保険負担分単価14行目
   */
  public ACTextField getByInsurerPrice14(){
    if(byInsurerPrice14==null){

      byInsurerPrice14 = new ACTextField();

      byInsurerPrice14.setBindPath("BY_INSURER_PRICE14");

      byInsurerPrice14.setColumns(3);

      byInsurerPrice14.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice14.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice14.setIMEMode(InputSubset.LATIN);

      byInsurerPrice14.setMaxLength(5);

      addByInsurerPrice14();
    }
    return byInsurerPrice14;

  }

  /**
   * 保険負担分数量14行目を取得します。
   * @return 保険負担分数量14行目
   */
  public ACTextField getByInsurerNumber14(){
    if(byInsurerNumber14==null){

      byInsurerNumber14 = new ACTextField();

      byInsurerNumber14.setBindPath("BY_INSURER_NUMBER14");

      byInsurerNumber14.setColumns(2);

      byInsurerNumber14.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber14.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber14.setIMEMode(InputSubset.LATIN);

      byInsurerNumber14.setMaxLength(3);

      addByInsurerNumber14();
    }
    return byInsurerNumber14;

  }

  /**
   * 保険負担分金額14行目を取得します。
   * @return 保険負担分金額14行目
   */
  public ACTextField getByInsurerSum14(){
    if(byInsurerSum14==null){

      byInsurerSum14 = new ACTextField();

      byInsurerSum14.setBindPath("BY_INSURER_SUM14");

      byInsurerSum14.setColumns(5);

      byInsurerSum14.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum14.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum14.setIMEMode(InputSubset.LATIN);

      byInsurerSum14.setMaxLength(8);

      addByInsurerSum14();
    }
    return byInsurerSum14;

  }

  /**
   * 保険負担分15行目を取得します。
   * @return 保険負担分15行目
   */
  public ACPanel getByInsurer15(){
    if(byInsurer15==null){

      byInsurer15 = new ACPanel();

      byInsurer15.setAutoWrap(false);

      byInsurer15.setHgap(0);

      byInsurer15.setVgap(0);

      addByInsurer15();
    }
    return byInsurer15;

  }

  /**
   * 保険負担分項目15行目を取得します。
   * @return 保険負担分項目15行目
   */
  public ACComboBox getByInsurerName15(){
    if(byInsurerName15==null){

      byInsurerName15 = new ACComboBox();

      byInsurerName15.setBindPath("BY_INSURER_NAME15");

      byInsurerName15.setColumns(10);

      byInsurerName15.setModelBindPath("BY_INSURER_NAME");

      byInsurerName15.setIMEMode(InputSubset.KANJI);

      byInsurerName15.setMaxLength(20);

      byInsurerName15.setMaxColumns(10);

      byInsurerName15.setModel(getByInsurerName15Model());

      addByInsurerName15();
    }
    return byInsurerName15;

  }

  /**
   * 保険負担分項目15行目モデルを取得します。
   * @return 保険負担分項目15行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName15Model(){
    if(byInsurerName15Model==null){
      byInsurerName15Model = new ACComboBoxModelAdapter();
      addByInsurerName15Model();
    }
    return byInsurerName15Model;
  }

  /**
   * 保険負担分単価15行目を取得します。
   * @return 保険負担分単価15行目
   */
  public ACTextField getByInsurerPrice15(){
    if(byInsurerPrice15==null){

      byInsurerPrice15 = new ACTextField();

      byInsurerPrice15.setBindPath("BY_INSURER_PRICE15");

      byInsurerPrice15.setColumns(3);

      byInsurerPrice15.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice15.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice15.setIMEMode(InputSubset.LATIN);

      byInsurerPrice15.setMaxLength(5);

      addByInsurerPrice15();
    }
    return byInsurerPrice15;

  }

  /**
   * 保険負担分数量15行目を取得します。
   * @return 保険負担分数量15行目
   */
  public ACTextField getByInsurerNumber15(){
    if(byInsurerNumber15==null){

      byInsurerNumber15 = new ACTextField();

      byInsurerNumber15.setBindPath("BY_INSURER_NUMBER15");

      byInsurerNumber15.setColumns(2);

      byInsurerNumber15.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber15.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber15.setIMEMode(InputSubset.LATIN);

      byInsurerNumber15.setMaxLength(3);

      addByInsurerNumber15();
    }
    return byInsurerNumber15;

  }

  /**
   * 保険負担分金額15行目を取得します。
   * @return 保険負担分金額15行目
   */
  public ACTextField getByInsurerSum15(){
    if(byInsurerSum15==null){

      byInsurerSum15 = new ACTextField();

      byInsurerSum15.setBindPath("BY_INSURER_SUM15");

      byInsurerSum15.setColumns(5);

      byInsurerSum15.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum15.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum15.setIMEMode(InputSubset.LATIN);

      byInsurerSum15.setMaxLength(8);

      addByInsurerSum15();
    }
    return byInsurerSum15;

  }

  /**
   * 保険負担分16行目を取得します。
   * @return 保険負担分16行目
   */
  public ACPanel getByInsurer16(){
    if(byInsurer16==null){

      byInsurer16 = new ACPanel();

      byInsurer16.setAutoWrap(false);

      byInsurer16.setHgap(0);

      byInsurer16.setVgap(0);

      addByInsurer16();
    }
    return byInsurer16;

  }

  /**
   * 保険負担分項目16行目を取得します。
   * @return 保険負担分項目16行目
   */
  public ACComboBox getByInsurerName16(){
    if(byInsurerName16==null){

      byInsurerName16 = new ACComboBox();

      byInsurerName16.setBindPath("BY_INSURER_NAME16");

      byInsurerName16.setColumns(10);

      byInsurerName16.setModelBindPath("BY_INSURER_NAME");

      byInsurerName16.setIMEMode(InputSubset.KANJI);

      byInsurerName16.setMaxLength(20);

      byInsurerName16.setMaxColumns(10);

      byInsurerName16.setModel(getByInsurerName16Model());

      addByInsurerName16();
    }
    return byInsurerName16;

  }

  /**
   * 保険負担分項目16行目モデルを取得します。
   * @return 保険負担分項目16行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName16Model(){
    if(byInsurerName16Model==null){
      byInsurerName16Model = new ACComboBoxModelAdapter();
      addByInsurerName16Model();
    }
    return byInsurerName16Model;
  }

  /**
   * 保険負担分単価16行目を取得します。
   * @return 保険負担分単価16行目
   */
  public ACTextField getByInsurerPrice16(){
    if(byInsurerPrice16==null){

      byInsurerPrice16 = new ACTextField();

      byInsurerPrice16.setBindPath("BY_INSURER_PRICE16");

      byInsurerPrice16.setColumns(3);

      byInsurerPrice16.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice16.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice16.setIMEMode(InputSubset.LATIN);

      byInsurerPrice16.setMaxLength(5);

      addByInsurerPrice16();
    }
    return byInsurerPrice16;

  }

  /**
   * 保険負担分数量16行目を取得します。
   * @return 保険負担分数量16行目
   */
  public ACTextField getByInsurerNumber16(){
    if(byInsurerNumber16==null){

      byInsurerNumber16 = new ACTextField();

      byInsurerNumber16.setBindPath("BY_INSURER_NUMBER16");

      byInsurerNumber16.setColumns(2);

      byInsurerNumber16.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber16.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber16.setIMEMode(InputSubset.LATIN);

      byInsurerNumber16.setMaxLength(3);

      addByInsurerNumber16();
    }
    return byInsurerNumber16;

  }

  /**
   * 保険負担分金額16行目を取得します。
   * @return 保険負担分金額16行目
   */
  public ACTextField getByInsurerSum16(){
    if(byInsurerSum16==null){

      byInsurerSum16 = new ACTextField();

      byInsurerSum16.setBindPath("BY_INSURER_SUM16");

      byInsurerSum16.setColumns(5);

      byInsurerSum16.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum16.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum16.setIMEMode(InputSubset.LATIN);

      byInsurerSum16.setMaxLength(8);

      addByInsurerSum16();
    }
    return byInsurerSum16;

  }

  /**
   * 保険負担分17行目を取得します。
   * @return 保険負担分17行目
   */
  public ACPanel getByInsurer17(){
    if(byInsurer17==null){

      byInsurer17 = new ACPanel();

      byInsurer17.setAutoWrap(false);

      byInsurer17.setHgap(0);

      byInsurer17.setVgap(0);

      addByInsurer17();
    }
    return byInsurer17;

  }

  /**
   * 保険負担分項目17行目を取得します。
   * @return 保険負担分項目17行目
   */
  public ACComboBox getByInsurerName17(){
    if(byInsurerName17==null){

      byInsurerName17 = new ACComboBox();

      byInsurerName17.setBindPath("BY_INSURER_NAME17");

      byInsurerName17.setColumns(10);

      byInsurerName17.setModelBindPath("BY_INSURER_NAME");

      byInsurerName17.setIMEMode(InputSubset.KANJI);

      byInsurerName17.setMaxLength(20);

      byInsurerName17.setMaxColumns(10);

      byInsurerName17.setModel(getByInsurerName17Model());

      addByInsurerName17();
    }
    return byInsurerName17;

  }

  /**
   * 保険負担分項目17行目モデルを取得します。
   * @return 保険負担分項目17行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName17Model(){
    if(byInsurerName17Model==null){
      byInsurerName17Model = new ACComboBoxModelAdapter();
      addByInsurerName17Model();
    }
    return byInsurerName17Model;
  }

  /**
   * 保険負担分単価17行目を取得します。
   * @return 保険負担分単価17行目
   */
  public ACTextField getByInsurerPrice17(){
    if(byInsurerPrice17==null){

      byInsurerPrice17 = new ACTextField();

      byInsurerPrice17.setBindPath("BY_INSURER_PRICE17");

      byInsurerPrice17.setColumns(3);

      byInsurerPrice17.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice17.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice17.setIMEMode(InputSubset.LATIN);

      byInsurerPrice17.setMaxLength(5);

      addByInsurerPrice17();
    }
    return byInsurerPrice17;

  }

  /**
   * 保険負担分数量17行目を取得します。
   * @return 保険負担分数量17行目
   */
  public ACTextField getByInsurerNumber17(){
    if(byInsurerNumber17==null){

      byInsurerNumber17 = new ACTextField();

      byInsurerNumber17.setBindPath("BY_INSURER_NUMBER17");

      byInsurerNumber17.setColumns(2);

      byInsurerNumber17.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber17.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber17.setIMEMode(InputSubset.LATIN);

      byInsurerNumber17.setMaxLength(3);

      addByInsurerNumber17();
    }
    return byInsurerNumber17;

  }

  /**
   * 保険負担分金額17行目を取得します。
   * @return 保険負担分金額17行目
   */
  public ACTextField getByInsurerSum17(){
    if(byInsurerSum17==null){

      byInsurerSum17 = new ACTextField();

      byInsurerSum17.setBindPath("BY_INSURER_SUM17");

      byInsurerSum17.setColumns(5);

      byInsurerSum17.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum17.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum17.setIMEMode(InputSubset.LATIN);

      byInsurerSum17.setMaxLength(8);

      addByInsurerSum17();
    }
    return byInsurerSum17;

  }

  /**
   * 保険負担分18行目を取得します。
   * @return 保険負担分18行目
   */
  public ACPanel getByInsurer18(){
    if(byInsurer18==null){

      byInsurer18 = new ACPanel();

      byInsurer18.setAutoWrap(false);

      byInsurer18.setHgap(0);

      byInsurer18.setVgap(0);

      addByInsurer18();
    }
    return byInsurer18;

  }

  /**
   * 保険負担分項目18行目を取得します。
   * @return 保険負担分項目18行目
   */
  public ACComboBox getByInsurerName18(){
    if(byInsurerName18==null){

      byInsurerName18 = new ACComboBox();

      byInsurerName18.setBindPath("BY_INSURER_NAME18");

      byInsurerName18.setColumns(10);

      byInsurerName18.setModelBindPath("BY_INSURER_NAME");

      byInsurerName18.setIMEMode(InputSubset.KANJI);

      byInsurerName18.setMaxLength(20);

      byInsurerName18.setMaxColumns(10);

      byInsurerName18.setModel(getByInsurerName18Model());

      addByInsurerName18();
    }
    return byInsurerName18;

  }

  /**
   * 保険負担分項目18行目モデルを取得します。
   * @return 保険負担分項目18行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName18Model(){
    if(byInsurerName18Model==null){
      byInsurerName18Model = new ACComboBoxModelAdapter();
      addByInsurerName18Model();
    }
    return byInsurerName18Model;
  }

  /**
   * 保険負担分単価18行目を取得します。
   * @return 保険負担分単価18行目
   */
  public ACTextField getByInsurerPrice18(){
    if(byInsurerPrice18==null){

      byInsurerPrice18 = new ACTextField();

      byInsurerPrice18.setBindPath("BY_INSURER_PRICE18");

      byInsurerPrice18.setColumns(3);

      byInsurerPrice18.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice18.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice18.setIMEMode(InputSubset.LATIN);

      byInsurerPrice18.setMaxLength(5);

      addByInsurerPrice18();
    }
    return byInsurerPrice18;

  }

  /**
   * 保険負担分数量18行目を取得します。
   * @return 保険負担分数量18行目
   */
  public ACTextField getByInsurerNumber18(){
    if(byInsurerNumber18==null){

      byInsurerNumber18 = new ACTextField();

      byInsurerNumber18.setBindPath("BY_INSURER_NUMBER18");

      byInsurerNumber18.setColumns(2);

      byInsurerNumber18.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber18.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber18.setIMEMode(InputSubset.LATIN);

      byInsurerNumber18.setMaxLength(3);

      addByInsurerNumber18();
    }
    return byInsurerNumber18;

  }

  /**
   * 保険負担分金額18行目を取得します。
   * @return 保険負担分金額18行目
   */
  public ACTextField getByInsurerSum18(){
    if(byInsurerSum18==null){

      byInsurerSum18 = new ACTextField();

      byInsurerSum18.setBindPath("BY_INSURER_SUM18");

      byInsurerSum18.setColumns(5);

      byInsurerSum18.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum18.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum18.setIMEMode(InputSubset.LATIN);

      byInsurerSum18.setMaxLength(8);

      addByInsurerSum18();
    }
    return byInsurerSum18;

  }

  /**
   * 保険負担分19行目を取得します。
   * @return 保険負担分19行目
   */
  public ACPanel getByInsurer19(){
    if(byInsurer19==null){

      byInsurer19 = new ACPanel();

      byInsurer19.setAutoWrap(false);

      byInsurer19.setHgap(0);

      byInsurer19.setVgap(0);

      addByInsurer19();
    }
    return byInsurer19;

  }

  /**
   * 保険負担分項目19行目を取得します。
   * @return 保険負担分項目19行目
   */
  public ACComboBox getByInsurerName19(){
    if(byInsurerName19==null){

      byInsurerName19 = new ACComboBox();

      byInsurerName19.setBindPath("BY_INSURER_NAME19");

      byInsurerName19.setColumns(10);

      byInsurerName19.setModelBindPath("BY_INSURER_NAME");

      byInsurerName19.setIMEMode(InputSubset.KANJI);

      byInsurerName19.setMaxLength(20);

      byInsurerName19.setMaxColumns(10);

      byInsurerName19.setModel(getByInsurerName19Model());

      addByInsurerName19();
    }
    return byInsurerName19;

  }

  /**
   * 保険負担分項目19行目モデルを取得します。
   * @return 保険負担分項目19行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName19Model(){
    if(byInsurerName19Model==null){
      byInsurerName19Model = new ACComboBoxModelAdapter();
      addByInsurerName19Model();
    }
    return byInsurerName19Model;
  }

  /**
   * 保険負担分単価19行目を取得します。
   * @return 保険負担分単価19行目
   */
  public ACTextField getByInsurerPrice19(){
    if(byInsurerPrice19==null){

      byInsurerPrice19 = new ACTextField();

      byInsurerPrice19.setBindPath("BY_INSURER_PRICE19");

      byInsurerPrice19.setColumns(3);

      byInsurerPrice19.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice19.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice19.setIMEMode(InputSubset.LATIN);

      byInsurerPrice19.setMaxLength(5);

      addByInsurerPrice19();
    }
    return byInsurerPrice19;

  }

  /**
   * 保険負担分数量19行目を取得します。
   * @return 保険負担分数量19行目
   */
  public ACTextField getByInsurerNumber19(){
    if(byInsurerNumber19==null){

      byInsurerNumber19 = new ACTextField();

      byInsurerNumber19.setBindPath("BY_INSURER_NUMBER19");

      byInsurerNumber19.setColumns(2);

      byInsurerNumber19.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber19.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber19.setIMEMode(InputSubset.LATIN);

      byInsurerNumber19.setMaxLength(3);

      addByInsurerNumber19();
    }
    return byInsurerNumber19;

  }

  /**
   * 保険負担分金額19行目を取得します。
   * @return 保険負担分金額19行目
   */
  public ACTextField getByInsurerSum19(){
    if(byInsurerSum19==null){

      byInsurerSum19 = new ACTextField();

      byInsurerSum19.setBindPath("BY_INSURER_SUM19");

      byInsurerSum19.setColumns(5);

      byInsurerSum19.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum19.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum19.setIMEMode(InputSubset.LATIN);

      byInsurerSum19.setMaxLength(8);

      addByInsurerSum19();
    }
    return byInsurerSum19;

  }

  /**
   * 保険負担分20行目を取得します。
   * @return 保険負担分20行目
   */
  public ACPanel getByInsurer20(){
    if(byInsurer20==null){

      byInsurer20 = new ACPanel();

      byInsurer20.setAutoWrap(false);

      byInsurer20.setHgap(0);

      byInsurer20.setVgap(0);

      addByInsurer20();
    }
    return byInsurer20;

  }

  /**
   * 保険負担分項目20行目を取得します。
   * @return 保険負担分項目20行目
   */
  public ACComboBox getByInsurerName20(){
    if(byInsurerName20==null){

      byInsurerName20 = new ACComboBox();

      byInsurerName20.setBindPath("BY_INSURER_NAME20");

      byInsurerName20.setColumns(10);

      byInsurerName20.setModelBindPath("BY_INSURER_NAME");

      byInsurerName20.setIMEMode(InputSubset.KANJI);

      byInsurerName20.setMaxLength(20);

      byInsurerName20.setMaxColumns(10);

      byInsurerName20.setModel(getByInsurerName20Model());

      addByInsurerName20();
    }
    return byInsurerName20;

  }

  /**
   * 保険負担分項目20行目モデルを取得します。
   * @return 保険負担分項目20行目モデル
   */
  protected ACComboBoxModelAdapter getByInsurerName20Model(){
    if(byInsurerName20Model==null){
      byInsurerName20Model = new ACComboBoxModelAdapter();
      addByInsurerName20Model();
    }
    return byInsurerName20Model;
  }

  /**
   * 保険負担分単価20行目を取得します。
   * @return 保険負担分単価20行目
   */
  public ACTextField getByInsurerPrice20(){
    if(byInsurerPrice20==null){

      byInsurerPrice20 = new ACTextField();

      byInsurerPrice20.setBindPath("BY_INSURER_PRICE20");

      byInsurerPrice20.setColumns(3);

      byInsurerPrice20.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerPrice20.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerPrice20.setIMEMode(InputSubset.LATIN);

      byInsurerPrice20.setMaxLength(5);

      addByInsurerPrice20();
    }
    return byInsurerPrice20;

  }

  /**
   * 保険負担分数量20行目を取得します。
   * @return 保険負担分数量20行目
   */
  public ACTextField getByInsurerNumber20(){
    if(byInsurerNumber20==null){

      byInsurerNumber20 = new ACTextField();

      byInsurerNumber20.setBindPath("BY_INSURER_NUMBER20");

      byInsurerNumber20.setColumns(2);

      byInsurerNumber20.setCharType(VRCharType.ONLY_DIGIT);

      byInsurerNumber20.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerNumber20.setIMEMode(InputSubset.LATIN);

      byInsurerNumber20.setMaxLength(3);

      addByInsurerNumber20();
    }
    return byInsurerNumber20;

  }

  /**
   * 保険負担分金額20行目を取得します。
   * @return 保険負担分金額20行目
   */
  public ACTextField getByInsurerSum20(){
    if(byInsurerSum20==null){

      byInsurerSum20 = new ACTextField();

      byInsurerSum20.setBindPath("BY_INSURER_SUM20");

      byInsurerSum20.setColumns(5);

      byInsurerSum20.setCharType(VRCharType.ONLY_NUMBER);

      byInsurerSum20.setHorizontalAlignment(SwingConstants.RIGHT);

      byInsurerSum20.setIMEMode(InputSubset.LATIN);

      byInsurerSum20.setMaxLength(8);

      addByInsurerSum20();
    }
    return byInsurerSum20;

  }

  /**
   * 保険外負担領域を取得します。
   * @return 保険外負担領域
   */
  public ACPanel getByPatientContents(){
    if(byPatientContents==null){

      byPatientContents = new ACPanel();

      byPatientContents.setVgap(0);

      addByPatientContents();
    }
    return byPatientContents;

  }

  /**
   * 保険外負担分タイトルを取得します。
   * @return 保険外負担分タイトル
   */
  public ACPanel getByPatientTitle(){
    if(byPatientTitle==null){

      byPatientTitle = new ACPanel();

      byPatientTitle.setAutoWrap(false);

      byPatientTitle.setHgap(0);

      byPatientTitle.setVgap(0);

      addByPatientTitle();
    }
    return byPatientTitle;

  }

  /**
   * 保険外負担分項目タイトルを取得します。
   * @return 保険外負担分項目タイトル
   */
  public ACTextField getByPatientNameTitle(){
    if(byPatientNameTitle==null){

      byPatientNameTitle = new ACTextField();

      byPatientNameTitle.setText("保険外負担分項目");

      byPatientNameTitle.setEditable(false);

      byPatientNameTitle.setColumns(10);

      addByPatientNameTitle();
    }
    return byPatientNameTitle;

  }

  /**
   * 保険外負担分単価タイトルを取得します。
   * @return 保険外負担分単価タイトル
   */
  public ACTextField getByPatientPriceTitle(){
    if(byPatientPriceTitle==null){

      byPatientPriceTitle = new ACTextField();

      byPatientPriceTitle.setText("単価");

      byPatientPriceTitle.setEditable(false);

      byPatientPriceTitle.setColumns(3);

      addByPatientPriceTitle();
    }
    return byPatientPriceTitle;

  }

  /**
   * 保険外負担分数量タイトルを取得します。
   * @return 保険外負担分数量タイトル
   */
  public ACTextField getByPatientNumberTitle(){
    if(byPatientNumberTitle==null){

      byPatientNumberTitle = new ACTextField();

      byPatientNumberTitle.setText("数量");

      byPatientNumberTitle.setEditable(false);

      byPatientNumberTitle.setColumns(2);

      addByPatientNumberTitle();
    }
    return byPatientNumberTitle;

  }

  /**
   * 保険外負担分金額タイトルを取得します。
   * @return 保険外負担分金額タイトル
   */
  public ACTextField getByPatientSumTitle(){
    if(byPatientSumTitle==null){

      byPatientSumTitle = new ACTextField();

      byPatientSumTitle.setText("金額");

      byPatientSumTitle.setEditable(false);

      byPatientSumTitle.setColumns(5);

      addByPatientSumTitle();
    }
    return byPatientSumTitle;

  }

  /**
   * 保険外負担分課税タイトルを取得します。
   * @return 保険外負担分課税タイトル
   */
  public ACTextField getByPatientTaxTargetTitle(){
    if(byPatientTaxTargetTitle==null){

      byPatientTaxTargetTitle = new ACTextField();

      byPatientTaxTargetTitle.setText("課税");

      byPatientTaxTargetTitle.setEditable(false);

      addByPatientTaxTargetTitle();
    }
    return byPatientTaxTargetTitle;

  }

  /**
   * 保険外負担分外税タイトルを取得します。
   * @return 保険外負担分外税タイトル
   */
  public ACTextField getByPatientUseTaxTitle(){
    if(byPatientUseTaxTitle==null){

      byPatientUseTaxTitle = new ACTextField();

      byPatientUseTaxTitle.setText("税");

      byPatientUseTaxTitle.setEditable(false);

      addByPatientUseTaxTitle();
    }
    return byPatientUseTaxTitle;

  }

  /**
   * 保険外負担分消費税等タイトルを取得します。
   * @return 保険外負担分消費税等タイトル
   */
  public ACTextField getByPatientTaxTitle(){
    if(byPatientTaxTitle==null){

      byPatientTaxTitle = new ACTextField();

      byPatientTaxTitle.setText("消費税等");

      byPatientTaxTitle.setEditable(false);

      byPatientTaxTitle.setColumns(4);

      addByPatientTaxTitle();
    }
    return byPatientTaxTitle;

  }

  /**
   * 保険外負担分1行目を取得します。
   * @return 保険外負担分1行目
   */
  public ACPanel getByPatient1(){
    if(byPatient1==null){

      byPatient1 = new ACPanel();

      byPatient1.setAutoWrap(false);

      byPatient1.setHgap(0);

      byPatient1.setVgap(0);

      addByPatient1();
    }
    return byPatient1;

  }

  /**
   * 保険外負担分項目1行目を取得します。
   * @return 保険外負担分項目1行目
   */
  public ACComboBox getByPatientName1(){
    if(byPatientName1==null){

      byPatientName1 = new ACComboBox();

      byPatientName1.setBindPath("BY_PATIENT_NAME1");

      byPatientName1.setColumns(10);

      byPatientName1.setModelBindPath("BY_PATIENT_NAME");

      byPatientName1.setIMEMode(InputSubset.KANJI);

      byPatientName1.setMaxLength(20);

      byPatientName1.setMaxColumns(10);

      byPatientName1.setModel(getByPatientName1Model());

      addByPatientName1();
    }
    return byPatientName1;

  }

  /**
   * 保険外負担分項目1行目モデルを取得します。
   * @return 保険外負担分項目1行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName1Model(){
    if(byPatientName1Model==null){
      byPatientName1Model = new ACComboBoxModelAdapter();
      addByPatientName1Model();
    }
    return byPatientName1Model;
  }

  /**
   * 保険外負担分単価1行目を取得します。
   * @return 保険外負担分単価1行目
   */
  public ACTextField getByPatientPrice1(){
    if(byPatientPrice1==null){

      byPatientPrice1 = new ACTextField();

      byPatientPrice1.setBindPath("BY_PATIENT_PRICE1");

      byPatientPrice1.setColumns(3);

      byPatientPrice1.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice1.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice1.setIMEMode(InputSubset.LATIN);

      byPatientPrice1.setMaxLength(5);

      addByPatientPrice1();
    }
    return byPatientPrice1;

  }

  /**
   * 保険外負担分数量1行目を取得します。
   * @return 保険外負担分数量1行目
   */
  public ACTextField getByPatientNumber1(){
    if(byPatientNumber1==null){

      byPatientNumber1 = new ACTextField();

      byPatientNumber1.setBindPath("BY_PATIENT_NUMBER1");

      byPatientNumber1.setColumns(2);

      byPatientNumber1.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber1.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber1.setIMEMode(InputSubset.LATIN);

      byPatientNumber1.setMaxLength(3);

      addByPatientNumber1();
    }
    return byPatientNumber1;

  }

  /**
   * 保険外負担分金額1行目を取得します。
   * @return 保険外負担分金額1行目
   */
  public ACTextField getByPatientSum1(){
    if(byPatientSum1==null){

      byPatientSum1 = new ACTextField();

      byPatientSum1.setBindPath("BY_PATIENT_SUM1");

      byPatientSum1.setColumns(5);

      byPatientSum1.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum1.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum1.setIMEMode(InputSubset.LATIN);

      byPatientSum1.setMaxLength(8);

      addByPatientSum1();
    }
    return byPatientSum1;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget1(){
    if(byPatientTaxTarget1==null){

      byPatientTaxTarget1 = new ACIntegerCheckBox();

      byPatientTaxTarget1.setText("　");

      byPatientTaxTarget1.setBindPath("BY_PATIENT_TAX_TARGET1");

      addByPatientTaxTarget1();
    }
    return byPatientTaxTarget1;

  }

  /**
   * 保険外負担分外税1行目を取得します。
   * @return 保険外負担分外税1行目
   */
  public ACIntegerCheckBox getByPatientUseTax1(){
    if(byPatientUseTax1==null){

      byPatientUseTax1 = new ACIntegerCheckBox();

      byPatientUseTax1.setBindPath("BY_PATIENT_USE_TAX1");

      addByPatientUseTax1();
    }
    return byPatientUseTax1;

  }

  /**
   * 保険外負担分消費税等1行目を取得します。
   * @return 保険外負担分消費税等1行目
   */
  public ACTextField getByPatientTax1(){
    if(byPatientTax1==null){

      byPatientTax1 = new ACTextField();

      byPatientTax1.setBindPath("BY_PATIENT_TAX1");

      byPatientTax1.setColumns(4);

      byPatientTax1.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax1.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax1.setIMEMode(InputSubset.LATIN);

      byPatientTax1.setMaxLength(5);

      addByPatientTax1();
    }
    return byPatientTax1;

  }

  /**
   * 保険外負担分2行目を取得します。
   * @return 保険外負担分2行目
   */
  public ACPanel getByPatient2(){
    if(byPatient2==null){

      byPatient2 = new ACPanel();

      byPatient2.setAutoWrap(false);

      byPatient2.setHgap(0);

      byPatient2.setVgap(0);

      addByPatient2();
    }
    return byPatient2;

  }

  /**
   * 保険外負担分項目2行目を取得します。
   * @return 保険外負担分項目2行目
   */
  public ACComboBox getByPatientName2(){
    if(byPatientName2==null){

      byPatientName2 = new ACComboBox();

      byPatientName2.setBindPath("BY_PATIENT_NAME2");

      byPatientName2.setColumns(10);

      byPatientName2.setModelBindPath("BY_PATIENT_NAME");

      byPatientName2.setIMEMode(InputSubset.KANJI);

      byPatientName2.setMaxLength(20);

      byPatientName2.setMaxColumns(10);

      byPatientName2.setModel(getByPatientName2Model());

      addByPatientName2();
    }
    return byPatientName2;

  }

  /**
   * 保険外負担分項目2行目モデルを取得します。
   * @return 保険外負担分項目2行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName2Model(){
    if(byPatientName2Model==null){
      byPatientName2Model = new ACComboBoxModelAdapter();
      addByPatientName2Model();
    }
    return byPatientName2Model;
  }

  /**
   * 保険外負担分単価2行目を取得します。
   * @return 保険外負担分単価2行目
   */
  public ACTextField getByPatientPrice2(){
    if(byPatientPrice2==null){

      byPatientPrice2 = new ACTextField();

      byPatientPrice2.setBindPath("BY_PATIENT_PRICE2");

      byPatientPrice2.setColumns(3);

      byPatientPrice2.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice2.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice2.setIMEMode(InputSubset.LATIN);

      byPatientPrice2.setMaxLength(5);

      addByPatientPrice2();
    }
    return byPatientPrice2;

  }

  /**
   * 保険外負担分数量2行目を取得します。
   * @return 保険外負担分数量2行目
   */
  public ACTextField getByPatientNumber2(){
    if(byPatientNumber2==null){

      byPatientNumber2 = new ACTextField();

      byPatientNumber2.setBindPath("BY_PATIENT_NUMBER2");

      byPatientNumber2.setColumns(2);

      byPatientNumber2.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber2.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber2.setIMEMode(InputSubset.LATIN);

      byPatientNumber2.setMaxLength(3);

      addByPatientNumber2();
    }
    return byPatientNumber2;

  }

  /**
   * 保険外負担分金額2行目を取得します。
   * @return 保険外負担分金額2行目
   */
  public ACTextField getByPatientSum2(){
    if(byPatientSum2==null){

      byPatientSum2 = new ACTextField();

      byPatientSum2.setBindPath("BY_PATIENT_SUM2");

      byPatientSum2.setColumns(5);

      byPatientSum2.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum2.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum2.setIMEMode(InputSubset.LATIN);

      byPatientSum2.setMaxLength(8);

      addByPatientSum2();
    }
    return byPatientSum2;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget2(){
    if(byPatientTaxTarget2==null){

      byPatientTaxTarget2 = new ACIntegerCheckBox();

      byPatientTaxTarget2.setText("　");

      byPatientTaxTarget2.setBindPath("BY_PATIENT_TAX_TARGET2");

      addByPatientTaxTarget2();
    }
    return byPatientTaxTarget2;

  }

  /**
   * 保険外負担分外税2行目を取得します。
   * @return 保険外負担分外税2行目
   */
  public ACIntegerCheckBox getByPatientUseTax2(){
    if(byPatientUseTax2==null){

      byPatientUseTax2 = new ACIntegerCheckBox();

      byPatientUseTax2.setBindPath("BY_PATIENT_USE_TAX2");

      addByPatientUseTax2();
    }
    return byPatientUseTax2;

  }

  /**
   * 保険外負担分消費税等2行目を取得します。
   * @return 保険外負担分消費税等2行目
   */
  public ACTextField getByPatientTax2(){
    if(byPatientTax2==null){

      byPatientTax2 = new ACTextField();

      byPatientTax2.setBindPath("BY_PATIENT_TAX2");

      byPatientTax2.setColumns(4);

      byPatientTax2.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax2.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax2.setIMEMode(InputSubset.LATIN);

      byPatientTax2.setMaxLength(5);

      addByPatientTax2();
    }
    return byPatientTax2;

  }

  /**
   * 保険外負担分3行目を取得します。
   * @return 保険外負担分3行目
   */
  public ACPanel getByPatient3(){
    if(byPatient3==null){

      byPatient3 = new ACPanel();

      byPatient3.setAutoWrap(false);

      byPatient3.setHgap(0);

      byPatient3.setVgap(0);

      addByPatient3();
    }
    return byPatient3;

  }

  /**
   * 保険外負担分項目3行目を取得します。
   * @return 保険外負担分項目3行目
   */
  public ACComboBox getByPatientName3(){
    if(byPatientName3==null){

      byPatientName3 = new ACComboBox();

      byPatientName3.setBindPath("BY_PATIENT_NAME3");

      byPatientName3.setColumns(10);

      byPatientName3.setModelBindPath("BY_PATIENT_NAME");

      byPatientName3.setIMEMode(InputSubset.KANJI);

      byPatientName3.setMaxLength(20);

      byPatientName3.setMaxColumns(10);

      byPatientName3.setModel(getByPatientName3Model());

      addByPatientName3();
    }
    return byPatientName3;

  }

  /**
   * 保険外負担分項目3行目モデルを取得します。
   * @return 保険外負担分項目3行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName3Model(){
    if(byPatientName3Model==null){
      byPatientName3Model = new ACComboBoxModelAdapter();
      addByPatientName3Model();
    }
    return byPatientName3Model;
  }

  /**
   * 保険外負担分単価3行目を取得します。
   * @return 保険外負担分単価3行目
   */
  public ACTextField getByPatientPrice3(){
    if(byPatientPrice3==null){

      byPatientPrice3 = new ACTextField();

      byPatientPrice3.setBindPath("BY_PATIENT_PRICE3");

      byPatientPrice3.setColumns(3);

      byPatientPrice3.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice3.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice3.setIMEMode(InputSubset.LATIN);

      byPatientPrice3.setMaxLength(5);

      addByPatientPrice3();
    }
    return byPatientPrice3;

  }

  /**
   * 保険外負担分数量3行目を取得します。
   * @return 保険外負担分数量3行目
   */
  public ACTextField getByPatientNumber3(){
    if(byPatientNumber3==null){

      byPatientNumber3 = new ACTextField();

      byPatientNumber3.setBindPath("BY_PATIENT_NUMBER3");

      byPatientNumber3.setColumns(2);

      byPatientNumber3.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber3.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber3.setIMEMode(InputSubset.LATIN);

      byPatientNumber3.setMaxLength(3);

      addByPatientNumber3();
    }
    return byPatientNumber3;

  }

  /**
   * 保険外負担分金額3行目を取得します。
   * @return 保険外負担分金額3行目
   */
  public ACTextField getByPatientSum3(){
    if(byPatientSum3==null){

      byPatientSum3 = new ACTextField();

      byPatientSum3.setBindPath("BY_PATIENT_SUM3");

      byPatientSum3.setColumns(5);

      byPatientSum3.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum3.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum3.setIMEMode(InputSubset.LATIN);

      byPatientSum3.setMaxLength(8);

      addByPatientSum3();
    }
    return byPatientSum3;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget3(){
    if(byPatientTaxTarget3==null){

      byPatientTaxTarget3 = new ACIntegerCheckBox();

      byPatientTaxTarget3.setText("　");

      byPatientTaxTarget3.setBindPath("BY_PATIENT_TAX_TARGET3");

      addByPatientTaxTarget3();
    }
    return byPatientTaxTarget3;

  }

  /**
   * 保険外負担分外税3行目を取得します。
   * @return 保険外負担分外税3行目
   */
  public ACIntegerCheckBox getByPatientUseTax3(){
    if(byPatientUseTax3==null){

      byPatientUseTax3 = new ACIntegerCheckBox();

      byPatientUseTax3.setBindPath("BY_PATIENT_USE_TAX3");

      addByPatientUseTax3();
    }
    return byPatientUseTax3;

  }

  /**
   * 保険外負担分消費税等3行目を取得します。
   * @return 保険外負担分消費税等3行目
   */
  public ACTextField getByPatientTax3(){
    if(byPatientTax3==null){

      byPatientTax3 = new ACTextField();

      byPatientTax3.setBindPath("BY_PATIENT_TAX3");

      byPatientTax3.setColumns(4);

      byPatientTax3.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax3.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax3.setIMEMode(InputSubset.LATIN);

      byPatientTax3.setMaxLength(5);

      addByPatientTax3();
    }
    return byPatientTax3;

  }

  /**
   * 保険外負担分4行目を取得します。
   * @return 保険外負担分4行目
   */
  public ACPanel getByPatient4(){
    if(byPatient4==null){

      byPatient4 = new ACPanel();

      byPatient4.setAutoWrap(false);

      byPatient4.setHgap(0);

      byPatient4.setVgap(0);

      addByPatient4();
    }
    return byPatient4;

  }

  /**
   * 保険外負担分項目4行目を取得します。
   * @return 保険外負担分項目4行目
   */
  public ACComboBox getByPatientName4(){
    if(byPatientName4==null){

      byPatientName4 = new ACComboBox();

      byPatientName4.setBindPath("BY_PATIENT_NAME4");

      byPatientName4.setColumns(10);

      byPatientName4.setModelBindPath("BY_PATIENT_NAME");

      byPatientName4.setIMEMode(InputSubset.KANJI);

      byPatientName4.setMaxLength(20);

      byPatientName4.setMaxColumns(10);

      byPatientName4.setModel(getByPatientName4Model());

      addByPatientName4();
    }
    return byPatientName4;

  }

  /**
   * 保険外負担分項目4行目モデルを取得します。
   * @return 保険外負担分項目4行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName4Model(){
    if(byPatientName4Model==null){
      byPatientName4Model = new ACComboBoxModelAdapter();
      addByPatientName4Model();
    }
    return byPatientName4Model;
  }

  /**
   * 保険外負担分単価4行目を取得します。
   * @return 保険外負担分単価4行目
   */
  public ACTextField getByPatientPrice4(){
    if(byPatientPrice4==null){

      byPatientPrice4 = new ACTextField();

      byPatientPrice4.setBindPath("BY_PATIENT_PRICE4");

      byPatientPrice4.setColumns(3);

      byPatientPrice4.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice4.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice4.setIMEMode(InputSubset.LATIN);

      byPatientPrice4.setMaxLength(5);

      addByPatientPrice4();
    }
    return byPatientPrice4;

  }

  /**
   * 保険外負担分数量4行目を取得します。
   * @return 保険外負担分数量4行目
   */
  public ACTextField getByPatientNumber4(){
    if(byPatientNumber4==null){

      byPatientNumber4 = new ACTextField();

      byPatientNumber4.setBindPath("BY_PATIENT_NUMBER4");

      byPatientNumber4.setColumns(2);

      byPatientNumber4.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber4.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber4.setIMEMode(InputSubset.LATIN);

      byPatientNumber4.setMaxLength(3);

      addByPatientNumber4();
    }
    return byPatientNumber4;

  }

  /**
   * 保険外負担分金額4行目を取得します。
   * @return 保険外負担分金額4行目
   */
  public ACTextField getByPatientSum4(){
    if(byPatientSum4==null){

      byPatientSum4 = new ACTextField();

      byPatientSum4.setBindPath("BY_PATIENT_SUM4");

      byPatientSum4.setColumns(5);

      byPatientSum4.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum4.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum4.setIMEMode(InputSubset.LATIN);

      byPatientSum4.setMaxLength(8);

      addByPatientSum4();
    }
    return byPatientSum4;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget4(){
    if(byPatientTaxTarget4==null){

      byPatientTaxTarget4 = new ACIntegerCheckBox();

      byPatientTaxTarget4.setText("　");

      byPatientTaxTarget4.setBindPath("BY_PATIENT_TAX_TARGET4");

      addByPatientTaxTarget4();
    }
    return byPatientTaxTarget4;

  }

  /**
   * 保険外負担分外税4行目を取得します。
   * @return 保険外負担分外税4行目
   */
  public ACIntegerCheckBox getByPatientUseTax4(){
    if(byPatientUseTax4==null){

      byPatientUseTax4 = new ACIntegerCheckBox();

      byPatientUseTax4.setBindPath("BY_PATIENT_USE_TAX4");

      addByPatientUseTax4();
    }
    return byPatientUseTax4;

  }

  /**
   * 保険外負担分消費税等4行目を取得します。
   * @return 保険外負担分消費税等4行目
   */
  public ACTextField getByPatientTax4(){
    if(byPatientTax4==null){

      byPatientTax4 = new ACTextField();

      byPatientTax4.setBindPath("BY_PATIENT_TAX4");

      byPatientTax4.setColumns(4);

      byPatientTax4.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax4.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax4.setIMEMode(InputSubset.LATIN);

      byPatientTax4.setMaxLength(5);

      addByPatientTax4();
    }
    return byPatientTax4;

  }

  /**
   * 保険外負担分5行目を取得します。
   * @return 保険外負担分5行目
   */
  public ACPanel getByPatient5(){
    if(byPatient5==null){

      byPatient5 = new ACPanel();

      byPatient5.setAutoWrap(false);

      byPatient5.setHgap(0);

      byPatient5.setVgap(0);

      addByPatient5();
    }
    return byPatient5;

  }

  /**
   * 保険外負担分項目5行目を取得します。
   * @return 保険外負担分項目5行目
   */
  public ACComboBox getByPatientName5(){
    if(byPatientName5==null){

      byPatientName5 = new ACComboBox();

      byPatientName5.setBindPath("BY_PATIENT_NAME5");

      byPatientName5.setColumns(10);

      byPatientName5.setModelBindPath("BY_PATIENT_NAME");

      byPatientName5.setIMEMode(InputSubset.KANJI);

      byPatientName5.setMaxLength(20);

      byPatientName5.setMaxColumns(10);

      byPatientName5.setModel(getByPatientName5Model());

      addByPatientName5();
    }
    return byPatientName5;

  }

  /**
   * 保険外負担分項目5行目モデルを取得します。
   * @return 保険外負担分項目5行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName5Model(){
    if(byPatientName5Model==null){
      byPatientName5Model = new ACComboBoxModelAdapter();
      addByPatientName5Model();
    }
    return byPatientName5Model;
  }

  /**
   * 保険外負担分単価5行目を取得します。
   * @return 保険外負担分単価5行目
   */
  public ACTextField getByPatientPrice5(){
    if(byPatientPrice5==null){

      byPatientPrice5 = new ACTextField();

      byPatientPrice5.setBindPath("BY_PATIENT_PRICE5");

      byPatientPrice5.setColumns(3);

      byPatientPrice5.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice5.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice5.setIMEMode(InputSubset.LATIN);

      byPatientPrice5.setMaxLength(5);

      addByPatientPrice5();
    }
    return byPatientPrice5;

  }

  /**
   * 保険外負担分数量5行目を取得します。
   * @return 保険外負担分数量5行目
   */
  public ACTextField getByPatientNumber5(){
    if(byPatientNumber5==null){

      byPatientNumber5 = new ACTextField();

      byPatientNumber5.setBindPath("BY_PATIENT_NUMBER5");

      byPatientNumber5.setColumns(2);

      byPatientNumber5.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber5.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber5.setIMEMode(InputSubset.LATIN);

      byPatientNumber5.setMaxLength(3);

      addByPatientNumber5();
    }
    return byPatientNumber5;

  }

  /**
   * 保険外負担分金額5行目を取得します。
   * @return 保険外負担分金額5行目
   */
  public ACTextField getByPatientSum5(){
    if(byPatientSum5==null){

      byPatientSum5 = new ACTextField();

      byPatientSum5.setBindPath("BY_PATIENT_SUM5");

      byPatientSum5.setColumns(5);

      byPatientSum5.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum5.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum5.setIMEMode(InputSubset.LATIN);

      byPatientSum5.setMaxLength(8);

      addByPatientSum5();
    }
    return byPatientSum5;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget5(){
    if(byPatientTaxTarget5==null){

      byPatientTaxTarget5 = new ACIntegerCheckBox();

      byPatientTaxTarget5.setText("　");

      byPatientTaxTarget5.setBindPath("BY_PATIENT_TAX_TARGET5");

      addByPatientTaxTarget5();
    }
    return byPatientTaxTarget5;

  }

  /**
   * 保険外負担分外税5行目を取得します。
   * @return 保険外負担分外税5行目
   */
  public ACIntegerCheckBox getByPatientUseTax5(){
    if(byPatientUseTax5==null){

      byPatientUseTax5 = new ACIntegerCheckBox();

      byPatientUseTax5.setBindPath("BY_PATIENT_USE_TAX5");

      addByPatientUseTax5();
    }
    return byPatientUseTax5;

  }

  /**
   * 保険外負担分消費税等5行目を取得します。
   * @return 保険外負担分消費税等5行目
   */
  public ACTextField getByPatientTax5(){
    if(byPatientTax5==null){

      byPatientTax5 = new ACTextField();

      byPatientTax5.setBindPath("BY_PATIENT_TAX5");

      byPatientTax5.setColumns(4);

      byPatientTax5.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax5.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax5.setIMEMode(InputSubset.LATIN);

      byPatientTax5.setMaxLength(5);

      addByPatientTax5();
    }
    return byPatientTax5;

  }

  /**
   * 保険外負担分6行目を取得します。
   * @return 保険外負担分6行目
   */
  public ACPanel getByPatient6(){
    if(byPatient6==null){

      byPatient6 = new ACPanel();

      byPatient6.setAutoWrap(false);

      byPatient6.setHgap(0);

      byPatient6.setVgap(0);

      addByPatient6();
    }
    return byPatient6;

  }

  /**
   * 保険外負担分項目6行目を取得します。
   * @return 保険外負担分項目6行目
   */
  public ACComboBox getByPatientName6(){
    if(byPatientName6==null){

      byPatientName6 = new ACComboBox();

      byPatientName6.setBindPath("BY_PATIENT_NAME6");

      byPatientName6.setColumns(10);

      byPatientName6.setModelBindPath("BY_PATIENT_NAME");

      byPatientName6.setIMEMode(InputSubset.KANJI);

      byPatientName6.setMaxLength(20);

      byPatientName6.setMaxColumns(10);

      byPatientName6.setModel(getByPatientName6Model());

      addByPatientName6();
    }
    return byPatientName6;

  }

  /**
   * 保険外負担分項目6行目モデルを取得します。
   * @return 保険外負担分項目6行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName6Model(){
    if(byPatientName6Model==null){
      byPatientName6Model = new ACComboBoxModelAdapter();
      addByPatientName6Model();
    }
    return byPatientName6Model;
  }

  /**
   * 保険外負担分単価6行目を取得します。
   * @return 保険外負担分単価6行目
   */
  public ACTextField getByPatientPrice6(){
    if(byPatientPrice6==null){

      byPatientPrice6 = new ACTextField();

      byPatientPrice6.setBindPath("BY_PATIENT_PRICE6");

      byPatientPrice6.setColumns(3);

      byPatientPrice6.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice6.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice6.setIMEMode(InputSubset.LATIN);

      byPatientPrice6.setMaxLength(5);

      addByPatientPrice6();
    }
    return byPatientPrice6;

  }

  /**
   * 保険外負担分数量6行目を取得します。
   * @return 保険外負担分数量6行目
   */
  public ACTextField getByPatientNumber6(){
    if(byPatientNumber6==null){

      byPatientNumber6 = new ACTextField();

      byPatientNumber6.setBindPath("BY_PATIENT_NUMBER6");

      byPatientNumber6.setColumns(2);

      byPatientNumber6.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber6.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber6.setIMEMode(InputSubset.LATIN);

      byPatientNumber6.setMaxLength(3);

      addByPatientNumber6();
    }
    return byPatientNumber6;

  }

  /**
   * 保険外負担分金額6行目を取得します。
   * @return 保険外負担分金額6行目
   */
  public ACTextField getByPatientSum6(){
    if(byPatientSum6==null){

      byPatientSum6 = new ACTextField();

      byPatientSum6.setBindPath("BY_PATIENT_SUM6");

      byPatientSum6.setColumns(5);

      byPatientSum6.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum6.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum6.setIMEMode(InputSubset.LATIN);

      byPatientSum6.setMaxLength(8);

      addByPatientSum6();
    }
    return byPatientSum6;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget6(){
    if(byPatientTaxTarget6==null){

      byPatientTaxTarget6 = new ACIntegerCheckBox();

      byPatientTaxTarget6.setText("　");

      byPatientTaxTarget6.setBindPath("BY_PATIENT_TAX_TARGET6");

      addByPatientTaxTarget6();
    }
    return byPatientTaxTarget6;

  }

  /**
   * 保険外負担分外税6行目を取得します。
   * @return 保険外負担分外税6行目
   */
  public ACIntegerCheckBox getByPatientUseTax6(){
    if(byPatientUseTax6==null){

      byPatientUseTax6 = new ACIntegerCheckBox();

      byPatientUseTax6.setBindPath("BY_PATIENT_USE_TAX6");

      addByPatientUseTax6();
    }
    return byPatientUseTax6;

  }

  /**
   * 保険外負担分消費税等6行目を取得します。
   * @return 保険外負担分消費税等6行目
   */
  public ACTextField getByPatientTax6(){
    if(byPatientTax6==null){

      byPatientTax6 = new ACTextField();

      byPatientTax6.setBindPath("BY_PATIENT_TAX6");

      byPatientTax6.setColumns(4);

      byPatientTax6.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax6.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax6.setIMEMode(InputSubset.LATIN);

      byPatientTax6.setMaxLength(5);

      addByPatientTax6();
    }
    return byPatientTax6;

  }

  /**
   * 保険外負担分7行目を取得します。
   * @return 保険外負担分7行目
   */
  public ACPanel getByPatient7(){
    if(byPatient7==null){

      byPatient7 = new ACPanel();

      byPatient7.setAutoWrap(false);

      byPatient7.setHgap(0);

      byPatient7.setVgap(0);

      addByPatient7();
    }
    return byPatient7;

  }

  /**
   * 保険外負担分項目7行目を取得します。
   * @return 保険外負担分項目7行目
   */
  public ACComboBox getByPatientName7(){
    if(byPatientName7==null){

      byPatientName7 = new ACComboBox();

      byPatientName7.setBindPath("BY_PATIENT_NAME7");

      byPatientName7.setColumns(10);

      byPatientName7.setModelBindPath("BY_PATIENT_NAME");

      byPatientName7.setIMEMode(InputSubset.KANJI);

      byPatientName7.setMaxLength(20);

      byPatientName7.setMaxColumns(10);

      byPatientName7.setModel(getByPatientName7Model());

      addByPatientName7();
    }
    return byPatientName7;

  }

  /**
   * 保険外負担分項目7行目モデルを取得します。
   * @return 保険外負担分項目7行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName7Model(){
    if(byPatientName7Model==null){
      byPatientName7Model = new ACComboBoxModelAdapter();
      addByPatientName7Model();
    }
    return byPatientName7Model;
  }

  /**
   * 保険外負担分単価7行目を取得します。
   * @return 保険外負担分単価7行目
   */
  public ACTextField getByPatientPrice7(){
    if(byPatientPrice7==null){

      byPatientPrice7 = new ACTextField();

      byPatientPrice7.setBindPath("BY_PATIENT_PRICE7");

      byPatientPrice7.setColumns(3);

      byPatientPrice7.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice7.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice7.setIMEMode(InputSubset.LATIN);

      byPatientPrice7.setMaxLength(5);

      addByPatientPrice7();
    }
    return byPatientPrice7;

  }

  /**
   * 保険外負担分数量7行目を取得します。
   * @return 保険外負担分数量7行目
   */
  public ACTextField getByPatientNumber7(){
    if(byPatientNumber7==null){

      byPatientNumber7 = new ACTextField();

      byPatientNumber7.setBindPath("BY_PATIENT_NUMBER7");

      byPatientNumber7.setColumns(2);

      byPatientNumber7.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber7.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber7.setIMEMode(InputSubset.LATIN);

      byPatientNumber7.setMaxLength(3);

      addByPatientNumber7();
    }
    return byPatientNumber7;

  }

  /**
   * 保険外負担分金額7行目を取得します。
   * @return 保険外負担分金額7行目
   */
  public ACTextField getByPatientSum7(){
    if(byPatientSum7==null){

      byPatientSum7 = new ACTextField();

      byPatientSum7.setBindPath("BY_PATIENT_SUM7");

      byPatientSum7.setColumns(5);

      byPatientSum7.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum7.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum7.setIMEMode(InputSubset.LATIN);

      byPatientSum7.setMaxLength(8);

      addByPatientSum7();
    }
    return byPatientSum7;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget7(){
    if(byPatientTaxTarget7==null){

      byPatientTaxTarget7 = new ACIntegerCheckBox();

      byPatientTaxTarget7.setText("　");

      byPatientTaxTarget7.setBindPath("BY_PATIENT_TAX_TARGET7");

      addByPatientTaxTarget7();
    }
    return byPatientTaxTarget7;

  }

  /**
   * 保険外負担分外税7行目を取得します。
   * @return 保険外負担分外税7行目
   */
  public ACIntegerCheckBox getByPatientUseTax7(){
    if(byPatientUseTax7==null){

      byPatientUseTax7 = new ACIntegerCheckBox();

      byPatientUseTax7.setBindPath("BY_PATIENT_USE_TAX7");

      addByPatientUseTax7();
    }
    return byPatientUseTax7;

  }

  /**
   * 保険外負担分消費税等7行目を取得します。
   * @return 保険外負担分消費税等7行目
   */
  public ACTextField getByPatientTax7(){
    if(byPatientTax7==null){

      byPatientTax7 = new ACTextField();

      byPatientTax7.setBindPath("BY_PATIENT_TAX7");

      byPatientTax7.setColumns(4);

      byPatientTax7.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax7.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax7.setIMEMode(InputSubset.LATIN);

      byPatientTax7.setMaxLength(5);

      addByPatientTax7();
    }
    return byPatientTax7;

  }

  /**
   * 保険外負担分8行目を取得します。
   * @return 保険外負担分8行目
   */
  public ACPanel getByPatient8(){
    if(byPatient8==null){

      byPatient8 = new ACPanel();

      byPatient8.setAutoWrap(false);

      byPatient8.setHgap(0);

      byPatient8.setVgap(0);

      addByPatient8();
    }
    return byPatient8;

  }

  /**
   * 保険外負担分項目8行目を取得します。
   * @return 保険外負担分項目8行目
   */
  public ACComboBox getByPatientName8(){
    if(byPatientName8==null){

      byPatientName8 = new ACComboBox();

      byPatientName8.setBindPath("BY_PATIENT_NAME8");

      byPatientName8.setColumns(10);

      byPatientName8.setModelBindPath("BY_PATIENT_NAME");

      byPatientName8.setIMEMode(InputSubset.KANJI);

      byPatientName8.setMaxLength(20);

      byPatientName8.setMaxColumns(10);

      byPatientName8.setModel(getByPatientName8Model());

      addByPatientName8();
    }
    return byPatientName8;

  }

  /**
   * 保険外負担分項目8行目モデルを取得します。
   * @return 保険外負担分項目8行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName8Model(){
    if(byPatientName8Model==null){
      byPatientName8Model = new ACComboBoxModelAdapter();
      addByPatientName8Model();
    }
    return byPatientName8Model;
  }

  /**
   * 保険外負担分単価8行目を取得します。
   * @return 保険外負担分単価8行目
   */
  public ACTextField getByPatientPrice8(){
    if(byPatientPrice8==null){

      byPatientPrice8 = new ACTextField();

      byPatientPrice8.setBindPath("BY_PATIENT_PRICE8");

      byPatientPrice8.setColumns(3);

      byPatientPrice8.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice8.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice8.setIMEMode(InputSubset.LATIN);

      byPatientPrice8.setMaxLength(5);

      addByPatientPrice8();
    }
    return byPatientPrice8;

  }

  /**
   * 保険外負担分数量8行目を取得します。
   * @return 保険外負担分数量8行目
   */
  public ACTextField getByPatientNumber8(){
    if(byPatientNumber8==null){

      byPatientNumber8 = new ACTextField();

      byPatientNumber8.setBindPath("BY_PATIENT_NUMBER8");

      byPatientNumber8.setColumns(2);

      byPatientNumber8.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber8.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber8.setIMEMode(InputSubset.LATIN);

      byPatientNumber8.setMaxLength(3);

      addByPatientNumber8();
    }
    return byPatientNumber8;

  }

  /**
   * 保険外負担分金額8行目を取得します。
   * @return 保険外負担分金額8行目
   */
  public ACTextField getByPatientSum8(){
    if(byPatientSum8==null){

      byPatientSum8 = new ACTextField();

      byPatientSum8.setBindPath("BY_PATIENT_SUM8");

      byPatientSum8.setColumns(5);

      byPatientSum8.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum8.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum8.setIMEMode(InputSubset.LATIN);

      byPatientSum8.setMaxLength(8);

      addByPatientSum8();
    }
    return byPatientSum8;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget8(){
    if(byPatientTaxTarget8==null){

      byPatientTaxTarget8 = new ACIntegerCheckBox();

      byPatientTaxTarget8.setText("　");

      byPatientTaxTarget8.setBindPath("BY_PATIENT_TAX_TARGET8");

      addByPatientTaxTarget8();
    }
    return byPatientTaxTarget8;

  }

  /**
   * 保険外負担分外税8行目を取得します。
   * @return 保険外負担分外税8行目
   */
  public ACIntegerCheckBox getByPatientUseTax8(){
    if(byPatientUseTax8==null){

      byPatientUseTax8 = new ACIntegerCheckBox();

      byPatientUseTax8.setBindPath("BY_PATIENT_USE_TAX8");

      addByPatientUseTax8();
    }
    return byPatientUseTax8;

  }

  /**
   * 保険外負担分消費税等8行目を取得します。
   * @return 保険外負担分消費税等8行目
   */
  public ACTextField getByPatientTax8(){
    if(byPatientTax8==null){

      byPatientTax8 = new ACTextField();

      byPatientTax8.setBindPath("BY_PATIENT_TAX8");

      byPatientTax8.setColumns(4);

      byPatientTax8.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax8.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax8.setIMEMode(InputSubset.LATIN);

      byPatientTax8.setMaxLength(5);

      addByPatientTax8();
    }
    return byPatientTax8;

  }

  /**
   * 保険外負担分9行目を取得します。
   * @return 保険外負担分9行目
   */
  public ACPanel getByPatient9(){
    if(byPatient9==null){

      byPatient9 = new ACPanel();

      byPatient9.setAutoWrap(false);

      byPatient9.setHgap(0);

      byPatient9.setVgap(0);

      addByPatient9();
    }
    return byPatient9;

  }

  /**
   * 保険外負担分項目9行目を取得します。
   * @return 保険外負担分項目9行目
   */
  public ACComboBox getByPatientName9(){
    if(byPatientName9==null){

      byPatientName9 = new ACComboBox();

      byPatientName9.setBindPath("BY_PATIENT_NAME9");

      byPatientName9.setColumns(10);

      byPatientName9.setModelBindPath("BY_PATIENT_NAME");

      byPatientName9.setIMEMode(InputSubset.KANJI);

      byPatientName9.setMaxLength(20);

      byPatientName9.setMaxColumns(10);

      byPatientName9.setModel(getByPatientName9Model());

      addByPatientName9();
    }
    return byPatientName9;

  }

  /**
   * 保険外負担分項目9行目モデルを取得します。
   * @return 保険外負担分項目9行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName9Model(){
    if(byPatientName9Model==null){
      byPatientName9Model = new ACComboBoxModelAdapter();
      addByPatientName9Model();
    }
    return byPatientName9Model;
  }

  /**
   * 保険外負担分単価9行目を取得します。
   * @return 保険外負担分単価9行目
   */
  public ACTextField getByPatientPrice9(){
    if(byPatientPrice9==null){

      byPatientPrice9 = new ACTextField();

      byPatientPrice9.setBindPath("BY_PATIENT_PRICE9");

      byPatientPrice9.setColumns(3);

      byPatientPrice9.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice9.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice9.setIMEMode(InputSubset.LATIN);

      byPatientPrice9.setMaxLength(5);

      addByPatientPrice9();
    }
    return byPatientPrice9;

  }

  /**
   * 保険外負担分数量9行目を取得します。
   * @return 保険外負担分数量9行目
   */
  public ACTextField getByPatientNumber9(){
    if(byPatientNumber9==null){

      byPatientNumber9 = new ACTextField();

      byPatientNumber9.setBindPath("BY_PATIENT_NUMBER9");

      byPatientNumber9.setColumns(2);

      byPatientNumber9.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber9.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber9.setIMEMode(InputSubset.LATIN);

      byPatientNumber9.setMaxLength(3);

      addByPatientNumber9();
    }
    return byPatientNumber9;

  }

  /**
   * 保険外負担分金額9行目を取得します。
   * @return 保険外負担分金額9行目
   */
  public ACTextField getByPatientSum9(){
    if(byPatientSum9==null){

      byPatientSum9 = new ACTextField();

      byPatientSum9.setBindPath("BY_PATIENT_SUM9");

      byPatientSum9.setColumns(5);

      byPatientSum9.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum9.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum9.setIMEMode(InputSubset.LATIN);

      byPatientSum9.setMaxLength(8);

      addByPatientSum9();
    }
    return byPatientSum9;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget9(){
    if(byPatientTaxTarget9==null){

      byPatientTaxTarget9 = new ACIntegerCheckBox();

      byPatientTaxTarget9.setText("　");

      byPatientTaxTarget9.setBindPath("BY_PATIENT_TAX_TARGET9");

      addByPatientTaxTarget9();
    }
    return byPatientTaxTarget9;

  }

  /**
   * 保険外負担分外税9行目を取得します。
   * @return 保険外負担分外税9行目
   */
  public ACIntegerCheckBox getByPatientUseTax9(){
    if(byPatientUseTax9==null){

      byPatientUseTax9 = new ACIntegerCheckBox();

      byPatientUseTax9.setBindPath("BY_PATIENT_USE_TAX9");

      addByPatientUseTax9();
    }
    return byPatientUseTax9;

  }

  /**
   * 保険外負担分消費税等9行目を取得します。
   * @return 保険外負担分消費税等9行目
   */
  public ACTextField getByPatientTax9(){
    if(byPatientTax9==null){

      byPatientTax9 = new ACTextField();

      byPatientTax9.setBindPath("BY_PATIENT_TAX9");

      byPatientTax9.setColumns(4);

      byPatientTax9.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax9.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax9.setIMEMode(InputSubset.LATIN);

      byPatientTax9.setMaxLength(5);

      addByPatientTax9();
    }
    return byPatientTax9;

  }

  /**
   * 保険外負担分10行目を取得します。
   * @return 保険外負担分10行目
   */
  public ACPanel getByPatient10(){
    if(byPatient10==null){

      byPatient10 = new ACPanel();

      byPatient10.setAutoWrap(false);

      byPatient10.setHgap(0);

      byPatient10.setVgap(0);

      addByPatient10();
    }
    return byPatient10;

  }

  /**
   * 保険外負担分項目10行目を取得します。
   * @return 保険外負担分項目10行目
   */
  public ACComboBox getByPatientName10(){
    if(byPatientName10==null){

      byPatientName10 = new ACComboBox();

      byPatientName10.setBindPath("BY_PATIENT_NAME10");

      byPatientName10.setColumns(10);

      byPatientName10.setModelBindPath("BY_PATIENT_NAME");

      byPatientName10.setIMEMode(InputSubset.KANJI);

      byPatientName10.setMaxLength(20);

      byPatientName10.setMaxColumns(10);

      byPatientName10.setModel(getByPatientName10Model());

      addByPatientName10();
    }
    return byPatientName10;

  }

  /**
   * 保険外負担分項目10行目モデルを取得します。
   * @return 保険外負担分項目10行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName10Model(){
    if(byPatientName10Model==null){
      byPatientName10Model = new ACComboBoxModelAdapter();
      addByPatientName10Model();
    }
    return byPatientName10Model;
  }

  /**
   * 保険外負担分単価10行目を取得します。
   * @return 保険外負担分単価10行目
   */
  public ACTextField getByPatientPrice10(){
    if(byPatientPrice10==null){

      byPatientPrice10 = new ACTextField();

      byPatientPrice10.setBindPath("BY_PATIENT_PRICE10");

      byPatientPrice10.setColumns(3);

      byPatientPrice10.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice10.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice10.setIMEMode(InputSubset.LATIN);

      byPatientPrice10.setMaxLength(5);

      addByPatientPrice10();
    }
    return byPatientPrice10;

  }

  /**
   * 保険外負担分数量10行目を取得します。
   * @return 保険外負担分数量10行目
   */
  public ACTextField getByPatientNumber10(){
    if(byPatientNumber10==null){

      byPatientNumber10 = new ACTextField();

      byPatientNumber10.setBindPath("BY_PATIENT_NUMBER10");

      byPatientNumber10.setColumns(2);

      byPatientNumber10.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber10.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber10.setIMEMode(InputSubset.LATIN);

      byPatientNumber10.setMaxLength(3);

      addByPatientNumber10();
    }
    return byPatientNumber10;

  }

  /**
   * 保険外負担分金額10行目を取得します。
   * @return 保険外負担分金額10行目
   */
  public ACTextField getByPatientSum10(){
    if(byPatientSum10==null){

      byPatientSum10 = new ACTextField();

      byPatientSum10.setBindPath("BY_PATIENT_SUM10");

      byPatientSum10.setColumns(5);

      byPatientSum10.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum10.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum10.setIMEMode(InputSubset.LATIN);

      byPatientSum10.setMaxLength(8);

      addByPatientSum10();
    }
    return byPatientSum10;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget10(){
    if(byPatientTaxTarget10==null){

      byPatientTaxTarget10 = new ACIntegerCheckBox();

      byPatientTaxTarget10.setText("　");

      byPatientTaxTarget10.setBindPath("BY_PATIENT_TAX_TARGET10");

      addByPatientTaxTarget10();
    }
    return byPatientTaxTarget10;

  }

  /**
   * 保険外負担分外税10行目を取得します。
   * @return 保険外負担分外税10行目
   */
  public ACIntegerCheckBox getByPatientUseTax10(){
    if(byPatientUseTax10==null){

      byPatientUseTax10 = new ACIntegerCheckBox();

      byPatientUseTax10.setBindPath("BY_PATIENT_USE_TAX10");

      addByPatientUseTax10();
    }
    return byPatientUseTax10;

  }

  /**
   * 保険外負担分消費税等10行目を取得します。
   * @return 保険外負担分消費税等10行目
   */
  public ACTextField getByPatientTax10(){
    if(byPatientTax10==null){

      byPatientTax10 = new ACTextField();

      byPatientTax10.setBindPath("BY_PATIENT_TAX10");

      byPatientTax10.setColumns(4);

      byPatientTax10.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax10.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax10.setIMEMode(InputSubset.LATIN);

      byPatientTax10.setMaxLength(5);

      addByPatientTax10();
    }
    return byPatientTax10;

  }

  /**
   * 保険外負担分11行目を取得します。
   * @return 保険外負担分11行目
   */
  public ACPanel getByPatient11(){
    if(byPatient11==null){

      byPatient11 = new ACPanel();

      byPatient11.setAutoWrap(false);

      byPatient11.setHgap(0);

      byPatient11.setVgap(0);

      addByPatient11();
    }
    return byPatient11;

  }

  /**
   * 保険外負担分項目11行目を取得します。
   * @return 保険外負担分項目11行目
   */
  public ACComboBox getByPatientName11(){
    if(byPatientName11==null){

      byPatientName11 = new ACComboBox();

      byPatientName11.setBindPath("BY_PATIENT_NAME11");

      byPatientName11.setColumns(10);

      byPatientName11.setModelBindPath("BY_PATIENT_NAME");

      byPatientName11.setIMEMode(InputSubset.KANJI);

      byPatientName11.setMaxLength(20);

      byPatientName11.setMaxColumns(10);

      byPatientName11.setModel(getByPatientName11Model());

      addByPatientName11();
    }
    return byPatientName11;

  }

  /**
   * 保険外負担分項目11行目モデルを取得します。
   * @return 保険外負担分項目11行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName11Model(){
    if(byPatientName11Model==null){
      byPatientName11Model = new ACComboBoxModelAdapter();
      addByPatientName11Model();
    }
    return byPatientName11Model;
  }

  /**
   * 保険外負担分単価11行目を取得します。
   * @return 保険外負担分単価11行目
   */
  public ACTextField getByPatientPrice11(){
    if(byPatientPrice11==null){

      byPatientPrice11 = new ACTextField();

      byPatientPrice11.setBindPath("BY_PATIENT_PRICE11");

      byPatientPrice11.setColumns(3);

      byPatientPrice11.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice11.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice11.setIMEMode(InputSubset.LATIN);

      byPatientPrice11.setMaxLength(5);

      addByPatientPrice11();
    }
    return byPatientPrice11;

  }

  /**
   * 保険外負担分数量11行目を取得します。
   * @return 保険外負担分数量11行目
   */
  public ACTextField getByPatientNumber11(){
    if(byPatientNumber11==null){

      byPatientNumber11 = new ACTextField();

      byPatientNumber11.setBindPath("BY_PATIENT_NUMBER11");

      byPatientNumber11.setColumns(2);

      byPatientNumber11.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber11.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber11.setIMEMode(InputSubset.LATIN);

      byPatientNumber11.setMaxLength(3);

      addByPatientNumber11();
    }
    return byPatientNumber11;

  }

  /**
   * 保険外負担分金額11行目を取得します。
   * @return 保険外負担分金額11行目
   */
  public ACTextField getByPatientSum11(){
    if(byPatientSum11==null){

      byPatientSum11 = new ACTextField();

      byPatientSum11.setBindPath("BY_PATIENT_SUM11");

      byPatientSum11.setColumns(5);

      byPatientSum11.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum11.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum11.setIMEMode(InputSubset.LATIN);

      byPatientSum11.setMaxLength(8);

      addByPatientSum11();
    }
    return byPatientSum11;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget11(){
    if(byPatientTaxTarget11==null){

      byPatientTaxTarget11 = new ACIntegerCheckBox();

      byPatientTaxTarget11.setText("　");

      byPatientTaxTarget11.setBindPath("BY_PATIENT_TAX_TARGET11");

      addByPatientTaxTarget11();
    }
    return byPatientTaxTarget11;

  }

  /**
   * 保険外負担分外税11行目を取得します。
   * @return 保険外負担分外税11行目
   */
  public ACIntegerCheckBox getByPatientUseTax11(){
    if(byPatientUseTax11==null){

      byPatientUseTax11 = new ACIntegerCheckBox();

      byPatientUseTax11.setBindPath("BY_PATIENT_USE_TAX11");

      addByPatientUseTax11();
    }
    return byPatientUseTax11;

  }

  /**
   * 保険外負担分消費税等11行目を取得します。
   * @return 保険外負担分消費税等11行目
   */
  public ACTextField getByPatientTax11(){
    if(byPatientTax11==null){

      byPatientTax11 = new ACTextField();

      byPatientTax11.setBindPath("BY_PATIENT_TAX11");

      byPatientTax11.setColumns(4);

      byPatientTax11.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax11.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax11.setIMEMode(InputSubset.LATIN);

      byPatientTax11.setMaxLength(5);

      addByPatientTax11();
    }
    return byPatientTax11;

  }

  /**
   * 保険外負担分12行目を取得します。
   * @return 保険外負担分12行目
   */
  public ACPanel getByPatient12(){
    if(byPatient12==null){

      byPatient12 = new ACPanel();

      byPatient12.setAutoWrap(false);

      byPatient12.setHgap(0);

      byPatient12.setVgap(0);

      addByPatient12();
    }
    return byPatient12;

  }

  /**
   * 保険外負担分項目12行目を取得します。
   * @return 保険外負担分項目12行目
   */
  public ACComboBox getByPatientName12(){
    if(byPatientName12==null){

      byPatientName12 = new ACComboBox();

      byPatientName12.setBindPath("BY_PATIENT_NAME12");

      byPatientName12.setColumns(10);

      byPatientName12.setModelBindPath("BY_PATIENT_NAME");

      byPatientName12.setIMEMode(InputSubset.KANJI);

      byPatientName12.setMaxLength(20);

      byPatientName12.setMaxColumns(10);

      byPatientName12.setModel(getByPatientName12Model());

      addByPatientName12();
    }
    return byPatientName12;

  }

  /**
   * 保険外負担分項目12行目モデルを取得します。
   * @return 保険外負担分項目12行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName12Model(){
    if(byPatientName12Model==null){
      byPatientName12Model = new ACComboBoxModelAdapter();
      addByPatientName12Model();
    }
    return byPatientName12Model;
  }

  /**
   * 保険外負担分単価12行目を取得します。
   * @return 保険外負担分単価12行目
   */
  public ACTextField getByPatientPrice12(){
    if(byPatientPrice12==null){

      byPatientPrice12 = new ACTextField();

      byPatientPrice12.setBindPath("BY_PATIENT_PRICE12");

      byPatientPrice12.setColumns(3);

      byPatientPrice12.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice12.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice12.setIMEMode(InputSubset.LATIN);

      byPatientPrice12.setMaxLength(5);

      addByPatientPrice12();
    }
    return byPatientPrice12;

  }

  /**
   * 保険外負担分数量12行目を取得します。
   * @return 保険外負担分数量12行目
   */
  public ACTextField getByPatientNumber12(){
    if(byPatientNumber12==null){

      byPatientNumber12 = new ACTextField();

      byPatientNumber12.setBindPath("BY_PATIENT_NUMBER12");

      byPatientNumber12.setColumns(2);

      byPatientNumber12.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber12.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber12.setIMEMode(InputSubset.LATIN);

      byPatientNumber12.setMaxLength(3);

      addByPatientNumber12();
    }
    return byPatientNumber12;

  }

  /**
   * 保険外負担分金額12行目を取得します。
   * @return 保険外負担分金額12行目
   */
  public ACTextField getByPatientSum12(){
    if(byPatientSum12==null){

      byPatientSum12 = new ACTextField();

      byPatientSum12.setBindPath("BY_PATIENT_SUM12");

      byPatientSum12.setColumns(5);

      byPatientSum12.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum12.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum12.setIMEMode(InputSubset.LATIN);

      byPatientSum12.setMaxLength(8);

      addByPatientSum12();
    }
    return byPatientSum12;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget12(){
    if(byPatientTaxTarget12==null){

      byPatientTaxTarget12 = new ACIntegerCheckBox();

      byPatientTaxTarget12.setText("　");

      byPatientTaxTarget12.setBindPath("BY_PATIENT_TAX_TARGET12");

      addByPatientTaxTarget12();
    }
    return byPatientTaxTarget12;

  }

  /**
   * 保険外負担分外税12行目を取得します。
   * @return 保険外負担分外税12行目
   */
  public ACIntegerCheckBox getByPatientUseTax12(){
    if(byPatientUseTax12==null){

      byPatientUseTax12 = new ACIntegerCheckBox();

      byPatientUseTax12.setBindPath("BY_PATIENT_USE_TAX12");

      addByPatientUseTax12();
    }
    return byPatientUseTax12;

  }

  /**
   * 保険外負担分消費税等12行目を取得します。
   * @return 保険外負担分消費税等12行目
   */
  public ACTextField getByPatientTax12(){
    if(byPatientTax12==null){

      byPatientTax12 = new ACTextField();

      byPatientTax12.setBindPath("BY_PATIENT_TAX12");

      byPatientTax12.setColumns(4);

      byPatientTax12.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax12.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax12.setIMEMode(InputSubset.LATIN);

      byPatientTax12.setMaxLength(5);

      addByPatientTax12();
    }
    return byPatientTax12;

  }

  /**
   * 保険外負担分13行目を取得します。
   * @return 保険外負担分13行目
   */
  public ACPanel getByPatient13(){
    if(byPatient13==null){

      byPatient13 = new ACPanel();

      byPatient13.setAutoWrap(false);

      byPatient13.setHgap(0);

      byPatient13.setVgap(0);

      addByPatient13();
    }
    return byPatient13;

  }

  /**
   * 保険外負担分項目13行目を取得します。
   * @return 保険外負担分項目13行目
   */
  public ACComboBox getByPatientName13(){
    if(byPatientName13==null){

      byPatientName13 = new ACComboBox();

      byPatientName13.setBindPath("BY_PATIENT_NAME13");

      byPatientName13.setColumns(10);

      byPatientName13.setModelBindPath("BY_PATIENT_NAME");

      byPatientName13.setIMEMode(InputSubset.KANJI);

      byPatientName13.setMaxLength(20);

      byPatientName13.setMaxColumns(10);

      byPatientName13.setModel(getByPatientName13Model());

      addByPatientName13();
    }
    return byPatientName13;

  }

  /**
   * 保険外負担分項目13行目モデルを取得します。
   * @return 保険外負担分項目13行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName13Model(){
    if(byPatientName13Model==null){
      byPatientName13Model = new ACComboBoxModelAdapter();
      addByPatientName13Model();
    }
    return byPatientName13Model;
  }

  /**
   * 保険外負担分単価13行目を取得します。
   * @return 保険外負担分単価13行目
   */
  public ACTextField getByPatientPrice13(){
    if(byPatientPrice13==null){

      byPatientPrice13 = new ACTextField();

      byPatientPrice13.setBindPath("BY_PATIENT_PRICE13");

      byPatientPrice13.setColumns(3);

      byPatientPrice13.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice13.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice13.setIMEMode(InputSubset.LATIN);

      byPatientPrice13.setMaxLength(5);

      addByPatientPrice13();
    }
    return byPatientPrice13;

  }

  /**
   * 保険外負担分数量13行目を取得します。
   * @return 保険外負担分数量13行目
   */
  public ACTextField getByPatientNumber13(){
    if(byPatientNumber13==null){

      byPatientNumber13 = new ACTextField();

      byPatientNumber13.setBindPath("BY_PATIENT_NUMBER13");

      byPatientNumber13.setColumns(2);

      byPatientNumber13.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber13.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber13.setIMEMode(InputSubset.LATIN);

      byPatientNumber13.setMaxLength(3);

      addByPatientNumber13();
    }
    return byPatientNumber13;

  }

  /**
   * 保険外負担分金額13行目を取得します。
   * @return 保険外負担分金額13行目
   */
  public ACTextField getByPatientSum13(){
    if(byPatientSum13==null){

      byPatientSum13 = new ACTextField();

      byPatientSum13.setBindPath("BY_PATIENT_SUM13");

      byPatientSum13.setColumns(5);

      byPatientSum13.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum13.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum13.setIMEMode(InputSubset.LATIN);

      byPatientSum13.setMaxLength(8);

      addByPatientSum13();
    }
    return byPatientSum13;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget13(){
    if(byPatientTaxTarget13==null){

      byPatientTaxTarget13 = new ACIntegerCheckBox();

      byPatientTaxTarget13.setText("　");

      byPatientTaxTarget13.setBindPath("BY_PATIENT_TAX_TARGET13");

      addByPatientTaxTarget13();
    }
    return byPatientTaxTarget13;

  }

  /**
   * 保険外負担分外税13行目を取得します。
   * @return 保険外負担分外税13行目
   */
  public ACIntegerCheckBox getByPatientUseTax13(){
    if(byPatientUseTax13==null){

      byPatientUseTax13 = new ACIntegerCheckBox();

      byPatientUseTax13.setBindPath("BY_PATIENT_USE_TAX13");

      addByPatientUseTax13();
    }
    return byPatientUseTax13;

  }

  /**
   * 保険外負担分消費税等13行目を取得します。
   * @return 保険外負担分消費税等13行目
   */
  public ACTextField getByPatientTax13(){
    if(byPatientTax13==null){

      byPatientTax13 = new ACTextField();

      byPatientTax13.setBindPath("BY_PATIENT_TAX13");

      byPatientTax13.setColumns(4);

      byPatientTax13.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax13.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax13.setIMEMode(InputSubset.LATIN);

      byPatientTax13.setMaxLength(5);

      addByPatientTax13();
    }
    return byPatientTax13;

  }

  /**
   * 保険外負担分14行目を取得します。
   * @return 保険外負担分14行目
   */
  public ACPanel getByPatient14(){
    if(byPatient14==null){

      byPatient14 = new ACPanel();

      byPatient14.setAutoWrap(false);

      byPatient14.setHgap(0);

      byPatient14.setVgap(0);

      addByPatient14();
    }
    return byPatient14;

  }

  /**
   * 保険外負担分項目14行目を取得します。
   * @return 保険外負担分項目14行目
   */
  public ACComboBox getByPatientName14(){
    if(byPatientName14==null){

      byPatientName14 = new ACComboBox();

      byPatientName14.setBindPath("BY_PATIENT_NAME14");

      byPatientName14.setColumns(10);

      byPatientName14.setModelBindPath("BY_PATIENT_NAME");

      byPatientName14.setIMEMode(InputSubset.KANJI);

      byPatientName14.setMaxLength(20);

      byPatientName14.setMaxColumns(10);

      byPatientName14.setModel(getByPatientName14Model());

      addByPatientName14();
    }
    return byPatientName14;

  }

  /**
   * 保険外負担分項目14行目モデルを取得します。
   * @return 保険外負担分項目14行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName14Model(){
    if(byPatientName14Model==null){
      byPatientName14Model = new ACComboBoxModelAdapter();
      addByPatientName14Model();
    }
    return byPatientName14Model;
  }

  /**
   * 保険外負担分単価14行目を取得します。
   * @return 保険外負担分単価14行目
   */
  public ACTextField getByPatientPrice14(){
    if(byPatientPrice14==null){

      byPatientPrice14 = new ACTextField();

      byPatientPrice14.setBindPath("BY_PATIENT_PRICE14");

      byPatientPrice14.setColumns(3);

      byPatientPrice14.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice14.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice14.setIMEMode(InputSubset.LATIN);

      byPatientPrice14.setMaxLength(5);

      addByPatientPrice14();
    }
    return byPatientPrice14;

  }

  /**
   * 保険外負担分数量14行目を取得します。
   * @return 保険外負担分数量14行目
   */
  public ACTextField getByPatientNumber14(){
    if(byPatientNumber14==null){

      byPatientNumber14 = new ACTextField();

      byPatientNumber14.setBindPath("BY_PATIENT_NUMBER14");

      byPatientNumber14.setColumns(2);

      byPatientNumber14.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber14.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber14.setIMEMode(InputSubset.LATIN);

      byPatientNumber14.setMaxLength(3);

      addByPatientNumber14();
    }
    return byPatientNumber14;

  }

  /**
   * 保険外負担分金額14行目を取得します。
   * @return 保険外負担分金額14行目
   */
  public ACTextField getByPatientSum14(){
    if(byPatientSum14==null){

      byPatientSum14 = new ACTextField();

      byPatientSum14.setBindPath("BY_PATIENT_SUM14");

      byPatientSum14.setColumns(5);

      byPatientSum14.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum14.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum14.setIMEMode(InputSubset.LATIN);

      byPatientSum14.setMaxLength(8);

      addByPatientSum14();
    }
    return byPatientSum14;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget14(){
    if(byPatientTaxTarget14==null){

      byPatientTaxTarget14 = new ACIntegerCheckBox();

      byPatientTaxTarget14.setText("　");

      byPatientTaxTarget14.setBindPath("BY_PATIENT_TAX_TARGET14");

      addByPatientTaxTarget14();
    }
    return byPatientTaxTarget14;

  }

  /**
   * 保険外負担分外税14行目を取得します。
   * @return 保険外負担分外税14行目
   */
  public ACIntegerCheckBox getByPatientUseTax14(){
    if(byPatientUseTax14==null){

      byPatientUseTax14 = new ACIntegerCheckBox();

      byPatientUseTax14.setBindPath("BY_PATIENT_USE_TAX14");

      addByPatientUseTax14();
    }
    return byPatientUseTax14;

  }

  /**
   * 保険外負担分消費税等14行目を取得します。
   * @return 保険外負担分消費税等14行目
   */
  public ACTextField getByPatientTax14(){
    if(byPatientTax14==null){

      byPatientTax14 = new ACTextField();

      byPatientTax14.setBindPath("BY_PATIENT_TAX14");

      byPatientTax14.setColumns(4);

      byPatientTax14.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax14.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax14.setIMEMode(InputSubset.LATIN);

      byPatientTax14.setMaxLength(5);

      addByPatientTax14();
    }
    return byPatientTax14;

  }

  /**
   * 保険外負担分15行目を取得します。
   * @return 保険外負担分15行目
   */
  public ACPanel getByPatient15(){
    if(byPatient15==null){

      byPatient15 = new ACPanel();

      byPatient15.setAutoWrap(false);

      byPatient15.setHgap(0);

      byPatient15.setVgap(0);

      addByPatient15();
    }
    return byPatient15;

  }

  /**
   * 保険外負担分項目15行目を取得します。
   * @return 保険外負担分項目15行目
   */
  public ACComboBox getByPatientName15(){
    if(byPatientName15==null){

      byPatientName15 = new ACComboBox();

      byPatientName15.setBindPath("BY_PATIENT_NAME15");

      byPatientName15.setColumns(10);

      byPatientName15.setModelBindPath("BY_PATIENT_NAME");

      byPatientName15.setIMEMode(InputSubset.KANJI);

      byPatientName15.setMaxLength(20);

      byPatientName15.setMaxColumns(10);

      byPatientName15.setModel(getByPatientName15Model());

      addByPatientName15();
    }
    return byPatientName15;

  }

  /**
   * 保険外負担分項目15行目モデルを取得します。
   * @return 保険外負担分項目15行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName15Model(){
    if(byPatientName15Model==null){
      byPatientName15Model = new ACComboBoxModelAdapter();
      addByPatientName15Model();
    }
    return byPatientName15Model;
  }

  /**
   * 保険外負担分単価15行目を取得します。
   * @return 保険外負担分単価15行目
   */
  public ACTextField getByPatientPrice15(){
    if(byPatientPrice15==null){

      byPatientPrice15 = new ACTextField();

      byPatientPrice15.setBindPath("BY_PATIENT_PRICE15");

      byPatientPrice15.setColumns(3);

      byPatientPrice15.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice15.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice15.setIMEMode(InputSubset.LATIN);

      byPatientPrice15.setMaxLength(5);

      addByPatientPrice15();
    }
    return byPatientPrice15;

  }

  /**
   * 保険外負担分数量15行目を取得します。
   * @return 保険外負担分数量15行目
   */
  public ACTextField getByPatientNumber15(){
    if(byPatientNumber15==null){

      byPatientNumber15 = new ACTextField();

      byPatientNumber15.setBindPath("BY_PATIENT_NUMBER15");

      byPatientNumber15.setColumns(2);

      byPatientNumber15.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber15.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber15.setIMEMode(InputSubset.LATIN);

      byPatientNumber15.setMaxLength(3);

      addByPatientNumber15();
    }
    return byPatientNumber15;

  }

  /**
   * 保険外負担分金額15行目を取得します。
   * @return 保険外負担分金額15行目
   */
  public ACTextField getByPatientSum15(){
    if(byPatientSum15==null){

      byPatientSum15 = new ACTextField();

      byPatientSum15.setBindPath("BY_PATIENT_SUM15");

      byPatientSum15.setColumns(5);

      byPatientSum15.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum15.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum15.setIMEMode(InputSubset.LATIN);

      byPatientSum15.setMaxLength(8);

      addByPatientSum15();
    }
    return byPatientSum15;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget15(){
    if(byPatientTaxTarget15==null){

      byPatientTaxTarget15 = new ACIntegerCheckBox();

      byPatientTaxTarget15.setText("　");

      byPatientTaxTarget15.setBindPath("BY_PATIENT_TAX_TARGET15");

      addByPatientTaxTarget15();
    }
    return byPatientTaxTarget15;

  }

  /**
   * 保険外負担分外税15行目を取得します。
   * @return 保険外負担分外税15行目
   */
  public ACIntegerCheckBox getByPatientUseTax15(){
    if(byPatientUseTax15==null){

      byPatientUseTax15 = new ACIntegerCheckBox();

      byPatientUseTax15.setBindPath("BY_PATIENT_USE_TAX15");

      addByPatientUseTax15();
    }
    return byPatientUseTax15;

  }

  /**
   * 保険外負担分消費税等15行目を取得します。
   * @return 保険外負担分消費税等15行目
   */
  public ACTextField getByPatientTax15(){
    if(byPatientTax15==null){

      byPatientTax15 = new ACTextField();

      byPatientTax15.setBindPath("BY_PATIENT_TAX15");

      byPatientTax15.setColumns(4);

      byPatientTax15.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax15.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax15.setIMEMode(InputSubset.LATIN);

      byPatientTax15.setMaxLength(5);

      addByPatientTax15();
    }
    return byPatientTax15;

  }

  /**
   * 保険外負担分16行目を取得します。
   * @return 保険外負担分16行目
   */
  public ACPanel getByPatient16(){
    if(byPatient16==null){

      byPatient16 = new ACPanel();

      byPatient16.setAutoWrap(false);

      byPatient16.setHgap(0);

      byPatient16.setVgap(0);

      addByPatient16();
    }
    return byPatient16;

  }

  /**
   * 保険外負担分項目16行目を取得します。
   * @return 保険外負担分項目16行目
   */
  public ACComboBox getByPatientName16(){
    if(byPatientName16==null){

      byPatientName16 = new ACComboBox();

      byPatientName16.setBindPath("BY_PATIENT_NAME16");

      byPatientName16.setColumns(10);

      byPatientName16.setModelBindPath("BY_PATIENT_NAME");

      byPatientName16.setIMEMode(InputSubset.KANJI);

      byPatientName16.setMaxLength(20);

      byPatientName16.setMaxColumns(10);

      byPatientName16.setModel(getByPatientName16Model());

      addByPatientName16();
    }
    return byPatientName16;

  }

  /**
   * 保険外負担分項目16行目モデルを取得します。
   * @return 保険外負担分項目16行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName16Model(){
    if(byPatientName16Model==null){
      byPatientName16Model = new ACComboBoxModelAdapter();
      addByPatientName16Model();
    }
    return byPatientName16Model;
  }

  /**
   * 保険外負担分単価16行目を取得します。
   * @return 保険外負担分単価16行目
   */
  public ACTextField getByPatientPrice16(){
    if(byPatientPrice16==null){

      byPatientPrice16 = new ACTextField();

      byPatientPrice16.setBindPath("BY_PATIENT_PRICE16");

      byPatientPrice16.setColumns(3);

      byPatientPrice16.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice16.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice16.setIMEMode(InputSubset.LATIN);

      byPatientPrice16.setMaxLength(5);

      addByPatientPrice16();
    }
    return byPatientPrice16;

  }

  /**
   * 保険外負担分数量16行目を取得します。
   * @return 保険外負担分数量16行目
   */
  public ACTextField getByPatientNumber16(){
    if(byPatientNumber16==null){

      byPatientNumber16 = new ACTextField();

      byPatientNumber16.setBindPath("BY_PATIENT_NUMBER16");

      byPatientNumber16.setColumns(2);

      byPatientNumber16.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber16.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber16.setIMEMode(InputSubset.LATIN);

      byPatientNumber16.setMaxLength(3);

      addByPatientNumber16();
    }
    return byPatientNumber16;

  }

  /**
   * 保険外負担分金額16行目を取得します。
   * @return 保険外負担分金額16行目
   */
  public ACTextField getByPatientSum16(){
    if(byPatientSum16==null){

      byPatientSum16 = new ACTextField();

      byPatientSum16.setBindPath("BY_PATIENT_SUM16");

      byPatientSum16.setColumns(5);

      byPatientSum16.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum16.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum16.setIMEMode(InputSubset.LATIN);

      byPatientSum16.setMaxLength(8);

      addByPatientSum16();
    }
    return byPatientSum16;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget16(){
    if(byPatientTaxTarget16==null){

      byPatientTaxTarget16 = new ACIntegerCheckBox();

      byPatientTaxTarget16.setText("　");

      byPatientTaxTarget16.setBindPath("BY_PATIENT_TAX_TARGET16");

      addByPatientTaxTarget16();
    }
    return byPatientTaxTarget16;

  }

  /**
   * 保険外負担分税16行目を取得します。
   * @return 保険外負担分税16行目
   */
  public ACIntegerCheckBox getByPatientUseTax16(){
    if(byPatientUseTax16==null){

      byPatientUseTax16 = new ACIntegerCheckBox();

      byPatientUseTax16.setBindPath("BY_PATIENT_USE_TAX16");

      addByPatientUseTax16();
    }
    return byPatientUseTax16;

  }

  /**
   * 保険外負担分消費税等16行目を取得します。
   * @return 保険外負担分消費税等16行目
   */
  public ACTextField getByPatientTax16(){
    if(byPatientTax16==null){

      byPatientTax16 = new ACTextField();

      byPatientTax16.setBindPath("BY_PATIENT_TAX16");

      byPatientTax16.setColumns(4);

      byPatientTax16.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax16.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax16.setIMEMode(InputSubset.LATIN);

      byPatientTax16.setMaxLength(5);

      addByPatientTax16();
    }
    return byPatientTax16;

  }

  /**
   * 保険外負担分17行目を取得します。
   * @return 保険外負担分17行目
   */
  public ACPanel getByPatient17(){
    if(byPatient17==null){

      byPatient17 = new ACPanel();

      byPatient17.setAutoWrap(false);

      byPatient17.setHgap(0);

      byPatient17.setVgap(0);

      addByPatient17();
    }
    return byPatient17;

  }

  /**
   * 保険外負担分項目17行目を取得します。
   * @return 保険外負担分項目17行目
   */
  public ACComboBox getByPatientName17(){
    if(byPatientName17==null){

      byPatientName17 = new ACComboBox();

      byPatientName17.setBindPath("BY_PATIENT_NAME17");

      byPatientName17.setColumns(10);

      byPatientName17.setModelBindPath("BY_PATIENT_NAME");

      byPatientName17.setIMEMode(InputSubset.KANJI);

      byPatientName17.setMaxLength(20);

      byPatientName17.setMaxColumns(10);

      byPatientName17.setModel(getByPatientName17Model());

      addByPatientName17();
    }
    return byPatientName17;

  }

  /**
   * 保険外負担分項目17行目モデルを取得します。
   * @return 保険外負担分項目17行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName17Model(){
    if(byPatientName17Model==null){
      byPatientName17Model = new ACComboBoxModelAdapter();
      addByPatientName17Model();
    }
    return byPatientName17Model;
  }

  /**
   * 保険外負担分単価17行目を取得します。
   * @return 保険外負担分単価17行目
   */
  public ACTextField getByPatientPrice17(){
    if(byPatientPrice17==null){

      byPatientPrice17 = new ACTextField();

      byPatientPrice17.setBindPath("BY_PATIENT_PRICE17");

      byPatientPrice17.setColumns(3);

      byPatientPrice17.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice17.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice17.setIMEMode(InputSubset.LATIN);

      byPatientPrice17.setMaxLength(5);

      addByPatientPrice17();
    }
    return byPatientPrice17;

  }

  /**
   * 保険外負担分数量17行目を取得します。
   * @return 保険外負担分数量17行目
   */
  public ACTextField getByPatientNumber17(){
    if(byPatientNumber17==null){

      byPatientNumber17 = new ACTextField();

      byPatientNumber17.setBindPath("BY_PATIENT_NUMBER17");

      byPatientNumber17.setColumns(2);

      byPatientNumber17.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber17.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber17.setIMEMode(InputSubset.LATIN);

      byPatientNumber17.setMaxLength(3);

      addByPatientNumber17();
    }
    return byPatientNumber17;

  }

  /**
   * 保険外負担分金額17行目を取得します。
   * @return 保険外負担分金額17行目
   */
  public ACTextField getByPatientSum17(){
    if(byPatientSum17==null){

      byPatientSum17 = new ACTextField();

      byPatientSum17.setBindPath("BY_PATIENT_SUM17");

      byPatientSum17.setColumns(5);

      byPatientSum17.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum17.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum17.setIMEMode(InputSubset.LATIN);

      byPatientSum17.setMaxLength(8);

      addByPatientSum17();
    }
    return byPatientSum17;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget17(){
    if(byPatientTaxTarget17==null){

      byPatientTaxTarget17 = new ACIntegerCheckBox();

      byPatientTaxTarget17.setText("　");

      byPatientTaxTarget17.setBindPath("BY_PATIENT_TAX_TARGET17");

      addByPatientTaxTarget17();
    }
    return byPatientTaxTarget17;

  }

  /**
   * 保険外負担分外税17行目を取得します。
   * @return 保険外負担分外税17行目
   */
  public ACIntegerCheckBox getByPatientUseTax17(){
    if(byPatientUseTax17==null){

      byPatientUseTax17 = new ACIntegerCheckBox();

      byPatientUseTax17.setBindPath("BY_PATIENT_USE_TAX17");

      addByPatientUseTax17();
    }
    return byPatientUseTax17;

  }

  /**
   * 保険外負担分消費税等17行目を取得します。
   * @return 保険外負担分消費税等17行目
   */
  public ACTextField getByPatientTax17(){
    if(byPatientTax17==null){

      byPatientTax17 = new ACTextField();

      byPatientTax17.setBindPath("BY_PATIENT_TAX17");

      byPatientTax17.setColumns(4);

      byPatientTax17.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax17.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax17.setIMEMode(InputSubset.LATIN);

      byPatientTax17.setMaxLength(5);

      addByPatientTax17();
    }
    return byPatientTax17;

  }

  /**
   * 保険外負担分18行目を取得します。
   * @return 保険外負担分18行目
   */
  public ACPanel getByPatient18(){
    if(byPatient18==null){

      byPatient18 = new ACPanel();

      byPatient18.setAutoWrap(false);

      byPatient18.setHgap(0);

      byPatient18.setVgap(0);

      addByPatient18();
    }
    return byPatient18;

  }

  /**
   * 保険外負担分項目18行目を取得します。
   * @return 保険外負担分項目18行目
   */
  public ACComboBox getByPatientName18(){
    if(byPatientName18==null){

      byPatientName18 = new ACComboBox();

      byPatientName18.setBindPath("BY_PATIENT_NAME18");

      byPatientName18.setColumns(10);

      byPatientName18.setModelBindPath("BY_PATIENT_NAME");

      byPatientName18.setIMEMode(InputSubset.KANJI);

      byPatientName18.setMaxLength(20);

      byPatientName18.setMaxColumns(10);

      byPatientName18.setModel(getByPatientName18Model());

      addByPatientName18();
    }
    return byPatientName18;

  }

  /**
   * 保険外負担分項目18行目モデルを取得します。
   * @return 保険外負担分項目18行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName18Model(){
    if(byPatientName18Model==null){
      byPatientName18Model = new ACComboBoxModelAdapter();
      addByPatientName18Model();
    }
    return byPatientName18Model;
  }

  /**
   * 保険外負担分単価18行目を取得します。
   * @return 保険外負担分単価18行目
   */
  public ACTextField getByPatientPrice18(){
    if(byPatientPrice18==null){

      byPatientPrice18 = new ACTextField();

      byPatientPrice18.setBindPath("BY_PATIENT_PRICE18");

      byPatientPrice18.setColumns(3);

      byPatientPrice18.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice18.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice18.setIMEMode(InputSubset.LATIN);

      byPatientPrice18.setMaxLength(5);

      addByPatientPrice18();
    }
    return byPatientPrice18;

  }

  /**
   * 保険外負担分数量18行目を取得します。
   * @return 保険外負担分数量18行目
   */
  public ACTextField getByPatientNumber18(){
    if(byPatientNumber18==null){

      byPatientNumber18 = new ACTextField();

      byPatientNumber18.setBindPath("BY_PATIENT_NUMBER18");

      byPatientNumber18.setColumns(2);

      byPatientNumber18.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber18.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber18.setIMEMode(InputSubset.LATIN);

      byPatientNumber18.setMaxLength(3);

      addByPatientNumber18();
    }
    return byPatientNumber18;

  }

  /**
   * 保険外負担分金額18行目を取得します。
   * @return 保険外負担分金額18行目
   */
  public ACTextField getByPatientSum18(){
    if(byPatientSum18==null){

      byPatientSum18 = new ACTextField();

      byPatientSum18.setBindPath("BY_PATIENT_SUM18");

      byPatientSum18.setColumns(5);

      byPatientSum18.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum18.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum18.setIMEMode(InputSubset.LATIN);

      byPatientSum18.setMaxLength(8);

      addByPatientSum18();
    }
    return byPatientSum18;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget18(){
    if(byPatientTaxTarget18==null){

      byPatientTaxTarget18 = new ACIntegerCheckBox();

      byPatientTaxTarget18.setText("　");

      byPatientTaxTarget18.setBindPath("BY_PATIENT_TAX_TARGET18");

      addByPatientTaxTarget18();
    }
    return byPatientTaxTarget18;

  }

  /**
   * 保険外負担分外税18行目を取得します。
   * @return 保険外負担分外税18行目
   */
  public ACIntegerCheckBox getByPatientUseTax18(){
    if(byPatientUseTax18==null){

      byPatientUseTax18 = new ACIntegerCheckBox();

      byPatientUseTax18.setBindPath("BY_PATIENT_USE_TAX18");

      addByPatientUseTax18();
    }
    return byPatientUseTax18;

  }

  /**
   * 保険外負担分消費税等18行目を取得します。
   * @return 保険外負担分消費税等18行目
   */
  public ACTextField getByPatientTax18(){
    if(byPatientTax18==null){

      byPatientTax18 = new ACTextField();

      byPatientTax18.setBindPath("BY_PATIENT_TAX18");

      byPatientTax18.setColumns(4);

      byPatientTax18.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax18.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax18.setIMEMode(InputSubset.LATIN);

      byPatientTax18.setMaxLength(5);

      addByPatientTax18();
    }
    return byPatientTax18;

  }

  /**
   * 保険外負担分19行目を取得します。
   * @return 保険外負担分19行目
   */
  public ACPanel getByPatient19(){
    if(byPatient19==null){

      byPatient19 = new ACPanel();

      byPatient19.setAutoWrap(false);

      byPatient19.setHgap(0);

      byPatient19.setVgap(0);

      addByPatient19();
    }
    return byPatient19;

  }

  /**
   * 保険外負担分項目19行目を取得します。
   * @return 保険外負担分項目19行目
   */
  public ACComboBox getByPatientName19(){
    if(byPatientName19==null){

      byPatientName19 = new ACComboBox();

      byPatientName19.setBindPath("BY_PATIENT_NAME19");

      byPatientName19.setColumns(10);

      byPatientName19.setModelBindPath("BY_PATIENT_NAME");

      byPatientName19.setIMEMode(InputSubset.KANJI);

      byPatientName19.setMaxLength(20);

      byPatientName19.setMaxColumns(10);

      byPatientName19.setModel(getByPatientName19Model());

      addByPatientName19();
    }
    return byPatientName19;

  }

  /**
   * 保険外負担分項目19行目モデルを取得します。
   * @return 保険外負担分項目19行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName19Model(){
    if(byPatientName19Model==null){
      byPatientName19Model = new ACComboBoxModelAdapter();
      addByPatientName19Model();
    }
    return byPatientName19Model;
  }

  /**
   * 保険外負担分単価19行目を取得します。
   * @return 保険外負担分単価19行目
   */
  public ACTextField getByPatientPrice19(){
    if(byPatientPrice19==null){

      byPatientPrice19 = new ACTextField();

      byPatientPrice19.setBindPath("BY_PATIENT_PRICE19");

      byPatientPrice19.setColumns(3);

      byPatientPrice19.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice19.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice19.setIMEMode(InputSubset.LATIN);

      byPatientPrice19.setMaxLength(5);

      addByPatientPrice19();
    }
    return byPatientPrice19;

  }

  /**
   * 保険外負担分数量19行目を取得します。
   * @return 保険外負担分数量19行目
   */
  public ACTextField getByPatientNumber19(){
    if(byPatientNumber19==null){

      byPatientNumber19 = new ACTextField();

      byPatientNumber19.setBindPath("BY_PATIENT_NUMBER19");

      byPatientNumber19.setColumns(2);

      byPatientNumber19.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber19.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber19.setIMEMode(InputSubset.LATIN);

      byPatientNumber19.setMaxLength(3);

      addByPatientNumber19();
    }
    return byPatientNumber19;

  }

  /**
   * 保険外負担分金額19行目を取得します。
   * @return 保険外負担分金額19行目
   */
  public ACTextField getByPatientSum19(){
    if(byPatientSum19==null){

      byPatientSum19 = new ACTextField();

      byPatientSum19.setBindPath("BY_PATIENT_SUM19");

      byPatientSum19.setColumns(5);

      byPatientSum19.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum19.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum19.setIMEMode(InputSubset.LATIN);

      byPatientSum19.setMaxLength(8);

      addByPatientSum19();
    }
    return byPatientSum19;

  }

  /**
   * 保険外負担分課税1行目を取得します。
   * @return 保険外負担分課税1行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget19(){
    if(byPatientTaxTarget19==null){

      byPatientTaxTarget19 = new ACIntegerCheckBox();

      byPatientTaxTarget19.setText("　");

      byPatientTaxTarget19.setBindPath("BY_PATIENT_TAX_TARGET19");

      addByPatientTaxTarget19();
    }
    return byPatientTaxTarget19;

  }

  /**
   * 保険外負担分外税19行目を取得します。
   * @return 保険外負担分外税19行目
   */
  public ACIntegerCheckBox getByPatientUseTax19(){
    if(byPatientUseTax19==null){

      byPatientUseTax19 = new ACIntegerCheckBox();

      byPatientUseTax19.setBindPath("BY_PATIENT_USE_TAX19");

      addByPatientUseTax19();
    }
    return byPatientUseTax19;

  }

  /**
   * 保険外負担分消費税等19行目を取得します。
   * @return 保険外負担分消費税等19行目
   */
  public ACTextField getByPatientTax19(){
    if(byPatientTax19==null){

      byPatientTax19 = new ACTextField();

      byPatientTax19.setBindPath("BY_PATIENT_TAX19");

      byPatientTax19.setColumns(4);

      byPatientTax19.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax19.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax19.setIMEMode(InputSubset.LATIN);

      byPatientTax19.setMaxLength(5);

      addByPatientTax19();
    }
    return byPatientTax19;

  }

  /**
   * 保険外負担分20行目を取得します。
   * @return 保険外負担分20行目
   */
  public ACPanel getByPatient20(){
    if(byPatient20==null){

      byPatient20 = new ACPanel();

      byPatient20.setAutoWrap(false);

      byPatient20.setHgap(0);

      byPatient20.setVgap(0);

      addByPatient20();
    }
    return byPatient20;

  }

  /**
   * 保険外負担分項目20行目を取得します。
   * @return 保険外負担分項目20行目
   */
  public ACComboBox getByPatientName20(){
    if(byPatientName20==null){

      byPatientName20 = new ACComboBox();

      byPatientName20.setBindPath("BY_PATIENT_NAME20");

      byPatientName20.setColumns(10);

      byPatientName20.setModelBindPath("BY_PATIENT_NAME");

      byPatientName20.setIMEMode(InputSubset.KANJI);

      byPatientName20.setMaxLength(20);

      byPatientName20.setMaxColumns(10);

      byPatientName20.setModel(getByPatientName20Model());

      addByPatientName20();
    }
    return byPatientName20;

  }

  /**
   * 保険外負担分項目20行目モデルを取得します。
   * @return 保険外負担分項目20行目モデル
   */
  protected ACComboBoxModelAdapter getByPatientName20Model(){
    if(byPatientName20Model==null){
      byPatientName20Model = new ACComboBoxModelAdapter();
      addByPatientName20Model();
    }
    return byPatientName20Model;
  }

  /**
   * 保険外負担分単価20行目を取得します。
   * @return 保険外負担分単価20行目
   */
  public ACTextField getByPatientPrice20(){
    if(byPatientPrice20==null){

      byPatientPrice20 = new ACTextField();

      byPatientPrice20.setBindPath("BY_PATIENT_PRICE20");

      byPatientPrice20.setColumns(3);

      byPatientPrice20.setCharType(VRCharType.ONLY_NUMBER);

      byPatientPrice20.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientPrice20.setIMEMode(InputSubset.LATIN);

      byPatientPrice20.setMaxLength(5);

      addByPatientPrice20();
    }
    return byPatientPrice20;

  }

  /**
   * 保険外負担分数量20行目を取得します。
   * @return 保険外負担分数量20行目
   */
  public ACTextField getByPatientNumber20(){
    if(byPatientNumber20==null){

      byPatientNumber20 = new ACTextField();

      byPatientNumber20.setBindPath("BY_PATIENT_NUMBER20");

      byPatientNumber20.setColumns(2);

      byPatientNumber20.setCharType(VRCharType.ONLY_DIGIT);

      byPatientNumber20.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientNumber20.setIMEMode(InputSubset.LATIN);

      byPatientNumber20.setMaxLength(3);

      addByPatientNumber20();
    }
    return byPatientNumber20;

  }

  /**
   * 保険外負担分金額20行目を取得します。
   * @return 保険外負担分金額20行目
   */
  public ACTextField getByPatientSum20(){
    if(byPatientSum20==null){

      byPatientSum20 = new ACTextField();

      byPatientSum20.setBindPath("BY_PATIENT_SUM20");

      byPatientSum20.setColumns(5);

      byPatientSum20.setCharType(VRCharType.ONLY_NUMBER);

      byPatientSum20.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientSum20.setIMEMode(InputSubset.LATIN);

      byPatientSum20.setMaxLength(8);

      addByPatientSum20();
    }
    return byPatientSum20;

  }

  /**
   * 保険外負担分課税20行目を取得します。
   * @return 保険外負担分課税20行目
   */
  public ACIntegerCheckBox getByPatientTaxTarget20(){
    if(byPatientTaxTarget20==null){

      byPatientTaxTarget20 = new ACIntegerCheckBox();

      byPatientTaxTarget20.setText("　");

      byPatientTaxTarget20.setBindPath("BY_PATIENT_TAX_TARGET20");

      addByPatientTaxTarget20();
    }
    return byPatientTaxTarget20;

  }

  /**
   * 保険外負担分外税20行目を取得します。
   * @return 保険外負担分外税20行目
   */
  public ACIntegerCheckBox getByPatientUseTax20(){
    if(byPatientUseTax20==null){

      byPatientUseTax20 = new ACIntegerCheckBox();

      byPatientUseTax20.setBindPath("BY_PATIENT_USE_TAX20");

      addByPatientUseTax20();
    }
    return byPatientUseTax20;

  }

  /**
   * 保険外負担分消費税等20行目を取得します。
   * @return 保険外負担分消費税等20行目
   */
  public ACTextField getByPatientTax20(){
    if(byPatientTax20==null){

      byPatientTax20 = new ACTextField();

      byPatientTax20.setBindPath("BY_PATIENT_TAX20");

      byPatientTax20.setColumns(4);

      byPatientTax20.setCharType(VRCharType.ONLY_NUMBER);

      byPatientTax20.setHorizontalAlignment(SwingConstants.RIGHT);

      byPatientTax20.setIMEMode(InputSubset.LATIN);

      byPatientTax20.setMaxLength(5);

      addByPatientTax20();
    }
    return byPatientTax20;

  }

  /**
   * 税説明を取得します。
   * @return 税説明
   */
  public ACLabel getUseTaxInfomation(){
    if(useTaxInfomation==null){

      useTaxInfomation = new ACLabel();

      useTaxInfomation.setText("「税」列にチェックをつけると、外税として消費税等列に税額が" + ACConstants.LINE_SEPARATOR + "自動入力されます。チェックを外すと、内税となります。");

      useTaxInfomation.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      useTaxInfomation.setAutoWrap(true);

      addUseTaxInfomation();
    }
    return useTaxInfomation;

  }

  /**
   * 補足領域を取得します。
   * @return 補足領域
   */
  public ACPanel getOptionContents(){
    if(optionContents==null){

      optionContents = new ACPanel();

      addOptionContents();
    }
    return optionContents;

  }

  /**
   * 請求保険情報領域を取得します。
   * @return 請求保険情報領域
   */
  public ACGroupBox getInsurerContents(){
    if(insurerContents==null){

      insurerContents = new ACGroupBox();

      insurerContents.setText("請求保険情報");

      insurerContents.setAutoWrap(false);

      addInsurerContents();
    }
    return insurerContents;

  }

  /**
   * 請求期間を取得します。
   * @return 請求期間
   */
  public ACLabelContainer getBillSpanContainer(){
    if(billSpanContainer==null){

      billSpanContainer = new ACLabelContainer();

      billSpanContainer.setText("請求期間");

      addBillSpanContainer();
    }
    return billSpanContainer;

  }

  /**
   * 開始年月日を取得します。
   * @return 開始年月日
   */
  public ACTextField getBillSpanStart(){
    if(billSpanStart==null){

      billSpanStart = new ACTextField();

      billSpanStart.setBindPath("BILL_SPAN_START");

      billSpanStart.setEditable(false);

      billSpanStart.setColumns(10);

      billSpanStart.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addBillSpanStart();
    }
    return billSpanStart;

  }

  /**
   * からを取得します。
   * @return から
   */
  public ACLabel getBillSpan(){
    if(billSpan==null){

      billSpan = new ACLabel();

      billSpan.setText("から");

      addBillSpan();
    }
    return billSpan;

  }

  /**
   * 終了年月日を取得します。
   * @return 終了年月日
   */
  public ACTextField getBillSpanEnd(){
    if(billSpanEnd==null){

      billSpanEnd = new ACTextField();

      billSpanEnd.setBindPath("BILL_SPAN_END");

      billSpanEnd.setEditable(false);

      billSpanEnd.setColumns(10);

      billSpanEnd.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addBillSpanEnd();
    }
    return billSpanEnd;

  }

  /**
   * 発行日を取得します。
   * @return 発行日
   */
  public QkanDateTextField getPrintDate(){
    if(printDate==null){

      printDate = new QkanDateTextField();

      getPrintDateContainer().setText("発行日");

      printDate.setBindPath("BILL_PRINT_DATE");

      addPrintDate();
    }
    return printDate;

  }

  /**
   * 発行日コンテナを取得します。
   * @return 発行日コンテナ
   */
  protected ACLabelContainer getPrintDateContainer(){
    if(printDateContainer==null){
      printDateContainer = new ACLabelContainer();
      printDateContainer.setFollowChildEnabled(true);
      printDateContainer.setVAlignment(VRLayout.CENTER);
      printDateContainer.add(getPrintDate(), null);
    }
    return printDateContainer;
  }

  /**
   * 負担割合コンテナを取得します。
   * @return 負担割合コンテナ
   */
  public ACLabelContainer getByPatientRateContainer(){
    if(byPatientRateContainer==null){

      byPatientRateContainer = new ACLabelContainer();

      byPatientRateContainer.setText("負担割合");

      addByPatientRateContainer();
    }
    return byPatientRateContainer;

  }

  /**
   * 負担割合を取得します。
   * @return 負担割合
   */
  public ACTextField getByPatientRate(){
    if(byPatientRate==null){

      byPatientRate = new ACTextField();

      byPatientRate.setBindPath("BY_PATIENT_RATE");

      byPatientRate.setEditable(false);

      byPatientRate.setColumns(2);

      byPatientRate.setHorizontalAlignment(SwingConstants.RIGHT);

      addByPatientRate();
    }
    return byPatientRate;

  }

  /**
   * 負担割合単位を取得します。
   * @return 負担割合単位
   */
  public ACLabel getByPatientRateUnit(){
    if(byPatientRateUnit==null){

      byPatientRateUnit = new ACLabel();

      byPatientRateUnit.setText("割");

      addByPatientRateUnit();
    }
    return byPatientRateUnit;

  }

  /**
   * 本・家を取得します。
   * @return 本・家
   */
  public ACTextField getPatientFamilyType(){
    if(patientFamilyType==null){

      patientFamilyType = new ACTextField();

      getPatientFamilyTypeContainer().setText("本・家");

      patientFamilyType.setBindPath("SELF_FLAG");

      patientFamilyType.setEditable(false);

      patientFamilyType.setColumns(3);

      patientFamilyType.setFormat(QkanMedicalSelfFlagFormat.getInstance());

      addPatientFamilyType();
    }
    return patientFamilyType;

  }

  /**
   * 本・家コンテナを取得します。
   * @return 本・家コンテナ
   */
  protected ACLabelContainer getPatientFamilyTypeContainer(){
    if(patientFamilyTypeContainer==null){
      patientFamilyTypeContainer = new ACLabelContainer();
      patientFamilyTypeContainer.setFollowChildEnabled(true);
      patientFamilyTypeContainer.setVAlignment(VRLayout.CENTER);
      patientFamilyTypeContainer.add(getPatientFamilyType(), null);
    }
    return patientFamilyTypeContainer;
  }

  /**
   * 区分を取得します。
   * @return 区分
   */
  public ACTextField getInsureType(){
    if(insureType==null){

      insureType = new ACTextField();

      getInsureTypeContainer().setText("区分");

      insureType.setBindPath("BILL_INSURE_TYPE");

      insureType.setColumns(20);

      insureType.setIMEMode(InputSubset.KANJI);

      insureType.setMaxLength(20);

      addInsureType();
    }
    return insureType;

  }

  /**
   * 区分コンテナを取得します。
   * @return 区分コンテナ
   */
  protected ACLabelContainer getInsureTypeContainer(){
    if(insureTypeContainer==null){
      insureTypeContainer = new ACLabelContainer();
      insureTypeContainer.setFollowChildEnabled(true);
      insureTypeContainer.setVAlignment(VRLayout.CENTER);
      insureTypeContainer.add(getInsureType(), null);
    }
    return insureTypeContainer;
  }

  /**
   * 税率コンテナを取得します。
   * @return 税率コンテナ
   */
  public ACLabelContainer getTaxContainer(){
    if(taxContainer==null){

      taxContainer = new ACLabelContainer();

      taxContainer.setText("消費税率");

      addTaxContainer();
    }
    return taxContainer;

  }

  /**
   * 税率を取得します。
   * @return 税率
   */
  public ACTextField getTax(){
    if(tax==null){

      tax = new ACTextField();

      tax.setBindPath("BILL_TAX");

      tax.setEditable(false);

      tax.setColumns(3);

      tax.setHorizontalAlignment(SwingConstants.RIGHT);

      addTax();
    }
    return tax;

  }

  /**
   * 税率単位を取得します。
   * @return 税率単位
   */
  public ACLabel getTaxUnit(){
    if(taxUnit==null){

      taxUnit = new ACLabel();

      taxUnit.setText("%");

      addTaxUnit();
    }
    return taxUnit;

  }

  /**
   * 税率再設定を取得します。
   * @return 税率再設定
   */
  public ACButton getTaxChange(){
    if(taxChange==null){

      taxChange = new ACButton();

      taxChange.setText("再設定");

      addTaxChange();
    }
    return taxChange;

  }

  /**
   * 提供日を取得します。
   * @return 提供日
   */
  public ACGroupBox getProvideContents(){
    if(provideContents==null){

      provideContents = new ACGroupBox();

      provideContents.setText("提供日");

      provideContents.setAutoWrap(false);

      provideContents.setHgap(0);

      provideContents.setVgap(0);

      addProvideContents();
    }
    return provideContents;

  }

  /**
   * 提供日1を取得します。
   * @return 提供日1
   */
  public ACComboBox getProvideDay1(){
    if(provideDay1==null){

      provideDay1 = new ACComboBox();

      provideDay1.setBindPath("PROVIDE_DAY_1");

      provideDay1.setEditable(false);

      provideDay1.setColumns(4);

      provideDay1.setRenderBindPath("ITEM");

      provideDay1.setMaxColumns(4);

      provideDay1.setModel(getProvideDay1Model());

      addProvideDay1();
    }
    return provideDay1;

  }

  /**
   * 提供日1モデルを取得します。
   * @return 提供日1モデル
   */
  protected ACComboBoxModelAdapter getProvideDay1Model(){
    if(provideDay1Model==null){
      provideDay1Model = new ACComboBoxModelAdapter();
      addProvideDay1Model();
    }
    return provideDay1Model;
  }

  /**
   * 1を取得します。
   * @return 1
   */
  public ACListItem getProvideDay1Item1(){
    if(provideDay1Item1==null){

      provideDay1Item1 = new ACListItem();

      provideDay1Item1.setText("1");

      provideDay1Item1.setSimpleValueMode(false);
      provideDay1Item1.put(getProvideDay1().getRenderBindPath(), "1");
      provideDay1Item1.put(getProvideDay1().getBindPath(), new Integer(0));

      addProvideDay1Item1();
    }
    return provideDay1Item1;

  }

  /**
   * 1○を取得します。
   * @return 1○
   */
  public ACListItem getProvideDay1Item2(){
    if(provideDay1Item2==null){

      provideDay1Item2 = new ACListItem();

      provideDay1Item2.setText("1○");

      provideDay1Item2.setSimpleValueMode(false);
      provideDay1Item2.put(getProvideDay1().getRenderBindPath(), "1○");
      provideDay1Item2.put(getProvideDay1().getBindPath(), new Integer(1));

      addProvideDay1Item2();
    }
    return provideDay1Item2;

  }

  /**
   * 1△を取得します。
   * @return 1△
   */
  public ACListItem getProvideDay1Item3(){
    if(provideDay1Item3==null){

      provideDay1Item3 = new ACListItem();

      provideDay1Item3.setText("1△");

      provideDay1Item3.setSimpleValueMode(false);
      provideDay1Item3.put(getProvideDay1().getRenderBindPath(), "1△");
      provideDay1Item3.put(getProvideDay1().getBindPath(), new Integer(2));

      addProvideDay1Item3();
    }
    return provideDay1Item3;

  }

  /**
   * 1◎を取得します。
   * @return 1◎
   */
  public ACListItem getProvideDay1Item4(){
    if(provideDay1Item4==null){

      provideDay1Item4 = new ACListItem();

      provideDay1Item4.setText("1◎");

      provideDay1Item4.setSimpleValueMode(false);
      provideDay1Item4.put(getProvideDay1().getRenderBindPath(), "1◎");
      provideDay1Item4.put(getProvideDay1().getBindPath(), new Integer(3));

      addProvideDay1Item4();
    }
    return provideDay1Item4;

  }

  /**
   * 1△◎を取得します。
   * @return 1△◎
   */
  public ACListItem getProvideDay1Item5(){
    if(provideDay1Item5==null){

      provideDay1Item5 = new ACListItem();

      provideDay1Item5.setText("1△◎");

      provideDay1Item5.setSimpleValueMode(false);
      provideDay1Item5.put(getProvideDay1().getRenderBindPath(), "1△◎");
      provideDay1Item5.put(getProvideDay1().getBindPath(), new Integer(4));

      addProvideDay1Item5();
    }
    return provideDay1Item5;

  }

  /**
   * 1◇を取得します。
   * @return 1◇
   */
  public ACListItem getProvideDay1Item6(){
    if(provideDay1Item6==null){

      provideDay1Item6 = new ACListItem();

      provideDay1Item6.setText("1◇");

      provideDay1Item6.setSimpleValueMode(false);
      provideDay1Item6.put(getProvideDay1().getRenderBindPath(), "1◇");
      provideDay1Item6.put(getProvideDay1().getBindPath(), new Integer(5));

      addProvideDay1Item6();
    }
    return provideDay1Item6;

  }

  /**
   * 1△◇を取得します。
   * @return 1△◇
   */
  public ACListItem getProvideDay1Item7(){
    if(provideDay1Item7==null){

      provideDay1Item7 = new ACListItem();

      provideDay1Item7.setText("1△◇");

      provideDay1Item7.setSimpleValueMode(false);
      provideDay1Item7.put(getProvideDay1().getRenderBindPath(), "1△◇");
      provideDay1Item7.put(getProvideDay1().getBindPath(), new Integer(6));

      addProvideDay1Item7();
    }
    return provideDay1Item7;

  }

  /**
   * 提供日2を取得します。
   * @return 提供日2
   */
  public ACComboBox getProvideDay2(){
    if(provideDay2==null){

      provideDay2 = new ACComboBox();

      provideDay2.setBindPath("PROVIDE_DAY_2");

      provideDay2.setEditable(false);

      provideDay2.setColumns(4);

      provideDay2.setRenderBindPath("ITEM");

      provideDay2.setMaxColumns(4);

      provideDay2.setModel(getProvideDay2Model());

      addProvideDay2();
    }
    return provideDay2;

  }

  /**
   * 提供日2モデルを取得します。
   * @return 提供日2モデル
   */
  protected ACComboBoxModelAdapter getProvideDay2Model(){
    if(provideDay2Model==null){
      provideDay2Model = new ACComboBoxModelAdapter();
      addProvideDay2Model();
    }
    return provideDay2Model;
  }

  /**
   * 2を取得します。
   * @return 2
   */
  public ACListItem getProvideDay2Item1(){
    if(provideDay2Item1==null){

      provideDay2Item1 = new ACListItem();

      provideDay2Item1.setText("2");

      provideDay2Item1.setSimpleValueMode(false);
      provideDay2Item1.put(getProvideDay2().getRenderBindPath(), "2");
      provideDay2Item1.put(getProvideDay2().getBindPath(), new Integer(0));

      addProvideDay2Item1();
    }
    return provideDay2Item1;

  }

  /**
   * 2○を取得します。
   * @return 2○
   */
  public ACListItem getProvideDay2Item2(){
    if(provideDay2Item2==null){

      provideDay2Item2 = new ACListItem();

      provideDay2Item2.setText("2○");

      provideDay2Item2.setSimpleValueMode(false);
      provideDay2Item2.put(getProvideDay2().getRenderBindPath(), "2○");
      provideDay2Item2.put(getProvideDay2().getBindPath(), new Integer(1));

      addProvideDay2Item2();
    }
    return provideDay2Item2;

  }

  /**
   * 2△を取得します。
   * @return 2△
   */
  public ACListItem getProvideDay2Item3(){
    if(provideDay2Item3==null){

      provideDay2Item3 = new ACListItem();

      provideDay2Item3.setText("2△");

      provideDay2Item3.setSimpleValueMode(false);
      provideDay2Item3.put(getProvideDay2().getRenderBindPath(), "2△");
      provideDay2Item3.put(getProvideDay2().getBindPath(), new Integer(2));

      addProvideDay2Item3();
    }
    return provideDay2Item3;

  }

  /**
   * 2◎を取得します。
   * @return 2◎
   */
  public ACListItem getProvideDay2Item4(){
    if(provideDay2Item4==null){

      provideDay2Item4 = new ACListItem();

      provideDay2Item4.setText("2◎");

      provideDay2Item4.setSimpleValueMode(false);
      provideDay2Item4.put(getProvideDay2().getRenderBindPath(), "2◎");
      provideDay2Item4.put(getProvideDay2().getBindPath(), new Integer(3));

      addProvideDay2Item4();
    }
    return provideDay2Item4;

  }

  /**
   * 2△◎を取得します。
   * @return 2△◎
   */
  public ACListItem getProvideDay2Item5(){
    if(provideDay2Item5==null){

      provideDay2Item5 = new ACListItem();

      provideDay2Item5.setText("2△◎");

      provideDay2Item5.setSimpleValueMode(false);
      provideDay2Item5.put(getProvideDay2().getRenderBindPath(), "2△◎");
      provideDay2Item5.put(getProvideDay2().getBindPath(), new Integer(4));

      addProvideDay2Item5();
    }
    return provideDay2Item5;

  }

  /**
   * 2◇を取得します。
   * @return 2◇
   */
  public ACListItem getProvideDay2Item6(){
    if(provideDay2Item6==null){

      provideDay2Item6 = new ACListItem();

      provideDay2Item6.setText("2◇");

      provideDay2Item6.setSimpleValueMode(false);
      provideDay2Item6.put(getProvideDay2().getRenderBindPath(), "2◇");
      provideDay2Item6.put(getProvideDay2().getBindPath(), new Integer(5));

      addProvideDay2Item6();
    }
    return provideDay2Item6;

  }

  /**
   * 2△◇を取得します。
   * @return 2△◇
   */
  public ACListItem getProvideDay2Item7(){
    if(provideDay2Item7==null){

      provideDay2Item7 = new ACListItem();

      provideDay2Item7.setText("2△◇");

      provideDay2Item7.setSimpleValueMode(false);
      provideDay2Item7.put(getProvideDay2().getRenderBindPath(), "2△◇");
      provideDay2Item7.put(getProvideDay2().getBindPath(), new Integer(6));

      addProvideDay2Item7();
    }
    return provideDay2Item7;

  }

  /**
   * 提供日3を取得します。
   * @return 提供日3
   */
  public ACComboBox getProvideDay3(){
    if(provideDay3==null){

      provideDay3 = new ACComboBox();

      provideDay3.setBindPath("PROVIDE_DAY_3");

      provideDay3.setEditable(false);

      provideDay3.setColumns(4);

      provideDay3.setRenderBindPath("ITEM");

      provideDay3.setMaxColumns(4);

      provideDay3.setModel(getProvideDay3Model());

      addProvideDay3();
    }
    return provideDay3;

  }

  /**
   * 提供日3モデルを取得します。
   * @return 提供日3モデル
   */
  protected ACComboBoxModelAdapter getProvideDay3Model(){
    if(provideDay3Model==null){
      provideDay3Model = new ACComboBoxModelAdapter();
      addProvideDay3Model();
    }
    return provideDay3Model;
  }

  /**
   * 3を取得します。
   * @return 3
   */
  public ACListItem getProvideDay3Item1(){
    if(provideDay3Item1==null){

      provideDay3Item1 = new ACListItem();

      provideDay3Item1.setText("3");

      provideDay3Item1.setSimpleValueMode(false);
      provideDay3Item1.put(getProvideDay3().getRenderBindPath(), "3");
      provideDay3Item1.put(getProvideDay3().getBindPath(), new Integer(0));

      addProvideDay3Item1();
    }
    return provideDay3Item1;

  }

  /**
   * 3○を取得します。
   * @return 3○
   */
  public ACListItem getProvideDay3Item2(){
    if(provideDay3Item2==null){

      provideDay3Item2 = new ACListItem();

      provideDay3Item2.setText("3○");

      provideDay3Item2.setSimpleValueMode(false);
      provideDay3Item2.put(getProvideDay3().getRenderBindPath(), "3○");
      provideDay3Item2.put(getProvideDay3().getBindPath(), new Integer(1));

      addProvideDay3Item2();
    }
    return provideDay3Item2;

  }

  /**
   * 3△を取得します。
   * @return 3△
   */
  public ACListItem getProvideDay3Item3(){
    if(provideDay3Item3==null){

      provideDay3Item3 = new ACListItem();

      provideDay3Item3.setText("3△");

      provideDay3Item3.setSimpleValueMode(false);
      provideDay3Item3.put(getProvideDay3().getRenderBindPath(), "3△");
      provideDay3Item3.put(getProvideDay3().getBindPath(), new Integer(2));

      addProvideDay3Item3();
    }
    return provideDay3Item3;

  }

  /**
   * 3◎を取得します。
   * @return 3◎
   */
  public ACListItem getProvideDay3Item4(){
    if(provideDay3Item4==null){

      provideDay3Item4 = new ACListItem();

      provideDay3Item4.setText("3◎");

      provideDay3Item4.setSimpleValueMode(false);
      provideDay3Item4.put(getProvideDay3().getRenderBindPath(), "3◎");
      provideDay3Item4.put(getProvideDay3().getBindPath(), new Integer(3));

      addProvideDay3Item4();
    }
    return provideDay3Item4;

  }

  /**
   * 3△◎を取得します。
   * @return 3△◎
   */
  public ACListItem getProvideDay3Item5(){
    if(provideDay3Item5==null){

      provideDay3Item5 = new ACListItem();

      provideDay3Item5.setText("3△◎");

      provideDay3Item5.setSimpleValueMode(false);
      provideDay3Item5.put(getProvideDay3().getRenderBindPath(), "3△◎");
      provideDay3Item5.put(getProvideDay3().getBindPath(), new Integer(4));

      addProvideDay3Item5();
    }
    return provideDay3Item5;

  }

  /**
   * 3◇を取得します。
   * @return 3◇
   */
  public ACListItem getProvideDay3Item6(){
    if(provideDay3Item6==null){

      provideDay3Item6 = new ACListItem();

      provideDay3Item6.setText("3◇");

      provideDay3Item6.setSimpleValueMode(false);
      provideDay3Item6.put(getProvideDay3().getRenderBindPath(), "3◇");
      provideDay3Item6.put(getProvideDay3().getBindPath(), new Integer(5));

      addProvideDay3Item6();
    }
    return provideDay3Item6;

  }

  /**
   * 3△◇を取得します。
   * @return 3△◇
   */
  public ACListItem getProvideDay3Item7(){
    if(provideDay3Item7==null){

      provideDay3Item7 = new ACListItem();

      provideDay3Item7.setText("3△◇");

      provideDay3Item7.setSimpleValueMode(false);
      provideDay3Item7.put(getProvideDay3().getRenderBindPath(), "3△◇");
      provideDay3Item7.put(getProvideDay3().getBindPath(), new Integer(6));

      addProvideDay3Item7();
    }
    return provideDay3Item7;

  }

  /**
   * 提供日4を取得します。
   * @return 提供日4
   */
  public ACComboBox getProvideDay4(){
    if(provideDay4==null){

      provideDay4 = new ACComboBox();

      provideDay4.setBindPath("PROVIDE_DAY_4");

      provideDay4.setEditable(false);

      provideDay4.setColumns(4);

      provideDay4.setRenderBindPath("ITEM");

      provideDay4.setMaxColumns(4);

      provideDay4.setModel(getProvideDay4Model());

      addProvideDay4();
    }
    return provideDay4;

  }

  /**
   * 提供日4モデルを取得します。
   * @return 提供日4モデル
   */
  protected ACComboBoxModelAdapter getProvideDay4Model(){
    if(provideDay4Model==null){
      provideDay4Model = new ACComboBoxModelAdapter();
      addProvideDay4Model();
    }
    return provideDay4Model;
  }

  /**
   * 4を取得します。
   * @return 4
   */
  public ACListItem getProvideDay4item1(){
    if(provideDay4item1==null){

      provideDay4item1 = new ACListItem();

      provideDay4item1.setText("4");

      provideDay4item1.setSimpleValueMode(false);
      provideDay4item1.put(getProvideDay4().getRenderBindPath(), "4");
      provideDay4item1.put(getProvideDay4().getBindPath(), new Integer(0));

      addProvideDay4item1();
    }
    return provideDay4item1;

  }

  /**
   * 4○を取得します。
   * @return 4○
   */
  public ACListItem getProvideDay4item2(){
    if(provideDay4item2==null){

      provideDay4item2 = new ACListItem();

      provideDay4item2.setText("4○");

      provideDay4item2.setSimpleValueMode(false);
      provideDay4item2.put(getProvideDay4().getRenderBindPath(), "4○");
      provideDay4item2.put(getProvideDay4().getBindPath(), new Integer(1));

      addProvideDay4item2();
    }
    return provideDay4item2;

  }

  /**
   * 4△を取得します。
   * @return 4△
   */
  public ACListItem getProvideDay4item3(){
    if(provideDay4item3==null){

      provideDay4item3 = new ACListItem();

      provideDay4item3.setText("4△");

      provideDay4item3.setSimpleValueMode(false);
      provideDay4item3.put(getProvideDay4().getRenderBindPath(), "4△");
      provideDay4item3.put(getProvideDay4().getBindPath(), new Integer(2));

      addProvideDay4item3();
    }
    return provideDay4item3;

  }

  /**
   * 4◎を取得します。
   * @return 4◎
   */
  public ACListItem getProvideDay4item4(){
    if(provideDay4item4==null){

      provideDay4item4 = new ACListItem();

      provideDay4item4.setText("4◎");

      provideDay4item4.setSimpleValueMode(false);
      provideDay4item4.put(getProvideDay4().getRenderBindPath(), "4◎");
      provideDay4item4.put(getProvideDay4().getBindPath(), new Integer(3));

      addProvideDay4item4();
    }
    return provideDay4item4;

  }

  /**
   * 4△◎を取得します。
   * @return 4△◎
   */
  public ACListItem getProvideDay4item5(){
    if(provideDay4item5==null){

      provideDay4item5 = new ACListItem();

      provideDay4item5.setText("4△◎");

      provideDay4item5.setSimpleValueMode(false);
      provideDay4item5.put(getProvideDay4().getRenderBindPath(), "4△◎");
      provideDay4item5.put(getProvideDay4().getBindPath(), new Integer(4));

      addProvideDay4item5();
    }
    return provideDay4item5;

  }

  /**
   * 4◇を取得します。
   * @return 4◇
   */
  public ACListItem getProvideDay4item6(){
    if(provideDay4item6==null){

      provideDay4item6 = new ACListItem();

      provideDay4item6.setText("4◇");

      provideDay4item6.setSimpleValueMode(false);
      provideDay4item6.put(getProvideDay4().getRenderBindPath(), "4◇");
      provideDay4item6.put(getProvideDay4().getBindPath(), new Integer(5));

      addProvideDay4item6();
    }
    return provideDay4item6;

  }

  /**
   * 4△◇を取得します。
   * @return 4△◇
   */
  public ACListItem getProvideDay4Item7(){
    if(provideDay4Item7==null){

      provideDay4Item7 = new ACListItem();

      provideDay4Item7.setText("4△◇");

      provideDay4Item7.setSimpleValueMode(false);
      provideDay4Item7.put(getProvideDay4().getRenderBindPath(), "4△◇");
      provideDay4Item7.put(getProvideDay4().getBindPath(), new Integer(6));

      addProvideDay4Item7();
    }
    return provideDay4Item7;

  }

  /**
   * 提供日5を取得します。
   * @return 提供日5
   */
  public ACComboBox getProvideDay5(){
    if(provideDay5==null){

      provideDay5 = new ACComboBox();

      provideDay5.setBindPath("PROVIDE_DAY_5");

      provideDay5.setEditable(false);

      provideDay5.setColumns(4);

      provideDay5.setRenderBindPath("ITEM");

      provideDay5.setMaxColumns(4);

      provideDay5.setModel(getProvideDay5Model());

      addProvideDay5();
    }
    return provideDay5;

  }

  /**
   * 提供日5モデルを取得します。
   * @return 提供日5モデル
   */
  protected ACComboBoxModelAdapter getProvideDay5Model(){
    if(provideDay5Model==null){
      provideDay5Model = new ACComboBoxModelAdapter();
      addProvideDay5Model();
    }
    return provideDay5Model;
  }

  /**
   * 5を取得します。
   * @return 5
   */
  public ACListItem getProvideDay5Item1(){
    if(provideDay5Item1==null){

      provideDay5Item1 = new ACListItem();

      provideDay5Item1.setText("5");

      provideDay5Item1.setSimpleValueMode(false);
      provideDay5Item1.put(getProvideDay5().getRenderBindPath(), "5");
      provideDay5Item1.put(getProvideDay5().getBindPath(), new Integer(0));

      addProvideDay5Item1();
    }
    return provideDay5Item1;

  }

  /**
   * 5○を取得します。
   * @return 5○
   */
  public ACListItem getProvideDay5Item2(){
    if(provideDay5Item2==null){

      provideDay5Item2 = new ACListItem();

      provideDay5Item2.setText("5○");

      provideDay5Item2.setSimpleValueMode(false);
      provideDay5Item2.put(getProvideDay5().getRenderBindPath(), "5○");
      provideDay5Item2.put(getProvideDay5().getBindPath(), new Integer(1));

      addProvideDay5Item2();
    }
    return provideDay5Item2;

  }

  /**
   * 5△を取得します。
   * @return 5△
   */
  public ACListItem getProvideDay5Item3(){
    if(provideDay5Item3==null){

      provideDay5Item3 = new ACListItem();

      provideDay5Item3.setText("5△");

      provideDay5Item3.setSimpleValueMode(false);
      provideDay5Item3.put(getProvideDay5().getRenderBindPath(), "5△");
      provideDay5Item3.put(getProvideDay5().getBindPath(), new Integer(2));

      addProvideDay5Item3();
    }
    return provideDay5Item3;

  }

  /**
   * 5◎を取得します。
   * @return 5◎
   */
  public ACListItem getProvideDay5Item4(){
    if(provideDay5Item4==null){

      provideDay5Item4 = new ACListItem();

      provideDay5Item4.setText("5◎");

      provideDay5Item4.setSimpleValueMode(false);
      provideDay5Item4.put(getProvideDay5().getRenderBindPath(), "5◎");
      provideDay5Item4.put(getProvideDay5().getBindPath(), new Integer(3));

      addProvideDay5Item4();
    }
    return provideDay5Item4;

  }

  /**
   * 5△◎を取得します。
   * @return 5△◎
   */
  public ACListItem getProvideDay5Item5(){
    if(provideDay5Item5==null){

      provideDay5Item5 = new ACListItem();

      provideDay5Item5.setText("5△◎");

      provideDay5Item5.setSimpleValueMode(false);
      provideDay5Item5.put(getProvideDay5().getRenderBindPath(), "5△◎");
      provideDay5Item5.put(getProvideDay5().getBindPath(), new Integer(4));

      addProvideDay5Item5();
    }
    return provideDay5Item5;

  }

  /**
   * 5◇を取得します。
   * @return 5◇
   */
  public ACListItem getProvideDay5Item6(){
    if(provideDay5Item6==null){

      provideDay5Item6 = new ACListItem();

      provideDay5Item6.setText("5◇");

      provideDay5Item6.setSimpleValueMode(false);
      provideDay5Item6.put(getProvideDay5().getRenderBindPath(), "5◇");
      provideDay5Item6.put(getProvideDay5().getBindPath(), new Integer(5));

      addProvideDay5Item6();
    }
    return provideDay5Item6;

  }

  /**
   * 5△◇を取得します。
   * @return 5△◇
   */
  public ACListItem getProvideDay5Item7(){
    if(provideDay5Item7==null){

      provideDay5Item7 = new ACListItem();

      provideDay5Item7.setText("5△◇");

      provideDay5Item7.setSimpleValueMode(false);
      provideDay5Item7.put(getProvideDay5().getRenderBindPath(), "5△◇");
      provideDay5Item7.put(getProvideDay5().getBindPath(), new Integer(6));

      addProvideDay5Item7();
    }
    return provideDay5Item7;

  }

  /**
   * 提供日6を取得します。
   * @return 提供日6
   */
  public ACComboBox getProvideDay6(){
    if(provideDay6==null){

      provideDay6 = new ACComboBox();

      provideDay6.setBindPath("PROVIDE_DAY_6");

      provideDay6.setEditable(false);

      provideDay6.setColumns(4);

      provideDay6.setRenderBindPath("ITEM");

      provideDay6.setMaxColumns(4);

      provideDay6.setModel(getProvideDay6Model());

      addProvideDay6();
    }
    return provideDay6;

  }

  /**
   * 提供日6モデルを取得します。
   * @return 提供日6モデル
   */
  protected ACComboBoxModelAdapter getProvideDay6Model(){
    if(provideDay6Model==null){
      provideDay6Model = new ACComboBoxModelAdapter();
      addProvideDay6Model();
    }
    return provideDay6Model;
  }

  /**
   * 6を取得します。
   * @return 6
   */
  public ACListItem getProvideDay6Item1(){
    if(provideDay6Item1==null){

      provideDay6Item1 = new ACListItem();

      provideDay6Item1.setText("6");

      provideDay6Item1.setSimpleValueMode(false);
      provideDay6Item1.put(getProvideDay6().getRenderBindPath(), "6");
      provideDay6Item1.put(getProvideDay6().getBindPath(), new Integer(0));

      addProvideDay6Item1();
    }
    return provideDay6Item1;

  }

  /**
   * 6○を取得します。
   * @return 6○
   */
  public ACListItem getProvideDay6Item2(){
    if(provideDay6Item2==null){

      provideDay6Item2 = new ACListItem();

      provideDay6Item2.setText("6○");

      provideDay6Item2.setSimpleValueMode(false);
      provideDay6Item2.put(getProvideDay6().getRenderBindPath(), "6○");
      provideDay6Item2.put(getProvideDay6().getBindPath(), new Integer(1));

      addProvideDay6Item2();
    }
    return provideDay6Item2;

  }

  /**
   * 6△を取得します。
   * @return 6△
   */
  public ACListItem getProvideDay6Item3(){
    if(provideDay6Item3==null){

      provideDay6Item3 = new ACListItem();

      provideDay6Item3.setText("6△");

      provideDay6Item3.setSimpleValueMode(false);
      provideDay6Item3.put(getProvideDay6().getRenderBindPath(), "6△");
      provideDay6Item3.put(getProvideDay6().getBindPath(), new Integer(2));

      addProvideDay6Item3();
    }
    return provideDay6Item3;

  }

  /**
   * 6◎を取得します。
   * @return 6◎
   */
  public ACListItem getProvideDay6Item4(){
    if(provideDay6Item4==null){

      provideDay6Item4 = new ACListItem();

      provideDay6Item4.setText("6◎");

      provideDay6Item4.setSimpleValueMode(false);
      provideDay6Item4.put(getProvideDay6().getRenderBindPath(), "6◎");
      provideDay6Item4.put(getProvideDay6().getBindPath(), new Integer(3));

      addProvideDay6Item4();
    }
    return provideDay6Item4;

  }

  /**
   * 6△◎を取得します。
   * @return 6△◎
   */
  public ACListItem getProvideDay6Item5(){
    if(provideDay6Item5==null){

      provideDay6Item5 = new ACListItem();

      provideDay6Item5.setText("6△◎");

      provideDay6Item5.setSimpleValueMode(false);
      provideDay6Item5.put(getProvideDay6().getRenderBindPath(), "6△◎");
      provideDay6Item5.put(getProvideDay6().getBindPath(), new Integer(4));

      addProvideDay6Item5();
    }
    return provideDay6Item5;

  }

  /**
   * 6◇を取得します。
   * @return 6◇
   */
  public ACListItem getProvideDay6Item6(){
    if(provideDay6Item6==null){

      provideDay6Item6 = new ACListItem();

      provideDay6Item6.setText("6◇");

      provideDay6Item6.setSimpleValueMode(false);
      provideDay6Item6.put(getProvideDay6().getRenderBindPath(), "6◇");
      provideDay6Item6.put(getProvideDay6().getBindPath(), new Integer(5));

      addProvideDay6Item6();
    }
    return provideDay6Item6;

  }

  /**
   * 6△◇を取得します。
   * @return 6△◇
   */
  public ACListItem getProvideDay6Item7(){
    if(provideDay6Item7==null){

      provideDay6Item7 = new ACListItem();

      provideDay6Item7.setText("6△◇");

      provideDay6Item7.setSimpleValueMode(false);
      provideDay6Item7.put(getProvideDay6().getRenderBindPath(), "6△◇");
      provideDay6Item7.put(getProvideDay6().getBindPath(), new Integer(6));

      addProvideDay6Item7();
    }
    return provideDay6Item7;

  }

  /**
   * 提供日7を取得します。
   * @return 提供日7
   */
  public ACComboBox getProvideDay7(){
    if(provideDay7==null){

      provideDay7 = new ACComboBox();

      provideDay7.setBindPath("PROVIDE_DAY_7");

      provideDay7.setEditable(false);

      provideDay7.setColumns(4);

      provideDay7.setRenderBindPath("ITEM");

      provideDay7.setMaxColumns(4);

      provideDay7.setModel(getProvideDay7Model());

      addProvideDay7();
    }
    return provideDay7;

  }

  /**
   * 提供日7モデルを取得します。
   * @return 提供日7モデル
   */
  protected ACComboBoxModelAdapter getProvideDay7Model(){
    if(provideDay7Model==null){
      provideDay7Model = new ACComboBoxModelAdapter();
      addProvideDay7Model();
    }
    return provideDay7Model;
  }

  /**
   * 7を取得します。
   * @return 7
   */
  public ACListItem getProvideDay7Item1(){
    if(provideDay7Item1==null){

      provideDay7Item1 = new ACListItem();

      provideDay7Item1.setText("7");

      provideDay7Item1.setSimpleValueMode(false);
      provideDay7Item1.put(getProvideDay7().getRenderBindPath(), "7");
      provideDay7Item1.put(getProvideDay7().getBindPath(), new Integer(0));

      addProvideDay7Item1();
    }
    return provideDay7Item1;

  }

  /**
   * 7○を取得します。
   * @return 7○
   */
  public ACListItem getProvideDay7Item2(){
    if(provideDay7Item2==null){

      provideDay7Item2 = new ACListItem();

      provideDay7Item2.setText("7○");

      provideDay7Item2.setSimpleValueMode(false);
      provideDay7Item2.put(getProvideDay7().getRenderBindPath(), "7○");
      provideDay7Item2.put(getProvideDay7().getBindPath(), new Integer(1));

      addProvideDay7Item2();
    }
    return provideDay7Item2;

  }

  /**
   * 7△を取得します。
   * @return 7△
   */
  public ACListItem getProvideDay7Item3(){
    if(provideDay7Item3==null){

      provideDay7Item3 = new ACListItem();

      provideDay7Item3.setText("7△");

      provideDay7Item3.setSimpleValueMode(false);
      provideDay7Item3.put(getProvideDay7().getRenderBindPath(), "7△");
      provideDay7Item3.put(getProvideDay7().getBindPath(), new Integer(2));

      addProvideDay7Item3();
    }
    return provideDay7Item3;

  }

  /**
   * 7◎を取得します。
   * @return 7◎
   */
  public ACListItem getProvideDay7Item4(){
    if(provideDay7Item4==null){

      provideDay7Item4 = new ACListItem();

      provideDay7Item4.setText("7◎");

      provideDay7Item4.setSimpleValueMode(false);
      provideDay7Item4.put(getProvideDay7().getRenderBindPath(), "7◎");
      provideDay7Item4.put(getProvideDay7().getBindPath(), new Integer(3));

      addProvideDay7Item4();
    }
    return provideDay7Item4;

  }

  /**
   * 7△◎を取得します。
   * @return 7△◎
   */
  public ACListItem getProvideDay7Item5(){
    if(provideDay7Item5==null){

      provideDay7Item5 = new ACListItem();

      provideDay7Item5.setText("7△◎");

      provideDay7Item5.setSimpleValueMode(false);
      provideDay7Item5.put(getProvideDay7().getRenderBindPath(), "7△◎");
      provideDay7Item5.put(getProvideDay7().getBindPath(), new Integer(4));

      addProvideDay7Item5();
    }
    return provideDay7Item5;

  }

  /**
   * 7◇を取得します。
   * @return 7◇
   */
  public ACListItem getProvideDay7Item6(){
    if(provideDay7Item6==null){

      provideDay7Item6 = new ACListItem();

      provideDay7Item6.setText("7◇");

      provideDay7Item6.setSimpleValueMode(false);
      provideDay7Item6.put(getProvideDay7().getRenderBindPath(), "7◇");
      provideDay7Item6.put(getProvideDay7().getBindPath(), new Integer(5));

      addProvideDay7Item6();
    }
    return provideDay7Item6;

  }

  /**
   * 7△◇を取得します。
   * @return 7△◇
   */
  public ACListItem getProvideDay7Item7(){
    if(provideDay7Item7==null){

      provideDay7Item7 = new ACListItem();

      provideDay7Item7.setText("7△◇");

      provideDay7Item7.setSimpleValueMode(false);
      provideDay7Item7.put(getProvideDay7().getRenderBindPath(), "7△◇");
      provideDay7Item7.put(getProvideDay7().getBindPath(), new Integer(6));

      addProvideDay7Item7();
    }
    return provideDay7Item7;

  }

  /**
   * 提供日8を取得します。
   * @return 提供日8
   */
  public ACComboBox getProvideDay8(){
    if(provideDay8==null){

      provideDay8 = new ACComboBox();

      provideDay8.setBindPath("PROVIDE_DAY_8");

      provideDay8.setEditable(false);

      provideDay8.setColumns(4);

      provideDay8.setRenderBindPath("ITEM");

      provideDay8.setMaxColumns(4);

      provideDay8.setModel(getProvideDay8Model());

      addProvideDay8();
    }
    return provideDay8;

  }

  /**
   * 提供日8モデルを取得します。
   * @return 提供日8モデル
   */
  protected ACComboBoxModelAdapter getProvideDay8Model(){
    if(provideDay8Model==null){
      provideDay8Model = new ACComboBoxModelAdapter();
      addProvideDay8Model();
    }
    return provideDay8Model;
  }

  /**
   * 8を取得します。
   * @return 8
   */
  public ACListItem getProvideDay8Item1(){
    if(provideDay8Item1==null){

      provideDay8Item1 = new ACListItem();

      provideDay8Item1.setText("8");

      provideDay8Item1.setSimpleValueMode(false);
      provideDay8Item1.put(getProvideDay8().getRenderBindPath(), "8");
      provideDay8Item1.put(getProvideDay8().getBindPath(), new Integer(0));

      addProvideDay8Item1();
    }
    return provideDay8Item1;

  }

  /**
   * 8○を取得します。
   * @return 8○
   */
  public ACListItem getProvideDay8Item2(){
    if(provideDay8Item2==null){

      provideDay8Item2 = new ACListItem();

      provideDay8Item2.setText("8○");

      provideDay8Item2.setSimpleValueMode(false);
      provideDay8Item2.put(getProvideDay8().getRenderBindPath(), "8○");
      provideDay8Item2.put(getProvideDay8().getBindPath(), new Integer(1));

      addProvideDay8Item2();
    }
    return provideDay8Item2;

  }

  /**
   * 8△を取得します。
   * @return 8△
   */
  public ACListItem getProvideDay8Item3(){
    if(provideDay8Item3==null){

      provideDay8Item3 = new ACListItem();

      provideDay8Item3.setText("8△");

      provideDay8Item3.setSimpleValueMode(false);
      provideDay8Item3.put(getProvideDay8().getRenderBindPath(), "8△");
      provideDay8Item3.put(getProvideDay8().getBindPath(), new Integer(2));

      addProvideDay8Item3();
    }
    return provideDay8Item3;

  }

  /**
   * 8◎を取得します。
   * @return 8◎
   */
  public ACListItem getProvideDay8Item4(){
    if(provideDay8Item4==null){

      provideDay8Item4 = new ACListItem();

      provideDay8Item4.setText("8◎");

      provideDay8Item4.setSimpleValueMode(false);
      provideDay8Item4.put(getProvideDay8().getRenderBindPath(), "8◎");
      provideDay8Item4.put(getProvideDay8().getBindPath(), new Integer(3));

      addProvideDay8Item4();
    }
    return provideDay8Item4;

  }

  /**
   * 8△◎を取得します。
   * @return 8△◎
   */
  public ACListItem getProvideDay8Item5(){
    if(provideDay8Item5==null){

      provideDay8Item5 = new ACListItem();

      provideDay8Item5.setText("8△◎");

      provideDay8Item5.setSimpleValueMode(false);
      provideDay8Item5.put(getProvideDay8().getRenderBindPath(), "8△◎");
      provideDay8Item5.put(getProvideDay8().getBindPath(), new Integer(4));

      addProvideDay8Item5();
    }
    return provideDay8Item5;

  }

  /**
   * 8◇を取得します。
   * @return 8◇
   */
  public ACListItem getProvideDay8Item6(){
    if(provideDay8Item6==null){

      provideDay8Item6 = new ACListItem();

      provideDay8Item6.setText("8◇");

      provideDay8Item6.setSimpleValueMode(false);
      provideDay8Item6.put(getProvideDay8().getRenderBindPath(), "8◇");
      provideDay8Item6.put(getProvideDay8().getBindPath(), new Integer(5));

      addProvideDay8Item6();
    }
    return provideDay8Item6;

  }

  /**
   * 8△◇を取得します。
   * @return 8△◇
   */
  public ACListItem getProvideDay8Item7(){
    if(provideDay8Item7==null){

      provideDay8Item7 = new ACListItem();

      provideDay8Item7.setText("8△◇");

      provideDay8Item7.setSimpleValueMode(false);
      provideDay8Item7.put(getProvideDay8().getRenderBindPath(), "8△◇");
      provideDay8Item7.put(getProvideDay8().getBindPath(), new Integer(6));

      addProvideDay8Item7();
    }
    return provideDay8Item7;

  }

  /**
   * 提供日9を取得します。
   * @return 提供日9
   */
  public ACComboBox getProvideDay9(){
    if(provideDay9==null){

      provideDay9 = new ACComboBox();

      provideDay9.setBindPath("PROVIDE_DAY_9");

      provideDay9.setEditable(false);

      provideDay9.setColumns(4);

      provideDay9.setRenderBindPath("ITEM");

      provideDay9.setMaxColumns(4);

      provideDay9.setModel(getProvideDay9Model());

      addProvideDay9();
    }
    return provideDay9;

  }

  /**
   * 提供日9モデルを取得します。
   * @return 提供日9モデル
   */
  protected ACComboBoxModelAdapter getProvideDay9Model(){
    if(provideDay9Model==null){
      provideDay9Model = new ACComboBoxModelAdapter();
      addProvideDay9Model();
    }
    return provideDay9Model;
  }

  /**
   * 9を取得します。
   * @return 9
   */
  public ACListItem getProvideDay9Item1(){
    if(provideDay9Item1==null){

      provideDay9Item1 = new ACListItem();

      provideDay9Item1.setText("9");

      provideDay9Item1.setSimpleValueMode(false);
      provideDay9Item1.put(getProvideDay9().getRenderBindPath(), "9");
      provideDay9Item1.put(getProvideDay9().getBindPath(), new Integer(0));

      addProvideDay9Item1();
    }
    return provideDay9Item1;

  }

  /**
   * 9○を取得します。
   * @return 9○
   */
  public ACListItem getProvideDay9Item2(){
    if(provideDay9Item2==null){

      provideDay9Item2 = new ACListItem();

      provideDay9Item2.setText("9○");

      provideDay9Item2.setSimpleValueMode(false);
      provideDay9Item2.put(getProvideDay9().getRenderBindPath(), "9○");
      provideDay9Item2.put(getProvideDay9().getBindPath(), new Integer(1));

      addProvideDay9Item2();
    }
    return provideDay9Item2;

  }

  /**
   * 9△を取得します。
   * @return 9△
   */
  public ACListItem getProvideDay9Item3(){
    if(provideDay9Item3==null){

      provideDay9Item3 = new ACListItem();

      provideDay9Item3.setText("9△");

      provideDay9Item3.setSimpleValueMode(false);
      provideDay9Item3.put(getProvideDay9().getRenderBindPath(), "9△");
      provideDay9Item3.put(getProvideDay9().getBindPath(), new Integer(2));

      addProvideDay9Item3();
    }
    return provideDay9Item3;

  }

  /**
   * 9◎を取得します。
   * @return 9◎
   */
  public ACListItem getProvideDay9Item4(){
    if(provideDay9Item4==null){

      provideDay9Item4 = new ACListItem();

      provideDay9Item4.setText("9◎");

      provideDay9Item4.setSimpleValueMode(false);
      provideDay9Item4.put(getProvideDay9().getRenderBindPath(), "9◎");
      provideDay9Item4.put(getProvideDay9().getBindPath(), new Integer(3));

      addProvideDay9Item4();
    }
    return provideDay9Item4;

  }

  /**
   * 9△◎を取得します。
   * @return 9△◎
   */
  public ACListItem getProvideDay9Item5(){
    if(provideDay9Item5==null){

      provideDay9Item5 = new ACListItem();

      provideDay9Item5.setText("9△◎");

      provideDay9Item5.setSimpleValueMode(false);
      provideDay9Item5.put(getProvideDay9().getRenderBindPath(), "9△◎");
      provideDay9Item5.put(getProvideDay9().getBindPath(), new Integer(4));

      addProvideDay9Item5();
    }
    return provideDay9Item5;

  }

  /**
   * 9◇を取得します。
   * @return 9◇
   */
  public ACListItem getProvideDay9Item6(){
    if(provideDay9Item6==null){

      provideDay9Item6 = new ACListItem();

      provideDay9Item6.setText("9◇");

      provideDay9Item6.setSimpleValueMode(false);
      provideDay9Item6.put(getProvideDay9().getRenderBindPath(), "9◇");
      provideDay9Item6.put(getProvideDay9().getBindPath(), new Integer(5));

      addProvideDay9Item6();
    }
    return provideDay9Item6;

  }

  /**
   * 9△◇を取得します。
   * @return 9△◇
   */
  public ACListItem getProvideDay9Item7(){
    if(provideDay9Item7==null){

      provideDay9Item7 = new ACListItem();

      provideDay9Item7.setText("9△◇");

      provideDay9Item7.setSimpleValueMode(false);
      provideDay9Item7.put(getProvideDay9().getRenderBindPath(), "9△◇");
      provideDay9Item7.put(getProvideDay9().getBindPath(), new Integer(6));

      addProvideDay9Item7();
    }
    return provideDay9Item7;

  }

  /**
   * 提供日10を取得します。
   * @return 提供日10
   */
  public ACComboBox getProvideDay10(){
    if(provideDay10==null){

      provideDay10 = new ACComboBox();

      provideDay10.setBindPath("PROVIDE_DAY_10");

      provideDay10.setEditable(false);

      provideDay10.setColumns(4);

      provideDay10.setRenderBindPath("ITEM");

      provideDay10.setMaxColumns(4);

      provideDay10.setModel(getProvideDay10Model());

      addProvideDay10();
    }
    return provideDay10;

  }

  /**
   * 提供日10モデルを取得します。
   * @return 提供日10モデル
   */
  protected ACComboBoxModelAdapter getProvideDay10Model(){
    if(provideDay10Model==null){
      provideDay10Model = new ACComboBoxModelAdapter();
      addProvideDay10Model();
    }
    return provideDay10Model;
  }

  /**
   * 10を取得します。
   * @return 10
   */
  public ACListItem getProvideDay10Item1(){
    if(provideDay10Item1==null){

      provideDay10Item1 = new ACListItem();

      provideDay10Item1.setText("10");

      provideDay10Item1.setSimpleValueMode(false);
      provideDay10Item1.put(getProvideDay10().getRenderBindPath(), "10");
      provideDay10Item1.put(getProvideDay10().getBindPath(), new Integer(0));

      addProvideDay10Item1();
    }
    return provideDay10Item1;

  }

  /**
   * 10○を取得します。
   * @return 10○
   */
  public ACListItem getProvideDay10Item2(){
    if(provideDay10Item2==null){

      provideDay10Item2 = new ACListItem();

      provideDay10Item2.setText("10○");

      provideDay10Item2.setSimpleValueMode(false);
      provideDay10Item2.put(getProvideDay10().getRenderBindPath(), "10○");
      provideDay10Item2.put(getProvideDay10().getBindPath(), new Integer(1));

      addProvideDay10Item2();
    }
    return provideDay10Item2;

  }

  /**
   * 10△を取得します。
   * @return 10△
   */
  public ACListItem getProvideDay10Item3(){
    if(provideDay10Item3==null){

      provideDay10Item3 = new ACListItem();

      provideDay10Item3.setText("10△");

      provideDay10Item3.setSimpleValueMode(false);
      provideDay10Item3.put(getProvideDay10().getRenderBindPath(), "10△");
      provideDay10Item3.put(getProvideDay10().getBindPath(), new Integer(2));

      addProvideDay10Item3();
    }
    return provideDay10Item3;

  }

  /**
   * 10◎を取得します。
   * @return 10◎
   */
  public ACListItem getProvideDay10Item4(){
    if(provideDay10Item4==null){

      provideDay10Item4 = new ACListItem();

      provideDay10Item4.setText("10◎");

      provideDay10Item4.setSimpleValueMode(false);
      provideDay10Item4.put(getProvideDay10().getRenderBindPath(), "10◎");
      provideDay10Item4.put(getProvideDay10().getBindPath(), new Integer(3));

      addProvideDay10Item4();
    }
    return provideDay10Item4;

  }

  /**
   * 10△◎を取得します。
   * @return 10△◎
   */
  public ACListItem getProvideDay10Item5(){
    if(provideDay10Item5==null){

      provideDay10Item5 = new ACListItem();

      provideDay10Item5.setText("10△◎");

      provideDay10Item5.setSimpleValueMode(false);
      provideDay10Item5.put(getProvideDay10().getRenderBindPath(), "10△◎");
      provideDay10Item5.put(getProvideDay10().getBindPath(), new Integer(4));

      addProvideDay10Item5();
    }
    return provideDay10Item5;

  }

  /**
   * 10◇を取得します。
   * @return 10◇
   */
  public ACListItem getProvideDay10Item6(){
    if(provideDay10Item6==null){

      provideDay10Item6 = new ACListItem();

      provideDay10Item6.setText("10◇");

      provideDay10Item6.setSimpleValueMode(false);
      provideDay10Item6.put(getProvideDay10().getRenderBindPath(), "10◇");
      provideDay10Item6.put(getProvideDay10().getBindPath(), new Integer(5));

      addProvideDay10Item6();
    }
    return provideDay10Item6;

  }

  /**
   * 10△◇を取得します。
   * @return 10△◇
   */
  public ACListItem getProvideDay10Item7(){
    if(provideDay10Item7==null){

      provideDay10Item7 = new ACListItem();

      provideDay10Item7.setText("10△◇");

      provideDay10Item7.setSimpleValueMode(false);
      provideDay10Item7.put(getProvideDay10().getRenderBindPath(), "10△◇");
      provideDay10Item7.put(getProvideDay10().getBindPath(), new Integer(6));

      addProvideDay10Item7();
    }
    return provideDay10Item7;

  }

  /**
   * 提供日11を取得します。
   * @return 提供日11
   */
  public ACComboBox getProvideDay11(){
    if(provideDay11==null){

      provideDay11 = new ACComboBox();

      provideDay11.setBindPath("PROVIDE_DAY_11");

      provideDay11.setEditable(false);

      provideDay11.setColumns(4);

      provideDay11.setRenderBindPath("ITEM");

      provideDay11.setMaxColumns(4);

      provideDay11.setModel(getProvideDay11Model());

      addProvideDay11();
    }
    return provideDay11;

  }

  /**
   * 提供日11モデルを取得します。
   * @return 提供日11モデル
   */
  protected ACComboBoxModelAdapter getProvideDay11Model(){
    if(provideDay11Model==null){
      provideDay11Model = new ACComboBoxModelAdapter();
      addProvideDay11Model();
    }
    return provideDay11Model;
  }

  /**
   * 11を取得します。
   * @return 11
   */
  public ACListItem getProvideDay11Item1(){
    if(provideDay11Item1==null){

      provideDay11Item1 = new ACListItem();

      provideDay11Item1.setText("11");

      provideDay11Item1.setSimpleValueMode(false);
      provideDay11Item1.put(getProvideDay11().getRenderBindPath(), "11");
      provideDay11Item1.put(getProvideDay11().getBindPath(), new Integer(0));

      addProvideDay11Item1();
    }
    return provideDay11Item1;

  }

  /**
   * 11○を取得します。
   * @return 11○
   */
  public ACListItem getProvideDay11Item2(){
    if(provideDay11Item2==null){

      provideDay11Item2 = new ACListItem();

      provideDay11Item2.setText("11○");

      provideDay11Item2.setSimpleValueMode(false);
      provideDay11Item2.put(getProvideDay11().getRenderBindPath(), "11○");
      provideDay11Item2.put(getProvideDay11().getBindPath(), new Integer(1));

      addProvideDay11Item2();
    }
    return provideDay11Item2;

  }

  /**
   * 11△を取得します。
   * @return 11△
   */
  public ACListItem getProvideDay11Item3(){
    if(provideDay11Item3==null){

      provideDay11Item3 = new ACListItem();

      provideDay11Item3.setText("11△");

      provideDay11Item3.setSimpleValueMode(false);
      provideDay11Item3.put(getProvideDay11().getRenderBindPath(), "11△");
      provideDay11Item3.put(getProvideDay11().getBindPath(), new Integer(2));

      addProvideDay11Item3();
    }
    return provideDay11Item3;

  }

  /**
   * 11◎を取得します。
   * @return 11◎
   */
  public ACListItem getProvideDay11Item4(){
    if(provideDay11Item4==null){

      provideDay11Item4 = new ACListItem();

      provideDay11Item4.setText("11◎");

      provideDay11Item4.setSimpleValueMode(false);
      provideDay11Item4.put(getProvideDay11().getRenderBindPath(), "11◎");
      provideDay11Item4.put(getProvideDay11().getBindPath(), new Integer(3));

      addProvideDay11Item4();
    }
    return provideDay11Item4;

  }

  /**
   * 11△◎を取得します。
   * @return 11△◎
   */
  public ACListItem getProvideDay11Item5(){
    if(provideDay11Item5==null){

      provideDay11Item5 = new ACListItem();

      provideDay11Item5.setText("11△◎");

      provideDay11Item5.setSimpleValueMode(false);
      provideDay11Item5.put(getProvideDay11().getRenderBindPath(), "11△◎");
      provideDay11Item5.put(getProvideDay11().getBindPath(), new Integer(4));

      addProvideDay11Item5();
    }
    return provideDay11Item5;

  }

  /**
   * 11◇を取得します。
   * @return 11◇
   */
  public ACListItem getProvideDay11Item6(){
    if(provideDay11Item6==null){

      provideDay11Item6 = new ACListItem();

      provideDay11Item6.setText("11◇");

      provideDay11Item6.setSimpleValueMode(false);
      provideDay11Item6.put(getProvideDay11().getRenderBindPath(), "11◇");
      provideDay11Item6.put(getProvideDay11().getBindPath(), new Integer(5));

      addProvideDay11Item6();
    }
    return provideDay11Item6;

  }

  /**
   * 11△◇を取得します。
   * @return 11△◇
   */
  public ACListItem getProvideDay11Item7(){
    if(provideDay11Item7==null){

      provideDay11Item7 = new ACListItem();

      provideDay11Item7.setText("11△◇");

      provideDay11Item7.setSimpleValueMode(false);
      provideDay11Item7.put(getProvideDay11().getRenderBindPath(), "11△◇");
      provideDay11Item7.put(getProvideDay11().getBindPath(), new Integer(6));

      addProvideDay11Item7();
    }
    return provideDay11Item7;

  }

  /**
   * 提供日12を取得します。
   * @return 提供日12
   */
  public ACComboBox getProvideDay12(){
    if(provideDay12==null){

      provideDay12 = new ACComboBox();

      provideDay12.setBindPath("PROVIDE_DAY_12");

      provideDay12.setEditable(false);

      provideDay12.setColumns(4);

      provideDay12.setRenderBindPath("ITEM");

      provideDay12.setMaxColumns(4);

      provideDay12.setModel(getProvideDay12Model());

      addProvideDay12();
    }
    return provideDay12;

  }

  /**
   * 提供日12モデルを取得します。
   * @return 提供日12モデル
   */
  protected ACComboBoxModelAdapter getProvideDay12Model(){
    if(provideDay12Model==null){
      provideDay12Model = new ACComboBoxModelAdapter();
      addProvideDay12Model();
    }
    return provideDay12Model;
  }

  /**
   * 12を取得します。
   * @return 12
   */
  public ACListItem getProvideDay12Item1(){
    if(provideDay12Item1==null){

      provideDay12Item1 = new ACListItem();

      provideDay12Item1.setText("12");

      provideDay12Item1.setSimpleValueMode(false);
      provideDay12Item1.put(getProvideDay12().getRenderBindPath(), "12");
      provideDay12Item1.put(getProvideDay12().getBindPath(), new Integer(0));

      addProvideDay12Item1();
    }
    return provideDay12Item1;

  }

  /**
   * 12○を取得します。
   * @return 12○
   */
  public ACListItem getProvideDay12Item2(){
    if(provideDay12Item2==null){

      provideDay12Item2 = new ACListItem();

      provideDay12Item2.setText("12○");

      provideDay12Item2.setSimpleValueMode(false);
      provideDay12Item2.put(getProvideDay12().getRenderBindPath(), "12○");
      provideDay12Item2.put(getProvideDay12().getBindPath(), new Integer(1));

      addProvideDay12Item2();
    }
    return provideDay12Item2;

  }

  /**
   * 12△を取得します。
   * @return 12△
   */
  public ACListItem getProvideDay12Item3(){
    if(provideDay12Item3==null){

      provideDay12Item3 = new ACListItem();

      provideDay12Item3.setText("12△");

      provideDay12Item3.setSimpleValueMode(false);
      provideDay12Item3.put(getProvideDay12().getRenderBindPath(), "12△");
      provideDay12Item3.put(getProvideDay12().getBindPath(), new Integer(2));

      addProvideDay12Item3();
    }
    return provideDay12Item3;

  }

  /**
   * 12◎を取得します。
   * @return 12◎
   */
  public ACListItem getProvideDay12Item4(){
    if(provideDay12Item4==null){

      provideDay12Item4 = new ACListItem();

      provideDay12Item4.setText("12◎");

      provideDay12Item4.setSimpleValueMode(false);
      provideDay12Item4.put(getProvideDay12().getRenderBindPath(), "12◎");
      provideDay12Item4.put(getProvideDay12().getBindPath(), new Integer(3));

      addProvideDay12Item4();
    }
    return provideDay12Item4;

  }

  /**
   * 12△◎を取得します。
   * @return 12△◎
   */
  public ACListItem getProvideDay12Item5(){
    if(provideDay12Item5==null){

      provideDay12Item5 = new ACListItem();

      provideDay12Item5.setText("12△◎");

      provideDay12Item5.setSimpleValueMode(false);
      provideDay12Item5.put(getProvideDay12().getRenderBindPath(), "12△◎");
      provideDay12Item5.put(getProvideDay12().getBindPath(), new Integer(4));

      addProvideDay12Item5();
    }
    return provideDay12Item5;

  }

  /**
   * 12◇を取得します。
   * @return 12◇
   */
  public ACListItem getProvideDay12Item6(){
    if(provideDay12Item6==null){

      provideDay12Item6 = new ACListItem();

      provideDay12Item6.setText("12◇");

      provideDay12Item6.setSimpleValueMode(false);
      provideDay12Item6.put(getProvideDay12().getRenderBindPath(), "12◇");
      provideDay12Item6.put(getProvideDay12().getBindPath(), new Integer(5));

      addProvideDay12Item6();
    }
    return provideDay12Item6;

  }

  /**
   * 12△◇を取得します。
   * @return 12△◇
   */
  public ACListItem getProvideDay12Item7(){
    if(provideDay12Item7==null){

      provideDay12Item7 = new ACListItem();

      provideDay12Item7.setText("12△◇");

      provideDay12Item7.setSimpleValueMode(false);
      provideDay12Item7.put(getProvideDay12().getRenderBindPath(), "12△◇");
      provideDay12Item7.put(getProvideDay12().getBindPath(), new Integer(6));

      addProvideDay12Item7();
    }
    return provideDay12Item7;

  }

  /**
   * 提供日13を取得します。
   * @return 提供日13
   */
  public ACComboBox getProvideDay13(){
    if(provideDay13==null){

      provideDay13 = new ACComboBox();

      provideDay13.setBindPath("PROVIDE_DAY_13");

      provideDay13.setEditable(false);

      provideDay13.setColumns(4);

      provideDay13.setRenderBindPath("ITEM");

      provideDay13.setMaxColumns(4);

      provideDay13.setModel(getProvideDay13Model());

      addProvideDay13();
    }
    return provideDay13;

  }

  /**
   * 提供日13モデルを取得します。
   * @return 提供日13モデル
   */
  protected ACComboBoxModelAdapter getProvideDay13Model(){
    if(provideDay13Model==null){
      provideDay13Model = new ACComboBoxModelAdapter();
      addProvideDay13Model();
    }
    return provideDay13Model;
  }

  /**
   * 13を取得します。
   * @return 13
   */
  public ACListItem getProvideDay13Item1(){
    if(provideDay13Item1==null){

      provideDay13Item1 = new ACListItem();

      provideDay13Item1.setText("13");

      provideDay13Item1.setSimpleValueMode(false);
      provideDay13Item1.put(getProvideDay13().getRenderBindPath(), "13");
      provideDay13Item1.put(getProvideDay13().getBindPath(), new Integer(0));

      addProvideDay13Item1();
    }
    return provideDay13Item1;

  }

  /**
   * 13○を取得します。
   * @return 13○
   */
  public ACListItem getProvideDay13Item2(){
    if(provideDay13Item2==null){

      provideDay13Item2 = new ACListItem();

      provideDay13Item2.setText("13○");

      provideDay13Item2.setSimpleValueMode(false);
      provideDay13Item2.put(getProvideDay13().getRenderBindPath(), "13○");
      provideDay13Item2.put(getProvideDay13().getBindPath(), new Integer(1));

      addProvideDay13Item2();
    }
    return provideDay13Item2;

  }

  /**
   * 13△を取得します。
   * @return 13△
   */
  public ACListItem getProvideDay13Item3(){
    if(provideDay13Item3==null){

      provideDay13Item3 = new ACListItem();

      provideDay13Item3.setText("13△");

      provideDay13Item3.setSimpleValueMode(false);
      provideDay13Item3.put(getProvideDay13().getRenderBindPath(), "13△");
      provideDay13Item3.put(getProvideDay13().getBindPath(), new Integer(2));

      addProvideDay13Item3();
    }
    return provideDay13Item3;

  }

  /**
   * 13◎を取得します。
   * @return 13◎
   */
  public ACListItem getProvideDay13Item4(){
    if(provideDay13Item4==null){

      provideDay13Item4 = new ACListItem();

      provideDay13Item4.setText("13◎");

      provideDay13Item4.setSimpleValueMode(false);
      provideDay13Item4.put(getProvideDay13().getRenderBindPath(), "13◎");
      provideDay13Item4.put(getProvideDay13().getBindPath(), new Integer(3));

      addProvideDay13Item4();
    }
    return provideDay13Item4;

  }

  /**
   * 13△◎を取得します。
   * @return 13△◎
   */
  public ACListItem getProvideDay13Item5(){
    if(provideDay13Item5==null){

      provideDay13Item5 = new ACListItem();

      provideDay13Item5.setText("13△◎");

      provideDay13Item5.setSimpleValueMode(false);
      provideDay13Item5.put(getProvideDay13().getRenderBindPath(), "13△◎");
      provideDay13Item5.put(getProvideDay13().getBindPath(), new Integer(4));

      addProvideDay13Item5();
    }
    return provideDay13Item5;

  }

  /**
   * 13◇を取得します。
   * @return 13◇
   */
  public ACListItem getProvideDay13Item6(){
    if(provideDay13Item6==null){

      provideDay13Item6 = new ACListItem();

      provideDay13Item6.setText("13◇");

      provideDay13Item6.setSimpleValueMode(false);
      provideDay13Item6.put(getProvideDay13().getRenderBindPath(), "13◇");
      provideDay13Item6.put(getProvideDay13().getBindPath(), new Integer(5));

      addProvideDay13Item6();
    }
    return provideDay13Item6;

  }

  /**
   * 13△◇を取得します。
   * @return 13△◇
   */
  public ACListItem getProvideDay13Item7(){
    if(provideDay13Item7==null){

      provideDay13Item7 = new ACListItem();

      provideDay13Item7.setText("13△◇");

      provideDay13Item7.setSimpleValueMode(false);
      provideDay13Item7.put(getProvideDay13().getRenderBindPath(), "13△◇");
      provideDay13Item7.put(getProvideDay13().getBindPath(), new Integer(6));

      addProvideDay13Item7();
    }
    return provideDay13Item7;

  }

  /**
   * 提供日14を取得します。
   * @return 提供日14
   */
  public ACComboBox getProvideDay14(){
    if(provideDay14==null){

      provideDay14 = new ACComboBox();

      provideDay14.setBindPath("PROVIDE_DAY_14");

      provideDay14.setEditable(false);

      provideDay14.setColumns(4);

      provideDay14.setRenderBindPath("ITEM");

      provideDay14.setMaxColumns(4);

      provideDay14.setModel(getProvideDay14Model());

      addProvideDay14();
    }
    return provideDay14;

  }

  /**
   * 提供日14モデルを取得します。
   * @return 提供日14モデル
   */
  protected ACComboBoxModelAdapter getProvideDay14Model(){
    if(provideDay14Model==null){
      provideDay14Model = new ACComboBoxModelAdapter();
      addProvideDay14Model();
    }
    return provideDay14Model;
  }

  /**
   * 14を取得します。
   * @return 14
   */
  public ACListItem getProvideDay14Item1(){
    if(provideDay14Item1==null){

      provideDay14Item1 = new ACListItem();

      provideDay14Item1.setText("14");

      provideDay14Item1.setSimpleValueMode(false);
      provideDay14Item1.put(getProvideDay14().getRenderBindPath(), "14");
      provideDay14Item1.put(getProvideDay14().getBindPath(), new Integer(0));

      addProvideDay14Item1();
    }
    return provideDay14Item1;

  }

  /**
   * 14○を取得します。
   * @return 14○
   */
  public ACListItem getProvideDay14Item2(){
    if(provideDay14Item2==null){

      provideDay14Item2 = new ACListItem();

      provideDay14Item2.setText("14○");

      provideDay14Item2.setSimpleValueMode(false);
      provideDay14Item2.put(getProvideDay14().getRenderBindPath(), "14○");
      provideDay14Item2.put(getProvideDay14().getBindPath(), new Integer(1));

      addProvideDay14Item2();
    }
    return provideDay14Item2;

  }

  /**
   * 14△を取得します。
   * @return 14△
   */
  public ACListItem getProvideDay14Item3(){
    if(provideDay14Item3==null){

      provideDay14Item3 = new ACListItem();

      provideDay14Item3.setText("14△");

      provideDay14Item3.setSimpleValueMode(false);
      provideDay14Item3.put(getProvideDay14().getRenderBindPath(), "14△");
      provideDay14Item3.put(getProvideDay14().getBindPath(), new Integer(2));

      addProvideDay14Item3();
    }
    return provideDay14Item3;

  }

  /**
   * 14◎を取得します。
   * @return 14◎
   */
  public ACListItem getProvideDay14Item4(){
    if(provideDay14Item4==null){

      provideDay14Item4 = new ACListItem();

      provideDay14Item4.setText("14◎");

      provideDay14Item4.setSimpleValueMode(false);
      provideDay14Item4.put(getProvideDay14().getRenderBindPath(), "14◎");
      provideDay14Item4.put(getProvideDay14().getBindPath(), new Integer(3));

      addProvideDay14Item4();
    }
    return provideDay14Item4;

  }

  /**
   * 14△◎を取得します。
   * @return 14△◎
   */
  public ACListItem getProvideDay14Item5(){
    if(provideDay14Item5==null){

      provideDay14Item5 = new ACListItem();

      provideDay14Item5.setText("14△◎");

      provideDay14Item5.setSimpleValueMode(false);
      provideDay14Item5.put(getProvideDay14().getRenderBindPath(), "14△◎");
      provideDay14Item5.put(getProvideDay14().getBindPath(), new Integer(4));

      addProvideDay14Item5();
    }
    return provideDay14Item5;

  }

  /**
   * 14◇を取得します。
   * @return 14◇
   */
  public ACListItem getProvideDay14Item6(){
    if(provideDay14Item6==null){

      provideDay14Item6 = new ACListItem();

      provideDay14Item6.setText("14◇");

      provideDay14Item6.setSimpleValueMode(false);
      provideDay14Item6.put(getProvideDay14().getRenderBindPath(), "14◇");
      provideDay14Item6.put(getProvideDay14().getBindPath(), new Integer(5));

      addProvideDay14Item6();
    }
    return provideDay14Item6;

  }

  /**
   * 14△◇を取得します。
   * @return 14△◇
   */
  public ACListItem getProvideDay14Item7(){
    if(provideDay14Item7==null){

      provideDay14Item7 = new ACListItem();

      provideDay14Item7.setText("14△◇");

      provideDay14Item7.setSimpleValueMode(false);
      provideDay14Item7.put(getProvideDay14().getRenderBindPath(), "14△◇");
      provideDay14Item7.put(getProvideDay14().getBindPath(), new Integer(6));

      addProvideDay14Item7();
    }
    return provideDay14Item7;

  }

  /**
   * 提供日15を取得します。
   * @return 提供日15
   */
  public ACComboBox getProvideDay15(){
    if(provideDay15==null){

      provideDay15 = new ACComboBox();

      provideDay15.setBindPath("PROVIDE_DAY_15");

      provideDay15.setEditable(false);

      provideDay15.setColumns(4);

      provideDay15.setRenderBindPath("ITEM");

      provideDay15.setMaxColumns(4);

      provideDay15.setModel(getProvideDay15Model());

      addProvideDay15();
    }
    return provideDay15;

  }

  /**
   * 提供日15モデルを取得します。
   * @return 提供日15モデル
   */
  protected ACComboBoxModelAdapter getProvideDay15Model(){
    if(provideDay15Model==null){
      provideDay15Model = new ACComboBoxModelAdapter();
      addProvideDay15Model();
    }
    return provideDay15Model;
  }

  /**
   * 15を取得します。
   * @return 15
   */
  public ACListItem getProvideDay15Item1(){
    if(provideDay15Item1==null){

      provideDay15Item1 = new ACListItem();

      provideDay15Item1.setText("15");

      provideDay15Item1.setSimpleValueMode(false);
      provideDay15Item1.put(getProvideDay15().getRenderBindPath(), "15");
      provideDay15Item1.put(getProvideDay15().getBindPath(), new Integer(0));

      addProvideDay15Item1();
    }
    return provideDay15Item1;

  }

  /**
   * 15○を取得します。
   * @return 15○
   */
  public ACListItem getProvideDay15Item2(){
    if(provideDay15Item2==null){

      provideDay15Item2 = new ACListItem();

      provideDay15Item2.setText("15○");

      provideDay15Item2.setSimpleValueMode(false);
      provideDay15Item2.put(getProvideDay15().getRenderBindPath(), "15○");
      provideDay15Item2.put(getProvideDay15().getBindPath(), new Integer(1));

      addProvideDay15Item2();
    }
    return provideDay15Item2;

  }

  /**
   * 15△を取得します。
   * @return 15△
   */
  public ACListItem getProvideDay15Item3(){
    if(provideDay15Item3==null){

      provideDay15Item3 = new ACListItem();

      provideDay15Item3.setText("15△");

      provideDay15Item3.setSimpleValueMode(false);
      provideDay15Item3.put(getProvideDay15().getRenderBindPath(), "15△");
      provideDay15Item3.put(getProvideDay15().getBindPath(), new Integer(2));

      addProvideDay15Item3();
    }
    return provideDay15Item3;

  }

  /**
   * 15◎を取得します。
   * @return 15◎
   */
  public ACListItem getProvideDay15Item4(){
    if(provideDay15Item4==null){

      provideDay15Item4 = new ACListItem();

      provideDay15Item4.setText("15◎");

      provideDay15Item4.setSimpleValueMode(false);
      provideDay15Item4.put(getProvideDay15().getRenderBindPath(), "15◎");
      provideDay15Item4.put(getProvideDay15().getBindPath(), new Integer(3));

      addProvideDay15Item4();
    }
    return provideDay15Item4;

  }

  /**
   * 15△◎を取得します。
   * @return 15△◎
   */
  public ACListItem getProvideDay15Item5(){
    if(provideDay15Item5==null){

      provideDay15Item5 = new ACListItem();

      provideDay15Item5.setText("15△◎");

      provideDay15Item5.setSimpleValueMode(false);
      provideDay15Item5.put(getProvideDay15().getRenderBindPath(), "15△◎");
      provideDay15Item5.put(getProvideDay15().getBindPath(), new Integer(4));

      addProvideDay15Item5();
    }
    return provideDay15Item5;

  }

  /**
   * 15◇を取得します。
   * @return 15◇
   */
  public ACListItem getProvideDay15Item6(){
    if(provideDay15Item6==null){

      provideDay15Item6 = new ACListItem();

      provideDay15Item6.setText("15◇");

      provideDay15Item6.setSimpleValueMode(false);
      provideDay15Item6.put(getProvideDay15().getRenderBindPath(), "15◇");
      provideDay15Item6.put(getProvideDay15().getBindPath(), new Integer(5));

      addProvideDay15Item6();
    }
    return provideDay15Item6;

  }

  /**
   * 15△◇を取得します。
   * @return 15△◇
   */
  public ACListItem getProvideDay15Item7(){
    if(provideDay15Item7==null){

      provideDay15Item7 = new ACListItem();

      provideDay15Item7.setText("15△◇");

      provideDay15Item7.setSimpleValueMode(false);
      provideDay15Item7.put(getProvideDay15().getRenderBindPath(), "15△◇");
      provideDay15Item7.put(getProvideDay15().getBindPath(), new Integer(6));

      addProvideDay15Item7();
    }
    return provideDay15Item7;

  }

  /**
   * 提供日16を取得します。
   * @return 提供日16
   */
  public ACComboBox getProvideDay16(){
    if(provideDay16==null){

      provideDay16 = new ACComboBox();

      provideDay16.setBindPath("PROVIDE_DAY_16");

      provideDay16.setEditable(false);

      provideDay16.setColumns(4);

      provideDay16.setRenderBindPath("ITEM");

      provideDay16.setMaxColumns(4);

      provideDay16.setModel(getProvideDay16Model());

      addProvideDay16();
    }
    return provideDay16;

  }

  /**
   * 提供日16モデルを取得します。
   * @return 提供日16モデル
   */
  protected ACComboBoxModelAdapter getProvideDay16Model(){
    if(provideDay16Model==null){
      provideDay16Model = new ACComboBoxModelAdapter();
      addProvideDay16Model();
    }
    return provideDay16Model;
  }

  /**
   * 16を取得します。
   * @return 16
   */
  public ACListItem getProvideDay16Item1(){
    if(provideDay16Item1==null){

      provideDay16Item1 = new ACListItem();

      provideDay16Item1.setText("16");

      provideDay16Item1.setSimpleValueMode(false);
      provideDay16Item1.put(getProvideDay16().getRenderBindPath(), "16");
      provideDay16Item1.put(getProvideDay16().getBindPath(), new Integer(0));

      addProvideDay16Item1();
    }
    return provideDay16Item1;

  }

  /**
   * 16○を取得します。
   * @return 16○
   */
  public ACListItem getProvideDay16Item2(){
    if(provideDay16Item2==null){

      provideDay16Item2 = new ACListItem();

      provideDay16Item2.setText("16○");

      provideDay16Item2.setSimpleValueMode(false);
      provideDay16Item2.put(getProvideDay16().getRenderBindPath(), "16○");
      provideDay16Item2.put(getProvideDay16().getBindPath(), new Integer(1));

      addProvideDay16Item2();
    }
    return provideDay16Item2;

  }

  /**
   * 16△を取得します。
   * @return 16△
   */
  public ACListItem getProvideDay16Item3(){
    if(provideDay16Item3==null){

      provideDay16Item3 = new ACListItem();

      provideDay16Item3.setText("16△");

      provideDay16Item3.setSimpleValueMode(false);
      provideDay16Item3.put(getProvideDay16().getRenderBindPath(), "16△");
      provideDay16Item3.put(getProvideDay16().getBindPath(), new Integer(2));

      addProvideDay16Item3();
    }
    return provideDay16Item3;

  }

  /**
   * 16◎を取得します。
   * @return 16◎
   */
  public ACListItem getProvideDay16Item4(){
    if(provideDay16Item4==null){

      provideDay16Item4 = new ACListItem();

      provideDay16Item4.setText("16◎");

      provideDay16Item4.setSimpleValueMode(false);
      provideDay16Item4.put(getProvideDay16().getRenderBindPath(), "16◎");
      provideDay16Item4.put(getProvideDay16().getBindPath(), new Integer(3));

      addProvideDay16Item4();
    }
    return provideDay16Item4;

  }

  /**
   * 16△◎を取得します。
   * @return 16△◎
   */
  public ACListItem getProvideDay16Item5(){
    if(provideDay16Item5==null){

      provideDay16Item5 = new ACListItem();

      provideDay16Item5.setText("16△◎");

      provideDay16Item5.setSimpleValueMode(false);
      provideDay16Item5.put(getProvideDay16().getRenderBindPath(), "16△◎");
      provideDay16Item5.put(getProvideDay16().getBindPath(), new Integer(4));

      addProvideDay16Item5();
    }
    return provideDay16Item5;

  }

  /**
   * 16◇を取得します。
   * @return 16◇
   */
  public ACListItem getProvideDay16Item6(){
    if(provideDay16Item6==null){

      provideDay16Item6 = new ACListItem();

      provideDay16Item6.setText("16◇");

      provideDay16Item6.setSimpleValueMode(false);
      provideDay16Item6.put(getProvideDay16().getRenderBindPath(), "16◇");
      provideDay16Item6.put(getProvideDay16().getBindPath(), new Integer(5));

      addProvideDay16Item6();
    }
    return provideDay16Item6;

  }

  /**
   * 16△◇を取得します。
   * @return 16△◇
   */
  public ACListItem getProvideDay16Item7(){
    if(provideDay16Item7==null){

      provideDay16Item7 = new ACListItem();

      provideDay16Item7.setText("16△◇");

      provideDay16Item7.setSimpleValueMode(false);
      provideDay16Item7.put(getProvideDay16().getRenderBindPath(), "16△◇");
      provideDay16Item7.put(getProvideDay16().getBindPath(), new Integer(6));

      addProvideDay16Item7();
    }
    return provideDay16Item7;

  }

  /**
   * 提供日17を取得します。
   * @return 提供日17
   */
  public ACComboBox getProvideDay17(){
    if(provideDay17==null){

      provideDay17 = new ACComboBox();

      provideDay17.setBindPath("PROVIDE_DAY_17");

      provideDay17.setEditable(false);

      provideDay17.setColumns(4);

      provideDay17.setRenderBindPath("ITEM");

      provideDay17.setMaxColumns(4);

      provideDay17.setModel(getProvideDay17Model());

      addProvideDay17();
    }
    return provideDay17;

  }

  /**
   * 提供日17モデルを取得します。
   * @return 提供日17モデル
   */
  protected ACComboBoxModelAdapter getProvideDay17Model(){
    if(provideDay17Model==null){
      provideDay17Model = new ACComboBoxModelAdapter();
      addProvideDay17Model();
    }
    return provideDay17Model;
  }

  /**
   * 17を取得します。
   * @return 17
   */
  public ACListItem getProvideDay17Item1(){
    if(provideDay17Item1==null){

      provideDay17Item1 = new ACListItem();

      provideDay17Item1.setText("17");

      provideDay17Item1.setSimpleValueMode(false);
      provideDay17Item1.put(getProvideDay17().getRenderBindPath(), "17");
      provideDay17Item1.put(getProvideDay17().getBindPath(), new Integer(0));

      addProvideDay17Item1();
    }
    return provideDay17Item1;

  }

  /**
   * 17○を取得します。
   * @return 17○
   */
  public ACListItem getProvideDay17Item2(){
    if(provideDay17Item2==null){

      provideDay17Item2 = new ACListItem();

      provideDay17Item2.setText("17○");

      provideDay17Item2.setSimpleValueMode(false);
      provideDay17Item2.put(getProvideDay17().getRenderBindPath(), "17○");
      provideDay17Item2.put(getProvideDay17().getBindPath(), new Integer(1));

      addProvideDay17Item2();
    }
    return provideDay17Item2;

  }

  /**
   * 17△を取得します。
   * @return 17△
   */
  public ACListItem getProvideDay17Item3(){
    if(provideDay17Item3==null){

      provideDay17Item3 = new ACListItem();

      provideDay17Item3.setText("17△");

      provideDay17Item3.setSimpleValueMode(false);
      provideDay17Item3.put(getProvideDay17().getRenderBindPath(), "17△");
      provideDay17Item3.put(getProvideDay17().getBindPath(), new Integer(2));

      addProvideDay17Item3();
    }
    return provideDay17Item3;

  }

  /**
   * 17◎を取得します。
   * @return 17◎
   */
  public ACListItem getProvideDay17Item4(){
    if(provideDay17Item4==null){

      provideDay17Item4 = new ACListItem();

      provideDay17Item4.setText("17◎");

      provideDay17Item4.setSimpleValueMode(false);
      provideDay17Item4.put(getProvideDay17().getRenderBindPath(), "17◎");
      provideDay17Item4.put(getProvideDay17().getBindPath(), new Integer(3));

      addProvideDay17Item4();
    }
    return provideDay17Item4;

  }

  /**
   * 17△◎を取得します。
   * @return 17△◎
   */
  public ACListItem getProvideDay17Item5(){
    if(provideDay17Item5==null){

      provideDay17Item5 = new ACListItem();

      provideDay17Item5.setText("17△◎");

      provideDay17Item5.setSimpleValueMode(false);
      provideDay17Item5.put(getProvideDay17().getRenderBindPath(), "17△◎");
      provideDay17Item5.put(getProvideDay17().getBindPath(), new Integer(4));

      addProvideDay17Item5();
    }
    return provideDay17Item5;

  }

  /**
   * 17◇を取得します。
   * @return 17◇
   */
  public ACListItem getProvideDay17Item6(){
    if(provideDay17Item6==null){

      provideDay17Item6 = new ACListItem();

      provideDay17Item6.setText("17◇");

      provideDay17Item6.setSimpleValueMode(false);
      provideDay17Item6.put(getProvideDay17().getRenderBindPath(), "17◇");
      provideDay17Item6.put(getProvideDay17().getBindPath(), new Integer(5));

      addProvideDay17Item6();
    }
    return provideDay17Item6;

  }

  /**
   * 17△◇を取得します。
   * @return 17△◇
   */
  public ACListItem getProvideDay17Item7(){
    if(provideDay17Item7==null){

      provideDay17Item7 = new ACListItem();

      provideDay17Item7.setText("17△◇");

      provideDay17Item7.setSimpleValueMode(false);
      provideDay17Item7.put(getProvideDay17().getRenderBindPath(), "17△◇");
      provideDay17Item7.put(getProvideDay17().getBindPath(), new Integer(6));

      addProvideDay17Item7();
    }
    return provideDay17Item7;

  }

  /**
   * 提供日18を取得します。
   * @return 提供日18
   */
  public ACComboBox getProvideDay18(){
    if(provideDay18==null){

      provideDay18 = new ACComboBox();

      provideDay18.setBindPath("PROVIDE_DAY_18");

      provideDay18.setEditable(false);

      provideDay18.setColumns(4);

      provideDay18.setRenderBindPath("ITEM");

      provideDay18.setMaxColumns(4);

      provideDay18.setModel(getProvideDay18Model());

      addProvideDay18();
    }
    return provideDay18;

  }

  /**
   * 提供日18モデルを取得します。
   * @return 提供日18モデル
   */
  protected ACComboBoxModelAdapter getProvideDay18Model(){
    if(provideDay18Model==null){
      provideDay18Model = new ACComboBoxModelAdapter();
      addProvideDay18Model();
    }
    return provideDay18Model;
  }

  /**
   * 18を取得します。
   * @return 18
   */
  public ACListItem getProvideDay18Item1(){
    if(provideDay18Item1==null){

      provideDay18Item1 = new ACListItem();

      provideDay18Item1.setText("18");

      provideDay18Item1.setSimpleValueMode(false);
      provideDay18Item1.put(getProvideDay18().getRenderBindPath(), "18");
      provideDay18Item1.put(getProvideDay18().getBindPath(), new Integer(0));

      addProvideDay18Item1();
    }
    return provideDay18Item1;

  }

  /**
   * 18○を取得します。
   * @return 18○
   */
  public ACListItem getProvideDay18Item2(){
    if(provideDay18Item2==null){

      provideDay18Item2 = new ACListItem();

      provideDay18Item2.setText("18○");

      provideDay18Item2.setSimpleValueMode(false);
      provideDay18Item2.put(getProvideDay18().getRenderBindPath(), "18○");
      provideDay18Item2.put(getProvideDay18().getBindPath(), new Integer(1));

      addProvideDay18Item2();
    }
    return provideDay18Item2;

  }

  /**
   * 18△を取得します。
   * @return 18△
   */
  public ACListItem getProvideDay18Item3(){
    if(provideDay18Item3==null){

      provideDay18Item3 = new ACListItem();

      provideDay18Item3.setText("18△");

      provideDay18Item3.setSimpleValueMode(false);
      provideDay18Item3.put(getProvideDay18().getRenderBindPath(), "18△");
      provideDay18Item3.put(getProvideDay18().getBindPath(), new Integer(2));

      addProvideDay18Item3();
    }
    return provideDay18Item3;

  }

  /**
   * 18◎を取得します。
   * @return 18◎
   */
  public ACListItem getProvideDay18Item4(){
    if(provideDay18Item4==null){

      provideDay18Item4 = new ACListItem();

      provideDay18Item4.setText("18◎");

      provideDay18Item4.setSimpleValueMode(false);
      provideDay18Item4.put(getProvideDay18().getRenderBindPath(), "18◎");
      provideDay18Item4.put(getProvideDay18().getBindPath(), new Integer(3));

      addProvideDay18Item4();
    }
    return provideDay18Item4;

  }

  /**
   * 18△◎を取得します。
   * @return 18△◎
   */
  public ACListItem getProvideDay18Item5(){
    if(provideDay18Item5==null){

      provideDay18Item5 = new ACListItem();

      provideDay18Item5.setText("18△◎");

      provideDay18Item5.setSimpleValueMode(false);
      provideDay18Item5.put(getProvideDay18().getRenderBindPath(), "18△◎");
      provideDay18Item5.put(getProvideDay18().getBindPath(), new Integer(4));

      addProvideDay18Item5();
    }
    return provideDay18Item5;

  }

  /**
   * 18◇を取得します。
   * @return 18◇
   */
  public ACListItem getProvideDay18Item6(){
    if(provideDay18Item6==null){

      provideDay18Item6 = new ACListItem();

      provideDay18Item6.setText("18◇");

      provideDay18Item6.setSimpleValueMode(false);
      provideDay18Item6.put(getProvideDay18().getRenderBindPath(), "18◇");
      provideDay18Item6.put(getProvideDay18().getBindPath(), new Integer(5));

      addProvideDay18Item6();
    }
    return provideDay18Item6;

  }

  /**
   * 18△◇を取得します。
   * @return 18△◇
   */
  public ACListItem getProvideDay18Item7(){
    if(provideDay18Item7==null){

      provideDay18Item7 = new ACListItem();

      provideDay18Item7.setText("18△◇");

      provideDay18Item7.setSimpleValueMode(false);
      provideDay18Item7.put(getProvideDay18().getRenderBindPath(), "18△◇");
      provideDay18Item7.put(getProvideDay18().getBindPath(), new Integer(6));

      addProvideDay18Item7();
    }
    return provideDay18Item7;

  }

  /**
   * 提供日19を取得します。
   * @return 提供日19
   */
  public ACComboBox getProvideDay19(){
    if(provideDay19==null){

      provideDay19 = new ACComboBox();

      provideDay19.setBindPath("PROVIDE_DAY_19");

      provideDay19.setEditable(false);

      provideDay19.setColumns(4);

      provideDay19.setRenderBindPath("ITEM");

      provideDay19.setMaxColumns(4);

      provideDay19.setModel(getProvideDay19Model());

      addProvideDay19();
    }
    return provideDay19;

  }

  /**
   * 提供日19モデルを取得します。
   * @return 提供日19モデル
   */
  protected ACComboBoxModelAdapter getProvideDay19Model(){
    if(provideDay19Model==null){
      provideDay19Model = new ACComboBoxModelAdapter();
      addProvideDay19Model();
    }
    return provideDay19Model;
  }

  /**
   * 19を取得します。
   * @return 19
   */
  public ACListItem getProvideDay19Item1(){
    if(provideDay19Item1==null){

      provideDay19Item1 = new ACListItem();

      provideDay19Item1.setText("19");

      provideDay19Item1.setSimpleValueMode(false);
      provideDay19Item1.put(getProvideDay19().getRenderBindPath(), "19");
      provideDay19Item1.put(getProvideDay19().getBindPath(), new Integer(0));

      addProvideDay19Item1();
    }
    return provideDay19Item1;

  }

  /**
   * 19○を取得します。
   * @return 19○
   */
  public ACListItem getProvideDay19Item2(){
    if(provideDay19Item2==null){

      provideDay19Item2 = new ACListItem();

      provideDay19Item2.setText("19○");

      provideDay19Item2.setSimpleValueMode(false);
      provideDay19Item2.put(getProvideDay19().getRenderBindPath(), "19○");
      provideDay19Item2.put(getProvideDay19().getBindPath(), new Integer(1));

      addProvideDay19Item2();
    }
    return provideDay19Item2;

  }

  /**
   * 19△を取得します。
   * @return 19△
   */
  public ACListItem getProvideDay19Item3(){
    if(provideDay19Item3==null){

      provideDay19Item3 = new ACListItem();

      provideDay19Item3.setText("19△");

      provideDay19Item3.setSimpleValueMode(false);
      provideDay19Item3.put(getProvideDay19().getRenderBindPath(), "19△");
      provideDay19Item3.put(getProvideDay19().getBindPath(), new Integer(2));

      addProvideDay19Item3();
    }
    return provideDay19Item3;

  }

  /**
   * 19◎を取得します。
   * @return 19◎
   */
  public ACListItem getProvideDay19Item4(){
    if(provideDay19Item4==null){

      provideDay19Item4 = new ACListItem();

      provideDay19Item4.setText("19◎");

      provideDay19Item4.setSimpleValueMode(false);
      provideDay19Item4.put(getProvideDay19().getRenderBindPath(), "19◎");
      provideDay19Item4.put(getProvideDay19().getBindPath(), new Integer(3));

      addProvideDay19Item4();
    }
    return provideDay19Item4;

  }

  /**
   * 19△◎を取得します。
   * @return 19△◎
   */
  public ACListItem getProvideDay19Item5(){
    if(provideDay19Item5==null){

      provideDay19Item5 = new ACListItem();

      provideDay19Item5.setText("19△◎");

      provideDay19Item5.setSimpleValueMode(false);
      provideDay19Item5.put(getProvideDay19().getRenderBindPath(), "19△◎");
      provideDay19Item5.put(getProvideDay19().getBindPath(), new Integer(4));

      addProvideDay19Item5();
    }
    return provideDay19Item5;

  }

  /**
   * 19◇を取得します。
   * @return 19◇
   */
  public ACListItem getProvideDay19Item6(){
    if(provideDay19Item6==null){

      provideDay19Item6 = new ACListItem();

      provideDay19Item6.setText("19◇");

      provideDay19Item6.setSimpleValueMode(false);
      provideDay19Item6.put(getProvideDay19().getRenderBindPath(), "19◇");
      provideDay19Item6.put(getProvideDay19().getBindPath(), new Integer(5));

      addProvideDay19Item6();
    }
    return provideDay19Item6;

  }

  /**
   * 19△◇を取得します。
   * @return 19△◇
   */
  public ACListItem getProvideDay19Item7(){
    if(provideDay19Item7==null){

      provideDay19Item7 = new ACListItem();

      provideDay19Item7.setText("19△◇");

      provideDay19Item7.setSimpleValueMode(false);
      provideDay19Item7.put(getProvideDay19().getRenderBindPath(), "19△◇");
      provideDay19Item7.put(getProvideDay19().getBindPath(), new Integer(6));

      addProvideDay19Item7();
    }
    return provideDay19Item7;

  }

  /**
   * 提供日20を取得します。
   * @return 提供日20
   */
  public ACComboBox getProvideDay20(){
    if(provideDay20==null){

      provideDay20 = new ACComboBox();

      provideDay20.setBindPath("PROVIDE_DAY_20");

      provideDay20.setEditable(false);

      provideDay20.setColumns(4);

      provideDay20.setRenderBindPath("ITEM");

      provideDay20.setMaxColumns(4);

      provideDay20.setModel(getProvideDay20Model());

      addProvideDay20();
    }
    return provideDay20;

  }

  /**
   * 提供日20モデルを取得します。
   * @return 提供日20モデル
   */
  protected ACComboBoxModelAdapter getProvideDay20Model(){
    if(provideDay20Model==null){
      provideDay20Model = new ACComboBoxModelAdapter();
      addProvideDay20Model();
    }
    return provideDay20Model;
  }

  /**
   * 20を取得します。
   * @return 20
   */
  public ACListItem getProvideDay20Item1(){
    if(provideDay20Item1==null){

      provideDay20Item1 = new ACListItem();

      provideDay20Item1.setText("20");

      provideDay20Item1.setSimpleValueMode(false);
      provideDay20Item1.put(getProvideDay20().getRenderBindPath(), "20");
      provideDay20Item1.put(getProvideDay20().getBindPath(), new Integer(0));

      addProvideDay20Item1();
    }
    return provideDay20Item1;

  }

  /**
   * 20○を取得します。
   * @return 20○
   */
  public ACListItem getProvideDay20Item2(){
    if(provideDay20Item2==null){

      provideDay20Item2 = new ACListItem();

      provideDay20Item2.setText("20○");

      provideDay20Item2.setSimpleValueMode(false);
      provideDay20Item2.put(getProvideDay20().getRenderBindPath(), "20○");
      provideDay20Item2.put(getProvideDay20().getBindPath(), new Integer(1));

      addProvideDay20Item2();
    }
    return provideDay20Item2;

  }

  /**
   * 20△を取得します。
   * @return 20△
   */
  public ACListItem getProvideDay20Item3(){
    if(provideDay20Item3==null){

      provideDay20Item3 = new ACListItem();

      provideDay20Item3.setText("20△");

      provideDay20Item3.setSimpleValueMode(false);
      provideDay20Item3.put(getProvideDay20().getRenderBindPath(), "20△");
      provideDay20Item3.put(getProvideDay20().getBindPath(), new Integer(2));

      addProvideDay20Item3();
    }
    return provideDay20Item3;

  }

  /**
   * 20◎を取得します。
   * @return 20◎
   */
  public ACListItem getProvideDay20Item4(){
    if(provideDay20Item4==null){

      provideDay20Item4 = new ACListItem();

      provideDay20Item4.setText("20◎");

      provideDay20Item4.setSimpleValueMode(false);
      provideDay20Item4.put(getProvideDay20().getRenderBindPath(), "20◎");
      provideDay20Item4.put(getProvideDay20().getBindPath(), new Integer(3));

      addProvideDay20Item4();
    }
    return provideDay20Item4;

  }

  /**
   * 20△◎を取得します。
   * @return 20△◎
   */
  public ACListItem getProvideDay20Item5(){
    if(provideDay20Item5==null){

      provideDay20Item5 = new ACListItem();

      provideDay20Item5.setText("20△◎");

      provideDay20Item5.setSimpleValueMode(false);
      provideDay20Item5.put(getProvideDay20().getRenderBindPath(), "20△◎");
      provideDay20Item5.put(getProvideDay20().getBindPath(), new Integer(4));

      addProvideDay20Item5();
    }
    return provideDay20Item5;

  }

  /**
   * 20◇を取得します。
   * @return 20◇
   */
  public ACListItem getProvideDay20Item6(){
    if(provideDay20Item6==null){

      provideDay20Item6 = new ACListItem();

      provideDay20Item6.setText("20◇");

      provideDay20Item6.setSimpleValueMode(false);
      provideDay20Item6.put(getProvideDay20().getRenderBindPath(), "20◇");
      provideDay20Item6.put(getProvideDay20().getBindPath(), new Integer(5));

      addProvideDay20Item6();
    }
    return provideDay20Item6;

  }

  /**
   * 20△◇を取得します。
   * @return 20△◇
   */
  public ACListItem getProvideDay20Item7(){
    if(provideDay20Item7==null){

      provideDay20Item7 = new ACListItem();

      provideDay20Item7.setText("20△◇");

      provideDay20Item7.setSimpleValueMode(false);
      provideDay20Item7.put(getProvideDay20().getRenderBindPath(), "20△◇");
      provideDay20Item7.put(getProvideDay20().getBindPath(), new Integer(6));

      addProvideDay20Item7();
    }
    return provideDay20Item7;

  }

  /**
   * 提供日21を取得します。
   * @return 提供日21
   */
  public ACComboBox getProvideDay21(){
    if(provideDay21==null){

      provideDay21 = new ACComboBox();

      provideDay21.setBindPath("PROVIDE_DAY_21");

      provideDay21.setEditable(false);

      provideDay21.setColumns(4);

      provideDay21.setRenderBindPath("ITEM");

      provideDay21.setMaxColumns(4);

      provideDay21.setModel(getProvideDay21Model());

      addProvideDay21();
    }
    return provideDay21;

  }

  /**
   * 提供日21モデルを取得します。
   * @return 提供日21モデル
   */
  protected ACComboBoxModelAdapter getProvideDay21Model(){
    if(provideDay21Model==null){
      provideDay21Model = new ACComboBoxModelAdapter();
      addProvideDay21Model();
    }
    return provideDay21Model;
  }

  /**
   * 21を取得します。
   * @return 21
   */
  public ACListItem getProvideDay21Item1(){
    if(provideDay21Item1==null){

      provideDay21Item1 = new ACListItem();

      provideDay21Item1.setText("21");

      provideDay21Item1.setSimpleValueMode(false);
      provideDay21Item1.put(getProvideDay21().getRenderBindPath(), "21");
      provideDay21Item1.put(getProvideDay21().getBindPath(), new Integer(0));

      addProvideDay21Item1();
    }
    return provideDay21Item1;

  }

  /**
   * 21○を取得します。
   * @return 21○
   */
  public ACListItem getProvideDay21Item2(){
    if(provideDay21Item2==null){

      provideDay21Item2 = new ACListItem();

      provideDay21Item2.setText("21○");

      provideDay21Item2.setSimpleValueMode(false);
      provideDay21Item2.put(getProvideDay21().getRenderBindPath(), "21○");
      provideDay21Item2.put(getProvideDay21().getBindPath(), new Integer(1));

      addProvideDay21Item2();
    }
    return provideDay21Item2;

  }

  /**
   * 21△を取得します。
   * @return 21△
   */
  public ACListItem getProvideDay21Item3(){
    if(provideDay21Item3==null){

      provideDay21Item3 = new ACListItem();

      provideDay21Item3.setText("21△");

      provideDay21Item3.setSimpleValueMode(false);
      provideDay21Item3.put(getProvideDay21().getRenderBindPath(), "21△");
      provideDay21Item3.put(getProvideDay21().getBindPath(), new Integer(2));

      addProvideDay21Item3();
    }
    return provideDay21Item3;

  }

  /**
   * 21◎を取得します。
   * @return 21◎
   */
  public ACListItem getProvideDay21Item4(){
    if(provideDay21Item4==null){

      provideDay21Item4 = new ACListItem();

      provideDay21Item4.setText("21◎");

      provideDay21Item4.setSimpleValueMode(false);
      provideDay21Item4.put(getProvideDay21().getRenderBindPath(), "21◎");
      provideDay21Item4.put(getProvideDay21().getBindPath(), new Integer(3));

      addProvideDay21Item4();
    }
    return provideDay21Item4;

  }

  /**
   * 21△◎を取得します。
   * @return 21△◎
   */
  public ACListItem getProvideDay21Item5(){
    if(provideDay21Item5==null){

      provideDay21Item5 = new ACListItem();

      provideDay21Item5.setText("21△◎");

      provideDay21Item5.setSimpleValueMode(false);
      provideDay21Item5.put(getProvideDay21().getRenderBindPath(), "21△◎");
      provideDay21Item5.put(getProvideDay21().getBindPath(), new Integer(4));

      addProvideDay21Item5();
    }
    return provideDay21Item5;

  }

  /**
   * 21◇を取得します。
   * @return 21◇
   */
  public ACListItem getProvideDay21Item6(){
    if(provideDay21Item6==null){

      provideDay21Item6 = new ACListItem();

      provideDay21Item6.setText("21◇");

      provideDay21Item6.setSimpleValueMode(false);
      provideDay21Item6.put(getProvideDay21().getRenderBindPath(), "21◇");
      provideDay21Item6.put(getProvideDay21().getBindPath(), new Integer(5));

      addProvideDay21Item6();
    }
    return provideDay21Item6;

  }

  /**
   * 21△◇を取得します。
   * @return 21△◇
   */
  public ACListItem getProvideDay21Item7(){
    if(provideDay21Item7==null){

      provideDay21Item7 = new ACListItem();

      provideDay21Item7.setText("21△◇");

      provideDay21Item7.setSimpleValueMode(false);
      provideDay21Item7.put(getProvideDay21().getRenderBindPath(), "21△◇");
      provideDay21Item7.put(getProvideDay21().getBindPath(), new Integer(6));

      addProvideDay21Item7();
    }
    return provideDay21Item7;

  }

  /**
   * 提供日22を取得します。
   * @return 提供日22
   */
  public ACComboBox getProvideDay22(){
    if(provideDay22==null){

      provideDay22 = new ACComboBox();

      provideDay22.setBindPath("PROVIDE_DAY_22");

      provideDay22.setEditable(false);

      provideDay22.setColumns(4);

      provideDay22.setRenderBindPath("ITEM");

      provideDay22.setMaxColumns(4);

      provideDay22.setModel(getProvideDay22Model());

      addProvideDay22();
    }
    return provideDay22;

  }

  /**
   * 提供日22モデルを取得します。
   * @return 提供日22モデル
   */
  protected ACComboBoxModelAdapter getProvideDay22Model(){
    if(provideDay22Model==null){
      provideDay22Model = new ACComboBoxModelAdapter();
      addProvideDay22Model();
    }
    return provideDay22Model;
  }

  /**
   * 22を取得します。
   * @return 22
   */
  public ACListItem getProvideDay22Item1(){
    if(provideDay22Item1==null){

      provideDay22Item1 = new ACListItem();

      provideDay22Item1.setText("22");

      provideDay22Item1.setSimpleValueMode(false);
      provideDay22Item1.put(getProvideDay22().getRenderBindPath(), "22");
      provideDay22Item1.put(getProvideDay22().getBindPath(), new Integer(0));

      addProvideDay22Item1();
    }
    return provideDay22Item1;

  }

  /**
   * 22○を取得します。
   * @return 22○
   */
  public ACListItem getProvideDay22Item2(){
    if(provideDay22Item2==null){

      provideDay22Item2 = new ACListItem();

      provideDay22Item2.setText("22○");

      provideDay22Item2.setSimpleValueMode(false);
      provideDay22Item2.put(getProvideDay22().getRenderBindPath(), "22○");
      provideDay22Item2.put(getProvideDay22().getBindPath(), new Integer(1));

      addProvideDay22Item2();
    }
    return provideDay22Item2;

  }

  /**
   * 22△を取得します。
   * @return 22△
   */
  public ACListItem getProvideDay22Item3(){
    if(provideDay22Item3==null){

      provideDay22Item3 = new ACListItem();

      provideDay22Item3.setText("22△");

      provideDay22Item3.setSimpleValueMode(false);
      provideDay22Item3.put(getProvideDay22().getRenderBindPath(), "22△");
      provideDay22Item3.put(getProvideDay22().getBindPath(), new Integer(2));

      addProvideDay22Item3();
    }
    return provideDay22Item3;

  }

  /**
   * 22◎を取得します。
   * @return 22◎
   */
  public ACListItem getProvideDay22Item4(){
    if(provideDay22Item4==null){

      provideDay22Item4 = new ACListItem();

      provideDay22Item4.setText("22◎");

      provideDay22Item4.setSimpleValueMode(false);
      provideDay22Item4.put(getProvideDay22().getRenderBindPath(), "22◎");
      provideDay22Item4.put(getProvideDay22().getBindPath(), new Integer(3));

      addProvideDay22Item4();
    }
    return provideDay22Item4;

  }

  /**
   * 22△◎を取得します。
   * @return 22△◎
   */
  public ACListItem getProvideDay22Item5(){
    if(provideDay22Item5==null){

      provideDay22Item5 = new ACListItem();

      provideDay22Item5.setText("22△◎");

      provideDay22Item5.setSimpleValueMode(false);
      provideDay22Item5.put(getProvideDay22().getRenderBindPath(), "22△◎");
      provideDay22Item5.put(getProvideDay22().getBindPath(), new Integer(4));

      addProvideDay22Item5();
    }
    return provideDay22Item5;

  }

  /**
   * 22◇を取得します。
   * @return 22◇
   */
  public ACListItem getProvideDay22Item6(){
    if(provideDay22Item6==null){

      provideDay22Item6 = new ACListItem();

      provideDay22Item6.setText("22◇");

      provideDay22Item6.setSimpleValueMode(false);
      provideDay22Item6.put(getProvideDay22().getRenderBindPath(), "22◇");
      provideDay22Item6.put(getProvideDay22().getBindPath(), new Integer(5));

      addProvideDay22Item6();
    }
    return provideDay22Item6;

  }

  /**
   * 22△◇を取得します。
   * @return 22△◇
   */
  public ACListItem getProvideDay22Item7(){
    if(provideDay22Item7==null){

      provideDay22Item7 = new ACListItem();

      provideDay22Item7.setText("22△◇");

      provideDay22Item7.setSimpleValueMode(false);
      provideDay22Item7.put(getProvideDay22().getRenderBindPath(), "22△◇");
      provideDay22Item7.put(getProvideDay22().getBindPath(), new Integer(6));

      addProvideDay22Item7();
    }
    return provideDay22Item7;

  }

  /**
   * 提供日23を取得します。
   * @return 提供日23
   */
  public ACComboBox getProvideDay23(){
    if(provideDay23==null){

      provideDay23 = new ACComboBox();

      provideDay23.setBindPath("PROVIDE_DAY_23");

      provideDay23.setEditable(false);

      provideDay23.setColumns(4);

      provideDay23.setRenderBindPath("ITEM");

      provideDay23.setMaxColumns(4);

      provideDay23.setModel(getProvideDay23Model());

      addProvideDay23();
    }
    return provideDay23;

  }

  /**
   * 提供日23モデルを取得します。
   * @return 提供日23モデル
   */
  protected ACComboBoxModelAdapter getProvideDay23Model(){
    if(provideDay23Model==null){
      provideDay23Model = new ACComboBoxModelAdapter();
      addProvideDay23Model();
    }
    return provideDay23Model;
  }

  /**
   * 23を取得します。
   * @return 23
   */
  public ACListItem getProvideDay23Item1(){
    if(provideDay23Item1==null){

      provideDay23Item1 = new ACListItem();

      provideDay23Item1.setText("23");

      provideDay23Item1.setSimpleValueMode(false);
      provideDay23Item1.put(getProvideDay23().getRenderBindPath(), "23");
      provideDay23Item1.put(getProvideDay23().getBindPath(), new Integer(0));

      addProvideDay23Item1();
    }
    return provideDay23Item1;

  }

  /**
   * 23○を取得します。
   * @return 23○
   */
  public ACListItem getProvideDay23Item2(){
    if(provideDay23Item2==null){

      provideDay23Item2 = new ACListItem();

      provideDay23Item2.setText("23○");

      provideDay23Item2.setSimpleValueMode(false);
      provideDay23Item2.put(getProvideDay23().getRenderBindPath(), "23○");
      provideDay23Item2.put(getProvideDay23().getBindPath(), new Integer(1));

      addProvideDay23Item2();
    }
    return provideDay23Item2;

  }

  /**
   * 23△を取得します。
   * @return 23△
   */
  public ACListItem getProvideDay23Item3(){
    if(provideDay23Item3==null){

      provideDay23Item3 = new ACListItem();

      provideDay23Item3.setText("23△");

      provideDay23Item3.setSimpleValueMode(false);
      provideDay23Item3.put(getProvideDay23().getRenderBindPath(), "23△");
      provideDay23Item3.put(getProvideDay23().getBindPath(), new Integer(2));

      addProvideDay23Item3();
    }
    return provideDay23Item3;

  }

  /**
   * 23◎を取得します。
   * @return 23◎
   */
  public ACListItem getProvideDay23Item4(){
    if(provideDay23Item4==null){

      provideDay23Item4 = new ACListItem();

      provideDay23Item4.setText("23◎");

      provideDay23Item4.setSimpleValueMode(false);
      provideDay23Item4.put(getProvideDay23().getRenderBindPath(), "23◎");
      provideDay23Item4.put(getProvideDay23().getBindPath(), new Integer(3));

      addProvideDay23Item4();
    }
    return provideDay23Item4;

  }

  /**
   * 23△◎を取得します。
   * @return 23△◎
   */
  public ACListItem getProvideDay23Item5(){
    if(provideDay23Item5==null){

      provideDay23Item5 = new ACListItem();

      provideDay23Item5.setText("23△◎");

      provideDay23Item5.setSimpleValueMode(false);
      provideDay23Item5.put(getProvideDay23().getRenderBindPath(), "23△◎");
      provideDay23Item5.put(getProvideDay23().getBindPath(), new Integer(4));

      addProvideDay23Item5();
    }
    return provideDay23Item5;

  }

  /**
   * 23◇を取得します。
   * @return 23◇
   */
  public ACListItem getProvideDay23Item6(){
    if(provideDay23Item6==null){

      provideDay23Item6 = new ACListItem();

      provideDay23Item6.setText("23◇");

      provideDay23Item6.setSimpleValueMode(false);
      provideDay23Item6.put(getProvideDay23().getRenderBindPath(), "23◇");
      provideDay23Item6.put(getProvideDay23().getBindPath(), new Integer(5));

      addProvideDay23Item6();
    }
    return provideDay23Item6;

  }

  /**
   * 23△◇を取得します。
   * @return 23△◇
   */
  public ACListItem getProvideDay23Item7(){
    if(provideDay23Item7==null){

      provideDay23Item7 = new ACListItem();

      provideDay23Item7.setText("23△◇");

      provideDay23Item7.setSimpleValueMode(false);
      provideDay23Item7.put(getProvideDay23().getRenderBindPath(), "23△◇");
      provideDay23Item7.put(getProvideDay23().getBindPath(), new Integer(6));

      addProvideDay23Item7();
    }
    return provideDay23Item7;

  }

  /**
   * 提供日24を取得します。
   * @return 提供日24
   */
  public ACComboBox getProvideDay24(){
    if(provideDay24==null){

      provideDay24 = new ACComboBox();

      provideDay24.setBindPath("PROVIDE_DAY_24");

      provideDay24.setEditable(false);

      provideDay24.setColumns(4);

      provideDay24.setRenderBindPath("ITEM");

      provideDay24.setMaxColumns(4);

      provideDay24.setModel(getProvideDay24Model());

      addProvideDay24();
    }
    return provideDay24;

  }

  /**
   * 提供日24モデルを取得します。
   * @return 提供日24モデル
   */
  protected ACComboBoxModelAdapter getProvideDay24Model(){
    if(provideDay24Model==null){
      provideDay24Model = new ACComboBoxModelAdapter();
      addProvideDay24Model();
    }
    return provideDay24Model;
  }

  /**
   * 24を取得します。
   * @return 24
   */
  public ACListItem getProvideDay24Item1(){
    if(provideDay24Item1==null){

      provideDay24Item1 = new ACListItem();

      provideDay24Item1.setText("24");

      provideDay24Item1.setSimpleValueMode(false);
      provideDay24Item1.put(getProvideDay24().getRenderBindPath(), "24");
      provideDay24Item1.put(getProvideDay24().getBindPath(), new Integer(0));

      addProvideDay24Item1();
    }
    return provideDay24Item1;

  }

  /**
   * 24○を取得します。
   * @return 24○
   */
  public ACListItem getProvideDay24Item2(){
    if(provideDay24Item2==null){

      provideDay24Item2 = new ACListItem();

      provideDay24Item2.setText("24○");

      provideDay24Item2.setSimpleValueMode(false);
      provideDay24Item2.put(getProvideDay24().getRenderBindPath(), "24○");
      provideDay24Item2.put(getProvideDay24().getBindPath(), new Integer(1));

      addProvideDay24Item2();
    }
    return provideDay24Item2;

  }

  /**
   * 24△を取得します。
   * @return 24△
   */
  public ACListItem getProvideDay24Item3(){
    if(provideDay24Item3==null){

      provideDay24Item3 = new ACListItem();

      provideDay24Item3.setText("24△");

      provideDay24Item3.setSimpleValueMode(false);
      provideDay24Item3.put(getProvideDay24().getRenderBindPath(), "24△");
      provideDay24Item3.put(getProvideDay24().getBindPath(), new Integer(2));

      addProvideDay24Item3();
    }
    return provideDay24Item3;

  }

  /**
   * 24◎を取得します。
   * @return 24◎
   */
  public ACListItem getProvideDay24Item4(){
    if(provideDay24Item4==null){

      provideDay24Item4 = new ACListItem();

      provideDay24Item4.setText("24◎");

      provideDay24Item4.setSimpleValueMode(false);
      provideDay24Item4.put(getProvideDay24().getRenderBindPath(), "24◎");
      provideDay24Item4.put(getProvideDay24().getBindPath(), new Integer(3));

      addProvideDay24Item4();
    }
    return provideDay24Item4;

  }

  /**
   * 24△◎を取得します。
   * @return 24△◎
   */
  public ACListItem getProvideDay24Item5(){
    if(provideDay24Item5==null){

      provideDay24Item5 = new ACListItem();

      provideDay24Item5.setText("24△◎");

      provideDay24Item5.setSimpleValueMode(false);
      provideDay24Item5.put(getProvideDay24().getRenderBindPath(), "24△◎");
      provideDay24Item5.put(getProvideDay24().getBindPath(), new Integer(4));

      addProvideDay24Item5();
    }
    return provideDay24Item5;

  }

  /**
   * 24◇を取得します。
   * @return 24◇
   */
  public ACListItem getProvideDay24Item6(){
    if(provideDay24Item6==null){

      provideDay24Item6 = new ACListItem();

      provideDay24Item6.setText("24◇");

      provideDay24Item6.setSimpleValueMode(false);
      provideDay24Item6.put(getProvideDay24().getRenderBindPath(), "24◇");
      provideDay24Item6.put(getProvideDay24().getBindPath(), new Integer(5));

      addProvideDay24Item6();
    }
    return provideDay24Item6;

  }

  /**
   * 24△◇を取得します。
   * @return 24△◇
   */
  public ACListItem getProvideDay24Item7(){
    if(provideDay24Item7==null){

      provideDay24Item7 = new ACListItem();

      provideDay24Item7.setText("24△◇");

      provideDay24Item7.setSimpleValueMode(false);
      provideDay24Item7.put(getProvideDay24().getRenderBindPath(), "24△◇");
      provideDay24Item7.put(getProvideDay24().getBindPath(), new Integer(6));

      addProvideDay24Item7();
    }
    return provideDay24Item7;

  }

  /**
   * 提供日25を取得します。
   * @return 提供日25
   */
  public ACComboBox getProvideDay25(){
    if(provideDay25==null){

      provideDay25 = new ACComboBox();

      provideDay25.setBindPath("PROVIDE_DAY_25");

      provideDay25.setEditable(false);

      provideDay25.setColumns(4);

      provideDay25.setRenderBindPath("ITEM");

      provideDay25.setMaxColumns(4);

      provideDay25.setModel(getProvideDay25Model());

      addProvideDay25();
    }
    return provideDay25;

  }

  /**
   * 提供日25モデルを取得します。
   * @return 提供日25モデル
   */
  protected ACComboBoxModelAdapter getProvideDay25Model(){
    if(provideDay25Model==null){
      provideDay25Model = new ACComboBoxModelAdapter();
      addProvideDay25Model();
    }
    return provideDay25Model;
  }

  /**
   * 25を取得します。
   * @return 25
   */
  public ACListItem getProvideDay25Item1(){
    if(provideDay25Item1==null){

      provideDay25Item1 = new ACListItem();

      provideDay25Item1.setText("25");

      provideDay25Item1.setSimpleValueMode(false);
      provideDay25Item1.put(getProvideDay25().getRenderBindPath(), "25");
      provideDay25Item1.put(getProvideDay25().getBindPath(), new Integer(0));

      addProvideDay25Item1();
    }
    return provideDay25Item1;

  }

  /**
   * 25○を取得します。
   * @return 25○
   */
  public ACListItem getProvideDay25Item2(){
    if(provideDay25Item2==null){

      provideDay25Item2 = new ACListItem();

      provideDay25Item2.setText("25○");

      provideDay25Item2.setSimpleValueMode(false);
      provideDay25Item2.put(getProvideDay25().getRenderBindPath(), "25○");
      provideDay25Item2.put(getProvideDay25().getBindPath(), new Integer(1));

      addProvideDay25Item2();
    }
    return provideDay25Item2;

  }

  /**
   * 25△を取得します。
   * @return 25△
   */
  public ACListItem getProvideDay25Item3(){
    if(provideDay25Item3==null){

      provideDay25Item3 = new ACListItem();

      provideDay25Item3.setText("25△");

      provideDay25Item3.setSimpleValueMode(false);
      provideDay25Item3.put(getProvideDay25().getRenderBindPath(), "25△");
      provideDay25Item3.put(getProvideDay25().getBindPath(), new Integer(2));

      addProvideDay25Item3();
    }
    return provideDay25Item3;

  }

  /**
   * 25◎を取得します。
   * @return 25◎
   */
  public ACListItem getProvideDay25Item4(){
    if(provideDay25Item4==null){

      provideDay25Item4 = new ACListItem();

      provideDay25Item4.setText("25◎");

      provideDay25Item4.setSimpleValueMode(false);
      provideDay25Item4.put(getProvideDay25().getRenderBindPath(), "25◎");
      provideDay25Item4.put(getProvideDay25().getBindPath(), new Integer(3));

      addProvideDay25Item4();
    }
    return provideDay25Item4;

  }

  /**
   * 25△◎を取得します。
   * @return 25△◎
   */
  public ACListItem getProvideDay25Item5(){
    if(provideDay25Item5==null){

      provideDay25Item5 = new ACListItem();

      provideDay25Item5.setText("25△◎");

      provideDay25Item5.setSimpleValueMode(false);
      provideDay25Item5.put(getProvideDay25().getRenderBindPath(), "25△◎");
      provideDay25Item5.put(getProvideDay25().getBindPath(), new Integer(4));

      addProvideDay25Item5();
    }
    return provideDay25Item5;

  }

  /**
   * 25◇を取得します。
   * @return 25◇
   */
  public ACListItem getProvideDay25Item6(){
    if(provideDay25Item6==null){

      provideDay25Item6 = new ACListItem();

      provideDay25Item6.setText("25◇");

      provideDay25Item6.setSimpleValueMode(false);
      provideDay25Item6.put(getProvideDay25().getRenderBindPath(), "25◇");
      provideDay25Item6.put(getProvideDay25().getBindPath(), new Integer(5));

      addProvideDay25Item6();
    }
    return provideDay25Item6;

  }

  /**
   * 25△◇を取得します。
   * @return 25△◇
   */
  public ACListItem getProvideDay25Item7(){
    if(provideDay25Item7==null){

      provideDay25Item7 = new ACListItem();

      provideDay25Item7.setText("25△◇");

      provideDay25Item7.setSimpleValueMode(false);
      provideDay25Item7.put(getProvideDay25().getRenderBindPath(), "25△◇");
      provideDay25Item7.put(getProvideDay25().getBindPath(), new Integer(6));

      addProvideDay25Item7();
    }
    return provideDay25Item7;

  }

  /**
   * 提供日26を取得します。
   * @return 提供日26
   */
  public ACComboBox getProvideDay26(){
    if(provideDay26==null){

      provideDay26 = new ACComboBox();

      provideDay26.setBindPath("PROVIDE_DAY_26");

      provideDay26.setEditable(false);

      provideDay26.setColumns(4);

      provideDay26.setRenderBindPath("ITEM");

      provideDay26.setMaxColumns(4);

      provideDay26.setModel(getProvideDay26Model());

      addProvideDay26();
    }
    return provideDay26;

  }

  /**
   * 提供日26モデルを取得します。
   * @return 提供日26モデル
   */
  protected ACComboBoxModelAdapter getProvideDay26Model(){
    if(provideDay26Model==null){
      provideDay26Model = new ACComboBoxModelAdapter();
      addProvideDay26Model();
    }
    return provideDay26Model;
  }

  /**
   * 26を取得します。
   * @return 26
   */
  public ACListItem getProvideDay26Item1(){
    if(provideDay26Item1==null){

      provideDay26Item1 = new ACListItem();

      provideDay26Item1.setText("26");

      provideDay26Item1.setSimpleValueMode(false);
      provideDay26Item1.put(getProvideDay26().getRenderBindPath(), "26");
      provideDay26Item1.put(getProvideDay26().getBindPath(), new Integer(0));

      addProvideDay26Item1();
    }
    return provideDay26Item1;

  }

  /**
   * 26○を取得します。
   * @return 26○
   */
  public ACListItem getProvideDay26Item2(){
    if(provideDay26Item2==null){

      provideDay26Item2 = new ACListItem();

      provideDay26Item2.setText("26○");

      provideDay26Item2.setSimpleValueMode(false);
      provideDay26Item2.put(getProvideDay26().getRenderBindPath(), "26○");
      provideDay26Item2.put(getProvideDay26().getBindPath(), new Integer(1));

      addProvideDay26Item2();
    }
    return provideDay26Item2;

  }

  /**
   * 26△を取得します。
   * @return 26△
   */
  public ACListItem getProvideDay26Item3(){
    if(provideDay26Item3==null){

      provideDay26Item3 = new ACListItem();

      provideDay26Item3.setText("26△");

      provideDay26Item3.setSimpleValueMode(false);
      provideDay26Item3.put(getProvideDay26().getRenderBindPath(), "26△");
      provideDay26Item3.put(getProvideDay26().getBindPath(), new Integer(2));

      addProvideDay26Item3();
    }
    return provideDay26Item3;

  }

  /**
   * 26◎を取得します。
   * @return 26◎
   */
  public ACListItem getProvideDay26Item4(){
    if(provideDay26Item4==null){

      provideDay26Item4 = new ACListItem();

      provideDay26Item4.setText("26◎");

      provideDay26Item4.setSimpleValueMode(false);
      provideDay26Item4.put(getProvideDay26().getRenderBindPath(), "26◎");
      provideDay26Item4.put(getProvideDay26().getBindPath(), new Integer(3));

      addProvideDay26Item4();
    }
    return provideDay26Item4;

  }

  /**
   * 26△◎を取得します。
   * @return 26△◎
   */
  public ACListItem getProvideDay26Item5(){
    if(provideDay26Item5==null){

      provideDay26Item5 = new ACListItem();

      provideDay26Item5.setText("26△◎");

      provideDay26Item5.setSimpleValueMode(false);
      provideDay26Item5.put(getProvideDay26().getRenderBindPath(), "26△◎");
      provideDay26Item5.put(getProvideDay26().getBindPath(), new Integer(4));

      addProvideDay26Item5();
    }
    return provideDay26Item5;

  }

  /**
   * 26◇を取得します。
   * @return 26◇
   */
  public ACListItem getProvideDay26Item6(){
    if(provideDay26Item6==null){

      provideDay26Item6 = new ACListItem();

      provideDay26Item6.setText("26◇");

      provideDay26Item6.setSimpleValueMode(false);
      provideDay26Item6.put(getProvideDay26().getRenderBindPath(), "26◇");
      provideDay26Item6.put(getProvideDay26().getBindPath(), new Integer(5));

      addProvideDay26Item6();
    }
    return provideDay26Item6;

  }

  /**
   * 26△◇を取得します。
   * @return 26△◇
   */
  public ACListItem getProvideDay26Item7(){
    if(provideDay26Item7==null){

      provideDay26Item7 = new ACListItem();

      provideDay26Item7.setText("26△◇");

      provideDay26Item7.setSimpleValueMode(false);
      provideDay26Item7.put(getProvideDay26().getRenderBindPath(), "26△◇");
      provideDay26Item7.put(getProvideDay26().getBindPath(), new Integer(6));

      addProvideDay26Item7();
    }
    return provideDay26Item7;

  }

  /**
   * 提供日27を取得します。
   * @return 提供日27
   */
  public ACComboBox getProvideDay27(){
    if(provideDay27==null){

      provideDay27 = new ACComboBox();

      provideDay27.setBindPath("PROVIDE_DAY_27");

      provideDay27.setEditable(false);

      provideDay27.setColumns(4);

      provideDay27.setRenderBindPath("ITEM");

      provideDay27.setMaxColumns(4);

      provideDay27.setModel(getProvideDay27Model());

      addProvideDay27();
    }
    return provideDay27;

  }

  /**
   * 提供日27モデルを取得します。
   * @return 提供日27モデル
   */
  protected ACComboBoxModelAdapter getProvideDay27Model(){
    if(provideDay27Model==null){
      provideDay27Model = new ACComboBoxModelAdapter();
      addProvideDay27Model();
    }
    return provideDay27Model;
  }

  /**
   * 27を取得します。
   * @return 27
   */
  public ACListItem getProvideDay27Item1(){
    if(provideDay27Item1==null){

      provideDay27Item1 = new ACListItem();

      provideDay27Item1.setText("27");

      provideDay27Item1.setSimpleValueMode(false);
      provideDay27Item1.put(getProvideDay27().getRenderBindPath(), "27");
      provideDay27Item1.put(getProvideDay27().getBindPath(), new Integer(0));

      addProvideDay27Item1();
    }
    return provideDay27Item1;

  }

  /**
   * 27○を取得します。
   * @return 27○
   */
  public ACListItem getProvideDay27Item2(){
    if(provideDay27Item2==null){

      provideDay27Item2 = new ACListItem();

      provideDay27Item2.setText("27○");

      provideDay27Item2.setSimpleValueMode(false);
      provideDay27Item2.put(getProvideDay27().getRenderBindPath(), "27○");
      provideDay27Item2.put(getProvideDay27().getBindPath(), new Integer(1));

      addProvideDay27Item2();
    }
    return provideDay27Item2;

  }

  /**
   * 27△を取得します。
   * @return 27△
   */
  public ACListItem getProvideDay27Item3(){
    if(provideDay27Item3==null){

      provideDay27Item3 = new ACListItem();

      provideDay27Item3.setText("27△");

      provideDay27Item3.setSimpleValueMode(false);
      provideDay27Item3.put(getProvideDay27().getRenderBindPath(), "27△");
      provideDay27Item3.put(getProvideDay27().getBindPath(), new Integer(2));

      addProvideDay27Item3();
    }
    return provideDay27Item3;

  }

  /**
   * 27◎を取得します。
   * @return 27◎
   */
  public ACListItem getProvideDay27Item4(){
    if(provideDay27Item4==null){

      provideDay27Item4 = new ACListItem();

      provideDay27Item4.setText("27◎");

      provideDay27Item4.setSimpleValueMode(false);
      provideDay27Item4.put(getProvideDay27().getRenderBindPath(), "27◎");
      provideDay27Item4.put(getProvideDay27().getBindPath(), new Integer(3));

      addProvideDay27Item4();
    }
    return provideDay27Item4;

  }

  /**
   * 27△◎を取得します。
   * @return 27△◎
   */
  public ACListItem getProvideDay27Item5(){
    if(provideDay27Item5==null){

      provideDay27Item5 = new ACListItem();

      provideDay27Item5.setText("27△◎");

      provideDay27Item5.setSimpleValueMode(false);
      provideDay27Item5.put(getProvideDay27().getRenderBindPath(), "27△◎");
      provideDay27Item5.put(getProvideDay27().getBindPath(), new Integer(4));

      addProvideDay27Item5();
    }
    return provideDay27Item5;

  }

  /**
   * 27◇を取得します。
   * @return 27◇
   */
  public ACListItem getProvideDay27Item6(){
    if(provideDay27Item6==null){

      provideDay27Item6 = new ACListItem();

      provideDay27Item6.setText("27◇");

      provideDay27Item6.setSimpleValueMode(false);
      provideDay27Item6.put(getProvideDay27().getRenderBindPath(), "27◇");
      provideDay27Item6.put(getProvideDay27().getBindPath(), new Integer(5));

      addProvideDay27Item6();
    }
    return provideDay27Item6;

  }

  /**
   * 27△◇を取得します。
   * @return 27△◇
   */
  public ACListItem getProvideDay27Item7(){
    if(provideDay27Item7==null){

      provideDay27Item7 = new ACListItem();

      provideDay27Item7.setText("27△◇");

      provideDay27Item7.setSimpleValueMode(false);
      provideDay27Item7.put(getProvideDay27().getRenderBindPath(), "27△◇");
      provideDay27Item7.put(getProvideDay27().getBindPath(), new Integer(6));

      addProvideDay27Item7();
    }
    return provideDay27Item7;

  }

  /**
   * 提供日28を取得します。
   * @return 提供日28
   */
  public ACComboBox getProvideDay28(){
    if(provideDay28==null){

      provideDay28 = new ACComboBox();

      provideDay28.setBindPath("PROVIDE_DAY_28");

      provideDay28.setEditable(false);

      provideDay28.setColumns(4);

      provideDay28.setRenderBindPath("ITEM");

      provideDay28.setMaxColumns(4);

      provideDay28.setModel(getProvideDay28Model());

      addProvideDay28();
    }
    return provideDay28;

  }

  /**
   * 提供日28モデルを取得します。
   * @return 提供日28モデル
   */
  protected ACComboBoxModelAdapter getProvideDay28Model(){
    if(provideDay28Model==null){
      provideDay28Model = new ACComboBoxModelAdapter();
      addProvideDay28Model();
    }
    return provideDay28Model;
  }

  /**
   * 28を取得します。
   * @return 28
   */
  public ACListItem getProvideDay28Item1(){
    if(provideDay28Item1==null){

      provideDay28Item1 = new ACListItem();

      provideDay28Item1.setText("28");

      provideDay28Item1.setSimpleValueMode(false);
      provideDay28Item1.put(getProvideDay28().getRenderBindPath(), "28");
      provideDay28Item1.put(getProvideDay28().getBindPath(), new Integer(0));

      addProvideDay28Item1();
    }
    return provideDay28Item1;

  }

  /**
   * 28○を取得します。
   * @return 28○
   */
  public ACListItem getProvideDay28Item2(){
    if(provideDay28Item2==null){

      provideDay28Item2 = new ACListItem();

      provideDay28Item2.setText("28○");

      provideDay28Item2.setSimpleValueMode(false);
      provideDay28Item2.put(getProvideDay28().getRenderBindPath(), "28○");
      provideDay28Item2.put(getProvideDay28().getBindPath(), new Integer(1));

      addProvideDay28Item2();
    }
    return provideDay28Item2;

  }

  /**
   * 28△を取得します。
   * @return 28△
   */
  public ACListItem getProvideDay28Item3(){
    if(provideDay28Item3==null){

      provideDay28Item3 = new ACListItem();

      provideDay28Item3.setText("28△");

      provideDay28Item3.setSimpleValueMode(false);
      provideDay28Item3.put(getProvideDay28().getRenderBindPath(), "28△");
      provideDay28Item3.put(getProvideDay28().getBindPath(), new Integer(2));

      addProvideDay28Item3();
    }
    return provideDay28Item3;

  }

  /**
   * 28◎を取得します。
   * @return 28◎
   */
  public ACListItem getProvideDay28Item4(){
    if(provideDay28Item4==null){

      provideDay28Item4 = new ACListItem();

      provideDay28Item4.setText("28◎");

      provideDay28Item4.setSimpleValueMode(false);
      provideDay28Item4.put(getProvideDay28().getRenderBindPath(), "28◎");
      provideDay28Item4.put(getProvideDay28().getBindPath(), new Integer(3));

      addProvideDay28Item4();
    }
    return provideDay28Item4;

  }

  /**
   * 28△◎を取得します。
   * @return 28△◎
   */
  public ACListItem getProvideDay28Item5(){
    if(provideDay28Item5==null){

      provideDay28Item5 = new ACListItem();

      provideDay28Item5.setText("28△◎");

      provideDay28Item5.setSimpleValueMode(false);
      provideDay28Item5.put(getProvideDay28().getRenderBindPath(), "28△◎");
      provideDay28Item5.put(getProvideDay28().getBindPath(), new Integer(4));

      addProvideDay28Item5();
    }
    return provideDay28Item5;

  }

  /**
   * 28◇を取得します。
   * @return 28◇
   */
  public ACListItem getProvideDay28Item6(){
    if(provideDay28Item6==null){

      provideDay28Item6 = new ACListItem();

      provideDay28Item6.setText("28◇");

      provideDay28Item6.setSimpleValueMode(false);
      provideDay28Item6.put(getProvideDay28().getRenderBindPath(), "28◇");
      provideDay28Item6.put(getProvideDay28().getBindPath(), new Integer(5));

      addProvideDay28Item6();
    }
    return provideDay28Item6;

  }

  /**
   * 28△◇を取得します。
   * @return 28△◇
   */
  public ACListItem getProvideDay28Item7(){
    if(provideDay28Item7==null){

      provideDay28Item7 = new ACListItem();

      provideDay28Item7.setText("28△◇");

      provideDay28Item7.setSimpleValueMode(false);
      provideDay28Item7.put(getProvideDay28().getRenderBindPath(), "28△◇");
      provideDay28Item7.put(getProvideDay28().getBindPath(), new Integer(6));

      addProvideDay28Item7();
    }
    return provideDay28Item7;

  }

  /**
   * 提供日29を取得します。
   * @return 提供日29
   */
  public ACComboBox getProvideDay29(){
    if(provideDay29==null){

      provideDay29 = new ACComboBox();

      provideDay29.setBindPath("PROVIDE_DAY_29");

      provideDay29.setEditable(false);

      provideDay29.setColumns(4);

      provideDay29.setRenderBindPath("ITEM");

      provideDay29.setMaxColumns(4);

      provideDay29.setModel(getProvideDay29Model());

      addProvideDay29();
    }
    return provideDay29;

  }

  /**
   * 提供日29モデルを取得します。
   * @return 提供日29モデル
   */
  protected ACComboBoxModelAdapter getProvideDay29Model(){
    if(provideDay29Model==null){
      provideDay29Model = new ACComboBoxModelAdapter();
      addProvideDay29Model();
    }
    return provideDay29Model;
  }

  /**
   * 29を取得します。
   * @return 29
   */
  public ACListItem getProvideDay29Item1(){
    if(provideDay29Item1==null){

      provideDay29Item1 = new ACListItem();

      provideDay29Item1.setText("29");

      provideDay29Item1.setSimpleValueMode(false);
      provideDay29Item1.put(getProvideDay29().getRenderBindPath(), "29");
      provideDay29Item1.put(getProvideDay29().getBindPath(), new Integer(0));

      addProvideDay29Item1();
    }
    return provideDay29Item1;

  }

  /**
   * 29○を取得します。
   * @return 29○
   */
  public ACListItem getProvideDay29Item2(){
    if(provideDay29Item2==null){

      provideDay29Item2 = new ACListItem();

      provideDay29Item2.setText("29○");

      provideDay29Item2.setSimpleValueMode(false);
      provideDay29Item2.put(getProvideDay29().getRenderBindPath(), "29○");
      provideDay29Item2.put(getProvideDay29().getBindPath(), new Integer(1));

      addProvideDay29Item2();
    }
    return provideDay29Item2;

  }

  /**
   * 29△を取得します。
   * @return 29△
   */
  public ACListItem getProvideDay29Item3(){
    if(provideDay29Item3==null){

      provideDay29Item3 = new ACListItem();

      provideDay29Item3.setText("29△");

      provideDay29Item3.setSimpleValueMode(false);
      provideDay29Item3.put(getProvideDay29().getRenderBindPath(), "29△");
      provideDay29Item3.put(getProvideDay29().getBindPath(), new Integer(2));

      addProvideDay29Item3();
    }
    return provideDay29Item3;

  }

  /**
   * 29◎を取得します。
   * @return 29◎
   */
  public ACListItem getProvideDay29Item4(){
    if(provideDay29Item4==null){

      provideDay29Item4 = new ACListItem();

      provideDay29Item4.setText("29◎");

      provideDay29Item4.setSimpleValueMode(false);
      provideDay29Item4.put(getProvideDay29().getRenderBindPath(), "29◎");
      provideDay29Item4.put(getProvideDay29().getBindPath(), new Integer(3));

      addProvideDay29Item4();
    }
    return provideDay29Item4;

  }

  /**
   * 29△◎を取得します。
   * @return 29△◎
   */
  public ACListItem getProvideDay29Item5(){
    if(provideDay29Item5==null){

      provideDay29Item5 = new ACListItem();

      provideDay29Item5.setText("29△◎");

      provideDay29Item5.setSimpleValueMode(false);
      provideDay29Item5.put(getProvideDay29().getRenderBindPath(), "29△◎");
      provideDay29Item5.put(getProvideDay29().getBindPath(), new Integer(4));

      addProvideDay29Item5();
    }
    return provideDay29Item5;

  }

  /**
   * 29◇を取得します。
   * @return 29◇
   */
  public ACListItem getProvideDay29Item6(){
    if(provideDay29Item6==null){

      provideDay29Item6 = new ACListItem();

      provideDay29Item6.setText("29◇");

      provideDay29Item6.setSimpleValueMode(false);
      provideDay29Item6.put(getProvideDay29().getRenderBindPath(), "29◇");
      provideDay29Item6.put(getProvideDay29().getBindPath(), new Integer(5));

      addProvideDay29Item6();
    }
    return provideDay29Item6;

  }

  /**
   * 29△◇を取得します。
   * @return 29△◇
   */
  public ACListItem getProvideDay29Item7(){
    if(provideDay29Item7==null){

      provideDay29Item7 = new ACListItem();

      provideDay29Item7.setText("29△◇");

      provideDay29Item7.setSimpleValueMode(false);
      provideDay29Item7.put(getProvideDay29().getRenderBindPath(), "29△◇");
      provideDay29Item7.put(getProvideDay29().getBindPath(), new Integer(6));

      addProvideDay29Item7();
    }
    return provideDay29Item7;

  }

  /**
   * 提供日30を取得します。
   * @return 提供日30
   */
  public ACComboBox getProvideDay30(){
    if(provideDay30==null){

      provideDay30 = new ACComboBox();

      provideDay30.setBindPath("PROVIDE_DAY_30");

      provideDay30.setEditable(false);

      provideDay30.setColumns(4);

      provideDay30.setRenderBindPath("ITEM");

      provideDay30.setMaxColumns(4);

      provideDay30.setModel(getProvideDay30Model());

      addProvideDay30();
    }
    return provideDay30;

  }

  /**
   * 提供日30モデルを取得します。
   * @return 提供日30モデル
   */
  protected ACComboBoxModelAdapter getProvideDay30Model(){
    if(provideDay30Model==null){
      provideDay30Model = new ACComboBoxModelAdapter();
      addProvideDay30Model();
    }
    return provideDay30Model;
  }

  /**
   * 30を取得します。
   * @return 30
   */
  public ACListItem getProvideDay30Item1(){
    if(provideDay30Item1==null){

      provideDay30Item1 = new ACListItem();

      provideDay30Item1.setText("30");

      provideDay30Item1.setSimpleValueMode(false);
      provideDay30Item1.put(getProvideDay30().getRenderBindPath(), "30");
      provideDay30Item1.put(getProvideDay30().getBindPath(), new Integer(0));

      addProvideDay30Item1();
    }
    return provideDay30Item1;

  }

  /**
   * 30○を取得します。
   * @return 30○
   */
  public ACListItem getProvideDay30Item2(){
    if(provideDay30Item2==null){

      provideDay30Item2 = new ACListItem();

      provideDay30Item2.setText("30○");

      provideDay30Item2.setSimpleValueMode(false);
      provideDay30Item2.put(getProvideDay30().getRenderBindPath(), "30○");
      provideDay30Item2.put(getProvideDay30().getBindPath(), new Integer(1));

      addProvideDay30Item2();
    }
    return provideDay30Item2;

  }

  /**
   * 30△を取得します。
   * @return 30△
   */
  public ACListItem getProvideDay30Item3(){
    if(provideDay30Item3==null){

      provideDay30Item3 = new ACListItem();

      provideDay30Item3.setText("30△");

      provideDay30Item3.setSimpleValueMode(false);
      provideDay30Item3.put(getProvideDay30().getRenderBindPath(), "30△");
      provideDay30Item3.put(getProvideDay30().getBindPath(), new Integer(2));

      addProvideDay30Item3();
    }
    return provideDay30Item3;

  }

  /**
   * 30◎を取得します。
   * @return 30◎
   */
  public ACListItem getProvideDay30Item4(){
    if(provideDay30Item4==null){

      provideDay30Item4 = new ACListItem();

      provideDay30Item4.setText("30◎");

      provideDay30Item4.setSimpleValueMode(false);
      provideDay30Item4.put(getProvideDay30().getRenderBindPath(), "30◎");
      provideDay30Item4.put(getProvideDay30().getBindPath(), new Integer(3));

      addProvideDay30Item4();
    }
    return provideDay30Item4;

  }

  /**
   * 30△◎を取得します。
   * @return 30△◎
   */
  public ACListItem getProvideDay30Item5(){
    if(provideDay30Item5==null){

      provideDay30Item5 = new ACListItem();

      provideDay30Item5.setText("30△◎");

      provideDay30Item5.setSimpleValueMode(false);
      provideDay30Item5.put(getProvideDay30().getRenderBindPath(), "30△◎");
      provideDay30Item5.put(getProvideDay30().getBindPath(), new Integer(4));

      addProvideDay30Item5();
    }
    return provideDay30Item5;

  }

  /**
   * 30◇を取得します。
   * @return 30◇
   */
  public ACListItem getProvideDay30Item6(){
    if(provideDay30Item6==null){

      provideDay30Item6 = new ACListItem();

      provideDay30Item6.setText("30◇");

      provideDay30Item6.setSimpleValueMode(false);
      provideDay30Item6.put(getProvideDay30().getRenderBindPath(), "30◇");
      provideDay30Item6.put(getProvideDay30().getBindPath(), new Integer(5));

      addProvideDay30Item6();
    }
    return provideDay30Item6;

  }

  /**
   * 30△◇を取得します。
   * @return 30△◇
   */
  public ACListItem getProvideDay30Item7(){
    if(provideDay30Item7==null){

      provideDay30Item7 = new ACListItem();

      provideDay30Item7.setText("30△◇");

      provideDay30Item7.setSimpleValueMode(false);
      provideDay30Item7.put(getProvideDay30().getRenderBindPath(), "30△◇");
      provideDay30Item7.put(getProvideDay30().getBindPath(), new Integer(6));

      addProvideDay30Item7();
    }
    return provideDay30Item7;

  }

  /**
   * 提供日31を取得します。
   * @return 提供日31
   */
  public ACComboBox getProvideDay31(){
    if(provideDay31==null){

      provideDay31 = new ACComboBox();

      provideDay31.setBindPath("PROVIDE_DAY_31");

      provideDay31.setEditable(false);

      provideDay31.setColumns(4);

      provideDay31.setRenderBindPath("ITEM");

      provideDay31.setMaxColumns(4);

      provideDay31.setModel(getProvideDay31Model());

      addProvideDay31();
    }
    return provideDay31;

  }

  /**
   * 提供日31モデルを取得します。
   * @return 提供日31モデル
   */
  protected ACComboBoxModelAdapter getProvideDay31Model(){
    if(provideDay31Model==null){
      provideDay31Model = new ACComboBoxModelAdapter();
      addProvideDay31Model();
    }
    return provideDay31Model;
  }

  /**
   * 31を取得します。
   * @return 31
   */
  public ACListItem getProvideDay31Item1(){
    if(provideDay31Item1==null){

      provideDay31Item1 = new ACListItem();

      provideDay31Item1.setText("31");

      provideDay31Item1.setSimpleValueMode(false);
      provideDay31Item1.put(getProvideDay31().getRenderBindPath(), "31");
      provideDay31Item1.put(getProvideDay31().getBindPath(), new Integer(0));

      addProvideDay31Item1();
    }
    return provideDay31Item1;

  }

  /**
   * 31○を取得します。
   * @return 31○
   */
  public ACListItem getProvideDay31Item2(){
    if(provideDay31Item2==null){

      provideDay31Item2 = new ACListItem();

      provideDay31Item2.setText("31○");

      provideDay31Item2.setSimpleValueMode(false);
      provideDay31Item2.put(getProvideDay31().getRenderBindPath(), "31○");
      provideDay31Item2.put(getProvideDay31().getBindPath(), new Integer(1));

      addProvideDay31Item2();
    }
    return provideDay31Item2;

  }

  /**
   * 31△を取得します。
   * @return 31△
   */
  public ACListItem getProvideDay31Item3(){
    if(provideDay31Item3==null){

      provideDay31Item3 = new ACListItem();

      provideDay31Item3.setText("31△");

      provideDay31Item3.setSimpleValueMode(false);
      provideDay31Item3.put(getProvideDay31().getRenderBindPath(), "31△");
      provideDay31Item3.put(getProvideDay31().getBindPath(), new Integer(2));

      addProvideDay31Item3();
    }
    return provideDay31Item3;

  }

  /**
   * 31◎を取得します。
   * @return 31◎
   */
  public ACListItem getProvideDay31Item4(){
    if(provideDay31Item4==null){

      provideDay31Item4 = new ACListItem();

      provideDay31Item4.setText("31◎");

      provideDay31Item4.setSimpleValueMode(false);
      provideDay31Item4.put(getProvideDay31().getRenderBindPath(), "31◎");
      provideDay31Item4.put(getProvideDay31().getBindPath(), new Integer(3));

      addProvideDay31Item4();
    }
    return provideDay31Item4;

  }

  /**
   * 31△◎を取得します。
   * @return 31△◎
   */
  public ACListItem getProvideDay31Item5(){
    if(provideDay31Item5==null){

      provideDay31Item5 = new ACListItem();

      provideDay31Item5.setText("31△◎");

      provideDay31Item5.setSimpleValueMode(false);
      provideDay31Item5.put(getProvideDay31().getRenderBindPath(), "31△◎");
      provideDay31Item5.put(getProvideDay31().getBindPath(), new Integer(4));

      addProvideDay31Item5();
    }
    return provideDay31Item5;

  }

  /**
   * 31◇を取得します。
   * @return 31◇
   */
  public ACListItem getProvideDay31Item6(){
    if(provideDay31Item6==null){

      provideDay31Item6 = new ACListItem();

      provideDay31Item6.setText("31◇");

      provideDay31Item6.setSimpleValueMode(false);
      provideDay31Item6.put(getProvideDay31().getRenderBindPath(), "31◇");
      provideDay31Item6.put(getProvideDay31().getBindPath(), new Integer(5));

      addProvideDay31Item6();
    }
    return provideDay31Item6;

  }

  /**
   * 31△◇を取得します。
   * @return 31△◇
   */
  public ACListItem getProvideDay31Item7(){
    if(provideDay31Item7==null){

      provideDay31Item7 = new ACListItem();

      provideDay31Item7.setText("31△◇");

      provideDay31Item7.setSimpleValueMode(false);
      provideDay31Item7.put(getProvideDay31().getRenderBindPath(), "31△◇");
      provideDay31Item7.put(getProvideDay31().getBindPath(), new Integer(6));

      addProvideDay31Item7();
    }
    return provideDay31Item7;

  }

  /**
   * 備考領域を取得します。
   * @return 備考領域
   */
  public ACGroupBox getNoteContents(){
    if(noteContents==null){

      noteContents = new ACGroupBox();

      noteContents.setText("備考");

      addNoteContents();
    }
    return noteContents;

  }

  /**
   * 備考を取得します。
   * @return 備考
   */
  public ACTextArea getNote(){
    if(note==null){

      note = new ACTextArea();

      note.setBindPath("BILL_NOTE");

      note.setColumns(50);

      note.setRows(5);

      note.setMaxRows(4);

      note.setIMEMode(InputSubset.KANJI);

      note.setMaxLength(100);

      note.setLineWrap(true);

      addNote();
    }
    return note;

  }

  /**
   * 合計領域を取得します。
   * @return 合計領域
   */
  public ACGroupBox getTotalContents(){
    if(totalContents==null){

      totalContents = new ACGroupBox();

      totalContents.setText("合計");

      addTotalContents();
    }
    return totalContents;

  }

  /**
   * 合計タイトル領域を取得します。
   * @return 合計タイトル領域
   */
  public ACPanel getTotalTitleContents(){
    if(totalTitleContents==null){

      totalTitleContents = new ACPanel();

      totalTitleContents.setAutoWrap(false);

      totalTitleContents.setHgap(0);

      totalTitleContents.setVgap(0);

      addTotalTitleContents();
    }
    return totalTitleContents;

  }

  /**
   * 合計余白を取得します。
   * @return 合計余白
   */
  public ACTextField getTotalSpace(){
    if(totalSpace==null){

      totalSpace = new ACTextField();

      totalSpace.setEditable(false);

      totalSpace.setColumns(7);

      addTotalSpace();
    }
    return totalSpace;

  }

  /**
   * 保険を取得します。
   * @return 保険
   */
  public ACTextField getTotalInsurerTitle(){
    if(totalInsurerTitle==null){

      totalInsurerTitle = new ACTextField();

      totalInsurerTitle.setText("保険");

      totalInsurerTitle.setEditable(false);

      totalInsurerTitle.setHorizontalAlignment(SwingConstants.CENTER);

      addTotalInsurerTitle();
    }
    return totalInsurerTitle;

  }

  /**
   * 保険外負担を取得します。
   * @return 保険外負担
   */
  public ACTextField getTotalUserTitle(){
    if(totalUserTitle==null){

      totalUserTitle = new ACTextField();

      totalUserTitle.setText("保険外負担");

      totalUserTitle.setEditable(false);

      totalUserTitle.setHorizontalAlignment(SwingConstants.CENTER);

      addTotalUserTitle();
    }
    return totalUserTitle;

  }

  /**
   * 明細合計領域を取得します。
   * @return 明細合計領域
   */
  public ACPanel getTotalNoTaxContents(){
    if(totalNoTaxContents==null){

      totalNoTaxContents = new ACPanel();

      totalNoTaxContents.setAutoWrap(false);

      totalNoTaxContents.setHgap(0);

      totalNoTaxContents.setVgap(0);

      addTotalNoTaxContents();
    }
    return totalNoTaxContents;

  }

  /**
   * 明細合計額を取得します。
   * @return 明細合計額
   */
  public ACTextField getTotalNoTaxTitle(){
    if(totalNoTaxTitle==null){

      totalNoTaxTitle = new ACTextField();

      totalNoTaxTitle.setText("明細合計額");

      totalNoTaxTitle.setEditable(false);

      totalNoTaxTitle.setColumns(7);

      addTotalNoTaxTitle();
    }
    return totalNoTaxTitle;

  }

  /**
   * 保険の明細合計額を取得します。
   * @return 保険の明細合計額
   */
  public ACTextField getTotalNoTaxByInsurer(){
    if(totalNoTaxByInsurer==null){

      totalNoTaxByInsurer = new ACTextField();

      totalNoTaxByInsurer.setBindPath("BILL_NO_TAX_BY_INSURER");

      totalNoTaxByInsurer.setEditable(false);

      totalNoTaxByInsurer.setFormat(NumberFormat.getIntegerInstance());

      totalNoTaxByInsurer.setHorizontalAlignment(SwingConstants.RIGHT);

      addTotalNoTaxByInsurer();
    }
    return totalNoTaxByInsurer;

  }

  /**
   * 保険外負担の明細合計額を取得します。
   * @return 保険外負担の明細合計額
   */
  public ACTextField getTotalNoTaxByPatient(){
    if(totalNoTaxByPatient==null){

      totalNoTaxByPatient = new ACTextField();

      totalNoTaxByPatient.setBindPath("BILL_NO_TAX_BY_PATIENT");

      totalNoTaxByPatient.setEditable(false);

      totalNoTaxByPatient.setFormat(NumberFormat.getIntegerInstance());

      totalNoTaxByPatient.setHorizontalAlignment(SwingConstants.RIGHT);

      addTotalNoTaxByPatient();
    }
    return totalNoTaxByPatient;

  }

  /**
   * 課税合計領域を取得します。
   * @return 課税合計領域
   */
  public ACPanel getTotalInTaxContents(){
    if(totalInTaxContents==null){

      totalInTaxContents = new ACPanel();

      totalInTaxContents.setAutoWrap(false);

      totalInTaxContents.setHgap(0);

      totalInTaxContents.setVgap(0);

      addTotalInTaxContents();
    }
    return totalInTaxContents;

  }

  /**
   * 課税対象額を取得します。
   * @return 課税対象額
   */
  public ACTextField getTotalInTaxTitle(){
    if(totalInTaxTitle==null){

      totalInTaxTitle = new ACTextField();

      totalInTaxTitle.setText("課税対象額");

      totalInTaxTitle.setEditable(false);

      totalInTaxTitle.setColumns(7);

      addTotalInTaxTitle();
    }
    return totalInTaxTitle;

  }

  /**
   * 保険の課税対象額を取得します。
   * @return 保険の課税対象額
   */
  public ACTextField getTotalInTaxByInsurer(){
    if(totalInTaxByInsurer==null){

      totalInTaxByInsurer = new ACTextField();

      totalInTaxByInsurer.setEditable(false);

      addTotalInTaxByInsurer();
    }
    return totalInTaxByInsurer;

  }

  /**
   * 保険外負担の課税対象額を取得します。
   * @return 保険外負担の課税対象額
   */
  public ACTextField getTotalInTaxByPatient(){
    if(totalInTaxByPatient==null){

      totalInTaxByPatient = new ACTextField();

      totalInTaxByPatient.setBindPath("BILL_IN_TAX_BY_PATIENT");

      totalInTaxByPatient.setEditable(false);

      totalInTaxByPatient.setFormat(NumberFormat.getIntegerInstance());

      totalInTaxByPatient.setHorizontalAlignment(SwingConstants.RIGHT);

      addTotalInTaxByPatient();
    }
    return totalInTaxByPatient;

  }

  /**
   * 領収額合計領域を取得します。
   * @return 領収額合計領域
   */
  public ACPanel getTotalFullContents(){
    if(totalFullContents==null){

      totalFullContents = new ACPanel();

      totalFullContents.setAutoWrap(false);

      totalFullContents.setHgap(0);

      totalFullContents.setVgap(0);

      addTotalFullContents();
    }
    return totalFullContents;

  }

  /**
   * 領収額合計を取得します。
   * @return 領収額合計
   */
  public ACTextField getTotalFullTitle(){
    if(totalFullTitle==null){

      totalFullTitle = new ACTextField();

      totalFullTitle.setText("領収額合計");

      totalFullTitle.setEditable(false);

      totalFullTitle.setColumns(7);

      addTotalFullTitle();
    }
    return totalFullTitle;

  }

  /**
   * 領収額合計額を取得します。
   * @return 領収額合計額
   */
  public ACTextField getTotalFull(){
    if(totalFull==null){

      totalFull = new ACTextField();

      totalFull.setBindPath("BILL_FULL_TOTAL");

      totalFull.setEditable(false);

      totalFull.setFormat(NumberFormat.getIntegerInstance());

      totalFull.setHorizontalAlignment(SwingConstants.RIGHT);

      addTotalFull();
    }
    return totalFull;

  }

  /**
   * コンストラクタです。
   */
  public QP012Design() {

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

    buttons.add(getPrint(), VRLayout.EAST);
    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getOpen(), VRLayout.EAST);
  }

  /**
   * 実績読み込みに内部項目を追加します。
   */
  protected void addOpen(){

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
   * 印刷に内部項目を追加します。
   */
  protected void addPrint(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getMainItemContents(), VRLayout.CLIENT);

    contents.add(getOptionContents(), VRLayout.EAST);
  }

  /**
   * 基本項目領域に内部項目を追加します。
   */
  protected void addMainItemContents(){

    mainItemContents.add(getBasicContents(), VRLayout.NORTH);

    mainItemContents.add(getItemContents(), VRLayout.NORTH);

  }

  /**
   * 基本情報領域に内部項目を追加します。
   */
  protected void addBasicContents(){

    basicContents.add(getBillNoContainer(), VRLayout.FLOW_INSETLINE);

    basicContents.add(getPatientCodeContainer(), VRLayout.FLOW_INSETLINE);

    basicContents.add(getPatientNameContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 領収書No.に内部項目を追加します。
   */
  protected void addBillNo(){

  }

  /**
   * 患者番号に内部項目を追加します。
   */
  protected void addPatientCode(){

  }

  /**
   * 氏名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * 項目領域に内部項目を追加します。
   */
  protected void addItemContents(){

    itemContents.add(getItemTabs(), VRLayout.NORTH);

  }

  /**
   * 項目タブに内部項目を追加します。
   */
  protected void addItemTabs(){

    itemTabs.addTab("保険適用負担", getByInsurerContents());

    itemTabs.addTab("保険外負担", getByPatientContents());

  }

  /**
   * 保険適用負担領域に内部項目を追加します。
   */
  protected void addByInsurerContents(){

    byInsurerContents.add(getByInsurerTitle(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer1(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer2(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer3(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer4(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer5(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer6(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer7(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer8(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer9(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer10(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer11(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer12(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer13(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer14(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer15(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer16(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer17(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer18(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer19(), VRLayout.NORTH);

    byInsurerContents.add(getByInsurer20(), VRLayout.NORTH);

  }

  /**
   * 保険負担分タイトルに内部項目を追加します。
   */
  protected void addByInsurerTitle(){

    byInsurerTitle.add(getByInsurerNameTitle(), VRLayout.CLIENT);

    byInsurerTitle.add(getByInsurerSumTitle(), VRLayout.EAST);
    byInsurerTitle.add(getByInsurerNumberTitle(), VRLayout.EAST);
    byInsurerTitle.add(getByInsurerPriceTitle(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目タイトルに内部項目を追加します。
   */
  protected void addByInsurerNameTitle(){

  }

  /**
   * 保険負担分単価タイトルに内部項目を追加します。
   */
  protected void addByInsurerPriceTitle(){

  }

  /**
   * 保険負担分数量タイトルに内部項目を追加します。
   */
  protected void addByInsurerNumberTitle(){

  }

  /**
   * 保険負担分金額タイトルに内部項目を追加します。
   */
  protected void addByInsurerSumTitle(){

  }

  /**
   * 保険負担分1行目に内部項目を追加します。
   */
  protected void addByInsurer1(){

    byInsurer1.add(getByInsurerName1(), VRLayout.CLIENT);

    byInsurer1.add(getByInsurerSum1(), VRLayout.EAST);
    byInsurer1.add(getByInsurerNumber1(), VRLayout.EAST);
    byInsurer1.add(getByInsurerPrice1(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目1行目に内部項目を追加します。
   */
  protected void addByInsurerName1(){

  }

  /**
   * 保険負担分項目1行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName1Model(){

  }

  /**
   * 保険負担分単価1行目に内部項目を追加します。
   */
  protected void addByInsurerPrice1(){

  }

  /**
   * 保険負担分数量1行目に内部項目を追加します。
   */
  protected void addByInsurerNumber1(){

  }

  /**
   * 保険負担分金額1行目に内部項目を追加します。
   */
  protected void addByInsurerSum1(){

  }

  /**
   * 保険負担分2行目に内部項目を追加します。
   */
  protected void addByInsurer2(){

    byInsurer2.add(getByInsurerName2(), VRLayout.CLIENT);

    byInsurer2.add(getByInsurerSum2(), VRLayout.EAST);
    byInsurer2.add(getByInsurerNumber2(), VRLayout.EAST);
    byInsurer2.add(getByInsurerPrice2(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目2行目に内部項目を追加します。
   */
  protected void addByInsurerName2(){

  }

  /**
   * 保険負担分項目2行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName2Model(){

  }

  /**
   * 保険負担分単価2行目に内部項目を追加します。
   */
  protected void addByInsurerPrice2(){

  }

  /**
   * 保険負担分数量2行目に内部項目を追加します。
   */
  protected void addByInsurerNumber2(){

  }

  /**
   * 保険負担分金額2行目に内部項目を追加します。
   */
  protected void addByInsurerSum2(){

  }

  /**
   * 保険負担分3行目に内部項目を追加します。
   */
  protected void addByInsurer3(){

    byInsurer3.add(getByInsurerName3(), VRLayout.CLIENT);

    byInsurer3.add(getByInsurerSum3(), VRLayout.EAST);
    byInsurer3.add(getByInsurerNumber3(), VRLayout.EAST);
    byInsurer3.add(getByInsurerPrice3(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目3行目に内部項目を追加します。
   */
  protected void addByInsurerName3(){

  }

  /**
   * 保険負担分項目3行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName3Model(){

  }

  /**
   * 保険負担分単価3行目に内部項目を追加します。
   */
  protected void addByInsurerPrice3(){

  }

  /**
   * 保険負担分数量3行目に内部項目を追加します。
   */
  protected void addByInsurerNumber3(){

  }

  /**
   * 保険負担分金額3行目に内部項目を追加します。
   */
  protected void addByInsurerSum3(){

  }

  /**
   * 保険負担分4行目に内部項目を追加します。
   */
  protected void addByInsurer4(){

    byInsurer4.add(getByInsurerName4(), VRLayout.CLIENT);

    byInsurer4.add(getByInsurerSum4(), VRLayout.EAST);
    byInsurer4.add(getByInsurerNumber4(), VRLayout.EAST);
    byInsurer4.add(getByInsurerPrice4(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目4行目に内部項目を追加します。
   */
  protected void addByInsurerName4(){

  }

  /**
   * 保険負担分項目4行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName4Model(){

  }

  /**
   * 保険負担分単価4行目に内部項目を追加します。
   */
  protected void addByInsurerPrice4(){

  }

  /**
   * 保険負担分数量4行目に内部項目を追加します。
   */
  protected void addByInsurerNumber4(){

  }

  /**
   * 保険負担分金額4行目に内部項目を追加します。
   */
  protected void addByInsurerSum4(){

  }

  /**
   * 保険負担分5行目に内部項目を追加します。
   */
  protected void addByInsurer5(){

    byInsurer5.add(getByInsurerName5(), VRLayout.CLIENT);

    byInsurer5.add(getByInsurerSum5(), VRLayout.EAST);
    byInsurer5.add(getByInsurerNumber5(), VRLayout.EAST);
    byInsurer5.add(getByInsurerPrice5(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目5行目に内部項目を追加します。
   */
  protected void addByInsurerName5(){

  }

  /**
   * 保険負担分項目5行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName5Model(){

  }

  /**
   * 保険負担分単価5行目に内部項目を追加します。
   */
  protected void addByInsurerPrice5(){

  }

  /**
   * 保険負担分数量5行目に内部項目を追加します。
   */
  protected void addByInsurerNumber5(){

  }

  /**
   * 保険負担分金額5行目に内部項目を追加します。
   */
  protected void addByInsurerSum5(){

  }

  /**
   * 保険負担分6行目に内部項目を追加します。
   */
  protected void addByInsurer6(){

    byInsurer6.add(getByInsurerName6(), VRLayout.CLIENT);

    byInsurer6.add(getByInsurerSum6(), VRLayout.EAST);
    byInsurer6.add(getByInsurerNumber6(), VRLayout.EAST);
    byInsurer6.add(getByInsurerPrice6(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目6行目に内部項目を追加します。
   */
  protected void addByInsurerName6(){

  }

  /**
   * 保険負担分項目6行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName6Model(){

  }

  /**
   * 保険負担分単価6行目に内部項目を追加します。
   */
  protected void addByInsurerPrice6(){

  }

  /**
   * 保険負担分数量6行目に内部項目を追加します。
   */
  protected void addByInsurerNumber6(){

  }

  /**
   * 保険負担分金額6行目に内部項目を追加します。
   */
  protected void addByInsurerSum6(){

  }

  /**
   * 保険負担分7行目に内部項目を追加します。
   */
  protected void addByInsurer7(){

    byInsurer7.add(getByInsurerName7(), VRLayout.CLIENT);

    byInsurer7.add(getByInsurerSum7(), VRLayout.EAST);
    byInsurer7.add(getByInsurerNumber7(), VRLayout.EAST);
    byInsurer7.add(getByInsurerPrice7(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目7行目に内部項目を追加します。
   */
  protected void addByInsurerName7(){

  }

  /**
   * 保険負担分項目7行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName7Model(){

  }

  /**
   * 保険負担分単価7行目に内部項目を追加します。
   */
  protected void addByInsurerPrice7(){

  }

  /**
   * 保険負担分数量7行目に内部項目を追加します。
   */
  protected void addByInsurerNumber7(){

  }

  /**
   * 保険負担分金額7行目に内部項目を追加します。
   */
  protected void addByInsurerSum7(){

  }

  /**
   * 保険負担分8行目に内部項目を追加します。
   */
  protected void addByInsurer8(){

    byInsurer8.add(getByInsurerName8(), VRLayout.CLIENT);

    byInsurer8.add(getByInsurerSum8(), VRLayout.EAST);
    byInsurer8.add(getByInsurerNumber8(), VRLayout.EAST);
    byInsurer8.add(getByInsurerPrice8(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目8行目に内部項目を追加します。
   */
  protected void addByInsurerName8(){

  }

  /**
   * 保険負担分項目8行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName8Model(){

  }

  /**
   * 保険負担分単価8行目に内部項目を追加します。
   */
  protected void addByInsurerPrice8(){

  }

  /**
   * 保険負担分数量8行目に内部項目を追加します。
   */
  protected void addByInsurerNumber8(){

  }

  /**
   * 保険負担分金額8行目に内部項目を追加します。
   */
  protected void addByInsurerSum8(){

  }

  /**
   * 保険負担分9行目に内部項目を追加します。
   */
  protected void addByInsurer9(){

    byInsurer9.add(getByInsurerName9(), VRLayout.CLIENT);

    byInsurer9.add(getByInsurerSum9(), VRLayout.EAST);
    byInsurer9.add(getByInsurerNumber9(), VRLayout.EAST);
    byInsurer9.add(getByInsurerPrice9(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目9行目に内部項目を追加します。
   */
  protected void addByInsurerName9(){

  }

  /**
   * 保険負担分項目9行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName9Model(){

  }

  /**
   * 保険負担分単価9行目に内部項目を追加します。
   */
  protected void addByInsurerPrice9(){

  }

  /**
   * 保険負担分数量9行目に内部項目を追加します。
   */
  protected void addByInsurerNumber9(){

  }

  /**
   * 保険負担分金額9行目に内部項目を追加します。
   */
  protected void addByInsurerSum9(){

  }

  /**
   * 保険負担分10行目に内部項目を追加します。
   */
  protected void addByInsurer10(){

    byInsurer10.add(getByInsurerName10(), VRLayout.CLIENT);

    byInsurer10.add(getByInsurerSum10(), VRLayout.EAST);
    byInsurer10.add(getByInsurerNumber10(), VRLayout.EAST);
    byInsurer10.add(getByInsurerPrice10(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目10行目に内部項目を追加します。
   */
  protected void addByInsurerName10(){

  }

  /**
   * 保険負担分項目10行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName10Model(){

  }

  /**
   * 保険負担分単価10行目に内部項目を追加します。
   */
  protected void addByInsurerPrice10(){

  }

  /**
   * 保険負担分数量10行目に内部項目を追加します。
   */
  protected void addByInsurerNumber10(){

  }

  /**
   * 保険負担分金額10行目に内部項目を追加します。
   */
  protected void addByInsurerSum10(){

  }

  /**
   * 保険負担分11行目に内部項目を追加します。
   */
  protected void addByInsurer11(){

    byInsurer11.add(getByInsurerName11(), VRLayout.CLIENT);

    byInsurer11.add(getByInsurerSum11(), VRLayout.EAST);
    byInsurer11.add(getByInsurerNumber11(), VRLayout.EAST);
    byInsurer11.add(getByInsurerPrice11(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目11行目に内部項目を追加します。
   */
  protected void addByInsurerName11(){

  }

  /**
   * 保険負担分項目11行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName11Model(){

  }

  /**
   * 保険負担分単価11行目に内部項目を追加します。
   */
  protected void addByInsurerPrice11(){

  }

  /**
   * 保険負担分数量11行目に内部項目を追加します。
   */
  protected void addByInsurerNumber11(){

  }

  /**
   * 保険負担分金額11行目に内部項目を追加します。
   */
  protected void addByInsurerSum11(){

  }

  /**
   * 保険負担分12行目に内部項目を追加します。
   */
  protected void addByInsurer12(){

    byInsurer12.add(getByInsurerName12(), VRLayout.CLIENT);

    byInsurer12.add(getByInsurerSum12(), VRLayout.EAST);
    byInsurer12.add(getByInsurerNumber12(), VRLayout.EAST);
    byInsurer12.add(getByInsurerPrice12(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目12行目に内部項目を追加します。
   */
  protected void addByInsurerName12(){

  }

  /**
   * 保険負担分項目12行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName12Model(){

  }

  /**
   * 保険負担分単価12行目に内部項目を追加します。
   */
  protected void addByInsurerPrice12(){

  }

  /**
   * 保険負担分数量12行目に内部項目を追加します。
   */
  protected void addByInsurerNumber12(){

  }

  /**
   * 保険負担分金額12行目に内部項目を追加します。
   */
  protected void addByInsurerSum12(){

  }

  /**
   * 保険負担分13行目に内部項目を追加します。
   */
  protected void addByInsurer13(){

    byInsurer13.add(getByInsurerName13(), VRLayout.CLIENT);

    byInsurer13.add(getByInsurerSum13(), VRLayout.EAST);
    byInsurer13.add(getByInsurerNumber13(), VRLayout.EAST);
    byInsurer13.add(getByInsurerPrice13(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目13行目に内部項目を追加します。
   */
  protected void addByInsurerName13(){

  }

  /**
   * 保険負担分項目13行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName13Model(){

  }

  /**
   * 保険負担分単価13行目に内部項目を追加します。
   */
  protected void addByInsurerPrice13(){

  }

  /**
   * 保険負担分数量13行目に内部項目を追加します。
   */
  protected void addByInsurerNumber13(){

  }

  /**
   * 保険負担分金額13行目に内部項目を追加します。
   */
  protected void addByInsurerSum13(){

  }

  /**
   * 保険負担分14行目に内部項目を追加します。
   */
  protected void addByInsurer14(){

    byInsurer14.add(getByInsurerName14(), VRLayout.CLIENT);

    byInsurer14.add(getByInsurerSum14(), VRLayout.EAST);
    byInsurer14.add(getByInsurerNumber14(), VRLayout.EAST);
    byInsurer14.add(getByInsurerPrice14(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目14行目に内部項目を追加します。
   */
  protected void addByInsurerName14(){

  }

  /**
   * 保険負担分項目14行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName14Model(){

  }

  /**
   * 保険負担分単価14行目に内部項目を追加します。
   */
  protected void addByInsurerPrice14(){

  }

  /**
   * 保険負担分数量14行目に内部項目を追加します。
   */
  protected void addByInsurerNumber14(){

  }

  /**
   * 保険負担分金額14行目に内部項目を追加します。
   */
  protected void addByInsurerSum14(){

  }

  /**
   * 保険負担分15行目に内部項目を追加します。
   */
  protected void addByInsurer15(){

    byInsurer15.add(getByInsurerName15(), VRLayout.CLIENT);

    byInsurer15.add(getByInsurerSum15(), VRLayout.EAST);
    byInsurer15.add(getByInsurerNumber15(), VRLayout.EAST);
    byInsurer15.add(getByInsurerPrice15(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目15行目に内部項目を追加します。
   */
  protected void addByInsurerName15(){

  }

  /**
   * 保険負担分項目15行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName15Model(){

  }

  /**
   * 保険負担分単価15行目に内部項目を追加します。
   */
  protected void addByInsurerPrice15(){

  }

  /**
   * 保険負担分数量15行目に内部項目を追加します。
   */
  protected void addByInsurerNumber15(){

  }

  /**
   * 保険負担分金額15行目に内部項目を追加します。
   */
  protected void addByInsurerSum15(){

  }

  /**
   * 保険負担分16行目に内部項目を追加します。
   */
  protected void addByInsurer16(){

    byInsurer16.add(getByInsurerName16(), VRLayout.CLIENT);

    byInsurer16.add(getByInsurerSum16(), VRLayout.EAST);
    byInsurer16.add(getByInsurerNumber16(), VRLayout.EAST);
    byInsurer16.add(getByInsurerPrice16(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目16行目に内部項目を追加します。
   */
  protected void addByInsurerName16(){

  }

  /**
   * 保険負担分項目16行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName16Model(){

  }

  /**
   * 保険負担分単価16行目に内部項目を追加します。
   */
  protected void addByInsurerPrice16(){

  }

  /**
   * 保険負担分数量16行目に内部項目を追加します。
   */
  protected void addByInsurerNumber16(){

  }

  /**
   * 保険負担分金額16行目に内部項目を追加します。
   */
  protected void addByInsurerSum16(){

  }

  /**
   * 保険負担分17行目に内部項目を追加します。
   */
  protected void addByInsurer17(){

    byInsurer17.add(getByInsurerName17(), VRLayout.CLIENT);

    byInsurer17.add(getByInsurerSum17(), VRLayout.EAST);
    byInsurer17.add(getByInsurerNumber17(), VRLayout.EAST);
    byInsurer17.add(getByInsurerPrice17(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目17行目に内部項目を追加します。
   */
  protected void addByInsurerName17(){

  }

  /**
   * 保険負担分項目17行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName17Model(){

  }

  /**
   * 保険負担分単価17行目に内部項目を追加します。
   */
  protected void addByInsurerPrice17(){

  }

  /**
   * 保険負担分数量17行目に内部項目を追加します。
   */
  protected void addByInsurerNumber17(){

  }

  /**
   * 保険負担分金額17行目に内部項目を追加します。
   */
  protected void addByInsurerSum17(){

  }

  /**
   * 保険負担分18行目に内部項目を追加します。
   */
  protected void addByInsurer18(){

    byInsurer18.add(getByInsurerName18(), VRLayout.CLIENT);

    byInsurer18.add(getByInsurerSum18(), VRLayout.EAST);
    byInsurer18.add(getByInsurerNumber18(), VRLayout.EAST);
    byInsurer18.add(getByInsurerPrice18(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目18行目に内部項目を追加します。
   */
  protected void addByInsurerName18(){

  }

  /**
   * 保険負担分項目18行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName18Model(){

  }

  /**
   * 保険負担分単価18行目に内部項目を追加します。
   */
  protected void addByInsurerPrice18(){

  }

  /**
   * 保険負担分数量18行目に内部項目を追加します。
   */
  protected void addByInsurerNumber18(){

  }

  /**
   * 保険負担分金額18行目に内部項目を追加します。
   */
  protected void addByInsurerSum18(){

  }

  /**
   * 保険負担分19行目に内部項目を追加します。
   */
  protected void addByInsurer19(){

    byInsurer19.add(getByInsurerName19(), VRLayout.CLIENT);

    byInsurer19.add(getByInsurerSum19(), VRLayout.EAST);
    byInsurer19.add(getByInsurerNumber19(), VRLayout.EAST);
    byInsurer19.add(getByInsurerPrice19(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目19行目に内部項目を追加します。
   */
  protected void addByInsurerName19(){

  }

  /**
   * 保険負担分項目19行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName19Model(){

  }

  /**
   * 保険負担分単価19行目に内部項目を追加します。
   */
  protected void addByInsurerPrice19(){

  }

  /**
   * 保険負担分数量19行目に内部項目を追加します。
   */
  protected void addByInsurerNumber19(){

  }

  /**
   * 保険負担分金額19行目に内部項目を追加します。
   */
  protected void addByInsurerSum19(){

  }

  /**
   * 保険負担分20行目に内部項目を追加します。
   */
  protected void addByInsurer20(){

    byInsurer20.add(getByInsurerName20(), VRLayout.CLIENT);

    byInsurer20.add(getByInsurerSum20(), VRLayout.EAST);
    byInsurer20.add(getByInsurerNumber20(), VRLayout.EAST);
    byInsurer20.add(getByInsurerPrice20(), VRLayout.EAST);
  }

  /**
   * 保険負担分項目20行目に内部項目を追加します。
   */
  protected void addByInsurerName20(){

  }

  /**
   * 保険負担分項目20行目モデルに内部項目を追加します。
   */
  protected void addByInsurerName20Model(){

  }

  /**
   * 保険負担分単価20行目に内部項目を追加します。
   */
  protected void addByInsurerPrice20(){

  }

  /**
   * 保険負担分数量20行目に内部項目を追加します。
   */
  protected void addByInsurerNumber20(){

  }

  /**
   * 保険負担分金額20行目に内部項目を追加します。
   */
  protected void addByInsurerSum20(){

  }

  /**
   * 保険外負担領域に内部項目を追加します。
   */
  protected void addByPatientContents(){

    byPatientContents.add(getByPatientTitle(), VRLayout.NORTH);

    byPatientContents.add(getByPatient1(), VRLayout.NORTH);

    byPatientContents.add(getByPatient2(), VRLayout.NORTH);

    byPatientContents.add(getByPatient3(), VRLayout.NORTH);

    byPatientContents.add(getByPatient4(), VRLayout.NORTH);

    byPatientContents.add(getByPatient5(), VRLayout.NORTH);

    byPatientContents.add(getByPatient6(), VRLayout.NORTH);

    byPatientContents.add(getByPatient7(), VRLayout.NORTH);

    byPatientContents.add(getByPatient8(), VRLayout.NORTH);

    byPatientContents.add(getByPatient9(), VRLayout.NORTH);

    byPatientContents.add(getByPatient10(), VRLayout.NORTH);

    byPatientContents.add(getByPatient11(), VRLayout.NORTH);

    byPatientContents.add(getByPatient12(), VRLayout.NORTH);

    byPatientContents.add(getByPatient13(), VRLayout.NORTH);

    byPatientContents.add(getByPatient14(), VRLayout.NORTH);

    byPatientContents.add(getByPatient15(), VRLayout.NORTH);

    byPatientContents.add(getByPatient16(), VRLayout.NORTH);

    byPatientContents.add(getByPatient17(), VRLayout.NORTH);

    byPatientContents.add(getByPatient18(), VRLayout.NORTH);

    byPatientContents.add(getByPatient19(), VRLayout.NORTH);

    byPatientContents.add(getByPatient20(), VRLayout.NORTH);

    byPatientContents.add(getUseTaxInfomation(), VRLayout.NORTH);

  }

  /**
   * 保険外負担分タイトルに内部項目を追加します。
   */
  protected void addByPatientTitle(){

    byPatientTitle.add(getByPatientNameTitle(), VRLayout.CLIENT);

    byPatientTitle.add(getByPatientTaxTitle(), VRLayout.EAST);
    byPatientTitle.add(getByPatientUseTaxTitle(), VRLayout.EAST);
    byPatientTitle.add(getByPatientTaxTargetTitle(), VRLayout.EAST);
    byPatientTitle.add(getByPatientSumTitle(), VRLayout.EAST);
    byPatientTitle.add(getByPatientNumberTitle(), VRLayout.EAST);
    byPatientTitle.add(getByPatientPriceTitle(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目タイトルに内部項目を追加します。
   */
  protected void addByPatientNameTitle(){

  }

  /**
   * 保険外負担分単価タイトルに内部項目を追加します。
   */
  protected void addByPatientPriceTitle(){

  }

  /**
   * 保険外負担分数量タイトルに内部項目を追加します。
   */
  protected void addByPatientNumberTitle(){

  }

  /**
   * 保険外負担分金額タイトルに内部項目を追加します。
   */
  protected void addByPatientSumTitle(){

  }

  /**
   * 保険外負担分課税タイトルに内部項目を追加します。
   */
  protected void addByPatientTaxTargetTitle(){

  }

  /**
   * 保険外負担分外税タイトルに内部項目を追加します。
   */
  protected void addByPatientUseTaxTitle(){

  }

  /**
   * 保険外負担分消費税等タイトルに内部項目を追加します。
   */
  protected void addByPatientTaxTitle(){

  }

  /**
   * 保険外負担分1行目に内部項目を追加します。
   */
  protected void addByPatient1(){

    byPatient1.add(getByPatientName1(), VRLayout.CLIENT);

    byPatient1.add(getByPatientTax1(), VRLayout.EAST);
    byPatient1.add(getByPatientUseTax1(), VRLayout.EAST);
    byPatient1.add(getByPatientTaxTarget1(), VRLayout.EAST);
    byPatient1.add(getByPatientSum1(), VRLayout.EAST);
    byPatient1.add(getByPatientNumber1(), VRLayout.EAST);
    byPatient1.add(getByPatientPrice1(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目1行目に内部項目を追加します。
   */
  protected void addByPatientName1(){

  }

  /**
   * 保険外負担分項目1行目モデルに内部項目を追加します。
   */
  protected void addByPatientName1Model(){

  }

  /**
   * 保険外負担分単価1行目に内部項目を追加します。
   */
  protected void addByPatientPrice1(){

  }

  /**
   * 保険外負担分数量1行目に内部項目を追加します。
   */
  protected void addByPatientNumber1(){

  }

  /**
   * 保険外負担分金額1行目に内部項目を追加します。
   */
  protected void addByPatientSum1(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget1(){

  }

  /**
   * 保険外負担分外税1行目に内部項目を追加します。
   */
  protected void addByPatientUseTax1(){

  }

  /**
   * 保険外負担分消費税等1行目に内部項目を追加します。
   */
  protected void addByPatientTax1(){

  }

  /**
   * 保険外負担分2行目に内部項目を追加します。
   */
  protected void addByPatient2(){

    byPatient2.add(getByPatientName2(), VRLayout.CLIENT);

    byPatient2.add(getByPatientTax2(), VRLayout.EAST);
    byPatient2.add(getByPatientUseTax2(), VRLayout.EAST);
    byPatient2.add(getByPatientTaxTarget2(), VRLayout.EAST);
    byPatient2.add(getByPatientSum2(), VRLayout.EAST);
    byPatient2.add(getByPatientNumber2(), VRLayout.EAST);
    byPatient2.add(getByPatientPrice2(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目2行目に内部項目を追加します。
   */
  protected void addByPatientName2(){

  }

  /**
   * 保険外負担分項目2行目モデルに内部項目を追加します。
   */
  protected void addByPatientName2Model(){

  }

  /**
   * 保険外負担分単価2行目に内部項目を追加します。
   */
  protected void addByPatientPrice2(){

  }

  /**
   * 保険外負担分数量2行目に内部項目を追加します。
   */
  protected void addByPatientNumber2(){

  }

  /**
   * 保険外負担分金額2行目に内部項目を追加します。
   */
  protected void addByPatientSum2(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget2(){

  }

  /**
   * 保険外負担分外税2行目に内部項目を追加します。
   */
  protected void addByPatientUseTax2(){

  }

  /**
   * 保険外負担分消費税等2行目に内部項目を追加します。
   */
  protected void addByPatientTax2(){

  }

  /**
   * 保険外負担分3行目に内部項目を追加します。
   */
  protected void addByPatient3(){

    byPatient3.add(getByPatientName3(), VRLayout.CLIENT);

    byPatient3.add(getByPatientTax3(), VRLayout.EAST);
    byPatient3.add(getByPatientUseTax3(), VRLayout.EAST);
    byPatient3.add(getByPatientTaxTarget3(), VRLayout.EAST);
    byPatient3.add(getByPatientSum3(), VRLayout.EAST);
    byPatient3.add(getByPatientNumber3(), VRLayout.EAST);
    byPatient3.add(getByPatientPrice3(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目3行目に内部項目を追加します。
   */
  protected void addByPatientName3(){

  }

  /**
   * 保険外負担分項目3行目モデルに内部項目を追加します。
   */
  protected void addByPatientName3Model(){

  }

  /**
   * 保険外負担分単価3行目に内部項目を追加します。
   */
  protected void addByPatientPrice3(){

  }

  /**
   * 保険外負担分数量3行目に内部項目を追加します。
   */
  protected void addByPatientNumber3(){

  }

  /**
   * 保険外負担分金額3行目に内部項目を追加します。
   */
  protected void addByPatientSum3(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget3(){

  }

  /**
   * 保険外負担分外税3行目に内部項目を追加します。
   */
  protected void addByPatientUseTax3(){

  }

  /**
   * 保険外負担分消費税等3行目に内部項目を追加します。
   */
  protected void addByPatientTax3(){

  }

  /**
   * 保険外負担分4行目に内部項目を追加します。
   */
  protected void addByPatient4(){

    byPatient4.add(getByPatientName4(), VRLayout.CLIENT);

    byPatient4.add(getByPatientTax4(), VRLayout.EAST);
    byPatient4.add(getByPatientUseTax4(), VRLayout.EAST);
    byPatient4.add(getByPatientTaxTarget4(), VRLayout.EAST);
    byPatient4.add(getByPatientSum4(), VRLayout.EAST);
    byPatient4.add(getByPatientNumber4(), VRLayout.EAST);
    byPatient4.add(getByPatientPrice4(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目4行目に内部項目を追加します。
   */
  protected void addByPatientName4(){

  }

  /**
   * 保険外負担分項目4行目モデルに内部項目を追加します。
   */
  protected void addByPatientName4Model(){

  }

  /**
   * 保険外負担分単価4行目に内部項目を追加します。
   */
  protected void addByPatientPrice4(){

  }

  /**
   * 保険外負担分数量4行目に内部項目を追加します。
   */
  protected void addByPatientNumber4(){

  }

  /**
   * 保険外負担分金額4行目に内部項目を追加します。
   */
  protected void addByPatientSum4(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget4(){

  }

  /**
   * 保険外負担分外税4行目に内部項目を追加します。
   */
  protected void addByPatientUseTax4(){

  }

  /**
   * 保険外負担分消費税等4行目に内部項目を追加します。
   */
  protected void addByPatientTax4(){

  }

  /**
   * 保険外負担分5行目に内部項目を追加します。
   */
  protected void addByPatient5(){

    byPatient5.add(getByPatientName5(), VRLayout.CLIENT);

    byPatient5.add(getByPatientTax5(), VRLayout.EAST);
    byPatient5.add(getByPatientUseTax5(), VRLayout.EAST);
    byPatient5.add(getByPatientTaxTarget5(), VRLayout.EAST);
    byPatient5.add(getByPatientSum5(), VRLayout.EAST);
    byPatient5.add(getByPatientNumber5(), VRLayout.EAST);
    byPatient5.add(getByPatientPrice5(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目5行目に内部項目を追加します。
   */
  protected void addByPatientName5(){

  }

  /**
   * 保険外負担分項目5行目モデルに内部項目を追加します。
   */
  protected void addByPatientName5Model(){

  }

  /**
   * 保険外負担分単価5行目に内部項目を追加します。
   */
  protected void addByPatientPrice5(){

  }

  /**
   * 保険外負担分数量5行目に内部項目を追加します。
   */
  protected void addByPatientNumber5(){

  }

  /**
   * 保険外負担分金額5行目に内部項目を追加します。
   */
  protected void addByPatientSum5(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget5(){

  }

  /**
   * 保険外負担分外税5行目に内部項目を追加します。
   */
  protected void addByPatientUseTax5(){

  }

  /**
   * 保険外負担分消費税等5行目に内部項目を追加します。
   */
  protected void addByPatientTax5(){

  }

  /**
   * 保険外負担分6行目に内部項目を追加します。
   */
  protected void addByPatient6(){

    byPatient6.add(getByPatientName6(), VRLayout.CLIENT);

    byPatient6.add(getByPatientTax6(), VRLayout.EAST);
    byPatient6.add(getByPatientUseTax6(), VRLayout.EAST);
    byPatient6.add(getByPatientTaxTarget6(), VRLayout.EAST);
    byPatient6.add(getByPatientSum6(), VRLayout.EAST);
    byPatient6.add(getByPatientNumber6(), VRLayout.EAST);
    byPatient6.add(getByPatientPrice6(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目6行目に内部項目を追加します。
   */
  protected void addByPatientName6(){

  }

  /**
   * 保険外負担分項目6行目モデルに内部項目を追加します。
   */
  protected void addByPatientName6Model(){

  }

  /**
   * 保険外負担分単価6行目に内部項目を追加します。
   */
  protected void addByPatientPrice6(){

  }

  /**
   * 保険外負担分数量6行目に内部項目を追加します。
   */
  protected void addByPatientNumber6(){

  }

  /**
   * 保険外負担分金額6行目に内部項目を追加します。
   */
  protected void addByPatientSum6(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget6(){

  }

  /**
   * 保険外負担分外税6行目に内部項目を追加します。
   */
  protected void addByPatientUseTax6(){

  }

  /**
   * 保険外負担分消費税等6行目に内部項目を追加します。
   */
  protected void addByPatientTax6(){

  }

  /**
   * 保険外負担分7行目に内部項目を追加します。
   */
  protected void addByPatient7(){

    byPatient7.add(getByPatientName7(), VRLayout.CLIENT);

    byPatient7.add(getByPatientTax7(), VRLayout.EAST);
    byPatient7.add(getByPatientUseTax7(), VRLayout.EAST);
    byPatient7.add(getByPatientTaxTarget7(), VRLayout.EAST);
    byPatient7.add(getByPatientSum7(), VRLayout.EAST);
    byPatient7.add(getByPatientNumber7(), VRLayout.EAST);
    byPatient7.add(getByPatientPrice7(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目7行目に内部項目を追加します。
   */
  protected void addByPatientName7(){

  }

  /**
   * 保険外負担分項目7行目モデルに内部項目を追加します。
   */
  protected void addByPatientName7Model(){

  }

  /**
   * 保険外負担分単価7行目に内部項目を追加します。
   */
  protected void addByPatientPrice7(){

  }

  /**
   * 保険外負担分数量7行目に内部項目を追加します。
   */
  protected void addByPatientNumber7(){

  }

  /**
   * 保険外負担分金額7行目に内部項目を追加します。
   */
  protected void addByPatientSum7(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget7(){

  }

  /**
   * 保険外負担分外税7行目に内部項目を追加します。
   */
  protected void addByPatientUseTax7(){

  }

  /**
   * 保険外負担分消費税等7行目に内部項目を追加します。
   */
  protected void addByPatientTax7(){

  }

  /**
   * 保険外負担分8行目に内部項目を追加します。
   */
  protected void addByPatient8(){

    byPatient8.add(getByPatientName8(), VRLayout.CLIENT);

    byPatient8.add(getByPatientTax8(), VRLayout.EAST);
    byPatient8.add(getByPatientUseTax8(), VRLayout.EAST);
    byPatient8.add(getByPatientTaxTarget8(), VRLayout.EAST);
    byPatient8.add(getByPatientSum8(), VRLayout.EAST);
    byPatient8.add(getByPatientNumber8(), VRLayout.EAST);
    byPatient8.add(getByPatientPrice8(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目8行目に内部項目を追加します。
   */
  protected void addByPatientName8(){

  }

  /**
   * 保険外負担分項目8行目モデルに内部項目を追加します。
   */
  protected void addByPatientName8Model(){

  }

  /**
   * 保険外負担分単価8行目に内部項目を追加します。
   */
  protected void addByPatientPrice8(){

  }

  /**
   * 保険外負担分数量8行目に内部項目を追加します。
   */
  protected void addByPatientNumber8(){

  }

  /**
   * 保険外負担分金額8行目に内部項目を追加します。
   */
  protected void addByPatientSum8(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget8(){

  }

  /**
   * 保険外負担分外税8行目に内部項目を追加します。
   */
  protected void addByPatientUseTax8(){

  }

  /**
   * 保険外負担分消費税等8行目に内部項目を追加します。
   */
  protected void addByPatientTax8(){

  }

  /**
   * 保険外負担分9行目に内部項目を追加します。
   */
  protected void addByPatient9(){

    byPatient9.add(getByPatientName9(), VRLayout.CLIENT);

    byPatient9.add(getByPatientTax9(), VRLayout.EAST);
    byPatient9.add(getByPatientUseTax9(), VRLayout.EAST);
    byPatient9.add(getByPatientTaxTarget9(), VRLayout.EAST);
    byPatient9.add(getByPatientSum9(), VRLayout.EAST);
    byPatient9.add(getByPatientNumber9(), VRLayout.EAST);
    byPatient9.add(getByPatientPrice9(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目9行目に内部項目を追加します。
   */
  protected void addByPatientName9(){

  }

  /**
   * 保険外負担分項目9行目モデルに内部項目を追加します。
   */
  protected void addByPatientName9Model(){

  }

  /**
   * 保険外負担分単価9行目に内部項目を追加します。
   */
  protected void addByPatientPrice9(){

  }

  /**
   * 保険外負担分数量9行目に内部項目を追加します。
   */
  protected void addByPatientNumber9(){

  }

  /**
   * 保険外負担分金額9行目に内部項目を追加します。
   */
  protected void addByPatientSum9(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget9(){

  }

  /**
   * 保険外負担分外税9行目に内部項目を追加します。
   */
  protected void addByPatientUseTax9(){

  }

  /**
   * 保険外負担分消費税等9行目に内部項目を追加します。
   */
  protected void addByPatientTax9(){

  }

  /**
   * 保険外負担分10行目に内部項目を追加します。
   */
  protected void addByPatient10(){

    byPatient10.add(getByPatientName10(), VRLayout.CLIENT);

    byPatient10.add(getByPatientTax10(), VRLayout.EAST);
    byPatient10.add(getByPatientUseTax10(), VRLayout.EAST);
    byPatient10.add(getByPatientTaxTarget10(), VRLayout.EAST);
    byPatient10.add(getByPatientSum10(), VRLayout.EAST);
    byPatient10.add(getByPatientNumber10(), VRLayout.EAST);
    byPatient10.add(getByPatientPrice10(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目10行目に内部項目を追加します。
   */
  protected void addByPatientName10(){

  }

  /**
   * 保険外負担分項目10行目モデルに内部項目を追加します。
   */
  protected void addByPatientName10Model(){

  }

  /**
   * 保険外負担分単価10行目に内部項目を追加します。
   */
  protected void addByPatientPrice10(){

  }

  /**
   * 保険外負担分数量10行目に内部項目を追加します。
   */
  protected void addByPatientNumber10(){

  }

  /**
   * 保険外負担分金額10行目に内部項目を追加します。
   */
  protected void addByPatientSum10(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget10(){

  }

  /**
   * 保険外負担分外税10行目に内部項目を追加します。
   */
  protected void addByPatientUseTax10(){

  }

  /**
   * 保険外負担分消費税等10行目に内部項目を追加します。
   */
  protected void addByPatientTax10(){

  }

  /**
   * 保険外負担分11行目に内部項目を追加します。
   */
  protected void addByPatient11(){

    byPatient11.add(getByPatientName11(), VRLayout.CLIENT);

    byPatient11.add(getByPatientTax11(), VRLayout.EAST);
    byPatient11.add(getByPatientUseTax11(), VRLayout.EAST);
    byPatient11.add(getByPatientTaxTarget11(), VRLayout.EAST);
    byPatient11.add(getByPatientSum11(), VRLayout.EAST);
    byPatient11.add(getByPatientNumber11(), VRLayout.EAST);
    byPatient11.add(getByPatientPrice11(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目11行目に内部項目を追加します。
   */
  protected void addByPatientName11(){

  }

  /**
   * 保険外負担分項目11行目モデルに内部項目を追加します。
   */
  protected void addByPatientName11Model(){

  }

  /**
   * 保険外負担分単価11行目に内部項目を追加します。
   */
  protected void addByPatientPrice11(){

  }

  /**
   * 保険外負担分数量11行目に内部項目を追加します。
   */
  protected void addByPatientNumber11(){

  }

  /**
   * 保険外負担分金額11行目に内部項目を追加します。
   */
  protected void addByPatientSum11(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget11(){

  }

  /**
   * 保険外負担分外税11行目に内部項目を追加します。
   */
  protected void addByPatientUseTax11(){

  }

  /**
   * 保険外負担分消費税等11行目に内部項目を追加します。
   */
  protected void addByPatientTax11(){

  }

  /**
   * 保険外負担分12行目に内部項目を追加します。
   */
  protected void addByPatient12(){

    byPatient12.add(getByPatientName12(), VRLayout.CLIENT);

    byPatient12.add(getByPatientTax12(), VRLayout.EAST);
    byPatient12.add(getByPatientUseTax12(), VRLayout.EAST);
    byPatient12.add(getByPatientTaxTarget12(), VRLayout.EAST);
    byPatient12.add(getByPatientSum12(), VRLayout.EAST);
    byPatient12.add(getByPatientNumber12(), VRLayout.EAST);
    byPatient12.add(getByPatientPrice12(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目12行目に内部項目を追加します。
   */
  protected void addByPatientName12(){

  }

  /**
   * 保険外負担分項目12行目モデルに内部項目を追加します。
   */
  protected void addByPatientName12Model(){

  }

  /**
   * 保険外負担分単価12行目に内部項目を追加します。
   */
  protected void addByPatientPrice12(){

  }

  /**
   * 保険外負担分数量12行目に内部項目を追加します。
   */
  protected void addByPatientNumber12(){

  }

  /**
   * 保険外負担分金額12行目に内部項目を追加します。
   */
  protected void addByPatientSum12(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget12(){

  }

  /**
   * 保険外負担分外税12行目に内部項目を追加します。
   */
  protected void addByPatientUseTax12(){

  }

  /**
   * 保険外負担分消費税等12行目に内部項目を追加します。
   */
  protected void addByPatientTax12(){

  }

  /**
   * 保険外負担分13行目に内部項目を追加します。
   */
  protected void addByPatient13(){

    byPatient13.add(getByPatientName13(), VRLayout.CLIENT);

    byPatient13.add(getByPatientTax13(), VRLayout.EAST);
    byPatient13.add(getByPatientUseTax13(), VRLayout.EAST);
    byPatient13.add(getByPatientTaxTarget13(), VRLayout.EAST);
    byPatient13.add(getByPatientSum13(), VRLayout.EAST);
    byPatient13.add(getByPatientNumber13(), VRLayout.EAST);
    byPatient13.add(getByPatientPrice13(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目13行目に内部項目を追加します。
   */
  protected void addByPatientName13(){

  }

  /**
   * 保険外負担分項目13行目モデルに内部項目を追加します。
   */
  protected void addByPatientName13Model(){

  }

  /**
   * 保険外負担分単価13行目に内部項目を追加します。
   */
  protected void addByPatientPrice13(){

  }

  /**
   * 保険外負担分数量13行目に内部項目を追加します。
   */
  protected void addByPatientNumber13(){

  }

  /**
   * 保険外負担分金額13行目に内部項目を追加します。
   */
  protected void addByPatientSum13(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget13(){

  }

  /**
   * 保険外負担分外税13行目に内部項目を追加します。
   */
  protected void addByPatientUseTax13(){

  }

  /**
   * 保険外負担分消費税等13行目に内部項目を追加します。
   */
  protected void addByPatientTax13(){

  }

  /**
   * 保険外負担分14行目に内部項目を追加します。
   */
  protected void addByPatient14(){

    byPatient14.add(getByPatientName14(), VRLayout.CLIENT);

    byPatient14.add(getByPatientTax14(), VRLayout.EAST);
    byPatient14.add(getByPatientUseTax14(), VRLayout.EAST);
    byPatient14.add(getByPatientTaxTarget14(), VRLayout.EAST);
    byPatient14.add(getByPatientSum14(), VRLayout.EAST);
    byPatient14.add(getByPatientNumber14(), VRLayout.EAST);
    byPatient14.add(getByPatientPrice14(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目14行目に内部項目を追加します。
   */
  protected void addByPatientName14(){

  }

  /**
   * 保険外負担分項目14行目モデルに内部項目を追加します。
   */
  protected void addByPatientName14Model(){

  }

  /**
   * 保険外負担分単価14行目に内部項目を追加します。
   */
  protected void addByPatientPrice14(){

  }

  /**
   * 保険外負担分数量14行目に内部項目を追加します。
   */
  protected void addByPatientNumber14(){

  }

  /**
   * 保険外負担分金額14行目に内部項目を追加します。
   */
  protected void addByPatientSum14(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget14(){

  }

  /**
   * 保険外負担分外税14行目に内部項目を追加します。
   */
  protected void addByPatientUseTax14(){

  }

  /**
   * 保険外負担分消費税等14行目に内部項目を追加します。
   */
  protected void addByPatientTax14(){

  }

  /**
   * 保険外負担分15行目に内部項目を追加します。
   */
  protected void addByPatient15(){

    byPatient15.add(getByPatientName15(), VRLayout.CLIENT);

    byPatient15.add(getByPatientTax15(), VRLayout.EAST);
    byPatient15.add(getByPatientUseTax15(), VRLayout.EAST);
    byPatient15.add(getByPatientTaxTarget15(), VRLayout.EAST);
    byPatient15.add(getByPatientSum15(), VRLayout.EAST);
    byPatient15.add(getByPatientNumber15(), VRLayout.EAST);
    byPatient15.add(getByPatientPrice15(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目15行目に内部項目を追加します。
   */
  protected void addByPatientName15(){

  }

  /**
   * 保険外負担分項目15行目モデルに内部項目を追加します。
   */
  protected void addByPatientName15Model(){

  }

  /**
   * 保険外負担分単価15行目に内部項目を追加します。
   */
  protected void addByPatientPrice15(){

  }

  /**
   * 保険外負担分数量15行目に内部項目を追加します。
   */
  protected void addByPatientNumber15(){

  }

  /**
   * 保険外負担分金額15行目に内部項目を追加します。
   */
  protected void addByPatientSum15(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget15(){

  }

  /**
   * 保険外負担分外税15行目に内部項目を追加します。
   */
  protected void addByPatientUseTax15(){

  }

  /**
   * 保険外負担分消費税等15行目に内部項目を追加します。
   */
  protected void addByPatientTax15(){

  }

  /**
   * 保険外負担分16行目に内部項目を追加します。
   */
  protected void addByPatient16(){

    byPatient16.add(getByPatientName16(), VRLayout.CLIENT);

    byPatient16.add(getByPatientTax16(), VRLayout.EAST);
    byPatient16.add(getByPatientUseTax16(), VRLayout.EAST);
    byPatient16.add(getByPatientTaxTarget16(), VRLayout.EAST);
    byPatient16.add(getByPatientSum16(), VRLayout.EAST);
    byPatient16.add(getByPatientNumber16(), VRLayout.EAST);
    byPatient16.add(getByPatientPrice16(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目16行目に内部項目を追加します。
   */
  protected void addByPatientName16(){

  }

  /**
   * 保険外負担分項目16行目モデルに内部項目を追加します。
   */
  protected void addByPatientName16Model(){

  }

  /**
   * 保険外負担分単価16行目に内部項目を追加します。
   */
  protected void addByPatientPrice16(){

  }

  /**
   * 保険外負担分数量16行目に内部項目を追加します。
   */
  protected void addByPatientNumber16(){

  }

  /**
   * 保険外負担分金額16行目に内部項目を追加します。
   */
  protected void addByPatientSum16(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget16(){

  }

  /**
   * 保険外負担分税16行目に内部項目を追加します。
   */
  protected void addByPatientUseTax16(){

  }

  /**
   * 保険外負担分消費税等16行目に内部項目を追加します。
   */
  protected void addByPatientTax16(){

  }

  /**
   * 保険外負担分17行目に内部項目を追加します。
   */
  protected void addByPatient17(){

    byPatient17.add(getByPatientName17(), VRLayout.CLIENT);

    byPatient17.add(getByPatientTax17(), VRLayout.EAST);
    byPatient17.add(getByPatientUseTax17(), VRLayout.EAST);
    byPatient17.add(getByPatientTaxTarget17(), VRLayout.EAST);
    byPatient17.add(getByPatientSum17(), VRLayout.EAST);
    byPatient17.add(getByPatientNumber17(), VRLayout.EAST);
    byPatient17.add(getByPatientPrice17(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目17行目に内部項目を追加します。
   */
  protected void addByPatientName17(){

  }

  /**
   * 保険外負担分項目17行目モデルに内部項目を追加します。
   */
  protected void addByPatientName17Model(){

  }

  /**
   * 保険外負担分単価17行目に内部項目を追加します。
   */
  protected void addByPatientPrice17(){

  }

  /**
   * 保険外負担分数量17行目に内部項目を追加します。
   */
  protected void addByPatientNumber17(){

  }

  /**
   * 保険外負担分金額17行目に内部項目を追加します。
   */
  protected void addByPatientSum17(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget17(){

  }

  /**
   * 保険外負担分外税17行目に内部項目を追加します。
   */
  protected void addByPatientUseTax17(){

  }

  /**
   * 保険外負担分消費税等17行目に内部項目を追加します。
   */
  protected void addByPatientTax17(){

  }

  /**
   * 保険外負担分18行目に内部項目を追加します。
   */
  protected void addByPatient18(){

    byPatient18.add(getByPatientName18(), VRLayout.CLIENT);

    byPatient18.add(getByPatientTax18(), VRLayout.EAST);
    byPatient18.add(getByPatientUseTax18(), VRLayout.EAST);
    byPatient18.add(getByPatientTaxTarget18(), VRLayout.EAST);
    byPatient18.add(getByPatientSum18(), VRLayout.EAST);
    byPatient18.add(getByPatientNumber18(), VRLayout.EAST);
    byPatient18.add(getByPatientPrice18(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目18行目に内部項目を追加します。
   */
  protected void addByPatientName18(){

  }

  /**
   * 保険外負担分項目18行目モデルに内部項目を追加します。
   */
  protected void addByPatientName18Model(){

  }

  /**
   * 保険外負担分単価18行目に内部項目を追加します。
   */
  protected void addByPatientPrice18(){

  }

  /**
   * 保険外負担分数量18行目に内部項目を追加します。
   */
  protected void addByPatientNumber18(){

  }

  /**
   * 保険外負担分金額18行目に内部項目を追加します。
   */
  protected void addByPatientSum18(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget18(){

  }

  /**
   * 保険外負担分外税18行目に内部項目を追加します。
   */
  protected void addByPatientUseTax18(){

  }

  /**
   * 保険外負担分消費税等18行目に内部項目を追加します。
   */
  protected void addByPatientTax18(){

  }

  /**
   * 保険外負担分19行目に内部項目を追加します。
   */
  protected void addByPatient19(){

    byPatient19.add(getByPatientName19(), VRLayout.CLIENT);

    byPatient19.add(getByPatientTax19(), VRLayout.EAST);
    byPatient19.add(getByPatientUseTax19(), VRLayout.EAST);
    byPatient19.add(getByPatientTaxTarget19(), VRLayout.EAST);
    byPatient19.add(getByPatientSum19(), VRLayout.EAST);
    byPatient19.add(getByPatientNumber19(), VRLayout.EAST);
    byPatient19.add(getByPatientPrice19(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目19行目に内部項目を追加します。
   */
  protected void addByPatientName19(){

  }

  /**
   * 保険外負担分項目19行目モデルに内部項目を追加します。
   */
  protected void addByPatientName19Model(){

  }

  /**
   * 保険外負担分単価19行目に内部項目を追加します。
   */
  protected void addByPatientPrice19(){

  }

  /**
   * 保険外負担分数量19行目に内部項目を追加します。
   */
  protected void addByPatientNumber19(){

  }

  /**
   * 保険外負担分金額19行目に内部項目を追加します。
   */
  protected void addByPatientSum19(){

  }

  /**
   * 保険外負担分課税1行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget19(){

  }

  /**
   * 保険外負担分外税19行目に内部項目を追加します。
   */
  protected void addByPatientUseTax19(){

  }

  /**
   * 保険外負担分消費税等19行目に内部項目を追加します。
   */
  protected void addByPatientTax19(){

  }

  /**
   * 保険外負担分20行目に内部項目を追加します。
   */
  protected void addByPatient20(){

    byPatient20.add(getByPatientName20(), VRLayout.CLIENT);

    byPatient20.add(getByPatientTax20(), VRLayout.EAST);
    byPatient20.add(getByPatientUseTax20(), VRLayout.EAST);
    byPatient20.add(getByPatientTaxTarget20(), VRLayout.EAST);
    byPatient20.add(getByPatientSum20(), VRLayout.EAST);
    byPatient20.add(getByPatientNumber20(), VRLayout.EAST);
    byPatient20.add(getByPatientPrice20(), VRLayout.EAST);
  }

  /**
   * 保険外負担分項目20行目に内部項目を追加します。
   */
  protected void addByPatientName20(){

  }

  /**
   * 保険外負担分項目20行目モデルに内部項目を追加します。
   */
  protected void addByPatientName20Model(){

  }

  /**
   * 保険外負担分単価20行目に内部項目を追加します。
   */
  protected void addByPatientPrice20(){

  }

  /**
   * 保険外負担分数量20行目に内部項目を追加します。
   */
  protected void addByPatientNumber20(){

  }

  /**
   * 保険外負担分金額20行目に内部項目を追加します。
   */
  protected void addByPatientSum20(){

  }

  /**
   * 保険外負担分課税20行目に内部項目を追加します。
   */
  protected void addByPatientTaxTarget20(){

  }

  /**
   * 保険外負担分外税20行目に内部項目を追加します。
   */
  protected void addByPatientUseTax20(){

  }

  /**
   * 保険外負担分消費税等20行目に内部項目を追加します。
   */
  protected void addByPatientTax20(){

  }

  /**
   * 税説明に内部項目を追加します。
   */
  protected void addUseTaxInfomation(){

  }

  /**
   * 補足領域に内部項目を追加します。
   */
  protected void addOptionContents(){

    optionContents.add(getInsurerContents(), VRLayout.NORTH);

    optionContents.add(getProvideContents(), VRLayout.NORTH);

    optionContents.add(getNoteContents(), VRLayout.NORTH);

    optionContents.add(getTotalContents(), VRLayout.NORTH);

  }

  /**
   * 請求保険情報領域に内部項目を追加します。
   */
  protected void addInsurerContents(){

    insurerContents.add(getBillSpanContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerContents.add(getPrintDateContainer(), VRLayout.FLOW_INSETLINE);

    insurerContents.add(getByPatientRateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerContents.add(getPatientFamilyTypeContainer(), VRLayout.FLOW_INSETLINE);

    insurerContents.add(getInsureTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerContents.add(getTaxContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 請求期間に内部項目を追加します。
   */
  protected void addBillSpanContainer(){

    billSpanContainer.add(getBillSpanStart(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpan(), VRLayout.FLOW);

    billSpanContainer.add(getBillSpanEnd(), VRLayout.FLOW);

  }

  /**
   * 開始年月日に内部項目を追加します。
   */
  protected void addBillSpanStart(){

  }

  /**
   * からに内部項目を追加します。
   */
  protected void addBillSpan(){

  }

  /**
   * 終了年月日に内部項目を追加します。
   */
  protected void addBillSpanEnd(){

  }

  /**
   * 発行日に内部項目を追加します。
   */
  protected void addPrintDate(){

  }

  /**
   * 負担割合コンテナに内部項目を追加します。
   */
  protected void addByPatientRateContainer(){

    byPatientRateContainer.add(getByPatientRate(), VRLayout.FLOW);

    byPatientRateContainer.add(getByPatientRateUnit(), VRLayout.FLOW);

  }

  /**
   * 負担割合に内部項目を追加します。
   */
  protected void addByPatientRate(){

  }

  /**
   * 負担割合単位に内部項目を追加します。
   */
  protected void addByPatientRateUnit(){

  }

  /**
   * 本・家に内部項目を追加します。
   */
  protected void addPatientFamilyType(){

  }

  /**
   * 区分に内部項目を追加します。
   */
  protected void addInsureType(){

  }

  /**
   * 税率コンテナに内部項目を追加します。
   */
  protected void addTaxContainer(){

    taxContainer.add(getTax(), VRLayout.FLOW);

    taxContainer.add(getTaxUnit(), VRLayout.FLOW);

    taxContainer.add(getTaxChange(), VRLayout.FLOW);

  }

  /**
   * 税率に内部項目を追加します。
   */
  protected void addTax(){

  }

  /**
   * 税率単位に内部項目を追加します。
   */
  protected void addTaxUnit(){

  }

  /**
   * 税率再設定に内部項目を追加します。
   */
  protected void addTaxChange(){

  }

  /**
   * 提供日に内部項目を追加します。
   */
  protected void addProvideContents(){

    provideContents.add(getProvideDay1(), VRLayout.FLOW);

    provideContents.add(getProvideDay2(), VRLayout.FLOW);

    provideContents.add(getProvideDay3(), VRLayout.FLOW);

    provideContents.add(getProvideDay4(), VRLayout.FLOW);

    provideContents.add(getProvideDay5(), VRLayout.FLOW);

    provideContents.add(getProvideDay6(), VRLayout.FLOW);

    provideContents.add(getProvideDay7(), VRLayout.FLOW_RETURN);

    provideContents.add(getProvideDay8(), VRLayout.FLOW);

    provideContents.add(getProvideDay9(), VRLayout.FLOW);

    provideContents.add(getProvideDay10(), VRLayout.FLOW);

    provideContents.add(getProvideDay11(), VRLayout.FLOW);

    provideContents.add(getProvideDay12(), VRLayout.FLOW);

    provideContents.add(getProvideDay13(), VRLayout.FLOW);

    provideContents.add(getProvideDay14(), VRLayout.FLOW_RETURN);

    provideContents.add(getProvideDay15(), VRLayout.FLOW);

    provideContents.add(getProvideDay16(), VRLayout.FLOW);

    provideContents.add(getProvideDay17(), VRLayout.FLOW);

    provideContents.add(getProvideDay18(), VRLayout.FLOW);

    provideContents.add(getProvideDay19(), VRLayout.FLOW);

    provideContents.add(getProvideDay20(), VRLayout.FLOW);

    provideContents.add(getProvideDay21(), VRLayout.FLOW_RETURN);

    provideContents.add(getProvideDay22(), VRLayout.FLOW);

    provideContents.add(getProvideDay23(), VRLayout.FLOW);

    provideContents.add(getProvideDay24(), VRLayout.FLOW);

    provideContents.add(getProvideDay25(), VRLayout.FLOW);

    provideContents.add(getProvideDay26(), VRLayout.FLOW);

    provideContents.add(getProvideDay27(), VRLayout.FLOW);

    provideContents.add(getProvideDay28(), VRLayout.FLOW_RETURN);

    provideContents.add(getProvideDay29(), VRLayout.FLOW);

    provideContents.add(getProvideDay30(), VRLayout.FLOW);

    provideContents.add(getProvideDay31(), VRLayout.FLOW);

  }

  /**
   * 提供日1に内部項目を追加します。
   */
  protected void addProvideDay1(){

  }

  /**
   * 提供日1モデルに内部項目を追加します。
   */
  protected void addProvideDay1Model(){

    getProvideDay1Model().add(getProvideDay1Item1());

    getProvideDay1Model().add(getProvideDay1Item2());

    getProvideDay1Model().add(getProvideDay1Item3());

    getProvideDay1Model().add(getProvideDay1Item4());

    getProvideDay1Model().add(getProvideDay1Item5());

    getProvideDay1Model().add(getProvideDay1Item6());

    getProvideDay1Model().add(getProvideDay1Item7());

  }

  /**
   * 1に内部項目を追加します。
   */
  protected void addProvideDay1Item1(){

  }

  /**
   * 1○に内部項目を追加します。
   */
  protected void addProvideDay1Item2(){

  }

  /**
   * 1△に内部項目を追加します。
   */
  protected void addProvideDay1Item3(){

  }

  /**
   * 1◎に内部項目を追加します。
   */
  protected void addProvideDay1Item4(){

  }

  /**
   * 1△◎に内部項目を追加します。
   */
  protected void addProvideDay1Item5(){

  }

  /**
   * 1◇に内部項目を追加します。
   */
  protected void addProvideDay1Item6(){

  }

  /**
   * 1△◇に内部項目を追加します。
   */
  protected void addProvideDay1Item7(){

  }

  /**
   * 提供日2に内部項目を追加します。
   */
  protected void addProvideDay2(){

  }

  /**
   * 提供日2モデルに内部項目を追加します。
   */
  protected void addProvideDay2Model(){

    getProvideDay2Model().add(getProvideDay2Item1());

    getProvideDay2Model().add(getProvideDay2Item2());

    getProvideDay2Model().add(getProvideDay2Item3());

    getProvideDay2Model().add(getProvideDay2Item4());

    getProvideDay2Model().add(getProvideDay2Item5());

    getProvideDay2Model().add(getProvideDay2Item6());

    getProvideDay2Model().add(getProvideDay2Item7());

  }

  /**
   * 2に内部項目を追加します。
   */
  protected void addProvideDay2Item1(){

  }

  /**
   * 2○に内部項目を追加します。
   */
  protected void addProvideDay2Item2(){

  }

  /**
   * 2△に内部項目を追加します。
   */
  protected void addProvideDay2Item3(){

  }

  /**
   * 2◎に内部項目を追加します。
   */
  protected void addProvideDay2Item4(){

  }

  /**
   * 2△◎に内部項目を追加します。
   */
  protected void addProvideDay2Item5(){

  }

  /**
   * 2◇に内部項目を追加します。
   */
  protected void addProvideDay2Item6(){

  }

  /**
   * 2△◇に内部項目を追加します。
   */
  protected void addProvideDay2Item7(){

  }

  /**
   * 提供日3に内部項目を追加します。
   */
  protected void addProvideDay3(){

  }

  /**
   * 提供日3モデルに内部項目を追加します。
   */
  protected void addProvideDay3Model(){

    getProvideDay3Model().add(getProvideDay3Item1());

    getProvideDay3Model().add(getProvideDay3Item2());

    getProvideDay3Model().add(getProvideDay3Item3());

    getProvideDay3Model().add(getProvideDay3Item4());

    getProvideDay3Model().add(getProvideDay3Item5());

    getProvideDay3Model().add(getProvideDay3Item6());

    getProvideDay3Model().add(getProvideDay3Item7());

  }

  /**
   * 3に内部項目を追加します。
   */
  protected void addProvideDay3Item1(){

  }

  /**
   * 3○に内部項目を追加します。
   */
  protected void addProvideDay3Item2(){

  }

  /**
   * 3△に内部項目を追加します。
   */
  protected void addProvideDay3Item3(){

  }

  /**
   * 3◎に内部項目を追加します。
   */
  protected void addProvideDay3Item4(){

  }

  /**
   * 3△◎に内部項目を追加します。
   */
  protected void addProvideDay3Item5(){

  }

  /**
   * 3◇に内部項目を追加します。
   */
  protected void addProvideDay3Item6(){

  }

  /**
   * 3△◇に内部項目を追加します。
   */
  protected void addProvideDay3Item7(){

  }

  /**
   * 提供日4に内部項目を追加します。
   */
  protected void addProvideDay4(){

  }

  /**
   * 提供日4モデルに内部項目を追加します。
   */
  protected void addProvideDay4Model(){

    getProvideDay4Model().add(getProvideDay4item1());

    getProvideDay4Model().add(getProvideDay4item2());

    getProvideDay4Model().add(getProvideDay4item3());

    getProvideDay4Model().add(getProvideDay4item4());

    getProvideDay4Model().add(getProvideDay4item5());

    getProvideDay4Model().add(getProvideDay4item6());

    getProvideDay4Model().add(getProvideDay4Item7());

  }

  /**
   * 4に内部項目を追加します。
   */
  protected void addProvideDay4item1(){

  }

  /**
   * 4○に内部項目を追加します。
   */
  protected void addProvideDay4item2(){

  }

  /**
   * 4△に内部項目を追加します。
   */
  protected void addProvideDay4item3(){

  }

  /**
   * 4◎に内部項目を追加します。
   */
  protected void addProvideDay4item4(){

  }

  /**
   * 4△◎に内部項目を追加します。
   */
  protected void addProvideDay4item5(){

  }

  /**
   * 4◇に内部項目を追加します。
   */
  protected void addProvideDay4item6(){

  }

  /**
   * 4△◇に内部項目を追加します。
   */
  protected void addProvideDay4Item7(){

  }

  /**
   * 提供日5に内部項目を追加します。
   */
  protected void addProvideDay5(){

  }

  /**
   * 提供日5モデルに内部項目を追加します。
   */
  protected void addProvideDay5Model(){

    getProvideDay5Model().add(getProvideDay5Item1());

    getProvideDay5Model().add(getProvideDay5Item2());

    getProvideDay5Model().add(getProvideDay5Item3());

    getProvideDay5Model().add(getProvideDay5Item4());

    getProvideDay5Model().add(getProvideDay5Item5());

    getProvideDay5Model().add(getProvideDay5Item6());

    getProvideDay5Model().add(getProvideDay5Item7());

  }

  /**
   * 5に内部項目を追加します。
   */
  protected void addProvideDay5Item1(){

  }

  /**
   * 5○に内部項目を追加します。
   */
  protected void addProvideDay5Item2(){

  }

  /**
   * 5△に内部項目を追加します。
   */
  protected void addProvideDay5Item3(){

  }

  /**
   * 5◎に内部項目を追加します。
   */
  protected void addProvideDay5Item4(){

  }

  /**
   * 5△◎に内部項目を追加します。
   */
  protected void addProvideDay5Item5(){

  }

  /**
   * 5◇に内部項目を追加します。
   */
  protected void addProvideDay5Item6(){

  }

  /**
   * 5△◇に内部項目を追加します。
   */
  protected void addProvideDay5Item7(){

  }

  /**
   * 提供日6に内部項目を追加します。
   */
  protected void addProvideDay6(){

  }

  /**
   * 提供日6モデルに内部項目を追加します。
   */
  protected void addProvideDay6Model(){

    getProvideDay6Model().add(getProvideDay6Item1());

    getProvideDay6Model().add(getProvideDay6Item2());

    getProvideDay6Model().add(getProvideDay6Item3());

    getProvideDay6Model().add(getProvideDay6Item4());

    getProvideDay6Model().add(getProvideDay6Item5());

    getProvideDay6Model().add(getProvideDay6Item6());

    getProvideDay6Model().add(getProvideDay6Item7());

  }

  /**
   * 6に内部項目を追加します。
   */
  protected void addProvideDay6Item1(){

  }

  /**
   * 6○に内部項目を追加します。
   */
  protected void addProvideDay6Item2(){

  }

  /**
   * 6△に内部項目を追加します。
   */
  protected void addProvideDay6Item3(){

  }

  /**
   * 6◎に内部項目を追加します。
   */
  protected void addProvideDay6Item4(){

  }

  /**
   * 6△◎に内部項目を追加します。
   */
  protected void addProvideDay6Item5(){

  }

  /**
   * 6◇に内部項目を追加します。
   */
  protected void addProvideDay6Item6(){

  }

  /**
   * 6△◇に内部項目を追加します。
   */
  protected void addProvideDay6Item7(){

  }

  /**
   * 提供日7に内部項目を追加します。
   */
  protected void addProvideDay7(){

  }

  /**
   * 提供日7モデルに内部項目を追加します。
   */
  protected void addProvideDay7Model(){

    getProvideDay7Model().add(getProvideDay7Item1());

    getProvideDay7Model().add(getProvideDay7Item2());

    getProvideDay7Model().add(getProvideDay7Item3());

    getProvideDay7Model().add(getProvideDay7Item4());

    getProvideDay7Model().add(getProvideDay7Item5());

    getProvideDay7Model().add(getProvideDay7Item6());

    getProvideDay7Model().add(getProvideDay7Item7());

  }

  /**
   * 7に内部項目を追加します。
   */
  protected void addProvideDay7Item1(){

  }

  /**
   * 7○に内部項目を追加します。
   */
  protected void addProvideDay7Item2(){

  }

  /**
   * 7△に内部項目を追加します。
   */
  protected void addProvideDay7Item3(){

  }

  /**
   * 7◎に内部項目を追加します。
   */
  protected void addProvideDay7Item4(){

  }

  /**
   * 7△◎に内部項目を追加します。
   */
  protected void addProvideDay7Item5(){

  }

  /**
   * 7◇に内部項目を追加します。
   */
  protected void addProvideDay7Item6(){

  }

  /**
   * 7△◇に内部項目を追加します。
   */
  protected void addProvideDay7Item7(){

  }

  /**
   * 提供日8に内部項目を追加します。
   */
  protected void addProvideDay8(){

  }

  /**
   * 提供日8モデルに内部項目を追加します。
   */
  protected void addProvideDay8Model(){

    getProvideDay8Model().add(getProvideDay8Item1());

    getProvideDay8Model().add(getProvideDay8Item2());

    getProvideDay8Model().add(getProvideDay8Item3());

    getProvideDay8Model().add(getProvideDay8Item4());

    getProvideDay8Model().add(getProvideDay8Item5());

    getProvideDay8Model().add(getProvideDay8Item6());

    getProvideDay8Model().add(getProvideDay8Item7());

  }

  /**
   * 8に内部項目を追加します。
   */
  protected void addProvideDay8Item1(){

  }

  /**
   * 8○に内部項目を追加します。
   */
  protected void addProvideDay8Item2(){

  }

  /**
   * 8△に内部項目を追加します。
   */
  protected void addProvideDay8Item3(){

  }

  /**
   * 8◎に内部項目を追加します。
   */
  protected void addProvideDay8Item4(){

  }

  /**
   * 8△◎に内部項目を追加します。
   */
  protected void addProvideDay8Item5(){

  }

  /**
   * 8◇に内部項目を追加します。
   */
  protected void addProvideDay8Item6(){

  }

  /**
   * 8△◇に内部項目を追加します。
   */
  protected void addProvideDay8Item7(){

  }

  /**
   * 提供日9に内部項目を追加します。
   */
  protected void addProvideDay9(){

  }

  /**
   * 提供日9モデルに内部項目を追加します。
   */
  protected void addProvideDay9Model(){

    getProvideDay9Model().add(getProvideDay9Item1());

    getProvideDay9Model().add(getProvideDay9Item2());

    getProvideDay9Model().add(getProvideDay9Item3());

    getProvideDay9Model().add(getProvideDay9Item4());

    getProvideDay9Model().add(getProvideDay9Item5());

    getProvideDay9Model().add(getProvideDay9Item6());

    getProvideDay9Model().add(getProvideDay9Item7());

  }

  /**
   * 9に内部項目を追加します。
   */
  protected void addProvideDay9Item1(){

  }

  /**
   * 9○に内部項目を追加します。
   */
  protected void addProvideDay9Item2(){

  }

  /**
   * 9△に内部項目を追加します。
   */
  protected void addProvideDay9Item3(){

  }

  /**
   * 9◎に内部項目を追加します。
   */
  protected void addProvideDay9Item4(){

  }

  /**
   * 9△◎に内部項目を追加します。
   */
  protected void addProvideDay9Item5(){

  }

  /**
   * 9◇に内部項目を追加します。
   */
  protected void addProvideDay9Item6(){

  }

  /**
   * 9△◇に内部項目を追加します。
   */
  protected void addProvideDay9Item7(){

  }

  /**
   * 提供日10に内部項目を追加します。
   */
  protected void addProvideDay10(){

  }

  /**
   * 提供日10モデルに内部項目を追加します。
   */
  protected void addProvideDay10Model(){

    getProvideDay10Model().add(getProvideDay10Item1());

    getProvideDay10Model().add(getProvideDay10Item2());

    getProvideDay10Model().add(getProvideDay10Item3());

    getProvideDay10Model().add(getProvideDay10Item4());

    getProvideDay10Model().add(getProvideDay10Item5());

    getProvideDay10Model().add(getProvideDay10Item6());

    getProvideDay10Model().add(getProvideDay10Item7());

  }

  /**
   * 10に内部項目を追加します。
   */
  protected void addProvideDay10Item1(){

  }

  /**
   * 10○に内部項目を追加します。
   */
  protected void addProvideDay10Item2(){

  }

  /**
   * 10△に内部項目を追加します。
   */
  protected void addProvideDay10Item3(){

  }

  /**
   * 10◎に内部項目を追加します。
   */
  protected void addProvideDay10Item4(){

  }

  /**
   * 10△◎に内部項目を追加します。
   */
  protected void addProvideDay10Item5(){

  }

  /**
   * 10◇に内部項目を追加します。
   */
  protected void addProvideDay10Item6(){

  }

  /**
   * 10△◇に内部項目を追加します。
   */
  protected void addProvideDay10Item7(){

  }

  /**
   * 提供日11に内部項目を追加します。
   */
  protected void addProvideDay11(){

  }

  /**
   * 提供日11モデルに内部項目を追加します。
   */
  protected void addProvideDay11Model(){

    getProvideDay11Model().add(getProvideDay11Item1());

    getProvideDay11Model().add(getProvideDay11Item2());

    getProvideDay11Model().add(getProvideDay11Item3());

    getProvideDay11Model().add(getProvideDay11Item4());

    getProvideDay11Model().add(getProvideDay11Item5());

    getProvideDay11Model().add(getProvideDay11Item6());

    getProvideDay11Model().add(getProvideDay11Item7());

  }

  /**
   * 11に内部項目を追加します。
   */
  protected void addProvideDay11Item1(){

  }

  /**
   * 11○に内部項目を追加します。
   */
  protected void addProvideDay11Item2(){

  }

  /**
   * 11△に内部項目を追加します。
   */
  protected void addProvideDay11Item3(){

  }

  /**
   * 11◎に内部項目を追加します。
   */
  protected void addProvideDay11Item4(){

  }

  /**
   * 11△◎に内部項目を追加します。
   */
  protected void addProvideDay11Item5(){

  }

  /**
   * 11◇に内部項目を追加します。
   */
  protected void addProvideDay11Item6(){

  }

  /**
   * 11△◇に内部項目を追加します。
   */
  protected void addProvideDay11Item7(){

  }

  /**
   * 提供日12に内部項目を追加します。
   */
  protected void addProvideDay12(){

  }

  /**
   * 提供日12モデルに内部項目を追加します。
   */
  protected void addProvideDay12Model(){

    getProvideDay12Model().add(getProvideDay12Item1());

    getProvideDay12Model().add(getProvideDay12Item2());

    getProvideDay12Model().add(getProvideDay12Item3());

    getProvideDay12Model().add(getProvideDay12Item4());

    getProvideDay12Model().add(getProvideDay12Item5());

    getProvideDay12Model().add(getProvideDay12Item6());

    getProvideDay12Model().add(getProvideDay12Item7());

  }

  /**
   * 12に内部項目を追加します。
   */
  protected void addProvideDay12Item1(){

  }

  /**
   * 12○に内部項目を追加します。
   */
  protected void addProvideDay12Item2(){

  }

  /**
   * 12△に内部項目を追加します。
   */
  protected void addProvideDay12Item3(){

  }

  /**
   * 12◎に内部項目を追加します。
   */
  protected void addProvideDay12Item4(){

  }

  /**
   * 12△◎に内部項目を追加します。
   */
  protected void addProvideDay12Item5(){

  }

  /**
   * 12◇に内部項目を追加します。
   */
  protected void addProvideDay12Item6(){

  }

  /**
   * 12△◇に内部項目を追加します。
   */
  protected void addProvideDay12Item7(){

  }

  /**
   * 提供日13に内部項目を追加します。
   */
  protected void addProvideDay13(){

  }

  /**
   * 提供日13モデルに内部項目を追加します。
   */
  protected void addProvideDay13Model(){

    getProvideDay13Model().add(getProvideDay13Item1());

    getProvideDay13Model().add(getProvideDay13Item2());

    getProvideDay13Model().add(getProvideDay13Item3());

    getProvideDay13Model().add(getProvideDay13Item4());

    getProvideDay13Model().add(getProvideDay13Item5());

    getProvideDay13Model().add(getProvideDay13Item6());

    getProvideDay13Model().add(getProvideDay13Item7());

  }

  /**
   * 13に内部項目を追加します。
   */
  protected void addProvideDay13Item1(){

  }

  /**
   * 13○に内部項目を追加します。
   */
  protected void addProvideDay13Item2(){

  }

  /**
   * 13△に内部項目を追加します。
   */
  protected void addProvideDay13Item3(){

  }

  /**
   * 13◎に内部項目を追加します。
   */
  protected void addProvideDay13Item4(){

  }

  /**
   * 13△◎に内部項目を追加します。
   */
  protected void addProvideDay13Item5(){

  }

  /**
   * 13◇に内部項目を追加します。
   */
  protected void addProvideDay13Item6(){

  }

  /**
   * 13△◇に内部項目を追加します。
   */
  protected void addProvideDay13Item7(){

  }

  /**
   * 提供日14に内部項目を追加します。
   */
  protected void addProvideDay14(){

  }

  /**
   * 提供日14モデルに内部項目を追加します。
   */
  protected void addProvideDay14Model(){

    getProvideDay14Model().add(getProvideDay14Item1());

    getProvideDay14Model().add(getProvideDay14Item2());

    getProvideDay14Model().add(getProvideDay14Item3());

    getProvideDay14Model().add(getProvideDay14Item4());

    getProvideDay14Model().add(getProvideDay14Item5());

    getProvideDay14Model().add(getProvideDay14Item6());

    getProvideDay14Model().add(getProvideDay14Item7());

  }

  /**
   * 14に内部項目を追加します。
   */
  protected void addProvideDay14Item1(){

  }

  /**
   * 14○に内部項目を追加します。
   */
  protected void addProvideDay14Item2(){

  }

  /**
   * 14△に内部項目を追加します。
   */
  protected void addProvideDay14Item3(){

  }

  /**
   * 14◎に内部項目を追加します。
   */
  protected void addProvideDay14Item4(){

  }

  /**
   * 14△◎に内部項目を追加します。
   */
  protected void addProvideDay14Item5(){

  }

  /**
   * 14◇に内部項目を追加します。
   */
  protected void addProvideDay14Item6(){

  }

  /**
   * 14△◇に内部項目を追加します。
   */
  protected void addProvideDay14Item7(){

  }

  /**
   * 提供日15に内部項目を追加します。
   */
  protected void addProvideDay15(){

  }

  /**
   * 提供日15モデルに内部項目を追加します。
   */
  protected void addProvideDay15Model(){

    getProvideDay15Model().add(getProvideDay15Item1());

    getProvideDay15Model().add(getProvideDay15Item2());

    getProvideDay15Model().add(getProvideDay15Item3());

    getProvideDay15Model().add(getProvideDay15Item4());

    getProvideDay15Model().add(getProvideDay15Item5());

    getProvideDay15Model().add(getProvideDay15Item6());

    getProvideDay15Model().add(getProvideDay15Item7());

  }

  /**
   * 15に内部項目を追加します。
   */
  protected void addProvideDay15Item1(){

  }

  /**
   * 15○に内部項目を追加します。
   */
  protected void addProvideDay15Item2(){

  }

  /**
   * 15△に内部項目を追加します。
   */
  protected void addProvideDay15Item3(){

  }

  /**
   * 15◎に内部項目を追加します。
   */
  protected void addProvideDay15Item4(){

  }

  /**
   * 15△◎に内部項目を追加します。
   */
  protected void addProvideDay15Item5(){

  }

  /**
   * 15◇に内部項目を追加します。
   */
  protected void addProvideDay15Item6(){

  }

  /**
   * 15△◇に内部項目を追加します。
   */
  protected void addProvideDay15Item7(){

  }

  /**
   * 提供日16に内部項目を追加します。
   */
  protected void addProvideDay16(){

  }

  /**
   * 提供日16モデルに内部項目を追加します。
   */
  protected void addProvideDay16Model(){

    getProvideDay16Model().add(getProvideDay16Item1());

    getProvideDay16Model().add(getProvideDay16Item2());

    getProvideDay16Model().add(getProvideDay16Item3());

    getProvideDay16Model().add(getProvideDay16Item4());

    getProvideDay16Model().add(getProvideDay16Item5());

    getProvideDay16Model().add(getProvideDay16Item6());

    getProvideDay16Model().add(getProvideDay16Item7());

  }

  /**
   * 16に内部項目を追加します。
   */
  protected void addProvideDay16Item1(){

  }

  /**
   * 16○に内部項目を追加します。
   */
  protected void addProvideDay16Item2(){

  }

  /**
   * 16△に内部項目を追加します。
   */
  protected void addProvideDay16Item3(){

  }

  /**
   * 16◎に内部項目を追加します。
   */
  protected void addProvideDay16Item4(){

  }

  /**
   * 16△◎に内部項目を追加します。
   */
  protected void addProvideDay16Item5(){

  }

  /**
   * 16◇に内部項目を追加します。
   */
  protected void addProvideDay16Item6(){

  }

  /**
   * 16△◇に内部項目を追加します。
   */
  protected void addProvideDay16Item7(){

  }

  /**
   * 提供日17に内部項目を追加します。
   */
  protected void addProvideDay17(){

  }

  /**
   * 提供日17モデルに内部項目を追加します。
   */
  protected void addProvideDay17Model(){

    getProvideDay17Model().add(getProvideDay17Item1());

    getProvideDay17Model().add(getProvideDay17Item2());

    getProvideDay17Model().add(getProvideDay17Item3());

    getProvideDay17Model().add(getProvideDay17Item4());

    getProvideDay17Model().add(getProvideDay17Item5());

    getProvideDay17Model().add(getProvideDay17Item6());

    getProvideDay17Model().add(getProvideDay17Item7());

  }

  /**
   * 17に内部項目を追加します。
   */
  protected void addProvideDay17Item1(){

  }

  /**
   * 17○に内部項目を追加します。
   */
  protected void addProvideDay17Item2(){

  }

  /**
   * 17△に内部項目を追加します。
   */
  protected void addProvideDay17Item3(){

  }

  /**
   * 17◎に内部項目を追加します。
   */
  protected void addProvideDay17Item4(){

  }

  /**
   * 17△◎に内部項目を追加します。
   */
  protected void addProvideDay17Item5(){

  }

  /**
   * 17◇に内部項目を追加します。
   */
  protected void addProvideDay17Item6(){

  }

  /**
   * 17△◇に内部項目を追加します。
   */
  protected void addProvideDay17Item7(){

  }

  /**
   * 提供日18に内部項目を追加します。
   */
  protected void addProvideDay18(){

  }

  /**
   * 提供日18モデルに内部項目を追加します。
   */
  protected void addProvideDay18Model(){

    getProvideDay18Model().add(getProvideDay18Item1());

    getProvideDay18Model().add(getProvideDay18Item2());

    getProvideDay18Model().add(getProvideDay18Item3());

    getProvideDay18Model().add(getProvideDay18Item4());

    getProvideDay18Model().add(getProvideDay18Item5());

    getProvideDay18Model().add(getProvideDay18Item6());

    getProvideDay18Model().add(getProvideDay18Item7());

  }

  /**
   * 18に内部項目を追加します。
   */
  protected void addProvideDay18Item1(){

  }

  /**
   * 18○に内部項目を追加します。
   */
  protected void addProvideDay18Item2(){

  }

  /**
   * 18△に内部項目を追加します。
   */
  protected void addProvideDay18Item3(){

  }

  /**
   * 18◎に内部項目を追加します。
   */
  protected void addProvideDay18Item4(){

  }

  /**
   * 18△◎に内部項目を追加します。
   */
  protected void addProvideDay18Item5(){

  }

  /**
   * 18◇に内部項目を追加します。
   */
  protected void addProvideDay18Item6(){

  }

  /**
   * 18△◇に内部項目を追加します。
   */
  protected void addProvideDay18Item7(){

  }

  /**
   * 提供日19に内部項目を追加します。
   */
  protected void addProvideDay19(){

  }

  /**
   * 提供日19モデルに内部項目を追加します。
   */
  protected void addProvideDay19Model(){

    getProvideDay19Model().add(getProvideDay19Item1());

    getProvideDay19Model().add(getProvideDay19Item2());

    getProvideDay19Model().add(getProvideDay19Item3());

    getProvideDay19Model().add(getProvideDay19Item4());

    getProvideDay19Model().add(getProvideDay19Item5());

    getProvideDay19Model().add(getProvideDay19Item6());

    getProvideDay19Model().add(getProvideDay19Item7());

  }

  /**
   * 19に内部項目を追加します。
   */
  protected void addProvideDay19Item1(){

  }

  /**
   * 19○に内部項目を追加します。
   */
  protected void addProvideDay19Item2(){

  }

  /**
   * 19△に内部項目を追加します。
   */
  protected void addProvideDay19Item3(){

  }

  /**
   * 19◎に内部項目を追加します。
   */
  protected void addProvideDay19Item4(){

  }

  /**
   * 19△◎に内部項目を追加します。
   */
  protected void addProvideDay19Item5(){

  }

  /**
   * 19◇に内部項目を追加します。
   */
  protected void addProvideDay19Item6(){

  }

  /**
   * 19△◇に内部項目を追加します。
   */
  protected void addProvideDay19Item7(){

  }

  /**
   * 提供日20に内部項目を追加します。
   */
  protected void addProvideDay20(){

  }

  /**
   * 提供日20モデルに内部項目を追加します。
   */
  protected void addProvideDay20Model(){

    getProvideDay20Model().add(getProvideDay20Item1());

    getProvideDay20Model().add(getProvideDay20Item2());

    getProvideDay20Model().add(getProvideDay20Item3());

    getProvideDay20Model().add(getProvideDay20Item4());

    getProvideDay20Model().add(getProvideDay20Item5());

    getProvideDay20Model().add(getProvideDay20Item6());

    getProvideDay20Model().add(getProvideDay20Item7());

  }

  /**
   * 20に内部項目を追加します。
   */
  protected void addProvideDay20Item1(){

  }

  /**
   * 20○に内部項目を追加します。
   */
  protected void addProvideDay20Item2(){

  }

  /**
   * 20△に内部項目を追加します。
   */
  protected void addProvideDay20Item3(){

  }

  /**
   * 20◎に内部項目を追加します。
   */
  protected void addProvideDay20Item4(){

  }

  /**
   * 20△◎に内部項目を追加します。
   */
  protected void addProvideDay20Item5(){

  }

  /**
   * 20◇に内部項目を追加します。
   */
  protected void addProvideDay20Item6(){

  }

  /**
   * 20△◇に内部項目を追加します。
   */
  protected void addProvideDay20Item7(){

  }

  /**
   * 提供日21に内部項目を追加します。
   */
  protected void addProvideDay21(){

  }

  /**
   * 提供日21モデルに内部項目を追加します。
   */
  protected void addProvideDay21Model(){

    getProvideDay21Model().add(getProvideDay21Item1());

    getProvideDay21Model().add(getProvideDay21Item2());

    getProvideDay21Model().add(getProvideDay21Item3());

    getProvideDay21Model().add(getProvideDay21Item4());

    getProvideDay21Model().add(getProvideDay21Item5());

    getProvideDay21Model().add(getProvideDay21Item6());

    getProvideDay21Model().add(getProvideDay21Item7());

  }

  /**
   * 21に内部項目を追加します。
   */
  protected void addProvideDay21Item1(){

  }

  /**
   * 21○に内部項目を追加します。
   */
  protected void addProvideDay21Item2(){

  }

  /**
   * 21△に内部項目を追加します。
   */
  protected void addProvideDay21Item3(){

  }

  /**
   * 21◎に内部項目を追加します。
   */
  protected void addProvideDay21Item4(){

  }

  /**
   * 21△◎に内部項目を追加します。
   */
  protected void addProvideDay21Item5(){

  }

  /**
   * 21◇に内部項目を追加します。
   */
  protected void addProvideDay21Item6(){

  }

  /**
   * 21△◇に内部項目を追加します。
   */
  protected void addProvideDay21Item7(){

  }

  /**
   * 提供日22に内部項目を追加します。
   */
  protected void addProvideDay22(){

  }

  /**
   * 提供日22モデルに内部項目を追加します。
   */
  protected void addProvideDay22Model(){

    getProvideDay22Model().add(getProvideDay22Item1());

    getProvideDay22Model().add(getProvideDay22Item2());

    getProvideDay22Model().add(getProvideDay22Item3());

    getProvideDay22Model().add(getProvideDay22Item4());

    getProvideDay22Model().add(getProvideDay22Item5());

    getProvideDay22Model().add(getProvideDay22Item6());

    getProvideDay22Model().add(getProvideDay22Item7());

  }

  /**
   * 22に内部項目を追加します。
   */
  protected void addProvideDay22Item1(){

  }

  /**
   * 22○に内部項目を追加します。
   */
  protected void addProvideDay22Item2(){

  }

  /**
   * 22△に内部項目を追加します。
   */
  protected void addProvideDay22Item3(){

  }

  /**
   * 22◎に内部項目を追加します。
   */
  protected void addProvideDay22Item4(){

  }

  /**
   * 22△◎に内部項目を追加します。
   */
  protected void addProvideDay22Item5(){

  }

  /**
   * 22◇に内部項目を追加します。
   */
  protected void addProvideDay22Item6(){

  }

  /**
   * 22△◇に内部項目を追加します。
   */
  protected void addProvideDay22Item7(){

  }

  /**
   * 提供日23に内部項目を追加します。
   */
  protected void addProvideDay23(){

  }

  /**
   * 提供日23モデルに内部項目を追加します。
   */
  protected void addProvideDay23Model(){

    getProvideDay23Model().add(getProvideDay23Item1());

    getProvideDay23Model().add(getProvideDay23Item2());

    getProvideDay23Model().add(getProvideDay23Item3());

    getProvideDay23Model().add(getProvideDay23Item4());

    getProvideDay23Model().add(getProvideDay23Item5());

    getProvideDay23Model().add(getProvideDay23Item6());

    getProvideDay23Model().add(getProvideDay23Item7());

  }

  /**
   * 23に内部項目を追加します。
   */
  protected void addProvideDay23Item1(){

  }

  /**
   * 23○に内部項目を追加します。
   */
  protected void addProvideDay23Item2(){

  }

  /**
   * 23△に内部項目を追加します。
   */
  protected void addProvideDay23Item3(){

  }

  /**
   * 23◎に内部項目を追加します。
   */
  protected void addProvideDay23Item4(){

  }

  /**
   * 23△◎に内部項目を追加します。
   */
  protected void addProvideDay23Item5(){

  }

  /**
   * 23◇に内部項目を追加します。
   */
  protected void addProvideDay23Item6(){

  }

  /**
   * 23△◇に内部項目を追加します。
   */
  protected void addProvideDay23Item7(){

  }

  /**
   * 提供日24に内部項目を追加します。
   */
  protected void addProvideDay24(){

  }

  /**
   * 提供日24モデルに内部項目を追加します。
   */
  protected void addProvideDay24Model(){

    getProvideDay24Model().add(getProvideDay24Item1());

    getProvideDay24Model().add(getProvideDay24Item2());

    getProvideDay24Model().add(getProvideDay24Item3());

    getProvideDay24Model().add(getProvideDay24Item4());

    getProvideDay24Model().add(getProvideDay24Item5());

    getProvideDay24Model().add(getProvideDay24Item6());

    getProvideDay24Model().add(getProvideDay24Item7());

  }

  /**
   * 24に内部項目を追加します。
   */
  protected void addProvideDay24Item1(){

  }

  /**
   * 24○に内部項目を追加します。
   */
  protected void addProvideDay24Item2(){

  }

  /**
   * 24△に内部項目を追加します。
   */
  protected void addProvideDay24Item3(){

  }

  /**
   * 24◎に内部項目を追加します。
   */
  protected void addProvideDay24Item4(){

  }

  /**
   * 24△◎に内部項目を追加します。
   */
  protected void addProvideDay24Item5(){

  }

  /**
   * 24◇に内部項目を追加します。
   */
  protected void addProvideDay24Item6(){

  }

  /**
   * 24△◇に内部項目を追加します。
   */
  protected void addProvideDay24Item7(){

  }

  /**
   * 提供日25に内部項目を追加します。
   */
  protected void addProvideDay25(){

  }

  /**
   * 提供日25モデルに内部項目を追加します。
   */
  protected void addProvideDay25Model(){

    getProvideDay25Model().add(getProvideDay25Item1());

    getProvideDay25Model().add(getProvideDay25Item2());

    getProvideDay25Model().add(getProvideDay25Item3());

    getProvideDay25Model().add(getProvideDay25Item4());

    getProvideDay25Model().add(getProvideDay25Item5());

    getProvideDay25Model().add(getProvideDay25Item6());

    getProvideDay25Model().add(getProvideDay25Item7());

  }

  /**
   * 25に内部項目を追加します。
   */
  protected void addProvideDay25Item1(){

  }

  /**
   * 25○に内部項目を追加します。
   */
  protected void addProvideDay25Item2(){

  }

  /**
   * 25△に内部項目を追加します。
   */
  protected void addProvideDay25Item3(){

  }

  /**
   * 25◎に内部項目を追加します。
   */
  protected void addProvideDay25Item4(){

  }

  /**
   * 25△◎に内部項目を追加します。
   */
  protected void addProvideDay25Item5(){

  }

  /**
   * 25◇に内部項目を追加します。
   */
  protected void addProvideDay25Item6(){

  }

  /**
   * 25△◇に内部項目を追加します。
   */
  protected void addProvideDay25Item7(){

  }

  /**
   * 提供日26に内部項目を追加します。
   */
  protected void addProvideDay26(){

  }

  /**
   * 提供日26モデルに内部項目を追加します。
   */
  protected void addProvideDay26Model(){

    getProvideDay26Model().add(getProvideDay26Item1());

    getProvideDay26Model().add(getProvideDay26Item2());

    getProvideDay26Model().add(getProvideDay26Item3());

    getProvideDay26Model().add(getProvideDay26Item4());

    getProvideDay26Model().add(getProvideDay26Item5());

    getProvideDay26Model().add(getProvideDay26Item6());

    getProvideDay26Model().add(getProvideDay26Item7());

  }

  /**
   * 26に内部項目を追加します。
   */
  protected void addProvideDay26Item1(){

  }

  /**
   * 26○に内部項目を追加します。
   */
  protected void addProvideDay26Item2(){

  }

  /**
   * 26△に内部項目を追加します。
   */
  protected void addProvideDay26Item3(){

  }

  /**
   * 26◎に内部項目を追加します。
   */
  protected void addProvideDay26Item4(){

  }

  /**
   * 26△◎に内部項目を追加します。
   */
  protected void addProvideDay26Item5(){

  }

  /**
   * 26◇に内部項目を追加します。
   */
  protected void addProvideDay26Item6(){

  }

  /**
   * 26△◇に内部項目を追加します。
   */
  protected void addProvideDay26Item7(){

  }

  /**
   * 提供日27に内部項目を追加します。
   */
  protected void addProvideDay27(){

  }

  /**
   * 提供日27モデルに内部項目を追加します。
   */
  protected void addProvideDay27Model(){

    getProvideDay27Model().add(getProvideDay27Item1());

    getProvideDay27Model().add(getProvideDay27Item2());

    getProvideDay27Model().add(getProvideDay27Item3());

    getProvideDay27Model().add(getProvideDay27Item4());

    getProvideDay27Model().add(getProvideDay27Item5());

    getProvideDay27Model().add(getProvideDay27Item6());

    getProvideDay27Model().add(getProvideDay27Item7());

  }

  /**
   * 27に内部項目を追加します。
   */
  protected void addProvideDay27Item1(){

  }

  /**
   * 27○に内部項目を追加します。
   */
  protected void addProvideDay27Item2(){

  }

  /**
   * 27△に内部項目を追加します。
   */
  protected void addProvideDay27Item3(){

  }

  /**
   * 27◎に内部項目を追加します。
   */
  protected void addProvideDay27Item4(){

  }

  /**
   * 27△◎に内部項目を追加します。
   */
  protected void addProvideDay27Item5(){

  }

  /**
   * 27◇に内部項目を追加します。
   */
  protected void addProvideDay27Item6(){

  }

  /**
   * 27△◇に内部項目を追加します。
   */
  protected void addProvideDay27Item7(){

  }

  /**
   * 提供日28に内部項目を追加します。
   */
  protected void addProvideDay28(){

  }

  /**
   * 提供日28モデルに内部項目を追加します。
   */
  protected void addProvideDay28Model(){

    getProvideDay28Model().add(getProvideDay28Item1());

    getProvideDay28Model().add(getProvideDay28Item2());

    getProvideDay28Model().add(getProvideDay28Item3());

    getProvideDay28Model().add(getProvideDay28Item4());

    getProvideDay28Model().add(getProvideDay28Item5());

    getProvideDay28Model().add(getProvideDay28Item6());

    getProvideDay28Model().add(getProvideDay28Item7());

  }

  /**
   * 28に内部項目を追加します。
   */
  protected void addProvideDay28Item1(){

  }

  /**
   * 28○に内部項目を追加します。
   */
  protected void addProvideDay28Item2(){

  }

  /**
   * 28△に内部項目を追加します。
   */
  protected void addProvideDay28Item3(){

  }

  /**
   * 28◎に内部項目を追加します。
   */
  protected void addProvideDay28Item4(){

  }

  /**
   * 28△◎に内部項目を追加します。
   */
  protected void addProvideDay28Item5(){

  }

  /**
   * 28◇に内部項目を追加します。
   */
  protected void addProvideDay28Item6(){

  }

  /**
   * 28△◇に内部項目を追加します。
   */
  protected void addProvideDay28Item7(){

  }

  /**
   * 提供日29に内部項目を追加します。
   */
  protected void addProvideDay29(){

  }

  /**
   * 提供日29モデルに内部項目を追加します。
   */
  protected void addProvideDay29Model(){

    getProvideDay29Model().add(getProvideDay29Item1());

    getProvideDay29Model().add(getProvideDay29Item2());

    getProvideDay29Model().add(getProvideDay29Item3());

    getProvideDay29Model().add(getProvideDay29Item4());

    getProvideDay29Model().add(getProvideDay29Item5());

    getProvideDay29Model().add(getProvideDay29Item6());

    getProvideDay29Model().add(getProvideDay29Item7());

  }

  /**
   * 29に内部項目を追加します。
   */
  protected void addProvideDay29Item1(){

  }

  /**
   * 29○に内部項目を追加します。
   */
  protected void addProvideDay29Item2(){

  }

  /**
   * 29△に内部項目を追加します。
   */
  protected void addProvideDay29Item3(){

  }

  /**
   * 29◎に内部項目を追加します。
   */
  protected void addProvideDay29Item4(){

  }

  /**
   * 29△◎に内部項目を追加します。
   */
  protected void addProvideDay29Item5(){

  }

  /**
   * 29◇に内部項目を追加します。
   */
  protected void addProvideDay29Item6(){

  }

  /**
   * 29△◇に内部項目を追加します。
   */
  protected void addProvideDay29Item7(){

  }

  /**
   * 提供日30に内部項目を追加します。
   */
  protected void addProvideDay30(){

  }

  /**
   * 提供日30モデルに内部項目を追加します。
   */
  protected void addProvideDay30Model(){

    getProvideDay30Model().add(getProvideDay30Item1());

    getProvideDay30Model().add(getProvideDay30Item2());

    getProvideDay30Model().add(getProvideDay30Item3());

    getProvideDay30Model().add(getProvideDay30Item4());

    getProvideDay30Model().add(getProvideDay30Item5());

    getProvideDay30Model().add(getProvideDay30Item6());

    getProvideDay30Model().add(getProvideDay30Item7());

  }

  /**
   * 30に内部項目を追加します。
   */
  protected void addProvideDay30Item1(){

  }

  /**
   * 30○に内部項目を追加します。
   */
  protected void addProvideDay30Item2(){

  }

  /**
   * 30△に内部項目を追加します。
   */
  protected void addProvideDay30Item3(){

  }

  /**
   * 30◎に内部項目を追加します。
   */
  protected void addProvideDay30Item4(){

  }

  /**
   * 30△◎に内部項目を追加します。
   */
  protected void addProvideDay30Item5(){

  }

  /**
   * 30◇に内部項目を追加します。
   */
  protected void addProvideDay30Item6(){

  }

  /**
   * 30△◇に内部項目を追加します。
   */
  protected void addProvideDay30Item7(){

  }

  /**
   * 提供日31に内部項目を追加します。
   */
  protected void addProvideDay31(){

  }

  /**
   * 提供日31モデルに内部項目を追加します。
   */
  protected void addProvideDay31Model(){

    getProvideDay31Model().add(getProvideDay31Item1());

    getProvideDay31Model().add(getProvideDay31Item2());

    getProvideDay31Model().add(getProvideDay31Item3());

    getProvideDay31Model().add(getProvideDay31Item4());

    getProvideDay31Model().add(getProvideDay31Item5());

    getProvideDay31Model().add(getProvideDay31Item6());

    getProvideDay31Model().add(getProvideDay31Item7());

  }

  /**
   * 31に内部項目を追加します。
   */
  protected void addProvideDay31Item1(){

  }

  /**
   * 31○に内部項目を追加します。
   */
  protected void addProvideDay31Item2(){

  }

  /**
   * 31△に内部項目を追加します。
   */
  protected void addProvideDay31Item3(){

  }

  /**
   * 31◎に内部項目を追加します。
   */
  protected void addProvideDay31Item4(){

  }

  /**
   * 31△◎に内部項目を追加します。
   */
  protected void addProvideDay31Item5(){

  }

  /**
   * 31◇に内部項目を追加します。
   */
  protected void addProvideDay31Item6(){

  }

  /**
   * 31△◇に内部項目を追加します。
   */
  protected void addProvideDay31Item7(){

  }

  /**
   * 備考領域に内部項目を追加します。
   */
  protected void addNoteContents(){

    noteContents.add(getNote(), VRLayout.FLOW);

  }

  /**
   * 備考に内部項目を追加します。
   */
  protected void addNote(){

  }

  /**
   * 合計領域に内部項目を追加します。
   */
  protected void addTotalContents(){

    totalContents.add(getTotalTitleContents(), VRLayout.NORTH);

    totalContents.add(getTotalNoTaxContents(), VRLayout.NORTH);

    totalContents.add(getTotalInTaxContents(), VRLayout.NORTH);

    totalContents.add(getTotalFullContents(), VRLayout.NORTH);

  }

  /**
   * 合計タイトル領域に内部項目を追加します。
   */
  protected void addTotalTitleContents(){

    totalTitleContents.add(getTotalSpace(), VRLayout.WEST);

    totalTitleContents.add(getTotalInsurerTitle(), VRLayout.CLIENT);

    totalTitleContents.add(getTotalUserTitle(), VRLayout.CLIENT);

  }

  /**
   * 合計余白に内部項目を追加します。
   */
  protected void addTotalSpace(){

  }

  /**
   * 保険に内部項目を追加します。
   */
  protected void addTotalInsurerTitle(){

  }

  /**
   * 保険外負担に内部項目を追加します。
   */
  protected void addTotalUserTitle(){

  }

  /**
   * 明細合計領域に内部項目を追加します。
   */
  protected void addTotalNoTaxContents(){

    totalNoTaxContents.add(getTotalNoTaxTitle(), VRLayout.WEST);

    totalNoTaxContents.add(getTotalNoTaxByInsurer(), VRLayout.CLIENT);

    totalNoTaxContents.add(getTotalNoTaxByPatient(), VRLayout.CLIENT);

  }

  /**
   * 明細合計額に内部項目を追加します。
   */
  protected void addTotalNoTaxTitle(){

  }

  /**
   * 保険の明細合計額に内部項目を追加します。
   */
  protected void addTotalNoTaxByInsurer(){

  }

  /**
   * 保険外負担の明細合計額に内部項目を追加します。
   */
  protected void addTotalNoTaxByPatient(){

  }

  /**
   * 課税合計領域に内部項目を追加します。
   */
  protected void addTotalInTaxContents(){

    totalInTaxContents.add(getTotalInTaxTitle(), VRLayout.WEST);

    totalInTaxContents.add(getTotalInTaxByInsurer(), VRLayout.CLIENT);

    totalInTaxContents.add(getTotalInTaxByPatient(), VRLayout.CLIENT);

  }

  /**
   * 課税対象額に内部項目を追加します。
   */
  protected void addTotalInTaxTitle(){

  }

  /**
   * 保険の課税対象額に内部項目を追加します。
   */
  protected void addTotalInTaxByInsurer(){

  }

  /**
   * 保険外負担の課税対象額に内部項目を追加します。
   */
  protected void addTotalInTaxByPatient(){

  }

  /**
   * 領収額合計領域に内部項目を追加します。
   */
  protected void addTotalFullContents(){

    totalFullContents.add(getTotalFullTitle(), VRLayout.WEST);

    totalFullContents.add(getTotalFull(), VRLayout.CLIENT);

  }

  /**
   * 領収額合計に内部項目を追加します。
   */
  protected void addTotalFullTitle(){

  }

  /**
   * 領収額合計額に内部項目を追加します。
   */
  protected void addTotalFull(){

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
      ACFrame.debugStart(new ACAffairInfo(QP012Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QP012Design getThis() {
    return this;
  }
}
