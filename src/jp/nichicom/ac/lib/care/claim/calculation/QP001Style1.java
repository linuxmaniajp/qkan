
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
 * プログラム 様式第一 (QP001Style1)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * 様式第一　一帳票分の情報
 * @author shin fujihara
 *
 */
public class QP001Style1{
	

    //居宅サービス・施設サービス
    private QP001RecordCareSupplyClaim insurance1 = new QP001RecordCareSupplyClaim();
    //居宅介護支援
    private QP001RecordCareSupplyClaim insurance2 = new QP001RecordCareSupplyClaim();
    
    //公費請求
    //生保居宅サービス・施設サービス
    private QP001RecordCareSupplyClaim publicExpense12_1 = new QP001RecordCareSupplyClaim();
    //生保居宅介護支援
    private QP001RecordCareSupplyClaim publicExpense12_2 = new QP001RecordCareSupplyClaim();
    //結核34条
    private QP001RecordCareSupplyClaim publicExpense10 = new QP001RecordCareSupplyClaim();
    //結核35条
    private QP001RecordCareSupplyClaim publicExpense11 = new QP001RecordCareSupplyClaim();
    //精神32条
    private QP001RecordCareSupplyClaim publicExpense21 = new QP001RecordCareSupplyClaim();
    //身障・更生
    private QP001RecordCareSupplyClaim publicExpense15 = new QP001RecordCareSupplyClaim();
    //原爆・一般
    private QP001RecordCareSupplyClaim publicExpense19 = new QP001RecordCareSupplyClaim();
    //特定疾患等治療研究
    private QP001RecordCareSupplyClaim publicExpense51 = new QP001RecordCareSupplyClaim();
    //障害者・支援措置
    private QP001RecordCareSupplyClaim publicExpense57 = new QP001RecordCareSupplyClaim();
    //被爆者助成
    private QP001RecordCareSupplyClaim publicExpense81 = new QP001RecordCareSupplyClaim();
    //被爆体験者
    private QP001RecordCareSupplyClaim publicExpense86 = new QP001RecordCareSupplyClaim();
    //有機ヒ素・緊急
    private QP001RecordCareSupplyClaim publicExpense87 = new QP001RecordCareSupplyClaim();
    //水俣病総合対策メチル水銀
    private QP001RecordCareSupplyClaim publicExpense88 = new QP001RecordCareSupplyClaim();
    //特対(全額免除)
    private QP001RecordCareSupplyClaim publicExpense58 = new QP001RecordCareSupplyClaim();
    //石綿
    private QP001RecordCareSupplyClaim publicExpense66 = new QP001RecordCareSupplyClaim();
    //中国残留法人等
    private QP001RecordCareSupplyClaim publicExpense25 = new QP001RecordCareSupplyClaim();
    
    private QP001Manager manager = null;
    
    /**
     * コンストラクタ
     */
    public QP001Style1(QP001Manager manager){
        this.manager = manager;
    }
    
