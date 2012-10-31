package jp.or.med.orca.qkan.affair;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.core.ACAffairInfo;

/**
 * �Ɩ��N�����O�o�̓N���X�Ŏg�p����A���O���R�[�h�̃t�H�[�}�b�g�N���X
 * <p>
 * Copyright (c) 2012 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Shin Fujihara
 * @version 1.0 2012/09/18
 */
public class QkanBrowseLoggerFormatter extends Formatter {
	
	private Date dat = new Date();
	private final static String format = "yyyy/MM/dd HH:mm:ss";
	private SimpleDateFormat formatter;
	
	private static String user = System.getProperty("user.name");
	
	//���[�h�����v���O����
	@SuppressWarnings("serial")
	public static final Map<String, String> AFFAIR_MODE = Collections.unmodifiableMap( new HashMap<String, String>(){{
		put("QU001", "NEXT_AFFAIR");	//���p�҈ꗗ(���[)
		put("QP001", "NEXT_AFFAIR");	//���p�҈ꗗ(���яW�v)
		put("QS001", "PROCESS_TYPE");	//�\��E����
	}});
	
	//�l�������v���O����
	@SuppressWarnings("serial")
	public static final Set<String> AFFAIR_PERSONAL = Collections.unmodifiableSet( new HashSet<String>(){{
		add("QU002");	//���p�ҏ��ڍ�
		add("QS001");	//�T�[�r�X�\��E����
		add("QC001");	//�K��Ō�v�揑
		add("QC002");	//�K��Ō�񍐏�
		add("QC003");	//�K��Ō�̏��񋟏�
		add("QC004");	//�K��Ō�L�^��I
		add("QC005");	//����×{�Ǘ��w����
		add("QP002");	//���[�i�l���j�I���i���ъm�F�E�C���j
	}});
	
	@Override
	public synchronized String format(LogRecord record) {
		
		StringBuilder sb = new StringBuilder();
		dat.setTime(record.getMillis());
		
		if (formatter == null) {
			formatter = new SimpleDateFormat(format);
		}
		
		sb.append(formatter.format(dat));
		sb.append(" ");
		
		//�J�X�^�����b�Z�[�W��\��
		ACAffairInfo info = (ACAffairInfo)record.getParameters()[0];
		
		sb.append(user);
		sb.append(" ");
		
		String classFullName = info.getClassName();
		String className = classFullName;
		int lastIndex = classFullName.lastIndexOf('.');
		if (lastIndex != -1) {
			className = classFullName.substring(lastIndex + 1);
		}
		
		sb.append(className);
		
		//���[�h�����v���O�����̏ꍇ�́A���[�h�����O�ɏo��
		if (AFFAIR_MODE.containsKey(className)) {
			sb.append(" ");
			sb.append(info.getParameters().get( AFFAIR_MODE.get(className) ));
		}
		
		//�l�������v���O�����̏ꍇ�́Aid�����O�ɏo��
		if (AFFAIR_PERSONAL.contains(className)) {
			sb.append(" ");
			sb.append(info.getParameters().get("PATIENT_ID"));
		}
		
		sb.append(ACConstants.LINE_SEPARATOR);
		
		return sb.toString();
	}

}
