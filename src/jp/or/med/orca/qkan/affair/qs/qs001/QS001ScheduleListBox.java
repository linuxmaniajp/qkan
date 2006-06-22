package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ListModel;

import jp.nichicom.ac.component.dnd.event.ACDropEvent;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * �T�[�r�X�p�̃��X�g�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/01/12
 */
public class QS001ScheduleListBox extends QS001DroppableListBox {
    private int dropAllowedServiceBitMask;
    private VRMap masterService;

    private int modifiersOnMousePressed = 0;

    /**
     * Constructs a <code>JList</code> with an empty model.
     */
    public QS001ScheduleListBox() {
        super();
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified, non-<code>null</code> model. All <code>JList</code>
     * constructors delegate to this one.
     * 
     * @param dataModel the data model for this list
     * @exception IllegalArgumentException if <code>dataModel</code> is
     *                <code>null</code>
     */
    public QS001ScheduleListBox(ListModel dataModel) {
        super(dataModel);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified array. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the array of Objects to be loaded into the data model
     */
    public QS001ScheduleListBox(Object[] listData) {
        super(listData);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified <code>Vector</code>. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the <code>Vector</code> to be loaded into the data
     *            model
     */
    public QS001ScheduleListBox(Vector listData) {
        super(listData);
    }

    /**
     * �h���b�v��������T�[�r�X�̃r�b�g�t���O ��Ԃ��܂��B
     * 
     * @return �h���b�v��������T�[�r�X�̃r�b�g�t���O
     */
    public int getDropAllowedServiceBitMask() {
        return dropAllowedServiceBitMask;
    }

    /**
     * �T�[�r�X�}�X�^ ��Ԃ��܂��B
     * 
     * @return �T�[�r�X�}�X�^
     */
    public VRMap getMasterService() {
        return masterService;
    }

    /**
     * �}�E�X�_�E�����̃L�[�C���q��Ԃ��܂��B
     * 
     * @return �}�E�X�_�E�����̃L�[�C���q
     */
    public int getModifiersOnMousePressed() {
        return modifiersOnMousePressed;
    }

    /**
     * �h���b�v��������T�[�r�X�̃r�b�g�t���O ��ݒ肵�܂��B
     * 
     * @param dropAllowedServiceBitMask �h���b�v��������T�[�r�X�̃r�b�g�t���O
     */
    public void setDropAllowedServiceBitMask(int dropAllowedServiceBitMask) {
        this.dropAllowedServiceBitMask = dropAllowedServiceBitMask;
    }

    /**
     * �T�[�r�X�}�X�^ ��ݒ肵�܂��B
     * 
     * @param serviceMaster �T�[�r�X�}�X�^
     */
    public void setMasterService(VRMap serviceMaster) {
        this.masterService = serviceMaster;
    }

    protected boolean canInnerDrop(Object data) {
        // �}�b�v�ȊO�͒ǉ��������Ȃ�
        return data instanceof VRMap;
    }

    protected boolean canOuterDrop(Object data) {
        if (data instanceof VRMap) {
            try {
                if (getMasterService() == null) {
                    return false;
                }

                VRMap service = (VRMap) getMasterService().get(
                        Integer.valueOf(String.valueOf(VRBindPathParser.get(
                                "SYSTEM_SERVICE_KIND_DETAIL", (VRMap) data))));
                int flag = Integer.parseInt(String.valueOf(VRBindPathParser
                        .get("CALENDAR_PASTE_FLAG", service)));
                if ((flag & getDropAllowedServiceBitMask()) == 0) {
                    // �t���O���Y�����Ȃ��ꍇ�͒ǉ����Ȃ�
                    return false;
                }
            } catch (Exception ex) {
                // ��O�̏ꍇ�͒ǉ��֎~
                return false;
            }
            // �ǉ�������
            return true;
        }
        // �}�b�v�ȊO�͒ǉ��������Ȃ�
        return false;
    }

    /**
     * ���ʑ�����s�Ȃ��Ă��邩���`�F�b�N���ĕԂ��܂��B
     * 
     * @param data �f�[�^
     * @return �`�F�b�N���ʃf�[�^
     */
    protected VRMap checkCopyKey(ACDropEvent e, VRMap data) {
        if ((e.getDropRequestValues() != null)
                && (e.getDropRequestValues().length > 0)) {
            Object obj = e.getDropRequestValues()[0];

            if (obj instanceof QS001ScheduleListBox) {
                QS001ScheduleListBox t = (QS001ScheduleListBox) obj;
                if ((t.getModifiersOnMousePressed() & MouseEvent.SHIFT_MASK) != 0) {
                    // �[��clone
                    data = new VRHashMap(data);
                    // �R���g���[���L�[�������Ă����ꍇ�͕��ʂ��邽�߁ASERVICE_ID���ӂ�Ȃ�������
                    data.remove("SERVICE_ID");

                    // �폜������
                    t.setDragRemoveIndex(-1);
                }
            }
        }
        return data;
    }
    protected int getDropCount(ACDropEvent e, Object[] values){
        if ((e.getDropRequestValues() != null)
                && (e.getDropRequestValues().length > 0)) {
            Object obj = e.getDropRequestValues()[0];

            if (obj instanceof QS001ScheduleListBox) {
                return values.length-1; 
            }
        }
        return super.getDropCount(e, values);
    }

    protected Transferable createTransfer(Object[] values) {
        ArrayList list = new ArrayList();
        list.add(this);
        list.addAll(java.util.Arrays.asList(values));
        return new QS001ServiceTransfer(list.toArray());
    }

    protected Object filterInnerDropData(ACDropEvent e, Object data) {
        if (data instanceof VRMap) {
            return checkCopyKey(e, (VRMap) data);
        }
        return data;
    }

    protected Object filterOuterDropData(ACDropEvent e, Object data) {
        if (data instanceof VRMap) {
            try {
                VRMap row = (VRMap) data;
                Object obj = VRBindPathParser.get("SERVICE_USE_TYPE", row);
                if (QkanConstants.SERVICE_USE_TYPE_PATTERN.equals(obj)) {
                    // �p�^�[������̃h���b�v�Ɋւ��Ă̂݁A�T�[�r�XID����������

                    // �[��clone
                    row = new VRHashMap(row);
                    data = row;

                    row.remove("SERVICE_ID");
                    row.remove("SERVICE_USE_TYPE");
                } else {
                    data = checkCopyKey(e, row);
                }

            } catch (Exception ex) {

            }

        }
        return data;
    }

    protected void initComponent() {
        super.initComponent();

        //�}�E�X�������̃L�[�C���q��ޔ�
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                setModifiersOnMousePressed(e.getModifiers());
            }

            public void mouseReleased(MouseEvent e) {
                setModifiersOnMousePressed(0);
            }
        });
    }

    /**
     * �}�E�X�_�E�����̃L�[�C���q ��ݒ肵�܂��B
     * 
     * @param modifiers �}�E�X�_�E�����̃L�[�C���q
     */
    protected void setModifiersOnMousePressed(int modifiers) {
        this.modifiersOnMousePressed = modifiers;
    }
}
