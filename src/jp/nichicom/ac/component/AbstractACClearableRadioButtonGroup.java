package jp.nichicom.ac.component;

import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import jp.nichicom.vr.component.VRButton;
import jp.nichicom.vr.component.VRRadioButtonGroup;
import jp.nichicom.vr.layout.VRLayout;

/**
 * クリアボタン対応の基底ラジオグループです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 * @see VRRadioButtonGroup
 */
public class AbstractACClearableRadioButtonGroup extends VRRadioButtonGroup {
    private transient ArrayList actionListeners;
    protected boolean useClearButton = true;
    private VRButton clear;

    /**
     * アクションリスナを追加します。
     * @param l アクションリスナ
     */
    public synchronized void addActionListener(ActionListener l) {
      ArrayList v = actionListeners == null ? new ArrayList(2) : (ArrayList) actionListeners.clone();
      if (!v.contains(l)) {
        v.add(l);
        actionListeners = v;
      }
    }

    /**
     * アクションリスナを除外します。
     * @param l アクションリスナ
     */
    public synchronized void removeActionListener(ActionListener l) {
      if (actionListeners != null && actionListeners.contains(l)) {
        ArrayList v = (ArrayList) actionListeners.clone();
        v.remove(l);
        actionListeners = v;
      }
    }

    /**
     * アクションイベントを発行します。
     * @param e アクションイベント情報
     */
    protected void fireActionPerformed(ActionEvent e) {
      if (actionListeners != null) {
        ArrayList listeners = actionListeners;
        int count = listeners.size();
        for (int i = 0; i < count; i++) {
          ((ActionListener) listeners.get(i)).actionPerformed(e);
        }
      }
    }
    /**
     * コンストラクタです。
     */
    public AbstractACClearableRadioButtonGroup() {
        super();
    }

    public void refreshRadioButton() {
        super.refreshRadioButton();
        if (getClearButton() != null) {
            if (isUseClearButton()) {
                addClearButton(getClearButton());
            } else {
                this.remove(getClearButton());
            }
            revalidate();
        }
    }

    /**
     * クリアボタンをコンテナである自分自身に追加します。
     * <p>
     * template method pattern
     * </p>
     * 
     * @param button 追加するクリアボタン
     */
    protected void addClearButton(JButton button) {
        this.add(button, null);
    }

    /**
     * クリアボタンのツールチップ を返します。
     * 
     * @return クリアボタンのツールチップ
     */
    public String getClearButtonToolTipText() {
        if (getClearButton() == null) {
            return "";
        }
        return getClearButton().getToolTipText();
    }

    /**
     * クリアボタンのツールチップ を設定します。
     * 
     * @param text クリアボタンのツールチップ
     */
    public void setClearButtonToolTipText(String text) {
        if (getClearButton() != null) {
            getClearButton().setToolTipText(text);
        }
    }

    /**
     * クリアボタンを使用するかを返します。
     * 
     * @return クリアボタンを使用するか
     */
    public boolean isUseClearButton() {
        return useClearButton;
    }

    /**
     * クリアボタンを使用するかを設定します。
     * 
     * @param useClearButton クリアボタンを使用するか
     */
    public void setUseClearButton(boolean useClearButton) {
        this.useClearButton = useClearButton;
        refreshRadioButton();
    }

    /**
     * クリアボタンを返します。
     * 
     * @return クリアボタン
     */
    public VRButton getClearButton() {
        if (clear == null) {
            clear = new VRButton();
            clear.setMargin(new Insets(0, 0, 0, 0));
            clear.setText("クリア");
            clear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setSelectedIndex(-1);
                }
            });
        }
        return clear;
    }

    /**
     * 最初の子コントロールにフォーカスを移します。
     */
    public void requestChildFocus() {
        if (getButtonCount() > 0) {
            super.getButton(0).requestFocus();
        }
    }

    protected void addRadioButton(JRadioButton item) {
        int addPos = getRadioButtons().size();
        if (getModel().getSize() > addPos) {
            Object obj = getModel().getElementAt(addPos);
            if (obj instanceof ACRadioButtonItem) {
                this.add(item, ((ACRadioButtonItem) obj).getConstraints());
                return;
            }
        }
        super.addRadioButton(item);
    }

    protected LayoutManager createLayout() {
        VRLayout lay = new VRLayout(VRLayout.LEFT, 8, 0);
        lay.setAutoWrap(false);
        lay.setVAlignment(VRLayout.CENTER);
        return lay;
    }

}
