
/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
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
 * �A�v��: QKANCHO
 * �J����: ��i�@�a�P
 * �쐬��: 2006/06/19  ���{�R���s���[�^�[������� ��i�@�a�P �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (006)
 * �v���O���� ��Ö��׏��ڍוҏW (QP006)
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
 * ��Ö��׏��ڍוҏW�C�x���g��`(QP006) 
 */
public abstract class QP006Event extends QP006State {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QP006Event(){
    addEvents();
  }
  /**
   * �C�x���g�����������`���܂��B
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
  //�R���|�[�l���g�C�x���g

  /**
   * �uDB�o�^�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText1FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedDayText1FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText2FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText3FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText4FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText5FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedDayText2FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText6FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText7FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText8FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText9FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedDayText3FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText10FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText11FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText12FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText13FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedDayText4FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText14FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText15FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText16FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText17FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedDayText5FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText18FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText19FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText20FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText51FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedDayText8FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText52FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText53FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText54FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText21FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedDayText6FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText22FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText23FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText24FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText25FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedTimeText1FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText26FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText27FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText28FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText29FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText29InsertFocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedDayText7FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText30FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText31FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText32FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText36FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText37FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText38FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText39FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText40FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText41FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText42FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText43FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText44FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText45FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText46FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText47FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText48FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText49FocusLost(FocusEvent e) throws Exception;

  /**
   * �u���z�v�Z�����v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedMoneyText50FocusLost(FocusEvent e) throws Exception;

  /**
   * �uEnable���䏈���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedReductionFocusLost(FocusEvent e) throws Exception;

  /**
   * �uEnable���䏈���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected abstract void visitCareDetailedReductionTextChanged(DocumentEvent e) throws Exception;

  //�ϐ���`

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
   * PASSIVE_CHECK_KEY��Ԃ��܂��B
   * @return PASSIVE_CHECK_KEY
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY(){
    return PASSIVE_CHECK_KEY;
  }
  /**
   * PASSIVE_CHECK_KEY��ݒ肵�܂��B
   * @param PASSIVE_CHECK_KEY PASSIVE_CHECK_KEY
   */
  protected void setPASSIVE_CHECK_KEY(ACPassiveKey PASSIVE_CHECK_KEY){
    this.PASSIVE_CHECK_KEY = PASSIVE_CHECK_KEY;
  }

  /**
   * patientId��Ԃ��܂��B
   * @return patientId
   */
  protected int getPatientId(){
    return patientId;
  }
  /**
   * patientId��ݒ肵�܂��B
   * @param patientId patientId
   */
  protected void setPatientId(int patientId){
    this.patientId = patientId;
  }

  /**
   * listIndex��Ԃ��܂��B
   * @return listIndex
   */
  protected int getListIndex(){
    return listIndex;
  }
  /**
   * listIndex��ݒ肵�܂��B
   * @param listIndex listIndex
   */
  protected void setListIndex(int listIndex){
    this.listIndex = listIndex;
  }

  /**
   * claimStyleType��Ԃ��܂��B
   * @return claimStyleType
   */
  protected int getClaimStyleType(){
    return claimStyleType;
  }
  /**
   * claimStyleType��ݒ肵�܂��B
   * @param claimStyleType claimStyleType
   */
  protected void setClaimStyleType(int claimStyleType){
    this.claimStyleType = claimStyleType;
  }

  /**
   * providerId��Ԃ��܂��B
   * @return providerId
   */
  protected String getProviderId(){
    return providerId;
  }
  /**
   * providerId��ݒ肵�܂��B
   * @param providerId providerId
   */
  protected void setProviderId(String providerId){
    this.providerId = providerId;
  }

  /**
   * InsurerID��Ԃ��܂��B
   * @return InsurerID
   */
  protected String getInsurerID(){
    return InsurerID;
  }
  /**
   * InsurerID��ݒ肵�܂��B
   * @param InsurerID InsurerID
   */
  protected void setInsurerID(String InsurerID){
    this.InsurerID = InsurerID;
  }

  /**
   * targetDate��Ԃ��܂��B
   * @return targetDate
   */
  protected Date getTargetDate(){
    return targetDate;
  }
  /**
   * targetDate��ݒ肵�܂��B
   * @param targetDate targetDate
   */
  protected void setTargetDate(Date targetDate){
    this.targetDate = targetDate;
  }

  /**
   * claimDate��Ԃ��܂��B
   * @return claimDate
   */
  protected Date getClaimDate(){
    return claimDate;
  }
  /**
   * claimDate��ݒ肵�܂��B
   * @param claimDate claimDate
   */
  protected void setClaimDate(Date claimDate){
    this.claimDate = claimDate;
  }

  /**
   * modelMap��Ԃ��܂��B
   * @return modelMap
   */
  protected VRMap getModelMap(){
    return modelMap;
  }
  /**
   * modelMap��ݒ肵�܂��B
   * @param modelMap modelMap
   */
  protected void setModelMap(VRMap modelMap){
    this.modelMap = modelMap;
  }

  /**
   * windowMap��Ԃ��܂��B
   * @return windowMap
   */
  protected VRMap getWindowMap(){
    return windowMap;
  }
  /**
   * windowMap��ݒ肵�܂��B
   * @param windowMap windowMap
   */
  protected void setWindowMap(VRMap windowMap){
    this.windowMap = windowMap;
  }

  /**
   * claimList��Ԃ��܂��B
   * @return claimList
   */
  protected VRList getClaimList(){
    return claimList;
  }
  /**
   * claimList��ݒ肵�܂��B
   * @param claimList claimList
   */
  protected void setClaimList(VRList claimList){
    this.claimList = claimList;
  }

  //�����֐�

  /**
   * �u�f�[�^�擾�E��ʓW�J�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * �u�����f�[�^�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doFindClaim() throws Exception;

  /**
   * �u�\���p�ɕҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doEditDataForDisplay() throws Exception;

  /**
   * �u�ۑ������v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * �u�X�V�p�ɕҏW�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doEditDataForUpdate() throws Exception;

  /**
   * �u�������z�̍��v�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doCalcTotal() throws Exception;

  /**
   * �u����1�������z�̍��v�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doCalcTotalKohi1() throws Exception;

  /**
   * �u����2�������z�̍��v�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   *
   */
  public abstract void doCalcTotalKohi2() throws Exception;

  /**
   * �u���̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean isValidInput() throws Exception;

  /**
   * �u2�̒l�̌v�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param firstACTextField ACTextField
   * @param secondACTextField ACTextField
   * @param output ACTextField
   * @throws Exception ������O
   *
   */
  public abstract void multiPlication(ACTextField firstACTextField, ACTextField secondACTextField, ACTextField output) throws Exception;

  /**
   * �u3�̒l�̌v�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param firstACTextField ACTextField
   * @param secondACTextField ACTextField
   * @param thirdACTextField ACTextField
   * @param output ACTextField
   * @throws Exception ������O
   *
   */
  public abstract void multiPlication(ACTextField firstACTextField, ACTextField secondACTextField, ACTextField thirdACTextField, ACTextField output) throws Exception;

  /**
   * �u���v�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param sumArray[] ACTextField
   * @param output ACTextField
   * @param oneShare ACTextField
   * @throws Exception ������O
   *
   */
  public abstract void sumMachine(ACTextField sumArray[], ACTextField output, ACTextField oneShare) throws Exception;

  /**
   * �u�Ó��ȓ��t�̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param dateParam QkanDateTextField
   * @param errMsg String
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkErrorDate(QkanDateTextField dateParam, String errMsg) throws Exception;

  /**
   * �u�Ó��Ȏ����̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param timeParam ACTimeTextField
   * @param errMsg String
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkErrorTime(ACTimeTextField timeParam, String errMsg) throws Exception;

  /**
   * �u�������t�̓��̓`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param dateParam QkanDateTextField
   * @param errMsg String
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkFutureDate(QkanDateTextField dateParam, String errMsg) throws Exception;

  /**
   * �u���t�̊J�n���ƏI�����̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @param firstDateParam QkanDateTextField
   * @param secondDateParam QkanDateTextField
   * @param errMsg1 String
   * @param errMsg2 String
   * @param errMsg3 String
   * @throws Exception ������O
   * @return boolean
   */
  public abstract boolean checkRelationDate(QkanDateTextField firstDateParam, QkanDateTextField secondDateParam, String errMsg1, String errMsg2, String errMsg3) throws Exception;

}
