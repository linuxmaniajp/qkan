
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
 * �J����: ����@��F
 * �쐬��: 2009/02/09  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���F�m�ǑΉ������������ (QS001126_H2104)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * �T�[�r�X�p�^�[���F�m�ǑΉ������������i�Z�����p�ȊO�j(QS001126_H2104) 
 */
public class QS001126_H2104 extends QS001126_H2104Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001126_H2104(){
  }

  //�R���|�[�l���g�C�x���g

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001126_H2104.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
      // ����ʓW�J���̏����ݒ�
      // ���R���{�A�C�e���̐ݒ�
      // ������
      // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
      VRMap comboItemMap = new VRHashMap();
      // ���ݒ�
      // ���W�J
      // ���g(this)��comboItemMap�ɐݒ肷��B
      getThis().setModelSource(comboItemMap);
      // �R���{�A�C�e����W�J����B
      getThis().bindModelSource();
      // ���I�����ڂ̏����ݒ�
      QkanCommon.selectFirstRadioItem(getThis());
      // ������
      // �����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
      VRMap defaultMap = new VRHashMap();
      // ���ݒ�
      // ���W�J
      // ���g(this)��defaultMap�ɐݒ肷��B
      getThis().setSource(defaultMap);
      // �����I�����ڂ�W�J����B
      getThis().bindSource();


  }

  /**
   * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void providerSelected(VRMap provider) throws Exception{
      // �����Ə��R���{�ύX���ɌĂԊ֐�
      // �I�����Ə����null�łȂ��ꍇ
      // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
      // ������
      // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
      VRMap defaultMap = new VRHashMap();
      // ���ݒ�
      // �l�����Z
      Object obj;
      obj = VRBindPathParser.get("1320102", provider);
      if (obj != null) {
          // ���Ə��o�^�̌��Z���ڂɍ��킹�����l�𒲐�
          switch (ACCastUtilities.toInt(obj)) {
          case 1: // �Ȃ��������ꍇ
              VRBindPathParser.set("1320105", defaultMap, new Integer(1));
              break;
          case 2: // ���]�Ǝ҂������ꍇ
              VRBindPathParser.set("1320105", defaultMap, new Integer(3));
              break;
          }
      }
      // ��ԋΖ������
      VRBindPathParser.set("1320106", defaultMap, VRBindPathParser.get(
              "1320103", provider));
      // ��ØA�g�̐����Z
      VRBindPathParser.set("1320107", defaultMap, VRBindPathParser.get(
              "1320104", provider));
      
      
      // ��ԃP�A���Z
      obj = VRBindPathParser.get("1320105", provider);
      if (obj != null) {
          VRBindPathParser.set("1320108", defaultMap, obj);
      }
      //��N���F�m�Ǘ��p�Ҏ�����Z�i���Ə��p�l���jKEY�F1320106�̒l���`�F�b�N����B
      obj = VRBindPathParser.get("1320106", provider);
      switch (ACCastUtilities.toInt(obj,0)) {
      //�l�����̂����ꂩ�������ꍇ
      case 2:
          //2�i����j
          //�L���ɂ���B
          setState_VALID_YOUNG_DEMENTIA_PATINET();
          break;
      default:
          //�l����L�ȊO�������ꍇ
          //�����ɂ���B
          setState_INVALID_YOUNG_DEMENTIA_PATINET();
          break;
      }
      //���defaultMap�� KEY�F1320109 VALUE�F1�i�Ȃ��j��ݒ肷��B
      VRBindPathParser.set("1320109", defaultMap, new Integer(1));   

      //�F�m�ǐ��P�A���Z�i���Ə��p�l���jKEY�F1320107�̒l���`�F�b�N����B
      obj = VRBindPathParser.get("1320107", provider);
      switch (ACCastUtilities.toInt(obj,0)) {
      //�l�����̂����ꂩ�������ꍇ
      case 2:
          //2�i���ZI�j
      case 3:
          //3�i���ZII�j
          //�L���ɂ���B
          setState_VALID_DEMENTIA_PRO_CARE();
          break;
      default:
          //�l����L�ȊO�������ꍇ
          //�����ɂ���B
          setState_INVALID_DEMENTIA_PRO_CARE();
          break;
      }
      //���defaultMap�� KEY�F1320110 VALUE�F1�i�Ȃ��j��ݒ肷��B
      VRBindPathParser.set("1320110", defaultMap, new Integer(1));   
      
      //�T�[�r�X�񋟑̐��������Z
      obj = VRBindPathParser.get("1320108", provider);
      if (obj != null) {
          VRBindPathParser.set("1320111", defaultMap, obj);
      }      

//      // �Ŏ������Z
//      switch (ACCastUtilities.toInt(VRBindPathParser.get("1320109", provider), 0)) {
//      case 2:
//          // �u����v�̏ꍇ
//          // �L���ɂ���B
//          setState_VALID_WATCH_KAIGO();
//          break;
//      default:
//          // �u�Ȃ��v�̏ꍇ
//          // �����ɂ���B
//          setState_INVALID_WATCH_KAIGO();
//          break;
//      }
      
      // ���W�J
      // ���g(this)��defaultMap�ɐݒ肷��B
      getThis().setSource(defaultMap);
      // �����I�����ڂ�W�J����B
      getThis().bindSource();
      // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

  }

  /**
   * �u���͓��e�̕s���������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public VRMap getValidData() throws Exception{
      // �����͓��e�ɕs�����Ȃ������`�F�b�N���A�T�[�r�X�f�[�^��Ԃ��B
      // ���ԋp�p�̃��R�[�h(data)�𐶐�
      VRMap data = new VRHashMap();
      // ���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
      getThis().setSource(data);
      // ���g(this)��applySource���Ăяo���ăf�[�^�����W����B
      getThis().applySource();
      // ���ԋp�p���R�[�h����s�v�ȃL�[������
      QkanCommon.removeDisabledBindPath(getThis(), data);
      // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
      return data;
  }

  /**
   * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean isUseProvider() throws Exception{
    // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
    // �@true��Ԃ��B
return true;
  }

  /**
   * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
    // ���J�n�������͗p�̃R���{��Ԃ��B
    // �@�֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
return null;
  }

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ���I���������͗p�̃R���{��Ԃ��B
    // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
return null;
  }


  /**
   * �u�T�[�r�X�@�����敪�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   *
   * @throws Exception ������O
   * @return int
   */
  public int getServiceLowVersion() throws Exception {
      //�����̃T�[�r�X�p�l���������T�[�r�X�̖@�����敪(M_DETAIL.SYSTEM_BIND_PATH=14)��Ԃ��B 
      //QkanConstants.SERVICE_LOW_VERSION_H2104 ��Ԃ��B
      return QkanConstants.SERVICE_LOW_VERSION_H2104;
  }
}
