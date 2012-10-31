
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
 * 作成日: 2006/01/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 利用者向け請求レコード (QP001RecordAbstract)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public class QP001RecordUserClaim extends QP001RecordAbstract {

    // 利用者負担　サービス名
    private String[] serviceNames = new String[10];
    // 利用者負担　利用者負担額
    private int[] serviceClaim = new int[10];    
    // 公費本人負担　公費名称
    // 2008/01/21 [Masahiko Higuchi] edit - begin 利用者向け請求書_簡易版対応
    private String[] kohiNames = new String[2];
    // 2008/01/21 [Masahiko Higuchi] edit - end
    // 公費本人負担　本人負担額
    // 2008/01/21 [Masahiko Higuchi] edit - begin 利用者向け請求書_簡易版対応
    // 配列のサイズに問題があるため修正
    private int[] kohiClaim = new int[2];
    // 2008/01/21 [Masahiko Higuchi] edit - end
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
    
    // 2008/02/06 [Masahiko Higuchi] add - begin Ver 5.4.1 利用者向け請求書対応
    private int[] serviceUnit = new int[10];
    private int[] serviceCount = new int[10];
    // 2008/02/06 [Masahiko Higuchi] add - end
    
    protected String getSerialId() {
        // TODO 自動生成されたメソッド・スタブ
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
    
    // 2007/11/09 [Masahiko Higuchi] del - begin Ver 5.4.1 利用者向け請求書対応
    /*
    /**
     * 公費本人負担(3列目)　公費名称を取得する。
     * @return
     */
    /*
    private String get_1601025() {
        return kohiNames[2];
    }*/
    /*
    /**
     * 公費本人負担(3列目)　本人負担額を取得する。
     * @return
     */
    /*
    private int get_1601026() {
        return kohiClaim[2];
    }
    */
    // 2007/11/09 [Masahiko Higuchi] del - end
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
    
    
    // 2007/11/09 [Masahiko Higuchi] add - begin Ver 5.4.1 利用者向け請求書対応
    //
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
    // 2007/11/09 [Masahiko Higuchi] add - end
    
    public void parse(VRList claimList,QP001Manager manager) throws Exception {
        
        // 集計情報レコード退避用
        VRList typeList = new VRArrayList();
        // 特定入所者介護サービス費用情報レコード
        VRList nursingList = new VRArrayList();
        // 社会福祉法人軽減額情報レコード
        VRList reductionList = new VRArrayList();
        // 公費情報
        VRMap kohiMap = new VRHashMap();
        
        //add start 2008.6.5 fujihara.shin
        //サービスコード順に明細を出力するよう、ソート処理を追加
        QP001P02_10Event sorter = new QP001P02_10Event();
        Collections.sort(claimList, sorter.new RecordComparator());
        //add end 2008.6.5 fujihara.shin
        
        for(int i = 0; i < claimList.size(); i++){
            VRMap claim = (VRMap)claimList.get(i);
            
            //キーの存在チェック
            //if(claim.containsKey("CATEGORY_NO") && (String.valueOf(claim.get("CATEGORY_NO")).equals("2"))){
            if(claim.containsKey("CATEGORY_NO")){
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
                    
                //集計情報レコード
                case 7:
                    typeList.add(claim);
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
        }
        //集計情報レコードの集計を行う
        for(int i = 0; i < typeList.size(); i++){
            //parseType(,kohiType,manager);
            VRMap map = (VRMap)typeList.get(i);
            parseType(map,(String[])kohiMap.get(String.valueOf(VRBindPathParser.get("701001",map))),manager);
        }
        //特定入所者介護サービス費用情報レコードの集計を行う。
        for(int i = 0; i < nursingList.size(); i++){
            //parseNursing((VRMap)nursingList.get(i),kohiType,manager);
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
    private void parseType(VRMap claim, String[] kohiType,QP001Manager manager) throws Exception {
        
        //利用者負担額が0円以外の場合、帳票に出力する。
        if(ACCastUtilities.toInt(claim.get("701017"),0) != 0){
            //サービス種類コード
            String serviceCodeKind = String.valueOf(claim.get("701007"));
            //サービス名称
            String serviceName = manager.getServiceName(serviceCodeKind);
            // [Masahiko Higuchi] edit - begin 利用者向け請求書（簡易版対応）
            //edit start 2008.6.5 fujihara.shin
            //setServiceData(serviceName,ACCastUtilities.toInt(claim.get("701017"),0),claim);
            //単位数を表示するよう修正
            //※最もコードの修正量が少なくなる方法を選択
            setServiceData(serviceName,ACCastUtilities.toInt(claim.get("701017"),0),claim);
            //edit end 2008.6.5 fujihara.shin
            // [Masahiko Higuchi] edit - end
        }
        
        //出来高医療費利用者負担額が0円以外の場合、帳票に出力する。
        if(ACCastUtilities.toInt(claim.get("701029"),0) != 0){
        	// 2006.05.09 edit sta shin.fujihara
        	// 表示する名称を変更
            //setServiceData("医療費利用者負担",ACCastUtilities.toInt(claim.get("701029"),0));
        	String styleNo = String.valueOf(claim.get("701001"));
        	
        	//様式第五、第五の二、第十であれば特定診療費
        	if("7164,7165,71A3".indexOf(styleNo) != -1){
                // [Masahiko Higuchi] edit - begin 利用者向け請求書（簡易版対応）
        		setServiceData("特定診療費利用者負担",ACCastUtilities.toInt(claim.get("701029"),0),claim, false);
                // [Masahiko Higuchi] edit - end
            //様式第四、第四の二、第九であれば緊急時施設療養
        	} else if("7153,7154,7193".indexOf(styleNo) != -1){
                // [Masahiko Higuchi] edit - begin 利用者向け請求書（簡易版対応）
        		setServiceData("特定治療費利用者負担",ACCastUtilities.toInt(claim.get("701029"),0),claim, false);
                // [Masahiko Higuchi] edit - end
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
            	// 2006.05.09 edit sta shin.fujihara
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
                // 2006.05.09 edit end
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
        	//edit sta 2006.05.16 shin.fujihara 文言修整
            //setServiceData("特定入所者利用者負担",ACCastUtilities.toInt(claim.get("801021"),0));
            // [Masahiko Higuchi] edit - begin 利用者向け請求書（簡易版対応）
        	setServiceData("食費・居住費",ACCastUtilities.toInt(claim.get("801021"),0),claim);
        	// [Masahiko Higuchi] edit - end
            //edit end 2006.05.16 shin.fujihara
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
        	// [Masahiko Higuchi] edit - begin 利用者向け請求書（簡易版対応）
            setServiceData("社会福祉法人軽減",(ACCastUtilities.toInt(claim.get("901010"),0)) * -1,claim, false);
            // [Masahiko Higuchi] edit - end
        }
    }
    
    
    /**
     * 利用者負担のサービス名称と金額を設定する。
     * @param serviceName 設定するサービス名称
     * @param cost 利用者負担額
     * @param claim 請求レコードデータ
     * 
     * @throws Exception
     */
    private void setServiceData(String serviceName, int cost,VRMap claim) throws Exception {
    	setServiceData(serviceName, cost, claim, true);
    }
    
    /**
     * 利用者負担のサービス名称と金額を設定する。
     * @param serviceName 設定するサービス名称
     * @param cost 利用者負担額
     * @param claim 請求レコードデータ
     * @param isPrint 単位数、回数・日数の印字をするかしないか。 True:表示する False:表示しない
     * @throws Exception
     */
    private void setServiceData(String serviceName, int cost,VRMap claim, boolean isPrint) throws Exception {
        boolean end = true;
        int unit = 0;
        // [Masahiko Higuchi] add - begin 利用者向け請求書（簡易版対応）
        Integer categoryNo = ACCastUtilities.toInteger(VRBindPathParser.get("CATEGORY_NO", claim));
        int count = 0;
        int etcTotal = 0;
        
        if (isPrint) {
	        //集計情報レコードを表す分類の定数情報である場合
	        if (QkanConstants.CATEGORY_NO_RECORD_TOTAL.equals(categoryNo)) {
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
	        	//その他用合算値
	        	etcTotal = ACCastUtilities.toInt(VRBindPathParser.get("801016",claim),0);
	        }
        }
        // [Masahiko Higuchi] add - end
        
        for(int i = 0; i < serviceClaim.length; i++){
            // [Masahiko Higuchi] edit - begin 利用者向け請求書（簡易版対応）
            // サービス名称及び負担額が同一の場合
            if((serviceNames[i] != null) && (serviceName.equals(serviceNames[i])) && serviceUnit[i] == unit){
                serviceClaim[i] += cost;
                serviceCount[i] += count;
                end = false;
                break;                    
            }
            
            if (serviceNames[i] == null) {
                serviceNames[i] = serviceName;
                serviceClaim[i] = cost;
                serviceUnit[i] = unit;
                serviceCount[i] = count;
                end = false;
                break;
            }
            
        }
        
        if(end){
            serviceNames[serviceClaim.length - 1] = "その他";
            serviceClaim[serviceClaim.length - 1] += cost;
            // [Masahiko Higuchi] add - begin 利用者向け請求書（簡易版対応）
            serviceUnit[serviceClaim.length - 1] += etcTotal;
            serviceCount[serviceClaim.length - 1] = 1;
            // [Masahiko Higuchi] add - end
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
        // 2008/02/06 [Masahiko Higuchi] del - begin Ver 5.4.1 利用者向け請求書対応
        //setData(result, "1601025", get_1601025());
        //setData(result, "1601026", get_1601026());
        // 2008/02/06 [Masahiko Higuchi] del - end
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
        
        setData(result, "TARGET_DATE", getTargetDate());
        
        // 2007/11/09 [Masahiko Higuchi] add - begin Ver 5.4.1 利用者向け請求書対応
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
        //setData(result, "1601062", get_1601062());
        //setData(result, "1601063", get_1601063());
        // 2007/11/09 [Masahiko Higuchi] add - end
        
        return result;
    }
    
    //[利用者向け請求書・領収書　詳細版対応] fujihara add start
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
    	
    	//公費自己負担分
    	result += get_1601022();
    	result += get_1601024();
    	
    	return result;
    }
    //[利用者向け請求書・領収書　詳細版対応] fujihara add end

}

//[H20.5 法改正対応] fujihara add start
class RecuperationUnitCalc{
	
	Map unitsStack = new VRHashMap();
	
	/**
	 * 保険給付率
	 */
	private int _201029 = 0;
	/**
	 * 公費１給付率
	 */
	private int _201030 = 0;
	/**
	 * 公費２給付率
	 */
	private int _201031 = 0;
	/**
	 * 公費３給付率
	 */
	private int _201032 = 0;
	
	/**
	 * 合計単位数
	 */
	private int _501013 = 0;
	/**
	 * 公費１合計単位数
	 */
	private int _501016 = 0;
	/**
	 * 公費２合計単位数
	 */
	private int _501019 = 0;
	/**
	 * 公費３合計単位数
	 */
	private int _501022 = 0;
	
	/**
	 * 基本情報レコード解析
	 */
	public void parseBase(Map claim){
		//交換識別番号から対象オブジェクトを取得
		RecuperationUnitCalc calc = getTargetUnit(ACCastUtilities.toString(claim.get("201001"),""));
		
		calc._201029 = ACCastUtilities.toInt(claim.get("201029"),0);
		
		calc._201030 = ACCastUtilities.toInt(claim.get("201030"),0);
		calc._201031 = ACCastUtilities.toInt(claim.get("201031"),0);
		calc._201032 = ACCastUtilities.toInt(claim.get("201032"),0);
	}
	
	/**
	 * 特別療養費解析
	 * @param claim
	 */
	public void parseRecuperation(Map claim){
		//交換識別番号から対象オブジェクトを取得
		RecuperationUnitCalc calc = getTargetUnit(ACCastUtilities.toString(claim.get("501001"),""));
		
		calc._501013 = ACCastUtilities.toInt(claim.get("501013"),0);
		
		calc._501016 = ACCastUtilities.toInt(claim.get("501016"),0);
		calc._501019 = ACCastUtilities.toInt(claim.get("501019"),0);
		calc._501022 = ACCastUtilities.toInt(claim.get("501022"),0);
	}
	
	/**
	 * 特別療養費の自己負担額を算定する
	 * @param claim
	 * @return
	 */
	public int[] getRecuperationCost(Map claim){
		//交換識別番号から対象オブジェクトを取得
		RecuperationUnitCalc calc = getTargetUnit(ACCastUtilities.toString(claim.get("701001"),""));
		
		//保険分単位数単位*単位数単価(10)*(100-給付率)/100
		//int recuperationCost = (calc._501013 * 10 * (100 - calc._201029)) / 100;
		
		//請求総額
		int totalCost = calc._501013 * 10;
		//保険請求額
		int insuranceCost = (int)Math.floor( (double)(calc._501013 * 10 * calc._201029) / 100d);
		//担保した給付率
        int amendsRate = calc._201029;
        //公費請求額
        int kohiCost = 0;
        
        //公費1の適用があるか確認
        if(calc._201030 != 0){
        	//月途中公費を疑う
        	if (calc._501013 == calc._501016) {
	            //公費１給付率が100の場合
	            if(calc._201030 == 100){
	                //高額医療合計金額-保険請求額を設定する。
	            	kohiCost = totalCost - insuranceCost;
	            } else {
	            	kohiCost += (int)Math.floor(totalCost * (calc._201030 - calc._201029) / 100);                
	            }
	            
	        //月途中公費の場合
        	} else {
        		kohiCost += (int)Math.floor(calc._501016 * 10 * (calc._201030 - amendsRate) / 100);
        		amendsRate = calc._201030;
        	}
        }
        //公費の対象となる自己負担額が残っているか確認
        if(totalCost >= (insuranceCost + kohiCost)){
            //公費2の適用があるか確認
            if(calc._201031 != 0){
            	//月途中を疑う
            	if (calc._501013 == calc._501019) {
	                //公費２の給付率が100の場合
	                if(calc._201031 == 100){
	                	kohiCost = totalCost - insuranceCost;
	                } else {
	                	kohiCost += (int)Math.floor(totalCost * (calc._201031 - calc._201030) / 100);
	                }
	                
	            //月途中の場合
            	} else {
            		kohiCost += (int)Math.floor(calc._501019 * 10 * (calc._201031 - amendsRate) / 100);
            		amendsRate = calc._201031;
            	}
            }
        }
        //公費の対象となる自己負担が残っているか確認
		if(totalCost >= (insuranceCost + kohiCost)){
            if(calc._201032 != 0){
            	//月途中を疑う
            	if (calc._501013 == calc._501022) {
	                if(calc._201032 == 100){
	                	kohiCost = totalCost - insuranceCost;
	                } else {
	                	kohiCost += (int)Math.floor(totalCost * (calc._201032 - calc._201031) / 100);
	                }
            	} else {
            		kohiCost += (int)Math.floor(calc._501022 * 10 * (calc._201032 - amendsRate) / 100);
            	}
            }
        }
		
		//特別療養費利用者負担額
		int recuperationCost = totalCost - insuranceCost - kohiCost;
		
		//緊急時治療は合算から特別療養費を引いたもの
		int treatmentCost = ACCastUtilities.toInt(claim.get("701029"),0) - recuperationCost; 
		
		return new int[]{treatmentCost,recuperationCost}; 
	}
	
	private RecuperationUnitCalc getTargetUnit(String no) {
		RecuperationUnitCalc calc = null;
		
		if (unitsStack.containsKey(no)){
			calc = (RecuperationUnitCalc)unitsStack.get(no);
		} else {
			calc = new RecuperationUnitCalc();
			unitsStack.put(no, calc);
		}
		return calc;
	}
	
	
}
//[H20.5 法改正対応] fujihara add end