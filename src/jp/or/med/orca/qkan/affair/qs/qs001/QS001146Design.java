
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
 * �J����: ���{�@�K��
 * �쐬��: 2006/05/09  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h�F�m�ǑΉ��^�ʏ���� (QS001146)
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
 * �T�[�r�X�p�^�[�����\�h�F�m�ǑΉ��^�ʏ�����ʍ��ڃf�U�C��(QS001146) 
 */
public class QS001146Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel ninchisyoTaioTusyoPatterns;

  private ACClearableRadioButtonGroup providerDivisionRadio;

  private ACLabelContainer providerDivisionRadioContainer;

  private ACListModelAdapter providerDivisionRadioModel;

  private ACRadioButtonItem providerDivisionRadioItem1;

  private ACRadioButtonItem providerDivisionRadioItem2;

  private ACClearableRadioButtonGroup divisionRadion;

  private ACLabelContainer divisionRadionContainer;

  private ACListModelAdapter divisionRadionModel;

  private ACRadioButtonItem divisionRadionitem1;

  private ACRadioButtonItem divisionRadionitem2;

  private ACClearableRadioButtonGroup timeDivisionRadio;

  private ACLabelContainer timeDivisionRadioContainer;

  private ACListModelAdapter timeDivisionRadioModel;

  private ACRadioButtonItem timeDivisionRadioItem1;

  private ACRadioButtonItem timeDivisionRadioItem2;

  private ACRadioButtonItem timeDivisionRadioItem3;

  private ACRadioButtonItem timeDivisionRadioItem4;

  private ACRadioButtonItem timeDivisionRadioItem5;

  private ACRadioButtonItem timeDivisionRadioItem6;

  private ACClearableRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACClearableRadioButtonGroup bathCareAddRadio;

  private ACLabelContainer bathCareAddRadioContainer;

  private ACListModelAdapter bathCareAddRadioModel;

  private ACRadioButtonItem bathCareAddRadioItem1;

  private ACRadioButtonItem bathCareAddRadioItem2;

  private ACClearableRadioButtonGroup functionTrainingAddRadio;

  private ACLabelContainer functionTrainingAddRadioContainer;

  private ACListModelAdapter functionTrainingAddRadioModel;

  private ACRadioButtonItem functionTrainingAddRadioItem1;

  private ACRadioButtonItem functionTrainingAddRadioItem2;

  private ACClearableRadioButtonGroup nourishmentManagementAddRadio;

  private ACLabelContainer nourishmentManagementAddRadioContainer;

  private ACListModelAdapter nourishmentManagementAddRadioModel;

  private ACRadioButtonItem nourishmentManagementAddRadioItem1;

  private ACRadioButtonItem nourishmentManagementAddRadioItem2;

  private ACClearableRadioButtonGroup oralFunctionAddRadio;

  private ACLabelContainer oralFunctionAddRadioContainer;

  private ACListModelAdapter oralFunctionAddRadioModel;

  private ACRadioButtonItem oralFunctionAddRadioItem1;

  private ACRadioButtonItem oralFunctionAddRadioItem2;

  private ACBackLabelContainer timeContena;

  private ACTimeComboBox beginTime;

  private ACLabelContainer beginTimeContainer;

  private ACComboBoxModelAdapter beginTimeModel;

  private ACTimeComboBox endTime;

  private ACLabelContainer endTimeContainer;

  private ACComboBoxModelAdapter endTimeModel;

  //getter

  /**
   * �F�m�ǑΉ��^�ʏ����p�^�[���̈���擾���܂��B
   * @return �F�m�ǑΉ��^�ʏ����p�^�[���̈�
   */
  public ACPanel getNinchisyoTaioTusyoPatterns(){
    if(ninchisyoTaioTusyoPatterns==null){

      ninchisyoTaioTusyoPatterns = new ACPanel();

      ninchisyoTaioTusyoPatterns.setAutoWrap(false);

      ninchisyoTaioTusyoPatterns.setHgap(0);

      ninchisyoTaioTusyoPatterns.setHgrid(200);

      addNinchisyoTaioTusyoPatterns();
    }
    return ninchisyoTaioTusyoPatterns;

  }

  /**
   * �{�ݓ��̋敪1���擾���܂��B
   * @return �{�ݓ��̋敪1
   */
  public ACClearableRadioButtonGroup getProviderDivisionRadio(){
    if(providerDivisionRadio==null){

      providerDivisionRadio = new ACClearableRadioButtonGroup();

      getProviderDivisionRadioContainer().setText("�{�ݓ��̋敪1");

      providerDivisionRadio.setBindPath("1740101");

      providerDivisionRadio.setUseClearButton(false);

      providerDivisionRadio.setModel(getProviderDivisionRadioModel());

      addProviderDivisionRadio();
    }
    return providerDivisionRadio;

  }

  /**
   * �{�ݓ��̋敪1�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪1�R���e�i
   */
  protected ACLabelContainer getProviderDivisionRadioContainer(){
    if(providerDivisionRadioContainer==null){
      providerDivisionRadioContainer = new ACLabelContainer();
      providerDivisionRadioContainer.setFollowChildEnabled(true);
      providerDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      providerDivisionRadioContainer.add(getProviderDivisionRadio(), null);
    }
    return providerDivisionRadioContainer;
  }

  /**
   * �{�ݓ��̋敪1���f�����擾���܂��B
   * @return �{�ݓ��̋敪1���f��
   */
  protected ACListModelAdapter getProviderDivisionRadioModel(){
    if(providerDivisionRadioModel==null){
      providerDivisionRadioModel = new ACListModelAdapter();
      addProviderDivisionRadioModel();
    }
    return providerDivisionRadioModel;
  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getProviderDivisionRadioItem1(){
    if(providerDivisionRadioItem1==null){

      providerDivisionRadioItem1 = new ACRadioButtonItem();

      providerDivisionRadioItem1.setText("I�^");

      providerDivisionRadioItem1.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem1();
    }
    return providerDivisionRadioItem1;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getProviderDivisionRadioItem2(){
    if(providerDivisionRadioItem2==null){

      providerDivisionRadioItem2 = new ACRadioButtonItem();

      providerDivisionRadioItem2.setText("II�^");

      providerDivisionRadioItem2.setGroup(getProviderDivisionRadio());

      providerDivisionRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderDivisionRadioItem2();
    }
    return providerDivisionRadioItem2;

  }

  /**
   * �{�ݓ��̋敪2���擾���܂��B
   * @return �{�ݓ��̋敪2
   */
  public ACClearableRadioButtonGroup getDivisionRadion(){
    if(divisionRadion==null){

      divisionRadion = new ACClearableRadioButtonGroup();

      getDivisionRadionContainer().setText("�{�ݓ��̋敪2");

      divisionRadion.setBindPath("1740102");

      divisionRadion.setUseClearButton(false);

      divisionRadion.setModel(getDivisionRadionModel());

      addDivisionRadion();
    }
    return divisionRadion;

  }

  /**
   * �{�ݓ��̋敪2�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪2�R���e�i
   */
  protected ACLabelContainer getDivisionRadionContainer(){
    if(divisionRadionContainer==null){
      divisionRadionContainer = new ACLabelContainer();
      divisionRadionContainer.setFollowChildEnabled(true);
      divisionRadionContainer.setVAlignment(VRLayout.CENTER);
      divisionRadionContainer.add(getDivisionRadion(), null);
    }
    return divisionRadionContainer;
  }

  /**
   * �{�ݓ��̋敪2���f�����擾���܂��B
   * @return �{�ݓ��̋敪2���f��
   */
  protected ACListModelAdapter getDivisionRadionModel(){
    if(divisionRadionModel==null){
      divisionRadionModel = new ACListModelAdapter();
      addDivisionRadionModel();
    }
    return divisionRadionModel;
  }

  /**
   * �P�ƌ^���擾���܂��B
   * @return �P�ƌ^
   */
  public ACRadioButtonItem getDivisionRadionitem1(){
    if(divisionRadionitem1==null){

      divisionRadionitem1 = new ACRadioButtonItem();

      divisionRadionitem1.setText("�P�ƌ^");

      divisionRadionitem1.setGroup(getDivisionRadion());

      divisionRadionitem1.setConstraints(VRLayout.FLOW);

      addDivisionRadionitem1();
    }
    return divisionRadionitem1;

  }

  /**
   * ���݌^���擾���܂��B
   * @return ���݌^
   */
  public ACRadioButtonItem getDivisionRadionitem2(){
    if(divisionRadionitem2==null){

      divisionRadionitem2 = new ACRadioButtonItem();

      divisionRadionitem2.setText("���݌^");

      divisionRadionitem2.setGroup(getDivisionRadion());

      divisionRadionitem2.setConstraints(VRLayout.FLOW);

      addDivisionRadionitem2();
    }
    return divisionRadionitem2;

  }

  /**
   * ���ԋ敪���擾���܂��B
   * @return ���ԋ敪
   */
  public ACClearableRadioButtonGroup getTimeDivisionRadio(){
    if(timeDivisionRadio==null){

      timeDivisionRadio = new ACClearableRadioButtonGroup();

      getTimeDivisionRadioContainer().setText("���ԋ敪");

      timeDivisionRadio.setBindPath("1740103");

      timeDivisionRadio.setUseClearButton(false);

      timeDivisionRadio.setModel(getTimeDivisionRadioModel());

      addTimeDivisionRadio();
    }
    return timeDivisionRadio;

  }

  /**
   * ���ԋ敪�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���e�i
   */
  protected ACLabelContainer getTimeDivisionRadioContainer(){
    if(timeDivisionRadioContainer==null){
      timeDivisionRadioContainer = new ACLabelContainer();
      timeDivisionRadioContainer.setFollowChildEnabled(true);
      timeDivisionRadioContainer.setVAlignment(VRLayout.CENTER);
      timeDivisionRadioContainer.add(getTimeDivisionRadio(), null);
    }
    return timeDivisionRadioContainer;
  }

  /**
   * ���ԋ敪���f�����擾���܂��B
   * @return ���ԋ敪���f��
   */
  protected ACListModelAdapter getTimeDivisionRadioModel(){
    if(timeDivisionRadioModel==null){
      timeDivisionRadioModel = new ACListModelAdapter();
      addTimeDivisionRadioModel();
    }
    return timeDivisionRadioModel;
  }

  /**
   * 2����3���Ԃ��擾���܂��B
   * @return 2����3����
   */
  public ACRadioButtonItem getTimeDivisionRadioItem1(){
    if(timeDivisionRadioItem1==null){

      timeDivisionRadioItem1 = new ACRadioButtonItem();

      timeDivisionRadioItem1.setText("2����3����");

      timeDivisionRadioItem1.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem1.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem1();
    }
    return timeDivisionRadioItem1;

  }

  /**
   * 3����4���Ԃ��擾���܂��B
   * @return 3����4����
   */
  public ACRadioButtonItem getTimeDivisionRadioItem2(){
    if(timeDivisionRadioItem2==null){

      timeDivisionRadioItem2 = new ACRadioButtonItem();

      timeDivisionRadioItem2.setText("3����4����");

      timeDivisionRadioItem2.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem2();
    }
    return timeDivisionRadioItem2;

  }

  /**
   * 4����6���Ԃ��擾���܂��B
   * @return 4����6����
   */
  public ACRadioButtonItem getTimeDivisionRadioItem3(){
    if(timeDivisionRadioItem3==null){

      timeDivisionRadioItem3 = new ACRadioButtonItem();

      timeDivisionRadioItem3.setText("4����6����");

      timeDivisionRadioItem3.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem3.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem3();
    }
    return timeDivisionRadioItem3;

  }

  /**
   * 6����8���Ԃ��擾���܂��B
   * @return 6����8����
   */
  public ACRadioButtonItem getTimeDivisionRadioItem4(){
    if(timeDivisionRadioItem4==null){

      timeDivisionRadioItem4 = new ACRadioButtonItem();

      timeDivisionRadioItem4.setText("6����8����");

      timeDivisionRadioItem4.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addTimeDivisionRadioItem4();
    }
    return timeDivisionRadioItem4;

  }

  /**
   * 8����9���Ԃ��擾���܂��B
   * @return 8����9����
   */
  public ACRadioButtonItem getTimeDivisionRadioItem5(){
    if(timeDivisionRadioItem5==null){

      timeDivisionRadioItem5 = new ACRadioButtonItem();

      timeDivisionRadioItem5.setText("8����9����");

      timeDivisionRadioItem5.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem5.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem5();
    }
    return timeDivisionRadioItem5;

  }

  /**
   * 9����10���Ԃ��擾���܂��B
   * @return 9����10����
   */
  public ACRadioButtonItem getTimeDivisionRadioItem6(){
    if(timeDivisionRadioItem6==null){

      timeDivisionRadioItem6 = new ACRadioButtonItem();

      timeDivisionRadioItem6.setText("9����10����");

      timeDivisionRadioItem6.setGroup(getTimeDivisionRadio());

      timeDivisionRadioItem6.setConstraints(VRLayout.FLOW);

      addTimeDivisionRadioItem6();
    }
    return timeDivisionRadioItem6;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACClearableRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("�l�����Z");

      staffSubtractionRadio.setBindPath("1740104");

      staffSubtractionRadio.setUseClearButton(false);

      staffSubtractionRadio.setModel(getStaffSubtractionRadioModel());

      addStaffSubtractionRadio();
    }
    return staffSubtractionRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getStaffSubtractionRadioContainer(){
    if(staffSubtractionRadioContainer==null){
      staffSubtractionRadioContainer = new ACLabelContainer();
      staffSubtractionRadioContainer.setFollowChildEnabled(true);
      staffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      staffSubtractionRadioContainer.add(getStaffSubtractionRadio(), null);
    }
    return staffSubtractionRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getStaffSubtractionRadioModel(){
    if(staffSubtractionRadioModel==null){
      staffSubtractionRadioModel = new ACListModelAdapter();
      addStaffSubtractionRadioModel();
    }
    return staffSubtractionRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem1(){
    if(staffSubtractionRadioItem1==null){

      staffSubtractionRadioItem1 = new ACRadioButtonItem();

      staffSubtractionRadioItem1.setText("�Ȃ�");

      staffSubtractionRadioItem1.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem1();
    }
    return staffSubtractionRadioItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem2(){
    if(staffSubtractionRadioItem2==null){

      staffSubtractionRadioItem2 = new ACRadioButtonItem();

      staffSubtractionRadioItem2.setText("�������");

      staffSubtractionRadioItem2.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addStaffSubtractionRadioItem2();
    }
    return staffSubtractionRadioItem2;

  }

  /**
   * �Ō쥉��E�����������擾���܂��B
   * @return �Ō쥉��E��������
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("�Ō�E���E��������");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * ��������Z���擾���܂��B
   * @return ��������Z
   */
  public ACClearableRadioButtonGroup getBathCareAddRadio(){
    if(bathCareAddRadio==null){

      bathCareAddRadio = new ACClearableRadioButtonGroup();

      getBathCareAddRadioContainer().setText("��������Z");

      bathCareAddRadio.setBindPath("1740105");

      bathCareAddRadio.setUseClearButton(false);

      bathCareAddRadio.setModel(getBathCareAddRadioModel());

      addBathCareAddRadio();
    }
    return bathCareAddRadio;

  }

  /**
   * ��������Z�R���e�i���擾���܂��B
   * @return ��������Z�R���e�i
   */
  protected ACLabelContainer getBathCareAddRadioContainer(){
    if(bathCareAddRadioContainer==null){
      bathCareAddRadioContainer = new ACLabelContainer();
      bathCareAddRadioContainer.setFollowChildEnabled(true);
      bathCareAddRadioContainer.setVAlignment(VRLayout.CENTER);
      bathCareAddRadioContainer.add(getBathCareAddRadio(), null);
    }
    return bathCareAddRadioContainer;
  }

  /**
   * ��������Z���f�����擾���܂��B
   * @return ��������Z���f��
   */
  protected ACListModelAdapter getBathCareAddRadioModel(){
    if(bathCareAddRadioModel==null){
      bathCareAddRadioModel = new ACListModelAdapter();
      addBathCareAddRadioModel();
    }
    return bathCareAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getBathCareAddRadioItem1(){
    if(bathCareAddRadioItem1==null){

      bathCareAddRadioItem1 = new ACRadioButtonItem();

      bathCareAddRadioItem1.setText("�Ȃ�");

      bathCareAddRadioItem1.setGroup(getBathCareAddRadio());

      bathCareAddRadioItem1.setConstraints(VRLayout.FLOW);

      addBathCareAddRadioItem1();
    }
    return bathCareAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getBathCareAddRadioItem2(){
    if(bathCareAddRadioItem2==null){

      bathCareAddRadioItem2 = new ACRadioButtonItem();

      bathCareAddRadioItem2.setText("����");

      bathCareAddRadioItem2.setGroup(getBathCareAddRadio());

      bathCareAddRadioItem2.setConstraints(VRLayout.FLOW);

      addBathCareAddRadioItem2();
    }
    return bathCareAddRadioItem2;

  }

  /**
   * �ʋ@�\�P�����Z���擾���܂��B
   * @return �ʋ@�\�P�����Z
   */
  public ACClearableRadioButtonGroup getFunctionTrainingAddRadio(){
    if(functionTrainingAddRadio==null){

      functionTrainingAddRadio = new ACClearableRadioButtonGroup();

      getFunctionTrainingAddRadioContainer().setText("�ʋ@�\�P�����Z");

      functionTrainingAddRadio.setBindPath("1740106");

      functionTrainingAddRadio.setUseClearButton(false);

      functionTrainingAddRadio.setModel(getFunctionTrainingAddRadioModel());

      addFunctionTrainingAddRadio();
    }
    return functionTrainingAddRadio;

  }

  /**
   * �ʋ@�\�P�����Z�R���e�i���擾���܂��B
   * @return �ʋ@�\�P�����Z�R���e�i
   */
  protected ACLabelContainer getFunctionTrainingAddRadioContainer(){
    if(functionTrainingAddRadioContainer==null){
      functionTrainingAddRadioContainer = new ACLabelContainer();
      functionTrainingAddRadioContainer.setFollowChildEnabled(true);
      functionTrainingAddRadioContainer.setVAlignment(VRLayout.CENTER);
      functionTrainingAddRadioContainer.add(getFunctionTrainingAddRadio(), null);
    }
    return functionTrainingAddRadioContainer;
  }

  /**
   * �ʋ@�\�P�����Z���f�����擾���܂��B
   * @return �ʋ@�\�P�����Z���f��
   */
  protected ACListModelAdapter getFunctionTrainingAddRadioModel(){
    if(functionTrainingAddRadioModel==null){
      functionTrainingAddRadioModel = new ACListModelAdapter();
      addFunctionTrainingAddRadioModel();
    }
    return functionTrainingAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getFunctionTrainingAddRadioItem1(){
    if(functionTrainingAddRadioItem1==null){

      functionTrainingAddRadioItem1 = new ACRadioButtonItem();

      functionTrainingAddRadioItem1.setText("�Ȃ�");

      functionTrainingAddRadioItem1.setGroup(getFunctionTrainingAddRadio());

      functionTrainingAddRadioItem1.setConstraints(VRLayout.FLOW);

      addFunctionTrainingAddRadioItem1();
    }
    return functionTrainingAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getFunctionTrainingAddRadioItem2(){
    if(functionTrainingAddRadioItem2==null){

      functionTrainingAddRadioItem2 = new ACRadioButtonItem();

      functionTrainingAddRadioItem2.setText("����");

      functionTrainingAddRadioItem2.setGroup(getFunctionTrainingAddRadio());

      functionTrainingAddRadioItem2.setConstraints(VRLayout.FLOW);

      addFunctionTrainingAddRadioItem2();
    }
    return functionTrainingAddRadioItem2;

  }

  /**
   * �h�{���P���Z���擾���܂��B
   * @return �h�{���P���Z
   */
  public ACClearableRadioButtonGroup getNourishmentManagementAddRadio(){
    if(nourishmentManagementAddRadio==null){

      nourishmentManagementAddRadio = new ACClearableRadioButtonGroup();

      getNourishmentManagementAddRadioContainer().setText("�h�{���P���Z");

      nourishmentManagementAddRadio.setBindPath("1740107");

      nourishmentManagementAddRadio.setUseClearButton(false);

      nourishmentManagementAddRadio.setModel(getNourishmentManagementAddRadioModel());

      addNourishmentManagementAddRadio();
    }
    return nourishmentManagementAddRadio;

  }

  /**
   * �h�{���P���Z�R���e�i���擾���܂��B
   * @return �h�{���P���Z�R���e�i
   */
  protected ACLabelContainer getNourishmentManagementAddRadioContainer(){
    if(nourishmentManagementAddRadioContainer==null){
      nourishmentManagementAddRadioContainer = new ACLabelContainer();
      nourishmentManagementAddRadioContainer.setFollowChildEnabled(true);
      nourishmentManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      nourishmentManagementAddRadioContainer.add(getNourishmentManagementAddRadio(), null);
    }
    return nourishmentManagementAddRadioContainer;
  }

  /**
   * �h�{���P���Z���f�����擾���܂��B
   * @return �h�{���P���Z���f��
   */
  protected ACListModelAdapter getNourishmentManagementAddRadioModel(){
    if(nourishmentManagementAddRadioModel==null){
      nourishmentManagementAddRadioModel = new ACListModelAdapter();
      addNourishmentManagementAddRadioModel();
    }
    return nourishmentManagementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNourishmentManagementAddRadioItem1(){
    if(nourishmentManagementAddRadioItem1==null){

      nourishmentManagementAddRadioItem1 = new ACRadioButtonItem();

      nourishmentManagementAddRadioItem1.setText("�Ȃ�");

      nourishmentManagementAddRadioItem1.setGroup(getNourishmentManagementAddRadio());

      nourishmentManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNourishmentManagementAddRadioItem1();
    }
    return nourishmentManagementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNourishmentManagementAddRadioItem2(){
    if(nourishmentManagementAddRadioItem2==null){

      nourishmentManagementAddRadioItem2 = new ACRadioButtonItem();

      nourishmentManagementAddRadioItem2.setText("����");

      nourishmentManagementAddRadioItem2.setGroup(getNourishmentManagementAddRadio());

      nourishmentManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNourishmentManagementAddRadioItem2();
    }
    return nourishmentManagementAddRadioItem2;

  }

  /**
   * ���o�@�\������Z���擾���܂��B
   * @return ���o�@�\������Z
   */
  public ACClearableRadioButtonGroup getOralFunctionAddRadio(){
    if(oralFunctionAddRadio==null){

      oralFunctionAddRadio = new ACClearableRadioButtonGroup();

      getOralFunctionAddRadioContainer().setText("���o�@�\������Z");

      oralFunctionAddRadio.setBindPath("1740108");

      oralFunctionAddRadio.setUseClearButton(false);

      oralFunctionAddRadio.setModel(getOralFunctionAddRadioModel());

      addOralFunctionAddRadio();
    }
    return oralFunctionAddRadio;

  }

  /**
   * ���o�@�\������Z�R���e�i���擾���܂��B
   * @return ���o�@�\������Z�R���e�i
   */
  protected ACLabelContainer getOralFunctionAddRadioContainer(){
    if(oralFunctionAddRadioContainer==null){
      oralFunctionAddRadioContainer = new ACLabelContainer();
      oralFunctionAddRadioContainer.setFollowChildEnabled(true);
      oralFunctionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      oralFunctionAddRadioContainer.add(getOralFunctionAddRadio(), null);
    }
    return oralFunctionAddRadioContainer;
  }

  /**
   * ���o�@�\������Z���f�����擾���܂��B
   * @return ���o�@�\������Z���f��
   */
  protected ACListModelAdapter getOralFunctionAddRadioModel(){
    if(oralFunctionAddRadioModel==null){
      oralFunctionAddRadioModel = new ACListModelAdapter();
      addOralFunctionAddRadioModel();
    }
    return oralFunctionAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getOralFunctionAddRadioItem1(){
    if(oralFunctionAddRadioItem1==null){

      oralFunctionAddRadioItem1 = new ACRadioButtonItem();

      oralFunctionAddRadioItem1.setText("�Ȃ�");

      oralFunctionAddRadioItem1.setGroup(getOralFunctionAddRadio());

      oralFunctionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOralFunctionAddRadioItem1();
    }
    return oralFunctionAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getOralFunctionAddRadioItem2(){
    if(oralFunctionAddRadioItem2==null){

      oralFunctionAddRadioItem2 = new ACRadioButtonItem();

      oralFunctionAddRadioItem2.setText("����");

      oralFunctionAddRadioItem2.setGroup(getOralFunctionAddRadio());

      oralFunctionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOralFunctionAddRadioItem2();
    }
    return oralFunctionAddRadioItem2;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getTimeContena(){
    if(timeContena==null){

      timeContena = new ACBackLabelContainer();

      addTimeContena();
    }
    return timeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getBeginTime(){
    if(beginTime==null){

      beginTime = new ACTimeComboBox();

      getBeginTimeContainer().setText("�J�n����");

      beginTime.setBindPath("3");

      beginTime.setModelBindPath("3");

      beginTime.setRenderBindPath("CONTENT");

      beginTime.setModel(getBeginTimeModel());

      addBeginTime();
    }
    return beginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getBeginTimeContainer(){
    if(beginTimeContainer==null){
      beginTimeContainer = new ACLabelContainer();
      beginTimeContainer.setFollowChildEnabled(true);
      beginTimeContainer.setVAlignment(VRLayout.CENTER);
      beginTimeContainer.add(getBeginTime(), null);
    }
    return beginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getBeginTimeModel(){
    if(beginTimeModel==null){
      beginTimeModel = new ACComboBoxModelAdapter();
      addBeginTimeModel();
    }
    return beginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getEndTime(){
    if(endTime==null){

      endTime = new ACTimeComboBox();

      getEndTimeContainer().setText("�I������");

      endTime.setBindPath("4");

      endTime.setModelBindPath("4");

      endTime.setRenderBindPath("CONTENT");

      endTime.setModel(getEndTimeModel());

      addEndTime();
    }
    return endTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getEndTimeContainer(){
    if(endTimeContainer==null){
      endTimeContainer = new ACLabelContainer();
      endTimeContainer.setFollowChildEnabled(true);
      endTimeContainer.setVAlignment(VRLayout.CENTER);
      endTimeContainer.add(getEndTime(), null);
    }
    return endTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getEndTimeModel(){
    if(endTimeModel==null){
      endTimeModel = new ACComboBoxModelAdapter();
      addEndTimeModel();
    }
    return endTimeModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001146Design() {

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

    this.add(getNinchisyoTaioTusyoPatterns(), VRLayout.CLIENT);

  }

  /**
   * �F�m�ǑΉ��^�ʏ����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNinchisyoTaioTusyoPatterns(){

    ninchisyoTaioTusyoPatterns.add(getProviderDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchisyoTaioTusyoPatterns.add(getDivisionRadionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchisyoTaioTusyoPatterns.add(getTimeDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchisyoTaioTusyoPatterns.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchisyoTaioTusyoPatterns.add(getBathCareAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchisyoTaioTusyoPatterns.add(getFunctionTrainingAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchisyoTaioTusyoPatterns.add(getNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchisyoTaioTusyoPatterns.add(getOralFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    ninchisyoTaioTusyoPatterns.add(getTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadio(){

  }

  /**
   * �{�ݓ��̋敪1���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioModel(){

    getProviderDivisionRadioItem1().setButtonIndex(1);
    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem1());

    getProviderDivisionRadioItem2().setButtonIndex(2);
    getProviderDivisionRadioModel().add(getProviderDivisionRadioItem2());

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioItem1(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderDivisionRadioItem2(){

  }

  /**
   * �{�ݓ��̋敪2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadion(){

  }

  /**
   * �{�ݓ��̋敪2���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadionModel(){

    getDivisionRadionitem1().setButtonIndex(1);
    getDivisionRadionModel().add(getDivisionRadionitem1());

    getDivisionRadionitem2().setButtonIndex(2);
    getDivisionRadionModel().add(getDivisionRadionitem2());

  }

  /**
   * �P�ƌ^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadionitem1(){

  }

  /**
   * ���݌^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDivisionRadionitem2(){

  }

  /**
   * ���ԋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadio(){

  }

  /**
   * ���ԋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioModel(){

    getTimeDivisionRadioItem1().setButtonIndex(1);
    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem1());

    getTimeDivisionRadioItem2().setButtonIndex(2);
    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem2());

    getTimeDivisionRadioItem3().setButtonIndex(3);
    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem3());

    getTimeDivisionRadioItem4().setButtonIndex(4);
    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem4());

    getTimeDivisionRadioItem5().setButtonIndex(5);
    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem5());

    getTimeDivisionRadioItem6().setButtonIndex(6);
    getTimeDivisionRadioModel().add(getTimeDivisionRadioItem6());

  }

  /**
   * 2����3���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioItem1(){

  }

  /**
   * 3����4���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioItem2(){

  }

  /**
   * 4����6���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioItem3(){

  }

  /**
   * 6����8���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioItem4(){

  }

  /**
   * 8����9���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioItem5(){

  }

  /**
   * 9����10���Ԃɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeDivisionRadioItem6(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioModel(){

    getStaffSubtractionRadioItem1().setButtonIndex(1);
    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem1());

    getStaffSubtractionRadioItem2().setButtonIndex(2);
    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem2());

    getStaffSubtractionRadioItem3().setButtonIndex(3);
    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem2(){

  }

  /**
   * �Ō쥉��E���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem3(){

  }

  /**
   * ��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathCareAddRadio(){

  }

  /**
   * ��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathCareAddRadioModel(){

    getBathCareAddRadioItem1().setButtonIndex(1);
    getBathCareAddRadioModel().add(getBathCareAddRadioItem1());

    getBathCareAddRadioItem2().setButtonIndex(2);
    getBathCareAddRadioModel().add(getBathCareAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathCareAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathCareAddRadioItem2(){

  }

  /**
   * �ʋ@�\�P�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingAddRadio(){

  }

  /**
   * �ʋ@�\�P�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingAddRadioModel(){

    getFunctionTrainingAddRadioItem1().setButtonIndex(1);
    getFunctionTrainingAddRadioModel().add(getFunctionTrainingAddRadioItem1());

    getFunctionTrainingAddRadioItem2().setButtonIndex(2);
    getFunctionTrainingAddRadioModel().add(getFunctionTrainingAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFunctionTrainingAddRadioItem2(){

  }

  /**
   * �h�{���P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAddRadio(){

  }

  /**
   * �h�{���P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAddRadioModel(){

    getNourishmentManagementAddRadioItem1().setButtonIndex(1);
    getNourishmentManagementAddRadioModel().add(getNourishmentManagementAddRadioItem1());

    getNourishmentManagementAddRadioItem2().setButtonIndex(2);
    getNourishmentManagementAddRadioModel().add(getNourishmentManagementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAddRadioItem2(){

  }

  /**
   * ���o�@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralFunctionAddRadio(){

  }

  /**
   * ���o�@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralFunctionAddRadioModel(){

    getOralFunctionAddRadioItem1().setButtonIndex(1);
    getOralFunctionAddRadioModel().add(getOralFunctionAddRadioItem1());

    getOralFunctionAddRadioItem2().setButtonIndex(2);
    getOralFunctionAddRadioModel().add(getOralFunctionAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralFunctionAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addOralFunctionAddRadioItem2(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTimeContena(){

    timeContena.add(getBeginTimeContainer(), VRLayout.FLOW);

    timeContena.add(getEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001146Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001146Design getThis() {
    return this;
  }
}
