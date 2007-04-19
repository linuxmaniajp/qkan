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
 * �J����: �c���@����
 * �쐬��: 2006/08/31  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �K��Ō�×{��̎����ҏW (012)
 * �v���O���� �K��Ō�×{��̎��� (QP012P01)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp012;

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
 * �K��Ō�×{��̎���(QP012P01) ���[��`�̃t�@�C���� �F QP012P01.xml
 */
public class QP012P01 extends QP012P01Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP012P01() {
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

        //���[��`�̖�������킷������ϐ�formatName���`���uQP012P01.xml�v�ŏ���������B
        String formatName = "QP012P01.xml";
        
        if(ACCastUtilities.toBoolean(printParam.getData("InnerTaxH1904Mode"), false)){
            //����printParam�̃L�[�uInnerTaxH1904Mode�v�Ő^�U�����擾���A�l���^(true)�̏ꍇ
            //formatName�ɁuQP012P02.xml�v��������B
            formatName = "QP012P02.xml";
        }
        
        
        // 2006/09/26
        // ���z���\���ύX�ɔ����t�H�[�}�b�^��ǉ�
        // Addition - begin [Masahiko Higuchi]
        NumberFormat nf = NumberFormat.getIntegerInstance();
        // Addition - end

        // ����y�[�W�����Z�o����
        pageCalc(printParam);
        // �y�[�W�������������[�v
        for (int i = 0; i <= ACCastUtilities.toInt(printParam
                .getData("LAST_PAGE")) - 1; i++) {

            // �K�v�ł���Β��[ID�����������邱�ƁB
            ACChotarouXMLUtilities
                    .addFormat(writer, "QP012P01", formatName);
            // �y�[�W�J�n
            writer.beginPageEdit("QP012P01");
            // ������������s�Ȃ��B

            // �n��p�����[�^�[�ł���DBManager���擾����B
            if (printParam.getData("DBM") instanceof ACDBManager) {
                ACDBManager dbm = (ACDBManager) printParam.getData("DBM");
                VRMap map = null;
                VRList providerList = QkanCommon.getProviderInfo(dbm,
                        QkanSystemInformation.getInstance()
                                .getLoginProviderID());
                // ���Ə����̎擾
                if (!providerList.isEmpty()) {
                    map = (VRMap) providerList.getData(0);
                }
                // �K��Ō��Ï����擾
                VRList serviceList = (VRArrayList) QkanCommon
                        .getProviderServiceDetail(dbm, QkanSystemInformation
                                .getInstance().getLoginProviderID(), 20101);
                if (!serviceList.isEmpty()) {
                    map.putAll((VRMap) serviceList.getData(0));
                    // 1130103 �Ǘ��Җ�
                }
                ACChotarouXMLUtilities.setValue(writer, map,
                        "PROVIDER_ADDRESS", "provider.h1.w1");
                ACChotarouXMLUtilities.setValue(writer, map, "PROVIDER_NAME",
                        "provider.h2.w1");
                ACChotarouXMLUtilities.setValue(writer, map, "1130103",
                        "provider.h3.w1");

            }

            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_1
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_2
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_3
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_4
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_5
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_6
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_7
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_8
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_9
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_10
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_11
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_12
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_13
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_14
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_15
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_16
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_17
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_18
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_19
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_20
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_21
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_22
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_23
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_24
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_25
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_26
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_27
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_28
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_29
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_30
            // �������\�b�h�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String PROVIDE_DAY_31
            for (int j = 1; j <= 31; j++) {
                convertCalenderData(printParam, "PROVIDE_DAY_" + j);
            }

            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX1
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX2
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX3
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX4
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX5
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX6
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX7
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX8
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX9
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX10
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX11
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX12
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX13
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX14
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX15
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX16
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX17
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX18
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX19
            // �������\�b�h(convertTax)�ɉ��L�̒l�������Ƃ��ēn������p�f�[�^�ɕϊ�����B
            // VRMap printParam String BY_PATIENT_USE_TAX20
            for (int k = 1; k <= 20; k++) {
                //replace-begin 2007/03/10 Tozo Tanaka
                //convertTax(printParam, "BY_PATIENT_USE_TAX" + k);
                if (ACCastUtilities.toInt(VRBindPathParser.get(
                        "BY_PATIENT_TAX_TARGET" + k, printParam), 0) != 0) {
                    //�ېőΏۂ̏ꍇ�̂ݐŋ敪����
                    convertTax(printParam, "BY_PATIENT_USE_TAX" + k);
                }
                //replace-end 2007/03/10 Tozo Tanaka
            }

            // �n��p�����[�^�[ printParam
            // KEY�FPATIENT_NAME
            ACChotarouXMLUtilities.setValue(writer, printParam, "PATIENT_NAME",
                    "basicInfo.h2.w4");
            // �t�H�[�}�b�g����
            VRDateFormat vf = new VRDateFormat("ggge�NM��d��");
            // �n��p�����[�^�[printParam ���� KEY�FBILL_SPAN_START��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "billSpan.h2.w1", vf
                    .format(ACCastUtilities.toDate(printParam
                            .getData("BILL_SPAN_START"))));
            // �n��p�����[�^�[printParam ���� KEY�FBILL_SPAN_END��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "billSpan.h2.w2", vf
                    .format(ACCastUtilities.toDate(printParam
                            .getData("BILL_SPAN_END"))));
            // �n��p�����[�^�[printParam ���� KEY�FBILL_NO��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam, "BILL_NO",
                    "basicInfo.h2.w1");
            // �n��p�����[�^�[printParam ���� KEY�FBILL_PATIENT_CODE��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "BILL_PATIENT_CODE", "basicInfo.h2.w3");
            // �n��p�����[�^�[printParam ���� KEY�FBILL_PRINT_DATE��VALUE���擾���ݒ肷��B
            printParam.setData("PRINT_BILL_PRINT_DATE", ACCastUtilities.toDate(
                    printParam.getData("BILL_PRINT_DATE"), null));
            // ���t�^�������Ă��Ȃ������ꍇ�͋󔒂ŏo�͂���B
            if (printParam.getData("PRINT_BILL_PRINT_DATE") != null) {
                ACChotarouXMLUtilities.setValue(writer, "billInfo.h2.w1", vf
                        .format(ACCastUtilities.toDate(printParam
                                .getData("PRINT_BILL_PRINT_DATE"))));
            } else {
                ACChotarouXMLUtilities.setValue(writer, "billInfo.h2.w1", "");
            }
            // �n��p�����[�^�[printParam ���� KEY�FBY_PATIENT_RATE��VALUE���擾���ݒ肷��B
            printParam.setData("PRINT_BY_PATIENT_RATE", ACCastUtilities.toInt(
                    printParam.getData("BY_PATIENT_RATE"), 0)
                    + "��");
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT_BY_PATIENT_RATE", "billInfo.h2.w2");
            // �n��p�����[�^�[printParam ���� KEY�FSELF_FLAG ��VALUE���擾���ݒ肷��B
            if (printParam.getData("SELF_FLAG") instanceof Integer) {
                // �l�𕶎���ɕϊ�����B
                // 1:�{�l 2:3�� 3:�Ƒ�
                switch (ACCastUtilities.toInt(printParam.getData("SELF_FLAG"))) {
                case 1:
                    printParam.setData("SELF_VALUE", "�{�l");
                    break;
                case 2:
                    printParam.setData("SELF_VALUE", "3��");
                    break;
                case 3:
                    printParam.setData("SELF_VALUE", "�Ƒ�");
                    break;
                default:
                    printParam.setData("SELF_VALUE", "");
                    break;
                }
            }

            ACChotarouXMLUtilities.setValue(writer, printParam, "SELF_VALUE",
                    "billInfo.h2.w3");
            // �n��p�����[�^�[printParam ���� KEY�FBY_PATIENT_RATE��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "BILL_INSURE_TYPE", "billInfo.h2.w4");
            // 1���ڂ̏ꍇ
            if (i == 0) {

                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NAME1��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_PRICE1��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NUMBER1��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_SUM1��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NAME2��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_PRICE2��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NUMBER2��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_SUM2��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NAME3��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_PRICE3��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NUMBER3��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_SUM3��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NAME4��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_PRICE4��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NUMBER4��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_SUM4��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NAME5��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_PRICE5��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NUMBER5��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_SUM5��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NAME6��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_PRICE6��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NUMBER6��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_SUM6��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NAME7��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_PRICE7��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NUMBER7��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_SUM7��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NAME8��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_PRICE8��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NUMBER8��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_SUM8��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NAME9��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_PRICE9��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NUMBER9��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_SUM9��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NAME10��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_PRICE10��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_NUMBER10��VALUE���擾���ݒ肷��B
                // �n��p�����[�^�[printParam ���� KEY�FBY_INSURER_SUM10��VALUE���擾���ݒ肷��B
                int heightCount = 2;
                for (int l = 1; l <= 10; l++) {

                    ACChotarouXMLUtilities.setValue(writer, printParam,
                            "BY_INSURER_NAME" + l, "byInsurer.h" + heightCount
                                    + ".w2");
                    // 2006/09/26
                    // ���z���\���ύX�ɔ����t�H�[�}�b�^��ǉ�
                    // Replace - begin [Masahiko Higuchi]
                    // KEY�����݂���ꍇ�͋��z�\��
                    if (!"".equals(VRBindPathParser.get("BY_INSURER_NAME" + l,
                            printParam))
                            && VRBindPathParser.get("BY_INSURER_NAME" + l,
                                    printParam) != null) {
                        // �l�����͂���Ă��邩�`�F�b�N����B
                        if (!"".equals(VRBindPathParser.get("BY_INSURER_PRICE"
                                + l, printParam))
                                && VRBindPathParser.get("BY_INSURER_PRICE" + l,
                                        printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w3", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_PRICE"
                                                                    + l,
                                                            printParam), 0)));
                        }

                        if (!"".equals(VRBindPathParser.get("BY_INSURER_NUMBER"
                                + l, printParam))
                                && VRBindPathParser.get(
                                        "BY_INSURER_NUMBER" + l, printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w4", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_NUMBER"
                                                                    + l,
                                                            printParam), 0)));
                        }

                        if (!"".equals(VRBindPathParser.get("BY_INSURER_SUM"
                                + l, printParam))
                                && VRBindPathParser.get("BY_INSURER_SUM" + l,
                                        printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w5", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_SUM"
                                                                    + l,
                                                            printParam), 0)));
                        }
                    }
                    // Replace - end [Masahiko Higuchi]

                    // ���ږ��������͂̏ꍇ�͈ꗥ�󎚏������s��Ȃ�
                    if (!"".equals(VRBindPathParser.get("BY_PATIENT_NAME" + l,
                            printParam))
                            && VRBindPathParser.get("BY_PATIENT_NAME" + l,
                                    printParam) != null) {
                        // �n��p�����[�^�[printParam ����
                        // KEY�FBY_PATIENT_NAME1��VALUE���擾���ݒ肷��B

                        // 2006/09/26
                        // ���z���\���ύX�ɔ����t�H�[�}�b�^��ǉ�
                        // Replace - begin [Masahiko Higuchi]

                        ACChotarouXMLUtilities.setValue(writer, printParam,
                                "BY_PATIENT_NAME" + l, "byPatient.h"
                                        + heightCount + ".w2");
                        // �n��p�����[�^�[printParam ����
                        // KEY�FBY_PATIENT_PRICE1��VALUE���擾���ݒ肷��B
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_PRICE"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_PRICE" + l,
                                        printParam) != null) {
                            // ��
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w3", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_PRICE"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // �n��p�����[�^�[printParam ����
                        // KEY�FBY_PATIENT_NUMBER1��VALUE���擾���ݒ肷��B
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_NUMBER"
                                + l, printParam))
                                && VRBindPathParser.get(
                                        "BY_PATIENT_NUMBER" + l, printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w4", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_NUMBER"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // �n��p�����[�^�[printParam ����
                        // KEY�FBY_PATIENT_SUM1��VALUE���擾���ݒ肷��B
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_SUM"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_SUM" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w5", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_SUM"
                                                                    + l,
                                                            printParam), 0)));
                        // �n��p�����[�^�[printParam ����
                        // KEY�FPRINT_BY_PATIENT_USE_TAX1��VALUE���擾���ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, printParam,
                                "PRINT_BY_PATIENT_USE_TAX" + l, "byPatient.h"
                                        + heightCount + ".w6");
                        }
                        // �n��p�����[�^�[printParam ����
                        // KEY�FBY_PATIENT_TAX1��VALUE���擾���ݒ肷��B
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_TAX"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_TAX" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w7", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_TAX"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // Replace - end [Masahiko Higuchi]
                    }
                    heightCount++;
                }

            } else if (i == 1) {

                int heightCount = 2;
                for (int l = 11; l <= 20; l++) {

                    ACChotarouXMLUtilities.setValue(writer, printParam,
                            "BY_INSURER_NAME" + l, "byInsurer.h" + heightCount
                                    + ".w2");
                    // 2006/09/26
                    // ���z���\���ύX�ɔ����t�H�[�}�b�^��ǉ�
                    // Replace - begin [Masahiko Higuchi]
                    // ���ږ����͂Ȃ珈���̓X�L�b�v
                    if (!"".equals(VRBindPathParser.get("BY_INSURER_NAME" + l,
                            printParam))
                            && VRBindPathParser.get("BY_INSURER_NAME" + l,
                                    printParam) != null) {

                        if (!"".equals(VRBindPathParser.get("BY_INSURER_PRICE"
                                + l, printParam))
                                && VRBindPathParser.get("BY_INSURER_PRICE" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w3", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_PRICE"
                                                                    + l,
                                                            printParam), 0)));
                        }

                        if (!"".equals(VRBindPathParser.get("BY_INSURER_NUMBER"
                                + l, printParam))
                                && VRBindPathParser.get("BY_INSURER_NUMBER" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w4", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_NUMBER"
                                                                    + l,
                                                            printParam), 0)));
                        }

                        if (!"".equals(VRBindPathParser.get("BY_INSURER_SUM"
                                + l, printParam))
                                && VRBindPathParser.get("BY_INSURER_SUM" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byInsurer.h" + heightCount + ".w5", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_INSURER_SUM"
                                                                    + l,
                                                            printParam), 0)));
                        }
                    }
                    // Replace - end [Masahiko Higuchi]

                    // ���ږ��������͂̏ꍇ�͈ꗥ�󎚏������s��Ȃ�
                    if (!"".equals(VRBindPathParser.get("BY_PATIENT_NAME" + l,
                            printParam))
                            && VRBindPathParser.get("BY_PATIENT_NAME" + l,
                                    printParam) != null) {
                        // �n��p�����[�^�[printParam ����
                        // KEY�FBY_PATIENT_NAME1��VALUE���擾���ݒ肷��B
                        // 2006/09/26
                        // ���z���\���ύX�ɔ����t�H�[�}�b�^��ǉ�
                        // Replace - begin [Masahiko Higuchi]

                        ACChotarouXMLUtilities.setValue(writer, printParam,
                                "BY_PATIENT_NAME" + l, "byPatient.h"
                                        + heightCount + ".w2");
                        // �n��p�����[�^�[printParam ����
                        // KEY�FBY_PATIENT_PRICE1��VALUE���擾���ݒ肷��B
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_PRICE"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_PRICE" + l,
                                        printParam) != null) {

                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w3", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_PRICE"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // �n��p�����[�^�[printParam ����
                        // KEY�FBY_PATIENT_NUMBER1��VALUE���擾���ݒ肷��B
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_NUMBER"
                                + l, printParam))
                                && VRBindPathParser.get(
                                        "BY_PATIENT_NUMBER" + l, printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w4", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_NUMBER"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // �n��p�����[�^�[printParam ����
                        // KEY�FBY_PATIENT_SUM1��VALUE���擾���ݒ肷��B
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_SUM"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_SUM" + l,
                                        printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w5", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_SUM"
                                                                    + l,
                                                            printParam), 0)));
                        // �n��p�����[�^�[printParam ����
                        // KEY�FPRINT_BY_PATIENT_USE_TAX1��VALUE���擾���ݒ肷��B
                            ACChotarouXMLUtilities.setValue(writer, printParam,
                                    "PRINT_BY_PATIENT_USE_TAX" + l,
                                    "byPatient.h" + heightCount + ".w6");
                        }
                        // �n��p�����[�^�[printParam ����
                        // KEY�FBY_PATIENT_TAX1��VALUE���擾���ݒ肷��B
                        if (!"".equals(VRBindPathParser.get("BY_PATIENT_TAX"
                                + l, printParam))
                                && VRBindPathParser.get("BY_PATIENT_TAX" + l,
                                        printParam) != null) {
                            ACChotarouXMLUtilities.setValue(writer,
                                    "byPatient.h" + heightCount + ".w7", nf
                                            .format(ACCastUtilities.toInt(
                                                    VRBindPathParser.get(
                                                            "BY_PATIENT_TAX"
                                                                    + l,
                                                            printParam), 0)));
                        }
                        // Replace - end [Masahiko Higuchi]
                    }
                    heightCount++;
                }

            }
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_1
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_1", "dayMark1.h1.w1");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_2
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_2", "dayMark1.h1.w2");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_3
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_3", "dayMark1.h1.w3");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_4
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_4", "dayMark1.h1.w4");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_5
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_5", "dayMark1.h1.w5");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_6
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_6", "dayMark1.h1.w6");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_7
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_7", "dayMark1.h1.w7");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_8
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_8", "dayMark1.h2.w1");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_9
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_9", "dayMark1.h2.w2");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_10
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_10", "dayMark1.h2.w3");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_11
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_11", "dayMark1.h2.w4");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_12
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_12", "dayMark1.h2.w5");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_13
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_13", "dayMark1.h2.w6");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_14
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_14", "dayMark1.h2.w7");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_15
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_15", "dayMark1.h3.w1");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_16
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_16", "dayMark1.h3.w2");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_17
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_17", "dayMark1.h3.w3");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_18
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_18", "dayMark1.h3.w4");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_19
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_19", "dayMark1.h3.w5");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_20
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_20", "dayMark1.h3.w6");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_21
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_21", "dayMark1.h3.w7");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_22
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_22", "dayMark1.h4.w1");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_23
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_23", "dayMark1.h4.w2");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_24
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_24", "dayMark1.h4.w3");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_25
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_25", "dayMark1.h4.w4");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_26
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_26", "dayMark1.h4.w5");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_27
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_27", "dayMark1.h4.w6");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_28
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_28", "dayMark1.h4.w7");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_29
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_29", "dayMark1.h5.w1");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_30
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_30", "dayMark1.h5.w2");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT1_PROVIDER_DAY_31
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT1_PROVIDE_DAY_31", "dayMark1.h5.w3");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_1
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_1", "dayMark2.h1.w1");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_2
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_2", "dayMark2.h1.w2");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_3
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_3", "dayMark2.h1.w3");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_4
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_4", "dayMark2.h1.w4");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_5
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_5", "dayMark2.h1.w5");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_6
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_6", "dayMark2.h1.w6");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_7
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_7", "dayMark2.h1.w7");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_8
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_8", "dayMark2.h2.w1");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_9
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_9", "dayMark2.h2.w2");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_10
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_10", "dayMark2.h2.w3");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_11
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_11", "dayMark2.h2.w4");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_12
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_12", "dayMark2.h2.w5");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_13
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_13", "dayMark2.h2.w6");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_14
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_14", "dayMark2.h2.w7");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_15
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_15", "dayMark2.h3.w1");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_16
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_16", "dayMark2.h3.w2");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_17
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_17", "dayMark2.h3.w3");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_18
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_18", "dayMark2.h3.w4");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_19
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_19", "dayMark2.h3.w5");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_20
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_20", "dayMark2.h3.w6");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_21
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_21", "dayMark2.h3.w7");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_22
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_22", "dayMark2.h4.w1");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_23
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_23", "dayMark2.h4.w2");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_24
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_24", "dayMark2.h4.w3");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_25
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_25", "dayMark2.h4.w4");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_26
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_26", "dayMark2.h4.w5");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_27
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_27", "dayMark2.h4.w6");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_28
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_28", "dayMark2.h4.w7");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_29
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_29", "dayMark2.h5.w1");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_30
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_30", "dayMark2.h5.w2");
            // �n��p�����[�^�[printParam ���� KEY�FPRINT2_PROVIDER_DAY_31
            // ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam,
                    "PRINT2_PROVIDE_DAY_31", "dayMark2.h5.w3");
            // �n��p�����[�^�[printParam ���� KEY�FBILL_NOTE ��VALUE���擾���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, printParam, "BILL_NOTE",
                    "note.h2.w1");

            // 2���ڂ̏ꍇ�͏����󎚂��Ȃ�
            if (i == 0) {
                // �l��0�ȊO�������ꍇ

                // 2006/09/26
                // ���z���\���ύX�ɔ����t�H�[�}�b�^��ǉ�
                // Replace - begin [Masahiko Higuchi]
                if (ACCastUtilities.toInt(VRBindPathParser.get(
                        "BILL_NO_TAX_BY_INSURER", printParam), 0) != 0) {
                    // �n��p�����[�^�[printParam ���� KEY�FBILL_NO_TAX_BY_INSURER
                    // ��VALUE���擾���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "Grid5.h2.w2", nf
                            .format(ACCastUtilities.toInt(VRBindPathParser.get(
                                    "BILL_NO_TAX_BY_INSURER", printParam), 0)));
                }
                // �l��0�ȊO�������ꍇ
                if (ACCastUtilities.toInt(VRBindPathParser.get(
                        "BILL_NO_TAX_BY_PATIENT", printParam), 0) != 0) {
                    // �n��p�����[�^�[printParam ���� KEY�FBILL_NO_TAX_BY_PATIENT
                    // ��VALUE���擾���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "Grid5.h2.w4", nf
                            .format(ACCastUtilities.toInt(VRBindPathParser.get(
                                    "BILL_NO_TAX_BY_PATIENT", printParam), 0)));
                }
                // �l��0�ȊO�������ꍇ
                if (ACCastUtilities.toLong(VRBindPathParser.get(
                        "BILL_IN_TAX_BY_PATIENT", printParam), 0) != 0) {
                    // �n��p�����[�^�[printParam ���� KEY�FBILL_IN_TAX_BY_PATIENT
                    // ��VALUE���擾���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "Grid5.h3.w4", nf
                            .format(ACCastUtilities.toInt(VRBindPathParser.get(
                                    "BILL_IN_TAX_BY_PATIENT", printParam), 0)));
                }
                // �l��0�ȊO�������ꍇ
                if (ACCastUtilities.toInt(VRBindPathParser.get(
                        "BILL_FULL_TOTAL", printParam), 0) != 0) {
                    // �n��p�����[�^�[printParam ���� KEY�FBILL_FULL_TOTAL
                    // ��VALUE���擾���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "Grid5.h4.w4", nf
                            .format(ACCastUtilities.toInt(VRBindPathParser.get(
                                    "BILL_FULL_TOTAL", printParam), 0)));
                }
                // Replace - end [Masahiko Higuchi]

            }
            // �ŏI���t���擾
            int maxDay = ACDateUtilities.getDayOfMonth(ACDateUtilities
                    .toLastDayOfMonth(ACCastUtilities.toDate(printParam
                            .getData("BILL_SPAN_END"))));
            // �ő���t�ɂ���ĕ\����ύX
            switch (maxDay) {
            case 28:
                // ���t���ڃN���A
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w1", "");
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w3", "");

                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w1", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w3", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w1", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w3", "");
                break;
            case 29:
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w3", "");

                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w3", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w2", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w3", "");
                break;
            case 30:
                ACChotarouXMLUtilities.setValue(writer, "days.h5.w3", "");

                ACChotarouXMLUtilities.setValue(writer, "dayMark1.h5.w3", "");
                ACChotarouXMLUtilities.setValue(writer, "dayMark2.h5.w3", "");
                break;
            }

            // �y�[�W���ݒ�
            ACChotarouXMLUtilities.setValue(writer, "page.h1.w3",
                    ACCastUtilities.toString(i + 1));
            ACChotarouXMLUtilities.setValue(writer, printParam, "LAST_PAGE",
                    "page.h1.w1");

            // �y�[�W�I��
            writer.endPageEdit();

        }

        // ��������s�����Ȃ��true��Ԃ��B
        return true;

    }

    // �����֐�

    /**
     * �u����p�Ƀf�[�^��ϊ����܂��B�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void convertCalenderData(VRMap printParam, String key)
            throws Exception {
        // �n���ꂽ�l�𒠕[�󎚗p�̃f�[�^�ɕϊ����܂��B
        // �n���ꂽ�p�����[�^�[����w�肳�ꂽKEY��VALUE���擾����B
        // �擾�����l�����l�ł��邩�`�F�b�N����B
        if (VRBindPathParser.get(key, printParam) instanceof Integer) {
            // ���l�ł���ꍇ
            // �����ϐ� mark[] �𐶐�����B
            String mark[] = new String[] { "", "" };
            switch (ACCastUtilities
                    .toInt(VRBindPathParser.get(key, printParam))) {
            // �擾�����l���`�F�b�N����B
            case 0:
                // �l��0�������ꍇ
                // mark[�z��1�Ԗ�]��VALUE�Ƃ��Ē萔�ENO_MARK��ݒ肷��B
                mark[0] = NO_MARK;
                break;
            case 1:
                // �l��1�������ꍇ
                // mark[�z��1�Ԗ�]��VALUE�Ƃ��Ē萔�ECIRCLE��ݒ肷��B
                mark[0] = CIRCLE;
                break;
            // �l��2�������ꍇ
            case 2:
                // mark[�z��1�Ԗ�]��VALUE�Ƃ��Ē萔�ETRIANGLE��ݒ肷��B
                mark[0] = TRIANGLE;
                break;
            case 3:
                // �l��3�������ꍇ
                // mark[�z��1�Ԗ�]��VALUE�Ƃ��Ē萔�EDOUBLE_CIRCLE��ݒ肷��B
                mark[0] = DOUBLE_CIRCLE;
                break;
            case 4:
                // �l��4�������ꍇ
                // mark[�z��1�Ԗ�]��VALUE�Ƃ��Ē萔�ETRIANGLE��ݒ肷��B
                // mark[�z��2�Ԗ�]��VALUE�Ƃ��Ē萔�EDOUBLE_CIRCLE��ݒ肷��B
                mark[0] = TRIANGLE;
                mark[1] = DOUBLE_CIRCLE;
                break;
            case 5:
                // �l��5�������ꍇ
                // mark[�z��1�Ԗ�]��VALUE�Ƃ��Ē萔�ERHOMBUS��ݒ肷��B
                mark[0] = RHOMBUS;
                break;
            case 6:
                // �l��6�������ꍇ
                // mark[�z��1�Ԗ�]��VALUE�Ƃ��Ē萔�ETRIANGLE��ݒ肷��B
                // mark[�z��2�Ԗ�]��VALUE�Ƃ��Ē萔�ERHOMBUS��ݒ肷��B
                mark[0] = TRIANGLE;
                mark[1] = RHOMBUS;
                break;
            }
            // �n��p�����[�^�[�W���ɉ��L��KEY�^VALUE�Ŋi�[����B
            // KEY�FPRINT_ + �w��KEY�� VALUE�Fmark
            VRBindPathParser.set("PRINT1_" + key, printParam, mark[0]);
            VRBindPathParser.set("PRINT2_" + key, printParam, mark[1]);
        }
        // ���l�łȂ��ꍇ
        // �������s��Ȃ��B

    }

    /**
     * �u�ł̓��E�O��ϊ����܂��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void convertTax(VRMap printParam, String key) throws Exception {
        // �ł̓��E�O��ϊ����܂�
        // �n���ꂽ�p�����[�^�[����w�肳�ꂽKEY��VALUE���擾����B
        // �擾�����l�����l�ł��邩�`�F�b�N����B
        if (printParam.getData(key) instanceof Integer) {
            // ���l�ł���ꍇ
            // �擾�����l���`�F�b�N����B
            switch (ACCastUtilities.toInt(printParam.getData(key))) {
            case 0:
                // �l��0�������ꍇ
                // ���L��KEY�^VALUE��n��p�����[�^�[printParam�Ɋi�[����B
                // KEY�FPRINT_ + �w��KEY�� VALUE�F"��"
                printParam.setData("PRINT_" + key, "��");
                break;
            case 1:
                // �l��1�������ꍇ
                // ���L��KEY�^VALUE��n��p�����[�^�[printParam�Ɋi�[����B
                // KEY�FPRINT_ + �w��KEY�� VALUE�F"�O"
                printParam.setData("PRINT_" + key, "�O");
                break;
            }
        }

    }

    /**
     * �u�y�[�W���v�Z�v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @throws Exception ������O
     */
    public void pageCalc(VRMap printParam) throws Exception {
        // ����y�[�W���v�Z�Ɋւ��鏈�����s���܂��B
        // �n���ꂽ�p�����[�^�[����ȉ��̔z��̕������KEY�Ƃ���printParam���VALUE�𔲂��o���󔒂��ǂ����`�F�b�N����B
        for (int i = 0; i < CALC_INSURER.length; i++) {
            // KEY �萔�FCALC_INSURER
            if (!"".equals(printParam.getData(CALC_INSURER[i]))
                    && printParam.getData(CALC_INSURER[i]) != null) {
                // ���炩�̕����񂪓����Ă����ꍇ
                // printPram�Ɉȉ���KEY/VALUE��ݒ肷��B
                // KEY�FLAST_PAGE VALUE�F2
                printParam.setData("LAST_PAGE", new Integer(2));
                return;
            }
        }

        // KEY �萔�FCALC_PATIENT_INSURER
        for (int j = 0; j < CALC_PATIENT_INSURER.length; j++) {
            if (!"".equals(printParam.getData(CALC_PATIENT_INSURER[j]))
                    && printParam.getData(CALC_PATIENT_INSURER[j]) != null) {
                printParam.setData("LAST_PAGE", new Integer(2));
                return;
            }
        }
        // �S�ċ󔒂������ꍇ
        // printPram�Ɉȉ���KEY/VALUE��ݒ肷��B
        // KEY�FLAST_PAGE VALUE�F1
        printParam.setData("LAST_PAGE", new Integer(1));

    }

}