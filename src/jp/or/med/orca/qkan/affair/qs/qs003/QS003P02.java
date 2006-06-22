
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
 * �쐬��: 2005/12/15  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ���p�[�ʕ\ (003)
 * �v���O���� ���p�[�ʕ\ (QS00302)
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
 * ���p�[�ʕ\(QS00302) 
 * ���[��`�̃t�@�C���� �F QS00302.xml
 */
public class QS003P02 extends QS003P02Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS003P02(){
  }

  /**
   * ���[�𐶐����܂��B
   * @param writer ����Ǘ��N���X
   * @param printParam ����p�����^
   * @throws Exception ������O
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
    //TODO ���[ID��K�v�ɉ�����"mainFormat"����K�؂Ȃ��̂ɏ��������邱�ƁB
    ACChotarouXMLUtilities.getInstance().addFormat(writer, "mainFormat", "QS00302.xml");
    //�y�[�W�J�n
    writer.beginPageEdit("mainFormat");
      // ���쐬�N����
    // �@�쐬�N�����Ƃ��āA�n��p�����[�^�� KEY : CREATE_DATE_OUTER �� VALUE ��ݒ肷��B
    // �@�@�N
    //     setValue(createDateOuterYear, (�N));

    // �@�@��
    //     setValue(createDateOuterMonth, (��));

    // �@�@��
    //     setValue(createDateOuterDay, (��));

    // �����p�ҏ��
    // �@�n��p�����[�^�� KEY : PATIENT_ID �� VALUE �����ɁA���p�ҏ����擾����B
    // �@���p�҂̐��E�����A��ی��Ҏ������擾����B
    //     toFullName((��), (��));

    // �@���p�Ҏ�����ݒ肷��B
    //     setValue(insured.insuredName.h1, (��ی��Ҏ���));

    // �@��ی��Ҕԍ���ݒ肷��B
    //     setValue(insured.insuredID.h1, INSURED_ID);

    // ���Ώ۔N��
    // �@�Ώ۔N���Ƃ��āA�n��p�����[�^�� KEY : TARGET_DATE �� VALUE ��ݒ肷��B
    // �@�@�N
    //     setValue(targetDateYear, (�N));

    // �@�@��
    //     setValue(targetDateMonth, (��));

    // ���敪�x�����x�Ǘ��E���p�ҕ��S�v�Z
    // �@���W�v���
    // �@�@�\���f�[�^�i�[�p�̃��R�[�h�W�� serviceData �𐶐�����B
    VRList serviceData = new VRArrayList();
    // �@�@serviceData�ɁA�n��p�����[�^�� KEY : SERVICE_DATA �� VALUE ��ݒ肷��B
    // �@�@�\���f�[�^�̏W�v�������s���B
    tabulation(serviceData, getPrintList(), getFooterMap());

    // �@���\�����̐ݒ�iprintList�̒l��ݒ�)
    // �@�@�f�[�^�̌��������[�v����B
    // �@�@�@�����Ə���
    //     setValue(main.x1.y1, PROVIDER_NAME);

    // �@�@�@�����Ə��ԍ�
    //     setValue(main.x2.y1, PROVIDER_ID);

    // �@�@�@���T�[�r�X���e/���
    //     setValue(main.x3.y1, SERVICE_NAME);

    // �@�@�@���T�[�r�X�R�[�h
    //     setValue(main.x4.y1, SERVICE_CODE);

    // �@�@�@���P��
    //     setValue(main.x5.y1, UNIT);

    // �@�@�@��������(��%)
    //     setValue(main.x6.y1, REDUCTION_RATE);

    // �@�@�@��������(�P�ʐ�)
    //     setValue(main.x7.y1, REDUCTION_UNIT);

    // �@�@�@����
    //     setValue(main.x8.y1, COUNT);

    // �@�@�@���T�[�r�X�P��/���z
    //     setValue(main.x9.y1, SERVICE_UNIT_COST);

    // �@�@�@���敪�x�����x��𒴂���P�ʐ�
    //     setValue(main.x12.y1, KUBUN_LIMIT_OVER);

    // �@�@�@���敪�x�����x����P�ʐ�
    //     setValue(main.x13.y1, KUBUN_LIMIT_UNDER);

    // �@�@�@���P�ʐ��P��
    //     setValue(main.x14.y1, YEN_PER_UNIT);

    // �@�@�@����p���z(�ی��Ώە�)
    //     setValue(main.x15.y1, INSURANCE_FEE);

    // �@�@�@�����t��(%)
    //     setValue(main.x16.y1, BENEFIT_RATE);

    // �@�@�@���ی����t�z
    //     setValue(main.x17.y1, BENEFIT);

    // �@�@�@�����p�ҕ��S(�ی��Ώە�)
    //     setValue(main.x18.y1, INSURED_INSURANCE_COST);

    // �@�@�@�����p�ҕ��S(�S�z���S��)
    //     setValue(main.x19.y1, INSURED_TOTAL_COST);

    // �@���t�b�^�[�̐ݒ�(footerMap�̒l��ݒ�)
    // �@�@���敪�x�����x��z(�P��)
    //     setValue(main.x5.total, UNIT_LIMIT);

    // �@�@�����v(�T�[�r�X�P��/���z)
    //     setValue(main.x9.total, SERVICE_UNIT_COST);

    // �@�@�����v(�敪�x�����x��𒴂���P�ʐ�)
    //     setValue(main.x12.total, KUBUN_LIMIT_OVER);

    // �@�@�����v(�敪�x�����x����P�ʐ�)
    //     setValue(main.x13.total, KUBUN_LIMIT_UNDER);

    // �@�@�����v(��p���z(�ی��Ώە�))
    //     setValue(main.x15.total, INSURANCE_FEE);

    // �@�@�����v(�ی����t�z)
    //     setValue(main.x17.total, BENEFIT);

    // �@�@�����v(���p�ҕ��S(�ی��Ώە�))
    //     setValue(main.x18.total, INSURED_INSURANCE_COST);

    // �@�@�����v(���p�ҕ��S(�S�z���S��))
    //     setValue(main.x19.total, INSURED_TOTAL_COST);

    // ���v���F����Ԓ��̒Z���������p����(�n��p�����[�^�̒l��ݒ�)
    // �@���O���܂ł̗��p����
    //     setValue(shortStay.pastMonth.h2, SHORT_STAY_PAST_MONTH);

    // �@�������̌v�旘�p����
    //     setValue(shortStay.thisMonth.h2, SHORT_STAY_THIS_MONTH);

    // �@���ݐϗ��p����
    //     setValue(shortStay.totalDays.h2, SHORT_STAY_TOTAL_DAYS);


    //�y�[�W�I��
    writer.endPageEdit();
    //TODO ��������s�����Ȃ��true��Ԃ��B
    return true;
  }

  //�����֐�

  /**
   * �u�\���f�[�^�W�v�֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public VRList tabulation(VRList serviceData, VRList printList, VRMap footerMap) throws Exception{
    // ���W�v�N���X���瑗���Ă����W�v��f�[�^������p�ɏW�v
    // �������ϐ���`
    // �@���[�v���A1�O�ɏ����������R�[�h�B
    VRMap recordOld = new VRHashMap();
    // �@���[�v���A���񏈗�����f�[�^�B
    VRMap recordNow = new VRHashMap();
    // �@���v�l��~�ς��邽�߂̃��R�[�h�B
    VRMap subTotal = new VRHashMap();
    // �@�񋟕[�ʕ\�ŁA�Ώۂ̎��Ə��ȊO�̎��Ə��̃��R�[�h�̒l��~�ς��邽�߂̃��R�[�h�B
    VRMap anotherProvider = new VRHashMap();
    // �@���x�Ǘ��ΏۊO�̃��R�[�h����~�ς��邽�߂̃��R�[�h�W���B
    VRList excludeLimit = new VRArrayList();
    // �@�T�[�r�X�}�X�^�i�[�p�B
    VRList masterService = new VRArrayList();
    // ���T�[�r�X�}�X�^�擾
    // �@masterService�ɁA�V�X�e������擾�����T�[�r�X�}�X�^��ݒ肷��B
//    QkanSystemInformation.getInstance().getMasterService();
    // ���W�v����
    // �@���v�p���R�[�h subTotal ������������B
    initializeRecord(subTotal);

    // �@�ߋ����R�[�h recordOld �Ɍ����R�[�h�W�� serviceData�̍ŏ��̃��R�[�h���㏑����B
    // ���W�v����
    // �@�����R�[�h�W�� serviceData �̌��������[�v����B
    // �@�@�����R�[�h recordNow �Ɍ����R�[�h�W�� serivceData ��N�Ԗڂ̃��R�[�h���㏑����B
    // �@�@�T�[�r�X���Ǘ��Ώۓ����`�F�b�N���邽�߁A�����R�[�h recordNow ��KEY : LIMIT_AMOUNT_OBJECT �� VALUE ���`�F�b�N����B
    // �@�@�@1(�Ώۓ�)�̏ꍇ
    // �@�@�@�@�����R�[�h recordNow �Ɖߋ����R�[�h recordOld �� KEY : PROVIDER_ID �� VALUE ���r����B
    // �@�@�@�@�@�قȂ�ꍇ
    // �@�@�@�@�@�@���v���Z�������s���B
    addSubTotalToPrintList(getPrintList(), getFooterMap(), subTotal, recordNow);

    // �@�@�@�@�@�@���v�����l�ݒ菈�����s���B
    setInitValueToSubTotal(subTotal, recordNow, masterService);

    // �@�@�@�@�@�����ꍇ
    // �@�@�@�@�@�@�����R�[�h recordNow �Ɖߋ����R�[�h recordOld �� KEY : SERVICE_CODE_KIND �� VALUE ���r����B
    // �@�@�@�@�@�@�@�قȂ�ꍇ
    // �@�@�@�@�@�@�@�@���v���Z�������s���B
    addSubTotalToPrintList(getPrintList(), getFooterMap(), subTotal, recordNow);

    // �@�@�@�@�@�@�@�@���v�����l�ݒ菈�����s���B
    setInitValueToSubTotal(subTotal, recordNow, masterService);

    // �@�@�@�@�@���v���Z�������s���B
    addRecordValueToSubTotal(subTotal, recordNow);

    // �@�@�@�@�@����p���R�[�h�W�� printList �Ɍ����R�[�h recordNow ��ǉ�����B(�p�^�[��A)
    addRecordToPrintListPatternA(getPrintList(), recordNow);

    // �@�@�@2(�ΏۊO)�̏ꍇ
    // �@�@�@�@�ΏۊO�p���R�[�h�W�� excludeLimit �Ɍ����R�[�h recordNow ��ǉ�����B
    // �@�@�ߋ����R�[�h recordOld �Ɍ����R�[�h recordNow ���㏑����B
    // ���v���Z�������s���B
    addSubTotalToPrintList(getPrintList(), getFooterMap(), subTotal, recordNow);

    // ����p���R�[�h�W�� printList �ɑΏۊO���R�[�h�W�� excludeList ��ǉ��B(�p�^�[��E)
    addRecordToPrintListPatternE(getPrintList(), excludeLimit);

    // �t�b�^�[���R�[�h footerMap �� �ΏۊO���R�[�h�W�� excludeList �����Z����B
    addExcludeValueToFooter(getFooterMap(), excludeLimit);

return null;
  }

  /**
   * �u���R�[�h�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initializeRecord(VRMap rec) throws Exception{
    // �����R�[�h������
    // �@rec�� KEY / VALUE ��S��remove����B
    // �@rec�ɉ��L�̒l��ݒ肷��B
    // �@�@KEY : PROVIDER_NAME          , VALUE : ""
    // �@�@KEY : PROVIDER_ID            , VALUE : ""
    // �@�@KEY : SERVICE_NAME           , VALUE : ""
    // �@�@KEY : SERVICE_CODE           , VALUE : ""
    // �@�@KEY : UNIT                   , VALUE : 0
    // �@�@KEY : REDUCTION_RATE         , VALUE : 0
    // �@�@KEY : REDUCTION_UNIT         , VALUE : 0
    // �@�@KEY : COUNT                  , VALUE : 0
    // �@�@KEY : SERVICE_UNIT_COST      , VALUE : 0
    // �@�@KEY : KUBUN_LIMIT_OVER       , VALUE : 0
    // �@�@KEY : KUBUN_LIMIT_UNDER      , VALUE : 0
    // �@�@KEY : YEN_PER_UNIT           , VALUE : 0
    // �@�@KEY : INSURANCE_FEE          , VALUE : 0
    // �@�@KEY : BENEFIT_RATE           , VALUE : 0
    // �@�@KEY : BENEFIT                , VALUE : 0
    // �@�@KEY : INSURED_INSURANCE_COST , VALUE : 0
    // �@�@KEY : INSURED_TOTAL_COST     , VALUE : 0
    // �@�@KEY : SERVICE_CODE_KIND, VALUE : ""

  }

  /**
   * �u���v�����l�ݒ�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void setInitValueToSubTotal(VRMap subTotal, VRMap recNow, VRList masterService) throws Exception{
    // �����v�����l�ݒ�
    // �@subTotal������������B
    initializeRecord(subTotal);

    // �@�T�[�r�X��ރR�[�h�i�[�p�̕����� serviceCodeKind �𐶐�����B
    String serviceCodeKind = null;
    // �@�T�[�r�X��ޖ��i�[�p�̕����� serviceKindName �𐶐�����B
    String serviceKindName = null;
    // �@serviceCodeKind �� recNow �� KEY : SERVICE_CODE_KIND �� VALUE ��ݒ肷��B
    // �@serviceKindName �� �T�[�r�X��ރR�[�h����擾�����T�[�r�X��ޖ���ݒ肷��B
    getServiceKindName(masterService, serviceCodeKind);

    // �@subTotal �� recNow �̉��L KEY �� VALUE ��ݒ肷��B
    // �@�@PROVIDER_NAME
    // �@�@PROVIDER_ID
    // �@�@YEN_PER_UNIT
    // �@�@BENEFIT_RATE
    // �@�@SERVICE_CODE_KIND
    // �@subTotal �� ���L�̒l��ݒ肷��B
    // �@�@KEY : SERVICE_NAME, VALUE : (serviceKindName + "�v")
    // �@�@KEY : INIT, VALUE : 1

  }

  /**
   * �u���v���Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void addRecordValueToSubTotal(VRMap subTotal, VRMap recNow) throws Exception{
    // �����v���Z����
    // �@subTotal �� recNow �̉��L KEY �� VALUE �����Z����B(VALUE ���m�𐔒l�ɃL���X�g���đ����Z����B)
    // �@�@SERVICE_UNIT_COST
    // �@�@KUBUN_LIMIT_OVER
    // �@�@KUBUN_LIMIT_UNDER
    // �@�@INSURANCE_FEE
    // �@�@BENEFIT
    // �@�@INSURED_INSURANCE_COST
    // �@�@INSURED_TOTAL_COST
    // �@subTotal �� ���L�̒l��ݒ肷��B
    // �@�@KEY : INIT, VALUE : 0

  }

  /**
   * �u�t�b�^�[���Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void addRecordValueToFooter(VRMap footerMap, VRMap rec) throws Exception{
    // ���t�b�^�[�ɒl�����Z����B
    // �@footerMap �� recNow �̉��L KEY �� VALUE �����Z����B(VALUE ���m�𐔒l�ɃL���X�g���đ����Z����B)
    // �@�@SERVICE_UNIT_COST
    // �@�@KUBUN_LIMIT_OVER
    // �@�@KUBUN_LIMIT_UNDER
    // �@�@INSURANCE_FEE
    // �@�@BENEFIT
    // �@�@INSURED_INSURANCE_COST
    // �@�@INSURED_TOTAL_COST

  }

  /**
   * �u�t�b�^�[���Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void addExcludeValueToFooter(VRMap footerMap, VRList list) throws Exception{
    // ���t�b�^�[�Ɍ��x�z�Ǘ��ΏۊO���̒l�𑫂�(�T�[�r�X�P��/���z�A�敪�x�����x����P�ʐ��͑����Ȃ�)
    // �@list �̔C�ӂ̃��R�[�h�i�[�p�̃��R�[�h rec �𐶐�����B
    VRMap rec = new VRHashMap();
    // �@list �̌��������[�v����B
    // �@�@rec �� list ��n�Ԗڂ̃��R�[�h��ݒ肷��B
    // �@�@footerMap �� rec �̉��L KEY �� VALUE �����Z����B(VALUE ���m�𐔒l�ɃL���X�g���đ����Z����B)
    // �@�@�@INSURANCE_FEE
    // �@�@�@BENEFIT
    // �@�@�@INSURED_INSURANCE_COST

  }

  /**
   * �u���v���Z�����v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void addSubTotalToPrintList(VRList printList, VRMap footerMap, VRMap subTotal, VRMap recNow) throws Exception{
    // �����v���Z����
    // �@subTotal �� KEY : INIT �� VALUE ���`�F�b�N����B
    // �@�@0�̏ꍇ
    // �@�@�@�������p������B
    // �@�@1�̏ꍇ
    // �@�@�@�����𒆒f����B
    // �@subTotal �̌������`�F�b�N����B
    // �@�@1���݂̂̏ꍇ
    // �@�@�@printList �� subTotal ��ǉ�����B(�ǉ��p�^�[��C)
    addRecordToPrintListPatternC(getPrintList(), subTotal);

    // �@�@�@footerMap �� subTotal �����Z����B
    addRecordValueToFooter(getFooterMap(), subTotal);

    // �@�@����������ꍇ
    // �@�@�@printList �� recNow ��ǉ�����B(�ǉ��p�^�[��B)
    addRecordToPrintListPatternB(getPrintList(), recNow);

    // �@�@�@footerMap �� recNow �����Z����B
    addRecordValueToFooter(getFooterMap(), recNow);


  }

  /**
   * �u����p���R�[�h�W���ւ̃��R�[�h�ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void addRecordToPrintListPatternA(VRList printList, VRMap rec) throws Exception{
    // ������p���R�[�h�W���Ɍ����R�[�h��ǉ�
    // �@�ϊ������f�[�^�i�[�p���R�[�h�Ƃ��� printMap �𐶐�����B
    VRMap printMap = new VRHashMap();
    // �@printMap�ɉ��L�̒l��ݒ肷��B
    // �@�@KEY : PROVIDER_NAME          , VALUE : (rec �� KEY : PROVIDER_NAME �� VALUE)
    // �@�@KEY : PROVIDER_ID            , VALUE :  (rec �� KEY : PROVIDER_ID �� VALUE)
    // �@�@KEY : SERVICE_NAME           , VALUE :  (rec �� KEY : SERVICE_NAME �� VALUE)
    // �@�@KEY : SERVICE_CODE           , VALUE :  (rec �� KEY : SERVICE_CODE �� VALUE)
    // �@�@KEY : UNIT                   , VALUE : (rec �� KEY : UNIT �� VALUE)
    // �@�@KEY : REDUCTION_RATE         , VALUE : (rec �� KEY : REDUCTION_RATE �� VALUE�B�������A0�Ȃ��)
    // �@�@KEY : REDUCTION_UNIT         , VALUE : (rec �� KEY : REDUCTION_UNIT �� VALUE�B�������A0�Ȃ��)
    // �@�@KEY : COUNT                  , VALUE : (rec �� KEY : COUNT �� VALUE)
    // �@�@KEY : SERVICE_UNIT_COST      , VALUE : (rec �� KEY : SERVICE_UNIT_COST �� VALUE)
    // �@�@KEY : KUBUN_LIMIT_OVER       , VALUE : ""
    // �@�@KEY : KUBUN_LIMIT_UNDER      , VALUE : ""
    // �@�@KEY : YEN_PER_UNIT           , VALUE : ""
    // �@�@KEY : INSURANCE_FEE          , VALUE : ""
    // �@�@KEY : BENEFIT_RATE           , VALUE : ""
    // �@�@KEY : BENEFIT                , VALUE : ""
    // �@�@KEY : INSURED_INSURANCE_COST , VALUE : ""
    // �@�@KEY : INSURED_TOTAL_COST     , VALUE : ""
    // �@printList �� printMap ��ǉ�����B

  }

  /**
   * �u����p���R�[�h�W���ւ̃��R�[�h�ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void addRecordToPrintListPatternB(VRList printList, VRMap rec) throws Exception{
    // ������p���R�[�h�W���Ɍ����R�[�h��ǉ�
    // �@�ϊ������f�[�^�i�[�p���R�[�h�Ƃ��� printMap �𐶐�����B
    VRMap printMap = new VRHashMap();
    // �@printMap�ɉ��L�̒l��ݒ肷��B
    // �@�@KEY : PROVIDER_NAME          , VALUE : (rec �� KEY : PROVIDER_NAME �� VALUE)
    // �@�@KEY : PROVIDER_ID            , VALUE :  (rec �� KEY : PROVIDER_ID �� VALUE)
    // �@�@KEY : SERVICE_NAME           , VALUE :  (rec �� KEY : SERVICE_NAME �� VALUE)
    // �@�@KEY : SERVICE_CODE           , VALUE :  (rec �� KEY : SERVICE_CODE �� VALUE)
    // �@�@KEY : UNIT                   , VALUE : (rec �� KEY : UNIT �� VALUE)
    // �@�@KEY : REDUCTION_RATE         , VALUE : (rec �� KEY : REDUCTION_RATE �� VALUE�B�������A0�Ȃ��)
    // �@�@KEY : REDUCTION_UNIT         , VALUE : (rec �� KEY : REDUCTION_UNIT �� VALUE�B�������A0�Ȃ��)
    // �@�@KEY : COUNT                  , VALUE : (rec �� KEY : COUNT �� VALUE)
    // �@�@KEY : SERVICE_UNIT_COST      , VALUE :  (rec �� KEY : SERVICE_UNIT_COST �� VALUE)
    // �@�@KEY : KUBUN_LIMIT_OVER       , VALUE : (rec �� KEY : KUBUN_LIMIT_OVER �� VALUE�B�������A0�Ȃ��)
    // �@�@KEY : KUBUN_LIMIT_UNDER      , VALUE : (rec �� KEY : KUBUN_LIMIT_UNDER �� VALUE)
    // �@�@KEY : YEN_PER_UNIT           , VALUE : (rec �� KEY : YEN_PER_UNIT �� VALUE)
    // �@�@KEY : INSURANCE_FEE          , VALUE : (rec �� KEY : INSURANCE_FEE �� VALUE)
    // �@�@KEY : BENEFIT_RATE           , VALUE : (rec �� KEY : BENEFIT_RATE �� VALUE)
    // �@�@KEY : BENEFIT                , VALUE : (rec �� KEY : BENEFIT �� VALUE)
    // �@�@KEY : INSURED_INSURANCE_COST , VALUE : (rec �� KEY : INSURED_INSURANCE_COST �� VALUE)
    // �@�@KEY : INSURED_TOTAL_COST     , VALUE : (rec �� KEY : INSURED_TOTAL_COST �� VALUE�B�������A0�Ȃ��)
    // �@printList �� printMap ��ǉ�����B

  }

  /**
   * �u����p���R�[�h�W���ւ̃��R�[�h�ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void addRecordToPrintListPatternC(VRList printList, VRMap rec) throws Exception{
    // ������p���R�[�h�W���ɏ��v�p���R�[�h��ǉ�
    // �@�ϊ������f�[�^�i�[�p���R�[�h�Ƃ��� printMap �𐶐�����B
    VRMap printMap = new VRHashMap();
    // �@printMap�ɉ��L�̒l��ݒ肷��B
    // �@�@KEY : PROVIDER_NAME          , VALUE : (rec �� KEY : PROVIDER_NAME �� VALUE)
    // �@�@KEY : PROVIDER_ID            , VALUE :  (rec �� KEY : PROVIDER_ID �� VALUE)
    // �@�@KEY : SERVICE_NAME           , VALUE : (rec �� KEY : SERVICE_NAME �� VALUE)
    // �@�@KEY : SERVICE_CODE           , VALUE :  ""
    // �@�@KEY : UNIT                   , VALUE : ""
    // �@�@KEY : REDUCTION_RATE         , VALUE : ""
    // �@�@KEY : REDUCTION_UNIT         , VALUE : ""
    // �@�@KEY : COUNT                  , VALUE : ""
    // �@�@KEY : SERVICE_UNIT_COST      , VALUE :  (rec �� KEY : SERVICE_UNIT_COST �� VALUE)
    // �@�@KEY : KUBUN_LIMIT_OVER       , VALUE : (rec �� KEY : KUBUN_LIMIT_OVER �� VALUE�B�������A0�Ȃ��)
    // �@�@KEY : KUBUN_LIMIT_UNDER      , VALUE : (rec �� KEY : KUBUN_LIMIT_UNDER �� VALUE)
    // �@�@KEY : YEN_PER_UNIT           , VALUE : (rec �� KEY : YEN_PER_UNIT �� VALUE)
    // �@�@KEY : INSURANCE_FEE          , VALUE : (rec �� KEY : INSURANCE_FEE �� VALUE)
    // �@�@KEY : BENEFIT_RATE           , VALUE : (rec �� KEY : BENEFIT_RATE �� VALUE)
    // �@�@KEY : BENEFIT                , VALUE : (rec �� KEY : BENEFIT �� VALUE)
    // �@�@KEY : INSURED_INSURANCE_COST , VALUE : (rec �� KEY : INSURED_INSURANCE_COST �� VALUE)
    // �@�@KEY : INSURED_TOTAL_COST     , VALUE : (rec �� KEY : INSURED_TOTAL_COST �� VALUE�B�������A0�Ȃ��)
    // �@printList �� printMap ��ǉ�����B

  }

  /**
   * �u����p���R�[�h�W���ւ̃��R�[�h�ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void addRecordToPrintListPatternD(VRList printList, VRMap rec) throws Exception{
    // ������p���R�[�h�W���ɂ��̑����Ə����R�[�h��ǉ�
    // �@�ϊ������f�[�^�i�[�p���R�[�h�Ƃ��� printMap �𐶐�����B
    VRMap printMap = new VRHashMap();
    // �@printMap�ɉ��L�̒l��ݒ肷��B
    // �@�@KEY : PROVIDER_NAME          , VALUE : "�����Ə�"
    // �@�@KEY : PROVIDER_ID            , VALUE :  ""
    // �@�@KEY : SERVICE_NAME           , VALUE :  "�����Ə��v"
    // �@�@KEY : SERVICE_CODE           , VALUE :  ""
    // �@�@KEY : UNIT                   , VALUE : ""
    // �@�@KEY : REDUCTION_RATE         , VALUE : ""
    // �@�@KEY : REDUCTION_UNIT         , VALUE : ""
    // �@�@KEY : COUNT                  , VALUE : ""
    // �@�@KEY : SERVICE_UNIT_COST      , VALUE : "(" + (rec �� KEY : SERVICE_UNIT_COST �� VALUE) + ")"
    // �@�@KEY : KUBUN_LIMIT_OVER       , VALUE : (rec �� KEY : KUBUN_LIMIT_OVER �� VALUE�B�������A0�Ȃ��)
    // �@�@KEY : KUBUN_LIMIT_UNDER      , VALUE : (rec �� KEY : KUBUN_LIMIT_UNDER �� VALUE)
    // �@�@KEY : YEN_PER_UNIT           , VALUE : ""
    // �@�@KEY : INSURANCE_FEE          , VALUE : (rec �� KEY : INSURANCE_FEE �� VALUE)
    // �@�@KEY : BENEFIT_RATE           , VALUE : ""
    // �@�@KEY : BENEFIT                , VALUE : (rec �� KEY : BENEFIT �� VALUE)
    // �@�@KEY : INSURED_INSURANCE_COST , VALUE : (rec �� KEY : INSURED_INSURANCE_COST �� VALUE)
    // �@�@KEY : INSURED_TOTAL_COST     , VALUE : (rec �� KEY : INSURED_TOTAL_COST �� VALUE�B�������A0�Ȃ��)
    // �@printList �� printMap ��ǉ�����B

  }

  /**
   * �u����p���R�[�h�W���ւ̃��R�[�h�ǉ��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void addRecordToPrintListPatternE(VRList printList, VRList recList) throws Exception{
    // ������p���R�[�h�W���ɑΏۊO�p���R�[�h�W����ǉ�
    // �@�ϊ������f�[�^�i�[�p���R�[�h�Ƃ��� printMap �𐶐�����B
    VRMap printMap = new VRHashMap();
    // �@recList ��n�Ԗڂ̃��R�[�h�i�[�p�̃��R�[�h rec �𐶐�����B
    VRMap rec = new VRHashMap();
    // �@recList �̌��������[�v����B
    // �@�@rec �� recList ��n�Ԗڂ̃��R�[�h��ݒ肷��B
    // �@�@printMap�ɉ��L�̒l��ݒ肷��B
    // �@�@�@KEY : PROVIDER_NAME          , VALUE : (rec �� KEY : PROVIDER_NAME �� VALUE)
    // �@�@�@KEY : PROVIDER_ID            , VALUE :  (rec �� KEY : PROVIDER_ID �� VALUE)
    // �@�@�@KEY : SERVICE_NAME           , VALUE :  (rec �� KEY : SERVICE_NAME �� VALUE)
    // �@�@�@KEY : SERVICE_CODE           , VALUE :  (rec �� KEY : SERVICE_CODE �� VALUE)
    // �@�@�@KEY : UNIT                   , VALUE : (rec �� KEY : UNIT �� VALUE)
    // �@�@�@KEY : REDUCTION_RATE         , VALUE : ""
    // �@�@�@KEY : REDUCTION_UNIT         , VALUE : ""
    // �@�@�@KEY : COUNT                  , VALUE : ""
    // �@�@�@KEY : SERVICE_UNIT_COST      , VALUE : "(" + (rec �� KEY : SERVICE_UNIT_COST �� VALUE) + ")"
    // �@�@�@KEY : KUBUN_LIMIT_OVER       , VALUE : ""
    // �@�@�@KEY : KUBUN_LIMIT_UNDER      , VALUE : "(" + (rec �� KEY : KUBUN_LIMIT_UNDER �� VALUE) + ")"
    // �@�@�@KEY : YEN_PER_UNIT           , VALUE : ""
    // �@�@�@KEY : INSURANCE_FEE          , VALUE : (rec �� KEY : INSURANCE_FEE �� VALUE)
    // �@�@�@KEY : BENEFIT_RATE           , VALUE : ""
    // �@�@�@KEY : BENEFIT                , VALUE : (rec �� KEY : BENEFIT �� VALUE)
    // �@�@�@KEY : INSURED_INSURANCE_COST , VALUE : (rec �� KEY : INSURED_INSURANCE_COST �� VALUE)
    // �@�@�@KEY : INSURED_TOTAL_COST     , VALUE : (rec �� KEY : INSURED_TOTAL_COST �� VALUE�B�������A0�Ȃ��)
    // �@�@printList �� printMap ��ǉ�����B

  }

  /**
   * �u�T�[�r�X��ޖ��擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public String getServiceKindName(VRList masterService, String kindCode) throws Exception{
    // ���T�[�r�X��ރR�[�h����T�[�r�X��ޖ����擾
    // �@masterService �̔C�ӂ�1���R�[�h�i�[�p�� mSvcMap �𐶐�����B
    VRMap mSvcMap = new VRHashMap();
    // �@masterService�̌��������[�v����B
    // �@�@mSvcMap �� masterService ��n�Ԗڂ̃��R�[�h��ݒ肷��B
    // �@�@kindCode �� mSvcMap �� KEY : SERVICE_CODE_KIND �� VALUE ���r����B
    // �@�@�@�������ꍇ
    // �@�@�@�@mSvcMap �� KEY : SERIVCE_KIND_NAME �� VALUE ��߂�l�Ƃ��ĕԂ��B
    // �@�@�@�������Ȃ��ꍇ
    // �@�@�@�@���[�v���p������B
    // �@�߂�l�Ƃ��ċ�("")��Ԃ��B
return null;
  }

}
