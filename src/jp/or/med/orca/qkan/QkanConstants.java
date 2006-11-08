/** TODO <HEAD_IKENSYO> */
package jp.or.med.orca.qkan;

import java.awt.Color;

import jp.nichicom.ac.text.ACHashMapFormat;
import jp.nichicom.ac.text.ACNowAgeFormat;
import jp.nichicom.ac.text.ACOneDecimalDoubleFormat;

/**
 * �V�X�e�����ʒ�`�ł��B
 * <p>
 * Copyright (c) 2005 Nippon Computer Corpration. All Rights Reserved.
 * </p>
 * 
 * @author Tozo Tanaka
 * @version 1.0 2006/03/31
 */
public interface QkanConstants {

    // public static final Color FRAME_BACKGROUND = new java.awt.Color(0, 51,
    // 153);

    // �A�C�R��
    /**
     * ���p�����ڍׂ�\���A�C�R���萔�ł��B
     */
    public static final String ICON_PATH_PATIENT_BILL_24 = "jp/or/med/orca/qkan/images/icon/pix24/btn_101.png";
    /**
     * ���Ə������ڍׂ�\���A�C�R���萔�ł��B
     */
    public static final String ICON_PATH_PROVIDER_BILL_24 = "jp/or/med/orca/qkan/images/icon/pix24/btn_102.png";
    /**
     * �ӌ�����\���A�C�R���萔�ł��B
     */
    public static final String ICON_PATH_IKENSHO_24 = "jp/or/med/orca/qkan/images/icon/pix24/btn_103.png";

    // �F�ݒ�
    public static final Color COLOR_TITLE_FOREGROUND = java.awt.Color.white;
    public static final Color COLOR_TOOL_BUTTON_FOREGROUND = java.awt.Color.white;
    public static final Color COLOR_TOOL_BUTTON_BACKGROUND = new java.awt.Color(
            0, 51, 153);

    public static final Color COLOR_BUTTON_YELLOW_FOREGROUND = new java.awt.Color(
            255, 204, 102);
    public static final Color COLOR_BUTTON_ORANGE_FOREGROUND = new java.awt.Color(
            255, 153, 102);
    public static final Color COLOR_BUTTON_GREEN_FOREGROUND = new java.awt.Color(
            153, 204, 0);

    public static final Color COLOR_BORDER_TEXT_FOREGROUND = new java.awt.Color(
            49, 83, 152);
    public static final Color COLOR_MESSAGE_TEXT_FOREGROUND = new java.awt.Color(
            49, 83, 255);
    public static final Color COLOR_MESSAGE_ALART_TEXT_FOREGROUND = new java.awt.Color(
            255, 0, 0);
    public static final Color COLOR_MESSAGE_WARNING_TEXT_FOREGROUND = new java.awt.Color(
            160, 0, 0);

    // public static final Color COLOR_RANGE_PANEL_BACKGROUND = new
    // java.awt.Color(255, 255, 211);

    // public static final Color COLOR_BACK_PANEL_BACKGROUND = new
    // java.awt.Color(204, 204, 255);
    // public static final Color COLOR_BACK_PANEL_FOREGROUND = Color.black;

    // public static final Color COLOR_DOUBLE_BACK_PANEL_BACKGROUND = new
    // Color(0xC5EDC5);

    public static final Color COLOR_PANEL_TITLE_FOREGROUND = java.awt.Color.white;
    public static final Color COLOR_PANEL_TITLE_BACKGROUND = new java.awt.Color(
            0, 51, 153);

    // �t�H�[�}�b�^
    /**
     * 1-�j�A2-���ƕϊ�����t�H�[�}�b�^�ł��B
     */
    public static final ACHashMapFormat FORMAT_SEX = new ACHashMapFormat(
            new String[] { "�j", "��" }, new Integer[] { new Integer(1),
                    new Integer(2) });
    /**
     * ���ݔN��ɕϊ�����t�H�[�}�b�^�ł��B
     */
    public static final ACNowAgeFormat FORMAT_NOW_AGE = new ACNowAgeFormat();

    /**
     * �����_���ʂ܂ŕ\������t�H�[�}�b�^�ł��B
     */
    public static final ACOneDecimalDoubleFormat FORMAT_DOUBLE1 = ACOneDecimalDoubleFormat
            .getInstance();

    // �G�f�B�V����
    public static final int EDITION_DEFAULT = 1; // �f�t�H���g�G�f�B�V����

