package jp.or.med.orca.qkan.affair.qp.qp004;

import jp.nichicom.ac.text.ACCharacterConverter;

//[ID:0000551][Tozo TANAKA] 2009/08 add begin 
public class QP004WideCommaCharacterConverter extends ACCharacterConverter {
    /**
     * �����ϊ����ʂ�Ԃ��܂��B
     * @param src �ϊ���
     * @param toCharacter �ϊ����ʂ̕������
     * @param fromCharacter �ϊ��Ώۂ̕������
     * @return �����ϊ�����
     */
    public String format(String src, int toCharacter, int fromCharacter) {
        //���p","��S�p"�A"�ɒu��������ŁA��ʃN���X�őS�p�ɕϊ�����B
        return super.format(src.replaceAll(",", "�A"), toCharacter, fromCharacter);
    }

    /**
     * �R���X�g���N�^�ł��B
     */
    public QP004WideCommaCharacterConverter() {
        super();
    }

    /**
     * �R���X�g���N�^�ł��B
     * @param toCharacter
     * @param fromCharacter
     */
    public QP004WideCommaCharacterConverter(int toCharacter, int fromCharacter) {
        super(toCharacter, fromCharacter);
    }

    /**
     * �R���X�g���N�^�ł��B
     * @param toCharacter
     */
    public QP004WideCommaCharacterConverter(int toCharacter) {
        super(toCharacter);
    }

}
//[ID:0000551][Tozo TANAKA] 2009/08 add end
