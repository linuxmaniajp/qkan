
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
 * �쐬��: 2009/03/20  ���{�R���s���[�^�[������� �c���@���� �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� �T�[�r�X�\��쐬/�ύX (S)
 * �v���Z�X �T�[�r�X�\��T�� (001)
 * �v���O���� �T�[�r�X�p�^�[�����\�h���K�͑��@�\�^������ (QS001147_H2104)
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
 * �T�[�r�X�p�^�[�����\�h���K�͑��@�\�^�������ʍ��ڃf�U�C��(QS001147_H2104) 
 */
public class QS001147_H2104Design extends QS001ServicePanel {
  //GUI�R���|�[�l���g

  private JTabbedPane regionSmallscaleMultiPatterns;

  private ACPanel tab1;

  private ACClearableRadioButtonGroup initialAddRadio;

  private ACLabelContainer initialAddRadioContainer;

  private ACListModelAdapter initialAddRadioModel;

  private ACRadioButtonItem initialAddRadioItem1;

  private ACRadioButtonItem initialAddRadioItem2;

  private ACClearableRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACValueArrayRadioButtonGroup underServiceSubtractionRadioGroup;

  private ACLabelContainer underServiceSubtractionRadioGroupContainer;

  private ACListModelAdapter underServiceSubtractionRadioGroupModel;

  private ACRadioButtonItem underServiceSubtractionRadioItem1;

  private ACRadioButtonItem underServiceSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup providerStartAddRadioGroup;

  private ACLabelContainer providerStartAddRadioGroupContainer;

  private ACListModelAdapter providerStartAddRadioGroupModel;

  private ACRadioButtonItem providerStartAddRadioItem1;

  private ACRadioButtonItem providerStartAddRadioItem2;

  private ACRadioButtonItem providerStartAddRadioItem3;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACClearableRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionItem1;

  private ACRadioButtonItem calculationDivisionItem2;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACGroupBox kaigoSupportSpecialMemberContainer;

  private ACTextField kaigoSupportSpecialMemberNumber;

  private ACLabelContainer kaigoSupportSpecialMemberNumberContainer;

  private ACComboBox kaigoSupportSpecialMemberName;

  private ACLabelContainer kaigoSupportSpecialMemberNameContainer;

  private ACComboBoxModelAdapter kaigoSupportSpecialMemberNameModel;

  private ACPanel tab2;

  private ACGroupBox tekiyouGroup;

  private ACTextField tekiyouText;

  private ACLabelContainer tekiyouTextContainer;

  private ACLabel tekiyouCommentTitle;

  private ACGroupBox infoGroup;

  private ACLabel infoLabel;

  //getter

  /**
   * �n�斧�����K�͑��@�\�^���p�^�[���̈���擾���܂��B
   * @return �n�斧�����K�͑��@�\�^���p�^�[���̈�
   */
  public JTabbedPane getRegionSmallscaleMultiPatterns(){
    if(regionSmallscaleMultiPatterns==null){

      regionSmallscaleMultiPatterns = new JTabbedPane();

      addRegionSmallscaleMultiPatterns();
    }
    return regionSmallscaleMultiPatterns;

  }

  /**
   * �^�u1���擾���܂��B
   * @return �^�u1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setHgap(0);

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * �������Z���擾���܂��B
   * @return �������Z
   */
  public ACClearableRadioButtonGroup getInitialAddRadio(){
    if(initialAddRadio==null){

      initialAddRadio = new ACClearableRadioButtonGroup();

      getInitialAddRadioContainer().setText("�������Z");

      initialAddRadio.setBindPath("1750101");

      initialAddRadio.setUseClearButton(false);

      initialAddRadio.setModel(getInitialAddRadioModel());

      addInitialAddRadio();
    }
    return initialAddRadio;

  }

  /**
   * �������Z�R���e�i���擾���܂��B
   * @return �������Z�R���e�i
   */
  protected ACLabelContainer getInitialAddRadioContainer(){
    if(initialAddRadioContainer==null){
      initialAddRadioContainer = new ACLabelContainer();
      initialAddRadioContainer.setFollowChildEnabled(true);
      initialAddRadioContainer.setVAlignment(VRLayout.CENTER);
      initialAddRadioContainer.add(getInitialAddRadio(), null);
    }
    return initialAddRadioContainer;
  }

  /**
   * �������Z���f�����擾���܂��B
   * @return �������Z���f��
   */
  protected ACListModelAdapter getInitialAddRadioModel(){
    if(initialAddRadioModel==null){
      initialAddRadioModel = new ACListModelAdapter();
      addInitialAddRadioModel();
    }
    return initialAddRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getInitialAddRadioItem1(){
    if(initialAddRadioItem1==null){

      initialAddRadioItem1 = new ACRadioButtonItem();

      initialAddRadioItem1.setText("�Ȃ�");

      initialAddRadioItem1.setGroup(getInitialAddRadio());

      initialAddRadioItem1.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem1();
    }
    return initialAddRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getInitialAddRadioItem2(){
    if(initialAddRadioItem2==null){

      initialAddRadioItem2 = new ACRadioButtonItem();

      initialAddRadioItem2.setText("����");

      initialAddRadioItem2.setGroup(getInitialAddRadio());

      initialAddRadioItem2.setConstraints(VRLayout.FLOW);

      addInitialAddRadioItem2();
    }
    return initialAddRadioItem2;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACClearableRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("�l�����Z");

      staffSubtractionRadio.setBindPath("1750102");

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
   * ���E�Ō�E�����������擾���܂��B
   * @return ���E�Ō�E��������
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("���E�Ō�E��������");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z
   */
  public ACValueArrayRadioButtonGroup getUnderServiceSubtractionRadioGroup(){
    if(underServiceSubtractionRadioGroup==null){

      underServiceSubtractionRadioGroup = new ACValueArrayRadioButtonGroup();

      getUnderServiceSubtractionRadioGroupContainer().setText("�ߏ��T�[�r�X�ɑ΂��錸�Z");

      underServiceSubtractionRadioGroup.setBindPath("1750106");

      underServiceSubtractionRadioGroup.setNoSelectIndex(0);

      underServiceSubtractionRadioGroup.setUseClearButton(false);

      underServiceSubtractionRadioGroup.setModel(getUnderServiceSubtractionRadioGroupModel());

      underServiceSubtractionRadioGroup.setValues(new int[]{1,2});

      addUnderServiceSubtractionRadioGroup();
    }
    return underServiceSubtractionRadioGroup;

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z�R���e�i���擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z�R���e�i
   */
  protected ACLabelContainer getUnderServiceSubtractionRadioGroupContainer(){
    if(underServiceSubtractionRadioGroupContainer==null){
      underServiceSubtractionRadioGroupContainer = new ACLabelContainer();
      underServiceSubtractionRadioGroupContainer.setFollowChildEnabled(true);
      underServiceSubtractionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      underServiceSubtractionRadioGroupContainer.add(getUnderServiceSubtractionRadioGroup(), null);
    }
    return underServiceSubtractionRadioGroupContainer;
  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���f�����擾���܂��B
   * @return �ߏ��T�[�r�X�ɑ΂��錸�Z���f��
   */
  protected ACListModelAdapter getUnderServiceSubtractionRadioGroupModel(){
    if(underServiceSubtractionRadioGroupModel==null){
      underServiceSubtractionRadioGroupModel = new ACListModelAdapter();
      addUnderServiceSubtractionRadioGroupModel();
    }
    return underServiceSubtractionRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getUnderServiceSubtractionRadioItem1(){
    if(underServiceSubtractionRadioItem1==null){

      underServiceSubtractionRadioItem1 = new ACRadioButtonItem();

      underServiceSubtractionRadioItem1.setText("�Ȃ�");

      underServiceSubtractionRadioItem1.setGroup(getUnderServiceSubtractionRadioGroup());

      underServiceSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addUnderServiceSubtractionRadioItem1();
    }
    return underServiceSubtractionRadioItem1;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getUnderServiceSubtractionRadioItem2(){
    if(underServiceSubtractionRadioItem2==null){

      underServiceSubtractionRadioItem2 = new ACRadioButtonItem();

      underServiceSubtractionRadioItem2.setText("����");

      underServiceSubtractionRadioItem2.setGroup(getUnderServiceSubtractionRadioGroup());

      underServiceSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addUnderServiceSubtractionRadioItem2();
    }
    return underServiceSubtractionRadioItem2;

  }

  /**
   * ���ƊJ�n���x�����Z���擾���܂��B
   * @return ���ƊJ�n���x�����Z
   */
  public ACValueArrayRadioButtonGroup getProviderStartAddRadioGroup(){
    if(providerStartAddRadioGroup==null){

      providerStartAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderStartAddRadioGroupContainer().setText("���ƊJ�n���x�����Z");

      providerStartAddRadioGroup.setBindPath("1750107");

      providerStartAddRadioGroup.setNoSelectIndex(0);

      providerStartAddRadioGroup.setUseClearButton(false);

      providerStartAddRadioGroup.setModel(getProviderStartAddRadioGroupModel());

      providerStartAddRadioGroup.setValues(new int[]{1,2,3});

      addProviderStartAddRadioGroup();
    }
    return providerStartAddRadioGroup;

  }

  /**
   * ���ƊJ�n���x�����Z�R���e�i���擾���܂��B
   * @return ���ƊJ�n���x�����Z�R���e�i
   */
  protected ACLabelContainer getProviderStartAddRadioGroupContainer(){
    if(providerStartAddRadioGroupContainer==null){
      providerStartAddRadioGroupContainer = new ACLabelContainer();
      providerStartAddRadioGroupContainer.setFollowChildEnabled(true);
      providerStartAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerStartAddRadioGroupContainer.add(getProviderStartAddRadioGroup(), null);
    }
    return providerStartAddRadioGroupContainer;
  }

  /**
   * ���ƊJ�n���x�����Z���f�����擾���܂��B
   * @return ���ƊJ�n���x�����Z���f��
   */
  protected ACListModelAdapter getProviderStartAddRadioGroupModel(){
    if(providerStartAddRadioGroupModel==null){
      providerStartAddRadioGroupModel = new ACListModelAdapter();
      addProviderStartAddRadioGroupModel();
    }
    return providerStartAddRadioGroupModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getProviderStartAddRadioItem1(){
    if(providerStartAddRadioItem1==null){

      providerStartAddRadioItem1 = new ACRadioButtonItem();

      providerStartAddRadioItem1.setText("�Ȃ�");

      providerStartAddRadioItem1.setGroup(getProviderStartAddRadioGroup());

      providerStartAddRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderStartAddRadioItem1();
    }
    return providerStartAddRadioItem1;

  }

  /**
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getProviderStartAddRadioItem2(){
    if(providerStartAddRadioItem2==null){

      providerStartAddRadioItem2 = new ACRadioButtonItem();

      providerStartAddRadioItem2.setText("I�^");

      providerStartAddRadioItem2.setGroup(getProviderStartAddRadioGroup());

      providerStartAddRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addProviderStartAddRadioItem2();
    }
    return providerStartAddRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getProviderStartAddRadioItem3(){
    if(providerStartAddRadioItem3==null){

      providerStartAddRadioItem3 = new ACRadioButtonItem();

      providerStartAddRadioItem3.setText("II�^");

      providerStartAddRadioItem3.setGroup(getProviderStartAddRadioGroup());

      providerStartAddRadioItem3.setConstraints(VRLayout.FLOW);

      addProviderStartAddRadioItem3();
    }
    return providerStartAddRadioItem3;

  }

  /**
   * �T�[�r�X�񋟑̐��������Z���擾���܂��B
   * @return �T�[�r�X�񋟑̐��������Z
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("�T�[�r�X�񋟑̐��������Z");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1750108");

      serviceAddProvisionStructuralRadioGroup.setVisible(true);

      serviceAddProvisionStructuralRadioGroup.setEnabled(true);

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,2,3,4});

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
   * I�^���擾���܂��B
   * @return I�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("I�^");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * II�^���擾���܂��B
   * @return II�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II�^");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * III�^���擾���܂��B
   * @return III�^
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("III�^");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * �Z��敪���擾���܂��B
   * @return �Z��敪
   */
  public ACClearableRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACClearableRadioButtonGroup();

      getCalculationDivisionContainer().setText("�Z��敪");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * �Z��敪�R���e�i���擾���܂��B
   * @return �Z��敪�R���e�i
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * �Z��敪���f�����擾���܂��B
   * @return �Z��敪���f��
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * �ʏ���擾���܂��B
   * @return �ʏ�
   */
  public ACRadioButtonItem getCalculationDivisionItem1(){
    if(calculationDivisionItem1==null){

      calculationDivisionItem1 = new ACRadioButtonItem();

      calculationDivisionItem1.setText("�ʏ�");

      calculationDivisionItem1.setGroup(getCalculationDivision());

      calculationDivisionItem1.setConstraints(VRLayout.FLOW);

      addCalculationDivisionItem1();
    }
    return calculationDivisionItem1;

  }

  /**
   * ���Z�݂̂��擾���܂��B
   * @return ���Z�̂�
   */
  public ACRadioButtonItem getCalculationDivisionItem2(){
    if(calculationDivisionItem2==null){

      calculationDivisionItem2 = new ACRadioButtonItem();

      calculationDivisionItem2.setText("���Z�̂�");

      calculationDivisionItem2.setGroup(getCalculationDivision());

      calculationDivisionItem2.setConstraints(VRLayout.FLOW);

      addCalculationDivisionItem2();
    }
    return calculationDivisionItem2;

  }

  /**
   * �������擾���܂��B
   * @return ����
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("����");

      crackOnDayCheck.setBindPath("1750103");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * ���x�������R���e�i���擾���܂��B
   * @return ���x�������R���e�i
   */
  public ACGroupBox getKaigoSupportSpecialMemberContainer(){
    if(kaigoSupportSpecialMemberContainer==null){

      kaigoSupportSpecialMemberContainer = new ACGroupBox();

      kaigoSupportSpecialMemberContainer.setText("���x���������");

      addKaigoSupportSpecialMemberContainer();
    }
    return kaigoSupportSpecialMemberContainer;

  }

  /**
   * ���x�������ԍ����擾���܂��B
   * @return ���x�������ԍ�
   */
  public ACTextField getKaigoSupportSpecialMemberNumber(){
    if(kaigoSupportSpecialMemberNumber==null){

      kaigoSupportSpecialMemberNumber = new ACTextField();

      getKaigoSupportSpecialMemberNumberContainer().setText("���x�������ԍ�");

      kaigoSupportSpecialMemberNumber.setBindPath("1750104");

      kaigoSupportSpecialMemberNumber.setColumns(6);

      kaigoSupportSpecialMemberNumber.setCharType(VRCharType.ONLY_DIGIT);

      kaigoSupportSpecialMemberNumber.setMaxLength(8);

      addKaigoSupportSpecialMemberNumber();
    }
    return kaigoSupportSpecialMemberNumber;

  }

  /**
   * ���x�������ԍ��R���e�i���擾���܂��B
   * @return ���x�������ԍ��R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNumberContainer(){
    if(kaigoSupportSpecialMemberNumberContainer==null){
      kaigoSupportSpecialMemberNumberContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNumberContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNumberContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNumberContainer.add(getKaigoSupportSpecialMemberNumber(), null);
    }
    return kaigoSupportSpecialMemberNumberContainer;
  }

  /**
   * ���x�������������擾���܂��B
   * @return ���x����������
   */
  public ACComboBox getKaigoSupportSpecialMemberName(){
    if(kaigoSupportSpecialMemberName==null){

      kaigoSupportSpecialMemberName = new ACComboBox();

      getKaigoSupportSpecialMemberNameContainer().setText("���x����������");

      kaigoSupportSpecialMemberName.setEditable(false);

      kaigoSupportSpecialMemberName.setRenderBindPath("STAFF_NAME");

      kaigoSupportSpecialMemberName.setMaxLength(60);

      kaigoSupportSpecialMemberName.setMaxColumns(10);

      kaigoSupportSpecialMemberName.setModel(getKaigoSupportSpecialMemberNameModel());

      addKaigoSupportSpecialMemberName();
    }
    return kaigoSupportSpecialMemberName;

  }

  /**
   * ���x�����������R���e�i���擾���܂��B
   * @return ���x�����������R���e�i
   */
  protected ACLabelContainer getKaigoSupportSpecialMemberNameContainer(){
    if(kaigoSupportSpecialMemberNameContainer==null){
      kaigoSupportSpecialMemberNameContainer = new ACLabelContainer();
      kaigoSupportSpecialMemberNameContainer.setFollowChildEnabled(true);
      kaigoSupportSpecialMemberNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoSupportSpecialMemberNameContainer.add(getKaigoSupportSpecialMemberName(), null);
    }
    return kaigoSupportSpecialMemberNameContainer;
  }

  /**
   * ���x�������������f�����擾���܂��B
   * @return ���x�������������f��
   */
  protected ACComboBoxModelAdapter getKaigoSupportSpecialMemberNameModel(){
    if(kaigoSupportSpecialMemberNameModel==null){
      kaigoSupportSpecialMemberNameModel = new ACComboBoxModelAdapter();
      addKaigoSupportSpecialMemberNameModel();
    }
    return kaigoSupportSpecialMemberNameModel;
  }

  /**
   * �^�u2���擾���܂��B
   * @return �^�u2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * �E�v�������O���[�v���擾���܂��B
   * @return �E�v�������O���[�v
   */
  public ACGroupBox getTekiyouGroup(){
    if(tekiyouGroup==null){

      tekiyouGroup = new ACGroupBox();

      tekiyouGroup.setText("�E�v��");

      tekiyouGroup.setVisible(true);

      tekiyouGroup.setEnabled(true);

      tekiyouGroup.setHgap(0);

      tekiyouGroup.setLabelMargin(0);

      tekiyouGroup.setVgap(0);

      addTekiyouGroup();
    }
    return tekiyouGroup;

  }

  /**
   * �E�v���e�L�X�g���擾���܂��B
   * @return �E�v���e�L�X�g
   */
  public ACTextField getTekiyouText(){
    if(tekiyouText==null){

      tekiyouText = new ACTextField();

      getTekiyouTextContainer().setText("�ʏ��K��h������");

      tekiyouText.setBindPath("1750105");

      tekiyouText.setVisible(true);

      tekiyouText.setEnabled(true);

      tekiyouText.setEditable(true);

      tekiyouText.setColumns(5);

      tekiyouText.setCharType(VRCharType.ONLY_DIGIT);

      tekiyouText.setHorizontalAlignment(SwingConstants.LEFT);

      tekiyouText.setIMEMode(InputSubset.LATIN);

      tekiyouText.setMaxLength(6);

      addTekiyouText();
    }
    return tekiyouText;

  }

  /**
   * �E�v���e�L�X�g�R���e�i���擾���܂��B
   * @return �E�v���e�L�X�g�R���e�i
   */
  protected ACLabelContainer getTekiyouTextContainer(){
    if(tekiyouTextContainer==null){
      tekiyouTextContainer = new ACLabelContainer();
      tekiyouTextContainer.setFollowChildEnabled(true);
      tekiyouTextContainer.setVAlignment(VRLayout.CENTER);
      tekiyouTextContainer.add(getTekiyouText(), null);
    }
    return tekiyouTextContainer;
  }

  /**
   * �E�v���������x�����擾���܂��B
   * @return �E�v���������x��
   */
  public ACLabel getTekiyouCommentTitle(){
    if(tekiyouCommentTitle==null){

      tekiyouCommentTitle = new ACLabel();

      tekiyouCommentTitle.setText("���̈�ԍŏ��̗��p���ɋL�����Ă��������B");

      tekiyouCommentTitle.setIconPath(ACConstants.ICON_PATH_EXCLAMATION_16);

      tekiyouCommentTitle.setAutoWrap(true);

      addTekiyouCommentTitle();
    }
    return tekiyouCommentTitle;

  }

  /**
   * ���ӏ����O���[�v���擾���܂��B
   * @return ���ӏ����O���[�v
   */
  public ACGroupBox getInfoGroup(){
    if(infoGroup==null){

      infoGroup = new ACGroupBox();

      infoGroup.setHgap(0);

      infoGroup.setLabelMargin(0);

      infoGroup.setVgap(0);

      addInfoGroup();
    }
    return infoGroup;

  }

  /**
   * ���ӏ������x�����擾���܂��B
   * @return ���ӏ������x��
   */
  public ACLabel getInfoLabel(){
    if(infoLabel==null){

      infoLabel = new ACLabel();

      infoLabel.setText("���r���ŗv����ԋ敪���ύX�ɂȂ�ꍇ�́A" + ACConstants.LINE_SEPARATOR + "�e������T�[�r�X�����ׂĂ̓����ɓ\��t���āA" + ACConstants.LINE_SEPARATOR + "�W�v��A�ҏW��ʂŎ������̏C�����s���Ă��������B");

      addInfoLabel();
    }
    return infoLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QS001147_H2104Design() {

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

    this.add(getRegionSmallscaleMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * �n�斧�����K�͑��@�\�^���p�^�[���̈�ɓ������ڂ�ǉ����܂��B
   */
  protected void addRegionSmallscaleMultiPatterns(){

    regionSmallscaleMultiPatterns.addTab("1", getTab1());

    regionSmallscaleMultiPatterns.addTab("2", getTab2());

  }

  /**
   * �^�u1�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab1(){

    tab1.add(getInitialAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getUnderServiceSubtractionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getProviderStartAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getCrackOnDayCheck(), VRLayout.FLOW_RETURN);

    tab1.add(getKaigoSupportSpecialMemberContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * �������Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadio(){

  }

  /**
   * �������Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioModel(){

    getInitialAddRadioItem1().setButtonIndex(1);

    getInitialAddRadioModel().add(getInitialAddRadioItem1());

    getInitialAddRadioItem2().setButtonIndex(2);

    getInitialAddRadioModel().add(getInitialAddRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addInitialAddRadioItem2(){

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
   * ���E�Ō�E���������ɓ������ڂ�ǉ����܂��B
   */
  protected void addStaffSubtractionRadioItem3(){

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnderServiceSubtractionRadioGroup(){

  }

  /**
   * �ߏ��T�[�r�X�ɑ΂��錸�Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnderServiceSubtractionRadioGroupModel(){

    getUnderServiceSubtractionRadioItem1().setButtonIndex(1);

    getUnderServiceSubtractionRadioGroupModel().add(getUnderServiceSubtractionRadioItem1());

    getUnderServiceSubtractionRadioItem2().setButtonIndex(2);

    getUnderServiceSubtractionRadioGroupModel().add(getUnderServiceSubtractionRadioItem2());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnderServiceSubtractionRadioItem1(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addUnderServiceSubtractionRadioItem2(){

  }

  /**
   * ���ƊJ�n���x�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStartAddRadioGroup(){

  }

  /**
   * ���ƊJ�n���x�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStartAddRadioGroupModel(){

    getProviderStartAddRadioItem1().setButtonIndex(1);

    getProviderStartAddRadioGroupModel().add(getProviderStartAddRadioItem1());

    getProviderStartAddRadioItem2().setButtonIndex(2);

    getProviderStartAddRadioGroupModel().add(getProviderStartAddRadioItem2());

    getProviderStartAddRadioItem3().setButtonIndex(3);

    getProviderStartAddRadioGroupModel().add(getProviderStartAddRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStartAddRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStartAddRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addProviderStartAddRadioItem3(){

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

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * I�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * III�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * �Z��敪�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivision(){

  }

  /**
   * �Z��敪���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionItem1().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionItem1());

    getCalculationDivisionItem2().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionItem2());

  }

  /**
   * �ʏ�ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionItem1(){

  }

  /**
   * ���Z�݂̂ɓ������ڂ�ǉ����܂��B
   */
  protected void addCalculationDivisionItem2(){

  }

  /**
   * �����ɓ������ڂ�ǉ����܂��B
   */
  protected void addCrackOnDayCheck(){

  }

  /**
   * ���x�������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberContainer(){

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNumberContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoSupportSpecialMemberContainer.add(getKaigoSupportSpecialMemberNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * ���x�������ԍ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberNumber(){

  }

  /**
   * ���x�����������ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberName(){

  }

  /**
   * ���x�������������f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addKaigoSupportSpecialMemberNameModel(){

  }

  /**
   * �^�u2�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTab2(){

    tab2.add(getTekiyouGroup(), VRLayout.FLOW_RETURN);

    tab2.add(getInfoGroup(), VRLayout.FLOW);

  }

  /**
   * �E�v�������O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouGroup(){

    tekiyouGroup.add(getTekiyouTextContainer(), VRLayout.FLOW_RETURN);

    tekiyouGroup.add(getTekiyouCommentTitle(), VRLayout.FLOW_RETURN);

  }

  /**
   * �E�v���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouText(){

  }

  /**
   * �E�v���������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addTekiyouCommentTitle(){

  }

  /**
   * ���ӏ����O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoGroup(){

    infoGroup.add(getInfoLabel(), VRLayout.FLOW);

  }

  /**
   * ���ӏ������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addInfoLabel(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001147_H2104Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QS001147_H2104Design getThis() {
    return this;
  }
}
