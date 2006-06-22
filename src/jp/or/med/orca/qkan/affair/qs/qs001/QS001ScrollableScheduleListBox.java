package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.Component;
import java.awt.dnd.DragGestureEvent;
import java.util.Vector;

import javax.swing.ListModel;

import jp.nichicom.ac.component.ACListBox;
import jp.nichicom.ac.component.dnd.ACDroppable;
import jp.nichicom.ac.component.dnd.ACDroppableListBox;
import jp.nichicom.ac.component.dnd.event.ACDroppableListener;
import jp.nichicom.vr.component.AbstractVRListBox;
import jp.nichicom.vr.util.VRMap;

/**
 * �X�N���[���y�C����̌^��<code>QS001ScheduleListBox</code>�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 * @see ACListBox
 * @see QS001ScheduleListBox
 */
public class QS001ScrollableScheduleListBox extends ACListBox implements ACDroppable {

    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001ScrollableScheduleListBox() {
        super();
    }

    /**
     * Creates a <code>JScrollPane</code> that displays the contents of the
     * specified component, where both horizontal and vertical scrollbars appear
     * whenever the component's contents are larger than the view.
     * 
     * @see #setViewportView
     * @param view the component to display in the scrollpane's viewport
     */
    public QS001ScrollableScheduleListBox(Component view) {
        super(view);
    }

    /**
     * Creates a <code>JScrollPane</code> that displays the view component in
     * a viewport whose view position can be controlled with a pair of
     * scrollbars. The scrollbar policies specify when the scrollbars are
     * displayed, For example, if <code>vsbPolicy</code> is
     * <code>VERTICAL_SCROLLBAR_AS_NEEDED</code> then the vertical scrollbar
     * only appears if the view doesn't fit vertically. The available policy
     * settings are listed at {@link #setVerticalScrollBarPolicy} and
     * {@link #setHorizontalScrollBarPolicy}.
     * 
     * @see #setViewportView
     * @param view the component to display in the scrollpanes viewport
     * @param vsbPolicy an integer that specifies the vertical scrollbar policy
     * @param hsbPolicy an integer that specifies the horizontal scrollbar
     *            policy
     */
    public QS001ScrollableScheduleListBox(Component view, int vsbPolicy,
            int hsbPolicy) {
        super(view, vsbPolicy, hsbPolicy);
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
    public QS001ScrollableScheduleListBox(ListModel dataModel) {
        super(dataModel);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified array. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the array of Objects to be loaded into the data model
     */
    public QS001ScrollableScheduleListBox(Object[] listData) {
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
    public QS001ScrollableScheduleListBox(Vector listData) {
        super(listData);
    }

    public void addDroppableListener(ACDroppableListener l) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).addDroppableListener(l);
        }
    }

    /**
     * �v�f��ǉ����܂��B
     * 
     * @param data �v�f
     */
    public void addElement(Object data) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).addElement(data);
        }
    }

    /**
     * �h���b�O�J�n���_�̃C�x���g ��Ԃ��܂��B
     * 
     * @return �h���b�O�J�n���_�̃C�x���g
     */
    public DragGestureEvent getBeginDragEvent() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            return ((ACDroppableListBox) list).getBeginDragEvent();
        }
        return null;
    }

    /**
     * �h���b�v��������T�[�r�X�̃r�b�g�t���O ��Ԃ��܂��B
     * 
     * @return �h���b�v��������T�[�r�X�̃r�b�g�t���O
     */
    public int getDropAllowedServiceBitMask() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof QS001ScheduleListBox) {
            return ((QS001ScheduleListBox) list).getDropAllowedServiceBitMask();
        }
        return 0;
    }

    /**
     * �v�f��Ԃ��܂��B
     * 
     * @param index �s�ԍ�
     * @return data �v�f
     */
    public Object getElement(int index) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).getElement(index);
        }
        return null;
    }

    /**
     * �T�[�r�X�}�X�^ ��Ԃ��܂��B
     * 
     * @return �T�[�r�X�}�X�^
     */
    public VRMap getMasterService() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof QS001ScheduleListBox) {
           return  ((QS001ScheduleListBox) list).getMasterService();
        }
        return null;
    }

    /**
     * �v�f��}�����܂��B
     * 
     * @param data �v�f
     * @param index �}���ʒu
     */
    public void insertElementAt(Object data, int index) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).addElement(data);
        }
    }

    /**
     * D&D�ɂ��ړ� ���s�Ȃ����Ԃ��܂��B
     * 
     * @return D&D�ɂ��ړ����s�Ȃ�
     */
    public boolean isMoveMode() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            return ((ACDroppableListBox) list).isMoveMode();
        }
        return false;
    }

    /**
     * D&D�ɂ��\��t�����󂯓���邩 ��Ԃ��܂��B
     * 
     * @return D&D�ɂ��\��t�����󂯓���邩
     */
    public boolean isRecieveMode() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            return ((ACDroppableListBox) list).isRecieveMode();
        }
        return false;
    }

    /**
     * �v�f�����ׂč폜���܂��B
     */
    public void removeAllElement() {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).removeAllElement();
        }
    }

    public void removeDroppableListener(ACDroppableListener l) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).removeDroppableListener(l);
        }         
    }

    /**
     * �v�f���폜���܂��B
     * 
     * @param index �폜�ʒu
     */
    public void removeElementAt(int index) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).removeElementAt(index);
        }
    }
    /**
     * �h���b�O�J�n���_�̃C�x���g ��ݒ肵�܂��B
     * 
     * @param dragModifiers �h���b�O�J�n���_�̃C�x���g
     */
    public void setBeginDragEvent(DragGestureEvent beginDragEvent) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).setBeginDragEvent(beginDragEvent);
        }
    }

    /**
     * �h���b�v��������T�[�r�X�̃r�b�g�t���O ��ݒ肵�܂��B
     * 
     * @param dropAllowedServiceBitMask �h���b�v��������T�[�r�X�̃r�b�g�t���O
     */
    public void setDropAllowedServiceBitMask(int dropAllowedServiceBitMask) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof QS001ScheduleListBox) {
            ((QS001ScheduleListBox) list)
                    .setDropAllowedServiceBitMask(dropAllowedServiceBitMask);
        }
    }

    /**
     * �T�[�r�X�}�X�^ ��ݒ肵�܂��B
     * 
     * @param serviceMaster �T�[�r�X�}�X�^
     */
    public void setMasterService(VRMap serviceMaster) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof QS001ScheduleListBox) {
            ((QS001ScheduleListBox) list).setMasterService(serviceMaster);
        }
    }

    /**
     * D&D�ɂ��ړ� ���s�Ȃ� ��ݒ肵�܂��B
     * 
     * @param moveMode D&D�ɂ��ړ����s�Ȃ�
     */
    public void setMoveMode(boolean moveMode) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).setMoveMode(moveMode);
        }
    }

    /**
     * D&D�ɂ��\��t�����󂯓���邩 ��ݒ肵�܂��B
     * 
     * @param recieveMode D&D�ɂ��\��t�����󂯓���邩
     */
    public void setRecieveMode(boolean recieveMode) {
        AbstractVRListBox list = getMainContent();
        if (list instanceof ACDroppableListBox) {
            ((ACDroppableListBox) list).setRecieveMode(recieveMode);
        }
    }

    protected AbstractVRListBox createMainContent() {
        return new QS001ScheduleListBox();
    }
}
