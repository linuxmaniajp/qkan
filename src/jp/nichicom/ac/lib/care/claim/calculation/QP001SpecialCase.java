
/*
 * Project code name "ORCA"
 * ‹‹•tŠÇ—‘ä’ ƒ\ƒtƒg QKANCHOiJMA care benefit management softwarej
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
 * ƒAƒvƒŠ: QKANCHO
 * ŠJ”­Ò: “¡Œ´@L
 * ì¬“ú: 2006/01/24  “ú–{ƒRƒ“ƒsƒ…[ƒ^[Š”®‰ïĞ “¡Œ´@L V‹Kì¬
 * XV“ú: ----/--/--
 * ƒVƒXƒeƒ€ ‹‹•tŠÇ—‘ä’  (Q)
 * ƒTƒuƒVƒXƒeƒ€ ¿‹‘o—Í (P)
 * ƒvƒƒZƒX ¿‹ˆ— (001)
 * ƒvƒƒOƒ‰ƒ€ ¿‹‘“Á—áˆ—ƒNƒ‰ƒX (QP001SpecialCase)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

public class QP001SpecialCase {
    
    //¶•ÛŒÀ“xŠz
    private static final int SEIHO_SELF_PAY = 15000;
    
    //–¾×î•ñƒŒƒR[ƒhƒVƒŠƒAƒ‹”Ô†
    private static int DETAIL_SERIAL = 0;
    
    /**
     * w’è‚³‚ê‚½¯•Ê”Ô†‚ª{İŒn‚Ì¿‹‚Å‚ ‚é‚©”»•Ê‚·‚éB
     * @param discriminationNo —l®¯•Ê”Ô†
     * @return true:{İŒn‚Å‚ ‚é(—l®‘æ”ªA‘æ‹ãA‘æ\) false:{İŒn‚Å‚Í‚È‚¢
     * @throws Exception
     */
    public static boolean isShisetsuDiscriminationNo(String discriminationNo) throws Exception {
        //ˆÈ‰º‚Ì‚¢‚¸‚ê‚©‚ÌŒğŠ·¯•Ê”Ô†‚ªŠÜ‚Ü‚ê‚Ä‚¢‚ê‚ÎA{İŒn‚Ì¿‹‚Æ‚İ‚È‚·B
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * w’è‚³‚ê‚½¯•Ê”Ô†‚Ì’ •[‚É‹‘îƒT[ƒrƒXŒv‰æì¬‹æ•ª‚ª•K—v‚Å‚ ‚é‚©B
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isServicePlanMakerLiving(String discriminationNo) throws Exception {
        //7171,7173,7183,7193,71A3(—l®‘æ˜ZA˜Z‚ÌOA”ªA‹ãA\‚Ìê‡)‚ÍA
        //‹‘îƒT[ƒrƒXŒv‰æì¬‹æ•ª‚Í•K—v‚È‚¢B
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return true;
    	
    }
    
    
    /**
     * w’è‚³‚ê‚½¯•Ê”Ô†‚Í“üŠ(‰@)‘O‚Ìó‘ÔƒR[ƒh‚Ì‘O‰ñî•ñˆøŒp‚¬‚ğs‚¤‚©
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isAdmissionStatusCodeTakeover(String discriminationNo) throws Exception {
        //—l®‚ª‘æ˜Z`˜Z‚ÌlA”ªA‹ãA\‚ÉŒÀ‚é
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * w’è‚³‚ê‚½¯•Ê”Ô†‚ÍA“Á’èf—Ã”ï‚ğŠÜ‚Ş‚©
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isIncludingDiagnosis(String discriminationNo) throws Exception {
        //—l®‚ª‘ælAl‚Ì“ñAŒÜAŒÜ‚Ì“ñA‹ãA\‚Ìê‡
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        return false;
    }
    
    /**
     * w’è‚³‚ê‚½¯•Ê”Ô†‚ÍAƒVƒ‡[ƒgƒXƒeƒC‚Å‚ ‚é‚©
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isShortStay(String discriminationNo) throws Exception {
        //¡—l®‘æOA‘ælA‘æŒÜA‘æ˜Z‚ÌŒÜA˜Z‚Ì˜ZA˜Z‚Ìµ‚Ìê‡
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * w’è‚³‚ê‚½¯•Ê”Ô†‚ÍA{İ‚Å‚ ‚é‚©
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isLongStay(String discriminationNo) throws Exception {
        //¡—l®‘æ˜Z‚Æ‘æ˜Z‚ÌOA—l®”ª‚©‚ç\‚Ìê‡
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * —l®‘æ“ñ‚©‚ç—l®‘æ\‚Ì¯•Ê”Ô†‚ğ•Ô‚·
     * @return
     */
    public static String getPerformanceCodes() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_3_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_4_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_5_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_7_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_7_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_8_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_9_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_10_201204);
        
        return sb.toString();
    }
    
    /**
     * —l®‘æ\ˆê‚Ì¯•Ê”Ô†‚ğ•Ô‚·
     * @return
     */
    public static String getBenefitManagementCodes() {
        return "8222,8221";
    }
    
    /**
     * w’è‚³‚ê‚½¯•Ê”Ô†‚ÍAƒT[ƒrƒXÀ“ú”‚ğo—Í‚·‚é‚©
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isOutRealDay(String discriminationNo) throws Exception {
        //—l®‘æ“ñA‘æ“ñ‚Ì“ñA‘æOA‘æO‚Ì“ñA‘ælA‘æl‚Ì“ñA‘æŒÜA‘æŒÜ‚Ì“ñA‘æ˜Z‚ÌŒÜA‘æ˜Z‚Ì˜Z
        //return ("7131,7132,7143,7144,7153,7154,7164,7165,7175,7176,7155,7156".indexOf(discriminationNo) != -1);
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(discriminationNo)) {
            return true;
        }
        return false;
    }
    
    
    /**
     * w’è‚³‚ê‚½¯•Ê”Ô†‚ÍAŒÀ“xŠzŠÇ—‘ÎÛŠO’PˆÊ”‚ğo—Í‚·‚é‚©
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isOutLimitUncontrolledUnit(String discriminationNo) throws Exception {
        //—l®‘æ“ñA“ñ‚Ì“ñAOAO‚Ì“ñAlAl‚Ì“ñAŒÜAŒÜ‚Ì“ñ
        //return ("7131,7132,7143,7144,7153,7154,7164,7165,7155,7156".indexOf(discriminationNo) != -1);
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(discriminationNo)) {
            return true;
        }
        return false;
    }
    
    
    /**
     * ˆø”‚Éw’è‚³‚ê‚½”í•ÛŒ¯Ò”Ô†‚©‚ç¶•Û’P“Æó‹‹Ò‚Å‚ ‚é‚©”»’f‚·‚éB
     * @param insurerdNo ”í•ÛŒ¯Ò”Ô†
     * @return true:¶•Û’P“Æ false:¶•Û’P“Æ‚Å‚Í‚È‚¢
     * @throws Exception
     */
    public static boolean isSeihoOnly(String insurerdNo) throws Exception {
        if(insurerdNo == null){
            return false;
        }
        //”í•ÛŒ¯Ò”Ô†‚ªH‚©‚çn‚Ü‚Á‚Ä‚¢‚ê‚Î¶•Û’P“Æ‚Æ‚İ‚È‚·B
        return insurerdNo.toUpperCase().startsWith("H");
        
    }
    
    /**
     * ƒT[ƒrƒX‚Ìí—Ş‚ğ”»’f‚·‚éB
     * @param serviceCode@ƒT[ƒrƒXƒR[ƒh
     * @return
     * 1:H”ï<br>
     * 2:ƒ†ƒjƒbƒgŒ^ŒÂº<br>
     * 3:ƒ†ƒjƒbƒgŒ^€ŒÂº<br>
     * 4:]—ˆŒ^ŒÂº(“Á—{“™)<br>
     * 5:]—ˆŒ^ŒÂº(˜VŒ’E—Ã—{“™)<br>
     * 6:‘½°º
     * @throws Exception
     */
    public static int getServiceKind(VRMap serviceCode) throws Exception {
        int result = 0;
        
        if(serviceCode == null){
            return result;
        }
        
        //•aº‹æ•ª
        
        //‰ÁZí•Ê‚Å•ªŠò
        switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_TYPE"), 0)) {
        //H”ï
        case 2:
            result = 1;
            break;
            
        //‹Z”ï
        case 3:
            //‹Z”ï‚Ìê‡‚ÍA•aº‹æ•ª‚ğæ“¾
            switch(ACCastUtilities.toInt(serviceCode.get("ROOM_TYPE"), 0)) {
            case 1: // 1-]—ˆŒ^ŒÂºi“Á—{“™j
                result = 4;
                break;
            case 2: // 2-]—ˆŒ^ŒÂºi˜VŒ’E—Ã—{“™j
                result = 5;
                break;
            case 3: // 3-‘½°º
                result = 6;
                break;
            case 4: // 4-ƒ†ƒjƒbƒgŒ^ŒÂº
                result = 2;
                break;
            case 5: // 5-ƒ†ƒjƒbƒgŒ^€ŒÂº
                result = 3;
                break;
            }
            
            break;
        
        }
        
        return result;
    }
    
    /**
     * ƒT[ƒrƒX‚Ìí—Ş‚ğ”»’f‚·‚éB
     * @param serviceCodeItem 
     * @return
     * 1:H”ï<br>
     * 2:ƒ†ƒjƒbƒgŒ^ŒÂº<br>
     * 3:ƒ†ƒjƒbƒgŒ^€ŒÂº<br>
     * 4:]—ˆŒ^ŒÂº(“Á—{“™)<br>
     * 5:]—ˆŒ^ŒÂº(˜VŒ’E—Ã—{“™)<br>
     * 6:‘½°º
     * @throws Exception
     */
    /*
    public static int getServiceKind(int serviceCodeItem) throws Exception {
        int result = 0;
        //ƒT[ƒrƒXƒR[ƒhí—Ş‚Å‘ÎÛƒT[ƒrƒX‚ğ”»’è‚·‚éB
        switch(serviceCodeItem){
            //H”ï
            case 2111:
            case 2211:
            case 2311:
            case 5111:
            case 5211:
            case 5311:
            case 5411:
            //—\–h‘Î‰ŠJn
            case 2411:
            case 2511:
            case 2611:
            //—\–h‘Î‰I—¹
                result = 1;
                break;
                
            //ƒ†ƒjƒbƒgŒ^ŒÂº
            case 2121:
            case 2221:
            case 2321:
            case 5121:
            case 5221:
            case 5321:
            case 5421:
            //—\–h‘Î‰ŠJn
            case 2421:
            case 2521:
            case 2621:
            //—\–h‘Î‰I—¹
                result = 2;
                break;
                
            //ƒ†ƒjƒbƒgŒ^€ŒÂº
            case 2122:
            case 2222:
            case 2322:
            case 5122:
            case 5222:
            case 5322:
            case 5422:
            //—\–h‘Î‰ŠJn
            case 2422:
            case 2522:
            case 2622:
            //—\–h‘Î‰I—¹
                result = 3;
                break;
                
            //]—ˆŒ^ŒÂº(“Á—{“™)
            case 2123:
            case 5123:
            //[ID:0000645][Shin Fujihara] 2011/04/20 add begin 2010”N“x‘Î‰
            //’nˆæ–§’…Œ^‰îŒì•Ÿƒ{İ-]—ˆŒ^ŒÂº‚ğ
            //]—ˆŒ^ŒÂº(˜VŒ’E—Ã—{“™)‚©‚ç]—ˆŒ^ŒÂº(“Á—{“™)‚ÖˆÚ“®
            case 5423:
            //[ID:0000645][Shin Fujihara] 2011/04/20 add end 2010”N“x‘Î‰
            //—\–h‘Î‰ŠJn
            case 2423:
            //—\–h‘Î‰I—¹
                result = 4;
                break;
                
            //]—ˆŒ^ŒÂº(˜VŒ’E—Ã—{“™)
            case 2223:
            case 2323:
            case 5223:
            case 5323:
            //[ID:0000645][Shin Fujihara] 2011/04/20 edit begin 2010”N“x‘Î‰
            //’nˆæ–§’…Œ^‰îŒì•Ÿƒ{İ-]—ˆŒ^ŒÂº‚Í]—ˆŒ^ŒÂº(“Á—{“™)‚ª³‚µ‚¢
            //case 5423:
            //[ID:0000645][Shin Fujihara] 2011/04/20 edit end 2010”N“x‘Î‰
            //—\–h‘Î‰ŠJn
            case 2523:
            case 2623:
            //—\–h‘Î‰I—¹
                result = 5;
                break;
            //‘½°º
            case 2124:
            case 2224:
            case 2324:
            case 5124:
            case 5224:
            case 5324:
            case 5424:
            //—\–h‘Î‰ŠJn
            case 2424:
            case 2524:
            case 2624:
            //—\–h‘Î‰I—¹
                result = 6;
                break;
        }
        
        return result;
    }
    */
    
    /**
     * Œö”ï©ŒÈ•‰’SŠz‚ÅÀÛ‚Ég—p‰Â”\‚È‹àŠz‚ğæ“¾‚·‚éB<BR>
     * <br>
     * {İŒnƒT[ƒrƒX‚Ìê‡A”í•ÛŒ¯Ò‚Å‚ ‚é”í•ÛŒìÒ‚É‚©‚©‚é‰îŒìŒ”‚É‚æ‚é–{lx•¥Šz‚ÍA<br>
     * 15,000‚Ü‚Å‚ğ–{‘Ì•ñV‚É‚©‚©‚éŒö”ï–{l•‰’SŠz‚É[“–‚µAcŠz‚ª‚ ‚éê‡‚É‚Í‚»‚ÌŠz‚ğ“Á’è“üŠÒ<br>
     * ‰îŒìƒT[ƒrƒX”ï‚É‚¨‚¯‚éŒö”ï–{l•‰’SŠz‚É[“–‚·‚éB<br>
     * ‚È‚¨A¶Šˆ•ÛŒì’P“Æó‹‹Ò‚É‚¨‚¢‚Ä‚ÍA‰îŒì•ÛŒ¯{İ‚Ì“Á’è“üŠÒ‰îŒìƒT[ƒrƒX”ï‚ÍA<br>
     * ‘SŠzŒö”ï•‰’S‚Æ‚È‚éB<br>
     * i‚½‚¾‚µA‹Z”ï‚É‚©‚©‚é“Á’è“üŠÒ‰îŒìƒT[ƒrƒX”ï‚ÍA‹º‹æ•ª‚ª‘½°º‚Ì‚İ‘ÎÛ‚Æ‚È‚éj
     * 
     * @param discriminationNo ¯•Ê”Ô†
     * @param insurerdNo ”í•ÛŒ¯Ò”Ô†
     * @param selfPay Œö”ï©ŒÈ•‰’SŠz
     * @return g—p‰Â”\‚È©ŒÈ•‰’SŠz
     * @throws Exception
     */
    public static int convertSelfPay(String discriminationNo,String insurerdNo,int selfPay,String kohi,int kohiCost) throws Exception {
        //—l®‘æ”ªA‘æ‹ãA‘æ\‚Å‚È‚¯‚ê‚ÎŒö”ï©ŒÈ•‰’SŠz‚ğ•Ô‹p‚·‚éB
        if(!isShisetsuDiscriminationNo(discriminationNo)){
            return selfPay;
        }
        //¶•Û’P“Æ‚Å‚ ‚ê‚ÎŒö”ï©ŒÈ•‰’SŠz‚ğ•Ô‹p‚·‚éB
        if(isSeihoOnly(insurerdNo)){
            return selfPay;
        }
        //add start 2006.9.12 fujihara shin
        /* 
         * > Sent: Monday, September 11, 2006 2:07 PM
         * > Subject: Re: y‹‹ŠÇ’¹zŒö”ï•ª–{l•‰’S‚ÉãŒÀ‚ğİ‚¯‚é–@—ß‚É‚Â‚¢‚Ä
         * 
         * > ‡@¶•Û’P“Æ‚Ìê‡(”í•ÛŒ¯Ò”Ô†‚ªH‚©‚çn‚Ü‚éê‡)
         * > @¨ãŒÀ‚ğİ‚¯‚È‚¢
         * 
         * –â‘è‚ ‚è‚Ü‚¹‚ñB
         * 
         * > ‡A{İŒnƒT[ƒrƒXˆÈŠO‚Ìê‡
         * > @¨ãŒÀ‚ğİ‚¯‚È‚¢
         * 
         * –â‘è‚ ‚è‚Ü‚¹‚ñB
         * 
         * > ‡BŒö”ï‚Æ‚µ‚Ä¶•Û‚ªŠÜ‚Ü‚ê‚È‚¢ê‡
         * > @¨ãŒÀ‚ğİ‚¯‚È‚¢
         * 
         * Šî–{“I‚É‚Í¶•Ûó‹‹Ò‚Ì‚İ“K—p‚É‚È‚é‚æ‚¤‚Å‚·B
         * ‚µ‚©‚µA‘¼‚Ìó‹‹Ò‚Å“¯—l‚Ìæˆµ‚ğ‚µ‚Ä‚àA“Á‚É•Ô–ß‚É‚Í‚È‚ç‚È‚¢‚æ‚¤‚Å‚·B
         * ‚Æ‚è‚ ‚¦‚¸Au¶•Ûv‚Ì‚İ15000‰~‚ÌãŒÀ‚ğİ‚¯‚éŒ`‚ğ‹‹ŠÇ’¹‚Å‚Í
         * Ì—p‚µA•ÒW‚µ‚½‚¢ê‡‚Íu–¾×‘î•ñ•ÒW‰æ–Êv‚ÅC³‚ğ‚µ‚Ä‚à‚ç‚¤
         * ‚Æ‚¢‚¤•û–@‚É‚µ‚Ü‚µ‚å‚¤B
         * 
         * > ‡Cã‹L3Œ‚ÉŠY“–‚¹‚¸‚©‚Â“Á’è“ü‹Ò‰îŒìƒT[ƒrƒX”ï‚ª‚©‚©‚éê‡
         * > @¨ãŒÀ15,000‰~‚ğİ‚¯‚é
         * 
         * ‚±‚ê‚Í‹ï‘Ì“I‚É‚Í‚Ç‚¤‚¢‚¤‚±‚Æ‚Å‚µ‚å‚¤‚©B
         * 
         * •ÊŒ‚É‚È‚é‚©‚Æv‚¢‚Ü‚·‚ªA¶•Ûó‹‹Ò‚Å“Á’è“üŠÒ‰îŒìƒT[ƒrƒX”ï‚ª
         * ‚©‚©‚ç‚È‚¢ê‡‚É‚Â‚¢‚Ä‚ÍãŒÀ‚ğİ‚¯‚È‚¢‚Æ‚¢‚¤–‚Å‚¨Šè‚¢‚µ‚Ü‚·B 
         */
        if((kohi != null) && (kohi.startsWith("12"))){
        	//Œö”ï•¹—pó‹‹Ò
        	//“Á’è“üŠÒ‰îŒìƒT[ƒrƒX”ï‚ª‚©‚©‚éê‡
        	if(kohiCost > 0){
                //–â“š–³—p‚Å15000‚ğ•Ô‹p‚·‚éB
                if(selfPay > SEIHO_SELF_PAY){
                    return SEIHO_SELF_PAY;
                }
        	}
        }
        //add end 2006.9.12 fujihara shin
        
//        //–â“š–³—p‚Å15000‚ğ•Ô‹p‚·‚éB
//        if(selfPay < SEIHO_SELF_PAY){
//            return selfPay;
//        }
//        return SEIHO_SELF_PAY;
        return selfPay;
    }
    
    /**
     * ’PˆÊ”‚ğŒvã‚µ‚È‚¢ƒT[ƒrƒX‚Å‚ ‚é‚©Šm”F‚·‚éB
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isUnitNoCountService(String serviceCodeKind, String serviceCodeItem) throws Exception {
    	
    	// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - begin ƒT[ƒrƒXƒR[ƒh‰p”‰»‚É‚æ‚èŒÄ‚Î‚È‚¢‚æ‚¤‚É‚µ‚½
        //int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        //int item = ACCastUtilities.toInt(serviceCodeItem,0);
        //return isUnitNoCountService(kind,item);
    	// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - end
        
    	// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 add - begin ƒT[ƒrƒXƒR[ƒh‰p”‰»
    	String kind = serviceCodeKind;
    	String item = serviceCodeItem;
        boolean result = false;
        //–K–âŠÅŒì
        if ("13".equals(kind)) {
        	if ("3111".equals(item)		//’èŠú„‰ñ–KŠÅ
        		|| "3113".equals(item)	//’èŠú„‰ñ–KŠÅEy‚P
        		|| "3115".equals(item)	//’èŠú„‰ñ–KŠÅE‰î‚T
        		|| "3117".equals(item)	//’èŠú„‰ñ–KŠÅEy‚PE‰î‚T
        		|| "6102".equals(item)	//–K–âŠÅŒìƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‚Q
        		|| "8001".equals(item)	//“Á•Ê’nˆæ–K–âŠÅŒì‰ÁZ‚Q
        		|| "8101".equals(item)	//–K–âŠÅŒì¬‹K–Í–‹ÆŠ‰ÁZ‚Q
        		|| "8111".equals(item)	//–K–âŠÅŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ‚Q
        		) {
                result = true;
            }
        }
        //•Ÿƒ—p‹ï‘İ—^
        if ("17".equals(kind)) {
            //•Ÿƒ—p‹ïŒn—ñ‚Íˆê—¥’PˆÊ”‚ğo—Í‚µ‚È‚¢B
            result = true;
        }
        //“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
        if ("33".equals(kind)) {
        	if ("2001".equals(item)		//ŠO•”Ô‚¢‚·‘İ—^
        		|| "2002".equals(item)	//ŠO•”Ô‚¢‚·•t‘®•i‘İ—^
        		|| "2003".equals(item)	//ŠO•”“ÁêQ‘ä‘İ—^
        		|| "2004".equals(item)	//ŠO•”“ÁêQ‘ä•t‘®•i‘İ—^
        		|| "2005".equals(item)	//ŠO•”°‚¸‚ê–h~—p‹ï‘İ—^
        		|| "2006".equals(item)	//ŠO•”‘ÌˆÊ•ÏŠ·Ší‘İ—^
        		|| "2007".equals(item)	//ŠO•”è‚·‚è‘İ—^
        		|| "2008".equals(item)	//ŠO•”ƒXƒ[ƒv‘İ—^
        		|| "2009".equals(item)	//ŠO•”•àsŠí‘İ—^
        		|| "2010".equals(item)	//ŠO•”•às•â•‚Â‚¦‘İ—^
        		|| "2011".equals(item)	//ŠO•”œpœjŠ´’m‹@Ší‘İ—^
        		|| "2012".equals(item)	//ŠO•”ˆÚ“®—pƒŠƒtƒg‘İ—^
        		|| "2013".equals(item)	//ŠO•”©“®”rŸ•ˆ—‘•’u‘İ—^" +
            	) {
                result = true;
            }
        }
        //‰îŒì—\–h“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
        if ("35".equals(kind)) {
            if ("1311".equals(item)		//—\–hŠO•”–K–â‰îŒì‡T
            	|| "1321".equals(item)	//—\–hŠO•”–K–â‰îŒì‡U
            	|| "1332".equals(item)	//—\–hŠO•”–K–â‰îŒì‡V
            	|| "1711".equals(item)	//—\–hŠO•”’ÊŠ‰îŒì‚P
            	|| "1712".equals(item)	//—\–hŠO•”’ÊŠ‰îŒì‚Q
            	|| "1722".equals(item)	//—\–hŠO•”’ÊŠ‰îŒì‰^“®Ší‰ÁZ
            	|| "1723".equals(item)	//—\–hŠO•”’ÊŠ‰îŒì‰h—{‰ü‘P‰ÁZ
            	|| "1724".equals(item)	//—\–hŠO•”’ÊŠ‰îŒìŒûo‹@”\‰ÁZ
            	|| "1725".equals(item)	//—\–hŠO•”’Ê‰î•¡”ƒT[ƒrƒX‰ÁZ‡T‚P
            	|| "1726".equals(item)	//—\–hŠO•”’Ê‰î•¡”ƒT[ƒrƒX‰ÁZ‡T‚Q
            	|| "1727".equals(item)	//—\–hŠO•”’Ê‰î•¡”ƒT[ƒrƒX‰ÁZ‡T‚R
            	|| "1728".equals(item)	//—\–hŠO•”’Ê‰î•¡”ƒT[ƒrƒX‰ÁZ‡U
            	|| "1811".equals(item)	//—\–hŠO•”’ÊŠƒŠƒn‚P‚P
            	|| "1812".equals(item)	//—\–hŠO•”’ÊŠƒŠƒn‚P‚Q
            	|| "1821".equals(item)	//—\–hŠO•”’ÊŠƒŠƒn‰^“®Ší‰ÁZ
            	|| "1822".equals(item)	//—\–hŠO•”’ÊŠƒŠƒn‰h—{‰ü‘P‰ÁZ
            	|| "1823".equals(item)	//—\–hŠO•”’ÊŠƒŠƒnŒûo‹@”\‰ÁZ
            	|| "1824".equals(item)	//—\–hŠO•”’ÊƒŠ•¡”ƒT[ƒrƒX‰ÁZ‡T‚P
            	|| "1825".equals(item)	//—\–hŠO•”’ÊƒŠ•¡”ƒT[ƒrƒX‰ÁZ‡T‚Q
            	|| "1826".equals(item)	//—\–hŠO•”’ÊƒŠ•¡”ƒT[ƒrƒX‰ÁZ‡T‚R
            	|| "1827".equals(item)	//—\–hŠO•”’ÊƒŠ•¡”ƒT[ƒrƒX‰ÁZ‡U
            	|| "1831".equals(item)	//—\–hŠO•”’ÊŠƒŠƒn‚Q‚P
            	|| "1832".equals(item)	//—\–hŠO•”’ÊŠƒŠƒn‚Q‚Q
            	|| "1901".equals(item)	//—\–hŠO•”Ô‚¢‚·‘İ—^
            	|| "1902".equals(item)	//—\–hŠO•”Ô‚¢‚·•t‘®•i‘İ—^
            	|| "1903".equals(item)	//—\–hŠO•”“ÁêQ‘ä‘İ—^
            	|| "1904".equals(item)	//—\–hŠO•”“ÁêQ‘ä•t‘®•i‘İ—^
            	|| "1905".equals(item)	//—\–hŠO•”°‚¸‚ê–h~—p‹ï‘İ—^
            	|| "1906".equals(item)	//—\–hŠO•”‘ÌˆÊ•ÏŠ·Ší‘İ—^
            	|| "1907".equals(item)	//—\–hŠO•”è‚·‚è‘İ—^
            	|| "1908".equals(item)	//—\–hŠO•”ƒXƒ[ƒv‘İ—^
            	|| "1909".equals(item)	//—\–hŠO•”•àsŠí‘İ—^
            	|| "1910".equals(item)	//—\–hŠO•”•às•â•‚Â‚¦‘İ—^
            	|| "1911".equals(item)	//—\–hŠO•”œpœjŠ´’m‹@Ší‘İ—^
            	|| "1912".equals(item)	//—\–hŠO•”ˆÚ“®—pƒŠƒtƒg‘İ—^
            	|| "1913".equals(item)	//—\–hŠO•”©“®”rŸ•ˆ—‘•’u‘İ—^
            	) {
                result = true;
            }
    	}
        //‰îŒì—\–hx‰‡
        if ("46".equals(kind)) {
            result = true;
        }
        //‰îŒì—\–h–K–â‰îŒì
        if ("61".equals(kind)) {
        	if ("1111".equals(item)		//—\–h–K–â‰îŒì‡T
            	|| "1113".equals(item)	//—\–h–K–â‰îŒì‡TE‚Q‹‰
            	|| "1114".equals(item)	//—\–h–K–â‰îŒì‡TE“¯ˆê
            	|| "1115".equals(item)	//—\–h–K–â‰îŒì‡TE‚Q‹‰E“¯ˆê
            	|| "1211".equals(item)	//—\–h–K–â‰îŒì‡U
            	|| "1213".equals(item)	//—\–h–K–â‰îŒì‡UE‚Q‹‰
            	|| "1214".equals(item)	//—\–h–K–â‰îŒì‡UE“¯ˆê
            	|| "1215".equals(item)	//—\–h–K–â‰îŒì‡UE‚Q‹‰E“¯ˆê
            	|| "1321".equals(item)	//—\–h–K–â‰îŒì‡V
            	|| "1323".equals(item)	//—\–h–K–â‰îŒì‡VE‚Q‹‰
            	|| "1324".equals(item)	//—\–h–K–â‰îŒì‡VE“¯ˆê
            	|| "1325".equals(item)	//—\–h–K–â‰îŒì‡VE‚Q‹‰E“¯ˆê
            	|| "4001".equals(item)	//—\–h–K–â‰îŒì‰‰ñ‰ÁZ
            	|| "4002".equals(item)	//—\–h–K–â‰îŒì¶Šˆ‹@”\Œüã‰ÁZ
            	|| "8000".equals(item)	//—\–h“Á•Ê’nˆæ–K–â‰îŒì‰ÁZ
            	|| "8100".equals(item)	//—\–h–K–â‰îŒì¬‹K–Í–‹ÆŠ‰ÁZ
            	|| "8110".equals(item)	//—\–h–K–â‰îŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ"
            	) {
                result = true;
            }
        }
        //‰îŒì—\–h’ÊŠ‰îŒì
        if ("65".equals(kind)) {
            if ("1111".equals(item)		//—\–h’ÊŠ‰îŒì‚P
            	|| "1121".equals(item)	//—\–h’ÊŠ‰îŒì‚Q
            	|| "5002".equals(item)	//—\–h’ÊŠ‰îŒì‰^“®Ší‹@”\Œüã‰ÁZ
            	|| "5003".equals(item)	//—\–h’ÊŠ‰îŒì‰h—{‰ü‘P‰ÁZ
            	|| "5004".equals(item)	//—\–h’ÊŠ‰îŒìŒûo‹@”\Œüã‰ÁZ
            	|| "5005".equals(item)	//—\–h’ÊŠ‰îŒì–‹ÆŠ•]‰¿‰ÁZ
            	|| "5006".equals(item)	//—\–h’Ê‰î•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚P
            	|| "5007".equals(item)	//—\–h’Ê‰î•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚Q
            	|| "5008".equals(item)	//—\–h’Ê‰î•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚R
            	|| "5009".equals(item)	//—\–h’Ê‰î•¡”ƒT[ƒrƒXÀ{‰ÁZ‡U
            	|| "5010".equals(item)	//—\–h’Ê‰î¶ŠˆŒüãƒOƒ‹[ƒvŠˆ“®‰ÁZ
            	|| "6101".equals(item)	//—\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T‚P
            	|| "6102".equals(item)	//—\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T‚Q
            	|| "6103".equals(item)	//—\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U‚P
            	|| "6104".equals(item)	//—\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U‚Q
            	|| "6105".equals(item)	//—\–h’ÊŠ‰îŒì‘—Œ}Œ¸Z‚P
            	|| "6106".equals(item)	//—\–h’ÊŠ‰îŒì‘—Œ}Œ¸Z‚Q
            	|| "6109".equals(item)	//—\–h’ÊŠ‰îŒìá”N«”F’mÇó“ü‰ÁZ
            	|| "8001".equals(item)	//—\–h’ÊŠ‰îŒì‚PE’è’´
            	|| "8011".equals(item)	//—\–h’ÊŠ‰îŒì‚QE’è’´
            	|| "8110".equals(item)	//—\–h’ÊŠ‰îŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
            	|| "9001".equals(item)	//—\–h’ÊŠ‰îŒì‚PElŒ‡
            	|| "9011".equals(item)	//—\–h’ÊŠ‰îŒì‚QElŒ‡"
            	) {
                result = true;
            }
        }
        //‰îŒì—\–h’ÊŠƒŠƒnƒrƒŠƒe[ƒVƒ‡ƒ“
        if ("66".equals(kind)) {
            if ("1111".equals(item)		//—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚P
            	|| "1121".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚Q
            	|| "2111".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚P
            	|| "2121".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚Q
            	|| "5002".equals(item)	//—\–h’ÊŠƒŠƒn‰^“®Ší‹@”\Œüã‰ÁZ
            	|| "5003".equals(item)	//—\–h’ÊŠƒŠƒn‰h—{‰ü‘P‰ÁZ
            	|| "5004".equals(item)	//—\–h’ÊŠƒŠƒnŒûo‹@”\Œüã‰ÁZ
            	|| "5005".equals(item)	//—\–h’ÊŠƒŠƒn–‹ÆŠ•]‰¿‰ÁZ
            	|| "5006".equals(item)	//—\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚P
            	|| "5007".equals(item)	//—\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚Q
            	|| "5008".equals(item)	//—\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚R
            	|| "5009".equals(item)	//—\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZ‡U
            	|| "6101".equals(item)	//—\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T‚P
            	|| "6102".equals(item)	//—\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T‚Q
            	|| "6103".equals(item)	//—\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U‚P
            	|| "6104".equals(item)	//—\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U‚Q
            	|| "6105".equals(item)	//—\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚P‚P
            	|| "6106".equals(item)	//—\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚P‚Q
            	|| "6107".equals(item)	//—\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚Q‚P
            	|| "6108".equals(item)	//—\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚Q‚Q
            	|| "6109".equals(item)	//—\–h’ÊŠƒŠƒná”N«”F’mÇó“ü‰ÁZ
            	|| "8001".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚PE’è’´
            	|| "8011".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚QE’è’´
            	|| "8110".equals(item)	//—\–h’ÊŠƒŠƒn’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
            	|| "8201".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚PE’è’´
            	|| "8211".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚QE’è’´
            	|| "9001".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚PElŒ‡
            	|| "9011".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚QElŒ‡
            	|| "9201".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚PElŒ‡
            	|| "9211".equals(item)	//—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚QElŒ‡
        		) {
                result = true;
            }
        }
        //‰îŒì—\–h•Ÿƒ—p‹ï‘İ—^
        if ("67".equals(kind)) {
            result = true;
        }
        //–éŠÔ‘Î‰Œ^–K–â‰îŒìƒT[ƒrƒX
        if ("71".equals(kind)) {
        	if ("1111".equals(item)		//–éŠÔ–K–â‰îŒì‡TŠî–{
            	|| "2111".equals(item)	//–éŠÔ–K–â‰îŒì‡U
            	|| "2113".equals(item)	//–éŠÔ–K–â‰îŒì‡UE“¯ˆê
            	|| "6102".equals(item)	//–éŠÔ–K–âƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
            	|| "6136".equals(item)	//–éŠÔ–K–â‰îŒì‚Q‚SŠÔ’Ê•ñ‘Î‰‰ÁZ
            	|| "7201".equals(item)	//Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚P
            	|| "7203".equals(item)	//Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚Q
            	|| "7205".equals(item)	//Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚R
            	|| "7207".equals(item)	//Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚S
            	|| "7209".equals(item)	//Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚T
            	|| "7211".equals(item)	//Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚U
            	|| "7301".equals(item)	//–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚P
            	|| "7303".equals(item)	//–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚Q
            	|| "7305".equals(item)	//–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚R
            	|| "7307".equals(item)	//–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚S
            	|| "7309".equals(item)	//–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚T
            	|| "7311".equals(item)	//–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚U
    			) {
                result = true;
            }
        }
        //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
        if ("73".equals(kind)) {
        	if ("1111".equals(item)		//¬‹K–Í‘½‹@”\‚P
            	|| "1113".equals(item)	//¬‹K–Í‘½‹@”\‚PE‰ß­
            	|| "1115".equals(item)	//¬‹K–Í‘½‹@”\‚PE“¯ˆê
            	|| "1117".equals(item)	//¬‹K–Í‘½‹@”\‚PE“¯ˆêE‰ß­
            	|| "1121".equals(item)	//¬‹K–Í‘½‹@”\‚Q
            	|| "1123".equals(item)	//¬‹K–Í‘½‹@”\‚QE‰ß­
            	|| "1125".equals(item)	//¬‹K–Í‘½‹@”\‚QE“¯ˆê
            	|| "1127".equals(item)	//¬‹K–Í‘½‹@”\‚QE“¯ˆêE‰ß­
            	|| "1131".equals(item)	//¬‹K–Í‘½‹@”\‚R
            	|| "1133".equals(item)	//¬‹K–Í‘½‹@”\‚RE‰ß­
            	|| "1135".equals(item)	//¬‹K–Í‘½‹@”\‚RE“¯ˆê
            	|| "1137".equals(item)	//¬‹K–Í‘½‹@”\‚RE“¯ˆêE‰ß­
            	|| "1141".equals(item)	//¬‹K–Í‘½‹@”\‚S
            	|| "1143".equals(item)	//¬‹K–Í‘½‹@”\‚SE‰ß­
            	|| "1145".equals(item)	//¬‹K–Í‘½‹@”\‚SE“¯ˆê
            	|| "1147".equals(item)	//¬‹K–Í‘½‹@”\‚SE“¯ˆêE‰ß­
            	|| "1151".equals(item)	//¬‹K–Í‘½‹@”\‚T
            	|| "1153".equals(item)	//¬‹K–Í‘½‹@”\‚TE‰ß­
            	|| "1155".equals(item)	//¬‹K–Í‘½‹@”\‚TE“¯ˆê
            	|| "1157".equals(item)	//¬‹K–Í‘½‹@”\‚TE“¯ˆêE‰ß­
            	|| "6101".equals(item)	//¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
            	|| "6102".equals(item)	//¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
            	|| "6103".equals(item)	//¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
            	|| "6128".equals(item)	//¬‹K–Í‘½‹@”\Œ^”F’mÇ‰ÁZ‡T
            	|| "6129".equals(item)	//¬‹K–Í‘½‹@”\Œ^”F’mÇ‰ÁZ‡U
            	|| "6137".equals(item)	//¬‹K–Í‘½‹@”\Œ^ŠÅŒìEˆõ”z’u‰ÁZ‡T
            	|| "6138".equals(item)	//¬‹K–Í‘½‹@”\Œ^ŠÅŒìEˆõ”z’u‰ÁZ‡U
            	|| "6139".equals(item)	//¬‹K–Í‘½‹@”\Œ^–‹ÆŠJnx‰‡‰ÁZ
            	|| "7101".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P
            	|| "7103".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚Q
            	|| "7105".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚R
            	|| "7107".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚S
            	|| "7109".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚T
            	|| "7111".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚U
            	|| "7113".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚V
            	|| "7115".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚W
            	|| "7117".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚X
            	|| "7119".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚O
            	|| "7121".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚P
            	|| "7123".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚Q
            	|| "7125".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚R
            	|| "7127".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚S
            	|| "7129".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚T
            	|| "7131".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚U
            	|| "7133".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚V
            	|| "7135".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚W
            	|| "7137".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚X
            	|| "7139".equals(item)	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚Q‚O
            	|| "8011".equals(item)	//¬‹K–Í‘½‹@”\‚PE’è’´
            	|| "8013".equals(item)	//¬‹K–Í‘½‹@”\‚PE’è’´E‰ß­
            	|| "8015".equals(item)	//¬‹K–Í‘½‹@”\‚PE’è’´E“¯ˆê
            	|| "8017".equals(item)	//¬‹K–Í‘½‹@”\‚PE’è’´E“¯ˆêE‰ß­
            	|| "8021".equals(item)	//¬‹K–Í‘½‹@”\‚QE’è’´
            	|| "8023".equals(item)	//¬‹K–Í‘½‹@”\‚QE’è’´E‰ß­
            	|| "8025".equals(item)	//¬‹K–Í‘½‹@”\‚QE’è’´E“¯ˆê
            	|| "8027".equals(item)	//¬‹K–Í‘½‹@”\‚QE’è’´E“¯ˆêE‰ß­
            	|| "8031".equals(item)	//¬‹K–Í‘½‹@”\‚RE’è’´
            	|| "8033".equals(item)	//¬‹K–Í‘½‹@”\‚RE’è’´E‰ß­
            	|| "8035".equals(item)	//¬‹K–Í‘½‹@”\‚RE’è’´E“¯ˆê
            	|| "8037".equals(item)	//¬‹K–Í‘½‹@”\‚RE’è’´E“¯ˆêE‰ß­
            	|| "8041".equals(item)	//¬‹K–Í‘½‹@”\‚SE’è’´
            	|| "8043".equals(item)	//¬‹K–Í‘½‹@”\‚SE’è’´E‰ß­
            	|| "8045".equals(item)	//¬‹K–Í‘½‹@”\‚SE’è’´E“¯ˆê
            	|| "8047".equals(item)	//¬‹K–Í‘½‹@”\‚SE’è’´E“¯ˆêE‰ß­
            	|| "8051".equals(item)	//¬‹K–Í‘½‹@”\‚TE’è’´
            	|| "8053".equals(item)	//¬‹K–Í‘½‹@”\‚TE’è’´E‰ß­
            	|| "8055".equals(item)	//¬‹K–Í‘½‹@”\‚TE’è’´E“¯ˆê
            	|| "8057".equals(item)	//¬‹K–Í‘½‹@”\‚TE’è’´E“¯ˆêE‰ß­
            	|| "9011".equals(item)	//¬‹K–Í‘½‹@”\‚PElŒ‡
            	|| "9013".equals(item)	//¬‹K–Í‘½‹@”\‚PElŒ‡E‰ß­
            	|| "9015".equals(item)	//¬‹K–Í‘½‹@”\‚PElŒ‡E“¯ˆê
            	|| "9017".equals(item)	//¬‹K–Í‘½‹@”\‚PElŒ‡E“¯ˆêE‰ß­
            	|| "9021".equals(item)	//¬‹K–Í‘½‹@”\‚QElŒ‡
            	|| "9023".equals(item)	//¬‹K–Í‘½‹@”\‚QElŒ‡E‰ß­
            	|| "9025".equals(item)	//¬‹K–Í‘½‹@”\‚QElŒ‡E“¯ˆê
            	|| "9027".equals(item)	//¬‹K–Í‘½‹@”\‚QElŒ‡E“¯ˆêE‰ß­
            	|| "9031".equals(item)	//¬‹K–Í‘½‹@”\‚RElŒ‡
            	|| "9033".equals(item)	//¬‹K–Í‘½‹@”\‚RElŒ‡E‰ß­
            	|| "9035".equals(item)	//¬‹K–Í‘½‹@”\‚RElŒ‡E“¯ˆê
            	|| "9037".equals(item)	//¬‹K–Í‘½‹@”\‚RElŒ‡E“¯ˆêE‰ß­
            	|| "9041".equals(item)	//¬‹K–Í‘½‹@”\‚SElŒ‡
            	|| "9043".equals(item)	//¬‹K–Í‘½‹@”\‚SElŒ‡E‰ß­
            	|| "9045".equals(item)	//¬‹K–Í‘½‹@”\‚SElŒ‡E“¯ˆê
            	|| "9047".equals(item)	//¬‹K–Í‘½‹@”\‚SElŒ‡E“¯ˆêE‰ß­
            	|| "9051".equals(item)	//¬‹K–Í‘½‹@”\‚TElŒ‡
            	|| "9053".equals(item)	//¬‹K–Í‘½‹@”\‚TElŒ‡E‰ß­
            	|| "9055".equals(item)	//¬‹K–Í‘½‹@”\‚TElŒ‡E“¯ˆê
            	|| "9057".equals(item)	//¬‹K–Í‘½‹@”\‚TElŒ‡E“¯ˆêE‰ß­
            	) {
                result = true;
            }
        }
        //‰îŒì—\–h¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
        if ("75".equals(kind)) {
        	if ("1111".equals(item)		//—\¬‹K–Í‘½‹@”\‚P
	            || "1113".equals(item)	//—\¬‹K–Í‘½‹@”\‚PE‰ß­
	            || "1115".equals(item)	//—\¬‹K–Í‘½‹@”\‚PE“¯ˆê
	            || "1117".equals(item)	//—\¬‹K–Í‘½‹@”\‚PE“¯ˆêE‰ß­
	            || "1121".equals(item)	//—\¬‹K–Í‘½‹@”\‚Q
	            || "1123".equals(item)	//—\¬‹K–Í‘½‹@”\‚QE‰ß­
	            || "1125".equals(item)	//—\¬‹K–Í‘½‹@”\‚QE“¯ˆê
	            || "1127".equals(item)	//—\¬‹K–Í‘½‹@”\‚QE“¯ˆêE‰ß­
	            || "6101".equals(item)	//—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
	            || "6102".equals(item)	//—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
	            || "6103".equals(item)	//—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
	            || "6139".equals(item)	//—\¬‘½‹@”\Œ^–‹ÆŠJnx‰‡‰ÁZ
	            || "8011".equals(item)	//—\¬‹K–Í‘½‹@”\‚PE’´
	            || "8013".equals(item)	//—\¬‹K–Í‘½‹@”\‚PE’´E‰ß­
	            || "8015".equals(item)	//—\¬‹K–Í‘½‹@”\‚PE’´E“¯ˆê
	            || "8017".equals(item)	//—\¬‹K–Í‘½‹@”\‚PE’´E“¯ˆêE‰ß­
	            || "8021".equals(item)	//—\¬‹K–Í‘½‹@”\‚QE’´
	            || "8023".equals(item)	//—\¬‹K–Í‘½‹@”\‚QE’´E‰ß­
	            || "8025".equals(item)	//—\¬‹K–Í‘½‹@”\‚QE’´E“¯ˆê
	            || "8027".equals(item)	//—\¬‹K–Í‘½‹@”\‚QE’´E“¯ˆêE‰ß­
	            || "9011".equals(item)	//—\¬‹K–Í‘½‹@”\‚PEŒ‡
	            || "9013".equals(item)	//—\¬‹K–Í‘½‹@”\‚PEŒ‡E‰ß­
	            || "9015".equals(item)	//—\¬‹K–Í‘½‹@”\‚PEŒ‡E“¯ˆê
	            || "9017".equals(item)	//—\¬‹K–Í‘½‹@”\‚PEŒ‡E“¯ˆêE‰ß­
	            || "9021".equals(item)	//—\¬‹K–Í‘½‹@”\‚QEŒ‡
	            || "9023".equals(item)	//—\¬‹K–Í‘½‹@”\‚QEŒ‡E‰ß­
	            || "9025".equals(item)	//—\¬‹K–Í‘½‹@”\‚QEŒ‡E“¯ˆê
	            || "9027".equals(item)	//—\¬‹K–Í‘½‹@”\‚QEŒ‡E“¯ˆêE‰ß­
	            ) {
                result = true;
            }
        }
        //’èŠú„‰ñE‘Î‰Œ^–K–âŠÅŒì‰îŒì
        if ("76".equals(kind)) {
        	if ("1111".equals(item)		//’èŠú„‰ñ‡T‚P‚P
	            || "1121".equals(item)	//’èŠú„‰ñ‡T‚P‚Q
	            || "1131".equals(item)	//’èŠú„‰ñ‡T‚P‚R
	            || "1141".equals(item)	//’èŠú„‰ñ‡T‚P‚S
	            || "1151".equals(item)	//’èŠú„‰ñ‡T‚P‚T
	            || "1211".equals(item)	//’èŠú„‰ñ‡T‚Q‚P
	            || "1213".equals(item)	//’èŠú„‰ñ‡T‚Q‚PEyŠÅ
	            || "1221".equals(item)	//’èŠú„‰ñ‡T‚Q‚Q
	            || "1223".equals(item)	//’èŠú„‰ñ‡T‚Q‚QEyŠÅ
	            || "1231".equals(item)	//’èŠú„‰ñ‡T‚Q‚R
	            || "1233".equals(item)	//’èŠú„‰ñ‡T‚Q‚REyŠÅ
	            || "1241".equals(item)	//’èŠú„‰ñ‡T‚Q‚S
	            || "1243".equals(item)	//’èŠú„‰ñ‡T‚Q‚SEyŠÅ
	            || "1251".equals(item)	//’èŠú„‰ñ‡T‚Q‚T
	            || "1253".equals(item)	//’èŠú„‰ñ‡T‚Q‚TEyŠÅ
	            || "2111".equals(item)	//’èŠú„‰ñ‡U‚P
	            || "2121".equals(item)	//’èŠú„‰ñ‡U‚Q
	            || "2131".equals(item)	//’èŠú„‰ñ‡U‚R
	            || "2141".equals(item)	//’èŠú„‰ñ‡U‚S
	            || "2151".equals(item)	//’èŠú„‰ñ‡U‚T
	            || "3100".equals(item)	//’èŠú„‰ñ‹Ù‹}–K–âŠÅŒì‰ÁZ
	            || "4000".equals(item)	//’èŠú„‰ñ“Á•ÊŠÇ—‰ÁZ‡T
	            || "4001".equals(item)	//’èŠú„‰ñ“Á•ÊŠÇ—‰ÁZ‡U
	            || "6100".equals(item)	//’èŠú„‰ñƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
	            || "6101".equals(item)	//’èŠú„‰ñƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
	            || "6102".equals(item)	//’èŠú„‰ñƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
	            || "6103".equals(item)	//’èŠú„‰ñƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
	            || "7101".equals(item)	//’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚P
	            || "7103".equals(item)	//’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚Q
	            || "7105".equals(item)	//’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚R
	            || "7107".equals(item)	//’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚S
	            || "7109".equals(item)	//’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚T
	            || "7111".equals(item)	//’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚U
	            || "7113".equals(item)	//’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚V
	            || "7115".equals(item)	//’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚W
	            || "7117".equals(item)	//’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚X
	            || "7119".equals(item)	//’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚P‚O
	            || "8000".equals(item)	//’èŠú„‰ñ“Á•Ê’nˆæ–K–âŠÅŒì‰ÁZ
	            || "8100".equals(item)	//’èŠú„‰ñ¬‹K–Í–‹ÆŠ‰ÁZ
	            || "8110".equals(item)	//’èŠú„‰ñ’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
    			) {
                result = true;
            }
        }
        //•¡‡Œ^ƒT[ƒrƒX
        if ("77".equals(kind)) {
        	if ("1111".equals(item)		//•¡‡Œ^ƒT[ƒrƒX‚P
	            || "1113".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚PE‰ß­
	            || "1121".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚Q
	            || "1123".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚QE‰ß­
	            || "1131".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚R
	            || "1133".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚RE‰ß­
	            || "1141".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚S
	            || "1143".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚SE‰ß­
	            || "1151".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚T
	            || "1153".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚TE‰ß­
	            || "3100".equals(item)	//•¡‡Œ^‹Ù‹}–K–âŠÅŒì‰ÁZ
	            || "4000".equals(item)	//•¡‡Œ^“Á•ÊŠÇ—‰ÁZ‡T
	            || "4001".equals(item)	//•¡‡Œ^“Á•ÊŠÇ—‰ÁZ‡U
	            || "6001".equals(item)	//•¡‡Œ^ˆã—Ã–K–âŠÅŒìŒ¸Z‚P
	            || "6003".equals(item)	//•¡‡Œ^ˆã—Ã–K–âŠÅŒìŒ¸Z‚Q
	            || "6005".equals(item)	//•¡‡Œ^ˆã—Ã–K–âŠÅŒìŒ¸Z‚R
	            || "6007".equals(item)	//•¡‡Œ^ˆã—Ã–K–âŠÅŒìŒ¸Z‚S
	            || "6009".equals(item)	//•¡‡Œ^ˆã—Ã–K–âŠÅŒìŒ¸Z‚T
	            || "6100".equals(item)	//•¡‡Œ^ƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
	            || "6101".equals(item)	//•¡‡Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
	            || "6102".equals(item)	//•¡‡Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
	            || "6103".equals(item)	//•¡‡Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
	            || "6128".equals(item)	//•¡‡Œ^”F’mÇ‰ÁZ‡T
	            || "6129".equals(item)	//•¡‡Œ^”F’mÇ‰ÁZ‡U
	            || "6139".equals(item)	//•¡‡Œ^–‹ÆŠJnx‰‡‰ÁZ
	            || "7101".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P
	            || "7103".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚Q
	            || "7105".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚R
	            || "7107".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚S
	            || "7109".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚T
	            || "7111".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚U
	            || "7113".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚V
	            || "7115".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚W
	            || "7117".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚X
	            || "7119".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚O
	            || "7121".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚P
	            || "7123".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚Q
	            || "7125".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚R
	            || "7127".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚S
	            || "7129".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚T
	            || "7131".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚U
	            || "7133".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚V
	            || "7135".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚W
	            || "7137".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚X
	            || "7139".equals(item)	//•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚Q‚O
	            || "8011".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚PE’è’´
	            || "8013".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚PE’è’´E‰ß­
	            || "8021".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚QE’è’´
	            || "8023".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚QE’è’´E‰ß­
	            || "8031".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚RE’è’´
	            || "8033".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚RE’è’´E‰ß­
	            || "8041".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚SE’è’´
	            || "8043".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚SE’è’´E‰ß­
	            || "8051".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚TE’è’´
	            || "8053".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚TE’è’´E‰ß­
	            || "9011".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚PElŒ‡
	            || "9013".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚PElŒ‡E‰ß­
	            || "9021".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚QElŒ‡
	            || "9023".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚QElŒ‡E‰ß­
	            || "9031".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚RElŒ‡
	            || "9033".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚RElŒ‡E‰ß­
	            || "9041".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚SElŒ‡
	            || "9043".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚SElŒ‡E‰ß­
	            || "9051".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚TElŒ‡
	            || "9053".equals(item)	//•¡‡Œ^ƒT[ƒrƒX‚TElŒ‡E‰ß­
	            ) {
                result = true;
            }
        }
        
        return result;
        // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 add - end ƒT[ƒrƒXƒR[ƒh‰p”‰»
    }
    
    /**
     * ’PˆÊ”‚ğŒvã‚µ‚È‚¢ƒT[ƒrƒX‚Å‚ ‚é‚©Šm”F‚·‚éB
     * @param serviceCodeKind ƒT[ƒrƒXƒR[ƒhí—Ş
     * @param serviceCodeItem ƒT[ƒrƒXƒR[ƒh€–Ú
     * @return true : ’PˆÊ”‚ğ‹LÚ‚µ‚È‚¢ false : ’PˆÊ”‚ğ‹LÚ‚·‚é
     * @throws Exception
     */
    // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - begin ƒT[ƒrƒXƒR[ƒh‰p”‰»‚É‚æ‚è‚±‚Ìƒ`ƒFƒbƒN•û–@‚ğ”p~
    /*
    public static boolean isUnitNoCountService(int kind, int item) throws Exception {
        
        //[ID:0000714] •½¬24”N4Œ–@‰ü³‚É”º‚¢A‘SC³
        
        boolean result = false;
        
        switch(kind){
        case 13: //–K–âŠÅŒì
            switch(item){
            case 3111: //’èŠú„‰ñ–KŠÅ
            case 3113: //’èŠú„‰ñ–KŠÅEy‚P
            case 3115: //’èŠú„‰ñ–KŠÅE‰î‚T
            case 3117: //’èŠú„‰ñ–KŠÅEy‚PE‰î‚T
            case 6102: //–K–âŠÅŒìƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‚Q
            case 8001: //“Á•Ê’nˆæ–K–âŠÅŒì‰ÁZ‚Q
            case 8101: //–K–âŠÅŒì¬‹K–Í–‹ÆŠ‰ÁZ‚Q
            case 8111: //–K–âŠÅŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ‚Q
                result = true;
                break;
            }
            break;
            
        case 17: //•Ÿƒ—p‹ï‘İ—^
            //•Ÿƒ—p‹ïŒn—ñ‚Íˆê—¥’PˆÊ”‚ğo—Í‚µ‚È‚¢B
            result = true;
            break;
            
        case 33: //“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
            switch(item){
            case 2001: //ŠO•”Ô‚¢‚·‘İ—^
            case 2002: //ŠO•”Ô‚¢‚·•t‘®•i‘İ—^
            case 2003: //ŠO•”“ÁêQ‘ä‘İ—^
            case 2004: //ŠO•”“ÁêQ‘ä•t‘®•i‘İ—^
            case 2005: //ŠO•”°‚¸‚ê–h~—p‹ï‘İ—^
            case 2006: //ŠO•”‘ÌˆÊ•ÏŠ·Ší‘İ—^
            case 2007: //ŠO•”è‚·‚è‘İ—^
            case 2008: //ŠO•”ƒXƒ[ƒv‘İ—^
            case 2009: //ŠO•”•àsŠí‘İ—^
            case 2010: //ŠO•”•às•â•‚Â‚¦‘İ—^
            case 2011: //ŠO•”œpœjŠ´’m‹@Ší‘İ—^
            case 2012: //ŠO•”ˆÚ“®—pƒŠƒtƒg‘İ—^
            case 2013: //ŠO•”©“®”rŸ•ˆ—‘•’u‘İ—^
                result = true;
                break;
            }
            break;
            
        case 35: //‰îŒì—\–h“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
            switch(item){
            case 1311: //—\–hŠO•”–K–â‰îŒì‡T
            case 1321: //—\–hŠO•”–K–â‰îŒì‡U
            case 1332: //—\–hŠO•”–K–â‰îŒì‡V
            case 1711: //—\–hŠO•”’ÊŠ‰îŒì‚P
            case 1712: //—\–hŠO•”’ÊŠ‰îŒì‚Q
            case 1722: //—\–hŠO•”’ÊŠ‰îŒì‰^“®Ší‰ÁZ
            case 1723: //—\–hŠO•”’ÊŠ‰îŒì‰h—{‰ü‘P‰ÁZ
            case 1724: //—\–hŠO•”’ÊŠ‰îŒìŒûo‹@”\‰ÁZ
            case 1725: //—\–hŠO•”’Ê‰î•¡”ƒT[ƒrƒX‰ÁZ‡T‚P
            case 1726: //—\–hŠO•”’Ê‰î•¡”ƒT[ƒrƒX‰ÁZ‡T‚Q
            case 1727: //—\–hŠO•”’Ê‰î•¡”ƒT[ƒrƒX‰ÁZ‡T‚R
            case 1728: //—\–hŠO•”’Ê‰î•¡”ƒT[ƒrƒX‰ÁZ‡U
            case 1811: //—\–hŠO•”’ÊŠƒŠƒn‚P‚P
            case 1812: //—\–hŠO•”’ÊŠƒŠƒn‚P‚Q
            case 1821: //—\–hŠO•”’ÊŠƒŠƒn‰^“®Ší‰ÁZ
            case 1822: //—\–hŠO•”’ÊŠƒŠƒn‰h—{‰ü‘P‰ÁZ
            case 1823: //—\–hŠO•”’ÊŠƒŠƒnŒûo‹@”\‰ÁZ
            case 1824: //—\–hŠO•”’ÊƒŠ•¡”ƒT[ƒrƒX‰ÁZ‡T‚P
            case 1825: //—\–hŠO•”’ÊƒŠ•¡”ƒT[ƒrƒX‰ÁZ‡T‚Q
            case 1826: //—\–hŠO•”’ÊƒŠ•¡”ƒT[ƒrƒX‰ÁZ‡T‚R
            case 1827: //—\–hŠO•”’ÊƒŠ•¡”ƒT[ƒrƒX‰ÁZ‡U
            case 1831: //—\–hŠO•”’ÊŠƒŠƒn‚Q‚P
            case 1832: //—\–hŠO•”’ÊŠƒŠƒn‚Q‚Q
            case 1901: //—\–hŠO•”Ô‚¢‚·‘İ—^
            case 1902: //—\–hŠO•”Ô‚¢‚·•t‘®•i‘İ—^
            case 1903: //—\–hŠO•”“ÁêQ‘ä‘İ—^
            case 1904: //—\–hŠO•”“ÁêQ‘ä•t‘®•i‘İ—^
            case 1905: //—\–hŠO•”°‚¸‚ê–h~—p‹ï‘İ—^
            case 1906: //—\–hŠO•”‘ÌˆÊ•ÏŠ·Ší‘İ—^
            case 1907: //—\–hŠO•”è‚·‚è‘İ—^
            case 1908: //—\–hŠO•”ƒXƒ[ƒv‘İ—^
            case 1909: //—\–hŠO•”•àsŠí‘İ—^
            case 1910: //—\–hŠO•”•às•â•‚Â‚¦‘İ—^
            case 1911: //—\–hŠO•”œpœjŠ´’m‹@Ší‘İ—^
            case 1912: //—\–hŠO•”ˆÚ“®—pƒŠƒtƒg‘İ—^
            case 1913: //—\–hŠO•”©“®”rŸ•ˆ—‘•’u‘İ—^
                result = true;
                break;
            }
            break;
            
        case 46: //‰îŒì—\–hx‰‡
            result = true;
            break;
            
        case 61: //‰îŒì—\–h–K–âŠÅŒì
            switch(item){
            case 1111: //—\–h–K–â‰îŒì‡T
            case 1113: //—\–h–K–â‰îŒì‡TE‚Q‹‰
            case 1114: //—\–h–K–â‰îŒì‡TE“¯ˆê
            case 1115: //—\–h–K–â‰îŒì‡TE‚Q‹‰E“¯ˆê
            case 1211: //—\–h–K–â‰îŒì‡U
            case 1213: //—\–h–K–â‰îŒì‡UE‚Q‹‰
            case 1214: //—\–h–K–â‰îŒì‡UE“¯ˆê
            case 1215: //—\–h–K–â‰îŒì‡UE‚Q‹‰E“¯ˆê
            case 1321: //—\–h–K–â‰îŒì‡V
            case 1323: //—\–h–K–â‰îŒì‡VE‚Q‹‰
            case 1324: //—\–h–K–â‰îŒì‡VE“¯ˆê
            case 1325: //—\–h–K–â‰îŒì‡VE‚Q‹‰E“¯ˆê
            case 4001: //—\–h–K–â‰îŒì‰‰ñ‰ÁZ
            case 4002: //—\–h–K–â‰îŒì¶Šˆ‹@”\Œüã‰ÁZ
            case 8000: //—\–h“Á•Ê’nˆæ–K–â‰îŒì‰ÁZ
            case 8100: //—\–h–K–â‰îŒì¬‹K–Í–‹ÆŠ‰ÁZ
            case 8110: //—\–h–K–â‰îŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
                result = true;
                break;
            }
            break;
            
        case 65: //‰îŒì—\–h’ÊŠ‰îŒì
            switch(item){
            case 1111: //—\–h’ÊŠ‰îŒì‚P
            case 1121: //—\–h’ÊŠ‰îŒì‚Q
            case 5002: //—\–h’ÊŠ‰îŒì‰^“®Ší‹@”\Œüã‰ÁZ
            case 5003: //—\–h’ÊŠ‰îŒì‰h—{‰ü‘P‰ÁZ
            case 5004: //—\–h’ÊŠ‰îŒìŒûo‹@”\Œüã‰ÁZ
            case 5005: //—\–h’ÊŠ‰îŒì–‹ÆŠ•]‰¿‰ÁZ
            case 5006: //—\–h’Ê‰î•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚P
            case 5007: //—\–h’Ê‰î•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚Q
            case 5008: //—\–h’Ê‰î•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚R
            case 5009: //—\–h’Ê‰î•¡”ƒT[ƒrƒXÀ{‰ÁZ‡U
            case 5010: //—\–h’Ê‰î¶ŠˆŒüãƒOƒ‹[ƒvŠˆ“®‰ÁZ
            case 6101: //—\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T‚P
            case 6102: //—\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T‚Q
            case 6103: //—\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U‚P
            case 6104: //—\–h’ÊŠƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U‚Q
            case 6105: //—\–h’ÊŠ‰îŒì‘—Œ}Œ¸Z‚P
            case 6106: //—\–h’ÊŠ‰îŒì‘—Œ}Œ¸Z‚Q
            case 6109: //—\–h’ÊŠ‰îŒìá”N«”F’mÇó“ü‰ÁZ
            case 8001: //—\–h’ÊŠ‰îŒì‚PE’è’´
            case 8011: //—\–h’ÊŠ‰îŒì‚QE’è’´
            case 8110: //—\–h’ÊŠ‰îŒì’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
            case 9001: //—\–h’ÊŠ‰îŒì‚PElŒ‡
            case 9011: //—\–h’ÊŠ‰îŒì‚QElŒ‡
                result = true;
                break;
            }
            break;
            
        case 66: //‰îŒì—\–h’ÊŠƒŠƒnƒrƒŠƒe[ƒVƒ‡ƒ“
            switch(item){
            case 1111: //—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚P
            case 1121: //—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚Q
            case 2111: //—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚P
            case 2121: //—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚Q
            case 5002: //—\–h’ÊŠƒŠƒn‰^“®Ší‹@”\Œüã‰ÁZ
            case 5003: //—\–h’ÊŠƒŠƒn‰h—{‰ü‘P‰ÁZ
            case 5004: //—\–h’ÊŠƒŠƒnŒûo‹@”\Œüã‰ÁZ
            case 5005: //—\–h’ÊŠƒŠƒn–‹ÆŠ•]‰¿‰ÁZ
            case 5006: //—\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚P
            case 5007: //—\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚Q
            case 5008: //—\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZ‡T‚R
            case 5009: //—\’ÊƒŠƒn•¡”ƒT[ƒrƒXÀ{‰ÁZ‡U
            case 6101: //—\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T‚P
            case 6102: //—\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T‚Q
            case 6103: //—\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U‚P
            case 6104: //—\’ÊƒŠƒnƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U‚Q
            case 6105: //—\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚P‚P
            case 6106: //—\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚P‚Q
            case 6107: //—\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚Q‚P
            case 6108: //—\–h’ÊŠƒŠƒn‘—Œ}Œ¸Z‚Q‚Q
            case 6109: //—\–h’ÊŠƒŠƒná”N«”F’mÇó“ü‰ÁZ
            case 8001: //—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚PE’è’´
            case 8011: //—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚QE’è’´
            case 8110: //—\–h’ÊŠƒŠƒn’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
            case 8201: //—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚PE’è’´
            case 8211: //—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚QE’è’´
            case 9001: //—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚PElŒ‡
            case 9011: //—\–h’ÊŠƒŠƒnƒrƒŠ‚P‚QElŒ‡
            case 9201: //—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚PElŒ‡
            case 9211: //—\–h’ÊŠƒŠƒnƒrƒŠ‚Q‚QElŒ‡
                result = true;
                break;
            }
            break;
            
        case 67: //‰îŒì—\–h•Ÿƒ—p‹ï‘İ—^
            result = true;
            break;
            
        case 71: //–éŠÔ‘Î‰Œ^–K–â‰îŒìƒT[ƒrƒX
            switch(item){
            case 1111: //–éŠÔ–K–â‰îŒì‡TŠî–{
            case 2111: //–éŠÔ–K–â‰îŒì‡U
            case 2113: //–éŠÔ–K–â‰îŒì‡UE“¯ˆê
            case 6102: //–éŠÔ–K–âƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
            case 6136: //–éŠÔ–K–â‰îŒì‚Q‚SŠÔ’Ê•ñ‘Î‰‰ÁZ
            case 7201: //Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚P
            case 7203: //Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚Q
            case 7205: //Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚R
            case 7207: //Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚S
            case 7209: //Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚T
            case 7211: //Šî–{–éŠÔ–K–â‡Ts’¬‘º“Æ©‰ÁZ‚U
            case 7301: //–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚P
            case 7303: //–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚Q
            case 7305: //–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚R
            case 7307: //–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚S
            case 7309: //–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚T
            case 7311: //–éŠÔ–K–â‰îŒì‡Us’¬‘º“Æ©‰ÁZ‚U
                result = true;
                break;
            }
            break;
            
        case 73: //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
            switch(item){
            case 1111: //¬‹K–Í‘½‹@”\‚P
            case 1113: //¬‹K–Í‘½‹@”\‚PE‰ß­
            case 1115: //¬‹K–Í‘½‹@”\‚PE“¯ˆê
            case 1117: //¬‹K–Í‘½‹@”\‚PE“¯ˆêE‰ß­
            case 1121: //¬‹K–Í‘½‹@”\‚Q
            case 1123: //¬‹K–Í‘½‹@”\‚QE‰ß­
            case 1125: //¬‹K–Í‘½‹@”\‚QE“¯ˆê
            case 1127: //¬‹K–Í‘½‹@”\‚QE“¯ˆêE‰ß­
            case 1131: //¬‹K–Í‘½‹@”\‚R
            case 1133: //¬‹K–Í‘½‹@”\‚RE‰ß­
            case 1135: //¬‹K–Í‘½‹@”\‚RE“¯ˆê
            case 1137: //¬‹K–Í‘½‹@”\‚RE“¯ˆêE‰ß­
            case 1141: //¬‹K–Í‘½‹@”\‚S
            case 1143: //¬‹K–Í‘½‹@”\‚SE‰ß­
            case 1145: //¬‹K–Í‘½‹@”\‚SE“¯ˆê
            case 1147: //¬‹K–Í‘½‹@”\‚SE“¯ˆêE‰ß­
            case 1151: //¬‹K–Í‘½‹@”\‚T
            case 1153: //¬‹K–Í‘½‹@”\‚TE‰ß­
            case 1155: //¬‹K–Í‘½‹@”\‚TE“¯ˆê
            case 1157: //¬‹K–Í‘½‹@”\‚TE“¯ˆêE‰ß­
            case 6101: //¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
            case 6102: //¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
            case 6103: //¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
            case 6128: //¬‹K–Í‘½‹@”\Œ^”F’mÇ‰ÁZ‡T
            case 6129: //¬‹K–Í‘½‹@”\Œ^”F’mÇ‰ÁZ‡U
            case 6137: //¬‹K–Í‘½‹@”\Œ^ŠÅŒìEˆõ”z’u‰ÁZ‡T
            case 6138: //¬‹K–Í‘½‹@”\Œ^ŠÅŒìEˆõ”z’u‰ÁZ‡U
            case 6139: //¬‹K–Í‘½‹@”\Œ^–‹ÆŠJnx‰‡‰ÁZ
            case 7101: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P
            case 7103: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚Q
            case 7105: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚R
            case 7107: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚S
            case 7109: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚T
            case 7111: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚U
            case 7113: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚V
            case 7115: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚W
            case 7117: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚X
            case 7119: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚O
            case 7121: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚P
            case 7123: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚Q
            case 7125: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚R
            case 7127: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚S
            case 7129: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚T
            case 7131: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚U
            case 7133: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚V
            case 7135: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚W
            case 7137: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚X
            case 7139: //¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚Q‚O
            case 8011: //¬‹K–Í‘½‹@”\‚PE’è’´
            case 8013: //¬‹K–Í‘½‹@”\‚PE’è’´E‰ß­
            case 8015: //¬‹K–Í‘½‹@”\‚PE’è’´E“¯ˆê
            case 8017: //¬‹K–Í‘½‹@”\‚PE’è’´E“¯ˆêE‰ß­
            case 8021: //¬‹K–Í‘½‹@”\‚QE’è’´
            case 8023: //¬‹K–Í‘½‹@”\‚QE’è’´E‰ß­
            case 8025: //¬‹K–Í‘½‹@”\‚QE’è’´E“¯ˆê
            case 8027: //¬‹K–Í‘½‹@”\‚QE’è’´E“¯ˆêE‰ß­
            case 8031: //¬‹K–Í‘½‹@”\‚RE’è’´
            case 8033: //¬‹K–Í‘½‹@”\‚RE’è’´E‰ß­
            case 8035: //¬‹K–Í‘½‹@”\‚RE’è’´E“¯ˆê
            case 8037: //¬‹K–Í‘½‹@”\‚RE’è’´E“¯ˆêE‰ß­
            case 8041: //¬‹K–Í‘½‹@”\‚SE’è’´
            case 8043: //¬‹K–Í‘½‹@”\‚SE’è’´E‰ß­
            case 8045: //¬‹K–Í‘½‹@”\‚SE’è’´E“¯ˆê
            case 8047: //¬‹K–Í‘½‹@”\‚SE’è’´E“¯ˆêE‰ß­
            case 8051: //¬‹K–Í‘½‹@”\‚TE’è’´
            case 8053: //¬‹K–Í‘½‹@”\‚TE’è’´E‰ß­
            case 8055: //¬‹K–Í‘½‹@”\‚TE’è’´E“¯ˆê
            case 8057: //¬‹K–Í‘½‹@”\‚TE’è’´E“¯ˆêE‰ß­
            case 9011: //¬‹K–Í‘½‹@”\‚PElŒ‡
            case 9013: //¬‹K–Í‘½‹@”\‚PElŒ‡E‰ß­
            case 9015: //¬‹K–Í‘½‹@”\‚PElŒ‡E“¯ˆê
            case 9017: //¬‹K–Í‘½‹@”\‚PElŒ‡E“¯ˆêE‰ß­
            case 9021: //¬‹K–Í‘½‹@”\‚QElŒ‡
            case 9023: //¬‹K–Í‘½‹@”\‚QElŒ‡E‰ß­
            case 9025: //¬‹K–Í‘½‹@”\‚QElŒ‡E“¯ˆê
            case 9027: //¬‹K–Í‘½‹@”\‚QElŒ‡E“¯ˆêE‰ß­
            case 9031: //¬‹K–Í‘½‹@”\‚RElŒ‡
            case 9033: //¬‹K–Í‘½‹@”\‚RElŒ‡E‰ß­
            case 9035: //¬‹K–Í‘½‹@”\‚RElŒ‡E“¯ˆê
            case 9037: //¬‹K–Í‘½‹@”\‚RElŒ‡E“¯ˆêE‰ß­
            case 9041: //¬‹K–Í‘½‹@”\‚SElŒ‡
            case 9043: //¬‹K–Í‘½‹@”\‚SElŒ‡E‰ß­
            case 9045: //¬‹K–Í‘½‹@”\‚SElŒ‡E“¯ˆê
            case 9047: //¬‹K–Í‘½‹@”\‚SElŒ‡E“¯ˆêE‰ß­
            case 9051: //¬‹K–Í‘½‹@”\‚TElŒ‡
            case 9053: //¬‹K–Í‘½‹@”\‚TElŒ‡E‰ß­
            case 9055: //¬‹K–Í‘½‹@”\‚TElŒ‡E“¯ˆê
            case 9057: //¬‹K–Í‘½‹@”\‚TElŒ‡E“¯ˆêE‰ß­
                result = true;
                break;
            }
            break;
            
        case 75: //‰îŒì—\–h¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
            switch(item){
            case 1111: //—\¬‹K–Í‘½‹@”\‚P
            case 1113: //—\¬‹K–Í‘½‹@”\‚PE‰ß­
            case 1115: //—\¬‹K–Í‘½‹@”\‚PE“¯ˆê
            case 1117: //—\¬‹K–Í‘½‹@”\‚PE“¯ˆêE‰ß­
            case 1121: //—\¬‹K–Í‘½‹@”\‚Q
            case 1123: //—\¬‹K–Í‘½‹@”\‚QE‰ß­
            case 1125: //—\¬‹K–Í‘½‹@”\‚QE“¯ˆê
            case 1127: //—\¬‹K–Í‘½‹@”\‚QE“¯ˆêE‰ß­
            case 6101: //—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
            case 6102: //—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
            case 6103: //—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
            case 6139: //—\¬‘½‹@”\Œ^–‹ÆŠJnx‰‡‰ÁZ
            case 8011: //—\¬‹K–Í‘½‹@”\‚PE’´
            case 8013: //—\¬‹K–Í‘½‹@”\‚PE’´E‰ß­
            case 8015: //—\¬‹K–Í‘½‹@”\‚PE’´E“¯ˆê
            case 8017: //—\¬‹K–Í‘½‹@”\‚PE’´E“¯ˆêE‰ß­
            case 8021: //—\¬‹K–Í‘½‹@”\‚QE’´
            case 8023: //—\¬‹K–Í‘½‹@”\‚QE’´E‰ß­
            case 8025: //—\¬‹K–Í‘½‹@”\‚QE’´E“¯ˆê
            case 8027: //—\¬‹K–Í‘½‹@”\‚QE’´E“¯ˆêE‰ß­
            case 9011: //—\¬‹K–Í‘½‹@”\‚PEŒ‡
            case 9013: //—\¬‹K–Í‘½‹@”\‚PEŒ‡E‰ß­
            case 9015: //—\¬‹K–Í‘½‹@”\‚PEŒ‡E“¯ˆê
            case 9017: //—\¬‹K–Í‘½‹@”\‚PEŒ‡E“¯ˆêE‰ß­
            case 9021: //—\¬‹K–Í‘½‹@”\‚QEŒ‡
            case 9023: //—\¬‹K–Í‘½‹@”\‚QEŒ‡E‰ß­
            case 9025: //—\¬‹K–Í‘½‹@”\‚QEŒ‡E“¯ˆê
            case 9027: //—\¬‹K–Í‘½‹@”\‚QEŒ‡E“¯ˆêE‰ß­
                result = true;
                break;
            }
            break;
            
        case 76: //’èŠú„‰ñE‘Î‰Œ^–K–âŠÅŒì‰îŒì
            switch(item){
            case 1111: //’èŠú„‰ñ‡T‚P‚P
            case 1121: //’èŠú„‰ñ‡T‚P‚Q
            case 1131: //’èŠú„‰ñ‡T‚P‚R
            case 1141: //’èŠú„‰ñ‡T‚P‚S
            case 1151: //’èŠú„‰ñ‡T‚P‚T
            case 1211: //’èŠú„‰ñ‡T‚Q‚P
            case 1213: //’èŠú„‰ñ‡T‚Q‚PEyŠÅ
            case 1221: //’èŠú„‰ñ‡T‚Q‚Q
            case 1223: //’èŠú„‰ñ‡T‚Q‚QEyŠÅ
            case 1231: //’èŠú„‰ñ‡T‚Q‚R
            case 1233: //’èŠú„‰ñ‡T‚Q‚REyŠÅ
            case 1241: //’èŠú„‰ñ‡T‚Q‚S
            case 1243: //’èŠú„‰ñ‡T‚Q‚SEyŠÅ
            case 1251: //’èŠú„‰ñ‡T‚Q‚T
            case 1253: //’èŠú„‰ñ‡T‚Q‚TEyŠÅ
            case 2111: //’èŠú„‰ñ‡U‚P
            case 2121: //’èŠú„‰ñ‡U‚Q
            case 2131: //’èŠú„‰ñ‡U‚R
            case 2141: //’èŠú„‰ñ‡U‚S
            case 2151: //’èŠú„‰ñ‡U‚T
            case 3100: //’èŠú„‰ñ‹Ù‹}–K–âŠÅŒì‰ÁZ
            case 4000: //’èŠú„‰ñ“Á•ÊŠÇ—‰ÁZ‡T
            case 4001: //’èŠú„‰ñ“Á•ÊŠÇ—‰ÁZ‡U
            case 6100: //’èŠú„‰ñƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
            case 6101: //’èŠú„‰ñƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
            case 6102: //’èŠú„‰ñƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
            case 6103: //’èŠú„‰ñƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
            case 7101: //’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚P
            case 7103: //’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚Q
            case 7105: //’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚R
            case 7107: //’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚S
            case 7109: //’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚T
            case 7111: //’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚U
            case 7113: //’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚V
            case 7115: //’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚W
            case 7117: //’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚X
            case 7119: //’èŠú„‰ñs’¬‘º“Æ©‰ÁZ‚P‚O
            case 8000: //’èŠú„‰ñ“Á•Ê’nˆæ–K–âŠÅŒì‰ÁZ
            case 8100: //’èŠú„‰ñ¬‹K–Í–‹ÆŠ‰ÁZ
            case 8110: //’èŠú„‰ñ’†RŠÔ’nˆæ“™’ñ‹Ÿ‰ÁZ
                result = true;
                break;
            }
            break;
            
        case 77: //•¡‡Œ^ƒT[ƒrƒX
            switch(item){
            case 1111: //•¡‡Œ^ƒT[ƒrƒX‚P
            case 1113: //•¡‡Œ^ƒT[ƒrƒX‚PE‰ß­
            case 1121: //•¡‡Œ^ƒT[ƒrƒX‚Q
            case 1123: //•¡‡Œ^ƒT[ƒrƒX‚QE‰ß­
            case 1131: //•¡‡Œ^ƒT[ƒrƒX‚R
            case 1133: //•¡‡Œ^ƒT[ƒrƒX‚RE‰ß­
            case 1141: //•¡‡Œ^ƒT[ƒrƒX‚S
            case 1143: //•¡‡Œ^ƒT[ƒrƒX‚SE‰ß­
            case 1151: //•¡‡Œ^ƒT[ƒrƒX‚T
            case 1153: //•¡‡Œ^ƒT[ƒrƒX‚TE‰ß­
            case 3100: //•¡‡Œ^‹Ù‹}–K–âŠÅŒì‰ÁZ
            case 4000: //•¡‡Œ^“Á•ÊŠÇ—‰ÁZ‡T
            case 4001: //•¡‡Œ^“Á•ÊŠÇ—‰ÁZ‡U
            case 6001: //•¡‡Œ^ˆã—Ã–K–âŠÅŒìŒ¸Z‚P
            case 6003: //•¡‡Œ^ˆã—Ã–K–âŠÅŒìŒ¸Z‚Q
            case 6005: //•¡‡Œ^ˆã—Ã–K–âŠÅŒìŒ¸Z‚R
            case 6007: //•¡‡Œ^ˆã—Ã–K–âŠÅŒìŒ¸Z‚S
            case 6009: //•¡‡Œ^ˆã—Ã–K–âŠÅŒìŒ¸Z‚T
            case 6100: //•¡‡Œ^ƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
            case 6101: //•¡‡Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
            case 6102: //•¡‡Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
            case 6103: //•¡‡Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
            case 6128: //•¡‡Œ^”F’mÇ‰ÁZ‡T
            case 6129: //•¡‡Œ^”F’mÇ‰ÁZ‡U
            case 6139: //•¡‡Œ^–‹ÆŠJnx‰‡‰ÁZ
            case 7101: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P
            case 7103: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚Q
            case 7105: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚R
            case 7107: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚S
            case 7109: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚T
            case 7111: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚U
            case 7113: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚V
            case 7115: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚W
            case 7117: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚X
            case 7119: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚O
            case 7121: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚P
            case 7123: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚Q
            case 7125: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚R
            case 7127: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚S
            case 7129: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚T
            case 7131: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚U
            case 7133: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚V
            case 7135: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚W
            case 7137: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚P‚X
            case 7139: //•¡‡Œ^s’¬‘º“Æ©‰ÁZ‚Q‚O
            case 8011: //•¡‡Œ^ƒT[ƒrƒX‚PE’è’´
            case 8013: //•¡‡Œ^ƒT[ƒrƒX‚PE’è’´E‰ß­
            case 8021: //•¡‡Œ^ƒT[ƒrƒX‚QE’è’´
            case 8023: //•¡‡Œ^ƒT[ƒrƒX‚QE’è’´E‰ß­
            case 8031: //•¡‡Œ^ƒT[ƒrƒX‚RE’è’´
            case 8033: //•¡‡Œ^ƒT[ƒrƒX‚RE’è’´E‰ß­
            case 8041: //•¡‡Œ^ƒT[ƒrƒX‚SE’è’´
            case 8043: //•¡‡Œ^ƒT[ƒrƒX‚SE’è’´E‰ß­
            case 8051: //•¡‡Œ^ƒT[ƒrƒX‚TE’è’´
            case 8053: //•¡‡Œ^ƒT[ƒrƒX‚TE’è’´E‰ß­
            case 9011: //•¡‡Œ^ƒT[ƒrƒX‚PElŒ‡
            case 9013: //•¡‡Œ^ƒT[ƒrƒX‚PElŒ‡E‰ß­
            case 9021: //•¡‡Œ^ƒT[ƒrƒX‚QElŒ‡
            case 9023: //•¡‡Œ^ƒT[ƒrƒX‚QElŒ‡E‰ß­
            case 9031: //•¡‡Œ^ƒT[ƒrƒX‚RElŒ‡
            case 9033: //•¡‡Œ^ƒT[ƒrƒX‚RElŒ‡E‰ß­
            case 9041: //•¡‡Œ^ƒT[ƒrƒX‚SElŒ‡
            case 9043: //•¡‡Œ^ƒT[ƒrƒX‚SElŒ‡E‰ß­
            case 9051: //•¡‡Œ^ƒT[ƒrƒX‚TElŒ‡
            case 9053: //•¡‡Œ^ƒT[ƒrƒX‚TElŒ‡E‰ß­
                result = true;
                break;
            }
            break;
        }
        
        return result;
    }
    */
    // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - end
    
    /**
     * ’PˆÊ”‚ğ’ •[‚É‹LÚ‚µ‚È‚¢ƒT[ƒrƒX‚Å‚ ‚é‚©Šm”F‚·‚éB
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isUnitNotShowService(String serviceCodeKind, String serviceCodeItem) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        int item = ACCastUtilities.toInt(serviceCodeItem,0);
        boolean result = false;
        
        // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 edit - begin ƒT[ƒrƒXƒR[ƒh‰p”‰»
        /*
        switch(kind){
        //–éŠÔ‘Î‰Œ^–K–â‰îŒì
        case 71:
            switch(item){
            //–éŠÔ–K–â‰îŒì‚PŠî–{
            case 1111:
            //–éŠÔ–K–â‰îŒì‚Q
            case 2111:
                result = true;
                break;
            }
            break;
            
        //•Ÿƒ—p‹ï
        case 17:
            result = true;
            break;
        default:
            result = isUnitNoCountService(kind,item);
            break;
        }
        */
        if ("71".equals(serviceCodeKind)) {
        	//–éŠÔ‘Î‰Œ^–K–â‰îŒì
        	if ("1111".equals(serviceCodeItem)		//–éŠÔ–K–â‰îŒì‚PŠî–{
        		|| "2111".equals(serviceCodeItem)	//–éŠÔ–K–â‰îŒì‚Q
        		) {
        		result = true;
        	}
        } else if ("17".equals(serviceCodeKind)) {
        	//•Ÿƒ—p‹ï
        	result = true;
        } else {
        	result = isUnitNoCountService(serviceCodeKind,serviceCodeItem);
        }
        // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 edit - end ƒT[ƒrƒXƒR[ƒh‰p”‰»
        
        return result;
    }
    
 // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 edit - begin ƒT[ƒrƒXƒR[ƒh‰p”‰»
    /**
     * ’ñ‹Ÿ‰ñ”‚ğ1‰ñ‚Æ‚µ‚ÄŒvã‚·‚éƒT[ƒrƒX‚Å‚ ‚é‚©Šm”F‚·‚éB
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isSingleCountService(String serviceCodeKind, String serviceCodeItem) throws Exception {
    	// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - begin   ƒT[ƒrƒXƒR[ƒh‰p”‰»i”’l‚É‚æ‚éƒ`ƒFƒbƒN‚ğŒÄ‚Î‚È‚¢j
        //int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        //int item = ACCastUtilities.toInt(serviceCodeItem,0);
        //return isSingleNoCountService(kind,item);
        // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - end
    	
    	// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 add - begin   ƒT[ƒrƒXƒR[ƒh‰p”‰»
    	String kind = serviceCodeKind;
    	String item = serviceCodeItem;
        boolean result = false;
        
        //•Ÿƒ—p‹ï‘İ—^ or ‰îŒì—\–h•Ÿƒ—p‹ï‘İ—^
        if ("17".equals(kind) || "67".equals(kind)) {
    		if ("8001".equals(item)		//Ô‚¢‚·•Ÿƒ—p‹ï‘İ—^“Á’n‰ÁZ
	    		|| "8002".equals(item)	//Ô‚¢‚·•t‘®•i‘İ—^“Á’n‰ÁZ
	    		|| "8003".equals(item)	//“ÁêQ‘ä‘İ—^“Á’n‰ÁZ
	    		|| "8004".equals(item)	//“ÁêQ‘ä•t‘®•i‘İ—^“Á’n‰ÁZ
	    		|| "8005".equals(item)	//°‚¸‚ê–h~—p‹ï‘İ—^“Á’n‰ÁZ
	    		|| "8006".equals(item)	//‘ÌˆÊ•ÏŠ·Ší‘İ—^“Á’n‰ÁZ
	    		|| "8007".equals(item)	//è‚·‚è‘İ—^“Á’n‰ÁZ
	    		|| "8008".equals(item)	//ƒXƒ[ƒv‘İ—^“Á’n‰ÁZ
	    		|| "8009".equals(item)	//•àsŠí‘İ—^“Á’n‰ÁZ
	    		|| "8010".equals(item)	//•às•â•‚Â‚¦‘İ—^“Á’n‰ÁZ
	    		|| "8011".equals(item)	//œpœjŠ´’m‹@Ší‘İ—^“Á’n‰ÁZ
	    		|| "8012".equals(item)	//ˆÚ“®—pƒŠƒtƒg‘İ—^“Á’n‰ÁZ
	            || "8013".equals(item)	//©“®”rŸ•ˆ—‘•’u‘İ—^“Á’n‰ÁZ
	    		|| "8101".equals(item)	//Ô‚¢‚·‘İ—^¬‹K–Í‰ÁZ
	    		|| "8102".equals(item)	//Ô‚¢‚·•t‘®•i‘İ—^¬‹K–Í‰ÁZ
	    		|| "8103".equals(item)	//“ÁêQ‘ä‘İ—^¬‹K–Í‰ÁZ
	    		|| "8104".equals(item)	//“ÁêQ‘ä•t‘®•i‘İ—^¬‹K–Í‰ÁZ
	    		|| "8105".equals(item)	//°‚¸‚ê–h~—p‹ï‘İ—^¬‹K–Í‰ÁZ
	    		|| "8106".equals(item)	//‘ÌˆÊ•ÏŠ·Ší‘İ—^¬‹K–Í‰ÁZ
	    		|| "8107".equals(item)	//è‚·‚è‘İ—^¬‹K–Í‰ÁZ
	    		|| "8108".equals(item)	//ƒXƒ[ƒv‘İ—^¬‹K–Í‰ÁZ
	    		|| "8109".equals(item)	//•àsŠí‘İ—^¬‹K–Í‰ÁZ
	    		|| "8110".equals(item)	//•às•â•‚Â‚¦‘İ—^¬‹K–Í‰ÁZ
	    		|| "8111".equals(item)	//œpœjŠ´’m‹@Ší‘İ—^¬‹K–Í‰ÁZ
	    		|| "8112".equals(item)	//ˆÚ“®—pƒŠƒtƒg‘İ—^¬‹K–Í‰ÁZ
	    		|| "8201".equals(item)	//Ô‚¢‚·‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8202".equals(item)	//Ô‚¢‚·•t‘®•i‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8203".equals(item)	//“ÁêQ‘ä‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8204".equals(item)	//“ÁêQ‘ä•t‘®•i‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8205".equals(item)	//°‚¸‚ê–h~—p‹ï‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8206".equals(item)	//‘ÌˆÊ•ÏŠ·Ší‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8207".equals(item)	//è‚·‚è‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8208".equals(item)	//ƒXƒ[ƒv‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8209".equals(item)	//•àsŠí‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8210".equals(item)	//•às•â•‚Â‚¦‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8211".equals(item)	//œpœjŠ´’m‹@Ší‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8212".equals(item)	//ˆÚ“®—pƒŠƒtƒg‘İ—^’†RŠÔ’nˆæ‰ÁZ
	    		|| "8213".equals(item)	//©“®”rŸ•‘•’u‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		) {
    			result = true;
    		}
        }
        //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
        if ("73".equals(kind)) {
            if ("1101".equals(item)		//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒìŒo
	            || "1111".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚P
	            || "1121".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚Q
	            || "1131".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚R
	            || "1141".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚S
	            || "1151".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚T
	            || "8001".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒìŒoE’è’´
	            || "8011".equals(item)	//¬‘½‹@”\Œ^‹‘î‰î‚PE’è’´
	            || "8021".equals(item)	//¬‘½‹@”\Œ^‹‘î‰î‚QE’è’´
	            || "8031".equals(item)	//¬‘½‹@”\Œ^‹‘î‰î‚RE’è’´
	            || "8041".equals(item)	//¬‘½‹@”\Œ^‹‘î‰î‚SE’è’´
	            || "8051".equals(item)	//¬‘½‹@”\Œ^‹‘î‰î‚TE’è’´
	            || "9001".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒìŒoElŒ‡
	            || "9011".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚PElŒ‡
	            || "9021".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚QElŒ‡
	            || "9031".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚RElŒ‡
	            || "9041".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚SElŒ‡
	            || "9051".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚TElŒ‡
	        	|| "1113".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚PE‰ß­
	        	|| "1123".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚QE‰ß­
	        	|| "1133".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚RE‰ß­
	        	|| "1143".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚SE‰ß­
	        	|| "1153".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚TE‰ß­
	        	|| "8013".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚PE’è’´E‰ß­
	        	|| "8023".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚QE’è’´E‰ß­
	        	|| "8033".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚RE’è’´E‰ß­
	        	|| "8043".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚SE’è’´E‰ß­
	        	|| "8053".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚TE’è’´E‰ß­
	        	|| "9013".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚PElŒ‡E‰ß­
	        	|| "9023".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚QElŒ‡E‰ß­
	        	|| "9033".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚RElŒ‡E‰ß­
	        	|| "9043".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚SElŒ‡E‰ß­
	        	|| "9053".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚TElŒ‡E‰ß­
        	) {
                result = true;
            }
        }
        //‰îŒì—\–h¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
        if ("75".equals(kind)) {
        	if ("1111".equals(item)		//—\–h¬‘½‹@”\Œ^‹‘î‰îŒì‚P
	        	|| "1121".equals(item)	//—\–h¬‘½‹@”\Œ^‹‘î‰îŒì‚Q
	        	|| "8011".equals(item)	//—\¬‘½‹@”\Œ^‹‘î‚PE’è’´
	        	|| "8021".equals(item)	//—\¬‘½‹@”\Œ^‹‘î‚QE’è’´
	        	|| "9011".equals(item)	//—\¬‘½‹@”\Œ^‹‘î‚PElŒ‡
	        	|| "9021".equals(item)	//—\¬‘½‹@”\Œ^‹‘î‚QElŒ‡
	        	|| "1113".equals(item)	//—\–h¬‘½‹@”\Œ^‹‘î‰îŒì‚PE‰ß­
	        	|| "1123".equals(item)	//—\–h¬‘½‹@”\Œ^‹‘î‰îŒì‚QE‰ß­
	        	|| "6139".equals(item)	//—\¬‘½‹@”\Œ^–‹ÆŠJnx‰‡‰ÁZ‡T
	        	|| "6140".equals(item)	//—\¬‘½‹@”\Œ^–‹ÆŠJnx‰‡‰ÁZ‡U
	        	|| "6101".equals(item)	//—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
	        	|| "6102".equals(item)	//—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
	        	|| "6103".equals(item)	//—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
	        	|| "8013".equals(item)	//—\¬‘½‹@”\Œ^‹‘î‚PE’è’´E‰ß­
	        	|| "8023".equals(item)	//—\¬‘½‹@”\Œ^‹‘î‚QE’è’´E‰ß­
	        	|| "9013".equals(item)	//—\¬‘½‹@”\Œ^‹‘î‚PElŒ‡E‰ß­
	        	|| "9023".equals(item)	//—\¬‘½‹@”\Œ^‹‘î‚QElŒ‡E‰ß­
        	) {
        		result = true;
        	}
        }
        
        return result;
    	// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 add - end
    }
    
    /**
     * ’ñ‹Ÿ‰ñ”‚ğ1‰ñ‚Æ‚µ‚ÄŒvã‚·‚éƒT[ƒrƒX‚Å‚ ‚é‚©Šm”F‚·‚éB
     * @param serviceCodeKind ƒT[ƒrƒXƒR[ƒhí—Ş
     * @param serviceCodeItem ƒT[ƒrƒXƒR[ƒh€–Ú
     * @return true : ’ñ‹Ÿ‰ñ”‚ğ1‰ñ‚Æ‚µ‚ÄŒvã‚·‚é false : ’ñ‹Ÿ‰ñ”‚ğŒvã‚·‚é
     * @throws Exception
     */
    // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - begin   ƒT[ƒrƒXƒR[ƒh‰p”‰»i”’l‚É‚æ‚éƒ`ƒFƒbƒN‚ğŒÄ‚Î‚È‚¢j
    /*
    public static boolean isSingleNoCountService(int kind, int item) throws Exception {
        
        boolean result = false;
        
        switch(kind){
    	//•Ÿƒ—p‹ï‘İ—^
    	case 17:
    	//‰îŒì—\–h•Ÿƒ—p‹ï‘İ—^
    	case 67:
    		switch(item){
    		//Ô‚¢‚·•Ÿƒ—p‹ï‘İ—^“Á’n‰ÁZ
    		case 8001:
    		//Ô‚¢‚·•t‘®•i‘İ—^“Á’n‰ÁZ
    		case 8002:
    		//“ÁêQ‘ä‘İ—^“Á’n‰ÁZ
    		case 8003:
    		//“ÁêQ‘ä•t‘®•i‘İ—^“Á’n‰ÁZ
    		case 8004:
    		//°‚¸‚ê–h~—p‹ï‘İ—^“Á’n‰ÁZ
    		case 8005:
    		//‘ÌˆÊ•ÏŠ·Ší‘İ—^“Á’n‰ÁZ
    		case 8006:
    		//è‚·‚è‘İ—^“Á’n‰ÁZ
    		case 8007:
    		//ƒXƒ[ƒv‘İ—^“Á’n‰ÁZ
    		case 8008:
    		//•àsŠí‘İ—^“Á’n‰ÁZ
    		case 8009:
    		//•às•â•‚Â‚¦‘İ—^“Á’n‰ÁZ
    		case 8010:
    		//œpœjŠ´’m‹@Ší‘İ—^“Á’n‰ÁZ
    		case 8011:
    		//ˆÚ“®—pƒŠƒtƒg‘İ—^“Á’n‰ÁZ
    		case 8012:
            //[ID:0000714][Shin Fujihara] 2012/03 add begin •½¬24”N4Œ–@‰ü³‘Î‰
            //©“®”rŸ•ˆ—‘•’u‘İ—^“Á’n‰ÁZ
            case 8013:
            //[ID:0000714][Shin Fujihara] 2012/03 add end •½¬24”N4Œ–@‰ü³‘Î‰
			//[ID:0000447][Shin Fujihara] 2009/02 add begin •½¬21”N4Œ–@‰ü³‘Î‰
			//Ô‚¢‚·‘İ—^¬‹K–Í‰ÁZ
    		case 8101:
			//Ô‚¢‚·•t‘®•i‘İ—^¬‹K–Í‰ÁZ
    		case 8102:
			//“ÁêQ‘ä‘İ—^¬‹K–Í‰ÁZ
    		case 8103:
			//“ÁêQ‘ä•t‘®•i‘İ—^¬‹K–Í‰ÁZ
    		case 8104:
			//°‚¸‚ê–h~—p‹ï‘İ—^¬‹K–Í‰ÁZ
    		case 8105:
			//‘ÌˆÊ•ÏŠ·Ší‘İ—^¬‹K–Í‰ÁZ
    		case 8106:
			//è‚·‚è‘İ—^¬‹K–Í‰ÁZ
    		case 8107:
			//ƒXƒ[ƒv‘İ—^¬‹K–Í‰ÁZ
    		case 8108:
			//•àsŠí‘İ—^¬‹K–Í‰ÁZ
    		case 8109:
			//•às•â•‚Â‚¦‘İ—^¬‹K–Í‰ÁZ
    		case 8110:
			//œpœjŠ´’m‹@Ší‘İ—^¬‹K–Í‰ÁZ
    		case 8111:
			//ˆÚ“®—pƒŠƒtƒg‘İ—^¬‹K–Í‰ÁZ
    		case 8112:
			//Ô‚¢‚·‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8201:
			//Ô‚¢‚·•t‘®•i‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8202:
			//“ÁêQ‘ä‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8203:
			//“ÁêQ‘ä•t‘®•i‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8204:
			//°‚¸‚ê–h~—p‹ï‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8205:
			//‘ÌˆÊ•ÏŠ·Ší‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8206:
			//è‚·‚è‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8207:
			//ƒXƒ[ƒv‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8208:
			//•àsŠí‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8209:
			//•às•â•‚Â‚¦‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8210:
			//œpœjŠ´’m‹@Ší‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8211:
			//ˆÚ“®—pƒŠƒtƒg‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8212:
			//[ID:0000447][Shin Fujihara] 2009/02 add end •½¬21”N4Œ–@‰ü³‘Î‰
    		//[ID:0000714][Shin Fujihara] 2012/03 add begin •½¬24”N4Œ–@‰ü³‘Î‰
    		//©“®”rŸ•‘•’u‘İ—^’†RŠÔ’nˆæ‰ÁZ
    		case 8213:
    		//[ID:0000714][Shin Fujihara] 2012/03 add end •½¬24”N4Œ–@‰ü³‘Î‰
    			result = true;
    			break;
    		}
    		break;
        
        
        //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
        case 73:
            switch(item){
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒìŒo
            case 1101:
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚P
            case 1111:
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚Q
            case 1121:
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚R
            case 1131:
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚S
            case 1141:
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚T
            case 1151:
            //¬‘½‹@”\Œ^‹‘î‰îŒìŒoE’è’´
            case 8001:
            //¬‘½‹@”\Œ^‹‘î‰î‚PE’è’´
            case 8011:
            //¬‘½‹@”\Œ^‹‘î‰î‚QE’è’´
            case 8021:
            //¬‘½‹@”\Œ^‹‘î‰î‚RE’è’´
            case 8031:
            //¬‘½‹@”\Œ^‹‘î‰î‚SE’è’´
            case 8041:
            //¬‘½‹@”\Œ^‹‘î‰î‚TE’è’´
            case 8051:
            //¬‘½‹@”\Œ^‹‘î‰îŒìŒoElŒ‡
            case 9001:
            //¬‘½‹@”\Œ^‹‘î‰îŒì‚PElŒ‡
            case 9011:
            //¬‘½‹@”\Œ^‹‘î‰îŒì‚QElŒ‡
            case 9021:
            //¬‘½‹@”\Œ^‹‘î‰îŒì‚RElŒ‡
            case 9031:
            //¬‘½‹@”\Œ^‹‘î‰îŒì‚SElŒ‡
            case 9041:
            //¬‘½‹@”\Œ^‹‘î‰îŒì‚TElŒ‡
            case 9051:
            	
        	//[ID:0000447][Shin Fujihara] 2009/02 add begin •½¬21”N4Œ–@‰ü³‘Î‰
        	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚PE‰ß­
        	case 1113:
        	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚QE‰ß­
        	case 1123:
        	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚RE‰ß­
        	case 1133:
        	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚SE‰ß­
        	case 1143:
        	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚TE‰ß­
        	case 1153:
        	//¬‘½‹@”\Œ^‹‘î‰îŒì‚PE’è’´E‰ß­
        	case 8013:
        	//¬‘½‹@”\Œ^‹‘î‰îŒì‚QE’è’´E‰ß­
        	case 8023:
        	//¬‘½‹@”\Œ^‹‘î‰îŒì‚RE’è’´E‰ß­
        	case 8033:
        	//¬‘½‹@”\Œ^‹‘î‰îŒì‚SE’è’´E‰ß­
        	case 8043:
        	//¬‘½‹@”\Œ^‹‘î‰îŒì‚TE’è’´E‰ß­
        	case 8053:
        	//¬‘½‹@”\Œ^‹‘î‰îŒì‚PElŒ‡E‰ß­
        	case 9013:
        	//¬‘½‹@”\Œ^‹‘î‰îŒì‚QElŒ‡E‰ß­
        	case 9023:
        	//¬‘½‹@”\Œ^‹‘î‰îŒì‚RElŒ‡E‰ß­
        	case 9033:
        	//¬‘½‹@”\Œ^‹‘î‰îŒì‚SElŒ‡E‰ß­
        	case 9043:
        	//¬‘½‹@”\Œ^‹‘î‰îŒì‚TElŒ‡E‰ß­
        	case 9053:
        	//[ID:0000447][Shin Fujihara] 2009/02 add end •½¬21”N4Œ–@‰ü³‘Î‰
        		
                result = true;
                break;
            }
            break;
        //‰îŒì—\–h¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
        case 75:
        	switch(item){
        	//—\–h¬‘½‹@”\Œ^‹‘î‰îŒì‚P
        	case 1111:
        	//—\–h¬‘½‹@”\Œ^‹‘î‰îŒì‚Q
        	case 1121:
        	//—\¬‘½‹@”\Œ^‹‘î‚PE’è’´
        	case 8011:
        	//—\¬‘½‹@”\Œ^‹‘î‚QE’è’´
        	case 8021:
        	//—\¬‘½‹@”\Œ^‹‘î‚PElŒ‡
        	case 9011:
        	//—\¬‘½‹@”\Œ^‹‘î‚QElŒ‡
        	case 9021:
        		
    		//[ID:0000447][Shin Fujihara] 2009/02 add begin •½¬21”N4Œ–@‰ü³‘Î‰
    		//—\–h¬‘½‹@”\Œ^‹‘î‰îŒì‚PE‰ß­
        	case 1113:
    		//—\–h¬‘½‹@”\Œ^‹‘î‰îŒì‚QE‰ß­
        	case 1123:
    		//—\¬‘½‹@”\Œ^–‹ÆŠJnx‰‡‰ÁZ‡T
        	case 6139:
    		//—\¬‘½‹@”\Œ^–‹ÆŠJnx‰‡‰ÁZ‡U
        	case 6140:
    		//—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
        	case 6101:
    		//—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
        	case 6102:
    		//—\¬‘½‹@”\ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
        	case 6103:
    		//—\¬‘½‹@”\Œ^‹‘î‚PE’è’´E‰ß­k
        	case 8013:
    		//—\¬‘½‹@”\Œ^‹‘î‚QE’è’´E‰ß­
        	case 8023:
    		//—\¬‘½‹@”\Œ^‹‘î‚PElŒ‡E‰ß­
        	case 9013:
    		//—\¬‘½‹@”\Œ^‹‘î‚QElŒ‡E‰ß­
        	case 9023:
    		//[ID:0000447][Shin Fujihara] 2009/02 add end •½¬21”N4Œ–@‰ü³‘Î‰
        		
        		result = true;
        		break;
        	}
        	break;
        }
        
        return result;
    }
    */
    // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - end
    
    /**
     * ƒT[ƒrƒX‰ñ”‚ğŒ‚Ì“ú”‚É•ÏX‚·‚éƒT[ƒrƒX‚©Šm”F‚·‚éB
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isMaxCountService(String serviceCodeKind, String serviceCodeItem) throws Exception {
    	
    	// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - begin   ƒT[ƒrƒXƒR[ƒh‰p”‰»i”’l‚É‚æ‚éƒ`ƒFƒbƒN‚ğŒÄ‚Î‚È‚¢j
        //int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        //int item = ACCastUtilities.toInt(serviceCodeItem,0);
        //return isMaxCountService(kind,item);
        // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - end
        
    	// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 add - begin
    	String kind = serviceCodeKind;
    	String item = serviceCodeItem;
        boolean result = false;
        
        //“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
        if ("33".equals(kind)) {
            if ("2001".equals(item)		//ŠO•”ÔˆÖq‘İ—^
	            || "2002".equals(item)	//ŠO•”ÔˆÖq•t‘®•i‘İ—^
	            || "2003".equals(item)	//ŠO•”“ÁêQ‘ä‘İ—^
	            || "2004".equals(item)	//ŠO•”“ÁêQ‘ä•t‘®•i‘İ—^
	            || "2005".equals(item)	//ŠO•”°‚¸‚ê–h~—p‹ï‘İ—^
	            || "2006".equals(item)	//ŠO•”‘ÌˆÊ•ÏŠ·‹@‘İ—^
	            || "2007".equals(item)	//ŠO•”è‚·‚è‘İ—^
	            || "2008".equals(item)	//ŠO•”ƒXƒ[ƒv‘İ—^
	            || "2009".equals(item)	//ŠO•”•àsŠí‘İ—^
	            || "2010".equals(item)	//ŠO•”•às•â•‚Â‚¦‘İ—^
	            || "2011".equals(item)	//ŠO•””oæ~Š´’mŠí‘İ—^
	            || "2012".equals(item)	//ŠO•”ˆÚ“®—pƒŠƒtƒg‘İ—^
	            || "2013".equals(item)	//ŠO•”©“®”rŸ•‘•’u‘İ—^
            ) {
                result = true;
            }
        }
        //•Ÿƒ—p‹ï‘İ—^
        if ("17".equals(kind)) {
            //•Ÿƒ—p‹ïŒn—ñ‚Íˆê—¥’PˆÊ”‚ğo—Í‚µ‚È‚¢B
            if ("1001".equals(item)		//ÔˆÖq‘İ—^
	            || "1002".equals(item)	//ÔˆÖq•t‘®•i‘İ—^
	            || "1003".equals(item)	//“ÁêQ‘ä‘İ—^
	            || "1004".equals(item)	//“ÁêQ‘ä•t‘®•i‘İ—^
	            || "1005".equals(item)	//°‚¸‚ê–h~—p‹ï‘İ—^
	            || "1006".equals(item)	//‘ÌˆÊ•ÏŠ·‹@‘İ—^
	            || "1007".equals(item)	//è‚·‚è‘İ—^
	            || "1008".equals(item)	//ƒXƒ[ƒv‘İ—^
	            || "1009".equals(item)	//•àsŠí‘İ—^
	            || "1010".equals(item)	//•às•â•‚Â‚¦‘İ—^
	            || "1011".equals(item)	//œpœj’T’m‹@‘İ—^
	            || "1012".equals(item)	//ˆÚ“®—pƒŠƒtƒg‘İ—^
	            || "1013".equals(item)	//©“®”rŸ•‘•’u‘İ—^
            ) {
                result = true;
            }
        }
        //‰îŒì—\–h•Ÿƒ—p‹ï‘İ—^
        if ("67".equals(kind)) {
        	//•Ÿƒ—p‹ïŒn—ñ‚Íˆê—¥’PˆÊ”‚ğo—Í‚µ‚È‚¢B
        	if ("1001".equals(item)		//—\–hÔˆÖq‘İ—^
	            || "1002".equals(item)	//—\–hÔˆÖq•t‘®•i‘İ—^
	            || "1003".equals(item)	//—\–h“ÁêQ‘ä‘İ—^
	            || "1004".equals(item)	//—\–h“ÁêQ‘ä•t‘®•i‘İ—^
	            || "1005".equals(item)	//—\–h°‚¸‚ê–h~—p‹ï‘İ—^
	            || "1006".equals(item)	//—\–h‘ÌˆÊ•ÏŠ·‹@‘İ—^
	            || "1007".equals(item)	//—\–hè‚·‚è‘İ—^
	            || "1008".equals(item)	//—\–hƒXƒ[ƒv‘İ—^
	            || "1009".equals(item)	//—\–h•àsŠí‘İ—^
	            || "1010".equals(item)	//—\–h•às•â•‚Â‚¦‘İ—^
	            || "1011".equals(item)	//—\–hœpœj’T’m‹@‘İ—^
	            || "1012".equals(item)	//—\–hˆÚ“®—pƒŠƒtƒg‘İ—^
	            || "1013".equals(item)	//—\–h©“®”rŸ•‘•’u‘İ—^
            ) {
                result = true;
        	}
        }
        //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
        if ("73".equals(kind)) {
            if ("1101".equals(item)		//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒìŒo
	            || "1111".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚P
	            || "1121".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚Q
	            || "1131".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚R
	            || "1141".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚S
	            || "1151".equals(item)	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚T
	            || "8001".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒìŒoE’è’´
	            || "8011".equals(item)	//¬‘½‹@”\Œ^‹‘î‰î‚PE’è’´
	            || "8021".equals(item)	//¬‘½‹@”\Œ^‹‘î‰î‚QE’è’´
	            || "8031".equals(item)	//¬‘½‹@”\Œ^‹‘î‰î‚RE’è’´
	            || "8041".equals(item)	//¬‘½‹@”\Œ^‹‘î‰î‚SE’è’´
	            || "8051".equals(item)	//¬‘½‹@”\Œ^‹‘î‰î‚TE’è’´
	            || "9001".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒìŒoElŒ‡
	            || "9011".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚PElŒ‡
	            || "9021".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚QElŒ‡
	            || "9031".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚RElŒ‡
	            || "9041".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚SElŒ‡
	            || "9051".equals(item)	//¬‘½‹@”\Œ^‹‘î‰îŒì‚TElŒ‡
            ) {
                result = true;
            }
        }
        //‰îŒì—\–h“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
        if ("35".equals(kind)) {
        	if ("1901".equals(item)		//—\–hŠO•”Ô‚¢‚·‘İ—^
	        	|| "1902".equals(item)	//—\–hŠO•”Ô‚¢‚·•t‘®•i‘İ—^
	        	|| "1903".equals(item)	//—\–hŠO•”“ÁêQ‘ä‘İ—^
	        	|| "1904".equals(item)	//—\–hŠO•”“ÁêQ‘ä•t‘®•i‘İ—^
	        	|| "1905".equals(item)	//—\–hŠO•”°‚¸‚ê–h~—p‹ï‘İ—^
	        	|| "1906".equals(item)	//—\–hŠO•”‘ÌˆÊ•ÏŠ·Ší‘İ—^
	        	|| "1907".equals(item)	//—\–hŠO•”è‚·‚è‘İ—^
	        	|| "1908".equals(item)	//—\–hŠO•”ƒXƒ[ƒv‘İ—^
	        	|| "1909".equals(item)	//—\–hŠO•”•àsŠí‘İ—^
	        	|| "1910".equals(item)	//—\–hŠO•”•às•â•‚Â‚¦‘İ—^
	        	|| "1911".equals(item)	//—\–hŠO•”œpœjŠ´’m‹@Ší‘İ—^
	        	|| "1912".equals(item)	//—\–hŠO•”ˆÚ“®—pƒŠƒtƒg‘İ—^
	            || "1913".equals(item)	//—\–hŠO•”©“®”rŸ•‘•’u‘İ—^
        	) {
        		result = true;
        	}
        }
        
        return result;
        
    	// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 add - end
    }
    
    /**
     * ƒT[ƒrƒX‰ñ”‚ğŒ‚Ì“ú”‚É•ÏX‚·‚éƒT[ƒrƒX‚©Šm”F‚·‚éB
     * @param serviceCodeKind ƒT[ƒrƒXƒR[ƒhí—Ş
     * @param serviceCodeItem ƒT[ƒrƒXƒR[ƒh€–Ú
     * @return true : ’PˆÊ”‚ğ‹LÚ‚µ‚È‚¢ false : ’PˆÊ”‚ğ‹LÚ‚·‚é
     * @throws Exception
     */
    // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - begin   ƒT[ƒrƒXƒR[ƒh‰p”‰»‚É‚æ‚è‚±‚Ìƒ`ƒFƒbƒN•û–@‚ğíœ
    /*
    public static boolean isMaxCountService(int kind, int item) throws Exception {
        
        boolean result = false;
        
        switch(kind){
        //“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
        case 33:
            switch(item){
            //ŠO•”ÔˆÖq‘İ—^
            case 2001:
            //ŠO•”ÔˆÖq•t‘®•i‘İ—^
            case 2002:
            //ŠO•”“ÁêQ‘ä‘İ—^
            case 2003:
            //ŠO•”“ÁêQ‘ä•t‘®•i‘İ—^
            case 2004:
            //ŠO•”°‚¸‚ê–h~—p‹ï‘İ—^
            case 2005:
            //ŠO•”‘ÌˆÊ•ÏŠ·‹@‘İ—^
            case 2006:
            //ŠO•”è‚·‚è‘İ—^
            case 2007:
            //ŠO•”ƒXƒ[ƒv‘İ—^
            case 2008:
            //ŠO•”•àsŠí‘İ—^
            case 2009:
            //ŠO•”•às•â•‚Â‚¦‘İ—^
            case 2010:
            //ŠO•””oæ~Š´’mŠí‘İ—^
            case 2011:
            //ŠO•”ˆÚ“®—pƒŠƒtƒg‘İ—^
            case 2012:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin •½¬24”N4Œ–@‰ü³‘Î‰
            //ŠO•”©“®”rŸ•‘•’u‘İ—^
            case 2013:
            //[ID:0000711][Shin Fujihara] 2012/03 add end •½¬24”N4Œ–@‰ü³‘Î‰
                result = true;
                break;
            }
            break;
        //•Ÿƒ—p‹ï‘İ—^
        case 17:
            //•Ÿƒ—p‹ïŒn—ñ‚Íˆê—¥’PˆÊ”‚ğo—Í‚µ‚È‚¢B
            switch(item){
            //ÔˆÖq‘İ—^
            case 1001:
            //ÔˆÖq•t‘®•i‘İ—^
            case 1002:
            //“ÁêQ‘ä‘İ—^
            case 1003:
            //“ÁêQ‘ä•t‘®•i‘İ—^
            case 1004:
            //°‚¸‚ê–h~—p‹ï‘İ—^
            case 1005:
            //‘ÌˆÊ•ÏŠ·‹@‘İ—^
            case 1006:
            //è‚·‚è‘İ—^
            case 1007:
            //ƒXƒ[ƒv‘İ—^
            case 1008:
            //•àsŠí‘İ—^
            case 1009:
            //•às•â•‚Â‚¦‘İ—^
            case 1010:
            //œpœj’T’m‹@‘İ—^
            case 1011:
            //ˆÚ“®—pƒŠƒtƒg‘İ—^
            case 1012:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin •½¬24”N4Œ–@‰ü³‘Î‰
            //©“®”rŸ•‘•’u‘İ—^
            case 1013:
            //[ID:0000711][Shin Fujihara] 2012/03 add end •½¬24”N4Œ–@‰ü³‘Î‰
                result = true;
                break;
            }
            break;
            
        //‰îŒì—\–h•Ÿƒ—p‹ï‘İ—^
        case 67:
        	//•Ÿƒ—p‹ïŒn—ñ‚Íˆê—¥’PˆÊ”‚ğo—Í‚µ‚È‚¢B
        	switch(item){
            //—\–hÔˆÖq‘İ—^
            case 1001:
            //—\–hÔˆÖq•t‘®•i‘İ—^
            case 1002:
            //—\–h“ÁêQ‘ä‘İ—^
            case 1003:
            //—\–h“ÁêQ‘ä•t‘®•i‘İ—^
            case 1004:
            //—\–h°‚¸‚ê–h~—p‹ï‘İ—^
            case 1005:
            //—\–h‘ÌˆÊ•ÏŠ·‹@‘İ—^
            case 1006:
            //—\–hè‚·‚è‘İ—^
            case 1007:
            //—\–hƒXƒ[ƒv‘İ—^
            case 1008:
            //—\–h•àsŠí‘İ—^
            case 1009:
            //—\–h•às•â•‚Â‚¦‘İ—^
            case 1010:
            //—\–hœpœj’T’m‹@‘İ—^
            case 1011:
            //—\–hˆÚ“®—pƒŠƒtƒg‘İ—^
            case 1012:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin •½¬24”N4Œ–@‰ü³‘Î‰
            //—\–h©“®”rŸ•‘•’u‘İ—^
            case 1013:
            //[ID:0000711][Shin Fujihara] 2012/03 add end •½¬24”N4Œ–@‰ü³‘Î‰
                result = true;
                break;
        	}
        	break;
            
        //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
        case 73:
            switch(item){
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒìŒo
            case 1101:
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚P
            case 1111:
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚Q
            case 1121:
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚R
            case 1131:
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚S
            case 1141:
            //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚T
            case 1151:
            //¬‘½‹@”\Œ^‹‘î‰îŒìŒoE’è’´
            case 8001:
            //¬‘½‹@”\Œ^‹‘î‰î‚PE’è’´
            case 8011:
            //¬‘½‹@”\Œ^‹‘î‰î‚QE’è’´
            case 8021:
            //¬‘½‹@”\Œ^‹‘î‰î‚RE’è’´
            case 8031:
            //¬‘½‹@”\Œ^‹‘î‰î‚SE’è’´
            case 8041:
            //¬‘½‹@”\Œ^‹‘î‰î‚TE’è’´
            case 8051:
            //¬‘½‹@”\Œ^‹‘î‰îŒìŒoElŒ‡
            case 9001:
            //¬‘½‹@”\Œ^‹‘î‰îŒì‚PElŒ‡
            case 9011:
            //¬‘½‹@”\Œ^‹‘î‰îŒì‚QElŒ‡
            case 9021:
            //¬‘½‹@”\Œ^‹‘î‰îŒì‚RElŒ‡
            case 9031:
            //¬‘½‹@”\Œ^‹‘î‰îŒì‚SElŒ‡
            case 9041:
            //¬‘½‹@”\Œ^‹‘î‰îŒì‚TElŒ‡
            case 9051:
            
            //[ID:0000497][Shin Fujihara] 2009/04/28 add begin áŠQ‘Î‰
//
//        	//[ID:0000447][Shin Fujihara] 2009/02 add begin •½¬21”N4Œ–@‰ü³‘Î‰
//        	//¬‹K–Í‘½‹@”\Œ^”F’mÇ‰ÁZ‡T
//        	case 6128:
//        	//¬‹K–Í‘½‹@”\Œ^”F’mÇ‰ÁZ‡U
//        	case 6129:
//        	//¬‹K–Í‘½‹@”\Œ^ŠÅŒìEˆõ”z’u‰ÁZ‡T
//        	case 6137:
//        	//¬‹K–Í‘½‹@”\Œ^ŠÅŒìEˆõ”z’u‰ÁZ‡U
//        	case 6138:
//        	//¬‹K–Í‘½‹@”\Œ^–‹ÆŠJnx‰‡‰ÁZ‡T
//        	case 6139:
//        	//¬‹K–Í‘½‹@”\Œ^–‹ÆŠJnx‰‡‰ÁZ‡U
//        	case 6140:
//        	//¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡T
//        	case 6101:
//        	//¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡U
//        	case 6102:
//        	//¬‘½‹@”\Œ^ƒT[ƒrƒX’ñ‹Ÿ‘Ì§‰ÁZ‡V
//        	case 6103:
//        	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P
//        	case 7001:
//        	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚Q
//        	case 7002:
//        	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚R
//        	case 7003:
//        	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚S
//        	case 7004:
//        	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚T
//        	case 7005:
//        	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚U
//        	case 7006:
//        	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚V
//        	case 7007:
//        	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚W
//        	case 7008:
//        	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚X
//        	case 7009:
//        	//¬‹K–Í‘½‹@”\Œ^s’¬‘º“Æ©‰ÁZ‚P‚O
//        	case 7010:
//        	//[ID:0000447][Shin Fujihara] 2009/02 add end •½¬21”N4Œ–@‰ü³‘Î‰
//
            //[ID:0000497][Shin Fujihara] 2009/04/28 add end áŠQ‘Î‰
                result = true;
                break;
            }
            break;
            
        //‰îŒì—\–h“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
        case 35:
        	switch(item){
        	//—\–hŠO•”Ô‚¢‚·‘İ—^
        	case 1901:
        	//—\–hŠO•”Ô‚¢‚·•t‘®•i‘İ—^
        	case 1902:
        	//—\–hŠO•”“ÁêQ‘ä‘İ—^
        	case 1903:
        	//—\–hŠO•”“ÁêQ‘ä•t‘®•i‘İ—^
        	case 1904:
        	//—\–hŠO•”°‚¸‚ê–h~—p‹ï‘İ—^
        	case 1905:
        	//—\–hŠO•”‘ÌˆÊ•ÏŠ·Ší‘İ—^
        	case 1906:
        	//—\–hŠO•”è‚·‚è‘İ—^
        	case 1907:
        	//—\–hŠO•”ƒXƒ[ƒv‘İ—^
        	case 1908:
        	//—\–hŠO•”•àsŠí‘İ—^
        	case 1909:
        	//—\–hŠO•”•às•â•‚Â‚¦‘İ—^
        	case 1910:
        	//—\–hŠO•”œpœjŠ´’m‹@Ší‘İ—^
        	case 1911:
        	//—\–hŠO•”ˆÚ“®—pƒŠƒtƒg‘İ—^
        	case 1912:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin •½¬24”N4Œ–@‰ü³‘Î‰
            //—\–hŠO•”©“®”rŸ•‘•’u‘İ—^
            case 1913:
            //[ID:0000711][Shin Fujihara] 2012/03 add end •½¬24”N4Œ–@‰ü³‘Î‰
        		result = true;
        		break;
        	}
        	break;
        	
//        //‰îŒì—\–h¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì
//        case 75:
//        	switch(item){
//        	//—\–h¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚P
//        	case 1111:
//        	//—\–h¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚Q
//        	case 1121:
//        	//—\¬‹K–Í‘½‹@”\Œ^‹‘î‚PE’è’´
//        	case 8011:
//        	//—\¬‹K–Í‘½‹@”\Œ^‹‘î‚QE’è’´
//        	case 8021:
//        	//—\¬‹K–Í‘½‹@”\Œ^‹‘î‚PElŒ‡
//        	case 9011:
//        	//—\¬‹K–Í‘½‹@”\Œ^‹‘î‚QElŒ‡
//        	case 9021:
//        		result = true;
//        		break;
//        	}
//        	break;
        }
        
        return result;
    }
    */
    // [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 del - end
    
    /**
     * —˜—pÒ•‰’SŠz‚ğæ“¾‚·‚éB
     * @param serviceCode
     * @param patientState
     * @return
     * @throws Exception
     */
    public static int getRiyosyaFutan(VRMap serviceCode, QP001PatientState patientState) throws Exception {
        Object unit = null;
        
        switch(QP001SpecialCase.getServiceKind(serviceCode)){
        //H”ï
        case 1:
            unit = patientState.getShisetsuData("LIMIT_SHOKUHI");
            break;
        //ƒ†ƒjƒbƒgŒ^ŒÂ
        case 2:
            unit = patientState.getShisetsuData("LIMIT_UNIT_KOSHITSU");
            break;
        //ƒ†ƒjƒbƒgŒ^€ŒÂº
        case 3:
            unit = patientState.getShisetsuData("LIMIT_UNIT_JUNKOSHITSU");
            break;
        //]—ˆŒ^ŒÂº(“Á—{“™)
        case 4:
            unit = patientState.getShisetsuData("LIMIT_JURAIGATA1");
            break;
        //]—ˆŒ^ŒÂº(˜VŒ’E—Ã—{“™)
        case 5:
            unit = patientState.getShisetsuData("LIMIT_JURAIGATA2");
            break;
        //‘½°º
        case 6:
            unit = patientState.getShisetsuData("LIMIT_TASHOSHITSU");
            break;
        }
        
        return ACCastUtilities.toInt(unit,0);
    }
    
    /**
     * ’P‰¿‚ğæ“¾‚·‚éB
     * @param serviceDetail
     * @param serviceCode
     * @return
     * @throws Exception
     */
    public static int getUnit(VRMap serviceDetail, VRMap serviceCode,QP001Manager manager) throws Exception {
        int unit = 0;
        //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
        int defaultUnit = Integer.MIN_VALUE;
        //[ID:0000641][Shin Fujihara] 2011/04/14 add end
        
        //ƒT[ƒrƒX‚Ìí•Ê‚ğ”»’è‚·‚é
        //H”ï‚Ìê‡‚ÍAƒT[ƒrƒXƒR[ƒh‚Éİ’è‚³‚ê‚Ä‚¢‚é’P‰¿‚ğ•Ô‹p‚·‚éB
        if(QP001SpecialCase.getServiceKind(serviceCode) == 1){
            unit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode),0);
            
            //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
            //ƒ}ƒXƒ^‚©‚çH”ï‚ÌŠî€Šz‚ğæ“¾
            defaultUnit = manager.getDefaultFoodCost();
            //[ID:0000641][Shin Fujihara] 2011/04/14 add end
            
        //ƒzƒeƒ‹ƒRƒXƒg‚Í–‹ÆŠ‚É“o˜^‚³‚ê‚Ä‚é’l‚ğæ“¾‚·‚éB
        } else {
            unit = manager.getHotelUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),String.valueOf(serviceCode.get("SERVICE_CODE_ITEM")));
            
            // [ID:0000641][Shin Fujihara] 2011/04/13 edit begin
            // Šî€Šz‚Æ–‹ÆŠÚ×“o˜^‰æ–Ê‚Å“ü—Í‚³‚ê‚½‹àŠz‚ğ”äŠr‚µA‹àŠz‚Ì’á‚¢‚Ù‚¤‚ğÌ—p‚·‚é‚æ‚¤C³B
            defaultUnit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode),0);
            
