
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
 * �쐬��: 2015/03/02  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�K�⃊�n�r���e�[�V���� (QS001_16411_201504)
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
 * �T�[�r�X�p�^�[�����\�h�K�⃊�n�r���e�[�V������ʍ��ڃf�U�C��(QS001_16411_201504) 
 */
public class QS001_16411_201504Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel houmonRehabilitationPatterns;

  private ACValueArrayRadioButtonGroup houmonRehabilitationFacilityDivision;

  private ACLabelContainer houmonRehabilitationFacilityDivisionContainer;

  private ACListModelAdapter houmonRehabilitationFacilityDivisionModel;

  private ACRadioButtonItem houmonRehabilitationClassDouble;

  private ACRadioButtonItem houmonRehabilitationClassSingle;

  private ACValueArrayRadioButtonGroup visitDemandRadioGroup;

  private ACLabelContainer visitDemandRadioGroupContainer;

  private ACListModelAdapter visitDemandRadioGroupModel;

  private ACRadioButtonItem visitDemandRadioItem1;

  private ACRadioButtonItem visitDemandRadioItem2;

  private ACValueArrayRadioButtonGroup houmonRehabiliShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabiliShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabiliShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabiliShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabiliShortConcentrationAddRadioItem2;

  private ACValueArrayRadioButtonGroup careVisitsCoordinationAddRadioGroup;

  private ACLabelContainer careVisitsCoordinationAddRadioGroupContainer;

  private ACListModelAdapter careVisitsCoordinationAddRadioGroupModel;

  private ACRadioButtonItem careVisitsCoordinationAddRadioItem1;

  private ACRadioButtonItem careVisitsCoordinationAddRadioItem2;

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

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  private ACBackLabelContainer houmonRehabilitationTimeContena;

  private ACTimeComboBox houmonRehabilitationBeginTime;

  private ACLabelContainer houmonRehabilitationBeginTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationBeginTimeModel;

  private ACTimeComboBox houmonRehabilitationEndTime;

  private ACLabelContainer houmonRehabilitationEndTimeContainer;

  private ACComboBoxModelAdapter houmonRehabilitationEndTimeModel;

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

      houmonRehabilitationFacilityDivision.setBindPath("1640101");

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
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂��擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X��
   */
  public ACValueArrayRadioButtonGroup getVisitDemandRadioGroup(){
    if(visitDemandRadioGroup==null){

      visitDemandRadioGroup = new ACValueArrayRadioButtonGroup();

      getVisitDemandRadioGroupContainer().setText("���ꌚ�����Z�҂ւ̃T�[�r�X��");

      visitDemandRadioGroup.setBindPath("16");

      visitDemandRadioGroup.setUseClearButton(false);

      visitDemandRadioGroup.setModel(getVisitDemandRadioGroupModel());

      visitDemandRadioGroup.setValues(new int[]{1,2});

      addVisitDemandRadioGroup();
    }
    return visitDemandRadioGroup;

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i���擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃R���e�i
   */
  protected ACLabelContainer getVisitDemandRadioGroupContainer(){
    if(visitDemandRadioGroupContainer==null){
      visitDemandRadioGroupContainer = new ACLabelContainer();
      visitDemandRadioGroupContainer.setFollowChildEnabled(true);
      visitDemandRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      visitDemandRadioGroupContainer.add(getVisitDemandRadioGroup(), null);
    }
    return visitDemandRadioGroupContainer;
  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f�����擾���܂��B
   * @return ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f��
   */
  protected ACListModelAdapter getVisitDemandRadioGroupModel(){
    if(visitDemandRadioGroupModel==null){
      visitDemandRadioGroupModel = new ACListModelAdapter();
      addVisitDemandRadioGroupModel();
    }
    return visitDemandRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getVisitDemandRadioItem1(){
    if(visitDemandRadioItem1==null){

      visitDemandRadioItem1 = new ACRadioButtonItem();

      visitDemandRadioItem1.setText("�Ȃ�");

      visitDemandRadioItem1.setGroup(getVisitDemandRadioGroup());

      visitDemandRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitDemandRadioItem1();
    }
    return visitDemandRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getVisitDemandRadioItem2(){
    if(visitDemandRadioItem2==null){

      visitDemandRadioItem2 = new ACRadioButtonItem();

      visitDemandRadioItem2.setText("����");

      visitDemandRadioItem2.setGroup(getVisitDemandRadioGroup());

      visitDemandRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addVisitDemandRadioItem2();
    }
    return visitDemandRadioItem2;

  }

  /**
   * �Z���W�����n�r�����{���Z���擾���܂��B
   * @return �Z���W�����n�r�����{���Z
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabiliShortConcentrationAddRadio(){
    if(houmonRehabiliShortConcentrationAddRadio==null){

      houmonRehabiliShortConcentrationAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabiliShortConcentrationAddRadioContainer().setText("�Z���W�����n�r�����{���Z");

      houmonRehabiliShortConcentrationAddRadio.setBindPath("1640103");

      houmonRehabiliShortConcentrationAddRadio.setUseClearButton(false);

      houmonRehabiliShortConcentrationAddRadio.setModel(getHoumonRehabiliShortConcentrationAddRadioModel());

      houmonRehabiliShortConcentrationAddRadio.setValues(new int[]{1,2});

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
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabiliShortConcentrationAddRadioItem2(){
    if(houmonRehabiliShortConcentrationAddRadioItem2==null){

      houmonRehabiliShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabiliShortConcentrationAddRadioItem2.setText("����");

      houmonRehabiliShortConcentrationAddRadioItem2.setGroup(getHoumonRehabiliShortConcentrationAddRadio());

      houmonRehabiliShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabiliShortConcentrationAddRadioItem2();
    }
    return houmonRehabiliShortConcentrationAddRadioItem2;

  }

  /**
   * �K����A�g���Z���擾���܂��B
   * @return �K����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getCareVisitsCoordinationAddRadioGroup(){
    if(careVisitsCoordinationAddRadioGroup==null){

      careVisitsCoordinationAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getCareVisitsCoordinationAddRadioGroupContainer().setText("�K����A�g���Z");

      careVisitsCoordinationAddRadioGroup.setBindPath("1640105");

      careVisitsCoordinationAddRadioGroup.setUseClearButton(false);

      careVisitsCoordinationAddRadioGroup.setModel(getCareVisitsCoordinationAddRadioGroupModel());

      careVisitsCoordinationAddRadioGroup.setValues(new int[]{1,2});

      addCareVisitsCoordinationAddRadioGroup();
    }
    return careVisitsCoordinationAddRadioGroup;

  }

  /**
   * �K����A�g���Z�R���e�i���擾���܂��B
   * @return �K����A�g���Z�R���e�i
   */
  protected ACLabelContainer getCareVisitsCoordinationAddRadioGroupContainer(){
    if(careVisitsCoordinationAddRadioGroupContainer==null){
      careVisitsCoordinationAddRadioGroupContainer = new ACLabelContainer();
      careVisitsCoordinationAddRadioGroupContainer.setFollowChildEnabled(true);
      careVisitsCoordinationAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      careVisitsCoordinationAddRadioGroupContainer.add(getCareVisitsCoordinationAddRadioGroup(), null);
    }
    return careVisitsCoordinationAddRadioGroupContainer;
  }

  /**
   * �K����A�g���Z���f�����擾���܂��B
   * @return �K����A�g���Z���f��
   */
  protected ACListModelAdapter getCareVisitsCoordinationAddRadioGroupModel(){
    if(careVisitsCoordinationAddRadioGroupModel==null){
      careVisitsCoordinationAddRadioGroupModel = new ACListModelAdapter();
      addCareVisitsCoordinationAddRadioGroupModel();
    }
    return careVisitsCoordinationAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getCareVisitsCoordinationAddRadioItem1(){
    if(careVisitsCoordinationAddRadioItem1==null){

      careVisitsCoordinationAddRadioItem1 = new ACRadioButtonItem();

      careVisitsCoordinationAddRadioItem1.setText("�Ȃ�");

      careVisitsCoordinationAddRadioItem1.setGroup(getCareVisitsCoordinationAddRadioGroup());

      careVisitsCoordinationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addCareVisitsCoordinationAddRadioItem1();
    }
    return careVisitsCoordinationAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getCareVisitsCoordinationAddRadioItem2(){
    if(careVisitsCoordinationAddRadioItem2==null){

      careVisitsCoordinationAddRadioItem2 = new ACRadioButtonItem();

      careVisitsCoordinationAddRadioItem2.setText("����");

      careVisitsCoordinationAddRadioItem2.setGroup(getCareVisitsCoordinationAddRadioGroup());

      careVisitsCoordinationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addCareVisitsCoordinationAddRadioItem2();
    }
    return careVisitsCoordinationAddRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1640104");

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
   * �R���X�g���N�^�ł��B
   */
  public QS001_16411_201504Design() {

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

    houmonRehabilitationPatterns.add(getVisitDemandRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabiliShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getCareVisitsCoordinationAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabilitationTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitDemandRadioGroup(){

  }

  /**
   * ���ꌚ�����Z�҂ւ̃T�[�r�X�񋟃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitDemandRadioGroupModel(){

    getVisitDemandRadioItem1().setButtonIndex(1);

    getVisitDemandRadioGroupModel().add(getVisitDemandRadioItem1());

    getVisitDemandRadioItem2().setButtonIndex(2);

    getVisitDemandRadioGroupModel().add(getVisitDemandRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitDemandRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitDemandRadioItem2(){

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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioItem2(){

  }

  /**
   * �K����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareVisitsCoordinationAddRadioGroup(){

  }

  /**
   * �K����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareVisitsCoordinationAddRadioGroupModel(){

    getCareVisitsCoordinationAddRadioItem1().setButtonIndex(1);

    getCareVisitsCoordinationAddRadioGroupModel().add(getCareVisitsCoordinationAddRadioItem1());

    getCareVisitsCoordinationAddRadioItem2().setButtonIndex(2);

    getCareVisitsCoordinationAddRadioGroupModel().add(getCareVisitsCoordinationAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareVisitsCoordinationAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareVisitsCoordinationAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_16411_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_16411_201504Design getThis() {
    return this;
  }
}