    /**
     * サービス提供日付を取得し、オブジェクトのシリアルとして返却する。
     * @param claimList
     * @return
     * @throws Exception
     */
    public static String getSerialId(VRList claimList) throws Exception {
        
        String result = "";
        
        lbl:for(int i = 0; i < claimList.size(); i++){
            VRMap map = (VRMap)claimList.get(i);
            //キーの存在チェック
            if(!map.containsKey("CATEGORY_NO")){
                continue;
            }
            
            switch(ACCastUtilities.toInt(map.get("CATEGORY_NO"),0)){
            //基本情報レコード
            case 2:
                //サービス提供年月6桁(YYYYMM)
                result = String.valueOf(map.get("201003"));
                break lbl;
                
            //集計情報レコード
            case 7:
                //サービス提供年月6桁(YYYYMM)
                result = String.valueOf(map.get("701003"));
                break lbl;
                
            //特定入所者介護サービス費用情報レコード
            case 8:
                //サービス提供年月6桁(YYYYMM)
                result = String.valueOf(map.get("801003"));
                break lbl;
                
            //介護給付費請求明細書(居宅サービス計画費)情報レコード
            case 10:
                //サービス提供年月6桁(YYYYMM)
                result = String.valueOf(map.get("1001004"));
                break lbl;
                
            default:
                break;
            }
        }
        return result;
    }
    
	
	/**
	 * データの解析を実行する。
	 * @param claimList
	 * @throws Exception
	 */
    public void parse(VRList claimList) throws Exception {
		
        VRMap kohiMap = new VRHashMap();
        VRList typeList = new VRArrayList();
        VRList nursingList = new VRArrayList();
        
        for(int i = 0; i < claimList.size(); i++){
            VRMap map = (VRMap)claimList.get(i);
            
            //キーの存在チェック
            if(!map.containsKey("CATEGORY_NO")){
                continue;
            }
            
            switch(ACCastUtilities.toInt(map.get("CATEGORY_NO"),0)){
            //基本情報レコード
            case 2:
                //保険請求
                //居宅・施設サービス／介護予防サービス／地域密着型サービス等サービス費用
                //生保単独以外の場合のみ計上する。
                if(!QP001SpecialCase.isSeihoOnly(String.valueOf(map.get("201006")))){
                    insurance1.parse(map,1,"00","01");
                }
                String[] kohi = new String[3];
                //公費の情報を退避
                if(!kohiMap.containsKey(map.get("201001"))){
                    kohi[0] = ACCastUtilities.toString((map.get("201058")));
                    kohi[1] = ACCastUtilities.toString((map.get("201059")));
                    kohi[2] = ACCastUtilities.toString((map.get("201060")));
                    kohiMap.put(map.get("201001"),kohi);
                }
                
                ///////公費の集計を個別ではなく様式の合算で行うよう変更
                //公費１のタイプが設定されている場合
                if(!ACTextUtilities.isNullText(kohi[0])){
                    //データの設定を行う。
                    setKohiRecord(map,kohi[0],0);
                }
                
                //公費２のタイプが設定されている場合
                if(!ACTextUtilities.isNullText(kohi[1])){
                    //データの設定を行う。
                    setKohiRecord(map,kohi[1],1);
                }
                
                //公費３のタイプが設定されている場合
                if(!ACTextUtilities.isNullText(kohi[2])){
                    //データの設定を行う。
                    setKohiRecord(map,kohi[2],2);
                }
                
                break;
                
            //集計情報レコード
            case 7:
                typeList.add(map);
                break;
                
            //特定入所者介護サービス費用情報レコード
            case 8:
                if(String.valueOf(map.get("801007")).equals("99")){
                    nursingList.add(map);
                }
                break;
                
            //介護給付費請求明細書(居宅サービス計画費)情報レコード
            case 10:
                //居宅介護支援・介護予防支援サービス費用
                //公費の適用が無い場合
                if(ACTextUtilities.isNullText(map.get("1001019"))){
                    insurance2.parseStyle7(map,1,"00","02");
                    
                //公費の適用がある場合
                } else {
                    setKohiRecord(map,String.valueOf(map.get("1001019")),0);
                }
                break;
                
            default:
                break;
            }            
        }
        
        //集計情報
        for(int i = 0; i < typeList.size(); i++){
            VRMap map = (VRMap)typeList.get(i);
            //緊急時特定診療費等の加算を行う。
            //生保単独以外の場合のみ計上する。
            if(!QP001SpecialCase.isSeihoOnly(String.valueOf(map.get("701006")))){
                insurance1.parseCategory7(map);
            }
            
            if(kohiMap.containsKey(map.get("701001"))){
                String kohi[] = (String[])kohiMap.get(map.get("701001"));
                //公費請求のチェック
                //公費１のタイプが設定されている場合
                if(!ACTextUtilities.isNullText(kohi[0])){
                    //データの設定を行う。
                    setKohiRecordCategory7(map,kohi[0],0);
                }
                
                //公費２のタイプが設定されている場合
                if(!ACTextUtilities.isNullText(kohi[1])){
                    //データの設定を行う。
                    setKohiRecordCategory7(map,kohi[1],1);
                }
                
                //公費３のタイプが設定されている場合
                if(!ACTextUtilities.isNullText(kohi[2])){
                    //データの設定を行う。
                    setKohiRecordCategory7(map,kohi[2],2);
                }
            }
            
        }
        
        
        //特定入所者介護
        for(int i = 0; i < nursingList.size(); i++){
            VRMap map = (VRMap)nursingList.get(i);
            
            //ID:0000198
            //保険請求額が0の場合は計上しない
            if(ACCastUtilities.toInt(map.get("801023"),0) != 0){
            	insurance1.parseCategory8(map,1,"00","01");
            }
            
            if(kohiMap.containsKey(map.get("801001"))){
                
                //様式８，９，１０でないと公費の適用は行われない。
                if(!QP001SpecialCase.isShisetsuDiscriminationNo(String.valueOf(map.get("801001")))){
                    continue;
                }
                
                String kohi[] = (String[])kohiMap.get(map.get("801001"));
                //公費請求のチェック
                //公費１のタイプが設定されている場合
                if(!ACTextUtilities.isNullText(kohi[0])){
                	//ID:0000188
                	//公費請求額が0の場合は計上しない。
                	if(ACCastUtilities.toInt(map.get("801026"),0) != 0){
                        //データの設定を行う。
                        setKohiRecord(map,kohi[0],0);
                	}
                }
                
                //公費２のタイプが設定されている場合
                if(!ACTextUtilities.isNullText(kohi[1])){
                	//ID:0000188
                	if(ACCastUtilities.toInt(map.get("801029"),0) != 0){
                        //データの設定を行う。
                        setKohiRecord(map,kohi[1],1);
                	}
                }
                
                //公費３のタイプが設定されている場合
                if(!ACTextUtilities.isNullText(kohi[2])){
                	if(ACCastUtilities.toInt(map.get("801032"),0) != 0){
                        //データの設定を行う。
                        setKohiRecord(map,kohi[2],2);
                	}
                }
                
            }
        }
        
	}
    
