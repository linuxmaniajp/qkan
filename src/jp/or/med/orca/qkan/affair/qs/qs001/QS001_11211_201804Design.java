
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
 * �쐬��: 2018/02/04  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K�������� (QS001_11211_201804)
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
/**
 * �T�[�r�X�p�^�[���K���������ʍ��ڃf�U�C��(QS001_11211_201804) 
 */
public class QS001_11211_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel homonNyuyokuPatterns;

  private ACValueArrayRadioButtonGroup homonNyuyokuClass;

  private ACLabelContainer homonNyuyokuClassContainer;

  private ACListModelAdapter homonNyuyokuClassModel;

  private ACRadioButtonItem homonNyuyokuClassDouble;

  private ACRadioButtonItem homonNyuyokuClassSingle;

  private ACValueArrayRadioButtonGroup homonNyuyokuPartsRadio;

  private ACLabelContainer homonNyuyokuPartsRadioContainer;

  private ACListModelAdapter homonNyuyokuPartsRadioModel;

  private ACRadioButtonItem homonNyuyokuPartsRadioItem1;

  private ACRadioButtonItem homonNyuyokuPartsRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

  private ACRadioButtonItem houmonNeededRadioItem3;

  private ACBackLabelContainer homonNyuyokuTimeContainer;

  private ACTimeComboBox homonNyuyokuBeginTime;

  private ACLabelContainer homonNyuyokuBeginTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuBeginTimeModel;

  private ACTimeComboBox homonNyuyokuEndTime;

  private ACLabelContainer homonNyuyokuEndTimeContainer;

  private ACComboBoxModelAdapter homonNyuyokuEndTimeModel;

  //getter

  /**
   * �K��������p�^�[���̈���擾���܂��B
   * @return �K��������p�^�[���̈�
   */
  public ACPanel getHomonNyuyokuPatterns(){
    if(homonNyuyokuPatterns==null){

      homonNyuyokuPatterns = new ACPanel();

      homonNyuyokuPatterns.setFollowChildEnabled(true);

      addHomonNyuyokuPatterns();
    }
    return homonNyuyokuPatterns;

  }

  /**
   * �K��҂̎�ʃ��W�I�O���[�v���擾���܂��B
   * @return �K��҂̎�ʃ��W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getHomonNyuyokuClass(){
    if(homonNyuyokuClass==null){

      homonNyuyokuClass = new ACValueArrayRadioButtonGroup();

      getHomonNyuyokuClassContainer().setText("�K��҂̐l��");

      homonNyuyokuClass.setBindPath("1120103");

      homonNyuyokuClass.setUseClearButton(false);

      homonNyuyokuClass.setModel(getHomonNyuyokuClassModel());

      homonNyuyokuClass.setValues(new int[]{1,2});

      addHomonNyuyokuClass();
    }
    return homonNyuyokuClass;

  }

  /**
   * �K��҂̎�ʃ��W�I�O���[�v�R���e�i���擾���܂��B
   * @return �K��҂̎�ʃ��W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuClassContainer(){
    if(homonNyuyokuClassContainer==null){
      homonNyuyokuClassContainer = new ACLabelContainer();
      homonNyuyokuClassContainer.setFollowChildEnabled(true);
      homonNyuyokuClassContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuClassContainer.add(getHomonNyuyokuClass(), null);
    }
    return homonNyuyokuClassContainer;
  }

  /**
   * �K��҂̎�ʃ��W�I�O���[�v���f�����擾���܂��B
   * @return �K��҂̎�ʃ��W�I�O���[�v���f��
   */
  protected ACListModelAdapter getHomonNyuyokuClassModel(){
    if(homonNyuyokuClassModel==null){
      homonNyuyokuClassModel = new ACListModelAdapter();
      addHomonNyuyokuClassModel();
    }
    return homonNyuyokuClassModel;
  }

  /**
   * �Ō�E��1�l�{���E��2�l���擾���܂��B
   * @return �Ō�E��1�l�{���E��2�l
   */
  public ACRadioButtonItem getHomonNyuyokuClassDouble(){
    if(homonNyuyokuClassDouble==null){

      homonNyuyokuClassDouble = new ACRadioButtonItem();

      homonNyuyokuClassDouble.setText("�Ō�E��1�l�y�щ��E��2�l");

      homonNyuyokuClassDouble.setGroup(getHomonNyuyokuClass());

      homonNyuyokuClassDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHomonNyuyokuClassDouble();
    }
    return homonNyuyokuClassDouble;

  }

  /**
   * ���E��3�l���擾���܂��B
   * @return ���E��3�l
   */
  public ACRadioButtonItem getHomonNyuyokuClassSingle(){
    if(homonNyuyokuClassSingle==null){

      homonNyuyokuClassSingle = new ACRadioButtonItem();

      homonNyuyokuClassSingle.setText("���E��3�l");

      homonNyuyokuClassSingle.setGroup(getHomonNyuyokuClass());

      homonNyuyokuClassSingle.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuClassSingle();
    }
    return homonNyuyokuClassSingle;

  }

  /**
   * �K��������敪���W�I�O���[�v���擾���܂��B
   * @return �K��������敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getHomonNyuyokuPartsRadio(){
    if(homonNyuyokuPartsRadio==null){

      homonNyuyokuPartsRadio = new ACValueArrayRadioButtonGroup();

      getHomonNyuyokuPartsRadioContainer().setText("�������敪");

      homonNyuyokuPartsRadio.setBindPath("1120104");

      homonNyuyokuPartsRadio.setUseClearButton(false);

      homonNyuyokuPartsRadio.setModel(getHomonNyuyokuPartsRadioModel());

      homonNyuyokuPartsRadio.setValues(new int[]{1,2});

      addHomonNyuyokuPartsRadio();
    }
    return homonNyuyokuPartsRadio;

  }

  /**
   * �K��������敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �K��������敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuPartsRadioContainer(){
    if(homonNyuyokuPartsRadioContainer==null){
      homonNyuyokuPartsRadioContainer = new ACLabelContainer();
      homonNyuyokuPartsRadioContainer.setFollowChildEnabled(true);
      homonNyuyokuPartsRadioContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuPartsRadioContainer.add(getHomonNyuyokuPartsRadio(), null);
    }
    return homonNyuyokuPartsRadioContainer;
  }

  /**
   * �K��������敪���W�I�O���[�v���f�����擾���܂��B
   * @return �K��������敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getHomonNyuyokuPartsRadioModel(){
    if(homonNyuyokuPartsRadioModel==null){
      homonNyuyokuPartsRadioModel = new ACListModelAdapter();
      addHomonNyuyokuPartsRadioModel();
    }
    return homonNyuyokuPartsRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHomonNyuyokuPartsRadioItem1(){
    if(homonNyuyokuPartsRadioItem1==null){

      homonNyuyokuPartsRadioItem1 = new ACRadioButtonItem();

      homonNyuyokuPartsRadioItem1.setText("�Ȃ�");

      homonNyuyokuPartsRadioItem1.setGroup(getHomonNyuyokuPartsRadio());

      homonNyuyokuPartsRadioItem1.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuPartsRadioItem1();
    }
    return homonNyuyokuPartsRadioItem1;

  }

  /**
   * �������E���@�݂̂��擾���܂��B
   * @return �������E���@�̂�
   */
  public ACRadioButtonItem getHomonNyuyokuPartsRadioItem2(){
    if(homonNyuyokuPartsRadioItem2==null){

      homonNyuyokuPartsRadioItem2 = new ACRadioButtonItem();

      homonNyuyokuPartsRadioItem2.setText("�������E���@�̂�");

      homonNyuyokuPartsRadioItem2.setGroup(getHomonNyuyokuPartsRadio());

      homonNyuyokuPartsRadioItem2.setConstraints(VRLayout.FLOW);

      addHomonNyuyokuPartsRadioItem2();
    }
    return homonNyuyokuPartsRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1120105");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,3,2});

      addServiceAddProvisionStructuralRadioGroup();
    }
    return serviceAddProvisionStructuralRadioGroup;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�R���e�i
   */
  protected ACLabelContainer getServiceAddProvisionStructuralRadioGroupContainer(){
    if(serviceAddProvisionStructuralRadioGroupContainer==null){
      serviceAddProvisionStructuralRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralRadioGroupContainer.add(getServiceAddProvisionStructuralRadioGroup(), null);
    }
    return serviceAddProvisionStructuralRadioGroupContainer;
  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f�����擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z���f��
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralRadioGroupModel(){
    if(serviceAddProvisionStructuralRadioGroupModel==null){
      serviceAddProvisionStructuralRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralRadioGroupModel();
    }
    return serviceAddProvisionStructuralRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem1(){
    if(serviceAddProvisionStructuralRadioItem1==null){

      serviceAddProvisionStructuralRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem1.setText("�Ȃ�");

      serviceAddProvisionStructuralRadioItem1.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem1();
    }
    return serviceAddProvisionStructuralRadioItem1;

  }

  /**
   * I�C�^���擾���܂��B
   * @return I�C�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("I�C�^");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * I���^���擾���܂��B
   * @return I���^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I���^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRafioRadioGroup(){
    if(providerAddMountainousAreaRafioRadioGroup==null){

      providerAddMountainousAreaRafioRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRafioRadioGroupContainer().setText("���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z");

      providerAddMountainousAreaRafioRadioGroup.setBindPath("12");

      providerAddMountainousAreaRafioRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRafioRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRafioRadioGroup.setModel(getProviderAddMountainousAreaRafioRadioGroupModel());

      providerAddMountainousAreaRafioRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRafioRadioGroup();
    }
    return providerAddMountainousAreaRafioRadioGroup;

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i
   */
  protected ACLabelContainer getProviderAddMountainousAreaRafioRadioGroupContainer(){
    if(providerAddMountainousAreaRafioRadioGroupContainer==null){
      providerAddMountainousAreaRafioRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRafioRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRafioRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRafioRadioGroupContainer.add(getProviderAddMountainousAreaRafioRadioGroup(), null);
    }
    return providerAddMountainousAreaRafioRadioGroupContainer;
  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f�����擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f��
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRafioRadioGroupModel(){
    if(providerAddMountainousAreaRafioRadioGroupModel==null){
      providerAddMountainousAreaRafioRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRafioRadioGroupModel();
    }
    return providerAddMountainousAreaRafioRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioItem1(){
    if(providerAddMountainousAreaRafioItem1==null){

      providerAddMountainousAreaRafioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioItem1.setText("�Ȃ�");

      providerAddMountainousAreaRafioItem1.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioItem1();
    }
    return providerAddMountainousAreaRafioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRafioRadioItem2(){
    if(providerAddMountainousAreaRafioRadioItem2==null){

      providerAddMountainousAreaRafioRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRafioRadioItem2.setText("����");

      providerAddMountainousAreaRafioRadioItem2.setGroup(getProviderAddMountainousAreaRafioRadioGroup());

      providerAddMountainousAreaRafioRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRafioRadioItem2();
    }
    return providerAddMountainousAreaRafioRadioItem2;

  }

  /**
   * ���ꌚ�����Z���擾���܂��B
   * @return ���ꌚ�����Z
   */
  public ACValueArrayRadioButtonGroup getHoumonNeededRadio(){
    if(houmonNeededRadio==null){

      houmonNeededRadio = new ACValueArrayRadioButtonGroup();

      getHoumonNeededRadioContainer().setText("���ꌚ�����Z");

      houmonNeededRadio.setBindPath("23");

      houmonNeededRadio.setNoSelectIndex(0);

      houmonNeededRadio.setUseClearButton(false);

      houmonNeededRadio.setModel(getHoumonNeededRadioModel());

      houmonNeededRadio.setValues(new int[]{1,2,3});

      addHoumonNeededRadio();
    }
    return houmonNeededRadio;

  }

  /**
   * ���ꌚ�����Z�R���e�i���擾���܂��B
   * @return ���ꌚ�����Z�R���e�i
   */
  protected ACLabelContainer getHoumonNeededRadioContainer(){
    if(houmonNeededRadioContainer==null){
      houmonNeededRadioContainer = new ACLabelContainer();
      houmonNeededRadioContainer.setFollowChildEnabled(true);
      houmonNeededRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonNeededRadioContainer.add(getHoumonNeededRadio(), null);
    }
    return houmonNeededRadioContainer;
  }

  /**
   * ���ꌚ�����Z���f�����擾���܂��B
   * @return ���ꌚ�����Z���f��
   */
  protected ACListModelAdapter getHoumonNeededRadioModel(){
    if(houmonNeededRadioModel==null){
      houmonNeededRadioModel = new ACListModelAdapter();
      addHoumonNeededRadioModel();
    }
    return houmonNeededRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonNeededRadioItem1(){
    if(houmonNeededRadioItem1==null){

      houmonNeededRadioItem1 = new ACRadioButtonItem();

      houmonNeededRadioItem1.setText("�Ȃ�");

      houmonNeededRadioItem1.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem1();
    }
    return houmonNeededRadioItem1;

  }

  /**
   * 20�l�ȏ���擾���܂��B
   * @return 20�l�ȏ�
   */
  public ACRadioButtonItem getHoumonNeededRadioItem2(){
    if(houmonNeededRadioItem2==null){

      houmonNeededRadioItem2 = new ACRadioButtonItem();

      houmonNeededRadioItem2.setText("20�l�ȏ�");

      houmonNeededRadioItem2.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem2();
    }
    return houmonNeededRadioItem2;

  }

  /**
   * 50�l�ȏ���擾���܂��B
   * @return 50�l�ȏ�
   */
  public ACRadioButtonItem getHoumonNeededRadioItem3(){
    if(houmonNeededRadioItem3==null){

      houmonNeededRadioItem3 = new ACRadioButtonItem();

      houmonNeededRadioItem3.setText("50�l�ȏ�");

      houmonNeededRadioItem3.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem3();
    }
    return houmonNeededRadioItem3;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHomonNyuyokuTimeContainer(){
    if(homonNyuyokuTimeContainer==null){

      homonNyuyokuTimeContainer = new ACBackLabelContainer();

      homonNyuyokuTimeContainer.setFollowChildEnabled(true);

      addHomonNyuyokuTimeContainer();
    }
    return homonNyuyokuTimeContainer;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHomonNyuyokuBeginTime(){
    if(homonNyuyokuBeginTime==null){

      homonNyuyokuBeginTime = new ACTimeComboBox();

      getHomonNyuyokuBeginTimeContainer().setText("�J�n����");

      homonNyuyokuBeginTime.setBindPath("3");

      homonNyuyokuBeginTime.setModelBindPath("3");

      homonNyuyokuBeginTime.setRenderBindPath("CONTENT");

      homonNyuyokuBeginTime.setModel(getHomonNyuyokuBeginTimeModel());

      addHomonNyuyokuBeginTime();
    }
    return homonNyuyokuBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuBeginTimeContainer(){
    if(homonNyuyokuBeginTimeContainer==null){
      homonNyuyokuBeginTimeContainer = new ACLabelContainer();
      homonNyuyokuBeginTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuBeginTimeContainer.add(getHomonNyuyokuBeginTime(), null);
    }
    return homonNyuyokuBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuBeginTimeModel(){
    if(homonNyuyokuBeginTimeModel==null){
      homonNyuyokuBeginTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuBeginTimeModel();
    }
    return homonNyuyokuBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHomonNyuyokuEndTime(){
    if(homonNyuyokuEndTime==null){

      homonNyuyokuEndTime = new ACTimeComboBox();

      getHomonNyuyokuEndTimeContainer().setText("�I������");

      homonNyuyokuEndTime.setBindPath("4");

      homonNyuyokuEndTime.setModelBindPath("4");

      homonNyuyokuEndTime.setRenderBindPath("CONTENT");

      homonNyuyokuEndTime.setModel(getHomonNyuyokuEndTimeModel());

      addHomonNyuyokuEndTime();
    }
    return homonNyuyokuEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHomonNyuyokuEndTimeContainer(){
    if(homonNyuyokuEndTimeContainer==null){
      homonNyuyokuEndTimeContainer = new ACLabelContainer();
      homonNyuyokuEndTimeContainer.setFollowChildEnabled(true);
      homonNyuyokuEndTimeContainer.setVAlignment(VRLayout.CENTER);
      homonNyuyokuEndTimeContainer.add(getHomonNyuyokuEndTime(), null);
    }
    return homonNyuyokuEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHomonNyuyokuEndTimeModel(){
    if(homonNyuyokuEndTimeModel==null){
      homonNyuyokuEndTimeModel = new ACComboBoxModelAdapter();
      addHomonNyuyokuEndTimeModel();
    }
    return homonNyuyokuEndTimeModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_11211_201804Design() {

    try {
      initialize();

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g�̐ݒ���s�Ȃ��܂��B
   */
  protected void initThis(){
  }

  /**
   * this�ɓ������ڂ�ǉ����܂��B
   */
  protected void addThis(){

    this.add(getHomonNyuyokuPatterns(), VRLayout.CLIENT);

  }

  /**
   * �K��������p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuPatterns(){

    homonNyuyokuPatterns.add(getHomonNyuyokuClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getHomonNyuyokuPartsRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonNyuyokuPatterns.add(getHomonNyuyokuTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �K��҂̎�ʃ��W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuClass(){

  }

  /**
   * �K��҂̎�ʃ��W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuClassModel(){

    getHomonNyuyokuClassDouble().setButtonIndex(1);

    getHomonNyuyokuClassModel().add(getHomonNyuyokuClassDouble());

    getHomonNyuyokuClassSingle().setButtonIndex(2);

    getHomonNyuyokuClassModel().add(getHomonNyuyokuClassSingle());

  }

  /**
   * �Ō�E��1�l�{���E��2�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuClassDouble(){

  }

  /**
   * ���E��3�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuClassSingle(){

  }

  /**
   * �K��������敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuPartsRadio(){

  }

  /**
   * �K��������敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuPartsRadioModel(){

    getHomonNyuyokuPartsRadioItem1().setButtonIndex(1);

    getHomonNyuyokuPartsRadioModel().add(getHomonNyuyokuPartsRadioItem1());

    getHomonNyuyokuPartsRadioItem2().setButtonIndex(2);

    getHomonNyuyokuPartsRadioModel().add(getHomonNyuyokuPartsRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuPartsRadioItem1(){

  }

  /**
   * �������E���@�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuPartsRadioItem2(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroupModel(){

    getServiceAddProvisionStructuralRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem1());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�C�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * I���^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioGroup(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioGroupModel(){

    getProviderAddMountainousAreaRafioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioItem1());

    getProviderAddMountainousAreaRafioRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRafioRadioGroupModel().add(getProviderAddMountainousAreaRafioRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRafioRadioItem2(){

  }

  /**
   * ���ꌚ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadio(){

  }

  /**
   * ���ꌚ�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadioModel(){

    getHoumonNeededRadioItem1().setButtonIndex(1);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem1());

    getHoumonNeededRadioItem2().setButtonIndex(2);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem2());

    getHoumonNeededRadioItem3().setButtonIndex(3);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadioItem1(){

  }

  /**
   * 20�l�ȏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadioItem2(){

  }

  /**
   * 50�l�ȏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadioItem3(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuTimeContainer(){

    homonNyuyokuTimeContainer.add(getHomonNyuyokuBeginTimeContainer(), VRLayout.FLOW);

    homonNyuyokuTimeContainer.add(getHomonNyuyokuEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonNyuyokuEndTimeModel(){

  }

  /**
   * �R���|�[�l���g�����������܂��B
   * @throws Exception ��������O
   */
  private void initialize() throws Exception {
    initThis();
    addThis();
  }
  public boolean canBack(VRMap parameters) throws Exception {
    return true;
  }
  public Component getFirstFocusComponent() {

    return null;

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001_11211_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_11211_201804Design getThis() {
    return this;
  }
}
