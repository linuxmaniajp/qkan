
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
 * �쐬��: 2012/02/08  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K�⃊�n (QS001_11411_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[���K�⃊�n��ʍ��ڃf�U�C��(QS001_11411_201204) 
 */
public class QS001_11411_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel houmonRehabilitationPatterns;

  private ACValueArrayRadioButtonGroup houmonRehabilitationFacilityDivision;

  private ACLabelContainer houmonRehabilitationFacilityDivisionContainer;

  private ACListModelAdapter houmonRehabilitationFacilityDivisionModel;

  private ACRadioButtonItem houmonRehabilitationClassDouble;

  private ACRadioButtonItem houmonRehabilitationClassSingle;

  private ACValueArrayRadioButtonGroup houmonRehabiliShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabiliShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabiliShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabiliShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabiliShortConcentrationAddRadioItem2;

  private ACRadioButtonItem houmonRehabiliShortConcentrationAddRadioItem3;

  private ACValueArrayRadioButtonGroup attendantServicepCoalitionRadioGroup;

  private ACLabelContainer attendantServicepCoalitionRadioGroupContainer;

  private ACListModelAdapter attendantServicepCoalitionRadioGroupModel;

  private ACRadioButtonItem attendantServicepCoalitionRadioItem1;

  private ACRadioButtonItem attendantServicepCoalitionRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaItem1;

  private ACRadioButtonItem providerAddMountainousAreaItem2;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationBeginTime;

  private ACLabelContainer houmonRehabilitationBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationEndTime;

  private ACLabelContainer houmonRehabilitationEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationEndTimeModel;

  private ACGroupBox houmonRehabilitationInfoGroup;

  private ACLabel houmonRehabilitationInfoLabel;

  //getter

  /**
   * �K�⃊�n�r���e�[�V�����p�^�[���̈���擾���܂��B
   * @return �K�⃊�n�r���e�[�V�����p�^�[���̈�
   */
  public ACPanel getHoumonRehabilitationPatterns(){
    if(houmonRehabilitationPatterns==null){

      houmonRehabilitationPatterns = new ACPanel();

      houmonRehabilitationPatterns.setFollowChildEnabled(true);

      addHoumonRehabilitationPatterns();
    }
    return houmonRehabilitationPatterns;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationFacilityDivision(){
    if(houmonRehabilitationFacilityDivision==null){

      houmonRehabilitationFacilityDivision = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationFacilityDivisionContainer().setText("�{�ݓ��̋敪");

      houmonRehabilitationFacilityDivision.setBindPath("1140103");

      houmonRehabilitationFacilityDivision.setUseClearButton(false);

      houmonRehabilitationFacilityDivision.setModel(getHoumonRehabilitationFacilityDivisionModel());

      houmonRehabilitationFacilityDivision.setValues(new int[]{1,2});

      addHoumonRehabilitationFacilityDivision();
    }
    return houmonRehabilitationFacilityDivision;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationFacilityDivisionContainer(){
    if(houmonRehabilitationFacilityDivisionContainer==null){
      houmonRehabilitationFacilityDivisionContainer = new ACLabelContainer();
      houmonRehabilitationFacilityDivisionContainer.setFollowChildEnabled(true);
      houmonRehabilitationFacilityDivisionContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationFacilityDivisionContainer.add(getHoumonRehabilitationFacilityDivision(), null);
    }
    return houmonRehabilitationFacilityDivisionContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getHoumonRehabilitationFacilityDivisionModel(){
    if(houmonRehabilitationFacilityDivisionModel==null){
      houmonRehabilitationFacilityDivisionModel = new ACListModelAdapter();
      addHoumonRehabilitationFacilityDivisionModel();
    }
    return houmonRehabilitationFacilityDivisionModel;
  }

  /**
   * �a�@�܂��͐f�Ï����擾���܂��B
   * @return �a�@�܂��͐f�Ï�
   */
  public ACRadioButtonItem getHoumonRehabilitationClassDouble(){
    if(houmonRehabilitationClassDouble==null){

      houmonRehabilitationClassDouble = new ACRadioButtonItem();

      houmonRehabilitationClassDouble.setText("�a�@���͐f�Ï�");

      houmonRehabilitationClassDouble.setGroup(getHoumonRehabilitationFacilityDivision());

      houmonRehabilitationClassDouble.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabilitationClassDouble();
    }
    return houmonRehabilitationClassDouble;

  }

  /**
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getHoumonRehabilitationClassSingle(){
    if(houmonRehabilitationClassSingle==null){

      houmonRehabilitationClassSingle = new ACRadioButtonItem();

      houmonRehabilitationClassSingle.setText("���V�l�ی��{��");

      houmonRehabilitationClassSingle.setGroup(getHoumonRehabilitationFacilityDivision());

      houmonRehabilitationClassSingle.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationClassSingle();
    }
    return houmonRehabilitationClassSingle;

  }

  /**
   * �Z���W�����n�r�����{���Z���擾���܂��B
   * @return �Z���W�����n�r�����{���Z
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabiliShortConcentrationAddRadio(){
    if(houmonRehabiliShortConcentrationAddRadio==null){

      houmonRehabiliShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabiliShortConcentrationAddRadioContainer().setText("�Z���W�����n�r�����{���Z");

      houmonRehabiliShortConcentrationAddRadio.setBindPath("1140106");

      houmonRehabiliShortConcentrationAddRadio.setUseClearButton(false);

      houmonRehabiliShortConcentrationAddRadio.setModel(getHoumonRehabiliShortConcentrationAddRadioModel());

      houmonRehabiliShortConcentrationAddRadio.setValues(new int[]{1,2,3});

      addHoumonRehabiliShortConcentrationAddRadio();
    }
    return houmonRehabiliShortConcentrationAddRadio;

  }

  /**
   * �Z���W�����n�r�����{���Z�R���e�i���擾���܂��B
   * @return �Z���W�����n�r�����{���Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabiliShortConcentrationAddRadioContainer(){
    if(houmonRehabiliShortConcentrationAddRadioContainer==null){
      houmonRehabiliShortConcentrationAddRadioContainer = new ACLabelContainer();
      houmonRehabiliShortConcentrationAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabiliShortConcentrationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabiliShortConcentrationAddRadioContainer.add(getHoumonRehabiliShortConcentrationAddRadio(), null);
    }
    return houmonRehabiliShortConcentrationAddRadioContainer;
  }

  /**
   * �Z���W�����n�r�����{���Z���f�����擾���܂��B
   * @return �Z���W�����n�r�����{���Z���f��
   */
  protected ACListModelAdapter getHoumonRehabiliShortConcentrationAddRadioModel(){
    if(houmonRehabiliShortConcentrationAddRadioModel==null){
      houmonRehabiliShortConcentrationAddRadioModel = new ACListModelAdapter();
      addHoumonRehabiliShortConcentrationAddRadioModel();
    }
    return houmonRehabiliShortConcentrationAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabiliShortConcentrationAddRadioItem1(){
    if(houmonRehabiliShortConcentrationAddRadioItem1==null){

      houmonRehabiliShortConcentrationAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabiliShortConcentrationAddRadioItem1.setText("�Ȃ�");

      houmonRehabiliShortConcentrationAddRadioItem1.setGroup(getHoumonRehabiliShortConcentrationAddRadio());

      houmonRehabiliShortConcentrationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabiliShortConcentrationAddRadioItem1();
    }
    return houmonRehabiliShortConcentrationAddRadioItem1;

  }

  /**
   * �P���ȓ����擾���܂��B
   * @return �P���ȓ�
   */
  public ACRadioButtonItem getHoumonRehabiliShortConcentrationAddRadioItem2(){
    if(houmonRehabiliShortConcentrationAddRadioItem2==null){

      houmonRehabiliShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabiliShortConcentrationAddRadioItem2.setText("�P���ȓ�");

      houmonRehabiliShortConcentrationAddRadioItem2.setGroup(getHoumonRehabiliShortConcentrationAddRadio());

      houmonRehabiliShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabiliShortConcentrationAddRadioItem2();
    }
    return houmonRehabiliShortConcentrationAddRadioItem2;

  }

  /**
   * �P�����R���ȓ����擾���܂��B
   * @return �P�����R���ȓ�
   */
  public ACRadioButtonItem getHoumonRehabiliShortConcentrationAddRadioItem3(){
    if(houmonRehabiliShortConcentrationAddRadioItem3==null){

      houmonRehabiliShortConcentrationAddRadioItem3 = new ACRadioButtonItem();

      houmonRehabiliShortConcentrationAddRadioItem3.setText("�P�����R���ȓ�");

      houmonRehabiliShortConcentrationAddRadioItem3.setGroup(getHoumonRehabiliShortConcentrationAddRadio());

      houmonRehabiliShortConcentrationAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabiliShortConcentrationAddRadioItem3();
    }
    return houmonRehabiliShortConcentrationAddRadioItem3;

  }

  /**
   * �K����A�g���Z���擾���܂��B
   * @return �K����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getAttendantServicepCoalitionRadioGroup(){
    if(attendantServicepCoalitionRadioGroup==null){

      attendantServicepCoalitionRadioGroup = new ACValueArrayRadioButtonGroup();

      getAttendantServicepCoalitionRadioGroupContainer().setText("�K����A�g���Z");

      attendantServicepCoalitionRadioGroup.setBindPath("1140108");

      attendantServicepCoalitionRadioGroup.setNoSelectIndex(0);

      attendantServicepCoalitionRadioGroup.setUseClearButton(false);

      attendantServicepCoalitionRadioGroup.setModel(getAttendantServicepCoalitionRadioGroupModel());

      attendantServicepCoalitionRadioGroup.setValues(new int[]{1,2});

      addAttendantServicepCoalitionRadioGroup();
    }
    return attendantServicepCoalitionRadioGroup;

  }

  /**
   * �K����A�g���Z�R���e�i���擾���܂��B
   * @return �K����A�g���Z�R���e�i
   */
  protected ACLabelContainer getAttendantServicepCoalitionRadioGroupContainer(){
    if(attendantServicepCoalitionRadioGroupContainer==null){
      attendantServicepCoalitionRadioGroupContainer = new ACLabelContainer();
      attendantServicepCoalitionRadioGroupContainer.setFollowChildEnabled(true);
      attendantServicepCoalitionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      attendantServicepCoalitionRadioGroupContainer.add(getAttendantServicepCoalitionRadioGroup(), null);
    }
    return attendantServicepCoalitionRadioGroupContainer;
  }

  /**
   * �K����A�g���Z���f�����擾���܂��B
   * @return �K����A�g���Z���f��
   */
  protected ACListModelAdapter getAttendantServicepCoalitionRadioGroupModel(){
    if(attendantServicepCoalitionRadioGroupModel==null){
      attendantServicepCoalitionRadioGroupModel = new ACListModelAdapter();
      addAttendantServicepCoalitionRadioGroupModel();
    }
    return attendantServicepCoalitionRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getAttendantServicepCoalitionRadioItem1(){
    if(attendantServicepCoalitionRadioItem1==null){

      attendantServicepCoalitionRadioItem1 = new ACRadioButtonItem();

      attendantServicepCoalitionRadioItem1.setText("�Ȃ�");

      attendantServicepCoalitionRadioItem1.setGroup(getAttendantServicepCoalitionRadioGroup());

      attendantServicepCoalitionRadioItem1.setConstraints(VRLayout.FLOW);

      addAttendantServicepCoalitionRadioItem1();
    }
    return attendantServicepCoalitionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getAttendantServicepCoalitionRadioItem2(){
    if(attendantServicepCoalitionRadioItem2==null){

      attendantServicepCoalitionRadioItem2 = new ACRadioButtonItem();

      attendantServicepCoalitionRadioItem2.setText("����");

      attendantServicepCoalitionRadioItem2.setGroup(getAttendantServicepCoalitionRadioGroup());

      attendantServicepCoalitionRadioItem2.setConstraints(VRLayout.FLOW);

      addAttendantServicepCoalitionRadioItem2();
    }
    return attendantServicepCoalitionRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1140107");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2});

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
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("����");

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
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRadioGroup(){
    if(providerAddMountainousAreaRadioGroup==null){

      providerAddMountainousAreaRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRadioGroupContainer().setText("���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z");

      providerAddMountainousAreaRadioGroup.setBindPath("12");

      providerAddMountainousAreaRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRadioGroup.setModel(getProviderAddMountainousAreaRadioGroupModel());

      providerAddMountainousAreaRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRadioGroup();
    }
    return providerAddMountainousAreaRadioGroup;

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i���擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�R���e�i
   */
  protected ACLabelContainer getProviderAddMountainousAreaRadioGroupContainer(){
    if(providerAddMountainousAreaRadioGroupContainer==null){
      providerAddMountainousAreaRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRadioGroupContainer.add(getProviderAddMountainousAreaRadioGroup(), null);
    }
    return providerAddMountainousAreaRadioGroupContainer;
  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f�����擾���܂��B
   * @return ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f��
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRadioGroupModel(){
    if(providerAddMountainousAreaRadioGroupModel==null){
      providerAddMountainousAreaRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRadioGroupModel();
    }
    return providerAddMountainousAreaRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getProviderAddMountainousAreaItem1(){
    if(providerAddMountainousAreaItem1==null){

      providerAddMountainousAreaItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaItem1.setText("�Ȃ�");

      providerAddMountainousAreaItem1.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaItem1();
    }
    return providerAddMountainousAreaItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getProviderAddMountainousAreaItem2(){
    if(providerAddMountainousAreaItem2==null){

      providerAddMountainousAreaItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaItem2.setText("����");

      providerAddMountainousAreaItem2.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaItem2();
    }
    return providerAddMountainousAreaItem2;

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂��擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X��
   */
  public ACValueArrayRadioButtonGroup getHoumonNeededRadio(){
    if(houmonNeededRadio==null){

      houmonNeededRadio = new ACValueArrayRadioButtonGroup();

      getHoumonNeededRadioContainer().setText("���ꌚ�����Z�҂ւ̃T�[�r�X��");

      houmonNeededRadio.setBindPath("16");

      houmonNeededRadio.setNoSelectIndex(0);

      houmonNeededRadio.setUseClearButton(false);

      houmonNeededRadio.setModel(getHoumonNeededRadioModel());

      houmonNeededRadio.setValues(new int[]{1,2});

      addHoumonNeededRadio();
    }
    return houmonNeededRadio;

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i���擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i
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
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f�����擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f��
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
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonNeededRadioItem2(){
    if(houmonNeededRadioItem2==null){

      houmonNeededRadioItem2 = new ACRadioButtonItem();

      houmonNeededRadioItem2.setText("����");

      houmonNeededRadioItem2.setGroup(getHoumonNeededRadio());

      houmonNeededRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonNeededRadioItem2();
    }
    return houmonNeededRadioItem2;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHoumonRehabilitationTimeContena(){
    if(houmonRehabilitationTimeContena==null){

      houmonRehabilitationTimeContena = new ACBackLabelContainer();

      houmonRehabilitationTimeContena.setFollowChildEnabled(true);

      addHoumonRehabilitationTimeContena();
    }
    return houmonRehabilitationTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHoumonRehabilitationBeginTime(){
    if(houmonRehabilitationBeginTime==null){

      houmonRehabilitationBeginTime = new ACTimeComboBox();

      getHoumonRehabilitationBeginTimeContainer().setText("�J�n����");

      houmonRehabilitationBeginTime.setBindPath("3");

      houmonRehabilitationBeginTime.setModelBindPath("3");

      houmonRehabilitationBeginTime.setRenderBindPath("CONTENT");

      houmonRehabilitationBeginTime.setModel(getHoumonRehabilitationBeginTimeModel());

      addHoumonRehabilitationBeginTime();
    }
    return houmonRehabilitationBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationBeginTimeContainer(){
    if(houmonRehabilitationBeginTimeContainer==null){
      houmonRehabilitationBeginTimeContainer = new ACLabelContainer();
      houmonRehabilitationBeginTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationBeginTimeContainer.add(getHoumonRehabilitationBeginTime(), null);
    }
    return houmonRehabilitationBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationBeginTimeModel(){
    if(houmonRehabilitationBeginTimeModel==null){
      houmonRehabilitationBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationBeginTimeModel();
    }
    return houmonRehabilitationBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHoumonRehabilitationEndTime(){
    if(houmonRehabilitationEndTime==null){

      houmonRehabilitationEndTime = new ACTimeComboBox();

      getHoumonRehabilitationEndTimeContainer().setText("�I������");

      houmonRehabilitationEndTime.setBindPath("4");

      houmonRehabilitationEndTime.setModelBindPath("4");

      houmonRehabilitationEndTime.setRenderBindPath("CONTENT");

      houmonRehabilitationEndTime.setModel(getHoumonRehabilitationEndTimeModel());

      addHoumonRehabilitationEndTime();
    }
    return houmonRehabilitationEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHoumonRehabilitationEndTimeContainer(){
    if(houmonRehabilitationEndTimeContainer==null){
      houmonRehabilitationEndTimeContainer = new ACLabelContainer();
      houmonRehabilitationEndTimeContainer.setFollowChildEnabled(true);
      houmonRehabilitationEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationEndTimeContainer.add(getHoumonRehabilitationEndTime(), null);
    }
    return houmonRehabilitationEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonRehabilitationEndTimeModel(){
    if(houmonRehabilitationEndTimeModel==null){
      houmonRehabilitationEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonRehabilitationEndTimeModel();
    }
    return houmonRehabilitationEndTimeModel;
  }

  /**
   * �������O���[�v���擾���܂��B
   * @return �������O���[�v
   */
  public ACGroupBox getHoumonRehabilitationInfoGroup(){
    if(houmonRehabilitationInfoGroup==null){

      houmonRehabilitationInfoGroup = new ACGroupBox();

      houmonRehabilitationInfoGroup.setAutoWrap(false);

      houmonRehabilitationInfoGroup.setFollowChildEnabled(true);

      houmonRehabilitationInfoGroup.setHgap(0);

      houmonRehabilitationInfoGroup.setLabelMargin(0);

      houmonRehabilitationInfoGroup.setVgap(0);

      addHoumonRehabilitationInfoGroup();
    }
    return houmonRehabilitationInfoGroup;

  }

  /**
   * ���������x�����擾���܂��B
   * @return ���������x��
   */
  public ACLabel getHoumonRehabilitationInfoLabel(){
    if(houmonRehabilitationInfoLabel==null){

      houmonRehabilitationInfoLabel = new ACLabel();

      houmonRehabilitationInfoLabel.setText("�T�[�r�X��40���ȏ�񋟂���ꍇ�́A�J�����_�[��" + ACConstants.LINE_SEPARATOR + "2��\��t���Ă��������B");

      houmonRehabilitationInfoLabel.setAutoWrap(false);

      addHoumonRehabilitationInfoLabel();
    }
    return houmonRehabilitationInfoLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_11411_201204Design() {

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

    this.add(getHoumonRehabilitationPatterns(), VRLayout.CLIENT);

  }

  /**
   * �K�⃊�n�r���e�[�V�����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationPatterns(){

    houmonRehabilitationPatterns.add(getHoumonRehabilitationFacilityDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabiliShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getAttendantServicepCoalitionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabilitationInfoGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationFacilityDivision(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationFacilityDivisionModel(){

    getHoumonRehabilitationClassDouble().setButtonIndex(1);

    getHoumonRehabilitationFacilityDivisionModel().add(getHoumonRehabilitationClassDouble());

    getHoumonRehabilitationClassSingle().setButtonIndex(2);

    getHoumonRehabilitationFacilityDivisionModel().add(getHoumonRehabilitationClassSingle());

  }

  /**
   * �a�@�܂��͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationClassDouble(){

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationClassSingle(){

  }

  /**
   * �Z���W�����n�r�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliShortConcentrationAddRadio(){

  }

  /**
   * �Z���W�����n�r�����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioModel(){

    getHoumonRehabiliShortConcentrationAddRadioItem1().setButtonIndex(1);

    getHoumonRehabiliShortConcentrationAddRadioModel().add(getHoumonRehabiliShortConcentrationAddRadioItem1());

    getHoumonRehabiliShortConcentrationAddRadioItem2().setButtonIndex(2);

    getHoumonRehabiliShortConcentrationAddRadioModel().add(getHoumonRehabiliShortConcentrationAddRadioItem2());

    getHoumonRehabiliShortConcentrationAddRadioItem3().setButtonIndex(3);

    getHoumonRehabiliShortConcentrationAddRadioModel().add(getHoumonRehabiliShortConcentrationAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioItem1(){

  }

  /**
   * �P���ȓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioItem2(){

  }

  /**
   * �P�����R���ȓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioItem3(){

  }

  /**
   * �K����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAttendantServicepCoalitionRadioGroup(){

  }

  /**
   * �K����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAttendantServicepCoalitionRadioGroupModel(){

    getAttendantServicepCoalitionRadioItem1().setButtonIndex(1);

    getAttendantServicepCoalitionRadioGroupModel().add(getAttendantServicepCoalitionRadioItem1());

    getAttendantServicepCoalitionRadioItem2().setButtonIndex(2);

    getAttendantServicepCoalitionRadioGroupModel().add(getAttendantServicepCoalitionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAttendantServicepCoalitionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addAttendantServicepCoalitionRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRadioGroup(){

  }

  /**
   * ���R�Ԓn�擙�ł̃T�[�r�X�񋟉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaRadioGroupModel(){

    getProviderAddMountainousAreaItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaItem1());

    getProviderAddMountainousAreaItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddMountainousAreaItem2(){

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadio(){

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadioModel(){

    getHoumonNeededRadioItem1().setButtonIndex(1);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem1());

    getHoumonNeededRadioItem2().setButtonIndex(2);

    getHoumonNeededRadioModel().add(getHoumonNeededRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonNeededRadioItem2(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationTimeContena(){

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationBeginTimeContainer(), VRLayout.FLOW);

    houmonRehabilitationTimeContena.add(getHoumonRehabilitationEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationEndTimeModel(){

  }

  /**
   * �������O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationInfoGroup(){

    houmonRehabilitationInfoGroup.add(getHoumonRehabilitationInfoLabel(), VRLayout.FLOW);

  }

  /**
   * ���������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabilitationInfoLabel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_11411_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_11411_201204Design getThis() {
    return this;
  }
}
