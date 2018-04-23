
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
 * �J����: �����@�L
 * �쐬��: 2006/01/17  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j (001)
 * �v���O���� �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j (QP001051)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public class QP001P092_201804 extends QP001P09_201804{
	
	/* 
	 * �l�����̓� 201804�ȍ~
	 * 
	 * addFormat()
	 * �ݒ肷�钠�[��`�̂�ύX
	 * 
	 * getFormatId()
	 * �t�H�[�}�b�g�ԍ��̕ύX
	 */

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P092_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P092_201804";
    }
    protected int getSpecialClinicRecordType() {
    	//���ʐf�Ô�̃��R�[�h�^�C�v��Ԃ�
    	return QkanConstants.SPECIAL_CLINIC_RECORD_TYPE_TOKUBETU_SHINRYO;
    }

	@Override
	protected VRMap getEmergencyInfo() {
		return getemErgencyMap();
	}

	@Override
	protected void writeEmergency() throws Exception {
		VRMap emergencyMap = getEmergencyInfo();
		/* ============================================================================= */
        /* �ً}���{�ݗ×{�� */
        /* ============================================================================= */
        if(emergencyMap != null){
            // �ً}�����a���P��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, emergencyMap,
                    "401008", "emergency.s1.syoubyo");
            // �ً}�����a���Q��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, emergencyMap,
                    "401009", "emergency.s2.syoubyo");
            // �ً}�����a���R��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, emergencyMap,
                    "401010", "emergency.s3.syoubyo");

            // �ً}�����ÊJ�n�J�n�N�����P
            if (QP001Util.isDate(VRBindPathParser.get("401011",
                    emergencyMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser
                        .get("401011", emergencyMap));
                // �ً}�����ÊJ�n�N�����P�̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergency.s1.emergencydate", eraFormat
                                .format(start));
                // �ً}�����ÊJ�n�N�����P�̘a��N��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyyear1", eraYearFormat.format(start));
                // �ً}�����ÊJ�n�N�����P�̌���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencymonth1", monthFormat.format(start));
                // �ً}�����ÊJ�n�N�����P�̓���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyday1", dayFormat.format(start));
            }

            // �ً}�����ÊJ�n�N�����Q
            if (QP001Util.isDate(VRBindPathParser.get("401012",
                    emergencyMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser
                        .get("401012", emergencyMap));
                // �ً}�����ÊJ�n�N�����Q�̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergency.s2.emergencydate", eraFormat
                                .format(start));
                // �ً}�����ÊJ�n�N�����Q�̘a��N��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyyear2", eraYearFormat.format(start));
                // �ً}�����ÊJ�n�N�����Q�̌���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencymonth2", monthFormat.format(start));
                // �ً}�����ÊJ�n�N�����Q�̓���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyday2", dayFormat.format(start));
            }

            // �ً}�����ÊJ�n�N�����R
            if (QP001Util.isDate(VRBindPathParser.get("401013",
                    emergencyMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser
                        .get("401013", emergencyMap));
                // �ً}�����ÊJ�n�N�����R�̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergency.s3.emergencydate", eraFormat
                                .format(start));
                // �ً}�����ÊJ�n�N�����R�̘a��N��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyyear3", eraYearFormat.format(start));
                // �ً}�����ÊJ�n�N�����R�̌���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencymonth3", monthFormat.format(start));
                // �ً}�����ÊJ�n�N�����R�̓���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "emergencyday3", dayFormat.format(start));
            }

            // �ً}�����ÊǗ�(�Čf)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency.h8.w4",
                    pad(emergencyMap.get("401020"), 0));
            // �ً}�����ÊǗ��P�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency.h8.w10",
                    pad(emergencyMap.get("401018"), 0));
            // �ً}�����ÊǗ�������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "tani", pad(
                    emergencyMap.get("401019"), 2));

            // ���n�r���e�[�V�����_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency.h7.w4",
                    pad(emergencyMap.get("401021"), 0));
            // ���u�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency.h6.w4",
                    pad(emergencyMap.get("401022"), 0));
            // ��p�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency.h5.w4",
                    pad(emergencyMap.get("401023"), 0));
            // �����_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency.h4.w4",
                    pad(emergencyMap.get("401024"), 0));
            // ���ː����Ó_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency.h3.w4",
                    pad(emergencyMap.get("401025"), 0));
            // ���v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency.h1.w4",
                    pad(emergencyMap.get("401046"), 0));

            // �E�v��ݒ肷��B���E�v�P�`�E�v�Q�O�܂ł��u�^�v�ŘA�����A�o�́B
            StringBuilder tekiyo = new StringBuilder();
            for (int j = 401026; j < 401046; j++) {
                if (!ACTextUtilities.isNullText(VRBindPathParser.get(
                        ACCastUtilities.toString(j), emergencyMap))) {
                    tekiyo.append(VRBindPathParser.get(ACCastUtilities
                            .toString(j), emergencyMap));
                    tekiyo.append("�^");
                }
            }
            if (tekiyo.length() > 0) {
                tekiyo.deleteCharAt(tekiyo.length() - 1);
            }
            ACChotarouXMLUtilities.setValue(writer, "emergency.h6.w10",
                    tekiyo.toString());
            // ���f������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "oushintimes", pad(
                    emergencyMap.get("401014"), 2));
            // ���f��Ë@�֖���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, emergencyMap,
                    "401015", "emergency.h2.w3");
            // �ʉ@������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "tuuintimes", pad(
                    emergencyMap.get("401016"), 2));
            // �ʉ@��Ë@�ւ�ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, emergencyMap,
                    "401017", "emergency.h2.w16");
        
        }
	}
}
