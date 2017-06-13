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

import java.util.Collections;
import java.util.Date;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.ac.text.ACDateFormat;
import jp.nichicom.ac.text.ACKanaConvert;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.nichicom.vr.util.logging.VRLogger;
import jp.or.med.orca.qkan.QkanCommon;

/**
 * ����C�x���g<br>
 * <br>
 * �ݑ�T�[�r�X��싋�t��׏��i����j�C�x���g��`-�l����� <br>
 * <br>
 * �ݑ�T�[�r�X��싋�t��׏��i�Z�������������j�C�x���g��`-�l����O<br>
 * <br>
 * �ݑ�T�[�r�X��싋�t��׏��i���V�l�ی��{�݁j�C�x���g��`-�l����l<br>
 * <br>
 * (�ݑ�T�[�r�X��싋�t��׏��i�a�@�E�f�Ï��ɂ�����Z�������×{���j)�C�x���g��`-�l�����<br>
 * <br>
 * (�ݑ�T�[�r�X��싋�t��׏��i�F�m�ǑΉ��^�E����{�ݓ����ҁj�C�x���g��`-�l����Z<br>
 * <br>
 * �{�݃T�[�r�X����싋�t��׏��i��앟���{�݁j�C�x���g��`-�l���攪<br>
 * <br>
 * �{�݃T�[�r�X����싋�t��׏��i���V�l�ی��{�݁j�C�x���g��`-�l�����<br>
 * <br>
 * �{�݃T�[�r�X����싋�t��׏��i���×{�^�{��)�C�x���g��`-�l����\<br>
 * <br>
 */
public class QP001P02_10Event extends QP001PrintEvent {

    ACChotarouXMLWriter writer = null;

    int kohiCountTotal = 1;

    ACDateFormat eraFormat = new ACDateFormat("ggg");

    ACDateFormat eraYearFormat = new ACDateFormat("ee");

    ACDateFormat monthFormat = new ACDateFormat("MM");

    ACDateFormat dayFormat = new ACDateFormat("dd");

    // ������
    Date seikyuDate = null;

    // �������
    private VRList styleList = null;

    // ���p�ҏ��
    private VRMap patient = null;

    // ���Ə����
    private VRMap providerMap = null;

    private VRMap provider = null;

    // ��{��񃌃R�[�h
    private VRMap baseMap = null;

    // ���׏�񃌃R�[�h�i�������R�[�h�j
    private VRList detailList = null;

    // �ً}���{�ݗ×{��񃌃R�[�h�i�������R�[�h�j
    private VRList emergencyList = null;
    
    // �ً}���{�ݗ×{�E���{�ݗ×{���񃌃R�[�h�i�������R�[�h�j
    private VRList emergencyOwnFacilityList = null;

    // ����f�Ô��񃌃R�[�h�i�������R�[�h�j
    private VRList diagnosisList = null;

    // �W�v��񃌃R�[�h�i�������R�[�h�j
    private VRList typeList = null;

    // ��������҉��T�[�r�X��p��񃌃R�[�h�i�������R�[�h�j
    private VRList nursingList = null;

    // �Љ���@�l�y���z��񃌃R�[�h�i�������R�[�h�j
    private VRList reductionList = null;
    
 // 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
 // ���׏��i�Z���n����j���R�[�h�i�������R�[�h�j
    private VRList detailJushotiTokureiList = null;
 // 2015/1/14 [Yoichiro Kamei] add - end

    // �T�[�r�X�P�ʐ����v
    private int serviceUnitTotal = 0;
    // ����P�P�ʐ����v
    private int kohiTotal1 = 0;
    // ����Q�P�ʐ����v
    private int kohiTotal2 = 0;
    // ����R�P�ʐ����v
    private int kohiTotal3 = 0;
    
    //��������҂��󎚂������J�E���g��ێ�
    int nursingCount = 0;
    
    
    //�l���ԍ��̈��
    private boolean yoshikiBango = true;
    
    //[ID:0000449][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
    private boolean printNursingZero = false;
    //[ID:0000449][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
    //[ID:0000651][Shin Fujihara] 2011/07/06 add begin ���S���x�z0�~�\���Ή�
    private boolean printNursingLimitZero = false;
    //[ID:0000651][Shin Fujihara] 2011/07/06 add end ���S���x�z0�~�\���Ή�
    
    private VRMap serviceName = null;
    
    QP001Manager manager = null;
    
    //[H20.5 �@�����Ή�] fujihara add start
    private int term = 0;
    //[H20.5 �@�����Ή�] fujihara add end
    
    /**
     * �R���X�g���N�^�ł��B
     */
    public QP001P02_10Event() {
    }

