
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
 * �쐬��: 2010/11/05  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� ����f�Ô��� (QS001199_H2104)
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
 * ����f�Ô��ʉ�ʍ��ڃf�U�C��(QS001199_H2104) 
 */
public class QS001199_H2104Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel specificConsultationFeePattern;

  private ACGroupBox guidanceManagement;

  private ACPanel guidanceManagements;

  private ACIntegerCheckBox infectionGuidanceManagement;

  private ACIntegerCheckBox bedGuidanceManagement;

  private ACIntegerCheckBox beginningGuidanceManagement;

  private ACIntegerCheckBox heavyRecuperateGuidanceManagement;

  private ACIntegerCheckBox particularInstitutionManagment;

  private ACIntegerCheckBox particularInstitutionManagmentPrivateRoom;

  private ACIntegerCheckBox particularInstitutionManagmentPrivateRoom2;

  private ACIntegerCheckBox heavySkinManegement;

  private ACIntegerCheckBox medicineManegementLeading;

  private ACIntegerCheckBox specialMedicineManagementLeading;

  private ACIntegerCheckBox medicalScienceInfo1;

  private ACIntegerCheckBox medicalScienceInfo2;

  private ACGroupBox rehabilitation;

  private ACGroupBox scienceTherapy;

  private ACPanel scienceTherapys;

  private ACLabelContainer scienceTherapy1Container;

  private ACIntegerCheckBox scienceTherapy1;

  private ACComboBox scienceTherapy1Combo;

  private ACComboBoxModelAdapter scienceTherapy1ComboModel;

  private ACLabelContainer scienceTherapy2Container;

  private ACIntegerCheckBox scienceTherapy2;

  private ACComboBox scienceTherapy2Combo;

  private ACComboBoxModelAdapter scienceTherapy2ComboModel;

  private ACLabelContainer science1Container;

  private ACLabel scienceLabel1;

  private ACIntegerCheckBox science1;

  private ACComboBox science1Combo;

  private ACComboBoxModelAdapter science1ComboModel;

  private ACLabelContainer science2Container;

  private ACIntegerCheckBox science2;

  private ACComboBox science2Combo;

  private ACComboBoxModelAdapter science2ComboModel;

  private ACIntegerCheckBox rehabilitationPlan;

  private ACIntegerCheckBox normalAction;

  private ACLabelContainer rehabilitationSystem1Container;

  private ACIntegerCheckBox rehabilitationSystem1;

  private ACComboBox rehabilitationSystem1Combo;

  private ACComboBoxModelAdapter rehabilitationSystem1ComboModel;

  private ACGroupBox workTherapyFrame;

  private ACPanel workTherapyFrames;

  private ACLabelContainer workTherapy1Conteiner;

  private ACIntegerCheckBox workTherapy1;

  private ACComboBox workTherapy1Combo;

  private ACComboBoxModelAdapter workTherapy1ComboModel;

  private ACLabelContainer work1Conteiner;

  private ACLabel reduce11Over;

  private ACIntegerCheckBox work1;

  private ACComboBox work1Combo;

  private ACComboBoxModelAdapter work1ComboModel;

  private ACIntegerCheckBox rehabilitationPlan2;

  private ACIntegerCheckBox normalActionTraning;

  private ACLabelContainer rehabilitationSystem2Container;

  private ACIntegerCheckBox rehabilitationSystem2;

  private ACComboBox rehabilitationSystem2Combo;

  private ACComboBoxModelAdapter rehabilitationSystem2ComboModel;

  private ACGroupBox etcFrame;

  private ACPanel etcFrames;

  private ACLabelContainer languageTherapy1Conteiner;

  private ACIntegerCheckBox languageTherapy1;

  private ACComboBox languageTherapy1Combo;

  private ACComboBoxModelAdapter languageTherapy1ComboModel;

  private ACLabelContainer language1Conteiner;

  private ACLabel language1Reduce;

  private ACIntegerCheckBox language1;

  private ACComboBox language1Combo;

  private ACComboBoxModelAdapter language1ComboModel;

  private ACLabelContainer rehabilitationSystem3Container;

  private ACIntegerCheckBox rehabilitationSystem3;

  private ACComboBox rehabilitationSystem3Combo;

  private ACComboBoxModelAdapter rehabilitationSystem3ComboModel;

  private ACIntegerCheckBox dinner;

  private ACIntegerCheckBox concentratedRehabilitation;

  private ACIntegerCheckBox groupCommunication;

  private ACIntegerCheckBox dementiaShortRehabilitation;

  private ACGroupBox mindFrame;

  private ACPanel mindFrames;

  private ACIntegerCheckBox mindTherapy;

  private ACIntegerCheckBox cognitive;

  private ACPanel buttons;

  private ACButton apply;

  //getter

  /**
   * ����f�Ô�ݒ�̈���擾���܂��B
   * @return ����f�Ô�ݒ�̈�
   */
  public ACPanel getSpecificConsultationFeePattern(){
    if(specificConsultationFeePattern==null){

      specificConsultationFeePattern = new ACPanel();

      addSpecificConsultationFeePattern();
    }
    return specificConsultationFeePattern;

  }

  /**
   * �w���Ǘ������擾���܂��B
   * @return �w���Ǘ���
   */
  public ACGroupBox getGuidanceManagement(){
    if(guidanceManagement==null){

      guidanceManagement = new ACGroupBox();

      guidanceManagement.setText("�w���Ǘ���");

      guidanceManagement.setPreferredSize(new Dimension(1,115));

      addGuidanceManagement();
    }
    return guidanceManagement;

  }

  /**
   * �w���Ǘ������擾���܂��B
   * @return �w���Ǘ���
   */
  public ACPanel getGuidanceManagements(){
    if(guidanceManagements==null){

      guidanceManagements = new ACPanel();

      addGuidanceManagements();
    }
    return guidanceManagements;

  }

  /**
   * �����΍�w���Ǘ����擾���܂��B
   * @return �����΍�w���Ǘ�
   */
  public ACIntegerCheckBox getInfectionGuidanceManagement(){
    if(infectionGuidanceManagement==null){

      infectionGuidanceManagement = new ACIntegerCheckBox();

      infectionGuidanceManagement.setText("�����΍�w���Ǘ�");

      infectionGuidanceManagement.setBindPath("3010101");

      addInfectionGuidanceManagement();
    }
    return infectionGuidanceManagement;

  }

  /**
   * ��጑΍�w���Ǘ����擾���܂��B
   * @return ��጑΍�w���Ǘ�
   */
  public ACIntegerCheckBox getBedGuidanceManagement(){
    if(bedGuidanceManagement==null){

      bedGuidanceManagement = new ACIntegerCheckBox();

      bedGuidanceManagement.setText("��጑΍�w���Ǘ�");

      bedGuidanceManagement.setBindPath("3010102");

      addBedGuidanceManagement();
    }
    return bedGuidanceManagement;

  }

  /**
   * �������@�f�ÊǗ����擾���܂��B
   * @return �������@�f�ÊǗ�
   */
  public ACIntegerCheckBox getBeginningGuidanceManagement(){
    if(beginningGuidanceManagement==null){

      beginningGuidanceManagement = new ACIntegerCheckBox();

      beginningGuidanceManagement.setText("�������@�f�ÊǗ�");

      beginningGuidanceManagement.setBindPath("3010103");

      addBeginningGuidanceManagement();
    }
    return beginningGuidanceManagement;

  }

  /**
   * �d�x�×{�Ǘ����擾���܂��B
   * @return �d�x�×{�Ǘ�
   */
  public ACIntegerCheckBox getHeavyRecuperateGuidanceManagement(){
    if(heavyRecuperateGuidanceManagement==null){

      heavyRecuperateGuidanceManagement = new ACIntegerCheckBox();

      heavyRecuperateGuidanceManagement.setText("�d�x�×{�Ǘ�");

      heavyRecuperateGuidanceManagement.setBindPath("3010104");

      addHeavyRecuperateGuidanceManagement();
    }
    return heavyRecuperateGuidanceManagement;

  }

  /**
   * ����{�݊Ǘ����擾���܂��B
   * @return ����{�݊Ǘ�
   */
  public ACIntegerCheckBox getParticularInstitutionManagment(){
    if(particularInstitutionManagment==null){

      particularInstitutionManagment = new ACIntegerCheckBox();

      particularInstitutionManagment.setText("����{�݊Ǘ�");

      particularInstitutionManagment.setBindPath("3010105");

      addParticularInstitutionManagment();
    }
    return particularInstitutionManagment;

  }

  /**
   * ����{�݊Ǘ������Z���擾���܂��B
   * @return ����{�݊Ǘ������Z
   */
  public ACIntegerCheckBox getParticularInstitutionManagmentPrivateRoom(){
    if(particularInstitutionManagmentPrivateRoom==null){

      particularInstitutionManagmentPrivateRoom = new ACIntegerCheckBox();

      particularInstitutionManagmentPrivateRoom.setText("����{�݊Ǘ������Z");

      particularInstitutionManagmentPrivateRoom.setBindPath("3010106");

      addParticularInstitutionManagmentPrivateRoom();
    }
    return particularInstitutionManagmentPrivateRoom;

  }

  /**
   * ����{�݊Ǘ�2�l�������Z���擾���܂��B
   * @return ����{�݊Ǘ�2�l�������Z
   */
  public ACIntegerCheckBox getParticularInstitutionManagmentPrivateRoom2(){
    if(particularInstitutionManagmentPrivateRoom2==null){

      particularInstitutionManagmentPrivateRoom2 = new ACIntegerCheckBox();

      particularInstitutionManagmentPrivateRoom2.setText("����{�݊Ǘ�2�l�������Z");

      particularInstitutionManagmentPrivateRoom2.setBindPath("3010107");

      addParticularInstitutionManagmentPrivateRoom2();
    }
    return particularInstitutionManagmentPrivateRoom2;

  }

  /**
   * �d�ǔ畆��ᇊǗ��w�����擾���܂��B
   * @return �d�ǔ畆��ᇊǗ��w��
   */
  public ACIntegerCheckBox getHeavySkinManegement(){
    if(heavySkinManegement==null){

      heavySkinManegement = new ACIntegerCheckBox();

      heavySkinManegement.setText("�d�ǔ畆��ᇊǗ��w��");

      heavySkinManegement.setBindPath("3010108");

      addHeavySkinManegement();
    }
    return heavySkinManegement;

  }

  /**
   * ��܊Ǘ��w�����擾���܂��B
   * @return ��܊Ǘ��w��
   */
  public ACIntegerCheckBox getMedicineManegementLeading(){
    if(medicineManegementLeading==null){

      medicineManegementLeading = new ACIntegerCheckBox();

      medicineManegementLeading.setText("��܊Ǘ��w��");

      medicineManegementLeading.setBindPath("3010110");

      addMedicineManegementLeading();
    }
    return medicineManegementLeading;

  }

  /**
   * ���ʖ�܊Ǘ��w�����Z���擾���܂��B
   * @return ���ʖ�܊Ǘ��w�����Z
   */
  public ACIntegerCheckBox getSpecialMedicineManagementLeading(){
    if(specialMedicineManagementLeading==null){

      specialMedicineManagementLeading = new ACIntegerCheckBox();

      specialMedicineManagementLeading.setText("���ʖ�܊Ǘ��w�����Z");

      specialMedicineManagementLeading.setBindPath("3010111");

      addSpecialMedicineManagementLeading();
    }
    return specialMedicineManagementLeading;

  }

  /**
   * ��w����(I)���擾���܂��B
   * @return ��w����(I)
   */
  public ACIntegerCheckBox getMedicalScienceInfo1(){
    if(medicalScienceInfo1==null){

      medicalScienceInfo1 = new ACIntegerCheckBox();

      medicalScienceInfo1.setText("��w����(I)");

      medicalScienceInfo1.setBindPath("3010112");

      addMedicalScienceInfo1();
    }
    return medicalScienceInfo1;

  }

  /**
   * ��w����(II)���擾���܂��B
   * @return ��w����(II)
   */
  public ACIntegerCheckBox getMedicalScienceInfo2(){
    if(medicalScienceInfo2==null){

      medicalScienceInfo2 = new ACIntegerCheckBox();

      medicalScienceInfo2.setText("��w����(II)");

      medicalScienceInfo2.setBindPath("3010113");

      addMedicalScienceInfo2();
    }
    return medicalScienceInfo2;

  }

  /**
   * ���n�r���e�[�V�����̈���擾���܂��B
   * @return ���n�r���e�[�V�����̈�
   */
  public ACGroupBox getRehabilitation(){
    if(rehabilitation==null){

      rehabilitation = new ACGroupBox();

      rehabilitation.setText("���n�r���e�[�V����");

      rehabilitation.setAutoWrap(false);

      rehabilitation.setHgap(0);

      rehabilitation.setLabelMargin(0);

      addRehabilitation();
    }
    return rehabilitation;

  }

  /**
   * ���w�Ö@�̈���擾���܂��B
   * @return ���w�Ö@�̈�
   */
  public ACGroupBox getScienceTherapy(){
    if(scienceTherapy==null){

      scienceTherapy = new ACGroupBox();

      scienceTherapy.setText("���w�Ö@");

      scienceTherapy.setPreferredSize(new Dimension(1,125));

      addScienceTherapy();
    }
    return scienceTherapy;

  }

  /**
   * ���w�Ö@�̈���擾���܂��B
   * @return ���w�Ö@�̈�
   */
  public ACPanel getScienceTherapys(){
    if(scienceTherapys==null){

      scienceTherapys = new ACPanel();

      addScienceTherapys();
    }
    return scienceTherapys;

  }

  /**
   * ���w�Ö@�R���e�i1���擾���܂��B
   * @return ���w�Ö@�R���e�i1
   */
  public ACLabelContainer getScienceTherapy1Container(){
    if(scienceTherapy1Container==null){

      scienceTherapy1Container = new ACLabelContainer();

      addScienceTherapy1Container();
    }
    return scienceTherapy1Container;

  }

  /**
   * ���w�Ö@(I)���擾���܂��B
   * @return ���w�Ö@(I)
   */
  public ACIntegerCheckBox getScienceTherapy1(){
    if(scienceTherapy1==null){

      scienceTherapy1 = new ACIntegerCheckBox();

      scienceTherapy1.setText("���w�Ö@(I)");

      addScienceTherapy1();
    }
    return scienceTherapy1;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getScienceTherapy1Combo(){
    if(scienceTherapy1Combo==null){

      scienceTherapy1Combo = new ACComboBox();

      scienceTherapy1Combo.setBindPath("3010116");

      scienceTherapy1Combo.setEnabled(false);

      scienceTherapy1Combo.setEditable(false);

      scienceTherapy1Combo.setModelBindPath("109");

      scienceTherapy1Combo.setRenderBindPath("CONTENT");

      scienceTherapy1Combo.setModel(getScienceTherapy1ComboModel());

      scienceTherapy1Combo.setPreferredSize(new Dimension(50,10));

      addScienceTherapy1Combo();
    }
    return scienceTherapy1Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getScienceTherapy1ComboModel(){
    if(scienceTherapy1ComboModel==null){
      scienceTherapy1ComboModel = new ACComboBoxModelAdapter();
      addScienceTherapy1ComboModel();
    }
    return scienceTherapy1ComboModel;
  }

  /**
   * ���w�Ö@�R���e�i2���擾���܂��B
   * @return ���w�Ö@�R���e�i2
   */
  public ACLabelContainer getScienceTherapy2Container(){
    if(scienceTherapy2Container==null){

      scienceTherapy2Container = new ACLabelContainer();

      addScienceTherapy2Container();
    }
    return scienceTherapy2Container;

  }

  /**
   * ���w�Ö@(II)���擾���܂��B
   * @return ���w�Ö@(II)
   */
  public ACIntegerCheckBox getScienceTherapy2(){
    if(scienceTherapy2==null){

      scienceTherapy2 = new ACIntegerCheckBox();

      scienceTherapy2.setText("���w�Ö@(II)");

      addScienceTherapy2();
    }
    return scienceTherapy2;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getScienceTherapy2Combo(){
    if(scienceTherapy2Combo==null){

      scienceTherapy2Combo = new ACComboBox();

      scienceTherapy2Combo.setBindPath("3010117");

      scienceTherapy2Combo.setEnabled(false);

      scienceTherapy2Combo.setEditable(false);

      scienceTherapy2Combo.setModelBindPath("109");

      scienceTherapy2Combo.setRenderBindPath("CONTENT");

      scienceTherapy2Combo.setModel(getScienceTherapy2ComboModel());

      scienceTherapy2Combo.setPreferredSize(new Dimension(50,10));

      addScienceTherapy2Combo();
    }
    return scienceTherapy2Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getScienceTherapy2ComboModel(){
    if(scienceTherapy2ComboModel==null){
      scienceTherapy2ComboModel = new ACComboBoxModelAdapter();
      addScienceTherapy2ComboModel();
    }
    return scienceTherapy2ComboModel;
  }

  /**
   * ���w�R���e�i1���擾���܂��B
   * @return ���w�R���e�i1
   */
  public ACLabelContainer getScience1Container(){
    if(science1Container==null){

      science1Container = new ACLabelContainer();

      addScience1Container();
    }
    return science1Container;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getScienceLabel1(){
    if(scienceLabel1==null){

      scienceLabel1 = new ACLabel();

      scienceLabel1.setText("11��ڈȍ~�̌��Z");

      addScienceLabel1();
    }
    return scienceLabel1;

  }

  /**
   * ���w(I)���擾���܂��B
   * @return ���w(I)
   */
  public ACIntegerCheckBox getScience1(){
    if(science1==null){

      science1 = new ACIntegerCheckBox();

      science1.setText("���w(I)");

      addScience1();
    }
    return science1;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getScience1Combo(){
    if(science1Combo==null){

      science1Combo = new ACComboBox();

      science1Combo.setBindPath("3010120");

      science1Combo.setEnabled(false);

      science1Combo.setEditable(false);

      science1Combo.setModelBindPath("109");

      science1Combo.setRenderBindPath("CONTENT");

      science1Combo.setModel(getScience1ComboModel());

      science1Combo.setPreferredSize(new Dimension(50,10));

      addScience1Combo();
    }
    return science1Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getScience1ComboModel(){
    if(science1ComboModel==null){
      science1ComboModel = new ACComboBoxModelAdapter();
      addScience1ComboModel();
    }
    return science1ComboModel;
  }

  /**
   * ���w�R���e�i2���擾���܂��B
   * @return ���w�R���e�i2
   */
  public ACLabelContainer getScience2Container(){
    if(science2Container==null){

      science2Container = new ACLabelContainer();

      addScience2Container();
    }
    return science2Container;

  }

  /**
   * ���w(II)���擾���܂��B
   * @return ���w(II)
   */
  public ACIntegerCheckBox getScience2(){
    if(science2==null){

      science2 = new ACIntegerCheckBox();

      science2.setText("���w(II)");

      addScience2();
    }
    return science2;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getScience2Combo(){
    if(science2Combo==null){

      science2Combo = new ACComboBox();

      science2Combo.setBindPath("3010121");

      science2Combo.setEnabled(false);

      science2Combo.setEditable(false);

      science2Combo.setModelBindPath("109");

      science2Combo.setRenderBindPath("CONTENT");

      science2Combo.setModel(getScience2ComboModel());

      science2Combo.setPreferredSize(new Dimension(50,10));

      addScience2Combo();
    }
    return science2Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getScience2ComboModel(){
    if(science2ComboModel==null){
      science2ComboModel = new ACComboBoxModelAdapter();
      addScience2ComboModel();
    }
    return science2ComboModel;
  }

  /**
   * ���n�r���v����Z���擾���܂��B
   * @return ���n�r���v����Z
   */
  public ACIntegerCheckBox getRehabilitationPlan(){
    if(rehabilitationPlan==null){

      rehabilitationPlan = new ACIntegerCheckBox();

      rehabilitationPlan.setText("���n�r���v����Z");

      rehabilitationPlan.setBindPath("3010123");

      addRehabilitationPlan();
    }
    return rehabilitationPlan;

  }

  /**
   * ���퓮��P���w�����Z���擾���܂��B
   * @return ���퓮��P���w�����Z
   */
  public ACIntegerCheckBox getNormalAction(){
    if(normalAction==null){

      normalAction = new ACIntegerCheckBox();

      normalAction.setText("���퓮��P���w�����Z");

      normalAction.setBindPath("3010124");

      addNormalAction();
    }
    return normalAction;

  }

  /**
   * ���n�r���̐��������Z�R���e�i���擾���܂��B
   * @return ���n�r���̐��������Z�R���e�i
   */
  public ACLabelContainer getRehabilitationSystem1Container(){
    if(rehabilitationSystem1Container==null){

      rehabilitationSystem1Container = new ACLabelContainer();

      addRehabilitationSystem1Container();
    }
    return rehabilitationSystem1Container;

  }

  /**
   * ���n�r���̐��������Z���擾���܂��B
   * @return ���n�r���̐��������Z
   */
  public ACIntegerCheckBox getRehabilitationSystem1(){
    if(rehabilitationSystem1==null){

      rehabilitationSystem1 = new ACIntegerCheckBox();

      rehabilitationSystem1.setText("���n�r���̐��������Z");

      addRehabilitationSystem1();
    }
    return rehabilitationSystem1;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getRehabilitationSystem1Combo(){
    if(rehabilitationSystem1Combo==null){

      rehabilitationSystem1Combo = new ACComboBox();

      rehabilitationSystem1Combo.setBindPath("3010139");

      rehabilitationSystem1Combo.setEnabled(false);

      rehabilitationSystem1Combo.setEditable(false);

      rehabilitationSystem1Combo.setModelBindPath("109");

      rehabilitationSystem1Combo.setRenderBindPath("CONTENT");

      rehabilitationSystem1Combo.setModel(getRehabilitationSystem1ComboModel());

      rehabilitationSystem1Combo.setPreferredSize(new Dimension(50,10));

      addRehabilitationSystem1Combo();
    }
    return rehabilitationSystem1Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getRehabilitationSystem1ComboModel(){
    if(rehabilitationSystem1ComboModel==null){
      rehabilitationSystem1ComboModel = new ACComboBoxModelAdapter();
      addRehabilitationSystem1ComboModel();
    }
    return rehabilitationSystem1ComboModel;
  }

  /**
   * ��ƗÖ@�t���[�����擾���܂��B
   * @return ��ƗÖ@�t���[��
   */
  public ACGroupBox getWorkTherapyFrame(){
    if(workTherapyFrame==null){

      workTherapyFrame = new ACGroupBox();

      workTherapyFrame.setText("��ƗÖ@");

      workTherapyFrame.setAutoWrap(false);

      workTherapyFrame.setPreferredSize(new Dimension(1,100));

      addWorkTherapyFrame();
    }
    return workTherapyFrame;

  }

  /**
   * ��ƗÖ@�̈���擾���܂��B
   * @return ��ƗÖ@�̈�
   */
  public ACPanel getWorkTherapyFrames(){
    if(workTherapyFrames==null){

      workTherapyFrames = new ACPanel();

      workTherapyFrames.setAutoWrap(false);

      addWorkTherapyFrames();
    }
    return workTherapyFrames;

  }

  /**
   * ��ƗÖ@I�R���e�i���擾���܂��B
   * @return ��ƗÖ@I�R���e�i
   */
  public ACLabelContainer getWorkTherapy1Conteiner(){
    if(workTherapy1Conteiner==null){

      workTherapy1Conteiner = new ACLabelContainer();

      addWorkTherapy1Conteiner();
    }
    return workTherapy1Conteiner;

  }

  /**
   * ��ƗÖ@I���擾���܂��B
   * @return ��ƗÖ@I
   */
  public ACIntegerCheckBox getWorkTherapy1(){
    if(workTherapy1==null){

      workTherapy1 = new ACIntegerCheckBox();

      workTherapy1.setText("��ƗÖ@");

      addWorkTherapy1();
    }
    return workTherapy1;

  }

  /**
   * ��ƗÖ@I�R���{���擾���܂��B
   * @return ��ƗÖ@I�R���{
   */
  public ACComboBox getWorkTherapy1Combo(){
    if(workTherapy1Combo==null){

      workTherapy1Combo = new ACComboBox();

      workTherapy1Combo.setBindPath("3010126");

      workTherapy1Combo.setEnabled(false);

      workTherapy1Combo.setEditable(false);

      workTherapy1Combo.setModelBindPath("109");

      workTherapy1Combo.setRenderBindPath("CONTENT");

      workTherapy1Combo.setModel(getWorkTherapy1ComboModel());

      workTherapy1Combo.setPreferredSize(new Dimension(50,10));

      addWorkTherapy1Combo();
    }
    return workTherapy1Combo;

  }

  /**
   * ��ƗÖ@I�R���{���f�����擾���܂��B
   * @return ��ƗÖ@I�R���{���f��
   */
  protected ACComboBoxModelAdapter getWorkTherapy1ComboModel(){
    if(workTherapy1ComboModel==null){
      workTherapy1ComboModel = new ACComboBoxModelAdapter();
      addWorkTherapy1ComboModel();
    }
    return workTherapy1ComboModel;
  }

  /**
   * ���I�R���e�i���擾���܂��B
   * @return ���I�R���e�i
   */
  public ACLabelContainer getWork1Conteiner(){
    if(work1Conteiner==null){

      work1Conteiner = new ACLabelContainer();

      addWork1Conteiner();
    }
    return work1Conteiner;

  }

  /**
   * 11��ڈȍ~�̌��Z���擾���܂��B
   * @return 11��ڈȍ~�̌��Z
   */
  public ACLabel getReduce11Over(){
    if(reduce11Over==null){

      reduce11Over = new ACLabel();

      reduce11Over.setText("11��ڈȍ~�̌��Z");

      addReduce11Over();
    }
    return reduce11Over;

  }

  /**
   * ���(I)���擾���܂��B
   * @return ���(I)
   */
  public ACIntegerCheckBox getWork1(){
    if(work1==null){

      work1 = new ACIntegerCheckBox();

      work1.setText("���");

      addWork1();
    }
    return work1;

  }

  /**
   * ���(I)�R���{���擾���܂��B
   * @return ���(I)�R���{
   */
  public ACComboBox getWork1Combo(){
    if(work1Combo==null){

      work1Combo = new ACComboBox();

      work1Combo.setBindPath("3010128");

      work1Combo.setEnabled(false);

      work1Combo.setEditable(false);

      work1Combo.setModelBindPath("109");

      work1Combo.setRenderBindPath("CONTENT");

      work1Combo.setModel(getWork1ComboModel());

      work1Combo.setPreferredSize(new Dimension(50,10));

      addWork1Combo();
    }
    return work1Combo;

  }

  /**
   * ���(I)�R���{���f�����擾���܂��B
   * @return ���(I)�R���{���f��
   */
  protected ACComboBoxModelAdapter getWork1ComboModel(){
    if(work1ComboModel==null){
      work1ComboModel = new ACComboBoxModelAdapter();
      addWork1ComboModel();
    }
    return work1ComboModel;
  }

  /**
   * ���n�r���v����Z���擾���܂��B
   * @return ���n�r���v����Z
   */
  public ACIntegerCheckBox getRehabilitationPlan2(){
    if(rehabilitationPlan2==null){

      rehabilitationPlan2 = new ACIntegerCheckBox();

      rehabilitationPlan2.setText("���n�r���v����Z");

      rehabilitationPlan2.setBindPath("3010130");

      addRehabilitationPlan2();
    }
    return rehabilitationPlan2;

  }

  /**
   * ���퓮��P���w�����Z���擾���܂��B
   * @return ���퓮��P���w�����Z
   */
  public ACIntegerCheckBox getNormalActionTraning(){
    if(normalActionTraning==null){

      normalActionTraning = new ACIntegerCheckBox();

      normalActionTraning.setText("���퓮��P���w�����Z");

      normalActionTraning.setBindPath("3010131");

      addNormalActionTraning();
    }
    return normalActionTraning;

  }

  /**
   * ���n�r���̐��������Z�R���e�i���擾���܂��B
   * @return ���n�r���̐��������Z�R���e�i
   */
  public ACLabelContainer getRehabilitationSystem2Container(){
    if(rehabilitationSystem2Container==null){

      rehabilitationSystem2Container = new ACLabelContainer();

      addRehabilitationSystem2Container();
    }
    return rehabilitationSystem2Container;

  }

  /**
   * ���n�r���̐��������Z���擾���܂��B
   * @return ���n�r���̐��������Z
   */
  public ACIntegerCheckBox getRehabilitationSystem2(){
    if(rehabilitationSystem2==null){

      rehabilitationSystem2 = new ACIntegerCheckBox();

      rehabilitationSystem2.setText("���n�r���̐��������Z");

      addRehabilitationSystem2();
    }
    return rehabilitationSystem2;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getRehabilitationSystem2Combo(){
    if(rehabilitationSystem2Combo==null){

      rehabilitationSystem2Combo = new ACComboBox();

      rehabilitationSystem2Combo.setBindPath("3010140");

      rehabilitationSystem2Combo.setEnabled(false);

      rehabilitationSystem2Combo.setEditable(false);

      rehabilitationSystem2Combo.setModelBindPath("109");

      rehabilitationSystem2Combo.setRenderBindPath("CONTENT");

      rehabilitationSystem2Combo.setModel(getRehabilitationSystem2ComboModel());

      rehabilitationSystem2Combo.setPreferredSize(new Dimension(50,10));

      addRehabilitationSystem2Combo();
    }
    return rehabilitationSystem2Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getRehabilitationSystem2ComboModel(){
    if(rehabilitationSystem2ComboModel==null){
      rehabilitationSystem2ComboModel = new ACComboBoxModelAdapter();
      addRehabilitationSystem2ComboModel();
    }
    return rehabilitationSystem2ComboModel;
  }

  /**
   * ���̑��̈���擾���܂��B
   * @return ���̑��̈�
   */
  public ACGroupBox getEtcFrame(){
    if(etcFrame==null){

      etcFrame = new ACGroupBox();

      etcFrame.setText("���̑�");

      etcFrame.setPreferredSize(new Dimension(1,110));

      addEtcFrame();
    }
    return etcFrame;

  }

  /**
   * ���̑��̈���擾���܂��B
   * @return ���̑��̈�
   */
  public ACPanel getEtcFrames(){
    if(etcFrames==null){

      etcFrames = new ACPanel();

      addEtcFrames();
    }
    return etcFrames;

  }

  /**
   * ���꒮�o�Ö@I�R���e�i���擾���܂��B
   * @return ���꒮�o�Ö@I�R���e�i
   */
  public ACLabelContainer getLanguageTherapy1Conteiner(){
    if(languageTherapy1Conteiner==null){

      languageTherapy1Conteiner = new ACLabelContainer();

      addLanguageTherapy1Conteiner();
    }
    return languageTherapy1Conteiner;

  }

  /**
   * ���꒮�o�Ö@I���擾���܂��B
   * @return ���꒮�o�Ö@I
   */
  public ACIntegerCheckBox getLanguageTherapy1(){
    if(languageTherapy1==null){

      languageTherapy1 = new ACIntegerCheckBox();

      languageTherapy1.setText("���꒮�o�Ö@");

      addLanguageTherapy1();
    }
    return languageTherapy1;

  }

  /**
   * ���꒮�o�Ö@I�R���{���擾���܂��B
   * @return ���꒮�o�Ö@I�R���{
   */
  public ACComboBox getLanguageTherapy1Combo(){
    if(languageTherapy1Combo==null){

      languageTherapy1Combo = new ACComboBox();

      languageTherapy1Combo.setBindPath("3010133");

      languageTherapy1Combo.setEnabled(false);

      languageTherapy1Combo.setEditable(false);

      languageTherapy1Combo.setModelBindPath("109");

      languageTherapy1Combo.setRenderBindPath("CONTENT");

      languageTherapy1Combo.setModel(getLanguageTherapy1ComboModel());

      languageTherapy1Combo.setPreferredSize(new Dimension(50,10));

      addLanguageTherapy1Combo();
    }
    return languageTherapy1Combo;

  }

  /**
   * ���꒮�o�Ö@I�R���{���f�����擾���܂��B
   * @return ���꒮�o�Ö@I�R���{���f��
   */
  protected ACComboBoxModelAdapter getLanguageTherapy1ComboModel(){
    if(languageTherapy1ComboModel==null){
      languageTherapy1ComboModel = new ACComboBoxModelAdapter();
      addLanguageTherapy1ComboModel();
    }
    return languageTherapy1ComboModel;
  }

  /**
   * ���꒮�o�R���e�i���擾���܂��B
   * @return ���꒮�o�R���e�i
   */
  public ACLabelContainer getLanguage1Conteiner(){
    if(language1Conteiner==null){

      language1Conteiner = new ACLabelContainer();

      addLanguage1Conteiner();
    }
    return language1Conteiner;

  }

  /**
   * 11��ڈȍ~�̌��Z���擾���܂��B
   * @return 11��ڈȍ~�̌��Z
   */
  public ACLabel getLanguage1Reduce(){
    if(language1Reduce==null){

      language1Reduce = new ACLabel();

      language1Reduce.setText("11��ڈȍ~�̌��Z");

      addLanguage1Reduce();
    }
    return language1Reduce;

  }

  /**
   * ���꒮�o(I)���擾���܂��B
   * @return ���꒮�o(I)
   */
  public ACIntegerCheckBox getLanguage1(){
    if(language1==null){

      language1 = new ACIntegerCheckBox();

      language1.setText("���꒮�o");

      addLanguage1();
    }
    return language1;

  }

  /**
   * ���꒮�o(I)�R���{���擾���܂��B
   * @return ���꒮�o(I)�R���{
   */
  public ACComboBox getLanguage1Combo(){
    if(language1Combo==null){

      language1Combo = new ACComboBox();

      language1Combo.setBindPath("3010135");

      language1Combo.setEnabled(false);

      language1Combo.setEditable(false);

      language1Combo.setModelBindPath("109");

      language1Combo.setRenderBindPath("CONTENT");

      language1Combo.setModel(getLanguage1ComboModel());

      language1Combo.setPreferredSize(new Dimension(50,10));

      addLanguage1Combo();
    }
    return language1Combo;

  }

  /**
   * ���꒮�o(I)�R���{���f�����擾���܂��B
   * @return ���꒮�o(I)�R���{���f��
   */
  protected ACComboBoxModelAdapter getLanguage1ComboModel(){
    if(language1ComboModel==null){
      language1ComboModel = new ACComboBoxModelAdapter();
      addLanguage1ComboModel();
    }
    return language1ComboModel;
  }

  /**
   * ���n�r���̐��������Z�R���e�i���擾���܂��B
   * @return ���n�r���̐��������Z�R���e�i
   */
  public ACLabelContainer getRehabilitationSystem3Container(){
    if(rehabilitationSystem3Container==null){

      rehabilitationSystem3Container = new ACLabelContainer();

      addRehabilitationSystem3Container();
    }
    return rehabilitationSystem3Container;

  }

  /**
   * ���n�r���̐��������Z���擾���܂��B
   * @return ���n�r���̐��������Z
   */
  public ACIntegerCheckBox getRehabilitationSystem3(){
    if(rehabilitationSystem3==null){

      rehabilitationSystem3 = new ACIntegerCheckBox();

      rehabilitationSystem3.setText("���n�r���̐��������Z");

      addRehabilitationSystem3();
    }
    return rehabilitationSystem3;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getRehabilitationSystem3Combo(){
    if(rehabilitationSystem3Combo==null){

      rehabilitationSystem3Combo = new ACComboBox();

      rehabilitationSystem3Combo.setBindPath("3010141");

      rehabilitationSystem3Combo.setEnabled(false);

      rehabilitationSystem3Combo.setEditable(false);

      rehabilitationSystem3Combo.setModelBindPath("109");

      rehabilitationSystem3Combo.setRenderBindPath("CONTENT");

      rehabilitationSystem3Combo.setModel(getRehabilitationSystem3ComboModel());

      rehabilitationSystem3Combo.setPreferredSize(new Dimension(50,10));

      addRehabilitationSystem3Combo();
    }
    return rehabilitationSystem3Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getRehabilitationSystem3ComboModel(){
    if(rehabilitationSystem3ComboModel==null){
      rehabilitationSystem3ComboModel = new ACComboBoxModelAdapter();
      addRehabilitationSystem3ComboModel();
    }
    return rehabilitationSystem3ComboModel;
  }

  /**
   * �ېH�@�\�Ö@���擾���܂��B
   * @return �ېH�@�\�Ö@
   */
  public ACIntegerCheckBox getDinner(){
    if(dinner==null){

      dinner = new ACIntegerCheckBox();

      dinner.setText("�ېH�@�\�Ö@");

      dinner.setBindPath("3010136");

      addDinner();
    }
    return dinner;

  }

  /**
   * �Z���W�����n�r�����{���Z���擾���܂��B
   * @return �Z���W�����n�r�����{���Z
   */
  public ACIntegerCheckBox getConcentratedRehabilitation(){
    if(concentratedRehabilitation==null){

      concentratedRehabilitation = new ACIntegerCheckBox();

      concentratedRehabilitation.setText("�Z���W�����n�r�����{���Z");

      concentratedRehabilitation.setBindPath("3010143");

      addConcentratedRehabilitation();
    }
    return concentratedRehabilitation;

  }

  /**
   * �W�c�R�~���j�P�[�V�����Ö@���擾���܂��B
   * @return �W�c�R�~���j�P�[�V�����Ö@
   */
  public ACIntegerCheckBox getGroupCommunication(){
    if(groupCommunication==null){

      groupCommunication = new ACIntegerCheckBox();

      groupCommunication.setText("�W�c�R�~���j�P�[�V�����Ö@");

      groupCommunication.setBindPath("3010150");

      addGroupCommunication();
    }
    return groupCommunication;

  }

  /**
   * �F�m�ǒZ���W�����n�r�����Z���擾���܂��B
   * @return �F�m�ǒZ���W�����n�r�����Z
   */
  public ACIntegerCheckBox getDementiaShortRehabilitation(){
    if(dementiaShortRehabilitation==null){

      dementiaShortRehabilitation = new ACIntegerCheckBox();

      dementiaShortRehabilitation.setText("�F�m�ǒZ���W�����n�r�����Z");

      dementiaShortRehabilitation.setBindPath("3010151");

      addDementiaShortRehabilitation();
    }
    return dementiaShortRehabilitation;

  }

  /**
   * ���_�Ȑ��Ö@�t���[�����擾���܂��B
   * @return ���_�Ȑ��Ö@�t���[��
   */
  public ACGroupBox getMindFrame(){
    if(mindFrame==null){

      mindFrame = new ACGroupBox();

      mindFrame.setText("���_�Ȑ��Ö@");

      mindFrame.setPreferredSize(new Dimension(1,50));

      addMindFrame();
    }
    return mindFrame;

  }

  /**
   * ���_�Ȑ��Ö@�̈���擾���܂��B
   * @return ���_�Ȑ��Ö@�̈�
   */
  public ACPanel getMindFrames(){
    if(mindFrames==null){

      mindFrames = new ACPanel();

      addMindFrames();
    }
    return mindFrames;

  }

  /**
   * ���_�ȍ�ƗÖ@���擾���܂��B
   * @return ���_�ȍ�ƗÖ@
   */
  public ACIntegerCheckBox getMindTherapy(){
    if(mindTherapy==null){

      mindTherapy = new ACIntegerCheckBox();

      mindTherapy.setText("���_�ȍ�ƗÖ@");

      mindTherapy.setBindPath("3010137");

      addMindTherapy();
    }
    return mindTherapy;

  }

  /**
   * �F�m�ǘV�l���@���_�Ö@���擾���܂��B
   * @return �F�m�ǘV�l���@���_�Ö@
   */
  public ACIntegerCheckBox getCognitive(){
    if(cognitive==null){

      cognitive = new ACIntegerCheckBox();

      cognitive.setText("�F�m�ǘV�l���@���_�Ö@");

      cognitive.setBindPath("3010138");

      addCognitive();
    }
    return cognitive;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * �ݒ���擾���܂��B
   * @return �ݒ�
   */
  public ACButton getApply(){
    if(apply==null){

      apply = new ACButton();

      apply.setText("����(C)");

      apply.setMnemonic('C');

      apply.setIconPath(ACConstants.ICON_PATH_OK_16);

      addApply();
    }
    return apply;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001199_H2104Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(800, 600);

      // �E�B���h�E�𒆉��ɔz�u
      Point pos;
      try{
          pos= ACFrame.getInstance().getLocationOnScreen();
      }catch(Exception ex){
          pos = new Point(0,0);
      }
      Dimension screenSize = ACFrame.getInstance().getSize();
      Dimension frameSize = this.getSize();
      if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
      }
      this.setLocation((int)(pos.getX()+(screenSize.width - frameSize.width) / 2),
              (int)(pos.getY()+(screenSize.height - frameSize.height) / 2));

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

    this.getContentPane().add(getSpecificConsultationFeePattern(), VRLayout.CLIENT);

  }

  /**
   * ����f�Ô�ݒ�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificConsultationFeePattern(){

    specificConsultationFeePattern.add(getGuidanceManagement(), VRLayout.NORTH);

    specificConsultationFeePattern.add(getRehabilitation(), VRLayout.NORTH);

    specificConsultationFeePattern.add(getButtons(), VRLayout.NORTH);

  }

  /**
   * �w���Ǘ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addGuidanceManagement(){

    guidanceManagement.add(getGuidanceManagements(), VRLayout.NORTH);

  }

  /**
   * �w���Ǘ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addGuidanceManagements(){

    guidanceManagements.add(getInfectionGuidanceManagement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getBedGuidanceManagement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getBeginningGuidanceManagement(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getHeavyRecuperateGuidanceManagement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getParticularInstitutionManagment(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom2(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getHeavySkinManegement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getMedicineManegementLeading(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getSpecialMedicineManagementLeading(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getMedicalScienceInfo1(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getMedicalScienceInfo2(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �����΍�w���Ǘ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfectionGuidanceManagement(){

  }

  /**
   * ��጑΍�w���Ǘ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBedGuidanceManagement(){

  }

  /**
   * �������@�f�ÊǗ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBeginningGuidanceManagement(){

  }

  /**
   * �d�x�×{�Ǘ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHeavyRecuperateGuidanceManagement(){

  }

  /**
   * ����{�݊Ǘ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInstitutionManagment(){

  }

  /**
   * ����{�݊Ǘ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInstitutionManagmentPrivateRoom(){

  }

  /**
   * ����{�݊Ǘ�2�l�������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInstitutionManagmentPrivateRoom2(){

  }

  /**
   * �d�ǔ畆��ᇊǗ��w���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHeavySkinManegement(){

  }

  /**
   * ��܊Ǘ��w���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicineManegementLeading(){

  }

  /**
   * ���ʖ�܊Ǘ��w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialMedicineManagementLeading(){

  }

  /**
   * ��w����(I)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalScienceInfo1(){

  }

  /**
   * ��w����(II)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalScienceInfo2(){

  }

  /**
   * ���n�r���e�[�V�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitation(){

    rehabilitation.add(getScienceTherapy(), VRLayout.NORTH);

    rehabilitation.add(getWorkTherapyFrame(), VRLayout.NORTH);

    rehabilitation.add(getEtcFrame(), VRLayout.NORTH);

    rehabilitation.add(getMindFrame(), VRLayout.NORTH);

  }

  /**
   * ���w�Ö@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy(){

    scienceTherapy.add(getScienceTherapys(), VRLayout.NORTH);

  }

  /**
   * ���w�Ö@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapys(){

    scienceTherapys.add(getScienceTherapy1Container(), VRLayout.FLOW_INSETLINE);

    scienceTherapys.add(getScienceTherapy2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    scienceTherapys.add(getScience1Container(), VRLayout.FLOW_INSETLINE);

    scienceTherapys.add(getScience2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    scienceTherapys.add(getRehabilitationPlan(), VRLayout.FLOW_INSETLINE);

    scienceTherapys.add(getNormalAction(), VRLayout.FLOW_INSETLINE_RETURN);

    scienceTherapys.add(getRehabilitationSystem1Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���w�Ö@�R���e�i1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy1Container(){

    scienceTherapy1Container.add(getScienceTherapy1(), null);

    scienceTherapy1Container.add(getScienceTherapy1Combo(), null);

  }

  /**
   * ���w�Ö@(I)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy1(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy1Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy1ComboModel(){

  }

  /**
   * ���w�Ö@�R���e�i2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy2Container(){

    scienceTherapy2Container.add(getScienceTherapy2(), null);

    scienceTherapy2Container.add(getScienceTherapy2Combo(), null);

  }

  /**
   * ���w�Ö@(II)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy2(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy2Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy2ComboModel(){

  }

  /**
   * ���w�R���e�i1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience1Container(){

    science1Container.add(getScienceLabel1(), null);

    science1Container.add(getScience1(), null);

    science1Container.add(getScience1Combo(), null);

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceLabel1(){

  }

  /**
   * ���w(I)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience1(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience1Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience1ComboModel(){

  }

  /**
   * ���w�R���e�i2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience2Container(){

    science2Container.add(getScience2(), null);

    science2Container.add(getScience2Combo(), null);

  }

  /**
   * ���w(II)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience2(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience2Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience2ComboModel(){

  }

  /**
   * ���n�r���v����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationPlan(){

  }

  /**
   * ���퓮��P���w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalAction(){

  }

  /**
   * ���n�r���̐��������Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem1Container(){

    rehabilitationSystem1Container.add(getRehabilitationSystem1(), null);

    rehabilitationSystem1Container.add(getRehabilitationSystem1Combo(), null);

  }

  /**
   * ���n�r���̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem1(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem1Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem1ComboModel(){

  }

  /**
   * ��ƗÖ@�t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapyFrame(){

    workTherapyFrame.add(getWorkTherapyFrames(), VRLayout.NORTH);

  }

  /**
   * ��ƗÖ@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapyFrames(){

    workTherapyFrames.add(getWorkTherapy1Conteiner(), VRLayout.FLOW_INSETLINE);

    workTherapyFrames.add(getWork1Conteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    workTherapyFrames.add(getRehabilitationPlan2(), VRLayout.FLOW_INSETLINE);

    workTherapyFrames.add(getNormalActionTraning(), VRLayout.FLOW_INSETLINE_RETURN);

    workTherapyFrames.add(getRehabilitationSystem2Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ��ƗÖ@I�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapy1Conteiner(){

    workTherapy1Conteiner.add(getWorkTherapy1(), null);

    workTherapy1Conteiner.add(getWorkTherapy1Combo(), null);

  }

  /**
   * ��ƗÖ@I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapy1(){

  }

  /**
   * ��ƗÖ@I�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapy1Combo(){

  }

  /**
   * ��ƗÖ@I�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapy1ComboModel(){

  }

  /**
   * ���I�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWork1Conteiner(){

    work1Conteiner.add(getReduce11Over(), null);

    work1Conteiner.add(getWork1(), null);

    work1Conteiner.add(getWork1Combo(), null);

  }

  /**
   * 11��ڈȍ~�̌��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduce11Over(){

  }

  /**
   * ���(I)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWork1(){

  }

  /**
   * ���(I)�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWork1Combo(){

  }

  /**
   * ���(I)�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWork1ComboModel(){

  }

  /**
   * ���n�r���v����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationPlan2(){

  }

  /**
   * ���퓮��P���w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalActionTraning(){

  }

  /**
   * ���n�r���̐��������Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem2Container(){

    rehabilitationSystem2Container.add(getRehabilitationSystem2(), null);

    rehabilitationSystem2Container.add(getRehabilitationSystem2Combo(), null);

  }

  /**
   * ���n�r���̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem2(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem2Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem2ComboModel(){

  }

  /**
   * ���̑��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcFrame(){

    etcFrame.add(getEtcFrames(), VRLayout.NORTH);

  }

  /**
   * ���̑��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcFrames(){

    etcFrames.add(getLanguageTherapy1Conteiner(), VRLayout.FLOW_INSETLINE);

    etcFrames.add(getLanguage1Conteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    etcFrames.add(getRehabilitationSystem3Container(), VRLayout.FLOW_INSETLINE_RETURN);

    etcFrames.add(getDinner(), VRLayout.FLOW_INSETLINE);

    etcFrames.add(getConcentratedRehabilitation(), VRLayout.FLOW_INSETLINE_RETURN);

    etcFrames.add(getGroupCommunication(), VRLayout.FLOW_INSETLINE);

    etcFrames.add(getDementiaShortRehabilitation(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���꒮�o�Ö@I�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy1Conteiner(){

    languageTherapy1Conteiner.add(getLanguageTherapy1(), null);

    languageTherapy1Conteiner.add(getLanguageTherapy1Combo(), null);

  }

  /**
   * ���꒮�o�Ö@I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy1(){

  }

  /**
   * ���꒮�o�Ö@I�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy1Combo(){

  }

  /**
   * ���꒮�o�Ö@I�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy1ComboModel(){

  }

  /**
   * ���꒮�o�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage1Conteiner(){

    language1Conteiner.add(getLanguage1Reduce(), null);

    language1Conteiner.add(getLanguage1(), null);

    language1Conteiner.add(getLanguage1Combo(), null);

  }

  /**
   * 11��ڈȍ~�̌��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage1Reduce(){

  }

  /**
   * ���꒮�o(I)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage1(){

  }

  /**
   * ���꒮�o(I)�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage1Combo(){

  }

  /**
   * ���꒮�o(I)�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage1ComboModel(){

  }

  /**
   * ���n�r���̐��������Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem3Container(){

    rehabilitationSystem3Container.add(getRehabilitationSystem3(), null);

    rehabilitationSystem3Container.add(getRehabilitationSystem3Combo(), null);

  }

  /**
   * ���n�r���̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem3(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem3Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem3ComboModel(){

  }

  /**
   * �ېH�@�\�Ö@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinner(){

  }

  /**
   * �Z���W�����n�r�����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addConcentratedRehabilitation(){

  }

  /**
   * �W�c�R�~���j�P�[�V�����Ö@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addGroupCommunication(){

  }

  /**
   * �F�m�ǒZ���W�����n�r�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaShortRehabilitation(){

  }

  /**
   * ���_�Ȑ��Ö@�t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMindFrame(){

    mindFrame.add(getMindFrames(), VRLayout.NORTH);

  }

  /**
   * ���_�Ȑ��Ö@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMindFrames(){

    mindFrames.add(getMindTherapy(), VRLayout.FLOW_INSETLINE);

    mindFrames.add(getCognitive(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���_�ȍ�ƗÖ@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMindTherapy(){

  }

  /**
   * �F�m�ǘV�l���@���_�Ö@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCognitive(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getApply(), VRLayout.EAST);
  }

  /**
   * �ݒ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addApply(){

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

  public void setVisible(boolean visible){
    if(visible){
      try{
        initAffair(null);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(ex);
      }
    }
    super.setVisible(visible);
  }
  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      new QS001199_H2104Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001199_H2104Design getThis() {
    return this;
  }
}
