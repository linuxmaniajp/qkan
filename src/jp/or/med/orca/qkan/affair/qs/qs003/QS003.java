
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
 * �J����: �� ����
 * �쐬��: 2005/12/22  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ���p�E�񋟕[��� (003)
 * �v���O���� ���p�E�񋟕[��� (QS003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs003;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
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

/**
 * ���p�E�񋟕[���(QS003) 
 */
public class QS003 extends QS003Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS003(){
  }
  public void initAffair(ACAffairInfo affair) throws Exception  {
    super.initAffair(affair);
    initAction(affair);
  }
  /**
   * �������������s�Ȃ��܂��B
   * @param affair �Ɩ����
   * @throws Exception ������O
   */
  protected void initAction(ACAffairInfo affair) throws Exception {
    // ���e�평���l�E������Ԃ�ݒ肷��
    // ���n��p�����[�^�̑ޔ�
    // �@patientID�ɁA�n��p�����[�^�� KEY : PATIENT_ID �� VALUE ��ݒ肷��B
    // �@targetDateSource�ɁA�n��p�����[�^�� KEY : TARGET_DATE �� VALUE ��ݒ肷��B
    // �@serviceData�ɁA�n��p�����[�^�� KEY : SERVICE_DATA �� VALUE ��ݒ肷��B
    // �@�n��p�����[�^�� KEY : PROCESS_TYPE �� VALUE ���`�F�b�N����B
    // �@�@PROCESS_TYPE_PLAN�̏ꍇ
    // �@�@�@processType�ɐ��l�萔PROCESS_TYPE_PLAN��ݒ肷��B
    // �@�@PROCESS_TYPE_RESULT�̏ꍇ
    // �@�@�@processType�ɐ��l�萔PROCESS_TYPE_RESULT��ݒ肷��B
    // �������l�̐ݒ�
    // �@��ʂ̏����l��ݒ肷��B
    setInitValue();

    // ��������Ԃ̐ݒ�
    // �@��ʂ̏�����Ԃ�ݒ肷��B
    setInitState();


  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u����T�[�r�X�쐬�ҕύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void planManufacturerActionPerformed(ActionEvent e) throws Exception{
    // ������T�[�r�X�쐬�ҕύX���A������x�����ƎҎ��Ə����̗L��/������؂�ւ���
    // �@������x�����ƎҎ��Ə����̗L��/������ݒ肷��B
    setProviderComponentState();


  }

  /**
   * �u���Ə����ύX�v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void supportProviderNameActionPerformed(ActionEvent e) throws Exception{
    // ��������x�����ƎҎ��Ə����ύX���A���Ə��ԍ��A�y�ђS���҂�؂�ւ���
    // �����Ə��ԍ��̕ύX
    // �@���ƎҔԍ����x��(supportProviderCd)�̒l�Ƃ��āA�I�����ꂽ���Ə��̎��Ə��ԍ���ݒ肷��B(���Ə������I�𓙂̗��R�ɂ��
    // �@���Ə��ԍ����擾�ł��Ȃ������ꍇ�A���Ə��ԍ��͖��I���Ƃ���)
    // ���S���҃R���{�̃A�C�e���ύX
    // �@�S���҃R���{(personInCharge)�̃A�C�e���Ƃ��āA�I�����ꂽ���Ə��ɓo�^����Ă���S���҂�ݒ肷��B(���Ə������I�𓙂̗��R
    // �@�ɂ�莖�Ə��ԍ����擾�ł��Ȃ������ꍇ�A�S���҃R���{�̃A�C�e���͂Ȃ��Ƃ���)
    // ���S���҃R���{�̏����I��
    // �@�I�����ꂽ���Ə��ŁA�ŗD��̒S���҂�I������i���Ə��ꗗ��ʂŕ\�������S���҂Ɠ����j�B(�ݒ�ł��Ȃ��ꍇ�͖��I���Ƃ���)

  }

  /**
   * �u���p�[/�񋟕[�̈���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void printActionPerformed(ActionEvent e) throws Exception{
    // �����p�[(�ʕ\)/�񋟕[(�ʕ\)�̈�����s���B
    // �@�n��p�����[�^ printParam (���R�[�h)�𐶐����A���L�̒l��ݒ肷��B
    VRMap printParam = new VRHashMap();
    // �@�@KEY : PATIENT_ID, VALUE : (���p��ID)
    // �@�@KEY : TARGET_DATE, VALUE : (�Ώ۔N��)
    // �@�@KEY : SERVICE_DATA, VALUE : (���ԕ\���̃��R�[�h�W��)
    // �@�@KEY : PROCESS_TYPE, VALUE : (�����ϐ�processType�̒l)
    // �@�@KEY : SHORT_STAR_USE_DAY, VALUE : (�O���܂ł̒Z���������p��)
    // �@�@KEY : CREATE_DATE_OUTER, VALUE : (�g�O�̍쐬�N����)
    // �@�@KEY : CREATE_DATE_INNER, VALUE : (�g���̍쐬�N����)
    // ��������[�̔���
    // �@����t���O�̏������̂��߁AprintParam�ɉ��L�̒l��ݒ肷��B
    // �@�@KEY : PRINT_MODE_USE, VALUE : 0
    // �@�@KEY : PRINT_MODE_USE_ANOTHER, VALUE : 0
    // �@�@KEY : PRINT_MODE_OFFER VALUE : 0
    // �@�@KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 0
    // �@�u������钠�[�̑I���v�̒l���`�F�b�N����B
    // �@�@�u���p�[�E�ʕ\�v�̏ꍇ
    // �@�@�@printParam�ɉ��L�̒l��ݒ肷��B
    // �@�@�@�@KEY : PRINT_MODE_USE, VALUE : 1
    // �@�@�@�@KEY : PRINT_MODE_USE_ANOTHER, VALUE : 1
    // �@�@�u�񋟕[�E�ʕ\�v�̏ꍇ
    // �@�@�@printParam�ɉ��L�̒l��ݒ肷��B
    // �@�@�@�@KEY : PRINT_MODE_OFFER VALUE : 1
    // �@�@�@�@KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 1
    // �@�@�u���p�[�v�̏ꍇ
    // �@�@�@printParam�ɉ��L�̒l��ݒ肷��B
    // �@�@�@�@KEY : PRINT_MODE_USE, VALUE : 1
    // �@�@�u�񋟕[�v�̏ꍇ
    // �@�@�@printParam�ɉ��L�̒l��ݒ肷��B
    // �@�@�@�@KEY : PRINT_MODE_OFFER VALUE : 1
    // �@�@�u�ʕ\�v�̏ꍇ
    // �@�@�@�u���[��ʑI���v�̒l���`�F�b�N����B
    // �@�@�@�@�u���p�[�v�̏ꍇ
    // �@�@�@�@�@printParam�ɉ��L�̒l��ݒ肷��B
    // �@�@�@�@�@�@KEY : PRINT_MODE_USE_ANOTHER, VALUE : 1
    // �@�@�@�@�u�񋟕[�v�̏ꍇ
    // �@�@�@�@�@printParam�ɉ��L�̒l��ݒ肷��B
    // �@�@�@�@�@�@KEY : PRINT_MODE_OFFER_ANOTHER VALUE : 1
    // ���W�v�E����N���X�ւ̒l�n��
    // �@���ԕ\�����W�v���A��������s���邽�߂̃N���X�֒l��n���A������J�n����B

  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    ACFrame.debugStart(new ACAffairInfo(QS003.class.getName()));
  }

  //�����֐�

  /**
   * �u�����l�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void setInitValue() throws Exception{
    // �������l�ݒ�
    // ��������
    // �@�v���x�������i�[�p�̃��R�[�h�W�� patientInsureInfoHistoryList�𐶐�����B
    VRList patientInsureInfoHistoryList = new VRArrayList();
    // �@�����̗v���x�������i�[�p���R�[�h patientInsureInfoFirst �𐶐�����B
    VRMap patientInsureInfoFirst = new VRHashMap();
    // �@�����̗v���x�������i�[�p���R�[�h patientInsureInfoLast �𐶐�����B
    VRMap patientInsureInfoLast = new VRHashMap();
    // �@�ł��d���v���x�������i�[�p���R�[�h patientInsureInfoHeaviest �𐶐�����B
    VRMap patientInsureInfoHeaviest = new VRHashMap();
    // �@�Ώ۔N�����̗��p�җv���x�F�藚�����R�[�h�W�����擾���ApatientInsureInfoHistoryList�ɐݒ肷��B
    //     atientInsurerInfoHistory(DBManager, targetDateSource, patinetID);

    // �@patientInsureInfoFirst�ɁApatientInsureInfoHistoryList�̍ŏ��̃��R�[�h��ݒ肷��B
    // �@patientInsureInfoLast�ɁApatientInsureInfoHistoryList�̍Ō�̃��R�[�h��ݒ肷��B
    // �@patientInsureInfoHeaviest�ɁA�ł��d���v���x��������ݒ肷��B
    QkanCommon.getPatientInsureInfoOnTargetDay(patientInsureInfoHistoryList, getTargetDateSource());
    // ���E�B���h�E�^�C�g���̐ݒ�
    // �@�Ɩ���񃌃R�[�h���擾����B
    QkanCommon.getAffairInfo(getDBManager(), "QS003", "0");
    // �@�E�B���h�E�^�C�g���ɁA�擾���R�[�h��KEY : WINDOW_TITLE��VALUE��ݒ肷��B
    // ������T�[�r�X�񋟎�
    // �@�R���{�̃A�C�e���Ƃ��āA������x�����Ǝ҂�ݒ肷��B
    // �@�R���{�̑I�����ڂƂ��āA���p�ҏ����擾�����u����T�[�r�X�񋟎ҁv��ݒ肷��B
    // ��������x�����ƎҎ��Ə���
    // �@���I���Ƃ���B
    // ���쐬�N����(�g�O/�ʕ\)
    // �@�V�X�e�����t��ݒ肷��B
    // ���쐬�N����
    // �@�V�X�e�����t��ݒ肷��B
    // ���͏o�N����
    // �@�����l�͐ݒ肵�Ȃ��B
    // ���v����ԋ敪
    // �@patientInsureInfoFirst���u�v����ԋ敪�v�����擾���A��ʂ�youKaigodoType1�ɐݒ肷��B
    // �@patientInsureInfoFirst���u�v����ԋ敪�v�����擾���A��ʂ�youKaigodoType2�ɐݒ肷��B
    // ���x�����x��z
    // �@patientInsureInfoHeaviest���u�x�����x��z�v�����擾���A�ݒ肷��B
    // �����x�z�K�p����
    // �@patientInsureInfoHeaviest���u���x�z�K�p���ԁv�����擾���A�ݒ肷��B
    // ���O���܂ł̒Z���������p����(�v���x�F����Ԓ��̑O���܂ł̒Z�������n�T�[�r�X���щ񐔂��J�E���g)
    // �@���v���x�̗L�����Ԃ��擾����B
    // �@�@�L�����ԊJ�n���i�[�p�̓����ϐ� insureValidStart �𐶐�����B
    Date insureValidStart = null;
    // �@�@�L�����ԏI�����i�[�p�̓����ϐ� insureValidEnd �𐶐�����B
    Date insureValidEnd = null;
    // �@�@patientInsureInfoFirst����L�����ԊJ�n(KEY : INSURE_VALID_START)���擾���AinsureValidStart�ɐݒ肷��B
    // �@�@insureInvalidEnd�ɁA�Ώ۔N���̑O��������ݒ肷��B(���� = �N��:targetDate�̈��(������) �}�C�i�X 1���Ȃ�)
    // �@���L�����ԓ��̃T�[�r�X���я����擾����B
    // �@�@�T�[�r�X�ڍ׏��擾�֐��ւ̓n��p�����[�^ params(������)�𐶐����A���L�̒l��ݒ肷��B
    String params = null;
    // �@�@�@params =
    // �@�@�@"PATIENT_ID=" + patientID +
    // �@�@�@"SERVICE_DATE>=" + insureValidStart +
    // �@�@�@"SERVICE_DATE<=" + insureValidEnd
    // �@�@�@"SERVICE_USE_TYPE=6"        //�J�n�����Ȏ���
    // �@�@�L�����ԓ��̃T�[�r�X���я����擾����B
    QkanCommon.getServiceDetailCustom(getDBManager(), params);
    // �@���O���܂ł̒Z���������p�����̏W�v
    // �@�@�擾�������я�񂩂�A�Z���������p�������J�E���g����B
    // �@�@�@�E�T�[�r�X��ނ�21�A22�A23�̃T�[�r�X���J�E���g�ΏۂƂ���
    // �@�@�@�E�u30�����v���ݒ肳��Ă�����̂̓J�E���g���Ȃ�
    // �@�@�@�E��������2�ȏ�̃T�[�r�X���т������Ă��A�u1���v�Ƃ��ăJ�E���g����
    // �@�@�@��)
    // �@�@�@�@�񋟓��i�[�p�̃��R�[�h�W�� offerDates �𐶐�����B
    // �@�@�@�@���я�񃌃R�[�h�W����n�Ԗڂ̃��R�[�h�ޔ�p�̃��R�[�h rec�𐶐�����B
    // �@�@�@�@�u30�����v�`�F�b�N�p�̐��l over30 �𐶐�����B
    // �@�@�@�@�`�F�b�N�Ώۂ̃T�[�r�X���ђ񋟓��i�[�p�̓��t serviceDate�𐶐�����B
    // �@�@�@�@���p�����i�[�p�̐��l usedDayCount�𐶐����A0�ŏ���������B
    // �@�@�@�@�擾�������я�񕪃��[�v����B
    // �@�@�@�@�@���я�񃌃R�[�h�W����n�Ԗڂ̃��R�[�h�� rec �ɑޔ�����B
    // �@�@�@�@�@���T�[�r�X��ނ̃`�F�b�N / �u30�����v�`�F�b�N
    // �@�@�@�@�@�@rec �� KEY : SYSTEM_SERVICE_KIND_DETAIL �� VALUE �ŕ��򂷂�B
    // �@�@�@�@�@�@�@12101
    // �@�@�@�@�@�@�@�@over30�ɁArec �� KEY : 1210113 �� VALUE ��ݒ肷��B
    // �@�@�@�@�@�@�@12201
    // �@�@�@�@�@�@�@�@over30�ɁArec �� KEY : 1220114 �� VALUE ��ݒ肷��B
    // �@�@�@�@�@�@�@12301
    // �@�@�@�@�@�@�@�@over30�ɁArec �� KEY : 1230152 �� VALUE ��ݒ肷��B
    // �@�@�@�@�@�@�@12302
    // �@�@�@�@�@�@�@�@over30�ɁArec �� KEY : 1230250 �� VALUE ��ݒ肷��B
    // �@�@�@�@�@�@�@12303
    // �@�@�@�@�@�@�@�@over30�ɁArec �� KEY : 1230349 �� VALUE ��ݒ肷��B
    // �@�@�@�@�@�@�@12304
    // �@�@�@�@�@�@�@�@over30�ɁArec �� KEY : 1230408 �� VALUE ��ݒ肷��B
    // �@�@�@�@�@�@�@��L�ȊO�̏ꍇ
    // �@�@�@�@�@�@�@�@���̃��[�v�֔�ԁB
    // �@�@�@�@�@�@over30�̒l���`�F�b�N����B
    // �@�@�@�@�@�@�@0(30�����łȂ�)�̏ꍇ
    // �@�@�@�@�@�@�@�@�������p������B
    // �@�@�@�@�@�@�@1(30�����ł���)�̏ꍇ
    // �@�@�@�@�@�@�@�@���̃��[�v�֔�ԁB
    // �@�@�@�@�@���J�E���g����
    // �@�@�@�@�@�@serviceDate��rec�� KEY : SERVICE_DATE �� VALUE ��ݒ肷��B
    // �@�@�@�@�@�@���ɃJ�E���g�������t���ǂ����`�F�b�N���邽�߂ɁAofferDates�̌��������[�v����B
    // �@�@�@�@�@�@�@serviceDate��offerDates��n�Ԗڂ̓��t�Ƃ��r����B
    // �@�@�@�@�@�@�@�@�������ꍇ
    // �@�@�@�@�@�@�@�@�@����rec�̃��[�v�֔�ԁB
    // �@�@�@�@�@�@�@�@�������Ȃ��ꍇ
    // �@�@�@�@�@�@�@�@�@offerDates�̃��[�v���p������B
    // �@�@�@�@�@�@�ǂ�offerDates�Ƃ��d�������Ƀ��[�v�𔲂���serviceDate�Ɋւ��āA���L�̏������s���B
    // �@�@�@�@�@�@�@usedDayCount��1���₷�B
    // �@�@�@�@�@�@�@offerDates��serviceDate��ǉ�����B
    // �@�@�擾�����T�[�r�X���p��������ʂ́u�Z�L�������p����(shortStayUseDay)�v�ɐݒ肷��B
    // ��������܂񂾋��t���ŕʕ\���쐬
    // �@���I���Ƃ���B
    // �����[��ʑI��
    // ��������钠�[�̎��

  }

  /**
   * �u��ʂ̏�����Ԃ̐ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void setInitState() throws Exception{
    // ����ʂ̏�����Ԃ�ݒ�
    // ��������x�����ƎҎ��Ə����̗L��/�����ݒ�
    // �@������x�����ƎҎ��Ə����̗L��/������ݒ肷��B
    setProviderComponentState();

    // ���\�����Ȃ̂��A���ш���Ȃ̂��ɂ���āA��Ԃ�ݒ�
    // �@processType�̒l���`�F�b�N����B
    // �@�@PROCESS_TYPE_PLAN�̏ꍇ
    // �@�@�@�u������܂񂾋��t���ŕʕ\���쐬�v�`�F�b�N�{�b�N�X�A�u���[��ށv�O���[�v��\������B
    setState_PROCESS_TYPE_PLAN();
    // �@�@PROCESS_TYPE_RESULT�̏ꍇ
    // �@�@�@�u������܂񂾋��t���ŕʕ\���쐬�v�`�F�b�N�{�b�N�X�A�u���[��ށv�O���[�v���\���ɂ���B
    setState_PROCESS_TYPE_RESULT();

  }

  /**
   * �u������x�����ƎҎ��Ə����̏�Ԑݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void setProviderComponentState() throws Exception{
    // ��������x�����ƎҎ��Ə����̗L��/�����̐ؑ�
    // ��������x�����ƎҎ��Ə����̗L��/�����ݒ�
    // �@planManufacturer�̒l���`�F�b�N����B
    // �@�@�u������x�����Ǝҁv���I������Ă���ꍇ
    // �@�@�@������x�����ƎҎ��Ə�����L���ɂ���B
    setState_PROVIDER_MADE();
    // �@�@�u������x�����Ǝҁv���I������Ă��Ȃ��ꍇ
    // �@�@�@������x�����ƎҎ��Ə����𖳌��ɂ���B
    setState_SELF_MADE();

  }

}