    /**
     * ������܂��B
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

        //���C�^�[��ݒ�
        this.writer = writer;
        
        //------���ʂ̈���f�[�^���擾����----------------//
        // ������
        styleList = (VRList) printParam.get("STYLE_DATA");
        // ���p�ҏ��
        patient = (VRMap) printParam.get("PATIENT");
        // ���Ǝҏ��
        providerMap = (VRMap) printParam.get("PROVIDERS");
        //�T�[�r�X����
        serviceName = (VRMap)printParam.get("SERVICE_NAME");
        
        manager = (QP001Manager)printParam.get("MANAGER");
        // �f�[�^���
        parseStyle();

        //�Ώی�
        seikyuDate = VRDateParser.parse(baseMap.get("201003") + "01");
        // �Ώێ��Ǝ�(201004)
        provider = (VRMap) providerMap.get(baseMap.get("201004"));
        
        //[H20.5 �@�����Ή�] fujihara add start
        term = QP001Util.getTerm(seikyuDate);
        //[H20.5 �@�����Ή�] fujihara add end
        
        // �쐬���Ǝ�(201019)
        // del sta 2006.05.14 shin.fujihara
        //provider_make = (VRMap) providerMap.get(baseMap.get("201020"));
        // del end 2006.05.14 shin.fujihara

        // ��������擾����B
        // ����2�̃f�[�^�����݂��邩�B
        if (!ACTextUtilities.isNullText(VRBindPathParser.get("201059",
                getBaseMap()))
                && (!"0".equals(String.valueOf(VRBindPathParser.get("201059", getBaseMap()))))) {
            kohiCountTotal = 2;
            
            //��������҈󎚑Ή�
            //����̓K�p������ꍇ�A���ۂ݈̂󎚂��s��
            //[H20.5 �@�����Ή�] fujihara edit start
            //���ہA�����c���M�l������̏ꍇ�݈̂󎚂��s���悤�C��
            //if("1201".equals(String.valueOf(VRBindPathParser.get("201059", getBaseMap())))){
            String kohiNo = String.valueOf(VRBindPathParser.get("201059", getBaseMap()));
            if("1201,2501".indexOf(kohiNo) != -1){
            //[H20.5 �@�����Ή�] fujihara edit end
                nursingCount = 1;
            }
        }
        // ����3�̃f�[�^�����݂��邩�B
        if (!ACTextUtilities.isNullText(VRBindPathParser.get("201060",
                getBaseMap()))
                && (!"0".equals(String.valueOf(VRBindPathParser.get("201060", getBaseMap()))))) {
            kohiCountTotal = 3;
            //��������҈󎚑Ή�
            //����̓K�p������ꍇ�A���ۂ݈̂󎚂��s��
            //[H20.5 �@�����Ή�] fujihara edit start
            //���ہA�����c���M�l������̏ꍇ�݈̂󎚂��s���悤�C��
            //if("1201".equals(String.valueOf(VRBindPathParser.get("201060", getBaseMap())))){
            String kohiNo = String.valueOf(VRBindPathParser.get("201060", getBaseMap()));
            if("1201,2501".indexOf(kohiNo) != -1){
            //[H20.5 �@�����Ή�] fujihara edit end
                nursingCount = 2;
            }
        }
        
        //�T�[�r�X�P�ʐ��̍��v�ƌ���ΏےP�ʐ��̍��v���Z�o
        for(int i = 0; i < detailList.size(); i++){
            VRMap map = (VRMap)detailList.get(i);
            //�T�[�r�X�P�ʐ�
            if(!ACTextUtilities.isNullText(map.get("301014"))){
                serviceUnitTotal += ACCastUtilities.toInt(map.get("301014"));
            }
            //����P�P�ʐ�
            if(!ACTextUtilities.isNullText(map.get("301015"))){
                kohiTotal1 += ACCastUtilities.toInt(map.get("301015"));
            }
            //����Q�P�ʐ�
            if(!ACTextUtilities.isNullText(map.get("301016"))){
                kohiTotal2 += ACCastUtilities.toInt(map.get("301016"));
            }
            //����R�P�ʐ�
            if(!ACTextUtilities.isNullText(map.get("301017"))){
                kohiTotal3 += ACCastUtilities.toInt(map.get("301017"));
            }
        }
        
        //�l���ԍ��̕\��������
        if(ACCastUtilities.toInt(printParam.get("YOSHIKI_BANGO"),0) == 0){
            //0�Ȃ�l���ԍ����\���Ƃ���B
            yoshikiBango = false;
        }
        
        //[ID:0000449][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
        if(ACCastUtilities.toInt(printParam.get("PRINT_NURSING_ZERO"),0) == 1){
            //1�Ȃ��������҂̗��p�ҕ��S�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���
        	printNursingZero = true;
        }
        //[ID:0000449][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
        //[ID:0000651][Shin Fujihara] 2011/07/06 add begin ���S���x�z0�~�\���Ή�
        if(ACCastUtilities.toInt(printParam.get("PRINT_NURSING_LIMIT_ZERO"),0) == 1){
            //1�Ȃ��������҂̕��S���x�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���
        	printNursingLimitZero = true;
        }
        //[ID:0000651][Shin Fujihara] 2011/07/06 add end ���S���x�z0�~�\���Ή�
        
        //���[��`��ID�̐ݒ�
        addFormat();
        
        //�Ǝ��̈�����W�b�N�����s���A���ʂ�ԋp����B
        return doPrintImpl(printParam);
    }

    /**
     * ����f�[�^�̉�͂��s���܂��B
     * 
     * @throws Exception
     */
    protected void parseStyle() throws Exception {
        if (styleList == null)
            return;

        // ������
        detailList = new VRArrayList();
        emergencyList = new VRArrayList();
        emergencyOwnFacilityList = new VRArrayList();
        diagnosisList = new VRArrayList();
        typeList = new VRArrayList();
        nursingList = new VRArrayList();
        reductionList = new VRArrayList();
 // 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
        detailJushotiTokureiList = new VRArrayList();
 // 2015/1/14 [Yoichiro Kamei] add - end

        VRMap map = null;
        int categoryNo = 0;
        // ���R�[�h�̕���
        for (int i = 0; i < styleList.getDataSize(); i++) {
            map = (VRMap) styleList.get(i);
            categoryNo = ACCastUtilities.toInt(VRBindPathParser.get(
                    "CATEGORY_NO", map));

            switch (categoryNo) {
            // ��{��񃌃R�[�h
            case 2:
                baseMap = map;
                break;
            // ���׏�񃌃R�[�h
            case 3:
                detailList.add(map);
                break;
            // �ً}���{�ݗ×{��񃌃R�[�h
            case 4:
                //�ً}���{�ݗ×{��񃌃R�[�h�����ԍ��Ń\�[�g
                if(QP001SpecialCase.isValidRecordEmergency(map)){
                	emergencyList.add(map);
                }
                break;
            // ����f�Ô��񃌃R�[�h
            case 5:
                diagnosisList.add(map);
                break;
            // �W�v��񃌃R�[�h
            case 7:
                //�T�[�r�X��ރR�[�h
                typeList.add(map);
                break;
            // ��������҉��T�[�r�X��p��񃌃R�[�h
            case 8:
                //���R�[�h�����ԍ���0�̃��R�[�h�͕\�����Ȃ��B
                if(ACCastUtilities.toInt(map.get("801007"),0) != 0){
                    //�T�[�r�X�R�[�h
                    nursingList.add(map);
                }
                break;
            // �Е����ƃ��R�[�h
            case 9:
                reductionList.add(map);
                break;
                
            // �ً}���{�ݗ×{�E���{�ݗ×{���񃌃R�[�h
            case 17:
                if (QP001SpecialCase.isValidRecordEmergencyOwnFacility(map)) {
                    emergencyOwnFacilityList.add(map);
                }
                break;
// 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
            // ���׏�񃌃R�[�h
            case 18:
            	detailJushotiTokureiList.add(map);
                break;            
// 2015/1/14 [Yoichiro Kamei] add - end
            }

        }
        
        Collections.sort(detailList,new RecordComparator());
        Collections.sort(emergencyList,new RecordComparator());
        Collections.sort(emergencyOwnFacilityList,new RecordComparator());
        Collections.sort(diagnosisList,new RecordComparator());
        Collections.sort(typeList,new RecordComparator());
        Collections.sort(nursingList,new RecordComparator());
        Collections.sort(reductionList,new RecordComparator());
// 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
        Collections.sort(detailJushotiTokureiList,new RecordComparator());
// 2015/1/14 [Yoichiro Kamei] add - end
        

    }

