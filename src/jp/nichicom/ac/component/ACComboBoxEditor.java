package jp.nichicom.ac.component;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import jp.nichicom.vr.component.VRComboBoxEditor;

/**
 * フォーカスイベントを監視者のコンボに仲介する機能を持ったコンボエディタです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/08/25
 */
public class ACComboBoxEditor extends VRComboBoxEditor {
    private JComboBox focusObserber;
    private FocusListener bridgeFocusListener;

    /**
     * コンストラクタです。
     */
    public ACComboBoxEditor() {
        super();
        initComponent();
    }

    /**
     * コンストラクタです。
     * 
     * @param focusObserber フォーカス監視者
     */
    public ACComboBoxEditor(JComboBox focusObserber) {
        super();
        initComponent();
        setFocusObserber(focusObserber);
    }

    /**
     * エディタのフォーカスイベントを監視者に橋渡すフォーカスリスナ を返します。
     * 
     * @return エディタのフォーカスイベントを監視者に橋渡すフォーカスリスナ
     */
    protected FocusListener getBridgeFocusListener() {
        return bridgeFocusListener;
    }

    /**
     * エディタのフォーカスイベントを監視者に橋渡すフォーカスリスナ を設定します。
     * 
     * @param bridgeFocusListener エディタのフォーカスイベントを監視者に橋渡すフォーカスリスナ
     */
    protected void setBridgeFocusListener(FocusListener bridgeFocusListener) {
        this.bridgeFocusListener = bridgeFocusListener;
    }

    /**
     * エディタのフォーカス監視者 を返します。
     * 
     * @return エディタのフォーカス監視者
     */
    public JComboBox getFocusObserber() {
        return focusObserber;
    }

    /**
     * エディタのフォーカス監視者 を設定します。
     * 
     * @param focusListener エディタのフォーカス監視者
     */
    public void setFocusObserber(JComboBox focusListener) {
        this.focusObserber = focusListener;
    }

    /**
     * コンポーネントを初期化します。
     */
    protected void initComponent() {
        setBridgeFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (getFocusObserber() != null) {
                    FocusListener[] listeners = getFocusObserber()
                            .getFocusListeners();
                    if (listeners != null) {
                        int end = listeners.length;
                        for (int i = 0; i < end; i++) {
                            listeners[i].focusGained(e);
                        }
                    }
                }
            }

            public void focusLost(FocusEvent e) {
                if (getFocusObserber() != null) {
                    FocusListener[] listeners = getFocusObserber()
                            .getFocusListeners();
                    if (listeners != null) {
                        int end = listeners.length;
                        for (int i = 0; i < end; i++) {
                            listeners[i].focusLost(e);
                        }
                    }
                }
            }
        });
    }

    public void setEditorComponent(JTextField editor) {
        if (getEditorComponent() != null) {
            getEditorComponent().removeFocusListener(getBridgeFocusListener());
        }
        super.setEditorComponent(editor);
        if (editor != null) {
            getEditorComponent().addFocusListener(getBridgeFocusListener());
        }
    }
}
