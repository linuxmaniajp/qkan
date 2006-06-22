
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
 * �J����: �c���@����
 * �쐬��: 2006/04/07  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �����f�[�^�쐬 (P)
 * �v���Z�X �m�F�E�C�� (004)
 * �v���O���� ���莡�Ô�ҏW��� (QP004001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp004;
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
 * ���莡�Ô�ҏW��ʉ�ʍ��ڃf�U�C��(QP004001) 
 */
public class QP004001Design extends QkanAffairDialog {
  //GUI�R���|�[�l���g

  private ACGroupBox contents;

  private ACPanel editors;

  private ACGroupBox points;

  private ACTextField rehavilitationPoint;

  private ACLabelContainer rehavilitationPointContainer;

  private ACTextField processPoint;

  private ACLabelContainer processPointContainer;

  private ACTextField operationPoint;

  private ACLabelContainer operationPointContainer;

  private ACTextField anesthesiaPoint;

  private ACLabelContainer anesthesiaPointContainer;

  private ACTextField radiationPoint;

  private ACLabelContainer radiationPointContainer;

  private ACPanel recordEditors;

  private ACBackLabelContainer sicks1;

  private ACTextField sickName1;

  private ACLabelContainer sickName1Container;

  private QkanDateTextField sickDate1;

  private ACLabelContainer sickDate1Container;

  private ACBackLabelContainer sicks2;

  private ACTextField sickName2;

  private ACLabelContainer sickName2Container;

  private QkanDateTextField sickDate2;

  private ACLabelContainer sickDate2Container;

  private ACBackLabelContainer sicks3;

  private ACTextField sickName3;

  private ACLabelContainer sickName3Container;

  private QkanDateTextField sickDate3;

  private ACLabelContainer sickDate3Container;

  private ACTextField houseCallProviderName;

  private ACLabelContainer houseCallProviderNameContainer;

  private ACTextField attendProviderName;

  private ACLabelContainer attendProviderNameContainer;

  private ACPanel hiddens;

  private ACTextField summary1;

  private ACTextField summary2;

  private ACTextField summary3;

  private ACTextField summary4;

  private ACTextField summary5;

  private ACTextField summary6;

  private ACTextField summary7;

  private ACTextField summary8;

  private ACTextField summary9;

  private ACTextField summary10;

  private ACTextField summary11;

  private ACTextField summary12;

  private ACTextField summary13;

  private ACTextField summary14;

  private ACTextField summary15;

  private ACTextField summary16;

  private ACTextField summary17;

  private ACTextField summary18;

  private ACTextField summary19;

  private ACTextField summary20;

  private ACPanel medicalButtons;

  private ACButton medicalClear;

  private ACButton medicalInsert;

  private ACButton medicalUpdate;

  private ACButton medicalDelete;

  private ACTable medicalTable;

  private VRTableColumnModel medicalTableColumnModel;

  private ACTableColumn medicalNo;

  private ACTableColumn medicalSickName1;

  private ACTableColumn medicalSickDate1;

  private ACTableColumn medicalSickName2;

  private ACTableColumn medicalSickDate2;

  private ACTableColumn medicalSickName3;

  private ACTableColumn medicalSickDate3;

  private ACTableColumn medicalHouseCallProviderName;

  private ACTableColumn medicalAttendProviderName;

  private ACPanel buttons;

  private ACButton aplly;

  private ACButton close;

  //getter

  /**
   * ���莡�Ô�����擾���܂��B
   * @return ���莡�Ô���
   */
  public ACGroupBox getContents(){
    if(contents==null){

      contents = new ACGroupBox();

      contents.setText("���莡�Ô���");

      addContents();
    }
    return contents;

  }

  /**
   * �ҏW�̈���擾���܂��B
   * @return �ҏW�̈�
   */
  public ACPanel getEditors(){
    if(editors==null){

      editors = new ACPanel();

      addEditors();
    }
    return editors;

  }

  /**
   * ���莡�Ô���擾���܂��B
   * @return ���莡�Ô�
   */
  public ACGroupBox getPoints(){
    if(points==null){

      points = new ACGroupBox();

      points.setText("���莡�Ô�");

      points.setAutoWrap(false);

      points.setHgap(0);

      points.setHgrid(300);

      addPoints();
    }
    return points;

  }

  /**
   * ���n�r���e�[�V�����_�����擾���܂��B
   * @return ���n�r���e�[�V�����_��
   */
  public ACTextField getRehavilitationPoint(){
    if(rehavilitationPoint==null){

      rehavilitationPoint = new ACTextField();

      getRehavilitationPointContainer().setText("���n�r���e�[�V�����_��");

      rehavilitationPoint.setBindPath("401021");

      rehavilitationPoint.setColumns(7);

      rehavilitationPoint.setCharType(VRCharType.ONLY_DIGIT);

      rehavilitationPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      rehavilitationPoint.setIMEMode(InputSubset.LATIN);

      rehavilitationPoint.setMaxLength(7);

      addRehavilitationPoint();
    }
    return rehavilitationPoint;

  }

  /**
   * ���n�r���e�[�V�����_���R���e�i���擾���܂��B
   * @return ���n�r���e�[�V�����_���R���e�i
   */
  protected ACLabelContainer getRehavilitationPointContainer(){
    if(rehavilitationPointContainer==null){
      rehavilitationPointContainer = new ACLabelContainer();
      rehavilitationPointContainer.setFollowChildEnabled(true);
      rehavilitationPointContainer.setVAlignment(VRLayout.CENTER);
      rehavilitationPointContainer.add(getRehavilitationPoint(), null);
    }
    return rehavilitationPointContainer;
  }

  /**
   * ���u�_�����擾���܂��B
   * @return ���u�_��
   */
  public ACTextField getProcessPoint(){
    if(processPoint==null){

      processPoint = new ACTextField();

      getProcessPointContainer().setText("���u�_��");

      processPoint.setBindPath("401022");

      processPoint.setColumns(7);

      processPoint.setCharType(VRCharType.ONLY_DIGIT);

      processPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      processPoint.setIMEMode(InputSubset.LATIN);

      processPoint.setMaxLength(7);

      addProcessPoint();
    }
    return processPoint;

  }

  /**
   * ���u�_���R���e�i���擾���܂��B
   * @return ���u�_���R���e�i
   */
  protected ACLabelContainer getProcessPointContainer(){
    if(processPointContainer==null){
      processPointContainer = new ACLabelContainer();
      processPointContainer.setFollowChildEnabled(true);
      processPointContainer.setVAlignment(VRLayout.CENTER);
      processPointContainer.add(getProcessPoint(), null);
    }
    return processPointContainer;
  }

  /**
   * ��p�_�����擾���܂��B
   * @return ��p�_��
   */
  public ACTextField getOperationPoint(){
    if(operationPoint==null){

      operationPoint = new ACTextField();

      getOperationPointContainer().setText("��p�_��");

      operationPoint.setBindPath("401023");

      operationPoint.setColumns(7);

      operationPoint.setCharType(VRCharType.ONLY_DIGIT);

      operationPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      operationPoint.setIMEMode(InputSubset.LATIN);

      operationPoint.setMaxLength(7);

      addOperationPoint();
    }
    return operationPoint;

  }

  /**
   * ��p�_���R���e�i���擾���܂��B
   * @return ��p�_���R���e�i
   */
  protected ACLabelContainer getOperationPointContainer(){
    if(operationPointContainer==null){
      operationPointContainer = new ACLabelContainer();
      operationPointContainer.setFollowChildEnabled(true);
      operationPointContainer.setVAlignment(VRLayout.CENTER);
      operationPointContainer.add(getOperationPoint(), null);
    }
    return operationPointContainer;
  }

  /**
   * �����_�����擾���܂��B
   * @return �����_��
   */
  public ACTextField getAnesthesiaPoint(){
    if(anesthesiaPoint==null){

      anesthesiaPoint = new ACTextField();

      getAnesthesiaPointContainer().setText("�����_��");

      anesthesiaPoint.setBindPath("401024");

      anesthesiaPoint.setColumns(7);

      anesthesiaPoint.setCharType(VRCharType.ONLY_DIGIT);

      anesthesiaPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      anesthesiaPoint.setIMEMode(InputSubset.LATIN);

      anesthesiaPoint.setMaxLength(7);

      addAnesthesiaPoint();
    }
    return anesthesiaPoint;

  }

  /**
   * �����_���R���e�i���擾���܂��B
   * @return �����_���R���e�i
   */
  protected ACLabelContainer getAnesthesiaPointContainer(){
    if(anesthesiaPointContainer==null){
      anesthesiaPointContainer = new ACLabelContainer();
      anesthesiaPointContainer.setFollowChildEnabled(true);
      anesthesiaPointContainer.setVAlignment(VRLayout.CENTER);
      anesthesiaPointContainer.add(getAnesthesiaPoint(), null);
    }
    return anesthesiaPointContainer;
  }

  /**
   * ���ː����Ó_�����擾���܂��B
   * @return ���ː����Ó_��
   */
  public ACTextField getRadiationPoint(){
    if(radiationPoint==null){

      radiationPoint = new ACTextField();

      getRadiationPointContainer().setText("���ː����Ó_��");

      radiationPoint.setBindPath("401025");

      radiationPoint.setColumns(7);

      radiationPoint.setCharType(VRCharType.ONLY_DIGIT);

      radiationPoint.setHorizontalAlignment(SwingConstants.RIGHT);

      radiationPoint.setIMEMode(InputSubset.LATIN);

      radiationPoint.setMaxLength(7);

      addRadiationPoint();
    }
    return radiationPoint;

  }

  /**
   * ���ː����Ó_���R���e�i���擾���܂��B
   * @return ���ː����Ó_���R���e�i
   */
  protected ACLabelContainer getRadiationPointContainer(){
    if(radiationPointContainer==null){
      radiationPointContainer = new ACLabelContainer();
      radiationPointContainer.setFollowChildEnabled(true);
      radiationPointContainer.setVAlignment(VRLayout.CENTER);
      radiationPointContainer.add(getRadiationPoint(), null);
    }
    return radiationPointContainer;
  }

  /**
   * ���R�[�h�̈���擾���܂��B
   * @return ���R�[�h�̈�
   */
  public ACPanel getRecordEditors(){
    if(recordEditors==null){

      recordEditors = new ACPanel();

      recordEditors.setAutoWrap(false);

      recordEditors.setHgap(0);

      recordEditors.setLabelMargin(0);

      addRecordEditors();
    }
    return recordEditors;

  }

  /**
   * ���a�R���e�i1���擾���܂��B
   * @return ���a�R���e�i1
   */
  public ACBackLabelContainer getSicks1(){
    if(sicks1==null){

      sicks1 = new ACBackLabelContainer();

      addSicks1();
    }
    return sicks1;

  }

  /**
   * �ً}�����a��1���擾���܂��B
   * @return �ً}�����a��1
   */
  public ACTextField getSickName1(){
    if(sickName1==null){

      sickName1 = new ACTextField();

      getSickName1Container().setText("�ً}�����a��1");

      sickName1.setBindPath("401008");

      sickName1.setColumns(20);

      sickName1.setIMEMode(InputSubset.KANJI);

      sickName1.setMaxLength(20);

      addSickName1();
    }
    return sickName1;

  }

  /**
   * �ً}�����a��1�R���e�i���擾���܂��B
   * @return �ً}�����a��1�R���e�i
   */
  protected ACLabelContainer getSickName1Container(){
    if(sickName1Container==null){
      sickName1Container = new ACLabelContainer();
      sickName1Container.setFollowChildEnabled(true);
      sickName1Container.setVAlignment(VRLayout.CENTER);
      sickName1Container.add(getSickName1(), null);
    }
    return sickName1Container;
  }

  /**
   * �ً}�����ÊJ�n�N����1���擾���܂��B
   * @return �ً}�����ÊJ�n�N����1
   */
  public QkanDateTextField getSickDate1(){
    if(sickDate1==null){

      sickDate1 = new QkanDateTextField();

      getSickDate1Container().setText("�ً}�����ÊJ�n�N����1");

      sickDate1.setBindPath("401009");

      addSickDate1();
    }
    return sickDate1;

  }

  /**
   * �ً}�����ÊJ�n�N����1�R���e�i���擾���܂��B
   * @return �ً}�����ÊJ�n�N����1�R���e�i
   */
  protected ACLabelContainer getSickDate1Container(){
    if(sickDate1Container==null){
      sickDate1Container = new ACLabelContainer();
      sickDate1Container.setFollowChildEnabled(true);
      sickDate1Container.setVAlignment(VRLayout.CENTER);
      sickDate1Container.add(getSickDate1(), null);
    }
    return sickDate1Container;
  }

  /**
   * ���a�R���e�i2���擾���܂��B
   * @return ���a�R���e�i2
   */
  public ACBackLabelContainer getSicks2(){
    if(sicks2==null){

      sicks2 = new ACBackLabelContainer();

      addSicks2();
    }
    return sicks2;

  }

  /**
   * �ً}�����a��2���擾���܂��B
   * @return �ً}�����a��2
   */
  public ACTextField getSickName2(){
    if(sickName2==null){

      sickName2 = new ACTextField();

      getSickName2Container().setText("�ً}�����a��2");

      sickName2.setBindPath("401010");

      sickName2.setColumns(20);

      sickName2.setIMEMode(InputSubset.KANJI);

      sickName2.setMaxLength(20);

      addSickName2();
    }
    return sickName2;

  }

  /**
   * �ً}�����a��2�R���e�i���擾���܂��B
   * @return �ً}�����a��2�R���e�i
   */
  protected ACLabelContainer getSickName2Container(){
    if(sickName2Container==null){
      sickName2Container = new ACLabelContainer();
      sickName2Container.setFollowChildEnabled(true);
      sickName2Container.setVAlignment(VRLayout.CENTER);
      sickName2Container.add(getSickName2(), null);
    }
    return sickName2Container;
  }

  /**
   * �ً}�����ÊJ�n�N����2���擾���܂��B
   * @return �ً}�����ÊJ�n�N����2
   */
  public QkanDateTextField getSickDate2(){
    if(sickDate2==null){

      sickDate2 = new QkanDateTextField();

      getSickDate2Container().setText("�ً}�����ÊJ�n�N����2");

      sickDate2.setBindPath("401011");

      addSickDate2();
    }
    return sickDate2;

  }

  /**
   * �ً}�����ÊJ�n�N����2�R���e�i���擾���܂��B
   * @return �ً}�����ÊJ�n�N����2�R���e�i
   */
  protected ACLabelContainer getSickDate2Container(){
    if(sickDate2Container==null){
      sickDate2Container = new ACLabelContainer();
      sickDate2Container.setFollowChildEnabled(true);
      sickDate2Container.setVAlignment(VRLayout.CENTER);
      sickDate2Container.add(getSickDate2(), null);
    }
    return sickDate2Container;
  }

  /**
   * ���a�R���e�i3���擾���܂��B
   * @return ���a�R���e�i3
   */
  public ACBackLabelContainer getSicks3(){
    if(sicks3==null){

      sicks3 = new ACBackLabelContainer();

      addSicks3();
    }
    return sicks3;

  }

  /**
   * �ً}�����a��3���擾���܂��B
   * @return �ً}�����a��3
   */
  public ACTextField getSickName3(){
    if(sickName3==null){

      sickName3 = new ACTextField();

      getSickName3Container().setText("�ً}�����a��3");

      sickName3.setBindPath("401012");

      sickName3.setColumns(20);

      sickName3.setIMEMode(InputSubset.KANJI);

      sickName3.setMaxLength(20);

      addSickName3();
    }
    return sickName3;

  }

  /**
   * �ً}�����a��3�R���e�i���擾���܂��B
   * @return �ً}�����a��3�R���e�i
   */
  protected ACLabelContainer getSickName3Container(){
    if(sickName3Container==null){
      sickName3Container = new ACLabelContainer();
      sickName3Container.setFollowChildEnabled(true);
      sickName3Container.setVAlignment(VRLayout.CENTER);
      sickName3Container.add(getSickName3(), null);
    }
    return sickName3Container;
  }

  /**
   * �ً}�����ÊJ�n�N����3���擾���܂��B
   * @return �ً}�����ÊJ�n�N����3
   */
  public QkanDateTextField getSickDate3(){
    if(sickDate3==null){

      sickDate3 = new QkanDateTextField();

      getSickDate3Container().setText("�ً}�����ÊJ�n�N����3");

      sickDate3.setBindPath("401013");

      addSickDate3();
    }
    return sickDate3;

  }

  /**
   * �ً}�����ÊJ�n�N����3�R���e�i���擾���܂��B
   * @return �ً}�����ÊJ�n�N����3�R���e�i
   */
  protected ACLabelContainer getSickDate3Container(){
    if(sickDate3Container==null){
      sickDate3Container = new ACLabelContainer();
      sickDate3Container.setFollowChildEnabled(true);
      sickDate3Container.setVAlignment(VRLayout.CENTER);
      sickDate3Container.add(getSickDate3(), null);
    }
    return sickDate3Container;
  }

  /**
   * ���f��Ë@�֖����擾���܂��B
   * @return ���f��Ë@�֖�
   */
  public ACTextField getHouseCallProviderName(){
    if(houseCallProviderName==null){

      houseCallProviderName = new ACTextField();

      getHouseCallProviderNameContainer().setText("���f��Ë@�֖�");

      houseCallProviderName.setBindPath("401015");

      houseCallProviderName.setColumns(20);

      houseCallProviderName.setIMEMode(InputSubset.KANJI);

      houseCallProviderName.setMaxLength(20);

      addHouseCallProviderName();
    }
    return houseCallProviderName;

  }

  /**
   * ���f��Ë@�֖��R���e�i���擾���܂��B
   * @return ���f��Ë@�֖��R���e�i
   */
  protected ACLabelContainer getHouseCallProviderNameContainer(){
    if(houseCallProviderNameContainer==null){
      houseCallProviderNameContainer = new ACLabelContainer();
      houseCallProviderNameContainer.setFollowChildEnabled(true);
      houseCallProviderNameContainer.setVAlignment(VRLayout.CENTER);
      houseCallProviderNameContainer.add(getHouseCallProviderName(), null);
    }
    return houseCallProviderNameContainer;
  }

  /**
   * �ʉ@��Ë@�֖����擾���܂��B
   * @return �ʉ@��Ë@�֖�
   */
  public ACTextField getAttendProviderName(){
    if(attendProviderName==null){

      attendProviderName = new ACTextField();

      getAttendProviderNameContainer().setText("�ʉ@��Ë@�֖�");

      attendProviderName.setBindPath("401017");

      attendProviderName.setColumns(20);

      attendProviderName.setIMEMode(InputSubset.KANJI);

      attendProviderName.setMaxLength(20);

      addAttendProviderName();
    }
    return attendProviderName;

  }

  /**
   * �ʉ@��Ë@�֖��R���e�i���擾���܂��B
   * @return �ʉ@��Ë@�֖��R���e�i
   */
  protected ACLabelContainer getAttendProviderNameContainer(){
    if(attendProviderNameContainer==null){
      attendProviderNameContainer = new ACLabelContainer();
      attendProviderNameContainer.setFollowChildEnabled(true);
      attendProviderNameContainer.setVAlignment(VRLayout.CENTER);
      attendProviderNameContainer.add(getAttendProviderName(), null);
    }
    return attendProviderNameContainer;
  }

  /**
   * �B���t�B�[���h���擾���܂��B
   * @return �B���t�B�[���h
   */
  public ACPanel getHiddens(){
    if(hiddens==null){

      hiddens = new ACPanel();

      hiddens.setVisible(false);

      addHiddens();
    }
    return hiddens;

  }

  /**
   * �E�v1���擾���܂��B
   * @return �E�v1
   */
  public ACTextField getSummary1(){
    if(summary1==null){

      summary1 = new ACTextField();

      summary1.setBindPath("401026");

      addSummary1();
    }
    return summary1;

  }

  /**
   * �E�v2���擾���܂��B
   * @return �E�v2
   */
  public ACTextField getSummary2(){
    if(summary2==null){

      summary2 = new ACTextField();

      summary2.setBindPath("401027");

      addSummary2();
    }
    return summary2;

  }

  /**
   * �E�v3���擾���܂��B
   * @return �E�v3
   */
  public ACTextField getSummary3(){
    if(summary3==null){

      summary3 = new ACTextField();

      summary3.setBindPath("401028");

      addSummary3();
    }
    return summary3;

  }

  /**
   * �E�v4���擾���܂��B
   * @return �E�v4
   */
  public ACTextField getSummary4(){
    if(summary4==null){

      summary4 = new ACTextField();

      summary4.setBindPath("401029");

      addSummary4();
    }
    return summary4;

  }

  /**
   * �E�v5���擾���܂��B
   * @return �E�v5
   */
  public ACTextField getSummary5(){
    if(summary5==null){

      summary5 = new ACTextField();

      summary5.setBindPath("401030");

      addSummary5();
    }
    return summary5;

  }

  /**
   * �E�v6���擾���܂��B
   * @return �E�v6
   */
  public ACTextField getSummary6(){
    if(summary6==null){

      summary6 = new ACTextField();

      summary6.setBindPath("401031");

      addSummary6();
    }
    return summary6;

  }

  /**
   * �E�v7���擾���܂��B
   * @return �E�v7
   */
  public ACTextField getSummary7(){
    if(summary7==null){

      summary7 = new ACTextField();

      summary7.setBindPath("401032");

      addSummary7();
    }
    return summary7;

  }

  /**
   * �E�v8���擾���܂��B
   * @return �E�v8
   */
  public ACTextField getSummary8(){
    if(summary8==null){

      summary8 = new ACTextField();

      summary8.setBindPath("401033");

      addSummary8();
    }
    return summary8;

  }

  /**
   * �E�v9���擾���܂��B
   * @return �E�v9
   */
  public ACTextField getSummary9(){
    if(summary9==null){

      summary9 = new ACTextField();

      summary9.setBindPath("401034");

      addSummary9();
    }
    return summary9;

  }

  /**
   * �E�v10���擾���܂��B
   * @return �E�v10
   */
  public ACTextField getSummary10(){
    if(summary10==null){

      summary10 = new ACTextField();

      summary10.setBindPath("401035");

      addSummary10();
    }
    return summary10;

  }

  /**
   * �E�v11���擾���܂��B
   * @return �E�v11
   */
  public ACTextField getSummary11(){
    if(summary11==null){

      summary11 = new ACTextField();

      summary11.setBindPath("401036");

      addSummary11();
    }
    return summary11;

  }

  /**
   * �E�v12���擾���܂��B
   * @return �E�v12
   */
  public ACTextField getSummary12(){
    if(summary12==null){

      summary12 = new ACTextField();

      summary12.setBindPath("401037");

      addSummary12();
    }
    return summary12;

  }

  /**
   * �E�v13���擾���܂��B
   * @return �E�v13
   */
  public ACTextField getSummary13(){
    if(summary13==null){

      summary13 = new ACTextField();

      summary13.setBindPath("401038");

      addSummary13();
    }
    return summary13;

  }

  /**
   * �E�v14���擾���܂��B
   * @return �E�v14
   */
  public ACTextField getSummary14(){
    if(summary14==null){

      summary14 = new ACTextField();

      summary14.setBindPath("401039");

      addSummary14();
    }
    return summary14;

  }

  /**
   * �E�v15���擾���܂��B
   * @return �E�v15
   */
  public ACTextField getSummary15(){
    if(summary15==null){

      summary15 = new ACTextField();

      summary15.setBindPath("401040");

      addSummary15();
    }
    return summary15;

  }

  /**
   * �E�v16���擾���܂��B
   * @return �E�v16
   */
  public ACTextField getSummary16(){
    if(summary16==null){

      summary16 = new ACTextField();

      summary16.setBindPath("401041");

      addSummary16();
    }
    return summary16;

  }

  /**
   * �E�v17���擾���܂��B
   * @return �E�v17
   */
  public ACTextField getSummary17(){
    if(summary17==null){

      summary17 = new ACTextField();

      summary17.setBindPath("401042");

      addSummary17();
    }
    return summary17;

  }

  /**
   * �E�v18���擾���܂��B
   * @return �E�v18
   */
  public ACTextField getSummary18(){
    if(summary18==null){

      summary18 = new ACTextField();

      summary18.setBindPath("401043");

      addSummary18();
    }
    return summary18;

  }

  /**
   * �E�v19���擾���܂��B
   * @return �E�v19
   */
  public ACTextField getSummary19(){
    if(summary19==null){

      summary19 = new ACTextField();

      summary19.setBindPath("401044");

      addSummary19();
    }
    return summary19;

  }

  /**
   * �E�v20���擾���܂��B
   * @return �E�v20
   */
  public ACTextField getSummary20(){
    if(summary20==null){

      summary20 = new ACTextField();

      summary20.setBindPath("401045");

      addSummary20();
    }
    return summary20;

  }

  /**
   * �ҏW�̈�E�{�^�����擾���܂��B
   * @return �ҏW�̈�E�{�^��
   */
  public ACPanel getMedicalButtons(){
    if(medicalButtons==null){

      medicalButtons = new ACPanel();

      addMedicalButtons();
    }
    return medicalButtons;

  }

  /**
   * �N���A���擾���܂��B
   * @return �N���A
   */
  public ACButton getMedicalClear(){
    if(medicalClear==null){

      medicalClear = new ACButton();

      medicalClear.setText("�N���A");

      medicalClear.setToolTipText("���莡�Ô�����N���A���܂��B");

      medicalClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addMedicalClear();
    }
    return medicalClear;

  }

  /**
   * �ǉ����擾���܂��B
   * @return �ǉ�
   */
  public ACButton getMedicalInsert(){
    if(medicalInsert==null){

      medicalInsert = new ACButton();

      medicalInsert.setText("�ǉ�");

      medicalInsert.setToolTipText("���莡�Ô����ǉ����܂��B");

      medicalInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addMedicalInsert();
    }
    return medicalInsert;

  }

  /**
   * ���ւ��擾���܂��B
   * @return ����
   */
  public ACButton getMedicalUpdate(){
    if(medicalUpdate==null){

      medicalUpdate = new ACButton();

      medicalUpdate.setText("����");

      medicalUpdate.setToolTipText("���莡�Ô�������������܂��B");

      medicalUpdate.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addMedicalUpdate();
    }
    return medicalUpdate;

  }

  /**
   * �폜���擾���܂��B
   * @return �폜
   */
  public ACButton getMedicalDelete(){
    if(medicalDelete==null){

      medicalDelete = new ACButton();

      medicalDelete.setText("�폜");

      medicalDelete.setToolTipText("���莡�Ô���폜���܂��B");

      medicalDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addMedicalDelete();
    }
    return medicalDelete;

  }

  /**
   * ���莡�Ô�ꗗ���擾���܂��B
   * @return ���莡�Ô�ꗗ
   */
  public ACTable getMedicalTable(){
    if(medicalTable==null){

      medicalTable = new ACTable();

      medicalTable.setColumnModel(getMedicalTableColumnModel());

      addMedicalTable();
    }
    return medicalTable;

  }

  /**
   * ���莡�Ô�ꗗ�J�������f�����擾���܂��B
   * @return ���莡�Ô�ꗗ�J�������f��
   */
  protected VRTableColumnModel getMedicalTableColumnModel(){
    if(medicalTableColumnModel==null){
      medicalTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addMedicalTableColumnModel();
    }
    return medicalTableColumnModel;
  }

  /**
   * No.���擾���܂��B
   * @return No.
   */
  public ACTableColumn getMedicalNo(){
    if(medicalNo==null){

      medicalNo = new ACTableColumn();

      medicalNo.setHeaderValue("No.");

      medicalNo.setColumnName("401008");

      medicalNo.setColumns(3);

      medicalNo.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      medicalNo.setSortable(false);

      addMedicalNo();
    }
    return medicalNo;

  }

  /**
   * �ً}�����a��1���擾���܂��B
   * @return �ً}�����a��1
   */
  public ACTableColumn getMedicalSickName1(){
    if(medicalSickName1==null){

      medicalSickName1 = new ACTableColumn();

      medicalSickName1.setHeaderValue("�ً}�����a��1");

      medicalSickName1.setColumnName("401008");

      medicalSickName1.setColumns(15);

      addMedicalSickName1();
    }
    return medicalSickName1;

  }

  /**
   * �ً}�����ÊJ�n�N����1���擾���܂��B
   * @return �ً}�����ÊJ�n�N����1
   */
  public ACTableColumn getMedicalSickDate1(){
    if(medicalSickDate1==null){

      medicalSickDate1 = new ACTableColumn();

      medicalSickDate1.setHeaderValue("�ً}�����ÊJ�n�N����1");

      medicalSickDate1.setColumnName("401009");

      medicalSickDate1.setColumns(13);

      medicalSickDate1.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addMedicalSickDate1();
    }
    return medicalSickDate1;

  }

  /**
   * �ً}�����a��2���擾���܂��B
   * @return �ً}�����a��2
   */
  public ACTableColumn getMedicalSickName2(){
    if(medicalSickName2==null){

      medicalSickName2 = new ACTableColumn();

      medicalSickName2.setHeaderValue("�ً}�����a��2");

      medicalSickName2.setColumnName("401010");

      medicalSickName2.setColumns(15);

      addMedicalSickName2();
    }
    return medicalSickName2;

  }

  /**
   * �ً}�����ÊJ�n�N����2���擾���܂��B
   * @return �ً}�����ÊJ�n�N����2
   */
  public ACTableColumn getMedicalSickDate2(){
    if(medicalSickDate2==null){

      medicalSickDate2 = new ACTableColumn();

      medicalSickDate2.setHeaderValue("�ً}�����ÊJ�n�N����2");

      medicalSickDate2.setColumnName("401011");

      medicalSickDate2.setColumns(13);

      medicalSickDate2.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addMedicalSickDate2();
    }
    return medicalSickDate2;

  }

  /**
   * �ً}�����a��3���擾���܂��B
   * @return �ً}�����a��3
   */
  public ACTableColumn getMedicalSickName3(){
    if(medicalSickName3==null){

      medicalSickName3 = new ACTableColumn();

      medicalSickName3.setHeaderValue("�ً}�����a��3");

      medicalSickName3.setColumnName("401012");

      medicalSickName3.setColumns(15);

      addMedicalSickName3();
    }
    return medicalSickName3;

  }

  /**
   * �ً}�����ÊJ�n�N����3���擾���܂��B
   * @return �ً}�����ÊJ�n�N����3
   */
  public ACTableColumn getMedicalSickDate3(){
    if(medicalSickDate3==null){

      medicalSickDate3 = new ACTableColumn();

      medicalSickDate3.setHeaderValue("�ً}�����ÊJ�n�N����3");

      medicalSickDate3.setColumnName("401013");

      medicalSickDate3.setColumns(13);

      medicalSickDate3.setFormat(new ACBorderBlankDateFormat("gggee�NMM��dd��"));

      addMedicalSickDate3();
    }
    return medicalSickDate3;

  }

  /**
   * ���f��Ë@�֖����擾���܂��B
   * @return ���f��Ë@�֖�
   */
  public ACTableColumn getMedicalHouseCallProviderName(){
    if(medicalHouseCallProviderName==null){

      medicalHouseCallProviderName = new ACTableColumn();

      medicalHouseCallProviderName.setHeaderValue("���f��Ë@�֖�");

      medicalHouseCallProviderName.setColumnName("401015");

      medicalHouseCallProviderName.setColumns(15);

      addMedicalHouseCallProviderName();
    }
    return medicalHouseCallProviderName;

  }

  /**
   * �ʉ@��Ë@�֖����擾���܂��B
   * @return �ʉ@��Ë@�֖�
   */
  public ACTableColumn getMedicalAttendProviderName(){
    if(medicalAttendProviderName==null){

      medicalAttendProviderName = new ACTableColumn();

      medicalAttendProviderName.setHeaderValue("�ʉ@��Ë@�֖�");

      medicalAttendProviderName.setColumnName("401017");

      medicalAttendProviderName.setColumns(15);

      addMedicalAttendProviderName();
    }
    return medicalAttendProviderName;

  }

  /**
   * �{�^���̈���擾���܂��B
   * @return �{�^���̈�
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * OK���擾���܂��B
   * @return OK
   */
  public ACButton getAplly(){
    if(aplly==null){

      aplly = new ACButton();

      aplly.setText("OK");

      aplly.setToolTipText("���͂��ꂽ���œ��莡�Ô�����X�V���܂��B");

      aplly.setMnemonic('O');

      aplly.setIconPath(ACConstants.ICON_PATH_OK_16);

      addAplly();
    }
    return aplly;

  }

  /**
   * �L�����Z�����擾���܂��B
   * @return �L�����Z��
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("�L�����Z��(C)");

      close.setToolTipText("���莡�Ô���̍X�V�͍s�킸�A�O�̉�ʂɖ߂�܂��B");

      close.setMnemonic('C');

      close.setIconPath(ACConstants.ICON_PATH_CANCEL_16);

      addClose();
    }
    return close;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QP004001Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(700, 400);

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

    this.getContentPane().add(getContents(), VRLayout.NORTH);

    this.getContentPane().add(getMedicalTable(), VRLayout.CLIENT);

    this.getContentPane().add(getButtons(), VRLayout.SOUTH);
  }

  /**
   * ���莡�Ô���ɓ������ڂ�ǉ����܂��B
   */
  protected void addContents(){

    contents.add(getEditors(), VRLayout.CLIENT);

    contents.add(getMedicalButtons(), VRLayout.SOUTH);
  }

  /**
   * �ҏW�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEditors(){

    editors.add(getPoints(), VRLayout.NORTH);

    editors.add(getRecordEditors(), VRLayout.CLIENT);

  }

  /**
   * ���莡�Ô�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPoints(){

    points.add(getRehavilitationPointContainer(), VRLayout.FLOW_INSETLINE);

    points.add(getProcessPointContainer(), VRLayout.FLOW_INSETLINE);

    points.add(getOperationPointContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    points.add(getAnesthesiaPointContainer(), VRLayout.FLOW_INSETLINE);

    points.add(getRadiationPointContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * ���n�r���e�[�V�����_���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehavilitationPoint(){

  }

  /**
   * ���u�_���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProcessPoint(){

  }

  /**
   * ��p�_���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOperationPoint(){

  }

  /**
   * �����_���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAnesthesiaPoint(){

  }

  /**
   * ���ː����Ó_���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRadiationPoint(){

  }

  /**
   * ���R�[�h�̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecordEditors(){

    recordEditors.add(getSicks1(), VRLayout.FLOW_INSETLINE_RETURN);

    recordEditors.add(getSicks2(), VRLayout.FLOW_INSETLINE_RETURN);

    recordEditors.add(getSicks3(), VRLayout.FLOW_INSETLINE_RETURN);

    recordEditors.add(getHouseCallProviderNameContainer(), VRLayout.FLOW_INSETLINE);

    recordEditors.add(getAttendProviderNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recordEditors.add(getHiddens(), VRLayout.FLOW_RETURN);

  }

  /**
   * ���a�R���e�i1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSicks1(){

    sicks1.add(getSickName1Container(), VRLayout.FLOW);

    sicks1.add(getSickDate1Container(), VRLayout.FLOW);

  }

  /**
   * �ً}�����a��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSickName1(){

  }

  /**
   * �ً}�����ÊJ�n�N����1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSickDate1(){

  }

  /**
   * ���a�R���e�i2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSicks2(){

    sicks2.add(getSickName2Container(), VRLayout.FLOW);

    sicks2.add(getSickDate2Container(), VRLayout.FLOW);

  }

  /**
   * �ً}�����a��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSickName2(){

  }

  /**
   * �ً}�����ÊJ�n�N����2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSickDate2(){

  }

  /**
   * ���a�R���e�i3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSicks3(){

    sicks3.add(getSickName3Container(), VRLayout.FLOW);

    sicks3.add(getSickDate3Container(), VRLayout.FLOW);

  }

  /**
   * �ً}�����a��3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSickName3(){

  }

  /**
   * �ً}�����ÊJ�n�N����3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSickDate3(){

  }

  /**
   * ���f��Ë@�֖��ɓ������ڂ�ǉ����܂��B
   */
  protected void addHouseCallProviderName(){

  }

  /**
   * �ʉ@��Ë@�֖��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAttendProviderName(){

  }

  /**
   * �B���t�B�[���h�ɓ������ڂ�ǉ����܂��B
   */
  protected void addHiddens(){

    hiddens.add(getSummary1(), VRLayout.FLOW);

    hiddens.add(getSummary2(), VRLayout.FLOW);

    hiddens.add(getSummary3(), VRLayout.FLOW);

    hiddens.add(getSummary4(), VRLayout.FLOW);

    hiddens.add(getSummary5(), VRLayout.FLOW);

    hiddens.add(getSummary6(), VRLayout.FLOW);

    hiddens.add(getSummary7(), VRLayout.FLOW);

    hiddens.add(getSummary8(), VRLayout.FLOW);

    hiddens.add(getSummary9(), VRLayout.FLOW);

    hiddens.add(getSummary10(), VRLayout.FLOW);

    hiddens.add(getSummary11(), VRLayout.FLOW);

    hiddens.add(getSummary12(), VRLayout.FLOW);

    hiddens.add(getSummary13(), VRLayout.FLOW);

    hiddens.add(getSummary14(), VRLayout.FLOW);

    hiddens.add(getSummary15(), VRLayout.FLOW);

    hiddens.add(getSummary16(), VRLayout.FLOW);

    hiddens.add(getSummary17(), VRLayout.FLOW);

    hiddens.add(getSummary18(), VRLayout.FLOW);

    hiddens.add(getSummary19(), VRLayout.FLOW);

    hiddens.add(getSummary20(), VRLayout.FLOW);

  }

  /**
   * �E�v1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary1(){

  }

  /**
   * �E�v2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary2(){

  }

  /**
   * �E�v3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary3(){

  }

  /**
   * �E�v4�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary4(){

  }

  /**
   * �E�v5�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary5(){

  }

  /**
   * �E�v6�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary6(){

  }

  /**
   * �E�v7�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary7(){

  }

  /**
   * �E�v8�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary8(){

  }

  /**
   * �E�v9�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary9(){

  }

  /**
   * �E�v10�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary10(){

  }

  /**
   * �E�v11�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary11(){

  }

  /**
   * �E�v12�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary12(){

  }

  /**
   * �E�v13�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary13(){

  }

  /**
   * �E�v14�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary14(){

  }

  /**
   * �E�v15�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary15(){

  }

  /**
   * �E�v16�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary16(){

  }

  /**
   * �E�v17�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary17(){

  }

  /**
   * �E�v18�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary18(){

  }

  /**
   * �E�v19�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary19(){

  }

  /**
   * �E�v20�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSummary20(){

  }

  /**
   * �ҏW�̈�E�{�^���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalButtons(){

    medicalButtons.add(getMedicalDelete(), VRLayout.EAST);
    medicalButtons.add(getMedicalUpdate(), VRLayout.EAST);
    medicalButtons.add(getMedicalInsert(), VRLayout.EAST);
    medicalButtons.add(getMedicalClear(), VRLayout.EAST);
  }

  /**
   * �N���A�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalClear(){

  }

  /**
   * �ǉ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalInsert(){

  }

  /**
   * ���ւɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalUpdate(){

  }

  /**
   * �폜�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalDelete(){

  }

  /**
   * ���莡�Ô�ꗗ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTable(){

  }

  /**
   * ���莡�Ô�ꗗ�J�������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalTableColumnModel(){

    getMedicalTableColumnModel().addColumn(getMedicalNo());

    getMedicalTableColumnModel().addColumn(getMedicalSickName1());

    getMedicalTableColumnModel().addColumn(getMedicalSickDate1());

    getMedicalTableColumnModel().addColumn(getMedicalSickName2());

    getMedicalTableColumnModel().addColumn(getMedicalSickDate2());

    getMedicalTableColumnModel().addColumn(getMedicalSickName3());

    getMedicalTableColumnModel().addColumn(getMedicalSickDate3());

    getMedicalTableColumnModel().addColumn(getMedicalHouseCallProviderName());

    getMedicalTableColumnModel().addColumn(getMedicalAttendProviderName());

  }

  /**
   * No.�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalNo(){

  }

  /**
   * �ً}�����a��1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalSickName1(){

  }

  /**
   * �ً}�����ÊJ�n�N����1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalSickDate1(){

  }

  /**
   * �ً}�����a��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalSickName2(){

  }

  /**
   * �ً}�����ÊJ�n�N����2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalSickDate2(){

  }

  /**
   * �ً}�����a��3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalSickName3(){

  }

  /**
   * �ً}�����ÊJ�n�N����3�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalSickDate3(){

  }

  /**
   * ���f��Ë@�֖��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalHouseCallProviderName(){

  }

  /**
   * �ʉ@��Ë@�֖��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMedicalAttendProviderName(){

  }

  /**
   * �{�^���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
    buttons.add(getAplly(), VRLayout.EAST);
  }

  /**
   * OK�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAplly(){

  }

  /**
   * �L�����Z���ɓ������ڂ�ǉ����܂��B
   */
  protected void addClose(){

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
      new QP004001Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QP004001Design getThis() {
    return this;
  }
}
