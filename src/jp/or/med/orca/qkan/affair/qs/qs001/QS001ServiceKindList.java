package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Dimension;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;

public class QS001ServiceKindList extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JList list = new JList();
	private JScrollPane sp = new JScrollPane();
	
	public QS001ServiceKindList () {
		sp.setPreferredSize(new Dimension(330, 110));
        sp.getViewport().setView(list);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(sp);
	}
	
	public int getItemCount() {
		return list.getModel().getSize();
	}
	public void setSelectedIndex(int index) {
		list.setSelectedIndex(index);
		ensureIndexIsVisible(index);
	}
	
	public int getSelectedIndex() {
		return list.getSelectedIndex();
	}
	
	public void ensureIndexIsVisible(int index) {
		list.ensureIndexIsVisible(index);
	}
	
	public Object getItemAt(int index) {
		return list.getModel().getElementAt(index);
	}
	
	public Object getSelectedValue() {
		return list.getSelectedValue();
	}
	
	public void addListSelectionListener(ListSelectionListener listener) {
		list.addListSelectionListener(listener);
	}

	
	public void setModel(ListModel model) {
		list.setModel(model);
	}
	
	public void setCellRenderer(DefaultListCellRenderer cellRenderer) {
		list.setCellRenderer(cellRenderer);
	}
}
