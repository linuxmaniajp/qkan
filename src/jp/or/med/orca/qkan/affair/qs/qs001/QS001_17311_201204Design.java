
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
 * �쐬��: 2012/02/22  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����K�͑��@�\�^��� (QS001_17311_201204)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACValueArrayRadioButtonGroup;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[�����K�͑��@�\�^����ʍ��ڃf�U�C��(QS001_17311_201204) 
 */
public class QS001_17311_201204Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel regionSmallscaleMultiPatterns;

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup initialAddRadio;

  private ACLabelContainer initialAddRadioContainer;

  private ACListModelAdapter initialAddRadioModel;

  private ACRadioButtonItem initialAddRadioItem1;

  private ACRadioButtonItem initialAddRadioItem2;

  private ACValueArrayRadioButtonGroup smallServiceRadio;

  private ACLabelContainer smallServiceRadioContainer;

  private ACListModelAdapter smallServiceRadioModel;

  private ACRadioButtonItem smallServiceRadioItem1;

  private ACRadioButtonItem smallServiceRadioItem2;

  private ACValueArrayRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACValueArrayRadioButtonGroup dementiaAddRadioGroup;

  private ACLabelContainer dementiaAddRadioGroupContainer;

  private ACListModelAdapter dementiaAddRadioGroupModel;

  private ACRadioButtonItem dementiaAddRadioItem1;

  private ACRadioButtonItem dementiaAddRadioItem2;

  private ACRadioButtonItem dementiaAddRadioItem3;

  private ACValueArrayRadioButtonGroup nurseStaffDispositionAddRadioGroup;

  private ACLabelContainer nurseStaffDispositionAddRadioGroupContainer;

  private ACListModelAdapter nurseStaffDispositionAddRadioGroupModel;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem1;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem2;

  private ACRadioButtonItem nurseStaffDispositionAddRadioItem3;

  private ACValueArrayRadioButtonGroup providerStartAddRadioGroup;

  private ACLabelContainer providerStartAddRadioGroupContainer;

  private ACListModelAdapter providerStartAddRadioGroupModel;

  private ACRadioButtonItem providerStartAddRadioItem1;

  private ACRadioButtonItem providerStartAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonNeededRadio;

  private ACLabelContainer houmonNeededRadioContainer;

  private ACListModelAdapter houmonNeededRadioModel;

  private ACRadioButtonItem houmonNeededRadioItem1;

  private ACRadioButtonItem houmonNeededRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACComboBox municipalityAdd;

  private ACLabelContainer municipalityAddContainer;

  private ACComboBoxModelAdapter municipalityAddModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionItem1;

  private ACRadioButtonItem calculationDivisionItem2;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACGroupBox kaigoSupportSpecialMemberContainer;

  private ACTextField kaigoSupportSpecialMemberNumber;

  private ACLabelContainer kaigoSupportSpecialMemberNumberContainer;

  private ACComboBox kaigoSupportSpecialMemberName;

  private ACLabelContainer kaigoSupportSpecialMemberNameContainer;

  private ACComboBoxModelAdapter kaigoSupportSpecialMemberNameModel;

  private ACGroupBox tekiyouGroup;

  private ACTextField tekiyouText;

  private ACLabelContainer tekiyouTextContainer;

  private ACLabel tekiyouCommentTitle;

  private ACGroupBox infoGroup;

  private ACLabel infoLabel;

  //getter

  /**
   * �n�斧�����K�͑��@�\�^���p�^�[���̈���擾���܂��B
   * @return �n�斧�����K�͑��@�\�^���p�^�[���̈�
   */
  public ACPanel getRegionSmallscaleMultiPatterns(){
    if(regionSmallscaleMultiPatterns==null){

      regionSmallscaleMultiPatterns = new ACPanel();

      regionSmallscaleMultiPatterns.setAutoWrap(false);

      regionSmallscaleMultiPatterns.setFollowChildEnabled(true);

      regionSmallscaleMultiPatterns.setHgrid(200);

      addRegionSmallscaleMultiPatterns();
    }
    return regionSmallscaleMultiPatterns;

  }

  /**
   * �^�u�p�l�����擾���܂��B
   * @return �^�u�p�l��
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * �^�u1���擾���܂��B
   * @return �^�u1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setHgap(0);

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getInitialAddRadio(){
    if(initialAddRadio==null){

      initialAddRadio = new ACValueArrayRadioButtonGroup();

      getInitialAddRadioContainer().setText("�������Z");

      initialAddRadio.setBindPath("1730101");

      initialAddRadio.setUseClearButton(false);

      initialAddRadio.setModel(getInitialAddRadioModel());

      initialAddRadio.setValues(new int[]{1,2});

      addInitialAddRadio();
    }
    return initialAddRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getInitialAddRadioContainer(){
    if(initialAddRadioContainer==null){
      initialAddRadioContainer = new ACLabelContainer();
      initialAddRadioContainer.setFollowChildEnabled(true);
      initialAddRadioContainer.setVAlignment(VRLayout.CENTER);
      initialAddRadioContainer.add(getInitialAddRadio(), null);
    }
    return initialAddRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getInitialAddRadioModel(){
    if(initialAddRadioModel==null){
      initialAddRadioModel = new ACListModelAdapter();
      addInitialAddRadioModel();
    }
    return initialAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getInitialAddRadioItem1(){
    if(initialAddRadioItem1==null){

      initialAddRadioItem1 = new ACRadioButtonItem();

      initialAddRadioItem1.setText("�Ȃ�");

      initialAddRadioItem1.setGroup(getInitialAddRadio());

      initialAddRadioItem1.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem1();
    }
    return initialAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getInitialAddRadioItem2(){
    if(initialAddRadioItem2==null){

      initialAddRadioItem2 = new ACRadioButtonItem();

      initialAddRadioItem2.setText("����");

      initialAddRadioItem2.setGroup(getInitialAddRadio());

      initialAddRadioItem2.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem2();
    }
    return initialAddRadioItem2;

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z
   */
  public ACValueArrayRadioButtonGroup getSmallServiceRadio(){
    if(smallServiceRadio==null){

      smallServiceRadio = new ACValueArrayRadioButtonGroup();

      getSmallServiceRadioContainer().setText("�ߏ��T�[�r�X�ɑ΂��錸�Z");

      smallServiceRadio.setBindPath("1730106");

      smallServiceRadio.setNoSelectIndex(0);

      smallServiceRadio.setUseClearButton(false);

      smallServiceRadio.setModel(getSmallServiceRadioModel());

      smallServiceRadio.setValues(new int[]{1,2});

      addSmallServiceRadio();
    }
    return smallServiceRadio;

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z�R���e�i���擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z�R���e�i
   */
  protected ACLabelContainer getSmallServiceRadioContainer(){
    if(smallServiceRadioContainer==null){
      smallServiceRadioContainer = new ACLabelContainer();
      smallServiceRadioContainer.setFollowChildEnabled(true);
      smallServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      smallServiceRadioContainer.add(getSmallServiceRadio(), null);
    }
    return smallServiceRadioContainer;
  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���f�����擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z���f��
   */
  protected ACListModelAdapter getSmallServiceRadioModel(){
    if(smallServiceRadioModel==null){
      smallServiceRadioModel = new ACListModelAdapter();
      addSmallServiceRadioModel();
    }
    return smallServiceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSmallServiceRadioItem1(){
    if(smallServiceRadioItem1==null){

      smallServiceRadioItem1 = new ACRadioButtonItem();

      smallServiceRadioItem1.setText("�Ȃ�");

      smallServiceRadioItem1.setGroup(getSmallServiceRadio());

      smallServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addSmallServiceRadioItem1();
    }
    return smallServiceRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSmallServiceRadioItem2(){
    if(smallServiceRadioItem2==null){

      smallServiceRadioItem2 = new ACRadioButtonItem();

      smallServiceRadioItem2.setText("����");

      smallServiceRadioItem2.setGroup(getSmallServiceRadio());

      smallServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addSmallServiceRadioItem2();
    }
    return smallServiceRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("�l�����Z");

      staffSubtractionRadio.setBindPath("1730102");

      staffSubtractionRadio.setUseClearButton(false);

      staffSubtractionRadio.setModel(getStaffSubtractionRadioModel());

      staffSubtractionRadio.setValues(new int[]{1,2,3});

      addStaffSubtractionRadio();
    }
    return staffSubtractionRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getStaffSubtractionRadioContainer(){
    if(staffSubtractionRadioContainer==null){
      staffSubtractionRadioContainer = new ACLabelContainer();
      staffSubtractionRadioContainer.setFollowChildEnabled(true);
      staffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      staffSubtractionRadioContainer.add(getStaffSubtractionRadio(), null);
    }
    return staffSubtractionRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getStaffSubtractionRadioModel(){
    if(staffSubtractionRadioModel==null){
      staffSubtractionRadioModel = new ACListModelAdapter();
      addStaffSubtractionRadioModel();
    }
    return staffSubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem1(){
    if(staffSubtractionRadioItem1==null){

      staffSubtractionRadioItem1 = new ACRadioButtonItem();

      staffSubtractionRadioItem1.setText("�Ȃ�");

      staffSubtractionRadioItem1.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem1();
    }
    return staffSubtractionRadioItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem2(){
    if(staffSubtractionRadioItem2==null){

      staffSubtractionRadioItem2 = new ACRadioButtonItem();

      staffSubtractionRadioItem2.setText("�������");

      staffSubtractionRadioItem2.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addStaffSubtractionRadioItem2();
    }
    return staffSubtractionRadioItem2;

  }

  /**
   * �]�Ǝ҂̕s�����擾���܂��B
   * @return �]�Ǝ҂̕s��
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("�]�Ǝ҂̕s��");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * �F�m�ǉ��Z���擾���܂��B
   * @return �F�m�ǉ��Z
   */
  public ACValueArrayRadioButtonGroup getDementiaAddRadioGroup(){
    if(dementiaAddRadioGroup==null){

      dementiaAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaAddRadioGroupContainer().setText("�F�m�ǉ��Z");

      dementiaAddRadioGroup.setBindPath("1730107");

      dementiaAddRadioGroup.setNoSelectIndex(0);

      dementiaAddRadioGroup.setUseClearButton(false);

      dementiaAddRadioGroup.setModel(getDementiaAddRadioGroupModel());

      dementiaAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaAddRadioGroup();
    }
    return dementiaAddRadioGroup;

  }

  /**
   * �F�m�ǉ��Z�R���e�i���擾���܂��B
   * @return �F�m�ǉ��Z�R���e�i
   */
  protected ACLabelContainer getDementiaAddRadioGroupContainer(){
    if(dementiaAddRadioGroupContainer==null){
      dementiaAddRadioGroupContainer = new ACLabelContainer();
      dementiaAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaAddRadioGroupContainer.add(getDementiaAddRadioGroup(), null);
    }
    return dementiaAddRadioGroupContainer;
  }

  /**
   * �F�m�ǉ��Z���f�����擾���܂��B
   * @return �F�m�ǉ��Z���f��
   */
  protected ACListModelAdapter getDementiaAddRadioGroupModel(){
    if(dementiaAddRadioGroupModel==null){
      dementiaAddRadioGroupModel = new ACListModelAdapter();
      addDementiaAddRadioGroupModel();
    }
    return dementiaAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaAddRadioItem1(){
    if(dementiaAddRadioItem1==null){

      dementiaAddRadioItem1 = new ACRadioButtonItem();

      dementiaAddRadioItem1.setText("�Ȃ�");

      dementiaAddRadioItem1.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem1();
    }
    return dementiaAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getDementiaAddRadioItem2(){
    if(dementiaAddRadioItem2==null){

      dementiaAddRadioItem2 = new ACRadioButtonItem();

      dementiaAddRadioItem2.setText("I�^");

      dementiaAddRadioItem2.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem2();
    }
    return dementiaAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getDementiaAddRadioItem3(){
    if(dementiaAddRadioItem3==null){

      dementiaAddRadioItem3 = new ACRadioButtonItem();

      dementiaAddRadioItem3.setText("II�^");

      dementiaAddRadioItem3.setGroup(getDementiaAddRadioGroup());

      dementiaAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaAddRadioItem3();
    }
    return dementiaAddRadioItem3;

  }

  /**
   * �Ō�E���z�u���Z���擾���܂��B
   * @return �Ō�E���z�u���Z
   */
  public ACValueArrayRadioButtonGroup getNurseStaffDispositionAddRadioGroup(){
    if(nurseStaffDispositionAddRadioGroup==null){

      nurseStaffDispositionAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNurseStaffDispositionAddRadioGroupContainer().setText("�Ō�E���z�u���Z");

      nurseStaffDispositionAddRadioGroup.setBindPath("1730108");

      nurseStaffDispositionAddRadioGroup.setNoSelectIndex(0);

      nurseStaffDispositionAddRadioGroup.setUseClearButton(false);

      nurseStaffDispositionAddRadioGroup.setModel(getNurseStaffDispositionAddRadioGroupModel());

      nurseStaffDispositionAddRadioGroup.setValues(new int[]{1,2,3});

      addNurseStaffDispositionAddRadioGroup();
    }
    return nurseStaffDispositionAddRadioGroup;

  }

  /**
   * �Ō�E���z�u���Z�R���e�i���擾���܂��B
   * @return �Ō�E���z�u���Z�R���e�i
   */
  protected ACLabelContainer getNurseStaffDispositionAddRadioGroupContainer(){
    if(nurseStaffDispositionAddRadioGroupContainer==null){
      nurseStaffDispositionAddRadioGroupContainer = new ACLabelContainer();
      nurseStaffDispositionAddRadioGroupContainer.setFollowChildEnabled(true);
      nurseStaffDispositionAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nurseStaffDispositionAddRadioGroupContainer.add(getNurseStaffDispositionAddRadioGroup(), null);
    }
    return nurseStaffDispositionAddRadioGroupContainer;
  }

  /**
   * �Ō�E���z�u���Z���f�����擾���܂��B
   * @return �Ō�E���z�u���Z���f��
   */
  protected ACListModelAdapter getNurseStaffDispositionAddRadioGroupModel(){
    if(nurseStaffDispositionAddRadioGroupModel==null){
      nurseStaffDispositionAddRadioGroupModel = new ACListModelAdapter();
      addNurseStaffDispositionAddRadioGroupModel();
    }
    return nurseStaffDispositionAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem1(){
    if(nurseStaffDispositionAddRadioItem1==null){

      nurseStaffDispositionAddRadioItem1 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem1.setText("�Ȃ�");

      nurseStaffDispositionAddRadioItem1.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem1();
    }
    return nurseStaffDispositionAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem2(){
    if(nurseStaffDispositionAddRadioItem2==null){

      nurseStaffDispositionAddRadioItem2 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem2.setText("I�^");

      nurseStaffDispositionAddRadioItem2.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem2();
    }
    return nurseStaffDispositionAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getNurseStaffDispositionAddRadioItem3(){
    if(nurseStaffDispositionAddRadioItem3==null){

      nurseStaffDispositionAddRadioItem3 = new ACRadioButtonItem();

      nurseStaffDispositionAddRadioItem3.setText("II�^");

      nurseStaffDispositionAddRadioItem3.setGroup(getNurseStaffDispositionAddRadioGroup());

      nurseStaffDispositionAddRadioItem3.setConstraints(VRLayout.FLOW);

      addNurseStaffDispositionAddRadioItem3();
    }
    return nurseStaffDispositionAddRadioItem3;

  }

  /**
   * ���ƊJ�n���x�����Z���擾���܂��B
   * @return ���ƊJ�n���x�����Z
   */
  public ACValueArrayRadioButtonGroup getProviderStartAddRadioGroup(){
    if(providerStartAddRadioGroup==null){

      providerStartAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderStartAddRadioGroupContainer().setText("���ƊJ�n���x�����Z");

      providerStartAddRadioGroup.setBindPath("1730109");

      providerStartAddRadioGroup.setNoSelectIndex(0);

      providerStartAddRadioGroup.setUseClearButton(false);

      providerStartAddRadioGroup.setModel(getProviderStartAddRadioGroupModel());

      providerStartAddRadioGroup.setValues(new int[]{1,2});

      addProviderStartAddRadioGroup();
    }
    return providerStartAddRadioGroup;

  }

  /**
   * ���ƊJ�n���x�����Z�R���e�i���擾���܂��B
   * @return ���ƊJ�n���x�����Z�R���e�i
   */
  protected ACLabelContainer getProviderStartAddRadioGroupContainer(){
    if(providerStartAddRadioGroupContainer==null){
      providerStartAddRadioGroupContainer = new ACLabelContainer();
      providerStartAddRadioGroupContainer.setFollowChildEnabled(true);
      providerStartAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerStartAddRadioGroupContainer.add(getProviderStartAddRadioGroup(), null);
    }
    return providerStartAddRadioGroupContainer;
  }

  /**
   * ���ƊJ�n���x�����Z���f�����擾���܂��B
   * @return ���ƊJ�n���x�����Z���f��
   */
  protected ACListModelAdapter getProviderStartAddRadioGroupModel(){
    if(providerStartAddRadioGroupModel==null){
      providerStartAddRadioGroupModel = new ACListModelAdapter();
      addProviderStartAddRadioGroupModel();
    }
    return providerStartAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getProviderStartAddRadioItem1(){
    if(providerStartAddRadioItem1==null){

      providerStartAddRadioItem1 = new ACRadioButtonItem();

      providerStartAddRadioItem1.setText("�Ȃ�");

      providerStartAddRadioItem1.setGroup(getProviderStartAddRadioGroup());

      providerStartAddRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderStartAddRadioItem1();
    }
    return providerStartAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getProviderStartAddRadioItem2(){
    if(providerStartAddRadioItem2==null){

      providerStartAddRadioItem2 = new ACRadioButtonItem();

      providerStartAddRadioItem2.setText("����");

      providerStartAddRadioItem2.setGroup(getProviderStartAddRadioGroup());

      providerStartAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addProviderStartAddRadioItem2();
    }
    return providerStartAddRadioItem2;

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
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1730110");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4});

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
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I�^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II�^");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("III�^");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * �s�����Ǝ����Z���擾���܂��B
   * @return �s�����Ǝ����Z
   */
  public ACComboBox getMunicipalityAdd(){
    if(municipalityAdd==null){

      municipalityAdd = new ACComboBox();

      getMunicipalityAddContainer().setText("�s�����Ǝ����Z");

      municipalityAdd.setBindPath("1730111");

      municipalityAdd.setEditable(false);

      municipalityAdd.setModelBindPath("1730111");

      municipalityAdd.setRenderBindPath("CONTENT");

      municipalityAdd.setBlankable(false);

      municipalityAdd.setModel(getMunicipalityAddModel());

      addMunicipalityAdd();
    }
    return municipalityAdd;

  }

  /**
   * �s�����Ǝ����Z�R���e�i���擾���܂��B
   * @return �s�����Ǝ����Z�R���e�i
   */
  protected ACLabelContainer getMunicipalityAddContainer(){
    if(municipalityAddContainer==null){
      municipalityAddContainer = new ACLabelContainer();
      municipalityAddContainer.setFollowChildEnabled(true);
      municipalityAddContainer.setVAlignment(VRLayout.CENTER);
      municipalityAddContainer.add(getMunicipalityAdd(), null);
    }
    return municipalityAddContainer;
  }

  /**
   * �s�����Ǝ����Z���f�����擾���܂��B
   * @return �s�����Ǝ����Z���f��
   */
  protected ACComboBoxModelAdapter getMunicipalityAddModel(){
    if(municipalityAddModel==null){
      municipalityAddModel = new ACComboBoxModelAdapter();
      addMunicipalityAddModel();
    }
    return municipalityAddModel;
  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACValueArrayRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionContainer().setText("�Z��敪");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      calculationDivision.setValues(new int[]{1,2});

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * �Z��敪�R���e�i���擾���܂��B
   * @return �Z��敪�R���e�i
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * �Z��敪���f�����擾���܂��B
   * @return �Z��敪���f��
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getCalculationDivisionItem1(){
    if(calculationDivisionItem1==null){

      calculationDivisionItem1 = new ACRadioButtonItem();

      calculationDivisionItem1.setText("�ʏ�");

      calculationDivisionItem1.setGroup(getCalculationDivision());

      calculationDivisionItem1.setConstraints(VRLayout.FLOW);

      addCalculationDivisionItem1();
    }
    return calculationDivisionItem1;

  }

  /**
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getCalculationDivisionItem2(){
    if(calculationDivisionItem2==null){

      calculationDivisionItem2 = new ACRadioButtonItem();

      calculationDivisionItem2.setText("���Z�̂�");

      calculationDivisionItem2.setGroup(getCalculationDivision());

      calculationDivisionItem2.setConstraints(VRLayout.FLOW);

      addCalculationDivisionItem2();
    }
    return calculationDivisionItem2;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("����");

      crackOnDayCheck.setBindPath("1730103");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * �񋟓����擾���܂��B
   * @return �񋟓�
   */
  public ACIntegerCheckBox getPrintable(){
    if(printable==null){

      printable = new ACIntegerCheckBox();

      printable.setText("�񋟓�");

      printable.setBindPath("15");

      printable.setSelectValue(2);

      printable.setUnSelectValue(1);

      addPrintable();
    }
    return printable;

  }

  /**
   * ���x�������R���e�i���擾���܂��B
   * @return ���x�������R���e�i
   */
  public ACGroupBox getKaigoSupportSpecialMemberContainer(){
    if(kaigoSupportSpecialMemberContainer==null){

      kaigoSupportSpecialMemberContainer = new ACGroupBox();

      kaigoSupportSpecialMemberContainer.setText("���x���������");

      kaigoSupportSpecialMemberContainer.setFollowChildEnabled(true);

      addKaigoSupportSpecialMemberContainer();
    }
    return kaigoSupportSpecialMemberContainer;

  }

  /**
   * ���x�������ԍ����擾���܂��B
   * @return ���x�������ԍ�
   */
  public ACTextField getKaigoSupportSpecialMemberNumber(){
    if(kaigoSupportSpecialMemberNumber==null){

      kaigoSupportSpecialMemberNumber = new ACTextField();

      getKaigoSupportSpecialMemberNumberContainer().setText("���x�������ԍ�");

      kaigoSupportSpecialMemberNumber.setBindPath("1730104");

      kaigoSupportSpecialMemberNumber.setColumns(6);

      kaigoSupportSpecialMemberNumber.setCharType(VRCharType.ONLY_DIGIT);

      kaigoSupportSpecialMemberNumber.setMaxLength(8);

      addKaigoSupportSpecialMemberNumber();
    }
    return kaigoSupportSpecialMemberNumber;

  }

  /**
   * ���x�������ԍ��R���e�i���擾���܂��B
   * @return ���x�������ԍ��R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNumberContainer(){
    if(kaigoSupportSpecialMemberNumberContainer==null){
      kaigoSupportSpecialMemberNumberContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNumberContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNumberContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNumberContainer.add(getKaigoSupportSpecialMemberNumber(), null);
    }
    return kaigoSupportSpecialMemberNumberContainer;
  }

  /**
   * ���x�������������擾���܂��B
   * @return ���x����������
   */
  public ACComboBox getKaigoSupportSpecialMemberName(){
    if(kaigoSupportSpecialMemberName==null){

      kaigoSupportSpecialMemberName = new ACComboBox();

      getKaigoSupportSpecialMemberNameContainer().setText("���x����������");

      kaigoSupportSpecialMemberName.setEditable(false);

      kaigoSupportSpecialMemberName.setRenderBindPath("STAFF_NAME");

      kaigoSupportSpecialMemberName.setMaxColumns(10);

      kaigoSupportSpecialMemberName.setModel(getKaigoSupportSpecialMemberNameModel());

      addKaigoSupportSpecialMemberName();
    }
    return kaigoSupportSpecialMemberName;

  }

  /**
   * ���x�����������R���e�i���擾���܂��B
   * @return ���x�����������R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNameContainer(){
    if(kaigoSupportSpecialMemberNameContainer==null){
      kaigoSupportSpecialMemberNameContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNameContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNameContainer.add(getKaigoSupportSpecialMemberName(), null);
    }
    return kaigoSupportSpecialMemberNameContainer;
  }

  /**
   * ���x�������������f�����擾���܂��B
   * @return ���x�������������f��
   */
  protected ACComboBoxModelAdapter getKaigoSupportSpecialMemberNameModel(){
    if(kaigoSupportSpecialMemberNameModel==null){
      kaigoSupportSpecialMemberNameModel = new ACComboBoxModelAdapter();
      addKaigoSupportSpecialMemberNameModel();
    }
    return kaigoSupportSpecialMemberNameModel;
  }

  /**
   * �E�v�������O���[�v���擾���܂��B
   * @return �E�v�������O���[�v
   */
  public ACGroupBox getTekiyouGroup(){
    if(tekiyouGroup==null){

      tekiyouGroup = new ACGroupBox();

      tekiyouGroup.setText("�E�v��");

      tekiyouGroup.setVisible(true);

      tekiyouGroup.setEnabled(true);

      tekiyouGroup.setFollowChildEnabled(true);

      tekiyouGroup.setHgap(0);

      tekiyouGroup.setLabelMargin(0);

      tekiyouGroup.setVgap(0);

      addTekiyouGroup();
    }
    return tekiyouGroup;

  }

  /**
   * �E�v���e�L�X�g���擾���܂��B
   * @return �E�v���e�L�X�g
   */
  public ACTextField getTekiyouText(){
    if(tekiyouText==null){

      tekiyouText = new ACTextField();

      getTekiyouTextContainer().setText("�ʏ��K��h������");

      tekiyouText.setBindPath("1730105");

      tekiyouText.setVisible(true);

      tekiyouText.setEnabled(true);

      tekiyouText.setEditable(true);

      tekiyouText.setColumns(5);

      tekiyouText.setCharType(VRCharType.ONLY_DIGIT);

      tekiyouText.setHorizontalAlignment(SwingConstants.LEFT);

      tekiyouText.setIMEMode(InputSubset.LATIN);

      tekiyouText.setMaxLength(6);

      addTekiyouText();
    }
    return tekiyouText;

  }

  /**
   * �E�v���e�L�X�g�R���e�i���擾���܂��B
   * @return �E�v���e�L�X�g�R���e�i
   */
  protected ACLabelContainer getTekiyouTextContainer(){
    if(tekiyouTextContainer==null){
      tekiyouTextContainer = new ACLabelContainer();
      tekiyouTextContainer.setFollowChildEnabled(true);
      tekiyouTextContainer.setVAlignment(VRLayout.CENTER);
      tekiyouTextContainer.add(getTekiyouText(), null);
    }
    return tekiyouTextContainer;
  }

  /**
   * �E�v���������x�����擾���܂��B
   * @return �E�v���������x��
   */
  public ACLabel getTekiyouCommentTitle(){
    if(tekiyouCommentTitle==null){

      tekiyouCommentTitle = new ACLabel();

      tekiyouCommentTitle.setText("���̈�ԍŏ��̗��p���ɋL�����Ă��������B");

      tekiyouCommentTitle.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      tekiyouCommentTitle.setAutoWrap(true);

      addTekiyouCommentTitle();
    }
    return tekiyouCommentTitle;

  }

  /**
   * ���ӏ����O���[�v���擾���܂��B
   * @return ���ӏ����O���[�v
   */
  public ACGroupBox getInfoGroup(){
    if(infoGroup==null){

      infoGroup = new ACGroupBox();

      infoGroup.setFollowChildEnabled(true);

      infoGroup.setHgap(0);

      infoGroup.setLabelMargin(0);

      infoGroup.setVgap(0);

      addInfoGroup();
    }
    return infoGroup;

  }

  /**
   * ���ӏ������x�����擾���܂��B
   * @return ���ӏ������x��
   */
  public ACLabel getInfoLabel(){
    if(infoLabel==null){

      infoLabel = new ACLabel();

      infoLabel.setText("���r���ŗv����ԋ敪���ύX�ɂȂ�ꍇ�́A" + ACConstants.LINE_SEPARATOR + "�e������T�[�r�X��S�Ă̓����ɓ\��t���A" + ACConstants.LINE_SEPARATOR + "���ۂ̒񋟓��ɂ́w�񋟓��x�̃`�F�b�N����" + ACConstants.LINE_SEPARATOR + "�k�ݒ�l�{�^�����N���b�N���Ă��������B");

      addInfoLabel();
    }
    return infoLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_17311_201204Design() {

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

    this.add(getRegionSmallscaleMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * �n�斧�����K�͑��@�\�^���p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionSmallscaleMultiPatterns(){

    regionSmallscaleMultiPatterns.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getInitialAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSmallServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNurseStaffDispositionAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getProviderStartAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonNeededRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioModel(){

    getInitialAddRadioItem1().setButtonIndex(1);

    getInitialAddRadioModel().add(getInitialAddRadioItem1());

    getInitialAddRadioItem2().setButtonIndex(2);

    getInitialAddRadioModel().add(getInitialAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioItem2(){

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadio(){

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadioModel(){

    getSmallServiceRadioItem1().setButtonIndex(1);

    getSmallServiceRadioModel().add(getSmallServiceRadioItem1());

    getSmallServiceRadioItem2().setButtonIndex(2);

    getSmallServiceRadioModel().add(getSmallServiceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSmallServiceRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioModel(){

    getStaffSubtractionRadioItem1().setButtonIndex(1);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem1());

    getStaffSubtractionRadioItem2().setButtonIndex(2);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem2());

    getStaffSubtractionRadioItem3().setButtonIndex(3);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem2(){

  }

  /**
   * �]�Ǝ҂̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem3(){

  }

  /**
   * �F�m�ǉ��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioGroup(){

  }

  /**
   * �F�m�ǉ��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioGroupModel(){

    getDementiaAddRadioItem1().setButtonIndex(1);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem1());

    getDementiaAddRadioItem2().setButtonIndex(2);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem2());

    getDementiaAddRadioItem3().setButtonIndex(3);

    getDementiaAddRadioGroupModel().add(getDementiaAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddRadioItem3(){

  }

  /**
   * �Ō�E���z�u���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioGroup(){

  }

  /**
   * �Ō�E���z�u���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioGroupModel(){

    getNurseStaffDispositionAddRadioItem1().setButtonIndex(1);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem1());

    getNurseStaffDispositionAddRadioItem2().setButtonIndex(2);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem2());

    getNurseStaffDispositionAddRadioItem3().setButtonIndex(3);

    getNurseStaffDispositionAddRadioGroupModel().add(getNurseStaffDispositionAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNurseStaffDispositionAddRadioItem3(){

  }

  /**
   * ���ƊJ�n���x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStartAddRadioGroup(){

  }

  /**
   * ���ƊJ�n���x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStartAddRadioGroupModel(){

    getProviderStartAddRadioItem1().setButtonIndex(1);

    getProviderStartAddRadioGroupModel().add(getProviderStartAddRadioItem1());

    getProviderStartAddRadioItem2().setButtonIndex(2);

    getProviderStartAddRadioGroupModel().add(getProviderStartAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStartAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStartAddRadioItem2(){

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

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * �s�����Ǝ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMunicipalityAdd(){

  }

  /**
   * �s�����Ǝ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMunicipalityAddModel(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCrackOnDayCheck(), VRLayout.FLOW_INSETLINE);

    tab2.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab2.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW_RETURN);

    tab2.add(getTekiyouGroup(), VRLayout.FLOW_RETURN);

    tab2.add(getInfoGroup(), VRLayout.FLOW);

  }

  /**
   * �Z��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivision(){

  }

  /**
   * �Z��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionItem1().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionItem1());

    getCalculationDivisionItem2().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionItem2());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionItem1(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionItem2(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCrackOnDayCheck(){

  }

  /**
   * �񋟓��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintable(){

  }

  /**
   * ���x�������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberContainer(){

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNumberContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberNumber(){

  }

  /**
   * ���x�����������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberName(){

  }

  /**
   * ���x�������������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberNameModel(){

  }

  /**
   * �E�v�������O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouGroup(){

    tekiyouGroup.add(getTekiyouTextContainer(), VRLayout.FLOW_RETURN);

    tekiyouGroup.add(getTekiyouCommentTitle(), VRLayout.FLOW_RETURN);

  }

  /**
   * �E�v���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouText(){

  }

  /**
   * �E�v���������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouCommentTitle(){

  }

  /**
   * ���ӏ����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoGroup(){

    infoGroup.add(getInfoLabel(), VRLayout.FLOW);

  }

  /**
   * ���ӏ������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoLabel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_17311_201204Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_17311_201204Design getThis() {
    return this;
  }
}