    /**
     * ���[���ʂ̈���ݒ���s���܂��B
     * 
     * @param writer
     * @throws Exception
     */
    protected void setPrintHeader(int kohiCount) throws Exception {

        //�l���ԍ��̕\���ݒ�
        if(!yoshikiBango){
            ACChotarouXMLUtilities.setInvisible(writer, "header1");
            ACChotarouXMLUtilities.setInvisible(writer, "header2");
        }
        
        switch(kohiCount){
            //����P�����
            case 0:
                // ����S�Ҕԍ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201007","kohifutanno");
                // ����󋋎Ҕԍ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201008","kohijyukyusyano");
                break;
            //����Q�����
            case 1:
                // ����S�Ҕԍ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201009","kohifutanno");
                // ����󋋎Ҕԍ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201010","kohijyukyusyano");
                break;
            //����R�����
            case 2:
                // ����S�Ҕԍ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201011","kohifutanno");
                // ����󋋎Ҕԍ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, baseMap, "201012","kohijyukyusyano");
                break;
        }
        
        // �����N���̘a���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyuYMD.h1.w1", eraFormat
                .format(seikyuDate));
        // �����N���̘a��N(YY�`��)��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikyuyear", eraYearFormat
                .format(seikyuDate));
        // �����N���̌�(MM�`��)��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "seikymonth", monthFormat
                .format(seikyuDate));

        // �ی��Ҕԍ���ݒ肷��B
        ACChotarouXMLUtilities
                .setValue(writer, baseMap, "201005", "hokensyano");
        // ��ی��Ҕԍ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, baseMap, "201006",
                "hihokensyano");

        // ��ی��҂̃t���K�i��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "patientNameKn", ACKanaConvert.toKatakana(QkanCommon
                .toFullName(ACCastUtilities.toString(VRBindPathParser.get(
                        "PATIENT_FAMILY_KANA", patient)), ACCastUtilities
                        .toString(VRBindPathParser.get("PATIENT_FIRST_KANA",
                                patient)))));
        // ��ی��҂̎�����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "patientName", QkanCommon
                .toFullName(ACCastUtilities.toString(VRBindPathParser.get(
                        "PATIENT_FAMILY_NAME", patient)), ACCastUtilities
                        .toString(VRBindPathParser.get("PATIENT_FIRST_NAME",
                                patient))));

        //[ID:0000569][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
        //CSV�t�@�C���̐��N�����ƈ�v������悤�C��
        //Date birthDay = ACCastUtilities.toDate(VRBindPathParser.get(
        //        "PATIENT_BIRTHDAY", patient));
        Date birthDay = ACCastUtilities.toDate(VRBindPathParser.get("201013", baseMap));
        //[ID:0000569][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
        // ��ی��Ґ��N�����̘a����擾����B
        String era = eraFormat.format(birthDay);

        // �u�����v�̏ꍇ
        if ("����".equals(era)) {
            // �u�吳�v�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
            // �u���a�v�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "syowa");
        } else if ("�吳".equals(era)) {
            // �u�����v�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "meiji");
            // �u���a�v�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "syowa");
        } else if ("���a".equals(era)) {
            // �u�����v�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "meiji");
            // �u�吳�v�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
        } else {
            ACChotarouXMLUtilities.setInvisible(writer, "meiji");
            ACChotarouXMLUtilities.setInvisible(writer, "taisyo");
            ACChotarouXMLUtilities.setInvisible(writer, "syowa");
        }

        // ���N�����̘a��N����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "birthyear", eraYearFormat
                .format(birthDay));

        // ���N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "birthmonth", monthFormat
                .format(birthDay));

        // ���N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "birthday", dayFormat
                .format(birthDay));

        // ��ی��҂̐��ʃR�[�h���擾����B
        //[ID:0000569][Shin Fujihara] 2010/01 edit begin 2009�N�x�Ή�
        //CSV�ɏo�͂������ʃR�[�h�ƈ�v����悤�C��
        //switch (ACCastUtilities.toInt(VRBindPathParser.get("PATIENT_SEX",
        //        patient))) {
        switch (ACCastUtilities.toInt(VRBindPathParser.get("201014", baseMap))) {
        //[ID:0000569][Shin Fujihara] 2010/01 edit end 2009�N�x�Ή�
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
            ACChotarouXMLUtilities.setInvisible(writer, "woman");
            ACChotarouXMLUtilities.setInvisible(writer, "man");
            break;
        }

        // ��ی��҂̗v����ԋ敪���擾����B ��201015���擾
        if(!ACTextUtilities.isNullText(VRBindPathParser.get("201015", baseMap))){
            switch (ACCastUtilities.toInt(VRBindPathParser.get("201015", baseMap))) {
            // �u6-���ƑΏێҁv�̏ꍇ
            case 6:
                // �v�x���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // �v�x���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // �v�x���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
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
                    
            // �u11-�v�x��(�o�ߓI�v���)�v�̏ꍇ
            case 11:
                // ���ƑΏێ҂́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
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
                
            // �u12-�v�x���P�v�̏ꍇ
            case 12:
                // ���ƑΏێ҂́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // �v�x���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // �v�x���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
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
                
            // �u13-�v�x���Q�v�̏ꍇ
            case 13:
                // ���ƑΏێ҂́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // �v�x���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // �v�x���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
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
    
            // �u21-�v���P�v�̏ꍇ
            case 21:
                // ���ƑΏێ҂́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // �v�x���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // �v�x���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // �v�x���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // �v���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // �v���R�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // �v���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // �v���T�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
    
            // �u22-�v���Q�v�̏ꍇ
            case 22:
                // ���ƑΏێ҂́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // �v�x���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // �v�x���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // �v�x���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // �v���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // �v���R�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // �v���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // �v���T�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
    
            // �u23-�v���R�v�̏ꍇ
            case 23:
                // ���ƑΏێ҂́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // �v�x���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // �v�x���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // �v�x���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // �v���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // �v���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // �v���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                // �v���T�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
    
            // �u24-�v���S�v�̏ꍇ
            case 24:
                // ���ƑΏێ҂́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // �v�x���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // �v�x���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // �v�x���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // �v���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // �v���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // �v���R�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // �v���T�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo5");
                break;
    
            // �u25-�v���T�v�̏ꍇ
            case 25:
                // ���ƑΏێ҂́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // �v�x���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // �v�x���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // �v�x���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
                // �v���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo1");
                // �v���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo2");
                // �v���R�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo3");
                // �v���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youkaigo4");
                break;
    
            // ��L�ȊO�̏ꍇ
            default:
                // ���ƑΏێ҂́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
                // �v�x���P�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
                // �v�x���Q�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
                // �v�x���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "youshien");
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
            }
        } else {
            // ���ƑΏێ҂́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jigyotaisho");
            // �v�x���P�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "youshien1");
            // �v�x���Q�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "youshien2");
            // �v�x���́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "youshien");
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
        }

        // �L���F����ԊJ�n��
//        if (!ACTextUtilities
//                .isNullText(VRBindPathParser.get("201017", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201017"))) {
            Date start = ACCastUtilities.toDate(VRBindPathParser.get("201017",
                    baseMap));
            // �L���F����ԊJ�n���̘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hihokensya.h7.w3",
                    eraFormat.format(start));
            // �L���F����ԊJ�n���̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "yukoyear", eraYearFormat
                    .format(start));
            // �L���F����ԊJ�n���̌�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "yukomonth", monthFormat
                    .format(start));
            // �L���F����ԊJ�n���̓�(DD�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "yukoday", dayFormat
                    .format(start));

        }

        // �L���F����ԏI����
