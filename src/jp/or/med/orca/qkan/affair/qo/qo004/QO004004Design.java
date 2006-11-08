
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
 * �쐬��: 2006/02/18  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �K�⃊�n (QO004004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
 * �K�⃊�n��ʍ��ڃf�U�C��(QO004004) 
 */
public class QO004004Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox homonrehabilitationGroup;

  private ACLabelContainer homonrehabilitationDiscountContainer;

  private ACTextField homonrehabilitationDiscountRate;

  private ACLabel homonrehabilitationPercentSign;

  private ACClearableRadioButtonGroup homonrehabilitationInstitutionDivisionRadio;

  private ACLabelContainer homonrehabilitationInstitutionDivisionRadioContainer;

  private ACListModelAdapter homonrehabilitationInstitutionDivisionRadioModel;

  private ACRadioButtonItem homonrehabilitationInstitutionDivisionRadioItem1;

  private ACRadioButtonItem homonrehabilitationInstitutionDivisionRadioItem2;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getHomonrehabilitationGroup(){
    if(homonrehabilitationGroup==null){

      homonrehabilitationGroup = new ACGroupBox();

      homonrehabilitationGroup.setText("�K�⃊�n�r���e�[�V����");

      homonrehabilitationGroup.setFollowChildEnabled(true);

      addHomonrehabilitationGroup();
    }
    return homonrehabilitationGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getHomonrehabilitationDiscountContainer(){
    if(homonrehabilitationDiscountContainer==null){

      homonrehabilitationDiscountContainer = new ACLabelContainer();

      homonrehabilitationDiscountContainer.setText("������");

      homonrehabilitationDiscountContainer.setFollowChildEnabled(true);

      addHomonrehabilitationDiscountContainer();
    }
    return homonrehabilitationDiscountContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getHomonrehabilitationDiscountRate(){
    if(homonrehabilitationDiscountRate==null){

      homonrehabilitationDiscountRate = new ACTextField();

      homonrehabilitationDiscountRate.setBindPath("REDUCT_RATE");

      homonrehabilitationDiscountRate.setColumns(3);

      homonrehabilitationDiscountRate.setCharType(VRCharType.ONLY_DIGIT);

      homonrehabilitationDiscountRate.setHorizontalAlignment(SwingConstants.RIGHT);

      homonrehabilitationDiscountRate.setIMEMode(InputSubset.LATIN);

      homonrehabilitationDiscountRate.setMaxLength(3);

      addHomonrehabilitationDiscountRate();
    }
    return homonrehabilitationDiscountRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getHomonrehabilitationPercentSign(){
    if(homonrehabilitationPercentSign==null){

      homonrehabilitationPercentSign = new ACLabel();

      homonrehabilitationPercentSign.setText("��");

      addHomonrehabilitationPercentSign();
    }
    return homonrehabilitationPercentSign;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getHomonrehabilitationInstitutionDivisionRadio(){
    if(homonrehabilitationInstitutionDivisionRadio==null){

      homonrehabilitationInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getHomonrehabilitationInstitutionDivisionRadioContainer().setText("�{�݋敪");

      homonrehabilitationInstitutionDivisionRadio.setBindPath("1140101");

      homonrehabilitationInstitutionDivisionRadio.setModel(getHomonrehabilitationInstitutionDivisionRadioModel());

      homonrehabilitationInstitutionDivisionRadio.setUseClearButton(false);

      addHomonrehabilitationInstitutionDivisionRadio();
    }
    return homonrehabilitationInstitutionDivisionRadio;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getHomonrehabilitationInstitutionDivisionRadioContainer(){
    if(homonrehabilitationInstitutionDivisionRadioContainer==null){
      homonrehabilitationInstitutionDivisionRadioContainer = new ACLabelContainer();
      homonrehabilitationInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      homonrehabilitationInstitutionDivisionRadioContainer.add(getHomonrehabilitationInstitutionDivisionRadio(), null);
    }
    return homonrehabilitationInstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getHomonrehabilitationInstitutionDivisionRadioModel(){
    if(homonrehabilitationInstitutionDivisionRadioModel==null){
      homonrehabilitationInstitutionDivisionRadioModel = new ACListModelAdapter();
      addHomonrehabilitationInstitutionDivisionRadioModel();
    }
    return homonrehabilitationInstitutionDivisionRadioModel;
  }

  /**
   * �a�@�܂��͐f�Ï����擾���܂��B
   * @return �a�@�܂��͐f�Ï�
   */
  public ACRadioButtonItem getHomonrehabilitationInstitutionDivisionRadioItem1(){
    if(homonrehabilitationInstitutionDivisionRadioItem1==null){

      homonrehabilitationInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      homonrehabilitationInstitutionDivisionRadioItem1.setText("�a�@���͐f�Ï�");

      homonrehabilitationInstitutionDivisionRadioItem1.setGroup(getHomonrehabilitationInstitutionDivisionRadio());

      homonrehabilitationInstitutionDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addHomonrehabilitationInstitutionDivisionRadioItem1();
    }
    return homonrehabilitationInstitutionDivisionRadioItem1;

  }

  /**
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getHomonrehabilitationInstitutionDivisionRadioItem2(){
    if(homonrehabilitationInstitutionDivisionRadioItem2==null){

      homonrehabilitationInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      homonrehabilitationInstitutionDivisionRadioItem2.setText("���V�l�ی��{��");

      homonrehabilitationInstitutionDivisionRadioItem2.setGroup(getHomonrehabilitationInstitutionDivisionRadio());

      homonrehabilitationInstitutionDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addHomonrehabilitationInstitutionDivisionRadioItem2();
    }
    return homonrehabilitationInstitutionDivisionRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004004Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getHomonrehabilitationGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonrehabilitationGroup(){

    homonrehabilitationGroup.add(getHomonrehabilitationDiscountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    homonrehabilitationGroup.add(getHomonrehabilitationInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonrehabilitationDiscountContainer(){

    homonrehabilitationDiscountContainer.add(getHomonrehabilitationDiscountRate(), VRLayout.FLOW);

    homonrehabilitationDiscountContainer.add(getHomonrehabilitationPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonrehabilitationDiscountRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonrehabilitationPercentSign(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonrehabilitationInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonrehabilitationInstitutionDivisionRadioModel(){

    getHomonrehabilitationInstitutionDivisionRadioItem1().setButtonIndex(1);
    getHomonrehabilitationInstitutionDivisionRadioModel().add(getHomonrehabilitationInstitutionDivisionRadioItem1());

    getHomonrehabilitationInstitutionDivisionRadioItem2().setButtonIndex(2);
    getHomonrehabilitationInstitutionDivisionRadioModel().add(getHomonrehabilitationInstitutionDivisionRadioItem2());

  }

  /**
   * �a�@�܂��͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonrehabilitationInstitutionDivisionRadioItem1(){

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHomonrehabilitationInstitutionDivisionRadioItem2(){

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
      ACFrame.getInstance().getContentPane().add(new QO004004Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004004Design getThis() {
    return this;
  }
}
