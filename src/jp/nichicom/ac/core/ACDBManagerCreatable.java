package jp.nichicom.ac.core;

import jp.nichicom.ac.sql.ACDBManager;
/**
 * システムデフォルトのDBManager生成インターフェースです。
 * <p>
 * 主として、ACFrameEventProcesserインターフェースとあわせてシステムイベント処理クラスに実装します。
 * </p>
 * <p>
 * デフォルトのDBManagerを生成できるシステムであれば、このインターフェースをシステムイベント処理クラスに実装することで、デバッガにクエリアナライザが追加されます。
 * </p>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/10/04
 * @see ACFrameEventProcesser
 */
public interface ACDBManagerCreatable {

    /**
     * システムデフォルトのDBManagerを生成します。
     * 
     * @return DBManager
     * @throws Exception 処理例外
     */
    public ACDBManager createDBManager() throws Exception;
 
}
