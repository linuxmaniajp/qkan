
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
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;

/**
 * ����̃L�[����ێ�����N���X�B
 * 
 */
public class QP001KohiKey implements java.lang.Comparable<QP001KohiKey> {

    private String kohiType = "";
    
    private Integer kohiSort = 0;
    
    private Date serviceDate;
    
    private String kohiLawNo = "";
    
    private String insurerId = "";
    
    private String kohiRecipientNo = "";
    
    /**
     * �R���X�g���N�^�B
     * 
     */
    public QP001KohiKey(Map kohiInfo) {
        this.kohiLawNo = ACCastUtilities.toString(kohiInfo.get("KOHI_LAW_NO"), "");
        this.insurerId = ACCastUtilities.toString(kohiInfo.get("INSURER_ID"), "");
        this.kohiRecipientNo = ACCastUtilities.toString(kohiInfo.get("KOHI_RECIPIENT_NO"), "");
        
        //�ȉ��̓L�[���ڂł͂Ȃ����t�����Ƃ��ĕێ�
        this.kohiType = ACCastUtilities.toString(kohiInfo.get("KOHI_TYPE"), "");
        this.kohiSort = ACCastUtilities.toInteger(kohiInfo.get("KOHI_SORT"), 0);
        this.serviceDate = ACCastUtilities.toDate(kohiInfo.get("SERVICE_DATE"), null);
    }
    
    /**
     * �����ނ��擾���܂��B
     * @return ������
     */
    public String getKohiType() {
        return kohiType;
    }

    /**
     * �@�ʔԍ����擾���܂��B
     * @return �@�ʔԍ�
     */
    public String getKohiLawNo() {
        return kohiLawNo;
    }

    /**
     * �ی��Ҕԍ����擾���܂��B
     * @return �ی��Ҕԍ�
     */
    public String getInsurerId() {
        return insurerId;
    }
    
    /**
     * �󋋎Ҕԍ����擾���܂��B
     * @return �󋋎Ҕԍ�
     */
    public String getKohiRecipientNo() {
        return kohiRecipientNo;
    }
    
    /**
     * ����D�揇���擾���܂��B
     * @return ����D�揇
     */
    public Integer getKohiSort() {
        return kohiSort;
    }
    
    /**
     * �񋟓����擾���܂��B
     * @return �񋟓�
     */
    public Date getServiceDate() {
        return serviceDate;
    }

  //Collections.sort���̕��ёւ����ɌĂ΂�܂��B
    @Override    
    public int compareTo(QP001KohiKey o) {
        //����D�揇
        int kohiSortResult = kohiSort.compareTo(o.getKohiSort());
        if (kohiSortResult != 0) {
            return kohiSortResult;
        }
        //�񋟓���
        if (serviceDate != null) {
            return serviceDate.compareTo(o.getServiceDate());
        }
        return 0;
    }

  //eclipse �\�[�X->hashCode()�����equals()�̐����ɂĎ����������ꂽ�R�[�h�ł��B
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((insurerId == null) ? 0 : insurerId.hashCode());
        result = prime * result
                + ((kohiLawNo == null) ? 0 : kohiLawNo.hashCode());
        result = prime * result
                + ((kohiRecipientNo == null) ? 0 : kohiRecipientNo.hashCode());
        return result;
    }

  //eclipse �\�[�X->hashCode()�����equals()�̐����ɂĎ����������ꂽ�R�[�h�ł��B
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QP001KohiKey other = (QP001KohiKey) obj;
        if (insurerId == null) {
            if (other.insurerId != null)
                return false;
        } else if (!insurerId.equals(other.insurerId))
            return false;
        if (kohiLawNo == null) {
            if (other.kohiLawNo != null)
                return false;
        } else if (!kohiLawNo.equals(other.kohiLawNo))
            return false;
        if (kohiRecipientNo == null) {
            if (other.kohiRecipientNo != null)
                return false;
        } else if (!kohiRecipientNo.equals(other.kohiRecipientNo))
            return false;
        return true;
    }



}

