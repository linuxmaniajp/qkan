
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
 * �쐬��: 2007/12/13  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �\��Ǘ� (S)
 * �v���Z�X �T�[�r�X�\�� (001)
 * �v���O���� �T�[�r�X�\�� (QS001)
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
 * �T�[�r�X�\���ʍ��ڃf�U�C��(QS001) 
 */
public class QS001Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton clearPlan;

  private ACAffairButton openPlan;

  private ACAffairButton clearResult;

  private ACAffairButton openResult;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACAffairButton printWeekly;

  private ACAffairButton printMonthly;

  private ACPanel contents;

  private ACPanel leftContents;

  private ACGroupBox serviceKinds;

  private ACListBox serviceKindList;

  private ACListModelAdapter serviceKindListModel;

  private ACGroupBox servicePatterns;

  private QS001DaySchedule patternList;

  private ACPanel patternListButtons;

  private ACButton patternAdd;

  private ACButton patternDelete;

  private ACButton patternNameChange;

  private ACGroupBox servuceDetails;

  private ACPanel serviceOfferEntrepreneurs;

  private ACComboBox serviceOfferEntrepreneur;

  private ACLabelContainer serviceOfferEntrepreneurContainer;

  private ACComboBoxModelAdapter serviceOfferEntrepreneurModel;

  private ACPanel serviceContentSettings;

  private ACLabel noServiceInfomation;

  private ACPanel serviceContentSettingButtons;

  private ACButton serviceSet;

  private ACButton serviceDelete;

  private QS001DraggableButton picture;

  private ACPanel rightContents;

  private ACGroupBox patientInfos;

  private ACLabel targetYearMonth;

  private ACLabel patientName;

  private ACLabel patientInsuredID;

  private ACPanel yokaigodoLimits;

  private ACTextField yokaigodo;

  private ACLabelContainer yokaigodoContainer;

  private ACPanel chartButtons;

  private ACButton changeChart;

  private ACLabel calendarInfomation;

  private ACPanel charts;

  //getter

  /**
   * �{�^���o�[���擾���܂��B
   * @return �{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("�T�[�r�X�\��");

      addButtons();
    }
    return buttons;

  }

  /**
   * �N���A(�\��)���擾���܂��B
   * @return �N���A(�\��)
   */
  public ACAffairButton getClearPlan(){
    if(clearPlan==null){

      clearPlan = new ACAffairButton();

      clearPlan.setText("�N���A(C)");

      clearPlan.setToolTipText("�\������N���A���܂��B");

      clearPlan.setMnemonic('C');

      clearPlan.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClearPlan();
    }
    return clearPlan;

  }

  /**
   * �O��Ǎ�(�\��)���擾���܂��B
   * @return �O��Ǎ�(�\��)
   */
  public ACAffairButton getOpenPlan(){
    if(openPlan==null){

      openPlan = new ACAffairButton();

      openPlan.setText("�O��Ǎ�(O)");

      openPlan.setToolTipText("�ߋ��ɗ��Ă��\��̒��ŁA�ŐV�̗\�����]�L���܂��B");

      openPlan.setMnemonic('O');

      openPlan.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpenPlan();
    }
    return openPlan;

  }

  /**
   * �N���A(����)���擾���܂��B
   * @return �N���A(����)
   */
  public ACAffairButton getClearResult(){
    if(clearResult==null){

      clearResult = new ACAffairButton();

      clearResult.setText("�N���A(C)");

      clearResult.setToolTipText("���я����N���A���܂��B");

      clearResult.setMnemonic('C');

      clearResult.setIconPath(ACConstants.ICON_PATH_CLEAR_24);

      addClearResult();
    }
    return clearResult;

  }

  /**
   * �\��Ǎ�(����)���擾���܂��B
   * @return �\��Ǎ�(����)
   */
  public ACAffairButton getOpenResult(){
    if(openResult==null){

      openResult = new ACAffairButton();

      openResult.setText("�\��Ǎ�(O)");

      openResult.setToolTipText("���т̑S�����Ɨ\��̓Ǎ����s���܂��B");

      openResult.setMnemonic('O');

      openResult.setIconPath(ACConstants.ICON_PATH_OPEN_24);

      addOpenResult();
    }
    return openResult;

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
   * ���(�T�ԕ\)���擾���܂��B
   * @return ���(�T�ԕ\)
   */
  public ACAffairButton getPrintWeekly(){
    if(printWeekly==null){

      printWeekly = new ACAffairButton();

      printWeekly.setText("���(P)");

      printWeekly.setToolTipText("�u�T�ԃT�[�r�X�v��\�v��������܂��B");

      printWeekly.setMnemonic('P');

      printWeekly.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrintWeekly();
    }
    return printWeekly;

  }

  /**
   * ���(���ԕ\)���擾���܂��B
   * @return ���(���ԕ\)
   */
  public ACAffairButton getPrintMonthly(){
    if(printMonthly==null){

      printMonthly = new ACAffairButton();

      printMonthly.setText("���(P)");

      printMonthly.setToolTipText("�u�T�[�r�X�\��[�E�񋟕[�v��������܂��B");

      printMonthly.setMnemonic('P');

      printMonthly.setIconPath(ACConstants.ICON_PATH_PRINT_24);

      addPrintMonthly();
    }
    return printMonthly;

  }

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
   * ���̈���擾���܂��B
   * @return ���̈�
   */
  public ACPanel getLeftContents(){
    if(leftContents==null){

      leftContents = new ACPanel();

      addLeftContents();
    }
    return leftContents;

  }

  /**
   * �T�[�r�X�I��̈���擾���܂��B
   * @return �T�[�r�X�I��̈�
   */
  public ACGroupBox getServiceKinds(){
    if(serviceKinds==null){

      serviceKinds = new ACGroupBox();

      serviceKinds.setText("�P.�T�[�r�X�̑I��");

      addServiceKinds();
    }
    return serviceKinds;

  }

  /**
   * �T�[�r�X��ރ��X�g���擾���܂��B
   * @return �T�[�r�X��ރ��X�g
   */
  public ACListBox getServiceKindList(){
    if(serviceKindList==null){

      serviceKindList = new ACListBox();

      serviceKindList.setModel(getServiceKindListModel());

      serviceKindList.setPreferredSize(new Dimension(240,120));

      addServiceKindList();
    }
    return serviceKindList;

  }

  /**
   * �T�[�r�X��ރ��X�g���f�����擾���܂��B
   * @return �T�[�r�X��ރ��X�g���f��
   */
  protected ACListModelAdapter getServiceKindListModel(){
    if(serviceKindListModel==null){
      serviceKindListModel = new ACListModelAdapter();
      addServiceKindListModel();
    }
    return serviceKindListModel;
  }

  /**
   * �p�^�[���ǉ��E�폜�̈���擾���܂��B
   * @return �p�^�[���ǉ��E�폜�̈�
   */
  public ACGroupBox getServicePatterns(){
    if(servicePatterns==null){

      servicePatterns = new ACGroupBox();

      servicePatterns.setText("�p�^�[���ǉ�/�폜");

      addServicePatterns();
    }
    return servicePatterns;

  }

  /**
   * �p�^�[�����X�g���擾���܂��B
   * @return �p�^�[�����X�g
   */
  public QS001DaySchedule getPatternList(){
    if(patternList==null){

      patternList = new QS001DaySchedule();

      patternList.setPreferredSize(new Dimension(100,80));

      patternList.setMoveMode(false);

      patternList.setRecieveMode(false);

      addPatternList();
    }
    return patternList;

  }

  /**
   * �p�^�[���{�^���̈���擾���܂��B
   * @return �p�^�[���{�^���̈�
   */
  public ACPanel getPatternListButtons(){
    if(patternListButtons==null){

      patternListButtons = new ACPanel();

      patternListButtons.setHgap(0);

      addPatternListButtons();
    }
    return patternListButtons;

  }

  /**
   * �p�^�[��-�ǉ����擾���܂��B
   * @return �p�^�[��-�ǉ�
   */
  public ACButton getPatternAdd(){
    if(patternAdd==null){

      patternAdd = new ACButton();

      patternAdd.setText("�ǉ�");

      addPatternAdd();
    }
    return patternAdd;

  }

  /**
   * �p�^�[��-�폜���擾���܂��B
   * @return �p�^�[��-�폜
   */
  public ACButton getPatternDelete(){
    if(patternDelete==null){

      patternDelete = new ACButton();

      patternDelete.setText("�폜");

      addPatternDelete();
    }
    return patternDelete;

  }

  /**
   * �p�^�[��-�ύX���擾���܂��B
   * @return �p�^�[��-�ύX
   */
  public ACButton getPatternNameChange(){
    if(patternNameChange==null){

      patternNameChange = new ACButton();

      patternNameChange.setText("����");

      addPatternNameChange();
    }
    return patternNameChange;

  }

  /**
   * �T�[�r�X���e�o�^�E�I��̈���擾���܂��B
   * @return �T�[�r�X���e�o�^�E�I��̈�
   */
  public ACGroupBox getServuceDetails(){
    if(servuceDetails==null){

      servuceDetails = new ACGroupBox();

      servuceDetails.setText("�Q.�T�[�r�X���e�o�^/�I��");

      addServuceDetails();
    }
    return servuceDetails;

  }

  /**
   * �T�[�r�X�񋟎��Ə��R���{�̈���擾���܂��B
   * @return �T�[�r�X�񋟎��Ə��R���{�̈�
   */
  public ACPanel getServiceOfferEntrepreneurs(){
    if(serviceOfferEntrepreneurs==null){

      serviceOfferEntrepreneurs = new ACPanel();

      addServiceOfferEntrepreneurs();
    }
    return serviceOfferEntrepreneurs;

  }

  /**
   * �T�[�r�X�񋟎��Ǝ҃R���{���擾���܂��B
   * @return �T�[�r�X�񋟎��Ǝ҃R���{
   */
  public ACComboBox getServiceOfferEntrepreneur(){
    if(serviceOfferEntrepreneur==null){

      serviceOfferEntrepreneur = new ACComboBox();

      getServiceOfferEntrepreneurContainer().setText("���Ə�");

      serviceOfferEntrepreneur.setBindPath("PROVIDER_ID");

      serviceOfferEntrepreneur.setEditable(false);

      serviceOfferEntrepreneur.setRenderBindPath("PROVIDER_NAME");

      serviceOfferEntrepreneur.setModel(getServiceOfferEntrepreneurModel());

      addServiceOfferEntrepreneur();
    }
    return serviceOfferEntrepreneur;

  }

  /**
   * �T�[�r�X�񋟎��Ǝ҃R���{�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟎��Ǝ҃R���{�R���e�i
   */
  protected ACLabelContainer getServiceOfferEntrepreneurContainer(){
    if(serviceOfferEntrepreneurContainer==null){
      serviceOfferEntrepreneurContainer = new ACLabelContainer();
      serviceOfferEntrepreneurContainer.setFollowChildEnabled(true);
      serviceOfferEntrepreneurContainer.setVAlignment(VRLayout.CENTER);
      serviceOfferEntrepreneurContainer.add(getServiceOfferEntrepreneur(), VRLayout.CLIENT);
    }
    return serviceOfferEntrepreneurContainer;
  }

  /**
   * �T�[�r�X�񋟎��Ǝ҃R���{���f�����擾���܂��B
   * @return �T�[�r�X�񋟎��Ǝ҃R���{���f��
   */
  protected ACComboBoxModelAdapter getServiceOfferEntrepreneurModel(){
    if(serviceOfferEntrepreneurModel==null){
      serviceOfferEntrepreneurModel = new ACComboBoxModelAdapter();
      addServiceOfferEntrepreneurModel();
    }
    return serviceOfferEntrepreneurModel;
  }

  /**
   * �T�[�r�X���e�ݒ�̈���擾���܂��B
   * @return �T�[�r�X���e�ݒ�̈�
   */
  public ACPanel getServiceContentSettings(){
    if(serviceContentSettings==null){

      serviceContentSettings = new ACPanel();

      serviceContentSettings.setBackground(new Color(233,255,240));

      addServiceContentSettings();
    }
    return serviceContentSettings;

  }

  /**
   * �񋟃T�[�r�X�Ȃ��̐������擾���܂��B
   * @return �񋟃T�[�r�X�Ȃ��̐���
   */
  public ACLabel getNoServiceInfomation(){
    if(noServiceInfomation==null){

      noServiceInfomation = new ACLabel();

      noServiceInfomation.setText("�񋟉\�ȃT�[�r�X������܂���B" + ACConstants.LINE_SEPARATOR + "���Ə��o�^��ʂɂāA" + ACConstants.LINE_SEPARATOR + "�񋟂���T�[�r�X��" + ACConstants.LINE_SEPARATOR + "�o�^���Ă��������B");

      noServiceInfomation.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      addNoServiceInfomation();
    }
    return noServiceInfomation;

  }

  /**
   * �T�[�r�X���e�ݒ�{�^���̈���擾���܂��B
   * @return �T�[�r�X���e�ݒ�{�^���̈�
   */
  public ACPanel getServiceContentSettingButtons(){
    if(serviceContentSettingButtons==null){

      serviceContentSettingButtons = new ACPanel();

      serviceContentSettingButtons.setAutoWrap(false);

      serviceContentSettingButtons.setHgap(0);

      addServiceContentSettingButtons();
    }
    return serviceContentSettingButtons;

  }

  /**
   * �ݒ�{�^�����擾���܂��B
   * @return �ݒ�{�^��
   */
  public ACButton getServiceSet(){
    if(serviceSet==null){

      serviceSet = new ACButton();

      serviceSet.setText("�ݒ�(A)");

      serviceSet.setMnemonic('A');

      addServiceSet();
    }
    return serviceSet;

  }

  /**
   * �폜�{�^�����擾���܂��B
   * @return �폜�{�^��
   */
  public ACButton getServiceDelete(){
    if(serviceDelete==null){

      serviceDelete = new ACButton();

      serviceDelete.setText("�폜(D)");

      serviceDelete.setMnemonic('D');

      addServiceDelete();
    }
    return serviceDelete;

  }

  /**
   * �G���擾���܂��B
   * @return �G
   */
  public QS001DraggableButton getPicture(){
    if(picture==null){

      picture = new QS001DraggableButton();

      picture.setIconPath(ACConstants.ICON_PATH_RIGHT_16);

      addPicture();
    }
    return picture;

  }

  /**
   * �E�̈���擾���܂��B
   * @return �E�̈�
   */
  public ACPanel getRightContents(){
    if(rightContents==null){

      rightContents = new ACPanel();

      addRightContents();
    }
    return rightContents;

  }

  /**
   * ���p�ҏ��̈���擾���܂��B
   * @return ���p�ҏ��̈�
   */
  public ACGroupBox getPatientInfos(){
    if(patientInfos==null){

      patientInfos = new ACGroupBox();

      patientInfos.setText("���p�ҏ��");

      addPatientInfos();
    }
    return patientInfos;

  }

  /**
   * �Ώ۔N�����擾���܂��B
   * @return �Ώ۔N��
   */
  public ACLabel getTargetYearMonth(){
    if(targetYearMonth==null){

      targetYearMonth = new ACLabel();

      targetYearMonth.setText("����99�N99��");

      addTargetYearMonth();
    }
    return targetYearMonth;

  }

  /**
   * ���p�Ҏ������擾���܂��B
   * @return ���p�Ҏ���
   */
  public ACLabel getPatientName(){
    if(patientName==null){

      patientName = new ACLabel();

      patientName.setText("(���p�Ҏ���)");

      addPatientName();
    }
    return patientName;

  }

  /**
   * ���p�Ҕ�ی��Ҕԍ����擾���܂��B
   * @return ���p�Ҕ�ی��Ҕԍ�
   */
  public ACLabel getPatientInsuredID(){
    if(patientInsuredID==null){

      patientInsuredID = new ACLabel();

      patientInsuredID.setText("(���p�Ҕ�ی��Ҕԍ�)");

      addPatientInsuredID();
    }
    return patientInsuredID;

  }

  /**
   * �v���x�E���x�z�̈���擾���܂��B
   * @return �v���x�E���x�z�̈�
   */
  public ACPanel getYokaigodoLimits(){
    if(yokaigodoLimits==null){

      yokaigodoLimits = new ACPanel();

      yokaigodoLimits.setAutoWrap(false);

      yokaigodoLimits.setHgap(0);

      addYokaigodoLimits();
    }
    return yokaigodoLimits;

  }

  /**
   * �v���x���擾���܂��B
   * @return �v���x
   */
  public ACTextField getYokaigodo(){
    if(yokaigodo==null){

      yokaigodo = new ACTextField();

      getYokaigodoContainer().setText("�v���x");

      yokaigodo.setEditable(false);

      yokaigodo.setColumns(6);

      yokaigodo.setHorizontalAlignment(SwingConstants.CENTER);

      addYokaigodo();
    }
    return yokaigodo;

  }

  /**
   * �v���x�R���e�i���擾���܂��B
   * @return �v���x�R���e�i
   */
  protected ACLabelContainer getYokaigodoContainer(){
    if(yokaigodoContainer==null){
      yokaigodoContainer = new ACLabelContainer();
      yokaigodoContainer.setFollowChildEnabled(true);
      yokaigodoContainer.setVAlignment(VRLayout.CENTER);
      yokaigodoContainer.add(getYokaigodo(), null);
    }
    return yokaigodoContainer;
  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getChartButtons(){
    if(chartButtons==null){

      chartButtons = new ACPanel();

      addChartButtons();
    }
    return chartButtons;

  }

  /**
   * ���ԕ\�E�T�ԕ\�ؑփ{�^�����擾���܂��B
   * @return ���ԕ\�E�T�ԕ\�ؑփ{�^��
   */
  public ACButton getChangeChart(){
    if(changeChart==null){

      changeChart = new ACButton();

      changeChart.setText("�ؑ�");

      addChangeChart();
    }
    return changeChart;

  }

  /**
   * �J�����_�������擾���܂��B
   * @return �J�����_����
   */
  public ACLabel getCalendarInfomation(){
    if(calendarInfomation==null){

      calendarInfomation = new ACLabel();

      calendarInfomation.setText("Shift�L�[�������Ȃ���h���b�O���h���b�v����ƁA�T�[�r�X�𕡐��ł��܂��B");

      calendarInfomation.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addCalendarInfomation();
    }
    return calendarInfomation;

  }

  /**
   * ���ԕ\�E�T�ԕ\�̈���擾���܂��B
   * @return ���ԕ\�E�T�ԕ\�̈�
   */
  public ACPanel getCharts(){
    if(charts==null){

      charts = new ACPanel();

      charts.setBackground(new Color(233,240,255));

      addCharts();
    }
    return charts;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001Design() {

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

    buttons.add(getPrintMonthly(), VRLayout.EAST);
    buttons.add(getPrintWeekly(), VRLayout.EAST);
    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
    buttons.add(getOpenResult(), VRLayout.EAST);
    buttons.add(getClearResult(), VRLayout.EAST);
    buttons.add(getOpenPlan(), VRLayout.EAST);
    buttons.add(getClearPlan(), VRLayout.EAST);
  }

  /**
   * �N���A(�\��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClearPlan(){

  }

  /**
   * �O��Ǎ�(�\��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOpenPlan(){

  }

  /**
   * �N���A(����)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClearResult(){

  }

  /**
   * �\��Ǎ�(����)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOpenResult(){

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
   * ���(�T�ԕ\)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintWeekly(){

  }

  /**
   * ���(���ԕ\)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPrintMonthly(){

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getLeftContents(), VRLayout.WEST);

    contents.add(getRightContents(), VRLayout.CLIENT);

  }

  /**
   * ���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLeftContents(){

    leftContents.add(getServiceKinds(), VRLayout.NORTH);

    leftContents.add(getServuceDetails(), VRLayout.CLIENT);

    leftContents.add(getServiceContentSettingButtons(), VRLayout.SOUTH);
  }

  /**
   * �T�[�r�X�I��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceKinds(){

    serviceKinds.add(getServiceKindList(), VRLayout.NORTH);

    serviceKinds.add(getServicePatterns(), VRLayout.NORTH);

  }

  /**
   * �T�[�r�X��ރ��X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceKindList(){

  }

  /**
   * �T�[�r�X��ރ��X�g���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceKindListModel(){

  }

  /**
   * �p�^�[���ǉ��E�폜�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServicePatterns(){

    servicePatterns.add(getPatternList(), VRLayout.CLIENT);

    servicePatterns.add(getPatternListButtons(), VRLayout.EAST);
  }

  /**
   * �p�^�[�����X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatternList(){

  }

  /**
   * �p�^�[���{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatternListButtons(){

    patternListButtons.add(getPatternAdd(), VRLayout.FLOW_RETURN);

    patternListButtons.add(getPatternDelete(), VRLayout.FLOW_RETURN);

    patternListButtons.add(getPatternNameChange(), VRLayout.FLOW_RETURN);

  }

  /**
   * �p�^�[��-�ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatternAdd(){

  }

  /**
   * �p�^�[��-�폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatternDelete(){

  }

  /**
   * �p�^�[��-�ύX�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatternNameChange(){

  }

  /**
   * �T�[�r�X���e�o�^�E�I��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServuceDetails(){

    servuceDetails.add(getServiceOfferEntrepreneurs(), VRLayout.NORTH);

    servuceDetails.add(getServiceContentSettings(), VRLayout.CLIENT);

  }

  /**
   * �T�[�r�X�񋟎��Ə��R���{�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceOfferEntrepreneurs(){

    serviceOfferEntrepreneurs.add(getServiceOfferEntrepreneurContainer(), VRLayout.CLIENT);

  }

  /**
   * �T�[�r�X�񋟎��Ǝ҃R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceOfferEntrepreneur(){

  }

  /**
   * �T�[�r�X�񋟎��Ǝ҃R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceOfferEntrepreneurModel(){

  }

  /**
   * �T�[�r�X���e�ݒ�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceContentSettings(){

    serviceContentSettings.add(getNoServiceInfomation(), VRLayout.CLIENT);

  }

  /**
   * �񋟃T�[�r�X�Ȃ��̐����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoServiceInfomation(){

  }

  /**
   * �T�[�r�X���e�ݒ�{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceContentSettingButtons(){

    serviceContentSettingButtons.add(getServiceSet(), VRLayout.FLOW);

    serviceContentSettingButtons.add(getServiceDelete(), VRLayout.FLOW);

    serviceContentSettingButtons.add(getPicture(), VRLayout.FLOW);

  }

  /**
   * �ݒ�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceSet(){

  }

  /**
   * �폜�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDelete(){

  }

  /**
   * �G�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPicture(){

  }

  /**
   * �E�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRightContents(){

    rightContents.add(getPatientInfos(), VRLayout.NORTH);

    rightContents.add(getChartButtons(), VRLayout.NORTH);

    rightContents.add(getCharts(), VRLayout.CLIENT);

  }

  /**
   * ���p�ҏ��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInfos(){

    patientInfos.add(getTargetYearMonth(), VRLayout.WEST);

    patientInfos.add(getPatientName(), VRLayout.FLOW);

    patientInfos.add(getPatientInsuredID(), VRLayout.FLOW);

    patientInfos.add(getYokaigodoLimits(), VRLayout.EAST);
  }

  /**
   * �Ώ۔N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTargetYearMonth(){

  }

  /**
   * ���p�Ҏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientName(){

  }

  /**
   * ���p�Ҕ�ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addPatientInsuredID(){

  }

  /**
   * �v���x�E���x�z�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodoLimits(){

    yokaigodoLimits.add(getYokaigodoContainer(), VRLayout.FLOW);

  }

  /**
   * �v���x�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYokaigodo(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addChartButtons(){

    chartButtons.add(getChangeChart(), VRLayout.WEST);

    chartButtons.add(getCalendarInfomation(), VRLayout.CLIENT);

  }

  /**
   * ���ԕ\�E�T�ԕ\�ؑփ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addChangeChart(){

  }

  /**
   * �J�����_�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalendarInfomation(){

  }

  /**
   * ���ԕ\�E�T�ԕ\�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCharts(){

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

    return getChangeChart();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001Design getThis() {
    return this;
  }
}
