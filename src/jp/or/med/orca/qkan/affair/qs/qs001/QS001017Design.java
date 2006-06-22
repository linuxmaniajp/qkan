
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
 * �쐬��: 2006/01/26  ���{�R���s���[�^�[������� ���}�@�M�u �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[���Z�������×{���i����×{�Ǘ��w���j (QS001017)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTimeComboBox;
import jp.nichicom.ac.component.ACVerticalRadioButtonGroup;
import jp.nichicom.ac.container.ACBackLabelContainer;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
/**
 * �T�[�r�X�p�^�[���Z�������×{���i����×{�Ǘ��w���j��ʍ��ڃf�U�C��(QS001017) 
 */
public class QS001017Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACPanel recuperationManagementGuidancePatterns;

  private ACBackLabelContainer recuperationManagementGuidanceTimeContena;

  private ACTimeComboBox recuperationManagementGuidanceBeginTime;

  private ACLabelContainer recuperationManagementGuidanceBeginTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceBeginTimeModel;

  private ACTimeComboBox recuperationManagementGuidanceEndTime;

  private ACLabelContainer recuperationManagementGuidanceEndTimeContainer;

  private ACComboBoxModelAdapter recuperationManagementGuidanceEndTimeModel;

  private ACVerticalRadioButtonGroup recuperationManagementGuidanceOccupationalCategory;

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

  private ACClearableRadioButtonGroup recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio;

  private ACLabelContainer recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer;

  private ACListModelAdapter recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1;

  private ACRadioButtonItem recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2;

  //getter

  /**
   * �Z�������×{���i����×{�Ǘ��w���j�p�^�[���̈�j���擾���܂��B
   * @return �Z�������×{���i����×{�Ǘ��w���j�p�^�[���̈�j
   */
  public ACPanel getRecuperationManagementGuidancePatterns(){
    if(recuperationManagementGuidancePatterns==null){

      recuperationManagementGuidancePatterns = new ACPanel();

      recuperationManagementGuidancePatterns.setAutoWrap(false);

      recuperationManagementGuidancePatterns.setHgrid(200);

      addRecuperationManagementGuidancePatterns();
    }
    return recuperationManagementGuidancePatterns;

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

      recuperationManagementGuidanceBeginTime.setModel(getRecuperationManagementGuidanceBeginTimeModel());

      recuperationManagementGuidanceBeginTime.setRenderBindPath("CONTENT");

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

      recuperationManagementGuidanceEndTime.setModel(getRecuperationManagementGuidanceEndTimeModel());

      recuperationManagementGuidanceEndTime.setRenderBindPath("CONTENT");

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
   * �E����擾���܂��B
   * @return �E��
   */
  public ACVerticalRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategory(){
    if(recuperationManagementGuidanceOccupationalCategory==null){

      recuperationManagementGuidanceOccupationalCategory = new ACVerticalRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryContainer().setText("�E���敪");

      recuperationManagementGuidanceOccupationalCategory.setBindPath("1310103");

      recuperationManagementGuidanceOccupationalCategory.setModel(getRecuperationManagementGuidanceOccupationalCategoryModel());

      recuperationManagementGuidanceOccupationalCategory.setUseClearButton(false);

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

      recuperationManagementGuidanceOccupationalCategoryDoctor.setConstraints(VRLayout.FLOW_RETURN);

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
   * �h�{�m���擾���܂��B
   * @return �h�{�m
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryDietitian(){
    if(recuperationManagementGuidanceOccupationalCategoryDietitian==null){

      recuperationManagementGuidanceOccupationalCategoryDietitian = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryDietitian.setText("�h�{�m");

      recuperationManagementGuidanceOccupationalCategoryDietitian.setGroup(getRecuperationManagementGuidanceOccupationalCategory());

      recuperationManagementGuidanceOccupationalCategoryDietitian.setConstraints(VRLayout.FLOW_RETURN);

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
   * �ݑ��f���擾���܂��B
   * @return �ݑ��f
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio==null){

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer().setText("�ݑ��f");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setBindPath("1310104");

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioModel());

      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio.setUseClearButton(false);

      addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio;

  }

  /**
   * �ݑ��f�R���e�i���擾���܂��B
   * @return �ݑ��f�R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer;
  }

  /**
   * �ݑ��f���f�����擾���܂��B
   * @return �ݑ��f���f��
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

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioModel());

      recuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadio.setUseClearButton(false);

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
   * �񐔂��擾���܂��B
   * @return ��
   */
  public ACClearableRadioButtonGroup getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio(){
    if(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio==null){

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio = new ACClearableRadioButtonGroup();

      getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer().setText("��");

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio.setBindPath("1310106");

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio.setModel(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel());

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio.setUseClearButton(false);

      addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio();
    }
    return recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio;

  }

  /**
   * �񐔃R���e�i���擾���܂��B
   * @return �񐔃R���e�i
   */
  protected ACLabelContainer getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer(){
    if(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer==null){
      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer = new ACLabelContainer();
      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer.add(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio(), null);
    }
    return recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer;
  }

  /**
   * �񐔃��f�����擾���܂��B
   * @return �񐔃��f��
   */
  protected ACListModelAdapter getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel(){
    if(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel==null){
      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel = new ACListModelAdapter();
      addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel();
    }
    return recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel;
  }

  /**
   * 1��ڂ��擾���܂��B
   * @return 1���
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1(){
    if(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1==null){

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1.setText("1���");

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1.setGroup(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio());

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1();
    }
    return recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1;

  }

  /**
   * 2��ڈȍ~���擾���܂��B
   * @return 2��ڈȍ~
   */
  public ACRadioButtonItem getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2(){
    if(recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2==null){

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2 = new ACRadioButtonItem();

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2.setText("2��ڈȍ~");

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2.setGroup(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio());

      recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2.setConstraints(VRLayout.FLOW);

      addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2();
    }
    return recuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001017Design() {

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

    this.add(getRecuperationManagementGuidancePatterns(), VRLayout.WEST);

  }

  /**
   * �Z�������×{���i����×{�Ǘ��w���j�p�^�[���̈�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidancePatterns(){

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceTimeContena(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryHospitalPharmacistSpecialDrugRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    recuperationManagementGuidancePatterns.add(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

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
   * �h�{�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryDietitian(){

  }

  /**
   * ���ȉq���m���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryEtc(){

  }

  /**
   * �ݑ��f�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryZaiSouShinRadio(){

  }

  /**
   * �ݑ��f���f���ɓ������ڂ�ǉ����܂��B
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
   * �񐔂ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadio(){

  }

  /**
   * �񐔃��f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel(){

    getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1().setButtonIndex(1);
    getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1());

    getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2().setButtonIndex(2);
    getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioModel().add(getRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2());

  }

  /**
   * 1��ڂɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem1(){

  }

  /**
   * 2��ڈȍ~�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRecuperationManagementGuidanceOccupationalCategoryTwoTimesOverDrugStorePharmacistRadioItem2(){

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
      ACFrame.getInstance().getContentPane().add(new QS001017Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001017Design getThis() {
    return this;
  }
}
