package jp.nichicom.ac.component.mainmenu;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;

/**
 * メインメニューツリーです。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2005/12/01
 * @see TreeNode
 */

public class ACMainMenuTree extends JTree {
    /**
     * 既定の子階層を表すバインドパス定数です。
     */
    public static final String DEFAULT_CHILDREN_KEY = "CHILDREN";

    /**
     * ノードとすべての葉をツリー上に表示することを表すツリーモード定数です。
     */
    public final static int TREE_MODE_NODE_AND_ALL_LEAF = 0;

    /**
     * ノードと単一の葉をツリー上に表示することを表すツリーモード定数です。
     */
    public final static int TREE_MODE_NODE_AND_SINGLE_LEAF = 1;

    /**
     * ノードだけをツリー上に表示することを表すツリーモード定数です。
     */
    public final static int TREE_MODE_NODE_ONLY = 2;

    public String childrenKey = DEFAULT_CHILDREN_KEY;

    private List fullModel;

    private int treeMode;

    /**
     * Returns a <code>JTree</code> with a sample model.
     * The default model used by the tree defines a leaf node as any node
     * without children.
     *
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACMainMenuTree() {
        super();
        initComponent();
    }

    /**
     * Returns a <code>JTree</code> created from a <code>Hashtable</code>
     * which does not display with root.
     * Each value-half of the key/value pairs in the <code>HashTable</code>
     * becomes a child of the new root node. By default, the tree defines
     * a leaf node as any node without children.
     *
     * @param value  a <code>Hashtable</code>
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACMainMenuTree(Hashtable value) {
        super(value);
        initComponent();
    }

    /**
     * Returns a <code>JTree</code> with each element of the
     * specified array as the
     * child of a new root node which is not displayed.
     * By default, the tree defines a leaf node as any node without
     * children.
     *
     * @param value  an array of <code>Object</code>s
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACMainMenuTree(Object[] value) {
        super(value);
        initComponent();
    }

    /**
     * Returns an instance of <code>JTree</code> which displays the root node 
     * -- the tree is created using the specified data model.
     *
     * @param newModel  the <code>TreeModel</code> to use as the data model
     */
    public ACMainMenuTree(TreeModel newModel) {
        super(newModel);
        initComponent();
    }

    /**
     * Returns a <code>JTree</code> with the specified
     * <code>TreeNode</code> as its root,
     * which displays the root node.
     * By default, the tree defines a leaf node as any node without children.
     *
     * @param root  a <code>TreeNode</code> object
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACMainMenuTree(TreeNode root) {
        super(root);
        initComponent();
    }

    /**
     * Returns a <code>JTree</code> with the specified <code>TreeNode</code>
     * as its root, which 
     * displays the root node and which decides whether a node is a 
     * leaf node in the specified manner.
     *
     * @param root  a <code>TreeNode</code> object
     * @param asksAllowsChildren  if false, any node without children is a 
     *              leaf node; if true, only nodes that do not allow 
     *              children are leaf nodes
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACMainMenuTree(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
        initComponent();
    }

    /**
     * Returns a <code>JTree</code> with each element of the specified
     * <code>Vector</code> as the
     * child of a new root node which is not displayed. By default, the
     * tree defines a leaf node as any node without children.
     *
     * @param value  a <code>Vector</code>
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACMainMenuTree(Vector value) {
        super(value);
        initComponent();
    }

    /**
     * 指定ノードの子要素としてツリーを追加します。
     * 
     * @param parent 対象親ノード
     * @param children ツリーデータ
     * @throws Exception 処理例外
     */
    public void addNode(DefaultMutableTreeNode parent, List children)
            throws Exception {
        if ((parent != null) && (children instanceof List)) {
            int end = children.size();
            for (int i = 0; i < end; i++) {
                Object child = children.get(i);
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(
                        child);
                parent.add(childNode);
                if (child instanceof VRBindSource) {
                    Object array = VRBindPathParser.get(childrenKey,
                            (VRBindSource) child);
                    if (array instanceof List) {
                        // 幹
                        addNode(childNode, (List) array);
                    }
                }
            }
        }
    }

    /**
     * 子階層を表すバインドパス を返します。
     * 
     * @return 子階層を表すバインドパス
     */
    public String getChildrenKey() {
        return childrenKey;
    }

    /**
     * メニューデータ形式のツリーデータを返します。
     * 
     * @return メニューデータ形式のツリーデータ
     */
    public List getFullModel() {
        return fullModel;
    }

    /**
     * ツリー表示モードを返します。
     * 
     * @return ツリー表示モード
     */
    public int getTreeMode() {
        return treeMode;
    }

    /**
     * 子階層を表すバインドパス を設定します。
     * 
     * @param childrenKey 子階層を表すバインドパス
     */
    public void setChildrenKey(String childrenKey) {
        this.childrenKey = childrenKey;
    }

    /**
     * 業務ツリーモデルを構築します。
     * @param newModel ツリーデータ
     * @param uniqueKey 主キーとなるメニューIDフィールド名
     * @param parentKey 親階層のメニューIDをあらわすフィールド名
     * @param rootID 最上位の階層を現すメニューID(通常は0)
     * @throws Exception 処理例外
     */
    public void setModel(List newModel, String uniqueKey, String parentKey, Object rootID) throws Exception {
        
    }
    
