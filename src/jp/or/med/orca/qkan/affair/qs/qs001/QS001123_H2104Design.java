
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
 * �J����: �c���@����
 * �쐬��: 2009/08/26  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
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
/**
 * �T�[�r�X�p�^�[����ԑΉ��^�K�����ʍ��ڃf�U�C��(QS001123_H2104) 
 */
public class QS001123_H2104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel nightTypeVisitCarePatterns;

  private ACClearableRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACClearableRadioButtonGroup serviceDivisionRadio;

  private ACLabelContainer serviceDivisionRadioContainer;

  private ACListModelAdapter serviceDivisionRadioModel;

  private ACRadioButtonItem serviceDivisionRadioItem1;

  private ACRadioButtonItem serviceDivisionRadioItem2;

  private ACClearableRadioButtonGroup anytimeCorrespondenceTypeRadio;

  private ACLabelContainer anytimeCorrespondenceTypeRadioContainer;

  private ACListModelAdapter anytimeCorrespondenceTypeRadioModel;

  private ACRadioButtonItem anytimeCorrespondenceTypeRadioItem1;

  private ACRadioButtonItem anytimeCorrespondenceTypeRadioItem2;

  private ACClearableRadioButtonGroup classEmploymentRadio;

  private ACLabelContainer classEmploymentRadioContainer;

  private ACListModelAdapter classEmploymentRadioModel;

  private ACRadioButtonItem classEmploymentRadioItem1;

  private ACRadioButtonItem classEmploymentRadioItem2;

  private ACValueArrayRadioButtonGroup hours24MessageAddRadioGroup;

  private ACLabelContainer hours24MessageAddRadioGroupContainer;

  private ACListModelAdapter hours24MessageAddRadioGroupModel;

  private ACRadioButtonItem hours24MessageAddRadioItem1;

  private ACRadioButtonItem hours24MessageAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACComboBox baseMunicipalityAdd;

  private ACLabelContainer baseMunicipalityAddContainer;

  private ACComboBoxModelAdapter baseMunicipalityAddModel;

  private ACComboBox serviceMunicipalityAdd;

  private ACLabelContainer serviceMunicipalityAddContainer;

  private ACComboBoxModelAdapter serviceMunicipalityAddModel;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionBasicOnly;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACBackLabelContainer yakanHoumonKaigoTimeContainer;

  private ACTimeComboBox yakanHoumonKaigoBeginTime;

  private ACLabelContainer yakanHoumonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter yakanHoumonKaigoBeginTimeModel;

  private ACTimeComboBox yakanHoumonKaigoEndTime;

  private ACLabelContainer yakanHoumonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter yakanHoumonKaigoEndTimeModel;

  //getter

  /**
   * ��ԑΉ��^�K����p�^�[���̈���擾���܂��B
   * @return ��ԑΉ��^�K����p�^�[���̈�
   */
  public ACPanel getNightTypeVisitCarePatterns(){
    if(nightTypeVisitCarePatterns==null){

      nightTypeVisitCarePatterns = new ACPanel();

      nightTypeVisitCarePatterns.setAutoWrap(false);

      nightTypeVisitCarePatterns.setHgrid(200);

      addNightTypeVisitCarePatterns();
    }
    return nightTypeVisitCarePatterns;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACClearableRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACClearableRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("�{�ݓ��̋敪");

      providerDivisionRadio.setBindPath("1710101");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

      addProviderDivisionRadio();
    }
    return providerDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  protected ACLabelContainer getProviderDivisionRadioContainer(){
    if(providerDivisionRadioContainer==null){
      providerDivisionRadioContainer = new ACLabelContainer();
      providerDivisionRadioContainer.setFollowChildEnabled(true);
      providerDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      providerDivisionRadioContainer.add(getProviderDivisionRadio(), null);
    }
    return providerDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪���f�����擾���܂��B
   * @return �{�ݓ��̋敪���f��
   */
  protected ACListModelAdapter getProviderDivisionRadioModel(){
    if(providerDivisionRadioModel==null){
      providerDivisionRadioModel = new ACListModelAdapter();
      addProviderDivisionRadioModel();
    }
    return providerDivisionRadioModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getProviderDivisionRadioItem1(){
    if(providerDivisionRadioItem1==null){

      providerDivisionRadioItem1 = new ACRadioButtonItem();

      providerDivisionRadioItem1.setText("I�^");

      providerDivisionRadioItem1.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem1();
    }
    return providerDivisionRadioItem1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getProviderDivisionRadioItem2(){
    if(providerDivisionRadioItem2==null){

      providerDivisionRadioItem2 = new ACRadioButtonItem();

      providerDivisionRadioItem2.setText("II�^");

      providerDivisionRadioItem2.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem2();
    }
    return providerDivisionRadioItem2;

  }

  /**
   * �T�[�r�X�敪���擾���܂��B
   * @return �T�[�r�X�敪
   */
  public ACClearableRadioButtonGroup getServiceDivisionRadio(){
    if(serviceDivisionRadio==null){

      serviceDivisionRadio = new ACClearableRadioButtonGroup();

      getServiceDivisionRadioContainer().setText("�T�[�r�X�敪");

      serviceDivisionRadio.setBindPath("1710102");

      serviceDivisionRadio.setUseClearButton(false);

      serviceDivisionRadio.setModel(getServiceDivisionRadioModel());

      addServiceDivisionRadio();
    }
    return serviceDivisionRadio;

  }

  /**
   * �T�[�r�X�敪�R���e�i���擾���܂��B
   * @return �T�[�r�X�敪�R���e�i
   */
  protected ACLabelContainer getServiceDivisionRadioContainer(){
    if(serviceDivisionRadioContainer==null){
      serviceDivisionRadioContainer = new ACLabelContainer();
      serviceDivisionRadioContainer.setFollowChildEnabled(true);
      serviceDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      serviceDivisionRadioContainer.add(getServiceDivisionRadio(), null);
    }
    return serviceDivisionRadioContainer;
  }

  /**
   * �T�[�r�X�敪���f�����擾���܂��B
   * @return �T�[�r�X�敪���f��
   */
  protected ACListModelAdapter getServiceDivisionRadioModel(){
    if(serviceDivisionRadioModel==null){
      serviceDivisionRadioModel = new ACListModelAdapter();
      addServiceDivisionRadioModel();
    }
    return serviceDivisionRadioModel;
  }

  /**
   * �������^���擾���܂��B
   * @return �������^
   */
  public ACRadioButtonItem getServiceDivisionRadioItem1(){
    if(serviceDivisionRadioItem1==null){

      serviceDivisionRadioItem1 = new ACRadioButtonItem();

      serviceDivisionRadioItem1.setText("�������^");

      serviceDivisionRadioItem1.setGroup(getServiceDivisionRadio());

      serviceDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceDivisionRadioItem1();
    }
    return serviceDivisionRadioItem1;

  }

  /**
   * �����Ή��^���擾���܂��B
   * @return �����Ή��^
   */
  public ACRadioButtonItem getServiceDivisionRadioItem2(){
    if(serviceDivisionRadioItem2==null){

      serviceDivisionRadioItem2 = new ACRadioButtonItem();

      serviceDivisionRadioItem2.setText("�����Ή��^");

      serviceDivisionRadioItem2.setGroup(getServiceDivisionRadio());

      serviceDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceDivisionRadioItem2();
    }
    return serviceDivisionRadioItem2;

  }

  /**
   * �Ή��l�����擾���܂��B
   * @return �Ή��l��
   */
  public ACClearableRadioButtonGroup getAnytimeCorrespondenceTypeRadio(){
    if(anytimeCorrespondenceTypeRadio==null){

      anytimeCorrespondenceTypeRadio = new ACClearableRadioButtonGroup();

      getAnytimeCorrespondenceTypeRadioContainer().setText("�Ή��l��");

      anytimeCorrespondenceTypeRadio.setBindPath("1710104");

      anytimeCorrespondenceTypeRadio.setUseClearButton(false);

      anytimeCorrespondenceTypeRadio.setModel(getAnytimeCorrespondenceTypeRadioModel());

      addAnytimeCorrespondenceTypeRadio();
    }
    return anytimeCorrespondenceTypeRadio;

  }

  /**
   * �Ή��l���R���e�i���擾���܂��B
   * @return �Ή��l���R���e�i
   */
  protected ACLabelContainer getAnytimeCorrespondenceTypeRadioContainer(){
    if(anytimeCorrespondenceTypeRadioContainer==null){
      anytimeCorrespondenceTypeRadioContainer = new ACLabelContainer();
      anytimeCorrespondenceTypeRadioContainer.setFollowChildEnabled(true);
      anytimeCorrespondenceTypeRadioContainer.setVAlignment(VRLayout.CENTER);
      anytimeCorrespondenceTypeRadioContainer.add(getAnytimeCorrespondenceTypeRadio(), null);
    }
    return anytimeCorrespondenceTypeRadioContainer;
  }

  /**
   * �Ή��l�����f�����擾���܂��B
   * @return �Ή��l�����f��
   */
  protected ACListModelAdapter getAnytimeCorrespondenceTypeRadioModel(){
    if(anytimeCorrespondenceTypeRadioModel==null){
      anytimeCorrespondenceTypeRadioModel = new ACListModelAdapter();
      addAnytimeCorrespondenceTypeRadioModel();
    }
    return anytimeCorrespondenceTypeRadioModel;
  }

  /**
   * 1�l�Ή����擾���܂��B
   * @return 1�l�Ή�
   */
  public ACRadioButtonItem getAnytimeCorrespondenceTypeRadioItem1(){
    if(anytimeCorrespondenceTypeRadioItem1==null){

      anytimeCorrespondenceTypeRadioItem1 = new ACRadioButtonItem();

      anytimeCorrespondenceTypeRadioItem1.setText("1�l�Ή�");

      anytimeCorrespondenceTypeRadioItem1.setGroup(getAnytimeCorrespondenceTypeRadio());

      anytimeCorrespondenceTypeRadioItem1.setConstraints(VRLayout.FLOW);

      addAnytimeCorrespondenceTypeRadioItem1();
    }
    return anytimeCorrespondenceTypeRadioItem1;

  }

  /**
   * 2�l�Ή����擾���܂��B
   * @return 2�l�Ή�
   */
  public ACRadioButtonItem getAnytimeCorrespondenceTypeRadioItem2(){
    if(anytimeCorrespondenceTypeRadioItem2==null){

      anytimeCorrespondenceTypeRadioItem2 = new ACRadioButtonItem();

      anytimeCorrespondenceTypeRadioItem2.setText("2�l�Ή�");

      anytimeCorrespondenceTypeRadioItem2.setGroup(getAnytimeCorrespondenceTypeRadio());

      anytimeCorrespondenceTypeRadioItem2.setConstraints(VRLayout.FLOW);

      addAnytimeCorrespondenceTypeRadioItem2();
    }
    return anytimeCorrespondenceTypeRadioItem2;

  }

  /**
   * �K��҂̋��E���擾���܂��B
   * @return �K��҂̋��E
   */
  public ACClearableRadioButtonGroup getClassEmploymentRadio(){
    if(classEmploymentRadio==null){

      classEmploymentRadio = new ACClearableRadioButtonGroup();

      getClassEmploymentRadioContainer().setText("�K��҂̋��E");

      classEmploymentRadio.setBindPath("1710105");

      classEmploymentRadio.setUseClearButton(false);

      classEmploymentRadio.setModel(getClassEmploymentRadioModel());

      addClassEmploymentRadio();
    }
    return classEmploymentRadio;

  }

  /**
   * �K��҂̋��E�R���e�i���擾���܂��B
   * @return �K��҂̋��E�R���e�i
   */
  protected ACLabelContainer getClassEmploymentRadioContainer(){
    if(classEmploymentRadioContainer==null){
      classEmploymentRadioContainer = new ACLabelContainer();
      classEmploymentRadioContainer.setFollowChildEnabled(true);
      classEmploymentRadioContainer.setVAlignment(VRLayout.CENTER);
      classEmploymentRadioContainer.add(getClassEmploymentRadio(), null);
    }
    return classEmploymentRadioContainer;
  }

  /**
   * �K��҂̋��E���f�����擾���܂��B
   * @return �K��҂̋��E���f��
   */
  protected ACListModelAdapter getClassEmploymentRadioModel(){
    if(classEmploymentRadioModel==null){
      classEmploymentRadioModel = new ACListModelAdapter();
      addClassEmploymentRadioModel();
    }
    return classEmploymentRadioModel;
  }

  /**
   * 3���ȊO���擾���܂��B
   * @return 3���ȊO
   */
  public ACRadioButtonItem getClassEmploymentRadioItem1(){
    if(classEmploymentRadioItem1==null){

      classEmploymentRadioItem1 = new ACRadioButtonItem();

      classEmploymentRadioItem1.setText("3���ȊO");

      classEmploymentRadioItem1.setGroup(getClassEmploymentRadio());

      classEmploymentRadioItem1.setConstraints(VRLayout.FLOW);

      addClassEmploymentRadioItem1();
    }
    return classEmploymentRadioItem1;

  }

  /**
   * 3�����擾���܂��B
   * @return 3��
   */
  public ACRadioButtonItem getClassEmploymentRadioItem2(){
    if(classEmploymentRadioItem2==null){

      classEmploymentRadioItem2 = new ACRadioButtonItem();

      classEmploymentRadioItem2.setText("3��");

      classEmploymentRadioItem2.setGroup(getClassEmploymentRadio());

      classEmploymentRadioItem2.setConstraints(VRLayout.FLOW);

      addClassEmploymentRadioItem2();
    }
    return classEmploymentRadioItem2;

  }

  /**
   * 24���Ԓʕ�Ή����Z���擾���܂��B
   * @return 24���Ԓʕ�Ή����Z
   */
  public ACValueArrayRadioButtonGroup getHours24MessageAddRadioGroup(){
    if(hours24MessageAddRadioGroup==null){

      hours24MessageAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHours24MessageAddRadioGroupContainer().setText("24���Ԓʕ�Ή����Z");

      hours24MessageAddRadioGroup.setBindPath("1710107");

      hours24MessageAddRadioGroup.setVisible(true);

      hours24MessageAddRadioGroup.setEnabled(true);

      hours24MessageAddRadioGroup.setNoSelectIndex(0);

      hours24MessageAddRadioGroup.setUseClearButton(false);

      hours24MessageAddRadioGroup.setModel(getHours24MessageAddRadioGroupModel());

      hours24MessageAddRadioGroup.setValues(new int[]{1,2});

      addHours24MessageAddRadioGroup();
    }
    return hours24MessageAddRadioGroup;

  }

  /**
   * 24���Ԓʕ�Ή����Z�R���e�i���擾���܂��B
   * @return 24���Ԓʕ�Ή����Z�R���e�i
   */
  protected ACLabelContainer getHours24MessageAddRadioGroupContainer(){
    if(hours24MessageAddRadioGroupContainer==null){
      hours24MessageAddRadioGroupContainer = new ACLabelContainer();
      hours24MessageAddRadioGroupContainer.setFollowChildEnabled(true);
      hours24MessageAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      hours24MessageAddRadioGroupContainer.add(getHours24MessageAddRadioGroup(), null);
    }
    return hours24MessageAddRadioGroupContainer;
  }

  /**
   * 24���Ԓʕ�Ή����Z���f�����擾���܂��B
   * @return 24���Ԓʕ�Ή����Z���f��
   */
  protected ACListModelAdapter getHours24MessageAddRadioGroupModel(){
    if(hours24MessageAddRadioGroupModel==null){
      hours24MessageAddRadioGroupModel = new ACListModelAdapter();
      addHours24MessageAddRadioGroupModel();
    }
    return hours24MessageAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHours24MessageAddRadioItem1(){
    if(hours24MessageAddRadioItem1==null){

      hours24MessageAddRadioItem1 = new ACRadioButtonItem();

      hours24MessageAddRadioItem1.setText("�Ȃ�");

      hours24MessageAddRadioItem1.setGroup(getHours24MessageAddRadioGroup());

      hours24MessageAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHours24MessageAddRadioItem1();
    }
    return hours24MessageAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHours24MessageAddRadioItem2(){
    if(hours24MessageAddRadioItem2==null){

      hours24MessageAddRadioItem2 = new ACRadioButtonItem();

      hours24MessageAddRadioItem2.setText("����");

      hours24MessageAddRadioItem2.setGroup(getHours24MessageAddRadioGroup());

      hours24MessageAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHours24MessageAddRadioItem2();
    }
    return hours24MessageAddRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1710108");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3});

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

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

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
   * ��{��ԖK�� I �s�����Ǝ����Z���擾���܂��B
   * @return ��{��ԖK�� I �s�����Ǝ����Z
   */
  public ACComboBox getBaseMunicipalityAdd(){
    if(baseMunicipalityAdd==null){

      baseMunicipalityAdd = new ACComboBox();

      getBaseMunicipalityAddContainer().setText("��{��ԖK�� I �s�����Ǝ����Z");

      baseMunicipalityAdd.setBindPath("1710109");

      baseMunicipalityAdd.setEditable(false);

      baseMunicipalityAdd.setModelBindPath("1710109");

      baseMunicipalityAdd.setRenderBindPath("CONTENT");

      baseMunicipalityAdd.setBlankable(false);

      baseMunicipalityAdd.setModel(getBaseMunicipalityAddModel());

      addBaseMunicipalityAdd();
    }
    return baseMunicipalityAdd;

  }

  /**
   * ��{��ԖK�� I �s�����Ǝ����Z�R���e�i���擾���܂��B
   * @return ��{��ԖK�� I �s�����Ǝ����Z�R���e�i
   */
  protected ACLabelContainer getBaseMunicipalityAddContainer(){
    if(baseMunicipalityAddContainer==null){
      baseMunicipalityAddContainer = new ACLabelContainer();
      baseMunicipalityAddContainer.setFollowChildEnabled(true);
      baseMunicipalityAddContainer.setVAlignment(VRLayout.CENTER);
      baseMunicipalityAddContainer.add(getBaseMunicipalityAdd(), null);
    }
    return baseMunicipalityAddContainer;
  }

  /**
   * ��{��ԖK�� I �s�����Ǝ����Z���f�����擾���܂��B
   * @return ��{��ԖK�� I �s�����Ǝ����Z���f��
   */
  protected ACComboBoxModelAdapter getBaseMunicipalityAddModel(){
    if(baseMunicipalityAddModel==null){
      baseMunicipalityAddModel = new ACComboBoxModelAdapter();
      addBaseMunicipalityAddModel();
    }
    return baseMunicipalityAddModel;
  }

  /**
   * ��ԖK���� II �s�����Ǝ����Z���擾���܂��B
   * @return ��ԖK���� II �s�����Ǝ����Z
   */
  public ACComboBox getServiceMunicipalityAdd(){
    if(serviceMunicipalityAdd==null){

      serviceMunicipalityAdd = new ACComboBox();

      getServiceMunicipalityAddContainer().setText("��ԖK���� II �s�����Ǝ����Z");

      serviceMunicipalityAdd.setBindPath("1710110");

      serviceMunicipalityAdd.setEditable(false);

      serviceMunicipalityAdd.setModelBindPath("1710110");

      serviceMunicipalityAdd.setRenderBindPath("CONTENT");

      serviceMunicipalityAdd.setBlankable(false);

      serviceMunicipalityAdd.setModel(getServiceMunicipalityAddModel());

      addServiceMunicipalityAdd();
    }
    return serviceMunicipalityAdd;

  }

  /**
   * ��ԖK���� II �s�����Ǝ����Z�R���e�i���擾���܂��B
   * @return ��ԖK���� II �s�����Ǝ����Z�R���e�i
   */
  protected ACLabelContainer getServiceMunicipalityAddContainer(){
    if(serviceMunicipalityAddContainer==null){
      serviceMunicipalityAddContainer = new ACLabelContainer();
      serviceMunicipalityAddContainer.setFollowChildEnabled(true);
      serviceMunicipalityAddContainer.setVAlignment(VRLayout.CENTER);
      serviceMunicipalityAddContainer.add(getServiceMunicipalityAdd(), null);
    }
    return serviceMunicipalityAddContainer;
  }

  /**
   * ��ԖK���� II �s�����Ǝ����Z���f�����擾���܂��B
   * @return ��ԖK���� II �s�����Ǝ����Z���f��
   */
  protected ACComboBoxModelAdapter getServiceMunicipalityAddModel(){
    if(serviceMunicipalityAddModel==null){
      serviceMunicipalityAddModel = new ACComboBoxModelAdapter();
      addServiceMunicipalityAddModel();
    }
    return serviceMunicipalityAddModel;
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

      calculationDivision.setValues(new int[]{1,3});

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
  public ACRadioButtonItem getCalculationDivisionNormal(){
    if(calculationDivisionNormal==null){

      calculationDivisionNormal = new ACRadioButtonItem();

      calculationDivisionNormal.setText("�ʏ�");

      calculationDivisionNormal.setGroup(getCalculationDivision());

      calculationDivisionNormal.setConstraints(VRLayout.FLOW);

      addCalculationDivisionNormal();
    }
    return calculationDivisionNormal;

  }

  /**
   * ��{�݂̂��擾���܂��B
   * @return ��{�̂�
   */
  public ACRadioButtonItem getCalculationDivisionBasicOnly(){
    if(calculationDivisionBasicOnly==null){

      calculationDivisionBasicOnly = new ACRadioButtonItem();

      calculationDivisionBasicOnly.setText("��{�̂�");

      calculationDivisionBasicOnly.setGroup(getCalculationDivision());

      calculationDivisionBasicOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionBasicOnly();
    }
    return calculationDivisionBasicOnly;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("����");

      crackOnDayCheck.setBindPath("1710106");

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
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getYakanHoumonKaigoTimeContainer(){
    if(yakanHoumonKaigoTimeContainer==null){

      yakanHoumonKaigoTimeContainer = new ACBackLabelContainer();

      addYakanHoumonKaigoTimeContainer();
    }
    return yakanHoumonKaigoTimeContainer;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getYakanHoumonKaigoBeginTime(){
    if(yakanHoumonKaigoBeginTime==null){

      yakanHoumonKaigoBeginTime = new ACTimeComboBox();

      getYakanHoumonKaigoBeginTimeContainer().setText("�J�n����");

      yakanHoumonKaigoBeginTime.setBindPath("3");

      yakanHoumonKaigoBeginTime.setModelBindPath("3");

      yakanHoumonKaigoBeginTime.setRenderBindPath("CONTENT");

      yakanHoumonKaigoBeginTime.setModel(getYakanHoumonKaigoBeginTimeModel());

      addYakanHoumonKaigoBeginTime();
    }
    return yakanHoumonKaigoBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getYakanHoumonKaigoBeginTimeContainer(){
    if(yakanHoumonKaigoBeginTimeContainer==null){
      yakanHoumonKaigoBeginTimeContainer = new ACLabelContainer();
      yakanHoumonKaigoBeginTimeContainer.setFollowChildEnabled(true);
      yakanHoumonKaigoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      yakanHoumonKaigoBeginTimeContainer.add(getYakanHoumonKaigoBeginTime(), null);
    }
    return yakanHoumonKaigoBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getYakanHoumonKaigoBeginTimeModel(){
    if(yakanHoumonKaigoBeginTimeModel==null){
      yakanHoumonKaigoBeginTimeModel = new ACComboBoxModelAdapter();
      addYakanHoumonKaigoBeginTimeModel();
    }
    return yakanHoumonKaigoBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getYakanHoumonKaigoEndTime(){
    if(yakanHoumonKaigoEndTime==null){

      yakanHoumonKaigoEndTime = new ACTimeComboBox();

      getYakanHoumonKaigoEndTimeContainer().setText("�I������");

      yakanHoumonKaigoEndTime.setBindPath("4");

      yakanHoumonKaigoEndTime.setModelBindPath("4");

      yakanHoumonKaigoEndTime.setRenderBindPath("CONTENT");

      yakanHoumonKaigoEndTime.setModel(getYakanHoumonKaigoEndTimeModel());

      addYakanHoumonKaigoEndTime();
    }
    return yakanHoumonKaigoEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getYakanHoumonKaigoEndTimeContainer(){
    if(yakanHoumonKaigoEndTimeContainer==null){
      yakanHoumonKaigoEndTimeContainer = new ACLabelContainer();
      yakanHoumonKaigoEndTimeContainer.setFollowChildEnabled(true);
      yakanHoumonKaigoEndTimeContainer.setVAlignment(VRLayout.CENTER);
      yakanHoumonKaigoEndTimeContainer.add(getYakanHoumonKaigoEndTime(), null);
    }
    return yakanHoumonKaigoEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getYakanHoumonKaigoEndTimeModel(){
    if(yakanHoumonKaigoEndTimeModel==null){
      yakanHoumonKaigoEndTimeModel = new ACComboBoxModelAdapter();
      addYakanHoumonKaigoEndTimeModel();
    }
    return yakanHoumonKaigoEndTimeModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001123_H2104Design() {

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

    this.add(getNightTypeVisitCarePatterns(), VRLayout.CLIENT);

  }

  /**
   * ��ԑΉ��^�K����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightTypeVisitCarePatterns(){

    nightTypeVisitCarePatterns.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getServiceDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getAnytimeCorrespondenceTypeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getClassEmploymentRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getHours24MessageAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getBaseMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getServiceMunicipalityAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    nightTypeVisitCarePatterns.add(getCrackOnDayCheck(), VRLayout.FLOW);

    nightTypeVisitCarePatterns.add(getPrintable(), VRLayout.FLOW_RETURN);

    nightTypeVisitCarePatterns.add(getYakanHoumonKaigoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioModel(){

    getProviderDivisionRadioItem1().setButtonIndex(1);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem1());

    getProviderDivisionRadioItem2().setButtonIndex(2);

    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem2());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioItem1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioItem2(){

  }

  /**
   * �T�[�r�X�敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDivisionRadio(){

  }

  /**
   * �T�[�r�X�敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDivisionRadioModel(){

    getServiceDivisionRadioItem1().setButtonIndex(1);

    getServiceDivisionRadioModel().add(getServiceDivisionRadioItem1());

    getServiceDivisionRadioItem2().setButtonIndex(2);

    getServiceDivisionRadioModel().add(getServiceDivisionRadioItem2());

  }

  /**
   * �������^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDivisionRadioItem1(){

  }

  /**
   * �����Ή��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDivisionRadioItem2(){

  }

  /**
   * �Ή��l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAnytimeCorrespondenceTypeRadio(){

  }

  /**
   * �Ή��l�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAnytimeCorrespondenceTypeRadioModel(){

    getAnytimeCorrespondenceTypeRadioItem1().setButtonIndex(1);

    getAnytimeCorrespondenceTypeRadioModel().add(getAnytimeCorrespondenceTypeRadioItem1());

    getAnytimeCorrespondenceTypeRadioItem2().setButtonIndex(2);

    getAnytimeCorrespondenceTypeRadioModel().add(getAnytimeCorrespondenceTypeRadioItem2());

  }

  /**
   * 1�l�Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAnytimeCorrespondenceTypeRadioItem1(){

  }

  /**
   * 2�l�Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAnytimeCorrespondenceTypeRadioItem2(){

  }

  /**
   * �K��҂̋��E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentRadio(){

  }

  /**
   * �K��҂̋��E���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentRadioModel(){

    getClassEmploymentRadioItem1().setButtonIndex(1);

    getClassEmploymentRadioModel().add(getClassEmploymentRadioItem1());

    getClassEmploymentRadioItem2().setButtonIndex(2);

    getClassEmploymentRadioModel().add(getClassEmploymentRadioItem2());

  }

  /**
   * 3���ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentRadioItem1(){

  }

  /**
   * 3���ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentRadioItem2(){

  }

  /**
   * 24���Ԓʕ�Ή����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHours24MessageAddRadioGroup(){

  }

  /**
   * 24���Ԓʕ�Ή����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHours24MessageAddRadioGroupModel(){

    getHours24MessageAddRadioItem1().setButtonIndex(1);

    getHours24MessageAddRadioGroupModel().add(getHours24MessageAddRadioItem1());

    getHours24MessageAddRadioItem2().setButtonIndex(2);

    getHours24MessageAddRadioGroupModel().add(getHours24MessageAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHours24MessageAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHours24MessageAddRadioItem2(){

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
   * ��{��ԖK�� I �s�����Ǝ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAdd(){

  }

  /**
   * ��{��ԖK�� I �s�����Ǝ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBaseMunicipalityAddModel(){

  }

  /**
   * ��ԖK���� II �s�����Ǝ����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAdd(){

  }

  /**
   * ��ԖK���� II �s�����Ǝ����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceMunicipalityAddModel(){

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

    getCalculationDivisionNormal().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionNormal());

    getCalculationDivisionBasicOnly().setButtonIndex(3);

    getCalculationDivisionModel().add(getCalculationDivisionBasicOnly());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * ��{�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionBasicOnly(){

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
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYakanHoumonKaigoTimeContainer(){

    yakanHoumonKaigoTimeContainer.add(getYakanHoumonKaigoBeginTimeContainer(), VRLayout.FLOW);

    yakanHoumonKaigoTimeContainer.add(getYakanHoumonKaigoEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYakanHoumonKaigoBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYakanHoumonKaigoBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYakanHoumonKaigoEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYakanHoumonKaigoEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001123_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001123_H2104Design getThis() {
    return this;
  }
}
