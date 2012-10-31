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
 * �쐬��: 2006/01/21  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �ݑ���x����싋�t��׏� (001)
 * �v���O���� �ݑ���x����싋�t��׏� (QP001P08)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACKanaConvert;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * �ݑ���x����싋�t��׏�(�l���掵) - ���[��`�̃t�@�C���� �F QP001P07X_YYYYMM.xml
 */
public class QP001P07_201204 extends QP001PrintEvent {
	
	/* 
	 * 2009-02-25
	 * [ID:0000447][Shin Fujihara] 2009/02 edit begin ����21�N4���@�����Ή�
	 * �v���O�����̓��e��啝�C��
	 */
	
    ACDateFormat eraFormat = new ACDateFormat("ggg");
    ACDateFormat eraYearFormat = new ACDateFormat("ee");
    ACDateFormat monthFormat = new ACDateFormat("MM");
    ACDateFormat dayFormat = new ACDateFormat("dd");
    
    
    // ������
    private VRList styleList = null;
    // ���Ǝҏ��
    private VRMap providerMap = null;
    // �Ώێ��Ǝ�
    private VRMap provider = null;
    //�l���ԍ��̕\���E��\��
    private boolean yoshikiBango = true;
    // �w�b�_���p�ɍŏ��̃f�[�^��ޔ����Ă���
    private VRMap header = null;
    private int term = 0;
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P07_201204() {
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
    public boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam)
            throws Exception {
    	
        // ������
        styleList = (VRList) printParam.get("STYLE_DATA");
        // ���Ǝҏ��
        providerMap = (VRMap) printParam.get("PROVIDERS");
        // �w�b�_���p�ɍŏ��̃f�[�^��ޔ����Ă���
        header = (VRMap)((VRList)((VRMap) styleList.get(0)).get("CLAIM_DATA")).get(0);
        // �Ώێ��Ǝ�
        //provider = (VRMap) providerMap.get(((VRMap) styleList.get(0)).get("1001002"));
        provider = (VRMap) providerMap.get(header.get("1001002"));
        
        //�l���ԍ��̕\��������
        if(ACCastUtilities.toInt(printParam.get("YOSHIKI_BANGO"),0) == 0){
            //0�Ȃ�l���ԍ����\���Ƃ���B
            yoshikiBango = false;
        }
    	
        // ���[ID��ݒ�
        addFormat(writer);
        
        // ���t�Ǘ��[�o�͖������Z�o
        int pageCount = (int) Math.ceil((double) styleList.getDataSize() / 2d);

        // ������[�v
        for (int i = 0; i < pageCount; i++) {
            // �y�[�W�J�n
            writer.beginPageEdit(getFormatId());
            
            //�l���ԍ��̕\���ݒ�
            if(!yoshikiBango){
                ACChotarouXMLUtilities.setInvisible(writer, "header1");
                ACChotarouXMLUtilities.setInvisible(writer, "header2");
            }

            // �y�[�W�w�b�_�̐ݒ�
            if (QP001Util.isDate(header.get("1001004"))) {
                Date teikyo = ACCastUtilities.toDate(VRBindPathParser.get("1001004", header) + "01");
                // �T�[�r�X�񋟔N���a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "serviceYMD.h1.w1",
                        eraFormat.format(teikyo));
                // �T�[�r�X�񋟔N���a��N(YY�t�H�[�}�b�g)��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "serviceyear",
                        eraYearFormat.format(teikyo));
                // �T�[�r�X�񋟔N����(MM�t�H�[�}�b�g)��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "servicemonth",
                        monthFormat.format(teikyo));

            }

            // �ی��Ҕԍ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, header, "1001005",
                    "hokensyano");
            // ����S�Ҕԍ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, header, "1001008",
                    "kouhihutanno");
            // ���ƎҔԍ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, header, "1001002",
                    "jigyosyano");
            // ���Ə����̂�ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME", "jigyousyo.h3.w3");
            // ���Ə��X�֔ԍ��̑O���R����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, provider,
                    "PROVIDER_ZIP_FIRST", "jigyousyozip1");
            // ���Ə��X�֔ԍ��̌㔼�S����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, provider,
                    "PROVIDER_ZIP_SECOND", "jigyousyozip2");
            // ���Ə��̏��ݒn��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, provider,
                    "PROVIDER_ADDRESS", "jigyousyo.h2.w14");
            // ���Ə��̓d�b�ԍ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "jigyousyo.h6.w22",
                    QkanCommon.toTel(ACCastUtilities.toString(VRBindPathParser
                            .get("PROVIDER_TEL_FIRST", provider)),
                            ACCastUtilities.toString(VRBindPathParser.get(
                                    "PROVIDER_TEL_SECOND", provider)),
                            ACCastUtilities.toString(VRBindPathParser.get(
                                    "PROVIDER_TEL_THIRD", provider))));

            // �P����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "tanka", getTanka(header.get("1001006")));

            // 1�ł�����̔�ی��Ґ���2��
            for (int j = 1; j < 3; j++) {
                if (styleList.getDataSize() == 0) {
                    // �u�����v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "meiji" + j);
                    // �u�吳�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "taisyo" + j);
                    // �u���a�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "syowa" + j);

                    // �v�x���́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);

                    // �v�x���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                    // �v�x���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                    
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities
                            .setInvisible(writer, "youkaigo1" + j);
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities
                            .setInvisible(writer, "youkaigo2" + j);
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities
                            .setInvisible(writer, "youkaigo3" + j);
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities
                            .setInvisible(writer, "youkaigo4" + j);
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities
                            .setInvisible(writer, "youkaigo5" + j);

                    // �u���v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "woman" + j);
                    // �u�j�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "man" + j);
                    continue;
                }

                VRMap main_map = (VRMap) styleList.get(0);
                VRList claim_data = (VRList)main_map.get("CLAIM_DATA");
                VRMap map = (VRMap)claim_data.get(0);

                // ���Ԃ�ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "grdKouban" + j + ".h4.w1", Integer.toString(i * 2 + j));

                // ��ی��Ҕԍ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, map, "1001007",
                        "hihokensyano" + j);

                // ����󋋎Ҕԍ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, map, "1001009",
                        "kouhijyukyusya" + j);

                if (QP001Util.isDate(map.get("1001010"))) {
                    Date birthDay = ACCastUtilities.toDate(VRBindPathParser
                            .get("1001010", map));

                    String era = eraFormat.format(birthDay);

                    // �u�����v�̏ꍇ
                    if ("����".equals(era)) {
                        // �u�吳�v�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "taisyo" + j);
                        // �u���a�v�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "syowa" + j);

                        // �u�吳�v�̏ꍇ
                    } else if ("�吳".equals(era)) {
                        // �u�����v�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "meiji" + j);
                        // �u���a�v�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "syowa" + j);

                        // �u���a�v�̏ꍇ
                    } else if ("���a".equals(era)) {
                        // �u�����v�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "meiji" + j);
                        // �u�吳�v�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "taisyo" + j);

                        // ��L�ȊO�͕\��������
                    } else {
                        // �u�����v�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "meiji" + j);
                        // �u�吳�v�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "tasiyo" + j);
                        // �u���a�v�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "syowa" + j);
                    }

                    // ���N�����̘a��N����ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h2.w", eraYearFormat.format(birthDay), 2, 2);
                    // ���N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h2.w", monthFormat.format(birthDay), 5, 2);
                    // ���N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h2.w", dayFormat.format(birthDay), 8, 2);
                }

                if (!ACTextUtilities.isNullText(VRBindPathParser.get("1001012",map))) {
                    switch (ACCastUtilities.toInt(VRBindPathParser.get("1001012", map))) {
                    // �u11-�v�x���v�̏ꍇ
                    case 11:
                        // �v�x���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // �v�x���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // �v���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // �v���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // �v���R�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // �v���S�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // �v���T�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;

                    // �u12-�v�x���P�v�̏ꍇ
                    case 12:
                        // �v�x���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // �v�x���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // �v���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // �v���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // �v���R�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // �v���S�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // �v���T�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;
                    // �u13-�v�x���Q�v�̏ꍇ
                    case 13:
                        // �v�x���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // �v�x���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // �v���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // �v���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // �v���R�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // �v���S�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // �v���T�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;
                    // �u21-�v���P�v�̏ꍇ
                    case 21:
                        // �v�x���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // �v�x���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // �v�x���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // �v���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // �v���R�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // �v���S�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // �v���T�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;

                    // �u22-�v���Q�v�̏ꍇ
                    case 22:
                        // �v�x���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // �v�x���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // �v�x���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // �v���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // �v���R�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // �v���S�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // �v���T�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;

                    // �u23-�v���R�v�̏ꍇ
                    case 23:
                        // �v�x���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // �v�x���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // �v�x���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // �v���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // �v���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // �v���S�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // �v���T�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;

                    // �u24-�v���S�v�̏ꍇ
                    case 24:
                        // �v�x���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // �v�x���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // �v�x���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // �v���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // �v���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // �v���R�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // �v���T�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;

                    // �u25-�v���T�v�̏ꍇ
                    case 25:
                        // �v�x���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // �v�x���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // �v�x���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // �v���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // �v���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // �v���R�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // �v���S�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        break;

                    // ��L�ȊO�̏ꍇ
                    default:
                        // �v�x���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                        // �v�x���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien1" + j);
                        // �v�x���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youshien2" + j);
                        // �v���P�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                        // �v���Q�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                        // �v���R�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                        // �v���S�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                        // �v���T�́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                        break;
                    }

                } else {
                    // �v�x���́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien" + j);
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1" + j);
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2" + j);
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3" + j);
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4" + j);
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5" + j);
                }

                //��ی��҃t���K�i��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "hihodata1" + j
                        + ".h1.w13", ACKanaConvert.toKatakana(QkanCommon.toFullName(main_map
                        .get("PATIENT_FAMILY_KANA"), main_map
                        .get("PATIENT_FIRST_KANA"))));
                
                //��ی��Ҏ�����ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "hihodata1" + j
                        + ".h2.w13", QkanCommon.toFullName(main_map
                        .get("PATIENT_FAMILY_NAME"), main_map
                        .get("PATIENT_FIRST_NAME")));

                //��ی��҂̐��ʃR�[�h���擾����B��1001011�̒l���擾����B
                switch (ACCastUtilities.toInt(VRBindPathParser.get("1001011",
                        map))) {
                //1(�j)�̏ꍇ�B
                case 1:
                    //�u���v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "woman" + j);
                    break;

                //2(��)�̏ꍇ
                case 2:
                    //�u�j�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "man" + j);
                    break;

                default:
                    //�u���v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "woman" + j);
                    //�u�j�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "man" + j);
                    break;
                }

                //�F��L�����ԊJ�n��
                if (QP001Util.isDate(map.get("1001013"))) {
                    Date start = ACCastUtilities.toDate(VRBindPathParser.get(
                            "1001013", map));
                    //�F��L�����ԊJ�n���̘a���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "hihodata2" + j
                            + "h1.w18", eraFormat.format(start));
                    //�F��L�����ԊJ�n���̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h1.w", eraYearFormat
                            .format(start), 19, 2);
                    //�F��L�����ԊJ�n���̘a�(MM�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h1.w", monthFormat
                            .format(start), 22, 2);
                    //�F��L�����ԊJ�n���̘a���(DD�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h1.w", dayFormat
                            .format(start), 25, 2);

                }

                //�F��L�����ԏI����
                if (QP001Util.isDate(map.get("1001014"))) {
                    Date end = ACCastUtilities.toDate(VRBindPathParser.get(
                            "1001014", map));
                    //�F��L�����ԏI�����̘a���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "hihodata2" + j
                            + "h2.w18", eraFormat.format(end));
                    //�F��L�����ԏI�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h2.w", eraYearFormat
                            .format(end), 19, 2);
                    //�F��L�����ԏI�����̘a�(MM�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h2.w", monthFormat
                            .format(end), 22, 2);
                    //�F��L�����ԏI�����̘a���(DD�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h2.w", dayFormat
                            .format(end), 25, 2);

                }

                //����T�[�r�X�v��쐬�˗��͏o�N����
                Date start = null;
                if ((start = ACCastUtilities.toDate(map.get("1001015"),null)) != null) {
                    //����T�[�r�X�v��쐬�˗��͏o�N�����̘a���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "hihodata2" + j
                            + "h3.w12", eraFormat.format(start));
                    //����T�[�r�X�v��쐬�˗��͏o�N�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h3.w", eraYearFormat
                            .format(start), 13, 2);
                    //����T�[�r�X�v��쐬�˗��͏o�N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h3.w", monthFormat
                            .format(start), 16, 2);
                    //����T�[�r�X�v��쐬�˗��͏o�N�����̓�(�c�c�t�H�[�}�b�g)��ݒ肷��B
                    setData(writer, "hihodata2" + j + ".h3.w", dayFormat
                            .format(start), 19, 2);

                }
                
                //�S�����x�������ԍ���ݒ肷��B
                setData(writer, "hihodata2" + j + ".h3.w", pad(map.get("1001022"),8), 3, 8);
                
                
                //�������疾�׈�
                //���׈󎚂ŉ��y�[�W�͔������Ȃ�
                for (int k = 0; k < claim_data.size(); k++) {
                    map = (VRMap)claim_data.get(k);
                    //�T�[�r�X���̂�ݒ肷��
                    ACChotarouXMLUtilities.setValue(writer, map, "1001028", "hihodata3" + j + ".h" + (k + 1) + ".w1");
                    
                    //�T�[�r�X�R�[�h��ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, map, "1001016", "servicecode" + (k + 1) + "" + j);
                    //�P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "tani" + (k + 1) + "" + j, pad(map.get("1001025"),4));
                    //�񐔂�ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "times" + (k + 1) + "" + j, pad(map.get("1001026"),2));
                    //�T�[�r�X�P�ʐ���ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, "servicetime" + (k + 1) + "" + j, pad(map.get("1001017"),5));
                    //�E�v����ݒ肷��B
                    ACChotarouXMLUtilities.setValue(writer, map, "1001023", "hihodata3" +j + ".h" + (k + 1) + ".tekiyo");
                    
                    //���R�[�h�����ԍ���99�̏ꍇ
                    if (ACCastUtilities.toInt(map.get("1001024"),0) == 99) {
                        //�T�[�r�X�P�ʐ����v��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "tanitotal" + j, pad(map.get("1001027"),6));
                        //�������z��ݒ肷��B
                        ACChotarouXMLUtilities.setValue(writer, "seikyutotal" + j, pad(map.get("1001018"),6));
                        
                    }
                }

                styleList.remove(0);
            }
            //�y�[�W�I��
            writer.endPageEdit();

        }

        //��������s�����Ȃ��true��Ԃ��B
        return true;
    }

    public void addFormat(ACChotarouXMLWriter writer) throws Exception {
    }
    public String getFormatId() throws Exception {
    	return null;
    }
    
    private void setData(ACChotarouXMLWriter writer, String target,
            Object objValue, int start, int pad) throws Exception {
        char values[] = pad(objValue, pad).toCharArray();

        for (int i = start; i < start + pad; i++) {
            ACChotarouXMLUtilities.setValue(writer, target + i, String
                    .valueOf(values[i - start]));
        }
    }

    protected String pad(Object value, int pad) throws Exception {
        String temp = "";
        if (!ACTextUtilities.isNullText(value)){
            temp = ACCastUtilities.toString(value);
        }
        StringBuilder padString = new StringBuilder();
        for (int i = 0; i < pad - temp.length(); i++) {
        	//�S�p�ɕύX
            //padString.append(" ");
        	padString.append("�@");
        }
        return padString.toString() + temp;
    }
    /**
     * 12.34�^���̒l��.�𔲂��āA1234�ɕύX���܂��B
     * 5.67�^���̏ꍇ�͐擪�ɋ󔒂������567��ԋp���܂��B
     * @param value
     * @return
     * @throws Exception
     */
    protected String getTanka(Object value) throws Exception {
        if (ACTextUtilities.isNullText(value))
            return "";
        String[] temp = ACCastUtilities.toString(value).split("\\.");
        temp[0] = pad(temp[0], 2);
        if (temp.length == 1){
            return temp[0] + "00";
        } else if(temp.length > 1){
            switch(temp[1].length()){
            case 0:
                temp[1] = "00";
                break;
            case 1:
                temp[1] += "0";
                break;
            }
        }
        return temp[0] + temp[1];

    }
    
    //�񋟓��̊��Ԃ��擾
    public int getTerm() {
    	return this.term;
    }
}