//        if (!ACTextUtilities
//                .isNullText(VRBindPathParser.get("201018", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201018"))) {
            Date end = ACCastUtilities.toDate(VRBindPathParser.get("201018",
                    baseMap));
            // �L���F����ԏI�����̘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "hihokensya.h8.w3",
                    eraFormat.format(end));
            // �L���F����ԏI�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "yukoendyear",
                    eraYearFormat.format(end));
            // �L���F����ԏI�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "yukoendmonth", monthFormat
                    .format(end));
            // �L���F����ԏI�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "yukoendday", dayFormat
                    .format(end));

        }
        // ���Ə��ԍ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, baseMap, "201004",
                "jigyousyono");
        // ���Ə����̂�ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_NAME",
                "providerName");
        // ���Ə��X�֔ԍ��̑O���R����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_ZIP_FIRST",
                "jigyousyozip1");
        // ���Ə��X�֔ԍ��̌㔼�S����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, provider,
                "PROVIDER_ZIP_SECOND", "jigyousyozip2");
        // ���Ə��̏��ݒn��ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, provider, "PROVIDER_ADDRESS",
                "providerAddress");
        // ���Ə��̓d�b�ԍ���ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "jigyousyotel", QkanCommon
                .toTel(ACCastUtilities.toString(VRBindPathParser.get(
                        "PROVIDER_TEL_FIRST", provider)), ACCastUtilities
                        .toString(VRBindPathParser.get("PROVIDER_TEL_SECOND",
                                provider)), ACCastUtilities
                        .toString(VRBindPathParser.get("PROVIDER_TEL_THIRD",
                                provider))));

    }

    protected void setKyotakuData() throws Exception {
        // �ݑ�T�[�r�X�v��҂��擾����B 201019�̏����擾();
        switch (ACCastUtilities.toInt(VRBindPathParser.get("201019", baseMap))) {
        // ������x�����Ə��쐬
        case 1:
            // �ݑ�T�[�r�X�v��҂��ݑ���x�����Ǝ҂̏ꍇ
            // ��ی��Ҏ��ȍ쐬�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jiko");
            // ���\�h�x�����Ǝ҂́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "kaigoshienjigyousya");
            
            // �ݑ�T�[�r�X�v�揑�쐬�̎��Ə��ԍ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, baseMap, "201020",
                    "kyotakujigyosyono");
            // �ݑ�T�[�r�X�v��쐬�̎��Ə����̂�ݒ肷��B
            // edit sta 2006.05.14 shin.fujihara
//            ACChotarouXMLUtilities.setValue(writer, provider_make,
//                    "PROVIDER_NAME", "kyotakuProviderName");
            ACChotarouXMLUtilities.setValue(writer, baseMap,
                    "201057", "kyotakuProviderName");
            // edit end 2006.05.14 shin.fujihara
            break;
        // ���ȍ쐬
        case 2:
            // �ݑ�T�[�r�X�v��҂���ی��Ҏ��ȍ쐬�̏ꍇ
            // �ݑ���x�����Ǝ҂́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shienjigyousya");
            // ���\�h�x�����Ǝ҂́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "kaigoshienjigyousya");
            break;
            
        case 3:
            // �ݑ�T�[�r�X�v��҂����\�h�x�����Ǝ҂̏ꍇ
            // �ݑ���x�����Ǝ҂́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shienjigyousya");
            // ��ی��Ҏ��ȍ쐬�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jiko");
            
            // �ݑ�T�[�r�X�v�揑�쐬�̎��Ə��ԍ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, baseMap, "201020",
                    "kyotakujigyosyono");
            // �ݑ�T�[�r�X�v��쐬�̎��Ə����̂�ݒ肷��B
            // edit sta 2006.05.14 shin.fujihara
//            ACChotarouXMLUtilities.setValue(writer, provider_make,
//                    "PROVIDER_NAME", "kyotakuProviderName");
            ACChotarouXMLUtilities.setValue(writer, baseMap,
                    "201057", "kyotakuProviderName");
            // edit end 2006.05.14 shin.fujihara
            
            break;
        default:
            //��ی��Ҏ��ȍ쐬�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "jiko");
            //�ݑ���x�����Ǝ҂́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shienjigyousya");
            // ���\�h�x�����Ǝ҂́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "kaigoshienjigyousya");
            break;
        }
    }

    /**
     * �J�n�N�������̐ݒ���s���܂��B
     * @throws Exception
     */
    protected void setKaishiDate() throws Exception {
        // �J�n�N�����̐ݒ�
//        if (!ACTextUtilities
//                .isNullText(VRBindPathParser.get("201021", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201021"))) {
            Date start = ACCastUtilities.toDate(VRBindPathParser.get("201021",
                    baseMap));
            // �J�n�N�����̘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kaishi.h1.w2", eraFormat
                    .format(start));
            // �J�n�N�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "stayear", eraYearFormat
                    .format(start));
            // �J�n�N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "stamonth", monthFormat
                    .format(start));
            // �J�n�N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "staday", dayFormat
                    .format(start));

        }

        // ���~�N�����̐ݒ�
//        if (!ACTextUtilities
//                .isNullText(VRBindPathParser.get("201022", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201022"))) {
            Date end = ACCastUtilities.toDate(VRBindPathParser.get("201022",
                    baseMap));
            // ���~�N�����̘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kaishi.h1.w10", eraFormat
                    .format(end));
            // ���~�N�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "endyear", eraYearFormat
                    .format(end));
            // ���~�N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "endmonth", monthFormat
                    .format(end));
            // ���~�N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "endday", dayFormat
                    .format(end));
        }

        // ���~���R�̐ݒ�
        if (!ACTextUtilities
                .isNullText(VRBindPathParser.get("201023", baseMap))) {
            // ���~���R���擾����B(201023���擾)
            switch (ACCastUtilities.toInt(VRBindPathParser.get("201023",
                    baseMap))) {
            // ���~���R���u��Y���v�̏ꍇ
            case 1:
                //��Ë@�֓��@�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //���̑��́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //���V�l�����{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //���V�l�ی��{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //���×{�^��Ë@�֓���
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            // ���~���R���u���ی��{�݁v�̏ꍇ
            // ���V�l���ł͔p�~
            case 2:
                // ��Y���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //��Ë@�֓��@�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //���̑��́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //���V�l�����{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //���V�l�ی��{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //���×{�^��Ë@�֓���
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            // ���~���R���u��Ë@�֓��@�v�̏ꍇ
            case 3:
                // ��Y���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //���̑��́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //���V�l�����{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //���V�l�ی��{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //���×{�^��Ë@�֓���
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            // ���~���R���u���S�v�̏ꍇ
            case 4:
                // ��Y���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //��Ë@�֓��@�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //���̑��́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //���V�l�����{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //���V�l�ی��{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //���×{�^��Ë@�֓���
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            // ���~���R���u���̑��v�̏ꍇ
            case 5:
                // ��Y���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //��Ë@�֓��@�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //���V�l�����{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //���V�l�ی��{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //���×{�^��Ë@�֓���
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;
                
            // ���~���R���u���V�l�����{�ݓ����v�̏ꍇ
            case 6:
                // ��Y���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //��Ë@�֓��@�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //���̑��́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //���V�l�ی��{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //���×{�^��Ë@�֓���
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;
                
            // ���~���R���u���V�l�ی��{�ݓ����v�̏ꍇ
            case 7:
                // ��Y���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //��Ë@�֓��@�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //���̑��́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //���V�l�����{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //���×{�^��Ë@�֓���
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            // ���~���R���u���V�l�ی��{�ݓ����v�̏ꍇ
            case 8:
                // ��Y���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //��Ë@�֓��@�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //���̑��́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //���V�l�����{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //���V�l�ی��{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                break;
                
            // ��L�ȊO
            default:
                // ��Y���́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "higaito");
                //��Ë@�֓��@�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
                //���S�́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "shibou");
                //���̑��́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "etc");
                //���V�l�����{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
                //���V�l�ی��{�ݓ����́����\���ɂ���B
                ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
                //���×{�^��Ë@�֓���
                ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
                break;

            }
        } else {
            // ��Y���́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "higaito");
            //��Ë@�֓��@�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "iryoukikan");
            //���S�́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "shibou");
            //���̑��́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "etc");
            //���V�l�����{�ݓ����́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "kaigofukushi");
            //���V�l�ی��{�ݓ����́����\���ɂ���B
            ACChotarouXMLUtilities.setInvisible(writer, "kaigohoken");
            //���×{�^��Ë@�֓���
            ACChotarouXMLUtilities.setInvisible(writer, "kaigoryoyo");
        }
    }
    
    /**
     * �����N�������̐ݒ���s���܂��B
     * (�l��������\�p)
     * @throws Exception
     */
    protected void setNyusyoDate() throws Exception {
        //���@�i�����j���̐ݒ�
//        if (!ACTextUtilities.isNullText(VRBindPathParser.get("201024", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201024"))) {
            Date start = ACCastUtilities.toDate(VRBindPathParser.get("201024",baseMap));
            // ���@�i�����j�����̘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "nyusyodate.h1.w2", eraFormat.format(start));
            // ���@�i�����j�N�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "nyusyoyear", eraYearFormat.format(start));
            // ���@�i�����j�N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "nyusyomonth", monthFormat.format(start));
            // ���@�i�����j�N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "nyusyoday", dayFormat.format(start));

        }

        // �ޏ��N�����̐ݒ�
