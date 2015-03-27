
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
 * �쐬��: 2006/06/09  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: 2014/10/23  MIS��B������� ���� ���̂�
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��E���� (001)
 * �v���O���� ���p�E�񋟕[��� (QS001003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairDialog;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * ���p�E�񋟕[�����ʍ��ڃf�U�C��(QS001003) 
 */
@SuppressWarnings("serial")
public class QS001003Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel uppers;

  private ACPanel upperLefts;

  private ACPanel patients;

  private ACTextField patentName;

  private ACLabelContainer patentNameContainer;

  private ACTextField serviceYearMonth;

  private ACLabelContainer serviceYearMonthContainer;

  private ACPanel prividers;

  private ACClearableRadioButtonGroup planManufacturer;

  private ACLabelContainer planManufacturerContainer;

  private ACListModelAdapter planManufacturerModel;

  private ACRadioButtonItem supportProvider;

  private ACRadioButtonItem patent;

  private ACRadioButtonItem preventSupportProvider;

  private ACLabelContainer supportProviderContainer;

  private ACLabel supportProviderCd;

  private ACComboBox supportProviderName;

  private ACComboBoxModelAdapter supportProviderNameModel;

  private ACComboBox personInCharge;

  private ACLabelContainer personInChargeContainer;

  private ACComboBoxModelAdapter personInChargeModel;

  private ACPanel upperRights;

  private QkanDateTextField dateOfMakingOutsideFrame;

  private ACLabelContainer dateOfMakingOutsideFrameContainer;

  private QkanDateTextField dateOfMaking;

  private ACLabelContainer dateOfMakingContainer;

  private QkanDateTextField dateOfWrittenReport;

  private ACLabelContainer dateOfWrittenReportContainer;

  private ACLabel solid2;

  private ACPanel middles;

  private ACGroupBox stateOfYouKaigo;

  private ACLabel youKaigodoType1;

  private ACLabel youKaigodoType2;

  private ACPanel limitAmountInformation;

  private ACLabelContainer limitAmountContainer;

  private ACTextField limitAmountContent;

  private ACLabel solid4;

  private ACLabelContainer limitAmountApplicationPeriod;

  private ACTextField applicationPeriodBegin;

  private ACLabel solid5;

  private ACTextField applicationPeriodEnd;

  private ACPanel shortStayAndPublicExpense;

  private ACLabelContainer shortStayUseDays;

  private ACLabel solid6;

  private ACTextField shortStayUseDay;

  private ACLabel solid8;

  private ACLabelContainer publicExpenses;

  private ACIntegerCheckBox publicExpense;

  private ACPanel lowers;

  private ACGroupBox slitTypes;

  private ACClearableRadioButtonGroup slitType;

  private ACListModelAdapter slitTypeModel;

  private ACRadioButtonItem useVoteType;

  private ACRadioButtonItem offerVote;

  private ACGroupBox slitKinds;

  private ACClearableRadioButtonGroup slitKind;

  private ACListModelAdapter slitKindModel;

  private ACRadioButtonItem useVoteAndAttachedTable;

  private ACRadioButtonItem useVoteKind;

  private ACRadioButtonItem attachedTable;

  private ACGroupBox slitKeisyos;

  private ACClearableRadioButtonGroup slitKeisyo;

  private ACListModelAdapter slitKeisyoModel;

  private ACRadioButtonItem sama;

  private ACRadioButtonItem dono;

  private ACRadioButtonItem nashi;

  private ACPanel printButtonArea;

  private ACPanel printButtons;

  private ACButton print;

  private ACButton end;

  //getter

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * ��i�̈���擾���܂��B
   * @return ��i�̈�
   */
  public ACPanel getUppers(){
    if(uppers==null){

      uppers = new ACPanel();

      addUppers();
    }
    return uppers;

  }

  /**
   * ��i�̈捶���擾���܂��B
   * @return ��i�̈捶
   */
  public ACPanel getUpperLefts(){
    if(upperLefts==null){

      upperLefts = new ACPanel();

      addUpperLefts();
    }
    return upperLefts;

  }

  /**
   * ���p�ҏ��̈���擾���܂��B
   * @return ���p�ҏ��̈�
   */
  public ACPanel getPatients(){
    if(patients==null){

      patients = new ACPanel();

      addPatients();
    }
    return patients;

  }

  /**
   * ���p�Җ����x�����擾���܂��B
   * @return ���p�Җ����x��
   */
  public ACTextField getPatentName(){
    if(patentName==null){

      patentName = new ACTextField();

      getPatentNameContainer().setText("���p�Ҏ���");

      patentName.setBindPath("PATIENT_NAME");

      patentName.setEditable(false);

      patentName.setColumns(34);

      addPatentName();
    }
    return patentName;

  }

  /**
   * ���p�Җ����x���R���e�i���擾���܂��B
   * @return ���p�Җ����x���R���e�i
   */
  protected ACLabelContainer getPatentNameContainer(){
    if(patentNameContainer==null){
      patentNameContainer = new ACLabelContainer();
      patentNameContainer.setFollowChildEnabled(true);
      patentNameContainer.setVAlignment(VRLayout.CENTER);
      patentNameContainer.add(getPatentName(), null);
    }
    return patentNameContainer;
  }

  /**
   * �N�����x�����擾���܂��B
   * @return �N�����x��
   */
  public ACTextField getServiceYearMonth(){
    if(serviceYearMonth==null){

      serviceYearMonth = new ACTextField();

      getServiceYearMonthContainer().setText("�Ώ۔N��");

      serviceYearMonth.setBindPath("TARGET_DATE");

      serviceYearMonth.setEditable(false);

      serviceYearMonth.setColumns(8);

      addServiceYearMonth();
    }
    return serviceYearMonth;

  }

  /**
   * �N�����x���R���e�i���擾���܂��B
   * @return �N�����x���R���e�i
   */
  protected ACLabelContainer getServiceYearMonthContainer(){
    if(serviceYearMonthContainer==null){
      serviceYearMonthContainer = new ACLabelContainer();
      serviceYearMonthContainer.setFollowChildEnabled(true);
      serviceYearMonthContainer.setVAlignment(VRLayout.CENTER);
      serviceYearMonthContainer.add(getServiceYearMonth(), null);
    }
    return serviceYearMonthContainer;
  }

  /**
   * ���Ǝҏ��̈���擾���܂��B
   * @return ���Ǝҏ��̈�
   */
  public ACPanel getPrividers(){
    if(prividers==null){

      prividers = new ACPanel();

      addPrividers();
    }
    return prividers;

  }

  /**
   * �v��쐬�҃��W�I�O���[�v���擾���܂��B
   * @return �v��쐬�҃��W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getPlanManufacturer(){
    if(planManufacturer==null){

      planManufacturer = new ACClearableRadioButtonGroup();

      getPlanManufacturerContainer().setText("����v��쐬��");

      planManufacturer.setUseClearButton(false);

      planManufacturer.setModel(getPlanManufacturerModel());

      addPlanManufacturer();
    }
    return planManufacturer;

  }

  /**
   * �v��쐬�҃��W�I�O���[�v�R���e�i���擾���܂��B
   * @return �v��쐬�҃��W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getPlanManufacturerContainer(){
    if(planManufacturerContainer==null){
      planManufacturerContainer = new ACLabelContainer();
      planManufacturerContainer.setFollowChildEnabled(true);
      planManufacturerContainer.setVAlignment(VRLayout.CENTER);
      planManufacturerContainer.add(getPlanManufacturer(), null);
    }
    return planManufacturerContainer;
  }

  /**
   * �v��쐬�҃��W�I�O���[�v���f�����擾���܂��B
   * @return �v��쐬�҃��W�I�O���[�v���f��
   */
  protected ACListModelAdapter getPlanManufacturerModel(){
    if(planManufacturerModel==null){
      planManufacturerModel = new ACListModelAdapter();
      addPlanManufacturerModel();
    }
    return planManufacturerModel;
  }

  /**
   * ������x�����Ǝ҂��擾���܂��B
   * @return ������x�����Ǝ�
   */
  public ACRadioButtonItem getSupportProvider(){
    if(supportProvider==null){

      supportProvider = new ACRadioButtonItem();

      supportProvider.setText("������x�����Ə�");

      supportProvider.setGroup(getPlanManufacturer());

      addSupportProvider();
    }
    return supportProvider;

  }

  /**
   * ��ی��҂��擾���܂��B
   * @return ��ی���
   */
  public ACRadioButtonItem getPatent(){
    if(patent==null){

      patent = new ACRadioButtonItem();

      patent.setText("��ی���");

      patent.setGroup(getPlanManufacturer());

      addPatent();
    }
    return patent;

  }

  /**
   * ���\�h�x�����Ə����擾���܂��B
   * @return ���\�h�x�����Ə�
   */
  public ACRadioButtonItem getPreventSupportProvider(){
    if(preventSupportProvider==null){

      preventSupportProvider = new ACRadioButtonItem();

      preventSupportProvider.setText("���\�h�x�����Ə�");

      preventSupportProvider.setGroup(getPlanManufacturer());

      addPreventSupportProvider();
    }
    return preventSupportProvider;

  }

  /**
   * ����x�����Ǝҏ��R���e�i���擾���܂��B
   * @return ����x�����Ǝҏ��R���e�i
   */
  public ACLabelContainer getSupportProviderContainer(){
    if(supportProviderContainer==null){

      supportProviderContainer = new ACLabelContainer();

      supportProviderContainer.setText("����x�����Ə�");

      supportProviderContainer.setAutoWrap(false);

      supportProviderContainer.setHgap(0);

      addSupportProviderContainer();
    }
    return supportProviderContainer;

  }

  /**
   * ���ƎҔԍ����x�����擾���܂��B
   * @return ���ƎҔԍ����x��
   */
  public ACLabel getSupportProviderCd(){
    if(supportProviderCd==null){

      supportProviderCd = new ACLabel();

      supportProviderCd.setColumns(10);

      addSupportProviderCd();
    }
    return supportProviderCd;

  }

  /**
   * ���ƎҖ��̃R���{���擾���܂��B
   * @return ���ƎҖ��̃R���{
   */
  public ACComboBox getSupportProviderName(){
    if(supportProviderName==null){

      supportProviderName = new ACComboBox();

      supportProviderName.setBindPath("PROVIDER_ID");

      supportProviderName.setEditable(false);

      supportProviderName.setRenderBindPath("PROVIDER_NAME");

      supportProviderName.setMaxColumns(30);

      supportProviderName.setModel(getSupportProviderNameModel());

      addSupportProviderName();
    }
    return supportProviderName;

  }

  /**
   * ���ƎҖ��̃R���{���f�����擾���܂��B
   * @return ���ƎҖ��̃R���{���f��
   */
  protected ACComboBoxModelAdapter getSupportProviderNameModel(){
    if(supportProviderNameModel==null){
      supportProviderNameModel = new ACComboBoxModelAdapter();
      addSupportProviderNameModel();
    }
    return supportProviderNameModel;
  }

  /**
   * �S���҃R���{���擾���܂��B
   * @return �S���҃R���{
   */
  public ACComboBox getPersonInCharge(){
    if(personInCharge==null){

      personInCharge = new ACComboBox();

      getPersonInChargeContainer().setText("�S���Җ�");

      personInCharge.setBindPath("STAFF_NAME");

      personInCharge.setEditable(false);

      personInCharge.setRenderBindPath("STAFF_NAME");

      personInCharge.setMaxColumns(30);

      personInCharge.setModel(getPersonInChargeModel());

      addPersonInCharge();
    }
    return personInCharge;

  }

  /**
   * �S���҃R���{�R���e�i���擾���܂��B
   * @return �S���҃R���{�R���e�i
   */
  protected ACLabelContainer getPersonInChargeContainer(){
    if(personInChargeContainer==null){
      personInChargeContainer = new ACLabelContainer();
      personInChargeContainer.setFollowChildEnabled(true);
      personInChargeContainer.setVAlignment(VRLayout.CENTER);
      personInChargeContainer.add(getPersonInCharge(), VRLayout.CLIENT);
    }
    return personInChargeContainer;
  }

  /**
   * �S���҃R���{���f�����擾���܂��B
   * @return �S���҃R���{���f��
   */
  protected ACComboBoxModelAdapter getPersonInChargeModel(){
    if(personInChargeModel==null){
      personInChargeModel = new ACComboBoxModelAdapter();
      addPersonInChargeModel();
    }
    return personInChargeModel;
  }

  /**
   * ��i�̈�E���擾���܂��B
   * @return ��i�̈�E
   */
  public ACPanel getUpperRights(){
    if(upperRights==null){

      upperRights = new ACPanel();

      upperRights.setHgrid(300);

      addUpperRights();
    }
    return upperRights;

  }

  /**
   * �쐬�N�����i�ʕ\�j���擾���܂��B
   * @return �쐬�N�����i�ʕ\�j
   */
  public QkanDateTextField getDateOfMakingOutsideFrame(){
    if(dateOfMakingOutsideFrame==null){

      dateOfMakingOutsideFrame = new QkanDateTextField();

      getDateOfMakingOutsideFrameContainer().setText("�쐬�N�����i�ʕ\�j");

      dateOfMakingOutsideFrame.setBindPath("CREATE_DATE_OUTER");

      addDateOfMakingOutsideFrame();
    }
    return dateOfMakingOutsideFrame;

  }

  /**
   * �쐬�N�����i�ʕ\�j�R���e�i���擾���܂��B
   * @return �쐬�N�����i�ʕ\�j�R���e�i
   */
  protected ACLabelContainer getDateOfMakingOutsideFrameContainer(){
    if(dateOfMakingOutsideFrameContainer==null){
      dateOfMakingOutsideFrameContainer = new ACLabelContainer();
      dateOfMakingOutsideFrameContainer.setFollowChildEnabled(true);
      dateOfMakingOutsideFrameContainer.setVAlignment(VRLayout.CENTER);
      dateOfMakingOutsideFrameContainer.add(getDateOfMakingOutsideFrame(), null);
    }
    return dateOfMakingOutsideFrameContainer;
  }

  /**
   * �쐬�N�������擾���܂��B
   * @return �쐬�N����
   */
  public QkanDateTextField getDateOfMaking(){
    if(dateOfMaking==null){

      dateOfMaking = new QkanDateTextField();

      getDateOfMakingContainer().setText("�쐬�N����");

      dateOfMaking.setBindPath("CREATE_DATE_INNER");

      addDateOfMaking();
    }
    return dateOfMaking;

  }

  /**
   * �쐬�N�����R���e�i���擾���܂��B
   * @return �쐬�N�����R���e�i
   */
  protected ACLabelContainer getDateOfMakingContainer(){
    if(dateOfMakingContainer==null){
      dateOfMakingContainer = new ACLabelContainer();
      dateOfMakingContainer.setFollowChildEnabled(true);
      dateOfMakingContainer.setVAlignment(VRLayout.CENTER);
      dateOfMakingContainer.add(getDateOfMaking(), null);
    }
    return dateOfMakingContainer;
  }

  /**
   * �͏o�N�������擾���܂��B
   * @return �͏o�N����
   */
  public QkanDateTextField getDateOfWrittenReport(){
    if(dateOfWrittenReport==null){

      dateOfWrittenReport = new QkanDateTextField();

      getDateOfWrittenReportContainer().setText("�͏o�N����");

      dateOfWrittenReport.setBindPath("DATE_OF_WRITTEN_REPORT");

      addDateOfWrittenReport();
    }
    return dateOfWrittenReport;

  }

  /**
   * �͏o�N�����R���e�i���擾���܂��B
   * @return �͏o�N�����R���e�i
   */
  protected ACLabelContainer getDateOfWrittenReportContainer(){
    if(dateOfWrittenReportContainer==null){
      dateOfWrittenReportContainer = new ACLabelContainer();
      dateOfWrittenReportContainer.setFollowChildEnabled(true);
      dateOfWrittenReportContainer.setVAlignment(VRLayout.CENTER);
      dateOfWrittenReportContainer.add(getDateOfWrittenReport(), null);
    }
    return dateOfWrittenReportContainer;
  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getSolid2(){
    if(solid2==null){

      solid2 = new ACLabel();

      solid2.setText("�i��ی��Ҏ��ȍ쐬�̏ꍇ�̂݁j");

      addSolid2();
    }
    return solid2;

  }

  /**
   * ���i�̈���擾���܂��B
   * @return ���i�̈�
   */
  public ACPanel getMiddles(){
    if(middles==null){

      middles = new ACPanel();

      middles.setAutoWrap(false);

      addMiddles();
    }
    return middles;

  }

  /**
   * �v����ԋ敪�̈���擾���܂��B
   * @return �v����ԋ敪�̈�
   */
  public ACGroupBox getStateOfYouKaigo(){
    if(stateOfYouKaigo==null){

      stateOfYouKaigo = new ACGroupBox();

      stateOfYouKaigo.setText("�v����ԋ敪");

      stateOfYouKaigo.setAutoWrap(false);

      addStateOfYouKaigo();
    }
    return stateOfYouKaigo;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getYouKaigodoType1(){
    if(youKaigodoType1==null){

      youKaigodoType1 = new ACLabel();

      youKaigodoType1.setBindPath("YOKAIGODO_TYPE1");

      addYouKaigodoType1();
    }
    return youKaigodoType1;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getYouKaigodoType2(){
    if(youKaigodoType2==null){

      youKaigodoType2 = new ACLabel();

      youKaigodoType2.setBindPath("YOKAIGODO_TYPE2");

      addYouKaigodoType2();
    }
    return youKaigodoType2;

  }

  /**
   * ���x�z���̈���擾���܂��B
   * @return ���x�z���̈�
   */
  public ACPanel getLimitAmountInformation(){
    if(limitAmountInformation==null){

      limitAmountInformation = new ACPanel();

      addLimitAmountInformation();
    }
    return limitAmountInformation;

  }

  /**
   * ���x�z�R���e�i���擾���܂��B
   * @return ���x�z�R���e�i
   */
  public ACLabelContainer getLimitAmountContainer(){
    if(limitAmountContainer==null){

      limitAmountContainer = new ACLabelContainer();

      limitAmountContainer.setText("�x�����x��z");

      addLimitAmountContainer();
    }
    return limitAmountContainer;

  }

  /**
   * �x�����x��z���擾���܂��B
   * @return �x�����x��z
   */
  public ACTextField getLimitAmountContent(){
    if(limitAmountContent==null){

      limitAmountContent = new ACTextField();

      limitAmountContent.setBindPath("LIMIT_AMOUNT_CONTENT");

      limitAmountContent.setEditable(false);

      limitAmountContent.setColumns(9);

      limitAmountContent.setCharType(VRCharType.ONLY_DIGIT);

      limitAmountContent.setHorizontalAlignment(SwingConstants.RIGHT);

      limitAmountContent.setIMEMode(InputSubset.LATIN);

      limitAmountContent.setMaxLength(15);

      addLimitAmountContent();
    }
    return limitAmountContent;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getSolid4(){
    if(solid4==null){

      solid4 = new ACLabel();

      solid4.setText("�P��");

      addSolid4();
    }
    return solid4;

  }

  /**
   * ���x�z�K�p���ԃR���e�i���擾���܂��B
   * @return ���x�z�K�p���ԃR���e�i
   */
  public ACLabelContainer getLimitAmountApplicationPeriod(){
    if(limitAmountApplicationPeriod==null){

      limitAmountApplicationPeriod = new ACLabelContainer();

      limitAmountApplicationPeriod.setText("���x�z�K�p����");

      addLimitAmountApplicationPeriod();
    }
    return limitAmountApplicationPeriod;

  }

  /**
   * �K�p���ԊJ�n���擾���܂��B
   * @return �K�p���ԊJ�n
   */
  public ACTextField getApplicationPeriodBegin(){
    if(applicationPeriodBegin==null){

      applicationPeriodBegin = new ACTextField();

      applicationPeriodBegin.setBindPath("INSURE_VALID_START");

      applicationPeriodBegin.setEditable(false);

      applicationPeriodBegin.setColumns(8);

      addApplicationPeriodBegin();
    }
    return applicationPeriodBegin;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getSolid5(){
    if(solid5==null){

      solid5 = new ACLabel();

      solid5.setText("����");

      addSolid5();
    }
    return solid5;

  }

  /**
   * �K�p���ԏI�����擾���܂��B
   * @return �K�p���ԏI��
   */
  public ACTextField getApplicationPeriodEnd(){
    if(applicationPeriodEnd==null){

      applicationPeriodEnd = new ACTextField();

      applicationPeriodEnd.setBindPath("INSURE_VALID_END");

      applicationPeriodEnd.setEditable(false);

      applicationPeriodEnd.setColumns(8);

      addApplicationPeriodEnd();
    }
    return applicationPeriodEnd;

  }

  /**
   * �Z������������̈���擾���܂��B
   * @return �Z������������̈�
   */
  public ACPanel getShortStayAndPublicExpense(){
    if(shortStayAndPublicExpense==null){

      shortStayAndPublicExpense = new ACPanel();

      addShortStayAndPublicExpense();
    }
    return shortStayAndPublicExpense;

  }

  /**
   * �Z���������p�����R���e�i���擾���܂��B
   * @return �Z���������p�����R���e�i
   */
  public ACLabelContainer getShortStayUseDays(){
    if(shortStayUseDays==null){

      shortStayUseDays = new ACLabelContainer();

      addShortStayUseDays();
    }
    return shortStayUseDays;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getSolid6(){
    if(solid6==null){

      solid6 = new ACLabel();

      solid6.setText("�O���܂ł̒Z���������p����");

      addSolid6();
    }
    return solid6;

  }

  /**
   * �Z���������p�������擾���܂��B
   * @return �Z���������p����
   */
  public ACTextField getShortStayUseDay(){
    if(shortStayUseDay==null){

      shortStayUseDay = new ACTextField();

      shortStayUseDay.setBindPath("SHORT_STAY_USE_DAY");

      shortStayUseDay.setColumns(3);

      shortStayUseDay.setCharType(VRCharType.ONLY_DIGIT);

      shortStayUseDay.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayUseDay.setIMEMode(InputSubset.LATIN);

      shortStayUseDay.setMaxLength(15);

      addShortStayUseDay();
    }
    return shortStayUseDay;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getSolid8(){
    if(solid8==null){

      solid8 = new ACLabel();

      solid8.setText("��");

      addSolid8();
    }
    return solid8;

  }

  /**
   * ����R���e�i���擾���܂��B
   * @return ����R���e�i
   */
  public ACLabelContainer getPublicExpenses(){
    if(publicExpenses==null){

      publicExpenses = new ACLabelContainer();

      addPublicExpenses();
    }
    return publicExpenses;

  }

  /**
   * ����`�F�b�N���擾���܂��B
   * @return ����`�F�b�N
   */
  public ACIntegerCheckBox getPublicExpense(){
    if(publicExpense==null){

      publicExpense = new ACIntegerCheckBox();

      publicExpense.setText("������܂߂����t���ŕʕ\���쐬(E)");

      publicExpense.setBindPath("WITH_PUBLIC_EXPENSE");

      publicExpense.setMnemonic('E');

      addPublicExpense();
    }
    return publicExpense;

  }

  /**
   * ���i�̈���擾���܂��B
   * @return ���i�̈�
   */
  public ACPanel getLowers(){
    if(lowers==null){

      lowers = new ACPanel();

      lowers.setAutoWrap(false);

      addLowers();
    }
    return lowers;

  }

  /**
   * ���[��ʑI���t���[�����擾���܂��B
   * @return ���[��ʑI���t���[��
   */
  public ACGroupBox getSlitTypes(){
    if(slitTypes==null){

      slitTypes = new ACGroupBox();

      slitTypes.setText("���[��ʑI��");

      addSlitTypes();
    }
    return slitTypes;

  }

  /**
   * ��ʑI�����擾���܂��B
   * @return ��ʑI��
   */
  public ACClearableRadioButtonGroup getSlitType(){
    if(slitType==null){

      slitType = new ACClearableRadioButtonGroup();

      slitType.setBindPath("SLIT_TYPE");

      slitType.setUseClearButton(false);

      slitType.setModel(getSlitTypeModel());

      addSlitType();
    }
    return slitType;

  }

  /**
   * ��ʑI�����f�����擾���܂��B
   * @return ��ʑI�����f��
   */
  protected ACListModelAdapter getSlitTypeModel(){
    if(slitTypeModel==null){
      slitTypeModel = new ACListModelAdapter();
      addSlitTypeModel();
    }
    return slitTypeModel;
  }

  /**
   * ���p�[���擾���܂��B
   * @return ���p�[
   */
  public ACRadioButtonItem getUseVoteType(){
    if(useVoteType==null){

      useVoteType = new ACRadioButtonItem();

      useVoteType.setText("���p�[");

      useVoteType.setGroup(getSlitType());

      addUseVoteType();
    }
    return useVoteType;

  }

  /**
   * �񋟕[���擾���܂��B
   * @return �񋟕[
   */
  public ACRadioButtonItem getOfferVote(){
    if(offerVote==null){

      offerVote = new ACRadioButtonItem();

      offerVote.setText("�񋟕[");

      offerVote.setGroup(getSlitType());

      addOfferVote();
    }
    return offerVote;

  }

  /**
   * ���[��ޑI���t���[�����擾���܂��B
   * @return ���[��ޑI���t���[��
   */
  public ACGroupBox getSlitKinds(){
    if(slitKinds==null){

      slitKinds = new ACGroupBox();

      slitKinds.setText("������钠�[�̑I��");

      addSlitKinds();
    }
    return slitKinds;

  }

  /**
   * ��ޑI�����擾���܂��B
   * @return ��ޑI��
   */
  public ACClearableRadioButtonGroup getSlitKind(){
    if(slitKind==null){

      slitKind = new ACClearableRadioButtonGroup();

      slitKind.setBindPath("SLIT_KIND");

      slitKind.setUseClearButton(false);

      slitKind.setModel(getSlitKindModel());

      addSlitKind();
    }
    return slitKind;

  }

  /**
   * ��ޑI�����f�����擾���܂��B
   * @return ��ޑI�����f��
   */
  protected ACListModelAdapter getSlitKindModel(){
    if(slitKindModel==null){
      slitKindModel = new ACListModelAdapter();
      addSlitKindModel();
    }
    return slitKindModel;
  }

  /**
   * ���p�[�E�ʕ\���擾���܂��B
   * @return ���p�[�E�ʕ\
   */
  public ACRadioButtonItem getUseVoteAndAttachedTable(){
    if(useVoteAndAttachedTable==null){

      useVoteAndAttachedTable = new ACRadioButtonItem();

      useVoteAndAttachedTable.setText("�{�[�ƕʕ\");

      useVoteAndAttachedTable.setGroup(getSlitKind());

      addUseVoteAndAttachedTable();
    }
    return useVoteAndAttachedTable;

  }

  /**
   * ���p�[���擾���܂��B
   * @return ���p�[
   */
  public ACRadioButtonItem getUseVoteKind(){
    if(useVoteKind==null){

      useVoteKind = new ACRadioButtonItem();

      useVoteKind.setText("�{�[");

      useVoteKind.setGroup(getSlitKind());

      addUseVoteKind();
    }
    return useVoteKind;

  }

  /**
   * �ʕ\���擾���܂��B
   * @return �ʕ\
   */
  public ACRadioButtonItem getAttachedTable(){
    if(attachedTable==null){

      attachedTable = new ACRadioButtonItem();

      attachedTable.setText("�ʕ\");

      attachedTable.setGroup(getSlitKind());

      addAttachedTable();
    }
    return attachedTable;

  }

  /**
   * �h�̎�ޑI���t���[�����擾���܂��B
   * @return �h�̎�ޑI���t���[��
   */
  public ACGroupBox getSlitKeisyos(){
    if(slitKeisyos==null){

      slitKeisyos = new ACGroupBox();

      slitKeisyos.setText("������闘�p�҂̌h��");

      addSlitKeisyos();
    }
    return slitKeisyos;

  }

  /**
   * ��ޑI�����擾���܂��B
   * @return ��ޑI��
   */
  public ACClearableRadioButtonGroup getSlitKeisyo(){
    if(slitKeisyo==null){

      slitKeisyo = new ACClearableRadioButtonGroup();

      slitKeisyo.setBindPath("SLIT_KEISYO");

      slitKeisyo.setUseClearButton(false);

      slitKeisyo.setModel(getSlitKeisyoModel());

      /** @TODO H26�N�x�ǉ� */

      addSlitKeisyo();
    }
    return slitKeisyo;

  }

  /**
   * ��ޑI�����f�����擾���܂��B
   * @return ��ޑI�����f��
   */
  protected ACListModelAdapter getSlitKeisyoModel(){
    if(slitKeisyoModel==null){
      slitKeisyoModel = new ACListModelAdapter();
      addSlitKeisyoModel();
    }
    return slitKeisyoModel;
  }

  /**
   * �l���擾���܂��B
   * @return �l
   */
  public ACRadioButtonItem getSama(){
    if(sama==null){

      sama = new ACRadioButtonItem();

      sama.setText("�l");

      sama.setGroup(getSlitKeisyo());

      addSama();
    }
    return sama;

  }

  /**
   * �a���擾���܂��B
   * @return �a
   */
  public ACRadioButtonItem getDono(){
    if(dono==null){

      dono = new ACRadioButtonItem();

      dono.setText("�a");

      dono.setGroup(getSlitKeisyo());

      addDono();
    }
    return dono;

  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNashi(){
    if(nashi==null){

      nashi = new ACRadioButtonItem();

      nashi.setText("�Ȃ�");

      nashi.setGroup(getSlitKeisyo());

      addNashi();
    }
    return nashi;

  }

  /**
   * �p�l�����擾���܂��B
   * @return �p�l��
   */
  public ACPanel getPrintButtonArea(){
    if(printButtonArea==null){

      printButtonArea = new ACPanel();

      addPrintButtonArea();
    }
    return printButtonArea;

  }

  /**
   * �{�^���p�l�����擾���܂��B
   * @return �{�^���p�l��
   */
  public ACPanel getPrintButtons(){
    if(printButtons==null){

      printButtons = new ACPanel();

      printButtons.setAutoWrap(false);

      addPrintButtons();
    }
    return printButtons;

  }

  /**
   * ������擾���܂��B
   * @return ���
   */
  public ACButton getPrint(){
    if(print==null){

      print = new ACButton();

      print.setText("���(P)");

      print.setToolTipText("��ʂ̐ݒ�ň�����܂��B");

      print.setMnemonic('P');

      addPrint();
    }
    return print;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACButton getEnd(){
    if(end==null){

      end = new ACButton();

      end.setText("����(C)");

      end.setToolTipText("��������ɉ�ʂ���܂��B");

      end.setMnemonic('C');

      addEnd();
    }
    return end;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001003Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(900, 310);

      // �E�B���h�E�𒆉��ɔz�u
      Point pos;
      try{
          pos= ACFrame.getInstance().getLocationOnScreen();
      }catch(Exception ex){
          pos = new Point(0,0);
      }
      Dimension screenSize = ACFrame.getInstance().getSize();
      Dimension frameSize = this.getSize();
      if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
      }
      this.setLocation((int)(pos.getX()+(screenSize.width - frameSize.width) / 2),
              (int)(pos.getY()+(screenSize.height - frameSize.height) / 2));

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

    this.getContentPane().add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getUppers(), VRLayout.NORTH);

    contents.add(getMiddles(), VRLayout.NORTH);

    contents.add(getLowers(), VRLayout.NORTH);

  }

  /**
   * ��i�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUppers(){

    uppers.add(getUpperLefts(), VRLayout.CLIENT);

    uppers.add(getUpperRights(), VRLayout.EAST);
  }

  /**
   * ��i�̈捶�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpperLefts(){

    upperLefts.add(getPatients(), VRLayout.NORTH);

    upperLefts.add(getPrividers(), VRLayout.NORTH);

  }

  /**
   * ���p�ҏ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatients(){

    patients.add(getPatentNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    patients.add(getServiceYearMonthContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���p�Җ����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatentName(){

  }

  /**
   * �N�����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceYearMonth(){

  }

  /**
   * ���Ǝҏ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrividers(){

    prividers.add(getPlanManufacturerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    prividers.add(getPersonInChargeContainer(), VRLayout.SOUTH);
    prividers.add(getSupportProviderContainer(), VRLayout.SOUTH);
  }

  /**
   * �v��쐬�҃��W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanManufacturer(){

  }

  /**
   * �v��쐬�҃��W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPlanManufacturerModel(){

    getSupportProvider().setButtonIndex(1);

    getPlanManufacturerModel().add(getSupportProvider());

    getPatent().setButtonIndex(2);

    getPlanManufacturerModel().add(getPatent());

    getPreventSupportProvider().setButtonIndex(3);

    getPlanManufacturerModel().add(getPreventSupportProvider());

  }

  /**
   * ������x�����Ǝ҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportProvider(){

  }

  /**
   * ��ی��҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatent(){

  }

  /**
   * ���\�h�x�����Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPreventSupportProvider(){

  }

  /**
   * ����x�����Ǝҏ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportProviderContainer(){

    supportProviderContainer.add(getSupportProviderCd(), VRLayout.FLOW_RETURN);

    supportProviderContainer.add(getSupportProviderName(), VRLayout.SOUTH);
  }

  /**
   * ���ƎҔԍ����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportProviderCd(){

  }

  /**
   * ���ƎҖ��̃R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportProviderName(){

  }

  /**
   * ���ƎҖ��̃R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportProviderNameModel(){

  }

  /**
   * �S���҃R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPersonInCharge(){

  }

  /**
   * �S���҃R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPersonInChargeModel(){

  }

  /**
   * ��i�̈�E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpperRights(){

    upperRights.add(getDateOfMakingOutsideFrameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    upperRights.add(getDateOfMakingContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    upperRights.add(getDateOfWrittenReportContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    upperRights.add(getSolid2(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �쐬�N�����i�ʕ\�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDateOfMakingOutsideFrame(){

  }

  /**
   * �쐬�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDateOfMaking(){

  }

  /**
   * �͏o�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDateOfWrittenReport(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolid2(){

  }

  /**
   * ���i�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMiddles(){

    middles.add(getStateOfYouKaigo(), VRLayout.FLOW);

    middles.add(getLimitAmountInformation(), VRLayout.FLOW);

    middles.add(getShortStayAndPublicExpense(), VRLayout.FLOW);

  }

  /**
   * �v����ԋ敪�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStateOfYouKaigo(){

    stateOfYouKaigo.add(getYouKaigodoType1(), VRLayout.FLOW_RETURN);

    stateOfYouKaigo.add(getYouKaigodoType2(), VRLayout.FLOW_RETURN);

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYouKaigodoType1(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYouKaigodoType2(){

  }

  /**
   * ���x�z���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLimitAmountInformation(){

    limitAmountInformation.add(getLimitAmountContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    limitAmountInformation.add(getLimitAmountApplicationPeriod(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���x�z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLimitAmountContainer(){

    limitAmountContainer.add(getLimitAmountContent(), null);

    limitAmountContainer.add(getSolid4(), null);

  }

  /**
   * �x�����x��z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLimitAmountContent(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolid4(){

  }

  /**
   * ���x�z�K�p���ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLimitAmountApplicationPeriod(){

    limitAmountApplicationPeriod.add(getApplicationPeriodBegin(), null);

    limitAmountApplicationPeriod.add(getSolid5(), null);

    limitAmountApplicationPeriod.add(getApplicationPeriodEnd(), null);

  }

  /**
   * �K�p���ԊJ�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addApplicationPeriodBegin(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolid5(){

  }

  /**
   * �K�p���ԏI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addApplicationPeriodEnd(){

  }

  /**
   * �Z������������̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayAndPublicExpense(){

    shortStayAndPublicExpense.add(getShortStayUseDays(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayAndPublicExpense.add(getPublicExpenses(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * �Z���������p�����R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayUseDays(){

    shortStayUseDays.add(getSolid6(), null);

    shortStayUseDays.add(getShortStayUseDay(), null);

    shortStayUseDays.add(getSolid8(), null);

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolid6(){

  }

  /**
   * �Z���������p�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayUseDay(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolid8(){

  }

  /**
   * ����R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPublicExpenses(){

    publicExpenses.add(getPublicExpense(), null);

  }

  /**
   * ����`�F�b�N�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPublicExpense(){

  }

  /**
   * ���i�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowers(){

    lowers.add(getSlitTypes(), VRLayout.WEST);

    lowers.add(getSlitKinds(), VRLayout.WEST);

    lowers.add(getSlitKeisyos(), VRLayout.WEST);

    lowers.add(getPrintButtonArea(), VRLayout.CLIENT);

  }

  /**
   * ���[��ʑI���t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSlitTypes(){

    slitTypes.add(getSlitType(), null);

  }

  /**
   * ��ʑI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSlitType(){

  }

  /**
   * ��ʑI�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSlitTypeModel(){

    getUseVoteType().setButtonIndex(1);

    getSlitTypeModel().add(getUseVoteType());

    getOfferVote().setButtonIndex(2);

    getSlitTypeModel().add(getOfferVote());

  }

  /**
   * ���p�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUseVoteType(){

  }

  /**
   * �񋟕[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOfferVote(){

  }

  /**
   * ���[��ޑI���t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSlitKinds(){

    slitKinds.add(getSlitKind(), null);

  }

  /**
   * ��ޑI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSlitKind(){

  }

  /**
   * ��ޑI�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSlitKindModel(){

    getUseVoteAndAttachedTable().setButtonIndex(1);

    getSlitKindModel().add(getUseVoteAndAttachedTable());

    getUseVoteKind().setButtonIndex(2);

    getSlitKindModel().add(getUseVoteKind());

    getAttachedTable().setButtonIndex(3);

    getSlitKindModel().add(getAttachedTable());

  }

  /**
   * ���p�[�E�ʕ\�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUseVoteAndAttachedTable(){

  }

  /**
   * ���p�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUseVoteKind(){

  }

  /**
   * �ʕ\�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAttachedTable(){

  }

  /**
   * �h�̎�ޑI���t���[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSlitKeisyos(){

    slitKeisyos.add(getSlitKeisyo(), null);

  }

  /**
   * ��ޑI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSlitKeisyo(){

  }

  /**
   * ��ޑI�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSlitKeisyoModel(){

    getSama().setButtonIndex(1);

    getSlitKeisyoModel().add(getSama());

    getDono().setButtonIndex(2);

    getSlitKeisyoModel().add(getDono());

    getNashi().setButtonIndex(3);

    getSlitKeisyoModel().add(getNashi());

  }

  /**
   * �l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSama(){

  }

  /**
   * �a�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDono(){

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNashi(){

  }

  /**
   * �p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintButtonArea(){

    printButtonArea.add(getPrintButtons(), VRLayout.SOUTH);
  }

  /**
   * �{�^���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintButtons(){

    printButtons.add(getEnd(), VRLayout.EAST);
    printButtons.add(getPrint(), VRLayout.EAST);
  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrint(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnd(){

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

  public void setVisible(boolean visible){
    if(visible){
      try{
        initAffair(null);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(ex);
      }
    }
    super.setVisible(visible);
  }
  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      new QS001003Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001003Design getThis() {
    return this;
  }
}
