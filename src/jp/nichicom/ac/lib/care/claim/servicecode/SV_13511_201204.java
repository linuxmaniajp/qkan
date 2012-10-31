package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRMap;

/**
 * 
 * �T�[�r�X�p�l���f�[�^�t�����N���X�ł��B
 * <p>
 * �T�[�r�X�F���\�h����{�ݓ����Ґ������
 * </p>
 * QkanValid13511_YobouTokutei�ł��B
 * <p>
 * Copyright (c) 2007 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Masahiko.Higuchi
 * @version 1.0 2008/01/11
 * @since version 5.4.1
 */
public class SV_13511_201204 extends AbstractQkanValidServiceGetter {
    
    // �K����(1)�A�ʏ����(5)�A�ʏ����n(6)
    private Map<String, VRMap> panelDatas = new HashMap<String, VRMap>();


    // �p�l���ɓ�����`�F�b�N�����Ă��邩�`�F�b�N
    protected boolean checkDeleteService(VRMap service) throws Exception {
        
        // �O���T�[�r�X���p�^���I������Ă��Ȃ��ꍇ�͏����I��
        if (ACCastUtilities.toInt(service.get("1350101"), 0) != 2) {
            return false;
        }
        
        
        String hiwariBindPath = "";
        String offerBindPath = "";
        String _1350104 = ACCastUtilities.toString(service.get("1350104"), "");
        
        // ������̂���O���T�[�r�X��񋟂��Ă��邩�`�F�b�N
        switch (ACCastUtilities.toInt(_1350104, 0)) {
        case 1: // �K����(�����F1350106�A�񋟓��F1350129)
            hiwariBindPath = "1350106";
            offerBindPath = "1350129";
            break;
            
        case 5: // �ʏ����(�����F1350111�A�񋟓��F1350130)
            hiwariBindPath = "1350111";
            offerBindPath = "1350130";
            break;
            
        case 6: // �ʏ����n(�����F1350115�A�񋟓��F1350131)
            hiwariBindPath = "1350115";
            offerBindPath = "1350131";
            break;
            
        default:
            return false;
        }
        
        VRMap panelData = null;
        if (panelDatas.containsKey(_1350104)) {
            panelData = panelDatas.get(_1350104);
            
        } else {
            panelData = createBaseMap(service, hiwariBindPath, offerBindPath);
            // �F����ԊO�ɒu���ꂽ�T�[�r�X�ł���Ε��u
            if (panelData == null) {
                return false;
            }
            panelDatas.put(_1350104, panelData);
        }
        
        
        //���H��������邽�߁A�{�ݒ񋟃p�^�[�����珜�O
        deleteFacilityOffer(service);
        
        // �p�l���Ŋ��ɓ�����̃`�F�b�N�����Ă�����A�f�ނ̗ǂ��𐶂���
        if (ACCastUtilities.toInt(service.get(hiwariBindPath), 1) > 1) {
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
    protected List<VRMap> getProRatedList() throws Exception {
        List<VRMap> list = new ArrayList<VRMap>();
        
        for (Entry<String, VRMap> entry : panelDatas.entrySet()) {
            list.addAll(createProRatedList(entry.getValue()));
        }
        
        return list;
    }
    

}
