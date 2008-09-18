
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
 * �J����: ���}�@�M�u
 * �쐬��: 2006/03/06  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� ����f�Ô��� (QS001028)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * ����f�Ô��ʉ�ʍ��ڃf�U�C��(QS001028) 
 */
public class QS001028Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel specificConsultationFeePattern;

  private ACGroupBox guidanceManagement;

  private ACPanel guidanceManagements;

  private GridBagLayout guidanceManagementLayout;

  private ACIntegerCheckBox infectionGuidanceManagement;

  private ACIntegerCheckBox bedGuidanceManagement;

  private ACIntegerCheckBox beginningGuidanceManagement;

  private ACIntegerCheckBox heavyRecuperateGuidanceManagement;

  private ACIntegerCheckBox particularInstitutionManagment;

  private ACIntegerCheckBox particularInstitutionManagmentPrivateRoom;

  private ACIntegerCheckBox particularInstitutionManagmentPrivateRoom2;

  private ACIntegerCheckBox heavySkinManegement;

  private ACIntegerCheckBox careNutritionDinnerLeading;

  private ACIntegerCheckBox medicineManegementLeading;

  private ACIntegerCheckBox specialMedicineManagementLeading;

  private ACIntegerCheckBox medicalScienceInfo1;

  private ACIntegerCheckBox medicalScienceInfo2;

  private ACGroupBox rehabilitation;

  private ACGroupBox scienceTherapy;

  private ACPanel scienceTherapys;

  private GridBagLayout scienceTherapyLayout;

  private ACLabelContainer scienceTherapy1Container;

  private ACIntegerCheckBox scienceTherapy1;

  private ACComboBox scienceTherapy1Combo;

  private ACComboBoxModelAdapter scienceTherapy1ComboModel;

  private ACLabelContainer scienceTherapy2Container;

  private ACIntegerCheckBox scienceTherapy2;

  private ACComboBox scienceTherapy2Combo;

  private ACComboBoxModelAdapter scienceTherapy2ComboModel;

  private ACLabelContainer scienceTherapy3Container;

  private ACIntegerCheckBox scienceTherapy3;

  private ACComboBox scienceTherapy3Combo;

  private ACComboBoxModelAdapter scienceTherapy3ComboModel;

  private ACLabelContainer scienceTherapy4Container;

  private ACIntegerCheckBox scienceTherapy4;

  private ACComboBox scienceTherapy4Combo;

  private ACComboBoxModelAdapter scienceTherapy4ComboModel;

  private ACLabelContainer science1Container;

  private ACLabel scienceLabel1;

  private ACIntegerCheckBox science1;

  private ACComboBox science1Combo;

  private ACComboBoxModelAdapter science1ComboModel;

  private ACLabelContainer science2Container;

  private ACIntegerCheckBox science2;

  private ACComboBox science2Combo;

  private ACComboBoxModelAdapter science2ComboModel;

  private ACLabelContainer science3Container;

  private ACIntegerCheckBox science3;

  private ACComboBox science3Combo;

  private ACComboBoxModelAdapter science3ComboModel;

  private ACLabelContainer science4Container;

  private ACIntegerCheckBox science4;

  private ACComboBox science4Combo;

  private ACComboBoxModelAdapter science4ComboModel;

  private ACLabelContainer normalLifeConteiner;

  private ACIntegerCheckBox normalLife;

  private ACComboBox normalLifeCombo;

  private ACComboBoxModelAdapter normalLifeComboModel;

  private ACPanel rehabilitationPlans;

  private ACIntegerCheckBox rehabilitationPlan;

  private ACPanel normalActions;

  private ACIntegerCheckBox normalAction;

  private ACGroupBox workTherapyFrame;

  private ACPanel workTherapyFrames;

  private GridBagLayout workTherapyFrameLayout;

  private ACLabelContainer workTherapy1Conteiner;

  private ACIntegerCheckBox workTherapy1;

  private ACComboBox workTherapy1Combo;

  private ACComboBoxModelAdapter workTherapy1ComboModel;

  private ACLabelContainer workTherapy2Conteiner;

  private ACIntegerCheckBox workTherapy2;

  private ACComboBox workTherapy2Combo;

  private ACComboBoxModelAdapter workTherapy2ComboModel;

  private ACLabelContainer work1Conteiner;

  private ACLabel reduce11Over;

  private ACIntegerCheckBox work1;

  private ACComboBox work1Combo;

  private ACComboBoxModelAdapter work1ComboModel;

  private ACLabelContainer work2Conteiner;

  private ACIntegerCheckBox work2;

  private ACComboBox work2Combo;

  private ACComboBoxModelAdapter work2ComboModel;

  private ACLabelContainer normalLife2Container;

  private ACIntegerCheckBox normalLife2;

  private ACComboBox normalLife2Combo;

  private ACComboBoxModelAdapter normalLife2ComboModel;

  private ACPanel rehabilitationPlan2s;

  private ACIntegerCheckBox rehabilitationPlan2;

  private ACPanel normalActionTranings;

  private ACIntegerCheckBox normalActionTraning;

  private ACGroupBox etcFrame;

  private ACPanel etcFrames;

  private GridBagLayout etcFrameLayout;

  private ACLabelContainer languageTherapy1Conteiner;

  private ACIntegerCheckBox languageTherapy1;

  private ACComboBox languageTherapy1Combo;

  private ACComboBoxModelAdapter languageTherapy1ComboModel;

  private ACLabelContainer languageTherapy2Conteiner;

  private ACIntegerCheckBox languageTherapy2;

  private ACComboBox languageTherapy2Combo;

  private ACComboBoxModelAdapter languageTherapy2ComboModel;

  private ACLabelContainer language1Conteiner;

  private ACLabel language1Reduce;

  private ACIntegerCheckBox language1;

  private ACComboBox language1Combo;

  private ACComboBoxModelAdapter language1ComboModel;

  private ACLabelContainer language2Conteiner;

  private ACIntegerCheckBox language2;

  private ACComboBox language2Combo;

  private ACComboBoxModelAdapter language2ComboModel;

  private ACPanel dinners;

  private ACIntegerCheckBox dinner;

  private ACGroupBox mindFrame;

  private ACPanel mindFrames;

  private GridBagLayout mindFrameLayout;

  private ACPanel mindTherapys;

  private ACIntegerCheckBox mindTherapy;

  private ACPanel cognitives;

  private ACIntegerCheckBox cognitive;

  private ACPanel buttons;

  private ACButton apply;

  private ACButton close;

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

      guidanceManagements.setLayout(getGuidanceManagementLayout());

      addGuidanceManagements();
    }
    return guidanceManagements;

  }

  /**
   * �w���Ǘ������C�A�E�g���擾���܂��B
   * @return �w���Ǘ������C�A�E�g
   */
  public GridBagLayout getGuidanceManagementLayout(){
    if(guidanceManagementLayout==null){

      guidanceManagementLayout = new GridBagLayout();

      addGuidanceManagementLayout();
    }
    return guidanceManagementLayout;

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
   * ���h�{�H���w�����擾���܂��B
   * @return ���h�{�H���w��
   */
  public ACIntegerCheckBox getCareNutritionDinnerLeading(){
    if(careNutritionDinnerLeading==null){

      careNutritionDinnerLeading = new ACIntegerCheckBox();

      careNutritionDinnerLeading.setText("���h�{�H���w��");

      careNutritionDinnerLeading.setBindPath("3010109");

      addCareNutritionDinnerLeading();
    }
    return careNutritionDinnerLeading;

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

      scienceTherapys.setLayout(getScienceTherapyLayout());

      addScienceTherapys();
    }
    return scienceTherapys;

  }

  /**
   * ���w�Ö@�̈惌�C�A�E�g���擾���܂��B
   * @return ���w�Ö@�̈惌�C�A�E�g
   */
  public GridBagLayout getScienceTherapyLayout(){
    if(scienceTherapyLayout==null){

      scienceTherapyLayout = new GridBagLayout();

      addScienceTherapyLayout();
    }
    return scienceTherapyLayout;

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

      scienceTherapy1Combo.setBindPath("3010114");

      scienceTherapy1Combo.setEnabled(false);

      scienceTherapy1Combo.setEditable(false);

      scienceTherapy1Combo.setModelBindPath("109");

      scienceTherapy1Combo.setModel(getScienceTherapy1ComboModel());

      scienceTherapy1Combo.setRenderBindPath("CONTENT");

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

      scienceTherapy2Combo.setBindPath("3010115");

      scienceTherapy2Combo.setEnabled(false);

      scienceTherapy2Combo.setEditable(false);

      scienceTherapy2Combo.setModelBindPath("109");

      scienceTherapy2Combo.setModel(getScienceTherapy2ComboModel());

      scienceTherapy2Combo.setRenderBindPath("CONTENT");

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
   * ���w�Ö@�R���e�i3���擾���܂��B
   * @return ���w�Ö@�R���e�i3
   */
  public ACLabelContainer getScienceTherapy3Container(){
    if(scienceTherapy3Container==null){

      scienceTherapy3Container = new ACLabelContainer();

      addScienceTherapy3Container();
    }
    return scienceTherapy3Container;

  }

  /**
   * ���w�Ö@(III)���擾���܂��B
   * @return ���w�Ö@(III)
   */
  public ACIntegerCheckBox getScienceTherapy3(){
    if(scienceTherapy3==null){

      scienceTherapy3 = new ACIntegerCheckBox();

      scienceTherapy3.setText("���w�Ö@(III)");

      addScienceTherapy3();
    }
    return scienceTherapy3;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getScienceTherapy3Combo(){
    if(scienceTherapy3Combo==null){

      scienceTherapy3Combo = new ACComboBox();

      scienceTherapy3Combo.setBindPath("3010116");

      scienceTherapy3Combo.setEnabled(false);

      scienceTherapy3Combo.setEditable(false);

      scienceTherapy3Combo.setModelBindPath("109");

      scienceTherapy3Combo.setModel(getScienceTherapy3ComboModel());

      scienceTherapy3Combo.setRenderBindPath("CONTENT");

      scienceTherapy3Combo.setPreferredSize(new Dimension(50,10));

      addScienceTherapy3Combo();
    }
    return scienceTherapy3Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getScienceTherapy3ComboModel(){
    if(scienceTherapy3ComboModel==null){
      scienceTherapy3ComboModel = new ACComboBoxModelAdapter();
      addScienceTherapy3ComboModel();
    }
    return scienceTherapy3ComboModel;
  }

  /**
   * ���w�Ö@�R���e�i4���擾���܂��B
   * @return ���w�Ö@�R���e�i4
   */
  public ACLabelContainer getScienceTherapy4Container(){
    if(scienceTherapy4Container==null){

      scienceTherapy4Container = new ACLabelContainer();

      addScienceTherapy4Container();
    }
    return scienceTherapy4Container;

  }

  /**
   * ���w�Ö@(I�u)���擾���܂��B
   * @return ���w�Ö@(I�u)
   */
  public ACIntegerCheckBox getScienceTherapy4(){
    if(scienceTherapy4==null){

      scienceTherapy4 = new ACIntegerCheckBox();

      scienceTherapy4.setText("���w�Ö@(I�u)");

      addScienceTherapy4();
    }
    return scienceTherapy4;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getScienceTherapy4Combo(){
    if(scienceTherapy4Combo==null){

      scienceTherapy4Combo = new ACComboBox();

      scienceTherapy4Combo.setBindPath("3010117");

      scienceTherapy4Combo.setEnabled(false);

      scienceTherapy4Combo.setEditable(false);

      scienceTherapy4Combo.setModelBindPath("109");

      scienceTherapy4Combo.setModel(getScienceTherapy4ComboModel());

      scienceTherapy4Combo.setRenderBindPath("CONTENT");

      scienceTherapy4Combo.setPreferredSize(new Dimension(50,10));

      addScienceTherapy4Combo();
    }
    return scienceTherapy4Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getScienceTherapy4ComboModel(){
    if(scienceTherapy4ComboModel==null){
      scienceTherapy4ComboModel = new ACComboBoxModelAdapter();
      addScienceTherapy4ComboModel();
    }
    return scienceTherapy4ComboModel;
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

      science1Combo.setBindPath("3010118");

      science1Combo.setEnabled(false);

      science1Combo.setEditable(false);

      science1Combo.setModelBindPath("109");

      science1Combo.setModel(getScience1ComboModel());

      science1Combo.setRenderBindPath("CONTENT");

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

      science2Combo.setBindPath("3010119");

      science2Combo.setEnabled(false);

      science2Combo.setEditable(false);

      science2Combo.setModelBindPath("109");

      science2Combo.setModel(getScience2ComboModel());

      science2Combo.setRenderBindPath("CONTENT");

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
   * ���w�R���e�i3���擾���܂��B
   * @return ���w�R���e�i3
   */
  public ACLabelContainer getScience3Container(){
    if(science3Container==null){

      science3Container = new ACLabelContainer();

      addScience3Container();
    }
    return science3Container;

  }

  /**
   * ���w(III)���擾���܂��B
   * @return ���w(III)
   */
  public ACIntegerCheckBox getScience3(){
    if(science3==null){

      science3 = new ACIntegerCheckBox();

      science3.setText("���w(III)");

      addScience3();
    }
    return science3;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getScience3Combo(){
    if(science3Combo==null){

      science3Combo = new ACComboBox();

      science3Combo.setBindPath("3010120");

      science3Combo.setEnabled(false);

      science3Combo.setEditable(false);

      science3Combo.setModelBindPath("109");

      science3Combo.setModel(getScience3ComboModel());

      science3Combo.setRenderBindPath("CONTENT");

      science3Combo.setPreferredSize(new Dimension(50,10));

      addScience3Combo();
    }
    return science3Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getScience3ComboModel(){
    if(science3ComboModel==null){
      science3ComboModel = new ACComboBoxModelAdapter();
      addScience3ComboModel();
    }
    return science3ComboModel;
  }

  /**
   * ���w�R���e�i4���擾���܂��B
   * @return ���w�R���e�i4
   */
  public ACLabelContainer getScience4Container(){
    if(science4Container==null){

      science4Container = new ACLabelContainer();

      addScience4Container();
    }
    return science4Container;

  }

  /**
   * ���w(I�u)���擾���܂��B
   * @return ���w(I�u)
   */
  public ACIntegerCheckBox getScience4(){
    if(science4==null){

      science4 = new ACIntegerCheckBox();

      science4.setText("���w(I�u)");

      addScience4();
    }
    return science4;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getScience4Combo(){
    if(science4Combo==null){

      science4Combo = new ACComboBox();

      science4Combo.setBindPath("3010121");

      science4Combo.setEnabled(false);

      science4Combo.setEditable(false);

      science4Combo.setModelBindPath("109");

      science4Combo.setModel(getScience4ComboModel());

      science4Combo.setRenderBindPath("CONTENT");

      science4Combo.setPreferredSize(new Dimension(50,10));

      addScience4Combo();
    }
    return science4Combo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getScience4ComboModel(){
    if(science4ComboModel==null){
      science4ComboModel = new ACComboBoxModelAdapter();
      addScience4ComboModel();
    }
    return science4ComboModel;
  }

  /**
   * ���퐶���P�����Z�R���e�i���擾���܂��B
   * @return ���퐶���P�����Z�R���e�i
   */
  public ACLabelContainer getNormalLifeConteiner(){
    if(normalLifeConteiner==null){

      normalLifeConteiner = new ACLabelContainer();

      addNormalLifeConteiner();
    }
    return normalLifeConteiner;

  }

  /**
   * ���퐶�������P�����Z���擾���܂��B
   * @return ���퐶�������P�����Z
   */
  public ACIntegerCheckBox getNormalLife(){
    if(normalLife==null){

      normalLife = new ACIntegerCheckBox();

      normalLife.setText("���퐶�������P�����Z");

      addNormalLife();
    }
    return normalLife;

  }

  /**
   * �R���{���擾���܂��B
   * @return �R���{
   */
  public ACComboBox getNormalLifeCombo(){
    if(normalLifeCombo==null){

      normalLifeCombo = new ACComboBox();

      normalLifeCombo.setBindPath("3010122");

      normalLifeCombo.setEnabled(false);

      normalLifeCombo.setEditable(false);

      normalLifeCombo.setModelBindPath("109");

      normalLifeCombo.setModel(getNormalLifeComboModel());

      normalLifeCombo.setRenderBindPath("CONTENT");

      normalLifeCombo.setPreferredSize(new Dimension(50,10));

      addNormalLifeCombo();
    }
    return normalLifeCombo;

  }

  /**
   * �R���{���f�����擾���܂��B
   * @return �R���{���f��
   */
  protected ACComboBoxModelAdapter getNormalLifeComboModel(){
    if(normalLifeComboModel==null){
      normalLifeComboModel = new ACComboBoxModelAdapter();
      addNormalLifeComboModel();
    }
    return normalLifeComboModel;
  }

  /**
   * ���n�r���v����Z�̈���擾���܂��B
   * @return ���n�r���v����Z�̈�
   */
  public ACPanel getRehabilitationPlans(){
    if(rehabilitationPlans==null){

      rehabilitationPlans = new ACPanel();

      rehabilitationPlans.setHgap(14);

      addRehabilitationPlans();
    }
    return rehabilitationPlans;

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
   * ���퓮��P���w�����Z�̈���擾���܂��B
   * @return ���퓮��P���w�����Z�̈�
   */
  public ACPanel getNormalActions(){
    if(normalActions==null){

      normalActions = new ACPanel();

      normalActions.setHgap(14);

      addNormalActions();
    }
    return normalActions;

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
   * ��ƗÖ@�t���[�����擾���܂��B
   * @return ��ƗÖ@�t���[��
   */
  public ACGroupBox getWorkTherapyFrame(){
    if(workTherapyFrame==null){

      workTherapyFrame = new ACGroupBox();

      workTherapyFrame.setText("��ƗÖ@");

      workTherapyFrame.setAutoWrap(false);

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

      workTherapyFrames.setLayout(getWorkTherapyFrameLayout());

      workTherapyFrames.setAutoWrap(false);

      addWorkTherapyFrames();
    }
    return workTherapyFrames;

  }

  /**
   * ��ƗÖ@�t���[���E���C�A�E�g���擾���܂��B
   * @return ��ƗÖ@�t���[���E���C�A�E�g
   */
  public GridBagLayout getWorkTherapyFrameLayout(){
    if(workTherapyFrameLayout==null){

      workTherapyFrameLayout = new GridBagLayout();

      addWorkTherapyFrameLayout();
    }
    return workTherapyFrameLayout;

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

      workTherapy1.setText("��ƗÖ@(I)");

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

      workTherapy1Combo.setBindPath("3010125");

      workTherapy1Combo.setEnabled(false);

      workTherapy1Combo.setEditable(false);

      workTherapy1Combo.setModelBindPath("109");

      workTherapy1Combo.setModel(getWorkTherapy1ComboModel());

      workTherapy1Combo.setRenderBindPath("CONTENT");

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
   * ��ƗÖ@II�R���e�i���擾���܂��B
   * @return ��ƗÖ@II�R���e�i
   */
  public ACLabelContainer getWorkTherapy2Conteiner(){
    if(workTherapy2Conteiner==null){

      workTherapy2Conteiner = new ACLabelContainer();

      addWorkTherapy2Conteiner();
    }
    return workTherapy2Conteiner;

  }

  /**
   * ��ƗÖ@II���擾���܂��B
   * @return ��ƗÖ@II
   */
  public ACIntegerCheckBox getWorkTherapy2(){
    if(workTherapy2==null){

      workTherapy2 = new ACIntegerCheckBox();

      workTherapy2.setText("��ƗÖ@(II)");

      addWorkTherapy2();
    }
    return workTherapy2;

  }

  /**
   * ��ƗÖ@II�E�R���{���擾���܂��B
   * @return ��ƗÖ@II�E�R���{
   */
  public ACComboBox getWorkTherapy2Combo(){
    if(workTherapy2Combo==null){

      workTherapy2Combo = new ACComboBox();

      workTherapy2Combo.setBindPath("3010126");

      workTherapy2Combo.setEnabled(false);

      workTherapy2Combo.setEditable(false);

      workTherapy2Combo.setModelBindPath("109");

      workTherapy2Combo.setModel(getWorkTherapy2ComboModel());

      workTherapy2Combo.setRenderBindPath("CONTENT");

      workTherapy2Combo.setPreferredSize(new Dimension(50,10));

      addWorkTherapy2Combo();
    }
    return workTherapy2Combo;

  }

  /**
   * ��ƗÖ@II�E�R���{���f�����擾���܂��B
   * @return ��ƗÖ@II�E�R���{���f��
   */
  protected ACComboBoxModelAdapter getWorkTherapy2ComboModel(){
    if(workTherapy2ComboModel==null){
      workTherapy2ComboModel = new ACComboBoxModelAdapter();
      addWorkTherapy2ComboModel();
    }
    return workTherapy2ComboModel;
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

      work1.setText("���(I)");

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

      work1Combo.setBindPath("3010127");

      work1Combo.setEnabled(false);

      work1Combo.setEditable(false);

      work1Combo.setModelBindPath("109");

      work1Combo.setModel(getWork1ComboModel());

      work1Combo.setRenderBindPath("CONTENT");

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
   * ���II�R���e�i���擾���܂��B
   * @return ���II�R���e�i
   */
  public ACLabelContainer getWork2Conteiner(){
    if(work2Conteiner==null){

      work2Conteiner = new ACLabelContainer();

      addWork2Conteiner();
    }
    return work2Conteiner;

  }

  /**
   * ���(II)���擾���܂��B
   * @return ���(II)
   */
  public ACIntegerCheckBox getWork2(){
    if(work2==null){

      work2 = new ACIntegerCheckBox();

      work2.setText("���(II)");

      addWork2();
    }
    return work2;

  }

  /**
   * ���(II)�R���{���擾���܂��B
   * @return ���(II)�R���{
   */
  public ACComboBox getWork2Combo(){
    if(work2Combo==null){

      work2Combo = new ACComboBox();

      work2Combo.setBindPath("3010128");

      work2Combo.setEnabled(false);

      work2Combo.setEditable(false);

      work2Combo.setModelBindPath("109");

      work2Combo.setModel(getWork2ComboModel());

      work2Combo.setRenderBindPath("CONTENT");

      work2Combo.setPreferredSize(new Dimension(50,10));

      addWork2Combo();
    }
    return work2Combo;

  }

  /**
   * ���(II)�R���{���f�����擾���܂��B
   * @return ���(II)�R���{���f��
   */
  protected ACComboBoxModelAdapter getWork2ComboModel(){
    if(work2ComboModel==null){
      work2ComboModel = new ACComboBoxModelAdapter();
      addWork2ComboModel();
    }
    return work2ComboModel;
  }

  /**
   * ���퐶�����������Z�R���e�i���擾���܂��B
   * @return ���퐶�����������Z�R���e�i
   */
  public ACLabelContainer getNormalLife2Container(){
    if(normalLife2Container==null){

      normalLife2Container = new ACLabelContainer();

      addNormalLife2Container();
    }
    return normalLife2Container;

  }

  /**
   * ���퐶�����������Z���擾���܂��B
   * @return ���퐶�����������Z
   */
  public ACIntegerCheckBox getNormalLife2(){
    if(normalLife2==null){

      normalLife2 = new ACIntegerCheckBox();

      normalLife2.setText("���퐶�������P�����Z");

      addNormalLife2();
    }
    return normalLife2;

  }

  /**
   * ���퐶�����������Z�R���{���擾���܂��B
   * @return ���퐶�����������Z�R���{
   */
  public ACComboBox getNormalLife2Combo(){
    if(normalLife2Combo==null){

      normalLife2Combo = new ACComboBox();

      normalLife2Combo.setBindPath("3010129");

      normalLife2Combo.setEnabled(false);

      normalLife2Combo.setEditable(false);

      normalLife2Combo.setModelBindPath("109");

      normalLife2Combo.setModel(getNormalLife2ComboModel());

      normalLife2Combo.setRenderBindPath("CONTENT");

      normalLife2Combo.setPreferredSize(new Dimension(50,10));

      addNormalLife2Combo();
    }
    return normalLife2Combo;

  }

  /**
   * ���퐶�����������Z�R���{���f�����擾���܂��B
   * @return ���퐶�����������Z�R���{���f��
   */
  protected ACComboBoxModelAdapter getNormalLife2ComboModel(){
    if(normalLife2ComboModel==null){
      normalLife2ComboModel = new ACComboBoxModelAdapter();
      addNormalLife2ComboModel();
    }
    return normalLife2ComboModel;
  }

  /**
   * ���n�r���v����Z�̈���擾���܂��B
   * @return ���n�r���v����Z�̈�
   */
  public ACPanel getRehabilitationPlan2s(){
    if(rehabilitationPlan2s==null){

      rehabilitationPlan2s = new ACPanel();

      rehabilitationPlan2s.setHgap(14);

      addRehabilitationPlan2s();
    }
    return rehabilitationPlan2s;

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
   * ���퓮��P���w�����Z�̈���擾���܂��B
   * @return ���퓮��P���w�����Z�̈�
   */
  public ACPanel getNormalActionTranings(){
    if(normalActionTranings==null){

      normalActionTranings = new ACPanel();

      addNormalActionTranings();
    }
    return normalActionTranings;

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
   * ���̑��̈���擾���܂��B
   * @return ���̑��̈�
   */
  public ACGroupBox getEtcFrame(){
    if(etcFrame==null){

      etcFrame = new ACGroupBox();

      etcFrame.setText("���̑�");

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

      etcFrames.setLayout(getEtcFrameLayout());

      addEtcFrames();
    }
    return etcFrames;

  }

  /**
   * ���̑��̈惌�C�A�E�g���擾���܂��B
   * @return ���̑��̈惌�C�A�E�g
   */
  public GridBagLayout getEtcFrameLayout(){
    if(etcFrameLayout==null){

      etcFrameLayout = new GridBagLayout();

      addEtcFrameLayout();
    }
    return etcFrameLayout;

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

      languageTherapy1.setText("���꒮�o�Ö@(I)");

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

      languageTherapy1Combo.setBindPath("3010132");

      languageTherapy1Combo.setEnabled(false);

      languageTherapy1Combo.setEditable(false);

      languageTherapy1Combo.setModelBindPath("109");

      languageTherapy1Combo.setModel(getLanguageTherapy1ComboModel());

      languageTherapy1Combo.setRenderBindPath("CONTENT");

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
   * ���꒮�o�Ö@II�R���e�i���擾���܂��B
   * @return ���꒮�o�Ö@II�R���e�i
   */
  public ACLabelContainer getLanguageTherapy2Conteiner(){
    if(languageTherapy2Conteiner==null){

      languageTherapy2Conteiner = new ACLabelContainer();

      addLanguageTherapy2Conteiner();
    }
    return languageTherapy2Conteiner;

  }

  /**
   * ���꒮�o�Ö@II���擾���܂��B
   * @return ���꒮�o�Ö@II
   */
  public ACIntegerCheckBox getLanguageTherapy2(){
    if(languageTherapy2==null){

      languageTherapy2 = new ACIntegerCheckBox();

      languageTherapy2.setText("���꒮�o�Ö@(II)");

      addLanguageTherapy2();
    }
    return languageTherapy2;

  }

  /**
   * ���꒮�o�Ö@II�R���{���擾���܂��B
   * @return ���꒮�o�Ö@II�R���{
   */
  public ACComboBox getLanguageTherapy2Combo(){
    if(languageTherapy2Combo==null){

      languageTherapy2Combo = new ACComboBox();

      languageTherapy2Combo.setBindPath("3010133");

      languageTherapy2Combo.setEnabled(false);

      languageTherapy2Combo.setEditable(false);

      languageTherapy2Combo.setModelBindPath("109");

      languageTherapy2Combo.setModel(getLanguageTherapy2ComboModel());

      languageTherapy2Combo.setRenderBindPath("CONTENT");

      languageTherapy2Combo.setPreferredSize(new Dimension(50,10));

      addLanguageTherapy2Combo();
    }
    return languageTherapy2Combo;

  }

  /**
   * ���꒮�o�Ö@II�R���{���f�����擾���܂��B
   * @return ���꒮�o�Ö@II�R���{���f��
   */
  protected ACComboBoxModelAdapter getLanguageTherapy2ComboModel(){
    if(languageTherapy2ComboModel==null){
      languageTherapy2ComboModel = new ACComboBoxModelAdapter();
      addLanguageTherapy2ComboModel();
    }
    return languageTherapy2ComboModel;
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

      language1.setText("���꒮�o(I)");

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

      language1Combo.setBindPath("3010134");

      language1Combo.setEnabled(false);

      language1Combo.setEditable(false);

      language1Combo.setModelBindPath("109");

      language1Combo.setModel(getLanguage1ComboModel());

      language1Combo.setRenderBindPath("CONTENT");

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
   * ���꒮�o2�R���e�i���擾���܂��B
   * @return ���꒮�o2�R���e�i
   */
  public ACLabelContainer getLanguage2Conteiner(){
    if(language2Conteiner==null){

      language2Conteiner = new ACLabelContainer();

      addLanguage2Conteiner();
    }
    return language2Conteiner;

  }

  /**
   * ���꒮�o(II)���擾���܂��B
   * @return ���꒮�o(II)
   */
  public ACIntegerCheckBox getLanguage2(){
    if(language2==null){

      language2 = new ACIntegerCheckBox();

      language2.setText("���꒮�o(II)");

      addLanguage2();
    }
    return language2;

  }

  /**
   * ���꒮�o(II)�R���{���擾���܂��B
   * @return ���꒮�o(II)�R���{
   */
  public ACComboBox getLanguage2Combo(){
    if(language2Combo==null){

      language2Combo = new ACComboBox();

      language2Combo.setBindPath("3010135");

      language2Combo.setEnabled(false);

      language2Combo.setEditable(false);

      language2Combo.setModelBindPath("109");

      language2Combo.setModel(getLanguage2ComboModel());

      language2Combo.setRenderBindPath("CONTENT");

      language2Combo.setPreferredSize(new Dimension(50,10));

      addLanguage2Combo();
    }
    return language2Combo;

  }

  /**
   * ���꒮�o(II)�R���{���f�����擾���܂��B
   * @return ���꒮�o(II)�R���{���f��
   */
  protected ACComboBoxModelAdapter getLanguage2ComboModel(){
    if(language2ComboModel==null){
      language2ComboModel = new ACComboBoxModelAdapter();
      addLanguage2ComboModel();
    }
    return language2ComboModel;
  }

  /**
   * �ېH�@�\�Ö@�̈���擾���܂��B
   * @return �ېH�@�\�Ö@�̈�
   */
  public ACPanel getDinners(){
    if(dinners==null){

      dinners = new ACPanel();

      dinners.setHgap(14);

      addDinners();
    }
    return dinners;

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
   * ���_�Ȑ��Ö@�t���[�����擾���܂��B
   * @return ���_�Ȑ��Ö@�t���[��
   */
  public ACGroupBox getMindFrame(){
    if(mindFrame==null){

      mindFrame = new ACGroupBox();

      mindFrame.setText("���_�Ȑ��Ö@");

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

      mindFrames.setLayout(getMindFrameLayout());

      addMindFrames();
    }
    return mindFrames;

  }

  /**
   * ���_�Ȑ��Ö@���C�A�E�g���擾���܂��B
   * @return ���_�Ȑ��Ö@���C�A�E�g
   */
  public GridBagLayout getMindFrameLayout(){
    if(mindFrameLayout==null){

      mindFrameLayout = new GridBagLayout();

      addMindFrameLayout();
    }
    return mindFrameLayout;

  }

  /**
   * ���_�ȍ�ƗÖ@�̈���擾���܂��B
   * @return ���_�ȍ�ƗÖ@�̈�
   */
  public ACPanel getMindTherapys(){
    if(mindTherapys==null){

      mindTherapys = new ACPanel();

      addMindTherapys();
    }
    return mindTherapys;

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
   * �F�m�ǘV�l���@���_�Ö@�̈���擾���܂��B
   * @return �F�m�ǘV�l���@���_�Ö@�̈�
   */
  public ACPanel getCognitives(){
    if(cognitives==null){

      cognitives = new ACPanel();

      addCognitives();
    }
    return cognitives;

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

      apply.setText("�ݒ�(O)");

      apply.setMnemonic('O');

      apply.setIconPath(ACConstants.ICON_PATH_OK_16);

      addApply();
    }
    return apply;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("����(C)");

      close.setMnemonic('C');

      close.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addClose();
    }
    return close;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001028Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(800, 500);

      // �E�B���h�E�𒆉��ɔz�u
      Point pos = ACFrame.getInstance().getLocationOnScreen();
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

    guidanceManagement.add(getGuidanceManagements(), VRLayout.FLOW);

  }

  /**
   * �w���Ǘ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addGuidanceManagements(){

    guidanceManagements.add(getInfectionGuidanceManagement(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getBedGuidanceManagement(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getBeginningGuidanceManagement(), new GridBagConstraints(2, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getHeavyRecuperateGuidanceManagement(), new GridBagConstraints(3, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getParticularInstitutionManagment(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom2(), new GridBagConstraints(2, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getHeavySkinManegement(), new GridBagConstraints(0, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getCareNutritionDinnerLeading(), new GridBagConstraints(1, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getMedicineManegementLeading(), new GridBagConstraints(2, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getSpecialMedicineManagementLeading(), new GridBagConstraints(3, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getMedicalScienceInfo1(), new GridBagConstraints(0, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

    guidanceManagements.add(getMedicalScienceInfo2(), new GridBagConstraints(1, 3, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

  }

  /**
   * �w���Ǘ������C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addGuidanceManagementLayout(){

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
   * ���h�{�H���w���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareNutritionDinnerLeading(){

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

    scienceTherapy.add(getScienceTherapys(), VRLayout.FLOW);

  }

  /**
   * ���w�Ö@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapys(){

    scienceTherapys.add(getScienceTherapy1Container(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScienceTherapy2Container(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScienceTherapy3Container(), new GridBagConstraints(2, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScienceTherapy4Container(), new GridBagConstraints(3, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScience1Container(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScience2Container(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScience3Container(), new GridBagConstraints(2, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getScience4Container(), new GridBagConstraints(3, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getNormalLifeConteiner(), new GridBagConstraints(0, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    scienceTherapys.add(getRehabilitationPlans(), new GridBagConstraints(1, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0));

    scienceTherapys.add(getNormalActions(), new GridBagConstraints(2, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0));

  }

  /**
   * ���w�Ö@�̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapyLayout(){

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
   * ���w�Ö@�R���e�i3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy3Container(){

    scienceTherapy3Container.add(getScienceTherapy3(), null);

    scienceTherapy3Container.add(getScienceTherapy3Combo(), null);

  }

  /**
   * ���w�Ö@(III)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy3(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy3Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy3ComboModel(){

  }

  /**
   * ���w�Ö@�R���e�i4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy4Container(){

    scienceTherapy4Container.add(getScienceTherapy4(), null);

    scienceTherapy4Container.add(getScienceTherapy4Combo(), null);

  }

  /**
   * ���w�Ö@(I�u)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy4(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy4Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addScienceTherapy4ComboModel(){

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
   * ���w�R���e�i3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience3Container(){

    science3Container.add(getScience3(), null);

    science3Container.add(getScience3Combo(), null);

  }

  /**
   * ���w(III)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience3(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience3Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience3ComboModel(){

  }

  /**
   * ���w�R���e�i4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience4Container(){

    science4Container.add(getScience4(), null);

    science4Container.add(getScience4Combo(), null);

  }

  /**
   * ���w(I�u)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience4(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience4Combo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addScience4ComboModel(){

  }

  /**
   * ���퐶���P�����Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalLifeConteiner(){

    normalLifeConteiner.add(getNormalLife(), null);

    normalLifeConteiner.add(getNormalLifeCombo(), null);

  }

  /**
   * ���퐶�������P�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalLife(){

  }

  /**
   * �R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalLifeCombo(){

  }

  /**
   * �R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalLifeComboModel(){

  }

  /**
   * ���n�r���v����Z�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationPlans(){

    rehabilitationPlans.add(getRehabilitationPlan(), VRLayout.FLOW);

  }

  /**
   * ���n�r���v����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationPlan(){

  }

  /**
   * ���퓮��P���w�����Z�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalActions(){

    normalActions.add(getNormalAction(), VRLayout.FLOW);

  }

  /**
   * ���퓮��P���w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalAction(){

  }

  /**
   * ��ƗÖ@�t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapyFrame(){

    workTherapyFrame.add(getWorkTherapyFrames(), VRLayout.FLOW);

  }

  /**
   * ��ƗÖ@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapyFrames(){

    workTherapyFrames.add(getWorkTherapy1Conteiner(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getWorkTherapy2Conteiner(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getWork1Conteiner(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getWork2Conteiner(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getNormalLife2Container(), new GridBagConstraints(0, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getRehabilitationPlan2s(), new GridBagConstraints(1, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    workTherapyFrames.add(getNormalActionTranings(), new GridBagConstraints(2, 2, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

  }

  /**
   * ��ƗÖ@�t���[���E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapyFrameLayout(){

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
   * ��ƗÖ@II�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapy2Conteiner(){

    workTherapy2Conteiner.add(getWorkTherapy2(), null);

    workTherapy2Conteiner.add(getWorkTherapy2Combo(), null);

  }

  /**
   * ��ƗÖ@II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapy2(){

  }

  /**
   * ��ƗÖ@II�E�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapy2Combo(){

  }

  /**
   * ��ƗÖ@II�E�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWorkTherapy2ComboModel(){

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
   * ���II�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWork2Conteiner(){

    work2Conteiner.add(getWork2(), null);

    work2Conteiner.add(getWork2Combo(), null);

  }

  /**
   * ���(II)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWork2(){

  }

  /**
   * ���(II)�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addWork2Combo(){

  }

  /**
   * ���(II)�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addWork2ComboModel(){

  }

  /**
   * ���퐶�����������Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalLife2Container(){

    normalLife2Container.add(getNormalLife2(), null);

    normalLife2Container.add(getNormalLife2Combo(), null);

  }

  /**
   * ���퐶�����������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalLife2(){

  }

  /**
   * ���퐶�����������Z�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalLife2Combo(){

  }

  /**
   * ���퐶�����������Z�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalLife2ComboModel(){

  }

  /**
   * ���n�r���v����Z�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationPlan2s(){

    rehabilitationPlan2s.add(getRehabilitationPlan2(), VRLayout.FLOW);

  }

  /**
   * ���n�r���v����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationPlan2(){

  }

  /**
   * ���퓮��P���w�����Z�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalActionTranings(){

    normalActionTranings.add(getNormalActionTraning(), VRLayout.FLOW);

  }

  /**
   * ���퓮��P���w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNormalActionTraning(){

  }

  /**
   * ���̑��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcFrame(){

    etcFrame.add(getEtcFrames(), VRLayout.FLOW);

  }

  /**
   * ���̑��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcFrames(){

    etcFrames.add(getLanguageTherapy1Conteiner(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    etcFrames.add(getLanguageTherapy2Conteiner(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    etcFrames.add(getLanguage1Conteiner(), new GridBagConstraints(0, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    etcFrames.add(getLanguage2Conteiner(), new GridBagConstraints(1, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    etcFrames.add(getDinners(), new GridBagConstraints(2, 1, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

  }

  /**
   * ���̑��̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcFrameLayout(){

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
   * ���꒮�o�Ö@II�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy2Conteiner(){

    languageTherapy2Conteiner.add(getLanguageTherapy2(), null);

    languageTherapy2Conteiner.add(getLanguageTherapy2Combo(), null);

  }

  /**
   * ���꒮�o�Ö@II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy2(){

  }

  /**
   * ���꒮�o�Ö@II�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy2Combo(){

  }

  /**
   * ���꒮�o�Ö@II�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy2ComboModel(){

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
   * ���꒮�o2�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage2Conteiner(){

    language2Conteiner.add(getLanguage2(), null);

    language2Conteiner.add(getLanguage2Combo(), null);

  }

  /**
   * ���꒮�o(II)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage2(){

  }

  /**
   * ���꒮�o(II)�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage2Combo(){

  }

  /**
   * ���꒮�o(II)�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage2ComboModel(){

  }

  /**
   * �ېH�@�\�Ö@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinners(){

    dinners.add(getDinner(), null);

  }

  /**
   * �ېH�@�\�Ö@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDinner(){

  }

  /**
   * ���_�Ȑ��Ö@�t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMindFrame(){

    mindFrame.add(getMindFrames(), VRLayout.FLOW);

  }

  /**
   * ���_�Ȑ��Ö@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMindFrames(){

    mindFrames.add(getMindTherapys(), new GridBagConstraints(0, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    mindFrames.add(getCognitives(), new GridBagConstraints(1, 0, 1, 1, 100.0, 100.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

  }

  /**
   * ���_�Ȑ��Ö@���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMindFrameLayout(){

  }

  /**
   * ���_�ȍ�ƗÖ@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMindTherapys(){

    mindTherapys.add(getMindTherapy(), VRLayout.FLOW);

  }

  /**
   * ���_�ȍ�ƗÖ@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMindTherapy(){

  }

  /**
   * �F�m�ǘV�l���@���_�Ö@�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCognitives(){

    cognitives.add(getCognitive(), VRLayout.FLOW);

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

    buttons.add(getClose(), VRLayout.EAST);
    buttons.add(getApply(), VRLayout.EAST);
  }

  /**
   * �ݒ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addApply(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addClose(){

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
      new QS001028Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001028Design getThis() {
    return this;
  }
}
