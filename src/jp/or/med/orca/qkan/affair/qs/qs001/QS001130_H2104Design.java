
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
 * �쐬��: 2009/03/06  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�K���� (QS001130_H2104)
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
 * �T�[�r�X�p�^�[�����\�h�K�����ʍ��ڃf�U�C��(QS001130_H2104) 
 */
public class QS001130_H2104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel preventiveVisitCareMultiPatterns;

  private ACClearableRadioButtonGroup visitCareExpenseAddRadio;

  private ACLabelContainer visitCareExpenseAddRadioContainer;

  private ACListModelAdapter visitCareExpenseAddRadioModel;

  private ACRadioButtonItem visitCareExpenseAddRadioItem1;

  private ACRadioButtonItem visitCareExpenseAddRadioItem2;

  private ACRadioButtonItem visitCareExpenseAddRadioItem3;

  private ACClearableRadioButtonGroup classEmploymentAddRadio;

  private ACLabelContainer classEmploymentAddRadioContainer;

  private ACListModelAdapter classEmploymentAddRadioModel;

  private ACRadioButtonItem classEmploymentAddRadioItem1;

  private ACRadioButtonItem classEmploymentAddRadioItem2;

  private ACValueArrayRadioButtonGroup houmonKaigoFirstAddRadioGroup;

  private ACLabelContainer houmonKaigoFirstAddRadioGroupContainer;

  private ACListModelAdapter houmonKaigoFirstAddRadioGroupModel;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem1;

  private ACRadioButtonItem houmonKaigoFirstAddRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRafioRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRafioRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRafioRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRafioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRafioRadioItem2;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  private ACGroupBox infoGroup;

  private ACLabel infoLabel;

  //getter

  /**
   * ���\�h�K����p�^�[���̈���擾���܂��B
   * @return ���\�h�K����p�^�[���̈�
   */
  public ACPanel getPreventiveVisitCareMultiPatterns(){
    if(preventiveVisitCareMultiPatterns==null){

      preventiveVisitCareMultiPatterns = new ACPanel();

      preventiveVisitCareMultiPatterns.setAutoWrap(false);

      addPreventiveVisitCareMultiPatterns();
    }
    return preventiveVisitCareMultiPatterns;

  }

  /**
   * �K�������擾���܂��B
   * @return �K�����
   */
  public ACClearableRadioButtonGroup getVisitCareExpenseAddRadio(){
    if(visitCareExpenseAddRadio==null){

      visitCareExpenseAddRadio = new ACClearableRadioButtonGroup();

      getVisitCareExpenseAddRadioContainer().setText("�K�����");

      visitCareExpenseAddRadio.setBindPath("1610101");

      visitCareExpenseAddRadio.setUseClearButton(false);

      visitCareExpenseAddRadio.setModel(getVisitCareExpenseAddRadioModel());

      addVisitCareExpenseAddRadio();
    }
    return visitCareExpenseAddRadio;

  }

  /**
   * �K�����R���e�i���擾���܂��B
   * @return �K�����R���e�i
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
   * �K�����f�����擾���܂��B
   * @return �K�����f��
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

      visitCareExpenseAddRadioItem3.setConstraints(VRLayout.FLOW);

      addVisitCareExpenseAddRadioItem3();
    }
    return visitCareExpenseAddRadioItem3;

  }

  /**
   * �K��҂̋��E���擾���܂��B
   * @return �K��҂̋��E
   */
  public ACClearableRadioButtonGroup getClassEmploymentAddRadio(){
    if(classEmploymentAddRadio==null){

      classEmploymentAddRadio = new ACClearableRadioButtonGroup();

      getClassEmploymentAddRadioContainer().setText("�K��҂̋��E");

      classEmploymentAddRadio.setBindPath("1610102");

      classEmploymentAddRadio.setUseClearButton(false);

      classEmploymentAddRadio.setModel(getClassEmploymentAddRadioModel());

      addClassEmploymentAddRadio();
    }
    return classEmploymentAddRadio;

  }

  /**
   * �K��҂̋��E�R���e�i���擾���܂��B
   * @return �K��҂̋��E�R���e�i
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
   * �K��҂̋��E���f�����擾���܂��B
   * @return �K��҂̋��E���f��
   */
  protected ACListModelAdapter getClassEmploymentAddRadioModel(){
    if(classEmploymentAddRadioModel==null){
      classEmploymentAddRadioModel = new ACListModelAdapter();
      addClassEmploymentAddRadioModel();
    }
    return classEmploymentAddRadioModel;
  }

  /**
   * 3���ȊO���擾���܂��B
   * @return 3���ȊO
   */
  public ACRadioButtonItem getClassEmploymentAddRadioItem1(){
    if(classEmploymentAddRadioItem1==null){

      classEmploymentAddRadioItem1 = new ACRadioButtonItem();

      classEmploymentAddRadioItem1.setText("3���ȊO");

      classEmploymentAddRadioItem1.setGroup(getClassEmploymentAddRadio());

      classEmploymentAddRadioItem1.setConstraints(VRLayout.FLOW);

      addClassEmploymentAddRadioItem1();
    }
    return classEmploymentAddRadioItem1;

  }

  /**
   * 3�����擾���܂��B
   * @return 3��
   */
  public ACRadioButtonItem getClassEmploymentAddRadioItem2(){
    if(classEmploymentAddRadioItem2==null){

      classEmploymentAddRadioItem2 = new ACRadioButtonItem();

      classEmploymentAddRadioItem2.setText("3��");

      classEmploymentAddRadioItem2.setGroup(getClassEmploymentAddRadio());

      classEmploymentAddRadioItem2.setConstraints(VRLayout.FLOW);

      addClassEmploymentAddRadioItem2();
    }
    return classEmploymentAddRadioItem2;

  }

  /**
   * ������Z���擾���܂��B
   * @return ������Z
   */
  public ACValueArrayRadioButtonGroup getHoumonKaigoFirstAddRadioGroup(){
    if(houmonKaigoFirstAddRadioGroup==null){

      houmonKaigoFirstAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getHoumonKaigoFirstAddRadioGroupContainer().setText("������Z");

      houmonKaigoFirstAddRadioGroup.setBindPath("1610104");

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

      crackOnDayCheck.setBindPath("1610103");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

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
   * ���ӏ����O���[�v���擾���܂��B
   * @return ���ӏ����O���[�v
   */
  public ACGroupBox getInfoGroup(){
    if(infoGroup==null){

      infoGroup = new ACGroupBox();

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

      infoLabel.setText("���r���ŗv�x��1�̗v�x��2�̕ύX�ƂȂ�ꍇ�́A" + ACConstants.LINE_SEPARATOR + "�e������T�[�r�X�����ׂĂ̓����ɓ\��t���āA" + ACConstants.LINE_SEPARATOR + "�W�v��A�ҏW��ʂŎ������̏C�����s���Ă��������B");

      addInfoLabel();
    }
    return infoLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001130_H2104Design() {

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
   * ���\�h�K����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPreventiveVisitCareMultiPatterns(){

    preventiveVisitCareMultiPatterns.add(getVisitCareExpenseAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveVisitCareMultiPatterns.add(getClassEmploymentAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveVisitCareMultiPatterns.add(getHoumonKaigoFirstAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveVisitCareMultiPatterns.add(getProviderAddMountainousAreaRafioRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    preventiveVisitCareMultiPatterns.add(getCrackOnDayCheck(), VRLayout.FLOW_RETURN);

    preventiveVisitCareMultiPatterns.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    preventiveVisitCareMultiPatterns.add(getInfoGroup(), VRLayout.FLOW);

  }

  /**
   * �K�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadio(){

  }

  /**
   * �K�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addVisitCareExpenseAddRadioModel(){

    getVisitCareExpenseAddRadioItem1().setButtonIndex(1);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem1());

    getVisitCareExpenseAddRadioItem2().setButtonIndex(2);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem2());

    getVisitCareExpenseAddRadioItem3().setButtonIndex(3);

    getVisitCareExpenseAddRadioModel().add(getVisitCareExpenseAddRadioItem3());

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
   * �K��҂̋��E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentAddRadio(){

  }

  /**
   * �K��҂̋��E���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentAddRadioModel(){

    getClassEmploymentAddRadioItem1().setButtonIndex(1);

    getClassEmploymentAddRadioModel().add(getClassEmploymentAddRadioItem1());

    getClassEmploymentAddRadioItem2().setButtonIndex(2);

    getClassEmploymentAddRadioModel().add(getClassEmploymentAddRadioItem2());

  }

  /**
   * 3���ȊO�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentAddRadioItem1(){

  }

  /**
   * 3���ɓ������ڂ�ǉ����܂��B
   */
  protected void addClassEmploymentAddRadioItem2(){

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
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKaigoTimeContainer(){

    houmonKaigoTimeContainer.add(getHoumonKaigoBeginTimeContainer(), VRLayout.FLOW);

    houmonKaigoTimeContainer.add(getHoumonKaigoEndTimeContainer(), VRLayout.FLOW_RETURN);

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
      ACFrame.debugStart(new ACAffairInfo(QS001130_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001130_H2104Design getThis() {
    return this;
  }
}