    // ���ƎҎ��
    public static final int LOGIN_MODE_KYOTAKU_SHIEN = 1; // ����x�����Ǝ�
    public static final int LOGIN_MODE_KYOTAKU_SERVICE = 2; // ����T�[�r�X�񋟋Ǝ�
    public static final int LOGIN_MODE_SHISETSU_SERVICE = 3; // �{�݃T�[�r�X�񋟋Ǝ�

    // PROCESS_MODE(�������[�h)
    public static final int PROCESS_MODE_DELETE = 1; // �폜
    public static final int PROCESS_MODE_SELECT = 2; // ����
    public static final int PROCESS_MODE_UPDATE = 3; // �X�V
    public static final int PROCESS_MODE_INSERT = 4; // �o�^


    // �T�[�r�X�ڍ׎擾
    /**
     * 101-�T�[�r�X�\��S�̂�\���T�[�r�X�ڍ׎擾���[�h�萔�ł��B
     */
    public static final int SERVICE_DETAIL_GET_PLAN = 101;
    /**
     * 102-�T�[�r�X���ёS�̂�\���T�[�r�X�ڍ׎擾���[�h�萔�ł��B
     */
    public static final int SERVICE_DETAIL_GET_RESULT = 102;
    /**
     * 103-�T�[�r�X�\��̌��ԑS�̂�\���T�[�r�X�ڍ׎擾���[�h�萔�ł��B
     */
    public static final int SERVICE_DETAIL_GET_PLAN_OF_MONTHLY_ONLY = 103;
    /**
     * 103-�T�[�r�X�\��̏T�ԑS�̂�\���T�[�r�X�ڍ׎擾���[�h�萔�ł��B
     */
    public static final int SERVICE_DETAIL_GET_PLAN_OF_WEEKLY_ONLY = 104;

    // �T�[�r�X�p�r
    /**
     * 1-�T�[�r�X�p�^�[����\���T�[�r�X�p�r�萔�ł��B
     */
    public static final Integer SERVICE_USE_TYPE_PATTERN = new Integer(1);
    /**
     * 2-�\��i�T�ԁ|�J�n�����j��\���T�[�r�X�p�r�萔�ł��B
     */
    public static final Integer SERVICE_USE_TYPE_PLAN_WEEKLY_DAY = new Integer(
            2);
    /**
     * 3-�\��i�T�ԁ|�J�n���~�j��\���T�[�r�X�p�r�萔�ł��B
     */
    public static final Integer SERVICE_USE_TYPE_PLAN_WEEKLY_FREE_DAY = new Integer(
            3);
    /**
     * 4-�\��i����-�J�n�����j��\���T�[�r�X�p�r�萔�ł��B
     */
    public static final Integer SERVICE_USE_TYPE_PLAN_MONTHLY_DAY = new Integer(
            4);
    /**
     * 5-�\��i����-�J�n���~�j��\���T�[�r�X�p�r�萔�ł��B
     */
    public static final Integer SERVICE_USE_TYPE_PLAN_MONTHLY_FREE_DAY = new Integer(
            5);
    /**
     * 6-���сi�J�n��-���j��\���T�[�r�X�p�r�萔�ł��B
     */
    public static final Integer SERVICE_USE_TYPE_RESULT_MONTHLY_DAY = new Integer(
            6);
    /**
     * 7-���сi�J�n��-�~�j��\���T�[�r�X�p�r�萔�ł��B
     */
    public static final Integer SERVICE_USE_TYPE_RESULT_MONTHLY_FREE_DAY = new Integer(
            7);
    /**
     * 8-���сi�T�ԁ|�J�n�����j��\���T�[�r�X�p�r�萔�ł��B
     */
    public static final Integer SERVICE_USE_TYPE_RESULT_WEEKLY_DAY = new Integer(
            8);
    /**
     * 9-���сi�T�ԁ|�J�n���~�j��\���T�[�r�X�p�r�萔�ł��B
     */
    public static final Integer SERVICE_USE_TYPE_RESULT_WEEKLY_FREE_DAY = new Integer(
            9);

