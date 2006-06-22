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
 * �쐬��: 2005/12/19  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���[�Ǘ� (C)
 * �v���Z�X �K��Ō�v�揑 (00101)
 * �v���O���� �K��Ō�v�揑 (QC00101)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.ac.util.ACDateUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.VRDateFormat;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �K��Ō�v�揑(QC00101) ���[��`�̃t�@�C���� �F QC00101.xml
 */
public class QC001P01 extends QC001P01Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QC001P01() {
    }

    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam)
            throws Exception {

        VRList list = null;

        // ���_�E������e�[�u���̏����擾
        if (VRBindPathParser.has("PLAN_NOTE", printParam)) {
            list = (VRList) VRBindPathParser.get("PLAN_NOTE", printParam);
        }

        // �������y�[�W���ƍ��ڂ��Z�o
        VRList printNoteDataList = calcPagePrint(list);

        // �������f�[�^�i�[�p�ϐ�
        VRList printList = new VRArrayList();

        ACChotarouXMLUtilities.addFormat(writer, "homonkangoKeikakusyo",
                "QC001P01.xml");

        int allPage = printNoteDataList.size();
        // ���v�y�[�W���ݒ�
        printParam.setData("ALL_PAGE", new Integer(allPage));

        // �������y�[�W�������[�v����
        for (int i = 0; i < printNoteDataList.size(); i++) {

            // 1�y�[�W���̃f�[�^���擾
            printList = (VRList) printNoteDataList.getData(i);

            // ���݂̃y�[�W����ݒ�
            printParam.setData("NOW_PAGE", new Integer(i + 1));

            // 1�y�[�W����
            doPrint(writer, printParam, printList);

        }

        return true;
    }

    /**
     * ���[�𐶐����܂��B
     * 
     * @param writer ����Ǘ��N���X
     * @param printParam ����p�����^
     * @throws Exception ������O
     */
    public void doPrint(ACChotarouXMLWriter writer, VRMap printParam,
            VRList printList) throws Exception {
        // TODO ���[ID��K�v�ɉ�����"mainFormat"����K�؂Ȃ��̂ɏ��������邱�ƁB

        // �y�[�W�J�n
        writer.beginPageEdit("homonkangoKeikakusyo");
        // ���p�Ҏ�����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME",
                "patient1.h2.patientName");
        // �n��p�����[�^printParam�� KEY:PATIENT_BIRTHDAY��VALUE���擾����B
        Date pd = new Date();
        if (VRBindPathParser.has("PATIENT_BIRTHDAY", printParam)) {

            // ���p�Ғa�������擾
            pd = (Date) VRBindPathParser.get("PATIENT_BIRTHDAY", printParam);

        }
        String wareki = VRDateParser.getEra(pd).getAbbreviation(3);
        // �擾�����l��a��ɕϊ�����B
        if ("����".equals(VRDateParser.getEra(pd).getAbbreviation(3))) {
            // �N���ɂ���ĕ��򂷂�B
            // �����̏ꍇ
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
            // �吳�̏ꍇ
        } else if ("�吳".equals(VRDateParser.getEra(pd).getAbbreviation(3))) {
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
            // ���a�̏ꍇ
        } else if ("���a".equals(VRDateParser.getEra(pd).getAbbreviation(3))) {
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
            // �����̏ꍇ
        } else if ("����".equals(VRDateParser.getEra(pd).getAbbreviation(3))) {
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
        } else {
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth1");
            // �u�吳�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth2");
            // �u���a�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth3");
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "patientBirth4");
        }
        // �N��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "patient1.h2.year",
                new Integer(ACDateUtilities.getEraYear(pd)));

        // ����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "patient1.h2.month",
                new Integer(ACDateUtilities.getMonth(pd)));
        // setValue(patient1.month.h);

        // ����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "patient1.h2.day", new Integer(
                ACDateUtilities.getDayOfMonth(pd)));
        // setValue(patient1.day.h);

        // ���p�ҔN���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_AGE",
                "patientAge.h1.w4");
        
        // �v���x
        int jotaiCode = ACCastUtilities.toInt(VRBindPathParser.get("JOTAI_CODE", printParam), 1);        	
        
        switch (jotaiCode) {
        // �n��p�����[�^printParam��KEY:JOTAI_CODE��VALUE�ɂ���ĕ��򂷂�B
        // �u�����v�̏ꍇ
        case 1:
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ��v�x��1��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ��v�x��2��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        case 11:
            // �u�v�x���v�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ��v�x��1��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ��v�x��2��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        case 12:
            // �u�v�x��1�v�̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // ��o�ߓI�v��죂̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // ��v�x��2��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // �����I��
            break;
        case 13:
            // ��v�x��2��̏ꍇ
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // ��o�ߓI�v��죂̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // ��v�x��1��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // �������I������B
            break;

        // �u�v���P�v�̏ꍇ
        case 21:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ��v�x��1��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ��v�x��2��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        // �u�v���Q�v�̏ꍇ
        case 22:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ��v�x��1��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ��v�x��2��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        // �u�v���R�v�̏ꍇ
        case 23:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ��v�x��1��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ��v�x��2��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        // �u�v���S�v�̏ꍇ
        case 24:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ��v�x��1��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ��v�x��2��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        // �u�v���T�v�̏ꍇ
        case 25:
            // �u�����v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // ��v�x��1��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ��v�x��2��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        default:
//            // �u�����v�̃V�F�C�v���\���ɂ���B
//            ACChotarouXMLUtilities.setInvisible(writer, "nursState1");
            // �u�v�x���v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState11");
            // �u�v���P�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState21");
            // �u�v���Q�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState22");
            // �u�v���R�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState23");
            // �u�v���S�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState24");
            // �u�v���T�v�̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState25");
            // ��v�x��1��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState12");
            // ��v�x��2��̃V�F�C�v���\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "nursState13");
            break;

        }
        
        // ���p�ҏZ����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_ADDRESS",
                "patient2.h1.w3");

        // �Ō�E���n�r���e�[�V�����̖ړI��ݒ肷��B
        String purpose = (String) VRBindPathParser.get("PLAN_PURPOSE",
                printParam);

        // 43�������Ƃɋ�؂����z����擾����
        String[] strPurpose = ACTextUtilities.separateLineWrapOnByte(purpose,
                88);
        // �s�����Ƃ̃��X�g�`���ɕϊ�����
        List listPurpose = Arrays.asList(strPurpose);

        StringBuffer sb = new StringBuffer();

        // �s�������[�v����
        for (int i = 0; i < listPurpose.size(); i++) {
            sb.append(listPurpose.get(i));
            // �ŏI�s�̂݉��s��ǉ����Ȃ�
            if (i != listPurpose.size() - 1) {
                sb.append(ACConstants.LINE_SEPARATOR);
            }
        }

        purpose = sb.toString();
        // �ڕW���󎚂���
        ACChotarouXMLUtilities.setValue(writer, "planPurpose", purpose);

        // ���l��ݒ肷��B
        String planComment = (String) VRBindPathParser.get("PLAN_COMMENT",
                printParam);
        // �擾�������l���S�R�������Ƃ�
        String[] strPlanComment = ACTextUtilities.separateLineWrapOnByte(
                planComment, 86);

        List listPlanComment = Arrays.asList(strPlanComment);
        // ������
        sb = new StringBuffer();

        for (int i = 0; i < listPlanComment.size(); i++) {
            sb.append(listPlanComment.get(i));
            // �ŏI�s�ł���ꍇ�͒ǉ����Ȃ�
            if (i != listPlanComment.size() - 1) {
                sb.append(ACConstants.LINE_SEPARATOR);
            }
        }

        planComment = sb.toString();

        ACChotarouXMLUtilities.setValue(writer, "planComment.h2.w2",
                planComment);

        // �n��p�����[�^printParam��KEY:PLAN_NOTES��VALUE (���R�[�h�z��)���擾����B
        // �擾�������R�[�h�z���ݒ肷��B�������A����̏����͉��L�̂Ƃ���Ƃ���B
        // �E
        // �E
        // �E
        // �E
        // �͐ݒ肵�Ȃ��B
        // �E
        // ���łɐݒ肷��B(�Ⴆ�΁A�c��2�s���̋󂫂����Ȃ��Ƃ���ɁA3�s�́u���_�E������v��ݒ肷��ꍇ�A���̕ł�2�s�͋�s�Ƃ��āA
        // ���łɉ��߂āu���_�E������v��ݒ肷��B)
        // �E

        // �n��p�����[�^printParam��KEY:CREATE_DATE��VALUE���擾����B
        VRList chotaList = null;
        chotaList = new VRArrayList();

        int k = 2;
        chotaList = printList;

        // �y�[�W�P�ʂ̃f�[�^����1�N���X���o��
        for (int j = 0; j < chotaList.size(); j++) {

            // �N���X������o�����f�[�^���i�[����B
            PrintData prinData = (PrintData) chotaList.getData(j);

            // ���t���擾����
            Date noteDate = prinData.getNoteDate();

            // �\���p���t�i�[�p�ϐ�
            String formatNoteDate = "";

            // ���t��null�łȂ����`�F�b�N����
            if (null != noteDate) {
                VRDateFormat vf = new VRDateFormat("ggge�NMM��dd��");

                formatNoteDate = vf.format(noteDate);
            }

            // �����s�̃R�����g���擾����
            List recordList = prinData.getNoteComment();

            // ���X�g��̃R�����g���擾����
            // List commentList = (List)recordList.get(0);

            // ���t��
            ACChotarouXMLUtilities.setValue(writer, "note.note" + k + ".ymd",
                    formatNoteDate);

            for (int i = 0; i < recordList.size(); i++) {
                // �s������
                ACChotarouXMLUtilities.setValue(writer, "note.note" + k
                        + ".comment", recordList.get(i));

                // ���[���Y�̈���s���̃J�E���g���{�P
                k++;
            }

        }

        // �擾�����l��a��ɕϊ�����B

        Date createDate = (Date) printParam.getData("CREATE_DATE");

        // �N��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "createDate.h1.w2",
                new Integer(ACDateUtilities.getEraYear(createDate)));
        // setValue(createDate.year.h1);
        // ����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "createDate.h1.w4",
                new Integer(ACDateUtilities.getMonth(createDate)));
        // setValue(createDate.month.h1);

        // ����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "createDate.h1.w6",
                new Integer(ACDateUtilities.getDayOfMonth(createDate)));
        // setValue(createDate.day.h1);

        // �X�e�[�V��������ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "PROVIDER_NAME",
                "station.stationName.value");
        // �Ǘ��Ҏ�����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam,
                "ADMINISTRATOR_NAME", "station.administratorName.value");
        // �厡�㎁����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, printParam, "DOCTOR_NAME",
                "doctor.doctorName.value");

        // ���v�y�[�W������
        ACChotarouXMLUtilities.setValue(writer, printParam, "ALL_PAGE",
                "grdPage.h1.max");
        // ���݂̃y�[�W������
        ACChotarouXMLUtilities.setValue(writer, printParam, "NOW_PAGE",
                "grdPage.h1.now");

        // �y�[�W�I��
        writer.endPageEdit();
        // TODO ��������s�����Ȃ��true��Ԃ��B

        // }

    }

    private VRList calcPagePrint(VRList list) throws Exception {

        // �߂�l���i�[����
        VRList result = new VRArrayList();
        // 1�y�[�W��
        VRList pageList = new VRArrayList();
        // 1���R�[�h��\���N���X
        PrintData pdClass = new PrintData();
        // ���t���i�[����ϐ�
        Date noteDate = new Date();
        // �R�����g���i�[����ϐ�
        String comment = new String();
        // �s�����Ƃɕ��������������ۑ�����z��
        String[] slComment = null;
        // 1���ڂ��ǂ����𔻕ʂ���t���O
        boolean gyouCheckFlag = true;
        // ���v�s�����L�^����ϐ�
        int currentCount = 0;
        // 11�s�ł��邩���ʂ��� 11�s�ł������ꍇ��true
        boolean countOver11 = false;
        // �ŏI�y�[�W�̍s����11�s���x�ł��邩���ʂ��� 11�s�ł������ꍇ��true
        boolean lastPageGyou = false;

        if (list != null) {

            for (int i = 0; i < list.size(); i++) {
                // 1���R�[�h���f�[�^���擾����
                VRMap record = (VRMap) list.getData(i);
                // ���_�E������̃f�[�^���擾����
                comment = String.valueOf(VRBindPathParser.get("NOTE_COMMENT",
                        record));
                // ���_�E������̓��t���擾����
                noteDate = (Date) VRBindPathParser.get("NOTE_DATE", record);
                // ���s�A�K�蕶�����ŋ�؂����z����擾����B
                slComment = ACTextUtilities.separateLineWrapOnByte(comment, 86);

                List sList = Arrays.asList(slComment);

                // �R�����g�̍s��
                int len = sList.size();
                // �ŏI�ǉ������f�p
                // ������
                countOver11 = false;
                // �������g��11�s�ȏ�̏ꍇ
                if (len >= 11) {
                    // 1���ڈȊO�ł������ꍇ
                    if (!gyouCheckFlag) {
                        // 11�s�ł������ꍇ
                        if (!lastPageGyou) {
                            result.add(pageList);
                        }
                    }

                    lastPageGyou = false;

                    int end = len / 11;
                    int lastCount = 0;
                    currentCount = 0;

                    // �N���X�ɒǉ�
                    pdClass.setNoteDate(noteDate);

                    // 11�s�P�ʂŕ���
                    for (int j = 0; j < end; j += 1) {
                        // �V�K�Ő���
                        pageList = new VRArrayList();
                        // �V���ɒǉ�����s����ێ�
                        lastCount += 11;
                        // �N���X�ɒǉ�
                        pdClass
                                .setNoteComment(sList
                                        .subList(j * 11, lastCount));
                        // �V�K��Array�ɒǉ�
                        pageList.add(pdClass);
                        // 11���ǉ�
                        result.add(pageList);
                        // �V�K�Ő���
                        pageList = new VRArrayList();
                        // �N���X������
                        pdClass = new PrintData();

                    }
                    if (len % 11 != 0) {
                        // 11�s�ǉ�������̏���
                        // �c��s����ǉ�
                        pdClass.setNoteComment(sList.subList(lastCount, len));
                        // �N���X�ɒǉ� (1�y�[�W���̃f�[�^�͕ێ�����j
                        pageList.add(pdClass);
                        // �ǉ������s����ێ�(�S����-����)
                        currentCount = len - lastCount;
                        // �N���X������
                        pdClass = new PrintData();
                        lastCount = 0;

                    } else {
                        // ���v��11�s�ɂȂ����ꍇ
                        countOver11 = true;
                        lastPageGyou = true;

                    }
                    // �������g��11�s�ȓ��̏ꍇ
                } else {

                    // �ǉ��s����11�s�ȓ��ł���Βǉ�
                    if (currentCount + len < 11) {
                        pdClass = new PrintData();
                        // �N���X�ɒǉ�
                        pdClass.setNoteComment(sList);
                        pdClass.setNoteDate(noteDate);
                        // 1�y�[�W���̃f�[�^�ɒǉ�
                        pageList.add(pdClass);
                        // �N���X������
                        pdClass = new PrintData();
                        // ������ێ�
                        currentCount += len;
                        // 11�s�ȊO
                        lastPageGyou = false;

                    } else if (currentCount + len == 11) {
                        // �N���X�ǉ�
                        pdClass.setNoteComment(sList.subList(0, len));
                        pdClass.setNoteDate(noteDate);
                        // 1�y�[�W���ǉ�
                        pageList.add(pdClass);
                        // 11�s�ǉ�
                        result.add(pageList);
                        // �V�K�Ő���
                        pageList = new VRArrayList();
                        pdClass = new PrintData();
                        // ������
                        currentCount = 0;
                        // 11�s�ȏ��ێ�
                        // �ŏI�ǉ����Ɏg�p
                        countOver11 = true;
                        lastPageGyou = true;

                        // �ǉ��s����11�s�ȏ�̏ꍇ�́A11�s�ɂȂ�悤�ǉ�
                    } else {
                        // int check = currentCount;
                        // �N���X�̒ǉ�
                        pdClass.setNoteComment(sList.subList(0,
                                11 - currentCount));
                        pdClass.setNoteDate(noteDate);

                        pageList.add(pdClass);
                        // 11�s�ǉ�
                        result.add(pageList);
                        // �V�K�Ő���
                        pageList = new VRArrayList();
                        pdClass = new PrintData();
                        // �ǉ��s���̎Z�o
                        int addLen = 11 - currentCount;
                        // �c��̍s����ǉ�
                        pdClass.setNoteComment(sList.subList(addLen, len));
                        // �y�[�W�ɒǉ�
                        pageList.add(pdClass);
                        // �N���X������
                        pdClass = new PrintData();
                        // �ǉ��s��
                        int nokori = len - addLen;
                        currentCount = nokori;

                    }
                    // �ǉ������s����11�s�ł������ꍇ�͒ǉ������Ȃ�
                    if (!lastPageGyou) {
                        gyouCheckFlag = false;
                    }
                }
                // �ǉ������s����11�s�ł������ꍇ�͒ǉ������Ȃ�
                if (!lastPageGyou) {
                    gyouCheckFlag = false;
                }

            }

            // �ŏI�y�[�W�ǉ�
            // �ǉ��s����11�s�ł���ꍇ�͒ǉ����Ȃ�
            if (!countOver11) {
                // ������
                countOver11 = false;
                // �߂�l�Ƃ��Ēǉ�
                result.add(pageList);
            }
        }
        return result;
    }

    protected class PrintData {

        // �R�����g�̓��t
        private Date noteDate;
        // �����s�̕�����
        private List noteComment;

        Date getNoteDate() {
            return noteDate;
        }

        void setNoteDate(Date noteDate) {
            this.noteDate = noteDate;
        }

        List getNoteComment() {
            return noteComment;
        }

        void setNoteComment(List noteComment) {
            this.noteComment = noteComment;
        }

    }

}
