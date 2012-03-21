package jp.nichicom.convert.util;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

//import jp.nichicom.update.task.DataUpdateTask;
//import jp.nichicom.update.task.ModuleCopyTask;
//import jp.nichicom.update.task.SchemaChangeTask;

// java 5�ł͎g�p�ł��Ȃ�
//import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * XML�h�L�������g����N���X
 * 
 * @version 1.01 2005/10/13
 * @author shin fujihara 1.01 java1.5 �ɑΉ�
 */
public class XMLDocumentUtil {

    /**
     * ��荞��XML�t�@�C����
     */
    private String xmlFileName = "";

    private String rootTagName = "properties";
    private String tagName = "property";

    /**
     * �h�L�������g�̃��[�g�v�f
     */
    private Element root;

    public XMLDocumentUtil(String documentPath) throws Exception {
        try {
            
            if ("".equals(documentPath)) {
                documentPath = "property.xml";
            }

            // �h�L�������g�r���_�[�t�@�N�g���𐶐�
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory
                    .newInstance();
            // �h�L�������g�r���_�[�𐶐�
            DocumentBuilder builder = dbfactory.newDocumentBuilder();
            // �p�[�X�����s����Document�I�u�W�F�N�g���擾
            Document doc = builder.parse(documentPath);
            // ���[�g�v�f���擾
            root = doc.getDocumentElement();

            // ���ǒ��ƈӌ����̃^�O�̖��O�̈Ⴂ���z��
            if (documentPath.startsWith("Ikensyo")) {
                rootTagName = "properities";
                tagName = "properity";
            }

        } catch (Exception e) {
            Log.warning("XMLDocument create Error : " + e.getLocalizedMessage());
            throw e;
        }
        xmlFileName = documentPath;
    }

    public String getPostURL() throws Exception {
        String url = "";
        try {
            NodeList list = root.getElementsByTagName("post_data");

            for (int i = 0; i < list.getLength(); i++) {
                Element el = (Element) list.item(i);
                url = getNodeValue(el, "module_url");
            }

        } catch (Exception e) {
            Log.warning("XML Parse Error : " + "update task�t�@�C���̃p�[�X�Ɏ��s���܂����B");
            throw e;
        }
        return url;
    }

    /**
     * ��荞�񂾃h�L�������g�ɑ΂��AXPath�𔭍s����B
     * 
     * @param xpath
     *            XPath
     * @return XPath�œ���ꂽ�l
     * @throws Exception
     *             ���s���G���[
     */
    public String getNodeValue(String xpath) throws Exception {
        return getNodeValue(root, xpath);
    }

    /**
     * �w�肵���m�[�h�̒l���擾����B
     * 
     * @param n
     *            XPath�����s����m�[�h
     * @param xpath
     *            ���s����XPathr
     * @return XPath�œ���ꂽ�l
     * @throws Exception
     *             ���s���G���[
     */
    private String getNodeValue(Node n, String xpath) throws Exception {
        String result = "";

        int index = xpath.indexOf("/");

        if (index != -1) {
            NodeList nodelist = ((Element) n).getElementsByTagName(xpath
                    .substring(0, index));
            return getNodeValue(nodelist.item(0), xpath.substring(index + 1));
        }

        NodeList nodelist = ((Element) n).getElementsByTagName(xpath);
        Node node;

        for (int i = 0; i < nodelist.getLength(); i++) {
            node = nodelist.item(i);
            if (node.getFirstChild() != null) {
                result = node.getFirstChild().getNodeValue();
            }
        }

        return result;
    }

    /**
     * �ݒ�t�@�C������o�[�W���������擾����B
     * 
     * @param properities
     * @param properity
     * @return
     * @throws Exception
     */
    public String getNodeValue(String properities, String properity)
            throws Exception {
        String result = "";
        Node node = getNode(properities, properity);

        if (node != null) {
            result = node.getNodeValue();
        }

        return result;
    }

    /**
     * �ݒ�t�@�C������o�[�W���������擾����B
     * 
     * @param properities
     * @param properity
     * @return
     * @throws Exception
     */
    public void setNodeValue(String properities, String properity, String value)
            throws Exception {
        Node node = getNode(properities, properity);

        if (node != null) {
            node.setNodeValue(value);
        }
    }

    /**
     * �ݒ�t�@�C������w�肳�ꂽ�m�[�h���擾����B
     * 
     * @param properities
     * @param properity
     * @return �w��m�[�h��������Ȃ��ꍇ�́Anull�����^�[��
     */
    private Node getNode(String properities, String properity) {
        NodeList list = root.getElementsByTagName(rootTagName);
        Node n;
        for (int i = 0; i < list.getLength(); i++) {
            n = list.item(i);
            NamedNodeMap map = n.getAttributes();
            if (properities.equals(map.getNamedItem("id").getNodeValue())) {
                NodeList list2 = ((Element) n).getElementsByTagName(tagName);
                for (int j = 0; j < list2.getLength(); j++) {
                    Node node = list2.item(j);
                    NamedNodeMap map2 = node.getAttributes();
                    if (properity
                            .equals(map2.getNamedItem("id").getNodeValue())) {
                        return node.getFirstChild();
                    }
                }
            }
        }
        return null;
    }

    /**
     * �h�L�������g��XML�t�@�C���ŕۑ�����B
     * 
     * @throws Exception
     *             ���s���G���[
     */
    public void store() throws Exception {
        store(xmlFileName);
    }

    /**
     * �w�肵���p�X�ցA�h�L�������g��XML�t�@�C���Ƀp�[�X���ۑ�����B
     * 
     * @param fileName
     *            xml�t�@�C����
     * @throws Exception
     *             ���s���G���[
     */
    public void store(String fileName) throws Exception {
        File newXML = new File(fileName);
        Transformer tm;
        try {
            tm = TransformerFactory.newInstance().newTransformer();
            tm.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            tm.transform(new DOMSource(root), new StreamResult(
                    new FileOutputStream(newXML)));
        } catch (Exception e) {
            Log.warning("store Error : " + fileName);
            throw e;
        }
        newXML = null;
    }

}
