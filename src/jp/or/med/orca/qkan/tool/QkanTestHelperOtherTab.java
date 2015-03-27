package jp.or.med.orca.qkan.tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.ListModel;

import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001Design;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServiceKindList;

public class QkanTestHelperOtherTab extends JPanel {

    private static final long serialVersionUID = 1L;

    private static final QkanTestHelperOtherTab INSTANCE = new QkanTestHelperOtherTab();

    private ListModel backModel = null;

    private QkanTestHelperOtherTab() {
        super();
        initComponents();
    }

    public static QkanTestHelperOtherTab getInstance() {
        return INSTANCE;
    }

    private void initComponents() {

        String[] names = { "âÓåÏ_äÓñ{", "ó\ñh_äÓñ{", "íZä˙ì¸èäÅEó√ó{", "é{ê›", "ì¡íËé{ê›", "ãèëÓâÓåÏéxâá" };
        final JComboBox cmb = new JComboBox(names);
        final JButton listChangeButton = new JButton("ÉTÅ[ÉrÉXÉäÉXÉgçiÇËçûÇ›");
        final VRMap cutMap = new VRHashMap();
        cutMap.setData("11111", 0);
        cutMap.setData("11211", 0);
        cutMap.setData("11311", 0);
        cutMap.setData("11411", 0);
        cutMap.setData("11511", 0);
        cutMap.setData("11611", 0);
        cutMap.setData("11711", 0);
        cutMap.setData("12111", 2);
        cutMap.setData("12211", 2);
        cutMap.setData("12311", 2);
        cutMap.setData("12312", 2);
        cutMap.setData("12313", 2);
        cutMap.setData("13111", 0);
        cutMap.setData("13311", 4);
        cutMap.setData("14311", 5);
        cutMap.setData("15111", 3);
        cutMap.setData("15211", 3);
        cutMap.setData("15311", 3);
        cutMap.setData("15312", 3);
        cutMap.setData("15313", 3);
        cutMap.setData("17111", 0);
        cutMap.setData("17211", 0);
        cutMap.setData("17311", 0);
        cutMap.setData("16811", 0);
        cutMap.setData("13211", 0);
        cutMap.setData("13811", 0);
        cutMap.setData("13611", 4);
        cutMap.setData("15411", 3);
        cutMap.setData("16111", 1);
        cutMap.setData("16211", 1);
        cutMap.setData("16311", 1);
        cutMap.setData("16411", 1);
        cutMap.setData("16511", 1);
        cutMap.setData("16611", 1);
        cutMap.setData("16711", 1);
        cutMap.setData("12411", 2);
        cutMap.setData("12511", 2);
        cutMap.setData("12611", 2);
        cutMap.setData("12612", 2);
        cutMap.setData("12613", 2);
        cutMap.setData("13411", 1);
        cutMap.setData("13511", 4);
        cutMap.setData("14611", 5);
        cutMap.setData("17411", 1);
        cutMap.setData("17511", 1);
        cutMap.setData("16911", 1);
        cutMap.setData("13711", 1);
        cutMap.setData("13911", 1);
        cutMap.setData("12711", 4);
        cutMap.setData("17611", 0);
        cutMap.setData("12811", 4);
        cutMap.setData("17711", 0);
        cutMap.setData("17911", 0);

        listChangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QS001ServiceKindList list = getServiceList();
                if (list != null) {
                    if (backModel == null) {
                        backModel = list.getModel();
                    } else {
                        list.setModel(backModel);
                    }
                    DefaultListModel newModel = new DefaultListModel();
                    int cmbMode = cmb.getSelectedIndex();
                    for (int i = 0; i < list.getItemCount(); i++) {
                        LinkedHashMap map = (LinkedHashMap) list.getItemAt(i);
                        String kind = ACCastUtilities.toString(
                                map.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
                        if (cmbMode == ACCastUtilities.toInt(
                                cutMap.getData(kind), 0)) {
                            newModel.addElement(list.getModel().getElementAt(i));
                        }
                    }
                    getServiceList().setModel(newModel);
                }
            }
        });
        add(cmb);
        add(listChangeButton);

        final JButton listBack = new JButton("å≥Ç…ñﬂÇ∑");

        listBack.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                QS001ServiceKindList list = getServiceList();
                if (list != null) {
                    if (backModel != null) {
                        list.setModel(backModel);
                    }
                }
            }
        });
        add(listBack);
        
        String[] typeNnames = { "ëÊìÒ", "ëÊìÒÇÃìÒ", "ëÊéO", "ëÊéOÇÃìÒ", "ëÊél", "ëÊélÇÃìÒ",
                "ëÊå‹", "ëÊå‹ÇÃìÒ", "ëÊòZ", "ëÊòZÇÃìÒ", "ëÊòZÇÃéO", "ëÊòZÇÃél", "ëÊòZÇÃå‹", "ëÊòZÇÃòZ", "ëÊòZÇÃéµ",
                "ëÊéµ", "ëÊéµÇÃìÒ", "ëÊî™", "ëÊã„", "ëÊè\"};
        final JComboBox cmbType = new JComboBox(typeNnames);
        final JButton listChangeTypeButton = new JButton("óléÆÇ≈çiÇËçûÇ›");
        
        listChangeTypeButton.addActionListener(new ActionListener() {
            
            private String[][] styleType = 
                {{"11111","11211","11311","11411","11511","11611","11711","13111","17111","17211","17311","16811","17611","17711","17911"},
                {"16111","16211","16311","16411","16511","16611","16711","13411","17411","17511","16911"},
                {"12111"},
                {"12411"},
                {"12211"},
                {"12511"},
                {"12311","12312","12313"},
                {"12611","12612","12613"},
                {"13211"},
                {"13711"},
                {"13311","13611"},
                {"13511"},
                {"13811"},
                {"13911"},
                {"12711","12811"},
                {"14311"},
                {"14611"},
                {"15111","15411"},
                {"15211"},
                {"15311","15312","15313"}};
            @Override
            public void actionPerformed(ActionEvent e) {
                QS001ServiceKindList list = getServiceList();
                if (list == null) {
                    return;
                }
                if (backModel == null) {
                    backModel = list.getModel();
                } else {
                    list.setModel(backModel);
                }
                
                DefaultListModel newModel = new DefaultListModel();
                for (int i = 0; i < list.getItemCount(); i++) {
                    Map map = (Map) list.getItemAt(i);
                    String kind = ACCastUtilities.toString(map.get("SYSTEM_SERVICE_KIND_DETAIL"), "");
                    
                    for (String style : styleType[cmbType.getSelectedIndex()]) {
                        if (kind.equals(style)) {
                            newModel.addElement(list.getModel().getElementAt(i));
                            break;
                        }
                    }
                }
                getServiceList().setModel(newModel);
            }
        });
        
        add(cmbType);
        add(listChangeTypeButton);

    }

    private static QS001ServiceKindList getServiceList() {
        ACAffairable nowPanel = QkanTestHelper.getNowPanel();

        if (nowPanel instanceof QS001Design) {
            QS001ServiceKindList list = ((QS001Design) nowPanel)
                    .getServiceKindList();
            return list;
        }

        return null;
    }

}
