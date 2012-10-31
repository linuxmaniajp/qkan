package jp.nichicom.ac.component;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JRadioButton;
import javax.swing.event.ListSelectionEvent;

/**
 * クリアボタン対応のラジオグループです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 * @see AbstractACClearableRadioButtonGroup
 */
public class ACClearableRadioButtonGroup extends AbstractACClearableRadioButtonGroup {
  protected int noSelectIndex = 0;
  protected int offset = -1;

  /**
   * コンストラクタです。
   */
  public ACClearableRadioButtonGroup(){
    super();
  }

  public JRadioButton getButton(int index){
    if (index == getNoSelectIndex()) {
      index = -1;
    }
    else {
      index += getOffset();
    }
    return super.getButton(index);
  }

  /**
   * 非選択時のインデックスを返します。
   * @return 非選択時のインデックス
   */
  public int getNoSelectIndex() {
    return noSelectIndex;
  }

  /**
   * インデックスオフセット を返します。
   *
   * @return インデックスオフセット
   */
  public int getOffset() {
      return offset;
  }

/**
 * オフセットや値置換による補正を行わないインデックスを返します。
 * @return 補正を行わないインデックス
 */
  public int getRealSelectedIndex() {
      return super.getSelectedIndex();
  }
  
  public JRadioButton getSelectedButton() {
      int idx =getRealSelectedIndex(); 
      if (idx >= 0) {
          return (JRadioButton) radioButtons.get(idx);
      } else {
          return null;
      }
  }
  public int getSelectedIndex() {
    int index = super.getSelectedIndex();
    if(index==-1){
      return getNoSelectIndex();
    }else{
      return index - getOffset();
    }
  }

  public void itemStateChanged(ItemEvent e) {
      int idx = radioButtons.indexOf(e.getSource());
      if (idx - getOffset() == getSelectedIndex()) {
          fireValueChanged(new ListSelectionEvent(this, idx, idx, false));
          fireActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
                                          "itemStateChanged"));
      }
  }

  /**
   * 非選択時のインデックスを設定します。
   * @param noSelectIndex 非選択時のインデックス
   */
  public void setNoSelectIndex(int noSelectIndex) {
    this.noSelectIndex = noSelectIndex;
  }

  /**
   * インデックスオフセット を設定します。
   *
   * @param offset インデックスオフセット
   */
  public void setOffset(int offset) {
      this.offset = offset;
  }
  public void setSelectedIndex(int selectedIndex) {
    if(selectedIndex==getNoSelectIndex()){
      selectedIndex = -1;
    }else{
      selectedIndex += getOffset();
    }
    super.setSelectedIndex(selectedIndex);
  }
}
