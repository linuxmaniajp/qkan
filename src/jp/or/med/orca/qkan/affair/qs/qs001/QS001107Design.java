
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
 * �쐬��: 2006/03/09  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���ʏ���� (QS001107)
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
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;
/**
 * �T�[�r�X�p�^�[���ʏ�����ʍ��ڃf�U�C��(QS001107) 
 */
public class QS001107Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel tsuusyoKaigoPatterns;

  private ACLabelContainer tsuusyoKaigoFacilitiesDivisionContainer;

  private ACClearableRadioButtonGroup tsuusyoKaigoTimeContenaFacilityDivision;

  private ACListModelAdapter tsuusyoKaigoTimeContenaFacilityDivisionModel;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem1;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem2;

  private ACRadioButtonItem tsuusyoKaigoTimeContenaFacilityDivisionItem3;

  private ACIntegerCheckBox tsuusyoKaigoDementiaLargeCheck;

  private ACComboBox tsuusyoKaigoTimeDivision;

  private ACLabelContainer tsuusyoKaigoTimeDivisionContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeDivisionModel;

  private ACClearableRadioButtonGroup tsuusyoKaigoAdditionFunctionTrainingRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionTrainingRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionTrainingRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  private ACClearableRadioButtonGroup tsuusyoKaigoAdditionFunctionBathRadio;

  private ACLabelContainer tsuusyoKaigoAdditionFunctionBathRadioContainer;

  private ACListModelAdapter tsuusyoKaigoAdditionFunctionBathRadioModel;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoAdditionFunctionBathRadioItem2;

  private ACClearableRadioButtonGroup tsuusyoKaigoSubtraction;

  private ACLabelContainer tsuusyoKaigoSubtractionContainer;

  private ACListModelAdapter tsuusyoKaigoSubtractionModel;

  private ACRadioButtonItem tsuusyoKaigoSubtractionNot;

  private ACRadioButtonItem tsuusyoKaigoSubtractionExcess;

  private ACRadioButtonItem tsuusyoKaigoSubtractionLack;

  private ACClearableRadioButtonGroup tsuusyoKaigoYouthNinchishoAddRadio;

  private ACLabelContainer tsuusyoKaigoYouthNinchishoAddRadioContainer;

  private ACListModelAdapter tsuusyoKaigoYouthNinchishoAddRadioModel;

  private ACRadioButtonItem tsuusyoKaigoYouthNinchishoAddRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoYouthNinchishoAddRadioItem2;

  private ACClearableRadioButtonGroup tsuusyoKaigoNourishmentManagementAddRadio;

  private ACLabelContainer tsuusyoKaigoNourishmentManagementAddRadioContainer;

  private ACListModelAdapter tsuusyoKaigoNourishmentManagementAddRadioModel;

  private ACRadioButtonItem tsuusyoKaigoNourishmentManagementAddRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoNourishmentManagementAddRadioItem2;

  private ACClearableRadioButtonGroup tsuusyoKaigoMouthFunctionAddRadio;

  private ACLabelContainer tsuusyoKaigoMouthFunctionAddRadioContainer;

  private ACListModelAdapter tsuusyoKaigoMouthFunctionAddRadioModel;

  private ACRadioButtonItem tsuusyoKaigoMouthFunctionAddRadioItem1;

  private ACRadioButtonItem tsuusyoKaigoMouthFunctionAddRadioItem2;

  private ACBackLabelContainer tsuusyoKaigoTimeContena;

  private ACTimeComboBox tsuusyoKaigoTimeBeginTime;

  private ACLabelContainer tsuusyoKaigoTimeBeginTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeBeginTimeModel;

  private ACTimeComboBox tsuusyoKaigoTimeEndTime;

  private ACLabelContainer tsuusyoKaigoTimeEndTimeContainer;

  private ACComboBoxModelAdapter tsuusyoKaigoTimeEndTimeModel;

  //getter

  /**
   * �ʏ����p�^�[���̈���擾���܂��B
   * @return �ʏ����p�^�[���̈�
   */
  public ACPanel getTsuusyoKaigoPatterns(){
    if(tsuusyoKaigoPatterns==null){

      tsuusyoKaigoPatterns = new ACPanel();

      tsuusyoKaigoPatterns.setHgap(0);

      tsuusyoKaigoPatterns.setHgrid(200);

      addTsuusyoKaigoPatterns();
    }
    return tsuusyoKaigoPatterns;

  }

  /**
   * �{�ݓ��̋敪�R���e�i���擾���܂��B
   * @return �{�ݓ��̋敪�R���e�i
   */
  public ACLabelContainer getTsuusyoKaigoFacilitiesDivisionContainer(){
    if(tsuusyoKaigoFacilitiesDivisionContainer==null){

      tsuusyoKaigoFacilitiesDivisionContainer = new ACLabelContainer();

      tsuusyoKaigoFacilitiesDivisionContainer.setText("�{�ݓ��̋敪");

      addTsuusyoKaigoFacilitiesDivisionContainer();
    }
    return tsuusyoKaigoFacilitiesDivisionContainer;

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v���擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoTimeContenaFacilityDivision(){
    if(tsuusyoKaigoTimeContenaFacilityDivision==null){

      tsuusyoKaigoTimeContenaFacilityDivision = new ACClearableRadioButtonGroup();

      tsuusyoKaigoTimeContenaFacilityDivision.setBindPath("1150103");

      tsuusyoKaigoTimeContenaFacilityDivision.setModel(getTsuusyoKaigoTimeContenaFacilityDivisionModel());

      tsuusyoKaigoTimeContenaFacilityDivision.setUseClearButton(false);

      addTsuusyoKaigoTimeContenaFacilityDivision();
    }
    return tsuusyoKaigoTimeContenaFacilityDivision;

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�ݓ��̋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoTimeContenaFacilityDivisionModel(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionModel==null){
      tsuusyoKaigoTimeContenaFacilityDivisionModel = new ACListModelAdapter();
      addTsuusyoKaigoTimeContenaFacilityDivisionModel();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionModel;
  }

  /**
   * ���K�͂��擾���܂��B
   * @return ���K��
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem1(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem1==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem1 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setText("���K��");

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem1();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem1;

  }

  /**
   * �ʏ�K�͂��擾���܂��B
   * @return �ʏ�K��
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem2(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem2==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem2 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setText("�ʏ�K��");

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem2();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem2;

  }

  /**
   * �×{�ʏ����擾���܂��B
   * @return �×{�ʏ�
   */
  public ACRadioButtonItem getTsuusyoKaigoTimeContenaFacilityDivisionItem3(){
    if(tsuusyoKaigoTimeContenaFacilityDivisionItem3==null){

      tsuusyoKaigoTimeContenaFacilityDivisionItem3 = new ACRadioButtonItem();

      tsuusyoKaigoTimeContenaFacilityDivisionItem3.setText("�×{�ʏ�");

      tsuusyoKaigoTimeContenaFacilityDivisionItem3.setGroup(getTsuusyoKaigoTimeContenaFacilityDivision());

      tsuusyoKaigoTimeContenaFacilityDivisionItem3.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoTimeContenaFacilityDivisionItem3();
    }
    return tsuusyoKaigoTimeContenaFacilityDivisionItem3;

  }

  /**
   * ��K�͎��Ə����擾���܂��B
   * @return ��K�͎��Ə�
   */
  public ACIntegerCheckBox getTsuusyoKaigoDementiaLargeCheck(){
    if(tsuusyoKaigoDementiaLargeCheck==null){

      tsuusyoKaigoDementiaLargeCheck = new ACIntegerCheckBox();

      tsuusyoKaigoDementiaLargeCheck.setText("��K�͎��Ə�");

      tsuusyoKaigoDementiaLargeCheck.setBindPath("1150109");

      tsuusyoKaigoDementiaLargeCheck.setSelectValue(2);

      tsuusyoKaigoDementiaLargeCheck.setUnSelectValue(1);

      addTsuusyoKaigoDementiaLargeCheck();
    }
    return tsuusyoKaigoDementiaLargeCheck;

  }

  /**
   * ���ԋ敪���擾���܂��B
   * @return ���ԋ敪
   */
  public ACComboBox getTsuusyoKaigoTimeDivision(){
    if(tsuusyoKaigoTimeDivision==null){

      tsuusyoKaigoTimeDivision = new ACComboBox();

      getTsuusyoKaigoTimeDivisionContainer().setText("���ԋ敪");

      tsuusyoKaigoTimeDivision.setBindPath("1150104");

      tsuusyoKaigoTimeDivision.setEditable(false);

      tsuusyoKaigoTimeDivision.setModelBindPath("1150104");

      tsuusyoKaigoTimeDivision.setModel(getTsuusyoKaigoTimeDivisionModel());

      tsuusyoKaigoTimeDivision.setRenderBindPath("CONTENT");

      addTsuusyoKaigoTimeDivision();
    }
    return tsuusyoKaigoTimeDivision;

  }

  /**
   * ���ԋ敪�R���e�i���擾���܂��B
   * @return ���ԋ敪�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoTimeDivisionContainer(){
    if(tsuusyoKaigoTimeDivisionContainer==null){
      tsuusyoKaigoTimeDivisionContainer = new ACLabelContainer();
      tsuusyoKaigoTimeDivisionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeDivisionContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeDivisionContainer.add(getTsuusyoKaigoTimeDivision(), null);
    }
    return tsuusyoKaigoTimeDivisionContainer;
  }

  /**
   * ���ԋ敪���f�����擾���܂��B
   * @return ���ԋ敪���f��
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeDivisionModel(){
    if(tsuusyoKaigoTimeDivisionModel==null){
      tsuusyoKaigoTimeDivisionModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeDivisionModel();
    }
    return tsuusyoKaigoTimeDivisionModel;
  }

  /**
   * �ʋ@�\�P���w�����Z���擾���܂��B
   * @return �ʋ@�\�P���w�����Z
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoAdditionFunctionTrainingRadio(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadio==null){

      tsuusyoKaigoAdditionFunctionTrainingRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionTrainingRadioContainer().setText("�ʋ@�\�P���w�����Z");

      tsuusyoKaigoAdditionFunctionTrainingRadio.setBindPath("1150105");

      tsuusyoKaigoAdditionFunctionTrainingRadio.setModel(getTsuusyoKaigoAdditionFunctionTrainingRadioModel());

      tsuusyoKaigoAdditionFunctionTrainingRadio.setUseClearButton(false);

      addTsuusyoKaigoAdditionFunctionTrainingRadio();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadio;

  }

  /**
   * �ʋ@�\�P���w�����Z�R���e�i���擾���܂��B
   * @return �ʋ@�\�P���w�����Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoAdditionFunctionTrainingRadioContainer(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioContainer==null){
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer = new ACLabelContainer();
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoAdditionFunctionTrainingRadioContainer.add(getTsuusyoKaigoAdditionFunctionTrainingRadio(), null);
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioContainer;
  }

  /**
   * �ʋ@�\�P���w�����Z���f�����擾���܂��B
   * @return �ʋ@�\�P���w�����Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoAdditionFunctionTrainingRadioModel(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioModel==null){
      tsuusyoKaigoAdditionFunctionTrainingRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoAdditionFunctionTrainingRadioModel();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem1==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setText("�Ȃ�");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setGroup(getTsuusyoKaigoAdditionFunctionTrainingRadio());

      tsuusyoKaigoAdditionFunctionTrainingRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionTrainingRadioItem2==null){

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setText("����");

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setGroup(getTsuusyoKaigoAdditionFunctionTrainingRadio());

      tsuusyoKaigoAdditionFunctionTrainingRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionTrainingRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionTrainingRadioItem2;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoAdditionFunctionBathRadio(){
    if(tsuusyoKaigoAdditionFunctionBathRadio==null){

      tsuusyoKaigoAdditionFunctionBathRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoAdditionFunctionBathRadioContainer().setText("�������Z");

      tsuusyoKaigoAdditionFunctionBathRadio.setBindPath("1150106");

      tsuusyoKaigoAdditionFunctionBathRadio.setModel(getTsuusyoKaigoAdditionFunctionBathRadioModel());

      tsuusyoKaigoAdditionFunctionBathRadio.setUseClearButton(false);

      addTsuusyoKaigoAdditionFunctionBathRadio();
    }
    return tsuusyoKaigoAdditionFunctionBathRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoAdditionFunctionBathRadioContainer(){
    if(tsuusyoKaigoAdditionFunctionBathRadioContainer==null){
      tsuusyoKaigoAdditionFunctionBathRadioContainer = new ACLabelContainer();
      tsuusyoKaigoAdditionFunctionBathRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoAdditionFunctionBathRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoAdditionFunctionBathRadioContainer.add(getTsuusyoKaigoAdditionFunctionBathRadio(), null);
    }
    return tsuusyoKaigoAdditionFunctionBathRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoAdditionFunctionBathRadioModel(){
    if(tsuusyoKaigoAdditionFunctionBathRadioModel==null){
      tsuusyoKaigoAdditionFunctionBathRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoAdditionFunctionBathRadioModel();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem1(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem1==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setText("�Ȃ�");

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem1();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyoKaigoAdditionFunctionBathRadioItem2(){
    if(tsuusyoKaigoAdditionFunctionBathRadioItem2==null){

      tsuusyoKaigoAdditionFunctionBathRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setText("����");

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setGroup(getTsuusyoKaigoAdditionFunctionBathRadio());

      tsuusyoKaigoAdditionFunctionBathRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoAdditionFunctionBathRadioItem2();
    }
    return tsuusyoKaigoAdditionFunctionBathRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoSubtraction(){
    if(tsuusyoKaigoSubtraction==null){

      tsuusyoKaigoSubtraction = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoSubtractionContainer().setText("�l�����Z");

      tsuusyoKaigoSubtraction.setBindPath("1150108");

      tsuusyoKaigoSubtraction.setModel(getTsuusyoKaigoSubtractionModel());

      tsuusyoKaigoSubtraction.setUseClearButton(false);

      addTsuusyoKaigoSubtraction();
    }
    return tsuusyoKaigoSubtraction;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoSubtractionContainer(){
    if(tsuusyoKaigoSubtractionContainer==null){
      tsuusyoKaigoSubtractionContainer = new ACLabelContainer();
      tsuusyoKaigoSubtractionContainer.setFollowChildEnabled(true);
      tsuusyoKaigoSubtractionContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoSubtractionContainer.add(getTsuusyoKaigoSubtraction(), null);
    }
    return tsuusyoKaigoSubtractionContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoSubtractionModel(){
    if(tsuusyoKaigoSubtractionModel==null){
      tsuusyoKaigoSubtractionModel = new ACListModelAdapter();
      addTsuusyoKaigoSubtractionModel();
    }
    return tsuusyoKaigoSubtractionModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionNot(){
    if(tsuusyoKaigoSubtractionNot==null){

      tsuusyoKaigoSubtractionNot = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionNot.setText("�Ȃ�");

      tsuusyoKaigoSubtractionNot.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionNot.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSubtractionNot();
    }
    return tsuusyoKaigoSubtractionNot;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionExcess(){
    if(tsuusyoKaigoSubtractionExcess==null){

      tsuusyoKaigoSubtractionExcess = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionExcess.setText("�������");

      tsuusyoKaigoSubtractionExcess.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionExcess.setConstraints(VRLayout.FLOW_RETURN);

      addTsuusyoKaigoSubtractionExcess();
    }
    return tsuusyoKaigoSubtractionExcess;

  }

  /**
   * �Ō�E���E���̕s�����擾���܂��B
   * @return �Ō�E���E���̕s��
   */
  public ACRadioButtonItem getTsuusyoKaigoSubtractionLack(){
    if(tsuusyoKaigoSubtractionLack==null){

      tsuusyoKaigoSubtractionLack = new ACRadioButtonItem();

      tsuusyoKaigoSubtractionLack.setText("�Ō�E���E���̕s��");

      tsuusyoKaigoSubtractionLack.setGroup(getTsuusyoKaigoSubtraction());

      tsuusyoKaigoSubtractionLack.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoSubtractionLack();
    }
    return tsuusyoKaigoSubtractionLack;

  }

  /**
   * ��N���F�m�ǃP�A���Z���擾���܂��B
   * @return ��N���F�m�ǃP�A���Z
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoYouthNinchishoAddRadio(){
    if(tsuusyoKaigoYouthNinchishoAddRadio==null){

      tsuusyoKaigoYouthNinchishoAddRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoYouthNinchishoAddRadioContainer().setText("��N���F�m�ǃP�A���Z");

      tsuusyoKaigoYouthNinchishoAddRadio.setBindPath("1150110");

      tsuusyoKaigoYouthNinchishoAddRadio.setModel(getTsuusyoKaigoYouthNinchishoAddRadioModel());

      tsuusyoKaigoYouthNinchishoAddRadio.setUseClearButton(false);

      addTsuusyoKaigoYouthNinchishoAddRadio();
    }
    return tsuusyoKaigoYouthNinchishoAddRadio;

  }

  /**
   * ��N���F�m�ǃP�A���Z�R���e�i���擾���܂��B
   * @return ��N���F�m�ǃP�A���Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoYouthNinchishoAddRadioContainer(){
    if(tsuusyoKaigoYouthNinchishoAddRadioContainer==null){
      tsuusyoKaigoYouthNinchishoAddRadioContainer = new ACLabelContainer();
      tsuusyoKaigoYouthNinchishoAddRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoYouthNinchishoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoYouthNinchishoAddRadioContainer.add(getTsuusyoKaigoYouthNinchishoAddRadio(), null);
    }
    return tsuusyoKaigoYouthNinchishoAddRadioContainer;
  }

  /**
   * ��N���F�m�ǃP�A���Z���f�����擾���܂��B
   * @return ��N���F�m�ǃP�A���Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoYouthNinchishoAddRadioModel(){
    if(tsuusyoKaigoYouthNinchishoAddRadioModel==null){
      tsuusyoKaigoYouthNinchishoAddRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoYouthNinchishoAddRadioModel();
    }
    return tsuusyoKaigoYouthNinchishoAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoYouthNinchishoAddRadioItem1(){
    if(tsuusyoKaigoYouthNinchishoAddRadioItem1==null){

      tsuusyoKaigoYouthNinchishoAddRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoYouthNinchishoAddRadioItem1.setText("�Ȃ�");

      tsuusyoKaigoYouthNinchishoAddRadioItem1.setGroup(getTsuusyoKaigoYouthNinchishoAddRadio());

      tsuusyoKaigoYouthNinchishoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoYouthNinchishoAddRadioItem1();
    }
    return tsuusyoKaigoYouthNinchishoAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyoKaigoYouthNinchishoAddRadioItem2(){
    if(tsuusyoKaigoYouthNinchishoAddRadioItem2==null){

      tsuusyoKaigoYouthNinchishoAddRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoYouthNinchishoAddRadioItem2.setText("����");

      tsuusyoKaigoYouthNinchishoAddRadioItem2.setGroup(getTsuusyoKaigoYouthNinchishoAddRadio());

      tsuusyoKaigoYouthNinchishoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoYouthNinchishoAddRadioItem2();
    }
    return tsuusyoKaigoYouthNinchishoAddRadioItem2;

  }

  /**
   * �h�{�}�l�W�����g���Z���擾���܂��B
   * @return �h�{�}�l�W�����g���Z
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoNourishmentManagementAddRadio(){
    if(tsuusyoKaigoNourishmentManagementAddRadio==null){

      tsuusyoKaigoNourishmentManagementAddRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoNourishmentManagementAddRadioContainer().setText("�h�{�}�l�W�����g���Z");

      tsuusyoKaigoNourishmentManagementAddRadio.setBindPath("1150111");

      tsuusyoKaigoNourishmentManagementAddRadio.setModel(getTsuusyoKaigoNourishmentManagementAddRadioModel());

      tsuusyoKaigoNourishmentManagementAddRadio.setUseClearButton(false);

      addTsuusyoKaigoNourishmentManagementAddRadio();
    }
    return tsuusyoKaigoNourishmentManagementAddRadio;

  }

  /**
   * �h�{�}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoNourishmentManagementAddRadioContainer(){
    if(tsuusyoKaigoNourishmentManagementAddRadioContainer==null){
      tsuusyoKaigoNourishmentManagementAddRadioContainer = new ACLabelContainer();
      tsuusyoKaigoNourishmentManagementAddRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoNourishmentManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoNourishmentManagementAddRadioContainer.add(getTsuusyoKaigoNourishmentManagementAddRadio(), null);
    }
    return tsuusyoKaigoNourishmentManagementAddRadioContainer;
  }

  /**
   * �h�{�}�l�W�����g���Z���f�����擾���܂��B
   * @return �h�{�}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoNourishmentManagementAddRadioModel(){
    if(tsuusyoKaigoNourishmentManagementAddRadioModel==null){
      tsuusyoKaigoNourishmentManagementAddRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoNourishmentManagementAddRadioModel();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoNourishmentManagementAddRadioItem1(){
    if(tsuusyoKaigoNourishmentManagementAddRadioItem1==null){

      tsuusyoKaigoNourishmentManagementAddRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setText("�Ȃ�");

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setGroup(getTsuusyoKaigoNourishmentManagementAddRadio());

      tsuusyoKaigoNourishmentManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoNourishmentManagementAddRadioItem1();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyoKaigoNourishmentManagementAddRadioItem2(){
    if(tsuusyoKaigoNourishmentManagementAddRadioItem2==null){

      tsuusyoKaigoNourishmentManagementAddRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setText("����");

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setGroup(getTsuusyoKaigoNourishmentManagementAddRadio());

      tsuusyoKaigoNourishmentManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoNourishmentManagementAddRadioItem2();
    }
    return tsuusyoKaigoNourishmentManagementAddRadioItem2;

  }

  /**
   * ���o�@�\������Z���擾���܂��B
   * @return ���o�@�\������Z
   */
  public ACClearableRadioButtonGroup getTsuusyoKaigoMouthFunctionAddRadio(){
    if(tsuusyoKaigoMouthFunctionAddRadio==null){

      tsuusyoKaigoMouthFunctionAddRadio = new ACClearableRadioButtonGroup();

      getTsuusyoKaigoMouthFunctionAddRadioContainer().setText("���o�@�\������Z");

      tsuusyoKaigoMouthFunctionAddRadio.setBindPath("1150112");

      tsuusyoKaigoMouthFunctionAddRadio.setModel(getTsuusyoKaigoMouthFunctionAddRadioModel());

      tsuusyoKaigoMouthFunctionAddRadio.setUseClearButton(false);

      addTsuusyoKaigoMouthFunctionAddRadio();
    }
    return tsuusyoKaigoMouthFunctionAddRadio;

  }

  /**
   * ���o�@�\������Z�R���e�i���擾���܂��B
   * @return ���o�@�\������Z�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoMouthFunctionAddRadioContainer(){
    if(tsuusyoKaigoMouthFunctionAddRadioContainer==null){
      tsuusyoKaigoMouthFunctionAddRadioContainer = new ACLabelContainer();
      tsuusyoKaigoMouthFunctionAddRadioContainer.setFollowChildEnabled(true);
      tsuusyoKaigoMouthFunctionAddRadioContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoMouthFunctionAddRadioContainer.add(getTsuusyoKaigoMouthFunctionAddRadio(), null);
    }
    return tsuusyoKaigoMouthFunctionAddRadioContainer;
  }

  /**
   * ���o�@�\������Z���f�����擾���܂��B
   * @return ���o�@�\������Z���f��
   */
  protected ACListModelAdapter getTsuusyoKaigoMouthFunctionAddRadioModel(){
    if(tsuusyoKaigoMouthFunctionAddRadioModel==null){
      tsuusyoKaigoMouthFunctionAddRadioModel = new ACListModelAdapter();
      addTsuusyoKaigoMouthFunctionAddRadioModel();
    }
    return tsuusyoKaigoMouthFunctionAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getTsuusyoKaigoMouthFunctionAddRadioItem1(){
    if(tsuusyoKaigoMouthFunctionAddRadioItem1==null){

      tsuusyoKaigoMouthFunctionAddRadioItem1 = new ACRadioButtonItem();

      tsuusyoKaigoMouthFunctionAddRadioItem1.setText("�Ȃ�");

      tsuusyoKaigoMouthFunctionAddRadioItem1.setGroup(getTsuusyoKaigoMouthFunctionAddRadio());

      tsuusyoKaigoMouthFunctionAddRadioItem1.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMouthFunctionAddRadioItem1();
    }
    return tsuusyoKaigoMouthFunctionAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getTsuusyoKaigoMouthFunctionAddRadioItem2(){
    if(tsuusyoKaigoMouthFunctionAddRadioItem2==null){

      tsuusyoKaigoMouthFunctionAddRadioItem2 = new ACRadioButtonItem();

      tsuusyoKaigoMouthFunctionAddRadioItem2.setText("����");

      tsuusyoKaigoMouthFunctionAddRadioItem2.setGroup(getTsuusyoKaigoMouthFunctionAddRadio());

      tsuusyoKaigoMouthFunctionAddRadioItem2.setConstraints(VRLayout.FLOW);

      addTsuusyoKaigoMouthFunctionAddRadioItem2();
    }
    return tsuusyoKaigoMouthFunctionAddRadioItem2;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getTsuusyoKaigoTimeContena(){
    if(tsuusyoKaigoTimeContena==null){

      tsuusyoKaigoTimeContena = new ACBackLabelContainer();

      addTsuusyoKaigoTimeContena();
    }
    return tsuusyoKaigoTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getTsuusyoKaigoTimeBeginTime(){
    if(tsuusyoKaigoTimeBeginTime==null){

      tsuusyoKaigoTimeBeginTime = new ACTimeComboBox();

      getTsuusyoKaigoTimeBeginTimeContainer().setText("�J�n����");

      tsuusyoKaigoTimeBeginTime.setBindPath("3");

      tsuusyoKaigoTimeBeginTime.setModelBindPath("3");

      tsuusyoKaigoTimeBeginTime.setModel(getTsuusyoKaigoTimeBeginTimeModel());

      tsuusyoKaigoTimeBeginTime.setRenderBindPath("CONTENT");

      addTsuusyoKaigoTimeBeginTime();
    }
    return tsuusyoKaigoTimeBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoTimeBeginTimeContainer(){
    if(tsuusyoKaigoTimeBeginTimeContainer==null){
      tsuusyoKaigoTimeBeginTimeContainer = new ACLabelContainer();
      tsuusyoKaigoTimeBeginTimeContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeBeginTimeContainer.add(getTsuusyoKaigoTimeBeginTime(), null);
    }
    return tsuusyoKaigoTimeBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeBeginTimeModel(){
    if(tsuusyoKaigoTimeBeginTimeModel==null){
      tsuusyoKaigoTimeBeginTimeModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeBeginTimeModel();
    }
    return tsuusyoKaigoTimeBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getTsuusyoKaigoTimeEndTime(){
    if(tsuusyoKaigoTimeEndTime==null){

      tsuusyoKaigoTimeEndTime = new ACTimeComboBox();

      getTsuusyoKaigoTimeEndTimeContainer().setText("�I������");

      tsuusyoKaigoTimeEndTime.setBindPath("4");

      tsuusyoKaigoTimeEndTime.setModelBindPath("4");

      tsuusyoKaigoTimeEndTime.setModel(getTsuusyoKaigoTimeEndTimeModel());

      tsuusyoKaigoTimeEndTime.setRenderBindPath("CONTENT");

      addTsuusyoKaigoTimeEndTime();
    }
    return tsuusyoKaigoTimeEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getTsuusyoKaigoTimeEndTimeContainer(){
    if(tsuusyoKaigoTimeEndTimeContainer==null){
      tsuusyoKaigoTimeEndTimeContainer = new ACLabelContainer();
      tsuusyoKaigoTimeEndTimeContainer.setFollowChildEnabled(true);
      tsuusyoKaigoTimeEndTimeContainer.setVAlignment(VRLayout.CENTER);
      tsuusyoKaigoTimeEndTimeContainer.add(getTsuusyoKaigoTimeEndTime(), null);
    }
    return tsuusyoKaigoTimeEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getTsuusyoKaigoTimeEndTimeModel(){
    if(tsuusyoKaigoTimeEndTimeModel==null){
      tsuusyoKaigoTimeEndTimeModel = new ACComboBoxModelAdapter();
      addTsuusyoKaigoTimeEndTimeModel();
    }
    return tsuusyoKaigoTimeEndTimeModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001107Design() {

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

    this.add(getTsuusyoKaigoPatterns(), VRLayout.CLIENT);

  }

  /**
   * �ʏ����p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoPatterns(){

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoTimeDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoAdditionFunctionTrainingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoAdditionFunctionBathRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoSubtractionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoYouthNinchishoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoNourishmentManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoMouthFunctionAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoPatterns.add(getTsuusyoKaigoTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �{�ݓ��̋敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoFacilitiesDivisionContainer(){

    tsuusyoKaigoFacilitiesDivisionContainer.add(getTsuusyoKaigoTimeContenaFacilityDivision(), VRLayout.FLOW_INSETLINE_RETURN);

    tsuusyoKaigoFacilitiesDivisionContainer.add(getTsuusyoKaigoDementiaLargeCheck(), VRLayout.FLOW);

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivision(){

  }

  /**
   * �{�ݓ��̋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionModel(){

    getTsuusyoKaigoTimeContenaFacilityDivisionItem1().setButtonIndex(1);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem1());

    getTsuusyoKaigoTimeContenaFacilityDivisionItem2().setButtonIndex(2);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem2());

    getTsuusyoKaigoTimeContenaFacilityDivisionItem3().setButtonIndex(3);
    getTsuusyoKaigoTimeContenaFacilityDivisionModel().add(getTsuusyoKaigoTimeContenaFacilityDivisionItem3());

  }

  /**
   * ���K�͂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem1(){

  }

  /**
   * �ʏ�K�͂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem2(){

  }

  /**
   * �×{�ʏ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContenaFacilityDivisionItem3(){

  }

  /**
   * ��K�͎��Ə��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoDementiaLargeCheck(){

  }

  /**
   * ���ԋ敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeDivision(){

  }

  /**
   * ���ԋ敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeDivisionModel(){

  }

  /**
   * �ʋ@�\�P���w�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadio(){

  }

  /**
   * �ʋ@�\�P���w�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioModel(){

    getTsuusyoKaigoAdditionFunctionTrainingRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoAdditionFunctionTrainingRadioModel().add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem1());

    getTsuusyoKaigoAdditionFunctionTrainingRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoAdditionFunctionTrainingRadioModel().add(getTsuusyoKaigoAdditionFunctionTrainingRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionTrainingRadioItem2(){

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioModel(){

    getTsuusyoKaigoAdditionFunctionBathRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem1());

    getTsuusyoKaigoAdditionFunctionBathRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoAdditionFunctionBathRadioModel().add(getTsuusyoKaigoAdditionFunctionBathRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoAdditionFunctionBathRadioItem2(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSubtraction(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSubtractionModel(){

    getTsuusyoKaigoSubtractionNot().setButtonIndex(1);
    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionNot());

    getTsuusyoKaigoSubtractionExcess().setButtonIndex(2);
    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionExcess());

    getTsuusyoKaigoSubtractionLack().setButtonIndex(3);
    getTsuusyoKaigoSubtractionModel().add(getTsuusyoKaigoSubtractionLack());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSubtractionNot(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSubtractionExcess(){

  }

  /**
   * �Ō�E���E���̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoSubtractionLack(){

  }

  /**
   * ��N���F�m�ǃP�A���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoYouthNinchishoAddRadio(){

  }

  /**
   * ��N���F�m�ǃP�A���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoYouthNinchishoAddRadioModel(){

    getTsuusyoKaigoYouthNinchishoAddRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoYouthNinchishoAddRadioModel().add(getTsuusyoKaigoYouthNinchishoAddRadioItem1());

    getTsuusyoKaigoYouthNinchishoAddRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoYouthNinchishoAddRadioModel().add(getTsuusyoKaigoYouthNinchishoAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoYouthNinchishoAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoYouthNinchishoAddRadioItem2(){

  }

  /**
   * �h�{�}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadio(){

  }

  /**
   * �h�{�}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioModel(){

    getTsuusyoKaigoNourishmentManagementAddRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoNourishmentManagementAddRadioModel().add(getTsuusyoKaigoNourishmentManagementAddRadioItem1());

    getTsuusyoKaigoNourishmentManagementAddRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoNourishmentManagementAddRadioModel().add(getTsuusyoKaigoNourishmentManagementAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoNourishmentManagementAddRadioItem2(){

  }

  /**
   * ���o�@�\������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadio(){

  }

  /**
   * ���o�@�\������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioModel(){

    getTsuusyoKaigoMouthFunctionAddRadioItem1().setButtonIndex(1);
    getTsuusyoKaigoMouthFunctionAddRadioModel().add(getTsuusyoKaigoMouthFunctionAddRadioItem1());

    getTsuusyoKaigoMouthFunctionAddRadioItem2().setButtonIndex(2);
    getTsuusyoKaigoMouthFunctionAddRadioModel().add(getTsuusyoKaigoMouthFunctionAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoMouthFunctionAddRadioItem2(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeContena(){

    tsuusyoKaigoTimeContena.add(getTsuusyoKaigoTimeBeginTimeContainer(), VRLayout.FLOW);

    tsuusyoKaigoTimeContena.add(getTsuusyoKaigoTimeEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTsuusyoKaigoTimeEndTimeModel(){

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
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QS001107Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001107Design getThis() {
    return this;
  }
}
