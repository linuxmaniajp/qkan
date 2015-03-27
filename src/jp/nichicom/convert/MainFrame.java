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
 * 給付管理鳥データ移行ツール(Ver.6.0.0向け)
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
     * プログレスバー
     */
    public JProgressBar progress = null;
    public JLabel status = null;
    private JTextField from = null;
    private JTextField to = null;
    private XMLDocumentUtil doc = null;

    private String lineSeparator = System.getProperty("line.separator");
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - begin
//    private static String TITLE = "給管鳥Ver.6.0.0 データ移行ツール";
    private static String TITLE = "給管鳥Ver.7.0.0 データ移行ツール";
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - begin
    /**
     * LookAndFeelの設定
     */
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable tw) {
        }
    }

    /**
     * アップデートツールの実行
     * 
     * @param args 起動時オプション
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 自分自身のインスタンス化
        JFrame frame = new MainFrame();
        // フレームのセットアップ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 終了時処理
        // 画面のサイズを決定します。
        // frame.setSize(new Dimension(500, 200));
        frame.pack();
        // 画面位置の設定を行います。
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((screenSize.width - frame.getWidth()) / 2,
                (screenSize.height - frame.getHeight()) / 2, frame.getWidth(),
                frame.getHeight());
        // 可視化（リアライズ）
        frame.setVisible(true);
    }

    // コンストラクタ
    public MainFrame() throws Exception {
        // スーパークラスのコンストラクタ呼び出し
        super(TITLE);

        try {
            Image img = Toolkit.getDefaultToolkit().createImage(
                    MainFrame.class.getClassLoader().getResource(
                            "jp/nichicom/convert/image/flameicon.png"));
            setIconImage(img);
        } catch (Exception e) {
        }

        // ログレベルの設定
        Log.setLogLevel(PropertyUtil.getProperty("log.level"));

        try {
            doc = new XMLDocumentUtil(
                    PropertyUtil.getProperty("property.filename"));
        } catch (Exception e) {
            doc = null;
        }

        // コンテント・ペインの取得
        Container cnt = getContentPane();
        cnt.setLayout(new BorderLayout());

        // 移行元データベースファイルの入力欄
        JPanel mp = new JPanel();
        mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));

        JPanel p = new JPanel();
        //p.setMaximumSize(new Dimension(500, 10));
        p.setMinimumSize(new Dimension(500, 10));
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - begin
//        p.setBorder(new CompoundBorder(new TitledBorder(
//                "１．移行元のデータベースファイルを指定してください（V5.5.0以上）"), new EmptyBorder(0, 0,
//                0, 0)));
        p.setBorder(new CompoundBorder(new TitledBorder(
                "１．移行元のデータベースファイルを指定してください（V6.1.2以上）"), new EmptyBorder(0, 0,
                0, 0)));
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - end
        from = new JTextField(30);
        from.setText("");
        JButton btn = new JButton("開く");
        btn.setActionCommand("from-open");
        btn.addActionListener(this);
        p.add(new JLabel("移行元："));
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
        btn = new JButton("開く");
        btn.setActionCommand("to-open");
        btn.addActionListener(this);
        p.add(new JLabel("移行先："));
        p.add(to);
        p.add(btn);

        p.setBorder(new CompoundBorder(new TitledBorder(
                "２．移行先のデータベースファイルを指定してください"), new EmptyBorder(0, 0, 0, 0)));
        mp.add(p);
        p = new JPanel();
        //p.setMaximumSize(new Dimension(500, 10));
        p.setMinimumSize(new Dimension(500, 10));
        p.add(new JLabel(icon));
        mp.add(p);

        p = new JPanel();
        //p.setMaximumSize(new Dimension(500, 10));
        p.setMinimumSize(new Dimension(500, 10));
        btn = new JButton("移行開始");
        btn.setActionCommand("run");
        btn.addActionListener(this);
        p.add(btn);

        JButton closeBtn = new JButton("閉じる");
        closeBtn.setActionCommand("close");
        closeBtn.addActionListener(this);

        p.setBorder(new CompoundBorder(new TitledBorder("３．移行開始ボタンを押してください"),
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
     * ボタン押下時のイベント処理
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

            if (JOptionPane.showConfirmDialog(this, "データの移行処理を開始します。"
                    + lineSeparator + "実行してもよろしいですか？", TITLE,
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                doConvert();
            } else {
                setEnabledButtons(getContentPane().getComponents(), true);
            }

        } else if ("from-open".equals(cmd)) {
            doSelectFDBFile(from, "移行元のデータベースファイルを選択");

        } else if ("to-open".equals(cmd)) {
            doSelectFDBFile(to, "移行先のデータベースファイルを選択");

        } else if ("close".equals(cmd)) {
            System.exit(0);
        }
    }

    // fdbファイルの選択
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

        // 移行元テキストボックスの入力チェック
        if ("".equals(from.getText())) {
            showError("移行元のデータベースファイルを選択してください。");
            from.requestFocus();
            return false;
        }

        // 移行元テキストのファイル存在チェック
        File file = new File(from.getText());
        if (!file.exists()) {
            showError("移行元のデータベースファイルが存在しません。");
            from.requestFocus();
            return false;
        }

        // 移行先テキストボックスの入力チェック
        if ("".equals(to.getText())) {
            showError("移行先のデータベースファイルを選択してください。");
            to.requestFocus();
            return false;
        }

        // 移行先テキストのファイル存在チェック
        file = new File(to.getText());
        if (!file.exists()) {
            showError("移行先のデータベースファイルが存在しません。");
            to.requestFocus();
            return false;
        }

        // 一旦コネクションを貼り、データベースバージョンのチェック
        
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - begin
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
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - begin
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

// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - begin
//            StringBuffer sql = new StringBuffer();
//            sql.append("SELECT COUNT(*) AS T_EXIST FROM RDB$RELATIONS");
//            sql.append(" WHERE");
//            sql.append(" (RDB$FLAGS = 1)");
//            sql.append(" AND (RDB$RELATION_NAME = 'M_PARAMETER')");
//
//            String maiExists = con.execQuerySingle(sql.toString());
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - end
            String[] ary = scv.split("\\.");
            int majer = Integer.parseInt(ary[0]);
            int miner = Integer.parseInt(ary[1]);
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - begin
            int rev = Integer.parseInt(ary[2]);
//            int maii = 6;
//
//            if (Integer.parseInt(maiExists) == 1) {
//                maii = 5;
//            }
//
//            if (majer != maii) {
//                showError("データベースの不整合を検出しました。" + lineSeparator
//                        + "バージョン情報とテーブルの形式が一致しません。");
//                return false;
//            }
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - end
            if (majer != targetVersion) {

// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - begin
//                if (targetVersion == 5) {
                if (targetVersion == 6) {
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - end
                    showError("移行元のデータベースファイルに、新しいバージョンの給管鳥用データベースファイルが指定されています。");
                } else {
                    showError("移行先のデータベースファイルに、古いバージョンの給管鳥用データベースファイルが指定されています。");
                }

                return false;
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - begin
//            } else if (targetVersion == 5) {
//                // 旧バージョンは、スキーマバージョン V5.5.0を要求
//                if ((majer != 5) || (miner != 5)) {
//                    showError("移行元のデータベースファイルを最新バージョンにアップデートしてください。"
//                            + lineSeparator + "要求バージョン：5.5.0" + lineSeparator
//                            + "指定されたデータベースファイルのバージョン：" + scv);
//                    return false;
//                }
            } else if (targetVersion == 6) {
                // 旧バージョンは、スキーマバージョン V6.1.2を要求
                if ( !(    ((majer == 6) && (miner == 1) && (rev >= 2))
                		|| ((majer == 6) && (miner > 1))
                	  )
                ) {
                    showError("移行元のデータベースファイルを最新バージョンにアップデートしてください。"
                            + lineSeparator + "要求バージョン：6.1.2" + lineSeparator
                            + "指定されたデータベースファイルのバージョン：" + scv);
                    return false;
                }
// 2015/2/2 [H27.4改正対応][Yoichiro Kamei] mod - end
            }

            return true;

        } catch (NumberFormatException e) {
            showError("バージョン情報の取得に失敗しました。" + lineSeparator + e.getMessage());
            return false;
        } catch (Exception e) {
            showError("データベースの接続に失敗しました。" + lineSeparator + e.getMessage());
            return false;
        }

    }

    /**
     * コンバート処理実行
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
            msg.append("データ移行時にエラーが発生しました。");
            msg.append(lineSeparator);
            msg.append("処理を続行できません。");
            msg.append(lineSeparator);
            msg.append(lineSeparator);
            msg.append(status.getText());
            msg.append(lineSeparator);
            msg.append(e.getMessage());

            Log.warning("データ移行エラー:" + msg.toString());

            showError(msg.toString());

            initState();
        }
    }

    public void taskEnd(Exception runException) {

        if (runException != null) {

            StringBuffer msg = new StringBuffer();
            msg.append("データ移行時にエラーが発生しました。");
            msg.append(lineSeparator);
            msg.append("処理を続行できません。");
            msg.append(lineSeparator);
            msg.append(lineSeparator);
            msg.append(status.getText());
            msg.append(lineSeparator);
            msg.append(runException.getMessage());

            Log.warning("データ移行エラー:" + msg.toString());

            showError(msg.toString());

        } else {

            // プログレスバーを伸ばし切る
            progress.setValue(100);
            status.setText("移行完了");

            // 更新処理実行
            JOptionPane.showConfirmDialog(this, "データ移行が完了しました。", TITLE,
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
