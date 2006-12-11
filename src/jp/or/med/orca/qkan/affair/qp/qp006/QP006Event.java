
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
 * 開発者: 上司　和善
 * 作成日: 2006/06/19  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (006)
 * プログラム 医療明細書詳細編集 (QP006)
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
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 医療明細書詳細編集イベント定義(QP006) 
 */
public abstract class QP006Event extends QP006State {
  /**
   * コンストラクタです。
   */
  public QP006Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getUpdate().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                updateActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedDayText1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedDayText1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedDayText2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedDayText2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText9().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText9FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedDayText3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedDayText3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText10().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText10FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText11().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText11FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText12().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText12FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText13().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText13FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedDayText4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedDayText4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText14().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText14FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText15().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText15FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText16().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText16FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText17().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText17FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedDayText5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedDayText5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText18().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText18FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText19().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText19FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText20().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText20FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText51().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText51FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedDayText8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedDayText8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText52().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText52FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText53().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText53FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText54().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText54FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText21().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText21FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedDayText6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedDayText6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText22().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText22FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText23().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText23FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText24().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText24FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText25().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText25FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedTimeText1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedTimeText1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText26().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText26FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText27().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText27FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText28().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText28FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText29().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText29FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText29Insert().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText29InsertFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedDayText7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedDayText7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText30().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText30FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText31().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText31FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText32().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText32FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText36().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText36FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText37().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText37FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText38().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText38FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText39().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText39FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText40().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText40FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText41().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText41FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText42().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText42FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText43().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText43FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText44().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText44FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText45().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText45FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText46().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText46FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText47().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText47FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText48().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText48FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText49().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText49FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedMoneyText50().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedMoneyText50FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedReduction().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedReductionFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getVisitCareDetailedReduction().getDocument().addDocumentListener(new DocumentListener(){
        private boolean lockFlag = false;
        public void changedUpdate(DocumentEvent e) {
          textChanged(e);
        }
        public void insertUpdate(DocumentEvent e) {
          textChanged(e);
        }
        public void removeUpdate(DocumentEvent e) {
          textChanged(e);
        }
        public void textChanged(DocumentEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                visitCareDetailedReductionTextChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「DB登録」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedDayText1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedDayText2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText9FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedDayText3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText10FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText11FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText12FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText13FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedDayText4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText14FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText15FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText16FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText17FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedDayText5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText18FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText19FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText20FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText51FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedDayText8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText52FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText53FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText54FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText21FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedDayText6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText22FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText23FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText24FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText25FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedTimeText1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText26FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText27FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText28FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText29FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText29InsertFocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedDayText7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText30FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText31FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText32FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText36FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText37FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText38FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText39FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText40FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText41FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText42FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText43FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText44FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText45FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText46FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText47FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText48FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText49FocusLost(FocusEvent e) throws Exception;

  /**
   * 「金額計算処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedMoneyText50FocusLost(FocusEvent e) throws Exception;

  /**
   * 「Enable制御処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedReductionFocusLost(FocusEvent e) throws Exception;

  /**
   * 「Enable制御処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void visitCareDetailedReductionTextChanged(DocumentEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY;
  public static final Integer Male = new Integer(1);
  public static final Integer feMale = new Integer(2);
  private int patientId;
  private int listIndex;
  private int claimStyleType;
  private String providerId;
  private String InsurerID;
  private Date targetDate;
  private Date claimDate;
  private VRMap modelMap = new VRHashMap();
  private VRMap windowMap = new VRHashMap();
  private VRList claimList = new VRArrayList();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEYを返します。
   * @return PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY(){
    return PASSIVE_CHECK_KEY;
  }
  /**
   * PASSIVE_CHECK_KEYを設定します。
   * @param PASSIVE_CHECK_KEY PASSIVE_CHECK_KEY
   */
  protected void setPASSIVE_CHECK_KEY(ACPassiveKey PASSIVE_CHECK_KEY){
    this.PASSIVE_CHECK_KEY = PASSIVE_CHECK_KEY;
  }

  /**
   * patientIdを返します。
   * @return patientId
   */
  protected int getPatientId(){
    return patientId;
  }
  /**
   * patientIdを設定します。
   * @param patientId patientId
   */
  protected void setPatientId(int patientId){
    this.patientId = patientId;
  }

  /**
   * listIndexを返します。
   * @return listIndex
   */
  protected int getListIndex(){
    return listIndex;
  }
  /**
   * listIndexを設定します。
   * @param listIndex listIndex
   */
  protected void setListIndex(int listIndex){
    this.listIndex = listIndex;
  }

  /**
   * claimStyleTypeを返します。
   * @return claimStyleType
   */
  protected int getClaimStyleType(){
    return claimStyleType;
  }
  /**
   * claimStyleTypeを設定します。
   * @param claimStyleType claimStyleType
   */
  protected void setClaimStyleType(int claimStyleType){
    this.claimStyleType = claimStyleType;
  }

  /**
   * providerIdを返します。
   * @return providerId
   */
  protected String getProviderId(){
    return providerId;
  }
  /**
   * providerIdを設定します。
   * @param providerId providerId
   */
  protected void setProviderId(String providerId){
    this.providerId = providerId;
  }

  /**
   * InsurerIDを返します。
   * @return InsurerID
   */
  protected String getInsurerID(){
    return InsurerID;
  }
  /**
   * InsurerIDを設定します。
   * @param InsurerID InsurerID
   */
  protected void setInsurerID(String InsurerID){
    this.InsurerID = InsurerID;
  }

  /**
   * targetDateを返します。
   * @return targetDate
   */
  protected Date getTargetDate(){
    return targetDate;
  }
  /**
   * targetDateを設定します。
   * @param targetDate targetDate
   */
  protected void setTargetDate(Date targetDate){
    this.targetDate = targetDate;
  }

  /**
   * claimDateを返します。
   * @return claimDate
   */
  protected Date getClaimDate(){
    return claimDate;
  }
  /**
   * claimDateを設定します。
   * @param claimDate claimDate
   */
  protected void setClaimDate(Date claimDate){
    this.claimDate = claimDate;
  }

  /**
   * modelMapを返します。
   * @return modelMap
   */
  protected VRMap getModelMap(){
    return modelMap;
  }
  /**
   * modelMapを設定します。
   * @param modelMap modelMap
   */
  protected void setModelMap(VRMap modelMap){
    this.modelMap = modelMap;
  }

  /**
   * windowMapを返します。
   * @return windowMap
   */
  protected VRMap getWindowMap(){
    return windowMap;
  }
  /**
   * windowMapを設定します。
   * @param windowMap windowMap
   */
  protected void setWindowMap(VRMap windowMap){
    this.windowMap = windowMap;
  }

  /**
   * claimListを返します。
   * @return claimList
   */
  protected VRList getClaimList(){
    return claimList;
  }
  /**
   * claimListを設定します。
   * @param claimList claimList
   */
  protected void setClaimList(VRList claimList){
    this.claimList = claimList;
  }

  //内部関数

  /**
   * 「データ取得・画面展開」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「請求データ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindClaim() throws Exception;

  /**
   * 「表示用に編集」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doEditDataForDisplay() throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「更新用に編集」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doEditDataForUpdate() throws Exception;

  /**
   * 「請求金額の合計」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doCalcTotal() throws Exception;

  /**
   * 「公費1請求金額の合計」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doCalcTotalKohi1() throws Exception;

  /**
   * 「公費2請求金額の合計」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doCalcTotalKohi2() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * 「2つの値の計算」に関する処理を行ないます。
   *
   * @param firstACTextField ACTextField
   * @param secondACTextField ACTextField
   * @param output ACTextField
   * @throws Exception 処理例外
   *
   */
  public abstract void multiPlication(ACTextField firstACTextField, ACTextField secondACTextField, ACTextField output) throws Exception;

  /**
   * 「3つの値の計算」に関する処理を行ないます。
   *
   * @param firstACTextField ACTextField
   * @param secondACTextField ACTextField
   * @param thirdACTextField ACTextField
   * @param output ACTextField
   * @throws Exception 処理例外
   *
   */
  public abstract void multiPlication(ACTextField firstACTextField, ACTextField secondACTextField, ACTextField thirdACTextField, ACTextField output) throws Exception;

  /**
   * 「合計」に関する処理を行ないます。
   *
   * @param sumArray[] ACTextField
   * @param output ACTextField
   * @param oneShare ACTextField
   * @throws Exception 処理例外
   *
   */
  public abstract void sumMachine(ACTextField sumArray[], ACTextField output, ACTextField oneShare) throws Exception;

  /**
   * 「妥当な日付の入力チェック」に関する処理を行ないます。
   *
   * @param dateParam QkanDateTextField
   * @param errMsg String
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkErrorDate(QkanDateTextField dateParam, String errMsg) throws Exception;

  /**
   * 「妥当な時刻の入力チェック」に関する処理を行ないます。
   *
   * @param timeParam ACTimeTextField
   * @param errMsg String
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkErrorTime(ACTimeTextField timeParam, String errMsg) throws Exception;

  /**
   * 「未来日付の入力チェック」に関する処理を行ないます。
   *
   * @param dateParam QkanDateTextField
   * @param errMsg String
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkFutureDate(QkanDateTextField dateParam, String errMsg) throws Exception;

  /**
   * 「日付の開始日と終了日のチェック」に関する処理を行ないます。
   *
   * @param firstDateParam QkanDateTextField
   * @param secondDateParam QkanDateTextField
   * @param errMsg1 String
   * @param errMsg2 String
   * @param errMsg3 String
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkRelationDate(QkanDateTextField firstDateParam, QkanDateTextField secondDateParam, String errMsg1, String errMsg2, String errMsg3) throws Exception;

}
