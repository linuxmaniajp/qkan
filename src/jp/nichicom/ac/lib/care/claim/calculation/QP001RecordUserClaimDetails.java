
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
 * 開発者: 藤原　伸
 * 作成日: 2008/02/27  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 利用者向け請求レコード-詳細 (QP001RecordUserClaimDetails)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public class QP001RecordUserClaimDetails extends QP001RecordAbstract {

    // 利用者負担　サービス名
    private String[] serviceNames = new String[19];
    // 利用者負担　利用者負担額
    private int[] serviceClaim = new int[19];
    // 利用者負担　単位数
    private int[] serviceUnit = new int[19];
    // 利用者負担　回数・日数
    private int[] serviceCount = new int[19];
    
    // 公費本人負担　公費名称
    private String[] kohiNames = new String[2];
    // 公費本人負担　本人負担額
    private int[] kohiClaim = new int[2];
    
    // 事業所名
    private String _1601027 = "";
    // 所在地
    private String _1601028 = "";
    // 電話番号
    private String _1601029 = "";
    // 管理者名
    private String _1601030 = "";
    // 居宅介護支援事業所名
    private String _1601031 = "";
    // 領収年月日
    private String _1601032 = "";
    // 振込先金融機関名
    private String _1601033 = "";
    // 振込先金融機関支店名
    private String _1601034 = "";
    // 振込先口座番号
    private String _1601035 = "";
    // 振込先口座種類
    private String _1601036 = "";
    // 振込先名義人
    private String _1601037 = "";
    // 請求対象月
    private Date target = null;
    
    //[H20.5 法改正対応] fujihara add start
    private RecuperationUnitCalc unitCalc = new RecuperationUnitCalc();
    //[H20.5 法改正対応] fujihara add end
    
    //[2014年要望][Shinobu Hitaka] 2015/04/15 add begin 「利用者負担額0円も印刷可能にする」のチェック状況
    private int zeroPrint = 0;
    //[2014年要望][Shinobu Hitaka] 2015/04/15 add end

    protected String getSerialId() {
        return null;
    }
    /**
     * 利用者負担(1列目)　サービス名を取得する。
     * @return
     */
    private String get_1601001() {
        return serviceNames[0];
    }
    /**
     * 利用者負担(1列目)　利用者負担額を取得する。
     * @return
     */
    private int get_1601002() {
        return serviceClaim[0];
    }
    /**
     * 利用者負担(2列目)　サービス名を取得する。
     * @return
     */
    private String get_1601003() {
        return serviceNames[1];
    }
    /**
     * 利用者負担(2列目)　利用者負担額を取得する。
     * @return
     */
    private int get_1601004() {
        return serviceClaim[1];
    }
    /**
     * 利用者負担(3列目)　サービス名を取得する。
     * @return
     */
    private String get_1601005() {
        return serviceNames[2];
    }
    /**
     * 利用者負担(3列目)　利用者負担額を取得する。
     * @return
     */
    private int get_1601006() {
        return serviceClaim[2];
    }
    /**
     * 利用者負担(4列目)　サービス名を取得する。
     * @return
     */
    private String get_1601007() {
        return serviceNames[3];
    }
    /**
     * 利用者負担(4列目)　利用者負担額を取得する。
     * @return
     */
    private int get_1601008() {
        return serviceClaim[3];
    }
    /**
     * 利用者負担(5列目)　サービス名を取得する。
     * @return
     */
    private String get_1601009() {
        return serviceNames[4];
    }
    /**
     * 利用者負担(5列目)　利用者負担額を取得する。
     * @return
     */
    private int get_1601010() {
        return serviceClaim[4];
    }
    /**
     * 利用者負担(6列目)　サービス名を取得する。
     * @return
     */
    private String get_1601011() {
        return serviceNames[5];
    }
    /**
     * 利用者負担(6列目)　利用者負担額を取得する。
     * @return
     */
    private int get_1601012() {
        return serviceClaim[5];
    }
    /**
     * 利用者負担(7列目)　サービス名を取得する。
     * @return
     */
    private String get_1601013() {
        return serviceNames[6];
    }
    /**
     * 利用者負担(7列目)　利用者負担額を取得する。
     * @return
     */
    private int get_1601014() {
        return serviceClaim[6];
    }
    /**
     * 利用者負担(8列目)　サービス名を取得する。
     * @return
     */
    private String get_1601015() {
        return serviceNames[7];
    }
    /**
     * 利用者負担(8列目)　利用者負担額を取得する。
     * @return
     */
    private int get_1601016() {
        return serviceClaim[7];
    }
    /**`
     * 利用者負担(9列目)　サービス名を取得する。
     * @return
     */
    private String get_1601017() {
        return serviceNames[8];
    }
    /**
     * 利用者負担(9列目)　利用者負担額を取得する。
     * @return
     */
    private int get_1601018() {
        return serviceClaim[8];
    }
    /**
     * 利用者負担(10列目)　サービス名を取得する。
     * @return
     */
    private String get_1601019() {
        return serviceNames[9];
    }
    /**
     * 利用者負担(10列目)　利用者負担額を取得する。
     * @return
     */
    private int get_1601020() {
        return serviceClaim[9];
    }
    /**
     * 公費本人負担(1列目)　公費名称を取得する。
     * @return
     */
    private String get_1601021() {
        return kohiNames[0];
    }
    /**
     * 公費本人負担(1列目)　本人負担額を取得する。
     * @return
     */
    private int get_1601022() {
        return kohiClaim[0];
    }
    /**
     * 公費本人負担(2列目)　公費名称を取得する。
     * @return
     */
    private String get_1601023() {
        return kohiNames[1];
    }
    /**
     * 公費本人負担(2列目)　本人負担額を取得する。
     * @return
     */
    private int get_1601024() {
        return kohiClaim[1];
    }
    
    /**
     * 事業所名を取得する。
     * @return
     */
    private String get_1601027() {
        return _1601027;
    }
    /**
     * 所在地を取得する。
     * @return
     */
    private String get_1601028() {
        return _1601028;
    }
    /**
     * 電話番号を取得する。
     * @return
     */
    private String get_1601029() {
        return _1601029;
    }
    /**
     * 管理者名を取得する。
     * @return
     */
    private String get_1601030() {
        return _1601030;
    }
    /**
     * 居宅介護支援事業所名を取得する。
     * @return
     */
    private String get_1601031() {
        return _1601031;
    }
    /**
     * 領収年月日を取得する。
     * @return
     */
    private String get_1601032() {
        return _1601032;
    }
    /**
     * 振込先金融機関名を取得する。
     * @return
     */
    private String get_1601033() {
        return _1601033;
    }
    /**
     * 振込先金融機関支店名を取得する。
     * @return
     */
    private String get_1601034() {
        return _1601034;
    }
    /**
     * 振込先口座番号を取得する。
     * @return
     */
    private String get_1601035() {
        return _1601035;
    }
    /**
     * 振込先口座種類を取得する。
     * @return
     */
    private String get_1601036() {
        return _1601036;
    }
    /**
     * 振込先名義人を取得する。
     * @return
     */
    private String get_1601037() {
        return _1601037;
    }
    /**
     * 請求対象月を設定する。
     * @param target
     */
    private void setTargetDate(Date target) {
        this.target = target;
    }
    
    /**
     * 請求対象月を取得する。
     * @return
     */
    private Date getTargetDate() {
        return target;
    }
    
    //[2014年要望][Shinobu Hitaka] 2015/04/15 add begin 「利用者負担額0円も印刷可能にする」のチェック状況
    /**
     * 利用者負担額0円の印字モードを設定する。
     * @param target
     */
    public void setZeroPrint(int zeroPrint) {
        this.zeroPrint = zeroPrint;
    }
    
    /**
     * 利用者負担額0円の印字モードを取得する。
     * @return
     */
    public int getZeroPrint() {
        return zeroPrint;
    }
    //[2014年要望][Shinobu Hitaka] 2015/04/15 add end
    
    /**
     * 利用者負担(1列目)　単位数を取得します。
     * @return
     */
    private int get_1601038() {
        return serviceUnit[0];
    }
    /**
     * 利用者負担(1列目)　回数を取得します。
     * @return
     */
    private int get_1601039() {
        return serviceCount[0];
    }
    /**
     * 利用者負担(2列目)　単位数を取得します。
     * @return
     */
    private int get_1601040() {
        return serviceUnit[1];
    }
    /**
     * 利用者負担(2列目)　回数を取得します。
     * @return
     */
    private int get_1601041() {
        return serviceCount[1];
    }
    /**
     * 利用者負担(3列目)　単位数を取得します。
     * @return
     */
    private int get_1601042() {
        return serviceUnit[2];
    }
    /**
     * 利用者負担(3列目)　回数を取得します。
     * @return
     */
    private int get_1601043() {
        return serviceCount[2];
    }
    /**
     * 利用者負担(4列目)　単位数を取得します。
     * @return
     */
    private int get_1601044() {
        return serviceUnit[3];
    }
    /**
     * 利用者負担(4列目)　回数を取得します。
     * @return
     */
    private int get_1601045() {
        return serviceCount[3];
    }
    /**
     * 利用者負担(5列目)　単位数を取得します。
     * @return
     */
    private int get_1601046() {
        return serviceUnit[4];
    }
    /**
     * 利用者負担(5列目)　回数を取得します。
     * @return
     */
    private int get_1601047() {
        return serviceCount[4];
    }
    /**
     * 利用者負担(6列目)　単位数を取得します。
     * @return
     */
    private int get_1601048() {
        return serviceUnit[5];
    }
    /**
     * 利用者負担(6列目)　回数を取得します。
     * @return
     */
    private int get_1601049() {
        return serviceCount[5];
    }
    /**
     * 利用者負担(7列目)　単位数を取得します。
     * @return
     */
    private int get_1601050() {
        return serviceUnit[6];
    }
    /**
     * 利用者負担(7列目)　回数を取得します。
     * @return
     */
    private int get_1601051() {
        return serviceCount[6];
    }
    /**
     * 利用者負担(8列目)　単位数を取得します。
     * @return
     */
    private int get_1601052() {
        return serviceUnit[7];
    }
    /**
     * 利用者負担(8列目)　回数を取得します。
     * @return
     */
    private int get_1601053() {
        return serviceCount[7];
    }
    /**
     * 利用者負担(9列目)　単位数を取得します。
     * @return
     */
    private int get_1601054() {
        return serviceUnit[8];
    }
    /**
     * 利用者負担(9列目)　回数を取得します。
     * @return
     */
    private int get_1601055() {
        return serviceCount[8];
    }
    /**
     * 利用者負担(10列目)　単位数を取得します。
     * @return
     */
    private int get_1601056() {
        return serviceUnit[9];
    }
    /**
     * 利用者負担(10列目)　回数を取得します。
     * @return
     */
    private int get_1601057() {
        return serviceCount[9];
    }
    /**
     * 利用者負担(11列目)　サービス名を取得します。
     * @return
     */
    private String get_1601062() {
        return serviceNames[10];
    }
    /**
     * 利用者負担(11列目)　単位数を取得します。
     * @return
     */
    private int get_1601063() {
        return serviceUnit[10];
    }
    /**
     * 利用者負担(11列目)　回数を取得します。
     * @return
     */
    private int get_1601064() {
        return serviceCount[10];
    }
    /**
     * 利用者負担(11列目)　利用者負担額を取得します。
     * @return
     */
    private int get_1601065() {
        return serviceClaim[10];
    }
    /**
     * 利用者負担(12列目)　サービス名を取得します。
     * @return
     */
    private String get_1601066() {
        return serviceNames[11];
    }
    /**
     * 利用者負担(12列目)　単位数を取得します。
     * @return
     */
    private int get_1601067() {
        return serviceUnit[11];
    }
    /**
     * 利用者負担(12列目)　回数を取得します。
     * @return
     */
    private int get_1601068() {
        return serviceCount[11];
    }
    /**
     * 利用者負担(12列目)　利用者負担額を取得します。
     * @return
     */
    private int get_1601069() {
        return serviceClaim[11];
    }
    /**
     * 利用者負担(13列目)　サービス名を取得します。
     * @return
     */
    private String get_1601070() {
        return serviceNames[12];
    }
    /**
     * 利用者負担(13列目)　単位数を取得します。
     * @return
     */
    private int get_1601071() {
        return serviceUnit[12];
    }
    /**
     * 利用者負担(13列目)　回数を取得します。
     * @return
     */
    private int get_1601072() {
        return serviceCount[12];
    }
    /**
     * 利用者負担(13列目)　利用者負担額を取得します。
     * @return
     */
    private int get_1601073() {
        return serviceClaim[12];
    }
    /**
     * 利用者負担(14列目)　サービス名を取得します。
     * @return
     */
    private String get_1601074() {
        return serviceNames[13];
    }
    /**
     * 利用者負担(14列目)　単位数を取得します。
     * @return
     */
    private int get_1601075() {
        return serviceUnit[13];
    }
    /**
     * 利用者負担(14列目)　回数を取得します。
     * @return
     */
    private int get_1601076() {
        return serviceCount[13];
    }
    /**
     * 利用者負担(14列目)　利用者負担額を取得します。
     * @return
     */
    private int get_1601077() {
        return serviceClaim[13];
    }
    /**
     * 利用者負担(15列目)　サービス名を取得します。
     * @return
     */
    private String get_1601078() {
        return serviceNames[14];
    }
    /**
     * 利用者負担(15列目)　単位数を取得します。
     * @return
     */
    private int get_1601079() {
        return serviceUnit[14];
    }
    /**
     * 利用者負担(15列目)　回数を取得します。
     * @return
     */
    private int get_1601080() {
        return serviceCount[14];
    }
    /**
     * 利用者負担(15列目)　利用者負担額を取得します。
     * @return
     */
    private int get_1601081() {
        return serviceClaim[14];
    }
    /**
     * 利用者負担(16列目)　サービス名を取得します。
     * @return
     */
    private String get_1601082() {
        return serviceNames[15];
    }
    /**
     * 利用者負担(16列目)　単位数を取得します。
     * @return
     */
    private int get_1601083() {
        return serviceUnit[15];
    }
    /**
     * 利用者負担(16列目)　回数を取得します。
     * @return
     */
    private int get_1601084() {
        return serviceCount[15];
    }
    /**
     * 利用者負担(16列目)　利用者負担額を取得します。
     * @return
     */
    private int get_1601085() {
        return serviceClaim[15];
    }
    /**
     * 利用者負担(17列目)　サービス名を取得します。
     * @return
     */
    private String get_1601086() {
        return serviceNames[16];
    }
    /**
     * 利用者負担(17列目)　単位数を取得します。
     * @return
     */
    private int get_1601087() {
        return serviceUnit[16];
    }
    /**
     * 利用者負担(17列目)　回数を取得します。
     * @return
     */
    private int get_1601088() {
        return serviceCount[16];
    }
    /**
     * 利用者負担(17列目)　利用者負担額を取得します。
     * @return
     */
    private int get_1601089() {
        return serviceClaim[16];
    }
    /**
     * 利用者負担(18列目)　サービス名を取得します。
     * @return
     */
    private String get_1601090() {
        return serviceNames[17];
    }
    /**
     * 利用者負担(18列目)　単位数を取得します。
     * @return
     */
    private int get_1601091() {
        return serviceUnit[17];
    }
    /**
     * 利用者負担(18列目)　回数を取得します。
     * @return
     */
    private int get_1601092() {
        return serviceCount[17];
    }
    /**
     * 利用者負担(18列目)　利用者負担額を取得します。
     * @return
     */
    private int get_1601093() {
        return serviceClaim[17];
    }
    /**
     * 利用者負担(19列目)　サービス名を取得します。
     * @return
     */
    private String get_1601094() {
        return serviceNames[18];
    }
    /**
     * 利用者負担(19列目)　単位数を取得します。
     * @return
     */
    private int get_1601095() {
        return serviceUnit[18];
    }
    /**
     * 利用者負担(19列目)　回数を取得します。
     * @return
     */
    private int get_1601096() {
        return serviceCount[18];
    }
    /**
     * 利用者負担(19列目)　利用者負担額を取得します。
     * @return
     */
    private int get_1601097() {
        return serviceClaim[18];
    }
    
    /**
     * 
     * @param claimList 請求情報
     * @param manager データマネージャ
     * @throws Exception
     */
    public void parse(VRList claimList,QP001Manager manager) throws Exception {
        
    	//明細情報レコード退避
    	VRMap detailsMap = new VRHashMap();
        // 集計情報レコード退避用
        Map typeMap = new TreeMap();
        // 特定入所者介護サービス費用情報レコード
        VRList nursingList = new VRArrayList();
        // 社会福祉法人軽減額情報レコード
        VRList reductionList = new VRArrayList();
        // 公費情報
        VRMap kohiMap = new VRHashMap();
        
        //ソート処理を追加
        QP001P02_10Event sorter = new QP001P02_10Event();
        Collections.sort(claimList, sorter.new RecordComparator());
        
        for(int i = 0; i < claimList.size(); i++){
            VRMap claim = (VRMap)claimList.get(i);
            
            //キーの存在チェック
            if(!claim.containsKey("CATEGORY_NO")){
            	continue;
            }
            
            
            switch(ACCastUtilities.toInt(claim.get("CATEGORY_NO"),0)){
            //基本情報レコード
            case 2:
                String[] kohiType = new String[3];
                //基本情報レコードを取得し、公費順位を退避する。
                if(!ACTextUtilities.isNullText(VRBindPathParser.get("201058",claim))){
                    kohiType[0] = String.valueOf(VRBindPathParser.get("201058",claim));
                }
                if(!ACTextUtilities.isNullText(VRBindPathParser.get("201059",claim))){
                    kohiType[1] = String.valueOf(VRBindPathParser.get("201059",claim));
                }
                if(!ACTextUtilities.isNullText(VRBindPathParser.get("201060",claim))){
                    kohiType[2] = String.valueOf(VRBindPathParser.get("201060",claim));
                }
                
                //交換情報識別番号をキーにハッシュマップに退避
                kohiMap.put(String.valueOf(VRBindPathParser.get("201001",claim)),kohiType);
                
                //対象月を設定する。
                if(ACTextUtilities.isNullText(getTargetDate())){
                    setTargetDate(ACCastUtilities.toDate(String.valueOf(VRBindPathParser.get("201003",claim)) + "01",null));
                }
                
                //[H20.5 法改正対応] fujihara add start
                unitCalc.parseBase(claim);
                //[H20.5 法改正対応] fujihara add end
                
                break;
                
            //[H20.5 法改正対応] fujihara add start
            //特定診療費情報レコード
            case 5:
                //特定診療費情報レコード順次番号が99の場合のみ有効
                if ("99".equals(ACCastUtilities.toString(claim.get("501007"),""))){
                    unitCalc.parseRecuperation(claim);
                }
                break;
            //[H20.5 法改正対応] fujihara add end
                
            //明細情報レコード
            case 3:
            	/*
            	 * サービス種類コード+サービス項目コード+'-'+サービス単位数＋'-'+摘要欄（用具対応）
            	 * 上記文字列をキーとしてTreeMapに挿入する。
            	 * 作成したTreeMapをdetailsMapにサービス種類コードをキーとして登録する。
            	 * 
            	 * detailsMap -+- "11" - TreeMap <- サービス種類コード11のデータの集まり
            	 *             |
            	 *             +- "12" - TreeMap <- サービス種類コード12のデータの集まり
            	 *             |
            	*/
            	
            	
            	StringBuilder detailsKey = new StringBuilder();
            	String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("301007",claim));
            	
            	detailsKey.append(serviceCodeKind);
            	detailsKey.append(ACCastUtilities.toString(VRBindPathParser.get("301008",claim)));
            	detailsKey.append("-");
            	detailsKey.append(ACCastUtilities.toString(VRBindPathParser.get("301014",claim)));
            	detailsKey.append("-");
            	detailsKey.append(ACCastUtilities.toString(VRBindPathParser.get("301018",claim)));
            	
            	Map detailsTmp = null;
            	if (detailsMap.containsKey(serviceCodeKind)){
            		detailsTmp = (Map)detailsMap.get(serviceCodeKind);
            	} else {
            		detailsTmp = new TreeMap();
            		detailsMap.put(serviceCodeKind, detailsTmp);
            	}
            	
            	detailsTmp.put(detailsKey.toString(), claim);
            	break;
                
            // [H27.4法改正対応][Shinobu Hitaka] 2015/04/08 add start
            //明細情報（住所地特例）レコード
            case 18:
            	/*
            	 * サービス種類コード+サービス項目コード+'-'+サービス単位数＋'-'+摘要欄（用具対応）
            	 * 上記文字列をキーとしてTreeMapに挿入する。
            	 * 作成したTreeMapをdetailsMapにサービス種類コードをキーとして登録する。
            	 * 
            	 * detailsMap -+- "11" - TreeMap <- サービス種類コード11のデータの集まり
            	 *             |
            	 *             +- "12" - TreeMap <- サービス種類コード12のデータの集まり
            	 *             |
            	*/
            	
            	
            	StringBuilder detailsKeyJT = new StringBuilder();
            	String serviceCodeKindJT = ACCastUtilities.toString(VRBindPathParser.get("1801007",claim));
            	
            	detailsKeyJT.append(serviceCodeKindJT);
            	detailsKeyJT.append(ACCastUtilities.toString(VRBindPathParser.get("1801008",claim)));
            	detailsKeyJT.append("-");
            	detailsKeyJT.append(ACCastUtilities.toString(VRBindPathParser.get("1801014",claim)));
            	detailsKeyJT.append("-");
            	detailsKeyJT.append(ACCastUtilities.toString(VRBindPathParser.get("1801018",claim)));
            	
            	Map detailsTmpJT = null;
            	if (detailsMap.containsKey(serviceCodeKindJT)){
            		detailsTmpJT = (Map)detailsMap.get(serviceCodeKindJT);
            	} else {
            		detailsTmpJT = new TreeMap();
            		detailsMap.put(serviceCodeKindJT, detailsTmpJT);
            	}
            	
            	detailsTmpJT.put(detailsKeyJT.toString(), claim);
            	break;
            // [H27.4法改正対応][Shinobu Hitaka] 2015/04/08 add end
                
            //集計情報レコード
            case 7:
            	typeMap.put(claim.get("701007"), claim);
                break;
                
            //特定入所者介護サービス費用情報レコード
            case 8:
                nursingList.add(claim);
                break;
                
            //社会福祉法人軽減額情報レコード
            case 9:
                reductionList.add(claim);
                break;
            }

        }
        
        //集計情報レコードの集計を行う
        Iterator it = typeMap.keySet().iterator();
        while (it.hasNext()){
        	VRMap map = (VRMap)typeMap.get(it.next());
        	parseType(map,(String[])kohiMap.get(String.valueOf(VRBindPathParser.get("701001",map))),manager,detailsMap);
        }
        //特定入所者介護サービス費用情報レコードの集計を行う。
        for(int i = 0; i < nursingList.size(); i++){
            VRMap map = (VRMap)nursingList.get(i);
            parseNursing(map,(String[])kohiMap.get(String.valueOf(VRBindPathParser.get("801001",map))),manager);
        }
        //社会福祉法人軽減額情報レコード
        for(int i = 0; i < reductionList.size(); i++){
            VRMap map = (VRMap)reductionList.get(i);
            parseReduction(map);
        }
    }
    
    
    /**
     * 集計情報レコードの集計を実行する。
     * @param claim
     * @param kohiType
     * @throws Exception
     */
    private void parseType(VRMap claim, String[] kohiType,QP001Manager manager,VRMap detailsMap) throws Exception {
        
    	// [2014年要望][Shinobu Hitaka] 2015/04/15 edit begin 利用者負担額0円も印刷可能にする
        //利用者負担額が0円以外の場合、帳票に出力する。
    	//if(ACCastUtilities.toInt(claim.get("701017"),0) != 0){
        if((zeroPrint == 0 && ACCastUtilities.toInt(claim.get("701017"),0) != 0) || (zeroPrint != 0)){
        // [2014年要望][Shinobu Hitaka] 2015/04/15 edit end
        	
            //サービス種類コード
            String serviceCodeKind = String.valueOf(claim.get("701007"));
            //サービス名称
            String serviceName = manager.getServiceName(serviceCodeKind);
            
            //明細情報レコードより、該当サービス種類コードの詳細を取得
            Map details = (Map)detailsMap.get(serviceCodeKind);
            
            // [H27.4法改正対応][Shinobu Hitaka] 2015/04/08 edit begin
            //Iterator it = details.keySet().iterator();
            //while(it.hasNext()){
            //	VRMap map = (VRMap)details.get(it.next());
            //	//集計情報レコードに関連する明細情報を出力する
            //	setServiceData((String)map.get("301019"), 0, map);
            //}
            //
            //利用者負担0円印字の場合はサービス名先頭に*を付加する
            if (zeroPrint != 0){
            	serviceName = "*" + serviceName;
            }
            //明細情報を念のためnull判定する
            if(details != null){
	            Iterator it = details.keySet().iterator();
	            while(it.hasNext()){
	            	VRMap map = (VRMap)details.get(it.next());
	            	if ((String)map.get("301019") != null) {
		            	//集計情報レコードに関連する明細情報を出力する
		            	setServiceData((String)map.get("301019"), 0, map);
	            	} else {
		            	//集計情報レコードに関連する明細情報（住所地特例）を出力する
	            		setServiceData((String)map.get("1801020"), 0, map);
	            	}
	            }
            }
            // [H27.4法改正対応][Shinobu Hitaka] 2015/04/08 edit end
            
            setServiceData(serviceName,ACCastUtilities.toInt(claim.get("701017"),0),claim);
        }
        
        //出来高医療費利用者負担額が0円以外の場合、帳票に出力する。
        if(ACCastUtilities.toInt(claim.get("701029"),0) != 0){
        	String styleNo = String.valueOf(claim.get("701001"));
        	
        	//様式第五、第五の二、第十であれば特定診療費
        	if("7164,7165,71A3".indexOf(styleNo) != -1){
        		setServiceData("特定診療費利用者負担",ACCastUtilities.toInt(claim.get("701029"),0),claim, false);
            //様式第四、第四の二、第九であれば緊急時施設療養
        	} else if("7153,7154,7193".indexOf(styleNo) != -1){
        		setServiceData("特定治療費利用者負担",ACCastUtilities.toInt(claim.get("701029"),0),claim, false);
        	}
            //[H20.5 法改正対応] fujihara add start
            //H20.5以降の様式第四、第四の二、第九である場合
        	//[ID:0000738][Shin Fujihara] 2012/05 edit begin 様式第九交換識別番号変更対応漏れ
            //else if ("7155,7156,7194".indexOf(styleNo) != -1){
        	else if ("7155,7156,7195".indexOf(styleNo) != -1){
        	//[ID:0000738][Shin Fujihara] 2012/05 edit end 様式第九交換識別番号変更対応漏れ
                int[] costs = unitCalc.getRecuperationCost(claim);
                //特定治療費の自己負担が存在する
                if (costs[0] != 0){
                    // 2008/05/27 [Masahiko Higuchi] edit - begin 利用者向け請求書（簡易版対応）
                    setServiceData("特定治療費利用者負担",costs[0],claim, false);
                    // 2008/05/27 [Masahiko Higuchi] edit - end
                }
                //特別療養費の自己負担が存在する
                if (costs[1] != 0){
                    // 2008/05/27 [Masahiko Higuchi] edit - begin 利用者向け請求書（簡易版対応）
                    setServiceData("特別療養費利用者負担",costs[1],claim, false);
                    // 2008/05/27 [Masahiko Higuchi] edit - end
                }
            }
            //[H20.5 法改正対応] fujihara add end
            // 2006.05.09 edit end
        }
        
        if(kohiType == null){
            return;
        }
        
        //公費自己負担金が0円以外の場合、帳票に出力する。
        for(int i = 0; i < kohiType.length; i++){
            
            int cost = 0;
            
            switch(i){
                //公費１
                case 0:
                    //公費１本人負担額
                    cost += ACCastUtilities.toInt(claim.get("701020"),0);
                    //(公費1分出来高医療費)出来高医療費本人負担額8桁
                    cost += ACCastUtilities.toInt(claim.get("701032"),0);
                    break;
                //公費２
                case 1:
                    //公費２本人負担
                    cost += ACCastUtilities.toInt(claim.get("701023"),0);
                    //(公費2分出来高医療費)出来高医療費本人負担額8桁
                    cost += ACCastUtilities.toInt(claim.get("701035"),0);
                    break;
                //公費３
                case 2:
                    //公費３本人負担
                    cost += ACCastUtilities.toInt(claim.get("701026"),0);
                    //(公費3分出来高医療費)出来高医療費本人負担額8桁
                    cost += ACCastUtilities.toInt(claim.get("701038"),0);
                    break;
            }
            
            //公費本人負担額が存在する場合
            if(cost != 0){
            	String kohiName = "特定診療費公費負担";
            	String styleNo = String.valueOf(claim.get("701001"));
                //様式第四、第四の二、第九であれば緊急時施設療養
            	if("7153,7154,7193".indexOf(styleNo) != -1){
            		kohiName = "特定治療費公費負担";
            	}
                //[H20.5 法改正対応] fujihara add start
                //ここの公費名称が使用されることは無い
            	//[ID:0000738][Shin Fujihara] 2012/05 edit begin 様式第九交換識別番号変更対応漏れ
                //else if("7155,7156,7194".indexOf(styleNo) != -1){
            	else if("7155,7156,7195".indexOf(styleNo) != -1){
                //[ID:0000738][Shin Fujihara] 2012/05 edit end 様式第九交換識別番号変更対応漏れ
                    kohiName = "特定治療・特別療養公費負担";
                }
                //[H20.5 法改正対応] fujihara add end
                //公費データが存在しない場合
                if(!ACTextUtilities.isNullText(kohiType[i])){
                    kohiName = manager.getKohiData(kohiType[i],"KOHI_NAME");
                }
                setKohiData(kohiName,cost);
            }
        }
    }
    
    /**
     * 集計情報レコードの集計を実行する。
     * @param claim
     * @param kohiType
     * @throws Exception
     */
    private void parseNursing(VRMap claim, String[] kohiType,QP001Manager manager) throws Exception {
        
        //利用者負担額が0円以外の場合、帳票に出力する。
        if(ACCastUtilities.toInt(claim.get("801021"),0) != 0){
            //サービス種類コード
        	setServiceData("食費・居住費",ACCastUtilities.toInt(claim.get("801021"),0),claim);
        }
        
        if(kohiType == null){
            return;
        }
        
        //公費自己負担金が0円以外の場合、帳票に出力する。
        for(int i = 0; i < kohiType.length; i++){
            
            int cost = 0;
            
            switch(i){
                //公費１
                case 0:
                    //公費１本人負担額
                    cost += ACCastUtilities.toInt(claim.get("801027"),0);
                    break;
                //公費２
                case 1:
                    cost += ACCastUtilities.toInt(claim.get("801030"),0);
                    break;
                //公費３
                case 2:
                    cost += ACCastUtilities.toInt(claim.get("801033"),0);
                    break;
            }
            
            //公費本人負担が存在する場合
            if(cost != 0){
                String kohiName = "";
                //公費データが存在しない場合
                if(!ACTextUtilities.isNullText(kohiType[i])){
                    kohiName = manager.getKohiData(kohiType[i],"KOHI_NAME");
                }
                setKohiData(kohiName,cost);
            }
        }
    }
    
    /**
     * 社福軽減を反映させる。
     * @param claim
     * @throws Exception
     */
    private void parseReduction(VRMap claim) throws Exception {
        //利用者負担額が0円以外の場合、帳票に出力する。
        if(ACCastUtilities.toInt(claim.get("901010"),0) != 0){
            setServiceData("社会福祉法人軽減",(ACCastUtilities.toInt(claim.get("901010"),0)) * -1,claim);
        }
    }
    
    
    /**
     * 利用者負担のサービス名称、単位、回数・日数、金額を設定する。
     * 
     * @param serviceName
     * @param cost
     * @param claim
     * 
     * @throws Exception
     */
    private void setServiceData(String serviceName, int cost,VRMap claim) throws Exception {
    	setServiceData(serviceName, cost, claim, true);
    }
    
    /**
     * 利用者負担のサービス名称と金額を設定する。
     * @param serviceName
     * @param cost
     * @param isPrint 単位数、回数・日数の印字をするかしないか。 True:表示する False:表示しない
     * 
     * @throws Exception
     */
    private void setServiceData(String serviceName, int cost,VRMap claim, boolean isPrint) throws Exception {
        boolean end = true;
        
        
        Integer categoryNo = ACCastUtilities.toInteger(VRBindPathParser.get("CATEGORY_NO", claim));
        int unit = 0;
        int count = 0;
        int etcTotal = 0;
        
        if (isPrint){
	        //明細情報レコードを表す分類の定数情報である場合
	        if (QkanConstants.CATEGORY_NO_RECORD_DETAILED.equals(categoryNo)){
	        	//単位数
	        	unit = ACCastUtilities.toInt(VRBindPathParser.get("301009",claim),0);
	        	//単位数0の場合は、サービス単位数を採用する
	        	if (unit == 0){
	        		unit = ACCastUtilities.toInt(VRBindPathParser.get("301014",claim),0);
	        	}
	        	//回数・日数
	        	count = ACCastUtilities.toInt(VRBindPathParser.get("301010",claim),0);
	        	
	        // [H27.4法改正対応][Shinobu Hitaka] 2015/04/08 add begin
	        //明細情報（住所地特例）レコードを表す分類の定数情報である場合
	        } else if (QkanConstants.CATEGORY_NO_RECORD_DETAILED_JUSHOTI_TOKUREI.equals(categoryNo)) {
	        	//単位数
	        	unit = ACCastUtilities.toInt(VRBindPathParser.get("1801009",claim),0);
	        	//単位数0の場合は、サービス単位数を採用する
	        	if (unit == 0){
	        		unit = ACCastUtilities.toInt(VRBindPathParser.get("1801014",claim),0);
	        	}
	        	//回数・日数
	        	count = ACCastUtilities.toInt(VRBindPathParser.get("1801010",claim),0);
	        // [H27.4法改正対応][Shinobu Hitaka] 2015/04/08 add end
	        	
	        //集計情報レコードを表す分類の定数情報である場合
	        } else if (QkanConstants.CATEGORY_NO_RECORD_TOTAL.equals(categoryNo)) {
	            // 保険単位数合計を採用
	    		unit = ACCastUtilities.toInt(VRBindPathParser.get("701014",claim),0);
	        	
	        	//サービス実日数を日数・回数として表示
	        	count = ACCastUtilities.toInt(VRBindPathParser.get("701008",claim),0);
	        	//その他用合算値
	        	etcTotal = ACCastUtilities.toInt(VRBindPathParser.get("701014",claim),0);
	            
	        //特定入所者介護サービス費用情報レコードを表す分類の情報定数である場合
	        } else if (QkanConstants.CATEGORY_NO_RECODE_SPECIAL_ENTER_SERVICE.equals(categoryNo)){
	            // 費用単価4桁
	            int hiyoTanka = ACCastUtilities.toInt(VRBindPathParser.get("801010",claim),0);
	            // 負担限度額4桁
	        	unit = ACCastUtilities.toInt(VRBindPathParser.get("801011",claim),0);
	            // 負担限度額が費用単価を上回る場合は費用単価を採用する
	            if(hiyoTanka < unit){
	                unit = hiyoTanka;
	            }
	        	count = ACCastUtilities.toInt(VRBindPathParser.get("801012",claim),0);
	        	//名称の変換処理
	        	serviceName = parseTokuteiServiceName(claim);
	        	//その他用単位数合算値
                etcTotal = unit;
	        }
        }
        
        for(int i = 0; i < serviceClaim.length; i++){
            // サービス名称及び負担額が同一の場合
            if((serviceNames[i] != null) && (serviceName.equals(serviceNames[i])) && serviceUnit[i] == unit){
                serviceClaim[i] += cost;
                serviceUnit[i] = unit;
                serviceCount[i] += count;
                end = false;
                break;                    
            }
            
            if(serviceNames[i] == null){
                serviceNames[i] = serviceName;
                serviceClaim[i] = cost;
                serviceUnit[i] = unit;
                serviceCount[i] = count;
                end = false;
                break;
            }
            
        }
        
        if(end){
            // 利用者負担額が０円の場合は明細情報が設定されているため
            // 単価は初期して再設定する。（明細書の単価＋集計情報の単価が合算される障害対応）
            if (serviceClaim[serviceClaim.length - 1] == 0) {
                serviceUnit[serviceClaim.length - 1] = 0;
            }
            serviceNames[serviceClaim.length - 1] = "その他";
            serviceClaim[serviceClaim.length - 1] += cost;
            serviceUnit[serviceClaim.length - 1] += etcTotal;
            serviceCount[serviceClaim.length - 1] = 1;
        }
    }
    
    /**
     * 特定施設入所者介護サービス費の名称を取得します。
     * @param claim
     * @return
     * @throws Exception
     */
    private String parseTokuteiServiceName(VRMap claim) throws Exception{
        String result = "";
        // 基準名称
        final String KYOJYUHI = "居住費";
        final String SYOKUHI = "食費";
        // 名称に変換して取得
        String detailName = ACCastUtilities.toString(VRBindPathParser.get("801034",claim),"");

        if("".equals(detailName)){
            // 空白の場合は暫定対応
            return "食費・居住費";
            
        }else{
            // 食費である場合
            if(detailName.indexOf(SYOKUHI) > 0){
                // 一律食費
                return SYOKUHI;
            }
            // 居住費である場合
            result = KYOJYUHI + "(" + detailName + ")";
        }
        // 値を戻す
        return result;
    }
    
    
    /**
     * 利用者負担の公費名称と金額を設定する。
     * @param kohiName
     * @param cost
     * @throws Exception
     */
    private void setKohiData(String kohiName, int cost) throws Exception {
        boolean end = true;
        for(int i = 0; i < kohiClaim.length; i++){
            if((kohiNames[i] != null) && (kohiName.equals(kohiNames[i]))){
                kohiClaim[i] += cost;
                end = false;
                break;
            }
            
            if(kohiClaim[i] == 0){
                kohiNames[i] = kohiName;
                kohiClaim[i] = cost;
                end = false;
                break;
            }
        }
        
        if(end){
            kohiNames[kohiClaim.length - 1] = "その他";
            kohiClaim[kohiClaim.length - 1] += cost;
        }
    }
    
    /**
     * 保持しているデータをマップに変換する。
     * @return
     * @throws Exception
     */
    public VRMap getRecord() throws Exception {
        VRMap result = new VRHashMap();
        
        setData(result, "TARGET_DATE", getTargetDate());
        
        setData(result, "1601001", get_1601001());
        setData(result, "1601002", get_1601002());
        setData(result, "1601003", get_1601003());
        setData(result, "1601004", get_1601004());
        setData(result, "1601005", get_1601005());
        setData(result, "1601006", get_1601006());
        setData(result, "1601007", get_1601007());
        setData(result, "1601008", get_1601008());
        setData(result, "1601009", get_1601009());
        
        setData(result, "1601010", get_1601010());
        setData(result, "1601011", get_1601011());
        setData(result, "1601012", get_1601012());
        setData(result, "1601013", get_1601013());
        setData(result, "1601014", get_1601014());
        setData(result, "1601015", get_1601015());
        setData(result, "1601016", get_1601016());
        setData(result, "1601017", get_1601017());
        setData(result, "1601018", get_1601018());
        setData(result, "1601019", get_1601019());
        
        setData(result, "1601020", get_1601020());
        setData(result, "1601021", get_1601021());
        setData(result, "1601022", get_1601022());
        setData(result, "1601023", get_1601023());
        setData(result, "1601024", get_1601024());
        setData(result, "1601027", get_1601027());
        setData(result, "1601028", get_1601028());
        setData(result, "1601029", get_1601029());
        
        setData(result, "1601030", get_1601030());
        setData(result, "1601031", get_1601031());
        setData(result, "1601032", get_1601032());
        setData(result, "1601033", get_1601033());
        setData(result, "1601034", get_1601034());
        setData(result, "1601035", get_1601035());
        setData(result, "1601036", get_1601036());
        setData(result, "1601037", get_1601037());
        setData(result, "1601038", get_1601038());
        setData(result, "1601039", get_1601039());
        
        setData(result, "1601040", get_1601040());
        setData(result, "1601041", get_1601041());
        setData(result, "1601042", get_1601042());
        setData(result, "1601043", get_1601043());
        setData(result, "1601044", get_1601044());
        setData(result, "1601045", get_1601045());
        setData(result, "1601046", get_1601046());
        setData(result, "1601047", get_1601047());
        setData(result, "1601048", get_1601048());
        setData(result, "1601049", get_1601049());
        
        setData(result, "1601050", get_1601050());
        setData(result, "1601051", get_1601051());
        setData(result, "1601052", get_1601052());
        setData(result, "1601053", get_1601053());
        setData(result, "1601054", get_1601054());
        setData(result, "1601055", get_1601055());
        setData(result, "1601056", get_1601056());
        setData(result, "1601057", get_1601057());

        setData(result, "1601062", get_1601062());
        setData(result, "1601063", get_1601063());
        setData(result, "1601064", get_1601064());
        setData(result, "1601065", get_1601065());
        setData(result, "1601066", get_1601066());
        setData(result, "1601067", get_1601067());
        setData(result, "1601068", get_1601068());
        setData(result, "1601069", get_1601069());
        
        setData(result, "1601070", get_1601070());
        setData(result, "1601071", get_1601071());
        setData(result, "1601072", get_1601072());
        setData(result, "1601073", get_1601073());
        setData(result, "1601074", get_1601074());
        setData(result, "1601075", get_1601075());
        setData(result, "1601076", get_1601076());
        setData(result, "1601077", get_1601077());
        setData(result, "1601078", get_1601078());
        setData(result, "1601079", get_1601079());
        
        setData(result, "1601080", get_1601080());
        setData(result, "1601081", get_1601081());
        setData(result, "1601082", get_1601082());
        setData(result, "1601083", get_1601083());
        setData(result, "1601084", get_1601084());
        setData(result, "1601085", get_1601085());
        setData(result, "1601086", get_1601086());
        setData(result, "1601087", get_1601087());
        setData(result, "1601088", get_1601088());
        setData(result, "1601089", get_1601089());
        
        setData(result, "1601090", get_1601090());
        setData(result, "1601091", get_1601091());
        setData(result, "1601092", get_1601092());
        setData(result, "1601093", get_1601093());
        setData(result, "1601094", get_1601094());
        setData(result, "1601095", get_1601095());
        setData(result, "1601096", get_1601096());
        setData(result, "1601097", get_1601097());

        return result;
    }

    /**
     * 利用者向け請求書における利用者負担額(全額自己負担分を除く)を取得する
     */
    public int getClaimTotal(){
    	int result = 0;
    	
    	//介護請求本人負担分
    	result += get_1601002();
    	result += get_1601004();
    	result += get_1601006();
    	result += get_1601008();
    	result += get_1601010();
    	result += get_1601012();
    	result += get_1601014();
    	result += get_1601016();
    	result += get_1601018();
    	result += get_1601020();
    	result += get_1601065();
    	result += get_1601069();
    	result += get_1601073();
    	result += get_1601077();
    	result += get_1601081();
    	result += get_1601085();
    	result += get_1601089();
    	result += get_1601093();
    	result += get_1601097();
    	//公費自己負担分
    	result += get_1601022();
    	result += get_1601024();
    	
    	return result;
    }
    
}
