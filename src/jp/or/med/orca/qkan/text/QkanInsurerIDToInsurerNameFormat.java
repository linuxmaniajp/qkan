package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Iterator;

import jp.nichicom.ac.bind.ACBindUtilities;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACNullToBlankFormat;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 保険者IDから保険者名に変換するフォーマット<br/> QP010で使用します。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/08/19
 */
public class QkanInsurerIDToInsurerNameFormat extends Format {
    private VRList insurers;

    /**
     * 保険者一覧 を返します。
     * 
     * @return 保険者一覧
     */
    public VRList getInsurers() {
        return insurers;
    }

    /**
     * 保険者一覧 を設定します。
     * 
     * @param insurers 保険者一覧
     */
    public void setInsurers(VRList insurers) {
        this.insurers = insurers;
    }

    /**
     * コンストラクタです。
     */
    public QkanInsurerIDToInsurerNameFormat() {
        super();
    }

    /**
     * コンストラクタです。
     * 
     * @param insurers 保険者一覧
     */
    public QkanInsurerIDToInsurerNameFormat(VRList insurers) {
        super();
        setInsurers(insurers);
    }

    public Object parseObject(String source, ParsePosition pos) {
        // 保険者名から保険者番号へ
        if (getInsurers() != null) {
            try {
                VRMap row = ACBindUtilities.getMatchRowFromValue(getInsurers(),
                        "INSURER_NAME", source);
                if (row != null) {
                    return ACNullToBlankFormat.getInstance().format(
                            VRBindPathParser.get("INSURER_ID", row));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
        // 保険者番号から保険者名へ
        if (getInsurers() != null) {
            try {
                String val = ACCastUtilities.toString(obj, "");
                if (!"".equals(val)) {
                    Iterator it = getInsurers().iterator();
                    while (it.hasNext()) {
                        VRMap row = (VRMap) it.next();
                        String id = ACCastUtilities.toString(VRBindPathParser
                                .get("INSURER_ID", row), "*");
                        if (val.endsWith(id)) {
                            //医療の保険者番号を考慮し、末尾が一致すればOK
                            toAppendTo.append(ACNullToBlankFormat.getInstance()
                                    .format(
                                            VRBindPathParser.get(
                                                    "INSURER_NAME", row)));
                            break;
                        }
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return toAppendTo;
    }

}
