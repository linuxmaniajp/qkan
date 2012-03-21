package jp.or.med.orca.qkan.tool;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACDBManagerCreatable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.sql.ACDBManager;

public class QkanTestHelper extends JDialog {
	private static final long serialVersionUID = 1L;
	private static ACDBManager dbm;

	private static final QkanTestHelper singleton = new QkanTestHelper(ACFrame.getInstance(),
			"ÉwÉãÉpÅ[", false);

	public static final QkanTestHelper getInstance() {
		return singleton;
	}

	private QkanTestHelper(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		initComponent();
	}

	private void initComponent() {
		setSize(150, 300);
		setLocation((int) Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth() - 150, 0);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		final JTabbedPane tabs = new JTabbedPane();

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(tabs, BorderLayout.CENTER);

		tabs.addTab("ó\íËÅEé¿ê—", QkanTestHelperServiceTab.getInstance());
	}

	static ACAffairable getNowPanel() {
		return ACFrame.getInstance().getNowPanel();
	}

	static ACDBManager getDBManager() throws Exception {
		if (dbm == null) {
			dbm = ((ACDBManagerCreatable) ACFrame.getInstance()
					.getFrameEventProcesser()).createDBManager();
		}
		return dbm;
	}

}
