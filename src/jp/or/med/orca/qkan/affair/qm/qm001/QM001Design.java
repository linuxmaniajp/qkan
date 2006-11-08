
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
 * �J����: �� ����
 * �쐬��: 2006/05/25  ���{�R���s���[�^�[������� �� ���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���j���[ (M)
 * �v���Z�X ���O�C����� (001)
 * �v���O���� ���O�C����� (QM001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qm.qm001;
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
 * ���O�C����ʉ�ʍ��ڃf�U�C��(QM001) 
 */
public class QM001Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACPanel contents;

  private ACPanel titles;

  private ACLabel affairTitle;

  private ACLabel systemVersion;

  private ACPanel clients;

  private VRLayout clientsLayout;

  private ACLabel dummyNorth;

  private ACLabel dummyWest;

  private ACLabel dummyEast;

  private ACLabel dummySouth;

  private ACPanel mains;

  private ACPanel controls;

  private ACLabel subTitle;

  private ACLabel dummyMargin;

  private ACPanel combos;

  private ACComboBox providerList;

  private ACLabelContainer providerListContainer;

  private ACComboBoxModelAdapter providerListModel;

  private QkanDateTextField systemDate;

  private ACLabelContainer systemDateContainer;

  private ACPanel informations;

  private ACPanel versionErros;

  private ACLabel versionError;

  private ACPanel dbErros;

  private ACLabel dbConnectionError;

  private ACLabel dbmsError;

  private ACLabel dbVersionError;

  private ACPanel goSettingButtons1;

  private ACButton goSetting1;

  private ACPanel noProviders;

  private ACLabel noPropvider;

  private ACPanel goProviderButtons;

  private ACButton goProvider;

  private ACPanel shareDBs;

  private ACLabel shareDB;

  private ACPanel goSettingButtons3;

  private ACButton goSetting3;

  private ACPanel noInsurers;

  private ACLabel noInsurer;

  private ACPanel goInsurerButtons;

  private ACButton goInsurer;

  private ACPanel noPatients;

  private ACLabel noPatient;

  private ACPanel goPatientButtons;

  private ACButton goPatient;

  private ACPanel noPDFViewers;

  private ACLabel noPDFViewer;

  private ACPanel goSettingButtons2;

  private ACButton goSetting2;

  private ACPanel noErrors;

  private ACLabel noError;

  private ACGroupBox environments;

  private ACLabel environment;

  private ACPanel bottoms;

  private ACButton showVersion;

  private ACButton start;

  private ACButton end;

  private ACPanel copyrights;

  private ACLabel copyright;

  //getter

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      contents.setBackground(new Color(0,51,153));

      addContents();
    }
    return contents;

  }

  /**
   * �^�C�g���̈���擾���܂��B
   * @return �^�C�g���̈�
   */
  public ACPanel getTitles(){
    if(titles==null){

      titles = new ACPanel();

      titles.setBackground(new Color(0,51,153));

      addTitles();
    }
    return titles;

  }

  /**
   * �^�C�g�����擾���܂��B
   * @return �^�C�g��
   */
  public ACLabel getAffairTitle(){
    if(affairTitle==null){

      affairTitle = new ACLabel();

      affairTitle.setText("���t�Ǘ��^����V�����x���\�t�g�@Ver.");

      affairTitle.setForeground(Color.white);

      Font font = affairTitle.getFont();
      if(font!=null){
        affairTitle.setFont(new Font(font.getName(), font.getStyle(), 18));
      }

      addAffairTitle();
    }
    return affairTitle;

  }

  /**
   * �V�X�e���o�[�W�������擾���܂��B
   * @return �V�X�e���o�[�W����
   */
  public ACLabel getSystemVersion(){
    if(systemVersion==null){

      systemVersion = new ACLabel();

      systemVersion.setForeground(Color.white);

      Font font = systemVersion.getFont();
      if(font!=null){
        systemVersion.setFont(new Font(font.getName(), font.getStyle(), 18));
      }

      addSystemVersion();
    }
    return systemVersion;

  }

  /**
   * �����̈���擾���܂��B
   * @return �����̈�
   */
  public ACPanel getClients(){
    if(clients==null){

      clients = new ACPanel();

      clients.setLayout(getClientsLayout());

      clients.setBackground(new Color(0,51,153));

      addClients();
    }
    return clients;

  }

  /**
   * �����ʗ̈惌�C�A�E�g���擾���܂��B
   * @return �����ʗ̈惌�C�A�E�g
   */
  public VRLayout getClientsLayout(){
    if(clientsLayout==null){

      clientsLayout = new VRLayout();

      clientsLayout.setHgap(0);

      clientsLayout.setLabelMargin(0);

      clientsLayout.setVAlignment(VRLayout.CENTER);

      clientsLayout.setAlignment(VRLayout.CENTER);

      addClientsLayout();
    }
    return clientsLayout;

  }

  /**
   * �_�~�[����擾���܂��B
   * @return �_�~�[��
   */
  public ACLabel getDummyNorth(){
    if(dummyNorth==null){

      dummyNorth = new ACLabel();

      dummyNorth.setText(" ");

      dummyNorth.setRows(4);

      addDummyNorth();
    }
    return dummyNorth;

  }

  /**
   * �_�~�[�����擾���܂��B
   * @return �_�~�[��
   */
  public ACLabel getDummyWest(){
    if(dummyWest==null){

      dummyWest = new ACLabel();

      dummyWest.setText("�@");

      dummyWest.setColumns(4);

      addDummyWest();
    }
    return dummyWest;

  }

  /**
   * �_�~�[�E���擾���܂��B
   * @return �_�~�[�E
   */
  public ACLabel getDummyEast(){
    if(dummyEast==null){

      dummyEast = new ACLabel();

      dummyEast.setText("�@");

      dummyEast.setColumns(4);

      addDummyEast();
    }
    return dummyEast;

  }

  /**
   * �_�~�[�����擾���܂��B
   * @return �_�~�[��
   */
  public ACLabel getDummySouth(){
    if(dummySouth==null){

      dummySouth = new ACLabel();

      dummySouth.setText(" ");

      dummySouth.setRows(4);

      addDummySouth();
    }
    return dummySouth;

  }

  /**
   * ���C���̈���擾���܂��B
   * @return ���C���̈�
   */
  public ACPanel getMains(){
    if(mains==null){

      mains = new ACPanel();

      mains.setBackground(new Color(0,51,153));

      addMains();
    }
    return mains;

  }

  /**
   * �R���g���[���̈���擾���܂��B
   * @return �R���g���[���̈�
   */
  public ACPanel getControls(){
    if(controls==null){

      controls = new ACPanel();

      addControls();
    }
    return controls;

  }

  /**
   * �T�u�^�C�g�����擾���܂��B
   * @return �T�u�^�C�g��
   */
  public ACLabel getSubTitle(){
    if(subTitle==null){

      subTitle = new ACLabel();

      subTitle.setText("�@���O�C�����");

      subTitle.setOpaque(true);
      subTitle.setBackground(new Color(20,80,20));

      subTitle.setForeground(Color.white);

      addSubTitle();
    }
    return subTitle;

  }

  /**
   * �}�[�W�����擾���܂��B
   * @return �}�[�W��
   */
  public ACLabel getDummyMargin(){
    if(dummyMargin==null){

      dummyMargin = new ACLabel();

      dummyMargin.setText("�@");

      addDummyMargin();
    }
    return dummyMargin;

  }

  /**
   * �R���{�̈���擾���܂��B
   * @return �R���{�̈�
   */
  public ACPanel getCombos(){
    if(combos==null){

      combos = new ACPanel();

      combos.setAutoWrap(false);

      addCombos();
    }
    return combos;

  }

  /**
   * �����Ə��ꗗ���擾���܂��B
   * @return �����Ə��ꗗ
   */
  public ACComboBox getProviderList(){
    if(providerList==null){

      providerList = new ACComboBox();

      getProviderListContainer().setText("�����Ə��I��");

      providerList.setBindPath("PROVIDER_ID");

      providerList.setEditable(false);

      providerList.setModelBindPath("PROVIDER_LISTS");

      providerList.setRenderBindPath("SHOW_PROVIDER_NAME");

      providerList.setMaxColumns(24);

      providerList.setModel(getProviderListModel());

      addProviderList();
    }
    return providerList;

  }

  /**
   * �����Ə��ꗗ�R���e�i���擾���܂��B
   * @return �����Ə��ꗗ�R���e�i
   */
  protected ACLabelContainer getProviderListContainer(){
    if(providerListContainer==null){
      providerListContainer = new ACLabelContainer();
      providerListContainer.setFollowChildEnabled(true);
      providerListContainer.setVAlignment(VRLayout.CENTER);
      providerListContainer.add(getProviderList(), null);
    }
    return providerListContainer;
  }

  /**
   * �����Ə��ꗗ���f�����擾���܂��B
   * @return �����Ə��ꗗ���f��
   */
  protected ACComboBoxModelAdapter getProviderListModel(){
    if(providerListModel==null){
      providerListModel = new ACComboBoxModelAdapter();
      addProviderListModel();
    }
    return providerListModel;
  }

  /**
   * �V�X�e�����t���擾���܂��B
   * @return �V�X�e�����t
   */
  public QkanDateTextField getSystemDate(){
    if(systemDate==null){

      systemDate = new QkanDateTextField();

      getSystemDateContainer().setText("�V�X�e�����t");

      systemDate.setBindPath("SYSTEM_DATE");

      addSystemDate();
    }
    return systemDate;

  }

  /**
   * �V�X�e�����t�R���e�i���擾���܂��B
   * @return �V�X�e�����t�R���e�i
   */
  protected ACLabelContainer getSystemDateContainer(){
    if(systemDateContainer==null){
      systemDateContainer = new ACLabelContainer();
      systemDateContainer.setFollowChildEnabled(true);
      systemDateContainer.setVAlignment(VRLayout.CENTER);
      systemDateContainer.add(getSystemDate(), null);
    }
    return systemDateContainer;
  }

  /**
   * ���̈���擾���܂��B
   * @return ���̈�
   */
  public ACPanel getInformations(){
    if(informations==null){

      informations = new ACPanel();

      addInformations();
    }
    return informations;

  }

  /**
   * �V�X�e���o�[�W�����G���[���擾���܂��B
   * @return �V�X�e���o�[�W�����G���[
   */
  public ACPanel getVersionErros(){
    if(versionErros==null){

      versionErros = new ACPanel();

      addVersionErros();
    }
    return versionErros;

  }

  /**
   * �V�X�e���o�[�W�����G���[���b�Z�[�W���擾���܂��B
   * @return �V�X�e���o�[�W�����G���[���b�Z�[�W
   */
  public ACLabel getVersionError(){
    if(versionError==null){

      versionError = new ACLabel();

      versionError.setText("�V�X�e���̃o�[�W�������擾�Ɏ��s���܂����B�ݒ�t�@�C�����s�����j�����Ă���\��������܂��B�ăC���X�g�[�����s���Ă��������B");

      versionError.setIconPath(ACConstants.ICON_PATH_STOP_16);

      versionError.setAutoWrap(true);

      addVersionError();
    }
    return versionError;

  }

  /**
   * DB�G���[���擾���܂��B
   * @return DB�G���[
   */
  public ACPanel getDbErros(){
    if(dbErros==null){

      dbErros = new ACPanel();

      addDbErros();
    }
    return dbErros;

  }

  /**
   * DB�ڑ��G���[���b�Z�[�W���擾���܂��B
   * @return DB�ڑ��G���[���b�Z�[�W
   */
  public ACLabel getDbConnectionError(){
    if(dbConnectionError==null){

      dbConnectionError = new ACLabel();

      dbConnectionError.setText("�f�[�^�x�[�X�ւ̐ڑ��Ɏ��s���܂����B�u�ݒ�ύX�v��ʂŃf�[�^�x�[�X�̐ݒ���s���Ă��������B");

      dbConnectionError.setIconPath(ACConstants.ICON_PATH_STOP_16);

      dbConnectionError.setAutoWrap(true);

      addDbConnectionError();
    }
    return dbConnectionError;

  }

  /**
   * DBMS��Ή��G���[���b�Z�[�W���擾���܂��B
   * @return DBMS��Ή��G���[���b�Z�[�W
   */
  public ACLabel getDbmsError(){
    if(dbmsError==null){

      dbmsError = new ACLabel();

      dbmsError.setText("�f�[�^�x�[�X�̃o�[�W������񂪕s���ł��BFirebird�̍ăC���X�g�[�����s���Ă��������B");

      dbmsError.setIconPath(ACConstants.ICON_PATH_STOP_16);

      dbmsError.setAutoWrap(true);

      addDbmsError();
    }
    return dbmsError;

  }

  /**
   * DB�o�[�W�����G���[���b�Z�[�W���擾���܂��B
   * @return DB�o�[�W�����G���[���b�Z�[�W
   */
  public ACLabel getDbVersionError(){
    if(dbVersionError==null){

      dbVersionError = new ACLabel();

      dbVersionError.setText("�f�[�^�x�[�X�\���̃o�[�W�������擾�Ɏ��s���܂����B�f�[�^�x�[�X���s�����j�����Ă���\��������܂��B�ăC���X�g�[�����s���Ă��������B");

      dbVersionError.setIconPath(ACConstants.ICON_PATH_STOP_16);

      dbVersionError.setAutoWrap(true);

      addDbVersionError();
    }
    return dbVersionError;

  }

  /**
   * �J�ڃ{�^���̈���擾���܂��B
   * @return �J�ڃ{�^���̈�
   */
  public ACPanel getGoSettingButtons1(){
    if(goSettingButtons1==null){

      goSettingButtons1 = new ACPanel();

      addGoSettingButtons1();
    }
    return goSettingButtons1;

  }

  /**
   * �ݒ�ύX�J�ڃ{�^�����擾���܂��B
   * @return �ݒ�ύX�J�ڃ{�^��
   */
  public ACButton getGoSetting1(){
    if(goSetting1==null){

      goSetting1 = new ACButton();

      goSetting1.setText("�ݒ�ύX��ʂ�");

      addGoSetting1();
    }
    return goSetting1;

  }

  /**
   * �����Ə��Ȃ����擾���܂��B
   * @return �����Ə��Ȃ�
   */
  public ACPanel getNoProviders(){
    if(noProviders==null){

      noProviders = new ACPanel();

      addNoProviders();
    }
    return noProviders;

  }

  /**
   * �����Ə��Ȃ����b�Z�[�W���擾���܂��B
   * @return �����Ə��Ȃ����b�Z�[�W
   */
  public ACLabel getNoPropvider(){
    if(noPropvider==null){

      noPropvider = new ACLabel();

      noPropvider.setText("�����Ə������݂��܂���B�u���Ə��o�^�v��ʂŎ����Ə���1���ȏ�쐬���Ă��������B");

      noPropvider.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      noPropvider.setAutoWrap(true);

      addNoPropvider();
    }
    return noPropvider;

  }

  /**
   * �J�ڃ{�^���̈���擾���܂��B
   * @return �J�ڃ{�^���̈�
   */
  public ACPanel getGoProviderButtons(){
    if(goProviderButtons==null){

      goProviderButtons = new ACPanel();

      addGoProviderButtons();
    }
    return goProviderButtons;

  }

  /**
   * ���Ə��o�^�J�ڃ{�^�����擾���܂��B
   * @return ���Ə��o�^�J�ڃ{�^��
   */
  public ACButton getGoProvider(){
    if(goProvider==null){

      goProvider = new ACButton();

      goProvider.setText("���Ə��o�^��ʂ�");

      addGoProvider();
    }
    return goProvider;

  }

  /**
   * DB���L�m�F���擾���܂��B
   * @return DB���L�m�F
   */
  public ACPanel getShareDBs(){
    if(shareDBs==null){

      shareDBs = new ACPanel();

      addShareDBs();
    }
    return shareDBs;

  }

  /**
   * DB���L�m�F���b�Z�[�W���擾���܂��B
   * @return DB���L�m�F���b�Z�[�W
   */
  public ACLabel getShareDB(){
    if(shareDB==null){

      shareDB = new ACLabel();

      shareDB.setText("���̃R���s���[�^�[�ɂ̓f�[�^���쐬�����A���̃R���s���[�^�[�ɂ���f�[�^�x�[�X�����L����ꍇ�́u�ݒ�ύX�v��ʂŃf�[�^�x�[�X�̐ݒ���s���Ă��������B");

      shareDB.setIconPath(ACConstants.ICON_PATH_QUESTION_16);

      shareDB.setAutoWrap(true);

      addShareDB();
    }
    return shareDB;

  }

  /**
   * �J�ڃ{�^���̈���擾���܂��B
   * @return �J�ڃ{�^���̈�
   */
  public ACPanel getGoSettingButtons3(){
    if(goSettingButtons3==null){

      goSettingButtons3 = new ACPanel();

      addGoSettingButtons3();
    }
    return goSettingButtons3;

  }

  /**
   * �ݒ�ύX�J�ڃ{�^�����擾���܂��B
   * @return �ݒ�ύX�J�ڃ{�^��
   */
  public ACButton getGoSetting3(){
    if(goSetting3==null){

      goSetting3 = new ACButton();

      goSetting3.setText("�ݒ�ύX��ʂ�");

      addGoSetting3();
    }
    return goSetting3;

  }

  /**
   * �ی��҂Ȃ����擾���܂��B
   * @return �ی��҂Ȃ�
   */
  public ACPanel getNoInsurers(){
    if(noInsurers==null){

      noInsurers = new ACPanel();

      addNoInsurers();
    }
    return noInsurers;

  }

  /**
   * �ی��҂Ȃ����b�Z�[�W���擾���܂��B
   * @return �ی��҂Ȃ����b�Z�[�W
   */
  public ACLabel getNoInsurer(){
    if(noInsurer==null){

      noInsurer = new ACLabel();

      noInsurer.setText("�ی��҂��o�^����Ă��܂���B�u�ی��ғo�^�v��ʂŕی��҂�o�^���Ă��������B");

      noInsurer.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      noInsurer.setAutoWrap(true);

      addNoInsurer();
    }
    return noInsurer;

  }

  /**
   * �J�ڃ{�^���̈���擾���܂��B
   * @return �J�ڃ{�^���̈�
   */
  public ACPanel getGoInsurerButtons(){
    if(goInsurerButtons==null){

      goInsurerButtons = new ACPanel();

      addGoInsurerButtons();
    }
    return goInsurerButtons;

  }

  /**
   * �ی��ғo�^�J�ڃ{�^�����擾���܂��B
   * @return �ی��ғo�^�J�ڃ{�^��
   */
  public ACButton getGoInsurer(){
    if(goInsurer==null){

      goInsurer = new ACButton();

      goInsurer.setText("�ی��ғo�^��ʂ�");

      addGoInsurer();
    }
    return goInsurer;

  }

  /**
   * ���p�҂Ȃ����擾���܂��B
   * @return ���p�҂Ȃ�
   */
  public ACPanel getNoPatients(){
    if(noPatients==null){

      noPatients = new ACPanel();

      addNoPatients();
    }
    return noPatients;

  }

  /**
   * ���p�҂Ȃ����b�Z�[�W���擾���܂��B
   * @return ���p�҂Ȃ����b�Z�[�W
   */
  public ACLabel getNoPatient(){
    if(noPatient==null){

      noPatient = new ACLabel();

      noPatient.setText("���p�҂��o�^����Ă��܂���B�u���p�ғo�^�v��ʂŗ��p�҂�o�^���Ă��������B");

      noPatient.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      noPatient.setAutoWrap(true);

      addNoPatient();
    }
    return noPatient;

  }

  /**
   * �J�ڃ{�^���̈���擾���܂��B
   * @return �J�ڃ{�^���̈�
   */
  public ACPanel getGoPatientButtons(){
    if(goPatientButtons==null){

      goPatientButtons = new ACPanel();

      addGoPatientButtons();
    }
    return goPatientButtons;

  }

  /**
   * ���p�ғo�^�J�ڃ{�^�����擾���܂��B
   * @return ���p�ғo�^�J�ڃ{�^��
   */
  public ACButton getGoPatient(){
    if(goPatient==null){

      goPatient = new ACButton();

      goPatient.setText("���p�ғo�^��ʂ�");

      addGoPatient();
    }
    return goPatient;

  }

  /**
   * PDF�r���[���Ȃ����擾���܂��B
   * @return PDF�r���[���Ȃ�
   */
  public ACPanel getNoPDFViewers(){
    if(noPDFViewers==null){

      noPDFViewers = new ACPanel();

      addNoPDFViewers();
    }
    return noPDFViewers;

  }

  /**
   * PDF�r���[���Ȃ����b�Z�[�W���擾���܂��B
   * @return PDF�r���[���Ȃ����b�Z�[�W
   */
  public ACLabel getNoPDFViewer(){
    if(noPDFViewer==null){

      noPDFViewer = new ACLabel();

      noPDFViewer.setText("������ʂ�\������PDF�r���[�����w�肳��Ă��܂���B�u�ݒ�ύX�v��ʂ�PDF�r���[����ݒ肵�Ă��������B");

      noPDFViewer.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      noPDFViewer.setAutoWrap(true);

      addNoPDFViewer();
    }
    return noPDFViewer;

  }

  /**
   * �J�ڃ{�^���̈���擾���܂��B
   * @return �J�ڃ{�^���̈�
   */
  public ACPanel getGoSettingButtons2(){
    if(goSettingButtons2==null){

      goSettingButtons2 = new ACPanel();

      addGoSettingButtons2();
    }
    return goSettingButtons2;

  }

  /**
   * �ݒ�ύX�J�ڃ{�^�����擾���܂��B
   * @return �ݒ�ύX�J�ڃ{�^��
   */
  public ACButton getGoSetting2(){
    if(goSetting2==null){

      goSetting2 = new ACButton();

      goSetting2.setText("�ݒ�ύX��ʂ�");

      addGoSetting2();
    }
    return goSetting2;

  }

  /**
   * ����N�����擾���܂��B
   * @return ����N��
   */
  public ACPanel getNoErrors(){
    if(noErrors==null){

      noErrors = new ACPanel();

      addNoErrors();
    }
    return noErrors;

  }

  /**
   * ����N�����b�Z�[�W���擾���܂��B
   * @return ����N�����b�Z�[�W
   */
  public ACLabel getNoError(){
    if(noError==null){

      noError = new ACLabel();

      noError.setText("�V�X�e��������N�����܂����B�����Ə���I�����A�J�n�{�^�����������Ă��������B");

      noError.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      noError.setAutoWrap(true);

      addNoError();
    }
    return noError;

  }

  /**
   * �������擾���܂��B
   * @return �����
   */
  public ACGroupBox getEnvironments(){
    if(environments==null){

      environments = new ACGroupBox();

      environments.setText("�����");

      addEnvironments();
    }
    return environments;

  }

  /**
   * �����ڍׂ��擾���܂��B
   * @return �����ڍ�
   */
  public ACLabel getEnvironment(){
    if(environment==null){

      environment = new ACLabel();

      environment.setText("�������擾�ł��܂���B");

      addEnvironment();
    }
    return environment;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getBottoms(){
    if(bottoms==null){

      bottoms = new ACPanel();

      addBottoms();
    }
    return bottoms;

  }

  /**
   * �o�[�W�������\���{�^�����擾���܂��B
   * @return �o�[�W�������\���{�^��
   */
  public ACButton getShowVersion(){
    if(showVersion==null){

      showVersion = new ACButton();

      showVersion.setText("�o�[�W�������");

      showVersion.setToolTipText("�o�[�W��������\�����܂��B");

      addShowVersion();
    }
    return showVersion;

  }

  /**
   * �J�n���擾���܂��B
   * @return �J�n
   */
  public ACButton getStart(){
    if(start==null){

      start = new ACButton();

      start.setText("�J�n(S)");

      start.setToolTipText("�I�����������Ə��ŊJ�n���܂��B");

      start.setMnemonic('S');

      start.setIconPath(ACConstants.ICON_PATH_START_16);

      addStart();
    }
    return start;

  }

  /**
   * �I�����擾���܂��B
   * @return �I��
   */
  public ACButton getEnd(){
    if(end==null){

      end = new ACButton();

      end.setText("�I��(E)");

      end.setToolTipText("�v���O�������I�����܂��B");

      end.setMnemonic('E');

      end.setIconPath(ACConstants.ICON_PATH_EXIT_16);

      addEnd();
    }
    return end;

  }

  /**
   * �R�s�[���C�g�̈���擾���܂��B
   * @return �R�s�[���C�g�̈�
   */
  public ACPanel getCopyrights(){
    if(copyrights==null){

      copyrights = new ACPanel();

      copyrights.setBackground(new Color(0,51,153));

      addCopyrights();
    }
    return copyrights;

  }

  /**
   * �R�s�[���C�g���擾���܂��B
   * @return �R�s�[���C�g
   */
  public ACLabel getCopyright(){
    if(copyright==null){

      copyright = new ACLabel();

      copyright.setText("Copyright �i�Ёj���{��t�� 2006");

      copyright.setForeground(Color.white);

      addCopyright();
    }
    return copyright;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QM001Design() {

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

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getTitles(), VRLayout.NORTH);

    contents.add(getClients(), VRLayout.CLIENT);

    contents.add(getCopyrights(), VRLayout.SOUTH);
  }

  /**
   * �^�C�g���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTitles(){

    titles.add(getAffairTitle(), VRLayout.FLOW);

    titles.add(getSystemVersion(), VRLayout.FLOW);

  }

  /**
   * �^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAffairTitle(){

  }

  /**
   * �V�X�e���o�[�W�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSystemVersion(){

  }

  /**
   * �����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClients(){

    clients.add(getDummyNorth(), VRLayout.NORTH);

    clients.add(getDummyWest(), VRLayout.WEST);

    clients.add(getMains(), VRLayout.FLOW);

    clients.add(getDummyEast(), VRLayout.EAST);
    clients.add(getDummySouth(), VRLayout.SOUTH);
  }

  /**
   * �����ʗ̈惌�C�A�E�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addClientsLayout(){

  }

  /**
   * �_�~�[��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDummyNorth(){

  }

  /**
   * �_�~�[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDummyWest(){

  }

  /**
   * �_�~�[�E�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDummyEast(){

  }

  /**
   * �_�~�[���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDummySouth(){

  }

  /**
   * ���C���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMains(){

    mains.add(getControls(), VRLayout.CLIENT);

  }

  /**
   * �R���g���[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addControls(){

    controls.add(getSubTitle(), VRLayout.NORTH);

    controls.add(getDummyMargin(), VRLayout.NORTH);

    controls.add(getCombos(), VRLayout.NORTH);

    controls.add(getBottoms(), VRLayout.SOUTH);
    controls.add(getInformations(), VRLayout.SOUTH);
  }

  /**
   * �T�u�^�C�g���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSubTitle(){

  }

  /**
   * �}�[�W���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDummyMargin(){

  }

  /**
   * �R���{�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCombos(){

    combos.add(getProviderListContainer(), VRLayout.FLOW);

    combos.add(getSystemDateContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * �����Ə��ꗗ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderList(){

  }

  /**
   * �����Ə��ꗗ���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderListModel(){

  }

  /**
   * �V�X�e�����t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSystemDate(){

  }

  /**
   * ���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInformations(){

    informations.add(getVersionErros(), VRLayout.NORTH);

    informations.add(getDbErros(), VRLayout.NORTH);

    informations.add(getNoProviders(), VRLayout.NORTH);

    informations.add(getShareDBs(), VRLayout.NORTH);

    informations.add(getNoInsurers(), VRLayout.NORTH);

    informations.add(getNoPatients(), VRLayout.NORTH);

    informations.add(getNoPDFViewers(), VRLayout.NORTH);

    informations.add(getNoErrors(), VRLayout.NORTH);

    informations.add(getEnvironments(), VRLayout.CLIENT);

  }

  /**
   * �V�X�e���o�[�W�����G���[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVersionErros(){

    versionErros.add(getVersionError(), VRLayout.CLIENT);

  }

  /**
   * �V�X�e���o�[�W�����G���[���b�Z�[�W�ɓ������ڂ�ǉ����܂��B
   */
  protected void addVersionError(){

  }

  /**
   * DB�G���[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbErros(){

    dbErros.add(getDbConnectionError(), VRLayout.CLIENT);

    dbErros.add(getDbmsError(), VRLayout.CLIENT);

    dbErros.add(getDbVersionError(), VRLayout.CLIENT);

    dbErros.add(getGoSettingButtons1(), VRLayout.EAST);
  }

  /**
   * DB�ڑ��G���[���b�Z�[�W�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbConnectionError(){

  }

  /**
   * DBMS��Ή��G���[���b�Z�[�W�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbmsError(){

  }

  /**
   * DB�o�[�W�����G���[���b�Z�[�W�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDbVersionError(){

  }

  /**
   * �J�ڃ{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoSettingButtons1(){

    goSettingButtons1.add(getGoSetting1(), VRLayout.FLOW);

  }

  /**
   * �ݒ�ύX�J�ڃ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoSetting1(){

  }

  /**
   * �����Ə��Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoProviders(){

    noProviders.add(getNoPropvider(), VRLayout.CLIENT);

    noProviders.add(getGoProviderButtons(), VRLayout.EAST);
  }

  /**
   * �����Ə��Ȃ����b�Z�[�W�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoPropvider(){

  }

  /**
   * �J�ڃ{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoProviderButtons(){

    goProviderButtons.add(getGoProvider(), VRLayout.FLOW);

  }

  /**
   * ���Ə��o�^�J�ڃ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoProvider(){

  }

  /**
   * DB���L�m�F�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShareDBs(){

    shareDBs.add(getShareDB(), VRLayout.CLIENT);

    shareDBs.add(getGoSettingButtons3(), VRLayout.EAST);
  }

  /**
   * DB���L�m�F���b�Z�[�W�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShareDB(){

  }

  /**
   * �J�ڃ{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoSettingButtons3(){

    goSettingButtons3.add(getGoSetting3(), VRLayout.FLOW);

  }

  /**
   * �ݒ�ύX�J�ڃ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoSetting3(){

  }

  /**
   * �ی��҂Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoInsurers(){

    noInsurers.add(getNoInsurer(), VRLayout.CLIENT);

    noInsurers.add(getGoInsurerButtons(), VRLayout.EAST);
  }

  /**
   * �ی��҂Ȃ����b�Z�[�W�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoInsurer(){

  }

  /**
   * �J�ڃ{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoInsurerButtons(){

    goInsurerButtons.add(getGoInsurer(), VRLayout.FLOW);

  }

  /**
   * �ی��ғo�^�J�ڃ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoInsurer(){

  }

  /**
   * ���p�҂Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoPatients(){

    noPatients.add(getNoPatient(), VRLayout.CLIENT);

    noPatients.add(getGoPatientButtons(), VRLayout.EAST);
  }

  /**
   * ���p�҂Ȃ����b�Z�[�W�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoPatient(){

  }

  /**
   * �J�ڃ{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoPatientButtons(){

    goPatientButtons.add(getGoPatient(), VRLayout.FLOW);

  }

  /**
   * ���p�ғo�^�J�ڃ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoPatient(){

  }

  /**
   * PDF�r���[���Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoPDFViewers(){

    noPDFViewers.add(getNoPDFViewer(), VRLayout.CLIENT);

    noPDFViewers.add(getGoSettingButtons2(), VRLayout.EAST);
  }

  /**
   * PDF�r���[���Ȃ����b�Z�[�W�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoPDFViewer(){

  }

  /**
   * �J�ڃ{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoSettingButtons2(){

    goSettingButtons2.add(getGoSetting2(), VRLayout.FLOW);

  }

  /**
   * �ݒ�ύX�J�ڃ{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addGoSetting2(){

  }

  /**
   * ����N���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoErrors(){

    noErrors.add(getNoError(), VRLayout.CLIENT);

  }

  /**
   * ����N�����b�Z�[�W�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNoError(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnvironments(){

    environments.add(getEnvironment(), VRLayout.CLIENT);

  }

  /**
   * �����ڍׂɓ������ڂ�ǉ����܂��B
   */
  protected void addEnvironment(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBottoms(){

    bottoms.add(getShowVersion(), VRLayout.WEST);

    bottoms.add(getEnd(), VRLayout.EAST);
    bottoms.add(getStart(), VRLayout.EAST);
  }

  /**
   * �o�[�W�������\���{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShowVersion(){

  }

  /**
   * �J�n�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStart(){

  }

  /**
   * �I���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEnd(){

  }

  /**
   * �R�s�[���C�g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCopyrights(){

    copyrights.add(getCopyright(), VRLayout.EAST);
  }

  /**
   * �R�s�[���C�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCopyright(){

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

    return getProviderList();

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //�f�t�H���g�f�o�b�O�N��
    try {
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QM001Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QM001Design getThis() {
    return this;
  }
}
