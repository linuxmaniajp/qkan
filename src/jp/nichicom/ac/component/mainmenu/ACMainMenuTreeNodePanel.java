package jp.nichicom.ac.component.mainmenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.vr.layout.VRLayout;

/**
 * 
 * ACMainMenuTreeNodePanelです。
 * <p>
 * Copyright (c) 2006 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2006/02/04
 */
public class ACMainMenuTreeNodePanel extends ACPanel {

    private ACLabel label;
    private ACButton detailButton;
    private ACPanel affairPanel;
    private ACLabel explanationLabel;
    private ACPanel underPanel;
    private ACButton affairButton;
    private ACLabel iconLabel;
    private Object nextAffair;
    private TreeNode node;
    private ACFilterableMainMenuTree tree;
    private Object nextParameter;
    
    private ACMainMenuTreeExecuteAffair type;
    
    private Border PRESSED_BORDER= BorderFactory.createRaisedBevelBorder();
    private Border RELEASED_BORDER= BorderFactory.createEmptyBorder();
    private Border FOCUS_GAINED_BORDER = new ACMainMenuTreeNodePanelFocusBorder();
    
    class ACMainMenuTreeNodePanelFocusBorder extends AbstractBorder {
        private Color color=new Color(0x90,0x90,0xFF, 0x70);
        private int innerSpace=6;
        private int outerSpace=4;
//        public ACMainMenuTreeNodePanelFocusBorder(Color color , int space) {
//            this.color = color;
//            this.space = space;
//        }
//        public Insets getBorderInsets(Component c)       { 
//            return new Insets(2, 2, 2, 2);
//        }
        public void paintBorder(Component c , Graphics g ,
                    int x , int y , int w , int h) {
            g.setColor(color);
            
            g.drawRect(
                x + innerSpace , y + innerSpace ,
                w - innerSpace * 2 - 1 , h - innerSpace * 2 - 1
            );

            g.fillRect(x , y , outerSpace, h - 1);
            g.fillRect(x+w-outerSpace , y , outerSpace, h - 1);
            g.fillRect(x , y , w-1, outerSpace);
            g.fillRect(x, y+h-outerSpace , w-1, outerSpace);
            
            
        }
    }
    
    
    /**
     * Creates a new <code>JPanel</code> with a double buffer and a flow
     * layout.
     */
    public ACMainMenuTreeNodePanel() {
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
    public ACMainMenuTreeNodePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    /**
     * Create a new buffered JPanel with the specified layout manager
     * 
     * @param layout the LayoutManager to use
     */
    public ACMainMenuTreeNodePanel(LayoutManager layout) {
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
    public ACMainMenuTreeNodePanel(LayoutManager layout,
            boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    protected void initComponent() {
        super.initComponent();
        detailButton = new ACButton();
        affairPanel = new ACPanel();
        explanationLabel = new ACLabel();
        underPanel = new ACPanel();
        affairButton = new ACButton();
        iconLabel = new ACLabel();       
        explanationLabel.setAutoWrap(true);
        setColor(Color.WHITE);
        underPanel.setVisible(false);
        affairPanel.setFollowChildEnabled(true);
        affairPanel.add(iconLabel, VRLayout.WEST);
        affairButton.setHorizontalAlignment(SwingConstants.LEFT);
        affairButton.setBorder(BorderFactory.createEmptyBorder());
        affairPanel.add(affairButton,VRLayout.CLIENT);        
//        affairPanel.add(detailButton, VRLayout.EAST);        
        underPanel.add(explanationLabel, VRLayout.CLIENT);
        add(affairPanel, VRLayout.NORTH);
        add(underPanel, VRLayout.CLIENT);

        event();

    }

    public ACPanel getPanels() {

        ACPanel pane = new ACPanel();

        return pane;
    }

    /**
     * コンポーネントのイベント定義します。
     */
    protected void event() {
        detailButton.addActionListener(new ActionListener() {
            private boolean lockFlag = false;

            public void actionPerformed(ActionEvent e) {
                if (lockFlag) {
                    return;
                }
                lockFlag = true;
                try {
                    changeAction(e);
                } catch (Throwable ex) {
                    ACCommon.getInstance().showExceptionMessage(ex);
                } finally {
                    lockFlag = false;
                }
            }
        });

        // 透明の設定
//        label.setOpaque(true);
        //マウスイベント
        affairButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if(canChange()){
                affairButton.setBackground(new Color(200, 255, 255));
                }

            }
            //マウスカーソルが離れた場合
            public void mouseExited(MouseEvent e) {
                if(canChange()){
                affairButton.setBackground(null);
                }
                    
            }
            //クリックされた場合
            public void mousePressed(MouseEvent e) {
                pressed = true;
                if(canChange()){
                affairButton.setBorder(PRESSED_BORDER);
                }
            }
            //マウスクリックが終わった場合
            public void mouseReleased(MouseEvent e) {
                pressed = false;
//                affairButton.setBorder(FOCUS_GAINED_BORDER);
                if(canChange()){
                affairButton.setBorder(RELEASED_BORDER);
                }
            }
            protected boolean canChange(){
                return affairButton.isEnabled();
            }
        });
                
        affairButton.addActionListener(new ActionListener(){
            private boolean lockFlag = false;
            public void actionPerformed(ActionEvent e) {
                if(lockFlag){
                    return;
                }
                lockFlag = true;
                try{
                    transfer(e);
                }catch(Throwable ex){
                    ACCommon.getInstance().showExceptionMessage(ex);
                }finally{
                    lockFlag = false;
                }
            }
        });
        
//        affairButton.addKeyListener(new KeyAdapter(){
//
//            public void keyPressed(KeyEvent e) {
//                switch(e.getKeyCode()){
//                case KeyEvent.VK_UP:
//                    affairButton.transferFocusBackward();
//                    transferFocusBackward();
//                    break;
//                case KeyEvent.VK_DOWN:
//                    detailButton.transferFocus();
//                    break;
//                }
//            }
//            
//        });
        
        //フォーカスイベント
        affairButton.addFocusListener(new FocusListener(){

            public void focusGained(FocusEvent e) {
                affairButton.setBackground(new Color(200, 255, 255));
//                if(!pressed){
//                    affairButton.setBorder(FOCUS_GAINED_BORDER);
//                }

            }
            public void focusLost(FocusEvent e) {
//                if(!detailButton.hasFocus()){
                affairButton.setBackground(null);
//                affairButton.setBorder(RELEASED_BORDER);
//                }
            }
        });
        
    }
    private boolean pressed = false;

