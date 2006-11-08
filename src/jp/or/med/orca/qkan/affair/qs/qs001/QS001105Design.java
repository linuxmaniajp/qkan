
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
 * �쐬��: 2006/03/09  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K�⃊�n (QS001105)
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
import jp.or.med.orca.qkan.text.*;
/**
 * �T�[�r�X�p�^�[���K�⃊�n��ʍ��ڃf�U�C��(QS001105) 
 */
public class QS001105Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel houmonRehabilitationPatterns;

  private ACClearableRadioButtonGroup houmonRehabilitationFacilityDivision;

  private ACLabelContainer houmonRehabilitationFacilityDivisionContainer;

  private ACListModelAdapter houmonRehabilitationFacilityDivisionModel;

  private ACRadioButtonItem houmonRehabilitationClassDouble;

  private ACRadioButtonItem houmonRehabilitationClassSingle;

  private ACClearableRadioButtonGroup houmonRehabiliManagementAddRadio;

  private ACLabelContainer houmonRehabiliManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabiliManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabiliManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabiliManagementAddRadioItem2;

  private ACClearableRadioButtonGroup houmonRehabiliShortConcentrationAddRadio;

  private ACLabelContainer houmonRehabiliShortConcentrationAddRadioContainer;

  private ACListModelAdapter houmonRehabiliShortConcentrationAddRadioModel;

  private ACRadioButtonItem houmonRehabiliShortConcentrationAddRadioItem1;

  private ACRadioButtonItem houmonRehabiliShortConcentrationAddRadioItem2;

  private ACRadioButtonItem houmonRehabiliShortConcentrationAddRadioItem3;

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

      addHoumonRehabilitationPatterns();
    }
    return houmonRehabilitationPatterns;

  }

  /**
   * �{�ݓ��̋敪���擾���܂��B
   * @return �{�ݓ��̋敪
   */
  public ACClearableRadioButtonGroup getHoumonRehabilitationFacilityDivision(){
    if(houmonRehabilitationFacilityDivision==null){

      houmonRehabilitationFacilityDivision = new ACClearableRadioButtonGroup();

      getHoumonRehabilitationFacilityDivisionContainer().setText("�{�ݓ��̋敪");

      houmonRehabilitationFacilityDivision.setBindPath("1140103");

      houmonRehabilitationFacilityDivision.setModel(getHoumonRehabilitationFacilityDivisionModel());

      houmonRehabilitationFacilityDivision.setUseClearButton(false);

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
   * ���n�r���E�}�l�W�����g���Z���擾���܂��B
   * @return ���n�r���E�}�l�W�����g���Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabiliManagementAddRadio(){
    if(houmonRehabiliManagementAddRadio==null){

      houmonRehabiliManagementAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabiliManagementAddRadioContainer().setText("���n�r���E�}�l�W�����g���Z");

      houmonRehabiliManagementAddRadio.setBindPath("1140105");

      houmonRehabiliManagementAddRadio.setModel(getHoumonRehabiliManagementAddRadioModel());

      houmonRehabiliManagementAddRadio.setUseClearButton(false);

      addHoumonRehabiliManagementAddRadio();
    }
    return houmonRehabiliManagementAddRadio;

  }

  /**
   * ���n�r���E�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return ���n�r���E�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getHoumonRehabiliManagementAddRadioContainer(){
    if(houmonRehabiliManagementAddRadioContainer==null){
      houmonRehabiliManagementAddRadioContainer = new ACLabelContainer();
      houmonRehabiliManagementAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabiliManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabiliManagementAddRadioContainer.add(getHoumonRehabiliManagementAddRadio(), null);
    }
    return houmonRehabiliManagementAddRadioContainer;
  }

  /**
   * ���n�r���E�}�l�W�����g���Z���f�����擾���܂��B
   * @return ���n�r���E�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getHoumonRehabiliManagementAddRadioModel(){
    if(houmonRehabiliManagementAddRadioModel==null){
      houmonRehabiliManagementAddRadioModel = new ACListModelAdapter();
      addHoumonRehabiliManagementAddRadioModel();
    }
    return houmonRehabiliManagementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonRehabiliManagementAddRadioItem1(){
    if(houmonRehabiliManagementAddRadioItem1==null){

      houmonRehabiliManagementAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabiliManagementAddRadioItem1.setText("�Ȃ�");

      houmonRehabiliManagementAddRadioItem1.setGroup(getHoumonRehabiliManagementAddRadio());

      houmonRehabiliManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabiliManagementAddRadioItem1();
    }
    return houmonRehabiliManagementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonRehabiliManagementAddRadioItem2(){
    if(houmonRehabiliManagementAddRadioItem2==null){

      houmonRehabiliManagementAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabiliManagementAddRadioItem2.setText("����");

      houmonRehabiliManagementAddRadioItem2.setGroup(getHoumonRehabiliManagementAddRadio());

      houmonRehabiliManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabiliManagementAddRadioItem2();
    }
    return houmonRehabiliManagementAddRadioItem2;

  }

  /**
   * �Z���W�����n�r�����{���Z���擾���܂��B
   * @return �Z���W�����n�r�����{���Z
   */
  public ACClearableRadioButtonGroup getHoumonRehabiliShortConcentrationAddRadio(){
    if(houmonRehabiliShortConcentrationAddRadio==null){

      houmonRehabiliShortConcentrationAddRadio = new ACClearableRadioButtonGroup();

      getHoumonRehabiliShortConcentrationAddRadioContainer().setText("�Z���W�����n�r�����{���Z");

      houmonRehabiliShortConcentrationAddRadio.setBindPath("1140106");

      houmonRehabiliShortConcentrationAddRadio.setModel(getHoumonRehabiliShortConcentrationAddRadioModel());

      houmonRehabiliShortConcentrationAddRadio.setUseClearButton(false);

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
   * �P���ȓ����擾���܂��B
   * @return �P���ȓ�
   */
  public ACRadioButtonItem getHoumonRehabiliShortConcentrationAddRadioItem2(){
    if(houmonRehabiliShortConcentrationAddRadioItem2==null){

      houmonRehabiliShortConcentrationAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabiliShortConcentrationAddRadioItem2.setText("�P���ȓ�");

      houmonRehabiliShortConcentrationAddRadioItem2.setGroup(getHoumonRehabiliShortConcentrationAddRadio());

      houmonRehabiliShortConcentrationAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabiliShortConcentrationAddRadioItem2();
    }
    return houmonRehabiliShortConcentrationAddRadioItem2;

  }

  /**
   * �P�����R���ȓ����擾���܂��B
   * @return �P�����R���ȓ�
   */
  public ACRadioButtonItem getHoumonRehabiliShortConcentrationAddRadioItem3(){
    if(houmonRehabiliShortConcentrationAddRadioItem3==null){

      houmonRehabiliShortConcentrationAddRadioItem3 = new ACRadioButtonItem();

      houmonRehabiliShortConcentrationAddRadioItem3.setText("�P�����R���ȓ�");

      houmonRehabiliShortConcentrationAddRadioItem3.setGroup(getHoumonRehabiliShortConcentrationAddRadio());

      houmonRehabiliShortConcentrationAddRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonRehabiliShortConcentrationAddRadioItem3();
    }
    return houmonRehabiliShortConcentrationAddRadioItem3;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHoumonRehabilitationTimeContena(){
    if(houmonRehabilitationTimeContena==null){

      houmonRehabilitationTimeContena = new ACBackLabelContainer();

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

      houmonRehabilitationBeginTime.setModel(getHoumonRehabilitationBeginTimeModel());

      houmonRehabilitationBeginTime.setRenderBindPath("CONTENT");

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

      houmonRehabilitationEndTime.setModel(getHoumonRehabilitationEndTimeModel());

      houmonRehabilitationEndTime.setRenderBindPath("CONTENT");

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
  public QS001105Design() {

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

    houmonRehabilitationPatterns.add(getHoumonRehabiliManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonRehabilitationPatterns.add(getHoumonRehabiliShortConcentrationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * ���n�r���E�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliManagementAddRadio(){

  }

  /**
   * ���n�r���E�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliManagementAddRadioModel(){

    getHoumonRehabiliManagementAddRadioItem1().setButtonIndex(1);
    getHoumonRehabiliManagementAddRadioModel().add(getHoumonRehabiliManagementAddRadioItem1());

    getHoumonRehabiliManagementAddRadioItem2().setButtonIndex(2);
    getHoumonRehabiliManagementAddRadioModel().add(getHoumonRehabiliManagementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliManagementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliManagementAddRadioItem2(){

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

    getHoumonRehabiliShortConcentrationAddRadioItem3().setButtonIndex(3);
    getHoumonRehabiliShortConcentrationAddRadioModel().add(getHoumonRehabiliShortConcentrationAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioItem1(){

  }

  /**
   * �P���ȓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioItem2(){

  }

  /**
   * �P�����R���ȓ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonRehabiliShortConcentrationAddRadioItem3(){

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001105Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001105Design getThis() {
    return this;
  }
}
