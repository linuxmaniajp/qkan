package jp.nichicom.ac.lib.care.claim.servicecode;



/**
 * 
 * �T�[�r�X�p�l���f�[�^�t�����N���X�ł��B
 * <p>
 * �T�[�r�X�F���K�͑��@�\�^������
 * </p>
 * QkanValid17311_Kyokai�ł��B
 * <p>
 * Copyright (c) 2009 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2009/03/10
 * @since version 5.4.5
 */
public class SV_17311_201804 extends AbstractQkanValidServiceDefaultGetter {
    
    // �p�l���̓�����`�F�b�N�̃o�C���h�p�X
    @Override
    protected String getHiwariBindPath() {
        return "1730103";
    }
    
    @Override
    protected boolean isValidDataCreateService(Integer changeMode) {
        /* 
         * �v��쁨�v�x���ɕω�����ꍇ�͕ϊ��ΏۂƂ���
         * 
         * �v�x�����v���̏ꍇ�͊J�n���̓��肪�K�v�ɂȂ邪
         * �J�n���̏������T�[�r�X�񋟓��ƒ�`����Ă��藚���̕ύX���Ƃ͈قȂ邽��
         * �ΏۊO�ɂ���B
         */
        if (QkanValidServiceManager.YOKAIGO_TO_YOSHIEN.equals(changeMode)) {
            return true;
        }
        return false;            
    }
}
