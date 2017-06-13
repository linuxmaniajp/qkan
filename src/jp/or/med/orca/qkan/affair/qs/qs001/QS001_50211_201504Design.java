
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
 * �J����: �����@���̂�
 * �쐬��: 2016/12/02  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K��^�T�[�r�X�i�Ǝ��j (QS001_50211_201504)
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
 * �T�[�r�X�p�^�[���K��^�T�[�r�X�i�Ǝ��j��ʍ��ڃf�U�C��(QS001_50211_201504) 
 */
public class QS001_50211_201504Design extends QS001ServicePanelSogo {
  //GUI�R���|�[�l���g

  private JTabbedPane preventiveVisitCareMultiPatterns;

  private ACPanel tab1;

  private ACLabelContainer insurerContainer;

  private ACComboBox insurerName;

  private ACComboBoxModelAdapter insurerNameModel;

  private ACComboBox servicePattern;

  private ACComboBoxModelAdapter servicePatternModel;

  private ACValueArrayRadioButtonGroup visitCareExpenseAddRadio;

  private ACLabelContainer visitCareExpenseAddRadioContainer;

  private ACListModelAdapter visitCareExpenseAddRadioModel;

  private ACRadioButtonItem visitCareExpenseAddRadioItem1;

  private ACRadioButtonItem visitCareExpenseAddRadioItem2;

  private ACRadioButtonItem visitCareExpenseAddRadioItem3;

  private ACRadioButtonItem visitCareExpenseAddRadioItem4;

  private ACRadioButtonItem visitCareExpenseAddRadioItem5;

  private ACRadioButtonItem visitCareExpenseAddRadioItem6;

  private ACRadioButtonItem visitCareExpenseAddRadioItem7;

  private ACValueArrayRadioButtonGroup classEmploymentAddRadio;

  private ACLabelContainer classEmploymentAddRadioContainer;

  private ACListModelAdapter classEmploymentAddRadioModel;

  private ACRadioButtonItem classEmploymentAddRadioItem1;

  private ACRadioButtonItem classEmploymentAddRadioItem2;

  private ACValueArrayRadioButtonGroup visitDemandRadioGroup;

  private ACLabelContainer visitDemandRadioGroupContainer;

  private ACListModelAdapter visitDemandRadioGroupModel;

  private ACRadioButtonItem visitDemandRadioItem1;

  private ACRadioButtonItem visitDemandRadioItem2;

  private ACValueArrayRadioButtonGroup houmonKaigoFirstAddRadioGroup;

  private ACLabelContainer houmonKaigoFirstAddRadioGroupContainer;

  private ACListModelAdapter houmonKaigoFirstAddRadioGroupModel;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem1;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem2;

  private ACValueArrayRadioButtonGroup rehabilitationProAddRadioGroup;

  private ACLabelContainer rehabilitationProAddRadioGroupContainer;

  private ACListModelAdapter rehabilitationProAddRadioGroupModel;

  private ACRadioButtonItem rehabilitationProAddRadioItem1;

  private ACRadioButtonItem rehabilitationProAddRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  private ACPanel tab2;

  private ACGroupBox infoGroup;

  private ACLabel infoLabel;

  //getter

  /**
   * �K��^�T�[�r�X�p�^�[���̈���擾���܂��B
   * @return �K��^�T�[�r�X�p�^�[���̈�
   */
  public JTabbedPane getPreventiveVisitCareMultiPatterns(){
    if(preventiveVisitCareMultiPatterns==null){

      preventiveVisitCareMultiPatterns = new JTabbedPane();

      addPreventiveVisitCareMultiPatterns();
    }
    return preventiveVisitCareMultiPatterns;

  }

  /**
   * �^�u1���擾���܂��B
   * @return �^�u1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �ی��҃R���e�i���擾���܂��B
   * @return �ی��҃R���e�i
   */
  public ACLabelContainer getInsurerContainer(){
    if(insurerContainer==null){

      insurerContainer = new ACLabelContainer();

      insurerContainer.setText("�ی��Җ�");

      insurerContainer.setFollowChildEnabled(true);

      addInsurerContainer();
    }
    return insurerContainer;

  }

  /**
   * �ی��Җ����擾���܂��B
   * @return �ی��Җ�
   */
  public ACComboBox getInsurerName(){
    if(insurerName==null){

      insurerName = new ACComboBox();

      insurerName.setBindPath("500");

      insurerName.setEditable(false);

      insurerName.setColumns(7);

      insurerName.setModelBindPath("INSURER");

      insurerName.setRenderBindPath("INSURER_NAME");

      insurerName.setModel(getInsurerNameModel());

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * �ی��Җ����f�����擾���܂��B
   * @return �ی��Җ����f��
   */
  protected ACComboBoxModelAdapter getInsurerNameModel(){
    if(insurerNameModel==null){
      insurerNameModel = new ACComboBoxModelAdapter();
      addInsurerNameModel();
    }
    return insurerNameModel;
  }

  /**
   * �p�^�[�����擾���܂��B
   * @return �p�^�[��
   */
  public ACComboBox getServicePattern(){
    if(servicePattern==null){

      servicePattern = new ACComboBox();

      servicePattern.setBindPath("5020106");

      servicePattern.setEditable(false);

      servicePattern.setColumns(5);

      servicePattern.setModelBindPath("5020106");

      servicePattern.setRenderBindPath("CONTENT");

      servicePattern.setModel(getServicePatternModel());

      addServicePattern();
    }
    return servicePattern;

  }

  /**
   * �p�^�[�����f�����擾���܂��B
   * @return �p�^�[�����f��
   */
  protected ACComboBoxModelAdapter getServicePatternModel(){
    if(servicePatternModel==null){
      servicePatternModel = new ACComboBoxModelAdapter();
      addServicePatternModel();
    }
    return servicePatternModel;
  }

  /**
   * �K��^�T�[�r�X����擾���܂��B
   * @return �K��^�T�[�r�X��
   */
  public ACValueArrayRadioButtonGroup getVisitCareExpenseAddRadio(){
    if(visitCareExpenseAddRadio==null){

      visitCareExpenseAddRadio = new ACValueArrayRadioButtonGroup();

      getVisitCareExpenseAddRadioContainer().setText("�K��^" + ACConstants.LINE_SEPARATOR + "�T�[�r�X��");

      visitCareExpenseAddRadio.setBindPath("5020101");

      visitCareExpenseAddRadio.setUseClearButton(false);

      visitCareExpenseAddRadio.setModel(getVisitCareExpenseAddRadioModel());

      visitCareExpenseAddRadio.setValues(new int[]{1,2,3,4,5,6,7});

      addVisitCareExpenseAddRadio();
    }
    return visitCareExpenseAddRadio;

  }

  /**
   * �K��^�T�[�r�X��R���e�i���擾���܂��B
   * @return �K��^�T�[�r�X��R���e�i
   */
  protected ACLabelContainer getVisitCareExpenseAddRadioContainer(){
    if(visitCareExpenseAddRadioContainer==null){
      visitCareExpenseAddRadioContainer = new ACLabelContainer();
      visitCareExpenseAddRadioContainer.setFollowChildEnabled(true);
      visitCareExpenseAddRadioContainer.setVAlignment(VRLayout.CENTER);
      visitCareExpenseAddRadioContainer.add(getVisitCareExpenseAddRadio(), null);
    }
    return visitCareExpenseAddRadioContainer;
  }

  /**
   * �K��^�T�[�r�X��f�����擾���܂��B
   * @return �K��^�T�[�r�X��f��
   */
  protected ACListModelAdapter getVisitCareExpenseAddRadioModel(){
    if(visitCareExpenseAddRadioModel==null){
      visitCareExpenseAddRadioModel = new ACListModelAdapter();
      addVisitCareExpenseAddRadioModel();
    }
    return visitCareExpenseAddRadioModel;
  }

  /**
   * �T�^���擾���܂��B
   * @return �T�^
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem1(){
    if(visitCareExpenseAddRadioItem1==null){

      visitCareExpenseAddRadioItem1 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem1.setText("I�^");

      visitCareExpenseAddRadioItem1.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem1.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem1();
    }
    return visitCareExpenseAddRadioItem1;

  }

  /**
   * �U�^���擾���܂��B
   * @return �U�^
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem2(){
    if(visitCareExpenseAddRadioItem2==null){

      visitCareExpenseAddRadioItem2 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem2.setText("II�^");

      visitCareExpenseAddRadioItem2.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem2();
    }
    return visitCareExpenseAddRadioItem2;

  }

  /**
   * �V�^���擾���܂��B
   * @return �V�^
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem3(){
    if(visitCareExpenseAddRadioItem3==null){

      visitCareExpenseAddRadioItem3 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem3.setText("III�^");

      visitCareExpenseAddRadioItem3.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addVisitCareExpenseAddRadioItem3();
    }
    return visitCareExpenseAddRadioItem3;

  }

  /**
   * �W�^���擾���܂��B
   * @return �W�^
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem4(){
    if(visitCareExpenseAddRadioItem4==null){

      visitCareExpenseAddRadioItem4 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem4.setText("IV�^");

      visitCareExpenseAddRadioItem4.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem4.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem4();
    }
    return visitCareExpenseAddRadioItem4;

  }

  /**
   * �X�^���擾���܂��B
   * @return �X�^
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem5(){
    if(visitCareExpenseAddRadioItem5==null){

      visitCareExpenseAddRadioItem5 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem5.setText("V�^");

      visitCareExpenseAddRadioItem5.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem5.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem5();
    }
    return visitCareExpenseAddRadioItem5;

  }

  /**
   * �Y�^���擾���܂��B
   * @return �Y�^
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem6(){
    if(visitCareExpenseAddRadioItem6==null){

      visitCareExpenseAddRadioItem6 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem6.setText("VI�^");

      visitCareExpenseAddRadioItem6.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem6.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem6();
    }
    return visitCareExpenseAddRadioItem6;

  }

  /**
   * �Z���Ԍ^���擾���܂��B
   * @return �Z���Ԍ^
   */
  public ACRadioButtonItem getVisitCareExpenseAddRadioItem7(){
    if(visitCareExpenseAddRadioItem7==null){

      visitCareExpenseAddRadioItem7 = new ACRadioButtonItem();

      visitCareExpenseAddRadioItem7.setText("�Z���Ԍ^");

      visitCareExpenseAddRadioItem7.setGroup(getVisitCareExpenseAddRadio());

      visitCareExpenseAddRadioItem7.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem7();
    }
    return visitCareExpenseAddRadioItem7;

  }

  /**
   * �T�[�r�X�񋟐ӔC�҂̋��E���擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�҂̋��E
   */
  public ACValueArrayRadioButtonGroup getClassEmploymentAddRadio(){
    if(classEmploymentAddRadio==null){

      classEmploymentAddRadio = new ACValueArrayRadioButtonGroup();

      getClassEmploymentAddRadioContainer().setText("�T�[�r�X�񋟐ӔC�҂̋��E");

      classEmploymentAddRadio.setBindPath("5020102");

      classEmploymentAddRadio.setUseClearButton(false);

      classEmploymentAddRadio.setModel(getClassEmploymentAddRadioModel());

      classEmploymentAddRadio.setValues(new int[]{1,2});

      addClassEmploymentAddRadio();
    }
    return classEmploymentAddRadio;

  }

  /**
   * �T�[�r�X�񋟐ӔC�҂̋��E�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�҂̋��E�R���e�i
   */
  protected ACLabelContainer getClassEmploymentAddRadioContainer(){
    if(classEmploymentAddRadioContainer==null){
      classEmploymentAddRadioContainer = new ACLabelContainer();
      classEmploymentAddRadioContainer.setFollowChildEnabled(true);
      classEmploymentAddRadioContainer.setVAlignment(VRLayout.CENTER);
      classEmploymentAddRadioContainer.add(getClassEmploymentAddRadio(), null);
    }
    return classEmploymentAddRadioContainer;
  }

  /**
   * �T�[�r�X�񋟐ӔC�҂̋��E���f�����擾���܂��B
   * @return �T�[�r�X�񋟐ӔC�҂̋��E���f��
   */
  protected ACListModelAdapter getClassEmploymentAddRadioModel(){
    if(classEmploymentAddRadioModel==null){
      classEmploymentAddRadioModel = new ACListModelAdapter();
      addClassEmploymentAddRadioModel();
    }
    return classEmploymentAddRadioModel;
  }

  /**
   * ���C�ȊO���擾���܂��B
   * @return ���C�ȊO
   */
  public ACRadioButtonItem getClassEmploymentAddRadioItem1(){
    if(classEmploymentAddRadioItem1==null){

      classEmploymentAddRadioItem1 = new ACRadioButtonItem();

      classEmploymentAddRadioItem1.setText("���C�ȊO");

      classEmploymentAddRadioItem1.setGroup(getClassEmploymentAddRadio());

      classEmploymentAddRadioItem1.setConstraints(VRLayout.FLOW);

      addClassEmploymentAddRadioItem1();
    }
    return classEmploymentAddRadioItem1;

  }

  /**
   * ���C���擾���܂��B
   * @return ���C
   */
  public ACRadioButtonItem getClassEmploymentAddRadioItem2(){
    if(classEmploymentAddRadioItem2==null){

      classEmploymentAddRadioItem2 = new ACRadioButtonItem();

      classEmploymentAddRadioItem2.setText("���C");

      classEmploymentAddRadioItem2.setGroup(getClassEmploymentAddRadio());

      classEmploymentAddRadioItem2.setConstraints(VRLayout.FLOW);

      addClassEmploymentAddRadioItem2();
    }
    return classEmploymentAddRadioItem2;

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

      visitDemandRadioItem2.setConstraints(VRLayout.FLOW);

      addVisitDemandRadioItem2();
    }
    return visitDemandRadioItem2;

  }

  /**
   * ������Z���擾���܂��B
   * @return ������Z
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoFirstAddRadioGroup(){
    if(houmonKaigoFirstAddRadioGroup==null){

      houmonKaigoFirstAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoFirstAddRadioGroupContainer().setText("������Z");

      houmonKaigoFirstAddRadioGroup.setBindPath("5020104");

      houmonKaigoFirstAddRadioGroup.setNoSelectIndex(0);

      houmonKaigoFirstAddRadioGroup.setUseClearButton(false);

      houmonKaigoFirstAddRadioGroup.setModel(getHoumonKaigoFirstAddRadioGroupModel());

      houmonKaigoFirstAddRadioGroup.setValues(new int[]{1,2});

      addHoumonKaigoFirstAddRadioGroup();
    }
    return houmonKaigoFirstAddRadioGroup;

  }

  /**
   * ������Z�R���e�i���擾���܂��B
   * @return ������Z�R���e�i
   */
  protected ACLabelContainer getHoumonKaigoFirstAddRadioGroupContainer(){
    if(houmonKaigoFirstAddRadioGroupContainer==null){
      houmonKaigoFirstAddRadioGroupContainer = new ACLabelContainer();
      houmonKaigoFirstAddRadioGroupContainer.setFollowChildEnabled(true);
      houmonKaigoFirstAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoFirstAddRadioGroupContainer.add(getHoumonKaigoFirstAddRadioGroup(), null);
    }
    return houmonKaigoFirstAddRadioGroupContainer;
  }

  /**
   * ������Z���f�����擾���܂��B
   * @return ������Z���f��
   */
  protected ACListModelAdapter getHoumonKaigoFirstAddRadioGroupModel(){
    if(houmonKaigoFirstAddRadioGroupModel==null){
      houmonKaigoFirstAddRadioGroupModel = new ACListModelAdapter();
      addHoumonKaigoFirstAddRadioGroupModel();
    }
    return houmonKaigoFirstAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKaigoFirstAddRadioItem1(){
    if(houmonKaigoFirstAddRadioItem1==null){

      houmonKaigoFirstAddRadioItem1 = new ACRadioButtonItem();

      houmonKaigoFirstAddRadioItem1.setText("�Ȃ�");

      houmonKaigoFirstAddRadioItem1.setGroup(getHoumonKaigoFirstAddRadioGroup());

      houmonKaigoFirstAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKaigoFirstAddRadioItem1();
    }
    return houmonKaigoFirstAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKaigoFirstAddRadioItem2(){
    if(houmonKaigoFirstAddRadioItem2==null){

      houmonKaigoFirstAddRadioItem2 = new ACRadioButtonItem();

      houmonKaigoFirstAddRadioItem2.setText("����");

      houmonKaigoFirstAddRadioItem2.setGroup(getHoumonKaigoFirstAddRadioGroup());

      houmonKaigoFirstAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKaigoFirstAddRadioItem2();
    }
    return houmonKaigoFirstAddRadioItem2;

  }

  /**
   * �����@�\����A�g���Z���擾���܂��B
   * @return �����@�\����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getRehabilitationProAddRadioGroup(){
    if(rehabilitationProAddRadioGroup==null){

      rehabilitationProAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getRehabilitationProAddRadioGroupContainer().setText("�����@�\����A�g���Z");

      rehabilitationProAddRadioGroup.setBindPath("5020105");

      rehabilitationProAddRadioGroup.setNoSelectIndex(0);

      rehabilitationProAddRadioGroup.setUseClearButton(false);

      rehabilitationProAddRadioGroup.setModel(getRehabilitationProAddRadioGroupModel());

      rehabilitationProAddRadioGroup.setValues(new int[]{1,2});

      addRehabilitationProAddRadioGroup();
    }
    return rehabilitationProAddRadioGroup;

  }

  /**
   * �����@�\����A�g���Z�R���e�i���擾���܂��B
   * @return �����@�\����A�g���Z�R���e�i
   */
  protected ACLabelContainer getRehabilitationProAddRadioGroupContainer(){
    if(rehabilitationProAddRadioGroupContainer==null){
      rehabilitationProAddRadioGroupContainer = new ACLabelContainer();
      rehabilitationProAddRadioGroupContainer.setFollowChildEnabled(true);
      rehabilitationProAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationProAddRadioGroupContainer.add(getRehabilitationProAddRadioGroup(), null);
    }
    return rehabilitationProAddRadioGroupContainer;
  }

  /**
   * �����@�\����A�g���Z���f�����擾���܂��B
   * @return �����@�\����A�g���Z���f��
   */
  protected ACListModelAdapter getRehabilitationProAddRadioGroupModel(){
    if(rehabilitationProAddRadioGroupModel==null){
      rehabilitationProAddRadioGroupModel = new ACListModelAdapter();
      addRehabilitationProAddRadioGroupModel();
    }
    return rehabilitationProAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRehabilitationProAddRadioItem1(){
    if(rehabilitationProAddRadioItem1==null){

      rehabilitationProAddRadioItem1 = new ACRadioButtonItem();

      rehabilitationProAddRadioItem1.setText("�Ȃ�");

      rehabilitationProAddRadioItem1.setGroup(getRehabilitationProAddRadioGroup());

      rehabilitationProAddRadioItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationProAddRadioItem1();
    }
    return rehabilitationProAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRehabilitationProAddRadioItem2(){
    if(rehabilitationProAddRadioItem2==null){

      rehabilitationProAddRadioItem2 = new ACRadioButtonItem();

      rehabilitationProAddRadioItem2.setText("����");

      rehabilitationProAddRadioItem2.setGroup(getRehabilitationProAddRadioGroup());

      rehabilitationProAddRadioItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationProAddRadioItem2();
    }
    return rehabilitationProAddRadioItem2;

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
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("����");

      crackOnDayCheck.setBindPath("5020103");

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
  public ACBackLabelContainer getHoumonKaigoTimeContainer(){
    if(houmonKaigoTimeContainer==null){

      houmonKaigoTimeContainer = new ACBackLabelContainer();

      houmonKaigoTimeContainer.setFollowChildEnabled(true);

      addHoumonKaigoTimeContainer();
    }
    return houmonKaigoTimeContainer;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHoumonKaigoBeginTime(){
    if(houmonKaigoBeginTime==null){

      houmonKaigoBeginTime = new ACTimeComboBox();

      getHoumonKaigoBeginTimeContainer().setText("�J�n����");

      houmonKaigoBeginTime.setBindPath("3");

      houmonKaigoBeginTime.setModelBindPath("3");

      houmonKaigoBeginTime.setRenderBindPath("CONTENT");

      houmonKaigoBeginTime.setModel(getHoumonKaigoBeginTimeModel());

      addHoumonKaigoBeginTime();
    }
    return houmonKaigoBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHoumonKaigoBeginTimeContainer(){
    if(houmonKaigoBeginTimeContainer==null){
      houmonKaigoBeginTimeContainer = new ACLabelContainer();
      houmonKaigoBeginTimeContainer.setFollowChildEnabled(true);
      houmonKaigoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoBeginTimeContainer.add(getHoumonKaigoBeginTime(), null);
    }
    return houmonKaigoBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonKaigoBeginTimeModel(){
    if(houmonKaigoBeginTimeModel==null){
      houmonKaigoBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoBeginTimeModel();
    }
    return houmonKaigoBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHoumonKaigoEndTime(){
    if(houmonKaigoEndTime==null){

      houmonKaigoEndTime = new ACTimeComboBox();

      getHoumonKaigoEndTimeContainer().setText("�I������");

      houmonKaigoEndTime.setBindPath("4");

      houmonKaigoEndTime.setModelBindPath("4");

      houmonKaigoEndTime.setRenderBindPath("CONTENT");

      houmonKaigoEndTime.setModel(getHoumonKaigoEndTimeModel());

      addHoumonKaigoEndTime();
    }
    return houmonKaigoEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHoumonKaigoEndTimeContainer(){
    if(houmonKaigoEndTimeContainer==null){
      houmonKaigoEndTimeContainer = new ACLabelContainer();
      houmonKaigoEndTimeContainer.setFollowChildEnabled(true);
      houmonKaigoEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoEndTimeContainer.add(getHoumonKaigoEndTime(), null);
    }
    return houmonKaigoEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonKaigoEndTimeModel(){
    if(houmonKaigoEndTimeModel==null){
      houmonKaigoEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoEndTimeModel();
    }
    return houmonKaigoEndTimeModel;
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

      infoLabel.setText("���r���ŋ敪�ύX�ƂȂ�ꍇ�i�v�x��1�̗v�x��2�A" + ACConstants.LINE_SEPARATOR + "���ƑΏێҁ��v�x���j�e������T�[�r�X��S�Ă̓���" + ACConstants.LINE_SEPARATOR + "�\��t���A���ۂ̒񋟓��ɂ́w�񋟓��x�Ƀ`�F�b�N��" + ACConstants.LINE_SEPARATOR + "�k�ݒ�l�{�^�����N���b�N���Ă��������B");

      addInfoLabel();
    }
    return infoLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_50211_201504Design() {

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

    this.add(getPreventiveVisitCareMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * �K��^�T�[�r�X�p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPreventiveVisitCareMultiPatterns(){

    preventiveVisitCareMultiPatterns.addTab("1", getTab1());

    preventiveVisitCareMultiPatterns.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getInsurerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getVisitCareExpenseAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getClassEmploymentAddRadioContainer(), VRLayout.FLOW_RETURN);

    tab1.add(getVisitDemandRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoFirstAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getRehabilitationProAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getCrackOnDayCheck(), VRLayout.FLOW);

    tab1.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab1.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �ی��҃R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerContainer(){

    insurerContainer.add(getInsurerName(), VRLayout.FLOW);

    insurerContainer.add(getServicePattern(), VRLayout.FLOW);

  }

  /**
   * �ی��Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerName(){

  }

  /**
   * �ی��Җ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNameModel(){

  }

  /**
   * �p�^�[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServicePattern(){

  }

  /**
   * �p�^�[�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServicePatternModel(){

  }

  /**
   * �K��^�T�[�r�X��ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadio(){

  }

  /**
   * �K��^�T�[�r�X��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadioModel(){

    getVisitCareExpenseAddRadioItem1().setButtonIndex(1);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem1());

    getVisitCareExpenseAddRadioItem2().setButtonIndex(2);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem2());

    getVisitCareExpenseAddRadioItem3().setButtonIndex(3);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem3());

    getVisitCareExpenseAddRadioItem4().setButtonIndex(4);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem4());

    getVisitCareExpenseAddRadioItem5().setButtonIndex(5);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem5());

    getVisitCareExpenseAddRadioItem6().setButtonIndex(6);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem6());

    getVisitCareExpenseAddRadioItem7().setButtonIndex(7);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem7());

  }

  /**
   * �T�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadioItem1(){

  }

  /**
   * �U�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadioItem2(){

  }

  /**
   * �V�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadioItem3(){

  }

  /**
   * �W�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadioItem4(){

  }

  /**
   * �X�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadioItem5(){

  }

  /**
   * �Y�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadioItem6(){

  }

  /**
   * �Z���Ԍ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadioItem7(){

  }

  /**
   * �T�[�r�X�񋟐ӔC�҂̋��E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentAddRadio(){

  }

  /**
   * �T�[�r�X�񋟐ӔC�҂̋��E���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentAddRadioModel(){

    getClassEmploymentAddRadioItem1().setButtonIndex(1);

    getClassEmploymentAddRadioModel().add(getClassEmploymentAddRadioItem1());

    getClassEmploymentAddRadioItem2().setButtonIndex(2);

    getClassEmploymentAddRadioModel().add(getClassEmploymentAddRadioItem2());

  }

  /**
   * ���C�ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentAddRadioItem1(){

  }

  /**
   * ���C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentAddRadioItem2(){

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
   * ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoFirstAddRadioGroup(){

  }

  /**
   * ������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoFirstAddRadioGroupModel(){

    getHoumonKaigoFirstAddRadioItem1().setButtonIndex(1);

    getHoumonKaigoFirstAddRadioGroupModel().add(getHoumonKaigoFirstAddRadioItem1());

    getHoumonKaigoFirstAddRadioItem2().setButtonIndex(2);

    getHoumonKaigoFirstAddRadioGroupModel().add(getHoumonKaigoFirstAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoFirstAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoFirstAddRadioItem2(){

  }

  /**
   * �����@�\����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationProAddRadioGroup(){

  }

  /**
   * �����@�\����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationProAddRadioGroupModel(){

    getRehabilitationProAddRadioItem1().setButtonIndex(1);

    getRehabilitationProAddRadioGroupModel().add(getRehabilitationProAddRadioItem1());

    getRehabilitationProAddRadioItem2().setButtonIndex(2);

    getRehabilitationProAddRadioGroupModel().add(getRehabilitationProAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationProAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationProAddRadioItem2(){

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
  protected void addHoumonKaigoTimeContainer(){

    houmonKaigoTimeContainer.add(getHoumonKaigoBeginTimeContainer(), VRLayout.FLOW);

    houmonKaigoTimeContainer.add(getHoumonKaigoEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoEndTimeModel(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getInfoGroup(), VRLayout.FLOW);

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
      ACFrame.debugStart(new ACAffairInfo(QS001_50211_201504Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_50211_201504Design getThis() {
    return this;
  }
}
