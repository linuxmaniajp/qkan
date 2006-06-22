package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * 帳票種類(CLAIM_STYLE_TYPE)を渡された場合、名称に変換するフォーマットです。<br>
 * 公費・減免情報(QU003)で使用します。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanClaimStyleFormat extends Format{
    private static QkanClaimStyleFormat singleton;

    /**
     * コンストラクタです。
     * 
     * @deprecated #getInstanceを使用してください。
     */
    public QkanClaimStyleFormat() {
        super();
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanClaimStyleFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanClaimStyleFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);

        // 帳票種類(CLAIM_STYLE_TYPE)の判定を行う。
        // 10101-介護給付費請求書
        if ("10101".equals(code)) {
            toAppendTo.append("介護給付費請求書");
    		// 10201-様式第ニ
        } else if ("10201".equals(code)) {
            toAppendTo.append("様式第ニ");
    		// 10301-様式第三
        } else if ("10301".equals(code)) {
            toAppendTo.append("様式第三");
    		// 10401-様式第四
        } else if ("10401".equals(code)) {
            toAppendTo.append("様式第四");
    		// 10501-様式第五
        } else if ("10501".equals(code)) {
            toAppendTo.append("様式第五");
    		// 10601-様式第六
        } else if ("10601".equals(code)) {
            toAppendTo.append("様式第六");
    		// 10701-様式第七
        } else if ("10701".equals(code)) {
            toAppendTo.append("様式第七");
    		// 10801-様式第八
        } else if ("10801".equals(code)) {
            toAppendTo.append("様式第八");
    		// 10901-様式第九
        } else if ("10901".equals(code)) {
            toAppendTo.append("様式第九");
    		// 11001-様式第十
        } else if ("11001".equals(code)) {
            toAppendTo.append("様式第十");
    		// 11101-給付管理票総括票
        } else if ("11101".equals(code)) {
            toAppendTo.append("給付管理票総括票");
    		// 11201-給付管理票
        } else if ("11201".equals(code)) {
            toAppendTo.append("給付管理票");
    		// 20101-訪問看護療養費明細書（社保）
        } else if ("20101".equals(code)) {
            toAppendTo.append("訪問看護療養費明細書（社保）");
    		// 20102-訪問看護療養費明細書（国保）
        } else if ("20102".equals(code)) {
            toAppendTo.append("訪問看護療養費明細書（国保）");
    		// 20201-訪問看護療養費請求書（社保）
        } else if ("20201".equals(code)) {
            toAppendTo.append("訪問看護療養費請求書（社保）");
    		// 20202-訪問看護療養費請求書（国保）
        } else if ("20202".equals(code)) {
            toAppendTo.append("訪問看護療養費請求書（国保）");
    		// 30101-利用者向け請求書
        } else if ("30101".equals(code)) {
            toAppendTo.append("利用者向け請求書");
            // 10111-介護給付費請求書
        } else if ("10111".equals(code)) {
            toAppendTo.append("介護給付費請求書");
    		// 10211-様式第ニ
        } else if ("10211".equals(code)) {
            toAppendTo.append("様式第ニ");
    		// 10212-様式第ニの二
        } else if ("10212".equals(code)) {
            toAppendTo.append("様式第ニの二");
    		// 10311-様式第三
        } else if ("10311".equals(code)) {
            toAppendTo.append("様式第三");
    		// 10312-様式第三の二
        } else if ("10312".equals(code)) {
            toAppendTo.append("様式第三の二");
    		// 10411-様式第四
        } else if ("10411".equals(code)) {
            toAppendTo.append("様式第四");
    		// 10412-様式第四の二
        } else if ("10412".equals(code)) {
            toAppendTo.append("様式第四の二");
    		// 10511-様式第五
        } else if ("10511".equals(code)) {
            toAppendTo.append("様式第五");
    		// 10512-様式第五の二
        } else if ("10512".equals(code)) {
            toAppendTo.append("様式第五の二");
    		// 10611-様式第六
        } else if ("10611".equals(code)) {
            toAppendTo.append("様式第六");
    		// 10612-様式第六の二
        } else if ("10612".equals(code)) {
            toAppendTo.append("様式第六の二");
    		// 10613-様式第六の三
        } else if ("10613".equals(code)) {
            toAppendTo.append("様式第六の三");
    		// 10614-様式第六の四
        } else if ("10614".equals(code)) {
            toAppendTo.append("様式第六の四");
    		// 10615-様式第六の五
        } else if ("10615".equals(code)) {
            toAppendTo.append("様式第六の五");
    		// 10616-様式第六の六
        } else if ("10616".equals(code)) {
            toAppendTo.append("様式第六の六");
    		// 10711-様式第七
        } else if ("10711".equals(code)) {
            toAppendTo.append("様式第七");
    		// 10712-様式第七の二
        } else if ("10712".equals(code)) {
            toAppendTo.append("様式第七の二");
    		// 10811-様式第八
        } else if ("10811".equals(code)) {
            toAppendTo.append("様式第八");
    		// 10911-様式第九
        } else if ("10911".equals(code)) {
            toAppendTo.append("様式第九");
    		// 11011-様式第十
        } else if ("11011".equals(code)) {
            toAppendTo.append("様式第十");
    		// 11111-給付管理票総括票
        } else if ("11111".equals(code)) {
            toAppendTo.append("給付管理票総括票");
    		// 11211-給付管理票
        } else if ("11211".equals(code)) {
            toAppendTo.append("給付管理票");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // 帳票種類(CLAIM_STYLE_TYPE)の判定を行う。
        // 10101-介護給付費請求書
        if ("介護給付費請求書".equals(source)) {
            result = "10101";
    		// 10201-様式第ニ
        } else if ("様式第ニ".equals(source)) {
            result = "10201";
    		// 10301-様式第三
        } else if ("様式第三".equals(source)) {
            result = "10301";
    		// 10401-様式第四
        } else if ("様式第四".equals(source)) {
            result = "10401";
    		// 10501-様式第五
        } else if ("様式第五".equals(source)) {
            result = "10501";
    		// 10601-様式第六
        } else if ("様式第六".equals(source)) {
            result = "10601";
    		// 10701-様式第七
        } else if ("様式第七".equals(source)) {
            result = "10701";
    		// 10801-様式第八
        } else if ("様式第八".equals(source)) {
            result = "10801";
    		// 10901-様式第九
        } else if ("様式第九".equals(source)) {
            result = "10901";
    		// 11001-様式第十
        } else if ("様式第十".equals(source)) {
            result = "11001";
    		// 11101-給付管理票総括票
        } else if ("給付管理票総括".equals(source)) {
            result = "11101";
    		// 11201-給付管理票
        } else if ("給付管理票".equals(source)) {
            result = "11201";
    		// 20101-訪問看護療養費明細書（社保）
        } else if ("訪問看護療養費明細書（社保）".equals(source)) {
            result = "20101";
    		// 20102-訪問看護療養費明細書（国保）
        } else if ("訪問看護療養費明細書（国保）".equals(source)) {
            result = "20102";
    		// 20201-訪問看護療養費請求書（社保）
        } else if ("訪問看護療養費請求書（社保）".equals(source)) {
            result = "20201";
    		// 20202-訪問看護療養費請求書（国保）
        } else if ("問看護療養費請求書（国保）".equals(source)) {
            result = "20202";
    		// 30101-利用者向け請求書
        } else if ("利用者向け請求書".equals(source)) {
            result = "30101";
            // 10111-介護給付費請求書
        } else if ("介護給付費請求書".equals(source)) {
            result = "10111";
    		// 10211-様式第ニ
        } else if ("様式第ニ".equals(source)) {
            result = "10211";
    		// 10212-様式第ニの二
        } else if ("様式第ニの二".equals(source)) {
            result = "10212";
    		// 10311-様式第三
        } else if ("様式第三".equals(source)) {
            result = "10311";
    		// 10312-様式第三の二
        } else if ("様式第三の二".equals(source)) {
            result = "10312";
    		// 10411-様式第四
        } else if ("様式第四".equals(source)) {
            result = "10411";
    		// 10412-様式第四の二
        } else if ("様式第四の二".equals(source)) {
            result = "10412";
    		// 10511-様式第五
        } else if ("様式第五".equals(source)) {
            result = "10511";
    		// 10512-様式第五の二
        } else if ("様式第五の二".equals(source)) {
            result = "10512";
    		// 10611-様式第六
        } else if ("様式第六".equals(source)) {
            result = "10611";
    		// 10612-様式第六の二
        } else if ("様式第六の二".equals(source)) {
            result = "10612";
    		// 10613-様式第六の三
        } else if ("様式第六の三".equals(source)) {
            result = "10613";
    		// 10614-様式第六の四
        } else if ("様式第六の四".equals(source)) {
            result = "10614";
    		// 10615-様式第六の五
        } else if ("様式第六の五".equals(source)) {
            result = "10615";
    		// 10616-様式第六の六
        } else if ("様式第六の六".equals(source)) {
            result = "10616";
    		// 10711-様式第七
        } else if ("様式第七".equals(source)) {
            result = "10711";
    		// 10712-様式第七の二
        } else if ("様式第七の二".equals(source)) {
            result = "10712";
    		// 10811-様式第八
        } else if ("様式第八".equals(source)) {
            result = "10811";
    		// 10911-様式第九
        } else if ("様式第九".equals(source)) {
            result = "10911";
    		// 11011-様式第十
        } else if ("様式第十".equals(source)) {
            result = "11011";
    		// 11111-給付管理票総括票
        } else if ("給付管理票総括".equals(source)) {
            result = "11111";
    		// 11211-給付管理票
        } else if ("給付管理票".equals(source)) {
            result = "11211";
        }

        return result;
    }

}
