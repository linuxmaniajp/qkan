
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
 * �v���O���� �T�[�r�X�p�^�[���K��Ō�i��Áj (QS001104)
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
 * �T�[�r�X�p�^�[���K��Ō�i��Áj��ʍ��ڃf�U�C��(QS001104) 
 */
public class QS001104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel houmonKangoIryoPatterns;

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

  private ACClearableRadioButtonGroup houmonKangoIryoInfoRadio;

  private ACLabelContainer houmonKangoIryoInfoRadioContainer;

  private ACListModelAdapter houmonKangoIryoInfoRadioModel;

  private ACRadioButtonItem houmonKangoIryoInfoRadioItem1;

  private ACRadioButtonItem houmonKangoIryoInfoRadioItem2;

  private ACClearableRadioButtonGroup houmonKangoIryoTerminalRadio;

  private ACLabelContainer houmonKangoIryoTerminalRadioContainer;

  private ACListModelAdapter houmonKangoIryoTerminalRadioModel;

  private ACRadioButtonItem houmonKangoIryoTerminalRadioItem1;

  private ACRadioButtonItem houmonKangoIryoTerminalRadioItem2;

  //getter

  /**
   * �K��Ō�i���j�p�^�[���̈�j���擾���܂��B
   * @return �K��Ō�i���j�p�^�[���̈�j
   */
  public ACPanel getHoumonKangoIryoPatterns(){
    if(houmonKangoIryoPatterns==null){

      houmonKangoIryoPatterns = new ACPanel();

      addHoumonKangoIryoPatterns();
    }
    return houmonKangoIryoPatterns;

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

      houmonKangoIryoClass.setModel(getHoumonKangoIryoClassModel());

      houmonKangoIryoClass.setUseClearButton(false);

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

      houmonKangoIryoIntractableDiseaseRadio.setModel(getHoumonKangoIryoIntractableDiseaseRadioModel());

      houmonKangoIryoIntractableDiseaseRadio.setUseClearButton(false);

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

      houmonKangoIryoExtensionTimeText.setMaxLength(2);

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
   * �����w�����Z���擾���܂��B
   * @return �����w�����Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoGuidanceRadio(){
    if(houmonKangoIryoGuidanceRadio==null){

      houmonKangoIryoGuidanceRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoGuidanceRadioContainer().setText("�����w�����Z");

      houmonKangoIryoGuidanceRadio.setBindPath("2010107");

      houmonKangoIryoGuidanceRadio.setModel(getHoumonKangoIryoGuidanceRadioModel());

      houmonKangoIryoGuidanceRadio.setUseClearButton(false);

      addHoumonKangoIryoGuidanceRadio();
    }
    return houmonKangoIryoGuidanceRadio;

  }

  /**
   * �����w�����Z�R���e�i���擾���܂��B
   * @return �����w�����Z�R���e�i
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
   * �����w�����Z���f�����擾���܂��B
   * @return �����w�����Z���f��
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

      addHoumonKangoIryoGuidanceRadioItem1();
    }
    return houmonKangoIryoGuidanceRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoIryoGuidanceRadioItem2(){
    if(houmonKangoIryoGuidanceRadioItem2==null){

      houmonKangoIryoGuidanceRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoGuidanceRadioItem2.setText("����");

      houmonKangoIryoGuidanceRadioItem2.setGroup(getHoumonKangoIryoGuidanceRadio());

      addHoumonKangoIryoGuidanceRadioItem2();
    }
    return houmonKangoIryoGuidanceRadioItem2;

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

      houmonKangoIryo24HoureRadio.setModel(getHoumonKangoIryo24HoureRadioModel());

      houmonKangoIryo24HoureRadio.setUseClearButton(false);

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
   * �d���҉��Z���擾���܂��B
   * @return �d���҉��Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoSeriousIllnessRadio(){
    if(houmonKangoIryoSeriousIllnessRadio==null){

      houmonKangoIryoSeriousIllnessRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoSeriousIllnessRadioContainer().setText("�d�ǎҊǗ����Z");

      houmonKangoIryoSeriousIllnessRadio.setBindPath("2010109");

      houmonKangoIryoSeriousIllnessRadio.setModel(getHoumonKangoIryoSeriousIllnessRadioModel());

      houmonKangoIryoSeriousIllnessRadio.setUseClearButton(false);

      addHoumonKangoIryoSeriousIllnessRadio();
    }
    return houmonKangoIryoSeriousIllnessRadio;

  }

  /**
   * �d���҉��Z�R���e�i���擾���܂��B
   * @return �d���҉��Z�R���e�i
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
   * �d���҉��Z���f�����擾���܂��B
   * @return �d���҉��Z���f��
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

      addHoumonKangoIryoSeriousIllnessRadioItem1();
    }
    return houmonKangoIryoSeriousIllnessRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoIryoSeriousIllnessRadioItem2(){
    if(houmonKangoIryoSeriousIllnessRadioItem2==null){

      houmonKangoIryoSeriousIllnessRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoSeriousIllnessRadioItem2.setText("����");

      houmonKangoIryoSeriousIllnessRadioItem2.setGroup(getHoumonKangoIryoSeriousIllnessRadio());

      addHoumonKangoIryoSeriousIllnessRadioItem2();
    }
    return houmonKangoIryoSeriousIllnessRadioItem2;

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

      houmonKangoIryoInfoRadio.setModel(getHoumonKangoIryoInfoRadioModel());

      houmonKangoIryoInfoRadio.setUseClearButton(false);

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
   * �^�[�~�i���P�A���Z���擾���܂��B
   * @return �^�[�~�i���P�A���Z
   */
  public ACClearableRadioButtonGroup getHoumonKangoIryoTerminalRadio(){
    if(houmonKangoIryoTerminalRadio==null){

      houmonKangoIryoTerminalRadio = new ACClearableRadioButtonGroup();

      getHoumonKangoIryoTerminalRadioContainer().setText("�^�[�~�i���P�A���Z");

      houmonKangoIryoTerminalRadio.setBindPath("2010111");

      houmonKangoIryoTerminalRadio.setModel(getHoumonKangoIryoTerminalRadioModel());

      houmonKangoIryoTerminalRadio.setUseClearButton(false);

      addHoumonKangoIryoTerminalRadio();
    }
    return houmonKangoIryoTerminalRadio;

  }

  /**
   * �^�[�~�i���P�A���Z�R���e�i���擾���܂��B
   * @return �^�[�~�i���P�A���Z�R���e�i
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
   * �^�[�~�i���P�A���Z���f�����擾���܂��B
   * @return �^�[�~�i���P�A���Z���f��
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

      addHoumonKangoIryoTerminalRadioItem1();
    }
    return houmonKangoIryoTerminalRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getHoumonKangoIryoTerminalRadioItem2(){
    if(houmonKangoIryoTerminalRadioItem2==null){

      houmonKangoIryoTerminalRadioItem2 = new ACRadioButtonItem();

      houmonKangoIryoTerminalRadioItem2.setText("����");

      houmonKangoIryoTerminalRadioItem2.setGroup(getHoumonKangoIryoTerminalRadio());

      addHoumonKangoIryoTerminalRadioItem2();
    }
    return houmonKangoIryoTerminalRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001104Design() {

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

    this.add(getHoumonKangoIryoPatterns(), VRLayout.CLIENT);

  }

  /**
   * �K��Ō�i���j�p�^�[���̈�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoPatterns(){

    houmonKangoIryoPatterns.add(getHoumonKangoIryoClassContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoIntractableDiseaseRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoExtensionTimeContena(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoGuidanceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryo24HoureRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoSeriousIllnessRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoInfoRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    houmonKangoIryoPatterns.add(getHoumonKangoIryoTerminalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �����w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoGuidanceRadio(){

  }

  /**
   * �����w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoGuidanceRadioModel(){

    getHoumonKangoIryoGuidanceRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoGuidanceRadioModel().add(getHoumonKangoIryoGuidanceRadioItem1());

    getHoumonKangoIryoGuidanceRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoGuidanceRadioModel().add(getHoumonKangoIryoGuidanceRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoGuidanceRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoGuidanceRadioItem2(){

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
   * �d���҉��Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoSeriousIllnessRadio(){

  }

  /**
   * �d���҉��Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioModel(){

    getHoumonKangoIryoSeriousIllnessRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoSeriousIllnessRadioModel().add(getHoumonKangoIryoSeriousIllnessRadioItem1());

    getHoumonKangoIryoSeriousIllnessRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoSeriousIllnessRadioModel().add(getHoumonKangoIryoSeriousIllnessRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoSeriousIllnessRadioItem2(){

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
   * �^�[�~�i���P�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoTerminalRadio(){

  }

  /**
   * �^�[�~�i���P�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoTerminalRadioModel(){

    getHoumonKangoIryoTerminalRadioItem1().setButtonIndex(1);
    getHoumonKangoIryoTerminalRadioModel().add(getHoumonKangoIryoTerminalRadioItem1());

    getHoumonKangoIryoTerminalRadioItem2().setButtonIndex(2);
    getHoumonKangoIryoTerminalRadioModel().add(getHoumonKangoIryoTerminalRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoTerminalRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addHoumonKangoIryoTerminalRadioItem2(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001104Design getThis() {
    return this;
  }
}