//        if (!ACTextUtilities
//                .isNullText(VRBindPathParser.get("201025", baseMap))) {
        if (QP001Util.isDate(baseMap.get("201025"))) {
            Date end = ACCastUtilities.toDate(VRBindPathParser.get("201025",baseMap));
            // �ޏ��N�����̘a���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "taisyodate.h1.w2", eraFormat.format(end));
            // �ޏ��N�����̘a��N(YY�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "taisyoyear", eraYearFormat.format(end));
            // �ޏ��N�����̌�(MM�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "taisyomonth", monthFormat.format(end));
            // �ޏ��N�����̓�(DD�t�H�[�}�b�g)��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "taisyoday", dayFormat.format(end));
        }
        

        // �Z�������̎�������ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "tankijitsu", pad(VRBindPathParser.get("201026", baseMap), 2));
        // �O���̓�����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, "gaihaku", pad(VRBindPathParser.get("201027", baseMap), 2));
        // �叝�a����ݒ肷��B
        ACChotarouXMLUtilities.setValue(writer, baseMap, "201061","syusyoubyou.h1.w2");
        
        //�މ@��̏�
        switch(ACCastUtilities.toInt(baseMap.get("201028"),0)){
            //1-����
            case 1:
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //2-���{��(����18�N4���ȍ~�p�~)-default��
            //3-��Ë@�֓��@
            case 3:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //4-���S
            case 4:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //5-���̑�
            case 5:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //6-���V�l�����{�ݓ���
            case 6:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //7-���V�l�ی��{�ݓ���
            case 7:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
            //8-���×{�^��Î{�ݓ��@
            case 8:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                break;
            default:
                ACChotarouXMLUtilities.setInvisible(writer,"higaito");
                ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan");
                ACChotarouXMLUtilities.setInvisible(writer,"shibou");
                ACChotarouXMLUtilities.setInvisible(writer,"etc");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken");
                ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo");
                break;
        }
        
        
    }
    
    /**
     * ���׏���ݒ肷��B
     * @param detailList
     * @param loopCount
     * @param kohiCount
     * @throws Exception
     */
    protected void setDetailList(VRList detailList,int loopCount,int kohiCount) throws Exception {
        // ���׌��������[�v����B
        for (int j = 1; j < loopCount; j++) {
            if (detailList.getDataSize() == 0)
                break;
            VRMap detail = (VRMap) detailList.get(0);
            // �T�[�r�X���e��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, detail, "301019",
                    "meisai.h" + j + ".w2");
            // �T�[�r�X�R�[�h��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "servicecode" + j,
                    ACCastUtilities.toString(VRBindPathParser.get(
                            "301007", detail))
                            + ACCastUtilities.toString(VRBindPathParser
                                    .get("301008", detail)));

            //�P�ʐ���\������T�[�r�X�łȂ���ΒP�ʐ��P����\������B
            // [�������ƓƎ��Ή�][Shinobu Hitaka] 2016/09/30 mod �Z��P�ʃp�����[�^�ǉ�
            // if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("301007")),String.valueOf(detail.get("301008")))){
            if(!QP001SpecialCase.isUnitNotShowService(String.valueOf(detail.get("301007")),String.valueOf(detail.get("301008")),
            		ACCastUtilities.toInt(detail.get("301027"), 0))){
                // �P�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "tani" + j, pad(
                        VRBindPathParser.get("301009", detail), 4));
            }

            // �����E�񐔂�ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "times" + j, pad(
                    VRBindPathParser.get("301010", detail), 2));
            
            // �T�[�r�X�P�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "servicetime" + j,
                    pad(VRBindPathParser.get("301014", detail), 5));

            
            switch (kohiCount) {
            // ����1
            case 0:
                // ����񐔂�ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301011", detail), 2));
                
                // ����ΏےP�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301015", detail), 5));

                break;
            // ����2
            case 1:
                // ����񐔂�ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301012", detail), 2));
                
                // ����ΏےP�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301016", detail), 5));

                break;
            // ����3
            case 2:
                // ����񐔂�ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer,
                        "kohitimes" + j, pad(VRBindPathParser.get(
                                "301013", detail), 2));

                // ����ΏےP�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohitani" + j,
                        pad(VRBindPathParser.get("301017", detail), 5));

                break;
            }

            // �E�v��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, detail, "301018",
                    "meisai.h" + j + ".tekiyo");
            detailList.remove(0);
        }
    }

// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] add - begin
    public VRMap getServiceName() {
        return serviceName;
    }
// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] add - end
    
    protected void setTypeList(VRList typeList,int loopCount,int kohiCount) throws Exception {
        for (int j = 1; j < loopCount; j++) {
            if (typeList.getDataSize() == 0)
                break;
            VRMap type = (VRMap) typeList.get(0);
            // �T�[�r�X��ރR�[�h��ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, type, "701007",
                    "servicekindcode" + j);
            
//            // �T�[�r�X���̂�ݒ肷��B
//            ACChotarouXMLUtilities.setValue(writer, type, "701039",
//                    "seikyumeisai.h1.w" + ((j * 3) + 1));
            
            
            VRMap service = (VRMap)serviceName.get(type.get("701007"));
            // �T�[�r�X���̂�ݒ肷��B
//            ACChotarouXMLUtilities.setValue(writer, service, "SERVICE_NAME",
//                    "seikyumeisai.h1.w" + ((j * 3) + 1));
//            ACChotarouXMLUtilities.setValue(writer, service, "SERVICE_KIND_NAME",
//                    "seikyumeisai.h1.w" + ((j * 3) + 1));
            //�\�h�Ή�
            ACChotarouXMLUtilities.setValue(writer, service, "SERVICE_KIND_NAME",
                    "seviceName" + j);
            
            // �T�[�r�X��������ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "servicerealdate"
                    + j, pad(VRBindPathParser.get("701008", type), 2));
            // �v��P�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "plantani" + j,
                    pad(VRBindPathParser.get("701009", type), 6));
            // ���x�z�Ǘ��ΏےP�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "limitin" + j, pad(
                    VRBindPathParser.get("701010", type), 6));
            // ���x�z�Ǘ��ΏۊO�P�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "limitout" + j,
                    pad(VRBindPathParser.get("701011", type), 6));
            // ���t�P�ʐ���ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "kyufutani" + j,
                    pad(VRBindPathParser.get("701014", type), 6));

            // �P�ʐ��P����ݒ肷��B
            ACChotarouXMLUtilities.setValue(writer, "tanisutani" + j,
                    getTanka(VRBindPathParser.get("701015", type)));

            if(kohiCount == 0){
                // �ی������z��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "hokenseikyu" + j,
                        pad(VRBindPathParser.get("701016", type), 6));
                // ���p�ҕ��S�z��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "riyosyafutan" + j,
                        pad(VRBindPathParser.get("701017", type), 6));
            }

            switch (kohiCount) {
            // ����1
            case 0:
                // ����P�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohibuntani"
                        + j, pad(VRBindPathParser.get("701018", type),
                        6));
                // ������z��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohiseikyu"
                        + j, pad(VRBindPathParser.get("701019", type),
                        6));
                // ����{�l���S�z��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohihonnin"
                        + j, pad(VRBindPathParser.get("701020", type),
                        6));
                break;
            // ����2
            case 1:
                // ����P�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohibuntani"
                        + j, pad(VRBindPathParser.get("701021", type),
                        6));
                // ������z��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohiseikyu"
                        + j, pad(VRBindPathParser.get("701022", type),
                        6));
                // ����{�l���S�z��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohihonnin"
                        + j, pad(VRBindPathParser.get("701023", type),
                        6));
                break;
            // ����3
            case 2:
                // ����P�ʐ���ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohibuntani"
                        + j, pad(VRBindPathParser.get("701024", type),
                        6));
                // ������z��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohiseikyu"
                        + j, pad(VRBindPathParser.get("701025", type),
                        6));
                // ����{�l���S�z��ݒ肷��B
                ACChotarouXMLUtilities.setValue(writer, "kohihonnin"
                        + j, pad(VRBindPathParser.get("701026", type),
                        6));
                break;
            }

            typeList.remove(0);
        }
    }
    
    //[ID:0000447][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
    /**
     * �����i���@�j�O�̏�Ԃ𒠕[�ɐݒ肵�܂��B
     * @param typeList
     * @param loopCount
     * @param kohiCount
     * @throws Exception
     */
    protected void setBeforeHospitalization() throws Exception {
        //�����i���@�j�O�̏��[���~���R�R�[�h]
        switch(ACCastUtilities.toInt(baseMap.get("201023"),0)){
	        // 1:����
	        case 1:
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 2:��Ë@��
	        case 2:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 3:���V�l�����{��
	        case 3:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 4:���V�l�ی��{��
	        case 4:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 5:���×{�^��Î{��
	        case 5:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 6:�F�m�ܑΉ��^���������
	        case 6:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 7:����{�ݓ����Ґ������
	        case 7:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;
	        	
	        // 8:���̑�
	        case 8:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
	        	ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
	        	break;
	        	
	        default:
	        	ACChotarouXMLUtilities.setInvisible(writer,"higaito2");
		        ACChotarouXMLUtilities.setInvisible(writer,"iryoukikan2");
		        ACChotarouXMLUtilities.setInvisible(writer,"kaigofukushi2");
		        ACChotarouXMLUtilities.setInvisible(writer,"kaigohoken2");
		        ACChotarouXMLUtilities.setInvisible(writer,"kaigoryoyo2");
		        ACChotarouXMLUtilities.setInvisible(writer,"ninchsyou2");
		        ACChotarouXMLUtilities.setInvisible(writer,"tokuteisisetu2");
		        ACChotarouXMLUtilities.setInvisible(writer,"etc2");
	        	break;

        }
    }
    //[ID:0000447][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�
    
    /**
     * ���t��ח���\�����邩�̃t���O��ԋp���܂��B<br>
     * ����S�Ҕԍ����ݒ肳��Ă���A
     * @param kohiCount
     * @return
     * @throws Exception
     */
    protected boolean isDetailListShow(int kohiCount) throws Exception {
    	
        switch(kohiCount){
	        //����P�����
	        case 0:
	            // ����S�Ҕԍ����m�F
	        	//����S�Ҕԍ������݂�
	        	if(!ACTextUtilities.isNullText(baseMap.get("201007"))){
	        		if(ACCastUtilities.toString(baseMap.get("201007")).startsWith("10")){
	        			return true;
	        		}
	        		
	        		//����v��0�̏ꍇ�͕\���𒆒f����B
	        		if(getKohiTotal1() == 0){
	        			return false;
	        		}
	        	}
	            break;
	        //����Q�����
	        case 1:
	        	if(!ACTextUtilities.isNullText(baseMap.get("201009"))){
	        		if(ACCastUtilities.toString(baseMap.get("201009")).startsWith("10")){
	        			return true;
	        		}
	        		
	        		//����v��0�̏ꍇ�͕\���𒆒f����B
	        		if(getKohiTotal2() == 0){
	        			return false;
	        		}
	        	}
	            break;
	        //����R�����
	        case 2:
	        	if(!ACTextUtilities.isNullText(baseMap.get("201011"))){
	        		if(ACCastUtilities.toString(baseMap.get("201011")).startsWith("10")){
	        			return true;
	        		}
	        		
	        		//����v��0�̏ꍇ�͕\���𒆒f����B
	        		if(getKohiTotal3() == 0){
	        			return false;
	        		}
	        	}
	            break;
        }
    	return true;
    }
    
    /**
     * ����f�Ô�ח���\�����邩�̃t���O��ԋp���܂��B
     * @param kohiCount
     * @param diagnosisLastMap
     * @return
     * @throws Exception
     */
    protected boolean isDiagnosisListShow(int kohiCount,VRMap diagnosisLastMap) throws Exception {
    	
    	if(diagnosisLastMap == null){
    		return true;
    	}
    	switch(kohiCount){
	        //����P�����
	        case 0:
	            // ����S�Ҕԍ����m�F
	        	//����S�Ҕԍ������݂�
	        	if(!ACTextUtilities.isNullText(baseMap.get("201007"))){
	        		if(ACCastUtilities.toString(baseMap.get("201007")).startsWith("10")){
	        			return true;
	        		}
	        		
	        		//����v��0�̏ꍇ�͕\���𒆒f����B
	        		if(ACCastUtilities.toInt(diagnosisLastMap.get("501016"),0) == 0){
	        			return false;
	        		}
	        	}
	            break;
	        //����Q�����
	        case 1:
	        	if(!ACTextUtilities.isNullText(baseMap.get("201009"))){
	        		if(ACCastUtilities.toString(baseMap.get("201009")).startsWith("10")){
	        			return true;
	        		}
	        		
	        		//����v��0�̏ꍇ�͕\���𒆒f����B
	        		if(ACCastUtilities.toInt(diagnosisLastMap.get("501019"),0) == 0){
	        			return false;
	        		}
	        	}
	            break;
	        //����R�����
	        case 2:
	        	if(!ACTextUtilities.isNullText(baseMap.get("201011"))){
	        		if(ACCastUtilities.toString(baseMap.get("201011")).startsWith("10")){
	        			return true;
	        		}
	        		
	        		//����v��0�̏ꍇ�͕\���𒆒f����B
	        		if(ACCastUtilities.toInt(diagnosisLastMap.get("501022"),0) == 0){
	        			return false;
	        		}
	        	}
	            break;
        }
    	return true;
    }
    
    /**
     * ���R�[�h�����ԍ���99�̃n�b�V���}�b�v��ԋp���܂��B
     * @param list �����Ώۂ̃��X�g
     * @param key ���R�[�h�����ԍ��̃L�[
     * @return �擾�����n�b�V���}�b�v
     * @throws Exception
     */
    protected VRMap getLastRecord(VRList list, String key) throws Exception {
        return getNominationRecord(list,key,99);
    }
    
    protected VRMap getNominationRecord(VRList list, String key,int recordNo) throws Exception {
        if(list == null) return null;
        
        if(list.size() == 1){
            return (VRMap)list.get(0);
        }
        
        for(int i =0; i < list.size(); i++){
            VRMap map = (VRMap)list.get(i);
            if((ACCastUtilities.toInt(map.get(key))) == recordNo){
                return map;
            }
        }
        return null;
    }

    /**
     * ��{��񃌃R�[�h���擾���܂��B
     * @return
     */
    protected VRMap getBaseMap() {
        return baseMap;
    }

    /**
     * ���׏�񃌃R�[�h���X�g���擾���܂��B
     * @return
     */
    protected VRList getDetailList() {
        return getStyleList(detailList);
    }
// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] add - begin �Z���n����Ή�
    /**
     * ���׏��i�Z���n����j���R�[�h���X�g���擾���܂��B
     * @return
     */
    protected VRList getDetailJushotiTokureiList() {
        return getStyleList(detailJushotiTokureiList);
    }
// 2015/1/26 [H27.4�����Ή�][Yoichiro Kamei] add - end
    /**
     * ���׏�񃌃R�[�h���擾���܂��B
     * @return
     */
    protected VRMap getDetailMap() {
        return getStyleMap(detailList);
    }

    /**
     * �ً}���{�ݗ×{��񃌃R�[�h���X�g���擾���܂��B
     * @return
     */
    protected VRList getEmergencyList() {
        return getStyleList(emergencyList);
    }

    /**
     * �ً}���{�ݗ×{��񃌃R�[�h���擾���܂��B
     * @return
     */
    protected VRMap getemErgencyMap() {
        return getStyleMap(emergencyList);
    }
    
    
    /**
     * �ً}���{�ݗ×{�E���{�ݗ×{���񃌃R�[�h���X�g���擾���܂��B
     * @return
     */
    protected VRList getEmergencyOwnFacilityList() {
        return getStyleList(emergencyOwnFacilityList);
    }

    /**
     * �ً}���{�ݗ×{�E���{�ݗ×{���񃌃R�[�h���擾���܂��B
     * @return
     */
    protected VRMap getemErgencyOwnFacilityMap() {
        return getStyleMap(emergencyOwnFacilityList);
    }

    /**
     * ����f�Ô��񃌃R�[�h���X�g���擾���܂��B
     * @return
     */
    protected VRList getDiagnosisList() {
        return getStyleList(diagnosisList);
    }

    /**
     * ����f�Ô��񃌃R�[�h���擾���܂��B
     * @return
     */
    protected VRMap getDiagnosisMap() {
        return getStyleMap(diagnosisList);
    }

    /**
     * �W�v��񃌃R�[�h���X�g���擾���܂��B
     * @return
     */
    protected VRList getTypeList() {
        return getStyleList(typeList);
    }

    /**
     * �W�v��񃌃R�[�h���擾���܂��B
     * @return
     */
    protected VRMap getTypeMap() {
        return getStyleMap(typeList);
    }

    /**
     * ��������҉��T�[�r�X��p��񃌃R�[�h���X�g���擾���܂��B
     * @return
     */
    protected VRList getNursingList() {
        return getStyleList(nursingList);
    }

    /**
     * ��������҉��T�[�r�X��p��񃌃R�[�h���擾���܂��B
     * @return
     */
    protected VRMap getNursingMap() {
        return getStyleMap(nursingList);
    }

    /**
     * �Љ���@�l�y���z��񃌃R�[�h���X�g���擾���܂��B
     * @return
     */
    protected VRList getReductionList() {
        return getStyleList(reductionList);
    }

    /**
     * �Љ���@�l�y���z��񃌃R�[�h���擾���܂��B
     * @return
     */
    protected VRMap getReductionMap() {
        return getStyleMap(reductionList);
    }
    
    /**
     * �T�[�r�X�P�ʐ����v���擾���܂��B
     * @return
     */
    protected int getServiceUnitTotal() {
        return serviceUnitTotal;
    }
    
    /**
     * ����P�P�ʐ����v���擾���܂��B
     * @return
     */
    protected int getKohiTotal1() {
        return kohiTotal1;
    }
    
    /**
     * ����Q�P�ʐ����v���擾���܂��B
     * @return
     */
    protected int getKohiTotal2() {
        return kohiTotal2;
    }
    
    /**
     * ����R�P�ʐ����v���擾���܂��B
     * @return
     */
    protected int getKohiTotal3() {
        return kohiTotal3;
    }

    private VRList getStyleList(VRList value) {
        if (value == null)
            return new VRArrayList();

        return value;
    }

    private VRMap getStyleMap(VRList value) {
        if ((value == null) || (value.getDataSize() == 0))
            return null;

        return (VRMap) value.get(0);
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
        } else if(temp.length == 2){
            if((temp[1] == null) || (temp[1].length() == 0)){
                temp[1] = "00";
            } else if(temp[1].length() == 1){
                temp[1] += "0";
            }
        }

        return temp[0] + temp[1];

    }

    /**
     * ������̐擪�ɋ󔒕�����}�����A�����Ŏw�肳�ꂽ�������ɂ��ĕԋp���܂��B
     * ������0�̏ꍇ�͋󔒂ɒu������܂��B
     * @param value �Ώە�����
     * @param pad ���߂镶����
     * @return �󔒂�}������������
     * @throws Exception
     */
    protected String pad(Object value, int pad) throws Exception {
        if (ACTextUtilities.isNullText(value))
            return "";
        //String temp = ACCastUtilities.toString(value);
        String temp = ACTextUtilities.trim(ACCastUtilities.toString(value));
        if ("0".equals(temp))
            return "";
        StringBuilder padString = new StringBuilder();
        for (int i = 0; i < pad - temp.length(); i++) {
        	//�S�p�ɕύX
            //padString.append(" ");
        	padString.append("�@");
        }
        return padString.toString() + temp;
    }
    
    //[ID:0000449][Shin Fujihara] 2009/02 add begin ����21�N4���@�����Ή�
    /**
     * ������̐擪�ɋ󔒕�����}�����A�����Ŏw�肳�ꂽ�������ɂ��ĕԋp���܂��B
     * ������0�̏ꍇ�A�ݒ�ύX�����e�i���X��
     * �u��������҂̗��p�ҕ��S�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���v
     * �Ƀ`�F�b�N�����Ă���΂�����0�A�`�F�b�N���t���Ă��Ȃ��ꍇ�͋󔒂�ԋp���܂��B
     * @param value �Ώە�����
     * @param pad ���߂镶����
     * @return �󔒂�}������������
     * @throws Exception
     */
    protected String pad0(Object value, int pad) throws Exception {
    	if (this.printNursingZero){
            if ("0".equals(ACTextUtilities.trim(ACCastUtilities.toString(value)))) {
            	StringBuilder padString = new StringBuilder();
            	for (int i = 0; i < pad - 1; i++){
            		padString.append("�@");
            	}
            	padString.append("0");
                return padString.toString();
            }
    	}
        return pad(value, pad);
    }
    //[ID:0000449][Shin Fujihara] 2009/02 add end ����21�N4���@�����Ή�

    //[ID:0000651][Shin Fujihara] 2011/07/06 add begin ���S���x�z0�~�\���Ή�
    //�ǂ��C�����@�ł͂Ȃ����Ƃ����m�ŏ�Lpad0���\�b�h���R�s�y
    //�������0�~�ł��o�͂���p�^�[�����ǉ����ꂽ�Ƃ��́A���W�b�N�𓝍�����
    /**
     * ������̐擪�ɋ󔒕�����}�����A�����Ŏw�肳�ꂽ�������ɂ��ĕԋp���܂��B
     * ������0�̏ꍇ�A�ݒ�ύX�����e�i���X��
     * �u��������҂̗��p�ҕ��S�z��0�~�̏ꍇ�ɖ��׏��Ɉ󎚂���v
     * �Ƀ`�F�b�N�����Ă���΂�����0�A�`�F�b�N���t���Ă��Ȃ��ꍇ�͋󔒂�ԋp���܂��B
     * @param value �Ώە�����
     * @param pad ���߂镶����
     * @return �󔒂�}������������
     * @throws Exception
     */
    protected String pad0NursingLimit(Object value, int pad) throws Exception {
    	if (this.printNursingLimitZero){
            if ("0".equals(ACTextUtilities.trim(ACCastUtilities.toString(value)))) {
            	StringBuilder padString = new StringBuilder();
            	for (int i = 0; i < pad - 1; i++){
            		padString.append("�@");
            	}
            	padString.append("0");
                return padString.toString();
            }
    	}
        return pad(value, pad);
    }
    //[ID:0000651][Shin Fujihara] 2011/07/06 add end ���S���x�z0�~�\���Ή�

    
    
    /**
     * ������܂��B
     * @param writer ����Ǘ��N���X
     * @param printParam ����p�����^
     * @throws Exception ������O
     */
    public boolean doPrintImpl(VRMap printParam) throws Exception{
        return false;
    }
    
    /**
     * ���[ID��ݒ肷��B
     * @throws Exception
     */
    public void addFormat() throws Exception{
        
    }
    
    /**
     * �ݒ肵�����[ID���擾����B
     * @return
     * @throws Exception
     */
    public String getFormatId() throws Exception{
        return "";
    }

    // 2008/05/27 [Masahiko_Higuchi] edit - start 2007�N�x�Ή� �O���A�N�Z�X����
    public class RecordComparator implements java.util.Comparator {
    // 2008/05/27 [Masahiko_Higuchi] edit - end
        public int compare(Object object1, Object object2) {
            String[] values = new String[]{"",""};
            try{
            	VRMap[] maps = new VRMap[2];
            	maps[0] = (VRMap)object1;
            	maps[1] = (VRMap)object2;
            	
            	for(int i = 0; i < maps.length; i++){
                    int categoryNo = ACCastUtilities.toInt(VRBindPathParser.get("CATEGORY_NO", maps[i]));

                    switch (categoryNo) {
                    // ��{��񃌃R�[�h
                    case 2:
                        break;
                    // ���׏�񃌃R�[�h
                    case 3:
                        //�T�[�r�X�R�[�h�Ń\�[�g
                    	values[i] = String.valueOf(maps[i].get("301007")) + "-"
                                + String.valueOf(maps[i].get("301008")) + "-"
                                + String.valueOf(maps[i].get("301009")) + "-"
                                + String.valueOf(maps[i].get("301014")) + "-"
                                + String.valueOf(maps[i].get("301018"));
                        break;
                    // �ً}���{�ݗ×{��񃌃R�[�h
                    case 4:
                        //�ً}���{�ݗ×{��񃌃R�[�h�����ԍ��Ń\�[�g
                    	values[i] = String.valueOf(maps[i].get("401007"));
                        break;
                    // ����f�Ô��񃌃R�[�h
                    case 5:
                        //����f�Ô��񃌃R�[�h���ʔԍ�
                    	values[i] = String.valueOf(maps[i].get("501009"));
                        break;
                    // �W�v��񃌃R�[�h
                    case 7:
                        //�T�[�r�X��ރR�[�h
                    	values[i] = String.valueOf(maps[i].get("701007"));
                        break;
                    // ��������҉��T�[�r�X��p��񃌃R�[�h
                    case 8:
                    	//���R�[�h�����ԍ�
                    	values[i] = String.valueOf(maps[i].get("801008")) + String.valueOf(maps[i].get("801009") + String.valueOf(maps[i].get("801010")));
                        break;
                    // �Е����ƃ��R�[�h
                    case 9:
                    	values[i] = String.valueOf(maps[i].get("901008"));
                        break;
                    // �ً}���{�ݗ×{�E���{�ݗ×{���񃌃R�[�h
                    case 17:
                        //�ً}���{�ݗ×{��񃌃R�[�h�����ԍ��Ń\�[�g
                        values[i] = String.valueOf(maps[i].get("1701007"));
                        break;
// 2015/1/14 [Yoichiro Kamei] add - begin �Z���n����Ή�
                    // ���׏��i�Z���n����j���R�[�h
                    case 18:
                        //�T�[�r�X�R�[�h�Ń\�[�g
                    	values[i] = String.valueOf(maps[i].get("1801007")) + "-"
                                + String.valueOf(maps[i].get("1801008")) + "-"
                                + String.valueOf(maps[i].get("1801009")) + "-"
                                + String.valueOf(maps[i].get("1801014")) + "-"
                                + String.valueOf(maps[i].get("1801019"));
                        break;
// 2015/1/14 [Yoichiro Kamei] add - end
                    }
            	}
            } catch(Exception e){
                VRLogger.warning(e);
            }
            
            return values[0].compareTo(values[1]);
        }
    }
    
    //[H20.5 �@�����Ή�] fujihara add start
    public int getTerm() {
    	return this.term;
    }
    //[H20.5 �@�����Ή�] fujihara add end
    
    //�ϐ���`

    //getter/setter

}
