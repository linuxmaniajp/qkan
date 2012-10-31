package jp.nichicom.ac.util;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import jp.nichicom.ac.component.event.ACFollowContainerFormatEventListener;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.bridge.sql.BridgeFirebirdDBManager;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindable;
import jp.nichicom.vr.bind.event.VRBindEvent;
import jp.nichicom.vr.bind.event.VRBindEventListener;
import jp.nichicom.vr.component.AbstractVRTextField;
import jp.nichicom.vr.component.event.VRFormatEvent;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 郵便番号と住所の関連付けクラスです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Koichi Matsumoto
 * @version 1.0 2006/03/31
 */
public class ACZipRelation implements KeyListener, VRBindEventListener {
    private JTextField address;

    private ACDBManager dbManager;

    private ACFollowContainerFormatEventListener followFormatListener = new ACFollowContainerFormatEventListener(
            true);

    private JTextField zipFirst;

    private JTextField zipSecond;

    private String oldzipFirst;

    private String oldzipSecond;
    
    private boolean autoFocusJump = true;
    

    /**
     * コンストラクタです。
     */
    public ACZipRelation() {
        super();
    }

    /**
     * コンストラクタです。
     * 
     * @param zipFirst 郵便番号(前)テキストフィールド
     * @param zipSecond 郵便番号(後)テキストフィールド
     * @param address 住所テキストフィールド
     */
    public ACZipRelation(JTextField zipFirst, JTextField zipSecond,
            JTextField address) {
        super();

        setZipFirst(zipFirst);
        setZipSecond(zipSecond);
        setAddress(address);
    }