    /**
     * 詳細コメント表示イベント
     * 
     * @param e
     */
    protected void changeAction(ActionEvent e) {

        if (underPanel.isVisible()) {
            underPanel.setVisible(false);
        } else {
            underPanel.setVisible(true);
        }
    }

    /**
     * 業務遷移イベント
     * 
     * @param e
     * @throws Exception
     */
    protected void transfer(ActionEvent e) throws Exception {
        // 次画面のIDが存在しない場合
        if (getNextAffair() == null || "".equals(getNextAffair())) {
            TreeNode node = getNode();
            if (node instanceof DefaultMutableTreeNode) {
                tree.setSelectionPath(new TreePath(
                        ((DefaultMutableTreeNode) node).getPath()));
            }

        } else {
            if (node != null || getTranceferAffair() != null) {
                getTranceferAffair()
                        .goAffair(node);

            }

        }
    }
    
    
    public String getText() {
        return label.getText();
    }

    public void setText(String text) {
        label.setText(text);
    }

    /**
     * ボタンに設定したアイコンを返します。
     * @return
     */
    public String getAffairButtonIconPath() {
        return affairButton.getIconPath();
    }

    /**
     * ボタンにアイコンを設定します。
     * @param iconPath
     */
    public void setAffairButtonIconPath(String iconPath) {
        affairButton.setIconPath(iconPath);
    }
    
    /**
     * ラベルに設定したアイコンを返します。
     * @return
     */
    public String getLabelIconPath() {
        return label.getIconPath();
    }

    /**
     * ラベルにアイコンを設定します。
     * @param iconPath
     */
    public void setLabelIconPath(String iconPath) {
        label.setIconPath(iconPath);
    }

    /**
     * ボタンに設定した文字列を取得します。
     * @return
     */
    public String getButtonText() {
        return detailButton.getText();
    }

    /**
     * ボタンに表示する文字を設定します
     * 
     * @param buttonText
     */
    public void setButtonText(String buttonText) {
        detailButton.setText(buttonText);
    }

    /**
     * ボタンに設定したアイコンを設定します。
     * 
     * @return
     */
    public String getButtonIconPath() {
        return detailButton.getIconPath();
    }

    /**
     * ボタンにアイコンを設定します。
     * 
     * @param iconPath
     */
    public void setButtonIconPath(String iconPath) {
        detailButton.setIconPath(iconPath);
    }

    /**
     * 詳細コメントを返します。
     * 
     * @return
     */
    public String getExplanationLabelText() {
        return explanationLabel.getText();
    }

    /**
     * 詳細コメントを設定します。
     * 
     * @param labelText
     */
    public void setExplanationLabelText(String labelText) {
        explanationLabel.setText(labelText);
        affairButton.setToolTipText(labelText);
    }

    /**
     * 詳細コメントの背景色を返します。
     * 
     * @return
     */
    public Color getColor() {
        return underPanel.getBackground();
    }

    /**
     * 詳細コメントの背景色を設定します。
     * 
     * @param color
     */
    public void setColor(Color color) {
        underPanel.setBackground(color);
    }

    /**
     * ボタンのコメントを返します。
     * 
     * @return
     */
    public String getAffairButtonText() {
        return affairButton.getText();
    }

    /**
     * ボタンのコメントを設定します。
     * 
     * @param affairButtonText
     */
    public void setAffairButtonText(String affairButtonText) {
        affairButton.setText(affairButtonText);
    }

    /**
     * 次画面の情報を返します。
     * 
     * @return
     */
    public Object getNextAffair() {
        return nextAffair;
    }

    /**
     * 次画面の情報を設定します。
     * 
     * @param nextAffair
     */
    public void setNextAffair(Object nextAffair) {
        this.nextAffair = nextAffair;
    }

    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public ACFilterableMainMenuTree getTree() {
        return tree;
    }

    public void setTree(ACFilterableMainMenuTree tree) {
        this.tree = tree;
    }

    /**
     * 遷移先業務のパラメーターを返します。
     * @return
     */
    public Object getNextParameter() {
        return nextParameter;
    }

    /**
     * 遷移先業務のパラメーターを設定します。
     * @param nextParameter
     */
    public void setNextParameter(Object nextParameter) {
        this.nextParameter = nextParameter;
    }

    public ACMainMenuTreeExecuteAffair getTranceferAffair() {
        return type;

    }

    public void setTranceferAffair(ACMainMenuTreeExecuteAffair type) {
        this.type = type;

    }

}
