
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
 * �쐬��: 2006/01/24  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� ���R�[�h���ۃN���X (QP001RecordAbstract)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.vr.util.VRMap;

abstract class QP001RecordAbstract {

    abstract protected String getSerialId();

    /**
     * VRMap�Ɉ����̃L�[�A�l��ݒ肷��B
     * @param result VRMap
     * @param bind_path �ݒ肷��L�[
     * @param value �ݒ肷��l
     * @throws Exception
     */
    public void setData(VRMap result, String bind_path, double value)
            throws Exception {
        setData(result, bind_path, Double.toString(value));
    }
    /**
     * VRMap�Ɉ����̃L�[�A�l��ݒ肷��B
     * @param result VRMap
     * @param bind_path �ݒ肷��L�[
     * @param value �ݒ肷��l
     * @throws Exception
     */
    public void setData(VRMap result, String bind_path, int value)
            throws Exception {
        setData(result, bind_path, Integer.toString(value));
    }
    /**
     * VRMap�Ɉ����̃L�[�A�l��ݒ肷��B
     * @param result VRMap
     * @param bind_path �ݒ肷��L�[
     * @param value �ݒ肷��l
     * @throws Exception
     */
    public void setData(VRMap result, String bind_path, Object value)
            throws Exception {
        
        if((value != null) && ("null".equalsIgnoreCase(String.valueOf(value)))){
            value = null;
        }
        result.put(bind_path, value);
    }
}
