package jp.or.med.orca.qkan.affair.qs.qs001;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.vr.util.VRMap;

/**
 * �T�[�r�X�\��/���тŎg�p����T�[�r�X������킷�C���^�[�t�F�[�X�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * @author Tozo Tanaka
 * @version 1.0 2006/01/09
 */
public interface QS001Service {
    /**
     * ���������܂��B
     * @throws Exception ������O
     */
    public void initialize() throws Exception;

    /**
     * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
     * @param provider �I�����Ə�
     * @throws Exception ������O
     */
    public void providerSelected(VRMap provider) throws Exception;
    
    /**
     * ���͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��܂��B
     * @return �s�����Ȃ����Map���A�s��������΃��b�Z�[�W�ƂƂ���null��Ԃ��B
     * @throws Exception ������O
     */
    public VRMap getValidData() throws Exception;
    /**
     * ���Ə�����K�v�Ƃ��邩��Ԃ��܂��B
     * @return ���Ə�����K�v�Ƃ��邩
     * @throws Exception ������O
     */
    public boolean isUseProvider() throws Exception;
    
    /**
     * �J�n�������͗p�̃R���{��Ԃ��܂��B
     * @return �J�n�������͗p�̃R���{
     */
    public ACComboBox getBeginTimeCombo() throws Exception;
    
    /**
     * �I���������͗p�̃R���{��Ԃ��܂��B
     * @return �I���������͗p�̃R���{
     */
    public ACComboBox getEndTimeCombo() throws Exception;
}
