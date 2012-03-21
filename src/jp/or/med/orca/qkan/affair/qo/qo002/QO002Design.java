
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
 * �쐬��: 2012/02/24  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑� (O)
 * �v���Z�X �ی��҈ꗗ�o�^ (002)
 * �v���O���� �ی��҈ꗗ�o�^ (QO002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;
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
 * �ی��҈ꗗ�o�^��ʍ��ڃf�U�C��(QO002) 
 */
public class QO002Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton newData;

  private ACAffairButton clear;

  private ACPanel contents;

  private ACGroupBox insurerSetInfos;

  private ACPanel insurerInfos;

  private ACTextField insurerId;

  private ACLabelContainer insurerIdContainer;

  private ACButton insurerSelectButton;

  private ACTextField insurerName;

  private ACLabelContainer insurerNameContainer;

  private ACLabelContainer insurerZipConteinar;

  private ACTextField insurerZip1;

  private ACLabel insurerZipLabel;

  private ACTextField insurerZip2;

  private ACTextField insurerAddress;

  private ACLabelContainer insurerAddressContainer;

  private ACLabelContainer insurerTelConteinar;

  private ACTextField insurerTel1;

  private ACLabel insurerTelLabel1;

  private ACTextField insurerTel2;

  private ACLabel insurerTelLabel2;

  private ACTextField insurerTel3;

  private ACClearableRadioButtonGroup insurerType;

  private ACLabelContainer insurerTypeContainer;

  private ACListModelAdapter insurerTypeModel;

  private ACRadioButtonItem insurerTypeCare;

  private ACRadioButtonItem insurerTypeMedical;

  private ACLabel insurerTypeInfomation;

  private ACPanel insurerLimitPanel;

  private ACIntegerCheckBox insurerLimitRateEnableCheck;

  private ACGroupBox insurerLimitRateInfos;

  private ACPanel insurerLimitRateInfo;

  private ACPanel insurerLimitRatePanel;

  private ACTable insurerLimitRateTable;

  private VRTableColumnModel insurerLimitRateTableColumnModel;

  private ACTableColumn insurerLimitRateTableColum1;

  private ACTableColumn insurerLimitRateTableColum10;

  private ACTableColumn insurerLimitRateTableColum11;

  private ACTableColumn insurerLimitRateTableColum2;

  private ACTableColumn insurerLimitRateTableColum3;

  private ACTableColumn insurerLimitRateTableColum4;

  private ACTableColumn insurerLimitRateTableColum5;

  private ACTableColumn insurerLimitRateTableColum6;

  private ACTableColumn insurerLimitRateTableColum7;

  private ACTableColumn insurerLimitRateTableColum8;

  private ACTableColumn insurerLimitRateTableColum9;

  private ACPanel validPeriodPanel;

  private ACPanel validPeriodRight;

  private ACPanel insurerLimitRateButtons;

  private ACButton insurerLimitRateRegularButton;

  private ACButton insurerLimitRateInsertButton;

  private ACButton insurerLimitRateEditButton;

  private ACButton insurerLimitRateDeleteButton;

  private ACPanel validPeriodLeft;

  private ACLabelContainer validPeriodCpntena;

  private QkanDateTextField validPeriodStart;

  private ACLabel validPeriodLabel;

  private QkanDateTextField validPeriodEnd;

  private ACTextField yosien1;

  private ACLabelContainer yosien1Container;

  private ACTextField yosien2;

  private ACLabelContainer yosien2Container;

  private ACTextField yosien;

  private ACLabelContainer yosienContainer;

  private ACTextField yokaigo1;

  private ACLabelContainer yokaigo1Container;

  private ACTextField yokaigo2;

  private ACLabelContainer yokaigo2Container;

  private ACTextField yokaigo3;

  private ACLabelContainer yokaigo3Container;

  private ACTextField yokaigo4;

  private ACLabelContainer yokaigo4Container;

  private ACTextField yokaigo5;

  private ACLabelContainer yokaigo5Container;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("�ی��ғo�^");

      addButtons();
    }
    return buttons;

  }

  /**
   * �o�^���擾���܂��B
   * @return �o�^
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
   * �X�V���擾���܂��B
   * @return �X�V
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
   * �V�K���擾���܂��B
   * @return �V�K
   */
  public ACAffairButton getNewData(){
    if(newData==null){

      newData = new ACAffairButton();

      newData.setText("�V�K(N)");

      newData.setToolTipText("�ی��҂�V�K�ɍ쐬���܂��B");

      newData.setMnemonic('N');

      newData.setIconPath(ACConstants.ICON_PATH_NEW_24);

      addNewData();
    }
    return newData;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACAffairButton getClear(){
    if(clear==null){

      clear = new ACAffairButton();

      clear.setText("�N���A(C)");

      clear.setToolTipText("�ی��҂̏����N���A���܂��B");

      clear.setMnemonic('C');

      clear.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClear();
    }
    return clear;

  }

  /**
   * ���͗̈���擾���܂��B
   * @return ���͗̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * �ی��ҏ��ݒ�̈���擾���܂��B
   * @return �ی��ҏ��ݒ�̈�
   */
  public ACGroupBox getInsurerSetInfos(){
    if(insurerSetInfos==null){

      insurerSetInfos = new ACGroupBox();

      insurerSetInfos.setText("��{���");

      insurerSetInfos.setVgap(5);

      addInsurerSetInfos();
    }
    return insurerSetInfos;

  }

  /**
   * �ی��ҏ����͗̈���擾���܂��B
   * @return �ی��ҏ����͗̈�
   */
  public ACPanel getInsurerInfos(){
    if(insurerInfos==null){

      insurerInfos = new ACPanel();

      insurerInfos.setHgap(1);

      addInsurerInfos();
    }
    return insurerInfos;

  }

  /**
   * �ی��Ҕԍ����擾���܂��B
   * @return �ی��Ҕԍ�
   */
  public ACTextField getInsurerId(){
    if(insurerId==null){

      insurerId = new ACTextField();

      getInsurerIdContainer().setText("�ی��Ҕԍ�");

      insurerId.setBindPath("INSURER_ID");

      insurerId.setColumns(5);

      insurerId.setCharType(VRCharType.ONLY_DIGIT);

      insurerId.setHorizontalAlignment(SwingConstants.LEFT);

      insurerId.setIMEMode(InputSubset.LATIN);

      insurerId.setMaxLength(6);

      addInsurerId();
    }
    return insurerId;

  }

  /**
   * �ی��Ҕԍ��R���e�i���擾���܂��B
   * @return �ی��Ҕԍ��R���e�i
   */
  protected ACLabelContainer getInsurerIdContainer(){
    if(insurerIdContainer==null){
      insurerIdContainer = new ACLabelContainer();
      insurerIdContainer.setFollowChildEnabled(true);
      insurerIdContainer.setVAlignment(VRLayout.CENTER);
      insurerIdContainer.add(getInsurerId(), null);
    }
    return insurerIdContainer;
  }

  /**
   * �ی��ґI�����擾���܂��B
   * @return �ی��ґI��
   */
  public ACButton getInsurerSelectButton(){
    if(insurerSelectButton==null){

      insurerSelectButton = new ACButton();

      insurerSelectButton.setText("�ی��ґI��(I)");

      insurerSelectButton.setToolTipText("�ی��҂��ꗗ���I�����܂��B");

      insurerSelectButton.setMnemonic('I');

      addInsurerSelectButton();
    }
    return insurerSelectButton;

  }

  /**
   * �ی��Җ��̂��擾���܂��B
   * @return �ی��Җ���
   */
  public ACTextField getInsurerName(){
    if(insurerName==null){

      insurerName = new ACTextField();

      getInsurerNameContainer().setText("�ی��Җ���");

      insurerName.setBindPath("INSURER_NAME");

      insurerName.setColumns(32);

      insurerName.setHorizontalAlignment(SwingConstants.LEFT);

      insurerName.setIMEMode(InputSubset.KANJI);

      insurerName.setMaxLength(32);

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * �ی��Җ��̃R���e�i���擾���܂��B
   * @return �ی��Җ��̃R���e�i
   */
  protected ACLabelContainer getInsurerNameContainer(){
    if(insurerNameContainer==null){
      insurerNameContainer = new ACLabelContainer();
      insurerNameContainer.setFollowChildEnabled(true);
      insurerNameContainer.setVAlignment(VRLayout.CENTER);
      insurerNameContainer.add(getInsurerName(), null);
    }
    return insurerNameContainer;
  }

  /**
   * �ی��җX�֔ԍ��E�R���e�i���擾���܂��B
   * @return �ی��җX�֔ԍ��E�R���e�i
   */
  public ACLabelContainer getInsurerZipConteinar(){
    if(insurerZipConteinar==null){

      insurerZipConteinar = new ACLabelContainer();

      insurerZipConteinar.setText("�X�֔ԍ�");

      addInsurerZipConteinar();
    }
    return insurerZipConteinar;

  }

  /**
   * �ی��җX�֔ԍ����͗̈�1���擾���܂��B
   * @return �ی��җX�֔ԍ����͗̈�1
   */
  public ACTextField getInsurerZip1(){
    if(insurerZip1==null){

      insurerZip1 = new ACTextField();

      insurerZip1.setBindPath("INSURER_ZIP_FIRST");

      insurerZip1.setColumns(2);

      insurerZip1.setCharType(VRCharType.ONLY_DIGIT);

      insurerZip1.setIMEMode(InputSubset.LATIN);

      insurerZip1.setMaxLength(3);

      addInsurerZip1();
    }
    return insurerZip1;

  }

  /**
   * �ی��җX�֔ԍ����x�����擾���܂��B
   * @return �ی��җX�֔ԍ����x��
   */
  public ACLabel getInsurerZipLabel(){
    if(insurerZipLabel==null){

      insurerZipLabel = new ACLabel();

      insurerZipLabel.setText("-");

      addInsurerZipLabel();
    }
    return insurerZipLabel;

  }

  /**
   * �ی��җX�֔ԍ����͗̈�2���擾���܂��B
   * @return �ی��җX�֔ԍ����͗̈�2
   */
  public ACTextField getInsurerZip2(){
    if(insurerZip2==null){

      insurerZip2 = new ACTextField();

      insurerZip2.setBindPath("INSURER_ZIP_SECOND");

      insurerZip2.setColumns(3);

      insurerZip2.setCharType(VRCharType.ONLY_DIGIT);

      insurerZip2.setIMEMode(InputSubset.LATIN);

      insurerZip2.setMaxLength(4);

      addInsurerZip2();
    }
    return insurerZip2;

  }

  /**
   * �ی��ҏ��ݒn���擾���܂��B
   * @return �ی��ҏ��ݒn
   */
  public ACTextField getInsurerAddress(){
    if(insurerAddress==null){

      insurerAddress = new ACTextField();

      getInsurerAddressContainer().setText("���ݒn");

      insurerAddress.setBindPath("INSURER_ADDRESS");

      insurerAddress.setColumns(64);

      insurerAddress.setHorizontalAlignment(SwingConstants.LEFT);

      insurerAddress.setIMEMode(InputSubset.KANJI);

      insurerAddress.setMaxLength(64);

      addInsurerAddress();
    }
    return insurerAddress;

  }

  /**
   * �ی��ҏ��ݒn�R���e�i���擾���܂��B
   * @return �ی��ҏ��ݒn�R���e�i
   */
  protected ACLabelContainer getInsurerAddressContainer(){
    if(insurerAddressContainer==null){
      insurerAddressContainer = new ACLabelContainer();
      insurerAddressContainer.setFollowChildEnabled(true);
      insurerAddressContainer.setVAlignment(VRLayout.CENTER);
      insurerAddressContainer.add(getInsurerAddress(), null);
    }
    return insurerAddressContainer;
  }

  /**
   * �ی��ғd�b�ԍ��E�R���e�i���擾���܂��B
   * @return �ی��ғd�b�ԍ��E�R���e�i
   */
  public ACLabelContainer getInsurerTelConteinar(){
    if(insurerTelConteinar==null){

      insurerTelConteinar = new ACLabelContainer();

      insurerTelConteinar.setText("�d�b�ԍ�");

      addInsurerTelConteinar();
    }
    return insurerTelConteinar;

  }

  /**
   * �ی��ғd�b�ԍ����͗̈�1���擾���܂��B
   * @return �ی��ғd�b�ԍ����͗̈�1
   */
  public ACTextField getInsurerTel1(){
    if(insurerTel1==null){

      insurerTel1 = new ACTextField();

      insurerTel1.setBindPath("INSURER_TEL_FIRST");

      insurerTel1.setColumns(4);

      insurerTel1.setCharType(VRCharType.ONLY_DIGIT);

      insurerTel1.setIMEMode(InputSubset.LATIN);

      insurerTel1.setMaxLength(6);

      addInsurerTel1();
    }
    return insurerTel1;

  }

  /**
   * �ی��ғd�b�ԍ����x�����擾���܂��B
   * @return �ی��ғd�b�ԍ����x��
   */
  public ACLabel getInsurerTelLabel1(){
    if(insurerTelLabel1==null){

      insurerTelLabel1 = new ACLabel();

      insurerTelLabel1.setText("-");

      addInsurerTelLabel1();
    }
    return insurerTelLabel1;

  }

  /**
   * �ی��ғd�b�ԍ����͗̈�2���擾���܂��B
   * @return �ی��ғd�b�ԍ����͗̈�2
   */
  public ACTextField getInsurerTel2(){
    if(insurerTel2==null){

      insurerTel2 = new ACTextField();

      insurerTel2.setBindPath("INSURER_TEL_SECOND");

      insurerTel2.setColumns(3);

      insurerTel2.setCharType(VRCharType.ONLY_DIGIT);

      insurerTel2.setIMEMode(InputSubset.LATIN);

      insurerTel2.setMaxLength(4);

      addInsurerTel2();
    }
    return insurerTel2;

  }

  /**
   * �ی��ғd�b�ԍ����x�����擾���܂��B
   * @return �ی��ғd�b�ԍ����x��
   */
  public ACLabel getInsurerTelLabel2(){
    if(insurerTelLabel2==null){

      insurerTelLabel2 = new ACLabel();

      insurerTelLabel2.setText("-");

      addInsurerTelLabel2();
    }
    return insurerTelLabel2;

  }

  /**
   * �ی��ғd�b�ԍ����͗̈�3���擾���܂��B
   * @return �ی��ғd�b�ԍ����͗̈�3
   */
  public ACTextField getInsurerTel3(){
    if(insurerTel3==null){

      insurerTel3 = new ACTextField();

      insurerTel3.setBindPath("INSURER_TEL_THIRD");

      insurerTel3.setColumns(3);

      insurerTel3.setCharType(VRCharType.ONLY_DIGIT);

      insurerTel3.setIMEMode(InputSubset.LATIN);

      insurerTel3.setMaxLength(4);

      addInsurerTel3();
    }
    return insurerTel3;

  }

  /**
   * �ی��ҋ敪���擾���܂��B
   * @return �ی��ҋ敪
   */
  public ACClearableRadioButtonGroup getInsurerType(){
    if(insurerType==null){

      insurerType = new ACClearableRadioButtonGroup();

      getInsurerTypeContainer().setText("�ی��ҋ敪");

      insurerType.setBindPath("INSURER_TYPE");

      insurerType.setModel(getInsurerTypeModel());

      addInsurerType();
    }
    return insurerType;

  }

  /**
   * �ی��ҋ敪�R���e�i���擾���܂��B
   * @return �ی��ҋ敪�R���e�i
   */
  protected ACLabelContainer getInsurerTypeContainer(){
    if(insurerTypeContainer==null){
      insurerTypeContainer = new ACLabelContainer();
      insurerTypeContainer.setFollowChildEnabled(true);
      insurerTypeContainer.setVAlignment(VRLayout.CENTER);
      insurerTypeContainer.add(getInsurerType(), null);
    }
    return insurerTypeContainer;
  }

  /**
   * �ی��ҋ敪���f�����擾���܂��B
   * @return �ی��ҋ敪���f��
   */
  protected ACListModelAdapter getInsurerTypeModel(){
    if(insurerTypeModel==null){
      insurerTypeModel = new ACListModelAdapter();
      addInsurerTypeModel();
    }
    return insurerTypeModel;
  }

  /**
   * �����擾���܂��B
   * @return ���
   */
  public ACRadioButtonItem getInsurerTypeCare(){
    if(insurerTypeCare==null){

      insurerTypeCare = new ACRadioButtonItem();

      insurerTypeCare.setText("���");

      insurerTypeCare.setGroup(getInsurerType());

      addInsurerTypeCare();
    }
    return insurerTypeCare;

  }

  /**
   * ��Â��擾���܂��B
   * @return ���
   */
  public ACRadioButtonItem getInsurerTypeMedical(){
    if(insurerTypeMedical==null){

      insurerTypeMedical = new ACRadioButtonItem();

      insurerTypeMedical.setText("���");

      insurerTypeMedical.setGroup(getInsurerType());

      addInsurerTypeMedical();
    }
    return insurerTypeMedical;

  }

  /**
   * �ی��ҋ敪�������擾���܂��B
   * @return �ی��ҋ敪����
   */
  public ACLabel getInsurerTypeInfomation(){
    if(insurerTypeInfomation==null){

      insurerTypeInfomation = new ACLabel();

      insurerTypeInfomation.setText("����̕ی��Ҕԍ��ŉ��ƈ�Â�Ώۂɂ��Ă���ی��҂́A�N���A�{�^���ŕی��ҋ敪�𖢑I����Ԃɂ��ēo�^���܂��B");

      insurerTypeInfomation.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addInsurerTypeInfomation();
    }
    return insurerTypeInfomation;

  }

  /**
   * �p�l�����擾���܂��B
   * @return �p�l��
   */
  public ACPanel getInsurerLimitPanel(){
    if(insurerLimitPanel==null){

      insurerLimitPanel = new ACPanel();

      addInsurerLimitPanel();
    }
    return insurerLimitPanel;

  }

  /**
   * �x�����x�z�L���؂�ւ��`�F�b�N���擾���܂��B
   * @return �x�����x�z�L���؂�ւ��`�F�b�N
   */
  public ACIntegerCheckBox getInsurerLimitRateEnableCheck(){
    if(insurerLimitRateEnableCheck==null){

      insurerLimitRateEnableCheck = new ACIntegerCheckBox();

      insurerLimitRateEnableCheck.setText("�敪�x�����x�z��ύX����");

      addInsurerLimitRateEnableCheck();
    }
    return insurerLimitRateEnableCheck;

  }

  /**
   * �ی��Ҏx�����x�z���̈���擾���܂��B
   * @return �ی��Ҏx�����x�z���̈�
   */
  public ACGroupBox getInsurerLimitRateInfos(){
    if(insurerLimitRateInfos==null){

      insurerLimitRateInfos = new ACGroupBox();

      insurerLimitRateInfos.setText("�敪�x�����x�z���");

      insurerLimitRateInfos.setFollowChildEnabled(true);

      insurerLimitRateInfos.setVgap(5);

      addInsurerLimitRateInfos();
    }
    return insurerLimitRateInfos;

  }

  /**
   * �ی��Ҏx�����x�z���p�l�����擾���܂��B
   * @return �ی��Ҏx�����x�z���p�l��
   */
  public ACPanel getInsurerLimitRateInfo(){
    if(insurerLimitRateInfo==null){

      insurerLimitRateInfo = new ACPanel();

      insurerLimitRateInfo.setEnabled(false);

      insurerLimitRateInfo.setAutoWrap(false);

      insurerLimitRateInfo.setFollowChildEnabled(true);

      insurerLimitRateInfo.setHgap(0);

      insurerLimitRateInfo.setLabelMargin(0);

      insurerLimitRateInfo.setVgap(5);

      addInsurerLimitRateInfo();
    }
    return insurerLimitRateInfo;

  }

  /**
   * �x�����x�z���p�l�����擾���܂��B
   * @return �x�����x�z���p�l��
   */
  public ACPanel getInsurerLimitRatePanel(){
    if(insurerLimitRatePanel==null){

      insurerLimitRatePanel = new ACPanel();

      insurerLimitRatePanel.setFollowChildEnabled(true);

      addInsurerLimitRatePanel();
    }
    return insurerLimitRatePanel;

  }

  /**
   * �x�����x�z���e�[�u�����擾���܂��B
   * @return �x�����x�z���e�[�u��
   */
  public ACTable getInsurerLimitRateTable(){
    if(insurerLimitRateTable==null){

      insurerLimitRateTable = new ACTable();

      insurerLimitRateTable.setColumnModel(getInsurerLimitRateTableColumnModel());

      addInsurerLimitRateTable();
    }
    return insurerLimitRateTable;

  }

  /**
   * �x�����x�z���e�[�u���J�������f�����擾���܂��B
   * @return �x�����x�z���e�[�u���J�������f��
   */
  protected VRTableColumnModel getInsurerLimitRateTableColumnModel(){
    if(insurerLimitRateTableColumnModel==null){
      insurerLimitRateTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addInsurerLimitRateTableColumnModel();
    }
    return insurerLimitRateTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getInsurerLimitRateTableColum1(){
    if(insurerLimitRateTableColum1==null){

      insurerLimitRateTableColum1 = new ACTableColumn();

      insurerLimitRateTableColum1.setHeaderValue("No.");

      insurerLimitRateTableColum1.setColumns(3);

      insurerLimitRateTableColum1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      insurerLimitRateTableColum1.setSortable(false);

      addInsurerLimitRateTableColum1();
    }
    return insurerLimitRateTableColum1;

  }

  /**
   * �v�x��1���擾���܂��B
   * @return �v�x��1
   */
  public ACTableColumn getInsurerLimitRateTableColum10(){
    if(insurerLimitRateTableColum10==null){

      insurerLimitRateTableColum10 = new ACTableColumn(0);

      insurerLimitRateTableColum10.setHeaderValue("�v�x��1");

      insurerLimitRateTableColum10.setColumns(6);

      addInsurerLimitRateTableColum10();
    }
    return insurerLimitRateTableColum10;

  }

  /**
   * �v�x��2���擾���܂��B
   * @return �v�x��2
   */
  public ACTableColumn getInsurerLimitRateTableColum11(){
    if(insurerLimitRateTableColum11==null){

      insurerLimitRateTableColum11 = new ACTableColumn(1);

      insurerLimitRateTableColum11.setHeaderValue("�v�x��2");

      insurerLimitRateTableColum11.setColumns(7);

      addInsurerLimitRateTableColum11();
    }
    return insurerLimitRateTableColum11;

  }

  /**
   * �o�ߓI�v�����擾���܂��B
   * @return �o�ߓI�v���
   */
  public ACTableColumn getInsurerLimitRateTableColum2(){
    if(insurerLimitRateTableColum2==null){

      insurerLimitRateTableColum2 = new ACTableColumn(2);

      insurerLimitRateTableColum2.setHeaderValue("�o�ߓI�v���");

      insurerLimitRateTableColum2.setColumns(7);

      addInsurerLimitRateTableColum2();
    }
    return insurerLimitRateTableColum2;

  }

  /**
   * �v���1���擾���܂��B
   * @return �v���1
   */
  public ACTableColumn getInsurerLimitRateTableColum3(){
    if(insurerLimitRateTableColum3==null){

      insurerLimitRateTableColum3 = new ACTableColumn(3);

      insurerLimitRateTableColum3.setHeaderValue("�v���1");

      insurerLimitRateTableColum3.setColumns(7);

      addInsurerLimitRateTableColum3();
    }
    return insurerLimitRateTableColum3;

  }

  /**
   * �v���2���擾���܂��B
   * @return �v���2
   */
  public ACTableColumn getInsurerLimitRateTableColum4(){
    if(insurerLimitRateTableColum4==null){

      insurerLimitRateTableColum4 = new ACTableColumn(4);

      insurerLimitRateTableColum4.setHeaderValue("�v���2");

      insurerLimitRateTableColum4.setColumns(7);

      addInsurerLimitRateTableColum4();
    }
    return insurerLimitRateTableColum4;

  }

  /**
   * �v���3���擾���܂��B
   * @return �v���3
   */
  public ACTableColumn getInsurerLimitRateTableColum5(){
    if(insurerLimitRateTableColum5==null){

      insurerLimitRateTableColum5 = new ACTableColumn(5);

      insurerLimitRateTableColum5.setHeaderValue("�v���3");

      insurerLimitRateTableColum5.setColumns(7);

      addInsurerLimitRateTableColum5();
    }
    return insurerLimitRateTableColum5;

  }

  /**
   * �v���4���擾���܂��B
   * @return �v���4
   */
  public ACTableColumn getInsurerLimitRateTableColum6(){
    if(insurerLimitRateTableColum6==null){

      insurerLimitRateTableColum6 = new ACTableColumn(6);

      insurerLimitRateTableColum6.setHeaderValue("�v���4");

      insurerLimitRateTableColum6.setColumns(7);

      addInsurerLimitRateTableColum6();
    }
    return insurerLimitRateTableColum6;

  }

  /**
   * �v���5���擾���܂��B
   * @return �v���5
   */
  public ACTableColumn getInsurerLimitRateTableColum7(){
    if(insurerLimitRateTableColum7==null){

      insurerLimitRateTableColum7 = new ACTableColumn(7);

      insurerLimitRateTableColum7.setHeaderValue("�v���5");

      insurerLimitRateTableColum7.setColumns(7);

      addInsurerLimitRateTableColum7();
    }
    return insurerLimitRateTableColum7;

  }

  /**
   * �ی��ҏ��L������(�J�n�j���擾���܂��B
   * @return �ی��ҏ��L������(�J�n�j
   */
  public ACTableColumn getInsurerLimitRateTableColum8(){
    if(insurerLimitRateTableColum8==null){

      insurerLimitRateTableColum8 = new ACTableColumn(8);

      insurerLimitRateTableColum8.setHeaderValue("�L������(�J�n�j");

      insurerLimitRateTableColum8.setColumns(12);

      insurerLimitRateTableColum8.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addInsurerLimitRateTableColum8();
    }
    return insurerLimitRateTableColum8;

  }

  /**
   * �ی��ҏ��L������(�I���j���擾���܂��B
   * @return �ی��ҏ��L������(�I���j
   */
  public ACTableColumn getInsurerLimitRateTableColum9(){
    if(insurerLimitRateTableColum9==null){

      insurerLimitRateTableColum9 = new ACTableColumn(9);

      insurerLimitRateTableColum9.setHeaderValue("�L������(�I���j");

      insurerLimitRateTableColum9.setColumns(12);

      insurerLimitRateTableColum9.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addInsurerLimitRateTableColum9();
    }
    return insurerLimitRateTableColum9;

  }

  /**
   * �L�����ԗ̈���擾���܂��B
   * @return �L�����ԗ̈�
   */
  public ACPanel getValidPeriodPanel(){
    if(validPeriodPanel==null){

      validPeriodPanel = new ACPanel();

      validPeriodPanel.setAutoWrap(false);

      validPeriodPanel.setFollowChildEnabled(true);

      addValidPeriodPanel();
    }
    return validPeriodPanel;

  }

  /**
   * �L�����ԗ̈�E���擾���܂��B
   * @return �L�����ԗ̈�E
   */
  public ACPanel getValidPeriodRight(){
    if(validPeriodRight==null){

      validPeriodRight = new ACPanel();

      validPeriodRight.setFollowChildEnabled(true);

      addValidPeriodRight();
    }
    return validPeriodRight;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getInsurerLimitRateButtons(){
    if(insurerLimitRateButtons==null){

      insurerLimitRateButtons = new ACPanel();

      insurerLimitRateButtons.setFollowChildEnabled(true);

      addInsurerLimitRateButtons();
    }
    return insurerLimitRateButtons;

  }

  /**
   * �K����擾���܂��B
   * @return �K��
   */
  public ACButton getInsurerLimitRateRegularButton(){
    if(insurerLimitRateRegularButton==null){

      insurerLimitRateRegularButton = new ACButton();

      insurerLimitRateRegularButton.setText("�K��");

      insurerLimitRateRegularButton.setToolTipText("�����J���ȋK��̎x�����x�z��ݒ肵�܂��B");

      insurerLimitRateRegularButton.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addInsurerLimitRateRegularButton();
    }
    return insurerLimitRateRegularButton;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getInsurerLimitRateInsertButton(){
    if(insurerLimitRateInsertButton==null){

      insurerLimitRateInsertButton = new ACButton();

      insurerLimitRateInsertButton.setText("�ǉ�");

      insurerLimitRateInsertButton.setToolTipText("�ی��҂̎x�����x�z����ǉ����܂��B");

      insurerLimitRateInsertButton.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addInsurerLimitRateInsertButton();
    }
    return insurerLimitRateInsertButton;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getInsurerLimitRateEditButton(){
    if(insurerLimitRateEditButton==null){

      insurerLimitRateEditButton = new ACButton();

      insurerLimitRateEditButton.setText("����");

      insurerLimitRateEditButton.setToolTipText("�I�𒆂̎x�����x�z����ҏW���܂��B");

      insurerLimitRateEditButton.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addInsurerLimitRateEditButton();
    }
    return insurerLimitRateEditButton;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getInsurerLimitRateDeleteButton(){
    if(insurerLimitRateDeleteButton==null){

      insurerLimitRateDeleteButton = new ACButton();

      insurerLimitRateDeleteButton.setText("�폜");

      insurerLimitRateDeleteButton.setToolTipText("�I�𒆂̕ی��҂̑S�����폜���܂��B");

      insurerLimitRateDeleteButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addInsurerLimitRateDeleteButton();
    }
    return insurerLimitRateDeleteButton;

  }

  /**
   * �L�����ԗ̈捶���擾���܂��B
   * @return �L�����ԗ̈捶
   */
  public ACPanel getValidPeriodLeft(){
    if(validPeriodLeft==null){

      validPeriodLeft = new ACPanel();

      validPeriodLeft.setAutoWrap(true);

      validPeriodLeft.setFollowChildEnabled(true);

      validPeriodLeft.setHgap(0);

      validPeriodLeft.setLabelMargin(0);

      addValidPeriodLeft();
    }
    return validPeriodLeft;

  }

  /**
   * �L�����ԃR���e�i���擾���܂��B
   * @return �L�����ԃR���e�i
   */
  public ACLabelContainer getValidPeriodCpntena(){
    if(validPeriodCpntena==null){

      validPeriodCpntena = new ACLabelContainer();

      validPeriodCpntena.setText("�L������");

      validPeriodCpntena.setFollowChildEnabled(true);

      addValidPeriodCpntena();
    }
    return validPeriodCpntena;

  }

  /**
   * �L�����ԃe�L�X�g�i�J�n�j���擾���܂��B
   * @return �L�����ԃe�L�X�g�i�J�n�j
   */
  public QkanDateTextField getValidPeriodStart(){
    if(validPeriodStart==null){

      validPeriodStart = new QkanDateTextField();

      validPeriodStart.setBindPath("LIMIT_RATE_VALID_START");

      addValidPeriodStart();
    }
    return validPeriodStart;

  }

  /**
   * �L�����ԁE���x�����擾���܂��B
   * @return �L�����ԁE���x��
   */
  public ACLabel getValidPeriodLabel(){
    if(validPeriodLabel==null){

      validPeriodLabel = new ACLabel();

      validPeriodLabel.setText("����");

      addValidPeriodLabel();
    }
    return validPeriodLabel;

  }

  /**
   * �L�����ԃe�L�X�g�i�I���j���擾���܂��B
   * @return �L�����ԃe�L�X�g�i�I���j
   */
  public QkanDateTextField getValidPeriodEnd(){
    if(validPeriodEnd==null){

      validPeriodEnd = new QkanDateTextField();

      validPeriodEnd.setBindPath("LIMIT_RATE_VALID_END");

      addValidPeriodEnd();
    }
    return validPeriodEnd;

  }

  /**
   * �v�x��1�e�L�X�g���擾���܂��B
   * @return �v�x��1�e�L�X�g
   */
  public ACTextField getYosien1(){
    if(yosien1==null){

      yosien1 = new ACTextField();

      getYosien1Container().setText("�v�x���P");

      yosien1.setBindPath("12");

      yosien1.setColumns(4);

      yosien1.setCharType(VRCharType.ONLY_DIGIT);

      yosien1.setHorizontalAlignment(SwingConstants.RIGHT);

      yosien1.setIMEMode(InputSubset.LATIN);

      yosien1.setMaxLength(5);

      addYosien1();
    }
    return yosien1;

  }

  /**
   * �v�x��1�e�L�X�g�R���e�i���擾���܂��B
   * @return �v�x��1�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getYosien1Container(){
    if(yosien1Container==null){
      yosien1Container = new ACLabelContainer();
      yosien1Container.setFollowChildEnabled(true);
      yosien1Container.setVAlignment(VRLayout.CENTER);
      yosien1Container.add(getYosien1(), null);
    }
    return yosien1Container;
  }

  /**
   * �v�x��2�e�L�X�g���擾���܂��B
   * @return �v�x��2�e�L�X�g
   */
  public ACTextField getYosien2(){
    if(yosien2==null){

      yosien2 = new ACTextField();

      getYosien2Container().setText("�v�x���Q");

      yosien2.setBindPath("13");

      yosien2.setColumns(4);

      yosien2.setCharType(VRCharType.ONLY_DIGIT);

      yosien2.setHorizontalAlignment(SwingConstants.RIGHT);

      yosien2.setIMEMode(InputSubset.LATIN);

      yosien2.setMaxLength(5);

      addYosien2();
    }
    return yosien2;

  }

  /**
   * �v�x��2�e�L�X�g�R���e�i���擾���܂��B
   * @return �v�x��2�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getYosien2Container(){
    if(yosien2Container==null){
      yosien2Container = new ACLabelContainer();
      yosien2Container.setFollowChildEnabled(true);
      yosien2Container.setVAlignment(VRLayout.CENTER);
      yosien2Container.add(getYosien2(), null);
    }
    return yosien2Container;
  }

  /**
   * �o�ߓI�v���e�L�X�g���擾���܂��B
   * @return �o�ߓI�v���e�L�X�g
   */
  public ACTextField getYosien(){
    if(yosien==null){

      yosien = new ACTextField();

      getYosienContainer().setText("�o�ߓI�v���");

      yosien.setBindPath("11");

      yosien.setColumns(4);

      yosien.setCharType(VRCharType.ONLY_DIGIT);

      yosien.setHorizontalAlignment(SwingConstants.RIGHT);

      yosien.setIMEMode(InputSubset.LATIN);

      yosien.setMaxLength(5);

      addYosien();
    }
    return yosien;

  }

  /**
   * �o�ߓI�v���e�L�X�g�R���e�i���擾���܂��B
   * @return �o�ߓI�v���e�L�X�g�R���e�i
   */
  protected ACLabelContainer getYosienContainer(){
    if(yosienContainer==null){
      yosienContainer = new ACLabelContainer();
      yosienContainer.setFollowChildEnabled(true);
      yosienContainer.setVAlignment(VRLayout.CENTER);
      yosienContainer.add(getYosien(), null);
    }
    return yosienContainer;
  }

  /**
   * �v���x1�e�L�X�g���擾���܂��B
   * @return �v���x1�e�L�X�g
   */
  public ACTextField getYokaigo1(){
    if(yokaigo1==null){

      yokaigo1 = new ACTextField();

      getYokaigo1Container().setText("�v���P");

      yokaigo1.setBindPath("21");

      yokaigo1.setColumns(4);

      yokaigo1.setCharType(VRCharType.ONLY_DIGIT);

      yokaigo1.setHorizontalAlignment(SwingConstants.RIGHT);

      yokaigo1.setIMEMode(InputSubset.LATIN);

      yokaigo1.setMaxLength(5);

      addYokaigo1();
    }
    return yokaigo1;

  }

  /**
   * �v���x1�e�L�X�g�R���e�i���擾���܂��B
   * @return �v���x1�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getYokaigo1Container(){
    if(yokaigo1Container==null){
      yokaigo1Container = new ACLabelContainer();
      yokaigo1Container.setFollowChildEnabled(true);
      yokaigo1Container.setVAlignment(VRLayout.CENTER);
      yokaigo1Container.add(getYokaigo1(), null);
    }
    return yokaigo1Container;
  }

  /**
   * �v���x2�e�L�X�g���擾���܂��B
   * @return �v���x2�e�L�X�g
   */
  public ACTextField getYokaigo2(){
    if(yokaigo2==null){

      yokaigo2 = new ACTextField();

      getYokaigo2Container().setText("�v���Q");

      yokaigo2.setBindPath("22");

      yokaigo2.setColumns(4);

      yokaigo2.setCharType(VRCharType.ONLY_DIGIT);

      yokaigo2.setHorizontalAlignment(SwingConstants.RIGHT);

      yokaigo2.setIMEMode(InputSubset.LATIN);

      yokaigo2.setMaxLength(5);

      addYokaigo2();
    }
    return yokaigo2;

  }

  /**
   * �v���x2�e�L�X�g�R���e�i���擾���܂��B
   * @return �v���x2�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getYokaigo2Container(){
    if(yokaigo2Container==null){
      yokaigo2Container = new ACLabelContainer();
      yokaigo2Container.setFollowChildEnabled(true);
      yokaigo2Container.setVAlignment(VRLayout.CENTER);
      yokaigo2Container.add(getYokaigo2(), null);
    }
    return yokaigo2Container;
  }

  /**
   * �v���x3�e�L�X�g���擾���܂��B
   * @return �v���x3�e�L�X�g
   */
  public ACTextField getYokaigo3(){
    if(yokaigo3==null){

      yokaigo3 = new ACTextField();

      getYokaigo3Container().setText("�v���R");

      yokaigo3.setBindPath("23");

      yokaigo3.setColumns(4);

      yokaigo3.setCharType(VRCharType.ONLY_DIGIT);

      yokaigo3.setHorizontalAlignment(SwingConstants.RIGHT);

      yokaigo3.setIMEMode(InputSubset.LATIN);

      yokaigo3.setMaxLength(5);

      addYokaigo3();
    }
    return yokaigo3;

  }

  /**
   * �v���x3�e�L�X�g�R���e�i���擾���܂��B
   * @return �v���x3�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getYokaigo3Container(){
    if(yokaigo3Container==null){
      yokaigo3Container = new ACLabelContainer();
      yokaigo3Container.setFollowChildEnabled(true);
      yokaigo3Container.setVAlignment(VRLayout.CENTER);
      yokaigo3Container.add(getYokaigo3(), null);
    }
    return yokaigo3Container;
  }

  /**
   * �v���x4�e�L�X�g���擾���܂��B
   * @return �v���x4�e�L�X�g
   */
  public ACTextField getYokaigo4(){
    if(yokaigo4==null){

      yokaigo4 = new ACTextField();

      getYokaigo4Container().setText("�v���S");

      yokaigo4.setBindPath("24");

      yokaigo4.setColumns(4);

      yokaigo4.setCharType(VRCharType.ONLY_DIGIT);

      yokaigo4.setHorizontalAlignment(SwingConstants.RIGHT);

      yokaigo4.setIMEMode(InputSubset.LATIN);

      yokaigo4.setMaxLength(5);

      addYokaigo4();
    }
    return yokaigo4;

  }

  /**
   * �v���x4�e�L�X�g�R���e�i���擾���܂��B
   * @return �v���x4�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getYokaigo4Container(){
    if(yokaigo4Container==null){
      yokaigo4Container = new ACLabelContainer();
      yokaigo4Container.setFollowChildEnabled(true);
      yokaigo4Container.setVAlignment(VRLayout.CENTER);
      yokaigo4Container.add(getYokaigo4(), null);
    }
    return yokaigo4Container;
  }

  /**
   * �v���x5�e�L�X�g���擾���܂��B
   * @return �v���x5�e�L�X�g
   */
  public ACTextField getYokaigo5(){
    if(yokaigo5==null){

      yokaigo5 = new ACTextField();

      getYokaigo5Container().setText("�v���T");

      yokaigo5.setBindPath("25");

      yokaigo5.setColumns(4);

      yokaigo5.setCharType(VRCharType.ONLY_DIGIT);

      yokaigo5.setHorizontalAlignment(SwingConstants.RIGHT);

      yokaigo5.setIMEMode(InputSubset.LATIN);

      yokaigo5.setMaxLength(5);

      addYokaigo5();
    }
    return yokaigo5;

  }

  /**
   * �v���x5�e�L�X�g�R���e�i���擾���܂��B
   * @return �v���x5�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getYokaigo5Container(){
    if(yokaigo5Container==null){
      yokaigo5Container = new ACLabelContainer();
      yokaigo5Container.setFollowChildEnabled(true);
      yokaigo5Container.setVAlignment(VRLayout.CENTER);
      yokaigo5Container.add(getYokaigo5(), null);
    }
    return yokaigo5Container;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO002Design() {

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

    buttons.add(getClear(), VRLayout.EAST);
    buttons.add(getNewData(), VRLayout.EAST);
    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
  }

  /**
   * �o�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsert(){

  }

  /**
   * �X�V�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpdate(){

  }

  /**
   * �V�K�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNewData(){

  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClear(){

  }

  /**
   * ���͗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getInsurerSetInfos(), VRLayout.NORTH);

    contents.add(getInsurerLimitPanel(), VRLayout.NORTH);

    contents.add(getInsurerLimitRateInfos(), VRLayout.NORTH);

  }

  /**
   * �ی��ҏ��ݒ�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerSetInfos(){

    insurerSetInfos.add(getInsurerInfos(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ی��ҏ����͗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerInfos(){

    insurerInfos.add(getInsurerIdContainer(), VRLayout.FLOW_INSETLINE);

    insurerInfos.add(getInsurerSelectButton(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerInfos.add(getInsurerNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerInfos.add(getInsurerZipConteinar(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerInfos.add(getInsurerAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerInfos.add(getInsurerTelConteinar(), VRLayout.FLOW_INSETLINE_RETURN);

    insurerInfos.add(getInsurerTypeContainer(), VRLayout.FLOW_INSETLINE);

    insurerInfos.add(getInsurerTypeInfomation(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerId(){

  }

  /**
   * �ی��ґI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerSelectButton(){

  }

  /**
   * �ی��Җ��̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerName(){

  }

  /**
   * �ی��җX�֔ԍ��E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerZipConteinar(){

    insurerZipConteinar.add(getInsurerZip1(), VRLayout.FLOW);

    insurerZipConteinar.add(getInsurerZipLabel(), VRLayout.FLOW);

    insurerZipConteinar.add(getInsurerZip2(), VRLayout.FLOW);

  }

  /**
   * �ی��җX�֔ԍ����͗̈�1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerZip1(){

  }

  /**
   * �ی��җX�֔ԍ����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerZipLabel(){

  }

  /**
   * �ی��җX�֔ԍ����͗̈�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerZip2(){

  }

  /**
   * �ی��ҏ��ݒn�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerAddress(){

  }

  /**
   * �ی��ғd�b�ԍ��E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTelConteinar(){

    insurerTelConteinar.add(getInsurerTel1(), VRLayout.FLOW);

    insurerTelConteinar.add(getInsurerTelLabel1(), VRLayout.FLOW);

    insurerTelConteinar.add(getInsurerTel2(), VRLayout.FLOW);

    insurerTelConteinar.add(getInsurerTelLabel2(), VRLayout.FLOW);

    insurerTelConteinar.add(getInsurerTel3(), VRLayout.FLOW);

  }

  /**
   * �ی��ғd�b�ԍ����͗̈�1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTel1(){

  }

  /**
   * �ی��ғd�b�ԍ����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTelLabel1(){

  }

  /**
   * �ی��ғd�b�ԍ����͗̈�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTel2(){

  }

  /**
   * �ی��ғd�b�ԍ����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTelLabel2(){

  }

  /**
   * �ی��ғd�b�ԍ����͗̈�3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTel3(){

  }

  /**
   * �ی��ҋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerType(){

  }

  /**
   * �ی��ҋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTypeModel(){

    getInsurerTypeCare().setButtonIndex(1);

    getInsurerTypeModel().add(getInsurerTypeCare());

    getInsurerTypeMedical().setButtonIndex(2);

    getInsurerTypeModel().add(getInsurerTypeMedical());

  }

  /**
   * ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTypeCare(){

  }

  /**
   * ��Âɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTypeMedical(){

  }

  /**
   * �ی��ҋ敪�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerTypeInfomation(){

  }

  /**
   * �p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitPanel(){

    insurerLimitPanel.add(getInsurerLimitRateEnableCheck(), VRLayout.FLOW_RETURN);

  }

  /**
   * �x�����x�z�L���؂�ւ��`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateEnableCheck(){

  }

  /**
   * �ی��Ҏx�����x�z���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateInfos(){

    insurerLimitRateInfos.add(getInsurerLimitRateInfo(), VRLayout.CLIENT);

  }

  /**
   * �ی��Ҏx�����x�z���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateInfo(){

    insurerLimitRateInfo.add(getInsurerLimitRatePanel(), VRLayout.NORTH);

    insurerLimitRateInfo.add(getValidPeriodPanel(), VRLayout.CLIENT);

  }

  /**
   * �x�����x�z���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRatePanel(){

    insurerLimitRatePanel.add(getInsurerLimitRateTable(), VRLayout.CLIENT);

  }

  /**
   * �x�����x�z���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTable(){

  }

  /**
   * �x�����x�z���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColumnModel(){

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum1());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum10());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum11());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum2());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum3());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum4());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum5());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum6());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum7());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum8());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum9());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum1(){

  }

  /**
   * �v�x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum10(){

  }

  /**
   * �v�x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum11(){

  }

  /**
   * �o�ߓI�v���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum2(){

  }

  /**
   * �v���1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum3(){

  }

  /**
   * �v���2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum4(){

  }

  /**
   * �v���3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum5(){

  }

  /**
   * �v���4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum6(){

  }

  /**
   * �v���5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum7(){

  }

  /**
   * �ی��ҏ��L������(�J�n�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum8(){

  }

  /**
   * �ی��ҏ��L������(�I���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum9(){

  }

  /**
   * �L�����ԗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodPanel(){

    validPeriodPanel.add(getValidPeriodRight(), VRLayout.NORTH);

    validPeriodPanel.add(getValidPeriodLeft(), VRLayout.NORTH);

  }

  /**
   * �L�����ԗ̈�E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodRight(){

    validPeriodRight.add(getInsurerLimitRateButtons(), VRLayout.EAST);
  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateButtons(){

    insurerLimitRateButtons.add(getInsurerLimitRateDeleteButton(), VRLayout.EAST);
    insurerLimitRateButtons.add(getInsurerLimitRateEditButton(), VRLayout.EAST);
    insurerLimitRateButtons.add(getInsurerLimitRateInsertButton(), VRLayout.EAST);
    insurerLimitRateButtons.add(getInsurerLimitRateRegularButton(), VRLayout.EAST);
  }

  /**
   * �K��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateRegularButton(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateInsertButton(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateEditButton(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateDeleteButton(){

  }

  /**
   * �L�����ԗ̈捶�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodLeft(){

    validPeriodLeft.add(getValidPeriodCpntena(), VRLayout.FLOW_RETURN);

    validPeriodLeft.add(getYosien1Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYosien2Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYosienContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    validPeriodLeft.add(getYokaigo1Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo2Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo3Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo4Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo5Container(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �L�����ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodCpntena(){

    validPeriodCpntena.add(getValidPeriodStart(), VRLayout.FLOW);

    validPeriodCpntena.add(getValidPeriodLabel(), VRLayout.FLOW);

    validPeriodCpntena.add(getValidPeriodEnd(), VRLayout.FLOW);

  }

  /**
   * �L�����ԃe�L�X�g�i�J�n�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodStart(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodLabel(){

  }

  /**
   * �L�����ԃe�L�X�g�i�I���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodEnd(){

  }

  /**
   * �v�x��1�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYosien1(){

  }

  /**
   * �v�x��2�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYosien2(){

  }

  /**
   * �o�ߓI�v���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYosien(){

  }

  /**
   * �v���x1�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigo1(){

  }

  /**
   * �v���x2�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigo2(){

  }

  /**
   * �v���x3�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigo3(){

  }

  /**
   * �v���x4�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigo4(){

  }

  /**
   * �v���x5�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigo5(){

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
      ACFrame.debugStart(new ACAffairInfo(QO002Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO002Design getThis() {
    return this;
  }
}
