package jp.nichicom.vr.component;

import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 * Editorを変更可能なコンボ用エディタクラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/10/31
 * @see BasicComboBoxEditor
 * @see JTextField
 */
public class VRComboBoxEditor extends BasicComboBoxEditor {
    /**
     * コンストラクタです。
     */
    public VRComboBoxEditor() {
        super();
    }
    /**
     * エディタコンポーネントを設定します。
     * 
     * @param editor エディタコンポーネント
     */
    public void setEditorComponent(JTextField editor) {
        super.editor = editor;
    }
}
