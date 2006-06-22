package jp.or.med.orca.qkan.affair.qs.qs001;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import jp.nichicom.ac.component.ACComboBox;

/**
 * �����̓��͓��e��A������A�N�V�������X�i�ł��B
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
     * ���͓��e��A�g���܂��B
     * 
     * @param from �l���͌�
     * @param to �l�ݒ��
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
     * �R���X�g���N�^�ł��B
     * 
     * @param a �A�g�Ώ�1
     * @param b �A�g�Ώ�2
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
     * �A�g�Ώ�1 ��Ԃ��܂��B
     * 
     * @return �A�g�Ώ�1
     */
    public ACComboBox getA() {
        return a;
    }

    /**
     * �A�g�Ώ�2 ��Ԃ��܂��B
     * 
     * @return �A�g�Ώ�2
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
     * �A�g�Ώ�1 ��ݒ肵�܂��B
     * 
     * @param a �A�g�Ώ�1
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
     * �A�g�Ώ�2 ��ݒ肵�܂��B
     * 
     * @param b �A�g�Ώ�2
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
