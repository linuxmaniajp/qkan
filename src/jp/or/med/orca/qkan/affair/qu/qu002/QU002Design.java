
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
 * �쐬��: 2018/02/21  ���{�R���s���[�^�[������� �����F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���p�ғo�^/�C�� (U)
 * �v���Z�X ���p�ғo�^ (002)
 * �v���O���� ���p�ғo�^ (QU002)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu002;
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
 * ���p�ғo�^��ʍ��ڃf�U�C��(QU002) 
 */
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

  private ACTextField yokaigodoNow;

  private ACLabelContainer yokaigodoNowContainer;

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

  private ACTextField kaigoInfoInsuredId;

  private ACLabelContainer kaigoInfoInsuredIdContainer;

  private ACLabelContainer kaigoInfoBenefitContainer;

  private ACTextField kaigoInfoBenefit;

  private ACLabel kaigoInfoBenefitPercent;

  private ACLabelContainer kaigoInfoShortCounts;

  private ACTextField kaigoInfoShortCount;

  private ACLabel kaigoInfoShortCountDay;

  private ACLabelContainer kaigoInfoKyotakuServiceContena;

  private VRLayout kaigoInfoKyotakuServiceContenaLayout;

  private ACClearableRadioButtonGroup kaigoInfoKyotakuServiceRadio;

  private ACListModelAdapter kaigoInfoKyotakuServiceRadioModel;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem1;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem2;

  private ACRadioButtonItem kaigoInfoKyotakuServiceRadioItem3;

  private QkanDateTextField kaigoInfoReportDate;

  private ACLabelContainer kaigoInfoReportDateContainer;

  private ACComboBox kaigoInfoKyotakuServicePlanCombo;

  private ACComboBoxModelAdapter kaigoInfoKyotakuServicePlanComboModel;

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

  private ACLabelContainer kaigoInfoLimitChanges;

  private ACIntegerCheckBox kaigoInfoLimitChange;

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

  private ACLabelContainer kaigoInfoSystemValidLimits;

  private QkanDateTextField kaigoInfoSystemValidLimit1;

  private ACLabel kaigoInfoSystemValidLimit2;

  private QkanDateTextField kaigoInfoSystemValidLimit3;

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

  private ACTableColumn kaigoInfoTableColumn10;

  private ACTableColumn kaigoInfoTableColumn11;

  private ACTableColumn kaigoInfoTableColumn12;

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

  private ACPanel shisetsuInfoPanel;

  private ACPanel shisetsuInputPanel;

  private ACPanel shisetsuInfSyokuhiPanel;

  private ACGroupBox shisetsuInfoSyokuhiGroup;

  private VRLayout shisetsuInfoSyokuhiLayout;

  private ACLabel shisetsuInfoSpaceLabel;

  private ACIntegerCheckBox shisetsuInfoTokuteiCheck;

  private ACLabelContainer shisetsuInfoDinnerBearLimitMoneyContena;

  private ACTextField shisetsuInfoDinnerBearLimitMoneyText;

  private ACLabel shisetsuInfoDinnerBearLimitMoneyLabel;

  private ACLabelContainer shisetsuInfoUnitRoomLimitMoneyContena;

  private ACTextField shisetsuInfoUnitRoomLimitMoneyText;

  private ACLabel shisetsuInfoUnitRoomLimitMoneyLabel;

  private ACLabelContainer shisetsuInfoUnitSemiRoomLimitMoneyContena;

  private ACTextField shisetsuInfoUnitSemiRoomLimitMoneyText;

  private ACLabel shisetsuInfoUnitSemiRoomLimitMoneyLabel;

  private ACLabelContainer shisetsuInfoNormalRoomLimitMoneyContena;

  private ACTextField shisetsuInfoNormalRoomLimitMoneyText;

  private ACLabel shisetsuInfoNormalRoomLimitMoneyLabel;

  private ACLabelContainer shisetsuInfoNormalRoomLimitMoneyContena2;

  private ACTextField shisetsuInfoNormalRoomLimitMoneyText2;

  private ACLabel shisetsuInfoNormalRoomLimitMoneyLabel2;

  private ACLabelContainer shisetsuInfoTasyoRoomLimitMoneyContena;

  private ACTextField shisetsuInfoTasyoRoomLimitMoneyText;

  private ACLabel shisetsuInfoTasyoRoomLimitMoneyLabel;

  private ACLabelContainer shisetsuInfoTasyoRoomLimitMoneyContena2;

  private ACTextField shisetsuInfoTasyoRoomLimitMoneyText2;

  private ACLabel shisetsuInfoTasyoRoomLimitMoneyLabel2;

  private ACPanel shisetsuInfRigthtPanel;

  private ACGroupBox shisetsuInfoCareOldPersonGroup;

  private ACIntegerCheckBox shisetsuInfoOldStep;

  private ACGroupBox shisetsuInfoCareOldPersonInsuranceGroup;

  private ACTextField shisetsuInfoMainDisease;

  private ACLabelContainer shisetsuInfoMainDiseaseContainer;

  private ACGroupBox shisetsuInfoExplanationGroup;

  private ACLabel shisetsuInfoExplanationLabel1;

  private ACLabel shisetsuInfoExplanationLabel2;

  private ACPanel shisetsuInfoOtherPanel;

  private VRLayout shisetsuInfoOtherLayout;

  private ACPanel shisetsuInfoLimitPanel;

  private ACLabelContainer shisetsuInfoValidLimitContainer;

  private QkanDateTextField shisetsuInfoValidLimitDateStart;

  private ACLabel shisetsuInfoValidLimitLabel;

  private QkanDateTextField shisetsuInfoValidLimitDateEnd;

  private ACPanel shisetsuInfoButtons;

  private ACButton shisetsuInfoButtonClear;

  private ACButton shisetsuInfoButtonInsert;

  private ACButton shisetsuInfoButtonEdit;

  private ACButton shisetsuInfoButtonDelete;

  private ACTable shisetsuInfoTable;

  private VRTableColumnModel shisetsuInfoTableColumnModel;

  private ACTableColumn shisetsuInfoTableColumn0;

  private ACTableColumn shisetsuInfoTableColumn1;

  private ACTableColumn shisetsuInfoTableColumn2;

  private ACTableColumn shisetsuInfoTableColumn3;

  private ACTableColumn shisetsuInfoTableColumn4;

  private ACTableColumn shisetsuInfoTableColumn5;

  private ACPanel jushotiTokureiInfoPanel;

  private ACPanel jushotiTokureiInputPanel;

  private ACGroupBox jushotiTokureiInfoGroup;

  private VRLayout jushotiTokureiInfoLayout2;

  private ACTextField jushotiTokureiInfoInsurerId;

  private ACLabelContainer jushotiTokureiInfoInsurerIdContainer;

  private ACComboBox jushotiTokureiInfoInsurerName;

  private ACLabelContainer jushotiTokureiInfoInsurerNameContainer;

  private ACComboBoxModelAdapter jushotiTokureiInfoInsurerNameModel;

  private ACPanel jushotiTokureiInfoLimitPanel;

  private ACLabelContainer jushotiTokureiInfoValidLimitContainer;

  private QkanDateTextField jushotiTokureiInfoValidLimitDateStart;

  private ACLabel jushotiTokureiInfoValidLimitLabel;

  private QkanDateTextField jushotiTokureiInfoValidLimitDateEnd;

  private ACPanel jushotiTokureiInfoButtons;

  private ACButton jushotiTokureiInfoButtonClear;

  private ACButton jushotiTokureiInfoButtonInsert;

  private ACButton jushotiTokureiInfoButtonEdit;

  private ACButton jushotiTokureiInfoButtonDelete;

  private ACTable jushotiTokureiInfoTable;

  private VRTableColumnModel jushotiTokureiInfoTableColumnModel;

  private ACTableColumn jushotiTokureiInfoTableColumn0;

  private ACTableColumn jushotiTokureiInfoTableColumn1;

  private ACTableColumn jushotiTokureiInfoTableColumn2;

  private ACTableColumn jushotiTokureiInfoTableColumn3;

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
   * (�Z���������p�����̏����l�E�R���e�i)���擾���܂��B
   * @return (�Z���������p�����̏����l�E�R���e�i)
   */
  public ACLabelContainer getKaigoInfoShortCounts(){
    if(kaigoInfoShortCounts==null){

      kaigoInfoShortCounts = new ACLabelContainer();

      kaigoInfoShortCounts.setText("�Z���������p�����̏����l");

      addKaigoInfoShortCounts();
    }
    return kaigoInfoShortCounts;

  }

  /**
   * �Z���������p�����̏����l���擾���܂��B
   * @return �Z���������p�����̏����l
   */
  public ACTextField getKaigoInfoShortCount(){
    if(kaigoInfoShortCount==null){

      kaigoInfoShortCount = new ACTextField();

      kaigoInfoShortCount.setBindPath("SHORTSTAY_USE_INIT_COUNT");

      kaigoInfoShortCount.setColumns(3);

      kaigoInfoShortCount.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoShortCount.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoShortCount.setMaxLength(3);

      addKaigoInfoShortCount();
    }
    return kaigoInfoShortCount;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getKaigoInfoShortCountDay(){
    if(kaigoInfoShortCountDay==null){

      kaigoInfoShortCountDay = new ACLabel();

      kaigoInfoShortCountDay.setText(" ��");

      addKaigoInfoShortCountDay();
    }
    return kaigoInfoShortCountDay;

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

      kaigoInfoKyotakuServiceContenaLayout.setAutoWrap(false);

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

      kaigoInfoValidLimits.setText("�F��L������");

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
   * (�v�x���P�̊z�𒴂��ăT�[�r�X�𗘗p�E�R���e�i)���擾���܂��B
   * @return (�v�x���P�̊z�𒴂��ăT�[�r�X�𗘗p�E�R���e�i)
   */
  public ACLabelContainer getKaigoInfoLimitChanges(){
    if(kaigoInfoLimitChanges==null){

      kaigoInfoLimitChanges = new ACLabelContainer();

      addKaigoInfoLimitChanges();
    }
    return kaigoInfoLimitChanges;

  }

  /**
   * �v�x���P�̊z�𒴂��ăT�[�r�X�𗘗p���擾���܂��B
   * @return �v�x���P�̊z�𒴂��ăT�[�r�X�𗘗p
   */
  public ACIntegerCheckBox getKaigoInfoLimitChange(){
    if(kaigoInfoLimitChange==null){

      kaigoInfoLimitChange = new ACIntegerCheckBox();

      kaigoInfoLimitChange.setText("�v�x���P�̊z�𒴂��ăT�[�r�X�𗘗p");

      kaigoInfoLimitChange.setBindPath("LIMIT_CHANGE_FLAG");

      kaigoInfoLimitChange.setSelectValue(2);

      kaigoInfoLimitChange.setUnSelectValue(1);

      addKaigoInfoLimitChange();
    }
    return kaigoInfoLimitChange;

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
   * (�L�����ԁE�R���e�i)���擾���܂��B
   * @return (�L�����ԁE�R���e�i)
   */
  public ACLabelContainer getKaigoInfoSystemValidLimits(){
    if(kaigoInfoSystemValidLimits==null){

      kaigoInfoSystemValidLimits = new ACLabelContainer();

      kaigoInfoSystemValidLimits.setText("�V�X�e���L������");

      addKaigoInfoSystemValidLimits();
    }
    return kaigoInfoSystemValidLimits;

  }

  /**
   * �L�����ԁE�e�L�X�g1���擾���܂��B
   * @return �L�����ԁE�e�L�X�g1
   */
  public QkanDateTextField getKaigoInfoSystemValidLimit1(){
    if(kaigoInfoSystemValidLimit1==null){

      kaigoInfoSystemValidLimit1 = new QkanDateTextField();

      kaigoInfoSystemValidLimit1.setBindPath("SYSTEM_INSURE_VALID_START");

      addKaigoInfoSystemValidLimit1();
    }
    return kaigoInfoSystemValidLimit1;

  }

  /**
   * �L�����ԁE���x�����擾���܂��B
   * @return �L�����ԁE���x��
   */
  public ACLabel getKaigoInfoSystemValidLimit2(){
    if(kaigoInfoSystemValidLimit2==null){

      kaigoInfoSystemValidLimit2 = new ACLabel();

      kaigoInfoSystemValidLimit2.setText(" ���� ");

      addKaigoInfoSystemValidLimit2();
    }
    return kaigoInfoSystemValidLimit2;

  }

  /**
   * �L�����ԁE�e�L�X�g2���擾���܂��B
   * @return �L�����ԁE�e�L�X�g2
   */
  public QkanDateTextField getKaigoInfoSystemValidLimit3(){
    if(kaigoInfoSystemValidLimit3==null){

      kaigoInfoSystemValidLimit3 = new QkanDateTextField();

      kaigoInfoSystemValidLimit3.setBindPath("SYSTEM_INSURE_VALID_END");

      addKaigoInfoSystemValidLimit3();
    }
    return kaigoInfoSystemValidLimit3;

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
   * �V�X�e���L���J�n���擾���܂��B
   * @return �V�X�e���L���J�n
   */
  public ACTableColumn getKaigoInfoTableColumn1(){
    if(kaigoInfoTableColumn1==null){

      kaigoInfoTableColumn1 = new ACTableColumn(0);

      kaigoInfoTableColumn1.setHeaderValue("�V�X�e���L���J�n");

      kaigoInfoTableColumn1.setColumns(10);

      kaigoInfoTableColumn1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn1();
    }
    return kaigoInfoTableColumn1;

  }

  /**
   * �V�X�e���L���I�����擾���܂��B
   * @return �V�X�e���L���I��
   */
  public ACTableColumn getKaigoInfoTableColumn2(){
    if(kaigoInfoTableColumn2==null){

      kaigoInfoTableColumn2 = new ACTableColumn(1);

      kaigoInfoTableColumn2.setHeaderValue("�V�X�e���L���I��");

      kaigoInfoTableColumn2.setColumns(10);

      kaigoInfoTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn2();
    }
    return kaigoInfoTableColumn2;

  }

  /**
   * ���t�����擾���܂��B
   * @return ���t��
   */
  public ACTableColumn getKaigoInfoTableColumn3(){
    if(kaigoInfoTableColumn3==null){

      kaigoInfoTableColumn3 = new ACTableColumn(2);

      kaigoInfoTableColumn3.setHeaderValue("���t��");

      kaigoInfoTableColumn3.setColumns(4);

      kaigoInfoTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addKaigoInfoTableColumn3();
    }
    return kaigoInfoTableColumn3;

  }

  /**
   * �\�������擾���܂��B
   * @return �\����
   */
  public ACTableColumn getKaigoInfoTableColumn4(){
    if(kaigoInfoTableColumn4==null){

      kaigoInfoTableColumn4 = new ACTableColumn(3);

      kaigoInfoTableColumn4.setHeaderValue("�\����");

      kaigoInfoTableColumn4.setColumns(10);

      kaigoInfoTableColumn4.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn4();
    }
    return kaigoInfoTableColumn4;

  }

  /**
   * �\���敪���擾���܂��B
   * @return �\���敪
   */
  public ACTableColumn getKaigoInfoTableColumn5(){
    if(kaigoInfoTableColumn5==null){

      kaigoInfoTableColumn5 = new ACTableColumn(4);

      kaigoInfoTableColumn5.setHeaderValue("�\���敪");

      kaigoInfoTableColumn5.setColumns(10);

      addKaigoInfoTableColumn5();
    }
    return kaigoInfoTableColumn5;

  }

  /**
   * �v�������擾���܂��B
   * @return �v�����
   */
  public ACTableColumn getKaigoInfoTableColumn6(){
    if(kaigoInfoTableColumn6==null){

      kaigoInfoTableColumn6 = new ACTableColumn(5);

      kaigoInfoTableColumn6.setHeaderValue("�v���x");

      kaigoInfoTableColumn6.setColumns(7);

      addKaigoInfoTableColumn6();
    }
    return kaigoInfoTableColumn6;

  }

  /**
   * �F��L�����ԊJ�n���擾���܂��B
   * @return �F��L�����ԊJ�n
   */
  public ACTableColumn getKaigoInfoTableColumn7(){
    if(kaigoInfoTableColumn7==null){

      kaigoInfoTableColumn7 = new ACTableColumn(6);

      kaigoInfoTableColumn7.setHeaderValue("�L�����ԊJ�n��");

      kaigoInfoTableColumn7.setColumns(10);

      kaigoInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn7();
    }
    return kaigoInfoTableColumn7;

  }

  /**
   * �F��L�����ԏI�����擾���܂��B
   * @return �F��L�����ԏI��
   */
  public ACTableColumn getKaigoInfoTableColumn8(){
    if(kaigoInfoTableColumn8==null){

      kaigoInfoTableColumn8 = new ACTableColumn(7);

      kaigoInfoTableColumn8.setHeaderValue("�L�����ԏI����");

      kaigoInfoTableColumn8.setColumns(10);

      kaigoInfoTableColumn8.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn8();
    }
    return kaigoInfoTableColumn8;

  }

  /**
   * �쐬�˗��͏o�����擾���܂��B
   * @return �쐬�˗��͏o��
   */
  public ACTableColumn getKaigoInfoTableColumn9(){
    if(kaigoInfoTableColumn9==null){

      kaigoInfoTableColumn9 = new ACTableColumn(8);

      kaigoInfoTableColumn9.setHeaderValue("�쐬�˗��͏o��");

      kaigoInfoTableColumn9.setColumns(10);

      kaigoInfoTableColumn9.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn9();
    }
    return kaigoInfoTableColumn9;

  }

  /**
   * ���f�N�������擾���܂��B
   * @return ���f�N����
   */
  public ACTableColumn getKaigoInfoTableColumn10(){
    if(kaigoInfoTableColumn10==null){

      kaigoInfoTableColumn10 = new ACTableColumn(9);

      kaigoInfoTableColumn10.setHeaderValue("���f�N����");

      kaigoInfoTableColumn10.setColumns(10);

      kaigoInfoTableColumn10.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addKaigoInfoTableColumn10();
    }
    return kaigoInfoTableColumn10;

  }

  /**
   * ���f���R���擾���܂��B
   * @return ���f���R
   */
  public ACTableColumn getKaigoInfoTableColumn11(){
    if(kaigoInfoTableColumn11==null){

      kaigoInfoTableColumn11 = new ACTableColumn(10);

      kaigoInfoTableColumn11.setHeaderValue("���f���R");

      kaigoInfoTableColumn11.setColumns(6);

      addKaigoInfoTableColumn11();
    }
    return kaigoInfoTableColumn11;

  }

  /**
   * �x�����x�z���擾���܂��B
   * @return �x�����x�z
   */
  public ACTableColumn getKaigoInfoTableColumn12(){
    if(kaigoInfoTableColumn12==null){

      kaigoInfoTableColumn12 = new ACTableColumn(11);

      kaigoInfoTableColumn12.setHeaderValue("�x�����x�z");

      kaigoInfoTableColumn12.setColumns(7);

      kaigoInfoTableColumn12.setHorizontalAlignment(SwingConstants.RIGHT);

      addKaigoInfoTableColumn12();
    }
    return kaigoInfoTableColumn12;

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
   * ��������ҏ��E�p�l�����擾���܂��B
   * @return ��������ҏ��E�p�l��
   */
  public ACPanel getShisetsuInfoPanel(){
    if(shisetsuInfoPanel==null){

      shisetsuInfoPanel = new ACPanel();

      addShisetsuInfoPanel();
    }
    return shisetsuInfoPanel;

  }

  /**
   * ��������ғ��͗̈�E�p�l�����擾���܂��B
   * @return ��������ғ��͗̈�E�p�l��
   */
  public ACPanel getShisetsuInputPanel(){
    if(shisetsuInputPanel==null){

      shisetsuInputPanel = new ACPanel();

      addShisetsuInputPanel();
    }
    return shisetsuInputPanel;

  }

  /**
   * �H��Z��E�p�l�����擾���܂��B
   * @return �H��Z��E�p�l��
   */
  public ACPanel getShisetsuInfSyokuhiPanel(){
    if(shisetsuInfSyokuhiPanel==null){

      shisetsuInfSyokuhiPanel = new ACPanel();

      addShisetsuInfSyokuhiPanel();
    }
    return shisetsuInfSyokuhiPanel;

  }

  /**
   * �H��Z��E�O���[�v���擾���܂��B
   * @return �H��Z��E�O���[�v
   */
  public ACGroupBox getShisetsuInfoSyokuhiGroup(){
    if(shisetsuInfoSyokuhiGroup==null){

      shisetsuInfoSyokuhiGroup = new ACGroupBox();

      shisetsuInfoSyokuhiGroup.setText("���p�ҕ��S���x�z");

      shisetsuInfoSyokuhiGroup.setLayout(getShisetsuInfoSyokuhiLayout());

      addShisetsuInfoSyokuhiGroup();
    }
    return shisetsuInfoSyokuhiGroup;

  }

  /**
   * �H��E���Z��̈�E���C�A�E�g���擾���܂��B
   * @return �H��E���Z��̈�E���C�A�E�g
   */
  public VRLayout getShisetsuInfoSyokuhiLayout(){
    if(shisetsuInfoSyokuhiLayout==null){

      shisetsuInfoSyokuhiLayout = new VRLayout();

      shisetsuInfoSyokuhiLayout.setAutoWrap(false);

      shisetsuInfoSyokuhiLayout.setHgap(0);

      shisetsuInfoSyokuhiLayout.setLabelMargin(0);

      shisetsuInfoSyokuhiLayout.setVgap(5);

      shisetsuInfoSyokuhiLayout.setHgrid(150);

      addShisetsuInfoSyokuhiLayout();
    }
    return shisetsuInfoSyokuhiLayout;

  }

  /**
   * ��������X�y�[�T�[���擾���܂��B
   * @return ��������X�y�[�T�[
   */
  public ACLabel getShisetsuInfoSpaceLabel(){
    if(shisetsuInfoSpaceLabel==null){

      shisetsuInfoSpaceLabel = new ACLabel();

      shisetsuInfoSpaceLabel.setText("�@");

      addShisetsuInfoSpaceLabel();
    }
    return shisetsuInfoSpaceLabel;

  }

  /**
   * ��������҃`�F�b�N���擾���܂��B
   * @return ��������҃`�F�b�N
   */
  public ACIntegerCheckBox getShisetsuInfoTokuteiCheck(){
    if(shisetsuInfoTokuteiCheck==null){

      shisetsuInfoTokuteiCheck = new ACIntegerCheckBox();

      shisetsuInfoTokuteiCheck.setText("���������");

      shisetsuInfoTokuteiCheck.setBindPath("TOKUTEI_NYUSHO_FLAG");

      shisetsuInfoTokuteiCheck.setSelectValue(2);

      shisetsuInfoTokuteiCheck.setUnSelectValue(1);

      addShisetsuInfoTokuteiCheck();
    }
    return shisetsuInfoTokuteiCheck;

  }

  /**
   * �H��S���x�z�E�R���e�i���擾���܂��B
   * @return �H��S���x�z�E�R���e�i
   */
  public ACLabelContainer getShisetsuInfoDinnerBearLimitMoneyContena(){
    if(shisetsuInfoDinnerBearLimitMoneyContena==null){

      shisetsuInfoDinnerBearLimitMoneyContena = new ACLabelContainer();

      shisetsuInfoDinnerBearLimitMoneyContena.setText("�H��");

      addShisetsuInfoDinnerBearLimitMoneyContena();
    }
    return shisetsuInfoDinnerBearLimitMoneyContena;

  }

  /**
   * �H��S���x�z�E�e�L�X�g���擾���܂��B
   * @return �H��S���x�z�E�e�L�X�g
   */
  public ACTextField getShisetsuInfoDinnerBearLimitMoneyText(){
    if(shisetsuInfoDinnerBearLimitMoneyText==null){

      shisetsuInfoDinnerBearLimitMoneyText = new ACTextField();

      shisetsuInfoDinnerBearLimitMoneyText.setBindPath("LIMIT_SHOKUHI");

      shisetsuInfoDinnerBearLimitMoneyText.setColumns(4);

      shisetsuInfoDinnerBearLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoDinnerBearLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoDinnerBearLimitMoneyText.setIMEMode(InputSubset.LATIN);

      shisetsuInfoDinnerBearLimitMoneyText.setMaxLength(4);

      addShisetsuInfoDinnerBearLimitMoneyText();
    }
    return shisetsuInfoDinnerBearLimitMoneyText;

  }

  /**
   * �H��S���x�z�E���x�����擾���܂��B
   * @return �H��S���x�z�E���x��
   */
  public ACLabel getShisetsuInfoDinnerBearLimitMoneyLabel(){
    if(shisetsuInfoDinnerBearLimitMoneyLabel==null){

      shisetsuInfoDinnerBearLimitMoneyLabel = new ACLabel();

      shisetsuInfoDinnerBearLimitMoneyLabel.setText("(�~)");

      addShisetsuInfoDinnerBearLimitMoneyLabel();
    }
    return shisetsuInfoDinnerBearLimitMoneyLabel;

  }

  /**
   * ���j�b�g�^�����S���x�z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^�����S���x�z�E�R���e�i
   */
  public ACLabelContainer getShisetsuInfoUnitRoomLimitMoneyContena(){
    if(shisetsuInfoUnitRoomLimitMoneyContena==null){

      shisetsuInfoUnitRoomLimitMoneyContena = new ACLabelContainer();

      shisetsuInfoUnitRoomLimitMoneyContena.setText("���j�b�g�^��");

      addShisetsuInfoUnitRoomLimitMoneyContena();
    }
    return shisetsuInfoUnitRoomLimitMoneyContena;

  }

  /**
   * ���j�b�g�^�����S���x�z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^�����S���x�z�E�e�L�X�g
   */
  public ACTextField getShisetsuInfoUnitRoomLimitMoneyText(){
    if(shisetsuInfoUnitRoomLimitMoneyText==null){

      shisetsuInfoUnitRoomLimitMoneyText = new ACTextField();

      shisetsuInfoUnitRoomLimitMoneyText.setBindPath("LIMIT_UNIT_KOSHITSU");

      shisetsuInfoUnitRoomLimitMoneyText.setColumns(4);

      shisetsuInfoUnitRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoUnitRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoUnitRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      shisetsuInfoUnitRoomLimitMoneyText.setMaxLength(4);

      addShisetsuInfoUnitRoomLimitMoneyText();
    }
    return shisetsuInfoUnitRoomLimitMoneyText;

  }

  /**
   * ���j�b�g�^�����S���x�z�E���x�����擾���܂��B
   * @return ���j�b�g�^�����S���x�z�E���x��
   */
  public ACLabel getShisetsuInfoUnitRoomLimitMoneyLabel(){
    if(shisetsuInfoUnitRoomLimitMoneyLabel==null){

      shisetsuInfoUnitRoomLimitMoneyLabel = new ACLabel();

      shisetsuInfoUnitRoomLimitMoneyLabel.setText("(�~)");

      addShisetsuInfoUnitRoomLimitMoneyLabel();
    }
    return shisetsuInfoUnitRoomLimitMoneyLabel;

  }

  /**
   * ���j�b�g�^���I���������S���x�z�E�R���e�i���擾���܂��B
   * @return ���j�b�g�^���I���������S���x�z�E�R���e�i
   */
  public ACLabelContainer getShisetsuInfoUnitSemiRoomLimitMoneyContena(){
    if(shisetsuInfoUnitSemiRoomLimitMoneyContena==null){

      shisetsuInfoUnitSemiRoomLimitMoneyContena = new ACLabelContainer();

      shisetsuInfoUnitSemiRoomLimitMoneyContena.setText("���j�b�g�^���I������");

      addShisetsuInfoUnitSemiRoomLimitMoneyContena();
    }
    return shisetsuInfoUnitSemiRoomLimitMoneyContena;

  }

  /**
   * ���j�b�g�^���I���������S���x�z�E�e�L�X�g���擾���܂��B
   * @return ���j�b�g�^���I���������S���x�z�E�e�L�X�g
   */
  public ACTextField getShisetsuInfoUnitSemiRoomLimitMoneyText(){
    if(shisetsuInfoUnitSemiRoomLimitMoneyText==null){

      shisetsuInfoUnitSemiRoomLimitMoneyText = new ACTextField();

      shisetsuInfoUnitSemiRoomLimitMoneyText.setBindPath("LIMIT_UNIT_JUNKOSHITSU");

      shisetsuInfoUnitSemiRoomLimitMoneyText.setColumns(4);

      shisetsuInfoUnitSemiRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoUnitSemiRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoUnitSemiRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      shisetsuInfoUnitSemiRoomLimitMoneyText.setMaxLength(4);

      addShisetsuInfoUnitSemiRoomLimitMoneyText();
    }
    return shisetsuInfoUnitSemiRoomLimitMoneyText;

  }

  /**
   * ���j�b�g�^���I���������S���x�z�E���x�����擾���܂��B
   * @return ���j�b�g�^���I���������S���x�z�E���x��
   */
  public ACLabel getShisetsuInfoUnitSemiRoomLimitMoneyLabel(){
    if(shisetsuInfoUnitSemiRoomLimitMoneyLabel==null){

      shisetsuInfoUnitSemiRoomLimitMoneyLabel = new ACLabel();

      shisetsuInfoUnitSemiRoomLimitMoneyLabel.setText("(�~)");

      addShisetsuInfoUnitSemiRoomLimitMoneyLabel();
    }
    return shisetsuInfoUnitSemiRoomLimitMoneyLabel;

  }

  /**
   * �]���^�����{�����S���x�z�E�R���e�i���擾���܂��B
   * @return �]���^�����{�����S���x�z�E�R���e�i
   */
  public ACLabelContainer getShisetsuInfoNormalRoomLimitMoneyContena(){
    if(shisetsuInfoNormalRoomLimitMoneyContena==null){

      shisetsuInfoNormalRoomLimitMoneyContena = new ACLabelContainer();

      shisetsuInfoNormalRoomLimitMoneyContena.setText("�]���^��(���{��)");

      addShisetsuInfoNormalRoomLimitMoneyContena();
    }
    return shisetsuInfoNormalRoomLimitMoneyContena;

  }

  /**
   * �]���^�����{�����S���x�z�E�e�L�X�g���擾���܂��B
   * @return �]���^�����{�����S���x�z�E�e�L�X�g
   */
  public ACTextField getShisetsuInfoNormalRoomLimitMoneyText(){
    if(shisetsuInfoNormalRoomLimitMoneyText==null){

      shisetsuInfoNormalRoomLimitMoneyText = new ACTextField();

      shisetsuInfoNormalRoomLimitMoneyText.setBindPath("LIMIT_JURAIGATA1");

      shisetsuInfoNormalRoomLimitMoneyText.setColumns(4);

      shisetsuInfoNormalRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoNormalRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoNormalRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      shisetsuInfoNormalRoomLimitMoneyText.setMaxLength(4);

      addShisetsuInfoNormalRoomLimitMoneyText();
    }
    return shisetsuInfoNormalRoomLimitMoneyText;

  }

  /**
   * �]���^�����{�����S���x�z�E���x�����擾���܂��B
   * @return �]���^�����{�����S���x�z�E���x��
   */
  public ACLabel getShisetsuInfoNormalRoomLimitMoneyLabel(){
    if(shisetsuInfoNormalRoomLimitMoneyLabel==null){

      shisetsuInfoNormalRoomLimitMoneyLabel = new ACLabel();

      shisetsuInfoNormalRoomLimitMoneyLabel.setText("(�~)");

      addShisetsuInfoNormalRoomLimitMoneyLabel();
    }
    return shisetsuInfoNormalRoomLimitMoneyLabel;

  }

  /**
   * �]���^���V���E�×{�E����É@�����S���x�z�E�R���e�i���擾���܂��B
   * @return �]���^���V���E�×{�E����É@�����S���x�z�E�R���e�i
   */
  public ACLabelContainer getShisetsuInfoNormalRoomLimitMoneyContena2(){
    if(shisetsuInfoNormalRoomLimitMoneyContena2==null){

      shisetsuInfoNormalRoomLimitMoneyContena2 = new ACLabelContainer();

      shisetsuInfoNormalRoomLimitMoneyContena2.setText("�]���^��(�V���E�×{�E����É@��)");

      addShisetsuInfoNormalRoomLimitMoneyContena2();
    }
    return shisetsuInfoNormalRoomLimitMoneyContena2;

  }

  /**
   * �]���^���V���E�×{�E����É@�����S���x�z�E�e�L�X�g���擾���܂��B
   * @return �]���^���V���E�×{�E����É@�����S���x�z�E�e�L�X�g
   */
  public ACTextField getShisetsuInfoNormalRoomLimitMoneyText2(){
    if(shisetsuInfoNormalRoomLimitMoneyText2==null){

      shisetsuInfoNormalRoomLimitMoneyText2 = new ACTextField();

      shisetsuInfoNormalRoomLimitMoneyText2.setBindPath("LIMIT_JURAIGATA2");

      shisetsuInfoNormalRoomLimitMoneyText2.setColumns(4);

      shisetsuInfoNormalRoomLimitMoneyText2.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoNormalRoomLimitMoneyText2.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoNormalRoomLimitMoneyText2.setIMEMode(InputSubset.LATIN);

      shisetsuInfoNormalRoomLimitMoneyText2.setMaxLength(4);

      addShisetsuInfoNormalRoomLimitMoneyText2();
    }
    return shisetsuInfoNormalRoomLimitMoneyText2;

  }

  /**
   * �]���^���V���E�×{�E����É@�����S���x�z�E���x�����擾���܂��B
   * @return �]���^���V���E�×{�E����É@�����S���x�z�E���x��
   */
  public ACLabel getShisetsuInfoNormalRoomLimitMoneyLabel2(){
    if(shisetsuInfoNormalRoomLimitMoneyLabel2==null){

      shisetsuInfoNormalRoomLimitMoneyLabel2 = new ACLabel();

      shisetsuInfoNormalRoomLimitMoneyLabel2.setText("(�~)");

      addShisetsuInfoNormalRoomLimitMoneyLabel2();
    }
    return shisetsuInfoNormalRoomLimitMoneyLabel2;

  }

  /**
   * ���������{�����S���x�z�E�R���e�i���擾���܂��B
   * @return ���������{�����S���x�z�E�R���e�i
   */
  public ACLabelContainer getShisetsuInfoTasyoRoomLimitMoneyContena(){
    if(shisetsuInfoTasyoRoomLimitMoneyContena==null){

      shisetsuInfoTasyoRoomLimitMoneyContena = new ACLabelContainer();

      shisetsuInfoTasyoRoomLimitMoneyContena.setText("������(���{��)");

      addShisetsuInfoTasyoRoomLimitMoneyContena();
    }
    return shisetsuInfoTasyoRoomLimitMoneyContena;

  }

  /**
   * ���������{�����S���x�z�E�e�L�X�g���擾���܂��B
   * @return ���������{�����S���x�z�E�e�L�X�g
   */
  public ACTextField getShisetsuInfoTasyoRoomLimitMoneyText(){
    if(shisetsuInfoTasyoRoomLimitMoneyText==null){

      shisetsuInfoTasyoRoomLimitMoneyText = new ACTextField();

      shisetsuInfoTasyoRoomLimitMoneyText.setBindPath("LIMIT_TASHOSHITSU2");

      shisetsuInfoTasyoRoomLimitMoneyText.setColumns(4);

      shisetsuInfoTasyoRoomLimitMoneyText.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoTasyoRoomLimitMoneyText.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoTasyoRoomLimitMoneyText.setIMEMode(InputSubset.LATIN);

      shisetsuInfoTasyoRoomLimitMoneyText.setMaxLength(4);

      addShisetsuInfoTasyoRoomLimitMoneyText();
    }
    return shisetsuInfoTasyoRoomLimitMoneyText;

  }

  /**
   * ���������{�����S���x�z�E���x�����擾���܂��B
   * @return ���������{�����S���x�z�E���x��
   */
  public ACLabel getShisetsuInfoTasyoRoomLimitMoneyLabel(){
    if(shisetsuInfoTasyoRoomLimitMoneyLabel==null){

      shisetsuInfoTasyoRoomLimitMoneyLabel = new ACLabel();

      shisetsuInfoTasyoRoomLimitMoneyLabel.setText("(�~)");

      addShisetsuInfoTasyoRoomLimitMoneyLabel();
    }
    return shisetsuInfoTasyoRoomLimitMoneyLabel;

  }

  /**
   * �������V���E�×{�E����É@�����S���x�z�E�R���e�i���擾���܂��B
   * @return �������V���E�×{�E����É@�����S���x�z�E�R���e�i
   */
  public ACLabelContainer getShisetsuInfoTasyoRoomLimitMoneyContena2(){
    if(shisetsuInfoTasyoRoomLimitMoneyContena2==null){

      shisetsuInfoTasyoRoomLimitMoneyContena2 = new ACLabelContainer();

      shisetsuInfoTasyoRoomLimitMoneyContena2.setText("������(�V���E�×{�E����É@��)");

      addShisetsuInfoTasyoRoomLimitMoneyContena2();
    }
    return shisetsuInfoTasyoRoomLimitMoneyContena2;

  }

  /**
   * �������V���E�×{�E����É@�����S���x�z�E�e�L�X�g���擾���܂��B
   * @return �������V���E�×{�E����É@�����S���x�z�E�e�L�X�g
   */
  public ACTextField getShisetsuInfoTasyoRoomLimitMoneyText2(){
    if(shisetsuInfoTasyoRoomLimitMoneyText2==null){

      shisetsuInfoTasyoRoomLimitMoneyText2 = new ACTextField();

      shisetsuInfoTasyoRoomLimitMoneyText2.setBindPath("LIMIT_TASHOSHITSU");

      shisetsuInfoTasyoRoomLimitMoneyText2.setColumns(4);

      shisetsuInfoTasyoRoomLimitMoneyText2.setCharType(VRCharType.ONLY_DIGIT);

      shisetsuInfoTasyoRoomLimitMoneyText2.setHorizontalAlignment(SwingConstants.RIGHT);

      shisetsuInfoTasyoRoomLimitMoneyText2.setIMEMode(InputSubset.LATIN);

      shisetsuInfoTasyoRoomLimitMoneyText2.setMaxLength(4);

      addShisetsuInfoTasyoRoomLimitMoneyText2();
    }
    return shisetsuInfoTasyoRoomLimitMoneyText2;

  }

  /**
   * �������V���E�×{�E����É@�����S���x�z�E���x�����擾���܂��B
   * @return �������V���E�×{�E����É@�����S���x�z�E���x��
   */
  public ACLabel getShisetsuInfoTasyoRoomLimitMoneyLabel2(){
    if(shisetsuInfoTasyoRoomLimitMoneyLabel2==null){

      shisetsuInfoTasyoRoomLimitMoneyLabel2 = new ACLabel();

      shisetsuInfoTasyoRoomLimitMoneyLabel2.setText("(�~)");

      addShisetsuInfoTasyoRoomLimitMoneyLabel2();
    }
    return shisetsuInfoTasyoRoomLimitMoneyLabel2;

  }

  /**
   * �E�p�l�����擾���܂��B
   * @return �E�p�l��
   */
  public ACPanel getShisetsuInfRigthtPanel(){
    if(shisetsuInfRigthtPanel==null){

      shisetsuInfRigthtPanel = new ACPanel();

      addShisetsuInfRigthtPanel();
    }
    return shisetsuInfRigthtPanel;

  }

  /**
   * ���V�l�����{�݁E�O���[�v���擾���܂��B
   * @return ���V�l�����{�݁E�O���[�v
   */
  public ACGroupBox getShisetsuInfoCareOldPersonGroup(){
    if(shisetsuInfoCareOldPersonGroup==null){

      shisetsuInfoCareOldPersonGroup = new ACGroupBox();

      shisetsuInfoCareOldPersonGroup.setText("���V�l�����{��");

      addShisetsuInfoCareOldPersonGroup();
    }
    return shisetsuInfoCareOldPersonGroup;

  }

  /**
   * ���[�u�����ғ�����擾���܂��B
   * @return ���[�u�����ғ���
   */
  public ACIntegerCheckBox getShisetsuInfoOldStep(){
    if(shisetsuInfoOldStep==null){

      shisetsuInfoOldStep = new ACIntegerCheckBox();

      shisetsuInfoOldStep.setText("���[�u�����ғ���");

      shisetsuInfoOldStep.setBindPath("KYUSOCHI_FLAG");

      shisetsuInfoOldStep.setSelectValue(2);

      shisetsuInfoOldStep.setUnSelectValue(1);

      addShisetsuInfoOldStep();
    }
    return shisetsuInfoOldStep;

  }

  /**
   * ���V�l�ی��{�݁E���×{�^��Î{�݁E����É@�O���[�v���擾���܂��B
   * @return ���V�l�ی��{�݁E���×{�^��Î{�݁E����É@�O���[�v
   */
  public ACGroupBox getShisetsuInfoCareOldPersonInsuranceGroup(){
    if(shisetsuInfoCareOldPersonInsuranceGroup==null){

      shisetsuInfoCareOldPersonInsuranceGroup = new ACGroupBox();

      shisetsuInfoCareOldPersonInsuranceGroup.setText("���V�l�ی��{�݁E���×{�^��Î{�݁E����É@");

      addShisetsuInfoCareOldPersonInsuranceGroup();
    }
    return shisetsuInfoCareOldPersonInsuranceGroup;

  }

  /**
   * �叝�a���擾���܂��B
   * @return �叝�a
   */
  public ACTextField getShisetsuInfoMainDisease(){
    if(shisetsuInfoMainDisease==null){

      shisetsuInfoMainDisease = new ACTextField();

      getShisetsuInfoMainDiseaseContainer().setText("�叝�a");

      shisetsuInfoMainDisease.setBindPath("DISEASE");

      shisetsuInfoMainDisease.setColumns(20);

      shisetsuInfoMainDisease.setIMEMode(InputSubset.KANJI);

      shisetsuInfoMainDisease.setMaxLength(64);

      addShisetsuInfoMainDisease();
    }
    return shisetsuInfoMainDisease;

  }

  /**
   * �叝�a�R���e�i���擾���܂��B
   * @return �叝�a�R���e�i
   */
  protected ACLabelContainer getShisetsuInfoMainDiseaseContainer(){
    if(shisetsuInfoMainDiseaseContainer==null){
      shisetsuInfoMainDiseaseContainer = new ACLabelContainer();
      shisetsuInfoMainDiseaseContainer.setFollowChildEnabled(true);
      shisetsuInfoMainDiseaseContainer.setVAlignment(VRLayout.CENTER);
      shisetsuInfoMainDiseaseContainer.add(getShisetsuInfoMainDisease(), null);
    }
    return shisetsuInfoMainDiseaseContainer;
  }

  /**
   * �������O���[�v���擾���܂��B
   * @return �������O���[�v
   */
  public ACGroupBox getShisetsuInfoExplanationGroup(){
    if(shisetsuInfoExplanationGroup==null){

      shisetsuInfoExplanationGroup = new ACGroupBox();

      shisetsuInfoExplanationGroup.setAutoWrap(true);

      shisetsuInfoExplanationGroup.setHgap(0);

      addShisetsuInfoExplanationGroup();
    }
    return shisetsuInfoExplanationGroup;

  }

  /**
   * ���������x��1���擾���܂��B
   * @return ���������x��1
   */
  public ACLabel getShisetsuInfoExplanationLabel1(){
    if(shisetsuInfoExplanationLabel1==null){

      shisetsuInfoExplanationLabel1 = new ACLabel();

      shisetsuInfoExplanationLabel1.setText("���@�E�������̐ݒ���@");

      shisetsuInfoExplanationLabel1.setIconPath(ACConstants.ICON_PATH_INFORMATION_24);

      addShisetsuInfoExplanationLabel1();
    }
    return shisetsuInfoExplanationLabel1;

  }

  /**
   * ���������x��2���擾���܂��B
   * @return ���������x��2
   */
  public ACLabel getShisetsuInfoExplanationLabel2(){
    if(shisetsuInfoExplanationLabel2==null){

      shisetsuInfoExplanationLabel2 = new ACLabel();

      shisetsuInfoExplanationLabel2.setText("�@�ٓ����ɂĎ{�݌n�T�[�r�X��I�����A�ݒ���s���Ă��������B");

      addShisetsuInfoExplanationLabel2();
    }
    return shisetsuInfoExplanationLabel2;

  }

  /**
   * �{�ݏ��E���̑��p�l�����擾���܂��B
   * @return �{�ݏ��E���̑��p�l��
   */
  public ACPanel getShisetsuInfoOtherPanel(){
    if(shisetsuInfoOtherPanel==null){

      shisetsuInfoOtherPanel = new ACPanel();

      shisetsuInfoOtherPanel.setLayout(getShisetsuInfoOtherLayout());

      addShisetsuInfoOtherPanel();
    }
    return shisetsuInfoOtherPanel;

  }

  /**
   * �{�ݏ�񂻂̑��̈�E���C�A�E�g���擾���܂��B
   * @return �{�ݏ�񂻂̑��̈�E���C�A�E�g
   */
  public VRLayout getShisetsuInfoOtherLayout(){
    if(shisetsuInfoOtherLayout==null){

      shisetsuInfoOtherLayout = new VRLayout();

      shisetsuInfoOtherLayout.setAutoWrap(false);

      shisetsuInfoOtherLayout.setVgap(5);

      addShisetsuInfoOtherLayout();
    }
    return shisetsuInfoOtherLayout;

  }

  /**
   * �L�����ԗ̈�E�p�l�����擾���܂��B
   * @return �L�����ԗ̈�E�p�l��
   */
  public ACPanel getShisetsuInfoLimitPanel(){
    if(shisetsuInfoLimitPanel==null){

      shisetsuInfoLimitPanel = new ACPanel();

      addShisetsuInfoLimitPanel();
    }
    return shisetsuInfoLimitPanel;

  }

  /**
   * �L�����ԁE�R���e�i���擾���܂��B
   * @return �L�����ԁE�R���e�i
   */
  public ACLabelContainer getShisetsuInfoValidLimitContainer(){
    if(shisetsuInfoValidLimitContainer==null){

      shisetsuInfoValidLimitContainer = new ACLabelContainer();

      shisetsuInfoValidLimitContainer.setText("�L������");

      addShisetsuInfoValidLimitContainer();
    }
    return shisetsuInfoValidLimitContainer;

  }

  /**
   * �L�����ԁE�e�L�X�g1���擾���܂��B
   * @return �L�����ԁE�e�L�X�g1
   */
  public QkanDateTextField getShisetsuInfoValidLimitDateStart(){
    if(shisetsuInfoValidLimitDateStart==null){

      shisetsuInfoValidLimitDateStart = new QkanDateTextField();

      shisetsuInfoValidLimitDateStart.setBindPath("SHISETSU_VALID_START");

      addShisetsuInfoValidLimitDateStart();
    }
    return shisetsuInfoValidLimitDateStart;

  }

  /**
   * �L�����ԁE���x�����擾���܂��B
   * @return �L�����ԁE���x��
   */
  public ACLabel getShisetsuInfoValidLimitLabel(){
    if(shisetsuInfoValidLimitLabel==null){

      shisetsuInfoValidLimitLabel = new ACLabel();

      shisetsuInfoValidLimitLabel.setText(" ���� ");

      addShisetsuInfoValidLimitLabel();
    }
    return shisetsuInfoValidLimitLabel;

  }

  /**
   * �L�����ԁE�e�L�X�g2���擾���܂��B
   * @return �L�����ԁE�e�L�X�g2
   */
  public QkanDateTextField getShisetsuInfoValidLimitDateEnd(){
    if(shisetsuInfoValidLimitDateEnd==null){

      shisetsuInfoValidLimitDateEnd = new QkanDateTextField();

      shisetsuInfoValidLimitDateEnd.setBindPath("SHISETSU_VALID_END");

      addShisetsuInfoValidLimitDateEnd();
    }
    return shisetsuInfoValidLimitDateEnd;

  }

  /**
   * ��������ҏ��E�{�^���̈���擾���܂��B
   * @return ��������ҏ��E�{�^���̈�
   */
  public ACPanel getShisetsuInfoButtons(){
    if(shisetsuInfoButtons==null){

      shisetsuInfoButtons = new ACPanel();

      addShisetsuInfoButtons();
    }
    return shisetsuInfoButtons;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACButton getShisetsuInfoButtonClear(){
    if(shisetsuInfoButtonClear==null){

      shisetsuInfoButtonClear = new ACButton();

      shisetsuInfoButtonClear.setText("�N���A");

      shisetsuInfoButtonClear.setToolTipText("�ٓ������N���A���܂��B");

      shisetsuInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addShisetsuInfoButtonClear();
    }
    return shisetsuInfoButtonClear;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getShisetsuInfoButtonInsert(){
    if(shisetsuInfoButtonInsert==null){

      shisetsuInfoButtonInsert = new ACButton();

      shisetsuInfoButtonInsert.setText("�ǉ�");

      shisetsuInfoButtonInsert.setToolTipText("�ٓ�����ǉ����܂��B");

      shisetsuInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addShisetsuInfoButtonInsert();
    }
    return shisetsuInfoButtonInsert;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getShisetsuInfoButtonEdit(){
    if(shisetsuInfoButtonEdit==null){

      shisetsuInfoButtonEdit = new ACButton();

      shisetsuInfoButtonEdit.setText("����");

      shisetsuInfoButtonEdit.setToolTipText("�ٓ�����ҏW���܂��B");

      shisetsuInfoButtonEdit.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addShisetsuInfoButtonEdit();
    }
    return shisetsuInfoButtonEdit;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getShisetsuInfoButtonDelete(){
    if(shisetsuInfoButtonDelete==null){

      shisetsuInfoButtonDelete = new ACButton();

      shisetsuInfoButtonDelete.setText("�폜");

      shisetsuInfoButtonDelete.setToolTipText("�ٓ������폜���܂��B");

      shisetsuInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addShisetsuInfoButtonDelete();
    }
    return shisetsuInfoButtonDelete;

  }

  /**
   * ��������ҏ��E�e�[�u���̈���擾���܂��B
   * @return ��������ҏ��E�e�[�u���̈�
   */
  public ACTable getShisetsuInfoTable(){
    if(shisetsuInfoTable==null){

      shisetsuInfoTable = new ACTable();

      shisetsuInfoTable.setColumnModel(getShisetsuInfoTableColumnModel());

      addShisetsuInfoTable();
    }
    return shisetsuInfoTable;

  }

  /**
   * ��������ҏ��E�e�[�u���̈�J�������f�����擾���܂��B
   * @return ��������ҏ��E�e�[�u���̈�J�������f��
   */
  protected VRTableColumnModel getShisetsuInfoTableColumnModel(){
    if(shisetsuInfoTableColumnModel==null){
      shisetsuInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addShisetsuInfoTableColumnModel();
    }
    return shisetsuInfoTableColumnModel;
  }

  /**
   * �����擾���܂��B
   * @return ��
   */
  public ACTableColumn getShisetsuInfoTableColumn0(){
    if(shisetsuInfoTableColumn0==null){

      shisetsuInfoTableColumn0 = new ACTableColumn();

      shisetsuInfoTableColumn0.setHeaderValue("No.");

      shisetsuInfoTableColumn0.setColumnName("SHOW_FLAG");

      shisetsuInfoTableColumn0.setColumns(3);

      shisetsuInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      shisetsuInfoTableColumn0.setSortable(false);

      addShisetsuInfoTableColumn0();
    }
    return shisetsuInfoTableColumn0;

  }

  /**
   * �L�����ԊJ�n���擾���܂��B
   * @return �L�����ԊJ�n
   */
  public ACTableColumn getShisetsuInfoTableColumn1(){
    if(shisetsuInfoTableColumn1==null){

      shisetsuInfoTableColumn1 = new ACTableColumn();

      shisetsuInfoTableColumn1.setHeaderValue("�L�����ԊJ�n");

      shisetsuInfoTableColumn1.setColumnName("SHISETSU_VALID_START");

      shisetsuInfoTableColumn1.setColumns(10);

      shisetsuInfoTableColumn1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addShisetsuInfoTableColumn1();
    }
    return shisetsuInfoTableColumn1;

  }

  /**
   * �L�����ԏI�����擾���܂��B
   * @return �L�����ԏI��
   */
  public ACTableColumn getShisetsuInfoTableColumn2(){
    if(shisetsuInfoTableColumn2==null){

      shisetsuInfoTableColumn2 = new ACTableColumn();

      shisetsuInfoTableColumn2.setHeaderValue("�L�����ԏI��");

      shisetsuInfoTableColumn2.setColumnName("SHISETSU_VALID_END");

      shisetsuInfoTableColumn2.setColumns(10);

      shisetsuInfoTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addShisetsuInfoTableColumn2();
    }
    return shisetsuInfoTableColumn2;

  }

  /**
   * ��������҂��擾���܂��B
   * @return ���������
   */
  public ACTableColumn getShisetsuInfoTableColumn3(){
    if(shisetsuInfoTableColumn3==null){

      shisetsuInfoTableColumn3 = new ACTableColumn();

      shisetsuInfoTableColumn3.setHeaderValue("���������");

      shisetsuInfoTableColumn3.setColumnName("TOKUTEI_NYUSHO_FLAG");

      shisetsuInfoTableColumn3.setColumns(7);

      shisetsuInfoTableColumn3.setHorizontalAlignment(SwingConstants.CENTER);

      shisetsuInfoTableColumn3.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      shisetsuInfoTableColumn3.setSortable(false);

      addShisetsuInfoTableColumn3();
    }
    return shisetsuInfoTableColumn3;

  }

  /**
   * ���[�u�����ғ�����擾���܂��B
   * @return ���[�u�����ғ���
   */
  public ACTableColumn getShisetsuInfoTableColumn4(){
    if(shisetsuInfoTableColumn4==null){

      shisetsuInfoTableColumn4 = new ACTableColumn();

      shisetsuInfoTableColumn4.setHeaderValue("���[�u�����ғ���");

      shisetsuInfoTableColumn4.setColumnName("KYUSOCHI_FLAG");

      shisetsuInfoTableColumn4.setColumns(10);

      shisetsuInfoTableColumn4.setHorizontalAlignment(SwingConstants.CENTER);

      shisetsuInfoTableColumn4.setRendererType(ACTableCellViewer.RENDERER_TYPE_ICON);

      shisetsuInfoTableColumn4.setSortable(false);

      addShisetsuInfoTableColumn4();
    }
    return shisetsuInfoTableColumn4;

  }

  /**
   * �叝�a�����擾���܂��B
   * @return �叝�a��
   */
  public ACTableColumn getShisetsuInfoTableColumn5(){
    if(shisetsuInfoTableColumn5==null){

      shisetsuInfoTableColumn5 = new ACTableColumn();

      shisetsuInfoTableColumn5.setHeaderValue("�叝�a��");

      shisetsuInfoTableColumn5.setColumnName("DISEASE");

      shisetsuInfoTableColumn5.setColumns(15);

      addShisetsuInfoTableColumn5();
    }
    return shisetsuInfoTableColumn5;

  }

  /**
   * �Z���n������E�p�l�����擾���܂��B
   * @return �Z���n������E�p�l��
   */
  public ACPanel getJushotiTokureiInfoPanel(){
    if(jushotiTokureiInfoPanel==null){

      jushotiTokureiInfoPanel = new ACPanel();

      addJushotiTokureiInfoPanel();
    }
    return jushotiTokureiInfoPanel;

  }

  /**
   * �Z���n������͗̈�E�p�l�����擾���܂��B
   * @return �Z���n������͗̈�E�p�l��
   */
  public ACPanel getJushotiTokureiInputPanel(){
    if(jushotiTokureiInputPanel==null){

      jushotiTokureiInputPanel = new ACPanel();

      addJushotiTokureiInputPanel();
    }
    return jushotiTokureiInputPanel;

  }

  /**
   * �H��Z��E�O���[�v���擾���܂��B
   * @return �H��Z��E�O���[�v
   */
  public ACGroupBox getJushotiTokureiInfoGroup(){
    if(jushotiTokureiInfoGroup==null){

      jushotiTokureiInfoGroup = new ACGroupBox();

      jushotiTokureiInfoGroup.setText("�Z���n������");

      jushotiTokureiInfoGroup.setLayout(getJushotiTokureiInfoLayout2());

      addJushotiTokureiInfoGroup();
    }
    return jushotiTokureiInfoGroup;

  }

  /**
   * (�Z���n�����{�̈�E���C�A�E�g)���擾���܂��B
   * @return (�Z���n�����{�̈�E���C�A�E�g)
   */
  public VRLayout getJushotiTokureiInfoLayout2(){
    if(jushotiTokureiInfoLayout2==null){

      jushotiTokureiInfoLayout2 = new VRLayout();

      jushotiTokureiInfoLayout2.setAutoWrap(false);

      jushotiTokureiInfoLayout2.setHgap(2);

      jushotiTokureiInfoLayout2.setHgrid(150);

      addJushotiTokureiInfoLayout2();
    }
    return jushotiTokureiInfoLayout2;

  }

  /**
   * �{�ݏ��ݕی��Ҕԍ����擾���܂��B
   * @return �{�ݏ��ݕی��Ҕԍ�
   */
  public ACTextField getJushotiTokureiInfoInsurerId(){
    if(jushotiTokureiInfoInsurerId==null){

      jushotiTokureiInfoInsurerId = new ACTextField();

      getJushotiTokureiInfoInsurerIdContainer().setText("�{�ݏ��ݕی��Ҕԍ�");

      jushotiTokureiInfoInsurerId.setBindPath("JUSHOTI_INSURER_ID");

      jushotiTokureiInfoInsurerId.setColumns(9);

      jushotiTokureiInfoInsurerId.setCharType(VRCharType.ONLY_DIGIT);

      jushotiTokureiInfoInsurerId.setIMEMode(InputSubset.LATIN);

      jushotiTokureiInfoInsurerId.setMaxLength(6);

      addJushotiTokureiInfoInsurerId();
    }
    return jushotiTokureiInfoInsurerId;

  }

  /**
   * �{�ݏ��ݕی��Ҕԍ��R���e�i���擾���܂��B
   * @return �{�ݏ��ݕی��Ҕԍ��R���e�i
   */
  protected ACLabelContainer getJushotiTokureiInfoInsurerIdContainer(){
    if(jushotiTokureiInfoInsurerIdContainer==null){
      jushotiTokureiInfoInsurerIdContainer = new ACLabelContainer();
      jushotiTokureiInfoInsurerIdContainer.setFollowChildEnabled(true);
      jushotiTokureiInfoInsurerIdContainer.setVAlignment(VRLayout.CENTER);
      jushotiTokureiInfoInsurerIdContainer.add(getJushotiTokureiInfoInsurerId(), null);
    }
    return jushotiTokureiInfoInsurerIdContainer;
  }

  /**
   * �{�ݏ��ݕی��Җ����擾���܂��B
   * @return �{�ݏ��ݕی��Җ�
   */
  public ACComboBox getJushotiTokureiInfoInsurerName(){
    if(jushotiTokureiInfoInsurerName==null){

      jushotiTokureiInfoInsurerName = new ACComboBox();

      getJushotiTokureiInfoInsurerNameContainer().setText("�{�ݏ��ݕی��Җ�");

      jushotiTokureiInfoInsurerName.setBindPath("JUSHOTI_INSURER_ID");

      jushotiTokureiInfoInsurerName.setEditable(false);

      jushotiTokureiInfoInsurerName.setColumns(10);

      jushotiTokureiInfoInsurerName.setModelBindPath("INSURER");

      jushotiTokureiInfoInsurerName.setRenderBindPath("INSURER_NAME");

      jushotiTokureiInfoInsurerName.setMaxColumns(18);

      jushotiTokureiInfoInsurerName.setModel(getJushotiTokureiInfoInsurerNameModel());

      addJushotiTokureiInfoInsurerName();
    }
    return jushotiTokureiInfoInsurerName;

  }

  /**
   * �{�ݏ��ݕی��Җ��R���e�i���擾���܂��B
   * @return �{�ݏ��ݕی��Җ��R���e�i
   */
  protected ACLabelContainer getJushotiTokureiInfoInsurerNameContainer(){
    if(jushotiTokureiInfoInsurerNameContainer==null){
      jushotiTokureiInfoInsurerNameContainer = new ACLabelContainer();
      jushotiTokureiInfoInsurerNameContainer.setFollowChildEnabled(true);
      jushotiTokureiInfoInsurerNameContainer.setVAlignment(VRLayout.CENTER);
      jushotiTokureiInfoInsurerNameContainer.add(getJushotiTokureiInfoInsurerName(), null);
    }
    return jushotiTokureiInfoInsurerNameContainer;
  }

  /**
   * �{�ݏ��ݕی��Җ����f�����擾���܂��B
   * @return �{�ݏ��ݕی��Җ����f��
   */
  protected ACComboBoxModelAdapter getJushotiTokureiInfoInsurerNameModel(){
    if(jushotiTokureiInfoInsurerNameModel==null){
      jushotiTokureiInfoInsurerNameModel = new ACComboBoxModelAdapter();
      addJushotiTokureiInfoInsurerNameModel();
    }
    return jushotiTokureiInfoInsurerNameModel;
  }

  /**
   * �L�����ԗ̈�E�p�l�����擾���܂��B
   * @return �L�����ԗ̈�E�p�l��
   */
  public ACPanel getJushotiTokureiInfoLimitPanel(){
    if(jushotiTokureiInfoLimitPanel==null){

      jushotiTokureiInfoLimitPanel = new ACPanel();

      addJushotiTokureiInfoLimitPanel();
    }
    return jushotiTokureiInfoLimitPanel;

  }

  /**
   * �L�����ԁE�R���e�i���擾���܂��B
   * @return �L�����ԁE�R���e�i
   */
  public ACLabelContainer getJushotiTokureiInfoValidLimitContainer(){
    if(jushotiTokureiInfoValidLimitContainer==null){

      jushotiTokureiInfoValidLimitContainer = new ACLabelContainer();

      jushotiTokureiInfoValidLimitContainer.setText("�L������");

      addJushotiTokureiInfoValidLimitContainer();
    }
    return jushotiTokureiInfoValidLimitContainer;

  }

  /**
   * �L�����ԁE�e�L�X�g1���擾���܂��B
   * @return �L�����ԁE�e�L�X�g1
   */
  public QkanDateTextField getJushotiTokureiInfoValidLimitDateStart(){
    if(jushotiTokureiInfoValidLimitDateStart==null){

      jushotiTokureiInfoValidLimitDateStart = new QkanDateTextField();

      jushotiTokureiInfoValidLimitDateStart.setBindPath("JUSHOTI_VALID_START");

      addJushotiTokureiInfoValidLimitDateStart();
    }
    return jushotiTokureiInfoValidLimitDateStart;

  }

  /**
   * �L�����ԁE���x�����擾���܂��B
   * @return �L�����ԁE���x��
   */
  public ACLabel getJushotiTokureiInfoValidLimitLabel(){
    if(jushotiTokureiInfoValidLimitLabel==null){

      jushotiTokureiInfoValidLimitLabel = new ACLabel();

      jushotiTokureiInfoValidLimitLabel.setText(" ���� ");

      addJushotiTokureiInfoValidLimitLabel();
    }
    return jushotiTokureiInfoValidLimitLabel;

  }

  /**
   * �L�����ԁE�e�L�X�g2���擾���܂��B
   * @return �L�����ԁE�e�L�X�g2
   */
  public QkanDateTextField getJushotiTokureiInfoValidLimitDateEnd(){
    if(jushotiTokureiInfoValidLimitDateEnd==null){

      jushotiTokureiInfoValidLimitDateEnd = new QkanDateTextField();

      jushotiTokureiInfoValidLimitDateEnd.setBindPath("JUSHOTI_VALID_END");

      addJushotiTokureiInfoValidLimitDateEnd();
    }
    return jushotiTokureiInfoValidLimitDateEnd;

  }

  /**
   * �Z���n������E�{�^���̈���擾���܂��B
   * @return �Z���n������E�{�^���̈�
   */
  public ACPanel getJushotiTokureiInfoButtons(){
    if(jushotiTokureiInfoButtons==null){

      jushotiTokureiInfoButtons = new ACPanel();

      addJushotiTokureiInfoButtons();
    }
    return jushotiTokureiInfoButtons;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACButton getJushotiTokureiInfoButtonClear(){
    if(jushotiTokureiInfoButtonClear==null){

      jushotiTokureiInfoButtonClear = new ACButton();

      jushotiTokureiInfoButtonClear.setText("�N���A");

      jushotiTokureiInfoButtonClear.setToolTipText("�Z���n��������N���A���܂��B");

      jushotiTokureiInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addJushotiTokureiInfoButtonClear();
    }
    return jushotiTokureiInfoButtonClear;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getJushotiTokureiInfoButtonInsert(){
    if(jushotiTokureiInfoButtonInsert==null){

      jushotiTokureiInfoButtonInsert = new ACButton();

      jushotiTokureiInfoButtonInsert.setText("�ǉ�");

      jushotiTokureiInfoButtonInsert.setToolTipText("�Z���n�������ǉ����܂��B");

      jushotiTokureiInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addJushotiTokureiInfoButtonInsert();
    }
    return jushotiTokureiInfoButtonInsert;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getJushotiTokureiInfoButtonEdit(){
    if(jushotiTokureiInfoButtonEdit==null){

      jushotiTokureiInfoButtonEdit = new ACButton();

      jushotiTokureiInfoButtonEdit.setText("����");

      jushotiTokureiInfoButtonEdit.setToolTipText("�Z���n�������ҏW���܂��B");

      jushotiTokureiInfoButtonEdit.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addJushotiTokureiInfoButtonEdit();
    }
    return jushotiTokureiInfoButtonEdit;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getJushotiTokureiInfoButtonDelete(){
    if(jushotiTokureiInfoButtonDelete==null){

      jushotiTokureiInfoButtonDelete = new ACButton();

      jushotiTokureiInfoButtonDelete.setText("�폜");

      jushotiTokureiInfoButtonDelete.setToolTipText("�Z���n��������폜���܂��B");

      jushotiTokureiInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addJushotiTokureiInfoButtonDelete();
    }
    return jushotiTokureiInfoButtonDelete;

  }

  /**
   * �Z���n������E�e�[�u���̈���擾���܂��B
   * @return �Z���n������E�e�[�u���̈�
   */
  public ACTable getJushotiTokureiInfoTable(){
    if(jushotiTokureiInfoTable==null){

      jushotiTokureiInfoTable = new ACTable();

      jushotiTokureiInfoTable.setColumnModel(getJushotiTokureiInfoTableColumnModel());

      addJushotiTokureiInfoTable();
    }
    return jushotiTokureiInfoTable;

  }

  /**
   * �Z���n������E�e�[�u���̈�J�������f�����擾���܂��B
   * @return �Z���n������E�e�[�u���̈�J�������f��
   */
  protected VRTableColumnModel getJushotiTokureiInfoTableColumnModel(){
    if(jushotiTokureiInfoTableColumnModel==null){
      jushotiTokureiInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addJushotiTokureiInfoTableColumnModel();
    }
    return jushotiTokureiInfoTableColumnModel;
  }

  /**
   * �����擾���܂��B
   * @return ��
   */
  public ACTableColumn getJushotiTokureiInfoTableColumn0(){
    if(jushotiTokureiInfoTableColumn0==null){

      jushotiTokureiInfoTableColumn0 = new ACTableColumn(0);

      jushotiTokureiInfoTableColumn0.setHeaderValue("No.");

      jushotiTokureiInfoTableColumn0.setColumns(3);

      jushotiTokureiInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      jushotiTokureiInfoTableColumn0.setSortable(false);

      addJushotiTokureiInfoTableColumn0();
    }
    return jushotiTokureiInfoTableColumn0;

  }

  /**
   * �L�����ԊJ�n���擾���܂��B
   * @return �L�����ԊJ�n
   */
  public ACTableColumn getJushotiTokureiInfoTableColumn1(){
    if(jushotiTokureiInfoTableColumn1==null){

      jushotiTokureiInfoTableColumn1 = new ACTableColumn(0);

      jushotiTokureiInfoTableColumn1.setHeaderValue("�L�����ԊJ�n");

      jushotiTokureiInfoTableColumn1.setColumnName("JUSHOTI_VALID_START");

      jushotiTokureiInfoTableColumn1.setColumns(10);

      jushotiTokureiInfoTableColumn1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addJushotiTokureiInfoTableColumn1();
    }
    return jushotiTokureiInfoTableColumn1;

  }

  /**
   * �L�����ԏI�����擾���܂��B
   * @return �L�����ԏI��
   */
  public ACTableColumn getJushotiTokureiInfoTableColumn2(){
    if(jushotiTokureiInfoTableColumn2==null){

      jushotiTokureiInfoTableColumn2 = new ACTableColumn(1);

      jushotiTokureiInfoTableColumn2.setHeaderValue("�L�����ԏI��");

      jushotiTokureiInfoTableColumn2.setColumnName("JUSHOTI_VALID_END");

      jushotiTokureiInfoTableColumn2.setColumns(10);

      jushotiTokureiInfoTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addJushotiTokureiInfoTableColumn2();
    }
    return jushotiTokureiInfoTableColumn2;

  }

  /**
   * �{�ݏ��ݕی��Ҕԍ����擾���܂��B
   * @return �{�ݏ��ݕی��Ҕԍ�
   */
  public ACTableColumn getJushotiTokureiInfoTableColumn3(){
    if(jushotiTokureiInfoTableColumn3==null){

      jushotiTokureiInfoTableColumn3 = new ACTableColumn(2);

      jushotiTokureiInfoTableColumn3.setHeaderValue("�{�ݏ��ݕی��Ҕԍ�");

      jushotiTokureiInfoTableColumn3.setColumnName("JUSHOTI_INSURER_ID");

      jushotiTokureiInfoTableColumn3.setColumns(10);

      addJushotiTokureiInfoTableColumn3();
    }
    return jushotiTokureiInfoTableColumn3;

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

    basicInfoAndInfoButton.add(getBasicInfoCheck(), VRLayout.FLOW_INSETLINE);

    basicInfoAndInfoButton.add(getYokaigodoNowContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * ���݂̗v���x�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoNow(){

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

    tabs.addTab("�ٓ����", getIdouInfoAndInstitutionInfoPanel());

    tabs.addTab("�{�ݏ��", getShisetsuInfoPanel());

    tabs.addTab("�Z���n������", getJushotiTokureiInfoPanel());

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

    kaigoInfo.add(getKaigoInfoInsuredIdContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoBenefitContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoShortCounts(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoKyotakuServiceContena(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoRequestDivisionContena(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoYokaigoInfoContainer(), VRLayout.FLOW);

    kaigoInfo.add(getKaigoInfoValidLimits(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoRequestDateContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoAuthorizeDateContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoLimitChanges(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoProvideLimitGroup(), VRLayout.FLOW);

    kaigoInfo.add(getKaigoInfoInterruptionGroup(), VRLayout.FLOW_RETURN);

    kaigoInfo.add(getKaigoInfoSystemValidLimits(), VRLayout.FLOW_RETURN);

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
   * (�Z���������p�����̏����l�E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoShortCounts(){

    kaigoInfoShortCounts.add(getKaigoInfoShortCount(), VRLayout.FLOW);

    kaigoInfoShortCounts.add(getKaigoInfoShortCountDay(), VRLayout.FLOW);

  }

  /**
   * �Z���������p�����̏����l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoShortCount(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoShortCountDay(){

  }

  /**
   * (����T�[�r�X�v��쐬�ҁE�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoKyotakuServiceContena(){

    kaigoInfoKyotakuServiceContena.add(getKaigoInfoKyotakuServiceRadio(), VRLayout.FLOW);

    kaigoInfoKyotakuServiceContena.add(getKaigoInfoReportDateContainer(), VRLayout.FLOW_RETURN);

    kaigoInfoKyotakuServiceContena.add(getKaigoInfoKyotakuServicePlanCombo(), VRLayout.FLOW_RETURN);

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
   * ����T�[�r�X�v��쐬�˗��͏o���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoReportDate(){

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
   * (�v�x���P�̊z�𒴂��ăT�[�r�X�𗘗p�E�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoLimitChanges(){

    kaigoInfoLimitChanges.add(getKaigoInfoLimitChange(), VRLayout.FLOW);

  }

  /**
   * �v�x���P�̊z�𒴂��ăT�[�r�X�𗘗p�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoLimitChange(){

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
   * (�L�����ԁE�R���e�i)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoSystemValidLimits(){

    kaigoInfoSystemValidLimits.add(getKaigoInfoSystemValidLimit1(), VRLayout.FLOW);

    kaigoInfoSystemValidLimits.add(getKaigoInfoSystemValidLimit2(), VRLayout.FLOW);

    kaigoInfoSystemValidLimits.add(getKaigoInfoSystemValidLimit3(), VRLayout.FLOW);

  }

  /**
   * �L�����ԁE�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoSystemValidLimit1(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoSystemValidLimit2(){

  }

  /**
   * �L�����ԁE�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoSystemValidLimit3(){

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

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn10());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn11());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn12());

  }

  /**
   * No�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn0(){

  }

  /**
   * �V�X�e���L���J�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn1(){

  }

  /**
   * �V�X�e���L���I���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn2(){

  }

  /**
   * ���t���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn3(){

  }

  /**
   * �\�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn4(){

  }

  /**
   * �\���敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn5(){

  }

  /**
   * �v�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn6(){

  }

  /**
   * �F��L�����ԊJ�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn7(){

  }

  /**
   * �F��L�����ԏI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn8(){

  }

  /**
   * �쐬�˗��͏o���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn9(){

  }

  /**
   * ���f�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn10(){

  }

  /**
   * ���f���R�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn11(){

  }

  /**
   * �x�����x�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoInfoTableColumn12(){

  }

  /**
   * (�ٓ��E�{�ݏ��E�p�l��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIdouInfoAndInstitutionInfoPanel(){

    idouInfoAndInstitutionInfoPanel.add(getIdouInfoAndInstitutionInfos(), VRLayout.CLIENT);

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

    idouInfoButtons.add(getIdouInfoButtonClear(), VRLayout.WEST);

    idouInfoButtons.add(getIdouInfoButtonInsert(), VRLayout.WEST);

    idouInfoButtons.add(getIdouInfoButtonEdit(), VRLayout.WEST);

    idouInfoButtons.add(getIdouInfoButtonDelete(), VRLayout.WEST);

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
   * ��������ҏ��E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoPanel(){

    shisetsuInfoPanel.add(getShisetsuInputPanel(), VRLayout.NORTH);

    shisetsuInfoPanel.add(getShisetsuInfoButtons(), VRLayout.NORTH);

    shisetsuInfoPanel.add(getShisetsuInfoTable(), VRLayout.CLIENT);

  }

  /**
   * ��������ғ��͗̈�E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInputPanel(){

    shisetsuInputPanel.add(getShisetsuInfSyokuhiPanel(), VRLayout.NORTH);

    shisetsuInputPanel.add(getShisetsuInfoOtherPanel(), VRLayout.NORTH);

    shisetsuInputPanel.add(getShisetsuInfoLimitPanel(), VRLayout.NORTH);

  }

  /**
   * �H��Z��E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfSyokuhiPanel(){

    shisetsuInfSyokuhiPanel.add(getShisetsuInfoSyokuhiGroup(), VRLayout.WEST);

    shisetsuInfSyokuhiPanel.add(getShisetsuInfRigthtPanel(), VRLayout.WEST);

  }

  /**
   * �H��Z��E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoSyokuhiGroup(){

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoSpaceLabel(), VRLayout.FLOW);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoTokuteiCheck(), VRLayout.FLOW_RETURN);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoDinnerBearLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoUnitRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoUnitSemiRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoNormalRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoNormalRoomLimitMoneyContena2(), VRLayout.FLOW_INSETLINE_RETURN);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoTasyoRoomLimitMoneyContena(), VRLayout.FLOW_INSETLINE);

    shisetsuInfoSyokuhiGroup.add(getShisetsuInfoTasyoRoomLimitMoneyContena2(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �H��E���Z��̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoSyokuhiLayout(){

  }

  /**
   * ��������X�y�[�T�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoSpaceLabel(){

  }

  /**
   * ��������҃`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTokuteiCheck(){

  }

  /**
   * �H��S���x�z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoDinnerBearLimitMoneyContena(){

    shisetsuInfoDinnerBearLimitMoneyContena.add(getShisetsuInfoDinnerBearLimitMoneyText(), null);

    shisetsuInfoDinnerBearLimitMoneyContena.add(getShisetsuInfoDinnerBearLimitMoneyLabel(), null);

  }

  /**
   * �H��S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoDinnerBearLimitMoneyText(){

  }

  /**
   * �H��S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoDinnerBearLimitMoneyLabel(){

  }

  /**
   * ���j�b�g�^�����S���x�z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoUnitRoomLimitMoneyContena(){

    shisetsuInfoUnitRoomLimitMoneyContena.add(getShisetsuInfoUnitRoomLimitMoneyText(), null);

    shisetsuInfoUnitRoomLimitMoneyContena.add(getShisetsuInfoUnitRoomLimitMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^�����S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoUnitRoomLimitMoneyText(){

  }

  /**
   * ���j�b�g�^�����S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoUnitRoomLimitMoneyLabel(){

  }

  /**
   * ���j�b�g�^���I���������S���x�z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoUnitSemiRoomLimitMoneyContena(){

    shisetsuInfoUnitSemiRoomLimitMoneyContena.add(getShisetsuInfoUnitSemiRoomLimitMoneyText(), null);

    shisetsuInfoUnitSemiRoomLimitMoneyContena.add(getShisetsuInfoUnitSemiRoomLimitMoneyLabel(), null);

  }

  /**
   * ���j�b�g�^���I���������S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoUnitSemiRoomLimitMoneyText(){

  }

  /**
   * ���j�b�g�^���I���������S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoUnitSemiRoomLimitMoneyLabel(){

  }

  /**
   * �]���^�����{�����S���x�z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyContena(){

    shisetsuInfoNormalRoomLimitMoneyContena.add(getShisetsuInfoNormalRoomLimitMoneyText(), null);

    shisetsuInfoNormalRoomLimitMoneyContena.add(getShisetsuInfoNormalRoomLimitMoneyLabel(), null);

  }

  /**
   * �]���^�����{�����S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyText(){

  }

  /**
   * �]���^�����{�����S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyLabel(){

  }

  /**
   * �]���^���V���E�×{�E����É@�����S���x�z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyContena2(){

    shisetsuInfoNormalRoomLimitMoneyContena2.add(getShisetsuInfoNormalRoomLimitMoneyText2(), null);

    shisetsuInfoNormalRoomLimitMoneyContena2.add(getShisetsuInfoNormalRoomLimitMoneyLabel2(), null);

  }

  /**
   * �]���^���V���E�×{�E����É@�����S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyText2(){

  }

  /**
   * �]���^���V���E�×{�E����É@�����S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoNormalRoomLimitMoneyLabel2(){

  }

  /**
   * ���������{�����S���x�z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyContena(){

    shisetsuInfoTasyoRoomLimitMoneyContena.add(getShisetsuInfoTasyoRoomLimitMoneyText(), null);

    shisetsuInfoTasyoRoomLimitMoneyContena.add(getShisetsuInfoTasyoRoomLimitMoneyLabel(), null);

  }

  /**
   * ���������{�����S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyText(){

  }

  /**
   * ���������{�����S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyLabel(){

  }

  /**
   * �������V���E�×{�E����É@�����S���x�z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyContena2(){

    shisetsuInfoTasyoRoomLimitMoneyContena2.add(getShisetsuInfoTasyoRoomLimitMoneyText2(), null);

    shisetsuInfoTasyoRoomLimitMoneyContena2.add(getShisetsuInfoTasyoRoomLimitMoneyLabel2(), null);

  }

  /**
   * �������V���E�×{�E����É@�����S���x�z�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyText2(){

  }

  /**
   * �������V���E�×{�E����É@�����S���x�z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTasyoRoomLimitMoneyLabel2(){

  }

  /**
   * �E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfRigthtPanel(){

    shisetsuInfRigthtPanel.add(getShisetsuInfoCareOldPersonGroup(), VRLayout.NORTH);

    shisetsuInfRigthtPanel.add(getShisetsuInfoCareOldPersonInsuranceGroup(), VRLayout.NORTH);

    shisetsuInfRigthtPanel.add(getShisetsuInfoExplanationGroup(), VRLayout.NORTH);

  }

  /**
   * ���V�l�����{�݁E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoCareOldPersonGroup(){

    shisetsuInfoCareOldPersonGroup.add(getShisetsuInfoOldStep(), VRLayout.FLOW);

  }

  /**
   * ���[�u�����ғ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoOldStep(){

  }

  /**
   * ���V�l�ی��{�݁E���×{�^��Î{�݁E����É@�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoCareOldPersonInsuranceGroup(){

    shisetsuInfoCareOldPersonInsuranceGroup.add(getShisetsuInfoMainDiseaseContainer(), VRLayout.FLOW);

  }

  /**
   * �叝�a�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoMainDisease(){

  }

  /**
   * �������O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoExplanationGroup(){

    shisetsuInfoExplanationGroup.add(getShisetsuInfoExplanationLabel1(), VRLayout.NORTH);

    shisetsuInfoExplanationGroup.add(getShisetsuInfoExplanationLabel2(), VRLayout.NORTH);

  }

  /**
   * ���������x��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoExplanationLabel1(){

  }

  /**
   * ���������x��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoExplanationLabel2(){

  }

  /**
   * �{�ݏ��E���̑��p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoOtherPanel(){

  }

  /**
   * �{�ݏ�񂻂̑��̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoOtherLayout(){

  }

  /**
   * �L�����ԗ̈�E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoLimitPanel(){

    shisetsuInfoLimitPanel.add(getShisetsuInfoValidLimitContainer(), VRLayout.FLOW);

  }

  /**
   * �L�����ԁE�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoValidLimitContainer(){

    shisetsuInfoValidLimitContainer.add(getShisetsuInfoValidLimitDateStart(), VRLayout.FLOW);

    shisetsuInfoValidLimitContainer.add(getShisetsuInfoValidLimitLabel(), VRLayout.FLOW);

    shisetsuInfoValidLimitContainer.add(getShisetsuInfoValidLimitDateEnd(), VRLayout.FLOW);

  }

  /**
   * �L�����ԁE�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoValidLimitDateStart(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoValidLimitLabel(){

  }

  /**
   * �L�����ԁE�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoValidLimitDateEnd(){

  }

  /**
   * ��������ҏ��E�{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoButtons(){

    shisetsuInfoButtons.add(getShisetsuInfoButtonClear(), VRLayout.WEST);

    shisetsuInfoButtons.add(getShisetsuInfoButtonInsert(), VRLayout.WEST);

    shisetsuInfoButtons.add(getShisetsuInfoButtonEdit(), VRLayout.WEST);

    shisetsuInfoButtons.add(getShisetsuInfoButtonDelete(), VRLayout.WEST);

  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoButtonClear(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoButtonInsert(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoButtonEdit(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoButtonDelete(){

  }

  /**
   * ��������ҏ��E�e�[�u���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTable(){

  }

  /**
   * ��������ҏ��E�e�[�u���̈�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTableColumnModel(){

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn0());

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn1());

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn2());

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn3());

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn4());

    getShisetsuInfoTableColumnModel().addColumn(getShisetsuInfoTableColumn5());

  }

  /**
   * ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTableColumn0(){

  }

  /**
   * �L�����ԊJ�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTableColumn1(){

  }

  /**
   * �L�����ԏI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTableColumn2(){

  }

  /**
   * ��������҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTableColumn3(){

  }

  /**
   * ���[�u�����ғ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTableColumn4(){

  }

  /**
   * �叝�a���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShisetsuInfoTableColumn5(){

  }

  /**
   * �Z���n������E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoPanel(){

    jushotiTokureiInfoPanel.add(getJushotiTokureiInputPanel(), VRLayout.NORTH);

    jushotiTokureiInfoPanel.add(getJushotiTokureiInfoButtons(), VRLayout.NORTH);

    jushotiTokureiInfoPanel.add(getJushotiTokureiInfoTable(), VRLayout.CLIENT);

  }

  /**
   * �Z���n������͗̈�E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInputPanel(){

    jushotiTokureiInputPanel.add(getJushotiTokureiInfoGroup(), VRLayout.NORTH);

    jushotiTokureiInputPanel.add(getJushotiTokureiInfoLimitPanel(), VRLayout.NORTH);

  }

  /**
   * �H��Z��E�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoGroup(){

    jushotiTokureiInfoGroup.add(getJushotiTokureiInfoInsurerIdContainer(), VRLayout.FLOW_INSETLINE);

    jushotiTokureiInfoGroup.add(getJushotiTokureiInfoInsurerNameContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * (�Z���n�����{�̈�E���C�A�E�g)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoLayout2(){

  }

  /**
   * �{�ݏ��ݕی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoInsurerId(){

  }

  /**
   * �{�ݏ��ݕی��Җ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoInsurerName(){

  }

  /**
   * �{�ݏ��ݕی��Җ����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoInsurerNameModel(){

  }

  /**
   * �L�����ԗ̈�E�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoLimitPanel(){

    jushotiTokureiInfoLimitPanel.add(getJushotiTokureiInfoValidLimitContainer(), VRLayout.FLOW);

  }

  /**
   * �L�����ԁE�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoValidLimitContainer(){

    jushotiTokureiInfoValidLimitContainer.add(getJushotiTokureiInfoValidLimitDateStart(), VRLayout.FLOW);

    jushotiTokureiInfoValidLimitContainer.add(getJushotiTokureiInfoValidLimitLabel(), VRLayout.FLOW);

    jushotiTokureiInfoValidLimitContainer.add(getJushotiTokureiInfoValidLimitDateEnd(), VRLayout.FLOW);

  }

  /**
   * �L�����ԁE�e�L�X�g1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoValidLimitDateStart(){

  }

  /**
   * �L�����ԁE���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoValidLimitLabel(){

  }

  /**
   * �L�����ԁE�e�L�X�g2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoValidLimitDateEnd(){

  }

  /**
   * �Z���n������E�{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoButtons(){

    jushotiTokureiInfoButtons.add(getJushotiTokureiInfoButtonClear(), VRLayout.WEST);

    jushotiTokureiInfoButtons.add(getJushotiTokureiInfoButtonInsert(), VRLayout.WEST);

    jushotiTokureiInfoButtons.add(getJushotiTokureiInfoButtonEdit(), VRLayout.WEST);

    jushotiTokureiInfoButtons.add(getJushotiTokureiInfoButtonDelete(), VRLayout.WEST);

  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoButtonClear(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoButtonInsert(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoButtonEdit(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoButtonDelete(){

  }

  /**
   * �Z���n������E�e�[�u���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoTable(){

  }

  /**
   * �Z���n������E�e�[�u���̈�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoTableColumnModel(){

    getJushotiTokureiInfoTableColumnModel().addColumn(getJushotiTokureiInfoTableColumn0());

    getJushotiTokureiInfoTableColumnModel().addColumn(getJushotiTokureiInfoTableColumn1());

    getJushotiTokureiInfoTableColumnModel().addColumn(getJushotiTokureiInfoTableColumn2());

    getJushotiTokureiInfoTableColumnModel().addColumn(getJushotiTokureiInfoTableColumn3());

  }

  /**
   * ���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoTableColumn0(){

  }

  /**
   * �L�����ԊJ�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoTableColumn1(){

  }

  /**
   * �L�����ԏI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoTableColumn2(){

  }

  /**
   * �{�ݏ��ݕی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addJushotiTokureiInfoTableColumn3(){

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
