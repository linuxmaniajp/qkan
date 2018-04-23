
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
 * �J����: �T��@�z��Y
 * �쐬��: 2017/06/19  ���{�R���s���[�^�[������� �T��@�z��Y �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�P�A�}�l�W�����g (QS001_51511_201804)
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
 * �T�[�r�X�p�^�[�����\�h�P�A�}�l�W�����g��ʍ��ڃf�U�C��(QS001_51511_201804) 
 */
public class QS001_51511_201804Design extends QS001ServicePanelSogo {
  //GUI�R���|�[�l���g

  private ACPanel soAFPatterns;

  private ACPanel soAFDetail;

  private ACComboBox insurerName;

  private ACLabelContainer insurerNameContainer;

  private ACComboBoxModelAdapter insurerNameModel;

  private ACBackLabelContainer soAFItemCodeContena;

  private ACTextField itemCodeText;

  private ACLabelContainer itemCodeTextContainer;

  private ACButton addCodeToListButton;

  private ACButton codeFindButton;

  private ACButton deleteCodeButton;

  private ACTable svCodeTable;

  private VRTableColumnModel svCodeTableColumnModel;

  private ACTableColumn svCodeTableColumn1;

  private ACTableColumn svCodeTableColumn2;

  private ACTableColumn svCodeTableColumn3;

  private ACTableColumn svCodeTableColumn4;

  private ACTableColumn svCodeTableColumn5;

  private ACTextField careManagerNoText;

  private ACLabelContainer careManagerNoTextContainer;

  private ACComboBox careManagerNameCombo;

  private ACLabelContainer careManagerNameComboContainer;

  private ACComboBoxModelAdapter careManagerNameComboModel;

  private ACGroupBox consignmentGroup;

  private ACComboBox consignmentProvider;

  private ACLabelContainer consignmentProviderContainer;

  private ACComboBoxModelAdapter consignmentProviderModel;

  private ACTextField consignmentCareManagerNoText;

  private ACLabelContainer consignmentCareManagerNoTextContainer;

  private ACComboBox consignmentCareManagerNameCombo;

  private ACLabelContainer consignmentCareManagerNameComboContainer;

  private ACComboBoxModelAdapter consignmentCareManagerNameComboModel;

  //getter

  /**
   * �K��^�T�[�r�X�Ǝ��藦�p�^�[���̈���擾���܂��B
   * @return �K��^�T�[�r�X�Ǝ��藦�p�^�[���̈�
   */
  public ACPanel getSoAFPatterns(){
    if(soAFPatterns==null){

      soAFPatterns = new ACPanel();

      soAFPatterns.setAutoWrap(false);

      addSoAFPatterns();
    }
    return soAFPatterns;

  }

  /**
   * ���e�p�l�����擾���܂��B
   * @return ���e�p�l��
   */
  public ACPanel getSoAFDetail(){
    if(soAFDetail==null){

      soAFDetail = new ACPanel();

      soAFDetail.setHgrid(200);

      addSoAFDetail();
    }
    return soAFDetail;

  }

  /**
   * �ی��Җ����擾���܂��B
   * @return �ی��Җ�
   */
  public ACComboBox getInsurerName(){
    if(insurerName==null){

      insurerName = new ACComboBox();

      getInsurerNameContainer().setText("�ی��Җ�");

      insurerName.setBindPath("500");

      insurerName.setEditable(false);

      insurerName.setColumns(10);

      insurerName.setModelBindPath("INSURER");

      insurerName.setRenderBindPath("INSURER_NAME");

      insurerName.setMaxColumns(18);

      insurerName.setModel(getInsurerNameModel());

      addInsurerName();
    }
    return insurerName;

  }

  /**
   * �ی��Җ��R���e�i���擾���܂��B
   * @return �ی��Җ��R���e�i
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
   * �ی��Җ����f�����擾���܂��B
   * @return �ی��Җ����f��
   */
  protected ACComboBoxModelAdapter getInsurerNameModel(){
    if(insurerNameModel==null){
      insurerNameModel = new ACComboBoxModelAdapter();
      addInsurerNameModel();
    }
    return insurerNameModel;
  }

  /**
   * �T�[�r�X���ڃR�[�h�R���e�i���擾���܂��B
   * @return �T�[�r�X���ڃR�[�h�R���e�i
   */
  public ACBackLabelContainer getSoAFItemCodeContena(){
    if(soAFItemCodeContena==null){

      soAFItemCodeContena = new ACBackLabelContainer();

      addSoAFItemCodeContena();
    }
    return soAFItemCodeContena;

  }

  /**
   * �T�[�r�X���ڃR�[�h�e�L�X�g���擾���܂��B
   * @return �T�[�r�X���ڃR�[�h�e�L�X�g
   */
  public ACTextField getItemCodeText(){
    if(itemCodeText==null){

      itemCodeText = new ACTextField();

      getItemCodeTextContainer().setText("AF");

      itemCodeText.setColumns(4);

      itemCodeText.setIMEMode(InputSubset.LATIN);

      itemCodeText.setMaxLength(4);

      addItemCodeText();
    }
    return itemCodeText;

  }

  /**
   * �T�[�r�X���ڃR�[�h�e�L�X�g�R���e�i���擾���܂��B
   * @return �T�[�r�X���ڃR�[�h�e�L�X�g�R���e�i
   */
  protected ACLabelContainer getItemCodeTextContainer(){
    if(itemCodeTextContainer==null){
      itemCodeTextContainer = new ACLabelContainer();
      itemCodeTextContainer.setFollowChildEnabled(true);
      itemCodeTextContainer.setVAlignment(VRLayout.CENTER);
      itemCodeTextContainer.add(getItemCodeText(), null);
    }
    return itemCodeTextContainer;
  }

  /**
   * �R�[�h���ꗗ�֒ǉ����擾���܂��B
   * @return �R�[�h���ꗗ�֒ǉ�
   */
  public ACButton getAddCodeToListButton(){
    if(addCodeToListButton==null){

      addCodeToListButton = new ACButton();

      addCodeToListButton.setText("�R�[�h���ꗗ�֒ǉ�");

      addAddCodeToListButton();
    }
    return addCodeToListButton;

  }

  /**
   * �R�[�h�I�����擾���܂��B
   * @return �R�[�h�I��
   */
  public ACButton getCodeFindButton(){
    if(codeFindButton==null){

      codeFindButton = new ACButton();

      codeFindButton.setText("�R�[�h�I��");

      addCodeFindButton();
    }
    return codeFindButton;

  }

  /**
   * �R�[�h�폜���擾���܂��B
   * @return �R�[�h�폜
   */
  public ACButton getDeleteCodeButton(){
    if(deleteCodeButton==null){

      deleteCodeButton = new ACButton();

      deleteCodeButton.setText("�R�[�h�폜");

      addDeleteCodeButton();
    }
    return deleteCodeButton;

  }

  /**
   * ��ȓ��퐶���e�[�u�����擾���܂��B
   * @return ��ȓ��퐶���e�[�u��
   */
  public ACTable getSvCodeTable(){
    if(svCodeTable==null){

      svCodeTable = new ACTable();

      svCodeTable.setColumnModel(getSvCodeTableColumnModel());

      svCodeTable.setPreferredSize(new Dimension(305,70));

      addSvCodeTable();
    }
    return svCodeTable;

  }

  /**
   * ��ȓ��퐶���e�[�u���J�������f�����擾���܂��B
   * @return ��ȓ��퐶���e�[�u���J�������f��
   */
  protected VRTableColumnModel getSvCodeTableColumnModel(){
    if(svCodeTableColumnModel==null){
      svCodeTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addSvCodeTableColumnModel();
    }
    return svCodeTableColumnModel;
  }

  /**
   * �R�[�h���擾���܂��B
   * @return �R�[�h
   */
  public ACTableColumn getSvCodeTableColumn1(){
    if(svCodeTableColumn1==null){

      svCodeTableColumn1 = new ACTableColumn();

      svCodeTableColumn1.setHeaderValue("�R�[�h");

      svCodeTableColumn1.setColumnName("SERVICE_CODE_ITEM");

      svCodeTableColumn1.setColumns(5);

      addSvCodeTableColumn1();
    }
    return svCodeTableColumn1;

  }

  /**
   * ���̂��擾���܂��B
   * @return ����
   */
  public ACTableColumn getSvCodeTableColumn2(){
    if(svCodeTableColumn2==null){

      svCodeTableColumn2 = new ACTableColumn();

      svCodeTableColumn2.setHeaderValue("����");

      svCodeTableColumn2.setColumnName("SERVICE_NAME");

      svCodeTableColumn2.setColumns(14);

      addSvCodeTableColumn2();
    }
    return svCodeTableColumn2;

  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTableColumn getSvCodeTableColumn3(){
    if(svCodeTableColumn3==null){

      svCodeTableColumn3 = new ACTableColumn();

      svCodeTableColumn3.setHeaderValue("�P�ʐ�");

      svCodeTableColumn3.setColumnName("SERVICE_UNIT");

      svCodeTableColumn3.setColumns(3);

      svCodeTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addSvCodeTableColumn3();
    }
    return svCodeTableColumn3;

  }

  /**
   * ���t�����擾���܂��B
   * @return ���t��
   */
  public ACTableColumn getSvCodeTableColumn4(){
    if(svCodeTableColumn4==null){

      svCodeTableColumn4 = new ACTableColumn();

      svCodeTableColumn4.setHeaderValue("���t��");

      svCodeTableColumn4.setColumnName("KYUFURITSU");

      svCodeTableColumn4.setColumns(3);

      svCodeTableColumn4.setHorizontalAlignment(SwingConstants.RIGHT);

      addSvCodeTableColumn4();
    }
    return svCodeTableColumn4;

  }

  /**
   * �ی��Ҕԍ����擾���܂��B
   * @return �ی��Ҕԍ�
   */
  public ACTableColumn getSvCodeTableColumn5(){
    if(svCodeTableColumn5==null){

      svCodeTableColumn5 = new ACTableColumn();

      svCodeTableColumn5.setHeaderValue("�ی��Ҕԍ�");

      svCodeTableColumn5.setColumnName("INSURER_ID");

      svCodeTableColumn5.setColumns(6);

      addSvCodeTableColumn5();
    }
    return svCodeTableColumn5;

  }

  /**
   * ���x�������ԍ����擾���܂��B
   * @return ���x�������ԍ�
   */
  public ACTextField getCareManagerNoText(){
    if(careManagerNoText==null){

      careManagerNoText = new ACTextField();

      getCareManagerNoTextContainer().setText("���x�������ԍ�");

      careManagerNoText.setBindPath("1430107");

      careManagerNoText.setColumns(10);

      careManagerNoText.setCharType(VRCharType.ONLY_DIGIT);

      careManagerNoText.setMaxLength(8);

      addCareManagerNoText();
    }
    return careManagerNoText;

  }

  /**
   * ���x�������ԍ��R���e�i���擾���܂��B
   * @return ���x�������ԍ��R���e�i
   */
  protected ACLabelContainer getCareManagerNoTextContainer(){
    if(careManagerNoTextContainer==null){
      careManagerNoTextContainer = new ACLabelContainer();
      careManagerNoTextContainer.setFollowChildEnabled(true);
      careManagerNoTextContainer.setVAlignment(VRLayout.CENTER);
      careManagerNoTextContainer.add(getCareManagerNoText(), null);
    }
    return careManagerNoTextContainer;
  }

  /**
   * ���x�������������擾���܂��B
   * @return ���x����������
   */
  public ACComboBox getCareManagerNameCombo(){
    if(careManagerNameCombo==null){

      careManagerNameCombo = new ACComboBox();

      getCareManagerNameComboContainer().setText("���x����������");

      careManagerNameCombo.setEditable(false);

      careManagerNameCombo.setRenderBindPath("STAFF_NAME");

      careManagerNameCombo.setBlankable(true);

      careManagerNameCombo.setIMEMode(InputSubset.KANJI);

      careManagerNameCombo.setMaxLength(30);

      careManagerNameCombo.setMaxColumns(10);

      careManagerNameCombo.setModel(getCareManagerNameComboModel());

      addCareManagerNameCombo();
    }
    return careManagerNameCombo;

  }

  /**
   * ���x�����������R���e�i���擾���܂��B
   * @return ���x�����������R���e�i
   */
  protected ACLabelContainer getCareManagerNameComboContainer(){
    if(careManagerNameComboContainer==null){
      careManagerNameComboContainer = new ACLabelContainer();
      careManagerNameComboContainer.setFollowChildEnabled(true);
      careManagerNameComboContainer.setVAlignment(VRLayout.CENTER);
      careManagerNameComboContainer.add(getCareManagerNameCombo(), null);
    }
    return careManagerNameComboContainer;
  }

  /**
   * ���x�������������f�����擾���܂��B
   * @return ���x�������������f��
   */
  protected ACComboBoxModelAdapter getCareManagerNameComboModel(){
    if(careManagerNameComboModel==null){
      careManagerNameComboModel = new ACComboBoxModelAdapter();
      addCareManagerNameComboModel();
    }
    return careManagerNameComboModel;
  }

  /**
   * �ϑ���O���[�v���擾���܂��B
   * @return �ϑ���O���[�v
   */
  public ACGroupBox getConsignmentGroup(){
    if(consignmentGroup==null){

      consignmentGroup = new ACGroupBox();

      consignmentGroup.setText("�ϑ���");

      consignmentGroup.setFollowChildEnabled(true);

      consignmentGroup.setHgap(0);

      consignmentGroup.setLabelMargin(0);

      consignmentGroup.setVgap(0);

      addConsignmentGroup();
    }
    return consignmentGroup;

  }

  /**
   * �ϑ��掖�Ə����擾���܂��B
   * @return �ϑ��掖�Ə�
   */
  public ACComboBox getConsignmentProvider(){
    if(consignmentProvider==null){

      consignmentProvider = new ACComboBox();

      getConsignmentProviderContainer().setText("�ϑ��掖�Ə�");

      consignmentProvider.setBindPath("1460102");

      consignmentProvider.setEditable(false);

      consignmentProvider.setRenderBindPath("PROVIDER_NAME");

      consignmentProvider.setBlankable(true);

      consignmentProvider.setIMEMode(InputSubset.KANJI);

      consignmentProvider.setMaxLength(60);

      consignmentProvider.setMaxColumns(10);

      consignmentProvider.setModel(getConsignmentProviderModel());

      addConsignmentProvider();
    }
    return consignmentProvider;

  }

  /**
   * �ϑ��掖�Ə��R���e�i���擾���܂��B
   * @return �ϑ��掖�Ə��R���e�i
   */
  protected ACLabelContainer getConsignmentProviderContainer(){
    if(consignmentProviderContainer==null){
      consignmentProviderContainer = new ACLabelContainer();
      consignmentProviderContainer.setFollowChildEnabled(true);
      consignmentProviderContainer.setVAlignment(VRLayout.CENTER);
      consignmentProviderContainer.add(getConsignmentProvider(), null);
    }
    return consignmentProviderContainer;
  }

  /**
   * �ϑ��掖�Ə����f�����擾���܂��B
   * @return �ϑ��掖�Ə����f��
   */
  protected ACComboBoxModelAdapter getConsignmentProviderModel(){
    if(consignmentProviderModel==null){
      consignmentProviderModel = new ACComboBoxModelAdapter();
      addConsignmentProviderModel();
    }
    return consignmentProviderModel;
  }

  /**
   * ���x�������ԍ����擾���܂��B
   * @return ���x�������ԍ�
   */
  public ACTextField getConsignmentCareManagerNoText(){
    if(consignmentCareManagerNoText==null){

      consignmentCareManagerNoText = new ACTextField();

      getConsignmentCareManagerNoTextContainer().setText("���x�������ԍ�");

      consignmentCareManagerNoText.setBindPath("1460103");

      consignmentCareManagerNoText.setColumns(10);

      consignmentCareManagerNoText.setCharType(VRCharType.ONLY_DIGIT);

      consignmentCareManagerNoText.setMaxLength(8);

      addConsignmentCareManagerNoText();
    }
    return consignmentCareManagerNoText;

  }

  /**
   * ���x�������ԍ��R���e�i���擾���܂��B
   * @return ���x�������ԍ��R���e�i
   */
  protected ACLabelContainer getConsignmentCareManagerNoTextContainer(){
    if(consignmentCareManagerNoTextContainer==null){
      consignmentCareManagerNoTextContainer = new ACLabelContainer();
      consignmentCareManagerNoTextContainer.setFollowChildEnabled(true);
      consignmentCareManagerNoTextContainer.setVAlignment(VRLayout.CENTER);
      consignmentCareManagerNoTextContainer.add(getConsignmentCareManagerNoText(), null);
    }
    return consignmentCareManagerNoTextContainer;
  }

  /**
   * ���x�����������擾���܂��B
   * @return ���x��������
   */
  public ACComboBox getConsignmentCareManagerNameCombo(){
    if(consignmentCareManagerNameCombo==null){

      consignmentCareManagerNameCombo = new ACComboBox();

      getConsignmentCareManagerNameComboContainer().setText("���x����������");

      consignmentCareManagerNameCombo.setEditable(false);

      consignmentCareManagerNameCombo.setRenderBindPath("CONSIGNMENT_STAFF_NAME");

      consignmentCareManagerNameCombo.setBlankable(true);

      consignmentCareManagerNameCombo.setIMEMode(InputSubset.KANJI);

      consignmentCareManagerNameCombo.setMaxLength(30);

      consignmentCareManagerNameCombo.setMaxColumns(10);

      consignmentCareManagerNameCombo.setModel(getConsignmentCareManagerNameComboModel());

      addConsignmentCareManagerNameCombo();
    }
    return consignmentCareManagerNameCombo;

  }

  /**
   * ���x���������R���e�i���擾���܂��B
   * @return ���x���������R���e�i
   */
  protected ACLabelContainer getConsignmentCareManagerNameComboContainer(){
    if(consignmentCareManagerNameComboContainer==null){
      consignmentCareManagerNameComboContainer = new ACLabelContainer();
      consignmentCareManagerNameComboContainer.setFollowChildEnabled(true);
      consignmentCareManagerNameComboContainer.setVAlignment(VRLayout.CENTER);
      consignmentCareManagerNameComboContainer.add(getConsignmentCareManagerNameCombo(), null);
    }
    return consignmentCareManagerNameComboContainer;
  }

  /**
   * ���x�����������f�����擾���܂��B
   * @return ���x�����������f��
   */
  protected ACComboBoxModelAdapter getConsignmentCareManagerNameComboModel(){
    if(consignmentCareManagerNameComboModel==null){
      consignmentCareManagerNameComboModel = new ACComboBoxModelAdapter();
      addConsignmentCareManagerNameComboModel();
    }
    return consignmentCareManagerNameComboModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001_51511_201804Design() {

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

    this.add(getSoAFPatterns(), VRLayout.WEST);

  }

  /**
   * �K��^�T�[�r�X�Ǝ��藦�p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoAFPatterns(){

    soAFPatterns.add(getSoAFDetail(), VRLayout.NORTH);

    soAFPatterns.add(getCareManagerNoTextContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    soAFPatterns.add(getCareManagerNameComboContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    soAFPatterns.add(getConsignmentGroup(), VRLayout.FLOW);

  }

  /**
   * ���e�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoAFDetail(){

    soAFDetail.add(getInsurerNameContainer(), VRLayout.FLOW_INSETLINE);

    soAFDetail.add(getSoAFItemCodeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    soAFDetail.add(getCodeFindButton(), VRLayout.FLOW);

    soAFDetail.add(getDeleteCodeButton(), VRLayout.FLOW_RETURN);

    soAFDetail.add(getSvCodeTable(), VRLayout.FLOW_RETURN);

  }

  /**
   * �ی��Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerName(){

  }

  /**
   * �ی��Җ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInsurerNameModel(){

  }

  /**
   * �T�[�r�X���ڃR�[�h�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSoAFItemCodeContena(){

    soAFItemCodeContena.add(getItemCodeTextContainer(), VRLayout.FLOW);

    soAFItemCodeContena.add(getAddCodeToListButton(), VRLayout.FLOW);

  }

  /**
   * �T�[�r�X���ڃR�[�h�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addItemCodeText(){

  }

  /**
   * �R�[�h���ꗗ�֒ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAddCodeToListButton(){

  }

  /**
   * �R�[�h�I���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCodeFindButton(){

  }

  /**
   * �R�[�h�폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDeleteCodeButton(){

  }

  /**
   * ��ȓ��퐶���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTable(){

  }

  /**
   * ��ȓ��퐶���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumnModel(){

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn1());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn2());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn3());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn4());

    getSvCodeTableColumnModel().addColumn(getSvCodeTableColumn5());

  }

  /**
   * �R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumn1(){

  }

  /**
   * ���̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumn2(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumn3(){

  }

  /**
   * ���t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumn4(){

  }

  /**
   * �ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSvCodeTableColumn5(){

  }

  /**
   * ���x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareManagerNoText(){

  }

  /**
   * ���x�����������ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareManagerNameCombo(){

  }

  /**
   * ���x�������������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCareManagerNameComboModel(){

  }

  /**
   * �ϑ���O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentGroup(){

    consignmentGroup.add(getConsignmentProviderContainer(), VRLayout.FLOW_RETURN);

    consignmentGroup.add(getConsignmentCareManagerNoTextContainer(), VRLayout.FLOW_RETURN);

    consignmentGroup.add(getConsignmentCareManagerNameComboContainer(), VRLayout.FLOW);

  }

  /**
   * �ϑ��掖�Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentProvider(){

  }

  /**
   * �ϑ��掖�Ə����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentProviderModel(){

  }

  /**
   * ���x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentCareManagerNoText(){

  }

  /**
   * ���x���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentCareManagerNameCombo(){

  }

  /**
   * ���x�����������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addConsignmentCareManagerNameComboModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_51511_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001_51511_201804Design getThis() {
    return this;
  }
}