    // �T�[�r�X�p�r��2�̎��̂ݎg�p����WEEK_DAY�t�B�[���h�l
    /**
     * 101-���퐶���ߑO��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_FREE_AM = new Integer(101);
    /**
     * 102-���퐶���ߌ��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_FREE_PM = new Integer(102);
    /**
     * 111-���j�ߑO��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_SUNDAY_AM = new Integer(111);
    /**
     * 112-���j�ߑO��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_MONDAY_AM = new Integer(112);
    /**
     * 113-�Ηj�ߑO��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_TUESDAY_AM = new Integer(113);
    /**
     * 114-���j�ߑO��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_WEDNESDAY_AM = new Integer(114);
    /**
     * 115-�ؗj�ߑO��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_THURSDAY_AM = new Integer(115);
    /**
     * 116-���j�ߑO��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_FRIDAY_AM = new Integer(116);
    /**
     * 117-�y�j�ߑO��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_SATURDAY_AM = new Integer(117);
    /**
     * 121-���j�ߌ��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_SUNDAY_PM = new Integer(121);
    /**
     * 122-���j�ߌ��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_MONDAY_PM = new Integer(122);
    /**
     * 123-�Ηj�ߌ��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_TUESDAY_PM = new Integer(123);
    /**
     * 124-���j�ߌ��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_WEDNESDAY_PM = new Integer(124);
    /**
     * 125-�ؗj�ߌ��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_THURSDAY_PM = new Integer(125);
    /**
     * 126-���j�ߌ��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_FRIDAY_PM = new Integer(126);
    /**
     * 127-�y�j�ߌ��\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_SATURDAY_PM = new Integer(127);

    /**
     * 1-�w��Ȃ���\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_UNKNOWN = new Integer(1);
    /**
     * 37-������\���T�[�r�X�j���萔�ł��B
     */
    public static final Integer SERVICE_WEEK_DAY_FIRST_DAY = new Integer(37);

    
    /**
     * 101-�T�P�ʈȊO�̃T�[�r�X�ɂ�������Ԃ�\���T�[�r�X�ڍג萔�ł��B
     */
    public static final Integer SERVICE_SYSTEM_BIND_PATH_SPAN = new Integer(101);
    
    /**
     * 10-�T�[�r�X�p�^�[���̓����ԍ���\�����l�ł��B
     */
    public static final Integer INTERNAL_SERVICE_PATTERN_NO_BIND_PATH = new Integer(10);
//    /**
//     * 90101-�u���̑��v��\���T�[�r�X��ޒ萔�ł��B
//     */
//    public static final Integer SERVICE_KIND_DETAIL_OTHER = new Integer(90101);
//    /**
//     * 90201-�u��ȓ��퐶����̊����v��\���T�[�r�X��ޒ萔�ł��B
//     */
//    public static final Integer SERVICE_KIND_DETAIL_DAILY_LIFE = new Integer(90201);
    
    /**
     * 1-�u�V�X�e���Ǘ��T�[�r�X�v��\���T�[�r�X��ޒ萔�ł��B
     */
    public static final Integer SERVICE_KIND_DETAIL_SYSTEM_SERVICE = new Integer(
            1);
    
    /**
     * ����{�ݓ����֘A�̃T�[�r�X�R�[�h������킷�T�[�r�X�R�[�h��ޒ萔�ł��B
     */
    public static final String SERVICE_KIND_LIFE_CARE_AT_SPECIAL_FACILITIY = "59";
    
    /**
     * ��������҂ł��邩������킷�T�[�r�X�ڍ׎�ނł��B
     */
    public static final String SERVICE_SYSTEM_KIND_DETAIL_SPECIAL_FACILITIY = "7";
    
    /**
     * ���[�u�����҂ł��邩������킷�T�[�r�X�ڍ׎�ނł��B
     */
    public static final String SERVICE_SYSTEM_KIND_DETAIL_OLD_FACILITIY_USER = "8";
    
    /**
     * �v��P�ʐ�������킷�T�[�r�X�ڍ׎�ނł��B
     */
    public static final String SERVICE_SYSTEM_KIND_DETAIL_PLAN_UNIT = "1001";
    
    /**
     * �T�[�r�X�̒P�Ɖ��Z�t���O������킷�T�[�r�X�ڍ׎�ނł��B
     */
    public static final String SERVICE_SYSTEM_KIND_DETAIL_ADD_TYPE = "9";

