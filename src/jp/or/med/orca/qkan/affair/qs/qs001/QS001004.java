
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
 * 作成日: 2006/05/29  日本コンピューター株式会社 田中　統蔵 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 計画単位数編集画面 (QS001032)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * 計画単位数編集画面(QS001032) 
 */
@SuppressWarnings("serial")
public class QS001004 extends QS001004Event {
  /**
   * コンストラクタです。
   */
  public QS001004(){
  }

  //コンポーネントイベント

  /**
   * 「破棄して閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void closeActionPerformed(ActionEvent e) throws Exception{
    // ■入力内容を破棄して画面を閉じる
    // 　画面を破棄します。
      dispose();
  }

  /**
   * 「保存して閉じる」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void okActionPerformed(ActionEvent e) throws Exception{
    // ■入力内容を保存して画面を閉じる
      if (!ACTextUtilities.isNullText(getSelectedProviderID())) {
          // 選択中の事業所番号が空でない場合
          // テーブルに入力された計画単位数を再集計して、事業所別計画単位数に追加する。
          getPlanUnits().setData(getSelectedProviderID(),
                  getSelectedPlanUnits());
      }
      setApplied(true);
      
      // 　画面を破棄します。
     dispose();
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001004.class.getName(), param));
  }

  //内部関数

  /**
     * 「初期設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean showModal(VRMap planUnit) throws Exception {
        // ■画面展開時の初期設定

        // 既存の計画単位数を内部変数に退避する。
        VRMap newMap = new VRHashMap();
        Iterator it = planUnit.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry ent = (Map.Entry) it.next();
            newMap.setData(ent.getKey(), ((VRMap) ent.getValue()).clone());
        }
        setPlanUnits(newMap);

        // 自事業所一覧を取得し、事業所コンボに設定する。
        VRList providers = getDBManager().executeQuery(
                getSQL_GET_MY_PROVIDER(null));
        
// 2016/9/6 [Yoichiro Kamei] add - begin 総合事業対応
        //対象の事業所が設定されていればその事業所のみ選択可とする
        if (!getTargetProviderIds().isEmpty()) {
        	VRList tmp = new VRArrayList();
        	for (int index = 0; index < providers.size(); index++) {
        		VRMap row = (VRMap) providers.get(index);
        		String provierId = ACCastUtilities.toString(row.get("PROVIDER_ID"));
        		if (getTargetProviderIds().contains(provierId)) {
        			tmp.add(row);
        		}
        	}
        	if (!tmp.isEmpty()) {
        		providers = tmp;
        	}
        }
// 2016/9/6 [Yoichiro Kamei] add - end
        getProvider().setModel(providers);
        
// 2016/9/6 [Yoichiro Kamei] mod - begin 総合事業対応
//        // ログイン事業所をデフォルト選択する。
//        getProvider().setSelectedIndex(
//                ACBindUtilities.getMatchIndexFromValue(providers,
//                        "PROVIDER_ID", QkanSystemInformation.getInstance()
//                                .getLoginProviderID()));
        String iniProviderId = QkanSystemInformation.getInstance()
        		.getLoginProviderID();
        if (!getTargetProviderIds().isEmpty()) {
        	iniProviderId = (String) getTargetProviderIds().get(0);
        }
        getProvider().setSelectedIndex(
           ACBindUtilities.getMatchIndexFromValue(providers,
              "PROVIDER_ID", iniProviderId));
// 2016/9/6 [Yoichiro Kamei] mod - end
        

        // ※計画単位数列のエディタをテキストフィールドとみなし、以下のプロパティ設定を行う。
        Component unitEditor = getPlanUnitTableUnit().getCellEditorComponent();
        if (unitEditor instanceof ACTextField) {
            ACTextField editor = (ACTextField) unitEditor;
            // 最大入力文字数：6
            editor.setMaxLength(6);
            // 許可文字種別：数字
            editor.setCharType(VRCharType.ONLY_DIGIT);
        }

        // ※ウィンドウタイトルの設定
        setAffairTitle("QS001004");
        // 画面をモーダル表示する。
        setVisible(true);
        //    決定ボタンを押して閉じたかを返す。
        return getApplied();
    }

  /**
   * 「対象事業所選択」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
    protected void providerActionPerformed(ActionEvent e) throws Exception {
        // ■計画単位数の編集対象事業所を選択
        if (!ACTextUtilities.isNullText(getSelectedProviderID())) {
            // 選択中の事業所番号が空でない場合
            // テーブルに入力された計画単位数を再集計して、事業所別計画単位数に追加する。
            getPlanUnits().setData(getSelectedProviderID(),
                    getSelectedPlanUnits());

        }
        Object obj = getProvider().getSelectedModelItem();
        if (obj instanceof VRMap) {
            // 選択中の事業所番号に、選択した事業所の事業所番号を設定する。
            setSelectedProviderID(ACCastUtilities.toString(VRBindPathParser
                    .get("PROVIDER_ID", (VRMap) obj)));
            obj = getPlanUnits().get(getSelectedProviderID());
            if (!(obj instanceof VRMap)) {
                // 事業所別計画単位数のキーに選択中の事業所番号が含まれない場合
                //新規にレコードを生成し、選択中の事業所番号をキーとした事業所別計画単位数の値として追加する。
                obj = new VRHashMap();
                getPlanUnits().setData(getSelectedProviderID(), obj);
            }
            // ※引数を元にテーブルモデルを作成し、計画単位数テーブル(planUnitTable)に設定する。
            VRMap planUnit = (VRMap) obj;
            VRArrayList units = new VRArrayList();
            String[] pathes = CareServiceCommon.getPlanUnitBindPathes();
// 2016/9/6 [Yoichiro Kamei] add - begin 総合事業対応
            //対象のサービス種類が設定されていればそのサービス種類のみ設定可とする
            VRList kindList = getTargetServiceCodeKinds();
            if (!kindList.isEmpty()) {
            	VRList tmp = new VRArrayList();
            	for (int index = 0; index < kindList.size(); index++) {
            		String kind = ACCastUtilities.toString(kindList.get(index));
            		String path = CareServiceCommon.getPlanUnitBindPath(kind);
            		if (!"".equals(path)) {
            			tmp.add(path);
            		}
            	}
            	if (!tmp.isEmpty()) {
            		pathes = (String[]) tmp.toArray(new String[0]);
            	}
            }
// 2016/9/6 [Yoichiro Kamei] add - end
            int end = pathes.length;
        	// [H28.4法改正対応][Shinobu Hitaka] 2016/02/02 add - begin
            // 78:地域密着型通所介護は対象年月がH28.4以降の場合とする
            boolean h2804flag = true;
        	if (getTargetDate() != null && 
                    ACDateUtilities.getDifferenceOnDay(QkanConstants.H2804, getTargetDate()) > 0) {
        		h2804flag = false;
        	}
        	// [H28.4法改正対応][Shinobu Hitaka] 2016/02/02 add - end
            for (int i = 0; i < end; i++) {
            	// [H28.4法改正対応][Shinobu Hitaka] 2016/02/02 add - begin
            	if (h2804flag == false && pathes[i].equals("1078")) {
            		continue;
            	}
            	// [H28.4法改正対応][Shinobu Hitaka] 2016/02/02 add - end
                VRMap row = new VRHashMap();
                row.setData("SERVICE_KIND_NAME", pathes[i]);
                row.setData("UNIT", ACCastUtilities.toInteger(VRBindPathParser
                        .get(pathes[i], planUnit), 0));
                units.add(row);
            }
            
            getPlanUnitTable().setModel(
                    new ACTableModelAdapter(units, new String[] {
                            "SERVICE_KIND_NAME", "UNIT" }));          
            setPlanUnitModelValue(units);
        }
    }

    /**
     * 「入力中の計画単位数の取得」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     *
     */
    public VRMap getSelectedPlanUnits() throws Exception {
        // テーブルに入力された計画単位数を再集計して返す。
        VRMap units = new VRHashMap();
        Iterator it = getPlanUnitModelValue().iterator();
        while (it.hasNext()) {
            VRMap row = (VRMap) it.next();
            int unit = ACCastUtilities.toInt(VRBindPathParser.get("UNIT", row),
                    0);
            if (unit > 0) {
                units.put(VRBindPathParser.get("SERVICE_KIND_NAME", row),
                        ACCastUtilities.toInteger(unit));
            }
        }
        if(!units.isEmpty()){
            units.setData("PROVIDER_ID", getSelectedProviderID());
        }
        return units;
    }

    /**
     * 「確定した計画単位数を取得」に関する処理を行ないます。
     *
     * @throws Exception 処理例外
     * @return VRMap
     */
    public VRMap getAppliedValue() throws Exception {
        return getPlanUnits();
    }

}
