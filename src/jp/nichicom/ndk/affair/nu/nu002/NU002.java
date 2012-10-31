package jp.nichicom.ndk.affair.nu.nu002;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.core.ACAffairContainer;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.core.ACPDFCreatable;
import jp.nichicom.ac.filechooser.ACFileChooser;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.util.ACMessageBox;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * <p>
 * タイトル:PDFTester
 * </p>
 * <p>
 * 説明:
 * </p>
 * <p>
 * 著作権: Copyright (c) 2005
 * </p>
 * <p>
 * 会社名:
 * </p>
 * 
 * @author 未入力
 * @version 1.0
 */
@SuppressWarnings("serial")
public class NU002 extends ACAffairContainer implements ACAffairable {
    private ACTable table = new ACTable();
    private ACGroupBox conditions = new ACGroupBox();
    private ACTableModelAdapter itemList;
    private ACLabelContainer inputPathContainer = new ACLabelContainer();
    private ACTextField inputPath = new ACTextField();
    private ACButton browseInputPath = new ACButton();
    private ACTextField outputPath = new ACTextField();
    private ACButton browseOutputtPath = new ACButton();
    private ACLabelContainer outputPathContainer = new ACLabelContainer();
    private ACAffairButtonBar buttons = new ACAffairButtonBar();
    private ACAffairButton read = new ACAffairButton();
    private ACAffairButton create = new ACAffairButton();
    private ACAffairButton close = new ACAffairButton();

    protected Node getChildNode(Node node, String childName) {
        NodeList children = node.getChildNodes();
        int cEnd = children.getLength();
        for (int j = 0; j < cEnd; j++) {
            Node child = children.item(j);
            if (childName.equals(child.getNodeName())) {
                return child;
            }
        }
        return null;
    }

    protected String getChildNodeText(Node node, String childName) {
        return getNodeText(getChildNode(node, childName));
    }

    protected String getNodeText(Node node) {
        if (node != null) {
            NodeList children = node.getChildNodes();
            int cEnd = children.getLength();
            for (int j = 0; j < cEnd; j++) {
                node = children.item(j);
                if (node.getNodeType() == Node.TEXT_NODE) {
                    return node.getNodeValue();
                }
            }
        }
        return "";
    }

    public NU002() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        read.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    File f = new File(inputPath.getText());
                    if (!f.exists()) {
                        ACMessageBox.show("帳票太郎形式のXMLファイルを指定してください。");
                        return;
                    }

                    // ドキュメントビルダーファクトリを生成
                    DocumentBuilderFactory dbfactory = DocumentBuilderFactory
                            .newInstance();
                    // ドキュメントビルダーを生成
                    DocumentBuilder builder = dbfactory.newDocumentBuilder();
                    // パースを実行してDocumentオブジェクトを取得
                    Document doc = builder.parse(f);
                    // ルート要素を取得（タグ名：message）
                    Element root = doc.getDocumentElement();

                    VRArrayList items = new VRArrayList();
                    NodeList labelList = root.getElementsByTagName("Label");
                    NodeList tableList = root.getElementsByTagName("Table");

