package jp.nichicom.copaychecker;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import java.io.*;

import jp.nichicom.copaychecker.util.*;

/**
 * 自己負担金過誤チェックツール
 * @version 1.00 2008.9.3
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
	public JProgressBar progress;
	public JLabel status;
	
	private String lineSeparator = System.getProperty("line.separator");
	private static String TITLE = "全額自己負担チェックツール";
	
	/**
	 * LookAndFeelの設定
	 */
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable tw) { }
	}

	/**
	 * アップデートツールの実行
	 * @param args 起動時オプション
	 */
	public static void main(String[] args) {
		// 自分自身のインスタンス化
	    JFrame frame = new MainFrame();
		// フレームのセットアップ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 終了時処理
		//画面のサイズを決定します。
		frame.setSize(new Dimension(500, 110));
		// 画面位置の設定を行います。
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds( (screenSize.width - frame.getWidth()) / 2,
			(screenSize.height - frame.getHeight()) /
			2, frame.getWidth(), frame.getHeight());
		// 可視化（リアライズ）
		frame.setVisible(true);
	}

	// コンストラクタ
	public MainFrame() {
		// スーパークラスのコンストラクタ呼び出し
		super(TITLE);
		
		//ログレベルの設定
		Log.setLogLevel(PropertyUtil.getProperty("log.level"));

		//実行ボタンの作成
		JButton update = new JButton("チェック実行(R)");
		update.setMnemonic('R');
		update.setActionCommand("recovery");
		update.addActionListener(this);
		
		// 終了ボタンの作成
		JButton cancel = new JButton("終了(E)");
		cancel.setMnemonic('E');
		cancel.setActionCommand("cancel");
		cancel.addActionListener(this);;
	
		// パネルに部品を追加
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel panel2 = new JPanel();
		panel2.add(update,BorderLayout.NORTH);
		panel2.add(cancel,BorderLayout.NORTH);
		panel.add(panel2, BorderLayout.NORTH);
	
		progress = new JProgressBar(0,10);
		progress.setStringPainted(true);
		progress.setIndeterminate(false);
		
		JPanel panelBottom = new JPanel();
		status = new JLabel(" ");
		panelBottom.add(status);
		
		// コンテント・ペインの取得
		Container cnt = getContentPane();
		cnt.setLayout(new BorderLayout());
		// コンテント・ペインに部品を追加
		cnt.add(panel, BorderLayout.NORTH);
		cnt.add(progress,BorderLayout.CENTER);
		cnt.add(panelBottom,BorderLayout.SOUTH);
		
		File file = new File("temp");
		if(file.exists()){
			file.delete();
		}
		file.mkdir();
	}

	/**
	 * ボタン押下時のイベント処理
	 */
	public void actionPerformed(ActionEvent ae) {
		if ("recovery".equals(ae.getActionCommand())) {
			StringBuffer sb = new StringBuffer();
			
			sb.append("全額自己負担金額チェックを実行します。");
			sb.append(lineSeparator);
			sb.append(lineSeparator);
			sb.append("チェック処理は数分にわたる場合があります。");
			sb.append(lineSeparator);
			sb.append("（処理中に画面が反応しなくなることもあります。）");
			sb.append(lineSeparator);
			sb.append(lineSeparator);
			sb.append("実行してもよろしいですか？");
			
            if(JOptionPane.showConfirmDialog(this, sb.toString(),TITLE,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
            	doCopayCheck();
            }
		} else if ("cancel".equals(ae.getActionCommand())) {
			System.exit(0);
		}
	}
	
	/**
	 * 全額自己負担過誤チェック処理を実行する。
	 *
	 */
	private void doCopayCheck(){
		
		try{
			
			progress.setMaximum(100);
			CopayChecker task = new CopayChecker();
			
			setEnabledButtons(getContentPane().getComponents(),false);
			
			task.runTask(this);
			
			//ステータスバーを延ばしきる
			progress.setValue(100);
			status.setText(" ");
            boolean isErrored = false;
			if (task.existErrorList()) {
				JOptionPane.showConfirmDialog(this,"金額チェックが終了しました。" + lineSeparator + "誤った金額が印字された可能性のある利用者のリストを作成します。",TITLE,JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
				
				try {
					//Macで動かないのは承知の上
					//Runtime.getRuntime().exec("excel logs/copaycheck.txt");
					
					//デスクトップに作成したファイルをコピー
					String filepath = "logs/copaycheck.csv";
					String osName = "";
                    String desktop = "";
                    
                    if(System.getProperty("os.name") != null){
                        osName = System.getProperty("os.name");
                        // 大文字にする
                        osName = osName.toUpperCase();
                    }
                    if("WINDOWS VISTA".equals(osName)){
                        // Vista
                        desktop = System.getProperty("user.home") + "\\Desktop\\copaycheck.csv";
                    } else {
                        // Vista以外
                        desktop = System.getProperty("user.home") + "\\デスクトップ\\copaycheck.csv";
                    }
					
					try {
						Util.copyFile(new File(filepath), new File(desktop));
						filepath = desktop;
					} catch(Exception e){
						File f = new File(filepath);
						JOptionPane.showConfirmDialog(this,
								"結果のデスクトップへのコピーが失敗しました。" + lineSeparator
										+ "結果は" + f.getAbsolutePath()
										+ "に保存しています。" + lineSeparator + "※デスクトップの結果ファイルが既に開いていないか等を確認してください。", TITLE,
								JOptionPane.CLOSED_OPTION,
								JOptionPane.INFORMATION_MESSAGE);
                        setEnabledButtons(getContentPane().getComponents(),true);
                        isErrored = true;
					}
					
					//vsbファイル作成
					Util.makeDir("logs/excelpath.vbs");
					
					OutputStreamWriter objOsr = new OutputStreamWriter(
							new FileOutputStream(new File("logs/excelpath.vbs")));
					BufferedWriter objBw = new BufferedWriter(objOsr);
					
					objBw.write("On Error Resume Next\n");
					objBw.write("Set exl = CreateObject(\"Excel.Application\")\n");
					objBw.write("WScript.Echo exl.Path & \"\\excel.exe \"\n");
					objBw.write("On Error Goto 0\n");
					objBw.close();
					
					Process proc = Runtime.getRuntime().exec("cscript //Nologo logs/excelpath.vbs");
					InputStream is = proc.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
				    String exlpath = "";
				    String line;
				    while ((line = br.readLine()) != null) {
				    	exlpath = line;
				    }
					
					Runtime.getRuntime().exec(exlpath + " \"" + filepath + "\"");
				} catch (Exception e){
                    // 上記でエラーが発生している場合はメッセージスキップ
                    if(!isErrored){
    					JOptionPane.showConfirmDialog(this, "デスクトップに結果を保存しました。"
    							+ lineSeparator + "結果を確認してください。", TITLE,
    							JOptionPane.CLOSED_OPTION,
    							JOptionPane.INFORMATION_MESSAGE);
                    }
				}
				
			} else {
				JOptionPane.showConfirmDialog(this, "正しく印字されています。"
                        + lineSeparator + "修正の必要はありません", TITLE,
                        JOptionPane.CLOSED_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch(Exception e){
			Log.warning("金額チェックエラー:" + e.getLocalizedMessage());
			JOptionPane.showConfirmDialog(this, "金額チェック中にエラーが発生しました。"
					+ lineSeparator + "処理を続行できません。", TITLE,
					JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
		}
		setEnabledButtons(getContentPane().getComponents(),true);
		
		progress.setValue(0);
		status.setText(" ");
	}
	
	private void setEnabledButtons(Component[] comps,boolean enabled){
		for(int i = 0; i < comps.length; i++){
			if(comps[i] instanceof JButton){
				((JButton)comps[i]).setEnabled(enabled);
			} else if(comps[i] instanceof Container) {
				setEnabledButtons( ((Container)comps[i]).getComponents(),enabled);
			}
		}
	}
}
