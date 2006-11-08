
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
 * �v���O���� �T�[�r�X�p�^�[�����\�h�Z������������� (QS001137)
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
 * �T�[�r�X�p�^�[�����\�h�Z�������������(QS001137) 
 */
public class QS001137 extends QS001137Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001137(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�{�݋敪�I�����C�x���g�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void shortStayLifeTimeContenaFacilityDivisionActionPerformed(ActionEvent e) throws Exception{
    // ���u�{�݋敪�v�I�����́u�a���敪�v�̏�Ԑؑ�
    // �@��ʂ̏�Ԃ𐧌䂷��B
    checkState();


  }

  /**
     * �u�H���񋟑I���v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void shortStayLifeDinnerOfferActionPerformed(ActionEvent e)
            throws Exception {
        // ���u�H���񋟁v�I�����Ɂu�H��v�̏�Ԑؑ�
        if (getShortStayLifeDinnerOffer().getSelectedIndex() < 1) {
            // �u�H���񋟁v���u�Ȃ��v�̏ꍇ
            // �H���e�L�X�g�̏�Ԃ𐧌䂷��B
            checkDinnerState();
        } else {
            // �u�H���񋟁v���u�Ȃ��v�ȊO�̏ꍇ
            // �H���L���ɂ���B
            checkDinnerState();

            // �H����p(shortStayLifeDinnerCost)��ݒ肷��B
            checkMeatCost();
        }

    }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001137.class.getName(), param));
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
        // �擾�����l���AcomboItemMap�� KEY : 1240109 �� VALUE �Ƃ��Đݒ肷��B
        comboItemMap.setData("1240109", QkanCommon.getArrayFromMasterCode(191,
                "1240109"));
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
        VRBindPathParser.set("1240109", defaultMap, new Integer(1));
        // ���W�J
        // ���g(this)��defaultMap�ɐݒ肷��B
        getThis().setSource(defaultMap);
        // �@�@�����I�����ڂ�W�J����B
        getThis().bindSource();
        // �@�@��ʂ̏�Ԃ𐧌䂷��B
        checkState();

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
            // �{�ݓ��̋敪�i���Ə��p�l���jKEY�F1240101�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240101",
                    provider), 0)) {
            case 1:
                // �l��1�i�P�ƌ^�j�������ꍇ
                // defaultMap�� KEY�F1240101 VALUE�F1�i�P�ƌ^�j��ݒ肷��B
                VRBindPathParser.set("1240101", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i���݌^�j�������ꍇ
                // defaultMap�� KEY�F1240101 VALUE�F2�i���݌^�j��ݒ肷��B
                VRBindPathParser.set("1240101", defaultMap, new Integer(2));
                break;
            case 3:
                // �l��3�i�P�ƌ^�E���j�b�g�^�j�������ꍇ
                // defaultMap�� KEY�F1240101 VALUE�F3�i�P�ƌ^�E���j�b�g�^�j��ݒ肷��B
                VRBindPathParser.set("1240101", defaultMap, new Integer(3));
                break;
            case 4:
                // �l��4�i���݌^�E���j�b�g�^�j�������ꍇ
                // defaultMap�� KEY�F1240101 VALUE�F4�i���݌^�E���j�b�g�^�j��ݒ肷��B
                VRBindPathParser.set("1240101", defaultMap, new Integer(4));
                break;
            }
            // ��ԋΖ�������i���Ə��p�l���jKEY�F1240102�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240102",
                    provider), 0)) {
            case 1:
                // �l��1�i��^�j�������ꍇ
                // defaultMap�� KEY�F1240104 VALUE�F1�i��^�j��ݒ肷��B
                VRBindPathParser.set("1240104", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i���Z�^�j�������ꍇ
                // defaultMap�� KEY�F1240104 VALUE�F2�i���Z�^�j��ݒ肷��B
                VRBindPathParser.set("1240104", defaultMap, new Integer(2));
                break;
            }
            // �E���̌����ɂ�錸�Z�̏󋵁i���Ə��p�l���jKEY�F1240103�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240103",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F1240108 VALUE�F1�i���}�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1240108", defaultMap, new Integer(1));
                break;
            case 2:
            case 3:
                // �l��3�i�Ō�E���E���j�������ꍇ
                // defaultMap�� KEY�F1240108 VALUE�F3�i���}�����j��ݒ肷��B
                VRBindPathParser.set("1240108", defaultMap, new Integer(3));
                break;
            }
            // ���j�b�g�P�A�̐��i���Ə��p�l���jKEY�F1240104�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240104",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ή��s�j�������ꍇ
                // defaultMap�� KEY�F1240111 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1240111", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i�Ή��j�������ꍇ
                // defaultMap�� KEY�F1240111 VALUE�F2�i����j��ݒ肷��B
                VRBindPathParser.set("1240111", defaultMap, new Integer(2));
                break;
            }
            // �@�\�P���w���̐��i���Ə��p�l���jKEY�F1240105�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240105",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // defaultMap�� KEY�F1240105 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1240105", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i����j�������ꍇ
                // defaultMap�� KEY�F1240105 VALUE�F2�i����j��ݒ肷��B
                VRBindPathParser.set("1240105", defaultMap, new Integer(2));
                break;
            }
            // ���}�̐��i���Ə��p�l���jKEY�F1240106�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240106",
                    provider), 0)) {
            case 1:
                // �l��1�i�Ή��s�j�������ꍇ
                // defaultMap�� KEY�F6 VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("6", defaultMap, new Integer(1));
                break;
            case 2:
                // �l��2�i�Ή��j�������ꍇ
                // defaultMap�� KEY�F6 VALUE�F3�i���}�����j��ݒ肷��B
                VRBindPathParser.set("6", defaultMap, new Integer(3));
                break;
            }
            // �h�{�Ǘ��̕]���i���Ə��p�l���jKEY�F1240107�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240107",
                    provider), 0)) {
            case 1:
                // �@�@�@�@�@�@�@�l��1�i�Ȃ��j�������ꍇ
                // �@�@�@�@�@�@�@�@defaultMap�� KEY�F1240106�@VALUE�F1�i�Ȃ��j��ݒ肷��B
                VRBindPathParser.set("1240106", defaultMap, new Integer(1));
                break;
            case 2:
                // �@�@�@�@�@�@�@�l��2�i�h�{�m�j�������ꍇ
                // �@�@�@�@�@�@�@�@defaultMap�� KEY�F1240106�@VALUE�F3�i�h�{�m�j��ݒ肷��B
                VRBindPathParser.set("1240106", defaultMap, new Integer(3));
                break;
            case 3:
                // �@�@�@�@�@�@�@�l��3�i�Ǘ��h�{�m�j�������ꍇ
                // �@�@�@�@�@�@�@�@defaultMap�� KEY�F1240106�@VALUE�F2�i�Ǘ��h�{�m�j��ݒ肷��B
                VRBindPathParser.set("1240106", defaultMap, new Integer(2));
                break;
            }
            // �@�@�@���W�J
            // �@�@�@�@���g(this)��defaultMap�ɐݒ肷��B
            getThis().setSource(defaultMap);
            // �@�@�@�@�����I�����ڂ�W�J����B
            getThis().bindSource();
            // �@�@���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
            // �@�@�@��ʂ̏�Ԃ𐧌䂷��B
            checkState();
            
            if(getShortStayLifeDinnerOffer().getSelectedIndex() == 0){
                getShortStayLifeDinnerOffer().setSelectedIndex(1);
            }
            // �@�@�@�e�L�X�g�G���A�̐��䂷��B
            checkDinnerState();
            
            checkMeatCost();
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
        QkanCommon.removeDisabledBindPath(getThis(), data);

        // �H��R���{�̒l���`�F�b�N����B
        if(getShortStayLifeDinnerOffer().getSelectedIndex()>=1){
            // �H��e�L�X�g�������͂������ꍇ
            if (ACTextUtilities.isNullText(getShortStayLifeDinnerCost().getText())){
                // ���e�̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // null��Ԃ��B
                return null;
            }
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
        // true��Ԃ��B
        return true;
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

  /**
     * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkState() throws Exception {
        // ����ʏ�Ԃ𐧌䂷��B
        // ���T�[�r�X�A��
        // �{�ݓ��̋敪�i�T�[�r�X�p�l���j�̒l���`�F�b�N����B
        switch (getShortStayLifeTimeContenaFacilityDivision()
                .getSelectedIndex()) {
        case 1:
        case 2:
            // �l��1����2�i�P�ƌ^�y�ѕ��݌^�j�������ꍇ
            // ���j�b�g�^���y�у��j�b�g�^�����i�T�[�r�X�p�l���j��Enable��false�ɂ���B
            setState_UNIT_HOSPITAL_ROOM_DIVISION_ENABLE_FALSE();
            // �]���^���y�ё��������i�T�[�r�X�p�l���j��Enable��true�ɂ���B
            setState_HOSPITAL_ROOM_DIVISION_ENABLE_TRUE();
            break;
        case 3:
        case 4:
            // �l��3����4�i�P�ƌ^���j�b�g�^�E���݌^���j�b�g�^�j�������ꍇ
            // �]���^���y�ё��������i�T�[�r�X�p�l���j��Enable��false�ɂ���B
            setState_HOSPITAL_ROOM_DIVISION_ENABLE_FALSE();
            // ���j�b�g�^���y�у��j�b�g�^�����i�T�[�r�X�p�l���j��Enable��true�ɂ���B
            setState_UNIT_HOSPITAL_ROOM_DIVISION_ENABLE_TRUE();
            break;
        }
        // �����Ə��A��
        // �����ϐ� providerInfoMap �𐶐�����B
        VRMap providerInfoMap;
        // ���Ə��p�l�������擾�� providerInfoMap �Ɋi�[����B
        providerInfoMap = getSelectedProvider();
        // providerInfoMap�� null ���`�F�b�N����B
        // null�i���Ə����I���j�������ꍇ
        // �����s��Ȃ��B
        if (providerInfoMap != null) {
            // null�ȊO�������ꍇ
            // ���j�b�g�P�A�̐��i���Ə��p�l���j�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240104",
                    providerInfoMap), 0)) {
            case 1:
                // �l��1�i�Ȃ��j�������ꍇ
                // ���j�b�g�P�A�̐����i�T�[�r�X�p�l���j��Enable��false�ɂ���B
                setState_UNIT_CARE_ENABLE_FALSE();
                break;
            case 2:
                // �l��2�i����j�������ꍇ
                // ���j�b�g�P�A�̐����i�T�[�r�X�p�l���j��Enable��true�ɂ���B
                setState_UNIT_CARE_ENABLE_TRUE();
                break;
            }
            // �@�\�P���w���̐��i���Ə��p�l���j�̒l���`�F�b�N����B
            switch (ACCastUtilities.toInt(VRBindPathParser.get("1240105",
                    providerInfoMap), 0)) {
            case 1:
                // �@�@�@�@�@�l��1�i�Ȃ��j�������ꍇ
                // �@�@�@�@�@�@�@�\�P�����Z�i�T�[�r�X�p�l���j��Enable��false�ɂ���B
                setState_ADDITION_FUNCTION_TRAINING_ENABLE_FALSE();
                break;
            case 2:
                // �@�@�@�@�@�l��2�i����j�������ꍇ
                // �@�@�@�@�@�@�@�\�P�����Z�i�T�[�r�X�p�l���j��Enable��true�ɂ���B
                setState_ADDITION_FUNCTION_TRAINING_ENABLE_TRUE();
                break;
            }
        }
        // ���j�b�g�^�ȊO�̏ꍇ�͈ꗥEnable��false�ɂ���B
        switch(getShortStayLifeTimeContenaFacilityDivision().getSelectedIndex()){
        case 1:
        case 2:
        // ���j�b�g�P�A�̐����i�T�[�r�X�p�l���j��Enable��false�ɂ���B
            setState_UNIT_CARE_ENABLE_FALSE();
            break;
        }
    }

  /**
   * �u�H���e�L�X�g����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void checkDinnerState() throws Exception{
    // ���H���e�L�X�g�̐�����s��
        // �H���񋟁ishortStayLifeDinnerOffer�j�̒l���`�F�b�N����B
        if (getShortStayLifeDinnerOffer().getSelectedIndex() == 0) {
            // �l��0�������ꍇ
            // �H���e�L�X�g��Enable�� false �ɂ���B
            setState_DINNER_COST_ENABLE_FALSE();
        } else {
            // �l��1�ȊO�������ꍇ
            // �H���e�L�X�g��Enable�� true �ɂ���B
            setState_DINNER_COST_ENABLE_TRUE();
        }
  }

  /**
     * �u�H��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void checkMeatCost() throws Exception {
        // ���H�����������ƂɑI�����Ə��ɂ�����H����p��Ԃ��B
        if (getSelectedProvider() != null) {
            // ���Ə������I���inull�j �ł͂Ȃ��ꍇ
            String meat = "";
            switch (getShortStayLifeDinnerOffer().getSelectedIndex()) {
            case 1:
                // �H���������u������v�̏ꍇ
                // �u���v�̐H��A�u���v�̐H��A�u��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240108", getSelectedProvider()),
                        0));
                break;
            case 2:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240109", getSelectedProvider()),
                        0));
                break;
            case 3:
                // �H���������u���̂݁v�̏ꍇ
                // �u���v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240110", getSelectedProvider()),
                        0));
                break;
            case 4:
                // �H���������u��̂݁v�̏ꍇ
                // �u��v�̐H���Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240111", getSelectedProvider()),
                        0));
                break;
            case 5:
                // �H���������u�����v�̏ꍇ
                // �u���v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240109", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1240110",
                                getSelectedProvider()), 0));
                break;
            case 6:
                // �H���������u����v�̏ꍇ
                // �u���v�̐H��Ɓu��v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240110", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1240111",
                                getSelectedProvider()), 0));
                break;
            case 7:
                // �H���������u�钩�v�̏ꍇ
                // �u��v�̐H��Ɓu���v�̐H��̍��Z��Ԃ��B
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1240111", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1240109",
                                getSelectedProvider()), 0));
                break;
            }
            getShortStayLifeDinnerCost().setText(meat);
        } else {

            // �@�󕶎���Ԃ��B
            getShortStayLifeDinnerCost().setText("");
        }
    }

}