                    // ラベルを解析
                    int end = labelList.getLength();
                    for (int i = 0; i < end; i++) {
                        Node item = labelList.item(i);
                        NamedNodeMap attrs = item.getAttributes();
                        Node id = attrs.getNamedItem("Id");
                        Node shape = attrs.getNamedItem("Shape");
                        String text = getChildNodeText(item, "Text");
                        VRMap row = new VRHashMap();
                        VRBindPathParser.set("Type", row, "ラベル");
                        VRBindPathParser.set("Id", row, id.getNodeValue());
                        VRBindPathParser.set("Text", row, text);
                        VRBindPathParser
                                .set("Shape", row, shape.getNodeValue());
                        VRBindPathParser.set("Use", row, new Boolean(false));
                        VRBindPathParser.set("Hide", row, new Boolean(false));
                        items.addData(row);
                    }
                    end = tableList.getLength();
                    for (int i = 0; i < end; i++) {
                        Node item = tableList.item(i);
                        NamedNodeMap attrs = item.getAttributes();
                        Node idNode = attrs.getNamedItem("Id");
                        Node shape = attrs.getNamedItem("Shape");
                        String id = idNode.getNodeValue();

                        VRHashMap row = new VRHashMap();
                        VRBindPathParser.set("Type", row, "グリッド");
                        VRBindPathParser.set("Id", row, id);
                        VRBindPathParser.set("Text", row, "");
                        VRBindPathParser
                                .set("Shape", row, shape.getNodeValue());
                        VRBindPathParser.set("Use", row, new Boolean(false));
                        VRBindPathParser.set("Hide", row, new Boolean(false));
                        items.addData(row);

                        // カラム名を取っておく
                        Node columns = getChildNode(item, "Columns");
                        NodeList childrens = columns.getChildNodes();
                        int columnCount = 0;
                        int jEnd = childrens.getLength();
                        ArrayList<Object> columnsArray = new ArrayList<Object>();
                        for (int j = 0; j < jEnd; j++) {
                            if ("Col".equals(childrens.item(j).getNodeName())) {
                                columnsArray.add(childrens.item(j)
                                        .getAttributes().getNamedItem("Id")
                                        .getNodeValue());
                                columnCount++;
                            }
                        }
                        String[] columnNames = new String[columnCount];
                        System.arraycopy(columnsArray.toArray(), 0,
                                columnNames, 0, columnsArray.size());

                        childrens = item.getChildNodes();
//                        int trCount = 0;
                        jEnd = childrens.getLength();
                        for (int j = 0; j < jEnd; j++) {
                            Node trNode = childrens.item(j);
                            if ("Tr".equals(trNode.getNodeName())) {
                                String trId = trNode.getAttributes()
                                        .getNamedItem("Id").getNodeValue();

                                NodeList tds = trNode.getChildNodes();
                                int tdCount = 0;
                                int kEnd = tds.getLength();
                                for (int k = 0; k < kEnd; k++) {
                                    Node tdNode = tds.item(k);
                                    if ("Td".equals(tdNode.getNodeName())) {
                                        row = new VRHashMap();
                                        VRBindPathParser.set("Type", row, "セル");
                                        VRBindPathParser.set("Id", row, id
                                                + "." + trId + "."
                                                + columnNames[tdCount]);
                                        VRBindPathParser
                                                .set("Text", row,
                                                        getChildNodeText(
                                                                tdNode, "Text"));
                                        VRBindPathParser.set("Shape", row, "");
                                        VRBindPathParser.set("Use", row,
                                                new Boolean(false));
                                        VRBindPathParser.set("Hide", row,
                                                new Boolean(false));
                                        items.addData(row);
                                        tdCount++;
                                    }
                                }
//                                trCount++;
                            }
                        }

                    }