    /**
     * �T�[�r�X�p�^�[���̃\�[�g��������킷�T�[�r�X�ڍ׎�ނł��B
     */
    public static final String SERVICE_SYSTEM_KIND_DETAIL_SORT_ORDER = "10";
    
    
    // ����f�Ô��
    /**
     * 1-�T�[�r�X��\������f�Ô���萔�ł��B
     */
    public static final int SPECIAL_CLINIC_TYPE_SERVICE = 1;
    /**
     * 2-���Ǝ� ��\������f�Ô���萔�ł��B
     */
    public static final int SPECIAL_CLINIC_TYPE_PROVIDER = 2;
    /**
     * 3-�X�^�b�t ��\������f�Ô���萔�ł��B
     */
    public static final int SPECIAL_CLINIC_TYPE_STAFF = 3;
    /**
     * 4-������\������f�Ô���萔�ł��B
     */
    public static final int SPECIAL_CLINIC_TYPE_BILL = 4;

    // �ڍ׃}�X�^�`��
    /**
     * 1.�T�[�r�X��\���ڍ׃}�X�^�`���萔�ł��B
     */
    public static final int DETAIL_MASTER_SERVICE = 1;
    /**
     * 2.���Ə���\���ڍ׃}�X�^�`���萔�ł��B
     */
    public static final int DETAIL_MASTER_PROVIDER = 2;
    /**
     * 3.�X�^�b�t��\���ڍ׃}�X�^�`���萔�ł��B
     */
    public static final int DETAIL_MASTER_STAFF = 3;
    /**
     * 4.�����c�a��\���ڍ׃}�X�^�`���萔�ł��B
     */
    public static final int DETAIL_MASTER_CLAIM = 4;

    // �ڍ׃f�[�^�`��
    /**
     * 1�DINTEGER��\���ڍ׃f�[�^�`���萔�ł��B
     */
    public static final int DETAIL_DATA_INTEGER = 1;
    /**
     * 2�DTEXT��\���ڍ׃f�[�^�`���萔�ł��B
     */
    public static final int DETAIL_DATA_STRING = 2;
    /**
     * 3�DTIMESTAMP�\���ڍ׃f�[�^�`���萔�ł��B
     */
    public static final int DETAIL_DATA_DATE = 3;

    // �T�[�r�X�\��E���уt���O
    /**
     * 1.�T�[�r�X�\���\���萔�ł��B
     */
    public static final int PROCESS_TYPE_PLAN = 1;
    /**
     * 2.�T�[�r�X���т�\���萔�ł��B
     */
    public static final int PROCESS_TYPE_RESULT = 2;

    // ���p�E�񋟕[�t���O
    /**
     * 1.���p�[��\���萔�ł��B
     */
    public static final int PRINT_MODE_USE = 1;
    /**
     * 2.���p�[�ʕ\��\���萔�ł��B
     */
    public static final int PRINT_MODE_USE_ANOTHER = 2;
    /**
     * 3.�񋟕[��\���萔�ł��B
     */
    public static final int PRINT_MODE_OFFER = 3;
    /**
     * 4.�񋟕[�ʕ\��\���萔�ł��B
     */
    public static final int PRINT_MODE_OFFER_ANOTHER = 4;

    // ������񒠕[�l�����
    /**
     * 10101-��싋�t���������\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_BENEFIT_BILL = 10101;
    /**
     * 10211-�l����2��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_2 = 10211;
    /**
     * 10212-�l����2-2��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_2_2 = 10212;
    /**
     * 10311-�l����3��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_3 = 10311;
    /**
     * 10312-�l����3-2��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_3_2 = 10312;
    /**
     * 10411-�l����4��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_4 = 10411;
    /**
     * 10412-�l����4��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_4_2 = 10412;
    /**
     * 10511-�l�� ��5��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_5 = 10511;
    /**
     * 10512-�l�� ��5-2��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_5_2 = 10512;
    /**
     * 10611-�l����6��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_6 = 10611;
    /**
     * 10612-�l����6-2��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_6_2 = 10612;
    /**
     * 10613-�l����6-3��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_6_3 = 10613;
    /**
     * 10614-�l����6-4��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_6_4 = 10614;
    /**
     * 10615-�l����6-5��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_6_5 = 10615;
    /**
     * 10616-�l����6-6��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_6_6 = 10616;
    /**
     * 10711-�l����7��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_7 = 10711;
    /**
     * 10712-�l����7-2��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_7_2 = 10712;
    /**
     * 10811-�l����8��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_8 = 10811;
    /**
     * 10812-�l����8��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_8_2 = 10812;
    /**
     * 9-�l����9��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_9 = 10911;
    /**
     * 10-�l����10��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_FORMAT_10 = 11011;
    /**
     * 11-���t�Ǘ��[��������\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_BENEFIT_SUMMARY = 11111;
    /**
     * 12-���t�Ǘ��[����\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_BENEFIT_MANAGEMENT = 11211;
    /**
     * 13-�K��Ō�×{��׏��i�Еہj��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_VISIT_DETAILED_SOCIAL_INSURANCE = 20101;
    /**
     * 14-�K��Ō�×{��׏��i���ہj��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_VISIT_DETAILE_NATIONAL_INSURANCE = 20102;
    /**
     * 15-�K��Ō�×{������i�Еہj��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_VISIT_BILL_SOCIAL_INSURANCE = 20201;
    /**
     * 16-�K��Ō�×{������i���ہj��\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_VISIT_BILL_NATIONAL_INSURANCE = 20202;
    /**
     * 17-���p�Ҍ���������\�����[�̗l���ԍ��萔�ł��B
     */
    public static final int CLAIM_STYLE_BILL_FOR_PATIENT = 30101;

