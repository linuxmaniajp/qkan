
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
 * �쐬��: 2015/03/13  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X ���ъm��E�����f�[�^�쐬 (005)
 * �v���O���� ���׏��ڍוҏW (QP005)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
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
 * ���׏��ڍוҏW��ʍ��ڃf�U�C��(QP005) 
 */
public class QP005Design extends QkanAffairContainer implements ACAffairable {
  //GUI�R���|�[�l���g

  private ACAffairButtonBar buttons;

  private ACAffairButton retotal;

  private ACAffairButton renewal;

  private ACPanel contens;

  private ACPanel commonInfoPanle;

  private ACPanel commonInfos;

  private ACLabel commonInfoPattern;

  private ACLabel commonInfoProvider;

  private ACLabel commonInfoDate;

  private ACLabel commmonInfoName;

  private ACLabel commonInfoPublicExpenseLabelAll;

  private ACLabel commonInfoPublicExpenseText;

  private JTabbedPane etcInfoTabs;

  private ACPanel basicInfos;

  private ACPanel basicInfo;

  private ACLabel basicInfoLabel;

  private ACTable basicInfoTable;

  private VRTableColumnModel basicInfoTableColumnModel;

  private ACTableColumn basicInfoTablecolumn0;

  private ACTableColumn basicInfoTablecolumn1;

  private ACTableColumn basicInfoTablecolumn2;

  private ACTableColumn basicInfoTablecolumn3;

  private ACTableColumn basicInfoTablecolumn4;

  private ACTableColumn basicInfoTablecolumn5;

  private ACTableColumn basicInfoTablecolumn6;

  private ACTableColumn basicInfoTablecolumn7;

  private ACTableColumn basicInfoTablecolumn8;

  private ACTableColumn basicInfoTablecolumn9;

  private ACTableColumn basicInfoTablecolumn10;

  private ACTableColumn basicInfoTablecolumn11;

  private ACTableColumn basicInfoTablecolumn12;

  private ACTableColumn basicInfoTablecolumn13;

  private ACTableColumn basicInfoTablecolumn14;

  private ACPanel basicInfoRevisionPanel;

  private ACLabel basicInfoRevisionLabel;

  private ACLabel basicInfoRevisionLabel2;

  private ACIntegerCheckBox basicInfoRevisionCheck;

  private ACTable basicInfoRevisionTable;

  private VRTableColumnModel basicInfoRevisionTableColumnModel;

  private ACTableColumn basicInfoRevisionTablecolumn0;

  private ACTableColumn basicInfoRevisionTablecolumn1;

  private ACTableColumn basicInfoRevisionTablecolumn2;

  private ACTableColumn basicInfoRevisionTablecolumn3;

  private ACPanel detailsInfos;

  private ACPanel detailsInfoPanel;

  private ACLabel detailsInfoLabel;

  private ACButton detailsDelButton;

  private ACTable detailsInfoTable;

  private VRTableColumnModel detailsInfoTableColumnModel;

  private ACTableColumn detailsInfoTablecolumn0;

  private ACTableColumn detailsInfoTablecolumn1;

  private ACTableColumn detailsInfoTablecolumn2;

  private ACTableColumn detailsInfoTablecolumn3;

  private ACTableColumn detailsInfoTablecolumn4;

  private ACTableColumn detailsInfoTablecolumn5;

  private ACTableColumn detailsInfoTablecolumn6;

  private ACTableColumn detailsInfoTablecolumn7;

  private ACTableColumn detailsInfoTablecolumn8;

  private ACTableColumn detailsInfoTablecolumn9;

  private ACTableColumn detailsInfoTablecolumn10;

  private ACTableColumn detailsInfoTablecolumn11;

  private ACTableColumn detailsInfoTablecolumn12;

  private ACTable kyotakuDetailsInfoTable;

  private VRTableColumnModel kyotakuDetailsInfoTableColumnModel;

  private ACTableColumn kyotakuDetailsInfoTablecolumn0;

  private ACTableColumn kyotakuDetailsInfoTablecolumn1;

  private ACTableColumn kyotakuDetailsInfoTablecolumn2;

  private ACTableColumn kyotakuDetailsInfoTablecolumn3;

  private ACTableColumn kyotakuDetailsInfoTablecolumn4;

  private ACTableColumn kyotakuDetailsInfoTablecolumn5;

  private ACTableColumn kyotakuDetailsInfoTablecolumn6;

  private ACTableColumn kyotakuDetailsInfoTablecolumn7;

  private ACTableColumn kyotakuDetailsInfoTablecolumn8;

  private ACTableColumn kyotakuDetailsInfoTablecolumn9;

  private ACTableColumn kyotakuDetailsInfoTablecolumn10;

  private ACPanel detailsInfoRevisionPanel;

  private ACLabel detailsInfoRevisionLabel;

  private ACLabel detailsInfoRevision;

  private ACIntegerCheckBox detailsInfoRevisionCheck;

  private ACTable detailsInfoRevisionTable;

  private VRTableColumnModel detailsInfoRevisionTableColumnModel;

  private ACTableColumn detailsInfoRevisionTablecolumn0;

  private ACTableColumn detailsInfoRevisionTablecolumn1;

  private ACTableColumn detailsInfoRevisionTablecolumn2;

  private ACTableColumn detailsInfoRevisionTablecolumn3;

  private ACPanel particularInfos;

  private ACPanel particularInfoPanel;

  private ACLabel particularInfoLabel;

  private ACTable particularInfoTable;

  private VRTableColumnModel particularInfoTableColumnModel;

  private ACTableColumn particularInfoTablecolumn0;

  private ACTableColumn particularInfoTablecolumn1;

  private ACTableColumn particularInfoTablecolumn2;

  private ACTableColumn particularInfoTablecolumn3;

  private ACTableColumn particularInfoTablecolumn4;

  private ACTableColumn particularInfoTablecolumn5;

  private ACTableColumn particularInfoTablecolumn6;

  private ACTableColumn particularInfoTablecolumn7;

  private ACTableColumn particularInfoTablecolumn8;

  private ACTableColumn particularInfoTablecolumn9;

  private ACTableColumn particularInfoTablecolumn10;

  private ACTableColumn particularInfoTablecolumn11;

  private ACTableColumn particularInfoTablecolumn12;

  private ACTableColumn particularInfoTablecolumn13;

  private ACTableColumn particularInfoTablecolumn14;

  private ACTableColumn particularInfoTablecolumn15;

  private ACTableColumn particularInfoTablecolumn16;

  private ACTableColumn particularInfoTablecolumn17;

  private ACTableColumn particularInfoTablecolumn18;

  private ACTableColumn particularInfoTablecolumn19;

  private ACTable specialClinicInfoTable;

  private VRTableColumnModel specialClinicInfoTableColumnModel;

  private ACTableColumn specialClinicInfoTablecolumn0;

  private ACTableColumn specialClinicInfoTablecolumn1;

  private ACTableColumn specialClinicInfoTablecolumn2;

  private ACTableColumn specialClinicInfoTablecolumn3;

  private ACTableColumn specialClinicInfoTablecolumn4;

  private ACTableColumn specialClinicInfoTablecolumn5;

  private ACTableColumn specialClinicInfoTablecolumn6;

  private ACTableColumn specialClinicInfoTablecolumn7;

  private ACTableColumn specialClinicInfoTablecolumn8;

  private ACTableColumn specialClinicInfoTablecolumn9;

  private ACTableColumn specialClinicInfoTablecolumn10;

  private ACTableColumn specialClinicInfoTablecolumn11;

  private ACTableColumn specialClinicInfoTablecolumn12;

  private ACPanel particularInfoRevisionPanel;

  private ACLabel particularInfoRevisionLabel;

  private ACLabel particularInfoRevision;

  private ACIntegerCheckBox particularInfoRevisionCheck;

  private ACTable particularInfoRevisionTable;

  private VRTableColumnModel particularInfoRevisionTableColumnModel;

  private ACTableColumn particularInfoRevisionTablecolumn0;

  private ACTableColumn particularInfoRevisionTablecolumn1;

  private ACTableColumn particularInfoRevisionTablecolumn2;

  private ACTableColumn particularInfoRevisionTablecolumn3;

  private ACPanel totalInfos;

  private ACPanel totalInfoPanel;

  private ACLabel totalInfoLabel;

  private ACTable totalInfoTable;

  private VRTableColumnModel totalInfoTableColumnModel;

  private ACTableColumn totalInfoTablecolumn0;

  private ACTableColumn totalInfoTablecolumn1;

  private ACTableColumn totalInfoTablecolumn2;

  private ACTableColumn totalInfoTablecolumn3;

  private ACTableColumn totalInfoTablecolumn4;

  private ACTableColumn totalInfoTablecolumn5;

  private ACTableColumn totalInfoTablecolumn6;

  private ACTableColumn totalInfoTablecolumn7;

  private ACTableColumn totalInfoTablecolumn8;

  private ACTableColumn totalInfoTablecolumn9;

  private ACTableColumn totalInfoTablecolumn10;

  private ACTableColumn totalInfoTablecolumn11;

  private ACTableColumn totalInfoTablecolumn12;

  private ACTableColumn totalInfoTablecolumn13;

  private ACTableColumn totalInfoTablecolumn14;

  private ACTableColumn totalInfoTablecolumn15;

  private ACTableColumn totalInfoTablecolumn16;

  private ACTableColumn totalInfoTablecolumn17;

  private ACTableColumn totalInfoTablecolumn18;

  private ACTableColumn totalInfoTablecolumn19;

  private ACTableColumn totalInfoTablecolumn20;

  private ACPanel totalInfoRevisionPanel;

  private ACLabel totalInfoRevisionLabel;

  private ACLabel totalInfoRevision;

  private ACIntegerCheckBox totalInfoRevisionCheck;

  private ACTable totalInfoRevisionTable;

  private VRTableColumnModel totalInfoRevisionTableColumnModel;

  private ACTableColumn totalInfoRevisionTablecolumn0;

  private ACTableColumn totalInfoRevisionTablecolumn1;

  private ACTableColumn totalInfoRevisionTablecolumn2;

  private ACTableColumn totalInfoRevisionTablecolumn3;

  private ACPanel nyushoInfos;

  private ACPanel nyushoInfoPanel;

  private ACLabel nyushoInfoLabel;

  private ACButton serviceAddButton;

  private ACButton serviceDelButton;

  private ACTable nyushoInfoTable;

  private VRTableColumnModel nyushoInfoTableColumnModel;

  private ACTableColumn nyushoInfoTablecolumn0;

  private ACTableColumn nyushoInfoTablecolumn1;

  private ACTableColumn nyushoInfoTablecolumn2;

  private ACTableColumn nyushoInfoTablecolumn3;

  private ACTableColumn nyushoInfoTablecolumn4;

  private ACTableColumn nyushoInfoTablecolumn5;

  private ACTableColumn nyushoInfoTablecolumn6;

  private ACTableColumn nyushoInfoTablecolumn7;

  private ACTableColumn nyushoInfoTablecolumn8;

  private ACTableColumn nyushoInfoTablecolumn9;

  private ACTableColumn nyushoInfoTablecolumn10;

  private ACTableColumn nyushoInfoTablecolumn11;

  private ACTableColumn nyushoInfoTablecolumn12;

  private ACTableColumn nyushoInfoTablecolumn13;

  private ACTableColumn nyushoInfoTablecolumn14;

  private ACTableColumn nyushoInfoTablecolumn15;

  private ACTableColumn nyushoInfoTablecolumn16;

  private ACTableColumn nyushoInfoTablecolumn17;

  private ACTableColumn nyushoInfoTablecolumn18;

  private ACTableColumn nyushoInfoTablecolumn19;

  private ACTableColumn nyushoInfoTablecolumn20;

  private ACTableColumn nyushoInfoTablecolumn21;

  private ACTableColumn nyushoInfoTablecolumn22;

  private ACTableColumn nyushoInfoTablecolumn23;

  private ACTableColumn nyushoInfoTablecolumn24;

  private ACTableColumn nyushoInfoTablecolumn25;

  private ACTableColumn nyushoInfoTablecolumn26;

  private ACTableColumn nyushoInfoTablecolumn27;

  private ACPanel nyushoInfoRevisionPanel;

  private ACLabel nyushoInfoRevisionLabel;

  private ACLabel nyushoInfoRevision;

  private ACIntegerCheckBox nyushoInfoRevisionCheck;

  private ACTable nyushoInfoRevisionTable;

  private VRTableColumnModel nyushoInfoRevisionTableColumnModel;

  private ACTableColumn nyushoInfoRevisionTablecolumn0;

  private ACTableColumn nyushoInfoRevisionTablecolumn1;

  private ACTableColumn nyushoInfoRevisionTablecolumn2;

  private ACTableColumn nyushoInfoRevisionTablecolumn3;

  private ACPanel shahukuInfos;

  private ACPanel shahukuInfoPanel;

  private ACLabel shahukuInfoLabel;

  private ACTable shahukuInfoTable;

  private VRTableColumnModel shahukuInfoTableColumnModel;

  private ACTableColumn shahukuInfoTablecolumn0;

  private ACTableColumn shahukuInfoTablecolumn1;

  private ACTableColumn shahukuInfoTablecolumn2;

  private ACTableColumn shahukuInfoTablecolumn3;

  private ACTableColumn shahukuInfoTablecolumn4;

  private ACTableColumn shahukuInfoTablecolumn5;

  private ACTableColumn shahukuInfoTablecolumn6;

  private ACPanel shahukuInfoRevisionPanel;

  private ACLabel shahukuInfoRevisionLabel;

  private ACLabel shahukuInfoRevision;

  private ACIntegerCheckBox shahukuInfoRevisionCheck;

  private ACTable shahukuInfoRevisionTable;

  private VRTableColumnModel shahukuInfoRevisionTableColumnModel;

  private ACTableColumn shahukuInfoRevisionTablecolumn0;

  private ACTableColumn shahukuInfoRevisionTablecolumn1;

  private ACTableColumn shahukuInfoRevisionTablecolumn2;

  private ACTableColumn shahukuInfoRevisionTablecolumn3;

  private ACPanel recuperationInfos;

  private ACPanel recuperationInfoPanel;

  private ACLabel recuperationInfoLabel;

  private ACTable recuperationInfoTable;

  private VRTableColumnModel recuperationInfoTableColumnModel;

  private ACTableColumn recuperationInfoTablecolumn0;

  private ACTableColumn recuperationInfoTablecolumn1;

  private ACTableColumn recuperationInfoTablecolumn2;

  private ACTableColumn recuperationInfoTablecolumn3;

  private ACTableColumn recuperationInfoTablecolumn4;

  private ACTableColumn recuperationInfoTablecolumn5;

  private ACTableColumn recuperationInfoTablecolumn6;

  private ACTableColumn recuperationInfoTablecolumn7;

  private ACTableColumn recuperationInfoTablecolumn8;

  private ACTableColumn recuperationInfoTablecolumn9;

  private ACTableColumn recuperationInfoTablecolumn10;

  private ACTableColumn recuperationInfoTablecolumn11;

  private ACTableColumn recuperationInfoTablecolumn12;

  private ACPanel recuperationInfoRevisionPanel;

  private ACLabel recuperationInfoRevisionLabel;

  private ACLabel recuperationInfoRevision;

  private ACIntegerCheckBox recuperationInfoRevisionCheck;

  private ACTable recuperationInfoRevisionTable;

  private VRTableColumnModel recuperationInfoRevisionTableColumnModel;

  private ACTableColumn recuperationInfoRevisionTablecolumn0;

  private ACTableColumn recuperationInfoRevisionTablecolumn1;

  private ACTableColumn recuperationInfoRevisionTablecolumn2;

  private ACTableColumn recuperationInfoRevisionTablecolumn3;

  private ACPanel detailsJushotiTokureiInfos;

  private ACPanel detailsJushotiTokureiPanel;

  private ACLabel detailsJushotiTokureiLabel;

  private ACButton detailsJushotiTokureiDelButton;

  private ACTable detailsJushotiTokureiInfoTable;

  private VRTableColumnModel detailsJushotiTokureiInfoTableColumnModel;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn0;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn1;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn2;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn3;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn4;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn5;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn6;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn7;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn8;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn9;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn10;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn11;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn12;

  private ACTableColumn detailsJushotiTokureiInfoTablecolumn13;

  private ACPanel detailsJushotiTokureiInfoRevisionPanel;

  private ACLabel detailsJushotiTokureiInfoRevisionLabel;

  private ACLabel detailsJushotiTokureiInfoRevision;

  private ACIntegerCheckBox detailsJushotiTokureiInfoRevisionCheck;

  private ACTable detailsJushotiTokureiInfoRevisionTable;

  private VRTableColumnModel detailsJushotiTokureiInfoRevisionTableColumnModel;

  private ACTableColumn detailsJushotiTokureiInfoRevisionTablecolumn0;

  private ACTableColumn detailsJushotiTokureiInfoRevisionTablecolumn1;

  private ACTableColumn detailsJushotiTokureiInfoRevisionTablecolumn2;

  private ACTableColumn detailsJushotiTokureiInfoRevisionTablecolumn3;

  //getter

  /**
   * �Ɩ��{�^���o�[���擾���܂��B
   * @return �Ɩ��{�^���o�[
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("���׏����ҏW���");

      addButtons();
    }
    return buttons;

  }

  /**
   * �ďW�v���擾���܂��B
   * @return �ďW�v
   */
  public ACAffairButton getRetotal(){
    if(retotal==null){

      retotal = new ACAffairButton();

      retotal.setText("�ďW�v(T)");

      retotal.setMnemonic('T');

      retotal.setIconPath(ACConstants.ICON_PATH_CALC_24);

      addRetotal();
    }
    return retotal;

  }

  /**
   * �X�V���擾���܂��B
   * @return �X�V
   */
  public ACAffairButton getRenewal(){
    if(renewal==null){

      renewal = new ACAffairButton();

      renewal.setText("�X�V(S)");

      renewal.setMnemonic('S');

      renewal.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addRenewal();
    }
    return renewal;

  }

  /**
   * �N���C�A���g�̈���擾���܂��B
   * @return �N���C�A���g�̈�
   */
  public ACPanel getContens(){
    if(contens==null){

      contens = new ACPanel();

      addContens();
    }
    return contens;

  }

  /**
   * ���ʗ̈���擾���܂��B
   * @return ���ʗ̈�
   */
  public ACPanel getCommonInfoPanle(){
    if(commonInfoPanle==null){

      commonInfoPanle = new ACPanel();

      addCommonInfoPanle();
    }
    return commonInfoPanle;

  }

  /**
   * ���̈���擾���܂��B
   * @return ���̈�
   */
  public ACPanel getCommonInfos(){
    if(commonInfos==null){

      commonInfos = new ACPanel();

      commonInfos.setAutoWrap(false);

      addCommonInfos();
    }
    return commonInfos;

  }

  /**
   * �l���e�L�X�g���擾���܂��B
   * @return �l���e�L�X�g
   */
  public ACLabel getCommonInfoPattern(){
    if(commonInfoPattern==null){

      commonInfoPattern = new ACLabel();

      commonInfoPattern.setText("�l������");

      commonInfoPattern.setBindPath("CLAIM_STYLE_NAME");

      addCommonInfoPattern();
    }
    return commonInfoPattern;

  }

  /**
   * ���Ǝ҃e�L�X�g���擾���܂��B
   * @return ���Ǝ҃e�L�X�g
   */
  public ACLabel getCommonInfoProvider(){
    if(commonInfoProvider==null){

      commonInfoProvider = new ACLabel();

      commonInfoProvider.setText("���Ə�����");

      commonInfoProvider.setBindPath("PROVIDER_NAME");

      addCommonInfoProvider();
    }
    return commonInfoProvider;

  }

  /**
   * �����e�L�X�g���擾���܂��B
   * @return �����e�L�X�g
   */
  public ACLabel getCommonInfoDate(){
    if(commonInfoDate==null){

      commonInfoDate = new ACLabel();

      commonInfoDate.setText("��������");

      commonInfoDate.setBindPath("TARGET_DATE");

      addCommonInfoDate();
    }
    return commonInfoDate;

  }

  /**
   * ���O�e�L�X�g���擾���܂��B
   * @return ���O�e�L�X�g
   */
  public ACLabel getCommmonInfoName(){
    if(commmonInfoName==null){

      commmonInfoName = new ACLabel();

      commmonInfoName.setText("���O����");

      commmonInfoName.setBindPath("PATIENT_NAME");

      addCommmonInfoName();
    }
    return commmonInfoName;

  }

  /**
   * �Y������ꗗ���x�����擾���܂��B
   * @return �Y������ꗗ���x��
   */
  public ACLabel getCommonInfoPublicExpenseLabelAll(){
    if(commonInfoPublicExpenseLabelAll==null){

      commonInfoPublicExpenseLabelAll = new ACLabel();

      commonInfoPublicExpenseLabelAll.setText("�Y������F");

      addCommonInfoPublicExpenseLabelAll();
    }
    return commonInfoPublicExpenseLabelAll;

  }

  /**
   * �Y������E�e�L�X�g���擾���܂��B
   * @return �Y������E�e�L�X�g
   */
  public ACLabel getCommonInfoPublicExpenseText(){
    if(commonInfoPublicExpenseText==null){

      commonInfoPublicExpenseText = new ACLabel();

      commonInfoPublicExpenseText.setText("1.�����i100%�j");

      commonInfoPublicExpenseText.setBindPath("KOHI_NAME");

      commonInfoPublicExpenseText.setColumns(60);

      addCommonInfoPublicExpenseText();
    }
    return commonInfoPublicExpenseText;

  }

  /**
   * ��ޕʃ^�u���擾���܂��B
   * @return ��ޕʃ^�u
   */
  public JTabbedPane getEtcInfoTabs(){
    if(etcInfoTabs==null){

      etcInfoTabs = new JTabbedPane();

      addEtcInfoTabs();
    }
    return etcInfoTabs;

  }

  /**
   * ��{���̈���擾���܂��B
   * @return ��{���̈�
   */
  public ACPanel getBasicInfos(){
    if(basicInfos==null){

      basicInfos = new ACPanel();

      addBasicInfos();
    }
    return basicInfos;

  }

  /**
   * ��{���p�l�����擾���܂��B
   * @return ��{���p�l��
   */
  public ACPanel getBasicInfo(){
    if(basicInfo==null){

      basicInfo = new ACPanel();

      addBasicInfo();
    }
    return basicInfo;

  }

  /**
   * ��{��񃉃x�����擾���܂��B
   * @return ��{��񃉃x��
   */
  public ACLabel getBasicInfoLabel(){
    if(basicInfoLabel==null){

      basicInfoLabel = new ACLabel();

      basicInfoLabel.setText("��{���");

      addBasicInfoLabel();
    }
    return basicInfoLabel;

  }

  /**
   * ��{���e�[�u�����擾���܂��B
   * @return ��{���e�[�u��
   */
  public ACTable getBasicInfoTable(){
    if(basicInfoTable==null){

      basicInfoTable = new ACTable();

      basicInfoTable.setColumnModel(getBasicInfoTableColumnModel());

      basicInfoTable.setColumnSort(false);

      addBasicInfoTable();
    }
    return basicInfoTable;

  }

  /**
   * ��{���e�[�u���J�������f�����擾���܂��B
   * @return ��{���e�[�u���J�������f��
   */
  protected VRTableColumnModel getBasicInfoTableColumnModel(){
    if(basicInfoTableColumnModel==null){
      basicInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addBasicInfoTableColumnModel();
    }
    return basicInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getBasicInfoTablecolumn0(){
    if(basicInfoTablecolumn0==null){

      basicInfoTablecolumn0 = new ACTableColumn(0, 30);

      basicInfoTablecolumn0.setHeaderValue("�@");

      basicInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      basicInfoTablecolumn0.setSortable(false);

      addBasicInfoTablecolumn0();
    }
    return basicInfoTablecolumn0;

  }

  /**
   * �ی��Ҕԍ����擾���܂��B
   * @return �ی��Ҕԍ�
   */
  public ACTableColumn getBasicInfoTablecolumn1(){
    if(basicInfoTablecolumn1==null){

      basicInfoTablecolumn1 = new ACTableColumn(0, 80);

      basicInfoTablecolumn1.setHeaderValue("�ی��Ҕԍ�");

      addBasicInfoTablecolumn1();
    }
    return basicInfoTablecolumn1;

  }

  /**
   * ��ی��Ҕԍ����擾���܂��B
   * @return ��ی��Ҕԍ�
   */
  public ACTableColumn getBasicInfoTablecolumn2(){
    if(basicInfoTablecolumn2==null){

      basicInfoTablecolumn2 = new ACTableColumn(1, 100);

      basicInfoTablecolumn2.setHeaderValue("��ی��Ҕԍ�");

      addBasicInfoTablecolumn2();
    }
    return basicInfoTablecolumn2;

  }

  /**
   * �v����ԋ敪�R�[�h���擾���܂��B
   * @return �v����ԋ敪�R�[�h
   */
  public ACTableColumn getBasicInfoTablecolumn3(){
    if(basicInfoTablecolumn3==null){

      basicInfoTablecolumn3 = new ACTableColumn(2, 140);

      basicInfoTablecolumn3.setHeaderValue("�v����ԋ敪�R�[�h");

      addBasicInfoTablecolumn3();
    }
    return basicInfoTablecolumn3;

  }

  /**
   * �F��L�����ԊJ�n�N�������擾���܂��B
   * @return �F��L�����ԊJ�n�N����
   */
  public ACTableColumn getBasicInfoTablecolumn4(){
    if(basicInfoTablecolumn4==null){

      basicInfoTablecolumn4 = new ACTableColumn(3, 150);

      basicInfoTablecolumn4.setHeaderValue("�F��L�����ԊJ�n�N����");

      addBasicInfoTablecolumn4();
    }
    return basicInfoTablecolumn4;

  }

  /**
   * �F��L�����ԏI���N�������擾���܂��B
   * @return �F��L�����ԏI���N����
   */
  public ACTableColumn getBasicInfoTablecolumn5(){
    if(basicInfoTablecolumn5==null){

      basicInfoTablecolumn5 = new ACTableColumn(4, 150);

      basicInfoTablecolumn5.setHeaderValue("�F��L�����ԏI���N����");

      addBasicInfoTablecolumn5();
    }
    return basicInfoTablecolumn5;

  }

  /**
   * ����T�[�r�X�v��Ҏ��Ə��ԍ����擾���܂��B
   * @return ����T�[�r�X�v��Ҏ��Ə��ԍ�
   */
  public ACTableColumn getBasicInfoTablecolumn6(){
    if(basicInfoTablecolumn6==null){

      basicInfoTablecolumn6 = new ACTableColumn(5, 185);

      basicInfoTablecolumn6.setHeaderValue("����T�[�r�X�v��Ҏ��Ə��ԍ�");

      addBasicInfoTablecolumn6();
    }
    return basicInfoTablecolumn6;

  }

  /**
   * ����T�[�r�X�v��Ҏ��Ə������擾���܂��B
   * @return ����T�[�r�X�v��Ҏ��Ə���
   */
  public ACTableColumn getBasicInfoTablecolumn7(){
    if(basicInfoTablecolumn7==null){

      basicInfoTablecolumn7 = new ACTableColumn(6, 175);

      basicInfoTablecolumn7.setHeaderValue("����T�[�r�X�v��Ҏ��Ə���");

      addBasicInfoTablecolumn7();
    }
    return basicInfoTablecolumn7;

  }

  /**
   * �J�n�N�������擾���܂��B
   * @return �J�n�N����
   */
  public ACTableColumn getBasicInfoTablecolumn8(){
    if(basicInfoTablecolumn8==null){

      basicInfoTablecolumn8 = new ACTableColumn(7, 80);

      basicInfoTablecolumn8.setHeaderValue("�J�n�N����");

      addBasicInfoTablecolumn8();
    }
    return basicInfoTablecolumn8;

  }

  /**
   * ���~�N�������擾���܂��B
   * @return ���~�N����
   */
  public ACTableColumn getBasicInfoTablecolumn9(){
    if(basicInfoTablecolumn9==null){

      basicInfoTablecolumn9 = new ACTableColumn(8, 80);

      basicInfoTablecolumn9.setHeaderValue("���~�N����");

      addBasicInfoTablecolumn9();
    }
    return basicInfoTablecolumn9;

  }

  /**
   * ���~���R�R�[�h���擾���܂��B
   * @return ���~���R�R�[�h
   */
  public ACTableColumn getBasicInfoTablecolumn10(){
    if(basicInfoTablecolumn10==null){

      basicInfoTablecolumn10 = new ACTableColumn(9, 100);

      basicInfoTablecolumn10.setHeaderValue("���~���R�R�[�h");

      addBasicInfoTablecolumn10();
    }
    return basicInfoTablecolumn10;

  }

  /**
   * ����(�@)�N�������擾���܂��B
   * @return ����(�@)�N����
   */
  public ACTableColumn getBasicInfoTablecolumn11(){
    if(basicInfoTablecolumn11==null){

      basicInfoTablecolumn11 = new ACTableColumn(10, 100);

      basicInfoTablecolumn11.setHeaderValue("����(�@)�N����");

      addBasicInfoTablecolumn11();
    }
    return basicInfoTablecolumn11;

  }

  /**
   * �ޏ�(�@)�N�������擾���܂��B
   * @return �ޏ�(�@)�N����
   */
  public ACTableColumn getBasicInfoTablecolumn12(){
    if(basicInfoTablecolumn12==null){

      basicInfoTablecolumn12 = new ACTableColumn(11, 100);

      basicInfoTablecolumn12.setHeaderValue("�ޏ�(�@)�N����");

      addBasicInfoTablecolumn12();
    }
    return basicInfoTablecolumn12;

  }

  /**
   * ����(�@)���������擾���܂��B
   * @return ����(�@)������
   */
  public ACTableColumn getBasicInfoTablecolumn13(){
    if(basicInfoTablecolumn13==null){

      basicInfoTablecolumn13 = new ACTableColumn(12, 120);

      basicInfoTablecolumn13.setHeaderValue("����(�@)������");

      addBasicInfoTablecolumn13();
    }
    return basicInfoTablecolumn13;

  }

  /**
   * �叝�a���擾���܂��B
   * @return �叝�a
   */
  public ACTableColumn getBasicInfoTablecolumn14(){
    if(basicInfoTablecolumn14==null){

      basicInfoTablecolumn14 = new ACTableColumn(13, 60);

      basicInfoTablecolumn14.setHeaderValue("�叝�a");

      addBasicInfoTablecolumn14();
    }
    return basicInfoTablecolumn14;

  }

  /**
   * ��{�ݒ���e�C���p�l�����擾���܂��B
   * @return ��{�ݒ���e�C���p�l��
   */
  public ACPanel getBasicInfoRevisionPanel(){
    if(basicInfoRevisionPanel==null){

      basicInfoRevisionPanel = new ACPanel();

      addBasicInfoRevisionPanel();
    }
    return basicInfoRevisionPanel;

  }

  /**
   * �ݒ���e�C�������x�����擾���܂��B
   * @return �ݒ���e�C�������x��
   */
  public ACLabel getBasicInfoRevisionLabel(){
    if(basicInfoRevisionLabel==null){

      basicInfoRevisionLabel = new ACLabel();

      basicInfoRevisionLabel.setText("�ݒ���e�C����");

      addBasicInfoRevisionLabel();
    }
    return basicInfoRevisionLabel;

  }

  /**
   * ��{�����擾���܂��B
   * @return ��{���
   */
  public ACLabel getBasicInfoRevisionLabel2(){
    if(basicInfoRevisionLabel2==null){

      basicInfoRevisionLabel2 = new ACLabel();

      basicInfoRevisionLabel2.setText("��{���");

      addBasicInfoRevisionLabel2();
    }
    return basicInfoRevisionLabel2;

  }

  /**
   * �S�Ă̏���\�����擾���܂��B
   * @return �S�Ă̏���\��
   */
  public ACIntegerCheckBox getBasicInfoRevisionCheck(){
    if(basicInfoRevisionCheck==null){

      basicInfoRevisionCheck = new ACIntegerCheckBox();

      basicInfoRevisionCheck.setText("���ׂĂ̏���\���iA�j");

      basicInfoRevisionCheck.setMnemonic('A');

      addBasicInfoRevisionCheck();
    }
    return basicInfoRevisionCheck;

  }

  /**
   * ��{���ڍ׃e�[�u�����擾���܂��B
   * @return ��{���ڍ׃e�[�u��
   */
  public ACTable getBasicInfoRevisionTable(){
    if(basicInfoRevisionTable==null){

      basicInfoRevisionTable = new ACTable();

      basicInfoRevisionTable.setColumnModel(getBasicInfoRevisionTableColumnModel());

      basicInfoRevisionTable.setColumnSort(false);

      addBasicInfoRevisionTable();
    }
    return basicInfoRevisionTable;

  }

  /**
   * ��{���ڍ׃e�[�u���J�������f�����擾���܂��B
   * @return ��{���ڍ׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getBasicInfoRevisionTableColumnModel(){
    if(basicInfoRevisionTableColumnModel==null){
      basicInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addBasicInfoRevisionTableColumnModel();
    }
    return basicInfoRevisionTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getBasicInfoRevisionTablecolumn0(){
    if(basicInfoRevisionTablecolumn0==null){

      basicInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      basicInfoRevisionTablecolumn0.setHeaderValue("�@");

      basicInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      basicInfoRevisionTablecolumn0.setSortable(false);

      addBasicInfoRevisionTablecolumn0();
    }
    return basicInfoRevisionTablecolumn0;

  }

  /**
   * ���ږ����擾���܂��B
   * @return ���ږ�
   */
  public ACTableColumn getBasicInfoRevisionTablecolumn1(){
    if(basicInfoRevisionTablecolumn1==null){

      basicInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      basicInfoRevisionTablecolumn1.setHeaderValue("���ږ�");

      basicInfoRevisionTablecolumn1.setColumns(15);

      addBasicInfoRevisionTablecolumn1();
    }
    return basicInfoRevisionTablecolumn1;

  }

  /**
   * �ݒ�l���擾���܂��B
   * @return �ݒ�l
   */
  public ACTableColumn getBasicInfoRevisionTablecolumn2(){
    if(basicInfoRevisionTablecolumn2==null){

      basicInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      basicInfoRevisionTablecolumn2.setHeaderValue("�ݒ�l");

      basicInfoRevisionTablecolumn2.setEditable(true);

      basicInfoRevisionTablecolumn2.setColumns(8);

      addBasicInfoRevisionTablecolumn2();
    }
    return basicInfoRevisionTablecolumn2;

  }

  /**
   * �R�����g���擾���܂��B
   * @return �R�����g
   */
  public ACTableColumn getBasicInfoRevisionTablecolumn3(){
    if(basicInfoRevisionTablecolumn3==null){

      basicInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      basicInfoRevisionTablecolumn3.setHeaderValue("�R�����g");

      basicInfoRevisionTablecolumn3.setColumns(30);

      addBasicInfoRevisionTablecolumn3();
    }
    return basicInfoRevisionTablecolumn3;

  }

  /**
   * ���׏��̈���擾���܂��B
   * @return ���׏��̈�
   */
  public ACPanel getDetailsInfos(){
    if(detailsInfos==null){

      detailsInfos = new ACPanel();

      addDetailsInfos();
    }
    return detailsInfos;

  }

  /**
   * ���׏��p�l�����擾���܂��B
   * @return ���׏��p�l��
   */
  public ACPanel getDetailsInfoPanel(){
    if(detailsInfoPanel==null){

      detailsInfoPanel = new ACPanel();

      addDetailsInfoPanel();
    }
    return detailsInfoPanel;

  }

  /**
   * ���׏�񃉃x�����擾���܂��B
   * @return ���׏�񃉃x��
   */
  public ACLabel getDetailsInfoLabel(){
    if(detailsInfoLabel==null){

      detailsInfoLabel = new ACLabel();

      detailsInfoLabel.setText("���׏��");

      addDetailsInfoLabel();
    }
    return detailsInfoLabel;

  }

  /**
   * �T�[�r�X�폜�{�^�����擾���܂��B
   * @return �T�[�r�X�폜�{�^��
   */
  public ACButton getDetailsDelButton(){
    if(detailsDelButton==null){

      detailsDelButton = new ACButton();

      detailsDelButton.setText("�T�[�r�X�폜");

      detailsDelButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addDetailsDelButton();
    }
    return detailsDelButton;

  }

  /**
   * ���׏��e�[�u�����擾���܂��B
   * @return ���׏��e�[�u��
   */
  public ACTable getDetailsInfoTable(){
    if(detailsInfoTable==null){

      detailsInfoTable = new ACTable();

      detailsInfoTable.setColumnModel(getDetailsInfoTableColumnModel());

      detailsInfoTable.setColumnSort(false);

      addDetailsInfoTable();
    }
    return detailsInfoTable;

  }

  /**
   * ���׏��e�[�u���J�������f�����擾���܂��B
   * @return ���׏��e�[�u���J�������f��
   */
  protected VRTableColumnModel getDetailsInfoTableColumnModel(){
    if(detailsInfoTableColumnModel==null){
      detailsInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsInfoTableColumnModel();
    }
    return detailsInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getDetailsInfoTablecolumn0(){
    if(detailsInfoTablecolumn0==null){

      detailsInfoTablecolumn0 = new ACTableColumn(0, 30);

      detailsInfoTablecolumn0.setHeaderValue("�@");

      detailsInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      detailsInfoTablecolumn0.setSortable(false);

      addDetailsInfoTablecolumn0();
    }
    return detailsInfoTablecolumn0;

  }

  /**
   * �T�[�r�X�R�[�h���擾���܂��B
   * @return �T�[�r�X�R�[�h
   */
  public ACTableColumn getDetailsInfoTablecolumn1(){
    if(detailsInfoTablecolumn1==null){

      detailsInfoTablecolumn1 = new ACTableColumn(0, 105);

      detailsInfoTablecolumn1.setHeaderValue("�T�[�r�X�R�[�h");

      addDetailsInfoTablecolumn1();
    }
    return detailsInfoTablecolumn1;

  }

  /**
   * �T�[�r�X���̂��擾���܂��B
   * @return �T�[�r�X����
   */
  public ACTableColumn getDetailsInfoTablecolumn2(){
    if(detailsInfoTablecolumn2==null){

      detailsInfoTablecolumn2 = new ACTableColumn(1, 90);

      detailsInfoTablecolumn2.setHeaderValue("�T�[�r�X����");

      addDetailsInfoTablecolumn2();
    }
    return detailsInfoTablecolumn2;

  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTableColumn getDetailsInfoTablecolumn3(){
    if(detailsInfoTablecolumn3==null){

      detailsInfoTablecolumn3 = new ACTableColumn(2, 55);

      detailsInfoTablecolumn3.setHeaderValue("�P�ʐ�");

      addDetailsInfoTablecolumn3();
    }
    return detailsInfoTablecolumn3;

  }

  /**
   * �����E�񐔂��擾���܂��B
   * @return �����E��
   */
  public ACTableColumn getDetailsInfoTablecolumn4(){
    if(detailsInfoTablecolumn4==null){

      detailsInfoTablecolumn4 = new ACTableColumn(3, 75);

      detailsInfoTablecolumn4.setHeaderValue("�����E��");

      addDetailsInfoTablecolumn4();
    }
    return detailsInfoTablecolumn4;

  }

  /**
   * ����1�Ώۓ����E�񐔂��擾���܂��B
   * @return ����1�Ώۓ����E��
   */
  public ACTableColumn getDetailsInfoTablecolumn5(){
    if(detailsInfoTablecolumn5==null){

      detailsInfoTablecolumn5 = new ACTableColumn(4, 135);

      detailsInfoTablecolumn5.setHeaderValue("����1�Ώۓ����E��");

      addDetailsInfoTablecolumn5();
    }
    return detailsInfoTablecolumn5;

  }

  /**
   * ����2�Ώۓ����E�񐔂��擾���܂��B
   * @return ����2�Ώۓ����E��
   */
  public ACTableColumn getDetailsInfoTablecolumn6(){
    if(detailsInfoTablecolumn6==null){

      detailsInfoTablecolumn6 = new ACTableColumn(5, 135);

      detailsInfoTablecolumn6.setHeaderValue("����2�Ώۓ����E��");

      addDetailsInfoTablecolumn6();
    }
    return detailsInfoTablecolumn6;

  }

  /**
   * ����3�Ώۓ����E�񐔂��擾���܂��B
   * @return ����3�Ώۓ����E��
   */
  public ACTableColumn getDetailsInfoTablecolumn7(){
    if(detailsInfoTablecolumn7==null){

      detailsInfoTablecolumn7 = new ACTableColumn(6, 135);

      detailsInfoTablecolumn7.setHeaderValue("����3�Ώۓ����E��");

      addDetailsInfoTablecolumn7();
    }
    return detailsInfoTablecolumn7;

  }

  /**
   * �T�[�r�X�P�ʐ����擾���܂��B
   * @return �T�[�r�X�P�ʐ�
   */
  public ACTableColumn getDetailsInfoTablecolumn8(){
    if(detailsInfoTablecolumn8==null){

      detailsInfoTablecolumn8 = new ACTableColumn(7, 105);

      detailsInfoTablecolumn8.setHeaderValue("�T�[�r�X�P�ʐ�");

      addDetailsInfoTablecolumn8();
    }
    return detailsInfoTablecolumn8;

  }

  /**
   * ����1�ΏۃT�[�r�X�P�ʐ����擾���܂��B
   * @return ����1�ΏۃT�[�r�X�P�ʐ�
   */
  public ACTableColumn getDetailsInfoTablecolumn9(){
    if(detailsInfoTablecolumn9==null){

      detailsInfoTablecolumn9 = new ACTableColumn(8, 165);

      detailsInfoTablecolumn9.setHeaderValue("����1�ΏۃT�[�r�X�P�ʐ�");

      addDetailsInfoTablecolumn9();
    }
    return detailsInfoTablecolumn9;

  }

  /**
   * ����2�ΏۃT�[�r�X�P�ʐ����擾���܂��B
   * @return ����2�ΏۃT�[�r�X�P�ʐ�
   */
  public ACTableColumn getDetailsInfoTablecolumn10(){
    if(detailsInfoTablecolumn10==null){

      detailsInfoTablecolumn10 = new ACTableColumn(9, 165);

      detailsInfoTablecolumn10.setHeaderValue("����2�ΏۃT�[�r�X�P�ʐ�");

      addDetailsInfoTablecolumn10();
    }
    return detailsInfoTablecolumn10;

  }

  /**
   * ����3�ΏۃT�[�r�X�P�ʐ����擾���܂��B
   * @return ����3�ΏۃT�[�r�X�P�ʐ�
   */
  public ACTableColumn getDetailsInfoTablecolumn11(){
    if(detailsInfoTablecolumn11==null){

      detailsInfoTablecolumn11 = new ACTableColumn(10, 165);

      detailsInfoTablecolumn11.setHeaderValue("����3�ΏۃT�[�r�X�P�ʐ�");

      addDetailsInfoTablecolumn11();
    }
    return detailsInfoTablecolumn11;

  }

  /**
   * �E�v(�p��)���擾���܂��B
   * @return �E�v(�p��)
   */
  public ACTableColumn getDetailsInfoTablecolumn12(){
    if(detailsInfoTablecolumn12==null){

      detailsInfoTablecolumn12 = new ACTableColumn(11, 105);

      detailsInfoTablecolumn12.setHeaderValue("�E�v(�p��)");

      addDetailsInfoTablecolumn12();
    }
    return detailsInfoTablecolumn12;

  }

  /**
   * ������x�����׏��e�[�u�����擾���܂��B
   * @return ������x�����׏��e�[�u��
   */
  public ACTable getKyotakuDetailsInfoTable(){
    if(kyotakuDetailsInfoTable==null){

      kyotakuDetailsInfoTable = new ACTable();

      kyotakuDetailsInfoTable.setColumnModel(getKyotakuDetailsInfoTableColumnModel());

      kyotakuDetailsInfoTable.setColumnSort(false);

      addKyotakuDetailsInfoTable();
    }
    return kyotakuDetailsInfoTable;

  }

  /**
   * ������x�����׏��e�[�u���J�������f�����擾���܂��B
   * @return ������x�����׏��e�[�u���J�������f��
   */
  protected VRTableColumnModel getKyotakuDetailsInfoTableColumnModel(){
    if(kyotakuDetailsInfoTableColumnModel==null){
      kyotakuDetailsInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKyotakuDetailsInfoTableColumnModel();
    }
    return kyotakuDetailsInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn0(){
    if(kyotakuDetailsInfoTablecolumn0==null){

      kyotakuDetailsInfoTablecolumn0 = new ACTableColumn(0, 30);

      kyotakuDetailsInfoTablecolumn0.setHeaderValue("�@");

      kyotakuDetailsInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      kyotakuDetailsInfoTablecolumn0.setSortable(false);

      addKyotakuDetailsInfoTablecolumn0();
    }
    return kyotakuDetailsInfoTablecolumn0;

  }

  /**
   * ���N�������擾���܂��B
   * @return ���N����
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn1(){
    if(kyotakuDetailsInfoTablecolumn1==null){

      kyotakuDetailsInfoTablecolumn1 = new ACTableColumn(0, 105);

      kyotakuDetailsInfoTablecolumn1.setHeaderValue("���N����");

      addKyotakuDetailsInfoTablecolumn1();
    }
    return kyotakuDetailsInfoTablecolumn1;

  }

  /**
   * ���ʃR�[�h���擾���܂��B
   * @return ���ʃR�[�h
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn2(){
    if(kyotakuDetailsInfoTablecolumn2==null){

      kyotakuDetailsInfoTablecolumn2 = new ACTableColumn(1, 90);

      kyotakuDetailsInfoTablecolumn2.setHeaderValue("���ʃR�[�h");

      addKyotakuDetailsInfoTablecolumn2();
    }
    return kyotakuDetailsInfoTablecolumn2;

  }

  /**
   * �v����ԋ敪�R�[�h���擾���܂��B
   * @return �v����ԋ敪�R�[�h
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn3(){
    if(kyotakuDetailsInfoTablecolumn3==null){

      kyotakuDetailsInfoTablecolumn3 = new ACTableColumn(2, 55);

      kyotakuDetailsInfoTablecolumn3.setHeaderValue("�v����ԋ敪�R�[�h");

      addKyotakuDetailsInfoTablecolumn3();
    }
    return kyotakuDetailsInfoTablecolumn3;

  }

  /**
   * �F��L�����ԊJ�n�����擾���܂��B
   * @return �F��L�����ԊJ�n��
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn4(){
    if(kyotakuDetailsInfoTablecolumn4==null){

      kyotakuDetailsInfoTablecolumn4 = new ACTableColumn(3, 75);

      kyotakuDetailsInfoTablecolumn4.setHeaderValue("�F��L�����ԊJ�n��");

      addKyotakuDetailsInfoTablecolumn4();
    }
    return kyotakuDetailsInfoTablecolumn4;

  }

  /**
   * �F��L�����ԏI�������擾���܂��B
   * @return �F��L�����ԏI����
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn5(){
    if(kyotakuDetailsInfoTablecolumn5==null){

      kyotakuDetailsInfoTablecolumn5 = new ACTableColumn(4, 135);

      kyotakuDetailsInfoTablecolumn5.setHeaderValue("�F��L�����ԏI����");

      addKyotakuDetailsInfoTablecolumn5();
    }
    return kyotakuDetailsInfoTablecolumn5;

  }

  /**
   * ����T�[�r�X�v��쐬�˗��͏o�N�������擾���܂��B
   * @return ����T�[�r�X�v��쐬�˗��͏o�N����
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn6(){
    if(kyotakuDetailsInfoTablecolumn6==null){

      kyotakuDetailsInfoTablecolumn6 = new ACTableColumn(5, 135);

      kyotakuDetailsInfoTablecolumn6.setHeaderValue("����T�[�r�X�v��쐬�˗��͏o�N����");

      addKyotakuDetailsInfoTablecolumn6();
    }
    return kyotakuDetailsInfoTablecolumn6;

  }

  /**
   * �T�[�r�X�R�[�h���擾���܂��B
   * @return �T�[�r�X�R�[�h
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn7(){
    if(kyotakuDetailsInfoTablecolumn7==null){

      kyotakuDetailsInfoTablecolumn7 = new ACTableColumn(6, 135);

      kyotakuDetailsInfoTablecolumn7.setHeaderValue("�T�[�r�X�R�[�h");

      addKyotakuDetailsInfoTablecolumn7();
    }
    return kyotakuDetailsInfoTablecolumn7;

  }

  /**
   * �T�[�r�X���̂��擾���܂��B
   * @return �T�[�r�X����
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn8(){
    if(kyotakuDetailsInfoTablecolumn8==null){

      kyotakuDetailsInfoTablecolumn8 = new ACTableColumn(7, 105);

      kyotakuDetailsInfoTablecolumn8.setHeaderValue("�T�[�r�X����");

      addKyotakuDetailsInfoTablecolumn8();
    }
    return kyotakuDetailsInfoTablecolumn8;

  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn9(){
    if(kyotakuDetailsInfoTablecolumn9==null){

      kyotakuDetailsInfoTablecolumn9 = new ACTableColumn(8, 165);

      kyotakuDetailsInfoTablecolumn9.setHeaderValue("�P�ʐ�");

      addKyotakuDetailsInfoTablecolumn9();
    }
    return kyotakuDetailsInfoTablecolumn9;

  }

  /**
   * �������z���擾���܂��B
   * @return �������z
   */
  public ACTableColumn getKyotakuDetailsInfoTablecolumn10(){
    if(kyotakuDetailsInfoTablecolumn10==null){

      kyotakuDetailsInfoTablecolumn10 = new ACTableColumn(9, 165);

      kyotakuDetailsInfoTablecolumn10.setHeaderValue("�������z");

      addKyotakuDetailsInfoTablecolumn10();
    }
    return kyotakuDetailsInfoTablecolumn10;

  }

  /**
   * ���אݒ���e�C���p�l�����擾���܂��B
   * @return ���אݒ���e�C���p�l��
   */
  public ACPanel getDetailsInfoRevisionPanel(){
    if(detailsInfoRevisionPanel==null){

      detailsInfoRevisionPanel = new ACPanel();

      addDetailsInfoRevisionPanel();
    }
    return detailsInfoRevisionPanel;

  }

  /**
   * �ݒ���e�C�������x�����擾���܂��B
   * @return �ݒ���e�C�������x��
   */
  public ACLabel getDetailsInfoRevisionLabel(){
    if(detailsInfoRevisionLabel==null){

      detailsInfoRevisionLabel = new ACLabel();

      detailsInfoRevisionLabel.setText("�ݒ���e�C����");

      addDetailsInfoRevisionLabel();
    }
    return detailsInfoRevisionLabel;

  }

  /**
   * ���׏����擾���܂��B
   * @return ���׏��
   */
  public ACLabel getDetailsInfoRevision(){
    if(detailsInfoRevision==null){

      detailsInfoRevision = new ACLabel();

      detailsInfoRevision.setText("���׏��");

      addDetailsInfoRevision();
    }
    return detailsInfoRevision;

  }

  /**
   * �S�Ă̏���\�����擾���܂��B
   * @return �S�Ă̏���\��
   */
  public ACIntegerCheckBox getDetailsInfoRevisionCheck(){
    if(detailsInfoRevisionCheck==null){

      detailsInfoRevisionCheck = new ACIntegerCheckBox();

      detailsInfoRevisionCheck.setText("���ׂĂ̏���\���iA�j");

      detailsInfoRevisionCheck.setMnemonic('A');

      addDetailsInfoRevisionCheck();
    }
    return detailsInfoRevisionCheck;

  }

  /**
   * ���׏��ڍ׃e�[�u�����擾���܂��B
   * @return ���׏��ڍ׃e�[�u��
   */
  public ACTable getDetailsInfoRevisionTable(){
    if(detailsInfoRevisionTable==null){

      detailsInfoRevisionTable = new ACTable();

      detailsInfoRevisionTable.setColumnModel(getDetailsInfoRevisionTableColumnModel());

      detailsInfoRevisionTable.setColumnSort(false);

      addDetailsInfoRevisionTable();
    }
    return detailsInfoRevisionTable;

  }

  /**
   * ���׏��ڍ׃e�[�u���J�������f�����擾���܂��B
   * @return ���׏��ڍ׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getDetailsInfoRevisionTableColumnModel(){
    if(detailsInfoRevisionTableColumnModel==null){
      detailsInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsInfoRevisionTableColumnModel();
    }
    return detailsInfoRevisionTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getDetailsInfoRevisionTablecolumn0(){
    if(detailsInfoRevisionTablecolumn0==null){

      detailsInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      detailsInfoRevisionTablecolumn0.setHeaderValue("�@");

      detailsInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      detailsInfoRevisionTablecolumn0.setSortable(false);

      addDetailsInfoRevisionTablecolumn0();
    }
    return detailsInfoRevisionTablecolumn0;

  }

  /**
   * ���ږ����擾���܂��B
   * @return ���ږ�
   */
  public ACTableColumn getDetailsInfoRevisionTablecolumn1(){
    if(detailsInfoRevisionTablecolumn1==null){

      detailsInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      detailsInfoRevisionTablecolumn1.setHeaderValue("���ږ�");

      detailsInfoRevisionTablecolumn1.setColumns(15);

      addDetailsInfoRevisionTablecolumn1();
    }
    return detailsInfoRevisionTablecolumn1;

  }

  /**
   * �ݒ�l���擾���܂��B
   * @return �ݒ�l
   */
  public ACTableColumn getDetailsInfoRevisionTablecolumn2(){
    if(detailsInfoRevisionTablecolumn2==null){

      detailsInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      detailsInfoRevisionTablecolumn2.setHeaderValue("�ݒ�l");

      detailsInfoRevisionTablecolumn2.setEditable(true);

      detailsInfoRevisionTablecolumn2.setColumns(8);

      addDetailsInfoRevisionTablecolumn2();
    }
    return detailsInfoRevisionTablecolumn2;

  }

  /**
   * �R�����g���擾���܂��B
   * @return �R�����g
   */
  public ACTableColumn getDetailsInfoRevisionTablecolumn3(){
    if(detailsInfoRevisionTablecolumn3==null){

      detailsInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      detailsInfoRevisionTablecolumn3.setHeaderValue("�R�����g");

      detailsInfoRevisionTablecolumn3.setColumns(30);

      addDetailsInfoRevisionTablecolumn3();
    }
    return detailsInfoRevisionTablecolumn3;

  }

  /**
   * ���莡�ÁE����f�Ï��̈���擾���܂��B
   * @return ���莡�ÁE����f�Ï��̈�
   */
  public ACPanel getParticularInfos(){
    if(particularInfos==null){

      particularInfos = new ACPanel();

      addParticularInfos();
    }
    return particularInfos;

  }

  /**
   * ���莡�Ô���p�l�����擾���܂��B
   * @return ���莡�Ô���p�l��
   */
  public ACPanel getParticularInfoPanel(){
    if(particularInfoPanel==null){

      particularInfoPanel = new ACPanel();

      addParticularInfoPanel();
    }
    return particularInfoPanel;

  }

  /**
   * ���莡�Ô��񃉃x�����擾���܂��B
   * @return ���莡�Ô��񃉃x��
   */
  public ACLabel getParticularInfoLabel(){
    if(particularInfoLabel==null){

      particularInfoLabel = new ACLabel();

      particularInfoLabel.setText("���莡�Ô���");

      addParticularInfoLabel();
    }
    return particularInfoLabel;

  }

  /**
   * ���莡�Ô���e�[�u�����擾���܂��B
   * @return ���莡�Ô���e�[�u��
   */
  public ACTable getParticularInfoTable(){
    if(particularInfoTable==null){

      particularInfoTable = new ACTable();

      particularInfoTable.setColumnModel(getParticularInfoTableColumnModel());

      particularInfoTable.setColumnSort(false);

      addParticularInfoTable();
    }
    return particularInfoTable;

  }

  /**
   * ���莡�Ô���e�[�u���J�������f�����擾���܂��B
   * @return ���莡�Ô���e�[�u���J�������f��
   */
  protected VRTableColumnModel getParticularInfoTableColumnModel(){
    if(particularInfoTableColumnModel==null){
      particularInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addParticularInfoTableColumnModel();
    }
    return particularInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getParticularInfoTablecolumn0(){
    if(particularInfoTablecolumn0==null){

      particularInfoTablecolumn0 = new ACTableColumn(0, 30);

      particularInfoTablecolumn0.setHeaderValue("�@");

      particularInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      particularInfoTablecolumn0.setSortable(false);

      addParticularInfoTablecolumn0();
    }
    return particularInfoTablecolumn0;

  }

  /**
   * ���Ə��ԍ����擾���܂��B
   * @return ���Ə��ԍ�
   */
  public ACTableColumn getParticularInfoTablecolumn1(){
    if(particularInfoTablecolumn1==null){

      particularInfoTablecolumn1 = new ACTableColumn(0, 75);

      particularInfoTablecolumn1.setHeaderValue("���Ə��ԍ�");

      addParticularInfoTablecolumn1();
    }
    return particularInfoTablecolumn1;

  }

  /**
   * �ً}�����a��1���擾���܂��B
   * @return �ً}�����a��1
   */
  public ACTableColumn getParticularInfoTablecolumn2(){
    if(particularInfoTablecolumn2==null){

      particularInfoTablecolumn2 = new ACTableColumn(1, 100);

      particularInfoTablecolumn2.setHeaderValue("�ً}�����a��1");

      addParticularInfoTablecolumn2();
    }
    return particularInfoTablecolumn2;

  }

  /**
   * �ً}�����a��2���擾���܂��B
   * @return �ً}�����a��2
   */
  public ACTableColumn getParticularInfoTablecolumn3(){
    if(particularInfoTablecolumn3==null){

      particularInfoTablecolumn3 = new ACTableColumn(2, 100);

      particularInfoTablecolumn3.setHeaderValue("�ً}�����a��2");

      addParticularInfoTablecolumn3();
    }
    return particularInfoTablecolumn3;

  }

  /**
   * �ً}�����a��3���擾���܂��B
   * @return �ً}�����a��3
   */
  public ACTableColumn getParticularInfoTablecolumn4(){
    if(particularInfoTablecolumn4==null){

      particularInfoTablecolumn4 = new ACTableColumn(3, 100);

      particularInfoTablecolumn4.setHeaderValue("�ً}�����a��3");

      addParticularInfoTablecolumn4();
    }
    return particularInfoTablecolumn4;

  }

  /**
   * �ً}�����ÊJ�n�N����1���擾���܂��B
   * @return �ً}�����ÊJ�n�N����1
   */
  public ACTableColumn getParticularInfoTablecolumn5(){
    if(particularInfoTablecolumn5==null){

      particularInfoTablecolumn5 = new ACTableColumn(4, 150);

      particularInfoTablecolumn5.setHeaderValue("�ً}�����ÊJ�n�N����1");

      addParticularInfoTablecolumn5();
    }
    return particularInfoTablecolumn5;

  }

  /**
   * �ً}�����ÊJ�n�N����2���擾���܂��B
   * @return �ً}�����ÊJ�n�N����2
   */
  public ACTableColumn getParticularInfoTablecolumn6(){
    if(particularInfoTablecolumn6==null){

      particularInfoTablecolumn6 = new ACTableColumn(5, 150);

      particularInfoTablecolumn6.setHeaderValue("�ً}�����ÊJ�n�N����2");

      addParticularInfoTablecolumn6();
    }
    return particularInfoTablecolumn6;

  }

  /**
   * �ً}�����ÊJ�n�N����3���擾���܂��B
   * @return �ً}�����ÊJ�n�N����3
   */
  public ACTableColumn getParticularInfoTablecolumn7(){
    if(particularInfoTablecolumn7==null){

      particularInfoTablecolumn7 = new ACTableColumn(6, 150);

      particularInfoTablecolumn7.setHeaderValue("�ً}�����ÊJ�n�N����3");

      addParticularInfoTablecolumn7();
    }
    return particularInfoTablecolumn7;

  }

  /**
   * ���f�������擾���܂��B
   * @return ���f����
   */
  public ACTableColumn getParticularInfoTablecolumn8(){
    if(particularInfoTablecolumn8==null){

      particularInfoTablecolumn8 = new ACTableColumn(7, 70);

      particularInfoTablecolumn8.setHeaderValue("���f����");

      addParticularInfoTablecolumn8();
    }
    return particularInfoTablecolumn8;

  }

  /**
   * ���f��Ë@�֖����擾���܂��B
   * @return ���f��Ë@�֖�
   */
  public ACTableColumn getParticularInfoTablecolumn9(){
    if(particularInfoTablecolumn9==null){

      particularInfoTablecolumn9 = new ACTableColumn(8, 105);

      particularInfoTablecolumn9.setHeaderValue("���f��Ë@�֖�");

      addParticularInfoTablecolumn9();
    }
    return particularInfoTablecolumn9;

  }

  /**
   * �ʉ@�������擾���܂��B
   * @return �ʉ@����
   */
  public ACTableColumn getParticularInfoTablecolumn10(){
    if(particularInfoTablecolumn10==null){

      particularInfoTablecolumn10 = new ACTableColumn(9, 70);

      particularInfoTablecolumn10.setHeaderValue("�ʉ@����");

      addParticularInfoTablecolumn10();
    }
    return particularInfoTablecolumn10;

  }

  /**
   * �ʉ@��Ë@�֖����擾���܂��B
   * @return �ʉ@��Ë@�֖�
   */
  public ACTableColumn getParticularInfoTablecolumn11(){
    if(particularInfoTablecolumn11==null){

      particularInfoTablecolumn11 = new ACTableColumn(10, 105);

      particularInfoTablecolumn11.setHeaderValue("�ʉ@��Ë@�֖�");

      addParticularInfoTablecolumn11();
    }
    return particularInfoTablecolumn11;

  }

  /**
   * �ً}�����ÊǗ��P�ʐ����擾���܂��B
   * @return �ً}�����ÊǗ��P�ʐ�
   */
  public ACTableColumn getParticularInfoTablecolumn12(){
    if(particularInfoTablecolumn12==null){

      particularInfoTablecolumn12 = new ACTableColumn(11, 140);

      particularInfoTablecolumn12.setHeaderValue("�ً}�����ÊǗ��P�ʐ�");

      addParticularInfoTablecolumn12();
    }
    return particularInfoTablecolumn12;

  }

  /**
   * �ً}�����ÊǗ��������擾���܂��B
   * @return �ً}�����ÊǗ�����
   */
  public ACTableColumn getParticularInfoTablecolumn13(){
    if(particularInfoTablecolumn13==null){

      particularInfoTablecolumn13 = new ACTableColumn(12, 120);

      particularInfoTablecolumn13.setHeaderValue("�ً}�����ÊǗ�����");

      addParticularInfoTablecolumn13();
    }
    return particularInfoTablecolumn13;

  }

  /**
   * �ً}�����ÊǗ����v���擾���܂��B
   * @return �ً}�����ÊǗ����v
   */
  public ACTableColumn getParticularInfoTablecolumn14(){
    if(particularInfoTablecolumn14==null){

      particularInfoTablecolumn14 = new ACTableColumn(13, 120);

      particularInfoTablecolumn14.setHeaderValue("�ً}�����ÊǗ����v");

      addParticularInfoTablecolumn14();
    }
    return particularInfoTablecolumn14;

  }

  /**
   * ���n�r���e�[�V�����_�����擾���܂��B
   * @return ���n�r���e�[�V�����_��
   */
  public ACTableColumn getParticularInfoTablecolumn15(){
    if(particularInfoTablecolumn15==null){

      particularInfoTablecolumn15 = new ACTableColumn(14, 160);

      particularInfoTablecolumn15.setHeaderValue("���n�r���e�[�V�����_��");

      addParticularInfoTablecolumn15();
    }
    return particularInfoTablecolumn15;

  }

  /**
   * ���u�_�����擾���܂��B
   * @return ���u�_��
   */
  public ACTableColumn getParticularInfoTablecolumn16(){
    if(particularInfoTablecolumn16==null){

      particularInfoTablecolumn16 = new ACTableColumn(15, 70);

      particularInfoTablecolumn16.setHeaderValue("���u�_��");

      addParticularInfoTablecolumn16();
    }
    return particularInfoTablecolumn16;

  }

  /**
   * ��p�_�����擾���܂��B
   * @return ��p�_��
   */
  public ACTableColumn getParticularInfoTablecolumn17(){
    if(particularInfoTablecolumn17==null){

      particularInfoTablecolumn17 = new ACTableColumn(16, 70);

      particularInfoTablecolumn17.setHeaderValue("��p�_��");

      addParticularInfoTablecolumn17();
    }
    return particularInfoTablecolumn17;

  }

  /**
   * �����_�����擾���܂��B
   * @return �����_��
   */
  public ACTableColumn getParticularInfoTablecolumn18(){
    if(particularInfoTablecolumn18==null){

      particularInfoTablecolumn18 = new ACTableColumn(17, 70);

      particularInfoTablecolumn18.setHeaderValue("�����_��");

      addParticularInfoTablecolumn18();
    }
    return particularInfoTablecolumn18;

  }

  /**
   * ���ː����Ó_�����擾���܂��B
   * @return ���ː����Ó_��
   */
  public ACTableColumn getParticularInfoTablecolumn19(){
    if(particularInfoTablecolumn19==null){

      particularInfoTablecolumn19 = new ACTableColumn(18, 105);

      particularInfoTablecolumn19.setHeaderValue("���ː����Ó_��");

      addParticularInfoTablecolumn19();
    }
    return particularInfoTablecolumn19;

  }

  /**
   * ����f�Ô���e�[�u�����擾���܂��B
   * @return ����f�Ô���e�[�u��
   */
  public ACTable getSpecialClinicInfoTable(){
    if(specialClinicInfoTable==null){

      specialClinicInfoTable = new ACTable();

      specialClinicInfoTable.setColumnModel(getSpecialClinicInfoTableColumnModel());

      specialClinicInfoTable.setColumnSort(false);

      addSpecialClinicInfoTable();
    }
    return specialClinicInfoTable;

  }

  /**
   * ����f�Ô���e�[�u���J�������f�����擾���܂��B
   * @return ����f�Ô���e�[�u���J�������f��
   */
  protected VRTableColumnModel getSpecialClinicInfoTableColumnModel(){
    if(specialClinicInfoTableColumnModel==null){
      specialClinicInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addSpecialClinicInfoTableColumnModel();
    }
    return specialClinicInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn0(){
    if(specialClinicInfoTablecolumn0==null){

      specialClinicInfoTablecolumn0 = new ACTableColumn(0, 30);

      specialClinicInfoTablecolumn0.setHeaderValue("�@");

      specialClinicInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      specialClinicInfoTablecolumn0.setSortable(false);

      addSpecialClinicInfoTablecolumn0();
    }
    return specialClinicInfoTablecolumn0;

  }

  /**
   * ���Ə��ԍ����擾���܂��B
   * @return ���Ə��ԍ�
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn1(){
    if(specialClinicInfoTablecolumn1==null){

      specialClinicInfoTablecolumn1 = new ACTableColumn(0, 75);

      specialClinicInfoTablecolumn1.setHeaderValue("���Ə��ԍ�");

      addSpecialClinicInfoTablecolumn1();
    }
    return specialClinicInfoTablecolumn1;

  }

  /**
   * ���R�[�h�����ԍ����擾���܂��B
   * @return ���R�[�h�����ԍ�
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn2(){
    if(specialClinicInfoTablecolumn2==null){

      specialClinicInfoTablecolumn2 = new ACTableColumn(1, 100);

      specialClinicInfoTablecolumn2.setHeaderValue("���R�[�h�����ԍ�");

      addSpecialClinicInfoTablecolumn2();
    }
    return specialClinicInfoTablecolumn2;

  }

  /**
   * ���a�����擾���܂��B
   * @return ���a��
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn3(){
    if(specialClinicInfoTablecolumn3==null){

      specialClinicInfoTablecolumn3 = new ACTableColumn(2, 100);

      specialClinicInfoTablecolumn3.setHeaderValue("���a��");

      addSpecialClinicInfoTablecolumn3();
    }
    return specialClinicInfoTablecolumn3;

  }

  /**
   * ���ʔԍ����擾���܂��B
   * @return ���ʔԍ�
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn4(){
    if(specialClinicInfoTablecolumn4==null){

      specialClinicInfoTablecolumn4 = new ACTableColumn(3, 100);

      specialClinicInfoTablecolumn4.setHeaderValue("���ʔԍ�");

      addSpecialClinicInfoTablecolumn4();
    }
    return specialClinicInfoTablecolumn4;

  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn5(){
    if(specialClinicInfoTablecolumn5==null){

      specialClinicInfoTablecolumn5 = new ACTableColumn(4, 150);

      specialClinicInfoTablecolumn5.setHeaderValue("�P�ʐ�");

      addSpecialClinicInfoTablecolumn5();
    }
    return specialClinicInfoTablecolumn5;

  }

  /**
   * �ی��񐔂��擾���܂��B
   * @return �ی���
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn6(){
    if(specialClinicInfoTablecolumn6==null){

      specialClinicInfoTablecolumn6 = new ACTableColumn(5, 150);

      specialClinicInfoTablecolumn6.setHeaderValue("�ی���");

      addSpecialClinicInfoTablecolumn6();
    }
    return specialClinicInfoTablecolumn6;

  }

  /**
   * �ی��T�[�r�X�P�ʐ����擾���܂��B
   * @return �ی��T�[�r�X�P�ʐ�
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn7(){
    if(specialClinicInfoTablecolumn7==null){

      specialClinicInfoTablecolumn7 = new ACTableColumn(6, 150);

      specialClinicInfoTablecolumn7.setHeaderValue("�ی��T�[�r�X�P�ʐ�");

      addSpecialClinicInfoTablecolumn7();
    }
    return specialClinicInfoTablecolumn7;

  }

  /**
   * �ی����v�P�ʐ����擾���܂��B
   * @return �ی����v�P�ʐ�
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn8(){
    if(specialClinicInfoTablecolumn8==null){

      specialClinicInfoTablecolumn8 = new ACTableColumn(7, 70);

      specialClinicInfoTablecolumn8.setHeaderValue("�ی����v�P�ʐ�");

      addSpecialClinicInfoTablecolumn8();
    }
    return specialClinicInfoTablecolumn8;

  }

  /**
   * ����1�񐔂��擾���܂��B
   * @return ����1��
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn9(){
    if(specialClinicInfoTablecolumn9==null){

      specialClinicInfoTablecolumn9 = new ACTableColumn(8, 105);

      specialClinicInfoTablecolumn9.setHeaderValue("����1��");

      addSpecialClinicInfoTablecolumn9();
    }
    return specialClinicInfoTablecolumn9;

  }

  /**
   * ����2�񐔂��擾���܂��B
   * @return ����2��
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn10(){
    if(specialClinicInfoTablecolumn10==null){

      specialClinicInfoTablecolumn10 = new ACTableColumn(9, 70);

      specialClinicInfoTablecolumn10.setHeaderValue("����2��");

      addSpecialClinicInfoTablecolumn10();
    }
    return specialClinicInfoTablecolumn10;

  }

  /**
   * ����3�񐔂��擾���܂��B
   * @return ����3��
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn11(){
    if(specialClinicInfoTablecolumn11==null){

      specialClinicInfoTablecolumn11 = new ACTableColumn(10, 105);

      specialClinicInfoTablecolumn11.setHeaderValue("����3��");

      addSpecialClinicInfoTablecolumn11();
    }
    return specialClinicInfoTablecolumn11;

  }

  /**
   * �E�v���擾���܂��B
   * @return �E�v
   */
  public ACTableColumn getSpecialClinicInfoTablecolumn12(){
    if(specialClinicInfoTablecolumn12==null){

      specialClinicInfoTablecolumn12 = new ACTableColumn(11, 140);

      specialClinicInfoTablecolumn12.setHeaderValue("�E�v");

      addSpecialClinicInfoTablecolumn12();
    }
    return specialClinicInfoTablecolumn12;

  }

  /**
   * ���莡�Ô�E����f�Ô�ݒ���e�C���p�l�����擾���܂��B
   * @return ���莡�Ô�E����f�Ô�ݒ���e�C���p�l��
   */
  public ACPanel getParticularInfoRevisionPanel(){
    if(particularInfoRevisionPanel==null){

      particularInfoRevisionPanel = new ACPanel();

      addParticularInfoRevisionPanel();
    }
    return particularInfoRevisionPanel;

  }

  /**
   * ���莡�Ô�E����f�Ô�ݒ���e�C�������x�����擾���܂��B
   * @return ���莡�Ô�E����f�Ô�ݒ���e�C�������x��
   */
  public ACLabel getParticularInfoRevisionLabel(){
    if(particularInfoRevisionLabel==null){

      particularInfoRevisionLabel = new ACLabel();

      particularInfoRevisionLabel.setText("�ݒ���e�C����");

      addParticularInfoRevisionLabel();
    }
    return particularInfoRevisionLabel;

  }

  /**
   * ���莡�Ô�E����f�Ô�����擾���܂��B
   * @return ���莡�Ô�E����f�Ô���
   */
  public ACLabel getParticularInfoRevision(){
    if(particularInfoRevision==null){

      particularInfoRevision = new ACLabel();

      particularInfoRevision.setText("���莡�Ô���");

      addParticularInfoRevision();
    }
    return particularInfoRevision;

  }

  /**
   * �S�Ă̏���\�����擾���܂��B
   * @return �S�Ă̏���\��
   */
  public ACIntegerCheckBox getParticularInfoRevisionCheck(){
    if(particularInfoRevisionCheck==null){

      particularInfoRevisionCheck = new ACIntegerCheckBox();

      particularInfoRevisionCheck.setText("���ׂĂ̏���\���iA�j");

      particularInfoRevisionCheck.setMnemonic('A');

      addParticularInfoRevisionCheck();
    }
    return particularInfoRevisionCheck;

  }

  /**
   * ���莡�Ô�E����f�Ô���ڍ׃e�[�u�����擾���܂��B
   * @return ���莡�Ô�E����f�Ô���ڍ׃e�[�u��
   */
  public ACTable getParticularInfoRevisionTable(){
    if(particularInfoRevisionTable==null){

      particularInfoRevisionTable = new ACTable();

      particularInfoRevisionTable.setColumnModel(getParticularInfoRevisionTableColumnModel());

      particularInfoRevisionTable.setColumnSort(false);

      addParticularInfoRevisionTable();
    }
    return particularInfoRevisionTable;

  }

  /**
   * ���莡�Ô�E����f�Ô���ڍ׃e�[�u���J�������f�����擾���܂��B
   * @return ���莡�Ô�E����f�Ô���ڍ׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getParticularInfoRevisionTableColumnModel(){
    if(particularInfoRevisionTableColumnModel==null){
      particularInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addParticularInfoRevisionTableColumnModel();
    }
    return particularInfoRevisionTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getParticularInfoRevisionTablecolumn0(){
    if(particularInfoRevisionTablecolumn0==null){

      particularInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      particularInfoRevisionTablecolumn0.setHeaderValue("�@");

      particularInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      particularInfoRevisionTablecolumn0.setSortable(false);

      addParticularInfoRevisionTablecolumn0();
    }
    return particularInfoRevisionTablecolumn0;

  }

  /**
   * ���ږ����擾���܂��B
   * @return ���ږ�
   */
  public ACTableColumn getParticularInfoRevisionTablecolumn1(){
    if(particularInfoRevisionTablecolumn1==null){

      particularInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      particularInfoRevisionTablecolumn1.setHeaderValue("���ږ�");

      particularInfoRevisionTablecolumn1.setColumns(15);

      addParticularInfoRevisionTablecolumn1();
    }
    return particularInfoRevisionTablecolumn1;

  }

  /**
   * �ݒ�l���擾���܂��B
   * @return �ݒ�l
   */
  public ACTableColumn getParticularInfoRevisionTablecolumn2(){
    if(particularInfoRevisionTablecolumn2==null){

      particularInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      particularInfoRevisionTablecolumn2.setHeaderValue("�ݒ�l");

      particularInfoRevisionTablecolumn2.setEditable(true);

      particularInfoRevisionTablecolumn2.setColumns(8);

      addParticularInfoRevisionTablecolumn2();
    }
    return particularInfoRevisionTablecolumn2;

  }

  /**
   * �R�����g���擾���܂��B
   * @return �R�����g
   */
  public ACTableColumn getParticularInfoRevisionTablecolumn3(){
    if(particularInfoRevisionTablecolumn3==null){

      particularInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      particularInfoRevisionTablecolumn3.setHeaderValue("�R�����g");

      particularInfoRevisionTablecolumn3.setColumns(30);

      addParticularInfoRevisionTablecolumn3();
    }
    return particularInfoRevisionTablecolumn3;

  }

  /**
   * �W�v���̈���擾���܂��B
   * @return �W�v���̈�
   */
  public ACPanel getTotalInfos(){
    if(totalInfos==null){

      totalInfos = new ACPanel();

      addTotalInfos();
    }
    return totalInfos;

  }

  /**
   * �W�v���p�l�����擾���܂��B
   * @return �W�v���p�l��
   */
  public ACPanel getTotalInfoPanel(){
    if(totalInfoPanel==null){

      totalInfoPanel = new ACPanel();

      addTotalInfoPanel();
    }
    return totalInfoPanel;

  }

  /**
   * �W�v��񃉃x�����擾���܂��B
   * @return �W�v��񃉃x��
   */
  public ACLabel getTotalInfoLabel(){
    if(totalInfoLabel==null){

      totalInfoLabel = new ACLabel();

      totalInfoLabel.setText("�W�v���");

      addTotalInfoLabel();
    }
    return totalInfoLabel;

  }

  /**
   * �W�v���e�[�u�����擾���܂��B
   * @return �W�v���e�[�u��
   */
  public ACTable getTotalInfoTable(){
    if(totalInfoTable==null){

      totalInfoTable = new ACTable();

      totalInfoTable.setColumnModel(getTotalInfoTableColumnModel());

      totalInfoTable.setColumnSort(false);

      addTotalInfoTable();
    }
    return totalInfoTable;

  }

  /**
   * �W�v���e�[�u���J�������f�����擾���܂��B
   * @return �W�v���e�[�u���J�������f��
   */
  protected VRTableColumnModel getTotalInfoTableColumnModel(){
    if(totalInfoTableColumnModel==null){
      totalInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addTotalInfoTableColumnModel();
    }
    return totalInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getTotalInfoTablecolumn0(){
    if(totalInfoTablecolumn0==null){

      totalInfoTablecolumn0 = new ACTableColumn(0, 30);

      totalInfoTablecolumn0.setHeaderValue("�@");

      totalInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      totalInfoTablecolumn0.setSortable(false);

      addTotalInfoTablecolumn0();
    }
    return totalInfoTablecolumn0;

  }

  /**
   * �T�[�r�X��ރR�[�h���擾���܂��B
   * @return �T�[�r�X��ރR�[�h
   */
  public ACTableColumn getTotalInfoTablecolumn1(){
    if(totalInfoTablecolumn1==null){

      totalInfoTablecolumn1 = new ACTableColumn(0, 135);

      totalInfoTablecolumn1.setHeaderValue("�T�[�r�X��ރR�[�h");

      addTotalInfoTablecolumn1();
    }
    return totalInfoTablecolumn1;

  }

  /**
   * �T�[�r�X���������擾���܂��B
   * @return �T�[�r�X������
   */
  public ACTableColumn getTotalInfoTablecolumn2(){
    if(totalInfoTablecolumn2==null){

      totalInfoTablecolumn2 = new ACTableColumn(1, 105);

      totalInfoTablecolumn2.setHeaderValue("�T�[�r�X������");

      addTotalInfoTablecolumn2();
    }
    return totalInfoTablecolumn2;

  }

  /**
   * �v��P�ʐ����擾���܂��B
   * @return �v��P�ʐ�
   */
  public ACTableColumn getTotalInfoTablecolumn3(){
    if(totalInfoTablecolumn3==null){

      totalInfoTablecolumn3 = new ACTableColumn(2, 77);

      totalInfoTablecolumn3.setHeaderValue("�v��P�ʐ�");

      addTotalInfoTablecolumn3();
    }
    return totalInfoTablecolumn3;

  }

  /**
   * ���x�z�Ǘ��ΏےP�ʐ����擾���܂��B
   * @return ���x�z�Ǘ��ΏےP�ʐ�
   */
  public ACTableColumn getTotalInfoTablecolumn4(){
    if(totalInfoTablecolumn4==null){

      totalInfoTablecolumn4 = new ACTableColumn(3, 140);

      totalInfoTablecolumn4.setHeaderValue("���x�z�Ǘ��ΏےP�ʐ�");

      addTotalInfoTablecolumn4();
    }
    return totalInfoTablecolumn4;

  }

  /**
   * ���x�z�Ǘ��ΏۊO�P�ʐ����擾���܂��B
   * @return ���x�z�Ǘ��ΏۊO�P�ʐ�
   */
  public ACTableColumn getTotalInfoTablecolumn5(){
    if(totalInfoTablecolumn5==null){

      totalInfoTablecolumn5 = new ACTableColumn(4, 155);

      totalInfoTablecolumn5.setHeaderValue("���x�z�Ǘ��ΏۊO�P�ʐ�");

      addTotalInfoTablecolumn5();
    }
    return totalInfoTablecolumn5;

  }

  /**
   * �Z�������v��������擾���܂��B
   * @return �Z�������v�����
   */
  public ACTableColumn getTotalInfoTablecolumn6(){
    if(totalInfoTablecolumn6==null){

      totalInfoTablecolumn6 = new ACTableColumn(5, 120);

      totalInfoTablecolumn6.setHeaderValue("�Z�������v�����");

      addTotalInfoTablecolumn6();
    }
    return totalInfoTablecolumn6;

  }

  /**
   * �Z���������������擾���܂��B
   * @return �Z������������
   */
  public ACTableColumn getTotalInfoTablecolumn7(){
    if(totalInfoTablecolumn7==null){

      totalInfoTablecolumn7 = new ACTableColumn(6, 105);

      totalInfoTablecolumn7.setHeaderValue("�Z������������");

      addTotalInfoTablecolumn7();
    }
    return totalInfoTablecolumn7;

  }

  /**
   * �ی��P�ʐ����v���擾���܂��B
   * @return �ی��P�ʐ����v
   */
  public ACTableColumn getTotalInfoTablecolumn8(){
    if(totalInfoTablecolumn8==null){

      totalInfoTablecolumn8 = new ACTableColumn(7, 105);

      totalInfoTablecolumn8.setHeaderValue("�ی��P�ʐ����v");

      addTotalInfoTablecolumn8();
    }
    return totalInfoTablecolumn8;

  }

  /**
   * �ی��P�ʐ��P�����擾���܂��B
   * @return �ی��P�ʐ��P��
   */
  public ACTableColumn getTotalInfoTablecolumn9(){
    if(totalInfoTablecolumn9==null){

      totalInfoTablecolumn9 = new ACTableColumn(8, 105);

      totalInfoTablecolumn9.setHeaderValue("�ی��P�ʐ��P��");

      addTotalInfoTablecolumn9();
    }
    return totalInfoTablecolumn9;

  }

  /**
   * �ی������z���擾���܂��B
   * @return �ی������z
   */
  public ACTableColumn getTotalInfoTablecolumn10(){
    if(totalInfoTablecolumn10==null){

      totalInfoTablecolumn10 = new ACTableColumn(9, 77);

      totalInfoTablecolumn10.setHeaderValue("�ی������z");

      addTotalInfoTablecolumn10();
    }
    return totalInfoTablecolumn10;

  }

  /**
   * �ی����p�ҕ��S�z���擾���܂��B
   * @return �ی����p�ҕ��S�z
   */
  public ACTableColumn getTotalInfoTablecolumn11(){
    if(totalInfoTablecolumn11==null){

      totalInfoTablecolumn11 = new ACTableColumn(10, 120);

      totalInfoTablecolumn11.setHeaderValue("�ی����p�ҕ��S�z");

      addTotalInfoTablecolumn11();
    }
    return totalInfoTablecolumn11;

  }

  /**
   * ����1�����z���擾���܂��B
   * @return ����1�����z
   */
  public ACTableColumn getTotalInfoTablecolumn12(){
    if(totalInfoTablecolumn12==null){

      totalInfoTablecolumn12 = new ACTableColumn(11, 90);

      totalInfoTablecolumn12.setHeaderValue("����1�����z");

      addTotalInfoTablecolumn12();
    }
    return totalInfoTablecolumn12;

  }

  /**
   * ����1�{�l���S�z���擾���܂��B
   * @return ����1�{�l���S�z
   */
  public ACTableColumn getTotalInfoTablecolumn13(){
    if(totalInfoTablecolumn13==null){

      totalInfoTablecolumn13 = new ACTableColumn(12, 110);

      totalInfoTablecolumn13.setHeaderValue("����1�{�l���S�z");

      addTotalInfoTablecolumn13();
    }
    return totalInfoTablecolumn13;

  }

  /**
   * ����2�����z���擾���܂��B
   * @return ����2�����z
   */
  public ACTableColumn getTotalInfoTablecolumn14(){
    if(totalInfoTablecolumn14==null){

      totalInfoTablecolumn14 = new ACTableColumn(13, 90);

      totalInfoTablecolumn14.setHeaderValue("����2�����z");

      addTotalInfoTablecolumn14();
    }
    return totalInfoTablecolumn14;

  }

  /**
   * ����2�{�l���S�z���擾���܂��B
   * @return ����2�{�l���S�z
   */
  public ACTableColumn getTotalInfoTablecolumn15(){
    if(totalInfoTablecolumn15==null){

      totalInfoTablecolumn15 = new ACTableColumn(14, 110);

      totalInfoTablecolumn15.setHeaderValue("����2�{�l���S�z");

      addTotalInfoTablecolumn15();
    }
    return totalInfoTablecolumn15;

  }

  /**
   * ����3�����z���擾���܂��B
   * @return ����3�����z
   */
  public ACTableColumn getTotalInfoTablecolumn16(){
    if(totalInfoTablecolumn16==null){

      totalInfoTablecolumn16 = new ACTableColumn(15, 90);

      totalInfoTablecolumn16.setHeaderValue("����3�����z");

      addTotalInfoTablecolumn16();
    }
    return totalInfoTablecolumn16;

  }

  /**
   * ����3�{�l���S�z���擾���܂��B
   * @return ����3�{�l���S�z
   */
  public ACTableColumn getTotalInfoTablecolumn17(){
    if(totalInfoTablecolumn17==null){

      totalInfoTablecolumn17 = new ACTableColumn(16, 110);

      totalInfoTablecolumn17.setHeaderValue("����3�{�l���S�z");

      addTotalInfoTablecolumn17();
    }
    return totalInfoTablecolumn17;

  }

  /**
   * �ی����o������Ô�P�ʐ����v���擾���܂��B
   * @return �ی����o������Ô�P�ʐ����v
   */
  public ACTableColumn getTotalInfoTablecolumn18(){
    if(totalInfoTablecolumn18==null){

      totalInfoTablecolumn18 = new ACTableColumn(17, 195);

      totalInfoTablecolumn18.setHeaderValue("�ی����o������Ô�P�ʐ����v");

      addTotalInfoTablecolumn18();
    }
    return totalInfoTablecolumn18;

  }

  /**
   * �ی����o������Ô���z���擾���܂��B
   * @return �ی����o������Ô���z
   */
  public ACTableColumn getTotalInfoTablecolumn19(){
    if(totalInfoTablecolumn19==null){

      totalInfoTablecolumn19 = new ACTableColumn(18, 175);

      totalInfoTablecolumn19.setHeaderValue("�ی����o������Ô���z");

      addTotalInfoTablecolumn19();
    }
    return totalInfoTablecolumn19;

  }

  /**
   * �ی����o������Ô�p�ҕ��S�z���擾���܂��B
   * @return �ی����o������Ô�p�ҕ��S�z
   */
  public ACTableColumn getTotalInfoTablecolumn20(){
    if(totalInfoTablecolumn20==null){

      totalInfoTablecolumn20 = new ACTableColumn(19, 210);

      totalInfoTablecolumn20.setHeaderValue("�ی����o������Ô�p�ҕ��S�z");

      addTotalInfoTablecolumn20();
    }
    return totalInfoTablecolumn20;

  }

  /**
   * �W�v���ݒ���e�C���p�l�����擾���܂��B
   * @return �W�v���ݒ���e�C���p�l��
   */
  public ACPanel getTotalInfoRevisionPanel(){
    if(totalInfoRevisionPanel==null){

      totalInfoRevisionPanel = new ACPanel();

      addTotalInfoRevisionPanel();
    }
    return totalInfoRevisionPanel;

  }

  /**
   * �W�v�ݒ���e�C�������x�����擾���܂��B
   * @return �W�v�ݒ���e�C�������x��
   */
  public ACLabel getTotalInfoRevisionLabel(){
    if(totalInfoRevisionLabel==null){

      totalInfoRevisionLabel = new ACLabel();

      totalInfoRevisionLabel.setText("�ݒ���e�C����");

      addTotalInfoRevisionLabel();
    }
    return totalInfoRevisionLabel;

  }

  /**
   * �W�v�����擾���܂��B
   * @return �W�v���
   */
  public ACLabel getTotalInfoRevision(){
    if(totalInfoRevision==null){

      totalInfoRevision = new ACLabel();

      totalInfoRevision.setText("�W�v���");

      addTotalInfoRevision();
    }
    return totalInfoRevision;

  }

  /**
   * �S�Ă̏���\�����擾���܂��B
   * @return �S�Ă̏���\��
   */
  public ACIntegerCheckBox getTotalInfoRevisionCheck(){
    if(totalInfoRevisionCheck==null){

      totalInfoRevisionCheck = new ACIntegerCheckBox();

      totalInfoRevisionCheck.setText("���ׂĂ̏���\���iA�j");

      totalInfoRevisionCheck.setMnemonic('A');

      addTotalInfoRevisionCheck();
    }
    return totalInfoRevisionCheck;

  }

  /**
   * �W�v���ڍ׃e�[�u�����擾���܂��B
   * @return �W�v���ڍ׃e�[�u��
   */
  public ACTable getTotalInfoRevisionTable(){
    if(totalInfoRevisionTable==null){

      totalInfoRevisionTable = new ACTable();

      totalInfoRevisionTable.setColumnModel(getTotalInfoRevisionTableColumnModel());

      totalInfoRevisionTable.setColumnSort(false);

      addTotalInfoRevisionTable();
    }
    return totalInfoRevisionTable;

  }

  /**
   * �W�v���ڍ׃e�[�u���J�������f�����擾���܂��B
   * @return �W�v���ڍ׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getTotalInfoRevisionTableColumnModel(){
    if(totalInfoRevisionTableColumnModel==null){
      totalInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addTotalInfoRevisionTableColumnModel();
    }
    return totalInfoRevisionTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getTotalInfoRevisionTablecolumn0(){
    if(totalInfoRevisionTablecolumn0==null){

      totalInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      totalInfoRevisionTablecolumn0.setHeaderValue("�@");

      totalInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      totalInfoRevisionTablecolumn0.setSortable(false);

      addTotalInfoRevisionTablecolumn0();
    }
    return totalInfoRevisionTablecolumn0;

  }

  /**
   * ���ږ����擾���܂��B
   * @return ���ږ�
   */
  public ACTableColumn getTotalInfoRevisionTablecolumn1(){
    if(totalInfoRevisionTablecolumn1==null){

      totalInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      totalInfoRevisionTablecolumn1.setHeaderValue("���ږ�");

      totalInfoRevisionTablecolumn1.setColumns(15);

      addTotalInfoRevisionTablecolumn1();
    }
    return totalInfoRevisionTablecolumn1;

  }

  /**
   * �ݒ�l���擾���܂��B
   * @return �ݒ�l
   */
  public ACTableColumn getTotalInfoRevisionTablecolumn2(){
    if(totalInfoRevisionTablecolumn2==null){

      totalInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      totalInfoRevisionTablecolumn2.setHeaderValue("�ݒ�l");

      totalInfoRevisionTablecolumn2.setEditable(true);

      totalInfoRevisionTablecolumn2.setColumns(8);

      addTotalInfoRevisionTablecolumn2();
    }
    return totalInfoRevisionTablecolumn2;

  }

  /**
   * �R�����g���擾���܂��B
   * @return �R�����g
   */
  public ACTableColumn getTotalInfoRevisionTablecolumn3(){
    if(totalInfoRevisionTablecolumn3==null){

      totalInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      totalInfoRevisionTablecolumn3.setHeaderValue("�R�����g");

      totalInfoRevisionTablecolumn3.setColumns(30);

      addTotalInfoRevisionTablecolumn3();
    }
    return totalInfoRevisionTablecolumn3;

  }

  /**
   * ��������҉�����̈���擾���܂��B
   * @return ��������҉�����̈�
   */
  public ACPanel getNyushoInfos(){
    if(nyushoInfos==null){

      nyushoInfos = new ACPanel();

      addNyushoInfos();
    }
    return nyushoInfos;

  }

  /**
   * ��������҉�����p�l�����擾���܂��B
   * @return ��������҉�����p�l��
   */
  public ACPanel getNyushoInfoPanel(){
    if(nyushoInfoPanel==null){

      nyushoInfoPanel = new ACPanel();

      addNyushoInfoPanel();
    }
    return nyushoInfoPanel;

  }

  /**
   * ��������҉����񃉃x�����擾���܂��B
   * @return ��������҉����񃉃x��
   */
  public ACLabel getNyushoInfoLabel(){
    if(nyushoInfoLabel==null){

      nyushoInfoLabel = new ACLabel();

      nyushoInfoLabel.setText("��������҉�����");

      addNyushoInfoLabel();
    }
    return nyushoInfoLabel;

  }

  /**
   * �T�[�r�X�ǉ��{�^�����擾���܂��B
   * @return �T�[�r�X�ǉ��{�^��
   */
  public ACButton getServiceAddButton(){
    if(serviceAddButton==null){

      serviceAddButton = new ACButton();

      serviceAddButton.setText("�T�[�r�X�ǉ�");

      serviceAddButton.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addServiceAddButton();
    }
    return serviceAddButton;

  }

  /**
   * �T�[�r�X�폜�{�^�����擾���܂��B
   * @return �T�[�r�X�폜�{�^��
   */
  public ACButton getServiceDelButton(){
    if(serviceDelButton==null){

      serviceDelButton = new ACButton();

      serviceDelButton.setText("�T�[�r�X�폜");

      serviceDelButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addServiceDelButton();
    }
    return serviceDelButton;

  }

  /**
   * ��������҉�����e�[�u�����擾���܂��B
   * @return ��������҉�����e�[�u��
   */
  public ACTable getNyushoInfoTable(){
    if(nyushoInfoTable==null){

      nyushoInfoTable = new ACTable();

      nyushoInfoTable.setColumnModel(getNyushoInfoTableColumnModel());

      nyushoInfoTable.setColumnSort(false);

      addNyushoInfoTable();
    }
    return nyushoInfoTable;

  }

  /**
   * ��������҉�����e�[�u���J�������f�����擾���܂��B
   * @return ��������҉�����e�[�u���J�������f��
   */
  protected VRTableColumnModel getNyushoInfoTableColumnModel(){
    if(nyushoInfoTableColumnModel==null){
      nyushoInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addNyushoInfoTableColumnModel();
    }
    return nyushoInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getNyushoInfoTablecolumn0(){
    if(nyushoInfoTablecolumn0==null){

      nyushoInfoTablecolumn0 = new ACTableColumn(0, 30);

      nyushoInfoTablecolumn0.setHeaderValue("�@");

      nyushoInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      nyushoInfoTablecolumn0.setSortable(false);

      addNyushoInfoTablecolumn0();
    }
    return nyushoInfoTablecolumn0;

  }

  /**
   * ���R�[�h�����擾���܂��B
   * @return ���R�[�h��
   */
  public ACTableColumn getNyushoInfoTablecolumn1(){
    if(nyushoInfoTablecolumn1==null){

      nyushoInfoTablecolumn1 = new ACTableColumn(0, 80);

      nyushoInfoTablecolumn1.setHeaderValue("���R�[�h��");

      addNyushoInfoTablecolumn1();
    }
    return nyushoInfoTablecolumn1;

  }

  /**
   * �T�[�r�X�R�[�h���擾���܂��B
   * @return �T�[�r�X�R�[�h
   */
  public ACTableColumn getNyushoInfoTablecolumn2(){
    if(nyushoInfoTablecolumn2==null){

      nyushoInfoTablecolumn2 = new ACTableColumn(1, 110);

      nyushoInfoTablecolumn2.setHeaderValue("�T�[�r�X�R�[�h");

      addNyushoInfoTablecolumn2();
    }
    return nyushoInfoTablecolumn2;

  }

  /**
   * �T�[�r�X�����擾���܂��B
   * @return �T�[�r�X��
   */
  public ACTableColumn getNyushoInfoTablecolumn3(){
    if(nyushoInfoTablecolumn3==null){

      nyushoInfoTablecolumn3 = new ACTableColumn(2, 110);

      nyushoInfoTablecolumn3.setHeaderValue("�T�[�r�X��");

      addNyushoInfoTablecolumn3();
    }
    return nyushoInfoTablecolumn3;

  }

  /**
   * ��p�P�����擾���܂��B
   * @return ��p�P��
   */
  public ACTableColumn getNyushoInfoTablecolumn4(){
    if(nyushoInfoTablecolumn4==null){

      nyushoInfoTablecolumn4 = new ACTableColumn(3, 80);

      nyushoInfoTablecolumn4.setHeaderValue("��p�P��");

      addNyushoInfoTablecolumn4();
    }
    return nyushoInfoTablecolumn4;

  }

  /**
   * ���S���x�z���擾���܂��B
   * @return ���S���x�z
   */
  public ACTableColumn getNyushoInfoTablecolumn5(){
    if(nyushoInfoTablecolumn5==null){

      nyushoInfoTablecolumn5 = new ACTableColumn(4, 80);

      nyushoInfoTablecolumn5.setHeaderValue("���S���x�z");

      addNyushoInfoTablecolumn5();
    }
    return nyushoInfoTablecolumn5;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACTableColumn getNyushoInfoTablecolumn6(){
    if(nyushoInfoTablecolumn6==null){

      nyushoInfoTablecolumn6 = new ACTableColumn(5, 50);

      nyushoInfoTablecolumn6.setHeaderValue("����");

      addNyushoInfoTablecolumn6();
    }
    return nyushoInfoTablecolumn6;

  }

  /**
   * ����1�������擾���܂��B
   * @return ����1����
   */
  public ACTableColumn getNyushoInfoTablecolumn7(){
    if(nyushoInfoTablecolumn7==null){

      nyushoInfoTablecolumn7 = new ACTableColumn(6, 80);

      nyushoInfoTablecolumn7.setHeaderValue("����1����");

      addNyushoInfoTablecolumn7();
    }
    return nyushoInfoTablecolumn7;

  }

  /**
   * ����2�������擾���܂��B
   * @return ����2����
   */
  public ACTableColumn getNyushoInfoTablecolumn8(){
    if(nyushoInfoTablecolumn8==null){

      nyushoInfoTablecolumn8 = new ACTableColumn(7, 80);

      nyushoInfoTablecolumn8.setHeaderValue("����2����");

      addNyushoInfoTablecolumn8();
    }
    return nyushoInfoTablecolumn8;

  }

  /**
   * ����3�������擾���܂��B
   * @return ����3����
   */
  public ACTableColumn getNyushoInfoTablecolumn9(){
    if(nyushoInfoTablecolumn9==null){

      nyushoInfoTablecolumn9 = new ACTableColumn(8, 80);

      nyushoInfoTablecolumn9.setHeaderValue("����3����");

      addNyushoInfoTablecolumn9();
    }
    return nyushoInfoTablecolumn9;

  }

  /**
   * ��p�z���擾���܂��B
   * @return ��p�z
   */
  public ACTableColumn getNyushoInfoTablecolumn10(){
    if(nyushoInfoTablecolumn10==null){

      nyushoInfoTablecolumn10 = new ACTableColumn(9, 50);

      nyushoInfoTablecolumn10.setHeaderValue("��p�z");

      addNyushoInfoTablecolumn10();
    }
    return nyushoInfoTablecolumn10;

  }

  /**
   * �ی��������z���擾���܂��B
   * @return �ی��������z
   */
  public ACTableColumn getNyushoInfoTablecolumn11(){
    if(nyushoInfoTablecolumn11==null){

      nyushoInfoTablecolumn11 = new ACTableColumn(10, 100);

      nyushoInfoTablecolumn11.setHeaderValue("�ی��������z");

      addNyushoInfoTablecolumn11();
    }
    return nyushoInfoTablecolumn11;

  }

  /**
   * ����1���S�z���擾���܂��B
   * @return ����1���S�z
   */
  public ACTableColumn getNyushoInfoTablecolumn12(){
    if(nyushoInfoTablecolumn12==null){

      nyushoInfoTablecolumn12 = new ACTableColumn(11, 80);

      nyushoInfoTablecolumn12.setHeaderValue("����1���S�z");

      addNyushoInfoTablecolumn12();
    }
    return nyushoInfoTablecolumn12;

  }

  /**
   * ����2���S�z���擾���܂��B
   * @return ����2���S�z
   */
  public ACTableColumn getNyushoInfoTablecolumn13(){
    if(nyushoInfoTablecolumn13==null){

      nyushoInfoTablecolumn13 = new ACTableColumn(12, 80);

      nyushoInfoTablecolumn13.setHeaderValue("����2���S�z");

      addNyushoInfoTablecolumn13();
    }
    return nyushoInfoTablecolumn13;

  }

  /**
   * ����3���S�z���擾���܂��B
   * @return ����3���S�z
   */
  public ACTableColumn getNyushoInfoTablecolumn14(){
    if(nyushoInfoTablecolumn14==null){

      nyushoInfoTablecolumn14 = new ACTableColumn(13, 80);

      nyushoInfoTablecolumn14.setHeaderValue("����3���S�z");

      addNyushoInfoTablecolumn14();
    }
    return nyushoInfoTablecolumn14;

  }

  /**
   * ���p�ҕ��S�z���擾���܂��B
   * @return ���p�ҕ��S�z
   */
  public ACTableColumn getNyushoInfoTablecolumn15(){
    if(nyushoInfoTablecolumn15==null){

      nyushoInfoTablecolumn15 = new ACTableColumn(14, 100);

      nyushoInfoTablecolumn15.setHeaderValue("���p�ҕ��S�z");

      addNyushoInfoTablecolumn15();
    }
    return nyushoInfoTablecolumn15;

  }

  /**
   * ��p�z���v���擾���܂��B
   * @return ��p�z���v
   */
  public ACTableColumn getNyushoInfoTablecolumn16(){
    if(nyushoInfoTablecolumn16==null){

      nyushoInfoTablecolumn16 = new ACTableColumn(15, 80);

      nyushoInfoTablecolumn16.setHeaderValue("��p�z���v");

      addNyushoInfoTablecolumn16();
    }
    return nyushoInfoTablecolumn16;

  }

  /**
   * �ی��������z���v���擾���܂��B
   * @return �ی��������z���v
   */
  public ACTableColumn getNyushoInfoTablecolumn17(){
    if(nyushoInfoTablecolumn17==null){

      nyushoInfoTablecolumn17 = new ACTableColumn(16, 140);

      nyushoInfoTablecolumn17.setHeaderValue("�ی��������z���v");

      addNyushoInfoTablecolumn17();
    }
    return nyushoInfoTablecolumn17;

  }

  /**
   * ���p�ҕ��S�z���v���擾���܂��B
   * @return ���p�ҕ��S�z���v
   */
  public ACTableColumn getNyushoInfoTablecolumn18(){
    if(nyushoInfoTablecolumn18==null){

      nyushoInfoTablecolumn18 = new ACTableColumn(17, 140);

      nyushoInfoTablecolumn18.setHeaderValue("���p�ҕ��S�z���v");

      addNyushoInfoTablecolumn18();
    }
    return nyushoInfoTablecolumn18;

  }

  /**
   * ����1���S�z���v���擾���܂��B
   * @return ����1���S�z���v
   */
  public ACTableColumn getNyushoInfoTablecolumn19(){
    if(nyushoInfoTablecolumn19==null){

      nyushoInfoTablecolumn19 = new ACTableColumn(18, 120);

      nyushoInfoTablecolumn19.setHeaderValue("����1���S�z���v");

      addNyushoInfoTablecolumn19();
    }
    return nyushoInfoTablecolumn19;

  }

  /**
   * ����1�����z���擾���܂��B
   * @return ����1�����z
   */
  public ACTableColumn getNyushoInfoTablecolumn20(){
    if(nyushoInfoTablecolumn20==null){

      nyushoInfoTablecolumn20 = new ACTableColumn(19, 100);

      nyushoInfoTablecolumn20.setHeaderValue("����1�����z");

      addNyushoInfoTablecolumn20();
    }
    return nyushoInfoTablecolumn20;

  }

  /**
   * ����1�{�l���S���z���擾���܂��B
   * @return ����1�{�l���S���z
   */
  public ACTableColumn getNyushoInfoTablecolumn21(){
    if(nyushoInfoTablecolumn21==null){

      nyushoInfoTablecolumn21 = new ACTableColumn(20, 150);

      nyushoInfoTablecolumn21.setHeaderValue("����1�{�l���S���z");

      addNyushoInfoTablecolumn21();
    }
    return nyushoInfoTablecolumn21;

  }

  /**
   * ����2���S�z���v���擾���܂��B
   * @return ����2���S�z���v
   */
  public ACTableColumn getNyushoInfoTablecolumn22(){
    if(nyushoInfoTablecolumn22==null){

      nyushoInfoTablecolumn22 = new ACTableColumn(21, 140);

      nyushoInfoTablecolumn22.setHeaderValue("����2���S�z���v");

      addNyushoInfoTablecolumn22();
    }
    return nyushoInfoTablecolumn22;

  }

  /**
   * ����2�����z���擾���܂��B
   * @return ����2�����z
   */
  public ACTableColumn getNyushoInfoTablecolumn23(){
    if(nyushoInfoTablecolumn23==null){

      nyushoInfoTablecolumn23 = new ACTableColumn(22, 100);

      nyushoInfoTablecolumn23.setHeaderValue("����2�����z");

      addNyushoInfoTablecolumn23();
    }
    return nyushoInfoTablecolumn23;

  }

  /**
   * ����2�{�l���S���z���擾���܂��B
   * @return ����2�{�l���S���z
   */
  public ACTableColumn getNyushoInfoTablecolumn24(){
    if(nyushoInfoTablecolumn24==null){

      nyushoInfoTablecolumn24 = new ACTableColumn(23, 150);

      nyushoInfoTablecolumn24.setHeaderValue("����2�{�l���S���z");

      addNyushoInfoTablecolumn24();
    }
    return nyushoInfoTablecolumn24;

  }

  /**
   * ����3���S�z���v���擾���܂��B
   * @return ����3���S�z���v
   */
  public ACTableColumn getNyushoInfoTablecolumn25(){
    if(nyushoInfoTablecolumn25==null){

      nyushoInfoTablecolumn25 = new ACTableColumn(24, 140);

      nyushoInfoTablecolumn25.setHeaderValue("����3���S�z���v");

      addNyushoInfoTablecolumn25();
    }
    return nyushoInfoTablecolumn25;

  }

  /**
   * ����3�����z���擾���܂��B
   * @return ����3�����z
   */
  public ACTableColumn getNyushoInfoTablecolumn26(){
    if(nyushoInfoTablecolumn26==null){

      nyushoInfoTablecolumn26 = new ACTableColumn(25, 100);

      nyushoInfoTablecolumn26.setHeaderValue("����3�����z");

      addNyushoInfoTablecolumn26();
    }
    return nyushoInfoTablecolumn26;

  }

  /**
   * ����3�{�l���S���z���擾���܂��B
   * @return ����3�{�l���S���z
   */
  public ACTableColumn getNyushoInfoTablecolumn27(){
    if(nyushoInfoTablecolumn27==null){

      nyushoInfoTablecolumn27 = new ACTableColumn(26, 150);

      nyushoInfoTablecolumn27.setHeaderValue("����3�{�l���S���z");

      addNyushoInfoTablecolumn27();
    }
    return nyushoInfoTablecolumn27;

  }

  /**
   * ��������҉���ݒ���e�C���p�l�����擾���܂��B
   * @return ��������҉���ݒ���e�C���p�l��
   */
  public ACPanel getNyushoInfoRevisionPanel(){
    if(nyushoInfoRevisionPanel==null){

      nyushoInfoRevisionPanel = new ACPanel();

      addNyushoInfoRevisionPanel();
    }
    return nyushoInfoRevisionPanel;

  }

  /**
   * ��������҉���ݒ���e�C�������x�����擾���܂��B
   * @return ��������҉���ݒ���e�C�������x��
   */
  public ACLabel getNyushoInfoRevisionLabel(){
    if(nyushoInfoRevisionLabel==null){

      nyushoInfoRevisionLabel = new ACLabel();

      nyushoInfoRevisionLabel.setText("�ݒ���e�C����");

      addNyushoInfoRevisionLabel();
    }
    return nyushoInfoRevisionLabel;

  }

  /**
   * ��������҉�������擾���܂��B
   * @return ��������҉�����
   */
  public ACLabel getNyushoInfoRevision(){
    if(nyushoInfoRevision==null){

      nyushoInfoRevision = new ACLabel();

      nyushoInfoRevision.setText("��������҉�����");

      addNyushoInfoRevision();
    }
    return nyushoInfoRevision;

  }

  /**
   * �S�Ă̏���\�����擾���܂��B
   * @return �S�Ă̏���\��
   */
  public ACIntegerCheckBox getNyushoInfoRevisionCheck(){
    if(nyushoInfoRevisionCheck==null){

      nyushoInfoRevisionCheck = new ACIntegerCheckBox();

      nyushoInfoRevisionCheck.setText("���ׂĂ̏���\���iA�j");

      nyushoInfoRevisionCheck.setMnemonic('A');

      addNyushoInfoRevisionCheck();
    }
    return nyushoInfoRevisionCheck;

  }

  /**
   * ��������҉�����ڍ׃e�[�u�����擾���܂��B
   * @return ��������҉�����ڍ׃e�[�u��
   */
  public ACTable getNyushoInfoRevisionTable(){
    if(nyushoInfoRevisionTable==null){

      nyushoInfoRevisionTable = new ACTable();

      nyushoInfoRevisionTable.setColumnModel(getNyushoInfoRevisionTableColumnModel());

      nyushoInfoRevisionTable.setColumnSort(false);

      addNyushoInfoRevisionTable();
    }
    return nyushoInfoRevisionTable;

  }

  /**
   * ��������҉�����ڍ׃e�[�u���J�������f�����擾���܂��B
   * @return ��������҉�����ڍ׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getNyushoInfoRevisionTableColumnModel(){
    if(nyushoInfoRevisionTableColumnModel==null){
      nyushoInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addNyushoInfoRevisionTableColumnModel();
    }
    return nyushoInfoRevisionTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getNyushoInfoRevisionTablecolumn0(){
    if(nyushoInfoRevisionTablecolumn0==null){

      nyushoInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      nyushoInfoRevisionTablecolumn0.setHeaderValue("�@");

      nyushoInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      nyushoInfoRevisionTablecolumn0.setSortable(false);

      addNyushoInfoRevisionTablecolumn0();
    }
    return nyushoInfoRevisionTablecolumn0;

  }

  /**
   * ���ږ����擾���܂��B
   * @return ���ږ�
   */
  public ACTableColumn getNyushoInfoRevisionTablecolumn1(){
    if(nyushoInfoRevisionTablecolumn1==null){

      nyushoInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      nyushoInfoRevisionTablecolumn1.setHeaderValue("���ږ�");

      nyushoInfoRevisionTablecolumn1.setColumns(15);

      addNyushoInfoRevisionTablecolumn1();
    }
    return nyushoInfoRevisionTablecolumn1;

  }

  /**
   * �ݒ�l���擾���܂��B
   * @return �ݒ�l
   */
  public ACTableColumn getNyushoInfoRevisionTablecolumn2(){
    if(nyushoInfoRevisionTablecolumn2==null){

      nyushoInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      nyushoInfoRevisionTablecolumn2.setHeaderValue("�ݒ�l");

      nyushoInfoRevisionTablecolumn2.setEditable(true);

      nyushoInfoRevisionTablecolumn2.setColumns(8);

      addNyushoInfoRevisionTablecolumn2();
    }
    return nyushoInfoRevisionTablecolumn2;

  }

  /**
   * �R�����g���擾���܂��B
   * @return �R�����g
   */
  public ACTableColumn getNyushoInfoRevisionTablecolumn3(){
    if(nyushoInfoRevisionTablecolumn3==null){

      nyushoInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      nyushoInfoRevisionTablecolumn3.setHeaderValue("�R�����g");

      nyushoInfoRevisionTablecolumn3.setColumns(30);

      addNyushoInfoRevisionTablecolumn3();
    }
    return nyushoInfoRevisionTablecolumn3;

  }

  /**
   * �Љ���@�l�y���z���̈���擾���܂��B
   * @return �Љ���@�l�y���z���̈�
   */
  public ACPanel getShahukuInfos(){
    if(shahukuInfos==null){

      shahukuInfos = new ACPanel();

      addShahukuInfos();
    }
    return shahukuInfos;

  }

  /**
   * �Љ���@�l�y���z���p�l�����擾���܂��B
   * @return �Љ���@�l�y���z���p�l��
   */
  public ACPanel getShahukuInfoPanel(){
    if(shahukuInfoPanel==null){

      shahukuInfoPanel = new ACPanel();

      addShahukuInfoPanel();
    }
    return shahukuInfoPanel;

  }

  /**
   * �Љ���@�l�y���z��񃉃x�����擾���܂��B
   * @return �Љ���@�l�y���z��񃉃x��
   */
  public ACLabel getShahukuInfoLabel(){
    if(shahukuInfoLabel==null){

      shahukuInfoLabel = new ACLabel();

      shahukuInfoLabel.setText("�Љ���@�l�y�����");

      addShahukuInfoLabel();
    }
    return shahukuInfoLabel;

  }

  /**
   * �Љ���@�l�y���z���e�[�u�����擾���܂��B
   * @return �Љ���@�l�y���z���e�[�u��
   */
  public ACTable getShahukuInfoTable(){
    if(shahukuInfoTable==null){

      shahukuInfoTable = new ACTable();

      shahukuInfoTable.setColumnModel(getShahukuInfoTableColumnModel());

      shahukuInfoTable.setColumnSort(false);

      addShahukuInfoTable();
    }
    return shahukuInfoTable;

  }

  /**
   * �Љ���@�l�y���z���e�[�u���J�������f�����擾���܂��B
   * @return �Љ���@�l�y���z���e�[�u���J�������f��
   */
  protected VRTableColumnModel getShahukuInfoTableColumnModel(){
    if(shahukuInfoTableColumnModel==null){
      shahukuInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addShahukuInfoTableColumnModel();
    }
    return shahukuInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getShahukuInfoTablecolumn0(){
    if(shahukuInfoTablecolumn0==null){

      shahukuInfoTablecolumn0 = new ACTableColumn(0, 30);

      shahukuInfoTablecolumn0.setHeaderValue("�@");

      shahukuInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      shahukuInfoTablecolumn0.setSortable(false);

      addShahukuInfoTablecolumn0();
    }
    return shahukuInfoTablecolumn0;

  }

  /**
   * �y�������擾���܂��B
   * @return �y����
   */
  public ACTableColumn getShahukuInfoTablecolumn1(){
    if(shahukuInfoTablecolumn1==null){

      shahukuInfoTablecolumn1 = new ACTableColumn(0, 50);

      shahukuInfoTablecolumn1.setHeaderValue("�y����");

      addShahukuInfoTablecolumn1();
    }
    return shahukuInfoTablecolumn1;

  }

  /**
   * �T�[�r�X��ރR�[�h���擾���܂��B
   * @return �T�[�r�X��ރR�[�h
   */
  public ACTableColumn getShahukuInfoTablecolumn2(){
    if(shahukuInfoTablecolumn2==null){

      shahukuInfoTablecolumn2 = new ACTableColumn(1, 120);

      shahukuInfoTablecolumn2.setHeaderValue("�T�[�r�X��ރR�[�h");

      addShahukuInfoTablecolumn2();
    }
    return shahukuInfoTablecolumn2;

  }

  /**
   * ��̂��ׂ����p�ҕ��S�̑��z���擾���܂��B
   * @return ��̂��ׂ����p�ҕ��S�̑��z
   */
  public ACTableColumn getShahukuInfoTablecolumn3(){
    if(shahukuInfoTablecolumn3==null){

      shahukuInfoTablecolumn3 = new ACTableColumn(2, 180);

      shahukuInfoTablecolumn3.setHeaderValue("��̂��ׂ����p�ҕ��S�̑��z");

      addShahukuInfoTablecolumn3();
    }
    return shahukuInfoTablecolumn3;

  }

  /**
   * �y���z���擾���܂��B
   * @return �y���z
   */
  public ACTableColumn getShahukuInfoTablecolumn4(){
    if(shahukuInfoTablecolumn4==null){

      shahukuInfoTablecolumn4 = new ACTableColumn(3, 50);

      shahukuInfoTablecolumn4.setHeaderValue("�y���z");

      addShahukuInfoTablecolumn4();
    }
    return shahukuInfoTablecolumn4;

  }

  /**
   * �y���㗘�p�ҕ��S�z���擾���܂��B
   * @return �y���㗘�p�ҕ��S�z
   */
  public ACTableColumn getShahukuInfoTablecolumn5(){
    if(shahukuInfoTablecolumn5==null){

      shahukuInfoTablecolumn5 = new ACTableColumn(4, 150);

      shahukuInfoTablecolumn5.setHeaderValue("�y���㗘�p�ҕ��S�z");

      addShahukuInfoTablecolumn5();
    }
    return shahukuInfoTablecolumn5;

  }

  /**
   * ���l���擾���܂��B
   * @return ���l
   */
  public ACTableColumn getShahukuInfoTablecolumn6(){
    if(shahukuInfoTablecolumn6==null){

      shahukuInfoTablecolumn6 = new ACTableColumn(5, 180);

      shahukuInfoTablecolumn6.setHeaderValue("���l");

      addShahukuInfoTablecolumn6();
    }
    return shahukuInfoTablecolumn6;

  }

  /**
   * �Љ���@�l�y���z�ݒ���e�C���p�l�����擾���܂��B
   * @return �Љ���@�l�y���z�ݒ���e�C���p�l��
   */
  public ACPanel getShahukuInfoRevisionPanel(){
    if(shahukuInfoRevisionPanel==null){

      shahukuInfoRevisionPanel = new ACPanel();

      addShahukuInfoRevisionPanel();
    }
    return shahukuInfoRevisionPanel;

  }

  /**
   * �Љ���@�l�y���z�ݒ���e�C�������x�����擾���܂��B
   * @return �Љ���@�l�y���z�ݒ���e�C�������x��
   */
  public ACLabel getShahukuInfoRevisionLabel(){
    if(shahukuInfoRevisionLabel==null){

      shahukuInfoRevisionLabel = new ACLabel();

      shahukuInfoRevisionLabel.setText("�ݒ���e�C����");

      addShahukuInfoRevisionLabel();
    }
    return shahukuInfoRevisionLabel;

  }

  /**
   * �Љ���@�l�y���z�����擾���܂��B
   * @return �Љ���@�l�y���z���
   */
  public ACLabel getShahukuInfoRevision(){
    if(shahukuInfoRevision==null){

      shahukuInfoRevision = new ACLabel();

      shahukuInfoRevision.setText("�Љ���@�l�y�����");

      addShahukuInfoRevision();
    }
    return shahukuInfoRevision;

  }

  /**
   * �S�Ă̏���\�����擾���܂��B
   * @return �S�Ă̏���\��
   */
  public ACIntegerCheckBox getShahukuInfoRevisionCheck(){
    if(shahukuInfoRevisionCheck==null){

      shahukuInfoRevisionCheck = new ACIntegerCheckBox();

      shahukuInfoRevisionCheck.setText("���ׂĂ̏���\���iA�j");

      shahukuInfoRevisionCheck.setMnemonic('A');

      addShahukuInfoRevisionCheck();
    }
    return shahukuInfoRevisionCheck;

  }

  /**
   * �Љ���@�l�y���z���ڍ׃e�[�u�����擾���܂��B
   * @return �Љ���@�l�y���z���ڍ׃e�[�u��
   */
  public ACTable getShahukuInfoRevisionTable(){
    if(shahukuInfoRevisionTable==null){

      shahukuInfoRevisionTable = new ACTable();

      shahukuInfoRevisionTable.setColumnModel(getShahukuInfoRevisionTableColumnModel());

      shahukuInfoRevisionTable.setColumnSort(false);

      addShahukuInfoRevisionTable();
    }
    return shahukuInfoRevisionTable;

  }

  /**
   * �Љ���@�l�y���z���ڍ׃e�[�u���J�������f�����擾���܂��B
   * @return �Љ���@�l�y���z���ڍ׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getShahukuInfoRevisionTableColumnModel(){
    if(shahukuInfoRevisionTableColumnModel==null){
      shahukuInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addShahukuInfoRevisionTableColumnModel();
    }
    return shahukuInfoRevisionTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getShahukuInfoRevisionTablecolumn0(){
    if(shahukuInfoRevisionTablecolumn0==null){

      shahukuInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      shahukuInfoRevisionTablecolumn0.setHeaderValue("�@");

      shahukuInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      shahukuInfoRevisionTablecolumn0.setSortable(false);

      addShahukuInfoRevisionTablecolumn0();
    }
    return shahukuInfoRevisionTablecolumn0;

  }

  /**
   * ���ږ����擾���܂��B
   * @return ���ږ�
   */
  public ACTableColumn getShahukuInfoRevisionTablecolumn1(){
    if(shahukuInfoRevisionTablecolumn1==null){

      shahukuInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      shahukuInfoRevisionTablecolumn1.setHeaderValue("���ږ�");

      shahukuInfoRevisionTablecolumn1.setColumns(15);

      addShahukuInfoRevisionTablecolumn1();
    }
    return shahukuInfoRevisionTablecolumn1;

  }

  /**
   * �ݒ�l���擾���܂��B
   * @return �ݒ�l
   */
  public ACTableColumn getShahukuInfoRevisionTablecolumn2(){
    if(shahukuInfoRevisionTablecolumn2==null){

      shahukuInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      shahukuInfoRevisionTablecolumn2.setHeaderValue("�ݒ�l");

      shahukuInfoRevisionTablecolumn2.setEditable(true);

      shahukuInfoRevisionTablecolumn2.setColumns(8);

      addShahukuInfoRevisionTablecolumn2();
    }
    return shahukuInfoRevisionTablecolumn2;

  }

  /**
   * �R�����g���擾���܂��B
   * @return �R�����g
   */
  public ACTableColumn getShahukuInfoRevisionTablecolumn3(){
    if(shahukuInfoRevisionTablecolumn3==null){

      shahukuInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      shahukuInfoRevisionTablecolumn3.setHeaderValue("�R�����g");

      shahukuInfoRevisionTablecolumn3.setColumns(30);

      addShahukuInfoRevisionTablecolumn3();
    }
    return shahukuInfoRevisionTablecolumn3;

  }

  /**
   * ����×{����̈���擾���܂��B
   * @return ����×{����̈�
   */
  public ACPanel getRecuperationInfos(){
    if(recuperationInfos==null){

      recuperationInfos = new ACPanel();

      addRecuperationInfos();
    }
    return recuperationInfos;

  }

  /**
   * ����×{����p�l�����擾���܂��B
   * @return ����×{����p�l��
   */
  public ACPanel getRecuperationInfoPanel(){
    if(recuperationInfoPanel==null){

      recuperationInfoPanel = new ACPanel();

      addRecuperationInfoPanel();
    }
    return recuperationInfoPanel;

  }

  /**
   * ����×{���񃉃x�����擾���܂��B
   * @return ����×{���񃉃x��
   */
  public ACLabel getRecuperationInfoLabel(){
    if(recuperationInfoLabel==null){

      recuperationInfoLabel = new ACLabel();

      recuperationInfoLabel.setText("���ʗ×{����");

      addRecuperationInfoLabel();
    }
    return recuperationInfoLabel;

  }

  /**
   * ����×{����e�[�u�����擾���܂��B
   * @return ����×{����e�[�u��
   */
  public ACTable getRecuperationInfoTable(){
    if(recuperationInfoTable==null){

      recuperationInfoTable = new ACTable();

      recuperationInfoTable.setColumnModel(getRecuperationInfoTableColumnModel());

      recuperationInfoTable.setColumnSort(false);

      addRecuperationInfoTable();
    }
    return recuperationInfoTable;

  }

  /**
   * ����×{����e�[�u���J�������f�����擾���܂��B
   * @return ����×{����e�[�u���J�������f��
   */
  protected VRTableColumnModel getRecuperationInfoTableColumnModel(){
    if(recuperationInfoTableColumnModel==null){
      recuperationInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addRecuperationInfoTableColumnModel();
    }
    return recuperationInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getRecuperationInfoTablecolumn0(){
    if(recuperationInfoTablecolumn0==null){

      recuperationInfoTablecolumn0 = new ACTableColumn(0, 30);

      recuperationInfoTablecolumn0.setHeaderValue("�@");

      recuperationInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      recuperationInfoTablecolumn0.setSortable(false);

      addRecuperationInfoTablecolumn0();
    }
    return recuperationInfoTablecolumn0;

  }

  /**
   * ���Ə��ԍ����擾���܂��B
   * @return ���Ə��ԍ�
   */
  public ACTableColumn getRecuperationInfoTablecolumn1(){
    if(recuperationInfoTablecolumn1==null){

      recuperationInfoTablecolumn1 = new ACTableColumn(0, 75);

      recuperationInfoTablecolumn1.setHeaderValue("���Ə��ԍ�");

      addRecuperationInfoTablecolumn1();
    }
    return recuperationInfoTablecolumn1;

  }

  /**
   * ���R�[�h�����ԍ����擾���܂��B
   * @return ���R�[�h�����ԍ�
   */
  public ACTableColumn getRecuperationInfoTablecolumn2(){
    if(recuperationInfoTablecolumn2==null){

      recuperationInfoTablecolumn2 = new ACTableColumn(1, 100);

      recuperationInfoTablecolumn2.setHeaderValue("���R�[�h�����ԍ�");

      addRecuperationInfoTablecolumn2();
    }
    return recuperationInfoTablecolumn2;

  }

  /**
   * ���a�����擾���܂��B
   * @return ���a��
   */
  public ACTableColumn getRecuperationInfoTablecolumn3(){
    if(recuperationInfoTablecolumn3==null){

      recuperationInfoTablecolumn3 = new ACTableColumn(2, 100);

      recuperationInfoTablecolumn3.setHeaderValue("���a��");

      addRecuperationInfoTablecolumn3();
    }
    return recuperationInfoTablecolumn3;

  }

  /**
   * ���ʔԍ����擾���܂��B
   * @return ���ʔԍ�
   */
  public ACTableColumn getRecuperationInfoTablecolumn4(){
    if(recuperationInfoTablecolumn4==null){

      recuperationInfoTablecolumn4 = new ACTableColumn(3, 100);

      recuperationInfoTablecolumn4.setHeaderValue("���ʔԍ�");

      addRecuperationInfoTablecolumn4();
    }
    return recuperationInfoTablecolumn4;

  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTableColumn getRecuperationInfoTablecolumn5(){
    if(recuperationInfoTablecolumn5==null){

      recuperationInfoTablecolumn5 = new ACTableColumn(4, 150);

      recuperationInfoTablecolumn5.setHeaderValue("�P�ʐ�");

      addRecuperationInfoTablecolumn5();
    }
    return recuperationInfoTablecolumn5;

  }

  /**
   * �ی��񐔂��擾���܂��B
   * @return �ی���
   */
  public ACTableColumn getRecuperationInfoTablecolumn6(){
    if(recuperationInfoTablecolumn6==null){

      recuperationInfoTablecolumn6 = new ACTableColumn(5, 150);

      recuperationInfoTablecolumn6.setHeaderValue("�ی���");

      addRecuperationInfoTablecolumn6();
    }
    return recuperationInfoTablecolumn6;

  }

  /**
   * �ی��T�[�r�X�P�ʐ����擾���܂��B
   * @return �ی��T�[�r�X�P�ʐ�
   */
  public ACTableColumn getRecuperationInfoTablecolumn7(){
    if(recuperationInfoTablecolumn7==null){

      recuperationInfoTablecolumn7 = new ACTableColumn(6, 150);

      recuperationInfoTablecolumn7.setHeaderValue("�ی��T�[�r�X�P�ʐ�");

      addRecuperationInfoTablecolumn7();
    }
    return recuperationInfoTablecolumn7;

  }

  /**
   * �ی����v�P�ʐ����擾���܂��B
   * @return �ی����v�P�ʐ�
   */
  public ACTableColumn getRecuperationInfoTablecolumn8(){
    if(recuperationInfoTablecolumn8==null){

      recuperationInfoTablecolumn8 = new ACTableColumn(7, 70);

      recuperationInfoTablecolumn8.setHeaderValue("�ی����v�P�ʐ�");

      addRecuperationInfoTablecolumn8();
    }
    return recuperationInfoTablecolumn8;

  }

  /**
   * ����1�񐔂��擾���܂��B
   * @return ����1��
   */
  public ACTableColumn getRecuperationInfoTablecolumn9(){
    if(recuperationInfoTablecolumn9==null){

      recuperationInfoTablecolumn9 = new ACTableColumn(8, 105);

      recuperationInfoTablecolumn9.setHeaderValue("����1��");

      addRecuperationInfoTablecolumn9();
    }
    return recuperationInfoTablecolumn9;

  }

  /**
   * ����2�񐔂��擾���܂��B
   * @return ����2��
   */
  public ACTableColumn getRecuperationInfoTablecolumn10(){
    if(recuperationInfoTablecolumn10==null){

      recuperationInfoTablecolumn10 = new ACTableColumn(9, 70);

      recuperationInfoTablecolumn10.setHeaderValue("����2��");

      addRecuperationInfoTablecolumn10();
    }
    return recuperationInfoTablecolumn10;

  }

  /**
   * ����3�񐔂��擾���܂��B
   * @return ����3��
   */
  public ACTableColumn getRecuperationInfoTablecolumn11(){
    if(recuperationInfoTablecolumn11==null){

      recuperationInfoTablecolumn11 = new ACTableColumn(10, 105);

      recuperationInfoTablecolumn11.setHeaderValue("����3��");

      addRecuperationInfoTablecolumn11();
    }
    return recuperationInfoTablecolumn11;

  }

  /**
   * �E�v���擾���܂��B
   * @return �E�v
   */
  public ACTableColumn getRecuperationInfoTablecolumn12(){
    if(recuperationInfoTablecolumn12==null){

      recuperationInfoTablecolumn12 = new ACTableColumn(11, 140);

      recuperationInfoTablecolumn12.setHeaderValue("�E�v");

      addRecuperationInfoTablecolumn12();
    }
    return recuperationInfoTablecolumn12;

  }

  /**
   * ����×{����ݒ���e�C���p�l�����擾���܂��B
   * @return ����×{����ݒ���e�C���p�l��
   */
  public ACPanel getRecuperationInfoRevisionPanel(){
    if(recuperationInfoRevisionPanel==null){

      recuperationInfoRevisionPanel = new ACPanel();

      addRecuperationInfoRevisionPanel();
    }
    return recuperationInfoRevisionPanel;

  }

  /**
   * ����×{����ݒ���e�C�������x�����擾���܂��B
   * @return ����×{����ݒ���e�C�������x��
   */
  public ACLabel getRecuperationInfoRevisionLabel(){
    if(recuperationInfoRevisionLabel==null){

      recuperationInfoRevisionLabel = new ACLabel();

      recuperationInfoRevisionLabel.setText("�ݒ���e�C����");

      addRecuperationInfoRevisionLabel();
    }
    return recuperationInfoRevisionLabel;

  }

  /**
   * ����×{��������擾���܂��B
   * @return ����×{������
   */
  public ACLabel getRecuperationInfoRevision(){
    if(recuperationInfoRevision==null){

      recuperationInfoRevision = new ACLabel();

      recuperationInfoRevision.setText("���ʗ×{����");

      addRecuperationInfoRevision();
    }
    return recuperationInfoRevision;

  }

  /**
   * �S�Ă̏���\�����擾���܂��B
   * @return �S�Ă̏���\��
   */
  public ACIntegerCheckBox getRecuperationInfoRevisionCheck(){
    if(recuperationInfoRevisionCheck==null){

      recuperationInfoRevisionCheck = new ACIntegerCheckBox();

      recuperationInfoRevisionCheck.setText("���ׂĂ̏���\���iA�j");

      recuperationInfoRevisionCheck.setMnemonic('A');

      addRecuperationInfoRevisionCheck();
    }
    return recuperationInfoRevisionCheck;

  }

  /**
   * ����×{������ڍ׃e�[�u�����擾���܂��B
   * @return ����×{������ڍ׃e�[�u��
   */
  public ACTable getRecuperationInfoRevisionTable(){
    if(recuperationInfoRevisionTable==null){

      recuperationInfoRevisionTable = new ACTable();

      recuperationInfoRevisionTable.setColumnModel(getRecuperationInfoRevisionTableColumnModel());

      recuperationInfoRevisionTable.setColumnSort(false);

      addRecuperationInfoRevisionTable();
    }
    return recuperationInfoRevisionTable;

  }

  /**
   * ����×{������ڍ׃e�[�u���J�������f�����擾���܂��B
   * @return ����×{������ڍ׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getRecuperationInfoRevisionTableColumnModel(){
    if(recuperationInfoRevisionTableColumnModel==null){
      recuperationInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addRecuperationInfoRevisionTableColumnModel();
    }
    return recuperationInfoRevisionTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getRecuperationInfoRevisionTablecolumn0(){
    if(recuperationInfoRevisionTablecolumn0==null){

      recuperationInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      recuperationInfoRevisionTablecolumn0.setHeaderValue("�@");

      recuperationInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      recuperationInfoRevisionTablecolumn0.setSortable(false);

      addRecuperationInfoRevisionTablecolumn0();
    }
    return recuperationInfoRevisionTablecolumn0;

  }

  /**
   * ���ږ����擾���܂��B
   * @return ���ږ�
   */
  public ACTableColumn getRecuperationInfoRevisionTablecolumn1(){
    if(recuperationInfoRevisionTablecolumn1==null){

      recuperationInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      recuperationInfoRevisionTablecolumn1.setHeaderValue("���ږ�");

      recuperationInfoRevisionTablecolumn1.setColumns(15);

      addRecuperationInfoRevisionTablecolumn1();
    }
    return recuperationInfoRevisionTablecolumn1;

  }

  /**
   * �ݒ�l���擾���܂��B
   * @return �ݒ�l
   */
  public ACTableColumn getRecuperationInfoRevisionTablecolumn2(){
    if(recuperationInfoRevisionTablecolumn2==null){

      recuperationInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      recuperationInfoRevisionTablecolumn2.setHeaderValue("�ݒ�l");

      recuperationInfoRevisionTablecolumn2.setEditable(true);

      recuperationInfoRevisionTablecolumn2.setColumns(8);

      addRecuperationInfoRevisionTablecolumn2();
    }
    return recuperationInfoRevisionTablecolumn2;

  }

  /**
   * �R�����g���擾���܂��B
   * @return �R�����g
   */
  public ACTableColumn getRecuperationInfoRevisionTablecolumn3(){
    if(recuperationInfoRevisionTablecolumn3==null){

      recuperationInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      recuperationInfoRevisionTablecolumn3.setHeaderValue("�R�����g");

      recuperationInfoRevisionTablecolumn3.setColumns(30);

      addRecuperationInfoRevisionTablecolumn3();
    }
    return recuperationInfoRevisionTablecolumn3;

  }

  /**
   * ���׏��i�Z���n����j�̈���擾���܂��B
   * @return ���׏��i�Z���n����j�̈�
   */
  public ACPanel getDetailsJushotiTokureiInfos(){
    if(detailsJushotiTokureiInfos==null){

      detailsJushotiTokureiInfos = new ACPanel();

      addDetailsJushotiTokureiInfos();
    }
    return detailsJushotiTokureiInfos;

  }

  /**
   * ���׏��i�Z���n����j�p�l�����擾���܂��B
   * @return ���׏��i�Z���n����j�p�l��
   */
  public ACPanel getDetailsJushotiTokureiPanel(){
    if(detailsJushotiTokureiPanel==null){

      detailsJushotiTokureiPanel = new ACPanel();

      addDetailsJushotiTokureiPanel();
    }
    return detailsJushotiTokureiPanel;

  }

  /**
   * ���׏��i�Z���n����j���x�����擾���܂��B
   * @return ���׏��i�Z���n����j���x��
   */
  public ACLabel getDetailsJushotiTokureiLabel(){
    if(detailsJushotiTokureiLabel==null){

      detailsJushotiTokureiLabel = new ACLabel();

      detailsJushotiTokureiLabel.setText("���׏��i�Z���n����j");

      addDetailsJushotiTokureiLabel();
    }
    return detailsJushotiTokureiLabel;

  }

  /**
   * �T�[�r�X�폜�{�^�����擾���܂��B
   * @return �T�[�r�X�폜�{�^��
   */
  public ACButton getDetailsJushotiTokureiDelButton(){
    if(detailsJushotiTokureiDelButton==null){

      detailsJushotiTokureiDelButton = new ACButton();

      detailsJushotiTokureiDelButton.setText("�T�[�r�X�폜");

      detailsJushotiTokureiDelButton.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addDetailsJushotiTokureiDelButton();
    }
    return detailsJushotiTokureiDelButton;

  }

  /**
   * ���׏��i�Z���n����j�e�[�u�����擾���܂��B
   * @return ���׏��i�Z���n����j�e�[�u��
   */
  public ACTable getDetailsJushotiTokureiInfoTable(){
    if(detailsJushotiTokureiInfoTable==null){

      detailsJushotiTokureiInfoTable = new ACTable();

      detailsJushotiTokureiInfoTable.setColumnModel(getDetailsJushotiTokureiInfoTableColumnModel());

      detailsJushotiTokureiInfoTable.setColumnSort(false);

      addDetailsJushotiTokureiInfoTable();
    }
    return detailsJushotiTokureiInfoTable;

  }

  /**
   * ���׏��i�Z���n����j�e�[�u���J�������f�����擾���܂��B
   * @return ���׏��i�Z���n����j�e�[�u���J�������f��
   */
  protected VRTableColumnModel getDetailsJushotiTokureiInfoTableColumnModel(){
    if(detailsJushotiTokureiInfoTableColumnModel==null){
      detailsJushotiTokureiInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsJushotiTokureiInfoTableColumnModel();
    }
    return detailsJushotiTokureiInfoTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn0(){
    if(detailsJushotiTokureiInfoTablecolumn0==null){

      detailsJushotiTokureiInfoTablecolumn0 = new ACTableColumn(0, 30);

      detailsJushotiTokureiInfoTablecolumn0.setHeaderValue("�@");

      detailsJushotiTokureiInfoTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      detailsJushotiTokureiInfoTablecolumn0.setSortable(false);

      addDetailsJushotiTokureiInfoTablecolumn0();
    }
    return detailsJushotiTokureiInfoTablecolumn0;

  }

  /**
   * �T�[�r�X�R�[�h���擾���܂��B
   * @return �T�[�r�X�R�[�h
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn1(){
    if(detailsJushotiTokureiInfoTablecolumn1==null){

      detailsJushotiTokureiInfoTablecolumn1 = new ACTableColumn(0, 105);

      detailsJushotiTokureiInfoTablecolumn1.setHeaderValue("�T�[�r�X�R�[�h");

      addDetailsJushotiTokureiInfoTablecolumn1();
    }
    return detailsJushotiTokureiInfoTablecolumn1;

  }

  /**
   * �T�[�r�X���̂��擾���܂��B
   * @return �T�[�r�X����
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn2(){
    if(detailsJushotiTokureiInfoTablecolumn2==null){

      detailsJushotiTokureiInfoTablecolumn2 = new ACTableColumn(1, 90);

      detailsJushotiTokureiInfoTablecolumn2.setHeaderValue("�T�[�r�X����");

      addDetailsJushotiTokureiInfoTablecolumn2();
    }
    return detailsJushotiTokureiInfoTablecolumn2;

  }

  /**
   * �P�ʐ����擾���܂��B
   * @return �P�ʐ�
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn3(){
    if(detailsJushotiTokureiInfoTablecolumn3==null){

      detailsJushotiTokureiInfoTablecolumn3 = new ACTableColumn(2, 55);

      detailsJushotiTokureiInfoTablecolumn3.setHeaderValue("�P�ʐ�");

      addDetailsJushotiTokureiInfoTablecolumn3();
    }
    return detailsJushotiTokureiInfoTablecolumn3;

  }

  /**
   * �����E�񐔂��擾���܂��B
   * @return �����E��
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn4(){
    if(detailsJushotiTokureiInfoTablecolumn4==null){

      detailsJushotiTokureiInfoTablecolumn4 = new ACTableColumn(3, 75);

      detailsJushotiTokureiInfoTablecolumn4.setHeaderValue("�����E��");

      addDetailsJushotiTokureiInfoTablecolumn4();
    }
    return detailsJushotiTokureiInfoTablecolumn4;

  }

  /**
   * ����1�Ώۓ����E�񐔂��擾���܂��B
   * @return ����1�Ώۓ����E��
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn5(){
    if(detailsJushotiTokureiInfoTablecolumn5==null){

      detailsJushotiTokureiInfoTablecolumn5 = new ACTableColumn(4, 135);

      detailsJushotiTokureiInfoTablecolumn5.setHeaderValue("����1�Ώۓ����E��");

      addDetailsJushotiTokureiInfoTablecolumn5();
    }
    return detailsJushotiTokureiInfoTablecolumn5;

  }

  /**
   * ����2�Ώۓ����E�񐔂��擾���܂��B
   * @return ����2�Ώۓ����E��
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn6(){
    if(detailsJushotiTokureiInfoTablecolumn6==null){

      detailsJushotiTokureiInfoTablecolumn6 = new ACTableColumn(5, 135);

      detailsJushotiTokureiInfoTablecolumn6.setHeaderValue("����2�Ώۓ����E��");

      addDetailsJushotiTokureiInfoTablecolumn6();
    }
    return detailsJushotiTokureiInfoTablecolumn6;

  }

  /**
   * ����3�Ώۓ����E�񐔂��擾���܂��B
   * @return ����3�Ώۓ����E��
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn7(){
    if(detailsJushotiTokureiInfoTablecolumn7==null){

      detailsJushotiTokureiInfoTablecolumn7 = new ACTableColumn(6, 135);

      detailsJushotiTokureiInfoTablecolumn7.setHeaderValue("����3�Ώۓ����E��");

      addDetailsJushotiTokureiInfoTablecolumn7();
    }
    return detailsJushotiTokureiInfoTablecolumn7;

  }

  /**
   * �T�[�r�X�P�ʐ����擾���܂��B
   * @return �T�[�r�X�P�ʐ�
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn8(){
    if(detailsJushotiTokureiInfoTablecolumn8==null){

      detailsJushotiTokureiInfoTablecolumn8 = new ACTableColumn(7, 105);

      detailsJushotiTokureiInfoTablecolumn8.setHeaderValue("�T�[�r�X�P�ʐ�");

      addDetailsJushotiTokureiInfoTablecolumn8();
    }
    return detailsJushotiTokureiInfoTablecolumn8;

  }

  /**
   * ����1�ΏۃT�[�r�X�P�ʐ����擾���܂��B
   * @return ����1�ΏۃT�[�r�X�P�ʐ�
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn9(){
    if(detailsJushotiTokureiInfoTablecolumn9==null){

      detailsJushotiTokureiInfoTablecolumn9 = new ACTableColumn(8, 165);

      detailsJushotiTokureiInfoTablecolumn9.setHeaderValue("����1�ΏۃT�[�r�X�P�ʐ�");

      addDetailsJushotiTokureiInfoTablecolumn9();
    }
    return detailsJushotiTokureiInfoTablecolumn9;

  }

  /**
   * ����2�ΏۃT�[�r�X�P�ʐ����擾���܂��B
   * @return ����2�ΏۃT�[�r�X�P�ʐ�
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn10(){
    if(detailsJushotiTokureiInfoTablecolumn10==null){

      detailsJushotiTokureiInfoTablecolumn10 = new ACTableColumn(9, 165);

      detailsJushotiTokureiInfoTablecolumn10.setHeaderValue("����2�ΏۃT�[�r�X�P�ʐ�");

      addDetailsJushotiTokureiInfoTablecolumn10();
    }
    return detailsJushotiTokureiInfoTablecolumn10;

  }

  /**
   * ����3�ΏۃT�[�r�X�P�ʐ����擾���܂��B
   * @return ����3�ΏۃT�[�r�X�P�ʐ�
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn11(){
    if(detailsJushotiTokureiInfoTablecolumn11==null){

      detailsJushotiTokureiInfoTablecolumn11 = new ACTableColumn(10, 165);

      detailsJushotiTokureiInfoTablecolumn11.setHeaderValue("����3�ΏۃT�[�r�X�P�ʐ�");

      addDetailsJushotiTokureiInfoTablecolumn11();
    }
    return detailsJushotiTokureiInfoTablecolumn11;

  }

  /**
   * �{�ݏ��ݕی��Ҕԍ����擾���܂��B
   * @return �{�ݏ��ݕی��Ҕԍ�
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn12(){
    if(detailsJushotiTokureiInfoTablecolumn12==null){

      detailsJushotiTokureiInfoTablecolumn12 = new ACTableColumn(11, 135);

      detailsJushotiTokureiInfoTablecolumn12.setHeaderValue("�{�ݏ��ݕی��Ҕԍ�");

      addDetailsJushotiTokureiInfoTablecolumn12();
    }
    return detailsJushotiTokureiInfoTablecolumn12;

  }

  /**
   * �E�v(�p��)���擾���܂��B
   * @return �E�v(�p��)
   */
  public ACTableColumn getDetailsJushotiTokureiInfoTablecolumn13(){
    if(detailsJushotiTokureiInfoTablecolumn13==null){

      detailsJushotiTokureiInfoTablecolumn13 = new ACTableColumn(12, 105);

      detailsJushotiTokureiInfoTablecolumn13.setHeaderValue("�E�v(�p��)");

      addDetailsJushotiTokureiInfoTablecolumn13();
    }
    return detailsJushotiTokureiInfoTablecolumn13;

  }

  /**
   * ���אݒ���e�C���p�l�����擾���܂��B
   * @return ���אݒ���e�C���p�l��
   */
  public ACPanel getDetailsJushotiTokureiInfoRevisionPanel(){
    if(detailsJushotiTokureiInfoRevisionPanel==null){

      detailsJushotiTokureiInfoRevisionPanel = new ACPanel();

      addDetailsJushotiTokureiInfoRevisionPanel();
    }
    return detailsJushotiTokureiInfoRevisionPanel;

  }

  /**
   * �ݒ���e�C�������x�����擾���܂��B
   * @return �ݒ���e�C�������x��
   */
  public ACLabel getDetailsJushotiTokureiInfoRevisionLabel(){
    if(detailsJushotiTokureiInfoRevisionLabel==null){

      detailsJushotiTokureiInfoRevisionLabel = new ACLabel();

      detailsJushotiTokureiInfoRevisionLabel.setText("�ݒ���e�C����");

      addDetailsJushotiTokureiInfoRevisionLabel();
    }
    return detailsJushotiTokureiInfoRevisionLabel;

  }

  /**
   * ���׏��i�Z���n����j���擾���܂��B
   * @return ���׏��i�Z���n����j
   */
  public ACLabel getDetailsJushotiTokureiInfoRevision(){
    if(detailsJushotiTokureiInfoRevision==null){

      detailsJushotiTokureiInfoRevision = new ACLabel();

      detailsJushotiTokureiInfoRevision.setText("���׏��i�Z���n����j");

      addDetailsJushotiTokureiInfoRevision();
    }
    return detailsJushotiTokureiInfoRevision;

  }

  /**
   * �S�Ă̏���\�����擾���܂��B
   * @return �S�Ă̏���\��
   */
  public ACIntegerCheckBox getDetailsJushotiTokureiInfoRevisionCheck(){
    if(detailsJushotiTokureiInfoRevisionCheck==null){

      detailsJushotiTokureiInfoRevisionCheck = new ACIntegerCheckBox();

      detailsJushotiTokureiInfoRevisionCheck.setText("���ׂĂ̏���\���iA�j");

      detailsJushotiTokureiInfoRevisionCheck.setMnemonic('A');

      addDetailsJushotiTokureiInfoRevisionCheck();
    }
    return detailsJushotiTokureiInfoRevisionCheck;

  }

  /**
   * ���׏��ڍ׃e�[�u�����擾���܂��B
   * @return ���׏��ڍ׃e�[�u��
   */
  public ACTable getDetailsJushotiTokureiInfoRevisionTable(){
    if(detailsJushotiTokureiInfoRevisionTable==null){

      detailsJushotiTokureiInfoRevisionTable = new ACTable();

      detailsJushotiTokureiInfoRevisionTable.setColumnModel(getDetailsJushotiTokureiInfoRevisionTableColumnModel());

      detailsJushotiTokureiInfoRevisionTable.setColumnSort(false);

      addDetailsJushotiTokureiInfoRevisionTable();
    }
    return detailsJushotiTokureiInfoRevisionTable;

  }

  /**
   * ���׏��ڍ׃e�[�u���J�������f�����擾���܂��B
   * @return ���׏��ڍ׃e�[�u���J�������f��
   */
  protected VRTableColumnModel getDetailsJushotiTokureiInfoRevisionTableColumnModel(){
    if(detailsJushotiTokureiInfoRevisionTableColumnModel==null){
      detailsJushotiTokureiInfoRevisionTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsJushotiTokureiInfoRevisionTableColumnModel();
    }
    return detailsJushotiTokureiInfoRevisionTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getDetailsJushotiTokureiInfoRevisionTablecolumn0(){
    if(detailsJushotiTokureiInfoRevisionTablecolumn0==null){

      detailsJushotiTokureiInfoRevisionTablecolumn0 = new ACTableColumn(0, 30);

      detailsJushotiTokureiInfoRevisionTablecolumn0.setHeaderValue("�@");

      detailsJushotiTokureiInfoRevisionTablecolumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      detailsJushotiTokureiInfoRevisionTablecolumn0.setSortable(false);

      addDetailsJushotiTokureiInfoRevisionTablecolumn0();
    }
    return detailsJushotiTokureiInfoRevisionTablecolumn0;

  }

  /**
   * ���ږ����擾���܂��B
   * @return ���ږ�
   */
  public ACTableColumn getDetailsJushotiTokureiInfoRevisionTablecolumn1(){
    if(detailsJushotiTokureiInfoRevisionTablecolumn1==null){

      detailsJushotiTokureiInfoRevisionTablecolumn1 = new ACTableColumn(0, 55);

      detailsJushotiTokureiInfoRevisionTablecolumn1.setHeaderValue("���ږ�");

      detailsJushotiTokureiInfoRevisionTablecolumn1.setColumns(15);

      addDetailsJushotiTokureiInfoRevisionTablecolumn1();
    }
    return detailsJushotiTokureiInfoRevisionTablecolumn1;

  }

  /**
   * �ݒ�l���擾���܂��B
   * @return �ݒ�l
   */
  public ACTableColumn getDetailsJushotiTokureiInfoRevisionTablecolumn2(){
    if(detailsJushotiTokureiInfoRevisionTablecolumn2==null){

      detailsJushotiTokureiInfoRevisionTablecolumn2 = new ACTableColumn(1, 55);

      detailsJushotiTokureiInfoRevisionTablecolumn2.setHeaderValue("�ݒ�l");

      detailsJushotiTokureiInfoRevisionTablecolumn2.setEditable(true);

      detailsJushotiTokureiInfoRevisionTablecolumn2.setColumns(8);

      addDetailsJushotiTokureiInfoRevisionTablecolumn2();
    }
    return detailsJushotiTokureiInfoRevisionTablecolumn2;

  }

  /**
   * �R�����g���擾���܂��B
   * @return �R�����g
   */
  public ACTableColumn getDetailsJushotiTokureiInfoRevisionTablecolumn3(){
    if(detailsJushotiTokureiInfoRevisionTablecolumn3==null){

      detailsJushotiTokureiInfoRevisionTablecolumn3 = new ACTableColumn(2, 55);

      detailsJushotiTokureiInfoRevisionTablecolumn3.setHeaderValue("�R�����g");

      detailsJushotiTokureiInfoRevisionTablecolumn3.setColumns(30);

      addDetailsJushotiTokureiInfoRevisionTablecolumn3();
    }
    return detailsJushotiTokureiInfoRevisionTablecolumn3;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP005Design() {

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

    this.add(getContens(), VRLayout.CLIENT);

  }

  /**
   * �Ɩ��{�^���o�[�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getRenewal(), VRLayout.EAST);
    buttons.add(getRetotal(), VRLayout.EAST);
  }

  /**
   * �ďW�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRetotal(){

  }

  /**
   * �X�V�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRenewal(){

  }

  /**
   * �N���C�A���g�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addContens(){

    contens.add(getCommonInfoPanle(), VRLayout.NORTH);

    contens.add(getEtcInfoTabs(), VRLayout.CLIENT);

  }

  /**
   * ���ʗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCommonInfoPanle(){

    commonInfoPanle.add(getCommonInfos(), VRLayout.WEST);

  }

  /**
   * ���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCommonInfos(){

    commonInfos.add(getCommonInfoPattern(), VRLayout.FLOW_RETURN);

    commonInfos.add(getCommonInfoProvider(), VRLayout.FLOW_RETURN);

    commonInfos.add(getCommonInfoDate(), VRLayout.FLOW);

    commonInfos.add(getCommmonInfoName(), VRLayout.FLOW_RETURN);

    commonInfos.add(getCommonInfoPublicExpenseLabelAll(), VRLayout.FLOW);

    commonInfos.add(getCommonInfoPublicExpenseText(), VRLayout.FLOW);

  }

  /**
   * �l���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCommonInfoPattern(){

  }

  /**
   * ���Ǝ҃e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCommonInfoProvider(){

  }

  /**
   * �����e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCommonInfoDate(){

  }

  /**
   * ���O�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCommmonInfoName(){

  }

  /**
   * �Y������ꗗ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCommonInfoPublicExpenseLabelAll(){

  }

  /**
   * �Y������E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCommonInfoPublicExpenseText(){

  }

  /**
   * ��ޕʃ^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEtcInfoTabs(){

    etcInfoTabs.addTab("��{���", getBasicInfos());

    etcInfoTabs.addTab("���׏��", getDetailsInfos());

    etcInfoTabs.addTab("���莡�ÁE����f�Ï��", getParticularInfos());

    etcInfoTabs.addTab("�W�v���", getTotalInfos());

    etcInfoTabs.addTab("��������҉�����", getNyushoInfos());

    etcInfoTabs.addTab("�Љ���@�l�y�����", getShahukuInfos());

    etcInfoTabs.addTab("���ʗ×{����", getRecuperationInfos());

    etcInfoTabs.addTab("���׏��i�Z���n����j", getDetailsJushotiTokureiInfos());

  }

  /**
   * ��{���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfos(){

    basicInfos.add(getBasicInfo(), VRLayout.NORTH);

    basicInfos.add(getBasicInfoTable(), VRLayout.NORTH);

    basicInfos.add(getBasicInfoRevisionPanel(), VRLayout.NORTH);

    basicInfos.add(getBasicInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * ��{���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfo(){

    basicInfo.add(getBasicInfoLabel(), VRLayout.FLOW);

  }

  /**
   * ��{��񃉃x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoLabel(){

  }

  /**
   * ��{���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTable(){

  }

  /**
   * ��{���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTableColumnModel(){

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn0());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn1());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn2());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn3());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn4());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn5());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn6());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn7());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn8());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn9());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn10());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn11());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn12());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn13());

    getBasicInfoTableColumnModel().addColumn(getBasicInfoTablecolumn14());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn0(){

  }

  /**
   * �ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn1(){

  }

  /**
   * ��ی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn2(){

  }

  /**
   * �v����ԋ敪�R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn3(){

  }

  /**
   * �F��L�����ԊJ�n�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn4(){

  }

  /**
   * �F��L�����ԏI���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn5(){

  }

  /**
   * ����T�[�r�X�v��Ҏ��Ə��ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn6(){

  }

  /**
   * ����T�[�r�X�v��Ҏ��Ə����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn7(){

  }

  /**
   * �J�n�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn8(){

  }

  /**
   * ���~�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn9(){

  }

  /**
   * ���~���R�R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn10(){

  }

  /**
   * ����(�@)�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn11(){

  }

  /**
   * �ޏ�(�@)�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn12(){

  }

  /**
   * ����(�@)�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn13(){

  }

  /**
   * �叝�a�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoTablecolumn14(){

  }

  /**
   * ��{�ݒ���e�C���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoRevisionPanel(){

    basicInfoRevisionPanel.add(getBasicInfoRevisionLabel(), VRLayout.FLOW);

    basicInfoRevisionPanel.add(getBasicInfoRevisionLabel2(), VRLayout.FLOW);

    basicInfoRevisionPanel.add(getBasicInfoRevisionCheck(), VRLayout.FLOW);

  }

  /**
   * �ݒ���e�C�������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoRevisionLabel(){

  }

  /**
   * ��{���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoRevisionLabel2(){

  }

  /**
   * �S�Ă̏���\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoRevisionCheck(){

  }

  /**
   * ��{���ڍ׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoRevisionTable(){

  }

  /**
   * ��{���ڍ׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoRevisionTableColumnModel(){

    getBasicInfoRevisionTableColumnModel().addColumn(getBasicInfoRevisionTablecolumn0());

    getBasicInfoRevisionTableColumnModel().addColumn(getBasicInfoRevisionTablecolumn1());

    getBasicInfoRevisionTableColumnModel().addColumn(getBasicInfoRevisionTablecolumn2());

    getBasicInfoRevisionTableColumnModel().addColumn(getBasicInfoRevisionTablecolumn3());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoRevisionTablecolumn0(){

  }

  /**
   * ���ږ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoRevisionTablecolumn1(){

  }

  /**
   * �ݒ�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoRevisionTablecolumn2(){

  }

  /**
   * �R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBasicInfoRevisionTablecolumn3(){

  }

  /**
   * ���׏��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfos(){

    detailsInfos.add(getDetailsInfoPanel(), VRLayout.NORTH);

    detailsInfos.add(getDetailsInfoTable(), VRLayout.NORTH);

    detailsInfos.add(getKyotakuDetailsInfoTable(), VRLayout.NORTH);

    detailsInfos.add(getDetailsInfoRevisionPanel(), VRLayout.NORTH);

    detailsInfos.add(getDetailsInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * ���׏��p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoPanel(){

    detailsInfoPanel.add(getDetailsInfoLabel(), VRLayout.FLOW);

    detailsInfoPanel.add(getDetailsDelButton(), VRLayout.EAST);
  }

  /**
   * ���׏�񃉃x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoLabel(){

  }

  /**
   * �T�[�r�X�폜�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsDelButton(){

  }

  /**
   * ���׏��e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTable(){

  }

  /**
   * ���׏��e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTableColumnModel(){

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn0());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn1());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn2());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn3());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn4());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn5());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn6());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn7());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn8());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn9());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn10());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn11());

    getDetailsInfoTableColumnModel().addColumn(getDetailsInfoTablecolumn12());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn0(){

  }

  /**
   * �T�[�r�X�R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn1(){

  }

  /**
   * �T�[�r�X���̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn2(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn3(){

  }

  /**
   * �����E�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn4(){

  }

  /**
   * ����1�Ώۓ����E�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn5(){

  }

  /**
   * ����2�Ώۓ����E�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn6(){

  }

  /**
   * ����3�Ώۓ����E�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn7(){

  }

  /**
   * �T�[�r�X�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn8(){

  }

  /**
   * ����1�ΏۃT�[�r�X�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn9(){

  }

  /**
   * ����2�ΏۃT�[�r�X�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn10(){

  }

  /**
   * ����3�ΏۃT�[�r�X�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn11(){

  }

  /**
   * �E�v(�p��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoTablecolumn12(){

  }

  /**
   * ������x�����׏��e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTable(){

  }

  /**
   * ������x�����׏��e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTableColumnModel(){

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn0());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn1());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn2());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn3());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn4());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn5());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn6());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn7());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn8());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn9());

    getKyotakuDetailsInfoTableColumnModel().addColumn(getKyotakuDetailsInfoTablecolumn10());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn0(){

  }

  /**
   * ���N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn1(){

  }

  /**
   * ���ʃR�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn2(){

  }

  /**
   * �v����ԋ敪�R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn3(){

  }

  /**
   * �F��L�����ԊJ�n���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn4(){

  }

  /**
   * �F��L�����ԏI�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn5(){

  }

  /**
   * ����T�[�r�X�v��쐬�˗��͏o�N�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn6(){

  }

  /**
   * �T�[�r�X�R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn7(){

  }

  /**
   * �T�[�r�X���̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn8(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn9(){

  }

  /**
   * �������z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyotakuDetailsInfoTablecolumn10(){

  }

  /**
   * ���אݒ���e�C���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoRevisionPanel(){

    detailsInfoRevisionPanel.add(getDetailsInfoRevisionLabel(), VRLayout.FLOW);

    detailsInfoRevisionPanel.add(getDetailsInfoRevision(), VRLayout.FLOW);

    detailsInfoRevisionPanel.add(getDetailsInfoRevisionCheck(), VRLayout.FLOW);

  }

  /**
   * �ݒ���e�C�������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoRevisionLabel(){

  }

  /**
   * ���׏��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoRevision(){

  }

  /**
   * �S�Ă̏���\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoRevisionCheck(){

  }

  /**
   * ���׏��ڍ׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoRevisionTable(){

  }

  /**
   * ���׏��ڍ׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoRevisionTableColumnModel(){

    getDetailsInfoRevisionTableColumnModel().addColumn(getDetailsInfoRevisionTablecolumn0());

    getDetailsInfoRevisionTableColumnModel().addColumn(getDetailsInfoRevisionTablecolumn1());

    getDetailsInfoRevisionTableColumnModel().addColumn(getDetailsInfoRevisionTablecolumn2());

    getDetailsInfoRevisionTableColumnModel().addColumn(getDetailsInfoRevisionTablecolumn3());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoRevisionTablecolumn0(){

  }

  /**
   * ���ږ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoRevisionTablecolumn1(){

  }

  /**
   * �ݒ�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoRevisionTablecolumn2(){

  }

  /**
   * �R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsInfoRevisionTablecolumn3(){

  }

  /**
   * ���莡�ÁE����f�Ï��̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfos(){

    particularInfos.add(getParticularInfoPanel(), VRLayout.NORTH);

    particularInfos.add(getParticularInfoTable(), VRLayout.NORTH);

    particularInfos.add(getSpecialClinicInfoTable(), VRLayout.NORTH);

    particularInfos.add(getParticularInfoRevisionPanel(), VRLayout.NORTH);

    particularInfos.add(getParticularInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * ���莡�Ô���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoPanel(){

    particularInfoPanel.add(getParticularInfoLabel(), VRLayout.FLOW);

  }

  /**
   * ���莡�Ô��񃉃x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoLabel(){

  }

  /**
   * ���莡�Ô���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTable(){

  }

  /**
   * ���莡�Ô���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTableColumnModel(){

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn0());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn1());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn2());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn3());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn4());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn5());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn6());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn7());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn8());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn9());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn10());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn11());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn12());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn13());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn14());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn15());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn16());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn17());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn18());

    getParticularInfoTableColumnModel().addColumn(getParticularInfoTablecolumn19());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn0(){

  }

  /**
   * ���Ə��ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn1(){

  }

  /**
   * �ً}�����a��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn2(){

  }

  /**
   * �ً}�����a��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn3(){

  }

  /**
   * �ً}�����a��3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn4(){

  }

  /**
   * �ً}�����ÊJ�n�N����1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn5(){

  }

  /**
   * �ً}�����ÊJ�n�N����2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn6(){

  }

  /**
   * �ً}�����ÊJ�n�N����3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn7(){

  }

  /**
   * ���f�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn8(){

  }

  /**
   * ���f��Ë@�֖��ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn9(){

  }

  /**
   * �ʉ@�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn10(){

  }

  /**
   * �ʉ@��Ë@�֖��ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn11(){

  }

  /**
   * �ً}�����ÊǗ��P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn12(){

  }

  /**
   * �ً}�����ÊǗ������ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn13(){

  }

  /**
   * �ً}�����ÊǗ����v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn14(){

  }

  /**
   * ���n�r���e�[�V�����_���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn15(){

  }

  /**
   * ���u�_���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn16(){

  }

  /**
   * ��p�_���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn17(){

  }

  /**
   * �����_���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn18(){

  }

  /**
   * ���ː����Ó_���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoTablecolumn19(){

  }

  /**
   * ����f�Ô���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTable(){

  }

  /**
   * ����f�Ô���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTableColumnModel(){

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn0());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn1());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn2());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn3());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn4());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn5());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn6());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn7());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn8());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn9());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn10());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn11());

    getSpecialClinicInfoTableColumnModel().addColumn(getSpecialClinicInfoTablecolumn12());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn0(){

  }

  /**
   * ���Ə��ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn1(){

  }

  /**
   * ���R�[�h�����ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn2(){

  }

  /**
   * ���a���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn3(){

  }

  /**
   * ���ʔԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn4(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn5(){

  }

  /**
   * �ی��񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn6(){

  }

  /**
   * �ی��T�[�r�X�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn7(){

  }

  /**
   * �ی����v�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn8(){

  }

  /**
   * ����1�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn9(){

  }

  /**
   * ����2�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn10(){

  }

  /**
   * ����3�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn11(){

  }

  /**
   * �E�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSpecialClinicInfoTablecolumn12(){

  }

  /**
   * ���莡�Ô�E����f�Ô�ݒ���e�C���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoRevisionPanel(){

    particularInfoRevisionPanel.add(getParticularInfoRevisionLabel(), null);

    particularInfoRevisionPanel.add(getParticularInfoRevision(), null);

    particularInfoRevisionPanel.add(getParticularInfoRevisionCheck(), null);

  }

  /**
   * ���莡�Ô�E����f�Ô�ݒ���e�C�������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoRevisionLabel(){

  }

  /**
   * ���莡�Ô�E����f�Ô���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoRevision(){

  }

  /**
   * �S�Ă̏���\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoRevisionCheck(){

  }

  /**
   * ���莡�Ô�E����f�Ô���ڍ׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoRevisionTable(){

  }

  /**
   * ���莡�Ô�E����f�Ô���ڍ׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoRevisionTableColumnModel(){

    getParticularInfoRevisionTableColumnModel().addColumn(getParticularInfoRevisionTablecolumn0());

    getParticularInfoRevisionTableColumnModel().addColumn(getParticularInfoRevisionTablecolumn1());

    getParticularInfoRevisionTableColumnModel().addColumn(getParticularInfoRevisionTablecolumn2());

    getParticularInfoRevisionTableColumnModel().addColumn(getParticularInfoRevisionTablecolumn3());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoRevisionTablecolumn0(){

  }

  /**
   * ���ږ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoRevisionTablecolumn1(){

  }

  /**
   * �ݒ�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoRevisionTablecolumn2(){

  }

  /**
   * �R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addParticularInfoRevisionTablecolumn3(){

  }

  /**
   * �W�v���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfos(){

    totalInfos.add(getTotalInfoPanel(), VRLayout.NORTH);

    totalInfos.add(getTotalInfoTable(), VRLayout.NORTH);

    totalInfos.add(getTotalInfoRevisionPanel(), VRLayout.NORTH);

    totalInfos.add(getTotalInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * �W�v���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoPanel(){

    totalInfoPanel.add(getTotalInfoLabel(), VRLayout.FLOW);

  }

  /**
   * �W�v��񃉃x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoLabel(){

  }

  /**
   * �W�v���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTable(){

  }

  /**
   * �W�v���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTableColumnModel(){

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn0());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn1());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn2());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn3());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn4());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn5());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn6());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn7());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn8());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn9());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn10());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn11());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn12());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn13());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn14());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn15());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn16());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn17());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn18());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn19());

    getTotalInfoTableColumnModel().addColumn(getTotalInfoTablecolumn20());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn0(){

  }

  /**
   * �T�[�r�X��ރR�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn1(){

  }

  /**
   * �T�[�r�X�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn2(){

  }

  /**
   * �v��P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn3(){

  }

  /**
   * ���x�z�Ǘ��ΏےP�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn4(){

  }

  /**
   * ���x�z�Ǘ��ΏۊO�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn5(){

  }

  /**
   * �Z�������v������ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn6(){

  }

  /**
   * �Z�������������ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn7(){

  }

  /**
   * �ی��P�ʐ����v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn8(){

  }

  /**
   * �ی��P�ʐ��P���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn9(){

  }

  /**
   * �ی������z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn10(){

  }

  /**
   * �ی����p�ҕ��S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn11(){

  }

  /**
   * ����1�����z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn12(){

  }

  /**
   * ����1�{�l���S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn13(){

  }

  /**
   * ����2�����z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn14(){

  }

  /**
   * ����2�{�l���S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn15(){

  }

  /**
   * ����3�����z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn16(){

  }

  /**
   * ����3�{�l���S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn17(){

  }

  /**
   * �ی����o������Ô�P�ʐ����v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn18(){

  }

  /**
   * �ی����o������Ô���z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn19(){

  }

  /**
   * �ی����o������Ô�p�ҕ��S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoTablecolumn20(){

  }

  /**
   * �W�v���ݒ���e�C���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoRevisionPanel(){

    totalInfoRevisionPanel.add(getTotalInfoRevisionLabel(), null);

    totalInfoRevisionPanel.add(getTotalInfoRevision(), null);

    totalInfoRevisionPanel.add(getTotalInfoRevisionCheck(), null);

  }

  /**
   * �W�v�ݒ���e�C�������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoRevisionLabel(){

  }

  /**
   * �W�v���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoRevision(){

  }

  /**
   * �S�Ă̏���\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoRevisionCheck(){

  }

  /**
   * �W�v���ڍ׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoRevisionTable(){

  }

  /**
   * �W�v���ڍ׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoRevisionTableColumnModel(){

    getTotalInfoRevisionTableColumnModel().addColumn(getTotalInfoRevisionTablecolumn0());

    getTotalInfoRevisionTableColumnModel().addColumn(getTotalInfoRevisionTablecolumn1());

    getTotalInfoRevisionTableColumnModel().addColumn(getTotalInfoRevisionTablecolumn2());

    getTotalInfoRevisionTableColumnModel().addColumn(getTotalInfoRevisionTablecolumn3());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoRevisionTablecolumn0(){

  }

  /**
   * ���ږ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoRevisionTablecolumn1(){

  }

  /**
   * �ݒ�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoRevisionTablecolumn2(){

  }

  /**
   * �R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTotalInfoRevisionTablecolumn3(){

  }

  /**
   * ��������҉�����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfos(){

    nyushoInfos.add(getNyushoInfoPanel(), VRLayout.NORTH);

    nyushoInfos.add(getNyushoInfoTable(), VRLayout.NORTH);

    nyushoInfos.add(getNyushoInfoRevisionPanel(), VRLayout.NORTH);

    nyushoInfos.add(getNyushoInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * ��������҉�����p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoPanel(){

    nyushoInfoPanel.add(getNyushoInfoLabel(), VRLayout.FLOW);

    nyushoInfoPanel.add(getServiceDelButton(), VRLayout.EAST);
    nyushoInfoPanel.add(getServiceAddButton(), VRLayout.EAST);
  }

  /**
   * ��������҉����񃉃x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoLabel(){

  }

  /**
   * �T�[�r�X�ǉ��{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddButton(){

  }

  /**
   * �T�[�r�X�폜�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceDelButton(){

  }

  /**
   * ��������҉�����e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTable(){

  }

  /**
   * ��������҉�����e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTableColumnModel(){

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn0());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn1());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn2());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn3());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn4());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn5());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn6());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn7());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn8());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn9());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn10());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn11());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn12());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn13());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn14());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn15());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn16());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn17());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn18());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn19());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn20());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn21());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn22());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn23());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn24());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn25());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn26());

    getNyushoInfoTableColumnModel().addColumn(getNyushoInfoTablecolumn27());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn0(){

  }

  /**
   * ���R�[�h���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn1(){

  }

  /**
   * �T�[�r�X�R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn2(){

  }

  /**
   * �T�[�r�X���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn3(){

  }

  /**
   * ��p�P���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn4(){

  }

  /**
   * ���S���x�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn5(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn6(){

  }

  /**
   * ����1�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn7(){

  }

  /**
   * ����2�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn8(){

  }

  /**
   * ����3�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn9(){

  }

  /**
   * ��p�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn10(){

  }

  /**
   * �ی��������z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn11(){

  }

  /**
   * ����1���S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn12(){

  }

  /**
   * ����2���S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn13(){

  }

  /**
   * ����3���S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn14(){

  }

  /**
   * ���p�ҕ��S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn15(){

  }

  /**
   * ��p�z���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn16(){

  }

  /**
   * �ی��������z���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn17(){

  }

  /**
   * ���p�ҕ��S�z���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn18(){

  }

  /**
   * ����1���S�z���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn19(){

  }

  /**
   * ����1�����z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn20(){

  }

  /**
   * ����1�{�l���S���z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn21(){

  }

  /**
   * ����2���S�z���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn22(){

  }

  /**
   * ����2�����z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn23(){

  }

  /**
   * ����2�{�l���S���z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn24(){

  }

  /**
   * ����3���S�z���v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn25(){

  }

  /**
   * ����3�����z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn26(){

  }

  /**
   * ����3�{�l���S���z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoTablecolumn27(){

  }

  /**
   * ��������҉���ݒ���e�C���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoRevisionPanel(){

    nyushoInfoRevisionPanel.add(getNyushoInfoRevisionLabel(), null);

    nyushoInfoRevisionPanel.add(getNyushoInfoRevision(), null);

    nyushoInfoRevisionPanel.add(getNyushoInfoRevisionCheck(), null);

  }

  /**
   * ��������҉���ݒ���e�C�������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoRevisionLabel(){

  }

  /**
   * ��������҉�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoRevision(){

  }

  /**
   * �S�Ă̏���\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoRevisionCheck(){

  }

  /**
   * ��������҉�����ڍ׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoRevisionTable(){

  }

  /**
   * ��������҉�����ڍ׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoRevisionTableColumnModel(){

    getNyushoInfoRevisionTableColumnModel().addColumn(getNyushoInfoRevisionTablecolumn0());

    getNyushoInfoRevisionTableColumnModel().addColumn(getNyushoInfoRevisionTablecolumn1());

    getNyushoInfoRevisionTableColumnModel().addColumn(getNyushoInfoRevisionTablecolumn2());

    getNyushoInfoRevisionTableColumnModel().addColumn(getNyushoInfoRevisionTablecolumn3());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoRevisionTablecolumn0(){

  }

  /**
   * ���ږ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoRevisionTablecolumn1(){

  }

  /**
   * �ݒ�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoRevisionTablecolumn2(){

  }

  /**
   * �R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNyushoInfoRevisionTablecolumn3(){

  }

  /**
   * �Љ���@�l�y���z���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfos(){

    shahukuInfos.add(getShahukuInfoPanel(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoTable(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoRevisionPanel(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * �Љ���@�l�y���z���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoPanel(){

    shahukuInfoPanel.add(getShahukuInfoLabel(), VRLayout.FLOW);

  }

  /**
   * �Љ���@�l�y���z��񃉃x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoLabel(){

  }

  /**
   * �Љ���@�l�y���z���e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTable(){

  }

  /**
   * �Љ���@�l�y���z���e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTableColumnModel(){

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn0());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn1());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn2());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn3());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn4());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn5());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTablecolumn6());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTablecolumn0(){

  }

  /**
   * �y�����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTablecolumn1(){

  }

  /**
   * �T�[�r�X��ރR�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTablecolumn2(){

  }

  /**
   * ��̂��ׂ����p�ҕ��S�̑��z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTablecolumn3(){

  }

  /**
   * �y���z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTablecolumn4(){

  }

  /**
   * �y���㗘�p�ҕ��S�z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTablecolumn5(){

  }

  /**
   * ���l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoTablecolumn6(){

  }

  /**
   * �Љ���@�l�y���z�ݒ���e�C���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoRevisionPanel(){

    shahukuInfoRevisionPanel.add(getShahukuInfoRevisionLabel(), null);

    shahukuInfoRevisionPanel.add(getShahukuInfoRevision(), null);

    shahukuInfoRevisionPanel.add(getShahukuInfoRevisionCheck(), null);

  }

  /**
   * �Љ���@�l�y���z�ݒ���e�C�������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoRevisionLabel(){

  }

  /**
   * �Љ���@�l�y���z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoRevision(){

  }

  /**
   * �S�Ă̏���\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoRevisionCheck(){

  }

  /**
   * �Љ���@�l�y���z���ڍ׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoRevisionTable(){

  }

  /**
   * �Љ���@�l�y���z���ڍ׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoRevisionTableColumnModel(){

    getShahukuInfoRevisionTableColumnModel().addColumn(getShahukuInfoRevisionTablecolumn0());

    getShahukuInfoRevisionTableColumnModel().addColumn(getShahukuInfoRevisionTablecolumn1());

    getShahukuInfoRevisionTableColumnModel().addColumn(getShahukuInfoRevisionTablecolumn2());

    getShahukuInfoRevisionTableColumnModel().addColumn(getShahukuInfoRevisionTablecolumn3());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoRevisionTablecolumn0(){

  }

  /**
   * ���ږ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoRevisionTablecolumn1(){

  }

  /**
   * �ݒ�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoRevisionTablecolumn2(){

  }

  /**
   * �R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuInfoRevisionTablecolumn3(){

  }

  /**
   * ����×{����̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfos(){

    recuperationInfos.add(getRecuperationInfoPanel(), VRLayout.NORTH);

    recuperationInfos.add(getRecuperationInfoTable(), VRLayout.NORTH);

    recuperationInfos.add(getRecuperationInfoRevisionPanel(), VRLayout.NORTH);

    recuperationInfos.add(getRecuperationInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * ����×{����p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoPanel(){

    recuperationInfoPanel.add(getRecuperationInfoLabel(), VRLayout.FLOW);

  }

  /**
   * ����×{���񃉃x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoLabel(){

  }

  /**
   * ����×{����e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTable(){

  }

  /**
   * ����×{����e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTableColumnModel(){

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn0());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn1());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn2());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn3());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn4());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn5());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn6());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn7());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn8());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn9());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn10());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn11());

    getRecuperationInfoTableColumnModel().addColumn(getRecuperationInfoTablecolumn12());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn0(){

  }

  /**
   * ���Ə��ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn1(){

  }

  /**
   * ���R�[�h�����ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn2(){

  }

  /**
   * ���a���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn3(){

  }

  /**
   * ���ʔԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn4(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn5(){

  }

  /**
   * �ی��񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn6(){

  }

  /**
   * �ی��T�[�r�X�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn7(){

  }

  /**
   * �ی����v�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn8(){

  }

  /**
   * ����1�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn9(){

  }

  /**
   * ����2�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn10(){

  }

  /**
   * ����3�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn11(){

  }

  /**
   * �E�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoTablecolumn12(){

  }

  /**
   * ����×{����ݒ���e�C���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoRevisionPanel(){

    recuperationInfoRevisionPanel.add(getRecuperationInfoRevisionLabel(), null);

    recuperationInfoRevisionPanel.add(getRecuperationInfoRevision(), null);

    recuperationInfoRevisionPanel.add(getRecuperationInfoRevisionCheck(), null);

  }

  /**
   * ����×{����ݒ���e�C�������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoRevisionLabel(){

  }

  /**
   * ����×{������ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoRevision(){

  }

  /**
   * �S�Ă̏���\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoRevisionCheck(){

  }

  /**
   * ����×{������ڍ׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoRevisionTable(){

  }

  /**
   * ����×{������ڍ׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoRevisionTableColumnModel(){

    getRecuperationInfoRevisionTableColumnModel().addColumn(getRecuperationInfoRevisionTablecolumn0());

    getRecuperationInfoRevisionTableColumnModel().addColumn(getRecuperationInfoRevisionTablecolumn1());

    getRecuperationInfoRevisionTableColumnModel().addColumn(getRecuperationInfoRevisionTablecolumn2());

    getRecuperationInfoRevisionTableColumnModel().addColumn(getRecuperationInfoRevisionTablecolumn3());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoRevisionTablecolumn0(){

  }

  /**
   * ���ږ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoRevisionTablecolumn1(){

  }

  /**
   * �ݒ�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoRevisionTablecolumn2(){

  }

  /**
   * �R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationInfoRevisionTablecolumn3(){

  }

  /**
   * ���׏��i�Z���n����j�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfos(){

    detailsJushotiTokureiInfos.add(getDetailsJushotiTokureiPanel(), VRLayout.NORTH);

    detailsJushotiTokureiInfos.add(getDetailsJushotiTokureiInfoTable(), VRLayout.NORTH);

    detailsJushotiTokureiInfos.add(getDetailsJushotiTokureiInfoRevisionPanel(), VRLayout.NORTH);

    detailsJushotiTokureiInfos.add(getDetailsJushotiTokureiInfoRevisionTable(), VRLayout.CLIENT);

  }

  /**
   * ���׏��i�Z���n����j�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiPanel(){

    detailsJushotiTokureiPanel.add(getDetailsJushotiTokureiLabel(), VRLayout.FLOW);

    detailsJushotiTokureiPanel.add(getDetailsJushotiTokureiDelButton(), VRLayout.EAST);
  }

  /**
   * ���׏��i�Z���n����j���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiLabel(){

  }

  /**
   * �T�[�r�X�폜�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiDelButton(){

  }

  /**
   * ���׏��i�Z���n����j�e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTable(){

  }

  /**
   * ���׏��i�Z���n����j�e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTableColumnModel(){

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn0());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn1());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn2());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn3());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn4());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn5());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn6());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn7());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn8());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn9());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn10());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn11());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn12());

    getDetailsJushotiTokureiInfoTableColumnModel().addColumn(getDetailsJushotiTokureiInfoTablecolumn13());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn0(){

  }

  /**
   * �T�[�r�X�R�[�h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn1(){

  }

  /**
   * �T�[�r�X���̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn2(){

  }

  /**
   * �P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn3(){

  }

  /**
   * �����E�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn4(){

  }

  /**
   * ����1�Ώۓ����E�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn5(){

  }

  /**
   * ����2�Ώۓ����E�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn6(){

  }

  /**
   * ����3�Ώۓ����E�񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn7(){

  }

  /**
   * �T�[�r�X�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn8(){

  }

  /**
   * ����1�ΏۃT�[�r�X�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn9(){

  }

  /**
   * ����2�ΏۃT�[�r�X�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn10(){

  }

  /**
   * ����3�ΏۃT�[�r�X�P�ʐ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn11(){

  }

  /**
   * �{�ݏ��ݕی��Ҕԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn12(){

  }

  /**
   * �E�v(�p��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoTablecolumn13(){

  }

  /**
   * ���אݒ���e�C���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoRevisionPanel(){

    detailsJushotiTokureiInfoRevisionPanel.add(getDetailsJushotiTokureiInfoRevisionLabel(), VRLayout.FLOW);

    detailsJushotiTokureiInfoRevisionPanel.add(getDetailsJushotiTokureiInfoRevision(), VRLayout.FLOW);

    detailsJushotiTokureiInfoRevisionPanel.add(getDetailsJushotiTokureiInfoRevisionCheck(), VRLayout.FLOW);

  }

  /**
   * �ݒ���e�C�������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoRevisionLabel(){

  }

  /**
   * ���׏��i�Z���n����j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoRevision(){

  }

  /**
   * �S�Ă̏���\���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoRevisionCheck(){

  }

  /**
   * ���׏��ڍ׃e�[�u���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoRevisionTable(){

  }

  /**
   * ���׏��ڍ׃e�[�u���J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoRevisionTableColumnModel(){

    getDetailsJushotiTokureiInfoRevisionTableColumnModel().addColumn(getDetailsJushotiTokureiInfoRevisionTablecolumn0());

    getDetailsJushotiTokureiInfoRevisionTableColumnModel().addColumn(getDetailsJushotiTokureiInfoRevisionTablecolumn1());

    getDetailsJushotiTokureiInfoRevisionTableColumnModel().addColumn(getDetailsJushotiTokureiInfoRevisionTablecolumn2());

    getDetailsJushotiTokureiInfoRevisionTableColumnModel().addColumn(getDetailsJushotiTokureiInfoRevisionTablecolumn3());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoRevisionTablecolumn0(){

  }

  /**
   * ���ږ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoRevisionTablecolumn1(){

  }

  /**
   * �ݒ�l�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoRevisionTablecolumn2(){

  }

  /**
   * �R�����g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDetailsJushotiTokureiInfoRevisionTablecolumn3(){

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
      ACFrame.debugStart(new ACAffairInfo(QP005Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP005Design getThis() {
    return this;
  }
}
