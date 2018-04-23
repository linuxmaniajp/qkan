
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

public class QP001P091_201804 extends QP001P09_201804{
	
	/* 
	 * �l����� 201804�ȍ~
	 * 
	 * addFormat()
	 * �ݒ肷�钠�[��`�̂�ύX
	 * 
	 * getFormatId()
	 * �t�H�[�}�b�g�ԍ��̕ύX
	 */

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P091_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P091_201804";
    }

    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/28 add - begin
    protected int getSpecialClinicRecordType() {
    	//���ʗ×{��̃��R�[�h�^�C�v��Ԃ�
    	return QkanConstants.SPECIAL_CLINIC_RECORD_TYPE_TOKUBETU_RYOYO;
    }
    
	@Override
	protected VRMap getEmergencyInfo() {
		return getemErgencyOwnFacilityMap();
	}
	
	@Override
	protected void writeEmergency() throws Exception {
		VRMap emergencyOwnFacilityMap = getEmergencyInfo();
		// �ً}���{�ݎ��Ô�===================================
        if(emergencyOwnFacilityMap != null){
            
            // ���莾���{�ݗ×{�� ���a���P
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701047", "emergency1.h1.w8");
            // ���莾���{�ݗ×{�� ���a���Q
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701048", "emergency1.h2.w8");
            // ���莾���{�ݗ×{�� ���a���R
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701049", "emergency1.h3.w8");
            // ���莾���{�ݗ×{��J�n�N�����P
            if (QP001Util.isDate(VRBindPathParser.get("1701050", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701050", emergencyOwnFacilityMap));
                // ���莾���{�ݗ×{��J�n�N�����P�̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h1.w19", eraFormat.format(start));
                // ���莾���{�ݗ×{��J�n�N�����P�̘a��N��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "ownyear1", eraYearFormat.format(start));
                // ���莾���{�ݗ×{��J�n�N�����P�̌���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "ownmonth1", monthFormat.format(start));
                // ���莾���{�ݗ×{��J�n�N�����P�̓���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "ownday1", dayFormat.format(start));
            }
            // ���莾���{�ݗ×{��J�n�N�����Q
            if (QP001Util.isDate(VRBindPathParser.get("1701051", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701051", emergencyOwnFacilityMap));
                // ���莾���{�ݗ×{��J�n�N�����Q�̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h2.w19", eraFormat.format(start));
                // ���莾���{�ݗ×{��J�n�N�����Q�̘a��N��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "ownyear2", eraYearFormat.format(start));
                // ���莾���{�ݗ×{��J�n�N�����Q�̌���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "ownmonth2", monthFormat.format(start));
                // ���莾���{�ݗ×{��J�n�N�����Q�̓���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "ownday2", dayFormat.format(start));
            }
            // ���莾���{�ݗ×{��J�n�N�����R
            if (QP001Util.isDate(VRBindPathParser.get("1701052", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701052", emergencyOwnFacilityMap));
                // ���莾���{�ݗ×{��J�n�N�����R�̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h3.w19", eraFormat.format(start));
                // ���莾���{�ݗ×{��J�n�N�����R�̘a��N��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "ownyear3", eraYearFormat.format(start));
                // ���莾���{�ݗ×{��J�n�N�����R�̌���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "ownmonth3", monthFormat.format(start));
                // ���莾���{�ݗ×{��J�n�N�����R�̓���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "ownday3", dayFormat.format(start));
            }
            // ���莾���{�ݗ×{��(�Čf)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency1.h4.w7", pad(emergencyOwnFacilityMap.get("1701055"),0));
            // ���莾���{�ݗ×{��P�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency1.h4.w10", pad(emergencyOwnFacilityMap.get("1701053"),0));
            // ���莾���{�ݗ×{�������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "owntani", pad(emergencyOwnFacilityMap.get("1701054"),2));
            
            
            // �ً}�����a���P��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701008", "emergency1.h5.w8");
            // �ً}�����a���Q��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701009", "emergency1.h6.w8");
            // �ً}�����a���R��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701010", "emergency1.h7.w8");

            // �ً}�����ÊJ�n�J�n�N�����P
            if (QP001Util.isDate(VRBindPathParser.get("1701011", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701011", emergencyOwnFacilityMap));
                // �ً}�����ÊJ�n�N�����P�̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h5.w19", eraFormat.format(start));
                // �ً}�����ÊJ�n�N�����P�̘a��N��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergencyyear1", eraYearFormat.format(start));
                // �ً}�����ÊJ�n�N�����P�̌���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergencymonth1", monthFormat.format(start));
                // �ً}�����ÊJ�n�N�����P�̓���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergencyday1", dayFormat.format(start));
            }

            // �ً}�����ÊJ�n�N�����Q
            if (QP001Util.isDate(VRBindPathParser.get("1701012", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701012", emergencyOwnFacilityMap));
                // �ً}�����ÊJ�n�N�����Q�̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h6.w19", eraFormat.format(start));
                // �ً}�����ÊJ�n�N�����Q�̘a��N��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergencyyear2", eraYearFormat.format(start));
                // �ً}�����ÊJ�n�N�����Q�̌���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergencymonth2", monthFormat.format(start));
                // �ً}�����ÊJ�n�N�����Q�̓���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergencyday2", dayFormat.format(start));
            }

            // �ً}�����ÊJ�n�N�����R
            if (QP001Util.isDate(VRBindPathParser.get("1701013", emergencyOwnFacilityMap))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1701013", emergencyOwnFacilityMap));
                // �ً}�����ÊJ�n�N�����R�̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergency1.h7.w19", eraFormat.format(start));
                // �ً}�����ÊJ�n�N�����R�̘a��N��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergencyyear3", eraYearFormat.format(start));
                // �ً}�����ÊJ�n�N�����R�̌���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergencymonth3", monthFormat.format(start));
                // �ً}�����ÊJ�n�N�����R�̓���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "emergencyday3", dayFormat.format(start));
            }

            // �ً}�����ÊǗ�(�Čf)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency1.h8.w7", pad(emergencyOwnFacilityMap.get("1701020"),0));
            // �ً}�����ÊǗ��P�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency1.h8.w10", pad(emergencyOwnFacilityMap.get("1701018"),0));
            // �ً}�����ÊǗ�������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergencytani", pad(emergencyOwnFacilityMap.get("1701019"),2));

            // ���n�r���e�[�V�����_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h9.w6", pad(emergencyOwnFacilityMap.get("1701021"),0));
            // ���u�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h10.w6", pad(emergencyOwnFacilityMap.get("1701022"),0));
            // ��p�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h11.w6", pad(emergencyOwnFacilityMap.get("1701023"),0));
            // �����_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h12.w6", pad(emergencyOwnFacilityMap.get("1701024"),0));
            // ���ː����Ó_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h13.w6", pad(emergencyOwnFacilityMap.get("1701025"),0));
            // ���v�_����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h14.w6", pad(emergencyOwnFacilityMap.get("1701046"),0));
            
            // �E�v��ݒ肷��B���E�v�P�`�E�v�Q�O�܂ł��u�^�v�ŘA�����A�o�́B
            StringBuilder tekiyo = new StringBuilder();
            for (int j = 1701026; j < 1701046; j++) {
                if (!ACTextUtilities.isNullText(VRBindPathParser.get(ACCastUtilities.toString(j), emergencyOwnFacilityMap))) {
                    tekiyo.append(VRBindPathParser.get(ACCastUtilities.toString(j), emergencyOwnFacilityMap));
                    tekiyo.append("�^");
                }
            }
            if (tekiyo.length() > 0) {
                tekiyo.deleteCharAt(tekiyo.length() - 1);
            }
            ACChotarouXMLUtilities.setValue(writer, "emergency2.h10.w10",tekiyo.toString());
            
            // ���f������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "oushintimes", pad(emergencyOwnFacilityMap.get("1701014"),2));
            // ���f��Ë@�֖���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap,"1701015", "emergency3.h15.w8");
            
            // �ʉ@������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "tuuintimes", pad(emergencyOwnFacilityMap.get("1701016"),2));
            // �ʉ@��Ë@�ւ�ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, emergencyOwnFacilityMap, "1701017","emergency3.h15.w21");
        }
	}
    // [H30.4�����Ή�][Yoichiro Kamei] 2018/3/28 add - end
}