    // �������J�e�S���ԍ�
    /**
     * 1�F��싋�t���������\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_BENEFIT_BILL = new Integer(1);
    /**
     * 2�F��{��񃌃R�[�h��\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_RECORD_BASIC_INFOMATION = new Integer(
            2);
    /**
     * 3�F���׏�񃌃R�[�h��\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_RECORD_DETAILED = new Integer(3);
    /**
     * 4�F�ً}���{�ݗ×{��񃌃R�[�h��\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_RECORD_EMERGENCY_INSTITUTION = new Integer(
            4);
    /**
     * 5�F����f�Ô��񃌃R�[�h��\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_RECORD_SPECIAL_TREATMENT = new Integer(
            5);
    /**
     * 6�F�H����p��񃌃R�[�h��\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_RECORD_MEAT_EXPENSES = new Integer(
            6);
    /**
     * 7�F�W�v��񃌃R�[�h��\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_RECORD_TOTAL = new Integer(7);
    /**
     * 8�F��������҉��T�[�r�X��p��񃌃R�[�h��\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_RECODE_SPECIAL_ENTER_SERVICE = new Integer(
            8);
    /**
     * 9�F�Љ���@�l�y���z��񃌃R�[�h��\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_SOCIAL_WELFARE_REDUCE = new Integer(
            9);
    /**
     * 10�F��싋�t������׏�(����T�[�r�X�v���)����\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_DETAILED_BENEFIT = new Integer(10);
    /**
     * 11�F���t�Ǘ��[�����[����\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_SUMMARY = new Integer(11);
    /**
     * 12�F���t�Ǘ��[����\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_MANAGEMENT = new Integer(12);
    /**
     * 13-�K��Ō�×{��׏���\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_VISIT_DETAILED = new Integer(13);
    /**
     * 14-�K��Ō�×{������i�Еہj��\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_VISIT_BILL_SOCIAL_INSURANCE = new Integer(
            14);
    /**
     * 15-�K��Ō�×{������i���ہj��\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_VISIT_BILL_NATIONAL_INSURANCE = new Integer(
            15);
    /**
     * 16-���p�Ҍ���������\�����ނ̏��萔�ł��B
     */
    public static final Integer CATEGORY_NO_BILL_FOR_PATIENT = new Integer(16);

    // �X�P�W���[���J�����_�ւ̃h���b�v���t���O
    /**
     * 1.�h���b�v�s��\���h���b�v���t���O�萔�ł��B
     */
    public static final int CALENADR_DROP_NONE = 0;
    /**
     * 1.���ԕ\��\���h���b�v���t���O�萔�ł��B
     */
    public static final int CALENADR_DROP_MONTHLY = 1;
    /**
     * 2.�T�ԕ\�̗j��������\���h���b�v���t���O�萔�ł��B
     */
    public static final int CALENADR_DROP_WEEKLY = 2;
    /**
     * 3.���ԕ\�ƏT�ԕ\�̗j��������\���h���b�v���t���O�萔�ł��B
     */
    public static final int CALENADR_DROP_MONTHLY_AND_WEEKLY = 3;
    /**
     * 4.�T�ԕ\�̓��퐶����\���h���b�v���t���O�萔�ł��B
     */
    public static final int CALENADR_DROP_DAILY_LIFE = 4;

}