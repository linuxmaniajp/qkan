package jp.nichicom.ac.container;

import java.awt.Color;

import jp.nichicom.vr.container.VRLabelContainer;

/**
 * 背面に重ねる用途を想定したラベルコンテナです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 * @see VRLabelContainer
 */

public class ACBackLabelContainer extends ACLabelContainer {
    
    private static Color themaColor = new Color(204, 204, 255);
    
    /**
     * コンストラクタです。
     */
    public ACBackLabelContainer() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * コンポーネントを初期化します。
     * 
     * @throws Exception 初期化例外
     */
    private void jbInit() throws Exception {
        this.setContentAreaFilled(true);
        this.setFocusBackground(themaColor);
    }
    
    /**
     * 背景色の変更対応
     * @param color
     */
    public static void setThemaColor(Color color) {
        themaColor = color;
    }

}
