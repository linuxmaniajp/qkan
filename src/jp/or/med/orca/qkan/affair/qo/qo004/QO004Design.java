
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
 * �J����: �����@���̂�
 * �쐬��: 2015/01/30  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� ���Ǝғo�^ (QO004)
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
 * ���Ǝғo�^��ʍ��ڃf�U�C��(QO004) 
 */
public class QO004Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton newData;

  private ACAffairButton clear;

  private ACPanel providerContents;

  private ACPanel providerMainContents;

  private VRLayout providerMainContentsLayout;

  private ACTextField providerId;

  private ACLabelContainer providerIdContainer;

  private ACTextField providerName;

  private ACLabelContainer providerNameContainer;

  private ACLabelContainer providerPostnoContena;

  private ACTextField providerPostnoOn;

  private ACLabel providerPostnoHyphen;

  private ACTextField providerPostnoUnder;

  private ACTextField providerAddress;

  private ACLabelContainer providerAddressContainer;

  private ACLabelContainer providerTelContena;

  private ACTextField providerTelOn;

  private ACLabel providerTelHyphen1;

  private ACTextField providerTelInside;

  private ACLabel providerTelHyphen2;

  private ACTextField providerTelUnder;

  private ACLabelContainer providerFaxContena;

  private ACTextField providerFaxOn;

  private ACLabel providerFaxHyphen1;

  private ACTextField providerFaxInside;

  private ACLabel providerFaxHyphen2;

  private ACTextField providerFaxUnder;

  private ACTextField providerEstablishName;

  private ACLabelContainer providerEstablishNameContainer;

  private ACValueArrayRadioButtonGroup providerMainContentDivision;

  private ACLabelContainer providerMainContentDivisionContainer;

  private ACListModelAdapter providerMainContentDivisionModel;

  private ACRadioButtonItem providerMainContentDivisionMine;

  private ACRadioButtonItem providerMainContentDivisionOther;

  private ACValueArrayRadioButtonGroup providerMainContentBusiness;

  private ACLabelContainer providerMainContentBusinessContainer;

  private ACListModelAdapter providerMainContentBusinessModel;

  private ACRadioButtonItem providerMainContentBusinessSpecification;

  private ACRadioButtonItem providerMainContentBusinessStandard;

  private ACRadioButtonItem providerMainContentBusinessRegion;

  private ACIntegerCheckBox medical;

  private ACComboBox providerType;

  private ACLabelContainer providerTypeContainer;

  private ACComboBoxModelAdapter providerTypeModel;

  private ACValueArrayRadioButtonGroup providerMainContentRegion;

  private ACLabelContainer providerMainContentRegionContainer;

  private ACListModelAdapter providerMainContentRegionModel;

  private ACRadioButtonItem providerMainContentRegionLank1;

  private ACRadioButtonItem providerMainContentRegionLank2;

  private ACRadioButtonItem providerMainContentRegionLank3;

  private ACRadioButtonItem providerMainContentRegionLank4;

  private ACRadioButtonItem providerMainContentRegionLank5;

  private ACRadioButtonItem providerMainContentRegionLank6;

  private ACRadioButtonItem providerMainContentRegionLank7;

  private ACRadioButtonItem providerMainContentRegionLank8;

  private ACIntegerCheckBox lankSpecialArea;

  private ACPanel providerSubContents;

  private ACPanel providerDetailContents;

  private ACPanel providerDetailServiceKinds;

  private ACGroupBox serviceKindOffer;

  private ACPanel serviceKindTablePanel;

  private ACTable serviceKindTable;

  private VRTableColumnModel serviceKindTableColumnModel;

  private ACTableColumn serviceKindTableColum1;

  private ACTableColumn serviceKindTableColum2;

  private ACPanel buttonsPanel;

  private ACIntegerCheckBox offerCheck;

  private ACButton reflection;

  private ACPanel claimInfos;

  private ACTextField bankName;

  private ACLabelContainer bankNameContainer;

  private ACTextField bankBranchName;

  private ACLabelContainer bankBranchNameContainer;

  private ACTextField accountNumber;

  private ACLabelContainer accountNumberContainer;

  private ACValueArrayRadioButtonGroup accountTypeRadio;

  private ACLabelContainer accountTypeRadioContainer;

  private ACListModelAdapter accountTypeRadioModel;

  private ACRadioButtonItem accountTypeRadioItem1;

  private ACRadioButtonItem accountTypeRadioItem2;

  private ACTextField accountHolder;

  private ACLabelContainer accountHolderContainer;

  private ACPanel providerMainContentChargesPanel;

  private ACGroupBox providerStaffGroup;

  private ACPanel providerStaffTablePanel;

  private ACTable providerStaffTable;

  private VRTableColumnModel providerStaffTableColumnModel;

  private ACTableColumn providerStaffTableColumn1;

  private ACTableColumn providerStaffTableColumn2;

  private ACTableColumn providerStaffTableColumn3;

  private ACPanel providerStaffInputPanel;

  private ACTextField providerStaffCareManagerNo;

  private ACLabelContainer providerStaffCareManagerNoContainer;

  private ACLabelContainer providerStaffNameContainer;

  private ACBackLabelContainer providerStaffFamilyNameContainer;

  private ACTextField providerStaffFamilyName;

  private ACBackLabelContainer providerStaffFirstNameContainer;

  private ACTextField providerStaffFirstName;

  private ACPanel providerStaffTableControlPanel;

  private ACButton providerStaffInsert;

  private ACButton providerStaffFind;

  private ACButton providerStaffDelete;

  private ACPanel providerDetailServiceDetails;

  private ACGroupBox explanationTitleGroup;

  private ACLabel explanationTitleLabel;

  private ACLabel explanationContentLabel1;

  private ACLabel explanationContentLabe2;

  private ACLabel explanationContentLabe3;

  private ACLabel explanationContentLabel4;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("���Ə��o�^");

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

      newData.setToolTipText("���Ə���V�K�ɍ쐬���܂��B");

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

      clear.setToolTipText("���Ə��̏����N���A���܂��B");

      clear.setMnemonic('C');

      clear.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClear();
    }
    return clear;

  }

  /**
   * ���Ə����̈���擾���܂��B
   * @return ���Ə����̈�
   */
  public ACPanel getProviderContents(){
    if(providerContents==null){

      providerContents = new ACPanel();

      addProviderContents();
    }
    return providerContents;

  }

  /**
   * ���Ə����C�����̈���擾���܂��B
   * @return ���Ə����C�����̈�
   */
  public ACPanel getProviderMainContents(){
    if(providerMainContents==null){

      providerMainContents = new ACPanel();

      providerMainContents.setLayout(getProviderMainContentsLayout());

      providerMainContents.setAutoWrap(false);

      addProviderMainContents();
    }
    return providerMainContents;

  }

  /**
   * ���Ə����C�����̈惌�C�A�E�g���擾���܂��B
   * @return ���Ə����C�����̈惌�C�A�E�g
   */
  public VRLayout getProviderMainContentsLayout(){
    if(providerMainContentsLayout==null){

      providerMainContentsLayout = new VRLayout();

      providerMainContentsLayout.setHgrid(200);

      addProviderMainContentsLayout();
    }
    return providerMainContentsLayout;

  }

  /**
   * ���Ə��ԍ����擾���܂��B
   * @return ���Ə��ԍ�
   */
  public ACTextField getProviderId(){
    if(providerId==null){

      providerId = new ACTextField();

      getProviderIdContainer().setText("���Ə��ԍ�");

      providerId.setBindPath("PROVIDER_ID");

      providerId.setColumns(8);

      providerId.setCharType(VRCharType.ONLY_ALNUM);

      providerId.setHorizontalAlignment(SwingConstants.LEFT);

      providerId.setIMEMode(InputSubset.LATIN);

      providerId.setMaxLength(10);

      /** @TODO 2014�N�x�����@�p������ */

      addProviderId();
    }
    return providerId;

  }

  /**
   * ���Ə��ԍ��R���e�i���擾���܂��B
   * @return ���Ə��ԍ��R���e�i
   */
  protected ACLabelContainer getProviderIdContainer(){
    if(providerIdContainer==null){
      providerIdContainer = new ACLabelContainer();
      providerIdContainer.setFollowChildEnabled(true);
      providerIdContainer.setVAlignment(VRLayout.CENTER);
      providerIdContainer.add(getProviderId(), null);
    }
    return providerIdContainer;
  }

  /**
   * ���Ə����̂��擾���܂��B
   * @return ���Ə�����
   */
  public ACTextField getProviderName(){
    if(providerName==null){

      providerName = new ACTextField();

      getProviderNameContainer().setText("���Ə�����");

      providerName.setBindPath("PROVIDER_NAME");

      providerName.setColumns(64);

      providerName.setHorizontalAlignment(SwingConstants.LEFT);

      providerName.setIMEMode(InputSubset.KANJI);

      providerName.setMaxLength(64);

      addProviderName();
    }
    return providerName;

  }

  /**
   * ���Ə����̃R���e�i���擾���܂��B
   * @return ���Ə����̃R���e�i
   */
  protected ACLabelContainer getProviderNameContainer(){
    if(providerNameContainer==null){
      providerNameContainer = new ACLabelContainer();
      providerNameContainer.setFollowChildEnabled(true);
      providerNameContainer.setVAlignment(VRLayout.CENTER);
      providerNameContainer.add(getProviderName(), null);
    }
    return providerNameContainer;
  }

  /**
   * �X�֔ԍ��R���e�i���擾���܂��B
   * @return �X�֔ԍ��R���e�i
   */
  public ACLabelContainer getProviderPostnoContena(){
    if(providerPostnoContena==null){

      providerPostnoContena = new ACLabelContainer();

      providerPostnoContena.setText("�X�֔ԍ�");

      addProviderPostnoContena();
    }
    return providerPostnoContena;

  }

  /**
   * �X�֔ԍ��i����擾���܂��B
   * @return �X�֔ԍ��i��
   */
  public ACTextField getProviderPostnoOn(){
    if(providerPostnoOn==null){

      providerPostnoOn = new ACTextField();

      providerPostnoOn.setBindPath("PROVIDER_ZIP_FIRST");

      providerPostnoOn.setColumns(3);

      providerPostnoOn.setCharType(VRCharType.ONLY_DIGIT);

      providerPostnoOn.setHorizontalAlignment(SwingConstants.LEFT);

      providerPostnoOn.setIMEMode(InputSubset.LATIN);

      providerPostnoOn.setMaxLength(3);

      addProviderPostnoOn();
    }
    return providerPostnoOn;

  }

  /**
   * �n�C�t�����擾���܂��B
   * @return �n�C�t��
   */
  public ACLabel getProviderPostnoHyphen(){
    if(providerPostnoHyphen==null){

      providerPostnoHyphen = new ACLabel();

      providerPostnoHyphen.setText("-");

      addProviderPostnoHyphen();
    }
    return providerPostnoHyphen;

  }

  /**
   * �X�֔ԍ��i�����擾���܂��B
   * @return �X�֔ԍ��i��
   */
  public ACTextField getProviderPostnoUnder(){
    if(providerPostnoUnder==null){

      providerPostnoUnder = new ACTextField();

      providerPostnoUnder.setBindPath("PROVIDER_ZIP_SECOND");

      providerPostnoUnder.setColumns(4);

      providerPostnoUnder.setCharType(VRCharType.ONLY_DIGIT);

      providerPostnoUnder.setHorizontalAlignment(SwingConstants.LEFT);

      providerPostnoUnder.setIMEMode(InputSubset.LATIN);

      providerPostnoUnder.setMaxLength(4);

      addProviderPostnoUnder();
    }
    return providerPostnoUnder;

  }

  /**
   * ���ݒn���擾���܂��B
   * @return ���ݒn
   */
  public ACTextField getProviderAddress(){
    if(providerAddress==null){

      providerAddress = new ACTextField();

      getProviderAddressContainer().setText("���ݒn");

      providerAddress.setBindPath("PROVIDER_ADDRESS");

      providerAddress.setColumns(70);

      providerAddress.setHorizontalAlignment(SwingConstants.LEFT);

      providerAddress.setIMEMode(InputSubset.KANJI);

      providerAddress.setMaxLength(70);

      addProviderAddress();
    }
    return providerAddress;

  }

  /**
   * ���ݒn�R���e�i���擾���܂��B
   * @return ���ݒn�R���e�i
   */
  protected ACLabelContainer getProviderAddressContainer(){
    if(providerAddressContainer==null){
      providerAddressContainer = new ACLabelContainer();
      providerAddressContainer.setFollowChildEnabled(true);
      providerAddressContainer.setVAlignment(VRLayout.CENTER);
      providerAddressContainer.add(getProviderAddress(), null);
    }
    return providerAddressContainer;
  }

  /**
   * �d�b�ԍ��R���e�i���擾���܂��B
   * @return �d�b�ԍ��R���e�i
   */
  public ACLabelContainer getProviderTelContena(){
    if(providerTelContena==null){

      providerTelContena = new ACLabelContainer();

      providerTelContena.setText("�d�b�ԍ�");

      addProviderTelContena();
    }
    return providerTelContena;

  }

  /**
   * �d�b�ԍ��i����擾���܂��B
   * @return �d�b�ԍ��i��
   */
  public ACTextField getProviderTelOn(){
    if(providerTelOn==null){

      providerTelOn = new ACTextField();

      providerTelOn.setBindPath("PROVIDER_TEL_FIRST");

      providerTelOn.setColumns(5);

      providerTelOn.setCharType(VRCharType.ONLY_DIGIT);

      providerTelOn.setHorizontalAlignment(SwingConstants.LEFT);

      providerTelOn.setIMEMode(InputSubset.LATIN);

      providerTelOn.setMaxLength(5);

      addProviderTelOn();
    }
    return providerTelOn;

  }

  /**
   * �n�C�t�����擾���܂��B
   * @return �n�C�t��
   */
  public ACLabel getProviderTelHyphen1(){
    if(providerTelHyphen1==null){

      providerTelHyphen1 = new ACLabel();

      providerTelHyphen1.setText("-");

      addProviderTelHyphen1();
    }
    return providerTelHyphen1;

  }

  /**
   * �d�b�ԍ��i�����擾���܂��B
   * @return �d�b�ԍ��i��
   */
  public ACTextField getProviderTelInside(){
    if(providerTelInside==null){

      providerTelInside = new ACTextField();

      providerTelInside.setBindPath("PROVIDER_TEL_SECOND");

      providerTelInside.setColumns(4);

      providerTelInside.setCharType(VRCharType.ONLY_DIGIT);

      providerTelInside.setHorizontalAlignment(SwingConstants.LEFT);

      providerTelInside.setIMEMode(InputSubset.LATIN);

      providerTelInside.setMaxLength(4);

      addProviderTelInside();
    }
    return providerTelInside;

  }

  /**
   * �n�C�t�����擾���܂��B
   * @return �n�C�t��
   */
  public ACLabel getProviderTelHyphen2(){
    if(providerTelHyphen2==null){

      providerTelHyphen2 = new ACLabel();

      providerTelHyphen2.setText("-");

      addProviderTelHyphen2();
    }
    return providerTelHyphen2;

  }

  /**
   * �d�b�ԍ��i�����擾���܂��B
   * @return �d�b�ԍ��i��
   */
  public ACTextField getProviderTelUnder(){
    if(providerTelUnder==null){

      providerTelUnder = new ACTextField();

      providerTelUnder.setBindPath("PROVIDER_TEL_THIRD");

      providerTelUnder.setColumns(4);

      providerTelUnder.setCharType(VRCharType.ONLY_DIGIT);

      providerTelUnder.setHorizontalAlignment(SwingConstants.LEFT);

      providerTelUnder.setIMEMode(InputSubset.LATIN);

      providerTelUnder.setMaxLength(4);

      addProviderTelUnder();
    }
    return providerTelUnder;

  }

  /**
   * FAX�ԍ��R���e�i���擾���܂��B
   * @return FAX�ԍ��R���e�i
   */
  public ACLabelContainer getProviderFaxContena(){
    if(providerFaxContena==null){

      providerFaxContena = new ACLabelContainer();

      providerFaxContena.setText("FAX�ԍ�");

      addProviderFaxContena();
    }
    return providerFaxContena;

  }

  /**
   * FAX�i����擾���܂��B
   * @return FAX�i��
   */
  public ACTextField getProviderFaxOn(){
    if(providerFaxOn==null){

      providerFaxOn = new ACTextField();

      providerFaxOn.setBindPath("PROVIDER_FAX_FIRST");

      providerFaxOn.setColumns(5);

      providerFaxOn.setCharType(VRCharType.ONLY_DIGIT);

      providerFaxOn.setHorizontalAlignment(SwingConstants.LEFT);

      providerFaxOn.setIMEMode(InputSubset.LATIN);

      providerFaxOn.setMaxLength(5);

      addProviderFaxOn();
    }
    return providerFaxOn;

  }

  /**
   * �n�C�t�����擾���܂��B
   * @return �n�C�t��
   */
  public ACLabel getProviderFaxHyphen1(){
    if(providerFaxHyphen1==null){

      providerFaxHyphen1 = new ACLabel();

      providerFaxHyphen1.setText("-");

      addProviderFaxHyphen1();
    }
    return providerFaxHyphen1;

  }

  /**
   * FAX�i�����擾���܂��B
   * @return FAX�i��
   */
  public ACTextField getProviderFaxInside(){
    if(providerFaxInside==null){

      providerFaxInside = new ACTextField();

      providerFaxInside.setBindPath("PROVIDER_FAX_SECOND");

      providerFaxInside.setColumns(4);

      providerFaxInside.setCharType(VRCharType.ONLY_DIGIT);

      providerFaxInside.setHorizontalAlignment(SwingConstants.LEFT);

      providerFaxInside.setIMEMode(InputSubset.LATIN);

      providerFaxInside.setMaxLength(4);

      addProviderFaxInside();
    }
    return providerFaxInside;

  }

  /**
   * �n�C�t�����擾���܂��B
   * @return �n�C�t��
   */
  public ACLabel getProviderFaxHyphen2(){
    if(providerFaxHyphen2==null){

      providerFaxHyphen2 = new ACLabel();

      providerFaxHyphen2.setText("-");

      addProviderFaxHyphen2();
    }
    return providerFaxHyphen2;

  }

  /**
   * FAX�i�����擾���܂��B
   * @return FAX�i��
   */
  public ACTextField getProviderFaxUnder(){
    if(providerFaxUnder==null){

      providerFaxUnder = new ACTextField();

      providerFaxUnder.setBindPath("PROVIDER_FAX_THIRD");

      providerFaxUnder.setColumns(4);

      providerFaxUnder.setCharType(VRCharType.ONLY_DIGIT);

      providerFaxUnder.setHorizontalAlignment(SwingConstants.LEFT);

      providerFaxUnder.setIMEMode(InputSubset.LATIN);

      providerFaxUnder.setMaxLength(4);

      addProviderFaxUnder();
    }
    return providerFaxUnder;

  }

  /**
   * �Ǘ��҂��擾���܂��B
   * @return �Ǘ���
   */
  public ACTextField getProviderEstablishName(){
    if(providerEstablishName==null){

      providerEstablishName = new ACTextField();

      getProviderEstablishNameContainer().setText("�Ǘ���");

      providerEstablishName.setBindPath("PROVIDER_OWNER_NAME");

      providerEstablishName.setColumns(16);

      providerEstablishName.setHorizontalAlignment(SwingConstants.LEFT);

      providerEstablishName.setIMEMode(InputSubset.KANJI);

      providerEstablishName.setMaxLength(16);

      addProviderEstablishName();
    }
    return providerEstablishName;

  }

  /**
   * �Ǘ��҃R���e�i���擾���܂��B
   * @return �Ǘ��҃R���e�i
   */
  protected ACLabelContainer getProviderEstablishNameContainer(){
    if(providerEstablishNameContainer==null){
      providerEstablishNameContainer = new ACLabelContainer();
      providerEstablishNameContainer.setFollowChildEnabled(true);
      providerEstablishNameContainer.setVAlignment(VRLayout.CENTER);
      providerEstablishNameContainer.add(getProviderEstablishName(), null);
    }
    return providerEstablishNameContainer;
  }

  /**
   * �����Ə��敪���W�I�O���[�v���擾���܂��B
   * @return �����Ə��敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getProviderMainContentDivision(){
    if(providerMainContentDivision==null){

      providerMainContentDivision = new ACValueArrayRadioButtonGroup();

      getProviderMainContentDivisionContainer().setText("�����Ə��敪");

      providerMainContentDivision.setBindPath("PROVIDER_JIJIGYOUSHO_TYPE");

      providerMainContentDivision.setUseClearButton(false);

      providerMainContentDivision.setModel(getProviderMainContentDivisionModel());

      providerMainContentDivision.setValues(new int[]{1,2});

      addProviderMainContentDivision();
    }
    return providerMainContentDivision;

  }

  /**
   * �����Ə��敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �����Ə��敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getProviderMainContentDivisionContainer(){
    if(providerMainContentDivisionContainer==null){
      providerMainContentDivisionContainer = new ACLabelContainer();
      providerMainContentDivisionContainer.setFollowChildEnabled(true);
      providerMainContentDivisionContainer.setVAlignment(VRLayout.CENTER);
      providerMainContentDivisionContainer.add(getProviderMainContentDivision(), null);
    }
    return providerMainContentDivisionContainer;
  }

  /**
   * �����Ə��敪���W�I�O���[�v���f�����擾���܂��B
   * @return �����Ə��敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getProviderMainContentDivisionModel(){
    if(providerMainContentDivisionModel==null){
      providerMainContentDivisionModel = new ACListModelAdapter();
      addProviderMainContentDivisionModel();
    }
    return providerMainContentDivisionModel;
  }

  /**
   * �����Ə����擾���܂��B
   * @return �����Ə�
   */
  public ACRadioButtonItem getProviderMainContentDivisionMine(){
    if(providerMainContentDivisionMine==null){

      providerMainContentDivisionMine = new ACRadioButtonItem();

      providerMainContentDivisionMine.setText("�����Ə�");

      providerMainContentDivisionMine.setGroup(getProviderMainContentDivision());

      addProviderMainContentDivisionMine();
    }
    return providerMainContentDivisionMine;

  }

  /**
   * �����Ə����擾���܂��B
   * @return �����Ə�
   */
  public ACRadioButtonItem getProviderMainContentDivisionOther(){
    if(providerMainContentDivisionOther==null){

      providerMainContentDivisionOther = new ACRadioButtonItem();

      providerMainContentDivisionOther.setText("�����Ə�");

      providerMainContentDivisionOther.setGroup(getProviderMainContentDivision());

      addProviderMainContentDivisionOther();
    }
    return providerMainContentDivisionOther;

  }

  /**
   * ���Ƌ敪���W�I�O���[�v���擾���܂��B
   * @return ���Ƌ敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getProviderMainContentBusiness(){
    if(providerMainContentBusiness==null){

      providerMainContentBusiness = new ACValueArrayRadioButtonGroup();

      getProviderMainContentBusinessContainer().setText("���Ə��敪");

      providerMainContentBusiness.setBindPath("PROVIDER_JIGYOU_TYPE");

      providerMainContentBusiness.setUseClearButton(false);

      providerMainContentBusiness.setModel(getProviderMainContentBusinessModel());

      providerMainContentBusiness.setValues(new int[]{1,2,5});

      addProviderMainContentBusiness();
    }
    return providerMainContentBusiness;

  }

  /**
   * ���Ƌ敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���Ƌ敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getProviderMainContentBusinessContainer(){
    if(providerMainContentBusinessContainer==null){
      providerMainContentBusinessContainer = new ACLabelContainer();
      providerMainContentBusinessContainer.setFollowChildEnabled(true);
      providerMainContentBusinessContainer.setVAlignment(VRLayout.CENTER);
      providerMainContentBusinessContainer.add(getProviderMainContentBusiness(), null);
    }
    return providerMainContentBusinessContainer;
  }

  /**
   * ���Ƌ敪���W�I�O���[�v���f�����擾���܂��B
   * @return ���Ƌ敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getProviderMainContentBusinessModel(){
    if(providerMainContentBusinessModel==null){
      providerMainContentBusinessModel = new ACListModelAdapter();
      addProviderMainContentBusinessModel();
    }
    return providerMainContentBusinessModel;
  }

  /**
   * �w����擾���܂��B
   * @return �w��
   */
  public ACRadioButtonItem getProviderMainContentBusinessSpecification(){
    if(providerMainContentBusinessSpecification==null){

      providerMainContentBusinessSpecification = new ACRadioButtonItem();

      providerMainContentBusinessSpecification.setText("�w��");

      providerMainContentBusinessSpecification.setGroup(getProviderMainContentBusiness());

      addProviderMainContentBusinessSpecification();
    }
    return providerMainContentBusinessSpecification;

  }

  /**
   * ��Y�����擾���܂��B
   * @return ��Y��
   */
  public ACRadioButtonItem getProviderMainContentBusinessStandard(){
    if(providerMainContentBusinessStandard==null){

      providerMainContentBusinessStandard = new ACRadioButtonItem();

      providerMainContentBusinessStandard.setText("��Y��");

      providerMainContentBusinessStandard.setGroup(getProviderMainContentBusiness());

      addProviderMainContentBusinessStandard();
    }
    return providerMainContentBusinessStandard;

  }

  /**
   * �n�斧�����擾���܂��B
   * @return �n�斧��
   */
  public ACRadioButtonItem getProviderMainContentBusinessRegion(){
    if(providerMainContentBusinessRegion==null){

      providerMainContentBusinessRegion = new ACRadioButtonItem();

      providerMainContentBusinessRegion.setText("�n�斧��");

      providerMainContentBusinessRegion.setGroup(getProviderMainContentBusiness());

      addProviderMainContentBusinessRegion();
    }
    return providerMainContentBusinessRegion;

  }

  /**
   * ��Ë@�ւ��擾���܂��B
   * @return ��Ë@��
   */
  public ACIntegerCheckBox getMedical(){
    if(medical==null){

      medical = new ACIntegerCheckBox();

      medical.setText("��Ë@��");

      medical.setBindPath("MEDICAL_FLAG");

      medical.setVisible(false);

      addMedical();
    }
    return medical;

  }

  /**
   * ���Ə���ʂ��擾���܂��B
   * @return ���Ə����
   */
  public ACComboBox getProviderType(){
    if(providerType==null){

      providerType = new ACComboBox();

      getProviderTypeContainer().setText("���Ə����");

      providerType.setBindPath("PROVIDER_TYPE");

      providerType.setEditable(false);

      providerType.setModelBindPath("PROVIDER_TYPE");

      providerType.setRenderBindPath("CONTENT");

      providerType.setBlankable(true);

      providerType.setModel(getProviderTypeModel());

      addProviderType();
    }
    return providerType;

  }

  /**
   * ���Ə���ʃR���e�i���擾���܂��B
   * @return ���Ə���ʃR���e�i
   */
  protected ACLabelContainer getProviderTypeContainer(){
    if(providerTypeContainer==null){
      providerTypeContainer = new ACLabelContainer();
      providerTypeContainer.setFollowChildEnabled(true);
      providerTypeContainer.setVAlignment(VRLayout.CENTER);
      providerTypeContainer.add(getProviderType(), null);
    }
    return providerTypeContainer;
  }

  /**
   * ���Ə���ʃ��f�����擾���܂��B
   * @return ���Ə���ʃ��f��
   */
  protected ACComboBoxModelAdapter getProviderTypeModel(){
    if(providerTypeModel==null){
      providerTypeModel = new ACComboBoxModelAdapter();
      addProviderTypeModel();
    }
    return providerTypeModel;
  }

  /**
   * �n��敪���W�I�O���[�v���擾���܂��B
   * @return �n��敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getProviderMainContentRegion(){
    if(providerMainContentRegion==null){

      providerMainContentRegion = new ACValueArrayRadioButtonGroup();

      getProviderMainContentRegionContainer().setText("�n��敪");

      providerMainContentRegion.setBindPath("PROVIDER_AREA_TYPE");

      providerMainContentRegion.setUseClearButton(false);

      providerMainContentRegion.setModel(getProviderMainContentRegionModel());

      providerMainContentRegion.setValues(new int[]{1,6,7,2,3,4,9,5});

      addProviderMainContentRegion();
    }
    return providerMainContentRegion;

  }

  /**
   * �n��敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �n��敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getProviderMainContentRegionContainer(){
    if(providerMainContentRegionContainer==null){
      providerMainContentRegionContainer = new ACLabelContainer();
      providerMainContentRegionContainer.setFollowChildEnabled(true);
      providerMainContentRegionContainer.setVAlignment(VRLayout.CENTER);
      providerMainContentRegionContainer.add(getProviderMainContentRegion(), null);
    }
    return providerMainContentRegionContainer;
  }

  /**
   * �n��敪���W�I�O���[�v���f�����擾���܂��B
   * @return �n��敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getProviderMainContentRegionModel(){
    if(providerMainContentRegionModel==null){
      providerMainContentRegionModel = new ACListModelAdapter();
      addProviderMainContentRegionModel();
    }
    return providerMainContentRegionModel;
  }

  /**
   * �P���n���擾���܂��B
   * @return �P���n
   */
  public ACRadioButtonItem getProviderMainContentRegionLank1(){
    if(providerMainContentRegionLank1==null){

      providerMainContentRegionLank1 = new ACRadioButtonItem();

      providerMainContentRegionLank1.setText("1���n");

      providerMainContentRegionLank1.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank1.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank1();
    }
    return providerMainContentRegionLank1;

  }

  /**
   * �Q���n���擾���܂��B
   * @return �Q���n
   */
  public ACRadioButtonItem getProviderMainContentRegionLank2(){
    if(providerMainContentRegionLank2==null){

      providerMainContentRegionLank2 = new ACRadioButtonItem();

      providerMainContentRegionLank2.setText("2���n");

      providerMainContentRegionLank2.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank2.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank2();
    }
    return providerMainContentRegionLank2;

  }

  /**
   * �R���n���擾���܂��B
   * @return �R���n
   */
  public ACRadioButtonItem getProviderMainContentRegionLank3(){
    if(providerMainContentRegionLank3==null){

      providerMainContentRegionLank3 = new ACRadioButtonItem();

      providerMainContentRegionLank3.setText("3���n");

      providerMainContentRegionLank3.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank3.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank3();
    }
    return providerMainContentRegionLank3;

  }

  /**
   * �S���n���擾���܂��B
   * @return �S���n
   */
  public ACRadioButtonItem getProviderMainContentRegionLank4(){
    if(providerMainContentRegionLank4==null){

      providerMainContentRegionLank4 = new ACRadioButtonItem();

      providerMainContentRegionLank4.setText("4���n");

      providerMainContentRegionLank4.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank4.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank4();
    }
    return providerMainContentRegionLank4;

  }

  /**
   * �T���n���擾���܂��B
   * @return �T���n
   */
  public ACRadioButtonItem getProviderMainContentRegionLank5(){
    if(providerMainContentRegionLank5==null){

      providerMainContentRegionLank5 = new ACRadioButtonItem();

      providerMainContentRegionLank5.setText("5���n");

      providerMainContentRegionLank5.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank5.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank5();
    }
    return providerMainContentRegionLank5;

  }

  /**
   * �U���n���擾���܂��B
   * @return �U���n
   */
  public ACRadioButtonItem getProviderMainContentRegionLank6(){
    if(providerMainContentRegionLank6==null){

      providerMainContentRegionLank6 = new ACRadioButtonItem();

      providerMainContentRegionLank6.setText("6���n");

      providerMainContentRegionLank6.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank6.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank6();
    }
    return providerMainContentRegionLank6;

  }

  /**
   * �V���n���擾���܂��B
   * @return �V���n
   */
  public ACRadioButtonItem getProviderMainContentRegionLank7(){
    if(providerMainContentRegionLank7==null){

      providerMainContentRegionLank7 = new ACRadioButtonItem();

      providerMainContentRegionLank7.setText("7���n");

      providerMainContentRegionLank7.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank7.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank7();
    }
    return providerMainContentRegionLank7;

  }

  /**
   * ���̑����擾���܂��B
   * @return ���̑�
   */
  public ACRadioButtonItem getProviderMainContentRegionLank8(){
    if(providerMainContentRegionLank8==null){

      providerMainContentRegionLank8 = new ACRadioButtonItem();

      providerMainContentRegionLank8.setText("���̑�");

      providerMainContentRegionLank8.setGroup(getProviderMainContentRegion());

      providerMainContentRegionLank8.setConstraints(VRLayout.FLOW);

      addProviderMainContentRegionLank8();
    }
    return providerMainContentRegionLank8;

  }

  /**
   * ���ʒn����擾���܂��B
   * @return ���ʒn��
   */
  public ACIntegerCheckBox getLankSpecialArea(){
    if(lankSpecialArea==null){

      lankSpecialArea = new ACIntegerCheckBox();

      lankSpecialArea.setText("���ʒn��");

      lankSpecialArea.setBindPath("SPECIAL_AREA_FLAG");

      lankSpecialArea.setSelectValue(2);

      lankSpecialArea.setUnSelectValue(1);

      addLankSpecialArea();
    }
    return lankSpecialArea;

  }

  /**
   * ���Ə��T�u���̈���擾���܂��B
   * @return ���Ə��T�u���̈�
   */
  public ACPanel getProviderSubContents(){
    if(providerSubContents==null){

      providerSubContents = new ACPanel();

      addProviderSubContents();
    }
    return providerSubContents;

  }

  /**
   * ���Ə��ڍ׏��̈���擾���܂��B
   * @return ���Ə��ڍ׏��̈�
   */
  public ACPanel getProviderDetailContents(){
    if(providerDetailContents==null){

      providerDetailContents = new ACPanel();

      addProviderDetailContents();
    }
    return providerDetailContents;

  }

  /**
   * ���Ə��ڍ׏��T�[�r�X���X�g�̈���擾���܂��B
   * @return ���Ə��ڍ׏��T�[�r�X���X�g�̈�
   */
  public ACPanel getProviderDetailServiceKinds(){
    if(providerDetailServiceKinds==null){

      providerDetailServiceKinds = new ACPanel();

      addProviderDetailServiceKinds();
    }
    return providerDetailServiceKinds;

  }

  /**
   * �񋟃T�[�r�X���擾���܂��B
   * @return �񋟃T�[�r�X
   */
  public ACGroupBox getServiceKindOffer(){
    if(serviceKindOffer==null){

      serviceKindOffer = new ACGroupBox();

      serviceKindOffer.setText("�񋟃T�[�r�X");

      serviceKindOffer.setHgap(0);

      serviceKindOffer.setLabelMargin(0);

      addServiceKindOffer();
    }
    return serviceKindOffer;

  }

  /**
   * �񋟃T�[�r�X�e�[�u���̈���擾���܂��B
   * @return �񋟃T�[�r�X�e�[�u���̈�
   */
  public ACPanel getServiceKindTablePanel(){
    if(serviceKindTablePanel==null){

      serviceKindTablePanel = new ACPanel();

      serviceKindTablePanel.setHgap(2);

      serviceKindTablePanel.setLabelMargin(0);

      addServiceKindTablePanel();
    }
    return serviceKindTablePanel;

  }

  /**
   * �񋟃T�[�r�X�e�[�u�����擾���܂��B
   * @return �񋟃T�[�r�X�e�[�u��
   */
  public ACTable getServiceKindTable(){
    if(serviceKindTable==null){

      serviceKindTable = new ACTable();

      serviceKindTable.setColumnModel(getServiceKindTableColumnModel());

      serviceKindTable.setPreferredSize(new Dimension(340,140));

      addServiceKindTable();
    }
    return serviceKindTable;

  }

  /**
   * �񋟃T�[�r�X�e�[�u���J�������f�����擾���܂��B
   * @return �񋟃T�[�r�X�e�[�u���J�������f��
   */
  protected VRTableColumnModel getServiceKindTableColumnModel(){
    if(serviceKindTableColumnModel==null){
      serviceKindTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addServiceKindTableColumnModel();
    }
    return serviceKindTableColumnModel;
  }

  /**
   * �񋟂��擾���܂��B
   * @return ��
   */
  public ACTableColumn getServiceKindTableColum1(){
    if(serviceKindTableColum1==null){

      serviceKindTableColum1 = new ACTableColumn(0);

      serviceKindTableColum1.setHeaderValue("��");

      serviceKindTableColum1.setColumns(3);

      serviceKindTableColum1.setHorizontalAlignment(SwingConstants.CENTER);

      serviceKindTableColum1.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      serviceKindTableColum1.setSortable(false);

      addServiceKindTableColum1();
    }
    return serviceKindTableColum1;

  }

  /**
   * �񋟃T�[�r�X���擾���܂��B
   * @return �񋟃T�[�r�X
   */
  public ACTableColumn getServiceKindTableColum2(){
    if(serviceKindTableColum2==null){

      serviceKindTableColum2 = new ACTableColumn(1);

      serviceKindTableColum2.setHeaderValue("�񋟃T�[�r�X");

      serviceKindTableColum2.setSortable(false);

      addServiceKindTableColum2();
    }
    return serviceKindTableColum2;

  }

  /**
   * �{�^���p�l�����擾���܂��B
   * @return �{�^���p�l��
   */
  public ACPanel getButtonsPanel(){
    if(buttonsPanel==null){

      buttonsPanel = new ACPanel();

      buttonsPanel.setAutoWrap(false);

      buttonsPanel.setHgap(6);

      buttonsPanel.setLabelMargin(0);

      addButtonsPanel();
    }
    return buttonsPanel;

  }

  /**
   * �񋟃`�F�b�N���擾���܂��B
   * @return �񋟃`�F�b�N
   */
  public ACIntegerCheckBox getOfferCheck(){
    if(offerCheck==null){

      offerCheck = new ACIntegerCheckBox();

      offerCheck.setText("�񋟂���");

      offerCheck.setBindPath("OFFER");

      addOfferCheck();
    }
    return offerCheck;

  }

  /**
   * ���f���擾���܂��B
   * @return ���f
   */
  public ACButton getReflection(){
    if(reflection==null){

      reflection = new ACButton();

      reflection.setText("���f");

      reflection.setToolTipText("���݂̒񋟃T�[�r�X���𔽉f���܂��B");

      reflection.setIconPath(ACConstants.ICON_PATH_LEFT_16);

      addReflection();
    }
    return reflection;

  }

  /**
   * �����֘A���̈���擾���܂��B
   * @return �����֘A���̈�
   */
  public ACPanel getClaimInfos(){
    if(claimInfos==null){

      claimInfos = new ACPanel();

      addClaimInfos();
    }
    return claimInfos;

  }

  /**
   * �U������Z�@�֖����擾���܂��B
   * @return �U������Z�@�֖�
   */
  public ACTextField getBankName(){
    if(bankName==null){

      bankName = new ACTextField();

      getBankNameContainer().setText("�U������Z�@�֖�");

      bankName.setBindPath("BANK_NAME");

      bankName.setColumns(15);

      bankName.setIMEMode(InputSubset.KANJI);

      bankName.setMaxLength(25);

      addBankName();
    }
    return bankName;

  }

  /**
   * �U������Z�@�֖��R���e�i���擾���܂��B
   * @return �U������Z�@�֖��R���e�i
   */
  protected ACLabelContainer getBankNameContainer(){
    if(bankNameContainer==null){
      bankNameContainer = new ACLabelContainer();
      bankNameContainer.setFollowChildEnabled(true);
      bankNameContainer.setVAlignment(VRLayout.CENTER);
      bankNameContainer.add(getBankName(), null);
    }
    return bankNameContainer;
  }

  /**
   * �U������Z�@�֎x�X�����擾���܂��B
   * @return �U������Z�@�֎x�X��
   */
  public ACTextField getBankBranchName(){
    if(bankBranchName==null){

      bankBranchName = new ACTextField();

      getBankBranchNameContainer().setText("�U������Z�@�֎x�X��");

      bankBranchName.setBindPath("BANK_BRANCH_NAME");

      bankBranchName.setColumns(15);

      bankBranchName.setIMEMode(InputSubset.KANJI);

      bankBranchName.setMaxLength(25);

      addBankBranchName();
    }
    return bankBranchName;

  }

  /**
   * �U������Z�@�֎x�X���R���e�i���擾���܂��B
   * @return �U������Z�@�֎x�X���R���e�i
   */
  protected ACLabelContainer getBankBranchNameContainer(){
    if(bankBranchNameContainer==null){
      bankBranchNameContainer = new ACLabelContainer();
      bankBranchNameContainer.setFollowChildEnabled(true);
      bankBranchNameContainer.setVAlignment(VRLayout.CENTER);
      bankBranchNameContainer.add(getBankBranchName(), null);
    }
    return bankBranchNameContainer;
  }

  /**
   * �U��������ԍ����擾���܂��B
   * @return �U��������ԍ�
   */
  public ACTextField getAccountNumber(){
    if(accountNumber==null){

      accountNumber = new ACTextField();

      getAccountNumberContainer().setText("�U��������ԍ�");

      accountNumber.setBindPath("ACCOUNT_NUMBER");

      accountNumber.setColumns(7);

      accountNumber.setCharType(VRCharType.ONLY_ALNUM);

      accountNumber.setIMEMode(InputSubset.LATIN);

      accountNumber.setMaxLength(10);

      addAccountNumber();
    }
    return accountNumber;

  }

  /**
   * �U��������ԍ��R���e�i���擾���܂��B
   * @return �U��������ԍ��R���e�i
   */
  protected ACLabelContainer getAccountNumberContainer(){
    if(accountNumberContainer==null){
      accountNumberContainer = new ACLabelContainer();
      accountNumberContainer.setFollowChildEnabled(true);
      accountNumberContainer.setVAlignment(VRLayout.CENTER);
      accountNumberContainer.add(getAccountNumber(), null);
    }
    return accountNumberContainer;
  }

  /**
   * �U���������ނ��擾���܂��B
   * @return �U����������
   */
  public ACValueArrayRadioButtonGroup getAccountTypeRadio(){
    if(accountTypeRadio==null){

      accountTypeRadio = new ACValueArrayRadioButtonGroup();

      getAccountTypeRadioContainer().setText("�U����������");

      accountTypeRadio.setBindPath("ACCOUNT_TYPE");

      accountTypeRadio.setModel(getAccountTypeRadioModel());

      accountTypeRadio.setValues(new int[]{1,2});

      addAccountTypeRadio();
    }
    return accountTypeRadio;

  }

  /**
   * �U���������ރR���e�i���擾���܂��B
   * @return �U���������ރR���e�i
   */
  protected ACLabelContainer getAccountTypeRadioContainer(){
    if(accountTypeRadioContainer==null){
      accountTypeRadioContainer = new ACLabelContainer();
      accountTypeRadioContainer.setFollowChildEnabled(true);
      accountTypeRadioContainer.setVAlignment(VRLayout.CENTER);
      accountTypeRadioContainer.add(getAccountTypeRadio(), null);
    }
    return accountTypeRadioContainer;
  }

  /**
   * �U���������ރ��f�����擾���܂��B
   * @return �U���������ރ��f��
   */
  protected ACListModelAdapter getAccountTypeRadioModel(){
    if(accountTypeRadioModel==null){
      accountTypeRadioModel = new ACListModelAdapter();
      addAccountTypeRadioModel();
    }
    return accountTypeRadioModel;
  }

  /**
   * ���ʂ��擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getAccountTypeRadioItem1(){
    if(accountTypeRadioItem1==null){

      accountTypeRadioItem1 = new ACRadioButtonItem();

      accountTypeRadioItem1.setText("����");

      accountTypeRadioItem1.setGroup(getAccountTypeRadio());

      addAccountTypeRadioItem1();
    }
    return accountTypeRadioItem1;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getAccountTypeRadioItem2(){
    if(accountTypeRadioItem2==null){

      accountTypeRadioItem2 = new ACRadioButtonItem();

      accountTypeRadioItem2.setText("����");

      accountTypeRadioItem2.setGroup(getAccountTypeRadio());

      addAccountTypeRadioItem2();
    }
    return accountTypeRadioItem2;

  }

  /**
   * �U���於�`�l���擾���܂��B
   * @return �U���於�`�l
   */
  public ACTextField getAccountHolder(){
    if(accountHolder==null){

      accountHolder = new ACTextField();

      getAccountHolderContainer().setText("�U���於�`�l");

      accountHolder.setBindPath("ACCOUNT_HOLDER");

      accountHolder.setColumns(20);

      accountHolder.setIMEMode(InputSubset.KANJI);

      accountHolder.setMaxLength(50);

      addAccountHolder();
    }
    return accountHolder;

  }

  /**
   * �U���於�`�l�R���e�i���擾���܂��B
   * @return �U���於�`�l�R���e�i
   */
  protected ACLabelContainer getAccountHolderContainer(){
    if(accountHolderContainer==null){
      accountHolderContainer = new ACLabelContainer();
      accountHolderContainer.setFollowChildEnabled(true);
      accountHolderContainer.setVAlignment(VRLayout.CENTER);
      accountHolderContainer.add(getAccountHolder(), null);
    }
    return accountHolderContainer;
  }

  /**
   * �S���җ̈���擾���܂��B
   * @return �S���җ̈�
   */
  public ACPanel getProviderMainContentChargesPanel(){
    if(providerMainContentChargesPanel==null){

      providerMainContentChargesPanel = new ACPanel();

      addProviderMainContentChargesPanel();
    }
    return providerMainContentChargesPanel;

  }

  /**
   * �S���҃O���[�v���擾���܂��B
   * @return �S���҃O���[�v
   */
  public ACGroupBox getProviderStaffGroup(){
    if(providerStaffGroup==null){

      providerStaffGroup = new ACGroupBox();

      providerStaffGroup.setText("�S����");

      addProviderStaffGroup();
    }
    return providerStaffGroup;

  }

  /**
   * �S���҃e�[�u���̈���擾���܂��B
   * @return �S���҃e�[�u���̈�
   */
  public ACPanel getProviderStaffTablePanel(){
    if(providerStaffTablePanel==null){

      providerStaffTablePanel = new ACPanel();

      addProviderStaffTablePanel();
    }
    return providerStaffTablePanel;

  }

  /**
   * �S���҃e�[�u�����擾���܂��B
   * @return �S���҃e�[�u��
   */
  public ACTable getProviderStaffTable(){
    if(providerStaffTable==null){

      providerStaffTable = new ACTable();

      providerStaffTable.setColumnModel(getProviderStaffTableColumnModel());

      providerStaffTable.setPreferredSize(new Dimension(440,80));

      addProviderStaffTable();
    }
    return providerStaffTable;

  }

  /**
   * �S���҃e�[�u���J�������f�����擾���܂��B
   * @return �S���҃e�[�u���J�������f��
   */
  protected VRTableColumnModel getProviderStaffTableColumnModel(){
    if(providerStaffTableColumnModel==null){
      providerStaffTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addProviderStaffTableColumnModel();
    }
    return providerStaffTableColumnModel;
  }

  /**
   * No���擾���܂��B
   * @return No
   */
  public ACTableColumn getProviderStaffTableColumn1(){
    if(providerStaffTableColumn1==null){

      providerStaffTableColumn1 = new ACTableColumn(0);

      providerStaffTableColumn1.setHeaderValue("No");

      providerStaffTableColumn1.setColumns(3);

      providerStaffTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      providerStaffTableColumn1.setSortable(false);

      providerStaffTableColumn1.setEditorType(ACTableCellViewer.EDITOR_TYPE_SERIAL_NO);

      addProviderStaffTableColumn1();
    }
    return providerStaffTableColumn1;

  }

  /**
   * �x�������ԍ����擾���܂��B
   * @return �x�������ԍ�
   */
  public ACTableColumn getProviderStaffTableColumn2(){
    if(providerStaffTableColumn2==null){

      providerStaffTableColumn2 = new ACTableColumn(0);

      providerStaffTableColumn2.setHeaderValue("�x�������ԍ�");

      providerStaffTableColumn2.setColumns(9);

      providerStaffTableColumn2.setSortable(true);

      addProviderStaffTableColumn2();
    }
    return providerStaffTableColumn2;

  }

  /**
   * �S���Җ����擾���܂��B
   * @return �S���Җ�
   */
  public ACTableColumn getProviderStaffTableColumn3(){
    if(providerStaffTableColumn3==null){

      providerStaffTableColumn3 = new ACTableColumn(1);

      providerStaffTableColumn3.setHeaderValue("�S���Җ�");

      providerStaffTableColumn3.setSortable(true);

      addProviderStaffTableColumn3();
    }
    return providerStaffTableColumn3;

  }

  /**
   * �S���ғ��͗̈���擾���܂��B
   * @return �S���ғ��͗̈�
   */
  public ACPanel getProviderStaffInputPanel(){
    if(providerStaffInputPanel==null){

      providerStaffInputPanel = new ACPanel();

      providerStaffInputPanel.setAutoWrap(false);

      providerStaffInputPanel.setHgap(0);

      providerStaffInputPanel.setLabelMargin(0);

      addProviderStaffInputPanel();
    }
    return providerStaffInputPanel;

  }

  /**
   * �x�������ԍ����擾���܂��B
   * @return �x�������ԍ�
   */
  public ACTextField getProviderStaffCareManagerNo(){
    if(providerStaffCareManagerNo==null){

      providerStaffCareManagerNo = new ACTextField();

      getProviderStaffCareManagerNoContainer().setText("�x�������ԍ�");

      providerStaffCareManagerNo.setBindPath("CARE_MANAGER_NO");

      providerStaffCareManagerNo.setColumns(6);

      providerStaffCareManagerNo.setCharType(VRCharType.ONLY_DIGIT);

      providerStaffCareManagerNo.setMaxLength(8);

      addProviderStaffCareManagerNo();
    }
    return providerStaffCareManagerNo;

  }

  /**
   * �x�������ԍ��R���e�i���擾���܂��B
   * @return �x�������ԍ��R���e�i
   */
  protected ACLabelContainer getProviderStaffCareManagerNoContainer(){
    if(providerStaffCareManagerNoContainer==null){
      providerStaffCareManagerNoContainer = new ACLabelContainer();
      providerStaffCareManagerNoContainer.setFollowChildEnabled(true);
      providerStaffCareManagerNoContainer.setVAlignment(VRLayout.CENTER);
      providerStaffCareManagerNoContainer.add(getProviderStaffCareManagerNo(), null);
    }
    return providerStaffCareManagerNoContainer;
  }

  /**
   * �S���ҁE�R���e�i���擾���܂��B
   * @return �S���ҁE�R���e�i
   */
  public ACLabelContainer getProviderStaffNameContainer(){
    if(providerStaffNameContainer==null){

      providerStaffNameContainer = new ACLabelContainer();

      providerStaffNameContainer.setText("�S����");

      addProviderStaffNameContainer();
    }
    return providerStaffNameContainer;

  }

  /**
   * ���E�R���e�i���擾���܂��B
   * @return ���E�R���e�i
   */
  public ACBackLabelContainer getProviderStaffFamilyNameContainer(){
    if(providerStaffFamilyNameContainer==null){

      providerStaffFamilyNameContainer = new ACBackLabelContainer();

      providerStaffFamilyNameContainer.setText("��");

      addProviderStaffFamilyNameContainer();
    }
    return providerStaffFamilyNameContainer;

  }

  /**
   * �S���Җ��i���j���擾���܂��B
   * @return �S���Җ��i���j
   */
  public ACTextField getProviderStaffFamilyName(){
    if(providerStaffFamilyName==null){

      providerStaffFamilyName = new ACTextField();

      providerStaffFamilyName.setBindPath("STAFF_FAMILY_NAME");

      providerStaffFamilyName.setColumns(12);

      providerStaffFamilyName.setIMEMode(InputSubset.KANJI);

      providerStaffFamilyName.setMaxLength(16);

      addProviderStaffFamilyName();
    }
    return providerStaffFamilyName;

  }

  /**
   * ���E�R���e�i���擾���܂��B
   * @return ���E�R���e�i
   */
  public ACBackLabelContainer getProviderStaffFirstNameContainer(){
    if(providerStaffFirstNameContainer==null){

      providerStaffFirstNameContainer = new ACBackLabelContainer();

      providerStaffFirstNameContainer.setText("��");

      addProviderStaffFirstNameContainer();
    }
    return providerStaffFirstNameContainer;

  }

  /**
   * �S���Җ��i���j���擾���܂��B
   * @return �S���Җ��i���j
   */
  public ACTextField getProviderStaffFirstName(){
    if(providerStaffFirstName==null){

      providerStaffFirstName = new ACTextField();

      providerStaffFirstName.setBindPath("STAFF_FIRST_NAME");

      providerStaffFirstName.setColumns(12);

      providerStaffFirstName.setIMEMode(InputSubset.KANJI);

      providerStaffFirstName.setMaxLength(16);

      addProviderStaffFirstName();
    }
    return providerStaffFirstName;

  }

  /**
   * ����̈���擾���܂��B
   * @return ����̈�
   */
  public ACPanel getProviderStaffTableControlPanel(){
    if(providerStaffTableControlPanel==null){

      providerStaffTableControlPanel = new ACPanel();

      addProviderStaffTableControlPanel();
    }
    return providerStaffTableControlPanel;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getProviderStaffInsert(){
    if(providerStaffInsert==null){

      providerStaffInsert = new ACButton();

      providerStaffInsert.setText("�ǉ�");

      providerStaffInsert.setToolTipText("�S���҂�ǉ����܂��B");

      addProviderStaffInsert();
    }
    return providerStaffInsert;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getProviderStaffFind(){
    if(providerStaffFind==null){

      providerStaffFind = new ACButton();

      providerStaffFind.setText("����");

      providerStaffFind.setToolTipText("�I�𒆂̒S���҂�ҏW���܂��B");

      addProviderStaffFind();
    }
    return providerStaffFind;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getProviderStaffDelete(){
    if(providerStaffDelete==null){

      providerStaffDelete = new ACButton();

      providerStaffDelete.setText("�폜");

      providerStaffDelete.setToolTipText("�I�𒆂̒S���҂��폜���܂��B");

      addProviderStaffDelete();
    }
    return providerStaffDelete;

  }

  /**
   * �T�[�r�X��ޏڍ׏��̈���擾���܂��B
   * @return �T�[�r�X��ޏڍ׏��̈�
   */
  public ACPanel getProviderDetailServiceDetails(){
    if(providerDetailServiceDetails==null){

      providerDetailServiceDetails = new ACPanel();

      providerDetailServiceDetails.setFollowChildEnabled(true);

      addProviderDetailServiceDetails();
    }
    return providerDetailServiceDetails;

  }

  /**
   * �������O���[�v���擾���܂��B
   * @return �������O���[�v
   */
  public ACGroupBox getExplanationTitleGroup(){
    if(explanationTitleGroup==null){

      explanationTitleGroup = new ACGroupBox();

      addExplanationTitleGroup();
    }
    return explanationTitleGroup;

  }

  /**
   * ���������x���E�^�C�g�����擾���܂��B
   * @return ���������x���E�^�C�g��
   */
  public ACLabel getExplanationTitleLabel(){
    if(explanationTitleLabel==null){

      explanationTitleLabel = new ACLabel();

      explanationTitleLabel.setText("�񋟃T�[�r�X�̐ݒ���@");

      explanationTitleLabel.setIconPath(ACConstants.ICON_PATH_INFORMATION_48);

      addExplanationTitleLabel();
    }
    return explanationTitleLabel;

  }

  /**
   * ���������x���E���e1���擾���܂��B
   * @return ���������x���E���e1
   */
  public ACLabel getExplanationContentLabel1(){
    if(explanationContentLabel1==null){

      explanationContentLabel1 = new ACLabel();

      explanationContentLabel1.setText("�@���ӁF�񋟃T�[�r�X��I������ƁA���̒��ӏ����͔�\���ɂȂ�܂��B");

      addExplanationContentLabel1();
    }
    return explanationContentLabel1;

  }

  /**
   * ���������x���E���e2���擾���܂��B
   * @return ���������x���E���e2
   */
  public ACLabel getExplanationContentLabe2(){
    if(explanationContentLabe2==null){

      explanationContentLabe2 = new ACLabel();

      explanationContentLabe2.setText("�@1�D��ʍ��̒񋟃T�[�r�X�ꗗ����A�񋟂��Ă���T�[�r�X��I�����Ă��������B");

      addExplanationContentLabe2();
    }
    return explanationContentLabe2;

  }

  /**
   * ���������x���E���e3���擾���܂��B
   * @return ���������x���E���e3
   */
  public ACLabel getExplanationContentLabe3(){
    if(explanationContentLabe3==null){

      explanationContentLabe3 = new ACLabel();

      explanationContentLabe3.setText("�@2�D�u�񋟂���v�Ƀ`�F�b�N�����A�e���ڂ�I�����Ă��������B");

      addExplanationContentLabe3();
    }
    return explanationContentLabe3;

  }

  /**
   * ���������x���E���e4���擾���܂��B
   * @return ���������x���E���e4
   */
  public ACLabel getExplanationContentLabel4(){
    if(explanationContentLabel4==null){

      explanationContentLabel4 = new ACLabel();

      explanationContentLabel4.setText("�@3�D�Ō�Ɂu���f�v�{�^���������Đݒ芮���ƂȂ�܂��B");

      addExplanationContentLabel4();
    }
    return explanationContentLabel4;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004Design() {

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

    this.add(getProviderContents(), VRLayout.CLIENT);

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
   * ���Ə����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderContents(){

    providerContents.add(getProviderMainContents(), VRLayout.NORTH);

    providerContents.add(getProviderSubContents(), VRLayout.WEST);

    providerContents.add(getProviderDetailServiceDetails(), VRLayout.CLIENT);

  }

  /**
   * ���Ə����C�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContents(){

    providerMainContents.add(getProviderIdContainer(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getProviderNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainContents.add(getProviderPostnoContena(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getProviderAddressContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainContents.add(getProviderTelContena(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getProviderFaxContena(), VRLayout.FLOW);

    providerMainContents.add(getProviderEstablishNameContainer(), VRLayout.FLOW_RETURN);

    providerMainContents.add(getProviderMainContentDivisionContainer(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getProviderMainContentBusinessContainer(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getMedical(), VRLayout.FLOW_INSETLINE);

    providerMainContents.add(getProviderTypeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainContents.add(getProviderMainContentRegionContainer(), VRLayout.FLOW);

    providerMainContents.add(getLankSpecialArea(), VRLayout.FLOW);

  }

  /**
   * ���Ə����C�����̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentsLayout(){

  }

  /**
   * ���Ə��ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderId(){

  }

  /**
   * ���Ə����̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderName(){

  }

  /**
   * �X�֔ԍ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderPostnoContena(){

    providerPostnoContena.add(getProviderPostnoOn(), null);

    providerPostnoContena.add(getProviderPostnoHyphen(), null);

    providerPostnoContena.add(getProviderPostnoUnder(), null);

  }

  /**
   * �X�֔ԍ��i��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderPostnoOn(){

  }

  /**
   * �n�C�t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderPostnoHyphen(){

  }

  /**
   * �X�֔ԍ��i���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderPostnoUnder(){

  }

  /**
   * ���ݒn�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderAddress(){

  }

  /**
   * �d�b�ԍ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTelContena(){

    providerTelContena.add(getProviderTelOn(), null);

    providerTelContena.add(getProviderTelHyphen1(), null);

    providerTelContena.add(getProviderTelInside(), null);

    providerTelContena.add(getProviderTelHyphen2(), null);

    providerTelContena.add(getProviderTelUnder(), null);

  }

  /**
   * �d�b�ԍ��i��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTelOn(){

  }

  /**
   * �n�C�t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTelHyphen1(){

  }

  /**
   * �d�b�ԍ��i���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTelInside(){

  }

  /**
   * �n�C�t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTelHyphen2(){

  }

  /**
   * �d�b�ԍ��i���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTelUnder(){

  }

  /**
   * FAX�ԍ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderFaxContena(){

    providerFaxContena.add(getProviderFaxOn(), null);

    providerFaxContena.add(getProviderFaxHyphen1(), null);

    providerFaxContena.add(getProviderFaxInside(), null);

    providerFaxContena.add(getProviderFaxHyphen2(), null);

    providerFaxContena.add(getProviderFaxUnder(), null);

  }

  /**
   * FAX�i��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderFaxOn(){

  }

  /**
   * �n�C�t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderFaxHyphen1(){

  }

  /**
   * FAX�i���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderFaxInside(){

  }

  /**
   * �n�C�t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderFaxHyphen2(){

  }

  /**
   * FAX�i���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderFaxUnder(){

  }

  /**
   * �Ǘ��҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderEstablishName(){

  }

  /**
   * �����Ə��敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentDivision(){

  }

  /**
   * �����Ə��敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentDivisionModel(){

    getProviderMainContentDivisionMine().setButtonIndex(1);

    getProviderMainContentDivisionModel().add(getProviderMainContentDivisionMine());

    getProviderMainContentDivisionOther().setButtonIndex(2);

    getProviderMainContentDivisionModel().add(getProviderMainContentDivisionOther());

  }

  /**
   * �����Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentDivisionMine(){

  }

  /**
   * �����Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentDivisionOther(){

  }

  /**
   * ���Ƌ敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentBusiness(){

  }

  /**
   * ���Ƌ敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentBusinessModel(){

    getProviderMainContentBusinessSpecification().setButtonIndex(1);

    getProviderMainContentBusinessModel().add(getProviderMainContentBusinessSpecification());

    getProviderMainContentBusinessStandard().setButtonIndex(2);

    getProviderMainContentBusinessModel().add(getProviderMainContentBusinessStandard());

    getProviderMainContentBusinessRegion().setButtonIndex(5);

    getProviderMainContentBusinessModel().add(getProviderMainContentBusinessRegion());

  }

  /**
   * �w��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentBusinessSpecification(){

  }

  /**
   * ��Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentBusinessStandard(){

  }

  /**
   * �n�斧���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentBusinessRegion(){

  }

  /**
   * ��Ë@�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addMedical(){

  }

  /**
   * ���Ə���ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderType(){

  }

  /**
   * ���Ə���ʃ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderTypeModel(){

  }

  /**
   * �n��敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentRegion(){

  }

  /**
   * �n��敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentRegionModel(){

    getProviderMainContentRegionLank1().setButtonIndex(1);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank1());

    getProviderMainContentRegionLank2().setButtonIndex(6);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank2());

    getProviderMainContentRegionLank3().setButtonIndex(7);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank3());

    getProviderMainContentRegionLank4().setButtonIndex(2);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank4());

    getProviderMainContentRegionLank5().setButtonIndex(3);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank5());

    getProviderMainContentRegionLank6().setButtonIndex(4);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank6());

    getProviderMainContentRegionLank7().setButtonIndex(9);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank7());

    getProviderMainContentRegionLank8().setButtonIndex(5);

    getProviderMainContentRegionModel().add(getProviderMainContentRegionLank8());

  }

  /**
   * �P���n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentRegionLank1(){

  }

  /**
   * �Q���n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentRegionLank2(){

  }

  /**
   * �R���n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentRegionLank3(){

  }

  /**
   * �S���n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentRegionLank4(){

  }

  /**
   * �T���n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentRegionLank5(){

  }

  /**
   * �U���n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentRegionLank6(){

  }

  /**
   * �V���n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentRegionLank7(){

  }

  /**
   * ���̑��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentRegionLank8(){

  }

  /**
   * ���ʒn��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLankSpecialArea(){

  }

  /**
   * ���Ə��T�u���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderSubContents(){

    providerSubContents.add(getProviderDetailContents(), VRLayout.NORTH);

    providerSubContents.add(getClaimInfos(), VRLayout.NORTH);

    providerSubContents.add(getProviderMainContentChargesPanel(), VRLayout.NORTH);

  }

  /**
   * ���Ə��ڍ׏��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDetailContents(){

    providerDetailContents.add(getProviderDetailServiceKinds(), VRLayout.CLIENT);

  }

  /**
   * ���Ə��ڍ׏��T�[�r�X���X�g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDetailServiceKinds(){

    providerDetailServiceKinds.add(getServiceKindOffer(), VRLayout.NORTH);

  }

  /**
   * �񋟃T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceKindOffer(){

    serviceKindOffer.add(getServiceKindTablePanel(), VRLayout.NORTH);

  }

  /**
   * �񋟃T�[�r�X�e�[�u���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceKindTablePanel(){

    serviceKindTablePanel.add(getServiceKindTable(), VRLayout.CLIENT);

    serviceKindTablePanel.add(getButtonsPanel(), VRLayout.EAST);
  }

  /**
   * �񋟃T�[�r�X�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceKindTable(){

  }

  /**
   * �񋟃T�[�r�X�e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceKindTableColumnModel(){

    getServiceKindTableColumnModel().addColumn(getServiceKindTableColum1());

    getServiceKindTableColumnModel().addColumn(getServiceKindTableColum2());

  }

  /**
   * �񋟂ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceKindTableColum1(){

  }

  /**
   * �񋟃T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceKindTableColum2(){

  }

  /**
   * �{�^���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtonsPanel(){

    buttonsPanel.add(getOfferCheck(), VRLayout.FLOW_RETURN);

    buttonsPanel.add(getReflection(), VRLayout.FLOW);

  }

  /**
   * �񋟃`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOfferCheck(){

  }

  /**
   * ���f�ɓ������ڂ�ǉ����܂��B
   */
  protected void addReflection(){

  }

  /**
   * �����֘A���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClaimInfos(){

    claimInfos.add(getBankNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    claimInfos.add(getBankBranchNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    claimInfos.add(getAccountNumberContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    claimInfos.add(getAccountTypeRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    claimInfos.add(getAccountHolderContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �U������Z�@�֖��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBankName(){

  }

  /**
   * �U������Z�@�֎x�X���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBankBranchName(){

  }

  /**
   * �U��������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAccountNumber(){

  }

  /**
   * �U���������ނɓ������ڂ�ǉ����܂��B
   */
  protected void addAccountTypeRadio(){

  }

  /**
   * �U���������ރ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAccountTypeRadioModel(){

    getAccountTypeRadioItem1().setButtonIndex(1);

    getAccountTypeRadioModel().add(getAccountTypeRadioItem1());

    getAccountTypeRadioItem2().setButtonIndex(2);

    getAccountTypeRadioModel().add(getAccountTypeRadioItem2());

  }

  /**
   * ���ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addAccountTypeRadioItem1(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addAccountTypeRadioItem2(){

  }

  /**
   * �U���於�`�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAccountHolder(){

  }

  /**
   * �S���җ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainContentChargesPanel(){

    providerMainContentChargesPanel.add(getProviderStaffGroup(), VRLayout.CLIENT);

  }

  /**
   * �S���҃O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffGroup(){

    providerStaffGroup.add(getProviderStaffTablePanel(), VRLayout.NORTH);

    providerStaffGroup.add(getProviderStaffInputPanel(), VRLayout.NORTH);

    providerStaffGroup.add(getProviderStaffTableControlPanel(), VRLayout.SOUTH);
  }

  /**
   * �S���҃e�[�u���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffTablePanel(){

    providerStaffTablePanel.add(getProviderStaffTable(), VRLayout.CLIENT);

  }

  /**
   * �S���҃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffTable(){

  }

  /**
   * �S���҃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffTableColumnModel(){

    getProviderStaffTableColumnModel().addColumn(getProviderStaffTableColumn1());

    getProviderStaffTableColumnModel().addColumn(getProviderStaffTableColumn2());

    getProviderStaffTableColumnModel().addColumn(getProviderStaffTableColumn3());

  }

  /**
   * No�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffTableColumn1(){

  }

  /**
   * �x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffTableColumn2(){

  }

  /**
   * �S���Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffTableColumn3(){

  }

  /**
   * �S���ғ��͗̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffInputPanel(){

    providerStaffInputPanel.add(getProviderStaffCareManagerNoContainer(), VRLayout.FLOW_RETURN);

    providerStaffInputPanel.add(getProviderStaffNameContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * �x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffCareManagerNo(){

  }

  /**
   * �S���ҁE�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffNameContainer(){

    providerStaffNameContainer.add(getProviderStaffFamilyNameContainer(), VRLayout.FLOW);

    providerStaffNameContainer.add(getProviderStaffFirstNameContainer(), VRLayout.FLOW);

  }

  /**
   * ���E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffFamilyNameContainer(){

    providerStaffFamilyNameContainer.add(getProviderStaffFamilyName(), VRLayout.FLOW);

  }

  /**
   * �S���Җ��i���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffFamilyName(){

  }

  /**
   * ���E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffFirstNameContainer(){

    providerStaffFirstNameContainer.add(getProviderStaffFirstName(), VRLayout.FLOW);

  }

  /**
   * �S���Җ��i���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffFirstName(){

  }

  /**
   * ����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffTableControlPanel(){

    providerStaffTableControlPanel.add(getProviderStaffDelete(), VRLayout.EAST);
    providerStaffTableControlPanel.add(getProviderStaffFind(), VRLayout.EAST);
    providerStaffTableControlPanel.add(getProviderStaffInsert(), VRLayout.EAST);
  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffInsert(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffFind(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStaffDelete(){

  }

  /**
   * �T�[�r�X��ޏڍ׏��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDetailServiceDetails(){

    providerDetailServiceDetails.add(getExplanationTitleGroup(), VRLayout.CLIENT);

  }

  /**
   * �������O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExplanationTitleGroup(){

    explanationTitleGroup.add(getExplanationTitleLabel(), VRLayout.NORTH);

    explanationTitleGroup.add(getExplanationContentLabel1(), VRLayout.NORTH);

    explanationTitleGroup.add(getExplanationContentLabe2(), VRLayout.NORTH);

    explanationTitleGroup.add(getExplanationContentLabe3(), VRLayout.NORTH);

    explanationTitleGroup.add(getExplanationContentLabel4(), VRLayout.NORTH);

  }

  /**
   * ���������x���E�^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExplanationTitleLabel(){

  }

  /**
   * ���������x���E���e1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExplanationContentLabel1(){

  }

  /**
   * ���������x���E���e2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExplanationContentLabe2(){

  }

  /**
   * ���������x���E���e3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExplanationContentLabe3(){

  }

  /**
   * ���������x���E���e4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExplanationContentLabel4(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004Design getThis() {
    return this;
  }
}
