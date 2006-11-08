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
 * �쐬��: 2006/06/01  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə��ꗗ (003)
 * �v���O���� ���Ə��ꗗ (QO003P01)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo003;

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
import java.util.Iterator;

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

/**
 * ���Ə��ꗗ(QO003P01) ���[��`�̃t�@�C���� �F QO003P01.xml
 */
public class QO003P01 {//extends QO003P01Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QO003P01() {
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

        // �������
        // ������p�����^�����[�J���ϐ��ɓW�J
        // ���Ə��ꗗ�����R�[�h�W���Ƃ��Đ錾���A����p�����^�̃L�[[PROVIDERS]�̒l���i�[����B
        VRList providerList = new VRArrayList();
        if (VRBindPathParser.has("PROVIDERS", printParam)) {
            providerList = (VRList) VRBindPathParser.get("PROVIDERS",
                    printParam);
            if (providerList.size() < 1) {
                // ����s��
                return false;
            }
        } else {
            // ������p�����[�^�����Ȃ������ꍇ
            return false;
        }
        // DB�}�l�[�W����錾���A����p�����^�̃L�[[DBM]�̒l���i�[����B
        ACDBManager dbm = (ACDBManager) VRBindPathParser.get("DBM", printParam);
        // ���T�[�r�X�}�X�^�̎擾
        // �T�[�r�X�}�X�^�Ƃ��ă��R�[�h��錾���A���ʊ֐��őΏ۔N�����w�肹���ɃT�[�r�X�}�X�^���擾�������ʂ��i�[����B
//        VRMap services = QkanCommon.getMasterService(dbm);
        // �����
        // ��������N���X�Ƀt�H�[�}�b�g(QO003P01.xml)���`����B
        ACChotarouXMLUtilities.addFormat(writer, "QO003P01", "QO003P01.xml");
        // ����Ώۍs������킷�����J�E���^�������l1�Ő錾����B
        int nowPrintLineNo = 1;
        // �y�[�W��`���J�n�������Ƃ�����킷�y�[�W�J�n�ς݃t���O��^�U�l�Ő錾���Afalse�ŏ���������B
        boolean isPrintStart = false;
        // �S�Ă̎��Ə����������܂ňȉ��̏������J��Ԃ��B
        Iterator it = providerList.iterator();
        while (it.hasNext()) {
            if (nowPrintLineNo <= 1) {
                // ����Ώۍs��1�ȉ��̏ꍇ
                // ��������N���X�Ƀy�[�W�̊J�n���`����B
                writer.beginPageEdit("QO003P01");
                // �y�[�W�J�n�ς݃t���O��true�ɂ���B
                isPrintStart = true;
                // ���ݓ������`�̍���[Date]�Ƃ��Ĉ󎚂���B
                ACChotarouXMLUtilities.setValue(writer, "Date", VRDateParser
                        .format(new Date(), "ggge�NMM��dd��"));
            }
            // ����Ώۂ̎��Ə�������킷���R�[�h��錾���A�J��Ԃ������ɂ����錻�݂̏����Ώۂ̎��Ə����i�[����B
            VRMap nowPrintProvider = (VRMap) it.next();
            // �����Ə��ԍ��A���Ə����A���Ə��Z����
            // �ȉ��̃L�[�ɑΉ����郌�R�[�h�̒l���󎚂���B�i���͈���Ώۍs�j
            // �L�[�FPROVIDER_ID ��`�̍��ځFproviders.h��.PROVIDER_ID
            // �L�[�FPROVIDER_NAME ��`�̍��ځFproviders.h��.PROVIDER_NAME
            // �L�[�FPROVIDER_ADDRESS ��`�̍��ځFproviders.h��.PROVIDER_ADDRESS
            ACChotarouXMLUtilities.setValue(writer, nowPrintProvider,
                    "PROVIDER_ID", "providers.h" + nowPrintLineNo
                            + ".PROVIDER_ID");
            ACChotarouXMLUtilities.setValue(writer, nowPrintProvider,
                    "PROVIDER_NAME", "providers.h" + nowPrintLineNo
                            + ".PROVIDER_NAME");
            ACChotarouXMLUtilities.setValue(writer, nowPrintProvider,
                    "PROVIDER_ADDRESS", "providers.h" + nowPrintLineNo
                            + ".PROVIDER_ADDRESS");
            // �����Ə��X�֔ԍ���
            // �ȉ��̃L�[�̒l�����ʊ֐��Ō������Ē�`�̍���[providers.h��.PROVIDER_ZIP]�Ɉ󎚂���B�i���͈���Ώۍs�j
            // �L�[�FPROVIDER_ZIP_FIRST�APROVIDER_ZIP_SECOND
            ACChotarouXMLUtilities.setValue(writer, "providers.h"
                    + nowPrintLineNo + ".PROVIDER_ZIP", QkanCommon.toZip(
                    VRBindPathParser
                            .get("PROVIDER_ZIP_FIRST", nowPrintProvider),
                    VRBindPathParser.get("PROVIDER_ZIP_SECOND",
                            nowPrintProvider)));
            // �����Ə��d�b�ԍ���
            // �ȉ��̃L�[�̒l�����ʊ֐��Ō������Ē�`�̍���[providers.h��.PROVIDER_TEL]�Ɉ󎚂���B�i���͈���Ώۍs�j
            // �L�[�FPROVIDER_TEL_FIRST�APROVIDER_TEL_SECOND�APROVIDER_TEL_THIRD
            ACChotarouXMLUtilities.setValue(writer, "providers.h"
                    + nowPrintLineNo + ".PROVIDER_TEL", QkanCommon.toTel(
                    VRBindPathParser
                            .get("PROVIDER_TEL_FIRST", nowPrintProvider),
                    VRBindPathParser.get("PROVIDER_TEL_SECOND",
                            nowPrintProvider), VRBindPathParser.get(
                            "PROVIDER_TEL_THIRD", nowPrintProvider)));
            // �����Ə�FAX�ԍ���
            // �ȉ��̃L�[�̒l�����ʊ֐��Ō������Ē�`�̍���[providers.h��.PROVIDER_FAX]�Ɉ󎚂���B�i���͈���Ώۍs�j
            // �L�[�FPROVIDER_FAX_FIRST�APROVIDER_FAX_SECOND�APROVIDER_FAX_THIRD
            ACChotarouXMLUtilities.setValue(writer, "providers.h"
                    + nowPrintLineNo + ".PROVIDER_FAX", QkanCommon.toTel(
                    VRBindPathParser
                            .get("PROVIDER_FAX_FIRST", nowPrintProvider),
                    VRBindPathParser.get("PROVIDER_FAX_SECOND",
                            nowPrintProvider), VRBindPathParser.get(
                            "PROVIDER_FAX_THIRD", nowPrintProvider)));
            // �����Ə����Ƌ敪��
            // �L�[[PROVIDER_JIGYOU_TYPE]�̒l���t�H�[�}�b�gQkanProviderJigyoTypeFormat�ŕϊ�����B
            // �ϊ����ʂ��`�̍���[providers.h��.PROVIDER_JIGYOU_TYPE]�Ɉ󎚂���B�i���͈���Ώۍs�j
            ACChotarouXMLUtilities
                    .setValue(
                            writer,
                            "providers.h" + nowPrintLineNo
                                    + ".PROVIDER_JIGYOU_TYPE",
                            QkanProviderJigyoTypeFormat
                                    .getInstance()
                                    .format(VRBindPathParser
                                                            .get(
                                                                    "PROVIDER_JIGYOU_TYPE",
                                                                    nowPrintProvider)));
            // �����Ə��n��敪��
            // �L�[[PROVIDER_AREA_TYPE]�̒l���t�H�[�}�b�gQkanProviderAreaTypeFormat�ŕϊ�����B
            // �ϊ����ʂ��`�̍���[providers.h��.PROVIDER_AREA_TYPE]�Ɉ󎚂���B�i���͈���Ώۍs�j
            ACChotarouXMLUtilities.setValue(writer, "providers.h"
                    + nowPrintLineNo + ".PROVIDER_AREA_TYPE",
                    QkanProviderAreaTypeFormat.getInstance().format(VRBindPathParser.get(
                                    "PROVIDER_AREA_TYPE", nowPrintProvider)));
            // ���񋟃T�[�r�X��
            // ���ʊ֐��őΏێ��Ə��̒񋟃T�[�r�X���擾����B
            VRList providerDetail = dbm
                    .executeQuery(getSQL_GET_SERVICE_CALENDAR_NAME(nowPrintProvider));
            if (!providerDetail.isEmpty()) {
                // �񋟃T�[�r�X��1�ȏ゠��ꍇ
                // �񋟃T�[�r�X�������ʂ�����킷�������錾����B
                StringBuffer sb = new StringBuffer();
                // �񋟃T�[�r�X�������ʂɁA�T�[�r�X�}�X�^�����Ƃ�1�߂̒񋟃T�[�r�X�̗��̂��i�[����B
                VRMap map = (VRMap) providerDetail.getData(0);
                sb.append(VRBindPathParser.get("SERVICE_CALENDAR_ABBREVIATION",
                        map));

                // 2�߂���5�߂܂ł̒񋟃T�[�r�X��ΏۂɈȉ��̏������J��Ԃ��B
                int end = Math.min(5, providerDetail.size());
                for (int i = 1; i < end; i++) {
                    map = (VRMap) providerDetail.getData(i);
                    // �񋟃T�[�r�X�������ʂɁA�Ǔ_�u�A�v����������B
                    sb.append("�A");
                    // �񋟃T�[�r�X�������ʂɁA�T�[�r�X�}�X�^�����ƂɑΏے񋟃T�[�r�X�̗��̂���������B
                    sb.append(VRBindPathParser.get(
                            "SERVICE_CALENDAR_ABBREVIATION", map));
                }

                if (providerDetail.size() >= 6) {
                    // �񋟃T�[�r�X��6�ȏ゠��ꍇ
                    // �񋟃T�[�r�X�������ʂɁA�u�A���v����������B
                    sb.append("�A��");
                }
                // �񋟃T�[�r�X�������ʂ��`�̍���[providers.h��.PROVIDER_SERVICE]�Ɉ󎚂���B�i���͈���Ώۍs�j
                ACChotarouXMLUtilities.setValue(writer, "providers.h"
                        + nowPrintLineNo + ".PROVIDER_SERVICE", sb.toString());
            }
            


            if (nowPrintLineNo < 24) {
                // ����Ώۍs��24�����̏ꍇ
                // ����Ώۍs��1���Z����B
                nowPrintLineNo++;
            } else {
                // ����Ώۍs��24�ȏ�̏ꍇ
                // ��������N���X�Ƀy�[�W�̏I�����`����B
                writer.endPageEdit();
                // ����Ώۍs��1�ɂ���B
                nowPrintLineNo = 1;
                // �y�[�W�J�n�ς݃t���O��false�ɂ���B
                isPrintStart = false;
            }
        }
        // �y�[�W�J�n�ς݃t���O��true�̏ꍇ
        if (isPrintStart) {
            // ��������N���X�Ƀy�[�W�̏I�����`����B
            writer.endPageEdit();
        }
        // TODO ��������s�����Ȃ��true��Ԃ��B
        return true;

    }

    /**
     * �u�T�[�r�X�J�����_�[�����擾����B�v�̂��߂�SQL��Ԃ��܂��B
     * @param sqlParam SQL�\�z�ɕK�v�ȃp�����^���i�[�����n�b�V���}�b�v
     * @throws Exception ������O
     * @return SQL��
     */
    public String getSQL_GET_SERVICE_CALENDAR_NAME(VRMap sqlParam) throws Exception{
      StringBuffer sb = new StringBuffer();
      Object[] inValues;
      Stack conditionStack = new Stack();
      boolean firstCondition = true;
      Object obj;

      sb.append("SELECT");

      sb.append(" DISTINCT");

      sb.append(" M_SERVICE.SERVICE_CALENDAR_ABBREVIATION");

      sb.append(" FROM");

      sb.append(" PROVIDER_SERVICE");

      sb.append(",M_SERVICE");

      sb.append(" WHERE");

      sb.append("(");

      sb.append(" PROVIDER_SERVICE.PROVIDER_ID");

      sb.append(" =");

      sb.append(ACSQLSafeStringFormat.getInstance().format(VRBindPathParser.get("PROVIDER_ID", sqlParam)));

      sb.append(")");

      sb.append("AND");

      sb.append("(");

      sb.append(" PROVIDER_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

      sb.append(" =");

      sb.append(" M_SERVICE.SYSTEM_SERVICE_KIND_DETAIL");

      sb.append(")");

      sb.append(" ORDER BY");

      sb.append(" SERVICE_SORT");

      sb.append(" ASC");

      return sb.toString();
    }
}
