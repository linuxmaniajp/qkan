package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.datatransfer.DataFlavor;

/**
 * サービスクラス用のデータフレーバです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/11
 */
public class QS001ServiceDataFlavor extends DataFlavor {
    public static final String FLAVOR_OF_SERVICE = "application/qkan-service";
    private static QS001ServiceDataFlavor singleton;

    /**
     * コンストラクタです。
     * 
     * @throws ClassNotFoundException 処理例外
     */
    protected QS001ServiceDataFlavor() throws ClassNotFoundException {
        super(Object.class, FLAVOR_OF_SERVICE);
    }

    /**
     * インスタンスを返します。
     * @return インスタンス
     */
    public static QS001ServiceDataFlavor getInstance() {
        if (singleton == null) {
            try {
                singleton = new QS001ServiceDataFlavor();
            } catch (Exception ex) {
                return null;
            }
        }
        return singleton;
    }
}
