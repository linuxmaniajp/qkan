
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
 * �쐬��: 2008/02/27  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �������o�� (P)
 * �v���Z�X �������� (001)
 * �v���O���� ���p�Ҍ����������R�[�h-�ڍ� (QP001RecordUserClaimDetails)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

public class QP001RecordUserClaimDetails extends QP001RecordAbstract {

    // ���p�ҕ��S�@�T�[�r�X��
    private String[] serviceNames = new String[19];
    // ���p�ҕ��S�@���p�ҕ��S�z
    private int[] serviceClaim = new int[19];
    // ���p�ҕ��S�@�P�ʐ�
    private int[] serviceUnit = new int[19];
    // ���p�ҕ��S�@�񐔁E����
    private int[] serviceCount = new int[19];
    
    // ����{�l���S�@�����
    private String[] kohiNames = new String[2];
    // ����{�l���S�@�{�l���S�z
    private int[] kohiClaim = new int[2];
    
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
    
    //[2014�N�v�]][Shinobu Hitaka] 2015/04/15 add begin �u���p�ҕ��S�z0�~������\�ɂ���v�̃`�F�b�N��
    private int zeroPrint = 0;
    //[2014�N�v�]][Shinobu Hitaka] 2015/04/15 add end

    protected String getSerialId() {
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
    
    //[2014�N�v�]][Shinobu Hitaka] 2015/04/15 add begin �u���p�ҕ��S�z0�~������\�ɂ���v�̃`�F�b�N��
    /**
     * ���p�ҕ��S�z0�~�̈󎚃��[�h��ݒ肷��B
     * @param target
     */
    public void setZeroPrint(int zeroPrint) {
        this.zeroPrint = zeroPrint;
    }
    
    /**
     * ���p�ҕ��S�z0�~�̈󎚃��[�h���擾����B
     * @return
     */
    public int getZeroPrint() {
        return zeroPrint;
    }
    //[2014�N�v�]][Shinobu Hitaka] 2015/04/15 add end
    
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
    /**
     * ���p�ҕ��S(11���)�@�T�[�r�X�����擾���܂��B
     * @return
     */
    private String get_1601062() {
        return serviceNames[10];
    }
    /**
     * ���p�ҕ��S(11���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601063() {
        return serviceUnit[10];
    }
    /**
     * ���p�ҕ��S(11���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601064() {
        return serviceCount[10];
    }
    /**
     * ���p�ҕ��S(11���)�@���p�ҕ��S�z���擾���܂��B
     * @return
     */
    private int get_1601065() {
        return serviceClaim[10];
    }
    /**
     * ���p�ҕ��S(12���)�@�T�[�r�X�����擾���܂��B
     * @return
     */
    private String get_1601066() {
        return serviceNames[11];
    }
    /**
     * ���p�ҕ��S(12���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601067() {
        return serviceUnit[11];
    }
    /**
     * ���p�ҕ��S(12���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601068() {
        return serviceCount[11];
    }
    /**
     * ���p�ҕ��S(12���)�@���p�ҕ��S�z���擾���܂��B
     * @return
     */
    private int get_1601069() {
        return serviceClaim[11];
    }
    /**
     * ���p�ҕ��S(13���)�@�T�[�r�X�����擾���܂��B
     * @return
     */
    private String get_1601070() {
        return serviceNames[12];
    }
    /**
     * ���p�ҕ��S(13���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601071() {
        return serviceUnit[12];
    }
    /**
     * ���p�ҕ��S(13���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601072() {
        return serviceCount[12];
    }
    /**
     * ���p�ҕ��S(13���)�@���p�ҕ��S�z���擾���܂��B
     * @return
     */
    private int get_1601073() {
        return serviceClaim[12];
    }
    /**
     * ���p�ҕ��S(14���)�@�T�[�r�X�����擾���܂��B
     * @return
     */
    private String get_1601074() {
        return serviceNames[13];
    }
    /**
     * ���p�ҕ��S(14���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601075() {
        return serviceUnit[13];
    }
    /**
     * ���p�ҕ��S(14���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601076() {
        return serviceCount[13];
    }
    /**
     * ���p�ҕ��S(14���)�@���p�ҕ��S�z���擾���܂��B
     * @return
     */
    private int get_1601077() {
        return serviceClaim[13];
    }
    /**
     * ���p�ҕ��S(15���)�@�T�[�r�X�����擾���܂��B
     * @return
     */
    private String get_1601078() {
        return serviceNames[14];
    }
    /**
     * ���p�ҕ��S(15���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601079() {
        return serviceUnit[14];
    }
    /**
     * ���p�ҕ��S(15���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601080() {
        return serviceCount[14];
    }
    /**
     * ���p�ҕ��S(15���)�@���p�ҕ��S�z���擾���܂��B
     * @return
     */
    private int get_1601081() {
        return serviceClaim[14];
    }
    /**
     * ���p�ҕ��S(16���)�@�T�[�r�X�����擾���܂��B
     * @return
     */
    private String get_1601082() {
        return serviceNames[15];
    }
    /**
     * ���p�ҕ��S(16���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601083() {
        return serviceUnit[15];
    }
    /**
     * ���p�ҕ��S(16���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601084() {
        return serviceCount[15];
    }
    /**
     * ���p�ҕ��S(16���)�@���p�ҕ��S�z���擾���܂��B
     * @return
     */
    private int get_1601085() {
        return serviceClaim[15];
    }
    /**
     * ���p�ҕ��S(17���)�@�T�[�r�X�����擾���܂��B
     * @return
     */
    private String get_1601086() {
        return serviceNames[16];
    }
    /**
     * ���p�ҕ��S(17���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601087() {
        return serviceUnit[16];
    }
    /**
     * ���p�ҕ��S(17���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601088() {
        return serviceCount[16];
    }
    /**
     * ���p�ҕ��S(17���)�@���p�ҕ��S�z���擾���܂��B
     * @return
     */
    private int get_1601089() {
        return serviceClaim[16];
    }
    /**
     * ���p�ҕ��S(18���)�@�T�[�r�X�����擾���܂��B
     * @return
     */
    private String get_1601090() {
        return serviceNames[17];
    }
    /**
     * ���p�ҕ��S(18���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601091() {
        return serviceUnit[17];
    }
    /**
     * ���p�ҕ��S(18���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601092() {
        return serviceCount[17];
    }
    /**
     * ���p�ҕ��S(18���)�@���p�ҕ��S�z���擾���܂��B
     * @return
     */
    private int get_1601093() {
        return serviceClaim[17];
    }
    /**
     * ���p�ҕ��S(19���)�@�T�[�r�X�����擾���܂��B
     * @return
     */
    private String get_1601094() {
        return serviceNames[18];
    }
    /**
     * ���p�ҕ��S(19���)�@�P�ʐ����擾���܂��B
     * @return
     */
    private int get_1601095() {
        return serviceUnit[18];
    }
    /**
     * ���p�ҕ��S(19���)�@�񐔂��擾���܂��B
     * @return
     */
    private int get_1601096() {
        return serviceCount[18];
    }
    /**
     * ���p�ҕ��S(19���)�@���p�ҕ��S�z���擾���܂��B
     * @return
     */
    private int get_1601097() {
        return serviceClaim[18];
    }
    
    /**
     * 
     * @param claimList �������
     * @param manager �f�[�^�}�l�[�W��
     * @throws Exception
     */
    public void parse(VRList claimList,QP001Manager manager) throws Exception {
        
    	//���׏�񃌃R�[�h�ޔ�
    	VRMap detailsMap = new VRHashMap();
        // �W�v��񃌃R�[�h�ޔ�p
        Map typeMap = new TreeMap();
        // ��������҉��T�[�r�X��p��񃌃R�[�h
        VRList nursingList = new VRArrayList();
        // �Љ���@�l�y���z��񃌃R�[�h
        VRList reductionList = new VRArrayList();
        // ������
        VRMap kohiMap = new VRHashMap();
        
        //�\�[�g������ǉ�
        QP001P02_10Event sorter = new QP001P02_10Event();
        Collections.sort(claimList, sorter.new RecordComparator());
        
        for(int i = 0; i < claimList.size(); i++){
            VRMap claim = (VRMap)claimList.get(i);
            
            //�L�[�̑��݃`�F�b�N
            if(!claim.containsKey("CATEGORY_NO")){
            	continue;
            }
            
            
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
                
            //���׏�񃌃R�[�h
            case 3:
            	/*
            	 * �T�[�r�X��ރR�[�h+�T�[�r�X���ڃR�[�h+'-'+�T�[�r�X�P�ʐ��{'-'+�E�v���i�p��Ή��j
            	 * ��L��������L�[�Ƃ���TreeMap�ɑ}������B
            	 * �쐬����TreeMap��detailsMap�ɃT�[�r�X��ރR�[�h���L�[�Ƃ��ēo�^����B
            	 * 
            	 * detailsMap -+- "11" - TreeMap <- �T�[�r�X��ރR�[�h11�̃f�[�^�̏W�܂�
            	 *             |
            	 *             +- "12" - TreeMap <- �T�[�r�X��ރR�[�h12�̃f�[�^�̏W�܂�
            	 *             |
            	*/
            	
            	
            	StringBuilder detailsKey = new StringBuilder();
            	String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("301007",claim));
            	
            	detailsKey.append(serviceCodeKind);
            	detailsKey.append(ACCastUtilities.toString(VRBindPathParser.get("301008",claim)));
            	detailsKey.append("-");
            	detailsKey.append(ACCastUtilities.toString(VRBindPathParser.get("301014",claim)));
            	detailsKey.append("-");
            	detailsKey.append(ACCastUtilities.toString(VRBindPathParser.get("301018",claim)));
            	
            	Map detailsTmp = null;
            	if (detailsMap.containsKey(serviceCodeKind)){
            		detailsTmp = (Map)detailsMap.get(serviceCodeKind);
            	} else {
            		detailsTmp = new TreeMap();
            		detailsMap.put(serviceCodeKind, detailsTmp);
            	}
            	
            	detailsTmp.put(detailsKey.toString(), claim);
            	break;
                
            // [H27.4�@�����Ή�][Shinobu Hitaka] 2015/04/08 add start
            //���׏��i�Z���n����j���R�[�h
            case 18:
            	/*
            	 * �T�[�r�X��ރR�[�h+�T�[�r�X���ڃR�[�h+'-'+�T�[�r�X�P�ʐ��{'-'+�E�v���i�p��Ή��j
            	 * ��L��������L�[�Ƃ���TreeMap�ɑ}������B
            	 * �쐬����TreeMap��detailsMap�ɃT�[�r�X��ރR�[�h���L�[�Ƃ��ēo�^����B
            	 * 
            	 * detailsMap -+- "11" - TreeMap <- �T�[�r�X��ރR�[�h11�̃f�[�^�̏W�܂�
            	 *             |
            	 *             +- "12" - TreeMap <- �T�[�r�X��ރR�[�h12�̃f�[�^�̏W�܂�
            	 *             |
            	*/
            	
            	
            	StringBuilder detailsKeyJT = new StringBuilder();
            	String serviceCodeKindJT = ACCastUtilities.toString(VRBindPathParser.get("1801007",claim));
            	
            	detailsKeyJT.append(serviceCodeKindJT);
            	detailsKeyJT.append(ACCastUtilities.toString(VRBindPathParser.get("1801008",claim)));
            	detailsKeyJT.append("-");
            	detailsKeyJT.append(ACCastUtilities.toString(VRBindPathParser.get("1801014",claim)));
            	detailsKeyJT.append("-");
            	detailsKeyJT.append(ACCastUtilities.toString(VRBindPathParser.get("1801018",claim)));
            	
            	Map detailsTmpJT = null;
            	if (detailsMap.containsKey(serviceCodeKindJT)){
            		detailsTmpJT = (Map)detailsMap.get(serviceCodeKindJT);
            	} else {
            		detailsTmpJT = new TreeMap();
            		detailsMap.put(serviceCodeKindJT, detailsTmpJT);
            	}
            	
            	detailsTmpJT.put(detailsKeyJT.toString(), claim);
            	break;
            // [H27.4�@�����Ή�][Shinobu Hitaka] 2015/04/08 add end
                
            //�W�v��񃌃R�[�h
            case 7:
            	typeMap.put(claim.get("701007"), claim);
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
        
        //�W�v��񃌃R�[�h�̏W�v���s��
        Iterator it = typeMap.keySet().iterator();
        while (it.hasNext()){
        	VRMap map = (VRMap)typeMap.get(it.next());
        	parseType(map,(String[])kohiMap.get(String.valueOf(VRBindPathParser.get("701001",map))),manager,detailsMap);
        }
        //��������҉��T�[�r�X��p��񃌃R�[�h�̏W�v���s���B
        for(int i = 0; i < nursingList.size(); i++){
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
    private void parseType(VRMap claim, String[] kohiType,QP001Manager manager,VRMap detailsMap) throws Exception {
        
    	// [2014�N�v�]][Shinobu Hitaka] 2015/04/15 edit begin ���p�ҕ��S�z0�~������\�ɂ���
        //���p�ҕ��S�z��0�~�ȊO�̏ꍇ�A���[�ɏo�͂���B
    	//if(ACCastUtilities.toInt(claim.get("701017"),0) != 0){
        if((zeroPrint == 0 && ACCastUtilities.toInt(claim.get("701017"),0) != 0) || (zeroPrint != 0)){
        // [2014�N�v�]][Shinobu Hitaka] 2015/04/15 edit end
        	
            //�T�[�r�X��ރR�[�h
            String serviceCodeKind = String.valueOf(claim.get("701007"));
            //�T�[�r�X����
            String serviceName = manager.getServiceName(serviceCodeKind);
            
            //���׏�񃌃R�[�h���A�Y���T�[�r�X��ރR�[�h�̏ڍׂ��擾
            Map details = (Map)detailsMap.get(serviceCodeKind);
            
            // [H27.4�@�����Ή�][Shinobu Hitaka] 2015/04/08 edit begin
            //Iterator it = details.keySet().iterator();
            //while(it.hasNext()){
            //	VRMap map = (VRMap)details.get(it.next());
            //	//�W�v��񃌃R�[�h�Ɋ֘A���閾�׏����o�͂���
            //	setServiceData((String)map.get("301019"), 0, map);
            //}
            //
            //���p�ҕ��S0�~�󎚂̏ꍇ�̓T�[�r�X���擪��*��t������
            if (zeroPrint != 0){
            	serviceName = "*" + serviceName;
            }
            //���׏���O�̂���null���肷��
            if(details != null){
	            Iterator it = details.keySet().iterator();
	            while(it.hasNext()){
	            	VRMap map = (VRMap)details.get(it.next());
	            	if ((String)map.get("301019") != null) {
		            	//�W�v��񃌃R�[�h�Ɋ֘A���閾�׏����o�͂���
		            	setServiceData((String)map.get("301019"), 0, map);
	            	} else {
		            	//�W�v��񃌃R�[�h�Ɋ֘A���閾�׏��i�Z���n����j���o�͂���
	            		setServiceData((String)map.get("1801020"), 0, map);
	            	}
	            }
            }
            // [H27.4�@�����Ή�][Shinobu Hitaka] 2015/04/08 edit end
            
            setServiceData(serviceName,ACCastUtilities.toInt(claim.get("701017"),0),claim);
        }
        
        //�o������Ô�p�ҕ��S�z��0�~�ȊO�̏ꍇ�A���[�ɏo�͂���B
        if(ACCastUtilities.toInt(claim.get("701029"),0) != 0){
        	String styleNo = String.valueOf(claim.get("701001"));
        	
        	//�l����܁A��܂̓�A��\�ł���Γ���f�Ô�
        	if("7164,7165,71A3".indexOf(styleNo) != -1){
        		setServiceData("����f�Ô�p�ҕ��S",ACCastUtilities.toInt(claim.get("701029"),0),claim, false);
            //�l����l�A��l�̓�A���ł���΋ً}���{�ݗ×{
        	} else if("7153,7154,7193".indexOf(styleNo) != -1){
        		setServiceData("���莡�Ô�p�ҕ��S",ACCastUtilities.toInt(claim.get("701029"),0),claim, false);
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
        	setServiceData("�H��E���Z��",ACCastUtilities.toInt(claim.get("801021"),0),claim);
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
            setServiceData("�Љ���@�l�y��",(ACCastUtilities.toInt(claim.get("901010"),0)) * -1,claim);
        }
    }
    
    
    /**
     * ���p�ҕ��S�̃T�[�r�X���́A�P�ʁA�񐔁E�����A���z��ݒ肷��B
     * 
     * @param serviceName
     * @param cost
     * @param claim
     * 
     * @throws Exception
     */
    private void setServiceData(String serviceName, int cost,VRMap claim) throws Exception {
    	setServiceData(serviceName, cost, claim, true);
    }
    
    /**
     * ���p�ҕ��S�̃T�[�r�X���̂Ƌ��z��ݒ肷��B
     * @param serviceName
     * @param cost
     * @param isPrint �P�ʐ��A�񐔁E�����̈󎚂����邩���Ȃ����B True:�\������ False:�\�����Ȃ�
     * 
     * @throws Exception
     */
    private void setServiceData(String serviceName, int cost,VRMap claim, boolean isPrint) throws Exception {
        boolean end = true;
        
        
        Integer categoryNo = ACCastUtilities.toInteger(VRBindPathParser.get("CATEGORY_NO", claim));
        int unit = 0;
        int count = 0;
        int etcTotal = 0;
        
        if (isPrint){
	        //���׏�񃌃R�[�h��\�����ނ̒萔���ł���ꍇ
	        if (QkanConstants.CATEGORY_NO_RECORD_DETAILED.equals(categoryNo)){
	        	//�P�ʐ�
	        	unit = ACCastUtilities.toInt(VRBindPathParser.get("301009",claim),0);
	        	//�P�ʐ�0�̏ꍇ�́A�T�[�r�X�P�ʐ����̗p����
	        	if (unit == 0){
	        		unit = ACCastUtilities.toInt(VRBindPathParser.get("301014",claim),0);
	        	}
	        	//�񐔁E����
	        	count = ACCastUtilities.toInt(VRBindPathParser.get("301010",claim),0);
	        	
	        // [H27.4�@�����Ή�][Shinobu Hitaka] 2015/04/08 add begin
	        //���׏��i�Z���n����j���R�[�h��\�����ނ̒萔���ł���ꍇ
	        } else if (QkanConstants.CATEGORY_NO_RECORD_DETAILED_JUSHOTI_TOKUREI.equals(categoryNo)) {
	        	//�P�ʐ�
	        	unit = ACCastUtilities.toInt(VRBindPathParser.get("1801009",claim),0);
	        	//�P�ʐ�0�̏ꍇ�́A�T�[�r�X�P�ʐ����̗p����
	        	if (unit == 0){
	        		unit = ACCastUtilities.toInt(VRBindPathParser.get("1801014",claim),0);
	        	}
	        	//�񐔁E����
	        	count = ACCastUtilities.toInt(VRBindPathParser.get("1801010",claim),0);
	        // [H27.4�@�����Ή�][Shinobu Hitaka] 2015/04/08 add end
	        	
	        //�W�v��񃌃R�[�h��\�����ނ̒萔���ł���ꍇ
	        } else if (QkanConstants.CATEGORY_NO_RECORD_TOTAL.equals(categoryNo)) {
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
	        	//���̑��p�P�ʐ����Z�l
                etcTotal = unit;
	        }
        }
        
        for(int i = 0; i < serviceClaim.length; i++){
            // �T�[�r�X���̋y�ѕ��S�z������̏ꍇ
            if((serviceNames[i] != null) && (serviceName.equals(serviceNames[i])) && serviceUnit[i] == unit){
                serviceClaim[i] += cost;
                serviceUnit[i] = unit;
                serviceCount[i] += count;
                end = false;
                break;                    
            }
            
            if(serviceNames[i] == null){
                serviceNames[i] = serviceName;
                serviceClaim[i] = cost;
                serviceUnit[i] = unit;
                serviceCount[i] = count;
                end = false;
                break;
            }
            
        }
        
        if(end){
            // ���p�ҕ��S�z���O�~�̏ꍇ�͖��׏�񂪐ݒ肳��Ă��邽��
            // �P���͏������čĐݒ肷��B�i���׏��̒P���{�W�v���̒P�������Z������Q�Ή��j
            if (serviceClaim[serviceClaim.length - 1] == 0) {
                serviceUnit[serviceClaim.length - 1] = 0;
            }
            serviceNames[serviceClaim.length - 1] = "���̑�";
            serviceClaim[serviceClaim.length - 1] += cost;
            serviceUnit[serviceClaim.length - 1] += etcTotal;
            serviceCount[serviceClaim.length - 1] = 1;
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
        
        setData(result, "TARGET_DATE", getTargetDate());
        
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

        setData(result, "1601062", get_1601062());
        setData(result, "1601063", get_1601063());
        setData(result, "1601064", get_1601064());
        setData(result, "1601065", get_1601065());
        setData(result, "1601066", get_1601066());
        setData(result, "1601067", get_1601067());
        setData(result, "1601068", get_1601068());
        setData(result, "1601069", get_1601069());
        
        setData(result, "1601070", get_1601070());
        setData(result, "1601071", get_1601071());
        setData(result, "1601072", get_1601072());
        setData(result, "1601073", get_1601073());
        setData(result, "1601074", get_1601074());
        setData(result, "1601075", get_1601075());
        setData(result, "1601076", get_1601076());
        setData(result, "1601077", get_1601077());
        setData(result, "1601078", get_1601078());
        setData(result, "1601079", get_1601079());
        
        setData(result, "1601080", get_1601080());
        setData(result, "1601081", get_1601081());
        setData(result, "1601082", get_1601082());
        setData(result, "1601083", get_1601083());
        setData(result, "1601084", get_1601084());
        setData(result, "1601085", get_1601085());
        setData(result, "1601086", get_1601086());
        setData(result, "1601087", get_1601087());
        setData(result, "1601088", get_1601088());
        setData(result, "1601089", get_1601089());
        
        setData(result, "1601090", get_1601090());
        setData(result, "1601091", get_1601091());
        setData(result, "1601092", get_1601092());
        setData(result, "1601093", get_1601093());
        setData(result, "1601094", get_1601094());
        setData(result, "1601095", get_1601095());
        setData(result, "1601096", get_1601096());
        setData(result, "1601097", get_1601097());

        return result;
    }

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
    	result += get_1601065();
    	result += get_1601069();
    	result += get_1601073();
    	result += get_1601077();
    	result += get_1601081();
    	result += get_1601085();
    	result += get_1601089();
    	result += get_1601093();
    	result += get_1601097();
    	//����ȕ��S��
    	result += get_1601022();
    	result += get_1601024();
    	
    	return result;
    }
    
}
