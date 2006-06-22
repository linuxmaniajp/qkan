package jp.or.med.orca.qkan.affair.qs.qs001;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.ListModel;

import jp.nichicom.ac.component.ACMutableListBox;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.bind.VRBindSource;
import jp.nichicom.vr.bind.event.VRBindEvent;

/**
 * �o�C���h�ɂ���ă��f�������������郊�X�g�{�b�N�X�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public class QS001BindModelValueListBox extends ACMutableListBox {
    private String[] bindPathes;

    /**
     * Constructs a <code>JList</code> with an empty model.
     */
    public QS001BindModelValueListBox() {
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
    public QS001BindModelValueListBox(ListModel dataModel) {
        super(dataModel);
    }

    /**
     * Constructs a <code>JList</code> that displays the elements in the
     * specified array. This constructor just delegates to the
     * <code>ListModel</code> constructor.
     * 
     * @param listData the array of Objects to be loaded into the data model
     */
    public QS001BindModelValueListBox(Object[] listData) {
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
    public QS001BindModelValueListBox(Vector listData) {
        super(listData);
    }

    public void applySource() throws ParseException {

        VRBindSource source = getSource();
        if (source != null) {
            // �ݒ��\�[�X��null�łȂ��ꍇ
            String[] pathes = getBindPathes();
            if (pathes != null) {
                // �p�X��null�łȂ��ꍇ
                ListModel mdl = getModel();
                if (mdl != null) {
                    // ���f����null�łȂ��ꍇ
                    Map result = new HashMap();
                    Map blanks = new HashMap();
                    int end = Math.min(mdl.getSize(), pathes.length);
                    // ���f���̒l�����Ƀp�X�Ɗ֘A�t����
                    for (int i = 0; i < end; i++) {
                        Object data = mdl.getElementAt(i);
                        if(data!=null){
                            result.put(pathes[i], data);
                            if(!blanks.isEmpty()){
                                //�f�[�^���������ꍇ�͂����܂ł�null�f�[�^���ǉ�
                                result.putAll(blanks);
                                blanks = new HashMap();
                            }
                        }else{
                            //�f�[�^���Ȃ��ꍇ��null�p�}�b�v�Ɋi�[
                            blanks.put(pathes[i], data);
                        }
                    }

                    if (!result.isEmpty()) {
                        // 1���ȏ㒊�o������
                        if (source instanceof Map) {
                            // �ݒ�悪Map�Ȃ�ꊇ�]�L
                            ((Map) source).putAll(result);
                        } else if (source instanceof List) {
                            // �ݒ�悪List�Ȃ璀���ǉ�
                            Iterator it = result.entrySet().iterator();
                            while (it.hasNext()) {
                                source.addData(it.next());
                            }
                        } else {
                            // �ݒ�悪�s���Ȃ璀���ݒ�
                            Iterator it = result.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry ent = (Map.Entry) it.next();
                                source.setData(ent.getKey(), ent.getValue());
                            }
                        }
                        // �C�x���g���s
                        fireApplySource(new VRBindEvent(this));
                    }

                }
            }
        }
    }

    public void bindSource() throws ParseException {

        String[] pathes = getBindPathes();
        if (pathes != null) {
            List result = new ArrayList();
            int end = pathes.length;
            int lastFind = -1;
            for (int i = 0; i < end; i++) {
                if (VRBindPathParser.has(pathes[i], getSource())) {
                    Object data = VRBindPathParser.get(pathes[i], getSource());
                    result.add(data);
                    lastFind = i;
                } else {
                    // �p�X���Y�����Ȃ��s��null�Œǉ�
                    result.add(null);
                }
            }

            if(lastFind<result.size()-1){
                //�����̋�f�[�^�͏���
                result = result.subList(0, lastFind + 1);
            }
            // ��ʃN���X��bind�𗘗p
            if (bindModelSourceImpl(result)) {
                fireBindSource(new VRBindEvent(this));
            }

        }

    }

    public String getBindPath() {
        String[] pathes = getBindPathes();
        if ((pathes != null) && (pathes.length > 0)) {
            return pathes[0];
        }
        return null;
    }

    /**
     * �o�C���h�Ώۂ̃L�[�W����Ԃ��܂��B
     * 
     * @return �o�C���h�Ώۂ̃L�[�W��
     */
    public String[] getBindPathes() {
        return bindPathes;
    }

    public void setBindPath(String bindPath) {
        setBindPathes(new String[] { bindPath });
    }

    /**
     * �o�C���h�Ώۂ̃L�[�W����ݒ肵�܂��B
     * 
     * @param bindPathes �o�C���h�Ώۂ̃L�[�W��
     */
    public void setBindPathes(List bindPathes) {
        if (bindPathes != null) {
            setBindPathes(bindPathes.toArray());
        }
    }

    /**
     * �o�C���h�Ώۂ̃L�[�W����ݒ肵�܂��B
     * 
     * @param bindPathes �o�C���h�Ώۂ̃L�[�W��
     */
    public void setBindPathes(Object[] bindPathes) {
        if (bindPathes != null) {
            setBindPathes((String[]) toStringArray(bindPathes));
        }
    }

    /**
     * �o�C���h�Ώۂ̃L�[�W����ݒ肵�܂��B
     * 
     * @param bindPathes �o�C���h�Ώۂ̃L�[�W��
     */
    public void setBindPathes(Set bindPathes) {
        if (bindPathes != null) {
            setBindPathes(bindPathes.toArray());
        }
    }

    /**
     * �o�C���h�Ώۂ̃L�[�W����ݒ肵�܂��B
     * 
     * @param bindPathes �o�C���h�Ώۂ̃L�[�W��
     */
    public void setBindPathes(String[] bindPathes) {
        this.bindPathes = bindPathes;
    }

    /**
     * ������z��ɕϊ����܂��B
     * 
     * @param array �z��
     * @return ������z��
     */
    protected String[] toStringArray(Object[] array) {
        if (!(array instanceof String[])) {
            int len = array.length;
            String[] newArray = new String[len];
            for (int i = 0; i < len; i++) {
                newArray[i] = String.valueOf(array[i]);
            }
            array = newArray;
        }
        return (String[]) array;
    }

}
