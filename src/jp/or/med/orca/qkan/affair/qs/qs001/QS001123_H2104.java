
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
 * �v���O���� �T�[�r�X�p�^�[����ԑΉ��^�K���� (QS001123_H2104)
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

/**
 * �T�[�r�X�p�^�[����ԑΉ��^�K����(QS001123_H2104) 
 */
public class QS001123_H2104 extends QS001123_H2104Event {
  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001123_H2104(){
  }

  //�R���|�[�l���g�C�x���g

  /**
   * �u�{�݋敪�ւ̘A���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void providerDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // ���{�݋敪�̏�Ԃɉ����Ă��̑��̍��ڂ̗L����Ԃ�؂�ւ���B
      switch(getProviderDivisionRadio().getSelectedIndex()){
      case 1:
          //I�^
          setState_FACILITY_STATE_1();
          //�������^�������ꍇ�͑Ή��l���𖳌��ɂ���B
          if(getServiceDivisionRadioItem1().isSelected()){
              setState_INVALID_PERSONS();
          }
          break;
      case 2:
          //II�^
          setState_FACILITY_STATE_2();
          break;
      }

  }

  /**
   * �u�T�[�r�X�敪�ւ̘A���v�C�x���g�ł��B
   * @param e �C�x���g���
   * @throws Exception ������O
   */
  protected void serviceDivisionRadioSelectionChanged(ListSelectionEvent e) throws Exception{
    // ���T�[�r�X�敪�̏�Ԃɉ����đΉ��l���̗L����Ԃ�؂�ւ���B
      switch(getServiceDivisionRadio().getSelectedIndex()){
      case 1:
          //�������^
          setState_INVALID_PERSONS();
          break;
      case 2:
          //�����Ή��^
          setState_VALID_PERSONS();
          break;
      }
      
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //param�ɓn��p�����^���l�߂Ď��s���邱�ƂŁA�ȈՃf�o�b�O���\�ł��B
    ACFrame.debugStart(new ACAffairInfo(QS001123_H2104.class.getName(), param));
  }

  //�����֐�

  /**
   * �u�������v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void initialize() throws Exception{
    // ����ʓW�J���̏����ݒ�
    // ���R���{�A�C�e���̐ݒ�
    // �@������
    // �@�@�R���{�A�C�e���ݒ�p�̃��R�[�h comboItemMap �𐶐�����B
    VRMap comboItemMap = new VRHashMap();
    // �@���ݒ�
    // �s�����Ǝ����ZI
    comboItemMap.setData("1710109", QkanCommon.getArrayFromMasterCode(276,
            "1710109"));
    // �s�����Ǝ����ZII
    comboItemMap.setData("1710110", QkanCommon.getArrayFromMasterCode(277,
            "1710110"));
    // ���J�n����
    // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
    // �擾�����l���AcomboItemMap�� KEY : 3 �� VALUE �Ƃ��Đݒ肷��B
    comboItemMap.setData("3", QkanCommon.getArrayFromMasterCode(23, "3"));
    // ���I������
    // �R�[�h�}�X�^�f�[�^���CODE_ID�F23�i�����E�j���̑I�� / ����(�J�n)�j���擾����B
    // �擾�����l���AcomboItemMap�� KEY : 4 �� VALUE �Ƃ��Đݒ肷��B
    comboItemMap.setData("4", QkanCommon.getArrayFromMasterCode(23, "4"));
    // �@���W�J
    // �@�@���g(this)��comboItemMap�ɐݒ肷��B
    getThis().setModelSource(comboItemMap);
    // �@�@�R���{�A�C�e����W�J����B
    getThis().bindModelSource();
    // ���I�����ڂ̏����ݒ�
    QkanCommon.selectFirstRadioItem(getThis());
    // �@������
    // �@�@�����I��ݒ�p�̃��R�[�h defaultMap �𐶐�����B
    VRMap defaultMap = new VRHashMap();
    // �@���ݒ�
    // �@���W�J
    // �@�@���g(this)��defaultMap�ɐݒ肷��B
    getThis().setSource(defaultMap);
    // �@�@�����I�����ڂ�W�J����B
    getThis().bindSource();

  }

  /**
   * �u���Ə��R���{�ύX���֐��v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public void providerSelected(VRMap provider) throws Exception{
      // �����Ə��R���{�ύX���ɌĂԊ֐�
      // �@�I�����Ə����null�łȂ��ꍇ
      // �@�@���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��̒l��ݒ肷��B
      // �@�@�@������
      // �@�@�@�@���Ə��A���p�̃��R�[�h defaultMap �𐶐�����B
      VRMap defaultMap = new VRHashMap();
      // �@�@�@���ݒ�
      //�{�݋敪
      VRBindPathParser.set("1710101", defaultMap,VRBindPathParser.get("1710101", provider));
      
      Object obj;
      


      // 24���Ԓʕ�Ή����Z
      switch (ACCastUtilities.toInt(VRBindPathParser.get("1710103", provider), 0)) {
      case 2:
          // �u����v�̏ꍇ
          // �L���ɂ���B
          setState_VALID_24MESSAGE();
          VRBindPathParser.set("1710107", defaultMap, new Integer(2));
          break;
      default:
          // �u�Ȃ��v�̏ꍇ
          // �����ɂ���B
          setState_INVALID_24MESSAGE();
          VRBindPathParser.set("1710107", defaultMap, new Integer(1));
          break;
      }
      
      //�T�[�r�X�񋟑̐��������Z
      obj = VRBindPathParser.get("1710104", provider);
      if (obj != null) {
          VRBindPathParser.set("1710108", defaultMap, obj);
      }
      
      //�s�����Ǝ����ZI�i���Ə��p�l���jKEY�F1710105�̒l���`�F�b�N����B
      obj = VRBindPathParser.get("1710105", provider);
      switch (ACCastUtilities.toInt(obj,0)) {
      //�l�����̂����ꂩ�������ꍇ
      case 2:
          //2�i�s�����Ǝ����Z�P�j
      case 3:
          //3�i�s�����Ǝ����Z�Q�j
      case 4:
          //4�i�s�����Ǝ����Z�R�j
      case 5:
          //5�i�s�����Ǝ����Z�S�j
      case 6:
          //6�i�s�����Ǝ����Z�T�j
      case 7:
          //7�i�s�����Ǝ����Z�U�j
          //defaultMap�� KEY�F1710109 VALUE�F���Ə��̒l��ݒ肷��B
          VRBindPathParser.set("1710109", defaultMap, obj);   
          break;
      default:
          //�l����L�ȊO�������ꍇ
          //defaultMap�� KEY�F1710109 VALUE�F1�i�Ȃ��j��ݒ肷��B
          VRBindPathParser.set("1710109", defaultMap, new Integer(1));   
          break;
      }

      //�s�����Ǝ����ZII�i���Ə��p�l���jKEY�F1710106�̒l���`�F�b�N����B
      obj = VRBindPathParser.get("1710106", provider);
      switch (ACCastUtilities.toInt(obj,0)) {
      //�l�����̂����ꂩ�������ꍇ
      case 2:
          //2�i�s�����Ǝ����Z�P�j
      case 3:
          //3�i�s�����Ǝ����Z�Q�j
      case 4:
          //4�i�s�����Ǝ����Z�R�j
      case 5:
          //5�i�s�����Ǝ����Z�S�j
      case 6:
          //6�i�s�����Ǝ����Z�T�j
      case 7:
          //7�i�s�����Ǝ����Z�U�j
          //defaultMap�� KEY�F1710110 VALUE�F���Ə��̒l��ݒ肷��B
          VRBindPathParser.set("1710110", defaultMap, obj);   
          break;
      default:
          //�l����L�ȊO�������ꍇ
          //defaultMap�� KEY�F1710110 VALUE�F1�i�Ȃ��j��ݒ肷��B
          VRBindPathParser.set("1710110", defaultMap, new Integer(1));   
          break;
      }
      
       // �@�@�@���W�J
      // �@�@�@�@���g(this)��defaultMap�ɐݒ肷��B
      getThis().setSource(defaultMap);
      // �@�@�@�@�����I�����ڂ�W�J����B
      getThis().bindSource();
      // �@�@���ȉ��̓��e�ڍ׍��ڂ́A�I�����Ə��́u�Ȃ��v�u����v�ɂ���āA����/�L����؂�ւ���B

      //��{��ԖK�� I �s�����Ǝ����Z�����I���̏ꍇ�́A�ŏ��̍���(�Ȃ�)��I������B
      if(getBaseMunicipalityAdd().getSelectedIndex()<0 && getBaseMunicipalityAdd().getItemCount()>0){
          getBaseMunicipalityAdd().setSelectedIndex(0);
      }
      //��{��ԖK�� II �s�����Ǝ����Z�����I���̏ꍇ�́A�ŏ��̍���(�Ȃ�)��I������B
      if(getServiceMunicipalityAdd().getSelectedIndex()<0 && getServiceMunicipalityAdd().getItemCount()>0){
          getServiceMunicipalityAdd().setSelectedIndex(0);
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
      // �@���g(this)�̃\�[�X�Ƃ��Đ������R�[�h��ݒ肷��B
      getThis().setSource(data);
      // �@���g(this)��applySource���Ăяo���ăf�[�^�����W����B
      getThis().applySource();
      // ���ԋp�p���R�[�h����s�v�ȃL�[������
      QkanCommon.removeDisabledBindPath(getThis(), data);
      // �@���Ȃ���Εԋp�p���R�[�h(data)��Ԃ��B
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
return getYakanHoumonKaigoBeginTime();
  }

  /**
   * �u�I���������͗p�̃R���{�擾�v�Ɋւ��鏈�����s�Ȃ��܂��B
   * @throws Exception ������O
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ���I���������͗p�̃R���{��Ԃ��B
    // �@�֐��̕Ԃ�l�Ƃ��ďI�����ԃR���{��Ԃ��B
return getYakanHoumonKaigoEndTime();
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
