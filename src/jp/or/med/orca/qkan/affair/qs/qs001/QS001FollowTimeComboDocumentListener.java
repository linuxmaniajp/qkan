package jp.or.med.orca.qkan.affair.qs.qs001;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import jp.nichicom.ac.component.ACComboBox;

/**
 * 時刻の入力内容を連動するアクションリスナです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QS001FollowTimeComboDocumentListener implements DocumentListener {
    private static boolean lock = false;

    /**
     * 入力内容を連携します。
     * 
     * @param from 値入力元
     * @param to 値設定先
     */
    public static void followValue(ACComboBox from, ACComboBox to) {
        if (lock) {
            return;
        }
        lock = true;
        if ((from != null) && (to != null)) {
            String fromVal = from.getText();
            String toVal = to.getText();
            if (!fromVal.equals(toVal)) {
                to.setText(fromVal);
            }
        }
        lock = false;
    }

    private ACComboBox a;

    private ACComboBox b;

    /**
     * コンストラクタです。
     * 
     * @param a 連携対象1
     * @param b 連携対象2
     */
    public QS001FollowTimeComboDocumentListener(ACComboBox a, ACComboBox b) {
        setA(a);
        setB(b);
    }

    public void changedUpdate(DocumentEvent e) {
        if (e.getDocument() == a.getDocument()) {
            followValue(a, b);
        } else {
            followValue(b, a);
        }
    }

    /**
     * 連携対象1 を返します。
     * 
     * @return 連携対象1
     */
    public ACComboBox getA() {
        return a;
    }

    /**
     * 連携対象2 を返します。
     * 
     * @return 連携対象2
     */
    public ACComboBox getB() {
        return b;
    }

    public void insertUpdate(DocumentEvent e) {
        if (e.getDocument() == a.getDocument()) {
            followValue(a, b);
        } else {
            followValue(b, a);
        }
    }

    public void removeUpdate(DocumentEvent e) {

        if (e.getDocument() == a.getDocument()) {
            followValue(a, b);
        } else {
            followValue(b, a);
        }
    }

    /**
     * 連携対象1 を設定します。
     * 
     * @param a 連携対象1
     */
    public void setA(ACComboBox a) {
        if (this.a != null) {
            this.a.getDocument().removeDocumentListener(this);
        }
        this.a = a;
        if (this.a != null) {
            this.a.getDocument().addDocumentListener(this);
        }
    }

    /**
     * 連携対象2 を設定します。
     * 
     * @param b 連携対象2
     */
    public void setB(ACComboBox b) {
        if (this.b != null) {
            this.b.getDocument().removeDocumentListener(this);
        }
        this.b = b;
        if (this.b != null) {
            this.b.getDocument().addDocumentListener(this);
        }
    }
}
