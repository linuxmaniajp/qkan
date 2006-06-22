
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
 * �쐬��: 2005/12/12  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X ���p�[ (003)
 * �v���O���� ���p�[ (QS00301)
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
 * ���p�[(QS00301) 
 * ���[��`�̃t�@�C���� �F 
 */
public class QS003P01 extends QS003P01Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS003P01(){
  }

  /**
   * ������܂��B
   * @param writer ����Ǘ��N���X
   * @param printParam ����p�����^
   * @throws Exception ������O
   */
  public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception {
    //�Ăяo�����Ƃōs�Ȃ�����������
    //ACChotarouXMLWriter writer = new ACChotarouXMLWriter();
    //pd.addFormat("mainFormat", ACFrame.getInstance().getExeFolderPath() + ACConstants.FILE_SEPARATOR + "format" + ACConstants.FILE_SEPARATOR + "���p�[");
    //pd.beginPrintEdit();
    //�������Ăяo�����Ƃōs�Ȃ�����
    //TODO �y�[�W�J�n[beginPageEdit("mainFormat")]���Y�ꂸ�ɁB
      // ���\��/���є���
    // �@�n��p�����[�^�� KEY : PROCESS_TYPE �� VALUE ���`�F�b�N����B
    // �@�@PROCESS_TYPE_PLAN�̏ꍇ
    // �@�@�@�ȉ��A�u�T�[�r�X�\��v�̗��p�\����Ƃ��ď�������B
    // �@�@PROCESS_TYPE_RESULT�̏ꍇ
    // �@�@�@�ȉ��A�u�T�[�r�X���сv�̗��p�\����Ƃ��ď�������B
    // ���쐬�N����
    // �@�\�O�̍쐬�N�����Ƃ��āA�n��p�����[�^�� KEY : CREATE_DATE_OUTER ��ݒ肷��B
    // �@�@�N
    //     setValue(createDateOuterYear, (�N));

    // �@�@��
    //     setValue(createDateOuterMonth, (��));

    // �@�@��
    //     setValue(createDateOuterDay, (��));

    // �@�\���̍쐬�N�����Ƃ��āA�n��p�����[�^�� KEY : CREATE_DATE_INNER ��ݒ肷��B
    // �@�@�N
    //     setValue(createDateInnerYear, (�N));

    // �@�@��
    //     setValue(createDateInnerMonth, (��));

    // �@�@��
    //     setValue(createDateInnerDay, (��));

    // �@���[��ޔ��ʂ̂��߁A�n��p�����[�^�� KEY : CHOHYO_TYPE �� VALUE ���`�F�b�N����B
    // �@�@FOR_PATIENT�̏ꍇ
    // �@�@�@���[��ނƂ��āu������x�����Ǝҁ����p�ҁv��ݒ肷��B
    //     setValue(chohyoType.w1.h1, "������x�����Ǝҁ����p��");

    // �@�@FOR_PROVIDER�̏ꍇ
    // �@�@�@���[��ނƂ��āu������x�����Ǝ�(�T)�v��ݒ肷��B
    //     setValue(chohyoType.w1.h1, "������x�����Ǝ�(�T)");

    // ���x�����Ǝҏ��
    // �@���Ǝ҂̏����A�n��p�����[�^ KEY : PROVIDER_ID �� VALUE �����Ɏ擾����B
    // �@�E������x�����ƎҖ�
    // �@�@������x�����ƎҖ���ݒ肷��B
    //     setValue(upper.w23.h1, (���ƎҖ�));

    // �@�E���Ǝғd�b�ԍ� / FAX�ԍ�
    // �@�@���Ǝғd�b�ԍ� / FAX�ԍ��i�[�p������𐶐�����B
    //     setValue(upper.w23.h2, (�d�b�ԍ� / FAX�ԍ�));

    // �@�@�d�b�ԍ����ݒ肳��Ă���ꍇ�A�i�[�p������ɓd�b�ԍ�(������)��ǉ�����B
    // �@�@FAX�ԍ����ݒ肳��Ă���ꍇ�A�i�[�p�������" FAX:" + FAX�ԍ�(������)��ݒ肷��B
    // �@�@���Ǝғd�b�ԍ� / FAX�ԍ���ݒ肷��B
    // �@�E�S���Җ�
    // �@�@�S���Җ���ݒ肷��B
    ACChotarouXMLUtilities.getInstance().setValue(writer, printParam, "PERSON_IN_CHARGE", "upper.w23.h3");
    // �����p�Ҋ֘A���̐ݒ�
    // �@�Ώۂ̗��p�҂̏����A�n��p�����[�^�� KEY : PATIENT_ID �� VALUE �����Ɏ擾����B
    // �@���ی��ҏ��
    // �@�@�E�ی��Ҕԍ�
    // �@�@�@�ی��Ҕԍ���separator�ɐݒ肷��B�������A�ԍ��͉E�l�Ƃ���B
    //     setValue(insurerNo, (�ی��Ҕԍ�));

    // �@�@�E�ی��Җ�
    // �@�@�@�ی��Җ���ݒ肷��B
    //     setValue(upper.w15.h1, (�ی��Җ�));

    // �@����ی���(���p��)���
    // �@�@�E�F���/�\����
    // �@�@�@�v���\���̏�Ԃ��`�F�b�N����B
    // �@�@�@�@�u�F��ρv�̏ꍇ
    // �@�@�@�@�@�u�\�����v�̃V�F�C�v���\���ɂ���B
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "requesting");
    // �@�@�@�@�u�\�����v�̏ꍇ
    // �@�@�@�@�@�u�F��ρv�̃V�F�C�v���\���ɂ���B
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "authorized");
    // �@�@�E��ی��Ҕԍ�
    // �@�@�@��ی��Ҕԍ���separator�ɐݒ肷��B�������A�E�l�Ƃ���B
    //     setValue(insuredNo, (��ی��Ҕԍ�));

    // �@�@�E��ی��҃t���K�i
    // �@�@�@��ی��҃t���K�i��ݒ肷��B�������A�t���K�i�͔��p�J�i�Ƃ���B
    //     setValue(upper.w15.h4, (�t���K�i));

    // �@�@�E��ی��Ҏ���
    // �@�@�@��ی��Ҏ�����ݒ肷��B
    //     setValue(upper.w15.h5, (��ی��Ҏ���));

    // �@�@�E�͏o�N����
    // �@�@�@�n��p�����[�^�� KEY : NOTIFICATION_DATE �� VALUE ���擾����B
    // �@�@�@�N��(������) �N
    //     setValue(notificationYear, (�N�� �N));

    // �@�@�@��
    //     setValue(notificationMonth, (��));

    // �@�@�@��
    //     setValue(notificationDay, (��));

    // �@�@�E���p�Ґ��N����
    // �@�@�@�N��(������)
    //     setValue(patientBirthDayEra, (�N��));

    // �@�@�@�N
    //     setValue(patientBirthDayYear, (�N));

    // �@�@�@��
    //     setValue(patientBirthDayMonth, (��));

    // �@�@�@��
    //     setValue(patientBirthDayDay, (��));

    // �@�@�E���p�Ґ���
    // �@�@�@����(������)
    //     setValue(upper.w12.h6, (����));

    // �@�����p�ҁE�v���x���
    // �@�@���v����ԋ敪
    // �@�@�@�v����ԋ敪��ݒ肷��B(�v���x��\���������ݒ肷��)
    //     setValue(upper.w15.h6, (�v����ԋ敪));

    // �@�@���ύX��v����ԋ敪
    // �@�@�@�����ŗv���x���ύX���ꂽ�ꍇ�̂ݍs���B
    // �@�@�@�@�ύX��̗v����ԋ敪���`�F�b�N���A�Y��������̈ȊO�̃V�F�C�v���\���ɂ���B
    // �@�@�@�@�@�v�x��
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo11");
    // �@�@�@�@�@�v���P
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo21");
    // �@�@�@�@�@�v���Q
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo22");
    // �@�@�@�@�@�v���R
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo23");
    // �@�@�@�@�@�v���S
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo24");
    // �@�@�@�@�@�v���T
    ACChotarouXMLUtilities.getInstance().setInvisible(writer, "yokaigodo25");
    // �@�@���v����ԋ敪�ύX��
    // �@�@�@�v����ԋ敪�̕ύX����ݒ肷��B
    // �@�@�@�@�N�� �N
    //     setValue(yokaigodoChangeYear, (�N�� �N));

    // �@�@�@�@��
    //     setValue(yokaigodoChangeMonth, (��));

    // �@�@�@�@��
    //     setValue(yokaigodoChangeDate, (��));

    // �@�@���敪�x�����x��z
    // �@�@�@�敪�x�����x��z��ݒ肷��B�������A����؂�́u,�v�����邱�ƁB
    ACChotarouXMLUtilities.getInstance().setValue(writer, printParam, "LIMIT_AMOUNT_CONTENT", "limitAmountContent");
    // �@�@�����x�z�K�p����(�J�n)
    // �@�@�@���x�z�K�p����(�J�n)��ݒ肷��B
    // �@�@�@�@�N�� �N
    //     setValue(applicationPeriodBeginYear, �N�� �N);

    // �@�@�@�@��
    //     setValue(applicationPeriodBeginMonth, ��);

    // �@�@�����x�z�K�p����(�I��)
    // �@�@�@���x�z�K�p����(�I��)��ݒ肷��B
    // �@�@�@�@�N�� �N
    //     setValue(applicationPeriodEndYear, �N�� �N);

    // �@�@�@�@��
    //     setValue(applicationPeriodEndMonth, ��);

    // ���O���܂ł̒Z���������p��
    // �@�u�O���܂ł̒Z���������p�񐔁v��ݒ肷��B
    // �@�Ώ۔N���Ƃ��āA�n��p�����[�^�� KEY : TARGET_DATE �� VALUE ���擾����B
    ACChotarouXMLUtilities.getInstance().setValue(writer, printParam, "SHORT_STAR_USE_DAY", "shortStayUseDay");
    // ���\�̗j��
    // �@�������猎�̍ŏI���܂ł̗j����ݒ肷��B
    //     setValue((lowerValue.xN.y), (����));

    // �@���j���ȊO�́�(�V�F�C�v)���\���ɂ���B
    //     addAttribute(sundayN);

    // ���񋟏��
    // �@�\���̃f�[�^�i�[�p�̃��R�[�h�W�� serviceData�𐶐�����B
    VRList serviceData = null;
    // �@serviceData�ɁA�n��p�����[�^printParam�� KEY : SERVICE_DATA�@�� VALUE ���i�[����B
    // �@serviceData�̌��������[�v����B
    // �@�@�E�񋟎��ԑ�
    // �@�@�@�񋟎��ԑ�(�J�n)��ݒ肷��B
    //     setValue((lowerHeader.time.row1Upper), (�񋟎��ԑ�(�J�n)));

    // �@�@�@�񋟎��ԑ�(�I��)��ݒ肷��B
    //     setValue((lowerHeader.time.row1Lower), (�񋟎��ԑ�(�I��)));

    // �@�@�E�T�[�r�X���e
    // �@�@�@�T�[�r�X���e��ݒ肷��B
    //     setValue((lowerHeader.service.row1Upper), (�T�[�r�X���e));

    // �@�@�E�T�[�r�X���ƎҎ��ƎҖ�
    // �@�@�@�T�[�r�X���ƎҎ��ƎҖ���ݒ肷��B
    //     setValue((lowerHeader.provider.row1Upper), (�T�[�r�X���ƎҎ��ƎҖ�));

    // �@�@�������猎�̍ŏI���܂Ń��[�v����B
    // �@�@�@�E���ԃT�[�r�X�v��y�ю��т̋L�^
    // �@�@�@�@�\��̏ꍇ
    // �@�@�@�@�@�Y���T�[�r�X�̊Y�����̒񋟉񐔂�ݒ肷��B
    //     setValue((lowerValue.x1.y1), (��));

    // �@�@�@�@���т̏ꍇ
    // �@�@�@�@�@�Y���T�[�r�X�̊Y�����̒񋟉񐔂�ݒ肷��B
    //     setValue((lowerValue.x1.j1), (��));

    // �@�@�@�E����(��)
    // �@�@�@�@�\��̏ꍇ
    // �@�@�@�@�@�Y�����̊Y���T�[�r�X������̏ꍇ�A�u���v������B
    //     setValue((lowerValueTriangle.x1.y1), "��");

    // �@�@�@�@���т̏ꍇ
    // �@�@�@�@�@�Y�����̊Y���T�[�r�X������̏ꍇ�A�u���v������B
    //     setValue((lowerValueTriangle.x1.j1), "��");

    // �@�@�E���v��
    // �@�@�@�\��̏ꍇ
    // �@�@�@�@�Y���T�[�r�X�̒񋟉񐔍��v��ݒ肷��B
    //     setValue((lowerValueTriangle.x1.y1), (���v));

    // �@�@�@���т̏ꍇ
    // �@�@�@�@�Y���T�[�r�X�̒񋟉񐔍��v��ݒ肷��B
    //     setValue((lowerValueTriangle.x1.j1), (���v));


    //TODO �y�[�W�I��[endPageEdit()]���Y�ꂸ�ɁB
    //�Ăяo�����Ƃōs�Ȃ�����������
    //writer.endPrintEdit();
    //ACCommon.getInstance().openPDF(writer);
    //�������Ăяo�����Ƃōs�Ȃ�����
    //TODO ��������s�����Ȃ��true��Ԃ��B
    return true;
  }

}