                    itemList.setAdaptee(items);
                } catch (Exception ex) {
                    ACCommon.getInstance().showExceptionMessage(ex);
                }
            }
        });

        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (itemList.getRowCount() == 0) {
                    ACMessageBox.show("定義ファイルが読み込まれていません。");
                    return;
                }
                if (!new File(outputPath.getText()).exists()) {
                    ACMessageBox.show("Acrobat Readerのパスを指定してください。");
                    return;
                }
                try {
                    ACFrame.getInstance().getPropertyXML().setForceValueAt(
                            "Acrobat/Path", outputPath.getText());
                    ACChotarouXMLWriter pd = new ACChotarouXMLWriter();

                    pd.addFormat("page1", inputPath.getText());

                    pd.beginPrintEdit();
                    pd.beginPageEdit("page1");

                    int end = itemList.getAdaptee().getDataSize();
                    for (int i = 0; i < end; i++) {
                        VRBindSource row = (VRBindSource) itemList.getAdaptee()
                                .getData(i);
                        if (Boolean.valueOf(
                                String
                                        .valueOf(VRBindPathParser.get("Use",
                                                row))).booleanValue()) {
                            String id = String.valueOf(VRBindPathParser.get(
                                    "Id", row));
                            if (Boolean.valueOf(
                                    String.valueOf(VRBindPathParser.get("Hide",
                                            row))).booleanValue()) {
                                pd.addAttribute(id, "Visible", "FALSE");
                            } else {
                                ACCommon.getInstance().setValue(pd, id,
                                        VRBindPathParser.get("Text", row));
                            }
                        }
                    }

                    pd.endPageEdit();
                    pd.endPrintEdit();

                    if (ACFrame.getInstance().getFrameEventProcesser() instanceof ACPDFCreatable) {
                        ((ACPDFCreatable) ACFrame.getInstance()
                                .getFrameEventProcesser()).writePDF(pd);
                        ACCommon.getInstance().openPDF(pd);
                    }
                } catch (Exception ex) {
                    ACCommon.getInstance().showExceptionMessage(ex);
                }
            }
        });
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ACMessageBox.show("終了してもよろしいですか？",
                        ACMessageBox.BUTTON_OKCANCEL,
                        ACMessageBox.ICON_QUESTION, ACMessageBox.FOCUS_CANCEL) == ACMessageBox.RESULT_OK) {
                    ACFrame.getInstance().dispose();
                }
            }
        });

        browseInputPath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ACFileChooser chooser = new ACFileChooser();
                File file = chooser.getFilePathWithExtension(chooser
                        .showOpenDialog("XMLファイルを開く", new String[] { "xml" },
                                "帳票太郎XML(.xml)"));
                // キャンセル時は中断
                if (file == null) {
                    return;
                }
                inputPath.setText(file.getPath());
            }
        });
        browseOutputtPath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ACFileChooser chooser = new ACFileChooser();
                File file = chooser.getFilePathWithExtension(chooser
                        .showOpenDialog("Acrobat Readerを開く",
                                new String[] { "exe" },
                                "Acrobat Reader(AcroRd32.exe)"));
                // キャンセル時は中断
                if (file == null) {
                    return;
                }
                outputPath.setText(file.getPath());
            }
        });
    }

    void jbInit() throws Exception {
        buttons.setBackVisible(false);

        conditions.setHgrid(200);
        conditions.setText("設定");
        inputPathContainer.setText("帳票定義体XMLの場所");
        inputPath.setColumns(40);
        browseInputPath.setMnemonic('I');
        browseInputPath.setText("参照(I)");
        outputPath.setColumns(40);
        outputPath
                .setText("C:\\Program Files\\Adobe\\Acrobat 7.0\\Reader\\acrord32.exe");
        browseOutputtPath.setMnemonic('O');
        browseOutputtPath.setText("参照(O)");
        outputPathContainer.setText("AcrobatReaderの場所");
        read.setIconPath(ACConstants.ICON_PATH_OPEN_24);
        read.setMnemonic('R');
        read.setText("読み込み(R)");
        create.setIconPath(ACConstants.ICON_PATH_EXPORT_24);
        create.setMnemonic('C');
        create.setText("生成(C)");
        buttons.setText("PDF出力テスト");
        close.setMnemonic('X');
        close.setText("終了(X)");
        close.setIconPath(ACConstants.ICON_PATH_EXIT_24);
        outputPathContainer.add(outputPath, null);
        outputPathContainer.add(browseOutputtPath, null);
        inputPathContainer.add(inputPath, null);
        inputPathContainer.add(browseInputPath, null);
        conditions.add(inputPathContainer, VRLayout.FLOW_RETURN);
        conditions.add(outputPathContainer, VRLayout.FLOW_RETURN);
        buttons.add(close, VRLayout.EAST);
        buttons.add(read, VRLayout.EAST);
        buttons.add(create, VRLayout.EAST);
        this.add(buttons, VRLayout.NORTH);
        this.add(table, VRLayout.CLIENT);
        this.add(conditions, VRLayout.NORTH);

        ACTableColumn typeColumn = new ACTableColumn(0, 60, "種類");
        ACTableColumn nameColumn = new ACTableColumn(1, 150, "帳票定義体ID");
        ACTableColumn shapeColumn = new ACTableColumn(2, 60, "形状");
        ACTableColumn useColumn = new ACTableColumn(3, 40, "出力");
        useColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_CHECK_BOX);
        useColumn.setEditorType(ACTableCellViewer.EDITOR_TYPE_CHECK_BOX);
        useColumn.setEditable(true);
        useColumn.setHorizontalAlignment(SwingConstants.CENTER);
        ACTableColumn hideColumn = new ACTableColumn(4, 50, "非表示");
        hideColumn.setRendererType(ACTableCellViewer.RENDERER_TYPE_CHECK_BOX);
        hideColumn.setEditorType(ACTableCellViewer.EDITOR_TYPE_CHECK_BOX);
        hideColumn.setEditable(true);
        hideColumn.setHorizontalAlignment(SwingConstants.CENTER);
        ACTableColumn textColumn = new ACTableColumn(5, 200, "文字");
        textColumn.setEditorType(ACTableCellViewer.EDITOR_TYPE_TEXT_FIELD);
        textColumn.setEditable(true);
        table.setColumnModel(new VRTableColumnModel(new ACTableColumn[] {
                typeColumn, nameColumn, shapeColumn, useColumn, hideColumn,
                textColumn, }));

    }

    public static void main(String[] args) {
        ACFrame.debugStart(new ACAffairInfo(NU002.class.getName(), null));
    }

    public boolean canBack(VRMap parameters) {
        return false;
    }

    public ACAffairButtonBar getButtonBar() {
        return buttons;
    }

    public Component getFirstFocusComponent() {
        return null;
    }

    public void initAffair(ACAffairInfo affair) {
        itemList = new ACTableModelAdapter(new String[] { "Type", "Id",
                "Shape", "Use", "Hide", "Text" });
        table.setModel(itemList);
    }
}