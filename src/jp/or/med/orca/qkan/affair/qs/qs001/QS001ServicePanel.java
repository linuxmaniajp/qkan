package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.LayoutManager;

import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.sql.ACDBManager;

/**
 * サービスパネル用の基底パネルクラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QS001ServicePanel extends ACPanel {
    private ACDBManager dbm;
    private boolean oldFacilityUser;
    private boolean planMode;

    /**
     * 予定モードであるか を返します。
     * @return 予定モードであるか
     */
    public boolean isPlanMode() {
        return planMode;
    }

    /**
     * 予定モードであるか を設定します。
     * @param planMode 予定モードであるか
     */
    public void setPlanMode(boolean planMode) {
        this.planMode = planMode;
    }

    /**
     * 旧措置入所者であるか を返します。
     * @return 旧措置入所者であるか
     */
    public boolean isOldFacilityUser() {
        return oldFacilityUser;
    }

    /**
     * 旧措置入所者であるか を設定します。
     * @param oldFacilityUser 旧措置入所者であるか
     */
    public void setOldFacilityUser(boolean oldFacilityUser) {
        this.oldFacilityUser = oldFacilityUser;
    }

    /**
     * Creates a new <code>JPanel</code> with a double buffer and a flow
     * layout.
     */
    public QS001ServicePanel() {
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
    public QS001ServicePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    /**
     * Create a new buffered JPanel with the specified layout manager
     * 
     * @param layout the LayoutManager to use
     */
    public QS001ServicePanel(LayoutManager layout) {
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
    public QS001ServicePanel(LayoutManager layout, boolean isDoubleBuffered) {
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
}
