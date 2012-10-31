package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.List;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * 
 * AbstractQkanValidServiceDefaultGetter�ł��B
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko Higuchi
 * @version 1.0 2007/12/19
 * @since version 5.4.1
 */
public abstract class AbstractQkanValidServiceDefaultGetter extends AbstractQkanValidServiceGetter {
    
    private VRMap panelData = null;
    
    // �p�l���ɓ�����`�F�b�N�����Ă��邩�`�F�b�N
    @Override
    protected boolean checkDeleteService(VRMap service) throws Exception {
        
        // �J�����_�[�̍ŏ��ɒu���ꂽ�f�[�^�ł���Αޔ�
        if (panelData == null) {
            
            panelData = createBaseMap(service, getHiwariBindPath(), getOfferBindPath());
            
            // �f�[�^���擾�ł��Ȃ������ꍇ�́A�F����ԊO�̃f�[�^
            if (panelData == null) {
                return false;
            }
        }
        
        // �p�l���Ŋ��ɓ�����̃`�F�b�N�����Ă�����A�f�ނ̗ǂ��𐶂���
        if (ACCastUtilities.toInt(service.get(getHiwariBindPath()), 1) > 1) {
            // �R�s�[�Ώۂ̓��t����폜
            deleteHistory(panelData, service);
            // ���X�g����f�[�^���폜���Ȃ�
            return false;
        }
        
        
        // �������������Ă�����Ă���̂ŁA�񋟓��Ƃ��Đ�����
        addOffer(panelData, service);
        
        // ������Ȃ��Œu���Ă���ꍇ�́A���X�g����폜
        return true;
    }
    
    // ����������W�J�f�[�^�쐬
    @Override
    protected List<VRMap> getProRatedList() throws Exception {
        return createProRatedList(panelData);
    }
    
    // �p�l���̒񋟓��`�F�b�N�̃o�C���h�p�X
    protected String getOfferBindPath() {
        return "15";
    }
    
    abstract protected String getHiwariBindPath();
    
}
