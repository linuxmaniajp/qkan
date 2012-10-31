package jp.nichicom.ac.lib.care.claim.servicecode;



/**
 * 
 * �T�[�r�X�p�l���f�[�^�t�����N���X�ł��B
 * <p>
 * �T�[�r�X�F���\�h���K�͑��@�\�^������
 * </p>
 * QkanValid17511_YobouKyokai�ł��B
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2008/01/11
 * @since version 5.4.1
 */
public class SV_17511_201204 extends AbstractQkanValidServiceDefaultGetter {
    
    // �p�l���̓�����`�F�b�N�̃o�C���h�p�X
    @Override
    protected String getHiwariBindPath() {
        return "1750103";
    }
    
    @Override
    protected boolean isValidDataCreateService(Integer changeMode) {
        /* 
         * �v�x�����v���ɕω�����ꍇ�͕ϊ��ΏۂƂ���
         * 
         * �v��쁨�v�x���̏ꍇ�͊J�n���̓��肪�K�v�ɂȂ邪
         * �J�n���̏������T�[�r�X�񋟓��ƒ�`����Ă��藚���̕ύX���Ƃ͈قȂ邽��
         * �ΏۊO�ɂ���B
         */
        if(QkanValidServiceManager.YOSHIEN_TO_YOKAIGO.equals(changeMode)){
            return true;
        }
        return false;
    }
}
