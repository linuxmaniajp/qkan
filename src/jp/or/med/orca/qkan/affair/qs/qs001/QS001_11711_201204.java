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
 * �쐬��: 2011/11/15  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�������p�� (QS001_11711_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.FocusEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.event.ACFollowContainerFormatEventListener;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.component.event.VRFormatEvent;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * �T�[�r�X�p�^�[�������p��(QS001_11711_201204)
 */
@SuppressWarnings("serial")
public class QS001_11711_201204 extends QS001_11711_201204Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001_11711_201204() {
        // �l�ɂ����͂��֎~���鎖�Ə��ݒ荀��
        putRestrictProviderBindPath("���ʒn����Z", "SPECIAL_AREA_FLAG", "1170103");
    }

    // �R���|�[�l���g�C�x���g

    public static void main(String[] args) {
        // �f�t�H���g�f�o�b�O�N��
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
        ACFrame.debugStart(new ACAffairInfo(QS001_11711_201204.class.getName(),
                param));
    }

    // �����֐�

    /**
     * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void initialize() throws Exception {
        // ����ʓW�J���̏����ݒ�
        // ���n���Z�e�L�X�g
        getWelfarePoint().setText("");
        getWelfareTokuchiPoint().setText("");
        // ���R�Ԓn�擙���K�͎��Ə����Z�e�L�X�g
        getProviderAddMountainousAreaScalePoint().setText("");
        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�e�L�X�g
        getProviderAddMountainousAreaRafioPoint().setText("");
        // ���R���{�A�C�e���̐ݒ�
        // ������
        // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
        VRMap comboItemMap = new VRHashMap();
        // �������p��X�g
        // �R�[�h�}�X�^�f�[�^���CODE_ID�F47(�p��j���擾����B
        // �擾�����l���AcomboItemMap�� KEY : 1170101 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1170101",
                QkanCommon.getArrayFromMasterCode(47, "1170101"));
        // ���R���{�A�C�e���̐ݒ�
        // ���g(this)��comboItemMap�ɐݒ肷��B
        getThis().setModelSource(comboItemMap);
        // �R���{�A�C�e����W�J����B
        getThis().bindModelSource();

    }

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception {
        // �����Ə��R���{�ύX���ɌĂԊ֐�
        if (provider != null) {
            Object obj;
            // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

            // ���R�Ԓn�掖�Ə��ł��邩�̔��胍�W�b�N
            String providerID = ACCastUtilities.toString(
                    ((VRMap) provider).getData("PROVIDER_ID"), "");
            VRList serviceInfo = QkanCommon.getProviderServiceDetail(
                    getDBManager(), providerID,
                    ACCastUtilities.toInt("11711", 0));

            if (serviceInfo != null && serviceInfo.getData(0) instanceof VRMap) {
                VRMap providerServiceInfo = (VRMap) serviceInfo.getData(0);
                // ���R�Ԓn�擙�̏��K�͎��Ə��ł���ꍇ
                if (CareServiceCommon.isMountainousArea(providerServiceInfo)) {
                    setState_VALID_MOUNTAINOUS_AREA();
                } else {
                    setState_INVALID_MOUNTAINOUS_AREA();
                }
            } else {
                setState_INVALID_MOUNTAINOUS_AREA();
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
        if (!getWelfareTools().isSelected()) {
            // �p��R���{(welfareTools)�����I���̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }
        if (ACTextUtilities.isNullText(getWelfarePoint().getText())) {
            // �P�ʐ��e�L�X�g(welfarePoint)���󗓂̏ꍇ
            // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
            QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
            // null��Ԃ��B
            return null;
        }

        // ���ԋp�p�̃��R�[�h(data)�𐶐�
        VRMap data = new VRHashMap();
        // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
        getThis().setSource(data);
        // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
        getThis().applySource();

        // ���ԋp�p���R�[�h����s�v�ȃL�[������
        QkanCommon.removeDisabledBindPath(getThis(), data);
        if (getWelfareTokuchiPoint().isEnabled()) {
            // ���n���Z�e�L�X�g(welfareTokuchiPoint)���L���̏ꍇ
            String val = getWelfareTokuchiPoint().getText();
            if (ACTextUtilities.isNullText(val)
                    || (ACCastUtilities.toInt(val, 0) == 0)) {
                // ���n���Z�e�L�X�g(welfareTokuchiPoint)���󗓂��l��0�̏ꍇ
                // �ԋp�p���R�[�h����A���n���Z�e�L�X�g(welfareTokuchiPoint)��bindPath����������B
                data.remove(getWelfareTokuchiPoint().getBindPath());
            }
        }
        // ���R�ԓ��n��
        if (getProviderAddMountainousAreaScalePoint().isEnabled()) {
            // ���R�ԉ��Z�e�L�X�g(getProviderAddMountainousAreaScalePoint)���L���̏ꍇ
            String val = getProviderAddMountainousAreaScalePoint().getText();
            if (ACTextUtilities.isNullText(val)
                    || (ACCastUtilities.toInt(val, 0) == 0)) {
                // ���R�ԉ��Z�e�L�X�g(getProviderAddMountainousAreaScalePoint)���󗓂��l��0�̏ꍇ
                // �ԋp�p���R�[�h����A���R�ԉ��Z�e�L�X�g(getProviderAddMountainousAreaRafioPoint)��bindPath����������B
                data.remove(getProviderAddMountainousAreaScalePoint()
                        .getBindPath());
            }
        }

        // ���R�Ԓn�擙�ł̃T�[�r�X��
        String val = getProviderAddMountainousAreaRafioPoint().getText();
        if (ACTextUtilities.isNullText(val)
                || (ACCastUtilities.toInt(val, 0) == 0)) {
            data.remove(getProviderAddMountainousAreaRafioPoint().getBindPath());
        }

        // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
        return data;
    }

    /**
     * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public boolean isUseProvider() throws Exception {
        // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
        // �@true��Ԃ��B
        return true;
    }

    /**
     * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ���J�n�������͗p�̃R���{��Ԃ��B
        // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
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

    /**
     * �u���R�Ԓn�擙�P�ʐ������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param checkMode int
     * @throws Exception ������O
     * @return boolean
     */
    public boolean checkMountainousPoint(int checkMode) throws Exception {
        // �����R�Ԓn�擙�̒P�ʐ����A�@�����𒴂��Ă��Ȃ�����������B

        //
        if (getSkipCheckMountainousPoint()) {
            return true;
        }

        // �x����ԕϐ�(warningState)���`���A0�ŏ���������B
        int warningState = 0;

        // ���R�Ԓn�擙���K�͎��Ə����Z�̒��߂���������B
        if (getProviderAddMountainousAreaScalePoint().isEnabled()
                && !ACTextUtilities.isNullText(getWelfarePoint().getText())
                && !ACTextUtilities
                        .isNullText(getProviderAddMountainousAreaScalePoint()
                                .getText())) {
            // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�������łȂ��A����
            // �P�ʐ�(welfarePoint)����ђ��R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̒l����łȂ��ꍇ
            if (ACCastUtilities.toInt(getProviderAddMountainousAreaScalePoint()
                    .getText()) > (ACCastUtilities.toInt(getWelfarePoint()
                    .getText()) * 2 / 3)) {
                // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̒l��
                // �P�ʐ�(welfarePoint)�̒l��3����2�𒴂��Ă���ꍇ
                // �x����ԕϐ�(warningState)��1�����Z����B
                warningState += 1;
            }
        }

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�̒��߂���������B
        if (getProviderAddMountainousAreaRafioPoint().isEnabled()
                && !ACTextUtilities.isNullText(getWelfarePoint().getText())
                && !ACTextUtilities
                        .isNullText(getProviderAddMountainousAreaRafioPoint()
                                .getText())) {
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�������łȂ��A����
            // �P�ʐ�(welfarePoint)����ђ��R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̒l����łȂ��ꍇ
            if (ACCastUtilities.toInt(getProviderAddMountainousAreaRafioPoint()
                    .getText()) > (ACCastUtilities.toInt(getWelfarePoint()
                    .getText()) * 1 / 3)) {
                // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̒l��
                // �P�ʐ�(welfarePoint)�̒l��3����1�𒴂��Ă���ꍇ
                // �x����ԕϐ�(warningState)��2�����Z����B
                warningState += 2;
            }
        }

        // ������ߌ������ʂ����ƂɁA�x�����b�Z�[�W����\������B
        // �x����ԕϐ�(warningState)�̒l����ɁA�ȉ��̂Ƃ��蕪�򂷂�B
        switch (warningState) {
        case 0:
            // �l��0�̏ꍇ(�x���Ȃ�)
            // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̃R���e�i������ʏ�\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̃R���e�i������ʏ�\���ɂ���B
            break;
        case 1:
            // �l��1�̏ꍇ(���R�Ԓn�擙���K�͎��Ə����Z�̂݌x��)
            // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̃R���e�i�������x���\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̃R���e�i������ʏ�\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // ����checkMode��0�܂���1�̏ꍇ
            switch (checkMode) {
            case 0:
            case 1:
                // �N���X�ϐ�skipCheckMountainousPoint�ɐ^(true)��������B
                setSkipCheckMountainousPoint(true);
                // ���R�Ԓn�擙���K�͎��Ə����Z�����߂��Ă���|�A�x����\������B
                // �����b�Z�[�WID = QS001_WARNING_OF_MOUNTAINOUS_AREA
                QkanMessageList.getInstance()
                        .QS001_WARNING_OF_MOUNTAINOUS_AREA("���R�Ԓn�擙���K�͎��Ə����Z",
                                "3����2");
                // �N���X�ϐ�skipCheckMountainousPoint�ɋU(false)��������B
                setSkipCheckMountainousPoint(false);
                break;
            }
            // �֐��̖߂�l�Ƃ��ċU��Ԃ��B
            return false;
        case 2:
            // �l��2�̏ꍇ(���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�̂݌x��)
            // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̃R���e�i������ʏ�\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̃R���e�i�������x���\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // ����checkMode��0�܂���2�̏ꍇ
            switch (checkMode) {
            case 0:
            case 2:
                // �N���X�ϐ�skipCheckMountainousPoint�ɐ^(true)��������B
                setSkipCheckMountainousPoint(true);
                // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�����߂��Ă���|�A�x����\������B
                // �����b�Z�[�WID = QS001_WARNING_OF_MOUNTAINOUS_AREA
                QkanMessageList.getInstance()
                        .QS001_WARNING_OF_MOUNTAINOUS_AREA("���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z",
                                "3����1");
                // �N���X�ϐ�skipCheckMountainousPoint�ɋU(false)��������B
                setSkipCheckMountainousPoint(false);
                break;
            }
            // �֐��̖߂�l�Ƃ��ċU��Ԃ��B
            return false;
        case 3:
            // �l��3�̏ꍇ(���R�Ԓn�擙���K�͎��Ə����Z�ƒ��R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�Ɍx��)
            // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̃R���e�i�������x���\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̃R���e�i�������x���\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // �N���X�ϐ�skipCheckMountainousPoint�ɐ^(true)��������B
            setSkipCheckMountainousPoint(true);
            // ���R�Ԓn�擙���K�͎��Ə����Z����ђ��R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�����߂��Ă���|�A�x����\������B
            // �����b�Z�[�WID = QS001_WARNING_OF_MOUNTAINOUS_AREA_ALL
            QkanMessageList.getInstance()
                    .QS001_WARNING_OF_MOUNTAINOUS_AREA_ALL();
            // �N���X�ϐ�skipCheckMountainousPoint�ɋU(false)��������B
            setSkipCheckMountainousPoint(false);
            // �֐��̖߂�l�Ƃ��ċU��Ԃ��B
            return false;
        }
        // �֐��̖߂�l�Ƃ��Đ^��Ԃ��B

        return true;
    }

    /**
     * �u���R�Ԓn��P�ʏ�������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void providerAddMountainousAreaRafioPointFocusLost(FocusEvent e)
            throws Exception {
        // ���P�ʐ��̃t�H�[�J�X�r���C�x���g
        // �֐��u���R�Ԓn�擙�P�ʐ������v��checkMode=2�ŌĂяo���B
        checkMountainousPoint(2);
    }

    /**
     * �u���R�Ԓn��P�ʏ�������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void providerAddMountainousAreaScalePointFocusLost(FocusEvent e)
            throws Exception {
        // ���P�ʐ��̃t�H�[�J�X�r���C�x���g
        // �֐��u���R�Ԓn�擙�P�ʐ������v��checkMode=1�ŌĂяo���B
        checkMountainousPoint(1);
    }

    /**
     * �u���R�Ԓn��P�ʏ�������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void welfarePointFocusLost(FocusEvent e) throws Exception {
        // ���P�ʐ��̃t�H�[�J�X�r���C�x���g
        // �֐��u���R�Ԓn�擙�P�ʐ������v��checkMode=0�ŌĂяo���B
        checkMountainousPoint(0);
    }

}
