package jp.nichicom.ac.component;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.component.VRLabel;
import jp.nichicom.vr.container.VRPanel;
import jp.nichicom.vr.layout.VRLayout;

/**
 * 業務ボタンバーです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 * @see ACAffairButton
 * @see VRPanel
 */
public class ACAffairButtonBar extends VRPanel{
  protected ACAffairButton back = new ACAffairButton();
  protected VRLabel title = new VRLabel();
  
  private static Color themaColor = new Color(0, 51, 153);

  /**
   * 戻るボタンの表示状態を設定します。
   * @param backVisible 戻るボタンの表示状態
   */
  public void setBackVisible(boolean backVisible){
    back.setVisible(backVisible);
  }

  /**
   * 戻るボタンの表示状態を返します。
   * @return 戻るボタンの表示状態
   */
  public boolean isBackVisible(){
    return back.isVisible();
  }

  /**
   * 業務タイトルを返します。
   * @deprecated #getTextを使用してください。
   * @return 業務タイトル
   */
  public String getTitle(){
    return title.getText();
  }
  /**
   * 業務タイトルを設定します。
   * @deprecated #setTextを使用してください。
   * @param title 業務タイトル
   */
  public void setTitle(String title){
    this.title.setText(title);
  }

  /**
   * 業務タイトルを返します。
   * @return 業務タイトル
   */
  public String getText(){
    return title.getText();
  }
  /**
   * 業務タイトルを設定します。
   * @param text 業務タイトル
   */
  public void setText(String text){
    this.title.setText(text);
  }


  /**
   * コンストラクタです。
   */
  public ACAffairButtonBar(){
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    
    setBackAffair(ACFrame.getInstance().getBackAffair());
//    setBackAffair(ACFrame.getInstance().getNowAffair());
  }

  /**
   * コンポーネントを初期化します。
   * @throws Exception 初期化例外
   */
  private void jbInit() throws Exception {
    this.setLayout(new VRLayout());
    back.setText("戻る(R)");
    back.setIconPath(ACConstants.ICON_PATH_BACK_24);
    if(title.getFont()!=null){
      title.setFont(new java.awt.Font(title.getFont().getName(),
                                      title.getFont().getStyle(), (int)(title.getFont().getSize()*20.0/11.0)));
    }


    title.setBorder(javax.swing.BorderFactory.createEmptyBorder(4,8,4,8));
    title.setText("業務タイトル");
    title.setHorizontalAlignment(SwingConstants.CENTER);
    back.setText("戻る(R)");
    back.setMnemonic('R');
    back.addActionListener(new ActionListener() {
      protected boolean lockFlag = false;
      public void actionPerformed(ActionEvent e) {
        if(lockFlag){
          return;
        }
        lockFlag = true;
        try {
          ACFrame.getInstance().back();
        }
        catch (Exception ex) {
          //例外の処理はイベント委譲
           ACFrame.getInstance().showExceptionMessage(ex);
        }
        lockFlag = false;
      }

    });
    this.add(back, VRLayout.WEST);
    this.add(title, VRLayout.WEST);

    String osName = System.getProperty("os.name");
    if ( (osName != null) && (osName.indexOf("Mac") < 0)) {
      title.setForeground(java.awt.Color.white);
      // FIXME カラー変更
      //this.setBackground(new java.awt.Color(0, 51, 153));
      this.setBackground(themaColor);
    }

  }

  /**
   * 前画面の情報から初期設定します。
   * @param affair 前画面の業務情報
   */
  protected void setBackAffair(ACAffairInfo affair){
    if (affair == null) {
      back.setToolTipText("メインメニューへ戻ります。");
    }
    else {
      back.setToolTipText(affair.getTitle() + "へ戻ります。");
    }
  }
  /**
   * 前画面へ戻るボタンを返します。
   * @return 前画面へ戻るボタン
   */
  public ACAffairButton getBackButton() {
    return back;
  }
  
   
  public static void setThemaColor(Color color) {
      themaColor = color;
  }
}
