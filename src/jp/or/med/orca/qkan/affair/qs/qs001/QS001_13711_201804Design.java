
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
 * �쐬��: 2018/02/15  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j (QS001_13711_201804)
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
 * �T�[�r�X�p�^�[�����\�h�F�m�ǑΉ��^�����������i�Z�����p�ȊO�j��ʍ��ڃf�U�C��(QS001_13711_201804) 
 */
public class QS001_13711_201804Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACValueArrayRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACValueArrayRadioButtonGroup typeSymbiosisNursingForDementiaDefaultRadio;

  private ACLabelContainer typeSymbiosisNursingForDementiaDefaultRadioContainer;

  private ACListModelAdapter typeSymbiosisNursingForDementiaDefaultRadioModel;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaDefaultRadioItem1;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaDefaultRadioItem2;

  private ACValueArrayRadioButtonGroup typeSymbiosisNursingForDementiaSubtraction;

  private ACLabelContainer typeSymbiosisNursingForDementiaSubtractionContainer;

  private ACListModelAdapter typeSymbiosisNursingForDementiaSubtractionModel;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionCapacityNot;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionCapacityExcess;

  private ACRadioButtonItem typeSymbiosisNursingForDementiaSubtractionPersonLack;

  private ACValueArrayRadioButtonGroup nightWorkConditionStandardRadio;

  private ACLabelContainer nightWorkConditionStandardRadioContainer;

  private ACListModelAdapter nightWorkConditionStandardRadioModel;

  private ACRadioButtonItem nightWorkConditionStandardRadioItem1;

  private ACRadioButtonItem nightWorkConditionStandardRadioItem2;

  private ACValueArrayRadioButtonGroup nightCareAddRadioGroup;

  private ACLabelContainer nightCareAddRadioGroupContainer;

  private ACListModelAdapter nightCareAddRadioGroupModel;

  private ACRadioButtonItem nightCareAddRadioItem1;

  private ACRadioButtonItem nightCareAddRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaProfessionalCareAddRadioGroup;

  private ACLabelContainer dementiaProfessionalCareAddRadioGroupContainer;

  private ACListModelAdapter dementiaProfessionalCareAddRadioGroupModel;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem1;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem2;

  private ACRadioButtonItem dementiaProfessionalCareAddRadioItem3;

  private ACLabelContainer kaigoHealthCareOfTheAgedHijoAddition;

  private ACIntegerCheckBox leaveApartmentsSupportAdd;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACValueArrayRadioButtonGroup kaigoWelfareFacilityBodyRestraintAbolitionRadio;

  private ACLabelContainer kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer;

  private ACListModelAdapter kaigoWelfareFacilityBodyRestraintAbolitionRadioModel;

  private ACRadioButtonItem kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1;

  private ACRadioButtonItem kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2;

  private ACValueArrayRadioButtonGroup hospitalizationExpensesRadioGroup;

  private ACLabelContainer hospitalizationExpensesRadioGroupContainer;

  private ACListModelAdapter hospitalizationExpensesRadioGroupModel;

  private ACRadioButtonItem hospitalizationExpensesRadioItem1;

  private ACRadioButtonItem hospitalizationExpensesRadioItem2;

  private ACValueArrayRadioButtonGroup improvementCollaboration;

  private ACLabelContainer improvementCollaborationContainer;

  private ACListModelAdapter improvementCollaborationModel;

  private ACRadioButtonItem improvementCollaborationItem1;

  private ACRadioButtonItem improvementCollaborationItem2;

  private ACValueArrayRadioButtonGroup oralKeepStructureAddRadioGroup;

  private ACLabelContainer oralKeepStructureAddRadioGroupContainer;

  private ACListModelAdapter oralKeepStructureAddRadioGroupModel;

  private ACRadioButtonItem oralKeepStructureAddRadioItem1;

  private ACRadioButtonItem oralKeepStructureAddRadioItem2;

  private ACValueArrayRadioButtonGroup nutritionScreening;

  private ACLabelContainer nutritionScreeningContainer;

  private ACListModelAdapter nutritionScreeningModel;

  private ACRadioButtonItem nutritionScreeningItem1;

  private ACRadioButtonItem nutritionScreeningItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  //getter

  /**
   * �F�m�ǑΉ������������i�Z�����p�ȊO�j�p�^�[���̈���擾���܂��B
   * @return �F�m�ǑΉ������������i�Z�����p�ȊO�j�p�^�[���̈�
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
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACValueArrayRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACValueArrayRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("�{�ݓ��̋敪");

      providerDivisionRadio.setBindPath("1370109");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

      providerDivisionRadio.setValues(new int[]{1,2});

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
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACValueArrayRadioButtonGroup getTypeSymbiosisNursingForDementiaDefaultRadio(){
    if(typeSymbiosisNursingForDementiaDefaultRadio==null){

      typeSymbiosisNursingForDementiaDefaultRadio = new ACValueArrayRadioButtonGroup();

      getTypeSymbiosisNursingForDementiaDefaultRadioContainer().setText("�������Z");

      typeSymbiosisNursingForDementiaDefaultRadio.setBindPath("1370101");

      typeSymbiosisNursingForDementiaDefaultRadio.setUseClearButton(false);

      typeSymbiosisNursingForDementiaDefaultRadio.setModel(getTypeSymbiosisNursingForDementiaDefaultRadioModel());

      typeSymbiosisNursingForDementiaDefaultRadio.setValues(new int[]{1,2});

      addTypeSymbiosisNursingForDementiaDefaultRadio();
    }
    return typeSymbiosisNursingForDementiaDefaultRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getTypeSymbiosisNursingForDementiaDefaultRadioContainer(){
    if(typeSymbiosisNursingForDementiaDefaultRadioContainer==null){
      typeSymbiosisNursingForDementiaDefaultRadioContainer = new ACLabelContainer();
      typeSymbiosisNursingForDementiaDefaultRadioContainer.setFollowChildEnabled(true);
      typeSymbiosisNursingForDementiaDefaultRadioContainer.setVAlignment(VRLayout.CENTER);
      typeSymbiosisNursingForDementiaDefaultRadioContainer.add(getTypeSymbiosisNursingForDementiaDefaultRadio(), null);
    }
    return typeSymbiosisNursingForDementiaDefaultRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getTypeSymbiosisNursingForDementiaDefaultRadioModel(){
    if(typeSymbiosisNursingForDementiaDefaultRadioModel==null){
      typeSymbiosisNursingForDementiaDefaultRadioModel = new ACListModelAdapter();
      addTypeSymbiosisNursingForDementiaDefaultRadioModel();
    }
    return typeSymbiosisNursingForDementiaDefaultRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaDefaultRadioItem1(){
    if(typeSymbiosisNursingForDementiaDefaultRadioItem1==null){

      typeSymbiosisNursingForDementiaDefaultRadioItem1 = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaDefaultRadioItem1.setText("�Ȃ�");

      typeSymbiosisNursingForDementiaDefaultRadioItem1.setGroup(getTypeSymbiosisNursingForDementiaDefaultRadio());

      typeSymbiosisNursingForDementiaDefaultRadioItem1.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaDefaultRadioItem1();
    }
    return typeSymbiosisNursingForDementiaDefaultRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaDefaultRadioItem2(){
    if(typeSymbiosisNursingForDementiaDefaultRadioItem2==null){

      typeSymbiosisNursingForDementiaDefaultRadioItem2 = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaDefaultRadioItem2.setText("����");

      typeSymbiosisNursingForDementiaDefaultRadioItem2.setGroup(getTypeSymbiosisNursingForDementiaDefaultRadio());

      typeSymbiosisNursingForDementiaDefaultRadioItem2.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaDefaultRadioItem2();
    }
    return typeSymbiosisNursingForDementiaDefaultRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACValueArrayRadioButtonGroup getTypeSymbiosisNursingForDementiaSubtraction(){
    if(typeSymbiosisNursingForDementiaSubtraction==null){

      typeSymbiosisNursingForDementiaSubtraction = new ACValueArrayRadioButtonGroup();

      getTypeSymbiosisNursingForDementiaSubtractionContainer().setText("�l�����Z");

      typeSymbiosisNursingForDementiaSubtraction.setBindPath("1370102");

      typeSymbiosisNursingForDementiaSubtraction.setUseClearButton(false);

      typeSymbiosisNursingForDementiaSubtraction.setModel(getTypeSymbiosisNursingForDementiaSubtractionModel());

      typeSymbiosisNursingForDementiaSubtraction.setValues(new int[]{1,2,3});

      addTypeSymbiosisNursingForDementiaSubtraction();
    }
    return typeSymbiosisNursingForDementiaSubtraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getTypeSymbiosisNursingForDementiaSubtractionContainer(){
    if(typeSymbiosisNursingForDementiaSubtractionContainer==null){
      typeSymbiosisNursingForDementiaSubtractionContainer = new ACLabelContainer();
      typeSymbiosisNursingForDementiaSubtractionContainer.setFollowChildEnabled(true);
      typeSymbiosisNursingForDementiaSubtractionContainer.setVAlignment(VRLayout.CENTER);
      typeSymbiosisNursingForDementiaSubtractionContainer.add(getTypeSymbiosisNursingForDementiaSubtraction(), null);
    }
    return typeSymbiosisNursingForDementiaSubtractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getTypeSymbiosisNursingForDementiaSubtractionModel(){
    if(typeSymbiosisNursingForDementiaSubtractionModel==null){
      typeSymbiosisNursingForDementiaSubtractionModel = new ACListModelAdapter();
      addTypeSymbiosisNursingForDementiaSubtractionModel();
    }
    return typeSymbiosisNursingForDementiaSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaSubtractionCapacityNot(){
    if(typeSymbiosisNursingForDementiaSubtractionCapacityNot==null){

      typeSymbiosisNursingForDementiaSubtractionCapacityNot = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaSubtractionCapacityNot.setText("�Ȃ�");

      typeSymbiosisNursingForDementiaSubtractionCapacityNot.setGroup(getTypeSymbiosisNursingForDementiaSubtraction());

      typeSymbiosisNursingForDementiaSubtractionCapacityNot.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaSubtractionCapacityNot();
    }
    return typeSymbiosisNursingForDementiaSubtractionCapacityNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaSubtractionCapacityExcess(){
    if(typeSymbiosisNursingForDementiaSubtractionCapacityExcess==null){

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess.setText("�������");

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess.setGroup(getTypeSymbiosisNursingForDementiaSubtraction());

      typeSymbiosisNursingForDementiaSubtractionCapacityExcess.setConstraints(VRLayout.FLOW_RETURN);

      addTypeSymbiosisNursingForDementiaSubtractionCapacityExcess();
    }
    return typeSymbiosisNursingForDementiaSubtractionCapacityExcess;

  }

  /**
   * ���]�Ǝ҂��������擾���܂��B
   * @return ���]�Ǝ҂�����
   */
  public ACRadioButtonItem getTypeSymbiosisNursingForDementiaSubtractionPersonLack(){
    if(typeSymbiosisNursingForDementiaSubtractionPersonLack==null){

      typeSymbiosisNursingForDementiaSubtractionPersonLack = new ACRadioButtonItem();

      typeSymbiosisNursingForDementiaSubtractionPersonLack.setText("���]�Ǝ҂�����");

      typeSymbiosisNursingForDementiaSubtractionPersonLack.setGroup(getTypeSymbiosisNursingForDementiaSubtraction());

      typeSymbiosisNursingForDementiaSubtractionPersonLack.setConstraints(VRLayout.FLOW);

      addTypeSymbiosisNursingForDementiaSubtractionPersonLack();
    }
    return typeSymbiosisNursingForDementiaSubtractionPersonLack;

  }

  /**
   * ��ԋΖ���������擾���܂��B
   * @return ��ԋΖ������
   */
  public ACValueArrayRadioButtonGroup getNightWorkConditionStandardRadio(){
    if(nightWorkConditionStandardRadio==null){

      nightWorkConditionStandardRadio = new ACValueArrayRadioButtonGroup();

      getNightWorkConditionStandardRadioContainer().setText("��ԋΖ������");

      nightWorkConditionStandardRadio.setBindPath("1370103");

      nightWorkConditionStandardRadio.setUseClearButton(false);

      nightWorkConditionStandardRadio.setModel(getNightWorkConditionStandardRadioModel());

      nightWorkConditionStandardRadio.setValues(new int[]{1,2});

      addNightWorkConditionStandardRadio();
    }
    return nightWorkConditionStandardRadio;

  }

  /**
   * ��ԋΖ�������R���e�i���擾���܂��B
   * @return ��ԋΖ�������R���e�i
   */
  protected ACLabelContainer getNightWorkConditionStandardRadioContainer(){
    if(nightWorkConditionStandardRadioContainer==null){
      nightWorkConditionStandardRadioContainer = new ACLabelContainer();
      nightWorkConditionStandardRadioContainer.setFollowChildEnabled(true);
      nightWorkConditionStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      nightWorkConditionStandardRadioContainer.add(getNightWorkConditionStandardRadio(), null);
    }
    return nightWorkConditionStandardRadioContainer;
  }

  /**
   * ��ԋΖ���������f�����擾���܂��B
   * @return ��ԋΖ���������f��
   */
  protected ACListModelAdapter getNightWorkConditionStandardRadioModel(){
    if(nightWorkConditionStandardRadioModel==null){
      nightWorkConditionStandardRadioModel = new ACListModelAdapter();
      addNightWorkConditionStandardRadioModel();
    }
    return nightWorkConditionStandardRadioModel;
  }

  /**
   * �������Ă�����擾���܂��B
   * @return �������Ă���
   */
  public ACRadioButtonItem getNightWorkConditionStandardRadioItem1(){
    if(nightWorkConditionStandardRadioItem1==null){

      nightWorkConditionStandardRadioItem1 = new ACRadioButtonItem();

      nightWorkConditionStandardRadioItem1.setText("�������Ă���");

      nightWorkConditionStandardRadioItem1.setGroup(getNightWorkConditionStandardRadio());

      nightWorkConditionStandardRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addNightWorkConditionStandardRadioItem1();
    }
    return nightWorkConditionStandardRadioItem1;

  }

  /**
   * �������Ă��Ȃ����擾���܂��B
   * @return �������Ă��Ȃ�
   */
  public ACRadioButtonItem getNightWorkConditionStandardRadioItem2(){
    if(nightWorkConditionStandardRadioItem2==null){

      nightWorkConditionStandardRadioItem2 = new ACRadioButtonItem();

      nightWorkConditionStandardRadioItem2.setText("�������Ă��Ȃ�");

      nightWorkConditionStandardRadioItem2.setGroup(getNightWorkConditionStandardRadio());

      nightWorkConditionStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addNightWorkConditionStandardRadioItem2();
    }
    return nightWorkConditionStandardRadioItem2;

  }

  /**
   * ��Ԏx���̐����Z���擾���܂��B
   * @return ��Ԏx���̐����Z
   */
  public ACValueArrayRadioButtonGroup getNightCareAddRadioGroup(){
    if(nightCareAddRadioGroup==null){

      nightCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getNightCareAddRadioGroupContainer().setText("��Ԏx���̐����Z");

      nightCareAddRadioGroup.setBindPath("1370104");

      nightCareAddRadioGroup.setNoSelectIndex(0);

      nightCareAddRadioGroup.setUseClearButton(false);

      nightCareAddRadioGroup.setModel(getNightCareAddRadioGroupModel());

      nightCareAddRadioGroup.setValues(new int[]{1,2});

      addNightCareAddRadioGroup();
    }
    return nightCareAddRadioGroup;

  }

  /**
   * ��Ԏx���̐����Z�R���e�i���擾���܂��B
   * @return ��Ԏx���̐����Z�R���e�i
   */
  protected ACLabelContainer getNightCareAddRadioGroupContainer(){
    if(nightCareAddRadioGroupContainer==null){
      nightCareAddRadioGroupContainer = new ACLabelContainer();
      nightCareAddRadioGroupContainer.setFollowChildEnabled(true);
      nightCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      nightCareAddRadioGroupContainer.add(getNightCareAddRadioGroup(), null);
    }
    return nightCareAddRadioGroupContainer;
  }

  /**
   * ��Ԏx���̐����Z���f�����擾���܂��B
   * @return ��Ԏx���̐����Z���f��
   */
  protected ACListModelAdapter getNightCareAddRadioGroupModel(){
    if(nightCareAddRadioGroupModel==null){
      nightCareAddRadioGroupModel = new ACListModelAdapter();
      addNightCareAddRadioGroupModel();
    }
    return nightCareAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNightCareAddRadioItem1(){
    if(nightCareAddRadioItem1==null){

      nightCareAddRadioItem1 = new ACRadioButtonItem();

      nightCareAddRadioItem1.setText("�Ȃ�");

      nightCareAddRadioItem1.setGroup(getNightCareAddRadioGroup());

      nightCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNightCareAddRadioItem1();
    }
    return nightCareAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNightCareAddRadioItem2(){
    if(nightCareAddRadioItem2==null){

      nightCareAddRadioItem2 = new ACRadioButtonItem();

      nightCareAddRadioItem2.setText("����");

      nightCareAddRadioItem2.setGroup(getNightCareAddRadioGroup());

      nightCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNightCareAddRadioItem2();
    }
    return nightCareAddRadioItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1370105");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i
   */
  protected ACLabelContainer getYoungDementiaPatinetAddRadioGroupContainer(){
    if(youngDementiaPatinetAddRadioGroupContainer==null){
      youngDementiaPatinetAddRadioGroupContainer = new ACLabelContainer();
      youngDementiaPatinetAddRadioGroupContainer.setFollowChildEnabled(true);
      youngDementiaPatinetAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      youngDementiaPatinetAddRadioGroupContainer.add(getYoungDementiaPatinetAddRadioGroup(), null);
    }
    return youngDementiaPatinetAddRadioGroupContainer;
  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f�����擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z���f��
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("�Ȃ�");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("����");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * �F�m�ǐ��P�A���Z���擾���܂��B
   * @return �F�m�ǐ��P�A���Z
   */
  public ACValueArrayRadioButtonGroup getDementiaProfessionalCareAddRadioGroup(){
    if(dementiaProfessionalCareAddRadioGroup==null){

      dementiaProfessionalCareAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaProfessionalCareAddRadioGroupContainer().setText("�F�m�ǐ��P�A���Z");

      dementiaProfessionalCareAddRadioGroup.setBindPath("1370106");

      dementiaProfessionalCareAddRadioGroup.setVisible(true);

      dementiaProfessionalCareAddRadioGroup.setEnabled(true);

      dementiaProfessionalCareAddRadioGroup.setNoSelectIndex(0);

      dementiaProfessionalCareAddRadioGroup.setUseClearButton(false);

      dementiaProfessionalCareAddRadioGroup.setModel(getDementiaProfessionalCareAddRadioGroupModel());

      dementiaProfessionalCareAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaProfessionalCareAddRadioGroup();
    }
    return dementiaProfessionalCareAddRadioGroup;

  }

  /**
   * �F�m�ǐ��P�A���Z�R���e�i���擾���܂��B
   * @return �F�m�ǐ��P�A���Z�R���e�i
   */
  protected ACLabelContainer getDementiaProfessionalCareAddRadioGroupContainer(){
    if(dementiaProfessionalCareAddRadioGroupContainer==null){
      dementiaProfessionalCareAddRadioGroupContainer = new ACLabelContainer();
      dementiaProfessionalCareAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaProfessionalCareAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaProfessionalCareAddRadioGroupContainer.add(getDementiaProfessionalCareAddRadioGroup(), null);
    }
    return dementiaProfessionalCareAddRadioGroupContainer;
  }

  /**
   * �F�m�ǐ��P�A���Z���f�����擾���܂��B
   * @return �F�m�ǐ��P�A���Z���f��
   */
  protected ACListModelAdapter getDementiaProfessionalCareAddRadioGroupModel(){
    if(dementiaProfessionalCareAddRadioGroupModel==null){
      dementiaProfessionalCareAddRadioGroupModel = new ACListModelAdapter();
      addDementiaProfessionalCareAddRadioGroupModel();
    }
    return dementiaProfessionalCareAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem1(){
    if(dementiaProfessionalCareAddRadioItem1==null){

      dementiaProfessionalCareAddRadioItem1 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem1.setText("�Ȃ�");

      dementiaProfessionalCareAddRadioItem1.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem1();
    }
    return dementiaProfessionalCareAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem2(){
    if(dementiaProfessionalCareAddRadioItem2==null){

      dementiaProfessionalCareAddRadioItem2 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem2.setText("I�^");

      dementiaProfessionalCareAddRadioItem2.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem2();
    }
    return dementiaProfessionalCareAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getDementiaProfessionalCareAddRadioItem3(){
    if(dementiaProfessionalCareAddRadioItem3==null){

      dementiaProfessionalCareAddRadioItem3 = new ACRadioButtonItem();

      dementiaProfessionalCareAddRadioItem3.setText("II�^");

      dementiaProfessionalCareAddRadioItem3.setGroup(getDementiaProfessionalCareAddRadioGroup());

      dementiaProfessionalCareAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaProfessionalCareAddRadioItem3();
    }
    return dementiaProfessionalCareAddRadioItem3;

  }

  /**
   * �ޏ��֘A���Z���擾���܂��B
   * @return �ޏ��֘A���Z
   */
  public ACLabelContainer getKaigoHealthCareOfTheAgedHijoAddition(){
    if(kaigoHealthCareOfTheAgedHijoAddition==null){

      kaigoHealthCareOfTheAgedHijoAddition = new ACLabelContainer();

      kaigoHealthCareOfTheAgedHijoAddition.setText("�ޏ��֘A���Z");

      kaigoHealthCareOfTheAgedHijoAddition.setFollowChildEnabled(true);

      addKaigoHealthCareOfTheAgedHijoAddition();
    }
    return kaigoHealthCareOfTheAgedHijoAddition;

  }

  /**
   * �ދ������k�������Z���擾���܂��B
   * @return �ދ������k�������Z
   */
  public ACIntegerCheckBox getLeaveApartmentsSupportAdd(){
    if(leaveApartmentsSupportAdd==null){

      leaveApartmentsSupportAdd = new ACIntegerCheckBox();

      leaveApartmentsSupportAdd.setText("�ދ������k�������Z");

      leaveApartmentsSupportAdd.setBindPath("1370108");

      leaveApartmentsSupportAdd.setSelectValue(2);

      leaveApartmentsSupportAdd.setUnSelectValue(1);

      addLeaveApartmentsSupportAdd();
    }
    return leaveApartmentsSupportAdd;

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

      addTab2();
    }
    return tab2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1370107");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,5,2,3,4});

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
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I�C�^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * I���^���擾���܂��B
   * @return I���^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("I���^");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("II�^");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("III�^");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

  }

  /**
   * �g�̍S���p�~�����{���Z���擾���܂��B
   * @return �g�̍S���p�~�����{���Z
   */
  public ACValueArrayRadioButtonGroup getKaigoWelfareFacilityBodyRestraintAbolitionRadio(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadio==null){

      kaigoWelfareFacilityBodyRestraintAbolitionRadio = new ACValueArrayRadioButtonGroup();

      getKaigoWelfareFacilityBodyRestraintAbolitionRadioContainer().setText("�g�̍S���p�~�����{���Z");

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setBindPath("1370110");

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setUseClearButton(false);

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setModel(getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel());

      kaigoWelfareFacilityBodyRestraintAbolitionRadio.setValues(new int[]{1,2});

      addKaigoWelfareFacilityBodyRestraintAbolitionRadio();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadio;

  }

  /**
   * �g�̍S���p�~�����{���Z�R���e�i���擾���܂��B
   * @return �g�̍S���p�~�����{���Z�R���e�i
   */
  protected ACLabelContainer getKaigoWelfareFacilityBodyRestraintAbolitionRadioContainer(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer==null){
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer = new ACLabelContainer();
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer.setFollowChildEnabled(true);
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer.add(getKaigoWelfareFacilityBodyRestraintAbolitionRadio(), null);
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioContainer;
  }

  /**
   * �g�̍S���p�~�����{���Z���f�����擾���܂��B
   * @return �g�̍S���p�~�����{���Z���f��
   */
  protected ACListModelAdapter getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioModel==null){
      kaigoWelfareFacilityBodyRestraintAbolitionRadioModel = new ACListModelAdapter();
      addKaigoWelfareFacilityBodyRestraintAbolitionRadioModel();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1==null){

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1 = new ACRadioButtonItem();

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1.setText("�Ȃ�");

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1.setGroup(getKaigoWelfareFacilityBodyRestraintAbolitionRadio());

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2(){
    if(kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2==null){

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2 = new ACRadioButtonItem();

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2.setText("����");

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2.setGroup(getKaigoWelfareFacilityBodyRestraintAbolitionRadio());

      kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2();
    }
    return kaigoWelfareFacilityBodyRestraintAbolitionRadioItem2;

  }

  /**
   * ���@����p���擾���܂��B
   * @return ���@����p
   */
  public ACValueArrayRadioButtonGroup getHospitalizationExpensesRadioGroup(){
    if(hospitalizationExpensesRadioGroup==null){

      hospitalizationExpensesRadioGroup = new ACValueArrayRadioButtonGroup();

      getHospitalizationExpensesRadioGroupContainer().setText("���@����p");

      hospitalizationExpensesRadioGroup.setBindPath("1370111");

      hospitalizationExpensesRadioGroup.setNoSelectIndex(0);

      hospitalizationExpensesRadioGroup.setUseClearButton(false);

      hospitalizationExpensesRadioGroup.setModel(getHospitalizationExpensesRadioGroupModel());

      hospitalizationExpensesRadioGroup.setValues(new int[]{1,2});

      addHospitalizationExpensesRadioGroup();
    }
    return hospitalizationExpensesRadioGroup;

  }

  /**
   * ���@����p�R���e�i���擾���܂��B
   * @return ���@����p�R���e�i
   */
  protected ACLabelContainer getHospitalizationExpensesRadioGroupContainer(){
    if(hospitalizationExpensesRadioGroupContainer==null){
      hospitalizationExpensesRadioGroupContainer = new ACLabelContainer();
      hospitalizationExpensesRadioGroupContainer.setFollowChildEnabled(true);
      hospitalizationExpensesRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      hospitalizationExpensesRadioGroupContainer.add(getHospitalizationExpensesRadioGroup(), null);
    }
    return hospitalizationExpensesRadioGroupContainer;
  }

  /**
   * ���@����p���f�����擾���܂��B
   * @return ���@����p���f��
   */
  protected ACListModelAdapter getHospitalizationExpensesRadioGroupModel(){
    if(hospitalizationExpensesRadioGroupModel==null){
      hospitalizationExpensesRadioGroupModel = new ACListModelAdapter();
      addHospitalizationExpensesRadioGroupModel();
    }
    return hospitalizationExpensesRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHospitalizationExpensesRadioItem1(){
    if(hospitalizationExpensesRadioItem1==null){

      hospitalizationExpensesRadioItem1 = new ACRadioButtonItem();

      hospitalizationExpensesRadioItem1.setText("�Ȃ�");

      hospitalizationExpensesRadioItem1.setGroup(getHospitalizationExpensesRadioGroup());

      hospitalizationExpensesRadioItem1.setConstraints(VRLayout.FLOW);

      addHospitalizationExpensesRadioItem1();
    }
    return hospitalizationExpensesRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHospitalizationExpensesRadioItem2(){
    if(hospitalizationExpensesRadioItem2==null){

      hospitalizationExpensesRadioItem2 = new ACRadioButtonItem();

      hospitalizationExpensesRadioItem2.setText("����");

      hospitalizationExpensesRadioItem2.setGroup(getHospitalizationExpensesRadioGroup());

      hospitalizationExpensesRadioItem2.setConstraints(VRLayout.FLOW);

      addHospitalizationExpensesRadioItem2();
    }
    return hospitalizationExpensesRadioItem2;

  }

  /**
   * �����@�\����A�g���Z���擾���܂��B
   * @return �����@�\����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getImprovementCollaboration(){
    if(improvementCollaboration==null){

      improvementCollaboration = new ACValueArrayRadioButtonGroup();

      getImprovementCollaborationContainer().setText("�����@�\����A�g���Z");

      improvementCollaboration.setBindPath("1370112");

      improvementCollaboration.setUseClearButton(false);

      improvementCollaboration.setModel(getImprovementCollaborationModel());

      improvementCollaboration.setValues(new int[]{1,2});

      addImprovementCollaboration();
    }
    return improvementCollaboration;

  }

  /**
   * �����@�\����A�g���Z�R���e�i���擾���܂��B
   * @return �����@�\����A�g���Z�R���e�i
   */
  protected ACLabelContainer getImprovementCollaborationContainer(){
    if(improvementCollaborationContainer==null){
      improvementCollaborationContainer = new ACLabelContainer();
      improvementCollaborationContainer.setFollowChildEnabled(true);
      improvementCollaborationContainer.setVAlignment(VRLayout.CENTER);
      improvementCollaborationContainer.add(getImprovementCollaboration(), null);
    }
    return improvementCollaborationContainer;
  }

  /**
   * �����@�\����A�g���Z���f�����擾���܂��B
   * @return �����@�\����A�g���Z���f��
   */
  protected ACListModelAdapter getImprovementCollaborationModel(){
    if(improvementCollaborationModel==null){
      improvementCollaborationModel = new ACListModelAdapter();
      addImprovementCollaborationModel();
    }
    return improvementCollaborationModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getImprovementCollaborationItem1(){
    if(improvementCollaborationItem1==null){

      improvementCollaborationItem1 = new ACRadioButtonItem();

      improvementCollaborationItem1.setText("�Ȃ�");

      improvementCollaborationItem1.setGroup(getImprovementCollaboration());

      improvementCollaborationItem1.setConstraints(VRLayout.FLOW);

      addImprovementCollaborationItem1();
    }
    return improvementCollaborationItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getImprovementCollaborationItem2(){
    if(improvementCollaborationItem2==null){

      improvementCollaborationItem2 = new ACRadioButtonItem();

      improvementCollaborationItem2.setText("����");

      improvementCollaborationItem2.setGroup(getImprovementCollaboration());

      improvementCollaborationItem2.setConstraints(VRLayout.FLOW);

      addImprovementCollaborationItem2();
    }
    return improvementCollaborationItem2;

  }

  /**
   * ���o�q���Ǘ��̐����Z���擾���܂��B
   * @return ���o�q���Ǘ��̐����Z
   */
  public ACValueArrayRadioButtonGroup getOralKeepStructureAddRadioGroup(){
    if(oralKeepStructureAddRadioGroup==null){

      oralKeepStructureAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getOralKeepStructureAddRadioGroupContainer().setText("���o�q���Ǘ��̐����Z");

      oralKeepStructureAddRadioGroup.setBindPath("1370113");

      oralKeepStructureAddRadioGroup.setNoSelectIndex(0);

      oralKeepStructureAddRadioGroup.setUseClearButton(false);

      oralKeepStructureAddRadioGroup.setModel(getOralKeepStructureAddRadioGroupModel());

      oralKeepStructureAddRadioGroup.setValues(new int[]{1,2});

      addOralKeepStructureAddRadioGroup();
    }
    return oralKeepStructureAddRadioGroup;

  }

  /**
   * ���o�q���Ǘ��̐����Z�R���e�i���擾���܂��B
   * @return ���o�q���Ǘ��̐����Z�R���e�i
   */
  protected ACLabelContainer getOralKeepStructureAddRadioGroupContainer(){
    if(oralKeepStructureAddRadioGroupContainer==null){
      oralKeepStructureAddRadioGroupContainer = new ACLabelContainer();
      oralKeepStructureAddRadioGroupContainer.setFollowChildEnabled(true);
      oralKeepStructureAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      oralKeepStructureAddRadioGroupContainer.add(getOralKeepStructureAddRadioGroup(), null);
    }
    return oralKeepStructureAddRadioGroupContainer;
  }

  /**
   * ���o�q���Ǘ��̐����Z���f�����擾���܂��B
   * @return ���o�q���Ǘ��̐����Z���f��
   */
  protected ACListModelAdapter getOralKeepStructureAddRadioGroupModel(){
    if(oralKeepStructureAddRadioGroupModel==null){
      oralKeepStructureAddRadioGroupModel = new ACListModelAdapter();
      addOralKeepStructureAddRadioGroupModel();
    }
    return oralKeepStructureAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralKeepStructureAddRadioItem1(){
    if(oralKeepStructureAddRadioItem1==null){

      oralKeepStructureAddRadioItem1 = new ACRadioButtonItem();

      oralKeepStructureAddRadioItem1.setText("�Ȃ�");

      oralKeepStructureAddRadioItem1.setGroup(getOralKeepStructureAddRadioGroup());

      oralKeepStructureAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralKeepStructureAddRadioItem1();
    }
    return oralKeepStructureAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getOralKeepStructureAddRadioItem2(){
    if(oralKeepStructureAddRadioItem2==null){

      oralKeepStructureAddRadioItem2 = new ACRadioButtonItem();

      oralKeepStructureAddRadioItem2.setText("����");

      oralKeepStructureAddRadioItem2.setGroup(getOralKeepStructureAddRadioGroup());

      oralKeepStructureAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralKeepStructureAddRadioItem2();
    }
    return oralKeepStructureAddRadioItem2;

  }

  /**
   * �h�{�X�N���[�j���O���Z���擾���܂��B
   * @return �h�{�X�N���[�j���O���Z
   */
  public ACValueArrayRadioButtonGroup getNutritionScreening(){
    if(nutritionScreening==null){

      nutritionScreening = new ACValueArrayRadioButtonGroup();

      getNutritionScreeningContainer().setText("�h�{�X�N���[�j���O���Z");

      nutritionScreening.setBindPath("1370114");

      nutritionScreening.setUseClearButton(false);

      nutritionScreening.setModel(getNutritionScreeningModel());

      nutritionScreening.setValues(new int[]{1,2});

      addNutritionScreening();
    }
    return nutritionScreening;

  }

  /**
   * �h�{�X�N���[�j���O���Z�R���e�i���擾���܂��B
   * @return �h�{�X�N���[�j���O���Z�R���e�i
   */
  protected ACLabelContainer getNutritionScreeningContainer(){
    if(nutritionScreeningContainer==null){
      nutritionScreeningContainer = new ACLabelContainer();
      nutritionScreeningContainer.setFollowChildEnabled(true);
      nutritionScreeningContainer.setVAlignment(VRLayout.CENTER);
      nutritionScreeningContainer.add(getNutritionScreening(), null);
    }
    return nutritionScreeningContainer;
  }

  /**
   * �h�{�X�N���[�j���O���Z���f�����擾���܂��B
   * @return �h�{�X�N���[�j���O���Z���f��
   */
  protected ACListModelAdapter getNutritionScreeningModel(){
    if(nutritionScreeningModel==null){
      nutritionScreeningModel = new ACListModelAdapter();
      addNutritionScreeningModel();
    }
    return nutritionScreeningModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNutritionScreeningItem1(){
    if(nutritionScreeningItem1==null){

      nutritionScreeningItem1 = new ACRadioButtonItem();

      nutritionScreeningItem1.setText("�Ȃ�");

      nutritionScreeningItem1.setGroup(getNutritionScreening());

      addNutritionScreeningItem1();
    }
    return nutritionScreeningItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNutritionScreeningItem2(){
    if(nutritionScreeningItem2==null){

      nutritionScreeningItem2 = new ACRadioButtonItem();

      nutritionScreeningItem2.setText("����");

      nutritionScreeningItem2.setGroup(getNutritionScreening());

      addNutritionScreeningItem2();
    }
    return nutritionScreeningItem2;

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
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getCalculationDivisionAddOnly(){
    if(calculationDivisionAddOnly==null){

      calculationDivisionAddOnly = new ACRadioButtonItem();

      calculationDivisionAddOnly.setText("���Z�̂�");

      calculationDivisionAddOnly.setGroup(getCalculationDivision());

      calculationDivisionAddOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionAddOnly();
    }
    return calculationDivisionAddOnly;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_13711_201804Design() {

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

    this.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �F�m�ǑΉ������������i�Z�����p�ȊO�j�p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTypeSymbiosisNursingForDementiaDefaultRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getTypeSymbiosisNursingForDementiaSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNightWorkConditionStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNightCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getDementiaProfessionalCareAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getKaigoHealthCareOfTheAgedHijoAddition(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadioModel(){

    getTypeSymbiosisNursingForDementiaDefaultRadioItem1().setButtonIndex(1);

    getTypeSymbiosisNursingForDementiaDefaultRadioModel().add(getTypeSymbiosisNursingForDementiaDefaultRadioItem1());

    getTypeSymbiosisNursingForDementiaDefaultRadioItem2().setButtonIndex(2);

    getTypeSymbiosisNursingForDementiaDefaultRadioModel().add(getTypeSymbiosisNursingForDementiaDefaultRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaDefaultRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaSubtraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionModel(){

    getTypeSymbiosisNursingForDementiaSubtractionCapacityNot().setButtonIndex(1);

    getTypeSymbiosisNursingForDementiaSubtractionModel().add(getTypeSymbiosisNursingForDementiaSubtractionCapacityNot());

    getTypeSymbiosisNursingForDementiaSubtractionCapacityExcess().setButtonIndex(2);

    getTypeSymbiosisNursingForDementiaSubtractionModel().add(getTypeSymbiosisNursingForDementiaSubtractionCapacityExcess());

    getTypeSymbiosisNursingForDementiaSubtractionPersonLack().setButtonIndex(3);

    getTypeSymbiosisNursingForDementiaSubtractionModel().add(getTypeSymbiosisNursingForDementiaSubtractionPersonLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionCapacityNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionCapacityExcess(){

  }

  /**
   * ���]�Ǝ҂������ɓ������ڂ�ǉ����܂��B
   */
  protected void addTypeSymbiosisNursingForDementiaSubtractionPersonLack(){

  }

  /**
   * ��ԋΖ�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionStandardRadio(){

  }

  /**
   * ��ԋΖ���������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionStandardRadioModel(){

    getNightWorkConditionStandardRadioItem1().setButtonIndex(1);

    getNightWorkConditionStandardRadioModel().add(getNightWorkConditionStandardRadioItem1());

    getNightWorkConditionStandardRadioItem2().setButtonIndex(2);

    getNightWorkConditionStandardRadioModel().add(getNightWorkConditionStandardRadioItem2());

  }

  /**
   * �������Ă���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionStandardRadioItem1(){

  }

  /**
   * �������Ă��Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightWorkConditionStandardRadioItem2(){

  }

  /**
   * ��Ԏx���̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightCareAddRadioGroup(){

  }

  /**
   * ��Ԏx���̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightCareAddRadioGroupModel(){

    getNightCareAddRadioItem1().setButtonIndex(1);

    getNightCareAddRadioGroupModel().add(getNightCareAddRadioItem1());

    getNightCareAddRadioItem2().setButtonIndex(2);

    getNightCareAddRadioGroupModel().add(getNightCareAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightCareAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNightCareAddRadioItem2(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

  }

  /**
   * �F�m�ǐ��P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioGroup(){

  }

  /**
   * �F�m�ǐ��P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioGroupModel(){

    getDementiaProfessionalCareAddRadioItem1().setButtonIndex(1);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem1());

    getDementiaProfessionalCareAddRadioItem2().setButtonIndex(2);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem2());

    getDementiaProfessionalCareAddRadioItem3().setButtonIndex(3);

    getDementiaProfessionalCareAddRadioGroupModel().add(getDementiaProfessionalCareAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaProfessionalCareAddRadioItem3(){

  }

  /**
   * �ޏ��֘A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoHealthCareOfTheAgedHijoAddition(){

    kaigoHealthCareOfTheAgedHijoAddition.add(getLeaveApartmentsSupportAdd(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ދ������k�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeaveApartmentsSupportAdd(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getKaigoWelfareFacilityBodyRestraintAbolitionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHospitalizationExpensesRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getImprovementCollaborationContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getOralKeepStructureAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getNutritionScreeningContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�C�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * I���^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

  }

  /**
   * �g�̍S���p�~�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadio(){

  }

  /**
   * �g�̍S���p�~�����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadioModel(){

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1().setButtonIndex(1);

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel().add(getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1());

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2().setButtonIndex(2);

    getKaigoWelfareFacilityBodyRestraintAbolitionRadioModel().add(getKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoWelfareFacilityBodyRestraintAbolitionRadioItem2(){

  }

  /**
   * ���@����p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalizationExpensesRadioGroup(){

  }

  /**
   * ���@����p���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalizationExpensesRadioGroupModel(){

    getHospitalizationExpensesRadioItem1().setButtonIndex(1);

    getHospitalizationExpensesRadioGroupModel().add(getHospitalizationExpensesRadioItem1());

    getHospitalizationExpensesRadioItem2().setButtonIndex(2);

    getHospitalizationExpensesRadioGroupModel().add(getHospitalizationExpensesRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalizationExpensesRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHospitalizationExpensesRadioItem2(){

  }

  /**
   * �����@�\����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaboration(){

  }

  /**
   * �����@�\����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaborationModel(){

    getImprovementCollaborationItem1().setButtonIndex(1);

    getImprovementCollaborationModel().add(getImprovementCollaborationItem1());

    getImprovementCollaborationItem2().setButtonIndex(2);

    getImprovementCollaborationModel().add(getImprovementCollaborationItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaborationItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addImprovementCollaborationItem2(){

  }

  /**
   * ���o�q���Ǘ��̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioGroup(){

  }

  /**
   * ���o�q���Ǘ��̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioGroupModel(){

    getOralKeepStructureAddRadioItem1().setButtonIndex(1);

    getOralKeepStructureAddRadioGroupModel().add(getOralKeepStructureAddRadioItem1());

    getOralKeepStructureAddRadioItem2().setButtonIndex(2);

    getOralKeepStructureAddRadioGroupModel().add(getOralKeepStructureAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralKeepStructureAddRadioItem2(){

  }

  /**
   * �h�{�X�N���[�j���O���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionScreening(){

  }

  /**
   * �h�{�X�N���[�j���O���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionScreeningModel(){

    getNutritionScreeningItem1().setButtonIndex(1);

    getNutritionScreeningModel().add(getNutritionScreeningItem1());

    getNutritionScreeningItem2().setButtonIndex(2);

    getNutritionScreeningModel().add(getNutritionScreeningItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionScreeningItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNutritionScreeningItem2(){

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

    getCalculationDivisionAddOnly().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionAddOnly());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionAddOnly(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_13711_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_13711_201804Design getThis() {
    return this;
  }
}
