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
 * �쐬��: 2006/01/19  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X (�ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj (001)
 * �v���O���� (�ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj (QP001P07)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * (�ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj(�l����Z) - ���[��`�̃t�@�C���� �F QP001P06X_YYYYMM.xml
 */
public class QP001P06_201204 extends QP001P02_10Event {
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P06_201204() {
    }

    /**
     * ���[�𐶐����܂��B
     * 
     * @param writer
     *            ����Ǘ��N���X
     * @param printParam
     *            ����p�����^
     * @throws Exception
     *             ������O
     */
    public boolean doPrintImpl(VRMap printParam) throws Exception {

        // ��{��񃌃R�[�h
        VRMap baseMap = getBaseMap();
        // ���׏�񃌃R�[�h�W��
        VRList detailList = getDetailList();
        // �W�v��񃌃R�[�h
        VRMap typeMap = getTypeMap();

        // ����Ő����Z�o����B�i1�ł�����̖��׏���7���A��������҉��T�[�r�X�����4��)
        // ����������̎󋋂��󂯂Ă���ꍇ�́A�󋋌�����[���o�͂���B
        int pageCount = 1;
        int pageTemp = 1;

        // ����Ő����Z�o����B�i1�ł�����̖��׏���11��)
        if (detailList.getDataSize() > 0) {
            //pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 11d);
            pageTemp = (int) Math.ceil((double) detailList.getDataSize() / (double)getDetailRowCount());
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }

        // ��������[�v
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            // ���R�[�h�̕���
            parseStyle();
            // ��{��񃌃R�[�h
            baseMap = getBaseMap();
            // ���׏�񃌃R�[�h�W��
            detailList = getDetailList();
            // �W�v��񃌃R�[�h
            typeMap = getTypeMap();

            // ������[�v
            for (int i = 0; i < pageCount; i++) {
                // �y�[�W�J�n
                writer.beginPageEdit(getFormatId());

                // ���[���ʏ���ݒ�
                setPrintHeader(kohiCount);
                
                //�K�v�ł���Γ����O�̏󋵂�ݒ�
                doPrintExternalUseHeader(baseMap, typeMap);
                
                //�ދ���ݒ�
                setNyusyoDate();
                
                setKyotakuData();

                // ���׌��������[�v����B���s���𒴂���ꍇ�́A���y�[�W�Ɉ�
                setDetailList(detailList,getDetailRowCount() + 1, kohiCount);

                if (i == 0) {
                    //�T�[�r�X�P�ʐ����v��ݒ肷��B�@���T�[�r�X�P�ʐ��̍��Z��ݒ�B
                    //setValue(servicetimetotal);
                    ACChotarouXMLUtilities.setValue(writer,"servicetimetotal", pad(String.valueOf(getServiceUnitTotal()),5));
                    //����ΏےP�ʐ����v��ݒ肷��B�@������ΏےP�ʐ��̍��Z��ݒ�B
                    switch(kohiCount){
                    case 0:
                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal1()),5));
// 2015/5/21 [Yoichiro Kamei] add - begin ����֘A������ 
                        //����t����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201030"),3));
                        //����̋��t�P�ʐ����v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kouhitanitotal", pad(baseMap.get("201039"),6));
                        //������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(baseMap.get("201040"),6));
                        //����p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohiriyosyafutan", pad(baseMap.get("201041"),6));
// 2015/5/21 [Yoichiro Kamei] add - end
                        break;
                    case 1:
                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal2()),5));
// 2015/5/21 [Yoichiro Kamei] add - begin ����֘A������ 
                        //����t����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201031"),3));
                        //����̋��t�P�ʐ����v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kouhitanitotal", pad(baseMap.get("201045"),6));
                        //������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(baseMap.get("201046"),6));
                        //����p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohiriyosyafutan", pad(baseMap.get("201047"),6));
// 2015/5/21 [Yoichiro Kamei] add - end
                        break;
                    case 2:
                        ACChotarouXMLUtilities.setValue(writer,"kohitanitotal",pad(String.valueOf(getKohiTotal3()),5));
// 2015/5/21 [Yoichiro Kamei] add - begin ����֘A������
                        //����t����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201032"),3));
                        //����̋��t�P�ʐ����v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kouhitanitotal", pad(baseMap.get("201051"),6));
                        //������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(baseMap.get("201052"),6));
                        //����p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "kohiriyosyafutan", pad(baseMap.get("201053"),6));
// 2015/5/21 [Yoichiro Kamei] add - end
                        break;
                    }
// 2015/5/21 [Yoichiro Kamei] mod - begin ����֘A������ 
// �����o�O�C�� ��Lswitch(kohiCount)���Ō���ʂɐݒ���s���K�v����
//                    //����̒P�ʐ����v��ݒ肷��B
//                    ACChotarouXMLUtilities.setValue(writer, "kouhitanitotal", pad(baseMap.get("201039"),6));
// 2015/5/21 [Yoichiro Kamei] mod - end
                    
                    //�P�ʐ��P����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "tanka", getTanka(typeMap.get("701015")));
                    
// 2015/5/21 [Yoichiro Kamei] mod - begin ����֘A������ 
// �����o�O�C�� ��Lswitch(kohiCount)���Ō���ʂɐݒ���s���K�v����
//                    //����t����ݒ肷��B
//                    ACChotarouXMLUtilities.setValue(writer, "kohikyufu", pad(baseMap.get("201030"),3));
// 2015/5/21 [Yoichiro Kamei] mod - end
                    
                    if(kohiCount == 0){
                        //�ی����t����ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenkyufu", pad(baseMap.get("201029"),3));
                        //�ی������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyu", pad(baseMap.get("201034"),6));
                        //�ی����p�ҕ��S�z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenriyosyafutan", pad(baseMap.get("201035"),6));
                    }
                    
// 2015/5/21 [Yoichiro Kamei] mod - begin ����֘A������ 
// �����o�O�C�� ��Lswitch(kohiCount)���Ō���ʂɐݒ���s���K�v����
//                    //������z��ݒ肷��B
//                    ACChotarouXMLUtilities.setValue(writer, "kohiseikyu", pad(baseMap.get("201040"),6));
//                    //����p�ҕ��S�z��ݒ肷��B
//                    ACChotarouXMLUtilities.setValue(writer, "kohiriyosyafutan", pad(baseMap.get("201041"),6));
// 2015/5/21 [Yoichiro Kamei] mod - end
                    
                    //�O�����p�^�̐ݒ���s��
                    doPrintExternalUse(baseMap,typeMap);
                    
                }

                //����y�[�W������2���ȏ�̏ꍇ
                if ((kohiCountTotal * pageCount) > 1) {
                    //�o�̓y�[�W���̑�����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "totalpage",
                            ACCastUtilities.toString((kohiCountTotal * pageCount)));
                    //���݂̏o�̓y�[�W����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "nowpage",
                            ACCastUtilities.toString(((kohiCount * pageCount) +i + 1)));
                }

                //�y�[�W�I��
                writer.endPageEdit();

            }
        }
        //��������s�����Ȃ��true��Ԃ��B
        return true;
    }
    
    // ���ׂ̍s��
    protected int getDetailRowCount() {
        return 11;
    }
    
    //�e���[�̌ʐݒ�i�S���y�[�W���ʁj
    protected void doPrintExternalUseHeader(VRMap baseMap, VRMap typeMap) throws Exception{
    }
    
    //�e���[�̌ʐݒ�i1�y�[�W�ڂ̂݁j
    protected void doPrintExternalUse(VRMap baseMap, VRMap typeMap) throws Exception{
    }

}
