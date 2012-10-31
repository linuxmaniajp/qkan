package jp.nichicom.ac.component.mainmenu;

import javax.swing.tree.TreeNode;
/**
 * 
 * ACMainMenuTreeExecuteAffairです。
 * <p>
 * Copyright (c) 2006 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2006/02/10
 */
public interface ACMainMenuTreeExecuteAffair {
    
    /**
     * 業務起動します。
     * @return
     */
    public void goAffair(TreeNode node) throws Exception;           

}
