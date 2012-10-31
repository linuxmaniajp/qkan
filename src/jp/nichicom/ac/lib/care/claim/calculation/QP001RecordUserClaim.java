
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
 * �v���O���� ���p�Ҍ����������R�[�h (QP001RecordAbstract)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public class QP001RecordUserClaim extends QP001RecordAbstract {

    // ���p�ҕ��S�@�T�[�r�X��
    private String[] serviceNames = new String[10];
    // ���p�ҕ��S�@���p�ҕ��S�z
    private int[] serviceClaim = new int[10];    
    // ����{�l���S�@�����
    // 2008/01/21 [Masahiko Higuchi] edit - begin ���p�Ҍ���������_�ȈՔőΉ�
    private String[] kohiNames = new String[2];
    // 2008/01/21 [Masahiko Higuchi] edit - end
    // ����{�l���S�@�{�l���S�z
    // 2008/01/21 [Masahiko Higuchi] edit - begin ���p�Ҍ���������_�ȈՔőΉ�
    // �z��̃T�C�Y�ɖ�肪���邽�ߏC��
    private int[] kohiClaim = new int[2];
    // 2008/01/21 [Masahiko Higuchi] edit - end
    // ���Ə���
    private String _1601027 = "";
    // ���ݒn
    private String _1601028 = "";
    // �d�b�ԍ�
    private String _1601029 = "";
    // �Ǘ��Җ�
    private String _1601030 = "";
    // ������x�����Ə���
    private String _1601031 = "";
    // �̎��N����
    private String _1601032 = "";
    // �U������Z�@�֖�
    private String _1601033 = "";
    // �U������Z�@�֎x�X��
    private String _1601034 = "";
    // �U��������ԍ�
    private String _1601035 = "";
    // �U����������
    private String _1601036 = "";
    // �U���於�`�l
    private String _1601037 = "";
    // �����Ώی�
    private Date target = null;
    
    //[H20.5 �@�����Ή�] fujihara add start
    private RecuperationUnitCalc unitCalc = new RecuperationUnitCalc();
    //[H20.5 �@�����Ή�] fujihara add end
    
    // 2008/02/06 [Masahiko Higuchi] add - begin Ver 5.4.1 ���p�Ҍ����������Ή�
    private int[] serviceUnit = new int[10];
    private int[] serviceCount = new int[10];
    // 2008/02/06 [Masahiko Higuchi] add - end
    
    protected String getSerialId() {
        // TODO �����������ꂽ���\�b�h�E�X�^�u
        return null;
    }
    /**
     * ���p�ҕ��S(1���)�@�T�[�r�X�����擾����B
     * @return
     */
    private String get_1601001() {
        return serviceNames[0];
    }
    /**
     * ���p�ҕ��S(1���)�@���p�ҕ��S�z���擾����B
     * @return
     */
    private int get_1601002() {
        return serviceClaim[0];
    }
    /**
     * ���p�ҕ��S(2���)�@�T�[�r�X�����擾����B
     * @return
     */
    private String get_1601003() {
        return serviceNames[1];
    }
    /**
     * ���p�ҕ��S(2���)�@���p�ҕ��S�z���擾����B
     * @return
     */
    private int get_1601004() {
        return serviceClaim[1];
    }
    /**
     * ���p�ҕ��S(3���)�@�T�[�r�X�����擾����B
     * @return
     */
    private String get_1601005() {
        return serviceNames[2];
    }
    /**
     * ���p�ҕ��S(3���)�@���p�ҕ��S�z���擾����B
     * @return
     */
    private int get_1601006() {
        return serviceClaim[2];
    }
    /**
     * ���p�ҕ��S(4���)�@�T�[�r�X�����擾����B
     * @return
     */
    private String get_1601007() {
        return serviceNames[3];
    }
    /**
     * ���p�ҕ��S(4���)�@���p�ҕ��S�z���擾����B
     * @return
     */
    private int get_1601008() {
        return serviceClaim[3];
    }
    /**
     * ���p�ҕ��S(5���)�@�T�[�r�X�����擾����B
     * @return
     */
    private String get_1601009() {
        return serviceNames[4];
    }
    /**
     * ���p�ҕ��S(5���)�@���p�ҕ��S�z���擾����B
     * @return
     */
    private int get_1601010() {
        return serviceClaim[4];
    }
    /**
     * ���p�ҕ��S(6���)�@�T�[�r�X�����擾����B
     * @return
     */
    private String get_1601011() {
        return serviceNames[5];
    }
    /**
     * ���p�ҕ��S(6���)�@���p�ҕ��S�z���擾����B
     * @return
     */
    private int get_1601012() {
        return serviceClaim[5];
    }
    /**
     * ���p�ҕ��S(7���)�@�T�[�r�X�����擾����B
     * @return
     */
    private String get_1601013() {
        return serviceNames[6];
    }
    /**
     * ���p�ҕ��S(7���)�@���p�ҕ��S�z���擾����B
     * @return
     */
    private int get_1601014() {
        return serviceClaim[6];
    }
    /**
     * ���p�ҕ��S(8���)�@�T�[�r�X�����擾����B
     * @return
     */
    private String get_1601015() {
        return serviceNames[7];
    }
    /**
     * ���p�ҕ��S(8���)�@���p�ҕ��S�z���擾����B
     * @return
     */
    private int get_1601016() {
        return serviceClaim[7];
    }
    /**`
     * ���p�ҕ��S(9���)�@�T�[�r�X�����擾����B
     * @return
     */
    private String get_1601017() {
        return serviceNames[8];
    }
    /**
     * ���p�ҕ��S(9���)�@���p�ҕ��S�z���擾����B
     * @return
     */
    private int get_1601018() {
        return serviceClaim[8];
    }
    /**
     * ���p�ҕ��S(10���)�@�T�[�r�X�����擾����B
     * @return
     */
    private String get_1601019() {
        return serviceNames[9];
    }
    /**
     * ���p�ҕ��S(10���)�@���p�ҕ��S�z���擾����B
     * @return
     */
    private int get_1601020() {
        return serviceClaim[9];
    }
    /**
     * ����{�l���S(1���)�@����̂��擾����B
     * @return
     */
    private String get_1601021() {
        return kohiNames[0];
    }
    /**
     * ����{�l���S(1���)�@�{�l���S�z���擾����B
     * @return
     */
    private int get_1601022() {
        return kohiClaim[0];
    }
    /**
     * ����{�l���S(2���)�@����̂��擾����B
     * @return
     */
    private String get_1601023() {
        return kohiNames[1];
    }
    /**
     * ����{�l���S(2���)�@�{�l���S�z���擾����B
     * @return
     */
    private int get_1601024() {
        return kohiClaim[1];
    }
    
    // 2007/11/09 [Masahiko Higuchi] del - begin Ver 5.4.1 ���p�Ҍ����������Ή�
    /*
    /**
     * ����{�l���S(3���)�@����̂��擾����B
     * @return
     */
    /*
    private String get_1601025() {
        return kohiNames[2];
    }*/
    /*
    /**
     * ����{�l���S(3���)�@�{�l���S�z���擾����B
     * @return
     */
    /*
    private int get_1601026() {
        return kohiClaim[2];
    }
    */
    // 2007/11/09 [Masahiko Higuchi] del - end
    /**
     * ���Ə������擾����B
     * @return
     */
    private String get_1601027() {
        return _1601027;
    }
    /**
     * ���ݒn���擾����B
     * @return
     */
    private String get_1601028() {
        return _1601028;
    }
    /**
     * �d�b�ԍ����擾����B
     * @return
     */
    private String get_1601029() {
        return _1601029;
    }
    /**
     * �Ǘ��Җ����擾����B
     * @return
     */
    private String get_1601030() {
        return _1601030;
    }
    /**
     * ������x�����Ə������擾����B
     * @return
     */
    private String get_1601031() {
        return _1601031;
    }
    /**
     * �̎��N�������擾����B
     * @return
     */
    private String get_1601032() {
        return _1601032;
    }
    /**
     * �U������Z�@�֖����擾����B
     * @return
     */
    private String get_1601033() {
        return _1601033;
    }
    /**
     * �U������Z�@�֎x�X�����擾����B
     * @return
     */
    private String get_1601034() {
        return _1601034;
    }
    /**
     * �U��������ԍ����擾����B
     * @return
     */
    private String get_1601035() {
        return _1601035;
    }
    /**
     * �U���������ނ��擾����B
     * @return
     */
    private String get_1601036() {
        return _1601036;
    }
    /**
     * �U���於�`�l���擾����B
     * @return
     */
    private String get_1601037() {
        return _1601037;
    }
    /**
     * �����Ώی���ݒ肷��B
     * @param target
     */
    private void setTargetDate(Date target) {
        this.target = target;
    }
    
    /**
     * �����Ώی����擾����B
     * @return
     */
    private Date getTargetDate() {
        return target;
    }
    
    
    // 2007/11/09 [Masahiko Higuchi] add - begin Ver 5.4.1 ���p�Ҍ����������Ή�
    //
    /**
     * ���p�ҕ��S(1���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601038() {
        return serviceUnit[0];
    }
    /**
     * ���p�ҕ��S(1���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601039() {
        return serviceCount[0];
    }
    /**
     * ���p�ҕ��S(2���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601040() {
        return serviceUnit[1];
    }
    /**
     * ���p�ҕ��S(2���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601041() {
        return serviceCount[1];
    }
    /**
     * ���p�ҕ��S(3���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601042() {
        return serviceUnit[2];
    }
    /**
     * ���p�ҕ��S(3���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601043() {
        return serviceCount[2];
    }
    /**
     * ���p�ҕ��S(4���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601044() {
        return serviceUnit[3];
    }
    /**
     * ���p�ҕ��S(4���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601045() {
        return serviceCount[3];
    }
    /**
     * ���p�ҕ��S(5���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601046() {
        return serviceUnit[4];
    }
    /**
     * ���p�ҕ��S(5���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601047() {
        return serviceCount[4];
    }
    /**
     * ���p�ҕ��S(6���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601048() {
        return serviceUnit[5];
    }
    /**
     * ���p�ҕ��S(6���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601049() {
        return serviceCount[5];
    }
    /**
     * ���p�ҕ��S(7���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601050() {
        return serviceUnit[6];
    }
    /**
     * ���p�ҕ��S(7���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601051() {
        return serviceCount[6];
    }
    /**
     * ���p�ҕ��S(8���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601052() {
        return serviceUnit[7];
    }
    /**
     * ���p�ҕ��S(8���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601053() {
        return serviceCount[7];
    }
    /**
     * ���p�ҕ��S(9���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601054() {
        return serviceUnit[8];
    }
    /**
     * ���p�ҕ��S(9���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601055() {
        return serviceCount[8];
    }
    /**
     * ���p�ҕ��S(10���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601056() {
        return serviceUnit[9];
    }
    /**
     * ���p�ҕ��S(10���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601057() {
        return serviceCount[9];
    }
    // 2007/11/09 [Masahiko Higuchi] add - end
    
    public void parse(VRList claimList,QP001Manager manager) throws Exception {
        
        // �W�v��񃌃R�[�h�ޔ�p
        VRList typeList = new VRArrayList();
        // ��������҉��T�[�r�X��p��񃌃R�[�h
        VRList nursingList = new VRArrayList();
        // �Љ���@�l�y���z��񃌃R�[�h
        VRList reductionList = new VRArrayList();
        // ������
        VRMap kohiMap = new VRHashMap();
        
        //add start 2008.6.5 fujihara.shin
        //�T�[�r�X�R�[�h���ɖ��ׂ��o�͂���悤�A�\�[�g������ǉ�
        QP001P02_10Event sorter = new QP001P02_10Event();
        Collections.sort(claimList, sorter.new RecordComparator());
        //add end 2008.6.5 fujihara.shin
        
        for(int i = 0; i < claimList.size(); i++){
            VRMap claim = (VRMap)claimList.get(i);
            
            //�L�[�̑��݃`�F�b�N
            //if(claim.containsKey("CATEGORY_NO") && (String.valueOf(claim.get("CATEGORY_NO")).equals("2"))){
            if(claim.containsKey("CATEGORY_NO")){
                switch(ACCastUtilities.toInt(claim.get("CATEGORY_NO"),0)){
                //��{��񃌃R�[�h
                case 2:
                    String[] kohiType = new String[3];
                    //��{��񃌃R�[�h���擾���A����ʂ�ޔ�����B
                    if(!ACTextUtilities.isNullText(VRBindPathParser.get("201058",claim))){
                        kohiType[0] = String.valueOf(VRBindPathParser.get("201058",claim));
                    }
                    if(!ACTextUtilities.isNullText(VRBindPathParser.get("201059",claim))){
                        kohiType[1] = String.valueOf(VRBindPathParser.get("201059",claim));
                    }
                    if(!ACTextUtilities.isNullText(VRBindPathParser.get("201060",claim))){
                        kohiType[2] = String.valueOf(VRBindPathParser.get("201060",claim));
                    }
                    
                    //������񎯕ʔԍ����L�[�Ƀn�b�V���}�b�v�ɑޔ�
                    kohiMap.put(String.valueOf(VRBindPathParser.get("201001",claim)),kohiType);
                    
                    //�Ώی���ݒ肷��B
                    if(ACTextUtilities.isNullText(getTargetDate())){
                        setTargetDate(ACCastUtilities.toDate(String.valueOf(VRBindPathParser.get("201003",claim)) + "01",null));
                    }
                    
                    //[H20.5 �@�����Ή�] fujihara add start
                    unitCalc.parseBase(claim);
                    //[H20.5 �@�����Ή�] fujihara add end
                    
                    break;
                    
                //[H20.5 �@�����Ή�] fujihara add start
                //����f�Ô��񃌃R�[�h
                case 5:
            		//����f�Ô��񃌃R�[�h�����ԍ���99�̏ꍇ�̂ݗL��
            		if ("99".equals(ACCastUtilities.toString(claim.get("501007"),""))){
            			unitCalc.parseRecuperation(claim);
            		}
                	break;
                //[H20.5 �@�����Ή�] fujihara add end
                    
                //�W�v��񃌃R�[�h
                case 7:
                    typeList.add(claim);
                    break;
                    
                //��������҉��T�[�r�X��p��񃌃R�[�h
                case 8:
                    nursingList.add(claim);
                    break;
                    
                //�Љ���@�l�y���z��񃌃R�[�h
                case 9:
                    reductionList.add(claim);
                    break;
                }
            }
        }
        //�W�v��񃌃R�[�h�̏W�v���s��
        for(int i = 0; i < typeList.size(); i++){
            //parseType(,kohiType,manager);
            VRMap map = (VRMap)typeList.get(i);
            parseType(map,(String[])kohiMap.get(String.valueOf(VRBindPathParser.get("701001",map))),manager);
        }
        //��������҉��T�[�r�X��p��񃌃R�[�h�̏W�v���s���B
        for(int i = 0; i < nursingList.size(); i++){
            //parseNursing((VRMap)nursingList.get(i),kohiType,manager);
            VRMap map = (VRMap)nursingList.get(i);
            parseNursing(map,(String[])kohiMap.get(String.valueOf(VRBindPathParser.get("801001",map))),manager);
        }
        //�Љ���@�l�y���z��񃌃R�[�h
        for(int i = 0; i < reductionList.size(); i++){
            VRMap map = (VRMap)reductionList.get(i);
            parseReduction(map);
        }
        
        
    }
    
    /**
     * �W�v��񃌃R�[�h�̏W�v�����s����B
     * @param claim
     * @param kohiType
     * @throws Exception
     */
    private void parseType(VRMap claim, String[] kohiType,QP001Manager manager) throws Exception {
        
        //���p�ҕ��S�z��0�~�ȊO�̏ꍇ�A���[�ɏo�͂���B
        if(ACCastUtilities.toInt(claim.get("701017"),0) != 0){
            //�T�[�r�X��ރR�[�h
            String serviceCodeKind = String.valueOf(claim.get("701007"));
            //�T�[�r�X����
            String serviceName = manager.getServiceName(serviceCodeKind);
            // [Masahiko Higuchi] edit - begin ���p�Ҍ����������i�ȈՔőΉ��j
            //edit start 2008.6.5 fujihara.shin
            //setServiceData(serviceName,ACCastUtilities.toInt(claim.get("701017"),0),claim);
            //�P�ʐ���\������悤�C��
            //���ł��R�[�h�̏C���ʂ����Ȃ��Ȃ���@��I��
            setServiceData(serviceName,ACCastUtilities.toInt(claim.get("701017"),0),claim);
            //edit end 2008.6.5 fujihara.shin
            // [Masahiko Higuchi] edit - end
        }
        
        //�o������Ô�p�ҕ��S�z��0�~�ȊO�̏ꍇ�A���[�ɏo�͂���B
        if(ACCastUtilities.toInt(claim.get("701029"),0) != 0){
        	// 2006.05.09 edit sta shin.fujihara
        	// �\�����閼�̂�ύX
            //setServiceData("��Ô�p�ҕ��S",ACCastUtilities.toInt(claim.get("701029"),0));
        	String styleNo = String.valueOf(claim.get("701001"));
        	
        	//�l����܁A��܂̓�A��\�ł���Γ���f�Ô�
        	if("7164,7165,71A3".indexOf(styleNo) != -1){
                // [Masahiko Higuchi] edit - begin ���p�Ҍ����������i�ȈՔőΉ��j
        		setServiceData("����f�Ô�p�ҕ��S",ACCastUtilities.toInt(claim.get("701029"),0),claim, false);
                // [Masahiko Higuchi] edit - end
            //�l����l�A��l�̓�A���ł���΋ً}���{�ݗ×{
        	} else if("7153,7154,7193".indexOf(styleNo) != -1){
                // [Masahiko Higuchi] edit - begin ���p�Ҍ����������i�ȈՔőΉ��j
        		setServiceData("���莡�Ô�p�ҕ��S",ACCastUtilities.toInt(claim.get("701029"),0),claim, false);
                // [Masahiko Higuchi] edit - end
        	}
        	//[H20.5 �@�����Ή�] fujihara add start
        	//H20.5�ȍ~�̗l����l�A��l�̓�A���ł���ꍇ
        	//[ID:0000738][Shin Fujihara] 2012/05 edit begin �l�����������ʔԍ��ύX�Ή��R��
        	//else if ("7155,7156,7194".indexOf(styleNo) != -1){
        	else if ("7155,7156,7195".indexOf(styleNo) != -1){
        	//[ID:0000738][Shin Fujihara] 2012/05 edit end �l�����������ʔԍ��ύX�Ή��R��
        		int[] costs = unitCalc.getRecuperationCost(claim);
        		//���莡�Ô�̎��ȕ��S�����݂���
        		if (costs[0] != 0){
                    // 2008/05/27 [Masahiko Higuchi] edit - begin ���p�Ҍ����������i�ȈՔőΉ��j
        			setServiceData("���莡�Ô�p�ҕ��S",costs[0],claim, false);
                    // 2008/05/27 [Masahiko Higuchi] edit - end
        		}
        		//���ʗ×{��̎��ȕ��S�����݂���
        		if (costs[1] != 0){
                    // 2008/05/27 [Masahiko Higuchi] edit - begin ���p�Ҍ����������i�ȈՔőΉ��j
        			setServiceData("���ʗ×{��p�ҕ��S",costs[1],claim, false);
                    // 2008/05/27 [Masahiko Higuchi] edit - end
        		}
        	}
        	//[H20.5 �@�����Ή�] fujihara add end
            // 2006.05.09 edit end
        }
        
        if(kohiType == null){
            return;
        }
        
        //����ȕ��S����0�~�ȊO�̏ꍇ�A���[�ɏo�͂���B
        for(int i = 0; i < kohiType.length; i++){
            
            int cost = 0;
            
            switch(i){
                //����P
                case 0:
                    //����P�{�l���S�z
                    cost += ACCastUtilities.toInt(claim.get("701020"),0);
                    //(����1���o������Ô�)�o������Ô�{�l���S�z8��
                    cost += ACCastUtilities.toInt(claim.get("701032"),0);
                    break;
                //����Q
                case 1:
                    //����Q�{�l���S
                    cost += ACCastUtilities.toInt(claim.get("701023"),0);
                    //(����2���o������Ô�)�o������Ô�{�l���S�z8��
                    cost += ACCastUtilities.toInt(claim.get("701035"),0);
                    break;
                //����R
                case 2:
                    //����R�{�l���S
                    cost += ACCastUtilities.toInt(claim.get("701026"),0);
                    //(����3���o������Ô�)�o������Ô�{�l���S�z8��
                    cost += ACCastUtilities.toInt(claim.get("701038"),0);
                    break;
            }
            
            //����{�l���S�z�����݂���ꍇ
            if(cost != 0){
            	String kohiName = "����f�Ô����S";
            	// 2006.05.09 edit sta shin.fujihara
            	String styleNo = String.valueOf(claim.get("701001"));
                //�l����l�A��l�̓�A���ł���΋ً}���{�ݗ×{
            	if("7153,7154,7193".indexOf(styleNo) != -1){
            		kohiName = "���莡�Ô����S";
            	}
            	//[H20.5 �@�����Ή�] fujihara add start
            	//�����̌���̂��g�p����邱�Ƃ͖���
            	//[ID:0000738][Shin Fujihara] 2012/05 edit begin �l�����������ʔԍ��ύX�Ή��R��
            	//else if("7155,7156,7194".indexOf(styleNo) != -1){
            	else if("7155,7156,7195".indexOf(styleNo) != -1){
            	//[ID:0000738][Shin Fujihara] 2012/05 edit end �l�����������ʔԍ��ύX�Ή��R��
            		kohiName = "���莡�ÁE���ʗ×{����S";
            	}
            	//[H20.5 �@�����Ή�] fujihara add end
                // 2006.05.09 edit end
                //����f�[�^�����݂��Ȃ��ꍇ
                if(!ACTextUtilities.isNullText(kohiType[i])){
                    kohiName = manager.getKohiData(kohiType[i],"KOHI_NAME");
                }
                setKohiData(kohiName,cost);
            }
        }
    }
    
    /**
     * �W�v��񃌃R�[�h�̏W�v�����s����B
     * @param claim
     * @param kohiType
     * @throws Exception
     */
    private void parseNursing(VRMap claim, String[] kohiType,QP001Manager manager) throws Exception {
        
        //���p�ҕ��S�z��0�~�ȊO�̏ꍇ�A���[�ɏo�͂���B
        if(ACCastUtilities.toInt(claim.get("801021"),0) != 0){
            //�T�[�r�X��ރR�[�h
        	//edit sta 2006.05.16 shin.fujihara �����C��
            //setServiceData("��������җ��p�ҕ��S",ACCastUtilities.toInt(claim.get("801021"),0));
            // [Masahiko Higuchi] edit - begin ���p�Ҍ����������i�ȈՔőΉ��j
        	setServiceData("�H��E���Z��",ACCastUtilities.toInt(claim.get("801021"),0),claim);
        	// [Masahiko Higuchi] edit - end
            //edit end 2006.05.16 shin.fujihara
        }
        
        if(kohiType == null){
            return;
        }
        
        //����ȕ��S����0�~�ȊO�̏ꍇ�A���[�ɏo�͂���B
        for(int i = 0; i < kohiType.length; i++){
            
            int cost = 0;
            
            switch(i){
                //����P
                case 0:
                    //����P�{�l���S�z
                    cost += ACCastUtilities.toInt(claim.get("801027"),0);
                    break;
                //����Q
                case 1:
                    cost += ACCastUtilities.toInt(claim.get("801030"),0);
                    break;
                //����R
                case 2:
                    cost += ACCastUtilities.toInt(claim.get("801033"),0);
                    break;
            }
            
            //����{�l���S�����݂���ꍇ
            if(cost != 0){
                String kohiName = "";
                //����f�[�^�����݂��Ȃ��ꍇ
                if(!ACTextUtilities.isNullText(kohiType[i])){
                    kohiName = manager.getKohiData(kohiType[i],"KOHI_NAME");
                }
                setKohiData(kohiName,cost);
            }
        }
    }
    
    /**
     * �Е��y���𔽉f������B
     * @param claim
     * @throws Exception
     */
    private void parseReduction(VRMap claim) throws Exception {
        //���p�ҕ��S�z��0�~�ȊO�̏ꍇ�A���[�ɏo�͂���B
        if(ACCastUtilities.toInt(claim.get("901010"),0) != 0){
        	// [Masahiko Higuchi] edit - begin ���p�Ҍ����������i�ȈՔőΉ��j
            setServiceData("�Љ���@�l�y��",(ACCastUtilities.toInt(claim.get("901010"),0)) * -1,claim, false);
            // [Masahiko Higuchi] edit - end
        }
    }
    
    
    /**
     * ���p�ҕ��S�̃T�[�r�X���̂Ƌ��z��ݒ肷��B
     * @param serviceName �ݒ肷��T�[�r�X����
     * @param cost ���p�ҕ��S�z
     * @param claim �������R�[�h�f�[�^
     * 
     * @throws Exception
     */
    private void setServiceData(String serviceName, int cost,VRMap claim) throws Exception {
    	setServiceData(serviceName, cost, claim, true);
    }
    
    /**
     * ���p�ҕ��S�̃T�[�r�X���̂Ƌ��z��ݒ肷��B
     * @param serviceName �ݒ肷��T�[�r�X����
     * @param cost ���p�ҕ��S�z
     * @param claim �������R�[�h�f�[�^
     * @param isPrint �P�ʐ��A�񐔁E�����̈󎚂����邩���Ȃ����B True:�\������ False:�\�����Ȃ�
     * @throws Exception
     */
    private void setServiceData(String serviceName, int cost,VRMap claim, boolean isPrint) throws Exception {
        boolean end = true;
        int unit = 0;
        // [Masahiko Higuchi] add - begin ���p�Ҍ����������i�ȈՔőΉ��j
        Integer categoryNo = ACCastUtilities.toInteger(VRBindPathParser.get("CATEGORY_NO", claim));
        int count = 0;
        int etcTotal = 0;
        
        if (isPrint) {
	        //�W�v��񃌃R�[�h��\�����ނ̒萔���ł���ꍇ
	        if (QkanConstants.CATEGORY_NO_RECORD_TOTAL.equals(categoryNo)) {
	            // �ی��P�ʐ����v���̗p
	    		unit = ACCastUtilities.toInt(VRBindPathParser.get("701014",claim),0);
	        	//�T�[�r�X������������E�񐔂Ƃ��ĕ\��
	        	count = ACCastUtilities.toInt(VRBindPathParser.get("701008",claim),0);
	        	//���̑��p���Z�l
	        	etcTotal = ACCastUtilities.toInt(VRBindPathParser.get("701014",claim),0);
	            
	        //��������҉��T�[�r�X��p��񃌃R�[�h��\�����ނ̏��萔�ł���ꍇ
	        } else if (QkanConstants.CATEGORY_NO_RECODE_SPECIAL_ENTER_SERVICE.equals(categoryNo)){
	            // ��p�P��4��
	            int hiyoTanka = ACCastUtilities.toInt(VRBindPathParser.get("801010",claim),0);
	            // ���S���x�z4��
	        	unit = ACCastUtilities.toInt(VRBindPathParser.get("801011",claim),0);
	            // ���S���x�z����p�P��������ꍇ�͔�p�P�����̗p����
	            if(hiyoTanka < unit){
	                unit = hiyoTanka;
	            }
	        	count = ACCastUtilities.toInt(VRBindPathParser.get("801012",claim),0);
	        	//���̂̕ϊ�����
	        	serviceName = parseTokuteiServiceName(claim);
	        	//���̑��p���Z�l
	        	etcTotal = ACCastUtilities.toInt(VRBindPathParser.get("801016",claim),0);
	        }
        }
        // [Masahiko Higuchi] add - end
        
        for(int i = 0; i < serviceClaim.length; i++){
            // [Masahiko Higuchi] edit - begin ���p�Ҍ����������i�ȈՔőΉ��j
            // �T�[�r�X���̋y�ѕ��S�z������̏ꍇ
            if((serviceNames[i] != null) && (serviceName.equals(serviceNames[i])) && serviceUnit[i] == unit){
                serviceClaim[i] += cost;
                serviceCount[i] += count;
                end = false;
                break;                    
            }
            
            if (serviceNames[i] == null) {
                serviceNames[i] = serviceName;
                serviceClaim[i] = cost;
                serviceUnit[i] = unit;
                serviceCount[i] = count;
                end = false;
                break;
            }
            
        }
        
        if(end){
            serviceNames[serviceClaim.length - 1] = "���̑�";
            serviceClaim[serviceClaim.length - 1] += cost;
            // [Masahiko Higuchi] add - begin ���p�Ҍ����������i�ȈՔőΉ��j
            serviceUnit[serviceClaim.length - 1] += etcTotal;
            serviceCount[serviceClaim.length - 1] = 1;
            // [Masahiko Higuchi] add - end
        }
    }
    
    /**
     * ����{�ݓ����҉��T�[�r�X��̖��̂��擾���܂��B
     * @param claim
     * @return
     * @throws Exception
     */
    private String parseTokuteiServiceName(VRMap claim) throws Exception{
        String result = "";
        // �����
        final String KYOJYUHI = "���Z��";
        final String SYOKUHI = "�H��";
        // ���̂ɕϊ����Ď擾
        String detailName = ACCastUtilities.toString(VRBindPathParser.get("801034",claim),"");

        if("".equals(detailName)){
            // �󔒂̏ꍇ�͎b��Ή�
            return "�H��E���Z��";
            
        }else{
            // �H��ł���ꍇ
            if(detailName.indexOf(SYOKUHI) > 0){
                // �ꗥ�H��
                return SYOKUHI;
            }
            // ���Z��ł���ꍇ
            result = KYOJYUHI + "(" + detailName + ")";
        }
        // �l��߂�
        return result;
    }
    
    
    /**
     * ���p�ҕ��S�̌���̂Ƌ��z��ݒ肷��B
     * @param kohiName
     * @param cost
     * @throws Exception
     */
    private void setKohiData(String kohiName, int cost) throws Exception {
        boolean end = true;
        for(int i = 0; i < kohiClaim.length; i++){
            if((kohiNames[i] != null) && (kohiName.equals(kohiNames[i]))){
                kohiClaim[i] += cost;
                end = false;
                break;
            }
            
            if(kohiClaim[i] == 0){
                kohiNames[i] = kohiName;
                kohiClaim[i] = cost;
                end = false;
                break;
            }
        }
        
        if(end){
            kohiNames[kohiClaim.length - 1] = "���̑�";
            kohiClaim[kohiClaim.length - 1] += cost;
        }
    }
    
    /**
     * �ێ����Ă���f�[�^���}�b�v�ɕϊ�����B
     * @return
     * @throws Exception
     */
    public VRMap getRecord() throws Exception {
        VRMap result = new VRHashMap();
        
        setData(result, "1601001", get_1601001());
        setData(result, "1601002", get_1601002());
        setData(result, "1601003", get_1601003());
        setData(result, "1601004", get_1601004());
        setData(result, "1601005", get_1601005());
        setData(result, "1601006", get_1601006());
        setData(result, "1601007", get_1601007());
        setData(result, "1601008", get_1601008());
        setData(result, "1601009", get_1601009());
        
        setData(result, "1601010", get_1601010());
        setData(result, "1601011", get_1601011());
        setData(result, "1601012", get_1601012());
        setData(result, "1601013", get_1601013());
        setData(result, "1601014", get_1601014());
        setData(result, "1601015", get_1601015());
        setData(result, "1601016", get_1601016());
        setData(result, "1601017", get_1601017());
        setData(result, "1601018", get_1601018());
        setData(result, "1601019", get_1601019());
        
        setData(result, "1601020", get_1601020());
        setData(result, "1601021", get_1601021());
        setData(result, "1601022", get_1601022());
        setData(result, "1601023", get_1601023());
        setData(result, "1601024", get_1601024());
        // 2008/02/06 [Masahiko Higuchi] del - begin Ver 5.4.1 ���p�Ҍ����������Ή�
        //setData(result, "1601025", get_1601025());
        //setData(result, "1601026", get_1601026());
        // 2008/02/06 [Masahiko Higuchi] del - end
        setData(result, "1601027", get_1601027());
        setData(result, "1601028", get_1601028());
        setData(result, "1601029", get_1601029());
        
        setData(result, "1601030", get_1601030());
        setData(result, "1601031", get_1601031());
        setData(result, "1601032", get_1601032());
        setData(result, "1601033", get_1601033());
        setData(result, "1601034", get_1601034());
        setData(result, "1601035", get_1601035());
        setData(result, "1601036", get_1601036());
        setData(result, "1601037", get_1601037());
        
        setData(result, "TARGET_DATE", getTargetDate());
        
        // 2007/11/09 [Masahiko Higuchi] add - begin Ver 5.4.1 ���p�Ҍ����������Ή�
        setData(result, "1601038", get_1601038());
        setData(result, "1601039", get_1601039());
        setData(result, "1601040", get_1601040());
        setData(result, "1601041", get_1601041());
        setData(result, "1601042", get_1601042());
        setData(result, "1601043", get_1601043());
        setData(result, "1601044", get_1601044());
        setData(result, "1601045", get_1601045());
        setData(result, "1601046", get_1601046());
        setData(result, "1601047", get_1601047());
        setData(result, "1601048", get_1601048());
        setData(result, "1601049", get_1601049());
        setData(result, "1601050", get_1601050());
        setData(result, "1601051", get_1601051());
        setData(result, "1601052", get_1601052());
        setData(result, "1601053", get_1601053());
        setData(result, "1601054", get_1601054());
        setData(result, "1601055", get_1601055());
        setData(result, "1601056", get_1601056());
        setData(result, "1601057", get_1601057());
        //setData(result, "1601062", get_1601062());
        //setData(result, "1601063", get_1601063());
        // 2007/11/09 [Masahiko Higuchi] add - end
        
        return result;
    }
    
    //[���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara add start
    /**
     * ���p�Ҍ����������ɂ����闘�p�ҕ��S�z(�S�z���ȕ��S��������)���擾����
     */
    public int getClaimTotal(){
    	int result = 0;
    	
    	//��쐿���{�l���S��
    	result += get_1601002();
    	result += get_1601004();
    	result += get_1601006();
    	result += get_1601008();
    	result += get_1601010();
    	result += get_1601012();
    	result += get_1601014();
    	result += get_1601016();
    	result += get_1601018();
    	result += get_1601020();
    	
    	//����ȕ��S��
    	result += get_1601022();
    	result += get_1601024();
    	
    	return result;
    }
    //[���p�Ҍ����������E�̎����@�ڍהőΉ�] fujihara add end

}

//[H20.5 �@�����Ή�] fujihara add start
class RecuperationUnitCalc{
	
	Map unitsStack = new VRHashMap();
	
	/**
	 * �ی����t��
	 */
	private int _201029 = 0;
	/**
	 * ����P���t��
	 */
	private int _201030 = 0;
	/**
	 * ����Q���t��
	 */
	private int _201031 = 0;
	/**
	 * ����R���t��
	 */
	private int _201032 = 0;
	
	/**
	 * ���v�P�ʐ�
	 */
	private int _501013 = 0;
	/**
	 * ����P���v�P�ʐ�
	 */
	private int _501016 = 0;
	/**
	 * ����Q���v�P�ʐ�
	 */
	private int _501019 = 0;
	/**
	 * ����R���v�P�ʐ�
	 */
	private int _501022 = 0;
	
	/**
	 * ��{��񃌃R�[�h���
	 */
	public void parseBase(Map claim){
		//�������ʔԍ�����ΏۃI�u�W�F�N�g���擾
		RecuperationUnitCalc calc = getTargetUnit(ACCastUtilities.toString(claim.get("201001"),""));
		
		calc._201029 = ACCastUtilities.toInt(claim.get("201029"),0);
		
		calc._201030 = ACCastUtilities.toInt(claim.get("201030"),0);
		calc._201031 = ACCastUtilities.toInt(claim.get("201031"),0);
		calc._201032 = ACCastUtilities.toInt(claim.get("201032"),0);
	}
	
	/**
	 * ���ʗ×{����
	 * @param claim
	 */
	public void parseRecuperation(Map claim){
		//�������ʔԍ�����ΏۃI�u�W�F�N�g���擾
		RecuperationUnitCalc calc = getTargetUnit(ACCastUtilities.toString(claim.get("501001"),""));
		
		calc._501013 = ACCastUtilities.toInt(claim.get("501013"),0);
		
		calc._501016 = ACCastUtilities.toInt(claim.get("501016"),0);
		calc._501019 = ACCastUtilities.toInt(claim.get("501019"),0);
		calc._501022 = ACCastUtilities.toInt(claim.get("501022"),0);
	}
	
	/**
	 * ���ʗ×{��̎��ȕ��S�z���Z�肷��
	 * @param claim
	 * @return
	 */
	public int[] getRecuperationCost(Map claim){
		//�������ʔԍ�����ΏۃI�u�W�F�N�g���擾
		RecuperationUnitCalc calc = getTargetUnit(ACCastUtilities.toString(claim.get("701001"),""));
		
		//�ی����P�ʐ��P��*�P�ʐ��P��(10)*(100-���t��)/100
		//int recuperationCost = (calc._501013 * 10 * (100 - calc._201029)) / 100;
		
		//�������z
		int totalCost = calc._501013 * 10;
		//�ی������z
		int insuranceCost = (int)Math.floor( (double)(calc._501013 * 10 * calc._201029) / 100d);
		//�S�ۂ������t��
        int amendsRate = calc._201029;
        //������z
        int kohiCost = 0;
        
        //����1�̓K�p�����邩�m�F
        if(calc._201030 != 0){
        	//���r��������^��
        	if (calc._501013 == calc._501016) {
	            //����P���t����100�̏ꍇ
	            if(calc._201030 == 100){
	                //���z��Í��v���z-�ی������z��ݒ肷��B
	            	kohiCost = totalCost - insuranceCost;
	            } else {
	            	kohiCost += (int)Math.floor(totalCost * (calc._201030 - calc._201029) / 100);                
	            }
	            
	        //���r������̏ꍇ
        	} else {
        		kohiCost += (int)Math.floor(calc._501016 * 10 * (calc._201030 - amendsRate) / 100);
        		amendsRate = calc._201030;
        	}
        }
        //����̑ΏۂƂȂ鎩�ȕ��S�z���c���Ă��邩�m�F
        if(totalCost >= (insuranceCost + kohiCost)){
            //����2�̓K�p�����邩�m�F
            if(calc._201031 != 0){
            	//���r�����^��
            	if (calc._501013 == calc._501019) {
	                //����Q�̋��t����100�̏ꍇ
	                if(calc._201031 == 100){
	                	kohiCost = totalCost - insuranceCost;
	                } else {
	                	kohiCost += (int)Math.floor(totalCost * (calc._201031 - calc._201030) / 100);
	                }
	                
	            //���r���̏ꍇ
            	} else {
            		kohiCost += (int)Math.floor(calc._501019 * 10 * (calc._201031 - amendsRate) / 100);
            		amendsRate = calc._201031;
            	}
            }
        }
        //����̑ΏۂƂȂ鎩�ȕ��S���c���Ă��邩�m�F
		if(totalCost >= (insuranceCost + kohiCost)){
            if(calc._201032 != 0){
            	//���r�����^��
            	if (calc._501013 == calc._501022) {
	                if(calc._201032 == 100){
	                	kohiCost = totalCost - insuranceCost;
	                } else {
	                	kohiCost += (int)Math.floor(totalCost * (calc._201032 - calc._201031) / 100);
	                }
            	} else {
            		kohiCost += (int)Math.floor(calc._501022 * 10 * (calc._201032 - amendsRate) / 100);
            	}
            }
        }
		
		//���ʗ×{��p�ҕ��S�z
		int recuperationCost = totalCost - insuranceCost - kohiCost;
		
		//�ً}�����Â͍��Z������ʗ×{�������������
		int treatmentCost = ACCastUtilities.toInt(claim.get("701029"),0) - recuperationCost; 
		
		return new int[]{treatmentCost,recuperationCost}; 
	}
	
	private RecuperationUnitCalc getTargetUnit(String no) {
		RecuperationUnitCalc calc = null;
		
		if (unitsStack.containsKey(no)){
			calc = (RecuperationUnitCalc)unitsStack.get(no);
		} else {
			calc = new RecuperationUnitCalc();
			unitsStack.put(no, calc);
		}
		return calc;
	}
	
	
}
//[H20.5 �@�����Ή�] fujihara add end