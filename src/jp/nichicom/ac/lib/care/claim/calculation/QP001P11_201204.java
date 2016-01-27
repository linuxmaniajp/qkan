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
 * �X�V��: 2015/01/23  MIS��B�@�����@�l���ύX�Ή�
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X ���t�Ǘ��[ (001)
 * �v���O���� ���t�Ǘ��[ (QP001P01)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

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
 * ���t�Ǘ��[(�l����\��) ���[��`�̃t�@�C���� �F QP001P110_YYYYMM.xml
 */
public class QP001P11_201204 extends QP001PrintEvent {

    ACDateFormat eraFormat = new ACDateFormat("ggg");

    ACDateFormat eraYearFormat = new ACDateFormat("ee");

    ACDateFormat monthFormat = new ACDateFormat("MM");

    ACDateFormat dayFormat = new ACDateFormat("dd");

    ACDateFormat eraAllFormat = new ACDateFormat("ee �N MM �� dd �� ");
    
    ACDateFormat periodFormat = new ACDateFormat("ee �N MM ��");

    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P11_201204() {
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
        // �K�v�ł���Β��[ID�����������邱�ƁB
        ACChotarouXMLUtilities.addFormat(writer, "QP001P110_201204", "QP001P110_201204.xml");

        // ���[���
        VRList styles = (VRList) printParam.get("STYLE_DATA");
        // ���Ə����
        VRMap providerMap = (VRMap) printParam.get("PROVIDERS");
        // ���p�ҏ��
        VRMap patient = (VRMap) printParam.get("PATIENT");
        
        VRMap header = (VRMap)styles.get(0);
        
        boolean yoshikiBango = true;
        //�l���ԍ��̕\��������
        if(ACCastUtilities.toInt(printParam.get("YOSHIKI_BANGO"),0) == 0){
            //0�Ȃ�l���ԍ����\���Ƃ���B
            yoshikiBango = false;
        }
        
        int totalUnit = 0;
        Map<String, VRMap> sorter = new TreeMap<String, VRMap>();
        // ���t�v��P�ʐ����v
        for(int i = 0; i < styles.size(); i++){
            VRMap map = (VRMap)styles.get(i);
            //99���R�[�h�͔���
            if(ACTextUtilities.isNullText(map.get("1201019"))){
                header = map;
                continue;
            }
            
            totalUnit += ACCastUtilities.toInt(map.get("1201020"));
            
            //�T�[�r�X��ރR�[�h-���Ə��ԍ��Ń\�[�g
            sorter.put(String.valueOf(map.get("1201019")) + "-" + String.valueOf(map.get("1201017")),map);
        }
        styles.clear();
        Iterator<String> it = sorter.keySet().iterator();
        while(it.hasNext()){
            styles.add(sorter.get(it.next()));
        }

        // �y�[�W���̃g�[�^��
        int pageCount = (int) Math.ceil(((double) styles.size() / 20));

        // �y�[�W�w�b�_�[�쐬

        // �y�[�W�������[�v
        for (int i = 0; i < pageCount; i++) {
            
            writer.beginPageEdit("QP001P110_201204");
            
            // �y�[�W�J�n
            if (QP001Util.isDate(header.get("1201002"))) {
                Date targetDate = ACCastUtilities.toDate(VRBindPathParser.get("1201002", header) + "01");
                // �Ώ۔N���̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "wareki", eraFormat
                        .format(targetDate));
                // �Ώ۔N���̘a��N(�x�x�t�H�[�}�b�g)��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "warekinen",
                        eraYearFormat.format(targetDate));
                // �Ώ۔N���̌�(MM�t�H�[�}�b�g)��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "warekitsuki",
                        monthFormat.format(targetDate));
            }
            
            //�o�͂��钠�[�̒�`�̂�ύX����K�v�����邽�߁A���W�b�N�̈ʒu��ύX
            //�l���ԍ��̕\���ݒ�
            if(!yoshikiBango){
                ACChotarouXMLUtilities.setInvisible(writer, "header1");
                ACChotarouXMLUtilities.setInvisible(writer, "header2");
            }

            // �ی��Ҕԍ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, header, "1201003",
                    "hokensyano");

            // �ی��Җ��̂�ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, header, "1201028",
            "data1.h2.w11");

            // ��ی��Ҕԍ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, header, "1201009",
                    "hihokensyano");

            // ��ی��҂̃t���K�i��ݒ肷��B �����p�҃}�X�^�Ɠˍ�
            ACChotarouXMLUtilities.setValue(writer, "data1.h4.w12", ACKanaConvert.toKatakana(QkanCommon
                    .toFullName(ACCastUtilities.toString(VRBindPathParser.get(
                            "PATIENT_FAMILY_KANA", patient)), ACCastUtilities
                            .toString(VRBindPathParser.get(
                                    "PATIENT_FIRST_KANA", patient)))));

            // ��ی��҂̎�����ݒ肷��B �����p�҂̃}�X�^�Ɠˍ�
            ACChotarouXMLUtilities.setValue(writer, "data1.h5.w11", QkanCommon
                    .toFullName(ACCastUtilities.toString(VRBindPathParser.get(
                            "PATIENT_FAMILY_NAME", patient)), ACCastUtilities
                            .toString(VRBindPathParser.get(
                                    "PATIENT_FIRST_NAME", patient))));

            if (QP001Util.isDate(header.get("1201010"))) {
                // ��ی��Ґ��N�����̘a����擾����B ��1201010���擾
                Date birthDay = ACCastUtilities.toDate(VRBindPathParser.get(
                        "1201010", header));

                String era = eraFormat.format(birthDay);
                // �u�����v�̏ꍇ
                if ("����".equals(era)) {
                    // �u�吳�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
                    // �u���a�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "syowa");

                    // �u�吳�v�̏ꍇ
                } else if ("�吳".equals(era)) {
                    // �u�����v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "meiji");
                    // �u���a�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "syowa");

                    // �u���a�v�̏ꍇ
                } else if ("���a".equals(era)) {
                    // �u�����v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "meiji");
                    // �u�吳�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
                } else {
                    // �u�����v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "meiji");
                    // �u�吳�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
                    // �u���a�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "syowa");
                }
                
                // ���N�����̘a��N����ݒ肷��B ��YY�NMM��DD���^���ŏo��
                ACChotarouXMLUtilities.setValue(writer, "data2.h3.w1",
                        eraAllFormat.format(birthDay));

            }

            // ��ی��҂̐��ʃR�[�h���擾����B ��1201011���擾
            if (!ACTextUtilities.isNullText(VRBindPathParser.get("1201011",
                    header))) {

                switch (ACCastUtilities.toInt(VRBindPathParser.get("1201011",
                        header))) {
                // 1(�j)�̏ꍇ�B
                case 1:
                    // �u���v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "woman");
                    break;

                // 2(��)�̏ꍇ
                case 2:
                    // �u�j�v�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "man");
                    break;

                default:
                    ACChotarouXMLUtilities.setInvisible(writer, "man");
                    ACChotarouXMLUtilities.setInvisible(writer, "woman");
                    break;
                }
            } else {
                ACChotarouXMLUtilities.setInvisible(writer, "man");
                ACChotarouXMLUtilities.setInvisible(writer, "woman");
            }

            // ��ی��҂̗v����ԋ敪���擾����B ��1201012���擾
            if (!ACTextUtilities.isNullText(VRBindPathParser.get("1201012",
                    header))) {
                switch (ACCastUtilities.toInt(VRBindPathParser.get("1201012",
                        header))) {
                // �u11-�o�ߓI�v���i�v�x���j�v�̏ꍇ
                case 11:
                    // �v�x���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // �v�x���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // ���ƑΏێ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                //�v�x���P
                case 12:
                    // �o�ߓI�v���i�v�x���j�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // �v�x���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // ���ƑΏێ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;
                //�v�x���Q
                case 13:
                    // �o�ߓI�v���i�v�x���j�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // �v�x���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // ���ƑΏێ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;
                // �u21-�v���P�v�̏ꍇ
                case 21:
                    // �o�ߓI�v���i�v�x���j�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // �v�x���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // �v�x���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // ���ƑΏێ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                // �u22-�v���Q�v�̏ꍇ
                case 22:
                    // �o�ߓI�v���i�v�x���j�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // �v�x���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // �v�x���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // ���ƑΏێ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                // �u23-�v���R�v�̏ꍇ
                case 23:
                    // �o�ߓI�v���i�v�x���j�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // �v�x���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // �v�x���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // ���ƑΏێ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                // �u24-�v���S�v�̏ꍇ
                case 24:
                    // �o�ߓI�v���i�v�x���j�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // �v�x���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // �v�x���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // ���ƑΏێ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                // �u25-�v���T�v�̏ꍇ
                case 25:
                    // �o�ߓI�v���i�v�x���j�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // �v�x���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // �v�x���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // ���ƑΏێ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;

                //���ƑΏێ� [H27.4�@�����Ή�][Shinobu.Hitaka]���r���Ŏ��ƑΏێ҂���v�x���P�֋�ς����ꍇ
                case 6:
                    // �o�ߓI�v���i�v�x���j�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // �v�x���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // �v�x���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    break;
                        
                // ��L�ȊO�̏ꍇ
                default:
                    // �o�ߓI�v���i�v�x���j�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "keikatekiyoukaigo");
                    // �v�x���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                    // �v�x���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                    // �v���P�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                    // �v���Q�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                    // �v���R�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                    // �v���S�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                    // �v���T�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                    // ���ƑΏێ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisyo1");
                    break;
                }
            }

            // ����T�[�r�X�x�����x��z��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, header, "1201015","tani");

            if (QP001Util.isDate(header.get("1201013"))) {
                Date start = ACCastUtilities.toDate(VRBindPathParser.get("1201013", header) + "01");

                // ���x�z�K�p���ԊJ�n���̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "data2.h5.w2",eraFormat.format(start));
                ACChotarouXMLUtilities.setValue(writer, "data2.h6.w2",periodFormat.format(start));
            }

            // ���x�z�K�p���ԏI����
            if (QP001Util.isDate(header.get("1201014"))) {
                Date end = ACCastUtilities.toDate(VRBindPathParser.get("1201014", header) + "01");

                // ���x�z�K�p���ԏI�����̘a���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "data2.h5.w5",eraFormat.format(end));
                ACChotarouXMLUtilities.setValue(writer, "data2.h6.w5",periodFormat.format(end));
            }

            // �쐬�敪���擾����B ��1201016���擾�B
            if (!ACTextUtilities.isNullText(VRBindPathParser.get("1201016",
                    header))) {
                switch (ACCastUtilities.toInt(VRBindPathParser.get("1201016",
                        header))) {
                // �u1-������x�����Ə��쐬�v�̏ꍇ
                case 1:
                    // ���ȍ쐬�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jiko");
                    // ���\�h�x�����Ǝ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "kaigoyobojigyousya");
                    break;

                // �u2-���ȍ쐬�v�̏ꍇ
                case 2:
                    // ������x�����Ə��쐬�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyosyo");
                    // ���\�h�x�����Ǝ҂́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "kaigoyobojigyousya");
                    break;
                    
                // �u3-���\�h�x�����Ǝҍ쐬�v�̏ꍇ
                case 3:
                    // ������x�����Ə��쐬�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyosyo");
                    // ���ȍ쐬�́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "jiko");
                    break;
                    
                default:
                    ACChotarouXMLUtilities.setInvisible(writer, "jigyosyo");
                    ACChotarouXMLUtilities.setInvisible(writer, "jiko");
                    ACChotarouXMLUtilities.setInvisible(writer, "kaigoyobojigyousya");
                    break;

                }
            } else {
                ACChotarouXMLUtilities.setInvisible(writer, "jigyosyo");
                ACChotarouXMLUtilities.setInvisible(writer, "jiko");
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoyobojigyousya");
            }

            // ������x�����Ə��ԍ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, header, "1201004",
                    "jigyosyono");
            
            
            //�S�����x�������ԍ�
            ACChotarouXMLUtilities.setValue(writer, header, "1201025",
                    "senmoninno");
            
            VRMap ownerProvider = (VRMap)providerMap.get(header.get("1201004"));

            // ������x�����Ə��̎��Ə�����ݒ肷��B �����Ə��̃}�X�^�f�[�^�Ɠˍ�
            ACChotarouXMLUtilities.setValue(writer, ownerProvider, "PROVIDER_NAME", "jigyosyodata.h5.w2");

            // ������x�����Ə��̎��Ə����ݒn��ݒ肷��B �����Ə��̃}�X�^�f�[�^�Ɠˍ�
            ACChotarouXMLUtilities.setValue(writer, ownerProvider, "PROVIDER_ADDRESS", "jigyosyodata.h6.w2");

            // ������x�����Ə��̘A����i�d�b�ԍ��j��ݒ肷��B �����Ə��̃}�X�^�f�[�^�Ɠˍ�
            String tel = QkanCommon.toTel(ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_TEL_FIRST",ownerProvider)),
                                          ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_TEL_SECOND",ownerProvider)),
                                          ACCastUtilities.toString(VRBindPathParser.get("PROVIDER_TEL_THIRD",ownerProvider)));
            
            
            ACChotarouXMLUtilities.setValue(writer, "jigyosyodata.h7.w5", tel);
            
            //�S�����x�������ԍ�
            ACChotarouXMLUtilities.setValue(writer, header, "1201026","itakuproviderid");
            //�ϑ���̒S�����x�������ԍ�
            ACChotarouXMLUtilities.setValue(writer, header, "1201027","itakusenmoninno");
            
            // ���t�Ǘ����������[�v����B��20���𒴂���ꍇ�́A���y�[�W�Ɉ�
            for (int j = 1; j < 21; j++) {
                if (styles.size() <= 0) {
                    // �w�莖�Ə��́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "sitei" + j);
                    // ��Y���́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "kijyun" + j);
                    // �n�斧���́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "tiiki" + j);
                    continue;
                }
                
                VRMap style = (VRMap) styles.get(0);
                
                String providerId = ACCastUtilities.toString(VRBindPathParser.get("1201017",style));
                //����T�[�r�X���Ə��̎��Ə�����ݒ肷��B �����Ə��̃}�X�^�Ɠˍ�����B
                VRMap provider = (VRMap)providerMap.get(providerId);
                ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME", "service.h" + j + ".w1");

                // ����T�[�r�X���Ə��̎��Ə��ԍ���ݒ肷��B
                for(int k = 0; k < providerId.length(); k++){
                    ACChotarouXMLUtilities.setValue(writer, "service.h" + j + ".w" + (k + 2), providerId.substring(k,k + 1));
                }

                // �w��^��Y���T�[�r�X���ʂ��擾����B ��1201018���擾�B
                if (!ACTextUtilities.isNullText(VRBindPathParser.get("1201018",
                        style))) {
                    switch (ACCastUtilities.toInt(VRBindPathParser.get(
                            "1201018", style))) {
                    // �u1-�w�莖�Ə��v�̏ꍇ�B
                    case 1:
                        // ��Y���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "kijyun" + j);
                        // �n�斧���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "tiiki" + j);
                        break;

                    // �u2-��Y�����Ə��v�̏ꍇ�B
                    case 2:
                        // �w�莖�Ə��́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "sitei" + j);
                        // �n�斧���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "tiiki" + j);
                        break;
                        
                    // �u3-�n�斧�����Ə��v�̏ꍇ�B
                    case 5:
                        // ��Y���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "kijyun" + j);
                        // �w�莖�Ə��́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "sitei" + j);
                        break;

                    // ��L�ȊO�̏ꍇ
                    default:
                        // �w�莖�Ə��́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "sitei" + j);
                        // ��Y���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "kijyun" + j);
                        // �n�斧���́����\���ɂ���B
                        ACChotarouXMLUtilities.setInvisible(writer, "tiiki" + j);
                        break;

                    }
                } else {
                    // �w�莖�Ə��́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "sitei" + j);
                    // ��Y���́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "kijyun" + j);
                    // �n�斧���́����\���ɂ���B
                    ACChotarouXMLUtilities.setInvisible(writer, "tiiki" + j);
                }

                // �T�[�r�X��ޖ���ݒ肷��B ���T�[�r�X��ނ̃}�X�^�Ɠˍ�����B
                ACChotarouXMLUtilities.setValue(writer, style, "1201029", "service.h" + j + ".w13");

                // �T�[�r�X��ރR�[�h��ݒ肷��B
                String code = String.valueOf(style.get("1201019"));
                for(int k = 0; k < code.length(); k++){
                    ACChotarouXMLUtilities.setValue(writer, "service.h" + j + ".w" + (k + 14), code.substring(k,k + 1));
                }
                
                // ���t�v��P�ʐ���ݒ肷��B
                String unit = String.valueOf(style.get("1201020"));
                int count = 0;
                for(int k = 5 - unit.length(); count < unit.length(); k++,count++){
                    ACChotarouXMLUtilities.setValue(writer, "service.h" + j + ".w" + (k + 16), unit.substring(count,count + 1));
                }

                styles.remove(0);
            }
            
            if(i == 0){
                String total = String.valueOf(totalUnit);
                int count = 0;
                for(int k = 5 - total.length(); count < total.length(); k++,count++){
                    ACChotarouXMLUtilities.setValue(writer, "total.h1.w" + (k + 2), total.substring(count,count + 1));
                }
            }

            // �y�[�W�I��
            writer.endPageEdit();
        }
        // ��������s�����Ȃ��true��Ԃ��B
        return true;
    }

}
