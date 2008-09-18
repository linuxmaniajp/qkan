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
 * ���ȕ��S���ߌ�`�F�b�N�c�[��
 * @version 1.00 2008.9.3
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
	public JProgressBar progress;
	public JLabel status;
	
	private String lineSeparator = System.getProperty("line.separator");
	private static String TITLE = "�S�z���ȕ��S�`�F�b�N�c�[��";
	
	/**
	 * LookAndFeel�̐ݒ�
	 */
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable tw) { }
	}

	/**
	 * �A�b�v�f�[�g�c�[���̎��s
	 * @param args �N�����I�v�V����
	 */
	public static void main(String[] args) {
		// �������g�̃C���X�^���X��
	    JFrame frame = new MainFrame();
		// �t���[���̃Z�b�g�A�b�v
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �I��������
		//��ʂ̃T�C�Y�����肵�܂��B
		frame.setSize(new Dimension(500, 110));
		// ��ʈʒu�̐ݒ���s���܂��B
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds( (screenSize.width - frame.getWidth()) / 2,
			(screenSize.height - frame.getHeight()) /
			2, frame.getWidth(), frame.getHeight());
		// �����i���A���C�Y�j
		frame.setVisible(true);
	}

	// �R���X�g���N�^
	public MainFrame() {
		// �X�[�p�[�N���X�̃R���X�g���N�^�Ăяo��
		super(TITLE);
		
		//���O���x���̐ݒ�
		Log.setLogLevel(PropertyUtil.getProperty("log.level"));

		//���s�{�^���̍쐬
		JButton update = new JButton("�`�F�b�N���s(R)");
		update.setMnemonic('R');
		update.setActionCommand("recovery");
		update.addActionListener(this);
		
		// �I���{�^���̍쐬
		JButton cancel = new JButton("�I��(E)");
		cancel.setMnemonic('E');
		cancel.setActionCommand("cancel");
		cancel.addActionListener(this);;
	
		// �p�l���ɕ��i��ǉ�
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
		
		// �R���e���g�E�y�C���̎擾
		Container cnt = getContentPane();
		cnt.setLayout(new BorderLayout());
		// �R���e���g�E�y�C���ɕ��i��ǉ�
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
	 * �{�^���������̃C�x���g����
	 */
	public void actionPerformed(ActionEvent ae) {
		if ("recovery".equals(ae.getActionCommand())) {
			StringBuffer sb = new StringBuffer();
			
			sb.append("�S�z���ȕ��S���z�`�F�b�N�����s���܂��B");
			sb.append(lineSeparator);
			sb.append(lineSeparator);
			sb.append("�`�F�b�N�����͐����ɂ킽��ꍇ������܂��B");
			sb.append(lineSeparator);
			sb.append("�i�������ɉ�ʂ��������Ȃ��Ȃ邱�Ƃ�����܂��B�j");
			sb.append(lineSeparator);
			sb.append(lineSeparator);
			sb.append("���s���Ă���낵���ł����H");
			
            if(JOptionPane.showConfirmDialog(this, sb.toString(),TITLE,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION){
            	doCopayCheck();
            }
		} else if ("cancel".equals(ae.getActionCommand())) {
			System.exit(0);
		}
	}
	
	/**
	 * �S�z���ȕ��S�ߌ�`�F�b�N���������s����B
	 *
	 */
	private void doCopayCheck(){
		
		try{
			
			progress.setMaximum(100);
			CopayChecker task = new CopayChecker();
			
			setEnabledButtons(getContentPane().getComponents(),false);
			
			task.runTask(this);
			
			//�X�e�[�^�X�o�[�����΂�����
			progress.setValue(100);
			status.setText(" ");
            boolean isErrored = false;
			if (task.existErrorList()) {
				JOptionPane.showConfirmDialog(this,"���z�`�F�b�N���I�����܂����B" + lineSeparator + "��������z���󎚂��ꂽ�\���̂��闘�p�҂̃��X�g���쐬���܂��B",TITLE,JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
				
				try {
					//Mac�œ����Ȃ��̂͏��m�̏�
					//Runtime.getRuntime().exec("excel logs/copaycheck.txt");
					
					//�f�X�N�g�b�v�ɍ쐬�����t�@�C�����R�s�[
					String filepath = "logs/copaycheck.csv";
					String osName = "";
                    String desktop = "";
                    
                    if(System.getProperty("os.name") != null){
                        osName = System.getProperty("os.name");
                        // �啶���ɂ���
                        osName = osName.toUpperCase();
                    }
                    if("WINDOWS VISTA".equals(osName)){
                        // Vista
                        desktop = System.getProperty("user.home") + "\\Desktop\\copaycheck.csv";
                    } else {
                        // Vista�ȊO
                        desktop = System.getProperty("user.home") + "\\�f�X�N�g�b�v\\copaycheck.csv";
                    }
					
					try {
						Util.copyFile(new File(filepath), new File(desktop));
						filepath = desktop;
					} catch(Exception e){
						File f = new File(filepath);
						JOptionPane.showConfirmDialog(this,
								"���ʂ̃f�X�N�g�b�v�ւ̃R�s�[�����s���܂����B" + lineSeparator
										+ "���ʂ�" + f.getAbsolutePath()
										+ "�ɕۑ����Ă��܂��B" + lineSeparator + "���f�X�N�g�b�v�̌��ʃt�@�C�������ɊJ���Ă��Ȃ��������m�F���Ă��������B", TITLE,
								JOptionPane.CLOSED_OPTION,
								JOptionPane.INFORMATION_MESSAGE);
                        setEnabledButtons(getContentPane().getComponents(),true);
                        isErrored = true;
					}
					
					//vsb�t�@�C���쐬
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
                    // ��L�ŃG���[���������Ă���ꍇ�̓��b�Z�[�W�X�L�b�v
                    if(!isErrored){
    					JOptionPane.showConfirmDialog(this, "�f�X�N�g�b�v�Ɍ��ʂ�ۑ����܂����B"
    							+ lineSeparator + "���ʂ��m�F���Ă��������B", TITLE,
    							JOptionPane.CLOSED_OPTION,
    							JOptionPane.INFORMATION_MESSAGE);
                    }
				}
				
			} else {
				JOptionPane.showConfirmDialog(this, "�������󎚂���Ă��܂��B"
                        + lineSeparator + "�C���̕K�v�͂���܂���", TITLE,
                        JOptionPane.CLOSED_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch(Exception e){
			Log.warning("���z�`�F�b�N�G���[:" + e.getLocalizedMessage());
			JOptionPane.showConfirmDialog(this, "���z�`�F�b�N���ɃG���[���������܂����B"
					+ lineSeparator + "�����𑱍s�ł��܂���B", TITLE,
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