//            if(unit == Integer.MIN_VALUE){
//                unit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode),0);
//            }
            // [ID:0000641][Shin Fujihara] 2011/04/13 edit end

        }
        
        //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
        //Šî€ŠzˆÈã‚Ì’l‚ªİ’è‚³‚ê‚Ä‚¢‚ê‚ÎAŠî€Šz‚É–ß‚·
        if((unit == Integer.MIN_VALUE) || (defaultUnit < unit)) {
            unit = defaultUnit;
        }
        //[ID:0000641][Shin Fujihara] 2011/04/14 add end
        
        return unit;
    }
    
    /**
     * ’nˆæ–§’…Œ^ƒT[ƒrƒX‚Å‚ ‚é‚©‚ğæ“¾‚·‚éB
     * @param serviceCodeKind
     * @return
     * @throws Exception
     */
    public static boolean isRegionStickingService(String serviceCodeKind) throws Exception {
        //int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        //return isRegionStickingService(kind);
    	
    	boolean result = false;
    	if ("32".equals(serviceCodeKind)	//”F’mÇ‘Î‰Œ^
    		|| "36".equals(serviceCodeKind)	//’nˆæ“Á’è{İ
    		|| "37".equals(serviceCodeKind)	//—\–h”F’mÇ
    		|| "38".equals(serviceCodeKind)	//”F’mÇ’ZŠú
    		|| "39".equals(serviceCodeKind)	//—\–h”F’m’ZŠú
    		|| "54".equals(serviceCodeKind)	//’nˆæ•Ÿƒ{İ
    		|| "71".equals(serviceCodeKind)	//–éŠÔ–K–â‰îŒì
    		|| "72".equals(serviceCodeKind)	//”F’mÇ’ÊŠ
    		|| "73".equals(serviceCodeKind)	//¬‹K–Í‘½‹@”\
    		|| "74".equals(serviceCodeKind)	//—\–h”F’m’ÊŠ
    		|| "75".equals(serviceCodeKind)	//—\–h¬‹K–Í
    		|| "77".equals(serviceCodeKind)	//•¡‡Œ^ 2015.03.04 add
    		|| "68".equals(serviceCodeKind)	//¬‹K–Í‘½‹@”\’ZŠú 2015.03.04 add
    		|| "69".equals(serviceCodeKind)	//—\–h¬‹K–Í‘½‹@”\’ZŠú 2015.03.04 add
    		|| "79".equals(serviceCodeKind)	//•¡‡Œ^’ZŠú 2015.03.04 add
    		) {
    		result = true;
    	}
    	return result;
    }
    /**
     * ’nˆæ–§’…Œ^ƒT[ƒrƒX‚Å‚ ‚é‚©‚ğæ“¾‚·‚éB
     * @param kind
     * @return
     * @throws Exception
     */
    /*
    public static boolean isRegionStickingService(int kind) throws Exception {
        boolean result = false;
        
        switch(kind){
        //”F’mÇ‘Î‰Œ^
        case 32:
        //’nˆæ“Á’è{İ
        case 36:
        //—\–h”F’mÇ
        case 37:
        //”F’mÇ’ZŠú
        case 38:
        //—\–h”F’m’ZŠú
        case 39:
        //’nˆæ•Ÿƒ{İ
        case 54:
        //–éŠÔ–K–â‰îŒì
        case 71:
        //”F’mÇ’ÊŠ
        case 72:
        //¬‹K–Í‘½‹@”\
        case 73:
        //—\–h”F’m’ÊŠ
        case 74:
        //—\–h¬‹K–Í
        case 75:
            result = true;
            break;
        }
        return result;
    }
    */
