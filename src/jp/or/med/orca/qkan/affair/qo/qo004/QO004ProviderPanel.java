package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.LayoutManager;

import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.lib.care.claim.print.schedule.CareServiceCodeCalcurater;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.vr.util.VRMap;

/**
 * 事業所パネル用の基底パネルクラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2009/02/25
 */
public class QO004ProviderPanel extends ACPanel {
    private ACDBManager dbm;
    
    /**
     * Creates a new <code>JPanel</code> with a double buffer and a flow
     * layout.
     */
    public QO004ProviderPanel() {
        super();
    }

    /**
     * Creates a new <code>JPanel</code> with <code>FlowLayout</code> and
     * the specified buffering strategy. If <code>isDoubleBuffered</code> is
     * true, the <code>JPanel</code> will use a double buffer.
     * 
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses
     *            additional memory space to achieve fast, flicker-free updates
     */
    public QO004ProviderPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    /**
     * Create a new buffered JPanel with the specified layout manager
     * 
     * @param layout the LayoutManager to use
     */
    public QO004ProviderPanel(LayoutManager layout) {
        super(layout);
    }

    /**
     * Creates a new JPanel with the specified layout manager and buffering
     * strategy.
     * 
     * @param layout the LayoutManager to use
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses
     *            additional memory space to achieve fast, flicker-free updates
     */
    public QO004ProviderPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    /**
     * DBマネージャを設定します。
     * 
     * @param dbm DBマネージャ
     */
    public void setDBManager(ACDBManager dbm) {
        this.dbm = dbm;
    }

    /**
     * DBマネージャを返します。
     * 
     * @return DBマネージャ
     */
    public ACDBManager getDBManager() {
        return dbm;
    }
    
    
    /**
     * 値をバインドした際の処理です。
     * @exception Exception 処理例外
     */
    public void binded() throws Exception{
        
    }

    /**
     * 旧法時代の設定項目を取得します。
     * @return 旧法時代の設定項目
     * @see 継承先でoverrideして実装すること。
     */
    public ACPanel getOldLowElementArea() {
        return null;
    }

    /**
     * 旧法時代の設定項目の表示状態を設定します。
     * @throws Exception 処理例外
     */
    public void setOldLowElementAreaVisible(boolean visible) throws Exception {
        if (visible) {
            setState_OLD_LOW_ELEMENT_AREA_SHOW();
        } else {
            setState_OLD_LOW_ELEMENT_AREA_HIDE();
        }
    }

    /**
     * 「旧法時代の設定項目表示」の状態に設定します。
     * @throws Exception 処理例外
     */
    public void setState_OLD_LOW_ELEMENT_AREA_SHOW() throws Exception {
        ACPanel oldLows = getOldLowElementArea();
        if (oldLows != null) {
            oldLows.setVisible(true);
        }
    }

    /**
     * 「旧法時代の設定項目非表示」の状態に設定します。
     * @throws Exception 処理例外
     */
    public void setState_OLD_LOW_ELEMENT_AREA_HIDE() throws Exception {
        ACPanel oldLows = getOldLowElementArea();
        if (oldLows != null) {
            oldLows.setVisible(false);
        }
    }    
}