    /**
     * 業務ツリーモデルを構築します。
     * 
     * @param newModel ツリーデータ
     * @param root ルートノード
     * @param uniqueKey 主キーとなるメニューIDフィールド名
     * @param parentKey 親階層のメニューIDをあらわすフィールド名
     * @param rootID 最上位の階層を現すメニューID(通常は0)
     * @throws Exception 処理例外
     */
    protected void setModel(List newModel, TreeNode root, String uniqueKey, String parentKey, Object rootID) throws Exception {

        //TODO uniqueKey、parentKey、rootIDを基準に階層化したListに変換する
        //TODO 変換結果をnewModelに代入する。
        
        

        //swingツリー化する
        setModel(newModel, root);
    }
    /**
     * 業務ツリーモデルを構築します。
     * 
     * @deprecated #setModel(List newModel, String uniqueKey, String parentKey)を使用してください。
     * @param newModel ツリーデータ
     * @throws Exception 処理例外
     */
    public void setModel(List newModel) throws Exception {
        setModel(newModel, null);
    }

    /**
     * 業務ツリーモデルを構築します。
     * 
    * @deprecated #setModel(List newModel, TreeNode root, String uniqueKey, String parentKey)を使用してください。
      * @param newModel ツリーデータ
     * @param root ルートノード
     * @throws Exception 処理例外
     */
    protected void setModel(List newModel, TreeNode root) throws Exception {
        fullModel = newModel;
        NCMainMenuTreeModel model = new NCMainMenuTreeModel();
        model.setTreeMode(getTreeMode());
        if (!(root instanceof DefaultMutableTreeNode)) {
            root = new NCMainMenuTreeNode(model);
        }
        model.setRoot(root);
        addNode((DefaultMutableTreeNode) root, newModel);
        setModel(model);
    }

    /**
     * ツリー表示モードを設定します。
     * 
     * @param treeMode ツリー表示モード
     */
    public void setTreeMode(int treeMode) {
        this.treeMode = treeMode;
        if (getModel() instanceof NCMainMenuTreeModel) {
            ((NCMainMenuTreeModel) getModel()).setTreeMode(treeMode);
        }

    }

    /**
     * コンポーネントを初期化します。
     */
    protected void initComponent() {
        setRootVisible(false);
        setShowsRootHandles(false);

    }

    /**
     * メインメニューツリー用のツリーモデルです。
     * <p>
     * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2005/12/01
     * @see TreeNode
     */
    protected class NCMainMenuTreeModel extends DefaultTreeModel {
        private int treeMode;

        /**
         * Creates a tree in which any node can have children.
         *
         * @param root a TreeNode object that is the root of the tree
         * @see #DefaultTreeModel(TreeNode, boolean)
         */
        public NCMainMenuTreeModel() {
            super(null);
        }

        public NCMainMenuTreeModel(TreeNode root) {
            super(root);
        }

        public int getTreeMode() {
            return treeMode;
        }

        public void setTreeMode(int treeMode) {
            this.treeMode = treeMode;
        }

        protected void setModelNode(TreeNode node) {
            if (node instanceof NCMainMenuTreeNode) {
                ((NCMainMenuTreeNode) node).setModel(this);
            }
            int end = node.getChildCount();
            for (int i = 0; i < end; i++) {
                setModelNode(node.getChildAt(i));
            }
        }
    }

    /**
     * メインメニューツリー用のノードデータです。
     * <p>
     * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
     * </p>
     * 
     * @author Tozo Tanaka
     * @version 1.0 2005/12/01
     * @see TreeNode
     */
    protected class NCMainMenuTreeNode extends DefaultMutableTreeNode {
        private NCMainMenuTreeModel model;

        public NCMainMenuTreeNode() {
            super();
        }

        public NCMainMenuTreeNode(NCMainMenuTreeModel model) {
            super();
            setModel(model);
        }

        public NCMainMenuTreeNode(TreeNode root, NCMainMenuTreeModel model) {
            super(root);
            setModel(model);
        }

        public int getChildCount() {
            //TODO SHOW_FLAGの考慮
            switch (model.getTreeMode()) {
            case TREE_MODE_NODE_ONLY:
                return 0;
            case TREE_MODE_NODE_AND_SINGLE_LEAF: {
                int size = super.getChildCount();
                if (size <= 1) {
                    return 0;
                }
                return size;
            }
            }
            return super.getChildCount();
        }

        public Object getUserObject() {
            switch (model.getTreeMode()) {
            case TREE_MODE_NODE_AND_SINGLE_LEAF: {
                if (super.getChildCount() == 1) {
                    TreeNode child = getChildAt(0);
                    if (child instanceof DefaultMutableTreeNode) {
                        return ((DefaultMutableTreeNode) child).getUserObject();
                    }
                }
            }
            }
            return super.getUserObject();
        }

        public void setModel(NCMainMenuTreeModel model) {
            this.model = model;
        }
    }

}