    /**
     * 公費のデータを設定する。
     * @param map
     * @param kohiType
     * @throws Exception
     */
    private void setKohiRecord(VRMap map,String kohiType,int kohiPosition) throws Exception {
        //公費の法別番号で分岐する。
        switch(ACCastUtilities.toInt(manager.getKohiData(kohiType,"KOHI_LAW_NO"),0)){
            //結核34条
            case 10:
                publicExpense10.parseKohi(map,2,"10","00",kohiPosition);
                break;
                
            //結核35条
            case 11:
                publicExpense11.parseKohi(map,2,"11","00",kohiPosition);
                break;
                
            //生保
            case 12:
                //居宅・施設と居宅介護支援で分岐
                switch(ACCastUtilities.toInt(map.get("CLAIM_STYLE_TYPE"),0)){
                //様式第七の場合
                case QkanConstants.CLAIM_STYLE_FORMAT_7:
                case QkanConstants.CLAIM_STYLE_FORMAT_7_2:
                    publicExpense12_2.parseKohi(map,2,"12","02",kohiPosition);
                    break;
                //様式第七以外の場合
                default:
                    publicExpense12_1.parseKohi(map,2,"12","01",kohiPosition);
                    break;
                    
                }
                break;
                
            //身障・更生
            case 15:
                publicExpense15.parseKohi(map,2,"15","00",kohiPosition);
                break;
                
            //原爆・一般
            case 19:
                publicExpense19.parseKohi(map,2,"19","00",kohiPosition);
                break;
                
            //精神32条
            case 21:
                publicExpense21.parseKohi(map,2,"21","00",kohiPosition);
                break;
                
            //特定疾患等治療研究費
            case 51:
                publicExpense51.parseKohi(map,2,"51","00",kohiPosition);
                break;
                
            //障害者・支援措置
            case 57:
                publicExpense57.parseKohi(map,2,"57","00",kohiPosition);
                break;
                
            //特対(全額免除)
            case 58:
                publicExpense58.parseKohi(map,2,"58","00",kohiPosition);
                break;
                
            //石綿
            case 66:
                publicExpense66.parseKohi(map,2,"66","00",kohiPosition);
                break;
                
            //被爆者助成
            case 81:
                publicExpense81.parseKohi(map,2,"81","00",kohiPosition);
                break;
                
            //被爆体験者
            case 86:
                publicExpense86.parseKohi(map,2,"86","00",kohiPosition);
                break;
                
            //有機ヒ素・緊急措置
            case 87:
                publicExpense87.parseKohi(map,2,"87","00",kohiPosition);
                break;
                
            //水俣病総合対策
            case 88:
                publicExpense88.parseKohi(map,2,"88","00",kohiPosition);
                break;
            
            //[H20.4 法改正対応] fujihara start
            //中国残留邦人等
            case 25:
            	publicExpense25.parseKohi(map, 2, "25", "00", kohiPosition);
                break;
            //[H20.4 法改正対応] fujihara add end
        }
    }
    
