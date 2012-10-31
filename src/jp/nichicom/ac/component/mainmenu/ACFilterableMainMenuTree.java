package jp.nichicom.ac.component.mainmenu;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRLinkedHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * 
 * メニューツリーです。
 * <p>
 * Copyright (c) 2006 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2006/02/04
 */
public class ACFilterableMainMenuTree extends JTree {
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

    /**
     * ノードの親を表すバインド定数です。
     */
    public final static String DEFAULT_PARENT_KEY = "PARENT_MENU_ID";

    /**
     * ノード自身を表すバインド定数です。
     */
    public final static String DEFAULT_NODE_ID = "MENU_ID";

    /**
     * ツリーのルートを表す定数です。
     */
    public final static int DEFAULT_TREE_ROOT_VALUE = 0;

    public String childrenKey = DEFAULT_CHILDREN_KEY;

    private List fullModel;

    private int treeMode;

    private ACMainMenuTreeNodeViewer nodeViewer;

    private String uniqueKey = DEFAULT_NODE_ID;

    private String parentKey = DEFAULT_PARENT_KEY;

    private Object mainRoot = new Integer(DEFAULT_TREE_ROOT_VALUE);

    private String showFlagKey = "";

    private ACMainMenuTreeExecuteAffair type;

    private ACMainMenuTreeModel model;

    /**
     * Returns a <code>JTree</code> with a sample model. The default model
     * used by the tree defines a leaf node as any node without children.
     * 
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACFilterableMainMenuTree() {
        super();
        initComponent();
    }

    /**
     * Returns a <code>JTree</code> created from a <code>Hashtable</code>
     * which does not display with root. Each value-half of the key/value pairs
     * in the <code>HashTable</code> becomes a child of the new root node. By
     * default, the tree defines a leaf node as any node without children.
     * 
     * @param value a <code>Hashtable</code>
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACFilterableMainMenuTree(Hashtable value) {
        super(value);
        initComponent();
    }

    /**
     * Returns a <code>JTree</code> with each element of the specified array
     * as the child of a new root node which is not displayed. By default, the
     * tree defines a leaf node as any node without children.
     * 
     * @param value an array of <code>Object</code>s
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACFilterableMainMenuTree(Object[] value) {
        super(value);
        initComponent();
    }

    /**
     * Returns an instance of <code>JTree</code> which displays the root node --
     * the tree is created using the specified data model.
     * 
     * @param newModel the <code>TreeModel</code> to use as the data model
     */
    public ACFilterableMainMenuTree(TreeModel newModel) {
        super(newModel);
        initComponent();
    }

