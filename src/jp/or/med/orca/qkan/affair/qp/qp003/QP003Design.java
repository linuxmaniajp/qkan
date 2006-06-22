
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
 * �J����: �����@�L
 * �쐬��: 2006/04/18  ���{�R���s���[�^�[������� �����@�L �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (003)
 * �v���O���� ���p�Ҍ��������ڍוҏW (QP003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp003;
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
 * ���p�Ҍ��������ڍוҏW��ʍ��ڃf�U�C��(QP003) 
 */
public class QP003Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACPanel contents;

  private ACPanel contentPatients;

  private ACTextField contentPatientText;

  private ACLabel contentPatientID;

  private ACLabel contentPatientName;

  private ACPanel contentProviders;

  private ACTextField contentProviderText;

  private ACLabel contentProviderId;

  private ACLabel contentProviderName;

  private ACLabel contentSpace1;

  private ACPanel contentJikohutanArea;

  private ACTextField contentBill;

  private ACPanel contentJikohutans;

  private VRLayout contentJikohutanLayout;

  private ACTextField contentJikohutanHimokuTitle;

  private ACTextField contentJikohutanUseTitle;

  private ACComboBox contentJikohutanHimoku1;

  private ACComboBoxModelAdapter contentJikohutanHimoku1Model;

  private ACTextField contentJikohutanUse1;

  private ACComboBox contentJikohutanHimoku2;

  private ACComboBoxModelAdapter contentJikohutanHimoku2Model;

  private ACTextField contentJikohutanUse2;

  private ACComboBox contentJikohutanHimoku3;

  private ACComboBoxModelAdapter contentJikohutanHimoku3Model;

  private ACTextField contentJikohutanUse3;

  private ACPanel contentJikohutanTitleArea;

  private VRLayout contentJikohutanTitleAreaLayout;

  private ACTextField contentJikohutanSubtotalTitle;

  private ACTextField contentJikohutanSubtotal;

  private ACLabel contentSpace2;

  private ACPanel contentEtcs;

  private ACPanel contentEtcArea;

  private VRLayout contentEtcAreaLayout;

  private ACTextField contentEtcHimokuTitle;

  private ACTextField contentEtcUseTitle;

  private ACComboBox contentEtcHimoku1;

  private ACComboBoxModelAdapter contentEtcHimoku1Model;

  private ACTextField contentEtcUse1;

  private ACComboBox contentEtcHimoku2;

  private ACComboBoxModelAdapter contentEtcHimoku2Model;

  private ACTextField contentEtcUse2;

  private ACComboBox contentEtcHimoku3;

  private ACComboBoxModelAdapter contentEtcHimoku3Model;

  private ACTextField contentEtcUse3;

  private ACComboBox contentEtcHimoku4;

  private ACComboBoxModelAdapter contentEtcHimoku4Model;

  private ACTextField contentEtcUse4;

  private ACComboBox contentEtcHimoku5;

  private ACComboBoxModelAdapter contentEtcHimoku5Model;

  private ACTextField contentEtcUse5;

  private ACPanel contentEtcTitleArea;

  private VRLayout contentEtcTitleAreaLayout;

  private ACTextField contentEtcSubtotalTitle;

  private ACTextField contentEtcSubtotal;

  private ACLabel contentSpace3;

  private ACPanel contentBottoms;

  private ACPanel contentTotals;

  private ACLabel contentTotalLabel;

  private ACTextField contentTotalText;

  private ACLabel contentKoujyoLabel;

  private ACTextField contentKoujyoText;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("���p�Ҍ��������ڍוҏW���");

      addButtons();
    }
    return buttons;

  }

  /**
   * �o�^�{�^��(S)���擾���܂��B
   * @return �o�^�{�^��(S)
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("�o�^(S)");

      insert.setToolTipText("���݂̓��e��o�^���܂��B");

      insert.setMnemonic('S');

      insert.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addInsert();
    }
    return insert;

  }

  /**
   * �X�V�{�^��(S)���擾���܂��B
   * @return �X�V�{�^��(S)
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("�X�V(S)");

      update.setToolTipText("���݂̓��e���X�V���܂��B");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setAutoWrap(false);

      contents.setHgap(0);

      addContents();
    }
    return contents;

  }

  /**
   * ���p�ҏ��̈���擾���܂��B
   * @return ���p�ҏ��̈�
   */
  public ACPanel getContentPatients(){
    if(contentPatients==null){

      contentPatients = new ACPanel();

      contentPatients.setAutoWrap(false);

      addContentPatients();
    }
    return contentPatients;

  }

  /**
   * ���p�҂��擾���܂��B
   * @return ���p��
   */
  public ACTextField getContentPatientText(){
    if(contentPatientText==null){

      contentPatientText = new ACTextField();

      contentPatientText.setText("���p��");

      contentPatientText.setEnabled(false);

      contentPatientText.setBackground(new Color(230,230,230));

      contentPatientText.setDisabledTextColor(new Color(0,0,0));

      addContentPatientText();
    }
    return contentPatientText;

  }

  /**
   * ���p��ID���擾���܂��B
   * @return ���p��ID
   */
  public ACLabel getContentPatientID(){
    if(contentPatientID==null){

      contentPatientID = new ACLabel();

      contentPatientID.setText("9999999999");

      contentPatientID.setBindPath("PATIENT_CODE");

      addContentPatientID();
    }
    return contentPatientID;

  }

  /**
   * ���p�Җ����擾���܂��B
   * @return ���p�Җ�
   */
  public ACLabel getContentPatientName(){
    if(contentPatientName==null){

      contentPatientName = new ACLabel();

      contentPatientName.setText("���p�ҁ@����");

      contentPatientName.setBindPath("PATIENT_NAME");

      addContentPatientName();
    }
    return contentPatientName;

  }

  /**
   * ���Ə����̈���擾���܂��B
   * @return ���Ə����̈�
   */
  public ACPanel getContentProviders(){
    if(contentProviders==null){

      contentProviders = new ACPanel();

      contentProviders.setAutoWrap(false);

      addContentProviders();
    }
    return contentProviders;

  }

  /**
   * ���Ə����擾���܂��B
   * @return ���Ə�
   */
  public ACTextField getContentProviderText(){
    if(contentProviderText==null){

      contentProviderText = new ACTextField();

      contentProviderText.setText("���Ə�");

      contentProviderText.setEnabled(false);

      contentProviderText.setBackground(new Color(230,230,230));

      contentProviderText.setDisabledTextColor(new Color(0,0,0));

      addContentProviderText();
    }
    return contentProviderText;

  }

  /**
   * ���Ə�ID���擾���܂��B
   * @return ���Ə�ID
   */
  public ACLabel getContentProviderId(){
    if(contentProviderId==null){

      contentProviderId = new ACLabel();

      contentProviderId.setText("9999999999");

      contentProviderId.setBindPath("PROVIDER_ID");

      addContentProviderId();
    }
    return contentProviderId;

  }

  /**
   * ���Ə����̂��擾���܂��B
   * @return ���Ə�����
   */
  public ACLabel getContentProviderName(){
    if(contentProviderName==null){

      contentProviderName = new ACLabel();

      contentProviderName.setText("���Ə��@����");

      contentProviderName.setBindPath("PROVIDER_NAME");

      addContentProviderName();
    }
    return contentProviderName;

  }

  /**
   * �X�y�[�T�[���擾���܂��B
   * @return �X�y�[�T�[
   */
  public ACLabel getContentSpace1(){
    if(contentSpace1==null){

      contentSpace1 = new ACLabel();

      contentSpace1.setText(" ");

      addContentSpace1();
    }
    return contentSpace1;

  }

  /**
   * ���ȕ��S���̈���擾���܂��B
   * @return ���ȕ��S���̈�
   */
  public ACPanel getContentJikohutanArea(){
    if(contentJikohutanArea==null){

      contentJikohutanArea = new ACPanel();

      contentJikohutanArea.setAutoWrap(false);

      addContentJikohutanArea();
    }
    return contentJikohutanArea;

  }

  /**
   * �����Ώ۔N�����擾���܂��B
   * @return �����Ώ۔N��
   */
  public ACTextField getContentBill(){
    if(contentBill==null){

      contentBill = new ACTextField();

      contentBill.setText("���������N������������");

      contentBill.setBindPath("TARGET_DATE");

      contentBill.setEnabled(false);

      contentBill.setColumns(26);

      contentBill.setFormat(new ACBorderBlankDateFormat("gggee�NMM��"));

      contentBill.setHorizontalAlignment(SwingConstants.CENTER);

      contentBill.setBackground(new Color(230,230,230));

      contentBill.setDisabledTextColor(new Color(0,0,0));

      addContentBill();
    }
    return contentBill;

  }

  /**
   * �S�z���ȕ��S���p�l�����擾���܂��B
   * @return �S�z���ȕ��S���p�l��
   */
  public ACPanel getContentJikohutans(){
    if(contentJikohutans==null){

      contentJikohutans = new ACPanel();

      contentJikohutans.setLayout(getContentJikohutanLayout());

      addContentJikohutans();
    }
    return contentJikohutans;

  }

  /**
   * �S�z���ȕ��S�����C�A�E�g���擾���܂��B
   * @return �S�z���ȕ��S�����C�A�E�g
   */
  public VRLayout getContentJikohutanLayout(){
    if(contentJikohutanLayout==null){

      contentJikohutanLayout = new VRLayout();

      contentJikohutanLayout.setAutoWrap(false);

      contentJikohutanLayout.setFitHLast(true);

      contentJikohutanLayout.setFitVLast(true);

      contentJikohutanLayout.setHgap(0);

      contentJikohutanLayout.setLabelMargin(0);

      contentJikohutanLayout.setVgap(0);

      addContentJikohutanLayout();
    }
    return contentJikohutanLayout;

  }

  /**
   * �S�z���ȕ��S����ڃ^�C�g�����擾���܂��B
   * @return �S�z���ȕ��S����ڃ^�C�g��
   */
  public ACTextField getContentJikohutanHimokuTitle(){
    if(contentJikohutanHimokuTitle==null){

      contentJikohutanHimokuTitle = new ACTextField();

      contentJikohutanHimokuTitle.setText("�S�z���ȕ��S���@���");

      contentJikohutanHimokuTitle.setEnabled(false);

      contentJikohutanHimokuTitle.setColumns(26);

      contentJikohutanHimokuTitle.setHorizontalAlignment(SwingConstants.CENTER);

      contentJikohutanHimokuTitle.setBackground(new Color(230,230,230));

      contentJikohutanHimokuTitle.setDisabledTextColor(new Color(0,0,0));

      addContentJikohutanHimokuTitle();
    }
    return contentJikohutanHimokuTitle;

  }

  /**
   * �S�z���ȕ��S�����p���^�C�g�����擾���܂��B
   * @return �S�z���ȕ��S�����p���^�C�g��
   */
  public ACTextField getContentJikohutanUseTitle(){
    if(contentJikohutanUseTitle==null){

      contentJikohutanUseTitle = new ACTextField();

      contentJikohutanUseTitle.setText("���p��");

      contentJikohutanUseTitle.setEnabled(false);

      contentJikohutanUseTitle.setColumns(9);

      contentJikohutanUseTitle.setHorizontalAlignment(SwingConstants.CENTER);

      contentJikohutanUseTitle.setBackground(new Color(230,230,230));

      contentJikohutanUseTitle.setDisabledTextColor(new Color(0,0,0));

      addContentJikohutanUseTitle();
    }
    return contentJikohutanUseTitle;

  }

  /**
   * �S�z���ȕ��S����ڂP���擾���܂��B
   * @return �S�z���ȕ��S����ڂP
   */
  public ACComboBox getContentJikohutanHimoku1(){
    if(contentJikohutanHimoku1==null){

      contentJikohutanHimoku1 = new ACComboBox();

      contentJikohutanHimoku1.setBindPath("SELF_SERVICE_NO1");

      contentJikohutanHimoku1.setEditable(true);

      contentJikohutanHimoku1.setColumns(25);

      contentJikohutanHimoku1.setModelBindPath("SELF_PAY");

      contentJikohutanHimoku1.setBlankable(false);

      contentJikohutanHimoku1.setIMEMode(InputSubset.KANJI);

      contentJikohutanHimoku1.setMaxLength(75);

      contentJikohutanHimoku1.setModel(getContentJikohutanHimoku1Model());

      addContentJikohutanHimoku1();
    }
    return contentJikohutanHimoku1;

  }

  /**
   * �S�z���ȕ��S����ڂP���f�����擾���܂��B
   * @return �S�z���ȕ��S����ڂP���f��
   */
  protected ACComboBoxModelAdapter getContentJikohutanHimoku1Model(){
    if(contentJikohutanHimoku1Model==null){
      contentJikohutanHimoku1Model = new ACComboBoxModelAdapter();
      addContentJikohutanHimoku1Model();
    }
    return contentJikohutanHimoku1Model;
  }

  /**
   * �S�z���ȕ��S�����p���P���擾���܂��B
   * @return �S�z���ȕ��S�����p���P
   */
  public ACTextField getContentJikohutanUse1(){
    if(contentJikohutanUse1==null){

      contentJikohutanUse1 = new ACTextField();

      contentJikohutanUse1.setBindPath("SELF_PAY_NO1");

      contentJikohutanUse1.setColumns(8);

      contentJikohutanUse1.setCharType(VRCharType.ONLY_NUMBER);

      contentJikohutanUse1.setHorizontalAlignment(SwingConstants.RIGHT);

      contentJikohutanUse1.setIMEMode(InputSubset.LATIN);

      contentJikohutanUse1.setMaxLength(8);

      addContentJikohutanUse1();
    }
    return contentJikohutanUse1;

  }

  /**
   * �S�z���ȕ��S����ڂQ���擾���܂��B
   * @return �S�z���ȕ��S����ڂQ
   */
  public ACComboBox getContentJikohutanHimoku2(){
    if(contentJikohutanHimoku2==null){

      contentJikohutanHimoku2 = new ACComboBox();

      contentJikohutanHimoku2.setBindPath("SELF_SERVICE_NO2");

      contentJikohutanHimoku2.setEditable(true);

      contentJikohutanHimoku2.setColumns(25);

      contentJikohutanHimoku2.setModelBindPath("SELF_PAY");

      contentJikohutanHimoku2.setBlankable(false);

      contentJikohutanHimoku2.setIMEMode(InputSubset.KANJI);

      contentJikohutanHimoku2.setMaxLength(75);

      contentJikohutanHimoku2.setModel(getContentJikohutanHimoku2Model());

      addContentJikohutanHimoku2();
    }
    return contentJikohutanHimoku2;

  }

  /**
   * �S�z���ȕ��S����ڂQ���f�����擾���܂��B
   * @return �S�z���ȕ��S����ڂQ���f��
   */
  protected ACComboBoxModelAdapter getContentJikohutanHimoku2Model(){
    if(contentJikohutanHimoku2Model==null){
      contentJikohutanHimoku2Model = new ACComboBoxModelAdapter();
      addContentJikohutanHimoku2Model();
    }
    return contentJikohutanHimoku2Model;
  }

  /**
   * �S�z���ȕ��S�����p���Q���擾���܂��B
   * @return �S�z���ȕ��S�����p���Q
   */
  public ACTextField getContentJikohutanUse2(){
    if(contentJikohutanUse2==null){

      contentJikohutanUse2 = new ACTextField();

      contentJikohutanUse2.setBindPath("SELF_PAY_NO2");

      contentJikohutanUse2.setColumns(8);

      contentJikohutanUse2.setCharType(VRCharType.ONLY_NUMBER);

      contentJikohutanUse2.setHorizontalAlignment(SwingConstants.RIGHT);

      contentJikohutanUse2.setIMEMode(InputSubset.LATIN);

      contentJikohutanUse2.setMaxLength(8);

      addContentJikohutanUse2();
    }
    return contentJikohutanUse2;

  }

  /**
   * �S�z���ȕ��S����ڂR���擾���܂��B
   * @return �S�z���ȕ��S����ڂR
   */
  public ACComboBox getContentJikohutanHimoku3(){
    if(contentJikohutanHimoku3==null){

      contentJikohutanHimoku3 = new ACComboBox();

      contentJikohutanHimoku3.setBindPath("SELF_SERVICE_NO3");

      contentJikohutanHimoku3.setEditable(true);

      contentJikohutanHimoku3.setColumns(25);

      contentJikohutanHimoku3.setModelBindPath("SELF_PAY");

      contentJikohutanHimoku3.setBlankable(false);

      contentJikohutanHimoku3.setIMEMode(InputSubset.KANJI);

      contentJikohutanHimoku3.setMaxLength(75);

      contentJikohutanHimoku3.setModel(getContentJikohutanHimoku3Model());

      addContentJikohutanHimoku3();
    }
    return contentJikohutanHimoku3;

  }

  /**
   * �S�z���ȕ��S����ڂR���f�����擾���܂��B
   * @return �S�z���ȕ��S����ڂR���f��
   */
  protected ACComboBoxModelAdapter getContentJikohutanHimoku3Model(){
    if(contentJikohutanHimoku3Model==null){
      contentJikohutanHimoku3Model = new ACComboBoxModelAdapter();
      addContentJikohutanHimoku3Model();
    }
    return contentJikohutanHimoku3Model;
  }

  /**
   * �S�z���ȕ��S�����p���R���擾���܂��B
   * @return �S�z���ȕ��S�����p���R
   */
  public ACTextField getContentJikohutanUse3(){
    if(contentJikohutanUse3==null){

      contentJikohutanUse3 = new ACTextField();

      contentJikohutanUse3.setBindPath("SELF_PAY_NO3");

      contentJikohutanUse3.setColumns(8);

      contentJikohutanUse3.setCharType(VRCharType.ONLY_NUMBER);

      contentJikohutanUse3.setHorizontalAlignment(SwingConstants.RIGHT);

      contentJikohutanUse3.setIMEMode(InputSubset.LATIN);

      contentJikohutanUse3.setMaxLength(8);

      addContentJikohutanUse3();
    }
    return contentJikohutanUse3;

  }

  /**
   * �S�z���ȕ��S�^�C�g���̈���擾���܂��B
   * @return �S�z���ȕ��S�^�C�g���̈�
   */
  public ACPanel getContentJikohutanTitleArea(){
    if(contentJikohutanTitleArea==null){

      contentJikohutanTitleArea = new ACPanel();

      contentJikohutanTitleArea.setLayout(getContentJikohutanTitleAreaLayout());

      contentJikohutanTitleArea.setAutoWrap(false);

      addContentJikohutanTitleArea();
    }
    return contentJikohutanTitleArea;

  }

  /**
   * �S�z���ȕ��S�^�C�g���̈�E���C�A�E�g���擾���܂��B
   * @return �S�z���ȕ��S�^�C�g���̈�E���C�A�E�g
   */
  public VRLayout getContentJikohutanTitleAreaLayout(){
    if(contentJikohutanTitleAreaLayout==null){

      contentJikohutanTitleAreaLayout = new VRLayout();

      contentJikohutanTitleAreaLayout.setAutoWrap(false);

      contentJikohutanTitleAreaLayout.setFitHLast(true);

      contentJikohutanTitleAreaLayout.setFitVLast(true);

      contentJikohutanTitleAreaLayout.setHgap(0);

      contentJikohutanTitleAreaLayout.setLabelMargin(0);

      contentJikohutanTitleAreaLayout.setVgap(0);

      addContentJikohutanTitleAreaLayout();
    }
    return contentJikohutanTitleAreaLayout;

  }

  /**
   * �S�z���ȕ��S���v�^�C�g�����擾���܂��B
   * @return �S�z���ȕ��S���v�^�C�g��
   */
  public ACTextField getContentJikohutanSubtotalTitle(){
    if(contentJikohutanSubtotalTitle==null){

      contentJikohutanSubtotalTitle = new ACTextField();

      contentJikohutanSubtotalTitle.setText("���v");

      contentJikohutanSubtotalTitle.setEnabled(false);

      contentJikohutanSubtotalTitle.setColumns(26);

      contentJikohutanSubtotalTitle.setHorizontalAlignment(SwingConstants.CENTER);

      contentJikohutanSubtotalTitle.setBackground(new Color(230,230,230));

      contentJikohutanSubtotalTitle.setDisabledTextColor(new Color(0,0,0));

      addContentJikohutanSubtotalTitle();
    }
    return contentJikohutanSubtotalTitle;

  }

  /**
   * �S�z���ȕ��S���v���擾���܂��B
   * @return �S�z���ȕ��S���v
   */
  public ACTextField getContentJikohutanSubtotal(){
    if(contentJikohutanSubtotal==null){

      contentJikohutanSubtotal = new ACTextField();

      contentJikohutanSubtotal.setEnabled(false);

      contentJikohutanSubtotal.setColumns(9);

      contentJikohutanSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);

      contentJikohutanSubtotal.setBackground(new Color(230,230,230));

      contentJikohutanSubtotal.setDisabledTextColor(new Color(0,0,0));

      addContentJikohutanSubtotal();
    }
    return contentJikohutanSubtotal;

  }

  /**
   * �X�y�[�T�[���擾���܂��B
   * @return �X�y�[�T�[
   */
  public ACLabel getContentSpace2(){
    if(contentSpace2==null){

      contentSpace2 = new ACLabel();

      contentSpace2.setText(" ");

      addContentSpace2();
    }
    return contentSpace2;

  }

  /**
   * ���̑��p�l�����擾���܂��B
   * @return ���̑��p�l��
   */
  public ACPanel getContentEtcs(){
    if(contentEtcs==null){

      contentEtcs = new ACPanel();

      addContentEtcs();
    }
    return contentEtcs;

  }

  /**
   * ���̑��̈���擾���܂��B
   * @return ���̑��̈�
   */
  public ACPanel getContentEtcArea(){
    if(contentEtcArea==null){

      contentEtcArea = new ACPanel();

      contentEtcArea.setLayout(getContentEtcAreaLayout());

      contentEtcArea.setAutoWrap(false);

      addContentEtcArea();
    }
    return contentEtcArea;

  }

  /**
   * ���C�A�E�g2���擾���܂��B
   * @return ���C�A�E�g2
   */
  public VRLayout getContentEtcAreaLayout(){
    if(contentEtcAreaLayout==null){

      contentEtcAreaLayout = new VRLayout();

      contentEtcAreaLayout.setAutoWrap(false);

      contentEtcAreaLayout.setFitHLast(true);

      contentEtcAreaLayout.setFitVLast(true);

      contentEtcAreaLayout.setHgap(0);

      contentEtcAreaLayout.setLabelMargin(0);

      contentEtcAreaLayout.setVgap(0);

      addContentEtcAreaLayout();
    }
    return contentEtcAreaLayout;

  }

  /**
   * ���̑���ڃ^�C�g�����擾���܂��B
   * @return ���̑���ڃ^�C�g��
   */
  public ACTextField getContentEtcHimokuTitle(){
    if(contentEtcHimokuTitle==null){

      contentEtcHimokuTitle = new ACTextField();

      contentEtcHimokuTitle.setText("���̑��@���");

      contentEtcHimokuTitle.setEnabled(false);

      contentEtcHimokuTitle.setColumns(26);

      contentEtcHimokuTitle.setHorizontalAlignment(SwingConstants.CENTER);

      contentEtcHimokuTitle.setBackground(new Color(230,230,230));

      contentEtcHimokuTitle.setDisabledTextColor(new Color(0,0,0));

      addContentEtcHimokuTitle();
    }
    return contentEtcHimokuTitle;

  }

  /**
   * ���̑����p���^�C�g�����擾���܂��B
   * @return ���̑����p���^�C�g��
   */
  public ACTextField getContentEtcUseTitle(){
    if(contentEtcUseTitle==null){

      contentEtcUseTitle = new ACTextField();

      contentEtcUseTitle.setText("���p��");

      contentEtcUseTitle.setEnabled(false);

      contentEtcUseTitle.setColumns(9);

      contentEtcUseTitle.setHorizontalAlignment(SwingConstants.CENTER);

      contentEtcUseTitle.setBackground(new Color(230,230,230));

      contentEtcUseTitle.setDisabledTextColor(new Color(0,0,0));

      addContentEtcUseTitle();
    }
    return contentEtcUseTitle;

  }

  /**
   * ���̑���ڂP���擾���܂��B
   * @return ���̑���ڂP
   */
  public ACComboBox getContentEtcHimoku1(){
    if(contentEtcHimoku1==null){

      contentEtcHimoku1 = new ACComboBox();

      contentEtcHimoku1.setBindPath("OTHER_HIMOKU_NO1");

      contentEtcHimoku1.setEditable(true);

      contentEtcHimoku1.setColumns(25);

      contentEtcHimoku1.setModelBindPath("OTHER");

      contentEtcHimoku1.setBlankable(false);

      contentEtcHimoku1.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku1.setMaxLength(75);

      contentEtcHimoku1.setModel(getContentEtcHimoku1Model());

      addContentEtcHimoku1();
    }
    return contentEtcHimoku1;

  }

  /**
   * ���̑���ڂP���f�����擾���܂��B
   * @return ���̑���ڂP���f��
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku1Model(){
    if(contentEtcHimoku1Model==null){
      contentEtcHimoku1Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku1Model();
    }
    return contentEtcHimoku1Model;
  }

  /**
   * ���̑����p���P���擾���܂��B
   * @return ���̑����p���P
   */
  public ACTextField getContentEtcUse1(){
    if(contentEtcUse1==null){

      contentEtcUse1 = new ACTextField();

      contentEtcUse1.setBindPath("OTHER_PAY_NO1");

      contentEtcUse1.setColumns(8);

      contentEtcUse1.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse1.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse1.setIMEMode(InputSubset.LATIN);

      contentEtcUse1.setMaxLength(8);

      addContentEtcUse1();
    }
    return contentEtcUse1;

  }

  /**
   * ���̑���ڂQ���擾���܂��B
   * @return ���̑���ڂQ
   */
  public ACComboBox getContentEtcHimoku2(){
    if(contentEtcHimoku2==null){

      contentEtcHimoku2 = new ACComboBox();

      contentEtcHimoku2.setBindPath("OTHER_HIMOKU_NO2");

      contentEtcHimoku2.setEditable(true);

      contentEtcHimoku2.setColumns(25);

      contentEtcHimoku2.setModelBindPath("OTHER");

      contentEtcHimoku2.setBlankable(false);

      contentEtcHimoku2.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku2.setMaxLength(75);

      contentEtcHimoku2.setModel(getContentEtcHimoku2Model());

      addContentEtcHimoku2();
    }
    return contentEtcHimoku2;

  }

  /**
   * ���̑���ڂQ���f�����擾���܂��B
   * @return ���̑���ڂQ���f��
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku2Model(){
    if(contentEtcHimoku2Model==null){
      contentEtcHimoku2Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku2Model();
    }
    return contentEtcHimoku2Model;
  }

  /**
   * ���̑����p���Q���擾���܂��B
   * @return ���̑����p���Q
   */
  public ACTextField getContentEtcUse2(){
    if(contentEtcUse2==null){

      contentEtcUse2 = new ACTextField();

      contentEtcUse2.setBindPath("OTHER_PAY_NO2");

      contentEtcUse2.setColumns(8);

      contentEtcUse2.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse2.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse2.setIMEMode(InputSubset.LATIN);

      contentEtcUse2.setMaxLength(8);

      addContentEtcUse2();
    }
    return contentEtcUse2;

  }

  /**
   * ���̑���ڂR���擾���܂��B
   * @return ���̑���ڂR
   */
  public ACComboBox getContentEtcHimoku3(){
    if(contentEtcHimoku3==null){

      contentEtcHimoku3 = new ACComboBox();

      contentEtcHimoku3.setBindPath("OTHER_HIMOKU_NO3");

      contentEtcHimoku3.setEditable(true);

      contentEtcHimoku3.setColumns(25);

      contentEtcHimoku3.setModelBindPath("OTHER");

      contentEtcHimoku3.setBlankable(false);

      contentEtcHimoku3.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku3.setMaxLength(75);

      contentEtcHimoku3.setModel(getContentEtcHimoku3Model());

      addContentEtcHimoku3();
    }
    return contentEtcHimoku3;

  }

  /**
   * ���̑���ڂR���f�����擾���܂��B
   * @return ���̑���ڂR���f��
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku3Model(){
    if(contentEtcHimoku3Model==null){
      contentEtcHimoku3Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku3Model();
    }
    return contentEtcHimoku3Model;
  }

  /**
   * ���̑����p���R���擾���܂��B
   * @return ���̑����p���R
   */
  public ACTextField getContentEtcUse3(){
    if(contentEtcUse3==null){

      contentEtcUse3 = new ACTextField();

      contentEtcUse3.setBindPath("OTHER_PAY_NO3");

      contentEtcUse3.setColumns(8);

      contentEtcUse3.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse3.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse3.setIMEMode(InputSubset.LATIN);

      contentEtcUse3.setMaxLength(8);

      addContentEtcUse3();
    }
    return contentEtcUse3;

  }

  /**
   * ���̑���ڂS���擾���܂��B
   * @return ���̑���ڂS
   */
  public ACComboBox getContentEtcHimoku4(){
    if(contentEtcHimoku4==null){

      contentEtcHimoku4 = new ACComboBox();

      contentEtcHimoku4.setBindPath("OTHER_HIMOKU_NO4");

      contentEtcHimoku4.setEditable(true);

      contentEtcHimoku4.setColumns(25);

      contentEtcHimoku4.setModelBindPath("OTHER");

      contentEtcHimoku4.setBlankable(false);

      contentEtcHimoku4.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku4.setMaxLength(75);

      contentEtcHimoku4.setModel(getContentEtcHimoku4Model());

      addContentEtcHimoku4();
    }
    return contentEtcHimoku4;

  }

  /**
   * ���̑���ڂS���f�����擾���܂��B
   * @return ���̑���ڂS���f��
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku4Model(){
    if(contentEtcHimoku4Model==null){
      contentEtcHimoku4Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku4Model();
    }
    return contentEtcHimoku4Model;
  }

  /**
   * ���̑����p���S���擾���܂��B
   * @return ���̑����p���S
   */
  public ACTextField getContentEtcUse4(){
    if(contentEtcUse4==null){

      contentEtcUse4 = new ACTextField();

      contentEtcUse4.setBindPath("OTHER_PAY_NO4");

      contentEtcUse4.setColumns(8);

      contentEtcUse4.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse4.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse4.setIMEMode(InputSubset.LATIN);

      contentEtcUse4.setMaxLength(8);

      addContentEtcUse4();
    }
    return contentEtcUse4;

  }

  /**
   * ���̑���ڂT���擾���܂��B
   * @return ���̑���ڂT
   */
  public ACComboBox getContentEtcHimoku5(){
    if(contentEtcHimoku5==null){

      contentEtcHimoku5 = new ACComboBox();

      contentEtcHimoku5.setBindPath("OTHER_HIMOKU_NO5");

      contentEtcHimoku5.setEditable(true);

      contentEtcHimoku5.setColumns(25);

      contentEtcHimoku5.setModelBindPath("OTHER");

      contentEtcHimoku5.setBlankable(false);

      contentEtcHimoku5.setIMEMode(InputSubset.KANJI);

      contentEtcHimoku5.setMaxLength(75);

      contentEtcHimoku5.setModel(getContentEtcHimoku5Model());

      addContentEtcHimoku5();
    }
    return contentEtcHimoku5;

  }

  /**
   * ���̑���ڂT���f�����擾���܂��B
   * @return ���̑���ڂT���f��
   */
  protected ACComboBoxModelAdapter getContentEtcHimoku5Model(){
    if(contentEtcHimoku5Model==null){
      contentEtcHimoku5Model = new ACComboBoxModelAdapter();
      addContentEtcHimoku5Model();
    }
    return contentEtcHimoku5Model;
  }

  /**
   * ���̑����p���T���擾���܂��B
   * @return ���̑����p���T
   */
  public ACTextField getContentEtcUse5(){
    if(contentEtcUse5==null){

      contentEtcUse5 = new ACTextField();

      contentEtcUse5.setBindPath("OTHER_PAY_NO5");

      contentEtcUse5.setColumns(8);

      contentEtcUse5.setCharType(VRCharType.ONLY_NUMBER);

      contentEtcUse5.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcUse5.setIMEMode(InputSubset.LATIN);

      contentEtcUse5.setMaxLength(8);

      addContentEtcUse5();
    }
    return contentEtcUse5;

  }

  /**
   * ���̑��^�C�g���̈���擾���܂��B
   * @return ���̑��^�C�g���̈�
   */
  public ACPanel getContentEtcTitleArea(){
    if(contentEtcTitleArea==null){

      contentEtcTitleArea = new ACPanel();

      contentEtcTitleArea.setLayout(getContentEtcTitleAreaLayout());

      contentEtcTitleArea.setAutoWrap(false);

      addContentEtcTitleArea();
    }
    return contentEtcTitleArea;

  }

  /**
   * ���C�A�E�g3���擾���܂��B
   * @return ���C�A�E�g3
   */
  public VRLayout getContentEtcTitleAreaLayout(){
    if(contentEtcTitleAreaLayout==null){

      contentEtcTitleAreaLayout = new VRLayout();

      contentEtcTitleAreaLayout.setAutoWrap(false);

      contentEtcTitleAreaLayout.setFitHLast(true);

      contentEtcTitleAreaLayout.setFitVLast(true);

      contentEtcTitleAreaLayout.setHgap(0);

      contentEtcTitleAreaLayout.setLabelMargin(0);

      contentEtcTitleAreaLayout.setVgap(0);

      addContentEtcTitleAreaLayout();
    }
    return contentEtcTitleAreaLayout;

  }

  /**
   * ���̑���p���v�^�C�g�����擾���܂��B
   * @return ���̑���p���v�^�C�g��
   */
  public ACTextField getContentEtcSubtotalTitle(){
    if(contentEtcSubtotalTitle==null){

      contentEtcSubtotalTitle = new ACTextField();

      contentEtcSubtotalTitle.setText("���v");

      contentEtcSubtotalTitle.setEnabled(false);

      contentEtcSubtotalTitle.setColumns(26);

      contentEtcSubtotalTitle.setHorizontalAlignment(SwingConstants.CENTER);

      contentEtcSubtotalTitle.setBackground(new Color(230,230,230));

      contentEtcSubtotalTitle.setDisabledTextColor(new Color(0,0,0));

      addContentEtcSubtotalTitle();
    }
    return contentEtcSubtotalTitle;

  }

  /**
   * ���̑���p���v���擾���܂��B
   * @return ���̑���p���v
   */
  public ACTextField getContentEtcSubtotal(){
    if(contentEtcSubtotal==null){

      contentEtcSubtotal = new ACTextField();

      contentEtcSubtotal.setEnabled(false);

      contentEtcSubtotal.setColumns(9);

      contentEtcSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);

      contentEtcSubtotal.setBackground(new Color(230,230,230));

      contentEtcSubtotal.setDisabledTextColor(new Color(0,0,0));

      addContentEtcSubtotal();
    }
    return contentEtcSubtotal;

  }

  /**
   * �X�y�[�T�[���擾���܂��B
   * @return �X�y�[�T�[
   */
  public ACLabel getContentSpace3(){
    if(contentSpace3==null){

      contentSpace3 = new ACLabel();

      contentSpace3.setText(" ");

      addContentSpace3();
    }
    return contentSpace3;

  }

  /**
   * ��ʉ����p�l�����擾���܂��B
   * @return ��ʉ����p�l��
   */
  public ACPanel getContentBottoms(){
    if(contentBottoms==null){

      contentBottoms = new ACPanel();

      addContentBottoms();
    }
    return contentBottoms;

  }

  /**
   * ���z�p�l�����擾���܂��B
   * @return ���z�p�l��
   */
  public ACPanel getContentTotals(){
    if(contentTotals==null){

      contentTotals = new ACPanel();

      addContentTotals();
    }
    return contentTotals;

  }

  /**
   * ���v�z���x�����擾���܂��B
   * @return ���v�z���x��
   */
  public ACLabel getContentTotalLabel(){
    if(contentTotalLabel==null){

      contentTotalLabel = new ACLabel();

      contentTotalLabel.setText("���v�z");

      addContentTotalLabel();
    }
    return contentTotalLabel;

  }

  /**
   * ���v�z���擾���܂��B
   * @return ���v�z
   */
  public ACTextField getContentTotalText(){
    if(contentTotalText==null){

      contentTotalText = new ACTextField();

      contentTotalText.setBindPath("SUM");

      contentTotalText.setEnabled(false);

      contentTotalText.setColumns(10);

      contentTotalText.setHorizontalAlignment(SwingConstants.RIGHT);

      addContentTotalText();
    }
    return contentTotalText;

  }

  /**
   * ��Ô�T���Ώۊz���x�����擾���܂��B
   * @return ��Ô�T���Ώۊz���x��
   */
  public ACLabel getContentKoujyoLabel(){
    if(contentKoujyoLabel==null){

      contentKoujyoLabel = new ACLabel();

      contentKoujyoLabel.setText("������Ô�T���Ώۊz");

      addContentKoujyoLabel();
    }
    return contentKoujyoLabel;

  }

  /**
   * ��Ô�T���Ώۊz���擾���܂��B
   * @return ��Ô�T���Ώۊz
   */
  public ACTextField getContentKoujyoText(){
    if(contentKoujyoText==null){

      contentKoujyoText = new ACTextField();

      contentKoujyoText.setBindPath("KOJO_TARGET");

      contentKoujyoText.setColumns(10);

      contentKoujyoText.setCharType(VRCharType.ONLY_DIGIT);

      contentKoujyoText.setHorizontalAlignment(SwingConstants.RIGHT);

      contentKoujyoText.setIMEMode(InputSubset.LATIN);

      contentKoujyoText.setMaxLength(8);

      addContentKoujyoText();
    }
    return contentKoujyoText;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP003Design() {

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

    this.add(getButtons(), VRLayout.NORTH);

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
  }

  /**
   * �o�^�{�^��(S)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsert(){

  }

  /**
   * �X�V�{�^��(S)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpdate(){

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getContentPatients(), VRLayout.FLOW_RETURN);

    contents.add(getContentProviders(), VRLayout.FLOW_RETURN);

    contents.add(getContentSpace1(), VRLayout.FLOW_RETURN);

    contents.add(getContentJikohutanArea(), VRLayout.FLOW_RETURN);

    contents.add(getContentSpace2(), VRLayout.FLOW_RETURN);

    contents.add(getContentEtcs(), VRLayout.FLOW_RETURN);

    contents.add(getContentSpace3(), VRLayout.FLOW_RETURN);

    contents.add(getContentBottoms(), VRLayout.FLOW_RETURN);

  }

  /**
   * ���p�ҏ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentPatients(){

    contentPatients.add(getContentPatientText(), VRLayout.FLOW_INSETLINE);

    contentPatients.add(getContentPatientID(), VRLayout.FLOW_INSETLINE);

    contentPatients.add(getContentPatientName(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���p�҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentPatientText(){

  }

  /**
   * ���p��ID�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentPatientID(){

  }

  /**
   * ���p�Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentPatientName(){

  }

  /**
   * ���Ə����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentProviders(){

    contentProviders.add(getContentProviderText(), VRLayout.FLOW_INSETLINE);

    contentProviders.add(getContentProviderId(), VRLayout.FLOW_INSETLINE);

    contentProviders.add(getContentProviderName(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentProviderText(){

  }

  /**
   * ���Ə�ID�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentProviderId(){

  }

  /**
   * ���Ə����̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentProviderName(){

  }

  /**
   * �X�y�[�T�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentSpace1(){

  }

  /**
   * ���ȕ��S���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanArea(){

    contentJikohutanArea.add(getContentBill(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutans(), VRLayout.FLOW_RETURN);

    contentJikohutanArea.add(getContentJikohutanTitleArea(), VRLayout.FLOW);

  }

  /**
   * �����Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentBill(){

  }

  /**
   * �S�z���ȕ��S���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutans(){

    contentJikohutans.add(getContentJikohutanHimokuTitle(), VRLayout.FLOW);

    contentJikohutans.add(getContentJikohutanUseTitle(), VRLayout.FLOW_RETURN);

    contentJikohutans.add(getContentJikohutanHimoku1(), VRLayout.FLOW);

    contentJikohutans.add(getContentJikohutanUse1(), VRLayout.FLOW_RETURN);

    contentJikohutans.add(getContentJikohutanHimoku2(), VRLayout.FLOW);

    contentJikohutans.add(getContentJikohutanUse2(), VRLayout.FLOW_RETURN);

    contentJikohutans.add(getContentJikohutanHimoku3(), VRLayout.FLOW);

    contentJikohutans.add(getContentJikohutanUse3(), VRLayout.FLOW_RETURN);

  }

  /**
   * �S�z���ȕ��S�����C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanLayout(){

  }

  /**
   * �S�z���ȕ��S����ڃ^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanHimokuTitle(){

  }

  /**
   * �S�z���ȕ��S�����p���^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanUseTitle(){

  }

  /**
   * �S�z���ȕ��S����ڂP�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanHimoku1(){

  }

  /**
   * �S�z���ȕ��S����ڂP���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanHimoku1Model(){

  }

  /**
   * �S�z���ȕ��S�����p���P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanUse1(){

  }

  /**
   * �S�z���ȕ��S����ڂQ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanHimoku2(){

  }

  /**
   * �S�z���ȕ��S����ڂQ���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanHimoku2Model(){

  }

  /**
   * �S�z���ȕ��S�����p���Q�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanUse2(){

  }

  /**
   * �S�z���ȕ��S����ڂR�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanHimoku3(){

  }

  /**
   * �S�z���ȕ��S����ڂR���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanHimoku3Model(){

  }

  /**
   * �S�z���ȕ��S�����p���R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanUse3(){

  }

  /**
   * �S�z���ȕ��S�^�C�g���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanTitleArea(){

    contentJikohutanTitleArea.add(getContentJikohutanSubtotalTitle(), VRLayout.FLOW);

    contentJikohutanTitleArea.add(getContentJikohutanSubtotal(), VRLayout.FLOW_RETURN);

  }

  /**
   * �S�z���ȕ��S�^�C�g���̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanTitleAreaLayout(){

  }

  /**
   * �S�z���ȕ��S���v�^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanSubtotalTitle(){

  }

  /**
   * �S�z���ȕ��S���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentJikohutanSubtotal(){

  }

  /**
   * �X�y�[�T�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentSpace2(){

  }

  /**
   * ���̑��p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcs(){

    contentEtcs.add(getContentEtcArea(), VRLayout.FLOW_RETURN);

    contentEtcs.add(getContentEtcTitleArea(), VRLayout.FLOW);

  }

  /**
   * ���̑��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcArea(){

    contentEtcArea.add(getContentEtcHimokuTitle(), VRLayout.FLOW);

    contentEtcArea.add(getContentEtcUseTitle(), VRLayout.FLOW_RETURN);

    contentEtcArea.add(getContentEtcHimoku1(), VRLayout.FLOW);

    contentEtcArea.add(getContentEtcUse1(), VRLayout.FLOW_RETURN);

    contentEtcArea.add(getContentEtcHimoku2(), VRLayout.FLOW);

    contentEtcArea.add(getContentEtcUse2(), VRLayout.FLOW_RETURN);

    contentEtcArea.add(getContentEtcHimoku3(), VRLayout.FLOW);

    contentEtcArea.add(getContentEtcUse3(), VRLayout.FLOW_RETURN);

    contentEtcArea.add(getContentEtcHimoku4(), VRLayout.FLOW);

    contentEtcArea.add(getContentEtcUse4(), VRLayout.FLOW_RETURN);

    contentEtcArea.add(getContentEtcHimoku5(), VRLayout.FLOW);

    contentEtcArea.add(getContentEtcUse5(), VRLayout.FLOW_RETURN);

  }

  /**
   * ���C�A�E�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcAreaLayout(){

  }

  /**
   * ���̑���ڃ^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimokuTitle(){

  }

  /**
   * ���̑����p���^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcUseTitle(){

  }

  /**
   * ���̑���ڂP�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimoku1(){

  }

  /**
   * ���̑���ڂP���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimoku1Model(){

  }

  /**
   * ���̑����p���P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcUse1(){

  }

  /**
   * ���̑���ڂQ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimoku2(){

  }

  /**
   * ���̑���ڂQ���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimoku2Model(){

  }

  /**
   * ���̑����p���Q�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcUse2(){

  }

  /**
   * ���̑���ڂR�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimoku3(){

  }

  /**
   * ���̑���ڂR���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimoku3Model(){

  }

  /**
   * ���̑����p���R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcUse3(){

  }

  /**
   * ���̑���ڂS�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimoku4(){

  }

  /**
   * ���̑���ڂS���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimoku4Model(){

  }

  /**
   * ���̑����p���S�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcUse4(){

  }

  /**
   * ���̑���ڂT�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimoku5(){

  }

  /**
   * ���̑���ڂT���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcHimoku5Model(){

  }

  /**
   * ���̑����p���T�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcUse5(){

  }

  /**
   * ���̑��^�C�g���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcTitleArea(){

    contentEtcTitleArea.add(getContentEtcSubtotalTitle(), VRLayout.FLOW);

    contentEtcTitleArea.add(getContentEtcSubtotal(), VRLayout.FLOW_RETURN);

  }

  /**
   * ���C�A�E�g3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcTitleAreaLayout(){

  }

  /**
   * ���̑���p���v�^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcSubtotalTitle(){

  }

  /**
   * ���̑���p���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentEtcSubtotal(){

  }

  /**
   * �X�y�[�T�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentSpace3(){

  }

  /**
   * ��ʉ����p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentBottoms(){

    contentBottoms.add(getContentTotals(), VRLayout.WEST);

  }

  /**
   * ���z�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentTotals(){

    contentTotals.add(getContentTotalLabel(), VRLayout.FLOW_RETURN);

    contentTotals.add(getContentTotalText(), VRLayout.FLOW_RETURN);

    contentTotals.add(getContentKoujyoLabel(), VRLayout.FLOW_RETURN);

    contentTotals.add(getContentKoujyoText(), VRLayout.FLOW);

  }

  /**
   * ���v�z���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentTotalLabel(){

  }

  /**
   * ���v�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentTotalText(){

  }

  /**
   * ��Ô�T���Ώۊz���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentKoujyoLabel(){

  }

  /**
   * ��Ô�T���Ώۊz�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentKoujyoText(){

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
      ACFrame.debugStart(new ACAffairInfo(QP003Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP003Design getThis() {
    return this;
  }
}
