
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
 * �J����: �����@���̂�
 * �쐬��: 2018/01/27  ���{�R���s���[�^�[������� �����@���̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �ʏ����n (QO004_11611_201804)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
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
 * �ʏ����n��ʍ��ڃf�U�C��(QO004_11611_201804) 
 */
public class QO004_11611_201804Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private JTabbedPane tab;

  private ACPanel panel1;

  private ACPanel calculationDetails;

  private ACValueArrayRadioButtonGroup facilitiesDivisionAfterH2104RadioGroup;

  private ACLabelContainer facilitiesDivisionAfterH2104RadioGroupContainer;

  private ACListModelAdapter facilitiesDivisionAfterH2104RadioGroupModel;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem1;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem4;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem7;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem2;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem5;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem8;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem3;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem6;

  private ACRadioButtonItem facilitiesDivisionAfterH2104RadioItem9;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACRadioButtonItem staffLackItem4;

  private ACRadioButtonItem staffLackItem5;

  private ACRadioButtonItem staffLackItem6;

  private ACRadioButtonItem staffLackItem7;

  private ACValueArrayRadioButtonGroup extendTime;

  private ACLabelContainer extendTimeContainer;

  private ACListModelAdapter extendTimeModel;

  private ACRadioButtonItem extendTimeItem1;

  private ACRadioButtonItem extendTimeItem2;

  private ACValueArrayRadioButtonGroup rehabilitationSystem;

  private ACLabelContainer rehabilitationSystemContainer;

  private ACListModelAdapter rehabilitationSystemModel;

  private ACRadioButtonItem rehabilitationSystemItem1;

  private ACRadioButtonItem rehabilitationSystemItem2;

  private ACValueArrayRadioButtonGroup bathingHelpSystem;

  private ACLabelContainer bathingHelpSystemContainer;

  private ACListModelAdapter bathingHelpSystemModel;

  private ACRadioButtonItem bathingHelpSystemItem1;

  private ACRadioButtonItem bathingHelpSystemItem2;

  private ACValueArrayRadioButtonGroup rehabilitationManagementRadioGroup;

  private ACLabelContainer rehabilitationManagementRadioGroupContainer;

  private ACListModelAdapter rehabilitationManagementRadioGroupModel;

  private ACRadioButtonItem rehabilitationManagementRadioItem1;

  private ACRadioButtonItem rehabilitationManagementRadioItem2;

  private ACRadioButtonItem rehabilitationManagementRadioItem3;

  private ACRadioButtonItem rehabilitationManagementRadioItem4;

  private ACRadioButtonItem rehabilitationManagementRadioItem5;

  private ACPanel panel2;

  private ACPanel calculationDetails2;

  private ACValueArrayRadioButtonGroup intensiveRehabilitationRadioGroup;

  private ACLabelContainer intensiveRehabilitationRadioGroupContainer;

  private ACListModelAdapter intensiveRehabilitationRadioGroupModel;

  private ACRadioButtonItem intensiveRehabilitationRadioItem1;

  private ACRadioButtonItem intensiveRehabilitationRadioItem2;

  private ACValueArrayRadioButtonGroup dementiaRihaAddRadioGroup;

  private ACLabelContainer dementiaRihaAddRadioGroupContainer;

  private ACListModelAdapter dementiaRihaAddRadioGroupModel;

  private ACRadioButtonItem dementiaRihaAddRadioItem1;

  private ACRadioButtonItem dementiaRihaAddRadioItem2;

  private ACRadioButtonItem dementiaRihaAddRadioItem3;

  private ACValueArrayRadioButtonGroup lifeActsImproveRehabilitationRadioGroup;

  private ACLabelContainer lifeActsImproveRehabilitationRadioGroupContainer;

  private ACListModelAdapter lifeActsImproveRehabilitationRadioGroupModel;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem1;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup nourishmentImprovement;

  private ACLabelContainer nourishmentImprovementContainer;

  private ACListModelAdapter nourishmentImprovementModel;

  private ACRadioButtonItem nourishmentImprovementItem1;

  private ACRadioButtonItem nourishmentImprovementItem2;

  private ACValueArrayRadioButtonGroup mouthImprovementAdd;

  private ACLabelContainer mouthImprovementAddContainer;

  private ACListModelAdapter mouthImprovementAddModel;

  private ACRadioButtonItem mouthImprovementAddItem1;

  private ACRadioButtonItem mouthImprovementAddItem2;

  private ACValueArrayRadioButtonGroup mediumSeverePersonCare;

  private ACLabelContainer mediumSeverePersonCareContainer;

  private ACListModelAdapter mediumSeverePersonCareModel;

  private ACRadioButtonItem mediumSeverePersonCareItem1;

  private ACRadioButtonItem mediumSeverePersonCareItem2;

  private ACValueArrayRadioButtonGroup socialSupportRadioGroup;

  private ACLabelContainer socialSupportRadioGroupContainer;

  private ACListModelAdapter socialSupportRadioGroupModel;

  private ACRadioButtonItem socialSupportRadioItem1;

  private ACRadioButtonItem socialSupportRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  private ACRadioButtonItem staffUpgradeRadioItem5;

  private ACRadioButtonItem staffUpgradeRadioItem6;

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
   * �^�u���擾���܂��B
   * @return �^�u
   */
  public JTabbedPane getTab(){
    if(tab==null){

      tab = new JTabbedPane();

      addTab();
    }
    return tab;

  }

  /**
   * �p�l���P���擾���܂��B
   * @return �p�l���P
   */
  public ACPanel getPanel1(){
    if(panel1==null){

      panel1 = new ACPanel();

      panel1.setFollowChildEnabled(true);

      addPanel1();
    }
    return panel1;

  }

  /**
   * �Z�荀�ڗ̈���擾���܂��B
   * @return �Z�荀�ڗ̈�
   */
  public ACPanel getCalculationDetails(){
    if(calculationDetails==null){

      calculationDetails = new ACPanel();

      calculationDetails.setFollowChildEnabled(true);

      calculationDetails.setHgrid(200);

      addCalculationDetails();
    }
    return calculationDetails;

  }

  /**
   * �{�݋敪���W�I�O���[�v�i����21�N4���ȍ~�j���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�i����21�N4���ȍ~�j
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivisionAfterH2104RadioGroup(){
    if(facilitiesDivisionAfterH2104RadioGroup==null){

      facilitiesDivisionAfterH2104RadioGroup = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionAfterH2104RadioGroupContainer().setText("�{�ݓ��̋敪");

      facilitiesDivisionAfterH2104RadioGroup.setBindPath("1160112");

      facilitiesDivisionAfterH2104RadioGroup.setNoSelectIndex(0);

      facilitiesDivisionAfterH2104RadioGroup.setUseClearButton(false);

      facilitiesDivisionAfterH2104RadioGroup.setModel(getFacilitiesDivisionAfterH2104RadioGroupModel());

      facilitiesDivisionAfterH2104RadioGroup.setValues(new int[]{1,2,7,3,4,8,5,6,9});

      addFacilitiesDivisionAfterH2104RadioGroup();
    }
    return facilitiesDivisionAfterH2104RadioGroup;

  }

  /**
   * �{�݋敪���W�I�O���[�v�i����21�N4���ȍ~�j�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�i����21�N4���ȍ~�j�R���e�i
   */
  protected ACLabelContainer getFacilitiesDivisionAfterH2104RadioGroupContainer(){
    if(facilitiesDivisionAfterH2104RadioGroupContainer==null){
      facilitiesDivisionAfterH2104RadioGroupContainer = new ACLabelContainer();
      facilitiesDivisionAfterH2104RadioGroupContainer.setFollowChildEnabled(true);
      facilitiesDivisionAfterH2104RadioGroupContainer.setVAlignment(VRLayout.CENTER);
      facilitiesDivisionAfterH2104RadioGroupContainer.add(getFacilitiesDivisionAfterH2104RadioGroup(), null);
    }
    return facilitiesDivisionAfterH2104RadioGroupContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v�i����21�N4���ȍ~�j���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�i����21�N4���ȍ~�j���f��
   */
  protected ACListModelAdapter getFacilitiesDivisionAfterH2104RadioGroupModel(){
    if(facilitiesDivisionAfterH2104RadioGroupModel==null){
      facilitiesDivisionAfterH2104RadioGroupModel = new ACListModelAdapter();
      addFacilitiesDivisionAfterH2104RadioGroupModel();
    }
    return facilitiesDivisionAfterH2104RadioGroupModel;
  }

  /**
   * �ʏ�K�͂̎��Ə�(�a�@�E�f�Ï�)���擾���܂��B
   * @return �ʏ�K�͂̎��Ə�(�a�@�E�f�Ï�)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem1(){
    if(facilitiesDivisionAfterH2104RadioItem1==null){

      facilitiesDivisionAfterH2104RadioItem1 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem1.setText("�ʏ�K�͂̎��Ə�  (�a�@�E�f�Ï�)");

      facilitiesDivisionAfterH2104RadioItem1.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem1();
    }
    return facilitiesDivisionAfterH2104RadioItem1;

  }

  /**
   * �ʏ�K�͂̎��Ə�(���V�l�ی��{��)���擾���܂��B
   * @return �ʏ�K�͂̎��Ə�(���V�l�ی��{��)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem4(){
    if(facilitiesDivisionAfterH2104RadioItem4==null){

      facilitiesDivisionAfterH2104RadioItem4 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem4.setText("�ʏ�K�͂̎��Ə�  (���V�l�ی��{��)");

      facilitiesDivisionAfterH2104RadioItem4.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem4();
    }
    return facilitiesDivisionAfterH2104RadioItem4;

  }

  /**
   * �ʏ�K�͂̎��Ə�(����É@)���擾���܂��B
   * @return �ʏ�K�͂̎��Ə�(����É@)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem7(){
    if(facilitiesDivisionAfterH2104RadioItem7==null){

      facilitiesDivisionAfterH2104RadioItem7 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem7.setText("�ʏ�K�͂̎��Ə�  (����É@)");

      facilitiesDivisionAfterH2104RadioItem7.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem7.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem7();
    }
    return facilitiesDivisionAfterH2104RadioItem7;

  }

  /**
   * ��K�͎��Ə�(I)(�a�@�E�f�Ï�)���擾���܂��B
   * @return ��K�͎��Ə�(I)(�a�@�E�f�Ï�)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem2(){
    if(facilitiesDivisionAfterH2104RadioItem2==null){

      facilitiesDivisionAfterH2104RadioItem2 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem2.setText("��K�͎��Ə��iI�j (�a�@�E�f�Ï�)");

      facilitiesDivisionAfterH2104RadioItem2.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem2();
    }
    return facilitiesDivisionAfterH2104RadioItem2;

  }

  /**
   * ��K�͎��Ə�(I)(���V�l�ی��{��)���擾���܂��B
   * @return ��K�͎��Ə�(I)(���V�l�ی��{��)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem5(){
    if(facilitiesDivisionAfterH2104RadioItem5==null){

      facilitiesDivisionAfterH2104RadioItem5 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem5.setText("��K�͎��Ə��iI�j (���V�l�ی��{��)");

      facilitiesDivisionAfterH2104RadioItem5.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem5.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem5();
    }
    return facilitiesDivisionAfterH2104RadioItem5;

  }

  /**
   * ��K�͎��Ə�(I)(����É@)���擾���܂��B
   * @return ��K�͎��Ə�(I)(����É@)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem8(){
    if(facilitiesDivisionAfterH2104RadioItem8==null){

      facilitiesDivisionAfterH2104RadioItem8 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem8.setText("��K�͎��Ə��iI�j (����É@)");

      facilitiesDivisionAfterH2104RadioItem8.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem8.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem8();
    }
    return facilitiesDivisionAfterH2104RadioItem8;

  }

  /**
   * ��K�͎��Ə�(II)(�a�@�E�f�Ï�)���擾���܂��B
   * @return ��K�͎��Ə�(II)(�a�@�E�f�Ï�)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem3(){
    if(facilitiesDivisionAfterH2104RadioItem3==null){

      facilitiesDivisionAfterH2104RadioItem3 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem3.setText("��K�͎��Ə��iII�j(�a�@�E�f�Ï�)");

      facilitiesDivisionAfterH2104RadioItem3.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem3();
    }
    return facilitiesDivisionAfterH2104RadioItem3;

  }

  /**
   * ��K�͎��Ə�(II)(���V�l�ی��{��)���擾���܂��B
   * @return ��K�͎��Ə�(II)(���V�l�ی��{��)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem6(){
    if(facilitiesDivisionAfterH2104RadioItem6==null){

      facilitiesDivisionAfterH2104RadioItem6 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem6.setText("��K�͎��Ə��iII�j(���V�l�ی��{��)");

      facilitiesDivisionAfterH2104RadioItem6.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem6.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem6();
    }
    return facilitiesDivisionAfterH2104RadioItem6;

  }

  /**
   * ��K�͎��Ə�(II)(����É@)���擾���܂��B
   * @return ��K�͎��Ə�(II)(����É@)
   */
  public ACRadioButtonItem getFacilitiesDivisionAfterH2104RadioItem9(){
    if(facilitiesDivisionAfterH2104RadioItem9==null){

      facilitiesDivisionAfterH2104RadioItem9 = new ACRadioButtonItem();

      facilitiesDivisionAfterH2104RadioItem9.setText("��K�͎��Ə��iII�j(����É@)");

      facilitiesDivisionAfterH2104RadioItem9.setGroup(getFacilitiesDivisionAfterH2104RadioGroup());

      facilitiesDivisionAfterH2104RadioItem9.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionAfterH2104RadioItem9();
    }
    return facilitiesDivisionAfterH2104RadioItem9;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("1160105");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3,4,5,6,7});

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
  public ACValueArrayRadioButtonGroup getExtendTime(){
    if(extendTime==null){

      extendTime = new ACValueArrayRadioButtonGroup();

      getExtendTimeContainer().setText("���ԉ����T�[�r�X�̐�");

      extendTime.setBindPath("1160110");

      extendTime.setUseClearButton(false);

      extendTime.setModel(getExtendTimeModel());

      extendTime.setValues(new int[]{1,2});

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
   * ���n�r���e�[�V�����񋟑̐����Z���擾���܂��B
   * @return ���n�r���e�[�V�����񋟑̐����Z
   */
  public ACValueArrayRadioButtonGroup getRehabilitationSystem(){
    if(rehabilitationSystem==null){

      rehabilitationSystem = new ACValueArrayRadioButtonGroup();

      getRehabilitationSystemContainer().setText("���n�r���e�[�V�����񋟑̐����Z");

      rehabilitationSystem.setBindPath("1160126");

      rehabilitationSystem.setUseClearButton(false);

      rehabilitationSystem.setModel(getRehabilitationSystemModel());

      rehabilitationSystem.setValues(new int[]{1,2});

      addRehabilitationSystem();
    }
    return rehabilitationSystem;

  }

  /**
   * ���n�r���e�[�V�����񋟑̐����Z�R���e�i���擾���܂��B
   * @return ���n�r���e�[�V�����񋟑̐����Z�R���e�i
   */
  protected ACLabelContainer getRehabilitationSystemContainer(){
    if(rehabilitationSystemContainer==null){
      rehabilitationSystemContainer = new ACLabelContainer();
      rehabilitationSystemContainer.setFollowChildEnabled(true);
      rehabilitationSystemContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationSystemContainer.add(getRehabilitationSystem(), null);
    }
    return rehabilitationSystemContainer;
  }

  /**
   * ���n�r���e�[�V�����񋟑̐����Z���f�����擾���܂��B
   * @return ���n�r���e�[�V�����񋟑̐����Z���f��
   */
  protected ACListModelAdapter getRehabilitationSystemModel(){
    if(rehabilitationSystemModel==null){
      rehabilitationSystemModel = new ACListModelAdapter();
      addRehabilitationSystemModel();
    }
    return rehabilitationSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRehabilitationSystemItem1(){
    if(rehabilitationSystemItem1==null){

      rehabilitationSystemItem1 = new ACRadioButtonItem();

      rehabilitationSystemItem1.setText("�Ȃ�");

      rehabilitationSystemItem1.setGroup(getRehabilitationSystem());

      rehabilitationSystemItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationSystemItem1();
    }
    return rehabilitationSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getRehabilitationSystemItem2(){
    if(rehabilitationSystemItem2==null){

      rehabilitationSystemItem2 = new ACRadioButtonItem();

      rehabilitationSystemItem2.setText("����");

      rehabilitationSystemItem2.setGroup(getRehabilitationSystem());

      rehabilitationSystemItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationSystemItem2();
    }
    return rehabilitationSystemItem2;

  }

  /**
   * ������̐����W�I�O���[�v���擾���܂��B
   * @return ������̐����W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getBathingHelpSystem(){
    if(bathingHelpSystem==null){

      bathingHelpSystem = new ACValueArrayRadioButtonGroup();

      getBathingHelpSystemContainer().setText("������̐�");

      bathingHelpSystem.setBindPath("1160102");

      bathingHelpSystem.setUseClearButton(false);

      bathingHelpSystem.setModel(getBathingHelpSystemModel());

      bathingHelpSystem.setValues(new int[]{1,2});

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

      bathingHelpSystemItem1.setConstraints(VRLayout.FLOW);

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

      bathingHelpSystemItem2.setConstraints(VRLayout.FLOW);

      addBathingHelpSystemItem2();
    }
    return bathingHelpSystemItem2;

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z���擾���܂��B
   * @return ���n�r���e�[�V�����}�l�W�����g���Z
   */
  public ACValueArrayRadioButtonGroup getRehabilitationManagementRadioGroup(){
    if(rehabilitationManagementRadioGroup==null){

      rehabilitationManagementRadioGroup = new ACValueArrayRadioButtonGroup();

      getRehabilitationManagementRadioGroupContainer().setText("���n�r���e�[�V�����}�l�W�����g���Z");

      rehabilitationManagementRadioGroup.setBindPath("1160119");

      rehabilitationManagementRadioGroup.setVisible(true);

      rehabilitationManagementRadioGroup.setEnabled(true);

      rehabilitationManagementRadioGroup.setNoSelectIndex(0);

      rehabilitationManagementRadioGroup.setUseClearButton(false);

      rehabilitationManagementRadioGroup.setModel(getRehabilitationManagementRadioGroupModel());

      rehabilitationManagementRadioGroup.setValues(new int[]{1,2,3,4,5});

      addRehabilitationManagementRadioGroup();
    }
    return rehabilitationManagementRadioGroup;

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z�R���e�i���擾���܂��B
   * @return ���n�r���e�[�V�����}�l�W�����g���Z�R���e�i
   */
  protected ACLabelContainer getRehabilitationManagementRadioGroupContainer(){
    if(rehabilitationManagementRadioGroupContainer==null){
      rehabilitationManagementRadioGroupContainer = new ACLabelContainer();
      rehabilitationManagementRadioGroupContainer.setFollowChildEnabled(true);
      rehabilitationManagementRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      rehabilitationManagementRadioGroupContainer.add(getRehabilitationManagementRadioGroup(), null);
    }
    return rehabilitationManagementRadioGroupContainer;
  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z���f�����擾���܂��B
   * @return ���n�r���e�[�V�����}�l�W�����g���Z���f��
   */
  protected ACListModelAdapter getRehabilitationManagementRadioGroupModel(){
    if(rehabilitationManagementRadioGroupModel==null){
      rehabilitationManagementRadioGroupModel = new ACListModelAdapter();
      addRehabilitationManagementRadioGroupModel();
    }
    return rehabilitationManagementRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem1(){
    if(rehabilitationManagementRadioItem1==null){

      rehabilitationManagementRadioItem1 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem1.setText("�Ȃ�");

      rehabilitationManagementRadioItem1.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem1.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem1();
    }
    return rehabilitationManagementRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem2(){
    if(rehabilitationManagementRadioItem2==null){

      rehabilitationManagementRadioItem2 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem2.setText("���ZI");

      rehabilitationManagementRadioItem2.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem2.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem2();
    }
    return rehabilitationManagementRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem3(){
    if(rehabilitationManagementRadioItem3==null){

      rehabilitationManagementRadioItem3 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem3.setText("���ZII");

      rehabilitationManagementRadioItem3.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addRehabilitationManagementRadioItem3();
    }
    return rehabilitationManagementRadioItem3;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem4(){
    if(rehabilitationManagementRadioItem4==null){

      rehabilitationManagementRadioItem4 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem4.setText("���ZIII");

      rehabilitationManagementRadioItem4.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem4.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem4();
    }
    return rehabilitationManagementRadioItem4;

  }

  /**
   * ���ZIV���擾���܂��B
   * @return ���ZIV
   */
  public ACRadioButtonItem getRehabilitationManagementRadioItem5(){
    if(rehabilitationManagementRadioItem5==null){

      rehabilitationManagementRadioItem5 = new ACRadioButtonItem();

      rehabilitationManagementRadioItem5.setText("���ZIV");

      rehabilitationManagementRadioItem5.setGroup(getRehabilitationManagementRadioGroup());

      rehabilitationManagementRadioItem5.setConstraints(VRLayout.FLOW);

      addRehabilitationManagementRadioItem5();
    }
    return rehabilitationManagementRadioItem5;

  }

  /**
   * �p�l��2���擾���܂��B
   * @return �p�l��2
   */
  public ACPanel getPanel2(){
    if(panel2==null){

      panel2 = new ACPanel();

      panel2.setFollowChildEnabled(true);

      addPanel2();
    }
    return panel2;

  }

  /**
   * �Z�荀�ڗ̈�2���擾���܂��B
   * @return �Z�荀�ڗ̈�2
   */
  public ACPanel getCalculationDetails2(){
    if(calculationDetails2==null){

      calculationDetails2 = new ACPanel();

      calculationDetails2.setFollowChildEnabled(true);

      calculationDetails2.setHgrid(200);

      addCalculationDetails2();
    }
    return calculationDetails2;

  }

  /**
   * �Z���W���ʃ��n�r���e�[�V�������{���Z���擾���܂��B
   * @return �Z���W���ʃ��n�r���e�[�V�������{���Z
   */
  public ACValueArrayRadioButtonGroup getIntensiveRehabilitationRadioGroup(){
    if(intensiveRehabilitationRadioGroup==null){

      intensiveRehabilitationRadioGroup = new ACValueArrayRadioButtonGroup();

      getIntensiveRehabilitationRadioGroupContainer().setText("�Z���W���ʃ��n�r���e�[�V�������{���Z");

      intensiveRehabilitationRadioGroup.setBindPath("1160120");

      intensiveRehabilitationRadioGroup.setVisible(true);

      intensiveRehabilitationRadioGroup.setEnabled(true);

      intensiveRehabilitationRadioGroup.setNoSelectIndex(0);

      intensiveRehabilitationRadioGroup.setUseClearButton(false);

      intensiveRehabilitationRadioGroup.setModel(getIntensiveRehabilitationRadioGroupModel());

      intensiveRehabilitationRadioGroup.setValues(new int[]{1,2});

      addIntensiveRehabilitationRadioGroup();
    }
    return intensiveRehabilitationRadioGroup;

  }

  /**
   * �Z���W���ʃ��n�r���e�[�V�������{���Z�R���e�i���擾���܂��B
   * @return �Z���W���ʃ��n�r���e�[�V�������{���Z�R���e�i
   */
  protected ACLabelContainer getIntensiveRehabilitationRadioGroupContainer(){
    if(intensiveRehabilitationRadioGroupContainer==null){
      intensiveRehabilitationRadioGroupContainer = new ACLabelContainer();
      intensiveRehabilitationRadioGroupContainer.setFollowChildEnabled(true);
      intensiveRehabilitationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      intensiveRehabilitationRadioGroupContainer.add(getIntensiveRehabilitationRadioGroup(), null);
    }
    return intensiveRehabilitationRadioGroupContainer;
  }

  /**
   * �Z���W���ʃ��n�r���e�[�V�������{���Z���f�����擾���܂��B
   * @return �Z���W���ʃ��n�r���e�[�V�������{���Z���f��
   */
  protected ACListModelAdapter getIntensiveRehabilitationRadioGroupModel(){
    if(intensiveRehabilitationRadioGroupModel==null){
      intensiveRehabilitationRadioGroupModel = new ACListModelAdapter();
      addIntensiveRehabilitationRadioGroupModel();
    }
    return intensiveRehabilitationRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getIntensiveRehabilitationRadioItem1(){
    if(intensiveRehabilitationRadioItem1==null){

      intensiveRehabilitationRadioItem1 = new ACRadioButtonItem();

      intensiveRehabilitationRadioItem1.setText("�Ȃ�");

      intensiveRehabilitationRadioItem1.setGroup(getIntensiveRehabilitationRadioGroup());

      intensiveRehabilitationRadioItem1.setConstraints(VRLayout.FLOW);

      addIntensiveRehabilitationRadioItem1();
    }
    return intensiveRehabilitationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getIntensiveRehabilitationRadioItem2(){
    if(intensiveRehabilitationRadioItem2==null){

      intensiveRehabilitationRadioItem2 = new ACRadioButtonItem();

      intensiveRehabilitationRadioItem2.setText("����");

      intensiveRehabilitationRadioItem2.setGroup(getIntensiveRehabilitationRadioGroup());

      intensiveRehabilitationRadioItem2.setConstraints(VRLayout.FLOW);

      addIntensiveRehabilitationRadioItem2();
    }
    return intensiveRehabilitationRadioItem2;

  }

  /**
   * �F�m�ǒZ���W�����n�r���e�[�V�������{���Z���擾���܂��B
   * @return �F�m�ǒZ���W�����n�r���e�[�V�������{���Z
   */
  public ACValueArrayRadioButtonGroup getDementiaRihaAddRadioGroup(){
    if(dementiaRihaAddRadioGroup==null){

      dementiaRihaAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getDementiaRihaAddRadioGroupContainer().setText("�F�m�ǒZ���W�����n�r���e�[�V�������{���Z");

      dementiaRihaAddRadioGroup.setBindPath("1160113");

      dementiaRihaAddRadioGroup.setNoSelectIndex(0);

      dementiaRihaAddRadioGroup.setUseClearButton(false);

      dementiaRihaAddRadioGroup.setModel(getDementiaRihaAddRadioGroupModel());

      dementiaRihaAddRadioGroup.setValues(new int[]{1,2,3});

      addDementiaRihaAddRadioGroup();
    }
    return dementiaRihaAddRadioGroup;

  }

  /**
   * �F�m�ǒZ���W�����n�r���e�[�V�������{���Z�R���e�i���擾���܂��B
   * @return �F�m�ǒZ���W�����n�r���e�[�V�������{���Z�R���e�i
   */
  protected ACLabelContainer getDementiaRihaAddRadioGroupContainer(){
    if(dementiaRihaAddRadioGroupContainer==null){
      dementiaRihaAddRadioGroupContainer = new ACLabelContainer();
      dementiaRihaAddRadioGroupContainer.setFollowChildEnabled(true);
      dementiaRihaAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      dementiaRihaAddRadioGroupContainer.add(getDementiaRihaAddRadioGroup(), null);
    }
    return dementiaRihaAddRadioGroupContainer;
  }

  /**
   * �F�m�ǒZ���W�����n�r���e�[�V�������{���Z���f�����擾���܂��B
   * @return �F�m�ǒZ���W�����n�r���e�[�V�������{���Z���f��
   */
  protected ACListModelAdapter getDementiaRihaAddRadioGroupModel(){
    if(dementiaRihaAddRadioGroupModel==null){
      dementiaRihaAddRadioGroupModel = new ACListModelAdapter();
      addDementiaRihaAddRadioGroupModel();
    }
    return dementiaRihaAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaRihaAddRadioItem1(){
    if(dementiaRihaAddRadioItem1==null){

      dementiaRihaAddRadioItem1 = new ACRadioButtonItem();

      dementiaRihaAddRadioItem1.setText("�Ȃ�");

      dementiaRihaAddRadioItem1.setGroup(getDementiaRihaAddRadioGroup());

      dementiaRihaAddRadioItem1.setConstraints(VRLayout.FLOW);

      addDementiaRihaAddRadioItem1();
    }
    return dementiaRihaAddRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getDementiaRihaAddRadioItem2(){
    if(dementiaRihaAddRadioItem2==null){

      dementiaRihaAddRadioItem2 = new ACRadioButtonItem();

      dementiaRihaAddRadioItem2.setText("���ZI");

      dementiaRihaAddRadioItem2.setGroup(getDementiaRihaAddRadioGroup());

      dementiaRihaAddRadioItem2.setConstraints(VRLayout.FLOW);

      addDementiaRihaAddRadioItem2();
    }
    return dementiaRihaAddRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getDementiaRihaAddRadioItem3(){
    if(dementiaRihaAddRadioItem3==null){

      dementiaRihaAddRadioItem3 = new ACRadioButtonItem();

      dementiaRihaAddRadioItem3.setText("���ZII");

      dementiaRihaAddRadioItem3.setGroup(getDementiaRihaAddRadioGroup());

      dementiaRihaAddRadioItem3.setConstraints(VRLayout.FLOW);

      addDementiaRihaAddRadioItem3();
    }
    return dementiaRihaAddRadioItem3;

  }

  /**
   * �����s�׌��ナ�n�r���e�[�V�������{���Z���擾���܂��B
   * @return �����s�׌��ナ�n�r���e�[�V�������{���Z
   */
  public ACValueArrayRadioButtonGroup getLifeActsImproveRehabilitationRadioGroup(){
    if(lifeActsImproveRehabilitationRadioGroup==null){

      lifeActsImproveRehabilitationRadioGroup = new ACValueArrayRadioButtonGroup();

      getLifeActsImproveRehabilitationRadioGroupContainer().setText("�����s�׌��ナ�n�r���e�[�V�������{���Z");

      lifeActsImproveRehabilitationRadioGroup.setBindPath("1160121");

      lifeActsImproveRehabilitationRadioGroup.setVisible(true);

      lifeActsImproveRehabilitationRadioGroup.setEnabled(true);

      lifeActsImproveRehabilitationRadioGroup.setNoSelectIndex(0);

      lifeActsImproveRehabilitationRadioGroup.setUseClearButton(false);

      lifeActsImproveRehabilitationRadioGroup.setModel(getLifeActsImproveRehabilitationRadioGroupModel());

      lifeActsImproveRehabilitationRadioGroup.setValues(new int[]{1,2});

      addLifeActsImproveRehabilitationRadioGroup();
    }
    return lifeActsImproveRehabilitationRadioGroup;

  }

  /**
   * �����s�׌��ナ�n�r���e�[�V�������{���Z�R���e�i���擾���܂��B
   * @return �����s�׌��ナ�n�r���e�[�V�������{���Z�R���e�i
   */
  protected ACLabelContainer getLifeActsImproveRehabilitationRadioGroupContainer(){
    if(lifeActsImproveRehabilitationRadioGroupContainer==null){
      lifeActsImproveRehabilitationRadioGroupContainer = new ACLabelContainer();
      lifeActsImproveRehabilitationRadioGroupContainer.setFollowChildEnabled(true);
      lifeActsImproveRehabilitationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      lifeActsImproveRehabilitationRadioGroupContainer.add(getLifeActsImproveRehabilitationRadioGroup(), null);
    }
    return lifeActsImproveRehabilitationRadioGroupContainer;
  }

  /**
   * �����s�׌��ナ�n�r���e�[�V�������{���Z���f�����擾���܂��B
   * @return �����s�׌��ナ�n�r���e�[�V�������{���Z���f��
   */
  protected ACListModelAdapter getLifeActsImproveRehabilitationRadioGroupModel(){
    if(lifeActsImproveRehabilitationRadioGroupModel==null){
      lifeActsImproveRehabilitationRadioGroupModel = new ACListModelAdapter();
      addLifeActsImproveRehabilitationRadioGroupModel();
    }
    return lifeActsImproveRehabilitationRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem1(){
    if(lifeActsImproveRehabilitationRadioItem1==null){

      lifeActsImproveRehabilitationRadioItem1 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem1.setText("�Ȃ�");

      lifeActsImproveRehabilitationRadioItem1.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem1.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehabilitationRadioItem1();
    }
    return lifeActsImproveRehabilitationRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem2(){
    if(lifeActsImproveRehabilitationRadioItem2==null){

      lifeActsImproveRehabilitationRadioItem2 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem2.setText("����");

      lifeActsImproveRehabilitationRadioItem2.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem2.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehabilitationRadioItem2();
    }
    return lifeActsImproveRehabilitationRadioItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1160114");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z�R���e�i
   */
  protected ACLabelContainer getYoungDementiaPatinetAddRadioGroupContainer(){
    if(youngDementiaPatinetAddRadioGroupContainer==null){
      youngDementiaPatinetAddRadioGroupContainer = new ACLabelContainer();
      youngDementiaPatinetAddRadioGroupContainer.setFollowChildEnabled(true);
      youngDementiaPatinetAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      youngDementiaPatinetAddRadioGroupContainer.add(getYoungDementiaPatinetAddRadioGroup(), null);
    }
    return youngDementiaPatinetAddRadioGroupContainer;
  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f�����擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z���f��
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("�Ȃ�");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("����");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * �h�{���P�̐����擾���܂��B
   * @return �h�{���P�̐�
   */
  public ACValueArrayRadioButtonGroup getNourishmentImprovement(){
    if(nourishmentImprovement==null){

      nourishmentImprovement = new ACValueArrayRadioButtonGroup();

      getNourishmentImprovementContainer().setText("�h�{���P�̐�");

      nourishmentImprovement.setBindPath("1160116");

      nourishmentImprovement.setUseClearButton(false);

      nourishmentImprovement.setModel(getNourishmentImprovementModel());

      nourishmentImprovement.setValues(new int[]{1,2});

      addNourishmentImprovement();
    }
    return nourishmentImprovement;

  }

  /**
   * �h�{���P�̐��R���e�i���擾���܂��B
   * @return �h�{���P�̐��R���e�i
   */
  protected ACLabelContainer getNourishmentImprovementContainer(){
    if(nourishmentImprovementContainer==null){
      nourishmentImprovementContainer = new ACLabelContainer();
      nourishmentImprovementContainer.setFollowChildEnabled(true);
      nourishmentImprovementContainer.setVAlignment(VRLayout.CENTER);
      nourishmentImprovementContainer.add(getNourishmentImprovement(), null);
    }
    return nourishmentImprovementContainer;
  }

  /**
   * �h�{���P�̐����f�����擾���܂��B
   * @return �h�{���P�̐����f��
   */
  protected ACListModelAdapter getNourishmentImprovementModel(){
    if(nourishmentImprovementModel==null){
      nourishmentImprovementModel = new ACListModelAdapter();
      addNourishmentImprovementModel();
    }
    return nourishmentImprovementModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getNourishmentImprovementItem1(){
    if(nourishmentImprovementItem1==null){

      nourishmentImprovementItem1 = new ACRadioButtonItem();

      nourishmentImprovementItem1.setText("�Ȃ�");

      nourishmentImprovementItem1.setGroup(getNourishmentImprovement());

      nourishmentImprovementItem1.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementItem1();
    }
    return nourishmentImprovementItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getNourishmentImprovementItem2(){
    if(nourishmentImprovementItem2==null){

      nourishmentImprovementItem2 = new ACRadioButtonItem();

      nourishmentImprovementItem2.setText("����");

      nourishmentImprovementItem2.setGroup(getNourishmentImprovement());

      nourishmentImprovementItem2.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementItem2();
    }
    return nourishmentImprovementItem2;

  }

  /**
   * ���o�@�\����̐����擾���܂��B
   * @return ���o�@�\����̐�
   */
  public ACValueArrayRadioButtonGroup getMouthImprovementAdd(){
    if(mouthImprovementAdd==null){

      mouthImprovementAdd = new ACValueArrayRadioButtonGroup();

      getMouthImprovementAddContainer().setText("���o�@�\����̐�");

      mouthImprovementAdd.setBindPath("1160109");

      mouthImprovementAdd.setUseClearButton(false);

      mouthImprovementAdd.setModel(getMouthImprovementAddModel());

      mouthImprovementAdd.setValues(new int[]{1,2});

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
   * ���d�x�҃P�A�̐����Z���擾���܂��B
   * @return ���d�x�҃P�A�̐����Z
   */
  public ACValueArrayRadioButtonGroup getMediumSeverePersonCare(){
    if(mediumSeverePersonCare==null){

      mediumSeverePersonCare = new ACValueArrayRadioButtonGroup();

      getMediumSeverePersonCareContainer().setText("���d�x�҃P�A�̐����Z");

      mediumSeverePersonCare.setBindPath("1160124");

      mediumSeverePersonCare.setUseClearButton(false);

      mediumSeverePersonCare.setModel(getMediumSeverePersonCareModel());

      mediumSeverePersonCare.setValues(new int[]{1,2});

      addMediumSeverePersonCare();
    }
    return mediumSeverePersonCare;

  }

  /**
   * ���d�x�҃P�A�̐����Z�R���e�i���擾���܂��B
   * @return ���d�x�҃P�A�̐����Z�R���e�i
   */
  protected ACLabelContainer getMediumSeverePersonCareContainer(){
    if(mediumSeverePersonCareContainer==null){
      mediumSeverePersonCareContainer = new ACLabelContainer();
      mediumSeverePersonCareContainer.setFollowChildEnabled(true);
      mediumSeverePersonCareContainer.setVAlignment(VRLayout.CENTER);
      mediumSeverePersonCareContainer.add(getMediumSeverePersonCare(), null);
    }
    return mediumSeverePersonCareContainer;
  }

  /**
   * ���d�x�҃P�A�̐����Z���f�����擾���܂��B
   * @return ���d�x�҃P�A�̐����Z���f��
   */
  protected ACListModelAdapter getMediumSeverePersonCareModel(){
    if(mediumSeverePersonCareModel==null){
      mediumSeverePersonCareModel = new ACListModelAdapter();
      addMediumSeverePersonCareModel();
    }
    return mediumSeverePersonCareModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getMediumSeverePersonCareItem1(){
    if(mediumSeverePersonCareItem1==null){

      mediumSeverePersonCareItem1 = new ACRadioButtonItem();

      mediumSeverePersonCareItem1.setText("�Ȃ�");

      mediumSeverePersonCareItem1.setGroup(getMediumSeverePersonCare());

      mediumSeverePersonCareItem1.setConstraints(VRLayout.FLOW);

      addMediumSeverePersonCareItem1();
    }
    return mediumSeverePersonCareItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getMediumSeverePersonCareItem2(){
    if(mediumSeverePersonCareItem2==null){

      mediumSeverePersonCareItem2 = new ACRadioButtonItem();

      mediumSeverePersonCareItem2.setText("����");

      mediumSeverePersonCareItem2.setGroup(getMediumSeverePersonCare());

      mediumSeverePersonCareItem2.setConstraints(VRLayout.FLOW);

      addMediumSeverePersonCareItem2();
    }
    return mediumSeverePersonCareItem2;

  }

  /**
   * �Љ�Q���x�����Z���擾���܂��B
   * @return �Љ�Q���x�����Z
   */
  public ACValueArrayRadioButtonGroup getSocialSupportRadioGroup(){
    if(socialSupportRadioGroup==null){

      socialSupportRadioGroup = new ACValueArrayRadioButtonGroup();

      getSocialSupportRadioGroupContainer().setText("�Љ�Q���x�����Z");

      socialSupportRadioGroup.setBindPath("1160125");

      socialSupportRadioGroup.setVisible(true);

      socialSupportRadioGroup.setEnabled(true);

      socialSupportRadioGroup.setNoSelectIndex(0);

      socialSupportRadioGroup.setUseClearButton(false);

      socialSupportRadioGroup.setModel(getSocialSupportRadioGroupModel());

      socialSupportRadioGroup.setValues(new int[]{1,2});

      addSocialSupportRadioGroup();
    }
    return socialSupportRadioGroup;

  }

  /**
   * �Љ�Q���x�����Z�R���e�i���擾���܂��B
   * @return �Љ�Q���x�����Z�R���e�i
   */
  protected ACLabelContainer getSocialSupportRadioGroupContainer(){
    if(socialSupportRadioGroupContainer==null){
      socialSupportRadioGroupContainer = new ACLabelContainer();
      socialSupportRadioGroupContainer.setFollowChildEnabled(true);
      socialSupportRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      socialSupportRadioGroupContainer.add(getSocialSupportRadioGroup(), null);
    }
    return socialSupportRadioGroupContainer;
  }

  /**
   * �Љ�Q���x�����Z���f�����擾���܂��B
   * @return �Љ�Q���x�����Z���f��
   */
  protected ACListModelAdapter getSocialSupportRadioGroupModel(){
    if(socialSupportRadioGroupModel==null){
      socialSupportRadioGroupModel = new ACListModelAdapter();
      addSocialSupportRadioGroupModel();
    }
    return socialSupportRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSocialSupportRadioItem1(){
    if(socialSupportRadioItem1==null){

      socialSupportRadioItem1 = new ACRadioButtonItem();

      socialSupportRadioItem1.setText("�Ȃ�");

      socialSupportRadioItem1.setGroup(getSocialSupportRadioGroup());

      socialSupportRadioItem1.setConstraints(VRLayout.FLOW);

      addSocialSupportRadioItem1();
    }
    return socialSupportRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSocialSupportRadioItem2(){
    if(socialSupportRadioItem2==null){

      socialSupportRadioItem2 = new ACRadioButtonItem();

      socialSupportRadioItem2.setText("����");

      socialSupportRadioItem2.setGroup(getSocialSupportRadioGroup());

      socialSupportRadioItem2.setConstraints(VRLayout.FLOW);

      addSocialSupportRadioItem2();
    }
    return socialSupportRadioItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1160115");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,4,2,3});

      addServiceAddProvisionStructuralRadioGroup();
    }
    return serviceAddProvisionStructuralRadioGroup;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�R���e�i���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z�R���e�i
   */
  protected ACLabelContainer getServiceAddProvisionStructuralRadioGroupContainer(){
    if(serviceAddProvisionStructuralRadioGroupContainer==null){
      serviceAddProvisionStructuralRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralRadioGroupContainer.add(getServiceAddProvisionStructuralRadioGroup(), null);
    }
    return serviceAddProvisionStructuralRadioGroupContainer;
  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f�����擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z���f��
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralRadioGroupModel(){
    if(serviceAddProvisionStructuralRadioGroupModel==null){
      serviceAddProvisionStructuralRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralRadioGroupModel();
    }
    return serviceAddProvisionStructuralRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem1(){
    if(serviceAddProvisionStructuralRadioItem1==null){

      serviceAddProvisionStructuralRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem1.setText("�Ȃ�");

      serviceAddProvisionStructuralRadioItem1.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem1();
    }
    return serviceAddProvisionStructuralRadioItem1;

  }

  /**
   * ���ZI�C���擾���܂��B
   * @return ���ZI�C
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("���ZI�C");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * ���ZI�����擾���܂��B
   * @return ���ZI��
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("���ZI��");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("���ZII");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * ���E���������P���Z���擾���܂��B
   * @return ���E���������P���Z
   */
  public ACValueArrayRadioButtonGroup getStaffUpgradeRadioGroup(){
    if(staffUpgradeRadioGroup==null){

      staffUpgradeRadioGroup = new ACValueArrayRadioButtonGroup();

      getStaffUpgradeRadioGroupContainer().setText("���E���������P���Z");

      staffUpgradeRadioGroup.setBindPath("4");

      staffUpgradeRadioGroup.setEnabled(true);

      staffUpgradeRadioGroup.setUseClearButton(false);

      staffUpgradeRadioGroup.setModel(getStaffUpgradeRadioGroupModel());

      staffUpgradeRadioGroup.setValues(new int[]{1,6,5,2,3,4});

      addStaffUpgradeRadioGroup();
    }
    return staffUpgradeRadioGroup;

  }

  /**
   * ���E���������P���Z�R���e�i���擾���܂��B
   * @return ���E���������P���Z�R���e�i
   */
  protected ACLabelContainer getStaffUpgradeRadioGroupContainer(){
    if(staffUpgradeRadioGroupContainer==null){
      staffUpgradeRadioGroupContainer = new ACLabelContainer();
      staffUpgradeRadioGroupContainer.setFollowChildEnabled(true);
      staffUpgradeRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      staffUpgradeRadioGroupContainer.add(getStaffUpgradeRadioGroup(), null);
    }
    return staffUpgradeRadioGroupContainer;
  }

  /**
   * ���E���������P���Z���f�����擾���܂��B
   * @return ���E���������P���Z���f��
   */
  protected ACListModelAdapter getStaffUpgradeRadioGroupModel(){
    if(staffUpgradeRadioGroupModel==null){
      staffUpgradeRadioGroupModel = new ACListModelAdapter();
      addStaffUpgradeRadioGroupModel();
    }
    return staffUpgradeRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem1(){
    if(staffUpgradeRadioItem1==null){

      staffUpgradeRadioItem1 = new ACRadioButtonItem();

      staffUpgradeRadioItem1.setText("�Ȃ�");

      staffUpgradeRadioItem1.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem1();
    }
    return staffUpgradeRadioItem1;

  }

  /**
   * ���ZI���擾���܂��B
   * @return ���ZI
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem2(){
    if(staffUpgradeRadioItem2==null){

      staffUpgradeRadioItem2 = new ACRadioButtonItem();

      staffUpgradeRadioItem2.setText("���ZI");

      staffUpgradeRadioItem2.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem2.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem2();
    }
    return staffUpgradeRadioItem2;

  }

  /**
   * ���ZII���擾���܂��B
   * @return ���ZII
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem3(){
    if(staffUpgradeRadioItem3==null){

      staffUpgradeRadioItem3 = new ACRadioButtonItem();

      staffUpgradeRadioItem3.setText("���ZII");

      staffUpgradeRadioItem3.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem3();
    }
    return staffUpgradeRadioItem3;

  }

  /**
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem4(){
    if(staffUpgradeRadioItem4==null){

      staffUpgradeRadioItem4 = new ACRadioButtonItem();

      staffUpgradeRadioItem4.setText("���ZIII");

      staffUpgradeRadioItem4.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addStaffUpgradeRadioItem4();
    }
    return staffUpgradeRadioItem4;

  }

  /**
   * ���ZIV���擾���܂��B
   * @return ���ZIV
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem5(){
    if(staffUpgradeRadioItem5==null){

      staffUpgradeRadioItem5 = new ACRadioButtonItem();

      staffUpgradeRadioItem5.setText("���ZIV");

      staffUpgradeRadioItem5.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem5.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem5();
    }
    return staffUpgradeRadioItem5;

  }

  /**
   * ���ZV���擾���܂��B
   * @return ���ZV
   */
  public ACRadioButtonItem getStaffUpgradeRadioItem6(){
    if(staffUpgradeRadioItem6==null){

      staffUpgradeRadioItem6 = new ACRadioButtonItem();

      staffUpgradeRadioItem6.setText("���ZV");

      staffUpgradeRadioItem6.setGroup(getStaffUpgradeRadioGroup());

      staffUpgradeRadioItem6.setConstraints(VRLayout.FLOW);

      addStaffUpgradeRadioItem6();
    }
    return staffUpgradeRadioItem6;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004_11611_201804Design() {

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

    mainGroup.add(getTab(), VRLayout.CLIENT);

  }

  /**
   * �^�u�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab(){

    tab.addTab("1", getPanel1());

    tab.addTab("2", getPanel2());

  }

  /**
   * �p�l���P�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanel1(){

    panel1.add(getCalculationDetails(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails(){

    calculationDetails.add(getFacilitiesDivisionAfterH2104RadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getExtendTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getRehabilitationSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails.add(getRehabilitationManagementRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪���W�I�O���[�v�i����21�N4���ȍ~�j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioGroup(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�i����21�N4���ȍ~�j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioGroupModel(){

    getFacilitiesDivisionAfterH2104RadioItem1().setButtonIndex(1);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem1());

    getFacilitiesDivisionAfterH2104RadioItem4().setButtonIndex(2);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem4());

    getFacilitiesDivisionAfterH2104RadioItem7().setButtonIndex(7);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem7());

    getFacilitiesDivisionAfterH2104RadioItem2().setButtonIndex(3);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem2());

    getFacilitiesDivisionAfterH2104RadioItem5().setButtonIndex(4);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem5());

    getFacilitiesDivisionAfterH2104RadioItem8().setButtonIndex(8);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem8());

    getFacilitiesDivisionAfterH2104RadioItem3().setButtonIndex(5);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem3());

    getFacilitiesDivisionAfterH2104RadioItem6().setButtonIndex(6);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem6());

    getFacilitiesDivisionAfterH2104RadioItem9().setButtonIndex(9);

    getFacilitiesDivisionAfterH2104RadioGroupModel().add(getFacilitiesDivisionAfterH2104RadioItem9());

  }

  /**
   * �ʏ�K�͂̎��Ə�(�a�@�E�f�Ï�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem1(){

  }

  /**
   * �ʏ�K�͂̎��Ə�(���V�l�ی��{��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem4(){

  }

  /**
   * �ʏ�K�͂̎��Ə�(����É@)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem7(){

  }

  /**
   * ��K�͎��Ə�(I)(�a�@�E�f�Ï�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem2(){

  }

  /**
   * ��K�͎��Ə�(I)(���V�l�ی��{��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem5(){

  }

  /**
   * ��K�͎��Ə�(I)(����É@)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem8(){

  }

  /**
   * ��K�͎��Ə�(II)(�a�@�E�f�Ï�)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem3(){

  }

  /**
   * ��K�͎��Ə�(II)(���V�l�ی��{��)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem6(){

  }

  /**
   * ��K�͎��Ə�(II)(����É@)�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionAfterH2104RadioItem9(){

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
   * ���n�r���e�[�V�����񋟑̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystem(){

  }

  /**
   * ���n�r���e�[�V�����񋟑̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystemModel(){

    getRehabilitationSystemItem1().setButtonIndex(1);

    getRehabilitationSystemModel().add(getRehabilitationSystemItem1());

    getRehabilitationSystemItem2().setButtonIndex(2);

    getRehabilitationSystemModel().add(getRehabilitationSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationSystemItem2(){

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
   * ���n�r���e�[�V�����}�l�W�����g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioGroup(){

  }

  /**
   * ���n�r���e�[�V�����}�l�W�����g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioGroupModel(){

    getRehabilitationManagementRadioItem1().setButtonIndex(1);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem1());

    getRehabilitationManagementRadioItem2().setButtonIndex(2);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem2());

    getRehabilitationManagementRadioItem3().setButtonIndex(3);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem3());

    getRehabilitationManagementRadioItem4().setButtonIndex(4);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem4());

    getRehabilitationManagementRadioItem5().setButtonIndex(5);

    getRehabilitationManagementRadioGroupModel().add(getRehabilitationManagementRadioItem5());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioItem3(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioItem4(){

  }

  /**
   * ���ZIV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRehabilitationManagementRadioItem5(){

  }

  /**
   * �p�l��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanel2(){

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getIntensiveRehabilitationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getDementiaRihaAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getLifeActsImproveRehabilitationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getNourishmentImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getMouthImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getMediumSeverePersonCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getSocialSupportRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �Z���W���ʃ��n�r���e�[�V�������{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntensiveRehabilitationRadioGroup(){

  }

  /**
   * �Z���W���ʃ��n�r���e�[�V�������{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntensiveRehabilitationRadioGroupModel(){

    getIntensiveRehabilitationRadioItem1().setButtonIndex(1);

    getIntensiveRehabilitationRadioGroupModel().add(getIntensiveRehabilitationRadioItem1());

    getIntensiveRehabilitationRadioItem2().setButtonIndex(2);

    getIntensiveRehabilitationRadioGroupModel().add(getIntensiveRehabilitationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntensiveRehabilitationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addIntensiveRehabilitationRadioItem2(){

  }

  /**
   * �F�m�ǒZ���W�����n�r���e�[�V�������{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRihaAddRadioGroup(){

  }

  /**
   * �F�m�ǒZ���W�����n�r���e�[�V�������{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRihaAddRadioGroupModel(){

    getDementiaRihaAddRadioItem1().setButtonIndex(1);

    getDementiaRihaAddRadioGroupModel().add(getDementiaRihaAddRadioItem1());

    getDementiaRihaAddRadioItem2().setButtonIndex(2);

    getDementiaRihaAddRadioGroupModel().add(getDementiaRihaAddRadioItem2());

    getDementiaRihaAddRadioItem3().setButtonIndex(3);

    getDementiaRihaAddRadioGroupModel().add(getDementiaRihaAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRihaAddRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRihaAddRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaRihaAddRadioItem3(){

  }

  /**
   * �����s�׌��ナ�n�r���e�[�V�������{���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehabilitationRadioGroup(){

  }

  /**
   * �����s�׌��ナ�n�r���e�[�V�������{���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehabilitationRadioGroupModel(){

    getLifeActsImproveRehabilitationRadioItem1().setButtonIndex(1);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem1());

    getLifeActsImproveRehabilitationRadioItem2().setButtonIndex(2);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehabilitationRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addLifeActsImproveRehabilitationRadioItem2(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

  }

  /**
   * �h�{���P�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovement(){

  }

  /**
   * �h�{���P�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovementModel(){

    getNourishmentImprovementItem1().setButtonIndex(1);

    getNourishmentImprovementModel().add(getNourishmentImprovementItem1());

    getNourishmentImprovementItem2().setButtonIndex(2);

    getNourishmentImprovementModel().add(getNourishmentImprovementItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovementItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addNourishmentImprovementItem2(){

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
   * ���d�x�҃P�A�̐����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumSeverePersonCare(){

  }

  /**
   * ���d�x�҃P�A�̐����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumSeverePersonCareModel(){

    getMediumSeverePersonCareItem1().setButtonIndex(1);

    getMediumSeverePersonCareModel().add(getMediumSeverePersonCareItem1());

    getMediumSeverePersonCareItem2().setButtonIndex(2);

    getMediumSeverePersonCareModel().add(getMediumSeverePersonCareItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumSeverePersonCareItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumSeverePersonCareItem2(){

  }

  /**
   * �Љ�Q���x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSocialSupportRadioGroup(){

  }

  /**
   * �Љ�Q���x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSocialSupportRadioGroupModel(){

    getSocialSupportRadioItem1().setButtonIndex(1);

    getSocialSupportRadioGroupModel().add(getSocialSupportRadioItem1());

    getSocialSupportRadioItem2().setButtonIndex(2);

    getSocialSupportRadioGroupModel().add(getSocialSupportRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSocialSupportRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSocialSupportRadioItem2(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioGroupModel(){

    getServiceAddProvisionStructuralRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem1());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * ���ZI�C�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * ���ZI���ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * ���E���������P���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioGroup(){

  }

  /**
   * ���E���������P���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioGroupModel(){

    getStaffUpgradeRadioItem1().setButtonIndex(1);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem1());

    getStaffUpgradeRadioItem2().setButtonIndex(6);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem2());

    getStaffUpgradeRadioItem3().setButtonIndex(5);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem3());

    getStaffUpgradeRadioItem4().setButtonIndex(2);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem4());

    getStaffUpgradeRadioItem5().setButtonIndex(3);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem5());

    getStaffUpgradeRadioItem6().setButtonIndex(4);

    getStaffUpgradeRadioGroupModel().add(getStaffUpgradeRadioItem6());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem1(){

  }

  /**
   * ���ZI�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem2(){

  }

  /**
   * ���ZII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem3(){

  }

  /**
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem4(){

  }

  /**
   * ���ZIV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem5(){

  }

  /**
   * ���ZV�ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffUpgradeRadioItem6(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_11611_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_11611_201804Design getThis() {
    return this;
  }
}
