package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Iterator;
import java.util.List;

import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanSystemInformation;

/**
 * コードマスタのデータを使うフォーマットです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public final class QkanCodeMasterFormat {
    private int contentID;

    /**
     * コードマスタ上のCONTENT_ID を返します。
     * 
     * @return コードマスタ上のCONTENT_ID
     */
    public int getContentID() {
        return contentID;
    }

    /**
     * コードマスタ上のCONTENT_ID を設定します。
     * 
     * @param contentID コードマスタ上のCONTENT_ID
     */
    public void setContentID(int contentID) {
        this.contentID = contentID;
    }

    /**
     * コンストラクタです。
     */
    public QkanCodeMasterFormat() {
        super();
    }

    /**
     * Parses text from a string to produce an object.
     * <p>
     * The method attempts to parse text starting at the index given by
     * <code>pos</code>. If parsing succeeds, then the index of
     * <code>pos</code> is updated to the index after the last character used
     * (parsing does not necessarily use all characters up to the end of the
     * string), and the parsed object is returned. The updated <code>pos</code>
     * can be used to indicate the starting point for the next call to this
     * method. If an error occurs, then the index of <code>pos</code> is not
     * changed, the error index of <code>pos</code> is set to the index of the
     * character where the error occurred, and null is returned.
     * 
     * @param source A <code>String</code>, part of which should be parsed.
     * @param pos A <code>ParsePosition</code> object with index and error
     *            index information as described above.
     * @return An <code>Object</code> parsed from the string. In case of
     *         error, returns null.
     * @exception NullPointerException if <code>pos</code> is null.
     */
    public Object parseObject(String source, ParsePosition pos) {
        pos.setIndex(1);
        if (source == null) {
            return "";
        }

        Object listObj = QkanSystemInformation.getInstance().getMasterCode()
                .get(new Integer(getContentID()));
        if (listObj instanceof List) {
            List list = (List) listObj;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                VRMap row = (VRMap) it.next();
                try {
                    if (source.equals(String.valueOf(VRBindPathParser.get(
                            "CONTENT", row)))) {
                        return VRBindPathParser.get("CONTENT_KEY", row);
                    }
                } catch (Exception ex) {

                }
            }
        }

        return source;
    }

    /**
     * Formats an object and appends the resulting text to a given string
     * buffer. If the <code>pos</code> argument identifies a field used by the
     * format, then its indices are set to the beginning and end of the first
     * such field encountered.
     * 
     * @param obj The object to format
     * @param toAppendTo where the text is to be appended
     * @param pos A <code>FieldPosition</code> identifying a field in the
     *            formatted text
     * @return the string buffer passed in as <code>toAppendTo</code>, with
     *         formatted text appended
     * @exception NullPointerException if <code>toAppendTo</code> or
     *                <code>pos</code> is null
     * @exception IllegalArgumentException if the Format cannot format the given
     *                object
     */
    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj != null) {

            Object listObj = QkanSystemInformation.getInstance()
                    .getMasterCode().get(new Integer(getContentID()));
            if (listObj instanceof List) {
                List list = (List) listObj;
                String val = String.valueOf(obj);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    VRMap row = (VRMap) it.next();
                    try {
                        if (val.equals(String.valueOf(VRBindPathParser.get(
                                "CONTENT_KEY", row)))) {
                            toAppendTo.append(VRBindPathParser.get("CONTENT",
                                    row));
                            return toAppendTo;
                        }
                    } catch (Exception ex) {

                    }
                }
            }
        }

        return toAppendTo;
    }

}