// 2014/12/24 [Yoichiro Kamei] add - begin ZŠ’n“Á—á‘Î‰
    /**
     * ZŠ’n“Á—á‚É‚Ä–¾×‘‹LÚ‘ÎÛ‚Ì’nˆæ–§’…Œ^ƒT[ƒrƒX‚Å‚ ‚é‚©‚ğæ“¾‚·‚éB
     * @param serviceCodeKind
     * @return
     * @throws Exception
     */
    public static boolean isRegionStickingServiceForJushotiTokurei(String serviceCodeKind) throws Exception {
    	/*
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        boolean result = false;
        
        switch(kind){
        //–éŠÔ–K–â‰îŒì
        case 71:
        //”F’mÇ’ÊŠ
        case 72:
        //¬‹K–Í‘½‹@”\
        case 73:
        //—\–h”F’m’ÊŠ
        case 74:
        //—\–h¬‹K–Í
        case 75:
        //’èŠú„‰ñ
        case 76:
        //•¡‡Œ^ƒT[ƒrƒX
        case 77:
            result = true;
            break;
        }
        return result;
        */
    	boolean result = false;
    	if ("71".equals(serviceCodeKind)	//–éŠÔ–K–â‰îŒì
    		|| "72".equals(serviceCodeKind)	//”F’mÇ’ÊŠ
    		|| "73".equals(serviceCodeKind)	//¬‹K–Í‘½‹@”\
    		|| "74".equals(serviceCodeKind)	//—\–h”F’m’ÊŠ
    		|| "75".equals(serviceCodeKind)	//—\–h¬‹K–Í
    		|| "76".equals(serviceCodeKind)	//’èŠú„‰ñ
    		|| "77".equals(serviceCodeKind)	//•¡‡Œ^ƒT[ƒrƒX
    		) {
    		result = true;
    	}
    	return result;
    }
