
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
 * �쐬��: 2009/02/10  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�����p��ݗ^ (QS001144_H2104)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.component.table.event.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
import jp.nichicom.ac.lib.care.claim.print.schedule.*;
import jp.nichicom.ac.lib.care.claim.servicecode.CareServiceCommon;
import jp.nichicom.ac.lib.care.claim.servicecode.QkanServiceUnitGetter;

/**
 * �T�[�r�X�p�^�[�����\�h�����p��ݗ^(QS001144_H2104) 
 */
public class QS001144_H2104 extends QS001144_H2104Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001144_H2104(){
  }

  //�R���|�[�l���g�C�x���g

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001144_H2104.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
      // ����ʓW�J���̏����ݒ�
      // ���n���Z�e�L�X�g
      getWelfarePoint().setText("");
      getWelfareTokuchiPoint().setText("");
      // ���R�Ԓn�擙���K�͎��Ə����Z�e�L�X�g
      getProviderAddMountainousAreaScalePoint().setText("");
      // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�e�L�X�g
      getProviderAddMountainousAreaRafioPoint().setText("");
      // ���R���{�A�C�e���̐ݒ�
      // ������
      // �R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
      VRMap comboItemMap = new VRHashMap();
      // ���ݒ�
      // �������p��X�g
      // �R�[�h�}�X�^�f�[�^���CODE_ID�F47(�p��j���擾����B
      // �擾�����l���AcomboItemMap�� KEY : 1670101 �� VALUE �Ƃ��Đݒ肷��B
      comboItemMap.setData("1670101", QkanCommon.getArrayFromMasterCode(47,
              "1670101"));
      // ���W�J
      // ���g(this)��comboItemMap�ɐݒ肷��B
      getThis().setModelSource(comboItemMap);
      // �R���{�A�C�e����W�J����B
      getThis().bindModelSource();
      // ���I�����ڂ̏����ݒ�
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
      if (provider != null) {
          // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
          // ������
          // ���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
          VRMap defaultMap = new VRHashMap();
          // ���ݒ�
          // ���W�J
          // ���g(this)��defaultMap�ɐݒ肷��B
          getThis().setSource(defaultMap);
          // �����I�����ڂ�W�J����B
          getThis().bindSource();
          // ���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B
          // ��ʏ�Ԃ�ύX����B
          checkState();
      }
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
      // �p��R���{(welfareTools)�����I���̏ꍇ
      if (!getWelfareTools().isSelected()) {
          // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          // null��Ԃ��B
          return null;
      }
      // �P�ʐ��e�L�X�g(welfarePoint)���󗓂̏ꍇ
      if (ACTextUtilities.isNullText(getWelfarePoint().getText())) {
          // ���e�ڍׂ̕s�����b�Z�[�W��\������B��ID=QS001_ERROR_OF_NO_CONTENT
          QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
          // null��Ԃ��B
          return null;
      }
      // �ԋp�p���R�[�h����A���n���Z�e�L�X�g(welfareTokuchiPoint)��bindPath����������B
      QkanCommon.removeDisabledBindPath(getThis(), data);
      // ���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
      // ���ʒn����Z�e�L�X�g�̗L����Ԃ��`�F�b�N����B
      if(getWelfareTokuchiPoint().isEnabled()){
          String val = getWelfareTokuchiPoint().getText();
          // ���ʒn��ł��菮���e�L�X�g�����͂�������0�����͂���Ă���ꍇ
          if(ACTextUtilities.isNullText(val)||ACCastUtilities.toInt(val)==0){
              // �L�[������Ă���
              data.remove(getWelfareTokuchiPoint().getBindPath());
          }
      }
      
      // ���R�ԓ��n��
      if (getProviderAddMountainousAreaScalePoint().isEnabled()) {
          // ���R�ԉ��Z�e�L�X�g(getProviderAddMountainousAreaScalePoint)���L���̏ꍇ
          String val = getProviderAddMountainousAreaScalePoint().getText();
          if (ACTextUtilities.isNullText(val) || (ACCastUtilities.toInt(val,0) == 0)) {
              // ���R�ԉ��Z�e�L�X�g(getProviderAddMountainousAreaScalePoint)���󗓂��l��0�̏ꍇ
              // �ԋp�p���R�[�h����A���R�ԉ��Z�e�L�X�g(getProviderAddMountainousAreaRafioPoint)��bindPath����������B
              data.remove(getProviderAddMountainousAreaScalePoint().getBindPath());
          }
      }
      
      // ���R�Ԓn�擙�ł̃T�[�r�X��
      String val = getProviderAddMountainousAreaRafioPoint().getText();
      if (ACTextUtilities.isNullText(val) || (ACCastUtilities.toInt(val,0) == 0)) {
          data.remove(getProviderAddMountainousAreaRafioPoint().getBindPath());
      }
      
      return data;
  }

  /**
   * �u���Ə����̕K�v�����擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public boolean isUseProvider() throws Exception{
      // �����Ə���񂪕K�v�ȃT�[�r�X�ł��邩��Ԃ��B
      // true��Ԃ��B
      return true;
  }

  /**
   * �u�J�n�������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
      // ���J�n�������͗p�̃R���{��Ԃ��B
      // �֐��̕Ԃ�l�Ƃ��ĊJ�n���ԃR���{��Ԃ��B
      return null;
  }

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getEndTimeCombo() throws Exception{
      // ���I���������͗p�̃R���{��Ԃ��B
      // �֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
      return null;
  }

  /**
   * �u��ʏ�Ԑ���v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void checkState() throws Exception{
      // ����ʏ�Ԑ��䏈��
      // �����Ə��A��
      // �����ϐ� providerInfoMap �𐶐�����B
      VRMap providerInfoMap = new VRHashMap();
      // ���Ə��p�l�������擾�� providerInfoMap �Ɋi�[����B
      // getSelectedProvider();
      providerInfoMap = getSelectedProvider();
      // providerInfoMap�� null ���`�F�b�N����B
      if (providerInfoMap != null) {
          // null�i���Ə����I���j�������ꍇ
          // �����s��Ȃ��B
          // null�ȊO�������ꍇ
          // providerInfoMap ���� KEY�FSPECIAL_AREA_FLAG �̒l���擾����B
          if (ACCastUtilities.toInt(VRBindPathParser.get("SPECIAL_AREA_FLAG",
                  providerInfoMap)) == 1) {
              // ���o�����l��1�������ꍇ
              // ��ʏ�Ԃ�ύX����
              setState_INVALID_ADD_SPECIAL_AREA();
          } else {
              // 1�ȊO�̏ꍇ
              // ��ʏ�Ԃ�ύX����
              setState_VALID_ADD_SPECIAL_AREA();
          }
          
          // ���R�Ԓn�掖�Ə��ł��邩�̔��胍�W�b�N
          String providerID = ACCastUtilities.toString(((VRMap) providerInfoMap)
                  .getData("PROVIDER_ID"), "");
          // ���\�h�����p��ݗ^
          VRList serviceInfo = QkanCommon.getProviderServiceDetail(
                  getDBManager(), providerID, ACCastUtilities.toInt("16711", 0));

          if(serviceInfo != null && serviceInfo.getData(0) instanceof VRMap) {
              VRMap providerServiceInfo = (VRMap)serviceInfo.getData(0);
              // ���R�Ԓn�擙�̏��K�͎��Ə��ł���ꍇ
              if(CareServiceCommon.isMountainousArea(providerServiceInfo)) {
                  setState_VALID_ADD_MOUNTAINOUS_AREA();
              } else {
                  setState_INVALID_ADD_MOUNTAINOUS_AREA();
              }
              
          } else {
              setState_INVALID_ADD_MOUNTAINOUS_AREA();
              
          }              
          
      }

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

  /**
     * �u���R�Ԓn�擙�P�ʐ������v�Ɋւ��鏈�����s�Ȃ��܂��B
     * 
     * @param checkMode int
     * @throws Exception ������O
     * @return boolean
     */
    public boolean checkMountainousPoint(int checkMode) throws Exception {
        // �����R�Ԓn�擙�̒P�ʐ����A�@�����𒴂��Ă��Ȃ�����������B

        //
        if (getSkipCheckMountainousPoint()) {
            return true;
        }

        // �x����ԕϐ�(warningState)���`���A0�ŏ���������B
        int warningState = 0;

        // ���R�Ԓn�擙���K�͎��Ə����Z�̒��߂���������B
        if (getProviderAddMountainousAreaScalePoint().isEnabled()
                && !ACTextUtilities.isNullText(getWelfarePoint().getText())
                && !ACTextUtilities
                        .isNullText(getProviderAddMountainousAreaScalePoint()
                                .getText())) {
            // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�������łȂ��A����
            // �P�ʐ�(welfarePoint)����ђ��R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̒l����łȂ��ꍇ
            if (ACCastUtilities.toInt(getProviderAddMountainousAreaScalePoint()
                    .getText()) > (ACCastUtilities.toInt(getWelfarePoint()
                    .getText()) * 2 / 3)) {
                // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̒l��
                // �P�ʐ�(welfarePoint)�̒l��3����2�𒴂��Ă���ꍇ
                // �x����ԕϐ�(warningState)��1�����Z����B
                warningState += 1;
            }
        }

        // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�̒��߂���������B
        if (getProviderAddMountainousAreaRafioPoint().isEnabled()
                && !ACTextUtilities.isNullText(getWelfarePoint().getText())
                && !ACTextUtilities
                        .isNullText(getProviderAddMountainousAreaRafioPoint()
                                .getText())) {
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�������łȂ��A����
            // �P�ʐ�(welfarePoint)����ђ��R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̒l����łȂ��ꍇ
            if (ACCastUtilities.toInt(getProviderAddMountainousAreaRafioPoint()
                    .getText()) > (ACCastUtilities.toInt(getWelfarePoint()
                    .getText()) * 1 / 3)) {
                // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̒l��
                // �P�ʐ�(welfarePoint)�̒l��3����1�𒴂��Ă���ꍇ
                // �x����ԕϐ�(warningState)��2�����Z����B
                warningState += 2;
            }
        }

        // ������ߌ������ʂ����ƂɁA�x�����b�Z�[�W����\������B
        // �x����ԕϐ�(warningState)�̒l����ɁA�ȉ��̂Ƃ��蕪�򂷂�B
        switch (warningState) {
        case 0:
            // �l��0�̏ꍇ(�x���Ȃ�)
            // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̃R���e�i������ʏ�\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̃R���e�i������ʏ�\���ɂ���B
            break;
        case 1:
            // �l��1�̏ꍇ(���R�Ԓn�擙���K�͎��Ə����Z�̂݌x��)
            // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̃R���e�i�������x���\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̃R���e�i������ʏ�\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // ����checkMode��0�܂���1�̏ꍇ
            switch (checkMode) {
            case 0:
            case 1:
                // �N���X�ϐ�skipCheckMountainousPoint�ɐ^(true)��������B
                setSkipCheckMountainousPoint(true);
                // ���R�Ԓn�擙���K�͎��Ə����Z�����߂��Ă���|�A�x����\������B
                // �����b�Z�[�WID = QS001_WARNING_OF_MOUNTAINOUS_AREA
                QkanMessageList.getInstance()
                        .QS001_WARNING_OF_MOUNTAINOUS_AREA("���R�Ԓn�擙���K�͎��Ə����Z",
                                "3����2");
                // �N���X�ϐ�skipCheckMountainousPoint�ɋU(false)��������B
                setSkipCheckMountainousPoint(false);
                break;
            }
            // �֐��̖߂�l�Ƃ��ċU��Ԃ��B
            return false;
        case 2:
            // �l��2�̏ꍇ(���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�̂݌x��)
            // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̃R���e�i������ʏ�\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatValid(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̃R���e�i�������x���\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // ����checkMode��0�܂���2�̏ꍇ
            switch (checkMode) {
            case 0:
            case 2:
                // �N���X�ϐ�skipCheckMountainousPoint�ɐ^(true)��������B
                setSkipCheckMountainousPoint(true);
                // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�����߂��Ă���|�A�x����\������B
                // �����b�Z�[�WID = QS001_WARNING_OF_MOUNTAINOUS_AREA
                QkanMessageList.getInstance()
                        .QS001_WARNING_OF_MOUNTAINOUS_AREA("���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z",
                                "3����1");
                // �N���X�ϐ�skipCheckMountainousPoint�ɋU(false)��������B
                setSkipCheckMountainousPoint(false);
                break;
            }
            // �֐��̖߂�l�Ƃ��ċU��Ԃ��B
            return false;
        case 3:
            // �l��3�̏ꍇ(���R�Ԓn�擙���K�͎��Ə����Z�ƒ��R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�Ɍx��)
            // ���R�Ԓn�擙���K�͎��Ə����Z(providerAddMountainousAreaScalePoint)�̃R���e�i�������x���\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaScalePoint(), "0", "0"));
            // ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z(providerAddMountainousAreaRafioPoint)�̃R���e�i�������x���\���ɂ���B
            new ACFollowContainerFormatEventListener(false)
                    .formatWarning(new VRFormatEvent(
                            getProviderAddMountainousAreaRafioPoint(), "0", "0"));
            // �N���X�ϐ�skipCheckMountainousPoint�ɐ^(true)��������B
            setSkipCheckMountainousPoint(true);
            // ���R�Ԓn�擙���K�͎��Ə����Z����ђ��R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�����߂��Ă���|�A�x����\������B
            // �����b�Z�[�WID = QS001_WARNING_OF_MOUNTAINOUS_AREA_ALL
            QkanMessageList.getInstance()
                    .QS001_WARNING_OF_MOUNTAINOUS_AREA_ALL();
            // �N���X�ϐ�skipCheckMountainousPoint�ɋU(false)��������B
            setSkipCheckMountainousPoint(false);
            // �֐��̖߂�l�Ƃ��ċU��Ԃ��B
            return false;
        }
        // �֐��̖߂�l�Ƃ��Đ^��Ԃ��B

        return true;
    }

    /**
     * �u���R�Ԓn��P�ʏ�������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void providerAddMountainousAreaRafioPointFocusLost(FocusEvent e)
            throws Exception {
        // ���P�ʐ��̃t�H�[�J�X�r���C�x���g
        // �֐��u���R�Ԓn�擙�P�ʐ������v��checkMode=2�ŌĂяo���B
        checkMountainousPoint(2);
    }

    /**
     * �u���R�Ԓn��P�ʏ�������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void providerAddMountainousAreaScalePointFocusLost(FocusEvent e)
            throws Exception {
        // ���P�ʐ��̃t�H�[�J�X�r���C�x���g
        // �֐��u���R�Ԓn�擙�P�ʐ������v��checkMode=1�ŌĂяo���B
        checkMountainousPoint(1);
    }

    /**
     * �u���R�Ԓn��P�ʏ�������v�C�x���g�ł��B
     * 
     * @param e �C�x���g���
     * @throws Exception ������O
     */
    protected void welfarePointFocusLost(FocusEvent e) throws Exception {
        // ���P�ʐ��̃t�H�[�J�X�r���C�x���g
        // �֐��u���R�Ԓn�擙�P�ʐ������v��checkMode=0�ŌĂяo���B
        checkMountainousPoint(0);
    }

}
