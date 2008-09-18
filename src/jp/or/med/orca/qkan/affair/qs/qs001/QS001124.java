
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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/02/23  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���F�m�ǑΉ��^�ʏ���� (QS001124)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * �T�[�r�X�p�^�[���F�m�ǑΉ��^�ʏ����(QS001124) 
 */
public class QS001124 extends QS001124Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001124(){
  }

  //�R���|�[�l���g�C�x���g

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001124.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
    // ����ʓW�J���̏����ݒ�
    // ���R���{�A�C�e���̐ݒ�
    // �@������
    // �@�@�R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
    VRMap comboItemMap = new VRHashMap();
    // �@���ݒ�
    // �J�n����
    comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
    // �I������
    comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
    // �@���W�J
    // �@�@���g(this)��comboItemMap�ɐݒ肷��B
    getThis().setModelSource(comboItemMap);
    // �@�@�R���{�A�C�e����W�J����B
    getThis().bindModelSource();
    // ���I�����ڂ̏����ݒ�
    QkanCommon.selectFirstRadioItem(getThis());
    // �@������
    // �@�@�����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
    VRMap defaultMap = new VRHashMap();
    // �@���ݒ�
    // �@���W�J
    // �@�@���g(this)��defaultMap�ɐݒ肷��B
    getThis().setSource(defaultMap);
    // �@�@�����I�����ڂ�W�J����B
    getThis().bindSource();

  }

  /**
   * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void providerSelected(VRMap provider) throws Exception{
    // �����Ə��R���{�ύX���ɌĂԊ֐�
    // �@�I�����Ə����null�łȂ��ꍇ
    // �@�@���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
    // �@�@�@������
    // �@�@�@�@���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
    VRMap defaultMap = new VRHashMap();
    // �@�@�@���ݒ�
    Object obj;
    
    //�{�݋敪1
    //�{�݋敪2
    obj = VRBindPathParser.get("1720101", provider);
    if(obj != null){
       //���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
        switch(ACCastUtilities.toInt(obj)){
        case 1: //
        	VRBindPathParser.set("1720101", defaultMap, new Integer(1));
        	VRBindPathParser.set("1720102", defaultMap, new Integer(1));
        	break;
        case 2: //
        	VRBindPathParser.set("1720101", defaultMap, new Integer(1));
            VRBindPathParser.set("1720102", defaultMap, new Integer(2));
            break;
        case 3: //
            VRBindPathParser.set("1720101", defaultMap, new Integer(2));
            break;
        }
    }
    
    //�l�����Z    
    obj = VRBindPathParser.get("1720103", provider);
    // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
    if (obj != null) {
        switch (ACCastUtilities.toInt(obj)) {
        case 1: // �Ȃ��������ꍇ
            VRBindPathParser.set("1720104", defaultMap, new Integer(1));
            break;
        case 2: // �Ō�E���������ꍇ
        case 3: // ���E���������ꍇ
            VRBindPathParser.set("1720104", defaultMap, new Integer(3));
            break;
        }
    }
//    
//    //�{�݋敪2�̏��
//    if(getProviderDivisionRadioItem1().isSelected()){
//        setInvalidFaclityState2Provider(false);
//        setState_VALID_FACILITY_STATE2();
//    }else{
//        setInvalidFaclityState2Provider(true);
//        setState_INVALID_FACILITY_STATE2();
//    }

    // �h�{�}�l�W�����g���Z
    obj = VRBindPathParser.get("1720104", provider);
    if (obj != null) {
        switch (ACCastUtilities.toInt(obj,0)) {
        case 2:
            // �u����v�̏ꍇ
            // �L���ɂ���B
            setState_VALID_NUTRITION();
            VRBindPathParser.set("1720105", defaultMap, obj);
            break;
        case 1:
            // �u�Ȃ��v�̏ꍇ
            // �����ɂ���B
            setState_INVALID_NUTRITION();
            VRBindPathParser.set("1720105", defaultMap, obj);
            break;
        }
    }

    // ���o�@�\������Z
    obj = VRBindPathParser.get("1720105", provider);
    if (obj != null) {
        switch (ACCastUtilities.toInt(obj)) {
        case 2:
            // �u����v�̏ꍇ
            // �L���ɂ���B
            setState_VALID_ORAL_FUNCTION();
            break;
        case 1:
            // �u�Ȃ��v�̏ꍇ
            // �����ɂ���B
            setState_INVALID_ORAL_FUNCTION();
            break;
        }
        VRBindPathParser.set("1720108", defaultMap, obj);
    }
    
    //�ʋ@�\�P���̐�
    // ���ӁF�ʏ�����SYSTEM_BIND_PATH���������Ă���B
    obj = VRBindPathParser.get("1150102",provider);
    if(obj != null){
        switch(ACCastUtilities.toInt(obj)){
        case 1://�Ȃ�
            setState_INVALID_FUNCTION_TRAINING_ADD();
            VRBindPathParser.set("1720107",defaultMap,obj);
            break;
        case 2://����
            setState_VALID_FUNCTION_TRAINING_ADD();
            VRBindPathParser.set("1720107",defaultMap,obj);
            break;
        }
    }
    
    //������̐�
    // ���ӁF�ʏ�����SYSTEM_BIND_PATH���������Ă���B
    obj = VRBindPathParser.get("1150103",provider);
    if(obj != null){
        switch(ACCastUtilities.toInt(obj)){
        case 1://�Ȃ�
            setState_INVALID_BATH_ADD();
            VRBindPathParser.set("1720106",defaultMap,obj);
            break;
        case 2://����
            setState_VALID_BATH_ADD();
            VRBindPathParser.set("1720106",defaultMap,obj);
            break;
        }
    }
    
    // ���W�J
    // ���g(this)��defaultMap�ɐݒ肷��B
    getThis().setSource(defaultMap);
    // �����I�����ڂ�W�J����B
    getThis().bindSource();
    // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

  }

  /**
   * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public VRMap getValidData() throws Exception{
    // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
      if (ACTextUtilities.isNullText(getBeginTime().getText())
              || ACTextUtilities.isNullText(getEndTime()
                      .getText())
              || (!getBeginTime().isValidDate())
              || (!getEndTime().isValidDate())) {
          // �J�n�����R���{(houmonKangoIryoBeginTime)�ƏI�������R���{(houmonKangoIryoEndTime)�̂����ꂩ���󗓂��s���̏ꍇ
          // �����̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_TIME
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_TIME();
          // null��Ԃ��B
          return null;
      }
    // ���ԋp�p�̃��R�[�h(data)�𐶐�
    VRMap data = new VRHashMap();
    // �@���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
    getThis().setSource(data);
    // �@���g(this)��applySource���Ăяo���ăf�[�^�����W����B
    getThis().applySource();
    // ���ԋp�p���R�[�h����s�v�ȃL�[������
    QkanCommon.removeDisabledBindPath(getThis(), data);
    // �@���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
return data;
  }

  /**
   * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean isUseProvider() throws Exception{
    // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
    // �@true��Ԃ��B
return true;
  }

  /**
   * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
    // ���J�n�������͗p�̃R���{��Ԃ��B
    // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
return getBeginTime();
  }

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ���I���������͗p�̃R���{��Ԃ��B
    // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
return getEndTime();
  }

  /**
   * �u�{�݋敪1,2�̘A���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
protected void providerDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception {
    switch (getProviderDivisionRadio().getSelectedIndex()) {
		case 1:
			// �{�݋敪1��I�^�̏ꍇ
			// �{�݋敪2��L���ɂ���B
			setState_VALID_FACILITY_STATE2();
			break;
		case 2:
			// �{�݋敪1��II�^�̏ꍇ
			// �{�݋敪2�𖳌��ɂ���B
			setState_INVALID_FACILITY_STATE2();
			break;
		}
    
}


/**
 * �u�I�����Ԃ̃`�F�b�N�v�Ɋւ��鏈�����s�Ȃ��܂��B
 * 
 * @throws Exception
 *             ������O
 */
public void checkEndTime() throws Exception {
    // �����ԑѕύX���A�I�����Ԃ��ύX
    // �J�n���ԃR���{(houmonRehabilitationTimeContenaBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
    // ���ԑޔ�p�̕ϐ�kangoTime�ɁA���ԋ敪����擾�������Ԃ�ݒ肷��B
    // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
    if (getBeginTime().isValidDate()
            && (!ACTextUtilities
                    .isNullText(getBeginTime()
                            .getText()))) {
        int kaigoTime = 0;
        // �J�n���ԃR���{(houmonKangoKaigoBeginTime)�̒l���󗓂���ѕs���łȂ��ꍇ
        // ���ԑޔ�p�̕ϐ�kangoTime�ɁA�K��Ō쎞�ԋ敪����擾�������Ԃ�ݒ肷��B
        kaigoTime = getNintiTuusho();

        // �I�����Ԃ��u�J�n���� + kangoTime(��)�v�ɐݒ肷��B
        getEndTime().setDate(
                ACDateUtilities.addMinute(
                        getBeginTime()
                                .getDate(), kaigoTime));
    }

}

/**
 * �u���ԋ敪�̎��Ԏ擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
 * 
 * @throws Exception ������O
 */
public int getNintiTuusho() throws Exception {
    // �����ԋ敪(getTsuusyoKaigoTimeDivision)�̎��Ԃ��擾
    // ���ԋ敪(getTsuusyoKaigoTimeDivision)�̒l���`�F�b�N����B
    switch (getTimeDivisionRadio().getSelectedIndex()) {
    case 1:
        // �Q���Ԉȏ�R���Ԗ����̏ꍇ
        // �߂�l�Ƃ���180��Ԃ��B
        return 180;
    case 2:
        // �R���Ԉȏ�S���Ԗ����̏ꍇ
        // �߂�l�Ƃ���240��Ԃ��B
        return 240;
    case 3:
        // �S���Ԉȏ�U���Ԗ����̏ꍇ
        // �߂�l�Ƃ���360��Ԃ��B
        return 360;
    case 4:
        // �U���Ԉȏ�W���Ԗ����̏ꍇ
        // �߂�l�Ƃ���480��Ԃ��B
        return 480;
    case 5:
        // �W���Ԉȏ�X���Ԗ����̏ꍇ
        // �߂�l�Ƃ���540��Ԃ��B
        return 540;
    case 6:
        // �X���Ԉȏ�P�O���Ԗ����̏ꍇ
        // �߂�l�Ƃ���600��Ԃ��B
        return 600;
    }
    return 0;
}

/**
 * �J�n���ԑI������
 */
protected void beginTimeActionPerformed(ActionEvent e) throws Exception {
    checkEndTime();
    
}

/**
 * �����敪�I���C�x���g 
 */
protected void timeDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception {
    checkEndTime();
    
}

}
