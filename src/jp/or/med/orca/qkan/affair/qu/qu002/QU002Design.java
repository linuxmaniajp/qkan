
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
 * �J����: �����F
 * �쐬��: 2011/12/19  ���{�R���s���[�^�[������� �����F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ғo�^/�C�� (U)
 * �v���Z�X ���p�ғo�^ (002)
 * �v���O���� ���p�ғo�^ (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
import java.awt.Color;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACKanaSendTextField;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.ACTimeTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanConstants;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * ���p�ғo�^��ʍ��ڃf�U�C��(QU002) 
 */
@SuppressWarnings("serial")
public class QU002Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton clearInsertMode;

  private ACAffairButton clearUpdateMode;

  private ACPanel contents;

  private VRLayout contentsLayout;

  private ACPanel basicInfoAndInfoButtons;

  private ACGroupBox basicInfoAndInfoButtonFlame;

  private VRLayout basicInfoAndInfoButtonLayout;

  private ACPanel basicInfoAndInfoButton;

  private VRLayout basicInfoLayout;

  private ACTextField basicInfoPatientCd;

  private ACLabelContainer basicInfoPatientCdContainer;

  private ACClearableRadioButtonGroup basicInfoSexs;

  private ACLabelContainer basicInfoSexsContainer;

  private ACListModelAdapter basicInfoSexsModel;

  private ACRadioButtonItem basicInfoMan;

  private ACRadioButtonItem basicInfoWoman;

  private ACIntegerCheckBox basicInfoCheck;

  private ACLabelContainer basicInfoNameContena;

  private ACBackLabelContainer basicInfoFamilyNameContena;

  private ACKanaSendTextField basicInfoName1;

  private ACBackLabelContainer basicInfoFirstNameContena;

  private ACKanaSendTextField basicInfoName2;

  private ACLabelContainer basicInfoBirthContena;

  private QkanDateTextField basicInfoBirth;

  private ACLabel basicInfoAgeLabel1;

  private ACTextField basicInfoAge;

  private ACLabel basicInfoAgeLabel2;

  private ACLabelContainer basicInfoFuriganaContena;

  private ACBackLabelContainer basicInfoFamilyFuriganaContena;

  private ACTextField basicInfoFurigana1;

  private ACBackLabelContainer basicInfoFirstFuriganaContena;

  private ACTextField basicInfoFurigana2;

  private ACLabelContainer basicInfoTelContena;

  private ACTextField basicInfoTel2;

  private ACLabel basicInfoTel3;

  private ACTextField basicInfoTel4;

  private ACLabel basicInfoTel5;

  private ACTextField basicInfoTel6;

  private ACLabelContainer basicInfoZips;

  private ACTextField basicInfoZip1;

  private ACLabel basicInfoZip2;

  private ACTextField basicInfoZip3;

  private ACTextField basicInfoAddress;

  private ACLabelContainer basicInfoAddressContainer;

  private ACPanel infoButtons;

  private ACButton toKohiInfoButton;

  private JTabbedPane tabs;

  private ACPanel kaigoInfoAndIdouInfos;

  private ACGroupBox kaigoInfos;

  private VRLayout kaigoInfoLayout;

  private ACPanel kaigoInfoRyo;

  private ACPanel kaigoInfo;

  private VRLayout kaigoInfoLayout2;

  private ACTextField kaigoInfoInsurerId;

  private ACLabelContainer kaigoInfoInsurerIdContainer;

  private ACComboBox kaigoInfoInsurerName;

  private ACLabelContainer kaigoInfoInsurerNameContainer;

  private ACComboBoxModelAdapter kaigoInfoInsurerNameModel;

  private ACTextField yokaigodoNow;

  private ACLabelContainer yokaigodoNowContainer;

  private ACTextField kaigoInfoInsuredId;

  private ACLabelContainer kaigoInfoInsuredIdContainer;

  private ACLabelContainer kaigoInfoBenefitContainer;

  private ACTextField kaigoInfoBenefit;

  private ACLabel kaigoInfoBenefitPercent;

  private ACLabelContainer kaigoInfoKyotakuServiceContena;

  private VRLayout kaigoInfoKyotakuServiceContenaLayout;

  private ACClearableRadioButtonGroup kaigoInfoKyotakuServiceRadio;

  private ACListModelAdapter kaigoInfoKyotakuServiceRadioModel;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem1;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem2;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem3;

  private ACComboBox kaigoInfoKyotakuServicePlanCombo;

  private ACComboBoxModelAdapter kaigoInfoKyotakuServicePlanComboModel;

  private QkanDateTextField kaigoInfoReportDate;

  private ACLabelContainer kaigoInfoReportDateContainer;

  private ACLabelContainer kaigoInfoRequestDivisionContena;

  private ACClearableRadioButtonGroup kaigoInfoRequestDivisionRadio;

  private ACListModelAdapter kaigoInfoRequestDivisionRadioModel;

  private ACRadioButtonItem kaigoInfoRequestDivisionRadioItem1;

  private ACRadioButtonItem kaigoInfoRequestDivisionRadioItem2;

  private ACRadioButtonItem kaigoInfoRequestDivisionRadioItem3;

  private ACIntegerCheckBox kaigoInfoRequests;

  private ACComboBox kaigoInfoYokaigoInfo;

  private ACLabelContainer kaigoInfoYokaigoInfoContainer;

  private ACComboBoxModelAdapter kaigoInfoYokaigoInfoModel;

  private ACLabelContainer kaigoInfoValidLimits;

  private QkanDateTextField kaigoInfoValidLimit1;

  private ACLabel kaigoInfoValidLimit2;

  private QkanDateTextField kaigoInfoValidLimit3;

  private QkanDateTextField kaigoInfoRequestDate;

  private ACLabelContainer kaigoInfoRequestDateContainer;

  private QkanDateTextField kaigoInfoAuthorizeDate;

  private ACLabelContainer kaigoInfoAuthorizeDateContainer;

  private ACGroupBox kaigoInfoProvideLimitGroup;

  private ACLabelContainer kaigoInfoProvideLimitContena;

  private ACTextField kaigoInfoProvideLimit;

  private ACLabel kaigoInfoProvideLimitLabel;

  private ACLabelContainer kaigoInfoExternalUseLimitContena;

  private ACTextField kaigoInfoExternalUseLimit;

  private ACLabel kaigoInfoExternalUseLimitLabel;

  private ACGroupBox kaigoInfoInterruptionGroup;

  private QkanDateTextField kaigoInfoInterruptionDate;

  private ACLabelContainer kaigoInfoInterruptionDateContainer;

  private ACClearableRadioButtonGroup kaigoInfoInterruptionReasonRadio;

  private ACLabelContainer kaigoInfoInterruptionReasonRadioContainer;

  private ACListModelAdapter kaigoInfoInterruptionReasonRadioModel;

  private ACRadioButtonItem kaigoInfoInterruptionReasonRadioItem1;

  private ACRadioButtonItem kaigoInfoInterruptionReasonRadioItem2;

  private ACRadioButtonItem kaigoInfoInterruptionReasonRadioItem3;

  private ACLabel kaigoInfoExplanationLabel1;

  private ACPanel kaigoInfoButtons;

  private ACButton kaigoInfoButtonClear;

  private ACButton kaigoInfoButtonInsert;

  private ACButton kaigoInfoButtonEdit;

  private ACButton kaigoInfoDelete;

  private ACTable kaigoInfoTable;

  private VRTableColumnModel kaigoInfoTableColumnModel;

  private ACTableColumn kaigoInfoTableColumn0;

  private ACTableColumn kaigoInfoTableColumn1;

  private ACTableColumn kaigoInfoTableColumn2;

  private ACTableColumn kaigoInfoTableColumn3;

  private ACTableColumn kaigoInfoTableColumn4;

  private ACTableColumn kaigoInfoTableColumn5;

  private ACTableColumn kaigoInfoTableColumn6;

  private ACTableColumn kaigoInfoTableColumn7;

  private ACTableColumn kaigoInfoTableColumn8;

  private ACTableColumn kaigoInfoTableColumn9;

  private ACPanel idouInfoAndInstitutionInfoPanel;

  private ACGroupBox idouInfoAndInstitutionInfos;

  private VRLayout idouInfoAndInstitutionInfoLayout;

  private ACPanel idouInfoUp;

  private ACPanel idouInfo;

  private VRLayout idouInfoLayout2;

  private ACComboBox idouInfoServise;

  private ACLabelContainer idouInfoServiseContainer;

  private ACComboBoxModelAdapter idouInfoServiseModel;

  private ACComboBox idouInfoChangeContent;

  private ACLabelContainer idouInfoChangeContentContainer;

  private ACComboBoxModelAdapter idouInfoChangeContentModel;

  private QkanDateTextField idouInfoDate;

  private ACLabelContainer idouInfoDateContainer;

  private ACTimeTextField idouInfoTime;

  private ACLabelContainer idouInfoTimeContainer;

  private ACComboBox idouInfoReason;

  private ACLabelContainer idouInfoReasonContainer;

  private ACComboBoxModelAdapter idouInfoReasonModel;

  private ACTextField idouInfoReasonMemo;

  private ACLabelContainer idouInfoReasonMemoContainer;

  private ACPanel idouInfoButtons;

  private ACButton idouInfoButtonClear;

  private ACButton idouInfoButtonInsert;

  private ACButton idouInfoButtonEdit;

  private ACButton idouInfoButtonDelete;

  private ACTable idouInfoTable;

  private VRTableColumnModel idouInfoTableColumnModel;

  private ACTableColumn idouInfoTableColumn0;

  private ACTableColumn idouInfoTableColumn1;

  private ACTableColumn idouInfoTableColumn2;

  private ACTableColumn idouInfoTableColumn3;

  private ACTableColumn idouInfoTableColumn4;

  private ACTableColumn idouInfoTableColumn5;

  private ACGroupBox institutionInfos;

  private VRLayout institutionInfoLayout;

  private ACLabel institutionInfoBearMoneyInfos;

  private ACLabel institutionInfoSpace1;

  private ACIntegerCheckBox institutionInfoTokuteiNyusho;

  private ACLabel institutionInfoSpace2;

  private ACLabelContainer institutionInfoDinnerBearLimitMoneyContena;

  private ACTextField institutionInfoDinnerBearLimitMoneyText;

  private ACLabel institutionInfoDinnerBearLimitMoneyLabel;

  private ACLabelContainer institutionInfoUnitRoomLimitMoneyContena;

  private ACTextField institutionInfoUnitRoomLimitMoneyText;

  private ACLabel institutionInfoUnitRoomLimitMoneyLabel;

  private ACLabelContainer institutionInfoUnitSemiRoomLimitMoneyContena;

  private ACTextField institutionInfoUnitSemiRoomLimitMoneyText;

  private ACLabel institutionInfoUnitSemiRoomLimitMoneyLabel;

  private ACLabelContainer institutionInfoNormalRoomLimitMoneyContena;

  private ACTextField institutionInfoNormalRoomLimitMoneyText;

  private ACLabel institutionInfoNormalRoomLimitMoneyLabel;

  private ACLabelContainer institutionInfoNormalRoomLimitMoneyContena2;

  private ACTextField institutionInfoNormalRoomLimitMoneyText2;

  private ACLabel institutionInfoNormalRoomLimitMoneyLabel2;

  private ACLabelContainer institutionInfoTasyoRoomLimitMoneyContena;

  private ACTextField institutionInfoTasyoRoomLimitMoneyText;

  private ACLabel institutionInfoTasyoRoomLimitMoneyLabel;

  private ACLabel institutionInfoCareOldPersonLabel;

  private ACLabel institutionInfoSpace3;

  private ACIntegerCheckBox institutionInfoOldStep;

  private ACLabel institutionInfoCareOldPersonInsuranceLabel;

  private ACLabel institutionInfoSpace4;

  private ACTextField institutionInfoMainDisease;

  private ACLabelContainer institutionInfoMainDiseaseContainer;

  private ACLabel institutionInfoSpace5;

  private ACGroupBox institutionInfoExplanationGroup;

  private ACLabel institutionInfoExplanationLabel1;

  private ACLabel institutionInfoExplanationLabel2;

  private ACLabel institutionInfoExplanationLabel3;

  //getter

  /**
   * (�Ɩ��{�^���o�[)���擾���܂��B
   * @return (�Ɩ��{�^���o�[)
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("���p�ҏ��o�^");

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
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACAffairButton getClearInsertMode(){
    if(clearInsertMode==null){

      clearInsertMode = new ACAffairButton();

      clearInsertMode.setText("�N���A(C)");

      clearInsertMode.setToolTipText("���p�ҏ����N���A���܂��B");

      clearInsertMode.setMnemonic('C');

      clearInsertMode.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClearInsertMode();
    }
    return clearInsertMode;

  }

  /**
   * �V�K���擾���܂��B
   * @return �V�K
   */
  public ACAffairButton getClearUpdateMode(){
    if(clearUpdateMode==null){

      clearUpdateMode = new ACAffairButton();

      clearUpdateMode.setText("�V�K(N)");

      clearUpdateMode.setToolTipText("���p�ҏ��̐V�K�o�^���s���܂��B");

      clearUpdateMode.setMnemonic('N');

      clearUpdateMode.setIconPath(ACConstants.ICON_PATH_NEW_24);

      addClearUpdateMode();
    }
    return clearUpdateMode;

  }

  /**
   * (�N���C�A���g�̈�)���擾���܂��B
   * @return (�N���C�A���g�̈�)
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setLayout(getContentsLayout());

      addContents();
    }
    return contents;

  }

  /**
   * (�N���C�A���g�̈�E���C�A�E�g)���擾���܂��B
   * @return (�N���C�A���g�̈�E���C�A�E�g)
   */
  public VRLayout getContentsLayout(){
    if(contentsLayout==null){

      contentsLayout = new VRLayout();

      contentsLayout.setAutoWrap(false);

      addContentsLayout();
    }
    return contentsLayout;

  }

  /**
   * (��{���E�{�^���̈�)���擾���܂��B
   * @return (��{���E�{�^���̈�)
   */
  public ACPanel getBasicInfoAndInfoButtons(){
    if(basicInfoAndInfoButtons==null){

      basicInfoAndInfoButtons = new ACPanel();

      addBasicInfoAndInfoButtons();
    }
    return basicInfoAndInfoButtons;

  }

  /**
   * (��{���E�{�^���̈�E�O���[�v)���擾���܂��B
   * @return (��{���E�{�^���̈�E�O���[�v)
   */
  public ACGroupBox getBasicInfoAndInfoButtonFlame(){
    if(basicInfoAndInfoButtonFlame==null){

      basicInfoAndInfoButtonFlame = new ACGroupBox();

      basicInfoAndInfoButtonFlame.setText("��{���");

      basicInfoAndInfoButtonFlame.setLayout(getBasicInfoAndInfoButtonLayout());

      addBasicInfoAndInfoButtonFlame();
    }
    return basicInfoAndInfoButtonFlame;

  }

  /**
   * (��{���E�{�^�����C�A�E�g)���擾���܂��B
   * @return (��{���E�{�^�����C�A�E�g)
   */
  public VRLayout getBasicInfoAndInfoButtonLayout(){
    if(basicInfoAndInfoButtonLayout==null){

      basicInfoAndInfoButtonLayout = new VRLayout();

      basicInfoAndInfoButtonLayout.setAutoWrap(false);

      addBasicInfoAndInfoButtonLayout();
    }
    return basicInfoAndInfoButtonLayout;

  }

  /**
   * (��{���̈�)���擾���܂��B
   * @return (��{���̈�)
   */
  public ACPanel getBasicInfoAndInfoButton(){
    if(basicInfoAndInfoButton==null){

      basicInfoAndInfoButton = new ACPanel();

      basicInfoAndInfoButton.setLayout(getBasicInfoLayout());

      basicInfoAndInfoButton.setAutoWrap(false);

      addBasicInfoAndInfoButton();
    }
    return basicInfoAndInfoButton;

  }

  /**
   * (��{���̈�E���C�A�E�g)���擾���܂��B
   * @return (��{���̈�E���C�A�E�g)
   */
  public VRLayout getBasicInfoLayout(){
    if(basicInfoLayout==null){

      basicInfoLayout = new VRLayout();

      basicInfoLayout.setAutoWrap(false);

      basicInfoLayout.setHgap(0);

      basicInfoLayout.setLabelMargin(0);

      addBasicInfoLayout();
    }
    return basicInfoLayout;

  }

  /**
   * ���p��Cd���擾���܂��B
   * @return ���p��Cd
   */
  public ACTextField getBasicInfoPatientCd(){
    if(basicInfoPatientCd==null){

      basicInfoPatientCd = new ACTextField();

      getBasicInfoPatientCdContainer().setText("���p�҃R�[�h");

      basicInfoPatientCd.setBindPath("PATIENT_CODE");

      basicInfoPatientCd.setColumns(15);

      basicInfoPatientCd.setCharType(VRCharType.ONLY_HALF_CHAR);

      basicInfoPatientCd.setMaxLength(16);

      addBasicInfoPatientCd();
    }
    return basicInfoPatientCd;

  }

  /**
   * ���p��Cd�R���e�i���擾���܂��B
   * @return ���p��Cd�R���e�i
   */
  protected ACLabelContainer getBasicInfoPatientCdContainer(){
    if(basicInfoPatientCdContainer==null){
      basicInfoPatientCdContainer = new ACLabelContainer();
      basicInfoPatientCdContainer.setFollowChildEnabled(true);
      basicInfoPatientCdContainer.setVAlignment(VRLayout.CENTER);
      basicInfoPatientCdContainer.add(getBasicInfoPatientCd(), null);
    }
    return basicInfoPatientCdContainer;
  }

  /**
   * ���ʂ��擾���܂��B
   * @return ����
   */
  public ACClearableRadioButtonGroup getBasicInfoSexs(){
    if(basicInfoSexs==null){

      basicInfoSexs = new ACClearableRadioButtonGroup();

      getBasicInfoSexsContainer().setText("����");

      basicInfoSexs.setBindPath("PATIENT_SEX");

      basicInfoSexs.setUseClearButton(false);

      basicInfoSexs.setModel(getBasicInfoSexsModel());

      addBasicInfoSexs();
    }
    return basicInfoSexs;

  }

  /**
   * ���ʃR���e�i���擾���܂��B
   * @return ���ʃR���e�i
   */
  protected ACLabelContainer getBasicInfoSexsContainer(){
    if(basicInfoSexsContainer==null){
      basicInfoSexsContainer = new ACLabelContainer();
      basicInfoSexsContainer.setFollowChildEnabled(true);
      basicInfoSexsContainer.setVAlignment(VRLayout.CENTER);
      basicInfoSexsContainer.add(getBasicInfoSexs(), null);
    }
    return basicInfoSexsContainer;
  }

  /**
   * ���ʃ��f�����擾���܂��B
   * @return ���ʃ��f��
   */
  protected ACListModelAdapter getBasicInfoSexsModel(){
    if(basicInfoSexsModel==null){
      basicInfoSexsModel = new ACListModelAdapter();
      addBasicInfoSexsModel();
    }
    return basicInfoSexsModel;
  }

  /**
   * �j���擾���܂��B
   * @return �j
   */
  public ACRadioButtonItem getBasicInfoMan(){
    if(basicInfoMan==null){

      basicInfoMan = new ACRadioButtonItem();

      basicInfoMan.setText("�j");

      basicInfoMan.setGroup(getBasicInfoSexs());

      basicInfoMan.setConstraints(VRLayout.FLOW);

      addBasicInfoMan();
    }
    return basicInfoMan;

  }

  /**
   * �����擾���܂��B
   * @return ��
   */
  public ACRadioButtonItem getBasicInfoWoman(){
    if(basicInfoWoman==null){

      basicInfoWoman = new ACRadioButtonItem();

      basicInfoWoman.setText("��");

      basicInfoWoman.setGroup(getBasicInfoSexs());

      basicInfoWoman.setConstraints(VRLayout.FLOW);

      addBasicInfoWoman();
    }
    return basicInfoWoman;

  }

  /**
   * �ꗗ�ɕ\���E�`�F�b�N���擾���܂��B
   * @return �ꗗ�ɕ\���E�`�F�b�N
   */
  public ACIntegerCheckBox getBasicInfoCheck(){
    if(basicInfoCheck==null){

      basicInfoCheck = new ACIntegerCheckBox();

      basicInfoCheck.setText("�ꗗ�ɕ\������");

      basicInfoCheck.setBindPath("SHOW_FLAG");

      addBasicInfoCheck();
    }
    return basicInfoCheck;

  }

  /**
   * (�����E�R���e�i)���擾���܂��B
   * @return (�����E�R���e�i)
   */
  public ACLabelContainer getBasicInfoNameContena(){
    if(basicInfoNameContena==null){

      basicInfoNameContena = new ACLabelContainer();

      basicInfoNameContena.setText("����");

      addBasicInfoNameContena();
    }
    return basicInfoNameContena;

  }

  /**
   * (����1�E�w�ʃR���e�i)���擾���܂��B
   * @return (����1�E�w�ʃR���e�i)
   */
  public ACBackLabelContainer getBasicInfoFamilyNameContena(){
    if(basicInfoFamilyNameContena==null){

      basicInfoFamilyNameContena = new ACBackLabelContainer();

      basicInfoFamilyNameContena.setText("��");

      addBasicInfoFamilyNameContena();
    }
    return basicInfoFamilyNameContena;

  }

  /**
   * ����1���擾���܂��B
   * @return ����1
   */
  public ACKanaSendTextField getBasicInfoName1(){
    if(basicInfoName1==null){

      basicInfoName1 = new ACKanaSendTextField();

      basicInfoName1.setBindPath("PATIENT_FAMILY_NAME");

      basicInfoName1.setColumns(16);

      basicInfoName1.setIMEMode(InputSubset.KANJI);

      basicInfoName1.setMaxLength(16);

      basicInfoName1.setKanaField(getBasicInfoFurigana1());

      addBasicInfoName1();
    }
    return basicInfoName1;

  }

  /**
   * (����2�E�w�ʃR���e�i)���擾���܂��B
   * @return (����2�E�w�ʃR���e�i)
   */
  public ACBackLabelContainer getBasicInfoFirstNameContena(){
    if(basicInfoFirstNameContena==null){

      basicInfoFirstNameContena = new ACBackLabelContainer();

      basicInfoFirstNameContena.setText("��");

      addBasicInfoFirstNameContena();
    }
    return basicInfoFirstNameContena;

  }

  /**
   * ����2���擾���܂��B
   * @return ����2
   */
  public ACKanaSendTextField getBasicInfoName2(){
    if(basicInfoName2==null){

      basicInfoName2 = new ACKanaSendTextField();

      basicInfoName2.setBindPath("PATIENT_FIRST_NAME");

      basicInfoName2.setColumns(16);

      basicInfoName2.setIMEMode(InputSubset.KANJI);

      basicInfoName2.setMaxLength(16);

      basicInfoName2.setKanaField(getBasicInfoFurigana2());

      addBasicInfoName2();
    }
    return basicInfoName2;

  }

  /**
   * (���N�����E�R���e�i)���擾���܂��B
   * @return (���N�����E�R���e�i)
   */
  public ACLabelContainer getBasicInfoBirthContena(){
    if(basicInfoBirthContena==null){

      basicInfoBirthContena = new ACLabelContainer();

      basicInfoBirthContena.setText("���N����");

      addBasicInfoBirthContena();
    }
    return basicInfoBirthContena;

  }

  /**
   * ���N�������擾���܂��B
   * @return ���N����
   */
  public QkanDateTextField getBasicInfoBirth(){
    if(basicInfoBirth==null){

      basicInfoBirth = new QkanDateTextField();

      basicInfoBirth.setBindPath("PATIENT_BIRTHDAY");

      addBasicInfoBirth();
    }
    return basicInfoBirth;

  }

  /**
   * �N��x�����擾���܂��B
   * @return �N��x��
   */
  public ACLabel getBasicInfoAgeLabel1(){
    if(basicInfoAgeLabel1==null){

      basicInfoAgeLabel1 = new ACLabel();

      basicInfoAgeLabel1.setText("�@�N��");

      addBasicInfoAgeLabel1();
    }
    return basicInfoAgeLabel1;

  }

  /**
   * �N����擾���܂��B
   * @return �N��
   */
  public ACTextField getBasicInfoAge(){
    if(basicInfoAge==null){

      basicInfoAge = new ACTextField();

      basicInfoAge.setBindPath("PATIENT_BIRTHDAY");

      basicInfoAge.setEditable(false);

      basicInfoAge.setColumns(3);

      basicInfoAge.setFormat(QkanConstants.FORMAT_NOW_AGE);

      basicInfoAge.setHorizontalAlignment(SwingConstants.RIGHT);

      addBasicInfoAge();
    }
    return basicInfoAge;

  }

  /**
   * �΃��x�����擾���܂��B
   * @return �΃��x��
   */
  public ACLabel getBasicInfoAgeLabel2(){
    if(basicInfoAgeLabel2==null){

      basicInfoAgeLabel2 = new ACLabel();

      basicInfoAgeLabel2.setText(" ��");

      addBasicInfoAgeLabel2();
    }
    return basicInfoAgeLabel2;

  }

  /**
   * (�t���K�i�E�R���e�i)���擾���܂��B
   * @return (�t���K�i�E�R���e�i)
   */
  public ACLabelContainer getBasicInfoFuriganaContena(){
    if(basicInfoFuriganaContena==null){

      basicInfoFuriganaContena = new ACLabelContainer();

      basicInfoFuriganaContena.setText("�ӂ肪��");

      addBasicInfoFuriganaContena();
    }
    return basicInfoFuriganaContena;

  }

  /**
   * (�t���K�i1�E�w�ʃR���e�i)���擾���܂��B
   * @return (�t���K�i1�E�w�ʃR���e�i)
   */
  public ACBackLabelContainer getBasicInfoFamilyFuriganaContena(){
    if(basicInfoFamilyFuriganaContena==null){

      basicInfoFamilyFuriganaContena = new ACBackLabelContainer();

      basicInfoFamilyFuriganaContena.setText("��");

      addBasicInfoFamilyFuriganaContena();
    }
    return basicInfoFamilyFuriganaContena;

  }

  /**
   * �t���K�i1���擾���܂��B
   * @return �t���K�i1
   */
  public ACTextField getBasicInfoFurigana1(){
    if(basicInfoFurigana1==null){

      basicInfoFurigana1 = new ACTextField();

      basicInfoFurigana1.setBindPath("PATIENT_FAMILY_KANA");

      basicInfoFurigana1.setColumns(16);

      basicInfoFurigana1.setIMEMode(InputSubset.KANJI);

      basicInfoFurigana1.setMaxLength(16);

      addBasicInfoFurigana1();
    }
    return basicInfoFurigana1;

  }

  /**
   * (�t���K�i2�E�w�ʃR���e�i)���擾���܂��B
   * @return (�t���K�i2�E�w�ʃR���e�i)
   */
  public ACBackLabelContainer getBasicInfoFirstFuriganaContena(){
    if(basicInfoFirstFuriganaContena==null){

      basicInfoFirstFuriganaContena = new ACBackLabelContainer();

      basicInfoFirstFuriganaContena.setText("��");

      addBasicInfoFirstFuriganaContena();
    }
    return basicInfoFirstFuriganaContena;

  }

  /**
   * �t���K�i2���擾���܂��B
   * @return �t���K�i2
   */
  public ACTextField getBasicInfoFurigana2(){
    if(basicInfoFurigana2==null){

      basicInfoFurigana2 = new ACTextField();

      basicInfoFurigana2.setBindPath("PATIENT_FIRST_KANA");

      basicInfoFurigana2.setColumns(16);

      basicInfoFurigana2.setIMEMode(InputSubset.KANJI);

      basicInfoFurigana2.setMaxLength(16);

      addBasicInfoFurigana2();
    }
    return basicInfoFurigana2;

  }

  /**
   * (�d�b�ԍ��E�R���e�i)���擾���܂��B
   * @return (�d�b�ԍ��E�R���e�i)
   */
  public ACLabelContainer getBasicInfoTelContena(){
    if(basicInfoTelContena==null){

      basicInfoTelContena = new ACLabelContainer();

      basicInfoTelContena.setText("�d�b�ԍ�");

      addBasicInfoTelContena();
    }
    return basicInfoTelContena;

  }

  /**
   * �d�b�ԍ��E�e�L�X�g1���擾���܂��B
   * @return �d�b�ԍ��E�e�L�X�g1
   */
  public ACTextField getBasicInfoTel2(){
    if(basicInfoTel2==null){

      basicInfoTel2 = new ACTextField();

      basicInfoTel2.setBindPath("PATIENT_TEL_FIRST");

      basicInfoTel2.setColumns(4);

      basicInfoTel2.setCharType(VRCharType.ONLY_DIGIT);

      basicInfoTel2.setIMEMode(InputSubset.LATIN);

      basicInfoTel2.setMaxLength(6);

      addBasicInfoTel2();
    }
    return basicInfoTel2;

  }

  /**
   * �d�b�ԍ��E���x��1���擾���܂��B
   * @return �d�b�ԍ��E���x��1
   */
  public ACLabel getBasicInfoTel3(){
    if(basicInfoTel3==null){

      basicInfoTel3 = new ACLabel();

      basicInfoTel3.setText("-");

      addBasicInfoTel3();
    }
    return basicInfoTel3;

  }

  /**
   * �d�b�ԍ��E�e�L�X�g2���擾���܂��B
   * @return �d�b�ԍ��E�e�L�X�g2
   */
  public ACTextField getBasicInfoTel4(){
    if(basicInfoTel4==null){

      basicInfoTel4 = new ACTextField();

      basicInfoTel4.setBindPath("PATIENT_TEL_SECOND");

      basicInfoTel4.setColumns(4);

      basicInfoTel4.setCharType(VRCharType.ONLY_DIGIT);

      basicInfoTel4.setIMEMode(InputSubset.LATIN);

      basicInfoTel4.setMaxLength(4);

      addBasicInfoTel4();
    }
    return basicInfoTel4;

  }

  /**
   * �d�b�ԍ��E���x��2���擾���܂��B
   * @return �d�b�ԍ��E���x��2
   */
  public ACLabel getBasicInfoTel5(){
    if(basicInfoTel5==null){

      basicInfoTel5 = new ACLabel();

      basicInfoTel5.setText("-");

      addBasicInfoTel5();
    }
    return basicInfoTel5;

  }

  /**
   * �d�b�ԍ��E�e�L�X�g3���擾���܂��B
   * @return �d�b�ԍ��E�e�L�X�g3
   */
  public ACTextField getBasicInfoTel6(){
    if(basicInfoTel6==null){

      basicInfoTel6 = new ACTextField();

      basicInfoTel6.setBindPath("PATIENT_TEL_THIRD");

      basicInfoTel6.setColumns(4);

      basicInfoTel6.setCharType(VRCharType.ONLY_DIGIT);

      basicInfoTel6.setIMEMode(InputSubset.LATIN);

      basicInfoTel6.setMaxLength(4);

      addBasicInfoTel6();
    }
    return basicInfoTel6;

  }

  /**
   * (�X�֔ԍ��E�R���e�i)���擾���܂��B
   * @return (�X�֔ԍ��E�R���e�i)
   */
  public ACLabelContainer getBasicInfoZips(){
    if(basicInfoZips==null){

      basicInfoZips = new ACLabelContainer();

      basicInfoZips.setText("�X�֔ԍ�");

      addBasicInfoZips();
    }
    return basicInfoZips;

  }

  /**
   * �X�֔ԍ��e�L�X�g1���擾���܂��B
   * @return �X�֔ԍ��e�L�X�g1
   */
  public ACTextField getBasicInfoZip1(){
    if(basicInfoZip1==null){

      basicInfoZip1 = new ACTextField();

      basicInfoZip1.setBindPath("PATIENT_ZIP_FIRST");

      basicInfoZip1.setColumns(4);

      basicInfoZip1.setCharType(VRCharType.ONLY_DIGIT);

      basicInfoZip1.setIMEMode(InputSubset.LATIN);

      basicInfoZip1.setMaxLength(3);

      addBasicInfoZip1();
    }
    return basicInfoZip1;

  }

  /**
   * �X�֔ԍ��E���x��1���擾���܂��B
   * @return �X�֔ԍ��E���x��1
   */
  public ACLabel getBasicInfoZip2(){
    if(basicInfoZip2==null){

      basicInfoZip2 = new ACLabel();

      basicInfoZip2.setText("-");

      addBasicInfoZip2();
    }
    return basicInfoZip2;

  }

  /**
   * �X�֔ԍ��e�L�X�g2���擾���܂��B
   * @return �X�֔ԍ��e�L�X�g2
   */
  public ACTextField getBasicInfoZip3(){
    if(basicInfoZip3==null){

      basicInfoZip3 = new ACTextField();

      basicInfoZip3.setBindPath("PATIENT_ZIP_SECOND");

      basicInfoZip3.setColumns(4);

      basicInfoZip3.setCharType(VRCharType.ONLY_DIGIT);

      basicInfoZip3.setIMEMode(InputSubset.LATIN);

      basicInfoZip3.setMaxLength(4);

      addBasicInfoZip3();
    }
    return basicInfoZip3;

  }

  /**
   * �Z�����擾���܂��B
   * @return �Z��
   */
  public ACTextField getBasicInfoAddress(){
    if(basicInfoAddress==null){

      basicInfoAddress = new ACTextField();

      getBasicInfoAddressContainer().setText("�Z��");

      basicInfoAddress.setBindPath("PATIENT_ADDRESS");

      basicInfoAddress.setColumns(64);

      basicInfoAddress.setIMEMode(InputSubset.KANJI);

      basicInfoAddress.setMaxLength(64);

      addBasicInfoAddress();
    }
    return basicInfoAddress;

  }

  /**
   * �Z���R���e�i���擾���܂��B
   * @return �Z���R���e�i
   */
  protected ACLabelContainer getBasicInfoAddressContainer(){
    if(basicInfoAddressContainer==null){
      basicInfoAddressContainer = new ACLabelContainer();
      basicInfoAddressContainer.setFollowChildEnabled(true);
      basicInfoAddressContainer.setVAlignment(VRLayout.CENTER);
      basicInfoAddressContainer.add(getBasicInfoAddress(), null);
    }
    return basicInfoAddressContainer;
  }

  /**
   * (�{�^���̈�)���擾���܂��B
   * @return (�{�^���̈�)
   */
  public ACPanel getInfoButtons(){
    if(infoButtons==null){

      infoButtons = new ACPanel();

      addInfoButtons();
    }
    return infoButtons;

  }

  /**
   * ����E�Е��y�������擾���܂��B
   * @return ����E�Е��y�����
   */
  public ACButton getToKohiInfoButton(){
    if(toKohiInfoButton==null){

      toKohiInfoButton = new ACButton();

      toKohiInfoButton.setText("����E�Е��y�����");

      toKohiInfoButton.setToolTipText("����E�Е��y������ʂɑJ�ڂ��܂��B");

      addToKohiInfoButton();
    }
    return toKohiInfoButton;

  }

  /**
   * (�^�u)���擾���܂��B
   * @return (�^�u)
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * (���ی����E�ٓ����̈�)���擾���܂��B
   * @return (���ی����E�ٓ����̈�)
   */
  public ACPanel getKaigoInfoAndIdouInfos(){
    if(kaigoInfoAndIdouInfos==null){

      kaigoInfoAndIdouInfos = new ACPanel();

      addKaigoInfoAndIdouInfos();
    }
    return kaigoInfoAndIdouInfos;

  }

  /**
   * (���ی����̈�)���擾���܂��B
   * @return (���ی����̈�)
   */
  public ACGroupBox getKaigoInfos(){
    if(kaigoInfos==null){

      kaigoInfos = new ACGroupBox();

      kaigoInfos.setText("���ی����");

      kaigoInfos.setLayout(getKaigoInfoLayout());

      addKaigoInfos();
    }
    return kaigoInfos;

  }

  /**
   * (���ی����̈�E���C�A�E�g)���擾���܂��B
   * @return (���ی����̈�E���C�A�E�g)
   */
  public VRLayout getKaigoInfoLayout(){
    if(kaigoInfoLayout==null){

      kaigoInfoLayout = new VRLayout();

      kaigoInfoLayout.setAutoWrap(false);

      kaigoInfoLayout.setHgap(0);

      kaigoInfoLayout.setLabelMargin(0);

      addKaigoInfoLayout();
    }
    return kaigoInfoLayout;

  }

  /**
   * (���ی��̈�)���擾���܂��B
   * @return (���ی��̈�)
   */
  public ACPanel getKaigoInfoRyo(){
    if(kaigoInfoRyo==null){

      kaigoInfoRyo = new ACPanel();

      addKaigoInfoRyo();
    }
    return kaigoInfoRyo;

  }

  /**
   * (���ی��̈�)���擾���܂��B
   * @return (���ی��̈�)
   */
  public ACPanel getKaigoInfo(){
    if(kaigoInfo==null){

      kaigoInfo = new ACPanel();

      kaigoInfo.setLayout(getKaigoInfoLayout2());

      addKaigoInfo();
    }
    return kaigoInfo;

  }

  /**
   * (���ی��̈�E���C�A�E�g)���擾���܂��B
   * @return (���ی��̈�E���C�A�E�g)
   */
  public VRLayout getKaigoInfoLayout2(){
    if(kaigoInfoLayout2==null){

      kaigoInfoLayout2 = new VRLayout();

      kaigoInfoLayout2.setAutoWrap(false);

      kaigoInfoLayout2.setHgap(2);

      kaigoInfoLayout2.setHgrid(150);

      addKaigoInfoLayout2();
    }
    return kaigoInfoLayout2;

  }

  /**
   * �ی��Ҕԍ����擾���܂��B
   * @return �ی��Ҕԍ�
   */
  public ACTextField getKaigoInfoInsurerId(){
    if(kaigoInfoInsurerId==null){

      kaigoInfoInsurerId = new ACTextField();

      getKaigoInfoInsurerIdContainer().setText("�ی��Ҕԍ�");

      kaigoInfoInsurerId.setBindPath("INSURER_ID");

      kaigoInfoInsurerId.setColumns(9);

      kaigoInfoInsurerId.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoInsurerId.setIMEMode(InputSubset.LATIN);

      kaigoInfoInsurerId.setMaxLength(6);

      addKaigoInfoInsurerId();
    }
    return kaigoInfoInsurerId;

  }

  /**
   * �ی��Ҕԍ��R���e�i���擾���܂��B
   * @return �ی��Ҕԍ��R���e�i
   */
  protected ACLabelContainer getKaigoInfoInsurerIdContainer(){
    if(kaigoInfoInsurerIdContainer==null){
      kaigoInfoInsurerIdContainer = new ACLabelContainer();
      kaigoInfoInsurerIdContainer.setFollowChildEnabled(true);
      kaigoInfoInsurerIdContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoInsurerIdContainer.add(getKaigoInfoInsurerId(), null);
    }
    return kaigoInfoInsurerIdContainer;
  }

  /**
   * �ی��Җ����擾���܂��B
   * @return �ی��Җ�
   */
  public ACComboBox getKaigoInfoInsurerName(){
    if(kaigoInfoInsurerName==null){

      kaigoInfoInsurerName = new ACComboBox();

      getKaigoInfoInsurerNameContainer().setText("�ی��Җ�");

      kaigoInfoInsurerName.setBindPath("INSURER_ID");

      kaigoInfoInsurerName.setEditable(false);

      kaigoInfoInsurerName.setColumns(10);

      kaigoInfoInsurerName.setModelBindPath("INSURER");

      kaigoInfoInsurerName.setRenderBindPath("INSURER_NAME");

      kaigoInfoInsurerName.setMaxColumns(18);

      kaigoInfoInsurerName.setModel(getKaigoInfoInsurerNameModel());

      addKaigoInfoInsurerName();
    }
    return kaigoInfoInsurerName;

  }

  /**
   * �ی��Җ��R���e�i���擾���܂��B
   * @return �ی��Җ��R���e�i
   */
  protected ACLabelContainer getKaigoInfoInsurerNameContainer(){
    if(kaigoInfoInsurerNameContainer==null){
      kaigoInfoInsurerNameContainer = new ACLabelContainer();
      kaigoInfoInsurerNameContainer.setFollowChildEnabled(true);
      kaigoInfoInsurerNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoInsurerNameContainer.add(getKaigoInfoInsurerName(), null);
    }
    return kaigoInfoInsurerNameContainer;
  }

  /**
   * �ی��Җ����f�����擾���܂��B
   * @return �ی��Җ����f��
   */
  protected ACComboBoxModelAdapter getKaigoInfoInsurerNameModel(){
    if(kaigoInfoInsurerNameModel==null){
      kaigoInfoInsurerNameModel = new ACComboBoxModelAdapter();
      addKaigoInfoInsurerNameModel();
    }
    return kaigoInfoInsurerNameModel;
  }

  /**
   * ���݂̗v���x���擾���܂��B
   * @return ���݂̗v���x
   */
  public ACTextField getYokaigodoNow(){
    if(yokaigodoNow==null){

      yokaigodoNow = new ACTextField();

      getYokaigodoNowContainer().setText("���݂̗v���x");

      yokaigodoNow.setEditable(false);

      yokaigodoNow.setColumns(7);

      yokaigodoNow.setHorizontalAlignment(SwingConstants.CENTER);

      yokaigodoNow.setForeground(Color.BLUE);

      addYokaigodoNow();
    }
    return yokaigodoNow;

  }

  /**
   * ���݂̗v���x�R���e�i���擾���܂��B
   * @return ���݂̗v���x�R���e�i
   */
  protected ACLabelContainer getYokaigodoNowContainer(){
    if(yokaigodoNowContainer==null){
      yokaigodoNowContainer = new ACLabelContainer();
      yokaigodoNowContainer.setFollowChildEnabled(true);
      yokaigodoNowContainer.setVAlignment(VRLayout.CENTER);
      yokaigodoNowContainer.add(getYokaigodoNow(), null);
    }
    return yokaigodoNowContainer;
  }

  /**
   * ��ی��Ҕԍ����擾���܂��B
   * @return ��ی��Ҕԍ�
   */
  public ACTextField getKaigoInfoInsuredId(){
    if(kaigoInfoInsuredId==null){

      kaigoInfoInsuredId = new ACTextField();

      getKaigoInfoInsuredIdContainer().setText("��ی��Ҕԍ�");

      kaigoInfoInsuredId.setBindPath("INSURED_ID");

      kaigoInfoInsuredId.setColumns(9);

      kaigoInfoInsuredId.setCharType(VRCharType.ONLY_ALNUM);

      kaigoInfoInsuredId.setMaxLength(10);

      addKaigoInfoInsuredId();
    }
    return kaigoInfoInsuredId;

  }

  /**
   * ��ی��Ҕԍ��R���e�i���擾���܂��B
   * @return ��ی��Ҕԍ��R���e�i
   */
  protected ACLabelContainer getKaigoInfoInsuredIdContainer(){
    if(kaigoInfoInsuredIdContainer==null){
      kaigoInfoInsuredIdContainer = new ACLabelContainer();
      kaigoInfoInsuredIdContainer.setFollowChildEnabled(true);
      kaigoInfoInsuredIdContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoInsuredIdContainer.add(getKaigoInfoInsuredId(), null);
    }
    return kaigoInfoInsuredIdContainer;
  }

  /**
   * (���t���̈�E�R���e�i)���擾���܂��B
   * @return (���t���̈�E�R���e�i)
   */
  public ACLabelContainer getKaigoInfoBenefitContainer(){
    if(kaigoInfoBenefitContainer==null){

      kaigoInfoBenefitContainer = new ACLabelContainer();

      kaigoInfoBenefitContainer.setText("���t��");

      addKaigoInfoBenefitContainer();
    }
    return kaigoInfoBenefitContainer;

  }

  /**
   * ���t�����擾���܂��B
   * @return ���t��
   */
  public ACTextField getKaigoInfoBenefit(){
    if(kaigoInfoBenefit==null){

      kaigoInfoBenefit = new ACTextField();

      kaigoInfoBenefit.setBindPath("INSURE_RATE");

      kaigoInfoBenefit.setColumns(3);

      kaigoInfoBenefit.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoBenefit.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoBenefit.setMaxLength(3);

      addKaigoInfoBenefit();
    }
    return kaigoInfoBenefit;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getKaigoInfoBenefitPercent(){
    if(kaigoInfoBenefitPercent==null){

      kaigoInfoBenefitPercent = new ACLabel();

      kaigoInfoBenefitPercent.setText(" ��");

      addKaigoInfoBenefitPercent();
    }
    return kaigoInfoBenefitPercent;

  }

  /**
   * (����T�[�r�X�v��쐬�ҁE�R���e�i)���擾���܂��B
   * @return (����T�[�r�X�v��쐬�ҁE�R���e�i)
   */
  public ACLabelContainer getKaigoInfoKyotakuServiceContena(){
    if(kaigoInfoKyotakuServiceContena==null){

      kaigoInfoKyotakuServiceContena = new ACLabelContainer();

      kaigoInfoKyotakuServiceContena.setText("����T�[�r�X�v��쐬��");

      kaigoInfoKyotakuServiceContena.setLayout(getKaigoInfoKyotakuServiceContenaLayout());

      addKaigoInfoKyotakuServiceContena();
    }
    return kaigoInfoKyotakuServiceContena;

  }

  /**
   * (����T�[�r�X�v��쐬�ҁE�R���e�i�E���C�A�E�g)���擾���܂��B
   * @return (����T�[�r�X�v��쐬�ҁE�R���e�i�E���C�A�E�g)
   */
  public VRLayout getKaigoInfoKyotakuServiceContenaLayout(){
    if(kaigoInfoKyotakuServiceContenaLayout==null){

      kaigoInfoKyotakuServiceContenaLayout = new VRLayout();

      kaigoInfoKyotakuServiceContenaLayout.setAutoWrap(true);

      addKaigoInfoKyotakuServiceContenaLayout();
    }
    return kaigoInfoKyotakuServiceContenaLayout;

  }

  /**
   * ����T�[�r�X�E���W�I�O���[�v���擾���܂��B
   * @return ����T�[�r�X�E���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getKaigoInfoKyotakuServiceRadio(){
    if(kaigoInfoKyotakuServiceRadio==null){

      kaigoInfoKyotakuServiceRadio = new ACClearableRadioButtonGroup();

      kaigoInfoKyotakuServiceRadio.setBindPath("PLANNER");

      kaigoInfoKyotakuServiceRadio.setUseClearButton(true);

      kaigoInfoKyotakuServiceRadio.setModel(getKaigoInfoKyotakuServiceRadioModel());

      addKaigoInfoKyotakuServiceRadio();
    }
    return kaigoInfoKyotakuServiceRadio;

  }

  /**
   * ����T�[�r�X�E���W�I�O���[�v���f�����擾���܂��B
   * @return ����T�[�r�X�E���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getKaigoInfoKyotakuServiceRadioModel(){
    if(kaigoInfoKyotakuServiceRadioModel==null){
      kaigoInfoKyotakuServiceRadioModel = new ACListModelAdapter();
      addKaigoInfoKyotakuServiceRadioModel();
    }
    return kaigoInfoKyotakuServiceRadioModel;
  }

  /**
   * ������x�����Ə����擾���܂��B
   * @return ������x�����Ə�
   */
  public ACRadioButtonItem getKaigoInfoKyotakuServiceRadioItem1(){
    if(kaigoInfoKyotakuServiceRadioItem1==null){

      kaigoInfoKyotakuServiceRadioItem1 = new ACRadioButtonItem();

      kaigoInfoKyotakuServiceRadioItem1.setText("������x�����Ə�");

      kaigoInfoKyotakuServiceRadioItem1.setGroup(getKaigoInfoKyotakuServiceRadio());

      kaigoInfoKyotakuServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoInfoKyotakuServiceRadioItem1();
    }
    return kaigoInfoKyotakuServiceRadioItem1;

  }

  /**
   * ��ی��҂��擾���܂��B
   * @return ��ی���
   */
  public ACRadioButtonItem getKaigoInfoKyotakuServiceRadioItem2(){
    if(kaigoInfoKyotakuServiceRadioItem2==null){

      kaigoInfoKyotakuServiceRadioItem2 = new ACRadioButtonItem();

      kaigoInfoKyotakuServiceRadioItem2.setText("��ی���");

      kaigoInfoKyotakuServiceRadioItem2.setGroup(getKaigoInfoKyotakuServiceRadio());

      kaigoInfoKyotakuServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoInfoKyotakuServiceRadioItem2();
    }
    return kaigoInfoKyotakuServiceRadioItem2;

  }

  /**
   * ���\�h�x�����Ə����擾���܂��B
   * @return ���\�h�x�����Ə�
   */
  public ACRadioButtonItem getKaigoInfoKyotakuServiceRadioItem3(){
    if(kaigoInfoKyotakuServiceRadioItem3==null){

      kaigoInfoKyotakuServiceRadioItem3 = new ACRadioButtonItem();

      kaigoInfoKyotakuServiceRadioItem3.setText("���\�h�x�����Ə�");

      kaigoInfoKyotakuServiceRadioItem3.setGroup(getKaigoInfoKyotakuServiceRadio());

      kaigoInfoKyotakuServiceRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoInfoKyotakuServiceRadioItem3();
    }
    return kaigoInfoKyotakuServiceRadioItem3;

  }

  /**
   * ����T�[�r�X�v��쐬�ҁE�R���{���擾���܂��B
   * @return ����T�[�r�X�v��쐬�ҁE�R���{
   */
  public ACComboBox getKaigoInfoKyotakuServicePlanCombo(){
    if(kaigoInfoKyotakuServicePlanCombo==null){

      kaigoInfoKyotakuServicePlanCombo = new ACComboBox();

      kaigoInfoKyotakuServicePlanCombo.setBindPath("PROVIDER_ID");

      kaigoInfoKyotakuServicePlanCombo.setEditable(false);

      kaigoInfoKyotakuServicePlanCombo.setColumns(18);

      kaigoInfoKyotakuServicePlanCombo.setModelBindPath("PROVIDER");

      kaigoInfoKyotakuServicePlanCombo.setRenderBindPath("PROVIDER_NAME");

      kaigoInfoKyotakuServicePlanCombo.setMaxColumns(64);

      kaigoInfoKyotakuServicePlanCombo.setModel(getKaigoInfoKyotakuServicePlanComboModel());

      addKaigoInfoKyotakuServicePlanCombo();
    }
    return kaigoInfoKyotakuServicePlanCombo;

  }

  /**
   * ����T�[�r�X�v��쐬�ҁE�R���{���f�����擾���܂��B
   * @return ����T�[�r�X�v��쐬�ҁE�R���{���f��
   */
  protected ACComboBoxModelAdapter getKaigoInfoKyotakuServicePlanComboModel(){
    if(kaigoInfoKyotakuServicePlanComboModel==null){
      kaigoInfoKyotakuServicePlanComboModel = new ACComboBoxModelAdapter();
      addKaigoInfoKyotakuServicePlanComboModel();
    }
    return kaigoInfoKyotakuServicePlanComboModel;
  }

  /**
   * ����T�[�r�X�v��쐬�˗��͏o�����擾���܂��B
   * @return ����T�[�r�X�v��쐬�˗��͏o��
   */
  public QkanDateTextField getKaigoInfoReportDate(){
    if(kaigoInfoReportDate==null){

      kaigoInfoReportDate = new QkanDateTextField();

      getKaigoInfoReportDateContainer().setText("�쐬�˗��͏o��");

      kaigoInfoReportDate.setBindPath("REPORTED_DATE");

      addKaigoInfoReportDate();
    }
    return kaigoInfoReportDate;

  }

  /**
   * ����T�[�r�X�v��쐬�˗��͏o���R���e�i���擾���܂��B
   * @return ����T�[�r�X�v��쐬�˗��͏o���R���e�i
   */
  protected ACLabelContainer getKaigoInfoReportDateContainer(){
    if(kaigoInfoReportDateContainer==null){
      kaigoInfoReportDateContainer = new ACLabelContainer();
      kaigoInfoReportDateContainer.setFollowChildEnabled(true);
      kaigoInfoReportDateContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoReportDateContainer.add(getKaigoInfoReportDate(), null);
    }
    return kaigoInfoReportDateContainer;
  }

  /**
   * (�\���敪�E�R���e�i)���擾���܂��B
   * @return (�\���敪�E�R���e�i)
   */
  public ACLabelContainer getKaigoInfoRequestDivisionContena(){
    if(kaigoInfoRequestDivisionContena==null){

      kaigoInfoRequestDivisionContena = new ACLabelContainer();

      kaigoInfoRequestDivisionContena.setText("�\���敪");

      addKaigoInfoRequestDivisionContena();
    }
    return kaigoInfoRequestDivisionContena;

  }

  /**
   * �\���敪�E���W�I�O���[�v���擾���܂��B
   * @return �\���敪�E���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getKaigoInfoRequestDivisionRadio(){
    if(kaigoInfoRequestDivisionRadio==null){

      kaigoInfoRequestDivisionRadio = new ACClearableRadioButtonGroup();

      kaigoInfoRequestDivisionRadio.setBindPath("SHUBETSU_CODE");

      kaigoInfoRequestDivisionRadio.setUseClearButton(false);

      kaigoInfoRequestDivisionRadio.setModel(getKaigoInfoRequestDivisionRadioModel());

      addKaigoInfoRequestDivisionRadio();
    }
    return kaigoInfoRequestDivisionRadio;

  }

  /**
   * �\���敪�E���W�I�O���[�v���f�����擾���܂��B
   * @return �\���敪�E���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getKaigoInfoRequestDivisionRadioModel(){
    if(kaigoInfoRequestDivisionRadioModel==null){
      kaigoInfoRequestDivisionRadioModel = new ACListModelAdapter();
      addKaigoInfoRequestDivisionRadioModel();
    }
    return kaigoInfoRequestDivisionRadioModel;
  }

  /**
   * ���ԏI����V�K���擾���܂��B
   * @return ���ԏI����V�K
   */
  public ACRadioButtonItem getKaigoInfoRequestDivisionRadioItem1(){
    if(kaigoInfoRequestDivisionRadioItem1==null){

      kaigoInfoRequestDivisionRadioItem1 = new ACRadioButtonItem();

      kaigoInfoRequestDivisionRadioItem1.setText("�V�K�E���ԏI����V�K");

      kaigoInfoRequestDivisionRadioItem1.setGroup(getKaigoInfoRequestDivisionRadio());

      kaigoInfoRequestDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoInfoRequestDivisionRadioItem1();
    }
    return kaigoInfoRequestDivisionRadioItem1;

  }

  /**
   * �X�V���擾���܂��B
   * @return �X�V
   */
  public ACRadioButtonItem getKaigoInfoRequestDivisionRadioItem2(){
    if(kaigoInfoRequestDivisionRadioItem2==null){

      kaigoInfoRequestDivisionRadioItem2 = new ACRadioButtonItem();

      kaigoInfoRequestDivisionRadioItem2.setText("�X�V");

      kaigoInfoRequestDivisionRadioItem2.setGroup(getKaigoInfoRequestDivisionRadio());

      kaigoInfoRequestDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoInfoRequestDivisionRadioItem2();
    }
    return kaigoInfoRequestDivisionRadioItem2;

  }

  /**
   * �ύX���擾���܂��B
   * @return �ύX
   */
  public ACRadioButtonItem getKaigoInfoRequestDivisionRadioItem3(){
    if(kaigoInfoRequestDivisionRadioItem3==null){

      kaigoInfoRequestDivisionRadioItem3 = new ACRadioButtonItem();

      kaigoInfoRequestDivisionRadioItem3.setText("�ύX");

      kaigoInfoRequestDivisionRadioItem3.setGroup(getKaigoInfoRequestDivisionRadio());

      kaigoInfoRequestDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoInfoRequestDivisionRadioItem3();
    }
    return kaigoInfoRequestDivisionRadioItem3;

  }

  /**
   * �\�������擾���܂��B
   * @return �\����
   */
  public ACIntegerCheckBox getKaigoInfoRequests(){
    if(kaigoInfoRequests==null){

      kaigoInfoRequests = new ACIntegerCheckBox();

      kaigoInfoRequests.setText("�\����");

      kaigoInfoRequests.setBindPath("CHANGE_CODE");

      addKaigoInfoRequests();
    }
    return kaigoInfoRequests;

  }

  /**
   * �v�������擾���܂��B
   * @return �v�����
   */
  public ACComboBox getKaigoInfoYokaigoInfo(){
    if(kaigoInfoYokaigoInfo==null){

      kaigoInfoYokaigoInfo = new ACComboBox();

      getKaigoInfoYokaigoInfoContainer().setText("�v���x");

      kaigoInfoYokaigoInfo.setBindPath("JOTAI_CODE");

      kaigoInfoYokaigoInfo.setEditable(false);

      kaigoInfoYokaigoInfo.setColumns(6);

      kaigoInfoYokaigoInfo.setModelBindPath("JOTAI_CODE");

      kaigoInfoYokaigoInfo.setRenderBindPath("CONTENT");

      kaigoInfoYokaigoInfo.setModel(getKaigoInfoYokaigoInfoModel());

      addKaigoInfoYokaigoInfo();
    }
    return kaigoInfoYokaigoInfo;

  }

  /**
   * �v�����R���e�i���擾���܂��B
   * @return �v�����R���e�i
   */
  protected ACLabelContainer getKaigoInfoYokaigoInfoContainer(){
    if(kaigoInfoYokaigoInfoContainer==null){
      kaigoInfoYokaigoInfoContainer = new ACLabelContainer();
      kaigoInfoYokaigoInfoContainer.setFollowChildEnabled(true);
      kaigoInfoYokaigoInfoContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoYokaigoInfoContainer.add(getKaigoInfoYokaigoInfo(), null);
    }
    return kaigoInfoYokaigoInfoContainer;
  }

  /**
   * �v����񃂃f�����擾���܂��B
   * @return �v����񃂃f��
   */
  protected ACComboBoxModelAdapter getKaigoInfoYokaigoInfoModel(){
    if(kaigoInfoYokaigoInfoModel==null){
      kaigoInfoYokaigoInfoModel = new ACComboBoxModelAdapter();
      addKaigoInfoYokaigoInfoModel();
    }
    return kaigoInfoYokaigoInfoModel;
  }

  /**
   * (�L�����ԁE�R���e�i)���擾���܂��B
   * @return (�L�����ԁE�R���e�i)
   */
  public ACLabelContainer getKaigoInfoValidLimits(){
    if(kaigoInfoValidLimits==null){

      kaigoInfoValidLimits = new ACLabelContainer();

      kaigoInfoValidLimits.setText("�L������");

      addKaigoInfoValidLimits();
    }
    return kaigoInfoValidLimits;

  }

  /**
   * �L�����ԁE�e�L�X�g1���擾���܂��B
   * @return �L�����ԁE�e�L�X�g1
   */
  public QkanDateTextField getKaigoInfoValidLimit1(){
    if(kaigoInfoValidLimit1==null){

      kaigoInfoValidLimit1 = new QkanDateTextField();

      kaigoInfoValidLimit1.setBindPath("INSURE_VALID_START");

      addKaigoInfoValidLimit1();
    }
    return kaigoInfoValidLimit1;

  }

  /**
   * �L�����ԁE���x�����擾���܂��B
   * @return �L�����ԁE���x��
   */
  public ACLabel getKaigoInfoValidLimit2(){
    if(kaigoInfoValidLimit2==null){

      kaigoInfoValidLimit2 = new ACLabel();

      kaigoInfoValidLimit2.setText(" ���� ");

      addKaigoInfoValidLimit2();
    }
    return kaigoInfoValidLimit2;

  }

  /**
   * �L�����ԁE�e�L�X�g2���擾���܂��B
   * @return �L�����ԁE�e�L�X�g2
   */
  public QkanDateTextField getKaigoInfoValidLimit3(){
    if(kaigoInfoValidLimit3==null){

      kaigoInfoValidLimit3 = new QkanDateTextField();

      kaigoInfoValidLimit3.setBindPath("INSURE_VALID_END");

      addKaigoInfoValidLimit3();
    }
    return kaigoInfoValidLimit3;

  }

  /**
   * �\�������擾���܂��B
   * @return �\����
   */
  public QkanDateTextField getKaigoInfoRequestDate(){
    if(kaigoInfoRequestDate==null){

      kaigoInfoRequestDate = new QkanDateTextField();

      getKaigoInfoRequestDateContainer().setText("�\����");

      kaigoInfoRequestDate.setBindPath("SHINSEI_DATE");

      addKaigoInfoRequestDate();
    }
    return kaigoInfoRequestDate;

  }

  /**
   * �\�����R���e�i���擾���܂��B
   * @return �\�����R���e�i
   */
  protected ACLabelContainer getKaigoInfoRequestDateContainer(){
    if(kaigoInfoRequestDateContainer==null){
      kaigoInfoRequestDateContainer = new ACLabelContainer();
      kaigoInfoRequestDateContainer.setFollowChildEnabled(true);
      kaigoInfoRequestDateContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoRequestDateContainer.add(getKaigoInfoRequestDate(), null);
    }
    return kaigoInfoRequestDateContainer;
  }

  /**
   * �F������擾���܂��B
   * @return �F���
   */
  public QkanDateTextField getKaigoInfoAuthorizeDate(){
    if(kaigoInfoAuthorizeDate==null){

      kaigoInfoAuthorizeDate = new QkanDateTextField();

      getKaigoInfoAuthorizeDateContainer().setText("�F���");

      kaigoInfoAuthorizeDate.setBindPath("NINTEI_DATE");

      addKaigoInfoAuthorizeDate();
    }
    return kaigoInfoAuthorizeDate;

  }

  /**
   * �F����R���e�i���擾���܂��B
   * @return �F����R���e�i
   */
  protected ACLabelContainer getKaigoInfoAuthorizeDateContainer(){
    if(kaigoInfoAuthorizeDateContainer==null){
      kaigoInfoAuthorizeDateContainer = new ACLabelContainer();
      kaigoInfoAuthorizeDateContainer.setFollowChildEnabled(true);
      kaigoInfoAuthorizeDateContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoAuthorizeDateContainer.add(getKaigoInfoAuthorizeDate(), null);
    }
    return kaigoInfoAuthorizeDateContainer;
  }

  /**
   * (�x�����x�z�O���[�v)���擾���܂��B
   * @return (�x�����x�z�O���[�v)
   */
  public ACGroupBox getKaigoInfoProvideLimitGroup(){
    if(kaigoInfoProvideLimitGroup==null){

      kaigoInfoProvideLimitGroup = new ACGroupBox();

      kaigoInfoProvideLimitGroup.setText("�x�����x�z�E�O�����p�^���t����P�ʐ�");

      kaigoInfoProvideLimitGroup.setHgap(0);

      addKaigoInfoProvideLimitGroup();
    }
    return kaigoInfoProvideLimitGroup;

  }

  /**
   * (�x�����x�z�E�R���e�i)���擾���܂��B
   * @return (�x�����x�z�E�R���e�i)
   */
  public ACLabelContainer getKaigoInfoProvideLimitContena(){
    if(kaigoInfoProvideLimitContena==null){

      kaigoInfoProvideLimitContena = new ACLabelContainer();

      kaigoInfoProvideLimitContena.setText("�x�����x�z");

      addKaigoInfoProvideLimitContena();
    }
    return kaigoInfoProvideLimitContena;

  }

  /**
   * �x�����x�z���擾���܂��B
   * @return �x�����x�z
   */
  public ACTextField getKaigoInfoProvideLimit(){
    if(kaigoInfoProvideLimit==null){

      kaigoInfoProvideLimit = new ACTextField();

      kaigoInfoProvideLimit.setBindPath("LIMIT_RATE");

      kaigoInfoProvideLimit.setEditable(false);

      kaigoInfoProvideLimit.setColumns(5);

      kaigoInfoProvideLimit.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoProvideLimit.setMaxLength(5);

      addKaigoInfoProvideLimit();
    }
    return kaigoInfoProvideLimit;

  }

  /**
   * �P�ʃ��x�����擾���܂��B
   * @return �P�ʃ��x��
   */
  public ACLabel getKaigoInfoProvideLimitLabel(){
    if(kaigoInfoProvideLimitLabel==null){

      kaigoInfoProvideLimitLabel = new ACLabel();

      kaigoInfoProvideLimitLabel.setText(" �P��");

      addKaigoInfoProvideLimitLabel();
    }
    return kaigoInfoProvideLimitLabel;

  }

  /**
   * (�O�����p�^���t����P�ʐ��E�R���e�i)���擾���܂��B
   * @return (�O�����p�^���t����P�ʐ��E�R���e�i)
   */
  public ACLabelContainer getKaigoInfoExternalUseLimitContena(){
    if(kaigoInfoExternalUseLimitContena==null){

      kaigoInfoExternalUseLimitContena = new ACLabelContainer();

      kaigoInfoExternalUseLimitContena.setText("�O�����p�^���t����P�ʐ�");

      addKaigoInfoExternalUseLimitContena();
    }
    return kaigoInfoExternalUseLimitContena;

  }

  /**
   * �O�����p�^���t����P�ʐ����擾���܂��B
   * @return �O�����p�^���t����P�ʐ�
   */
  public ACTextField getKaigoInfoExternalUseLimit(){
    if(kaigoInfoExternalUseLimit==null){

      kaigoInfoExternalUseLimit = new ACTextField();

      kaigoInfoExternalUseLimit.setBindPath("EXTERNAL_USE_LIMIT");

      kaigoInfoExternalUseLimit.setEditable(false);

      kaigoInfoExternalUseLimit.setColumns(5);

      kaigoInfoExternalUseLimit.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoExternalUseLimit.setMaxLength(5);

      addKaigoInfoExternalUseLimit();
    }
    return kaigoInfoExternalUseLimit;

  }

  /**
   * �P�ʃ��x�����擾���܂��B
   * @return �P�ʃ��x��
   */
  public ACLabel getKaigoInfoExternalUseLimitLabel(){
    if(kaigoInfoExternalUseLimitLabel==null){

      kaigoInfoExternalUseLimitLabel = new ACLabel();

      kaigoInfoExternalUseLimitLabel.setText(" �P��");

      addKaigoInfoExternalUseLimitLabel();
    }
    return kaigoInfoExternalUseLimitLabel;

  }

  /**
   * (���f���E���f���R�O���[�v)���擾���܂��B
   * @return (���f���E���f���R�O���[�v)
   */
  public ACGroupBox getKaigoInfoInterruptionGroup(){
    if(kaigoInfoInterruptionGroup==null){

      kaigoInfoInterruptionGroup = new ACGroupBox();

      kaigoInfoInterruptionGroup.setText("���f���E���f���R");

      kaigoInfoInterruptionGroup.setAutoWrap(false);

      kaigoInfoInterruptionGroup.setHgap(0);

      addKaigoInfoInterruptionGroup();
    }
    return kaigoInfoInterruptionGroup;

  }

  /**
   * ���f�����擾���܂��B
   * @return ���f��
   */
  public QkanDateTextField getKaigoInfoInterruptionDate(){
    if(kaigoInfoInterruptionDate==null){

      kaigoInfoInterruptionDate = new QkanDateTextField();

      getKaigoInfoInterruptionDateContainer().setText("���f��");

      kaigoInfoInterruptionDate.setBindPath("STOP_DATE");

      addKaigoInfoInterruptionDate();
    }
    return kaigoInfoInterruptionDate;

  }

  /**
   * ���f���R���e�i���擾���܂��B
   * @return ���f���R���e�i
   */
  protected ACLabelContainer getKaigoInfoInterruptionDateContainer(){
    if(kaigoInfoInterruptionDateContainer==null){
      kaigoInfoInterruptionDateContainer = new ACLabelContainer();
      kaigoInfoInterruptionDateContainer.setFollowChildEnabled(true);
      kaigoInfoInterruptionDateContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoInterruptionDateContainer.add(getKaigoInfoInterruptionDate(), null);
    }
    return kaigoInfoInterruptionDateContainer;
  }

  /**
   * ���f���R���擾���܂��B
   * @return ���f���R
   */
  public ACClearableRadioButtonGroup getKaigoInfoInterruptionReasonRadio(){
    if(kaigoInfoInterruptionReasonRadio==null){

      kaigoInfoInterruptionReasonRadio = new ACClearableRadioButtonGroup();

      getKaigoInfoInterruptionReasonRadioContainer().setText("���f���R");

      kaigoInfoInterruptionReasonRadio.setBindPath("STOP_REASON");

      kaigoInfoInterruptionReasonRadio.setUseClearButton(true);

      kaigoInfoInterruptionReasonRadio.setModel(getKaigoInfoInterruptionReasonRadioModel());

      addKaigoInfoInterruptionReasonRadio();
    }
    return kaigoInfoInterruptionReasonRadio;

  }

  /**
   * ���f���R�R���e�i���擾���܂��B
   * @return ���f���R�R���e�i
   */
  protected ACLabelContainer getKaigoInfoInterruptionReasonRadioContainer(){
    if(kaigoInfoInterruptionReasonRadioContainer==null){
      kaigoInfoInterruptionReasonRadioContainer = new ACLabelContainer();
      kaigoInfoInterruptionReasonRadioContainer.setFollowChildEnabled(true);
      kaigoInfoInterruptionReasonRadioContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoInterruptionReasonRadioContainer.add(getKaigoInfoInterruptionReasonRadio(), null);
    }
    return kaigoInfoInterruptionReasonRadioContainer;
  }

  /**
   * ���f���R���f�����擾���܂��B
   * @return ���f���R���f��
   */
  protected ACListModelAdapter getKaigoInfoInterruptionReasonRadioModel(){
    if(kaigoInfoInterruptionReasonRadioModel==null){
      kaigoInfoInterruptionReasonRadioModel = new ACListModelAdapter();
      addKaigoInfoInterruptionReasonRadioModel();
    }
    return kaigoInfoInterruptionReasonRadioModel;
  }

  /**
   * ��X�V���擾���܂��B
   * @return ��X�V
   */
  public ACRadioButtonItem getKaigoInfoInterruptionReasonRadioItem1(){
    if(kaigoInfoInterruptionReasonRadioItem1==null){

      kaigoInfoInterruptionReasonRadioItem1 = new ACRadioButtonItem();

      kaigoInfoInterruptionReasonRadioItem1.setText("��X�V");

      kaigoInfoInterruptionReasonRadioItem1.setGroup(getKaigoInfoInterruptionReasonRadio());

      kaigoInfoInterruptionReasonRadioItem1.setConstraints(VRLayout.FLOW);

      addKaigoInfoInterruptionReasonRadioItem1();
    }
    return kaigoInfoInterruptionReasonRadioItem1;

  }

  /**
   * ��Y�����擾���܂��B
   * @return ��Y��
   */
  public ACRadioButtonItem getKaigoInfoInterruptionReasonRadioItem2(){
    if(kaigoInfoInterruptionReasonRadioItem2==null){

      kaigoInfoInterruptionReasonRadioItem2 = new ACRadioButtonItem();

      kaigoInfoInterruptionReasonRadioItem2.setText("��Y��");

      kaigoInfoInterruptionReasonRadioItem2.setGroup(getKaigoInfoInterruptionReasonRadio());

      kaigoInfoInterruptionReasonRadioItem2.setConstraints(VRLayout.FLOW);

      addKaigoInfoInterruptionReasonRadioItem2();
    }
    return kaigoInfoInterruptionReasonRadioItem2;

  }

  /**
   * ���S���擾���܂��B
   * @return ���S
   */
  public ACRadioButtonItem getKaigoInfoInterruptionReasonRadioItem3(){
    if(kaigoInfoInterruptionReasonRadioItem3==null){

      kaigoInfoInterruptionReasonRadioItem3 = new ACRadioButtonItem();

      kaigoInfoInterruptionReasonRadioItem3.setText("���S");

      kaigoInfoInterruptionReasonRadioItem3.setGroup(getKaigoInfoInterruptionReasonRadio());

      kaigoInfoInterruptionReasonRadioItem3.setConstraints(VRLayout.FLOW);

      addKaigoInfoInterruptionReasonRadioItem3();
    }
    return kaigoInfoInterruptionReasonRadioItem3;

  }

  /**
   * ���������x��1���擾���܂��B
   * @return ���������x��1
   */
  public ACLabel getKaigoInfoExplanationLabel1(){
    if(kaigoInfoExplanationLabel1==null){

      kaigoInfoExplanationLabel1 = new ACLabel();

      kaigoInfoExplanationLabel1.setText("�����̔F��ɒ��f���E���f���R��ݒ肷��ꍇ�́A�ǉ��{�^���ł͂Ȃ����������{�^���������Ă��������B");

      kaigoInfoExplanationLabel1.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addKaigoInfoExplanationLabel1();
    }
    return kaigoInfoExplanationLabel1;

  }

  /**
   * (���ی����E�{�^���̈�)���擾���܂��B
   * @return (���ی����E�{�^���̈�)
   */
  public ACPanel getKaigoInfoButtons(){
    if(kaigoInfoButtons==null){

      kaigoInfoButtons = new ACPanel();

      addKaigoInfoButtons();
    }
    return kaigoInfoButtons;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACButton getKaigoInfoButtonClear(){
    if(kaigoInfoButtonClear==null){

      kaigoInfoButtonClear = new ACButton();

      kaigoInfoButtonClear.setText("�N���A");

      kaigoInfoButtonClear.setToolTipText("���ی������N���A���܂��B");

      kaigoInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addKaigoInfoButtonClear();
    }
    return kaigoInfoButtonClear;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getKaigoInfoButtonInsert(){
    if(kaigoInfoButtonInsert==null){

      kaigoInfoButtonInsert = new ACButton();

      kaigoInfoButtonInsert.setText("�ǉ�");

      kaigoInfoButtonInsert.setToolTipText("���ی�����ǉ����܂��B");

      kaigoInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addKaigoInfoButtonInsert();
    }
    return kaigoInfoButtonInsert;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getKaigoInfoButtonEdit(){
    if(kaigoInfoButtonEdit==null){

      kaigoInfoButtonEdit = new ACButton();

      kaigoInfoButtonEdit.setText("����");

      kaigoInfoButtonEdit.setToolTipText("���ی��������������܂��B");

      kaigoInfoButtonEdit.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addKaigoInfoButtonEdit();
    }
    return kaigoInfoButtonEdit;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getKaigoInfoDelete(){
    if(kaigoInfoDelete==null){

      kaigoInfoDelete = new ACButton();

      kaigoInfoDelete.setText("�폜");

      kaigoInfoDelete.setToolTipText("���ی������폜���܂��B");

      kaigoInfoDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addKaigoInfoDelete();
    }
    return kaigoInfoDelete;

  }

  /**
   * (�����E�e�[�u���̈�)���擾���܂��B
   * @return (�����E�e�[�u���̈�)
   */
  public ACTable getKaigoInfoTable(){
    if(kaigoInfoTable==null){

      kaigoInfoTable = new ACTable();

      kaigoInfoTable.setColumnModel(getKaigoInfoTableColumnModel());

      addKaigoInfoTable();
    }
    return kaigoInfoTable;

  }

  /**
   * (�����E�e�[�u���̈�)�J�������f�����擾���܂��B
   * @return (�����E�e�[�u���̈�)�J�������f��
   */
  protected VRTableColumnModel getKaigoInfoTableColumnModel(){
    if(kaigoInfoTableColumnModel==null){
      kaigoInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKaigoInfoTableColumnModel();
    }
    return kaigoInfoTableColumnModel;
  }

  /**
   * No���擾���܂��B
   * @return No
   */
  public ACTableColumn getKaigoInfoTableColumn0(){
    if(kaigoInfoTableColumn0==null){

      kaigoInfoTableColumn0 = new ACTableColumn(0);

      kaigoInfoTableColumn0.setHeaderValue("No.");

      kaigoInfoTableColumn0.setColumns(3);

      kaigoInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      kaigoInfoTableColumn0.setSortable(false);

      addKaigoInfoTableColumn0();
    }
    return kaigoInfoTableColumn0;

  }

  /**
   * �\�������擾���܂��B
   * @return �\����
   */
  public ACTableColumn getKaigoInfoTableColumn1(){
    if(kaigoInfoTableColumn1==null){

      kaigoInfoTableColumn1 = new ACTableColumn(0);

      kaigoInfoTableColumn1.setHeaderValue("�\����");

      kaigoInfoTableColumn1.setColumns(10);

      kaigoInfoTableColumn1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn1();
    }
    return kaigoInfoTableColumn1;

  }

  /**
   * �\���敪���擾���܂��B
   * @return �\���敪
   */
  public ACTableColumn getKaigoInfoTableColumn2(){
    if(kaigoInfoTableColumn2==null){

      kaigoInfoTableColumn2 = new ACTableColumn(1);

      kaigoInfoTableColumn2.setHeaderValue("�\���敪");

      kaigoInfoTableColumn2.setColumns(10);

      addKaigoInfoTableColumn2();
    }
    return kaigoInfoTableColumn2;

  }

  /**
   * �v�������擾���܂��B
   * @return �v�����
   */
  public ACTableColumn getKaigoInfoTableColumn3(){
    if(kaigoInfoTableColumn3==null){

      kaigoInfoTableColumn3 = new ACTableColumn(2);

      kaigoInfoTableColumn3.setHeaderValue("�v���x");

      kaigoInfoTableColumn3.setColumns(7);

      addKaigoInfoTableColumn3();
    }
    return kaigoInfoTableColumn3;

  }

  /**
   * �L�����ԊJ�n�����擾���܂��B
   * @return �L�����ԊJ�n��
   */
  public ACTableColumn getKaigoInfoTableColumn4(){
    if(kaigoInfoTableColumn4==null){

      kaigoInfoTableColumn4 = new ACTableColumn(3);

      kaigoInfoTableColumn4.setHeaderValue("�L�����ԊJ�n��");

      kaigoInfoTableColumn4.setColumns(10);

      kaigoInfoTableColumn4.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn4();
    }
    return kaigoInfoTableColumn4;

  }

  /**
   * �L�����ԏI�������擾���܂��B
   * @return �L�����ԏI����
   */
  public ACTableColumn getKaigoInfoTableColumn5(){
    if(kaigoInfoTableColumn5==null){

      kaigoInfoTableColumn5 = new ACTableColumn(4);

      kaigoInfoTableColumn5.setHeaderValue("�L�����ԏI����");

      kaigoInfoTableColumn5.setColumns(10);

      kaigoInfoTableColumn5.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn5();
    }
    return kaigoInfoTableColumn5;

  }

  /**
   * �쐬�˗��͏o�����擾���܂��B
   * @return �쐬�˗��͏o��
   */
  public ACTableColumn getKaigoInfoTableColumn6(){
    if(kaigoInfoTableColumn6==null){

      kaigoInfoTableColumn6 = new ACTableColumn(5);

      kaigoInfoTableColumn6.setHeaderValue("�쐬�˗��͏o��");

      kaigoInfoTableColumn6.setColumns(10);

      kaigoInfoTableColumn6.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn6();
    }
    return kaigoInfoTableColumn6;

  }

  /**
   * ���f�N�������擾���܂��B
   * @return ���f�N����
   */
  public ACTableColumn getKaigoInfoTableColumn7(){
    if(kaigoInfoTableColumn7==null){

      kaigoInfoTableColumn7 = new ACTableColumn(6);

      kaigoInfoTableColumn7.setHeaderValue("���f�N����");

      kaigoInfoTableColumn7.setColumns(10);

      kaigoInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn7();
    }
    return kaigoInfoTableColumn7;

  }

  /**
   * ���f���R���擾���܂��B
   * @return ���f���R
   */
  public ACTableColumn getKaigoInfoTableColumn8(){
    if(kaigoInfoTableColumn8==null){

      kaigoInfoTableColumn8 = new ACTableColumn(7);

      kaigoInfoTableColumn8.setHeaderValue("���f���R");

      kaigoInfoTableColumn8.setColumns(6);

      addKaigoInfoTableColumn8();
    }
    return kaigoInfoTableColumn8;

  }

  /**
   * �x�����x�z���擾���܂��B
   * @return �x�����x�z
   */
  public ACTableColumn getKaigoInfoTableColumn9(){
    if(kaigoInfoTableColumn9==null){

      kaigoInfoTableColumn9 = new ACTableColumn(8);

      kaigoInfoTableColumn9.setHeaderValue("�x�����x�z");

      kaigoInfoTableColumn9.setColumns(7);

      kaigoInfoTableColumn9.setHorizontalAlignment(SwingConstants.RIGHT);

      addKaigoInfoTableColumn9();
    }
    return kaigoInfoTableColumn9;

  }

  /**
   * (�ٓ��E�{�ݏ��E�p�l��)���擾���܂��B
   * @return (�ٓ��E�{�ݏ��E�p�l��)
   */
  public ACPanel getIdouInfoAndInstitutionInfoPanel(){
    if(idouInfoAndInstitutionInfoPanel==null){

      idouInfoAndInstitutionInfoPanel = new ACPanel();

      addIdouInfoAndInstitutionInfoPanel();
    }
    return idouInfoAndInstitutionInfoPanel;

  }

  /**
   * (�ٓ����̈�E�O���[�v)���擾���܂��B
   * @return (�ٓ����̈�E�O���[�v)
   */
  public ACGroupBox getIdouInfoAndInstitutionInfos(){
    if(idouInfoAndInstitutionInfos==null){

      idouInfoAndInstitutionInfos = new ACGroupBox();

      idouInfoAndInstitutionInfos.setText("�ٓ����");

      idouInfoAndInstitutionInfos.setLayout(getIdouInfoAndInstitutionInfoLayout());

      addIdouInfoAndInstitutionInfos();
    }
    return idouInfoAndInstitutionInfos;

  }

  /**
   * (�ٓ��E�{�ݏ��̈�E���C�A�E�g)���擾���܂��B
   * @return (�ٓ��E�{�ݏ��̈�E���C�A�E�g)
   */
  public VRLayout getIdouInfoAndInstitutionInfoLayout(){
    if(idouInfoAndInstitutionInfoLayout==null){

      idouInfoAndInstitutionInfoLayout = new VRLayout();

      idouInfoAndInstitutionInfoLayout.setAutoWrap(false);

      addIdouInfoAndInstitutionInfoLayout();
    }
    return idouInfoAndInstitutionInfoLayout;

  }

  /**
   * (�ٓ����̈�E��)���擾���܂��B
   * @return (�ٓ����̈�E��)
   */
  public ACPanel getIdouInfoUp(){
    if(idouInfoUp==null){

      idouInfoUp = new ACPanel();

      addIdouInfoUp();
    }
    return idouInfoUp;

  }

  /**
   * (�ٓ����̈�)���擾���܂��B
   * @return (�ٓ����̈�)
   */
  public ACPanel getIdouInfo(){
    if(idouInfo==null){

      idouInfo = new ACPanel();

      idouInfo.setLayout(getIdouInfoLayout2());

      addIdouInfo();
    }
    return idouInfo;

  }

  /**
   * (�ٓ����̈�E���C�A�E�g)���擾���܂��B
   * @return (�ٓ����̈�E���C�A�E�g)
   */
  public VRLayout getIdouInfoLayout2(){
    if(idouInfoLayout2==null){

      idouInfoLayout2 = new VRLayout();

      idouInfoLayout2.setAutoWrap(false);

      addIdouInfoLayout2();
    }
    return idouInfoLayout2;

  }

  /**
   * �T�[�r�X���擾���܂��B
   * @return �T�[�r�X
   */
  public ACComboBox getIdouInfoServise(){
    if(idouInfoServise==null){

      idouInfoServise = new ACComboBox();

      getIdouInfoServiseContainer().setText("�T�[�r�X");

      idouInfoServise.setBindPath("SYSTEM_SERVICE_KIND_DETAIL");

      idouInfoServise.setEditable(false);

      idouInfoServise.setColumns(10);

      idouInfoServise.setModelBindPath("SERVICE");

      idouInfoServise.setRenderBindPath("SERVICE_ABBREVIATION");

      idouInfoServise.setModel(getIdouInfoServiseModel());

      addIdouInfoServise();
    }
    return idouInfoServise;

  }

  /**
   * �T�[�r�X�R���e�i���擾���܂��B
   * @return �T�[�r�X�R���e�i
   */
  protected ACLabelContainer getIdouInfoServiseContainer(){
    if(idouInfoServiseContainer==null){
      idouInfoServiseContainer = new ACLabelContainer();
      idouInfoServiseContainer.setFollowChildEnabled(true);
      idouInfoServiseContainer.setVAlignment(VRLayout.CENTER);
      idouInfoServiseContainer.add(getIdouInfoServise(), null);
    }
    return idouInfoServiseContainer;
  }

  /**
   * �T�[�r�X���f�����擾���܂��B
   * @return �T�[�r�X���f��
   */
  protected ACComboBoxModelAdapter getIdouInfoServiseModel(){
    if(idouInfoServiseModel==null){
      idouInfoServiseModel = new ACComboBoxModelAdapter();
      addIdouInfoServiseModel();
    }
    return idouInfoServiseModel;
  }

  /**
   * �ٓ����R���擾���܂��B
   * @return �ٓ����R
   */
  public ACComboBox getIdouInfoChangeContent(){
    if(idouInfoChangeContent==null){

      idouInfoChangeContent = new ACComboBox();

      getIdouInfoChangeContentContainer().setText("�ٓ����R");

      idouInfoChangeContent.setBindPath("CHANGES_CONTENT");

      idouInfoChangeContent.setEditable(false);

      idouInfoChangeContent.setColumns(5);

      idouInfoChangeContent.setModelBindPath("CHANGES_CONTENT");

      idouInfoChangeContent.setRenderBindPath("CONTENT");

      idouInfoChangeContent.setModel(getIdouInfoChangeContentModel());

      addIdouInfoChangeContent();
    }
    return idouInfoChangeContent;

  }

  /**
   * �ٓ����R�R���e�i���擾���܂��B
   * @return �ٓ����R�R���e�i
   */
  protected ACLabelContainer getIdouInfoChangeContentContainer(){
    if(idouInfoChangeContentContainer==null){
      idouInfoChangeContentContainer = new ACLabelContainer();
      idouInfoChangeContentContainer.setFollowChildEnabled(true);
      idouInfoChangeContentContainer.setVAlignment(VRLayout.CENTER);
      idouInfoChangeContentContainer.add(getIdouInfoChangeContent(), null);
    }
    return idouInfoChangeContentContainer;
  }

  /**
   * �ٓ����R���f�����擾���܂��B
   * @return �ٓ����R���f��
   */
  protected ACComboBoxModelAdapter getIdouInfoChangeContentModel(){
    if(idouInfoChangeContentModel==null){
      idouInfoChangeContentModel = new ACComboBoxModelAdapter();
      addIdouInfoChangeContentModel();
    }
    return idouInfoChangeContentModel;
  }

  /**
   * ���t���擾���܂��B
   * @return ���t
   */
  public QkanDateTextField getIdouInfoDate(){
    if(idouInfoDate==null){

      idouInfoDate = new QkanDateTextField();

      getIdouInfoDateContainer().setText("���t");

      idouInfoDate.setBindPath("CHANGES_DATE");

      addIdouInfoDate();
    }
    return idouInfoDate;

  }

  /**
   * ���t�R���e�i���擾���܂��B
   * @return ���t�R���e�i
   */
  protected ACLabelContainer getIdouInfoDateContainer(){
    if(idouInfoDateContainer==null){
      idouInfoDateContainer = new ACLabelContainer();
      idouInfoDateContainer.setFollowChildEnabled(true);
      idouInfoDateContainer.setVAlignment(VRLayout.CENTER);
      idouInfoDateContainer.add(getIdouInfoDate(), null);
    }
    return idouInfoDateContainer;
  }

  /**
   * ���Ԃ��擾���܂��B
   * @return ����
   */
  public ACTimeTextField getIdouInfoTime(){
    if(idouInfoTime==null){

      idouInfoTime = new ACTimeTextField();

      getIdouInfoTimeContainer().setText("����");

      idouInfoTime.setBindPath("CHANGES_TIME");

      addIdouInfoTime();
    }
    return idouInfoTime;

  }

  /**
   * ���ԃR���e�i���擾���܂��B
   * @return ���ԃR���e�i
   */
  protected ACLabelContainer getIdouInfoTimeContainer(){
    if(idouInfoTimeContainer==null){
      idouInfoTimeContainer = new ACLabelContainer();
      idouInfoTimeContainer.setFollowChildEnabled(true);
      idouInfoTimeContainer.setVAlignment(VRLayout.CENTER);
      idouInfoTimeContainer.add(getIdouInfoTime(), null);
    }
    return idouInfoTimeContainer;
  }

  /**
   * ���R/�󋵂��擾���܂��B
   * @return ���R/��
   */
  public ACComboBox getIdouInfoReason(){
    if(idouInfoReason==null){

      idouInfoReason = new ACComboBox();

      getIdouInfoReasonContainer().setText("���R/��");

      idouInfoReason.setBindPath("CHANGES_REASON");

      idouInfoReason.setEditable(false);

      idouInfoReason.setColumns(5);

      idouInfoReason.setModelBindPath("CHANGES_REASON");

      idouInfoReason.setRenderBindPath("CONTENT");

      idouInfoReason.setBlankable(true);

      idouInfoReason.setModel(getIdouInfoReasonModel());

      addIdouInfoReason();
    }
    return idouInfoReason;

  }

  /**
   * ���R/�󋵃R���e�i���擾���܂��B
   * @return ���R/�󋵃R���e�i
   */
  protected ACLabelContainer getIdouInfoReasonContainer(){
    if(idouInfoReasonContainer==null){
      idouInfoReasonContainer = new ACLabelContainer();
      idouInfoReasonContainer.setFollowChildEnabled(true);
      idouInfoReasonContainer.setVAlignment(VRLayout.CENTER);
      idouInfoReasonContainer.add(getIdouInfoReason(), null);
    }
    return idouInfoReasonContainer;
  }

  /**
   * ���R/�󋵃��f�����擾���܂��B
   * @return ���R/�󋵃��f��
   */
  protected ACComboBoxModelAdapter getIdouInfoReasonModel(){
    if(idouInfoReasonModel==null){
      idouInfoReasonModel = new ACComboBoxModelAdapter();
      addIdouInfoReasonModel();
    }
    return idouInfoReasonModel;
  }

  /**
   * ���̑��@���e���擾���܂��B
   * @return ���̑��@���e
   */
  public ACTextField getIdouInfoReasonMemo(){
    if(idouInfoReasonMemo==null){

      idouInfoReasonMemo = new ACTextField();

      getIdouInfoReasonMemoContainer().setText("���e");

      idouInfoReasonMemo.setBindPath("REASON_MEMO");

      idouInfoReasonMemo.setColumns(30);

      idouInfoReasonMemo.setIMEMode(InputSubset.KANJI);

      idouInfoReasonMemo.setMaxLength(50);

      addIdouInfoReasonMemo();
    }
    return idouInfoReasonMemo;

  }

  /**
   * ���̑��@���e�R���e�i���擾���܂��B
   * @return ���̑��@���e�R���e�i
   */
  protected ACLabelContainer getIdouInfoReasonMemoContainer(){
    if(idouInfoReasonMemoContainer==null){
      idouInfoReasonMemoContainer = new ACLabelContainer();
      idouInfoReasonMemoContainer.setFollowChildEnabled(true);
      idouInfoReasonMemoContainer.setVAlignment(VRLayout.CENTER);
      idouInfoReasonMemoContainer.add(getIdouInfoReasonMemo(), null);
    }
    return idouInfoReasonMemoContainer;
  }

  /**
   * (�ٓ����E�{�^���̈�)���擾���܂��B
   * @return (�ٓ����E�{�^���̈�)
   */
  public ACPanel getIdouInfoButtons(){
    if(idouInfoButtons==null){

      idouInfoButtons = new ACPanel();

      addIdouInfoButtons();
    }
    return idouInfoButtons;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACButton getIdouInfoButtonClear(){
    if(idouInfoButtonClear==null){

      idouInfoButtonClear = new ACButton();

      idouInfoButtonClear.setText("�N���A");

      idouInfoButtonClear.setToolTipText("�ٓ������N���A���܂��B");

      idouInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addIdouInfoButtonClear();
    }
    return idouInfoButtonClear;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getIdouInfoButtonInsert(){
    if(idouInfoButtonInsert==null){

      idouInfoButtonInsert = new ACButton();

      idouInfoButtonInsert.setText("�ǉ�");

      idouInfoButtonInsert.setToolTipText("�ٓ�����ǉ����܂��B");

      idouInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addIdouInfoButtonInsert();
    }
    return idouInfoButtonInsert;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getIdouInfoButtonEdit(){
    if(idouInfoButtonEdit==null){

      idouInfoButtonEdit = new ACButton();

      idouInfoButtonEdit.setText("����");

      idouInfoButtonEdit.setToolTipText("�ٓ�����ҏW���܂��B");

      idouInfoButtonEdit.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addIdouInfoButtonEdit();
    }
    return idouInfoButtonEdit;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getIdouInfoButtonDelete(){
    if(idouInfoButtonDelete==null){

      idouInfoButtonDelete = new ACButton();

      idouInfoButtonDelete.setText("�폜");

      idouInfoButtonDelete.setToolTipText("�ٓ������폜���܂��B");

      idouInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addIdouInfoButtonDelete();
    }
    return idouInfoButtonDelete;

  }

  /**
   * (�ٓ����E�e�[�u���̈�)���擾���܂��B
   * @return (�ٓ����E�e�[�u���̈�)
   */
  public ACTable getIdouInfoTable(){
    if(idouInfoTable==null){

      idouInfoTable = new ACTable();

      idouInfoTable.setColumnModel(getIdouInfoTableColumnModel());

      addIdouInfoTable();
    }
    return idouInfoTable;

  }

  /**
   * (�ٓ����E�e�[�u���̈�)�J�������f�����擾���܂��B
   * @return (�ٓ����E�e�[�u���̈�)�J�������f��
   */
  protected VRTableColumnModel getIdouInfoTableColumnModel(){
    if(idouInfoTableColumnModel==null){
      idouInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addIdouInfoTableColumnModel();
    }
    return idouInfoTableColumnModel;
  }

  /**
   * No���擾���܂��B
   * @return No
   */
  public ACTableColumn getIdouInfoTableColumn0(){
    if(idouInfoTableColumn0==null){

      idouInfoTableColumn0 = new ACTableColumn(0);

      idouInfoTableColumn0.setHeaderValue("No.");

      idouInfoTableColumn0.setColumns(3);

      idouInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      idouInfoTableColumn0.setSortable(false);

      addIdouInfoTableColumn0();
    }
    return idouInfoTableColumn0;

  }

  /**
   * �T�[�r�X���擾���܂��B
   * @return �T�[�r�X
   */
  public ACTableColumn getIdouInfoTableColumn1(){
    if(idouInfoTableColumn1==null){

      idouInfoTableColumn1 = new ACTableColumn(0);

      idouInfoTableColumn1.setHeaderValue("�T�[�r�X");

      idouInfoTableColumn1.setColumns(20);

      addIdouInfoTableColumn1();
    }
    return idouInfoTableColumn1;

  }

  /**
   * �ٓ����R���擾���܂��B
   * @return �ٓ����R
   */
  public ACTableColumn getIdouInfoTableColumn2(){
    if(idouInfoTableColumn2==null){

      idouInfoTableColumn2 = new ACTableColumn(1);

      idouInfoTableColumn2.setHeaderValue("�ٓ����R");

      idouInfoTableColumn2.setColumns(6);

      addIdouInfoTableColumn2();
    }
    return idouInfoTableColumn2;

  }

  /**
   * ���t���擾���܂��B
   * @return ���t
   */
  public ACTableColumn getIdouInfoTableColumn3(){
    if(idouInfoTableColumn3==null){

      idouInfoTableColumn3 = new ACTableColumn(2);

      idouInfoTableColumn3.setHeaderValue("���t");

      idouInfoTableColumn3.setColumns(10);

      idouInfoTableColumn3.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addIdouInfoTableColumn3();
    }
    return idouInfoTableColumn3;

  }

  /**
   * ���Ԃ��擾���܂��B
   * @return ����
   */
  public ACTableColumn getIdouInfoTableColumn4(){
    if(idouInfoTableColumn4==null){

      idouInfoTableColumn4 = new ACTableColumn(3);

      idouInfoTableColumn4.setHeaderValue("����");

      idouInfoTableColumn4.setColumns(6);

      idouInfoTableColumn4.setFormat(ACConstants.FORMAT_FULL_HOUR_MINUTE);

      addIdouInfoTableColumn4();
    }
    return idouInfoTableColumn4;

  }

  /**
   * ���R/�󋵂��擾���܂��B
   * @return ���R/��
   */
  public ACTableColumn getIdouInfoTableColumn5(){
    if(idouInfoTableColumn5==null){

      idouInfoTableColumn5 = new ACTableColumn(4);

      idouInfoTableColumn5.setHeaderValue("���R/��");

      idouInfoTableColumn5.setColumns(4);

      addIdouInfoTableColumn5();
    }
    return idouInfoTableColumn5;

  }

  /**
   * (�{�ݏ��E�̈�E�O���[�v)���擾���܂��B
   * @return (�{�ݏ��E�̈�E�O���[�v)
   */
  public ACGroupBox getInstitutionInfos(){
    if(institutionInfos==null){

      institutionInfos = new ACGroupBox();

      institutionInfos.setText("�{�ݏ��");

      institutionInfos.setLayout(getInstitutionInfoLayout());

      addInstitutionInfos();
    }
    return institutionInfos;

  }

  /**
   * (�{�ݏ��̈�E���C�A�E�g)���擾���܂��B
   * @return (�{�ݏ��̈�E���C�A�E�g)
   */
  public VRLayout getInstitutionInfoLayout(){
    if(institutionInfoLayout==null){

      institutionInfoLayout = new VRLayout();

      institutionInfoLayout.setAutoWrap(false);

      institutionInfoLayout.setVgap(5);

      institutionInfoLayout.setHgrid(200);

      addInstitutionInfoLayout();
    }
    return institutionInfoLayout;

  }

  /**
   * ���p�ҕ��S���x�z���x�����擾���܂��B
   * @return ���p�ҕ��S���x�z���x��
   */
  public ACLabel getInstitutionInfoBearMoneyInfos(){
    if(institutionInfoBearMoneyInfos==null){

      institutionInfoBearMoneyInfos = new ACLabel();

      institutionInfoBearMoneyInfos.setText("���p�ҕ��S���x�z");

      addInstitutionInfoBearMoneyInfos();
    }
    return institutionInfoBearMoneyInfos;

  }

  /**
   * �X�y�[�X1���擾���܂��B
   * @return �X�y�[�X1
   */
  public ACLabel getInstitutionInfoSpace1(){
    if(institutionInfoSpace1==null){

      institutionInfoSpace1 = new ACLabel();

      institutionInfoSpace1.setText(" ");

      addInstitutionInfoSpace1();
    }
    return institutionInfoSpace1;

  }

  /**
   * ��������҃`�F�b�N���擾���܂��B
   * @return ��������҃`�F�b�N
   */
  public ACIntegerCheckBox getInstitutionInfoTokuteiNyusho(){
    if(institutionInfoTokuteiNyusho==null){

      institutionInfoTokuteiNyusho = new ACIntegerCheckBox();

      institutionInfoTokuteiNyusho.setText("���������");

      institutionInfoTokuteiNyusho.setBindPath("TOKUTEI_NYUSHO_FLAG");

      institutionInfoTokuteiNyusho.setSelectValue(2);

      institutionInfoTokuteiNyusho.setUnSelectValue(1);

      addInstitutionInfoTokuteiNyusho();
    }
    return institutionInfoTokuteiNyusho;

  }

  /**
   * �X�y�[�X2���擾���܂��B
   * @return �X�y�[�X2
   */
  public ACLabel getInstitutionInfoSpace2(){
    if(institutionInfoSpace2==null){

      institutionInfoSpace2 = new ACLabel();

      institutionInfoSpace2.setText("�@�@�@�@�@�@�@�@�@�@�@");

      addInstitutionInfoSpace2();
    }
    return institutionInfoSpace2;

  }

  /**
   * �i�H��S���x�z�E�R���e�i�j���擾���܂��B
   * @return �i�H��S���x�z�E�R���e�i�j
   */
  public ACLabelContainer getInstitutionInfoDinnerBearLimitMoneyContena(){
    if(institutionInfoDinnerBearLimitMoneyContena==null){

      institutionInfoDinnerBearLimitMoneyContena = new ACLabelContainer();

      institutionInfoDinnerBearLimitMoneyContena.setText("�H��");

      addInstitutionInfoDinnerBearLimitMoneyContena();
    }
    return institutionInfoDinnerBearLimitMoneyContena;

  }

  /**
   * �H��S���x�z�E�e�L�X�g���擾���܂��B
   * @return �H��S���x�z�E�e�L�X�g
   */
  public ACTextField getInstitutionInfoDinnerBearLimitMoneyText(){
    if(institutionInfoDinnerBearLimitMoneyText==null){

      institutionInfoDinnerBearLimitMoneyText = new ACTextField();

      institutionInfoDinnerBearLimitMoneyText.setBindPath("LIMIT_SHOKUHI");

      institutionInfoDinnerBearLimitMoneyText.setColumns(4);

      institutionInfoDinnerBearLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoDinnerBearLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoDinnerBearLimitMoneyText.setIMEMode(InputSubset.LATIN);

      institutionInfoDinnerBearLimitMoneyText.setMaxLength(4);

      addInstitutionInfoDinnerBearLimitMoneyText();
    }
    return institutionInfoDinnerBearLimitMoneyText;

  }

  /**
   * �H��S���x�z�E���x�����擾���܂��B
   * @return �H��S���x�z�E���x��
   */
  public ACLabel getInstitutionInfoDinnerBearLimitMoneyLabel(){
    if(institutionInfoDinnerBearLimitMoneyLabel==null){

      institutionInfoDinnerBearLimitMoneyLabel = new ACLabel();

      institutionInfoDinnerBearLimitMoneyLabel.setText("�i�~�j");

      addInstitutionInfoDinnerBearLimitMoneyLabel();
    }
    return institutionInfoDinnerBearLimitMoneyLabel;

  }

  /**
   * �i���j�b�g�^�����S���x�z�E�R���e�i�j���擾���܂��B
   * @return �i���j�b�g�^�����S���x�z�E�R���e�i�j
   */
  public ACLabelContainer getInstitutionInfoUnitRoomLimitMoneyContena(){
    if(institutionInfoUnitRoomLimitMoneyContena==null){

      institutionInfoUnitRoomLimitMoneyContena = new ACLabelContainer();

      institutionInfoUnitRoomLimitMoneyContena.setText("���j�b�g�^��");

      addInstitutionInfoUnitRoomLimitMoneyContena();
    }
    return institutionInfoUnitRoomLimitMoneyContena;

  }

  /**
   * ���j�b�g�^�����S���x�z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^�����S���x�z�E�e�L�X�g
   */
  public ACTextField getInstitutionInfoUnitRoomLimitMoneyText(){
    if(institutionInfoUnitRoomLimitMoneyText==null){

      institutionInfoUnitRoomLimitMoneyText = new ACTextField();

      institutionInfoUnitRoomLimitMoneyText.setBindPath("LIMIT_UNIT_KOSHITSU");

      institutionInfoUnitRoomLimitMoneyText.setColumns(4);

      institutionInfoUnitRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoUnitRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoUnitRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      institutionInfoUnitRoomLimitMoneyText.setMaxLength(4);

      addInstitutionInfoUnitRoomLimitMoneyText();
    }
    return institutionInfoUnitRoomLimitMoneyText;

  }

  /**
   * ���j�b�g�^�����S���x�z�E���x�����擾���܂��B
   * @return ���j�b�g�^�����S���x�z�E���x��
   */
  public ACLabel getInstitutionInfoUnitRoomLimitMoneyLabel(){
    if(institutionInfoUnitRoomLimitMoneyLabel==null){

      institutionInfoUnitRoomLimitMoneyLabel = new ACLabel();

      institutionInfoUnitRoomLimitMoneyLabel.setText("�i�~�j");

      addInstitutionInfoUnitRoomLimitMoneyLabel();
    }
    return institutionInfoUnitRoomLimitMoneyLabel;

  }

  /**
   * �i���j�b�g�^�������S���x�z�E�R���e�i�j���擾���܂��B
   * @return �i���j�b�g�^�������S���x�z�E�R���e�i�j
   */
  public ACLabelContainer getInstitutionInfoUnitSemiRoomLimitMoneyContena(){
    if(institutionInfoUnitSemiRoomLimitMoneyContena==null){

      institutionInfoUnitSemiRoomLimitMoneyContena = new ACLabelContainer();

      institutionInfoUnitSemiRoomLimitMoneyContena.setText("���j�b�g�^����");

      addInstitutionInfoUnitSemiRoomLimitMoneyContena();
    }
    return institutionInfoUnitSemiRoomLimitMoneyContena;

  }

  /**
   * ���j�b�g�^�������S���x�z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^�������S���x�z�E�e�L�X�g
   */
  public ACTextField getInstitutionInfoUnitSemiRoomLimitMoneyText(){
    if(institutionInfoUnitSemiRoomLimitMoneyText==null){

      institutionInfoUnitSemiRoomLimitMoneyText = new ACTextField();

      institutionInfoUnitSemiRoomLimitMoneyText.setBindPath("LIMIT_UNIT_JUNKOSHITSU");

      institutionInfoUnitSemiRoomLimitMoneyText.setColumns(4);

      institutionInfoUnitSemiRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoUnitSemiRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoUnitSemiRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      institutionInfoUnitSemiRoomLimitMoneyText.setMaxLength(4);

      addInstitutionInfoUnitSemiRoomLimitMoneyText();
    }
    return institutionInfoUnitSemiRoomLimitMoneyText;

  }

  /**
   * ���j�b�g�^�������S���x�z�E���x�����擾���܂��B
   * @return ���j�b�g�^�������S���x�z�E���x��
   */
  public ACLabel getInstitutionInfoUnitSemiRoomLimitMoneyLabel(){
    if(institutionInfoUnitSemiRoomLimitMoneyLabel==null){

      institutionInfoUnitSemiRoomLimitMoneyLabel = new ACLabel();

      institutionInfoUnitSemiRoomLimitMoneyLabel.setText("�i�~�j");

      addInstitutionInfoUnitSemiRoomLimitMoneyLabel();
    }
    return institutionInfoUnitSemiRoomLimitMoneyLabel;

  }

  /**
   * �i�]���^���i���{���j���S���x�z�E�R���e�i�j���擾���܂��B
   * @return �i�]���^���i���{���j���S���x�z�E�R���e�i�j
   */
  public ACLabelContainer getInstitutionInfoNormalRoomLimitMoneyContena(){
    if(institutionInfoNormalRoomLimitMoneyContena==null){

      institutionInfoNormalRoomLimitMoneyContena = new ACLabelContainer();

      institutionInfoNormalRoomLimitMoneyContena.setText("�]���^��(���{��)");

      addInstitutionInfoNormalRoomLimitMoneyContena();
    }
    return institutionInfoNormalRoomLimitMoneyContena;

  }

  /**
   * �]���^���i���{���j���S���x�z�E�e�L�X�g���擾���܂��B
   * @return �]���^���i���{���j���S���x�z�E�e�L�X�g
   */
  public ACTextField getInstitutionInfoNormalRoomLimitMoneyText(){
    if(institutionInfoNormalRoomLimitMoneyText==null){

      institutionInfoNormalRoomLimitMoneyText = new ACTextField();

      institutionInfoNormalRoomLimitMoneyText.setBindPath("LIMIT_JURAIGATA1");

      institutionInfoNormalRoomLimitMoneyText.setColumns(4);

      institutionInfoNormalRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoNormalRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoNormalRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      institutionInfoNormalRoomLimitMoneyText.setMaxLength(4);

      addInstitutionInfoNormalRoomLimitMoneyText();
    }
    return institutionInfoNormalRoomLimitMoneyText;

  }

  /**
   * �]���^���i���{���j���S���x�z�E���x�����擾���܂��B
   * @return �]���^���i���{���j���S���x�z�E���x��
   */
  public ACLabel getInstitutionInfoNormalRoomLimitMoneyLabel(){
    if(institutionInfoNormalRoomLimitMoneyLabel==null){

      institutionInfoNormalRoomLimitMoneyLabel = new ACLabel();

      institutionInfoNormalRoomLimitMoneyLabel.setText("�i�~�j");

      addInstitutionInfoNormalRoomLimitMoneyLabel();
    }
    return institutionInfoNormalRoomLimitMoneyLabel;

  }

  /**
   * �i�]���^���i�V���E�×{���j���S���x�z�E�R���e�i�j���擾���܂��B
   * @return �i�]���^���i�V���E�×{���j���S���x�z�E�R���e�i�j
   */
  public ACLabelContainer getInstitutionInfoNormalRoomLimitMoneyContena2(){
    if(institutionInfoNormalRoomLimitMoneyContena2==null){

      institutionInfoNormalRoomLimitMoneyContena2 = new ACLabelContainer();

      institutionInfoNormalRoomLimitMoneyContena2.setText("�]���^��(�V���E�×{��)");

      addInstitutionInfoNormalRoomLimitMoneyContena2();
    }
    return institutionInfoNormalRoomLimitMoneyContena2;

  }

  /**
   * �]���^���i�V���E�×{���j���S���x�z�E�e�L�X�g���擾���܂��B
   * @return �]���^���i�V���E�×{���j���S���x�z�E�e�L�X�g
   */
  public ACTextField getInstitutionInfoNormalRoomLimitMoneyText2(){
    if(institutionInfoNormalRoomLimitMoneyText2==null){

      institutionInfoNormalRoomLimitMoneyText2 = new ACTextField();

      institutionInfoNormalRoomLimitMoneyText2.setBindPath("LIMIT_JURAIGATA2");

      institutionInfoNormalRoomLimitMoneyText2.setColumns(4);

      institutionInfoNormalRoomLimitMoneyText2.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoNormalRoomLimitMoneyText2.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoNormalRoomLimitMoneyText2.setIMEMode(InputSubset.LATIN);

      institutionInfoNormalRoomLimitMoneyText2.setMaxLength(4);

      addInstitutionInfoNormalRoomLimitMoneyText2();
    }
    return institutionInfoNormalRoomLimitMoneyText2;

  }

  /**
   * �]���^���i�V���E�×{���j���S���x�z�E���x�����擾���܂��B
   * @return �]���^���i�V���E�×{���j���S���x�z�E���x��
   */
  public ACLabel getInstitutionInfoNormalRoomLimitMoneyLabel2(){
    if(institutionInfoNormalRoomLimitMoneyLabel2==null){

      institutionInfoNormalRoomLimitMoneyLabel2 = new ACLabel();

      institutionInfoNormalRoomLimitMoneyLabel2.setText("�i�~�j");

      addInstitutionInfoNormalRoomLimitMoneyLabel2();
    }
    return institutionInfoNormalRoomLimitMoneyLabel2;

  }

  /**
   * �i���������S���x�z�E�R���e�i�j���擾���܂��B
   * @return �i���������S���x�z�E�R���e�i�j
   */
  public ACLabelContainer getInstitutionInfoTasyoRoomLimitMoneyContena(){
    if(institutionInfoTasyoRoomLimitMoneyContena==null){

      institutionInfoTasyoRoomLimitMoneyContena = new ACLabelContainer();

      institutionInfoTasyoRoomLimitMoneyContena.setText("������");

      addInstitutionInfoTasyoRoomLimitMoneyContena();
    }
    return institutionInfoTasyoRoomLimitMoneyContena;

  }

  /**
   * ���������S���x�z�E�e�L�X�g���擾���܂��B
   * @return ���������S���x�z�E�e�L�X�g
   */
  public ACTextField getInstitutionInfoTasyoRoomLimitMoneyText(){
    if(institutionInfoTasyoRoomLimitMoneyText==null){

      institutionInfoTasyoRoomLimitMoneyText = new ACTextField();

      institutionInfoTasyoRoomLimitMoneyText.setBindPath("LIMIT_TASHOSHITSU");

      institutionInfoTasyoRoomLimitMoneyText.setColumns(4);

      institutionInfoTasyoRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      institutionInfoTasyoRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      institutionInfoTasyoRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      institutionInfoTasyoRoomLimitMoneyText.setMaxLength(4);

      addInstitutionInfoTasyoRoomLimitMoneyText();
    }
    return institutionInfoTasyoRoomLimitMoneyText;

  }

  /**
   * ���������S���x�z�E���x�����擾���܂��B
   * @return ���������S���x�z�E���x��
   */
  public ACLabel getInstitutionInfoTasyoRoomLimitMoneyLabel(){
    if(institutionInfoTasyoRoomLimitMoneyLabel==null){

      institutionInfoTasyoRoomLimitMoneyLabel = new ACLabel();

      institutionInfoTasyoRoomLimitMoneyLabel.setText("�i�~�j");

      addInstitutionInfoTasyoRoomLimitMoneyLabel();
    }
    return institutionInfoTasyoRoomLimitMoneyLabel;

  }

  /**
   * ���V�l�����{�݁E���x�����擾���܂��B
   * @return ���V�l�����{�݁E���x��
   */
  public ACLabel getInstitutionInfoCareOldPersonLabel(){
    if(institutionInfoCareOldPersonLabel==null){

      institutionInfoCareOldPersonLabel = new ACLabel();

      institutionInfoCareOldPersonLabel.setText("���V�l�����{��");

      addInstitutionInfoCareOldPersonLabel();
    }
    return institutionInfoCareOldPersonLabel;

  }

  /**
   * �X�y�[�X3���擾���܂��B
   * @return �X�y�[�X3
   */
  public ACLabel getInstitutionInfoSpace3(){
    if(institutionInfoSpace3==null){

      institutionInfoSpace3 = new ACLabel();

      institutionInfoSpace3.setText(" ");

      addInstitutionInfoSpace3();
    }
    return institutionInfoSpace3;

  }

  /**
   * ���[�u�����ғ�����擾���܂��B
   * @return ���[�u�����ғ���
   */
  public ACIntegerCheckBox getInstitutionInfoOldStep(){
    if(institutionInfoOldStep==null){

      institutionInfoOldStep = new ACIntegerCheckBox();

      institutionInfoOldStep.setText("���[�u�����ғ���");

      institutionInfoOldStep.setBindPath("KYUSOCHI_FLAG");

      institutionInfoOldStep.setSelectValue(2);

      institutionInfoOldStep.setUnSelectValue(1);

      addInstitutionInfoOldStep();
    }
    return institutionInfoOldStep;

  }

  /**
   * ���V�l�ی��{�݁E���×{�^��Î{�݂��擾���܂��B
   * @return ���V�l�ی��{�݁E���×{�^��Î{��
   */
  public ACLabel getInstitutionInfoCareOldPersonInsuranceLabel(){
    if(institutionInfoCareOldPersonInsuranceLabel==null){

      institutionInfoCareOldPersonInsuranceLabel = new ACLabel();

      institutionInfoCareOldPersonInsuranceLabel.setText("���V�l�ی��{�݁E���×{�^��Î{��");

      addInstitutionInfoCareOldPersonInsuranceLabel();
    }
    return institutionInfoCareOldPersonInsuranceLabel;

  }

  /**
   * �X�y�[�X4���擾���܂��B
   * @return �X�y�[�X4
   */
  public ACLabel getInstitutionInfoSpace4(){
    if(institutionInfoSpace4==null){

      institutionInfoSpace4 = new ACLabel();

      addInstitutionInfoSpace4();
    }
    return institutionInfoSpace4;

  }

  /**
   * �叝�a���擾���܂��B
   * @return �叝�a
   */
  public ACTextField getInstitutionInfoMainDisease(){
    if(institutionInfoMainDisease==null){

      institutionInfoMainDisease = new ACTextField();

      getInstitutionInfoMainDiseaseContainer().setText("�叝�a");

      institutionInfoMainDisease.setBindPath("DISEASE");

      institutionInfoMainDisease.setColumns(15);

      institutionInfoMainDisease.setIMEMode(InputSubset.KANJI);

      institutionInfoMainDisease.setMaxLength(64);

      addInstitutionInfoMainDisease();
    }
    return institutionInfoMainDisease;

  }

  /**
   * �叝�a�R���e�i���擾���܂��B
   * @return �叝�a�R���e�i
   */
  protected ACLabelContainer getInstitutionInfoMainDiseaseContainer(){
    if(institutionInfoMainDiseaseContainer==null){
      institutionInfoMainDiseaseContainer = new ACLabelContainer();
      institutionInfoMainDiseaseContainer.setFollowChildEnabled(true);
      institutionInfoMainDiseaseContainer.setVAlignment(VRLayout.CENTER);
      institutionInfoMainDiseaseContainer.add(getInstitutionInfoMainDisease(), null);
    }
    return institutionInfoMainDiseaseContainer;
  }

  /**
   * �X�y�[�X5���擾���܂��B
   * @return �X�y�[�X5
   */
  public ACLabel getInstitutionInfoSpace5(){
    if(institutionInfoSpace5==null){

      institutionInfoSpace5 = new ACLabel();

      institutionInfoSpace5.setText("�@");

      addInstitutionInfoSpace5();
    }
    return institutionInfoSpace5;

  }

  /**
   * (�������O���[�v)���擾���܂��B
   * @return (�������O���[�v)
   */
  public ACGroupBox getInstitutionInfoExplanationGroup(){
    if(institutionInfoExplanationGroup==null){

      institutionInfoExplanationGroup = new ACGroupBox();

      institutionInfoExplanationGroup.setAutoWrap(true);

      institutionInfoExplanationGroup.setHgap(0);

      addInstitutionInfoExplanationGroup();
    }
    return institutionInfoExplanationGroup;

  }

  /**
   * ���������x��1���擾���܂��B
   * @return ���������x��1
   */
  public ACLabel getInstitutionInfoExplanationLabel1(){
    if(institutionInfoExplanationLabel1==null){

      institutionInfoExplanationLabel1 = new ACLabel();

      institutionInfoExplanationLabel1.setText("���@�E�������̐ݒ���@");

      institutionInfoExplanationLabel1.setIconPath(ACConstants.ICON_PATH_INFORMATION_24);

      addInstitutionInfoExplanationLabel1();
    }
    return institutionInfoExplanationLabel1;

  }

  /**
   * ���������x��2���擾���܂��B
   * @return ���������x��2
   */
  public ACLabel getInstitutionInfoExplanationLabel2(){
    if(institutionInfoExplanationLabel2==null){

      institutionInfoExplanationLabel2 = new ACLabel();

      institutionInfoExplanationLabel2.setText("�@�ٓ����ɂĎ{�݌n�T�[�r�X��I�����A�ݒ���@");

      addInstitutionInfoExplanationLabel2();
    }
    return institutionInfoExplanationLabel2;

  }

  /**
   * ���������x��3���擾���܂��B
   * @return ���������x��3
   */
  public ACLabel getInstitutionInfoExplanationLabel3(){
    if(institutionInfoExplanationLabel3==null){

      institutionInfoExplanationLabel3 = new ACLabel();

      institutionInfoExplanationLabel3.setText("�@�s���Ă��������B");

      addInstitutionInfoExplanationLabel3();
    }
    return institutionInfoExplanationLabel3;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QU002Design() {

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
   * (�Ɩ��{�^���o�[)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getClearUpdateMode(), VRLayout.EAST);
    buttons.add(getClearInsertMode(), VRLayout.EAST);
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
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClearInsertMode(){

  }

  /**
   * �V�K�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClearUpdateMode(){

  }

  /**
   * (�N���C�A���g�̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getBasicInfoAndInfoButtons(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * (�N���C�A���g�̈�E���C�A�E�g)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContentsLayout(){

  }

  /**
   * (��{���E�{�^���̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoAndInfoButtons(){

    basicInfoAndInfoButtons.add(getBasicInfoAndInfoButtonFlame(), VRLayout.CLIENT);

    basicInfoAndInfoButtons.add(getInfoButtons(), VRLayout.EAST);
  }

  /**
   * (��{���E�{�^���̈�E�O���[�v)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoAndInfoButtonFlame(){

    basicInfoAndInfoButtonFlame.add(getBasicInfoAndInfoButton(), VRLayout.FLOW);

  }

  /**
   * (��{���E�{�^�����C�A�E�g)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoAndInfoButtonLayout(){

  }

  /**
   * (��{���̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoAndInfoButton(){

    basicInfoAndInfoButton.add(getBasicInfoPatientCdContainer(), VRLayout.FLOW_INSETLINE);

    basicInfoAndInfoButton.add(getBasicInfoSexsContainer(), VRLayout.FLOW_INSETLINE);

    basicInfoAndInfoButton.add(getBasicInfoCheck(), VRLayout.FLOW_INSETLINE_RETURN);

    basicInfoAndInfoButton.add(getBasicInfoNameContena(), VRLayout.FLOW_DOUBLEINSETLINE);

    basicInfoAndInfoButton.add(getBasicInfoBirthContena(), VRLayout.FLOW_INSETLINE_RETURN);

    basicInfoAndInfoButton.add(getBasicInfoFuriganaContena(), VRLayout.FLOW_DOUBLEINSETLINE);

    basicInfoAndInfoButton.add(getBasicInfoTelContena(), VRLayout.FLOW_INSETLINE_RETURN);

    basicInfoAndInfoButton.add(getBasicInfoZips(), VRLayout.FLOW_INSETLINE);

    basicInfoAndInfoButton.add(getBasicInfoAddressContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * (��{���̈�E���C�A�E�g)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoLayout(){

  }

  /**
   * ���p��Cd�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoPatientCd(){

  }

  /**
   * ���ʂɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoSexs(){

  }

  /**
   * ���ʃ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoSexsModel(){

    getBasicInfoMan().setButtonIndex(1);

    getBasicInfoSexsModel().add(getBasicInfoMan());

    getBasicInfoWoman().setButtonIndex(2);

    getBasicInfoSexsModel().add(getBasicInfoWoman());

  }

  /**
   * �j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoMan(){

  }

  /**
   * ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoWoman(){

  }

  /**
   * �ꗗ�ɕ\���E�`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoCheck(){

  }

  /**
   * (�����E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoNameContena(){

    basicInfoNameContena.add(getBasicInfoFamilyNameContena(), VRLayout.FLOW);

    basicInfoNameContena.add(getBasicInfoFirstNameContena(), VRLayout.FLOW);

  }

  /**
   * (����1�E�w�ʃR���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoFamilyNameContena(){

    basicInfoFamilyNameContena.add(getBasicInfoName1(), VRLayout.FLOW);

  }

  /**
   * ����1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoName1(){

  }

  /**
   * (����2�E�w�ʃR���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoFirstNameContena(){

    basicInfoFirstNameContena.add(getBasicInfoName2(), VRLayout.FLOW);

  }

  /**
   * ����2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoName2(){

  }

  /**
   * (���N�����E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoBirthContena(){

    basicInfoBirthContena.add(getBasicInfoBirth(), VRLayout.FLOW);

    basicInfoBirthContena.add(getBasicInfoAgeLabel1(), VRLayout.FLOW);

    basicInfoBirthContena.add(getBasicInfoAge(), VRLayout.FLOW);

    basicInfoBirthContena.add(getBasicInfoAgeLabel2(), VRLayout.FLOW);

  }

  /**
   * ���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoBirth(){

  }

  /**
   * �N��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoAgeLabel1(){

  }

  /**
   * �N��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoAge(){

  }

  /**
   * �΃��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoAgeLabel2(){

  }

  /**
   * (�t���K�i�E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoFuriganaContena(){

    basicInfoFuriganaContena.add(getBasicInfoFamilyFuriganaContena(), VRLayout.FLOW);

    basicInfoFuriganaContena.add(getBasicInfoFirstFuriganaContena(), VRLayout.FLOW);

  }

  /**
   * (�t���K�i1�E�w�ʃR���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoFamilyFuriganaContena(){

    basicInfoFamilyFuriganaContena.add(getBasicInfoFurigana1(), VRLayout.FLOW);

  }

  /**
   * �t���K�i1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoFurigana1(){

  }

  /**
   * (�t���K�i2�E�w�ʃR���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoFirstFuriganaContena(){

    basicInfoFirstFuriganaContena.add(getBasicInfoFurigana2(), VRLayout.FLOW);

  }

  /**
   * �t���K�i2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoFurigana2(){

  }

  /**
   * (�d�b�ԍ��E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTelContena(){

    basicInfoTelContena.add(getBasicInfoTel2(), VRLayout.FLOW);

    basicInfoTelContena.add(getBasicInfoTel3(), VRLayout.FLOW);

    basicInfoTelContena.add(getBasicInfoTel4(), VRLayout.FLOW);

    basicInfoTelContena.add(getBasicInfoTel5(), VRLayout.FLOW);

    basicInfoTelContena.add(getBasicInfoTel6(), VRLayout.FLOW);

  }

  /**
   * �d�b�ԍ��E�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTel2(){

  }

  /**
   * �d�b�ԍ��E���x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTel3(){

  }

  /**
   * �d�b�ԍ��E�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTel4(){

  }

  /**
   * �d�b�ԍ��E���x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTel5(){

  }

  /**
   * �d�b�ԍ��E�e�L�X�g3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTel6(){

  }

  /**
   * (�X�֔ԍ��E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoZips(){

    basicInfoZips.add(getBasicInfoZip1(), VRLayout.FLOW);

    basicInfoZips.add(getBasicInfoZip2(), VRLayout.FLOW);

    basicInfoZips.add(getBasicInfoZip3(), VRLayout.FLOW);

  }

  /**
   * �X�֔ԍ��e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoZip1(){

  }

  /**
   * �X�֔ԍ��E���x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoZip2(){

  }

  /**
   * �X�֔ԍ��e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoZip3(){

  }

  /**
   * �Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoAddress(){

  }

  /**
   * (�{�^���̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoButtons(){

    infoButtons.add(getToKohiInfoButton(), VRLayout.FLOW);

  }

  /**
   * ����E�Е��y�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addToKohiInfoButton(){

  }

  /**
   * (�^�u)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTabs(){

    tabs.addTab("���ی����", getKaigoInfoAndIdouInfos());

    tabs.addTab("�ٓ��E�{�ݏ��", getIdouInfoAndInstitutionInfoPanel());

  }

  /**
   * (���ی����E�ٓ����̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoAndIdouInfos(){

    kaigoInfoAndIdouInfos.add(getKaigoInfos(), VRLayout.CLIENT);

  }

  /**
   * (���ی����̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfos(){

    kaigoInfos.add(getKaigoInfoRyo(), VRLayout.NORTH);

    kaigoInfos.add(getKaigoInfoTable(), VRLayout.CLIENT);

  }

  /**
   * (���ی����̈�E���C�A�E�g)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoLayout(){

  }

  /**
   * (���ی��̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoRyo(){

    kaigoInfoRyo.add(getKaigoInfo(), VRLayout.NORTH);

    kaigoInfoRyo.add(getKaigoInfoButtons(), VRLayout.NORTH);

  }

  /**
   * (���ی��̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfo(){

    kaigoInfo.add(getKaigoInfoInsurerIdContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoInsurerNameContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getYokaigodoNowContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoInsuredIdContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoBenefitContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoKyotakuServiceContena(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoReportDateContainer(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoRequestDivisionContena(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoYokaigoInfoContainer(), VRLayout.FLOW);

    kaigoInfo.add(getKaigoInfoValidLimits(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoRequestDateContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoAuthorizeDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoProvideLimitGroup(), VRLayout.FLOW);

    kaigoInfo.add(getKaigoInfoInterruptionGroup(), VRLayout.FLOW_RETURN);

  }

  /**
   * (���ی��̈�E���C�A�E�g)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoLayout2(){

  }

  /**
   * �ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInsurerId(){

  }

  /**
   * �ی��Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInsurerName(){

  }

  /**
   * �ی��Җ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInsurerNameModel(){

  }

  /**
   * ���݂̗v���x�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoNow(){

  }

  /**
   * ��ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInsuredId(){

  }

  /**
   * (���t���̈�E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoBenefitContainer(){

    kaigoInfoBenefitContainer.add(getKaigoInfoBenefit(), VRLayout.FLOW);

    kaigoInfoBenefitContainer.add(getKaigoInfoBenefitPercent(), VRLayout.FLOW);

  }

  /**
   * ���t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoBenefit(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoBenefitPercent(){

  }

  /**
   * (����T�[�r�X�v��쐬�ҁE�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKyotakuServiceContena(){

    kaigoInfoKyotakuServiceContena.add(getKaigoInfoKyotakuServiceRadio(), VRLayout.FLOW);

    kaigoInfoKyotakuServiceContena.add(getKaigoInfoKyotakuServicePlanCombo(), VRLayout.FLOW);

  }

  /**
   * (����T�[�r�X�v��쐬�ҁE�R���e�i�E���C�A�E�g)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKyotakuServiceContenaLayout(){

  }

  /**
   * ����T�[�r�X�E���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKyotakuServiceRadio(){

  }

  /**
   * ����T�[�r�X�E���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKyotakuServiceRadioModel(){

    getKaigoInfoKyotakuServiceRadioItem1().setButtonIndex(1);

    getKaigoInfoKyotakuServiceRadioModel().add(getKaigoInfoKyotakuServiceRadioItem1());

    getKaigoInfoKyotakuServiceRadioItem2().setButtonIndex(2);

    getKaigoInfoKyotakuServiceRadioModel().add(getKaigoInfoKyotakuServiceRadioItem2());

    getKaigoInfoKyotakuServiceRadioItem3().setButtonIndex(3);

    getKaigoInfoKyotakuServiceRadioModel().add(getKaigoInfoKyotakuServiceRadioItem3());

  }

  /**
   * ������x�����Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKyotakuServiceRadioItem1(){

  }

  /**
   * ��ی��҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKyotakuServiceRadioItem2(){

  }

  /**
   * ���\�h�x�����Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKyotakuServiceRadioItem3(){

  }

  /**
   * ����T�[�r�X�v��쐬�ҁE�R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKyotakuServicePlanCombo(){

  }

  /**
   * ����T�[�r�X�v��쐬�ҁE�R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKyotakuServicePlanComboModel(){

  }

  /**
   * ����T�[�r�X�v��쐬�˗��͏o���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoReportDate(){

  }

  /**
   * (�\���敪�E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoRequestDivisionContena(){

    kaigoInfoRequestDivisionContena.add(getKaigoInfoRequestDivisionRadio(), VRLayout.FLOW);

    kaigoInfoRequestDivisionContena.add(getKaigoInfoRequests(), VRLayout.FLOW);

  }

  /**
   * �\���敪�E���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoRequestDivisionRadio(){

  }

  /**
   * �\���敪�E���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoRequestDivisionRadioModel(){

    getKaigoInfoRequestDivisionRadioItem1().setButtonIndex(1);

    getKaigoInfoRequestDivisionRadioModel().add(getKaigoInfoRequestDivisionRadioItem1());

    getKaigoInfoRequestDivisionRadioItem2().setButtonIndex(2);

    getKaigoInfoRequestDivisionRadioModel().add(getKaigoInfoRequestDivisionRadioItem2());

    getKaigoInfoRequestDivisionRadioItem3().setButtonIndex(3);

    getKaigoInfoRequestDivisionRadioModel().add(getKaigoInfoRequestDivisionRadioItem3());

  }

  /**
   * ���ԏI����V�K�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoRequestDivisionRadioItem1(){

  }

  /**
   * �X�V�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoRequestDivisionRadioItem2(){

  }

  /**
   * �ύX�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoRequestDivisionRadioItem3(){

  }

  /**
   * �\�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoRequests(){

  }

  /**
   * �v�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoYokaigoInfo(){

  }

  /**
   * �v����񃂃f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoYokaigoInfoModel(){

  }

  /**
   * (�L�����ԁE�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoValidLimits(){

    kaigoInfoValidLimits.add(getKaigoInfoValidLimit1(), VRLayout.FLOW);

    kaigoInfoValidLimits.add(getKaigoInfoValidLimit2(), VRLayout.FLOW);

    kaigoInfoValidLimits.add(getKaigoInfoValidLimit3(), VRLayout.FLOW);

  }

  /**
   * �L�����ԁE�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoValidLimit1(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoValidLimit2(){

  }

  /**
   * �L�����ԁE�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoValidLimit3(){

  }

  /**
   * �\�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoRequestDate(){

  }

  /**
   * �F����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoAuthorizeDate(){

  }

  /**
   * (�x�����x�z�O���[�v)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoProvideLimitGroup(){

    kaigoInfoProvideLimitGroup.add(getKaigoInfoProvideLimitContena(), VRLayout.FLOW_INSETLINE);

    kaigoInfoProvideLimitGroup.add(getKaigoInfoExternalUseLimitContena(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * (�x�����x�z�E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoProvideLimitContena(){

    kaigoInfoProvideLimitContena.add(getKaigoInfoProvideLimit(), VRLayout.FLOW);

    kaigoInfoProvideLimitContena.add(getKaigoInfoProvideLimitLabel(), VRLayout.FLOW);

  }

  /**
   * �x�����x�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoProvideLimit(){

  }

  /**
   * �P�ʃ��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoProvideLimitLabel(){

  }

  /**
   * (�O�����p�^���t����P�ʐ��E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoExternalUseLimitContena(){

    kaigoInfoExternalUseLimitContena.add(getKaigoInfoExternalUseLimit(), VRLayout.FLOW);

    kaigoInfoExternalUseLimitContena.add(getKaigoInfoExternalUseLimitLabel(), VRLayout.FLOW);

  }

  /**
   * �O�����p�^���t����P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoExternalUseLimit(){

  }

  /**
   * �P�ʃ��x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoExternalUseLimitLabel(){

  }

  /**
   * (���f���E���f���R�O���[�v)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInterruptionGroup(){

    kaigoInfoInterruptionGroup.add(getKaigoInfoInterruptionDateContainer(), VRLayout.FLOW);

    kaigoInfoInterruptionGroup.add(getKaigoInfoInterruptionReasonRadioContainer(), VRLayout.FLOW_RETURN);

    kaigoInfoInterruptionGroup.add(getKaigoInfoExplanationLabel1(), VRLayout.FLOW);

  }

  /**
   * ���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInterruptionDate(){

  }

  /**
   * ���f���R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInterruptionReasonRadio(){

  }

  /**
   * ���f���R���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInterruptionReasonRadioModel(){

    getKaigoInfoInterruptionReasonRadioItem1().setButtonIndex(1);

    getKaigoInfoInterruptionReasonRadioModel().add(getKaigoInfoInterruptionReasonRadioItem1());

    getKaigoInfoInterruptionReasonRadioItem2().setButtonIndex(2);

    getKaigoInfoInterruptionReasonRadioModel().add(getKaigoInfoInterruptionReasonRadioItem2());

    getKaigoInfoInterruptionReasonRadioItem3().setButtonIndex(3);

    getKaigoInfoInterruptionReasonRadioModel().add(getKaigoInfoInterruptionReasonRadioItem3());

  }

  /**
   * ��X�V�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInterruptionReasonRadioItem1(){

  }

  /**
   * ��Y���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInterruptionReasonRadioItem2(){

  }

  /**
   * ���S�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoInterruptionReasonRadioItem3(){

  }

  /**
   * ���������x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoExplanationLabel1(){

  }

  /**
   * (���ی����E�{�^���̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoButtons(){

    kaigoInfoButtons.add(getKaigoInfoButtonClear(), VRLayout.WEST);

    kaigoInfoButtons.add(getKaigoInfoButtonInsert(), VRLayout.WEST);

    kaigoInfoButtons.add(getKaigoInfoButtonEdit(), VRLayout.WEST);

    kaigoInfoButtons.add(getKaigoInfoDelete(), VRLayout.WEST);

  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoButtonClear(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoButtonInsert(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoButtonEdit(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoDelete(){

  }

  /**
   * (�����E�e�[�u���̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTable(){

  }

  /**
   * (�����E�e�[�u���̈�)�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumnModel(){

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn0());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn1());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn2());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn3());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn4());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn5());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn6());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn7());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn8());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn9());

  }

  /**
   * No�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn0(){

  }

  /**
   * �\�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn1(){

  }

  /**
   * �\���敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn2(){

  }

  /**
   * �v�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn3(){

  }

  /**
   * �L�����ԊJ�n���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn4(){

  }

  /**
   * �L�����ԏI�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn5(){

  }

  /**
   * �쐬�˗��͏o���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn6(){

  }

  /**
   * ���f�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn7(){

  }

  /**
   * ���f���R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn8(){

  }

  /**
   * �x�����x�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn9(){

  }

  /**
   * (�ٓ��E�{�ݏ��E�p�l��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoAndInstitutionInfoPanel(){

    idouInfoAndInstitutionInfoPanel.add(getIdouInfoAndInstitutionInfos(), VRLayout.CLIENT);

    idouInfoAndInstitutionInfoPanel.add(getInstitutionInfos(), VRLayout.EAST);
  }

  /**
   * (�ٓ����̈�E�O���[�v)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoAndInstitutionInfos(){

    idouInfoAndInstitutionInfos.add(getIdouInfoUp(), VRLayout.NORTH);

    idouInfoAndInstitutionInfos.add(getIdouInfoTable(), VRLayout.CLIENT);

  }

  /**
   * (�ٓ��E�{�ݏ��̈�E���C�A�E�g)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoAndInstitutionInfoLayout(){

  }

  /**
   * (�ٓ����̈�E��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoUp(){

    idouInfoUp.add(getIdouInfo(), VRLayout.NORTH);

    idouInfoUp.add(getIdouInfoButtons(), VRLayout.NORTH);

  }

  /**
   * (�ٓ����̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfo(){

    idouInfo.add(getIdouInfoServiseContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    idouInfo.add(getIdouInfoChangeContentContainer(), VRLayout.FLOW_INSETLINE);

    idouInfo.add(getIdouInfoDateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    idouInfo.add(getIdouInfoTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    idouInfo.add(getIdouInfoReasonContainer(), VRLayout.FLOW_INSETLINE);

    idouInfo.add(getIdouInfoReasonMemoContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * (�ٓ����̈�E���C�A�E�g)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoLayout2(){

  }

  /**
   * �T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoServise(){

  }

  /**
   * �T�[�r�X���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoServiseModel(){

  }

  /**
   * �ٓ����R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoChangeContent(){

  }

  /**
   * �ٓ����R���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoChangeContentModel(){

  }

  /**
   * ���t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoDate(){

  }

  /**
   * ���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoTime(){

  }

  /**
   * ���R/�󋵂ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoReason(){

  }

  /**
   * ���R/�󋵃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoReasonModel(){

  }

  /**
   * ���̑��@���e�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoReasonMemo(){

  }

  /**
   * (�ٓ����E�{�^���̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoButtons(){

    idouInfoButtons.add(getIdouInfoButtonDelete(), VRLayout.EAST);
    idouInfoButtons.add(getIdouInfoButtonEdit(), VRLayout.EAST);
    idouInfoButtons.add(getIdouInfoButtonInsert(), VRLayout.EAST);
    idouInfoButtons.add(getIdouInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoButtonClear(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoButtonInsert(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoButtonEdit(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoButtonDelete(){

  }

  /**
   * (�ٓ����E�e�[�u���̈�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoTable(){

  }

  /**
   * (�ٓ����E�e�[�u���̈�)�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoTableColumnModel(){

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn0());

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn1());

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn2());

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn3());

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn4());

    getIdouInfoTableColumnModel().addColumn(getIdouInfoTableColumn5());

  }

  /**
   * No�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoTableColumn0(){

  }

  /**
   * �T�[�r�X�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoTableColumn1(){

  }

  /**
   * �ٓ����R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoTableColumn2(){

  }

  /**
   * ���t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoTableColumn3(){

  }

  /**
   * ���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoTableColumn4(){

  }

  /**
   * ���R/�󋵂ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoTableColumn5(){

  }

  /**
   * (�{�ݏ��E�̈�E�O���[�v)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfos(){

    institutionInfos.add(getInstitutionInfoBearMoneyInfos(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoSpace1(), VRLayout.FLOW);

    institutionInfos.add(getInstitutionInfoTokuteiNyusho(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoSpace2(), VRLayout.FLOW);

    institutionInfos.add(getInstitutionInfoDinnerBearLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoUnitRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoUnitSemiRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoNormalRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoNormalRoomLimitMoneyContena2(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoTasyoRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    institutionInfos.add(getInstitutionInfoCareOldPersonLabel(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoSpace3(), VRLayout.FLOW);

    institutionInfos.add(getInstitutionInfoOldStep(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoCareOldPersonInsuranceLabel(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoSpace4(), VRLayout.FLOW);

    institutionInfos.add(getInstitutionInfoMainDiseaseContainer(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoSpace5(), VRLayout.FLOW_RETURN);

    institutionInfos.add(getInstitutionInfoExplanationGroup(), VRLayout.FLOW);

  }

  /**
   * (�{�ݏ��̈�E���C�A�E�g)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoLayout(){

  }

  /**
   * ���p�ҕ��S���x�z���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoBearMoneyInfos(){

  }

  /**
   * �X�y�[�X1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoSpace1(){

  }

  /**
   * ��������҃`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoTokuteiNyusho(){

  }

  /**
   * �X�y�[�X2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoSpace2(){

  }

  /**
   * �i�H��S���x�z�E�R���e�i�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoDinnerBearLimitMoneyContena(){

    institutionInfoDinnerBearLimitMoneyContena.add(getInstitutionInfoDinnerBearLimitMoneyText(), null);

    institutionInfoDinnerBearLimitMoneyContena.add(getInstitutionInfoDinnerBearLimitMoneyLabel(), null);

  }

  /**
   * �H��S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoDinnerBearLimitMoneyText(){

  }

  /**
   * �H��S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoDinnerBearLimitMoneyLabel(){

  }

  /**
   * �i���j�b�g�^�����S���x�z�E�R���e�i�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoUnitRoomLimitMoneyContena(){

    institutionInfoUnitRoomLimitMoneyContena.add(getInstitutionInfoUnitRoomLimitMoneyText(), null);

    institutionInfoUnitRoomLimitMoneyContena.add(getInstitutionInfoUnitRoomLimitMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^�����S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoUnitRoomLimitMoneyText(){

  }

  /**
   * ���j�b�g�^�����S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoUnitRoomLimitMoneyLabel(){

  }

  /**
   * �i���j�b�g�^�������S���x�z�E�R���e�i�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoUnitSemiRoomLimitMoneyContena(){

    institutionInfoUnitSemiRoomLimitMoneyContena.add(getInstitutionInfoUnitSemiRoomLimitMoneyText(), null);

    institutionInfoUnitSemiRoomLimitMoneyContena.add(getInstitutionInfoUnitSemiRoomLimitMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^�������S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoUnitSemiRoomLimitMoneyText(){

  }

  /**
   * ���j�b�g�^�������S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoUnitSemiRoomLimitMoneyLabel(){

  }

  /**
   * �i�]���^���i���{���j���S���x�z�E�R���e�i�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyContena(){

    institutionInfoNormalRoomLimitMoneyContena.add(getInstitutionInfoNormalRoomLimitMoneyText(), null);

    institutionInfoNormalRoomLimitMoneyContena.add(getInstitutionInfoNormalRoomLimitMoneyLabel(), null);

  }

  /**
   * �]���^���i���{���j���S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyText(){

  }

  /**
   * �]���^���i���{���j���S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyLabel(){

  }

  /**
   * �i�]���^���i�V���E�×{���j���S���x�z�E�R���e�i�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyContena2(){

    institutionInfoNormalRoomLimitMoneyContena2.add(getInstitutionInfoNormalRoomLimitMoneyText2(), null);

    institutionInfoNormalRoomLimitMoneyContena2.add(getInstitutionInfoNormalRoomLimitMoneyLabel2(), null);

  }

  /**
   * �]���^���i�V���E�×{���j���S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyText2(){

  }

  /**
   * �]���^���i�V���E�×{���j���S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoNormalRoomLimitMoneyLabel2(){

  }

  /**
   * �i���������S���x�z�E�R���e�i�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoTasyoRoomLimitMoneyContena(){

    institutionInfoTasyoRoomLimitMoneyContena.add(getInstitutionInfoTasyoRoomLimitMoneyText(), null);

    institutionInfoTasyoRoomLimitMoneyContena.add(getInstitutionInfoTasyoRoomLimitMoneyLabel(), null);

  }

  /**
   * ���������S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoTasyoRoomLimitMoneyText(){

  }

  /**
   * ���������S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoTasyoRoomLimitMoneyLabel(){

  }

  /**
   * ���V�l�����{�݁E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoCareOldPersonLabel(){

  }

  /**
   * �X�y�[�X3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoSpace3(){

  }

  /**
   * ���[�u�����ғ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoOldStep(){

  }

  /**
   * ���V�l�ی��{�݁E���×{�^��Î{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoCareOldPersonInsuranceLabel(){

  }

  /**
   * �X�y�[�X4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoSpace4(){

  }

  /**
   * �叝�a�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoMainDisease(){

  }

  /**
   * �X�y�[�X5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoSpace5(){

  }

  /**
   * (�������O���[�v)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoExplanationGroup(){

    institutionInfoExplanationGroup.add(getInstitutionInfoExplanationLabel1(), VRLayout.NORTH);

    institutionInfoExplanationGroup.add(getInstitutionInfoExplanationLabel2(), VRLayout.NORTH);

    institutionInfoExplanationGroup.add(getInstitutionInfoExplanationLabel3(), VRLayout.NORTH);

  }

  /**
   * ���������x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoExplanationLabel1(){

  }

  /**
   * ���������x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoExplanationLabel2(){

  }

  /**
   * ���������x��3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInstitutionInfoExplanationLabel3(){

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
      ACFrame.debugStart(new ACAffairInfo(QU002Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QU002Design getThis() {
    return this;
  }
}