    /**
     * Returns a <code>JTree</code> with the specified <code>TreeNode</code>
     * as its root, which displays the root node. By default, the tree defines a
     * leaf node as any node without children.
     * 
     * @param root a <code>TreeNode</code> object
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACFilterableMainMenuTree(TreeNode root) {
        super(root);
        initComponent();
    }

    /**
     * Returns a <code>JTree</code> with the specified <code>TreeNode</code>
     * as its root, which displays the root node and which decides whether a
     * node is a leaf node in the specified manner.
     * 
     * @param root a <code>TreeNode</code> object
     * @param asksAllowsChildren if false, any node without children is a leaf
     *            node; if true, only nodes that do not allow children are leaf
     *            nodes
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACFilterableMainMenuTree(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
        initComponent();
    }

    /**
     * Returns a <code>JTree</code> with each element of the specified
     * <code>Vector</code> as the child of a new root node which is not
     * displayed. By default, the tree defines a leaf node as any node without
     * children.
     * 
     * @param value a <code>Vector</code>
     * @see DefaultTreeModel#asksAllowsChildren
     */
    public ACFilterableMainMenuTree(Vector value) {
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
    protected void addNode(DefaultMutableTreeNode parent, List children,
            ACMainMenuTreeModel model) throws Exception {
        if ((parent != null) && (children instanceof List)) {
            int end = children.size();
            for (int i = 0; i < end; i++) {
                Object child = children.get(i);
                ACMainMenuTreeNode childNode;
                childNode = new ACMainMenuTreeNode();
                childNode.setModel(model);
                childNode.setUserObject(child);

                // DefaultMutableTreeNode childNode = new
                // DefaultMutableTreeNode(child);
                parent.add(childNode);
                if (child instanceof VRBindSource) {
                    Object array = VRBindPathParser.get(childrenKey,
                            (VRBindSource) child);
                    if (array instanceof List) {
                        // 幹
                        addNode(childNode, (List) array, model);
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
     * ツリー表示モードを設定します。
     * 
     * @param treeMode ツリー表示モード
     */
    public void setTreeMode(int treeMode) {
        // modeが初期値の場合再設定
        // TODO setTreeModeの順番を考慮
        this.treeMode = treeMode;
        if (getModel() instanceof ACMainMenuTreeModel) {
            ((ACMainMenuTreeModel) getModel()).setTreeMode(treeMode);
            // 強制再構築
            updateUI();
        }

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
     * 
     * @param newModel ツリーデータ
     * @param mainRoot ルートノード
     * @param uniqueKey 主キーとなるメニューIDフィールド名
     * @param parentKey 親階層のメニューIDをあらわすフィールド名
     * @param showFlagKey 表示・非表示をあらわすフィールド名（未使用の場合はnull)を送ってください
     * @throws Exception 処理例外
     */
    public void setModel(List newModel) throws Exception {

        // uniqueKey、parentKey、rootIDを基準に階層化したListに変換する
        fullModel = newModel;
        VRMap groupMap = new VRHashMap();

        ACFilterableMainMenuTree tree = new ACFilterableMainMenuTree();

        Object rootID = null;
        for (int i = 0; i < newModel.size(); i++) {
            VRMap map = new VRLinkedHashMap();
            map = (VRLinkedHashMap) newModel.get(i);
            // 表示・非表示のフラグが表示だった場合又は表示・非表示の設定を行わない場合
            if (new Integer(1).equals(map.getData(showFlagKey))
                    || "".equals(showFlagKey)) {

                Object pid = VRBindPathParser.get("PARENT_MENU_ID", map);
                List adder;
                // キーが存在しているかチェック
                if (groupMap.containsKey(pid)) {
                    // 存在していた場合
                    // 指定されたキーのVALUEにあたるListを取り出す
                    adder = (List) groupMap.get(pid);
                } else {
                    // 存在しなかった場合
                    // 新規にArrayListを生成しrootMapに新規のキーとして登録
                    adder = new ArrayList();
                    groupMap.setData(pid, adder);
                }
                // 取り出した又は生成したMapに追加を行う
                adder.add(map);
            }
        }

        // 変換結果をnewModelに代入する。TODO
        newModel = new ArrayList();
        // グループごとにまとめたMapからルートを取得
        List rootList = (List) groupMap.getData(mainRoot);
        VRMap rootMap = null;
        if ((rootList != null) && (!rootList.isEmpty())) {
            rootMap = (VRMap) rootList.get(0);
            // rootとなるMapから上位のルートを取得
            rootID = rootMap.getData(uniqueKey);
        }
        // //root設定

        newModel = createTrees(groupMap, uniqueKey, parentKey, rootID);

        fullModel = newModel;
        // root設定
        model = new ACMainMenuTreeModel();
        ACMainMenuTreeNode root = tree.new ACMainMenuTreeNode(model, rootMap);
        model.setRoot(root);
        model.setTreeMode(getTreeMode());

        addNode((DefaultMutableTreeNode) root, newModel, model);

        setModel(model);

    }

    /**
     * 渡されたVRMapからTree形式のリストを生成します
     * 
     * @param groupMap 生成元となるデータ
     * @param uniqueKey 親となるキー名
     * @param parentKey 親を表すキー名
     * @param rootID ルートを表す値
     * @return
     * @throws Exception
     */

    private List createTrees(VRMap groupMap, String uniqueKey,
        String parentKey, Object rootID) throws Exception {
        List rootList = new ArrayList();
        List treeList = new ArrayList();
        rootList = (List) groupMap.getData(rootID);
        VRMap map;
        //子が全くいなかった場合は無視
        if(rootList != null){
            for (int i = 0; i < rootList.size(); i++) {
                map = new VRLinkedHashMap();
                map = (VRMap) rootList.get(i);
                //親となるキーを取得
                rootID = map.getData(uniqueKey);
                if (VRBindPathParser.has(rootID, groupMap)) {
                    createTrees(groupMap, uniqueKey, parentKey, rootID);
                    map.setData("CHILDREN", groupMap.getData(rootID));
    
                }
                treeList.add(map);
    
            }
        }
        return treeList;

    }

    /**
     * コンポーネントを初期化します。
     */
    protected void initComponent() {
        // setRootVisible(true);
        // setShowsRootHandles(true);
        addEvents();
    }

    //
    protected void addEvents() {

        addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
                //エラートラップ
                try {
                    TreePath path = getSelectionPath();
                    if (path != null) {
                        ACMainMenuTreeNodeViewer viewer = getNodeViewer();
                        if (path.getLastPathComponent() instanceof ACMainMenuTreeNode) {
                            // 選択されたノードからパスを取得
                            ACMainMenuTreeNode treeNode = (ACMainMenuTreeNode) path
                                    .getLastPathComponent();
                            // ツリーがルートのみだった場合は回避
                            if (treeNode != treeNode.getRoot()
                                    && treeNode.getRealChildCount() == 0) {
                                // ノードに子がいるかチェック
                                if (treeNode.getRealChildCount() == 0) {
                                    // 画面遷移時のエラートラップ
                                    try {
                                        getTransfer().goAffair(treeNode);
                                        //画面遷移に失敗もしくは次クラスが存在しなかった場合処理を中断
                                        return;
                                    } catch (Exception ex) {
                                        // エラーが起きた場合基盤に投げる
                                        throw ex;
                                    }
                                }
                            }
                                                        
                            if (viewer != null) {
                                viewer.setTreeNode((TreeNode) treeNode,
                                        getTree());

                            }
                        }
                    }
                    
                } catch (Exception exc) {
                    // 
                    exc.printStackTrace();

                }
            }
        });

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
    protected class ACMainMenuTreeModel extends DefaultTreeModel {
        private int treeMode;

        /**
         * Creates a tree in which any node can have children.
         * 
         * @param root a TreeNode object that is the root of the tree
         * @see #DefaultTreeModel(TreeNode, boolean)
         */
        public ACMainMenuTreeModel() {
            super(null);
        }

        public ACMainMenuTreeModel(TreeNode root) {
            super(root);
        }

        public int getTreeMode() {
            return treeMode;
        }

        public void setTreeMode(int treeMode) {
            this.treeMode = treeMode;
        }

        protected void setModelNode(TreeNode node) {
            if (node instanceof ACMainMenuTreeNode) {
                ((ACMainMenuTreeNode) node).setModel(this);
            }
            int end = node.getChildCount();
            for (int i = 0; i < end; i++) {
                setModelNode(node.getChildAt(i));
            }
        }

        public ACMainMenuTreeModel getModel() {
            return ACMainMenuTreeModel.this;

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
    protected class ACMainMenuTreeNode extends DefaultMutableTreeNode implements
            ACFilterableMainMenuTreeNode {
        private ACMainMenuTreeModel model;

        private int childCounter = 0;
        private int roopCounter = 0;
        private ACMainMenuTreeNode acNode;

        /**
         * Creates a tree node that has no parent and no children, but which
         * allows children.
         */
        public ACMainMenuTreeNode() {
            super();
        }

        /**
         * コンストラクタです。
         * 
         * @param model モデル
         */
        public ACMainMenuTreeNode(ACMainMenuTreeModel model) {
            super();
            setModel(model);
        }

        /**
         * コンストラクタです。TODO
         * 
         * @param model モデル
         * @param userObject ノードメニューデータ
         */
        public ACMainMenuTreeNode(ACMainMenuTreeModel model, Object userObject) {
            super(userObject);
            setModel(model);
        }

        /**
         * Creates a tree node with no parent, no children, but which allows
         * children, and initializes it with the specified user object.
         * 
         * @param userObject an Object provided by the user that constitutes the
         *            node's data
         */
        public ACMainMenuTreeNode(Object userObject) {
            super(userObject);
        }

        /**
         * Creates a tree node with no parent, no children, but which allows
         * children, and initializes it with the specified user object.
         * 
         * @param userObject an Object provided by the user that constitutes the
         *            node's data
         */
        public ACMainMenuTreeNode(TreeNode root, ACMainMenuTreeModel model) {
            super(root);
            setModel(model);
        }

        public Object getUserObject() {
            if (model != null) {
                switch (model.getTreeMode()) {
                case TREE_MODE_NODE_AND_SINGLE_LEAF: {
                    if (super.getChildCount() == 1) {
                        TreeNode child = super.getChildAt(0);
                        if (child instanceof DefaultMutableTreeNode) {
                            if (child.isLeaf()) {
                                return ((DefaultMutableTreeNode) child)
                                        .getUserObject();
                            }
                        }
                    }
                }
                }
            }
            return super.getUserObject();
        }

        /**
         * 参照先のツリーモデルを設定します。
         * 
         * @param model ツリーモデル
         */
        public void setModel(ACMainMenuTreeModel model) {
            this.model = model;
        }

        /**
         * 子の数をカウントします
         */
        public int getChildCount() {
            //
            if (model != null) {
                switch (model.getTreeMode()) {
                case TREE_MODE_NODE_ONLY: {
                    int count = 0;

                    int end = super.getChildCount();
                    for (roopCounter = 0; roopCounter < end; roopCounter++) {
                        try {
                            // カウントするノードを取得します
                            acNode = ACMainMenuTreeNode.this;
                            // 業務以外の子の数を返します
                            return filterableChildCount(acNode);
                        } catch (Exception e) {
                        }

                    }

                    count = childCounter;
                    childCounter = 0;
                    return count;
                }
                case TREE_MODE_NODE_AND_SINGLE_LEAF: {
                    int leafCount = 0;
                    int nodeCount = 0;
                    int end = super.getChildCount();
                    for (int i = 0; i < end; i++) {
                        if (super.getChildAt(i).isLeaf()) {
                            leafCount++;
                        } else {
                            nodeCount++;
                        }
                    }
                    if (nodeCount == 0) {
                        if (leafCount == 1) {
                            return 0;
                        }
                    }
                    return nodeCount;

                }
                }
            }
            return super.getChildCount();
        }

        /**
         * フィルタリングした子の数を取得します。
         * 
         * @param node カウント対象となるnode
         * @return フィルタリングした子の数
         * @throws Exception
         */
        public int filterableChildCount(ACMainMenuTreeNode node)
                throws Exception {

            VRMap map = new VRHashMap();
            List koList = new ArrayList();
            int count = 0;

            for (int i = 0; i < node.getRealChildCount(); i++) {
                if (node.getRealChildAt(i) instanceof ACMainMenuTreeNode) {
                    // nodeの子を取得
                    ACMainMenuTreeNode koNode = (ACMainMenuTreeNode) node
                            .getRealChildAt(i);
                    // 子の子（nodeから見て孫）が1つでも見つかった場合はカウント
                    if (0 < koNode.getRealChildCount()) {
                        count++;
                    }
                } else {
                    // ACMainMenuTreeNode以外の型の場合
                }
            }

            return count;
        }

        // public boolean isLeaf() {
        // switch (model.getTreeMode()) {
        // case TREE_MODE_NODE_ONLY: {
        // int count = 0;
        // for (int i = 0; i < super.getChildCount(); i++) {
        // if (((ACMainMenuTreeNode) super.getChildAt(i))
        // .getRealChildCount()!=0) {
        // count++;
        // }
        // }
        //
        // if (count > 0) {
        // return false;
        // } else {
        // return true;
        // }
        // }
        // case TREE_MODE_NODE_AND_SINGLE_LEAF: {
        // //
        // break;
        // }
        // }
        // return super.isLeaf();
        //
        // }
        /**
         * 子の数をフィルタリングせずに取得します。
         */
        public int getRealChildCount() {
            return super.getChildCount();
        }

        /**
         * 指定位置の子をフィルタリングせずに取得します
         */
        public TreeNode getRealChildAt(int childIndex) {
            return super.getChildAt(childIndex);
        }

        /**
         * します。
         * 
         * @return
         */
        public boolean isRealLeaf() {
            return super.isLeaf();
        }

        public Enumeration children() {
            // TODO 偽装 フォルダの表示個数偽装
            if (model != null) {
                int count = 0;
                switch (model.getTreeMode()) {
                case TREE_MODE_NODE_ONLY:
                case TREE_MODE_NODE_AND_SINGLE_LEAF:
                    ItEnum e = new ItEnum();
                    e.setNode(ACMainMenuTreeNode.this);
                    return e;

                }
            }
            return super.children();
        }

        public int getIndex(TreeNode node) {

            if (model != null) {
                //
                switch (model.getTreeMode()) {
                case TREE_MODE_NODE_ONLY:
                    // カウンタ
                    int childCount = 0;
                    // 子の数分カウントする
                    for (int i = 0; i < super.getChildCount(); i++) {
                        TreeNode child = super.getChildAt(i);
                        // 子のノードと一致した場合返す
                        if (child == node) {
                            return childCount;
                        }
                        if (((ACMainMenuTreeNode) child).getRealChildCount() != 0) {
                            // if(!child.isLeaf()){
                            childCount++;
                        }
                    }
                    return -1;

                }

            }
            return super.getIndex(node);
        }

        public TreeNode getChildAt(int childIndex) {
            if (model != null) {
                // 
                switch (model.getTreeMode()) {
                case TREE_MODE_NODE_ONLY:
                    int childCount = 0;

                    for (int i = 0; i < super.getChildCount(); i++) {
                        TreeNode child = super.getChildAt(i);

                        // 子がいる場合はカウント
                        if (((ACMainMenuTreeNode) child).getRealChildCount() != 0) {
                            // カウント数に達した場合現在のノードを返す
                            if (childCount == childIndex) {
                                return child;
                            }
                            childCount++;
                        }

                    }

                    return null;
                }
            }
            return super.getChildAt(childIndex);
        }

    }

    //
    protected class ItEnum implements Enumeration {

        private int count;
        private Object Data;
        private int maxCounter = 0;
        private ACFilterableMainMenuTree tree;
        private TreeNode node;

        /**
         * @return <code>true</code> if and only if this enumeration object
         *         contains at least one more element to provide;
         *         <code>false</code> otherwise.
         */
        public boolean hasMoreElements() {
            if (count < maxCounter) {
                return true;
            } else {
                return false;
            }

        }

        /**
         * Returns the next element of this enumeration if this enumeration
         * object has at least one more element to provide.
         * 
         * @return the next element of this enumeration.
         * @exception NoSuchElementException if no more elements exist.
         */
        public Object nextElement() {
            Object returnObj;

            returnObj = node.getChildAt(count);

            count++;
            return returnObj;

        }

        /**
         * ノードを設定します。
         * 
         * @param node
         */
        public void setNode(TreeNode node) {
            this.node = node;
            if (node != null) {
                maxCounter = node.getChildCount();
            } else {
                maxCounter = 0;
            }
            count = 0;

        }

    }

    /**
     * メインメニューツリーのノードの詳細表示コンポーネントを返します。
     * 
     * @return 詳細表示コンポーネント
     */
    public ACMainMenuTreeNodeViewer getNodeViewer() {
        return nodeViewer;
    }

    /**
     * メインメニューツリーのノードの詳細表示コンポーネントを設定します。
     * 
     * @param nodeViewer 詳細表示コンポーネント
     */
    public void setNodeViewer(ACMainMenuTreeNodeViewer nodeViewer) {
        this.nodeViewer = nodeViewer;
    }

    public ACFilterableMainMenuTree getTree() {
        return this;
    }

    public ACMainMenuTreeExecuteAffair getTransfer() {
        return type;
    }

    public void setTransfer(ACMainMenuTreeExecuteAffair type) {
        this.type = type;
    }

}


