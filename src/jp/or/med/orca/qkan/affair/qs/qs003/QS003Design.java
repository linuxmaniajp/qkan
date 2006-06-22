
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
 * �쐬��: 2005/12/22  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\�茎�� (003)
 * �v���O���� ���p�E�񋟕[��� (QS003)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs003;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
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
import jp.or.med.orca.qkan.lib.*;
/**
 * ���p�E�񋟕[�����ʍ��ڃf�U�C��(QS003) 
 */
public class QS003Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel uppers;

  private ACPanel upperLefts;

  private ACPanel patients;

  private ACLabel patentName;

  private ACLabel serviceYearMonth;

  private ACLabel solid1;

  private ACPanel prividers;

  private ACClearableRadioButtonGroup planManufacturer;

  private ACLabelContainer planManufacturerContainer;

  private ACListModelAdapter planManufacturerModel;

  private ACRadioButtonItem supportProvider;

  private ACRadioButtonItem patent;

  private ACLabelContainer supportProviderContainer;

  private VRLayout supportProviderContainerLayout;

  private ACLabel supportProviderCd;

  private ACComboBox supportProviderName;

  private ACComboBoxModelAdapter supportProviderNameModel;

  private ACComboBox personInCharge;

  private ACLabelContainer personInChargeContainer;

  private ACComboBoxModelAdapter personInChargeModel;

  private ACPanel upperRights;

  private VRLayout upperRightsLayout;

  private QkanDateTextField dateOfMakingOutsideFrame;

  private ACLabelContainer dateOfMakingOutsideFrameContainer;

  private QkanDateTextField dateOfMaking;

  private ACLabelContainer dateOfMakingContainer;

  private QkanDateTextField dateOfWrittenReport;

  private ACLabelContainer dateOfWrittenReportContainer;

  private ACLabel solid2;

  private ACPanel middles;

  private VRLayout middlesLayout;

  private ACPanel stateOfYouKaigo;

  private VRLayout stateOfYouKaigoLayout;

  private ACLabel solid3;

  private ACLabel youKaigodoType1;

  private ACLabel youKaigodoType2;

  private ACPanel limitAmountInformation;

  private ACLabelContainer limitAmountContainer;

  private ACTextField limitAmountContent;

  private ACLabel solid4;

  private ACLabelContainer limitAmountApplicationPeriod;

  private QkanYearDateTextField applicationPeriodBegin;

  private ACLabel solid5;

  private QkanYearDateTextField applicationPeriodEnd;

  private ACPanel shortStayAndPublicExpense;

  private ACLabelContainer shortStayUseDays;

  private ACLabel solid6;

  private ACTextField shortStayUseDay;

  private ACLabel solid8;

  private ACLabelContainer publicExpenses;

  private ACIntegerCheckBox publicExpense;

  private ACPanel lowers;

  private VRLayout lowersLayout;

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

  private ACPanel printButtonArea;

  private ACPanel printButtons;

  private VRLayout printButtonsLayout;

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
  public ACLabel getPatentName(){
    if(patentName==null){

      patentName = new ACLabel();

      patentName.setText("�������@����");

      patentName.setBindPath("PATIENT_NAME");

      addPatentName();
    }
    return patentName;

  }

  /**
   * �N�����x�����擾���܂��B
   * @return �N�����x��
   */
  public ACLabel getServiceYearMonth(){
    if(serviceYearMonth==null){

      serviceYearMonth = new ACLabel();

      serviceYearMonth.setText("����17�N8����");

      serviceYearMonth.setBindPath("TARGET_DATE");

      addServiceYearMonth();
    }
    return serviceYearMonth;

  }

  /**
   * ���p�[�@�񋟕[���x���i�Œ�j���擾���܂��B
   * @return ���p�[�@�񋟕[���x���i�Œ�j
   */
  public ACLabel getSolid1(){
    if(solid1==null){

      solid1 = new ACLabel();

      solid1.setText("���p�[�@�񋟕[");

      addSolid1();
    }
    return solid1;

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

      planManufacturer.setModel(getPlanManufacturerModel());

      planManufacturer.setUseClearButton(false);

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
   * ����x�����Ǝҏ��R���e�i���擾���܂��B
   * @return ����x�����Ǝҏ��R���e�i
   */
  public ACLabelContainer getSupportProviderContainer(){
    if(supportProviderContainer==null){

      supportProviderContainer = new ACLabelContainer();

      supportProviderContainer.setText("����x�����Ə�");

      supportProviderContainer.setLayout(getSupportProviderContainerLayout());

      addSupportProviderContainer();
    }
    return supportProviderContainer;

  }

  /**
   * ����x�����Ǝҏ�񃌃C�A�E�g���擾���܂��B
   * @return ����x�����Ǝҏ�񃌃C�A�E�g
   */
  public VRLayout getSupportProviderContainerLayout(){
    if(supportProviderContainerLayout==null){

      supportProviderContainerLayout = new VRLayout();

      supportProviderContainerLayout.setAutoWrap(false);

      supportProviderContainerLayout.setHgap(0);

      addSupportProviderContainerLayout();
    }
    return supportProviderContainerLayout;

  }

  /**
   * ���ƎҔԍ����x�����擾���܂��B
   * @return ���ƎҔԍ����x��
   */
  public ACLabel getSupportProviderCd(){
    if(supportProviderCd==null){

      supportProviderCd = new ACLabel();

      supportProviderCd.setText("8888888888");

      supportProviderCd.setBindPath("SUPPORT_PROVIDER_CD");

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

      supportProviderName.setBindPath("SUPORT_PROVIDER_NAME");

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

      personInCharge.setBindPath("PERSON_IN_CHARGE");

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
      personInChargeContainer.add(getPersonInCharge(), null);
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

      upperRights.setLayout(getUpperRightsLayout());

      addUpperRights();
    }
    return upperRights;

  }

  /**
   * ��i�̈�E���C�A�E�g���擾���܂��B
   * @return ��i�̈�E���C�A�E�g
   */
  public VRLayout getUpperRightsLayout(){
    if(upperRightsLayout==null){

      upperRightsLayout = new VRLayout();

      upperRightsLayout.setHgrid(300);

      addUpperRightsLayout();
    }
    return upperRightsLayout;

  }

  /**
   * �쐬�N�����i�g�O/�ʕ\�j���擾���܂��B
   * @return �쐬�N�����i�g�O/�ʕ\�j
   */
  public QkanDateTextField getDateOfMakingOutsideFrame(){
    if(dateOfMakingOutsideFrame==null){

      dateOfMakingOutsideFrame = new QkanDateTextField();

      getDateOfMakingOutsideFrameContainer().setText("�쐬�N�����i�g�O/�ʕ\�j");

      dateOfMakingOutsideFrame.setBindPath("CREATE_DATE_OUTER");

      addDateOfMakingOutsideFrame();
    }
    return dateOfMakingOutsideFrame;

  }

  /**
   * �쐬�N�����i�g�O/�ʕ\�j�R���e�i���擾���܂��B
   * @return �쐬�N�����i�g�O/�ʕ\�j�R���e�i
   */
  protected ACLabelContainer getDateOfMakingOutsideFrameContainer(){
    if(dateOfMakingOutsideFrameContainer==null){
      dateOfMakingOutsideFrameContainer = new ACLabelContainer();
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

      middles.setLayout(getMiddlesLayout());

      addMiddles();
    }
    return middles;

  }

  /**
   * ���i�̈惌�C�A�E�g���擾���܂��B
   * @return ���i�̈惌�C�A�E�g
   */
  public VRLayout getMiddlesLayout(){
    if(middlesLayout==null){

      middlesLayout = new VRLayout();

      middlesLayout.setAutoWrap(false);

      addMiddlesLayout();
    }
    return middlesLayout;

  }

  /**
   * �v����ԋ敪�̈���擾���܂��B
   * @return �v����ԋ敪�̈�
   */
  public ACPanel getStateOfYouKaigo(){
    if(stateOfYouKaigo==null){

      stateOfYouKaigo = new ACPanel();

      stateOfYouKaigo.setLayout(getStateOfYouKaigoLayout());

      addStateOfYouKaigo();
    }
    return stateOfYouKaigo;

  }

  /**
   * �v����ԋ敪�̈惌�C�A�E�g���擾���܂��B
   * @return �v����ԋ敪�̈惌�C�A�E�g
   */
  public VRLayout getStateOfYouKaigoLayout(){
    if(stateOfYouKaigoLayout==null){

      stateOfYouKaigoLayout = new VRLayout();

      stateOfYouKaigoLayout.setAutoWrap(false);

      addStateOfYouKaigoLayout();
    }
    return stateOfYouKaigoLayout;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getSolid3(){
    if(solid3==null){

      solid3 = new ACLabel();

      solid3.setText("�v����ԋ敪");

      addSolid3();
    }
    return solid3;

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

      limitAmountContainer.setText("�x�����x��z�F");

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
  public QkanYearDateTextField getApplicationPeriodBegin(){
    if(applicationPeriodBegin==null){

      applicationPeriodBegin = new QkanYearDateTextField();

      applicationPeriodBegin.setBindPath("INSURE_VALID_START");

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
  public QkanYearDateTextField getApplicationPeriodEnd(){
    if(applicationPeriodEnd==null){

      applicationPeriodEnd = new QkanYearDateTextField();

      applicationPeriodEnd.setBindPath("INSURE_VALID_END");

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

      lowers.setLayout(getLowersLayout());

      addLowers();
    }
    return lowers;

  }

  /**
   * ���i�̈���擾���܂��B
   * @return ���i�̈�
   */
  public VRLayout getLowersLayout(){
    if(lowersLayout==null){

      lowersLayout = new VRLayout();

      lowersLayout.setAutoWrap(false);

      addLowersLayout();
    }
    return lowersLayout;

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

      slitType.setModel(getSlitTypeModel());

      slitType.setUseClearButton(false);

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

      slitKind.setModel(getSlitKindModel());

      slitKind.setUseClearButton(false);

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

      printButtons.setLayout(getPrintButtonsLayout());

      addPrintButtons();
    }
    return printButtons;

  }

  /**
   * �{�^���p�l�����C�A�E�g���擾���܂��B
   * @return �{�^���p�l�����C�A�E�g
   */
  public VRLayout getPrintButtonsLayout(){
    if(printButtonsLayout==null){

      printButtonsLayout = new VRLayout();

      printButtonsLayout.setAutoWrap(false);

      addPrintButtonsLayout();
    }
    return printButtonsLayout;

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
  public QS003Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());

    setSize(900, 310);

    try {
      jbInit();
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

    uppers.add(getUpperLefts(), VRLayout.WEST);

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

    patients.add(getPatentName(), VRLayout.FLOW);

    patients.add(getServiceYearMonth(), VRLayout.FLOW);

    patients.add(getSolid1(), VRLayout.FLOW_RETURN);

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
   * ���p�[�@�񋟕[���x���i�Œ�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolid1(){

  }

  /**
   * ���Ǝҏ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrividers(){

    prividers.add(getPlanManufacturerContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    prividers.add(getSupportProviderContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    prividers.add(getPersonInChargeContainer(), VRLayout.FLOW_INSETLINE);

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

    getSupportProvider().setButtonIndex(0);
    getPlanManufacturerModel().add(getSupportProvider());

    getPatent().setButtonIndex(1);
    getPlanManufacturerModel().add(getPatent());

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
   * ����x�����Ǝҏ��R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportProviderContainer(){

    supportProviderContainer.add(getSupportProviderCd(), VRLayout.FLOW_RETURN);

    supportProviderContainer.add(getSupportProviderName(), null);

  }

  /**
   * ����x�����Ǝҏ�񃌃C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSupportProviderContainerLayout(){

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
   * ��i�̈�E���C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUpperRightsLayout(){

  }

  /**
   * �쐬�N�����i�g�O/�ʕ\�j�ɓ������ڂ�ǉ����܂��B
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
   * ���i�̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMiddlesLayout(){

  }

  /**
   * �v����ԋ敪�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStateOfYouKaigo(){

    stateOfYouKaigo.add(getSolid3(), VRLayout.FLOW_RETURN);

    stateOfYouKaigo.add(getYouKaigodoType1(), VRLayout.FLOW_RETURN);

    stateOfYouKaigo.add(getYouKaigodoType2(), VRLayout.FLOW_RETURN);

  }

  /**
   * �v����ԋ敪�̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStateOfYouKaigoLayout(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSolid3(){

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

    lowers.add(getPrintButtonArea(), VRLayout.CLIENT);

  }

  /**
   * ���i�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLowersLayout(){

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

    getUseVoteType().setButtonIndex(0);
    getSlitTypeModel().add(getUseVoteType());

    getOfferVote().setButtonIndex(1);
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

    getUseVoteAndAttachedTable().setButtonIndex(0);
    getSlitKindModel().add(getUseVoteAndAttachedTable());

    getUseVoteKind().setButtonIndex(1);
    getSlitKindModel().add(getUseVoteKind());

    getAttachedTable().setButtonIndex(2);
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
   * �{�^���p�l�����C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintButtonsLayout(){

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
  private void jbInit() throws Exception {
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
      }catch(Exception ex){
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
      new QS003Design().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS003Design getThis() {
    return this;
  }
}
