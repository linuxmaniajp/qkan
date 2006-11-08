
/*
 * Project code name "ORCA"
 * ���t�Ǘ��䒠�\�t�g QKANCHO�iJMA care benefit management software�j
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * �A�v��: QKANCHO
 * �J����: ����@��F
 * �쐬��: 2006/05/07  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z�������×{��� (QS001142)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;

/**
 * �T�[�r�X�p�^�[�����\�h�Z�������×{���(QS001142) 
 */
public class QS001142 extends QS001142Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001142(){
  }

  //�R���|�[�l���g�C�x���g

  /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayStandardRecuperationDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getShortStayStandardRecuperationDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H��𖳌��ɂ���B
            checkDinnerState();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            checkDinnerState();

            // �H����p(shortStayStandardRecuperationDinnerCost)��ݒ肷��B
            checkMeatCost();
        }

    }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001142.class.getName(), param));
  }

  //�����֐�

  /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // ���ݒ�
        // ���H����
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F191�i�H���񋟁j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1260405 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1260405", QkanCommon.getArrayFromMasterCode(191,
                "1260405"));
        // ���W�J
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();
        // ���I�����ڂ̏����ݒ�
        // ������
        // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
        VRMap defaultMap = new VRHashMap();
        // ���ݒ�
        // ��ʂ̃��W�I�̏����l��ݒ肷��B�iselectFirstRadioItem�j
        QkanCommon.selectFirstRadioItem(getThis());
        // �H���񋟂��u�Ȃ��v�ɂ���B
        VRBindPathParser.set("1260405", defaultMap, new Integer(1));
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �����I�����ڂ�W�J����B
        getThis().bindSource();

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            // �I�����Ə����null�łȂ��ꍇ
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
            // ������
            // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
            VRMap defaultMap = new VRHashMap();
            // ���ݒ�
            // �����Ə��A��
            // ���}�̐��i���Ə��p�l���jKEY�F1260401�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260401",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ή��s�j�������ꍇ
                // defaultMap�� KEY�F6 VALUE�F1�i���}�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("6", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i�Ή��j�������ꍇ
                // defaultMap�� KEY�F6 VALUE�F3�i���}�����j��ݒ肷��B
                VRBindPathParser.set("6", defaultMap, new Integer(3));
                break;
            }
            // �h�{�Ǘ��̕]���i���Ə��p�l���jKEY�F1260402�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1260402",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F1260402 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1260402", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i�h�{�m�j�������ꍇ
                // defaultMap�� KEY�F1260402 VALUE�F3�i�h�{�m�j��ݒ肷��B
                VRBindPathParser.set("1260402", defaultMap, new Integer(3));
                break;
            case 3:
                // �l��3�i�Ǘ��h�{�m�j�������ꍇ
                // defaultMap�� KEY�F1260402 VALUE�F2�i�Ǘ��h�{�m�j��ݒ肷��B
                VRBindPathParser.set("1260402", defaultMap, new Integer(2));
                break;
            }
            // ���W�J
            // �@�@�@�@���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �@�@�@�@�����I�����ڂ�W�J����B
            getThis().bindSource();
            // �@�@���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �@�@�������ݒ�
            // �@�@�@�H���񋟃R���{�`�F�b�N
            if (getShortStayStandardRecuperationDinnerOffer()
                    .getSelectedIndex() == 0) {
                // �@�@�@�@�l��1�i�Ȃ��j�������ꍇ
                // �@�@�@�@�@�H��R���{�̢�����飂�I������B�i�����I���j
                getShortStayStandardRecuperationDinnerOffer().setSelectedIndex(
                        1);
            }
        }

    }

  /**
     * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception {
        // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();
        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        // ���H���e�L�X�g�`�F�b�N
        // �H���񋟃R���{�̒l���`�F�b�N����B
        if (getShortStayStandardRecuperationDinnerOffer().getSelectedIndex() > 0) {
            // �l��1�i�Ȃ��j�ȊO�������ꍇ
            // �H����p(shortStayLifeDinnerCost)�̒l���`�F�b�N����B
            if (ACTextUtilities
                    .isNullText(getShortStayStandardRecuperationDinnerCost()
                            .getText())) {
                // �l���󔒂������ꍇ
                // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
        }
        QkanCommon.removeDisabledBindPath(getThis(), data);
        return data;
    }

    /**
     * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // true��Ԃ��B
        return true;
    }

    /**
     * �u�H��e�L�X�g����v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkDinnerState() throws Exception {
        // ���H��e�L�X�g��Enable���䏈��
        // �H���񋟁ishortStayRecuperationHealthFacilityDinnerCost�j�̒l���`�F�b�N����B
        if (getShortStayStandardRecuperationDinnerOffer().getSelectedIndex() == 0) {
            // �l��1�������ꍇ
            // �H���e�L�X�g��Enable�� false �ɂ���B
            setState_DINNER_COST_ENABLE_FALSE();
        } else {
            // �@�@�l��1�ȊO�������ꍇ
            // �@�@�@�H���e�L�X�g��Enable���@true�@�ɂ���B
            setState_DINNER_COST_ENABLE_TRUE();
        }
    }

  /**
     * �u�H����p���v�l�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkMeatCost() throws Exception {
        // ���H�����������ƂɑI�����Ə��ɂ�����H����p��Ԃ��B
        if (getSelectedProvider() != null) {
            // ���Ə������I���inull�j �ł͂Ȃ��ꍇ
            String meat = "";
            switch (getShortStayStandardRecuperationDinnerOffer()
                    .getSelectedIndex()) {
            case 1:
                // �H���������u������v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��A�u��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260403", getSelectedProvider()),
                        0));
                break;
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260404", getSelectedProvider()),
                        0));
                break;
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260405", getSelectedProvider()),
                        0));
                break;
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260406", getSelectedProvider()),
                        0));
                break;
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260404", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260405",
                                getSelectedProvider()), 0));
                break;
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��Ɓu��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260405", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260406",
                                getSelectedProvider()), 0));
                break;
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260406", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260404",
                                getSelectedProvider()), 0));
                break;
            }
            getShortStayStandardRecuperationDinnerCost().setText(meat);
        } else {
            // �@���Ə������I���̏ꍇ
            // �@�@�󕶎���Ԃ��B
            getShortStayStandardRecuperationDinnerCost().setText("");
        }

    }

  /**
     * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
        return null;
    }

    /**
     * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ���I���������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
        return null;
    }

}
