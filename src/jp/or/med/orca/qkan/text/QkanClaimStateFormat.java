package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

import jp.nichicom.ac.lang.ACCastUtilities;

public class QkanClaimStateFormat extends Format{
	
//	private static QkanClaimStateFormat format;
	
    private String affair = "01";
    
	private QkanClaimStateFormat(){
	}
    
    /**
     * �R���X�g���N�^
     * �����Ńv���O�����̋N�����[�h���w�肵�܂��B<br>
     * 01:���яW�v<br>
     * 02:���p�҈ꗗ�i���t�Ǘ��[�j<br>
     * 03:���p�҈ꗗ�i�ݑ�T�[�r�X�x�����Ə������j�l����񂩂��\<br>
     * 04:���p�҈ꗗ�i�ݑ�T�[�r�X�񋟎��Ə������j�l���掵<br>
     * 05:�o�ג��O�̎d�l�ύX�ɔ������g�p����<br>
     * 06:���p�҈ꗗ�i��Ð���<br>
     * 07:���p�҈ꗗ(���p�Ҍ������)<br>
     * 08:���p�҈ꗗ�i��싋�t������j<br>
     * 
     * @param affair �Ɩ����[�h���w�肷��B
     */
    public QkanClaimStateFormat(String affair){
        this.affair = affair;
    }
	
//	public static QkanClaimStateFormat getInstance(){
//		if(format == null){
//			format = new QkanClaimStateFormat();
//		}
//		return format;
//	}

	public Object parseObject(String source, ParsePosition pos) {
		if(source == null) return "";
		
		String result = "";
		
		//(null)
		if((source == null) || ("".equals(source))){
		//0:��
		} else if("��".equals(source)){
			result = "0";
		//1:���
		} else if("���".equals(source)){
			result = "1";
		//2:����
		} else if("����".equals(source)){
			result = "2";
        //4:����CSV��
        } else if("��CSV��".equals(source)){
            result = "4";
        //8:����
        } else if("����".equals(source)){
            result = "8";
        //16:��CSV��
        } else if("��CSV��".equals(source)){
            result = "16";
        //32:����
        } else if("����".equals(source)){
            result = "32";
        //64:�����(���)
        } else if("�����".equals(source)){
            result = "64";
        //128:����
        } else if("����".equals(source)){
            result = "128";
        //256:��CSV��
        } else if("����".equals(source)){
            result = "256";
        }
		
		return result;
	}

	public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
		if(obj == null) return new StringBuffer();
		
		String code = String.valueOf(obj);
		
		//(null)
		if((code == null) || ("".equals(code))){
			//��
		//0:��
		} else if("0".equals(code)){
            if("01".equals(affair)){
                toAppendTo.append("��");
            }
		//1:���
		} else if("1".equals(code)){
			//toAppendTo.append("���");
            toAppendTo.append("���");
            
        } else {
            if("01".equals(affair)){
                toAppendTo.append("��");
            } else {
                int printed = ACCastUtilities.toInt(getPrintedCode(affair), 0);
                int csvOuted =  ACCastUtilities.toInt(getCSVOutCode(affair), 0);
                int printCode = ACCastUtilities.toInt(code,0);
                
                String appendStr = null;
                if((printCode & printed) > 0){
                    appendStr = "��";
                }
                if((printCode & csvOuted) > 0){
                    appendStr = "CSV";
                }
                if(appendStr != null){
                    toAppendTo.append(appendStr);
                }
            }

        }
		//2:����
//		} else if("2".equals(code)){
//			//toAppendTo.append("����");
//            toAppendTo.append("��");
//        //4:����CSV��
//		} else if("4".equals(code)){
//            toAppendTo.append("CSV");
//        //8:����
//        } else if("8".equals(code)){
//            //toAppendTo.append("����");
//            toAppendTo.append("��");
//        //16:��CSV��
//        } else if("16".equals(code)){
//            toAppendTo.append("CSV");
//        //32:����
//        } else if("32".equals(code)){
//            //toAppendTo.append("����");
//            toAppendTo.append("��");
//        //64:�����(���)
//        } else if("64".equals(code)){
//            //toAppendTo.append("�����");
//            toAppendTo.append("��");
//        //128:����
//        } else if("128".equals(code)){
//            //toAppendTo.append("����");
//            toAppendTo.append("��");
//        //256:��CSV��
//        } else if("256".equals(code)){
//            toAppendTo.append("CSV");
//        }
		
