package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * �T�[�r�X��ރR�[�h��n���ꂽ�ꍇ�A�R�[�h���疼�̂ɕϊ�����t�H�[�}�b�g�ł��B<br>
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanServiceKindNameFormat extends Format {
    private static QkanServiceKindNameFormat singleton;
    private VRMap masterService;
// 2016/7/15 [Yoichiro Kamei] add - begin �������ƑΉ�
    private boolean initialized = false;
    private VRMap serviceMap = new VRHashMap();
// 2016/7/15 [Yoichiro Kamei] add - end
    
    /**
     * �T�[�r�X�}�X�^ ��Ԃ��܂��B
     * 
     * @return �T�[�r�X�}�X�^
     */
    public VRMap getMasterService() {
        return masterService;
    }

    /**
     * �T�[�r�X�}�X�^ ��ݒ肵�܂��B
     * 
     * @param serviceMaster �T�[�r�X�}�X�^
     */
    public void setMasterService(VRMap serviceMaster) {
        this.masterService = serviceMaster;
// 2016/7/15 [Yoichiro Kamei] add - begin �������ƑΉ�
        this.initialized = false;
// 2016/7/15 [Yoichiro Kamei] add - end
    }

    /**
     * �R���X�g���N�^�ł��B
     */
    protected QkanServiceKindNameFormat() {
        super();
    }

    /**
     * �C���X�^���X��Ԃ��܂��B
     * 
     * @return �C���X�^���X
     */
    public static QkanServiceKindNameFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanServiceKindNameFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {
// 2016/7/15 [Yoichiro Kamei] mod - begin �������ƑΉ�
//        if (obj != null) {
//            if (getMasterService() != null) {
//                int val = ACCastUtilities.toInt(obj, 0) - 1000;
//                if (val > 0) {
//                    Iterator it = getMasterService().values().iterator();
//                    while (it.hasNext()) {
//                        Map row = (Map) it.next();
//                        if (ACCastUtilities.toInt(row.get("SERVICE_CODE_KIND"),
//                                0) == val) {
//                            // �T�[�r�X�̗��̖��ɒu��
//                            obj = row.get("SERVICE_KIND_NAME");
//                            if (obj != null) {
//                                toAppendTo.append(obj);
//                                break;
//                            }
//                        }
//                    }
//
//                }
//            }
//        }
        if (obj == null) {
            return toAppendTo;
        }
        
        //�T�[�r�X��ރR�[�h����T�[�r�X�}�X�^���������߂̃}�b�v���쐬
        cleateServiceMap();
        
        
        int path = ACCastUtilities.toInt(obj, 0);
        String kind = "";
        switch (path) {
        // �������� �v��P�ʐ��̃o�C���h�p�X����T�[�r�X��ރR�[�h�ɕϊ�
        case 1101:
            kind = "A1";
            break;
        case 1105:
            kind = "A5";
            break;
        default:
        // �������ƈȊO�́A�v��P�ʐ��̃o�C���h�p�X - 1000�̌��ʂ��T�[�r�X��ރR�[�h�ƂȂ�
            int val = ACCastUtilities.toInt(obj, 0) - 1000;
            if (val > 0) {
                kind = String.valueOf(val);
            }
        }
        toAppendTo.append(getServiceName(kind));
// 2016/7/15 [Yoichiro Kamei] mod - end
        return toAppendTo;
    }

    
// 2016/7/15 [Yoichiro Kamei] add - begin �������ƑΉ�
    private synchronized void cleateServiceMap() {
        if (initialized) {
            //���ɂ��̃}�b�v���쐬����Ă�����Ȃɂ����Ȃ�
            return;
        }
        if (masterService != null) {
            serviceMap.clear();
            Iterator it = masterService.values().iterator();
            while (it.hasNext()) {
                Map row = (Map) it.next();
                String kind = String.valueOf(row.get("SERVICE_CODE_KIND"));
                serviceMap.put(kind, row);
            }
        }
        initialized = true;
    }
    //�T�[�r�X��ރR�[�h���疼�̂��擾
    private String getServiceName(String serviceKind) {
        String result = "";
        Map row = (Map) this.serviceMap.get(serviceKind);
        if (row != null) {
            result = ACCastUtilities.toString(row.get("SERVICE_KIND_NAME"), "");
        }
        return result;
    }
// 2016/7/15 [Yoichiro Kamei] add - end
    
    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        return result;
    }

}
