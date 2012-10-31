
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
 * �v���O���� �l����\�ꃌ�R�[�h (QP001RecordCareSupplyClaim)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;

/**
 * ��싋�t�������񃌃R�[�h
 *
 */
public class QP001RecordCareSupplyClaim extends QP001RecordAbstract {

    // ������񎯕ʔԍ�4��(7111�Œ�)
    private String _101001 = "7111";

    // �T�[�r�X�񋟔N��6��(YYYYMM)
    private String _101002 = "";

    // ���Ə��ԍ�10��
    private String _101003 = "";

    // �ی��E����敪�R�[�h1�� 1-�ی����� 2-�����
    private int _101004 = 0;

    // �@�ʔԍ�2�����ی��������̏ꍇ��0
    private String _101005 = "";

    // �������敪�R�[�h2�� �@�ʔԍ�=0 OR 12��01-����E�{�݃T�[�r�X 02-������x�� �@�ʔԍ�=����ȊO��0�Œ�
    private String _101006 = "";

    // (�T�[�r�X��p)����6��
//    private int _101007 = 0;
    private VRMap _101007 = new VRHashMap();

    // (�T�[�r�X��p)�P�ʐ�11��
    private int _101008 = 0;

    // (�T�[�r�X��p)��p���v12��
    private int _101009 = 0;

    // (�T�[�r�X��p)�ی������z12��
    private int _101010 = 0;

    // (�T�[�r�X��p)������z12��
    private int _101011 = 0;

    // (�T�[�r�X��p)���p�ҕ��S12��
    private int _101012 = 0;

    // (��������҉��T�[�r�X�)����6��
    private int _101013 = 0;

    // (��������Ҍ�T�[�r�X�)���ד���8��
    private int _101014 = 0;

    // (��������҉��T�[�r�X�)��p���v12��
    private int _101015 = 0;

    // (��������҉��T�[�r�X�)���p�ҕ��S12��
    private int _101016 = 0;

    // (��������҉��T�[�r�X�)������z12��
    private int _101017 = 0;

    // (��������҉�T�[�r�X�)�ی������z12��
    private int _101018 = 0;

    protected String getSerialId() {
        return null;
    }

    /**
     * ������񎯕ʔԍ�4��(7111�Œ�)���擾����B
     * 
     * @return
     */
    protected String get_101001() {
        return _101001;
    }

    /**
     * ������񎯕ʔԍ�4��(7111�Œ�)��ݒ肷��B
     * 
     * @param _101001
     */
    protected void set_101001(String _101001) {
        this._101001 = _101001;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)���擾����B
     * 
     * @return
     */
    protected String get_101002() {
        return _101002;
    }

    /**
     * �T�[�r�X�񋟔N��6��(YYYYMM)��ݒ肷��B
     * 
     * @param _101002
     */
    protected void set_101002(String _101002) {
        this._101002 = _101002;
    }

    /**
     * ���Ə��ԍ�10�����擾����B
     * 
     * @return
     */
    protected String get_101003() {
        return _101003;
    }

    /**
     * ���Ə��ԍ�10����ݒ肷��B
     * 
     * @param _101003
     */
    protected void set_101003(String _101003) {
        this._101003 = _101003;
    }

    /**
     * �ی��E����敪�R�[�h1�� 1-�ی����� 2-��������擾����B
     * 
     * @return
     */
    protected int get_101004() {
        return _101004;
    }

    /**
     * �ی��E����敪�R�[�h1�� 1-�ی����� 2-�������ݒ肷��B
     * 
     * @param _101004
     */
    protected void set_101004(int _101004) {
        this._101004 = _101004;
    }

    /**
     * �@�ʔԍ�2�����ی��������̏ꍇ��0���擾����B
     * 
     * @return
     */
    protected String get_101005() {
        return _101005;
    }

    /**
     * �@�ʔԍ�2�����ی��������̏ꍇ��0��ݒ肷��B
     * 
     * @param _101005
     */
    protected void set_101005(String _101005) {
        this._101005 = _101005;
    }

    /**
     * �������敪�R�[�h2�� �@�ʔԍ�=0 OR 12��01-����E�{�݃T�[�r�X 02-������x�� �@�ʔԍ�=����ȊO��0�Œ� ���擾����B
     */
    protected String get_101006() {
        return _101006;
    }

    /**
     * �������敪�R�[�h2�� �@�ʔԍ�=0 OR 12��01-����E�{�݃T�[�r�X 02-������x�� �@�ʔԍ�=����ȊO��0�Œ� ��ݒ肷��B
     * 
     * @param _101006
     */
    protected void set_101006(String _101006) {
        this._101006 = _101006;
    }

    /**
     * (�T�[�r�X��p)����6�����擾����B
     * 
     * @return
     */
    protected int get_101007() {
        return _101007.size();
    }

//    /**
//     * (�T�[�r�X��p)����6����ݒ肷��B
//     * 
//     * @param _101007
//     */
//    protected void set_101007(int _101007) {
//        this._101007 = _101007;
//    }
    /**
     * (�T�[�r�X��p)����6����ݒ肷��B
     * 
     * @param _101007
     */
    // [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
//    protected void set_101007(Object identification, Object patient_id) {
//        _101007.put(String.valueOf(identification) + "-" + String.valueOf(patient_id),null);
//    }
    protected void set_101007(Object identification, Object insurer_id ,Object patient_id) {
        _101007.put(String.valueOf(identification) + "-" + insurer_id + "-" + String.valueOf(patient_id),null);
    }
    // [ID:0000622][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
    /**
     * (�T�[�r�X��p)�P�ʐ�11�����擾����B
     * 
     * @return
     */
    protected int get_101008() {
        return _101008;
    }

    /**
     * (�T�[�r�X��p)�P�ʐ�11����ݒ肷��B
     * 
     * @param _101008
     */
    protected void set_101008(int _101008) {
        this._101008 = _101008;
    }

    /**
     * (�T�[�r�X��p)��p���v12�����擾����B
     * 
     * @return
     */
    protected int get_101009() {
        return _101009;
    }

    /**
     * (�T�[�r�X��p)��p���v12����ݒ肷��B
     * 
     * @param _101009
     */
    protected void set_101009(int _101009) {
        this._101009 = _101009;
    }

    /**
     * (�T�[�r�X��p)�ی������z12�����擾����B
     * 
     * @return
     */
    protected int get_101010() {
        return _101010;
    }

    /**
     * ` (�T�[�r�X��p)�ی������z12����ݒ肷��B
     * 
     * @param _101010
     */
    protected void set_101010(int _101010) {
        this._101010 = _101010;
    }

    /**
     * (�T�[�r�X��p)������z12�����擾����B
     * 
     * @return
     */
    protected int get_101011() {
        return _101011;
    }

    /**
     * (�T�[�r�X��p)������z12����ݒ肷��B
     * 
     * @param _101011
     */
    protected void set_101011(int _101011) {
        this._101011 = _101011;
    }

    /**
     * (�T�[�r�X��p)���p�ҕ��S12�����擾����B
     * 
     * @return
     */
    protected int get_101012() {
        return _101012;
    }

    /**
     * (�T�[�r�X��p)���p�ҕ��S12����ݒ肷��B
     * 
     * @param _101012
     */
    protected void set_101012(int _101012) {
        this._101012 = _101012;
    }

    /**
     * (��������҉��T�[�r�X�)����6�����擾����B
     * 
     * @return
     */
    protected int get_101013() {
        return _101013;
    }

    /**
     * (��������҉��T�[�r�X�)����6����ݒ肷��B
     * 
     * @param _101013
     */
    protected void set_101013(int _101013) {
        this._101013 = _101013;
    }

    /**
     * (��������Ҍ�T�[�r�X�)���ד���8�����擾����B
     * 
     * @return
     */
    protected int get_101014() {
        return _101014;
    }

    /**
     * (��������Ҍ�T�[�r�X�)���ד���8����ݒ肷��B
     * 
     * @param _101014
     */
    protected void set_101014(int _101014) {
        this._101014 = _101014;
    }

    /**
     * (��������҉��T�[�r�X�)��p���v12�����擾����B
     * 
     * @return
     */
    protected int get_101015() {
        return _101015;
    }

    /**
     * (��������҉��T�[�r�X�)��p���v12����ݒ肷��B
     * 
     * @param _101015
     */
    protected void set_101015(int _101015) {
        this._101015 = _101015;
    }

    /**
     * (��������҉��T�[�r�X�)���p�ҕ��S12�����擾����B
     * 
     * @return
     */
    protected int get_101016() {
        return _101016;
    }

    /**
     * (��������҉��T�[�r�X�)���p�ҕ��S12����ݒ肷��B
     * 
     * @param _101016
     */
    protected void set_101016(int _101016) {
        this._101016 = _101016;
    }

    /**
     * (��������҉��T�[�r�X�)������z12�����擾����B
     * 
     * @return
     */
    protected int get_101017() {
        return _101017;
    }

    /**
     * (��������҉��T�[�r�X�)������z12����ݒ肷��B
     * 
     * @param _101017
     */
    protected void set_101017(int _101017) {
        this._101017 = _101017;
    }

    /**
     * (��������҉�T�[�r�X�)�ی������z12�����擾����B
     * 
     * @return
     */
    protected int get_101018() {
        return _101018;
    }

    /**
     * (��������҉�T�[�r�X�)�ی������z12����ݒ肷��B
     * 
     * @param _101018
     */
    protected void set_101018(int _101018) {
        this._101018 = _101018;
    }

    
    public boolean isNew() throws Exception {
        if(ACTextUtilities.isNullText(get_101002())){
            return true;
        }
        return false;
    }
    
    /**
     * �f�[�^�̃p�[�X�����s���܂��B
     * @param base
     * @param recordKubun 1-�ی����� 2-�����
     * @param lawNo �@�ʔԍ��@���ی�������0
     * @param kubun
     * @throws Exception
     */
    protected void parse(VRMap base,int recordKubun, String lawNo, String kubun) throws Exception {

        // ��{��񃌃R�[�h�̒l�����싋�t������̃��C�A�E�g�ɕύX����B
        // �T�[�r�X�񋟔N��
        set_101002(String.valueOf(base.get("201003")));
        // ���Ə��ԍ�
        set_101003(String.valueOf(base.get("201004")));
        // �ی��E����敪���R�[�h
        // 1-�ی����� 2-�����
        set_101004(recordKubun);
        
        // �@�ʔԍ�2�����ی��������̏ꍇ��0
        set_101005(lawNo);

        // �������敪�R�[�h2��
        // �@�ʔԍ�=0 OR 12��01-����E�{�݃T�[�r�X 02-������x�� �@�ʔԍ�=����ȊO��0�Œ�
        // �y����z
        // �ی������A�܂��͌�����Ŗ@�ʔԍ���12(����)�̏ꍇ��01-����E�{�݃T�[�r�X 02-������x��
        // ������Ŗ@�ʔԍ���12�ȊO�̏ꍇ��0�Œ�
        set_101006(kubun);

        // (�T�[�r�X��p)����6����ݒ肷��B
        //set_101007(get_101007() + 1);
        // [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
        //set_101007(base.get("201001"),base.get("201006"));
        set_101007(base.get("201001"), base.get("201005"), base.get("201006"));
        // [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�

        // (�T�[�r�X��p)�P�ʐ�11����ݒ肷��B
        set_101008(get_101008()
                + ACCastUtilities.toInt(base.get("201033"), 0));

        // (�T�[�r�X��p)�ی������z12����ݒ肷��B
        set_101010(get_101010()
                + ACCastUtilities.toInt(base.get("201034"), 0) //(���v��� �ی�)�����z9��
                + ACCastUtilities.toInt(base.get("201036"), 0) //(���v��� �ی�)�ً}���{�ݗ×{����z9��
                + ACCastUtilities.toInt(base.get("201037"), 0));//(���v��� �ی�)����f�Ô���z9��

        // (�T�[�r�X��p)������z12����ݒ肷��B
        set_101011(get_101011()
                + ACCastUtilities.toInt(base.get("201040"), 0) // ����P
                + ACCastUtilities.toInt(base.get("201046"), 0) // ����Q
                + ACCastUtilities.toInt(base.get("201052"), 0) // ����R
                
                + ACCastUtilities.toInt(base.get("201042"), 0) //(���v��� ����1)�ً}���{�ݗ×{����z8��
                + ACCastUtilities.toInt(base.get("201048"), 0) //(���v��� ����2)�ً}���{�ݗ×{����z8��
                + ACCastUtilities.toInt(base.get("201054"), 0) //(���v��� ����3)�ً}���{�ݗ×{����z8��
                
                + ACCastUtilities.toInt(base.get("201043"), 0) //(���v��� ����1)����f�Ô���z8��
                + ACCastUtilities.toInt(base.get("201049"), 0) //(���v��� ����2)����f�Ô���z8��
                + ACCastUtilities.toInt(base.get("201055"), 0) //(���v��� ����3)����f�Ô���z8��
        );

        // (�T�[�r�X��p)���p�ҕ��S12����ݒ肷��B
        set_101012(get_101012()
                + ACCastUtilities.toInt(base.get("201035"), 0) //�ی������p�ҕ��S�z
                + ACCastUtilities.toInt(base.get("201041"), 0) //(���v��� ����1)�{�l���S�z8��
                + ACCastUtilities.toInt(base.get("201047"), 0) //(���v��� ����2)�{�l���S�z8��
                + ACCastUtilities.toInt(base.get("201053"), 0) //(���v��� ����3)�{�l���S�z8��
                );
        
        // (�T�[�r�X��p)��p���v12����ݒ肷��B
        //�ی������z+������z+���p�ҕ��S�z
        set_101009(get_101010() + get_101011() + get_101012());

    }

    /**
     * �W�v��񃌃R�[�h�̏W�v
     * @param base
     * @throws Exception
     */
    protected void parseCategory7(VRMap base) throws Exception {
        // (�ی����o������Ô�)�P�ʐ����v
        set_101008(get_101008()
                + ACCastUtilities.toInt(base.get("701027"), 0)
                );
        //(�ی����o������Ô�)�o������Ô�p�ҕ��S�z8��
        set_101012(get_101012()
                + ACCastUtilities.toInt(base.get("701029"),0)
                + ACCastUtilities.toInt(base.get("701032"),0)
                + ACCastUtilities.toInt(base.get("701035"),0)
                + ACCastUtilities.toInt(base.get("701038"),0)
                );
        
//        //������z
//        set_101011(get_101011()
//                + ACCastUtilities.toInt(base.get("701029"),0)
//                + ACCastUtilities.toInt(base.get("701031"),0)
//                + ACCastUtilities.toInt(base.get("701034"),0)
//                + ACCastUtilities.toInt(base.get("701037"),0)
//                );
        
        // (�T�[�r�X��p)��p���v12����ݒ肷��B
        set_101009(get_101010() + get_101011() + get_101012());
    }
    
    /**
     * ��������ҏ�񃌃R�[�h�̏W�v
     * @param base
     * @param recordKubun
     * @param lawNo
     * @param kubun
     * @throws Exception
     */
    protected void parseCategory8(VRMap base,int recordKubun, String lawNo, String kubun) throws Exception {
      // ��������҉��T�[�r�X��p����
        set_101013(get_101013() + 1);
        // ��������҉��T�[�r�X��p���v
        set_101015(get_101015() + ACCastUtilities.toInt(base.get("801022"), 0));
        // ��������҉��T�[�r�X���p�ҕ��S
        set_101016(get_101016()
                + ACCastUtilities.toInt(base.get("801024"), 0)
                + ACCastUtilities.toInt(base.get("801027"), 0)// ����P
                + ACCastUtilities.toInt(base.get("801030"), 0)// ����Q
                + ACCastUtilities.toInt(base.get("801033"), 0)// ����R
                );
        // ��������҉��T�[�r�X������z
        set_101017(get_101017()
                + ACCastUtilities.toInt(base.get("801026"), 0)// ����P
                + ACCastUtilities.toInt(base.get("801029"), 0)// ����Q
                + ACCastUtilities.toInt(base.get("801032"), 0)// ����R
        );
        // ��������҉��T�[�r�X�ی������z
        set_101018(get_101018()
                + ACCastUtilities.toInt(base.get("801023"),0));
    }
    
    /**
     * �f�[�^�̃p�[�X�����s���܂��B
     * @param base
     * @param recordKubun 1-�ی����� 2-�����
     * @param lawNo �@�ʔԍ��@���ی�������0
     * @param kubun
     * @throws Exception
     */
    protected void parseStyle7(VRMap base,int recordKubun, String lawNo, String kubun) throws Exception {

        // ��{��񃌃R�[�h�̒l�����싋�t������̃��C�A�E�g�ɕύX����B
        // �T�[�r�X�񋟔N��
        set_101002(String.valueOf(base.get("1001004")));
        // ���Ə��ԍ�
        set_101003(String.valueOf(base.get("1001002")));
        // �ی��E����敪���R�[�h
        // 1-�ی����� 2-�����
        set_101004(recordKubun);
        
        // �@�ʔԍ�2�����ی��������̏ꍇ��0
        set_101005(lawNo);

        // �������敪�R�[�h2��
        // �@�ʔԍ�=0 OR 12��01-����E�{�݃T�[�r�X 02-������x�� �@�ʔԍ�=����ȊO��0�Œ�
        // �y����z
        // �ی������A�܂��͌�����Ŗ@�ʔԍ���12(����)�̏ꍇ��01-����E�{�݃T�[�r�X 02-������x��
        // ������Ŗ@�ʔԍ���12�ȊO�̏ꍇ��0�Œ�
        set_101006(kubun);

        // (�T�[�r�X��p)����6����ݒ肷��B
        //set_101007(get_101007() + 1);
        // [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
        //set_101007(base.get("1001001"),base.get("1001007"));
        set_101007(base.get("1001001"), base.get("1001005"), base.get("1001007"));
        // [ID:0000622][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�

        // (�T�[�r�X��p)�P�ʐ�11����ݒ肷��B
        set_101008(get_101008() + ACCastUtilities.toInt(base.get("1001017"), 0));

        // (�T�[�r�X��p)��p���v12����ݒ肷��B
        set_101009(get_101009() + ACCastUtilities.toInt(base.get("1001018"), 0));

        // (�T�[�r�X��p)�ی������z12����ݒ肷��B
        set_101010(get_101010() + ACCastUtilities.toInt(base.get("1001018"), 0));

        // (�T�[�r�X��p)������z12����ݒ肷��B
        set_101011(0);

        // (�T�[�r�X��p)���p�ҕ��S12����ݒ肷��B
        set_101012(0);
    }
    
    
    /**
     * �f�[�^�̃p�[�X�����s���܂��B
     * @param base
     * @param recordKubun 1-�ی����� 2-�����
     * @param lawNo �@�ʔԍ��@���ی�������0
     * @param kubun
     * @throws Exception
     */
    protected void parseKohi(VRMap base,int recordKubun, String lawNo, String kubun,int kohiPosition) throws Exception {

        // �ی��E����敪���R�[�h
        // 1-�ی����� 2-�����
        set_101004(recordKubun);
        // �@�ʔԍ�2�����ی��������̏ꍇ��0
        set_101005(lawNo);
        // �������敪�R�[�h2��
        // �@�ʔԍ�=0 OR 12��01-����E�{�݃T�[�r�X 02-������x�� �@�ʔԍ�=����ȊO��0�Œ�
        // �y����z
        // �ی������A�܂��͌�����Ŗ@�ʔԍ���12(����)�̏ꍇ��01-����E�{�݃T�[�r�X 02-������x��
        // ������Ŗ@�ʔԍ���12�ȊO�̏ꍇ��0�Œ�
        set_101006(kubun);
        
        if(base.containsKey("201001")){
            // (�T�[�r�X��p)����6����ݒ肷��B
            //set_101007(get_101007() + 1);
        	// [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
            //set_101007(base.get("201001"),base.get("201006"));
        	set_101007(base.get("201001"), base.get("201005"), base.get("201006"));
        	// [ID:0000622][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
            // ��{��񃌃R�[�h�̒l�����싋�t������̃��C�A�E�g�ɕύX����B
            // �T�[�r�X�񋟔N��
            set_101002(String.valueOf(base.get("201003")));
            // ���Ə��ԍ�
            set_101003(String.valueOf(base.get("201004")));

            
            // (�T�[�r�X��p)�P�ʐ�11����ݒ肷��B
            set_101008(get_101008()
                    + ACCastUtilities.toInt(base.get("201033"), 0));

            // (�T�[�r�X��p)�ی������z12����ݒ肷��B
            set_101010(get_101010()
                    + ACCastUtilities.toInt(base.get("201034"), 0) //(���v��� �ی�)�����z9��
                    + ACCastUtilities.toInt(base.get("201036"), 0) //(���v��� �ی�)�ً}���{�ݗ×{����z9��
                    + ACCastUtilities.toInt(base.get("201037"), 0));//(���v��� �ی�)����f�Ô���z9��

            

            // (�T�[�r�X��p)������z12����ݒ肷��B
            switch(kohiPosition){
            case 0:
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("201040"), 0) // ����P
                        + ACCastUtilities.toInt(base.get("201042"), 0) //(���v��� ����1)�ً}���{�ݗ×{����z8��
                        + ACCastUtilities.toInt(base.get("201043"), 0) //(���v��� ����1)����f�Ô���z8��
                        );
                // (�T�[�r�X��p)���p�ҕ��S12����ݒ肷��B
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201035"), 0) //�ی������p�ҕ��S�z
                        + ACCastUtilities.toInt(base.get("201041"), 0) //(���v��� ����1)�{�l���S�z8��
                        );
                
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201046"), 0) // ����Q
                        + ACCastUtilities.toInt(base.get("201048"), 0) //(���v��� ����2)�ً}���{�ݗ×{����z8��
                        + ACCastUtilities.toInt(base.get("201049"), 0) //(���v��� ����2)����f�Ô���z8��
                        );
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201052"), 0) // ����R
                        + ACCastUtilities.toInt(base.get("201054"), 0) //(���v��� ����3)�ً}���{�ݗ×{����z8��
                        + ACCastUtilities.toInt(base.get("201055"), 0) //(���v��� ����3)����f�Ô���z8��
                        );
                
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201047"), 0) //(���v��� ����2)�{�l���S�z8��
                        + ACCastUtilities.toInt(base.get("201053"), 0) //(���v��� ����3)�{�l���S�z8��
                        );
                        break;
            case 1:
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("201046"), 0) // ����Q
                        + ACCastUtilities.toInt(base.get("201048"), 0) //(���v��� ����2)�ً}���{�ݗ×{����z8��
                        + ACCastUtilities.toInt(base.get("201049"), 0) //(���v��� ����2)����f�Ô���z8��
                        );
                // (�T�[�r�X��p)���p�ҕ��S12����ݒ肷��B
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201035"), 0) //�ی������p�ҕ��S�z
                        + ACCastUtilities.toInt(base.get("201047"), 0) //(���v��� ����2)�{�l���S�z8��
                        );
                
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201040"), 0) // ����P
                        + ACCastUtilities.toInt(base.get("201042"), 0) //(���v��� ����1)�ً}���{�ݗ×{����z8��
                        + ACCastUtilities.toInt(base.get("201043"), 0) //(���v��� ����1)����f�Ô���z8��
                        );
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201052"), 0) // ����R
                        + ACCastUtilities.toInt(base.get("201054"), 0) //(���v��� ����3)�ً}���{�ݗ×{����z8��
                        + ACCastUtilities.toInt(base.get("201055"), 0) //(���v��� ����3)����f�Ô���z8��
                        );
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201041"), 0) //(���v��� ����1)�{�l���S�z8��
                        + ACCastUtilities.toInt(base.get("201053"), 0) //(���v��� ����3)�{�l���S�z8��
                        );
                        break;
            case 2:
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("201052"), 0) // ����R
                        + ACCastUtilities.toInt(base.get("201054"), 0) //(���v��� ����3)�ً}���{�ݗ×{����z8��
                        + ACCastUtilities.toInt(base.get("201055"), 0) //(���v��� ����3)����f�Ô���z8��
                        );
                // (�T�[�r�X��p)���p�ҕ��S12����ݒ肷��B
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201035"), 0) //�ی������p�ҕ��S�z
                        + ACCastUtilities.toInt(base.get("201053"), 0) //(���v��� ����3)�{�l���S�z8��
                        );
                
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201040"), 0) // ����P
                        + ACCastUtilities.toInt(base.get("201042"), 0) //(���v��� ����1)�ً}���{�ݗ×{����z8��
                        + ACCastUtilities.toInt(base.get("201043"), 0) //(���v��� ����1)����f�Ô���z8��
                        );
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201052"), 0) // ����R
                        + ACCastUtilities.toInt(base.get("201054"), 0) //(���v��� ����3)�ً}���{�ݗ×{����z8��
                        + ACCastUtilities.toInt(base.get("201055"), 0) //(���v��� ����3)����f�Ô���z8��
                        );
                
                set_101012(get_101012()
                        + ACCastUtilities.toInt(base.get("201047"), 0) //(���v��� ����2)�{�l���S�z8��
                        + ACCastUtilities.toInt(base.get("201053"), 0) //(���v��� ����3)�{�l���S�z8��
                        );
                        break;
            }
            

            // (�T�[�r�X��p)��p���v12����ݒ肷��B
            //�ی������z+������z+���p�ҕ��S�z
            set_101009(get_101010() + get_101011() + get_101012());

        }
        
        //�W�v��񃌃R�[�h
        if(base.containsKey("701001")){
            // (�T�[�r�X��p)����6����ݒ肷��B
            //set_101007(get_101007() + 1);
        	// [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
            //set_101007(base.get("701001"),base.get("701006"));
        	set_101007(base.get("701001"), base.get("701005"), base.get("701006"));
        	// [ID:0000622][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�
            // ��{��񃌃R�[�h�̒l�����싋�t������̃��C�A�E�g�ɕύX����B
            // �T�[�r�X�񋟔N��
            set_101002(String.valueOf(base.get("701003")));
            // ���Ə��ԍ�
            set_101003(String.valueOf(base.get("701004")));

            // (�T�[�r�X��p)������z12����ݒ肷��B
            switch(kohiPosition){
            case 0:
                //�P�ʐ�
                set_101008(get_101008()
                        + ACCastUtilities.toInt(base.get("701018"),0)   //����P�P�ʐ�
                        + ACCastUtilities.toInt(base.get("701030"),0)   //(����1���o������Ô�)�P�ʐ����v8��
                        );
                
                
                //��p�z���v==========================
                //�ی����̌���̓K�p�����邩�m�F
                if((ACCastUtilities.toInt(base.get("701019"), 0) + ACCastUtilities.toInt(base.get("701020"), 0)) > 0){
                    //���݂���΁A�ی����̔�p�����Z
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701016"), 0)  //(�ی�)�����z9��
                            + ACCastUtilities.toInt(base.get("701017"), 0)  //(�ی�)���p�ҕ��S�z8��
                            + ACCastUtilities.toInt(base.get("701019"), 0)  //(����1)�����z9��
                            + ACCastUtilities.toInt(base.get("701020"), 0)  //(����1)�{�l���S�z6��
                            + ACCastUtilities.toInt(base.get("701022"), 0)  //(����2)�����z9��
                            + ACCastUtilities.toInt(base.get("701023"), 0)  //(����2)�{�l���S�z6��
                            + ACCastUtilities.toInt(base.get("701025"), 0)  //(����3)�����z9��
                            + ACCastUtilities.toInt(base.get("701026"), 0)  //(����3)�{�l���S�z6��
                            );
                }
                
                //�ی����o������Ô�̌���̓K�p�����邩�m�F
                if((ACCastUtilities.toInt(base.get("701031"), 0) + ACCastUtilities.toInt(base.get("701032"), 0)) > 0){
                    //���݂���Εی����o������Ô�̔�p�����Z
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701028"), 0)  //(�ی����o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701029"), 0)  //(�ی����o������Ô�)�o������Ô�p�ҕ��S�z8��
                            + ACCastUtilities.toInt(base.get("701031"), 0)  //(����1���o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701032"), 0)  //(����1���o������Ô�)�o������Ô�{�l���S�z8��
                            + ACCastUtilities.toInt(base.get("701034"), 0)  //(����2���o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701035"), 0)  //(����2���o������Ô�)�o������Ô�{�l���S�z8��
                            + ACCastUtilities.toInt(base.get("701037"), 0)  //(����3���o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701038"), 0)  //(����3���o������Ô�)�o������Ô�{�l���S�z8��
                            );
                }
                
                //������z==========================================
                // (�T�[�r�X��p)���p�ҕ��S12����ݒ肷��B
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("701019"), 0)  //(����1)�����z9��
                        + ACCastUtilities.toInt(base.get("701031"), 0)  //(����1���o������Ô�)�����z9��
                        );
                        break;
            case 1:
                //�P�ʐ�
                set_101008(get_101008()
                        + ACCastUtilities.toInt(base.get("701021"),0)   //����Q�P�ʐ�
                        + ACCastUtilities.toInt(base.get("701033"),0)   //(����Q���o������Ô�)�P�ʐ����v8��
                        );
                
                
                //��p�z���v==========================
                //�ی����̌���̓K�p�����邩�m�F
                if((ACCastUtilities.toInt(base.get("701022"), 0) + ACCastUtilities.toInt(base.get("701023"), 0)) > 0){
                    //���݂���΁A�ی����̔�p�����Z
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701016"), 0)  //(�ی�)�����z9��
                            + ACCastUtilities.toInt(base.get("701017"), 0)  //(�ی�)���p�ҕ��S�z8��
                            + ACCastUtilities.toInt(base.get("701019"), 0)  //(����1)�����z9��
                            + ACCastUtilities.toInt(base.get("701020"), 0)  //(����1)�{�l���S�z6��
                            + ACCastUtilities.toInt(base.get("701022"), 0)  //(����2)�����z9��
                            + ACCastUtilities.toInt(base.get("701023"), 0)  //(����2)�{�l���S�z6��
                            + ACCastUtilities.toInt(base.get("701025"), 0)  //(����3)�����z9��
                            + ACCastUtilities.toInt(base.get("701026"), 0)  //(����3)�{�l���S�z6��
                            );
                }
                
                //�ی����o������Ô�̌���̓K�p�����邩�m�F
                if((ACCastUtilities.toInt(base.get("701034"), 0) + ACCastUtilities.toInt(base.get("701035"), 0)) > 0){
                    //���݂���Εی����o������Ô�̔�p�����Z
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701028"), 0)  //(�ی����o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701029"), 0)  //(�ی����o������Ô�)�o������Ô�p�ҕ��S�z8��
                            + ACCastUtilities.toInt(base.get("701031"), 0)  //(����1���o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701032"), 0)  //(����1���o������Ô�)�o������Ô�{�l���S�z8��
                            + ACCastUtilities.toInt(base.get("701034"), 0)  //(����2���o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701035"), 0)  //(����2���o������Ô�)�o������Ô�{�l���S�z8��
                            + ACCastUtilities.toInt(base.get("701037"), 0)  //(����3���o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701038"), 0)  //(����3���o������Ô�)�o������Ô�{�l���S�z8��
                            );
                }
                
                //������z==========================================
                // (�T�[�r�X��p)���p�ҕ��S12����ݒ肷��B
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("701022"), 0)  //(����2)�����z9��
                        + ACCastUtilities.toInt(base.get("701034"), 0)  //(����2���o������Ô�)�����z9��
                        );
                        break;
            case 2:
                //�P�ʐ�
                set_101008(get_101008()
                        + ACCastUtilities.toInt(base.get("701024"),0)   //����R�P�ʐ�
                        + ACCastUtilities.toInt(base.get("701036"),0)   //(����R���o������Ô�)�P�ʐ����v8��
                        );
                
                
                //��p�z���v==========================
                //�ی����̌���̓K�p�����邩�m�F
                if((ACCastUtilities.toInt(base.get("701025"), 0) + ACCastUtilities.toInt(base.get("701026"), 0)) > 0){
                    //���݂���΁A�ی����̔�p�����Z
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701016"), 0)  //(�ی�)�����z9��
                            + ACCastUtilities.toInt(base.get("701017"), 0)  //(�ی�)���p�ҕ��S�z8��
                            + ACCastUtilities.toInt(base.get("701019"), 0)  //(����1)�����z9��
                            + ACCastUtilities.toInt(base.get("701020"), 0)  //(����1)�{�l���S�z6��
                            + ACCastUtilities.toInt(base.get("701022"), 0)  //(����2)�����z9��
                            + ACCastUtilities.toInt(base.get("701023"), 0)  //(����2)�{�l���S�z6��
                            + ACCastUtilities.toInt(base.get("701025"), 0)  //(����3)�����z9��
                            + ACCastUtilities.toInt(base.get("701026"), 0)  //(����3)�{�l���S�z6��
                            );
                }
                
                //�ی����o������Ô�̌���̓K�p�����邩�m�F
                if((ACCastUtilities.toInt(base.get("701037"), 0) + ACCastUtilities.toInt(base.get("701038"), 0)) > 0){
                    //���݂���Εی����o������Ô�̔�p�����Z
                    set_101009(get_101009()
                            + ACCastUtilities.toInt(base.get("701028"), 0)  //(�ی����o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701029"), 0)  //(�ی����o������Ô�)�o������Ô�p�ҕ��S�z8��
                            + ACCastUtilities.toInt(base.get("701031"), 0)  //(����1���o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701032"), 0)  //(����1���o������Ô�)�o������Ô�{�l���S�z8��
                            + ACCastUtilities.toInt(base.get("701034"), 0)  //(����2���o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701035"), 0)  //(����2���o������Ô�)�o������Ô�{�l���S�z8��
                            + ACCastUtilities.toInt(base.get("701037"), 0)  //(����3���o������Ô�)�����z9��
                            + ACCastUtilities.toInt(base.get("701038"), 0)  //(����3���o������Ô�)�o������Ô�{�l���S�z8��
                            );
                }
                
                //������z==========================================
                // (�T�[�r�X��p)���p�ҕ��S12����ݒ肷��B
                set_101011(get_101011()
                        + ACCastUtilities.toInt(base.get("701025"), 0)  //(����3)�����z9��
                        + ACCastUtilities.toInt(base.get("701037"), 0)  //(����3���o������Ô�)�����z9��
                        );
                        break;
            }
        }
        
        if(base.containsKey("801001")){
            // ��������҉��T�[�r�X��p����
            set_101013(get_101013() + 1);
            // ��������҉��T�[�r�X��p���v
            set_101015(get_101015() + ACCastUtilities.toInt(base.get("801022"), 0));
            // ��������҉��T�[�r�X���p�ҕ��S
            set_101016(get_101016()
                    + ACCastUtilities.toInt(base.get("801024"), 0)
                    );
            // ��������҉��T�[�r�X������z
            set_101017(get_101017()
                    + ACCastUtilities.toInt(base.get("801026"), 0)// ����P
                    + ACCastUtilities.toInt(base.get("801029"), 0)// ����Q
                    + ACCastUtilities.toInt(base.get("801032"), 0)// ����R
            );
            set_101018(get_101018()
                    + ACCastUtilities.toInt(base.get("801023"),0));
            
            // (�T�[�r�X��p)��p���v12����ݒ肷��B
            //�ی������z+������z+���p�ҕ��S�z
            set_101009(get_101010() + get_101011() + get_101012());
        }
        
        if(base.containsKey("1001004")){
            // ��{��񃌃R�[�h�̒l�����싋�t������̃��C�A�E�g�ɕύX����B
            // �T�[�r�X�񋟔N��
            set_101002(String.valueOf(base.get("1001004")));
            // ���Ə��ԍ�
            set_101003(String.valueOf(base.get("1001002")));

            // (�T�[�r�X��p)����6����ݒ肷��B
            //set_101007(get_101007() + 1);
            // [ID:0000622][Shin Fujihara] 2010/11 edit begin 2010�N�x�Ή�
            //set_101007(base.get("1001001"),base.get("1001007"));
            set_101007(base.get("1001001"), base.get("1001005"), base.get("1001007"));
            // [ID:0000622][Shin Fujihara] 2010/11 edit end 2010�N�x�Ή�

            // (�T�[�r�X��p)�P�ʐ�11����ݒ肷��B
            set_101008(get_101008() + ACCastUtilities.toInt(base.get("1001017"), 0));

            // (�T�[�r�X��p)��p���v12����ݒ肷��B
            set_101009(get_101009() + ACCastUtilities.toInt(base.get("1001018"), 0));

            // (�T�[�r�X��p)�ی������z12����ݒ肷��B
            set_101010(0);

            // (�T�[�r�X��p)������z12����ݒ肷��B
            set_101011(get_101011() +  + ACCastUtilities.toInt(base.get("1001018"), 0));

            // (�T�[�r�X��p)���p�ҕ��S12����ݒ肷��B
            set_101012(0);
            
            // (�T�[�r�X��p)��p���v12����ݒ肷��B
            //�ی������z+������z+���p�ҕ��S�z
            set_101009(get_101010() + get_101011() + get_101012());
        }

    }
    
    /**
     * �ێ����Ă���f�[�^���}�b�v�ɕϊ�����B
     * @return
     * @throws Exception
     */
    protected VRMap getRecord() throws Exception {
        VRMap result = new VRHashMap();
        
        putData(result, "101001", get_101001());
        putData(result, "101002", get_101002());
        putData(result, "101003", get_101003());
        putData(result, "101004", get_101004());
        putData(result, "101005", get_101005());
        putData(result, "101006", get_101006());
        putData(result, "101007", get_101007());
        putData(result, "101008", get_101008());
        putData(result, "101009", get_101009());
        
        putData(result, "101010", get_101010());
        putData(result, "101011", get_101011());
        putData(result, "101012", get_101012());
        putData(result, "101013", get_101013());
        putData(result, "101014", get_101014());
        putData(result, "101015", get_101015());
        putData(result, "101016", get_101016());
        putData(result, "101017", get_101017());
        putData(result, "101018", get_101018());
        
        result.put("CATEGORY_NO", QkanConstants.CATEGORY_NO_BENEFIT_BILL);
        
        return result;
    }
    
    private void putData(VRMap map, String key, int value) throws Exception {
        putData(map,key,String.valueOf(value));
    }
    
    private void putData(VRMap map, String key, String value) throws Exception {
        map.put(key,value);
    }
    
}
