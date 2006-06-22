package jp.or.med.orca.qkan.affair.qs.qs001;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.vr.util.VRMap;

/**
 * サービス予定/実績で使用するサービスをあらわすインターフェースです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/01/09
 */
public interface QS001Service {
    /**
     * 初期化します。
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception;

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * @param provider 選択事業所
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception;
    
    /**
     * 入力内容に不備がないかをチェックし、サービスデータを返します。
     * @return 不備がなければMapを、不備があればメッセージとともにnullを返す。
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception;
    /**
     * 事業所情報を必要とするかを返します。
     * @return 事業所情報を必要とするか
     * @throws Exception 処理例外
     */
    public boolean isUseProvider() throws Exception;
    
    /**
     * 開始時刻入力用のコンボを返します。
     * @return 開始時刻入力用のコンボ
     */
    public ACComboBox getBeginTimeCombo() throws Exception;
    
    /**
     * 終了時刻入力用のコンボを返します。
     * @return 終了時刻入力用のコンボ
     */
    public ACComboBox getEndTimeCombo() throws Exception;
}
