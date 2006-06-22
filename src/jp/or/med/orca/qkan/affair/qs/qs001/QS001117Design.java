
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
 * �쐬��: 2006/04/10  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[��������x�� (QS001117)
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
 * �T�[�r�X�p�^�[��������x����ʍ��ڃf�U�C��(QS001117) 
 */
public class QS001117Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel kaigoSupportPattern;

  private ACClearableRadioButtonGroup kaigoSupportDivisionRadio;

  private ACLabelContainer kaigoSupportDivisionRadioContainer;

  private ACListModelAdapter kaigoSupportDivisionRadioModel;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem1;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem2;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem3;

  private ACRadioButtonItem kaigoSupportDivisionRadioItem4;

  private ACClearableRadioButtonGroup kaigoSupportManagementBasicRadio;

  private ACLabelContainer kaigoSupportManagementBasicRadioContainer;

  private ACListModelAdapter kaigoSupportManagementBasicRadioModel;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem1;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem2;

  private ACRadioButtonItem kaigoSupportManagementBasicRadioItem3;

  private ACClearableRadioButtonGroup kaigoSupportSpecificProviderSubtractionRadio;

  private ACLabelContainer kaigoSupportSpecificProviderSubtractionRadioContainer;

  private ACListModelAdapter kaigoSupportSpecificProviderSubtractionRadioModel;

  private ACRadioButtonItem kaigoSupportSpecificProviderSubtractionRadioItem1;

  private ACRadioButtonItem kaigoSupportSpecificProviderSubtractionRadioItem2;

  private ACClearableRadioButtonGroup kaigoSupportStandardRadio;

  private ACLabelContainer kaigoSupportStandardRadioContainer;

  private ACListModelAdapter kaigoSupportStandardRadioModel;

  private ACRadioButtonItem kaigoSupportStandardRadioItem1;

  private ACRadioButtonItem kaigoSupportStandardRadioItem2;

  private ACRadioButtonItem kaigoSupportStandardRadioItem3;

  private ACClearableRadioButtonGroup kaigoSupportSpecificStandardRadio;

  private ACLabelContainer kaigoSupportSpecificStandardRadioContainer;

  private ACListModelAdapter kaigoSupportSpecificStandardRadioModel;

  private ACRadioButtonItem kaigoSupportSpecificStandardRadioItem1;

  private ACRadioButtonItem kaigoSupportSpecificStandardRadioItem2;

  private ACGroupBox kaigoSupportSpecialMemberContainer;

  private ACTextField kaigoSupportSpecialMemberNumber;

  private ACLabelContainer kaigoSupportSpecialMemberNumberContainer;

  private ACComboBox kaigoSupportSpecialMemberName;

  private ACLabelContainer kaigoSupportSpecialMemberNameContainer;

  private ACComboBoxModelAdapter kaigoSupportSpecialMemberNameModel;

  //getter

  /**
   * ������x���̈���擾���܂��B
   * @return ������x���̈�
   */
  public ACPanel getKaigoSupportPattern(){
    if(kaigoSupportPattern==null){

      kaigoSupportPattern = new ACPanel();

      kaigoSupportPattern.setAutoWrap(false);

      addKaigoSupportPattern();
    }
    return kaigoSupportPattern;

  }

  /**
   * ������x������擾���܂��B
   * @return ������x����
   */
  public ACClearableRadioButtonGroup getKaigoSupportDivisionRadio(){
    if(kaigoSupportDivisionRadio==null){

      kaigoSupportDivisionRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportDivisionRadioContainer().setText("������x����");

      kaigoSupportDivisionRadio.setBindPath("1430103");

      kaigoSupportDivisionRadio.setUseClearButton(false);

      kaigoSupportDivisionRadio.setModel(getKaigoSupportDivisionRadioModel());

      addKaigoSupportDivisionRadio();
    }
    return kaigoSupportDivisionRadio;

  }

  /**
   * ������x����R���e�i���擾���܂��B
   * @return ������x����R���e�i
   */
  protected ACLabelContainer getKaigoSupportDivisionRadioContainer(){
    if(kaigoSupportDivisionRadioContainer==null){
      kaigoSupportDivisionRadioContainer = new ACLabelContainer();
      kaigoSupportDivisionRadioContainer.setFollowChildEnabled(true);
      kaigoSupportDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportDivisionRadioContainer.add(getKaigoSupportDivisionRadio(), null);
    }
    return kaigoSupportDivisionRadioContainer;
  }

  /**
   * ������x����f�����擾���܂��B
   * @return ������x����f��
   */
  protected ACListModelAdapter getKaigoSupportDivisionRadioModel(){
    if(kaigoSupportDivisionRadioModel==null){
      kaigoSupportDivisionRadioModel = new ACListModelAdapter();
      addKaigoSupportDivisionRadioModel();
    }
    return kaigoSupportDivisionRadioModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem1(){
    if(kaigoSupportDivisionRadioItem1==null){

      kaigoSupportDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem1.setText("I�^");

      kaigoSupportDivisionRadioItem1.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportDivisionRadioItem1();
    }
    return kaigoSupportDivisionRadioItem1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem2(){
    if(kaigoSupportDivisionRadioItem2==null){

      kaigoSupportDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem2.setText("II�^");

      kaigoSupportDivisionRadioItem2.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportDivisionRadioItem2();
    }
    return kaigoSupportDivisionRadioItem2;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem3(){
    if(kaigoSupportDivisionRadioItem3==null){

      kaigoSupportDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem3.setText("III�^");

      kaigoSupportDivisionRadioItem3.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportDivisionRadioItem3();
    }
    return kaigoSupportDivisionRadioItem3;

  }

  /**
   * �o�ߓI�v�����擾���܂��B
   * @return �o�ߓI�v���
   */
  public ACRadioButtonItem getKaigoSupportDivisionRadioItem4(){
    if(kaigoSupportDivisionRadioItem4==null){

      kaigoSupportDivisionRadioItem4 = new ACRadioButtonItem();

      kaigoSupportDivisionRadioItem4.setText("�o�ߓI�v���");

      kaigoSupportDivisionRadioItem4.setGroup(getKaigoSupportDivisionRadio());

      kaigoSupportDivisionRadioItem4.setConstraints(VRLayout.FLOW);

      addKaigoSupportDivisionRadioItem4();
    }
    return kaigoSupportDivisionRadioItem4;

  }

  /**
   * �^�c����Z���擾���܂��B
   * @return �^�c����Z
   */
  public ACClearableRadioButtonGroup getKaigoSupportManagementBasicRadio(){
    if(kaigoSupportManagementBasicRadio==null){

      kaigoSupportManagementBasicRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportManagementBasicRadioContainer().setText("�^�c����Z");

      kaigoSupportManagementBasicRadio.setBindPath("1430101");

      kaigoSupportManagementBasicRadio.setUseClearButton(false);

      kaigoSupportManagementBasicRadio.setModel(getKaigoSupportManagementBasicRadioModel());

      addKaigoSupportManagementBasicRadio();
    }
    return kaigoSupportManagementBasicRadio;

  }

  /**
   * �^�c����Z�R���e�i���擾���܂��B
   * @return �^�c����Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportManagementBasicRadioContainer(){
    if(kaigoSupportManagementBasicRadioContainer==null){
      kaigoSupportManagementBasicRadioContainer = new ACLabelContainer();
      kaigoSupportManagementBasicRadioContainer.setFollowChildEnabled(true);
      kaigoSupportManagementBasicRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportManagementBasicRadioContainer.add(getKaigoSupportManagementBasicRadio(), null);
    }
    return kaigoSupportManagementBasicRadioContainer;
  }

  /**
   * �^�c����Z���f�����擾���܂��B
   * @return �^�c����Z���f��
   */
  protected ACListModelAdapter getKaigoSupportManagementBasicRadioModel(){
    if(kaigoSupportManagementBasicRadioModel==null){
      kaigoSupportManagementBasicRadioModel = new ACListModelAdapter();
      addKaigoSupportManagementBasicRadioModel();
    }
    return kaigoSupportManagementBasicRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem1(){
    if(kaigoSupportManagementBasicRadioItem1==null){

      kaigoSupportManagementBasicRadioItem1 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem1.setText("�Ȃ�");

      kaigoSupportManagementBasicRadioItem1.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportManagementBasicRadioItem1();
    }
    return kaigoSupportManagementBasicRadioItem1;

  }

  /**
   * ���Z�v���Y�����擾���܂��B
   * @return ���Z�v���Y��
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem2(){
    if(kaigoSupportManagementBasicRadioItem2==null){

      kaigoSupportManagementBasicRadioItem2 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem2.setText("I�^");

      kaigoSupportManagementBasicRadioItem2.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addKaigoSupportManagementBasicRadioItem2();
    }
    return kaigoSupportManagementBasicRadioItem2;

  }

  /**
   * ���Z�v���Y����2�����ȏ���擾���܂��B
   * @return ���Z�v���Y����2�����ȏ�
   */
  public ACRadioButtonItem getKaigoSupportManagementBasicRadioItem3(){
    if(kaigoSupportManagementBasicRadioItem3==null){

      kaigoSupportManagementBasicRadioItem3 = new ACRadioButtonItem();

      kaigoSupportManagementBasicRadioItem3.setText("II�^(I�^�̌��Z��2�����ȏ�p��)");

      kaigoSupportManagementBasicRadioItem3.setGroup(getKaigoSupportManagementBasicRadio());

      kaigoSupportManagementBasicRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoSupportManagementBasicRadioItem3();
    }
    return kaigoSupportManagementBasicRadioItem3;

  }

  /**
   * ���莖�Ə��W�����Z���擾���܂��B
   * @return ���莖�Ə��W�����Z
   */
  public ACClearableRadioButtonGroup getKaigoSupportSpecificProviderSubtractionRadio(){
    if(kaigoSupportSpecificProviderSubtractionRadio==null){

      kaigoSupportSpecificProviderSubtractionRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportSpecificProviderSubtractionRadioContainer().setText("���莖�Ə��W�����Z");

      kaigoSupportSpecificProviderSubtractionRadio.setBindPath("1430104");

      kaigoSupportSpecificProviderSubtractionRadio.setUseClearButton(false);

      kaigoSupportSpecificProviderSubtractionRadio.setModel(getKaigoSupportSpecificProviderSubtractionRadioModel());

      addKaigoSupportSpecificProviderSubtractionRadio();
    }
    return kaigoSupportSpecificProviderSubtractionRadio;

  }

  /**
   * ���莖�Ə��W�����Z�R���e�i���擾���܂��B
   * @return ���莖�Ə��W�����Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecificProviderSubtractionRadioContainer(){
    if(kaigoSupportSpecificProviderSubtractionRadioContainer==null){
      kaigoSupportSpecificProviderSubtractionRadioContainer = new ACLabelContainer();
      kaigoSupportSpecificProviderSubtractionRadioContainer.setFollowChildEnabled(true);
      kaigoSupportSpecificProviderSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecificProviderSubtractionRadioContainer.add(getKaigoSupportSpecificProviderSubtractionRadio(), null);
    }
    return kaigoSupportSpecificProviderSubtractionRadioContainer;
  }

  /**
   * ���莖�Ə��W�����Z���f�����擾���܂��B
   * @return ���莖�Ə��W�����Z���f��
   */
  protected ACListModelAdapter getKaigoSupportSpecificProviderSubtractionRadioModel(){
    if(kaigoSupportSpecificProviderSubtractionRadioModel==null){
      kaigoSupportSpecificProviderSubtractionRadioModel = new ACListModelAdapter();
      addKaigoSupportSpecificProviderSubtractionRadioModel();
    }
    return kaigoSupportSpecificProviderSubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoSupportSpecificProviderSubtractionRadioItem1(){
    if(kaigoSupportSpecificProviderSubtractionRadioItem1==null){

      kaigoSupportSpecificProviderSubtractionRadioItem1 = new ACRadioButtonItem();

      kaigoSupportSpecificProviderSubtractionRadioItem1.setText("�Ȃ�");

      kaigoSupportSpecificProviderSubtractionRadioItem1.setGroup(getKaigoSupportSpecificProviderSubtractionRadio());

      kaigoSupportSpecificProviderSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificProviderSubtractionRadioItem1();
    }
    return kaigoSupportSpecificProviderSubtractionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoSupportSpecificProviderSubtractionRadioItem2(){
    if(kaigoSupportSpecificProviderSubtractionRadioItem2==null){

      kaigoSupportSpecificProviderSubtractionRadioItem2 = new ACRadioButtonItem();

      kaigoSupportSpecificProviderSubtractionRadioItem2.setText("����");

      kaigoSupportSpecificProviderSubtractionRadioItem2.setGroup(getKaigoSupportSpecificProviderSubtractionRadio());

      kaigoSupportSpecificProviderSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificProviderSubtractionRadioItem2();
    }
    return kaigoSupportSpecificProviderSubtractionRadioItem2;

  }

  /**
   * ������Z���擾���܂��B
   * @return ������Z
   */
  public ACClearableRadioButtonGroup getKaigoSupportStandardRadio(){
    if(kaigoSupportStandardRadio==null){

      kaigoSupportStandardRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportStandardRadioContainer().setText("������Z");

      kaigoSupportStandardRadio.setBindPath("1430105");

      kaigoSupportStandardRadio.setUseClearButton(false);

      kaigoSupportStandardRadio.setModel(getKaigoSupportStandardRadioModel());

      addKaigoSupportStandardRadio();
    }
    return kaigoSupportStandardRadio;

  }

  /**
   * ������Z�R���e�i���擾���܂��B
   * @return ������Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportStandardRadioContainer(){
    if(kaigoSupportStandardRadioContainer==null){
      kaigoSupportStandardRadioContainer = new ACLabelContainer();
      kaigoSupportStandardRadioContainer.setFollowChildEnabled(true);
      kaigoSupportStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportStandardRadioContainer.add(getKaigoSupportStandardRadio(), null);
    }
    return kaigoSupportStandardRadioContainer;
  }

  /**
   * ������Z���f�����擾���܂��B
   * @return ������Z���f��
   */
  protected ACListModelAdapter getKaigoSupportStandardRadioModel(){
    if(kaigoSupportStandardRadioModel==null){
      kaigoSupportStandardRadioModel = new ACListModelAdapter();
      addKaigoSupportStandardRadioModel();
    }
    return kaigoSupportStandardRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoSupportStandardRadioItem1(){
    if(kaigoSupportStandardRadioItem1==null){

      kaigoSupportStandardRadioItem1 = new ACRadioButtonItem();

      kaigoSupportStandardRadioItem1.setText("�Ȃ�");

      kaigoSupportStandardRadioItem1.setGroup(getKaigoSupportStandardRadio());

      kaigoSupportStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportStandardRadioItem1();
    }
    return kaigoSupportStandardRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoSupportStandardRadioItem2(){
    if(kaigoSupportStandardRadioItem2==null){

      kaigoSupportStandardRadioItem2 = new ACRadioButtonItem();

      kaigoSupportStandardRadioItem2.setText("����");

      kaigoSupportStandardRadioItem2.setGroup(getKaigoSupportStandardRadio());

      kaigoSupportStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportStandardRadioItem2();
    }
    return kaigoSupportStandardRadioItem2;

  }

  /**
   * �މ@�E�ޏ������擾���܂��B
   * @return �މ@�E�ޏ���
   */
  public ACRadioButtonItem getKaigoSupportStandardRadioItem3(){
    if(kaigoSupportStandardRadioItem3==null){

      kaigoSupportStandardRadioItem3 = new ACRadioButtonItem();

      kaigoSupportStandardRadioItem3.setText("�މ@�E�ޏ���");

      kaigoSupportStandardRadioItem3.setGroup(getKaigoSupportStandardRadio());

      kaigoSupportStandardRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoSupportStandardRadioItem3();
    }
    return kaigoSupportStandardRadioItem3;

  }

  /**
   * ���莖�Ə����Z���擾���܂��B
   * @return ���莖�Ə����Z
   */
  public ACClearableRadioButtonGroup getKaigoSupportSpecificStandardRadio(){
    if(kaigoSupportSpecificStandardRadio==null){

      kaigoSupportSpecificStandardRadio = new ACClearableRadioButtonGroup();

      getKaigoSupportSpecificStandardRadioContainer().setText("���莖�Ə����Z");

      kaigoSupportSpecificStandardRadio.setBindPath("1430106");

      kaigoSupportSpecificStandardRadio.setUseClearButton(false);

      kaigoSupportSpecificStandardRadio.setModel(getKaigoSupportSpecificStandardRadioModel());

      addKaigoSupportSpecificStandardRadio();
    }
    return kaigoSupportSpecificStandardRadio;

  }

  /**
   * ���莖�Ə����Z�R���e�i���擾���܂��B
   * @return ���莖�Ə����Z�R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecificStandardRadioContainer(){
    if(kaigoSupportSpecificStandardRadioContainer==null){
      kaigoSupportSpecificStandardRadioContainer = new ACLabelContainer();
      kaigoSupportSpecificStandardRadioContainer.setFollowChildEnabled(true);
      kaigoSupportSpecificStandardRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecificStandardRadioContainer.add(getKaigoSupportSpecificStandardRadio(), null);
    }
    return kaigoSupportSpecificStandardRadioContainer;
  }

  /**
   * ���莖�Ə����Z���f�����擾���܂��B
   * @return ���莖�Ə����Z���f��
   */
  protected ACListModelAdapter getKaigoSupportSpecificStandardRadioModel(){
    if(kaigoSupportSpecificStandardRadioModel==null){
      kaigoSupportSpecificStandardRadioModel = new ACListModelAdapter();
      addKaigoSupportSpecificStandardRadioModel();
    }
    return kaigoSupportSpecificStandardRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKaigoSupportSpecificStandardRadioItem1(){
    if(kaigoSupportSpecificStandardRadioItem1==null){

      kaigoSupportSpecificStandardRadioItem1 = new ACRadioButtonItem();

      kaigoSupportSpecificStandardRadioItem1.setText("�Ȃ�");

      kaigoSupportSpecificStandardRadioItem1.setGroup(getKaigoSupportSpecificStandardRadio());

      kaigoSupportSpecificStandardRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificStandardRadioItem1();
    }
    return kaigoSupportSpecificStandardRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKaigoSupportSpecificStandardRadioItem2(){
    if(kaigoSupportSpecificStandardRadioItem2==null){

      kaigoSupportSpecificStandardRadioItem2 = new ACRadioButtonItem();

      kaigoSupportSpecificStandardRadioItem2.setText("����");

      kaigoSupportSpecificStandardRadioItem2.setGroup(getKaigoSupportSpecificStandardRadio());

      kaigoSupportSpecificStandardRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoSupportSpecificStandardRadioItem2();
    }
    return kaigoSupportSpecificStandardRadioItem2;

  }

  /**
   * ���x�������R���e�i���擾���܂��B
   * @return ���x�������R���e�i
   */
  public ACGroupBox getKaigoSupportSpecialMemberContainer(){
    if(kaigoSupportSpecialMemberContainer==null){

      kaigoSupportSpecialMemberContainer = new ACGroupBox();

      kaigoSupportSpecialMemberContainer.setText("���x���������");

      addKaigoSupportSpecialMemberContainer();
    }
    return kaigoSupportSpecialMemberContainer;

  }

  /**
   * ���x�������ԍ����擾���܂��B
   * @return ���x�������ԍ�
   */
  public ACTextField getKaigoSupportSpecialMemberNumber(){
    if(kaigoSupportSpecialMemberNumber==null){

      kaigoSupportSpecialMemberNumber = new ACTextField();

      getKaigoSupportSpecialMemberNumberContainer().setText("���x�������ԍ�");

      kaigoSupportSpecialMemberNumber.setBindPath("1430107");

      kaigoSupportSpecialMemberNumber.setColumns(6);

      kaigoSupportSpecialMemberNumber.setCharType(VRCharType.ONLY_DIGIT);

      kaigoSupportSpecialMemberNumber.setMaxLength(8);

      addKaigoSupportSpecialMemberNumber();
    }
    return kaigoSupportSpecialMemberNumber;

  }

  /**
   * ���x�������ԍ��R���e�i���擾���܂��B
   * @return ���x�������ԍ��R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNumberContainer(){
    if(kaigoSupportSpecialMemberNumberContainer==null){
      kaigoSupportSpecialMemberNumberContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNumberContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNumberContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNumberContainer.add(getKaigoSupportSpecialMemberNumber(), null);
    }
    return kaigoSupportSpecialMemberNumberContainer;
  }

  /**
   * ���x�������������擾���܂��B
   * @return ���x����������
   */
  public ACComboBox getKaigoSupportSpecialMemberName(){
    if(kaigoSupportSpecialMemberName==null){

      kaigoSupportSpecialMemberName = new ACComboBox();

      getKaigoSupportSpecialMemberNameContainer().setText("���x����������");

      kaigoSupportSpecialMemberName.setEditable(false);

      kaigoSupportSpecialMemberName.setRenderBindPath("STAFF_NAME");

      kaigoSupportSpecialMemberName.setMaxLength(10);

      kaigoSupportSpecialMemberName.setModel(getKaigoSupportSpecialMemberNameModel());

      addKaigoSupportSpecialMemberName();
    }
    return kaigoSupportSpecialMemberName;

  }

  /**
   * ���x�����������R���e�i���擾���܂��B
   * @return ���x�����������R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNameContainer(){
    if(kaigoSupportSpecialMemberNameContainer==null){
      kaigoSupportSpecialMemberNameContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNameContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNameContainer.add(getKaigoSupportSpecialMemberName(), null);
    }
    return kaigoSupportSpecialMemberNameContainer;
  }

  /**
   * ���x�������������f�����擾���܂��B
   * @return ���x�������������f��
   */
  protected ACComboBoxModelAdapter getKaigoSupportSpecialMemberNameModel(){
    if(kaigoSupportSpecialMemberNameModel==null){
      kaigoSupportSpecialMemberNameModel = new ACComboBoxModelAdapter();
      addKaigoSupportSpecialMemberNameModel();
    }
    return kaigoSupportSpecialMemberNameModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001117Design() {

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

    this.add(getKaigoSupportPattern(), VRLayout.CLIENT);

  }

  /**
   * ������x���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportPattern(){

    kaigoSupportPattern.add(getKaigoSupportDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportManagementBasicRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportSpecificProviderSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportSpecificStandardRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportPattern.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW);

  }

  /**
   * ������x����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadio(){

  }

  /**
   * ������x����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadioModel(){

    getKaigoSupportDivisionRadioItem1().setButtonIndex(1);
    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem1());

    getKaigoSupportDivisionRadioItem2().setButtonIndex(2);
    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem2());

    getKaigoSupportDivisionRadioItem3().setButtonIndex(3);
    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem3());

    getKaigoSupportDivisionRadioItem4().setButtonIndex(4);
    getKaigoSupportDivisionRadioModel().add(getKaigoSupportDivisionRadioItem4());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadioItem1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadioItem2(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadioItem3(){

  }

  /**
   * �o�ߓI�v���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportDivisionRadioItem4(){

  }

  /**
   * �^�c����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadio(){

  }

  /**
   * �^�c����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadioModel(){

    getKaigoSupportManagementBasicRadioItem1().setButtonIndex(1);
    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem1());

    getKaigoSupportManagementBasicRadioItem2().setButtonIndex(2);
    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem2());

    getKaigoSupportManagementBasicRadioItem3().setButtonIndex(3);
    getKaigoSupportManagementBasicRadioModel().add(getKaigoSupportManagementBasicRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadioItem1(){

  }

  /**
   * ���Z�v���Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadioItem2(){

  }

  /**
   * ���Z�v���Y����2�����ȏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportManagementBasicRadioItem3(){

  }

  /**
   * ���莖�Ə��W�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadio(){

  }

  /**
   * ���莖�Ə��W�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioModel(){

    getKaigoSupportSpecificProviderSubtractionRadioItem1().setButtonIndex(1);
    getKaigoSupportSpecificProviderSubtractionRadioModel().add(getKaigoSupportSpecificProviderSubtractionRadioItem1());

    getKaigoSupportSpecificProviderSubtractionRadioItem2().setButtonIndex(2);
    getKaigoSupportSpecificProviderSubtractionRadioModel().add(getKaigoSupportSpecificProviderSubtractionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificProviderSubtractionRadioItem2(){

  }

  /**
   * ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportStandardRadio(){

  }

  /**
   * ������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportStandardRadioModel(){

    getKaigoSupportStandardRadioItem1().setButtonIndex(1);
    getKaigoSupportStandardRadioModel().add(getKaigoSupportStandardRadioItem1());

    getKaigoSupportStandardRadioItem2().setButtonIndex(2);
    getKaigoSupportStandardRadioModel().add(getKaigoSupportStandardRadioItem2());

    getKaigoSupportStandardRadioItem3().setButtonIndex(3);
    getKaigoSupportStandardRadioModel().add(getKaigoSupportStandardRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportStandardRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportStandardRadioItem2(){

  }

  /**
   * �މ@�E�ޏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportStandardRadioItem3(){

  }

  /**
   * ���莖�Ə����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificStandardRadio(){

  }

  /**
   * ���莖�Ə����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificStandardRadioModel(){

    getKaigoSupportSpecificStandardRadioItem1().setButtonIndex(1);
    getKaigoSupportSpecificStandardRadioModel().add(getKaigoSupportSpecificStandardRadioItem1());

    getKaigoSupportSpecificStandardRadioItem2().setButtonIndex(2);
    getKaigoSupportSpecificStandardRadioModel().add(getKaigoSupportSpecificStandardRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificStandardRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecificStandardRadioItem2(){

  }

  /**
   * ���x�������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberContainer(){

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNumberContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberNumber(){

  }

  /**
   * ���x�����������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberName(){

  }

  /**
   * ���x�������������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberNameModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001117Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001117Design getThis() {
    return this;
  }
}
