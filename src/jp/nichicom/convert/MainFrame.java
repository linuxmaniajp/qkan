package jp.nichicom.convert;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import jp.nichicom.convert.util.DBConnect;
import jp.nichicom.convert.util.Log;
import jp.nichicom.convert.util.PropertyUtil;
import jp.nichicom.convert.util.XMLDocumentUtil;

/**
 * ���t�Ǘ����f�[�^�ڍs�c�[��(Ver.6.0.0����)
 * 
 * @version 1.00 2011.11.25
 * @author shin fujihara
 */
public class MainFrame extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * �v���O���X�o�[
     */
    public JProgressBar progress = null;
    public JLabel status = null;
    private JTextField from = null;
    private JTextField to = null;
    private XMLDocumentUtil doc = null;

    private String lineSeparator = System.getProperty("line.separator");
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
//    private static String TITLE = "���ǒ�Ver.6.0.0 �f�[�^�ڍs�c�[��";
    private static String TITLE = "���ǒ�Ver.7.0.0 �f�[�^�ڍs�c�[��";
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
    /**
     * LookAndFeel�̐ݒ�
     */
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable tw) {
        }
    }

    /**
     * �A�b�v�f�[�g�c�[���̎��s
     * 
     * @param args �N�����I�v�V����
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // �������g�̃C���X�^���X��
        JFrame frame = new MainFrame();
        // �t���[���̃Z�b�g�A�b�v
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �I��������
        // ��ʂ̃T�C�Y�����肵�܂��B
        // frame.setSize(new Dimension(500, 200));
        frame.pack();
        // ��ʈʒu�̐ݒ���s���܂��B
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((screenSize.width - frame.getWidth()) / 2,
                (screenSize.height - frame.getHeight()) / 2, frame.getWidth(),
                frame.getHeight());
        // �����i���A���C�Y�j
        frame.setVisible(true);
    }

    // �R���X�g���N�^
    public MainFrame() throws Exception {
        // �X�[�p�[�N���X�̃R���X�g���N�^�Ăяo��
        super(TITLE);

        try {
            Image img = Toolkit.getDefaultToolkit().createImage(
                    MainFrame.class.getClassLoader().getResource(
                            "jp/nichicom/convert/image/flameicon.png"));
            setIconImage(img);
        } catch (Exception e) {
        }

        // ���O���x���̐ݒ�
        Log.setLogLevel(PropertyUtil.getProperty("log.level"));

        try {
            doc = new XMLDocumentUtil(
                    PropertyUtil.getProperty("property.filename"));
        } catch (Exception e) {
            doc = null;
        }

        // �R���e���g�E�y�C���̎擾
        Container cnt = getContentPane();
        cnt.setLayout(new BorderLayout());

        // �ڍs���f�[�^�x�[�X�t�@�C���̓��͗�
        JPanel mp = new JPanel();
        mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));

        JPanel p = new JPanel();
        //p.setMaximumSize(new Dimension(500, 10));
        p.setMinimumSize(new Dimension(500, 10));
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
//        p.setBorder(new CompoundBorder(new TitledBorder(
//                "�P�D�ڍs���̃f�[�^�x�[�X�t�@�C�����w�肵�Ă��������iV5.5.0�ȏ�j"), new EmptyBorder(0, 0,
//                0, 0)));
        p.setBorder(new CompoundBorder(new TitledBorder(
                "�P�D�ڍs���̃f�[�^�x�[�X�t�@�C�����w�肵�Ă��������iV6.1.2�ȏ�j"), new EmptyBorder(0, 0,
                0, 0)));
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - end
        from = new JTextField(30);
        from.setText("");
        JButton btn = new JButton("�J��");
        btn.setActionCommand("from-open");
        btn.addActionListener(this);
        p.add(new JLabel("�ڍs���F"));
        p.add(from);
        p.add(btn);

        mp.add(new JPanel());
        mp.add(p);

        p = new JPanel();
        BorderLayout layout = new BorderLayout();
        layout.setVgap(0);
        p.setLayout(layout);
        //p.setMaximumSize(new Dimension(500, 16));
        p.setMinimumSize(new Dimension(500, 16));
        Icon icon = new ImageIcon(MainFrame.class.getClassLoader().getResource(
                "jp/nichicom/convert/image/arrow.png"));

        p.add(new JLabel(icon));
        mp.add(p);

        p = new JPanel();
        //p.setMaximumSize(new Dimension(500, 10));
        p.setMinimumSize(new Dimension(500, 10));
        to = new JTextField(30);
        if (doc != null) {
            to.setText(doc.getNodeValue("DBConfig", "Path"));
        }
        btn = new JButton("�J��");
        btn.setActionCommand("to-open");
        btn.addActionListener(this);
        p.add(new JLabel("�ڍs��F"));
        p.add(to);
        p.add(btn);

        p.setBorder(new CompoundBorder(new TitledBorder(
                "�Q�D�ڍs��̃f�[�^�x�[�X�t�@�C�����w�肵�Ă�������"), new EmptyBorder(0, 0, 0, 0)));
        mp.add(p);
        p = new JPanel();
        //p.setMaximumSize(new Dimension(500, 10));
        p.setMinimumSize(new Dimension(500, 10));
        p.add(new JLabel(icon));
        mp.add(p);

        p = new JPanel();
        //p.setMaximumSize(new Dimension(500, 10));
        p.setMinimumSize(new Dimension(500, 10));
        btn = new JButton("�ڍs�J�n");
        btn.setActionCommand("run");
        btn.addActionListener(this);
        p.add(btn);

        JButton closeBtn = new JButton("����");
        closeBtn.setActionCommand("close");
        closeBtn.addActionListener(this);

        p.setBorder(new CompoundBorder(new TitledBorder("�R�D�ڍs�J�n�{�^���������Ă�������"),
                new EmptyBorder(0, 0, 0, 0)));
        mp.add(p);

        p = new JPanel();
        progress = new JProgressBar(0, 10);
        progress.setStringPainted(true);
        progress.setIndeterminate(false);
        progress.setPreferredSize(new Dimension(480, 20));
        p.add(progress);
        mp.add(p);

        cnt.add(mp, BorderLayout.CENTER);

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new BorderLayout());
        p = new JPanel();
        status = new JLabel(" ");
        p.add(status);
        cnt.add(p, BorderLayout.SOUTH);

        panelBottom.add(p, BorderLayout.NORTH);
        
        p = new JPanel();
        p.add(closeBtn);
        panelBottom.add(p, BorderLayout.SOUTH);

        cnt.add(panelBottom, BorderLayout.SOUTH);

    }

    /**
     * �{�^���������̃C�x���g����
     */
    public void actionPerformed(ActionEvent ae) {

        if (ae == null) {
            return;
        }

        String cmd = ae.getActionCommand();

        if ("run".equals(cmd)) {

            if (!isValidSelect()) {
                return;
            }

            setEnabledButtons(getContentPane().getComponents(), false);

            if (JOptionPane.showConfirmDialog(this, "�f�[�^�̈ڍs�������J�n���܂��B"
                    + lineSeparator + "���s���Ă���낵���ł����H", TITLE,
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                doConvert();
            } else {
                setEnabledButtons(getContentPane().getComponents(), true);
            }

        } else if ("from-open".equals(cmd)) {
            doSelectFDBFile(from, "�ڍs���̃f�[�^�x�[�X�t�@�C����I��");

        } else if ("to-open".equals(cmd)) {
            doSelectFDBFile(to, "�ڍs��̃f�[�^�x�[�X�t�@�C����I��");

        } else if ("close".equals(cmd)) {
            System.exit(0);
        }
    }

    // fdb�t�@�C���̑I��
    private void doSelectFDBFile(JTextField t, String title) {

        JFileChooser filechooser = new JFileChooser();
        FDBFileFilter filter = new FDBFileFilter();

        filechooser.setDialogTitle(title);
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        filechooser.setCurrentDirectory(new File(t.getText()));
        filechooser.setFileFilter(filter);

        int selected = filechooser.showOpenDialog(this);
        if (selected != JFileChooser.APPROVE_OPTION) {
            return;
        }

        t.setText(filechooser.getSelectedFile().getPath());
    }

    private boolean isValidSelect() {

        // �ڍs���e�L�X�g�{�b�N�X�̓��̓`�F�b�N
        if ("".equals(from.getText())) {
            showError("�ڍs���̃f�[�^�x�[�X�t�@�C����I�����Ă��������B");
            from.requestFocus();
            return false;
        }

        // �ڍs���e�L�X�g�̃t�@�C�����݃`�F�b�N
        File file = new File(from.getText());
        if (!file.exists()) {
            showError("�ڍs���̃f�[�^�x�[�X�t�@�C�������݂��܂���B");
            from.requestFocus();
            return false;
        }

        // �ڍs��e�L�X�g�{�b�N�X�̓��̓`�F�b�N
        if ("".equals(to.getText())) {
            showError("�ڍs��̃f�[�^�x�[�X�t�@�C����I�����Ă��������B");
            to.requestFocus();
            return false;
        }

        // �ڍs��e�L�X�g�̃t�@�C�����݃`�F�b�N
        file = new File(to.getText());
        if (!file.exists()) {
            showError("�ڍs��̃f�[�^�x�[�X�t�@�C�������݂��܂���B");
            to.requestFocus();
            return false;
        }

        // ��U�R�l�N�V������\��A�f�[�^�x�[�X�o�[�W�����̃`�F�b�N
        
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
//        if (!checkVersion(from.getText(), 5)) {
//            from.requestFocus();
//            return false;
//        }
//        if (!checkVersion(to.getText(), 6)) {
//            to.requestFocus();
//            return false;
//        }
        if (!checkVersion(from.getText(), 6)) {
            from.requestFocus();
            return false;
        }
        if (!checkVersion(to.getText(), 7)) {
            to.requestFocus();
            return false;
        }
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
        return true;
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, TITLE,
                JOptionPane.ERROR_MESSAGE);
    }

    private boolean checkVersion(String path, int targetVersion) {

        try {
            DBConnect con = new DBConnect(doc, path);

            String scv = con
                    .execQuerySingle("SELECT SCHEME_VERSION FROM M_QKAN_VERSION");

// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
//            StringBuffer sql = new StringBuffer();
//            sql.append("SELECT COUNT(*) AS T_EXIST FROM RDB$RELATIONS");
//            sql.append(" WHERE");
//            sql.append(" (RDB$FLAGS = 1)");
//            sql.append(" AND (RDB$RELATION_NAME = 'M_PARAMETER')");
//
//            String maiExists = con.execQuerySingle(sql.toString());
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - end
            String[] ary = scv.split("\\.");
            int majer = Integer.parseInt(ary[0]);
            int miner = Integer.parseInt(ary[1]);
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
            int rev = Integer.parseInt(ary[2]);
//            int maii = 6;
//
//            if (Integer.parseInt(maiExists) == 1) {
//                maii = 5;
//            }
//
//            if (majer != maii) {
//                showError("�f�[�^�x�[�X�̕s���������o���܂����B" + lineSeparator
//                        + "�o�[�W�������ƃe�[�u���̌`������v���܂���B");
//                return false;
//            }
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - end
            if (majer != targetVersion) {

// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
//                if (targetVersion == 5) {
                if (targetVersion == 6) {
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - end
                    showError("�ڍs���̃f�[�^�x�[�X�t�@�C���ɁA�V�����o�[�W�����̋��ǒ��p�f�[�^�x�[�X�t�@�C�����w�肳��Ă��܂��B");
                } else {
                    showError("�ڍs��̃f�[�^�x�[�X�t�@�C���ɁA�Â��o�[�W�����̋��ǒ��p�f�[�^�x�[�X�t�@�C�����w�肳��Ă��܂��B");
                }

                return false;
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - begin
//            } else if (targetVersion == 5) {
//                // ���o�[�W�����́A�X�L�[�}�o�[�W���� V5.5.0��v��
//                if ((majer != 5) || (miner != 5)) {
//                    showError("�ڍs���̃f�[�^�x�[�X�t�@�C�����ŐV�o�[�W�����ɃA�b�v�f�[�g���Ă��������B"
//                            + lineSeparator + "�v���o�[�W�����F5.5.0" + lineSeparator
//                            + "�w�肳�ꂽ�f�[�^�x�[�X�t�@�C���̃o�[�W�����F" + scv);
//                    return false;
//                }
            } else if (targetVersion == 6) {
                // ���o�[�W�����́A�X�L�[�}�o�[�W���� V6.1.2��v��
                if ( !(    ((majer == 6) && (miner == 1) && (rev >= 2))
                		|| ((majer == 6) && (miner > 1))
                	  )
                ) {
                    showError("�ڍs���̃f�[�^�x�[�X�t�@�C�����ŐV�o�[�W�����ɃA�b�v�f�[�g���Ă��������B"
                            + lineSeparator + "�v���o�[�W�����F6.1.2" + lineSeparator
                            + "�w�肳�ꂽ�f�[�^�x�[�X�t�@�C���̃o�[�W�����F" + scv);
                    return false;
                }
// 2015/2/2 [H27.4�����Ή�][Yoichiro Kamei] mod - end
            }

            return true;

        } catch (NumberFormatException e) {
            showError("�o�[�W�������̎擾�Ɏ��s���܂����B" + lineSeparator + e.getMessage());
            return false;
        } catch (Exception e) {
            showError("�f�[�^�x�[�X�̐ڑ��Ɏ��s���܂����B" + lineSeparator + e.getMessage());
            return false;
        }

    }

    /**
     * �R���o�[�g�������s
     * 
     */
    private void doConvert() {

        try {

            progress.setMaximum(100);
            ConvertTask task = new ConvertTask();
            task.putTask(this, new DBConnect(doc, from.getText()),
                    new DBConnect(doc, to.getText()));

            Thread thread = new Thread(task);
            thread.start();

        } catch (Exception e) {

            StringBuffer msg = new StringBuffer();
            msg.append("�f�[�^�ڍs���ɃG���[���������܂����B");
            msg.append(lineSeparator);
            msg.append("�����𑱍s�ł��܂���B");
            msg.append(lineSeparator);
            msg.append(lineSeparator);
            msg.append(status.getText());
            msg.append(lineSeparator);
            msg.append(e.getMessage());

            Log.warning("�f�[�^�ڍs�G���[:" + msg.toString());

            showError(msg.toString());

            initState();
        }
    }

    public void taskEnd(Exception runException) {

        if (runException != null) {

            StringBuffer msg = new StringBuffer();
            msg.append("�f�[�^�ڍs���ɃG���[���������܂����B");
            msg.append(lineSeparator);
            msg.append("�����𑱍s�ł��܂���B");
            msg.append(lineSeparator);
            msg.append(lineSeparator);
            msg.append(status.getText());
            msg.append(lineSeparator);
            msg.append(runException.getMessage());

            Log.warning("�f�[�^�ڍs�G���[:" + msg.toString());

            showError(msg.toString());

        } else {

            // �v���O���X�o�[��L�΂��؂�
            progress.setValue(100);
            status.setText("�ڍs����");

            // �X�V�������s
            JOptionPane.showConfirmDialog(this, "�f�[�^�ڍs���������܂����B", TITLE,
                    JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }

        initState();
    }

    private void initState() {
        setEnabledButtons(getContentPane().getComponents(), true);
        progress.setValue(0);
        status.setText(" ");
    }

    private void setEnabledButtons(Component[] comps, boolean enabled) {
        for (int i = 0; i < comps.length; i++) {
            if (comps[i] instanceof JButton) {
                ((JButton) comps[i]).setEnabled(enabled);
            } else if (comps[i] instanceof Container) {
                setEnabledButtons(((Container) comps[i]).getComponents(),
                        enabled);
            }
        }

    }
}
