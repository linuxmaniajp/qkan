
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
 * �쐬��: 2008/05/01  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� ���ʗ×{���� (QS001200)
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
 * ���ʗ×{���ʉ�ʍ��ڃf�U�C��(QS001200) 
 */
public class QS001200Design extends QkanAffairDialog {
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

  private ACIntegerCheckBox medicalScienceInfo;

  private ACIntegerCheckBox rehabilitationManegement;

  private ACGroupBox rehabilitation;

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

  private ACIntegerCheckBox rehabilitationSystem;

  private ACIntegerCheckBox dinner;

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

      guidanceManagement.setPreferredSize(new Dimension(1,130));

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
   * ��ጊǗ����擾���܂��B
   * @return ��ጊǗ�
   */
  public ACIntegerCheckBox getBedGuidanceManagement(){
    if(bedGuidanceManagement==null){

      bedGuidanceManagement = new ACIntegerCheckBox();

      bedGuidanceManagement.setText("��ጊǗ�");

      bedGuidanceManagement.setBindPath("3010102");

      addBedGuidanceManagement();
    }
    return bedGuidanceManagement;

  }

  /**
   * ���������f�ÊǗ����擾���܂��B
   * @return ���������f�ÊǗ�
   */
  public ACIntegerCheckBox getBeginningGuidanceManagement(){
    if(beginningGuidanceManagement==null){

      beginningGuidanceManagement = new ACIntegerCheckBox();

      beginningGuidanceManagement.setText("���������f�ÊǗ�");

      beginningGuidanceManagement.setBindPath("3010144");

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
   * ��w���񋟂��擾���܂��B
   * @return ��w����
   */
  public ACIntegerCheckBox getMedicalScienceInfo(){
    if(medicalScienceInfo==null){

      medicalScienceInfo = new ACIntegerCheckBox();

      medicalScienceInfo.setText("��w����");

      medicalScienceInfo.setBindPath("3010145");

      addMedicalScienceInfo();
    }
    return medicalScienceInfo;

  }

  /**
   * ���n�r���e�[�V�����w���Ǘ����擾���܂��B
   * @return ���n�r���e�[�V�����w���Ǘ�
   */
  public ACIntegerCheckBox getRehabilitationManegement(){
    if(rehabilitationManegement==null){

      rehabilitationManegement = new ACIntegerCheckBox();

      rehabilitationManegement.setText("���n�r���e�[�V�����w���Ǘ�");

      rehabilitationManegement.setBindPath("3010146");

      addRehabilitationManegement();
    }
    return rehabilitationManegement;

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
   * ���̑��̈���擾���܂��B
   * @return ���̑��̈�
   */
  public ACGroupBox getEtcFrame(){
    if(etcFrame==null){

      etcFrame = new ACGroupBox();

      etcFrame.setText("���̑�");

      etcFrame.setPreferredSize(new Dimension(1,80));

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
   * ���꒮�o�Ö@�R���e�i���擾���܂��B
   * @return ���꒮�o�Ö@�R���e�i
   */
  public ACLabelContainer getLanguageTherapy1Conteiner(){
    if(languageTherapy1Conteiner==null){

      languageTherapy1Conteiner = new ACLabelContainer();

      addLanguageTherapy1Conteiner();
    }
    return languageTherapy1Conteiner;

  }

  /**
   * ���꒮�o�Ö@���擾���܂��B
   * @return ���꒮�o�Ö@
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
   * ���꒮�o�Ö@�R���{���擾���܂��B
   * @return ���꒮�o�Ö@�R���{
   */
  public ACComboBox getLanguageTherapy1Combo(){
    if(languageTherapy1Combo==null){

      languageTherapy1Combo = new ACComboBox();

      languageTherapy1Combo.setBindPath("3010147");

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
   * ���꒮�o�Ö@�R���{���f�����擾���܂��B
   * @return ���꒮�o�Ö@�R���{���f��
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
   * ���꒮�o���擾���܂��B
   * @return ���꒮�o
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
   * ���꒮�o�R���{���擾���܂��B
   * @return ���꒮�o�R���{
   */
  public ACComboBox getLanguage1Combo(){
    if(language1Combo==null){

      language1Combo = new ACComboBox();

      language1Combo.setBindPath("3010148");

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
   * ���꒮�o�R���{���f�����擾���܂��B
   * @return ���꒮�o�R���{���f��
   */
  protected ACComboBoxModelAdapter getLanguage1ComboModel(){
    if(language1ComboModel==null){
      language1ComboModel = new ACComboBoxModelAdapter();
      addLanguage1ComboModel();
    }
    return language1ComboModel;
  }

  /**
   * ���n�r���̐��������Z���擾���܂��B
   * @return ���n�r���̐��������Z
   */
  public ACIntegerCheckBox getRehabilitationSystem(){
    if(rehabilitationSystem==null){

      rehabilitationSystem = new ACIntegerCheckBox();

      rehabilitationSystem.setText("���n�r���̐��������Z");

      rehabilitationSystem.setBindPath("3010141");

      addRehabilitationSystem();
    }
    return rehabilitationSystem;

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
   * �F�m�ǘV�l�������_�Ö@���擾���܂��B
   * @return �F�m�ǘV�l�������_�Ö@
   */
  public ACIntegerCheckBox getCognitive(){
    if(cognitive==null){

      cognitive = new ACIntegerCheckBox();

      cognitive.setText("�F�m�ǘV�l�������_�Ö@");

      cognitive.setBindPath("3010149");

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
  public QS001200Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(600, 355);

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

    guidanceManagements.add(getBedGuidanceManagement(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getBeginningGuidanceManagement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getHeavyRecuperateGuidanceManagement(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getParticularInstitutionManagment(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getParticularInstitutionManagmentPrivateRoom2(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getHeavySkinManegement(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getMedicineManegementLeading(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getSpecialMedicineManagementLeading(), VRLayout.FLOW_INSETLINE_RETURN);

    guidanceManagements.add(getMedicalScienceInfo(), VRLayout.FLOW_INSETLINE);

    guidanceManagements.add(getRehabilitationManegement(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �����΍�w���Ǘ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfectionGuidanceManagement(){

  }

  /**
   * ��ጊǗ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBedGuidanceManagement(){

  }

  /**
   * ���������f�ÊǗ��ɓ������ڂ�ǉ����܂��B
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
   * ��w���񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalScienceInfo(){

  }

  /**
   * ���n�r���e�[�V�����w���Ǘ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManegement(){

  }

  /**
   * ���n�r���e�[�V�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitation(){

    rehabilitation.add(getEtcFrame(), VRLayout.NORTH);

    rehabilitation.add(getMindFrame(), VRLayout.NORTH);

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

    etcFrames.add(getRehabilitationSystem(), VRLayout.FLOW_INSETLINE);

    etcFrames.add(getDinner(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���꒮�o�Ö@�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy1Conteiner(){

    languageTherapy1Conteiner.add(getLanguageTherapy1(), null);

    languageTherapy1Conteiner.add(getLanguageTherapy1Combo(), null);

  }

  /**
   * ���꒮�o�Ö@�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy1(){

  }

  /**
   * ���꒮�o�Ö@�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguageTherapy1Combo(){

  }

  /**
   * ���꒮�o�Ö@�R���{���f���ɓ������ڂ�ǉ����܂��B
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
   * ���꒮�o�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage1(){

  }

  /**
   * ���꒮�o�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage1Combo(){

  }

  /**
   * ���꒮�o�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLanguage1ComboModel(){

  }

  /**
   * ���n�r���̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem(){

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
   * �F�m�ǘV�l�������_�Ö@�ɓ������ڂ�ǉ����܂��B
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
      new QS001200Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001200Design getThis() {
    return this;
  }
}
