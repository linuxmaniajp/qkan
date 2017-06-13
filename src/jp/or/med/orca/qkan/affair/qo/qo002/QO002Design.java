
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
 * �쐬��: 2016/09/29  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
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

  private ACListModelAdapter insurerTypeModel;

  private ACRadioButtonItem insurerTypeCare;

  private ACRadioButtonItem insurerTypeMedical;

  private ACLabel insurerTypeInfomation;

  private JTabbedPane tabs;

  private ACPanel tabInsurerUnitPrice;

  private ACPanel insurerUnitPricePanel;

  private ACGroupBox insurerUnitPriceInfos;

  private ACPanel unitPriceSetInfos;

  private ACPanel unitPriceSetPanel;

  private ACComboBox unitPriceType;

  private ACLabelContainer unitPriceTypeContainer;

  private ACComboBoxModelAdapter unitPriceTypeModel;

  private ACPanel unitPriceServicePanel1;

  private ACComboBox unitPriceServiceA2;

  private ACLabelContainer unitPriceServiceA2Container;

  private ACComboBoxModelAdapter unitPriceServiceA2Model;

  private ACComboBox unitPriceServiceA3;

  private ACLabelContainer unitPriceServiceA3Container;

  private ACComboBoxModelAdapter unitPriceServiceA3Model;

  private ACComboBox unitPriceServiceA4;

  private ACLabelContainer unitPriceServiceA4Container;

  private ACComboBoxModelAdapter unitPriceServiceA4Model;

  private ACComboBox unitPriceServiceA9;

  private ACLabelContainer unitPriceServiceA9Container;

  private ACComboBoxModelAdapter unitPriceServiceA9Model;

  private ACComboBox unitPriceServiceAB;

  private ACLabelContainer unitPriceServiceABContainer;

  private ACComboBoxModelAdapter unitPriceServiceABModel;

  private ACComboBox unitPriceServiceAD;

  private ACLabelContainer unitPriceServiceADContainer;

  private ACComboBoxModelAdapter unitPriceServiceADModel;

  private ACPanel unitPriceServicePanel2;

  private ACComboBox unitPriceServiceA6;

  private ACLabelContainer unitPriceServiceA6Container;

  private ACComboBoxModelAdapter unitPriceServiceA6Model;

  private ACComboBox unitPriceServiceA7;

  private ACLabelContainer unitPriceServiceA7Container;

  private ACComboBoxModelAdapter unitPriceServiceA7Model;

  private ACComboBox unitPriceServiceA8;

  private ACLabelContainer unitPriceServiceA8Container;

  private ACComboBoxModelAdapter unitPriceServiceA8Model;

  private ACComboBox unitPriceServiceAA;

  private ACLabelContainer unitPriceServiceAAContainer;

  private ACComboBoxModelAdapter unitPriceServiceAAModel;

  private ACComboBox unitPriceServiceAC;

  private ACLabelContainer unitPriceServiceACContainer;

  private ACComboBoxModelAdapter unitPriceServiceACModel;

  private ACComboBox unitPriceServiceAE;

  private ACLabelContainer unitPriceServiceAEContainer;

  private ACComboBoxModelAdapter unitPriceServiceAEModel;

  private ACPanel unitPriceServicePanel3;

  private ACComboBox unitPriceServiceAF;

  private ACLabelContainer unitPriceServiceAFContainer;

  private ACComboBoxModelAdapter unitPriceServiceAFModel;

  private ACLabelContainer unitPriceValidPeriodContena;

  private QkanDateTextField unitPriceValidStart;

  private ACLabel unitPriceValidLabel;

  private QkanDateTextField unitPriceValidEnd;

  private ACPanel unitPriceButtonPanel;

  private ACPanel unitPriceButtons;

  private ACButton unitPriceRegularButton;

  private ACButton unitPriceInsertButton;

  private ACButton unitPriceEditButton;

  private ACButton unitPriceDeleteButton;

  private ACPanel unitPriceInfo;

  private ACTable unitPriceTable;

  private VRTableColumnModel unitPriceTableColumnModel;

  private ACTableColumn unitPriceTableColum1;

  private ACTableColumn unitPriceTableColum2;

  private ACTableColumn unitPriceTableColum3;

  private ACTableColumn unitPriceTableColum4;

  private ACPanel tabInsurerLimitRate;

  private ACPanel insurerLimitPanel;

  private ACIntegerCheckBox insurerLimitRateEnableCheck;

  private ACGroupBox insurerLimitRateInfos;

  private ACPanel insurerLimitRateInfo;

  private ACPanel validPeriodPanel;

  private ACPanel validPeriodLeft;

  private ACTextField jigyoTaishosha;

  private ACLabelContainer jigyoTaishoshaContainer;

  private ACTextField jigyoTaishoshaOver;

  private ACLabelContainer jigyoTaishoshaOverContainer;

  private ACLabel jigyoTaishoshaOverComment;

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

  private ACLabelContainer validPeriodCpntena;

  private QkanDateTextField validPeriodStart;

  private ACLabel validPeriodLabel;

  private QkanDateTextField validPeriodEnd;

  private ACPanel validPeriodRight;

  private ACPanel insurerLimitRateButtons;

  private ACButton insurerLimitRateRegularButton;

  private ACButton insurerLimitRateInsertButton;

  private ACButton insurerLimitRateEditButton;

  private ACButton insurerLimitRateDeleteButton;

  private ACPanel insurerLimitRatePanel;

  private ACTable insurerLimitRateTable;

  private VRTableColumnModel insurerLimitRateTableColumnModel;

  private ACTableColumn insurerLimitRateTableColum1;

  private ACTableColumn insurerLimitRateTableColum8;

  private ACTableColumn insurerLimitRateTableColum9;

  private ACTableColumn insurerLimitRateTableColum12;

  private ACTableColumn insurerLimitRateTableColum13;

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

      insurerType.setBindPath("INSURER_TYPE");

      insurerType.setVisible(false);

      insurerType.setModel(getInsurerTypeModel());

      addInsurerType();
    }
    return insurerType;

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

      insurerTypeInfomation.setVisible(false);

      insurerTypeInfomation.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addInsurerTypeInfomation();
    }
    return insurerTypeInfomation;

  }

  /**
   * Tab���擾���܂��B
   * @return Tab
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * Tab�u�������� �P�ʐ��P���v���擾���܂��B
   * @return Tab�u�������� �P�ʐ��P���v
   */
  public ACPanel getTabInsurerUnitPrice(){
    if(tabInsurerUnitPrice==null){

      tabInsurerUnitPrice = new ACPanel();

      addTabInsurerUnitPrice();
    }
    return tabInsurerUnitPrice;

  }

  /**
   * �p�l�����擾���܂��B
   * @return �p�l��
   */
  public ACPanel getInsurerUnitPricePanel(){
    if(insurerUnitPricePanel==null){

      insurerUnitPricePanel = new ACPanel();

      addInsurerUnitPricePanel();
    }
    return insurerUnitPricePanel;

  }

  /**
   * �������ƒP�ʐ��P�����̈���擾���܂��B
   * @return �������ƒP�ʐ��P�����̈�
   */
  public ACGroupBox getInsurerUnitPriceInfos(){
    if(insurerUnitPriceInfos==null){

      insurerUnitPriceInfos = new ACGroupBox();

      insurerUnitPriceInfos.setText("�������ƒP�ʐ��P�����");

      insurerUnitPriceInfos.setFollowChildEnabled(true);

      insurerUnitPriceInfos.setVgap(5);

      addInsurerUnitPriceInfos();
    }
    return insurerUnitPriceInfos;

  }

  /**
   * �P�ʐ��P���ݒ�̈���擾���܂��B
   * @return �P�ʐ��P���ݒ�̈�
   */
  public ACPanel getUnitPriceSetInfos(){
    if(unitPriceSetInfos==null){

      unitPriceSetInfos = new ACPanel();

      unitPriceSetInfos.setAutoWrap(false);

      unitPriceSetInfos.setFollowChildEnabled(true);

      addUnitPriceSetInfos();
    }
    return unitPriceSetInfos;

  }

  /**
   * �P�ʐ��P�����͗̈���擾���܂��B
   * @return �P�ʐ��P�����͗̈�
   */
  public ACPanel getUnitPriceSetPanel(){
    if(unitPriceSetPanel==null){

      unitPriceSetPanel = new ACPanel();

      unitPriceSetPanel.setAutoWrap(true);

      unitPriceSetPanel.setFollowChildEnabled(true);

      unitPriceSetPanel.setHgap(0);

      unitPriceSetPanel.setLabelMargin(0);

      addUnitPriceSetPanel();
    }
    return unitPriceSetPanel;

  }

  /**
   * �n��敪�R���{���擾���܂��B
   * @return �n��敪�R���{
   */
  public ACComboBox getUnitPriceType(){
    if(unitPriceType==null){

      unitPriceType = new ACComboBox();

      getUnitPriceTypeContainer().setText("�n��敪");

      unitPriceType.setBindPath("UNIT_PRICE_TYPE");

      unitPriceType.setEditable(false);

      unitPriceType.setModelBindPath("UNIT_PRICE_TYPE");

      unitPriceType.setRenderBindPath("CONTENT");

      unitPriceType.setModel(getUnitPriceTypeModel());

      addUnitPriceType();
    }
    return unitPriceType;

  }

  /**
   * �n��敪�R���{�R���e�i���擾���܂��B
   * @return �n��敪�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceTypeContainer(){
    if(unitPriceTypeContainer==null){
      unitPriceTypeContainer = new ACLabelContainer();
      unitPriceTypeContainer.setFollowChildEnabled(true);
      unitPriceTypeContainer.setVAlignment(VRLayout.CENTER);
      unitPriceTypeContainer.add(getUnitPriceType(), null);
    }
    return unitPriceTypeContainer;
  }

  /**
   * �n��敪�R���{���f�����擾���܂��B
   * @return �n��敪�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceTypeModel(){
    if(unitPriceTypeModel==null){
      unitPriceTypeModel = new ACComboBoxModelAdapter();
      addUnitPriceTypeModel();
    }
    return unitPriceTypeModel;
  }

  /**
   * �P�ʐ��P���p�l���P���擾���܂��B
   * @return �P�ʐ��P���p�l���P
   */
  public ACPanel getUnitPriceServicePanel1(){
    if(unitPriceServicePanel1==null){

      unitPriceServicePanel1 = new ACPanel();

      addUnitPriceServicePanel1();
    }
    return unitPriceServicePanel1;

  }

  /**
   * A2�R���{���擾���܂��B
   * @return A2�R���{
   */
  public ACComboBox getUnitPriceServiceA2(){
    if(unitPriceServiceA2==null){

      unitPriceServiceA2 = new ACComboBox();

      getUnitPriceServiceA2Container().setText("A2:�K��^(�Ǝ�)");

      unitPriceServiceA2.setBindPath("50211");

      unitPriceServiceA2.setEditable(false);

      unitPriceServiceA2.setModelBindPath("50211");

      unitPriceServiceA2.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA2.setBlankable(true);

      unitPriceServiceA2.setModel(getUnitPriceServiceA2Model());

      addUnitPriceServiceA2();
    }
    return unitPriceServiceA2;

  }

  /**
   * A2�R���{�R���e�i���擾���܂��B
   * @return A2�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceA2Container(){
    if(unitPriceServiceA2Container==null){
      unitPriceServiceA2Container = new ACLabelContainer();
      unitPriceServiceA2Container.setFollowChildEnabled(true);
      unitPriceServiceA2Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA2Container.add(getUnitPriceServiceA2(), null);
    }
    return unitPriceServiceA2Container;
  }

  /**
   * A2�R���{���f�����擾���܂��B
   * @return A2�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA2Model(){
    if(unitPriceServiceA2Model==null){
      unitPriceServiceA2Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA2Model();
    }
    return unitPriceServiceA2Model;
  }

  /**
   * A3�R���{���擾���܂��B
   * @return A3�R���{
   */
  public ACComboBox getUnitPriceServiceA3(){
    if(unitPriceServiceA3==null){

      unitPriceServiceA3 = new ACComboBox();

      getUnitPriceServiceA3Container().setText("A3:�K��^(�藦)");

      unitPriceServiceA3.setBindPath("50311");

      unitPriceServiceA3.setEditable(false);

      unitPriceServiceA3.setModelBindPath("50311");

      unitPriceServiceA3.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA3.setBlankable(true);

      unitPriceServiceA3.setModel(getUnitPriceServiceA3Model());

      addUnitPriceServiceA3();
    }
    return unitPriceServiceA3;

  }

  /**
   * A3�R���{�R���e�i���擾���܂��B
   * @return A3�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceA3Container(){
    if(unitPriceServiceA3Container==null){
      unitPriceServiceA3Container = new ACLabelContainer();
      unitPriceServiceA3Container.setFollowChildEnabled(true);
      unitPriceServiceA3Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA3Container.add(getUnitPriceServiceA3(), null);
    }
    return unitPriceServiceA3Container;
  }

  /**
   * A3�R���{���f�����擾���܂��B
   * @return A3�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA3Model(){
    if(unitPriceServiceA3Model==null){
      unitPriceServiceA3Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA3Model();
    }
    return unitPriceServiceA3Model;
  }

  /**
   * A4�R���{���擾���܂��B
   * @return A4�R���{
   */
  public ACComboBox getUnitPriceServiceA4(){
    if(unitPriceServiceA4==null){

      unitPriceServiceA4 = new ACComboBox();

      getUnitPriceServiceA4Container().setText("A4:�K��^(��z)");

      unitPriceServiceA4.setBindPath("50411");

      unitPriceServiceA4.setEditable(false);

      unitPriceServiceA4.setModelBindPath("50411");

      unitPriceServiceA4.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA4.setBlankable(true);

      unitPriceServiceA4.setModel(getUnitPriceServiceA4Model());

      addUnitPriceServiceA4();
    }
    return unitPriceServiceA4;

  }

  /**
   * A4�R���{�R���e�i���擾���܂��B
   * @return A4�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceA4Container(){
    if(unitPriceServiceA4Container==null){
      unitPriceServiceA4Container = new ACLabelContainer();
      unitPriceServiceA4Container.setFollowChildEnabled(true);
      unitPriceServiceA4Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA4Container.add(getUnitPriceServiceA4(), null);
    }
    return unitPriceServiceA4Container;
  }

  /**
   * A4�R���{���f�����擾���܂��B
   * @return A4�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA4Model(){
    if(unitPriceServiceA4Model==null){
      unitPriceServiceA4Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA4Model();
    }
    return unitPriceServiceA4Model;
  }

  /**
   * A9�R���{���擾���܂��B
   * @return A9�R���{
   */
  public ACComboBox getUnitPriceServiceA9(){
    if(unitPriceServiceA9==null){

      unitPriceServiceA9 = new ACComboBox();

      getUnitPriceServiceA9Container().setText("A9:�����z�H(�藦)");

      unitPriceServiceA9.setBindPath("50911");

      unitPriceServiceA9.setEditable(false);

      unitPriceServiceA9.setModelBindPath("50911");

      unitPriceServiceA9.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA9.setBlankable(true);

      unitPriceServiceA9.setModel(getUnitPriceServiceA9Model());

      addUnitPriceServiceA9();
    }
    return unitPriceServiceA9;

  }

  /**
   * A9�R���{�R���e�i���擾���܂��B
   * @return A9�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceA9Container(){
    if(unitPriceServiceA9Container==null){
      unitPriceServiceA9Container = new ACLabelContainer();
      unitPriceServiceA9Container.setFollowChildEnabled(true);
      unitPriceServiceA9Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA9Container.add(getUnitPriceServiceA9(), null);
    }
    return unitPriceServiceA9Container;
  }

  /**
   * A9�R���{���f�����擾���܂��B
   * @return A9�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA9Model(){
    if(unitPriceServiceA9Model==null){
      unitPriceServiceA9Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA9Model();
    }
    return unitPriceServiceA9Model;
  }

  /**
   * AB�R���{���擾���܂��B
   * @return AB�R���{
   */
  public ACComboBox getUnitPriceServiceAB(){
    if(unitPriceServiceAB==null){

      unitPriceServiceAB = new ACComboBox();

      getUnitPriceServiceABContainer().setText("AB:��������(�藦)");

      unitPriceServiceAB.setBindPath("51111");

      unitPriceServiceAB.setEditable(false);

      unitPriceServiceAB.setModelBindPath("51111");

      unitPriceServiceAB.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAB.setBlankable(true);

      unitPriceServiceAB.setModel(getUnitPriceServiceABModel());

      addUnitPriceServiceAB();
    }
    return unitPriceServiceAB;

  }

  /**
   * AB�R���{�R���e�i���擾���܂��B
   * @return AB�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceABContainer(){
    if(unitPriceServiceABContainer==null){
      unitPriceServiceABContainer = new ACLabelContainer();
      unitPriceServiceABContainer.setFollowChildEnabled(true);
      unitPriceServiceABContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceABContainer.add(getUnitPriceServiceAB(), null);
    }
    return unitPriceServiceABContainer;
  }

  /**
   * AB�R���{���f�����擾���܂��B
   * @return AB�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceABModel(){
    if(unitPriceServiceABModel==null){
      unitPriceServiceABModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceABModel();
    }
    return unitPriceServiceABModel;
  }

  /**
   * AD�R���{���擾���܂��B
   * @return AD�R���{
   */
  public ACComboBox getUnitPriceServiceAD(){
    if(unitPriceServiceAD==null){

      unitPriceServiceAD = new ACComboBox();

      getUnitPriceServiceADContainer().setText("AD:������(�藦)");

      unitPriceServiceAD.setBindPath("51311");

      unitPriceServiceAD.setEditable(false);

      unitPriceServiceAD.setModelBindPath("51311");

      unitPriceServiceAD.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAD.setBlankable(true);

      unitPriceServiceAD.setModel(getUnitPriceServiceADModel());

      addUnitPriceServiceAD();
    }
    return unitPriceServiceAD;

  }

  /**
   * AD�R���{�R���e�i���擾���܂��B
   * @return AD�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceADContainer(){
    if(unitPriceServiceADContainer==null){
      unitPriceServiceADContainer = new ACLabelContainer();
      unitPriceServiceADContainer.setFollowChildEnabled(true);
      unitPriceServiceADContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceADContainer.add(getUnitPriceServiceAD(), null);
    }
    return unitPriceServiceADContainer;
  }

  /**
   * AD�R���{���f�����擾���܂��B
   * @return AD�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceADModel(){
    if(unitPriceServiceADModel==null){
      unitPriceServiceADModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceADModel();
    }
    return unitPriceServiceADModel;
  }

  /**
   * �P�ʐ��P���p�l���Q���擾���܂��B
   * @return �P�ʐ��P���p�l���Q
   */
  public ACPanel getUnitPriceServicePanel2(){
    if(unitPriceServicePanel2==null){

      unitPriceServicePanel2 = new ACPanel();

      addUnitPriceServicePanel2();
    }
    return unitPriceServicePanel2;

  }

  /**
   * A6�R���{���擾���܂��B
   * @return A6�R���{
   */
  public ACComboBox getUnitPriceServiceA6(){
    if(unitPriceServiceA6==null){

      unitPriceServiceA6 = new ACComboBox();

      getUnitPriceServiceA6Container().setText("A6:�ʏ��^(�Ǝ�)");

      unitPriceServiceA6.setBindPath("50611");

      unitPriceServiceA6.setEditable(false);

      unitPriceServiceA6.setModelBindPath("50611");

      unitPriceServiceA6.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA6.setBlankable(true);

      unitPriceServiceA6.setModel(getUnitPriceServiceA6Model());

      addUnitPriceServiceA6();
    }
    return unitPriceServiceA6;

  }

  /**
   * A6�R���{�R���e�i���擾���܂��B
   * @return A6�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceA6Container(){
    if(unitPriceServiceA6Container==null){
      unitPriceServiceA6Container = new ACLabelContainer();
      unitPriceServiceA6Container.setFollowChildEnabled(true);
      unitPriceServiceA6Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA6Container.add(getUnitPriceServiceA6(), null);
    }
    return unitPriceServiceA6Container;
  }

  /**
   * A6�R���{���f�����擾���܂��B
   * @return A6�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA6Model(){
    if(unitPriceServiceA6Model==null){
      unitPriceServiceA6Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA6Model();
    }
    return unitPriceServiceA6Model;
  }

  /**
   * A7�R���{���擾���܂��B
   * @return A7�R���{
   */
  public ACComboBox getUnitPriceServiceA7(){
    if(unitPriceServiceA7==null){

      unitPriceServiceA7 = new ACComboBox();

      getUnitPriceServiceA7Container().setText("A7:�ʏ��^(�藦)");

      unitPriceServiceA7.setBindPath("50711");

      unitPriceServiceA7.setEditable(false);

      unitPriceServiceA7.setModelBindPath("50711");

      unitPriceServiceA7.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA7.setBlankable(true);

      unitPriceServiceA7.setModel(getUnitPriceServiceA7Model());

      addUnitPriceServiceA7();
    }
    return unitPriceServiceA7;

  }

  /**
   * A7�R���{�R���e�i���擾���܂��B
   * @return A7�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceA7Container(){
    if(unitPriceServiceA7Container==null){
      unitPriceServiceA7Container = new ACLabelContainer();
      unitPriceServiceA7Container.setFollowChildEnabled(true);
      unitPriceServiceA7Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA7Container.add(getUnitPriceServiceA7(), null);
    }
    return unitPriceServiceA7Container;
  }

  /**
   * A7�R���{���f�����擾���܂��B
   * @return A7�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA7Model(){
    if(unitPriceServiceA7Model==null){
      unitPriceServiceA7Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA7Model();
    }
    return unitPriceServiceA7Model;
  }

  /**
   * A8�R���{���擾���܂��B
   * @return A8�R���{
   */
  public ACComboBox getUnitPriceServiceA8(){
    if(unitPriceServiceA8==null){

      unitPriceServiceA8 = new ACComboBox();

      getUnitPriceServiceA8Container().setText("A8:�ʏ��^(��z)");

      unitPriceServiceA8.setBindPath("50811");

      unitPriceServiceA8.setEditable(false);

      unitPriceServiceA8.setModelBindPath("50811");

      unitPriceServiceA8.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceA8.setBlankable(true);

      unitPriceServiceA8.setModel(getUnitPriceServiceA8Model());

      addUnitPriceServiceA8();
    }
    return unitPriceServiceA8;

  }

  /**
   * A8�R���{�R���e�i���擾���܂��B
   * @return A8�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceA8Container(){
    if(unitPriceServiceA8Container==null){
      unitPriceServiceA8Container = new ACLabelContainer();
      unitPriceServiceA8Container.setFollowChildEnabled(true);
      unitPriceServiceA8Container.setVAlignment(VRLayout.CENTER);
      unitPriceServiceA8Container.add(getUnitPriceServiceA8(), null);
    }
    return unitPriceServiceA8Container;
  }

  /**
   * A8�R���{���f�����擾���܂��B
   * @return A8�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceA8Model(){
    if(unitPriceServiceA8Model==null){
      unitPriceServiceA8Model = new ACComboBoxModelAdapter();
      addUnitPriceServiceA8Model();
    }
    return unitPriceServiceA8Model;
  }

  /**
   * AA�R���{���擾���܂��B
   * @return AA�R���{
   */
  public ACComboBox getUnitPriceServiceAA(){
    if(unitPriceServiceAA==null){

      unitPriceServiceAA = new ACComboBox();

      getUnitPriceServiceAAContainer().setText("AA:�����z�H(��z)");

      unitPriceServiceAA.setBindPath("51011");

      unitPriceServiceAA.setEditable(false);

      unitPriceServiceAA.setModelBindPath("51011");

      unitPriceServiceAA.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAA.setBlankable(true);

      unitPriceServiceAA.setModel(getUnitPriceServiceAAModel());

      addUnitPriceServiceAA();
    }
    return unitPriceServiceAA;

  }

  /**
   * AA�R���{�R���e�i���擾���܂��B
   * @return AA�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceAAContainer(){
    if(unitPriceServiceAAContainer==null){
      unitPriceServiceAAContainer = new ACLabelContainer();
      unitPriceServiceAAContainer.setFollowChildEnabled(true);
      unitPriceServiceAAContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceAAContainer.add(getUnitPriceServiceAA(), null);
    }
    return unitPriceServiceAAContainer;
  }

  /**
   * AA�R���{���f�����擾���܂��B
   * @return AA�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceAAModel(){
    if(unitPriceServiceAAModel==null){
      unitPriceServiceAAModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceAAModel();
    }
    return unitPriceServiceAAModel;
  }

  /**
   * AC�R���{���擾���܂��B
   * @return AC�R���{
   */
  public ACComboBox getUnitPriceServiceAC(){
    if(unitPriceServiceAC==null){

      unitPriceServiceAC = new ACComboBox();

      getUnitPriceServiceACContainer().setText("AC:��������(��z)");

      unitPriceServiceAC.setBindPath("51211");

      unitPriceServiceAC.setEditable(false);

      unitPriceServiceAC.setModelBindPath("51211");

      unitPriceServiceAC.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAC.setBlankable(true);

      unitPriceServiceAC.setModel(getUnitPriceServiceACModel());

      addUnitPriceServiceAC();
    }
    return unitPriceServiceAC;

  }

  /**
   * AC�R���{�R���e�i���擾���܂��B
   * @return AC�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceACContainer(){
    if(unitPriceServiceACContainer==null){
      unitPriceServiceACContainer = new ACLabelContainer();
      unitPriceServiceACContainer.setFollowChildEnabled(true);
      unitPriceServiceACContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceACContainer.add(getUnitPriceServiceAC(), null);
    }
    return unitPriceServiceACContainer;
  }

  /**
   * AC�R���{���f�����擾���܂��B
   * @return AC�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceACModel(){
    if(unitPriceServiceACModel==null){
      unitPriceServiceACModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceACModel();
    }
    return unitPriceServiceACModel;
  }

  /**
   * AE�R���{���擾���܂��B
   * @return AE�R���{
   */
  public ACComboBox getUnitPriceServiceAE(){
    if(unitPriceServiceAE==null){

      unitPriceServiceAE = new ACComboBox();

      getUnitPriceServiceAEContainer().setText("AE:������(��z)");

      unitPriceServiceAE.setBindPath("51411");

      unitPriceServiceAE.setEditable(false);

      unitPriceServiceAE.setModelBindPath("51411");

      unitPriceServiceAE.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAE.setBlankable(true);

      unitPriceServiceAE.setModel(getUnitPriceServiceAEModel());

      addUnitPriceServiceAE();
    }
    return unitPriceServiceAE;

  }

  /**
   * AE�R���{�R���e�i���擾���܂��B
   * @return AE�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceAEContainer(){
    if(unitPriceServiceAEContainer==null){
      unitPriceServiceAEContainer = new ACLabelContainer();
      unitPriceServiceAEContainer.setFollowChildEnabled(true);
      unitPriceServiceAEContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceAEContainer.add(getUnitPriceServiceAE(), null);
    }
    return unitPriceServiceAEContainer;
  }

  /**
   * AE�R���{���f�����擾���܂��B
   * @return AE�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceAEModel(){
    if(unitPriceServiceAEModel==null){
      unitPriceServiceAEModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceAEModel();
    }
    return unitPriceServiceAEModel;
  }

  /**
   * �P�ʐ��P���p�l���R���擾���܂��B
   * @return �P�ʐ��P���p�l���R
   */
  public ACPanel getUnitPriceServicePanel3(){
    if(unitPriceServicePanel3==null){

      unitPriceServicePanel3 = new ACPanel();

      addUnitPriceServicePanel3();
    }
    return unitPriceServicePanel3;

  }

  /**
   * AF�R���{���擾���܂��B
   * @return AF�R���{
   */
  public ACComboBox getUnitPriceServiceAF(){
    if(unitPriceServiceAF==null){

      unitPriceServiceAF = new ACComboBox();

      getUnitPriceServiceAFContainer().setText("AF:�\�h�P�A�}�l");

      unitPriceServiceAF.setBindPath("51511");

      unitPriceServiceAF.setEditable(false);

      unitPriceServiceAF.setModelBindPath("51511");

      unitPriceServiceAF.setRenderBindPath("UNIT_PRICE_VALUE");

      unitPriceServiceAF.setBlankable(true);

      unitPriceServiceAF.setModel(getUnitPriceServiceAFModel());

      addUnitPriceServiceAF();
    }
    return unitPriceServiceAF;

  }

  /**
   * AF�R���{�R���e�i���擾���܂��B
   * @return AF�R���{�R���e�i
   */
  protected ACLabelContainer getUnitPriceServiceAFContainer(){
    if(unitPriceServiceAFContainer==null){
      unitPriceServiceAFContainer = new ACLabelContainer();
      unitPriceServiceAFContainer.setFollowChildEnabled(true);
      unitPriceServiceAFContainer.setVAlignment(VRLayout.CENTER);
      unitPriceServiceAFContainer.add(getUnitPriceServiceAF(), null);
    }
    return unitPriceServiceAFContainer;
  }

  /**
   * AF�R���{���f�����擾���܂��B
   * @return AF�R���{���f��
   */
  protected ACComboBoxModelAdapter getUnitPriceServiceAFModel(){
    if(unitPriceServiceAFModel==null){
      unitPriceServiceAFModel = new ACComboBoxModelAdapter();
      addUnitPriceServiceAFModel();
    }
    return unitPriceServiceAFModel;
  }

  /**
   * �L�����ԃR���e�i���擾���܂��B
   * @return �L�����ԃR���e�i
   */
  public ACLabelContainer getUnitPriceValidPeriodContena(){
    if(unitPriceValidPeriodContena==null){

      unitPriceValidPeriodContena = new ACLabelContainer();

      unitPriceValidPeriodContena.setText("�L������");

      unitPriceValidPeriodContena.setFollowChildEnabled(true);

      addUnitPriceValidPeriodContena();
    }
    return unitPriceValidPeriodContena;

  }

  /**
   * �L�����ԃe�L�X�g(�J�n)���擾���܂��B
   * @return �L�����ԃe�L�X�g(�J�n)
   */
  public QkanDateTextField getUnitPriceValidStart(){
    if(unitPriceValidStart==null){

      unitPriceValidStart = new QkanDateTextField();

      unitPriceValidStart.setBindPath("UNIT_PRICE_VALID_START");

      addUnitPriceValidStart();
    }
    return unitPriceValidStart;

  }

  /**
   * �L�����ԁE���x�����擾���܂��B
   * @return �L�����ԁE���x��
   */
  public ACLabel getUnitPriceValidLabel(){
    if(unitPriceValidLabel==null){

      unitPriceValidLabel = new ACLabel();

      unitPriceValidLabel.setText("����");

      addUnitPriceValidLabel();
    }
    return unitPriceValidLabel;

  }

  /**
   * �L�����ԃe�L�X�g(�I��)���擾���܂��B
   * @return �L�����ԃe�L�X�g(�I��)
   */
  public QkanDateTextField getUnitPriceValidEnd(){
    if(unitPriceValidEnd==null){

      unitPriceValidEnd = new QkanDateTextField();

      unitPriceValidEnd.setBindPath("UNIT_PRICE_VALID_END");

      addUnitPriceValidEnd();
    }
    return unitPriceValidEnd;

  }

  /**
   * �L�����ԗ̈�E���擾���܂��B
   * @return �L�����ԗ̈�E
   */
  public ACPanel getUnitPriceButtonPanel(){
    if(unitPriceButtonPanel==null){

      unitPriceButtonPanel = new ACPanel();

      unitPriceButtonPanel.setFollowChildEnabled(true);

      addUnitPriceButtonPanel();
    }
    return unitPriceButtonPanel;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getUnitPriceButtons(){
    if(unitPriceButtons==null){

      unitPriceButtons = new ACPanel();

      unitPriceButtons.setFollowChildEnabled(true);

      addUnitPriceButtons();
    }
    return unitPriceButtons;

  }

  /**
   * �K����擾���܂��B
   * @return �K��
   */
  public ACButton getUnitPriceRegularButton(){
    if(unitPriceRegularButton==null){

      unitPriceRegularButton = new ACButton();

      unitPriceRegularButton.setText("�K��");

      unitPriceRegularButton.setToolTipText("�����J���ȋK��̑������ƒP�ʐ��P����ݒ肵�܂��B");

      unitPriceRegularButton.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addUnitPriceRegularButton();
    }
    return unitPriceRegularButton;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getUnitPriceInsertButton(){
    if(unitPriceInsertButton==null){

      unitPriceInsertButton = new ACButton();

      unitPriceInsertButton.setText("�ǉ�");

      unitPriceInsertButton.setToolTipText("�ی��҂̑������ƒP�ʐ��P������ǉ����܂��B");

      unitPriceInsertButton.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addUnitPriceInsertButton();
    }
    return unitPriceInsertButton;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getUnitPriceEditButton(){
    if(unitPriceEditButton==null){

      unitPriceEditButton = new ACButton();

      unitPriceEditButton.setText("����");

      unitPriceEditButton.setToolTipText("�I�𒆂̑������ƒP�ʐ��P������ҏW���܂��B");

      unitPriceEditButton.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addUnitPriceEditButton();
    }
    return unitPriceEditButton;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getUnitPriceDeleteButton(){
    if(unitPriceDeleteButton==null){

      unitPriceDeleteButton = new ACButton();

      unitPriceDeleteButton.setText("�폜");

      unitPriceDeleteButton.setToolTipText("�I�𒆂̑������ƒP�ʐ��P�������폜���܂��B");

      unitPriceDeleteButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addUnitPriceDeleteButton();
    }
    return unitPriceDeleteButton;

  }

  /**
   * �������ƒP�ʐ��P�����p�l�����擾���܂��B
   * @return �������ƒP�ʐ��P�����p�l��
   */
  public ACPanel getUnitPriceInfo(){
    if(unitPriceInfo==null){

      unitPriceInfo = new ACPanel();

      addUnitPriceInfo();
    }
    return unitPriceInfo;

  }

  /**
   * �������ƒP�ʐ��P�����e�[�u�����擾���܂��B
   * @return �������ƒP�ʐ��P�����e�[�u��
   */
  public ACTable getUnitPriceTable(){
    if(unitPriceTable==null){

      unitPriceTable = new ACTable();

      unitPriceTable.setColumnModel(getUnitPriceTableColumnModel());

      addUnitPriceTable();
    }
    return unitPriceTable;

  }

  /**
   * �������ƒP�ʐ��P�����e�[�u���J�������f�����擾���܂��B
   * @return �������ƒP�ʐ��P�����e�[�u���J�������f��
   */
  protected VRTableColumnModel getUnitPriceTableColumnModel(){
    if(unitPriceTableColumnModel==null){
      unitPriceTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addUnitPriceTableColumnModel();
    }
    return unitPriceTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getUnitPriceTableColum1(){
    if(unitPriceTableColum1==null){

      unitPriceTableColum1 = new ACTableColumn();

      unitPriceTableColum1.setHeaderValue("No.");

      unitPriceTableColum1.setColumns(3);

      unitPriceTableColum1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      unitPriceTableColum1.setSortable(false);

      addUnitPriceTableColum1();
    }
    return unitPriceTableColum1;

  }

  /**
   * �������ƒP�ʐ��P�����L������(�J�n)���擾���܂��B
   * @return �������ƒP�ʐ��P�����L������(�J�n)
   */
  public ACTableColumn getUnitPriceTableColum2(){
    if(unitPriceTableColum2==null){

      unitPriceTableColum2 = new ACTableColumn(0);

      unitPriceTableColum2.setHeaderValue("�L������(�J�n)");

      unitPriceTableColum2.setColumns(12);

      unitPriceTableColum2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addUnitPriceTableColum2();
    }
    return unitPriceTableColum2;

  }

  /**
   * �������ƒP�ʐ��P�����L������(�I��)���擾���܂��B
   * @return �������ƒP�ʐ��P�����L������(�I��)
   */
  public ACTableColumn getUnitPriceTableColum3(){
    if(unitPriceTableColum3==null){

      unitPriceTableColum3 = new ACTableColumn(1);

      unitPriceTableColum3.setHeaderValue("�L������(�I��)");

      unitPriceTableColum3.setColumns(12);

      unitPriceTableColum3.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addUnitPriceTableColum3();
    }
    return unitPriceTableColum3;

  }

  /**
   * �n��敪���擾���܂��B
   * @return �n��敪
   */
  public ACTableColumn getUnitPriceTableColum4(){
    if(unitPriceTableColum4==null){

      unitPriceTableColum4 = new ACTableColumn(2);

      unitPriceTableColum4.setHeaderValue("�n��敪");

      unitPriceTableColum4.setColumns(12);

      addUnitPriceTableColum4();
    }
    return unitPriceTableColum4;

  }

  /**
   * Tab�u�������� ���x�z�v���擾���܂��B
   * @return Tab�u�������� ���x�z�v
   */
  public ACPanel getTabInsurerLimitRate(){
    if(tabInsurerLimitRate==null){

      tabInsurerLimitRate = new ACPanel();

      addTabInsurerLimitRate();
    }
    return tabInsurerLimitRate;

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

      insurerLimitRateInfos.setText("�������ƌ��x�z���");

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
   * ���ƑΏێ҃e�L�X�g���擾���܂��B
   * @return ���ƑΏێ҃e�L�X�g
   */
  public ACTextField getJigyoTaishosha(){
    if(jigyoTaishosha==null){

      jigyoTaishosha = new ACTextField();

      getJigyoTaishoshaContainer().setText("���ƑΏێ�");

      jigyoTaishosha.setBindPath("6");

      jigyoTaishosha.setColumns(4);

      jigyoTaishosha.setCharType(VRCharType.ONLY_DIGIT);

      jigyoTaishosha.setHorizontalAlignment(SwingConstants.RIGHT);

      jigyoTaishosha.setIMEMode(InputSubset.LATIN);

      jigyoTaishosha.setMaxLength(5);

      addJigyoTaishosha();
    }
    return jigyoTaishosha;

  }

  /**
   * ���ƑΏێ҃e�L�X�g�R���e�i���擾���܂��B
   * @return ���ƑΏێ҃e�L�X�g�R���e�i
   */
  protected ACLabelContainer getJigyoTaishoshaContainer(){
    if(jigyoTaishoshaContainer==null){
      jigyoTaishoshaContainer = new ACLabelContainer();
      jigyoTaishoshaContainer.setFollowChildEnabled(true);
      jigyoTaishoshaContainer.setVAlignment(VRLayout.CENTER);
      jigyoTaishoshaContainer.add(getJigyoTaishosha(), null);
    }
    return jigyoTaishoshaContainer;
  }

  /**
   * ���ƑΏێ�(�v�x���P��)�e�L�X�g���擾���܂��B
   * @return ���ƑΏێ�(�v�x���P��)�e�L�X�g
   */
  public ACTextField getJigyoTaishoshaOver(){
    if(jigyoTaishoshaOver==null){

      jigyoTaishoshaOver = new ACTextField();

      getJigyoTaishoshaOverContainer().setText("���ƑΏێ�(�v�x���P��)");

      jigyoTaishoshaOver.setBindPath("61");

      jigyoTaishoshaOver.setColumns(4);

      jigyoTaishoshaOver.setCharType(VRCharType.ONLY_DIGIT);

      jigyoTaishoshaOver.setHorizontalAlignment(SwingConstants.RIGHT);

      jigyoTaishoshaOver.setIMEMode(InputSubset.LATIN);

      jigyoTaishoshaOver.setMaxLength(5);

      addJigyoTaishoshaOver();
    }
    return jigyoTaishoshaOver;

  }

  /**
   * ���ƑΏێ�(�v�x���P��)�e�L�X�g�R���e�i���擾���܂��B
   * @return ���ƑΏێ�(�v�x���P��)�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getJigyoTaishoshaOverContainer(){
    if(jigyoTaishoshaOverContainer==null){
      jigyoTaishoshaOverContainer = new ACLabelContainer();
      jigyoTaishoshaOverContainer.setFollowChildEnabled(true);
      jigyoTaishoshaOverContainer.setVAlignment(VRLayout.CENTER);
      jigyoTaishoshaOverContainer.add(getJigyoTaishoshaOver(), null);
    }
    return jigyoTaishoshaOverContainer;
  }

  /**
   * ���ƑΏێ҃R�����g�E���x�����擾���܂��B
   * @return ���ƑΏێ҃R�����g�E���x��
   */
  public ACLabel getJigyoTaishoshaOverComment(){
    if(jigyoTaishoshaOverComment==null){

      jigyoTaishoshaOverComment = new ACLabel();

      jigyoTaishoshaOverComment.setText("�s�����ɂĎ��ƑΏێ҂��v�x���P�̊z�𒴂��ăT�[�r�X�𗘗p" + ACConstants.LINE_SEPARATOR + "����ꍇ�̌��x�z����߂��Ă���ꍇ�͐ݒ肵�Ă��������B");

      addJigyoTaishoshaOverComment();
    }
    return jigyoTaishoshaOverComment;

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
   * �L�����ԃe�L�X�g(�J�n)���擾���܂��B
   * @return �L�����ԃe�L�X�g(�J�n)
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
   * �L�����ԃe�L�X�g(�I��)���擾���܂��B
   * @return �L�����ԃe�L�X�g(�I��)
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

      insurerLimitRateDeleteButton.setToolTipText("�I�𒆂̎x�����x�z�����폜���܂��B");

      insurerLimitRateDeleteButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addInsurerLimitRateDeleteButton();
    }
    return insurerLimitRateDeleteButton;

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
   * �ی��ҏ��L������(�J�n)���擾���܂��B
   * @return �ی��ҏ��L������(�J�n)
   */
  public ACTableColumn getInsurerLimitRateTableColum8(){
    if(insurerLimitRateTableColum8==null){

      insurerLimitRateTableColum8 = new ACTableColumn(0);

      insurerLimitRateTableColum8.setHeaderValue("�L������(�J�n)");

      insurerLimitRateTableColum8.setColumns(12);

      insurerLimitRateTableColum8.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addInsurerLimitRateTableColum8();
    }
    return insurerLimitRateTableColum8;

  }

  /**
   * �ی��ҏ��L������(�I��)���擾���܂��B
   * @return �ی��ҏ��L������(�I��)
   */
  public ACTableColumn getInsurerLimitRateTableColum9(){
    if(insurerLimitRateTableColum9==null){

      insurerLimitRateTableColum9 = new ACTableColumn(1);

      insurerLimitRateTableColum9.setHeaderValue("�L������(�I��)");

      insurerLimitRateTableColum9.setColumns(12);

      insurerLimitRateTableColum9.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addInsurerLimitRateTableColum9();
    }
    return insurerLimitRateTableColum9;

  }

  /**
   * ���ƑΏێ҂��擾���܂��B
   * @return ���ƑΏێ�
   */
  public ACTableColumn getInsurerLimitRateTableColum12(){
    if(insurerLimitRateTableColum12==null){

      insurerLimitRateTableColum12 = new ACTableColumn(2);

      insurerLimitRateTableColum12.setHeaderValue("���ƑΏێ�");

      insurerLimitRateTableColum12.setColumns(7);

      addInsurerLimitRateTableColum12();
    }
    return insurerLimitRateTableColum12;

  }

  /**
   * ���ƑΏێ�(�v�x���P��)���擾���܂��B
   * @return ���ƑΏێ�(�v�x���P��)
   */
  public ACTableColumn getInsurerLimitRateTableColum13(){
    if(insurerLimitRateTableColum13==null){

      insurerLimitRateTableColum13 = new ACTableColumn(3);

      insurerLimitRateTableColum13.setHeaderValue("���ƑΏێ�(�v�x���P��)");

      insurerLimitRateTableColum13.setColumns(12);

      addInsurerLimitRateTableColum13();
    }
    return insurerLimitRateTableColum13;

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

    contents.add(getTabs(), VRLayout.CLIENT);

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

    insurerInfos.add(getInsurerType(), VRLayout.FLOW_INSETLINE);

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
   * Tab�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("�������� �P�ʐ��P��", getTabInsurerUnitPrice());

    tabs.addTab("�������� ���x�z", getTabInsurerLimitRate());

  }

  /**
   * Tab�u�������� �P�ʐ��P���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabInsurerUnitPrice(){

    tabInsurerUnitPrice.add(getInsurerUnitPricePanel(), VRLayout.CLIENT);

  }

  /**
   * �p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerUnitPricePanel(){

    insurerUnitPricePanel.add(getInsurerUnitPriceInfos(), VRLayout.CLIENT);

  }

  /**
   * �������ƒP�ʐ��P�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerUnitPriceInfos(){

    insurerUnitPriceInfos.add(getUnitPriceSetInfos(), VRLayout.NORTH);

    insurerUnitPriceInfos.add(getUnitPriceInfo(), VRLayout.CLIENT);

  }

  /**
   * �P�ʐ��P���ݒ�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceSetInfos(){

    unitPriceSetInfos.add(getUnitPriceSetPanel(), VRLayout.NORTH);

    unitPriceSetInfos.add(getUnitPriceButtonPanel(), VRLayout.NORTH);

  }

  /**
   * �P�ʐ��P�����͗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceSetPanel(){

    unitPriceSetPanel.add(getUnitPriceTypeContainer(), VRLayout.FLOW_RETURN);

    unitPriceSetPanel.add(getUnitPriceServicePanel1(), VRLayout.FLOW);

    unitPriceSetPanel.add(getUnitPriceServicePanel2(), VRLayout.FLOW);

    unitPriceSetPanel.add(getUnitPriceServicePanel3(), VRLayout.FLOW_RETURN);

    unitPriceSetPanel.add(getUnitPriceValidPeriodContena(), VRLayout.FLOW_RETURN);

  }

  /**
   * �n��敪�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceType(){

  }

  /**
   * �n��敪�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceTypeModel(){

  }

  /**
   * �P�ʐ��P���p�l���P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServicePanel1(){

    unitPriceServicePanel1.add(getUnitPriceServiceA2Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel1.add(getUnitPriceServiceA3Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel1.add(getUnitPriceServiceA4Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel1.add(getUnitPriceServiceA9Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel1.add(getUnitPriceServiceABContainer(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel1.add(getUnitPriceServiceADContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * A2�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA2(){

  }

  /**
   * A2�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA2Model(){

  }

  /**
   * A3�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA3(){

  }

  /**
   * A3�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA3Model(){

  }

  /**
   * A4�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA4(){

  }

  /**
   * A4�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA4Model(){

  }

  /**
   * A9�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA9(){

  }

  /**
   * A9�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA9Model(){

  }

  /**
   * AB�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceAB(){

  }

  /**
   * AB�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceABModel(){

  }

  /**
   * AD�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceAD(){

  }

  /**
   * AD�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceADModel(){

  }

  /**
   * �P�ʐ��P���p�l���Q�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServicePanel2(){

    unitPriceServicePanel2.add(getUnitPriceServiceA6Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel2.add(getUnitPriceServiceA7Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel2.add(getUnitPriceServiceA8Container(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel2.add(getUnitPriceServiceAAContainer(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel2.add(getUnitPriceServiceACContainer(), VRLayout.FLOW_INSETLINE);

    unitPriceServicePanel2.add(getUnitPriceServiceAEContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * A6�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA6(){

  }

  /**
   * A6�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA6Model(){

  }

  /**
   * A7�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA7(){

  }

  /**
   * A7�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA7Model(){

  }

  /**
   * A8�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA8(){

  }

  /**
   * A8�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceA8Model(){

  }

  /**
   * AA�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceAA(){

  }

  /**
   * AA�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceAAModel(){

  }

  /**
   * AC�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceAC(){

  }

  /**
   * AC�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceACModel(){

  }

  /**
   * AE�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceAE(){

  }

  /**
   * AE�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceAEModel(){

  }

  /**
   * �P�ʐ��P���p�l���R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServicePanel3(){

    unitPriceServicePanel3.add(getUnitPriceServiceAFContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * AF�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceAF(){

  }

  /**
   * AF�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceServiceAFModel(){

  }

  /**
   * �L�����ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceValidPeriodContena(){

    unitPriceValidPeriodContena.add(getUnitPriceValidStart(), VRLayout.FLOW);

    unitPriceValidPeriodContena.add(getUnitPriceValidLabel(), VRLayout.FLOW);

    unitPriceValidPeriodContena.add(getUnitPriceValidEnd(), VRLayout.FLOW);

  }

  /**
   * �L�����ԃe�L�X�g(�J�n)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceValidStart(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceValidLabel(){

  }

  /**
   * �L�����ԃe�L�X�g(�I��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceValidEnd(){

  }

  /**
   * �L�����ԗ̈�E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceButtonPanel(){

    unitPriceButtonPanel.add(getUnitPriceButtons(), VRLayout.WEST);

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceButtons(){

    unitPriceButtons.add(getUnitPriceRegularButton(), VRLayout.WEST);

    unitPriceButtons.add(getUnitPriceInsertButton(), VRLayout.WEST);

    unitPriceButtons.add(getUnitPriceEditButton(), VRLayout.WEST);

    unitPriceButtons.add(getUnitPriceDeleteButton(), VRLayout.WEST);

  }

  /**
   * �K��ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceRegularButton(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceInsertButton(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceEditButton(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceDeleteButton(){

  }

  /**
   * �������ƒP�ʐ��P�����p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceInfo(){

    unitPriceInfo.add(getUnitPriceTable(), VRLayout.CLIENT);

  }

  /**
   * �������ƒP�ʐ��P�����e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceTable(){

  }

  /**
   * �������ƒP�ʐ��P�����e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceTableColumnModel(){

    getUnitPriceTableColumnModel().addColumn(getUnitPriceTableColum1());

    getUnitPriceTableColumnModel().addColumn(getUnitPriceTableColum2());

    getUnitPriceTableColumnModel().addColumn(getUnitPriceTableColum3());

    getUnitPriceTableColumnModel().addColumn(getUnitPriceTableColum4());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceTableColum1(){

  }

  /**
   * �������ƒP�ʐ��P�����L������(�J�n)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceTableColum2(){

  }

  /**
   * �������ƒP�ʐ��P�����L������(�I��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceTableColum3(){

  }

  /**
   * �n��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnitPriceTableColum4(){

  }

  /**
   * Tab�u�������� ���x�z�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabInsurerLimitRate(){

    tabInsurerLimitRate.add(getInsurerLimitPanel(), VRLayout.CLIENT);

    tabInsurerLimitRate.add(getInsurerLimitRateInfos(), VRLayout.CLIENT);

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

    insurerLimitRateInfo.add(getValidPeriodPanel(), VRLayout.NORTH);

    insurerLimitRateInfo.add(getInsurerLimitRatePanel(), VRLayout.CLIENT);

  }

  /**
   * �L�����ԗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodPanel(){

    validPeriodPanel.add(getValidPeriodLeft(), VRLayout.NORTH);

    validPeriodPanel.add(getValidPeriodRight(), VRLayout.NORTH);

  }

  /**
   * �L�����ԗ̈捶�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodLeft(){

    validPeriodLeft.add(getJigyoTaishoshaContainer(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getJigyoTaishoshaOverContainer(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getJigyoTaishoshaOverComment(), VRLayout.FLOW_INSETLINE_RETURN);

    validPeriodLeft.add(getYosien1Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYosien2Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYosienContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    validPeriodLeft.add(getYokaigo1Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo2Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo3Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo4Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getYokaigo5Container(), VRLayout.FLOW_INSETLINE);

    validPeriodLeft.add(getValidPeriodCpntena(), VRLayout.FLOW_RETURN);

  }

  /**
   * ���ƑΏێ҃e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJigyoTaishosha(){

  }

  /**
   * ���ƑΏێ�(�v�x���P��)�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJigyoTaishoshaOver(){

  }

  /**
   * ���ƑΏێ҃R�����g�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJigyoTaishoshaOverComment(){

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
   * �L�����ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodCpntena(){

    validPeriodCpntena.add(getValidPeriodStart(), VRLayout.FLOW);

    validPeriodCpntena.add(getValidPeriodLabel(), VRLayout.FLOW);

    validPeriodCpntena.add(getValidPeriodEnd(), VRLayout.FLOW);

  }

  /**
   * �L�����ԃe�L�X�g(�J�n)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodStart(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodLabel(){

  }

  /**
   * �L�����ԃe�L�X�g(�I��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodEnd(){

  }

  /**
   * �L�����ԗ̈�E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addValidPeriodRight(){

    validPeriodRight.add(getInsurerLimitRateButtons(), VRLayout.WEST);

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateButtons(){

    insurerLimitRateButtons.add(getInsurerLimitRateRegularButton(), VRLayout.WEST);

    insurerLimitRateButtons.add(getInsurerLimitRateInsertButton(), VRLayout.WEST);

    insurerLimitRateButtons.add(getInsurerLimitRateEditButton(), VRLayout.WEST);

    insurerLimitRateButtons.add(getInsurerLimitRateDeleteButton(), VRLayout.WEST);

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

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum8());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum9());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum12());

    getInsurerLimitRateTableColumnModel().addColumn(getInsurerLimitRateTableColum13());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum1(){

  }

  /**
   * �ی��ҏ��L������(�J�n)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum8(){

  }

  /**
   * �ی��ҏ��L������(�I��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum9(){

  }

  /**
   * ���ƑΏێ҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum12(){

  }

  /**
   * ���ƑΏێ�(�v�x���P��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerLimitRateTableColum13(){

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
