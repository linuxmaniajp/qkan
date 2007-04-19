
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
 * 作成日: 2007/03/10  日本コンピューター株式会社 田中　統蔵 新規作成
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
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * 訪問看護療養費領収書編集イベント定義(QP012) 
 */
public abstract class QP012Event extends QP012SQL {
  /**
   * コンストラクタです。
   */
  public QP012Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getOpen().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                openActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                insertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
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
    getPrint().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                printActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getTaxChange().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                taxChangeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName9().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName9FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice9().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice9FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber9().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber9FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum9().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum9FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName10().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName10FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice10().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice10FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber10().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber10FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum10().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum10FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName11().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName11FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice11().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice11FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber11().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber11FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum11().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum11FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName12().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName12FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice12().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice12FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber12().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber12FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum12().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum12FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName13().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName13FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice13().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice13FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber13().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber13FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum13().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum13FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName14().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName14FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice14().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice14FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber14().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber14FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum14().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum14FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName15().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName15FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice15().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice15FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber15().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber15FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum15().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum15FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName16().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName16FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice16().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice16FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber16().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber16FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum16().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum16FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName17().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName17FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice17().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice17FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber17().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber17FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum17().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum17FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName18().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName18FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice18().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice18FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber18().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber18FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum18().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum18FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName19().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName19FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice19().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice19FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber19().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber19FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum19().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum19FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerName20().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerName20FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerPrice20().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerPrice20FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerNumber20().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerNumber20FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByInsurerSum20().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byInsurerSum20FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax1().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax1ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax2().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax2ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax2().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax2FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget3ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax3().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax3ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget4().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget4ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax4().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax4ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax4().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax4FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget5().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget5ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax5().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax5ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax5().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax5FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget6().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget6ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax6().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax6ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax6().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax6FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget7().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget7ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax7().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax7ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax7().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax7FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget8().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget8ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax8().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax8ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax8().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax8FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName9().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName9FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice9().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice9FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber9().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber9FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum9().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum9FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget9().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget9ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax9().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax9ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax9().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax9FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName10().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName10FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice10().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice10FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber10().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber10FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum10().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum10FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget10().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget10ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax10().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax10ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax10().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax10FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName11().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName11FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice11().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice11FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber11().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber11FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum11().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum11FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget11().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget11ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax11().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax11ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax11().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax11FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName12().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName12FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice12().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice12FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber12().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber12FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum12().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum12FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget12().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget12ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax12().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax12ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax12().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax12FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName13().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName13FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice13().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice13FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber13().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber13FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum13().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum13FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget13().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget13ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax13().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax13ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax13().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax13FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName14().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName14FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice14().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice14FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber14().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber14FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum14().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum14FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget14().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget14ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax14().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax14ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax14().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax14FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName15().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName15FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice15().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice15FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber15().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber15FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum15().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum15FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget15().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget15ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax15().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax15ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax15().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax15FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName16().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName16FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice16().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice16FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber16().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber16FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum16().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum16FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget16().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget16ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax16().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax16ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax16().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax16FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName17().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName17FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice17().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice17FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber17().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber17FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum17().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum17FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget17().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget17ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax17().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax17ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax17().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax17FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName18().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName18FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice18().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice18FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber18().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber18FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum18().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum18FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget18().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget18ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax18().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax18ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax18().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax18FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName19().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName19FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice19().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice19FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber19().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber19FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum19().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum19FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget19().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget19ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax19().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax19ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax19().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax19FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientName20().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientName20FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientPrice20().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientPrice20FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientNumber20().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientNumber20FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientSum20().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientSum20FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTaxTarget20().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTaxTarget20ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientUseTax20().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientUseTax20ActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getByPatientTax20().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                byPatientTax20FocusLost(e);
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
   * 「実績読み込み」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void openActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「登録」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「更新」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「印刷」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void printActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「税率変更」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void taxChangeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName9FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice9FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber9FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum9FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName10FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice10FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber10FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum10FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName11FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice11FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber11FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum11FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName12FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice12FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber12FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum12FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName13FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice13FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber13FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum13FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName14FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice14FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber14FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum14FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName15FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice15FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber15FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum15FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName16FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice16FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber16FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum16FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName17FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice17FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber17FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum17FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName18FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice18FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber18FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum18FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName19FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice19FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber19FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum19FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerName20FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerPrice20FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerNumber20FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byInsurerSum20FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax1ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax2ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax2FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget3ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax3ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget4ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax4ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax4FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget5ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax5ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax5FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget6ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax6ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax6FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget7ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax7ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax7FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget8ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax8ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax8FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName9FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice9FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber9FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum9FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget9ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax9ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax9FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName10FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice10FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber10FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum10FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget10ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax10ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax10FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName11FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice11FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber11FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum11FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget11ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax11ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax11FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName12FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice12FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber12FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum12FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget12ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax12ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax12FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName13FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice13FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber13FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum13FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget13ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax13ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax13FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName14FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice14FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber14FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum14FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget14ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax14ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax14FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName15FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice15FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber15FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum15FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget15ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax15ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax15FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName16FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice16FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber16FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum16FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget16ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax16ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax16FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName17FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice17FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber17FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum17FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget17ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax17ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax17FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName18FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice18FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber18FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum18FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget18ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax18ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax18FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName19FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice19FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber19FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum19FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget19ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax19ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax19FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientName20FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientPrice20FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientNumber20FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientSum20FocusLost(FocusEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTaxTarget20ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientUseTax20ActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「再計算」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void byPatientTax20FocusLost(FocusEvent e) throws Exception;

  //変数定義

  private ACPassiveKey BILL_PASSIVE_CHECK_KEY;
  private int claimMedicalID;
  private int patientID;
  private int processMode;
  private int byPatientRateValue;
  private boolean innerTaxH1904Mode;
  private Date billStart;
  private Date billEnd;
  private VRMap byPatientSumCache = new VRHashMap();
  private Set byInsurerAndPatientNameCache;
  public static final int ROWS_OF_ITEM = 20;
  //getter/setter

  /**
   * BILL_PASSIVE_CHECK_KEYを返します。
   * @return BILL_PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getBILL_PASSIVE_CHECK_KEY(){
    return BILL_PASSIVE_CHECK_KEY;
  }
  /**
   * BILL_PASSIVE_CHECK_KEYを設定します。
   * @param BILL_PASSIVE_CHECK_KEY BILL_PASSIVE_CHECK_KEY
   */
  protected void setBILL_PASSIVE_CHECK_KEY(ACPassiveKey BILL_PASSIVE_CHECK_KEY){
    this.BILL_PASSIVE_CHECK_KEY = BILL_PASSIVE_CHECK_KEY;
  }

  /**
   * claimMedicalIDを返します。
   * @return claimMedicalID
   */
  protected int getClaimMedicalID(){
    return claimMedicalID;
  }
  /**
   * claimMedicalIDを設定します。
   * @param claimMedicalID claimMedicalID
   */
  protected void setClaimMedicalID(int claimMedicalID){
    this.claimMedicalID = claimMedicalID;
  }

  /**
   * patientIDを返します。
   * @return patientID
   */
  protected int getPatientID(){
    return patientID;
  }
  /**
   * patientIDを設定します。
   * @param patientID patientID
   */
  protected void setPatientID(int patientID){
    this.patientID = patientID;
  }

  /**
   * processModeを返します。
   * @return processMode
   */
  protected int getProcessMode(){
    return processMode;
  }
  /**
   * processModeを設定します。
   * @param processMode processMode
   */
  protected void setProcessMode(int processMode){
    this.processMode = processMode;
  }

  /**
   * byPatientRateValueを返します。
   * @return byPatientRateValue
   */
  protected int getByPatientRateValue(){
    return byPatientRateValue;
  }
  /**
   * byPatientRateValueを設定します。
   * @param byPatientRateValue byPatientRateValue
   */
  protected void setByPatientRateValue(int byPatientRateValue){
    this.byPatientRateValue = byPatientRateValue;
  }

  /**
   * innerTaxH1904Modeを返します。
   * @return innerTaxH1904Mode
   */
  protected boolean getInnerTaxH1904Mode(){
    return innerTaxH1904Mode;
  }
  /**
   * innerTaxH1904Modeを設定します。
   * @param innerTaxH1904Mode innerTaxH1904Mode
   */
  protected void setInnerTaxH1904Mode(boolean innerTaxH1904Mode){
    this.innerTaxH1904Mode = innerTaxH1904Mode;
  }

  /**
   * billStartを返します。
   * @return billStart
   */
  protected Date getBillStart(){
    return billStart;
  }
  /**
   * billStartを設定します。
   * @param billStart billStart
   */
  protected void setBillStart(Date billStart){
    this.billStart = billStart;
  }

  /**
   * billEndを返します。
   * @return billEnd
   */
  protected Date getBillEnd(){
    return billEnd;
  }
  /**
   * billEndを設定します。
   * @param billEnd billEnd
   */
  protected void setBillEnd(Date billEnd){
    this.billEnd = billEnd;
  }

  /**
   * byPatientSumCacheを返します。
   * @return byPatientSumCache
   */
  protected VRMap getByPatientSumCache(){
    return byPatientSumCache;
  }
  /**
   * byPatientSumCacheを設定します。
   * @param byPatientSumCache byPatientSumCache
   */
  protected void setByPatientSumCache(VRMap byPatientSumCache){
    this.byPatientSumCache = byPatientSumCache;
  }

  /**
   * byInsurerAndPatientNameCacheを返します。
   * @return byInsurerAndPatientNameCache
   */
  protected Set getByInsurerAndPatientNameCache(){
    return byInsurerAndPatientNameCache;
  }
  /**
   * byInsurerAndPatientNameCacheを設定します。
   * @param byInsurerAndPatientNameCache byInsurerAndPatientNameCache
   */
  protected void setByInsurerAndPatientNameCache(Set byInsurerAndPatientNameCache){
    this.byInsurerAndPatientNameCache = byInsurerAndPatientNameCache;
  }

  //内部関数

  /**
   * 「実績読み込み処理」に関する処理を行ないます。
   *
   * @param fullAleart boolean
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doOpenResult(boolean fullAleart) throws Exception;

  /**
   * 「登録処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doInsert() throws Exception;

  /**
   * 「更新処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doUpdate() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * 「項目名チェック変更」に関する処理を行ないます。
   *
   * @param name ACComboBox
   * @throws Exception 処理例外
   *
   */
  public abstract void doCheckName(ACComboBox name) throws Exception;

  /**
   * 「保険適用負担の金額再計算」に関する処理を行ないます。
   *
   * @param price ACTextField
   * @param number ACTextField
   * @param sum ACTextField
   * @throws Exception 処理例外
   *
   */
  public abstract void doCalcSum(ACTextField price, ACTextField number, ACTextField sum) throws Exception;

  /**
   * 「外税チェック変更」に関する処理を行ないます。
   *
   * @param price ACTextField
   * @param number ACTextField
   * @param sum ACTextField
   * @param taxTarget, ACCheckBox useTax ACCheckBox
   * @param tax, boolean mustCalcTax ACTextField
   * @throws Exception 処理例外
   *
   */
  public abstract void doCheckTax(ACTextField price, ACTextField number, ACTextField sum, ACCheckBox taxTarget, ACCheckBox useTax, ACTextField tax, boolean mustCalcTax) throws Exception;

  /**
   * 「保険外負担の金額再計算」に関する処理を行ないます。
   *
   * @param price ACTextField
   * @param number ACTextField
   * @param sum ACTextField
   * @param taxTarget, ACCheckBox useTax ACCheckBox
   * @param tax, boolean mustCalcSum ACTextField
   * @throws Exception 処理例外
   *
   */
  public abstract void doCalcSum(ACTextField price, ACTextField number, ACTextField sum, ACCheckBox taxTarget, ACCheckBox useTax, ACTextField tax, boolean mustCalcSum) throws Exception;

  /**
   * 「保険外負担の税再計算」に関する処理を行ないます。
   *
   * @param sum ACTextField
   * @param taxTarget, ACCheckBox useTax ACCheckBox
   * @param tax ACTextField
   * @throws Exception 処理例外
   *
   */
  public abstract void doCalcSum(ACTextField sum, ACCheckBox taxTarget, ACCheckBox useTax, ACTextField tax) throws Exception;

  /**
   * 「合計欄の再計算」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doCalcTotal() throws Exception;

  /**
   * 「税再集計」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doCalcTax() throws Exception;

  /**
   * 「データのフィルタリング」に関する処理を行ないます。
   *
   * @param data VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void filterBindPath(VRMap data) throws Exception;

  /**
   * 「定型文の追加」に関する処理を行ないます。
   *
   * @param data VRMap
   * @throws Exception 処理例外
   *
   */
  public abstract void insertFixedForm(VRMap data) throws Exception;

  /**
   * 「保険区分の解析」に関する処理を行ないます。
   *
   * @param insureInfo VRMap
   * @throws Exception 処理例外
   * @return String
   */
  public abstract String createInsureType(VRMap insureInfo) throws Exception;

  /**
   * 「項目名配列を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACComboBox[]
   */
  public abstract ACComboBox[] getByInsurerNamesAndPatientNames() throws Exception;

  /**
   * 「利用者負担の単価配列を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACTextField[]
   */
  public abstract ACTextField[] getByPatientPrices() throws Exception;

  /**
   * 「利用者負担の個数配列を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACTextField[]
   */
  public abstract ACTextField[] getByPatientNumbers() throws Exception;

  /**
   * 「利用者負担の金額配列を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACTextField[]
   */
  public abstract ACTextField[] getByPatientSums() throws Exception;

  /**
   * 「利用者負担の税配列を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACIntegerCheckBox[]
   */
  public abstract ACIntegerCheckBox[] getByPatientUseTaxs() throws Exception;

  /**
   * 「利用者負担の消費税等配列を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACTextField[]
   */
  public abstract ACTextField[] getByPatientTaxs() throws Exception;

  /**
   * 「利用者負担の課税対象配列を取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return ACIntegerCheckBox[]
   */
  public abstract ACIntegerCheckBox[] getByPatientTaxTargets() throws Exception;

  /**
   * 「平成19年4月改定チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void checkInnerTaxModeH1804() throws Exception;

}
