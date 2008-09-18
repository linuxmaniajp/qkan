
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
 * �쐬��: 2006/02/18  ���{�R���s���[�^�[������� ����@��F �V�K�쐬
 * �X�V��: ----/--/--
 * �V�X�e�� ���t�Ǘ��䒠 (Q)
 * �T�u�V�X�e�� ���̑��@�\ (O)
 * �v���Z�X ���Ə����o�^ (004)
 * �v���O���� �Z�������×{���i���V�l�ی��{�݁j (QO004009)
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
 * �Z�������×{���i���V�l�ی��{�݁j��ʍ��ڃf�U�C��(QO004009) 
 */
public class QO004009Design extends ACPanel {
  //GUI�R���|�[�l���g

  private ACGroupBox shortStayCareOldPersonGroup;

  private ACLabelContainer shortStayCareOldPersonDiscountConteiner;

  private ACTextField shortStayCareOldPersonDiscountText;

  private ACLabel shortStayCareOldPersonDiscountLabel;

  private ACClearableRadioButtonGroup shortStayCareOldPersonInstitutionDivisionRadio;

  private ACLabelContainer shortStayCareOldPersonInstitutionDivisionRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonInstitutionDivisionRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonInstitutionDivisionRadioItem1;

  private ACRadioButtonItem shortStayCareOldPersonInstitutionDivisionRadioItem2;

  private ACClearableRadioButtonGroup shortStayCareOldPersonNightWorkDivisionRadio;

  private ACLabelContainer shortStayCareOldPersonNightWorkDivisionRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonNightWorkDivisionRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonNightWorkDivisionOn;

  private ACRadioButtonItem shortStayCareOldPersonNightWorkDivisionOff;

  private ACClearableRadioButtonGroup shortStayCareOldPersonRehabilitationRadio;

  private ACLabelContainer shortStayCareOldPersonRehabilitationRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonRehabilitationRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonRehabilitationOff;

  private ACRadioButtonItem shortStayCareOldPersonRehabilitationOn;

  private ACClearableRadioButtonGroup shortStayCareOldPersonCognitiveRadio;

  private ACLabelContainer shortStayCareOldPersonCognitiveRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonCognitiveRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonCognitiveOff;

  private ACRadioButtonItem shortStayCareOldPersonCognitiveOn;

  private ACClearableRadioButtonGroup shortStayCareOldPersonMeetingAndSendingRadio;

  private ACLabelContainer shortStayCareOldPersonMeetingAndSendingRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonMeetingAndSendingRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonMeetingAndSendingOff;

  private ACRadioButtonItem shortStayCareOldPersonMeetingAndSendingOn;

  private ACClearableRadioButtonGroup shortStayCareOldPersonRecuperationNutritionManageRadio;

  private ACLabelContainer shortStayCareOldPersonRecuperationNutritionManageRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonRecuperationNutritionManageRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonRecuperationNutritionManageOff;

  private ACRadioButtonItem shortStayCareOldPersonNutritionManageOn;

  private ACClearableRadioButtonGroup shortStayCareOldPersonRecuperationRadio;

  private ACLabelContainer shortStayCareOldPersonRecuperationRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonRecuperationRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonOff;

  private ACRadioButtonItem shortStayCareOldPersonOn;

  private ACClearableRadioButtonGroup shortStayCareOldPersonStaffReduceRadio;

  private ACLabelContainer shortStayCareOldPersonStaffReduceRadioContainer;

  private ACListModelAdapter shortStayCareOldPersonStaffReduceRadioModel;

  private ACRadioButtonItem shortStayCareOldPersonStaffReduceRadioItem1;

  private ACRadioButtonItem shortStayCareOldPersonStaffReduceRadioItem2;

  private ACRadioButtonItem shortStayCareOldPersonStaffReduceRadioItem3;

  private ACLabelContainer shortStayCareOldPersonDinnerStandardConteinar;

  private ACTextField shortStayCareOldPersonDinnerStandarTotal;

  private ACLabel shortStayCareOldPersonMorningDinnerStandardMoneyLabel;

  private ACTextField shortStayCareOldPersonMorningDinnerStandardMoney;

  private ACLabel shortStayCareOldPersonNoonDinnerStandardMoneyLabel;

  private ACTextField shortStayCareOldPersonNoonDinnerStandardMoney;

  private ACLabel shortStayCareOldPersonNightDinnerStandardMoneyLabel;

  private ACTextField shortStayCareOldPersonNightDinnerStandardMoney;

  private ACLabel shortStayCareOldPersonDinnerStandarTotalLabel;

  private ACLabelContainer shortStayCareOldPersonUnitRoomContainar;

  private ACTextField shortStayCareOldPersonUnitRoomText;

  private ACLabel shortStayCareOldPersonUnitRoomLabel;

  private ACLabelContainer shortStayCareOldPersonUnitSemiRoomContainar;

  private ACTextField shortStayCareOldPersonUnitSemiRoomText;

  private ACLabel shortStayCareOldPersonUnitSemiRoomLabel;

  private ACLabelContainer shortStayCareOldPersonNormalRoomContainar;

  private ACTextField shortStayCareOldPersonNormalRoomText;

  private ACLabel shortStayCareOldPersonNormalRoomLabel;

  private ACLabelContainer shortStayCareOldPersonTasyouRoomContainar;

  private ACTextField shortStayCareOldPersonTasyouRoomText;

  private ACLabel shortStayCareOldPersonTasyouRoomLabel;

  //getter

  /**
   * ���ƃO���[�v���擾���܂��B
   * @return ���ƃO���[�v
   */
  public ACGroupBox getShortStayCareOldPersonGroup(){
    if(shortStayCareOldPersonGroup==null){

      shortStayCareOldPersonGroup = new ACGroupBox();

      shortStayCareOldPersonGroup.setText("�Z�������×{���i���V�l�ی��{�݁j");

      shortStayCareOldPersonGroup.setFollowChildEnabled(true);

      shortStayCareOldPersonGroup.setHgrid(200);

      addShortStayCareOldPersonGroup();
    }
    return shortStayCareOldPersonGroup;

  }

  /**
   * �������R���e�i���擾���܂��B
   * @return �������R���e�i
   */
  public ACLabelContainer getShortStayCareOldPersonDiscountConteiner(){
    if(shortStayCareOldPersonDiscountConteiner==null){

      shortStayCareOldPersonDiscountConteiner = new ACLabelContainer();

      shortStayCareOldPersonDiscountConteiner.setText("������");

      shortStayCareOldPersonDiscountConteiner.setFollowChildEnabled(true);

      addShortStayCareOldPersonDiscountConteiner();
    }
    return shortStayCareOldPersonDiscountConteiner;

  }

  /**
   * �e�L�X�g���擾���܂��B
   * @return �e�L�X�g
   */
  public ACTextField getShortStayCareOldPersonDiscountText(){
    if(shortStayCareOldPersonDiscountText==null){

      shortStayCareOldPersonDiscountText = new ACTextField();

      shortStayCareOldPersonDiscountText.setBindPath("REDUCT_RATE");

      shortStayCareOldPersonDiscountText.setColumns(3);

      shortStayCareOldPersonDiscountText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonDiscountText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonDiscountText.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonDiscountText.setMaxLength(3);

      addShortStayCareOldPersonDiscountText();
    }
    return shortStayCareOldPersonDiscountText;

  }

  /**
   * ���x�����擾���܂��B
   * @return ���x��
   */
  public ACLabel getShortStayCareOldPersonDiscountLabel(){
    if(shortStayCareOldPersonDiscountLabel==null){

      shortStayCareOldPersonDiscountLabel = new ACLabel();

      shortStayCareOldPersonDiscountLabel.setText("��");

      addShortStayCareOldPersonDiscountLabel();
    }
    return shortStayCareOldPersonDiscountLabel;

  }

  /**
   * �{�݋敪���W�I�O���[�v���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonInstitutionDivisionRadio(){
    if(shortStayCareOldPersonInstitutionDivisionRadio==null){

      shortStayCareOldPersonInstitutionDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonInstitutionDivisionRadioContainer().setText("�{�݋敪");

      shortStayCareOldPersonInstitutionDivisionRadio.setBindPath("1220101");

      shortStayCareOldPersonInstitutionDivisionRadio.setModel(getShortStayCareOldPersonInstitutionDivisionRadioModel());

      shortStayCareOldPersonInstitutionDivisionRadio.setUseClearButton(false);

      addShortStayCareOldPersonInstitutionDivisionRadio();
    }
    return shortStayCareOldPersonInstitutionDivisionRadio;

  }

  /**
   * �{�݋敪���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �{�݋敪���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayCareOldPersonInstitutionDivisionRadioContainer(){
    if(shortStayCareOldPersonInstitutionDivisionRadioContainer==null){
      shortStayCareOldPersonInstitutionDivisionRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonInstitutionDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonInstitutionDivisionRadioContainer.add(getShortStayCareOldPersonInstitutionDivisionRadio(), null);
    }
    return shortStayCareOldPersonInstitutionDivisionRadioContainer;
  }

  /**
   * �{�݋敪���W�I�O���[�v���f�����擾���܂��B
   * @return �{�݋敪���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayCareOldPersonInstitutionDivisionRadioModel(){
    if(shortStayCareOldPersonInstitutionDivisionRadioModel==null){
      shortStayCareOldPersonInstitutionDivisionRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonInstitutionDivisionRadioModel();
    }
    return shortStayCareOldPersonInstitutionDivisionRadioModel;
  }

  /**
   * ���V�l�ی��{�݂��擾���܂��B
   * @return ���V�l�ی��{��
   */
  public ACRadioButtonItem getShortStayCareOldPersonInstitutionDivisionRadioItem1(){
    if(shortStayCareOldPersonInstitutionDivisionRadioItem1==null){

      shortStayCareOldPersonInstitutionDivisionRadioItem1 = new ACRadioButtonItem();

      shortStayCareOldPersonInstitutionDivisionRadioItem1.setText("���V�l�ی��{��");

      shortStayCareOldPersonInstitutionDivisionRadioItem1.setGroup(getShortStayCareOldPersonInstitutionDivisionRadio());

      addShortStayCareOldPersonInstitutionDivisionRadioItem1();
    }
    return shortStayCareOldPersonInstitutionDivisionRadioItem1;

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݂��擾���܂��B
   * @return ���j�b�g�^���V�l�ی��{��
   */
  public ACRadioButtonItem getShortStayCareOldPersonInstitutionDivisionRadioItem2(){
    if(shortStayCareOldPersonInstitutionDivisionRadioItem2==null){

      shortStayCareOldPersonInstitutionDivisionRadioItem2 = new ACRadioButtonItem();

      shortStayCareOldPersonInstitutionDivisionRadioItem2.setText("���j�b�g�^���V�l�ی��{��");

      shortStayCareOldPersonInstitutionDivisionRadioItem2.setGroup(getShortStayCareOldPersonInstitutionDivisionRadio());

      addShortStayCareOldPersonInstitutionDivisionRadioItem2();
    }
    return shortStayCareOldPersonInstitutionDivisionRadioItem2;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonNightWorkDivisionRadio(){
    if(shortStayCareOldPersonNightWorkDivisionRadio==null){

      shortStayCareOldPersonNightWorkDivisionRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonNightWorkDivisionRadioContainer().setText("��ԋΖ������");

      shortStayCareOldPersonNightWorkDivisionRadio.setBindPath("1220102");

      shortStayCareOldPersonNightWorkDivisionRadio.setModel(getShortStayCareOldPersonNightWorkDivisionRadioModel());

      shortStayCareOldPersonNightWorkDivisionRadio.setUseClearButton(false);

      addShortStayCareOldPersonNightWorkDivisionRadio();
    }
    return shortStayCareOldPersonNightWorkDivisionRadio;

  }

  /**
   * ��ԋΖ���������W�I�O���[�v�R���e�i���擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayCareOldPersonNightWorkDivisionRadioContainer(){
    if(shortStayCareOldPersonNightWorkDivisionRadioContainer==null){
      shortStayCareOldPersonNightWorkDivisionRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonNightWorkDivisionRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonNightWorkDivisionRadioContainer.add(getShortStayCareOldPersonNightWorkDivisionRadio(), null);
    }
    return shortStayCareOldPersonNightWorkDivisionRadioContainer;
  }

  /**
   * ��ԋΖ���������W�I�O���[�v���f�����擾���܂��B
   * @return ��ԋΖ���������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayCareOldPersonNightWorkDivisionRadioModel(){
    if(shortStayCareOldPersonNightWorkDivisionRadioModel==null){
      shortStayCareOldPersonNightWorkDivisionRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonNightWorkDivisionRadioModel();
    }
    return shortStayCareOldPersonNightWorkDivisionRadioModel;
  }

  /**
   * ��^���擾���܂��B
   * @return ��^
   */
  public ACRadioButtonItem getShortStayCareOldPersonNightWorkDivisionOn(){
    if(shortStayCareOldPersonNightWorkDivisionOn==null){

      shortStayCareOldPersonNightWorkDivisionOn = new ACRadioButtonItem();

      shortStayCareOldPersonNightWorkDivisionOn.setText("��^");

      shortStayCareOldPersonNightWorkDivisionOn.setGroup(getShortStayCareOldPersonNightWorkDivisionRadio());

      addShortStayCareOldPersonNightWorkDivisionOn();
    }
    return shortStayCareOldPersonNightWorkDivisionOn;

  }

  /**
   * ���Z�^���擾���܂��B
   * @return ���Z�^
   */
  public ACRadioButtonItem getShortStayCareOldPersonNightWorkDivisionOff(){
    if(shortStayCareOldPersonNightWorkDivisionOff==null){

      shortStayCareOldPersonNightWorkDivisionOff = new ACRadioButtonItem();

      shortStayCareOldPersonNightWorkDivisionOff.setText("���Z�^");

      shortStayCareOldPersonNightWorkDivisionOff.setGroup(getShortStayCareOldPersonNightWorkDivisionRadio());

      addShortStayCareOldPersonNightWorkDivisionOff();
    }
    return shortStayCareOldPersonNightWorkDivisionOff;

  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v���擾���܂��B
   * @return ���n�r���e�[�V�����@�\�������W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonRehabilitationRadio(){
    if(shortStayCareOldPersonRehabilitationRadio==null){

      shortStayCareOldPersonRehabilitationRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonRehabilitationRadioContainer().setText("���n�r���@�\�����̐�");

      shortStayCareOldPersonRehabilitationRadio.setBindPath("1220103");

      shortStayCareOldPersonRehabilitationRadio.setModel(getShortStayCareOldPersonRehabilitationRadioModel());

      shortStayCareOldPersonRehabilitationRadio.setUseClearButton(false);

      addShortStayCareOldPersonRehabilitationRadio();
    }
    return shortStayCareOldPersonRehabilitationRadio;

  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���n�r���e�[�V�����@�\�������W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayCareOldPersonRehabilitationRadioContainer(){
    if(shortStayCareOldPersonRehabilitationRadioContainer==null){
      shortStayCareOldPersonRehabilitationRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonRehabilitationRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonRehabilitationRadioContainer.add(getShortStayCareOldPersonRehabilitationRadio(), null);
    }
    return shortStayCareOldPersonRehabilitationRadioContainer;
  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v���f�����擾���܂��B
   * @return ���n�r���e�[�V�����@�\�������W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayCareOldPersonRehabilitationRadioModel(){
    if(shortStayCareOldPersonRehabilitationRadioModel==null){
      shortStayCareOldPersonRehabilitationRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonRehabilitationRadioModel();
    }
    return shortStayCareOldPersonRehabilitationRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayCareOldPersonRehabilitationOff(){
    if(shortStayCareOldPersonRehabilitationOff==null){

      shortStayCareOldPersonRehabilitationOff = new ACRadioButtonItem();

      shortStayCareOldPersonRehabilitationOff.setText("�Ȃ�");

      shortStayCareOldPersonRehabilitationOff.setGroup(getShortStayCareOldPersonRehabilitationRadio());

      addShortStayCareOldPersonRehabilitationOff();
    }
    return shortStayCareOldPersonRehabilitationOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayCareOldPersonRehabilitationOn(){
    if(shortStayCareOldPersonRehabilitationOn==null){

      shortStayCareOldPersonRehabilitationOn = new ACRadioButtonItem();

      shortStayCareOldPersonRehabilitationOn.setText("����");

      shortStayCareOldPersonRehabilitationOn.setGroup(getShortStayCareOldPersonRehabilitationRadio());

      addShortStayCareOldPersonRehabilitationOn();
    }
    return shortStayCareOldPersonRehabilitationOn;

  }

  /**
   * �F�m�ǐ�哏���W�I�O���[�v���擾���܂��B
   * @return �F�m�ǐ�哏���W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonCognitiveRadio(){
    if(shortStayCareOldPersonCognitiveRadio==null){

      shortStayCareOldPersonCognitiveRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonCognitiveRadioContainer().setText("�F�m�ǐ�哏");

      shortStayCareOldPersonCognitiveRadio.setBindPath("1220104");

      shortStayCareOldPersonCognitiveRadio.setModel(getShortStayCareOldPersonCognitiveRadioModel());

      shortStayCareOldPersonCognitiveRadio.setUseClearButton(false);

      addShortStayCareOldPersonCognitiveRadio();
    }
    return shortStayCareOldPersonCognitiveRadio;

  }

  /**
   * �F�m�ǐ�哏���W�I�O���[�v�R���e�i���擾���܂��B
   * @return �F�m�ǐ�哏���W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayCareOldPersonCognitiveRadioContainer(){
    if(shortStayCareOldPersonCognitiveRadioContainer==null){
      shortStayCareOldPersonCognitiveRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonCognitiveRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonCognitiveRadioContainer.add(getShortStayCareOldPersonCognitiveRadio(), null);
    }
    return shortStayCareOldPersonCognitiveRadioContainer;
  }

  /**
   * �F�m�ǐ�哏���W�I�O���[�v���f�����擾���܂��B
   * @return �F�m�ǐ�哏���W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayCareOldPersonCognitiveRadioModel(){
    if(shortStayCareOldPersonCognitiveRadioModel==null){
      shortStayCareOldPersonCognitiveRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonCognitiveRadioModel();
    }
    return shortStayCareOldPersonCognitiveRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayCareOldPersonCognitiveOff(){
    if(shortStayCareOldPersonCognitiveOff==null){

      shortStayCareOldPersonCognitiveOff = new ACRadioButtonItem();

      shortStayCareOldPersonCognitiveOff.setText("�Ȃ�");

      shortStayCareOldPersonCognitiveOff.setGroup(getShortStayCareOldPersonCognitiveRadio());

      addShortStayCareOldPersonCognitiveOff();
    }
    return shortStayCareOldPersonCognitiveOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayCareOldPersonCognitiveOn(){
    if(shortStayCareOldPersonCognitiveOn==null){

      shortStayCareOldPersonCognitiveOn = new ACRadioButtonItem();

      shortStayCareOldPersonCognitiveOn.setText("����");

      shortStayCareOldPersonCognitiveOn.setGroup(getShortStayCareOldPersonCognitiveRadio());

      addShortStayCareOldPersonCognitiveOn();
    }
    return shortStayCareOldPersonCognitiveOn;

  }

  /**
   * ���}�̐����W�I�O���[�v���擾���܂��B
   * @return ���}�̐����W�I�O���[�v
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonMeetingAndSendingRadio(){
    if(shortStayCareOldPersonMeetingAndSendingRadio==null){

      shortStayCareOldPersonMeetingAndSendingRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonMeetingAndSendingRadioContainer().setText("���}�̐�");

      shortStayCareOldPersonMeetingAndSendingRadio.setBindPath("1220105");

      shortStayCareOldPersonMeetingAndSendingRadio.setModel(getShortStayCareOldPersonMeetingAndSendingRadioModel());

      shortStayCareOldPersonMeetingAndSendingRadio.setUseClearButton(false);

      addShortStayCareOldPersonMeetingAndSendingRadio();
    }
    return shortStayCareOldPersonMeetingAndSendingRadio;

  }

  /**
   * ���}�̐����W�I�O���[�v�R���e�i���擾���܂��B
   * @return ���}�̐����W�I�O���[�v�R���e�i
   */
  protected ACLabelContainer getShortStayCareOldPersonMeetingAndSendingRadioContainer(){
    if(shortStayCareOldPersonMeetingAndSendingRadioContainer==null){
      shortStayCareOldPersonMeetingAndSendingRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonMeetingAndSendingRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonMeetingAndSendingRadioContainer.add(getShortStayCareOldPersonMeetingAndSendingRadio(), null);
    }
    return shortStayCareOldPersonMeetingAndSendingRadioContainer;
  }

  /**
   * ���}�̐����W�I�O���[�v���f�����擾���܂��B
   * @return ���}�̐����W�I�O���[�v���f��
   */
  protected ACListModelAdapter getShortStayCareOldPersonMeetingAndSendingRadioModel(){
    if(shortStayCareOldPersonMeetingAndSendingRadioModel==null){
      shortStayCareOldPersonMeetingAndSendingRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonMeetingAndSendingRadioModel();
    }
    return shortStayCareOldPersonMeetingAndSendingRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayCareOldPersonMeetingAndSendingOff(){
    if(shortStayCareOldPersonMeetingAndSendingOff==null){

      shortStayCareOldPersonMeetingAndSendingOff = new ACRadioButtonItem();

      shortStayCareOldPersonMeetingAndSendingOff.setText("�Ȃ�");

      shortStayCareOldPersonMeetingAndSendingOff.setGroup(getShortStayCareOldPersonMeetingAndSendingRadio());

      addShortStayCareOldPersonMeetingAndSendingOff();
    }
    return shortStayCareOldPersonMeetingAndSendingOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayCareOldPersonMeetingAndSendingOn(){
    if(shortStayCareOldPersonMeetingAndSendingOn==null){

      shortStayCareOldPersonMeetingAndSendingOn = new ACRadioButtonItem();

      shortStayCareOldPersonMeetingAndSendingOn.setText("����");

      shortStayCareOldPersonMeetingAndSendingOn.setGroup(getShortStayCareOldPersonMeetingAndSendingRadio());

      addShortStayCareOldPersonMeetingAndSendingOn();
    }
    return shortStayCareOldPersonMeetingAndSendingOn;

  }

  /**
   * �h�{�Ǘ��̐����擾���܂��B
   * @return �h�{�Ǘ��̐�
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonRecuperationNutritionManageRadio(){
    if(shortStayCareOldPersonRecuperationNutritionManageRadio==null){

      shortStayCareOldPersonRecuperationNutritionManageRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonRecuperationNutritionManageRadioContainer().setText("�h�{�Ǘ��̐�");

      shortStayCareOldPersonRecuperationNutritionManageRadio.setBindPath("1220106");

      shortStayCareOldPersonRecuperationNutritionManageRadio.setModel(getShortStayCareOldPersonRecuperationNutritionManageRadioModel());

      shortStayCareOldPersonRecuperationNutritionManageRadio.setUseClearButton(false);

      addShortStayCareOldPersonRecuperationNutritionManageRadio();
    }
    return shortStayCareOldPersonRecuperationNutritionManageRadio;

  }

  /**
   * �h�{�Ǘ��̐��R���e�i���擾���܂��B
   * @return �h�{�Ǘ��̐��R���e�i
   */
  protected ACLabelContainer getShortStayCareOldPersonRecuperationNutritionManageRadioContainer(){
    if(shortStayCareOldPersonRecuperationNutritionManageRadioContainer==null){
      shortStayCareOldPersonRecuperationNutritionManageRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonRecuperationNutritionManageRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonRecuperationNutritionManageRadioContainer.add(getShortStayCareOldPersonRecuperationNutritionManageRadio(), null);
    }
    return shortStayCareOldPersonRecuperationNutritionManageRadioContainer;
  }

  /**
   * �h�{�Ǘ��̐����f�����擾���܂��B
   * @return �h�{�Ǘ��̐����f��
   */
  protected ACListModelAdapter getShortStayCareOldPersonRecuperationNutritionManageRadioModel(){
    if(shortStayCareOldPersonRecuperationNutritionManageRadioModel==null){
      shortStayCareOldPersonRecuperationNutritionManageRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonRecuperationNutritionManageRadioModel();
    }
    return shortStayCareOldPersonRecuperationNutritionManageRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayCareOldPersonRecuperationNutritionManageOff(){
    if(shortStayCareOldPersonRecuperationNutritionManageOff==null){

      shortStayCareOldPersonRecuperationNutritionManageOff = new ACRadioButtonItem();

      shortStayCareOldPersonRecuperationNutritionManageOff.setText("�Ȃ�");

      shortStayCareOldPersonRecuperationNutritionManageOff.setGroup(getShortStayCareOldPersonRecuperationNutritionManageRadio());

      addShortStayCareOldPersonRecuperationNutritionManageOff();
    }
    return shortStayCareOldPersonRecuperationNutritionManageOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayCareOldPersonNutritionManageOn(){
    if(shortStayCareOldPersonNutritionManageOn==null){

      shortStayCareOldPersonNutritionManageOn = new ACRadioButtonItem();

      shortStayCareOldPersonNutritionManageOn.setText("����");

      shortStayCareOldPersonNutritionManageOn.setGroup(getShortStayCareOldPersonRecuperationNutritionManageRadio());

      addShortStayCareOldPersonNutritionManageOn();
    }
    return shortStayCareOldPersonNutritionManageOn;

  }

  /**
   * �×{�H�̐����擾���܂��B
   * @return �×{�H�̐�
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonRecuperationRadio(){
    if(shortStayCareOldPersonRecuperationRadio==null){

      shortStayCareOldPersonRecuperationRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonRecuperationRadioContainer().setText("�×{�H�̐�");

      shortStayCareOldPersonRecuperationRadio.setBindPath("1220107");

      shortStayCareOldPersonRecuperationRadio.setModel(getShortStayCareOldPersonRecuperationRadioModel());

      shortStayCareOldPersonRecuperationRadio.setUseClearButton(false);

      addShortStayCareOldPersonRecuperationRadio();
    }
    return shortStayCareOldPersonRecuperationRadio;

  }

  /**
   * �×{�H�̐��R���e�i���擾���܂��B
   * @return �×{�H�̐��R���e�i
   */
  protected ACLabelContainer getShortStayCareOldPersonRecuperationRadioContainer(){
    if(shortStayCareOldPersonRecuperationRadioContainer==null){
      shortStayCareOldPersonRecuperationRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonRecuperationRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonRecuperationRadioContainer.add(getShortStayCareOldPersonRecuperationRadio(), null);
    }
    return shortStayCareOldPersonRecuperationRadioContainer;
  }

  /**
   * �×{�H�̐����f�����擾���܂��B
   * @return �×{�H�̐����f��
   */
  protected ACListModelAdapter getShortStayCareOldPersonRecuperationRadioModel(){
    if(shortStayCareOldPersonRecuperationRadioModel==null){
      shortStayCareOldPersonRecuperationRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonRecuperationRadioModel();
    }
    return shortStayCareOldPersonRecuperationRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayCareOldPersonOff(){
    if(shortStayCareOldPersonOff==null){

      shortStayCareOldPersonOff = new ACRadioButtonItem();

      shortStayCareOldPersonOff.setText("�Ȃ�");

      shortStayCareOldPersonOff.setGroup(getShortStayCareOldPersonRecuperationRadio());

      addShortStayCareOldPersonOff();
    }
    return shortStayCareOldPersonOff;

  }

  /**
   * ������擾���܂��B
   * @return ����
   */
  public ACRadioButtonItem getShortStayCareOldPersonOn(){
    if(shortStayCareOldPersonOn==null){

      shortStayCareOldPersonOn = new ACRadioButtonItem();

      shortStayCareOldPersonOn.setText("����");

      shortStayCareOldPersonOn.setGroup(getShortStayCareOldPersonRecuperationRadio());

      addShortStayCareOldPersonOn();
    }
    return shortStayCareOldPersonOn;

  }

  /**
   * �l�����Z���擾���܂��B
   * @return �l�����Z
   */
  public ACClearableRadioButtonGroup getShortStayCareOldPersonStaffReduceRadio(){
    if(shortStayCareOldPersonStaffReduceRadio==null){

      shortStayCareOldPersonStaffReduceRadio = new ACClearableRadioButtonGroup();

      getShortStayCareOldPersonStaffReduceRadioContainer().setText("�l�����Z");

      shortStayCareOldPersonStaffReduceRadio.setBindPath("1220108");

      shortStayCareOldPersonStaffReduceRadio.setModel(getShortStayCareOldPersonStaffReduceRadioModel());

      shortStayCareOldPersonStaffReduceRadio.setUseClearButton(false);

      addShortStayCareOldPersonStaffReduceRadio();
    }
    return shortStayCareOldPersonStaffReduceRadio;

  }

  /**
   * �l�����Z�R���e�i���擾���܂��B
   * @return �l�����Z�R���e�i
   */
  protected ACLabelContainer getShortStayCareOldPersonStaffReduceRadioContainer(){
    if(shortStayCareOldPersonStaffReduceRadioContainer==null){
      shortStayCareOldPersonStaffReduceRadioContainer = new ACLabelContainer();
      shortStayCareOldPersonStaffReduceRadioContainer.setFollowChildEnabled(true);
      shortStayCareOldPersonStaffReduceRadioContainer.add(getShortStayCareOldPersonStaffReduceRadio(), null);
    }
    return shortStayCareOldPersonStaffReduceRadioContainer;
  }

  /**
   * �l�����Z���f�����擾���܂��B
   * @return �l�����Z���f��
   */
  protected ACListModelAdapter getShortStayCareOldPersonStaffReduceRadioModel(){
    if(shortStayCareOldPersonStaffReduceRadioModel==null){
      shortStayCareOldPersonStaffReduceRadioModel = new ACListModelAdapter();
      addShortStayCareOldPersonStaffReduceRadioModel();
    }
    return shortStayCareOldPersonStaffReduceRadioModel;
  }

  /**
   * �Ȃ����擾���܂��B
   * @return �Ȃ�
   */
  public ACRadioButtonItem getShortStayCareOldPersonStaffReduceRadioItem1(){
    if(shortStayCareOldPersonStaffReduceRadioItem1==null){

      shortStayCareOldPersonStaffReduceRadioItem1 = new ACRadioButtonItem();

      shortStayCareOldPersonStaffReduceRadioItem1.setText("�Ȃ�");

      shortStayCareOldPersonStaffReduceRadioItem1.setGroup(getShortStayCareOldPersonStaffReduceRadio());

      addShortStayCareOldPersonStaffReduceRadioItem1();
    }
    return shortStayCareOldPersonStaffReduceRadioItem1;

  }

  /**
   * ������߂��擾���܂��B
   * @return �������
   */
  public ACRadioButtonItem getShortStayCareOldPersonStaffReduceRadioItem2(){
    if(shortStayCareOldPersonStaffReduceRadioItem2==null){

      shortStayCareOldPersonStaffReduceRadioItem2 = new ACRadioButtonItem();

      shortStayCareOldPersonStaffReduceRadioItem2.setText("�������");

      shortStayCareOldPersonStaffReduceRadioItem2.setGroup(getShortStayCareOldPersonStaffReduceRadio());

      addShortStayCareOldPersonStaffReduceRadioItem2();
    }
    return shortStayCareOldPersonStaffReduceRadioItem2;

  }

  /**
   * �Ō�E���E�����͈�t�APT�AOT�̕s�����擾���܂��B
   * @return �Ō�E���E�����͈�t�APT�AOT�̕s��
   */
  public ACRadioButtonItem getShortStayCareOldPersonStaffReduceRadioItem3(){
    if(shortStayCareOldPersonStaffReduceRadioItem3==null){

      shortStayCareOldPersonStaffReduceRadioItem3 = new ACRadioButtonItem();

      shortStayCareOldPersonStaffReduceRadioItem3.setText("�Ō�E���E�����͈�t�APT�AOT�̕s��");

      shortStayCareOldPersonStaffReduceRadioItem3.setGroup(getShortStayCareOldPersonStaffReduceRadio());

      addShortStayCareOldPersonStaffReduceRadioItem3();
    }
    return shortStayCareOldPersonStaffReduceRadioItem3;

  }

  /**
   * �H���z�E�R���e�i���擾���܂��B
   * @return �H���z�E�R���e�i
   */
  public ACLabelContainer getShortStayCareOldPersonDinnerStandardConteinar(){
    if(shortStayCareOldPersonDinnerStandardConteinar==null){

      shortStayCareOldPersonDinnerStandardConteinar = new ACLabelContainer();

      shortStayCareOldPersonDinnerStandardConteinar.setText("�@�@�@�@�@�@�@�H���z");

      shortStayCareOldPersonDinnerStandardConteinar.setFollowChildEnabled(true);

      addShortStayCareOldPersonDinnerStandardConteinar();
    }
    return shortStayCareOldPersonDinnerStandardConteinar;

  }

  /**
   * �H���z�E���v�E�e�L�X�g���擾���܂��B
   * @return �H���z�E���v�E�e�L�X�g
   */
  public ACTextField getShortStayCareOldPersonDinnerStandarTotal(){
    if(shortStayCareOldPersonDinnerStandarTotal==null){

      shortStayCareOldPersonDinnerStandarTotal = new ACTextField();

      shortStayCareOldPersonDinnerStandarTotal.setBindPath("1220109");

      shortStayCareOldPersonDinnerStandarTotal.setEditable(false);

      shortStayCareOldPersonDinnerStandarTotal.setColumns(4);

      shortStayCareOldPersonDinnerStandarTotal.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonDinnerStandarTotal.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonDinnerStandarTotal.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonDinnerStandarTotal.setMaxLength(4);

      addShortStayCareOldPersonDinnerStandarTotal();
    }
    return shortStayCareOldPersonDinnerStandarTotal;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayCareOldPersonMorningDinnerStandardMoneyLabel(){
    if(shortStayCareOldPersonMorningDinnerStandardMoneyLabel==null){

      shortStayCareOldPersonMorningDinnerStandardMoneyLabel = new ACLabel();

      shortStayCareOldPersonMorningDinnerStandardMoneyLabel.setText("�@��");

      addShortStayCareOldPersonMorningDinnerStandardMoneyLabel();
    }
    return shortStayCareOldPersonMorningDinnerStandardMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayCareOldPersonMorningDinnerStandardMoney(){
    if(shortStayCareOldPersonMorningDinnerStandardMoney==null){

      shortStayCareOldPersonMorningDinnerStandardMoney = new ACTextField();

      shortStayCareOldPersonMorningDinnerStandardMoney.setBindPath("1220110");

      shortStayCareOldPersonMorningDinnerStandardMoney.setColumns(3);

      shortStayCareOldPersonMorningDinnerStandardMoney.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonMorningDinnerStandardMoney.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonMorningDinnerStandardMoney.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonMorningDinnerStandardMoney.setMaxLength(3);

      addShortStayCareOldPersonMorningDinnerStandardMoney();
    }
    return shortStayCareOldPersonMorningDinnerStandardMoney;

  }

  /**
   * �H���z�E���E���x�����擾���܂��B
   * @return �H���z�E���E���x��
   */
  public ACLabel getShortStayCareOldPersonNoonDinnerStandardMoneyLabel(){
    if(shortStayCareOldPersonNoonDinnerStandardMoneyLabel==null){

      shortStayCareOldPersonNoonDinnerStandardMoneyLabel = new ACLabel();

      shortStayCareOldPersonNoonDinnerStandardMoneyLabel.setText("��");

      addShortStayCareOldPersonNoonDinnerStandardMoneyLabel();
    }
    return shortStayCareOldPersonNoonDinnerStandardMoneyLabel;

  }

  /**
   * �H���z�E���E�e�L�X�g���擾���܂��B
   * @return �H���z�E���E�e�L�X�g
   */
  public ACTextField getShortStayCareOldPersonNoonDinnerStandardMoney(){
    if(shortStayCareOldPersonNoonDinnerStandardMoney==null){

      shortStayCareOldPersonNoonDinnerStandardMoney = new ACTextField();

      shortStayCareOldPersonNoonDinnerStandardMoney.setBindPath("1220111");

      shortStayCareOldPersonNoonDinnerStandardMoney.setColumns(3);

      shortStayCareOldPersonNoonDinnerStandardMoney.setMaxLength(3);

      addShortStayCareOldPersonNoonDinnerStandardMoney();
    }
    return shortStayCareOldPersonNoonDinnerStandardMoney;

  }

  /**
   * �H���z�E��E���x�����擾���܂��B
   * @return �H���z�E��E���x��
   */
  public ACLabel getShortStayCareOldPersonNightDinnerStandardMoneyLabel(){
    if(shortStayCareOldPersonNightDinnerStandardMoneyLabel==null){

      shortStayCareOldPersonNightDinnerStandardMoneyLabel = new ACLabel();

      shortStayCareOldPersonNightDinnerStandardMoneyLabel.setText("��");

      addShortStayCareOldPersonNightDinnerStandardMoneyLabel();
    }
    return shortStayCareOldPersonNightDinnerStandardMoneyLabel;

  }

  /**
   * �H���z�E��E�e�L�X�g���擾���܂��B
   * @return �H���z�E��E�e�L�X�g
   */
  public ACTextField getShortStayCareOldPersonNightDinnerStandardMoney(){
    if(shortStayCareOldPersonNightDinnerStandardMoney==null){

      shortStayCareOldPersonNightDinnerStandardMoney = new ACTextField();

      shortStayCareOldPersonNightDinnerStandardMoney.setBindPath("1220112");

      shortStayCareOldPersonNightDinnerStandardMoney.setColumns(3);

      shortStayCareOldPersonNightDinnerStandardMoney.setMaxLength(3);

      addShortStayCareOldPersonNightDinnerStandardMoney();
    }
    return shortStayCareOldPersonNightDinnerStandardMoney;

  }

  /**
   * �H���z�E���x�����擾���܂��B
   * @return �H���z�E���x��
   */
  public ACLabel getShortStayCareOldPersonDinnerStandarTotalLabel(){
    if(shortStayCareOldPersonDinnerStandarTotalLabel==null){

      shortStayCareOldPersonDinnerStandarTotalLabel = new ACLabel();

      shortStayCareOldPersonDinnerStandarTotalLabel.setText("�i�~�j");

      addShortStayCareOldPersonDinnerStandarTotalLabel();
    }
    return shortStayCareOldPersonDinnerStandarTotalLabel;

  }

  /**
   * ���j�b�g�^����z�R���e�i���擾���܂��B
   * @return ���j�b�g�^����z�R���e�i
   */
  public ACLabelContainer getShortStayCareOldPersonUnitRoomContainar(){
    if(shortStayCareOldPersonUnitRoomContainar==null){

      shortStayCareOldPersonUnitRoomContainar = new ACLabelContainer();

      shortStayCareOldPersonUnitRoomContainar.setText("���j�b�g�^����z");

      shortStayCareOldPersonUnitRoomContainar.setFollowChildEnabled(true);

      addShortStayCareOldPersonUnitRoomContainar();
    }
    return shortStayCareOldPersonUnitRoomContainar;

  }

  /**
   * ���j�b�g�^���e�L�X�g���擾���܂��B
   * @return ���j�b�g�^���e�L�X�g
   */
  public ACTextField getShortStayCareOldPersonUnitRoomText(){
    if(shortStayCareOldPersonUnitRoomText==null){

      shortStayCareOldPersonUnitRoomText = new ACTextField();

      shortStayCareOldPersonUnitRoomText.setBindPath("1220113");

      shortStayCareOldPersonUnitRoomText.setColumns(4);

      shortStayCareOldPersonUnitRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonUnitRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonUnitRoomText.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonUnitRoomText.setMaxLength(4);

      addShortStayCareOldPersonUnitRoomText();
    }
    return shortStayCareOldPersonUnitRoomText;

  }

  /**
   * ���j�b�g�^�����x�����擾���܂��B
   * @return ���j�b�g�^�����x��
   */
  public ACLabel getShortStayCareOldPersonUnitRoomLabel(){
    if(shortStayCareOldPersonUnitRoomLabel==null){

      shortStayCareOldPersonUnitRoomLabel = new ACLabel();

      shortStayCareOldPersonUnitRoomLabel.setText("�i�~�j");

      addShortStayCareOldPersonUnitRoomLabel();
    }
    return shortStayCareOldPersonUnitRoomLabel;

  }

  /**
   * ���j�b�g�^������z�R���e�i���擾���܂��B
   * @return ���j�b�g�^������z�R���e�i
   */
  public ACLabelContainer getShortStayCareOldPersonUnitSemiRoomContainar(){
    if(shortStayCareOldPersonUnitSemiRoomContainar==null){

      shortStayCareOldPersonUnitSemiRoomContainar = new ACLabelContainer();

      shortStayCareOldPersonUnitSemiRoomContainar.setText("���j�b�g�^������z");

      shortStayCareOldPersonUnitSemiRoomContainar.setFollowChildEnabled(true);

      addShortStayCareOldPersonUnitSemiRoomContainar();
    }
    return shortStayCareOldPersonUnitSemiRoomContainar;

  }

  /**
   * ���j�b�g�^�����e�L�X�g���擾���܂��B
   * @return ���j�b�g�^�����e�L�X�g
   */
  public ACTextField getShortStayCareOldPersonUnitSemiRoomText(){
    if(shortStayCareOldPersonUnitSemiRoomText==null){

      shortStayCareOldPersonUnitSemiRoomText = new ACTextField();

      shortStayCareOldPersonUnitSemiRoomText.setBindPath("1220114");

      shortStayCareOldPersonUnitSemiRoomText.setColumns(4);

      shortStayCareOldPersonUnitSemiRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonUnitSemiRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonUnitSemiRoomText.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonUnitSemiRoomText.setMaxLength(4);

      addShortStayCareOldPersonUnitSemiRoomText();
    }
    return shortStayCareOldPersonUnitSemiRoomText;

  }

  /**
   * ���j�b�g�^�������x�����擾���܂��B
   * @return ���j�b�g�^�������x��
   */
  public ACLabel getShortStayCareOldPersonUnitSemiRoomLabel(){
    if(shortStayCareOldPersonUnitSemiRoomLabel==null){

      shortStayCareOldPersonUnitSemiRoomLabel = new ACLabel();

      shortStayCareOldPersonUnitSemiRoomLabel.setText("�i�~�j");

      addShortStayCareOldPersonUnitSemiRoomLabel();
    }
    return shortStayCareOldPersonUnitSemiRoomLabel;

  }

  /**
   * �]���^����z�R���e�i���擾���܂��B
   * @return �]���^����z�R���e�i
   */
  public ACLabelContainer getShortStayCareOldPersonNormalRoomContainar(){
    if(shortStayCareOldPersonNormalRoomContainar==null){

      shortStayCareOldPersonNormalRoomContainar = new ACLabelContainer();

      shortStayCareOldPersonNormalRoomContainar.setText("�@�@�]���^����z");

      shortStayCareOldPersonNormalRoomContainar.setFollowChildEnabled(true);

      addShortStayCareOldPersonNormalRoomContainar();
    }
    return shortStayCareOldPersonNormalRoomContainar;

  }

  /**
   * �]���^���e�L�X�g���擾���܂��B
   * @return �]���^���e�L�X�g
   */
  public ACTextField getShortStayCareOldPersonNormalRoomText(){
    if(shortStayCareOldPersonNormalRoomText==null){

      shortStayCareOldPersonNormalRoomText = new ACTextField();

      shortStayCareOldPersonNormalRoomText.setBindPath("1220115");

      shortStayCareOldPersonNormalRoomText.setColumns(4);

      shortStayCareOldPersonNormalRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonNormalRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonNormalRoomText.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonNormalRoomText.setMaxLength(4);

      addShortStayCareOldPersonNormalRoomText();
    }
    return shortStayCareOldPersonNormalRoomText;

  }

  /**
   * �]���^�����x�����擾���܂��B
   * @return �]���^�����x��
   */
  public ACLabel getShortStayCareOldPersonNormalRoomLabel(){
    if(shortStayCareOldPersonNormalRoomLabel==null){

      shortStayCareOldPersonNormalRoomLabel = new ACLabel();

      shortStayCareOldPersonNormalRoomLabel.setText("�i�~�j");

      addShortStayCareOldPersonNormalRoomLabel();
    }
    return shortStayCareOldPersonNormalRoomLabel;

  }

  /**
   * ��������z�R���e�i���擾���܂��B
   * @return ��������z�R���e�i
   */
  public ACLabelContainer getShortStayCareOldPersonTasyouRoomContainar(){
    if(shortStayCareOldPersonTasyouRoomContainar==null){

      shortStayCareOldPersonTasyouRoomContainar = new ACLabelContainer();

      shortStayCareOldPersonTasyouRoomContainar.setText("�@�@��������z");

      shortStayCareOldPersonTasyouRoomContainar.setFollowChildEnabled(true);

      addShortStayCareOldPersonTasyouRoomContainar();
    }
    return shortStayCareOldPersonTasyouRoomContainar;

  }

  /**
   * �������e�L�X�g���擾���܂��B
   * @return �������e�L�X�g
   */
  public ACTextField getShortStayCareOldPersonTasyouRoomText(){
    if(shortStayCareOldPersonTasyouRoomText==null){

      shortStayCareOldPersonTasyouRoomText = new ACTextField();

      shortStayCareOldPersonTasyouRoomText.setBindPath("1220116");

      shortStayCareOldPersonTasyouRoomText.setColumns(4);

      shortStayCareOldPersonTasyouRoomText.setCharType(VRCharType.ONLY_DIGIT);

      shortStayCareOldPersonTasyouRoomText.setHorizontalAlignment(SwingConstants.RIGHT);

      shortStayCareOldPersonTasyouRoomText.setIMEMode(InputSubset.LATIN);

      shortStayCareOldPersonTasyouRoomText.setMaxLength(4);

      addShortStayCareOldPersonTasyouRoomText();
    }
    return shortStayCareOldPersonTasyouRoomText;

  }

  /**
   * ���������x�����擾���܂��B
   * @return ���������x��
   */
  public ACLabel getShortStayCareOldPersonTasyouRoomLabel(){
    if(shortStayCareOldPersonTasyouRoomLabel==null){

      shortStayCareOldPersonTasyouRoomLabel = new ACLabel();

      shortStayCareOldPersonTasyouRoomLabel.setText("�i�~�j");

      addShortStayCareOldPersonTasyouRoomLabel();
    }
    return shortStayCareOldPersonTasyouRoomLabel;

  }

  /**
   * �R���X�g���N�^�ł��B
   */
  public QO004009Design() {

    try {
      initialize();

      initAffair(null);

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

    this.add(getShortStayCareOldPersonGroup(), VRLayout.CLIENT);

  }

  /**
   * ���ƃO���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonGroup(){

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonDiscountConteiner(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonInstitutionDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonNightWorkDivisionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonRehabilitationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonCognitiveRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonMeetingAndSendingRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonRecuperationNutritionManageRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonRecuperationRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonStaffReduceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonDinnerStandardConteinar(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonUnitRoomContainar(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonUnitSemiRoomContainar(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonNormalRoomContainar(), VRLayout.FLOW_INSETLINE_RETURN);

    shortStayCareOldPersonGroup.add(getShortStayCareOldPersonTasyouRoomContainar(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * �������R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonDiscountConteiner(){

    shortStayCareOldPersonDiscountConteiner.add(getShortStayCareOldPersonDiscountText(), VRLayout.FLOW);

    shortStayCareOldPersonDiscountConteiner.add(getShortStayCareOldPersonDiscountLabel(), VRLayout.FLOW);

  }

  /**
   * �e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonDiscountText(){

  }

  /**
   * ���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonDiscountLabel(){

  }

  /**
   * �{�݋敪���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonInstitutionDivisionRadio(){

  }

  /**
   * �{�݋敪���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonInstitutionDivisionRadioModel(){

    getShortStayCareOldPersonInstitutionDivisionRadioItem1().setButtonIndex(1);
    getShortStayCareOldPersonInstitutionDivisionRadioModel().add(getShortStayCareOldPersonInstitutionDivisionRadioItem1());

    getShortStayCareOldPersonInstitutionDivisionRadioItem2().setButtonIndex(2);
    getShortStayCareOldPersonInstitutionDivisionRadioModel().add(getShortStayCareOldPersonInstitutionDivisionRadioItem2());

  }

  /**
   * ���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonInstitutionDivisionRadioItem1(){

  }

  /**
   * ���j�b�g�^���V�l�ی��{�݂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonInstitutionDivisionRadioItem2(){

  }

  /**
   * ��ԋΖ���������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNightWorkDivisionRadio(){

  }

  /**
   * ��ԋΖ���������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNightWorkDivisionRadioModel(){

    getShortStayCareOldPersonNightWorkDivisionOn().setButtonIndex(1);
    getShortStayCareOldPersonNightWorkDivisionRadioModel().add(getShortStayCareOldPersonNightWorkDivisionOn());

    getShortStayCareOldPersonNightWorkDivisionOff().setButtonIndex(2);
    getShortStayCareOldPersonNightWorkDivisionRadioModel().add(getShortStayCareOldPersonNightWorkDivisionOff());

  }

  /**
   * ��^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNightWorkDivisionOn(){

  }

  /**
   * ���Z�^�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNightWorkDivisionOff(){

  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonRehabilitationRadio(){

  }

  /**
   * ���n�r���e�[�V�����@�\�������W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonRehabilitationRadioModel(){

    getShortStayCareOldPersonRehabilitationOff().setButtonIndex(1);
    getShortStayCareOldPersonRehabilitationRadioModel().add(getShortStayCareOldPersonRehabilitationOff());

    getShortStayCareOldPersonRehabilitationOn().setButtonIndex(2);
    getShortStayCareOldPersonRehabilitationRadioModel().add(getShortStayCareOldPersonRehabilitationOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonRehabilitationOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonRehabilitationOn(){

  }

  /**
   * �F�m�ǐ�哏���W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonCognitiveRadio(){

  }

  /**
   * �F�m�ǐ�哏���W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonCognitiveRadioModel(){

    getShortStayCareOldPersonCognitiveOff().setButtonIndex(1);
    getShortStayCareOldPersonCognitiveRadioModel().add(getShortStayCareOldPersonCognitiveOff());

    getShortStayCareOldPersonCognitiveOn().setButtonIndex(2);
    getShortStayCareOldPersonCognitiveRadioModel().add(getShortStayCareOldPersonCognitiveOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonCognitiveOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonCognitiveOn(){

  }

  /**
   * ���}�̐����W�I�O���[�v�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonMeetingAndSendingRadio(){

  }

  /**
   * ���}�̐����W�I�O���[�v���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonMeetingAndSendingRadioModel(){

    getShortStayCareOldPersonMeetingAndSendingOff().setButtonIndex(1);
    getShortStayCareOldPersonMeetingAndSendingRadioModel().add(getShortStayCareOldPersonMeetingAndSendingOff());

    getShortStayCareOldPersonMeetingAndSendingOn().setButtonIndex(2);
    getShortStayCareOldPersonMeetingAndSendingRadioModel().add(getShortStayCareOldPersonMeetingAndSendingOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonMeetingAndSendingOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonMeetingAndSendingOn(){

  }

  /**
   * �h�{�Ǘ��̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonRecuperationNutritionManageRadio(){

  }

  /**
   * �h�{�Ǘ��̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonRecuperationNutritionManageRadioModel(){

    getShortStayCareOldPersonRecuperationNutritionManageOff().setButtonIndex(1);
    getShortStayCareOldPersonRecuperationNutritionManageRadioModel().add(getShortStayCareOldPersonRecuperationNutritionManageOff());

    getShortStayCareOldPersonNutritionManageOn().setButtonIndex(2);
    getShortStayCareOldPersonRecuperationNutritionManageRadioModel().add(getShortStayCareOldPersonNutritionManageOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonRecuperationNutritionManageOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNutritionManageOn(){

  }

  /**
   * �×{�H�̐��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonRecuperationRadio(){

  }

  /**
   * �×{�H�̐����f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonRecuperationRadioModel(){

    getShortStayCareOldPersonOff().setButtonIndex(1);
    getShortStayCareOldPersonRecuperationRadioModel().add(getShortStayCareOldPersonOff());

    getShortStayCareOldPersonOn().setButtonIndex(2);
    getShortStayCareOldPersonRecuperationRadioModel().add(getShortStayCareOldPersonOn());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonOff(){

  }

  /**
   * ����ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonOn(){

  }

  /**
   * �l�����Z�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonStaffReduceRadio(){

  }

  /**
   * �l�����Z���f���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonStaffReduceRadioModel(){

    getShortStayCareOldPersonStaffReduceRadioItem1().setButtonIndex(1);
    getShortStayCareOldPersonStaffReduceRadioModel().add(getShortStayCareOldPersonStaffReduceRadioItem1());

    getShortStayCareOldPersonStaffReduceRadioItem2().setButtonIndex(2);
    getShortStayCareOldPersonStaffReduceRadioModel().add(getShortStayCareOldPersonStaffReduceRadioItem2());

    getShortStayCareOldPersonStaffReduceRadioItem3().setButtonIndex(3);
    getShortStayCareOldPersonStaffReduceRadioModel().add(getShortStayCareOldPersonStaffReduceRadioItem3());

  }

  /**
   * �Ȃ��ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonStaffReduceRadioItem1(){

  }

  /**
   * ������߂ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonStaffReduceRadioItem2(){

  }

  /**
   * �Ō�E���E�����͈�t�APT�AOT�̕s���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonStaffReduceRadioItem3(){

  }

  /**
   * �H���z�E�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonDinnerStandardConteinar(){

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonDinnerStandarTotal(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonMorningDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonMorningDinnerStandardMoney(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonNoonDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonNoonDinnerStandardMoney(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonNightDinnerStandardMoneyLabel(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonNightDinnerStandardMoney(), VRLayout.FLOW);

    shortStayCareOldPersonDinnerStandardConteinar.add(getShortStayCareOldPersonDinnerStandarTotalLabel(), VRLayout.FLOW);

  }

  /**
   * �H���z�E���v�E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonDinnerStandarTotal(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonMorningDinnerStandardMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonMorningDinnerStandardMoney(){

  }

  /**
   * �H���z�E���E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNoonDinnerStandardMoneyLabel(){

  }

  /**
   * �H���z�E���E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNoonDinnerStandardMoney(){

  }

  /**
   * �H���z�E��E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNightDinnerStandardMoneyLabel(){

  }

  /**
   * �H���z�E��E�e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNightDinnerStandardMoney(){

  }

  /**
   * �H���z�E���x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonDinnerStandarTotalLabel(){

  }

  /**
   * ���j�b�g�^����z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonUnitRoomContainar(){

    shortStayCareOldPersonUnitRoomContainar.add(getShortStayCareOldPersonUnitRoomText(), null);

    shortStayCareOldPersonUnitRoomContainar.add(getShortStayCareOldPersonUnitRoomLabel(), null);

  }

  /**
   * ���j�b�g�^���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonUnitRoomText(){

  }

  /**
   * ���j�b�g�^�����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonUnitRoomLabel(){

  }

  /**
   * ���j�b�g�^������z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonUnitSemiRoomContainar(){

    shortStayCareOldPersonUnitSemiRoomContainar.add(getShortStayCareOldPersonUnitSemiRoomText(), null);

    shortStayCareOldPersonUnitSemiRoomContainar.add(getShortStayCareOldPersonUnitSemiRoomLabel(), null);

  }

  /**
   * ���j�b�g�^�����e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonUnitSemiRoomText(){

  }

  /**
   * ���j�b�g�^�������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonUnitSemiRoomLabel(){

  }

  /**
   * �]���^����z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNormalRoomContainar(){

    shortStayCareOldPersonNormalRoomContainar.add(getShortStayCareOldPersonNormalRoomText(), null);

    shortStayCareOldPersonNormalRoomContainar.add(getShortStayCareOldPersonNormalRoomLabel(), null);

  }

  /**
   * �]���^���e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNormalRoomText(){

  }

  /**
   * �]���^�����x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonNormalRoomLabel(){

  }

  /**
   * ��������z�R���e�i�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonTasyouRoomContainar(){

    shortStayCareOldPersonTasyouRoomContainar.add(getShortStayCareOldPersonTasyouRoomText(), null);

    shortStayCareOldPersonTasyouRoomContainar.add(getShortStayCareOldPersonTasyouRoomLabel(), null);

  }

  /**
   * �������e�L�X�g�ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonTasyouRoomText(){

  }

  /**
   * ���������x���ɓ������ڂ�ǉ����܂��B
   */
  protected void addShortStayCareOldPersonTasyouRoomLabel(){

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
      ACFrame.getInstance().getContentPane().add(new QO004009Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * ���g��Ԃ��܂��B
   */
  protected QO004009Design getThis() {
    return this;
  }
}
