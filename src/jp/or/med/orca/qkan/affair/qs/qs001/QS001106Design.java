
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
 * �쐬��: 2006/03/29  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i����×{�Ǘ��w���j (QS001106)
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
import jp.or.med.orca.qkan.text.*;
/**
 * �T�[�r�X�p�^�[���Z�������×{���i����×{�Ǘ��w���j��ʍ��ڃf�U�C��(QS001106) 
 */
public class QS001106Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel recuperationManagementGuidancePatterns;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceOccupationalCategory;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDoctor;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDentist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryDietitian;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryEtc;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceInfoAddRadio;

  private ACLabelContainer recuperationManagementGuidanceInfoAddRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceInfoAddRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceInfoAddRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceInfoAddRadioItem2;

  private ACGroupBox recuperationManagementGuidanceTimesGroup;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceTimesHospitalRadio;

  private ACLabelContainer recuperationManagementGuidanceTimesHospitalRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceTimesHospitalRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceTimesHospitalRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceTimesHospitalRadioItem2;

  private ACClearableRadioButtonGroup recuperationManagementGuidanceTimesDrugstoreRadio;

  private ACLabelContainer recuperationManagementGuidanceTimesDrugstoreRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceTimesDrugstoreRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceTimesDrugstoreRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceTimesDrugstoreRadioItem2;

  private ACIntegerCheckBox recuperationManagementGuidanceTimesCancerEndCheck;

  private ACBackLabelContainer recuperationManagementGuidanceTimeContena;

  private ACTimeComboBox recuperationManagementGuidanceBeginTime;

  private ACLabelContainer recuperationManagementGuidanceBeginTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceBeginTimeModel;

  private ACTimeComboBox recuperationManagementGuidanceEndTime;

  private ACLabelContainer recuperationManagementGuidanceEndTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceEndTimeModel;

  //getter

  /**
   * �Z�������×{���i����×{�Ǘ��w���j�p�^�[���̈�j���擾���܂��B
   * @return �Z�������×{���i����×{�Ǘ��w���j�p�^�[���̈�j
   */
  public ACPanel getRecuperationManagementGuidancePatterns(){
    if(recuperationManagementGuidancePatterns==null){

      recuperationManagementGuidancePatterns = new ACPanel();

      recuperationManagementGuidancePatterns.setAutoWrap(false);

      recuperationManagementGuidancePatterns.setHgap(0);

      recuperationManagementGuidancePatterns.setHgrid(200);

      addRecuperationManagementGuidancePatterns();
    }
    return recuperationManagementGuidancePatterns;

  }

  /**
   * �E����擾���܂��B
   * @return �E��
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategory(){
    if(recuperationManagementGuidanceOccupationalCategory==null){

      recuperationManagementGuidanceOccupationalCategory = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryContainer().setText("�S���ҋ敪");

      recuperationManagementGuidanceOccupationalCategory.setBindPath("1310103");

      recuperationManagementGuidanceOccupationalCategory.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategory.setModel(getRecuperationManagementGuidanceOccupationalCategoryModel());

      addRecuperationManagementGuidanceOccupationalCategory();
    }
    return recuperationManagementGuidanceOccupationalCategory;

  }

  /**
   * �E��R���e�i���擾���܂��B
   * @return �E��R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryContainer==null){
      recuperationManagementGuidanceOccupationalCategoryContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceOccupationalCategoryContainer.add(getRecuperationManagementGuidanceOccupationalCategory(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryContainer;
  }

  /**
   * �E�탂�f�����擾���܂��B
   * @return �E�탂�f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryModel(){
    if(recuperationManagementGuidanceOccupationalCategoryModel==null){
      recuperationManagementGuidanceOccupationalCategoryModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryModel;
  }

  /**
   * ��t���擾���܂��B
   * @return ��t
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDoctor(){
    if(recuperationManagementGuidanceOccupationalCategoryDoctor==null){

      recuperationManagementGuidanceOccupationalCategoryDoctor = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDoctor.setText("��t");

      recuperationManagementGuidanceOccupationalCategoryDoctor.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDoctor.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryDoctor();
    }
    return recuperationManagementGuidanceOccupationalCategoryDoctor;

  }

  /**
   * ���Ȉ�t���擾���܂��B
   * @return ���Ȉ�t
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDentist(){
    if(recuperationManagementGuidanceOccupationalCategoryDentist==null){

      recuperationManagementGuidanceOccupationalCategoryDentist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDentist.setText("���Ȉ�t");

      recuperationManagementGuidanceOccupationalCategoryDentist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDentist.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDentist();
    }
    return recuperationManagementGuidanceOccupationalCategoryDentist;

  }

  /**
   * ��܎t�i��Ë@�ցj���擾���܂��B
   * @return ��܎t�i��Ë@�ցj
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setText("��܎t�i��Ë@�ցj");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacist;

  }

  /**
   * ��܎t�i��ǁj���擾���܂��B
   * @return ��܎t�i��ǁj
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist(){
    if(recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist==null){

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setText("��܎t�i��ǁj");

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist();
    }
    return recuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist;

  }

  /**
   * �Ǘ��h�{�m���擾���܂��B
   * @return �Ǘ��h�{�m
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDietitian(){
    if(recuperationManagementGuidanceOccupationalCategoryDietitian==null){

      recuperationManagementGuidanceOccupationalCategoryDietitian = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDietitian.setText("�Ǘ��h�{�m");

      recuperationManagementGuidanceOccupationalCategoryDietitian.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDietitian.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryDietitian();
    }
    return recuperationManagementGuidanceOccupationalCategoryDietitian;

  }

  /**
   * ���ȉq���m�����擾���܂��B
   * @return ���ȉq���m��
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryEtc(){
    if(recuperationManagementGuidanceOccupationalCategoryEtc==null){

      recuperationManagementGuidanceOccupationalCategoryEtc = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryEtc.setText("���ȉq���m��");

      recuperationManagementGuidanceOccupationalCategoryEtc.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryEtc.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceOccupationalCategoryEtc();
    }
    return recuperationManagementGuidanceOccupationalCategoryEtc;

  }

  /**
   * �ݑ��w�����Ǘ������擾���܂��B
   * @return �ݑ��w�����Ǘ���
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer().setText("�ݑ��w�����Ǘ���");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setBindPath("1310104");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel());

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio;

  }

  /**
   * �ݑ��w�����Ǘ����R���e�i���擾���܂��B
   * @return �ݑ��w�����Ǘ����R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer;
  }

  /**
   * �ݑ��w�����Ǘ������f�����擾���܂��B
   * @return �ݑ��w�����Ǘ������f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel==null){
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1.setText("�Ȃ�");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1.setGroup(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio());

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2.setText("����");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2.setGroup(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio());

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2;

  }

  /**
   * ���ʖ�܂��擾���܂��B
   * @return ���ʖ��
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer().setText("���ʖ��");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setBindPath("1310105");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setUseClearButton(false);

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel());

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio;

  }

  /**
   * ���ʖ�܃R���e�i���擾���܂��B
   * @return ���ʖ�܃R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer;
  }

  /**
   * ���ʖ�܃��f�����擾���܂��B
   * @return ���ʖ�܃��f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel==null){
      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setText("�Ȃ�");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setGroup(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2(){
    if(recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2==null){

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setText("����");

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setGroup(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2();
    }
    return recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2;

  }

  /**
   * ���񋟖����{���Z���擾���܂��B
   * @return ���񋟖����{���Z
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceInfoAddRadio(){
    if(recuperationManagementGuidanceInfoAddRadio==null){

      recuperationManagementGuidanceInfoAddRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceInfoAddRadioContainer().setText("���񋟖����{���Z");

      recuperationManagementGuidanceInfoAddRadio.setBindPath("1310107");

      recuperationManagementGuidanceInfoAddRadio.setUseClearButton(false);

      recuperationManagementGuidanceInfoAddRadio.setModel(getRecuperationManagementGuidanceInfoAddRadioModel());

      addRecuperationManagementGuidanceInfoAddRadio();
    }
    return recuperationManagementGuidanceInfoAddRadio;

  }

  /**
   * ���񋟖����{���Z�R���e�i���擾���܂��B
   * @return ���񋟖����{���Z�R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceInfoAddRadioContainer(){
    if(recuperationManagementGuidanceInfoAddRadioContainer==null){
      recuperationManagementGuidanceInfoAddRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceInfoAddRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceInfoAddRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceInfoAddRadioContainer.add(getRecuperationManagementGuidanceInfoAddRadio(), null);
    }
    return recuperationManagementGuidanceInfoAddRadioContainer;
  }

  /**
   * ���񋟖����{���Z���f�����擾���܂��B
   * @return ���񋟖����{���Z���f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceInfoAddRadioModel(){
    if(recuperationManagementGuidanceInfoAddRadioModel==null){
      recuperationManagementGuidanceInfoAddRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceInfoAddRadioModel();
    }
    return recuperationManagementGuidanceInfoAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceInfoAddRadioItem1(){
    if(recuperationManagementGuidanceInfoAddRadioItem1==null){

      recuperationManagementGuidanceInfoAddRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceInfoAddRadioItem1.setText("�Ȃ�");

      recuperationManagementGuidanceInfoAddRadioItem1.setGroup(getRecuperationManagementGuidanceInfoAddRadio());

      recuperationManagementGuidanceInfoAddRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceInfoAddRadioItem1();
    }
    return recuperationManagementGuidanceInfoAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceInfoAddRadioItem2(){
    if(recuperationManagementGuidanceInfoAddRadioItem2==null){

      recuperationManagementGuidanceInfoAddRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceInfoAddRadioItem2.setText("����");

      recuperationManagementGuidanceInfoAddRadioItem2.setGroup(getRecuperationManagementGuidanceInfoAddRadio());

      recuperationManagementGuidanceInfoAddRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceInfoAddRadioItem2();
    }
    return recuperationManagementGuidanceInfoAddRadioItem2;

  }

  /**
   * ��܎t����×{�Ǘ��w���񐔂��擾���܂��B
   * @return ��܎t����×{�Ǘ��w����
   */
  public ACGroupBox getRecuperationManagementGuidanceTimesGroup(){
    if(recuperationManagementGuidanceTimesGroup==null){

      recuperationManagementGuidanceTimesGroup = new ACGroupBox();

      recuperationManagementGuidanceTimesGroup.setText("��܎t����×{�Ǘ��w����");

      recuperationManagementGuidanceTimesGroup.setFollowChildEnabled(false);

      addRecuperationManagementGuidanceTimesGroup();
    }
    return recuperationManagementGuidanceTimesGroup;

  }

  /**
   * ��܎t����Ë@�ւ��擾���܂��B
   * @return ��܎t����Ë@��
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceTimesHospitalRadio(){
    if(recuperationManagementGuidanceTimesHospitalRadio==null){

      recuperationManagementGuidanceTimesHospitalRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceTimesHospitalRadioContainer().setText("��܎t����Ë@��");

      recuperationManagementGuidanceTimesHospitalRadio.setBindPath("1310108");

      recuperationManagementGuidanceTimesHospitalRadio.setUseClearButton(false);

      recuperationManagementGuidanceTimesHospitalRadio.setModel(getRecuperationManagementGuidanceTimesHospitalRadioModel());

      addRecuperationManagementGuidanceTimesHospitalRadio();
    }
    return recuperationManagementGuidanceTimesHospitalRadio;

  }

  /**
   * ��܎t����Ë@�փR���e�i���擾���܂��B
   * @return ��܎t����Ë@�փR���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceTimesHospitalRadioContainer(){
    if(recuperationManagementGuidanceTimesHospitalRadioContainer==null){
      recuperationManagementGuidanceTimesHospitalRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceTimesHospitalRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceTimesHospitalRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceTimesHospitalRadioContainer.add(getRecuperationManagementGuidanceTimesHospitalRadio(), null);
    }
    return recuperationManagementGuidanceTimesHospitalRadioContainer;
  }

  /**
   * ��܎t����Ë@�փ��f�����擾���܂��B
   * @return ��܎t����Ë@�փ��f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceTimesHospitalRadioModel(){
    if(recuperationManagementGuidanceTimesHospitalRadioModel==null){
      recuperationManagementGuidanceTimesHospitalRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceTimesHospitalRadioModel();
    }
    return recuperationManagementGuidanceTimesHospitalRadioModel;
  }

  /**
   * 1��ږ���2��ڂ��擾���܂��B
   * @return 1��ږ���2���
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceTimesHospitalRadioItem1(){
    if(recuperationManagementGuidanceTimesHospitalRadioItem1==null){

      recuperationManagementGuidanceTimesHospitalRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceTimesHospitalRadioItem1.setText("1��ږ���2���");

      recuperationManagementGuidanceTimesHospitalRadioItem1.setGroup(getRecuperationManagementGuidanceTimesHospitalRadio());

      recuperationManagementGuidanceTimesHospitalRadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceTimesHospitalRadioItem1();
    }
    return recuperationManagementGuidanceTimesHospitalRadioItem1;

  }

  /**
   * 3��ڈȍ~���擾���܂��B
   * @return 3��ڈȍ~
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceTimesHospitalRadioItem2(){
    if(recuperationManagementGuidanceTimesHospitalRadioItem2==null){

      recuperationManagementGuidanceTimesHospitalRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceTimesHospitalRadioItem2.setText("3��ڈȍ~");

      recuperationManagementGuidanceTimesHospitalRadioItem2.setGroup(getRecuperationManagementGuidanceTimesHospitalRadio());

      recuperationManagementGuidanceTimesHospitalRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceTimesHospitalRadioItem2();
    }
    return recuperationManagementGuidanceTimesHospitalRadioItem2;

  }

  /**
   * ��܎t����ǂ��擾���܂��B
   * @return ��܎t�����
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceTimesDrugstoreRadio(){
    if(recuperationManagementGuidanceTimesDrugstoreRadio==null){

      recuperationManagementGuidanceTimesDrugstoreRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceTimesDrugstoreRadioContainer().setText("��܎t�����");

      recuperationManagementGuidanceTimesDrugstoreRadio.setBindPath("1310109");

      recuperationManagementGuidanceTimesDrugstoreRadio.setUseClearButton(false);

      recuperationManagementGuidanceTimesDrugstoreRadio.setModel(getRecuperationManagementGuidanceTimesDrugstoreRadioModel());

      addRecuperationManagementGuidanceTimesDrugstoreRadio();
    }
    return recuperationManagementGuidanceTimesDrugstoreRadio;

  }

  /**
   * ��܎t����ǃR���e�i���擾���܂��B
   * @return ��܎t����ǃR���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceTimesDrugstoreRadioContainer(){
    if(recuperationManagementGuidanceTimesDrugstoreRadioContainer==null){
      recuperationManagementGuidanceTimesDrugstoreRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceTimesDrugstoreRadioContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceTimesDrugstoreRadioContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceTimesDrugstoreRadioContainer.add(getRecuperationManagementGuidanceTimesDrugstoreRadio(), null);
    }
    return recuperationManagementGuidanceTimesDrugstoreRadioContainer;
  }

  /**
   * ��܎t����ǃ��f�����擾���܂��B
   * @return ��܎t����ǃ��f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceTimesDrugstoreRadioModel(){
    if(recuperationManagementGuidanceTimesDrugstoreRadioModel==null){
      recuperationManagementGuidanceTimesDrugstoreRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceTimesDrugstoreRadioModel();
    }
    return recuperationManagementGuidanceTimesDrugstoreRadioModel;
  }

  /**
   * 1��ڂ��擾���܂��B
   * @return 1���
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceTimesDrugstoreRadioItem1(){
    if(recuperationManagementGuidanceTimesDrugstoreRadioItem1==null){

      recuperationManagementGuidanceTimesDrugstoreRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceTimesDrugstoreRadioItem1.setText("1���");

      recuperationManagementGuidanceTimesDrugstoreRadioItem1.setGroup(getRecuperationManagementGuidanceTimesDrugstoreRadio());

      recuperationManagementGuidanceTimesDrugstoreRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceTimesDrugstoreRadioItem1();
    }
    return recuperationManagementGuidanceTimesDrugstoreRadioItem1;

  }

  /**
   * 2��ڈȍ~���擾���܂��B
   * @return 2��ڈȍ~
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceTimesDrugstoreRadioItem2(){
    if(recuperationManagementGuidanceTimesDrugstoreRadioItem2==null){

      recuperationManagementGuidanceTimesDrugstoreRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceTimesDrugstoreRadioItem2.setText("2��ڈȍ~");

      recuperationManagementGuidanceTimesDrugstoreRadioItem2.setGroup(getRecuperationManagementGuidanceTimesDrugstoreRadio());

      recuperationManagementGuidanceTimesDrugstoreRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addRecuperationManagementGuidanceTimesDrugstoreRadioItem2();
    }
    return recuperationManagementGuidanceTimesDrugstoreRadioItem2;

  }

  /**
   * �K���������擾���܂��B
   * @return �K������
   */
  public ACIntegerCheckBox getRecuperationManagementGuidanceTimesCancerEndCheck(){
    if(recuperationManagementGuidanceTimesCancerEndCheck==null){

      recuperationManagementGuidanceTimesCancerEndCheck = new ACIntegerCheckBox();

      recuperationManagementGuidanceTimesCancerEndCheck.setText("�K������");

      recuperationManagementGuidanceTimesCancerEndCheck.setBindPath("1310110");

      recuperationManagementGuidanceTimesCancerEndCheck.setSelectValue(2);

      recuperationManagementGuidanceTimesCancerEndCheck.setUnSelectValue(1);

      addRecuperationManagementGuidanceTimesCancerEndCheck();
    }
    return recuperationManagementGuidanceTimesCancerEndCheck;

  }

  /**
   * �񋟎��ԃR���e�i���擾���܂��B
   * @return �񋟎��ԃR���e�i
   */
  public ACBackLabelContainer getRecuperationManagementGuidanceTimeContena(){
    if(recuperationManagementGuidanceTimeContena==null){

      recuperationManagementGuidanceTimeContena = new ACBackLabelContainer();

      addRecuperationManagementGuidanceTimeContena();
    }
    return recuperationManagementGuidanceTimeContena;

  }

  /**
   * �J�n�����R���{���擾���܂��B
   * @return �J�n�����R���{
   */
  public ACTimeComboBox getRecuperationManagementGuidanceBeginTime(){
    if(recuperationManagementGuidanceBeginTime==null){

      recuperationManagementGuidanceBeginTime = new ACTimeComboBox();

      getRecuperationManagementGuidanceBeginTimeContainer().setText("�J�n����");

      recuperationManagementGuidanceBeginTime.setBindPath("3");

      recuperationManagementGuidanceBeginTime.setModelBindPath("3");

      recuperationManagementGuidanceBeginTime.setRenderBindPath("CONTENT");

      recuperationManagementGuidanceBeginTime.setModel(getRecuperationManagementGuidanceBeginTimeModel());

      addRecuperationManagementGuidanceBeginTime();
    }
    return recuperationManagementGuidanceBeginTime;

  }

  /**
   * �J�n�����R���{�R���e�i���擾���܂��B
   * @return �J�n�����R���{�R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceBeginTimeContainer(){
    if(recuperationManagementGuidanceBeginTimeContainer==null){
      recuperationManagementGuidanceBeginTimeContainer = new ACLabelContainer();
      recuperationManagementGuidanceBeginTimeContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceBeginTimeContainer.add(getRecuperationManagementGuidanceBeginTime(), null);
    }
    return recuperationManagementGuidanceBeginTimeContainer;
  }

  /**
   * �J�n�����R���{���f�����擾���܂��B
   * @return �J�n�����R���{���f��
   */
  protected ACComboBoxModelAdapter getRecuperationManagementGuidanceBeginTimeModel(){
    if(recuperationManagementGuidanceBeginTimeModel==null){
      recuperationManagementGuidanceBeginTimeModel = new ACComboBoxModelAdapter();
      addRecuperationManagementGuidanceBeginTimeModel();
    }
    return recuperationManagementGuidanceBeginTimeModel;
  }

  /**
   * �I�������R���{���擾���܂��B
   * @return �I�������R���{
   */
  public ACTimeComboBox getRecuperationManagementGuidanceEndTime(){
    if(recuperationManagementGuidanceEndTime==null){

      recuperationManagementGuidanceEndTime = new ACTimeComboBox();

      getRecuperationManagementGuidanceEndTimeContainer().setText("�I������");

      recuperationManagementGuidanceEndTime.setBindPath("4");

      recuperationManagementGuidanceEndTime.setModelBindPath("4");

      recuperationManagementGuidanceEndTime.setRenderBindPath("CONTENT");

      recuperationManagementGuidanceEndTime.setModel(getRecuperationManagementGuidanceEndTimeModel());

      addRecuperationManagementGuidanceEndTime();
    }
    return recuperationManagementGuidanceEndTime;

  }

  /**
   * �I�������R���{�R���e�i���擾���܂��B
   * @return �I�������R���{�R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceEndTimeContainer(){
    if(recuperationManagementGuidanceEndTimeContainer==null){
      recuperationManagementGuidanceEndTimeContainer = new ACLabelContainer();
      recuperationManagementGuidanceEndTimeContainer.setFollowChildEnabled(true);
      recuperationManagementGuidanceEndTimeContainer.setVAlignment(VRLayout.CENTER);
      recuperationManagementGuidanceEndTimeContainer.add(getRecuperationManagementGuidanceEndTime(), null);
    }
    return recuperationManagementGuidanceEndTimeContainer;
  }

  /**
   * �I�������R���{���f�����擾���܂��B
   * @return �I�������R���{���f��
   */
  protected ACComboBoxModelAdapter getRecuperationManagementGuidanceEndTimeModel(){
    if(recuperationManagementGuidanceEndTimeModel==null){
      recuperationManagementGuidanceEndTimeModel = new ACComboBoxModelAdapter();
      addRecuperationManagementGuidanceEndTimeModel();
    }
    return recuperationManagementGuidanceEndTimeModel;
  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001106Design() {

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

    this.add(getRecuperationManagementGuidancePatterns(), VRLayout.CLIENT);

  }

  /**
   * �Z�������×{���i����×{�Ǘ��w���j�p�^�[���̈�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidancePatterns(){

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceInfoAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceTimesGroup(), VRLayout.FLOW_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * �E��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategory(){

  }

  /**
   * �E�탂�f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryModel(){

    getRecuperationManagementGuidanceOccupationalCategoryDoctor().setButtonIndex(1);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDoctor());

    getRecuperationManagementGuidanceOccupationalCategoryDentist().setButtonIndex(2);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDentist());

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist().setButtonIndex(3);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist());

    getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist().setButtonIndex(4);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist());

    getRecuperationManagementGuidanceOccupationalCategoryDietitian().setButtonIndex(5);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryDietitian());

    getRecuperationManagementGuidanceOccupationalCategoryEtc().setButtonIndex(6);
    getRecuperationManagementGuidanceOccupationalCategoryModel().add(getRecuperationManagementGuidanceOccupationalCategoryEtc());

  }

  /**
   * ��t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDoctor(){

  }

  /**
   * ���Ȉ�t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDentist(){

  }

  /**
   * ��܎t�i��Ë@�ցj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacist(){

  }

  /**
   * ��܎t�i��ǁj�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDrugstorePharmacist(){

  }

  /**
   * �Ǘ��h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDietitian(){

  }

  /**
   * ���ȉq���m���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryEtc(){

  }

  /**
   * �ݑ��w�����Ǘ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(){

  }

  /**
   * �ݑ��w�����Ǘ������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel(){

    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1());

    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioItem2(){

  }

  /**
   * ���ʖ�܂ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio(){

  }

  /**
   * ���ʖ�܃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel(){

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1());

    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioItem2(){

  }

  /**
   * ���񋟖����{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceInfoAddRadio(){

  }

  /**
   * ���񋟖����{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceInfoAddRadioModel(){

    getRecuperationManagementGuidanceInfoAddRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceInfoAddRadioModel().add(getRecuperationManagementGuidanceInfoAddRadioItem1());

    getRecuperationManagementGuidanceInfoAddRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceInfoAddRadioModel().add(getRecuperationManagementGuidanceInfoAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceInfoAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceInfoAddRadioItem2(){

  }

  /**
   * ��܎t����×{�Ǘ��w���񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesGroup(){

    recuperationManagementGuidanceTimesGroup.add(getRecuperationManagementGuidanceTimesHospitalRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidanceTimesGroup.add(getRecuperationManagementGuidanceTimesDrugstoreRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidanceTimesGroup.add(getRecuperationManagementGuidanceTimesCancerEndCheck(), VRLayout.FLOW);

  }

  /**
   * ��܎t����Ë@�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesHospitalRadio(){

  }

  /**
   * ��܎t����Ë@�փ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesHospitalRadioModel(){

    getRecuperationManagementGuidanceTimesHospitalRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceTimesHospitalRadioModel().add(getRecuperationManagementGuidanceTimesHospitalRadioItem1());

    getRecuperationManagementGuidanceTimesHospitalRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceTimesHospitalRadioModel().add(getRecuperationManagementGuidanceTimesHospitalRadioItem2());

  }

  /**
   * 1��ږ���2��ڂɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesHospitalRadioItem1(){

  }

  /**
   * 3��ڈȍ~�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesHospitalRadioItem2(){

  }

  /**
   * ��܎t����ǂɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesDrugstoreRadio(){

  }

  /**
   * ��܎t����ǃ��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesDrugstoreRadioModel(){

    getRecuperationManagementGuidanceTimesDrugstoreRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceTimesDrugstoreRadioModel().add(getRecuperationManagementGuidanceTimesDrugstoreRadioItem1());

    getRecuperationManagementGuidanceTimesDrugstoreRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceTimesDrugstoreRadioModel().add(getRecuperationManagementGuidanceTimesDrugstoreRadioItem2());

  }

  /**
   * 1��ڂɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesDrugstoreRadioItem1(){

  }

  /**
   * 2��ڈȍ~�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesDrugstoreRadioItem2(){

  }

  /**
   * �K�������ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimesCancerEndCheck(){

  }

  /**
   * �񋟎��ԃR���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceTimeContena(){

    recuperationManagementGuidanceTimeContena.add(getRecuperationManagementGuidanceBeginTimeContainer(), VRLayout.FLOW);

    recuperationManagementGuidanceTimeContena.add(getRecuperationManagementGuidanceEndTimeContainer(), VRLayout.FLOW);

  }

  /**
   * �J�n�����R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceBeginTime(){

  }

  /**
   * �J�n�����R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceBeginTimeModel(){

  }

  /**
   * �I�������R���{�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceEndTime(){

  }

  /**
   * �I�������R���{���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceEndTimeModel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001106Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001106Design getThis() {
    return this;
  }
}