    /**
     * 公費のデータを設定する。
     * @param map
     * @param kohiType
     * @throws Exception
     */
    private void setKohiRecordCategory7(VRMap map,String kohiType,int kohiPosition) throws Exception {
        //公費の法別番号で分岐する。
        switch(ACCastUtilities.toInt(manager.getKohiData(kohiType,"KOHI_LAW_NO"),0)){
            //結核34条
            case 10:
                publicExpense10.parseCategory7(map);
                break;
                
            //結核35条
            case 11:
                publicExpense11.parseCategory7(map);
                break;
                
            //生保
            case 12:
                //居宅・施設と居宅介護支援で分岐
                switch(ACCastUtilities.toInt(map.get("CLAIM_STYLE_TYPE"),0)){
                //様式第七の場合
                case QkanConstants.CLAIM_STYLE_FORMAT_7:
                case QkanConstants.CLAIM_STYLE_FORMAT_7_2:
                    publicExpense12_2.parseCategory7(map);
                    break;
                //様式第七以外の場合
                default:
                    publicExpense12_1.parseCategory7(map);
                    break;
                    
                }
                break;
                
            //身障・更生
            case 15:
                publicExpense15.parseCategory7(map);
                break;
                
            //原爆・一般
            case 19:
                publicExpense19.parseCategory7(map);
                break;
                
            //精神32条
            case 21:
                publicExpense21.parseCategory7(map);
                break;
                
            //特定疾患等治療研究費
            case 51:
                publicExpense51.parseCategory7(map);
                break;
                
            //障害者・支援措置
            case 57:
                publicExpense57.parseCategory7(map);
                break;
                
            //特対(全額免除)
            case 58:
                publicExpense58.parseCategory7(map);
                break;
                
            //石綿
            case 66:
                publicExpense66.parseCategory7(map);
                break;
                
            //被爆者助成
            case 81:
                publicExpense81.parseCategory7(map);
                break;
                
            //被爆体験者
            case 86:
                publicExpense86.parseCategory7(map);
                break;
                
            //有機ヒ素・緊急措置
            case 87:
                publicExpense87.parseCategory7(map);
                break;
                
            //水俣病総合対策
            case 88:
                publicExpense88.parseCategory7(map);
                break;
                
            //[H20.4 法改正対応] fujihara start
            //中国残留邦人等
            case 25:
            	publicExpense25.parseCategory7(map);
            	break;
            //[H20.4 法改正対応] fujihara add end
            
        }
    }
	
	/**
	 * データの確定を行う。
	 */
	protected void commitRecords(QP001PatientState patientState) throws Exception {
		//
	}
	
	/**
	 * DB登録用のレコード集合を作成します。
	 * @param patient_id
	 * @param targetDate
	 * @return
	 * @throws Exception
	 */
    public VRList getRecords() throws Exception {
		VRList list = new VRArrayList();
        
        //居宅サービス・施設サービス
        if(!insurance1.isNew()){
            list.add(insurance1.getRecord());
        }
        
        //居宅介護支援
        if(!insurance2.isNew()){
            list.add(insurance2.getRecord());
        }
        
        //公費請求
        //※公費の法別番号順に出力する。
        //結核34条
        if(!publicExpense10.isNew()){
            list.add(publicExpense10.getRecord());
        }
        //結核35条
        if(!publicExpense11.isNew()){
            list.add(publicExpense11.getRecord());
        }
        
        //生保居宅サービス・施設サービス
        if(!publicExpense12_1.isNew()){
            list.add(publicExpense12_1.getRecord());
        }
        
        //生保居宅介護支援
        if(!publicExpense12_2.isNew()){
            list.add(publicExpense12_2.getRecord());
        }
        //身障・更生
        if(!publicExpense15.isNew()){
            list.add(publicExpense15.getRecord());
        }
        
        //原爆・一般
        if(!publicExpense19.isNew()){
            list.add(publicExpense19.getRecord());
        }
        
        //精神32条
        if(!publicExpense21.isNew()){
            list.add(publicExpense21.getRecord());
        }
        
        //特定疾患等治療研究
        if(!publicExpense51.isNew()){
            list.add(publicExpense51.getRecord());
        }
        
        //障害者・支援措置
        if(!publicExpense57.isNew()){
            list.add(publicExpense57.getRecord());
        }
        
        //特対(全額免除)
        if(!publicExpense58.isNew()){
            list.add(publicExpense58.getRecord());
        }
        //石綿
        if(!publicExpense66.isNew()){
            list.add(publicExpense66.getRecord());
        }
        //被爆者助成
        if(!publicExpense81.isNew()){
            list.add(publicExpense81.getRecord());
        }
        
        //被爆体験者
        if(!publicExpense86.isNew()){
            list.add(publicExpense86.getRecord());
        }
        
        //有機ヒ素・緊急
        if(!publicExpense87.isNew()){
            list.add(publicExpense87.getRecord());
        }
        
        //水俣病総合対策メチル水銀
        if(!publicExpense88.isNew()){
            list.add(publicExpense88.getRecord());
        }
		
        //[H20.4 法改正対応] fujihara start
        //中国残留邦人等
        if(!publicExpense25.isNew()){
            list.add(publicExpense25.getRecord());
        }
        //[H20.4 法改正対応] fujihara end
        
		return list;
	}
	

}
