
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
 * �쐬��: 2006/04/30  ���{�R���s���[�^�[������� ���{�@�K�� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �ʏ����n (QO004108)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
/**
 * �ʏ����n��ʍ��ڃf�U�C��(QO004108) 
 */
public class QO004108Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACClearableRadioButtonGroup facilitiesDivision;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACIntegerCheckBox facilitiesDivisionOther1;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACRadioButtonItem staffLackItem4;

  private ACRadioButtonItem staffLackItem5;

  private ACRadioButtonItem staffLackItem6;

  private ACRadioButtonItem staffLackItem7;

  private ACClearableRadioButtonGroup extendTime;

  private ACLabelContainer extendTimeContainer;

  private ACListModelAdapter extendTimeModel;

  private ACRadioButtonItem extendTimeItem1;

  private ACRadioButtonItem extendTimeItem2;

  private ACClearableRadioButtonGroup bathingHelpSystem;

  private ACLabelContainer bathingHelpSystemContainer;

  private ACListModelAdapter bathingHelpSystemModel;

  private ACRadioButtonItem bathingHelpSystemItem1;

  private ACRadioButtonItem bathingHelpSystemItem2;

  private ACClearableRadioButtonGroup dementiaCare;

  private ACLabelContainer dementiaCareContainer;

  private ACListModelAdapter dementiaCareModel;

  private ACRadioButtonItem dementiaCareItem1;

  private ACRadioButtonItem dementiaCareItem2;

  private ACClearableRadioButtonGroup nourishmentManagementAdd;

  private ACLabelContainer nourishmentManagementAddContainer;

  private ACListModelAdapter nourishmentManagementAddModel;

  private ACRadioButtonItem nourishmentManagementAddItem1;

  private ACRadioButtonItem nourishmentManagementAddItem2;

  private ACClearableRadioButtonGroup mouthImprovementAdd;

  private ACLabelContainer mouthImprovementAddContainer;

  private ACListModelAdapter mouthImprovementAddModel;

  private ACRadioButtonItem mouthImprovementAddItem1;

  private ACRadioButtonItem mouthImprovementAddItem2;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("�ʏ����n");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * �{�݋敪�R���e�i���擾���܂��B
   * @return �{�݋敪�R���e�i
   */
  public ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){

      facilitiesDivisionContainer = new ACLabelContainer();

      facilitiesDivisionContainer.setText("�{�ݓ��̋敪");

      facilitiesDivisionContainer.setFollowChildEnabled(true);

      addFacilitiesDivisionContainer();
    }
    return facilitiesDivisionContainer;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACClearableRadioButtonGroup();

      facilitiesDivision.setBindPath("1160101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      addFacilitiesDivision();
    }
    return facilitiesDivision;

  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getFacilitiesDivisionModel(){
    if(facilitiesDivisionModel==null){
      facilitiesDivisionModel = new ACListModelAdapter();
      addFacilitiesDivisionModel();
    }
    return facilitiesDivisionModel;
  }

  /**
   * �ʏ�K�͂̈�Ë@�ւ��擾���܂��B
   * @return �ʏ�K�͂̈�Ë@��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("�ʏ�K�͂̈�Ë@��");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * ���K�͐f�Ï����擾���܂��B
   * @return ���K�͐f�Ï�
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("���K�͐f�Ï�");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("���V�l�ی��{��");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * ��K�͎��Ə��i���p�Ґ�900�l���j���擾���܂��B
   * @return ��K�͎��Ə��i���p�Ґ�900�l���j
   */
  public ACIntegerCheckBox getFacilitiesDivisionOther1(){
    if(facilitiesDivisionOther1==null){

      facilitiesDivisionOther1 = new ACIntegerCheckBox();

      facilitiesDivisionOther1.setText("��K�͎��Ə��i���p�Ґ�900�l���j");

      facilitiesDivisionOther1.setBindPath("1160106");

      facilitiesDivisionOther1.setSelectValue(2);

      facilitiesDivisionOther1.setUnSelectValue(1);

      addFacilitiesDivisionOther1();
    }
    return facilitiesDivisionOther1;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("1160105");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v�R���e�i���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.setVAlignment(VRLayout.CENTER);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���f�����擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���f��
   */
  protected ACListModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACListModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffLackItem1(){
    if(staffLackItem1==null){

      staffLackItem1 = new ACRadioButtonItem();

      staffLackItem1.setText("�Ȃ�");

      staffLackItem1.setGroup(getStaffLack());

      staffLackItem1.setConstraints(VRLayout.FLOW);

      addStaffLackItem1();
    }
    return staffLackItem1;

  }

  /**
   * ��t���擾���܂��B
   * @return ��t
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("��t");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("�Ō�E��");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * ���E�����擾���܂��B
   * @return ���E��
   */
  public ACRadioButtonItem getStaffLackItem4(){
    if(staffLackItem4==null){

      staffLackItem4 = new ACRadioButtonItem();

      staffLackItem4.setText("���E��");

      staffLackItem4.setGroup(getStaffLack());

      staffLackItem4.setConstraints(VRLayout.FLOW_RETURN);

      addStaffLackItem4();
    }
    return staffLackItem4;

  }

  /**
   * ���w�Ö@�m���擾���܂��B
   * @return ���w�Ö@�m
   */
  public ACRadioButtonItem getStaffLackItem5(){
    if(staffLackItem5==null){

      staffLackItem5 = new ACRadioButtonItem();

      staffLackItem5.setText("���w�Ö@�m");

      staffLackItem5.setGroup(getStaffLack());

      staffLackItem5.setConstraints(VRLayout.FLOW);

      addStaffLackItem5();
    }
    return staffLackItem5;

  }

  /**
   * ��ƗÖ@�m���擾���܂��B
   * @return ��ƗÖ@�m
   */
  public ACRadioButtonItem getStaffLackItem6(){
    if(staffLackItem6==null){

      staffLackItem6 = new ACRadioButtonItem();

      staffLackItem6.setText("��ƗÖ@�m");

      staffLackItem6.setGroup(getStaffLack());

      staffLackItem6.setConstraints(VRLayout.FLOW);

      addStaffLackItem6();
    }
    return staffLackItem6;

  }

  /**
   * ���꒮�o�m���擾���܂��B
   * @return ���꒮�o�m
   */
  public ACRadioButtonItem getStaffLackItem7(){
    if(staffLackItem7==null){

      staffLackItem7 = new ACRadioButtonItem();

      staffLackItem7.setText("���꒮�o�m");

      staffLackItem7.setGroup(getStaffLack());

      staffLackItem7.setConstraints(VRLayout.FLOW);

      addStaffLackItem7();
    }
    return staffLackItem7;

  }

  /**
   * ���ԉ����T�[�r�X�̐����擾���܂��B
   * @return ���ԉ����T�[�r�X�̐�
   */
  public ACClearableRadioButtonGroup getExtendTime(){
    if(extendTime==null){

      extendTime = new ACClearableRadioButtonGroup();

      getExtendTimeContainer().setText("���ԉ����T�[�r�X�̐�");

      extendTime.setBindPath("1160110");

      extendTime.setUseClearButton(false);

      extendTime.setModel(getExtendTimeModel());

      addExtendTime();
    }
    return extendTime;

  }

  /**
   * ���ԉ����T�[�r�X�̐��R���e�i���擾���܂��B
   * @return ���ԉ����T�[�r�X�̐��R���e�i
   */
  protected ACLabelContainer getExtendTimeContainer(){
    if(extendTimeContainer==null){
      extendTimeContainer = new ACLabelContainer();
      extendTimeContainer.setFollowChildEnabled(true);
      extendTimeContainer.setVAlignment(VRLayout.CENTER);
      extendTimeContainer.add(getExtendTime(), null);
    }
    return extendTimeContainer;
  }

  /**
   * ���ԉ����T�[�r�X�̐����f�����擾���܂��B
   * @return ���ԉ����T�[�r�X�̐����f��
   */
  protected ACListModelAdapter getExtendTimeModel(){
    if(extendTimeModel==null){
      extendTimeModel = new ACListModelAdapter();
      addExtendTimeModel();
    }
    return extendTimeModel;
  }

  /**
   * �Ή��s���擾���܂��B
   * @return �Ή��s��
   */
  public ACRadioButtonItem getExtendTimeItem1(){
    if(extendTimeItem1==null){

      extendTimeItem1 = new ACRadioButtonItem();

      extendTimeItem1.setText("�Ή��s��");

      extendTimeItem1.setGroup(getExtendTime());

      extendTimeItem1.setConstraints(VRLayout.FLOW);

      addExtendTimeItem1();
    }
    return extendTimeItem1;

  }

  /**
   * �Ή����擾���܂��B
   * @return �Ή���
   */
  public ACRadioButtonItem getExtendTimeItem2(){
    if(extendTimeItem2==null){

      extendTimeItem2 = new ACRadioButtonItem();

      extendTimeItem2.setText("�Ή���");

      extendTimeItem2.setGroup(getExtendTime());

      extendTimeItem2.setConstraints(VRLayout.FLOW);

      addExtendTimeItem2();
    }
    return extendTimeItem2;

  }

  /**
   * ������̐����W�I�O���[�v���擾���܂��B
   * @return ������̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getBathingHelpSystem(){
    if(bathingHelpSystem==null){

      bathingHelpSystem = new ACClearableRadioButtonGroup();

      getBathingHelpSystemContainer().setText("������̐�");

      bathingHelpSystem.setBindPath("1160102");

      bathingHelpSystem.setUseClearButton(false);

      bathingHelpSystem.setModel(getBathingHelpSystemModel());

      addBathingHelpSystem();
    }
    return bathingHelpSystem;

  }

  /**
   * ������̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ������̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getBathingHelpSystemContainer(){
    if(bathingHelpSystemContainer==null){
      bathingHelpSystemContainer = new ACLabelContainer();
      bathingHelpSystemContainer.setFollowChildEnabled(true);
      bathingHelpSystemContainer.setVAlignment(VRLayout.CENTER);
      bathingHelpSystemContainer.add(getBathingHelpSystem(), null);
    }
    return bathingHelpSystemContainer;
  }

  /**
   * ������̐����W�I�O���[�v���f�����擾���܂��B
   * @return ������̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getBathingHelpSystemModel(){
    if(bathingHelpSystemModel==null){
      bathingHelpSystemModel = new ACListModelAdapter();
      addBathingHelpSystemModel();
    }
    return bathingHelpSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getBathingHelpSystemItem1(){
    if(bathingHelpSystemItem1==null){

      bathingHelpSystemItem1 = new ACRadioButtonItem();

      bathingHelpSystemItem1.setText("�Ȃ�");

      bathingHelpSystemItem1.setGroup(getBathingHelpSystem());

      addBathingHelpSystemItem1();
    }
    return bathingHelpSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getBathingHelpSystemItem2(){
    if(bathingHelpSystemItem2==null){

      bathingHelpSystemItem2 = new ACRadioButtonItem();

      bathingHelpSystemItem2.setText("����");

      bathingHelpSystemItem2.setGroup(getBathingHelpSystem());

      addBathingHelpSystemItem2();
    }
    return bathingHelpSystemItem2;

  }

  /**
   * ��N���F�m�ǃP�A�̐����擾���܂��B
   * @return ��N���F�m�ǃP�A�̐�
   */
  public ACClearableRadioButtonGroup getDementiaCare(){
    if(dementiaCare==null){

      dementiaCare = new ACClearableRadioButtonGroup();

      getDementiaCareContainer().setText("��N���F�m�ǃP�A�̐�");

      dementiaCare.setBindPath("1160111");

      dementiaCare.setUseClearButton(false);

      dementiaCare.setModel(getDementiaCareModel());

      addDementiaCare();
    }
    return dementiaCare;

  }

  /**
   * ��N���F�m�ǃP�A�̐��R���e�i���擾���܂��B
   * @return ��N���F�m�ǃP�A�̐��R���e�i
   */
  protected ACLabelContainer getDementiaCareContainer(){
    if(dementiaCareContainer==null){
      dementiaCareContainer = new ACLabelContainer();
      dementiaCareContainer.setFollowChildEnabled(true);
      dementiaCareContainer.setVAlignment(VRLayout.CENTER);
      dementiaCareContainer.add(getDementiaCare(), null);
    }
    return dementiaCareContainer;
  }

  /**
   * ��N���F�m�ǃP�A�̐����f�����擾���܂��B
   * @return ��N���F�m�ǃP�A�̐����f��
   */
  protected ACListModelAdapter getDementiaCareModel(){
    if(dementiaCareModel==null){
      dementiaCareModel = new ACListModelAdapter();
      addDementiaCareModel();
    }
    return dementiaCareModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaCareItem1(){
    if(dementiaCareItem1==null){

      dementiaCareItem1 = new ACRadioButtonItem();

      dementiaCareItem1.setText("�Ȃ�");

      dementiaCareItem1.setGroup(getDementiaCare());

      dementiaCareItem1.setConstraints(VRLayout.FLOW);

      addDementiaCareItem1();
    }
    return dementiaCareItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiaCareItem2(){
    if(dementiaCareItem2==null){

      dementiaCareItem2 = new ACRadioButtonItem();

      dementiaCareItem2.setText("����");

      dementiaCareItem2.setGroup(getDementiaCare());

      dementiaCareItem2.setConstraints(VRLayout.FLOW);

      addDementiaCareItem2();
    }
    return dementiaCareItem2;

  }

  /**
   * �h�{�}�l�W�����g�̐����擾���܂��B
   * @return �h�{�}�l�W�����g�̐�
   */
  public ACClearableRadioButtonGroup getNourishmentManagementAdd(){
    if(nourishmentManagementAdd==null){

      nourishmentManagementAdd = new ACClearableRadioButtonGroup();

      getNourishmentManagementAddContainer().setText("�h�{�}�l�W�����g�̐�");

      nourishmentManagementAdd.setBindPath("1160108");

      nourishmentManagementAdd.setUseClearButton(false);

      nourishmentManagementAdd.setModel(getNourishmentManagementAddModel());

      addNourishmentManagementAdd();
    }
    return nourishmentManagementAdd;

  }

  /**
   * �h�{�}�l�W�����g�̐��R���e�i���擾���܂��B
   * @return �h�{�}�l�W�����g�̐��R���e�i
   */
  protected ACLabelContainer getNourishmentManagementAddContainer(){
    if(nourishmentManagementAddContainer==null){
      nourishmentManagementAddContainer = new ACLabelContainer();
      nourishmentManagementAddContainer.setFollowChildEnabled(true);
      nourishmentManagementAddContainer.setVAlignment(VRLayout.CENTER);
      nourishmentManagementAddContainer.add(getNourishmentManagementAdd(), null);
    }
    return nourishmentManagementAddContainer;
  }

  /**
   * �h�{�}�l�W�����g�̐����f�����擾���܂��B
   * @return �h�{�}�l�W�����g�̐����f��
   */
  protected ACListModelAdapter getNourishmentManagementAddModel(){
    if(nourishmentManagementAddModel==null){
      nourishmentManagementAddModel = new ACListModelAdapter();
      addNourishmentManagementAddModel();
    }
    return nourishmentManagementAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNourishmentManagementAddItem1(){
    if(nourishmentManagementAddItem1==null){

      nourishmentManagementAddItem1 = new ACRadioButtonItem();

      nourishmentManagementAddItem1.setText("�Ȃ�");

      nourishmentManagementAddItem1.setGroup(getNourishmentManagementAdd());

      nourishmentManagementAddItem1.setConstraints(VRLayout.FLOW);

      addNourishmentManagementAddItem1();
    }
    return nourishmentManagementAddItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNourishmentManagementAddItem2(){
    if(nourishmentManagementAddItem2==null){

      nourishmentManagementAddItem2 = new ACRadioButtonItem();

      nourishmentManagementAddItem2.setText("����");

      nourishmentManagementAddItem2.setGroup(getNourishmentManagementAdd());

      nourishmentManagementAddItem2.setConstraints(VRLayout.FLOW);

      addNourishmentManagementAddItem2();
    }
    return nourishmentManagementAddItem2;

  }

  /**
   * ���o�@�\����̐����擾���܂��B
   * @return ���o�@�\����̐�
   */
  public ACClearableRadioButtonGroup getMouthImprovementAdd(){
    if(mouthImprovementAdd==null){

      mouthImprovementAdd = new ACClearableRadioButtonGroup();

      getMouthImprovementAddContainer().setText("���o�@�\����̐�");

      mouthImprovementAdd.setBindPath("1160109");

      mouthImprovementAdd.setUseClearButton(false);

      mouthImprovementAdd.setModel(getMouthImprovementAddModel());

      addMouthImprovementAdd();
    }
    return mouthImprovementAdd;

  }

  /**
   * ���o�@�\����̐��R���e�i���擾���܂��B
   * @return ���o�@�\����̐��R���e�i
   */
  protected ACLabelContainer getMouthImprovementAddContainer(){
    if(mouthImprovementAddContainer==null){
      mouthImprovementAddContainer = new ACLabelContainer();
      mouthImprovementAddContainer.setFollowChildEnabled(true);
      mouthImprovementAddContainer.setVAlignment(VRLayout.CENTER);
      mouthImprovementAddContainer.add(getMouthImprovementAdd(), null);
    }
    return mouthImprovementAddContainer;
  }

  /**
   * ���o�@�\����̐����f�����擾���܂��B
   * @return ���o�@�\����̐����f��
   */
  protected ACListModelAdapter getMouthImprovementAddModel(){
    if(mouthImprovementAddModel==null){
      mouthImprovementAddModel = new ACListModelAdapter();
      addMouthImprovementAddModel();
    }
    return mouthImprovementAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMouthImprovementAddItem1(){
    if(mouthImprovementAddItem1==null){

      mouthImprovementAddItem1 = new ACRadioButtonItem();

      mouthImprovementAddItem1.setText("�Ȃ�");

      mouthImprovementAddItem1.setGroup(getMouthImprovementAdd());

      mouthImprovementAddItem1.setConstraints(VRLayout.FLOW);

      addMouthImprovementAddItem1();
    }
    return mouthImprovementAddItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMouthImprovementAddItem2(){
    if(mouthImprovementAddItem2==null){

      mouthImprovementAddItem2 = new ACRadioButtonItem();

      mouthImprovementAddItem2.setText("����");

      mouthImprovementAddItem2.setGroup(getMouthImprovementAdd());

      mouthImprovementAddItem2.setConstraints(VRLayout.FLOW);

      addMouthImprovementAddItem2();
    }
    return mouthImprovementAddItem2;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getReduceRateContainer(){
    if(reduceRateContainer==null){

      reduceRateContainer = new ACLabelContainer();

      reduceRateContainer.setText("������");

      reduceRateContainer.setFollowChildEnabled(true);

      addReduceRateContainer();
    }
    return reduceRateContainer;

  }

  /**
   * ���������擾���܂��B
   * @return ������
   */
  public ACTextField getReduceRate(){
    if(reduceRate==null){

      reduceRate = new ACTextField();

      reduceRate.setBindPath("REDUCT_RATE");

      reduceRate.setColumns(3);

      reduceRate.setCharType(VRCharType.ONLY_DIGIT);

      reduceRate.setHorizontalAlignment(SwingConstants.RIGHT);

      reduceRate.setIMEMode(InputSubset.LATIN);

      reduceRate.setMaxLength(3);

      addReduceRate();
    }
    return reduceRate;

  }

  /**
   * �����x�����擾���܂��B
   * @return �����x��
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("��");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004108Design() {

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

    this.add(getMainGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMainGroup(){

    mainGroup.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getExtendTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getDementiaCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNourishmentManagementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getMouthImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionContainer(){

    facilitiesDivisionContainer.add(getFacilitiesDivision(), VRLayout.FLOW_INSETLINE_RETURN);

    facilitiesDivisionContainer.add(getFacilitiesDivisionOther1(), VRLayout.FLOW);

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivision(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionModel(){

    getFacilitiesDivisionItem1().setButtonIndex(1);
    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem1());

    getFacilitiesDivisionItem2().setButtonIndex(2);
    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem2());

    getFacilitiesDivisionItem3().setButtonIndex(3);
    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem3());

  }

  /**
   * �ʏ�K�͂̈�Ë@�ւɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * ���K�͐f�Ï��ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * ��K�͎��Ə��i���p�Ґ�900�l���j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionOther1(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLack(){

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackModel(){

    getStaffLackItem1().setButtonIndex(1);
    getStaffLackModel().add(getStaffLackItem1());

    getStaffLackItem2().setButtonIndex(2);
    getStaffLackModel().add(getStaffLackItem2());

    getStaffLackItem3().setButtonIndex(3);
    getStaffLackModel().add(getStaffLackItem3());

    getStaffLackItem4().setButtonIndex(4);
    getStaffLackModel().add(getStaffLackItem4());

    getStaffLackItem5().setButtonIndex(5);
    getStaffLackModel().add(getStaffLackItem5());

    getStaffLackItem6().setButtonIndex(6);
    getStaffLackModel().add(getStaffLackItem6());

    getStaffLackItem7().setButtonIndex(7);
    getStaffLackModel().add(getStaffLackItem7());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem1(){

  }

  /**
   * ��t�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem2(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem3(){

  }

  /**
   * ���E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem4(){

  }

  /**
   * ���w�Ö@�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem5(){

  }

  /**
   * ��ƗÖ@�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem6(){

  }

  /**
   * ���꒮�o�m�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem7(){

  }

  /**
   * ���ԉ����T�[�r�X�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExtendTime(){

  }

  /**
   * ���ԉ����T�[�r�X�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addExtendTimeModel(){

    getExtendTimeItem1().setButtonIndex(1);
    getExtendTimeModel().add(getExtendTimeItem1());

    getExtendTimeItem2().setButtonIndex(2);
    getExtendTimeModel().add(getExtendTimeItem2());

  }

  /**
   * �Ή��s�ɓ������ڂ�ǉ����܂��B
   */
  protected void addExtendTimeItem1(){

  }

  /**
   * �Ή��ɓ������ڂ�ǉ����܂��B
   */
  protected void addExtendTimeItem2(){

  }

  /**
   * ������̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingHelpSystem(){

  }

  /**
   * ������̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingHelpSystemModel(){

    getBathingHelpSystemItem1().setButtonIndex(1);
    getBathingHelpSystemModel().add(getBathingHelpSystemItem1());

    getBathingHelpSystemItem2().setButtonIndex(2);
    getBathingHelpSystemModel().add(getBathingHelpSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingHelpSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingHelpSystemItem2(){

  }

  /**
   * ��N���F�m�ǃP�A�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCare(){

  }

  /**
   * ��N���F�m�ǃP�A�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareModel(){

    getDementiaCareItem1().setButtonIndex(1);
    getDementiaCareModel().add(getDementiaCareItem1());

    getDementiaCareItem2().setButtonIndex(2);
    getDementiaCareModel().add(getDementiaCareItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaCareItem2(){

  }

  /**
   * �h�{�}�l�W�����g�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAdd(){

  }

  /**
   * �h�{�}�l�W�����g�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAddModel(){

    getNourishmentManagementAddItem1().setButtonIndex(1);
    getNourishmentManagementAddModel().add(getNourishmentManagementAddItem1());

    getNourishmentManagementAddItem2().setButtonIndex(2);
    getNourishmentManagementAddModel().add(getNourishmentManagementAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAddItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentManagementAddItem2(){

  }

  /**
   * ���o�@�\����̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthImprovementAdd(){

  }

  /**
   * ���o�@�\����̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthImprovementAddModel(){

    getMouthImprovementAddItem1().setButtonIndex(1);
    getMouthImprovementAddModel().add(getMouthImprovementAddItem1());

    getMouthImprovementAddItem2().setButtonIndex(2);
    getMouthImprovementAddModel().add(getMouthImprovementAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthImprovementAddItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMouthImprovementAddItem2(){

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduceRateContainer(){

    reduceRateContainer.add(getReduceRate(), VRLayout.FLOW);

    reduceRateContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * �������ɓ������ڂ�ǉ����܂��B
   */
  protected void addReduceRate(){

  }

  /**
   * �����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addPercentSign(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004108Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004108Design getThis() {
    return this;
  }
}
