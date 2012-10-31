package jp.nichicom.ndk.affair.cm.cm001;

import java.awt.Component;
import java.awt.event.ActionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ndk.affair.ce.ce001.CE001;
import jp.nichicom.vr.util.VRMap;

/**
 * CodeWallです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2005/11/04
 */
@SuppressWarnings("serial")
public class CM001 extends CM001Event implements ACAffairable  {
    /**
     * コンストラクタです。
     */
    public CM001(){
    }

    public void initAffair(ACAffairInfo affair) throws Exception  {
      super.initAffair(affair);
      initAction(affair);
    }
    /**
     * 初期化処理を行ないます。
     * @param affair 業務情報
     * @throws Exception 処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {

    }

    //コンポーネントイベント

    /**
     * 「暗号化業務遷移」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void encodeActionPerformed(ActionEvent e) throws Exception{
      // 以下のパラメータで次画面に遷移。
      //     next();

      // 　クラス名　：　CE001
        ACFrame.getInstance().next(new ACAffairInfo(CE001.class.getName()));
    }

    /**
     * 「復号化業務遷移」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void decodeActionPerformed(ActionEvent e) throws Exception{
      //TODO 以下のパラメータで次画面に遷移。
      //TODO     next();

      //TODO 　クラス名　：　CD001

    }

    /**
     * 「起動コード生成業務遷移」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void createExecuteActionPerformed(ActionEvent e) throws Exception{
      //TODO 以下のパラメータで次画面に遷移。
      //TODO     next();

      //TODO 　クラス名　：　CC001

    }

    /**
     * 「システム終了」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void systemExitActionPerformed(ActionEvent e) throws Exception{
      //システムを終了する。
      System.exit(0);
    }

    
    public boolean canBack(VRMap parameters) throws Exception {
        return false;
      }
    
      public Component getFirstFocusComponent() {
        return null;
      }


    public static void main(String[] args) {
        try {
            ACFrame.setVRLookAndFeel();
            ACFrame.getInstance().next(
                    new ACAffairInfo(CM001.class.getName()));
            ACFrame frame = ACFrame.getInstance();
            frame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public boolean canClose() throws Exception {
        return true;
    }
}