// 2014/12/24 [Yoichiro Kamei] add - end
    
    
    //[ID:0000523][Shin Fujihara] 2009/07 add begin 2009”N“x‘Î‰
    /**
     * 
     * @param discriminationNo
     * @param insurerdNo
     * @param selfPay
     * @param usedSelfPay
     * @param kohi
     * @param nursing
     * @return
     * @throws Exception
     */
    public static int getApplicationIndividualPayment(
    		String discriminationNo,
    		String insurerdNo,
    		int selfPay,
    		int usedSelfPay,
    		String kohi,
    		QP001RecordNursing nursing) throws Exception {
    	
    	
    	int nursingKohiCost = 0;
    	
    	if ((nursing != null)
    		&& (nursing.get_801007() == 99)){
    		nursingKohiCost = nursing.get_801026();
    	}
    	
    	
    	return getApplicationIndividualPayment(discriminationNo, insurerdNo, selfPay, usedSelfPay, kohi, nursingKohiCost);
    }

    /**
     * 
     * @param discriminationNo
     * @param insurerdNo
     * @param selfPay
     * @param usedSelfPay
     * @param kohi
     * @param nursing
     * @return
     * @throws Exception
     */
    public static int getApplicationIndividualPayment(
    		String discriminationNo,
    		String insurerdNo,
    		int selfPay,
    		int usedSelfPay,
    		String kohi,
    		VRMap nursing) throws Exception {
    	
    	
    	int nursingKohiCost = 0;
    	
    	if ((nursing != null)
        	&& (ACCastUtilities.toInt(nursing.get("801007"), 0) == 99)){
        	nursingKohiCost = ACCastUtilities.toInt(nursing.get("801026"), 0);
        }
    	
    	return getApplicationIndividualPayment(discriminationNo, insurerdNo, selfPay, usedSelfPay, kohi, nursingKohiCost);
    }
    //[ID:0000523][Shin Fujihara] 2009/07 add end 2009”N“x‘Î‰
    
    /**
     * “Á’èf—Ã”ï‚Ö‚ÌŒö”ï©ŒÈ•‰’SŠz‚ğæ“¾‚·‚éB
     * @param discriminationNo —l®”Ô†
     * @param insurerdNo ”í•ÛŒ¯Ò”Ô† 
     * @param selfPay ©ŒÈ•‰’SŠz
     * @param usedSelfPay Šù‚Ég—pÏ‚İ‚ÌŒö”ï©ŒÈ•‰’SŠz
     * @return “Á’èf—Ã”ï‚É“K—p‰Â”\‚ÈŒö”ï©ŒÈ•‰’SŠz
     * @throws Exception
     */
    //[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009”N“x‘Î‰
    //public static int getApplicationIndividualPayment(String discriminationNo,String insurerdNo,int selfPay,int usedSelfPay, String kohi) throws Exception {
    public static int getApplicationIndividualPayment(String discriminationNo,String insurerdNo,int selfPay,int usedSelfPay, String kohi, int nursingKohiCost) throws Exception {
    //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009”N“x‘Î‰
        //—l®‘æ”ªA‘æ‹ãA‘æ\‚Å‚È‚¯‚ê‚Î“K—p‰Â”\
        if(!isShisetsuDiscriminationNo(discriminationNo)){
            return selfPay;
        }
        //¶•Û’P“Æ‚Å‚ ‚ê‚Î“K—p‰Â”\
        if(isSeihoOnly(insurerdNo)){
            return selfPay;
        }
        
        //[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009”N“x‘Î‰
        /*
        if(SEIHO_SELF_PAY < (selfPay + usedSelfPay)){
            return SEIHO_SELF_PAY - usedSelfPay;
        }
        */
        if((kohi != null) && (kohi.startsWith("12"))){
        	
        	if (nursingKohiCost > 0) {
	            if(SEIHO_SELF_PAY < (selfPay + usedSelfPay)){
	                return SEIHO_SELF_PAY - usedSelfPay;
	            }
        	}
        }
        //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009”N“x‘Î‰
        
        return selfPay;
    }

    // add sta 2006.05.20 fujihara.shin
    /**
     * ‹Ù‹}¡—Ãî•ñƒŒƒR[ƒh‚Ì’l‚Æ‚µ‚Ä‘Ã“–‚Å‚ ‚é‚©”»’è‚·‚éB
     * @param map ŒŸØ‚ğs‚¤ƒf[ƒ^
     * @return true:‘Ã“–‚Å‚ ‚é@false:‘Ã“–‚Å‚È‚¢
     * @throws Exception
     */
    public static boolean isValidRecordEmergency(VRMap map) throws Exception {
    	
    	if(map == null){
    		return false;
    	}
    	
    	//ƒ•K{€–Ú„
    	//‚¢‚Ã‚ê‚©‚Ğ‚Æ‚Â‚Å‚à“ü—Í‚³‚ê‚Ä‚¢‚ê‚ÎOK
    	//‹Ù‹}•a–¼1 40Œ…
    	if(!ACTextUtilities.isNullText(map.get("401008"))){
    		return true;
    	}
    	//‹Ù‹}•a–¼2 40Œ…
    	if(!ACTextUtilities.isNullText(map.get("401009"))){
    		return true;
    	}
    	//‹Ù‹}•a–¼3 40Œ…
    	if(!ACTextUtilities.isNullText(map.get("401010"))){
    		return true;
    	}
    	//‹Ù‹}¡—ÃŠJn”NŒ“ú1 8Œ…(YYYYMMDD)
    	if(!ACTextUtilities.isNullText(map.get("401011"))){
    		return true;
    	}
    	//‹Ù‹}¡—ÃŠJn”NŒ“ú2 8Œ…(YYYYMMDD)
    	if(!ACTextUtilities.isNullText(map.get("401012"))){
    		return true;
    	}
    	//‹Ù‹}¡—ÃŠJn”NŒ“ú3 8Œ…(YYYYMMDD)
    	if(!ACTextUtilities.isNullText(map.get("401013"))){
    		return true;
    	}
    	//“E—v1 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401026"))){
    		return true;
    	}
    	//“E—v2 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401027"))){
    		return true;
    	}
    	//“E—v3 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401028"))){
    		return true;
    	}
    	//“E—v4 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401029"))){
    		return true;
    	}
    	//“E—v5 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401030"))){
    		return true;
    	}
    	//“E—v6 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401031"))){
    		return true;
    	}
    	//“E—v7 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401032"))){
    		return true;
    	}
    	//“E—v8 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401033"))){
    		return true;
    	}
    	//“E—v9 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401034"))){
    		return true;
    	}
    	//“E—v10 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401035"))){
    		return true;
    	}
    	//“E—v11 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401036"))){
    		return true;
    	}
    	//“E—v12 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401037"))){
    		return true;
    	}
    	//“E—v13 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401038"))){
    		return true;
    	}
    	//“E—v14 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401039"))){
    		return true;
    	}
    	//“E—v15 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401040"))){
    		return true;
    	}
    	//“E—v16 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401041"))){
    		return true;
    	}
    	//“E—v17 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401042"))){
    		return true;
    	}
    	//“E—v18 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401043"))){
    		return true;
    	}
    	//“E—v19 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401044"))){
    		return true;
    	}
    	//“E—v20 64Œ…
    	if(!ACTextUtilities.isNullText(map.get("401045"))){
    		return true;
    	}
    	
    	//ƒƒyƒA‚Å•K{‚È€–Ú„
    	//‰f“ú”2Œ… - ‰fˆã—Ã‹@ŠÖ–¼40Œ…
    	if((ACCastUtilities.toInt(map.get("401014"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("401015"))){
    		return true;
    	}
    	//’Ê‰@“ú”2Œ… -’Ê‰@ˆã—Ã‹@ŠÖ–¼40Œ… 
    	if((ACCastUtilities.toInt(map.get("401016"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("401017"))){
    		return true;
    	}
    	
    	return false;
    }
    // add end 2006.05.20 fujihara.shin
    
    
    /**
     * ‹Ù‹}¡—Ãî•ñƒŒƒR[ƒh‚Ì’l‚Æ‚µ‚Ä‘Ã“–‚Å‚ ‚é‚©”»’è‚·‚éB
     * @param map ŒŸØ‚ğs‚¤ƒf[ƒ^
     * @return true:‘Ã“–‚Å‚ ‚é@false:‘Ã“–‚Å‚È‚¢
     * @throws Exception
     */
    public static boolean isValidRecordEmergencyOwnFacility(VRMap map) throws Exception {
        
        if(map == null){
            return false;
        }
        
        //ƒ•K{€–Ú„
        //‚¢‚Ã‚ê‚©‚Ğ‚Æ‚Â‚Å‚à“ü—Í‚³‚ê‚Ä‚¢‚ê‚ÎOK
        String[] needsList = new String[]{
                "1701008",        //‹Ù‹}•a–¼1 40Œ…
                "1701009",        //‹Ù‹}•a–¼2 40Œ…
                "1701010",        //‹Ù‹}•a–¼3 40Œ…
                "1701011",        //‹Ù‹}¡—ÃŠJn”NŒ“ú1 8Œ…(YYYYMMDD)
                "1701012",        //‹Ù‹}¡—ÃŠJn”NŒ“ú2 8Œ…(YYYYMMDD)
                "1701013",        //‹Ù‹}¡—ÃŠJn”NŒ“ú3 8Œ…(YYYYMMDD)
                "1701026",        //“E—v1 64Œ…
                "1701027",        //“E—v2 64Œ…
                "1701028",        //“E—v3 64Œ…
                "1701029",        //“E—v4 64Œ…
                "1701030",        //“E—v5 64Œ…
                "1701031",        //“E—v6 64Œ…
                "1701032",        //“E—v7 64Œ…
                "1701033",        //“E—v8 64Œ…
                "1701034",        //“E—v9 64Œ…
                "1701035",        //“E—v10 64Œ…
                "1701036",        //“E—v11 64Œ…
                "1701037",        //“E—v12 64Œ…
                "1701038",        //“E—v13 64Œ…
                "1701039",        //“E—v14 64Œ…
                "1701040",        //“E—v15 64Œ…
                "1701041",        //“E—v16 64Œ…
                "1701042",        //“E—v17 64Œ…
                "1701043",        //“E—v18 64Œ…
                "1701044",        //“E—v19 64Œ…
                "1701045",        //“E—v20 64Œ…
                "1701047",        //©{İ—Ã—{”ï•a–¼1 40Œ…
                "1701048",        //©{İ—Ã—{”ï•a–¼2 40Œ…
                "1701049",        //©{İ—Ã—{”ï•a–¼3 40Œ…
                "1701050",        //©{İ—Ã—{”ïŠJn”NŒ“ú1 8Œ…(YYYYMMDD)
                "1701051",        //©{İ—Ã—{”ïŠJn”NŒ“ú2 8Œ…(YYYYMMDD)
                "1701052"        //©{İ—Ã—{”ïŠJn”NŒ“ú3 8Œ…(YYYYMMDD)
                };
        
        for (String needs : needsList) {
            if(!ACTextUtilities.isNullText(map.get(needs))){
                return true;
            }
        }
        
        //ƒƒyƒA‚Å•K{‚È€–Ú„
        //‰f“ú”2Œ… - ‰fˆã—Ã‹@ŠÖ–¼40Œ…
        if((ACCastUtilities.toInt(map.get("1701014"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("1701015"))){
            return true;
        }
        //’Ê‰@“ú”2Œ… -’Ê‰@ˆã—Ã‹@ŠÖ–¼40Œ… 
        if((ACCastUtilities.toInt(map.get("1701016"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("1701017"))){
            return true;
        }
        
        return false;
    }
    
    /**
     * ŠY“–‚ÌƒT[ƒrƒX‚Ì‘½°º‚Éƒ`ƒFƒbƒN‚ª•t‚¢‚Ä‚¢‚é‚©”»’è‚·‚éB
     * @return
     * @throws Exception
     */
    public static boolean isMultiFloorRoom(VRMap serviceCode) throws Exception {
    	boolean result = false;
    	/*
    	if (serviceDetail.containsKey("1210103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1210103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1220102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1220102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1220119")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1220119"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230113")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230113"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230203")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230203"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230212")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230212"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230303")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230303"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230311")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230311"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230401")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230401"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230411")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230411"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1240102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1240102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1250102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1250102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260203")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260203"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260304")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260304"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260401")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260401"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1510102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1510102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1520102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1520102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1530103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1530103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1530203")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1530203"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1530303")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1530303"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1540103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1540103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1590102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1590102"), 0) == 5) {
				result = true;
			}
		}
		*/
    	if (ACCastUtilities.toInt(serviceCode.get("ROOM_TYPE"), 0) == 3) {
    	    result = true;
    	}
    	return result;
    }
    
    /**
     * –¾×î•ñƒŒƒR[ƒh‚ÌƒVƒŠƒAƒ‹”Ô†‚É•t‰Á‚·‚é’l‚ğæ“¾‚·‚éB
     * @param serviceDetail
     * @param serviceCode
     * @return
     * @throws Exception
     */
    public static String getDetailSerial(VRMap serviceDetail,VRMap serviceCode) throws Exception {
    	
    	String result = "";
    	
        // ƒT[ƒrƒXí—ŞƒR[ƒh
        String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode),"");
        //ƒVƒXƒeƒ€“àƒT[ƒrƒX€–ÚƒR[ƒh
        String systemServiceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", serviceCode),"");
        
        //•Ÿƒ—p‹ï‚Ì“K—pİ’è
        if("17".equals(serviceCodeKind) || "67".equals(serviceCodeKind)){
	        if(serviceDetail.containsKey("1170104")){
	            //ƒVƒXƒeƒ€“àƒT[ƒrƒXí—ŞƒR[ƒh‚ª2‚©‚çn‚Ü‚Á‚Ä‚¢‚éê‡‚ÍA
	            //“Á•Ê’nˆæ‰ÁZ‚ÌƒŒƒR[ƒh
	        	//[ID:0000447][Shin Fujihara] 2009/04 add begin •½¬21”N4Œ–@‰ü³‘Î‰
	            //if(!systemServiceCodeItem.startsWith("2")){
	        	//”»’fŠî€‚ğ•ÏX
	        	//ƒT[ƒrƒX€–ÚƒR[ƒh‚ª8‚Ån‚Ü‚Á‚Ä‚¢‚ê‚ÎA“Á•Ê’nˆæE’†RŠÔ‚Ì‰ÁZ
	        	//if(!systemServiceCodeItem.startsWith("2")){
	        	String serviceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_ITEM", serviceCode),"");
	        	if(!serviceCodeItem.startsWith("8")){
	            //[ID:0000447][Shin Fujihara] 2009/04 add end •½¬21”N4Œ–@‰ü³‘Î‰
	                //‰æ–Êã‚Ì•Ÿƒ—p‹ï“E—v—“‚É“ü—Í‚ª‚ ‚éê‡
	                if(!ACTextUtilities.isNullText(serviceDetail.get("1170104"))){
	                    //“E—v—“‚É•Ÿƒ—p‹ï‚Ì“E—v—“‚É“ü—Í‚³‚ê‚½’l‚ğ“ü—Í‚·‚éB
	                	result = String.valueOf(DETAIL_SERIAL++);
	                }
	            }
	        }
        }
        
        /*
         * ¡“Á’è{İ“ü‹Ò¶Šˆ‰îŒìA‰îŒì—\–h“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
         * EŠO•”ƒT[ƒrƒX—˜—pŒ^‚É‚¨‚¯‚é•Ÿƒ—p‹ï‘İ—^A‰îŒì—\–h•Ÿƒ—p‹ï‘İ—^
         * yƒvƒƒOƒ‰ƒ€’†‚Ì‰ğßz
         * ‰æ–Êã‚É“ü—Í‚³‚ê‚½’l‚ğQÆ
         * 
         * ¦¦¦’ˆÓ¦¦¦
         * ƒVƒXƒeƒ€“àƒT[ƒrƒXí—ŞƒR[ƒh‚ğg—p‚µ‚ÄA”»’è‚µ‚Ä‚¢‚Ü‚·B
         */
        //ƒT[ƒrƒXí—ŞƒR[ƒh‚ª33‚Å‚ ‚è
        if("33".equals(serviceCodeKind)){
            //ƒVƒXƒeƒ€“àƒT[ƒrƒXí—ŞƒR[ƒh‚ª27‚©‚çn‚Ü‚è
            if(systemServiceCodeItem.startsWith("27")){
                //“E—v—“‚É“ü—Í‚³‚ê‚Ä‚¢‚é€–Ú‚ª‚ ‚éê‡
                if(serviceDetail.containsKey("1330120")){
                    //“E—v—“‚ÉŠO•”—˜—p•Ÿƒ—p‹ï‚Ì“E—v—“‚É“ü—Í‚³‚ê‚½’l‚ğİ’è‚·‚éB
                	result = String.valueOf(DETAIL_SERIAL++);
                }
            }
        }
        
        //¦¦¦’ˆÓ¦¦¦
        //ƒVƒXƒeƒ€“àƒT[ƒrƒXí—ŞƒR[ƒh‚ğg—p‚µ‚ÄA”»’è‚µ‚Ä‚¢‚Ü‚·B
        
        //ƒT[ƒrƒXí—ŞƒR[ƒh‚ª35‚Å‚ ‚è
        if("35".equals(serviceCodeKind)){
            //ƒVƒXƒeƒ€“àƒT[ƒrƒXí—ŞƒR[ƒh‚ª27‚©‚çn‚Ü‚è
            if(systemServiceCodeItem.startsWith("27")){
                //“E—v—“‚É“ü—Í‚³‚ê‚Ä‚¢‚é€–Ú‚ª‚ ‚éê‡
                if(serviceDetail.containsKey("1170104")){
                    //“E—v—“‚ÉŠO•”—˜—p•Ÿƒ—p‹ï‚Ì“E—v—“‚É“ü—Í‚³‚ê‚½’l‚ğİ’è‚·‚éB
                	result = String.valueOf(DETAIL_SERIAL++);
                }
            }
        }
        
        return result;
    }
    
    /**
     * —l®‘æ“ñ‚Ì“ñ‚É‚¨‚¢‚ÄA—\–h–K–â‰îŒì‚P‚Æ—\–h–K–â‰îŒì‚PE‚R‹‰‚ªƒT[ƒrƒX‚É“o˜^‚³‚ê‚Ä‚¢‚½<br>
     * ê‡A—\–h–K–â‰îŒì‚PE‚R‹‰‚Ì‚İ¿‹‚ğs‚È‚¤B<br>
     * ¨  2015.4 ‰ü³‘Î‰
     *     2012”N‚Éu—\–h–K–â‰îŒì‚PE‚R‹‰v‚ª”p~‚³‚êAu—\–h–K–â‰îŒì‡TE‰”Cvu—\–h–K–â‰îŒì‡TE“¯ˆêvu—\–h–K–â‰îŒì‡TE‰”CE“¯ˆêv
     *     ‚ª’Ç‰Á‚³‚ê‚Ä‚¢‚é‚±‚Æ‚É‘Î‰‚³‚ê‚Ä‚¢‚È‚¢‚½‚ßC³‚ğs‚Á‚½B
     * ‰îŒì—\–h–K–â‰îŒìƒT[ƒrƒXi“úŠ„‚ğœ‚­j‚Å‚ ‚ê‚ÎAtrue‚ğ•Ô‹p‚·‚éB
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isArrangementData(String serviceCodeKind, String serviceCodeItem) throws Exception {
    	boolean result = false;
    	
    	// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 edit - begin   ƒT[ƒrƒXƒR[ƒh‰p”‰»‚Æ–¢‘Î‰ƒR[ƒh”»’è’Ç‰Á
    	//int kind = ACCastUtilities.toInt(serviceCodeKind,0);
    	//int item = ACCastUtilities.toInt(serviceCodeItem,0);
    	
		//ƒT[ƒrƒXí—ŞƒR[ƒh‚ÌŠm”F
//		if(kind == 61){
//			switch(item){
//			//—\–h–K–â‰îŒì‚P
//			case 1111:
//			//—\–h–K–â‰îŒì‚PE‚R‹‰
//			case 1112:
//			//—\–h–K–â‰îŒì‚Q
//			case 1211:
//			//—\–h–K–â‰îŒì‚QE‚R‹‰
//			case 1212:
//			//—\–h–K–â‰îŒì‚R
//			case 1321:
//			//—\–h–K–â‰îŒì‚RE‚R‹‰
//			case 1322:
//				result = true;
//				break;
//			}
//		}
    	//—\–h–K–â‰îŒì
		if ("61".equals(serviceCodeKind)){
			if ("1111".equals(serviceCodeItem)		//—\–h–K–â‰îŒì‚P
				|| "1113".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚PE‰”C
				|| "1114".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚PE“¯ˆê
				|| "1115".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚PE‰”CE“¯ˆê
				|| "1211".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚Q
				|| "1213".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚QE‰”C
				|| "1214".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚QE“¯ˆê
				|| "1215".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚QE‰”CE“¯ˆê
				|| "1321".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚R
				|| "1323".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚RE‰”C
				|| "1324".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚RE“¯ˆê
				|| "1325".equals(serviceCodeItem)	//—\–h–K–â‰îŒì‚RE‰”CE“¯ˆê
			) {
				result = true;
			}
		}
		// [H27.4‰ü³‘Î‰][Shinobu Hitaka] 2015/1/20 edit - end
		
		return result;
    }
    
    //[ID:0000529][Shin Fujihara] 2009/07 add begin 2009”N“x‘Î‰
    /**
     * ‘ÎÛ‚ÌƒT[ƒrƒX‚ªÀ“ú”‚Æ‚µ‚ÄŒvã‚·‚×‚«‚©”»’è‚·‚é
     * @param serviceDetail
     * @param serviceCode
     * @return
     * @throws Exception
     */
    //[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009”N“x‘Î‰
    //public static boolean isRealDay(VRMap serviceDetail) throws Exception {
    public static boolean isRealDay(VRMap serviceDetail, VRMap serviceCode) throws Exception {
    //[ID:0000586][Shin Fujihara] 2010/01 edit end 2009”N“x‘Î‰
    	if (serviceDetail.containsKey("DUMMY")) {
    		return false;
    	}
    	
    	// –{•[‚Éˆóš‚·‚é‚ÌƒL[‚ª‚È‚¢ê‡‚ÍƒT[ƒrƒX’ñ‹Ÿƒf[ƒ^‚Æ‚µ‚Äˆµ‚¤
    	// —\–h“Á’è“ü‹Ò¶Šˆ‰îŒì‚Ì‚İˆÙ‚È‚éƒoƒCƒ“ƒhƒpƒX
    	String[] checkBindPath = { "15", "1350129", "1350130", "1350131" };

    	for (int i = 0; i < checkBindPath.length; i++) {
    	    // –{•[‚Éˆóš‚·‚éƒ`ƒFƒbƒN‚ª‘¶İ‚·‚éê‡
    	    if (ACCastUtilities.toInt(serviceDetail.getData(checkBindPath[i]), 0) == 1) {
    	        // ƒ`ƒFƒbƒN‚ª‚È‚¢ê‡‚Ì‚İ’ñ‹Ÿ“úˆÈŠO‚Ìƒf[ƒ^‚Æ‚·‚é
    	        return false;
    	    }
    	}
    	
    	//[ID:0000586][Shin Fujihara] 2010/01 add begin 2009”N“x‘Î‰
    	String systemServiceKindDetail = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceCode),"");
    	//¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒìA‚Ü‚½‚Í—\–h¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒì‚Å‚ ‚éê‡
    	if ("17311".equals(systemServiceKindDetail) || "17511".equals(systemServiceKindDetail)) {
    		//‰Šú‰ÁZ‚ª‰ÁZ‚Ì‚İ‚ÅZ’è‚³‚ê‚Ä‚¢‚éê‡‚ÍAÀ“ú”‚Æ‚µ‚ÄŒvã‚µ‚È‚¢
    		if (serviceDetail.containsKey("9")) {
    			if (ACCastUtilities.toInt(serviceDetail.get("9"), 0) == 2) {
    				return false;
    			}
    		}
    	}
    	//[ID:0000586][Shin Fujihara] 2010/01 add end 2009”N“x‘Î‰
    	
    	return true;
    }
    //[ID:0000529][Shin Fujihara] 2009/07 add end 2009”N“x‘Î‰
    
    //[ID:0000720][Shin Fujihara] 2012/04 add start 2012”N“x‘Î‰
    // QP001RecordDetail‚Ìˆ—‚ğˆÚ“®
    /**
     * ƒT[ƒrƒX‚Ì’ñ‹Ÿ‰ñ”‚ğæ“¾‚·‚é(ŠÅæ‚èŠÅŒì‘Î‰)
     * @param serviceCodeKind ƒT[ƒrƒXí—ŞƒR[ƒh
     * @param serviceCodeItem ƒT[ƒrƒX€–ÚƒR[ƒh
     * @param serviceDetail ƒT[ƒrƒXÚ×
     * @return ’ñ‹Ÿ‰ñ”
     * @throws Exception
     */
    public static int getServiceCount(String serviceCodeKind, String serviceCodeItem, VRMap serviceDetail) throws Exception {
        
        int count = 1;
        
        
        //”F’mÇ‘Î‰Œ^‹¤“¯¶Šˆ‰îŒìi’ZŠú—˜—pˆÈŠOj
        if ("32".equals(serviceCodeKind)) {
            
            //6142:”F’mÇ‘Î‰Œ^ŠÅæ‚èŠÅŒì‰ÁZ‚P 6143:”F’mÇ‘Î‰Œ^ŠÅæ‚èŠÅŒì‰ÁZ‚Q
            if("6142".equals(serviceCodeItem) || "6143".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1320115"),1);
            }
            
// 2015/3/9 [H27.4‰ü³‘Î‰][Yoichiro Kamei] add - begin
        //“Á’è{İ“ü‹Ò¶Šˆ‰îŒì
        } else if ("33".equals(serviceCodeKind)) {
            
            //6125:“Á’è{İŠÅæ‚è‰îŒì‰ÁZ‚P 6126:“Á’è{İŠÅæ‚è‰îŒì‰ÁZ‚Q
            if("6125".equals(serviceCodeItem) || "6126".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1330133"),1);
            }
// 2015/3/9 [H27.4‰ü³‘Î‰][Yoichiro Kamei] add - begin
        //‰îŒì•Ÿƒ{İ
        } else if ("51".equals(serviceCodeKind)) {
            
            //6276:•Ÿƒ{İŠÅæ‚è‰îŒì‰ÁZ‚P 6277:•Ÿƒ{İŠÅæ‚è‰îŒì‰ÁZ‚Q
            if("6276".equals(serviceCodeItem) || "6277".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1510132"),1);
            }
            
            
        //‰îŒì•ÛŒ’{İ
        } else if ("52".equals(serviceCodeKind)) {
            
            //6600:•ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚P‚P 6001:•ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚P‚Q
            //6602:•ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚Q‚P 6002:•ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚Q‚Q
            if ("6600".equals(serviceCodeItem)
                || "6001".equals(serviceCodeItem)
                || "6602".equals(serviceCodeItem)
                || "6002".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1520150"),1);
            }
            
            
        //’nˆæ–§’…Œ^‰îŒì•Ÿƒ{İ
        } else if ("54".equals(serviceCodeKind)) {
            
            //6276:’n•Ÿƒ{İŠÅæ‚è‰îŒì‰ÁZ‚P 6277:’n•Ÿƒ{İŠÅæ‚è‰îŒì‰ÁZ‚Q
            if("6276".equals(serviceCodeItem) || "6277".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1540128"),1);
            }
        
// 2015/3/17 [H27.4‰ü³‘Î‰][Shinobu Hitaka] add - begin
        //¬‹K–Í‘½‹@”\Œ^‹‘î‰îŒìi’ZŠú—˜—pˆÈŠOj
        } else if ("73".equals(serviceCodeKind)) {
            
            //4000:¬‘½‹@”\Œ^ŠÅæ‚è˜AŒg‘Ì§‰ÁZ
            if("4000".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1730116"),1);
            }
// 2017/3/9 [H27.4‰ü³‘Î‰][Shinobu Hitaka] add - begin
            
        }
            
        return count;
    }
    //[ID:0000720][Shin Fujihara] 2012/04 add end 2012”N“x‘Î‰
    
    //[ID:0000720][Shin Fujihara] 2012/04 add start 2012”N“x‘Î‰
    /**
     * ŠÅæ‚èŠÅŒìEƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚Å€–S“ú‚ğ‚ ‚ç‚í‚·ƒR[ƒh‚Å‚ ‚é‚©
     * @param serviceCodeKind ƒT[ƒrƒXí—ŞƒR[ƒh
     * @param serviceCodeItem ƒT[ƒrƒX€–ÚƒR[ƒh
     * @return true:€–S“ú‚Ì‰ÁZ false:’Êí‚ÌƒT[ƒrƒXƒR[ƒh
     * @throws Exception
     */
    public static boolean isMitori(String serviceCodeKind, String serviceCodeItem) throws Exception {
        
        //–K–âŠÅŒì
        if ("13".equals(serviceCodeKind)) {
            //–K–âŠÅŒìƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
            if ("7000".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //•Ÿƒ{İ
        if ("51".equals(serviceCodeKind)) {
            //•Ÿƒ{İŠÅæ‚è‰îŒì‰ÁZ‚R
            if ("6283".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //’n•Ÿƒ{
        if ("54".equals(serviceCodeKind)) {
            //’n•Ÿƒ{İŠÅæ‚è‰îŒì‰ÁZ‚R
            if ("6283".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //•ÛŒ’{İ
        if ("52".equals(serviceCodeKind)) {
            //•ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚R‚PA•ÛŒ’{İƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ‚R‚Q
            if ("6603".equals(serviceCodeItem)
             || "6003".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //”F’mÇ‘Î‰Œ^
        if ("32".equals(serviceCodeKind)) {
            //”F’mÇ‘Î‰Œ^ŠÅæ‚è‰îŒì‰ÁZ‚R
            if ("6144".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //“Á’è{İ
        if ("33".equals(serviceCodeKind)) {
            //“Á’è{İŠÅæ‚è‰îŒì‰ÁZ‚R
            if ("6127".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //’nˆæ“Á’è{İ
        if ("36".equals(serviceCodeKind)) {
            //’nˆæ“Á’è{İŠÅæ‚è‰îŒì‰ÁZ‚R
            if ("6127".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //’èŠú„‰ñ
        if ("76".equals(serviceCodeKind)) {
            //’èŠú„‰ñƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
            if ("6100".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //•¡‡Œ^
        if ("77".equals(serviceCodeKind)) {
            //•¡‡Œ^ƒ^[ƒ~ƒiƒ‹ƒPƒA‰ÁZ
            if ("6100".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        return false;
    }
    //[ID:0000720][Shin Fujihara] 2012/04 add end 2012”N“x‘Î‰
    
}
