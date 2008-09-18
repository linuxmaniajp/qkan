package jp.nichicom.copaychecker.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * ���[�e�B���e�B�N���X
 * @version 1.00 4 August
 * @author shin fujihara
 */
public class Util {

	public static boolean isNull(String str){
		return (str == null) || ("".equals(trim(str)));
	}
	/**
	 * ������O��̋󔒁A���s����菜��
	 * @param str �Ώۃf�[�^
	 * @return ������̕�����
	 */
	public static String trim(String str){
		if(str == null) return "";
		
		char[] temp = str.toCharArray();
		int start = -1;
		int end = -1;
		//�󔒂Ƃ݂Ȃ�����
		String comp = " " + "�@" + "\n";
		
		for(int i = 0; i < temp.length; i++){
			if(comp.indexOf(temp[i]) == -1){
				start = i;
				break;
			}
		}
		//�S�ċ�
		if(start == -1) return "";
		
		for(int i = temp.length - 1; i >= 0; i--){
			if(comp.indexOf(temp[i]) == -1){
				end = i;
				break;
			}
		}
		return str.substring(start,end + 1);
	}
	/**
	 * �w�肳�ꂽ�p�X�̃f�B���N�g�����쐬����B
	 * @param fileName �t�@�C���p�X
	 */
	public static void makeDir(String fileName){
		if(isNull(fileName)){
			return;
		}
	    File file = new File(fileName);
	    //�t�H���_������΁A�쐬����
	    if(file.getParent() != null){
	    	File dir = new File(file.getParent());
	    	if(!dir.exists()){
		    	dir.mkdirs();
	    	}
	    }
	}
	
	/**
	 * �������Ɋ܂܂�鐔����S�p�ɕϊ�����B
	 * @param value
	 * @return
	 */
	public static String toWideNumber(String value){
		if (value == null){
			return null;
		}
		
		char[] ary = value.toCharArray();
		StringBuffer rst = new StringBuffer();
		
		for(int i = 0; i < ary.length; i++){
			
			switch(ary[i]){
			case '0':
				rst.append('�O');
				break;
			case '1':
				rst.append('�P');
				break;
			case '2':
				rst.append('�Q');
				break;
			case '3':
				rst.append('�R');
				break;
			case '4':
				rst.append('�S');
				break;
			case '5':
				rst.append('�T');
				break;
			case '6':
				rst.append('�U');
				break;
			case '7':
				rst.append('�V');
				break;
			case '8':
				rst.append('�W');
				break;
			case '9':
				rst.append('�X');
				break;
			default:
				rst.append(ary[i]);
				break;
			}
			
		}
		return rst.toString();
		
	}
	
	/**
	 * ���l�ϊ��@�ϊ��ł��Ȃ��ꍇ��0��ԋp
	 * @param value
	 * @return
	 */
	public static int toInt(Object value) {
		int result = 0;
		
		try {
			result = Integer.parseInt(value.toString());
		} catch(Exception e){}
		
		return result;
	}
	
	/**
	 * �t�@�C���̃R�s�[���s��
	 * @param in
	 * @param out
	 * @throws Exception
	 */
    public static void copyFile(File in, File out) throws Exception {
        FileChannel sourceChannel = new
            FileInputStream(in).getChannel();
        FileChannel destinationChannel = new
            FileOutputStream(out).getChannel();
        sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
        sourceChannel.close();
        destinationChannel.close();
    }
    
    public static String toStr(Object obj) {
        if (obj == null) return "";
        
        return obj.toString();
    }

}
