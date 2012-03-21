
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
 * �J����: ����@��F
 * �쐬��: 2006/03/06  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ��Ë@�֊Ǘ� (010)
 * �v���O���� ��Ë@�֓o�^ (QO010)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo010;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * ��Ë@�֓o�^��ʍ��ڃf�U�C��(QO010) 
 */
public class QO010Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton newData;

  private ACAffairButton clear;

  private ACPanel medicalFacilityContents;

  private ACGroupBox medicalFacilityMainContents;

  private VRLayout medicalFacilityMainContentsLayout;

  private ACTextField medicalFacilityName;

  private ACLabelContainer medicalFacilityNameContainer;

  private ACLabelContainer medicalFacilityPostnoContena;

  private ACTextField medicalFacilityPostnoOn;

  private ACLabel medicalFacilityPostnoHyphen;

  private ACTextField medicalFacilityPostnoUnder;

  private ACTextField medicalFacilityAddress;

  private ACLabelContainer medicalFacilityAddressContainer;

  private ACLabelContainer medicalFacilityTelContena;

  private ACTextField medicalFacilityTelOn;

  private ACLabel medicalFacilityTelHyphen1;

  private ACTextField medicalFacilityTelInside;

  private ACLabel medicalFacilityTelHyphen2;

  private ACTextField medicalFacilityTelUnder;

  private ACLabelContainer medicalFacilityFaxContena;

  private ACTextField medicalFacilityFaxOn;

  private ACLabel medicalFacilityFaxHyphen1;

  private ACTextField medicalFacilityFaxInside;

  private ACLabel medicalFacilityFaxHyphen2;

  private ACTextField medicalFacilityFaxUnder;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("��Ë@�֓o�^");

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

      /** @TODO �{�^���̃L���v�V�����ɂ��ẮA�ǉ��̏ꍇ�́u�o�^�v�A�ҏW�̏ꍇ�́u�ҏW�v�Ƃ���B */

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

      newData.setToolTipText("��Ë@�ւ�V�K�ɍ쐬���܂��B");

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

      clear.setToolTipText("��Ë@�ւ̏����N���A���܂��B");

      clear.setMnemonic('C');

      clear.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClear();
    }
    return clear;

  }

  /**
   * ��Ë@�֏��̈���擾���܂��B
   * @return ��Ë@�֏��̈�
   */
  public ACPanel getMedicalFacilityContents(){
    if(medicalFacilityContents==null){

      medicalFacilityContents = new ACPanel();

      addMedicalFacilityContents();
    }
    return medicalFacilityContents;

  }

  /**
   * ��Ë@�փ��C�����̈���擾���܂��B
   * @return ��Ë@�փ��C�����̈�
   */
  public ACGroupBox getMedicalFacilityMainContents(){
    if(medicalFacilityMainContents==null){

      medicalFacilityMainContents = new ACGroupBox();

      medicalFacilityMainContents.setText("��{���");

      medicalFacilityMainContents.setLayout(getMedicalFacilityMainContentsLayout());

      addMedicalFacilityMainContents();
    }
    return medicalFacilityMainContents;

  }

  /**
   * ��Ë@�փ��C�����̈惌�C�A�E�g���擾���܂��B
   * @return ��Ë@�փ��C�����̈惌�C�A�E�g
   */
  public VRLayout getMedicalFacilityMainContentsLayout(){
    if(medicalFacilityMainContentsLayout==null){

      medicalFacilityMainContentsLayout = new VRLayout();

      medicalFacilityMainContentsLayout.setHgrid(200);

      addMedicalFacilityMainContentsLayout();
    }
    return medicalFacilityMainContentsLayout;

  }

  /**
   * ��Ë@�֖��̂��擾���܂��B
   * @return ��Ë@�֖���
   */
  public ACTextField getMedicalFacilityName(){
    if(medicalFacilityName==null){

      medicalFacilityName = new ACTextField();

      getMedicalFacilityNameContainer().setText("��Ë@�֖���");

      medicalFacilityName.setBindPath("MEDICAL_FACILITY_NAME");

      medicalFacilityName.setColumns(64);

      medicalFacilityName.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityName.setIMEMode(InputSubset.KANJI);

      medicalFacilityName.setMaxLength(64);

      addMedicalFacilityName();
    }
    return medicalFacilityName;

  }

  /**
   * ��Ë@�֖��̃R���e�i���擾���܂��B
   * @return ��Ë@�֖��̃R���e�i
   */
  protected ACLabelContainer getMedicalFacilityNameContainer(){
    if(medicalFacilityNameContainer==null){
      medicalFacilityNameContainer = new ACLabelContainer();
      medicalFacilityNameContainer.setFollowChildEnabled(true);
      medicalFacilityNameContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityNameContainer.add(getMedicalFacilityName(), null);
    }
    return medicalFacilityNameContainer;
  }

  /**
   * �X�֔ԍ��R���e�i���擾���܂��B
   * @return �X�֔ԍ��R���e�i
   */
  public ACLabelContainer getMedicalFacilityPostnoContena(){
    if(medicalFacilityPostnoContena==null){

      medicalFacilityPostnoContena = new ACLabelContainer();

      medicalFacilityPostnoContena.setText("�X�֔ԍ�");

      addMedicalFacilityPostnoContena();
    }
    return medicalFacilityPostnoContena;

  }

  /**
   * �X�֔ԍ��i����擾���܂��B
   * @return �X�֔ԍ��i��
   */
  public ACTextField getMedicalFacilityPostnoOn(){
    if(medicalFacilityPostnoOn==null){

      medicalFacilityPostnoOn = new ACTextField();

      medicalFacilityPostnoOn.setBindPath("MEDICAL_FACILITY_ZIP_FIRST");

      medicalFacilityPostnoOn.setColumns(3);

      medicalFacilityPostnoOn.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityPostnoOn.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityPostnoOn.setIMEMode(InputSubset.LATIN);

      medicalFacilityPostnoOn.setMaxLength(3);

      addMedicalFacilityPostnoOn();
    }
    return medicalFacilityPostnoOn;

  }

  /**
   * �n�C�t�����擾���܂��B
   * @return �n�C�t��
   */
  public ACLabel getMedicalFacilityPostnoHyphen(){
    if(medicalFacilityPostnoHyphen==null){

      medicalFacilityPostnoHyphen = new ACLabel();

      medicalFacilityPostnoHyphen.setText("-");

      addMedicalFacilityPostnoHyphen();
    }
    return medicalFacilityPostnoHyphen;

  }

  /**
   * �X�֔ԍ��i�����擾���܂��B
   * @return �X�֔ԍ��i��
   */
  public ACTextField getMedicalFacilityPostnoUnder(){
    if(medicalFacilityPostnoUnder==null){

      medicalFacilityPostnoUnder = new ACTextField();

      medicalFacilityPostnoUnder.setBindPath("MEDICAL_FACILITY_ZIP_SECOND");

      medicalFacilityPostnoUnder.setColumns(4);

      medicalFacilityPostnoUnder.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityPostnoUnder.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityPostnoUnder.setIMEMode(InputSubset.LATIN);

      medicalFacilityPostnoUnder.setMaxLength(4);

      addMedicalFacilityPostnoUnder();
    }
    return medicalFacilityPostnoUnder;

  }

  /**
   * ���ݒn���擾���܂��B
   * @return ���ݒn
   */
  public ACTextField getMedicalFacilityAddress(){
    if(medicalFacilityAddress==null){

      medicalFacilityAddress = new ACTextField();

      getMedicalFacilityAddressContainer().setText("���ݒn");

      medicalFacilityAddress.setBindPath("MEDICAL_FACILITY_ADDRESS");

      medicalFacilityAddress.setColumns(70);

      medicalFacilityAddress.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityAddress.setIMEMode(InputSubset.KANJI);

      medicalFacilityAddress.setMaxLength(70);

      addMedicalFacilityAddress();
    }
    return medicalFacilityAddress;

  }

  /**
   * ���ݒn�R���e�i���擾���܂��B
   * @return ���ݒn�R���e�i
   */
  protected ACLabelContainer getMedicalFacilityAddressContainer(){
    if(medicalFacilityAddressContainer==null){
      medicalFacilityAddressContainer = new ACLabelContainer();
      medicalFacilityAddressContainer.setFollowChildEnabled(true);
      medicalFacilityAddressContainer.setVAlignment(VRLayout.CENTER);
      medicalFacilityAddressContainer.add(getMedicalFacilityAddress(), null);
    }
    return medicalFacilityAddressContainer;
  }

  /**
   * �d�b�ԍ��R���e�i���擾���܂��B
   * @return �d�b�ԍ��R���e�i
   */
  public ACLabelContainer getMedicalFacilityTelContena(){
    if(medicalFacilityTelContena==null){

      medicalFacilityTelContena = new ACLabelContainer();

      medicalFacilityTelContena.setText("�d�b�ԍ�");

      addMedicalFacilityTelContena();
    }
    return medicalFacilityTelContena;

  }

  /**
   * �d�b�ԍ��i����擾���܂��B
   * @return �d�b�ԍ��i��
   */
  public ACTextField getMedicalFacilityTelOn(){
    if(medicalFacilityTelOn==null){

      medicalFacilityTelOn = new ACTextField();

      medicalFacilityTelOn.setBindPath("MEDICAL_FACILITY_TEL_FIRST");

      medicalFacilityTelOn.setColumns(5);

      medicalFacilityTelOn.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityTelOn.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityTelOn.setIMEMode(InputSubset.LATIN);

      medicalFacilityTelOn.setMaxLength(5);

      addMedicalFacilityTelOn();
    }
    return medicalFacilityTelOn;

  }

  /**
   * �n�C�t�����擾���܂��B
   * @return �n�C�t��
   */
  public ACLabel getMedicalFacilityTelHyphen1(){
    if(medicalFacilityTelHyphen1==null){

      medicalFacilityTelHyphen1 = new ACLabel();

      medicalFacilityTelHyphen1.setText("-");

      addMedicalFacilityTelHyphen1();
    }
    return medicalFacilityTelHyphen1;

  }

  /**
   * �d�b�ԍ��i�����擾���܂��B
   * @return �d�b�ԍ��i��
   */
  public ACTextField getMedicalFacilityTelInside(){
    if(medicalFacilityTelInside==null){

      medicalFacilityTelInside = new ACTextField();

      medicalFacilityTelInside.setBindPath("MEDICAL_FACILITY_TEL_SECOND");

      medicalFacilityTelInside.setColumns(4);

      medicalFacilityTelInside.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityTelInside.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityTelInside.setIMEMode(InputSubset.LATIN);

      medicalFacilityTelInside.setMaxLength(4);

      addMedicalFacilityTelInside();
    }
    return medicalFacilityTelInside;

  }

  /**
   * �n�C�t�����擾���܂��B
   * @return �n�C�t��
   */
  public ACLabel getMedicalFacilityTelHyphen2(){
    if(medicalFacilityTelHyphen2==null){

      medicalFacilityTelHyphen2 = new ACLabel();

      medicalFacilityTelHyphen2.setText("-");

      addMedicalFacilityTelHyphen2();
    }
    return medicalFacilityTelHyphen2;

  }

  /**
   * �d�b�ԍ��i�����擾���܂��B
   * @return �d�b�ԍ��i��
   */
  public ACTextField getMedicalFacilityTelUnder(){
    if(medicalFacilityTelUnder==null){

      medicalFacilityTelUnder = new ACTextField();

      medicalFacilityTelUnder.setBindPath("MEDICAL_FACILITY_TEL_THIRD");

      medicalFacilityTelUnder.setColumns(4);

      medicalFacilityTelUnder.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityTelUnder.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityTelUnder.setIMEMode(InputSubset.LATIN);

      medicalFacilityTelUnder.setMaxLength(4);

      addMedicalFacilityTelUnder();
    }
    return medicalFacilityTelUnder;

  }

  /**
   * FAX�ԍ��R���e�i���擾���܂��B
   * @return FAX�ԍ��R���e�i
   */
  public ACLabelContainer getMedicalFacilityFaxContena(){
    if(medicalFacilityFaxContena==null){

      medicalFacilityFaxContena = new ACLabelContainer();

      medicalFacilityFaxContena.setText("FAX�ԍ�");

      addMedicalFacilityFaxContena();
    }
    return medicalFacilityFaxContena;

  }

  /**
   * FAX�i����擾���܂��B
   * @return FAX�i��
   */
  public ACTextField getMedicalFacilityFaxOn(){
    if(medicalFacilityFaxOn==null){

      medicalFacilityFaxOn = new ACTextField();

      medicalFacilityFaxOn.setBindPath("MEDICAL_FACILITY_FAX_FIRST");

      medicalFacilityFaxOn.setColumns(5);

      medicalFacilityFaxOn.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityFaxOn.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityFaxOn.setIMEMode(InputSubset.LATIN);

      medicalFacilityFaxOn.setMaxLength(5);

      addMedicalFacilityFaxOn();
    }
    return medicalFacilityFaxOn;

  }

  /**
   * �n�C�t�����擾���܂��B
   * @return �n�C�t��
   */
  public ACLabel getMedicalFacilityFaxHyphen1(){
    if(medicalFacilityFaxHyphen1==null){

      medicalFacilityFaxHyphen1 = new ACLabel();

      medicalFacilityFaxHyphen1.setText("-");

      addMedicalFacilityFaxHyphen1();
    }
    return medicalFacilityFaxHyphen1;

  }

  /**
   * FAX�i�����擾���܂��B
   * @return FAX�i��
   */
  public ACTextField getMedicalFacilityFaxInside(){
    if(medicalFacilityFaxInside==null){

      medicalFacilityFaxInside = new ACTextField();

      medicalFacilityFaxInside.setBindPath("MEDICAL_FACILITY_FAX_SECOND");

      medicalFacilityFaxInside.setColumns(4);

      medicalFacilityFaxInside.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityFaxInside.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityFaxInside.setIMEMode(InputSubset.LATIN);

      medicalFacilityFaxInside.setMaxLength(4);

      addMedicalFacilityFaxInside();
    }
    return medicalFacilityFaxInside;

  }

  /**
   * �n�C�t�����擾���܂��B
   * @return �n�C�t��
   */
  public ACLabel getMedicalFacilityFaxHyphen2(){
    if(medicalFacilityFaxHyphen2==null){

      medicalFacilityFaxHyphen2 = new ACLabel();

      medicalFacilityFaxHyphen2.setText("-");

      addMedicalFacilityFaxHyphen2();
    }
    return medicalFacilityFaxHyphen2;

  }

  /**
   * FAX�i�����擾���܂��B
   * @return FAX�i��
   */
  public ACTextField getMedicalFacilityFaxUnder(){
    if(medicalFacilityFaxUnder==null){

      medicalFacilityFaxUnder = new ACTextField();

      medicalFacilityFaxUnder.setBindPath("MEDICAL_FACILITY_FAX_THIRD");

      medicalFacilityFaxUnder.setColumns(4);

      medicalFacilityFaxUnder.setCharType(VRCharType.ONLY_DIGIT);

      medicalFacilityFaxUnder.setHorizontalAlignment(SwingConstants.LEFT);

      medicalFacilityFaxUnder.setIMEMode(InputSubset.LATIN);

      medicalFacilityFaxUnder.setMaxLength(4);

      addMedicalFacilityFaxUnder();
    }
    return medicalFacilityFaxUnder;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO010Design() {

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

    this.add(getMedicalFacilityContents(), VRLayout.CLIENT);

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
   * ��Ë@�֏��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityContents(){

    medicalFacilityContents.add(getMedicalFacilityMainContents(), VRLayout.NORTH);

  }

  /**
   * ��Ë@�փ��C�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityMainContents(){

    medicalFacilityMainContents.add(getMedicalFacilityNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityMainContents.add(getMedicalFacilityPostnoContena(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityMainContents.add(getMedicalFacilityAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityMainContents.add(getMedicalFacilityTelContena(), VRLayout.FLOW_INSETLINE_RETURN);

    medicalFacilityMainContents.add(getMedicalFacilityFaxContena(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ��Ë@�փ��C�����̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityMainContentsLayout(){

  }

  /**
   * ��Ë@�֖��̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityName(){

  }

  /**
   * �X�֔ԍ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityPostnoContena(){

    medicalFacilityPostnoContena.add(getMedicalFacilityPostnoOn(), null);

    medicalFacilityPostnoContena.add(getMedicalFacilityPostnoHyphen(), null);

    medicalFacilityPostnoContena.add(getMedicalFacilityPostnoUnder(), null);

  }

  /**
   * �X�֔ԍ��i��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityPostnoOn(){

  }

  /**
   * �n�C�t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityPostnoHyphen(){

  }

  /**
   * �X�֔ԍ��i���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityPostnoUnder(){

  }

  /**
   * ���ݒn�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityAddress(){

  }

  /**
   * �d�b�ԍ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTelContena(){

    medicalFacilityTelContena.add(getMedicalFacilityTelOn(), null);

    medicalFacilityTelContena.add(getMedicalFacilityTelHyphen1(), null);

    medicalFacilityTelContena.add(getMedicalFacilityTelInside(), null);

    medicalFacilityTelContena.add(getMedicalFacilityTelHyphen2(), null);

    medicalFacilityTelContena.add(getMedicalFacilityTelUnder(), null);

  }

  /**
   * �d�b�ԍ��i��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTelOn(){

  }

  /**
   * �n�C�t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTelHyphen1(){

  }

  /**
   * �d�b�ԍ��i���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTelInside(){

  }

  /**
   * �n�C�t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTelHyphen2(){

  }

  /**
   * �d�b�ԍ��i���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityTelUnder(){

  }

  /**
   * FAX�ԍ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityFaxContena(){

    medicalFacilityFaxContena.add(getMedicalFacilityFaxOn(), null);

    medicalFacilityFaxContena.add(getMedicalFacilityFaxHyphen1(), null);

    medicalFacilityFaxContena.add(getMedicalFacilityFaxInside(), null);

    medicalFacilityFaxContena.add(getMedicalFacilityFaxHyphen2(), null);

    medicalFacilityFaxContena.add(getMedicalFacilityFaxUnder(), null);

  }

  /**
   * FAX�i��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityFaxOn(){

  }

  /**
   * �n�C�t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityFaxHyphen1(){

  }

  /**
   * FAX�i���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityFaxInside(){

  }

  /**
   * �n�C�t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityFaxHyphen2(){

  }

  /**
   * FAX�i���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalFacilityFaxUnder(){

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

    return getMedicalFacilityName();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QO010Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO010Design getThis() {
    return this;
  }
}
