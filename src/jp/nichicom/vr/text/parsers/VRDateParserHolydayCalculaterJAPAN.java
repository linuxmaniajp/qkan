/** TODO <HEAD> */
package jp.nichicom.vr.text.parsers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;



/**
 * 和暦用の標準祝祭日特定クラスです。
 * <p>
 * 春分の日、秋分の日、振り替え休日、国民の休日を特定可能です。
 * </p>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/06/31
 * @see VRDateParser
 * @see VRDateParserHolydayCalculatable
 */
public class VRDateParserHolydayCalculaterJAPAN implements
        VRDateParserHolydayCalculatable {
    private static final Boolean REPEAT_CHECK_FLAG = new Boolean(true);

    public void stockHolyday(Calendar cal, List<VRDateParserHolyday> holydays, Object parameter) {

        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH);
        int d = cal.get(Calendar.DATE);

        switch (m) {
        case Calendar.MARCH:
            //3月
            if ((y >= 1900) && (2099 >= y)) {
                int springEquinoxDay = (int) Math.floor(0.24242d * y - Math.floor(y / 4.0d) + 35.84d);
                if (d == springEquinoxDay) {
                    holydays.add(new VRDateParserHolyday("春分の日"));
                    return;
                }
            }
            break;
        case Calendar.SEPTEMBER:
            //9月
            if ((y >= 1900) && (2099 >= y)) {
                int autumnalEquinoxDay = (int) Math.floor(0.24204d * y - Math.floor(y / 4.0d) + 39.01d);
                if (d == autumnalEquinoxDay) {
                    holydays.add(new VRDateParserHolyday("秋分の日"));
                    return;
                }
            }
            break;
        }
        if (parameter == REPEAT_CHECK_FLAG) {
            //重複再帰防止のため返却
            return;
        }
        
        if(!holydays.isEmpty()){
            //すでに他の祝日が該当
            return;
        }

        int wday =cal.get(Calendar.DAY_OF_WEEK); 
        if(wday==Calendar.SUNDAY){
            //当日が日曜なら祝日ではない
            return;
        }        
        
        
        Calendar behindDay = Calendar.getInstance();

        //前日チェック
        behindDay.setTime(cal.getTime());
        behindDay.add(Calendar.DATE, -1);
        ArrayList<VRDateParserHolyday> behindHolydays = new ArrayList<VRDateParserHolyday>();
        
        if(y<2007){
            //2006年までは振り替え休日は月曜に限定
            if (isEmptyHolyday(behindDay, behindHolydays)) {
                //前日が平日なら祝日になり得ない
                return;
            }
            if (wday == Calendar.MONDAY) {
                // 振り替え休日に該当
                holydays.add(new VRDateParserHolyday("振り替え休日"));
                return;
            }
        }else{
            //2007年からの振り替え休日は祝日明けの平日            
            while(true){
                int bwday = behindDay.get(Calendar.DAY_OF_WEEK); 
                if (isEmptyHolyday(behindDay, behindHolydays)) {
                    //前日は祝日ではない
                    if(bwday!=Calendar.SUNDAY){
                        //日曜以外なら振り替え休日にはならない
                        break;
                    }
                }else{
                    //前日は祝日
                    if(bwday==Calendar.SUNDAY){
                        //前日は日曜の祝日
                        // 振り替え休日に該当
                        holydays.add(new VRDateParserHolyday("振り替え休日"));
                        return;
                    }
                }
                //さらに前日をチェック
                behindDay.add(Calendar.DATE, -1);
            }
            
        }

        //翌日チェック
        behindDay.setTime(cal.getTime());
        behindDay.add(Calendar.DATE, 1);
        if (isEmptyHolyday(behindDay, behindHolydays)) {
            //翌日が祝日でなければ国民の休日にはならない
            return;
        }

        if(wday != Calendar.SUNDAY) {
            //日曜でない
            behindDay.setTime(cal.getTime());
            behindDay.add(Calendar.DATE, -1);
            if (!isEmptyHolyday(behindDay, behindHolydays)) {
                //前日の祝日をチェック
                boolean behindIsTransferHolyday = false;
                Iterator<VRDateParserHolyday> it=behindHolydays.iterator();
                while(it.hasNext()){
                    VRDateParserHolyday h = it.next();
                    if("振り替え休日".equals(h.getId())){
                        behindIsTransferHolyday = true;
                        break;
                    }
                }
                if(!behindIsTransferHolyday){
                    //前日の祝日は振り替え休日以外の場合
                    //国民の休日に該当
                    holydays.add(new VRDateParserHolyday("国民の休日"));
                }
            }
        }
        return;
    }
    /**
     * 指定日に祝日が存在しないかを返します。
     * @param cal 検査日
     * @param holydays 祝日定義蓄積先
     * @return 指定日に祝日が存在しないか
     */
    protected boolean isEmptyHolyday(Calendar cal, List<VRDateParserHolyday> holydays){
        holydays.clear();
        VRDateParser.getLocale(Locale.JAPAN).getHolydays().stockHolyday(cal, holydays, REPEAT_CHECK_FLAG);
        VRDateParser.getLocale(VRDateParser.FREE_LOCALE).getHolydays().stockHolyday(cal, holydays, REPEAT_CHECK_FLAG);
        return holydays.isEmpty();
    }
}