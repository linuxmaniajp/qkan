
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKAACHO（JMA care benefit management software）
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
 * 作成日: 2005/12/06  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 実績確定/請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム CSVファイル作成モジュール (QP001CSVCreator)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

/**
 * 利用者一覧（請求）(QP001CSVCreator) CSVファイル作成クラス
 * ※対象月ごとにCSVファイルを作成する。
 * @version 2.1
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanSystemInformation;
import jp.or.med.orca.qkan.affair.QkanMessageList;

public class QP001CSVCreator {
    
    private DecimalFormat continuousnessFormat = new DecimalFormat("00");
    private DecimalFormat insureNoFormat = new DecimalFormat("00000000");
    private ACDateFormat csvFileNameFormat = new ACDateFormat("eeMM");
    
    //データ種別
    //様式第一から第十 711
    //様式第十一 821
    //様式第七 812
    private String dataType = "";
    
    //区切り文字
    private final String spliter = "\",\"";
    /**
     * デフォルトコンストラクタ
     *
     */
    public QP001CSVCreator(){
    }
    
    
    public String create(ACDBManager dbm, String affair,VRList patientData, Date claimDate, VRMap settings,Date claimTargetDate,QP001Manager manager) throws Exception {
        
        //データ種別を確定する。
        //給付管理票
        if("02".equals(affair)){
            dataType = "821";
        //様式第七
        } else if("03".equals(affair)){
            dataType = "812";
        //様式第二から第十
        } else if("04".equals(affair)){
            dataType = "711";
        //様式第一
        } else if("08".equals(affair)){
            dataType = "711";
        }
        
        
        // 請求情報退避用の VRArrayList claim_temp を生成する。
        TreeMap claimSorter = new TreeMap();
        List style11 = new ArrayList();
        
//        //介護給付費請求書印刷用
//        TreeMap style1Sorter = new TreeMap();
        
        VRMap map = null;
        VRList claim = null;
        String serviceDate = "";
        
        List claimListTemp = null;
        QP001Style1 style1 = null;
        
        //[ID:0000443][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        QP001ErrorControl errorControl = new QP001ErrorControl();
        //[ID:0000443][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
        
        //patientDataの件数分ループする。
        for(int i = 0; i < patientData.size(); i++){
            map = (VRMap)patientData.get(i);
            // 画面の「利用者一覧(infoTable)」に表示している利用者の「選択(列(infoTableColumn3)」のチェックがついている場合。
            if (!"TRUE".equalsIgnoreCase(ACCastUtilities
                    .toString(VRBindPathParser.get("CHOISE", map)))){
                continue;
            }
            
            //patientDataの KEY : PATIENT_ID の VALUE を取得する(利用者ID)。
            int patient_id = ACCastUtilities.toInt(map.get("PATIENT_ID"));
            // 様式番号を取得する。
            int claimStyleType = ACCastUtilities.toInt(VRBindPathParser.get("CLAIM_STYLE_TYPE", map),0);
            
            // 請求詳細情報を取得し、VRArrayList claimList に格納する。
            StringBuilder sb = new StringBuilder();
            Date rowClaimDate =  ACCastUtilities.toDate(map.get("CLAIM_DATE"));
            sb.append(" AND(CLAIM.CLAIM_DATE = '" + VRDateParser.format(rowClaimDate,"yyyy/MM/dd") + "')");
            sb.append(" AND(CLAIM.TARGET_DATE = '" + VRDateParser.format(ACCastUtilities.toDate(map.get("TARGET_DATE")),"yyyy/MM/dd") + "')");
            // 利用者IDを指定しているならば特定の利用者のみ。未指定ならば全利用者を対象とする。
            sb.append(" AND(CLAIM.PATIENT_ID = " + patient_id + ")");
            // 保険者番号、被保険者番号の検索条件を追加する。
            sb.append(" AND(CLAIM.INSURER_ID = '" + VRBindPathParser.get("INSURER_ID",map) + "')");
            sb.append(" AND(CLAIM.INSURED_ID = '" + VRBindPathParser.get("INSURED_ID",map) + "')");
            sb.append(" AND(CLAIM.PROVIDER_ID = '" + QkanSystemInformation.getInstance().getLoginProviderID() + "')");
            
            if (!"08".equals(affair)) {
                sb.append(" AND(CLAIM.CLAIM_STYLE_TYPE = " + claimStyleType + ")");
            }
            
            claim = QkanCommon.getClaimDetailCustom(dbm, rowClaimDate, sb.toString());
            
            if((claim == null) || (claim.size() == 0)){
                continue;
            }
            
            try{
                serviceDate = String.valueOf(
                        VRDateParser.format(
                        ACCastUtilities.toDate(
                                ((VRMap)claim.get(0)).get("TARGET_DATE")),"yyyyMM"));
            } catch (Exception e){
                VRLogger.warning("対象日の取得に失敗:" + claim);
                continue;
            }

            
            //affairの値によって分岐する。
            //「02」の場合 ※利用者一覧（給付管理票）
            if("02".equals(affair)){
                String kubun = ACCastUtilities.toString(map.get("KUBUN"),"");
                if(kubun == null){
                    kubun = ""; 
                }
                String kubunCode = "1";
                if("新規".equals(kubun)){
                    kubunCode = "1";
                } else if("修正".equals(kubun)){
                    kubunCode = "2";
                } else if("取消".equals(kubun)){
                    kubunCode = "3";
                }
                
                //[ID:0000443][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
                if (!errorControl.isValidBenefitManagement(claim, map)){
                	continue;
                }
                //[ID:0000443][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
                
                //claimより様式第十一の情報(識別レコードの値が8211)を取得し、clime_tempに設定する。
                setTargetRecord(claim,style11,QP001SpecialCase.getBenefitManagementCodes() ,kubunCode,claimTargetDate);

            //「08」の場合 ※利用者一覧（在宅サービス提供事業所請求）
            } else if("08".equals(affair)){
                // claimより様式第二の情報(識別レコードの値が7131)を取得し、clime_tempに設定する。
                // claimより様式第三の情報(識別レコードの値が7143)を取得し、clime_tempに設定する。
                // claimより様式第四の情報(識別レコードの値が7153)を取得し、clime_tempに設定する。
                // claimより様式第五の情報(識別レコードの値が7164)を取得し、clime_tempに設定する。
                // claimより様式第六の情報(識別レコードの値が7171)を取得し、clime_tempに設定する。
                // claimより様式第七の情報(識別レコードの値が8122)を取得し、clime_tempに設定する。
                // claimより様式第七の情報(識別レコードの値が8123)を取得し、clime_tempに設定する。
                // claimより様式第八の情報(識別レコードの値が7183)を取得し、clime_tempに設定する。
                // claimより様式第九の情報(識別レコードの値が7193)を取得し、clime_tempに設定する。
                // claimより様式第十の情報(識別レコードの値が71A3)を取得し、clime_tempに設定する。
                
                CSVData data = null;
                //既に登録がある場合
                if(claimSorter.containsKey(serviceDate)){
                    data = (CSVData)claimSorter.get(serviceDate);
                } else {
                    data = new CSVData(manager);
                    claimSorter.put(serviceDate,data);
                }
                claimListTemp = data.getCSVList();
                style1 = data.getTotalObject();
                
                setTargetRecord(claim,claimListTemp, QP001SpecialCase.getPerformanceCodes());
                style1.parse(claim);
                
            }
        }

        //給付管理票の場合は１ファイル
        if("02".equals(affair)){
        	//[ID:0000443][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        	errorControl.showBenefitManagementError();
        	if (errorControl.isAllError()){
        		return null;
        	}
        	//[ID:0000443][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
            Collections.sort(style11,new StringComparator());
            return makeCSV(style11,claimDate, settings,claimTargetDate);
        }
        List claim_temp_list = null;
        Iterator it = claimSorter.keySet().iterator();
        String result = "";
        while(it.hasNext()){
            claim_temp_list = new ArrayList();
            String key = String.valueOf(it.next());
            CSVData data = (CSVData)claimSorter.get(key);
            setTargetRecord(data.getTotalObject().getRecords(),claim_temp_list,"7111");
            claim_temp_list.addAll(data.getCSVList());
            
            Collections.sort(claim_temp_list,new StringComparator());
            
            if(!ACTextUtilities.isNullText(result)){
                result += "\n　　　　　　　　";
            }
            
            // 2006/08/28 add begin kamitsukasa
            // 訪問看護療養費領収書対応
            String temp = makeCSV(claim_temp_list,claimDate, settings,claimTargetDate);
            if(temp == null){
                return null;
            }
            result += temp;
            // 2006/08/28 add end kamitsukasa
//            result += makeCSV(claim_temp_list,claimDate, settings,claimTargetDate);
            
            //いらなくなったデータを捨てる。
            claimSorter.put(key,null);
            Runtime.getRuntime().gc();
        }
        
        // CSVファイルを作成する。
        return result;
        
        
    }

    /**
     * 引数に指定された識別番号に該当するレコードである場合、
     * テンポラリリストに格納する。
     * @param claim
     * @param claim_temp
     * @param code
     * @throws Exception
     */
    private void setTargetRecord(VRList claim,List claimList,String code) throws Exception {
        setTargetRecord(claim,claimList,code,"",null);
    }
    
    /**
     * 引数に指定された識別番号に該当するレコードである場合、
     * テンポラリリストに格納する。
     * @param claim
     * @param claimCSVList
     * @param code
     * @throws Exception
     */
    private void setTargetRecord(VRList claim,List claimCSVList,String code, String kubunCode,Date targetDate) throws Exception {
        VRMap map = null;
        //比較対象のコード
        String compCode = "";
        //ソート用のキー
        StringBuilder sortkey = new StringBuilder();
        String csvData = "";
        
        for(int i = 0; i < claim.size(); i++){
            sortkey = new StringBuilder();
            map = (VRMap)claim.get(i);
            csvData = "";
            //CATEGORY_NO
            //介護給付費請求書
            if(map.containsKey("101001")){
                compCode = ACCastUtilities.toString(map.get("101001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("101005")) + "-" + getSortKey(map.get("101006"));
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("101002"));
                sortkey.append("-");
                //交換情報識別番号4桁(7111固定)
                sortkey.append(map.get("101001"));
                sortkey.append("-");

                //事業所番号10桁
                sortkey.append(map.get("101003"));
                sortkey.append("-");
                //保険・公費等区分コード1桁　1-保険請求 2-公費請求
                sortkey.append(map.get("101004"));
                sortkey.append("-");
                //法別番号2桁※保険請求分の場合は0
                sortkey.append(map.get("101005"));
                sortkey.append("-");
                //請求情報区分コード2桁　法別番号=0 OR 12→01-居宅・施設サービス　02-居宅介護支援　法別番号=それ以外→0固定
                sortkey.append(map.get("101006"));
                
                //CSV出力用のデータを生成
                csvData = makeCareSupplyClaim(map);
                
            //基本情報レコード
            } else if(map.containsKey("201001")){
                compCode = ACCastUtilities.toString(map.get("201001"));
                
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("201003"));
                sortkey.append("-");
                //交換情報識別番号4桁
                sortkey.append(map.get("201001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("201005"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("201006"));
                sortkey.append("-");                

                //レコード種別コード2桁(01を設定)
                sortkey.append(map.get("201002"));
                sortkey.append("-");
                //事業所番号10桁
                sortkey.append(map.get("201004"));
                
                //CSV出力用のデータを生成
                csvData = makeBaseRecord(map);
                
            //明細情報レコード
            } else if(map.containsKey("301001")){
                compCode = ACCastUtilities.toString(map.get("301001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("301007")) + "-" + getSortKey(map.get("301008"));
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("301003"));
                sortkey.append("-");
                //交換情報識別番号4桁
                sortkey.append(map.get("301001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("301005"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("301006"));
                sortkey.append("-");
                
                //レコード種別コード2桁(02を設定)
                sortkey.append(map.get("301002"));
                sortkey.append("-");
                //事業所番号10桁
                sortkey.append(map.get("301004"));
                sortkey.append("-");
                //サービス種類コード2桁
                sortkey.append(map.get("301007"));
                sortkey.append("-");
                //サービス項目コード4桁
                sortkey.append(map.get("301008"));
                
                //福祉用具対応
                sortkey.append("-");
                sortkey.append(map.get("301009"));
                sortkey.append("-");
                sortkey.append(map.get("301018"));
                
                //CSV出力用のデータを生成
                csvData = makeDetailRecord(map);
                
            //緊急時施設療養情報レコード
            } else if(map.containsKey("401001")){
                //空レコード対応
                if(ACTextUtilities.isNullText(map.get("401001"))){
                    continue;
                }
                
                //add sta 2006.05.20 fujihara.shin
                if(!QP001SpecialCase.isValidRecordEmergency(map)){
                	continue;
                }
                //add end 2006.05.20 fujihara.shin
                
                compCode = ACCastUtilities.toString(map.get("401001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("401007"));
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("401003"));
                sortkey.append("-");
                //交換情報識別番号4桁
                sortkey.append(map.get("401001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("401005"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("401006"));
                sortkey.append("-");
                
                //レコード種別コード2桁(03を設定)
                sortkey.append(map.get("401002"));
                sortkey.append("-");
                //事業所番号10桁
                sortkey.append(map.get("401004"));
                sortkey.append("-");
                //緊急時施設療養情報レコード順次番号2桁
                sortkey.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("401007"),0)));

                //CSV出力用のデータを生成
                csvData = makeEmergencyRecord(map);
                
            //特定診療費情報レコード
            } else if(map.containsKey("501001")){
                compCode = ACCastUtilities.toString(map.get("501001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("501007"));
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("501003"));
                sortkey.append("-");
                //交換情報識別番号4桁
                sortkey.append(map.get("501001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("501005"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("501006"));
                sortkey.append("-");
                
                //レコード種別コード2桁(04を設定)
                sortkey.append(map.get("501002"));
                sortkey.append("-");
                //事業所番号10桁
                sortkey.append(map.get("501004"));
                sortkey.append("-");
                //特定診療費情報レコード順次番号2桁
                sortkey.append(continuousnessFormat.format(ACCastUtilities.toInt(map.get("501007"),0)));
                
                //CSV出力用のデータを生成
                csvData = makeDiagnosisRecord(map);
                
                
            //食費(未使用)
            } else if(map.containsKey("601001")){
                compCode = ACCastUtilities.toString(map.get("601001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO"));
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("601003"));
                sortkey.append("-");
                //交換情報識別番号4桁
                sortkey.append(map.get("601001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("601005"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("601006"));
                sortkey.append("-");
                
                //レコード種別コード2桁(05を設定)
                sortkey.append(map.get("601002"));
                sortkey.append("-");
                //事業所番号10桁
                sortkey.append(map.get("601004"));
                
                //CSV出力用のデータを生成
                csvData = "";
                
                
            //集計情報レコード
            } else if(map.containsKey("701001")){
                compCode = ACCastUtilities.toString(map.get("701001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("701007"));
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("701003"));
                sortkey.append("-");
                //交換情報識別番号4桁
                sortkey.append(map.get("701001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("701005"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("701006"));
                sortkey.append("-");
                
                //レコード種別コード2桁(10を設定)
                sortkey.append(map.get("701002"));
                sortkey.append("-");
                //事業所番号10桁
                sortkey.append(map.get("701004"));
                sortkey.append("-");
                //サービス種類コード2桁
                sortkey.append(map.get("701007"));
                
                //CSV出力用のデータを生成
                csvData = makeTypeRecord(map);
                
            //特定入所者介護サービス費用情報レコード
            } else if(map.containsKey("801001")){
                //2006.04.28 全額利用者負担対応
                //レコード順次番号が0のレコードは表示しない。
                if(ACCastUtilities.toInt(map.get("801007"),0) == 0){
                    continue;
                }
                
                compCode = ACCastUtilities.toString(map.get("801001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("801007"));
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("801003"));
                sortkey.append("-");
                //交換情報識別番号4桁
                sortkey.append(map.get("801001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("801005"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("801006"));
                sortkey.append("-");
                
                //レコード種別コード2桁(11を設定)
                sortkey.append(map.get("801002"));
                sortkey.append("-");
                //事業所番号10桁
                sortkey.append(map.get("801004"));
                sortkey.append("-");
                //特定入所者介護サービス費用情報レコード順次番号2桁
                sortkey.append(continuousnessFormat.format(ACCastUtilities.toInt(map.get("801007"),0)));
                sortkey.append("-");
                //サービス種類コード2桁
                sortkey.append(map.get("801008"));
                sortkey.append("-");
                //サービス項目コード4桁
                sortkey.append(map.get("801009"));
                
                //CSV出力用のデータを生成
                csvData = makeNursingRecord(map);
                
            //社会福祉減免
            } else if(map.containsKey("901001")){
                compCode = ACCastUtilities.toString(map.get("901001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("901008"));
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("901003"));
                sortkey.append("-");
                //交換情報識別番号4桁
                sortkey.append(map.get("901001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("901005"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("901006"));
                sortkey.append("-");
                
                //レコード種別コード2桁(12を設定)
                sortkey.append(map.get("901002"));
                sortkey.append("-");
                //事業所番号10桁
                sortkey.append(map.get("901004"));
                sortkey.append("-");
                //サービス種類コード2桁
                sortkey.append(map.get("901008"));
                
                //CSV出力用のデータを生成
                csvData = makeReductionRecord(map);
                
            //居宅サービス計画費情報レコード
            } else if(map.containsKey("1001001")){
                compCode = ACCastUtilities.toString(map.get("1001001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("1001007"));
                
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("1001004"));
                sortkey.append("-");
                //交換情報識別番号4桁(平成18年4月以前8121固定　平成18年4月以降8122、もしくは8123)
                sortkey.append(map.get("1001001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("1001005"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("1001007"));
                sortkey.append("-");
                
                //事業所番号10桁
                sortkey.append(map.get("1001002"));
                sortkey.append("-");
                //指定/基準該当等事業所区分コード1桁　1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 5-地域密着型サービス
                sortkey.append(map.get("1001003"));
                sortkey.append("-");
                
                //[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
                if ("8124,8125".indexOf(compCode) != -1) {
                	sortkey.append(continuousnessFormat.format(ACCastUtilities.toInt(map.get("1001024"),0)));
                    sortkey.append("-");
                }
                //[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
                
                //単位数単価4桁
                sortkey.append(map.get("1001006"));
                sortkey.append("-");
                //公費負担者番号8桁
                sortkey.append(map.get("1001008"));
                sortkey.append("-");
                //公費受給者番号7桁
                sortkey.append(map.get("1001009"));
                
                //CSV出力用のデータを生成
                csvData = makeCarePlanCSV(map);
                
            //未使用
            } else if(map.containsKey("1101001")){
                compCode = ACCastUtilities.toString(map.get("1101001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO"));
                //提出年月6桁(YYYYMM)
                sortkey.append(map.get("1101002"));
                sortkey.append("-");
                //交換情報識別番号4桁(8211固定)
                sortkey.append(map.get("1101001"));
                sortkey.append("-");
                
                //保険者番号8桁
                sortkey.append(map.get("1101003"));
                sortkey.append("-");
                //事業所番号10桁(居宅介護支援事業所)
                sortkey.append(map.get("1101004"));
                sortkey.append("-");
                //居宅サービス計画作成区分コード1桁　1-居宅介護支援事業所作成 2-自己作成
                sortkey.append(map.get("1101005"));
                
                //CSV出力用のデータを生成
                csvData = "";
                
            //給付管理票
            } else if(map.containsKey("1201001")){
            	// add sta 2006.5.11 shin.fujihara
            	if(targetDate == null){
            		continue;
            	}
            	// add end 2006.5.11
            	
                compCode = ACCastUtilities.toString(map.get("1201001"));
                //sortkey = getSortKey(map.get("CATEGORY_NO")) + "-" + getSortKey(map.get("1201008"));
                //対象年月6桁(YYYYMM)
                sortkey.append(map.get("1201002"));
                sortkey.append("-");
                //給付管理票情報作成区分コードを追加する。
                map.put("1201005",kubunCode);
                //交換情報識別番号4桁(平成18年4月以前8221固定　平成18年4月以降8222固定)
                sortkey.append(map.get("1201001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("1201003"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("1201009"));
                sortkey.append("-");
                
                //事業所番号10桁(居宅介護支援事業所、もしくは介護予防支援事業所)
                sortkey.append(map.get("1201004"));
                sortkey.append("-");
                //給付管理票情報作成区分コード1桁　1-新規 2-修正 3-取消
                sortkey.append(map.get("1201005"));
                sortkey.append("-");
                //給付管理票作成年月日8桁(YYYYMMDD)
                sortkey.append(map.get("1201006"));
                sortkey.append("-");
                //給付管理票種別区分コード1桁　1-訪問通所サービス給付管理票 2-短期入所サービス給付管理票 3-居宅サービス区分給付管理票
                sortkey.append(map.get("1201007"));
                sortkey.append("-");
                //給付管理票明細行番号2桁
                sortkey.append(map.get("1201008"));
                
                //CSV出力用のデータを生成
                csvData = makeSupplyManagementCSV(map,targetDate);
                
            //緊急時施設療養・自施設療養費情報レコード
            } else if(map.containsKey("1701001")){
                //空レコード対応
                if(ACTextUtilities.isNullText(map.get("1701001"))){
                    continue;
                }
                
                if(!QP001SpecialCase.isValidRecordEmergencyOwnFacility(map)){
                    continue;
                }
                
                compCode = ACCastUtilities.toString(map.get("1701001"));
                //サービス提供年月6桁(YYYYMM)
                sortkey.append(map.get("1701003"));
                sortkey.append("-");
                //交換情報識別番号4桁
                sortkey.append(map.get("1701001"));
                sortkey.append("-");
                //証記載保険者番号8桁
                sortkey.append(map.get("1701005"));
                sortkey.append("-");
                //被保険者番号10桁
                sortkey.append(map.get("1701006"));
                sortkey.append("-");
                
                //レコード種別コード2桁(03を設定)
                sortkey.append(map.get("1701002"));
                sortkey.append("-");
                //事業所番号10桁
                sortkey.append(map.get("1701004"));
                sortkey.append("-");
                //緊急時施設療養情報レコード順次番号2桁
                sortkey.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("1701007"),0)));

                //CSV出力用のデータを生成
                csvData = makeEmergencyOwnFacilityRecord(map);
                
            }
 // 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
            //明細情報（住所地特例）レコード
	          else if(map.containsKey("1801001")){
	            compCode = ACCastUtilities.toString(map.get("1801001"));
	            
	            //サービス提供年月6桁(YYYYMM)
	            sortkey.append(map.get("1801003"));
	            sortkey.append("-");
	            //交換情報識別番号4桁
	            sortkey.append(map.get("1801001"));
	            sortkey.append("-");
	            //証記載保険者番号8桁
	            sortkey.append(map.get("1801005"));
	            sortkey.append("-");
	            //被保険者番号10桁
	            sortkey.append(map.get("1801006"));
	            sortkey.append("-");
	            
	            //レコード種別コード2桁(14を設定)
	            sortkey.append(map.get("1801002"));
	            sortkey.append("-");
	            //事業所番号10桁
	            sortkey.append(map.get("1801004"));
	            sortkey.append("-");
	            //サービス種類コード2桁
	            sortkey.append(map.get("1801007"));
	            sortkey.append("-");
	            //サービス項目コード4桁
	            sortkey.append(map.get("1801008"));
	            
	            //福祉用具対応
	            sortkey.append("-");
	            sortkey.append(map.get("1801009"));
	            sortkey.append("-");
	            sortkey.append(map.get("1801019"));
	            
	            //CSV出力用のデータを生成
	            csvData = makeDetailJushotiTokureiRecord(map);
// 2014/12/24 [Yoichiro Kamei] add - end
	        } else {
            	continue;
            }
            
            //値と比較
            if(code.indexOf(compCode) != -1){
                claimCSVList.add(new String[]{sortkey.toString(),csvData});
            }
        }
    }
    
    /**
     * CSVファイルの作成を行う。
     * @param clime_temp
     * @param claimDate
     * @param settings
     * @return
     * @throws Exception
     */
    private String makeCSV(List clime_temp,Date claimDate,VRMap settings,Date claimTargetDate) throws Exception {
        //char crlf = 0x0D0A;
        String crlf = String.valueOf(new char[]{0x0D,0x0A});
        // CSVファイルを作成する。
        // ファイルへ出力する文字列退避陽のStringBuilder sb を生成する。
        StringBuilder sb = new StringBuilder();
        
        //1ファイルに出力したデータ件数
        int dataCount = 1;
        //レコード通し番号
        int recordCount = 2;
        int controlRecordCount = 1;
        
        int fdCount = 1;
        int baitai = 0;
        
        //ファイル名の命名規則は、FD/CD-R:f MO:m 伝送(ISDN):d 伝送(インターネット):i(和暦年月)(アルファベットa-).csv
        String fileNameHeader = csvFileNameFormat.format(new Date());
        switch(ACCastUtilities.toInt(VRBindPathParser.get("MEDIUM_DIVISION",settings))){
            //FD／CD-R
            case 1:
                fileNameHeader = "f" + fileNameHeader;
                baitai = 4;
                break;
            //MO
            case 2:
                fileNameHeader = "m" + fileNameHeader;
                baitai = 2;
                break;
            //伝送（ISDN）
            case 3:
                fileNameHeader = "d" + fileNameHeader;
                baitai = 1;
                break;
            //[CCCX:1938][Shinobu Hitaka] 2014/10 edit begin 平成26年11月インターネット請求開始対応
            //伝送（インターネット）
            case 4:
                fileNameHeader = "i" + fileNameHeader;
                baitai = 7;
                break;
            //[CCCX:1938][Shinobu Hitaka] 2014/10 edit end   平成26年11月インターネット請求開始対応
        }
        
        
        //FDが選択されているかフラグ
        boolean fdSelect = (ACCastUtilities.toInt(settings.get("MEDIUM_DIVISION")) == 1);
        int maxFileSize = 1024 * 1024;
        //int maxFileSize = 1024 * 5;
        
        String filePath = ACCastUtilities.toString(settings.get("FILE_PATH"));
        
        //File file = new File(filePath, fileNameHeader + String.valueOf((char)(0x60 + fileCount)) + ".csv");
        File file = getNewFile(filePath,fileNameHeader);
        OutputStreamWriter objOsr=new OutputStreamWriter(new FileOutputStream(file),"MS932");
        BufferedWriter objBw=new BufferedWriter(objOsr);
        
        try{
            // sbの先頭に以下の文字列を追加する。
            //FDが選択されていなければ
            if(!fdSelect){
                //ヘッダレコード作成
                sb.append(getControlRecord(controlRecordCount,0,clime_temp.size(),baitai,claimDate) + crlf);
            }
            
            //clime_tempの数分ループする。
            for(int i = 0; i < clime_temp.size(); i++,recordCount++,dataCount++){
                String[] data = (String[])clime_temp.get(i);
                
                //データをStringBuilderに退避する。
                sb.append("2," + recordCount + "," + data[1] + crlf);
                
                //FDが選択されている場合
                if(fdSelect && ((i % 1000) == 0)){
                    
                    //出力される容量をチェックする。
                    //容量がFDサイズを超えそうならば
                    if(sb.toString().getBytes().length > maxFileSize){
                        sb.insert(0,getControlRecord(controlRecordCount,fdCount-1,dataCount,baitai,claimDate) + crlf);
                        
                        //一旦ファイルに出力
                        objBw.write(sb.toString());
                        
                        sb = new StringBuilder();
                        
                        //ファイルをクローズする
                        objBw.close();
                        
                        recordCount++;
                        dataCount = 0;
                        fdCount++;
                        
                        //次のフローっピーディスクを挿入してください。
                        //"１枚目のフロッピーを挿入して下さい。"
                        VRMap messageMap = new VRHashMap();
                        messageMap.put("count",String.valueOf(fdCount));
                        QkanMessageList.getInstance().QP001_NEXT_FD(messageMap);
                        
                        //新規ファイルをオープンする
                        // ファイル名の命名規則は、d(和暦年月)(アルファベットa-).csv
                        file = getNewFile(filePath,fileNameHeader);
                        objOsr = new OutputStreamWriter(new FileOutputStream(file),"MS932");
                        objBw = new BufferedWriter(objOsr);
                        controlRecordCount=recordCount;

                    }
                }
                
            }
            
            
            if(fdSelect){
                sb.insert(0,getControlRecord(controlRecordCount,fdCount-1,dataCount - 1,baitai,claimDate) + crlf);
            }
            
            //※複数ファイルを出力した場合でも、最後に出力したファイルの末端のみに付加する。
            // sbの最後に以下の文字列を追加する。
            // レコード種別3
            sb.append("3");
            // カンマ(,)
            sb.append(",");
            // レコード番号(連番)
            //sb.append(recordNoFormat.format((long)(recordCount)));
            sb.append(recordCount);
            // 改行コード(0x0D0A)
            sb.append(crlf);
            
            objBw.write(sb.toString());
            
            // ファイルに出力する。
            objBw.close();
        
        } catch (Exception e){
            // ファイル出力時のエラー
            return null;
        }
        return file.getAbsolutePath();
    }
    
    /**
     * CSV出力に使用するファイルオブジェクトを取得します。
     * @return
     * @throws Exception
     */
    private File getNewFile(String filePath,String fileNameHeader) throws Exception {
        File file = null;
//        for(int fileNameOption = 1;;fileNameOption++){
//            file = new File(filePath, fileNameHeader + String.valueOf((char)(0x60 + fileNameOption)) + ".csv");
//            //作成されていないファイルを探す
//            if(!file.exists()){
//                break;
//            }
//        }
        // 末尾がz以上のファイルを作成しないよう修整
        for(int fileNameOption = 0;fileNameOption < 26;fileNameOption++){
            file = new File(filePath, fileNameHeader + String.valueOf((char)(0x61 + fileNameOption)) + ".csv");
            //作成されていないファイルを探す
            if(!file.exists()){
                break;
            }
        }
        return file;
    }
    
    /**
     * CSVファイルのコントロールレコードを作成します。
     * @param recordCount
     * @param volume
     * @param size
     * @param baitai
     * @param claimDate
     * @return
     * @throws Exception
     */
    public String getControlRecord(int recordCount,int volume,int size,int baitai,Date claimDate) throws Exception {
        StringBuilder sb = new StringBuilder();
        //コントロールレコードを示す1
        sb.append("1");
        // カンマ(,)
        sb.append(",");
        // レコード番号0000000001
        //sb.append(recordNoFormat.format((long)recordCount));
        sb.append(recordCount);
        // カンマ(,)
        sb.append(",");
        // ボリューム通し番号000
        //sb.append(fileCountFormat.format((long)volume));
        sb.append(volume);
        // カンマ(,)
        sb.append(",");
        // レコード件数
        sb.append(size);
        // カンマ(,)
        sb.append(",");
        // データ種別
        sb.append(dataType);
        // カンマ(,)
        sb.append(",");
        // 福祉事務所特定番号0
        sb.append("0");
        // カンマ(,)
        sb.append(",");
        // 保険者番号(""でくくる)
        sb.append("000000");
        // カンマ(,)
        sb.append(",");
        // 事業所番号
        sb.append(QkanSystemInformation.getInstance().getLoginProviderID());
        // カンマ(,)
        sb.append(",");
        // 都道府県番号
        //sb.append(QkanSystemInformation.getInstance().getLoginProviderID().substring(0,2));
        sb.append("00");
        // カンマ(,)
        sb.append(",");
        // 媒体区分("1":伝送(ISDN) "2":MO "4":FD/CD-R "7":伝送(インターネット))
        sb.append(baitai);
        // カンマ(,)
        sb.append(",");
        // 処理対象月
        sb.append(VRDateParser.format(claimDate,"yyyyMM"));
        // カンマ(,)
        sb.append(",");
        // ファイル管理区分000000
        sb.append("0");
        
        
        return sb.toString();
    }
    
    /**
     * 「介護給付費明細書のCSVファイル作成」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public String makeCareSupplyClaim(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        //居宅介護支援フラグ
        //0:特定入所者　件数・費用合計・公費請求額を出力
        //1:特定入所者　全て出力
        //2:特定入所者　未出力
        int tokuteiOut = 0;
        
        //居宅・施設サービス 介護予防サービス 地域密着型サービス等であれば、特定診療費情報を出力する。
        if ("1".equals(getData(map, "101004"))
                && "00".equals(getData(map, "101005"))
                && "01".equals(getData(map, "101006"))) {
            tokuteiOut = 1;
        }
        
        if ("1".equals(getData(map, "101004"))
                && "00".equals(getData(map, "101005"))
                && "02".equals(getData(map, "101006"))) {
            tokuteiOut = 2;
        }
        
        if ("2".equals(getData(map, "101004"))
                && "12".equals(getData(map, "101005"))
                && "02".equals(getData(map, "101006"))) {
            tokuteiOut = 3;
        }
        
        //以下の文字列をカンマ区切りで生成する。
        // 交換情報識別番号4桁(7111固定)
        sb.append("\"");
        sb.append(getData(map,"101001"));
        sb.append(spliter);
        // サービス提供年月6桁(YYYYMM)
        sb.append(getData(map,"101002"));
        sb.append(spliter);
        // 事業所番号10桁
        sb.append(getData(map,"101003"));
        sb.append(spliter);
        // 保険・公費等区分コード1桁　1-保険請求 2-公費請求
        sb.append(getData(map,"101004"));
        sb.append(spliter);
        // 法別番号2桁※保険請求分の場合は0
        sb.append(getData(map,"101005"));
        sb.append(spliter);
        // 請求情報区分コード2桁　法別番号=0 OR 12→01-居宅・施設サービス　02-居宅介護支援　法別番号=それ以外→0固定
        sb.append(getData(map,"101006"));
        sb.append(spliter);
        
        // (サービス費用)件数6桁
        sb.append(getData(map,"101007"));
        sb.append(spliter);
        // (サービス費用)単位数11桁
        sb.append(getData(map,"101008"));
        sb.append(spliter);
        //(サービス費用)費用合計12桁 
        sb.append(getData(map,"101009"));
        sb.append(spliter);
        
        switch(tokuteiOut){
        //0:特定入所者　件数・費用合計・公費請求額を出力
        case 0:
            // (サービス費用)保険請求額12桁
            //sb.append(getData(map,"101010"));
            sb.append("0");
            sb.append(spliter);
            // (サービス費用)公費請求額12桁
            sb.append(getData(map,"101011"));
            sb.append(spliter);
            // (サービス費用)利用者負担12桁
            sb.append("0");
            sb.append(spliter);
            
            // (特定入所者介護サービス費等)件数6桁
            sb.append(getData(map,"101013"));
            sb.append(spliter);
            // (特定入所者護サービス費等)延べ日数8桁
            //平成17年10月以降は設定不要
            //sb.append(getData(map,"101014"));
            sb.append(spliter);
            
            // (特定入所者介護サービス費等)費用合計12桁
            sb.append(getData(map,"101015"));
            sb.append(spliter);
            // (特定入所者介護サービス費等)利用者負担12桁
            sb.append("0");
            sb.append(spliter);
            // (特定入所者介護サービス費等)公費請求額12桁
            sb.append(getData(map,"101017"));
            sb.append(spliter);
            // (特定入所者介サービス費等)保険請求額12桁
            sb.append("0");
            sb.append("\"");
            break;
            
        //1:特定入所者　全て出力
        case 1:
            // (サービス費用)保険請求額12桁
            sb.append(getData(map,"101010"));
            sb.append(spliter);
            // (サービス費用)公費請求額12桁
            sb.append(getData(map,"101011"));
            sb.append(spliter);
            // (サービス費用)利用者負担12桁
            sb.append(getData(map,"101012"));
            sb.append(spliter);
            
            // (特定入所者介護サービス費等)件数6桁
            sb.append(getData(map,"101013"));
            sb.append(spliter);
            // (特定入所者護サービス費等)延べ日数8桁
            //平成17年10月以降は設定不要
            //sb.append(getData(map,"101014"));
            sb.append(spliter);
            
            // (特定入所者介護サービス費等)費用合計12桁
            sb.append(getData(map,"101015"));
            sb.append(spliter);
            // (特定入所者介護サービス費等)利用者負担12桁
            sb.append(getData(map,"101016"));
            sb.append(spliter);
            // (特定入所者介護サービス費等)公費請求額12桁
            sb.append(getData(map,"101017"));
            sb.append(spliter);
            // (特定入所者介サービス費等)保険請求額12桁
            sb.append(getData(map,"101018"));
            sb.append("\"");
            break;
            
        //2:特定入所者　未出力
        case 2:
            // (サービス費用)保険請求額12桁
            sb.append(getData(map,"101010"));
            sb.append(spliter);
            // (サービス費用)公費請求額12桁
            sb.append(getData(map,"101011"));
            sb.append(spliter);
            // (サービス費用)利用者負担12桁
            sb.append(getData(map,"101012"));
            sb.append(spliter);
            
            // (特定入所者介護サービス費等)件数6桁
            sb.append(spliter);
            // (特定入所者護サービス費等)延べ日数8桁
            //平成17年10月以降は設定不要
            //sb.append(getData(map,"101014"));
            sb.append(spliter);
            
            // (特定入所者介護サービス費等)費用合計12桁
            sb.append(spliter);
            // (特定入所者介護サービス費等)利用者負担12桁
            sb.append(spliter);
            // (特定入所者介護サービス費等)公費請求額12桁
            sb.append(spliter);
            // (特定入所者介サービス費等)保険請求額12桁
            sb.append("\"");
            break;
            
        //3:特定入所者　未出力+サービス費用の保険・利用者負担を0出力
        case 3:
            // (サービス費用)保険請求額12桁
            sb.append("0");
            sb.append(spliter);
            // (サービス費用)公費請求額12桁
            sb.append(getData(map,"101011"));
            sb.append(spliter);
            // (サービス費用)利用者負担12桁
            sb.append("0");
            sb.append(spliter);
            
            // (特定入所者介護サービス費等)件数6桁
            sb.append(spliter);
            // (特定入所者護サービス費等)延べ日数8桁
            //平成17年10月以降は設定不要
            //sb.append(getData(map,"101014"));
            sb.append(spliter);
            
            // (特定入所者介護サービス費等)費用合計12桁
            sb.append(spliter);
            // (特定入所者介護サービス費等)利用者負担12桁
            sb.append(spliter);
            // (特定入所者介護サービス費等)公費請求額12桁
            sb.append(spliter);
            // (特定入所者介サービス費等)保険請求額12桁
            sb.append("\"");
            break;
        }
        
        return sb.toString();

    }

    /**
     * 「基本情報レコードデータ文字列作成」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public String makeBaseRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 交換情報識別番号4桁(SYSTEM_BIND_PATH:201001)
        sb.append("\"");
        sb.append(getData(map,"201001"));
        sb.append(spliter);
        // レコード種別コード2桁(SYSTEM_BIND_PATH:201002)
        sb.append(getData(map,"201002"));
        sb.append(spliter);
        // サービス提供年月6桁(SYSTEM_BIND_PATH:201003)
        sb.append(getData(map,"201003"));
        sb.append(spliter);
        // 事業所番号10桁(SYSTEM_BIND_PATH:201004)
        sb.append(getData(map,"201004"));
        sb.append(spliter);
        // 証記載保険者番号8桁(SYSTEM_BIND_PATH:201005)
        //sb.append(getData(map,"201005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"201005"),0)));
        sb.append(spliter);
        // 被保険者番号10桁(SYSTEM_BIND_PATH:201006)
        sb.append(getData(map,"201006"));
        sb.append(spliter);
        // (公費1)負担者番号8桁(SYSTEM_BIND_PATH:201007)
        sb.append(getData(map,"201007"));
        sb.append(spliter);
        // (公費1)受給者番号7桁(SYSTEM_BIND_PATH:201008)
        sb.append(getData(map,"201008"));
        sb.append(spliter);
        // (公費2)負担者番号8桁(SYSTEM_BIND_PATH:201009)
        sb.append(getData(map,"201009"));
        sb.append(spliter);
        // (公費2)受給者番号7桁(SYSTEM_BIND_PATH:201010)
        sb.append(getData(map,"201010"));
        sb.append(spliter);
        // (公費3)負担者番号8桁(SYSTEM_BIND_PATH:201011)
        sb.append(getData(map,"201011"));
        sb.append(spliter);
        // (公費3)受給者番号7桁(SYSTEM_BIND_PATH:201012)
        sb.append(getData(map,"201012"));
        sb.append(spliter);
        // (被保険者情報)生年月日8桁YYYYMMDD(SYSTEM_BIND_PATH:201013)
        sb.append(getData(map,"201013"));
        sb.append(spliter);
        // (被保険者情報)性別コード1桁(SYSTEM_BIND_PATH:201014)
        sb.append(getData(map,"201014"));
        sb.append(spliter);
        // (被保険者情報)要介護状態区分コード2桁(SYSTEM_BIND_PATH:201015)
        sb.append(getData(map,"201015"));
        sb.append(spliter);
        // (被保険者情報)旧措置入所者特例コード1桁(SYSTEM_BIND_PATH:201016)
        //様式第八のみ出力
        if("7183".equals(String.valueOf(map.get("201001")))){
            sb.append(getData(map,"201016"));
        }
        sb.append(spliter);
        // (被保険者情報)認定有効期間 開始年月日8桁(YYYYMMDD)(SYSTEM_BIND_PATH:201017)
        sb.append(getData(map,"201017"));
        sb.append(spliter);
        // (被保険者情報)認定有効期間 終了年月日8桁(YYYYMMDD)(SYSTEM_BIND_PATH:201018)
        sb.append(getData(map,"201018"));
        sb.append(spliter);
        // (居宅サービス計画)居宅サービス計画作成区分コード(SYSTEM_BIND_PATH:201019)
        if(ACCastUtilities.toInt(map.get("201019"),0) != 0){
            sb.append(getData(map,"201019"));
        }
        sb.append(spliter);
        if(QP001SpecialCase.isServicePlanMakerLiving(getData(map,"201001"))){
            // (居宅サービス計画)事業所番号10桁(居宅介護支援事業所)(SYSTEM_BIND_PATH:201020)
            sb.append(getData(map,"201020"));
        }
        sb.append(spliter);
        // 開始年月日8桁(YYYYMMDD)(SYSTEM_BIND_PATH:201021)
        sb.append(getData(map,"201021"));
        sb.append(spliter);
        // 中止年月日8桁(YYYYMMDD)(SYSTEM_BIND_PATH:201022)
        sb.append(getData(map,"201022"));
        sb.append(spliter);
        // 中止理由コード1桁(SYSTEM_BIND_PATH:201023)
        if(ACCastUtilities.toInt(map.get("201023"),0) != 0){
            sb.append(getData(map,"201023"));
        }
        sb.append(spliter);
        // 入所(院)年月日8桁(YYYYMMDD)(SYSTEM_BIND_PATH:201024)
        sb.append(getData(map,"201024"));
        sb.append(spliter);
        // 退所(院)年月日8桁(YYYYMMDD)(SYSTEM_BIND_PATH:201025)
        sb.append(getData(map,"201025"));
        sb.append(spliter);
        // 入所(院)実日数2桁(SYSTEM_BIND_PATH:201026)
        if(ACTextUtilities.isNullText(getData(map,"201026"))){
            sb.append("0");
        } else {
            sb.append(getData(map,"201026"));
        }
        sb.append(spliter);
        // 外泊日数2桁(SYSTEM_BIND_PATH:201027)
        if(ACTextUtilities.isNullText(getData(map,"201027"))){
            sb.append("0");
        } else {
            sb.append(getData(map,"201027"));
        }
        sb.append(spliter);
        // 退所(院)後の状態コード1桁(SYSTEM_BIND_PATH:201028)
        if(ACCastUtilities.toInt(map.get("201028"),0) != 0){
            sb.append(getData(map,"201028"));
        }
        sb.append(spliter);
        // 保険給付率3桁(SYSTEM_BIND_PATH:201029)
        sb.append(getData(map,"201029"));
        sb.append(spliter);
        // 公費1給付率(SYSTEM_BIND_PATH:201030)
        sb.append(getData(map,"201030"));
        sb.append(spliter);
        // 公費2給付率(SYSTEM_BIND_PATH:201031)
        sb.append(getData(map,"201031"));
        sb.append(spliter);
        // 公費3給付率(SYSTEM_BIND_PATH:201032)
        sb.append(getData(map,"201032"));
        sb.append(spliter);
        // (合計情報 保険)サービス単位数8桁(SYSTEM_BIND_PATH:201033)
        sb.append(getData(map,"201033"));
        sb.append(spliter);
        // (合計情報 保険)請求額9桁(SYSTEM_BIND_PATH:201034)
        sb.append(getData(map,"201034"));
        sb.append(spliter);
        // (合計情報 保険)利用者負担額8桁(SYSTEM_BIND_PATH:201035)
        sb.append(getData(map,"201035"));
        sb.append(spliter);
        // (合計情報 保険)緊急時施設療養費請求額9桁(SYSTEM_BIND_PATH:201036)
        sb.append(getData(map,"201036"));
        sb.append(spliter);
        // (合計情報 保険)特定診療費請求額9桁(SYSTEM_BIND_PATH:201037)
        sb.append(getData(map,"201037"));
        sb.append(spliter);
        // (合計情報 保険)特定入所者介護サービス費等請求額8桁(SYSTEM_BIND_PATH:201038)
        sb.append(getData(map,"201038"));
        sb.append(spliter);
        // (合計情報 公費1)サービス単位数8桁(SYSTEM_BIND_PATH:201039)
        sb.append(getData(map,"201039"));
        sb.append(spliter);
        // (合計情報 公費1)請求額8桁(SYSTEM_BIND_PATH:201040)
        sb.append(getData(map,"201040"));
        sb.append(spliter);
        // (合計情報 公費1)本人負担額8桁(SYSTEM_BIND_PATH:201041)
        sb.append(getData(map,"201041"));
        sb.append(spliter);
        // (合計情報 公費1)緊急時施設療養費請求額8桁(SYSTEM_BIND_PATH:201042)
        sb.append(getData(map,"201042"));
        sb.append(spliter);
        // (合計情報 公費1)特定診療費請求額8桁(SYSTEM_BIND_PATH:201043)
        sb.append(getData(map,"201043"));
        sb.append(spliter);
        // (合計情報 公費1)特定入所者介護サービス費等請求額8桁(SYSTEM_BIND_PATH:201044)
        sb.append(getData(map,"201044"));
        sb.append(spliter);
        // (合計情報 公費2)サービス単位数8桁(SYSTEM_BIND_PATH:201045)
        sb.append(getData(map,"201045"));
        sb.append(spliter);
        // (合計情報 公費2)請求額8桁(SYSTEM_BIND_PATH:201046)
        sb.append(getData(map,"201046"));
        sb.append(spliter);
        // (合計情報 公費2)本人負担額8桁(SYSTEM_BIND_PATH:201047)
        sb.append(getData(map,"201047"));
        sb.append(spliter);
        // (合計情報 公費2)緊急時施設療養費請求額8桁(SYSTEM_BIND_PATH:201048)
        sb.append(getData(map,"201048"));
        sb.append(spliter);
        // (合計情報 公費2)特定診療費請求額8桁(SYSTEM_BIND_PATH:201049)
        sb.append(getData(map,"201049"));
        sb.append(spliter);
        // (合計情報 公費2)特定入所者介護サービス費等請求額8桁(SYSTEM_BIND_PATH:201050)
        sb.append(getData(map,"201050"));
        sb.append(spliter);
        // (合計情報 公費3)サービス単位数8桁(SYSTEM_BIND_PATH:201051)
        sb.append(getData(map,"201051"));
        sb.append(spliter);
        // (合計情報 公費3)請求額8桁(SYSTEM_BIND_PATH:201052)
        sb.append(getData(map,"201052"));
        sb.append(spliter);
        // (合計情報 公費3)本人負担額8桁(SYSTEM_BIND_PATH:201053)
        sb.append(getData(map,"201053"));
        sb.append(spliter);
        // (合計情報 公費3)緊急時施設療養費請求額8桁(SYSTEM_BIND_PATH:201054)
        sb.append(getData(map,"201054"));
        sb.append(spliter);
        // (合計情報 公費3)特定診療費請求額8桁(SYSTEM_BIND_PATH:201055)
        sb.append(getData(map,"201055"));
        sb.append(spliter);
        // (合計情報 公費3)特定入所者介護サービス費等請求額8桁(SYSTEM_BIND_PATH:201056)
        sb.append(getData(map,"201056"));
        sb.append("\"");
        
//        sb.append(",");
//        // 居宅サービス計画者事業所名(SYSTEM_BIND_PATH:201057)
//        sb.append(map.get("201057"));
//        sb.append(",");
//        // 公費1 公費種類(KOHI_TYPE)(SYSTEM_BIND_PATH:201058)
//        sb.append(map.get("201058"));
//        sb.append(",");
//        // 公費2 公費種類(KOHI_TYPE)(SYSTEM_BIND_PATH:201059)
//        sb.append(map.get("201059"));
//        sb.append(",");
//        // 公費3 公費種類(KOHI_TYPE)(SYSTEM_BIND_PATH:201060)
//        sb.append(map.get("201060"));
        
        return sb.toString();
    }

    /**
     * 「明細情報レコードデータ文字列作成」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public String makeDetailRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 以下の文字列をカンマ区切りで生成する。
        // 交換情報識別番号4桁(SYSTEM_BIND_PATH:301001)
        sb.append("\"");
        sb.append(getData(map,"301001"));
        sb.append(spliter);
        // レコード種別コード2桁(SYSTEM_BIND_PATH:301002)
        sb.append(getData(map,"301002"));
        sb.append(spliter);
        // サービス提供年月6桁(YYYYMM)(SYSTEM_BIND_PATH:301003)
        sb.append(getData(map,"301003"));
        sb.append(spliter);
        // 事業所番号10桁(SYSTEM_BIND_PATH:301004)
        sb.append(getData(map,"301004"));
        sb.append(spliter);
        // 証記載保険者番号8桁(SYSTEM_BIND_PATH:301005)
        //sb.append(getData(map,"301005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"301005"),0)));
        sb.append(spliter);
        // 被保険者番号10桁(SYSTEM_BIND_PATH:301006)
        sb.append(getData(map,"301006"));
        sb.append(spliter);
        // サービス種類コード2桁(SYSTEM_BIND_PATH:301007)
        sb.append(getData(map,"301007"));
        sb.append(spliter);
        // サービス項目コード4桁(SYSTEM_BIND_PATH:301008)
        sb.append(getData(map,"301008"));
        sb.append(spliter);
        //単位数を記載しないサービスでない場合、単位数を出力する。
        if(!QP001SpecialCase.isUnitNoCountService(getData(map,"301007"),getData(map,"301008"))){
            // 単位数4桁(SYSTEM_BIND_PATH:301009)
            sb.append(getData(map,"301009"));
        }
        sb.append(spliter);
        // 日数･回数2桁(SYSTEM_BIND_PATH:301010)
        sb.append(getData(map,"301010"));
        sb.append(spliter);
        // 公費1対象日数・回数2桁(SYSTEM_BIND_PATH:301011)
        sb.append(getData(map,"301011"));
        sb.append(spliter);
        // 公費2対象日数・回数2桁(SYSTEM_BIND_PATH:301012)
        sb.append(getData(map,"301012"));
        sb.append(spliter);
        // 公費3対象日数・回数2桁(SYSTEM_BIND_PATH:301013)
        sb.append(getData(map,"301013"));
        sb.append(spliter);
        // サービス単位数6桁(SYSTEM_BIND_PATH:301014)
        sb.append(getData(map,"301014"));
        sb.append(spliter);
        // 公費1対象サービス単位数6桁(SYSTEM_BIND_PATH:301015)
        sb.append(getData(map,"301015"));
        sb.append(spliter);
        // 公費2対象サービス単位数6桁(SYSTEM_BIND_PATH:301016)
        sb.append(getData(map,"301016"));
        sb.append(spliter);
        // 公費3対象サービス単位数6桁(SYSTEM_BIND_PATH:301017)
        sb.append(getData(map,"301017"));
        sb.append(spliter);
        // 摘要20桁(SYSTEM_BIND_PATH:301018)
        sb.append(getData(map,"301018"));
        sb.append("\"");
        
        return sb.toString();
    }

    /**
     * 「緊急時施設療養情報レコードデータ文字列作成」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public String makeEmergencyRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 以下の文字列をカンマ区切りで生成する。
        // 交換情報識別番号4桁(SYSTEM_BIND_PATH:401001)
        sb.append("\"");
        sb.append(getData(map,"401001"));
        sb.append(spliter);
        // レコード種別コード2桁(SYSTEM_BIND_PATH:401002)
        sb.append(getData(map,"401002"));
        sb.append(spliter);
        // サービス提供年月6桁(YYYYMM)(SYSTEM_BIND_PATH:401003)
        sb.append(getData(map,"401003"));
        sb.append(spliter);
        // 事業所番号10桁(SYSTEM_BIND_PATH:401004)
        sb.append(getData(map,"401004"));
        sb.append(spliter);
        // 証記載保険者番号8桁(SYSTEM_BIND_PATH:401005)
        //sb.append(getData(map,"401005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"401005"),0)));
        sb.append(spliter);
        // 被保険者番号10桁(SYSTEM_BIND_PATH:401006)
        sb.append(getData(map,"401006"));
        sb.append(spliter);
        // 緊急時施設療養情報レコード順次番号2桁(SYSTEM_BIND_PATH:401007)
        sb.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("401007"))));
        sb.append(spliter);
        // 緊急時傷病名1 40桁(SYSTEM_BIND_PATH:401008)
        sb.append(getData(map,"401008"));
        sb.append(spliter);
        // 緊急時傷病名2 40桁(SYSTEM_BIND_PATH:401009)
        sb.append(getData(map,"401009"));
        sb.append(spliter);
        // 緊急時傷病名3 40桁(SYSTEM_BIND_PATH:401010)
        sb.append(getData(map,"401010"));
        sb.append(spliter);
        // 緊急時治療開始年月日1 8桁(YYYYMMDD)(SYSTEM_BIND_PATH:401011)
        sb.append(getData(map,"401011"));
        sb.append(spliter);
        // 緊急時治療開始年月日2 8桁(YYYYMMDD)(SYSTEM_BIND_PATH:401012)
        sb.append(getData(map,"401012"));
        sb.append(spliter);
        // 緊急時治療開始年月日3 8桁(YYYYMMDD)(SYSTEM_BIND_PATH:401013)
        sb.append(getData(map,"401013"));
        sb.append(spliter);
        // 往診日数2桁(SYSTEM_BIND_PATH:401014)
        sb.append(getData(map,"401014"));
        sb.append(spliter);
        // 往診医療機関名40桁(SYSTEM_BIND_PATH:401015)
        sb.append(getData(map,"401015"));
        sb.append(spliter);
        // 通院日数2桁(SYSTEM_BIND_PATH:401016)
        sb.append(getData(map,"401016"));
        sb.append(spliter);
        // 通院医療機関名40桁(SYSTEM_BIND_PATH:401017)
        sb.append(getData(map,"401017"));
        sb.append(spliter);
        // 緊急時治療管理単位数6桁(SYSTEM_BIND_PATH:401018)
        sb.append(getData(map,"401018"));
        sb.append(spliter);
        // 緊急時治療管理日数2桁(SYSTEM_BIND_PATH:401019)
        sb.append(getData(map,"401019"));
        sb.append(spliter);
        // 緊急時治療管理小計7桁(SYSTEM_BIND_PATH:401020)
        sb.append(getData(map,"401020"));
        sb.append(spliter);
        // リハビリテーション点数7桁(SYSTEM_BIND_PATH:401021)
        sb.append(getData(map,"401021"));
        sb.append(spliter);
        // 処置点数7桁(SYSTEM_BIND_PATH:401022)
        sb.append(getData(map,"401022"));
        sb.append(spliter);
        // 手術点数7桁(SYSTEM_BIND_PATH:401023)
        sb.append(getData(map,"401023"));
        sb.append(spliter);
        // 麻酔点数7桁(SYSTEM_BIND_PATH:401024)
        sb.append(getData(map,"401024"));
        sb.append(spliter);
        // 放射線治療点数7桁(SYSTEM_BIND_PATH:401025)
        sb.append(getData(map,"401025"));
        sb.append(spliter);
        // 摘要1 64桁(SYSTEM_BIND_PATH:401026)
        sb.append(getData(map,"401026"));
        sb.append(spliter);
        // 摘要2 64桁(SYSTEM_BIND_PATH:401027)
        sb.append(getData(map,"401027"));
        sb.append(spliter);
        // 摘要3 64桁(SYSTEM_BIND_PATH:401028)
        sb.append(getData(map,"401028"));
        sb.append(spliter);
        // 摘要4 64桁(SYSTEM_BIND_PATH:401029)
        sb.append(getData(map,"401029"));
        sb.append(spliter);
        // 摘要5 64桁(SYSTEM_BIND_PATH:401030)
        sb.append(getData(map,"401030"));
        sb.append(spliter);
        // 摘要6 64桁(SYSTEM_BIND_PATH:401031)
        sb.append(getData(map,"401031"));
        sb.append(spliter);
        // 摘要7 64桁(SYSTEM_BIND_PATH:401032)
        sb.append(getData(map,"401032"));
        sb.append(spliter);
        // 摘要8 64桁(SYSTEM_BIND_PATH:401033)
        sb.append(getData(map,"401033"));
        sb.append(spliter);
        // 摘要9 64桁(SYSTEM_BIND_PATH:401034)
        sb.append(getData(map,"401034"));
        sb.append(spliter);
        // 摘要10 64桁(SYSTEM_BIND_PATH:401035)
        sb.append(getData(map,"401035"));
        sb.append(spliter);
        // 摘要11 64桁(SYSTEM_BIND_PATH:401036)
        sb.append(getData(map,"401036"));
        sb.append(spliter);
        // 摘要12 64桁(SYSTEM_BIND_PATH:401037)
        sb.append(getData(map,"401037"));
        sb.append(spliter);
        // 摘要13 64桁(SYSTEM_BIND_PATH:401038)
        sb.append(getData(map,"401038"));
        sb.append(spliter);
        // 摘要14 64桁(SYSTEM_BIND_PATH:401039)
        sb.append(getData(map,"401039"));
        sb.append(spliter);
        // 摘要15 64桁(SYSTEM_BIND_PATH:401040)
        sb.append(getData(map,"401040"));
        sb.append(spliter);
        // 摘要16 64桁(SYSTEM_BIND_PATH:401041)
        sb.append(getData(map,"401041"));
        sb.append(spliter);
        // 摘要17 64桁(SYSTEM_BIND_PATH:401042)
        sb.append(getData(map,"401042"));
        sb.append(spliter);
        // 摘要18 64桁(SYSTEM_BIND_PATH:401043)
        sb.append(getData(map,"401043"));
        sb.append(spliter);
        // 摘要19 64桁(SYSTEM_BIND_PATH:401044)
        // edit sta 2006.05.20 fujihara.shin
        //sb.append(getData(map,"401043"));
        sb.append(getData(map,"401044"));
        // edit end 2006.05.20 fujihara.shin
        sb.append(spliter);
        // 摘要20 64桁(SYSTEM_BIND_PATH:401045)
        sb.append(getData(map,"401045"));
        sb.append(spliter);
        // 緊急時施設療養費合計点数8桁(SYSTEM_BIND_PATH:401046)
        sb.append(getData(map,"401046"));
        sb.append("\"");
        
        return sb.toString();
    }

    /**
     * 「特定診療費情報レコードデータ文字列作成」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public String makeDiagnosisRecord(VRMap map) throws Exception {
        
        int _501007 = ACCastUtilities.toInt(map.get("501007"),0);
        StringBuilder sb = new StringBuilder();
        // 以下の文字列をカンマ区切りで生成する。
        // 交換情報識別番号4桁(SYSTEM_BIND_PATH:501001)
        sb.append("\"");
        sb.append(getData(map,"501001"));
        sb.append(spliter);
        // レコード種別コード2桁(SYSTEM_BIND_PATH:501002)
        sb.append(getData(map,"501002"));
        sb.append(spliter);
        // サービス提供年月6桁(YYYYMM)(SYSTEM_BIND_PATH:501003)
        sb.append(getData(map,"501003"));
        sb.append(spliter);
        // 事業所番号10桁(SYSTEM_BIND_PATH:501004)
        sb.append(getData(map,"501004"));
        sb.append(spliter);
        // 証記載保険者番号8桁(SYSTEM_BIND_PATH:501005)
        //sb.append(getData(map,"501005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"501005"),0)));
        sb.append(spliter);
        // 被保険者番号10桁(SYSTEM_BIND_PATH:501006)
        sb.append(getData(map,"501006"));
        sb.append(spliter);
        // 特定診療費情報レコード順次番号2桁(SYSTEM_BIND_PATH:501007)
        //sb.append(getData(map,"501007"));
        sb.append(continuousnessFormat.format((long)_501007));
        sb.append(spliter);
        // 傷病名40桁(SYSTEM_BIND_PATH:501008)
        sb.append(getData(map,"501008"));
        sb.append(spliter);
        // 識別番号2桁特定診療費の識別番号(SYSTEM_BIND_PATH:501009)
        sb.append(getData(map,"501009"));
        sb.append(spliter);
        // 単位数4桁(SYSTEM_BIND_PATH:501010)
        sb.append(getData(map,"501010"));
        sb.append(spliter);
        // (保険)回数2桁(SYSTEM_BIND_PATH:501011)
        sb.append(getData(map,"501011"));
        sb.append(spliter);
        // (保険)サービス単位数6桁(SYSTEM_BIND_PATH:501012)
        sb.append(getData(map,"501012"));
        sb.append(spliter);
        if(_501007 == 99){
            // (保険)合計単位数8桁(SYSTEM_BIND_PATH:501013)
            sb.append(getData(map,"501013"));
        }
        sb.append(spliter);
        // (公費1)回数2桁(SYSTEM_BIND_PATH:501014)
        sb.append(getData(map,"501014"));
        sb.append(spliter);
        // (公費1)サービス単位数6桁(SYSTEM_BIND_PATH:501015)
        sb.append(getData(map,"501015"));
        sb.append(spliter);
        if(_501007 == 99){
            // (公費1)合計単位数8桁(SYSTEM_BIND_PATH:501016)
            sb.append(getData(map,"501016"));
        }
        sb.append(spliter);
        // (公費2)回数2桁(SYSTEM_BIND_PATH:501017)
        sb.append(getData(map,"501017"));
        sb.append(spliter);
        // (公費2)サービス単位数6桁(SYSTEM_BIND_PATH:501018)
        sb.append(getData(map,"501018"));
        sb.append(spliter);
        if(_501007 == 99){
            // (公費2)合計単位数8桁(SYSTEM_BIND_PATH:501019)
            sb.append(getData(map,"501019"));
        }
        sb.append(spliter);
        // (公費3)回数2桁(SYSTEM_BIND_PATH:501020)
        sb.append(getData(map,"501020"));
        sb.append(spliter);
        // (公費3)サービス単位数6桁(SYSTEM_BIND_PATH:501021)
        sb.append(getData(map,"501021"));
        sb.append(spliter);
        if(_501007 == 99){
            // (公費3)合計単位数8桁(SYSTEM_BIND_PATH:501022)
            sb.append(getData(map,"501022"));
        }
        sb.append(spliter);
        // 摘要100桁(SYSTEM_BIND_PATH:501023)
        sb.append(getData(map,"501023"));
        sb.append("\"");
        
        return sb.toString();
    }

    /**
     * 「集計情報レコードデータ文字列作成」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public String makeTypeRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 以下の文字列をカンマ区切りで生成する。
        // 交換情報識別番号4桁(SYSTEM_BIND_PATH:701001)
        sb.append("\"");
        sb.append(getData(map,"701001"));
        sb.append(spliter);
        // レコード種別コード2桁(SYSTEM_BIND_PATH:701002)
        sb.append(getData(map,"701002"));
        sb.append(spliter);
        // サービス提供年月6桁(YYYYMM)(SYSTEM_BIND_PATH:701003)
        sb.append(getData(map,"701003"));
        sb.append(spliter);
        // 事業所番号10桁(SYSTEM_BIND_PATH:701004)
        sb.append(getData(map,"701004"));
        sb.append(spliter);
        // 証記載保険者番号8桁(SYSTEM_BIND_PATH:701005)
        //sb.append(getData(map,"701005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"701005"),0)));
        sb.append(spliter);
        // 被保険者番号10桁(SYSTEM_BIND_PATH:701006)
        sb.append(getData(map,"701006"));
        sb.append(spliter);
        // サービス種類コード2桁(SYSTEM_BIND_PATH:701007)
        sb.append(getData(map,"701007"));
        sb.append(spliter);
        // サービス実日数2桁(SYSTEM_BIND_PATH:701008)
        //様式第三、第四、第五、第六の五、第六の六の場合のみ出力する。
        if(QP001SpecialCase.isOutRealDay(String.valueOf(map.get("701001")))) {
            sb.append(getData(map,"701008"));
        } else {
            sb.append("0");
        }
        sb.append(spliter);
        // 計画単位数6桁(SYSTEM_BIND_PATH:701009)
        sb.append(getData(map,"701009"));
        sb.append(spliter);
        // 限度額管理対象単位数6桁(SYSTEM_BIND_PATH:701010)
        sb.append(getData(map,"701010"));
        sb.append(spliter);
        
        //限度額管理対象外単位数6桁(SYSTEM_BIND_PATH:701011)
        //様式第二第三、
        if(QP001SpecialCase.isOutLimitUncontrolledUnit(String.valueOf(map.get("701001")))) {
            sb.append(getData(map,"701011"));
        } else {
            sb.append("0");
        }
        sb.append(spliter);
        
        
        // 短期入所計画日数2桁(SYSTEM_BIND_PATH:701012)
        //出力しない仕様
        //sb.append(getData(map,"701012"));
        sb.append(spliter);
        // 短期入所実日数2桁(SYSTEM_BIND_PATH:701013)
        //sb.append(getData(map,"701013"));
        //出力しない仕様
        sb.append(spliter);
        
        // (保険)単位数合計8桁(SYSTEM_BIND_PATH:701014)
        sb.append(getData(map,"701014"));
        sb.append(spliter);
        // (保険)単位数単価4桁(SYSTEM_BIND_PATH:701015)
        sb.append(getTanka(getData(map,"701015")));
        sb.append(spliter);
        // (保険)請求額9桁(SYSTEM_BIND_PATH:701016)
        sb.append(getData(map,"701016"));
        sb.append(spliter);
        // (保険)利用者負担額8桁(SYSTEM_BIND_PATH:701017)
        sb.append(getData(map,"701017"));
        sb.append(spliter);
        // (公費1)単位数合計6桁(SYSTEM_BIND_PATH:701018)
        sb.append(getData(map,"701018"));
        sb.append(spliter);
        // (公費1)請求額9桁(SYSTEM_BIND_PATH:701019)
        sb.append(getData(map,"701019"));
        sb.append(spliter);
        // (公費1)本人負担額6桁(SYSTEM_BIND_PATH:701020)
        sb.append(getData(map,"701020"));
        sb.append(spliter);
        // (公費2)単位数合計6桁(SYSTEM_BIND_PATH:701021)
        sb.append(getData(map,"701021"));
        sb.append(spliter);
        // (公費2)請求額9桁(SYSTEM_BIND_PATH:701022)
        sb.append(getData(map,"701022"));
        sb.append(spliter);
        // (公費2)本人負担額6桁(SYSTEM_BIND_PATH:701023)
        sb.append(getData(map,"701023"));
        sb.append(spliter);
        // (公費3)単位数合計6桁(SYSTEM_BIND_PATH:701024)
        sb.append(getData(map,"701024"));
        sb.append(spliter);
        // (公費3)請求額9桁(SYSTEM_BIND_PATH:701025)
        sb.append(getData(map,"701025"));
        sb.append(spliter);
        // (公費3)本人負担額6桁(SYSTEM_BIND_PATH:701026)
        sb.append(getData(map,"701026"));
        sb.append(spliter);
        // (保険分出来高医療費)単位数合計8桁(SYSTEM_BIND_PATH:701027)
        sb.append(getData(map,"701027"));
        sb.append(spliter);
        // (保険分出来高医療費)請求額9桁(SYSTEM_BIND_PATH:701028)
        sb.append(getData(map,"701028"));
        sb.append(spliter);
        // (保険分出来高医療費)出来高医療費利用者負担額8桁(SYSTEM_BIND_PATH:701029)
        sb.append(getData(map,"701029"));
        sb.append(spliter);
        // (公費1分出来高医療費)単位数合計8桁(SYSTEM_BIND_PATH:701030)
        sb.append(getData(map,"701030"));
        sb.append(spliter);
        // (公費1分出来高医療費)請求額9桁(SYSTEM_BIND_PATH:701031)
        sb.append(getData(map,"701031"));
        sb.append(spliter);
        // (公費1分出来高医療費)出来高医療費本人負担額8桁(SYSTEM_BIND_PATH:701032)
        sb.append(getData(map,"701032"));
        sb.append(spliter);
        // (公費2分出来高医療費)単位数合計8桁(SYSTEM_BIND_PATH:701033)
        sb.append(getData(map,"701033"));
        sb.append(spliter);
        // (公費2分出来高医療費)請求額9桁(SYSTEM_BIND_PATH:701034)
        sb.append(getData(map,"701034"));
        sb.append(spliter);
        // (公費2分出来高医療費)出来高医療費本人負担額8桁(SYSTEM_BIND_PATH:701035)
        sb.append(getData(map,"701035"));
        sb.append(spliter);
        // (公費3分出来高医療費)単位数合計8桁(SYSTEM_BIND_PATH:701036)
        sb.append(getData(map,"701036"));
        sb.append(spliter);
        // (公費3分出来高医療費)請求額9桁(SYSTEM_BIND_PATH:701037)
        sb.append(getData(map,"701037"));
        sb.append(spliter);
        // (公費3分出来高医療費)出来高医療費本人負担額8桁(SYSTEM_BIND_PATH:701038)
        sb.append(getData(map,"701038"));
        sb.append("\"");
        
        return sb.toString();
    }

    /**
     * 「特定入所者介護サービス費用情報レコードデータ文字列作成」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public String makeNursingRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 以下の文字列をカンマ区切りで生成する。
        
        // 交換情報識別番号4桁(SYSTEM_BIND_PATH:801001)
        sb.append("\"");
        sb.append(getData(map,"801001"));
        sb.append(spliter);
        // レコード種別コード2桁(11を設定)(SYSTEM_BIND_PATH:801002)
        sb.append(getData(map,"801002"));
        sb.append(spliter);
        // サービス提供年月6桁(YYYYMM)(SYSTEM_BIND_PATH:801003)
        sb.append(getData(map,"801003"));
        sb.append(spliter);
        // 事業所番号10桁(SYSTEM_BIND_PATH:801004)
        sb.append(getData(map,"801004"));
        sb.append(spliter);
        // 証記載保険者番号8桁(SYSTEM_BIND_PATH:801005)
        //sb.append(getData(map,"801005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"801005"),0)));
        sb.append(spliter);
        // 被保険者番号10桁(SYSTEM_BIND_PATH:801006)
        sb.append(getData(map,"801006"));
        sb.append(spliter);
        // 特定入所者介護サービス費用情報レコード順次番号2桁(SYSTEM_BIND_PATH:801007)
        //sb.append(getData(map,"801007"));
        sb.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("801007"),0)));
        sb.append(spliter);
        // サービス種類コード2桁(SYSTEM_BIND_PATH:801008)
        sb.append(getData(map,"801008"));
        sb.append(spliter);
        // サービス項目コード4桁(SYSTEM_BIND_PATH:801009)
        sb.append(getData(map,"801009"));
        sb.append(spliter);
        // 費用単価4桁(SYSTEM_BIND_PATH:801010)
        sb.append(getData(map,"801010"));
        sb.append(spliter);
        // 負担限度額4桁(SYSTEM_BIND_PATH:801011)
        sb.append(getData(map,"801011"));
        sb.append(spliter);
        // 日数2桁(SYSTEM_BIND_PATH:801012)
        sb.append(getData(map,"801012"));
        sb.append(spliter);
        // 公費1日数2桁(SYSTEM_BIND_PATH:801013)
        sb.append(getData(map,"801013"));
        sb.append(spliter);
        // 公費2日数2桁(SYSTEM_BIND_PATH:801014)
        sb.append(getData(map,"801014"));
        sb.append(spliter);
        // 公費3日数2桁(SYSTEM_BIND_PATH:801015)
        sb.append(getData(map,"801015"));
        sb.append(spliter);
        // 費用額6桁(SYSTEM_BIND_PATH:801016)
        sb.append(getData(map,"801016"));
        sb.append(spliter);
        // 保険分請求額6桁(SYSTEM_BIND_PATH:801017)
        sb.append(getData(map,"801017"));
        sb.append(spliter);
        // 公費1負担額(明細)6桁(SYSTEM_BIND_PATH:801018)
        sb.append(getData(map,"801018"));
        sb.append(spliter);
        // 公費2負担額(明細)6桁(SYSTEM_BIND_PATH:801019)
        sb.append(getData(map,"801019"));
        sb.append(spliter);
        // 公費3負担額(明細)6桁(SYSTEM_BIND_PATH:801020)
        sb.append(getData(map,"801020"));
        sb.append(spliter);
        // 利用者負担額5桁(SYSTEM_BIND_PATH:801021)
        sb.append(getData(map,"801021"));
        sb.append(spliter);
        
        //レコード順次番号が99の場合のみ、値を出力する。
        if(ACCastUtilities.toInt(map.get("801007"),0) == 99){
            // 費用額合計6桁(SYSTEM_BIND_PATH:801022)
            sb.append(getData(map,"801022"));
            sb.append(spliter);
            // 保険分請求額合計6桁(SYSTEM_BIND_PATH:801023)
            sb.append(getData(map,"801023"));
            sb.append(spliter);
            // 利用者負担額合計6桁(SYSTEM_BIND_PATH:801024)
            sb.append(getData(map,"801024"));
            sb.append(spliter);
            // (公費1)負担額合計6桁(SYSTEM_BIND_PATH:801025)
            sb.append(getData(map,"801025"));
            sb.append(spliter);
            // (公費1)請求額6桁(SYSTEM_BIND_PATH:801026)
            sb.append(getData(map,"801026"));
            sb.append(spliter);
            // (公費1)本人負担額5桁(SYSTEM_BIND_PATH:801027)
            sb.append(getData(map,"801027"));
            sb.append(spliter);
            // (公費2)負担額合計6桁(SYSTEM_BIND_PATH:801028)
            sb.append(getData(map,"801028"));
            sb.append(spliter);
            // (公費2)請求額6桁(SYSTEM_BIND_PATH:801029)
            sb.append(getData(map,"801029"));
            sb.append(spliter);
            // (公費2)本人負担額5桁(SYSTEM_BIND_PATH:801030)
            sb.append(getData(map,"801030"));
            sb.append(spliter);
            // (公費3)負担額合計6桁(SYSTEM_BIND_PATH:801031)
            sb.append(getData(map,"801031"));
            sb.append(spliter);
            // (公費3)請求額6桁(SYSTEM_BIND_PATH:801032)
            sb.append(getData(map,"801032"));
            sb.append(spliter);
            // (公費3)本人負担額5桁(SYSTEM_BIND_PATH:801033)
            sb.append(getData(map,"801033"));
            sb.append("\"");
        } else {
            // 費用額合計6桁(SYSTEM_BIND_PATH:801022)
            sb.append(spliter);
            // 保険分請求額合計6桁(SYSTEM_BIND_PATH:801023)
            sb.append(spliter);
            // 利用者負担額合計6桁(SYSTEM_BIND_PATH:801024)
            sb.append(spliter);
            // (公費1)負担額合計6桁(SYSTEM_BIND_PATH:801025)
            sb.append(spliter);
            // (公費1)請求額6桁(SYSTEM_BIND_PATH:801026)
            sb.append(spliter);
            // (公費1)本人負担額5桁(SYSTEM_BIND_PATH:801027)
            sb.append(spliter);
            // (公費2)負担額合計6桁(SYSTEM_BIND_PATH:801028)
            sb.append(spliter);
            // (公費2)請求額6桁(SYSTEM_BIND_PATH:801029)
            sb.append(spliter);
            // (公費2)本人負担額5桁(SYSTEM_BIND_PATH:801030)
            sb.append(spliter);
            // (公費3)負担額合計6桁(SYSTEM_BIND_PATH:801031)
            sb.append(spliter);
            // (公費3)請求額6桁(SYSTEM_BIND_PATH:801032)
            sb.append(spliter);
            // (公費3)本人負担額5桁(SYSTEM_BIND_PATH:801033)
            sb.append("\"");
        }
        
        return sb.toString();
    }

    /**
     * 「社会福祉法人軽減額情報レコードデータ作成」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public String makeReductionRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 以下の文字列をカンマ区切りで生成する。
        // 交換情報識別番号4桁(SYSTEM_BIND_PATH:901001)
        sb.append("\"");
        sb.append(map.get("901001"));
        sb.append(spliter);
        // レコード種別コード2桁(SYSTEM_BIND_PATH:901002)
        sb.append(getData(map,"901002"));
        sb.append(spliter);
        // サービス提供年月6桁(YYYYMM)(SYSTEM_BIND_PATH:901003)
        sb.append(getData(map,"901003"));
        sb.append(spliter);
        // 事業所番号10桁(SYSTEM_BIND_PATH:901004)
        sb.append(getData(map,"901004"));
        sb.append(spliter);
        // 証記載保険者番号8桁(SYSTEM_BIND_PATH:901005)
        //sb.append(getData(map,"901005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"901005"),0)));
        sb.append(spliter);
        // 被保険者番号10桁(SYSTEM_BIND_PATH:901006)
        sb.append(getData(map,"901006"));
        sb.append(spliter);
        // 軽減率4桁(SYSTEM_BIND_PATH:901007)
        //sb.append(getTanka(getData(map,"901007")));
        sb.append(getData(map,"901007"));
        sb.append(spliter);
        // サービス種類コード2桁(SYSTEM_BIND_PATH:901008)
        sb.append(getData(map,"901008"));
        sb.append(spliter);
        // 受領すべき利用者負担の総額8桁(SYSTEM_BIND_PATH:901009)
        sb.append(getData(map,"901009"));
        sb.append(spliter);
        // 軽減額8桁(SYSTEM_BIND_PATH:901010)
        sb.append(getData(map,"901010"));
        sb.append(spliter);
        // 軽減後利用者負担額8桁(SYSTEM_BIND_PATH:901011)
        sb.append(getData(map,"901011"));
        sb.append(spliter);
        // 備考20桁(SYSTEM_BIND_PATH:901012)
        sb.append(getData(map,"901012"));
        sb.append("\"");
        
        return sb.toString();
    }
    
    /**
     * 「給付管理のCSVファイル作成」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public String makeCarePlanCSV(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        //以下の文字列をカンマ区切りで生成する。
        // 交換情報識別番号4桁(平成18年4月以前8121固定　平成18年4月以降8122、もしくは8123)
        sb.append("\"");
        sb.append(getData(map,"1001001"));
        sb.append(spliter);
        // 事業所番号10桁
        sb.append(getData(map,"1001002"));
        sb.append(spliter);
        // 指定/基準該当等事業所区分コード1桁　1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 5-地域密着型サービス
        sb.append(getData(map,"1001003"));
        sb.append(spliter);
        // サービス提供年月6桁(YYYYMM)
        sb.append(getData(map,"1001004"));
        sb.append(spliter);
        // 証記載保険者番号8桁
        sb.append(getData(map,"1001005"));
        //ここだけフォーマットしなくて良い
        //sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"1001005"),0)));
        sb.append(spliter);
        // 単位数単価4桁
        sb.append(getTanka(getData(map,"1001006")));
        sb.append(spliter);
        // 被保険者番号10桁
        sb.append(getData(map,"1001007"));
        sb.append(spliter);
        // 公費負担者番号8桁
        sb.append(getData(map,"1001008"));
        sb.append(spliter);
        // 公費受給者番号7桁
        sb.append(getData(map,"1001009"));
        sb.append(spliter);
        // 被保険者生年月日8桁(YYYYMMDD)
        sb.append(getData(map,"1001010"));
        sb.append(spliter);
        // 性別コード1桁1-男 2-女
        sb.append(getData(map,"1001011"));
        sb.append(spliter);
        // 要介護状態区分コード2桁　01-非該当 11-要支援(経過的要介護) 12-要支援1 13-要支援2 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
        sb.append(getData(map,"1001012"));
        sb.append(spliter);
        // 認定有効期間(開始)8桁(YYYYMMDD)
        sb.append(getData(map,"1001013"));
        sb.append(spliter);
        // 認定有効期間(終了)8桁(YYYYMMDD)
        sb.append(getData(map,"1001014"));
        sb.append(spliter);
        
        // 居宅サービス計画作成依頼届出年月日8桁(YYYYMMDD)
        sb.append(getData(map,"1001015"));
        sb.append(spliter);
        
    	//サービス計画費明細行番号
    	sb.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("1001024"),0)));
    	sb.append(spliter);
    	//サービスコード
        sb.append(getData(map,"1001016"));
        sb.append(spliter);
        //単位数
        sb.append(getData(map,"1001025"));
        sb.append(spliter);
        //回数
        sb.append(getData(map,"1001026"));
        sb.append(spliter);
        //サービス単位数
        sb.append(getData(map,"1001017"));
        sb.append(spliter);
        //サービス単位数合計
        sb.append(getData(map,"1001027"));
        sb.append(spliter);
        
        // 請求金額6桁
        sb.append(getData(map,"1001018"));
        sb.append(spliter);
        // 担当介護支援専門員番号(交換情報識別番号が8122の場合、必須)
        sb.append(getData(map,"1001022"));
        sb.append(spliter);
        // 摘要
        sb.append(getData(map,"1001023"));
        sb.append("\"");
        
        return sb.toString();

    }

    /**
     * 「給付管理のCSVファイル作成」に関する処理を行ないます。
     * @throws Exception 処理例外
     */
    public String makeSupplyManagementCSV(VRMap map, Date claimTargetDate) throws Exception {
        
        StringBuilder sb = new StringBuilder();
        
        //以下の文字列をカンマ区切りで生成する。
        // 交換情報識別番号4桁(平成18年4月以前8221固定　平成18年4月以降8222固定)
        sb.append("\"");
        sb.append(getData(map,"1201001"));
        sb.append(spliter);
        // 対象年月6桁(YYYYMM)
        sb.append(getData(map,"1201002"));
        sb.append(spliter);
        // 証記載保険者番号8桁
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"1201003"),0)));
        sb.append(spliter);
        // 事業所番号10桁(居宅介護支援事業所、もしくは介護予防支援事業所)
        sb.append(getData(map,"1201004"));
        sb.append(spliter);
        // 給付管理票情報作成区分コード1桁　1-新規 2-修正 3-取消
        sb.append(getData(map,"1201005"));
        sb.append(spliter);
        // 給付管理票作成年月日8桁(YYYYMMDD)
        sb.append(VRDateParser.format(claimTargetDate,"yyyyMMdd"));
        sb.append(spliter);
        // 給付管理票種別区分コード1桁　1-訪問通所サービス給付管理票 2-短期入所サービス給付管理票 3-居宅サービス区分給付管理票
        sb.append(getData(map,"1201007"));
        sb.append(spliter);
        // 給付管理票明細行番号2桁
        //sb.append(getData(map,"1201008"));
        sb.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("1201008"),0)));
        sb.append(spliter);
        // 被保険者番号10桁
        sb.append(getData(map,"1201009"));
        sb.append(spliter);
        // 被保険者生年月日8桁(YYYYMMDD)
        sb.append(getData(map,"1201010"));
        sb.append(spliter);
        // 性別コード1桁　1-男 2-女
        sb.append(getData(map,"1201011"));
        sb.append(spliter);
        // 要介護状態区分コード2桁　01-非該当 11-要支援(経過的要介護) 12-要支援1 13-要支援2 21-要介護1 22-要介護2 23-要介護3 24-要介護4 25-要介護5
        sb.append(getData(map,"1201012"));
        sb.append(spliter);
        // 限度額適用期間(開始)6桁(YYYYMM)
        sb.append(getData(map,"1201013"));
        sb.append(spliter);
        // 限度額適用期間(終了)6桁(YYYYMM)
        sb.append(getData(map,"1201014"));
        sb.append(spliter);
        
        // 居宅・介護予防支給限度額6桁
        sb.append(getData(map,"1201015"));
        sb.append(spliter);
        // 居宅サービス計画作成区分コード1桁　1-居宅介護支援事業所作成　2-自己作成　3-介護予防支援事業所作成
        sb.append(getData(map,"1201016"));
        sb.append(spliter);
        // 事業所番号(サービス事業所)10桁
        sb.append(getData(map,"1201017"));
        sb.append(spliter);
        // 指定/基準該当等事業所区分コード1桁　1-指定事業所 2-基準該当事業所 3-相当サービス事業所 4-その他 5-地域密着型サービス
        sb.append(getData0Rep(map,"1201018"));
        sb.append(spliter);
        // サービス種類コード2桁
        sb.append(getData(map,"1201019"));
        sb.append(spliter);
        // 給付計画単位数/日数6桁
        sb.append(getData0Rep(map,"1201020"));
        sb.append(spliter);
        // 限度額管理期間における前月までの給付計画日数3桁
        sb.append(getData(map,"1201021"));
        sb.append(spliter);
        // 指定サービス分小計6桁
        sb.append(getData(map,"1201022"));
        sb.append(spliter);
        // 基準該当サービス分小計6桁
        sb.append(getData(map,"1201023"));
        sb.append(spliter);
        // 給付計画合計単位数/日数6桁
        sb.append(getData0Rep(map,"1201024"));
        sb.append(spliter);
        // 担当介護支援専門員番号
        sb.append(getData(map,"1201025"));
        sb.append(spliter);
        // 委託先の居宅介護支援事業所番号
        sb.append(getData(map,"1201026"));
        sb.append(spliter);
        // 委託先の担当介護支援専門員番号
        sb.append(getData(map,"1201027"));
        sb.append("\"");
        
        return sb.toString();

    }
    
    
    /**
     * 「緊急時施設療養情報レコードデータ文字列作成」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public String makeEmergencyOwnFacilityRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 以下の文字列をカンマ区切りで生成する。
        // 交換情報識別番号4桁(SYSTEM_BIND_PATH:1701001)
        sb.append("\"");
        sb.append(getData(map,"1701001"));
        sb.append(spliter);
        // レコード種別コード2桁(SYSTEM_BIND_PATH:1701002)
        sb.append(getData(map,"1701002"));
        sb.append(spliter);
        // サービス提供年月6桁(YYYYMM)(SYSTEM_BIND_PATH:1701003)
        sb.append(getData(map,"1701003"));
        sb.append(spliter);
        // 事業所番号10桁(SYSTEM_BIND_PATH:1701004)
        sb.append(getData(map,"1701004"));
        sb.append(spliter);
        // 証記載保険者番号8桁(SYSTEM_BIND_PATH:1701005)
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"1701005"),0)));
        sb.append(spliter);
        // 被保険者番号10桁(SYSTEM_BIND_PATH:1701006)
        sb.append(getData(map,"1701006"));
        sb.append(spliter);
        // 緊急時施設療養情報レコード順次番号2桁(SYSTEM_BIND_PATH:1701007)
        sb.append(continuousnessFormat.format(ACCastUtilities.toLong(map.get("1701007"))));
        sb.append(spliter);
        // 緊急時傷病名1 40桁(SYSTEM_BIND_PATH:1701008)
        sb.append(getData(map,"1701008"));
        sb.append(spliter);
        // 緊急時傷病名2 40桁(SYSTEM_BIND_PATH:1701009)
        sb.append(getData(map,"1701009"));
        sb.append(spliter);
        // 緊急時傷病名3 40桁(SYSTEM_BIND_PATH:1701010)
        sb.append(getData(map,"1701010"));
        sb.append(spliter);
        // 緊急時治療開始年月日1 8桁(YYYYMMDD)(SYSTEM_BIND_PATH:1701011)
        sb.append(getData(map,"1701011"));
        sb.append(spliter);
        // 緊急時治療開始年月日2 8桁(YYYYMMDD)(SYSTEM_BIND_PATH:1701012)
        sb.append(getData(map,"1701012"));
        sb.append(spliter);
        // 緊急時治療開始年月日3 8桁(YYYYMMDD)(SYSTEM_BIND_PATH:1701013)
        sb.append(getData(map,"1701013"));
        sb.append(spliter);
        // 往診日数2桁(SYSTEM_BIND_PATH:1701014)
        sb.append(getData(map,"1701014"));
        sb.append(spliter);
        // 往診医療機関名40桁(SYSTEM_BIND_PATH:1701015)
        sb.append(getData(map,"1701015"));
        sb.append(spliter);
        // 通院日数2桁(SYSTEM_BIND_PATH:1701016)
        sb.append(getData(map,"1701016"));
        sb.append(spliter);
        // 通院医療機関名40桁(SYSTEM_BIND_PATH:1701017)
        sb.append(getData(map,"1701017"));
        sb.append(spliter);
        // 緊急時治療管理単位数6桁(SYSTEM_BIND_PATH:1701018)
        sb.append(getData(map,"1701018"));
        sb.append(spliter);
        // 緊急時治療管理日数2桁(SYSTEM_BIND_PATH:1701019)
        sb.append(getData(map,"1701019"));
        sb.append(spliter);
        // 緊急時治療管理小計7桁(SYSTEM_BIND_PATH:1701020)
        sb.append(getData(map,"1701020"));
        sb.append(spliter);
        // リハビリテーション点数7桁(SYSTEM_BIND_PATH:1701021)
        sb.append(getData(map,"1701021"));
        sb.append(spliter);
        // 処置点数7桁(SYSTEM_BIND_PATH:1701022)
        sb.append(getData(map,"1701022"));
        sb.append(spliter);
        // 手術点数7桁(SYSTEM_BIND_PATH:1701023)
        sb.append(getData(map,"1701023"));
        sb.append(spliter);
        // 麻酔点数7桁(SYSTEM_BIND_PATH:1701024)
        sb.append(getData(map,"1701024"));
        sb.append(spliter);
        // 放射線治療点数7桁(SYSTEM_BIND_PATH:1701025)
        sb.append(getData(map,"1701025"));
        sb.append(spliter);
        // 摘要1 64桁(SYSTEM_BIND_PATH:1701026)
        sb.append(getData(map,"1701026"));
        sb.append(spliter);
        // 摘要2 64桁(SYSTEM_BIND_PATH:1701027)
        sb.append(getData(map,"1701027"));
        sb.append(spliter);
        // 摘要3 64桁(SYSTEM_BIND_PATH:1701028)
        sb.append(getData(map,"1701028"));
        sb.append(spliter);
        // 摘要4 64桁(SYSTEM_BIND_PATH:1701029)
        sb.append(getData(map,"1701029"));
        sb.append(spliter);
        // 摘要5 64桁(SYSTEM_BIND_PATH:1701030)
        sb.append(getData(map,"1701030"));
        sb.append(spliter);
        // 摘要6 64桁(SYSTEM_BIND_PATH:1701031)
        sb.append(getData(map,"1701031"));
        sb.append(spliter);
        // 摘要7 64桁(SYSTEM_BIND_PATH:1701032)
        sb.append(getData(map,"1701032"));
        sb.append(spliter);
        // 摘要8 64桁(SYSTEM_BIND_PATH:1701033)
        sb.append(getData(map,"1701033"));
        sb.append(spliter);
        // 摘要9 64桁(SYSTEM_BIND_PATH:1701034)
        sb.append(getData(map,"1701034"));
        sb.append(spliter);
        // 摘要10 64桁(SYSTEM_BIND_PATH:1701035)
        sb.append(getData(map,"1701035"));
        sb.append(spliter);
        // 摘要11 64桁(SYSTEM_BIND_PATH:1701036)
        sb.append(getData(map,"1701036"));
        sb.append(spliter);
        // 摘要12 64桁(SYSTEM_BIND_PATH:1701037)
        sb.append(getData(map,"1701037"));
        sb.append(spliter);
        // 摘要13 64桁(SYSTEM_BIND_PATH:1701038)
        sb.append(getData(map,"1701038"));
        sb.append(spliter);
        // 摘要14 64桁(SYSTEM_BIND_PATH:1701039)
        sb.append(getData(map,"1701039"));
        sb.append(spliter);
        // 摘要15 64桁(SYSTEM_BIND_PATH:1701040)
        sb.append(getData(map,"1701040"));
        sb.append(spliter);
        // 摘要16 64桁(SYSTEM_BIND_PATH:1701041)
        sb.append(getData(map,"1701041"));
        sb.append(spliter);
        // 摘要17 64桁(SYSTEM_BIND_PATH:1701042)
        sb.append(getData(map,"1701042"));
        sb.append(spliter);
        // 摘要18 64桁(SYSTEM_BIND_PATH:1701043)
        sb.append(getData(map,"1701043"));
        sb.append(spliter);
        // 摘要19 64桁(SYSTEM_BIND_PATH:1701044);
        sb.append(getData(map,"1701044"));
        sb.append(spliter);
        // 摘要20 64桁(SYSTEM_BIND_PATH:1701045)
        sb.append(getData(map,"1701045"));
        sb.append(spliter);
        // 緊急時施設療養費合計点数8桁(SYSTEM_BIND_PATH:1701046)
        sb.append(getData(map,"1701046"));
        sb.append(spliter);
        // 自施設療養費傷病名1 40桁(SYSTEM_BIND_PATH:1701047)
        sb.append(getData(map,"1701047"));
        sb.append(spliter);
        // 自施設療養費傷病名2 40桁(SYSTEM_BIND_PATH:1701048)
        sb.append(getData(map,"1701048"));
        sb.append(spliter);
        // 自施設療養費傷病名3 40桁(SYSTEM_BIND_PATH:1701049)
        sb.append(getData(map,"1701049"));
        sb.append(spliter);
        // 自施設療養費開始年月日1 8桁(YYYYMMDD)(SYSTEM_BIND_PATH:1701050)
        sb.append(getData(map,"1701050"));
        sb.append(spliter);
        // 自施設療養費開始年月日2 8桁(YYYYMMDD)(SYSTEM_BIND_PATH:1701051)
        sb.append(getData(map,"1701051"));
        sb.append(spliter);
        // 自施設療養費開始年月日3 8桁(YYYYMMDD)(SYSTEM_BIND_PATH:1701052)
        sb.append(getData(map,"1701052"));
        sb.append(spliter);
        // 自施設療養費単位数6桁(SYSTEM_BIND_PATH:1701053)
        sb.append(getData(map,"1701053"));
        sb.append(spliter);
        // 自施設療養費日数2桁(SYSTEM_BIND_PATH:1701054)
        sb.append(getData(map,"1701054"));
        sb.append(spliter);
        // 自施設療養費小計7桁(SYSTEM_BIND_PATH:1701055)
        sb.append(getData(map,"1701055"));
        
        sb.append("\"");
        
        return sb.toString();
    }
    
 // 2014/12/24 [Yoichiro Kamei] add - begin 住所地特例対応
    /**
     * 「明細情報（住所地特例）レコードデータ文字列作成」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public String makeDetailJushotiTokureiRecord(VRMap map) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 以下の文字列をカンマ区切りで生成する。
        // 交換情報識別番号4桁(SYSTEM_BIND_PATH:1801001)
        sb.append("\"");
        sb.append(getData(map,"1801001"));
        sb.append(spliter);
        // レコード種別コード2桁(SYSTEM_BIND_PATH:1801002)
        sb.append(getData(map,"1801002"));
        sb.append(spliter);
        // サービス提供年月6桁(YYYYMM)(SYSTEM_BIND_PATH:1801003)
        sb.append(getData(map,"1801003"));
        sb.append(spliter);
        // 事業所番号10桁(SYSTEM_BIND_PATH:1801004)
        sb.append(getData(map,"1801004"));
        sb.append(spliter);
        // 証記載保険者番号8桁(SYSTEM_BIND_PATH:1801005)
        //sb.append(getData(map,"1801005"));
        sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"1801005"),0)));
        sb.append(spliter);
        // 被保険者番号10桁(SYSTEM_BIND_PATH:1801006)
        sb.append(getData(map,"1801006"));
        sb.append(spliter);
        // サービス種類コード2桁(SYSTEM_BIND_PATH:1801007)
        sb.append(getData(map,"1801007"));
        sb.append(spliter);
        // サービス項目コード4桁(SYSTEM_BIND_PATH:1801008)
        sb.append(getData(map,"1801008"));
        sb.append(spliter);
        //単位数を記載しないサービスでない場合、単位数を出力する。
        if(!QP001SpecialCase.isUnitNoCountService(getData(map,"1801007"),getData(map,"1801008"))){
            // 単位数4桁(SYSTEM_BIND_PATH:1801009)
            sb.append(getData(map,"1801009"));
        }
        sb.append(spliter);
        // 日数･回数2桁(SYSTEM_BIND_PATH:1801010)
        sb.append(getData(map,"1801010"));
        sb.append(spliter);
        // 公費1対象日数・回数2桁(SYSTEM_BIND_PATH:1801011)
        sb.append(getData(map,"1801011"));
        sb.append(spliter);
        // 公費2対象日数・回数2桁(SYSTEM_BIND_PATH:1801012)
        sb.append(getData(map,"1801012"));
        sb.append(spliter);
        // 公費3対象日数・回数2桁(SYSTEM_BIND_PATH:1801013)
        sb.append(getData(map,"1801013"));
        sb.append(spliter);
        // サービス単位数6桁(SYSTEM_BIND_PATH:1801014)
        sb.append(getData(map,"1801014"));
        sb.append(spliter);
        // 公費1対象サービス単位数6桁(SYSTEM_BIND_PATH:1801015)
        sb.append(getData(map,"1801015"));
        sb.append(spliter);
        // 公費2対象サービス単位数6桁(SYSTEM_BIND_PATH:1801016)
        sb.append(getData(map,"1801016"));
        sb.append(spliter);
        // 公費3対象サービス単位数6桁(SYSTEM_BIND_PATH:1801017)
        sb.append(getData(map,"1801017"));
        sb.append(spliter);
        // 施設所在保険者番号6桁(SYSTEM_BIND_PATH:1801018)
        sb.append(getData(map,"1801018"));
        //sb.append(insureNoFormat.format(ACCastUtilities.toLong(getData(map,"1801018"),0)));
        sb.append(spliter);
        // 摘要20桁(SYSTEM_BIND_PATH:1801019)
        sb.append(getData(map,"1801019"));
        sb.append("\"");
        
        return sb.toString();
    }
 // 2014/12/24 [Yoichiro Kamei] add - end 
    
    private String getData0Rep(VRMap map,String key) throws Exception {
        String result = getData(map,key);
        if((result == null) || ("0".equals(result))){
            result = "";
        }
        return result;
    }
    
    /**
     * CSV出力用の文字列に変換する。
     * @param map
     * @param key
     * @return
     * @throws Exception
     */
    private String getData(VRMap map,String key) throws Exception {
        String result = "";
        if(!map.containsKey(key)){
            VRLogger.warning("CSV出力：MAPに存在しないキーが指定されました。:" + key);
        } else {
            if(map.get(key) != null){
                result = String.valueOf(map.get(key));
                if("null".equalsIgnoreCase(result)){
                    result = "";
                }
            }
        }
        return result;
    }
    
    /**
     * 12.34型式の値の.を抜いて、1234に変更します。
     * 5.67型式の場合は先頭に空白をいれて567を返却します。
     * @param value
     * @return
     * @throws Exception
     */
    protected String getTanka(Object value) throws Exception {
        if (ACTextUtilities.isNullText(value))
            return "";
        String[] temp = ACCastUtilities.toString(value).split("\\.");
        temp[0] = pad(temp[0], 2);
        if (temp.length == 1)
            return temp[0] + "00";
        
        switch(temp[1].length()){
        case 0:
            temp[1] = "00";
            break;
        case 1:
            temp[1] += "0";
            break;
        }

        return temp[0] + temp[1];

    }
    

    /**
     * 文字列の先頭に空白文字を挿入し、引数で指定された文字数にして返却します。
     * 引数が0の場合は空白に置換されます。
     * @param value 対象文字列
     * @param pad 求める文字数
     * @return 空白を挿入した文字列
     * @throws Exception
     */
    protected String pad(Object value, int pad) throws Exception {
        if (ACTextUtilities.isNullText(value))
            return "";
        String temp = ACCastUtilities.toString(value);
        if ("0".equals(temp))
            return "";
        StringBuilder padString = new StringBuilder();
        for (int i = 0; i < pad - temp.length(); i++) {
            padString.append(" ");
        }
        return padString.toString() + temp;
    }
    
    private class CSVData {
        private QP001Style1 style1 = null;
        private List csvList = new ArrayList();
        
        public CSVData(QP001Manager manager) {
            this.style1 = new QP001Style1(manager);
        }
        
        public QP001Style1 getTotalObject() {
            return style1;
        }
        
        public List getCSVList() {
            return csvList;
        }
    }
    
    /**
     * 指定されているソートキー順に辞書順でソートする
     */
    private class StringComparator implements java.util.Comparator {
        public int compare(Object object1, Object object2) {
            String value1 = "";
            String value2 = "";
            try{
                value1 = ((String[])object1)[0];
                value2 = ((String[])object2)[0];
            } catch(Exception e){
                VRLogger.warning(e);
            }
            
            return value1.compareTo(value2);
        }
    }
    
}
