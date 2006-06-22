
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
 * 開発者: 上司 和善
 * 作成日: 2006/03/06  日本コンピューター株式会社 上司 和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 利用者管理 (U)
 * プロセス 利用者登録 (002)
 * プログラム 利用者登録 (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
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
 * 利用者登録イベント定義(QU002) 
 */
public abstract class QU002Event extends QU002SQL {
  /**
   * コンストラクタです。
   */
  public QU002Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
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
    getClearInsertMode().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                clearInsertModeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getClearUpdateMode().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                clearUpdateModeActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getToHokanInfoButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                toHokanInfoButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getToKohiInfoButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                toKohiInfoButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoButtonClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoButtonInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoButtonEdit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoButtonEditActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoButtonDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoButtonDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoTable().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoTableSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonClear().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonClearActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonInsert().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonInsertActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoButtonEdit().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoButtonEditActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoDelete().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoDeleteActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoServise().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoServiseActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoChangeContent().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoChangeContentActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getIdouInfoReason().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                idouInfoReasonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoInsurerId().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoInsurerIdFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoInsurerName().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoInsurerNameActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoKyotakuServiceRadio().addListSelectionListener(new ListSelectionListener(){
        private boolean lockFlag = false;
        public void valueChanged(ListSelectionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoKyotakuServiceRadioSelectionChanged(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoYokaigoInfo().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoYokaigoInfoActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoValidLimit1().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoValidLimit1FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getKaigoInfoValidLimit3().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                kaigoInfoValidLimit3FocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getBasicInfoBirth().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                basicInfoBirthFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getInstitutionInfoTokuteiNyusho().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                institutionInfoTokuteiNyushoActionPerformed(e);
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
  protected abstract void insertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「DB更新」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void updateActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面全体クリア処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void clearInsertModeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面全体クリア処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void clearUpdateModeActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面遷移処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void toHokanInfoButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面遷移処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void toKohiInfoButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「対象レコードを表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void idouInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「クリア処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void idouInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「追加処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void idouInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「編集処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void idouInfoButtonEditActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void idouInfoButtonDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「対象レコードを表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoTableSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「クリア処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoButtonClearActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「追加処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoButtonInsertActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「編集処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoButtonEditActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「削除処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoDeleteActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void idouInfoServiseActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void idouInfoChangeContentActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void idouInfoReasonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「保険者名表示・支給限度額表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoInsurerIdFocusLost(FocusEvent e) throws Exception;

  /**
   * 「保険者番号表示・支給限度額表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoInsurerNameActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoKyotakuServiceRadioSelectionChanged(ListSelectionEvent e) throws Exception;

  /**
   * 「支給限度額表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoYokaigoInfoActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「支給限度額表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoValidLimit1FocusLost(FocusEvent e) throws Exception;

  /**
   * 「支給限度額表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void kaigoInfoValidLimit3FocusLost(FocusEvent e) throws Exception;

  /**
   * 「年齢表示」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void basicInfoBirthFocusLost(FocusEvent e) throws Exception;

  /**
   * 「画面処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void institutionInfoTokuteiNyushoActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private ACPassiveKey PASSIVE_CHECK_KEY_PATIENT;
  private int patientId;
  private int processMode = QkanConstants.PROCESS_MODE_INSERT;
  private int idouTableChangeFlg;
  private int kaigoTableChangeFlg;
  private int kaigoDataFlg;
  private int idouDataFlg;
  private int shisetsuDataFlg;
  private int compulsoryBackFlg;
  private int NonCorrespondenceFlg;
  private Date systemDate;
  public static final Date TARGET_DATE_20060401 = ACCastUtilities.toDate("2006/04/01", null);
  public static final Date MAX_DATE = ACCastUtilities.toDate("9999/12/31", null);
  public static final Date MIN_DATE = ACCastUtilities.toDate("0001/01/01", null);
  public static final String AFFAIR_ID = "QU002";
  public static final int INDEX_OF_PROVIDER_SHIEN = 1;
  public static final int INSURE_RATE_SEIHO = 0;
  public static final int CHECK_MODE_INSERT = 1;
  public static final int CHECK_MODE_UPDATE = 2;
  public static final int CODE_YOKAIGODO = 204;
  public static final int CODE_SHINSEI_KUBUN = 11;
  public static final int CODE_TYUDAN_RIYU = 13;
  public static final int CODE_INSURE_RATE = 192;
  public static final int CODE_IDOU_CONTENT_KYOTAKU = 2;
  public static final int CODE_IDOU_CONTENT_SHISETSU1 = 3;
  public static final int CODE_IDOU_CONTENT_SHISETSU2 = 4;
  public static final int CODE_IDOU_CONTENT_IRYO_KANGO = 5;
  public static final int CODE_IDOU_CONTENT_SHISETSU3 = 200;
  public static final int CODE_IDOU_REASON_KYOTAKU = 6;
  public static final int CODE_IDOU_REASON_SHISETSU1 = 7;
  public static final int CODE_IDOU_REASON_SHISETSU2 = 8;
  public static final int CODE_IDOU_REASON_IRYO_KANGO = 9;
  public static final int CODE_IDOU_REASON_SHISETSU3 = 201;
  public static final int IDOU_SERVICE_KYOTAKU = 1;
  public static final int IDOU_SERVICE_SHISETSU1 = 2;
  public static final int IDOU_SERVICE_SHISETSU2 = 3;
  public static final int IDOU_SERVICE_IRYO_KANGO = 4;
  public static final int IDOU_SERVICE_SHISETSU3 = 5;
  public static final int IDOU_STOP_KYOTAKU = 2;
  public static final int IDOU_STOP_SHISETSU1 = 2;
  public static final int IDOU_STOP_SHISETSU2 = 2;
  public static final int IDOU_STOP_IRYO_KANGO = 2;
  public static final int IDOU_STOP_SHISETSU3 = 2;
  public static final int IDOU_OTHER_KYOTAKU = 5;
  public static final int IDOU_OTHER_SHISETSU1 = 5;
  public static final int IDOU_OTHER_SHISETSU2 = 5;
  public static final int IDOU_OTHER_IRYO_KANGO = 5;
  public static final int IDOU_OTHER_SHISETSU3 = 5;
  public static final int SERVICE_TYPE_SHIEN = 14311;
  public static final int SERVICE_TYPE_SHOKIBO = 17311;
  public static final int SERVICE_TYPE_OTHER = 90101;
  public static final int SERVICE_TYPE_ROUTINE = 90201;
  public static final int YOUKAIGODO_HIGAITOU = 1;
  private String processStart;
  private VRMap masterService = new VRHashMap();
  private VRMap masterCode = new VRHashMap();
  private VRList patientInfoList = new VRArrayList();
  private VRList kaigoHistoryList = new VRArrayList();
  private VRList idouHistoryList = new VRArrayList();
  private VRList shisetsuHistoryList = new VRArrayList();
  private ACTableModelAdapter kaigoTableModel;
  private ACTableModelAdapter idouTableModel;
  private ACSnapshot snapShotKaigo = new ACSnapshot();
  private ACSnapshot snapShotIdou = new ACSnapshot();
  //getter/setter

  /**
   * PASSIVE_CHECK_KEY_PATIENTを返します。
   * @return PASSIVE_CHECK_KEY_PATIENT
   */
  protected ACPassiveKey getPASSIVE_CHECK_KEY_PATIENT(){
    return PASSIVE_CHECK_KEY_PATIENT;
  }
  /**
   * PASSIVE_CHECK_KEY_PATIENTを設定します。
   * @param PASSIVE_CHECK_KEY_PATIENT PASSIVE_CHECK_KEY_PATIENT
   */
  protected void setPASSIVE_CHECK_KEY_PATIENT(ACPassiveKey PASSIVE_CHECK_KEY_PATIENT){
    this.PASSIVE_CHECK_KEY_PATIENT = PASSIVE_CHECK_KEY_PATIENT;
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
   * idouTableChangeFlgを返します。
   * @return idouTableChangeFlg
   */
  protected int getIdouTableChangeFlg(){
    return idouTableChangeFlg;
  }
  /**
   * idouTableChangeFlgを設定します。
   * @param idouTableChangeFlg idouTableChangeFlg
   */
  protected void setIdouTableChangeFlg(int idouTableChangeFlg){
    this.idouTableChangeFlg = idouTableChangeFlg;
  }

  /**
   * kaigoTableChangeFlgを返します。
   * @return kaigoTableChangeFlg
   */
  protected int getKaigoTableChangeFlg(){
    return kaigoTableChangeFlg;
  }
  /**
   * kaigoTableChangeFlgを設定します。
   * @param kaigoTableChangeFlg kaigoTableChangeFlg
   */
  protected void setKaigoTableChangeFlg(int kaigoTableChangeFlg){
    this.kaigoTableChangeFlg = kaigoTableChangeFlg;
  }

  /**
   * kaigoDataFlgを返します。
   * @return kaigoDataFlg
   */
  protected int getKaigoDataFlg(){
    return kaigoDataFlg;
  }
  /**
   * kaigoDataFlgを設定します。
   * @param kaigoDataFlg kaigoDataFlg
   */
  protected void setKaigoDataFlg(int kaigoDataFlg){
    this.kaigoDataFlg = kaigoDataFlg;
  }

  /**
   * idouDataFlgを返します。
   * @return idouDataFlg
   */
  protected int getIdouDataFlg(){
    return idouDataFlg;
  }
  /**
   * idouDataFlgを設定します。
   * @param idouDataFlg idouDataFlg
   */
  protected void setIdouDataFlg(int idouDataFlg){
    this.idouDataFlg = idouDataFlg;
  }

  /**
   * shisetsuDataFlgを返します。
   * @return shisetsuDataFlg
   */
  protected int getShisetsuDataFlg(){
    return shisetsuDataFlg;
  }
  /**
   * shisetsuDataFlgを設定します。
   * @param shisetsuDataFlg shisetsuDataFlg
   */
  protected void setShisetsuDataFlg(int shisetsuDataFlg){
    this.shisetsuDataFlg = shisetsuDataFlg;
  }

  /**
   * compulsoryBackFlgを返します。
   * @return compulsoryBackFlg
   */
  protected int getCompulsoryBackFlg(){
    return compulsoryBackFlg;
  }
  /**
   * compulsoryBackFlgを設定します。
   * @param compulsoryBackFlg compulsoryBackFlg
   */
  protected void setCompulsoryBackFlg(int compulsoryBackFlg){
    this.compulsoryBackFlg = compulsoryBackFlg;
  }

  /**
   * NonCorrespondenceFlgを返します。
   * @return NonCorrespondenceFlg
   */
  protected int getNonCorrespondenceFlg(){
    return NonCorrespondenceFlg;
  }
  /**
   * NonCorrespondenceFlgを設定します。
   * @param NonCorrespondenceFlg NonCorrespondenceFlg
   */
  protected void setNonCorrespondenceFlg(int NonCorrespondenceFlg){
    this.NonCorrespondenceFlg = NonCorrespondenceFlg;
  }

  /**
   * systemDateを返します。
   * @return systemDate
   */
  protected Date getSystemDate(){
    return systemDate;
  }
  /**
   * systemDateを設定します。
   * @param systemDate systemDate
   */
  protected void setSystemDate(Date systemDate){
    this.systemDate = systemDate;
  }

  /**
   * processStartを返します。
   * @return processStart
   */
  protected String getProcessStart(){
    return processStart;
  }
  /**
   * processStartを設定します。
   * @param processStart processStart
   */
  protected void setProcessStart(String processStart){
    this.processStart = processStart;
  }

  /**
   * masterServiceを返します。
   * @return masterService
   */
  protected VRMap getMasterService(){
    return masterService;
  }
  /**
   * masterServiceを設定します。
   * @param masterService masterService
   */
  protected void setMasterService(VRMap masterService){
    this.masterService = masterService;
  }

  /**
   * masterCodeを返します。
   * @return masterCode
   */
  protected VRMap getMasterCode(){
    return masterCode;
  }
  /**
   * masterCodeを設定します。
   * @param masterCode masterCode
   */
  protected void setMasterCode(VRMap masterCode){
    this.masterCode = masterCode;
  }

  /**
   * patientInfoListを返します。
   * @return patientInfoList
   */
  protected VRList getPatientInfoList(){
    return patientInfoList;
  }
  /**
   * patientInfoListを設定します。
   * @param patientInfoList patientInfoList
   */
  protected void setPatientInfoList(VRList patientInfoList){
    this.patientInfoList = patientInfoList;
  }

  /**
   * kaigoHistoryListを返します。
   * @return kaigoHistoryList
   */
  protected VRList getKaigoHistoryList(){
    return kaigoHistoryList;
  }
  /**
   * kaigoHistoryListを設定します。
   * @param kaigoHistoryList kaigoHistoryList
   */
  protected void setKaigoHistoryList(VRList kaigoHistoryList){
    this.kaigoHistoryList = kaigoHistoryList;
  }

  /**
   * idouHistoryListを返します。
   * @return idouHistoryList
   */
  protected VRList getIdouHistoryList(){
    return idouHistoryList;
  }
  /**
   * idouHistoryListを設定します。
   * @param idouHistoryList idouHistoryList
   */
  protected void setIdouHistoryList(VRList idouHistoryList){
    this.idouHistoryList = idouHistoryList;
  }

  /**
   * shisetsuHistoryListを返します。
   * @return shisetsuHistoryList
   */
  protected VRList getShisetsuHistoryList(){
    return shisetsuHistoryList;
  }
  /**
   * shisetsuHistoryListを設定します。
   * @param shisetsuHistoryList shisetsuHistoryList
   */
  protected void setShisetsuHistoryList(VRList shisetsuHistoryList){
    this.shisetsuHistoryList = shisetsuHistoryList;
  }

  /**
   * kaigoTableModelを返します。
   * @return kaigoTableModel
   */
  protected ACTableModelAdapter getKaigoTableModel(){
    return kaigoTableModel;
  }
  /**
   * kaigoTableModelを設定します。
   * @param kaigoTableModel kaigoTableModel
   */
  protected void setKaigoTableModel(ACTableModelAdapter kaigoTableModel){
    this.kaigoTableModel = kaigoTableModel;
  }

  /**
   * idouTableModelを返します。
   * @return idouTableModel
   */
  protected ACTableModelAdapter getIdouTableModel(){
    return idouTableModel;
  }
  /**
   * idouTableModelを設定します。
   * @param idouTableModel idouTableModel
   */
  protected void setIdouTableModel(ACTableModelAdapter idouTableModel){
    this.idouTableModel = idouTableModel;
  }

  /**
   * snapShotKaigoを返します。
   * @return snapShotKaigo
   */
  protected ACSnapshot getSnapShotKaigo(){
    return snapShotKaigo;
  }
  /**
   * snapShotKaigoを設定します。
   * @param snapShotKaigo snapShotKaigo
   */
  protected void setSnapShotKaigo(ACSnapshot snapShotKaigo){
    this.snapShotKaigo = snapShotKaigo;
  }

  /**
   * snapShotIdouを返します。
   * @return snapShotIdou
   */
  protected ACSnapshot getSnapShotIdou(){
    return snapShotIdou;
  }
  /**
   * snapShotIdouを設定します。
   * @param snapShotIdou snapShotIdou
   */
  protected void setSnapShotIdou(ACSnapshot snapShotIdou){
    this.snapShotIdou = snapShotIdou;
  }

  //内部関数

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInputPatient() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInputIdou() throws Exception;

  /**
   * 「支給限度額表示」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindLimitRate() throws Exception;

  /**
   * 「支給限度額取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return int
   */
  public abstract int getLimitRate() throws Exception;

  /**
   * 「入力チェック・支給限度額取得用引数作成」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public abstract VRMap getParamForLimitRate() throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @param checkMode int
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidInputKaigo(int checkMode) throws Exception;

  /**
   * 「保存処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean doSave() throws Exception;

  /**
   * 「レコード取得・画面設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFind() throws Exception;

  /**
   * 「利用者情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindPatient() throws Exception;

  /**
   * 「要介護履歴情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindKaigo() throws Exception;

  /**
   * 「異動履歴情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindIdou() throws Exception;

  /**
   * 「施設履歴情報取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doFindShisetsu() throws Exception;

  /**
   * 「画面全体クリア処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void doClear() throws Exception;

  /**
   * 「画面初期化」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void initialize() throws Exception;

  /**
   * 「状態設定」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   *
   */
  public abstract void casualInitialize() throws Exception;

}
