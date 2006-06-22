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
 * サービス用のリストです。
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
     * ドロップを許可するサービスのビットフラグ を返します。
     * 
     * @return ドロップを許可するサービスのビットフラグ
     */
    public int getDropAllowedServiceBitMask() {
        return dropAllowedServiceBitMask;
    }

    /**
     * サービスマスタ を返します。
     * 
     * @return サービスマスタ
     */
    public VRMap getMasterService() {
        return masterService;
    }

    /**
     * マウスダウン時のキー修飾子を返します。
     * 
     * @return マウスダウン時のキー修飾子
     */
    public int getModifiersOnMousePressed() {
        return modifiersOnMousePressed;
    }

    /**
     * ドロップを許可するサービスのビットフラグ を設定します。
     * 
     * @param dropAllowedServiceBitMask ドロップを許可するサービスのビットフラグ
     */
    public void setDropAllowedServiceBitMask(int dropAllowedServiceBitMask) {
        this.dropAllowedServiceBitMask = dropAllowedServiceBitMask;
    }

    /**
     * サービスマスタ を設定します。
     * 
     * @param serviceMaster サービスマスタ
     */
    public void setMasterService(VRMap serviceMaster) {
        this.masterService = serviceMaster;
    }

    protected boolean canInnerDrop(Object data) {
        // マップ以外は追加を許さない
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
                    // フラグが該当しない場合は追加しない
                    return false;
                }
            } catch (Exception ex) {
                // 例外の場合は追加禁止
                return false;
            }
            // 追加を許可
            return true;
        }
        // マップ以外は追加を許さない
        return false;
    }

    /**
     * 複写操作を行なっているかをチェックして返します。
     * 
     * @param data データ
     * @return チェック結果データ
     */
    protected VRMap checkCopyKey(ACDropEvent e, VRMap data) {
        if ((e.getDropRequestValues() != null)
                && (e.getDropRequestValues().length > 0)) {
            Object obj = e.getDropRequestValues()[0];

            if (obj instanceof QS001ScheduleListBox) {
                QS001ScheduleListBox t = (QS001ScheduleListBox) obj;
                if ((t.getModifiersOnMousePressed() & MouseEvent.SHIFT_MASK) != 0) {
                    // 擬似clone
                    data = new VRHashMap(data);
                    // コントロールキーを押していた場合は複写するため、SERVICE_IDをふりなおさせる
                    data.remove("SERVICE_ID");

                    // 削除を解除
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
                    // パターンからのドロップに関してのみ、サービスIDを除去する

                    // 擬似clone
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

        //マウス押下時のキー修飾子を退避
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
     * マウスダウン時のキー修飾子 を設定します。
     * 
     * @param modifiers マウスダウン時のキー修飾子
     */
    protected void setModifiersOnMousePressed(int modifiers) {
        this.modifiersOnMousePressed = modifiers;
    }
}
