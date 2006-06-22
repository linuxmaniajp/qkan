package jp.or.med.orca.qkan.component;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACCheckBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.vr.layout.VRLayout;

/** TODO <HEAD_IKENSYO> */
public class QkanDateFormatChangableTextField extends ACPanel {
    private QkanDateTextField dateText = new QkanDateTextField();
    private ACCheckBox changeFormat = new ACCheckBox();

    /**
     * コンストラクタです。
     */
    public QkanDateFormatChangableTextField() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        changeFormat.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String oldText = dateText.getText();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    dateText.setFormat(ACConstants.FORMAT_FULL_YMD);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    dateText.setFormat(ACConstants.FORMAT_FULL_ERA_YMD);
                } else {
                    return;
                }
                dateText.setText(oldText);
            }
        });
    }

    public Object createSource() {
        return dateText.createSource();
    }

    /**
     * 直接入力可能であるかを設定します。
     * 
     * @param editable 直接入力可能であるか
     */
    public void setEditable(boolean editable) {
        dateText.setEditable(editable);
        changeFormat.setEnabled(editable);
    }

    /**
     * 直接入力可能であるかを返します。
     * 
     * @return 直接入力可能であるか
     */
    public boolean isEditable() {
        return dateText.isEditable() && changeFormat.isEnabled();
    }

    /**
     * コンポーネントを初期化します。
     * 
     * @throws Exception 初期化例外
     */
    private void jbInit() throws Exception {
        this.setAutoWrap(false);
        setFollowChildEnabled(true);
        changeFormat.setText("西暦");
        dateText.setColumns(11);
        dateText.setMaxLength(11);
        dateText.setFormat(ACConstants.FORMAT_FULL_ERA_YMD);
        this.add(dateText, VRLayout.CLIENT);
        this.add(changeFormat, VRLayout.EAST);
    }

    public void requestFocus() {
        dateText.requestFocus();
    }

}
