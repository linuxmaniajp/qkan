package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Component;
import java.text.ParseException;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

/**
 * �T�[�r�X�\��ɂ�����T�[�r�X��ވꗗ�p�̃Z�������_���ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/01/08
 */
public class QS001ServiceKindListCellRenderer extends DefaultListCellRenderer {

    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001ServiceKindListCellRenderer() {
        super();
    }

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        if(value instanceof VRMap){
            try {
                //Map(���R�[�h)���ׂĂł͂Ȃ�����������`�悷��
                value = VRBindPathParser.get("SERVICE_ABBREVIATION", (VRMap)value);
            } catch (ParseException e) {
            }
        }
        return super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
    }

}
