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
 * �쐬��: 2006/01/13  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �ݑ�T�[�r�X��싋�t��׏��i����j (001)
 * �v���O���� �ݑ�T�[�r�X��싋�t��׏��i����j (QP00103)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * �ݑ�T�[�r�X��싋�t��׏��i����j(�l�����) - ���[��`�̃t�@�C���� �F QP001P02X_YYYYYMM.xml
 */
public class QP001P02_201204 extends QP001P02_10Event {

    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P02_201204() {
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
        VRList typeList = getTypeList();
        // �Е����ƃ��R�[�h
        VRList reductionList = getReductionList();

        // ����Ő����Z�o����B�i1�ł�����̖��׏���14���A�W�v����4��)
        // ����������̎󋋂��󂯂Ă���ꍇ�́A�󋋌�����[���o�͂���B
        int pageCount = 1;
        int pageTemp = 1;

        if (detailList.getDataSize() > 0) {
            //pageTemp = (int) Math.ceil((double) detailList.getDataSize() / 14d);
        	pageTemp = (int) Math.ceil((double) detailList.getDataSize() / getDetailRowCount());
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }
        if (typeList.getDataSize() > 0) {
            pageTemp = (int) Math.ceil((double) typeList.getDataSize() / 4d);
            if (pageTemp > pageCount)
                pageCount = pageTemp;
        }

        // ��������[�v
        for (int kohiCount = 0; kohiCount < kohiCountTotal; kohiCount++) {
            // ���R�[�h�̕���
            parseStyle();
            // ��{��񃌃R�[�h
            baseMap = getBaseMap();
            // ���׏�񃌃R�[�h
            detailList = getDetailList();
            // �W�v��񃌃R�[�h
            typeList = getTypeList();
            // �Е����ƃ��R�[�h
            reductionList = getReductionList();

            // ������[�v
            for (int i = 0; i < pageCount; i++) {
                // �y�[�W�J�n
                writer.beginPageEdit(getFormatId());

                // ���[���ʏ���ݒ�
                setPrintHeader(kohiCount);

                // ����T�[�r�X�󋵂�ݒ�
                setKyotakuData();

                // �J�n�A�I���󋵂�ݒ�
                setKaishiDate();
                
                //���׏��̃e�[�u����ݒ�
                //��12���𒴂���ꍇ�́A���y�[�W�Ɉ�
//                setDetailList(detailList,13,kohiCount);
                doPrintDetailList(detailList,kohiCount);

                // �W�v���������[�v����B��4���𒴂���ꍇ�́A���y�[�W�Ɉ�
                setTypeList(typeList,5,kohiCount);

                // �p�����ꖇ�߂̏ꍇ
                if (i == 0) {
                    
                    if(kohiCount == 0){
                        // �ی����t����ݒ肷��B
                        if (!ACTextUtilities.isNullText(VRBindPathParser.get("201029", baseMap))) {
                            ACChotarouXMLUtilities.setValue(writer, "hokenkyufu",
                                            pad(VRBindPathParser.get("201029",baseMap), 3));
                        }
                        // �ی������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "hokenseikyutotal",
                                pad(VRBindPathParser.get("201034", baseMap), 6));
                        
                        // ���p�ҕ��S�z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "riyousyahutantotal", pad(VRBindPathParser.get(
                                        "201035", baseMap), 6));
                    }

                    // ����Ԃɂ�蕪��
                    switch (kohiCount) {
                    // ����1
                    case 0:
                        // ����t����ݒ肷��B
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201030",
                                                baseMap), 3));
                        // ������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201040", baseMap), 6));
                        // ����{�l���S�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201041", baseMap), 6));
                        break;
                    // ����2
                    case 1:
                        // ����t����ݒ肷��B
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201031",
                                                baseMap), 3));
                        // ������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201046", baseMap), 6));
                        // ����{�l���S�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201047", baseMap), 6));
                        break;
                    // ����3
                    case 2:
                        // ����t����ݒ肷��B
                        ACChotarouXMLUtilities
                                .setValue(writer, "kohikyufu",
                                        pad(VRBindPathParser.get("201032",
                                                baseMap), 3));
                        // ������z�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kouhiseikyutotal", pad(VRBindPathParser.get(
                                        "201052", baseMap), 6));
                        // ����{�l���S�̍��v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer,
                                "kohihonnintotal", pad(VRBindPathParser.get(
                                        "201053", baseMap), 6));
                        break;
                    }
                    
                    //����̊g���|�C���g���R�[������B
                    doPrintReductionList(reductionList);


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
    
    /**
     * �l�����Ɨl�����̓�̍�����⊮����
     * @param printParam
     * @param reductionList
     * @throws Exception
     */
    public void doPrintReductionList(VRList reductionList) throws Exception{
        
    }
    /**
     * �l�����Ɨl�����̓�̍�����⊮����
     * @param printParam
     * @param reductionList
     * @throws Exception
     */
    public void doPrintDetailList(VRList detailList,int kohiCount) throws Exception {
        
    }

    public void addFormat() throws Exception {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        
    }

    public String getFormatId() throws Exception {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return null;
    }
    
    public double getDetailRowCount() {
        return 12d;
    }
    
}
