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
 * �쐬��: 2006/02/23  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�ԃT�[�r�X�v��\ (QS001P01)
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
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
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
 * �T�ԃT�[�r�X�v��\(QS001P01) ���[��`�̃t�@�C���� �F QS001P01.xml
 */
public class QS001P01 extends QS001P01Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QS001P01() {
    }

    /**
     * ���[�𐶐����܂��B
     * 
     * @param writer ����Ǘ��N���X
     * @param printParam ����p�����^
     * @throws Exception ������O
     */
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam)
            throws Exception {
        // �K�v�ł���Β��[ID�����������邱�ƁB
        ACChotarouXMLUtilities.addFormat(writer, "QS001P01", "QS001P01.xml");
        // �y�[�W�J�n
        writer.beginPageEdit("QS001P01");
        // �����p�Ҏ����̐ݒ�
        // ���p�Ҏ�����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME",
                "patient.h1.patientName");
        // �����p�Ҕԍ��̐ݒ�
        // ���p�Ҕԍ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_CODE",
                "patient.h1.patientID");
        // ���쐬�N�����̐ݒ�
        // �n��p�����[�^�� KEY : CREATE_DATE �� VALUE(���t) ���擾����B
        Object obj = printParam.get("CREATE_DATE");
        // �쐬�N�����̔N��ݒ肷��B
        // setValue(createYear, (�쐬�N�����̔N));

        // �쐬�N�����̌���ݒ肷��B
        // setValue(createMonth, (�쐬�N�����̌�));

        // �쐬�N�����̓���ݒ肷��B
        // setValue(createDate, (�쐬�N�����̓�));
        if ((!ACTextUtilities.isNullText(obj)) && (obj instanceof Date)) {
            ACChotarouXMLUtilities.setValue(writer, "createDate", "�쐬�N�����F "
                    + ACConstants.FORMAT_FULL_ERA_YMD.format(obj));
        }

        // ���Ώ۔N���̐ݒ�
        // �n��p�����[�^�� KEY : TARGET_DATE �� VALUE(���t) ���擾����B
        obj = printParam.get("TARGET_DATE");
        // �Ώ۔N�����̔N��ݒ肷��B
        // setValue(targetYear, (�Ώ۔N���̔N));

        // �Ώ۔N�����̌���ݒ肷��B
        // setValue(targetMonth, (�Ώ۔N���̌�));
        // �Ώ۔N�����̓���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "targetDate",
                ACConstants.FORMAT_FULL_ERA_YM.format(obj));

        obj = printParam.get("M_SERVICE");
        Map hashedServiceName;
        if (obj instanceof Map) {
            hashedServiceName = (Map) obj;
        } else {
            hashedServiceName = new HashMap();
        }

        obj = printParam.get("WEEKLY_SERVICE");
        if (obj instanceof List) {
            // ���T�P�ʂ̃T�[�r�X�ݒ�̏���
            String[][] serviceNameTable = new String[8][48];
            int[][] serviceCountTable = new int[8][48];
            List list = (List) obj;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Map service = (Map) it.next();
                // �n��p�����[�^�� KEY : WEEKLY_SERVICE �� VALUE(���R�[�h�z��)
                // ���擾���A���R�[�h�z��weeklyServiceArray�Ɋi�[����B
                // �O���b�h��̐���\�����l�z�� lineMatrix (384 = 48 �~ 8)�𐶐����A0�ŏ���������B
                // �O���b�h��̕�����\��������z�� captionMatrix (384 = 48 �~
                // 8)�𐶐����A""(�����Ȃ�)�ŏ���������B
                // weeklyServiceArray�̌��������[�v����B
                // �T�[�r�X�����j���`���j���̊Ԃ̃T�[�r�X�̏ꍇ
                // ���R�[�hweeklyServiceMap��weeklyServiceArray��n�Ԗڂ̃��R�[�h���i�[����B
                // ���t�^�ϐ�startTime��weeklyServiceMap�̊J�n���Ԃ��i�[����B
                // ���l�^�ϐ�startTimeIndex��startTime����j��4:00��0�Ƃ���30���P�ʂ̒l��ݒ肷��B
                // ���P�ʂ̃C���f�b�N�X�i�[�p�̐��l�ϐ� daylyIndex �𐶐����A�J�n���Ԃ̃C���f�b�N�X���i�[����B
                // convertToDaylyIndex((�J�n����));

                // startTimeIndex = �j�� * 48 + idx
                // ���P�ʂ̃C���f�b�N�X�i�[�p�̐��l�ϐ� daylyIndex �ɁA�I�����Ԃ̃C���f�b�N�X���i�[����B
                // convertToDaylyIndex((�I������));

                // endTimeIndex = �j�� * 48 + idx - 1
                // �T�[�r�X���u��ȓ��퐶����̊����v�̏ꍇ
                // ���R�[�hweeklyServiceMap��weeklyServiceArray��n�Ԗڂ̃��R�[�h���i�[����B
                // ���t�^�ϐ�startTime��weeklyServiceMap�̊J�n���Ԃ��i�[����B
                // ���l�^�ϐ�startTimeIndex��startTime����j��4:00��0�Ƃ���30���P�ʂ̒l��ݒ肷��B
                // ���P�ʂ̃C���f�b�N�X�i�[�p�̐��l�ϐ� daylyIndex �𐶐����A�J�n���Ԃ̃C���f�b�N�X���i�[����B
                // convertToDaylyIndex((�J�n����));

                // startTimeIndex = 7 * 48 + idx
                // ���P�ʂ̃C���f�b�N�X�i�[�p�̐��l�ϐ� daylyIndex �ɁA�I�����Ԃ̃C���f�b�N�X���i�[����B
                // convertToDaylyIndex((�I������));

                // endTimeIndex = 7 * 48 + idx - 1
                // startTimeIndex ���� endTimeIndex�܂Ń��[�v����B
                // lineMatrix( i )�̒l��1���₷�B
                // captionMatrix( i )���`�F�b�N����B
                // �󔒂̏ꍇ
                // captionMatrix( i )�ɃT�[�r�X���̂�ݒ肷��B
                // �󔒂łȂ��ꍇ
                // captionMatrix( i + 1 )�ɃT�[�r�X���̂�ݒ肷��B�������Ai + 1���󔒂łȂ��ꍇ�� i +
                // 2�ɁA�c�Ƃ����ӂ��ɁA�󂢂Ă���
                // �Ƃ���ɃT�[�r�X���̂��i�[����B

                // �T�[�r�X����
                String serviceName;
                obj = hashedServiceName.get(service
                        .get("SYSTEM_SERVICE_KIND_DETAIL"));
                if (obj instanceof Map) {
                    serviceName = ACCastUtilities.toString(((Map) obj)
                            .get("SERVICE_CALENDAR_ABBREVIATION"));
                } else {
                    serviceName = "�H";
                }

                // �J�n�E�I������
                Date begin = ACCastUtilities.toDate(service.get("3"), null);
                Date end = ACCastUtilities.toDate(service.get("4"), null);
                if (begin == null) {
                    // �J�n�����s�ڂ�0������
                    begin = ACDateUtilities.createTime(0, 0);
                }
                if (end == null) {
                    end = ACDateUtilities.addMinute(begin, 1);
                }
                // �j��
                int wday;
                if (CareServiceCommon.isDailyAction(service)) {
                    // ��ȓ��퐶����̊���
                    wday = 7;
                } else {
                    wday = ACCastUtilities.toInt(service.get("WEEK_DAY"), 0);
                    if ((wday == QkanConstants.SERVICE_WEEK_DAY_SUNDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_SUNDAY_PM
                                    .intValue())) {
                        wday = 0;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_MONDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_MONDAY_PM
                                    .intValue())) {
                        wday = 1;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_TUESDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_TUESDAY_PM
                                    .intValue())) {
                        wday = 2;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_WEDNESDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_WEDNESDAY_PM
                                    .intValue())) {
                        wday = 3;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_THURSDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_THURSDAY_PM
                                    .intValue())) {
                        wday = 4;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_FRIDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_FRIDAY_PM
                                    .intValue())) {
                        wday = 5;
                    } else if ((wday == QkanConstants.SERVICE_WEEK_DAY_SATURDAY_AM
                            .intValue())
                            || (wday == QkanConstants.SERVICE_WEEK_DAY_SATURDAY_PM
                                    .intValue())) {
                        wday = 6;
                    } else {
                        wday = 7;
                    }
                }

                int beginRow = ACDateUtilities.getHourOfDay(begin) * 2
                        + ACDateUtilities.getMinute(begin) / 30;
                int endMinute = ACDateUtilities.getMinute(end);
                int endRow = ACDateUtilities.getHourOfDay(end) * 2
                        + endMinute / 30;
                if(endMinute%30==0){
                    endRow--;
                }

                // �T�[�r�X�񋟎��ԑт̉��Z
                if (beginRow <= endRow) {
                    for (int i = beginRow; i <= endRow; i++) {
                        serviceCountTable[wday][i]++;
                    }
                } else {
                    // 0���܂���
                    for (int i = beginRow; i <= 47; i++) {
                        serviceCountTable[wday][i]++;
                    }
                    for (int i = 0; i <= endRow; i++) {
                        serviceCountTable[wday][i]++;
                    }
                }

                String name = serviceNameTable[wday][beginRow];
                if (name == null) {
                    // ���̎��ԑэŏ��̃T�[�r�X��
                    name = serviceName;
                } else if (name.indexOf(serviceName) < 0) {
                    // ���̎��ԑтł͐V�K�ȃT�[�r�X��
                    name += "," + serviceName;
                }
                serviceNameTable[wday][beginRow] = name;
            }
            // ���T�P�ʂ̃T�[�r�X�̐ݒ�
            // �T�ԕ\�̗��\�����l�ϐ� col ���`����B
            // �T�ԕ\�̍s��\�����l�ϐ� row ���`����B
            // 0 ���� 383 �܂Ń��[�v����B(�J�E���^�� i �Ƃ���B383 = 48 �~ 8 - 1)
            // �O���b�h��̈ʒu����肷�邽�߁A���L�̌v�Z���s���B
            // col = i % 48
            // row = i / 48
            // captionMatrix( i )�̒l���`�F�b�N����B�������A(col)�A(row)�͉��L�̕�����Ƃ���B
            // (col) : w + col�̒l
            // (row) : h + row�̒l
            // �󔒂̏ꍇ
            // �������Ȃ��B
            // �󔒂łȂ��ꍇ
            // �O���b�h��̃Z��week.(col).(row)��captionMatrix( i )�̕������ݒ肷��B
            // setValue(week.(col).(row), captionMatrix(i));

            // lineMatrix( i )�̒l�ɉ����āA�ҏW�Z���̔w�i�F��`�悷��B�������A(col)�A(row)�͉��L�̕�����Ƃ���B
            // (col) : l + col�̒l
            // (row) : h + row�̒l
            // 0�̏ꍇ
            // �w�i�F�͕`�悵�Ȃ��B
            // 1�̏ꍇ
            // �w�i�F��#cccccc�Ƃ���B
            // 2�̏ꍇ
            // �w�i�F��#999999�Ƃ���B
            // 3�ȏ�̏ꍇ
            // �w�i�F��#666666�Ƃ���B

            int colEnd = serviceNameTable.length;
            if (colEnd > 0) {
                final String oneColor = "#CCCCCC";
                final String twoColor = "#999999";
                final String manyColor = "#666666";

                int rowEnd = serviceNameTable[0].length;
                for (int col = 0; col < colEnd; col++) {
                    for (int row = 0; row < rowEnd; row++) {
                        if (!ACTextUtilities
                                .isNullText(serviceNameTable[col][row])) {
                            // �T�[�r�X������łȂ��ꍇ
                            ACChotarouXMLUtilities.setValue(writer, "week.h"
                                    + row + ".w" + col,
                                    serviceNameTable[col][row]);
                        }
                        String fillColor;
                        int count = serviceCountTable[col][row];
                        if (count == 1) {
                            // 1�̏ꍇ
                            // �w�i�F��#cccccc�Ƃ���B
                            fillColor = oneColor;
                        } else if (count == 2) {
                            // 2�̏ꍇ
                            // �w�i�F��#999999�Ƃ���B
                            fillColor = twoColor;
                        } else if (count > 2) {
                            // 3�ȏ�̏ꍇ
                            // �w�i�F��#666666�Ƃ���B
                            fillColor = manyColor;
                        } else {
                            continue;
                        }
                        ACChotarouXMLUtilities.setFillColor(writer, "week.h"
                                + row + ".l" + col, fillColor);
                    }
                }
            }
        }

        // ���T�P�ʈȊO�̃T�[�r�X�̐ݒ�
        obj = printParam.get("NON_WEEKLY_SERVICE");
        if (obj instanceof List) {
            // �n��p�����[�^�� KEY : NON_WEEKLY_SERVICE �� VALUE(���R�[�h�z��)
            // ���擾���A���R�[�h�z��nonWeeklyServiceArray�Ɋi�[����B
            // nonWeeklyServiceArray�̌��������[�v����B
            // ���L�t�H�[�}�b�g�̕�����𐶐�����B
            // �����e<����> �J�n���F<�J�n��> �I�����F<�I����>
            // <����>�̓T�[�r�X�̗���
            // <�J�n��>�̓T�[�r�X�̊J�n��(�u�恛���j���v��u�����v�Ȃ�)
            // <�I����>�̓T�[�r�X�̊J�n��(�u�恛���j���v��u�����v�Ȃ�)
            // ����������������u �v(�X�y�[�X)�ŘA������B
            // �A�������������\�����ɐݒ肷��B
            // setValue(nonWeek.w2.h1, (�A������������));
            StringBuffer freedays = new StringBuffer();
            List list = (List) obj;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Map service = (Map) it.next();
                // �T�[�r�X����
                String serviceName;
                obj = hashedServiceName.get(service
                        .get("SYSTEM_SERVICE_KIND_DETAIL"));
                if (obj instanceof Map) {
                    serviceName = ACCastUtilities.toString(((Map) obj)
                            .get("SERVICE_CALENDAR_ABBREVIATION"));
                } else {
                    serviceName = "�H";
                }

                if (freedays.length() > 0) {
                    //2�ڈȏ�
                    freedays.append("�@");
                }
                freedays.append("�����e�F");
                freedays.append(serviceName);
                //�J�n��
                freedays.append(" �J�n���F");
                freedays.append(QkanNonWeeklyServiceBeginFormat.getInstance().format(service
                        .get("WEEK_DAY")));
                //����
                freedays.append(" ���ԁF");
                freedays.append(QkanNonWeeklyServiceSpanFormat.getInstance().format(service
                        .get(QkanConstants.SERVICE_SYSTEM_BIND_PATH_SPAN)));
            }

            ACChotarouXMLUtilities.setValue(writer, "nonWeek.h1.w2", freedays
                    .toString());
        }

        // �y�[�W�I��
        writer.endPageEdit();
        //  ��������s�����Ȃ��true��Ԃ��B
        return true;
    }

}