		return toAppendTo;
	}
    
    public static String getPrintedCode(String affair,Object presentCode) {
        int addition = 0;
        int code = 0;
        
        String codeTemp = getPrintedCode(affair);
        
        if((codeTemp != null) && (codeTemp.length() > 0)){
            try{
                code = Integer.parseInt(codeTemp);
            } catch(Exception e){}
        }
        
        //���݂̈���i���t���O���擾
        if((presentCode != null) && (String.valueOf(presentCode).length() > 0)){
            try{
                addition = Integer.parseInt(String.valueOf(presentCode));
            } catch(Exception e){}
        }
        
        return String.valueOf(code | addition);
    }
    
    /**
     * ������s��ɍX�V����R�[�h���擾����B
     * @param affair �v���O�����̋N�����[�h
     * @param presentCode ���݂̈���i���t���O
     * @return
     */
    public static String getPrintedCode(String affair) {
        if((affair == null) || (affair.length() == 0)){
            return "";
        }
        
        String code = "";
        
        //���яW�v
        if("01".equals(affair)){
            code = "0";
        //���p�҈ꗗ�i���t�Ǘ��[�j
        } else if("02".equals(affair)){
            code = "8";
        //���p�҈ꗗ�i�ݑ�T�[�r�X�x�����Ə������j�l����񂩂��\
        } else if("03".equals(affair)){
            code = "2";
        //���p�҈ꗗ�i�ݑ�T�[�r�X�񋟎��Ə������j�l���掵
        } else if("04".equals(affair)){
            code = "2";
        //�o�ג��O�̎d�l�ύX�ɔ������g�p����
        } else if("05".equals(affair)){
            code = "";
        //���p�҈ꗗ�i��Ð���
        } else if("06".equals(affair)){
            code = "64";
        //���p�҈ꗗ(���p�Ҍ������)
        } else if("07".equals(affair)){
            code = "32";
        //���p�҈ꗗ�i��싋�t������j
        } else if("08".equals(affair)){
            code = "128";
        }
        
        return String.valueOf(code);
    }
    
    public static String getCSVOutCode(String affair,Object presentCode) {
        int addition = 0;
        int code = 0;
        
        String codeTemp = getCSVOutCode(affair);
        
        if((codeTemp != null) && (codeTemp.length() > 0)){
            try{
                code = Integer.parseInt(codeTemp);
            } catch(Exception e){}
        }
        
        //���݂̈���i���t���O���擾
        if((presentCode != null) && (String.valueOf(presentCode).length() > 0)){
            try{
                addition = Integer.parseInt(String.valueOf(presentCode));
            } catch(Exception e){}
        }
        
        return String.valueOf(code | addition);
    }
    
    
    /**
     * CSV�o�͎��s��ɍX�V����R�[�h���擾����B
     * @param affair �v���O�����̋N�����[�h
     * @param presentCode ���݂̈���i���t���O
     * @return
     */
    public static String getCSVOutCode(String affair) {
        if((affair == null) || (affair.length() == 0)){
            return "";
        }
        
        String code = "";
        
        //���яW�v
        if("01".equals(affair)){
            code = "";
        //���p�҈ꗗ�i���t�Ǘ��[�j
        } else if("02".equals(affair)){
            code = "16";
        //���p�҈ꗗ�i�ݑ�T�[�r�X�x�����Ə������j�l����񂩂��\
        } else if("03".equals(affair)){
            code = "4";
        //���p�҈ꗗ�i�ݑ�T�[�r�X�񋟎��Ə������j�l���掵
        } else if("04".equals(affair)){
            code = "4";
        //�o�ג��O�̎d�l�ύX�ɔ������g�p����
        } else if("05".equals(affair)){
            code = "";
        //���p�҈ꗗ�i��Ð���
        } else if("06".equals(affair)){
            code = "";
        //���p�҈ꗗ(���p�Ҍ������)
        } else if("07".equals(affair)){
            code = "";
        //���p�҈ꗗ�i��싋�t������j
        } else if("08".equals(affair)){
            code = "256";
        }
        
        return String.valueOf(code);
        
    }

}
