
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
 * �쐬��: 2006/04/19  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�i��Áj (QS001006)
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
 * �T�[�r�X�p�^�[���K��Ō�i��Áj��ʍ��ڃf�U�C��(QS001006) 
 */
public class QS001006Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane tabs;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup houmonKangoIryoBasicChargeDivision;

  private ACLabelContainer houmonKangoIryoBasicChargeDivisionContainer;

  private ACListModelAdapter houmonKangoIryoBasicChargeDivisionModel;

  private ACRadioButtonItem houmonKangoIryoBasicChargeDivision1;

  private ACRadioButtonItem houmonKangoIryoBasicChargeDivision2;

  private ACClearableRadioButtonGroup houmonKangoIryoClass;

  private ACLabelContainer houmonKangoIryoClassContainer;

  private ACListModelAdapter houmonKangoIryoClassModel;

  private ACRadioButtonItem houmonKangoIryoClass1;

  private ACRadioButtonItem houmonKangoIryoClass2;

  private ACClearableRadioButtonGroup houmonKangoIryoIntractableDiseaseRadio;

  private ACLabelContainer houmonKangoIryoIntractableDiseaseRadioContainer;

  private ACListModelAdapter houmonKangoIryoIntractableDiseaseRadioModel;

  private ACRadioButtonItem houmonKangoIryoIntractableDiseaseRadioItem1;

  private ACRadioButtonItem houmonKangoIryoIntractableDiseaseRadioItem2;

  private ACLabelContainer houmonKangoIryoExtensionTimeContena;

  private ACTextField houmonKangoIryoExtensionTimeText;

  private ACLabel houmonKangoIryoExtensionTimeLabel;

  private ACClearableRadioButtonGroup houmonKangoIryoGuidanceRadio;

  private ACLabelContainer houmonKangoIryoGuidanceRadioContainer;

  private ACListModelAdapter houmonKangoIryoGuidanceRadioModel;

  private ACRadioButtonItem houmonKangoIryoGuidanceRadioItem1;

  private ACRadioButtonItem houmonKangoIryoGuidanceRadioItem2;

  private ACRadioButtonItem houmonKangoIryoGuidanceRadioItem3;

  private ACClearableRadioButtonGroup houmonKangoIryo24HoureRadio;

  private ACLabelContainer houmonKangoIryo24HoureRadioContainer;

  private ACListModelAdapter houmonKangoIryo24HoureRadioModel;

  private ACRadioButtonItem houmonKangoIryo24HoureRadioItem1;

  private ACRadioButtonItem houmonKangoIryo24HoureRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoIryoSeriousIllnessRadio;

  private ACLabelContainer houmonKangoIryoSeriousIllnessRadioContainer;

  private ACListModelAdapter houmonKangoIryoSeriousIllnessRadioModel;

  private ACRadioButtonItem houmonKangoIryoSeriousIllnessRadioItem1;

  private ACRadioButtonItem houmonKangoIryoSeriousIllnessRadioItem2;

  private ACRadioButtonItem houmonKangoIryoSeriousIllnessRadioItem3;

  private ACClearableRadioButtonGroup houmonKangoIryoInfoRadio;

  private ACLabelContainer houmonKangoIryoInfoRadioContainer;

  private ACListModelAdapter houmonKangoIryoInfoRadioModel;

  private ACRadioButtonItem houmonKangoIryoInfoRadioItem1;

  private ACRadioButtonItem houmonKangoIryoInfoRadioItem2;

  private ACPanel tab2;

  private ACClearableRadioButtonGroup houmonKangoIryoTerminalRadio;

  private ACLabelContainer houmonKangoIryoTerminalRadioContainer;

  private ACListModelAdapter houmonKangoIryoTerminalRadioModel;

  private ACRadioButtonItem houmonKangoIryoTerminalRadioItem1;

  private ACRadioButtonItem houmonKangoIryoTerminalRadioItem2;

  private ACRadioButtonItem houmonKangoIryoTerminalRadioItem3;

  private ACClearableRadioButtonGroup houmonKangoIryoEmergencyVisitNursingRadio;

  private ACLabelContainer houmonKangoIryoEmergencyVisitNursingRadioContainer;

  private ACListModelAdapter houmonKangoIryoEmergencyVisitNursingRadioModel;

  private ACRadioButtonItem houmonKangoIryoEmergencyVisitNursingRadioItem1;

  private ACRadioButtonItem houmonKangoIryoEmergencyVisitNursingRadioItem2;

  private ACBackLabelContainer houmonKangoIryoTimeContena;

  private ACTimeComboBox houmonKangoIryoBeginTime;

  private ACLabelContainer houmonKangoIryoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKangoIryoBeginTimeModel;

  private ACTimeComboBox houmonKangoIryoEndTime;

  private ACLabelContainer houmonKangoIryoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKangoIryoEndTimeModel;

  //getter

  /**
   * �^�u�y�C�����擾���܂��B
   * @return �^�u�y�C��
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * �^�u1���擾���܂��B
   * @return �^�u1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setHgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * ��{�×{��敪���擾���܂��B
   * @return ��{�×{��敪
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoBasicChargeDivision(){
    if(houmonKangoIryoBasicChargeDivision==null){

      houmonKangoIryoBasicChargeDivision = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoBasicChargeDivisionContainer().setText("��{�×{��敪");

      houmonKangoIryoBasicChargeDivision.setBindPath("2010103");

      houmonKangoIryoBasicChargeDivision.setUseClearButton(false);

      houmonKangoIryoBasicChargeDivision.setModel(getHoumonKangoIryoBasicChargeDivisionModel());

      addHoumonKangoIryoBasicChargeDivision();
    }
    return houmonKangoIryoBasicChargeDivision;

  }

  /**
   * ��{�×{��敪�R���e�i���擾���܂��B
   * @return ��{�×{��敪�R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryoBasicChargeDivisionContainer(){
    if(houmonKangoIryoBasicChargeDivisionContainer==null){
      houmonKangoIryoBasicChargeDivisionContainer = new ACLabelContainer();
      houmonKangoIryoBasicChargeDivisionContainer.setFollowChildEnabled(true);
      houmonKangoIryoBasicChargeDivisionContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoBasicChargeDivisionContainer.add(getHoumonKangoIryoBasicChargeDivision(), null);
    }
    return houmonKangoIryoBasicChargeDivisionContainer;
  }

  /**
   * ��{�×{��敪���f�����擾���܂��B
   * @return ��{�×{��敪���f��
   */
  protected ACListModelAdapter getHoumonKangoIryoBasicChargeDivisionModel(){
    if(houmonKangoIryoBasicChargeDivisionModel==null){
      houmonKangoIryoBasicChargeDivisionModel = new ACListModelAdapter();
      addHoumonKangoIryoBasicChargeDivisionModel();
    }
    return houmonKangoIryoBasicChargeDivisionModel;
  }

  /**
   * ��{�×{��I���擾���܂��B
   * @return ��{�×{��I
   */
  public ACRadioButtonItem getHoumonKangoIryoBasicChargeDivision1(){
    if(houmonKangoIryoBasicChargeDivision1==null){

      houmonKangoIryoBasicChargeDivision1 = new ACRadioButtonItem();

      houmonKangoIryoBasicChargeDivision1.setText("��{�×{��I");

      houmonKangoIryoBasicChargeDivision1.setGroup(getHoumonKangoIryoBasicChargeDivision());

      addHoumonKangoIryoBasicChargeDivision1();
    }
    return houmonKangoIryoBasicChargeDivision1;

  }

  /**
   * ��{�×{��II���擾���܂��B
   * @return ��{�×{��II
   */
  public ACRadioButtonItem getHoumonKangoIryoBasicChargeDivision2(){
    if(houmonKangoIryoBasicChargeDivision2==null){

      houmonKangoIryoBasicChargeDivision2 = new ACRadioButtonItem();

      houmonKangoIryoBasicChargeDivision2.setText("��{�×{��II");

      houmonKangoIryoBasicChargeDivision2.setGroup(getHoumonKangoIryoBasicChargeDivision());

      addHoumonKangoIryoBasicChargeDivision2();
    }
    return houmonKangoIryoBasicChargeDivision2;

  }

  /**
   * �K��Ō�E���敪���擾���܂��B
   * @return �K��Ō�E���敪
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoClass(){
    if(houmonKangoIryoClass==null){

      houmonKangoIryoClass = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoClassContainer().setText("�E���敪");

      houmonKangoIryoClass.setBindPath("2010104");

      houmonKangoIryoClass.setUseClearButton(false);

      houmonKangoIryoClass.setModel(getHoumonKangoIryoClassModel());

      addHoumonKangoIryoClass();
    }
    return houmonKangoIryoClass;

  }

  /**
   * �K��Ō�E���敪�R���e�i���擾���܂��B
   * @return �K��Ō�E���敪�R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryoClassContainer(){
    if(houmonKangoIryoClassContainer==null){
      houmonKangoIryoClassContainer = new ACLabelContainer();
      houmonKangoIryoClassContainer.setFollowChildEnabled(true);
      houmonKangoIryoClassContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoClassContainer.add(getHoumonKangoIryoClass(), null);
    }
    return houmonKangoIryoClassContainer;
  }

  /**
   * �K��Ō�E���敪���f�����擾���܂��B
   * @return �K��Ō�E���敪���f��
   */
  protected ACListModelAdapter getHoumonKangoIryoClassModel(){
    if(houmonKangoIryoClassModel==null){
      houmonKangoIryoClassModel = new ACListModelAdapter();
      addHoumonKangoIryoClassModel();
    }
    return houmonKangoIryoClassModel;
  }

  /**
   * ���œ����擾���܂��B
   * @return ���œ�
   */
  public ACRadioButtonItem getHoumonKangoIryoClass1(){
    if(houmonKangoIryoClass1==null){

      houmonKangoIryoClass1 = new ACRadioButtonItem();

      houmonKangoIryoClass1.setText("���œ�");

      houmonKangoIryoClass1.setGroup(getHoumonKangoIryoClass());

      addHoumonKangoIryoClass1();
    }
    return houmonKangoIryoClass1;

  }

  /**
   * �y�ł��擾���܂��B
   * @return �y��
   */
  public ACRadioButtonItem getHoumonKangoIryoClass2(){
    if(houmonKangoIryoClass2==null){

      houmonKangoIryoClass2 = new ACRadioButtonItem();

      houmonKangoIryoClass2.setText("�y��");

      houmonKangoIryoClass2.setGroup(getHoumonKangoIryoClass());

      addHoumonKangoIryoClass2();
    }
    return houmonKangoIryoClass2;

  }

  /**
   * ��a�������񐔖K����Z���擾���܂��B
   * @return ��a�������񐔖K����Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoIntractableDiseaseRadio(){
    if(houmonKangoIryoIntractableDiseaseRadio==null){

      houmonKangoIryoIntractableDiseaseRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoIntractableDiseaseRadioContainer().setText("��a�������񐔖K����Z");

      houmonKangoIryoIntractableDiseaseRadio.setBindPath("2010105");

      houmonKangoIryoIntractableDiseaseRadio.setUseClearButton(false);

      houmonKangoIryoIntractableDiseaseRadio.setModel(getHoumonKangoIryoIntractableDiseaseRadioModel());

      addHoumonKangoIryoIntractableDiseaseRadio();
    }
    return houmonKangoIryoIntractableDiseaseRadio;

  }

  /**
   * ��a�������񐔖K����Z�R���e�i���擾���܂��B
   * @return ��a�������񐔖K����Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryoIntractableDiseaseRadioContainer(){
    if(houmonKangoIryoIntractableDiseaseRadioContainer==null){
      houmonKangoIryoIntractableDiseaseRadioContainer = new ACLabelContainer();
      houmonKangoIryoIntractableDiseaseRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoIntractableDiseaseRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoIntractableDiseaseRadioContainer.add(getHoumonKangoIryoIntractableDiseaseRadio(), null);
    }
    return houmonKangoIryoIntractableDiseaseRadioContainer;
  }

  /**
   * ��a�������񐔖K����Z���f�����擾���܂��B
   * @return ��a�������񐔖K����Z���f��
   */
  protected ACListModelAdapter getHoumonKangoIryoIntractableDiseaseRadioModel(){
    if(houmonKangoIryoIntractableDiseaseRadioModel==null){
      houmonKangoIryoIntractableDiseaseRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoIntractableDiseaseRadioModel();
    }
    return houmonKangoIryoIntractableDiseaseRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoIryoIntractableDiseaseRadioItem1(){
    if(houmonKangoIryoIntractableDiseaseRadioItem1==null){

      houmonKangoIryoIntractableDiseaseRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoIntractableDiseaseRadioItem1.setText("�Ȃ�");

      houmonKangoIryoIntractableDiseaseRadioItem1.setGroup(getHoumonKangoIryoIntractableDiseaseRadio());

      addHoumonKangoIryoIntractableDiseaseRadioItem1();
    }
    return houmonKangoIryoIntractableDiseaseRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoIryoIntractableDiseaseRadioItem2(){
    if(houmonKangoIryoIntractableDiseaseRadioItem2==null){

      houmonKangoIryoIntractableDiseaseRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoIntractableDiseaseRadioItem2.setText("����");

      houmonKangoIryoIntractableDiseaseRadioItem2.setGroup(getHoumonKangoIryoIntractableDiseaseRadio());

      addHoumonKangoIryoIntractableDiseaseRadioItem2();
    }
    return houmonKangoIryoIntractableDiseaseRadioItem2;

  }

  /**
   * �������ԉ��Z�R���e�i���擾���܂��B
   * @return �������ԉ��Z�R���e�i
   */
  public ACLabelContainer getHoumonKangoIryoExtensionTimeContena(){
    if(houmonKangoIryoExtensionTimeContena==null){

      houmonKangoIryoExtensionTimeContena = new ACLabelContainer();

      houmonKangoIryoExtensionTimeContena.setText("�������ԉ��Z");

      houmonKangoIryoExtensionTimeContena.setFollowChildEnabled(false);

      addHoumonKangoIryoExtensionTimeContena();
    }
    return houmonKangoIryoExtensionTimeContena;

  }

  /**
   * �������ԁE�e�L�X�g���擾���܂��B
   * @return �������ԁE�e�L�X�g
   */
  public ACTextField getHoumonKangoIryoExtensionTimeText(){
    if(houmonKangoIryoExtensionTimeText==null){

      houmonKangoIryoExtensionTimeText = new ACTextField();

      houmonKangoIryoExtensionTimeText.setBindPath("2010106");

      houmonKangoIryoExtensionTimeText.setColumns(2);

      houmonKangoIryoExtensionTimeText.setCharType(VRCharType.ONLY_DIGIT);

      houmonKangoIryoExtensionTimeText.setHorizontalAlignment(SwingConstants.RIGHT);

      houmonKangoIryoExtensionTimeText.setIMEMode(InputSubset.LATIN);

      houmonKangoIryoExtensionTimeText.setMaxLength(1);

      addHoumonKangoIryoExtensionTimeText();
    }
    return houmonKangoIryoExtensionTimeText;

  }

  /**
   * �������ԁE���x��2���擾���܂��B
   * @return �������ԁE���x��2
   */
  public ACLabel getHoumonKangoIryoExtensionTimeLabel(){
    if(houmonKangoIryoExtensionTimeLabel==null){

      houmonKangoIryoExtensionTimeLabel = new ACLabel();

      houmonKangoIryoExtensionTimeLabel.setText("����");

      addHoumonKangoIryoExtensionTimeLabel();
    }
    return houmonKangoIryoExtensionTimeLabel;

  }

  /**
   * �n��A�g�މ@�������w�����Z���擾���܂��B
   * @return �n��A�g�މ@�������w�����Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoGuidanceRadio(){
    if(houmonKangoIryoGuidanceRadio==null){

      houmonKangoIryoGuidanceRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoGuidanceRadioContainer().setText("�n��A�g�����w�����Z");

      houmonKangoIryoGuidanceRadio.setBindPath("2010107");

      houmonKangoIryoGuidanceRadio.setUseClearButton(false);

      houmonKangoIryoGuidanceRadio.setModel(getHoumonKangoIryoGuidanceRadioModel());

      addHoumonKangoIryoGuidanceRadio();
    }
    return houmonKangoIryoGuidanceRadio;

  }

  /**
   * �n��A�g�މ@�������w�����Z�R���e�i���擾���܂��B
   * @return �n��A�g�މ@�������w�����Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryoGuidanceRadioContainer(){
    if(houmonKangoIryoGuidanceRadioContainer==null){
      houmonKangoIryoGuidanceRadioContainer = new ACLabelContainer();
      houmonKangoIryoGuidanceRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoGuidanceRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoGuidanceRadioContainer.add(getHoumonKangoIryoGuidanceRadio(), null);
    }
    return houmonKangoIryoGuidanceRadioContainer;
  }

  /**
   * �n��A�g�މ@�������w�����Z���f�����擾���܂��B
   * @return �n��A�g�މ@�������w�����Z���f��
   */
  protected ACListModelAdapter getHoumonKangoIryoGuidanceRadioModel(){
    if(houmonKangoIryoGuidanceRadioModel==null){
      houmonKangoIryoGuidanceRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoGuidanceRadioModel();
    }
    return houmonKangoIryoGuidanceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoIryoGuidanceRadioItem1(){
    if(houmonKangoIryoGuidanceRadioItem1==null){

      houmonKangoIryoGuidanceRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoGuidanceRadioItem1.setText("�Ȃ�");

      houmonKangoIryoGuidanceRadioItem1.setGroup(getHoumonKangoIryoGuidanceRadio());

      houmonKangoIryoGuidanceRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoGuidanceRadioItem1();
    }
    return houmonKangoIryoGuidanceRadioItem1;

  }

  /**
   * �ʏ�̏ꍇ���擾���܂��B
   * @return �ʏ�̏ꍇ
   */
  public ACRadioButtonItem getHoumonKangoIryoGuidanceRadioItem2(){
    if(houmonKangoIryoGuidanceRadioItem2==null){

      houmonKangoIryoGuidanceRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoGuidanceRadioItem2.setText("�ʏ�̏ꍇ");

      houmonKangoIryoGuidanceRadioItem2.setGroup(getHoumonKangoIryoGuidanceRadio());

      houmonKangoIryoGuidanceRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoGuidanceRadioItem2();
    }
    return houmonKangoIryoGuidanceRadioItem2;

  }

  /**
   * �ݑ�×{�x���f�Ï��̕ی���̏ꍇ���擾���܂��B
   * @return �ݑ�×{�x���f�Ï��̕ی���̏ꍇ
   */
  public ACRadioButtonItem getHoumonKangoIryoGuidanceRadioItem3(){
    if(houmonKangoIryoGuidanceRadioItem3==null){

      houmonKangoIryoGuidanceRadioItem3 = new ACRadioButtonItem();

      houmonKangoIryoGuidanceRadioItem3.setText("<html>�ݑ�×{�x���f�Ï���<br>�ی���̏ꍇ</html>");

      houmonKangoIryoGuidanceRadioItem3.setGroup(getHoumonKangoIryoGuidanceRadio());

      houmonKangoIryoGuidanceRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoIryoGuidanceRadioItem3();
    }
    return houmonKangoIryoGuidanceRadioItem3;

  }

  /**
   * 24���ԉ��Z���擾���܂��B
   * @return 24���ԉ��Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryo24HoureRadio(){
    if(houmonKangoIryo24HoureRadio==null){

      houmonKangoIryo24HoureRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryo24HoureRadioContainer().setText("24���ԘA���̐����Z");

      houmonKangoIryo24HoureRadio.setBindPath("2010108");

      houmonKangoIryo24HoureRadio.setUseClearButton(false);

      houmonKangoIryo24HoureRadio.setModel(getHoumonKangoIryo24HoureRadioModel());

      addHoumonKangoIryo24HoureRadio();
    }
    return houmonKangoIryo24HoureRadio;

  }

  /**
   * 24���ԉ��Z�R���e�i���擾���܂��B
   * @return 24���ԉ��Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryo24HoureRadioContainer(){
    if(houmonKangoIryo24HoureRadioContainer==null){
      houmonKangoIryo24HoureRadioContainer = new ACLabelContainer();
      houmonKangoIryo24HoureRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryo24HoureRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryo24HoureRadioContainer.add(getHoumonKangoIryo24HoureRadio(), null);
    }
    return houmonKangoIryo24HoureRadioContainer;
  }

  /**
   * 24���ԉ��Z���f�����擾���܂��B
   * @return 24���ԉ��Z���f��
   */
  protected ACListModelAdapter getHoumonKangoIryo24HoureRadioModel(){
    if(houmonKangoIryo24HoureRadioModel==null){
      houmonKangoIryo24HoureRadioModel = new ACListModelAdapter();
      addHoumonKangoIryo24HoureRadioModel();
    }
    return houmonKangoIryo24HoureRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoIryo24HoureRadioItem1(){
    if(houmonKangoIryo24HoureRadioItem1==null){

      houmonKangoIryo24HoureRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryo24HoureRadioItem1.setText("�Ȃ�");

      houmonKangoIryo24HoureRadioItem1.setGroup(getHoumonKangoIryo24HoureRadio());

      addHoumonKangoIryo24HoureRadioItem1();
    }
    return houmonKangoIryo24HoureRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoIryo24HoureRadioItem2(){
    if(houmonKangoIryo24HoureRadioItem2==null){

      houmonKangoIryo24HoureRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryo24HoureRadioItem2.setText("����");

      houmonKangoIryo24HoureRadioItem2.setGroup(getHoumonKangoIryo24HoureRadio());

      addHoumonKangoIryo24HoureRadioItem2();
    }
    return houmonKangoIryo24HoureRadioItem2;

  }

  /**
   * �d�ǎ҉��Z���擾���܂��B
   * @return �d�ǎ҉��Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoSeriousIllnessRadio(){
    if(houmonKangoIryoSeriousIllnessRadio==null){

      houmonKangoIryoSeriousIllnessRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoSeriousIllnessRadioContainer().setText("�d�ǎҊǗ����Z");

      houmonKangoIryoSeriousIllnessRadio.setBindPath("2010109");

      houmonKangoIryoSeriousIllnessRadio.setUseClearButton(false);

      houmonKangoIryoSeriousIllnessRadio.setModel(getHoumonKangoIryoSeriousIllnessRadioModel());

      addHoumonKangoIryoSeriousIllnessRadio();
    }
    return houmonKangoIryoSeriousIllnessRadio;

  }

  /**
   * �d�ǎ҉��Z�R���e�i���擾���܂��B
   * @return �d�ǎ҉��Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryoSeriousIllnessRadioContainer(){
    if(houmonKangoIryoSeriousIllnessRadioContainer==null){
      houmonKangoIryoSeriousIllnessRadioContainer = new ACLabelContainer();
      houmonKangoIryoSeriousIllnessRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoSeriousIllnessRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoSeriousIllnessRadioContainer.add(getHoumonKangoIryoSeriousIllnessRadio(), null);
    }
    return houmonKangoIryoSeriousIllnessRadioContainer;
  }

  /**
   * �d�ǎ҉��Z���f�����擾���܂��B
   * @return �d�ǎ҉��Z���f��
   */
  protected ACListModelAdapter getHoumonKangoIryoSeriousIllnessRadioModel(){
    if(houmonKangoIryoSeriousIllnessRadioModel==null){
      houmonKangoIryoSeriousIllnessRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoSeriousIllnessRadioModel();
    }
    return houmonKangoIryoSeriousIllnessRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoIryoSeriousIllnessRadioItem1(){
    if(houmonKangoIryoSeriousIllnessRadioItem1==null){

      houmonKangoIryoSeriousIllnessRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoSeriousIllnessRadioItem1.setText("�Ȃ�");

      houmonKangoIryoSeriousIllnessRadioItem1.setGroup(getHoumonKangoIryoSeriousIllnessRadio());

      houmonKangoIryoSeriousIllnessRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoSeriousIllnessRadioItem1();
    }
    return houmonKangoIryoSeriousIllnessRadioItem1;

  }

  /**
   * ���ʂȊǗ���K�v�Ƃ��銳�҂��擾���܂��B
   * @return ���ʂȊǗ���K�v�Ƃ��銳��
   */
  public ACRadioButtonItem getHoumonKangoIryoSeriousIllnessRadioItem2(){
    if(houmonKangoIryoSeriousIllnessRadioItem2==null){

      houmonKangoIryoSeriousIllnessRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoSeriousIllnessRadioItem2.setText("���ʂȊǗ���K�v�Ƃ��銳��");

      houmonKangoIryoSeriousIllnessRadioItem2.setGroup(getHoumonKangoIryoSeriousIllnessRadio());

      houmonKangoIryoSeriousIllnessRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoSeriousIllnessRadioItem2();
    }
    return houmonKangoIryoSeriousIllnessRadioItem2;

  }

  /**
   * �d�Ǔx���̍������҂��擾���܂��B
   * @return �d�Ǔx���̍�������
   */
  public ACRadioButtonItem getHoumonKangoIryoSeriousIllnessRadioItem3(){
    if(houmonKangoIryoSeriousIllnessRadioItem3==null){

      houmonKangoIryoSeriousIllnessRadioItem3 = new ACRadioButtonItem();

      houmonKangoIryoSeriousIllnessRadioItem3.setText("�d�Ǔx���̍�������");

      houmonKangoIryoSeriousIllnessRadioItem3.setGroup(getHoumonKangoIryoSeriousIllnessRadio());

      houmonKangoIryoSeriousIllnessRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoIryoSeriousIllnessRadioItem3();
    }
    return houmonKangoIryoSeriousIllnessRadioItem3;

  }

  /**
   * ���񋟉��Z���擾���܂��B
   * @return ���񋟉��Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoInfoRadio(){
    if(houmonKangoIryoInfoRadio==null){

      houmonKangoIryoInfoRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoInfoRadioContainer().setText("���񋟉��Z");

      houmonKangoIryoInfoRadio.setBindPath("2010110");

      houmonKangoIryoInfoRadio.setUseClearButton(false);

      houmonKangoIryoInfoRadio.setModel(getHoumonKangoIryoInfoRadioModel());

      addHoumonKangoIryoInfoRadio();
    }
    return houmonKangoIryoInfoRadio;

  }

  /**
   * ���񋟉��Z�R���e�i���擾���܂��B
   * @return ���񋟉��Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryoInfoRadioContainer(){
    if(houmonKangoIryoInfoRadioContainer==null){
      houmonKangoIryoInfoRadioContainer = new ACLabelContainer();
      houmonKangoIryoInfoRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoInfoRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoInfoRadioContainer.add(getHoumonKangoIryoInfoRadio(), null);
    }
    return houmonKangoIryoInfoRadioContainer;
  }

  /**
   * ���񋟉��Z���f�����擾���܂��B
   * @return ���񋟉��Z���f��
   */
  protected ACListModelAdapter getHoumonKangoIryoInfoRadioModel(){
    if(houmonKangoIryoInfoRadioModel==null){
      houmonKangoIryoInfoRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoInfoRadioModel();
    }
    return houmonKangoIryoInfoRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoIryoInfoRadioItem1(){
    if(houmonKangoIryoInfoRadioItem1==null){

      houmonKangoIryoInfoRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoInfoRadioItem1.setText("�Ȃ�");

      houmonKangoIryoInfoRadioItem1.setGroup(getHoumonKangoIryoInfoRadio());

      addHoumonKangoIryoInfoRadioItem1();
    }
    return houmonKangoIryoInfoRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoIryoInfoRadioItem2(){
    if(houmonKangoIryoInfoRadioItem2==null){

      houmonKangoIryoInfoRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoInfoRadioItem2.setText("����");

      houmonKangoIryoInfoRadioItem2.setGroup(getHoumonKangoIryoInfoRadio());

      addHoumonKangoIryoInfoRadioItem2();
    }
    return houmonKangoIryoInfoRadioItem2;

  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setHgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * �^�[�~�i���P�A�×{����擾���܂��B
   * @return �^�[�~�i���P�A�×{��
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoTerminalRadio(){
    if(houmonKangoIryoTerminalRadio==null){

      houmonKangoIryoTerminalRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoTerminalRadioContainer().setText("�^�[�~�i���P�A�×{��");

      houmonKangoIryoTerminalRadio.setBindPath("2010111");

      houmonKangoIryoTerminalRadio.setUseClearButton(false);

      houmonKangoIryoTerminalRadio.setModel(getHoumonKangoIryoTerminalRadioModel());

      addHoumonKangoIryoTerminalRadio();
    }
    return houmonKangoIryoTerminalRadio;

  }

  /**
   * �^�[�~�i���P�A�×{��R���e�i���擾���܂��B
   * @return �^�[�~�i���P�A�×{��R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryoTerminalRadioContainer(){
    if(houmonKangoIryoTerminalRadioContainer==null){
      houmonKangoIryoTerminalRadioContainer = new ACLabelContainer();
      houmonKangoIryoTerminalRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoTerminalRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoTerminalRadioContainer.add(getHoumonKangoIryoTerminalRadio(), null);
    }
    return houmonKangoIryoTerminalRadioContainer;
  }

  /**
   * �^�[�~�i���P�A�×{��f�����擾���܂��B
   * @return �^�[�~�i���P�A�×{��f��
   */
  protected ACListModelAdapter getHoumonKangoIryoTerminalRadioModel(){
    if(houmonKangoIryoTerminalRadioModel==null){
      houmonKangoIryoTerminalRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoTerminalRadioModel();
    }
    return houmonKangoIryoTerminalRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoIryoTerminalRadioItem1(){
    if(houmonKangoIryoTerminalRadioItem1==null){

      houmonKangoIryoTerminalRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoTerminalRadioItem1.setText("�Ȃ�");

      houmonKangoIryoTerminalRadioItem1.setGroup(getHoumonKangoIryoTerminalRadio());

      houmonKangoIryoTerminalRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoTerminalRadioItem1();
    }
    return houmonKangoIryoTerminalRadioItem1;

  }

  /**
   * �ݑ�×{�x���f�Ï��̕ی���̎w�����擾���܂��B
   * @return �ݑ�×{�x���f�Ï��̕ی���̎w��
   */
  public ACRadioButtonItem getHoumonKangoIryoTerminalRadioItem2(){
    if(houmonKangoIryoTerminalRadioItem2==null){

      houmonKangoIryoTerminalRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoTerminalRadioItem2.setText("<html>�ݑ�×{�x���f�Ï���<br>�ی���̎w��</html>");

      houmonKangoIryoTerminalRadioItem2.setGroup(getHoumonKangoIryoTerminalRadio());

      houmonKangoIryoTerminalRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addHoumonKangoIryoTerminalRadioItem2();
    }
    return houmonKangoIryoTerminalRadioItem2;

  }

  /**
   * �ی���Ë@�ւ̕ی���̎w�����擾���܂��B
   * @return �ی���Ë@�ւ̕ی���̎w��
   */
  public ACRadioButtonItem getHoumonKangoIryoTerminalRadioItem3(){
    if(houmonKangoIryoTerminalRadioItem3==null){

      houmonKangoIryoTerminalRadioItem3 = new ACRadioButtonItem();

      houmonKangoIryoTerminalRadioItem3.setText("�ی���Ë@�ւ̕ی���̎w��");

      houmonKangoIryoTerminalRadioItem3.setGroup(getHoumonKangoIryoTerminalRadio());

      houmonKangoIryoTerminalRadioItem3.setConstraints(VRLayout.FLOW);

      addHoumonKangoIryoTerminalRadioItem3();
    }
    return houmonKangoIryoTerminalRadioItem3;

  }

  /**
   * �ً}�K��Ō���Z���擾���܂��B
   * @return �ً}�K��Ō���Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoEmergencyVisitNursingRadio(){
    if(houmonKangoIryoEmergencyVisitNursingRadio==null){

      houmonKangoIryoEmergencyVisitNursingRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoEmergencyVisitNursingRadioContainer().setText("�ً}���K��Ō���Z");

      houmonKangoIryoEmergencyVisitNursingRadio.setBindPath("2010112");

      houmonKangoIryoEmergencyVisitNursingRadio.setUseClearButton(false);

      houmonKangoIryoEmergencyVisitNursingRadio.setModel(getHoumonKangoIryoEmergencyVisitNursingRadioModel());

      addHoumonKangoIryoEmergencyVisitNursingRadio();
    }
    return houmonKangoIryoEmergencyVisitNursingRadio;

  }

  /**
   * �ً}�K��Ō���Z�R���e�i���擾���܂��B
   * @return �ً}�K��Ō���Z�R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryoEmergencyVisitNursingRadioContainer(){
    if(houmonKangoIryoEmergencyVisitNursingRadioContainer==null){
      houmonKangoIryoEmergencyVisitNursingRadioContainer = new ACLabelContainer();
      houmonKangoIryoEmergencyVisitNursingRadioContainer.setFollowChildEnabled(true);
      houmonKangoIryoEmergencyVisitNursingRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoEmergencyVisitNursingRadioContainer.add(getHoumonKangoIryoEmergencyVisitNursingRadio(), null);
    }
    return houmonKangoIryoEmergencyVisitNursingRadioContainer;
  }

  /**
   * �ً}�K��Ō���Z���f�����擾���܂��B
   * @return �ً}�K��Ō���Z���f��
   */
  protected ACListModelAdapter getHoumonKangoIryoEmergencyVisitNursingRadioModel(){
    if(houmonKangoIryoEmergencyVisitNursingRadioModel==null){
      houmonKangoIryoEmergencyVisitNursingRadioModel = new ACListModelAdapter();
      addHoumonKangoIryoEmergencyVisitNursingRadioModel();
    }
    return houmonKangoIryoEmergencyVisitNursingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getHoumonKangoIryoEmergencyVisitNursingRadioItem1(){
    if(houmonKangoIryoEmergencyVisitNursingRadioItem1==null){

      houmonKangoIryoEmergencyVisitNursingRadioItem1 = new ACRadioButtonItem();

      houmonKangoIryoEmergencyVisitNursingRadioItem1.setText("�Ȃ�");

      houmonKangoIryoEmergencyVisitNursingRadioItem1.setGroup(getHoumonKangoIryoEmergencyVisitNursingRadio());

      houmonKangoIryoEmergencyVisitNursingRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonKangoIryoEmergencyVisitNursingRadioItem1();
    }
    return houmonKangoIryoEmergencyVisitNursingRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoIryoEmergencyVisitNursingRadioItem2(){
    if(houmonKangoIryoEmergencyVisitNursingRadioItem2==null){

      houmonKangoIryoEmergencyVisitNursingRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoEmergencyVisitNursingRadioItem2.setText("����");

      houmonKangoIryoEmergencyVisitNursingRadioItem2.setGroup(getHoumonKangoIryoEmergencyVisitNursingRadio());

      houmonKangoIryoEmergencyVisitNursingRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonKangoIryoEmergencyVisitNursingRadioItem2();
    }
    return houmonKangoIryoEmergencyVisitNursingRadioItem2;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getHoumonKangoIryoTimeContena(){
    if(houmonKangoIryoTimeContena==null){

      houmonKangoIryoTimeContena = new ACBackLabelContainer();

      addHoumonKangoIryoTimeContena();
    }
    return houmonKangoIryoTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getHoumonKangoIryoBeginTime(){
    if(houmonKangoIryoBeginTime==null){

      houmonKangoIryoBeginTime = new ACTimeComboBox();

      getHoumonKangoIryoBeginTimeContainer().setText("�J�n����");

      houmonKangoIryoBeginTime.setBindPath("3");

      houmonKangoIryoBeginTime.setModelBindPath("3");

      houmonKangoIryoBeginTime.setRenderBindPath("CONTENT");

      houmonKangoIryoBeginTime.setModel(getHoumonKangoIryoBeginTimeModel());

      addHoumonKangoIryoBeginTime();
    }
    return houmonKangoIryoBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryoBeginTimeContainer(){
    if(houmonKangoIryoBeginTimeContainer==null){
      houmonKangoIryoBeginTimeContainer = new ACLabelContainer();
      houmonKangoIryoBeginTimeContainer.setFollowChildEnabled(true);
      houmonKangoIryoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoBeginTimeContainer.add(getHoumonKangoIryoBeginTime(), null);
    }
    return houmonKangoIryoBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonKangoIryoBeginTimeModel(){
    if(houmonKangoIryoBeginTimeModel==null){
      houmonKangoIryoBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonKangoIryoBeginTimeModel();
    }
    return houmonKangoIryoBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getHoumonKangoIryoEndTime(){
    if(houmonKangoIryoEndTime==null){

      houmonKangoIryoEndTime = new ACTimeComboBox();

      getHoumonKangoIryoEndTimeContainer().setText("�I������");

      houmonKangoIryoEndTime.setBindPath("4");

      houmonKangoIryoEndTime.setModelBindPath("4");

      houmonKangoIryoEndTime.setRenderBindPath("CONTENT");

      houmonKangoIryoEndTime.setModel(getHoumonKangoIryoEndTimeModel());

      addHoumonKangoIryoEndTime();
    }
    return houmonKangoIryoEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getHoumonKangoIryoEndTimeContainer(){
    if(houmonKangoIryoEndTimeContainer==null){
      houmonKangoIryoEndTimeContainer = new ACLabelContainer();
      houmonKangoIryoEndTimeContainer.setFollowChildEnabled(true);
      houmonKangoIryoEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKangoIryoEndTimeContainer.add(getHoumonKangoIryoEndTime(), null);
    }
    return houmonKangoIryoEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getHoumonKangoIryoEndTimeModel(){
    if(houmonKangoIryoEndTimeModel==null){
      houmonKangoIryoEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonKangoIryoEndTimeModel();
    }
    return houmonKangoIryoEndTimeModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001006Design() {

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

    this.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * �^�u�y�C���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("1", getTab1());

    tabs.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getHoumonKangoIryoBasicChargeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoIntractableDiseaseRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoExtensionTimeContena(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoGuidanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryo24HoureRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoSeriousIllnessRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKangoIryoInfoRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ��{�×{��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoBasicChargeDivision(){

  }

  /**
   * ��{�×{��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoBasicChargeDivisionModel(){

    getHoumonKangoIryoBasicChargeDivision1().setButtonIndex(1);
    getHoumonKangoIryoBasicChargeDivisionModel().add(getHoumonKangoIryoBasicChargeDivision1());

    getHoumonKangoIryoBasicChargeDivision2().setButtonIndex(2);
    getHoumonKangoIryoBasicChargeDivisionModel().add(getHoumonKangoIryoBasicChargeDivision2());

  }

  /**
   * ��{�×{��I�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoBasicChargeDivision1(){

  }

  /**
   * ��{�×{��II�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoBasicChargeDivision2(){

  }

  /**
   * �K��Ō�E���敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoClass(){

  }

  /**
   * �K��Ō�E���敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoClassModel(){

    getHoumonKangoIryoClass1().setButtonIndex(1);
    getHoumonKangoIryoClassModel().add(getHoumonKangoIryoClass1());

    getHoumonKangoIryoClass2().setButtonIndex(2);
    getHoumonKangoIryoClassModel().add(getHoumonKangoIryoClass2());

  }

  /**
   * ���œ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoClass1(){

  }

  /**
   * �y�łɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoClass2(){

  }

  /**
   * ��a�������񐔖K����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadio(){

  }

  /**
   * ��a�������񐔖K����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadioModel(){

    getHoumonKangoIryoIntractableDiseaseRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoIntractableDiseaseRadioModel().add(getHoumonKangoIryoIntractableDiseaseRadioItem1());

    getHoumonKangoIryoIntractableDiseaseRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoIntractableDiseaseRadioModel().add(getHoumonKangoIryoIntractableDiseaseRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoIntractableDiseaseRadioItem2(){

  }

  /**
   * �������ԉ��Z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoExtensionTimeContena(){

    houmonKangoIryoExtensionTimeContena.add(getHoumonKangoIryoExtensionTimeText(), VRLayout.FLOW);

    houmonKangoIryoExtensionTimeContena.add(getHoumonKangoIryoExtensionTimeLabel(), VRLayout.FLOW);

  }

  /**
   * �������ԁE�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoExtensionTimeText(){

  }

  /**
   * �������ԁE���x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoExtensionTimeLabel(){

  }

  /**
   * �n��A�g�މ@�������w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoGuidanceRadio(){

  }

  /**
   * �n��A�g�މ@�������w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoGuidanceRadioModel(){

    getHoumonKangoIryoGuidanceRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoGuidanceRadioModel().add(getHoumonKangoIryoGuidanceRadioItem1());

    getHoumonKangoIryoGuidanceRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoGuidanceRadioModel().add(getHoumonKangoIryoGuidanceRadioItem2());

    getHoumonKangoIryoGuidanceRadioItem3().setButtonIndex(3);
    getHoumonKangoIryoGuidanceRadioModel().add(getHoumonKangoIryoGuidanceRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoGuidanceRadioItem1(){

  }

  /**
   * �ʏ�̏ꍇ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoGuidanceRadioItem2(){

  }

  /**
   * �ݑ�×{�x���f�Ï��̕ی���̏ꍇ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoGuidanceRadioItem3(){

  }

  /**
   * 24���ԉ��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryo24HoureRadio(){

  }

  /**
   * 24���ԉ��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryo24HoureRadioModel(){

    getHoumonKangoIryo24HoureRadioItem1().setButtonIndex(1);
    getHoumonKangoIryo24HoureRadioModel().add(getHoumonKangoIryo24HoureRadioItem1());

    getHoumonKangoIryo24HoureRadioItem2().setButtonIndex(2);
    getHoumonKangoIryo24HoureRadioModel().add(getHoumonKangoIryo24HoureRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryo24HoureRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryo24HoureRadioItem2(){

  }

  /**
   * �d�ǎ҉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoSeriousIllnessRadio(){

  }

  /**
   * �d�ǎ҉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioModel(){

    getHoumonKangoIryoSeriousIllnessRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoSeriousIllnessRadioModel().add(getHoumonKangoIryoSeriousIllnessRadioItem1());

    getHoumonKangoIryoSeriousIllnessRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoSeriousIllnessRadioModel().add(getHoumonKangoIryoSeriousIllnessRadioItem2());

    getHoumonKangoIryoSeriousIllnessRadioItem3().setButtonIndex(3);
    getHoumonKangoIryoSeriousIllnessRadioModel().add(getHoumonKangoIryoSeriousIllnessRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioItem1(){

  }

  /**
   * ���ʂȊǗ���K�v�Ƃ��銳�҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioItem2(){

  }

  /**
   * �d�Ǔx���̍������҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioItem3(){

  }

  /**
   * ���񋟉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoInfoRadio(){

  }

  /**
   * ���񋟉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoInfoRadioModel(){

    getHoumonKangoIryoInfoRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoInfoRadioModel().add(getHoumonKangoIryoInfoRadioItem1());

    getHoumonKangoIryoInfoRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoInfoRadioModel().add(getHoumonKangoIryoInfoRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoInfoRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoInfoRadioItem2(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getHoumonKangoIryoTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonKangoIryoEmergencyVisitNursingRadioContainer(), VRLayout.FLOW_INSETLINE);

    tab2.add(getHoumonKangoIryoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �^�[�~�i���P�A�×{��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoTerminalRadio(){

  }

  /**
   * �^�[�~�i���P�A�×{��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoTerminalRadioModel(){

    getHoumonKangoIryoTerminalRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoTerminalRadioModel().add(getHoumonKangoIryoTerminalRadioItem1());

    getHoumonKangoIryoTerminalRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoTerminalRadioModel().add(getHoumonKangoIryoTerminalRadioItem2());

    getHoumonKangoIryoTerminalRadioItem3().setButtonIndex(3);
    getHoumonKangoIryoTerminalRadioModel().add(getHoumonKangoIryoTerminalRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoTerminalRadioItem1(){

  }

  /**
   * �ݑ�×{�x���f�Ï��̕ی���̎w���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoTerminalRadioItem2(){

  }

  /**
   * �ی���Ë@�ւ̕ی���̎w���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoTerminalRadioItem3(){

  }

  /**
   * �ً}�K��Ō���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoEmergencyVisitNursingRadio(){

  }

  /**
   * �ً}�K��Ō���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoEmergencyVisitNursingRadioModel(){

    getHoumonKangoIryoEmergencyVisitNursingRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoEmergencyVisitNursingRadioModel().add(getHoumonKangoIryoEmergencyVisitNursingRadioItem1());

    getHoumonKangoIryoEmergencyVisitNursingRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoEmergencyVisitNursingRadioModel().add(getHoumonKangoIryoEmergencyVisitNursingRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoEmergencyVisitNursingRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoEmergencyVisitNursingRadioItem2(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoTimeContena(){

    houmonKangoIryoTimeContena.add(getHoumonKangoIryoBeginTimeContainer(), VRLayout.FLOW);

    houmonKangoIryoTimeContena.add(getHoumonKangoIryoEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001006Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001006Design getThis() {
    return this;
  }
}
