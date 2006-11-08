
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
 * �쐬��: 2006/03/05  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ������x�� (QO004117)
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
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.text.*;
/**
 * ������x����ʍ��ڃf�U�C��(QO004117) 
 */
public class QO004117Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACClearableRadioButtonGroup specificProviderAdd;

  private ACLabelContainer specificProviderAddContainer;

  private ACListModelAdapter specificProviderAddModel;

  private ACRadioButtonItem specificProviderAddItem1;

  private ACRadioButtonItem specificProviderAddItem2;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("������x��");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * ����̐��������Ə����Z�̗L�����擾���܂��B
   * @return ����̐��������Ə����Z�̗L��
   */
  public ACClearableRadioButtonGroup getSpecificProviderAdd(){
    if(specificProviderAdd==null){

      specificProviderAdd = new ACClearableRadioButtonGroup();

      getSpecificProviderAddContainer().setText("����̐��������Ə����Z�̗L��");

      specificProviderAdd.setBindPath("1430103");

      specificProviderAdd.setModel(getSpecificProviderAddModel());

      specificProviderAdd.setUseClearButton(false);

      addSpecificProviderAdd();
    }
    return specificProviderAdd;

  }

  /**
   * ����̐��������Ə����Z�̗L���R���e�i���擾���܂��B
   * @return ����̐��������Ə����Z�̗L���R���e�i
   */
  protected ACLabelContainer getSpecificProviderAddContainer(){
    if(specificProviderAddContainer==null){
      specificProviderAddContainer = new ACLabelContainer();
      specificProviderAddContainer.setFollowChildEnabled(true);
      specificProviderAddContainer.setVAlignment(VRLayout.CENTER);
      specificProviderAddContainer.add(getSpecificProviderAdd(), null);
    }
    return specificProviderAddContainer;
  }

  /**
   * ����̐��������Ə����Z�̗L�����f�����擾���܂��B
   * @return ����̐��������Ə����Z�̗L�����f��
   */
  protected ACListModelAdapter getSpecificProviderAddModel(){
    if(specificProviderAddModel==null){
      specificProviderAddModel = new ACListModelAdapter();
      addSpecificProviderAddModel();
    }
    return specificProviderAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSpecificProviderAddItem1(){
    if(specificProviderAddItem1==null){

      specificProviderAddItem1 = new ACRadioButtonItem();

      specificProviderAddItem1.setText("�Ȃ�");

      specificProviderAddItem1.setGroup(getSpecificProviderAdd());

      specificProviderAddItem1.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem1();
    }
    return specificProviderAddItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSpecificProviderAddItem2(){
    if(specificProviderAddItem2==null){

      specificProviderAddItem2 = new ACRadioButtonItem();

      specificProviderAddItem2.setText("����");

      specificProviderAddItem2.setGroup(getSpecificProviderAdd());

      specificProviderAddItem2.setConstraints(VRLayout.FLOW);

      addSpecificProviderAddItem2();
    }
    return specificProviderAddItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004117Design() {

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

    this.add(getMainGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainGroup(){

    mainGroup.add(getSpecificProviderAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ����̐��������Ə����Z�̗L���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAdd(){

  }

  /**
   * ����̐��������Ə����Z�̗L�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddModel(){

    getSpecificProviderAddItem1().setButtonIndex(1);
    getSpecificProviderAddModel().add(getSpecificProviderAddItem1());

    getSpecificProviderAddItem2().setButtonIndex(2);
    getSpecificProviderAddModel().add(getSpecificProviderAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecificProviderAddItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004117Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004117Design getThis() {
    return this;
  }
}