    public void updateInput(KeyEvent e) {
        // フォーカスロストイベント
        // 前後の郵便番号がともに3、4桁入力されているならば結合して検索
        // 検索結果があれば住所テキストにsetText

        if ((getZipFirst() == null) || (getZipSecond() == null)) {
            // nullチェック
            return;
        }

        String zip1 = getZipFirst().getText();
        String zip2 = getZipSecond().getText();

        if (zip1.equals(oldzipFirst) && zip2.equals(oldzipSecond)) {
            return;
        }

        oldzipFirst = zip1;
        oldzipSecond = zip2;

        if (isAutoFocusJump() && e != null && getZipFirst() != null
                && e.getComponent() == getZipFirst()) {
            //最初の郵便番号フィールドが最大文字列長分入力されていれば、二番目の郵便番号フィールドにフォーカスを遷移させる
            int firstMaxLen = 3;
            if(getZipFirst() instanceof AbstractVRTextField){
                firstMaxLen = ((AbstractVRTextField)getZipFirst()).getMaxLength();
            }
            if(zip1.length() >= firstMaxLen){
                getZipSecond().requestFocus();
            }
        }
        
        if (zip1.length() <= 0) {
            if (zip2.length() <= 0) {
                // 空欄
                validData(getZipFirst(), zip1);
                return;
            }
            // 桁数不足
            warningData(getZipFirst(), zip2);
            return;
        } else if (zip2.length() <= 0) {
            // 桁数不足
            warningData(getZipFirst(), zip1);
            return;
        }

        try {
            String matchAddress = getMatchAddress(zip1 + "-" + zip2);
            if ((matchAddress != null) && (!"".equals(matchAddress))) {
                validData(getZipFirst(), zip1);
                getAddress().setText(matchAddress);
            } else {
                warningData(getZipFirst(), zip1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 住所テキストフィールド を返します。
     * 
     * @return 住所テキストフィールド
     */
    public JTextField getAddress() {
        return address;
    }

    /**
     * 郵便番号対応表の取得に使用するDBマネージャを返します。
     * 
     * @return DBマネージャ
     */
    public ACDBManager getDBManager() {
        return dbManager;
    }

    /**
     * 郵便番号(前)テキストフィールド を返します。
     * 
     * @return 郵便番号(前)テキストフィールド
     */
    public JTextField getZipFirst() {
        return zipFirst;
    }

    /**
     * 郵便番号(後)テキストフィールド を返します。
     * 
     * @return 郵便番号(後)テキストフィールド
     */
    public JTextField getZipSecond() {
        return zipSecond;
    }

    /**
     * 住所テキストフィールド を設定します。
     * 
     * @param address 住所テキストフィールド
     */
    public void setAddress(JTextField address) {
        this.address = address;
    }

    /**
     * 郵便番号対応表の取得に使用するDBマネージャを設定します。
     * 
     * @param dbManager DBマネージャ
     */
    public void setDBManager(ACDBManager dbManager) {
        this.dbManager = dbManager;
    }

    /**
     * 郵便番号(前)テキストフィールド を設定します。
     * 
     * @param zipFirst 郵便番号(前)テキストフィールド
     */
    public void setZipFirst(JTextField zipFirst) {
        if (this.zipFirst != null) {
            // これまでに設定されていたテキストからドキュメントリスナを除く
            this.zipFirst.removeKeyListener(this);

            if (this.zipFirst instanceof VRBindable) {
                ((VRBindable) this.zipFirst).removeBindEventListener(this);
            }
        }
        this.zipFirst = zipFirst;
        // 新たに設定されたテキストにドキュメントリスナを追加
        if (this.zipFirst != null) {
            zipFirst.addKeyListener(this);

            oldzipFirst = zipFirst.getText();
            if (this.zipFirst instanceof VRBindable) {
                ((VRBindable) this.zipFirst).addBindEventListener(this);
            }
        }
    }

    /**
     * 郵便番号(後)テキストフィールド を設定します。
     * 
     * @param zipSecond 郵便番号(後)テキストフィールド
     */
    public void setZipSecond(JTextField zipSecond) {
        if (this.zipSecond != null) {
            // これまでに設定されていたテキストからドキュメントリスナを除く
            this.zipSecond.removeKeyListener(this);
            
            if (this.zipSecond instanceof VRBindable) {
                ((VRBindable) this.zipSecond).removeBindEventListener(this);
            }
        }
        this.zipSecond = zipSecond;
        // 新たに設定されたテキストにドキュメントリスナを追加
        if (this.zipSecond != null) {
            zipSecond.addKeyListener(this);

            oldzipSecond = zipSecond.getText();
            if (this.zipSecond instanceof VRBindable) {
                ((VRBindable) this.zipSecond).addBindEventListener(this);
            }
        }
    }

    /**
     * 郵便番号一覧取得に使用するDBマネージャを生成します。
     * 
     * @return DBマネージャ
     * @throws Exception 処理例外
     */
    protected ACDBManager createDBManager() throws Exception {
        return new BridgeFirebirdDBManager();
    }

    /**
     * 郵便番号に対応する住所を返します。
     * 
     * @param fullZip "-"結合済みの郵便番号
     * @return 住所(該当しなければnull)
     * @throws Exception 処理例外
     */
    protected String getMatchAddress(String fullZip) throws Exception {
        ACDBManager dbm = getDBManager();

        if (dbm == null) {
            dbm = createDBManager();
            if (dbm == null) {
                return null;
            }
            setDBManager(dbm);
        }
        // コードマスタの取得と変換
        VRList list = dbManager
                .executeQuery("SELECT ADDRESS FROM M_POST WHERE POST_CD = '"
                        + fullZip.replaceAll("'", "''") + "'");

        if (list.size() > 0) {
            return String.valueOf(VRBindPathParser.get("ADDRESS", (VRMap) list
                    .getData()));
        }
        return null;
    }

    /**
     * コンポーネントのコンテナを警告状態にします。
     * 
     * @param comp 対象コンポーネント
     * @param data 設定データ
     */
    protected void warningData(Component comp, String data) {
        followFormatListener.formatWarning(new VRFormatEvent(comp, null, data));
    }

    /**
     * コンポーネントのコンテナを有効状態にします。
     * 
     * @param comp 対象コンポーネント
     * @param data 設定データ
     */
    protected void validData(Component comp, String data) {
        followFormatListener.formatValid(new VRFormatEvent(comp, null, data));
    }

    public void applySource(VRBindEvent e) {
    }

    public void bindSource(VRBindEvent e) {
        if (getZipFirst() != null) {
            oldzipFirst = getZipFirst().getText();
        }
        if (getZipSecond() != null) {
            oldzipSecond = getZipSecond().getText();
        }
    }


    /**
     * 前半のテキストに3桁入力したら自動で後半のテキストにフォーカスを当てるか を返します。
     * @return 前半のテキストに3桁入力したら自動で後半のテキストにフォーカスを当てるか
     */
    public boolean isAutoFocusJump() {
        return autoFocusJump;
    }

    /**
     * 前半のテキストに3桁入力したら自動で後半のテキストにフォーカスを当てるか を設定します。
     * @param autoFocusJump 前半のテキストに3桁入力したら自動で後半のテキストにフォーカスを当てるか
     */
    public void setAutoFocusJump(boolean autoFocusJump) {
        this.autoFocusJump = autoFocusJump;
    }

    /**
     * Invoked when a key has been pressed. 
     * See the class description for {@link KeyEvent} for a definition of 
     * a key pressed event.
     */
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of 
     * a key released event.
     */
    public void keyReleased(KeyEvent e) {
        updateInput(e);
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of 
     * a key typed event.
     */
    public void keyTyped(KeyEvent e) {
    }

}
