
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
 * �J����: �������̂�
 * �쐬��: 2018/01/30  ���{�R���s���[�^�[������� �������̂� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ǝғo�^ (004)
 * �v���O���� �n�斧���^�ʏ���� (QO004_17811_201804)
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
 * �n�斧���^�ʏ�����ʍ��ڃf�U�C��(QO004_17811_201804) 
 */
public class QO004_17811_201804Design extends QO004ProviderPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox mainGroup;

  private JTabbedPane tab;

  private ACPanel panel1;

  private ACPanel providerMainPanel;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACValueArrayRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACValueArrayRadioButtonGroup extendTime;

  private ACLabelContainer extendTimeContainer;

  private ACListModelAdapter extendTimeModel;

  private ACRadioButtonItem extendTimeItem1;

  private ACRadioButtonItem extendTimeItem2;

  private ACValueArrayRadioButtonGroup kyoseiServiceSeikatsuRadioGroup;

  private ACLabelContainer kyoseiServiceSeikatsuRadioGroupContainer;

  private ACListModelAdapter kyoseiServiceSeikatsuRadioGroupModel;

  private ACRadioButtonItem kyoseiServiceSeikatsuRadioItem1;

  private ACRadioButtonItem kyoseiServiceSeikatsuRadioItem2;

  private ACValueArrayRadioButtonGroup kyoseiServiceJiritsuRadioGroup;

  private ACLabelContainer kyoseiServiceJiritsuRadioGroupContainer;

  private ACListModelAdapter kyoseiServiceJiritsuRadioGroupModel;

  private ACRadioButtonItem kyoseiServiceJiritsuRadioItem1;

  private ACRadioButtonItem kyoseiServiceJiritsuRadioItem2;

  private ACValueArrayRadioButtonGroup kyoseiServiceJidoRadioGroup;

  private ACLabelContainer kyoseiServiceJidoRadioGroupContainer;

  private ACListModelAdapter kyoseiServiceJidoRadioGroupModel;

  private ACRadioButtonItem kyoseiServiceJidoRadioItem1;

  private ACRadioButtonItem kyoseiServiceJidoRadioItem2;

  private ACValueArrayRadioButtonGroup kyoseiServiceDayRadioGroup;

  private ACLabelContainer kyoseiServiceDayRadioGroupContainer;

  private ACListModelAdapter kyoseiServiceDayRadioGroupModel;

  private ACRadioButtonItem kyoseiServiceDayRadioItem1;

  private ACRadioButtonItem kyoseiServiceDayRadioItem2;

  private ACValueArrayRadioButtonGroup seikatsuSoudanGroup;

  private ACLabelContainer seikatsuSoudanGroupContainer;

  private ACListModelAdapter seikatsuSoudanGroupModel;

  private ACRadioButtonItem seikatsuSoudanGroupItem1;

  private ACRadioButtonItem seikatsuSoudanGroupItem2;

  private ACValueArrayRadioButtonGroup bathingHelpSystem;

  private ACLabelContainer bathingHelpSystemContainer;

  private ACListModelAdapter bathingHelpSystemModel;

  private ACRadioButtonItem bathingHelpSystemItem1;

  private ACRadioButtonItem bathingHelpSystemItem2;

  private ACValueArrayRadioButtonGroup mediumSeverePersonCare;

  private ACLabelContainer mediumSeverePersonCareContainer;

  private ACListModelAdapter mediumSeverePersonCareModel;

  private ACRadioButtonItem mediumSeverePersonCareItem1;

  private ACRadioButtonItem mediumSeverePersonCareItem2;

  private ACValueArrayRadioButtonGroup seikatsuKinouGroup;

  private ACLabelContainer seikatsuKinouGroupContainer;

  private ACListModelAdapter seikatsuKinouGroupModel;

  private ACRadioButtonItem seikatsuKinouGroupItem1;

  private ACRadioButtonItem seikatsuKinouGroupItem2;

  private ACValueArrayRadioButtonGroup individualfunctionTrainingSystem;

  private ACLabelContainer individualfunctionTrainingSystemContainer;

  private ACListModelAdapter individualfunctionTrainingSystemModel;

  private ACRadioButtonItem individualfunctionTrainingSystemItem1;

  private ACRadioButtonItem individualfunctionTrainingSystemItem2;

  private ACValueArrayRadioButtonGroup individualfunctionTrainingSystem2;

  private ACLabelContainer individualfunctionTrainingSystem2Container;

  private ACListModelAdapter individualfunctionTrainingSystem2Model;

  private ACRadioButtonItem individualfunctionTrainingSystem2Item1;

  private ACRadioButtonItem individualfunctionTrainingSystem2Item2;

  private ACValueArrayRadioButtonGroup adlIjiGroup;

  private ACLabelContainer adlIjiGroupContainer;

  private ACListModelAdapter adlIjiGroupModel;

  private ACRadioButtonItem adlIjiGroupItem1;

  private ACRadioButtonItem adlIjiGroupItem2;

  private ACValueArrayRadioButtonGroup adlIjiGroup2;

  private ACLabelContainer adlIjiGroup2Container;

  private ACListModelAdapter adlIjiGroup2Model;

  private ACRadioButtonItem adlIjiGroup2Item1;

  private ACRadioButtonItem adlIjiGroup2Item2;

  private ACPanel panel2;

  private ACPanel calculationDetails2;

  private ACValueArrayRadioButtonGroup dementiaAdd;

  private ACLabelContainer dementiaAddContainer;

  private ACListModelAdapter dementiaAddModel;

  private ACRadioButtonItem dementiaAddItem1;

  private ACRadioButtonItem dementiaAddItem2;

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

  private ACValueArrayRadioButtonGroup individualPickupSystem;

  private ACLabelContainer individualPickupSystemContainer;

  private ACListModelAdapter individualPickupSystemModel;

  private ACRadioButtonItem individualPickupSystemItem1;

  private ACRadioButtonItem individualPickupSystemItem2;

  private ACValueArrayRadioButtonGroup bathingAssistanceSystem;

  private ACLabelContainer bathingAssistanceSystemContainer;

  private ACListModelAdapter bathingAssistanceSystemModel;

  private ACRadioButtonItem bathingAssistanceSystemItem1;

  private ACRadioButtonItem bathingAssistanceSystemItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem5;

  private ACValueArrayRadioButtonGroup staffUpgradeRadioGroup;

  private ACLabelContainer staffUpgradeRadioGroupContainer;

  private ACListModelAdapter staffUpgradeRadioGroupModel;

  private ACRadioButtonItem staffUpgradeRadioItem1;

  private ACRadioButtonItem staffUpgradeRadioItem2;

  private ACRadioButtonItem staffUpgradeRadioItem3;

  private ACRadioButtonItem staffUpgradeRadioItem4;

  private ACRadioButtonItem staffUpgradeRadioItem5;

  private ACRadioButtonItem staffUpgradeRadioItem6;

  private ACPanel providerSubPanel;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("�n�斧���^�ʏ����");

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
   * ���Ə����C���p�l�����擾���܂��B
   * @return ���Ə����C���p�l��
   */
  public ACPanel getProviderMainPanel(){
    if(providerMainPanel==null){

      providerMainPanel = new ACPanel();

      providerMainPanel.setFollowChildEnabled(true);

      providerMainPanel.setHgap(0);

      providerMainPanel.setLabelMargin(0);

      providerMainPanel.setVgap(0);

      providerMainPanel.setHgrid(200);

      addProviderMainPanel();
    }
    return providerMainPanel;

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

      facilitiesDivisionContainer.setHgap(0);

      facilitiesDivisionContainer.setLabelMargin(0);

      facilitiesDivisionContainer.setVgap(0);

      addFacilitiesDivisionContainer();
    }
    return facilitiesDivisionContainer;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      facilitiesDivision.setBindPath("1780101");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2});

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
   * �n�斧���^�ʏ������擾���܂��B
   * @return �n�斧���^�ʏ����
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("�n�斧���^�ʏ����");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * �×{�ʏ������擾���܂��B
   * @return �×{�ʏ����
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("�×{�ʏ����");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v���擾���܂��B
   * @return �E���̌����ɂ�錸�Z�̏󋵃��W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACValueArrayRadioButtonGroup();

      getStaffLackContainer().setText("�E���̌����ɂ�錸�Z�̏�");

      staffLack.setBindPath("1780102");

      staffLack.setUseClearButton(false);

      staffLack.setModel(getStaffLackModel());

      staffLack.setValues(new int[]{1,2,3});

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
   * �Ō�E�����擾���܂��B
   * @return �Ō�E��
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("�Ō�E��");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * ���E�����擾���܂��B
   * @return ���E��
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("���E��");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * ���ԉ����T�[�r�X�̐����擾���܂��B
   * @return ���ԉ����T�[�r�X�̐�
   */
  public ACValueArrayRadioButtonGroup getExtendTime(){
    if(extendTime==null){

      extendTime = new ACValueArrayRadioButtonGroup();

      getExtendTimeContainer().setText("���ԉ����T�[�r�X�̐�");

      extendTime.setBindPath("1780103");

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
   * �����^�T�[�r�X�̒񋟁i������쎖�Ə��j���擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i������쎖�Ə��j
   */
  public ACValueArrayRadioButtonGroup getKyoseiServiceSeikatsuRadioGroup(){
    if(kyoseiServiceSeikatsuRadioGroup==null){

      kyoseiServiceSeikatsuRadioGroup = new ACValueArrayRadioButtonGroup();

      getKyoseiServiceSeikatsuRadioGroupContainer().setText("�����^�T�[�r�X�̒񋟁i������쎖�Ə��j");

      kyoseiServiceSeikatsuRadioGroup.setBindPath("1780114");

      kyoseiServiceSeikatsuRadioGroup.setVisible(true);

      kyoseiServiceSeikatsuRadioGroup.setEnabled(true);

      kyoseiServiceSeikatsuRadioGroup.setNoSelectIndex(0);

      kyoseiServiceSeikatsuRadioGroup.setUseClearButton(false);

      kyoseiServiceSeikatsuRadioGroup.setModel(getKyoseiServiceSeikatsuRadioGroupModel());

      kyoseiServiceSeikatsuRadioGroup.setValues(new int[]{1,2});

      addKyoseiServiceSeikatsuRadioGroup();
    }
    return kyoseiServiceSeikatsuRadioGroup;

  }

  /**
   * �����^�T�[�r�X�̒񋟁i������쎖�Ə��j�R���e�i���擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i������쎖�Ə��j�R���e�i
   */
  protected ACLabelContainer getKyoseiServiceSeikatsuRadioGroupContainer(){
    if(kyoseiServiceSeikatsuRadioGroupContainer==null){
      kyoseiServiceSeikatsuRadioGroupContainer = new ACLabelContainer();
      kyoseiServiceSeikatsuRadioGroupContainer.setFollowChildEnabled(true);
      kyoseiServiceSeikatsuRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kyoseiServiceSeikatsuRadioGroupContainer.add(getKyoseiServiceSeikatsuRadioGroup(), null);
    }
    return kyoseiServiceSeikatsuRadioGroupContainer;
  }

  /**
   * �����^�T�[�r�X�̒񋟁i������쎖�Ə��j���f�����擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i������쎖�Ə��j���f��
   */
  protected ACListModelAdapter getKyoseiServiceSeikatsuRadioGroupModel(){
    if(kyoseiServiceSeikatsuRadioGroupModel==null){
      kyoseiServiceSeikatsuRadioGroupModel = new ACListModelAdapter();
      addKyoseiServiceSeikatsuRadioGroupModel();
    }
    return kyoseiServiceSeikatsuRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKyoseiServiceSeikatsuRadioItem1(){
    if(kyoseiServiceSeikatsuRadioItem1==null){

      kyoseiServiceSeikatsuRadioItem1 = new ACRadioButtonItem();

      kyoseiServiceSeikatsuRadioItem1.setText("�Ȃ�");

      kyoseiServiceSeikatsuRadioItem1.setGroup(getKyoseiServiceSeikatsuRadioGroup());

      kyoseiServiceSeikatsuRadioItem1.setConstraints(VRLayout.FLOW);

      addKyoseiServiceSeikatsuRadioItem1();
    }
    return kyoseiServiceSeikatsuRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKyoseiServiceSeikatsuRadioItem2(){
    if(kyoseiServiceSeikatsuRadioItem2==null){

      kyoseiServiceSeikatsuRadioItem2 = new ACRadioButtonItem();

      kyoseiServiceSeikatsuRadioItem2.setText("����");

      kyoseiServiceSeikatsuRadioItem2.setGroup(getKyoseiServiceSeikatsuRadioGroup());

      kyoseiServiceSeikatsuRadioItem2.setConstraints(VRLayout.FLOW);

      addKyoseiServiceSeikatsuRadioItem2();
    }
    return kyoseiServiceSeikatsuRadioItem2;

  }

  /**
   * �����^�T�[�r�X�̒񋟁i�����P�����Ə��j���擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i�����P�����Ə��j
   */
  public ACValueArrayRadioButtonGroup getKyoseiServiceJiritsuRadioGroup(){
    if(kyoseiServiceJiritsuRadioGroup==null){

      kyoseiServiceJiritsuRadioGroup = new ACValueArrayRadioButtonGroup();

      getKyoseiServiceJiritsuRadioGroupContainer().setText("�����^�T�[�r�X�̒񋟁i�����P�����Ə��j");

      kyoseiServiceJiritsuRadioGroup.setBindPath("1780115");

      kyoseiServiceJiritsuRadioGroup.setVisible(true);

      kyoseiServiceJiritsuRadioGroup.setEnabled(true);

      kyoseiServiceJiritsuRadioGroup.setNoSelectIndex(0);

      kyoseiServiceJiritsuRadioGroup.setUseClearButton(false);

      kyoseiServiceJiritsuRadioGroup.setModel(getKyoseiServiceJiritsuRadioGroupModel());

      kyoseiServiceJiritsuRadioGroup.setValues(new int[]{1,2});

      addKyoseiServiceJiritsuRadioGroup();
    }
    return kyoseiServiceJiritsuRadioGroup;

  }

  /**
   * �����^�T�[�r�X�̒񋟁i�����P�����Ə��j�R���e�i���擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i�����P�����Ə��j�R���e�i
   */
  protected ACLabelContainer getKyoseiServiceJiritsuRadioGroupContainer(){
    if(kyoseiServiceJiritsuRadioGroupContainer==null){
      kyoseiServiceJiritsuRadioGroupContainer = new ACLabelContainer();
      kyoseiServiceJiritsuRadioGroupContainer.setFollowChildEnabled(true);
      kyoseiServiceJiritsuRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kyoseiServiceJiritsuRadioGroupContainer.add(getKyoseiServiceJiritsuRadioGroup(), null);
    }
    return kyoseiServiceJiritsuRadioGroupContainer;
  }

  /**
   * �����^�T�[�r�X�̒񋟁i�����P�����Ə��j���f�����擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i�����P�����Ə��j���f��
   */
  protected ACListModelAdapter getKyoseiServiceJiritsuRadioGroupModel(){
    if(kyoseiServiceJiritsuRadioGroupModel==null){
      kyoseiServiceJiritsuRadioGroupModel = new ACListModelAdapter();
      addKyoseiServiceJiritsuRadioGroupModel();
    }
    return kyoseiServiceJiritsuRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKyoseiServiceJiritsuRadioItem1(){
    if(kyoseiServiceJiritsuRadioItem1==null){

      kyoseiServiceJiritsuRadioItem1 = new ACRadioButtonItem();

      kyoseiServiceJiritsuRadioItem1.setText("�Ȃ�");

      kyoseiServiceJiritsuRadioItem1.setGroup(getKyoseiServiceJiritsuRadioGroup());

      kyoseiServiceJiritsuRadioItem1.setConstraints(VRLayout.FLOW);

      addKyoseiServiceJiritsuRadioItem1();
    }
    return kyoseiServiceJiritsuRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKyoseiServiceJiritsuRadioItem2(){
    if(kyoseiServiceJiritsuRadioItem2==null){

      kyoseiServiceJiritsuRadioItem2 = new ACRadioButtonItem();

      kyoseiServiceJiritsuRadioItem2.setText("����");

      kyoseiServiceJiritsuRadioItem2.setGroup(getKyoseiServiceJiritsuRadioGroup());

      kyoseiServiceJiritsuRadioItem2.setConstraints(VRLayout.FLOW);

      addKyoseiServiceJiritsuRadioItem2();
    }
    return kyoseiServiceJiritsuRadioItem2;

  }

  /**
   * �����^�T�[�r�X�̒񋟁i�������B�x�����Ə��j���擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i�������B�x�����Ə��j
   */
  public ACValueArrayRadioButtonGroup getKyoseiServiceJidoRadioGroup(){
    if(kyoseiServiceJidoRadioGroup==null){

      kyoseiServiceJidoRadioGroup = new ACValueArrayRadioButtonGroup();

      getKyoseiServiceJidoRadioGroupContainer().setText("�����^�T�[�r�X�̒񋟁i�������B�x�����Ə��j");

      kyoseiServiceJidoRadioGroup.setBindPath("1780116");

      kyoseiServiceJidoRadioGroup.setVisible(true);

      kyoseiServiceJidoRadioGroup.setEnabled(true);

      kyoseiServiceJidoRadioGroup.setNoSelectIndex(0);

      kyoseiServiceJidoRadioGroup.setUseClearButton(false);

      kyoseiServiceJidoRadioGroup.setModel(getKyoseiServiceJidoRadioGroupModel());

      kyoseiServiceJidoRadioGroup.setValues(new int[]{1,2});

      addKyoseiServiceJidoRadioGroup();
    }
    return kyoseiServiceJidoRadioGroup;

  }

  /**
   * �����^�T�[�r�X�̒񋟁i�������B�x�����Ə��j�R���e�i���擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i�������B�x�����Ə��j�R���e�i
   */
  protected ACLabelContainer getKyoseiServiceJidoRadioGroupContainer(){
    if(kyoseiServiceJidoRadioGroupContainer==null){
      kyoseiServiceJidoRadioGroupContainer = new ACLabelContainer();
      kyoseiServiceJidoRadioGroupContainer.setFollowChildEnabled(true);
      kyoseiServiceJidoRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kyoseiServiceJidoRadioGroupContainer.add(getKyoseiServiceJidoRadioGroup(), null);
    }
    return kyoseiServiceJidoRadioGroupContainer;
  }

  /**
   * �����^�T�[�r�X�̒񋟁i�������B�x�����Ə��j���f�����擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i�������B�x�����Ə��j���f��
   */
  protected ACListModelAdapter getKyoseiServiceJidoRadioGroupModel(){
    if(kyoseiServiceJidoRadioGroupModel==null){
      kyoseiServiceJidoRadioGroupModel = new ACListModelAdapter();
      addKyoseiServiceJidoRadioGroupModel();
    }
    return kyoseiServiceJidoRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKyoseiServiceJidoRadioItem1(){
    if(kyoseiServiceJidoRadioItem1==null){

      kyoseiServiceJidoRadioItem1 = new ACRadioButtonItem();

      kyoseiServiceJidoRadioItem1.setText("�Ȃ�");

      kyoseiServiceJidoRadioItem1.setGroup(getKyoseiServiceJidoRadioGroup());

      kyoseiServiceJidoRadioItem1.setConstraints(VRLayout.FLOW);

      addKyoseiServiceJidoRadioItem1();
    }
    return kyoseiServiceJidoRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKyoseiServiceJidoRadioItem2(){
    if(kyoseiServiceJidoRadioItem2==null){

      kyoseiServiceJidoRadioItem2 = new ACRadioButtonItem();

      kyoseiServiceJidoRadioItem2.setText("����");

      kyoseiServiceJidoRadioItem2.setGroup(getKyoseiServiceJidoRadioGroup());

      kyoseiServiceJidoRadioItem2.setConstraints(VRLayout.FLOW);

      addKyoseiServiceJidoRadioItem2();
    }
    return kyoseiServiceJidoRadioItem2;

  }

  /**
   * �����^�T�[�r�X�̒񋟁i���ی㓙�f�C�T�[�r�X���Ə��j���擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i���ی㓙�f�C�T�[�r�X���Ə��j
   */
  public ACValueArrayRadioButtonGroup getKyoseiServiceDayRadioGroup(){
    if(kyoseiServiceDayRadioGroup==null){

      kyoseiServiceDayRadioGroup = new ACValueArrayRadioButtonGroup();

      getKyoseiServiceDayRadioGroupContainer().setText("�����^�T�[�r�X�̒񋟁i���ی㓙�f�C�T�[�r�X���Ə��j");

      kyoseiServiceDayRadioGroup.setBindPath("1780117");

      kyoseiServiceDayRadioGroup.setVisible(true);

      kyoseiServiceDayRadioGroup.setEnabled(true);

      kyoseiServiceDayRadioGroup.setNoSelectIndex(0);

      kyoseiServiceDayRadioGroup.setUseClearButton(false);

      kyoseiServiceDayRadioGroup.setModel(getKyoseiServiceDayRadioGroupModel());

      kyoseiServiceDayRadioGroup.setValues(new int[]{1,2});

      addKyoseiServiceDayRadioGroup();
    }
    return kyoseiServiceDayRadioGroup;

  }

  /**
   * �����^�T�[�r�X�̒񋟁i���ی㓙�f�C�T�[�r�X���Ə��j�R���e�i���擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i���ی㓙�f�C�T�[�r�X���Ə��j�R���e�i
   */
  protected ACLabelContainer getKyoseiServiceDayRadioGroupContainer(){
    if(kyoseiServiceDayRadioGroupContainer==null){
      kyoseiServiceDayRadioGroupContainer = new ACLabelContainer();
      kyoseiServiceDayRadioGroupContainer.setFollowChildEnabled(true);
      kyoseiServiceDayRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      kyoseiServiceDayRadioGroupContainer.add(getKyoseiServiceDayRadioGroup(), null);
    }
    return kyoseiServiceDayRadioGroupContainer;
  }

  /**
   * �����^�T�[�r�X�̒񋟁i���ی㓙�f�C�T�[�r�X���Ə��j���f�����擾���܂��B
   * @return �����^�T�[�r�X�̒񋟁i���ی㓙�f�C�T�[�r�X���Ə��j���f��
   */
  protected ACListModelAdapter getKyoseiServiceDayRadioGroupModel(){
    if(kyoseiServiceDayRadioGroupModel==null){
      kyoseiServiceDayRadioGroupModel = new ACListModelAdapter();
      addKyoseiServiceDayRadioGroupModel();
    }
    return kyoseiServiceDayRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getKyoseiServiceDayRadioItem1(){
    if(kyoseiServiceDayRadioItem1==null){

      kyoseiServiceDayRadioItem1 = new ACRadioButtonItem();

      kyoseiServiceDayRadioItem1.setText("�Ȃ�");

      kyoseiServiceDayRadioItem1.setGroup(getKyoseiServiceDayRadioGroup());

      kyoseiServiceDayRadioItem1.setConstraints(VRLayout.FLOW);

      addKyoseiServiceDayRadioItem1();
    }
    return kyoseiServiceDayRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getKyoseiServiceDayRadioItem2(){
    if(kyoseiServiceDayRadioItem2==null){

      kyoseiServiceDayRadioItem2 = new ACRadioButtonItem();

      kyoseiServiceDayRadioItem2.setText("����");

      kyoseiServiceDayRadioItem2.setGroup(getKyoseiServiceDayRadioGroup());

      kyoseiServiceDayRadioItem2.setConstraints(VRLayout.FLOW);

      addKyoseiServiceDayRadioItem2();
    }
    return kyoseiServiceDayRadioItem2;

  }

  /**
   * �������k���z�u�����Z���擾���܂��B
   * @return �������k���z�u�����Z
   */
  public ACValueArrayRadioButtonGroup getSeikatsuSoudanGroup(){
    if(seikatsuSoudanGroup==null){

      seikatsuSoudanGroup = new ACValueArrayRadioButtonGroup();

      getSeikatsuSoudanGroupContainer().setText("�������k���z�u�����Z");

      seikatsuSoudanGroup.setBindPath("1780118");

      seikatsuSoudanGroup.setNoSelectIndex(0);

      seikatsuSoudanGroup.setUseClearButton(false);

      seikatsuSoudanGroup.setModel(getSeikatsuSoudanGroupModel());

      seikatsuSoudanGroup.setValues(new int[]{1,2});

      addSeikatsuSoudanGroup();
    }
    return seikatsuSoudanGroup;

  }

  /**
   * �������k���z�u�����Z�R���e�i���擾���܂��B
   * @return �������k���z�u�����Z�R���e�i
   */
  protected ACLabelContainer getSeikatsuSoudanGroupContainer(){
    if(seikatsuSoudanGroupContainer==null){
      seikatsuSoudanGroupContainer = new ACLabelContainer();
      seikatsuSoudanGroupContainer.setFollowChildEnabled(true);
      seikatsuSoudanGroupContainer.setVAlignment(VRLayout.CENTER);
      seikatsuSoudanGroupContainer.add(getSeikatsuSoudanGroup(), null);
    }
    return seikatsuSoudanGroupContainer;
  }

  /**
   * �������k���z�u�����Z���f�����擾���܂��B
   * @return �������k���z�u�����Z���f��
   */
  protected ACListModelAdapter getSeikatsuSoudanGroupModel(){
    if(seikatsuSoudanGroupModel==null){
      seikatsuSoudanGroupModel = new ACListModelAdapter();
      addSeikatsuSoudanGroupModel();
    }
    return seikatsuSoudanGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSeikatsuSoudanGroupItem1(){
    if(seikatsuSoudanGroupItem1==null){

      seikatsuSoudanGroupItem1 = new ACRadioButtonItem();

      seikatsuSoudanGroupItem1.setText("�Ȃ�");

      seikatsuSoudanGroupItem1.setGroup(getSeikatsuSoudanGroup());

      seikatsuSoudanGroupItem1.setConstraints(VRLayout.FLOW);

      addSeikatsuSoudanGroupItem1();
    }
    return seikatsuSoudanGroupItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSeikatsuSoudanGroupItem2(){
    if(seikatsuSoudanGroupItem2==null){

      seikatsuSoudanGroupItem2 = new ACRadioButtonItem();

      seikatsuSoudanGroupItem2.setText("����");

      seikatsuSoudanGroupItem2.setGroup(getSeikatsuSoudanGroup());

      seikatsuSoudanGroupItem2.setConstraints(VRLayout.FLOW);

      addSeikatsuSoudanGroupItem2();
    }
    return seikatsuSoudanGroupItem2;

  }

  /**
   * ������̐����W�I�O���[�v���擾���܂��B
   * @return ������̐����W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getBathingHelpSystem(){
    if(bathingHelpSystem==null){

      bathingHelpSystem = new ACValueArrayRadioButtonGroup();

      getBathingHelpSystemContainer().setText("������̐�");

      bathingHelpSystem.setBindPath("1780104");

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
   * ���d�x�҃P�A�̐����Z���W�I�O���[�v���擾���܂��B
   * @return ���d�x�҃P�A�̐����Z���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getMediumSeverePersonCare(){
    if(mediumSeverePersonCare==null){

      mediumSeverePersonCare = new ACValueArrayRadioButtonGroup();

      getMediumSeverePersonCareContainer().setText("���d�x�҃P�A�̐����Z");

      mediumSeverePersonCare.setBindPath("1780105");

      mediumSeverePersonCare.setUseClearButton(false);

      mediumSeverePersonCare.setModel(getMediumSeverePersonCareModel());

      mediumSeverePersonCare.setValues(new int[]{1,2});

      addMediumSeverePersonCare();
    }
    return mediumSeverePersonCare;

  }

  /**
   * ���d�x�҃P�A�̐����Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���d�x�҃P�A�̐����Z���W�I�O���[�v�R���e�i
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
   * ���d�x�҃P�A�̐����Z���W�I�O���[�v���f�����擾���܂��B
   * @return ���d�x�҃P�A�̐����Z���W�I�O���[�v���f��
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
   * �����@�\����A�g���Z���擾���܂��B
   * @return �����@�\����A�g���Z
   */
  public ACValueArrayRadioButtonGroup getSeikatsuKinouGroup(){
    if(seikatsuKinouGroup==null){

      seikatsuKinouGroup = new ACValueArrayRadioButtonGroup();

      getSeikatsuKinouGroupContainer().setText("�����@�\����A�g���Z");

      seikatsuKinouGroup.setBindPath("1780119");

      seikatsuKinouGroup.setNoSelectIndex(0);

      seikatsuKinouGroup.setUseClearButton(false);

      seikatsuKinouGroup.setModel(getSeikatsuKinouGroupModel());

      seikatsuKinouGroup.setValues(new int[]{1,2});

      addSeikatsuKinouGroup();
    }
    return seikatsuKinouGroup;

  }

  /**
   * �����@�\����A�g���Z�R���e�i���擾���܂��B
   * @return �����@�\����A�g���Z�R���e�i
   */
  protected ACLabelContainer getSeikatsuKinouGroupContainer(){
    if(seikatsuKinouGroupContainer==null){
      seikatsuKinouGroupContainer = new ACLabelContainer();
      seikatsuKinouGroupContainer.setFollowChildEnabled(true);
      seikatsuKinouGroupContainer.setVAlignment(VRLayout.CENTER);
      seikatsuKinouGroupContainer.add(getSeikatsuKinouGroup(), null);
    }
    return seikatsuKinouGroupContainer;
  }

  /**
   * �����@�\����A�g���Z���f�����擾���܂��B
   * @return �����@�\����A�g���Z���f��
   */
  protected ACListModelAdapter getSeikatsuKinouGroupModel(){
    if(seikatsuKinouGroupModel==null){
      seikatsuKinouGroupModel = new ACListModelAdapter();
      addSeikatsuKinouGroupModel();
    }
    return seikatsuKinouGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getSeikatsuKinouGroupItem1(){
    if(seikatsuKinouGroupItem1==null){

      seikatsuKinouGroupItem1 = new ACRadioButtonItem();

      seikatsuKinouGroupItem1.setText("�Ȃ�");

      seikatsuKinouGroupItem1.setGroup(getSeikatsuKinouGroup());

      seikatsuKinouGroupItem1.setConstraints(VRLayout.FLOW);

      addSeikatsuKinouGroupItem1();
    }
    return seikatsuKinouGroupItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getSeikatsuKinouGroupItem2(){
    if(seikatsuKinouGroupItem2==null){

      seikatsuKinouGroupItem2 = new ACRadioButtonItem();

      seikatsuKinouGroupItem2.setText("����");

      seikatsuKinouGroupItem2.setGroup(getSeikatsuKinouGroup());

      seikatsuKinouGroupItem2.setConstraints(VRLayout.FLOW);

      addSeikatsuKinouGroupItem2();
    }
    return seikatsuKinouGroupItem2;

  }

  /**
   * �ʋ@�\�P���̐�I���W�I�O���[�v���擾���܂��B
   * @return �ʋ@�\�P���̐�I���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getIndividualfunctionTrainingSystem(){
    if(individualfunctionTrainingSystem==null){

      individualfunctionTrainingSystem = new ACValueArrayRadioButtonGroup();

      getIndividualfunctionTrainingSystemContainer().setText("�ʋ@�\�P���̐� I");

      individualfunctionTrainingSystem.setBindPath("1780106");

      individualfunctionTrainingSystem.setNoSelectIndex(0);

      individualfunctionTrainingSystem.setUseClearButton(false);

      individualfunctionTrainingSystem.setModel(getIndividualfunctionTrainingSystemModel());

      individualfunctionTrainingSystem.setValues(new int[]{1,2});

      addIndividualfunctionTrainingSystem();
    }
    return individualfunctionTrainingSystem;

  }

  /**
   * �ʋ@�\�P���̐�I���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �ʋ@�\�P���̐�I���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getIndividualfunctionTrainingSystemContainer(){
    if(individualfunctionTrainingSystemContainer==null){
      individualfunctionTrainingSystemContainer = new ACLabelContainer();
      individualfunctionTrainingSystemContainer.setFollowChildEnabled(true);
      individualfunctionTrainingSystemContainer.setVAlignment(VRLayout.CENTER);
      individualfunctionTrainingSystemContainer.add(getIndividualfunctionTrainingSystem(), null);
    }
    return individualfunctionTrainingSystemContainer;
  }

  /**
   * �ʋ@�\�P���̐�I���W�I�O���[�v���f�����擾���܂��B
   * @return �ʋ@�\�P���̐�I���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getIndividualfunctionTrainingSystemModel(){
    if(individualfunctionTrainingSystemModel==null){
      individualfunctionTrainingSystemModel = new ACListModelAdapter();
      addIndividualfunctionTrainingSystemModel();
    }
    return individualfunctionTrainingSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem1(){
    if(individualfunctionTrainingSystemItem1==null){

      individualfunctionTrainingSystemItem1 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem1.setText("�Ȃ�");

      individualfunctionTrainingSystemItem1.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem1.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem1();
    }
    return individualfunctionTrainingSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystemItem2(){
    if(individualfunctionTrainingSystemItem2==null){

      individualfunctionTrainingSystemItem2 = new ACRadioButtonItem();

      individualfunctionTrainingSystemItem2.setText("����");

      individualfunctionTrainingSystemItem2.setGroup(getIndividualfunctionTrainingSystem());

      individualfunctionTrainingSystemItem2.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystemItem2();
    }
    return individualfunctionTrainingSystemItem2;

  }

  /**
   * �ʋ@�\�P���̐�II���W�I�O���[�v���擾���܂��B
   * @return �ʋ@�\�P���̐�II���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getIndividualfunctionTrainingSystem2(){
    if(individualfunctionTrainingSystem2==null){

      individualfunctionTrainingSystem2 = new ACValueArrayRadioButtonGroup();

      getIndividualfunctionTrainingSystem2Container().setText("�ʋ@�\�P���̐� II");

      individualfunctionTrainingSystem2.setBindPath("1780120");

      individualfunctionTrainingSystem2.setNoSelectIndex(0);

      individualfunctionTrainingSystem2.setUseClearButton(false);

      individualfunctionTrainingSystem2.setModel(getIndividualfunctionTrainingSystem2Model());

      individualfunctionTrainingSystem2.setValues(new int[]{1,2});

      addIndividualfunctionTrainingSystem2();
    }
    return individualfunctionTrainingSystem2;

  }

  /**
   * �ʋ@�\�P���̐�II���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �ʋ@�\�P���̐�II���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getIndividualfunctionTrainingSystem2Container(){
    if(individualfunctionTrainingSystem2Container==null){
      individualfunctionTrainingSystem2Container = new ACLabelContainer();
      individualfunctionTrainingSystem2Container.setFollowChildEnabled(true);
      individualfunctionTrainingSystem2Container.setVAlignment(VRLayout.CENTER);
      individualfunctionTrainingSystem2Container.add(getIndividualfunctionTrainingSystem2(), null);
    }
    return individualfunctionTrainingSystem2Container;
  }

  /**
   * �ʋ@�\�P���̐�II���W�I�O���[�v���f�����擾���܂��B
   * @return �ʋ@�\�P���̐�II���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getIndividualfunctionTrainingSystem2Model(){
    if(individualfunctionTrainingSystem2Model==null){
      individualfunctionTrainingSystem2Model = new ACListModelAdapter();
      addIndividualfunctionTrainingSystem2Model();
    }
    return individualfunctionTrainingSystem2Model;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystem2Item1(){
    if(individualfunctionTrainingSystem2Item1==null){

      individualfunctionTrainingSystem2Item1 = new ACRadioButtonItem();

      individualfunctionTrainingSystem2Item1.setText("�Ȃ�");

      individualfunctionTrainingSystem2Item1.setGroup(getIndividualfunctionTrainingSystem2());

      individualfunctionTrainingSystem2Item1.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystem2Item1();
    }
    return individualfunctionTrainingSystem2Item1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getIndividualfunctionTrainingSystem2Item2(){
    if(individualfunctionTrainingSystem2Item2==null){

      individualfunctionTrainingSystem2Item2 = new ACRadioButtonItem();

      individualfunctionTrainingSystem2Item2.setText("����");

      individualfunctionTrainingSystem2Item2.setGroup(getIndividualfunctionTrainingSystem2());

      individualfunctionTrainingSystem2Item2.setConstraints(VRLayout.FLOW);

      addIndividualfunctionTrainingSystem2Item2();
    }
    return individualfunctionTrainingSystem2Item2;

  }

  /**
   * ADL�ێ������Z�k�\�o�l�̗L�����擾���܂��B
   * @return ADL�ێ������Z�k�\�o�l�̗L��
   */
  public ACValueArrayRadioButtonGroup getAdlIjiGroup(){
    if(adlIjiGroup==null){

      adlIjiGroup = new ACValueArrayRadioButtonGroup();

      getAdlIjiGroupContainer().setText("ADL�ێ������Z�k�\�o�l�̗L��");

      adlIjiGroup.setBindPath("1780121");

      adlIjiGroup.setNoSelectIndex(0);

      adlIjiGroup.setUseClearButton(false);

      adlIjiGroup.setModel(getAdlIjiGroupModel());

      adlIjiGroup.setValues(new int[]{1,2});

      addAdlIjiGroup();
    }
    return adlIjiGroup;

  }

  /**
   * ADL�ێ������Z�k�\�o�l�̗L���R���e�i���擾���܂��B
   * @return ADL�ێ������Z�k�\�o�l�̗L���R���e�i
   */
  protected ACLabelContainer getAdlIjiGroupContainer(){
    if(adlIjiGroupContainer==null){
      adlIjiGroupContainer = new ACLabelContainer();
      adlIjiGroupContainer.setFollowChildEnabled(true);
      adlIjiGroupContainer.setVAlignment(VRLayout.CENTER);
      adlIjiGroupContainer.add(getAdlIjiGroup(), null);
    }
    return adlIjiGroupContainer;
  }

  /**
   * ADL�ێ������Z�k�\�o�l�̗L�����f�����擾���܂��B
   * @return ADL�ێ������Z�k�\�o�l�̗L�����f��
   */
  protected ACListModelAdapter getAdlIjiGroupModel(){
    if(adlIjiGroupModel==null){
      adlIjiGroupModel = new ACListModelAdapter();
      addAdlIjiGroupModel();
    }
    return adlIjiGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getAdlIjiGroupItem1(){
    if(adlIjiGroupItem1==null){

      adlIjiGroupItem1 = new ACRadioButtonItem();

      adlIjiGroupItem1.setText("�Ȃ�");

      adlIjiGroupItem1.setGroup(getAdlIjiGroup());

      adlIjiGroupItem1.setConstraints(VRLayout.FLOW);

      addAdlIjiGroupItem1();
    }
    return adlIjiGroupItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getAdlIjiGroupItem2(){
    if(adlIjiGroupItem2==null){

      adlIjiGroupItem2 = new ACRadioButtonItem();

      adlIjiGroupItem2.setText("����");

      adlIjiGroupItem2.setGroup(getAdlIjiGroup());

      adlIjiGroupItem2.setConstraints(VRLayout.FLOW);

      addAdlIjiGroupItem2();
    }
    return adlIjiGroupItem2;

  }

  /**
   * ADL�ێ������Z���擾���܂��B
   * @return ADL�ێ������Z
   */
  public ACValueArrayRadioButtonGroup getAdlIjiGroup2(){
    if(adlIjiGroup2==null){

      adlIjiGroup2 = new ACValueArrayRadioButtonGroup();

      getAdlIjiGroup2Container().setText("ADL�ێ������Z");

      adlIjiGroup2.setBindPath("1780122");

      adlIjiGroup2.setNoSelectIndex(0);

      adlIjiGroup2.setUseClearButton(false);

      adlIjiGroup2.setModel(getAdlIjiGroup2Model());

      adlIjiGroup2.setValues(new int[]{1,2});

      addAdlIjiGroup2();
    }
    return adlIjiGroup2;

  }

  /**
   * ADL�ێ������Z�R���e�i���擾���܂��B
   * @return ADL�ێ������Z�R���e�i
   */
  protected ACLabelContainer getAdlIjiGroup2Container(){
    if(adlIjiGroup2Container==null){
      adlIjiGroup2Container = new ACLabelContainer();
      adlIjiGroup2Container.setFollowChildEnabled(true);
      adlIjiGroup2Container.setVAlignment(VRLayout.CENTER);
      adlIjiGroup2Container.add(getAdlIjiGroup2(), null);
    }
    return adlIjiGroup2Container;
  }

  /**
   * ADL�ێ������Z���f�����擾���܂��B
   * @return ADL�ێ������Z���f��
   */
  protected ACListModelAdapter getAdlIjiGroup2Model(){
    if(adlIjiGroup2Model==null){
      adlIjiGroup2Model = new ACListModelAdapter();
      addAdlIjiGroup2Model();
    }
    return adlIjiGroup2Model;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getAdlIjiGroup2Item1(){
    if(adlIjiGroup2Item1==null){

      adlIjiGroup2Item1 = new ACRadioButtonItem();

      adlIjiGroup2Item1.setText("�Ȃ�");

      adlIjiGroup2Item1.setGroup(getAdlIjiGroup2());

      adlIjiGroup2Item1.setConstraints(VRLayout.FLOW);

      addAdlIjiGroup2Item1();
    }
    return adlIjiGroup2Item1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getAdlIjiGroup2Item2(){
    if(adlIjiGroup2Item2==null){

      adlIjiGroup2Item2 = new ACRadioButtonItem();

      adlIjiGroup2Item2.setText("����");

      adlIjiGroup2Item2.setGroup(getAdlIjiGroup2());

      adlIjiGroup2Item2.setConstraints(VRLayout.FLOW);

      addAdlIjiGroup2Item2();
    }
    return adlIjiGroup2Item2;

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
   * �F�m�ǉ��Z���W�I�O���[�v���擾���܂��B
   * @return �F�m�ǉ��Z���W�I�O���[�v
   */
  public ACValueArrayRadioButtonGroup getDementiaAdd(){
    if(dementiaAdd==null){

      dementiaAdd = new ACValueArrayRadioButtonGroup();

      getDementiaAddContainer().setText("�F�m�ǉ��Z");

      dementiaAdd.setBindPath("1780107");

      dementiaAdd.setUseClearButton(false);

      dementiaAdd.setModel(getDementiaAddModel());

      dementiaAdd.setValues(new int[]{1,2});

      addDementiaAdd();
    }
    return dementiaAdd;

  }

  /**
   * �F�m�ǉ��Z���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �F�m�ǉ��Z���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getDementiaAddContainer(){
    if(dementiaAddContainer==null){
      dementiaAddContainer = new ACLabelContainer();
      dementiaAddContainer.setFollowChildEnabled(true);
      dementiaAddContainer.setVAlignment(VRLayout.CENTER);
      dementiaAddContainer.add(getDementiaAdd(), null);
    }
    return dementiaAddContainer;
  }

  /**
   * �F�m�ǉ��Z���W�I�O���[�v���f�����擾���܂��B
   * @return �F�m�ǉ��Z���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getDementiaAddModel(){
    if(dementiaAddModel==null){
      dementiaAddModel = new ACListModelAdapter();
      addDementiaAddModel();
    }
    return dementiaAddModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getDementiaAddItem1(){
    if(dementiaAddItem1==null){

      dementiaAddItem1 = new ACRadioButtonItem();

      dementiaAddItem1.setText("�Ȃ�");

      dementiaAddItem1.setGroup(getDementiaAdd());

      dementiaAddItem1.setConstraints(VRLayout.FLOW);

      addDementiaAddItem1();
    }
    return dementiaAddItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getDementiaAddItem2(){
    if(dementiaAddItem2==null){

      dementiaAddItem2 = new ACRadioButtonItem();

      dementiaAddItem2.setText("����");

      dementiaAddItem2.setGroup(getDementiaAdd());

      dementiaAddItem2.setConstraints(VRLayout.FLOW);

      addDementiaAddItem2();
    }
    return dementiaAddItem2;

  }

  /**
   * ��N���F�m�Ǘ��p�Ҏ�����Z���擾���܂��B
   * @return ��N���F�m�Ǘ��p�Ҏ�����Z
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("��N���F�m�Ǘ��p�Ҏ�����Z");

      youngDementiaPatinetAddRadioGroup.setBindPath("1780108");

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

      nourishmentImprovement.setBindPath("1780109");

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

      mouthImprovementAdd.setBindPath("1780110");

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
   * �ʑ��}�̐��������Z���擾���܂��B
   * @return �ʑ��}�̐��������Z
   */
  public ACValueArrayRadioButtonGroup getIndividualPickupSystem(){
    if(individualPickupSystem==null){

      individualPickupSystem = new ACValueArrayRadioButtonGroup();

      getIndividualPickupSystemContainer().setText("�ʑ��}�̐��������Z");

      individualPickupSystem.setBindPath("1780111");

      individualPickupSystem.setUseClearButton(false);

      individualPickupSystem.setModel(getIndividualPickupSystemModel());

      individualPickupSystem.setValues(new int[]{1,2});

      addIndividualPickupSystem();
    }
    return individualPickupSystem;

  }

  /**
   * �ʑ��}�̐��������Z�R���e�i���擾���܂��B
   * @return �ʑ��}�̐��������Z�R���e�i
   */
  protected ACLabelContainer getIndividualPickupSystemContainer(){
    if(individualPickupSystemContainer==null){
      individualPickupSystemContainer = new ACLabelContainer();
      individualPickupSystemContainer.setFollowChildEnabled(true);
      individualPickupSystemContainer.setVAlignment(VRLayout.CENTER);
      individualPickupSystemContainer.add(getIndividualPickupSystem(), null);
    }
    return individualPickupSystemContainer;
  }

  /**
   * �ʑ��}�̐��������Z���f�����擾���܂��B
   * @return �ʑ��}�̐��������Z���f��
   */
  protected ACListModelAdapter getIndividualPickupSystemModel(){
    if(individualPickupSystemModel==null){
      individualPickupSystemModel = new ACListModelAdapter();
      addIndividualPickupSystemModel();
    }
    return individualPickupSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getIndividualPickupSystemItem1(){
    if(individualPickupSystemItem1==null){

      individualPickupSystemItem1 = new ACRadioButtonItem();

      individualPickupSystemItem1.setText("�Ȃ�");

      individualPickupSystemItem1.setGroup(getIndividualPickupSystem());

      addIndividualPickupSystemItem1();
    }
    return individualPickupSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getIndividualPickupSystemItem2(){
    if(individualPickupSystemItem2==null){

      individualPickupSystemItem2 = new ACRadioButtonItem();

      individualPickupSystemItem2.setText("����");

      individualPickupSystemItem2.setGroup(getIndividualPickupSystem());

      addIndividualPickupSystemItem2();
    }
    return individualPickupSystemItem2;

  }

  /**
   * ������̐��������Z���擾���܂��B
   * @return ������̐��������Z
   */
  public ACValueArrayRadioButtonGroup getBathingAssistanceSystem(){
    if(bathingAssistanceSystem==null){

      bathingAssistanceSystem = new ACValueArrayRadioButtonGroup();

      getBathingAssistanceSystemContainer().setText("������̐��������Z");

      bathingAssistanceSystem.setBindPath("1780112");

      bathingAssistanceSystem.setUseClearButton(false);

      bathingAssistanceSystem.setModel(getBathingAssistanceSystemModel());

      bathingAssistanceSystem.setValues(new int[]{1,2});

      addBathingAssistanceSystem();
    }
    return bathingAssistanceSystem;

  }

  /**
   * ������̐��������Z�R���e�i���擾���܂��B
   * @return ������̐��������Z�R���e�i
   */
  protected ACLabelContainer getBathingAssistanceSystemContainer(){
    if(bathingAssistanceSystemContainer==null){
      bathingAssistanceSystemContainer = new ACLabelContainer();
      bathingAssistanceSystemContainer.setFollowChildEnabled(true);
      bathingAssistanceSystemContainer.setVAlignment(VRLayout.CENTER);
      bathingAssistanceSystemContainer.add(getBathingAssistanceSystem(), null);
    }
    return bathingAssistanceSystemContainer;
  }

  /**
   * ������̐��������Z���f�����擾���܂��B
   * @return ������̐��������Z���f��
   */
  protected ACListModelAdapter getBathingAssistanceSystemModel(){
    if(bathingAssistanceSystemModel==null){
      bathingAssistanceSystemModel = new ACListModelAdapter();
      addBathingAssistanceSystemModel();
    }
    return bathingAssistanceSystemModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getBathingAssistanceSystemItem1(){
    if(bathingAssistanceSystemItem1==null){

      bathingAssistanceSystemItem1 = new ACRadioButtonItem();

      bathingAssistanceSystemItem1.setText("�Ȃ�");

      bathingAssistanceSystemItem1.setGroup(getBathingAssistanceSystem());

      bathingAssistanceSystemItem1.setConstraints(VRLayout.FLOW);

      addBathingAssistanceSystemItem1();
    }
    return bathingAssistanceSystemItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getBathingAssistanceSystemItem2(){
    if(bathingAssistanceSystemItem2==null){

      bathingAssistanceSystemItem2 = new ACRadioButtonItem();

      bathingAssistanceSystemItem2.setText("����");

      bathingAssistanceSystemItem2.setGroup(getBathingAssistanceSystem());

      bathingAssistanceSystemItem2.setConstraints(VRLayout.FLOW);

      addBathingAssistanceSystemItem2();
    }
    return bathingAssistanceSystemItem2;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1780113");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4,5});

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

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

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
   * ���ZIII���擾���܂��B
   * @return ���ZIII
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem5(){
    if(serviceAddProvisionStructuralRadioItem5==null){

      serviceAddProvisionStructuralRadioItem5 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem5.setText("���ZIII");

      serviceAddProvisionStructuralRadioItem5.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem5.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem5();
    }
    return serviceAddProvisionStructuralRadioItem5;

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
   * ���Ə��T�u�p�l�����擾���܂��B
   * @return ���Ə��T�u�p�l��
   */
  public ACPanel getProviderSubPanel(){
    if(providerSubPanel==null){

      providerSubPanel = new ACPanel();

      providerSubPanel.setFollowChildEnabled(true);

      providerSubPanel.setHgap(0);

      providerSubPanel.setLabelMargin(0);

      providerSubPanel.setVgap(0);

      addProviderSubPanel();
    }
    return providerSubPanel;

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
   * �Е����ƑΏێ��Ǝ҂��擾���܂��B
   * @return �Е����ƑΏێ��Ǝ�
   */
  public ACIntegerCheckBox getShahukuReduce(){
    if(ShahukuReduce==null){

      ShahukuReduce = new ACIntegerCheckBox();

      ShahukuReduce.setText("�Љ���@�l���̌y�����x");

      ShahukuReduce.setBindPath("1");

      ShahukuReduce.setSelectValue(2);

      ShahukuReduce.setUnSelectValue(1);

      addShahukuReduce();
    }
    return ShahukuReduce;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004_17811_201804Design() {

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

    panel1.add(getProviderMainPanel(), VRLayout.NORTH);

  }

  /**
   * ���Ə����C���p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderMainPanel(){

    providerMainPanel.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getExtendTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getKyoseiServiceSeikatsuRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getKyoseiServiceJiritsuRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getKyoseiServiceJidoRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getKyoseiServiceDayRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getSeikatsuSoudanGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getMediumSeverePersonCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getSeikatsuKinouGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getIndividualfunctionTrainingSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getIndividualfunctionTrainingSystem2Container(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getAdlIjiGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    providerMainPanel.add(getAdlIjiGroup2Container(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �{�݋敪�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionContainer(){

    facilitiesDivisionContainer.add(getFacilitiesDivision(), VRLayout.FLOW_RETURN);

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

  }

  /**
   * �n�斧���^�ʏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * �×{�ʏ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addFacilitiesDivisionItem2(){

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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem1(){

  }

  /**
   * �Ō�E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem2(){

  }

  /**
   * ���E���ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffLackItem3(){

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
   * �����^�T�[�r�X�̒񋟁i������쎖�Ə��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceSeikatsuRadioGroup(){

  }

  /**
   * �����^�T�[�r�X�̒񋟁i������쎖�Ə��j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceSeikatsuRadioGroupModel(){

    getKyoseiServiceSeikatsuRadioItem1().setButtonIndex(1);

    getKyoseiServiceSeikatsuRadioGroupModel().add(getKyoseiServiceSeikatsuRadioItem1());

    getKyoseiServiceSeikatsuRadioItem2().setButtonIndex(2);

    getKyoseiServiceSeikatsuRadioGroupModel().add(getKyoseiServiceSeikatsuRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceSeikatsuRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceSeikatsuRadioItem2(){

  }

  /**
   * �����^�T�[�r�X�̒񋟁i�����P�����Ə��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceJiritsuRadioGroup(){

  }

  /**
   * �����^�T�[�r�X�̒񋟁i�����P�����Ə��j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceJiritsuRadioGroupModel(){

    getKyoseiServiceJiritsuRadioItem1().setButtonIndex(1);

    getKyoseiServiceJiritsuRadioGroupModel().add(getKyoseiServiceJiritsuRadioItem1());

    getKyoseiServiceJiritsuRadioItem2().setButtonIndex(2);

    getKyoseiServiceJiritsuRadioGroupModel().add(getKyoseiServiceJiritsuRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceJiritsuRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceJiritsuRadioItem2(){

  }

  /**
   * �����^�T�[�r�X�̒񋟁i�������B�x�����Ə��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceJidoRadioGroup(){

  }

  /**
   * �����^�T�[�r�X�̒񋟁i�������B�x�����Ə��j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceJidoRadioGroupModel(){

    getKyoseiServiceJidoRadioItem1().setButtonIndex(1);

    getKyoseiServiceJidoRadioGroupModel().add(getKyoseiServiceJidoRadioItem1());

    getKyoseiServiceJidoRadioItem2().setButtonIndex(2);

    getKyoseiServiceJidoRadioGroupModel().add(getKyoseiServiceJidoRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceJidoRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceJidoRadioItem2(){

  }

  /**
   * �����^�T�[�r�X�̒񋟁i���ی㓙�f�C�T�[�r�X���Ə��j�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceDayRadioGroup(){

  }

  /**
   * �����^�T�[�r�X�̒񋟁i���ی㓙�f�C�T�[�r�X���Ə��j���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceDayRadioGroupModel(){

    getKyoseiServiceDayRadioItem1().setButtonIndex(1);

    getKyoseiServiceDayRadioGroupModel().add(getKyoseiServiceDayRadioItem1());

    getKyoseiServiceDayRadioItem2().setButtonIndex(2);

    getKyoseiServiceDayRadioGroupModel().add(getKyoseiServiceDayRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceDayRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addKyoseiServiceDayRadioItem2(){

  }

  /**
   * �������k���z�u�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuSoudanGroup(){

  }

  /**
   * �������k���z�u�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuSoudanGroupModel(){

    getSeikatsuSoudanGroupItem1().setButtonIndex(1);

    getSeikatsuSoudanGroupModel().add(getSeikatsuSoudanGroupItem1());

    getSeikatsuSoudanGroupItem2().setButtonIndex(2);

    getSeikatsuSoudanGroupModel().add(getSeikatsuSoudanGroupItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuSoudanGroupItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuSoudanGroupItem2(){

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
   * ���d�x�҃P�A�̐����Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addMediumSeverePersonCare(){

  }

  /**
   * ���d�x�҃P�A�̐����Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
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
   * �����@�\����A�g���Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuKinouGroup(){

  }

  /**
   * �����@�\����A�g���Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuKinouGroupModel(){

    getSeikatsuKinouGroupItem1().setButtonIndex(1);

    getSeikatsuKinouGroupModel().add(getSeikatsuKinouGroupItem1());

    getSeikatsuKinouGroupItem2().setButtonIndex(2);

    getSeikatsuKinouGroupModel().add(getSeikatsuKinouGroupItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuKinouGroupItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addSeikatsuKinouGroupItem2(){

  }

  /**
   * �ʋ@�\�P���̐�I���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystem(){

  }

  /**
   * �ʋ@�\�P���̐�I���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystemModel(){

    getIndividualfunctionTrainingSystemItem1().setButtonIndex(1);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem1());

    getIndividualfunctionTrainingSystemItem2().setButtonIndex(2);

    getIndividualfunctionTrainingSystemModel().add(getIndividualfunctionTrainingSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystemItem2(){

  }

  /**
   * �ʋ@�\�P���̐�II���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystem2(){

  }

  /**
   * �ʋ@�\�P���̐�II���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystem2Model(){

    getIndividualfunctionTrainingSystem2Item1().setButtonIndex(1);

    getIndividualfunctionTrainingSystem2Model().add(getIndividualfunctionTrainingSystem2Item1());

    getIndividualfunctionTrainingSystem2Item2().setButtonIndex(2);

    getIndividualfunctionTrainingSystem2Model().add(getIndividualfunctionTrainingSystem2Item2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystem2Item1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualfunctionTrainingSystem2Item2(){

  }

  /**
   * ADL�ێ������Z�k�\�o�l�̗L���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlIjiGroup(){

  }

  /**
   * ADL�ێ������Z�k�\�o�l�̗L�����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlIjiGroupModel(){

    getAdlIjiGroupItem1().setButtonIndex(1);

    getAdlIjiGroupModel().add(getAdlIjiGroupItem1());

    getAdlIjiGroupItem2().setButtonIndex(2);

    getAdlIjiGroupModel().add(getAdlIjiGroupItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlIjiGroupItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlIjiGroupItem2(){

  }

  /**
   * ADL�ێ������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlIjiGroup2(){

  }

  /**
   * ADL�ێ������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlIjiGroup2Model(){

    getAdlIjiGroup2Item1().setButtonIndex(1);

    getAdlIjiGroup2Model().add(getAdlIjiGroup2Item1());

    getAdlIjiGroup2Item2().setButtonIndex(2);

    getAdlIjiGroup2Model().add(getAdlIjiGroup2Item2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlIjiGroup2Item1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addAdlIjiGroup2Item2(){

  }

  /**
   * �p�l��2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addPanel2(){

    panel2.add(getCalculationDetails2(), VRLayout.NORTH);

    panel2.add(getProviderSubPanel(), VRLayout.NORTH);

  }

  /**
   * �Z�荀�ڗ̈�2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDetails2(){

    calculationDetails2.add(getDementiaAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getNourishmentImprovementContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getMouthImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getIndividualPickupSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getBathingAssistanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    calculationDetails2.add(getStaffUpgradeRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �F�m�ǉ��Z���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAdd(){

  }

  /**
   * �F�m�ǉ��Z���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddModel(){

    getDementiaAddItem1().setButtonIndex(1);

    getDementiaAddModel().add(getDementiaAddItem1());

    getDementiaAddItem2().setButtonIndex(2);

    getDementiaAddModel().add(getDementiaAddItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addDementiaAddItem2(){

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
   * �ʑ��}�̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualPickupSystem(){

  }

  /**
   * �ʑ��}�̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualPickupSystemModel(){

    getIndividualPickupSystemItem1().setButtonIndex(1);

    getIndividualPickupSystemModel().add(getIndividualPickupSystemItem1());

    getIndividualPickupSystemItem2().setButtonIndex(2);

    getIndividualPickupSystemModel().add(getIndividualPickupSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualPickupSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addIndividualPickupSystemItem2(){

  }

  /**
   * ������̐��������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingAssistanceSystem(){

  }

  /**
   * ������̐��������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingAssistanceSystemModel(){

    getBathingAssistanceSystemItem1().setButtonIndex(1);

    getBathingAssistanceSystemModel().add(getBathingAssistanceSystemItem1());

    getBathingAssistanceSystemItem2().setButtonIndex(2);

    getBathingAssistanceSystemModel().add(getBathingAssistanceSystemItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingAssistanceSystemItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addBathingAssistanceSystemItem2(){

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

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem5().setButtonIndex(5);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem5());

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
   * ���ZIII�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem5(){

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
   * ���Ə��T�u�p�l���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderSubPanel(){

    providerSubPanel.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    providerSubPanel.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

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
   * �Е����ƑΏێ��Ǝ҂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShahukuReduce(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004_17811_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004_17811_201804Design getThis() {
    return this;
  }
}
