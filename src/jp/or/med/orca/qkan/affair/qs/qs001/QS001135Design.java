
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
 * �J����: ���{�@�K��
 * �쐬��: 2006/05/09  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�ʏ���� (QS001135)
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
 * �T�[�r�X�p�^�[�����\�h�ʏ�����ʍ��ڃf�U�C��(QS001135) 
 */
public class QS001135Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel preventiveExpertPlaceCareMultiPatterns;

  private ACClearableRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACClearableRadioButtonGroup activityAddRadio;

  private ACLabelContainer activityAddRadioContainer;

  private ACListModelAdapter activityAddRadioModel;

  private ACRadioButtonItem activityAddRadioItem1;

  private ACRadioButtonItem activityAddRadioItem2;

  private ACClearableRadioButtonGroup moveFunctionImprovementAddRadio;

  private ACLabelContainer moveFunctionImprovementAddRadioContainer;

  private ACListModelAdapter moveFunctionImprovementAddRadioModel;

  private ACRadioButtonItem moveFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem moveFunctionImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup nourishmentImprovementAddRadio;

  private ACLabelContainer nourishmentImprovementAddRadioContainer;

  private ACListModelAdapter nourishmentImprovementAddRadioModel;

  private ACRadioButtonItem nourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem nourishmentImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup mouthFunctionImprovementAddRadio;

  private ACLabelContainer mouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter mouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem mouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem mouthFunctionImprovementAddRadioItem2;

  private ACClearableRadioButtonGroup officeEvaluationAddRadio;

  private ACLabelContainer officeEvaluationAddRadioContainer;

  private ACListModelAdapter officeEvaluationAddRadioModel;

  private ACRadioButtonItem officeEvaluationAddRadioItem1;

  private ACRadioButtonItem officeEvaluationAddRadioItem2;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  //getter

  /**
   * ���\�h�ʏ����p�^�[���̈���擾���܂��B
   * @return ���\�h�ʏ����p�^�[���̈�
   */
  public ACPanel getPreventiveExpertPlaceCareMultiPatterns(){
    if(preventiveExpertPlaceCareMultiPatterns==null){

      preventiveExpertPlaceCareMultiPatterns = new ACPanel();

      preventiveExpertPlaceCareMultiPatterns.setAutoWrap(false);

      preventiveExpertPlaceCareMultiPatterns.setHgrid(200);

      addPreventiveExpertPlaceCareMultiPatterns();
    }
    return preventiveExpertPlaceCareMultiPatterns;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACClearableRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("�l�����Z");

      staffSubtractionRadio.setBindPath("1650101");

      staffSubtractionRadio.setUseClearButton(false);

      staffSubtractionRadio.setModel(getStaffSubtractionRadioModel());

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
   * �Ō�E���E�����������擾���܂��B
   * @return �Ō�E���E��������
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("�Ō�E���E��������");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("����");

      crackOnDayCheck.setBindPath("1650102");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * �A�N�e�B�r�e�B���{���Z���擾���܂��B
   * @return �A�N�e�B�r�e�B���{���Z
   */
  public ACClearableRadioButtonGroup getActivityAddRadio(){
    if(activityAddRadio==null){

      activityAddRadio = new ACClearableRadioButtonGroup();

      getActivityAddRadioContainer().setText("�A�N�e�B�r�e�B���{���Z");

      activityAddRadio.setBindPath("1650103");

      activityAddRadio.setUseClearButton(false);

      activityAddRadio.setModel(getActivityAddRadioModel());

      addActivityAddRadio();
    }
    return activityAddRadio;

  }

  /**
   * �A�N�e�B�r�e�B���{���Z�R���e�i���擾���܂��B
   * @return �A�N�e�B�r�e�B���{���Z�R���e�i
   */
  protected ACLabelContainer getActivityAddRadioContainer(){
    if(activityAddRadioContainer==null){
      activityAddRadioContainer = new ACLabelContainer();
      activityAddRadioContainer.setFollowChildEnabled(true);
      activityAddRadioContainer.setVAlignment(VRLayout.CENTER);
      activityAddRadioContainer.add(getActivityAddRadio(), null);
    }
    return activityAddRadioContainer;
  }

  /**
   * �A�N�e�B�r�e�B���{���Z���f�����擾���܂��B
   * @return �A�N�e�B�r�e�B���{���Z���f��
   */
  protected ACListModelAdapter getActivityAddRadioModel(){
    if(activityAddRadioModel==null){
      activityAddRadioModel = new ACListModelAdapter();
      addActivityAddRadioModel();
    }
    return activityAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getActivityAddRadioItem1(){
    if(activityAddRadioItem1==null){

      activityAddRadioItem1 = new ACRadioButtonItem();

      activityAddRadioItem1.setText("�Ȃ�");

      activityAddRadioItem1.setGroup(getActivityAddRadio());

      activityAddRadioItem1.setConstraints(VRLayout.FLOW);

      addActivityAddRadioItem1();
    }
    return activityAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getActivityAddRadioItem2(){
    if(activityAddRadioItem2==null){

      activityAddRadioItem2 = new ACRadioButtonItem();

      activityAddRadioItem2.setText("����");

      activityAddRadioItem2.setGroup(getActivityAddRadio());

      activityAddRadioItem2.setConstraints(VRLayout.FLOW);

      addActivityAddRadioItem2();
    }
    return activityAddRadioItem2;

  }

  /**
   * �^����@�\������Z���擾���܂��B
   * @return �^����@�\������Z
   */
  public ACClearableRadioButtonGroup getMoveFunctionImprovementAddRadio(){
    if(moveFunctionImprovementAddRadio==null){

      moveFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getMoveFunctionImprovementAddRadioContainer().setText("�^����@�\������Z");

      moveFunctionImprovementAddRadio.setBindPath("1650104");

      moveFunctionImprovementAddRadio.setUseClearButton(false);

      moveFunctionImprovementAddRadio.setModel(getMoveFunctionImprovementAddRadioModel());

      addMoveFunctionImprovementAddRadio();
    }
    return moveFunctionImprovementAddRadio;

  }

  /**
   * �^����@�\������Z�R���e�i���擾���܂��B
   * @return �^����@�\������Z�R���e�i
   */
  protected ACLabelContainer getMoveFunctionImprovementAddRadioContainer(){
    if(moveFunctionImprovementAddRadioContainer==null){
      moveFunctionImprovementAddRadioContainer = new ACLabelContainer();
      moveFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      moveFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      moveFunctionImprovementAddRadioContainer.add(getMoveFunctionImprovementAddRadio(), null);
    }
    return moveFunctionImprovementAddRadioContainer;
  }

  /**
   * �^����@�\������Z���f�����擾���܂��B
   * @return �^����@�\������Z���f��
   */
  protected ACListModelAdapter getMoveFunctionImprovementAddRadioModel(){
    if(moveFunctionImprovementAddRadioModel==null){
      moveFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addMoveFunctionImprovementAddRadioModel();
    }
    return moveFunctionImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMoveFunctionImprovementAddRadioItem1(){
    if(moveFunctionImprovementAddRadioItem1==null){

      moveFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      moveFunctionImprovementAddRadioItem1.setText("�Ȃ�");

      moveFunctionImprovementAddRadioItem1.setGroup(getMoveFunctionImprovementAddRadio());

      moveFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMoveFunctionImprovementAddRadioItem1();
    }
    return moveFunctionImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMoveFunctionImprovementAddRadioItem2(){
    if(moveFunctionImprovementAddRadioItem2==null){

      moveFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      moveFunctionImprovementAddRadioItem2.setText("����");

      moveFunctionImprovementAddRadioItem2.setGroup(getMoveFunctionImprovementAddRadio());

      moveFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMoveFunctionImprovementAddRadioItem2();
    }
    return moveFunctionImprovementAddRadioItem2;

  }

  /**
   * �h�{���P���Z���擾���܂��B
   * @return �h�{���P���Z
   */
  public ACClearableRadioButtonGroup getNourishmentImprovementAddRadio(){
    if(nourishmentImprovementAddRadio==null){

      nourishmentImprovementAddRadio = new ACClearableRadioButtonGroup();

      getNourishmentImprovementAddRadioContainer().setText("�h�{���P���Z");

      nourishmentImprovementAddRadio.setBindPath("1650105");

      nourishmentImprovementAddRadio.setUseClearButton(false);

      nourishmentImprovementAddRadio.setModel(getNourishmentImprovementAddRadioModel());

      addNourishmentImprovementAddRadio();
    }
    return nourishmentImprovementAddRadio;

  }

  /**
   * �h�{���P���Z�R���e�i���擾���܂��B
   * @return �h�{���P���Z�R���e�i
   */
  protected ACLabelContainer getNourishmentImprovementAddRadioContainer(){
    if(nourishmentImprovementAddRadioContainer==null){
      nourishmentImprovementAddRadioContainer = new ACLabelContainer();
      nourishmentImprovementAddRadioContainer.setFollowChildEnabled(true);
      nourishmentImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      nourishmentImprovementAddRadioContainer.add(getNourishmentImprovementAddRadio(), null);
    }
    return nourishmentImprovementAddRadioContainer;
  }

  /**
   * �h�{���P���Z���f�����擾���܂��B
   * @return �h�{���P���Z���f��
   */
  protected ACListModelAdapter getNourishmentImprovementAddRadioModel(){
    if(nourishmentImprovementAddRadioModel==null){
      nourishmentImprovementAddRadioModel = new ACListModelAdapter();
      addNourishmentImprovementAddRadioModel();
    }
    return nourishmentImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNourishmentImprovementAddRadioItem1(){
    if(nourishmentImprovementAddRadioItem1==null){

      nourishmentImprovementAddRadioItem1 = new ACRadioButtonItem();

      nourishmentImprovementAddRadioItem1.setText("�Ȃ�");

      nourishmentImprovementAddRadioItem1.setGroup(getNourishmentImprovementAddRadio());

      nourishmentImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementAddRadioItem1();
    }
    return nourishmentImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNourishmentImprovementAddRadioItem2(){
    if(nourishmentImprovementAddRadioItem2==null){

      nourishmentImprovementAddRadioItem2 = new ACRadioButtonItem();

      nourishmentImprovementAddRadioItem2.setText("����");

      nourishmentImprovementAddRadioItem2.setGroup(getNourishmentImprovementAddRadio());

      nourishmentImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementAddRadioItem2();
    }
    return nourishmentImprovementAddRadioItem2;

  }

  /**
   * ���o�@�\������Z���擾���܂��B
   * @return ���o�@�\������Z
   */
  public ACClearableRadioButtonGroup getMouthFunctionImprovementAddRadio(){
    if(mouthFunctionImprovementAddRadio==null){

      mouthFunctionImprovementAddRadio = new ACClearableRadioButtonGroup();

      getMouthFunctionImprovementAddRadioContainer().setText("���o�@�\������Z");

      mouthFunctionImprovementAddRadio.setBindPath("1650106");

      mouthFunctionImprovementAddRadio.setUseClearButton(false);

      mouthFunctionImprovementAddRadio.setModel(getMouthFunctionImprovementAddRadioModel());

      addMouthFunctionImprovementAddRadio();
    }
    return mouthFunctionImprovementAddRadio;

  }

  /**
   * ���o�@�\������Z�R���e�i���擾���܂��B
   * @return ���o�@�\������Z�R���e�i
   */
  protected ACLabelContainer getMouthFunctionImprovementAddRadioContainer(){
    if(mouthFunctionImprovementAddRadioContainer==null){
      mouthFunctionImprovementAddRadioContainer = new ACLabelContainer();
      mouthFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      mouthFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      mouthFunctionImprovementAddRadioContainer.add(getMouthFunctionImprovementAddRadio(), null);
    }
    return mouthFunctionImprovementAddRadioContainer;
  }

  /**
   * ���o�@�\������Z���f�����擾���܂��B
   * @return ���o�@�\������Z���f��
   */
  protected ACListModelAdapter getMouthFunctionImprovementAddRadioModel(){
    if(mouthFunctionImprovementAddRadioModel==null){
      mouthFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addMouthFunctionImprovementAddRadioModel();
    }
    return mouthFunctionImprovementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMouthFunctionImprovementAddRadioItem1(){
    if(mouthFunctionImprovementAddRadioItem1==null){

      mouthFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      mouthFunctionImprovementAddRadioItem1.setText("�Ȃ�");

      mouthFunctionImprovementAddRadioItem1.setGroup(getMouthFunctionImprovementAddRadio());

      mouthFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMouthFunctionImprovementAddRadioItem1();
    }
    return mouthFunctionImprovementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMouthFunctionImprovementAddRadioItem2(){
    if(mouthFunctionImprovementAddRadioItem2==null){

      mouthFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      mouthFunctionImprovementAddRadioItem2.setText("����");

      mouthFunctionImprovementAddRadioItem2.setGroup(getMouthFunctionImprovementAddRadio());

      mouthFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMouthFunctionImprovementAddRadioItem2();
    }
    return mouthFunctionImprovementAddRadioItem2;

  }

  /**
   * ���Ə��]�����Z���擾���܂��B
   * @return ���Ə��]�����Z
   */
  public ACClearableRadioButtonGroup getOfficeEvaluationAddRadio(){
    if(officeEvaluationAddRadio==null){

      officeEvaluationAddRadio = new ACClearableRadioButtonGroup();

      getOfficeEvaluationAddRadioContainer().setText("���Ə��]�����Z");

      officeEvaluationAddRadio.setBindPath("1650107");

      officeEvaluationAddRadio.setUseClearButton(false);

      officeEvaluationAddRadio.setModel(getOfficeEvaluationAddRadioModel());

      addOfficeEvaluationAddRadio();
    }
    return officeEvaluationAddRadio;

  }

  /**
   * ���Ə��]�����Z�R���e�i���擾���܂��B
   * @return ���Ə��]�����Z�R���e�i
   */
  protected ACLabelContainer getOfficeEvaluationAddRadioContainer(){
    if(officeEvaluationAddRadioContainer==null){
      officeEvaluationAddRadioContainer = new ACLabelContainer();
      officeEvaluationAddRadioContainer.setFollowChildEnabled(true);
      officeEvaluationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      officeEvaluationAddRadioContainer.add(getOfficeEvaluationAddRadio(), null);
    }
    return officeEvaluationAddRadioContainer;
  }

  /**
   * ���Ə��]�����Z���f�����擾���܂��B
   * @return ���Ə��]�����Z���f��
   */
  protected ACListModelAdapter getOfficeEvaluationAddRadioModel(){
    if(officeEvaluationAddRadioModel==null){
      officeEvaluationAddRadioModel = new ACListModelAdapter();
      addOfficeEvaluationAddRadioModel();
    }
    return officeEvaluationAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOfficeEvaluationAddRadioItem1(){
    if(officeEvaluationAddRadioItem1==null){

      officeEvaluationAddRadioItem1 = new ACRadioButtonItem();

      officeEvaluationAddRadioItem1.setText("�Ȃ�");

      officeEvaluationAddRadioItem1.setGroup(getOfficeEvaluationAddRadio());

      officeEvaluationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOfficeEvaluationAddRadioItem1();
    }
    return officeEvaluationAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getOfficeEvaluationAddRadioItem2(){
    if(officeEvaluationAddRadioItem2==null){

      officeEvaluationAddRadioItem2 = new ACRadioButtonItem();

      officeEvaluationAddRadioItem2.setText("����");

      officeEvaluationAddRadioItem2.setGroup(getOfficeEvaluationAddRadio());

      officeEvaluationAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOfficeEvaluationAddRadioItem2();
    }
    return officeEvaluationAddRadioItem2;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHoumonKaigoTimeContainer(){
    if(houmonKaigoTimeContainer==null){

      houmonKaigoTimeContainer = new ACBackLabelContainer();

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
   * �R���X�g���N�^�ł��B
   */
  public QS001135Design() {

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

    this.add(getPreventiveExpertPlaceCareMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * ���\�h�ʏ����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPreventiveExpertPlaceCareMultiPatterns(){

    preventiveExpertPlaceCareMultiPatterns.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getCrackOnDayCheck(), VRLayout.FLOW_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getActivityAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getMoveFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getOfficeEvaluationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveExpertPlaceCareMultiPatterns.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

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
   * �Ō�E���E���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem3(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCrackOnDayCheck(){

  }

  /**
   * �A�N�e�B�r�e�B���{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addActivityAddRadio(){

  }

  /**
   * �A�N�e�B�r�e�B���{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addActivityAddRadioModel(){

    getActivityAddRadioItem1().setButtonIndex(1);
    getActivityAddRadioModel().add(getActivityAddRadioItem1());

    getActivityAddRadioItem2().setButtonIndex(2);
    getActivityAddRadioModel().add(getActivityAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addActivityAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addActivityAddRadioItem2(){

  }

  /**
   * �^����@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMoveFunctionImprovementAddRadio(){

  }

  /**
   * �^����@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMoveFunctionImprovementAddRadioModel(){

    getMoveFunctionImprovementAddRadioItem1().setButtonIndex(1);
    getMoveFunctionImprovementAddRadioModel().add(getMoveFunctionImprovementAddRadioItem1());

    getMoveFunctionImprovementAddRadioItem2().setButtonIndex(2);
    getMoveFunctionImprovementAddRadioModel().add(getMoveFunctionImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMoveFunctionImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMoveFunctionImprovementAddRadioItem2(){

  }

  /**
   * �h�{���P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovementAddRadio(){

  }

  /**
   * �h�{���P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovementAddRadioModel(){

    getNourishmentImprovementAddRadioItem1().setButtonIndex(1);
    getNourishmentImprovementAddRadioModel().add(getNourishmentImprovementAddRadioItem1());

    getNourishmentImprovementAddRadioItem2().setButtonIndex(2);
    getNourishmentImprovementAddRadioModel().add(getNourishmentImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovementAddRadioItem2(){

  }

  /**
   * ���o�@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthFunctionImprovementAddRadio(){

  }

  /**
   * ���o�@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthFunctionImprovementAddRadioModel(){

    getMouthFunctionImprovementAddRadioItem1().setButtonIndex(1);
    getMouthFunctionImprovementAddRadioModel().add(getMouthFunctionImprovementAddRadioItem1());

    getMouthFunctionImprovementAddRadioItem2().setButtonIndex(2);
    getMouthFunctionImprovementAddRadioModel().add(getMouthFunctionImprovementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthFunctionImprovementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthFunctionImprovementAddRadioItem2(){

  }

  /**
   * ���Ə��]�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOfficeEvaluationAddRadio(){

  }

  /**
   * ���Ə��]�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOfficeEvaluationAddRadioModel(){

    getOfficeEvaluationAddRadioItem1().setButtonIndex(1);
    getOfficeEvaluationAddRadioModel().add(getOfficeEvaluationAddRadioItem1());

    getOfficeEvaluationAddRadioItem2().setButtonIndex(2);
    getOfficeEvaluationAddRadioModel().add(getOfficeEvaluationAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOfficeEvaluationAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOfficeEvaluationAddRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001135Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001135Design getThis() {
    return this;
  }
}
